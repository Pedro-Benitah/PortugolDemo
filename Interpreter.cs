using System;
using System.Collections.Generic;
using Antlr4.Runtime.Misc;

// Valor dinamico simples
enum VType { Int, Real, Bool, Text, Void }

sealed class Value {
    public VType Type { get; }
    public int I; public double R; public bool B; public string S;
    private Value(VType t){ Type=t; S=""; }
    public static Value FromInt(int v){ var x=new Value(VType.Int); x.I=v; return x; }
    public static Value FromReal(double v){ var x=new Value(VType.Real); x.R=v; return x; }
    public static Value FromBool(bool v){ var x=new Value(VType.Bool); x.B=v; return x; }
    public static Value FromText(string v){ var x=new Value(VType.Text); x.S=v; return x; }
    public static readonly Value Void = new Value(VType.Void);
    public override string ToString() => Type switch {
        VType.Int => I.ToString(),
        VType.Real => R.ToString(System.Globalization.CultureInfo.InvariantCulture),
        VType.Bool => B ? "verdadeiro" : "falso",
        VType.Text => S,
        _ => ""
    };

    // promoções numéricas
    public static (Value,Value,VType) Num(Value a, Value b){
        if (a.Type==VType.Real || b.Type==VType.Real)
            return (a.ToReal(), b.ToReal(), VType.Real);
        return (a.ToInt(), b.ToInt(), VType.Int);
    }
    public Value ToInt()  => Type switch { VType.Int=>this, VType.Real=>FromInt((int)R), _=>throw new Exception("esperado numero") };
    public Value ToReal() => Type switch { VType.Real=>this, VType.Int=>FromReal(I), _=>throw new Exception("esperado numero") };
    public bool  ToBool() => Type switch { VType.Bool=>B, VType.Int=>I!=0, VType.Real=>Math.Abs(R)>double.Epsilon, VType.Text=>!string.IsNullOrEmpty(S), _=>false };
}

// exceção de retorno para “sair” de função
sealed class ReturnSignal : Exception {
    public Value Ret { get; }
    public ReturnSignal(Value v){ Ret=v; }
}

// função/procedimento registrado
sealed class FunctionDef {
    public string Name="";
    public bool IsProcedure;     // true = sem retorno
    public PortugolParser.TipoContext? ReturnType; // null se procedimento
    public PortugolParser.ListaParamsContext? Params;
    public PortugolParser.BlocoContext? Body;
}

// escopo de variáveis
sealed class Env {
    readonly Env? parent;
    readonly Dictionary<string,Value> vars = new(StringComparer.Ordinal);
    public Env(Env? p=null){ parent=p; }
    public bool TryGet(string id, out Value v){
        if (vars.TryGetValue(id, out v)) return true;
        if (parent!=null) return parent.TryGet(id, out v);
        v = Value.Void; return false;
    }
    public void SetLocal(string id, Value v)=> vars[id]=v;
    public void Assign(string id, Value v){
        if (vars.ContainsKey(id)) { vars[id]=v; return; }
        if (parent!=null) { parent.Assign(id,v); return; }
        throw new Exception($"variavel nao declarada: {id}");
    }
}

// Visitor executor
sealed class Exec : PortugolBaseVisitor<Value> {
    readonly Dictionary<string,FunctionDef> funcs = new(StringComparer.Ordinal);
    Env globals = new Env();

    // Entrada: programa => registra funções/procedimentos e executa a main
    public override Value VisitPrograma([NotNull] PortugolParser.ProgramaContext ctx){
        // 1) registrar funcoes/procedimentos
        foreach (var child in ctx.children){
            switch (child){
                case PortugolParser.DeclaracaoFuncaoContext f:
                    RegisterFunc(f);
                    break;
                case PortugolParser.DeclaracaoProcedimentoContext p:
                    RegisterProc(p);
                    break;
            }
        }
        // 2) executar blocoPrincipal (main)
        return VisitBlocoPrincipal(ctx.blocoPrincipal());
    }

    void RegisterFunc(PortugolParser.DeclaracaoFuncaoContext f){
        var name = f.ID().GetText();
        funcs[name] = new FunctionDef {
            Name = name,
            IsProcedure = false,
            ReturnType = f.tipo(),
            Params = f.listaParams(),
            Body = f.bloco()
        };
    }
    void RegisterProc(PortugolParser.DeclaracaoProcedimentoContext p){
        var name = p.ID().GetText();
        funcs[name] = new FunctionDef {
            Name = name,
            IsProcedure = true,
            ReturnType = null,
            Params = p.listaParams(),
            Body = p.bloco()
        };
    }

    public override Value VisitBlocoPrincipal([NotNull] PortugolParser.BlocoPrincipalContext ctx){
        var env = new Env(globals);
        ExecComandos(ctx.comandos(), env);
        return Value.Void;
    }

    // ===== comandos =====
    void ExecComandos(PortugolParser.ComandosContext? cmds, Env env){
        if (cmds==null) return;
        foreach (var c in cmds.comando())
            ExecComando(c, env);
    }

    void ExecComando(PortugolParser.ComandoContext c, Env env){
        if (c.declaracaoVar()!=null){
            var d = c.declaracaoVar();
            var name = d.ID().GetText();
            var v = d.expr()!=null ? EvalExpr(d.expr(), env) : DefaultForType(d.tipo());
            env.SetLocal(name, v); return;
        }
        if (c.atribuicao()!=null){
            var a = c.atribuicao();
            var name = a.ID().GetText();
            var v = EvalExpr(a.expr(), env);
            env.Assign(name, v); return;
        }
        if (c.chamadaProc()!=null){
            ExecCallAsProc(c.chamadaProc(), env); return;
        }
        if (c.comandoCondicional()!=null){
            var cc = c.comandoCondicional();
            var cond = EvalExpr(cc.expr(), env).ToBool();
            if (cond) ExecBloco(cc.bloco(0), env);
            else if (cc.SENAO()!=null) ExecBloco(cc.bloco(1), env);
            return;
        }
        if (c.comandoEnquanto()!=null){
            var w = c.comandoEnquanto();
            while (EvalExpr(w.expr(), env).ToBool()){
                ExecBloco(w.bloco(), env);
            }
            return;
        }
        if (c.comandoDoEnquanto()!=null){
            var dw = c.comandoDoEnquanto();
            do { ExecBloco(dw.bloco(), env); }
            while (EvalExpr(dw.expr(), env).ToBool());
            return;
        }
        if (c.comandoPara()!=null){
            var fr = c.comandoPara();
            var id = fr.ID().GetText();
            var ini = EvalExpr(fr.expr(0), env).ToInt().I;
            var ate = EvalExpr(fr.expr(1), env).ToInt().I;
            var passo = EvalExpr(fr.expr(2), env).ToInt().I;
            env.SetLocal(id, Value.FromInt(ini));
            for (int i=ini; i<=ate; i+=passo){
                env.Assign(id, Value.FromInt(i));
                ExecBloco(fr.bloco(), env);
            }
            return;
        }
        if (c.comandoRetorne()!=null){
            var r = c.comandoRetorne();
            var val = r.expr()!=null ? EvalExpr(r.expr(), env) : Value.Void;
            throw new ReturnSignal(val);
        }
    }

    void ExecBloco(PortugolParser.BlocoContext b, Env parent){
        var env = new Env(parent);
        ExecComandos(b.comandos(), env);
    }

    // ===== chamadas como procedimento (inclui escreva) =====
    void ExecCallAsProc(PortugolParser.ChamadaProcContext call, Env env){
        if (call is PortugolParser.ChamadaEscrevaContext ez){
            var args = CollectArgs(ez.listaArgs(), env);
            // imprimir na mesma linha, separados por espaço (ou só concatenar)
            Console.WriteLine(string.Join("", args));
            return;
        }
        // generica: ID(...)
        var cg = (PortugolParser.ChamadaGenericaContext)call;
        var name = cg.ID().GetText();
        var args2 = CollectArgs(cg.listaArgs(), env);
        CallFunction(name, args2, env, asProc:true);
    }

    // ===== avaliar expressões =====
    Value EvalExpr(PortugolParser.ExprContext e, Env env)
    {
        // OR
        if (e is PortugolParser.OrExprContext orx)
        {
            var a = EvalExpr(orx.expr(0), env).ToBool();
            if (a) return Value.FromBool(true); // curto-circuito
            var b = EvalExpr(orx.expr(1), env).ToBool();
            return Value.FromBool(a || b);
        }

        // AND
        if (e is PortugolParser.AndExprContext andx)
        {
            var a = EvalExpr(andx.expr(0), env).ToBool();
            if (!a) return Value.FromBool(false); // curto-circuito
            var b = EvalExpr(andx.expr(1), env).ToBool();
            return Value.FromBool(a && b);
        }

        // Base: relação
        var rx = (PortugolParser.RelExprContext)e;
        return EvalRel(rx.relacao(), env);
    }

    Value EvalRel(PortugolParser.RelacaoContext r, Env env){
        var left = EvalSoma(r.soma(0), env);
        for (int i=1; i<r.soma().Length; i++){
            var op = r.GetChild(2*i-1).GetText(); // <, <=, >, >=, ==, !=
            var right = EvalSoma(r.soma(i), env);
            switch(op){
                case "<":  (left,right,_) = Value.Num(left,right); left = Value.FromBool( (left.Type==VType.Real?left.R:left.I)  <  (right.Type==VType.Real?right.R:right.I) ); break;
                case "<=": (left,right,_) = Value.Num(left,right); left = Value.FromBool( (left.Type==VType.Real?left.R:left.I) <= (right.Type==VType.Real?right.R:right.I) ); break;
                case ">":  (left,right,_) = Value.Num(left,right); left = Value.FromBool( (left.Type==VType.Real?left.R:left.I)  >  (right.Type==VType.Real?right.R:right.I) ); break;
                case ">=": (left,right,_) = Value.Num(left,right); left = Value.FromBool( (left.Type==VType.Real?left.R:left.I) >= (right.Type==VType.Real?right.R:right.I) ); break;
                case "==": left = Value.FromBool(EqualsVals(left,right)); break;
                case "!=": left = Value.FromBool(!EqualsVals(left,right)); break;
            }
        }
        return left;
    }

    static bool EqualsVals(Value a, Value b){
        if (a.Type==VType.Text || b.Type==VType.Text) return a.ToString()==b.ToString();
        if (a.Type==VType.Bool || b.Type==VType.Bool) return a.ToBool()==b.ToBool();
        (a,b,_) = Value.Num(a,b);
        return (a.Type==VType.Real ? a.R : a.I) == (b.Type==VType.Real ? b.R : b.I);
    }

    Value EvalSoma(PortugolParser.SomaContext s, Env env){
        var v = EvalTermo(s.termo(0), env);
        for (int i=1;i<s.termo().Length;i++){
            var op = s.GetChild(2*i-1).GetText(); // + |
            var r = EvalTermo(s.termo(i), env);
            if (op=="+"){
                // concat se houver texto
                if (v.Type==VType.Text || r.Type==VType.Text)
                    v = Value.FromText(v.ToString()+r.ToString());
                else {
                    (v,r, var t) = Value.Num(v,r);
                    v = (t==VType.Real) ? Value.FromReal( (v.Type==VType.Real?v.R:v.I) + (r.Type==VType.Real?r.R:r.I) )
                                        : Value.FromInt( v.I + r.I );
                }
            } else { // '-'
                (v,r, var t) = Value.Num(v,r);
                v = (t==VType.Real) ? Value.FromReal( (v.Type==VType.Real?v.R:v.I) - (r.Type==VType.Real?r.R:r.I) )
                                    : Value.FromInt( v.I - r.I );
            }
        }
        return v;
    }

    Value EvalTermo(PortugolParser.TermoContext t, Env env){
        var v = EvalUn(t.un(0), env);
        for (int i=1;i<t.un().Length;i++){
            var op = t.GetChild(2*i-1).GetText(); // * / %
            var r = EvalUn(t.un(i), env);
            switch(op){
                case "*": { (v,r, var tp)=Value.Num(v,r);
                    v = (tp==VType.Real) ? Value.FromReal( (v.Type==VType.Real?v.R:v.I) * (r.Type==VType.Real?r.R:r.I) )
                                         : Value.FromInt( v.I * r.I ); break; }
                case "/": { (v,r, _)=Value.Num(v,r);
                    v = Value.FromReal( (v.Type==VType.Real?v.R:v.I) / (r.Type==VType.Real?r.R:r.I) ); break; }
                case "%": { v = Value.FromInt( v.ToInt().I % r.ToInt().I ); break; }
            }
        }
        return v;
    }

    Value EvalUn(PortugolParser.UnContext u, Env env){
        if (u is PortugolParser.NotExprContext nx) return Value.FromBool(!EvalUn(nx.un(), env).ToBool());
        if (u is PortugolParser.NegExprContext ng){
            var v = EvalUn(ng.un(), env);
            if (v.Type==VType.Real) return Value.FromReal(-v.R);
            return Value.FromInt(-v.ToInt().I);
        }
        if (u is PortugolParser.PosExprContext px) return EvalUn(px.un(), env);
        // prim
        return EvalPrim(((PortugolParser.PrimExprContext)u).prim(), env);
    }

    Value EvalPrim(PortugolParser.PrimContext p, Env env){
        if (p.LPAREN()!=null) return EvalExpr(p.expr(), env);
        if (p.BOOL_LITERAL()!=null) return Value.FromBool(p.BOOL_LITERAL().GetText()=="verdadeiro");
        if (p.NUM_LITERAL()!=null){
            var txt = p.NUM_LITERAL().GetText();
            if (txt.Contains(".")) return Value.FromReal(double.Parse(txt, System.Globalization.CultureInfo.InvariantCulture));
            return Value.FromInt(int.Parse(txt));
        }
        if (p.STRING_LITERAL()!=null){
            var raw = p.STRING_LITERAL().GetText();
            return Value.FromText(raw.Substring(1, raw.Length-2)); // sem aspas
        }
        if (p.chamadaFunc()!=null){
            var cf = p.chamadaFunc();
            var name = cf.ID().GetText();
            var args = CollectArgs(cf.listaArgs(), env);
            return CallFunction(name, args, env, asProc:false);
        }
        // ID (variavel)
        var id = p.ID().GetText();
        if (!env.TryGet(id, out var v)) throw new Exception($"variavel nao declarada: {id}");
        return v;
    }

    List<Value> CollectArgs(PortugolParser.ListaArgsContext? la, Env env){
        var res = new List<Value>();
        if (la==null) return res;
        foreach (var e in la.expr()) res.Add(EvalExpr(e, env));
        return res;
    }

    Value DefaultForType(PortugolParser.TipoContext t){
        var k = t.GetText(); // 'inteiro'|'real'|'logico'|'texto'
        return k switch {
            "inteiro" => Value.FromInt(0),
            "real"    => Value.FromReal(0),
            "logico"  => Value.FromBool(false),
            "texto"   => Value.FromText(""),
            _ => Value.Void
        };
    }

    Value CallFunction(string name, List<Value> args, Env env, bool asProc){
        // builtin: escreva é tratado em chamadaProc
        if (!funcs.TryGetValue(name, out var f)) throw new Exception($"funcao/procedimento nao encontrado: {name}");
        if ((f.Params?.param().Length ?? 0) != args.Count) throw new Exception($"quantidade de argumentos invalida em {name}");

        var local = new Env(env);
        // bind params
        if (f.Params!=null){
            for (int i=0;i<f.Params.param().Length;i++){
                var p = f.Params.param(i);
                var id = p.ID().GetText();
                // opcional: coerção simples por tipo declarado
                var v = CoerceToType(args[i], p.tipo());
                local.SetLocal(id, v);
            }
        }
        try {
            ExecBloco(f.Body!, local);
            // se for funcao e nao houve retorne, valor default do tipo
            if (!f.IsProcedure) return DefaultForType(f.ReturnType!);
            return Value.Void;
        } catch (ReturnSignal rs) {
            if (f.IsProcedure){
                // em procedimento, ignore payload (ou valide vazio)
                return Value.Void;
            } else {
                return rs.Ret;
            }
        }
    }

    Value CoerceToType(Value v, PortugolParser.TipoContext t){
        var k = t.GetText();
        return k switch {
            "inteiro" => Value.FromInt(v.Type==VType.Int ? v.I : v.ToInt().I),
            "real"    => Value.FromReal(v.Type==VType.Real? v.R : v.ToReal().R),
            "logico"  => Value.FromBool(v.ToBool()),
            "texto"   => Value.FromText(v.ToString()),
            _ => v
        };
    }
}

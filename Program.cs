using System;
using System.IO;
using System.Linq;
using System.Text;
using System.Collections.Generic;
using System.Text.RegularExpressions;

/// <summary>
/// ANALISADOR LÉXICO E SINTÁTICO LL(1) - LINGUAGEM PORTUGOL
/// 
/// Gramática LL(1) (após eliminação de recursão à esquerda e fatoração):
/// 
/// programa          → PROGRAMA ID LPAREN RPAREN blocoPrincipal FIMPROGRAMA
/// blocoPrincipal    → INICIO comandos FIM
/// comandos          → (comando SEMI)*
/// comando           → declaracao | atribuicao | condicional | laco | escreva | retorne
/// 
/// declaracao        → tipo ID (EQUAL expr)?
/// tipo              → INTEIRO | REAL | LOGICO | TEXTO
/// 
/// atribuicao        → ID EQUAL expr
/// 
/// condicional       → SE LPAREN expr RPAREN ENTAO blocoPrincipal senaoOpt
/// senaoOpt          → SENAO blocoPrincipal | ε
/// 
/// laco              → enquanto | para
/// enquanto          → ENQUANTO LPAREN expr RPAREN FACA blocoPrincipal FIMENQUANTO
/// para              → PARA ID DE expr ATE expr passoOpt FACA blocoPrincipal FIMPARA
/// passoOpt          → PASSO expr | ε
/// 
/// escreva           → ESCREVA LPAREN listaExpr RPAREN
/// listaExpr         → expr (COMMA expr)*
/// 
/// retorne           → RETORNE expr
/// 
/// expr              → exprOu
/// exprOu            → exprE (OU exprE)*
/// exprE             → exprNao (E exprNao)*
/// exprNao           → NAO exprNao | exprRel
/// exprRel           → exprAd ((EQ | NE | LT | LE | GT | GE) exprAd)*
/// exprAd            → exprMul ((PLUS | MINUS) exprMul)*
/// exprMul           → exprUn ((STAR | SLASH | PERCENT) exprUn)*
/// exprUn            → (MINUS | NAO)? exprPri
/// exprPri           → ID | NUM_LITERAL | STRING_LITERAL | BOOL_LITERAL | LPAREN expr RPAREN
/// </summary>

class Program
{
    static int Main(string[] args)
    {
        try
        {
            // 1) Parse de argumentos
            bool printTokens = args.Contains("--tokens");
            bool printCsv    = args.Contains("--csv");
            bool showHelp    = args.Contains("--help") || args.Contains("-h");
            bool verbose     = args.Contains("--verbose") || args.Contains("-v");

            string? outPath = null;
            int outIdx = Array.IndexOf(args, "--out");
            if (outIdx >= 0 && outIdx + 1 < args.Length && !args[outIdx + 1].StartsWith("-"))
                outPath = args[outIdx + 1];

            // Procurar arquivo de entrada (ignora flags e seus argumentos)
            string? path = null;
            for (int i = 0; i < args.Length; i++)
            {
                if (!args[i].StartsWith("-"))
                {
                    // Verificar se é argumento de uma flag anterior
                    if (i > 0 && args[i-1] == "--out")
                        continue;
                    path = args[i];
                    break;
                }
            }

            if (showHelp)
            {
                Console.WriteLine(@"Uso: dotnet run [opções] [arquivo]

Opções:
  --tokens        : Imprime tokens (tipo, lexema, linha)
  --csv           : Imprime tokens em formato CSV (tipo,lexema,linha,coluna)
  --out <arquivo> : Salva saída CSV no arquivo
  --verbose, -v   : Modo verbose com derivações
  --help, -h      : Mostra esta ajuda

Sem arquivo: lê da STDIN.
Sem flags  : analisa sintaticamente (modo normal).");
                return 0;
            }

            // 2) Carregar entrada
            string inputText;
            if (!string.IsNullOrWhiteSpace(path))
            {
                if (!File.Exists(path))
                {
                    Console.Error.WriteLine($"Erro: arquivo não encontrado: {path}");
                    return 1;
                }
                inputText = File.ReadAllText(path, Encoding.UTF8);
            }
            else
            {
                inputText = Console.In.ReadToEnd();
            }

            if (string.IsNullOrWhiteSpace(inputText))
            {
                Console.Error.WriteLine("Entrada vazia.");
                return 1;
            }

            // 3) Análise Léxica
            var lexer = new LexicalAnalyzer(inputText);
            var tokens = lexer.Analyze();

            if (printTokens || printCsv)
            {
                if (printCsv)
                {
                    PrintTokensCsv(Console.Out, tokens);
                    
                    if (!string.IsNullOrWhiteSpace(outPath))
                    {
                        var dir = Path.GetDirectoryName(outPath);
                        if (!string.IsNullOrEmpty(dir) && !Directory.Exists(dir))
                            Directory.CreateDirectory(dir);

                        using (var w = new StreamWriter(outPath, false, new UTF8Encoding(false)))
                        {
                            PrintTokensCsv(w, tokens);
                        }
                        Console.Error.WriteLine($"✓ CSV salvo em: {outPath}");
                    }
                }
                else
                {
                    PrintTokensTable(Console.Out, tokens);
                }
                return 0;
            }

            // 4) Análise Sintática LL(1)
            var parser = new LL1Parser(tokens, verbose);
            parser.Parse();

            Console.WriteLine("\n✓ Análise concluída com sucesso!");
            return 0;
        }
        catch (Exception ex)
        {
            Console.Error.WriteLine($"✗ Erro: {ex.Message}");
            return 1;
        }
    }

    // Imprime tokens em formato tabular
    static void PrintTokensTable(TextWriter output, List<LexicalAnalyzer.Token> tokens)
    {
        output.WriteLine("=== TOKENS ===");
        output.WriteLine($"{"TIPO",20} | {"LEXEMA",20} | {"LINHA",5}");
        output.WriteLine(new string('-', 50));
        
        foreach (var tok in tokens)
        {
            if (tok.Type != LexicalAnalyzer.TokenType.EOF)
            {
                output.WriteLine($"{tok.Type,20} | {tok.Lexeme,20} | {tok.Line,5}");
            }
        }
    }

    // Imprime tokens em formato CSV
    static void PrintTokensCsv(TextWriter output, List<LexicalAnalyzer.Token> tokens)
    {
        output.WriteLine("Tipo,Lexema,Linha,Coluna");
        
        int coluna = 0;
        int linhaAtual = 1;
        
        foreach (var tok in tokens)
        {
            if (tok.Type == LexicalAnalyzer.TokenType.EOF)
                continue;

            if (tok.Line > linhaAtual)
            {
                linhaAtual = tok.Line;
                coluna = 0;
            }

            string tipo = tok.Type.ToString();
            string lexema = tok.Lexeme.Replace("\"", "\"\"");
            
            output.WriteLine($"{tipo},\"{lexema}\",{tok.Line},{coluna}");
            coluna += tok.Lexeme.Length;
        }
    }
}

class LexicalAnalyzer
{
    // Definindo os tipos de token
    public enum TokenType
    {
        PROGRAMA, FIMPROGRAMA, INICIO, FIM, INTEIRO, REAL, LOGICO, TEXTO, SE, ENTAO, SENAO,
        ENQUANTO, FACA, FIMENQUANTO, PARA, DE, ATE, PASSO, FIMPARA, ESCREVA, PROCEDIMENTO, RETORNE,
        E, OU, NAO, LPAREN, RPAREN, COMMA, SEMI, EQUAL, PLUS, MINUS, STAR, SLASH, PERCENT,
        LT, LE, GT, GE, EQ, NE, BOOL_LITERAL, NUM_LITERAL, STRING_LITERAL, ID, EOF, ERROR
    }

    // Estrutura para um Token
    public class Token
    {
        public TokenType Type { get; }
        public string Lexeme { get; }
        public int Line { get; }

        public Token(TokenType type, string lexeme, int line)
        {
            Type = type;
            Lexeme = lexeme;
            Line = line;
        }
    }

    private static readonly Dictionary<TokenType, string> tokenPatterns = new Dictionary<TokenType, string>
    {
        // Palavras-chave (deve vir antes de ID para ter precedência)
        { TokenType.PROGRAMA, @"^programa$" },
        { TokenType.FIMPROGRAMA, @"^fimPrograma$" },
        { TokenType.INICIO, @"^inicio$" },
        { TokenType.FIM, @"^fim$" },
        { TokenType.INTEIRO, @"^inteiro$" },
        { TokenType.REAL, @"^real$" },
        { TokenType.LOGICO, @"^logico$" },
        { TokenType.TEXTO, @"^texto$" },
        { TokenType.SE, @"^se$" },
        { TokenType.ENTAO, @"^entao$" },
        { TokenType.SENAO, @"^senao$" },
        { TokenType.ENQUANTO, @"^enquanto$" },
        { TokenType.FACA, @"^faca$" },
        { TokenType.FIMENQUANTO, @"^fimEnquanto$" },
        { TokenType.PARA, @"^para$" },
        { TokenType.DE, @"^de$" },
        { TokenType.ATE, @"^ate$" },
        { TokenType.PASSO, @"^passo$" },
        { TokenType.FIMPARA, @"^fimPara$" },
        { TokenType.ESCREVA, @"^escreva$" },
        { TokenType.PROCEDIMENTO, @"^procedimento$" },
        { TokenType.RETORNE, @"^retorne$" },
        { TokenType.E, @"^e$" },
        { TokenType.OU, @"^ou$" },
        { TokenType.NAO, @"^nao$" },
        { TokenType.BOOL_LITERAL, @"^(verdadeiro|falso)$" },

        // Números e strings
        { TokenType.NUM_LITERAL, @"^\d+(\.\d+)?" },
        { TokenType.STRING_LITERAL, @"""([^""\\]|\\.)*""" },

        // Operadores e símbolos
        { TokenType.LPAREN, @"^\(" },
        { TokenType.RPAREN, @"^\)" },
        { TokenType.COMMA, @"^," },
        { TokenType.SEMI, @"^;" },
        { TokenType.EQUAL, @"^=" },
        { TokenType.PLUS, @"^\+" },
        { TokenType.MINUS, @"^-" },
        { TokenType.STAR, @"^\*" },
        { TokenType.SLASH, @"^/" },
        { TokenType.PERCENT, @"^%" },
        { TokenType.LT, @"^<" },
        { TokenType.GT, @"^>" },

        // Identificadores (deve vir por último)
        { TokenType.ID, @"^[a-zA-Z_][a-zA-Z0-9_]*" }
    };

    public List<Token> Tokens { get; private set; }
    private string input;
    private int currentPos;
    private int currentLine;

    public LexicalAnalyzer(string input)
    {
        this.input = input;
        this.Tokens = new List<Token>();
        this.currentPos = 0;
        this.currentLine = 1;
    }

    // Função para realizar a análise léxica
    public List<Token> Analyze()
    {
        while (currentPos < input.Length)
        {
            // Pular espaços em branco e comentários
            if (char.IsWhiteSpace(input[currentPos]))
            {
                if (input[currentPos] == '\n')
                    currentLine++;
                currentPos++;
                continue;
            }

            // Ignorar comentários (//... até fim de linha)
            if (currentPos + 1 < input.Length && input[currentPos] == '/' && input[currentPos + 1] == '/')
            {
                while (currentPos < input.Length && input[currentPos] != '\n')
                    currentPos++;
                continue;
            }

            Token? token = GetNextToken();
            if (token != null)
            {
                Tokens.Add(token);
            }
            else
            {
                throw new Exception($"Token inválido na linha {currentLine}: {input[currentPos]}");
            }
        }

        Tokens.Add(new Token(TokenType.EOF, "", currentLine));
        return Tokens;
    }

    private Token? GetNextToken()
    {
        // Tenta correspondências de 2 caracteres primeiro (<=, >=, ==, !=)
        if (currentPos + 1 < input.Length)
        {
            string twoChar = input.Substring(currentPos, 2);
            if (twoChar == "<=")
            {
                currentPos += 2;
                return new Token(TokenType.LE, twoChar, currentLine);
            }
            if (twoChar == ">=")
            {
                currentPos += 2;
                return new Token(TokenType.GE, twoChar, currentLine);
            }
            if (twoChar == "==")
            {
                currentPos += 2;
                return new Token(TokenType.EQ, twoChar, currentLine);
            }
            if (twoChar == "!=")
            {
                currentPos += 2;
                return new Token(TokenType.NE, twoChar, currentLine);
            }
        }

        // Para palavras-chave e identificadores, extrair a palavra inteira primeiro
        if (char.IsLetter(input[currentPos]) || input[currentPos] == '_')
        {
            int startPos = currentPos;
            while (currentPos < input.Length && (char.IsLetterOrDigit(input[currentPos]) || input[currentPos] == '_'))
                currentPos++;

            string lexeme = input.Substring(startPos, currentPos - startPos);

            // Verificar se é uma palavra-chave ou boolean literal
            foreach (var pattern in tokenPatterns)
            {
                if (Regex.IsMatch(lexeme, pattern.Value, RegexOptions.IgnoreCase))
                {
                    return new Token(pattern.Key, lexeme, currentLine);
                }
            }

            // Se não for nenhuma palavra-chave, é um identificador
            return new Token(TokenType.ID, lexeme, currentLine);
        }

        // Tenta correspondências de números
        if (char.IsDigit(input[currentPos]))
        {
            int startPos = currentPos;
            while (currentPos < input.Length && (char.IsDigit(input[currentPos]) || input[currentPos] == '.'))
                currentPos++;

            string lexeme = input.Substring(startPos, currentPos - startPos);
            return new Token(TokenType.NUM_LITERAL, lexeme, currentLine);
        }

        // Tenta correspondências de strings
        if (input[currentPos] == '"')
        {
            int startPos = currentPos;
            currentPos++; // Skip opening quote

            while (currentPos < input.Length && input[currentPos] != '"')
            {
                if (input[currentPos] == '\\')
                    currentPos++; // Skip escaped character
                if (currentPos < input.Length)
                    currentPos++;
            }

            if (currentPos < input.Length)
                currentPos++; // Skip closing quote

            string lexeme = input.Substring(startPos, currentPos - startPos);
            return new Token(TokenType.STRING_LITERAL, lexeme, currentLine);
        }

        // Tenta correspondências de operadores e símbolos
        foreach (var pattern in tokenPatterns)
        {
            var regex = new Regex(pattern.Value);
            var match = regex.Match(input.Substring(currentPos));

            if (match.Success && match.Index == 0)
            {
                string lexeme = match.Value;
                currentPos += lexeme.Length;
                return new Token(pattern.Key, lexeme, currentLine);
            }
        }

        return null;
    }
}
/// <summary>
/// Analisador Sintático LL(1) com:
/// 1. Cálculo de conjuntos FIRST e FOLLOW
/// 2. Construção da tabela de análise LL(1)
/// 3. Algoritmo de pilha LL(1) com MATCH
/// 
/// Gramática LL(1) simplificada para Portugol:
/// 
/// programa          → PROGRAMA ID LPAREN RPAREN blocoPrincipal FIMPROGRAMA
/// blocoPrincipal    → INICIO comandos FIM
/// comandos          → (comando)*
/// comando           → (simples | estruturado) SEMI?
/// simples           → declaracao | atribuicao | escreva | retorne
/// estruturado       → condicional | enquanto | para
/// </summary>
class LL1Parser
{
    private List<LexicalAnalyzer.Token> tokens;
    private Stack<string> stack;
    private Dictionary<(string, string), List<string>> parseTable;
    private HashSet<string> nonTerminals;
    private HashSet<string> terminals;
    private Dictionary<string, HashSet<string>> first;
    private Dictionary<string, HashSet<string>> follow;
    private bool verbose;

    public LL1Parser(List<LexicalAnalyzer.Token> tokens, bool verbose = false)
    {
        this.tokens = tokens;
        this.verbose = verbose;
        this.stack = new Stack<string>();
        this.parseTable = new Dictionary<(string, string), List<string>>();
        this.nonTerminals = new HashSet<string>();
        this.terminals = new HashSet<string>();
        this.first = new Dictionary<string, HashSet<string>>();
        this.follow = new Dictionary<string, HashSet<string>>();

        InitializeGrammar();
        ComputeFIRST();
        ComputeFOLLOW();
        BuildParseTable();
    }

    private void InitializeGrammar()
    {
        terminals = new HashSet<string> {
            "PROGRAMA", "FIMPROGRAMA", "INICIO", "FIM", "INTEIRO", "REAL", "LOGICO", "TEXTO",
            "SE", "ENTAO", "SENAO", "ENQUANTO", "FACA", "FIMENQUANTO", "PARA", "DE", "ATE",
            "PASSO", "FIMPARA", "ESCREVA", "PROCEDIMENTO", "RETORNE", "E", "OU", "NAO",
            "LPAREN", "RPAREN", "COMMA", "SEMI", "EQUAL", "PLUS", "MINUS", "STAR", "SLASH",
            "PERCENT", "LT", "LE", "GT", "GE", "EQ", "NE", "BOOL_LITERAL", "NUM_LITERAL",
            "STRING_LITERAL", "ID", "EOF", "ε"
        };

        nonTerminals = new HashSet<string> {
            "start", "programa", "topDecls", "topDecl", "funcDecl", "procDecl", "paramList", "paramListRest",
            "blocoPrincipal", "comandos", "comando", "simples", "estruturado",
            "simplesRest",
            "declaracao", "tipo", "atribuicao", "condicional", "senaoOpt", 
            "enquanto", "para", "passoOpt", "escreva", "listaExpr", "listaExprRest",
            "retorne", "expr", "exprOu", "exprOuRest", "exprE", "exprERest", "exprNao", 
            "exprRel", "exprRelRest", "exprAd", "exprAdRest", "exprMul", "exprMulRest", 
            "exprUn", "exprPri"
        };
          // exprPriRest para suportar chamadas de função/expression calls: ID LPAREN listaExpr RPAREN
          nonTerminals.Add("exprPriRest");

        foreach (var nt in nonTerminals)
            first[nt] = new HashSet<string>();
        foreach (var nt in nonTerminals)
            follow[nt] = new HashSet<string>();
    }

    private void ComputeFIRST()
    {
        bool changed = true;
        while (changed)
        {
            changed = false;

            if (AddFIRST("programa", "PROGRAMA")) changed = true;
            // start can begin with a programa or with top-level declarations
            if (AddFIRST("start", "PROGRAMA")) changed = true;
            if (AddFIRST("start", "INTEIRO")) changed = true;
            if (AddFIRST("start", "REAL")) changed = true;
            if (AddFIRST("start", "LOGICO")) changed = true;
            if (AddFIRST("start", "TEXTO")) changed = true;
            if (AddFIRST("start", "PROCEDIMENTO")) changed = true;

            // top-level declarations
            if (AddFIRST("topDecls", "INTEIRO")) changed = true;
            if (AddFIRST("topDecls", "REAL")) changed = true;
            if (AddFIRST("topDecls", "LOGICO")) changed = true;
            if (AddFIRST("topDecls", "TEXTO")) changed = true;
            if (AddFIRST("topDecls", "PROCEDIMENTO")) changed = true;
            if (AddFIRST("topDecls", "ε")) changed = true;

            if (AddFIRSTFromNT("funcDecl", "tipo")) changed = true;
            if (AddFIRST("procDecl", "PROCEDIMENTO")) changed = true;
            if (AddFIRST("paramList", "INTEIRO")) changed = true;
            if (AddFIRST("paramList", "REAL")) changed = true;
            if (AddFIRST("paramList", "LOGICO")) changed = true;
            if (AddFIRST("paramList", "TEXTO")) changed = true;
            if (AddFIRST("paramList", "ε")) changed = true;
            if (AddFIRST("blocoPrincipal", "INICIO")) changed = true;
            if (AddFIRST("comandos", "ε")) changed = true;
            if (AddFIRSTFromNT("comandos", "comando")) changed = true;

            if (AddFIRSTFromNT("comando", "simples")) changed = true;
            if (AddFIRSTFromNT("comando", "estruturado")) changed = true;

            if (AddFIRSTFromNT("simples", "declaracao")) changed = true;
            // simples can start with ID followed by either EQUAL (assignment) or LPAREN (call)
            if (AddFIRST("simples", "ID")) changed = true;
            if (AddFIRST("simplesRest", "EQUAL")) changed = true;
            if (AddFIRST("simplesRest", "LPAREN")) changed = true;
            if (AddFIRSTFromNT("simples", "escreva")) changed = true;
            if (AddFIRSTFromNT("simples", "retorne")) changed = true;

            if (AddFIRSTFromNT("estruturado", "condicional")) changed = true;
            if (AddFIRSTFromNT("estruturado", "enquanto")) changed = true;
            if (AddFIRSTFromNT("estruturado", "para")) changed = true;

            if (AddFIRSTFromNT("declaracao", "tipo")) changed = true;
            if (AddFIRST("tipo", "INTEIRO")) changed = true;
            if (AddFIRST("tipo", "REAL")) changed = true;
            if (AddFIRST("tipo", "LOGICO")) changed = true;
            if (AddFIRST("tipo", "TEXTO")) changed = true;

            if (AddFIRST("atribuicao", "ID")) changed = true;
            if (AddFIRST("condicional", "SE")) changed = true;
            if (AddFIRST("senaoOpt", "SENAO")) changed = true;
            if (AddFIRST("senaoOpt", "ε")) changed = true;

            if (AddFIRST("enquanto", "ENQUANTO")) changed = true;
            if (AddFIRST("para", "PARA")) changed = true;
            if (AddFIRST("passoOpt", "PASSO")) changed = true;
            if (AddFIRST("passoOpt", "ε")) changed = true;

            if (AddFIRST("escreva", "ESCREVA")) changed = true;
            if (AddFIRSTFromNT("listaExpr", "expr")) changed = true;
            if (AddFIRST("listaExprRest", "COMMA")) changed = true;
            if (AddFIRST("listaExprRest", "ε")) changed = true;

            if (AddFIRST("retorne", "RETORNE")) changed = true;
            if (AddFIRSTFromNT("expr", "exprOu")) changed = true;
            if (AddFIRSTFromNT("exprOu", "exprE")) changed = true;
            if (AddFIRSTFromNT("exprE", "exprNao")) changed = true;
            if (AddFIRST("exprNao", "NAO")) changed = true;
            if (AddFIRSTFromNT("exprNao", "exprRel")) changed = true;
            if (AddFIRSTFromNT("exprRel", "exprAd")) changed = true;
            if (AddFIRSTFromNT("exprAd", "exprMul")) changed = true;
            if (AddFIRSTFromNT("exprMul", "exprUn")) changed = true;
            if (AddFIRST("exprUn", "MINUS")) changed = true;
            if (AddFIRST("exprUn", "NAO")) changed = true;
            if (AddFIRSTFromNT("exprUn", "exprPri")) changed = true;

            if (AddFIRST("exprPri", "ID")) changed = true;
            if (AddFIRST("exprPriRest", "LPAREN")) changed = true;
            if (AddFIRST("exprPri", "NUM_LITERAL")) changed = true;
            if (AddFIRST("exprPri", "STRING_LITERAL")) changed = true;
            if (AddFIRST("exprPri", "BOOL_LITERAL")) changed = true;
            if (AddFIRST("exprPri", "LPAREN")) changed = true;
        }
    }

    private bool AddFIRST(string nt, string symbol)
    {
        if (!first.ContainsKey(nt))
            first[nt] = new HashSet<string>();
        return first[nt].Add(symbol);
    }

    private bool AddFIRSTFromNT(string nt, string sourceNT)
    {
        bool changed = false;
        if (first.ContainsKey(sourceNT))
        {
            foreach (var sym in first[sourceNT])
            {
                if (sym != "ε" && AddFIRST(nt, sym))
                    changed = true;
            }
        }
        return changed;
    }

    private void ComputeFOLLOW()
    {
        // start é o símbolo inicial agora
        follow["start"].Add("EOF");
        follow["programa"].Add("EOF");
    }

    private void BuildParseTable()
    {
        // start: allows optional top-level declarations before programa
        AddProduction("start", "PROGRAMA", new List<string> { "programa" });
        foreach (var term in new[] { "INTEIRO", "REAL", "LOGICO", "TEXTO", "PROCEDIMENTO" })
            AddProduction("start", term, new List<string> { "topDecls", "programa" });

        // topDecls -> topDecl topDecls | ε
        foreach (var term in new[] { "INTEIRO", "REAL", "LOGICO", "TEXTO", "PROCEDIMENTO" })
            AddProduction("topDecls", term, new List<string> { "topDecl", "topDecls" });
        AddProduction("topDecls", "PROGRAMA", new List<string> { "ε" });

        // topDecl -> funcDecl | procDecl
        foreach (var term in new[] { "INTEIRO", "REAL", "LOGICO", "TEXTO" })
            AddProduction("topDecl", term, new List<string> { "funcDecl" });
        AddProduction("topDecl", "PROCEDIMENTO", new List<string> { "procDecl" });

        // funcDecl -> tipo ID LPAREN paramList RPAREN blocoPrincipal
        AddProduction("funcDecl", "INTEIRO", new List<string> { "tipo", "ID", "LPAREN", "paramList", "RPAREN", "blocoPrincipal" });
        AddProduction("funcDecl", "REAL", new List<string> { "tipo", "ID", "LPAREN", "paramList", "RPAREN", "blocoPrincipal" });
        AddProduction("funcDecl", "LOGICO", new List<string> { "tipo", "ID", "LPAREN", "paramList", "RPAREN", "blocoPrincipal" });
        AddProduction("funcDecl", "TEXTO", new List<string> { "tipo", "ID", "LPAREN", "paramList", "RPAREN", "blocoPrincipal" });

        // procDecl -> PROCEDIMENTO ID LPAREN paramList RPAREN blocoPrincipal
        AddProduction("procDecl", "PROCEDIMENTO", new List<string> { "PROCEDIMENTO", "ID", "LPAREN", "paramList", "RPAREN", "blocoPrincipal" });

        // paramList -> tipo ID paramListRest | ε
        foreach (var t in new[] { "INTEIRO", "REAL", "LOGICO", "TEXTO" })
            AddProduction("paramList", t, new List<string> { "tipo", "ID", "paramListRest" });
        AddProduction("paramList", "RPAREN", new List<string> { "ε" });

        // paramListRest -> COMMA tipo ID paramListRest | ε
        AddProduction("paramListRest", "COMMA", new List<string> { "COMMA", "tipo", "ID", "paramListRest" });
        AddProduction("paramListRest", "RPAREN", new List<string> { "ε" });

        // programa
        AddProduction("programa", "PROGRAMA", new List<string> { "PROGRAMA", "ID", "LPAREN", "RPAREN", "blocoPrincipal", "FIMPROGRAMA" });

        // blocoPrincipal
        AddProduction("blocoPrincipal", "INICIO", new List<string> { "INICIO", "comandos", "FIM" });

        // comandos → comando comandos | ε
        foreach (var term in new[] { "INTEIRO", "REAL", "LOGICO", "TEXTO", "ID", "SE", "ENQUANTO", "PARA", "ESCREVA", "RETORNE" })
            AddProduction("comandos", term, new List<string> { "comando", "comandos" });
        foreach (var term in new[] { "FIM", "FIMENQUANTO", "FIMPARA", "SENAO", "EOF" })
            AddProduction("comandos", term, new List<string> { "ε" });

        // comando → simples SEMI | estruturado
        foreach (var term in new[] { "INTEIRO", "REAL", "LOGICO", "TEXTO", "ID", "ESCREVA", "RETORNE" })
            AddProduction("comando", term, new List<string> { "simples", "SEMI" });
        foreach (var term in new[] { "SE", "ENQUANTO", "PARA" })
            AddProduction("comando", term, new List<string> { "estruturado" });

        // simples
        foreach (var term in new[] { "INTEIRO", "REAL", "LOGICO", "TEXTO" })
            AddProduction("simples", term, new List<string> { "declaracao" });
        // ID pode iniciar uma atribuicao (ID = expr) ou uma chamada (ID LPAREN listaExpr RPAREN)
        AddProduction("simples", "ID", new List<string> { "ID", "simplesRest" });

        // simplesRest -> EQUAL expr | LPAREN listaExpr RPAREN
        AddProduction("simplesRest", "EQUAL", new List<string> { "EQUAL", "expr" });
        AddProduction("simplesRest", "LPAREN", new List<string> { "LPAREN", "listaExpr", "RPAREN" });
        AddProduction("simples", "ESCREVA", new List<string> { "escreva" });
        AddProduction("simples", "RETORNE", new List<string> { "retorne" });

        // estruturado
        AddProduction("estruturado", "SE", new List<string> { "condicional" });
        AddProduction("estruturado", "ENQUANTO", new List<string> { "enquanto" });
        AddProduction("estruturado", "PARA", new List<string> { "para" });

        // declaracao
        foreach (var term in new[] { "INTEIRO", "REAL", "LOGICO", "TEXTO" })
            AddProduction("declaracao", term, new List<string> { "tipo", "ID", "EQUAL", "expr" });

        // tipo
        AddProduction("tipo", "INTEIRO", new List<string> { "INTEIRO" });
        AddProduction("tipo", "REAL", new List<string> { "REAL" });
        AddProduction("tipo", "LOGICO", new List<string> { "LOGICO" });
        AddProduction("tipo", "TEXTO", new List<string> { "TEXTO" });

        // atribuicao
        AddProduction("atribuicao", "ID", new List<string> { "ID", "EQUAL", "expr" });

        // condicional
        AddProduction("condicional", "SE", new List<string> { "SE", "LPAREN", "expr", "RPAREN", "ENTAO", "blocoPrincipal", "senaoOpt" });

        // senaoOpt
        AddProduction("senaoOpt", "SENAO", new List<string> { "SENAO", "blocoPrincipal" });
        foreach (var term in new[] { "FIM", "FIMENQUANTO", "FIMPARA", "INTEIRO", "REAL", "LOGICO", "TEXTO", "ID", "SE", "ENQUANTO", "PARA", "ESCREVA", "RETORNE", "EOF" })
            AddProduction("senaoOpt", term, new List<string> { "ε" });

        // enquanto
        AddProduction("enquanto", "ENQUANTO", new List<string> { "ENQUANTO", "LPAREN", "expr", "RPAREN", "FACA", "blocoPrincipal", "FIMENQUANTO" });

        // para
        AddProduction("para", "PARA", new List<string> { "PARA", "ID", "DE", "expr", "ATE", "expr", "passoOpt", "FACA", "blocoPrincipal", "FIMPARA" });

        // passoOpt
        AddProduction("passoOpt", "PASSO", new List<string> { "PASSO", "expr" });
        AddProduction("passoOpt", "FACA", new List<string> { "ε" });

        // escreva
        AddProduction("escreva", "ESCREVA", new List<string> { "ESCREVA", "LPAREN", "listaExpr", "RPAREN" });

        // listaExpr
        foreach (var term in new[] { "ID", "NUM_LITERAL", "STRING_LITERAL", "BOOL_LITERAL", "LPAREN", "MINUS", "NAO" })
            AddProduction("listaExpr", term, new List<string> { "expr", "listaExprRest" });

        // listaExprRest
        AddProduction("listaExprRest", "COMMA", new List<string> { "COMMA", "expr", "listaExprRest" });
        AddProduction("listaExprRest", "RPAREN", new List<string> { "ε" });

        // retorne
        AddProduction("retorne", "RETORNE", new List<string> { "RETORNE", "expr" });

        // expr → exprOu
        foreach (var term in new[] { "ID", "NUM_LITERAL", "STRING_LITERAL", "BOOL_LITERAL", "LPAREN", "MINUS", "NAO" })
            AddProduction("expr", term, new List<string> { "exprOu" });

        // exprOu → exprE exprOuRest
        foreach (var term in new[] { "ID", "NUM_LITERAL", "STRING_LITERAL", "BOOL_LITERAL", "LPAREN", "MINUS", "NAO" })
            AddProduction("exprOu", term, new List<string> { "exprE", "exprOuRest" });

        // exprOuRest → OU exprE exprOuRest | ε
        AddProduction("exprOuRest", "OU", new List<string> { "OU", "exprE", "exprOuRest" });
        foreach (var t in new[] { "SEMI", "RPAREN", "COMMA", "ENTAO", "FACA", "ATE", "PASSO", "DE", "EQ", "NE", "LT", "LE", "GT", "GE", "PLUS", "MINUS", "STAR", "SLASH", "PERCENT", "E", "FIM", "FIMENQUANTO", "FIMPARA", "SENAO", "EOF" })
            AddProduction("exprOuRest", t, new List<string> { "ε" });

        // exprE → exprNao exprERest
        foreach (var term in new[] { "ID", "NUM_LITERAL", "STRING_LITERAL", "BOOL_LITERAL", "LPAREN", "MINUS", "NAO" })
            AddProduction("exprE", term, new List<string> { "exprNao", "exprERest" });

        // exprERest → E exprNao exprERest | ε
        AddProduction("exprERest", "E", new List<string> { "E", "exprNao", "exprERest" });
        foreach (var t in new[] { "SEMI", "RPAREN", "COMMA", "ENTAO", "FACA", "ATE", "PASSO", "DE", "EQ", "NE", "LT", "LE", "GT", "GE", "PLUS", "MINUS", "STAR", "SLASH", "PERCENT", "OU", "FIM", "FIMENQUANTO", "FIMPARA", "SENAO", "EOF" })
            AddProduction("exprERest", t, new List<string> { "ε" });

        // exprNao → NAO exprNao | exprRel
        AddProduction("exprNao", "NAO", new List<string> { "NAO", "exprNao" });
        foreach (var term in new[] { "ID", "NUM_LITERAL", "STRING_LITERAL", "BOOL_LITERAL", "LPAREN", "MINUS" })
            AddProduction("exprNao", term, new List<string> { "exprRel" });

        // exprRel → exprAd exprRelRest
        foreach (var term in new[] { "ID", "NUM_LITERAL", "STRING_LITERAL", "BOOL_LITERAL", "LPAREN", "MINUS" })
            AddProduction("exprRel", term, new List<string> { "exprAd", "exprRelRest" });

        // exprRelRest → (EQ|NE|LT|LE|GT|GE) exprAd exprRelRest | ε
        foreach (var op in new[] { "EQ", "NE", "LT", "LE", "GT", "GE" })
            AddProduction("exprRelRest", op, new List<string> { op, "exprAd", "exprRelRest" });
        foreach (var t in new[] { "SEMI", "RPAREN", "COMMA", "ENTAO", "FACA", "ATE", "PASSO", "DE", "PLUS", "MINUS", "STAR", "SLASH", "PERCENT", "E", "OU", "FIM", "FIMENQUANTO", "FIMPARA", "SENAO", "EOF" })
            AddProduction("exprRelRest", t, new List<string> { "ε" });

        // exprAd → exprMul exprAdRest
        foreach (var term in new[] { "ID", "NUM_LITERAL", "STRING_LITERAL", "BOOL_LITERAL", "LPAREN", "MINUS" })
            AddProduction("exprAd", term, new List<string> { "exprMul", "exprAdRest" });

        // exprAdRest → (PLUS|MINUS) exprMul exprAdRest | ε
        AddProduction("exprAdRest", "PLUS", new List<string> { "PLUS", "exprMul", "exprAdRest" });
        AddProduction("exprAdRest", "MINUS", new List<string> { "MINUS", "exprMul", "exprAdRest" });
        foreach (var t in new[] { "SEMI", "RPAREN", "COMMA", "ENTAO", "FACA", "ATE", "PASSO", "DE", "EQ", "NE", "LT", "LE", "GT", "GE", "STAR", "SLASH", "PERCENT", "E", "OU", "FIM", "FIMENQUANTO", "FIMPARA", "SENAO", "EOF" })
            AddProduction("exprAdRest", t, new List<string> { "ε" });

        // exprMul → exprUn exprMulRest
        foreach (var term in new[] { "ID", "NUM_LITERAL", "STRING_LITERAL", "BOOL_LITERAL", "LPAREN", "MINUS" })
            AddProduction("exprMul", term, new List<string> { "exprUn", "exprMulRest" });

        // exprMulRest → (STAR|SLASH|PERCENT) exprUn exprMulRest | ε
        AddProduction("exprMulRest", "STAR", new List<string> { "STAR", "exprUn", "exprMulRest" });
        AddProduction("exprMulRest", "SLASH", new List<string> { "SLASH", "exprUn", "exprMulRest" });
        AddProduction("exprMulRest", "PERCENT", new List<string> { "PERCENT", "exprUn", "exprMulRest" });
        foreach (var t in new[] { "SEMI", "RPAREN", "COMMA", "ENTAO", "FACA", "ATE", "PASSO", "DE", "EQ", "NE", "LT", "LE", "GT", "GE", "PLUS", "MINUS", "E", "OU", "FIM", "FIMENQUANTO", "FIMPARA", "SENAO", "EOF" })
            AddProduction("exprMulRest", t, new List<string> { "ε" });

        // exprUn → (MINUS|NAO)? exprPri
        AddProduction("exprUn", "MINUS", new List<string> { "MINUS", "exprPri" });
        AddProduction("exprUn", "NAO", new List<string> { "NAO", "exprPri" });
        foreach (var term in new[] { "ID", "NUM_LITERAL", "STRING_LITERAL", "BOOL_LITERAL", "LPAREN" })
            AddProduction("exprUn", term, new List<string> { "exprPri" });

        // exprPri
        // ID pode ser uso de variável ou chamada: ID exprPriRest
        AddProduction("exprPri", "ID", new List<string> { "ID", "exprPriRest" });
        // exprPriRest -> LPAREN listaExpr RPAREN | ε
        AddProduction("exprPriRest", "LPAREN", new List<string> { "LPAREN", "listaExpr", "RPAREN" });
        foreach (var t in new[] { "SEMI", "RPAREN", "COMMA", "ENTAO", "FACA", "ATE", "PASSO", "DE", "EQ", "NE", "LT", "LE", "GT", "GE", "PLUS", "MINUS", "STAR", "SLASH", "PERCENT", "E", "OU", "FIM", "FIMENQUANTO", "FIMPARA", "SENAO", "EOF" })
            AddProduction("exprPriRest", t, new List<string> { "ε" });
        AddProduction("exprPri", "NUM_LITERAL", new List<string> { "NUM_LITERAL" });
        AddProduction("exprPri", "STRING_LITERAL", new List<string> { "STRING_LITERAL" });
        AddProduction("exprPri", "BOOL_LITERAL", new List<string> { "BOOL_LITERAL" });
        AddProduction("exprPri", "LPAREN", new List<string> { "LPAREN", "expr", "RPAREN" });
    }

    private void AddProduction(string nonTerminal, string lookahead, List<string> production)
    {
        var key = (nonTerminal, lookahead);
        parseTable[key] = production;
    }

    public void Parse()
    {
        stack.Push("EOF");
        stack.Push("start");

        int tokenIdx = 0;

        if (verbose)
        {
            Console.WriteLine("\n=== ANÁLISE SINTÁTICA LL(1) - MODO VERBOSE ===\n");
        }

        while (stack.Count > 0)
        {
            string top = stack.Peek();
            string currentToken = tokenIdx < tokens.Count ? tokens[tokenIdx].Type.ToString() : "EOF";

            if (terminals.Contains(top))
            {
                if (top == currentToken || top == "ε")
                {
                    if (top != "ε")
                    {
                        tokenIdx++;
                    }
                    stack.Pop();
                }
                else
                {
                    throw new Exception($"Erro sintático linha {tokens[tokenIdx].Line}: esperado '{top}' mas encontrou '{currentToken}'");
                }
            }
            else if (top == "EOF")
            {
                if (currentToken == "EOF")
                {
                    stack.Pop();
                }
                else
                {
                    throw new Exception($"Erro: tokens restantes após EOF");
                }
            }
            else
            {
                if (parseTable.TryGetValue((top, currentToken), out var production))
                {
                    if (verbose)
                    {
                        Console.WriteLine($"{top} → {string.Join(" ", production)}");
                    }
                    
                    stack.Pop();
                    for (int i = production.Count - 1; i >= 0; i--)
                    {
                        if (production[i] != "ε")
                            stack.Push(production[i]);
                    }
                }
                else
                {
                    throw new Exception($"Erro sintático linha {tokens[tokenIdx].Line}: sem produção para '{top}' com token '{currentToken}'");
                }
            }
        }
    }
}

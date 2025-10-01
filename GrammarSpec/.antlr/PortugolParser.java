// Generated from c:/Users/pedro/Downloads/PortugolDemo/GrammarSpec/Portugol.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PortugolParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PROGRAMA=1, FIMPROGRAMA=2, INICIO=3, FIM=4, INTEIRO=5, REAL=6, LOGICO=7, 
		TEXTO=8, SE=9, ENTAO=10, SENAO=11, ENQUANTO=12, FACA=13, FIMENQUANTO=14, 
		PARA=15, DE=16, ATE=17, PASSO=18, FIMPARA=19, ESCREVA=20, PROCEDIMENTO=21, 
		RETORNE=22, E=23, OU=24, NAO=25, LPAREN=26, RPAREN=27, COMMA=28, SEMI=29, 
		EQUAL=30, PLUS=31, MINUS=32, STAR=33, SLASH=34, PERCENT=35, LT=36, LE=37, 
		GT=38, GE=39, EQ=40, NE=41, BOOL_LITERAL=42, NUM_LITERAL=43, STRING_LITERAL=44, 
		ID=45, WS=46, COMMENT=47, BLOCK_COMMENT=48;
	public static final int
		RULE_programa = 0, RULE_blocoPrincipal = 1, RULE_bloco = 2, RULE_comandos = 3, 
		RULE_declaracaoFuncao = 4, RULE_declaracaoProcedimento = 5, RULE_listaParams = 6, 
		RULE_param = 7, RULE_tipo = 8, RULE_comando = 9, RULE_declaracaoVar = 10, 
		RULE_atribuicao = 11, RULE_chamadaProc = 12, RULE_comandoRetorne = 13, 
		RULE_comandoCondicional = 14, RULE_comandoEnquanto = 15, RULE_comandoDoEnquanto = 16, 
		RULE_comandoPara = 17, RULE_listaArgs = 18, RULE_expr = 19, RULE_relacao = 20, 
		RULE_soma = 21, RULE_termo = 22, RULE_un = 23, RULE_prim = 24, RULE_chamadaFunc = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "blocoPrincipal", "bloco", "comandos", "declaracaoFuncao", 
			"declaracaoProcedimento", "listaParams", "param", "tipo", "comando", 
			"declaracaoVar", "atribuicao", "chamadaProc", "comandoRetorne", "comandoCondicional", 
			"comandoEnquanto", "comandoDoEnquanto", "comandoPara", "listaArgs", "expr", 
			"relacao", "soma", "termo", "un", "prim", "chamadaFunc"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimPrograma'", "'inicio'", "'fim'", "'inteiro'", 
			"'real'", "'logico'", "'texto'", "'se'", "'entao'", "'senao'", "'enquanto'", 
			"'faca'", "'fimEnquanto'", "'para'", "'de'", "'ate'", "'passo'", "'fimPara'", 
			"'escreva'", "'procedimento'", "'retorne'", "'e'", "'ou'", "'nao'", "'('", 
			"')'", "','", "';'", "'='", "'+'", "'-'", "'*'", "'/'", "'%'", "'<'", 
			"'<='", "'>'", "'>='", "'=='", "'!='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PROGRAMA", "FIMPROGRAMA", "INICIO", "FIM", "INTEIRO", "REAL", 
			"LOGICO", "TEXTO", "SE", "ENTAO", "SENAO", "ENQUANTO", "FACA", "FIMENQUANTO", 
			"PARA", "DE", "ATE", "PASSO", "FIMPARA", "ESCREVA", "PROCEDIMENTO", "RETORNE", 
			"E", "OU", "NAO", "LPAREN", "RPAREN", "COMMA", "SEMI", "EQUAL", "PLUS", 
			"MINUS", "STAR", "SLASH", "PERCENT", "LT", "LE", "GT", "GE", "EQ", "NE", 
			"BOOL_LITERAL", "NUM_LITERAL", "STRING_LITERAL", "ID", "WS", "COMMENT", 
			"BLOCK_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Portugol.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PortugolParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode PROGRAMA() { return getToken(PortugolParser.PROGRAMA, 0); }
		public TerminalNode ID() { return getToken(PortugolParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(PortugolParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PortugolParser.RPAREN, 0); }
		public BlocoPrincipalContext blocoPrincipal() {
			return getRuleContext(BlocoPrincipalContext.class,0);
		}
		public TerminalNode FIMPROGRAMA() { return getToken(PortugolParser.FIMPROGRAMA, 0); }
		public TerminalNode EOF() { return getToken(PortugolParser.EOF, 0); }
		public List<DeclaracaoFuncaoContext> declaracaoFuncao() {
			return getRuleContexts(DeclaracaoFuncaoContext.class);
		}
		public DeclaracaoFuncaoContext declaracaoFuncao(int i) {
			return getRuleContext(DeclaracaoFuncaoContext.class,i);
		}
		public List<DeclaracaoProcedimentoContext> declaracaoProcedimento() {
			return getRuleContexts(DeclaracaoProcedimentoContext.class);
		}
		public DeclaracaoProcedimentoContext declaracaoProcedimento(int i) {
			return getRuleContext(DeclaracaoProcedimentoContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2097632L) != 0)) {
				{
				setState(54);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INTEIRO:
				case REAL:
				case LOGICO:
				case TEXTO:
					{
					setState(52);
					declaracaoFuncao();
					}
					break;
				case PROCEDIMENTO:
					{
					setState(53);
					declaracaoProcedimento();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
			match(PROGRAMA);
			setState(60);
			match(ID);
			setState(61);
			match(LPAREN);
			setState(62);
			match(RPAREN);
			setState(63);
			blocoPrincipal();
			setState(64);
			match(FIMPROGRAMA);
			setState(65);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlocoPrincipalContext extends ParserRuleContext {
		public TerminalNode INICIO() { return getToken(PortugolParser.INICIO, 0); }
		public ComandosContext comandos() {
			return getRuleContext(ComandosContext.class,0);
		}
		public TerminalNode FIM() { return getToken(PortugolParser.FIM, 0); }
		public BlocoPrincipalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blocoPrincipal; }
	}

	public final BlocoPrincipalContext blocoPrincipal() throws RecognitionException {
		BlocoPrincipalContext _localctx = new BlocoPrincipalContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_blocoPrincipal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(INICIO);
			setState(68);
			comandos();
			setState(69);
			match(FIM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlocoContext extends ParserRuleContext {
		public TerminalNode INICIO() { return getToken(PortugolParser.INICIO, 0); }
		public ComandosContext comandos() {
			return getRuleContext(ComandosContext.class,0);
		}
		public TerminalNode FIM() { return getToken(PortugolParser.FIM, 0); }
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_bloco);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(INICIO);
			setState(72);
			comandos();
			setState(73);
			match(FIM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComandosContext extends ParserRuleContext {
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public ComandosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandos; }
	}

	public final ComandosContext comandos() throws RecognitionException {
		ComandosContext _localctx = new ComandosContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_comandos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 35184377377760L) != 0)) {
				{
				{
				setState(75);
				comando();
				}
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracaoFuncaoContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(PortugolParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(PortugolParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PortugolParser.RPAREN, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ListaParamsContext listaParams() {
			return getRuleContext(ListaParamsContext.class,0);
		}
		public DeclaracaoFuncaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracaoFuncao; }
	}

	public final DeclaracaoFuncaoContext declaracaoFuncao() throws RecognitionException {
		DeclaracaoFuncaoContext _localctx = new DeclaracaoFuncaoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declaracaoFuncao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			tipo();
			setState(82);
			match(ID);
			setState(83);
			match(LPAREN);
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 480L) != 0)) {
				{
				setState(84);
				listaParams();
				}
			}

			setState(87);
			match(RPAREN);
			setState(88);
			bloco();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracaoProcedimentoContext extends ParserRuleContext {
		public TerminalNode PROCEDIMENTO() { return getToken(PortugolParser.PROCEDIMENTO, 0); }
		public TerminalNode ID() { return getToken(PortugolParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(PortugolParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PortugolParser.RPAREN, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ListaParamsContext listaParams() {
			return getRuleContext(ListaParamsContext.class,0);
		}
		public DeclaracaoProcedimentoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracaoProcedimento; }
	}

	public final DeclaracaoProcedimentoContext declaracaoProcedimento() throws RecognitionException {
		DeclaracaoProcedimentoContext _localctx = new DeclaracaoProcedimentoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declaracaoProcedimento);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(PROCEDIMENTO);
			setState(91);
			match(ID);
			setState(92);
			match(LPAREN);
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 480L) != 0)) {
				{
				setState(93);
				listaParams();
				}
			}

			setState(96);
			match(RPAREN);
			setState(97);
			bloco();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListaParamsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PortugolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PortugolParser.COMMA, i);
		}
		public ListaParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaParams; }
	}

	public final ListaParamsContext listaParams() throws RecognitionException {
		ListaParamsContext _localctx = new ListaParamsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_listaParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			param();
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(100);
				match(COMMA);
				setState(101);
				param();
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(PortugolParser.ID, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			tipo();
			setState(108);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TipoContext extends ParserRuleContext {
		public TerminalNode INTEIRO() { return getToken(PortugolParser.INTEIRO, 0); }
		public TerminalNode REAL() { return getToken(PortugolParser.REAL, 0); }
		public TerminalNode LOGICO() { return getToken(PortugolParser.LOGICO, 0); }
		public TerminalNode TEXTO() { return getToken(PortugolParser.TEXTO, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 480L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComandoContext extends ParserRuleContext {
		public DeclaracaoVarContext declaracaoVar() {
			return getRuleContext(DeclaracaoVarContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(PortugolParser.SEMI, 0); }
		public AtribuicaoContext atribuicao() {
			return getRuleContext(AtribuicaoContext.class,0);
		}
		public ChamadaProcContext chamadaProc() {
			return getRuleContext(ChamadaProcContext.class,0);
		}
		public ComandoCondicionalContext comandoCondicional() {
			return getRuleContext(ComandoCondicionalContext.class,0);
		}
		public ComandoEnquantoContext comandoEnquanto() {
			return getRuleContext(ComandoEnquantoContext.class,0);
		}
		public ComandoParaContext comandoPara() {
			return getRuleContext(ComandoParaContext.class,0);
		}
		public ComandoDoEnquantoContext comandoDoEnquanto() {
			return getRuleContext(ComandoDoEnquantoContext.class,0);
		}
		public ComandoRetorneContext comandoRetorne() {
			return getRuleContext(ComandoRetorneContext.class,0);
		}
		public ComandoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comando; }
	}

	public final ComandoContext comando() throws RecognitionException {
		ComandoContext _localctx = new ComandoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_comando);
		try {
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				declaracaoVar();
				setState(113);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				atribuicao();
				setState(116);
				match(SEMI);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(118);
				chamadaProc();
				setState(119);
				match(SEMI);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(121);
				comandoCondicional();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(122);
				comandoEnquanto();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(123);
				comandoPara();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(124);
				comandoDoEnquanto();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(125);
				comandoRetorne();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracaoVarContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(PortugolParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(PortugolParser.EQUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclaracaoVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracaoVar; }
	}

	public final DeclaracaoVarContext declaracaoVar() throws RecognitionException {
		DeclaracaoVarContext _localctx = new DeclaracaoVarContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_declaracaoVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			tipo();
			setState(129);
			match(ID);
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(130);
				match(EQUAL);
				setState(131);
				expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtribuicaoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PortugolParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(PortugolParser.EQUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AtribuicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atribuicao; }
	}

	public final AtribuicaoContext atribuicao() throws RecognitionException {
		AtribuicaoContext _localctx = new AtribuicaoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_atribuicao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(ID);
			setState(135);
			match(EQUAL);
			setState(136);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ChamadaProcContext extends ParserRuleContext {
		public ChamadaProcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chamadaProc; }
	 
		public ChamadaProcContext() { }
		public void copyFrom(ChamadaProcContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ChamadaEscrevaContext extends ChamadaProcContext {
		public TerminalNode ESCREVA() { return getToken(PortugolParser.ESCREVA, 0); }
		public TerminalNode LPAREN() { return getToken(PortugolParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PortugolParser.RPAREN, 0); }
		public ListaArgsContext listaArgs() {
			return getRuleContext(ListaArgsContext.class,0);
		}
		public ChamadaEscrevaContext(ChamadaProcContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ChamadaGenericaContext extends ChamadaProcContext {
		public TerminalNode ID() { return getToken(PortugolParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(PortugolParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PortugolParser.RPAREN, 0); }
		public ListaArgsContext listaArgs() {
			return getRuleContext(ListaArgsContext.class,0);
		}
		public ChamadaGenericaContext(ChamadaProcContext ctx) { copyFrom(ctx); }
	}

	public final ChamadaProcContext chamadaProc() throws RecognitionException {
		ChamadaProcContext _localctx = new ChamadaProcContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_chamadaProc);
		int _la;
		try {
			setState(150);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ESCREVA:
				_localctx = new ChamadaEscrevaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				match(ESCREVA);
				setState(139);
				match(LPAREN);
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 65977240780800L) != 0)) {
					{
					setState(140);
					listaArgs();
					}
				}

				setState(143);
				match(RPAREN);
				}
				break;
			case ID:
				_localctx = new ChamadaGenericaContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				match(ID);
				setState(145);
				match(LPAREN);
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 65977240780800L) != 0)) {
					{
					setState(146);
					listaArgs();
					}
				}

				setState(149);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComandoRetorneContext extends ParserRuleContext {
		public TerminalNode RETORNE() { return getToken(PortugolParser.RETORNE, 0); }
		public TerminalNode SEMI() { return getToken(PortugolParser.SEMI, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ComandoRetorneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoRetorne; }
	}

	public final ComandoRetorneContext comandoRetorne() throws RecognitionException {
		ComandoRetorneContext _localctx = new ComandoRetorneContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_comandoRetorne);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(RETORNE);
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 65977240780800L) != 0)) {
				{
				setState(153);
				expr(0);
				}
			}

			setState(156);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComandoCondicionalContext extends ParserRuleContext {
		public TerminalNode SE() { return getToken(PortugolParser.SE, 0); }
		public TerminalNode LPAREN() { return getToken(PortugolParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PortugolParser.RPAREN, 0); }
		public TerminalNode ENTAO() { return getToken(PortugolParser.ENTAO, 0); }
		public List<BlocoContext> bloco() {
			return getRuleContexts(BlocoContext.class);
		}
		public BlocoContext bloco(int i) {
			return getRuleContext(BlocoContext.class,i);
		}
		public TerminalNode SENAO() { return getToken(PortugolParser.SENAO, 0); }
		public ComandoCondicionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoCondicional; }
	}

	public final ComandoCondicionalContext comandoCondicional() throws RecognitionException {
		ComandoCondicionalContext _localctx = new ComandoCondicionalContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_comandoCondicional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(SE);
			setState(159);
			match(LPAREN);
			setState(160);
			expr(0);
			setState(161);
			match(RPAREN);
			setState(162);
			match(ENTAO);
			setState(163);
			bloco();
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SENAO) {
				{
				setState(164);
				match(SENAO);
				setState(165);
				bloco();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComandoEnquantoContext extends ParserRuleContext {
		public TerminalNode ENQUANTO() { return getToken(PortugolParser.ENQUANTO, 0); }
		public TerminalNode LPAREN() { return getToken(PortugolParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PortugolParser.RPAREN, 0); }
		public TerminalNode FACA() { return getToken(PortugolParser.FACA, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public TerminalNode FIMENQUANTO() { return getToken(PortugolParser.FIMENQUANTO, 0); }
		public ComandoEnquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoEnquanto; }
	}

	public final ComandoEnquantoContext comandoEnquanto() throws RecognitionException {
		ComandoEnquantoContext _localctx = new ComandoEnquantoContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_comandoEnquanto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(ENQUANTO);
			setState(169);
			match(LPAREN);
			setState(170);
			expr(0);
			setState(171);
			match(RPAREN);
			setState(172);
			match(FACA);
			setState(173);
			bloco();
			setState(174);
			match(FIMENQUANTO);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComandoDoEnquantoContext extends ParserRuleContext {
		public TerminalNode FACA() { return getToken(PortugolParser.FACA, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public TerminalNode ENQUANTO() { return getToken(PortugolParser.ENQUANTO, 0); }
		public TerminalNode LPAREN() { return getToken(PortugolParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PortugolParser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(PortugolParser.SEMI, 0); }
		public ComandoDoEnquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoDoEnquanto; }
	}

	public final ComandoDoEnquantoContext comandoDoEnquanto() throws RecognitionException {
		ComandoDoEnquantoContext _localctx = new ComandoDoEnquantoContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_comandoDoEnquanto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(FACA);
			setState(177);
			bloco();
			setState(178);
			match(ENQUANTO);
			setState(179);
			match(LPAREN);
			setState(180);
			expr(0);
			setState(181);
			match(RPAREN);
			setState(182);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComandoParaContext extends ParserRuleContext {
		public TerminalNode PARA() { return getToken(PortugolParser.PARA, 0); }
		public TerminalNode ID() { return getToken(PortugolParser.ID, 0); }
		public TerminalNode DE() { return getToken(PortugolParser.DE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ATE() { return getToken(PortugolParser.ATE, 0); }
		public TerminalNode PASSO() { return getToken(PortugolParser.PASSO, 0); }
		public TerminalNode FACA() { return getToken(PortugolParser.FACA, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public TerminalNode FIMPARA() { return getToken(PortugolParser.FIMPARA, 0); }
		public ComandoParaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoPara; }
	}

	public final ComandoParaContext comandoPara() throws RecognitionException {
		ComandoParaContext _localctx = new ComandoParaContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_comandoPara);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(PARA);
			setState(185);
			match(ID);
			setState(186);
			match(DE);
			setState(187);
			expr(0);
			setState(188);
			match(ATE);
			setState(189);
			expr(0);
			setState(190);
			match(PASSO);
			setState(191);
			expr(0);
			setState(192);
			match(FACA);
			setState(193);
			bloco();
			setState(194);
			match(FIMPARA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListaArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PortugolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PortugolParser.COMMA, i);
		}
		public ListaArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaArgs; }
	}

	public final ListaArgsContext listaArgs() throws RecognitionException {
		ListaArgsContext _localctx = new ListaArgsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_listaArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			expr(0);
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(197);
				match(COMMA);
				setState(198);
				expr(0);
				}
				}
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode E() { return getToken(PortugolParser.E, 0); }
		public AndExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelExprContext extends ExprContext {
		public RelacaoContext relacao() {
			return getRuleContext(RelacaoContext.class,0);
		}
		public RelExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OU() { return getToken(PortugolParser.OU, 0); }
		public OrExprContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new RelExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(205);
			relacao();
			}
			_ctx.stop = _input.LT(-1);
			setState(215);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(213);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(207);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(208);
						match(OU);
						setState(209);
						expr(4);
						}
						break;
					case 2:
						{
						_localctx = new AndExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(210);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(211);
						match(E);
						setState(212);
						expr(3);
						}
						break;
					}
					} 
				}
				setState(217);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RelacaoContext extends ParserRuleContext {
		public List<SomaContext> soma() {
			return getRuleContexts(SomaContext.class);
		}
		public SomaContext soma(int i) {
			return getRuleContext(SomaContext.class,i);
		}
		public List<TerminalNode> LT() { return getTokens(PortugolParser.LT); }
		public TerminalNode LT(int i) {
			return getToken(PortugolParser.LT, i);
		}
		public List<TerminalNode> LE() { return getTokens(PortugolParser.LE); }
		public TerminalNode LE(int i) {
			return getToken(PortugolParser.LE, i);
		}
		public List<TerminalNode> GT() { return getTokens(PortugolParser.GT); }
		public TerminalNode GT(int i) {
			return getToken(PortugolParser.GT, i);
		}
		public List<TerminalNode> GE() { return getTokens(PortugolParser.GE); }
		public TerminalNode GE(int i) {
			return getToken(PortugolParser.GE, i);
		}
		public List<TerminalNode> EQ() { return getTokens(PortugolParser.EQ); }
		public TerminalNode EQ(int i) {
			return getToken(PortugolParser.EQ, i);
		}
		public List<TerminalNode> NE() { return getTokens(PortugolParser.NE); }
		public TerminalNode NE(int i) {
			return getToken(PortugolParser.NE, i);
		}
		public RelacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relacao; }
	}

	public final RelacaoContext relacao() throws RecognitionException {
		RelacaoContext _localctx = new RelacaoContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_relacao);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			soma();
			setState(223);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(219);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4329327034368L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(220);
					soma();
					}
					} 
				}
				setState(225);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SomaContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(PortugolParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(PortugolParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(PortugolParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(PortugolParser.MINUS, i);
		}
		public SomaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_soma; }
	}

	public final SomaContext soma() throws RecognitionException {
		SomaContext _localctx = new SomaContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_soma);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			termo();
			setState(231);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(227);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(228);
					termo();
					}
					} 
				}
				setState(233);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermoContext extends ParserRuleContext {
		public List<UnContext> un() {
			return getRuleContexts(UnContext.class);
		}
		public UnContext un(int i) {
			return getRuleContext(UnContext.class,i);
		}
		public List<TerminalNode> STAR() { return getTokens(PortugolParser.STAR); }
		public TerminalNode STAR(int i) {
			return getToken(PortugolParser.STAR, i);
		}
		public List<TerminalNode> SLASH() { return getTokens(PortugolParser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(PortugolParser.SLASH, i);
		}
		public List<TerminalNode> PERCENT() { return getTokens(PortugolParser.PERCENT); }
		public TerminalNode PERCENT(int i) {
			return getToken(PortugolParser.PERCENT, i);
		}
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_termo);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			un();
			setState(239);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(235);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 60129542144L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(236);
					un();
					}
					} 
				}
				setState(241);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnContext extends ParserRuleContext {
		public UnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_un; }
	 
		public UnContext() { }
		public void copyFrom(UnContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegExprContext extends UnContext {
		public TerminalNode MINUS() { return getToken(PortugolParser.MINUS, 0); }
		public UnContext un() {
			return getRuleContext(UnContext.class,0);
		}
		public NegExprContext(UnContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimExprContext extends UnContext {
		public PrimContext prim() {
			return getRuleContext(PrimContext.class,0);
		}
		public PrimExprContext(UnContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotExprContext extends UnContext {
		public TerminalNode NAO() { return getToken(PortugolParser.NAO, 0); }
		public UnContext un() {
			return getRuleContext(UnContext.class,0);
		}
		public NotExprContext(UnContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PosExprContext extends UnContext {
		public TerminalNode PLUS() { return getToken(PortugolParser.PLUS, 0); }
		public UnContext un() {
			return getRuleContext(UnContext.class,0);
		}
		public PosExprContext(UnContext ctx) { copyFrom(ctx); }
	}

	public final UnContext un() throws RecognitionException {
		UnContext _localctx = new UnContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_un);
		try {
			setState(249);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAO:
				_localctx = new NotExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(242);
				match(NAO);
				setState(243);
				un();
				}
				break;
			case MINUS:
				_localctx = new NegExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				match(MINUS);
				setState(245);
				un();
				}
				break;
			case PLUS:
				_localctx = new PosExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(246);
				match(PLUS);
				setState(247);
				un();
				}
				break;
			case LPAREN:
			case BOOL_LITERAL:
			case NUM_LITERAL:
			case STRING_LITERAL:
			case ID:
				_localctx = new PrimExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(248);
				prim();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(PortugolParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PortugolParser.RPAREN, 0); }
		public TerminalNode BOOL_LITERAL() { return getToken(PortugolParser.BOOL_LITERAL, 0); }
		public TerminalNode NUM_LITERAL() { return getToken(PortugolParser.NUM_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(PortugolParser.STRING_LITERAL, 0); }
		public ChamadaFuncContext chamadaFunc() {
			return getRuleContext(ChamadaFuncContext.class,0);
		}
		public TerminalNode ID() { return getToken(PortugolParser.ID, 0); }
		public PrimContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prim; }
	}

	public final PrimContext prim() throws RecognitionException {
		PrimContext _localctx = new PrimContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_prim);
		try {
			setState(260);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(251);
				match(LPAREN);
				setState(252);
				expr(0);
				setState(253);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				match(BOOL_LITERAL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(256);
				match(NUM_LITERAL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(257);
				match(STRING_LITERAL);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(258);
				chamadaFunc();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(259);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ChamadaFuncContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PortugolParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(PortugolParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PortugolParser.RPAREN, 0); }
		public ListaArgsContext listaArgs() {
			return getRuleContext(ListaArgsContext.class,0);
		}
		public ChamadaFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chamadaFunc; }
	}

	public final ChamadaFuncContext chamadaFunc() throws RecognitionException {
		ChamadaFuncContext _localctx = new ChamadaFuncContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_chamadaFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			match(ID);
			setState(263);
			match(LPAREN);
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 65977240780800L) != 0)) {
				{
				setState(264);
				listaArgs();
				}
			}

			setState(267);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 19:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00010\u010e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0001\u0000\u0001\u0000\u0005\u00007\b\u0000"+
		"\n\u0000\f\u0000:\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0005\u0003M\b\u0003\n\u0003\f\u0003P\t\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004V\b\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005_\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0005\u0006g\b\u0006\n\u0006\f\u0006j\t\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0003\t\u007f\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0003"+
		"\n\u0085\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0003\f\u008e\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0094"+
		"\b\f\u0001\f\u0003\f\u0097\b\f\u0001\r\u0001\r\u0003\r\u009b\b\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00a7\b\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0005\u0012\u00c8\b\u0012\n\u0012\f\u0012\u00cb\t\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0005\u0013\u00d6\b\u0013\n\u0013\f\u0013\u00d9\t\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u00de\b\u0014\n\u0014"+
		"\f\u0014\u00e1\t\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015"+
		"\u00e6\b\u0015\n\u0015\f\u0015\u00e9\t\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0005\u0016\u00ee\b\u0016\n\u0016\f\u0016\u00f1\t\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0003\u0017\u00fa\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018"+
		"\u0105\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u010a\b"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0000\u0001&\u001a\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02\u0000\u0004\u0001\u0000\u0005\b\u0001\u0000$)\u0001\u0000"+
		"\u001f \u0001\u0000!#\u0115\u00008\u0001\u0000\u0000\u0000\u0002C\u0001"+
		"\u0000\u0000\u0000\u0004G\u0001\u0000\u0000\u0000\u0006N\u0001\u0000\u0000"+
		"\u0000\bQ\u0001\u0000\u0000\u0000\nZ\u0001\u0000\u0000\u0000\fc\u0001"+
		"\u0000\u0000\u0000\u000ek\u0001\u0000\u0000\u0000\u0010n\u0001\u0000\u0000"+
		"\u0000\u0012~\u0001\u0000\u0000\u0000\u0014\u0080\u0001\u0000\u0000\u0000"+
		"\u0016\u0086\u0001\u0000\u0000\u0000\u0018\u0096\u0001\u0000\u0000\u0000"+
		"\u001a\u0098\u0001\u0000\u0000\u0000\u001c\u009e\u0001\u0000\u0000\u0000"+
		"\u001e\u00a8\u0001\u0000\u0000\u0000 \u00b0\u0001\u0000\u0000\u0000\""+
		"\u00b8\u0001\u0000\u0000\u0000$\u00c4\u0001\u0000\u0000\u0000&\u00cc\u0001"+
		"\u0000\u0000\u0000(\u00da\u0001\u0000\u0000\u0000*\u00e2\u0001\u0000\u0000"+
		"\u0000,\u00ea\u0001\u0000\u0000\u0000.\u00f9\u0001\u0000\u0000\u00000"+
		"\u0104\u0001\u0000\u0000\u00002\u0106\u0001\u0000\u0000\u000047\u0003"+
		"\b\u0004\u000057\u0003\n\u0005\u000064\u0001\u0000\u0000\u000065\u0001"+
		"\u0000\u0000\u00007:\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u0000"+
		"89\u0001\u0000\u0000\u00009;\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000"+
		"\u0000;<\u0005\u0001\u0000\u0000<=\u0005-\u0000\u0000=>\u0005\u001a\u0000"+
		"\u0000>?\u0005\u001b\u0000\u0000?@\u0003\u0002\u0001\u0000@A\u0005\u0002"+
		"\u0000\u0000AB\u0005\u0000\u0000\u0001B\u0001\u0001\u0000\u0000\u0000"+
		"CD\u0005\u0003\u0000\u0000DE\u0003\u0006\u0003\u0000EF\u0005\u0004\u0000"+
		"\u0000F\u0003\u0001\u0000\u0000\u0000GH\u0005\u0003\u0000\u0000HI\u0003"+
		"\u0006\u0003\u0000IJ\u0005\u0004\u0000\u0000J\u0005\u0001\u0000\u0000"+
		"\u0000KM\u0003\u0012\t\u0000LK\u0001\u0000\u0000\u0000MP\u0001\u0000\u0000"+
		"\u0000NL\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000O\u0007\u0001"+
		"\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000QR\u0003\u0010\b\u0000RS\u0005"+
		"-\u0000\u0000SU\u0005\u001a\u0000\u0000TV\u0003\f\u0006\u0000UT\u0001"+
		"\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000"+
		"WX\u0005\u001b\u0000\u0000XY\u0003\u0004\u0002\u0000Y\t\u0001\u0000\u0000"+
		"\u0000Z[\u0005\u0015\u0000\u0000[\\\u0005-\u0000\u0000\\^\u0005\u001a"+
		"\u0000\u0000]_\u0003\f\u0006\u0000^]\u0001\u0000\u0000\u0000^_\u0001\u0000"+
		"\u0000\u0000_`\u0001\u0000\u0000\u0000`a\u0005\u001b\u0000\u0000ab\u0003"+
		"\u0004\u0002\u0000b\u000b\u0001\u0000\u0000\u0000ch\u0003\u000e\u0007"+
		"\u0000de\u0005\u001c\u0000\u0000eg\u0003\u000e\u0007\u0000fd\u0001\u0000"+
		"\u0000\u0000gj\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000hi\u0001"+
		"\u0000\u0000\u0000i\r\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000"+
		"kl\u0003\u0010\b\u0000lm\u0005-\u0000\u0000m\u000f\u0001\u0000\u0000\u0000"+
		"no\u0007\u0000\u0000\u0000o\u0011\u0001\u0000\u0000\u0000pq\u0003\u0014"+
		"\n\u0000qr\u0005\u001d\u0000\u0000r\u007f\u0001\u0000\u0000\u0000st\u0003"+
		"\u0016\u000b\u0000tu\u0005\u001d\u0000\u0000u\u007f\u0001\u0000\u0000"+
		"\u0000vw\u0003\u0018\f\u0000wx\u0005\u001d\u0000\u0000x\u007f\u0001\u0000"+
		"\u0000\u0000y\u007f\u0003\u001c\u000e\u0000z\u007f\u0003\u001e\u000f\u0000"+
		"{\u007f\u0003\"\u0011\u0000|\u007f\u0003 \u0010\u0000}\u007f\u0003\u001a"+
		"\r\u0000~p\u0001\u0000\u0000\u0000~s\u0001\u0000\u0000\u0000~v\u0001\u0000"+
		"\u0000\u0000~y\u0001\u0000\u0000\u0000~z\u0001\u0000\u0000\u0000~{\u0001"+
		"\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000~}\u0001\u0000\u0000\u0000"+
		"\u007f\u0013\u0001\u0000\u0000\u0000\u0080\u0081\u0003\u0010\b\u0000\u0081"+
		"\u0084\u0005-\u0000\u0000\u0082\u0083\u0005\u001e\u0000\u0000\u0083\u0085"+
		"\u0003&\u0013\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0084\u0085\u0001"+
		"\u0000\u0000\u0000\u0085\u0015\u0001\u0000\u0000\u0000\u0086\u0087\u0005"+
		"-\u0000\u0000\u0087\u0088\u0005\u001e\u0000\u0000\u0088\u0089\u0003&\u0013"+
		"\u0000\u0089\u0017\u0001\u0000\u0000\u0000\u008a\u008b\u0005\u0014\u0000"+
		"\u0000\u008b\u008d\u0005\u001a\u0000\u0000\u008c\u008e\u0003$\u0012\u0000"+
		"\u008d\u008c\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000"+
		"\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u0097\u0005\u001b\u0000\u0000"+
		"\u0090\u0091\u0005-\u0000\u0000\u0091\u0093\u0005\u001a\u0000\u0000\u0092"+
		"\u0094\u0003$\u0012\u0000\u0093\u0092\u0001\u0000\u0000\u0000\u0093\u0094"+
		"\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0097"+
		"\u0005\u001b\u0000\u0000\u0096\u008a\u0001\u0000\u0000\u0000\u0096\u0090"+
		"\u0001\u0000\u0000\u0000\u0097\u0019\u0001\u0000\u0000\u0000\u0098\u009a"+
		"\u0005\u0016\u0000\u0000\u0099\u009b\u0003&\u0013\u0000\u009a\u0099\u0001"+
		"\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u009c\u0001"+
		"\u0000\u0000\u0000\u009c\u009d\u0005\u001d\u0000\u0000\u009d\u001b\u0001"+
		"\u0000\u0000\u0000\u009e\u009f\u0005\t\u0000\u0000\u009f\u00a0\u0005\u001a"+
		"\u0000\u0000\u00a0\u00a1\u0003&\u0013\u0000\u00a1\u00a2\u0005\u001b\u0000"+
		"\u0000\u00a2\u00a3\u0005\n\u0000\u0000\u00a3\u00a6\u0003\u0004\u0002\u0000"+
		"\u00a4\u00a5\u0005\u000b\u0000\u0000\u00a5\u00a7\u0003\u0004\u0002\u0000"+
		"\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000"+
		"\u00a7\u001d\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005\f\u0000\u0000\u00a9"+
		"\u00aa\u0005\u001a\u0000\u0000\u00aa\u00ab\u0003&\u0013\u0000\u00ab\u00ac"+
		"\u0005\u001b\u0000\u0000\u00ac\u00ad\u0005\r\u0000\u0000\u00ad\u00ae\u0003"+
		"\u0004\u0002\u0000\u00ae\u00af\u0005\u000e\u0000\u0000\u00af\u001f\u0001"+
		"\u0000\u0000\u0000\u00b0\u00b1\u0005\r\u0000\u0000\u00b1\u00b2\u0003\u0004"+
		"\u0002\u0000\u00b2\u00b3\u0005\f\u0000\u0000\u00b3\u00b4\u0005\u001a\u0000"+
		"\u0000\u00b4\u00b5\u0003&\u0013\u0000\u00b5\u00b6\u0005\u001b\u0000\u0000"+
		"\u00b6\u00b7\u0005\u001d\u0000\u0000\u00b7!\u0001\u0000\u0000\u0000\u00b8"+
		"\u00b9\u0005\u000f\u0000\u0000\u00b9\u00ba\u0005-\u0000\u0000\u00ba\u00bb"+
		"\u0005\u0010\u0000\u0000\u00bb\u00bc\u0003&\u0013\u0000\u00bc\u00bd\u0005"+
		"\u0011\u0000\u0000\u00bd\u00be\u0003&\u0013\u0000\u00be\u00bf\u0005\u0012"+
		"\u0000\u0000\u00bf\u00c0\u0003&\u0013\u0000\u00c0\u00c1\u0005\r\u0000"+
		"\u0000\u00c1\u00c2\u0003\u0004\u0002\u0000\u00c2\u00c3\u0005\u0013\u0000"+
		"\u0000\u00c3#\u0001\u0000\u0000\u0000\u00c4\u00c9\u0003&\u0013\u0000\u00c5"+
		"\u00c6\u0005\u001c\u0000\u0000\u00c6\u00c8\u0003&\u0013\u0000\u00c7\u00c5"+
		"\u0001\u0000\u0000\u0000\u00c8\u00cb\u0001\u0000\u0000\u0000\u00c9\u00c7"+
		"\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca%\u0001"+
		"\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cc\u00cd\u0006"+
		"\u0013\uffff\uffff\u0000\u00cd\u00ce\u0003(\u0014\u0000\u00ce\u00d7\u0001"+
		"\u0000\u0000\u0000\u00cf\u00d0\n\u0003\u0000\u0000\u00d0\u00d1\u0005\u0018"+
		"\u0000\u0000\u00d1\u00d6\u0003&\u0013\u0004\u00d2\u00d3\n\u0002\u0000"+
		"\u0000\u00d3\u00d4\u0005\u0017\u0000\u0000\u00d4\u00d6\u0003&\u0013\u0003"+
		"\u00d5\u00cf\u0001\u0000\u0000\u0000\u00d5\u00d2\u0001\u0000\u0000\u0000"+
		"\u00d6\u00d9\u0001\u0000\u0000\u0000\u00d7\u00d5\u0001\u0000\u0000\u0000"+
		"\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8\'\u0001\u0000\u0000\u0000\u00d9"+
		"\u00d7\u0001\u0000\u0000\u0000\u00da\u00df\u0003*\u0015\u0000\u00db\u00dc"+
		"\u0007\u0001\u0000\u0000\u00dc\u00de\u0003*\u0015\u0000\u00dd\u00db\u0001"+
		"\u0000\u0000\u0000\u00de\u00e1\u0001\u0000\u0000\u0000\u00df\u00dd\u0001"+
		"\u0000\u0000\u0000\u00df\u00e0\u0001\u0000\u0000\u0000\u00e0)\u0001\u0000"+
		"\u0000\u0000\u00e1\u00df\u0001\u0000\u0000\u0000\u00e2\u00e7\u0003,\u0016"+
		"\u0000\u00e3\u00e4\u0007\u0002\u0000\u0000\u00e4\u00e6\u0003,\u0016\u0000"+
		"\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e6\u00e9\u0001\u0000\u0000\u0000"+
		"\u00e7\u00e5\u0001\u0000\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000"+
		"\u00e8+\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000\u00ea"+
		"\u00ef\u0003.\u0017\u0000\u00eb\u00ec\u0007\u0003\u0000\u0000\u00ec\u00ee"+
		"\u0003.\u0017\u0000\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ee\u00f1\u0001"+
		"\u0000\u0000\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000\u00ef\u00f0\u0001"+
		"\u0000\u0000\u0000\u00f0-\u0001\u0000\u0000\u0000\u00f1\u00ef\u0001\u0000"+
		"\u0000\u0000\u00f2\u00f3\u0005\u0019\u0000\u0000\u00f3\u00fa\u0003.\u0017"+
		"\u0000\u00f4\u00f5\u0005 \u0000\u0000\u00f5\u00fa\u0003.\u0017\u0000\u00f6"+
		"\u00f7\u0005\u001f\u0000\u0000\u00f7\u00fa\u0003.\u0017\u0000\u00f8\u00fa"+
		"\u00030\u0018\u0000\u00f9\u00f2\u0001\u0000\u0000\u0000\u00f9\u00f4\u0001"+
		"\u0000\u0000\u0000\u00f9\u00f6\u0001\u0000\u0000\u0000\u00f9\u00f8\u0001"+
		"\u0000\u0000\u0000\u00fa/\u0001\u0000\u0000\u0000\u00fb\u00fc\u0005\u001a"+
		"\u0000\u0000\u00fc\u00fd\u0003&\u0013\u0000\u00fd\u00fe\u0005\u001b\u0000"+
		"\u0000\u00fe\u0105\u0001\u0000\u0000\u0000\u00ff\u0105\u0005*\u0000\u0000"+
		"\u0100\u0105\u0005+\u0000\u0000\u0101\u0105\u0005,\u0000\u0000\u0102\u0105"+
		"\u00032\u0019\u0000\u0103\u0105\u0005-\u0000\u0000\u0104\u00fb\u0001\u0000"+
		"\u0000\u0000\u0104\u00ff\u0001\u0000\u0000\u0000\u0104\u0100\u0001\u0000"+
		"\u0000\u0000\u0104\u0101\u0001\u0000\u0000\u0000\u0104\u0102\u0001\u0000"+
		"\u0000\u0000\u0104\u0103\u0001\u0000\u0000\u0000\u01051\u0001\u0000\u0000"+
		"\u0000\u0106\u0107\u0005-\u0000\u0000\u0107\u0109\u0005\u001a\u0000\u0000"+
		"\u0108\u010a\u0003$\u0012\u0000\u0109\u0108\u0001\u0000\u0000\u0000\u0109"+
		"\u010a\u0001\u0000\u0000\u0000\u010a\u010b\u0001\u0000\u0000\u0000\u010b"+
		"\u010c\u0005\u001b\u0000\u0000\u010c3\u0001\u0000\u0000\u0000\u001668"+
		"NU^h~\u0084\u008d\u0093\u0096\u009a\u00a6\u00c9\u00d5\u00d7\u00df\u00e7"+
		"\u00ef\u00f9\u0104\u0109";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
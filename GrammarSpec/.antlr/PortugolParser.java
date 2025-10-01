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
		PROGRAMA=1, INICIO=2, FIM=3, FIMPROGRAMA=4, SE=5, ENTAO=6, SENAO=7, ENQUANTO=8, 
		FACA=9, FIMENQUANTO=10, PARA=11, DE=12, ATE=13, PASSO=14, FIMPARA=15, 
		ESCREVA=16, E=17, OU=18, NAO=19, INTEIRO=20, REAL=21, LOGICO=22, TEXTO=23, 
		BOOL_LITERAL=24, NUM_LITERAL=25, STRING_LITERAL=26, EQEQ=27, NEQ=28, GE=29, 
		LE=30, GT=31, LT=32, EQUAL=33, PLUS=34, MINUS=35, MULT=36, DIV=37, LPAREN=38, 
		RPAREN=39, SEMI=40, COMMA=41, ID=42, WS=43, COMMENT=44, BLOCK_COMMENT=45;
	public static final int
		RULE_programa = 0, RULE_blocoPrincipal = 1, RULE_declaracoes = 2, RULE_declaracao = 3, 
		RULE_tipo = 4, RULE_comandos = 5, RULE_comando = 6, RULE_atribuicao = 7, 
		RULE_comandoCondicional = 8, RULE_comandoEnquanto = 9, RULE_comandoPara = 10, 
		RULE_comandoSaida = 11, RULE_blocoComandos = 12, RULE_expr = 13, RULE_exprLogica = 14, 
		RULE_exprRelacional = 15, RULE_exprAritmetica = 16, RULE_termo = 17, RULE_fator = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "blocoPrincipal", "declaracoes", "declaracao", "tipo", "comandos", 
			"comando", "atribuicao", "comandoCondicional", "comandoEnquanto", "comandoPara", 
			"comandoSaida", "blocoComandos", "expr", "exprLogica", "exprRelacional", 
			"exprAritmetica", "termo", "fator"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'inicio'", "'fim'", "'fimPrograma'", "'se'", "'entao'", 
			"'senao'", "'enquanto'", "'faca'", "'fimEnquanto'", "'para'", "'de'", 
			"'ate'", "'passo'", "'fimPara'", "'escreva'", "'e'", "'ou'", "'nao'", 
			"'inteiro'", "'real'", "'logico'", "'texto'", null, null, null, "'=='", 
			"'!='", "'>='", "'<='", "'>'", "'<'", "'='", "'+'", "'-'", "'*'", "'/'", 
			"'('", "')'", "';'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PROGRAMA", "INICIO", "FIM", "FIMPROGRAMA", "SE", "ENTAO", "SENAO", 
			"ENQUANTO", "FACA", "FIMENQUANTO", "PARA", "DE", "ATE", "PASSO", "FIMPARA", 
			"ESCREVA", "E", "OU", "NAO", "INTEIRO", "REAL", "LOGICO", "TEXTO", "BOOL_LITERAL", 
			"NUM_LITERAL", "STRING_LITERAL", "EQEQ", "NEQ", "GE", "LE", "GT", "LT", 
			"EQUAL", "PLUS", "MINUS", "MULT", "DIV", "LPAREN", "RPAREN", "SEMI", 
			"COMMA", "ID", "WS", "COMMENT", "BLOCK_COMMENT"
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
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(PROGRAMA);
			setState(39);
			match(ID);
			setState(40);
			match(LPAREN);
			setState(41);
			match(RPAREN);
			setState(42);
			blocoPrincipal();
			setState(43);
			match(FIMPROGRAMA);
			setState(44);
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
			setState(46);
			match(INICIO);
			setState(47);
			comandos();
			setState(48);
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
	public static class DeclaracoesContext extends ParserRuleContext {
		public List<DeclaracaoContext> declaracao() {
			return getRuleContexts(DeclaracaoContext.class);
		}
		public DeclaracaoContext declaracao(int i) {
			return getRuleContext(DeclaracaoContext.class,i);
		}
		public DeclaracoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracoes; }
	}

	public final DeclaracoesContext declaracoes() throws RecognitionException {
		DeclaracoesContext _localctx = new DeclaracoesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaracoes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(50);
				declaracao();
				}
				}
				setState(53); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 15728640L) != 0) );
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
	public static class DeclaracaoContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(PortugolParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(PortugolParser.SEMI, 0); }
		public TerminalNode EQUAL() { return getToken(PortugolParser.EQUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclaracaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao; }
	}

	public final DeclaracaoContext declaracao() throws RecognitionException {
		DeclaracaoContext _localctx = new DeclaracaoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaracao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			tipo();
			setState(56);
			match(ID);
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(57);
				match(EQUAL);
				setState(58);
				expr();
				}
			}

			setState(61);
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
		enterRule(_localctx, 8, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 15728640L) != 0)) ) {
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
	public static class ComandosContext extends ParserRuleContext {
		public List<DeclaracaoContext> declaracao() {
			return getRuleContexts(DeclaracaoContext.class);
		}
		public DeclaracaoContext declaracao(int i) {
			return getRuleContext(DeclaracaoContext.class,i);
		}
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
		enterRule(_localctx, 10, RULE_comandos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(67);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INTEIRO:
				case REAL:
				case LOGICO:
				case TEXTO:
					{
					setState(65);
					declaracao();
					}
					break;
				case SE:
				case ENQUANTO:
				case PARA:
				case ESCREVA:
				case ID:
					{
					setState(66);
					comando();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(69); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4398062307616L) != 0) );
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
		public AtribuicaoContext atribuicao() {
			return getRuleContext(AtribuicaoContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(PortugolParser.SEMI, 0); }
		public ComandoCondicionalContext comandoCondicional() {
			return getRuleContext(ComandoCondicionalContext.class,0);
		}
		public ComandoEnquantoContext comandoEnquanto() {
			return getRuleContext(ComandoEnquantoContext.class,0);
		}
		public ComandoParaContext comandoPara() {
			return getRuleContext(ComandoParaContext.class,0);
		}
		public ComandoSaidaContext comandoSaida() {
			return getRuleContext(ComandoSaidaContext.class,0);
		}
		public ComandoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comando; }
	}

	public final ComandoContext comando() throws RecognitionException {
		ComandoContext _localctx = new ComandoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_comando);
		try {
			setState(80);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				atribuicao();
				setState(72);
				match(SEMI);
				}
				break;
			case SE:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				comandoCondicional();
				}
				break;
			case ENQUANTO:
				enterOuterAlt(_localctx, 3);
				{
				setState(75);
				comandoEnquanto();
				}
				break;
			case PARA:
				enterOuterAlt(_localctx, 4);
				{
				setState(76);
				comandoPara();
				}
				break;
			case ESCREVA:
				enterOuterAlt(_localctx, 5);
				{
				setState(77);
				comandoSaida();
				setState(78);
				match(SEMI);
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
		enterRule(_localctx, 14, RULE_atribuicao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(ID);
			setState(83);
			match(EQUAL);
			setState(84);
			expr();
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
		public List<BlocoComandosContext> blocoComandos() {
			return getRuleContexts(BlocoComandosContext.class);
		}
		public BlocoComandosContext blocoComandos(int i) {
			return getRuleContext(BlocoComandosContext.class,i);
		}
		public TerminalNode SENAO() { return getToken(PortugolParser.SENAO, 0); }
		public ComandoCondicionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoCondicional; }
	}

	public final ComandoCondicionalContext comandoCondicional() throws RecognitionException {
		ComandoCondicionalContext _localctx = new ComandoCondicionalContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_comandoCondicional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(SE);
			setState(87);
			match(LPAREN);
			setState(88);
			expr();
			setState(89);
			match(RPAREN);
			setState(90);
			match(ENTAO);
			setState(91);
			blocoComandos();
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SENAO) {
				{
				setState(92);
				match(SENAO);
				setState(93);
				blocoComandos();
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
		public BlocoComandosContext blocoComandos() {
			return getRuleContext(BlocoComandosContext.class,0);
		}
		public TerminalNode FIMENQUANTO() { return getToken(PortugolParser.FIMENQUANTO, 0); }
		public ComandoEnquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoEnquanto; }
	}

	public final ComandoEnquantoContext comandoEnquanto() throws RecognitionException {
		ComandoEnquantoContext _localctx = new ComandoEnquantoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_comandoEnquanto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(ENQUANTO);
			setState(97);
			match(LPAREN);
			setState(98);
			expr();
			setState(99);
			match(RPAREN);
			setState(100);
			match(FACA);
			setState(101);
			blocoComandos();
			setState(102);
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
		public BlocoComandosContext blocoComandos() {
			return getRuleContext(BlocoComandosContext.class,0);
		}
		public TerminalNode FIMPARA() { return getToken(PortugolParser.FIMPARA, 0); }
		public ComandoParaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoPara; }
	}

	public final ComandoParaContext comandoPara() throws RecognitionException {
		ComandoParaContext _localctx = new ComandoParaContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_comandoPara);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(PARA);
			setState(105);
			match(ID);
			setState(106);
			match(DE);
			setState(107);
			expr();
			setState(108);
			match(ATE);
			setState(109);
			expr();
			setState(110);
			match(PASSO);
			setState(111);
			expr();
			setState(112);
			match(FACA);
			setState(113);
			blocoComandos();
			setState(114);
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
	public static class ComandoSaidaContext extends ParserRuleContext {
		public TerminalNode ESCREVA() { return getToken(PortugolParser.ESCREVA, 0); }
		public TerminalNode LPAREN() { return getToken(PortugolParser.LPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(PortugolParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(PortugolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PortugolParser.COMMA, i);
		}
		public ComandoSaidaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoSaida; }
	}

	public final ComandoSaidaContext comandoSaida() throws RecognitionException {
		ComandoSaidaContext _localctx = new ComandoSaidaContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_comandoSaida);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(ESCREVA);
			setState(117);
			match(LPAREN);
			setState(118);
			expr();
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(119);
				match(COMMA);
				setState(120);
				expr();
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(126);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlocoComandosContext extends ParserRuleContext {
		public TerminalNode INICIO() { return getToken(PortugolParser.INICIO, 0); }
		public ComandosContext comandos() {
			return getRuleContext(ComandosContext.class,0);
		}
		public TerminalNode FIM() { return getToken(PortugolParser.FIM, 0); }
		public BlocoComandosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blocoComandos; }
	}

	public final BlocoComandosContext blocoComandos() throws RecognitionException {
		BlocoComandosContext _localctx = new BlocoComandosContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_blocoComandos);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(INICIO);
			setState(129);
			comandos();
			setState(130);
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
	public static class ExprContext extends ParserRuleContext {
		public ExprLogicaContext exprLogica() {
			return getRuleContext(ExprLogicaContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			exprLogica();
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
	public static class ExprLogicaContext extends ParserRuleContext {
		public List<ExprRelacionalContext> exprRelacional() {
			return getRuleContexts(ExprRelacionalContext.class);
		}
		public ExprRelacionalContext exprRelacional(int i) {
			return getRuleContext(ExprRelacionalContext.class,i);
		}
		public List<TerminalNode> E() { return getTokens(PortugolParser.E); }
		public TerminalNode E(int i) {
			return getToken(PortugolParser.E, i);
		}
		public List<TerminalNode> OU() { return getTokens(PortugolParser.OU); }
		public TerminalNode OU(int i) {
			return getToken(PortugolParser.OU, i);
		}
		public ExprLogicaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprLogica; }
	}

	public final ExprLogicaContext exprLogica() throws RecognitionException {
		ExprLogicaContext _localctx = new ExprLogicaContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_exprLogica);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			exprRelacional();
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==E || _la==OU) {
				{
				{
				setState(135);
				_la = _input.LA(1);
				if ( !(_la==E || _la==OU) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(136);
				exprRelacional();
				}
				}
				setState(141);
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
	public static class ExprRelacionalContext extends ParserRuleContext {
		public List<ExprAritmeticaContext> exprAritmetica() {
			return getRuleContexts(ExprAritmeticaContext.class);
		}
		public ExprAritmeticaContext exprAritmetica(int i) {
			return getRuleContext(ExprAritmeticaContext.class,i);
		}
		public List<TerminalNode> GT() { return getTokens(PortugolParser.GT); }
		public TerminalNode GT(int i) {
			return getToken(PortugolParser.GT, i);
		}
		public List<TerminalNode> LT() { return getTokens(PortugolParser.LT); }
		public TerminalNode LT(int i) {
			return getToken(PortugolParser.LT, i);
		}
		public List<TerminalNode> GE() { return getTokens(PortugolParser.GE); }
		public TerminalNode GE(int i) {
			return getToken(PortugolParser.GE, i);
		}
		public List<TerminalNode> LE() { return getTokens(PortugolParser.LE); }
		public TerminalNode LE(int i) {
			return getToken(PortugolParser.LE, i);
		}
		public List<TerminalNode> EQEQ() { return getTokens(PortugolParser.EQEQ); }
		public TerminalNode EQEQ(int i) {
			return getToken(PortugolParser.EQEQ, i);
		}
		public List<TerminalNode> NEQ() { return getTokens(PortugolParser.NEQ); }
		public TerminalNode NEQ(int i) {
			return getToken(PortugolParser.NEQ, i);
		}
		public ExprRelacionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprRelacional; }
	}

	public final ExprRelacionalContext exprRelacional() throws RecognitionException {
		ExprRelacionalContext _localctx = new ExprRelacionalContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_exprRelacional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			exprAritmetica();
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8455716864L) != 0)) {
				{
				{
				setState(143);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8455716864L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(144);
				exprAritmetica();
				}
				}
				setState(149);
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
	public static class ExprAritmeticaContext extends ParserRuleContext {
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
		public ExprAritmeticaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprAritmetica; }
	}

	public final ExprAritmeticaContext exprAritmetica() throws RecognitionException {
		ExprAritmeticaContext _localctx = new ExprAritmeticaContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_exprAritmetica);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			termo();
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(151);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(152);
				termo();
				}
				}
				setState(157);
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
	public static class TermoContext extends ParserRuleContext {
		public List<FatorContext> fator() {
			return getRuleContexts(FatorContext.class);
		}
		public FatorContext fator(int i) {
			return getRuleContext(FatorContext.class,i);
		}
		public List<TerminalNode> MULT() { return getTokens(PortugolParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(PortugolParser.MULT, i);
		}
		public List<TerminalNode> DIV() { return getTokens(PortugolParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(PortugolParser.DIV, i);
		}
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_termo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			fator();
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULT || _la==DIV) {
				{
				{
				setState(159);
				_la = _input.LA(1);
				if ( !(_la==MULT || _la==DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(160);
				fator();
				}
				}
				setState(165);
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
	public static class FatorContext extends ParserRuleContext {
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
	 
		public FatorContext() { }
		public void copyFrom(FatorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumeroContext extends FatorContext {
		public TerminalNode NUM_LITERAL() { return getToken(PortugolParser.NUM_LITERAL, 0); }
		public NumeroContext(FatorContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanoContext extends FatorContext {
		public TerminalNode BOOL_LITERAL() { return getToken(PortugolParser.BOOL_LITERAL, 0); }
		public BooleanoContext(FatorContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SubExprContext extends FatorContext {
		public TerminalNode LPAREN() { return getToken(PortugolParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PortugolParser.RPAREN, 0); }
		public SubExprContext(FatorContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TextoLiteralContext extends FatorContext {
		public TerminalNode STRING_LITERAL() { return getToken(PortugolParser.STRING_LITERAL, 0); }
		public TextoLiteralContext(FatorContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegacaoContext extends FatorContext {
		public TerminalNode NAO() { return getToken(PortugolParser.NAO, 0); }
		public FatorContext fator() {
			return getRuleContext(FatorContext.class,0);
		}
		public NegacaoContext(FatorContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentificadorContext extends FatorContext {
		public TerminalNode ID() { return getToken(PortugolParser.ID, 0); }
		public IdentificadorContext(FatorContext ctx) { copyFrom(ctx); }
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_fator);
		try {
			setState(176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new SubExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				match(LPAREN);
				setState(167);
				expr();
				setState(168);
				match(RPAREN);
				}
				break;
			case NAO:
				_localctx = new NegacaoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(170);
				match(NAO);
				setState(171);
				fator();
				}
				break;
			case BOOL_LITERAL:
				_localctx = new BooleanoContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(172);
				match(BOOL_LITERAL);
				}
				break;
			case NUM_LITERAL:
				_localctx = new NumeroContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(173);
				match(NUM_LITERAL);
				}
				break;
			case STRING_LITERAL:
				_localctx = new TextoLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(174);
				match(STRING_LITERAL);
				}
				break;
			case ID:
				_localctx = new IdentificadorContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(175);
				match(ID);
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

	public static final String _serializedATN =
		"\u0004\u0001-\u00b3\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0004\u00024\b\u0002\u000b\u0002\f\u00025\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003<\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0004\u0005D\b"+
		"\u0005\u000b\u0005\f\u0005E\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006Q\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b_\b"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0005\u000bz\b\u000b\n\u000b\f\u000b}\t\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0005\u000e\u008a\b\u000e\n\u000e\f\u000e\u008d\t\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0092\b\u000f\n\u000f"+
		"\f\u000f\u0095\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010"+
		"\u009a\b\u0010\n\u0010\f\u0010\u009d\t\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0005\u0011\u00a2\b\u0011\n\u0011\f\u0011\u00a5\t\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00b1\b\u0012\u0001\u0012"+
		"\u0000\u0000\u0013\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$\u0000\u0005\u0001\u0000\u0014\u0017"+
		"\u0001\u0000\u0011\u0012\u0001\u0000\u001b \u0001\u0000\"#\u0001\u0000"+
		"$%\u00b2\u0000&\u0001\u0000\u0000\u0000\u0002.\u0001\u0000\u0000\u0000"+
		"\u00043\u0001\u0000\u0000\u0000\u00067\u0001\u0000\u0000\u0000\b?\u0001"+
		"\u0000\u0000\u0000\nC\u0001\u0000\u0000\u0000\fP\u0001\u0000\u0000\u0000"+
		"\u000eR\u0001\u0000\u0000\u0000\u0010V\u0001\u0000\u0000\u0000\u0012`"+
		"\u0001\u0000\u0000\u0000\u0014h\u0001\u0000\u0000\u0000\u0016t\u0001\u0000"+
		"\u0000\u0000\u0018\u0080\u0001\u0000\u0000\u0000\u001a\u0084\u0001\u0000"+
		"\u0000\u0000\u001c\u0086\u0001\u0000\u0000\u0000\u001e\u008e\u0001\u0000"+
		"\u0000\u0000 \u0096\u0001\u0000\u0000\u0000\"\u009e\u0001\u0000\u0000"+
		"\u0000$\u00b0\u0001\u0000\u0000\u0000&\'\u0005\u0001\u0000\u0000\'(\u0005"+
		"*\u0000\u0000()\u0005&\u0000\u0000)*\u0005\'\u0000\u0000*+\u0003\u0002"+
		"\u0001\u0000+,\u0005\u0004\u0000\u0000,-\u0005\u0000\u0000\u0001-\u0001"+
		"\u0001\u0000\u0000\u0000./\u0005\u0002\u0000\u0000/0\u0003\n\u0005\u0000"+
		"01\u0005\u0003\u0000\u00001\u0003\u0001\u0000\u0000\u000024\u0003\u0006"+
		"\u0003\u000032\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u000053\u0001"+
		"\u0000\u0000\u000056\u0001\u0000\u0000\u00006\u0005\u0001\u0000\u0000"+
		"\u000078\u0003\b\u0004\u00008;\u0005*\u0000\u00009:\u0005!\u0000\u0000"+
		":<\u0003\u001a\r\u0000;9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000"+
		"<=\u0001\u0000\u0000\u0000=>\u0005(\u0000\u0000>\u0007\u0001\u0000\u0000"+
		"\u0000?@\u0007\u0000\u0000\u0000@\t\u0001\u0000\u0000\u0000AD\u0003\u0006"+
		"\u0003\u0000BD\u0003\f\u0006\u0000CA\u0001\u0000\u0000\u0000CB\u0001\u0000"+
		"\u0000\u0000DE\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000EF\u0001"+
		"\u0000\u0000\u0000F\u000b\u0001\u0000\u0000\u0000GH\u0003\u000e\u0007"+
		"\u0000HI\u0005(\u0000\u0000IQ\u0001\u0000\u0000\u0000JQ\u0003\u0010\b"+
		"\u0000KQ\u0003\u0012\t\u0000LQ\u0003\u0014\n\u0000MN\u0003\u0016\u000b"+
		"\u0000NO\u0005(\u0000\u0000OQ\u0001\u0000\u0000\u0000PG\u0001\u0000\u0000"+
		"\u0000PJ\u0001\u0000\u0000\u0000PK\u0001\u0000\u0000\u0000PL\u0001\u0000"+
		"\u0000\u0000PM\u0001\u0000\u0000\u0000Q\r\u0001\u0000\u0000\u0000RS\u0005"+
		"*\u0000\u0000ST\u0005!\u0000\u0000TU\u0003\u001a\r\u0000U\u000f\u0001"+
		"\u0000\u0000\u0000VW\u0005\u0005\u0000\u0000WX\u0005&\u0000\u0000XY\u0003"+
		"\u001a\r\u0000YZ\u0005\'\u0000\u0000Z[\u0005\u0006\u0000\u0000[^\u0003"+
		"\u0018\f\u0000\\]\u0005\u0007\u0000\u0000]_\u0003\u0018\f\u0000^\\\u0001"+
		"\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_\u0011\u0001\u0000\u0000"+
		"\u0000`a\u0005\b\u0000\u0000ab\u0005&\u0000\u0000bc\u0003\u001a\r\u0000"+
		"cd\u0005\'\u0000\u0000de\u0005\t\u0000\u0000ef\u0003\u0018\f\u0000fg\u0005"+
		"\n\u0000\u0000g\u0013\u0001\u0000\u0000\u0000hi\u0005\u000b\u0000\u0000"+
		"ij\u0005*\u0000\u0000jk\u0005\f\u0000\u0000kl\u0003\u001a\r\u0000lm\u0005"+
		"\r\u0000\u0000mn\u0003\u001a\r\u0000no\u0005\u000e\u0000\u0000op\u0003"+
		"\u001a\r\u0000pq\u0005\t\u0000\u0000qr\u0003\u0018\f\u0000rs\u0005\u000f"+
		"\u0000\u0000s\u0015\u0001\u0000\u0000\u0000tu\u0005\u0010\u0000\u0000"+
		"uv\u0005&\u0000\u0000v{\u0003\u001a\r\u0000wx\u0005)\u0000\u0000xz\u0003"+
		"\u001a\r\u0000yw\u0001\u0000\u0000\u0000z}\u0001\u0000\u0000\u0000{y\u0001"+
		"\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|~\u0001\u0000\u0000\u0000"+
		"}{\u0001\u0000\u0000\u0000~\u007f\u0005\'\u0000\u0000\u007f\u0017\u0001"+
		"\u0000\u0000\u0000\u0080\u0081\u0005\u0002\u0000\u0000\u0081\u0082\u0003"+
		"\n\u0005\u0000\u0082\u0083\u0005\u0003\u0000\u0000\u0083\u0019\u0001\u0000"+
		"\u0000\u0000\u0084\u0085\u0003\u001c\u000e\u0000\u0085\u001b\u0001\u0000"+
		"\u0000\u0000\u0086\u008b\u0003\u001e\u000f\u0000\u0087\u0088\u0007\u0001"+
		"\u0000\u0000\u0088\u008a\u0003\u001e\u000f\u0000\u0089\u0087\u0001\u0000"+
		"\u0000\u0000\u008a\u008d\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000"+
		"\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u001d\u0001\u0000"+
		"\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008e\u0093\u0003 \u0010"+
		"\u0000\u008f\u0090\u0007\u0002\u0000\u0000\u0090\u0092\u0003 \u0010\u0000"+
		"\u0091\u008f\u0001\u0000\u0000\u0000\u0092\u0095\u0001\u0000\u0000\u0000"+
		"\u0093\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000"+
		"\u0094\u001f\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000"+
		"\u0096\u009b\u0003\"\u0011\u0000\u0097\u0098\u0007\u0003\u0000\u0000\u0098"+
		"\u009a\u0003\"\u0011\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u009a\u009d"+
		"\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009b\u009c"+
		"\u0001\u0000\u0000\u0000\u009c!\u0001\u0000\u0000\u0000\u009d\u009b\u0001"+
		"\u0000\u0000\u0000\u009e\u00a3\u0003$\u0012\u0000\u009f\u00a0\u0007\u0004"+
		"\u0000\u0000\u00a0\u00a2\u0003$\u0012\u0000\u00a1\u009f\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a5\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000"+
		"\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4#\u0001\u0000\u0000\u0000"+
		"\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005&\u0000\u0000\u00a7"+
		"\u00a8\u0003\u001a\r\u0000\u00a8\u00a9\u0005\'\u0000\u0000\u00a9\u00b1"+
		"\u0001\u0000\u0000\u0000\u00aa\u00ab\u0005\u0013\u0000\u0000\u00ab\u00b1"+
		"\u0003$\u0012\u0000\u00ac\u00b1\u0005\u0018\u0000\u0000\u00ad\u00b1\u0005"+
		"\u0019\u0000\u0000\u00ae\u00b1\u0005\u001a\u0000\u0000\u00af\u00b1\u0005"+
		"*\u0000\u0000\u00b0\u00a6\u0001\u0000\u0000\u0000\u00b0\u00aa\u0001\u0000"+
		"\u0000\u0000\u00b0\u00ac\u0001\u0000\u0000\u0000\u00b0\u00ad\u0001\u0000"+
		"\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b0\u00af\u0001\u0000"+
		"\u0000\u0000\u00b1%\u0001\u0000\u0000\u0000\f5;CEP^{\u008b\u0093\u009b"+
		"\u00a3\u00b0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
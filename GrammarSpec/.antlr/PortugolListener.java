// Generated from c:/Users/pedro/Downloads/PortugolDemo/GrammarSpec/Portugol.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PortugolParser}.
 */
public interface PortugolListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PortugolParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(PortugolParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(PortugolParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#blocoPrincipal}.
	 * @param ctx the parse tree
	 */
	void enterBlocoPrincipal(PortugolParser.BlocoPrincipalContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#blocoPrincipal}.
	 * @param ctx the parse tree
	 */
	void exitBlocoPrincipal(PortugolParser.BlocoPrincipalContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracoes(PortugolParser.DeclaracoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracoes(PortugolParser.DeclaracoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao(PortugolParser.DeclaracaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao(PortugolParser.DeclaracaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(PortugolParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(PortugolParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#comandos}.
	 * @param ctx the parse tree
	 */
	void enterComandos(PortugolParser.ComandosContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#comandos}.
	 * @param ctx the parse tree
	 */
	void exitComandos(PortugolParser.ComandosContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterComando(PortugolParser.ComandoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitComando(PortugolParser.ComandoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void enterAtribuicao(PortugolParser.AtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void exitAtribuicao(PortugolParser.AtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#comandoCondicional}.
	 * @param ctx the parse tree
	 */
	void enterComandoCondicional(PortugolParser.ComandoCondicionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#comandoCondicional}.
	 * @param ctx the parse tree
	 */
	void exitComandoCondicional(PortugolParser.ComandoCondicionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#comandoEnquanto}.
	 * @param ctx the parse tree
	 */
	void enterComandoEnquanto(PortugolParser.ComandoEnquantoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#comandoEnquanto}.
	 * @param ctx the parse tree
	 */
	void exitComandoEnquanto(PortugolParser.ComandoEnquantoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#comandoPara}.
	 * @param ctx the parse tree
	 */
	void enterComandoPara(PortugolParser.ComandoParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#comandoPara}.
	 * @param ctx the parse tree
	 */
	void exitComandoPara(PortugolParser.ComandoParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#comandoSaida}.
	 * @param ctx the parse tree
	 */
	void enterComandoSaida(PortugolParser.ComandoSaidaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#comandoSaida}.
	 * @param ctx the parse tree
	 */
	void exitComandoSaida(PortugolParser.ComandoSaidaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#blocoComandos}.
	 * @param ctx the parse tree
	 */
	void enterBlocoComandos(PortugolParser.BlocoComandosContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#blocoComandos}.
	 * @param ctx the parse tree
	 */
	void exitBlocoComandos(PortugolParser.BlocoComandosContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(PortugolParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(PortugolParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#exprLogica}.
	 * @param ctx the parse tree
	 */
	void enterExprLogica(PortugolParser.ExprLogicaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#exprLogica}.
	 * @param ctx the parse tree
	 */
	void exitExprLogica(PortugolParser.ExprLogicaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#exprRelacional}.
	 * @param ctx the parse tree
	 */
	void enterExprRelacional(PortugolParser.ExprRelacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#exprRelacional}.
	 * @param ctx the parse tree
	 */
	void exitExprRelacional(PortugolParser.ExprRelacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#exprAritmetica}.
	 * @param ctx the parse tree
	 */
	void enterExprAritmetica(PortugolParser.ExprAritmeticaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#exprAritmetica}.
	 * @param ctx the parse tree
	 */
	void exitExprAritmetica(PortugolParser.ExprAritmeticaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(PortugolParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(PortugolParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subExpr}
	 * labeled alternative in {@link PortugolParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterSubExpr(PortugolParser.SubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subExpr}
	 * labeled alternative in {@link PortugolParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitSubExpr(PortugolParser.SubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negacao}
	 * labeled alternative in {@link PortugolParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterNegacao(PortugolParser.NegacaoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negacao}
	 * labeled alternative in {@link PortugolParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitNegacao(PortugolParser.NegacaoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleano}
	 * labeled alternative in {@link PortugolParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterBooleano(PortugolParser.BooleanoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleano}
	 * labeled alternative in {@link PortugolParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitBooleano(PortugolParser.BooleanoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numero}
	 * labeled alternative in {@link PortugolParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterNumero(PortugolParser.NumeroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numero}
	 * labeled alternative in {@link PortugolParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitNumero(PortugolParser.NumeroContext ctx);
	/**
	 * Enter a parse tree produced by the {@code textoLiteral}
	 * labeled alternative in {@link PortugolParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterTextoLiteral(PortugolParser.TextoLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code textoLiteral}
	 * labeled alternative in {@link PortugolParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitTextoLiteral(PortugolParser.TextoLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identificador}
	 * labeled alternative in {@link PortugolParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterIdentificador(PortugolParser.IdentificadorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identificador}
	 * labeled alternative in {@link PortugolParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitIdentificador(PortugolParser.IdentificadorContext ctx);
}
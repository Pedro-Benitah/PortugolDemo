grammar Portugol;

// Parser

// Permite 0+ funções/procedimentos ANTES da main.
programa
    : (declaracaoFuncao | declaracaoProcedimento)* 
      PROGRAMA ID LPAREN RPAREN blocoPrincipal FIMPROGRAMA EOF
    ;

// Bloco principal da main
blocoPrincipal
    : INICIO comandos FIM
    ;

// Bloco genérico (usado em if/while/for/funções/procedimentos)
bloco
    : INICIO comandos FIM
    ;

// Lista de comandos dentro de um bloco
comandos
    : comando*
    ;

// Declarações de topo

// função com tipo de retorno
declaracaoFuncao
    : tipo ID LPAREN listaParams? RPAREN bloco
    ;

// procedimento (sem retorno)
declaracaoProcedimento
    : PROCEDIMENTO ID LPAREN listaParams? RPAREN bloco
    ;

// parâmetros
listaParams
    : param (COMMA param)*
    ;

param
    : tipo ID
    ;

// tipos básicos
tipo
    : INTEIRO
    | REAL
    | LOGICO
    | TEXTO
    ;

// Comandos
comando
    : declaracaoVar SEMI
    | atribuicao     SEMI
    | chamadaProc    SEMI
    | comandoCondicional
    | comandoEnquanto
    | comandoPara
    | comandoDoEnquanto
    | comandoRetorne
    ;

// Declaração de variável (com ou sem inicialização)
declaracaoVar
    : tipo ID (EQUAL expr)?
    ;

// x = expr
atribuicao
    : ID EQUAL expr
    ;

// chamada como comando
chamadaProc
    : ESCREVA LPAREN listaArgs? RPAREN     #chamadaEscreva
    | ID LPAREN listaArgs? RPAREN          #chamadaGenerica
    ;

// retorne
comandoRetorne
    : RETORNE expr? SEMI
    ;

// se (cond) entao bloco (senao bloco)?
comandoCondicional
    : SE LPAREN expr RPAREN ENTAO bloco (SENAO bloco)?
    ;

// enquanto (cond) faca bloco fimEnquanto
comandoEnquanto
    : ENQUANTO LPAREN expr RPAREN FACA bloco FIMENQUANTO
    ;

// do/while (opcional, caso use)
comandoDoEnquanto
    : FACA bloco ENQUANTO LPAREN expr RPAREN SEMI
    ;

// para i de a ate b passo p faca bloco fimPara
comandoPara
    : PARA ID DE expr ATE expr PASSO expr FACA bloco FIMPARA
    ;

// argumentos de chamadas
listaArgs
    : expr (COMMA expr)*
    ;

// Expressões
// 1) OU
expr
    : expr OU expr            #OrExpr
    | expr E  expr            #AndExpr
    | relacao                 #RelExpr
    ;

// 2) Relações: < <= > >= == !=
relacao
    : soma ( (LT|LE|GT|GE|EQ|NE) soma )*
    ;

// 3) Soma/Sub
soma
    : termo ( (PLUS|MINUS) termo )*
    ;

// 4) Mul/Div/Mod
termo
    : un ( (STAR|SLASH|PERCENT) un )*
    ;

// 5) Unários: nao, -, + (unário)
un
    : NAO un                       #NotExpr
    | MINUS un                     #NegExpr
    | PLUS  un                     #PosExpr
    | prim                         #PrimExpr
    ;

// 6) Primários: literais, id, chamada com valor, (expr)
prim
    : LPAREN expr RPAREN
    | BOOL_LITERAL
    | NUM_LITERAL
    | STRING_LITERAL
    | chamadaFunc                 // ID(...)
    | ID                          // variável
    ;

// chamada que produz valor (usada em expr)
chamadaFunc
    : ID LPAREN listaArgs? RPAREN
    ;

// Lexer rules (tokens)

// Palavras-chave / símbolos
PROGRAMA     : 'programa';
FIMPROGRAMA  : 'fimPrograma';
INICIO       : 'inicio';
FIM          : 'fim';

INTEIRO      : 'inteiro';
REAL         : 'real';
LOGICO       : 'logico';
TEXTO        : 'texto';

SE           : 'se';
ENTAO        : 'entao';
SENAO        : 'senao';

ENQUANTO     : 'enquanto';
FACA         : 'faca';
FIMENQUANTO  : 'fimEnquanto';

PARA         : 'para';
DE           : 'de';
ATE          : 'ate';
PASSO        : 'passo';
FIMPARA      : 'fimPara';

ESCREVA      : 'escreva';

PROCEDIMENTO : 'procedimento';
RETORNE      : 'retorne';

E            : 'e';
OU           : 'ou';
NAO          : 'nao';

// Operadores e pontuação
LPAREN  : '(';
RPAREN  : ')';
COMMA   : ',';
SEMI    : ';';
EQUAL   : '=';
PLUS    : '+';
MINUS   : '-';
STAR    : '*';
SLASH   : '/';
PERCENT : '%';

LT : '<';
LE : '<=';
GT : '>';
GE : '>=';
EQ : '==';
NE : '!=';

// Literais
BOOL_LITERAL : 'verdadeiro' | 'falso';

// Números (inteiro ou real)
NUM_LITERAL
    : DIGITOS ('.' DIGITOS)?
    ;

// String entre aspas, com escape simples
STRING_LITERAL
    : '"' ( '\\' . | ~["\\\r\n] )* '"'
    ;

// Identificadores
ID
    : LETRA (LETRA | DIGITO)*
    ;

// Espaços e comentários
WS : [ \t\r\n]+ -> skip ;

COMMENT       : '//' ~[\r\n]*      -> skip ;
BLOCK_COMMENT : '/*' .*? '*/'      -> skip ;

// Fragments
fragment LETRA  : [a-zA-Z_] ;
fragment DIGITO : [0-9] ;
fragment DIGITOS: DIGITO+ ;

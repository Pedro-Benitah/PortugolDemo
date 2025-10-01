grammar Portugol;

// Parser

// programa <nome>() inicio ... fim fimPrograma
programa
    : PROGRAMA ID LPAREN RPAREN blocoPrincipal FIMPROGRAMA EOF
    ;

// bloco principal do programa
blocoPrincipal
    : INICIO comandos FIM
    ;

// sequência de declarações (uma ou mais)
declaracoes
    : declaracao+
    ;

// declaração de variável com tipo e opcional inicialização
declaracao
    : tipo ID (EQUAL expr)? SEMI
    ;

// tipos primitivos
tipo
    : INTEIRO
    | REAL
    | LOGICO
    | TEXTO
    ;

// uma ou mais instruções
comandos
    : (declaracao | comando)+
    ;

// diferentes formas de comando
comando
    : atribuicao SEMI
    | comandoCondicional
    | comandoEnquanto
    | comandoPara
    | comandoSaida SEMI
    ;

// x = expr
atribuicao
    : ID EQUAL expr
    ;

// se (cond) entao ... (senao ...)?
comandoCondicional
    : SE LPAREN expr RPAREN ENTAO blocoComandos (SENAO blocoComandos)?
    ;

// enquanto (cond) faca ... fimEnquanto
comandoEnquanto
    : ENQUANTO LPAREN expr RPAREN FACA blocoComandos FIMENQUANTO
    ;

// para i de a ate b passo p faca ... fimPara
comandoPara
    : PARA ID DE expr ATE expr PASSO expr FACA blocoComandos FIMPARA
    ;

// escreva(expr, expr, ...)
comandoSaida
    : ESCREVA LPAREN expr (COMMA expr)* RPAREN
    ;

// bloco aninhado
blocoComandos
    : INICIO comandos FIM
    ;

// Expressões

expr
    : exprLogica
    ;

// lógica: e / ou
exprLogica
    : exprRelacional ((E | OU) exprRelacional)*
    ;

// relacionais: > < >= <= == !=
exprRelacional
    : exprAritmetica ((GT | LT | GE | LE | EQEQ | NEQ) exprAritmetica)*
    ;

// soma/subtração
exprAritmetica
    : termo ((PLUS | MINUS) termo)*
    ;

// multiplicação/divisão
termo
    : fator ((MULT | DIV) fator)*
    ;

// fatores e negação
fator
    : LPAREN expr RPAREN          # subExpr
    | NAO fator                   # negacao
    | BOOL_LITERAL                # booleano
    | NUM_LITERAL                 # numero
    | STRING_LITERAL              # textoLiteral
    | ID                          # identificador
    ;

// Lexer

// --- palavras‑chave ---
PROGRAMA   : 'programa';
INICIO     : 'inicio';
FIM        : 'fim';
FIMPROGRAMA: 'fimPrograma';

SE         : 'se';
ENTAO      : 'entao';
SENAO      : 'senao';

ENQUANTO   : 'enquanto';
FACA       : 'faca';
FIMENQUANTO: 'fimEnquanto';

PARA       : 'para';
DE         : 'de';
ATE        : 'ate';
PASSO      : 'passo';
FIMPARA    : 'fimPara';

ESCREVA    : 'escreva';

E          : 'e';
OU         : 'ou';
NAO        : 'nao';

INTEIRO    : 'inteiro';
REAL       : 'real';
LOGICO     : 'logico';
TEXTO      : 'texto';

// --- literais ---
BOOL_LITERAL
    : 'verdadeiro'
    | 'falso'
    ;
NUM_LITERAL
    : DIGITO+ ('.' DIGITO+)?
    ;
STRING_LITERAL
    : '"' ( ~["\\] | '\\' . )* '"'
    ;

// --- operadores e pontuação ---
EQEQ  : '==';
NEQ   : '!=';
GE    : '>=';
LE    : '<=';

GT    : '>';
LT    : '<';

EQUAL : '=';

PLUS  : '+';
MINUS : '-';
MULT  : '*';
DIV   : '/';

LPAREN: '(';
RPAREN: ')';
SEMI  : ';';
COMMA : ',';

// --- identificadores ---
ID
    : LETRA (LETRA | DIGITO)*
    ;

// --- espaços e comentários ---
WS : [ \t\r\n]+ -> skip ;

COMMENT       : '//' ~[\r\n]*       -> skip ;
BLOCK_COMMENT : '/*' .*? '*/'      -> skip ;

// --- fragments ---
fragment LETRA  : [a-zA-Z_] ;
fragment DIGITO : [0-9]     ;

inteiro soma(inteiro x, inteiro y)
inicio
    retorne x + y;
fim

real media(real x, real y)
inicio
    retorne (x + y) / 2;
fim

logico ehPar(inteiro n)
inicio
    retorne (n % 2) == 0;
fim

procedimento titulo(texto t)
inicio
    escreva("== ", t, " ==");
fim

procedimento logInt(texto nome, inteiro valor)
inicio
    escreva(nome, "=", valor);
fim

procedimento logReal(texto nome, real valor)
inicio
    escreva(nome, "=", valor);
fim

procedimento logTexto(texto nome, texto valor)
inicio
    escreva(nome, "=", valor);
fim

procedimento logLogico(texto nome, logico valor)
inicio
    escreva(nome, "=", valor);
fim


programa main()
inicio
    titulo("====Teste====");

    // declarações básicas
    inteiro a = 10;
    real b = 2.5;
    logico flag = falso;
    texto msg = "Teste";

    // equações matemáticas
    inteiro c = soma(a, 5) * 2;
    real d = (a - 3) / b;

    // regras lógicas e relacionais
    flag = (a > 5 e b < 3.0) ou nao falso;

    // bloco condicional if/else
    se (a >= 10 e b <= 2.5) entao
    inicio
        escreva("condicao 1: ok");
    fim
    senao
    inicio
        escreva("condicao 1: falhou");
    fim

    // laço while
    inteiro i = 0;
    enquanto (i < 3) faca
    inicio
        escreva("while i=", i, ", ehPar=", ehPar(i));
        i = i + 1;
    fim
    fimEnquanto

    // laço for
    para i de 0 ate 2 passo 1 faca
    inicio
        escreva("for i=", i);
    fim
    fimPara

    // chamada de procedimentos auxiliares de log
    logInt("a", a);
    logReal("b", b);
    logInt("c", c);
    logReal("d", d);
    logLogico("flag", flag);
    logTexto("msg", msg);

    // saída final com vários argumentos numa única linha
    escreva("a=", a, ", b=", b, ", c=", c, ", d=", d, ", flag=", flag, ", msg=", msg);
fim
fimPrograma

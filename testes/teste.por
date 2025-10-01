programa main()
inicio
    inteiro a = 10;
    real b = 2.5;
    logico flag = falso;
    texto msg = "Demo ANTLR";

    // equações matemáticas
    inteiro c = a + 5 * 2;
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
        escreva("while i=", i);
        i = i + 1;
    fim
    fimEnquanto

    // laço for
    para i de 0 ate 2 passo 1 faca
    inicio
        escreva("for i=", i);
    fim
    fimPara

    // saída final com vários argumentos
    escreva("a=", a, ", b=", b, ", c=", c, ", d=", d, ", flag=", flag, ", msg=", msg);
fim
fimPrograma

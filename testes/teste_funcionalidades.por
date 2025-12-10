// Teste completo de recursos Portugol

programa exercicios()
inicio
    // Teste 1: Declaração de variáveis
    inteiro numero = 42;
    real valor = 3.14;
    logico ativo = verdadeiro;
    texto mensagem = "Olá, Mundo!";
    
    // Teste 2: Operações matemáticas com precedência
    inteiro resultado1 = 10 + 5 * 2;      // 20
    inteiro resultado2 = (10 + 5) * 2;    // 30
    real valor_real = 100.5 / 2;          // 50.25
    inteiro modulo = 10 % 3;              // 1
    
    // Teste 3: Expressões lógicas
    logico teste1 = verdadeiro e verdadeiro;
    logico teste2 = falso ou verdadeiro;
    logico teste3 = nao falso;
    logico teste4 = (numero > 40) e (numero < 50);
    
    // Teste 4: Condicional if/else
    se (numero > 0) entao
    inicio
        escreva("Número positivo");
    fim
    senao
    inicio
        escreva("Número não-positivo");
    fim
    
    // Teste 5: Comparações relacionais
    logico comp1 = numero == 42;
    logico comp2 = valor != 3.14;
    logico comp3 = numero >= 40;
    logico comp4 = numero <= 50;
    
    // Teste 6: Laço while
    inteiro contador = 0;
    enquanto (contador < 3) faca
    inicio
        escreva("While: ", contador);
        contador = contador + 1;
    fim
    fimEnquanto
    
    // Teste 7: Laço for
    inteiro i = 1;
    para i de 1 ate 5 passo 1 faca
    inicio
        escreva("For: ", i);
    fim
    fimPara
    
fim
fimPrograma

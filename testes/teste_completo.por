// Programa demonstrando todos os recursos da linguagem Portugol
// Analisador Léxico Puro + Parser LL(1)

programa demonstracao()
inicio
    // Declaração de variáveis de diferentes tipos
    inteiro idade = 25;
    real salario = 3500.50;
    logico ativo = verdadeiro;
    texto nome = "João Silva";
    
    // Expressões matemáticas com precedência
    inteiro resultado = 10 + 5 * 2;      // 20 (não 30)
    real media = (10.5 + 20.3) / 2;     // 15.4
    
    // Expressões lógicas
    logico condicao = (idade >= 18) e (salario > 3000);
    logico negacao = nao falso;
    logico ou_logico = verdadeiro ou falso;
    
    // Condicional if/else
    se (idade >= 18) entao
    inicio
        escreva("Maior de idade");
    fim
    senao
    inicio
        escreva("Menor de idade");
    fim
    
    // Laço while
    inteiro contador = 0;
    enquanto (contador < 3) faca
    inicio
        escreva("Contador: ", contador);
        contador = contador + 1;
    fim
    fimEnquanto;
    
    // Laço for
    inteiro i = 1;
    para i de 1 ate 5 passo 1 faca
    inicio
        escreva("Iteração: ", i);
    fim
    fimPara;
    
    // Expressões complexas
    inteiro operacao = 100 - 20 * 2 + 10 / 2;
    
fim
fimPrograma

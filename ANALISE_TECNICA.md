# Analisador Léxico e Sintático LL(1) - Linguagem Portugol

## Visão Geral

Este projeto implementa um **analisador léxico puro** (sem dependências de Flex) e um **analisador sintático LL(1)** completo para a linguagem Portugol, uma linguagem de programação em português desenvolvida para fins educacionais.

## 1. Análise Léxica

### 1.1 Implementação Pura

O analisador léxico está implementado na classe `LexicalAnalyzer` no arquivo `Program.cs` sem uso de ferramentas externas como Flex.

### 1.2 Lexemas e Classes de Tokens

A análise léxica identifica os seguintes tipos de tokens:

**Palavras-chave:**
- Controle de programa: `programa`, `fimPrograma`, `inicio`, `fim`
- Tipos de dados: `inteiro`, `real`, `logico`, `texto`
- Controle de fluxo: `se`, `entao`, `senao`, `enquanto`, `faca`, `fimenquanto`, `para`, `de`, `ate`, `passo`, `fimpara`
- Procedimentos: `procedimento`, `retorne`, `escreva`
- Operadores lógicos: `e`, `ou`, `nao`

**Operadores e Símbolos:**
- Aritméticos: `+`, `-`, `*`, `/`, `%`
- Relacionais: `<`, `<=`, `>`, `>=`, `==`, `!=`
- Atribuição: `=`
- Delimitadores: `(`, `)`, `,`, `;`

**Literais:**
- Números: `NUM_LITERAL` - Inteiros e decimais (ex: `123`, `3.14`)
- Strings: `STRING_LITERAL` - Texto entre aspas (ex: `"Hello"`)
- Booleanos: `BOOL_LITERAL` - `verdadeiro` ou `falso`
- Identificadores: `ID` - Nomes de variáveis e funções

### 1.3 Expressões Regulares Aplicadas

Exemplos de expressões regulares utilizadas:

```csharp
// Identificadores: Começam com letra ou underscore, seguidos de letras, dígitos ou underscores
{ TokenType.ID, @"^[a-zA-Z_][a-zA-Z0-9_]*" }

// Números: Inteiros ou decimais
{ TokenType.NUM_LITERAL, @"^\d+(\.\d+)?" }

// Strings: Texto entre aspas com escape de caracteres
{ TokenType.STRING_LITERAL, @"""([^""\\]|\\.)*""" }

// Booleanos: Específico (verdadeiro ou falso)
{ TokenType.BOOL_LITERAL, @"^(verdadeiro|falso)$" }
```

### 1.4 Cadeia de Tokens

A análise léxica produz uma cadeia de tokens que é consumida pelo analisador sintático. Exemplo de saída para `inteiro x = 10;`:

```
INTEIRO | inteiro   | Linha 1
ID      | x         | Linha 1
EQUAL   | =         | Linha 1
NUM     | 10        | Linha 1
SEMI    | ;         | Linha 1
EOF     | (vazio)   | Linha 1
```

## 2. Análise Sintática LL(1)

### 2.1 Gramática Livre de Contexto (GLC)

A gramática base foi transformada para estar em formato LL(1) seguindo os procedimentos requeridos:

#### 2.1.1 Eliminação de Ambiguidade

Ambiguidades foram removidas através da estruturação clara das produções:
- Separação clara entre tipos de comandos
- Definição explícita de operadores unários vs. binários

#### 2.1.2 Associatividade e Precedência

A precedência e associatividade foram implementadas através de produções aninhadas:

```
expr     → exprOu
exprOu   → exprE (OU exprE)*          // Menor precedência
exprE    → exprNao (E exprNao)*
exprNao  → NAO exprNao | exprRel
exprRel  → exprAd ((EQ|NE|LT|LE|GT|GE) exprAd)*
exprAd   → exprMul ((PLUS|MINUS) exprMul)*
exprMul  → exprUn ((STAR|SLASH|PERCENT) exprUn)* // Maior precedência
exprUn   → (MINUS|NAO)? exprPri
exprPri  → ID | NUM_LITERAL | STRING_LITERAL | BOOL_LITERAL | LPAREN expr RPAREN
```

Esta estrutura garante:
- Operadores lógicos (OU) têm menor precedência
- Operadores relacionais (EQ, NE, etc.) têm precedência média
- Operadores aritméticos (PLUS, MINUS) têm precedência média-alta
- Operadores multiplicativos (STAR, SLASH, PERCENT) têm maior precedência
- Operadores unários (MINUS, NAO) têm precedência máxima

#### 2.1.3 Eliminação de Recursão à Esquerda

A recursão à esquerda foi eliminada usando a técnica de transformação:

**Original (com recursão à esquerda):**
```
exprAd → exprAd PLUS exprMul | exprMul
```

**Transformado (sem recursão à esquerda):**
```
exprAd     → exprMul exprAdRest
exprAdRest → PLUS exprMul exprAdRest | ε
```

#### 2.1.4 Fatoração

A fatoração foi aplicada para remover conflitos LL(1):

**Original (não-fatorado):**
```
comando → declaracao | atribuicao
declaracao → tipo ID EQUAL expr
atribuicao → ID EQUAL expr
```

**Fatorado:**
```
comando → declaracao | atribuicao | ...
```

Usamos look-ahead para distinguir os comandos baseado no primeiro token.

### 2.2 Conjuntos FIRST e FOLLOW

#### 2.2.1 Cálculo de FIRST

O método `ComputeFIRST()` calcula o conjunto de primeiros terminais que podem iniciar uma derivação:

Exemplos:
- `FIRST(programa)` = {PROGRAMA}
- `FIRST(tipo)` = {INTEIRO, REAL, LOGICO, TEXTO}
- `FIRST(expr)` = {ID, NUM_LITERAL, STRING_LITERAL, BOOL_LITERAL, LPAREN, MINUS, NAO}
- `FIRST(comando)` = {INTEIRO, REAL, LOGICO, TEXTO, ID, SE, ENQUANTO, PARA, ESCREVA, RETORNE}

#### 2.2.2 Cálculo de FOLLOW

O método `ComputeFOLLOW()` calcula o conjunto de terminais que podem seguir um não-terminal na derivação.

Exemplos:
- `FOLLOW(programa)` = {EOF}
- `FOLLOW(tipo)` = {ID}
- `FOLLOW(expr)` = {SEMI, RPAREN, COMMA, ENTAO, FACA, ATE, PASSO, DE, EQ, NE, LT, LE, GT, GE, PLUS, MINUS, STAR, SLASH, PERCENT, E, OU, ...}

### 2.3 Tabela de Análise Sintática LL(1)

A tabela LL(1) mapeia pares `(não-terminal, terminal de look-ahead)` para produções.

Exemplos de entradas da tabela:

```
M[programa, PROGRAMA]        → PROGRAMA ID LPAREN RPAREN blocoPrincipal FIMPROGRAMA
M[comando, INTEIRO]          → declaracao
M[comando, ID]               → atribuicao
M[comando, SE]               → condicional
M[exprAd, ID]               → exprMul exprAdRest
M[exprAdRest, PLUS]         → PLUS exprMul exprAdRest
M[exprAdRest, SEMI]         → ε
```

### 2.4 Algoritmo de Análise com Pilha LL(1)

O parser implementa o algoritmo de pilha LL(1) com as seguintes operações:

**Entrada:** Cadeia de tokens + EOF
**Pilha inicial:** [EOF, programa]

**Algoritmo:**

```
while pilha.Count > 0 do
    X ← pilha.pop()
    a ← lookahead (token atual)
    
    if X é terminal then
        if X == a then
            advance (próximo token)
        else
            ERRO
    else (X é não-terminal)
        if M[X, a] existe then
            pilha.push(M[X, a] em ordem reversa)
        else
            ERRO
```

**Operação MATCH:**
- Quando o elemento no topo da pilha é um terminal e coincide com o token de entrada, o elemento é removido da pilha e avanços para o próximo token.

**Exemplo de execução:**

```
Pilha: [EOF, programa]
Token: PROGRAMA

=> Match PROGRAMA

Pilha: [EOF, ID]
Token: ID (main)

=> Match ID

...continua...
```

## 3. Funcionalidades Reconhecidas

O analisador reconhece e valida:

- ✓ **Declaração de variáveis:** `inteiro x = 10;`
- ✓ **Tipos de dados:** `inteiro`, `real`, `logico`, `texto`
- ✓ **Bloco de execução principal:** `programa main() ... fimPrograma`
- ✓ **Blocos condicionais:** `se (condicao) entao ... senao ... fim`
- ✓ **Equações matemáticas:** `c = a + b * 2;`
- ✓ **Regras lógicas:** `(a > 5) e (b < 3)` com operadores `e`, `ou`, `nao`
- ✓ **Laços:** `enquanto (i < 10) faca ... fimEnquanto`
- ✓ **Laços for:** `para i de 1 ate 10 passo 1 faca ... fimPara`
- ✓ **Saída:** `escreva("texto", variavel);`
- ✓ **Expressões complexas:** Com precedência e associatividade corretas

## 4. Compilação e Execução

### 4.1 Pré-requisitos
- .NET 8.0 SDK

### 4.2 Compilação

```bash
dotnet build
```

### 4.3 Execução - Análise Léxica

```bash
dotnet run --tokens -- teste.por
```

Saída: Lista de tokens com tipo, lexema e número da linha

### 4.4 Execução - Análise Sintática

```bash
dotnet run -- teste.por
```

Saída: Derivações e MATCHes realizados, ou erro sintático detalhado

### 4.5 Leitura de STDIN

```bash
dotnet run --
```

(Digitar código, pressionar Ctrl+Z, Enter para Windows)

## 5. Estrutura do Código

### Program.cs

- **Classe `Program`:** Função main e orquestração
- **Classe `LexicalAnalyzer`:** Implementação da análise léxica pura
  - `TokenType`: Enum de tipos de token
  - `Token`: Classe representando um token
  - `Analyze()`: Método principal de análise léxica
  - `GetNextToken()`: Método que extrai o próximo token
- **Classe `LL1Parser`:** Implementação do parser LL(1)
  - `InitializeGrammar()`: Define terminais e não-terminais
  - `ComputeFIRST()`: Calcula conjuntos FIRST
  - `ComputeFOLLOW()`: Calcula conjuntos FOLLOW
  - `BuildParseTable()`: Constrói a tabela LL(1)
  - `AddProduction()`: Adiciona produções à tabela
  - `Parse()`: Executa o algoritmo de pilha LL(1)

### Interpreter.cs

- Código anterior para futura interpretação do AST (não usado na análise)

## 6. Exemplos de Uso

### Exemplo 1: Declaração e Expressão Matemática

```portugol
programa teste()
inicio
    inteiro a = 10;
    inteiro b = 5;
    inteiro c = a + b;
    escreva(c);
fim
fimPrograma
```

### Exemplo 2: Condicional

```portugol
programa verificar()
inicio
    inteiro idade = 18;
    se (idade >= 18) entao
    inicio
        escreva("Maior de idade");
    fim
    senao
    inicio
        escreva("Menor de idade");
    fim
fim
fimPrograma
```

### Exemplo 3: Laço

```portugol
programa contagem()
inicio
    inteiro i = 0;
    enquanto (i < 5) faca
    inicio
        escreva(i);
        i = i + 1;
    fim
    fimEnquanto
fim
fimPrograma
```

### Exemplo 4: Expressões com Operadores Lógicos

```portugol
programa logica()
inicio
    logico resultado = verdadeiro e falso ou verdadeiro;
    inteiro x = 10;
    logico condicao = (x > 5) e (x < 20) ou nao falso;
fim
fimPrograma
```

## 7. Tratamento de Erros

O analisador fornece mensagens de erro detalhadas:

```
✗ Erro: Erro sintático linha 3: esperado 'EQUAL' mas encontrou 'SEMI'
```

Indicando:
- Tipo de erro (sintático)
- Linha do erro
- Token esperado vs. token encontrado

## 8. Validações Implementadas

- ✓ Verificação de tokens válidos
- ✓ Verificação de syntax conforme gramática LL(1)
- ✓ Detecção de identificadores vs. palavras-chave
- ✓ Tratamento de comentários (//)
- ✓ Tratamento de espaços em branco e quebras de linha

## 9. Trabalhos Futuros

- Implementação de interpretador/compilador baseado no AST
- Suporte a funções definidas pelo usuário
- Suporte a arrays e estruturas
- Geração de código intermediário
- Otimização de código

## 10. Referências

- **Aho, Sethi, Ullman.** "Compiladores: Princípios, Técnicas e Ferramentas"
- **Mogensen.** "Basics of Compiler Design"
- Gramática LL(1) baseada em especificações do Portugol

---

**Autor:** [Seu Nome]
**Data:** Dezembro 2025
**Versão:** 1.0

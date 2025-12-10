````markdown
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

... (arquivo completo arquivado)
````

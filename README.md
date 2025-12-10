# Analisador Léxico e Sintático LL(1) - Linguagem Portugol

![Status: Completo](https://img.shields.io/badge/status-completo-brightgreen)
![.NET 8.0](https://img.shields.io/badge/.NET-8.0-blue)

Um projeto educacional implementando um **analisador léxico puro** e um **analisador sintático LL(1)** completo para a linguagem Portugol (linguagem de programação em português).

## 📋 Características

✓ **Análise Léxica Pura** (sem dependências de Flex)
- Identificação de lexemas e classes de tokens
- Expressões regulares para identificadores, números, strings
- Tratamento de comentários (//) e espaços em branco

✓ **Análise Sintática LL(1) Completa**
- Gramática livre de contexto sem recursão à esquerda
- Cálculo de conjuntos FIRST e FOLLOW
- Tabela de análise LL(1)
- Algoritmo de pilha com operação MATCH

✓ **Recursos Reconhecidos**
- Declaração de variáveis (inteiro, real, logico, texto)
- Bloco principal de execução (programa/fimPrograma)
- Condicionais (se/entao/senao)
- Laços (enquanto, para)
- Expressões matemáticas e lógicas com precedência correta
- Entrada/saída (escreva)

## 🚀 Início Rápido

### Requisitos
- Windows, macOS ou Linux
- [.NET SDK 8.0+](https://dotnet.microsoft.com/)

### Compilação

```bash
dotnet build
```

### Executar com arquivo

```bash
dotnet run -- testes/teste_simples.por
```

### Mostrar tokens (Análise Léxica)

```bash
dotnet run --tokens -- testes/teste_simples.por
```

### Ler de STDIN (PowerShell)

```powershell
Get-Content testes/teste_simples.por | dotnet run --
```

## 📁 Estrutura do Projeto

```
.
├── Program.cs                 # Analisadores Léxico e Sintático LL(1)
├── Interpreter.cs            # Código de interpretação (auxiliar)
├── ANALISE_TECNICA.md        # Documentação técnica completa
├── README.md                 # Este arquivo
├── PortugolDemo.csproj       # Configuração do projeto
└── testes/                   # Arquivos de teste
    ├── teste_simples.por     # Teste básico
    └── teste_completo.por    # Teste com múltiplos recursos
```

## 💻 Exemplos

### Exemplo 1: Declaração e Expressão Simples

```portugol
programa main()
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
programa teste()
inicio
    inteiro idade = 25;
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

### Exemplo 3: Laço While

```portugol
programa contagem()
inicio
    inteiro i = 0;
    enquanto (i < 5) faca
    inicio
        escreva("Valor: ", i);
        i = i + 1;
    fim
    fimEnquanto;
fim
fimPrograma
```

## 📊 Especificação Técnica

### Análise Léxica

**Classes de Tokens:**
- 20+ palavras-chave
- Operadores aritméticos, relacionais, lógicos
- Literais (números, strings, booleanos)
- Identificadores
- Delimitadores

**Expressões Regulares Utilizadas:**
```
ID               = [a-zA-Z_][a-zA-Z0-9_]*
NUM_LITERAL      = \d+(\.\d+)?
STRING_LITERAL   = "[^"]*"
BOOL_LITERAL     = (verdadeiro|falso)
COMENTÁRIO       = //.*
```

### Análise Sintática

**Gramática LL(1) Principal:**
```
programa      → PROGRAMA ID LPAREN RPAREN blocoPrincipal FIMPROGRAMA
blocoPrincipal→ INICIO comandos FIM
comandos      → comando comandos | ε
comando       → (simples SEMI | estruturado)
simples       → declaracao | atribuicao | escreva | retorne
estruturado   → condicional | enquanto | para
expr          → exprOu
...
```

**Precedência de Operadores (menor → maior):**
1. Operadores lógicos (OU)
2. Operadores lógicos (E)
3. Negação (NAO)
4. Operadores relacionais (==, !=, <, <=, >, >=)
5. Adição e subtração (+, -)
6. Multiplicação, divisão, módulo (*, /, %)
7. Operadores unários (-, NAO)

## 🔍 Tratamento de Erros

O analisador fornece mensagens de erro detalhadas:

```
✗ Erro: Erro sintático linha 5: sem produção para 'comando' com token 'INTEIRO'
```

Indicando:
- Tipo de erro
- Linha e contexto
- Token esperado vs. encontrado

## 📝 Documentação

Para documentação técnica completa, incluindo:
- Cálculo detalhado de FIRST e FOLLOW
- Construção da tabela LL(1)
- Exemplos de derivações
- Análise de complexidade

Veja: **[ANALISE_TECNICA.md](ANALISE_TECNICA.md)**

## 🎓 Objetivo Educacional

Este projeto foi desenvolvido para demonstrar:
1. ✓ Implementação pura de análise léxica
2. ✓ Transformação de gramática para forma LL(1)
3. ✓ Cálculo de conjuntos FIRST/FOLLOW
4. ✓ Construção de tabela LL(1)
5. ✓ Implementação do algoritmo de pilha LL(1)

## 📜 Requisitos do Trabalho Acadêmico

Este projeto atende aos seguintes requisitos:

- [x] Análise léxica pura (sem Flex/bibliotecas externas)
- [x] Análise sintática LL(1) implementada manualmente
- [x] Linguagem com:
  - [x] Declaração de variáveis (int, float, double equivalentes)
  - [x] Bloco de execução principal (main/programa)
  - [x] Blocos condicionais (if/else)
  - [x] Equações matemáticas com precedência
  - [x] Regras lógicas (AND, OR, NOT)
  - [x] Laços (while, for)
  - [x] Saída (print/escreva)
- [x] Gramática em formato LL(1):
  - [x] Sem ambiguidades
  - [x] Com associatividade e precedência definidas
  - [x] Sem recursão à esquerda
  - [x] Fatorada
- [x] FIRST e FOLLOW calculados
- [x] Tabela LL(1) construída
- [x] Pilha de análise com MATCH implementada

## 🔗 Tecnologias

- **Linguagem:** C# 11
- **Framework:** .NET 8.0
- **Paradigma:** Programação imperativa/orientada a objetos

## 📄 Licença

Este projeto é fornecido como material educacional.

## 👤 Autor

Desenvolvido como projeto acadêmico para demonstração de compiladores e análise de linguagens.

---

**Status:** ✓ Completo e testado
**Última atualização:** Dezembro 2025


## (Opcional) Regenerar léxico/parser a partir do `Portugol.g4`
Se desejar alterar a gramática e **regenerar** os arquivos C#:

java -jar %ANTLR_JAR% -Dlanguage=CSharp -visitor -listener Portugol.g4 -o Grammar

> Após regenerar, execute novamente `dotnet restore` e `dotnet build`.

## Estrutura mínima esperada
- `Grammar/` — arquivos gerados do ANTLR (lexer/parser/visitors/listeners)
- `Portugol.g4` — gramática da linguagem
- `Program.cs` — ponto de entrada do analisador
- `PortugolDemo.csproj` — projeto .NET
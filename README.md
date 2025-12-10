# Analisador Léxico e Sintático LL(1) - Linguagem Portugol

![Status: Completo](https://img.shields.io/badge/status-completo-brightgreen)
![.NET 8.0](https://img.shields.io/badge/.NET-8.0-blue)

Um projeto educacional implementando um **analisador léxico puro** e um **analisador sintático LL(1)** completo para a linguagem Portugol (linguagem de programação em português).

## Sumário

- [Características](#caracteristicas)
- [Início Rápido](#inicio-rapido)
- [Estrutura do Projeto / Resumo GitHub](#resumo-github)
- [Quick start](#quick-start)
- [O que contém](#o-que-contem)
- [Uso (CLI)](#uso-cli)
- [Exemplos rápidos](#exemplos-rapidos)
- [Testes e validação](#testes-e-validacao)
- [Documentação arquivada](#documentacao-arquivada)
- [Contribuição](#contribuicao)

<!-- Anchors for reliable links -->
<a id="caracteristicas"></a>

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

<a id="inicio-rapido"></a>
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
dotnet run -- --tokens testes/teste_simples.por
```

### Exportar para CSV

```bash
dotnet run -- --csv testes/teste_simples.por
```

### Salvar CSV em arquivo

```bash
dotnet run -- --csv --out tokens.csv testes/teste_simples.por
```

### Ver derivações sintáticas

```bash
dotnet run -- --verbose testes/teste_simples.por
```

### Ajuda

```bash
dotnet run -- --help
```

### Ler de STDIN (PowerShell)

```powershell
Get-Content testes/teste_simples.por | dotnet run --
```

<a id="resumo-github"></a>
## 📁 Estrutura do Projeto

# PortugolDemo — Compilador Educacional (Resumo para GitHub)

![Status: Completo](https://img.shields.io/badge/status-completo-brightgreen) ![.NET 8.0](https://img.shields.io/badge/.NET-8.0-blue)

Breve: implementação didática e funcional de um analisador léxico puro e um parser LL(1) (stack-based) para a linguagem Portugol.

## Índice

- [Quick start](#quick-start)
- [O que contém](#o-que-contém)
- [Uso (CLI)](#uso-cli)
- [Exemplos rápidos](#exemplos-rapidos)
- [Testes e validação](#testes-e-validação)
- [Documentação completa (arquivada)](#documentação-completa-arquivada)
- [Contribuição](#contribuição)

---

<a id="quick-start"></a>
## Quick start

Requisitos: [.NET SDK 8.0+]

```powershell
cd PortugolDemo
dotnet build
dotnet run -- testes/teste_simples.por
```

Resultado esperado: `✓ Análise concluída com sucesso!`

<a id="o-que-contem"></a>
## O que contém

- Analisador léxico (regex-based) — ~30 tipos de tokens
- Parser LL(1) com cálculo automático de FIRST/FOLLOW e tabela de parsing
- Exportação de tokens em CSV e modo `--tokens` para inspeção
- Modo `--verbose` para imprimir derivações (educacional)
- Testes de exemplo em `testes/` (incluindo `teste_funcionalidades.por`)

<a id="uso-cli"></a>
## Uso (CLI)

- Modo padrão (sintático):
    ```powershell
    dotnet run -- arquivo.por
    ```
- Listar tokens (table):
    ```powershell
    dotnet run -- --tokens arquivo.por
    ```
- CSV:
    ```powershell
    dotnet run -- --csv arquivo.por
    dotnet run -- --csv --out tokens.csv arquivo.por
    ```
- Verbose (derivações):
    ```powershell
    dotnet run -- --verbose arquivo.por
    ```

<a id="exemplos-rapidos"></a>
## Exemplos rápidos

Programa mínimo:

```portugol
programa hello()
inicio
        escreva("Olá, Mundo!");
fim
fimPrograma
```

Ver tokens:

```powershell
dotnet run -- --tokens testes/teste_simples.por
```

<a id="testes-e-validacao"></a>
## Testes e validação

Segue abaixo o relatório de validação consolidado (original em `TESTE_VALIDACAO.md`).

### Resultados dos Testes

#### ✅ Teste 1: Compilação
**Status:** PASSOU
- Projeto compilado sem erros
- Avisos ignorados (ANTLR generated code)

#### ✅ Teste 2: Análise Simples
**Arquivo:** `testes/teste_simples.por`
```
programa helloWorld()
inicio
        escreva("Olá, Mundo!");
fim
fimPrograma
```
**Resultado:** ✓ Análise concluída com sucesso!

#### ✅ Teste 3: Análise Funcionalidades Completas
**Arquivo:** `testes/teste_funcionalidades.por` (57 linhas)
**Recursos Testados:**
- ✅ Declaração de variáveis (inteiro, real, logico, texto)
- ✅ Operações matemáticas com precedência
- ✅ Expressões lógicas (e, ou, nao)
- ✅ Condicional (se/entao/senao)
- ✅ Comparações relacionais (==, !=, <, >, <=, >=)
- ✅ Laço while (enquanto/faca/fimEnquanto)
- ✅ Laço for (para/de/ate/passo/faca/fimPara)
- ✅ Output múltiplo (escreva)

**Resultado:** Análise sintática completa com sucesso

#### ✅ Teste 4: Análise Léxica
**Comando:** `dotnet run -- --tokens testes/teste_funcionalidades.por`
**Tokens Gerados:** 157 tokens
**Tipos Únicos:** 30+
**Exemplo de Saída:**
```
                                TIPO |               LEXEMA | LINHA
--------------------------------------------------
                        PROGRAMA |             programa |     3
                                    ID |           exercicios |     3
                            LPAREN |                    ( |     3
                            RPAREN |                    ) |     3
                            INICIO |               inicio |     4
                         INTEIRO |              inteiro |     6
                                    ID |               numero |     6
                             EQUAL |                    = |     6
                 NUM_LITERAL |                   42 |     6
                                SEMI |                    ; |     6
```

**Resultado:** ✓ Todos os tokens extraídos corretamente

#### ✅ Teste 5: Exportação CSV
**Comando:** `dotnet run -- --csv testes/teste_funcionalidades.por`
**Formato:** Tipo,Lexema,Linha,Coluna
**Exemplo de Saída:**
```
Tipo,Lexema,Linha,Coluna
PROGRAMA,"programa",3,0
ID,"exercicios",3,8
LPAREN,"(",3,18
RPAREN,")",3,19
INICIO,"inicio",4,0
INTEIRO,"inteiro",6,0
ID,"numero",6,7
EQUAL,"=",6,13
NUM_LITERAL,"42",6,14
SEMI,";",6,16
```

**Resultado:** ✓ CSV formatado corretamente

#### ✅ Teste 6: Salvar CSV em Arquivo
**Comando:** `dotnet run -- --csv --out tokens.csv testes/teste_funcionalidades.por`
**Arquivo Criado:** ✓ tokens.csv
**Tamanho:** ~8KB com 157 linhas

**Resultado:** ✓ Arquivo criado e salvo com sucesso

#### ✅ Teste 7: Modo Verbose
**Comando:** `dotnet run -- --verbose testes/teste_funcionalidades.por`
**Derivações:** 100+ derivações diferentes
**Exemplo de Saída:**
```
=== ANÁLISE SINTÁTICA LL(1) - MODO VERBOSE ===

programa → PROGRAMA ID LPAREN RPAREN blocoPrincipal FIMPROGRAMA
blocoPrincipal → INICIO comandos FIM
comandos → comando comandos
comando → simples SEMI
simples → declaracao
declaracao → tipo ID EQUAL expr
tipo → INTEIRO
expr → exprOu
exprOu → exprE exprOuRest
exprE → exprNao exprERest
exprNao → exprRel
exprRel → exprAd exprRelRest
exprAd → exprMul exprAdRest
exprMul → exprUn exprMulRest
exprUn → exprPri
exprPri → NUM_LITERAL
exprMulRest → ε
exprAdRest → ε
exprRelRest → ε
exprERest → ε
exprOuRest → ε
...
```

**Resultado:** ✓ Derivações exibidas corretamente

#### ✅ Teste 8: Ajuda
**Comando:** `dotnet run -- --help`
**Saída:**
```
Uso: dotnet run [opções] [arquivo]

Opções:
    --tokens        : Imprime tokens (tipo, lexema, linha)
    --csv           : Imprime tokens em formato CSV (tipo,lexema,linha,coluna)
    --out <arquivo> : Salva saída CSV no arquivo
    --verbose, -v   : Modo verbose com derivações
    --help, -h      : Mostra esta ajuda

Sem arquivo: lê da STDIN.
Sem flags  : analisa sintaticamente (modo normal).
```

**Resultado:** ✓ Ajuda exibida corretamente

### Resumo de Resultados

| Teste | Status | Detalhes |
|-------|--------|----------|
| Compilação | ✅ PASSOU | 0 erros, 6 avisos (ANTLR) |
| Análise Simples | ✅ PASSOU | Programa básico analisado |
| Análise Completa | ✅ PASSOU | Todos os recursos suportados |
| Léxica (Tokens) | ✅ PASSOU | 157 tokens extraídos |
| CSV Output | ✅ PASSOU | Formato correto com linha/coluna |
| CSV File | ✅ PASSOU | Arquivo criado e salvo |
| Verbose | ✅ PASSOU | Derivações exibidas |
| Help | ✅ PASSOU | Documentação disponível |

**Total: 8/8 TESTES PASSARAM ✅**

### Validações Técnicas (resumo)

- Análise Léxica: reconhecimento de 30+ tipos de tokens, literais numéricos, strings com escape, booleanos, rastreamento linha/coluna, comentários, EOF
- Análise Sintática: gramática LL(1) sem ambiguidades, eliminação de recursão à esquerda, fatoração, cálculo FIRST/FOLLOW, parse table e stack-based parser
- Suporte à linguagem: variáveis (4 tipos), operadores aritméticos e lógicos com precedência, condicionais, laços while/for, writes
- Interface: CLI multi-modo, tokens formatados, exportação CSV, verbose, ajuda, leitura stdin

**Conclusão:** ✓ TODOS OS TESTES PASSARAM — compilador pronto para uso educacional e demonstração.


<a id="documentacao-arquivada"></a>
## Documentação completa (arquivada)

To keep the repository root concise, the full technical documents were moved to `docs/archive_md/`.

Arquivos arquivados (exemplos):

- `docs/archive_md/DEMONSTRACAO.md`
- `docs/archive_md/ARQUITETURA.md`
- `docs/archive_md/ANALISE_TECNICA.md`
- `docs/archive_md/QUICKSTART.md`
- `docs/archive_md/RESUMO_FINAL.md`
- `docs/archive_md/00_LEIA_PRIMEIRO.md`

Abraços: mantenha `README.md` enxuto para a página do GitHub; o restante está em `docs/archive_md/` para leitura aprofundada.

<a id="contribuicao"></a>
## Contribuição

Se desejar que eu remova também os arquivos arquivados (excluí-los permanentemente) ou gerar um TOC navegável automático, diga qual opção prefere.

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
# PortugolDemo

## Requisitos
- Windows, macOS ou Linux
- [.NET SDK 8.0+](https://dotnet.microsoft.com/)
- Java (JDK 11+)

## Instalação
1. Baixe/clone o projeto para uma pasta local.

## Como usar
### Compilar

dotnet build


### Executar com **arquivo**

dotnet run caminho/para/arquivo.por


### Executar lendo do **stdin** (PowerShell)

Get-Content caminho/para/arquivo.por | dotnet run


### Mostrar somente **tokens** (útil para a parte léxica)

dotnet run -- --tokens caminho/para/arquivo.por


## (Opcional) Regenerar léxico/parser a partir do `Portugol.g4`
Se desejar alterar a gramática e **regenerar** os arquivos C#:

java -jar %ANTLR_JAR% -Dlanguage=CSharp -visitor -listener Portugol.g4 -o Grammar

> Após regenerar, execute novamente `dotnet restore` e `dotnet build`.

## Estrutura mínima esperada
- `Grammar/` — arquivos gerados do ANTLR (lexer/parser/visitors/listeners)
- `Portugol.g4` — gramática da linguagem
- `Program.cs` — ponto de entrada do analisador
- `PortugolDemo.csproj` — projeto .NET
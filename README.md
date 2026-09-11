# Analisador léxico e sintático LL(1) para Portugol

Projeto educacional em .NET 8 que implementa um analisador léxico e um parser preditivo LL(1) para uma linguagem inspirada em Portugol.

## Funcionalidades

- Reconhecimento de identificadores, literais, palavras-chave, operadores e comentários.
- Cálculo e uso de conjuntos FIRST e FOLLOW.
- Tabela de análise LL(1) e parser baseado em pilha.
- Modos de linha de comando para exibir tokens, exportar CSV e acompanhar derivações.
- Arquivos `.por` de exemplo em `testes/` para validação manual.

## Requisitos

- .NET SDK 8.0 ou superior.
- Java e ANTLR apenas se você quiser regenerar os arquivos da gramática.

## Compilar e executar

```bash
dotnet build
dotnet run -- testes/teste_simples.por
dotnet run -- --tokens testes/teste_funcionalidades.por
dotnet run -- --csv testes/teste_funcionalidades.por
dotnet run -- --verbose testes/teste_funcionalidades.por
```

Use `dotnet run -- --help` para ver todas as opções. Sem arquivo, a aplicação lê a entrada padrão.

## Estrutura principal

- `Program.cs`: interface de linha de comando.
- `Portugol.g4`: gramática da linguagem.
- `Grammar/`: código gerado pelo ANTLR.
- `testes/`: programas de exemplo válidos e inválidos.
- `docs/archive_md/`: documentação técnica histórica.

## Validação e limites

Os arquivos em `testes/` permitem verificar manualmente compilação, tokenização, análise sintática, exportação CSV, modo detalhado e ajuda. O repositório não contém um projeto formal de testes unitários nem mede cobertura; por isso, este README não afirma uma taxa automatizada de aprovação.

O projeto tem finalidade didática e não é um compilador de produção.

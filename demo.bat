@echo off
REM Demonstração completa do compilador Portugol

echo.
echo ====================================================================
echo   DEMONSTRACAO COMPILADOR PORTUGOL - ANALISE LEICA E SINTATICA LL(1)
echo ====================================================================
echo.

cd /d "%~dp0"

echo [1/6] Compilando o projeto...
echo.
dotnet build > nul 2>&1
if %ERRORLEVEL% neq 0 (
    echo ERRO: Falha na compilacao
    exit /b 1
)
echo ✓ Projeto compilado com sucesso

echo.
echo.
echo [2/6] Teste Simples - Analise Sintatica
echo.
echo Arquivo: testes/teste_simples.por
echo.
dotnet run -- testes/teste_simples.por
if %ERRORLEVEL% neq 0 (
    echo ✗ Teste simples falhou
) else (
    echo.
)

echo.
echo [3/6] Teste Completo - Analise Leica (Tokens)
echo.
echo Arquivo: testes/teste_funcionalidades.por
echo.
echo Primeiros 15 tokens:
dotnet run -- --tokens testes/teste_funcionalidades.por 2>nul | findstr /N /V "^$" | head -n 17
echo.

echo.
echo [4/6] Teste Completo - Exportacao CSV
echo.
dotnet run -- --csv --out "tokens_export.csv" testes/teste_funcionalidades.por > nul 2>&1
if exist "tokens_export.csv" (
    echo ✓ Arquivo CSV criado: tokens_export.csv
    echo.
    echo Primeiras 5 linhas do CSV:
    type tokens_export.csv | findstr /N "." | head -n 6
    echo.
) else (
    echo ✗ Falha ao criar arquivo CSV
)

echo.
echo [5/6] Teste Completo - Modo Verbose (Derivacoes)
echo.
echo Primeiras 25 derivacoes:
dotnet run -- --verbose testes/teste_funcionalidades.por 2>nul | findstr /V "^$" | head -n 27
echo.

echo.
echo [6/6] Informacoes do Projeto
echo.
echo Estrutura de arquivos:
tree /F /A "%~dp0" | findstr /V "node_modules"
echo.

echo.
echo ====================================================================
echo   DEMONSTRACAO CONCLUIDA COM SUCESSO
echo ====================================================================
echo.
echo Use: dotnet run -- --help
echo Para ver todas as opcoes disponíveis
echo.

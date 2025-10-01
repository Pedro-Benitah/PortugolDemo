using System;
using System.IO;
using System.Linq;
using System.Text;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;

class Program
{
    static int Main(string[] args)
    {
        // 1) Parse de argumentos
        bool printTokens = args.Contains("--tokens");
        bool showHelp = args.Contains("--help") || args.Contains("-h");

        string? path = args.FirstOrDefault(a => !a.StartsWith("-"));

        if (showHelp)
        {
            Console.WriteLine(@"Uso:
  dotnet run [--] [--tokens] [arquivo]

Sem arquivo: lê da STDIN.
--tokens   : imprime CSV de tokens (Tipo,Lexema,Linha,Coluna).
Sem --tokens: imprime a árvore sintática.");
            return 0;
        }

        // 2) Carregar entrada (arquivo ou STDIN)
        string inputText;
        if (!string.IsNullOrWhiteSpace(path))
        {
            if (!File.Exists(path))
            {
                Console.Error.WriteLine($"Erro: arquivo não encontrado: {path}");
                return 1;
            }
            inputText = File.ReadAllText(path, Encoding.UTF8);
        }
        else
        {
            // Lê tudo da entrada padrão
            inputText = Console.In.ReadToEnd();
        }

        if (string.IsNullOrWhiteSpace(inputText))
        {
            Console.Error.WriteLine("Entrada vazia. Use: dotnet run <arquivo>  ou  Get-Content arquivo | dotnet run");
            return 1;
        }

        // 3) Pipeline ANTLR
        var input = new AntlrInputStream(inputText);
        var lexer = new PortugolLexer(input);

        // Captura erros léxicos
        var lexErr = new CollectingErrorListener();
        lexer.RemoveErrorListeners();
        lexer.AddErrorListener(lexErr);

        var tokens = new CommonTokenStream(lexer);
        var parser = new PortugolParser(tokens);

        // Captura erros sintáticos
        var synErr = new CollectingErrorListener();
        parser.RemoveErrorListeners();
        parser.AddErrorListener(synErr);

        // 4) Rodar conforme o modo
        try
        {
            if (printTokens)
            {
                // Força a tokenização
                tokens.Fill();

                // Se houve erro léxico, mostre e retorne falha
                if (lexErr.HasErrors)
                {
                    lexErr.PrintTo(Console.Error, "LÉXICO");
                    return 1;
                }

                PrintTokensCsv(tokens, lexer);
            }
            else
            {
                // Parse a partir da regra inicial
                IParseTree tree = parser.programa();

                bool hasErrors = lexErr.HasErrors || synErr.HasErrors || parser.NumberOfSyntaxErrors > 0;
                if (hasErrors)
                {
                    if (lexErr.HasErrors) lexErr.PrintTo(Console.Error, "LÉXICO");
                    if (synErr.HasErrors) synErr.PrintTo(Console.Error, "SINTÁTICO");
                    return 1;
                }

                // Imprime árvore bonita
                PrintTree(tree, parser);
            }

            return 0;
        }
        catch (Exception ex)
        {
            Console.Error.WriteLine("Falha durante a análise:");
            Console.Error.WriteLine(ex.Message);
            return 1;
        }
    }

    // Helpers

    // CSV de tokens: Tipo,Lexema,Linha,Coluna
    static void PrintTokensCsv(CommonTokenStream tokenStream, PortugolLexer lexer)
    {
        Console.WriteLine("Tipo,Lexema,Linha,Coluna");

        foreach (var t in tokenStream.GetTokens())
        {
            if (t.Type == TokenConstants.EOF) continue;

            string tipo = GetTokenDisplayName(lexer, t.Type);
            string lexema = t.Text?.Replace("\"", "\"\"") ?? "";
            int linha = t.Line;
            int coluna = t.Column;

            // Tipo entre aspas simples
            if (tipo.StartsWith("'") || tipo.All(ch => char.IsLetterOrDigit(ch) || ch == '_' || ch == '\''))
            {
                Console.WriteLine($"{tipo},\"{lexema}\",{linha},{coluna}");
            }
            else
            {
                // fallback
                Console.WriteLine($"'{tipo}',\"{lexema}\",{linha},{coluna}");
            }
        }
    }

    // Retorna um nome para o token
    static string GetTokenDisplayName(PortugolLexer lexer, int tokenType)
    {
        var vocab = lexer.Vocabulary;
        string? literal = vocab.GetLiteralName(tokenType);
        if (!string.IsNullOrEmpty(literal))
            return literal;

        string? symbolic = vocab.GetSymbolicName(tokenType);
        if (!string.IsNullOrEmpty(symbolic))
            return symbolic;

        return tokenType.ToString();
    }

    // Impressão recursiva da árvore com indentação
    static void PrintTree(IParseTree tree, Parser parser, int indent = 0)
    {
        var pad = new string(' ', indent);
        string nodeText = tree switch
        {
            ParserRuleContext prc => parser.RuleNames[prc.RuleIndex],
            _ => tree.GetText()
        };

        Console.WriteLine($"{pad}{nodeText}");

        for (int i = 0; i < tree.ChildCount; i++)
        {
            PrintTree(tree.GetChild(i), parser, indent + 2);
        }
    }
}

// Error listener que acumula mensagens
class CollectingErrorListener : IAntlrErrorListener<int>, IAntlrErrorListener<IToken>
{
    private readonly StringBuilder _sb = new StringBuilder();
    public bool HasErrors => _sb.Length > 0;

    public void SyntaxError(TextWriter output, IRecognizer recognizer, int offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
    {
        _sb.AppendLine($"[linha {line}, coluna {charPositionInLine}] {msg}");
    }

    public void SyntaxError(TextWriter output, IRecognizer recognizer, IToken offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
    {
        string text = offendingSymbol?.Text ?? "<EOF>";
        _sb.AppendLine($"[linha {line}, coluna {charPositionInLine}] perto de '{text}': {msg}");
    }

    public void PrintTo(TextWriter tw, string titulo)
    {
        tw.WriteLine($"Erros {titulo}:");
        tw.Write(_sb.ToString());
    }
}

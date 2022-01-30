package ru.senina.itmo.taskB.parser;

import org.antlr.v4.runtime.*;
import ru.senina.itmo.MathlogLexer;
import ru.senina.itmo.MathlogParser;
import ru.senina.itmo.taskB.expressions.Expression;

import java.io.*;

public class Parser{
    public static Expression parse(String path) throws IOException {
        CharStream codePointCharStream = CharStreams.fromFileName(path);
        MathlogLexer lexer = new MathlogLexer(codePointCharStream);
        MathlogParser parser = new MathlogParser(new CommonTokenStream(lexer));
        return parser.expression().e;
    }
}

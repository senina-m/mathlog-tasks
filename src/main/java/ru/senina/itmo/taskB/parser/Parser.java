package ru.senina.itmo.taskB.parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import ru.senina.itmo.MathlogLexer;
import ru.senina.itmo.MathlogParser;
import ru.senina.itmo.taskB.expressions.Expression;

import java.io.IOException;

public class Parser{
    public static Expression parse() throws IOException {
        CharStream codePointCharStream = CharStreams.fromStream(System.in);
        MathlogLexer lexer = new MathlogLexer(codePointCharStream);
        MathlogParser parser = new MathlogParser(new CommonTokenStream(lexer));
        return parser.expression().e;
    }
}

package ru.senina.itmo.taskB;

import ru.senina.itmo.taskB.expressions.Expression;
import ru.senina.itmo.taskB.parser.Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        Expression expression = Parser.parse("input.txt");
        try (PrintWriter out = new PrintWriter("output.txt")) {
            out.println(expression.toTree());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

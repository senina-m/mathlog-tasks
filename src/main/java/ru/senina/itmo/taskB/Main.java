package ru.senina.itmo.taskB;

import com.bpodgursky.jbool_expressions.Expression;
import com.bpodgursky.jbool_expressions.parsers.ExprParser;
import com.bpodgursky.jbool_expressions.rules.RuleSet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        String example = "(( (! C) | C) & A => B)";
        Expression<String> parsedExpression = ExprParser.parse(example);
        System.out.println(parsedExpression);
    }
}

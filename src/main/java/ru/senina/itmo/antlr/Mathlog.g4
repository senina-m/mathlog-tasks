grammar Mathlog;

//〈Файл〉 ::= 〈Выражение〉
//〈Выражение〉 ::= 〈Дизъюнкция〉 | 〈Дизъюнкция〉 ‘->’ 〈Выражение〉
//〈Дизъюнкция〉 ::= 〈Конъюнкция〉 | 〈Дизъюнкция〉 ‘|’ 〈Конъюнкция〉
//〈Конъюнкция〉 ::= 〈Отрицание〉 | 〈Конъюнкция〉 ‘&’ 〈Отрицание〉
//〈Отрицание〉 ::= ‘!’ 〈Отрицание〉 | 〈Переменная〉 | ‘(’ 〈Выражение〉 ‘)’
//〈Переменная〉 ::= (‘A’ . . . ‘Z’) {‘A’ . . . ‘Z’ | ‘0’ . . . ‘9’ | ‘’’}∗

@header {
package ru.senina.itmo;
import ru.senina.itmo.MathlogListener;
import ru.senina.itmo.MathlogVisitor;
import ru.senina.itmo.MathlogParser;
import ru.senina.itmo.taskB.expressions.*;
}

expression returns [Expression e] : disjuct=disjunction {$e = $disjuct.e;}
                | disjuctImpl=disjunction '->' exprImpl=expression {$e = new Implication($disjuctImpl.e, $exprImpl.e);};

disjunction returns [Expression e] : conjuct=conjunction {$e = $conjuct.e;}
                | disjunctOr=disjunction '|' conjuctOr=conjunction {$e = new Disjunction($disjunctOr.e, $conjuctOr.e);};

conjunction returns [Expression e] : neg=negation {$e = $neg.e;}
                | conjuctAnd=conjunction '&' negAnd=negation{$e = new Conjunction($conjuctAnd.e, $negAnd.e);};

negation returns [Expression e] : var=variable {$e = $var.e;}
                | '!' neg=negation {$e = new Negation($neg.e);} | '(' exp=expression ')' {$e = $exp.e;};

variable returns [Expression e] : VAR {$e = new Variable($VAR.text);};

VAR : [A-Z]([A-Z0-9])*;
WS  : [ \t\r\n]+ -> skip ; // whitespases, skip spaces, tabs, newlines

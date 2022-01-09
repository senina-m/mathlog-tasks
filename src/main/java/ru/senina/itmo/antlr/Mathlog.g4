//   〈Файл〉 ::= 〈Выражение〉
//   〈Выражение〉 ::= 〈Дизъюнкция〉 | 〈Дизъюнкция〉 ‘->’ 〈Выражение〉
//   〈Дизъюнкция〉 ::= 〈Конъюнкция〉 | 〈Дизъюнкция〉 ‘|’ 〈Конъюнкция〉
//   〈Конъюнкция〉 ::= 〈Отрицание〉 | 〈Конъюнкция〉 ‘&’ 〈Отрицание〉
//   〈Отрицание〉 ::= ‘!’ 〈Отрицание〉 | 〈Переменная〉 | ‘(’ 〈Выражение〉 ‘)’
//   〈Переменная〉 ::= (‘A’ . . . ‘Z’) {‘A’ . . . ‘Z’ | ‘0’ . . . ‘9’ | ‘’’}∗

grammar Mathlog;

@header {
package ru.senina.itmo;
}
mathlog : expression* EOF;
expression : disjunction | (disjunction '->' expression);
disjunction : conjunction | (disjunction '|' conjunction);
conjunction : negation | (conjunction '&' negation);
negation  : '!' (negation | VAR | '(' expression ')');
WS  : [ \t\r\n]+ -> skip ; // whitespases, skip spaces, tabs, newlines
VAR : [A-Z0-9’]+; // match variables (‘A’ . . . ‘Z’) {‘A’ . . . ‘Z’ | ‘0’ . . . ‘9’ | ‘’’

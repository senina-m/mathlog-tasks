package ru.senina.itmo.taskB.expressions;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Implication implements Expression{

    private final Expression disjunction;
    private final Expression expression;

    @Override
    public String toTree() {
        return "(->," + disjunction.toTree() + "," + expression.toTree() + ")";
    }

    @Override
    public String toString(){
        return "(" + disjunction.toString() + "->" + expression.toString() + ")";
    }
}

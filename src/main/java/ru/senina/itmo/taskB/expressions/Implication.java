package ru.senina.itmo.taskB.expressions;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Implication implements Expression{

    private Expression disjunction;
    private Expression expression;

    @Override
    public String toTree() {
        return "(->," + disjunction.toTree() + "," + expression.toTree() + ")";
    }

    @Override
    public String toString(){
        return "(" + disjunction.toString() + "->" + expression.toString() + ")";
    }
}

package ru.senina.itmo.taskB.expressions;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Negation implements  Expression{
    private final Expression negation;

    @Override
    public String toTree() {
        return "(!" + negation.toTree() + ")";
    }

    @Override
    public String toString(){
        return "!" + negation.toString();
    }
}

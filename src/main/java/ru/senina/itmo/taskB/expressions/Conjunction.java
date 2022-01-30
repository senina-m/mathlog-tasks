package ru.senina.itmo.taskB.expressions;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Conjunction implements Expression{
    private final Expression conjunction;
    private final Expression negation;

    @Override
    public String toTree() {
        return "(&," + conjunction.toTree() + "," + negation.toTree() + ")";
    }

    @Override
    public String toString() {
        return "(" + conjunction + "&" + negation + ")";
    }
}

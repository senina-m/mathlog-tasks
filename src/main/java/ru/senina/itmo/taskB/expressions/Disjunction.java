package ru.senina.itmo.taskB.expressions;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Disjunction implements Expression {
    private final Expression disjunction;
    private final Expression conjunction;

    @Override
    public String toTree() {
        return "(" + disjunction + "|" + conjunction + ")";
    }

    @Override
    public String toString() {
        return "(|," + disjunction.toTree() + "," + conjunction.toTree() + ")";
    }
}

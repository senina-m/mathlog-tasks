package ru.senina.itmo.taskB.expressions;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Disjunction implements Expression {
    private Expression disjunction;
    private Expression conjunction;

    @Override
    public String toTree() {
        return "(" + disjunction + "|" + conjunction + ")";
    }

    @Override
    public String toString() {
        return "(|," + disjunction.toTree() + "," + conjunction.toTree() + ")";
    }
}

package ru.senina.itmo.taskB.expressions;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Conjunction implements Expression{
    private Expression conjunction;
    private Expression negation;

    @Override
    public String toTree() {
        return "(&," + conjunction.toTree() + "," + negation.toTree() + ")";
    }

    @Override
    public String toString() {
        return "(" + conjunction + "&" + negation + ")";
    }
}

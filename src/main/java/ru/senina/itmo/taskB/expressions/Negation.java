package ru.senina.itmo.taskB.expressions;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Negation implements  Expression{
    private Expression negation;

    @Override
    public String toTree() {
        return "(!" + negation.toTree() + ")";
    }

    @Override
    public String toString(){
        return "!" + negation.toString();
    }
}

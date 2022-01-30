package ru.senina.itmo.taskB.expressions;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

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
    public boolean calcValue() {
        return conjunction.calcValue() && negation.calcValue();
    }

    @Override
    public void fillVarSet(Map<String, List<Variable>> map) {
        conjunction.fillVarSet(map);
        negation.fillVarSet(map);
    }

    @Override
    public String toString() {
        return "(" + conjunction + "&" + negation + ")";
    }
}

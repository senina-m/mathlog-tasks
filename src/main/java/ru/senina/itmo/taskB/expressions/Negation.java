package ru.senina.itmo.taskB.expressions;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
    public boolean calcValue() {
        return !negation.calcValue();
    }

    @Override
    public void fillVarSet(Map<String, List<Variable>> map) {
        negation.fillVarSet(map);
    }

    @Override
    public String toString(){
        return "!" + negation.toString();
    }
}

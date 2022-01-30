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
public class Implication implements Expression{

    private Expression disjunction;
    private Expression expression;

    @Override
    public String toTree() {
        return "(->," + disjunction.toTree() + "," + expression.toTree() + ")";
    }

    @Override
    public boolean calcValue() {
        return !disjunction.calcValue() || expression.calcValue();
    }

    @Override
    public void fillVarSet(Map<String, List<Variable>> map) {
        disjunction.fillVarSet(map);
        expression.fillVarSet(map);
    }

    @Override
    public String toString(){
        return "(" + disjunction.toString() + "->" + expression.toString() + ")";
    }
}

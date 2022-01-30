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
public class Disjunction implements Expression {
    private Expression disjunction;
    private Expression conjunction;

    @Override
    public String toTree() {
        return "(" + disjunction + "|" + conjunction + ")";
    }

    @Override
    public boolean calcValue() {
        return disjunction.calcValue() || conjunction.calcValue();
    }

    @Override
    public void fillVarSet(Map<String, List<Variable>> map) {
        conjunction.fillVarSet(map);
        disjunction.fillVarSet(map);
    }

    @Override
    public String toString() {
        return "(|," + disjunction.toTree() + "," + conjunction.toTree() + ")";
    }
}

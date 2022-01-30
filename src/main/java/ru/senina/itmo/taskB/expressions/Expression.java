package ru.senina.itmo.taskB.expressions;

import java.util.List;
import java.util.Map;

public interface Expression {
    String toTree();
    boolean calcValue();
    void fillVarSet(Map<String, List<Variable>> map);
}

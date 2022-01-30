package ru.senina.itmo.taskB.expressions;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class Variable implements Expression{

    private String name;
    @Setter
    private boolean value = false;

    @Override
    public String toTree() {
        return name;
    }

    @Override
    public boolean calcValue() {
        return value;
    }

    @Override
    public void fillVarSet(Map<String, List<Variable>> map) {
        if(!map.containsKey(name)) map.put(name, new ArrayList<>());
        map.get(name).add(this);

    }

    @Override
    public String toString() {
        return name;
    }

    public Variable(String name) {
        this.name = name;
    }

    public boolean getValue() {
        return value;
    }
}

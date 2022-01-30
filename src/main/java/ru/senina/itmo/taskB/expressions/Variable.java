package ru.senina.itmo.taskB.expressions;

import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
public class Variable implements Expression{
    @Getter
    private final String var;

    @Override
    public String toTree() {
        return var;
    }

    @Override
    public String toString() {
        return var;
    }
}

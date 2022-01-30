package ru.senina.itmo.taskB.expressions;

import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Variable implements Expression{
    @Getter
    private String var;

    @Override
    public String toTree() {
        return var;
    }

    @Override
    public String toString() {
        return var;
    }
}

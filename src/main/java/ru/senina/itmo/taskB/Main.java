package ru.senina.itmo.taskB;

import ru.senina.itmo.taskB.expressions.Expression;
import ru.senina.itmo.taskB.expressions.Variable;
import ru.senina.itmo.taskB.parser.Parser;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Expression expression = Parser.parse("input.txt");

        Map<String, List<Variable>> varMap = new HashMap<>();

        expression.fillVarSet(varMap);

        String[] varNames = varMap.keySet().toArray(new String[0]);
        int numOfChecks = (int) Math.pow(2, varNames.length);
        int numOfTrueResults = 0;

        for(int i = 0; i < numOfChecks; i++) {
            setNextCombination(varNames, varMap);
            if (expression.calcValue()) numOfTrueResults++;
        }

        System.out.println();

        if(numOfTrueResults == 0){
            System.out.println("Unsatisfiable");
        }else if (numOfTrueResults == numOfChecks){
            System.out.println("Valid");
        }else{
            System.out.println("Satisfiable and invalid, " + numOfTrueResults + " true and " +
                    (numOfChecks - numOfTrueResults) + " false cases");
        }

        try (PrintWriter out = new PrintWriter("output.txt")) {
            out.println(expression.toTree());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

//    private static Variable[] createArrayFromMap(Map<String, Variable> map) {
//        Variable[] out = new Variable[map.size()];
//        List<Variable> ret = new ArrayList<>(map.size());
//        ret.addAll(map.values());
//        return ret.toArray(out);
//    }

    private static void setNextCombination(String[] varNames, Map<String, List<Variable>> map) {
        boolean value = getValueOfVars(varNames[0], map);
        setValueToVars(map.get(varNames[0]),!value);
        boolean tmp = value;
        for (int i = 1; i < varNames.length; i++) {
            value = getValueOfVars(varNames[i], map);
            setValueToVars(map.get(varNames[i]),value^tmp);
            tmp = value && tmp;
        }
    }

    private static void setValueToVars(List<Variable> list, boolean value){
        for(Variable var : list) var.setValue(value);
    }

    private static boolean getValueOfVars(String name, Map<String, List<Variable>> map){
        return map.get(name).get(0).getValue();
    }
}

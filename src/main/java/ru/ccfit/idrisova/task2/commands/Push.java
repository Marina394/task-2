package ru.ccfit.idrisova.task2.commands;

import ru.ccfit.idrisova.task2.CalcException;
import ru.ccfit.idrisova.task2.Command;
import ru.ccfit.idrisova.task2.Context;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Push implements Command {
    private String parameter;

    public void calculate(Context context, List<String> parameters) throws CalcException {
        if(parameters.size() < 2)
            throw new CalcException("Not enough parameters in PUSH");
        parameter = parameters.get(1);
        if(context.isInListDefinition(parameter))
            context.push(context.getValue(parameter));
        else{
            char array[] = parameter.toCharArray();
            if(array[0] > '9' || array[0] < '0'){
                throw new CalcException("Not found parameter " + parameter);
            }
            double num = Double.parseDouble((parameter));
            context.push(num);
        }
    }
}

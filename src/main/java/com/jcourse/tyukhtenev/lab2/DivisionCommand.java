package com.jcourse.tyukhtenev.lab2;
import java.util.*;

public class DivisionCommand extends Command {
    public void execute(Stack<Double> stack, Map<String, Double> defineMap, String[] s){
        Double a, b, c;
        a = stack.pop();
        b = stack.pop();
        c = a / b; //Деление, возможно написать обработку деления на 0
        stack.push(c);
    }
}

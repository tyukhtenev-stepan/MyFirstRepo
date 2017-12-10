package com.jcourse.tyukhtenev.lab2.commands;

import com.jcourse.tyukhtenev.lab2.Command;

import java.util.Map;
import java.util.Stack;

public class SqrtCommand implements Command {
    public void execute(Stack<Double> stack, Map<String, Double> defineMap, String[] s){
        Double a, b;
        a = stack.pop();
        b = Math.sqrt(a); //Вычислим квадратный корень от числа
        stack.push(b);
    }
}

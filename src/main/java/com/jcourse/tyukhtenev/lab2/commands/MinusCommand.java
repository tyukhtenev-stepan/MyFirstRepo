package com.jcourse.tyukhtenev.lab2.commands;

import com.jcourse.tyukhtenev.lab2.Command;

import java.util.Map;
import java.util.Stack;

public class MinusCommand implements Command {
    public void execute(Stack<Double> stack, Map<String, Double> defineMap, String[] s) {
        Double a, b, c;
        a = stack.pop();
        b = stack.pop();
        c = a - b; // Вычислим разницу между двумя числами
        stack.push(c);
    }
}

package com.jcourse.tyukhtenev.lab2.stackcalc.commands;

import com.jcourse.tyukhtenev.lab2.stackcalc.Command;

import java.util.Map;
import java.util.Stack;

public class PlusCommand implements Command {
    public void execute(Stack<Double> stack, Map<String, Double> defineMap, String[] s) {
        Double a, b, c;
        a = stack.pop();
        b = stack.pop();
        c = a + b; // Сложение
        stack.push(c);
    }
}
package com.jcourse.tyukhtenev.lab2.stackcalc.commands;

import com.jcourse.tyukhtenev.lab2.stackcalc.Command;

import java.util.Map;
import java.util.Stack;

public class MinusCommand implements Command {
    public void execute(Stack<Double> stack, Map<String, Double> defineMap, String s) {
        Double a;
        Double b;
        System.out.println("-");
        a = stack.pop();
        b = stack.pop();
        stack.push(a - b);
    }

    public int getEnoughStackDepth() {
        return 2;
    }
}
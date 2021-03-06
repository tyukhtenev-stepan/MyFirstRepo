package com.jcourse.tyukhtenev.lab2.stackcalc.commands;

import com.jcourse.tyukhtenev.lab2.stackcalc.Command;

import java.util.Map;
import java.util.Stack;

public class SqrtCommand implements Command {
    public void execute(Stack<Double> stack, Map<String, Double> defineMap, String s) {
        double a;
        System.out.println("sqrt");
        if (stack.peek() < 0) {
            System.out.println("sqrt" + stack.peek());
            System.out.println("Стек содержит отрицательное число, извлечение корня невозможно");
            return;
        }
        a = stack.pop();
        stack.push(StrictMath.sqrt(a));
    }

    public int getEnoughStackDepth() {
        return 1;
    }
}
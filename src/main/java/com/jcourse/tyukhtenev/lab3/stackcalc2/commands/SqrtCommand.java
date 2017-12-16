package com.jcourse.tyukhtenev.lab3.stackcalc2.commands;

import com.jcourse.tyukhtenev.lab3.stackcalc2.Arg;
import com.jcourse.tyukhtenev.lab3.stackcalc2.Command;
import com.jcourse.tyukhtenev.lab3.stackcalc2.In;

import java.util.Stack;

public class SqrtCommand implements Command {
    @In(getArg = Arg.STACK)
    private Stack<Double> stack;

    public void execute(String string) {
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

    public int getEnoughParams() {
        return 1;
    }
}
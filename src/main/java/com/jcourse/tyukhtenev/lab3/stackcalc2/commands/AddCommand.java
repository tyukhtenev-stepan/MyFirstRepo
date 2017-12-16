package com.jcourse.tyukhtenev.lab3.stackcalc2.commands;

import com.jcourse.tyukhtenev.lab3.stackcalc2.Command;
import com.jcourse.tyukhtenev.lab3.stackcalc2.Arg;
import com.jcourse.tyukhtenev.lab3.stackcalc2.In;

import java.util.Stack;

public class AddCommand implements Command {
    @In(getArg = Arg.STACK)
    private Stack<Double> stack;

    public void execute(String s) {
        double a;
        double b;
        System.out.println("+");
        a = stack.pop();
        b = stack.pop();
        stack.push(a + b);
    }

    public int getEnoughParams() {
        return 2;
    }
}
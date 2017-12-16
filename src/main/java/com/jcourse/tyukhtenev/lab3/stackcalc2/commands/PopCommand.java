package com.jcourse.tyukhtenev.lab3.stackcalc2.commands;

import com.jcourse.tyukhtenev.lab3.stackcalc2.Arg;
import com.jcourse.tyukhtenev.lab3.stackcalc2.Command;
import com.jcourse.tyukhtenev.lab3.stackcalc2.In;

import java.util.Stack;

public class PopCommand implements Command {
    @In(getArg = Arg.STACK)
    private Stack<Double> stack;

    public void execute(String string) {
        System.out.println("pop");
        stack.pop();
    }

    public int getEnoughParams() {
        return 1;
    }
}
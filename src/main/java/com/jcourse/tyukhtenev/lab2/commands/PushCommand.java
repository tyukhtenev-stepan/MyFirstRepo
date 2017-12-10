package com.jcourse.tyukhtenev.lab2.commands;

import com.jcourse.tyukhtenev.lab2.Command;

import java.util.Map;
import java.util.Stack;

public class PushCommand implements Command {
    public void execute(Stack<Double> stack, Map<String, Double> defineMap, String[] s){
        Double d;
        d = defineMap.get(s[1]); //Достанем из defineMap значение для s[1]
        if (d == null) {
            d = Double.valueOf(s[1]);
        }
        stack.push(d);
    }
}

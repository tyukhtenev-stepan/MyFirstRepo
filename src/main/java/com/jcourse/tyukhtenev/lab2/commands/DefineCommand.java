package com.jcourse.tyukhtenev.lab2.commands;

import com.jcourse.tyukhtenev.lab2.Command;

import java.util.Map;
import java.util.Stack;

public class DefineCommand implements Command {
    public void execute(Stack<Double> stack, Map<String, Double> defineMap, String[] s) {
        Double d;
        String str;
        str = s[1];
        System.out.println("s[1]="+str);
        d = Double.valueOf(s[2]);
        System.out.println("d="+d);
        defineMap.put(str, d); //Положим в defineMap строку и её значение
    }
}

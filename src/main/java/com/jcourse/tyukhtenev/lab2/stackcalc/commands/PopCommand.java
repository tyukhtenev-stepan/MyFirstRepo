package com.jcourse.tyukhtenev.lab2.stackcalc.commands;

import com.jcourse.tyukhtenev.lab2.stackcalc.Command;

import java.util.Map;
import java.util.Stack;

public class PopCommand implements Command {
    public void execute(Stack<Double> stack, Map<String, Double> defineMap, String[] s){
        stack.pop();//Достанем один элемент из стэка
    }
}

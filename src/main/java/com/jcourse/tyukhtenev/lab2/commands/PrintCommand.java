package com.jcourse.tyukhtenev.lab2.commands;

import com.jcourse.tyukhtenev.lab2.Command;

import java.util.Map;
import java.util.Stack;

public class PrintCommand implements Command {
    public void execute(Stack<Double> stack, Map<String, Double> defineMap, String[] s) {
        if (stack.empty()) {
            System.out.println("Стек пуст");
        }
            else {
                System.out.println("peek=" + stack.peek());
            }



        stack.peek(); //Распечатаем головной элемент стэка
    }
}

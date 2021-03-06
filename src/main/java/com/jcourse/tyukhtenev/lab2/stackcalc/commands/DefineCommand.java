package com.jcourse.tyukhtenev.lab2.stackcalc.commands;

import com.jcourse.tyukhtenev.lab2.stackcalc.Command;

import java.util.Map;
import java.util.Stack;

public class DefineCommand implements Command {
    public void execute(Stack<Double> stack, Map<String, Double> defineMap, String s) {
        String words[] = s.split(" ");

        if (words.length < 3) {
            System.out.println("Недостаточно параметров для выполнения операции.");
            System.out.println("Введите имя и значение переменной.");
            return;
        }

        String commandName = words[0];
        String varName = words[1];
        String varValue = words[2];

        System.out.println(commandName + " " + varName + " " + varValue);

        try {
            if (Character.isDigit(varName.charAt(0))) {
                System.out.println("Имя переменной не может начинаться с цифры");
                return;
            }
            defineMap.put(varName, Double.parseDouble(varValue));
        } catch (NumberFormatException e) {
            System.out.println("Неверное значение переменной: " + varValue);
        }
    }

    public int getEnoughStackDepth() {
        return 0;
    }
}

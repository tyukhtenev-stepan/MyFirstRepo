package com.jcourse.tyukhtenev.lab2.stackcalc.commands;

import com.jcourse.tyukhtenev.lab2.stackcalc.Command;

import java.util.Map;
import java.util.Stack;

public class PushCommand implements Command {
    public void execute(Stack<Double> stack, Map<String, Double> defineMap, String s) {
        int i;
        String[] words = s.split(" ");
        for (String str : words) {
            System.out.print(str + " ");
        }
        System.out.print("\n");

        if (words.length < 2) {
            System.out.println("Недостаточно параметров для выполнения операции.");
            System.out.println("Введите значение или имя переменной.");
            return;
        }

        for (i = 1; i < words.length; i++)
            try {
                if (defineMap.containsKey(words[i])) {
                    words[i] = defineMap.get(words[i]).toString();
                }
                stack.push(Double.parseDouble(words[i]));
            } catch (NumberFormatException e) {
                System.out.println("Не могу положить в стек значение: " + words[i]);
            }
    }

    public int getEnoughStackDepth() {
        return 0;
    }
}

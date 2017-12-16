package com.jcourse.tyukhtenev.lab2.stackcalc;

import com.jcourse.tyukhtenev.lab2.stackcalc.commands.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class StackCalc {
    public static void main(String[] args) throws Exception {
        Stack<Double> stack = new Stack<>(); // стек для хранения значений
        Map<String, Command> commands = new HashMap<>(); // map для хранения команд
        String s; // строка для хранения конкретной команды
        Map<String, Double> defineMap = new HashMap<>(); // map для хранения переменных

        commands.put("push", new PushCommand());
        commands.put("pop", new PopCommand());
        commands.put("+", new AddCommand());
        commands.put("-", new MinusCommand());
        commands.put("*", new MultCommand());
        commands.put("/", new DivideCommand());
        commands.put("sqrt", new SqrtCommand());
        commands.put("#", new CommentCommand());
        commands.put("print", new PrintCommand());
        commands.put("define", new DefineCommand());

        System.out.println(commands.keySet());
        Scanner scanner = null;

        try {
            if (args.length != 0) {
                File file = new File(args[0]);
                scanner = new Scanner(file);
            } else {
                scanner = new Scanner(System.in);
            }

            while (true) {
                if (scanner.hasNextLine()) {
                    s = scanner.nextLine();
                } else {
                    scanner = new Scanner(System.in);
                    continue;
                }

                s = s.replaceAll("\\s+", " ");
                s = s.trim();

                if ("quit".equals(s)) {
                    System.out.println("Выход из приложения");
                    break;
                }

                String[] words = s.split(" ");
                String cmdName = words[0];

                if (commands.containsKey(cmdName)) {
                    Command x = commands.get(cmdName);
                    int enoughParams = x.getEnoughStackDepth();
                    if (stack.size() >= enoughParams) {
                        x.execute(stack, defineMap, s);
                    } else {
                        System.out.println("Недостаточно операндов в стеке.");
                        System.out.println("Требуется: >=" + enoughParams);
                        System.out.println("Стек содержит: " + stack.size());
                    }
                } else System.out.println("Неизвестная команда: " + cmdName);

                System.out.println(stack.toString());
                System.out.println(defineMap);
            }

        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
package com.jcourse.tyukhtenev.lab3.stackcalc2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class StackCalc2 {
    static Boolean isDebug = false; // Дебаг режим

    public static void main(String[] args) throws IOException {
        String s; // строка для хранения конкретной команды

        for (String arg : args) {
            if (arg.equals("debug")) {
                isDebug = true; // устанавливаем дебаг режим
            }
        }

        Factory factory = Factory.createFactory(); // создаем фабрику для команд калькулятора

        Scanner scanner = null;

        try {
            if (isDebug) {
                System.out.println("Start in debug mode");
                if (args.length >= 2) {
                    File file = new File(args[0]);
                    scanner = new Scanner(file);
                } else scanner = new Scanner(System.in);
            }

            if (!isDebug) {
                if (args.length != 0) {
                    File file = new File(args[0]);
                    scanner = new Scanner(file);
                } else scanner = new Scanner(System.in);
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

                if ("#".equals(cmdName)) {
                    cmdName = "/#";
                } // мы должны использовать "/#" вместо "#" в файле commands.properties и здесь мы конвертируем команду в название класса

                if (factory.existCommand(cmdName)) {
                    Command command = factory.getCommandByName(cmdName);
                    int enoughParams = command.getEnoughParams();
                    if (factory.getStack().size() >= enoughParams) {
                        command.execute(s);
                    } else {
                        System.out.println("Недостаточно операндов в стеке.");
                        System.out.println("Требуется: >=" + enoughParams);
                        System.out.println("Стек содержит: " + factory.getStack().size());
                    }
                } else {
                    System.out.println("Неизвестная команда: " + cmdName);
                }
                System.out.println(factory.getStack());
                System.out.println(factory.getVariables());
            }

        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

}
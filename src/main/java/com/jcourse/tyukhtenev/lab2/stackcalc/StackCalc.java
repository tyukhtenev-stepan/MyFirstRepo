package com.jcourse.tyukhtenev.lab2.stackcalc;

import com.jcourse.tyukhtenev.lab2.stackcalc.commands.*;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class StackCalc {
    public static void main(String[] args) throws FileNotFoundException {
        Stack<Double> stack = new Stack<>();
        Map<String, Double> vars = new HashMap<>();
        Map<String, Command> commands = new HashMap<>();
        String s;
        Scanner scanner = null;

        commands.put("PLUS", new PlusCommand());
        commands.put("COMMENT", new CommentCommand());
        commands.put("DEFINE", new DefineCommand());
        commands.put("DIVISION", new DivisionCommand());
        commands.put("MULT", new MultCommand());
        commands.put("POP", new PopCommand());
        commands.put("PRINT", new PrintCommand());
        commands.put("PUSH", new PushCommand());
        commands.put("SQRT", new SqrtCommand());
        commands.put("MINUS", new MinusCommand());

        scanner = new Scanner(System.in);

        vars.put("A", 2.);
        vars.put("B", 3.);

        while (scanner.hasNextLine()) {
            s = scanner.nextLine();
            String str[] = s.split(" ");
            if (commands.containsKey(str[0])){
                try {
                    commands.get(str[0]).execute(stack, vars, str);
                } catch (CalcException e){
                    e.printStackTrace();
                    System.out.println("Произошла ошибка!");
                }
            } else
                System.out.println("Нет такой команды");
        }
    }
}

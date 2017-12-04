package com.jcourse.tyukhtenev.lab2;
import java.util.*;

public class Invoker {
    public static void main(String[] args) {
        Stack<Double> stack = new Stack<>();

        Scanner scanner = new Scanner(System.in);
        String s;

        Map<String, Command> commands = new HashMap<>();
        Map<String, Double> vars = new HashMap<>();

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

        while (scanner.hasNextLine()) {
            s = scanner.nextLine();
            String str[] = s.split(" ");
            if (commands.containsKey(str[0])){
                commands.get(str[0]).execute(stack, vars, str);
            } else
                System.out.println("Нет такой команды");
        }
    }
}

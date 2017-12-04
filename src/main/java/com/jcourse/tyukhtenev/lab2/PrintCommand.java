package com.jcourse.tyukhtenev.lab2;
import java.util.*;

public class PrintCommand extends Command {
    public void execute(Stack<Double> stack, Map<String, Double> defineMap, String[] s) {
        System.out.println("peek="+stack.peek());
        stack.peek(); //Распечатаем головной элемент стэка
    }
}

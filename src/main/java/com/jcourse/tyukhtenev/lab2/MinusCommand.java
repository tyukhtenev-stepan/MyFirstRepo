package com.jcourse.tyukhtenev.lab2;
import java.util.*;

public class MinusCommand extends Command {
    public void execute(Stack<Double> stack, Map<String, Double> defineMap, String[] s) {
        Double a, b, c;
        a = stack.pop();
        b = stack.pop();
        c = a - b; // Вычислим разницу между двумя числами
        stack.push(c);
    }
}

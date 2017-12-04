package com.jcourse.tyukhtenev.lab2;
import java.util.*;

public class MultCommand extends Command {
    public void execute(Stack<Double> stack, Map<String, Double> defineMap, String[] s){
        Double a, b, c;
        a = stack.pop();
        b = stack.pop();
        c = a * b; // Умножение
        stack.push(c);
    }
}

package com.jcourse.tyukhtenev.lab2;
import java.util.*;

public class SqrtCommand extends Command {
    public void execute(Stack<Double> stack, Map<String, Double> defineMap, String[] s){
        Double a, b;
        a = stack.pop();
        b = Math.sqrt(a); //Вычислим квадратный корень от числа
        stack.push(b);
    }
}

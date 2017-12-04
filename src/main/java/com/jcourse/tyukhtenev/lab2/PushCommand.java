package com.jcourse.tyukhtenev.lab2;
import java.util.*;

public class PushCommand extends Command {
    public void execute(Stack<Double> stack, Map<String, Double> defineMap, String[] s){
        Double d;
        d = defineMap.get(s[1]); //Достанем из defineMap значение для s[1]
        stack.push(d);
    }
}

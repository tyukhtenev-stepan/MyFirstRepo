package com.jcourse.tyukhtenev.lab2;
import java.util.*;

public class PopCommand extends Command {
    public void execute(Stack<Double> stack, Map<String, Double> defineMap, String[] s){
        stack.pop();//Достанем один элемент из стэка
    }
}

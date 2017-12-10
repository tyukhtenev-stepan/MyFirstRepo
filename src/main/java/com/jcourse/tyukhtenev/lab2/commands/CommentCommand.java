package com.jcourse.tyukhtenev.lab2.commands;

import com.jcourse.tyukhtenev.lab2.Command;

import java.util.Map;
import java.util.Stack;

public class CommentCommand implements Command {
    public void execute(Stack<Double> stack, Map<String, Double> defineMap, String[] s){
        System.out.println("Комментарий"); //Обработка # должна быть
    }
}

package com.jcourse.tyukhtenev.lab2;

import java.util.Map;
import java.util.Stack;

public interface Command {
    void execute(Stack<Double> stack, Map<String, Double> defineMap, String[] s) throws CalcException;
}

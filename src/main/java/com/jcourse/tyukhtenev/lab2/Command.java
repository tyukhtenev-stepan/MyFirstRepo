package com.jcourse.tyukhtenev.lab2;
import java.util.*;

abstract class Command {
    abstract void execute(Stack<Double> stack, Map<String, Double> defineMap, String[] s);
}

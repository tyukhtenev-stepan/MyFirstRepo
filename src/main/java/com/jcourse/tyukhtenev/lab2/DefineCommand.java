package com.jcourse.tyukhtenev.lab2;
import java.util.*;

public class DefineCommand extends Command {
    public void execute(Stack<Double> stack, Map<String, Double> defineMap, String[] s) {
        Double d;
        String str;
        str = s[1];
        System.out.println("s[1]="+str);
        d = Double.valueOf(s[2]);
        System.out.println("d="+d);
        defineMap.put(str, d); //Положим в defineMap строку и её значение
    }
}

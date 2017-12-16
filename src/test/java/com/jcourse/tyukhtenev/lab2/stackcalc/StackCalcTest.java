package com.jcourse.tyukhtenev.lab2.stackcalc;
import org.junit.Test;

import com.jcourse.tyukhtenev.lab2.stackcalc.Command;
import com.jcourse.tyukhtenev.lab2.stackcalc.commands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StackCalcTest {

    Double a = 1d;
    Double b = -8d;
    Double c = 12d;

    Stack<Double> stack = new Stack<>();
    Map<String, Double> defineMap = new HashMap<>();

    Command push = new PushCommand();
    Command add = new AddCommand();
    Command minus = new MinusCommand();
    Command mult = new MultCommand();
    Command divide = new DivideCommand();
    Command define = new DefineCommand();
    Command sqrt = new SqrtCommand();

    @Test
    public void quadraticEquation1() {
        define.execute(stack, defineMap, "define a " + a);
        define.execute(stack, defineMap, "define b " + b);
        define.execute(stack, defineMap, "define c " + c);
        assert (defineMap.get("a").equals(a));
        assert (defineMap.get("b").equals(b));
        assert (defineMap.get("c").equals(c));

        push.execute(stack, defineMap,"push 2 a");
        mult.execute(stack, defineMap, "*");
        assert (stack.peek() == 2 * a);
        System.out.println(stack.peek());

        push.execute(stack, defineMap,"push 4 a c");
        mult.execute(stack, defineMap, "*");
        mult.execute(stack, defineMap, "*");
        assert (stack.peek() == 4 * a * c);
        System.out.println(stack.peek());

        push.execute(stack, defineMap,"push b b ");
        mult.execute(stack, defineMap, "*");
        minus.execute(stack, defineMap, "-");
        assert (stack.peek() == b * b - 4 * a * c);
        System.out.println(stack.peek());

        sqrt.execute(stack, defineMap, "sqrt");
        assert (stack.peek() == Math.sqrt(b * b - 4 * a * c));
        System.out.println(stack.peek());

        push.execute(stack, defineMap,"push b 0");
        minus.execute(stack, defineMap, "-");
        assert (stack.peek() == -b);
        System.out.println(stack.peek());

        minus.execute(stack, defineMap, "-");
        assert (stack.peek() == -b - Math.sqrt(b * b - 4 * a * c));
        System.out.println(stack.peek());

        divide.execute(stack, defineMap,"/");
        assert (stack.peek() == (-b - Math.sqrt(b * b - 4 * a * c)) / 2 * a);
        System.out.println("Первый ответ: " + stack.peek());
    }

    @Test
    public void quadraticEquation2() {
        define.execute(stack, defineMap, "define a " + a);
        define.execute(stack, defineMap, "define b " + b);
        define.execute(stack, defineMap, "define c " + c);
        assert (defineMap.get("a").equals(a));
        assert (defineMap.get("b").equals(b));
        assert (defineMap.get("c").equals(c));

        push.execute(stack, defineMap, "push 2 a");
        mult.execute(stack, defineMap, "*");
        assert (stack.peek() == 2 * a);
        System.out.println(stack.peek());

        push.execute(stack, defineMap, "push 4 a c");
        mult.execute(stack, defineMap, "*");
        mult.execute(stack, defineMap, "*");
        assert (stack.peek() == 4 * a * c);
        System.out.println(stack.peek());

        push.execute(stack, defineMap, "push b b ");
        mult.execute(stack, defineMap, "*");
        minus.execute(stack, defineMap, "-");
        assert (stack.peek() == b * b - 4 * a * c);
        System.out.println(stack.peek());

        sqrt.execute(stack, defineMap, "sqrt");
        assert (stack.peek() == Math.sqrt(b * b - 4 * a * c));
        System.out.println(stack.peek());

        push.execute(stack, defineMap, "push b 0");
        minus.execute(stack, defineMap, "-");
        assert (stack.peek() == -b);
        System.out.println(stack.peek());

        add.execute(stack, defineMap, "+");
        assert (stack.peek() == -b + Math.sqrt(b * b - 4 * a * c));
        System.out.println(stack.peek());

        divide.execute(stack, defineMap, "/");
        assert (stack.peek() == (-b + Math.sqrt(b * b - 4 * a * c)) / 2 * a);
        System.out.println("Второй ответ: " + stack.peek());
    }
}
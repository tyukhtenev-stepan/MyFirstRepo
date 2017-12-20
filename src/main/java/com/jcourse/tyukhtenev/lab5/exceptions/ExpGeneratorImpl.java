package com.jcourse.tyukhtenev.lab5.exceptions;

import java.util.Stack;

public class ExpGeneratorImpl implements ExceptionGenerator {
    @Override
    public void generateNullPointerException() {
        Stack stack = null;
        stack.peek();
    }

    @Override
    public void generateClassCastException() {
        Object x = new Integer (0);
        System.out.println((String) x);
    }

    @Override
    public void generateNumberFormatException() {
        String s = "a";
        Integer.parseInt(s);
    }

    @Override
    public void generateStackOverflowError() {
        while(true) {
            generateStackOverflowError();
        }
    }

    @Override
    public void generateOutOfMemoryError() {
        Stack stack = new Stack();
        ExpGeneratorImpl expGenerator = new ExpGeneratorImpl();
        stack.push(expGenerator);
    }

    @Override
    public void generateMyException(String message) throws MyException {
         throw new MyException(message);
    }
}

package com.jcourse.tyukhtenev.lab5.exceptions;

import java.util.Stack;

public class ExceptionImpl implements ExceptionGenerator {

    public void generateNullPointerException() {
        Stack stack = null;
        stack.peek();
    }

    public void generateClassCastException() {
        Object x = new Integer(0);
        System.out.println((String) x);
    }

    public void generateNumberFormatException() {
        String string = "a";
        Integer.parseInt(string);
    }

    public void generateStackOverFlowError() {
        while (true) {
            generateStackOverFlowError();
        }
    }

    public void generateOutOfMemoryError() {
        Stack stack = new Stack();
        while (true) {
            ExceptionImpl exceptionImplementation = new ExceptionImpl();
            stack.push(exceptionImplementation);
        }
    }

    public void generateMyException(String message) throws MyException {
        throw new MyException(message);
    }
}
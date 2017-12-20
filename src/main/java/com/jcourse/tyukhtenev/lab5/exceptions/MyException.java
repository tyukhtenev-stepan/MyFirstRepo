package com.jcourse.tyukhtenev.lab5.exceptions;

public class MyException extends Exception {

    public MyException(String message) {
    }

    public static void main(String[] args) {
        String message = "New string";
        ExpGeneratorImpl exception = new ExpGeneratorImpl();
        try {
            exception.generateStackOverflowError();
        } catch (StackOverflowError e) {
            //e.printStackTrace();
            System.out.println("StackOverflowError");
        }
        try {
            exception.generateClassCastException();
        } catch (ClassCastException e) {
            //e.printStackTrace();
            System.out.println("ClassCastException");
        }
        try {
            exception.generateNullPointerException();
        } catch (NullPointerException e) {
            //e.printStackTrace();
            System.out.println("NullPointerException");
        }
        try {
            exception.generateNumberFormatException();
        } catch (NumberFormatException e) {
            //e.printStackTrace();
            System.out.println("NumberFormatException");
        }
        try {
            exception.generateOutOfMemoryError();
        } catch (OutOfMemoryError e) {
            //e.printStackTrace();
            System.out.println("OutOfMemoryError");
        }
        try {
            exception.generateMyException(message);
        } catch (MyException e) {
            //e.printStackTrace();
            System.out.println("MyException");
        }
    }
}

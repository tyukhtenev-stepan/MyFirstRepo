package com.jcourse.tyukhtenev.lab5.exceptions;

public class ExceptionMain {
    public static void main(String[] args) {
        String message = "Test message";

        ExceptionGenerator exception = new ExceptionImpl();
        try {
            exception.generateNullPointerException();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        try {
            exception.generateClassCastException();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }

        try {
            exception.generateNumberFormatException();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        try {
            exception.generateStackOverFlowError();
        } catch (StackOverflowError e) {
            e.printStackTrace();
        }

        try {
            exception.generateOutOfMemoryError();
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }

        try {
            exception.generateMyException(message);
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
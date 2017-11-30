package com.jcourse.tyukhtenev.lab1;

public class MyClass {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        System.out.println(myClass.getClass().getSimpleName());
        System.out.println(myClass.getClass().getCanonicalName());
        System.out.println(myClass.getClass().getName());
    }
}
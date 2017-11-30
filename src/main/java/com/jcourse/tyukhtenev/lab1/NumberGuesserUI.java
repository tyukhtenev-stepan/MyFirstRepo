package com.jcourse.tyukhtenev.lab1;

import java.util.Scanner;

// Игра "Угадай число"
public class NumberGuesserUI {
    public static void main(String[] args) {

        int numberAttempt; //Количество попыток
        int enteredNumber; //Введенное число
        int randomNumber;

        NumberGuesserLogic numberGuesserLogic = new NumberGuesserLogic();
        numberGuesserLogic.counter = 0;
        //Загадаем число
        randomNumber = numberGuesserLogic.MakeNumber();
        //Зададим количество попыток
        numberAttempt = numberGuesserLogic.NumberAttempts(8);

        System.out.println("Игра \"Угадай число\". Угадайте простое число от 1 до 100. У вас всего 8 попыток.");

        Scanner in = new Scanner(System.in); //Считывать будем входящий поток

        while (numberGuesserLogic.counter <= numberAttempt) {
            try {
                numberGuesserLogic.counter++;
                System.out.println("Попытка "+numberGuesserLogic.counter+": ");
                enteredNumber = Integer.parseInt(in.nextLine());

            if (enteredNumber < randomNumber) {
                System.out.println("Загаданное число БОЛЬШЕ вашего числа: "+enteredNumber);
            } else if (enteredNumber > randomNumber) {
                System.out.println("Загаданное число МЕНЬШЕ вашего числа: "+enteredNumber);
            } else if (enteredNumber == randomNumber) {
                System.out.println("Вы угадали! Загаданное число РАВНО вашему числу: "+enteredNumber);
                break;
            }
            if (numberGuesserLogic.counter == numberAttempt) {
                System.out.println("Попытки закончились. Загаданное число: "+randomNumber);
                break;
            }
        } catch (NumberFormatException ex) {
                System.out.println("Вы ввели не число, введите пожалуйста простое число от 1 до 100.");
            }
        }
    }
}
package com.jcourse.tyukhtenev.lab1;

import java.util.Random;

public class NumberGuesserLogic {
    public int counter; //Счетчик попыток

    public int MakeNumber() {
        int randomNumber = new Random().nextInt(100);
        return randomNumber;
    }
    public int NumberAttempts(int numberAttempts) {
        return numberAttempts;
    }
}

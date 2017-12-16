package com.jcourse.tyukhtenev.lab3.stackcalc2;

public interface Command {
    //Выполнить команду калькулятора
    void execute(String string);

    //Получить достаточное количество параметров из стэка для выполнения команды
    int getEnoughParams();
}

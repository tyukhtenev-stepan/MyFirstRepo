package com.jcourse.tyukhtenev.lab3.stackcalc2.commands;

import com.jcourse.tyukhtenev.lab3.stackcalc2.Command;

public class CommentCommand implements Command {
    public void execute(String string) {
        System.out.println(string);
    }

    public int getEnoughParams() {
        return 0;
    }
}
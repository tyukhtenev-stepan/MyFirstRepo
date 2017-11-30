package com.jcourse.tyukhtenev.lab1;

import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Scanner;
import static java.nio.charset.Charset.*;

public class Echo {
    public static void main(String[] args) {
        //InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(s);
        // while (s != null|| !s.equals("exit")){// в equals может быть quit
        //    s = scanner.nextLine();
        //    System.out.println(s);
        //}

        System.out.println(System.getProperty("file.encoding"));
        String s3 = new String("my string".getBytes(), Charset.forName("UTF-8"));
        System.out.println(s3);
    }
}
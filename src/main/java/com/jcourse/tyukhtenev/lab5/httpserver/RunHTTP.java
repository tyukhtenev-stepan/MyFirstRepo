package com.jcourse.tyukhtenev.lab5.httpserver;

public class RunHTTP {
    public static void main(String[] args) {
        HTTPServer server = new HTTPServer();

        //       http://localhost:8080
        //TODO Сервер в качестве аргумента принимает адрес на серве
        //TODO юзер вводит локалхост8080 и видит эту дирректорию

        try {
            server.runHTTPServer();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
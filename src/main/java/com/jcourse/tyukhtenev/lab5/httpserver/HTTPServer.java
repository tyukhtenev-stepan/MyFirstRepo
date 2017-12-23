package com.jcourse.tyukhtenev.lab5.httpserver;

public class HTTPServer {
    public static void main(String[] args) throws Throwable {
        int port = 8080;
        String path = "\\";
        if (args.length >= 1) {
            port = Integer.parseInt(args[0]);
            path = args[1];

        } else System.out.println("Укажите параметры запуска: порт, директорию сервера");
        RequestHandler requestHandler = new RequestHandler(port, path);
        requestHandler.listen();
    }
}
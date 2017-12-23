package com.jcourse.tyukhtenev.lab5.httpserver;

import java.net.ServerSocket;
import java.net.Socket;

public class RequestHandler {
    private int port;
    private String path;

    public RequestHandler(int port, String path) {
        this.port = port;
        this.path = path;
    }

    public void listen() throws Throwable {
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            Thread thread = new Thread(new SocketProcessor(clientSocket, path));
            thread.start();
        }
    }
}
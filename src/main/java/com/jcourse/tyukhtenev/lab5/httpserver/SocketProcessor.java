package com.jcourse.tyukhtenev.lab5.httpserver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class SocketProcessor implements Runnable {
    private HTMLFileGen htmlFileGen;
    private Socket s;
    private InputStream is;
    private OutputStream os;

    SocketProcessor(Socket s, String path) throws Throwable {
        this.s = s;
        this.is = s.getInputStream();
        this.os = s.getOutputStream();
    }

    public void run() {
        try {
            readInputHeaders();
//                writeResponse("<html><body><h1>111</h1></body></html>\r\n\r\n");

        } catch (Throwable t) {
            /*do nothing*/
        } finally {
            try {
                s.close();
            } catch (Throwable t) {
                /*do nothing*/
            }
        }
        System.err.println("Client processing finished");
    }

    private void writeResponse(String s) throws Throwable {
//            String response = "HTTP/1.1 404 Not Found\r\n";
//            String response = "HTTP/1.1 200 OK\r\n";
        // + "Server: YarServer/2009-09-09\r\n" + "Content-Type: text/html\r\n" + "Content-Length: " + s.length() + "\r\n" + "Connection: close\r\n\r\n";
        String result = s;
        os.write(result.getBytes());
        os.flush();
    }

    private void readInputHeaders() throws Throwable {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String s;
        while (true) {
            s = br.readLine();
            if (s == null || s.trim().length() == 0) {
                break;
            }
        }
        String[] line = s.split(" ");

        if (line[0].equals("GET")){
            htmlFileGen = new HTMLFileGen(line);
            htmlFileGen.generateHTML();
        } else if (line[0].equals("HEAD")){
            System.out.println("ПОКА НЕ РЕАЛИЗОВАНО! xD");
        } else {
            writeResponse("HTTP/1.1 501 Not Implemented\r\n");
            writeResponse("Content-Type: text/html; charset=UTF-8\r\n\r\n");
            writeResponse("<html><body><h1>Неизвестная команда</h1></body></html>\r\n");
        }
    }
}
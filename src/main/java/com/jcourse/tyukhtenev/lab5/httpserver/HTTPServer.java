package com.jcourse.tyukhtenev.lab5.httpserver;

import javax.activation.MimetypesFileTypeMap;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HTTPServer {

    public void runHTTPServer() throws Throwable {
        ServerSocket ss = new ServerSocket(8080);

        while (true) {
            Socket s = ss.accept();
            System.err.println("Client accepted");
            new Thread(new SocketProcessor(s)).start();
        }
    }

    private static class SocketProcessor implements Runnable {
        private HTMLFileGen htmlFileGen;
        private Socket s;
        private InputStream is;
        private OutputStream os;

        private SocketProcessor(Socket s) throws Throwable {
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
          String result = s;
            os.write(result.getBytes());
            os.flush();
        }

        private void readInputHeaders() throws Throwable {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String s;
            StringBuilder sb = new StringBuilder();
            while (true) {
                s = br.readLine();
                System.out.println(s);
                sb.append(s);
                if (s == null || s.trim().length() == 0) {
                    break;
                }
            }
            String[] line = sb.toString().split(" ");
            System.out.println("line[0] - " + line[0]);
            System.out.println("line[1] - " + line[1]);
            char[] arrayChar = line[1].toCharArray();

            if (arrayChar[arrayChar.length-1] != '/' && line[0].equals("GET")) {
                String fileName = line[1].substring(1);

                File file = new File(fileName);
                String ContentType = new MimetypesFileTypeMap().getContentType(file);

                writeResponse("HTTP/1.1 200 OK\r\n");
                writeResponse("Content-Type: " + ContentType + " Content-Length: "+ file.length()+"\r\n\r\n");
                System.out.println("аываы");
                os.write(Files.readAllBytes(Paths.get(fileName)));
                os.flush();

            }
            else if (line[1].equals("/") && line[0].equals("GET")) {
                writeResponse("HTTP/1.1 200 OK\r\n");
                writeResponse("Content-Type: text/html; charset=UTF-8\r\n\r\n");
                htmlFileGen = new HTMLFileGen(line, false);
                writeResponse(htmlFileGen.generate());
            } else if (line[0].equals("GET")) {
                writeResponse("HTTP/1.1 200 OK\r\n");
                writeResponse("Content-Type: text/html; charset=UTF-8\r\n\r\n");
                htmlFileGen = new HTMLFileGen(line, true);
                writeResponse(htmlFileGen.generate());
            } else if (line[0].equals("HEAD")){
                System.out.println("ПОКА НЕ РЕАЛИЗОВАНО! xD");
            } else {
                writeResponse("HTTP/1.1 501 Not Implemented\r\n");
                writeResponse("Content-Type: text/html; charset=UTF-8\r\n\r\n");
                writeResponse("<html><body><h1>Неизвестная команда</h1></body></html>\r\n");
            }
        }
    }
}
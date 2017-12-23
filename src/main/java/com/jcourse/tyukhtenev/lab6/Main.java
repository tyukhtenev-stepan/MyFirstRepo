package com.jcourse.tyukhtenev.lab6;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.sql.*;

public class Main {
    public static void main(String[] args){
        Connection connection = null;
        String driver = "jdbc:h2:mem:mydatabase";
        String user = "user1";
        String password = "password1";
        Statement statement = null;
        String query;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(driver, user, password);
            statement = connection.createStatement();
            query = "CREATE TABLE POSTS(ID INT PRIMARY KEY, POST_DATE TIMESTAMP, POST_MESSAGE VARCHAR(255))";
            statement.execute(query);
            statement.execute("INSERT INTO POSTS(ID, POST_MESSAGE) VALUES (1, 'something')");
            ResultSet rs = statement.executeQuery("SELECT ID, POST_MESSAGE FROM POSTS");
            while (rs.next()) {
                System.out.println("id: " + rs.getInt("ID"));
                System.out.println("message: " + rs.getString("POST_MESSAGE"));
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Ошибка");
        }
    }
}

package com.urena.postit.postit;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

    public static void main(String[] args) {


        try {

            String jdbcUrl = "jdbc:mysql://localhost:3306/post-it-db?useSSL=false&serverTimezone=UTC";

            System.out.println("Connecting to database: " + jdbcUrl);

            Connection myConn =
                    DriverManager.getConnection(jdbcUrl,"root","1234");

            System.out.println("Connection successful!!!");

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }
}

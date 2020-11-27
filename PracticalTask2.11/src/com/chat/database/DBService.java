package com.chat.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {

    private DBService() {
    }

    public static Connection getConnection() {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/chat?user=root&password=");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return conn;
    }

}

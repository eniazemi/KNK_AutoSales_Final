package com.example.enifinal.database;

import java.sql.*;

public class DBConnect {

    int port = 3306;
    String db_name = "knk_project";
    String user = "root";
    String user_pw = "root123";
    Connection connection = null;

    public DBConnect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/" + db_name, user, user_pw);
    }

    public Connection getConnection() {
        return this.connection;
    }
}
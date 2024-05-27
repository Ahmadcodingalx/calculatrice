package org.example.calculatrice.dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    static String host = "localhost";
    static String port = "3306";
    static String username = "root";
    static String password = "";
    static String database = "historique";
    static String URL = "jdbc:mysql://"+host+":"+port+"/"+database;

    public static Connection connectDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
//            throw new RuntimeException(e);
        }
    }

}

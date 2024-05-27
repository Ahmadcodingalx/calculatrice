package org.example.calculatrice.dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface IDBConfig {
    static String host = "localhost";
    static String port = "3306";
    static String username = "root";
    static String password = "";
    static String database = "historique";
    static String URL = "jdbc:mysql://"+host+":"+port+"/"+database;

    static Connection getConnection() {
        try{
            return DriverManager.getConnection(URL, username, password);
        } catch (SQLException e) {
            return null;
        }
    }
}

package com.Bgrupo4.hospitalupskill.imagem;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    static Connection connection = null;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jbdc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_centrohospitalar", "root", "root");
        } catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}

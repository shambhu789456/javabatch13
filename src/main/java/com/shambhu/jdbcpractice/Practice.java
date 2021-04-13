package com.shambhu.jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Practice {
    public static final String DRIVER_NAME ="com.mysql.cj.jdbc.Driver";
    public static final String URL_NAME = "jdbc:mysql://localhost:3306/?serverTimezone=UTC";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "Shambhu12345$";
    public static final String MYSQl = "create database practice";

    public static void main(String[] args) {
        Connection con = null;
        Statement st= null;
        try {
            // 1. register the driver
            Class.forName(DRIVER_NAME);
            // 2. obtain connection
            con= DriverManager.getConnection(URL_NAME,USER_NAME,PASSWORD);
            // 3. obtain statement object
            st= con.createStatement();
            // 4. execute the query
            st.executeUpdate(MYSQl);
            System.out.println("database created");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                //5. close connection
                con.close();
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

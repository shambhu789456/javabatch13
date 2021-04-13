package com.shambhu.jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreate {
    public static final String DRIVER_NAME ="com.mysql.cj.jdbc.Driver";
    public static final String URL_NAME = "jdbc:mysql://localhost:3306/practice?serverTimezone=UTC";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "Shambhu12345$";
    public static final String MYSQl = "create table user_table( ID int not null auto_increment, User_name varchar(45),Password varchar(45), primary key(ID))";

    public static void main(String[] args) {
        Connection con=null;
        Statement st= null;
        try {
            Class.forName(DRIVER_NAME);
            con= DriverManager.getConnection(URL_NAME,USER_NAME,PASSWORD);
            st= con.createStatement();
            st.executeUpdate(MYSQl);
            System.out.println("table created");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

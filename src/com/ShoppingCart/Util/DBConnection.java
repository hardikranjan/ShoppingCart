package com.ShoppingCart.Util;

/**
 * Created by hardikranjan on 17/02/17.
 */
import com.ShoppingCart.DAO.DAOUser;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection
{
    public static Connection getConnection() throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ShoppingCart","root","password");
        return con;
    }
}
package com.ShoppingCart.DAO;
/**
 * Created by hardikranjan on 20/02/17.
 */

import com.ShoppingCart.Domain.DomainUser;
import com.ShoppingCart.Util.*;
import java.sql.*;

public class DAOUser implements DAO_Users {
    public void insert(DomainUser obj) throws Exception {

        Connection con = DBConnection.getConnection();
        String name = obj.getName();
        String email = obj.getEmail();
        String address = obj.getAddress();

        PreparedStatement preparedStatement = con.prepareStatement("insert into Users (UsersName,UsersEmailId,UsersAddress) values (?,?,?)");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, email);
        preparedStatement.setString(3, address);
        preparedStatement.executeUpdate();

        con.close();
    }

    public int getById(int id) throws Exception {
        Connection con = DBConnection.getConnection();

        PreparedStatement preparedStatement = con.prepareStatement("select * from Users where UsersId=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next())
            return 1;
        else
            return 0;
    }

    public void deleteById(int id) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement("delete from Users where UsersId=?");
        preparedStatement.setInt(1,id);
        boolean resultSet = preparedStatement.execute();
    }

}



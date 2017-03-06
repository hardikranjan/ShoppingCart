package com.ShoppingCart.DAO;

import com.ShoppingCart.Domain.*;
import com.ShoppingCart.Util.*;
import java.sql.*;
/**
 * Created by hardikranjan on 21/02/17.
 */
public class DAOProduct implements DAOProductt {
    public void insert(DomainProduct obj) throws Exception {
        Connection con = DBConnection.getConnection();
        String name = obj.getProductname();
        int initialprice = obj.getProductunitprice();
        int quantity = obj.getProductquantity();

        PreparedStatement pst = con.prepareStatement("insert into Products (ProductsName,ProductsQuantity,ProductsInitialPrice) values (?,?,?)");
        pst.setString(1, name);
        pst.setInt(2, quantity);
        pst.setInt(3, initialprice);
        pst.execute();
    }

    public void updateById(int id, int qty) throws Exception {

        Connection con = DBConnection.getConnection();
        String query = "update Products set ProductsQuantity = ? where ProductsId = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, qty);
        pst.setInt(2, id);

        pst.executeUpdate();
    }

    public DomainProduct getById(int id) throws Exception {
        String query = "select * from Products where ProductsId=?";

        Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, id);
        DomainProduct domainProduct = new DomainProduct();
        ResultSet resultSet = pst.executeQuery();
        if (resultSet.next()) {
            domainProduct.setProductid(resultSet.getInt(1));
            domainProduct.setProductname(resultSet.getString(2));
            domainProduct.setProductquantity(resultSet.getInt(3));
            domainProduct.setProductunitprice(resultSet.getInt(4));
        }
        return domainProduct;
    }

    public int getProductById(int id) throws Exception {
        Connection con = DBConnection.getConnection();

        PreparedStatement preparedStatement = con.prepareStatement("select * from Products where ProductsId=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next())
            return 1;
        else
            return 0;
    }

    public void deleteById(int id) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement("delete from Products where ProductsId=?");
        preparedStatement.setInt(1, id);
        boolean resultSet = preparedStatement.execute();
    }
}

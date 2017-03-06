package com.ShoppingCart.DAO;
import com.ShoppingCart.Domain.*;
import com.ShoppingCart.Util.*;
import com.ShoppingCart.Services.*;
import java.util.ArrayList;
import java.sql.*;
/**
 * Created by hardikranjan on 21/02/17.
 */

//Returns an array of integer type for the Product_id and Quantity
public class DAOBill
{
    public ArrayList<Integer> Billdetail(int orderid) throws Exception
    {
        ArrayList<Integer> arraylist = new ArrayList<>();
        Connection con = DBConnection.getConnection();

        String query="select * from orderDetails where OrdersId= ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,orderid);
        ps.execute();

        ResultSet resultSet = ps.executeQuery();
        while(resultSet.next())
        {
            int id = resultSet.getInt("OrderProductsId");
            int quantity = resultSet.getInt("OrderDetailsQuantity");
            arraylist.add(quantity);
            arraylist.add(id);
        }
        ps.close();
        con.close();
        return arraylist;
    }
}

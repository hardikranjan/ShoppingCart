package com.ShoppingCart.DAO;
import com.ShoppingCart.Domain.*;
import com.ShoppingCart.Util.*;
import java.sql.*;
import java.util.Date;
/**
 * Created by hardikranjan on 21/02/17.
 */

public class DAOOrder implements DAO_Orders
{
    public int place(DomainOrder domainOrder) throws Exception
    {
        Connection con = DBConnection.getConnection();

        int userId = domainOrder.getOrderUserId(); // Calling DomainOrder to get userId
        String status = domainOrder.getStatus();

        Timestamp t=new Timestamp(new Date().getTime());//For Present Date

        String query = "insert into Orders (OrdersUsersId,OrdersCreatedDate,OrdersStatus) values (?,?,?)";
        //Insert values into database for orders table
        int odrId = 0;

        PreparedStatement pst = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        //Return_Generated_Keys to return the Order_Id
        pst.setInt(1, userId);
        pst.setTimestamp(2,t);
        pst.setString(3, status);
        pst.executeUpdate();
        ResultSet resultSet = pst.getGeneratedKeys();

        if(resultSet.next())
        {
            odrId = resultSet.getInt(1);
        }

        return odrId;
    }

    public int getOrderById(int id) throws Exception {
        Connection con = DBConnection.getConnection();

        PreparedStatement preparedStatement = con.prepareStatement("select * from Orders where OrdersId=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next())
            return 1;
        else
            return 0;
    }

    public void deleteById(int id) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement("delete from Orders where OrdersId=?");
        preparedStatement.setInt(1, id);
        boolean resultSet = preparedStatement.execute();
    }
}

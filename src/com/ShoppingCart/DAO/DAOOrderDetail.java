package com.ShoppingCart.DAO;

import com.ShoppingCart.Domain.DomainOrderDetail;
import com.ShoppingCart.Domain.DomainProduct;
import com.ShoppingCart.Util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by hardikranjan on 21/02/17.
 */
//Inserting values in Order_Detail Database
public class DAOOrderDetail implements DAO_OrderDetail
{
    public void placed(DomainOrderDetail domainOrderDetail) throws Exception {
        Connection con = DBConnection.getConnection();

        int id = domainOrderDetail.getOrderId();
        int productid = domainOrderDetail.getProductid();
        int quantity = domainOrderDetail.getOrderdetailquantity();

        PreparedStatement preparedStatement = con.prepareStatement("select OrderDetailsQuantity from orderDetails where orderProductsId=? and OrdersId=?");
        preparedStatement.setInt(1,productid);
        preparedStatement.setInt(2,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){

            int qty = resultSet.getInt(1);
            qty = qty + quantity;
            updateQuantity(domainOrderDetail,qty,productid);
        }
        else{
            PreparedStatement preparedStatement1 = con.prepareStatement("insert into orderDetails (OrdersId,OrderProductsId,OrderDetailsQuantity) values (?,?,?)");
            preparedStatement1.setInt(1, id);
            preparedStatement1.setInt(2, productid);
            preparedStatement1.setInt(3,quantity);

            preparedStatement1.execute();
        }
    }
    public void updateQuantity(DomainOrderDetail domainOrderDetail,int quantity,int productid) throws Exception{
        Connection con = DBConnection.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement("update orderDetails set OrderDetailsQuantity=? where OrderProductsId=?");
        preparedStatement.setInt(1,quantity);
        preparedStatement.setInt(2,productid);

        int resultSet = preparedStatement.executeUpdate();
    }

}

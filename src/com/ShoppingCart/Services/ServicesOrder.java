package com.ShoppingCart.Services;
import com.ShoppingCart.DAO.*;
import com.ShoppingCart.Domain.*;
import com.ShoppingCart.Util.DBConnection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * Created by hardikranjan on 20/02/17.
 */

public class ServicesOrder implements serviceorder
{
    Scanner sc = new Scanner(System.in);
    public void addorder() throws Exception
    {
        String cvorder = "src/com/ShoppingCart/Util/order.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(cvorder));

        String space="";
        String comma=",";

        String addrow = bufferedReader.readLine();
        int userId = Integer.parseInt(addrow);

        DomainOrder domainOrder = new DomainOrder();
        domainOrder.setOrderuserid(userId);
        domainOrder.setStatus("Confirmed");

        int orderId = 0;

        DAOOrder daoOrder = new DAOOrder();
        try {
            orderId = daoOrder.place(domainOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ServicesOrderDetail servicesOrderDetail = new ServicesOrderDetail();
        servicesOrderDetail.place(orderId);
    }

    // Remove Order From Database with Id
    public void removeOrder() throws Exception{

        Connection connection = DBConnection.getConnection();
        int orderId = 12; // Order with this orderId is to be removed from Order Table

        PreparedStatement preparedStatement = connection.prepareStatement("select * from Orders");
        ResultSet resultSet = preparedStatement.executeQuery();
        int check=0;
        do
        {
            DAOOrder daoOrder = new DAOOrder();
            int flag = daoOrder.getOrderById(orderId);
            if(flag == 1){
                daoOrder.deleteById(orderId);
                check=1;
            }
            else {
                System.out.println("Order does not Exist");
            }
        }while(check!=1);
    }



}

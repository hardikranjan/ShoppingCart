package com.ShoppingCart.Services;
import com.ShoppingCart.DAO.DAOProduct;
import com.ShoppingCart.DAO.DAOUser;
import com.ShoppingCart.Domain.DomainProduct;
import com.ShoppingCart.Util.DBConnection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.*;

/**
 * Created by hardikranjan on 20/02/17.
 */


public class ServicesProduct implements serviceproduct
{
    Scanner sc = new Scanner(System.in);
    public void addProduct() throws Exception {
        String csv ="src/com/ShoppingCart/Util/product.txt";

        BufferedReader bufferedReader =new BufferedReader(new FileReader(csv));
        DAOProduct daoProduct=new DAOProduct();

        String space="";
        String comma=",";
        DomainProduct domainProduct= new DomainProduct();
        while((space=bufferedReader.readLine())!=null)
        {
            String[] str = space.split(comma);
            domainProduct.setProductname(str[1]);
            domainProduct.setProductquantity(Integer.parseInt(str[2]));
            domainProduct.setProductunitprice(Integer.parseInt(str[3]));
            daoProduct.insert(domainProduct);
        }
        System.out.println("Products Added in Database");
    }

    public void updateById(int id,int qty) throws  Exception{
        DAOProduct daoProduct= new DAOProduct();
        daoProduct.updateById(id,qty);
    }

    public DomainProduct getById(int id) throws Exception{
        DAOProduct daoProduct = new DAOProduct();
        return daoProduct.getById(id);
    }

    public void deleteProduct() throws Exception{

        Connection con = DBConnection.getConnection();
        System.out.println("Existing Products:- ");
        PreparedStatement preparedStatement = con.prepareStatement("select * from Products");
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            System.out.print(resultSet.getInt(1)+ " ");
            System.out.println(resultSet.getString(2));
        }
        int check=0;
        do
        {
            System.out.println("Enter Id of product to delete");
            int id = sc.nextInt();
            DAOProduct daoProduct = new DAOProduct();
            int flag = daoProduct.getProductById(id);
            if(flag == 1){
                daoProduct.deleteById(id);
                check=1;
            }
            else
            {
                System.out.println("Product donot Exist");
            }
        }while(check!=1);
    }

    public void displayProduct() throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement("select * from Products");
        ResultSet resultSet = preparedStatement.executeQuery();

    }
}

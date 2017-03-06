package com.ShoppingCart.Services;
import com.ShoppingCart.Clients.*;
import com.ShoppingCart.DAO.DAOUser;
import com.ShoppingCart.Domain.DomainUser;
import com.ShoppingCart.Util.*;
import java.util.*;
/**
 * Created by hardikranjan on 20/02/17.
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import  java.util.List;

public class ServicesUser implements serviceuser
{
    Scanner sc = new Scanner(System.in);
    public void userAdd() throws Exception
    {
        String cvuser = "src/com/ShoppingCart/Util/user.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(cvuser));
        DAOUser daoUser = new DAOUser();
        String space="";
        String comma=",";
        DomainUser domainUser = new DomainUser();
        while((space=bufferedReader.readLine())!=null)
        {
            String[] str = space.split(comma);

            domainUser.setName(str[1]);
            domainUser.setEmail(str[2]);
            domainUser.setAddress(str[3]);
            daoUser.insert(domainUser);
        }
        System.out.println("Users Added in Database");
    }

    public void removeUser() throws Exception{

        Connection con = DBConnection.getConnection();
        System.out.println("Existing Users:- ");
        PreparedStatement preparedStatement = con.prepareStatement("select * from Users");
        ResultSet resultSet = preparedStatement.executeQuery();

        int check=0;
        do
        {
            System.out.println("Enter Id of user to delete");
            int id = sc.nextInt();
            DAOUser daoUser = new DAOUser();
            int flag = daoUser.getById(id);
            if(flag == 1){
                daoUser.deleteById(id);
                check=1;
            }
            else
            {
                System.out.println("User donot Exist");
            }
        }while(check!=1);
    }


    public void displayUser() throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement("select * from Users");
        ResultSet resultSet = preparedStatement.executeQuery();

    }
}

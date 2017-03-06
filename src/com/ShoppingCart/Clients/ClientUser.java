package com.ShoppingCart.Clients;

import com.ShoppingCart.Services.ServicesOrder;
import com.ShoppingCart.Services.ServicesUser;
import java.util.*;
/**
 * Created by hardikranjan on 20/02/17.
 */


//EXECUTE USER CODE FOR ADDING USERS
public class ClientUser
{
    public static void main(String[] arg) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Press:  1 Adding User to database \n 2 Removing User from database");
        int choice  = sc.nextInt();
        ServicesUser serviceUser = new ServicesUser();

        if(choice==1) {
            try {
                serviceUser.userAdd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(choice==2){
            serviceUser.removeUser();
            System.out.println("User Removed");
        }
        else if(choice==3){
            serviceUser.displayUser();
        }
    }
}

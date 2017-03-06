package com.ShoppingCart.Clients;

import com.ShoppingCart.Services.ServicesBill;
import com.ShoppingCart.Services.ServicesOrder;
import java.io.IOException;
import java.util.*;
/**
 * Created by hardikranjan on 20/02/17.
 */


public class ClientOrder {
    public static void main(String[] args) throws Exception {

        //This is the main through which Order is placed and CSV File (Bill.csv) is created in UTIL PACKAGE
        Scanner sc = new Scanner(System.in);

        System.out.println("Press:  1 Add Order  \n 2 Remove Order");
        int choice = sc.nextInt();
        System.out.println("Enter Your Choice");
        ServicesOrder servicesOrder = new ServicesOrder();
        if (choice == 1) {
            try {
                servicesOrder.addorder();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (choice == 2) {
            try {
                servicesOrder.removeOrder();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}

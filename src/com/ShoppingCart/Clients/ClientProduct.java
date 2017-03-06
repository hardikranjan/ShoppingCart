package com.ShoppingCart.Clients;

import com.ShoppingCart.Domain.DomainProduct;
import com.ShoppingCart.Services.ServicesProduct;
import com.ShoppingCart.Services.ServicesUser;
import java.util.Scanner;

/**
 * Created by hardikranjan on 20/02/17.
 */


//EXECUTE USERS CODE FOR ADDING PRODUCTS
public class ClientProduct
{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Press:  1 Adding Product to database \n 2 Removing Product from database \n 3 Display existing Products");
        int choice  = sc.nextInt();
        ServicesProduct servicesProduct = new ServicesProduct();
        if(choice==1) {
            try {
                servicesProduct.addProduct();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(choice==2){
            servicesProduct.deleteProduct();
            System.out.println("Product Removed");
        }
        else if(choice==3){
            servicesProduct.displayProduct();
        }

    }
}

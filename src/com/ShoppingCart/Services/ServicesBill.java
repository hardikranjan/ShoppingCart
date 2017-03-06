package com.ShoppingCart.Services;
import com.ShoppingCart.Domain.*;
import com.ShoppingCart.Util.*;
import com.ShoppingCart.DAO.*;
import java.io.*;
import com.ShoppingCart.Clients.*;
import java.util.ArrayList;

/**
 * Created by hardikranjan on 21/02/17.
 */
//Writting in CSV File

public class ServicesBill
{
    public void billgenerate(int orderId) throws Exception
    {
        File file = new File("src/com/ShoppingCart/Util/Bill.csv");
        DAOBill daoBill =new DAOBill();
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String productname="";
        int price=0,productquantity=0,productprice=0;

        ServicesProduct servicesProduct = new ServicesProduct();

        ArrayList<Integer> arrayList = daoBill.Billdetail(orderId);

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("Order Id: "+ orderId+"\n");

        String row = "NAME,QUANTITY,INITIALPRICE,TOTAL";
        fileWriter.write(row+ "\n");
        int quantity=0,productid=0;
        int grossTotal=0;

        DomainProduct domainProduct = new DomainProduct();
        for(int i=0;i<arrayList.size();i+=2)
        {
            quantity = arrayList.get(i);
            productid = arrayList.get(i + 1);
            domainProduct = servicesProduct.getById(productid);

            productprice = domainProduct.getProductunitprice();
            productname = domainProduct.getProductname();

            int total = productprice * quantity;
            grossTotal = grossTotal + total;
            row = ""+ productname + "," + quantity + "," + productprice + "," + total;

            fileWriter.write(row);
            fileWriter.write("\n");
        }
        fileWriter.write("Total Price " + ","+","+"," + grossTotal);
        fileWriter.flush();
        fileWriter.close();
    }
}

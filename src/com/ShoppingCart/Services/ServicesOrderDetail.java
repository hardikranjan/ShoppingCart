package com.ShoppingCart.Services;

import com.ShoppingCart.DAO.DAOOrder;
import com.ShoppingCart.DAO.DAOOrderDetail;
import com.ShoppingCart.Domain.DomainOrder;
import com.ShoppingCart.Domain.DomainOrderDetail;
import com.ShoppingCart.Domain.DomainProduct;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by hardikranjan on 20/02/17.
 */
public class ServicesOrderDetail {
    DAOOrderDetail daoOrderDetail = new DAOOrderDetail();

    public void place(int orderId) throws Exception {

        String cvuser = "src/com/ShoppingCart/Util/OrderDetail.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(cvuser));
        String space = "";
        String comma = ",";

        ServicesProduct servicesProduct = new ServicesProduct();

        System.out.println("Order Bill in CSV File ");
        while ((space = bufferedReader.readLine()) != null) {
            String[] str = space.split(comma);
            int productId = Integer.parseInt(str[0]);
            int qty = Integer.parseInt(str[1]);

            DomainOrderDetail domainOrderDetail = new DomainOrderDetail();
            domainOrderDetail.setOrderId(orderId);
            domainOrderDetail.setProductid(productId);
            domainOrderDetail.setOrderdetailquantity(qty);

            daoOrderDetail.placed(domainOrderDetail);

            DomainProduct domainProduct = servicesProduct.getById(productId);
            int updatedQty = domainProduct.getProductquantity() - qty;
            servicesProduct.updateById(productId, updatedQty);

            //CALLING BILL
            ServicesBill servicesBill = new ServicesBill();
            servicesBill.billgenerate(orderId);
        }
    }
}

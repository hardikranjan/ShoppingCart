package com.ShoppingCart.Domain;

import com.ShoppingCart.Services.ServicesOrder;

/**
 * Created by hardikranjan on 20/02/17.
 */
public class DomainOrderDetail extends DomainOrder {
    private int  orderdetailquantity;
    private int orderid;
    private int productid;

    /*
    ServicesOrder obj = new ServicesOrder();
    public DomainOrderDetail()
    {
        this.orderdetailid = orderdetailid;
        this.orderdetailquantity = orderdetailquantity;
        this.orderid = orderid;
        this.productid = productid;
    }

    public DomainOrder getOrderid() {

        return orderid;
    }
*/

    public int getOrderId() {
        return orderid;
    }

    public int getProductid() {
        return productid;
    }

    public int getOrderdetailquantity() {
        return orderdetailquantity;
    }

    public void setOrderId(int orderid) {
        this.orderid = orderid;
    }

    public void setOrderdetailquantity(int orderdetailquantity) {
        this.orderdetailquantity = orderdetailquantity;
    }


    public void setProductid(int productid) {
        this.productid = productid;
    }


}

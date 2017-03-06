package com.ShoppingCart.Domain;
import java.sql.Timestamp;

/**
 * Created by hardikranjan on 20/02/17.
 */
public class DomainOrder
{
    private int orderid;
    private int orderuserid;
    private Timestamp timestamp;
    private String status;
    public DomainOrder(int orderid, int orderuserid, Timestamp timestamp, String status)
    {
        this.orderid =  orderid;
        this.orderuserid = orderuserid;
        this.timestamp=timestamp;
        this.status = status;
    }

    public DomainOrder() {

    }

    public int getOrderId()
    {
        return orderid;
    }
    public int getOrderUserId()
    {
        return orderuserid;
    }

    public String getStatus()
    {
        return status;
    }
    public void setOrderId(int orderId)
    {
        this.orderid = orderid;
    }
    public void setOrderuserid(int orderuserid)
    {
        this.orderuserid = orderuserid;
    }
    public void setTimestamp(Timestamp timestamp)
    {
        this.timestamp=timestamp;
    }
    public void setStatus(String status)
    {
        this.status=status;
    }
    public String toString()
    {
        return "Order{ "+ "\tOrderId= "+orderid+"\tOrderUserId= "+orderuserid+
                "\tCreated"+timestamp+"\tStatus= "+status;
    }


    public Timestamp getTimestamp(String s) {
            return timestamp;
    }

}

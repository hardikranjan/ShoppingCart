package com.ShoppingCart.Domain;

/**
 * Created by hardikranjan on 20/02/17.
 */
public class DomainProduct
{
    private int productid,productquantity,productunitprice;
    private String productname;
    public DomainProduct(){}
    public DomainProduct(String productname,int productid,int productquantity,int productunitprice)
    {
        this.productid = productid;
        this.productquantity = productquantity;
        this.productunitprice = productunitprice;
        this.productname = productname;
    }
    public int getProductid() {return productid;}
    public int getProductquantity()
    {
        return productquantity;
    }
    public String getProductname() { return productname; }
    public int getProductunitprice()
    {
        return productunitprice;
    }
    public void getItemByProductId(int productid) {
    }
    public void setProductid(int productid)
    {
        this.productid = productid;
    }
    public void setProductunitprice(int productunitprice)
    {
        this.productunitprice = productunitprice;
    }

    public void setProductname(String productname)
    {
        this.productname = productname;
    }
    public void setProductquantity(int productquantity)
    {
        this.productquantity = productquantity;
    }
    public String toString() {
        return "Product{" + "ProductId= " + productid + "\tProductName= " + productname + "\tProductQuantity= "
                + productquantity + ", ProductInitialPrice= " + productunitprice + '}';
    }
}

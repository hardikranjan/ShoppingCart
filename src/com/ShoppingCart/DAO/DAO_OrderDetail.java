package com.ShoppingCart.DAO;

import com.ShoppingCart.Domain.DomainOrderDetail;

/**
 * Created by hardikranjan on 06/03/17.
 */
interface DAO_OrderDetail {
    void placed(DomainOrderDetail domainOrderDetail) throws Exception;
    void updateQuantity(DomainOrderDetail domainOrderDetail,int quantity,int productid) throws Exception;
}

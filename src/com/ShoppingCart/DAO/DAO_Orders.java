package com.ShoppingCart.DAO;

import com.ShoppingCart.Domain.DomainOrder;

/**
 * Created by hardikranjan on 06/03/17.
 */
interface DAO_Orders {
    int place(DomainOrder domainOrder) throws Exception;
    int getOrderById(int id) throws Exception;
    void deleteById(int id) throws Exception;
}

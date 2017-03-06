package com.ShoppingCart.Services;

import com.ShoppingCart.Domain.DomainProduct;

/**
 * Created by hardikranjan on 05/03/17.
 */

interface serviceproduct
{
    void addProduct() throws Exception;
    void deleteProduct() throws Exception;
    void displayProduct() throws Exception;
    void updateById(int id,int qty) throws  Exception;
    DomainProduct getById(int id) throws Exception;
}

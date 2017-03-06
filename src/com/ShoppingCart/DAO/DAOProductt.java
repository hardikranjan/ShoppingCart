package com.ShoppingCart.DAO;

import com.ShoppingCart.Domain.DomainProduct;

/**
 * Created by hardikranjan on 24/02/17.
 */
public interface DAOProductt {
    void insert(DomainProduct domainProduct) throws Exception;
    void updateById(int id,int qty) throws Exception;
    public DomainProduct getById(int id) throws Exception;
    int getProductById(int id) throws Exception;
    public void deleteById(int id) throws Exception;

}

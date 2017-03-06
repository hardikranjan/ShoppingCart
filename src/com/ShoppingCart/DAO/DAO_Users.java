package com.ShoppingCart.DAO;

import com.ShoppingCart.Domain.DomainUser;
import com.ShoppingCart.Util.DBConnection;
import java.sql.Connection;

/**
 * Created by hardikranjan on 25/02/17.
 */
public interface DAO_Users {
    interface DaoUsers
    {
        void insert(DomainUser domainUser) throws Exception;
        int getById(int id)throws Exception;
        void deleteById(int id) throws Exception;
    }
}

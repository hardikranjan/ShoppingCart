package com.ShoppingCart.Services;

import com.ShoppingCart.Domain.DomainOrderDetail;

/**
 * Created by hardikranjan on 24/02/17.
 */
public interface ServiceOrderDetail {
    void place(DomainOrderDetail domainOrderDetail) throws Exception;
}

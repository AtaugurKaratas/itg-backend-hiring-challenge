package com.itg.supplychainmanagement.dao;

import com.itg.supplychainmanagement.model.Cart;

import java.util.List;

public interface BillDao {
    void addToBill(List<Cart> cartList, int retailerId);
}

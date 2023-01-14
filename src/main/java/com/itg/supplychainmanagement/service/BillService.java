package com.itg.supplychainmanagement.service;

import com.itg.supplychainmanagement.model.Cart;

import java.util.List;

public interface BillService {
    void addToBill(List<Cart> cartList, int retailerId);
}

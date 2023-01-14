package com.itg.supplychainmanagement.service.impl;

import com.itg.supplychainmanagement.dao.impl.BillImpl;
import com.itg.supplychainmanagement.model.Cart;
import com.itg.supplychainmanagement.service.BillService;

import java.util.List;

public class BillServiceImpl implements BillService {
    @Override
    public void addToBill(List<Cart> cartList, int retailerId) {
        BillImpl bill = new BillImpl();
        bill.addToBill(cartList, retailerId);
    }
}

package com.itg.supplychainmanagement.service;

import com.itg.supplychainmanagement.dto.BillDTO;
import com.itg.supplychainmanagement.model.Bill;
import com.itg.supplychainmanagement.model.Cart;

import java.util.ArrayList;
import java.util.List;

public interface BillService {
    void addToBill(List<Cart> cartList, int retailerId);

    ArrayList<BillDTO> getAllBills();

    ArrayList<Cart> getAllCartById(int billId);

    void checkBill(int billId);

    ArrayList<Bill> getAllBillRetailer(int retailerId);

    void deleteBillById(int billId);
}

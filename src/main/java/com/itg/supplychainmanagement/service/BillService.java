package com.itg.supplychainmanagement.service;

import com.itg.supplychainmanagement.dto.BillDTO;
import com.itg.supplychainmanagement.dto.CartDTO;
import com.itg.supplychainmanagement.model.Bill;

import java.util.ArrayList;
import java.util.List;

public interface BillService {
    void addToBill(List<CartDTO> cartList, int retailerId);

    ArrayList<BillDTO> getAllBills();

    ArrayList<CartDTO> getAllCartById(int billId);

    void checkBill(int billId);

    ArrayList<BillDTO> getAllBillRetailer(int retailerId);

    void deleteBillById(int billId);
}

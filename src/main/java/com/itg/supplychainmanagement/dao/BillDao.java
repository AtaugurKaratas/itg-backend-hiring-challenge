package com.itg.supplychainmanagement.dao;

import com.itg.supplychainmanagement.dto.BillDTO;
import com.itg.supplychainmanagement.dto.CartDTO;
import com.itg.supplychainmanagement.model.Bill;
import com.itg.supplychainmanagement.model.Cart;

import java.util.ArrayList;
import java.util.List;

public interface BillDao {
    void addToBill(List<CartDTO> cartList, int retailerId);

    List<BillDTO> getAllBills();

    List<CartDTO> getAllCartById(int billId);

    void checkBill(int billId);

    ArrayList<BillDTO> getAllBillRetailer(int retailerId);

    void deleteBillById(int billId);

    BillDTO getBillById(int billId);
}

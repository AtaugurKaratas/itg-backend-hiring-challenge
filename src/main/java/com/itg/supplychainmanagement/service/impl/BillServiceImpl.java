package com.itg.supplychainmanagement.service.impl;

import com.itg.supplychainmanagement.dao.impl.BillImpl;
import com.itg.supplychainmanagement.dto.BillDTO;
import com.itg.supplychainmanagement.dto.CartDTO;
import com.itg.supplychainmanagement.model.Bill;
import com.itg.supplychainmanagement.model.Cart;
import com.itg.supplychainmanagement.service.BillService;

import java.util.ArrayList;
import java.util.List;

public class BillServiceImpl implements BillService {
    @Override
    public void addToBill(List<CartDTO> cartList, int retailerId) {
        BillImpl bill = new BillImpl();
        bill.addToBill(cartList, retailerId);
    }

    @Override
    public ArrayList<BillDTO> getAllBills() {
        BillImpl bill = new BillImpl();
        return bill.getAllBills();
    }

    @Override
    public ArrayList<CartDTO> getAllCartById(int billId) {
        BillImpl bill = new BillImpl();
        return bill.getAllCartById(billId);
    }

    @Override
    public void checkBill(int billId) {
        BillImpl bill = new BillImpl();
        bill.checkBill(billId);
    }

    @Override
    public ArrayList<BillDTO> getAllBillRetailer(int retailerId) {
        BillImpl bill = new BillImpl();
        return bill.getAllBillRetailer(retailerId);
    }

    @Override
    public void deleteBillById(int billId) {
        BillImpl bill = new BillImpl();
        bill.deleteBillById(billId);
    }

    @Override
    public BillDTO getBillById(int billId) {
        BillImpl bill = new BillImpl();
        return bill.getBillById(billId);
    }
}

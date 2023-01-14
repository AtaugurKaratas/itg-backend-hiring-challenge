package com.itg.supplychainmanagement.dao.impl;

import com.itg.supplychainmanagement.dao.BillDao;
import com.itg.supplychainmanagement.model.Bill;
import com.itg.supplychainmanagement.model.Cart;
import com.itg.supplychainmanagement.util.DBUtil;

import java.sql.*;
import java.util.List;

public class BillImpl implements BillDao {
    @Override
    public void addToBill(List<Cart> carts, int retailerId) {
        int billId = 0;
        double totalPrice = 0;
        for(Cart c: carts){
            totalPrice += c.getPrice() * c.getQuantity();
        }
        try{
            Connection connection = DBUtil.connection();
            String saveBill = "Insert into bill (totalprice, creationdate, ischeck, retailerid, approvaldate) values (?, ?, ?, ?, ?)";
            Bill bill = new Bill(totalPrice, retailerId);
            PreparedStatement preStatement = connection.prepareStatement(saveBill, Statement.RETURN_GENERATED_KEYS);
            preStatement.setDouble(1, bill.getTotalPrice());
            preStatement.setDate(2, bill.getCreationDate());
            preStatement.setBoolean(3, bill.isCheck());
            preStatement.setInt(4, retailerId);
            preStatement.setDate(5, bill.getApprovalDate());
            billId = preStatement.executeUpdate();
            ResultSet generatedKeys = preStatement.getGeneratedKeys();
            if(generatedKeys.next()){
                billId = generatedKeys.getInt("id");
            }
            String saveCart = "Insert into cart (productname, quantity, price, ischeck, productid, billid) values (?, ?, ?, ?, ?, ?)";
            for(Cart c: carts){
                preStatement = connection.prepareStatement(saveCart);
                preStatement.setString(1, c.getName());
                preStatement.setInt(2, c.getQuantity());
                preStatement.setDouble(3, c.getPrice());
                preStatement.setBoolean(4, c.isCheck());
                preStatement.setInt(5, c.getProductId());
                preStatement.setInt(6, billId);
                preStatement.executeUpdate();
            }
            DBUtil.close(connection, preStatement, generatedKeys);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

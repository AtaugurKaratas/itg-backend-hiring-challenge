package com.itg.supplychainmanagement.dao.impl;

import com.itg.supplychainmanagement.dao.BillDao;
import com.itg.supplychainmanagement.dto.BillDTO;
import com.itg.supplychainmanagement.model.Bill;
import com.itg.supplychainmanagement.model.Cart;
import com.itg.supplychainmanagement.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BillImpl implements BillDao {
    @Override
    public void addToBill(List<Cart> carts, int retailerId) {
        int billId = 0;
        double totalPrice = 0;
        for (Cart c : carts) {
            totalPrice += c.getPrice() * c.getQuantity();
        }
        try {
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
            if (generatedKeys.next()) {
                billId = generatedKeys.getInt("id");
            }
            String saveCart = "Insert into cart (productname, quantity, price, ischeck, productid, billid) values (?, ?, ?, ?, ?, ?)";
            for (Cart c : carts) {
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

    @Override
    public ArrayList<BillDTO> getAllBills() {
        ArrayList<BillDTO> billList = new ArrayList<>();
        try {
            Connection connection = DBUtil.connection();
            PreparedStatement preStatement = connection
                    .prepareStatement("Select bill.id, bill.totalprice, bill.creationdate, bill.ischeck, users.name, bill.approvaldate from bill" +
                            " inner join users on bill.retailerId = users.id where bill.ischeck is null");
            ResultSet rs = preStatement.executeQuery();
            while (rs.next()) {
                BillDTO billDTO = new BillDTO();
                billDTO.setId(rs.getInt("id"));
                billDTO.setTotalPrice(rs.getDouble("totalprice"));
                billDTO.setCreationDate(rs.getDate("creationdate"));
                billDTO.setCheck(rs.getBoolean("ischeck"));
                billDTO.setRetailerName(rs.getString("name"));
                billDTO.setApprovalDate(rs.getDate("approvaldate"));
                billList.add(billDTO);
            }
            DBUtil.close(connection, preStatement, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return billList;
    }

    @Override
    public ArrayList<Cart> getAllCartById(int billId) {
        ArrayList<Cart> cartList = new ArrayList<>();
        try{
            Connection connection = DBUtil.connection();
            PreparedStatement preStatement = connection.prepareStatement("Select * from cart where billId = ?");
            preStatement.setInt(1, billId);
            ResultSet rs = preStatement.executeQuery();
            while (rs.next()){
                Cart cart = new Cart();
                cart.setId(rs.getInt("id"));
                cart.setName(rs.getString("productname"));
                cart.setQuantity(rs.getInt("quantity"));
                cart.setPrice(rs.getDouble("price"));
                cart.setCheck(rs.getBoolean("ischeck"));
                cart.setProductId(rs.getInt("productid"));
                cart.setBillId(rs.getInt("billid"));
                cartList.add(cart);
            }
            DBUtil.close(connection, preStatement, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cartList;
    }

    @Override
    public void checkBill(int billId) {
        try{
            Connection connection = DBUtil.connection();
            PreparedStatement preStatement = connection.prepareStatement("Update bill set ischeck = ?, approvaldate = ? where id = ?");
            preStatement.setBoolean(1, true);
            preStatement.setDate(2, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
            preStatement.setInt(3, billId);
            preStatement.executeUpdate();
            DBUtil.close(connection, preStatement, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Bill> getAllBillRetailer(int retailerId) {
        ArrayList<Bill> billArrayList = new ArrayList<>();
        try{
            Connection connection = DBUtil.connection();
            PreparedStatement preStatement = connection.prepareStatement("Select * from bill where retailerid = ?");
            preStatement.setInt(1, retailerId);
            ResultSet rs = preStatement.executeQuery();
            while (rs.next()){
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setTotalPrice(rs.getDouble("totalprice"));
                bill.setCreationDate(rs.getDate("creationdate"));
                bill.setCheck(rs.getBoolean("ischeck"));
                bill.setRetailerId(rs.getInt("retailerid"));
                bill.setApprovalDate(rs.getDate("approvaldate"));
                billArrayList.add(bill);
            }
            DBUtil.close(connection, preStatement, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return billArrayList;
    }

    @Override
    public void deleteBillById(int billId) {
        try{
            Connection connection = DBUtil.connection();
            PreparedStatement preStatement = connection.prepareStatement("delete from bill where id = ?");
            preStatement.setInt(1, billId);
            preStatement.executeUpdate();
            DBUtil.close(connection, preStatement, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try{
            Connection connection = DBUtil.connection();
            PreparedStatement preStatement = connection.prepareStatement("delete from cart where billid = ?");
            preStatement.setInt(1, billId);
            preStatement.executeUpdate();
            DBUtil.close(connection, preStatement, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

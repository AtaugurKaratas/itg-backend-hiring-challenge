package com.itg.supplychainmanagement.dao.impl;

import com.itg.supplychainmanagement.dao.RetailerDao;
import com.itg.supplychainmanagement.model.Retailer;
import com.itg.supplychainmanagement.model.UserType;
import com.itg.supplychainmanagement.util.DBUtil;

import java.sql.*;

public class RetailerImpl implements RetailerDao {
    @Override
    public int register(Retailer retailer) {
        int saveResult = 0;
        try{
            Connection connection = DBUtil.connection();
            String saveUser = "Insert into users (name, password, emailaddress, phonenumber, role, creationdate, creationtime) values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preStatement = connection.prepareStatement(saveUser);
            preStatement.setString(1, retailer.getName());
            preStatement.setString(2, retailer.getPassword());
            preStatement.setString(3, retailer.getEmailAddress());
            preStatement.setString(4, retailer.getPhoneNumber());
            preStatement.setString(5, retailer.getUserRole());
            preStatement.setDate(6, (Date) retailer.getCreationDate());
            preStatement.setTime(7, retailer.getCreationTime());
            saveResult = preStatement.executeUpdate();
            DBUtil.close(connection, preStatement, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saveResult;
    }

    @Override
    public String validate(String email, String password) {
        String retailerId = null;
        try{
            Connection connection = DBUtil.connection();
            PreparedStatement preStatement = connection.prepareStatement("Select * from users where emailaddress=? and password=? and role=?");
            preStatement.setString(1, email);
            preStatement.setString(2, password);
            preStatement.setString(3, UserType.RETAILER.name());
            ResultSet rs = preStatement.executeQuery();
            if(rs.next()){
                retailerId = String.valueOf(rs.getInt("id"));
            }
            DBUtil.close(connection, preStatement, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retailerId;
    }

    @Override
    public Retailer getRetailerById(int retailerId) {
        Retailer retailer = new Retailer();
        retailer.setId(retailerId);
        try{
            Connection connection = DBUtil.connection();
            PreparedStatement preStatement = connection.prepareStatement("Select * from users where id = ? and role=?");
            preStatement.setInt(1, retailer.getId());
            preStatement.setString(2, UserType.RETAILER.name());
            ResultSet rs = preStatement.executeQuery();
            if(rs.next()){
                retailer.setName(String.valueOf(rs.getInt("name")));
                retailer.setPassword(rs.getString("password"));
                retailer.setEmailAddress(rs.getString("emailaddress"));
                retailer.setPhoneNumber(rs.getString("phonenumber"));
                retailer.setName(String.valueOf(rs.getDate("creationdate")));
                retailer.setName(String.valueOf(rs.getTime("creationtime")));
            }
            DBUtil.close(connection, preStatement, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retailer;
    }
}

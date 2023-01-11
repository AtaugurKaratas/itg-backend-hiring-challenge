package com.itg.supplychainmanagement.dao.impl;

import com.itg.supplychainmanagement.dao.RetailerDao;
import com.itg.supplychainmanagement.model.Retailer;
import com.itg.supplychainmanagement.model.UserType;
import com.itg.supplychainmanagement.util.DBUtil;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RetailerImpl implements RetailerDao {
    Logger logger = LoggerFactory.getLogger(RetailerImpl.class);
    @Override
    public int register(Retailer retailer) {
        int saveResult = 0;
        try{
            Connection connection = DBUtil.connection();
            String saveUser = "Insert into users (name, password, emailaddress, phonenumber, role) values (?, ?, ?, ?, ?)";
            PreparedStatement preStatement = connection.prepareStatement(saveUser);
            preStatement.setString(1, retailer.getName());
            preStatement.setString(2, retailer.getPassword());
            preStatement.setString(3, retailer.getEmailAddress());
            preStatement.setString(4, retailer.getPhoneNumber());
            preStatement.setString(5, retailer.getUserRole());
            saveResult = preStatement.executeUpdate();
            logger.error(String.valueOf(saveResult));
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
}

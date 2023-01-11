package com.itg.supplychainmanagement.dao.impl;

import com.itg.supplychainmanagement.dao.SupplierDao;
import com.itg.supplychainmanagement.model.Supplier;
import com.itg.supplychainmanagement.model.UserType;
import com.itg.supplychainmanagement.util.DBUtil;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SupplierImpl implements SupplierDao {

    Logger logger = Logger.getLogger(SupplierImpl.class.getName());
    @Override
    public int register(Supplier supplier) {
        int saveResult = 0;
        try{
            Connection connection = DBUtil.connection();
            String saveUser = "Insert into users (name, password, emailaddress, phonenumber, role) values (?, ?, ?, ?, ?)";
            PreparedStatement preStatement = connection.prepareStatement(saveUser);
            preStatement.setString(1, supplier.getName());
            preStatement.setString(2, supplier.getPassword());
            preStatement.setString(3, supplier.getEmailAddress());
            preStatement.setString(4, supplier.getPhoneNumber());
            preStatement.setString(5, supplier.getUserRole());
            saveResult = preStatement.executeUpdate();
            DBUtil.close(connection, preStatement, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saveResult;
    }

    @Override
    public String validate(String email, String password) {
        String supplierId = null;
        try{
            Connection connection = DBUtil.connection();
            PreparedStatement preStatement = connection.prepareStatement("Select * from users where emailaddress=? and password=? and role=?");
            preStatement.setString(1, email);
            preStatement.setString(2, password);
            preStatement.setString(3, UserType.SUPPLIER.name());
            ResultSet rs = preStatement.executeQuery();
            if(rs.next()){
                supplierId = String.valueOf(rs.getInt("id"));
            }
            DBUtil.close(connection, preStatement, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return supplierId;
    }
}

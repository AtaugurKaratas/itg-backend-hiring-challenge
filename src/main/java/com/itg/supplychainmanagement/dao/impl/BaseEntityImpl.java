package com.itg.supplychainmanagement.dao.impl;

import com.itg.supplychainmanagement.dao.BaseEntityDao;
import com.itg.supplychainmanagement.model.BaseEntity;
import com.itg.supplychainmanagement.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BaseEntityImpl implements BaseEntityDao {
    @Override
    public int save(BaseEntity baseEntity, String userType) {
        int saveResult = 0;
        try{
            Connection connection = DBUtil.connection();
            String saveUser = "Insert into " + userType + "(name, password, email, phoneNumber) values (?, ?, ?, ?)";
            PreparedStatement preStatement = connection.prepareStatement(saveUser);
            preStatement.setString(1, baseEntity.getName());
            preStatement.setString(2, baseEntity.getPassword());
            preStatement.setString(3, baseEntity.getEmailAddress());
            preStatement.setString(4, baseEntity.getPhoneNumber());
            saveResult = preStatement.executeUpdate();
            DBUtil.close(connection, preStatement, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saveResult;
    }
}

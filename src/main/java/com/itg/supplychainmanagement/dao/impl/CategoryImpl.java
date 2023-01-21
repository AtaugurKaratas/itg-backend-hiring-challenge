package com.itg.supplychainmanagement.dao.impl;

import com.itg.supplychainmanagement.dao.CategoryDao;
import com.itg.supplychainmanagement.model.Category;
import com.itg.supplychainmanagement.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryImpl implements CategoryDao {
    @Override
    public void addCategory(String name) {
        Connection connection = DBUtil.connection();
        Category category = new Category(name);
        try{
            String saveProduct = "Insert into category (name) values (?)";
            PreparedStatement preStatement = connection.prepareStatement(saveProduct);
            preStatement.setString(1, category.getName());
            preStatement.executeUpdate();
            DBUtil.close(connection, preStatement, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        try{
            Connection connection = DBUtil.connection();
            PreparedStatement preStatement = connection.prepareStatement("Select * from category");
            ResultSet rs = preStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                categories.add(new Category(id, name));
            }
            DBUtil.close(connection, preStatement, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }
}

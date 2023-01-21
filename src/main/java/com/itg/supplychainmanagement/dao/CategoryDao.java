package com.itg.supplychainmanagement.dao;

import com.itg.supplychainmanagement.model.Category;

import java.util.List;

public interface CategoryDao {
    void addCategory(String name);

    List<Category> getAllCategories();
}

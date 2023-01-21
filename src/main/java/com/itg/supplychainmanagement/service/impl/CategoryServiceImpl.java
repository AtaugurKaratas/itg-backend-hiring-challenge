package com.itg.supplychainmanagement.service.impl;

import com.itg.supplychainmanagement.dao.impl.CategoryImpl;
import com.itg.supplychainmanagement.model.Category;
import com.itg.supplychainmanagement.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Override
    public void addCategory(String name) {
        CategoryImpl category = new CategoryImpl();
        category.addCategory(name);
    }

    @Override
    public List<Category> getAllCategory() {
        CategoryImpl category = new CategoryImpl();
        return category.getAllCategories();
    }
}

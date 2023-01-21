package com.itg.supplychainmanagement.service;

import com.itg.supplychainmanagement.model.Category;

import java.util.List;

public interface CategoryService {

    void addCategory(String name);

    List<Category> getAllCategory();
}

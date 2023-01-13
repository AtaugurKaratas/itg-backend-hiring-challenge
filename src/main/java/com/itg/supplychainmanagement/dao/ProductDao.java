package com.itg.supplychainmanagement.dao;

import com.itg.supplychainmanagement.model.Product;

import java.util.List;

public interface ProductDao {
    int addProduct(String name, float price, int retailerId);

    void addProductImage(String path, int productId);

    List<Product> searchProduct(String name);
}

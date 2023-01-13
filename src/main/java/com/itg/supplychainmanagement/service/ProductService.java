package com.itg.supplychainmanagement.service;

import com.itg.supplychainmanagement.model.Product;

import java.util.List;

public interface ProductService {

    int addProduct(String name, float price, int retailerId);

    void addProductImage(String path, int productId);

    List<Product> searchProduct(String name);
}
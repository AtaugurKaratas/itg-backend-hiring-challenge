package com.itg.supplychainmanagement.service.impl;

import com.itg.supplychainmanagement.dao.impl.ProductImpl;
import com.itg.supplychainmanagement.model.Product;
import com.itg.supplychainmanagement.service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    ProductImpl product = new ProductImpl();
    @Override
    public int addProduct(String name, float price, int retailerId) {
        return product.addProduct(name, price, retailerId);
    }

    @Override
    public void addProductImage(String path, int productId) {
        product.addProductImage(path, productId);
    }

    @Override
    public List<Product> searchProduct(String name) {
        return product.searchProduct(name);
    }
}

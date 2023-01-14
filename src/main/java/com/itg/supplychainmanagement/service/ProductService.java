package com.itg.supplychainmanagement.service;

import com.itg.supplychainmanagement.model.Cart;
import com.itg.supplychainmanagement.model.Product;
import com.itg.supplychainmanagement.model.ProductImage;

import java.util.List;

public interface ProductService {

    int addProduct(String name, float price, int retailerId);

    void addProductImage(String path, int productId);

    List<Product> searchProduct(String name);

    List<Cart> addToCart(List<Cart> cartList);

    List<Product> outOfStockProduct();

    List<ProductImage> getProductImages(int productId);
}

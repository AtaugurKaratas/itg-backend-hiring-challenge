package com.itg.supplychainmanagement.service;

import com.itg.supplychainmanagement.dto.ProductDTO;
import com.itg.supplychainmanagement.model.Cart;
import com.itg.supplychainmanagement.model.Product;
import com.itg.supplychainmanagement.model.ProductImage;

import java.util.List;

public interface ProductService {

    int addProduct(String name, float price, int retailerId);

    void addProductImage(String path, int productId);

    List<ProductDTO> searchProduct(String name);

    List<Cart> addToCart(List<Cart> cartList);

    List<ProductDTO> outOfStockProduct();

    List<ProductImage> getProductImages(int productId);

    void updateProduct(int id, int quantity, int discount);
}

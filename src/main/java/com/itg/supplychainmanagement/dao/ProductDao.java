package com.itg.supplychainmanagement.dao;

import com.itg.supplychainmanagement.dto.ProductDTO;
import com.itg.supplychainmanagement.model.Cart;
import com.itg.supplychainmanagement.model.Product;
import com.itg.supplychainmanagement.model.ProductImage;

import java.util.List;

public interface ProductDao {
    int addProduct(String name, float price, int retailerId, int categoryId);

    void addProductImage(String path, int productId);

    List<ProductDTO> searchProduct(String name);

    List<Cart> addToCart(List<Cart> cartList);

    List<ProductDTO> outOfStockProduct();


    List<ProductImage> getProductImages(int productId);

    void updateProduct(int id, int quantity, int discount);

    ProductDTO getProductById(int productId);
}

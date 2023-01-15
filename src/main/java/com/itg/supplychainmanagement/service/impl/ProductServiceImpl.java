package com.itg.supplychainmanagement.service.impl;

import com.itg.supplychainmanagement.dao.impl.ProductImpl;
import com.itg.supplychainmanagement.dto.ProductDTO;
import com.itg.supplychainmanagement.model.Cart;
import com.itg.supplychainmanagement.model.Product;
import com.itg.supplychainmanagement.model.ProductImage;
import com.itg.supplychainmanagement.service.ProductService;

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
    public List<ProductDTO> searchProduct(String name) {
        return product.searchProduct(name);
    }

    @Override
    public List<Cart> addToCart(List<Cart> cartList) {
        List<Cart> carts = cartList;
        for(Cart c: carts){
            c.setPrice(c.getQuantity()*c.getPrice());
        }
        return carts;
    }

    @Override
    public List<ProductDTO> outOfStockProduct() {
        return product.outOfStockProduct();
    }

    @Override
    public List<ProductImage> getProductImages(int productId) {
        return product.getProductImages(productId);
    }

    @Override
    public void updateProduct(int id, int quantity, int discount) {
        product.updateProduct(id, quantity, discount);
    }


}

package com.itg.supplychainmanagement.model;

public class ProductImage {
    private int id;
    private String path;

    private int productId;

    public ProductImage(){}

    public ProductImage(int id, String path, int productId) {
        this.id = id;
        this.path = path;
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getProduct() {
        return productId;
    }

    public void setProduct(int productId) {
        this.productId = productId;
    }
}

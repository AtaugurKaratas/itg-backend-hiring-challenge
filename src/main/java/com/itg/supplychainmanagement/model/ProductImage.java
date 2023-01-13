package com.itg.supplychainmanagement.model;

public class ProductImage {
    private int id;
    private String path;

    private int product;

    public ProductImage(int id, String path, int product) {
        this.id = id;
        this.path = path;
        this.product = product;
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
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }
}

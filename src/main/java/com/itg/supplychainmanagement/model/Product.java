package com.itg.supplychainmanagement.model;

public class Product{
    private int id;
    private String name;
    private int quantity;
    private float price;
    private ProductImage[] productImages;

    public Product(int id, String name, int quantity, float price, ProductImage[] productImages) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.productImages = productImages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ProductImage[] getProductImages() {
        return productImages;
    }

    public void setProductImages(ProductImage[] productImages) {
        this.productImages = productImages;
    }
}

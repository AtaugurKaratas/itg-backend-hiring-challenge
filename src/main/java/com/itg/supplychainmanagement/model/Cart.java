package com.itg.supplychainmanagement.model;

public class Cart {
    private int id;
    private int quantity;
    private double price;
    private int productId;
    private int billId;
    public Cart(int quantity, double price, int productId) {
        this.quantity = quantity;
        this.price = price;
        this.productId = productId;
    }
    public Cart(int quantity, double price, int productId, int billId) {
        this.quantity = quantity;
        this.price = price;
        this.productId = productId;
        this.billId = billId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }
}

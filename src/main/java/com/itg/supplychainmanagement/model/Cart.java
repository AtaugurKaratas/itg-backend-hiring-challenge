package com.itg.supplychainmanagement.model;

public class Cart {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private boolean isCheck;
    private int productId;
    private int billId;

    public Cart() {
    }
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
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

package com.itg.supplychainmanagement.dto;

public class CartDTO {
    private int id;
    private String productname;
    private int quantity;
    private double price;
    private boolean isCheck;
    private int productId;
    private int billId;

    public CartDTO() {
    }

    public CartDTO(String productname, int quantity, double price, boolean isCheck, int productId) {
        this.productname = productname;
        this.quantity = quantity;
        this.price = price;
        this.isCheck = isCheck;
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
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

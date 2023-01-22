package com.itg.supplychainmanagement.model;

import java.sql.Time;
import java.util.Date;

public class Product{
    private int id;
    private String name;
    private int quantity;
    private float price;
    private int discount;
    private Retailer retailer;
    private Category category;
    private Date creationDate;
    private Time creationTime;

    public Product() {
    }

    public Product(String name, float price, Retailer retailer, Category category) {
        this.name = name;
        this.quantity = 0;
        this.price = price;
        this.discount = 0;
        this.retailer = retailer;
        this.category = category;
        this.creationDate = java.sql.Date.valueOf(java.time.LocalDate.now());
        this.creationTime = Time.valueOf(java.time.LocalTime.now());
    }

    public Product(int id, String name, int quantity, float price, int discount, Retailer retailer) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
        this.retailer = retailer;
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

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Retailer getRetailer() {
        return retailer;
    }

    public void setRetailer(Retailer retailer) {
        this.retailer = retailer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Time getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Time creationTime) {
        this.creationTime = creationTime;
    }
}

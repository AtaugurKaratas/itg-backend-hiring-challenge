package com.itg.supplychainmanagement.model;

import java.sql.Date;
import java.util.Calendar;

public class Bill {
    private int id;
    private double totalPrice;
    private int retailerId;
    private boolean isCheck;
    private Date creationDate;
    private Date approvalDate;

    public Bill(){}

    public Bill(double totalPrice, int retailerId) {
        this.totalPrice = totalPrice;
        this.retailerId = retailerId;
        this.creationDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(int retailerId) {
        this.retailerId = retailerId;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }
}

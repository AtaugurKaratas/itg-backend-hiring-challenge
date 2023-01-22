package com.itg.supplychainmanagement.model;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

public class Bill {
    private int id;
    private double totalPrice;
    private Retailer retailer;
    private boolean isCheck;
    private Date creationDate;
    private Time creationTime;
    private Date approvalDate;
    private Time approvalTime;

    public Bill() {
    }

    public Bill(double totalPrice, Retailer retailer) {
        this.totalPrice = totalPrice;
        this.retailer = retailer;
        this.creationDate = java.sql.Date.valueOf(java.time.LocalDate.now());
        this.creationTime = Time.valueOf(java.time.LocalTime.now());
        this.approvalDate = null;
        this.approvalTime = null;
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

    public Retailer getRetailer() {
        return retailer;
    }

    public void setRetailer(Retailer retailer) {
        this.retailer = retailer;
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

    public Time getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Time creationTime) {
        this.creationTime = creationTime;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public Time getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(Time approvalTime) {
        this.approvalTime = approvalTime;
    }
}

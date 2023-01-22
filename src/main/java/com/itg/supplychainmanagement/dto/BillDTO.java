package com.itg.supplychainmanagement.dto;

import com.itg.supplychainmanagement.model.Bill;

import java.sql.Date;
import java.sql.Time;

public class BillDTO {
    private int id;
    private double totalPrice;
    private Date creationDate;
    private boolean isCheck;
    private String retailerName;
    private Date approvalDate;
    private Time creationTime;
    private Time approvalTime;

    private int retailerId;

    public BillDTO(){}

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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean isCheck) {
        this.isCheck = isCheck;
    }

    public String getRetailerName() {
        return retailerName;
    }

    public void setRetailerName(String retailerName) {
        this.retailerName = retailerName;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public Time getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Time creationTime) {
        this.creationTime = creationTime;
    }

    public Time getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(Time approvalTime) {
        this.approvalTime = approvalTime;
    }

    public int getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(int retailerId) {
        this.retailerId = retailerId;
    }
}

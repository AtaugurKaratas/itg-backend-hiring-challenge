package com.itg.supplychainmanagement.model;

import java.sql.Time;
import java.util.Date;

public abstract class BaseEntity {
    private int id;
    private String name;
    private String password;
    private String emailAddress;
    private String phoneNumber;
    private Date creationDate;
    private Time creationTime;

    public BaseEntity() {
    }

    public BaseEntity(String name, String password, String emailAddress, String phoneNumber) {
        this.name = name;
        this.password = password;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.creationDate = java.sql.Date.valueOf(java.time.LocalDate.now());
        this.creationTime = Time.valueOf(java.time.LocalTime.now());
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

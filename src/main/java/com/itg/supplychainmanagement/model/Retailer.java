package com.itg.supplychainmanagement.model;

public class Retailer extends BaseEntity {

    private String userRole;

    public Retailer() {
    }

    public Retailer(String name, String password, String emailAddress, String phoneNumber, String userRole) {
        super(name, password, emailAddress, phoneNumber);
        this.userRole = userRole;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}

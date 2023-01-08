package com.itg.supplychainmanagement.model;

public class Retailer extends BaseEntity{
    public Retailer(String name, String password, String emailAddress, String phoneNumber) {
        super(name, password, emailAddress, phoneNumber);
    }

    public Retailer(int id, String name, String password, String emailAddress, String phoneNumber) {
        super(id, name, password, emailAddress, phoneNumber);
    }
}

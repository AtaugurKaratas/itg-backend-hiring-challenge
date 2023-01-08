package com.itg.supplychainmanagement.model;

public class Supplier extends BaseEntity{
    public Supplier(String name, String password, String emailAddress, String phoneNumber) {
        super(name, password, emailAddress, phoneNumber);
    }

    public Supplier(int id, String name, String password, String emailAddress, String phoneNumber) {
        super(id, name, password, emailAddress, phoneNumber);
    }
}

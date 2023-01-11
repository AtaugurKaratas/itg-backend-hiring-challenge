package com.itg.supplychainmanagement.dao;
import com.itg.supplychainmanagement.model.Retailer;

public interface RetailerDao {
    int register(Retailer retailer);

    String validate(String email, String password);
}

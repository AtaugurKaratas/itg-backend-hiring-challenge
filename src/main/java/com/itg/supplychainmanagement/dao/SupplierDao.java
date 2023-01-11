package com.itg.supplychainmanagement.dao;

import com.itg.supplychainmanagement.model.Supplier;

public interface SupplierDao {
    int register(Supplier supplier);

    String validate(String email, String password);
}

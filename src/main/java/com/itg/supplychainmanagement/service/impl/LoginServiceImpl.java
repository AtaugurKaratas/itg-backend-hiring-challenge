package com.itg.supplychainmanagement.service.impl;

import com.itg.supplychainmanagement.dao.impl.RetailerImpl;
import com.itg.supplychainmanagement.dao.impl.SupplierImpl;
import com.itg.supplychainmanagement.service.LoginService;

public class LoginServiceImpl implements LoginService {
    @Override
    public String loginRegister(String email, String password) {
        RetailerImpl retailer = new RetailerImpl();
        return retailer.validate(email, password);
    }

    @Override
    public String loginSupplier(String email, String password) {
        SupplierImpl supplier = new SupplierImpl();
        return supplier.validate(email, password);
    }
}

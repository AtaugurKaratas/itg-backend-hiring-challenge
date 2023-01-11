package com.itg.supplychainmanagement.service.impl;

import com.itg.supplychainmanagement.dao.impl.RetailerImpl;
import com.itg.supplychainmanagement.dao.impl.SupplierImpl;
import com.itg.supplychainmanagement.model.Retailer;
import com.itg.supplychainmanagement.model.Supplier;
import com.itg.supplychainmanagement.model.UserType;
import com.itg.supplychainmanagement.service.RegisterService;

import javax.servlet.http.HttpSession;

public class RegisterServiceImpl implements RegisterService {
    @Override
    public String doRegisterRetailer(String name, String password, String email, String phoneNumber) {
        Retailer retailer = new Retailer(name, password, email, phoneNumber, UserType.RETAILER.name());
        RetailerImpl baseEntity = new RetailerImpl();
        baseEntity.register(retailer);
        return "Kayit basari ile tamamlandı";
    }
    @Override
    public String doRegisterSupplier(String name, String password, String email, String phoneNumber) {
        Supplier supplier = new Supplier(name, password, email, phoneNumber, UserType.SUPPLIER.name());
        SupplierImpl baseEntity = new SupplierImpl();
        baseEntity.register(supplier);
        return "Kayit basari ile tamamlandı";
    }
}

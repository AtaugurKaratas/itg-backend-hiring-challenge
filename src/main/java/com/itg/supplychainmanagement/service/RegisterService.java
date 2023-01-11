package com.itg.supplychainmanagement.service;

import javax.servlet.http.HttpSession;

public interface RegisterService {

    String doRegisterRetailer(String name, String password, String email, String phoneNumber);

    String doRegisterSupplier(String name, String password, String email, String phoneNumber);
}

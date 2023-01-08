package com.itg.supplychainmanagement.service.impl;

import com.itg.supplychainmanagement.service.RegisterService;

import javax.servlet.http.HttpSession;

public class RegisterServiceImpl implements RegisterService {
    @Override
    public String doRegister(String name, String password, String email, String phoneNumber, String userType, HttpSession httpSession) {
        return null;
    }
}

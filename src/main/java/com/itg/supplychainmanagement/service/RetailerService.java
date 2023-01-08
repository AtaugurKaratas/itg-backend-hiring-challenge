package com.itg.supplychainmanagement.service;

import javax.servlet.http.HttpSession;

public interface RetailerService{
    String doRegister(String name, String password, String email, String phoneNumber, HttpSession httpSession);
}
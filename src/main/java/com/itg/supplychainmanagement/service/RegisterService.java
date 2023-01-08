package com.itg.supplychainmanagement.service;

import javax.servlet.http.HttpSession;

public interface RegisterService {

    String doRegister(String name, String password, String email, String phoneNumber, String userType, HttpSession httpSession);
}

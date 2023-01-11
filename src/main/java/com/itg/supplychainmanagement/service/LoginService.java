package com.itg.supplychainmanagement.service;

public interface LoginService {
    String loginRegister(String email, String password);

    String loginSupplier(String email, String password);
}

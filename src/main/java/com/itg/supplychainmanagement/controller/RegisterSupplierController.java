package com.itg.supplychainmanagement.controller;

import com.itg.supplychainmanagement.service.impl.RegisterServiceImpl;
import com.itg.supplychainmanagement.util.PasswordHashing;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet(name = "supplier-register", value = "/supplier-register")
public class RegisterSupplierController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String passwordRepeat = req.getParameter("passwordRepeat");
        String email = req.getParameter("email");
        String phoneNumber = req.getParameter("phoneNumber");
        HttpSession session = req.getSession();

        try {
            password = PasswordHashing.toHexString(PasswordHashing.getSHA(password));
            passwordRepeat = PasswordHashing.toHexString(PasswordHashing.getSHA(passwordRepeat));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        if (password.equals(passwordRepeat)) {
            RegisterServiceImpl registerService = new RegisterServiceImpl();
            String message = registerService.doRegisterSupplier(name, password, email, phoneNumber);
            req.setAttribute("message", message);
            req.getRequestDispatcher("/homePageSupplier.jsp").forward(req, resp);
        } else {
            String message = "Password not the same";
            req.setAttribute("message", message);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/registerSupplier.jsp").forward(req, resp);
    }
}

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

@WebServlet(name = "retailer-register", value = "/retailer-register")
public class RegisterRetailerController extends HttpServlet {

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
            String message = registerService.doRegisterRetailer(name, password, email, phoneNumber);
            req.setAttribute("name", message);
            session.setAttribute("retailerName", name);
            session.setAttribute("retailerId", "karatas");
            req.getRequestDispatcher("/homePageRetailer.jsp").forward(req, resp);
        } else {
            String message = "Password not the same";
            req.setAttribute("message", message);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/registerRetailer.jsp").forward(req, resp);
    }
}

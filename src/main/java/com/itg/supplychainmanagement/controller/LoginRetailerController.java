package com.itg.supplychainmanagement.controller;

import com.itg.supplychainmanagement.service.impl.LoginServiceImpl;
import com.itg.supplychainmanagement.util.PasswordHashing;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet(name = "retailer-login", value = "/retailer-login")
public class LoginRetailerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/loginRetailer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();

        try {
            password = PasswordHashing.toHexString(PasswordHashing.getSHA(password));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        LoginServiceImpl loginService = new LoginServiceImpl();
        String retailerId = loginService.loginRegister(email, password);
        if(retailerId != null) {
            session.setAttribute("retailerId", retailerId);
            session.setAttribute("auth", "Auth");
            req.setAttribute("status", "Başarılı");
            req.getRequestDispatcher("/homePageRetailer.jsp").forward(req, resp);
        } else {
            req.setAttribute("status", "Giriş Işlemi Başarısız");
            req.getRequestDispatcher("/loginRetailer.jsp").forward(req, resp);
        }
    }
}

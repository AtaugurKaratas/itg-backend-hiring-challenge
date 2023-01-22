package com.itg.supplychainmanagement.controller.user;

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

@WebServlet(name = "supplier-login", value = "/supplier-login")
public class LoginSupplierController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/billDetail").forward(req, resp);
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
        String supplierId = loginService.loginSupplier(email, password);
        if(supplierId != null) {
            session.setAttribute("supplierId", supplierId);
            session.setAttribute("auth", "Auth");
            req.setAttribute("status", "success");
            req.getRequestDispatcher("/homePageSupplier.jsp").forward(req, resp);
        } else {
            req.setAttribute("status", "failed");
            req.getRequestDispatcher("/loginSupplier.jsp").forward(req, resp);
        }
    }
}

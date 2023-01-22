package com.itg.supplychainmanagement.controller.product;

import com.itg.supplychainmanagement.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "update-product", value = "/update-product")
public class UpdateProductController extends HttpServlet {
    int productId;
    int quantity;
    int discount;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productId = Integer.parseInt(req.getParameter("id"));
        quantity = Integer.parseInt(req.getParameter("quantity"));
        discount = Integer.parseInt(req.getParameter("discount"));
        ProductServiceImpl productService = new ProductServiceImpl();
        System.out.println(productId + quantity + discount);
        productService.updateProduct(productId, quantity, discount);
        req.getRequestDispatcher("/allProductSupplier.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productId = Integer.parseInt(req.getParameter("id"));
        quantity = Integer.parseInt(req.getParameter("quantity"));
        discount = Integer.parseInt(req.getParameter("discount"));
        ProductServiceImpl productService = new ProductServiceImpl();
        System.out.println(productId + quantity + discount);
        productService.updateProduct(productId, quantity, discount);
        req.getRequestDispatcher("/allProductSupplier.jsp").forward(req, resp);
    }
}

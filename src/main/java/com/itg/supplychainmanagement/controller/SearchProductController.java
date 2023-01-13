package com.itg.supplychainmanagement.controller;

import com.itg.supplychainmanagement.model.Product;
import com.itg.supplychainmanagement.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "search-product", value = "/search-product")
public class SearchProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/homePageRetailer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        ProductServiceImpl productService = new ProductServiceImpl();
        List<Product> productList = productService.searchProduct(name);
        System.out.println(productList.toString());
        req.setAttribute("productList", productList);
        req.getRequestDispatcher("/homePageRetailer.jsp").forward(req, resp);

    }
}

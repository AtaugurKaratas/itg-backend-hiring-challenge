package com.itg.supplychainmanagement.controller;

import com.itg.supplychainmanagement.dto.ProductDTO;
import com.itg.supplychainmanagement.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "all-product-supplier", value = "/all-product-supplier")
public class AllProductSupplier extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/allProductSupplier.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        ProductServiceImpl productService = new ProductServiceImpl();
        List<ProductDTO> productList = productService.searchProduct(name);
        req.setAttribute("productList", productList);
        req.getRequestDispatcher("/allProductSupplier.jsp").forward(req, resp);

    }
}

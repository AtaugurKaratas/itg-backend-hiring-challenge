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

@WebServlet(name = "out-of-stock-supplier", value = "/out-of-stock-supplier")
public class OutOfStockSupplierController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductServiceImpl productService = new ProductServiceImpl();
        List<ProductDTO> productList = productService.outOfStockProduct();
        req.setAttribute("productList", productList);
        req.getRequestDispatcher("/allProductSupplier.jsp").forward(req, resp);
    }
}

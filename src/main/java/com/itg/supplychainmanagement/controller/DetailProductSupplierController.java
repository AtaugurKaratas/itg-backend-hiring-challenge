package com.itg.supplychainmanagement.controller;

import com.itg.supplychainmanagement.model.ProductImage;
import com.itg.supplychainmanagement.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "detail-product-supplier", value = "/detail-product-supplier")
public class DetailProductSupplierController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF8");
        ArrayList<ProductImage> imageList;
        int productId = Integer.parseInt(req.getParameter("id"));
        double price = Double.parseDouble(req.getParameter("price"));
        String name = req.getParameter("name");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int discount = Integer.parseInt(req.getParameter("discount"));
        ProductServiceImpl productService = new ProductServiceImpl();
        imageList = (ArrayList<ProductImage>) productService.getProductImages(productId);
        req.setAttribute("imageList", imageList);


        HttpSession session = req.getSession();
        session.setAttribute("productId", productId);
        session.setAttribute("productPrice", price);
        session.setAttribute("productName", name);
        session.setAttribute("productQuantity", quantity);
        session.setAttribute("productDiscount", discount);

        req.getRequestDispatcher("/productDetailSupplier.jsp").forward(req, resp);
    }
}

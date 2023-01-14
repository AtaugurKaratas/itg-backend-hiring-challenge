package com.itg.supplychainmanagement.controller;

import com.itg.supplychainmanagement.service.impl.ProductServiceImpl;
import com.itg.supplychainmanagement.util.ImageProcess;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Collection;
@MultipartConfig(fileSizeThreshold = 512*512*1,
maxFileSize = 1024*1024*1,
maxRequestSize = 1024*1024*2,
location = "/home/ataugurkaratas/Desktop/supply-chain-management/src/main/webapp/productImage")
@WebServlet(name = "add-product", value = "/add-product")
public class AddProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/addProduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("productName");
        float price = Float.parseFloat(req.getParameter("price"));
        HttpSession session = req.getSession(false);
        String retailerId = (String)session.getAttribute("retailerId");
        int productId = 0;
        if (productName != null && price != 0) {
            ProductServiceImpl productService = new ProductServiceImpl();
            productId = productService.addProduct(productName, price, Integer.parseInt(retailerId));
            Collection<Part> parts = req.getParts();
            ImageProcess imageProcess = new ImageProcess();
            for(Part filePart : parts){
                String fileName = imageProcess.getFileName(filePart);
                if (fileName != null){
                    productService.addProductImage("productImage/"+fileName, productId);
                    filePart.write(fileName);
                }
            }
            req.getRequestDispatcher("/homePageRetailer.jsp").forward(req, resp);
        }
    }
}


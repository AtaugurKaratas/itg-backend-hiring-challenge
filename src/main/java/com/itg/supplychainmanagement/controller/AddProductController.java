package com.itg.supplychainmanagement.controller;

import com.itg.supplychainmanagement.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Collection;

@MultipartConfig(fileSizeThreshold = 512*512*1,
maxFileSize = 1024*1024*1,
maxRequestSize = 1024*1024*2,
location = "/home/ataugurkaratas/Desktop/productImages")
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
            for(Part filePart : parts){
                String fileName = getFileName(filePart);
                if (fileName != null){
                    productService.addProductImage("/home/ataugurkaratas/Desktop/productImages/"+fileName, productId);
                    filePart.write(fileName);
                }
            }
            req.getRequestDispatcher("/homePageRetailer.jsp").forward(req, resp);
        }
    }

    private String getFileName(Part part){
        String contentDisposition = part.getHeader("content-disposition");
        if(!contentDisposition.contains("filename="))
            return null;
        int beginIndex = contentDisposition.indexOf("filename=") + 10;
        int endIndex = contentDisposition.length() - 1;

        return contentDisposition.substring(beginIndex, endIndex);
    }
}


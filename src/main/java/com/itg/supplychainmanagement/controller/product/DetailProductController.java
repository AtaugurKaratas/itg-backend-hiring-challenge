package com.itg.supplychainmanagement.controller.product;

import com.itg.supplychainmanagement.dto.ProductDTO;
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

@WebServlet(name = "detailProduct", value = "/detailProduct")
public class DetailProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF8");
        ArrayList<ProductImage> imageList = new ArrayList<>();
        int productId = Integer.parseInt(req.getParameter("id"));
        ProductServiceImpl productService = new ProductServiceImpl();
        ProductDTO productDTO = productService.getProductById(productId);
        productDTO.getProductImageList().forEach(x -> imageList.add(x));

        req.setAttribute("productDTO", productDTO);

        req.getRequestDispatcher("/productDetail.jsp").forward(req, resp);
    }
}

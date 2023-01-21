package com.itg.supplychainmanagement.controller.product;

import com.itg.supplychainmanagement.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "add-category", value = "/add-category")
public class AddCategoryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/addCategory.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryName = req.getParameter("categoryName");
        HttpSession session = req.getSession(false);

        CategoryServiceImpl categoryService = new CategoryServiceImpl();
        categoryService.addCategory(categoryName);
        req.getRequestDispatcher("/homePageRetailer.jsp").forward(req, resp);
    }
}

package com.itg.supplychainmanagement.controller;

import com.itg.supplychainmanagement.model.Bill;
import com.itg.supplychainmanagement.service.impl.BillServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(name = "bill-retailer", value = "/bill-retailer")
public class BillRetailerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF8");
        ArrayList<Bill> billListRetailer;
        HttpSession session = req.getSession();
        int retailerId = Integer.parseInt((String) session.getAttribute("retailerId"));
        BillServiceImpl billService = new BillServiceImpl();
        billListRetailer = billService.getAllBillRetailer(retailerId);
        req.setAttribute("billListRetailer", billListRetailer);
        req.getRequestDispatcher("/billRetailer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

package com.itg.supplychainmanagement.controller.bill;

import com.itg.supplychainmanagement.service.impl.BillServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "delete-bill", value = "/delete-bill")
public class DeleteBillRetailerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int billId = Integer.parseInt(req.getParameter("id"));
        HttpSession session = req.getSession();
        session.setAttribute("billId", billId);
        BillServiceImpl billService = new BillServiceImpl();
        billService.deleteBillById(billId);
        req.getRequestDispatcher("/bill-retailer").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int billId = Integer.parseInt(req.getParameter("id"));
        BillServiceImpl billService = new BillServiceImpl();
        billService.getAllCartById(billId);
        req.getRequestDispatcher("/bill-retailer").forward(req, resp);
    }
}

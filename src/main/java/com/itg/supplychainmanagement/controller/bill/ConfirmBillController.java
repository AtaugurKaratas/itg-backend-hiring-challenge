package com.itg.supplychainmanagement.controller.bill;

import com.itg.supplychainmanagement.service.impl.BillServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "confirm-bill", value = "/confirm-bill")
public class ConfirmBillController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF8");
        int billId = Integer.parseInt(req.getParameter("id"));
        BillServiceImpl billService = new BillServiceImpl();
        billService.checkBill(billId);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

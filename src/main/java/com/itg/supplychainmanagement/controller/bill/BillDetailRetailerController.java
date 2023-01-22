package com.itg.supplychainmanagement.controller.bill;

import com.itg.supplychainmanagement.dto.CartDTO;
import com.itg.supplychainmanagement.model.Cart;
import com.itg.supplychainmanagement.service.impl.BillServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "bill-detail-retailer", value = "/bill-detail-retailer")
public class BillDetailRetailerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF8");
        ArrayList<CartDTO> cartList;
        int billId = Integer.parseInt(req.getParameter("id"));
        HttpSession session = req.getSession();
        session.setAttribute("billId", billId);
        BillServiceImpl billService = new BillServiceImpl();
        cartList = billService.getAllCartById(billId);
        req.setAttribute("cartListById", cartList);
        req.getRequestDispatcher("/detailBillRetailer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

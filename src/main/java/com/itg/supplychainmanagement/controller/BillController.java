package com.itg.supplychainmanagement.controller;

import com.itg.supplychainmanagement.dto.BillDTO;
import com.itg.supplychainmanagement.service.impl.BillServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
@WebServlet(name = "billDetail", value = "/billDetail")
public class BillController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BillServiceImpl billService = new BillServiceImpl();
        ArrayList<BillDTO> billDTOList = billService.getAllBills();
        System.out.println(billDTOList);
        req.setAttribute("billList", billDTOList);
        req.getRequestDispatcher("/homePageSupplier.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

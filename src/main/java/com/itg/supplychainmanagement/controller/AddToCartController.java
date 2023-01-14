package com.itg.supplychainmanagement.controller;

import com.itg.supplychainmanagement.model.Cart;
import com.itg.supplychainmanagement.service.impl.BillServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet(name = "addToCart", value = "/addToCart")
public class AddToCartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF8");

        try(PrintWriter out = resp.getWriter()){
            ArrayList<Cart> cartList = new ArrayList<>();

            int productId = Integer.parseInt(req.getParameter("id"));
            double price = Double.parseDouble(req.getParameter("price"));
            String productName = req.getParameter("name");
            Cart cart = new Cart(1, price, productId);
            cart.setName(productName);

            HttpSession session = req.getSession();
            ArrayList<Cart> cartArrayList =  (ArrayList<Cart>) session.getAttribute("cartList");
            if(cartArrayList == null){
                cartList.add(cart);
                session.setAttribute("cartList", cartList);
                out.println("session created and added the list");
            } else{
                cartList = cartArrayList;
                session.setAttribute("cartList", cartList);
                out.println("session is not empty");
                boolean isHas = true;
                for(Cart c: cartList){
                    if(c.getProductId() == productId) {
                        c.setQuantity((c.getQuantity() + 1));
                        isHas = false;
                        session.setAttribute("cartList", cartList);
                    }
                }
                if(isHas){
                    cartList.add(cart);
                    session.setAttribute("cartList", cartList);
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ArrayList<Cart> cartArrayList =  (ArrayList<Cart>) session.getAttribute("cartList");
        req.setAttribute("cartList", cartArrayList);
        int retailerId = Integer.parseInt((String)session.getAttribute("retailerId"));
        BillServiceImpl billService = new BillServiceImpl();
        billService.addToBill(cartArrayList, retailerId);
        session.setAttribute("cartList", null);
    }
}

package com.itg.supplychainmanagement.controller.bill;

import com.itg.supplychainmanagement.dto.CartDTO;
import com.itg.supplychainmanagement.dto.ProductDTO;
import com.itg.supplychainmanagement.model.Cart;
import com.itg.supplychainmanagement.service.impl.BillServiceImpl;
import com.itg.supplychainmanagement.service.impl.ProductServiceImpl;

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

        try (PrintWriter out = resp.getWriter()) {
            ArrayList<CartDTO> cartList = new ArrayList<>();

            int productId = Integer.parseInt(req.getParameter("id"));
            ProductServiceImpl productService = new ProductServiceImpl();
            ProductDTO productDTO = productService.getProductById(productId);
            CartDTO cartDTO = new CartDTO(productDTO.getName(), 1, productDTO.getPrice(), false, productDTO.getProductId());

            HttpSession session = req.getSession();
            ArrayList<CartDTO> cartArrayList = (ArrayList<CartDTO>) session.getAttribute("cartList");
            if (cartArrayList == null) {
                cartList.add(cartDTO);
                session.setAttribute("cartList", cartList);
            } else {
                cartList = cartArrayList;
                session.setAttribute("cartList", cartList);
                boolean isHas = true;
                for (CartDTO c : cartList) {
                    if (c.getProductId() == productId) {
                        c.setQuantity((c.getQuantity() + 1));
                        isHas = false;
                        session.setAttribute("cartList", cartList);
                    }
                }
                if (isHas) {
                    cartList.add(cartDTO);
                    session.setAttribute("cartList", cartList);
                }
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ArrayList<CartDTO> cartArrayList =  (ArrayList<CartDTO>) session.getAttribute("cartList");
        req.setAttribute("cartList", cartArrayList);
        int retailerId = Integer.parseInt((String)session.getAttribute("retailerId"));
        BillServiceImpl billService = new BillServiceImpl();
        billService.addToBill(cartArrayList, retailerId);
        session.setAttribute("cartList", null);
    }
}
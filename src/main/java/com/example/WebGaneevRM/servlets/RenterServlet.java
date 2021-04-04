package com.example.WebGaneevRM.servlets;

import com.example.WebGaneevRM.data.RenterData;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RenterServlet", value = "/RenterServlet")
public class RenterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RenterData renterData = new RenterData();
        request.setAttribute("renters", renterData.selectRenter());
        getServletContext().getRequestDispatcher("/RenterJsp.jsp").forward(request,response);
    }
}

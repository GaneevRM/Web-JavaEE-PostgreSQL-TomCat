package com.example.WebGaneevRM.servlets;

import com.example.WebGaneevRM.data.RenterData;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RenterServlet", value = "/RenterServlet")
public class RenterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("action").equals("add")){
            getServletContext().getRequestDispatcher("/ContractJsp.jsp").forward(request,response);
        } else if (request.getParameter("action").equals("delete")) {
            String [] listCheckBox = request.getParameterValues("list");
            for (String id: listCheckBox) {
                try {
                    RenterData.deleteRenter(Integer.parseInt(id));
                } catch (SQLException e) {
                    e.printStackTrace();
                    if(e.getSQLState().equals("23503")){
                        request.setAttribute("error", "Удаление невозможно. Запись №" + Integer.parseInt(id) + " используется в другой таблице");
                        request.setAttribute("renters", RenterData.selectRenter());
                        getServletContext().getRequestDispatcher("/RenterJsp.jsp").forward(request, response);
                    }
                    break;
                }
            }
            request.setAttribute("renters", RenterData.selectRenter());
            getServletContext().getRequestDispatcher("/RenterJsp.jsp").forward(request, response);

        } else if(request.getParameter("action").equals("edit")){

        } else {
            request.setAttribute("renters", RenterData.selectRenter());
            getServletContext().getRequestDispatcher("/RenterJsp.jsp").forward(request, response);
        }
    }
}

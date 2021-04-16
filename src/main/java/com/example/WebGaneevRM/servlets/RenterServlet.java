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
        request.setAttribute("renters", RenterData.selectRenter());
        getServletContext().getRequestDispatcher("/RenterJsp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        switch (request.getParameter("action")) {
            case "ok":
                RenterData.addRenter(request.getParameter("nameOk"), request.getParameter("phoneOk"), request.getParameter("emailOk"));
                request.setAttribute("renters", RenterData.selectRenter());
                getServletContext().getRequestDispatcher("/RenterJsp.jsp").forward(request, response);
                break;
            case "delete": {
                String[] listCounter = request.getParameterValues("listCounter");
                String[] listId = request.getParameterValues("listId");
                for (String counter : listCounter) {
                    int counterForMass = Integer.parseInt(counter);
                    try {
                        RenterData.deleteRenter(Integer.parseInt(listId[counterForMass]));
                    } catch (SQLException e) {
                        if (e.getSQLState().equals("23503")) {
                            e.printStackTrace();
                        //    System.out.println(e + "Удаление невозможно. Запись №" + Integer.parseInt(listId[counterForMass]) + " используется в другой таблице");
                            request.setAttribute("error", "Удаление невозможно. Запись №" + Integer.parseInt(listId[counterForMass]) + " используется в другой таблице");
                            request.setAttribute("renters", RenterData.selectRenter());
                            getServletContext().getRequestDispatcher("/RenterJsp.jsp").forward(request, response);
                        }
                        break;
                    }
                }
                request.setAttribute("renters", RenterData.selectRenter());
                getServletContext().getRequestDispatcher("/RenterJsp.jsp").forward(request, response);

                break;
            }
            case "edit": {
                String[] listId = request.getParameterValues("listId");
                String[] listCounter = request.getParameterValues("listCounter");
                String[] listName = request.getParameterValues("listName");
                String[] listPhone = request.getParameterValues("listPhone");
                String[] listEmail = request.getParameterValues("listEmail");

                for (String counter : listCounter) {
                    try {
                        int counterForMass = Integer.parseInt(counter);
                        RenterData.editRenter(Integer.parseInt(listId[counterForMass]), listName[counterForMass], listPhone[counterForMass], listEmail[counterForMass]);
                    } catch (SQLException e) {
                        e.printStackTrace();
                        request.setAttribute("renters", RenterData.selectRenter());
                        getServletContext().getRequestDispatcher("/RenterJsp.jsp").forward(request, response);
                        break;
                    }
                }
                request.setAttribute("renters", RenterData.selectRenter());
                getServletContext().getRequestDispatcher("/RenterJsp.jsp").forward(request, response);
                break;
            }
            default:
                request.setAttribute("renters", RenterData.selectRenter());
                getServletContext().getRequestDispatcher("/RenterJsp.jsp").forward(request, response);
                break;
        }
    }
}

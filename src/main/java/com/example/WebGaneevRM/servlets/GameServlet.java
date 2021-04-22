package com.example.WebGaneevRM.servlets;

import com.example.WebGaneevRM.data.GameData;
import com.example.WebGaneevRM.data.RenterData;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "GameServlet", value = "/GameServlet")
public class GameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("games", GameData.selectGame());
        getServletContext().getRequestDispatcher("/GameJsp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        switch (request.getParameter("action")) {
            case "ok":
                GameData.addGame(request.getParameter("nameOk"), Date.valueOf(request.getParameter("dateOk")), Integer.parseInt(request.getParameter("numberOk")), request.getParameter("difficultyOk"));
                request.setAttribute("games", GameData.selectGame());
                getServletContext().getRequestDispatcher("/GameJsp.jsp").forward(request, response);
                break;
            case "delete": {
                String[] listCounter = request.getParameterValues("listCounter");
                String[] listId = request.getParameterValues("listId");
                for (String counter : listCounter) {
                    int counterForMass = Integer.parseInt(counter);
                    try {
                        GameData.deleteGame(Integer.parseInt(listId[counterForMass]));
                    } catch (SQLException e) {
                        e.printStackTrace();
                        if (e.getSQLState().equals("23503")) {
                            request.setAttribute("error", "Удаление невозможно. Запись №" + Integer.parseInt(listId[counterForMass]) + " используется в другой таблице");
                            request.setAttribute("games", GameData.selectGame());
                            getServletContext().getRequestDispatcher("/GameJsp.jsp").forward(request, response);
                        }
                        break;
                    }
                }
                request.setAttribute("games", GameData.selectGame());
                getServletContext().getRequestDispatcher("/GameJsp.jsp").forward(request, response);

                break;
            }
            case "edit": {
                String[] listId = request.getParameterValues("listId");
                String[] listCounter = request.getParameterValues("listCounter");
                String[] listName = request.getParameterValues("listName");
                String[] listDate = request.getParameterValues("listDate");
                String[] listNumber = request.getParameterValues("listNumber");
                String[] listDifficulty = request.getParameterValues("listDifficulty");


                for (String counter : listCounter) {
                    try {
                        int counterForMass = Integer.parseInt(counter);
                        GameData.editGame(Integer.parseInt(listId[counterForMass]), listName[counterForMass], Date.valueOf(listDate[counterForMass]), Integer.parseInt(listNumber[counterForMass]), listDifficulty[counterForMass]);
                    } catch (SQLException e) {
                        e.printStackTrace();
                        request.setAttribute("games", GameData.selectGame());
                        getServletContext().getRequestDispatcher("/GameJsp.jsp").forward(request, response);
                        break;
                    }
                }
                request.setAttribute("games", GameData.selectGame());
                getServletContext().getRequestDispatcher("/GameJsp.jsp").forward(request, response);
                break;
            }
            default:
                request.setAttribute("games", GameData.selectGame());
                getServletContext().getRequestDispatcher("/GameJsp.jsp").forward(request, response);
                break;
        }
    }
}

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="com.example.WebGaneevRM.data.ConsiderationData" %>
<!DOCTYPE html>
<html>
<head>
    <title>Добро пожаловать!</title>
</head>
    <body>
        <h1>Добро пожаловать!</h1>
        <form method="post" action="RenterServlet">
            <button>Арендаторы</button>
        </form>
        </br>
        <form method="post" action="LandlordJsp.jsp">
            <button>Арендодатели</button>
        </form>
        </br>
        <form method="post" action="ContractJsp.jsp">
            <button>Договоры</button>
        </form>
        </br>
        <form method="post" action="GameJsp.jsp">
            <button>Игры</button>
        </form>
        </br>
        <form method="post" action="ConsiderationJsp.jsp">
            <button>Складской учёт</button>
        </form>
    </body>
</html>
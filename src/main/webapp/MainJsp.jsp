<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="com.example.WebGaneevRM.data.ConsiderationData" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Добро пожаловать!</title>
    <link href="css/main.css" rel="stylesheet"/>
</head>
    <body>
        <header class="main_block">
            Аренда настольных игр
        </header>
        <main class="main_block">
            <p>Добро пожаловать!</p>
            <form method="post" action="RenterServlet">
                <button>Арендаторы</button>
            </form>
            <br>
            <form method="post" action="LandlordJsp.jsp">
                <button>Арендодатели</button>
            </form>
            <br>
            <form method="post" action="ContractJsp.jsp">
                <button>Договоры</button>
            </form>
            <br>
            <form method="post" action="GameJsp.jsp">
                <button>Игры</button>
            </form>
            <br>
            <form method="post" action="ConsiderationJsp.jsp">
                <button>Складской учёт</button>
            </form>
        </main>
        <footer class="main_block">
            Разработчик: Ганеев Рустам
            <br>
            ganeevrm@yahoo.com
        </footer>
    </body>
</html>
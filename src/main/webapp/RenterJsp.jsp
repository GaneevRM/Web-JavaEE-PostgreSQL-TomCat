<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.WebGaneevRM.data.RenterData" %>
<%@ page import="com.example.WebGaneevRM.dto.RenterDTO" %>
<%@ page import="java.util.LinkedList" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Добро пожаловать!</title>
    <link href="css/main.css" rel="stylesheet"/>
</head>
    <body>
    <header>
        <div class="main_block name_bar">Аренда настольных игр</div>
        <div class="main_block bar">
            <form method="post" action="RenterServlet">
                <button>Арендаторы</button>
            </form>
            <form method="post" action="LandlordJsp.jsp">
                <button>Арендодатели</button>
            </form>
            <form method="post" action="ContractJsp.jsp">
                <button>Договоры</button>
            </form>
            <form method="post" action="GameJsp.jsp">
                <button>Игры</button>
            </form>
            <form method="post" action="ConsiderationJsp.jsp">
                <button>Учёт</button>
            </form>
        </div>
    </header>
        <main class="main_block">
            <p>Арендаторы</p>
            <div class="tale_block lightyellow">
                <table border="2">
                    <thead>
                    <tr>
                        <th><input type="checkbox" onclick="onClickMainCheckBox(this)"></th>
                        <th>ID</th>
                        <th>ФИО</th>
                        <th>Телефон</th>
                        <th>Email</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${renters}">
                        <tr>
                            <td><input type="checkbox" name="checkBox"></td>
                            <td class="id_col">${item.getId_renter()}</td>
                            <td><input type="text" onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;" value="${item.getName_renter()}"></td>
                            <td><input type="tel" value="${item.getPhone()}"></td>
                            <td><input type="email" value="${item.getEmail()}"></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <br>
            <div class="main_block lightyellow">
                <form method="post">
                <button>Добавить</button>
                </form>
                <form method="post">
                    <button>Удалить</button>
                </form>
                <form method="post">
                    <button>Редактировать</button>
                </form>
            </div>
        </main>
        <footer class="main_block">
            Разработчик: Ганеев Рустам
            <br>
            ganeevrm@yahoo.com
        </footer>
    <script src="js/main.js"></script>
    </body>
</html>
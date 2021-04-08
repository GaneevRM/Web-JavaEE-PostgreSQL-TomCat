<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.WebGaneevRM.data.RenterData" %>
<%@ page import="com.example.WebGaneevRM.dto.RenterDTO" %>
<%@ page import="java.util.LinkedList" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
    <head>
        <title>Арендаторы</title>
        <link href="css/main.css" rel="stylesheet"/>
    </head>
    <body>
        <header>
            Аренда настольных игр
        </header>
        <h1>Арендаторы</h1>
        <br>
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
                    <td>${item.getId_renter()}</td>
                    <td><input type="text" value="${item.getName_renter()}"></td>
                    <td><input type="tel" value="${item.getPhone()}"></td>
                    <td><input type="email" value="${item.getEmail()}"></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <script src="js/main.js"></script>
    </body>
</html>

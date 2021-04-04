<%@ page import="com.example.WebGaneevRM.data.RenterData" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Ошибка</title>
    </head>
    <body>
        <h1>Ошибка</h1>>
        <%
            RenterData renterData = new RenterData();
            renterData.selectRenter();
        %>
    </body>
</html>

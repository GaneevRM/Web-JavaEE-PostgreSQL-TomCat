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
    <link href="css/modal.css" rel="stylesheet">
    <script src="js/modal.js"></script>
</head>
    <body>
    <header>
        <div class="main_block name_bar">Аренда настольных игр</div>
        <div class="main_block bar">
            <form method="post" action="RenterServlet">
                <button name="action" value="renterPage">Арендаторы</button>
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
            <form method="post" action="RenterServlet">
            <p>Арендаторы</p>
            <div class="table_block lightyellow">
                <table border="2">
                    <thead>
                    <tr>
                        <th><input type="checkbox" onclick="onClickMainCheckBox(this)"></th>
                        <th>№</th>
                        <th>ФИО</th>
                        <th>Телефон</th>
                        <th>Email</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${renters}">
                        <tr>
                            <td><input type="checkbox" name="list" value=${item.getId_renter()}></td>
                            <td class="id_col">${item.getId_renter()}</td>
                            <td><input type="text" class="input_table" value="${item.getName_renter()}"></td>
                            <td><input type="tel" class="input_table" value="${item.getPhone()}"></td>
                            <td><input type="email" class="input_table" value="${item.getEmail()}"></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <br>
            </form>


            <div class="main_block lightyellow">
                <button id="actionAdd" name="action" value="add">Добавить</button>
                <button name="action" value="delete">Удалить</button>
                <button id="actionEdit" name="action" value="edit">Редактировать</button>
            </div>

            <script>
                var modal = $modal({
                    title: 'Добавление новой записи',
                    content: '<form method="post" action="RenterServlet">' +
                        '<p><b>ФИО:</b><br>' +
                        '<input required type="text" class="input_modal"></p>' +
                        '<p><b>Телефон:</b><br>' +
                        '<input required type="tel" class="input_modal"></p>' +
                        '<p><b>Email:</b><br>' +
                        '<input required type="email" class="input_modal"></p>' +
                        '</form>',
                    footerButtons: [
                        { class: 'btn btn__cancel', text: 'Отмена', handler: 'modalHandlerCancel' },
                        { class: 'btn btn__ok', text: 'ОК', handler: 'modalHandlerOk' }
                    ]
                });
                document.querySelector('#actionAdd').addEventListener('click', function(e) {
                    modal.show();
                });

                document.querySelector('#actionEdit').addEventListener('click', function(e) {
                    modal.show();
                });
            </script>

            <%
                String errorM = (String) request.getAttribute("error");
            %>
            <c:if test="${error!=null}">
                <script>
                    var error="<%= errorM%>";
                    alert(error);
                </script>
            </c:if>
        </main>
        <footer class="main_block">
            Разработчик: Ганеев Рустам
            <br>
            ganeevrm@yahoo.com
        </footer>
    <script src="js/main.js"></script>
    </body>
</html>
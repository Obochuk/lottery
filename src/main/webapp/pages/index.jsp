<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Головна сторінка</title>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge">
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

<div class="white">
    <header class="main">
        <hr>
        <h1 align="center">Онлайн лоторея</h1>
        <hr>
        <div class="row">
            <img src="<c:url value='pages/images/logo.jpg'/>" alt="logo" height="100" width="92">
            <nav>
                <a href="${pageContext.servletContext.contextPath}">Головна сторінка</a>
                <a href="deal">Зробити ставку</a>
                <a href="about">Про лоторею</a>
            </nav>
            <div class="logIn" align="right">
                <a href="login" class="log">Login</a>
                <br> <br>
                <a href="register" class="log">Register</a>
            </div>
        </div>
        <hr>
    </header>

    <div class="content">
        <strong><a href="deal">Зроби ставку</a> та вигравай просто зараз!</strong>
        <br>
        <p style="vertical-align: middle">
            <strong>Результати попереднього розіграшу</strong>
        <p align="center" style="color: #8f80ff">
            ${time} ${result}
        </p>
        ${text}
        </p>

        <strong>Не втрачай можливості взяти участь у наступному розіграші, що відбудеться
            <%
                Date today = new Date();
                Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
                java.sql.Date tmr = new java.sql.Date(tomorrow.getTime());
                out.print("<p align='center'>" + tmr + "</p>");
            %>

        </strong>
    </div>
</div>

<p align="center">The developer is <a href="https://www.linkedin.com/in/vlad-obochuk-ab9494ba/">Vlad Obochuk</a>.
    You can see source of the project on <a href="https://github.com/Obochuk/GroupPage">github</a></p>

</body>
</html>
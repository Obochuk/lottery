<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>New super LOTTERY</title>
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

    <h1 align="center">Старт розіграшу</h1> <br>
    <div align="center">
    <form  action="start" method="get">
        <input type="submit" name="start" value="Почати розіграш">
    </form>
    </div>
    <br>

    <p style="border: 1px; border-color: blueviolet; text-align: center">${result}</p>


</div>

<p align="center">The developer is <a href="https://www.linkedin.com/in/vlad-obochuk-ab9494ba/">Vlad Obochuk</a>.
    You can see source of the project on <a href="https://github.com/Obochuk/GroupPage">github</a></p>

</body>
</html>

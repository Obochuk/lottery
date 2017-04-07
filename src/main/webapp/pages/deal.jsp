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

    <h1 align="center">Приймання ставки</h1>
    <br>
    <p style="font-size: 26px; color: red; border: 1px">${errMessage}</p>
    <p style="font-size: 26px; color: green; border: 1px">${message}</p>

    <div class="content">
        <strong>Визначте бажане число у межах від 0 до 2 000 000 000 та впишіть його у наступне поле:</strong>
        <br>
        <br>
        <br>
        <p style="vertical-align: middle">
        <form action="deal" method="get">
            <input type="number" name="number">
            <a href="about" style="text-decoration: none; user-select: none; padding: .1em .2em; background: #8f80ff; text-align: right">?</a>
            <br>
            <input type="submit" value="Зробити ставку">
        </form>
        </p>
        <br>
    </div>
</div>

<p align="center">The developer is <a href="https://www.linkedin.com/in/vlad-obochuk-ab9494ba/">Vlad Obochuk</a>.
    You can see source of the project on <a href="https://github.com/Obochuk/GroupPage">github</a></p>

</body>
</html>
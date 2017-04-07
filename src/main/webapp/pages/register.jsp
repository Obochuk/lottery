<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.Jcrop.min.js"></script>
    <script type="text/javascript" src="js/query.js"></script>
    <link rel="stylesheet" href="css/jquery.Jcrop.css" type="text/css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <title>Реєстрація</title>
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

    <div align="center">

        <h1>Реєстрація нового користувача у системі</h1>

        <form action="register" method="post" enctype="multipart/form-data">
            Ім'я:  <input type="text" name="userName" title="Name" autofocus/><br>
            Пароль: <input type="password" name="userPassword" title="Password"><br>
            Про себе(не обов'язково): <br> <textarea name="description" title="Description" cols="50" rows="8"></textarea><br>
            Фото: <input type="file" name="photo" accept="image/*" id="imgInp" onchange="loadFile(event)"><br>

            <img id="loaded" src="#" alt="Your image" hidden/> <br>

            <input type="hidden" name="x" id="x"/>
            <input type="hidden" name="y" id="y"/>
            <input type="hidden" name="w" id="w"/>
            <input type="hidden" name="h" id="h"/>
            <input type="submit" name="Crop" value="Зареєструватися"/>
        </form>
    </div>

</div>

<p align="center">The developer is <a href="https://www.linkedin.com/in/vlad-obochuk-ab9494ba/">Vlad Obochuk</a>.
    You can see source of the project on <a href="https://github.com/Obochuk/GroupPage">github</a></p>

</body>
</html>


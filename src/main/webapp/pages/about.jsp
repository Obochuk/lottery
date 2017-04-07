<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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
            <img src="<c:url value="pages/images/logo.jpg"/>" alt="logo" height="100" width="92">
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

    <h1 align="center">Про лоторею</h1>

    <p style="text-indent: 2em; padding: 20px">
        Ціллю даної лотореї є визначити число, що буде згенероване на сервері у відповідний період,
        що заданий на головній сторінці сайту. Для того щоб мати змогу спробувати вгадати число, потрібно увійти
        у систему(якщо не зареєстровані, то потрібно спочатку зареєструватися). Після успішного входу в систему,
        перейти в пункт меню "Зробити ставку", та у відповідному полі ввести бажане число(воно має бути цілим та
        знаходитись у межах [0; 2 000 000 000]). Результат лотореї з'явиться на головній сторінці, в час, що був
        на ній же написано. У разі виграшу на головній сторінці, появиться текст виділений зеленим кольором,
        що сповіщає про виграш. <br>
        У разі виникнення додаткових питань чи пропозицій, можете писати за адресою:
        <a href="mailto:vlad.obochuk@gmail.com?subject=Онлайн Лоторея">vlad.obochuk@gmail.com</a> <br>
        Дана лоторея не порушує <a href="http://zakon3.rada.gov.ua/laws/show/5204-17">Законодавства України</a>
    </p>

</div>

<p align="center">The developer is <a href="https://www.linkedin.com/in/vlad-obochuk-ab9494ba/">Vlad Obochuk</a>.
    You can see source of the project on <a href="https://github.com/Obochuk/GroupPage">github</a></p>

</body>
</html>
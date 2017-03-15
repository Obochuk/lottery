<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.Jcrop.min.js"></script>
    <script type="text/javascript" src="js/query.js"></script>
    <link rel="stylesheet" href="css/jquery.Jcrop.css" type="text/css">
    <title>Register</title>
</head>
<body>


<form  action="register" method="post" enctype="multipart/form-data">
    Name: <input type="text" name="userName" title="Name" autofocus/><br>
    Password: <input type="password" name="userPassword" title="Password"><br>
    Description: <textarea name="description" title="Description" cols="50" rows="8"></textarea><br>
    Photo: <input type="file" name="photo" accept="image/*" id="imgInp" onchange="loadFile(event)"><br>

    <img id="loaded" src="#" alt="Your image" hidden/> <br>

    <input type="hidden" name="x" id="x"/>
    <input type="hidden" name="y" id="y"/>
    <input type="hidden" name="w" id="w"/>
    <input type="hidden" name="h" id="h"/>
    <input type="submit" name="Crop" value="Crop"/>
</form>

</body>
</html>

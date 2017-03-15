<%--suppress ALL --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>NAU SP-325</title>
</head>
<body>
<h1 align="center">Our group SP-325</h1>

<table align="center" cellpadding="20" width="100%">
    <tr align="center">
        <td width="15%"><img src="<c:url value='/pages/images/ikit325.jpg'/>" alt="Group logo"/></td>
        <td>The students of 325 group of National Aviation University</td>
        <td width="5%" align="right">
            <a href="login"><input type="submit" value="Login"></a>
            <br>
            <a href="register">register</a>
        </td>
    </tr>
    <tr align="center">
        <td>Menu</td>
        <td colspan="2">Content</td>
    </tr>


    <c:forEach var="user" items="${result}">
        <tr>
            <td>
                <img src="${pageContext.servletContext.contextPath}/photoServlet?id=${user.id}&crop=true"
                     alt="${user.name} photo" height="200"/>

            </td>
            <td colspan="2">
                Student: <b>${user.name}</b><br>
                About him: <em>${user.description}</em>
            </td>
        </tr>
    </c:forEach>
    <tr align="center">
        <td colspan="3">Bottom</td>
    </tr>
</table>
</body>

</html>

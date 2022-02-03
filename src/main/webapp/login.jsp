<%--
  Created by IntelliJ IDEA.
  User: ac
  Date: 2/3/22
  Time: 11:48 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form method="POST" action="${pageContext.request.contextPath}/login.jsp">
    <label for="username">Username:</label>
    <input id="username" name="username" placeholder="Enter your Username">
    <label for="password">Password:</label>
    <input id="password" name="password" placeholder="Enter your Password">
    <input type="submit"/>
</form>

<c:choose>
    <c:when test="${param.username.equals('admin') && param.password.equals('password')}">
        <c:redirect url="/profile.jsp"/>
    </c:when>
</c:choose>

</body>
</html>

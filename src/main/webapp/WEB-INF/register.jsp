<%--
  Created by IntelliJ IDEA.
  User: ac
  Date: 2/10/22
  Time: 2:02 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Registration" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1>Register New User</h1>
    <form action="/register" method="POST">
        <div class="form-group">
            <label for="username">Username</label>
            <input id="username" name="username" type="text">
        </div>
        <div class="form-group">
            <label for="email">E-Mail</label>
            <textarea id="email" name="email" type="text"></textarea>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <textarea id="password" name="password" type="text"></textarea>
        </div>
        <input type="submit">
    </form>
</div>
</body>
</html>

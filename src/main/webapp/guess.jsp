<%--
  Created by IntelliJ IDEA.
  User: ac
  Date: 2/4/22
  Time: 2:20 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="guess" method="POST">
    <label for="number">Guess a Number Between 1 and 3</label>
    <input name="number" id="number" type="number" min="1" max="3">
    <input type="submit">
</form>
</body>
</html>

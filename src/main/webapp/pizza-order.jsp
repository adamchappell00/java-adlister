<%--
  Created by IntelliJ IDEA.
  User: ac
  Date: 2/4/22
  Time: 11:42 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order Form</title>
</head>
<body>
<h1>Select Your Options</h1>
<form action="pizza-order" method="POST">
    <div>
        <label for="crust">Crust</label>
        <select name="crust" id="crust">
            <option value="Thin">Thin</option>
            <option value="Pan" selected>Pan</option>
            <option value="Stuffed">Stuffed</option>
        </select>
    </div>
    <div>
        <label for="sauce">Sauce</label>
        <select name="sauce" id="sauce">
            <option value="tomato" selected>Tomato</option>
            <option value="alfredo">Alfredo</option>
            <option value="BBQ">BBQ</option>
        </select>
    </div>
    <div>
        <label for="size">Size</label>
        <select name="size" id="size">
            <option value="Personal">Personal</option>
            <option value="Medium" selected>Medium</option>
            <option value="Large">Large</option>
        </select>
    </div>
    <div>
        <div>
            <input type="checkbox" name="sausage" id="sausage" value="sausage-yes">
            <label for="sausage">Sausage</label>
        </div>
        <div>
            <input type="checkbox" name="ham" id="ham" value="ham-yes">
            <label for="ham">Ham</label>
        </div>
        <div>
            <input type="checkbox" name="bacon" id="bacon" value="bacon-yes">
            <label for="bacon">Bacon</label>
        </div>
        <div>
            <input type="checkbox" name="mushrooms" id="mushrooms" value="mushrooms-yes">
            <label for="mushrooms">Mushrooms</label>
        </div>
        <div>
            <input type="checkbox" name="spinach" id="spinach" value="spinach-yes">
            <label for="spinach">Spinach</label>
        </div>
        <div>
            <input type="checkbox" name="olives" id="olives" value="olives-yes">
            <label for="olives">Olives</label>
        </div>
    </div>
    <div>
        <label for="address">Delivery Address</label>
        <input id="address" name="address" type="text">
    </div>
    <input type="submit">
</form>
</body>
</html>

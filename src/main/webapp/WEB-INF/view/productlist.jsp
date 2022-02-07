<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Repository Listing</title>
</head>
<body>
<h1>Product List</h1>
<table>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Price</th>
        </tr>
        <c:forEach var="product" items="${list}">
            <tr>
                <td><a href="/products/${product.id}">${product.id}<a/></td>
                <td>${product.title}</td>
                <td>${product.cost}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
<a href="/products/add">ADD<a/>
</body>
</html>
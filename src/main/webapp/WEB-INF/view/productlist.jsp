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
                <td>${product.id}</td>
                <td>${product.title}</td>
                <td>${product.cost}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
<c:url var="addProduct" value="/products/add"/>
<a href="${addProduct}">ADD<a/>
</body>
</html>
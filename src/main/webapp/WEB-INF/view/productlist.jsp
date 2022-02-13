<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Repository Listing</title>
</head>
<body>
<h1>Product List</h1>
<c:url var="sortAscUrl" value="/products/">
<c:param name="sort" value="asc"/>
</c:url>
<a href="${sortAscUrl}">SORT ASC</a>
<c:url var="sortDescUrl" value="/products/">
<c:param name="sort" value="desc"/>
</c:url>
<a href="${sortDescUrl}">SORT DESC</a>
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
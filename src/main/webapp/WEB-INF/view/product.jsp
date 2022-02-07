<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Detail</title>
</head>
<body>
<h1>Product Detail</h1>
<h2>Id: ${product.id} </h2>
<h2>Title: ${product.title} </h2>
<h2>Price: ${product.cost} </h2>
<br>
<c:url var="removeUrl" value="/products/remove">
<c:param name="id" value="${product.id}"/>
</c:url>
<a href="${removeUrl}">REMOVE</a>
<br>
<a href="/products/">BACK</a>
</body>
</html>
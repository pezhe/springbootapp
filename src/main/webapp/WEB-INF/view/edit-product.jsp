<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<%--@elvariable id="product" type="ru.gb.springbootapp.model.Product"--%>
<form:form action="add" modelAttribute="product">
<form:hidden path="id" value="${product.id}"/>
Title: <form:input path="title"/>
<br>
Price: <form:input path="cost"/>
<br>
<input type="submit" value="Save"/>
</form:form>
</body>
</html>
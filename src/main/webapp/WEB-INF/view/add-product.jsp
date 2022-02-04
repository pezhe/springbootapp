<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
<form:form action="add" modelAttribute="product">
Title: <form:input path="title"/>
<br>
Price: <form:input path="cost"/>
<br>
<input type="submit" value="Add"/>
</form:form>
</body>
</html>
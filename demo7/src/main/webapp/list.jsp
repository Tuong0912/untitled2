<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03/03/2023
  Time: 02:07 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><a href="/productServlet?action=create">Create new Product</a></p>
<table border="1">
    <tr>
        <td>ID</td>
        <td>MaSP</td>
        <td>Name</td>
        <td>Price</td>
        <td>NhaSX</td>
        <td>Note</td>
    </tr>
    <c:forEach var="p" items="${product}">
        <tr>
            <td><a href="/productServlet?action=view&id=${p.id()}">${p.id()}</a></td>
            <td>${p.maSP()}</td>
            <td>${p.name()}</td>
            <td>${p.price()}</td>
            <td>${p.nhaSX()}</td>
            <td>${p.note()}</td>
            <td><a href="/productServlet?action=edit&id=${p.id()}">Edit</a></td>
            <td><a href="/productServlet?action=delete&id=${p.id()}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

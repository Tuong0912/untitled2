<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03/03/2023
  Time: 02:58 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><a href="/productServlet">Back to Product list</a></p>
<table>
    <tr>
        <td>ID</td>
        <td>${product.id()}</td>
    </tr>    <tr>
        <td>MaSP</td>
        <td>${product.maSP()}</td>
    </tr>    <tr>
        <td>Name</td>
        <td>${product.name()}</td>
    </tr>    <tr>
        <td>Price</td>
        <td>${product.price()}</td>
    </tr>    <tr>
        <td>NhaSX</td>
        <td>${product.nhaSX()}</td>
    </tr>
    <tr>
        <td>Note</td>
        <td>${product.note()}</td>
    </tr>
</table>
</body>
</html>

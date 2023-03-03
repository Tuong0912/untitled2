<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03/03/2023
  Time: 02:27 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><a href="/productServlet">Back to Products list</a></p>
<form method="post">
    <fieldset>
        <legend>Edit</legend>
        <table>
            <tr>
                <td>ID</td>
                <td><input type="text" name="id" value="${product.id()}" readonly></td>
            </tr>
            <tr>
                <td>MaSP</td>
                <td><input type="text" name="masp" value="${product.maSP()}"></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="${product.name()}"></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="text" name="price" value="${product.price()}"></td>
            </tr>
            <tr>
                <td>NhaSX</td>
                <td><input type="text" name="nhasx" value="${product.nhaSX()}"></td>
            </tr>
            <tr>
                <td>Note</td>
                <td><input type="text" name="note" value="${product.note()}"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

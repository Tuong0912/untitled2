<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03/03/2023
  Time: 02:14 CH
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
        <legend>Create</legend>
        <table>
            <tr>
                <td>maSP</td>
                <td><input type="text" name="maSP"></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="text" name="price"></td>
            </tr>
            <tr>
                <td>nhaSX</td>
                <td><input type="text" name="nhaSX"></td>
            </tr>
            <tr>
                <td>Note</td>
                <td><input type="text" name="note"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="position: center">Danh sách khách hàng</h1>
<form action="customerServlet">
    <table border="1">
        <tr>
            <td>Id</td>
            <td>Date of Birth</td>
            <td>Location</td>
            <td>Name</td>
        </tr>

        <c:forEach items='${customer}' var="cus">
            <tr>
                <td>${cus.getId()}</td>
                <td>${cus.getName()}</td>
                <td>${cus.getDate()}</td>
                <td>${cus.getLocation()}</td>
            </tr>
        </c:forEach>

    </table>
</form>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: mechrevo
  Date: 2022-02-11
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工列表</title>
</head>
<body>
<table>
    <tr>
        <td>id</td>
        <td>lastName</td>
        <td>email</td>
        <td>gender</td>
    </tr>
    <c:forEach items="${allEmployees}" var="emp">
        <tr>
            <td>${emp.id }</td>
            <td>${emp.lastName }</td>
            <td>${emp.email }</td>
            <td>${emp.gender }</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>

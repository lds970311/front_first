<%--
  Created by IntelliJ IDEA.
  User: WARRIOR
  Date: 2022-01-31
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>index page</title>
</head>
<body>
<div class="header">
    <c:forEach begin="1" end="10" step="1" var="index">
        <span>${index}</span>
    </c:forEach>
</div>
</body>
</html>

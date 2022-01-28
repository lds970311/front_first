<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Mybatis</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="main-section">
    <h1>Hello Mybatis</h1>
    <p>
        <c:forEach begin="1" end="10" step="1" var="index">
            <span>${index}</span>
        </c:forEach>
    </p>
</div>
</body>
</html>

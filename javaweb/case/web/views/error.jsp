<%--
  Created by IntelliJ IDEA.
  User: mechrevo
  Date: 2022-01-21
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String msg = exception.getMessage();
%>
<h3>
    <%= msg%>
</h3>
</body>
</html>

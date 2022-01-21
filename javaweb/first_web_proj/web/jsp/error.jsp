<%--
  Created by IntelliJ IDEA.
  User: mechrevo
  Date: 2022-01-20
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<%
    String message = exception.getMessage();
%>
<h1>
    <%=
    message
    %>
</h1>


</body>
</html>

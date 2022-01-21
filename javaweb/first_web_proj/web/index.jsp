<%--
  Created by IntelliJ IDEA.
  User: mechrevo
  Date: 2022-01-18
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>this is index jsp</title>
</head>
<body>
<h1>Hello Tomcat123123123</h1>
<%--定义成员变量--%>
<%!
    int i = 10;
    String msg = "my msg";
%>
<div>
    <p>
        <%= i %>
    </p>
    <p>
        <%= msg %>
    </p>
</div>


</body>
</html>

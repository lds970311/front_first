<%--
  Created by IntelliJ IDEA.
  User: mechrevo
  Date: 2022-01-21
  Time: 0:46
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <title>el表达式</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        .main {
            width: 800px;
            min-height: 300px;
            border: 1px solid grey;
            margin: 0 auto;
        }

        .main h3 {
            text-align: center;
        }
    </style>
</head>
<body>
<%
    request.setAttribute("name", "zhangsan");
%>
<div class="main">
    <h3>el表达式</h3>
    <span>${1<2}</span>
    <span>${1+10}</span>
    <span>${6/2}</span>
    <span>${6%5}</span>
    <span>
        ${requestScope.name}
    </span>
    <span>
        ${requestScope.get("name")}
    </span>
</div>
</body>
</html>

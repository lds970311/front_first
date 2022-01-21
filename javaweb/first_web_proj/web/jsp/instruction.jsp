<%--
  Created by IntelliJ IDEA.
  Date: 2022-01-20
  Time: 23:26
--%>

<%--jsp指令--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" errorPage="error.jsp" isErrorPage="false"
%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--导入页面资源--%>
<%@ include file="header.jsp" %>
<%--导入jstl--%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
    <title>JSP指令</title>
</head>
<body>
<%
    List<String> list = new ArrayList<>();
    ServletContext context = request.getServletContext();
%>

</body>
</html>

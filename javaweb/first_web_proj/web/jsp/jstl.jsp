<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.evan.web.beans.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" isErrorPage="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>使用Jstl</title>
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
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.6.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.6.1/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<%
    pageContext.setAttribute("num", 5);
%>

<%
    request.setAttribute("score", 90);
%>

<%
    Book book1 = new Book("西游记", 49.99, "神魔小说");
    Book book2 = new Book("骆驼祥子", 69.99, "小说");
    Book book3 = new Book("聊斋", 49.99, "故事类");
    pageContext.setAttribute("favourite", book1);
    //初始化list
    List<Book> bookList = new ArrayList<>();
    bookList.add(book1);
    bookList.add(book2);
    bookList.add(book3);
    pageContext.setAttribute("bookList", bookList);
%>
<div class="main">
    <c:forEach begin="1" end="5" step="1" var="a">
        <span>${a}</span>
    </c:forEach>

    <%--if--%>
    <c:if test="${num >5}">
        <div>num >5</div>
    </c:if>
    <c:if test="${num <=5}">
        <div>num <=5</div>
    </c:if>


    <%--<c:redirect url="https://www.baidu.com">

    </c:redirect>--%>

    <c:choose>
        <c:when test="${requestScope.score >= 80}">优秀</c:when>
        <c:when test="${requestScope.score >= 60}">及格</c:when>
        <c:otherwise>不及格</c:otherwise>
    </c:choose>
    <br/>
    <table border="1" class="table table-bordered table-hover">
        <thead>
        <tr class="success">
            <td>书名</td>
            <td>价格</td>
            <td>分类</td>
        </tr>
        </thead>
        <c:forEach items="${bookList}" var="book" varStatus="i">
            <c:if test="${i.count % 2 == 0}">
                <tr bgcolor="#5f9ea0">
                    <td>${book.name}</td>
                    <td>${book.price}</td>
                    <td>${book.category}</td>
                </tr>
            </c:if>
            <c:if test="${i.count % 2 != 0}">
                <tr bgcolor="#7fff00">
                    <td>${book.name}</td>
                    <td>${book.price}</td>
                    <td>${book.category}</td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
</div>
</body>
</html>

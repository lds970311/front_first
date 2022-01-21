<%@ page import="com.evan.web.beans.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>

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

    //初始化Map
    Map<String, Book> bookMap = new HashMap<>();
    bookMap.put("a", book1);
    bookMap.put("b", book2);
    bookMap.put("c", book3);
    pageContext.setAttribute("bookMap", bookMap);
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

    <p class="obj">
        <%--获取对象--%>
        <span>${pageScope.favourite.name}</span>
        <br/>
        <%--List--%>
        <span>${pageScope.bookList[1].name}</span>
        <%--map--%>
        <span>${bookMap.c.name}</span>
    </p>
    <%--获取虚拟目录--%>
    <p>${pageContext.request.contextPath}</p>
</div>
</body>
</html>

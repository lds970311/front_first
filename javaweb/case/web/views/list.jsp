<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.codewolf.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="false" errorPage="error.jsp" %>

<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>用户信息管理系统</title>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.6.1/js/bootstrap.min.js"></script>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.6.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/UserHandler.js"></script>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
    <style type="text/css">
        td, th {
            text-align: center;
        }

        .form-group input {
            width: 120px;
        }

        .form-group label {
            margin: 0 5px 0 16px;
        }

        .my-form {
            float: left;
            max-width: 600px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .my-form .btn {
            margin-left: 16px;
        }

    </style>
</head>
<body>
<div class="container-md">
    <h3 style="text-align: center">用户信息列表</h3>

    <div class="my-form">
        <form class="form-inline" method="post" action="${pageContext.request.contextPath}/findByPage">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" name="name" value="${condition.name[0]}" id="exampleInputName2">
            </div>
            <div class="form-group">
                <label for="exampleInputName3">籍贯</label>
                <input type="text" name="address" value="${condition.address[0]}" id="exampleInputName3">
            </div>

            <div class="form-group">
                <label for="exampleInputEmail2">邮箱</label>
                <input type="text" name="email" value="${condition.email[0]}" id="exampleInputEmail2">
            </div>
            <button type="submit" class="btn btn-warning">查询</button>
        </form>

    </div>
    <div style="float: right;margin: 5px;">

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/views/add.jsp">添加联系人</a>
        <span class="btn btn-primary" onclick="handleIdSelect()" id="delSelected">删除选中</span>

    </div>
    <table border="1" class="table table-bordered table-hover">
        <tr class="table-head">
            <th><label for="firstCb"></label><input type="checkbox" id="firstCb"></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${page.list}" var="user" varStatus="s">
            <tr>
                <td><label>
                    <input type="checkbox" name="uid" value="${user.id}">
                </label></td>
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.address}</td>
                <td>${user.qq}</td>
                <td>${user.email}</td>
                <td>
                    <span class="btn btn-default btn-sm" onclick="handleUserUpdate(${user.id})">修改</span>
                    &nbsp;
                    <span
                            class="btn btn-default btn-sm"
                            onclick="handleDelete(${user.id});">删除
                    </span>
                </td>
            </tr>

        </c:forEach>
    </table>
    <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
            <c:if test="${page.currentPage == 1}">
            <li class="disabled page-item">
                </c:if>

                <c:if test="${page.currentPage != 1}">
            <li class="page-item">
                </c:if>

                <a class="page-link"
                   href="${pageContext.request.contextPath}/findByPage?currentPage=${page.currentPage - 1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}"
                   aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>


            <c:forEach begin="1" end="${page.totalPages}" var="i">


                <c:if test="${page.currentPage == i}">
                    <li class="active page-item"><a class="page-link"
                                                    href="${pageContext.request.contextPath}/findByPage?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a>
                    </li>
                </c:if>
                <c:if test="${page.currentPage != i}">
                    <li class="page-item">
                        <a class="page-link"
                           href="${pageContext.request.contextPath}/findByPage?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a>
                    </li>
                </c:if>

            </c:forEach>

            <c:if test="${page.currentPage == page.totalPages}">
                <li class="page-item disabled">
                    <a class="page-link"
                       href="${pageContext.request.contextPath}/findByPage?currentPage=${page.currentPage + 1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </c:if>

            <c:if test="${page.currentPage != page.totalPages}">
                <li class="page-item">
                    <a class="page-link"
                       href="${pageContext.request.contextPath}/findByPage?currentPage=${page.currentPage + 1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </c:if>

        </ul>
        <p style="font-size: 14px;margin-left: 5px; text-align:center">
            共 <b>${page.totalCount}</b> 条记录，共<b>${page.totalPages}</b>页
        </p>
    </nav>
</div>

</body>
</html>

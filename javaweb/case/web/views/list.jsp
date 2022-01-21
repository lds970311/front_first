<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.codewolf.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: mechrevo
  Date: 2022-01-21
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="false" errorPage="error.jsp" %>

<html>
<head>
    <title>用户信息管理系统</title>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.6.1/js/bootstrap.min.js"></script>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.6.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/UserHandler.js"></script>
    <link href="../css/style.css" rel="stylesheet">
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

        .pagination {
            transform: translateX(25%);
        }
    </style>
</head>
<body>
<div class="container-md">
    <h3 style="text-align: center">用户信息列表</h3>

    <div class="my-form">
        <form class="form-inline" method="post">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" name="name" id="exampleInputName2">
            </div>
            <div class="form-group">
                <label for="exampleInputName3">籍贯</label>
                <input type="text" name="address" id="exampleInputName3">
            </div>

            <div class="form-group">
                <label for="exampleInputEmail2">邮箱</label>
                <input type="text" name="email" id="exampleInputEmail2">
            </div>
            <button type="submit" class="btn btn-warning">查询</button>
        </form>

    </div>
    <div style="float: right;margin: 5px;">

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/views/add.jsp">添加联系人</a>
        <a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除选中</a>

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

        <c:forEach items="${users}" var="user" varStatus="s">
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
                    <a class="btn btn-default btn-sm" href="views/update.jsp">修改</a>
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
        <ul class="pagination">
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">4</a></li>
            <li class="page-item"><a class="page-link" href="#">5</a></li>
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <span style="font-size: 14px;margin-left: 5px; line-height:40px">
                    共123条记录，共12页
                </span>
        </ul>
    </nav>
</div>

</body>
</html>

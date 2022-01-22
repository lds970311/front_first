<%@ page import="com.codewolf.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta content="width=device-width, initial-scale=1" name="viewport">
    <title>修改用户</title>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.6.1/js/bootstrap.min.js"></script>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.6.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%
    String[] regions = {"广东", "广西", "山东", "河南", "北京", "上海", "浙江", "天津", "江苏"};
    pageContext.setAttribute("regions", regions);
%>

<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改联系人</h3>
    <form action="${pageContext.request.contextPath}/updateUser" method="post">
        <input type="hidden" name="id" value="${currUser.id}">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input class="form-control" id="name" name="name" placeholder="请输入姓名" readonly="readonly"
                   value="${currUser.name}"
                   type="text"/>
        </div>

        <div class="form-group">
            <label>性别：</label>
            <c:if test="${currUser.gender=='男'}">
                <label>
                    <input name="sex" type="radio" value="男" checked/>
                    男
                </label>
                <label>
                    <input name="sex" type="radio" value="女"/>
                    女
                </label>
            </c:if>
            <c:if test="${currUser.gender=='女'}">
                <label>
                    <input name="sex" type="radio" value="男"/>
                    男
                </label>
                <label>
                    <input name="sex" type="radio" value="女" checked/>
                    女
                </label>
            </c:if>

        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input class="form-control" id="age" name="age" placeholder="请输入年龄" type="text" value="${currUser.age}"/>
        </div>
        <div class="form-group">
            <label for="address">籍贯：</label>
            <select class="form-control" id="address" name="address">
                <c:forEach items="${regions}" var="region">
                    <c:if test="${currUser.address == region}">
                        <option value="${region}" selected="selected">${region}</option>
                    </c:if>
                    <c:if test="${currUser.address != region}">
                        <option value="${region}">${region}</option>
                    </c:if>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <label id="qq">
                <input class="form-control" name="qq" placeholder="请输入QQ号码" type="text" value="${currUser.qq}"/>
            </label>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <label id="email">
                <input class="form-control" name="email" placeholder="请输入邮箱地址" type="text" value="${currUser.email}">
            </label>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交"/>
            <input class="btn btn-default" type="reset" value="重置"/>
            <input class="btn btn-default" type="button" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>

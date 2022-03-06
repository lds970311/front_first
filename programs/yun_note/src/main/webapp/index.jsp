<%--
  Created by IntelliJ IDEA.
  User: mechrevo
  Date: 2022-02-26
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>云日记首页</title>
    <link href="static/css/note.css" rel="stylesheet">
    <link href="static/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="static/sweetalert/sweetalert2.min.css" rel="stylesheet">
    <script src="static/js/jquery-1.11.3.js"></script>
    <script src="static/bootstrap/js/bootstrap.js"></script>
    <script src="static/sweetalert/sweetalert2.min.js"></script>
    <!-- 配置文件 -->
    <script type="text/javascript" src="static/ueditor/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="static/ueditor/ueditor.all.js"></script>
    <%--自定义的首页css--%>
    <link rel="stylesheet" href="static/css/index.css">
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" style="font-size:25px" href="main">云日记</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li <c:if test="${changePage == 'list.jsp'}">
                    class="active"
                </c:if> id="menu">
                    <a href="NoteServlet?actionName=list&pageNo=1&pageSize=5"><i class="glyphicon glyphicon-cloud"></i>&nbsp;主&nbsp;&nbsp;页</a>
                </li>
                <li <c:if test="${fn:contains(changePage,'note')}">
                    class="active"
                </c:if>>
                    <a href="NoteServlet?actionName=view"><i class="glyphicon glyphicon-pencil"></i>&nbsp;发表云记</a>
                </li>
                <li <c:if test="${changePage == 'type.jsp'}">
                    class="active"
                </c:if>>
                    <a href="NoteTypeServlet?actionName=list"><i class="glyphicon glyphicon-list"></i>&nbsp;类别管理</a>
                </li>
                <li <c:if test="${changePage == 'personal_center.jsp'}">
                        class="active"
                </c:if>>
                    <a href="UserServlet?actionName=userCenter"><i class="glyphicon glyphicon-user"></i>&nbsp;个人中心</a>
                <li>
                    <a href="report"><i class="glyphicon glyphicon-signal"></i>&nbsp;数据报表</a>
                </li>
            </ul>
            <form class="navbar-form navbar-right" role="search" action="IndexServlet">
                <div class="form-group">
                    <input type="hidden" name="actionName" value="searchTitle">
                    <input type="text" name="title" class="form-control" placeholder="搜索云记" value="${title}">
                </div>
                <button type="submit" class="btn btn-default">查询</button>
            </form>
        </div>
    </div>
</nav>
<div class="container">
    <div class="row-fluid">
        <div class="col-md-3">
            <div class="data_list">
                <div class="data_list_title">
                    <span class="glyphicon glyphicon-user"></span>&nbsp;
                    个人中心&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="UserServlet?actionName=logout">退出</a>
                </div>
                <div class="userimg">
                    <img src="static/images/${user.head}" alt="退出">
                </div>
                <div class="nick">${user.nick}</div>
                <div class="mood">${user.mood}</div>
            </div>
            <div class="data_list">
                <div class="data_list_title">
					<span class="glyphicon glyphicon-calendar">
					</span>&nbsp;云记日期
                </div>
                <div>
                    <ul class="nav nav-pills nav-stacked">
                        <c:forEach items="${dateInfo}" var="item">
                            <li>
                                <a href="IndexServlet?actionName=searchDate&date=${item.groupName}">${item.groupName}
                                    <span class="badge">${item.noteCount}</span>
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>

            </div>
            <div class="data_list">
                <div class="data_list_title">
					<span class="glyphicon glyphicon-list-alt">
					</span>&nbsp;云记类别
                </div>
                <div>
                    <ul class="nav nav-pills nav-stacked" id="typeUl">
                        <c:forEach items="${typeInfo}" var="item">
                            <li>
                                <a href="IndexServlet?actionName=searchType&type=${item.groupName}">${item.groupName}
                                    <span class="badge">${item.noteCount}</span>
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>

            </div>
        </div>
    </div>
    <c:if test="${empty changePage}">
        <jsp:include page="pages/list.jsp"/>
    </c:if>
    <c:if test="${not empty changePage}">
        <jsp:include page="pages/${changePage}"/>
    </c:if>
</div>
</body>
</html>

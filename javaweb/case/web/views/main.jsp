<%--
  Created by IntelliJ IDEA.
  User: mechrevo
  Date: 2022-01-21
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <!-- 1. 导入CSS的全局样式 -->
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.6.1/js/bootstrap.min.js"></script>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.6.1/css/bootstrap.min.css" rel="stylesheet">

    <script type="text/javascript">
    </script>
</head>
<body>
<div align="center">
    <a
            href="${pageContext.request.contextPath}/findByPage?currentPage=1&rows=5"
            style="text-decoration:none;font-size:33px">查询所有用户信息
    </a>
    <svg class="bi bi-arrow-down-short" fill="currentColor" height="16" viewBox="0 0 16 16" width="16"
         xmlns="http://www.w3.org/2000/svg">
        <path d="M8 4a.5.5 0 0 1 .5.5v5.793l2.146-2.147a.5.5 0 0 1 .708.708l-3 3a.5.5 0 0 1-.708 0l-3-3a.5.5 0 1 1 .708-.708L7.5 10.293V4.5A.5.5 0 0 1 8 4z"
              fill-rule="evenodd"></path>
    </svg>
</div>
</body>
</html>

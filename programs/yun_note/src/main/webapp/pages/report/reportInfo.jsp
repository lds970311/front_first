<%--
  Created by IntelliJ IDEA.
  User: mechrevo
  Date: 2022-03-06
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>数据报表</title>
    <script src="${pageContext.request.contextPath}/static/echarts/echarts.min.js"></script>
    <script type="text/javascript"
            src="https://api.map.baidu.com/api?v=1.0&&type=webgl&ak=yrxymYTyuefnxNtXbZcMU8phABXtu6TG"></script>
</head>
<body>
<div class="col-md-9">
    <div class="data_list">
        <div class="data_list_title"><span class="glyphicon glyphicon-signal"></span>&nbsp;数据报表</div>
        <div class="container-fluid">
            <div class="row" style="padding-top: 20px;">
                <div class="col-md-12">
                    <%-- 柱状图的容器 --%>
                    <div id="monthChart" style="height: 500px"></div>

                    <%-- 百度地图的加载 --%>
                    <h3 style="text-align: center">用户地区分布图</h3>
                    <%-- 百度地图的容器 --%>
                    <div id="baiduMap" style="height: 600px;width: 100%;"></div>

                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/static/js/reportInfo.js"></script>
</body>
</html>

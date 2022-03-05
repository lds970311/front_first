<%--
  Created by IntelliJ IDEA.
  User: mechrevo
  Date: 2022-03-04
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>view</title>
    <script src="${pageContext.request.contextPath}/static/js/note/view.js"></script>
</head>
<body>
<div class="col-md-9">
    <div class="data_list">
        <div class="data_list_title">
            <span class="glyphicon glyphicon-cloud-upload"></span>&nbsp;
            添加云记
        </div>
        <div class="container-fluid">
            <div class="container-fluid">
                <div class="row" style="padding-top: 20px;">
                    <div class="col-md-12">
                        <%-- 判断类型列表是否为空，如果为空，提示用户先添加类型 --%>
                        <c:if test="${empty typeList}">
                            <h3>暂未查询到云记类型</h3>
                            <h4>
                                <a href="NoteTypeServlet?actionName=list">添加类型</a>
                            </h4>
                        </c:if>
                        <c:if test="${not empty typeList}">
                            <form class="form-horizontal" method="post" action="NoteServlet">
                                    <%-- 设置隐藏域：用来存放用户行为actionName --%>
                                <input type="hidden" name="actionName" value="addOrUpdate">
                                    <%-- 设置隐藏域：用来存放noteId --%>
                                <input type="hidden" name="noteId" value="">

                                    <%-- 设置隐藏域：用来存放用户发布云记时所在地区的经纬度 --%>
                                    <%-- 经度 --%>
                                <input type="hidden" name="lon" id="lon">
                                    <%-- 纬度 --%>
                                <input type="hidden" name="lat" id="lat">

                                <div class="form-group">
                                    <label for="typeId" class="col-sm-2 control-label">类别:</label>
                                    <div class="col-sm-10">
                                        <select id="typeId" class="form-control" name="typeId">
                                            <option value="">请选择云记类别...</option>
                                            <c:forEach items="${typeList}" var="item">
                                                <c:if test="${resultInfo.result.typeId == item.typeId}">selected</c:if>
                                                <option value="${item.typeId}"
                                                        <c:if test="${resultInfo.result.typeId == item.typeId}">selected</c:if>
                                                >${item.typeName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="title" class="col-sm-2 control-label">标题:</label>
                                    <div class="col-sm-10">
                                        <input class="form-control" name="title" id="title" placeholder="云记标题"
                                               value="${resultInfo.result.title}">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="title" class="col-sm-2 control-label">内容:</label>
                                    <div class="col-sm-10">
                                        <label for="content">
                                            <textarea id="content"
                                                      name="content">${resultInfo.result.content}</textarea>
                                        </label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-offset-4 col-sm-4">
                                        <input type="submit" class="btn btn-primary" onclick="return checkNoteForm()"
                                               value="保存">
                                        &nbsp;<span id="msg"
                                                    style="font-size: 12px;color: red">${resultInfo.result.message}</span>
                                    </div>
                                </div>
                            </form>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

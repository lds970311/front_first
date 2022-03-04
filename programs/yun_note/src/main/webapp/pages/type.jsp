<%--
  Created by IntelliJ IDEA.
  User: mechrevo
  Date: 2022-03-02
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>类别管理</title>
</head>
<body>
<div class="col-md-9">
    <div class="data_list">
        <div class="data_list_title">
            <span class="glyphicon glyphicon-list"></span>&nbsp;类型列表
            <span class="noteType_add">
			<button class="btn btn-sm btn-success" type="button" id="addBtn">添加类别</button>
		</span>

        </div>
        <div>
            <c:if test="${empty typeList}">
                <h3>暂未查询到类型数据!</h3>
            </c:if>
            <c:if test="${not empty typeList}">
                <table class="table table-hover table-striped ">
                    <tbody>
                    <tr>
                        <th>编号</th>
                        <th>类型</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${typeList}" var="item" varStatus="vs">
                        <tr>
                            <td>${vs.index+1}</td>
                            <td>${item.typeName}</td>
                            <td>
                                <button class="btn btn-primary" type="button">修改</button>&nbsp;
                                <button class="btn btn-danger del" type="button">删除</button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span></button>
                    <h4 class="modal-title" id="myModalLabel">新增</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="typename">类型名称</label>
                        <input type="hidden" name="typeId">
                        <input type="text" name="typename" class="form-control" id="typename" placeholder="类型名称">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">
                        <span class="glyphicon glyphicon-remove"></span>关闭
                    </button>
                    <button type="button" id="btn_submit" class="btn btn-primary">
                        <span class="glyphicon glyphicon-floppy-disk"></span>保存
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        $.ajax({
            type: 'get',
            url: "NoteTypeServlet?actionName=list"
        })
    })
</script>
</body>
</html>

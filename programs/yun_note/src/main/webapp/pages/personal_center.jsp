<%--
  Created by IntelliJ IDEA.
  User: mechrevo
  Date: 2022-03-02
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>个人中心</title>
<body>
<div class="col-md-9">

    <div class="data_list">
        <div class="data_list_title"><span class="glyphicon glyphicon-edit"></span>&nbsp;个人中心</div>
        <div class="container-fluid">
            <div class="row" style="padding-top: 20px;">
                <div class="col-md-8">
                    <form class="form-horizontal" method="post" action="user?act=save" enctype="multipart/form-data"
                          onsubmit="return checkUser();">
                        <div class="form-group">
                            <input type="hidden" name="act" value="save">
                            <label for="nickName" class="col-sm-2 control-label">昵称:</label>
                            <div class="col-sm-3">
                                <input class="form-control" name="nick" id="nickName" placeholder="昵称"
                                       value="${user.nick}">
                            </div>
                            <label for="img" class="col-sm-2 control-label">头像:</label>
                            <div class="col-sm-5">
                                <input type="file" id="img" name="img">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="mood" class="col-sm-2 control-label">心情:</label>
                            <div class="col-sm-10">
                                <textarea class="form-control" name="mood" id="mood" rows="3">${user.mood}</textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" id="btn" class="btn btn-success">修改</button>&nbsp;&nbsp;<span
                                    style="color:red" id="msg"></span>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-md-4">
                    <img style="width:260px;height:200px"
                         src="${pageContext.request.contextPath}/static/images/${user.head}"
                         alt="呵呵">
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

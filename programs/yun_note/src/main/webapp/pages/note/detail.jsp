<%--
  Created by IntelliJ IDEA.
  User: mechrevo
  Date: 2022-03-04
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>云记详情</title>
</head>
<body>
<div class="col-md-9">
    <div class="data_list">
        <div class="data_list_title" style="overflow:hidden;">
            <span class="glyphicon glyphicon-eye-open"></span>&nbsp;查看云记
            <div class="note_btn" style="display: inline-block; float: right; margin-top:0 ">
                <button class="btn btn-primary" type="button" onclick="updateNote(${note.noteId})">修改</button>
                <button class="btn btn-danger" type="button" onclick="deleteNote(${note.noteId})">删除</button>
            </div>
        </div>
        <div>
            <div class="note_title">
                <h2>${note.title}</h2>
            </div>
            <div class="note_info">
                发布时间：『<fmt:formatDate value="${note.pubTime}" pattern="yyyy年MM月dd日  HH:mm"/> 』
                &nbsp;&nbsp;云记类别：${typeName}
            </div>
            <div class="note_content">
                <p>${note.content}</p>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    function deleteNote(noteId) {
        // 弹出提示框询问用户是否确认删除
        swal({
            title: "",  // 标题
            text: "<h3>您确认要删除该记录吗？</h3>", // 内容
            type: "warning", // 图标  error	 success	info  warning
            showCancelButton: true,  // 是否显示取消按钮
            confirmButtonColor: "orange", // 确认按钮的颜色
            confirmButtonText: "确定", // 确认按钮的文本
            cancelButtonText: "取消" // 取消按钮的文本
        }).then(function () {
            // 如果用户确认删除，则发送ajax请求
            $.ajax({
                type: "post",
                url: "NoteServlet",
                data: {
                    actionName: "delete",
                    noteId
                },
                success: function (result) {
                    // 判断是否删除成功
                    if (result.code == 1) {
                        // 跳转到首页
                        window.location.href = "IndexServlet";
                    } else {
                        // 提示失败
                        swal("", `<h3>${result.message}</h3>`, "error");
                    }
                }
            });

        });
    }

    /**
     * 进入发布云记的页面
     * @param noteId
     */
    function updateNote(noteId) {
        window.location.href = "NoteServlet?actionName=view&noteId=" + noteId;
    }

</script>
</body>
</html>

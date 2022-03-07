<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
>
<html>
<head>
    <title>云记列表</title>
</head>
<body>
<div class="col-md-9">
    <div class="data_list">
        <div class="data_list_title"><span class="glyphicon glyphicon glyphicon-th-list"></span>&nbsp;
            云记列表
        </div>
        <c:if test="${empty page}">
            <h3>当前用户暂未发布云记</h3>
        </c:if>

        <c:if test="${not empty page}">
            <div class="note_datas">
                <ul>
                    <c:forEach items="${page.dataList}" var="data">
                        <li>『<fmt:formatDate value="${data.pubTime}" pattern="yyyy-MM-dd"/>』&nbsp;&nbsp;
                            <a href="NoteServlet?actionName=detail&noteId=${data.noteId}&typeId=${data.typeId}">${data.title}</a>
                        </li>
                    </c:forEach>

                </ul>
            </div>
            <nav style="text-align: center">
                <ul class="pagination  center">
                    <c:if test="${page.pageNo > 1}">
                        <li>
                            <a href="NoteServlet?actionName=list&pageNo=${page.pageNo - 1}&pageSize=5&title=${title}&date=${date}&type=${type}">
                                <span>«</span>
                            </a>
                        </li>
                    </c:if>
                        <%--导航页数--%>
                    <c:forEach begin="${page.startNavPage}" end="${page.endNavPage}" var="p">
                        <li <c:if test="${page.pageNo == p}">class="active"</c:if>>
                            <a href="NoteServlet?actionName=list&pageNo=${p}&pageSize=5&title=${title}&date=${date}&type=${type}">${p}</a>
                        </li>
                    </c:forEach>
                    <c:if test="${page.pageNo < page.totalPages}">
                        <li>
                            <a href="NoteServlet?actionName=list&pageNo=${page.pageNo + 1}&pageSize=5&title=${title}&date=${date}&type=${type}">
                                <span>»</span>
                            </a>
                        </li>
                    </c:if>
                </ul>
            </nav>
        </c:if>

    </div>
</div>
</body>
</html>

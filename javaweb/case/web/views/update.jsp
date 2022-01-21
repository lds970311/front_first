<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta content="width=device-width, initial-scale=1" name="viewport">
    <title>修改用户</title>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.6.1/js/bootstrap.min.js"></script>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.6.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改联系人</h3>
    <form action="" method="post">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input class="form-control" id="name" name="name" placeholder="请输入姓名" readonly="readonly" type="text"/>
        </div>

        <div class="form-group">
            <label>性别：</label>
            <label>
                <input name="sex" type="radio" value="男"/>
                男
            </label>
            <label>
                <input name="sex" type="radio" value="女"/>
                女
            </label>
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input class="form-control" id="age" name="age" placeholder="请输入年龄" type="text"/>
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select class="form-control" id="address" name="address">
                <option value="广东">广东</option>
                <option value="广西">广西</option>
                <option value="湖南">湖南</option>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <label id="qq">
                <input class="form-control" name="qq" placeholder="请输入QQ号码" type="text"/>
            </label>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <label id="email">
                <input class="form-control" name="email" placeholder="请输入邮箱地址" type="text"/>
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

<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
    <div class="container">
        <h3 style="text-align: center;">修改用户</h3>
        <form action="${pageContext.request.contextPath}/update2" method="post">
            <div class="form-group">
                <label for="name">编号：</label>
                <input type="text" class="form-control" id="id" readonly="readonly" name="id" value="${user.id}">
            </div>

            <div class="form-group">
                <label for="name">姓名：</label>
                <input type="text" class="form-control" id="name" name="name" value="${user.name}" placeholder="请输入姓名"/>
            </div>

            <div class="form-group">
                <label>性别：</label>
                <input type="radio" name="sex" value="男"
                ${user.sex=="男"?"checked":""} />男
                <input type="radio" name="sex" value="女"
                ${user.sex=="女"?"checked":""} />女
            </div>

            <div class="form-group">
                <label for="age">年龄：</label>
                <input type="text" class="form-control" id="age" name="age" value="${user.age}" placeholder="请输入年龄"/>
            </div>

            <div class="form-group">
                <div class="form-group">
                    <label for="address">籍贯：</label>
                    <input type="text" class="form-control" id="address" name="address" value="${user.address}"
                           placeholder="请输入籍贯">
                </div>
            </div>

            <div class="form-group">
                <label for="qq">QQ：</label>
                <input type="text" class="form-control" id="qq" name="qq" value="${user.qq}" placeholder="请输入QQ号码"/>
            </div>

            <div class="form-group">
                <label for="email">Email：</label>
                <input type="text" class="form-control" id="email" name="email" value="${user.email}"
                       placeholder="请输入邮箱地址"/>
            </div>

            <div class="form-group" style="text-align: center">
                <input class="btn btn-primary" type="submit" value="提交"/>
                <input class="btn btn-default" type="reset" value="重置"/>
                <input class="btn btn-default" type="button" value="返回"/>
            </div>
        </form>
    </div>
</div>
</body>
</html>
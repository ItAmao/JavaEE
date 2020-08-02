<%--
  Created by IntelliJ IDEA.
  User: muzimoo
  Date: 2020-6-24
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
<h2>用户注册</h2>
<form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
    用户名：<input type="text" name="username"/><br/>
    头像上传：<input type="file" name="info"/><br/>
    <input type="submit" value="注册">
</form>
</body>
</html>

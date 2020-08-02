<%--
  User: ItAmao
  Date: 2020/7/31
  Time: 20:56
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/register" method="post">
    用户名: <input type="text" id="username" name="username" placeholder="请输入用户名"> <br>
    密码: <input type="password" id="password" name="password" placeholder="请输入密码"> <br>
    金钱: <input type="text" id="money" name="money" placeholder="请输入钱钱"> <br>
    <input type="submit" value="注册">
</form>
</body>
</html>

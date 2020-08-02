<%--
  User: ItAmao
  Date: 2020/7/31
  Time: 20:53
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/login" method="post">
    用户名: <input type="text" id="username" name="username" placeholder="请输入用户名"> <br>
    密码: <input type="password" id="password" name="password" placeholder="请输入密码"> <br>
    <input type="submit" value="登录">
</form>
</body>
</html>

<%--
  User: ItAmao
  Date: 2020/7/23
  Time: 12:17
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${requestScope.errMsg}
<hr>
<form action="" method="post">
    账号: <input type="text" name="username" placeholder="请输入账号"> <br>
    密码: <input type="text" name="password" placeholder="请输入密码"> <br>
    自动登录: <input type="radio" name="isauto" value="${60*60*24}">
    <input type="submit" value="登录">

</form>
</body>
</html>

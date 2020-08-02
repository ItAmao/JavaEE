<%--
  User: ItAmao
  Date: 2020/7/23
  Time: 20:44
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/loginServlet" method="get">
    用户名: <input type="text" name="name" placeholder="请输入你的用户名">
    <input type="submit" value="登录">
</form>
</body>
</html>

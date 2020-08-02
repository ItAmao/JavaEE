<%--
  User: ItAmao
  Date: 2020/7/19
  Time: 21:18
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取隐式对象</title>
</head>
<body>

    ${pageContext.request} <br>
    <h4>在jsp页面动态获取虚拟目录</h4>
    ${pageContext.request.contextPath}
</body>
</html>

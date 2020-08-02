<%--
  User: ItAmao
  Date: 2020/7/23
  Time: 20:22
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/add.jsp">新增</a>
<table border="1" width="500">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>操作</th>
    </tr>
    <c:forEach var="user" items="${list}">
        <tr>
            <td>${user.uid}</td>
            <td>${user.name}</td>
            <td>${user.gender=="m"?"男":"女"}</td>
            <td>${user.age}</td>
            <td>
                <a href="${pageContext.request.contextPath}/findByIdServlet?uid=${user.uid}">修改</a>|
                <a href="${pageContext.request.contextPath}/deleteById?uid=${user.uid}">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

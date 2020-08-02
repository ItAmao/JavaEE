<%--
  User: ItAmao
  Date: 2020/7/23
  Time: 21:27
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/updateServlet" method="post">
    学号:<input type="text" disabled name="uid" value="${user.uid}"/><br/>
    姓名:<input type="text" name="name" value="${user.name}"/><br/>
    性别:<input type="radio" name="gender" value="男"${user.gender=="男"?"checked":""}/>男
    <input type="radio" name="gender" value="女" ${user.gender=="女"?"checked":""}/>女<br/>
    年龄:<input type="text" name="age" value="${user.age}"/><br/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>

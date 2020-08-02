<%--
  User: ItAmao
  Date: 2020/7/23
  Time: 20:25
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>添加用户</title>

</head>
<body>
    <form action="${pageContext.request.contextPath}/registerServlet" method="post">
        编号:<input type="text" name="uid"/><br/>
        姓名:<input type="text" name="name"/><br/>
        性别:<input type="radio" name="gender" value="男" checked/>男
        <input type="radio" name="gender" value="女"/>女<br/>
        年龄:<input type="text" name="age"/><br/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>

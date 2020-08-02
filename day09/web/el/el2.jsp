<%--
  User: ItAmao
  Date: 2020/7/19
  Time: 20:10
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取域中的数据</title>
</head>
<body>
<%
    //在域中存储数据
    request.setAttribute("name", "阿毛");
    session.setAttribute("age", "23");
%>

<h3>el获取值</h3>

${requestScope.name}
${sessionScope.age}

</body>
</html>

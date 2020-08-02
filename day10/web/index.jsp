<%--
  User: ItAmao
  Date: 2020/7/22
  Time: 07:21
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/form.jsp">form表单</a>
<c:choose>
    <%--相当于switch--%>
    <c:when test="$">
        <a href="${pageContext.request.contextPath}/login.jsp">请进行登录</a>
    </c:when>
    <c:otherwise>
        欢迎你 ${sessionScope.user.username}
        <a href="${pageContext.request.contextPath}/LogoutServlet">注销</a>
    </c:otherwise>
</c:choose>
</body>
</html>

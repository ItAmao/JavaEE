<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  User: ItAmao
  Date: 2020/7/19
  Time: 21:58
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach begin="1" end="10" var="i" step="1">
    ${i}<br>
</c:forEach>
<hr>

<%

    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    request.setAttribute("list", list);

%>
<c:forEach items="${list}" var="str" varStatus="s">
    ${s.index} ${s.count} ${str}
</c:forEach>


</body>
</html>

<%@ page import="com.amao.domain.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="javax.xml.crypto.Data" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%--
  User: ItAmao
  Date: 2020/7/19
  Time: 20:24
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取数据</title>
</head>
<body>
<%
    User user = new User();
    user.setName("阿毛");
    user.setAge(23);
    user.setBirthday(new Date());
    request.setAttribute("user", user);

    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");

%>
<h3>el获取对象中的值</h3>
${requestScope.user.name}
${requestScope.user.age}
${requestScope.user.birthday}

<%--
    通过的是对象的属性来获取
    setter或getter方法,去掉set或get,在将剩余部分.首字母变为小写
--%>


</body>
</html>

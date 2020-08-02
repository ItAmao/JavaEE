<%--
  User: ItAmao
  Date: 2020/7/24
  Time: 15:21
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--    文件上传三要输:--%>
<%--        1.表单提交方式必须为post--%>
<%--        2.表单中必须有type=file 组件,必须有name名称
            3.表单必须设置多部分文件上传 enctype="multipart/form-data"

            多部分表单文件上传 数据格式,不再是key=value&key=value的格式,而是以分割线为主,切割不同的表单中
            每一个input组件,都会有自己的独立去域以分割线划分

            浏览器传输给服务器的数据,原来的request.getParameter()实效,getParameter解析的数据只是key=value$key=value
            的数据对于文件上传项,普通表单项的数据获得不了

            1.普通表单项
            2.文件上传项
--%>
<form action="${pageContext.request.contextPath}/uploadServlet" method="post" enctype="multipart/form-data">
    用户名 <input type="text" name="username"> <br>
    昵称 <input type="text" name="nickname"> <br>
    文件上传: <input type="file" name="MyFile"> <br>
    <input type="submit" value="提交">
</form>
</body>
</html>

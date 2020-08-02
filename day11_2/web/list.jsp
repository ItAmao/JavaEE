<%--
  User: ItAmao
  Date: 2020/7/25
  Time: 19:45
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-3.5.1.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <%--开始遍历数据--%>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.address}</td>
                <td>${user.QQ}</td>
                <td>${user.email}</td>
                <td><a class="btn btn-default btn-sm"
                       href="${pageContext.request.contextPath}/user/findById?id=${user.id}">修改</a>&nbsp;
                        <%--
                           onclick属性和href属性 只出现一个 , 互相冲突的
                           如何进行属性?
                            <a class="btn btn-default btn-sm" onclick="deleteById()" href="${pageContext.request.contextPath}/deleteById?id=${user.id}">删除</a></td>

                            表示的含义:href="javascript:alert(1);"
                                href属性:执行javascript的代码 不进行链接跳转
                                href属性:跳转链接代码
                                href="javascript:;"  href="javascript:void(0);" 执行javascript但是不执行任何代码(相当于禁用)

                        --%>
                    <a class="btn btn-default btn-sm" onclick="deleteById(${user.id})" href="javascript:void(0);">删除</a>
                    <a class="btn btn-default btn-sm" href="javascript:deleteById(${user.id});">删除</a>
                </td>
            </tr>
        </c:forEach>
        <%--结束遍历数据--%>
        <script>
            //alert("123");

            //prompt()
            function deleteById(id) {
                let flag = confirm("是否确定删除?");  //返回值是true 确定和false 取消
                if (flag) {
                    //确定删除(等效 需要在js中 调用servlet删除数据即可)
                    location.href = "${pageContext.request.contextPath}/user/deleteById?id=" + id;
                }
            }
        </script>
        <tr>
            <td colspan="8" align="center"><a class="btn btn-primary" href="register.jsp">添加联系人</a></td>
        </tr>
    </table>
</div>
</body>
</html>

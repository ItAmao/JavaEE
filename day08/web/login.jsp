<%--
  User: ItAmao
  Date: 2020/7/19
  Time: 16:40
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <script src="js/jquery-3.5.1.js"></script>
    <script>
        // $(function () {
        //     $(function () {
        //         $("#checkCode").click(function () {
        //             let date = new Date().getTime();
        //             this.src = "/day08/checkCodeServlet?" + date;
        //         })
        //     })
        // })
        window.onload = function () {
            document.getElementById("img").onclick = function () {
                this.src = "/day08/checkCodeServlet?time" + new Date().getTime();
            }
        }
    </script>

    <style>
        div {
            color: red;
        }
    </style>
</head>
<body>
<form action="/day08/loginServlet" method="post">
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>验证码:</td>
            <td><input type="text" name="checkCode"></td>
        </tr>
        <tr>
            <td colspan="2"><img src="/day08/checkCodeServlet" id="img"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="登录"></td>
        </tr>
    </table>
</form>

<div>
    <%=request.getAttribute("cc_error") == null ? "" : request.getAttribute("cc_error") %>
</div>

<div>
    <%=request.getAttribute("login_error") == null ? "" : request.getAttribute("login_error")%>
</div>
</body>
</html>

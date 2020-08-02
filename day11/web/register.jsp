<%--
  User: ItAmao
  Date: 2020/7/22
  Time: 09:44
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <link rel="stylesheet" href="css/register.css">
    <script src="jq/jquery-3.5.1.js"></script>
    <script>
        $(function () {
            //获取姓名文本框,并绑定失去焦点事件
            $("input[name ='user']").blur(function () {
                //alert(1);
                //定义json格式的参数
                let param = {"user": $(this).val()};
                //发送ajax,验证用户名是否存在
                $.get("${pageContext.request.contextPath}/checkNameServlet", param, function (result) {
                    if (result == "n") {
                        //向span标签添加文本,并调用类样式
                        $(".msg").html("❌").addClass("msg");
                    } else if (result = "y") {
                        $(".msg").html("✔️").addClass("msg");
                    }
                });
            });
            $("input[name ='user']").onblur(function () {
                $(".msg").html("").removeClass("msg");
            });


        });
    </script>
</head>
<body>
<div class="container">
    <div>
        <img src="img/top_banner.jpg" width="100%">
    </div>
    <div>
        <img src="img/logo.png" width="100%">
    </div>
    <div class="nav">
        <ul>
            <li>首页</li>
            <li>周边游</li>
            <li>日本游</li>
            <li>欧美游</li>
            <li>首页</li>
            <li>首页</li>
            <li>首页</li>
            <li>首页</li>
            <li>首页</li>
        </ul>
    </div>

    <!--注册布局-->
    <div class="content">
        <div class="rg_form">
            <!--左-->
            <div class="rg_form_left">
                <font size="4" color="orange">用户注册</font>
                <br/><br/>
                <font size="4" color="#a9a9a9">USER REGISTER</font>
            </div>
            <!--中-->
            <div class="rg_form_center">
                <!--表格-->
                <table>
                    <form action="${pageContext.request.contextPath}/registerServlet" method="get">
                        <tr>
                            <td class="td_left">用户名</td>
                            <td class="td_right">
                                <input type="text" name="user" placeholder="请输入用户名">
                                <span class="msg"></span>
                            </td>
                        </tr>
                        <tr>
                            <td class="td_left">邮箱:</td>
                            <td class="td_right">
                                <input type="text" name="email" placeholder="请输入邮箱地址">
                                <span class="email1"></span>
                            </td>
                        </tr>
                        <tr>
                            <td class="td_left">密码</td>
                            <td class="td_right">
                                <input type="password" name="pass" placeholder="请输入密码">
                            </td>
                        </tr>
                        <tr>
                            <td class="td_left">验证码</td>
                            <td class="td_right">
                                <input type="text" name="yzm" placeholder="请输入验证码">
                                <img src="${pageContext.request.contextPath}/produceCodeServlet" id="img">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <input type="submit" value="注册">
                            </td>
                        </tr>

                    </form>
                </table>
            </div>
            <!--右-->
            <div class="rg_form_right">
                已有账号？<a href="#" style="color: deeppink; text-decoration: none">立即登录</a>
            </div>
        </div>
    </div>


    <div class="footer">
        <img src="img/footer_service.png" width="100%">
    </div>
    <div class="copyright">
        江苏传智播客教育科技股份有限公司
        版权所有Copyright&copy;2006-2018, All Rights Reserved 苏ICP备16007882
    </div>
</div>
</body>
</html>

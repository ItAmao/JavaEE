$(function () {
    //验证码图片点击刷新事件
    $("#checkCode").click(function () {
        let date = new Date().getTime();
        this.src = "/day07_2/checkCodeServlet?" + date;
    })

    //用户名正则表达式
    let username = $("#userName");
    username.blur(function () {
        let value = username.val();
        //alert(value);
        //创建正则
        let regex = /^[A-Za-z_@.]{6,10}$/;
        let span = $("#span1");
        if (!regex.test(value)) {
            //因为span是jq的对象,不能直接调用js的东西,需要转成js对象才能使用
            span[0].innerHTML = "用户名格式错误";
        } else {
            span[0].innerHTML = " ✓";
        }
    })

    //手机号匹配
    let userPhone = $("#userPhone");
    userPhone.blur(function () {
        let value = userPhone.val();
        //创建正则
        let regex = /^1[356789]\d{9}$/;
        let span = $("#span2");
        if (!regex.test(value)) {
            span[0].innerHTML = "手机号格式错误";
        } else {
            span[0].innerHTML = " ✓";
        }
    })
    //密码匹配
    let userPass = $("#userPass");
    userPass.blur(function () {
        let value = userPass.val();
        //创建正则
        let regex = /^[A-Za-z_@.]{6,10}$/;
        let span = $("#span3");
        if (!regex.test(value)) {
            span[0].innerHTML = "密码格式错误";
        } else {
            span[0].innerHTML = " ✓";
        }
    })

})
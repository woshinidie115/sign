<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2022/12/26
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="js/jquery-3.1.1.min.js"></script>
</head>
<body>

<form method="post" action="/register">
    name<input type="text" name="phone"><br>
    password<input type="password" name="password"><br>
    rePassword<input type="password" name="rePassword"><br>
    otherid<input type="text" name="otherid"><br>
    <input type="submit" value="注册">
</form>

<script>
    // $(function () {
    //
    // })
    $("form").submit(function () {
        var phone = $("input[name='phone']");
        var password = $("input[name='password']");
        var rePassword = $("input[name='rePassword']");
        var otherid=$("input[name='otherid']");
        if (phone.val()=="") {
            alert("请输入用户名。");
            name.show().focus();
            return false;
        }
        if (password.val() == "" || rePassword.val() == "") {
            alert("请输入密码或二次校验密码");
            return false;
        }
        // if (password != rePassword ) {
        if (password.val() != rePassword.val() ) {
            alert("两次输入的密码不一致，请重新输入：");
            password.val("");
            rePassword.val("");
            password.show().focus();
            return false;
        }
        if (otherid.val()=="") {
            alert("请输入邀请人id。");

            return false;
        }

        $.ajax({
            type:"post",
            url:"/register",
            data:$("form").serialize(),
            dataType:"json",
            success:function (backData) {
                if (backData.code == 200) {

                    window.location.href = "/login2.jsp";
                } else {
                    alert(backData.msg);
                }
            },
            error:function () {
                alert("ajax请求失败");
            }
        });
        return false;
    })
</script>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2022/12/26
  Time: 20:04
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
<form method="post" action="/login">
    name<input type="text" name="phone"><br>
    password<input type="password" name="password"><br>
    <input type="submit" value="登录">
</form>

<script>
    // $(function () {
    //
    // })



    $("form").submit(function () {
        var name = $("input[name='phone']");
        var password = $("input[name='password']");

        if (name.val()=="") {
            alert("请输入手机号。");
            name.show().focus();
            return false;
        }
        if (password.val() == "") {
            alert("请输入密码");
            password.val("");
            password.show().focus();
            return false;
        }

        $.ajax({
            type:"post",
            url:"/login",
            data:$("form").serialize(),
            dataType:"json",
            success:function (backData) {
                if (backData.code == 200) {
                    //这个data其实就是根据name和password返回来的student对象，根据是不是空来判断是否登录成功。
                    var user1 = backData.data;
                    if (user1 != null) {

                        window.location.href = "/sign2.jsp";
                    } else {
                        alert("手机号或密码错误。")
                    }
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


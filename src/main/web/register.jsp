
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>登录</title>
    <style type="text/css">
        table {
            width: 300px;
            border-collapse: collapse;
        }

        h3 {
            text-align: center;
        }

        div {
            margin: 0 auto;
            width: 300px;
        }
    </style>
</head>
<body>
<div>
    <h3>登录</h3>
    <form action="register" method="post" onsubmit="return checkInfo()">
        <table border="1">

            <tr>
                <th>手机号</th>
                <td><input id="phone" type="text" name="phone" /></td>
            </tr>
            <tr>
                <th>密码</th>
                <td><input id="password" type="password" name="password" /></td>
            </tr>
            <tr>
                <th>确认密码</th>
                <td><input id="confirmPassword" type="password" name="confirmPassword" /></td>
            </tr>
            <tr>
                <th>邀请人ID</th>
                <td><input id="otherid" type="text" name="otherid" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="注册账号" />&nbsp;
            </tr>
        </table>
    </form>
</div>
<script type="text/javascript">
    function checkInfo() {
        var phoneEle = document.getElementById("phone");
        var passwordEle = document.getElementById("password");
        var confirmPasswordEle = document.getElementById("confirmPassword");
        var fIdEle = document.getElementById("otherid");

        var phone = phoneEle.value;
        var password = passwordEle.value;
        var confirmPassword = confirmPasswordEle.value;
        var fId = fIdEle.value;

        if(phone == null || phone.length ==0){
            alert("请输入手机号");
            return false;
        }
        if(password == null || password.length ==0){
            alert("请输入密码");
            return false;
        }
        if(confirmPassword == null || confirmPassword.length ==0){
            alert("请输入确认密码");
            return false;
        }
        if(fId == null || fId.length ==0){
            alert("请输入推荐人ID");
            return false;
        }

        if(password != confirmPassword){
            alert("两次密码不相同");
            return false;
        }


    }
</script>
</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>所有员工信息</title>
    <style type="text/css">
        table td {
            text-align: center;
        }
        /*合并表格的边框*/

        table {
            width: 700px;
            border-collapse: collapse;
        }

        h3 {
            text-align: center;
        }

        div {
            margin: 0 auto;
            width: 700px;
        }
    </style>
</head>
<body>
<div>
    <h3>我邀请的人</h3>
    <p>用户：${user.phone}</p>
    <table border="1">

        <tr>
            <th>id</th>
            <th>手机号</th>
            <th>注册时间</th>
            <th>积分奖励</th>

        </tr>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.phone}</td>
                <td>${user.registerTime}</td>
                <td>${user.rewardSum}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

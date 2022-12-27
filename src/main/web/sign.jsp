
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
    <h3>所有签到信息</h3>
    <a href="signIn">签到</a><br/>

    <table border="1">

        <tr>
            <th>id</th>
            <th>手机号</th>
            <th>时间</th>
            <th>奖励积分</th>

        </tr>
        <c:forEach items="${signList}" var="sign">
            <tr>
                <td>${sign.id}</td>
                <td>${sign.phone}</td>
                <td>${sign.arrivetime}</td>
                <td>${sign.score}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

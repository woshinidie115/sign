<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2022/12/26
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
</head>
<body>

<button onclick="sign()">签到</button>
<a href="invite.jsp">查看邀请人信息</a>

<table border="1" width="400">
    <tr>
        <td>id</td>
        <td>电话</td>
        <td>签到时间</td>
        <td>积分</td>
    </tr>
    <tbody id="tbody"></tbody>


</table>

<script>
    function sign() {
        $.ajax({
            type: "get",
            url: "/sign",
            dataType: "json",
            success: function (backData) {
                if (backData.code == 200) {
                    loadData();
                } else {
                    alert(backData.msg);
                }
            },
            error: function () {
                alert("ajax请求异常")
            }
        })
    }

    $(function () {
        loadData();
    })

    function loadData() {
        $.ajax({
            type: "get",
            url: "/signList",
            dataType: "json",
            success: function (backData) {
                if (backData.code == 200) {
                    var signList = backData.data;
                    $("#tbody").empty();
                    $(signList).each(function () {
                        var html = "<tr><td>" + this.id + "</td>" +
                            "<td>" + this.phone + "</td>" +
                            "<td>" + this.arrivetime + "</td>" +
                            "<td>" + this.score + "</td></tr>";
                        $("#tbody").append($(html));
                    })

                } else {
                    alert(backData.msg);
                }
            },
            error: function () {
                alert("ajax请求异常")
            }
        })
    }

</script>

</body>
</html>


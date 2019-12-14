<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <script>
        window.onload = function () {
            var pic = document.getElementById("pic");
            var a_pic = document.getElementById("a_pic");
            pic.onclick = function () {
                var date = new Date();
                var time = date.getTime();
                pic.src = "/day16/checkServlet?"+time;
            }
            a_pic.onclick = function () {
                var date = new Date();
                var time = date.getTime();
                pic.src = "/day16/checkServlet?"+time;
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

<form action="/day16/loginServlet" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username" id="username"></td>
        </tr>
        <tr>
            <td>密   码</td>
            <td><input type="text" name="password" id="password"></td>
        </tr>

        <tr>
            <td>验证码</td>
            <td><input type="text" name="checkBox" id="checkBox"></td>
        </tr>
        <tr>
            <td colspan="1"><img src="/day16/checkServlet" alt="" id="pic"></td>
            <td><a href="javascript:void(0)" id="a_pic">看不清楚?换一张</a></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
<div><%= request.getAttribute("c_error") == null? "" :request.getAttribute("c_error")%></div>
<div><%= request.getAttribute("up_error")== null? "" :request.getAttribute("up_error")%></div>
</body>
</html>

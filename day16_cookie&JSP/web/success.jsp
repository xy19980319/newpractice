<%--
  Created by IntelliJ IDEA.
  User: xy
  Date: 2019/12/12
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆成功</title>
    <style>
        h1{
            align-content: center;
        }
    </style>
</head>
<body>
<h1>尊敬的用户<%= request.getSession().getAttribute("username")%>欢迎您登录</h1>
<%= request.getSession().getAttribute("username")%>
</body>
</html>

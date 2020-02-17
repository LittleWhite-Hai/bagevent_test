<%--
  Created by IntelliJ IDEA.
  User: LittleWhite
  Date: 2020/2/16
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form method="post" action="loginSubmit" class="loginForm">
    ${msg}
    <p><input id="name" name="user_name" placeholder="登录名" ></p>
    <p><input id="password" name="password" type="password"  placeholder="密码" ></p>

    <button  >登录</button>
</form>
</body>
</html>

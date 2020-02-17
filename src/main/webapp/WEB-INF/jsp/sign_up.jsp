<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LittleWhite
  Date: 2020/2/16
  Time: 8:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%><html>

<head>
    <title>注册</title>
</head>

    <script>
    $(function(){

        <c:if test="${!empty msg}">
        $("span.errorMessage").html("${msg}");
        $("div.registerErrorMessageDiv").css("visibility","visible");
        </c:if>


    })
</script>


<div style=" margin:0 auto">
<form method="post" action="register_submit" class="registerForm">
    <div class="registerErrorMessageDiv">
        <div class="alert alert-danger" role="alert">
            <span class="errorMessage">${msg}</span>
        </div>
    </div>
    <p><input id="name" name="user_name" placeholder="登录名" ></p>
    <p><input id="password" name="password" type="password"  placeholder="密码" ></p>
    <p><input id="cellphone" name="cellphone" placeholder="手机号"> </p>
    <button  >注册</button>
</form>
</div>
</body>
</html>

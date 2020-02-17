
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-->
TEST BRANCH!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
<--%>
<html>
<head>
    <title>登录日志</title>
</head>

<body>

<div  id="like_button_container">

</div>
<script src="https://unpkg.com/react@16/umd/react.development.js" crossorigin></script>
<script src="https://unpkg.com/react-dom@16/umd/react-dom.development.js" crossorigin></script>
<script src="https://unpkg.com/babel-standalone@6.15.0/babel.min.js"></script>

<script type="text/babel">
    ReactDOM.render(
            <h1><table>
    <tr>
        <td>日志id</td>
        <td>登陆时间</td>
        <td>ip地址</td>
    </tr>
    <c:forEach items="${ls}" var="log">
        <tr>
            <td>${log.login_id}</td>
            <td>${log.login_time}</td>
            <td>${log.login_ip}</td>
        </tr>
    </c:forEach>
</table></h1>,
        document.getElementById('like_button_container')
    );
</script>

<%--
<script src="../../js/button_like.js"></script>
--%>

</body>
</html>

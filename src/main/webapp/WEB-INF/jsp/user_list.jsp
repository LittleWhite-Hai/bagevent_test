<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>


<c:forEach items="${us}" var="u">


    <div>${u.user_id}</div>
    <div>${u.user_name}</div>
</c:forEach>

</div>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="bean.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body style="font-size: 30px;">
   <%User user = new User();
    user.setUname("李白");
    user.setGender("g");
    session.setAttribute("user", user);
   %>
   用户名：${user.uname }<br/>
   性   别：<c:if test="${user.gender=='m' }">男</c:if>
       <c:if test="${user.gender!='m' }">女</c:if>
       <br/>
       性别：<c:if test="${user.gender }" var="rs" scope="page">男</c:if>
       <c:if test="${!rs }">女</c:if>
       性别：

</body>
</html>
<%@page import="bean.User"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body style="font-size: 30px; color: blue;">
     <%User user = new User();
    user.setUname("李白");
    user.setGender("g");
    user.setAge(20);
    user.setInterest("篮球");
    session.setAttribute("user", user);
   %>
   姓名：${user.uname }<br>
   性别：<c:choose>
         <c:when test="${user.gender=='m' }">男</c:when>
         <c:when test="${user.gender=='f' }">女</c:when>
         <c:otherwise>保密</c:otherwise>
    </c:choose>
    <br>
  年龄：
    <c:choose>
          <c:when test="${user.age>50 }">老年人</c:when>
          <c:when test="${user.age<18 }">未成年</c:when>
          <c:otherwise>成年人</c:otherwise>
    </c:choose>
</body>
</html>
<%@page import="bean.User"%>
<%@page import="java.util.*,bean.*"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
  <style type="text/css">
     .row1{background-color: #FFF;}
     .row2{background-color: pink;}
     table {
	           text-align: center;
}
  </style>
</head>
<body style="font-size: 30px;">
    <%List<User> users = new ArrayList<User>();
      for(int i = 0;i<8;i++){
    	  User user = new User();
    	  user.setUname("user"+i);
    	  user.setGender("m");
    	  user.setAge(25+i);
    	  user.setInterest("足球");
    	  users.add(user);  
      }
      request.setAttribute("users", users);
    %>
    <table width="60%" border="1" cellpadding="0" cellspacing="0">
          <tr>
          <td>序号</td> 
          <td>下标</td>      
          <td>用户名</td>
          <td>性别</td>
          <td>年龄</td>
          <td>兴趣</td></tr>
          <c:forEach items="${users }" var="u" varStatus="s">
          <tr class="row${s.index % 2 + 1}">
              <td>${s.count }</td>
              <td>${s.index }</td>
              <td>${u.uname }</td>
              <td>${u.gender }</td>
              <td>${u.age }</td>
              <td>${u.interest }</td>         
           </tr>
          </c:forEach>
    </table>
     

</body>
</html>
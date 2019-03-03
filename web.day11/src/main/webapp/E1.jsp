<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="Bean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body style="font-size: 30px;">
          <%
          User user = new User();
          user.setUsername("King");
          user.setAge(22);
          request.setAttribute("user", user);
          
          User user2 = new User();
             user2.setUsername("唐三藏");
             user2.setAge(23);
             session.setAttribute("user", user2);
          %>
          username:<% User user1 = (User)request.getAttribute("user");
                      out.println(user1.getUsername());%>
                      <br/>
                      <%--bean 找到以后，就不在继续往后找 --%>
          username:${user.username}
          <br/>
          <!-- 指定查找范围 xxxScope -->
          username:${requestScope.user.age}
          <%--user.username==user["username"] --%>
          username:${user["username"] }
          username:${sessionScope.user["username"] }
          
          <%session.setAttribute("prop", "age"); %>
          <%--user[prop] 相当于 user.username --%>
          允许[]里面出现绑定名：<br/>
          ${user[prop] }
          <br/>
               允许[]里面出现绑定名：<br/>
          ${user[sessionScope.prop] }
          <br/>
          允许[]里面出现从0开始的下标：<br/>
          ${user.interest[0] }
          
</body>
</html>
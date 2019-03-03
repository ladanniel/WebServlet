<%@ page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*,entity.*" %>
<html>
<head></head>
<body style="font-size:30px;">
	     缓存内容为：<%
			List<User> users = 
				(List<User>)application.getAttribute("users");
			for(User u : users){
				out.println(u.getUsername() + "<br/>");
			}
		%>
		
</body>
</html>
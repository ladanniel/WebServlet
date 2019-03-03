<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body style="font-size: 30px;">
       username:<%=pageContext.getAttribute("username") %>
        <br/>
     
        city:<%=request.getAttribute("city") %>
        <!-- request:一次请求，（容器创建新的request对象） 一次响应，（request消失） -->
        <br/>
        city:<%=session.getAttribute("city") %>
        <!-- a5浏览器访问，服务器在内存中开辟一个session内存空间，并创建session对象，浏览器并储存sessionId,a5绑定数据到服务器，a6访问时
                           会带着sessionId一起访问服务器 -->
</body>
</html>
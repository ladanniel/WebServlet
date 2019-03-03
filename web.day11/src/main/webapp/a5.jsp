<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body style="font-size: 30px;">
         <!-- pageContext page上下文 -->
        <%pageContext.setAttribute("username", "tom"); %>
        username:<%=pageContext.getAttribute("username")%>
        <br/>
        <% request.setAttribute("city", "成都"); %>
        <%=request.getAttribute("city") %>
        <br/>
        <%session.setAttribute("city", "芙蓉城-成都"); %>
        <%=session.getAttribute("city") %>

</body>
</html>
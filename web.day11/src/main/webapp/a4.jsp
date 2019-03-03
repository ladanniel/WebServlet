<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body style="font-size: 30px;">
       请输入合法的数字
       <!--  isErrorPage="true"只有值为true，才能使用隐含对象描述 -->
       <%=exception.getMessage()%>
</body>
</html>
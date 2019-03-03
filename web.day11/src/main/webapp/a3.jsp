<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" errorPage="a4.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body style="font-size: 30px;">
     <%String str = request.getParameter("str");
         int str1 = Integer.parseInt(str);
         out.println(str1*2);
     %>

</body>
</html>
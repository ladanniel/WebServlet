<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body style="font-size: 30px;">
  <!-- 代码片段写代码，输出结果在jsp代码表达式 -->
       <%!
        int i = 100;
        int sum(int a1,int a2){
        	return a1+a2;
        }
       %>
       输出i值：  <%=i+100 %><br/>
               求和：<%=sum(50,70) %>
</body>
</html>
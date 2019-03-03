<%@page import="java.util.*"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body style="font-size: 15px;">
          ${1+1 }
          <br/>
          关系运算：${1>3}
          <%request.setAttribute("s1", "abc"); %>
           <br/>
    字符串：      ${s1=='abc' }
     <br/>
     逻辑运算:${2>1&&1<9 }
     <% request.setAttribute("s2", "");
         List list1 = new ArrayList();
         request.setAttribute("list1", list1);
     %>
     <br/>
     空字符串：empty运算：${empty s2 }
      <br/>
    空集合： empty运算：${empty list1 }
      <br/>
   找不到对应的值：  empty运算：${empty null }
      <br/>
   null:  empty运算：${empty abc}
</body>
</html>
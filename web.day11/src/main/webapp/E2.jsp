
<%@page import="bean1.Employee"%>
<%@ page  contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
     <%
        Employee e = new Employee();
     e.setEname("刘备");
     e.setAge(25);
     e.setSalary(5000.00);
     session.setAttribute("e", e);  
     %>
    员工名： <%  Employee emp1=(Employee)session.getAttribute("e");
             out.println(emp1.getEname());
     %>
      <%session.setAttribute("prop", "age"); %>
     <br/>
  年   龄：${e.age }
      <br/>
 工    资：${sessionScope.e.salary }
       <br/>
       允许[]里面出现绑定名：<br/>
          ${e[prop] }
     


</body>
</html>
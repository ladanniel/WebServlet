<%@page  pageEncoding="utf-8" contentType="text/html; charset=utf-8"  %>
<%Cookie c = new Cookie("interest","cooking,fishing");
   c.setPath("/day06");
   response.addCookie(c);
   
   out.println("显示cookie:"+c);
%>
           
   
      
      




<%
  Cookie[] c = request.getCookies();
  if(c!=null){
	  for(Cookie cs : c ){
		  out.print(cs.getName()+":"+cs.getValue()+"<br/>");
	  }
  }


  %>
  
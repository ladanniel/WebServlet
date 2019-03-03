package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String username = request.getParameter("username");
		System.out.println(username);
		response.sendRedirect(request.getContextPath()+"/biz01/b1.jsp");//
		request.getRequestDispatcher("/biz02/b3.jsp");//×ª·¢
	}

}

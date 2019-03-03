package web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class B extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		System.out.println("sc::"+sc);
		//		String username = (String) sc.getAttribute("username");
		response.setContentType("text/html;charset=utf-8");
		//		response.getWriter().println("username:"+ username);
		//		System.out.println("username:"+username);
		HttpSession session  = request.getSession();


		String city = (String) session.getAttribute("city");
		response.getWriter().println("city:"+  city);
		String company = sc.getInitParameter("company");
		response.getWriter().print("company:"+  company);

	}

}

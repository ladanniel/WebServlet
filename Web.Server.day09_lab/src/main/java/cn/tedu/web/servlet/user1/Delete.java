package cn.tedu.web.servlet.user1;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import entity.User;
public class Delete extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//session验证
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user");
		if (obj==null) {
			response.sendRedirect("list");//重定向
			return;    //return: 
		}
		try {
			//删除指定用户
			User use = new User();
			int d = Integer.parseInt(request.getParameter("id"));
			use.setId(d);
			new UserDAO().Del(use);
		} catch (Exception e) {
			
			e.printStackTrace();
			request.setAttribute("error",
					"系统异常，请稍后重试");
			request.getRequestDispatcher("error.jsp")
			.forward(request, response);
		}
		response.sendRedirect("list");
	}

	
}

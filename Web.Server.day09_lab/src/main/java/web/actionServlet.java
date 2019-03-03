package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import entity.User;


public class actionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		System.out.println("path:"+path+":"+uri);
		if ("/login".equals(path)) {
			proLogin(request,response);
		}else if ("/list".equals(path)) {
			proList(request,response);
		}else if ("/add".equals(path)) {
			proAdd(request,response);
		}else if ("/del".equals(path)) {
			proDel(request,response);
		}


	}


	private void proDel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//session验证
				HttpSession session = request.getSession();
				Object obj = session.getAttribute("user");
				if (obj==null) {
					response.sendRedirect("login.jsp");//重定向
					return;    //return: 
				}
				try {
					//删除指定用户
					User use = new User();
					int d = Integer.parseInt(request.getParameter("id"));
					use.setId(d);
					new UserDAO().Del(use);
					response.sendRedirect("list.do");
				} catch (Exception e) {
					
					e.printStackTrace();
					request.setAttribute("error",
							"系统异常，请稍后重试");
					request.getRequestDispatcher("error.jsp")
					.forward(request, response);
				}
				
			
		
	}


	private void proAdd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user");
		if (obj==null) {
			response.sendRedirect("login.jsp");
			return;
		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			UserDAO dao=new UserDAO();
			User u1 = dao.find(username);	
			if (u1!=null) {//说明用户存在
				request.setAttribute("msg", "用户名已经存在");
				request.getRequestDispatcher("addUser.jsp").forward(request, response);	
			}else{ //用户名为空
				User u = new User();
				u.setUsername(username);
				u.setPassword(password);
				u.setEmail(request.getParameter("email"));
				dao.Save(u);//调参数
				response.sendRedirect("list.do");
				System.out.println("重定向执行");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "系统繁忙，请稍后重试");
			request.getRequestDispatcher("error.jsp").forward(request, response);

		}
		
		
		
	}


	private void proList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		/**
		 * 进行session验证
		 */
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user");
		if (obj==null) {
			//==null表示没有登录，重定向到登录页面
			response.sendRedirect("login.jsp");	
			return;//否则没必要继续执行或者加else
		}

		try {//查询所有用户信息
			UserDAO dao = new UserDAO();
			List<User> users = dao.findall();

			request.setAttribute("users", users);
			
			RequestDispatcher rd = request.getRequestDispatcher("LUS3.jsp");
			
			rd.forward(request, response);

		} catch (SQLException e) {

			e.printStackTrace();
		
			request.setAttribute("error", "系统繁忙，请稍后重试");
			request.getRequestDispatcher("error.jsp").forward(request, response);

		}

	}


	private void proLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("utf-8");
		//读取用户名和密码
		String name = request.getParameter("username"); 
		String pw = request.getParameter("password");
		System.out.println(name+":"+pw); 

		UserDAO dao = new UserDAO();
		try{
			User user = dao.find(name);
			if (user!=null && user.getPassword().equals(pw)) {
				//1、session验证登录
				HttpSession session = request.getSession();
				//1、绑定数据到session
				session.setAttribute("user", user);
				response.sendRedirect("list.do");
			}else{
				request.setAttribute("login_failed", "用户名或密码错误");//绑定
				request.getRequestDispatcher("login.jsp").forward(request, response);//获取转发器并转发
			}
		} catch (SQLException e) {			
			e.printStackTrace();
			request.setAttribute("error", "系统繁忙，稍后重试");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}

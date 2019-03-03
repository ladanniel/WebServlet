package cn.tedu.web.servlet.user1;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import utils.DBUtils;

public class ListUserServlet extends HttpServlet{
/**重定向：response.sendRedirect(url);
 * 服务器可以通过发送302状态码以及一个location消息头(该消息头的值是一个地址，称之为重定向地址)给浏览器，浏览器收到地址后，会立即向重定向地址发送请求
 * 
 * 重定向的两个特征：
 * 重定向地址是任意的：
 * 
 * 
 * 重定向之后，浏览器地址栏的地址会发生变化；
 * 注（细节）：容器在重定向之前，会先清空response对象上，放的所有数据。
 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
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
			
				 /**
				  * 依据查询到的数据生成表格
				  */
				 
				 /**
				  * 因为servlet 不便于生成复杂的页面，所以我们通常转发给jsp，由jsp来生成页面
				  */
				 /**
				  * 绑定数据到request
				  */
				 request.setAttribute("users", users);
				 /**
				  * 获得转发器
				  */
				 RequestDispatcher rd = request.getRequestDispatcher("LUS3.jsp");
				 /**
				  * 转发
				  */
				 rd.forward(request, response);
				 
		} catch (SQLException e) {
			
			e.printStackTrace();
		/**转发到系统异常处理页面
		 * 
		 */
			request.setAttribute("error", "系统繁忙，请稍后重试");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			
		}
	}
       
}

package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class commentServlet extends HttpServlet{
	

	public commentServlet() {
		System.out.println("commentServlet的构造器");
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //处理客户端请求
		 System.out.println("service方法开始执行");
		   request.setCharacterEncoding("utf-8");
	       String content = request.getParameter("content");
	       response.setContentType("text/html;charset=utf-8");
	       response.getWriter().println("你的评论是："+content);
	       System.out.println("service方法执行--跟踪--完毕");
	}
	
 
}

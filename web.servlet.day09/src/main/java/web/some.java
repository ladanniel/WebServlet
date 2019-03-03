package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class some extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("some的service方法");
	//获得请求资源路径的方法
	String uri = request.getRequestURI();
	System.out.println("uri::"+uri);
	//分析请示资源路径，进行相应的处理
	String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
	System.out.println("path--"+path);
	if("/add".equals(path)){
		System.out.println("添加用户");
	}
	else if("/list".equals(path)){
		System.out.println("用户列表");
	}
	}

	


}

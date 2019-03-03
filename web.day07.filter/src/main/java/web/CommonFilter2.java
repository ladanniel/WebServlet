package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonFilter2 implements Filter{
	private FilterConfig config;
	public CommonFilter2() {
		System.out.println("commentfilter的构造器被调用了");
	}
	public void destroy() {//销毁方法，不常用
		System.out.println("这是comment的destroy方法");
	}
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("这是doFilter方法开始执行");
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String content = request.getParameter("content");
		String size = config.getInitParameter("length");
		if (content.length()>Integer.parseInt(size)) {
			response.getWriter().println("评论的内容超限");
		}else{
		   arg2.doFilter(request, response);
		}
		
		   
		    System.out.println("doFilter2方法执行--跟踪--完毕");
		 
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("commentFilter的init方法被调用了");
		config=arg0;
		
		
	}

}

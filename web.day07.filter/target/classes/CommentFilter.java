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

public class CommentFilter implements Filter{
	private FilterConfig config;
	
	/*
	 * 容器启动之后，会立即创建过滤器实例
	 * (通过调用构造器)。
	 * 注:
	 * 	只会创建一个实例。
	 */
	public CommentFilter(){
		System.out.println(
				"CommentFilter的构造器");
	}
	
	
	/**
	 * 当容器在删除过滤器实例之前，会先调用
	 * 该实例的destroy方法。
	 * 注：
	 * 		该方法只会执行一次。
	 */
	public void destroy() {
		System.out.println(
				"CommentFilter的destroy方法");
	}
	

	/**
	 * 容器收到请求之后，会调用doFilter方法
	 * 来处理请求。
	 * 容器会将request和response对象作为参数传进来，
	 * 注(了解):
	 * 	 ServletRequest是HttpServletRequest的
	 * 父接口,ServletResponse是HttpServletResponse
	 * 的父接口。这儿没有用子接口，是过度设计的产物。
	 * 
	 * 如果调用了FilterChain对象的doFilter方法，
	 * 表示继续向后调用;否则，中断请求，返回处理结果。
	 * 
	 * 过滤器链
	 */
	public void doFilter(
			ServletRequest arg0, 
			ServletResponse arg1, 
			FilterChain arg2)
			throws IOException, 
			ServletException {
		
		System.out.println("CommentFilter的"
				+ "doFilter方法开始执行");
		
		HttpServletRequest request = 
			(HttpServletRequest)arg0;
		HttpServletResponse response = 
			(HttpServletResponse)arg1;
		
		response.setContentType(
				"text/html;charset=utf-8");
		
		request.setCharacterEncoding("utf-8");
		String content = 
				request.getParameter("content");
		
		//调用FilterConfig对象的方法来读取
		//初始化参数
		String illegal = 
				config.getInitParameter(
						"illegal");
		
		if(content.indexOf(illegal) != -1){
			//包含了敏感字，不再向后调用，返回处理结果
			response.getWriter().println(
					"评论的内容包含了违禁词");
		}else{
			//没有敏感字，则继续向后调用
			arg2.doFilter(request, response);
		}
		
		System.out.println(
				"CommentFilter的doFilter方法执行完毕");
	}

	/**
	 * 容器在创建好过滤器实例之后，会立即调用
	 * 该实例的init方法(初始化方法)。
	 * 注:
	 * 	a.该方法只会执行一次。 
	 *  b.容器会将FilterConfig对象作为参数传进来，
	 *  可以利用该对象读取初始化参数。
	 */
	public void init(FilterConfig arg0) 
			throws ServletException {
		System.out.println(
				"CommentFilter的init方法");
		config = arg0;
	}
	

}




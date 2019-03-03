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

public class CommonFilter implements Filter{
	private FilterConfig config;
	//<!-- 初始化参数可以一个，也可以多个 如果要配置多个初始化参数，可以使用多个init-param配置 -->
	/*实例化：容器调用servlet的构造器，创建servlet对象的过程，就称为实例化
	 * 容器启动之后，会立即创建过滤器实例
	 * (通过调用构造器)。
	 * 注:
	 * 	只会创建一个实例。
	 */

	
	public CommonFilter() {
		System.out.println("commentfilter的构造器被调用了");
	}
     /**
      * 当容器删除过滤器之前，会先调用该实例的destroy方法，该方法只会执行只一次；
//      */
	public void destroy() {//销毁方法，不常用
		System.out.println("这是comment的destroy方法");
		
	}
   /**容器收到请求之后，会调用doFile来处理请求
    * 容器会将请求和响应对象作为参数传进来，
    * 注：servletRequest是HTTPServletRequest的父接口，同理response也是一样
    * FilterChain：过滤器链，如果条用了过滤器链的方法，表示，继续向后调用；否则中断请求，返回处理结果；（决定是否继续向后调用）
    */
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		System.out.println("这是doFilter方法开始执行");	
		    HttpServletRequest request = (HttpServletRequest) arg0;
		    HttpServletResponse response = (HttpServletResponse) arg1;
		    request.setCharacterEncoding("utf-8");
		    String content = request.getParameter("content");
		    response.setContentType("text/html;charset=utf-8");
		    String illegal = config.getInitParameter("illegal");
		    String lnegth =config.getInitParameter("length");
		    if ((content.indexOf("狗"))!=-1) {
				//包含了敏感字，不用向后调用，返回处理结果
		    	response.getWriter().println("评论的内容包含了不合法字符");
			}else if(content.contains(illegal)){
				response.getWriter().println("评论的内容包含了不合法字符");
			}
			else{
				//如果不包含敏感字，则继续向后调用
			    arg2.doFilter(request, response);
			    
			    //写出需要调用另外过滤器的doFilter方法
			    
			}
		    System.out.println("doFilter方法执行--跟踪--完毕");
		 
	}
/**
 * init：初始化
 * 容器在创建好过滤器实例后，会立即调用该实例的init方法
 * 注：
 *   1、该方法只会执行一次；
 *   2、FilterConfig对象作为参数传进来
 *   可以利用该对象，读取初始化参数。
 *   
 *   3.可以在不同的class里面调用多个过滤器
 */
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("commentFilter的init方法被调用了");
		config=arg0;
		
		
	}

}

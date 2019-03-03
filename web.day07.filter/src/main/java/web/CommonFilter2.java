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
		System.out.println("commentfilter�Ĺ�������������");
	}
	public void destroy() {//���ٷ�����������
		System.out.println("����comment��destroy����");
	}
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("����doFilter������ʼִ��");
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String content = request.getParameter("content");
		String size = config.getInitParameter("length");
		if (content.length()>Integer.parseInt(size)) {
			response.getWriter().println("���۵����ݳ���");
		}else{
		   arg2.doFilter(request, response);
		}
		
		   
		    System.out.println("doFilter2����ִ��--����--���");
		 
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("commentFilter��init������������");
		config=arg0;
		
		
	}

}

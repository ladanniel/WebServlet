package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class commentServlet extends HttpServlet{
	

	public commentServlet() {
		System.out.println("commentServlet�Ĺ�����");
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //����ͻ�������
		 System.out.println("service������ʼִ��");
		   request.setCharacterEncoding("utf-8");
	       String content = request.getParameter("content");
	       response.setContentType("text/html;charset=utf-8");
	       response.getWriter().println("��������ǣ�"+content);
	       System.out.println("service����ִ��--����--���");
	}
	
 
}

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
	System.out.println("some��service����");
	//���������Դ·���ķ���
	String uri = request.getRequestURI();
	System.out.println("uri::"+uri);
	//������ʾ��Դ·����������Ӧ�Ĵ���
	String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
	System.out.println("path--"+path);
	if("/add".equals(path)){
		System.out.println("����û�");
	}
	else if("/list".equals(path)){
		System.out.println("�û��б�");
	}
	}

	


}

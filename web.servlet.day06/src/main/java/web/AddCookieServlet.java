package web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCookieServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���cookie��ע�⣺cookie��ֻ�ܱ���Ϸ���ASCII�ַ����������ģ���Ҫת���ɶ�Ӧ��ASCII�ַ�����ʽ��
		Cookie c = new Cookie("username", URLEncoder.encode(("�����")));
		//����cookie����ʱ��
		c.setMaxAge(40);
		response.addCookie(c);
		Cookie c2 = new Cookie("city","bk");
		response.addCookie(c2);
	}
	
    
}

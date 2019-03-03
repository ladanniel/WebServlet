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
		//添加cookie（注意：cookie中只能保存合法的ASCII字符，对于中文，需要转换成对应的ASCII字符的形式）
		Cookie c = new Cookie("username", URLEncoder.encode(("孙悟空")));
		//设置cookie生存时间
		c.setMaxAge(40);
		response.addCookie(c);
		Cookie c2 = new Cookie("city","bk");
		response.addCookie(c2);
	}
	
    
}

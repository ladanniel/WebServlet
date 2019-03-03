package web;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindCookie extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if (cookies!=null) {
			for (Cookie c:cookies) {
				String name = c.getName();
				String value = URLDecoder.decode(c.getValue(),"utf-8");
				pw.println(name+" "+value+"<br/>");
			}
		}else{
			pw.println("√ª”–’“µΩcookie");
		}
	}
}

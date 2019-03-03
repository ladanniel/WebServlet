package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.CookieUtil;

public class CountServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 先查看有没有一个名称为countd cookie，如果有，则添加cookie(值设置为1)
		 * 如果没有，则将其值加1，之后，在将该cookie发送给浏览器
		 */
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String count = CookieUtil.findCookie("count", request);
		if (count==null) {
			CookieUtil.addCookie("count", "1", 30*24*60*60, "/web.servlet.day06.lab", response);
			out.println("该用户是第1次访问：");
		}
		else{
			int v1=Integer.parseInt(count)+1;

			CookieUtil.addCookie("count", v1+"", 30*24*60*60, "/web.servlet.day06.lab", response);
			out.println("该用户是第"+v1+"次访问");
		}


	}	


}

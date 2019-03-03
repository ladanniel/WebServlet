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
		 * �Ȳ鿴��û��һ������Ϊcountd cookie������У������cookie(ֵ����Ϊ1)
		 * ���û�У�����ֵ��1��֮���ڽ���cookie���͸������
		 */
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String count = CookieUtil.findCookie("count", request);
		if (count==null) {
			CookieUtil.addCookie("count", "1", 30*24*60*60, "/web.servlet.day06.lab", response);
			out.println("���û��ǵ�1�η��ʣ�");
		}
		else{
			int v1=Integer.parseInt(count)+1;

			CookieUtil.addCookie("count", v1+"", 30*24*60*60, "/web.servlet.day06.lab", response);
			out.println("���û��ǵ�"+v1+"�η���");
		}


	}	


}

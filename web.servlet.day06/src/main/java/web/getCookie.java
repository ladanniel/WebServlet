package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class getCookie extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie c = new Cookie("cart","001");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
	    Cookie []cookies = request.getCookies();
	    if (cookies!=null) {
	    	boolean flag = false;
	    	for (Cookie c1:cookies){
				String name = c1.getName();	
				if (name.equals("cart")) {
					String value = c1.getValue();
					out.println("如果有则显示,名字和值：名为："+name+";值为："+value);	
				flag = true;
					
				}
			}
           	/**遍历所有cookie，任然找不到，需要添加
	    	 * 
    	     */
	    	if (!flag) { 
	    		response.addCookie(c);
			}
		}
	    
	    else{//如果没有就创建一个
	    	out.println("没有找到cart cookie:即将创建！");
	    }
	}
	

}

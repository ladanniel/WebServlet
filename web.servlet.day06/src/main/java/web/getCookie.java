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
					out.println("���������ʾ,���ֺ�ֵ����Ϊ��"+name+";ֵΪ��"+value);	
				flag = true;
					
				}
			}
           	/**��������cookie����Ȼ�Ҳ�������Ҫ���
	    	 * 
    	     */
	    	if (!flag) { 
	    		response.addCookie(c);
			}
		}
	    
	    else{//���û�оʹ���һ��
	    	out.println("û���ҵ�cart cookie:����������");
	    }
	}
	

}

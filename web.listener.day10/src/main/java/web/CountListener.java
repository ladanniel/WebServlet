package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountListener implements HttpSessionListener{
/**
 * session 对象创建之后，容器会调用此方法
 * 注：httpsessionEvent是事件对象
 */
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("sessionCreated方法");
		//通过session找到上下文
		HttpSession session = arg0.getSession();
		ServletContext sct = session.getServletContext();
		Integer count = (Integer) sct.getAttribute("count");
		if (count==null) {
			//第一个用户
			count=1;
		}else {
			count++;
		}
		sct.setAttribute("count", count);
		
		
	}
	/**
	 * session销毁之后，容器会调用此方法
	 */

	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("sessionDestroy的方法");
		ServletContext sct = arg0.getSession().getServletContext();
		Integer count = (Integer) sct.getAttribute("count");
		count--;
		sct.setAttribute("count", count);
		
		
	}

}

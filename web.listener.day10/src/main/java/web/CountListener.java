package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountListener implements HttpSessionListener{
/**
 * session ���󴴽�֮����������ô˷���
 * ע��httpsessionEvent���¼�����
 */
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("sessionCreated����");
		//ͨ��session�ҵ�������
		HttpSession session = arg0.getSession();
		ServletContext sct = session.getServletContext();
		Integer count = (Integer) sct.getAttribute("count");
		if (count==null) {
			//��һ���û�
			count=1;
		}else {
			count++;
		}
		sct.setAttribute("count", count);
		
		
	}
	/**
	 * session����֮����������ô˷���
	 */

	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("sessionDestroy�ķ���");
		ServletContext sct = arg0.getSession().getServletContext();
		Integer count = (Integer) sct.getAttribute("count");
		count--;
		sct.setAttribute("count", count);
		
		
	}

}

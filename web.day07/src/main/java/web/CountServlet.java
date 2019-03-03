package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CountServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession(true);��request.getSession()���
//		//���sessionId
//		String sessionId = session.getId();
//		System.out.println("sessionId"+sessionId);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		//�޸�session���浽�ڴ��е�ʱ�䵥λ���룩
		session.setMaxInactiveInterval(15);
		//���sessionId
		String sessionId = session.getId();
		System.out.println("sessionId:"+sessionId);
		Integer count = (Integer) session.getAttribute("count");//��ȡ��
		if (count!=null) {
			 count++;
			
		}else{
			count=1;
			
		}
		//�����ʵĴ����󶨵�session�����ϣ��ѵõ��Ĵ����ٷŻ�ȥ��
		session.setAttribute("count", count);
		out.println("���ǵ�"+count+"�η���");
		
		
//		//ɾ��session  invalidateΪ�˽�ʡ����������Ŀ��������Է�����ѡ������������������������߷��񴴽�������Ч��
//		session.invalidate();
		
		
		
		
	}
}

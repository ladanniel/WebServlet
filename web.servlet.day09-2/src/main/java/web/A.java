package web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class A
 */
public class A extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//ͨ���̳���GenericServlet,�����Servlet��������
		/*�����ĵ����ã�
		 * 1�����ڰ�����
		 * 2��ֻҪ���������رջ���Ӧ�ò���ɾ����������һֱ����
		 * request<session<������
		 * ����1��
		 *     �������ʱ�䳤��������request<session<Servlet������.������ʹ������������£�����ʹ���������ڶ̵ģ��������Խ�ʡ�ڴ�ռ䣻
		 * ����2��
		 *     �󶨵��������ϵ����ݣ������û������Թ������ʲ��ҵõ�ֵ�������󶨵�session�ϵ����ݣ�ֻ�����session��Ӧ���û��ܷ��ʲ��õ�ֵ ��
		 *     ת����request�󶨣�
		 *     
		 *  ����2��
		 *  ��ȡȫ�ֵĳ�ʼ��������
		 *  ���Ա�ͬһ��Ӧ���е�����������ܷ��ʵ��ĳ�ʼ����������request��jsp,��������
		 *  ���ã�
		 *     <context-param>
		             <param-name>company</param-name>
		             <param-value>LENOVO:�������</param-value>
	           </context-param>
		 */
		ServletContext sct = getServletContext(); 
		System.out.println("sctx:"+sct);
		//		sct.setAttribute("username", "Giving");
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=utf-8");
		session.setAttribute("city", "�ɶ����ɹ�֮��");
		String company = sct.getInitParameter("company");
		response.getWriter().print("company:"+  company);






	}
}

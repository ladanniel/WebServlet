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

		//通过继承自GenericServlet,来获得Servlet的上下文
		/*上下文的作用：
		 * 1、用于绑定数据
		 * 2、只要服务器不关闭或者应用不被删除，上下文一直存在
		 * request<session<上下文
		 * 区别1：
		 *     从生存的时间长度来看，request<session<Servlet上下文.在满足使用条件的情况下，优先使用生命周期短的，这样可以节省内存空间；
		 * 区别2：
		 *     绑定到上下文上的数据，所有用户都可以共享（访问并且得到值），而绑定到session上的数据，只有与该session对应的用户能访问并得到值 ；
		 *     转发用request绑定；
		 *     
		 *  作用2：
		 *  读取全局的初始化参数：
		 *  可以被同一个应用中的所有组件都能访问到的初始化参数，如request，jsp,过滤器等
		 *  配置：
		 *     <context-param>
		             <param-name>company</param-name>
		             <param-value>LENOVO:联想电脑</param-value>
	           </context-param>
		 */
		ServletContext sct = getServletContext(); 
		System.out.println("sctx:"+sct);
		//		sct.setAttribute("username", "Giving");
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=utf-8");
		session.setAttribute("city", "成都：成功之都");
		String company = sct.getInitParameter("company");
		response.getWriter().print("company:"+  company);






	}
}

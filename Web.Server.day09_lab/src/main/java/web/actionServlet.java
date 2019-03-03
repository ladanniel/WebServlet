package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import entity.User;


public class actionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		System.out.println("path:"+path+":"+uri);
		if ("/login".equals(path)) {
			proLogin(request,response);
		}else if ("/list".equals(path)) {
			proList(request,response);
		}else if ("/add".equals(path)) {
			proAdd(request,response);
		}else if ("/del".equals(path)) {
			proDel(request,response);
		}


	}


	private void proDel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//session��֤
				HttpSession session = request.getSession();
				Object obj = session.getAttribute("user");
				if (obj==null) {
					response.sendRedirect("login.jsp");//�ض���
					return;    //return: 
				}
				try {
					//ɾ��ָ���û�
					User use = new User();
					int d = Integer.parseInt(request.getParameter("id"));
					use.setId(d);
					new UserDAO().Del(use);
					response.sendRedirect("list.do");
				} catch (Exception e) {
					
					e.printStackTrace();
					request.setAttribute("error",
							"ϵͳ�쳣�����Ժ�����");
					request.getRequestDispatcher("error.jsp")
					.forward(request, response);
				}
				
			
		
	}


	private void proAdd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user");
		if (obj==null) {
			response.sendRedirect("login.jsp");
			return;
		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			UserDAO dao=new UserDAO();
			User u1 = dao.find(username);	
			if (u1!=null) {//˵���û�����
				request.setAttribute("msg", "�û����Ѿ�����");
				request.getRequestDispatcher("addUser.jsp").forward(request, response);	
			}else{ //�û���Ϊ��
				User u = new User();
				u.setUsername(username);
				u.setPassword(password);
				u.setEmail(request.getParameter("email"));
				dao.Save(u);//������
				response.sendRedirect("list.do");
				System.out.println("�ض���ִ��");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "ϵͳ��æ�����Ժ�����");
			request.getRequestDispatcher("error.jsp").forward(request, response);

		}
		
		
		
	}


	private void proList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		/**
		 * ����session��֤
		 */
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user");
		if (obj==null) {
			//==null��ʾû�е�¼���ض��򵽵�¼ҳ��
			response.sendRedirect("login.jsp");	
			return;//����û��Ҫ����ִ�л��߼�else
		}

		try {//��ѯ�����û���Ϣ
			UserDAO dao = new UserDAO();
			List<User> users = dao.findall();

			request.setAttribute("users", users);
			
			RequestDispatcher rd = request.getRequestDispatcher("LUS3.jsp");
			
			rd.forward(request, response);

		} catch (SQLException e) {

			e.printStackTrace();
		
			request.setAttribute("error", "ϵͳ��æ�����Ժ�����");
			request.getRequestDispatcher("error.jsp").forward(request, response);

		}

	}


	private void proLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("utf-8");
		//��ȡ�û���������
		String name = request.getParameter("username"); 
		String pw = request.getParameter("password");
		System.out.println(name+":"+pw); 

		UserDAO dao = new UserDAO();
		try{
			User user = dao.find(name);
			if (user!=null && user.getPassword().equals(pw)) {
				//1��session��֤��¼
				HttpSession session = request.getSession();
				//1�������ݵ�session
				session.setAttribute("user", user);
				response.sendRedirect("list.do");
			}else{
				request.setAttribute("login_failed", "�û������������");//��
				request.getRequestDispatcher("login.jsp").forward(request, response);//��ȡת������ת��
			}
		} catch (SQLException e) {			
			e.printStackTrace();
			request.setAttribute("error", "ϵͳ��æ���Ժ�����");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}

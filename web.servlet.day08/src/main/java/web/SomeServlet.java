package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SomeServlet extends HttpServlet{
    private int max;
    private int min;
	@Override
	public void init() throws ServletException {
		//ʵ����
		ServletConfig config = getServletConfig();
		 max = Integer.parseInt(config.getInitParameter("max"));
		 min = Integer.parseInt(config.getInitParameter("min"));
		
	}
	

	@Override
	public void destroy() {
		System.out.println("someServlet��destroy����");
		
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		double we = Integer.parseInt(request.getParameter("we"));
		double he = Integer.parseInt(request.getParameter("he"));
		double bmi =we/(he*he);
		String t;
		if (bmi<he) {
			t="���ع���";
		}else if(bmi>max){
			t="���ع���";
		}else{
			t="����";
		}
		response.getWriter().println("BMIָ��Ϊ"+bmi+"��"+"���أ�"+t);
	}
	
   
}

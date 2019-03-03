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
		//实例化
		ServletConfig config = getServletConfig();
		 max = Integer.parseInt(config.getInitParameter("max"));
		 min = Integer.parseInt(config.getInitParameter("min"));
		
	}
	

	@Override
	public void destroy() {
		System.out.println("someServlet的destroy方法");
		
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
			t="体重过轻";
		}else if(bmi>max){
			t="体重过重";
		}else{
			t="正常";
		}
		response.getWriter().println("BMI指数为"+bmi+"，"+"体重："+t);
	}
	
   
}

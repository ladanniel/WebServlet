package actionServlet;
/**为了使程序运行更方便可以试试这个web.xml中的配置
 * <welcome-file-list>
		<welcome-file>bmi.jsp</welcome-file>
	</welcome-file-list>
 * 
 */

//控制器
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BmiService;


public class bmiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		System.out.println("path:" + path);
		//依据请求路径，调用响应的模型来处理
		if ("/toBmi".equals(path)) {
			
			request.getRequestDispatcher("/WEB-INF/bmi.jsp").forward(request, response);
		}
		else if ("/bmi".equals(path)) {
			
			String height = request.getParameter("height");
			String weight = request.getParameter("weight");
			BmiService bs = new BmiService();
			String status = bs.Bmi(Double.parseDouble(height), Double.parseDouble(weight));
			//依据模型返回的处理结果，调用对应的视图
	      	request.setAttribute("status", status);
			request.getRequestDispatcher("view.jsp").forward(request, response);
		}	
	}
}

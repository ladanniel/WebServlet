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
//		HttpSession session = request.getSession(true);与request.getSession()相等
//		//获得sessionId
//		String sessionId = session.getId();
//		System.out.println("sessionId"+sessionId);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		//修改session保存到内存中的时间单位（秒）
		session.setMaxInactiveInterval(15);
		//获得sessionId
		String sessionId = session.getId();
		System.out.println("sessionId:"+sessionId);
		Integer count = (Integer) session.getAttribute("count");//获取绑定
		if (count!=null) {
			 count++;
			
		}else{
			count=1;
			
		}
		//将访问的次数绑定到session对象上（把得到的次数再放回去）
		session.setAttribute("count", count);
		out.println("您是第"+count+"次访问");
		
		
//		//删除session  invalidate为了节省服务器对象的开销，所以服务器选择对数据清除掉，这样可以提高服务创建和运行效率
//		session.invalidate();
		
		
		
		
	}
}

package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Other extends HttpServlet {
	private static final long serialVersionUID = 1L;//java���л��ܷ�ֹ�汾��ͻ
	private int count=0;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		synchronized(this){
			count++;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+":"+count);
	}
		}
		

}

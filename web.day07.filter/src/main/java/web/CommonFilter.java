package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonFilter implements Filter{
	private FilterConfig config;
	//<!-- ��ʼ����������һ����Ҳ���Զ�� ���Ҫ���ö����ʼ������������ʹ�ö��init-param���� -->
	/*ʵ��������������servlet�Ĺ�����������servlet����Ĺ��̣��ͳ�Ϊʵ����
	 * ��������֮�󣬻���������������ʵ��
	 * (ͨ�����ù�����)��
	 * ע:
	 * 	ֻ�ᴴ��һ��ʵ����
	 */

	
	public CommonFilter() {
		System.out.println("commentfilter�Ĺ�������������");
	}
     /**
      * ������ɾ��������֮ǰ�����ȵ��ø�ʵ����destroy�������÷���ֻ��ִ��ֻһ�Σ�
//      */
	public void destroy() {//���ٷ�����������
		System.out.println("����comment��destroy����");
		
	}
   /**�����յ�����֮�󣬻����doFile����������
    * �����Ὣ�������Ӧ������Ϊ������������
    * ע��servletRequest��HTTPServletRequest�ĸ��ӿڣ�ͬ��responseҲ��һ��
    * FilterChain��������������������˹��������ķ�������ʾ�����������ã������ж����󣬷��ش��������������Ƿ���������ã�
    */
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		System.out.println("����doFilter������ʼִ��");	
		    HttpServletRequest request = (HttpServletRequest) arg0;
		    HttpServletResponse response = (HttpServletResponse) arg1;
		    request.setCharacterEncoding("utf-8");
		    String content = request.getParameter("content");
		    response.setContentType("text/html;charset=utf-8");
		    String illegal = config.getInitParameter("illegal");
		    String lnegth =config.getInitParameter("length");
		    if ((content.indexOf("��"))!=-1) {
				//�����������֣����������ã����ش�����
		    	response.getWriter().println("���۵����ݰ����˲��Ϸ��ַ�");
			}else if(content.contains(illegal)){
				response.getWriter().println("���۵����ݰ����˲��Ϸ��ַ�");
			}
			else{
				//��������������֣������������
			    arg2.doFilter(request, response);
			    
			    //д����Ҫ���������������doFilter����
			    
			}
		    System.out.println("doFilter����ִ��--����--���");
		 
	}
/**
 * init����ʼ��
 * �����ڴ����ù�����ʵ���󣬻��������ø�ʵ����init����
 * ע��
 *   1���÷���ֻ��ִ��һ�Σ�
 *   2��FilterConfig������Ϊ����������
 *   �������øö��󣬶�ȡ��ʼ��������
 *   
 *   3.�����ڲ�ͬ��class������ö��������
 */
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("commentFilter��init������������");
		config=arg0;
		
		
	}

}

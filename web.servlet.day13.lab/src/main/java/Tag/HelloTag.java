package Tag;
/**
 * ��ǩ��
 */
import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * a/ �̳�SimpleTagSupport��
 * b/ ��дdoTag����
 * c/ ��ǩ����Щ���ԣ���ǩ��Ҳ�ж�Ӧ�����ԡ�
 * ������Ҫһ��������Ҫƥ�䣬�����ж�Ӧ��set����
 * 
 *
 */

public class HelloTag extends SimpleTagSupport{
	private String info;
	private int qty;
	
	public void setInfo(String info) {
		System.out.println("����HelloTag��setInfo����"+info);
		this.info = info;
	}

	public void setQty(int qty) {
		System.out.println("����HelloTag��setQty����"+qty);
		this.qty = qty;
	}
	

	public HelloTag() {
		System.out.println("����HelloTag�Ĺ�����");
	}

	@Override
	public void doTag() throws JspException, IOException {
		//д�����߼�
		/**
		 * ͨ���̳���SimpleTagSupport���ṩ�ķ����������pageContext���󣬸ö����ṩ��һЩ���������������������������
		 * �涨ֵ�ֳ�Ϊ��Ӳ���� ,�ڱ���б������Ӳ����
		 */
		System.out.println("����HelloTag�Ķ�Tag����");
		PageContext pcxt = (PageContext) getJspContext();
		JspWriter out = pcxt.getOut();
		for(int i=0;i<qty;i++){
	    	  out.println("hello"+"<br/>");
	      } 
	}



}

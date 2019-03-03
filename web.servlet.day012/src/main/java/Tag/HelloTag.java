package Tag;
/**
 * 标签类
 */
import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * a/ 继承SimpleTagSupport类
 * b/ 重写doTag方法
 * c/ 标签有哪些属性，标签类也有对应的属性。
 * 属性名要一样，类型要匹配，并且有对应的set方法
 * 
 *
 */

public class HelloTag extends SimpleTagSupport{
	private String info;
	private int qty;
	
	public void setInfo(String info) {
		System.out.println("这是HelloTag的setInfo方法"+info);
		this.info = info;
	}

	public void setQty(int qty) {
		System.out.println("这是HelloTag的setQty方法"+qty);
		this.qty = qty;
	}
	

	public HelloTag() {
		System.out.println("这是HelloTag的构造器");
	}

	@Override
	public void doTag() throws JspException, IOException {
		//写处理逻辑
		/**
		 * 通过继承自SimpleTagSupport类提供的方法，来获得pageContext对象，该对象提供了一些可以用来获得其它所有隐含对象
		 * 规定值又称为：硬编码 ,在编程中必须避免硬编码
		 */
		System.out.println("这是HelloTag的都Tag方法");
		PageContext pcxt = (PageContext) getJspContext();
		JspWriter out = pcxt.getOut();
		for(int i=0;i<qty;i++){
	    	  out.println("hello"+"<br/>");
	      } 
	}



}

package util;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	public static void addCookie(String name,
			String value,int age,String path,
			HttpServletResponse response) throws UnsupportedEncodingException{
		
		Cookie c = new Cookie(name, URLEncoder.encode(value,"utf-8"));
		c.setMaxAge(age);
		c.setPath(path);
		response.addCookie(c);
	}
	/**
	 * 依据cookie的名称，查找对应的cookie，并返回该cookie的值
	 * 找不到返回null
	 * @throws UnsupportedEncodingException 
	 */
	public static String findCookie(String name,HttpServletRequest request) throws UnsupportedEncodingException{
		String value = null;
		Cookie[] cookies = request.getCookies();
		if (cookies!=null) {
			for(Cookie c:cookies){
				if (c.getName().equals(name)) {
					value = URLDecoder.decode(c.getValue(),"utf-8");
				}
			}
		}
		System.out.println("value:"+value);
		return value;
	}
	

}

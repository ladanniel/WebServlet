package test;
/**
 * �ַ���ת��
 */
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class strncmp {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = URLEncoder.encode("�����","utf-8");
		System.out.println(str);
		
		String st = URLDecoder.decode(str,"utf-8");
		System.out.println(st);
	}

}

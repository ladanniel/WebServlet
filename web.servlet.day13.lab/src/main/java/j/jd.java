package j;

import java.text.SimpleDateFormat;
import java.util.Date;


public class jd {
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		System.out.println(sdf.format(date));
		
	}
	

}

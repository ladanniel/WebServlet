package service;
//模型（负责数据处理）（业务逻辑）
public class BmiService {
	/**
	 * 依据身高、体重、计算bmi指数，返回的是bmi指数值以及身体状况
	 * @param height
	 * @param weight
	 * @return
	 */
	public String Bmi(double height,double weight){
		String status; 
		double bmi = weight/(height*height);
		if (bmi<19) {
			status = "过轻";
		}else if(bmi>25){
			status = "过重";
		}else{
			status = "正常";
		}
		
		return "你的bmi指数为"+bmi+"体重："+status;
		
	}

}

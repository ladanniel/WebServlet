package service;
//ģ�ͣ��������ݴ�����ҵ���߼���
public class BmiService {
	/**
	 * ������ߡ����ء�����bmiָ�������ص���bmiָ��ֵ�Լ�����״��
	 * @param height
	 * @param weight
	 * @return
	 */
	public String Bmi(double height,double weight){
		String status; 
		double bmi = weight/(height*height);
		if (bmi<19) {
			status = "����";
		}else if(bmi>25){
			status = "����";
		}else{
			status = "����";
		}
		
		return "���bmiָ��Ϊ"+bmi+"���أ�"+status;
		
	}

}

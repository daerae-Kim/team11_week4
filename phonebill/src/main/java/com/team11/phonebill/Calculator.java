package com.team11.phonebill;

import java.text.NumberFormat;

public class Calculator {
	private PlanRates planRates;
	private String plan;
	private int minutesUsed;
	private int numberOfLines;
	
	private double basicMonthlyRate;
	private double additionalLineRate;
	private int includedMinutes;
	private double ratePerExcessMinute;
	
	private NumberFormat nf;
	
	public Calculator(InfoGetter userInfo){
		
		plan = userInfo.getPlan();//���
		minutesUsed = userInfo.getMinutesUsed();//��뷮
		numberOfLines = userInfo.getNumberOfLines();//�ڽ��������Ѷ��μ�

		setPlan(plan);
		
		basicMonthlyRate = planRates.getBasicMonthlyRate(); //�⺻��
		additionalLineRate = planRates.getAdditionalLineRate(); //�߰����μ����߰����
		includedMinutes = planRates.getIncludedMinutes(); //�⺻�����Ǵ���ȭ�ð�
		ratePerExcessMinute = planRates.getRatePerExcessMinute(); //�д��ʰ��ð����

		nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
	}
	
	private void setPlan(String plan){
		if("Gold".equals(plan)){
			planRates = new Gold();
		}
		else if ("Silver".equals(plan)){
			planRates = new Silver();
		}
	}
	
	private double calcExcessRateByMinute(){
		if(minutesUsed - includedMinutes <= 0){ //����ڰ� �ʰ���������
			return 0;
		} 
		else { //����ڰ� �ʰ�������
			return (minutesUsed-includedMinutes) * ratePerExcessMinute;
		}
	}
	
	private double calcExcessRateByLines(){
		if (numberOfLines == 1) 
			return 0;
		else if (numberOfLines>1 && numberOfLines<4){
			return (numberOfLines-1)*additionalLineRate;
		} 
		else{
			return (2*additionalLineRate) + (5*(numberOfLines-3));
		}
		
	}
	public String sumTotalRate(){
		String total = nf.format(basicMonthlyRate + calcExcessRateByMinute() + calcExcessRateByLines());
		return "\nBasicMontlyRate : " + basicMonthlyRate + 
				"\nExcessRateByMinute : " + calcExcessRateByMinute() + 
				"\nExcessRateByLines : " + calcExcessRateByLines() +
				"\n-> Expected Bill : " + total;
	}
}

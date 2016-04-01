package com.team11.phonebill;

public class Silver extends PlanRates{
	private double additionalLineRate;
	private double basicMonthlyRate;
	private double ratePerExcessMinute;
	private int includedMinutes;
	
	public Silver(){
		this.additionalLineRate = 21.50;
		this.basicMonthlyRate = 29.95;
		this.ratePerExcessMinute = 0.54;
		this.includedMinutes = 500;
	}
	
	@Override
	public double getAdditionalLineRate(){
		return additionalLineRate;
	}
	
	@Override
	public double getBasicMonthlyRate(){
		return basicMonthlyRate;
	}
	
	@Override
	public double getRatePerExcessMinute(){
		return ratePerExcessMinute;
	}
	
	@Override
	public int getIncludedMinutes(){
		return includedMinutes;
	}
	
	
}

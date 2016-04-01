package com.team11.phonebill;

public class Gold extends PlanRates {
	
	private double basicMonthlyRate;
	private double ratePerExcessMinute;
	private int includedMinutes;
	private double additionalLineRate;
	
	public Gold(){
		this.basicMonthlyRate = 49.95;
		this.ratePerExcessMinute = 0.45;
		this.includedMinutes = 1000;
		this.additionalLineRate = 14.50;
	}
	@Override
	public double getBasicMonthlyRate() {
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
	
	@Override
	public double getAdditionalLineRate(){
		return additionalLineRate;
	}
	
}

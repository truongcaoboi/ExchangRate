package com.tvh.exchangerate.vo;

import java.util.List;

public class ResultExchange {
	private String fromCur;
	private String toCur;
	private double fromMoney;
	private double moneyExchange;
	
	private List<CurrencyInfo> otherCurrencies;

	public String getFromCur() {
		return fromCur;
	}

	public void setFromCur(String fromCur) {
		this.fromCur = fromCur;
	}

	public String getToCur() {
		return toCur;
	}

	public void setToCur(String toCur) {
		this.toCur = toCur;
	}

	public double getFromMoney() {
		return fromMoney;
	}

	public void setFromMoney(double fromMoney) {
		this.fromMoney = fromMoney;
	}

	public double getMoneyExchange() {
		return moneyExchange;
	}

	public void setMoneyExchange(double moneyExchange) {
		this.moneyExchange = moneyExchange;
	}

	public List<CurrencyInfo> getOtherCurrencies() {
		return otherCurrencies;
	}

	public void setOtherCurrencies(List<CurrencyInfo> otherCurrencies) {
		this.otherCurrencies = otherCurrencies;
	}

	
}

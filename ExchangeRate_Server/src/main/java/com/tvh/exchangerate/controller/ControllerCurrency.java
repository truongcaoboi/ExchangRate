package com.tvh.exchangerate.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.tvh.exchangerate.dao.DAOCurrency;
import com.tvh.exchangerate.vo.Currency;
import com.tvh.exchangerate.vo.CurrencyInfo;
import com.tvh.exchangerate.vo.DataCurrencyClient;
import com.tvh.exchangerate.vo.ResultExchange;

@RestController
public class ControllerCurrency {
	private static final String domainAllow = "http://localhost:81";
	@Autowired
	private DAOCurrency daoCurrency;
	@GetMapping("/currency/getAll")
//	@CrossOrigin(origins = domainAllow)
	@CrossOrigin(origins = {domainAllow})
	public List<Currency> getCurrencys(){
		return daoCurrency.getCurrencys();
	}
	
	@GetMapping("/currency/{id}")
	@CrossOrigin(origins = {domainAllow})
	public Currency getCurrency(@PathVariable int id){
		return daoCurrency.getCurrency(id);
	}
	
	//Có hai cách tiếp cận với object mà POST gửi lên
	//Một là tạo một object có các trường tương ứng với các trường data gửi lên
	//Hai là sử dụng Map<String key, Object value>
	@PostMapping("/currency/exchange")
	@CrossOrigin(origins = {domainAllow})
	public ResultExchange getValueExchange(@RequestBody DataCurrencyClient data) {
		System.out.println(new Gson().toJson(data));
		List<Currency> currencies = daoCurrency.getCurrencys();
		ResultExchange result = new ResultExchange();
		String fromCur = data.getFromCur();
		Currency curf = daoCurrency.getCurrency(fromCur);
		if(curf == null) {
			System.out.println("khong tim thay curf");
			return null;
		}
		String toCur = data.getToCur();
		Currency curt = daoCurrency.getCurrency(toCur);
		if(curt == null) {
			System.out.println("khong tim thay curt");
			return null;
		}
		double fromMoney = data.getFromMoney();
		if(fromMoney < 0) {
			System.out.println("from money nho hon 0");
			return null;
		}
		if(fromMoney > Double.MAX_VALUE) {
			System.out.println("from money qua lon");
			return null;
		}
		double moneyExchange = fromMoney/curf.getExchangeRate()*curt.getExchangeRate();
		double moneyExchangei = 0;
		List<CurrencyInfo> otherCurrencies = new ArrayList<CurrencyInfo>();
		
		for(Currency cur : currencies) {
			CurrencyInfo curi = new CurrencyInfo();
			curi.setId(cur.getId());
			curi.setSumName(cur.getSumName());
			curi.setCurName(cur.getCurName());
			curi.setExchangeRate(cur.getExchangeRate());
			curi.setModifyDate(cur.getModifyDate());
			curi.setNation(cur.getNation());
			curi.setNumberCode(cur.getNumberCode());
			curi.setRanking(cur.getRanking());
			moneyExchangei = fromMoney/curf.getExchangeRate()*curi.getExchangeRate();
			curi.setMoneyExchange(moneyExchangei);
			otherCurrencies.add(curi);
		}
		
		result.setFromCur(fromCur);
		result.setToCur(toCur);
		result.setFromMoney(fromMoney);
		result.setMoneyExchange(moneyExchange);
		result.setOtherCurrencies(otherCurrencies);
		return result;
	}
}

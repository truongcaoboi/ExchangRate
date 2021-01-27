package com.tvh.exchangerate.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Currency")
@Table(name = "CURRENCY")
public class Currency implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected Integer id;
	@Column(name = "sum_name")
	protected String sumName;
	@Column(name = "cur_name")
	protected String curName;
	@Column(name = "exchange_rate")
	protected Double exchangeRate;
	@Column(name = "number_code")
	protected String numberCode;
	@Column(name = "nation")
	protected String nation;
	@Column(name = "modify_date")
	protected Long modifyDate;
	@Column(name="ranking")
	protected Integer ranking;

	public Currency() {
	}

	public Currency(String sumName, String curName, Double exchangeRate, String numberCode, String nation,
			Long modifyDate) {
		this.sumName = sumName;
		this.curName = curName;
		this.exchangeRate = exchangeRate;
		this.numberCode = numberCode;
		this.nation = nation;
		this.modifyDate = modifyDate;
	}

	
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getSumName() {
		return this.sumName;
	}

	public void setSumName(String sumName) {
		this.sumName = sumName;
	}

	public String getCurName() {
		return this.curName;
	}

	public void setCurName(String curName) {
		this.curName = curName;
	}

	public Double getExchangeRate() {
		return this.exchangeRate;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public String getNumberCode() {
		return this.numberCode;
	}

	public void setNumberCode(String numberCode) {
		this.numberCode = numberCode;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public Long getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Long modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

}

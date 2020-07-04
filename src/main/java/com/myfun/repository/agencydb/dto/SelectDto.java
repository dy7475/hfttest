package com.myfun.repository.agencydb.dto;

import java.io.Serializable;

public class SelectDto implements Serializable{
	private String text;
	private String value;
	private String secondValue;
	
	
	/**
	 * 额外参数
	 * **/
	public String getValue() {
		return value;
	}
	public String getSecondValue() {
		return secondValue;
	}
	public void setSecondValue(String secondValue) {
		this.secondValue = secondValue;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}

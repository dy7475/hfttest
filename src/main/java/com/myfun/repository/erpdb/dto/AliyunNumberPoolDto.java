package com.myfun.repository.erpdb.dto;

import java.io.Serializable;

import com.myfun.repository.erpdb.po.ErpAliyunNumberPool;

public class AliyunNumberPoolDto extends ErpAliyunNumberPool implements Serializable {
    
    private Integer phoneNum;
    
	private Integer isBind;
	
	private Integer unBind;

	public Integer getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(Integer phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Integer getIsBind() {
		return isBind;
	}

	public void setIsBind(Integer isBind) {
		this.isBind = isBind;
	}

	public Integer getUnBind() {
		return unBind;
	}

	public void setUnBind(Integer unBind) {
		this.unBind = unBind;
	}
	
}

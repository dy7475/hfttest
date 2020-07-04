package com.myfun.repository.admindb.dto;

import com.myfun.repository.admindb.po.AdminMakeOrderSkill;

public class AdminMakeOrderSkillDto extends AdminMakeOrderSkill{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer isSuperComp;

	private Integer prohibitSpeak;
	
	public Integer getProhibitSpeak() {
		return prohibitSpeak;
	}

	public void setProhibitSpeak(Integer prohibitSpeak) {
		this.prohibitSpeak = prohibitSpeak;
	}

	public Integer getIsSuperComp() {
		return isSuperComp;
	}

	public void setIsSuperComp(Integer isSuperComp) {
		this.isSuperComp = isSuperComp;
	}
	
}

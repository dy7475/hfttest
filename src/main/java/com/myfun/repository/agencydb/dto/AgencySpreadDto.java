package com.myfun.repository.agencydb.dto;

import com.myfun.repository.agencydb.po.AgencySpread;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年5月9日 下午5:26:31 
 * 类说明 
*/
public class AgencySpreadDto extends AgencySpread{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String spreadCount;
	private String spreadCountSucc;
	public String getSpreadCount() {
		return spreadCount;
	}
	public void setSpreadCount(String spreadCount) {
		this.spreadCount = spreadCount;
	}
	public String getSpreadCountSucc() {
		return spreadCountSucc;
	}
	public void setSpreadCountSucc(String spreadCountSucc) {
		this.spreadCountSucc = spreadCountSucc;
	}
}

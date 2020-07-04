package com.myfun.repository.admindb.dto;

import java.io.Serializable;

/**
 * 公寓男女和总数统计信息
 */
public class AdminApartmentCountDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private int girlCount;
	private int boyCount;
	private int totleCount;
	public int getGirlCount() {
		return girlCount;
	}
	public void setGirlCount(int girlCount) {
		this.girlCount = girlCount;
	}
	public int getTotleCount() {
		return totleCount;
	}
	public void setTotleCount(int totleCount) {
		this.totleCount = totleCount;
	}
	public int getBoyCount() {
		return boyCount;
	}
	public void setBoyCount(int boyCount) {
		this.boyCount = boyCount;
	}
}

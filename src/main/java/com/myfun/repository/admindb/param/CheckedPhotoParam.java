package com.myfun.repository.admindb.param;

import com.myfun.repository.support.param.PageParam;

public class CheckedPhotoParam extends PageParam {

	private Integer userId;
	private String date;
	private String flag;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}

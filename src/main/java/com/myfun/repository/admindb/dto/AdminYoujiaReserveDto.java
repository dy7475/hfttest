package com.myfun.repository.admindb.dto;

import com.myfun.repository.admindb.po.AdminYoujiaReserve;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class AdminYoujiaReserveDto extends AdminYoujiaReserve {

	private List<AdminYoujiaReserveHouseEvaDto> houseEvaDtoList;
	private String wxPhoto;

	private Integer sysCaseId;
	private Integer sysCaseType;

	public Integer getSysCaseId() {
		return sysCaseId;
	}

	public void setSysCaseId(Integer sysCaseId) {
		this.sysCaseId = sysCaseId;
	}

	public Integer getSysCaseType() {
		return sysCaseType;
	}

	public void setSysCaseType(Integer sysCaseType) {
		this.sysCaseType = sysCaseType;
	}

	public String getWxPhoto() {
		return wxPhoto;
	}

	public void setWxPhoto(String wxPhoto) {
		this.wxPhoto = wxPhoto;
	}

	public List<AdminYoujiaReserveHouseEvaDto> getHouseEvaDtoList() {
		return houseEvaDtoList;
	}

	public void setHouseEvaDtoList(List<AdminYoujiaReserveHouseEvaDto> houseEvaDtoList) {
		this.houseEvaDtoList = houseEvaDtoList;
	}
}

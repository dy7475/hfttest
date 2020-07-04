package com.myfun.erpWeb.deal.vo;

import java.io.Serializable;
import java.util.List;

import com.myfun.repository.erpdb.po.ErpBuildingPhoto;
import com.myfun.repository.erpdb.po.ErpFunDealPhoto;

import io.swagger.annotations.ApiModelProperty;

public class ErpFunDealPhotoListVO implements Serializable{
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("图片集合")
	private List<ErpFunDealPhoto> erpFunDealPhotoList;
	
	@ApiModelProperty("图片域名")
	private String picDomain;

	public List<ErpFunDealPhoto> getErpFunDealPhotoList() {
		return erpFunDealPhotoList;
	}

	public void setErpFunDealPhotoList(List<ErpFunDealPhoto> erpFunDealPhotoList) {
		this.erpFunDealPhotoList = erpFunDealPhotoList;
	}

	public String getPicDomain() {
	
		return picDomain;
	}

	public void setPicDomain(String picDomain) {
	
		this.picDomain = picDomain;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

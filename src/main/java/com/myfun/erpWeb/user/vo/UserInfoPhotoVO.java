package com.myfun.erpWeb.user.vo;

import java.io.Serializable;
import java.util.List;

import com.myfun.repository.erpdb.po.ErpBuildingPhoto;
import com.myfun.repository.erpdb.po.ErpFunDealPhoto;

import io.swagger.annotations.ApiModelProperty;

public class UserInfoPhotoVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("photoId写死的")
	private Integer photoId;

	@ApiModelProperty("图片地址")
	private String photoAddr;

	public Integer getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

	public String getPhotoAddr() {
		return photoAddr;
	}

	public void setPhotoAddr(String photoAddr) {
		this.photoAddr = photoAddr;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

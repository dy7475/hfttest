package com.myfun.erpWeb.build.vo;

import java.io.Serializable;
import java.util.List;

import com.myfun.repository.erpdb.po.ErpBuildingPhoto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 段成伟
 */
@ApiModel
public class ErpBuildingPhotoListVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("图片集合")
	private List<ErpBuildingPhoto> erpBuildingPhotoList;

	public List<ErpBuildingPhoto> getErpBuildingPhotoList() {
		return erpBuildingPhotoList;
	}

	public void setErpBuildingPhotoList(List<ErpBuildingPhoto> erpBuildingPhotoList) {
		this.erpBuildingPhotoList = erpBuildingPhotoList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
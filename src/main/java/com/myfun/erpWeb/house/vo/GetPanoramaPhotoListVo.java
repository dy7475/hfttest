package com.myfun.erpWeb.house.vo;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class GetPanoramaPhotoListVo {

	@ApiModelProperty("VR列表")
	private List<ErpFunPanoramaPhotoVo> panoramaPhotoList;

	public List<ErpFunPanoramaPhotoVo> getPanoramaPhotoList() {
		return panoramaPhotoList;
	}

	public void setPanoramaPhotoList(List<ErpFunPanoramaPhotoVo> panoramaPhotoList) {
		this.panoramaPhotoList = panoramaPhotoList;
	}
	
	
}

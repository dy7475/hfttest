package com.myfun.erpWeb.build.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 段成伟 上传楼盘图片
 */
@ApiModel
public class DeleteBuildingPhotoParam implements EncryParamIfc {


	@NotNull
	@ApiModelProperty(value = "楼盘相关图片ID,多个','隔开", required = true)
	private String photoIds;

	public String getPhotoIds() {
		return photoIds;
	}

	public void setPhotoIds(String photoIds) {
		this.photoIds = photoIds;
	}
}

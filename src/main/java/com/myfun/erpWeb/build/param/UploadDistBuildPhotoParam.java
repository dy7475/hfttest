package com.myfun.erpWeb.build.param;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 段成伟 上传楼盘分销广告图片
 */
@ApiModel
public class UploadDistBuildPhotoParam implements EncryParamIfc {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@ApiModelProperty(value = "楼盘id", required = true)
	private Integer buildId;
	@NotNull
	@ApiModelProperty(value = "图片类型 1外景 2效果 3户型 4交通 5规划 6配套 7样板 多张图片以英文,分隔", required = true)
	private byte photoType;

	@NotBlank
	@ApiModelProperty(value = "图片地址,多个以英文,分隔", required = true)
	private String photoAddr;

	public String getPhotoAddr() {
		return photoAddr;
	}

	public void setPhotoAddr(String photoAddr) {
		this.photoAddr = photoAddr;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getBuildId() {
		return buildId;
	}

	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	public byte getPhotoType() {
		return photoType;
	}

	public void setPhotoType(byte photoType) {
		this.photoType = photoType;
	}

}

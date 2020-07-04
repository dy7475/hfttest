package com.myfun.erpWeb.build.param;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 段成伟 上传楼盘图片
 */
@ApiModel
public class UploadBuildingPhotoParam implements EncryParamIfc {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@ApiModelProperty(value = "楼盘id", required = true)
	private Integer buildId;
	@NotNull
	@ApiModelProperty(value = "图片类型 1:外景图 2:效果图 3:户型图  4:交通图 5:规划图 6:配套图 7:样板图 8:实景图", required = true)
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

package com.myfun.erpWeb.build.param;

import org.hibernate.validator.constraints.NotBlank;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 段成伟
 */
@ApiModel
public class UploadSealLogoPhotoParam implements EncryParamIfc{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank
	@ApiModelProperty(value="图片地址,多个以英文,分隔", required = true)
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
}

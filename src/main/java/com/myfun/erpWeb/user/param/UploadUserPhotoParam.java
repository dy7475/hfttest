package com.myfun.erpWeb.user.param;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 段成伟
 * 上传用户图片
 */
@ApiModel
public class UploadUserPhotoParam implements EncryParamIfc{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@ApiModelProperty(value="图片类型 1标准照片 2身份证背面 3名片 4店铺内景图 5店铺外景图 6论坛头像 其他 min头像", required = true)
	private byte photoType;
	
	@NotBlank
	@ApiModelProperty(value="图片地址", required = true)
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
	public byte getPhotoType() {
		return photoType;
	}

	public void setPhotoType(byte photoType) {
		this.photoType = photoType;
	}
}

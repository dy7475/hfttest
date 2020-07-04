package com.myfun.erpWeb.deal.param;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 段成伟 上传合同相关图片
 */
@ApiModel
public class UploadDealPhotoParam implements EncryParamIfc {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@ApiModelProperty(value = "合同id", required = true)
	private Integer dealId;
	
	@ApiModelProperty(value = "图片类型 0=客户资料表 1=业主资料表 2=其他资料表 3=logo 4=合同快照 5=合同pdf文件 6=合同补充协议pdf文件 7=印章8=水印", required = true)
	private Byte photoType;
	
	@ApiModelProperty(value = "photoId", required = true)
	private Integer photoId;
	
	@NotBlank
	@ApiModelProperty(value = "图片地址,多个以英文,分隔", required = true)
	private String photoAddr;
	
	@ApiModelProperty(value = "文件类型", required = true)
	private Byte fileType;
	
	@ApiModelProperty(value = "文件子类型", required = true)
	private Byte fileSubType;

	public Byte getFileType() {
	
		return fileType;
	}

	public void setFileType(Byte fileType) {
	
		this.fileType = fileType;
	}

	public Byte getFileSubType() {
	
		return fileSubType;
	}

	public void setFileSubType(Byte fileSubType) {
	
		this.fileSubType = fileSubType;
	}

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public Byte getPhotoType() {
		return photoType;
	}

	public void setPhotoType(Byte photoType) {
		this.photoType = photoType;
	}

	public Integer getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPhotoAddr() {
		return photoAddr;
	}

	public void setPhotoAddr(String photoAddr) {
		this.photoAddr = photoAddr;
	}
}

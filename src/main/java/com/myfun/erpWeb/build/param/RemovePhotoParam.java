package com.myfun.erpWeb.build.param;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 删除图片
 */
@ApiModel
public class RemovePhotoParam implements EncryParamIfc {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@ApiModelProperty(value = "caseId", required = true)
	private Integer caseId;
	@NotNull
	@ApiModelProperty(value = "caseType 1 出售 2 出租", required = true)
	private byte caseType;

	@NotNull
	@ApiModelProperty(value = "图片ID", required = true)
	private Integer photoId;
	@NotBlank
	@ApiModelProperty(value = "caseNo", required = true)
	private String caseNo;

	public Integer getCaseId() {
		return caseId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public byte getCaseType() {
		return caseType;
	}

	public void setCaseType(byte caseType) {
		this.caseType = caseType;
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

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
}

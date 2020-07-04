package com.myfun.erpWeb.deal.param;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 上传发票图片
 */
@ApiModel
public class UploadFailureCausePhotoParam implements EncryParamIfc {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@ApiModelProperty(value = "发票ID", required = true)
	private Integer invoiceId;

	@ApiModelProperty(value = "附件类型 1:合同附件 2:委托证明 3:纳税证明 4：营业执照", required = true)
	private Byte esType;

	@NotBlank
	@ApiModelProperty(value = "图片地址,多个以英文,分隔", required = true)
	private String photoAddr;

	public Integer getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Byte getEsType() {
		return esType;
	}

	public void setEsType(Byte esType) {
		this.esType = esType;
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

package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ErpFunDealParam extends AbstractEncryParam implements DaoBaseParam{
	@ApiModelProperty(value = "合同ID")
	private Integer dealId;
	@ApiModelProperty(value = "分类ID")
	private Integer categoryId;
	@ApiModelProperty(value = "图片类型 0=客户资料表 1=业主资料表 2=其他资料表 3=logo 4=合同快照 5=合同pdf文件 6=合同补充协议pdf文件 7=印章8=水印")
	private String photoType;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public String getPhotoType() {
		return photoType;
	}

	public void setPhotoType(String photoType) {
		this.photoType = photoType;
	}
}

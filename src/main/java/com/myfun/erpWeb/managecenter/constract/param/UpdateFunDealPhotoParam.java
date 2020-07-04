package com.myfun.erpWeb.managecenter.constract.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
@ApiModel
public class UpdateFunDealPhotoParam implements EncryParamIfc {
	@ApiModelProperty(value = "图片ID 用逗号分隔")
	private String photoIds;//图片ID列表
	@ApiModelProperty(value = "业主资料附件图片")
	private Integer sellCount;//业主资料附件图片
	@ApiModelProperty(value = "客户资料附件图片")
	private Integer buyCount;//客户资料附件图片
	@ApiModelProperty(value = "其他资料附件图片")
	private Integer otherCount;//其他资料附件图片
	@ApiModelProperty(value = "合同ID")
	private Integer dealId;

	public String getPhotoIds() {
		return photoIds;
	}

	public void setPhotoIds(String photoIds) {
		this.photoIds = photoIds;
	}

	public Integer getSellCount() {
		return sellCount;
	}

	public void setSellCount(Integer sellCount) {
		this.sellCount = sellCount;
	}

	public Integer getBuyCount() {
		return buyCount;
	}

	public void setBuyCount(Integer buyCount) {
		this.buyCount = buyCount;
	}

	public Integer getOtherCount() {
		return otherCount;
	}

	public void setOtherCount(Integer otherCount) {
		this.otherCount = otherCount;
	}

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}
}

package com.myfun.erpWeb.managecenter.constract.param;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author XIONG CAI
 * @since 2019年9月23日 下午7:28:51
 * Modified XXX XIONG CAI 2019年9月23日
 */
public class ErpFunDealTypeParam {
	@ApiModelProperty(value = "附件类型 图片类型 0=客户资料表 1=业主资料表,2=其他资料")
	private Integer photoType ;

	public Integer getPhotoType() {
	
		return photoType;
	}

	public void setPhotoType(Integer photoType) {
	
		this.photoType = photoType;
	}
	
	
}


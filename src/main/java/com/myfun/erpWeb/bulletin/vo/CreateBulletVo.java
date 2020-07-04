package com.myfun.erpWeb.bulletin.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
@ApiModel(description = "创建公告信息VO")
public class CreateBulletVo implements Serializable {
	@ApiModelProperty("公告ID")
	private Integer bulletId;

	public Integer getBulletId() {
		return bulletId;
	}

	public void setBulletId(Integer bulletId) {
		this.bulletId = bulletId;
	}
}

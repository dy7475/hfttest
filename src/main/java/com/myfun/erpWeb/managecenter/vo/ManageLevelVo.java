package com.myfun.erpWeb.managecenter.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "查询模块权限返回")
public class ManageLevelVo implements Serializable {
	/**
	 * @author 朱科
	 * @since 2018年11月12日
	 * @return
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty("是否有权限")
	private Integer canOper = 0;
	@ApiModelProperty("权限层级（能操作到哪一级，自己所在层级） 1=公司 2：大区 3：片区 4：门店 5：分组")
	private Integer operLevel;

	public Integer getCanOper() {
		return canOper;
	}

	public void setCanOper(Integer canOper) {
		this.canOper = canOper;
	}

	public Integer getOperLevel() {
		return operLevel;
	}

	public void setOperLevel(Integer operLevel) {
		this.operLevel = operLevel;
	}
}

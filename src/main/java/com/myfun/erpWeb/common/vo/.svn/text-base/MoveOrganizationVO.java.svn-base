package com.myfun.erpWeb.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class MoveOrganizationVO {
	@ApiModelProperty("组织机构调动类型 0=马上执行 1=晚上任务执行，当moveType=1时，前端提示文案从moveMsg取")
	private int moveType;
	@ApiModelProperty("前端提示文案")
	private String moveMsg;
	public int getMoveType() {
		return moveType;
	}
	public void setMoveType(int moveType) {
		this.moveType = moveType;
	}
	public String getMoveMsg() {
		return moveMsg;
	}
	public void setMoveMsg(String moveMsg) {
		this.moveMsg = moveMsg;
	}
}

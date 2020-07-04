package com.myfun.erpWeb.managecenter.sysmanager.vo;

import io.swagger.annotations.ApiModelProperty;

public class GetEditedUserSeqNoVo {

	@ApiModelProperty(value = "自己的角色seqNo")
	private Byte selfSeqNo;
	@ApiModelProperty(value = "目标对象的角色seqNo")
	private Byte aimSeqNo;
	@ApiModelProperty(value = "总经理标记; 1 = 总经理")
	private Integer generalFlag;
	public Byte getSelfSeqNo() {
		return selfSeqNo;
	}
	public void setSelfSeqNo(Byte selfSeqNo) {
		this.selfSeqNo = selfSeqNo;
	}
	public Byte getAimSeqNo() {
		return aimSeqNo;
	}
	public void setAimSeqNo(Byte aimSeqNo) {
		this.aimSeqNo = aimSeqNo;
	}
	public Integer getGeneralFlag() {
		return generalFlag;
	}
	public void setGeneralFlag(Integer generalFlag) {
		this.generalFlag = generalFlag;
	}
}

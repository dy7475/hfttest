package com.myfun.erpWeb.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("区域VO")
public class ErpFunRegVo {

	@ApiModelProperty("区域ID")
	private Integer regId;
	@ApiModelProperty("城市ID")
	private Short cityId;
	@ApiModelProperty("区域名称")
	private String regName;
	@ApiModelProperty("序号")
	private Byte seqNo;
	@ApiModelProperty("是否主城区，1=是")
	private Byte mainReg;
	@ApiModelProperty("是否有效 0=无效 1=有效")
	private Byte vertifyFlag;

	public Integer getRegId() {
		return regId;
	}

	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	public Short getCityId() {
		return cityId;
	}

	public void setCityId(Short cityId) {
		this.cityId = cityId;
	}

	public String getRegName() {
		return regName;
	}

	public void setRegName(String regName) {
		this.regName = regName;
	}

	public Byte getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Byte seqNo) {
		this.seqNo = seqNo;
	}

	public Byte getMainReg() {
		return mainReg;
	}

	public void setMainReg(Byte mainReg) {
		this.mainReg = mainReg;
	}

	public Byte getVertifyFlag() {
		return vertifyFlag;
	}

	public void setVertifyFlag(Byte vertifyFlag) {
		this.vertifyFlag = vertifyFlag;
	}
}

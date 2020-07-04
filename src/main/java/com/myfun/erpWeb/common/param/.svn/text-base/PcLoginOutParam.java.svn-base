package com.myfun.erpWeb.common.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("登陆请求参数")
public class PcLoginOutParam extends AbstractEncryParam {

	@ApiModelProperty(hidden = true)
	private Integer cityId;
	@ApiModelProperty(hidden = true)
	private Integer compId;
	@ApiModelProperty("门店付费状态，0-暂停; -1:意向; 1:试用; 2:正式; -2:停用; -3:注销 ,-4待审")
	private Integer deptFlag;
	@ApiModelProperty("更新时间")
	private String updateTime;
	@ApiModelProperty("字典更新时间")
	private String updateDicTime;
	@ApiModelProperty("headShow")
	private Byte headShow;
	@ApiModelProperty("caseType")
	private Byte caseType;

	public String getUpdateDicTime() {
		return updateDicTime;
	}

	public void setUpdateDicTime(String updateDicTime) {
		this.updateDicTime = updateDicTime;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Byte getHeadShow() {
		return headShow;
	}

	public void setHeadShow(Byte headShow) {
		this.headShow = headShow;
	}

	public Byte getCaseType() {
		return caseType;
	}

	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getDeptFlag() {
		return deptFlag;
	}

	public void setDeptFlag(Integer deptFlag) {
		this.deptFlag = deptFlag;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
}

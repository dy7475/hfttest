package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;
import com.myfun.repository.support.param.GeneralParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ConvertDepositHouseParam implements EncryParamIfc {
	private boolean isFJD = false;
	@ApiModelProperty("定金id")
	private Integer id;
	@ApiModelProperty("房源id")
	private Integer caseId;
	@ApiModelProperty("房源类型 1=出售 2=出租")
	private Integer caseType;
	@ApiModelProperty("楼盘id")
	private Integer buildId;
	@ApiModelProperty("房源编号")
	private String caseNo;
	@ApiModelProperty("楼盘名称")
	private String buildName;
	@ApiModelProperty(hidden = true)
	private GeneralParam generalParam;

	public boolean isFJD() {
		return isFJD;
	}

	public void setFJD(boolean FJD) {
		isFJD = FJD;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCaseId() {
		return caseId;
	}
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}
	public Integer getCaseType() {
		return caseType;
	}
	public void setCaseType(Integer caseType) {
		this.caseType = caseType;
	}
	public Integer getBuildId() {
		return buildId;
	}
	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}
	public String getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
	public String getBuildName() {
		return buildName;
	}
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
	public GeneralParam getGeneralParam() {
		return generalParam;
	}
	public void setGeneralParam(GeneralParam generalParam) {
		this.generalParam = generalParam;
	}
}

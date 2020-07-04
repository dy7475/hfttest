package com.myfun.erpWeb.managecenter.sysmanager.vo;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class SysParamListResultVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "参数列表")
	private List<SysParamListVO> sysParamList;
	
	@ApiModelProperty("类型：1=企业版2=专业版3=赢销版0=城市 4=新赢销版 5=物业版 6=单店版")
	private Integer compType;
	
	@ApiModelProperty("是否开通大区 1=是")
	private String areaFlag;
	
	@ApiModelProperty("是否是link下的物业版 1=是")
	private Integer supportPropertyFlag;

	public List<SysParamListVO> getSysParamList() {
		return sysParamList;
	}

	public void setSysParamList(List<SysParamListVO> sysParamList) {
		this.sysParamList = sysParamList;
	}

	public Integer getCompType() {
		return compType;
	}

	public void setCompType(Integer compType) {
		this.compType = compType;
	}

	public String getAreaFlag() {
		return areaFlag;
	}

	public void setAreaFlag(String areaFlag) {
		this.areaFlag = areaFlag;
	}

	public Integer getSupportPropertyFlag() {
		return supportPropertyFlag;
	}

	public void setSupportPropertyFlag(Integer supportPropertyFlag) {
		this.supportPropertyFlag = supportPropertyFlag;
	}

}

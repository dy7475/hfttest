package com.myfun.erpWeb.managecenter.profit.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AppFunPerformanceTypeVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "类型id")
	private Integer performanceId;
	
	@ApiModelProperty(value = "业绩类型名称")
	private String performanceName;
	
	@ApiModelProperty(value = "排序no")
	private Integer seqNo;
	
	@ApiModelProperty(value = "能否删除")
	private Integer canDel;
	
	@ApiModelProperty(value = "业绩分配比例")
	private BigDecimal performanceProportion;
	
	@ApiModelProperty(value = "是否使用该比例分配业绩1=是 0=否")
	private Byte isAuto;

	public Integer getPerformanceId() {
		return performanceId;
	}

	public void setPerformanceId(Integer performanceId) {
		this.performanceId = performanceId;
	}

	public String getPerformanceName() {
		return performanceName;
	}

	public void setPerformanceName(String performanceName) {
		this.performanceName = performanceName;
	}

	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	public Integer getCanDel() {
		return canDel;
	}

	public void setCanDel(Integer canDel) {
		this.canDel = canDel;
	}

	public BigDecimal getPerformanceProportion() {
		return performanceProportion;
	}

	public void setPerformanceProportion(BigDecimal performanceProportion) {
		this.performanceProportion = performanceProportion;
	}

	public Byte getIsAuto() {
		return isAuto;
	}

	public void setIsAuto(Byte isAuto) {
		this.isAuto = isAuto;
	}

}

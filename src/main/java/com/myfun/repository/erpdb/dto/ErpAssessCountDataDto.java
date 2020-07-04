package com.myfun.repository.erpdb.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "个人提成相关的业绩数据")
public class ErpAssessCountDataDto implements Serializable{

    @ApiModelProperty("业绩参与人archiveId")
    private Integer archiveId;
    
    @ApiModelProperty("合同业绩统计数据")
    private BigDecimal sumIncomeAmount;
    
    @ApiModelProperty("统计的数据类型：具体注释查看ErpFunProfitDetailMapper.getAssessCountData查询方法")
    private String countType;
    
    @ApiModelProperty("业绩类别ID：1=过户 2=二手佣金 3=新房佣金 4=租赁租金 5=金融 6=总业绩(旧的)7=总业绩")
    private Integer performanceId;
    
	public Integer getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	public BigDecimal getSumIncomeAmount() {
		return sumIncomeAmount;
	}

	public void setSumIncomeAmount(BigDecimal sumIncomeAmount) {
		this.sumIncomeAmount = sumIncomeAmount;
	}

	public String getCountType() {
		return countType;
	}

	public void setCountType(String countType) {
		this.countType = countType;
	}

	public Integer getPerformanceId() {
		return performanceId;
	}

	public void setPerformanceId(Integer performanceId) {
		this.performanceId = performanceId;
	}
}

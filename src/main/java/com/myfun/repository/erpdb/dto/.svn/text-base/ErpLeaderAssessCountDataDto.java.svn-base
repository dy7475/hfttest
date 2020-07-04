package com.myfun.repository.erpdb.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "个人提成相关的业绩数据")
public class ErpLeaderAssessCountDataDto implements Serializable{

    @ApiModelProperty("业绩直接培育或间接培育人的userId")
    private Integer upLeaderUser;
    
    @ApiModelProperty("合同业绩统计数据")
    private BigDecimal sumIncomeAmount;
    
    @ApiModelProperty("统计的数据类型：具体注释查看ErpFunProfitDynamicShareDetailMapper.getLeaderAssessCountData查询方法")
    private String countType;
    
    @ApiModelProperty("分成人业绩数据类型：0=直接培育人、1=邀请人、2=间接培育人，程序中只使用了1和2，为了方便计算将0和1统一转换成1")
    private Byte upLeaderType;

	public Integer getUpLeaderUser() {
		return upLeaderUser;
	}

	public void setUpLeaderUser(Integer upLeaderUser) {
		this.upLeaderUser = upLeaderUser;
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

	public Byte getUpLeaderType() {
		return upLeaderType;
	}

	public void setUpLeaderType(Byte upLeaderType) {
		this.upLeaderType = upLeaderType;
	}
}

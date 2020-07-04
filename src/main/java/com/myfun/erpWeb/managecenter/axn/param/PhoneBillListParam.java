package com.myfun.erpWeb.managecenter.axn.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class PhoneBillListParam extends AbstractEncryParam {
    
    @ApiModelProperty(value = "组织id")
    private Integer organizationId;
    
    @ApiModelProperty(value = "员工id")
    private Integer userId;
    
    @ApiModelProperty(value = "月份 格式：2019-12")
    private String suffix;
    
    @ApiModelProperty(value = "月份开始", hidden = true)
    private String suffixStart;
    
    @ApiModelProperty(value = "月份结束", hidden = true)
    private String suffixEnd;
    
    @ApiModelProperty(value = "模糊检索字段（隐号，试用组织，组织编号或者使用人）")
    private String queryWord;
    
    @ApiModelProperty(value = "是否导出，0=否 1=是")
    private Integer isExport;
    
    @ApiModelProperty(value = "号池组织id", hidden = true)
    private Integer poolOrganizationId;
    
    public Integer getIsExport() {
        return isExport;
    }
    
    public void setIsExport(Integer isExport) {
        this.isExport = isExport;
    }
    
    @ApiModelProperty(hidden = true)
    private Integer compId;
    
    public Integer getOrganizationId() {
        return organizationId;
    }
    
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }
    
    public Integer getUserId() {
        return userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public String getSuffix() {
        return suffix;
    }
    
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
    
    public String getSuffixStart() {
        return suffixStart;
    }
    
    public void setSuffixStart(String suffixStart) {
        this.suffixStart = suffixStart;
    }
    
    public String getSuffixEnd() {
        return suffixEnd;
    }
    
    public void setSuffixEnd(String suffixEnd) {
        this.suffixEnd = suffixEnd;
    }
    
    public String getQueryWord() {
        return queryWord;
    }
    
    public void setQueryWord(String queryWord) {
        this.queryWord = queryWord;
    }
    
    public Integer getCompId() {
        return compId;
    }
    
    public void setCompId(Integer compId) {
        this.compId = compId;
    }

	public Integer getPoolOrganizationId() {
		return poolOrganizationId;
	}

	public void setPoolOrganizationId(Integer poolOrganizationId) {
		this.poolOrganizationId = poolOrganizationId;
	}
    
}

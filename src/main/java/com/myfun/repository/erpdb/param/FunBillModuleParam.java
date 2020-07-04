package com.myfun.repository.erpdb.param;

import com.myfun.framework.annotation.DefaultValue;
import com.myfun.repository.erpdb.po.ErpFunBillCode;
import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.param.EncryParamIfc;
import com.myfun.repository.support.param.DaoBaseParam;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class FunBillModuleParam extends ErpFunBillCode implements EncryParamIfc {

    private Integer grId;
    private String startTime;
    private String endTime;
    private String earbestDealBillRepeat;
    private String allowUseBillnoIsbyhand;
    private String invalidBillnoCanUseAgain;
    private String billPrintWay;
    private String billPrintTemplet;

    private Date queryStartTime;
    private Date queryEndTime;

    protected Integer pageOffset = 1; // 1 第几页
    protected Integer pageRows; // 50 一页多少条
    private Integer isNeedCount;
    @ApiModelProperty(value = "组织机构ID")
    private Integer organizationId;

    @ApiModelProperty(hidden = true)
	private Boolean isNewOrganization = false;
	
    public Boolean getIsNewOrganization() {
	
		return isNewOrganization;
	}

	public void setIsNewOrganization(Boolean isNewOrganization) {
	
		this.isNewOrganization = isNewOrganization;
	}

	public boolean isNeedCount() {
        return getPageOffset() == 1;
    }

    public Date getQueryEndTime() {
        return queryEndTime;
    }

    public void setQueryEndTime(Date queryEndTime) {
        this.queryEndTime = queryEndTime;
    }

    public Date getQueryStartTime() {
        return queryStartTime;
    }

    public void setQueryStartTime(Date queryStartTime) {
        this.queryStartTime = queryStartTime;
    }

    public Integer getGrId() {
        return grId;
    }

    public void setGrId(Integer grId) {
        this.grId = grId;
    }

    public Integer getPageOffset() {
        return pageOffset;
    }

    public void setPageOffset(Integer pageOffset) {
        this.pageOffset = pageOffset;
    }

    public Integer getPageRows() {
        return pageRows;
    }

    public void setPageRows(Integer pageRows) {
        this.pageRows = pageRows;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getIsNeedCount() {
        return isNeedCount;
    }

    public void setIsNeedCount(Integer isNeedCount) {
        this.isNeedCount = isNeedCount;
    }

    public String getEarbestDealBillRepeat() {
        return earbestDealBillRepeat;
    }

    public void setEarbestDealBillRepeat(String earbestDealBillRepeat) {
        this.earbestDealBillRepeat = earbestDealBillRepeat;
    }

    public String getAllowUseBillnoIsbyhand() {
        return allowUseBillnoIsbyhand;
    }

    public void setAllowUseBillnoIsbyhand(String allowUseBillnoIsbyhand) {
        this.allowUseBillnoIsbyhand = allowUseBillnoIsbyhand;
    }

    public String getInvalidBillnoCanUseAgain() {
        return invalidBillnoCanUseAgain;
    }

    public void setInvalidBillnoCanUseAgain(String invalidBillnoCanUseAgain) {
        this.invalidBillnoCanUseAgain = invalidBillnoCanUseAgain;
    }

    public String getBillPrintWay() {
        return billPrintWay;
    }

    public void setBillPrintWay(String billPrintWay) {
        this.billPrintWay = billPrintWay;
    }

	public String getBillPrintTemplet() {
		return billPrintTemplet;
	}

	public void setBillPrintTemplet(String billPrintTemplet) {
		this.billPrintTemplet = billPrintTemplet;
	}

    @Override
    public Integer getOrganizationId() {
        return organizationId;
    }

    @Override
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

}

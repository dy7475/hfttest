package com.myfun.erpWeb.managecenter.profit.param;

import com.myfun.repository.param.EncryParamIfc;
import com.myfun.repository.support.param.PageParam;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class FinancAuditListParam extends PageParam implements EncryParamIfc {

    @ApiModelProperty(value = "是否实付，0=应收 1=实收",required = true)
    private Integer pfActual;
    @ApiModelProperty(value = "审核人姓名")
    private String auditUserName;
    @ApiModelProperty(value = "创建日期：  1:=应收日期   2=审核日期")
    private Integer timeRank;
    @ApiModelProperty(value = "开始时间")
    private String startTime;// 开始时间
    @ApiModelProperty(value = "结束时间")
    private String endTime;// 结束时间
    @ApiModelProperty(value = "合同编号")
    private String agreementNo;


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

    public Integer getPfActual() {
        return pfActual;
    }

    public void setPfActual(Integer pfActual) {
        this.pfActual = pfActual;
    }

    public String getAuditUserName() {
        return auditUserName;
    }

    public void setAuditUserName(String auditUserName) {
        this.auditUserName = auditUserName;
    }

    public Integer getTimeRank() {
        return timeRank;
    }

    public void setTimeRank(Integer timeRank) {
        this.timeRank = timeRank;
    }


    public String getAgreementNo() {
        return agreementNo;
    }

    public void setAgreementNo(String agreementNo) {
        this.agreementNo = agreementNo;
    }
}

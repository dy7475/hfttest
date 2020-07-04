package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * create by 程二狗 on 2018/11/7 0007
 */
@ApiModel
public class ProcessFinancStatusParam implements EncryParamIfc {
    @ApiModelProperty("帐务ID")
    private String pfIds;
    @ApiModelProperty("合同ID")
    private Integer dealId;
    @ApiModelProperty("帐务ID")
    private Integer pfActual;
    @ApiModelProperty("审核状态(审核=1 反审核=0)")
    private Integer auditStatus;
    @ApiModelProperty("是否来自手机端 1=手机端")
    private Integer isMobileApi;// 是否来自手机端 1=手机端

    @ApiModelProperty("如果有共享中心审核配置, 选择的具体共享中心审核流程的ID")
    private Integer classId;

    public Integer getIsMobileApi() {
        return isMobileApi;
    }

    public void setIsMobileApi(Integer isMobileApi) {
        this.isMobileApi = isMobileApi;
    }

    public String getPfIds() {
        return pfIds;
    }

    public void setPfIds(String pfIds) {
        this.pfIds = pfIds;
    }

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    public Integer getPfActual() {
        return pfActual;
    }

    public void setPfActual(Integer pfActual) {
        this.pfActual = pfActual;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }
}

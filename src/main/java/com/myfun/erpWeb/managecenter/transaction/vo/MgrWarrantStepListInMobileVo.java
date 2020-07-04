package com.myfun.erpWeb.managecenter.transaction.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author czq
 * @since 2019/3/11
 */
public class MgrWarrantStepListInMobileVo {

    @ApiModelProperty(value = "实例表主键")
    private Integer runstepId;

    @ApiModelProperty(value = "合同ID")
    private Integer dealId;

    @ApiModelProperty(value = "步骤排序")
    private Integer stepSeq;

    @ApiModelProperty(value = "执行人 archiveId")
    private Integer executorArchiveId;

    @ApiModelProperty(value = "到期时间 （执行时间）")
    private String timelimitdate;

    public Integer getRunstepId() {
        return runstepId;
    }

    public void setRunstepId(Integer runstepId) {
        this.runstepId = runstepId;
    }

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    public Integer getStepSeq() {
        return stepSeq;
    }

    public void setStepSeq(Integer stepSeq) {
        this.stepSeq = stepSeq;
    }

    public Integer getExecutorArchiveId() {
        return executorArchiveId;
    }

    public void setExecutorArchiveId(Integer executorArchiveId) {
        this.executorArchiveId = executorArchiveId;
    }

    public String getTimelimitdate() {
        return timelimitdate;
    }

    public void setTimelimitdate(String timelimitdate) {
        this.timelimitdate = timelimitdate;
    }
}
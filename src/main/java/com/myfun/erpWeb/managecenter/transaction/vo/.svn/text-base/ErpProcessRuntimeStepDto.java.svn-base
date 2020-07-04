package com.myfun.erpWeb.managecenter.transaction.vo;

import com.myfun.repository.erpdb.po.ErpProcessRuntimeStep;
import io.swagger.annotations.ApiModelProperty;

public class ErpProcessRuntimeStepDto extends ErpProcessRuntimeStep {

    @ApiModelProperty(value = "执行人 archiveId")
    private Integer executorArchiveId;

    @ApiModelProperty(value = "指定提醒人 archiveId")
    private Integer reminderArchiveId;

    @ApiModelProperty(value = "提醒人 archiveId")
    private Integer warnerArchiveId;

    @ApiModelProperty(value = "真正执行人 archiveId")
    private Integer updateUserArchiveId;

    @ApiModelProperty("是否过期(当前时间大于计划时间) 0 没有过期 1 过期")
    private Byte expired;

    public Integer getExecutorArchiveId() {
        return executorArchiveId;
    }

    public void setExecutorArchiveId(Integer executorArchiveId) {
        this.executorArchiveId = executorArchiveId;
    }

    public Integer getReminderArchiveId() {
        return reminderArchiveId;
    }

    public void setReminderArchiveId(Integer reminderArchiveId) {
        this.reminderArchiveId = reminderArchiveId;
    }

    public Integer getWarnerArchiveId() {
        return warnerArchiveId;
    }

    public void setWarnerArchiveId(Integer warnerArchiveId) {
        this.warnerArchiveId = warnerArchiveId;
    }

    public Integer getUpdateUserArchiveId() {
        return updateUserArchiveId;
    }

    public void setUpdateUserArchiveId(Integer updateUserArchiveId) {
        this.updateUserArchiveId = updateUserArchiveId;
    }

    public Byte getExpired() {
        return expired;
    }

    public void setExpired(Byte expired) {
        this.expired = expired;
    }
}

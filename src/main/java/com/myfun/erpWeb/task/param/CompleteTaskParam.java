package com.myfun.erpWeb.task.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("结束任务参数")
public class CompleteTaskParam implements EncryParamIfc {
    @ApiModelProperty(value="任务ID")
    private Integer taskId;
    @ApiModelProperty(value="完成情况1完成2未完成3延期4无法完成")
    private Byte completeStatus;
    @ApiModelProperty(value="任务完成时间")
    private Date taskCompleteTime;
    @ApiModelProperty(value="任务备注")
    private String taskRemark;
    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Byte getCompleteStatus() {
        return completeStatus;
    }

    public void setCompleteStatus(Byte completeStatus) {
        this.completeStatus = completeStatus;
    }

    public Date getTaskCompleteTime() {
        return taskCompleteTime;
    }

    public void setTaskCompleteTime(Date taskCompleteTime) {
        this.taskCompleteTime = taskCompleteTime;
    }

    public String getTaskRemark() {
        return taskRemark;
    }

    public void setTaskRemark(String taskRemark) {
        this.taskRemark = taskRemark;
    }
}

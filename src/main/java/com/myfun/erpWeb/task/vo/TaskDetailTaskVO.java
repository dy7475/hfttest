package com.myfun.erpWeb.task.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("我发布的任务详情下 接收的任务")
public class TaskDetailTaskVO {
    @ApiModelProperty(value="执行人名称人")
    private String recieveUsersName;
    @ApiModelProperty(value="app执行人头像地址")
    private String headImgUrl;
    @ApiModelProperty(value="完成情况1完成2未完成3延期4无法完成")
    private Byte completeStatus;
    @ApiModelProperty(value="任务备注")
    private String taskRemark;
    @ApiModelProperty(value="任务完成时间，既操作时间")
    private Date taskCompleteTime;
    @ApiModelProperty(value="任务截止时间")
    private Date taskEndTime;

    public Date getTaskEndTime() {
        return taskEndTime;
    }

    public void setTaskEndTime(Date taskEndTime) {
        this.taskEndTime = taskEndTime;
    }

    public String getRecieveUsersName() {
        return recieveUsersName;
    }

    public void setRecieveUsersName(String recieveUsersName) {
        this.recieveUsersName = recieveUsersName;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public Byte getCompleteStatus() {
        return completeStatus;
    }

    public void setCompleteStatus(Byte completeStatus) {
        this.completeStatus = completeStatus;
    }

    public String getTaskRemark() {
        return taskRemark;
    }

    public void setTaskRemark(String taskRemark) {
        this.taskRemark = taskRemark;
    }

    public Date getTaskCompleteTime() {
        return taskCompleteTime;
    }

    public void setTaskCompleteTime(Date taskCompleteTime) {
        this.taskCompleteTime = taskCompleteTime;
    }
}

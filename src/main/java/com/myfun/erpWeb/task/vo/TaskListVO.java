package com.myfun.erpWeb.task.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("任务列表VO")
public class TaskListVO {
    @ApiModelProperty(value="任务ID")
    private Integer taskId;
    @ApiModelProperty(value="app发布人或者接收人头像地址")
    private String headImgUrl;
    @ApiModelProperty(value="任务名称")
    private String taskName;
    @ApiModelProperty(value="发布人名字")
    private String sendUserName;
    @ApiModelProperty(value="任务描述")
    private String taskDescription;
    @ApiModelProperty(value="发送时间")
    private Date sendTime;
    @ApiModelProperty(value="任务截止时间")
    private Date taskEndTime;
    @ApiModelProperty(value="完成情况1完成2未完成3延期4无法完成")
    private Byte completeStatus;
    @ApiModelProperty(value="1发送任务2接收任务")
    private Byte taskType;
    @ApiModelProperty(value="关联房客源")
    private FunAndCustVO funAndCustVO;
    @ApiModelProperty(value="执行人名称 多个表现为XX等多少人")
    private String recieveUsersName;
    @ApiModelProperty(value="任务完成时间")
    private Date taskCompleteTime;
    @ApiModelProperty(value="任务接收人数量")
    private Integer recieveCount;
    
    public Integer getRecieveCount() {
		return recieveCount;
	}

	public void setRecieveCount(Integer recieveCount) {
		this.recieveCount = recieveCount;
	}

	public Date getTaskCompleteTime() {
        return taskCompleteTime;
    }

    public void setTaskCompleteTime(Date taskCompleteTime) {
        this.taskCompleteTime = taskCompleteTime;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getSendUserName() {
        return sendUserName;
    }

    public void setSendUserName(String sendUserName) {
        this.sendUserName = sendUserName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getTaskEndTime() {
        return taskEndTime;
    }

    public void setTaskEndTime(Date taskEndTime) {
        this.taskEndTime = taskEndTime;
    }

    public Byte getCompleteStatus() {
        return completeStatus;
    }

    public void setCompleteStatus(Byte completeStatus) {
        this.completeStatus = completeStatus;
    }

    public Byte getTaskType() {
        return taskType;
    }

    public void setTaskType(Byte taskType) {
        this.taskType = taskType;
    }

    public FunAndCustVO getFunAndCustVO() {
        return funAndCustVO;
    }

    public void setFunAndCustVO(FunAndCustVO funAndCustVO) {
        this.funAndCustVO = funAndCustVO;
    }

    public String getRecieveUsersName() {
        return recieveUsersName;
    }

    public void setRecieveUsersName(String recieveUsersName) {
        this.recieveUsersName = recieveUsersName;
    }
}

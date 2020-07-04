package com.myfun.erpWeb.task.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@ApiModel("任务详情")
public class TaskDetailVO {
    @ApiModelProperty(value="任务ID")
    private Integer taskId;
     @ApiModelProperty(value="任务名称")
     private String taskName;
    @ApiModelProperty(value="app发布人头像地址")
    private String headImgUrl;
    @ApiModelProperty(value="发布人名字")
    private String sendUserName;
    @ApiModelProperty(value="发送时间")
    private Date sendTime;
    @ApiModelProperty(value="任务描述")
    private String taskDescription;
    @ApiModelProperty(value="1发送任务2接收任务")
    private Byte taskType;
    @ApiModelProperty(value="执行人名称 多个表现为XX等多少人")
    private String recieveUsersName;
    @ApiModelProperty(value="完成情况1完成2未完成3延期4无法完成")
    private Byte completeStatus;
    @ApiModelProperty(value="任务截止时间")
    private Date taskEndTime;
//    @ApiModelProperty(value="任务附件地址，多个以逗号分隔")
//    private String accessoryAddr;
    @ApiModelProperty(value="域名")
    private String domainName;
    @ApiModelProperty("已发送多少人")
    private Integer sendPeopleCount;
    @ApiModelProperty("未完成个数")
    private Integer notCompleteCount;
    @ApiModelProperty("已完成个数")
    private Integer completeCount;
    @ApiModelProperty("无法完成个数")
    private Integer unablecompleteCount;
    @ApiModelProperty("已经逾期个数")
    private Integer overDueCount;
    @ApiModelProperty("接收任务List")
    private List<TaskDetailTaskVO> recieveTaskList;
    @ApiModelProperty("关联房客源实体")
    private  FunAndCustVO funAndCustVO;
    @ApiModelProperty("附件集合")
    private List<TaskFileVO> taskFileVOList;
    @ApiModelProperty(value="任务备注")
    private String taskRemark;
    @ApiModelProperty(value="任务完成时间")
    private Date taskCompleteTime;

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

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public List<TaskFileVO> getTaskFileVOList() {
        return taskFileVOList;
    }

    public void setTaskFileVOList(List<TaskFileVO> taskFileVOList) {
        this.taskFileVOList = taskFileVOList;
    }

    public String getSendUserName() {
        return sendUserName;
    }

    public void setSendUserName(String sendUserName) {
        this.sendUserName = sendUserName;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public FunAndCustVO getFunAndCustVO() {
        return funAndCustVO;
    }

    public void setFunAndCustVO(FunAndCustVO funAndCustVO) {
        this.funAndCustVO = funAndCustVO;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Byte getTaskType() {
        return taskType;
    }

    public void setTaskType(Byte taskType) {
        this.taskType = taskType;
    }

    public String getRecieveUsersName() {
        return recieveUsersName;
    }

    public void setRecieveUsersName(String recieveUsersName) {
        this.recieveUsersName = recieveUsersName;
    }

    public Byte getCompleteStatus() {
        return completeStatus;
    }

    public void setCompleteStatus(Byte completeStatus) {
        this.completeStatus = completeStatus;
    }

    public Date getTaskEndTime() {
        return taskEndTime;
    }

    public void setTaskEndTime(Date taskEndTime) {
        this.taskEndTime = taskEndTime;
    }

//    public String getAccessoryAddr() {
//        return accessoryAddr;
//    }
//
//    public void setAccessoryAddr(String accessoryAddr) {
//        this.accessoryAddr = accessoryAddr;
//    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public Integer getSendPeopleCount() {
        return sendPeopleCount;
    }

    public void setSendPeopleCount(Integer sendPeopleCount) {
        this.sendPeopleCount = sendPeopleCount;
    }

    public Integer getNotCompleteCount() {
        return notCompleteCount;
    }

    public void setNotCompleteCount(Integer notCompleteCount) {
        this.notCompleteCount = notCompleteCount;
    }

    public Integer getCompleteCount() {
        return completeCount;
    }

    public void setCompleteCount(Integer completeCount) {
        this.completeCount = completeCount;
    }

    public Integer getUnablecompleteCount() {
        return unablecompleteCount;
    }

    public void setUnablecompleteCount(Integer unablecompleteCount) {
        this.unablecompleteCount = unablecompleteCount;
    }

    public Integer getOverDueCount() {
        return overDueCount;
    }

    public void setOverDueCount(Integer overDueCount) {
        this.overDueCount = overDueCount;
    }

    public List<TaskDetailTaskVO> getRecieveTaskList() {
        return recieveTaskList;
    }

    public void setRecieveTaskList(List<TaskDetailTaskVO> recieveTaskList) {
        this.recieveTaskList = recieveTaskList;
    }
}

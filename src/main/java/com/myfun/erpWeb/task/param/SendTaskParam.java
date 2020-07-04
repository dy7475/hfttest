package com.myfun.erpWeb.task.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@ApiModel("发布任务接收参数")
public class SendTaskParam implements EncryParamIfc {
    @ApiModelProperty(value= "任务名称")
    private String taskName;
    @ApiModelProperty(value= "任务描述")
    private String taskDescription;
//    @ApiModelProperty(value= "任务附件地址，多个以逗号分隔")
//    private String accessoryAddr;
    @ApiModelProperty(value= "关联房客源ID")
    private Integer caseId;
    @ApiModelProperty(value= "关联房客源类型1出售2出租3求购4求租")
    private Byte caseType;
    @ApiModelProperty(value= "任务执行人id")
    private List<Integer> userIdList;
    @ApiModelProperty(value= "任务截止时间")
    private Date taskEndTime;
    @ApiModelProperty(value= "是否立即发送0否1是",required = true)
    private Byte sendNow;
    @ApiModelProperty(value= "发送时间")
    private Date sendTime;
    @ApiModelProperty ("附件集合")
    private List<TaskFileParam> taskFileList;
    @ApiModelProperty(value= "Pc专用 任务执行人id,多个以逗号分隔")
    private String userIdStr;
    @ApiModelProperty(value= "pc 专用掉用传1")
    private String fromErp;

    public String getUserIdStr() {
        return userIdStr;
    }

    public void setUserIdStr(String userIdStr) {
        this.userIdStr = userIdStr;
    }

    public String getFromErp() {
        return fromErp;
    }

    public void setFromErp(String fromErp) {
        this.fromErp = fromErp;
    }

    public List<TaskFileParam> getTaskFileList() {
        return taskFileList;
    }

    public void setTaskFileList(List<TaskFileParam> taskFileList) {
        this.taskFileList = taskFileList;
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

//    public String getAccessoryAddr() {
//        return accessoryAddr;
//    }
//
//    public void setAccessoryAddr(String accessoryAddr) {
//        this.accessoryAddr = accessoryAddr;
//    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public Byte getCaseType() {
        return caseType;
    }

    public void setCaseType(Byte caseType) {
        this.caseType = caseType;
    }

    public List<Integer> getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(List<Integer> userIdList) {
        this.userIdList = userIdList;
    }

    public Date getTaskEndTime() {
        return taskEndTime;
    }

    public void setTaskEndTime(Date taskEndTime) {
        this.taskEndTime = taskEndTime;
    }

    public Byte getSendNow() {
        return sendNow;
    }

    public void setSendNow(Byte sendNow) {
        this.sendNow = sendNow;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}

package com.myfun.erpWeb.task.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import org.springframework.data.domain.Page;

import java.util.Date;

@ApiModel("任务列表参数")
public class TaskListParam extends AbstractEncryParam {
    @ApiModelProperty(value="1发送任务2接收任务")
    private Byte taskType;
    @ApiModelProperty(value="关联房客源类型1出售2出租3求购4求租5无关联")
    private Byte caseType;
    @ApiModelProperty(value="完成情况1完成2未完成3延期4无法完成")
    private Byte completeStatus;
    @ApiModelProperty(value="范围")
    private Integer orgId;
    @ApiModelProperty(value="发布人/执行人")
    private Integer relativeUserId;
    @ApiModelProperty(value="时间1今日2一周内3月内4一季内5半年内")
    private Integer date;
    @ApiModelProperty(value="搜索框关键字")
    private String keyWord;
    @ApiModelProperty(value="erp用：操作开始时间")
    private Date operateStartTime;
    @ApiModelProperty(value="erp用：操作结束时间")
    private Date operateEndTime;
    @ApiModelProperty(value="公司id",hidden=true)
    private Integer compId;
    @ApiModelProperty(value="组织idstr")
    private String orgIdStr;
    @ApiModelProperty(value="员工id",hidden=true)
    private Integer userId;
    
    
    
    public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getOrgIdStr() {
		return orgIdStr;
	}

	public void setOrgIdStr(String orgIdStr) {
		this.orgIdStr = orgIdStr;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Date getOperateStartTime() {
        return operateStartTime;
    }

    public void setOperateStartTime(Date operateStartTime) {
        this.operateStartTime = operateStartTime;
    }

    public Date getOperateEndTime() {
        return operateEndTime;
    }

    public void setOperateEndTime(Date operateEndTime) {
        this.operateEndTime = operateEndTime;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getRelativeUserId() {
        return relativeUserId;
    }

    public void setRelativeUserId(Integer relativeUserId) {
        this.relativeUserId = relativeUserId;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Byte getTaskType() {
        return taskType;
    }

    public void setTaskType(Byte taskType) {
        this.taskType = taskType;
    }

    public Byte getCaseType() {
        return caseType;
    }

    public void setCaseType(Byte caseType) {
        this.caseType = caseType;
    }

    public Byte getCompleteStatus() {
        return completeStatus;
    }

    public void setCompleteStatus(Byte completeStatus) {
        this.completeStatus = completeStatus;
    }
}

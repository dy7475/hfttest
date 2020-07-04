package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import com.myfun.utils.DateTimeHelper;

import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;

public class ErpProcessRuntimeStep extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "实例表主键")
	private Integer runstepId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "合同ID")
	private Integer dealId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "步骤ID")
	private Integer stepId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "步骤排序")
	private Integer stepSeq;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "步骤名")
	private String stepName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "时间限制类别")
	private Byte timelimitType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "时间限制")
	private Integer timelimit;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "执行人类别")
	private Byte executorType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "指定执行人")
	private Integer executor;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "指定执行人姓名")
	private String executorName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "指定职务")
	private String executorRole;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "提醒人类别")
	private Byte warnType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "指定提醒人")
	private Integer warner;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "指定提醒人姓名")
	private String warnerName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "指定提醒职务")
	private String warnerRole;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否是系统生成")
	private Byte isSystem;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "前置流程ID")
	private Integer rpevstepId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "前置流程名称")
	private String rpevstepName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "到期时间 （执行时间）")
	private String timelimitdate;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "权证内容（备注）")
	private String flowcontent;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "提醒任务标记")
	private Byte warmFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "提醒人")
	private Integer reminderId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "提醒人姓名")
	private String reminderName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "提醒内容")
	private String warmContent;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "提醒时间")
	private String warnTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "执行状态 1:未处理 2:待处理 3:已处理 4跳过")
	private Byte runstepStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "具体执行人")
	private Integer updateUser;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "执行时间")
	private String updateTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "具体执行人姓名")
	private String updateUsername;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "步骤删除标记 1：标记删除")
	private Byte delFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "排序号")
	private Integer seqSort;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 实例表主键
	 */
	public Integer getRunstepId() {
		return runstepId;
	}

	/**
	 * @mbggenerated 实例表主键
	 */
	public void setRunstepId(Integer runstepId) {
		this.runstepId = runstepId;
	}

	/**
	 * @mbggenerated 合同ID
	 */
	public Integer getDealId() {
		return dealId;
	}

	/**
	 * @mbggenerated 合同ID
	 */
	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 步骤ID
	 */
	public Integer getStepId() {
		return stepId;
	}

	/**
	 * @mbggenerated 步骤ID
	 */
	public void setStepId(Integer stepId) {
		this.stepId = stepId;
	}

	/**
	 * @mbggenerated 步骤排序
	 */
	public Integer getStepSeq() {
		return stepSeq;
	}

	/**
	 * @mbggenerated 步骤排序
	 */
	public void setStepSeq(Integer stepSeq) {
		this.stepSeq = stepSeq;
	}

	/**
	 * @mbggenerated 步骤名
	 */
	public String getStepName() {
		return stepName;
	}

	/**
	 * @mbggenerated 步骤名
	 */
	public void setStepName(String stepName) {
		this.stepName = stepName == null ? null : stepName.trim();
	}

	/**
	 * @mbggenerated 时间限制类别
	 */
	public Byte getTimelimitType() {
		return timelimitType;
	}

	/**
	 * @mbggenerated 时间限制类别
	 */
	public void setTimelimitType(Byte timelimitType) {
		this.timelimitType = timelimitType;
	}

	/**
	 * @mbggenerated 时间限制
	 */
	public Integer getTimelimit() {
		return timelimit;
	}

	/**
	 * @mbggenerated 时间限制
	 */
	public void setTimelimit(Integer timelimit) {
		this.timelimit = timelimit;
	}

	/**
	 * @mbggenerated 执行人类别
	 */
	public Byte getExecutorType() {
		return executorType;
	}

	/**
	 * @mbggenerated 执行人类别
	 */
	public void setExecutorType(Byte executorType) {
		this.executorType = executorType;
	}

	/**
	 * @mbggenerated 指定执行人
	 */
	public Integer getExecutor() {
		return executor;
	}

	/**
	 * @mbggenerated 指定执行人
	 */
	public void setExecutor(Integer executor) {
		this.executor = executor;
	}

	/**
	 * @mbggenerated 指定执行人姓名
	 */
	public String getExecutorName() {
		return executorName;
	}

	/**
	 * @mbggenerated 指定执行人姓名
	 */
	public void setExecutorName(String executorName) {
		this.executorName = executorName == null ? null : executorName.trim();
	}

	/**
	 * @mbggenerated 指定职务
	 */
	public String getExecutorRole() {
		return executorRole;
	}

	/**
	 * @mbggenerated 指定职务
	 */
	public void setExecutorRole(String executorRole) {
		this.executorRole = executorRole == null ? null : executorRole.trim();
	}

	/**
	 * @mbggenerated 提醒人类别
	 */
	public Byte getWarnType() {
		return warnType;
	}

	/**
	 * @mbggenerated 提醒人类别
	 */
	public void setWarnType(Byte warnType) {
		this.warnType = warnType;
	}

	/**
	 * @mbggenerated 指定提醒人
	 */
	public Integer getWarner() {
		return warner;
	}

	/**
	 * @mbggenerated 指定提醒人
	 */
	public void setWarner(Integer warner) {
		this.warner = warner;
	}

	/**
	 * @mbggenerated 指定提醒人姓名
	 */
	public String getWarnerName() {
		return warnerName;
	}

	/**
	 * @mbggenerated 指定提醒人姓名
	 */
	public void setWarnerName(String warnerName) {
		this.warnerName = warnerName == null ? null : warnerName.trim();
	}

	/**
	 * @mbggenerated 指定提醒职务
	 */
	public String getWarnerRole() {
		return warnerRole;
	}

	/**
	 * @mbggenerated 指定提醒职务
	 */
	public void setWarnerRole(String warnerRole) {
		this.warnerRole = warnerRole == null ? null : warnerRole.trim();
	}

	/**
	 * @mbggenerated 是否是系统生成
	 */
	public Byte getIsSystem() {
		return isSystem;
	}

	/**
	 * @mbggenerated 是否是系统生成
	 */
	public void setIsSystem(Byte isSystem) {
		this.isSystem = isSystem;
	}

	/**
	 * @mbggenerated 前置流程ID
	 */
	public Integer getRpevstepId() {
		return rpevstepId;
	}

	/**
	 * @mbggenerated 前置流程ID
	 */
	public void setRpevstepId(Integer rpevstepId) {
		this.rpevstepId = rpevstepId;
	}

	/**
	 * @mbggenerated 前置流程名称
	 */
	public String getRpevstepName() {
		return rpevstepName;
	}

	/**
	 * @mbggenerated 前置流程名称
	 */
	public void setRpevstepName(String rpevstepName) {
		this.rpevstepName = rpevstepName == null ? null : rpevstepName.trim();
	}

	/**
	 * @mbggenerated 到期时间 （执行时间）
	 */
	public String getTimelimitdate() {
		return timelimitdate;
	}

	/**
	 * @mbggenerated 到期时间 （执行时间）
	 */
	public void setTimelimitdate(String timelimitdate) {
		this.timelimitdate = timelimitdate == null ? null : timelimitdate.trim();
	}

	/**
	 * @mbggenerated 权证内容（备注）
	 */
	public String getFlowcontent() {
		return flowcontent;
	}

	/**
	 * @mbggenerated 权证内容（备注）
	 */
	public void setFlowcontent(String flowcontent) {
		this.flowcontent = flowcontent == null ? null : flowcontent.trim();
	}

	/**
	 * @mbggenerated 提醒任务标记
	 */
	public Byte getWarmFlag() {
		return warmFlag;
	}

	/**
	 * @mbggenerated 提醒任务标记
	 */
	public void setWarmFlag(Byte warmFlag) {
		this.warmFlag = warmFlag;
	}

	/**
	 * @mbggenerated 提醒人
	 */
	public Integer getReminderId() {
		return reminderId;
	}

	/**
	 * @mbggenerated 提醒人
	 */
	public void setReminderId(Integer reminderId) {
		this.reminderId = reminderId;
	}

	/**
	 * @mbggenerated 提醒人姓名
	 */
	public String getReminderName() {
		return reminderName;
	}

	/**
	 * @mbggenerated 提醒人姓名
	 */
	public void setReminderName(String reminderName) {
		this.reminderName = reminderName == null ? null : reminderName.trim();
	}

	/**
	 * @mbggenerated 提醒内容
	 */
	public String getWarmContent() {
		return warmContent;
	}

	/**
	 * @mbggenerated 提醒内容
	 */
	public void setWarmContent(String warmContent) {
		this.warmContent = warmContent == null ? null : warmContent.trim();
	}

	/**
	 * @mbggenerated 提醒时间
	 */
	public String getWarnTime() {
		return warnTime;
	}

	/**
	 * @mbggenerated 提醒时间
	 */
	public void setWarnTime(String warnTime) {
		this.warnTime = warnTime == null ? null : warnTime.trim();
	}

	/**
	 * @mbggenerated 执行状态 1:未处理 2:待处理 3:已处理 4跳过
	 */
	public Byte getRunstepStatus() {
		return runstepStatus;
	}

	/**
	 * @mbggenerated 执行状态 1:未处理 2:待处理 3:已处理 4跳过
	 */
	public void setRunstepStatus(Byte runstepStatus) {
		this.runstepStatus = runstepStatus;
	}

	/**
	 * @mbggenerated 具体执行人
	 */
	public Integer getUpdateUser() {
		return updateUser;
	}

	/**
	 * @mbggenerated 具体执行人
	 */
	public void setUpdateUser(Integer updateUser) {
		this.updateUser = updateUser;
	}

	/**
	 * @mbggenerated 执行时间
	 */
	public String getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated 执行时间
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime == null ? null : updateTime.trim();
	}

	/**
	 * @mbggenerated 具体执行人姓名
	 */
	public String getUpdateUsername() {
		return updateUsername;
	}

	/**
	 * @mbggenerated 具体执行人姓名
	 */
	public void setUpdateUsername(String updateUsername) {
		this.updateUsername = updateUsername == null ? null : updateUsername.trim();
	}

	/**
	 * @mbggenerated 步骤删除标记 1：标记删除
	 */
	public Byte getDelFlag() {
		return delFlag;
	}

	/**
	 * @mbggenerated 步骤删除标记 1：标记删除
	 */
	public void setDelFlag(Byte delFlag) {
		this.delFlag = delFlag;
	}

	/**
	 * @mbggenerated 排序号
	 */
	public Integer getSeqSort() {
		return seqSort;
	}

	/**
	 * @mbggenerated 排序号
	 */
	public void setSeqSort(Integer seqSort) {
		this.seqSort = seqSort;
	}

	/**
	 * @mbggenerated
	 */
	public ErpProcessRuntimeStep() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpProcessRuntimeStep(Integer shardCityId, Integer runstepId) {
		super(shardCityId);
		this.runstepId = runstepId;
	}

	public String getUpdateContent(ErpProcessRuntimeStep obj) {
		String updateContent = "";
		ErpProcessRuntimeStep other = obj;
		int count = 0;
		if(executor!=null){
			if (!executor.equals(other.executor)){
				count++;
				if(count==2){
					updateContent+="指定执行人";
					return updateContent;
				}else{
					updateContent+="指定执行人、";
				}
			}
		}
		if(executorRole!=null){
			if (!executorRole.equals(other.executorRole)){
				count++;
				if(count==2){
					updateContent+="指定执行角色";
					return updateContent;
				}else{
					updateContent+="指定执行角色、";
				}
			}
		}
		if(executorType!=null){
			if (!executorType.equals(other.executorType)){
				count++;
				if(count==2){
					updateContent+="指定执行人类别";
					return updateContent;
				}else{
					updateContent+="指定执行人类别、";
				}
			}
		}
		if(flowcontent!=null){
			if (!flowcontent.equals(other.flowcontent)){
				count++;
				if(count==2){
					updateContent+="备注";
					return updateContent;
				}else{
					updateContent+="备注、";
				}
			}
		}
		if(reminderId!=null){
			if (!reminderId.equals(other.reminderId)){
				count++;
				if(count==2){
					updateContent+="提醒人";
					return updateContent;
				}else{
					updateContent+="提醒人、";
				}
			}
		}
		if(rpevstepId!=null){
			if (!rpevstepId.equals(other.rpevstepId)){
				count++;
				if(count==2){
					updateContent+="前置流程";
					return updateContent;
				}else{
					updateContent+="前置流程、";
				}
			}
		}
		if(runstepStatus!=null){
			if (!runstepStatus.equals(other.runstepStatus)){
				count++;
				if(count==2){
					updateContent+="执行状态";
					return updateContent;
				}else{
					updateContent+="执行状态、";
				}
			}
		}
		if(timelimitdate!=null){
			if (!DateTimeHelper.formatDateTimetoString(timelimitdate, DateTimeHelper.FMT_yyyyMMdd).equals(DateTimeHelper.formatDateTimetoString(other.timelimitdate, DateTimeHelper.FMT_yyyyMMdd))){
				count++;
				if(count==2){
					updateContent+="计划完成日期";
					return updateContent;
				}else{
					updateContent+="计划完成日期、";
				}
			}
		}
		if(updateTime!=null){
			if (!DateTimeHelper.formatDateTimetoString(updateTime, DateTimeHelper.FMT_yyyyMMdd).equals(DateTimeHelper.formatDateTimetoString(other.updateTime, DateTimeHelper.FMT_yyyyMMdd))){
				count++;
				if(count==2){
					updateContent+="完成时间";
					return updateContent;
				}else{
					updateContent+="完成时间、";
				}
			}
		}
		if(updateUser!=null){
			if (!updateUser.equals(other.updateUser)){
				count++;
				if(count==2){
					updateContent+="更新人";
					return updateContent;
				}else{
					updateContent+="更新人、";
				}
			}
		}
		if(warmContent!=null){
			if (!warmContent.equals(other.warmContent)){
				count++;
				if(count==2){
					updateContent+="提醒内容";
					return updateContent;
				}else{
					updateContent+="提醒内容、";
				}

			}
		}
		if(warner!=null){
			if (!warner.equals(other.warner)){
				count++;
				if(count==2){
					updateContent+="提醒人";
					return updateContent;
				}else{
					updateContent+="提醒人、";
				}
			}
		}
		if(warnerRole!=null){
			if (!warnerRole.equals(other.warnerRole)){

				count++;
				if(count==2){
					updateContent+="提醒角色";
					return updateContent;
				}else{
					updateContent+="提醒角色、";
				}

			}
		}
		if(warnTime!=null){
			if (!DateTimeHelper.formatDateTimetoString(warnTime, DateTimeHelper.FMT_yyyyMMdd).equals(DateTimeHelper.formatDateTimetoString(other.warnTime, DateTimeHelper.FMT_yyyyMMdd))){
				count++;
				if(count==2){
					updateContent+="提醒时间";
					return updateContent;
				}else{
					updateContent+="提醒时间、";
				}
			}
		}
		if(warnType!=null)
			if (!warnType.equals(other.warnType)){
				count++;
				if(count==2){
					updateContent+="提醒类型";
					return updateContent;
				}else{
					updateContent+="提醒类型、";
				}
			}
		return updateContent;

	}

}
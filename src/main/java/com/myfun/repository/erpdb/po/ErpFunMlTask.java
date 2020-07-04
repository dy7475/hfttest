package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpFunMlTask extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "任务ID")
	private Integer taskId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "发送任务ID")
	private Integer sendTaskId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "发布人ID")
	private Integer sendUserId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "发布人档案ID")
	private Integer sendArchiveId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "发布人名字")
	private String sendUserName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否立即发送0否1是")
	private Byte sendNow;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "发送时间")
	private Date sendTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否删除0否1是")
	private Byte delStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "发送人组织ID")
	private Integer sendUserOrgId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "发送人组织线")
	private String sendUserOrgPath;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "任务名称")
	private String taskName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "任务描述")
	private String taskDescription;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "关联房客源ID")
	private Integer caseId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "关联房客源类型1出售2出租3求购4求租")
	private Byte caseType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "完成情况1完成2未完成3延期4无法完成")
	private Byte completeStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "任务截止时间")
	private Date taskEndTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "任务完成时间")
	private Date taskCompleteTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "任务备注")
	private String taskRemark;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "任务附件地址，多个以逗号分隔")
	private String accessoryAddr;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否可看0否1是 1出现在列表")
	private Byte seeStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "1发送任务2接收任务")
	private Byte taskType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "执行人ID")
	private Integer recieveUsersId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "接收人档案ID")
	private Integer recieveArchiveId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "执行人名称 多个表现为XX等多少人")
	private String recieveUsersName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "执行人组织机构")
	private String recieveUserOrgId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "执行人组织结构线")
	private String recieveUserOrgPath;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "延期任务是否已经发送app消息提醒0否1是")
	private Integer sendStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String taskSearch;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer recieveCount;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 任务ID
	 */
	public Integer getTaskId() {
		return taskId;
	}

	/**
	 * @mbggenerated 任务ID
	 */
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	/**
	 * @mbggenerated 发送任务ID
	 */
	public Integer getSendTaskId() {
		return sendTaskId;
	}

	/**
	 * @mbggenerated 发送任务ID
	 */
	public void setSendTaskId(Integer sendTaskId) {
		this.sendTaskId = sendTaskId;
	}

	/**
	 * @mbggenerated 发布人ID
	 */
	public Integer getSendUserId() {
		return sendUserId;
	}

	/**
	 * @mbggenerated 发布人ID
	 */
	public void setSendUserId(Integer sendUserId) {
		this.sendUserId = sendUserId;
	}

	/**
	 * @mbggenerated 发布人档案ID
	 */
	public Integer getSendArchiveId() {
		return sendArchiveId;
	}

	/**
	 * @mbggenerated 发布人档案ID
	 */
	public void setSendArchiveId(Integer sendArchiveId) {
		this.sendArchiveId = sendArchiveId;
	}

	/**
	 * @mbggenerated 发布人名字
	 */
	public String getSendUserName() {
		return sendUserName;
	}

	/**
	 * @mbggenerated 发布人名字
	 */
	public void setSendUserName(String sendUserName) {
		this.sendUserName = sendUserName;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated 是否立即发送0否1是
	 */
	public Byte getSendNow() {
		return sendNow;
	}

	/**
	 * @mbggenerated 是否立即发送0否1是
	 */
	public void setSendNow(Byte sendNow) {
		this.sendNow = sendNow;
	}

	/**
	 * @mbggenerated 发送时间
	 */
	public Date getSendTime() {
		return sendTime;
	}

	/**
	 * @mbggenerated 发送时间
	 */
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	/**
	 * @mbggenerated 是否删除0否1是
	 */
	public Byte getDelStatus() {
		return delStatus;
	}

	/**
	 * @mbggenerated 是否删除0否1是
	 */
	public void setDelStatus(Byte delStatus) {
		this.delStatus = delStatus;
	}

	/**
	 * @mbggenerated 发送人组织ID
	 */
	public Integer getSendUserOrgId() {
		return sendUserOrgId;
	}

	/**
	 * @mbggenerated 发送人组织ID
	 */
	public void setSendUserOrgId(Integer sendUserOrgId) {
		this.sendUserOrgId = sendUserOrgId;
	}

	/**
	 * @mbggenerated 发送人组织线
	 */
	public String getSendUserOrgPath() {
		return sendUserOrgPath;
	}

	/**
	 * @mbggenerated 发送人组织线
	 */
	public void setSendUserOrgPath(String sendUserOrgPath) {
		this.sendUserOrgPath = sendUserOrgPath;
	}

	/**
	 * @mbggenerated 任务名称
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * @mbggenerated 任务名称
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * @mbggenerated 任务描述
	 */
	public String getTaskDescription() {
		return taskDescription;
	}

	/**
	 * @mbggenerated 任务描述
	 */
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	/**
	 * @mbggenerated 关联房客源ID
	 */
	public Integer getCaseId() {
		return caseId;
	}

	/**
	 * @mbggenerated 关联房客源ID
	 */
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	/**
	 * @mbggenerated 关联房客源类型1出售2出租3求购4求租
	 */
	public Byte getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated 关联房客源类型1出售2出租3求购4求租
	 */
	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}

	/**
	 * @mbggenerated 完成情况1完成2未完成3延期4无法完成
	 */
	public Byte getCompleteStatus() {
		return completeStatus;
	}

	/**
	 * @mbggenerated 完成情况1完成2未完成3延期4无法完成
	 */
	public void setCompleteStatus(Byte completeStatus) {
		this.completeStatus = completeStatus;
	}

	/**
	 * @mbggenerated 任务截止时间
	 */
	public Date getTaskEndTime() {
		return taskEndTime;
	}

	/**
	 * @mbggenerated 任务截止时间
	 */
	public void setTaskEndTime(Date taskEndTime) {
		this.taskEndTime = taskEndTime;
	}

	/**
	 * @mbggenerated 任务完成时间
	 */
	public Date getTaskCompleteTime() {
		return taskCompleteTime;
	}

	/**
	 * @mbggenerated 任务完成时间
	 */
	public void setTaskCompleteTime(Date taskCompleteTime) {
		this.taskCompleteTime = taskCompleteTime;
	}

	/**
	 * @mbggenerated 任务备注
	 */
	public String getTaskRemark() {
		return taskRemark;
	}

	/**
	 * @mbggenerated 任务备注
	 */
	public void setTaskRemark(String taskRemark) {
		this.taskRemark = taskRemark;
	}

	/**
	 * @mbggenerated 任务附件地址，多个以逗号分隔
	 */
	public String getAccessoryAddr() {
		return accessoryAddr;
	}

	/**
	 * @mbggenerated 任务附件地址，多个以逗号分隔
	 */
	public void setAccessoryAddr(String accessoryAddr) {
		this.accessoryAddr = accessoryAddr;
	}

	/**
	 * @mbggenerated 是否可看0否1是 1出现在列表
	 */
	public Byte getSeeStatus() {
		return seeStatus;
	}

	/**
	 * @mbggenerated 是否可看0否1是 1出现在列表
	 */
	public void setSeeStatus(Byte seeStatus) {
		this.seeStatus = seeStatus;
	}

	/**
	 * @mbggenerated 1发送任务2接收任务
	 */
	public Byte getTaskType() {
		return taskType;
	}

	/**
	 * @mbggenerated 1发送任务2接收任务
	 */
	public void setTaskType(Byte taskType) {
		this.taskType = taskType;
	}

	/**
	 * @mbggenerated 执行人ID
	 */
	public Integer getRecieveUsersId() {
		return recieveUsersId;
	}

	/**
	 * @mbggenerated 执行人ID
	 */
	public void setRecieveUsersId(Integer recieveUsersId) {
		this.recieveUsersId = recieveUsersId;
	}

	/**
	 * @mbggenerated 接收人档案ID
	 */
	public Integer getRecieveArchiveId() {
		return recieveArchiveId;
	}

	/**
	 * @mbggenerated 接收人档案ID
	 */
	public void setRecieveArchiveId(Integer recieveArchiveId) {
		this.recieveArchiveId = recieveArchiveId;
	}

	/**
	 * @mbggenerated 执行人名称 多个表现为XX等多少人
	 */
	public String getRecieveUsersName() {
		return recieveUsersName;
	}

	/**
	 * @mbggenerated 执行人名称 多个表现为XX等多少人
	 */
	public void setRecieveUsersName(String recieveUsersName) {
		this.recieveUsersName = recieveUsersName;
	}

	/**
	 * @mbggenerated 执行人组织机构
	 */
	public String getRecieveUserOrgId() {
		return recieveUserOrgId;
	}

	/**
	 * @mbggenerated 执行人组织机构
	 */
	public void setRecieveUserOrgId(String recieveUserOrgId) {
		this.recieveUserOrgId = recieveUserOrgId;
	}

	/**
	 * @mbggenerated 执行人组织结构线
	 */
	public String getRecieveUserOrgPath() {
		return recieveUserOrgPath;
	}

	/**
	 * @mbggenerated 执行人组织结构线
	 */
	public void setRecieveUserOrgPath(String recieveUserOrgPath) {
		this.recieveUserOrgPath = recieveUserOrgPath;
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
	 * @mbggenerated 延期任务是否已经发送app消息提醒0否1是
	 */
	public Integer getSendStatus() {
		return sendStatus;
	}

	/**
	 * @mbggenerated 延期任务是否已经发送app消息提醒0否1是
	 */
	public void setSendStatus(Integer sendStatus) {
		this.sendStatus = sendStatus;
	}

	/**
	 * @mbggenerated -
	 */
	public String getTaskSearch() {
		return taskSearch;
	}

	/**
	 * @mbggenerated -
	 */
	public void setTaskSearch(String taskSearch) {
		this.taskSearch = taskSearch;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getRecieveCount() {
		return recieveCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setRecieveCount(Integer recieveCount) {
		this.recieveCount = recieveCount;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunMlTask() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunMlTask(Integer shardCityId, Integer taskId) {
		super(shardCityId);
		this.taskId = taskId;
	}
}
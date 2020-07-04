package com.myfun.service.jms.bean;

import java.util.List;

import com.myfun.repository.admindb.po.AdminFunUserMessage;
import com.myfun.repository.support.constant.Const.LogInEnum;
import com.myfun.service.jms.TaskQueueThread.TaskType;

/**
 * 延后处理任务的消息对象
 * @author 张宏利
 * @since 2017年11月3日
 */
public class TaskQueueMsg {
	private TaskType[] taskType;
	private Integer[] targetIds;
	private LogInEnum logInEnum;
	private AdminFunUserMessage adminFunUserMessage;
	private ViewLogTaskWarningParam viewLogTaskWarningParam;
	private List<AdminFunUserMessage> messageList;

	public TaskType[] getTaskType() {
		return taskType;
	}

	public void setTaskType(TaskType[] taskType) {
		this.taskType = taskType;
	}

	public AdminFunUserMessage getAdminFunUserMessage() {
		return adminFunUserMessage;
	}

	public void setAdminFunUserMessage(AdminFunUserMessage adminFunUserMessage) {
		this.adminFunUserMessage = adminFunUserMessage;
	}

	public List<AdminFunUserMessage> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<AdminFunUserMessage> messageList) {
		this.messageList = messageList;
	}

	public ViewLogTaskWarningParam getViewLogTaskWarningParam() {
		return viewLogTaskWarningParam;
	}

	public void setViewLogTaskWarningParam(ViewLogTaskWarningParam viewLogTaskWarningParam) {
		this.viewLogTaskWarningParam = viewLogTaskWarningParam;
	}

	public Integer[] getTargetIds() {
		return targetIds;
	}

	public void setTargetIds(Integer[] targetIds) {
		this.targetIds = targetIds;
	}

	public LogInEnum getLogInEnum() {
		return logInEnum;
	}

	public void setLogInEnum(LogInEnum logInEnum) {
		this.logInEnum = logInEnum;
	}
	
}

package com.myfun.service.jms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.util.SpringContextUtil;
import com.myfun.repository.admindb.dao.AdminAppRefreshUserMapper;
import com.myfun.repository.admindb.po.AdminFunUserMessage;
import com.myfun.repository.support.constant.Const.LogInEnum;
import com.myfun.service.business.erpdb.ErpFunTaskService;
import com.myfun.service.jms.bean.TaskQueueMsg;
import com.myfun.service.jms.bean.ViewLogTaskWarningParam;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.HttpUtil;

public class TaskQueueThread {
	private transient static final Logger logger = LoggerFactory.getLogger(TaskQueueThread.class.getName());
	
	/** 消息内容队列，所有的消息存在这，等单独的线程扫描并处理 */
	public static LinkedBlockingQueue<TaskQueueMsg> taskMsgQueue = new LinkedBlockingQueue<>();
	public static ErpFunTaskService erpFunTaskService;
	public static AdminAppRefreshUserMapper adminAppRefreshUserMapper;
	private final static int MAX_COUNT_REMOVE = 100;

	static {
		erpFunTaskService = SpringContextUtil.getBean(ErpFunTaskService.class);
		adminAppRefreshUserMapper = SpringContextUtil.getBean(AdminAppRefreshUserMapper.class);
	}

	public static enum TaskType{
		/**用户访问接口记录*/
		POST_CPP_SERVICE,
		/**用户使用情况分数记录*/
		BORKER_CLICK_LOG,
		/**踢出app登录用户*/
		MERGE_APP_REFRESH_USER,
		/**所有用户请求记录*/
		SQL_RUNTIME_RECORDE,
		/**发送socket消息*/
		SEND_SOCKET_MESSAGE,
		/**推送给socketWeb，匹配到数据后推送给前端*/
		MATCH_HOUSE_CUST,
		/**查询房客源列表记录用户查询条件*/
		USER_SEARCH_LIST_RECORD,
		/**房客源指定提醒人*/
		TASK_TIMED,
		/**增加提醒总经理查看条数达到上限*/
		VIEW_LOG_TASK_WARNING,
	}
	
	static {
		// 单独发送消息的线程
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					// take()是阻塞的，没有消息时线程挂起
					while (true) {
						try {
							TaskQueueMsg taskQueueMsg = taskMsgQueue.take();
							for (TaskType taskType : taskQueueMsg.getTaskType()) {
								switch (taskType) {
									case SEND_SOCKET_MESSAGE:
										sendSocketMessage(taskQueueMsg.getAdminFunUserMessage());
										break;
									case TASK_TIMED:
										sendSocketMessage(taskQueueMsg.getMessageList());
										break;
									case VIEW_LOG_TASK_WARNING:
										createViewLogTaskWarning(taskQueueMsg.getViewLogTaskWarningParam());
										break;
									case MERGE_APP_REFRESH_USER:
										mergeAppRefreshUser(taskQueueMsg.getTargetIds(), taskQueueMsg.getLogInEnum());
										break;
									default:
										break;
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, "taskQueueThread").start();
	}
	
	/**
	 * 添加发送对象到队列
	 * ！！所有必须调用此方法添加！！
	 * @author 张宏利
	 */
	public static void addTaskMsgQueue(TaskQueueMsg record){
		if(taskMsgQueue.size() < MAX_COUNT_REMOVE) {
			taskMsgQueue.add(record);
		}
	}
	
	/**
	 * 添加发送对象到队列
	 * @author 张宏利
	 */
	public static void sendMessage(TaskQueueMsg record){
		addTaskMsgQueue(record);
	}
	
	/**
	 * 踢app用户下线
	 * @author 张宏利
	 */
	public static void sendMessageMergeAppRefreshUser(LogInEnum logInEnum, Integer... archiveIds){
		TaskQueueMsg record = new TaskQueueMsg();
		record.setTaskType(new TaskType[]{TaskType.MERGE_APP_REFRESH_USER});
		record.setTargetIds(archiveIds);
		record.setLogInEnum(logInEnum);
		addTaskMsgQueue(record);
	}
	
	/**
	 * 发送socket消息
	 * @author 张宏利
	 * 
	 */
	public static void sendMessage(AdminFunUserMessage adminFunUserMessage, Integer moduleType, String trackContent){
		if(adminFunUserMessage == null){
			return;
		}
		adminFunUserMessage.setModuleType(moduleType);
		adminFunUserMessage.setMsgContent(trackContent);
		TaskQueueThread.sendMessage(adminFunUserMessage);
	}
	
	/**
	 * 发送socket消息
	 * @author 张宏利
	 * 
	 */
	public static void sendMessage(AdminFunUserMessage adminFunUserMessage){
		TaskQueueMsg record = new TaskQueueMsg();
		record.setTaskType(new TaskType[]{TaskType.SEND_SOCKET_MESSAGE});
		record.setAdminFunUserMessage(adminFunUserMessage);
		addTaskMsgQueue(record);
	}
	
	/**
	 * 发送socket消息
	 * @author 张宏利
	 * 
	 */
	public static void sendMessageList(List<AdminFunUserMessage> messageList){
		TaskQueueMsg record = new TaskQueueMsg();
		record.setTaskType(new TaskType[]{TaskType.TASK_TIMED});
		record.setMessageList(messageList);
		addTaskMsgQueue(record);
	}
	
	/**
	 * 发送socket消息
	 * @author 张宏利
	 */
	public static void sendMessage(Integer cityId, Integer compId, Integer caseType, Integer casePlateType,
			String userName, Integer caseId, String caseNo, Integer caseDeptId, Integer selfDeptId, Integer selfUserId){
		ViewLogTaskWarningParam param = new ViewLogTaskWarningParam();
		param.setCityId(cityId);
		param.setCompId(compId);
		param.setCaseType(caseType);
		param.setCasePlateType(casePlateType);
		param.setUserName(userName);
		param.setCaseId(caseId);
		param.setCaseNo(caseNo);
		param.setCaseDeptId(caseDeptId);
		param.setSelfDeptId(selfDeptId);
		param.setSelfUserId(selfUserId);
		TaskQueueMsg record = new TaskQueueMsg();
		record.setTaskType(new TaskType[]{TaskType.VIEW_LOG_TASK_WARNING});
		record.setViewLogTaskWarningParam(param);
		addTaskMsgQueue(record);
	}
	
	/**
	 * 发送socket通知消息
	 * @author 张宏利
	 * @since 2017年11月6日
	 * @param funUserMessage
	 */
	private static void sendSocketMessage(AdminFunUserMessage funUserMessage){
		try {
			if (funUserMessage == null || funUserMessage.getArchiveId() == null) {
				return;
			}
			Map<String, Object> param = new HashMap<>();
			param.put("cityId", funUserMessage.getCityId());
			param.put("compId", funUserMessage.getCompId());
			param.put("appType", funUserMessage.getAppType());
			param.put("archiveId", funUserMessage.getArchiveId());
			param.put("userMobile", funUserMessage.getUserMobile());
			param.put("socketId", funUserMessage.getSocketId());
			param.put("msgModule", funUserMessage.getMsgModule());
			param.put("moduleType", funUserMessage.getModuleType());
			param.put("caseId", funUserMessage.getCaseId());
			param.put("caseType", funUserMessage.getCaseType());
			param.put("houseUseage", funUserMessage.getHouseUseage());
			param.put("msgContent", funUserMessage.getMsgContent());
			param.put("isDel", funUserMessage.getIsDel());
			param.put("caseNo", funUserMessage.getCaseNo());
			param.put("createArchiveId", funUserMessage.getCreateArchiveId());
			param.put("createUserName", funUserMessage.getCreateUserName());
			param.put("targetId", funUserMessage.getTargetId());
			if(funUserMessage.getInvalidTime() != null) {
				String invalidTime = DateTimeHelper.formatDateTimetoString(funUserMessage.getInvalidTime());
				param.put("invalidTime", invalidTime);
			}
			if(funUserMessage.getCreationTime() != null) {
				String creationTime = DateTimeHelper.formatDateTimetoString(funUserMessage.getCreationTime());
				param.put("creationTime", creationTime);
			}
			HttpUtil.post(AppConfig.getSocketWebUrl() + "/socket/send", param);
		} catch (Exception e) {
			logger.error("sendSocketMessage:" + e.getMessage());
		}
	}
	
	/**
	 * 增加提醒总经理查看条数达到上限
	 * @author 张宏利
	 * @since 2018年2月11日
	 * @param param
	 */
	private static void createViewLogTaskWarning(ViewLogTaskWarningParam param){
		try {
			erpFunTaskService.createViewLogTaskWarning(param.getCityId(), param.getCompId(), param.getCaseType(),
					param.getCasePlateType(), param.getUserName(), param.getCaseId(), param.getCaseNo(),
					param.getCaseDeptId(), param.getSelfDeptId(), param.getSelfUserId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 踢app用户登录
	 * @author 张宏利
	 * @since 2018年6月20日
	 * @param targetIds
	 * @param logInEnum 
	 */
	private static void mergeAppRefreshUser(Integer[] targetIds, LogInEnum logInEnum){
		// 不用单独踢APP了
//		for (Integer archiveId : targetIds) {
//			adminAppRefreshUserMapper.addAppRefreshUser(archiveId, logInEnum.getValue());
//		}
	}
	
	/**
	 * 发送socket通知消息
	 * @author 张宏利
	 * @since 2017年11月6日
	 * @param funUserMessage
	 */
	private static void sendSocketMessage(List<AdminFunUserMessage> funUserMessageList){
		try {
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("userList", JSON.toJSONString(funUserMessageList));
			HttpUtil.post(AppConfig.getSocketWebUrl() + "/socket/sendMessageList", paramMap);
			System.out.println(AppConfig.getSocketWebUrl() + "/socket/sendMessageList: " + JSON.toJSONString(funUserMessageList));
		} catch (Exception e) {
			logger.error("sendSocketMessage:" + e.getMessage());
		}
	}
}


package com.myfun.repository.jms;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.myfun.service.jms.bean.UpdateFunUserMessage;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ScheduledMessage;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.myfun.framework.config.AppConfig;
import com.myfun.repository.admindb.po.AdminJmsMessage;
import com.myfun.repository.support.constant.Const;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.StringUtil;

public class JmsPublisher {
	private transient static final Logger logger = LoggerFactory.getLogger(JmsPublisher.class.getName());
	public static String connectionURI = AppConfig.getProperty("common.jmsConfig.produce.url");
	public static String destinationName = AppConfig.getProperty("common.jmsConfig.destinationRootName");
	public static String jmsDelayPayName = AppConfig.getProperty("common.jmsConfig.jmsDelayPayName");
	public static String jmsBuySoftName = AppConfig.getProperty("common.jmsConfig.jmsBuySoftName");
	public static String jmsUserManageName = AppConfig.getProperty("common.jmsConfig.jmsUserManageName");
	public static String jmsRunScoreName = AppConfig.getProperty("common.jmsConfig.jmsRunScoreName");
	
	/** 消息内容队列，所有的消息存在这，等单独的线程扫描并处理 */
	public static LinkedBlockingQueue<AdminJmsMessage> jmsMessageQueue = new LinkedBlockingQueue<>();
	/** 达到多少未消费数据时预警，不宜设置小了，不然邮件有点多 **/
	public static long maxMessage = 50000;//
	public static Date lastSendTime = new Date();//
	
	static {
		// 单独发送消息的线程，如果JMS服务器挂了会被阻塞
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					// 创建AMQ
					ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(connectionURI);
					Connection connection = factory.createConnection();
					connection.start();
					Session jmsSession = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
					MessageProducer rootProducer = createDestination(destinationName, jmsSession);
					MessageProducer buySoftProducer = createDestination(jmsBuySoftName, jmsSession);
					MessageProducer delayPayProducer = createDestination(jmsDelayPayName, jmsSession);
					MessageProducer userManageProducer = createDestination(jmsUserManageName, jmsSession);
					MessageProducer runScoreProducer = createDestination(jmsRunScoreName, jmsSession);
					// take()是阻塞的，没有消息时线程挂起
					while(true){
						try {
							AdminJmsMessage adminJmsMessage = jmsMessageQueue.take();
							TextMessage createTextMessage = jmsSession.createTextMessage(JSON.toJSONString(adminJmsMessage));
							if(null != adminJmsMessage.getDelaySeconds()) {
								createTextMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, 1000 * Long.valueOf(adminJmsMessage.getDelaySeconds()));
							}
							if(Constants_DIC.DIC_JMS_SEND_PRODUCER_1.equals(adminJmsMessage.getSendProducer())) {
								rootProducer.send(createTextMessage);
							} else if(Constants_DIC.DIC_JMS_SEND_PRODUCER_2.equals(adminJmsMessage.getSendProducer())) {
								buySoftProducer.send(createTextMessage);
							} else if(Constants_DIC.DIC_JMS_SEND_PRODUCER_3.equals(adminJmsMessage.getSendProducer())) {
								delayPayProducer.send(createTextMessage);
							} else if(Constants_DIC.DIC_JMS_SEND_PRODUCER_4.equals(adminJmsMessage.getSendProducer())) {
								userManageProducer.send(createTextMessage);
							} else if(Constants_DIC.DIC_JMS_SEND_PRODUCER_5.equals(adminJmsMessage.getSendProducer())) {
								runScoreProducer.send(createTextMessage);
							} else {
								rootProducer.send(createTextMessage);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, "jmsSenderThread").start();
	}
	
	public static MessageProducer createDestination(String destinationName, Session jmsSession) throws Exception {
		if(StringUtils.isBlank(destinationName)) {
			return null;
		}
		Destination destination = jmsSession.createQueue(destinationName);
		MessageProducer jmsProducer = jmsSession.createProducer(destination);
		jmsProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
		return jmsProducer;
	}
	
	
	/**
	 * @TODO 添加发送对象到队列
	 * @author lcb
	 * 
	 */
	public static void sendMessage(AdminJmsMessage adminJmsMessage) {
		jmsMessageQueue.add(adminJmsMessage);
		// 每次达到上限时邮件提醒
	}
	
	/**
	 * 审核之后通知消息，因为要延迟发送，所以用jms发送消息
	 * @author 张宏利
	 * @since 2017年11月3日
	 * @param cityId
	 * @param auditId
	 * @param auditSeq
	 * @param auditStatus 审核状态，1=等待审核 2=审核通过 3=审核未通过 4=没有审核人
	 * @param delaySeconds 延迟时间，秒
	 */
	public static void sendJmsMessageForAudit(Integer cityId, Integer auditId, Integer auditSeq,
			Integer auditStatus, Integer delaySeconds) {
		Map<String, Object> content = new HashMap<>();
		content.put("cityId", cityId);
		content.put("auditId", auditId);
		content.put("auditSeq", auditSeq);
		content.put("auditStatus", auditStatus);
		// 组装消息的发送
		AdminJmsMessage adminJmsMessage = new AdminJmsMessage();
		adminJmsMessage.setMsgSource("ERP");
		adminJmsMessage.setAction(JmsMsgAction.AUDIT_TOAST);
		adminJmsMessage.setCreateTime(new Date());
		adminJmsMessage.setCityId(cityId);
		adminJmsMessage.setDelaySeconds(delaySeconds);
		adminJmsMessage.setSendProducer(Constants_DIC.DIC_JMS_SEND_PRODUCER_4);
		adminJmsMessage.setMsgContent(JSON.toJSONString(content));
		JmsPublisher.sendMessage(adminJmsMessage);
	}
	
	/**
	 * 创建审核后发送延迟自动审核
	 * @author 张宏利
	 * @since 2017年11月16日
	 * @param cityId
	 * @param auditId
	 * @param compId
	 * @param limitTime
	 */
	public static void sendJmsMessageForAutoExmain(Integer cityId, Integer auditId, Integer compId, Integer limitTime) {
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("cityId", cityId);
		pMap.put("compId", compId);
		pMap.put("auditId", auditId);
		AdminJmsMessage adminJmsMessage = new AdminJmsMessage();
		adminJmsMessage.setMsgSource("ERP");
		adminJmsMessage.setAction(JmsMsgAction.FUN_CASE_AUTO_ADUIT);
		adminJmsMessage.setCreateTime(new Date());
		adminJmsMessage.setCityId(cityId);
		adminJmsMessage.setSendProducer(Constants_DIC.DIC_JMS_SEND_PRODUCER_1);
		adminJmsMessage.setMsgContent(JSON.toJSONString(pMap));
		if (limitTime > 0) {
			adminJmsMessage.setDelaySeconds(limitTime);
		}
		JmsPublisher.sendMessage(adminJmsMessage);
	}
	
	/**
	 * 审核时推送消息，给移动
	 * @author 方李骥
	 * @since 2017年11月15日
	 * @param cityId
	 * @param auditId
	 */
	public static void sendJmsMessageForPushAudiltMsgToMobile(Integer cityId, Integer auditId) {
		Map<String, Object> content = new HashMap<>();
		content.put("cityId", cityId);
		content.put("auditId", auditId);
		// 组装消息的发送
		AdminJmsMessage adminJmsMessage = new AdminJmsMessage();
		adminJmsMessage.setMsgSource("ERP");
		adminJmsMessage.setAction(JmsMsgAction.SEND_AUDIT_RUNTIME_MSG_TO_MOBILE);
		adminJmsMessage.setCreateTime(new Date());
		adminJmsMessage.setCityId(cityId);
		adminJmsMessage.setSendProducer(Constants_DIC.DIC_JMS_SEND_PRODUCER_4);
		adminJmsMessage.setMsgContent(JSON.toJSONString(content));
		JmsPublisher.sendMessage(adminJmsMessage);
	}
	
	/**
	 * 发送登录消息
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/24
	 * @return 
	 * 
	 */
	public static void sendForLogin(Integer cityId, String userName, Integer archiveId) {
		AdminJmsMessage adminJmsMessage = new AdminJmsMessage();
		adminJmsMessage.setAction(JmsMsgAction.USER_LOGIN);
		adminJmsMessage.setCityId(cityId);
		adminJmsMessage.setCreateTime(new Date());
		adminJmsMessage.setSendProducer(Constants_DIC.DIC_JMS_SEND_PRODUCER_4);
		Map<String, String> msgContent = new HashMap<>();
		msgContent.put("cityId", StringUtil.toString(cityId));
		msgContent.put("userName", userName);
		msgContent.put("archiveId", StringUtil.toString(archiveId));
		adminJmsMessage.setMsgContent(JSON.toJSONString(msgContent));
		sendMessage(adminJmsMessage);
	}
	
	/**
	 * 员工异动相关的jms消息，用于同步相关房客源等数据组织机构
	 * @author 张宏利
	 * @since 2018年5月29日
	 * @param cityId 城市ID
	 * @param userIds 用户ID，多个以英文逗号分隔
	 * @param oldCompId 老的公司ID
	 * @param newCompId 新的公司ID
	 * @param delUserId 被删除的用户ID，员工调店时才需要
	 * @param updateRange 员工调店的时候才传DEPT，其他情况可以不传
	 */
	public static void sendForUpdateUser(Integer cityId, List<Integer> userIds, Integer oldCompId, Integer newCompId, Integer delUserId, String updateRange) {
		Integer[] allChangedUserIdArr = userIds.toArray(new Integer[] {});
		StringBuilder userIdSb = new StringBuilder();
		for (Integer userIdTmp : allChangedUserIdArr) {
			if(userIdSb.length() > 0) {
				userIdSb.append(",");
			}
			userIdSb.append(userIdTmp);
		}

		Map<String, Object> content = new HashMap<>();
		content.put("USER_IDS", userIdSb.toString());
		content.put("UPDATE_RANGE", updateRange);
		content.put("OLD_COMP_ID", oldCompId);
		content.put("NEW_COMP_ID", newCompId);
		content.put("DEL_USER_ID", delUserId);
		// 组装发送jms消息
		AdminJmsMessage adminJmsMessage = new AdminJmsMessage();
		adminJmsMessage.setMsgSource("ERP");
		adminJmsMessage.setAction(JmsMsgAction.UPDATE_AREA_REG_DEPT_GROUP_INFO);
		adminJmsMessage.setCreateTime(new Date());
		adminJmsMessage.setCityId(cityId);
		adminJmsMessage.setSendProducer(Const.DIC_JMS_SEND_PRODUCER_4);
		adminJmsMessage.setMsgContent(JSON.toJSONString(content));
		sendMessage(adminJmsMessage);

	}

	/**
	 * 创建用户时发送消息 异步处理
	 * **/
	public static void sendCreateUserMessage(Integer cityId, Integer userId) {
		AdminJmsMessage adminJmsMessage = new AdminJmsMessage();
		adminJmsMessage.setAction(JmsMsgAction.CREATE_USER_MESSAEG);// createUser
		adminJmsMessage.setCityId(cityId);
		adminJmsMessage.setCreateTime(new Date());
		adminJmsMessage.setSendProducer(Constants_DIC.DIC_JMS_SEND_PRODUCER_4);
		Map<String, Object> msgContent = new HashMap<>();
		msgContent.put("CITY_ID", cityId);
		msgContent.put("USER_ID", userId);
		adminJmsMessage.setMsgContent(JSON.toJSONString(msgContent));
		sendMessage(adminJmsMessage);
	}
}

package com.myfun.service.business.admindb.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.alibaba.fastjson.JSON;
import com.extension.framework.mq.context.MqUtil;
import com.myfun.framework.session.ThreadLocalHelper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpFunStatisticDetail;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.jms.JmsMsgAction;
import com.myfun.repository.jms.JmsPublisher;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.constant.Const.StatisticDetailType;
import com.myfun.service.jms.bean.UpdateFunProfitMessage;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringUtil;
import com.myfun.utils.jms.JmsMsgSource;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminJmsMessageMapper;
import com.myfun.repository.admindb.po.AdminJmsMessage;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminJmsMessageService;

@Service
public class AdminJmsMessageServiceImpl extends AbstractService<AdminJmsMessage, Integer> implements AdminJmsMessageService {
	@Autowired
	private AdminJmsMessageMapper adminJmsMessageMapper;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private MqUtil mqUtil;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminJmsMessageMapper;
	}

	@Override
	public int deleteJmsMsg(Integer msgId) throws Exception {
		if(msgId == null){
			return 0;
		}
		AdminJmsMessage msg = new AdminJmsMessage();
		msg.setJmsId(msgId);
		msg.setIsDel(1);
		msg.setDelTime(new Date());
		return adminJmsMessageMapper.updateByPrimaryKey(msg);
	}

	/**
	 * @tag 审核过后发送消息处理流水
	 * @author 邓永洪
	 * @since 2018/6/15
	 */
	@Override
	public void createProfitDetail(Integer cityId, Map<String, Object> content) {
		try {
			AdminJmsMessage jmsMessage = this.sendJmsMsg("updateProfitDetail", cityId, Const.DIC_JMS_SEND_PRODUCER_4, content, 10);
			// 发送消息给JMS服务器，发送失败不回滚插入的数据
			JmsPublisher.sendMessage(jmsMessage);
		} catch (Exception e) {
			ThreadLocalHelper.addErrorInfoLocal("\nJMS错误：业务逻辑未出错，输出方便调试\n" + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void createProfitDetail(UpdateFunProfitMessage updateFunProfitMessage) {
		updateFunProfitMessage.setQueneName(JmsMsgAction.UPDATE_PROFIT_DETAIL);
		mqUtil.sendMessage(updateFunProfitMessage);
	}

	public AdminJmsMessage sendJmsMsg(String action, Integer cityId, Integer sendProducer, Object msgContent, Integer delaySeconds) {
		AdminJmsMessage jmsMessage = new AdminJmsMessage();
		jmsMessage.setMsgSource(JmsMsgSource.ERP.name());
		jmsMessage.setAction(action);
		jmsMessage.setCreateTime(new Date());
		jmsMessage.setCityId(cityId);
		jmsMessage.setSendProducer(sendProducer);
		jmsMessage.setMsgContent(JSON.toJSONString(msgContent));
		if (null != delaySeconds && delaySeconds > 0) {
			jmsMessage.setDelaySeconds(delaySeconds);
		}
		return jmsMessage;
	}

	@Override
	public void addWorkCount(StatisticDetailType countFieldName, Date creationTime, Integer userId, Integer caseType,
			Integer caseId, String trackId, int countSize,Integer cityId) throws Exception {
		try {
			if (countFieldName == null) {
				return;
			}
			ErpFunUsers funUserPO = erpFunUsersMapper.selectByUserId(cityId, userId);
			
			ErpFunStatisticDetail countInfoPO = new ErpFunStatisticDetail();
			Integer grId = funUserPO.getGrId();
			
			countInfoPO.setCaseType(caseType);
			countInfoPO.setCaseId(caseId);
			countInfoPO.setTrackId(trackId);
			countInfoPO.setArchiveId(funUserPO.getArchiveId());
			countInfoPO.setUserId(funUserPO.getUserId());
			
			countInfoPO.setGrId(grId==null?0:grId);
			countInfoPO.setDeptId(funUserPO.getDeptId());
			countInfoPO.setRegId(funUserPO.getRegId());
			countInfoPO.setAreaId(funUserPO.getAreaId());
			countInfoPO.setCompId(funUserPO.getCompId());
			countInfoPO.setCityId(funUserPO.getCityId().intValue());
			countInfoPO.setStatisticType(Integer.valueOf(countFieldName.toString()));
			countInfoPO.setCreateTime(creationTime);
			Map<String, String> content = BeanUtil.objToMap(countInfoPO);
			Map<String, String> messageContent = new HashMap<>();
			content.forEach((key, value) -> {
				messageContent.put(BeanUtil.camelToUnderline(key), value);
			});
			AdminJmsMessage jmsMessage = new AdminJmsMessage();
			// 扩展字段，增加哪一个工作量，和数据库表字段名一致
			messageContent.put("COUNT_FIELD_NAME", countFieldName.name());
			// 增加的量，大于1时caseId是个数组[12,56,46]
			messageContent.put("COUNT_SIZE", String.valueOf(countSize));
			messageContent.put("CREATE_TIME", DateTimeHelper.formatDatetoString(creationTime));
			jmsMessage.setMsgSource(JmsMsgSource.ERP.name());
			jmsMessage.setAction(JmsMsgAction.ADD_WORK_COUNT);
			jmsMessage.setCreateTime(new Date());
			jmsMessage.setCityId(cityId);
			jmsMessage.setSendProducer(Constants_DIC.DIC_JMS_SEND_PRODUCER_1);
			jmsMessage.setMsgContent(JSON.toJSONString(messageContent));
			
			// 发送消息给JMS服务器，发送失败不回滚插入的数据
			JmsPublisher.sendMessage(jmsMessage);
		} catch (Exception e) {
			ThreadLocalHelper.addErrorInfoLocal("\nJMS错误：业务逻辑未出错，输出方便调试\n" + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void createCountScoreData(Integer cityId, Integer userId, String scoreType, Integer caseType,
			Integer caseId) throws Exception {
		try {
			if (cityId==null||userId==null||StringUtils.isBlank(scoreType)) {
				return;
			}
			Map<String, String> content = new HashMap<String, String>();
			content.put("cityId", cityId.toString());
			content.put("userId", userId.toString());
			content.put("scoreType", scoreType);
			content.put("caseType", caseType.toString());
			content.put("caseId", caseId.toString());
			
			AdminJmsMessage jmsMessage = new AdminJmsMessage();
			jmsMessage.setMsgSource(JmsMsgSource.ERP.name());
			jmsMessage.setAction(JmsMsgAction.COUNT_SCORE);
			jmsMessage.setCreateTime(new Date());
			jmsMessage.setCityId(cityId);
			jmsMessage.setSendProducer(Constants_DIC.DIC_JMS_SEND_PRODUCER_5);
			jmsMessage.setMsgContent(JSON.toJSONString(content));
			
			// 发送消息给JMS服务器，发送失败不回滚插入的数据
			JmsPublisher.sendMessage(jmsMessage);
		} catch (Exception e) {
			ThreadLocalHelper.addErrorInfoLocal("\nJMS错误：业务逻辑未出错，输出方便调试\n" + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
}

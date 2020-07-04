package com.myfun.service.business.admindb;

import java.util.Date;
import java.util.Map;

import com.myfun.repository.admindb.po.AdminJmsMessage;
import com.myfun.repository.support.constant.Const.StatisticDetailType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.service.jms.bean.UpdateFunProfitMessage;

public interface AdminJmsMessageService extends BaseMapper<AdminJmsMessage, Integer> {
	
	/**
	 * 标记删除消息
	 * @author 张宏利
	 * @since 2016年2月26日
	 * @return
	 * @throws Exception
	 */
	public int deleteJmsMsg(Integer msgId) throws Exception;

	void createProfitDetail(Integer cityId, Map<String,Object> content);
	AdminJmsMessage sendJmsMsg(String action, Integer cityId, Integer sendProducer, Object msgContent, Integer delaySeconds);

	/**
	 * 增加夺宝币
	 * @author HeWei
	 * @since 2018年7月23日 下午5:20:10
	 * @param countFieldName
	 * @param creationTime
	 * @param userId
	 * @param caseType
	 * @param caseId
	 * @param trackId
	 * @param countSize
	 * @param cityId
	 * @throws Exception
	 * Modified XXX HeWei 2018年7月23日
	 */
	public void addWorkCount(StatisticDetailType countFieldName, Date creationTime, Integer userId, Integer caseType, Integer caseId, String trackId, int countSize,Integer cityId) throws Exception;
	public void createCountScoreData(Integer cityId,Integer userId, String scoreType,Integer caseType,Integer caseId) throws Exception;

	void createProfitDetail(UpdateFunProfitMessage updateFunProfitMessage);
}

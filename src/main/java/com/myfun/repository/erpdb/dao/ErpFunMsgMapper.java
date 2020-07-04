package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunMlTask;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpFunMsg;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpFunMsgExample;
import java.util.List;
import java.util.Map;

@SwitchDB(type=SwitchDBType.COMP_ID)
public interface ErpFunMsgMapper extends BaseMapper<ErpFunMsg, ErpFunMsg> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunMsgExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunMsgExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunMsg> selectByExampleWithBLOBs(ErpFunMsgExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunMsg> selectByExample(ErpFunMsgExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunMsg record, @Param("example") ErpFunMsgExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleWithBLOBs(@Param("record") ErpFunMsg record, @Param("example") ErpFunMsgExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunMsg record, @Param("example") ErpFunMsgExample example);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(ErpFunMsg record);

	void insertBatch(@Param("shardCompId")Integer cityId, @Param("userId")Integer userId, @Param("msg")String msg1);
	
	@SwitchDB(type=SwitchDBType.CITY_ID)
	void insertFunMsg(ErpFunMsg erpFunMsg);
	
	/**
	 * 增加消息
	 * @author 张宏利
	 * @since 2017年11月2日
	 * @param cityId 城市ID
	 * @param compId 公司ID
	 * @param sendUser 发送人
	 * @param msgType 消息类型，消息类型 1=新房联动报备客户，2=抢单小秘书推送,3=退出公司审核失败,4=审核任务没有审核人
	 * @param receiveUser 接收人
	 * @param msgContent 消息内容
	 */
	void createMsg(@Param("shardCompId")Integer cityId, @Param("compId")Integer compId, @Param("sendUser")Integer sendUser, 
			@Param("msgType")Integer msgType, @Param("receiveUser")Integer receiveUser, @Param("msgContent")String msgContent,
			@Param("caseId")Integer caseId, @Param("caseType")Integer caseType);

	List<Map<String,Object>> getFunMsgList(@Param("shardCompId")Integer cityId, @Param("compId")Integer compId,@Param("userId")Integer userId);

	
	/**
	 * 执行存储过程PROC_SYSMSG（FUN_MSG插入数据）
	 * @author ZangTie
	 * @since 2018年7月25日 上午10:55:00
	 * @param cityId
	 * @param userId
	 * @param msgContent
	 * Modified XXX ZangTie 2018年7月25日
	 */
	void createSystemMsg(@Param("shardCityId")Integer cityId, @Param("userId")Integer userId, @Param("msgContent")String msgContent);
    @SwitchDB(type=SwitchDBType.CITY_ID)
    void insertTaskMsgBatch(@Param("shardCityId")Integer cityId, @Param("funMsgList")List<ErpFunMsg> funMsgList);
}

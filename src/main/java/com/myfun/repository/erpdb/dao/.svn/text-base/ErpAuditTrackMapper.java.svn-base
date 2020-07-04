package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpAuditTrack;
import com.myfun.repository.erpdb.po.ErpAuditTrackExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpAuditTrackMapper extends BaseMapper<ErpAuditTrack, ErpAuditTrack> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpAuditTrackExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpAuditTrackExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpAuditTrack> selectByExample(ErpAuditTrackExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpAuditTrack record, @Param("example") ErpAuditTrackExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpAuditTrack record, @Param("example") ErpAuditTrackExample example);

	/**
	 * 写审核跟进
	 * @author 张宏利
	 * @since 2017年10月12日
	 * @param cityId 分库城市ID
	 * @param auditId 运行时模板ID，AUDIT_RUNTIME
	 * @param trackType 跟进类型，0=普通跟进 1=发起申请 2=通过 3=拒绝 4=已撤回 5=已超期
	 * @param trackContent 跟进内容
	 */
	void createAuditTrack(@Param("shardCityId") Integer cityId, @Param("auditId") Integer auditId, @Param("trackUserId") Integer trackUserId, @Param("trackType") Byte trackType, @Param("auditSeq") Integer auditSeq, @Param("trackContent") String trackContent);
	
	/**
	 * 获取审核的跟进列表
	 * @author 张宏利
	 * @since 2017年10月16日
	 * @param cityId
	 * @param auditId
	 * @return
	 */
	List<ErpAuditTrack> getAuditTrackList(@Param("shardCityId") Integer cityId, @Param("auditId")Integer auditId);
}


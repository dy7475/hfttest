package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminFunBuildAuditPush;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.admindb.po.AdminFunBuildAuditPushExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminFunBuildAuditPushMapper extends BaseMapper<AdminFunBuildAuditPush, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminFunBuildAuditPushExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminFunBuildAuditPushExample example);

	/**
	 * @mbggenerated
	 */List<AdminFunBuildAuditPush> selectByExample(AdminFunBuildAuditPushExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") AdminFunBuildAuditPush record,@Param("example") AdminFunBuildAuditPushExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") AdminFunBuildAuditPush record,@Param("example") AdminFunBuildAuditPushExample example);
	 
	 /**
	  * 获取当前推送数据
	  * @author 何传强
	  * @since 2017年6月27日
	  * @param archiveId
	  * @return
	  */
	AdminFunBuildAuditPush getFunBuildAuditPushByArchiveId(Integer archiveId);

}
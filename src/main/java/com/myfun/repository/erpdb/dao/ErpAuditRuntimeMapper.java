package com.myfun.repository.erpdb.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.myfun.erpWeb.managecenter.houseComplain.param.GetHouseComplainListParam;
import org.apache.ibatis.annotations.Param;

import com.myfun.erpWeb.managecenter.sysmanager.param.GetAuditListParam;
import com.myfun.repository.erpdb.dto.ErpAuditRuntimeDto;
import com.myfun.repository.erpdb.po.ErpAuditRuntime;
import com.myfun.repository.erpdb.po.ErpAuditRuntimeExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpAuditRuntimeMapper extends BaseMapper<ErpAuditRuntime, ErpAuditRuntime> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpAuditRuntimeExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpAuditRuntimeExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpAuditRuntime> selectByExample(ErpAuditRuntimeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpAuditRuntime record,
			@Param("example") ErpAuditRuntimeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpAuditRuntime record, @Param("example") ErpAuditRuntimeExample example);

	ErpAuditRuntimeDto selectById(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId, @Param("auditId")Integer auditId);
	
	/**
	 * 通过ID列表获取数据
	 * @author 张宏利
	 * @since 2017年10月20日
	 * @param cityId 城市ID
	 * @param auditIdList ID列表
	 * @return
	 */
	List<ErpAuditRuntime> selectListByIds(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId, @Param("auditIdList") List<Integer> auditIdList);
	
	/**
	 * 获取我发起的审核
	 * @author 张宏利
	 * @since 2017年10月20日
	 * @param cityId 城市ID
	 * @param compId 公司ID
	 * @param userId 用户ID
	 * @param param 
	 * @return
	 */
	List<ErpAuditRuntime> getAuditTaskList(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("param") GetAuditListParam param);
	
	/**
	 * 查看是否已提交查看核心信息申请
	 * @author 张宏利
	 * @since 2017年11月13日
	 * @param cityId
	 * @param compId
	 * @param userId
	 * @param caseType
	 * @param caseId
	 * @return
	 */
	ErpAuditRuntime getHaveAuditByType(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, 
			@Param("userId") Integer userId, @Param("caseId") Integer caseId, @Param("caseType") Integer caseType,
			@Param("auditType") Byte auditType);
	
	/**
	 * 将审核任务失效
	 * @author 张宏利
	 * @since 2017年11月13日
	 * @param cityId
	 * @param compId
	 * @param caseId
	 * @param caseType
	 * @param caseStatus
	 * @param content
	 */
	void cancelAuditTask(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("caseId")Integer caseId, 
			@Param("caseType")Integer caseType, @Param("trackTypes")Byte[] trackTypes, @Param("content")String content);
	
	/**
	 * 获取最后一条审核通过的记录，通过房源信息
	 * @author 张宏利
	 * @since 2017年11月16日
	 * @param cityId
	 * @param compId
	 * @param caseId
	 * @param caseType
	 * @param auditType 
	 * @param startTime 
	 * @return
	 */
	ErpAuditRuntime getLastAuditByCase(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,
			@Param("userId")Integer userId, @Param("caseId")Integer caseId, @Param("caseType")Integer caseType,
			@Param("auditType")Byte auditType, @Param("startTime")Date startTime);

	ErpAuditRuntime getOneClockTimeLeaveOut(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("selfUserId")Integer selfUserId,@Param("startTime")Date startTime);

	List<ErpAuditRuntime> selectComplainList(@Param("shardCityId")Integer cityId, @Param("param") GetHouseComplainListParam param);

}




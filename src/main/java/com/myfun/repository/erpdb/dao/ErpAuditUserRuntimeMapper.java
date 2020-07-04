package com.myfun.repository.erpdb.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.myfun.erpWeb.managecenter.sysmanager.param.GetAuditListParam;
import com.myfun.repository.erpdb.dto.ErpAuditUserRuntimeDto;
import com.myfun.repository.erpdb.po.ErpAuditUserRuntime;
import com.myfun.repository.erpdb.po.ErpAuditUserRuntimeExample;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpAuditUserRuntimeMapper extends BaseMapper<ErpAuditUserRuntime, ErpAuditUserRuntime> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpAuditUserRuntimeExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpAuditUserRuntimeExample example);

	/**
	 * @mbggenerated
	 */List<ErpAuditUserRuntime> selectByExample(ErpAuditUserRuntimeExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpAuditUserRuntime record,@Param("example") ErpAuditUserRuntimeExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpAuditUserRuntime record,@Param("example") ErpAuditUserRuntimeExample example);

	/**
	 * 批量插入审核人
	 * @author 张宏利
	 * @since 2017年10月12日
	 * @param cityId
	 * @param auditUserRuntimeList
	 */
	void insertList(@Param("shardCityId") Integer cityId, @Param("auditUserRuntimeList") List<ErpAuditUserRuntime> auditUserRuntimeList);
	
	/**
	 * 更具用户ID获取审核人
	 * @author 张宏利
	 * @since 2017年10月12日
	 * @param cityId
	 * @param auditId
	 * @param userId 指定用户ID，可不传
	 * @param auditStatus 审核状态
	 * @return
	 */
	List<ErpAuditUserRuntime> selectNowAuditUser(@Param("shardCityId") Integer cityId, @Param("auditId") Integer auditId, @Param("userId") Integer userId, @Param("auditStatus") Integer auditStatus);
	
	/**
	 * 通过IDs更新审核状态
	 * @author 张宏利
	 * @since 2017年10月12日
	 * @param cityId
	 * @param ids
	 * @param auditStatus
	 * @param auditDate 
	 */
	void updateAuditStatusByIds(@Param("shardCityId") Integer cityId, @Param("ids") Set<Integer> ids, @Param("auditStatus") int auditStatus, @Param("trackContent") String trackContent, @Param("auditDate") Date auditDate);
	
	/**
	 * 通过seq更新不在ids列表里面的审核状态
	 * @author 张宏利
	 * @since 2017年10月12日
	 * @param cityId
	 * @param ids
	 * @param auditSeq
	 * @param auditStatus
	 */
	void updateAuditStatusBySeq(@Param("shardCityId")Integer cityId, @Param("auditId") Integer auditId, @Param("ids") Set<Integer> ids, @Param("auditSeq") Integer auditSeq, @Param("auditStatus") Integer auditStatus);
	
	/**
	 * 根据审核类型获取我的审核列表
	 * @author 张宏利
	 * @since 2017年10月20日
	 * @param cityId 城市ID
	 * @param compId 公司ID
	 * @param userId 用户ID
	 * @param auditType 审核类型,1=待我审核 2=我审核的
	 * @param param 
	 * @return
	 */
	List<Integer> getMyAuditList(@Param("shardCityId")Integer cityId, @Param("userId")Integer userId, @Param("auditType")Integer auditType, @Param("param") GetAuditListParam param);
	
	/**
	 * 获取审核人员列表
	 * @author 张宏利
	 * @since 2017年10月27日
	 * @param cityId
	 * @param auditId
	 * @param userId 当前人的ID，会排在前面
	 * @return
	 */
	List<ErpAuditUserRuntimeDto> getUserListByAuditId(@Param("shardCityId")Integer cityId, @Param("auditId")Integer auditId, @Param("userId")Integer userId);
	
	/**
	 * 查询需要处理的审核人信息，解决审核中的审核，角色没有审核人的情况
	 * @author 张宏利
	 * @since 2017年11月14日
	 * @param cityId
	 * @param compId
	 * @param roleId
	 * @return
	 */
	List<ErpAuditUserRuntimeDto> getAuditUserByRole(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("roleId")String roleId);
	
	/**
	 * 删除这个人的所有审批，指定角色审批的，清除userId
	 * @author 张宏利
	 * @since 2017年10月27日
	 * @param cityId
	 * @param auditId
	 * @param userId 当前人的ID，会排在前面
	 * @return
	 */
	void deleteAllAuditByUser(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("userId")Integer userId);
	
	/**
	 * 查询需要处理的审核人信息，解决审核中的审核，角色审核人修改角色
	 * @author 张宏利
	 * @since 2017年11月14日
	 * @param cityId
	 * @param compId
	 * @param userId
	 * @return
	 */
	List<ErpAuditUserRuntimeDto> getAuditUserByUser(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("userId")Integer userId);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<Integer> getAuditUserByMyselfCount(@Param("shardCityId")Integer shardCityId, @Param("userId")Integer auditUserId, @Param("auditStatus")Integer auditStatus, @Param("startTime")String startTime, @Param("nowDate")String nowDate);

	@AccessReadonlyDb
	int getAuditCount(@Param("shardCityId")Integer cityId,@Param("userId") Integer userId,@Param("time1") String time1,@Param("time2") String time2);

	List<ErpAuditUserRuntime> selectUserByAuditId(@Param("shardCityId")Integer cityId, @Param("auditIds")List<Integer> auditIds);

	List<ErpAuditUserRuntimeDto> getThisUserAsOrgManagerAuditList(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId, @Param("userId")Integer userId);
}



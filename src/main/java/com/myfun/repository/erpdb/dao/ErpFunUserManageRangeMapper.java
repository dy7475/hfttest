package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.param.ErpPerformanceAssessmentCountParam;
import com.myfun.repository.erpdb.po.ErpFunUserManageRange;
import com.myfun.repository.erpdb.po.ErpFunUserManageRangeExample;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Update;

public interface ErpFunUserManageRangeMapper extends BaseMapper<ErpFunUserManageRange, ErpFunUserManageRange> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpFunUserManageRangeExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunUserManageRangeExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunUserManageRange> selectByExample(ErpFunUserManageRangeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunUserManageRange record,
			@Param("example") ErpFunUserManageRangeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunUserManageRange record,
			@Param("example") ErpFunUserManageRangeExample example);

	/**
	 * 通过userId获取管理范围列表
	 * @author 张宏�?
	 * @since 2017�?11�?1�?
	 * @param cityId 城市ID
	 * @param userIds 用户ID
	 * @return
	 */
	List<ErpFunUserManageRange> getListByUserId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("userIds") Set<Integer> userIds, @Param("manageType") Integer manageType);
	
	/**
	 * 通过用户ID删除管理范围
	 * @author 张宏�?
	 * @since 2017�?11�?1�?
	 * @param cityId
	 * @param userId
	 */
	void deleteByUserId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("userId")Integer userId);
	
	/**
	 * 插入列表
	 * @author 张宏�?
	 * @since 2017�?11�?1�?
	 * @param cityId
	 * @param rangeList
	 */
	void insertList(@Param("shardCityId")Integer cityId, @Param("rangeList")List<ErpFunUserManageRange> rangeList);
	
	/**
	 * 依据层级找到上一层领�?
	 * @author 张宏�?
	 * @since 2017�?11�?1�?
	 * @param cityId 城市ID
	 * @param compId 公司ID
	 * @param roleId 角色ID
	 * @param areaId 大区ID
	 * @param regId 片区ID
	 * @param deptId 门店ID
	 * @param grId 分组ID
	 * @return
	 */
	Integer getManageUserByUp(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("roleId") String roleId, @Param("areaId")Integer areaId, 
			@Param("regId")Integer regId, @Param("deptId")Integer deptId, @Param("grId")Integer grId);
	
	/**
	 * 获取有权限的用户列表
	 * @author 张宏�?
	 * @since 2017�?11�?1�?
	 * @param cityId 城市ID
	 * @param compId 公司ID
	 * @param roleId 角色ID
	 * @param areaId 大区ID
	 * @param regId 片区ID
	 * @param deptId 门店ID
	 * @param grId 分组ID
	 * @return
	 */
	List<Integer> getAllManageRange(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("roleId") String roleId);
	
	/**
	 * 获取有权限的用户列表
	 * @author 张宏�?
	 * @since 2017�?11�?1�?
	 * @param cityId 城市ID
	 * @param compId 公司ID
	 * @param roleId 角色ID
	 * @param areaId 大区ID
	 * @param regId 片区ID
	 * @param deptId 门店ID
	 * @param grId 分组ID
	 * @return
	 */
	List<Integer> getManageUserList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("roleId") String roleId, @Param("areaId")Integer areaId, 
			@Param("regId")Integer regId, @Param("deptId")Integer deptId, @Param("grId")Integer grId);

	List<ErpFunUserManageRange> getUserManageRange(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("userId")Integer userId);

	List<Map<String, Object>> getManageAssessmentDataList(@Param("shardCityId") Integer cityId, @Param("param") ErpPerformanceAssessmentCountParam param, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

	List<ErpFunUserManageRange> selectByCompIdAndUserId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("userId")Integer userId);

	@Update(value="INSERT INTO dbo.FUN_USER_MANAGE_RANGE ( COMP_ID , USER_ID ,ROLE_ID , RANGE_TYPE , RANGE_ID ,CREATION_TIME ,MANAGE_TYPE)VALUES  (#{compId}, #{userId}, 'GENERAL_MANAGER', 1, 0, GETDATE(), 1)")
	@ResultType(Integer.class)
	int initGeneralManagerange(@Param("shardCityId")Short cityId, @Param("userId")Integer userId, @Param("compId")Integer compId);
}


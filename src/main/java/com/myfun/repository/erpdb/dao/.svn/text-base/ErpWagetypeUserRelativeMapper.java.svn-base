package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.dto.ErpWagetypeUserRelativeDto;
import com.myfun.repository.erpdb.po.ErpWagetypeUserRelative;
import com.myfun.repository.erpdb.po.ErpWagetypeUserRelativeExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
@SwitchDB(type=SwitchDBType.CITY_ID)
public interface ErpWagetypeUserRelativeMapper extends BaseMapper<ErpWagetypeUserRelative, ErpWagetypeUserRelative> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpWagetypeUserRelativeExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpWagetypeUserRelativeExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpWagetypeUserRelative> selectByExample(ErpWagetypeUserRelativeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpWagetypeUserRelative record,
			@Param("example") ErpWagetypeUserRelativeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpWagetypeUserRelative record,
			@Param("example") ErpWagetypeUserRelativeExample example);

	List<ErpWagetypeUserRelativeDto> getUserWageTypeList(@Param("shardCityId")Integer cityId,@Param("userIds") Integer[] userIds,@Param("wageTypeId") Integer wageTypeId);

	List<Map<String,Object>> getSalaryPlanByUserId(@Param("shardCityId")Integer cityId,
			@Param("compId")Integer compId, @Param("userId")Integer userId);

	List<Map<String, Object>> getOneSalaryPlanUserList(@Param("shardCityId")Integer cityId,
			@Param("compId")Integer compId, @Param("wageTypeId")Integer wageTypeId, @Param("deptId")Integer deptId, @Param("userRole")String userRole, @Param("startTime")String startTime,@Param("endTime")String endTime);

	List<Map<String, Object>> getUserWageTypeRelativeMap(@Param("shardCityId")Integer cityId,
			@Param("compId")Integer compId, @Param("userId")Integer userId);
	
	List<Map<String, Object>> getUserWageTypeRelativeAndManagePlanMap(@Param("shardCityId")Integer cityId,
			@Param("compId")Integer compId, @Param("wageTypeId")Integer managePlan);
	
	void updateWagetypeUserRelative(@Param("shardCityId")Integer cityId, @Param("wageTypeId")Integer wageTypeId, 
			@Param("compId")Integer compId, @Param("deptId")Integer deptId, @Param("userPosition")String userPosition, @Param("salaryTypeId")Integer salaryTypeId);

	Map<String, Object> getWageTypeDataOFfOffSalaryTypeId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("salaryId")Integer salaryId);

	void deleteWageTypeUserRelativeByRole(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("roleId") String roleId,@Param("performanceType") String performanceType,@Param("managePlan") String managePlan);

	Integer selectWageTypeByWageTypeIdAndUserId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("wagetypeId")Integer wagetypeId, @Param("userId")Integer userId);

	void deleteWageTypeUserRelativeByUserId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("userId")Integer resetUserId, @Param("performanceType")String performanceType,
			@Param("managePlan")String managePlan);

	void updateWagetypeUserRelativeOffUserId(@Param("shardCityId")Integer cityId, @Param("wageTypeId")Integer wageTypeId, 
			@Param("compId")Integer compId, @Param("deptId")Integer deptId, @Param("userId")Integer userId, @Param("salaryTypeId")Integer salaryTypeId);
}


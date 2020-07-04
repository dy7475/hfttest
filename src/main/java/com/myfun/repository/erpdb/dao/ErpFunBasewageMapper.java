package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.dto.ErpFunBasewageDto;
import com.myfun.repository.erpdb.po.ErpFunBasewage;
import com.myfun.repository.erpdb.po.ErpFunBasewageExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunBasewageMapper extends BaseMapper<ErpFunBasewage, ErpFunBasewage> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunBasewageExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunBasewageExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunBasewage> selectByExample(ErpFunBasewageExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunBasewage record,
			@Param("example") ErpFunBasewageExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunBasewage record, @Param("example") ErpFunBasewageExample example);

	List<ErpFunBasewageDto> getUserBasewage(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,
			@Param("deptId") Integer deptId,@Param("userId") Integer userId, @Param("startTime")String startTime,@Param("roleId") String roleId);

	List<ErpFunBasewageDto> getBaseWageList(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("deptId")Integer deptId,@Param("userPosition")String USER_POSITION, @Param("startTime")String startTime, @Param("endTime")String nowTime);
	String getBaseMoneyByUserId(@Param("shardCityId")Integer cityId,@Param("param")Map<String, Object> param);
	
	int resetBasicSalary(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("newDeptId")Integer newDeptId, @Param("userId")Integer userId);
}

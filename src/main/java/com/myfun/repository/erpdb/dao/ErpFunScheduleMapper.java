package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunSchedule;
import com.myfun.repository.erpdb.po.ErpFunScheduleExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunScheduleMapper extends BaseMapper<ErpFunSchedule, ErpFunSchedule> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunScheduleExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunScheduleExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunSchedule> selectByExample(ErpFunScheduleExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunSchedule record,
			@Param("example") ErpFunScheduleExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunSchedule record, @Param("example") ErpFunScheduleExample example);


	/**
	 * @author 周希来
	 * @since 2019年5月27日
	 * @param cityId
	 * @param userId
	 * @param cityId2
	 * @param compId
	 * @param workType
	 * @param caseId
	 * @param caseType
	 * @param runstepId 
	 * @return
	 */
	ErpFunSchedule findByContion(@Param("shardCityId") Integer cityId, @Param("userId")Integer userId,  @Param("compId")Integer compId, @Param("workType") int workType,
			 @Param("caseId")Integer caseId,  @Param("caseType")Integer caseType, @Param("runstepId") Integer runstepId);
	

}
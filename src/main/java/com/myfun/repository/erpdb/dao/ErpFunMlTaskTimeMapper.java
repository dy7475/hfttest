package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunMlTask;
import com.myfun.repository.erpdb.po.ErpFunMlTaskTime;
import com.myfun.repository.erpdb.po.ErpFunMlTaskTimeExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunMlTaskTimeMapper extends BaseMapper<ErpFunMlTaskTime, ErpFunMlTaskTime> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunMlTaskTimeExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunMlTaskTimeExample example);

	/**
	 * @mbggenerated
	 */List<ErpFunMlTaskTime> selectByExample(ErpFunMlTaskTimeExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpFunMlTaskTime record,@Param("example") ErpFunMlTaskTimeExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpFunMlTaskTime record,@Param("example") ErpFunMlTaskTimeExample example);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void  insertBatch(@Param("shardCityId")Integer shardCityId ,@Param("erpFunMlTaskTimeList") List<ErpFunMlTaskTime> erpFunMlTaskTimeList);
}
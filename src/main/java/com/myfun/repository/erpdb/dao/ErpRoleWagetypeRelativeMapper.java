package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpRoleWagetypeRelative;
import com.myfun.repository.erpdb.po.ErpRoleWagetypeRelativeExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ErpRoleWagetypeRelativeMapper extends BaseMapper<ErpRoleWagetypeRelative, ErpRoleWagetypeRelative> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpRoleWagetypeRelativeExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpRoleWagetypeRelativeExample example);

	/**
	 * @mbggenerated
	 */List<ErpRoleWagetypeRelative> selectByExample(ErpRoleWagetypeRelativeExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpRoleWagetypeRelative record,@Param("example") ErpRoleWagetypeRelativeExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpRoleWagetypeRelative record,@Param("example") ErpRoleWagetypeRelativeExample example);

	List<Map<String, Object>> selectBySalaryId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("salaryId")Integer salaryId);

	int countIsUseByWageTypeId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("wageTypeId")Integer wageTypeId);

	void updateById(@Param("shardCityId")Integer cityId, @Param("param")ErpRoleWagetypeRelative erpFunRoleWageWorkcount);

	/**
	 * 可以把方案的id设置为null
	 * @param cityId
	 * @param bRelative
	 * @return
	 */
	int canUpdateFiledIsNull(@Param("shardCityId")Integer cityId,@Param("param")ErpRoleWagetypeRelative relative);
}
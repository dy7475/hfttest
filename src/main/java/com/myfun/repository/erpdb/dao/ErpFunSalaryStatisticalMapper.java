package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunSalaryStatistical;
import com.myfun.repository.erpdb.po.ErpFunSalaryStatisticalExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunSalaryStatisticalMapper extends BaseMapper<ErpFunSalaryStatistical, ErpFunSalaryStatistical> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunSalaryStatisticalExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunSalaryStatisticalExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunSalaryStatistical> selectByExample(ErpFunSalaryStatisticalExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunSalaryStatistical record,
			@Param("example") ErpFunSalaryStatisticalExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunSalaryStatistical record,
			@Param("example") ErpFunSalaryStatisticalExample example);
}
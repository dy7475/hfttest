package com.myfun.repository.admindb.dao;

import com.myfun.erpWeb.common.vo.AdminLoanRateVo;
import com.myfun.repository.admindb.po.AdminLoanRate;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.admindb.po.AdminLoanRateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminLoanRateMapper extends BaseMapper<AdminLoanRate, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminLoanRateExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminLoanRateExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminLoanRate> selectByExample(AdminLoanRateExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminLoanRate record, @Param("example") AdminLoanRateExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminLoanRate record, @Param("example") AdminLoanRateExample example);

	List<AdminLoanRateVo> getLoanRateVoList();
}
package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.dto.AdminJrFinanceInfoDto;
import com.myfun.repository.admindb.param.QueryFinancialListParam;
import com.myfun.repository.admindb.po.AdminJrFinanceInfo;
import com.myfun.repository.admindb.po.AdminJrFinanceInfoExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AdminJrFinanceInfoMapper extends BaseMapper<AdminJrFinanceInfo, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminJrFinanceInfoExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminJrFinanceInfoExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminJrFinanceInfo> selectByExample(AdminJrFinanceInfoExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminJrFinanceInfo record,
			@Param("example") AdminJrFinanceInfoExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminJrFinanceInfo record,
			@Param("example") AdminJrFinanceInfoExample example);

	List<Map<String, Object>> getFinanceRecordList(QueryFinancialListParam param);

    AdminJrFinanceInfoDto getTransferInfoByDealId(@Param("cityId")Integer cityId, @Param("compNo")String compNo,
												  @Param("deptNo")String deptNo, @Param("dealId")Integer dealId);
}
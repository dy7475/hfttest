package com.myfun.repository.reportdb.dao;

import com.myfun.repository.reportdb.po.ReportFunCustDemandSplit1;
import com.myfun.repository.reportdb.po.ReportFunCustDemandSplit1Example;
import com.myfun.repository.reportdb.po.ReportFunCustDemandSplit1Key;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReportFunCustDemandSplit1Mapper extends BaseMapper<ReportFunCustDemandSplit1, ReportFunCustDemandSplit1Key> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ReportFunCustDemandSplit1Example example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ReportFunCustDemandSplit1Example example);

	/**
	 * @mbggenerated
	 */
	List<ReportFunCustDemandSplit1> selectByExample(ReportFunCustDemandSplit1Example example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ReportFunCustDemandSplit1 record,
			@Param("example") ReportFunCustDemandSplit1Example example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ReportFunCustDemandSplit1 record,
			@Param("example") ReportFunCustDemandSplit1Example example);
}
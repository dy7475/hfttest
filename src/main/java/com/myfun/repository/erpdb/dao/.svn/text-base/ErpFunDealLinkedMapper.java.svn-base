package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunDealLinked;
import com.myfun.repository.erpdb.po.ErpFunDealLinkedExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunDealLinkedMapper extends BaseMapper<ErpFunDealLinked, ErpFunDealLinked> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunDealLinkedExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunDealLinkedExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunDealLinked> selectByExample(ErpFunDealLinkedExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunDealLinked record,
			@Param("example") ErpFunDealLinkedExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunDealLinked record, @Param("example") ErpFunDealLinkedExample example);

    ErpFunDealLinked selectByPartnerId(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("partnerId") Integer partnerId);
}
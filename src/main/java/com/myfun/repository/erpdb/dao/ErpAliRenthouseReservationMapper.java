package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.managecenter.alipayReservation.param.GetReservationListParam;
import com.myfun.repository.erpdb.dto.ErpAliRenthouseReservationDto;
import com.myfun.repository.erpdb.po.ErpAliRenthouseReservation;
import com.myfun.repository.erpdb.po.ErpAliRenthouseReservationExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpAliRenthouseReservationMapper extends BaseMapper<ErpAliRenthouseReservation, ErpAliRenthouseReservation> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpAliRenthouseReservationExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpAliRenthouseReservationExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpAliRenthouseReservation> selectByExample(ErpAliRenthouseReservationExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpAliRenthouseReservation record,
			@Param("example") ErpAliRenthouseReservationExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpAliRenthouseReservation record,
			@Param("example") ErpAliRenthouseReservationExample example);

	List<ErpAliRenthouseReservationDto> getReservationList(@Param("shardCityId")Integer cityId, @Param("param")GetReservationListParam param);
	
}
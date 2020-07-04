package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import com.myfun.erpWeb.house.vo.LeasePeRelDto;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpLeasePeopleRelative;
import com.myfun.repository.erpdb.po.ErpLeasePeopleRelativeExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpLeasePeopleRelativeMapper extends BaseMapper<ErpLeasePeopleRelative, ErpLeasePeopleRelative> {
	/**
	 * @mbggenerated
	 */
	int countByExample(ErpLeasePeopleRelativeExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpLeasePeopleRelativeExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpLeasePeopleRelative> selectByExample(ErpLeasePeopleRelativeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpLeasePeopleRelative record,
			@Param("example") ErpLeasePeopleRelativeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpLeasePeopleRelative record,
			@Param("example") ErpLeasePeopleRelativeExample example);

	List<LeasePeRelDto> getListByCaseId(@Param("shardCityId") Integer cityId,
										@Param("compId") Integer compId, @Param("caseId") Integer caseId,
										@Param("isSaleLease") Integer isSaleLease);
	
	public  List<Object> getErpLeasePeopleRelativeListByCaseId(@Param("shardCityId")Integer cityId,@Param("param") Map<String,Object> param);

	public ErpLeasePeopleRelative getErpLeasePeopleRelativeByCaseIdAndHouseType(@Param("shardCityId")Integer cityId,@Param("caseId")Integer caseId,@Param("peopleType")Integer peopleType);
}


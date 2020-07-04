package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import com.myfun.erpWeb.house.vo.SalePeRelDto;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpSalePeopleRelative;
import com.myfun.repository.erpdb.po.ErpSalePeopleRelativeExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpSalePeopleRelativeMapper extends BaseMapper<ErpSalePeopleRelative, ErpSalePeopleRelative> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpSalePeopleRelativeExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpSalePeopleRelativeExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpSalePeopleRelative> selectByExample(ErpSalePeopleRelativeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpSalePeopleRelative record,
			@Param("example") ErpSalePeopleRelativeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpSalePeopleRelative record,
			@Param("example") ErpSalePeopleRelativeExample example);

	List<SalePeRelDto> getListByCaseId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("caseId")Integer caseId, @Param("isSaleLease")Integer isSaleLease);
	
	public List<Object> getErpSalePeopleRelativeListByCaseId(@Param("shardCityId")Integer cityId,@Param("param")Map<String,Object> param);

	public ErpSalePeopleRelative getErpSalePeopleRelativeByCaseIdAndHouseType(@Param("shardCityId")Integer cityId,@Param("caseId")Integer caseId,@Param("peopleType")Integer peopleType);
	
}
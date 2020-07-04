package com.myfun.repository.erpdb.dao;

import java.util.List;

import com.myfun.erpWeb.common.vo.ErpFunSectionVo;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpFunSection;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpFunSectionExample;
@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpFunSectionMapper extends BaseMapper<ErpFunSection, ErpFunSection> {
	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunSectionExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunSectionExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunSection> selectByExample(ErpFunSectionExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunSection record, @Param("example") ErpFunSectionExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunSection record, @Param("example") ErpFunSectionExample example);

	/**
	 * 新增不采用ID自增
	 * @param record
	 */
	int insertDefaultSelective(ErpFunSection record);

	/**
	 * @author 方李骥
	 * @since 2016年9月1日
	 * @param cityId
	 * @param upperCase
	 * @return
	 */
	
	
	List<ErpFunSection> selectSectionListByName(@Param("shardCityId")Short cityId, @Param("sectionName")String sectionName);

	/**
	 * @author 方李骥
	 * @since 2016年9月1日
	 * @param cityId
	 * @param insertModel
	 */
	
	
	void insertErpFunSection(@Param("shardCityId")Short cityId,@Param("insertModel") ErpFunSection insertModel);

    List<ErpFunSectionVo> getRegVoListByCityId(@Param("shardCityId") Integer cityId);

	List<ErpFunSection> getListByRegIdOrSectionId(@Param("shardCityId") Integer cityId,@Param("sectionIdList")List<String> sectionIdList,@Param("regId")Integer regId);
}
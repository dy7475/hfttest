package com.myfun.repository.erpdb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.erpWeb.businesstools.vcard.param.PerEcardsParam;
import com.myfun.repository.erpdb.dto.ErpFunEcardsDto;
import com.myfun.repository.erpdb.po.ErpFunEcards;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.DaoBaseParam;
import com.myfun.repository.erpdb.po.ErpFunEcardsExample;

public interface ErpFunEcardsMapper extends BaseMapper<ErpFunEcards, ErpFunEcards> {
	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunEcardsExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunEcardsExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunEcards> selectByExample(ErpFunEcardsExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunEcards record, @Param("example") ErpFunEcardsExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunEcards record, @Param("example") ErpFunEcardsExample example);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunEcardsDto> getBusinessTooleCardList(@Param("shardCityId")Integer cityId, @Param("conditionModel")DaoBaseParam param);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunEcardsDto> getEcardsLists(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("archiveId")Integer archiveId, @Param("param")PerEcardsParam param);

	/**
	 * 通过主键更新部分字段（编辑电子名片）
	 * @author 臧铁
	 * @param param   erpFunEcards
	 * @since 2017年6月16日
	 * @return
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateById(ErpFunEcards erpFunEcards);
	
	/**
	 * 修改名片公司和角色名称
	 * @author 张宏利
	 * @since 2018年4月25日
	 * @param cityId
	 * @param compId
	 * @param archiveId
	 * @param deptName
	 * @param roleName
	 */
	void updateCompAndRole(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
			@Param("archiveId") Integer archiveId, @Param("deptName") String deptName,
			@Param("roleName") String roleName);

}
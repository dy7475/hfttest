package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.common.vo.OrganizationDefinitionVO;
import com.myfun.erpWeb.common.vo.OrganizationVO;
import com.myfun.erpWeb.statisticalAnalysis.param.GetSelectNmaesParam;
import com.myfun.repository.erpdb.po.ErpFunOrganizationDefinition;
import com.myfun.repository.erpdb.po.ErpFunOrganizationDefinitionExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface ErpFunOrganizationDefinitionMapper extends BaseMapper<ErpFunOrganizationDefinition, ErpFunOrganizationDefinition> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunOrganizationDefinitionExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunOrganizationDefinitionExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunOrganizationDefinition> selectByExample(ErpFunOrganizationDefinitionExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunOrganizationDefinition record,
			@Param("example") ErpFunOrganizationDefinitionExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunOrganizationDefinition record,
			@Param("example") ErpFunOrganizationDefinitionExample example);

	List<OrganizationDefinitionVO> getOrganizationDefinitionList(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId);
	
	List<OrganizationDefinitionVO> getAllOrganizationDefinitionList(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<String> selectDefinitionNameByLevel(@Param("shardCityId")Integer cityId,@Param("param") GetSelectNmaesParam param);

    void updateSetPartnerLevelFlag(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("partnerLevel")Integer partnerLevel);

    @SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunOrganizationDefinition> getCanPubDefinitionList(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("organizationDefinitionId") Integer organizationDefinitionId);

	ErpFunOrganizationDefinition selectOneByExample(ErpFunOrganizationDefinitionExample definitionExample);

	ErpFunOrganizationDefinition getOrganizationDefinitionId(@Param("shardCityId") Integer cityId,  @Param("compId") Integer compId, @Param("defId") Integer organizationDefinitionId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<Map<String, Object>> selectByDefId(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("defId") Integer defId);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunOrganizationDefinition getOrganizationDefinitionByDefId(@Param("shardCityId") Integer cityId,  @Param("compId") Integer compId, @Param("defId") Integer organizationDefinitionId);
	
	/**
	 * 通过用户的organizationId去查用户的层级
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	Integer getUserLevelByOrgId(@Param("shardCityId") Integer cityId,  @Param("compId") Integer compId, @Param("organizationId") Integer organizationId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunOrganizationDefinition> getOrganizationDefinitionByDefIdSet(@Param("shardCityId") Integer cityId,  @Param("compId") Integer compId, @Param("defIds") Set<Integer> defIds);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunOrganizationDefinition getLastDef(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId);

	int getOrgDefinitionIdDescSeq(@Param("shardCityId") Integer cityId,  @Param("compId") Integer compId, @Param("defId") Integer organizationDefinitionId);

	OrganizationDefinitionVO selectOrganizationDefVO(@Param("shardCityId")Integer cityId,  @Param("organizationId") Integer bizId);
}
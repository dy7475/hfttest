package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Set;

import com.myfun.erpWeb.managecenter.sysmanager.vo.GetCompRoleInfoVo;
import com.myfun.repository.erpdb.po.ErpCompRoleOpers;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.cache.CacheStructure;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpCompRoleOpersExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.cache.annotation.Cacheable;

public interface ErpCompRoleOpersMapper extends BaseMapper<ErpCompRoleOpers, ErpCompRoleOpers> {
	
	/**
	 * @mbggenerated
	 */
	int countByExample(ErpCompRoleOpersExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpCompRoleOpersExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpCompRoleOpers> selectByExample(ErpCompRoleOpersExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpCompRoleOpers record,
			@Param("example") ErpCompRoleOpersExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpCompRoleOpers record, @Param("example") ErpCompRoleOpersExample example);

	List<ErpCompRoleOpers> parseQueryColumnForUserOpers(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("roleId")String roleId);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void deleteCompRoleOpersByRegId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("regId")Integer regId);

	List<ErpCompRoleOpers> getCheckedCommonMapOpers(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("column")String column,
													@Param("columnValue") String columnValue, @Param("roleId") String roleId, @Param("operType") Integer operType, @Param("flagList") List<Byte> flagList);


    void insertByDynamicId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,
						   @Param("columnName")String columnName, @Param("columnValue")String columnValue, @Param("roleId")String roleId,
						   @Param("operId")String operId, @Param("operType") Integer operType, @Param("partnerOper") Byte partnerOper);

	void deleteByDynamincId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("roleId")String roleId,
							@Param("columnName")String columnName, @Param("columnValue")String columnValue, @Param("operIds")Set<String> repeatUpdateOperIds, @Param("flagList") List<Byte> flagList);

	void deleteByDynamincId2(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("roleId")String roleId,
							@Param("columnName")String columnName, @Param("columnValue")String columnValue, @Param("operIds")Set<String> repeatUpdateOperIds, @Param("flagList") List<Byte> flagList);

	List<ErpCompRoleOpers> getCompRoleOpersByRoleId(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("roleId") String roleId);

	@Cacheable(value= CacheStructure.hfterpdb_compRoleOpersCache,
			key="'"+CacheStructure.hfterpdb_compRoleOpersCacheByCompId+"'+#p0.compId+'_CITY_ID_'+#p0.shardCityId")
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpCompRoleOpers> getCompRoleOpersByCompId(ErpCompRoleOpers opersParam);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<GetCompRoleInfoVo> getTOP4RoleOpers(@Param("shardCityId")Integer cityId,@Param("roleId") String roleId);

	void insertRoleOper(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("roleId")String roleId, 
			@Param("opers")Set<String> opers, @Param("templateId")Integer templateId);

	void insertRoleOpersByTemplateId(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("roleId") String roleId, @Param("permissionTemplateId") Integer permissionTemplateId);

	List<ErpCompRoleOpers> getQueryColumnForUserOpers(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("permissionTemplateId") Integer permissionTemplateId);

    List<ErpCompRoleOpers> parseQueryColumnOrganizationForUserOpers(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("roleId")String roleId);

	void deleteByDynaminc2NewOrg(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("roleId")String roleId,
							 @Param("organizationId")Integer organizationId, @Param("operIds")List<String> updateOperIdList, @Param("flagList") List<Byte> flagList);

	void deleteByDynamincNewOrg(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("roleId")String roleId,
								@Param("organizationId")Integer organizationId, @Param("operIds")List<String> updateOperIdList, @Param("flagList") List<Byte> flagList);

	void insertByDynamicIdNewOrg(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,
								 @Param("organizationId")Integer organizationId, @Param("organizationDefinitionId")Integer organizationDefinitionId, @Param("roleId")String roleId,
						   @Param("operId")String operId, @Param("operType") Integer operType, @Param("partnerOper") Byte partnerOper);

	/**
	 * 物理删除
	 * @author HuangJiang
	 * @since 2019年4月28日 上午10:15:23
	 * @param shardCityId
	 * @param erpCompId
	 * Modified XXX HuangJiang 2019年4月28日
	 */
	@SwitchDB(type=SwitchDBType.CITY_ID)
	void deleteErpCompRoleOpersByErpCompId(@Param("shardCityId") Integer shardCityId, @Param("erpCompId") Integer erpCompId);


	@SwitchDB(type=SwitchDBType.CITY_ID)
	void insertErpCompRoleOpersNew(@Param("shardCityId") Integer shardCityId, @Param("erpCompId") Integer erpCompId);

	@SwitchDB(type=SwitchDBType.CITY_ID)
	void updateManageOper(@Param("shardCityId") Integer cityId,@Param("erpCompId") Integer erpCompId);

	@SwitchDB(type=SwitchDBType.CITY_ID)
	void deleteOpers(@Param("shardCityId") Integer cityId,@Param("erpCompId")  Integer erpCompId);

	@SwitchDB(type=SwitchDBType.CITY_ID)
	void insertErpCompRoleOpers(@Param("shardCityId") Integer shardCityId, @Param("erpCompId") Integer erpCompId);

	@SwitchDB(type=SwitchDBType.CITY_ID)
	void deleteRoleOpersByCompIdAndRoleNew(@Param("shardCityId") Integer shardCityId, @Param("erpCompId") Integer erpCompId, @Param("roleId") String roleId, @Param("operId") String operId);

	@SwitchDB(type=SwitchDBType.CITY_ID)
	@SelectProvider(type=ErpCompRoleOpersMapper.ErpCompRoleOpersMapperProvider.class, method="deleteRoleOpersByCompIdAndRole")
	void deleteRoleOpersByCompIdAndRole(@Param("shardCityId") Integer shardCityId, @Param("erpCompId") Integer erpCompId, @Param("roleId") String roleId, @Param("operId") String operId);

	static class ErpCompRoleOpersMapperProvider {

		public String deleteRoleOpersByCompIdAndRole (@Param("shardCityId") Integer shardCityId, @Param("erpCompId") Integer erpCompId, @Param("roleId") String roleId, @Param("operId") String operId) {
			StringBuilder sqlSb = new StringBuilder();
			sqlSb.append(" DELETE FROM COMP_ROLE_OPERS ");
			sqlSb.append(" WHERE ROLE_ID = '" + roleId + "' ");
			sqlSb.append(" AND COMP_ID = " + erpCompId + " ");
			sqlSb.append(" AND OPER_ID NOT IN (" + operId + ")");
			return sqlSb.toString();
		}
	}
}
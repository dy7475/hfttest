package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.dto.ErpUserOpersDto;
import com.myfun.repository.erpdb.po.ErpCompRoleOpers;
import com.myfun.repository.erpdb.dto.UserOpOrgInfoDto;
import com.myfun.repository.erpdb.po.ErpUserOpers;
import com.myfun.repository.erpdb.po.ErpUserOpersExample;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.cache.CacheStructure;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.cache.annotation.CacheEvict;

import java.util.List;
import java.util.Map;
import java.util.Set;

@SwitchDB(type=SwitchDBType.COMP_ID)
public interface ErpUserOpersMapper extends BaseMapper<ErpUserOpers, Integer> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpUserOpersExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpUserOpersExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpUserOpers> selectByExample(ErpUserOpersExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpUserOpers record, @Param("example") ErpUserOpersExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpUserOpers record, @Param("example") ErpUserOpersExample example);

	/**
     * 删除权限
     * @param deptId
     * @param compId
     */
	void batchDeleteByCompIdAndDeptId(@Param("shardCityId") Integer cityId, @Param("deptId")Integer deptId, @Param("compId")Integer compId);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void deleteByCompIdAndRoleId(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("roleId")String roleId, @Param("deptIds") Set<Integer> deptIds,
								 @Param("grId") Integer grId, @Param("organizationId") Integer organizationId);
	
	/**
	 * 添加总经理权限
	 * @param cityId 
	 * @param enterCompId
	 * @param softType
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void batchInsertOpers(@Param("shardCityId") short cityId, @Param("compId")String enterCompId, @Param("softType")String softType);
	
	/**
	 * 删除所有公司除总经理以外人员的企业版权限
	 * @param cityId 
	 * @param enterCompId
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void batchDeleteByCompId(@Param("shardCityId") short cityId, @Param("compId") String compId);

	/**
	 * 根据userId删除权限
	 * @param userId
	 * @param userId2
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	@CacheEvict(value =CacheStructure.hfterpdb_userOpersCache,
			key = "'"+CacheStructure.hfterpdb_userOpersCache_map_by_USER_ID+"'+#userId")
	void deleteByUserId(@Param("shardCityId") Integer cityId, @Param("userId") Integer userId);

	/**
	 * 添加角色权限
	 * @param cityId
	 * @param userId
	 * @param deptType 
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void insertUserOpper(@Param("shardCityId") Integer cityId, @Param("userId") Integer userId, @Param("deptType") Integer deptType);

	/**
	 * 永久停用删除权限
	 * @param cityId
	 * @param erpDeptId
	 * @param erpCompId
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void deleteOpersByCompIdAndDeptId(@Param("shardCityId") Integer cityId, @Param("erpDeptId") Integer erpDeptId, @Param("erpCompId") Integer erpCompId);

	/**
	 * 根据权限名称查询某一个人的权限
	 * @author 方李骥
	 * @since 2016年9月2日
	 * @param cityId
	 * @param userId
	 * @param permissionName
	 * @return
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpUserOpers selectPerPermissionByName(@Param("shardCityId")Integer cityId, @Param("userId")Integer userId, @Param("permissionName")String permissionName);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void deleteMgrRegistManager(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,
			@Param("operId")String operId, @Param("roleName")String roleName);
	
	void createByHaveCompRoleOper(@Param("shardCityId")Integer cityId, @Param("userId")Integer userId, @Param("roleId")String roleId, @Param("compId") Integer compId, @Param("columnName") String columnName, @Param("columnValue") Integer columnValue, @Param("flagList") List<Byte> flagList);
	
	void createByNoCompRoleOper(@Param("shardCityId")Integer cityId, @Param("userId")Integer userId,
								@Param("roleId")String roleId, @Param("compType") Byte compType, @Param("commonAdminFlag") Boolean commonAdminFlag);
	
	@SelectProvider(type=AddDefaultPrivilegeProvider.class, method="addDefaultPrivilege")
	void addDefaultPrivilege(@Param("shardCityId")Short cityId,@Param("opersPo") List<ErpUserOpers> opersPo);
	
	/**
	 * 通过userId获取列表数据
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/25
	 * @return
	 *
	 */
	@AccessReadonlyDb
	List<ErpUserOpers> getListById(@Param("shardCityId") Integer cityId,@Param("userId") Integer userId);

	List<ErpUserOpers> getListByRoleId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("roleId")String roleId);

	void mergeUserOpers(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,
						@Param("tmpField") String tmpField,@Param("columnName")String columnName,@Param("columnValue")String columnValue, @Param("roleId")String roleId, @Param("flagList") List<Byte> flagList);

	List<ErpUserOpersDto> getUserOpersList(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,
										   @Param("userId")Integer userId,@Param("roleId") String userPosition);

	@AccessReadonlyDb
	List<ErpUserOpersDto> getUserOpersListByComp(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId, @Param("roleIsList") List<String> roleIsList,
												 @Param("userIdList") List<Integer> userIdList);

	void copyGeneralOperToUser(@Param("shardCityId")Integer cityId,@Param("genealUserId") Integer genealUserId,@Param("userId") Integer userId);

	List<ErpUserOpersDto> getUsersOpers(@Param("shardCityId")Integer cityId,@Param("userId") Integer userId);

	void insertUserOpperByOpers(@Param("shardCityId")Integer cityId,@Param("userId") Integer userId,@Param("opers") Set<ErpCompRoleOpers> opers);

	List<ErpUserOpersDto> getUsersOpersWithOrganization(@Param("shardCityId")Integer cityId,@Param("userId") Integer userId,@Param("needRemoveOpers") List<String> operList );
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateUserOpperDefId(@Param("shardCityId")Integer cityId,@Param("userId") Integer userId);

    public class AddDefaultPrivilegeProvider{
		
		@SuppressWarnings("unchecked")
		public String addDefaultPrivilege(Map<String, Object> param){
			List<ErpUserOpers> opersPo = (List<ErpUserOpers>) param.get("opersPo");
			StringBuilder sb = new StringBuilder();
			sb.append("merge into USER_OPERS dest USING (");
			for (int i = 0; i < opersPo.size(); i++) {
				ErpUserOpers po = opersPo.get(i);
				sb.append(" select " + po.getUserId() + " as USER_ID,'" + po.getOperId() + "' as OPER_ID ");
				if (i + 1 < opersPo.size()) {
					sb.append(" union all ");
				}
			}
			sb.append(") src ON dest.USER_ID = src.USER_ID and dest.OPER_ID = src.OPER_ID ")
			.append("when not matched then insert(USER_ID,OPER_ID) values (src.USER_ID,src.OPER_ID);");
			return sb.toString();
		}
	}
	
	void deleteOldManager(@Param("shardCityId")Integer cityId, @Param("userId")Integer userId,@Param("compId") Integer compId);
	
	/**
	 * 通过用户ID获取有的权限
	 * @author 张宏利
	 * @since 2017年10月24日
	 * @param cityId
	 * @param userId
	 * @param viewLimit 
	 * @return
	 */
	Set<String> getUsersOpersByUserId(@Param("shardCityId")Integer cityId, @Param("userId")Integer userId, @Param("opersArr") String[] opersArr);

	void deleteByRoleId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("tmpField")String tmpField,
						@Param("columnValue")String columnValue, @Param("roleId")String roleId, @Param("deleteOpers")Set<String> deleteOpers);

	void deleteUserOper(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("roleId")String roleId, @Param("deleteOpers")Set<String> deleteOpers);

	void deleteByCompRoleOpers(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("roleId") String roleId);

	void mergeUserOpersNewOrg(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,
						@Param("organizationId") Integer organizationId, @Param("roleId")String roleId, @Param("flagList") List<Byte> flagList);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void deletePartnerOperByNoPartner(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("operId") String operId, @Param("column") String column, @Param("columnVal") String columnVal, @Param("flag") Integer flag);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void deletePartnerOperByNoPartnerNewOrg(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("operId") String operId, @Param("column") String column, @Param("columnVal") String columnVal, @Param("flag") Integer flag);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updatePartnerOperByNoPartnerNewOrg(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("operId") String operId, @Param("column") String column, @Param("columnVal") String columnVal, @Param("flag") Integer flag);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpUserOpers getUserOperByUSerIdOperId(@Param("shardCityId")Integer cityId, @Param("userId")Integer userId, @Param("operId") String operId);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpUserOpersDto> getUserOperByCompGeneralManager(@Param("shardCityId")Integer nowCityId, @Param("compId")Integer nowCompId, @Param("notNeedOpers")List<String> notNeedOpers);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void insertUserOpperNew(@Param("shardCityId") Integer cityId, @Param("userId") Integer userId, @Param("deptType") Integer deptType, @Param("organizationType") Integer organizationType);

	ErpUserOpers getUserOperByUserIdOperIdSwitchLogin(@Param("shardCityId")Integer cityId, @Param("userId")Integer currUserId,@Param("operId") String string);
	
	/**
	 * 获取有某个权限的员工列表
	 * @author HuangJiang
	 * @since 2020年02月12日 13:00
	 * @param cityId 城市ID
	 * @param compId 公司ID
	 * @param operId 权限ID
	 * @return java.util.List<com.myfun.repository.erpdb.dto.UserOpOrgInfoDto>
	 * Modified XXX HuangJiang 2020年02月12日
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<UserOpOrgInfoDto> selectAllUserByOerId(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("operId") String operId);
	
}


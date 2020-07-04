package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Set;

import com.myfun.repository.erpdb.dto.ErpFunOpersDto;
import com.myfun.repository.erpdb.po.ErpCompRoleOpers;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import com.myfun.repository.support.cache.CacheStructure;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpFunOpers;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpFunOpersExample;
import org.springframework.cache.annotation.Cacheable;

@SwitchDB(type = SwitchDBType.COMP_ID)
public interface ErpFunOpersMapper extends BaseMapper<ErpFunOpers, ErpFunOpers> {
	
	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunOpersExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunOpersExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunOpers> selectByExample(ErpFunOpersExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunOpers record, @Param("example") ErpFunOpersExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunOpers record, @Param("example") ErpFunOpersExample example);

	/**
	 * 获取用户的权限信息列表
	 * @author 臧铁
	 * @param userId 用户id
	 * @since 2017年6月27日
	 * @return
	 */
	Set<String> getOpersByUserId(@Param("shardCityId")Integer cityId, @Param("userId")Integer userId);

	/**
	 * 获取用户操作列表
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/20
	 */
	/*@AccessReadonlyDb*/
	List<ErpFunOpers> getFunOpersListById(@Param("shardCityId") Integer cityId, @Param("userId") Integer userId, @Param("mobileApi")Boolean mobileApi);

	ErpFunOpers getModelDataById(@Param("shardCityId") Integer cityId,@Param("operId")String operId);

	@Cacheable(value= CacheStructure.hfterpdb_funOpersCache,
			key="'"+CacheStructure.hfterpdb_funOpersCacheByCityId+"'+#p0")
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunOpers> getOpersList(@Param("shardCityId") Integer cityId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	Set<ErpFunOpersDto> getOpersListByRoleId(@Param("shardCityId")Integer cityId, @Param("roleId")String roleId, @Param("compType")Integer comType,  @Param("operType")Integer operType,
											 @Param("mobileApi")Boolean mobileApi, @Param("flagList") List<Byte> flagList, @Param("newOrganizationType") Boolean newOrganizationType);
	
    /**
     * 员工权限-高级权限说明
     * @author ZangTie
     * @since 2018年7月24日 下午1:55:31
     * @param param
     * @return
     * Modified XXX ZangTie 2018年7月24日
     */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunOpers> getALLAdvanceOperDescription(@Param("shardCityId")Integer cityId);

	
	Set<ErpFunOpersDto> getRoleOpersList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("columnName")String columnName, @Param("columnValue")String columnValue,
										 @Param("roleId")String roleId, @Param("mobileApi")Boolean mobileApi, @Param("flagList") List<Byte> flagList);

	Set<ErpFunOpersDto> getRoleOpersListNewOrg(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,  @Param("organizationId") Integer organizationId,
										 @Param("roleId")String roleId, @Param("mobileApi")Boolean mobileApi, @Param("flagList") List<Byte> flagList);



	List<ErpFunOpersDto> getFunOpersDtoListById(@Param("shardCityId")Integer cityId, @Param("userId")Integer userId, @Param("roleId") String roleId, @Param("mobileApi")Boolean mobileApi, @Param("flagList") List<Byte> flagList);


	Set<ErpFunOpersDto> getOpersListByRoleId2(@Param("shardCityId") Integer cityId, @Param("roleId") String roleId,@Param("operList") Set<String> removeOperId);


	Set<ErpFunOpersDto> getOpersListByRoleId3(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("roleId") String roleId,@Param("operList") Set<String> removeOperId, @Param("mobileApi")Boolean mobileApi);
}
package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpRoleOpers;
import com.myfun.repository.erpdb.po.ErpRoleOpersKey;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.myfun.repository.erpdb.po.ErpRoleOpersExample;

@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpRoleOpersMapper extends BaseMapper<ErpRoleOpers, ErpRoleOpersKey> {
	/**
	 * @mbggenerated
	 */
	int countByExample(ErpRoleOpersExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpRoleOpersExample example);

	/**
	 * @mbggenerated
	 */List<ErpRoleOpers> selectByExample(ErpRoleOpersExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpRoleOpers record,@Param("example") ErpRoleOpersExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpRoleOpers record,@Param("example") ErpRoleOpersExample example);

	List<ErpRoleOpers> getProDataListById(@Param("shardCityId") Integer cityId, @Param("roleId") String roleId);

	List<ErpRoleOpers> getEpDataListById(@Param("shardCityId") Integer cityId, @Param("roleId") String roleId);

	List<ErpRoleOpers> getSmpDataListById(@Param("shardCityId") Integer cityId, @Param("roleId") String roleId);

}
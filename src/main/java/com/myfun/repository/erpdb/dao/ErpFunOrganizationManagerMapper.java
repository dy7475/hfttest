package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.common.vo.OrganizationManagerVO;
import com.myfun.erpWeb.common.vo.OrganizationVO;
import com.myfun.repository.erpdb.po.ErpFunOrganizationManager;
import com.myfun.repository.erpdb.po.ErpFunOrganizationManagerExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunOrganizationManagerMapper extends BaseMapper<ErpFunOrganizationManager, ErpFunOrganizationManager> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunOrganizationManagerExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunOrganizationManagerExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunOrganizationManager> selectByExample(ErpFunOrganizationManagerExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunOrganizationManager record,
			@Param("example") ErpFunOrganizationManagerExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunOrganizationManager record,
			@Param("example") ErpFunOrganizationManagerExample example);

	List<OrganizationManagerVO> getOrganizationManagerList(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("organizationIdList") List<Integer> organizationIdList);

	List<ErpFunOrganizationManager> getManagerListByUserId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("userId")Integer userId);

    int updateCaseInfoType(@Param("shardCityId") Integer cityId, @Param("infoType") Integer organizationBussinessType, @Param("organizationId") Integer organizationId, @Param("compId") Integer compId);

}
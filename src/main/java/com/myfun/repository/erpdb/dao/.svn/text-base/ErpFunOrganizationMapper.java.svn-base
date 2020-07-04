package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.common.vo.GetChildOrganizationCountVO;
import com.myfun.erpWeb.common.vo.OrganizationVO;
import com.myfun.erpWeb.managecenter.profit.vo.ProfiTargetNewOrgVO;
import com.myfun.erpWeb.managecenter.userOpers.vo.ErpOrganizationVO;
import com.myfun.repository.erpdb.po.ErpFunOrganization;
import com.myfun.repository.erpdb.po.ErpFunOrganizationExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.myfun.service.business.erpdb.bean.vo.OrganizationDic;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

public interface ErpFunOrganizationMapper extends BaseMapper<ErpFunOrganization, ErpFunOrganization> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunOrganizationExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunOrganizationExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunOrganization> selectByExample(ErpFunOrganizationExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunOrganization record,
			@Param("example") ErpFunOrganizationExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunOrganization record,
			@Param("example") ErpFunOrganizationExample example);

	/**
	 * @Desc 查询组织机构列表
	 * @Time 2019/11/23
	 * @Author lcb
	 **/
	List<OrganizationVO> getOrganizationList(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("updateTime") String updateTime);

	/**
	 * @desc 查询部门名数量（判重）
	 * @author lzg
	 * @since 2019年11月25日
	 * @param cityId
	 * @param compId
	 * @param organizationName
	 * @return
	 */
	Integer countByEqualOrgName(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("organizationName") String organizationName);

	/**
	 * @desc 添加新组织机构信息
	 * @author lzg
	 * @since 2019年11月26日
	 * @param org
	 * @return
	 */
	Integer insertOrganizationInfo(ErpFunOrganization org);


	List<ErpOrganizationVO> getOrganizationVOs(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("organizationIds")  Set<Integer> organizationIds);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	@MapKey("orgId")
	Map<Integer, OrganizationDic> selectOrganizationMap(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId);


	List<ErpFunOrganization> selectByPartnerIds(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("partnerIds") List<Integer> partnerIds);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunOrganization selectOrgByOrgId(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("organizationId") Integer organizationId);

	/**
	 * 老的机构信息更新为新的机构信息
	 * @Package com.myfun.repository.erpdb.dao 
	 * @author 陈文超   
	 * @date 2020年3月19日 下午3:59:14
	 */
	void updateMoveOrgPath(@Param("shardCityId")Integer cityId, 
							@Param("compId")Integer compId, 
							@Param("newPid")Integer newPid, 
							@Param("moveOrgId")String moveOrgId,
							@Param("moveOrgIdintVal")Integer moveOrgIdintVal, 
							@Param("replaceNewPrefix")String replaceNewPrefix,
							@Param("replaceOldPrefix")String replaceOldPrefix, 
							@Param("partnerId")Integer partnerId,
							@Param("newDeptId")Integer newDeptId,
							@Param("startTime") String startTime,
							@Param("endTime") String endTime,
							@Param("bussinessType") Byte bussinessType);

	void updateOrganizationUserNum(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,  @Param("dealPidList")List<Integer> dealPidList,  @Param("userNum")Integer userNum);

    List<ErpFunOrganization> selectOrgByOrgIds(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("organizationIds") List<Integer> organizationIds);
    List<ErpFunOrganization> selectOneLevelOrganization(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("whereCause")String whereCause,@Param("defId") Integer defId);

	void updateMoveUserNewOrg(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, 
			@Param("organizationPath")String organizationPath, @Param("oldOrgId")Integer oldOrgId,
			@Param("newOrgId")Integer newOrgId, @Param("userId")Integer moveUserId, 
			@Param("archiveId") Integer archiveId, @Param("partnerId")Integer partnerId,
			@Param("startTime") String startTime,@Param("endTime") String endTime,
			@Param("bussinessType") Byte bussinessType);

	ErpFunOrganization selectOneByExample(ErpFunOrganizationExample erpFunOrganizationExample);

    List<ProfiTargetNewOrgVO> selectOrgByOrgPath(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("orgIds") String organizationId);

	List<ErpFunOrganization> selectOrgByOrgWithOrgIds(@Param("shardCityId")Integer cityId, @Param("organizationIds") List<Integer> organizationIds);

	@SwitchDB(type = SwitchDBType.CITY_ID)
    List<ErpFunOrganization> selectOrgInfoByDefAndOrgId(@Param("shardCityId")Integer cityId,@Param("compId") String compId,@Param("defId") Integer defId,@Param("organizationId") Integer organizationId);
	
	//根据组织线和defid查ErpFunOrganization
	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunOrganization selectOrgByTissueLine(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId, @Param("tissueLines") String [] tissueLines, @Param("organizationDefId") Integer organizationDefId);
	

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunOrganization> getAcrossTheCityOrganization(@Param("shardCityId") Integer cityId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<GetChildOrganizationCountVO> getChildOrganizationCount(@Param("shardCityId") Integer cityId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunOrganization hasGreaterThanUpdateTime(@Param("shardCityId") Integer cityId, @Param("updateTime") String updateTime);

    void insertSelectiveNew(ErpFunOrganization organizationByOne);

	void updateByPrimaryKeySelectiveNew(ErpFunOrganization organizationByOne);
	
	//根据orgId查defId
	@SwitchDB(type = SwitchDBType.CITY_ID)
    Integer selectDefIdByOrgId(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("organizationId") Integer organizationId);

	Integer getLatestLevelOrgIdLessthanDefId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("orgIds")List<Integer> orgIds,@Param("operDefId") Integer operDefId);

	ErpFunOrganization selectOrgByOrganizationId(@Param("shardCityId")Integer cityId ,@Param("organizationId")Integer organizationId);

}
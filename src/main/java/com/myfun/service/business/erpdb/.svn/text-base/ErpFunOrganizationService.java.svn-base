package com.myfun.service.business.erpdb;

import java.util.List;
import java.util.Map;

import com.myfun.erpWeb.common.param.AddSubOrganizationParam;
import com.myfun.erpWeb.common.param.DeleteSubOrganizationParam;
import com.myfun.erpWeb.common.param.EditSubOrganizationParam;
import com.myfun.erpWeb.common.param.MoveOrganizationParam;
import com.myfun.erpWeb.common.param.SaveLevelDefinitionListParam;
import com.myfun.erpWeb.common.vo.OrganizationVO;
import com.myfun.erpWeb.statisticalAnalysis.param.GetSelectNmaesParam;
import com.myfun.erpWeb.statisticalAnalysis.param.GetSelectWhereParam;
import com.myfun.repository.erpdb.po.ErpFunOrganization;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.service.business.erpdb.bean.vo.InsertSqlVO;
import com.myfun.service.business.erpdb.bean.vo.MoveOrganizationServiceVO;


public interface ErpFunOrganizationService extends BaseMapper<ErpFunOrganization, ErpFunOrganization> {

	Integer insertOrganizationInfo(AddSubOrganizationParam param,String userName);

	Integer deleteOrgByOrganizationId(DeleteSubOrganizationParam param);

	Integer editOrganizationInfo(EditSubOrganizationParam param);

	Integer insertUpdatePidApplyInfo(MoveOrganizationParam param);

	/**
	 * 组织架构改版拼装insertSQL
	 * @param cityId
	 * @param compId
	 * @return
	 */
	InsertSqlVO createInsertSql(Integer cityId, Integer compId, String orgPath);

	String createUpdateSql(Integer cityId, Integer compId,String path);

	String getSelectWhere(GetSelectWhereParam param);

	String getSelectWhereTwo(GetSelectWhereParam param);

	String getSelectSql(String selectSql,String petName, String prefix);

	public String getSelectNames(GetSelectNmaesParam param);

	public String getConcatNames(String columnNames);

	Integer saveOrganizationDefinitionInfo(SaveLevelDefinitionListParam param);

	MoveOrganizationServiceVO moveOrganization(Integer cityId, Integer compId, Integer userId, Integer organizationId, Integer oldPid,
										Integer newPid);
	/**
	 * 更新调动组织之后的人员调整方法，员工调组织，组织移动都阔以用
	 * @param cityId
	 * @param compId
	 * @param oldPid
	 * @param newPid
	 * @param needUpdateUserCount
	 */
	public void updateAfterMoveOrgUserNum(Integer cityId, Integer compId, Integer oldPid, Integer moveOrgId, Integer newPid,
			Integer needUpdateUserCount, List<OrganizationVO> compOrgList);


	/**
	 *
	 * @param cityId 分库标志
	 * @param compId 当前登录人公司id
	 * @param userId 当前登录人的ID
	 * @param defId orgId类型 -2表示个人 >0为某组织ID
	 * @param orgId 查询指定的组织
	 * @return
	 */
	String getMangeRangeWhereCause(Integer cityId,Integer compId,Integer userId,String aliasName,Integer defId,Integer orgId);

	String getMangeRangePathWhereCause(Integer cityId, Integer compId, Integer userId, String column, String aliasName, Integer defId, Integer orgId);
	
	/**
	 *
	 * @param cityId 分库标志
	 * @param compId 当前登录人公司id
	 * @param userId 当前登录人的ID
	 * @param orgId 查询指定的组织
	 * @return
	 */
	void updateBelongOrgUserCount(Integer cityId,Integer compId,Integer orgId,Integer needUpdateCount);
	
	/**
	 * 
	 * @param cityId 城市id
	 * @param compId 公司id
	 * @param oldOrgInfo 老的组织
	 * @param newOrgInfo 新的组织
	 */
	
	public void updateMoveUserNewOrgCount(Integer cityId, Integer compId, ErpFunOrganization oldOrgInfo, ErpFunOrganization newOrgInfo);

	public Map<String,Integer> moveUserNewOrganization(Integer cityId, Integer compId, Integer selfUserId, Integer moveUserId, Integer oldOrgId, Integer newOrgId ,String createUserName);

	public Integer lookFourLevelOrgId(Map<Integer, OrganizationVO> orgMap, String orgPath);

	/**
	 * 通过组织id判断是否是当前人本组织下的数据
	 * @param cityId
	 * @param compId
	 * @param userOrganizationId
	 * @param caseOrganizationId
	 * @return
	 */
	boolean judgePermissionByOrganizationId(Integer cityId, Integer compId, Integer userOrganizationId, Integer caseOrganizationId);

	public String getSelectSqlTwo(String selectSql,String petName, String prefix);

	void updateFieldStaff(Integer cityId,Integer userId,Integer organizationId,Integer compId);

    void updateOrganizationManager(Integer cityId, Integer compId, Integer organizationId, String userIds);
}


/**
 * @author 方李骥
 * @since 2016年9月2日
 */
package com.myfun.service.business.erpdb;

import java.util.List;
import java.util.Set;

import com.myfun.erpWeb.managecenter.sysmanager.param.OrganizatQueryParam;
import com.myfun.erpWeb.managecenter.userOpers.param.SaveCrossCompOperParam;
import com.myfun.erpWeb.managecenter.userOpers.vo.FunOpersVO;
import com.myfun.framework.session.Operator;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpUserOpers;
import com.myfun.repository.support.mybatis.api.BaseMapper;

/**
 * @author 方李骥
 * @since 2016年9月2日
 */
public interface ErpUserOpersService extends BaseMapper<ErpUserOpers,Integer> {

	/**
	 * @author 方李骥
	 * @since 2016年9月2日
	 * @param cityId
	 * @param userId
	 * @param permissionName
	 * @return
	 */
	Boolean judgePermission(Integer cityId, Integer userId, String permissionName);
	
	public String conditionMixByOperRange(String plateTypeStr, String caseType, Integer cityId, Integer compId, Integer selfUid, Integer selfGrId, Integer compType, String userPosition);
	
	public String conditionMixByOperRangeSub(String infoPlateType, String caseType, Integer cityId, Integer compId, Integer selfUid, Integer selfGrId, Integer compType, String userPosition);
	
	/**
	 * 创建员工时增加权限
	 * @author 张宏利
	 * @since 2017年5月10日
	 * @param erpFunUsers
	 * @param compType 
	 */
	void insertUserOpersByCreateUser(ErpFunUsers erpFunUsers, Byte compType);

	/**
	* 新版组织机构创建员工时增加权限
	* @param null
	* @author zangtie
	* @since 2019/12/10 20:46
	* @return
	**/
	void insertUserOpersByCreateUserNew(ErpFunUsers erpFunUsers, Byte compType);
	
	void setRegistManager(Integer cityId , Integer userId,Integer compId);

	boolean userGetPublicInfoCheckRange(Integer cityId,Integer compId,Integer userId, Integer infoDeptId, Integer infoRegId, Integer infoAreaId, Integer caseType,String areaFlag,Integer selfAreaId,Integer selfRegId,Integer selfDeptId);
	
	/**
	 * 是否拥有自动审核权限
	 * @author 张宏利
	 * @since 2017年10月24日
	 * @return
	 */
	public boolean getViewBizExaminLimit(Integer cityId, Integer compId,Integer caseType, String examName, 
			Integer infoAreaId, Integer infoRegId, Integer infoDeptId, Integer infoGroupId, Integer infoUserId,
			Integer selfAreaId, Integer selfRegId, Integer selfDeptId, Integer selfGroupId, Integer selfUserId);
	
	/**
	 * 判断用户查看核心信息的查看电话限制
	 * @author 方李骥
	 * @since 2017年11月01日
	 * @return
	 */
	public boolean getViewPhoneExaminLimit(Integer cityId, Integer compId, Integer caseGrId, Integer caseDeptId,
			Integer caseRegId, Integer caseAreaId, Integer caseType, Integer selfAreaId, Integer selfRegId, Integer selfDeptId, Integer selfGrId, Integer selfUserId);

	public boolean judgeBranchManager(Integer cityId, Integer compId, Integer deptId, Integer compType, Integer selfDeptId);

	void updateUserOpers(Integer cityId, Integer compId, Integer compType, Integer userId,  String areaFlag, String roleId,
						 Integer userRoleChange, String delOpers, String addOpers, Integer currentUserId, Integer currentDeptId);

	void marketVirtualGeneralProcess(ErpFunUsers funUsers, Integer currentUserId, String oldPosition, String roleId);
	
	
	void updateUserOpers(Integer cityId,Integer compId,List<String> roleIds,Set<String>  deleteOpers,Set<String>  repeatUpdateOperIds,Set<String>  ptOperAdd);

	void updateUserOpersNewOrg(Integer cityId, Integer compId, Integer compType, Integer userId, String areaFlag, String roleId,
							   Integer userRoleChange, String delOpers, List<ErpUserOpers> updateOpersList, Integer currentUserId, Integer currentDeptId, String userName);

	/**
	 * 判断前端传值的组织orgId, 与自己权限判断范围的集合
	 * operId=需要查询的权限名称(例如 MANAGE_ORGANIZATION_CASE_COOPERATE, MGR_OTHER_BIZ_DATA_ORGANIZATION, VIEW_ORGANIZATION_HOUSE_LIST_INFO)
	 * queryOrgId=前端传上来的组织机构ID, 需要和自己的权限范围做判断
	 **/
	OrganizatQueryParam checkOrgIdAndOperNewOrg(Integer cityId, Integer compId, Integer currUserId, Byte caseType, String operId, Integer queryOrgId, boolean isSwitchCompLogin);

	void saveCrossCompOper(SaveCrossCompOperParam param, Operator operator);

	boolean checkOperNewOrg(Integer cityId, Integer compId, Integer currUserId, Integer caseId, Byte caseType, String operId, Integer queryOrgId, boolean isSwitchCompLogin);

	public boolean judgePermissionBySwitchLogin(Integer cityId, Integer userId, String permissionName,boolean isSwitchCompLogin);
}

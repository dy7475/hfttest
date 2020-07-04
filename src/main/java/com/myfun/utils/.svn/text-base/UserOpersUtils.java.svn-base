package com.myfun.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.myfun.repository.erpdb.dto.ErpFunOpersDto;
import com.myfun.repository.erpdb.dto.ErpUserOpersDto;
import com.myfun.repository.erpdb.po.ErpCompRoleOpers;
import com.myfun.repository.erpdb.po.ErpFunOpers;
import org.apache.commons.lang.StringUtils;

import com.myfun.repository.erpdb.po.ErpUserOpers;

public class UserOpersUtils {

	/**
	 * 每次初始化必须要有的权限，默认是不显示出来
	 */
	public static final Set<String> PUBLIC_OPERS = new HashSet<String>();

	/**
	 * 大区权限不显示
	 */
	public static final Set<String> HIDDEN_AREA_OPER = new HashSet<String>();

	/**
	 * 公司没有开放大区的，但是也默认补充大区权限
	 */
	private static final Map<String,String> NO_OPEN_AREA_NEED_AREA_MAP = new HashMap<String,String>();

	/**
	 * 陈文超
	 * A.公房私客制：去掉查看房源电话自动审核权限
	 * B.私房公客制：去掉查看客源电话自动审核权限
	 * C.公房公客制：去掉查看客源源电话自动审核权限、查看房源电话自动审核权限 陈文超
	 */
	public static final Set<String> AUTO_EXAMINE_FUN_SET = new HashSet<String>();
	public static final Set<String> AUTO_EXAMINE_CUST_SET = new HashSet<String>();

	public static final String COMP_ROLE_OPERS_SOURCE_COMP_ID = "SOURCE_COMP_ID";
	public static final String COMP_ROLE_OPERS_AREA_ID = "AREA_ID";
	public static final String COMP_ROLE_OPERS_REG_ID = "REG_ID";
	public static final String COMP_ROLE_OPERS_DEPT_ID = "DEPT_ID";
	public static final String COMP_ROLE_OPERS_GROUP_ID = "GROUP_ID";

	/**查看房源数据权**/
	public static final String [] VIEW_HOUSE_ARRAY = new String[]{"","VIEW_COMP_HOUSE","VIEW_AREA_HOUSE","VIEW_REG_HOUSE","VIEW_DEPT_HOUSE","VIEW_GROUP_HOUSE"};

	/**查看客源数据权**/
	public static final String [] VIEW_CUST_ARRAY = new String[]{"","VIEW_COMP_CUST","VIEW_AREA_CUST","VIEW_REG_CUST","VIEW_DEPT_CUST","VIEW_GROUP_CUST"};

	/**查看客源列表数据权**/
	public static final String [] VIEW_CUST_LIST_ARRAY = new String[]{
		"VIEW_GROUP_CUST_LIST_INFO",
		"VIEW_DEPT_CUST_LIST_INFO",
		"VIEW_REG_CUST_LIST_INFO",
		"VIEW_AREA_CUST_LIST_INFO",
	"VIEW_COMP_CUST_LIST_INFO"};

	/**查看房源列表数据权**/
	public static final String [] VIEW_HOUSE_LIST_ARRAY = new String[]{
		"VIEW_GROUP_HOUSE_LIST_INFO",
		"VIEW_DEPT_HOUSE_LIST_INFO",
		"VIEW_REG_HOUSE_LIST_INFO",
		"VIEW_AREA_HOUSE_LIST_INFO",
		"VIEW_COMP_HOUSE_LIST_INFO"
		};

	//赢销版默认要添加的权限
	static{
		AUTO_EXAMINE_FUN_SET.add("AUTO_EXAM_VIEW_COMP_HOUSE");
		AUTO_EXAMINE_FUN_SET.add("AUTO_EXAM_VIEW_AREA_HOUSE");
		AUTO_EXAMINE_FUN_SET.add("AUTO_EXAM_VIEW_REG_HOUSE");
		AUTO_EXAMINE_FUN_SET.add("AUTO_EXAM_VIEW_DEPT_HOUSE");
		AUTO_EXAMINE_FUN_SET.add("AUTO_EXAM_VIEW_GROUP_HOUSE");

		AUTO_EXAMINE_CUST_SET.add("AUTO_EXAM_VIEW_COMP_CUST");
		AUTO_EXAMINE_CUST_SET.add("AUTO_EXAM_VIEW_AREA_CUST");
		AUTO_EXAMINE_CUST_SET.add("AUTO_EXAM_VIEW_REG_CUST");
		AUTO_EXAMINE_CUST_SET.add("AUTO_EXAM_VIEW_DEPT_CUST");
		AUTO_EXAMINE_CUST_SET.add("AUTO_EXAM_VIEW_GROUP_CUST");

		PUBLIC_OPERS.add("SALE_MANAGE");
		PUBLIC_OPERS.add("LEASE_MANAGE");
		PUBLIC_OPERS.add("BUY_MANAGE");
		PUBLIC_OPERS.add("RENT_MANAGE");

		//当公司没有开放大区时隐藏一下权限
		HIDDEN_AREA_OPER.add("VIEW_AREA_CUST");
		HIDDEN_AREA_OPER.add("EDIT_AREA_CUST");
		HIDDEN_AREA_OPER.add("VIEW_AREA_CUST_LIST_INFO");
		HIDDEN_AREA_OPER.add("AUTO_EXAM_APPLY_AREA_CUST");
		HIDDEN_AREA_OPER.add("AUTO_EXAM_VIEW_AREA_CUST");

		HIDDEN_AREA_OPER.add("VIEW_AREA_HOUSE");
		HIDDEN_AREA_OPER.add("EDIT_AREA_HOUSE");
		HIDDEN_AREA_OPER.add("VIEW_AREA_HOUSE_LIST_INFO");
		HIDDEN_AREA_OPER.add("AUTO_EXAM_APPLY_AREA_HOUSE");
		HIDDEN_AREA_OPER.add("AUTO_EXAM_VIEW_AREA_HOUSE");

		HIDDEN_AREA_OPER.add("BIZ_DATA_EXAMIN_AREA");
		HIDDEN_AREA_OPER.add("BIZ_DATA_VIEW_AREA");
		HIDDEN_AREA_OPER.add("KEY_MANAGE_AREA");
		HIDDEN_AREA_OPER.add("MGR_OTHER_BIZ_DATA_AREA");
		
		HIDDEN_AREA_OPER.add("JOINT_CUSTOMER_AREA_VIEW");
		HIDDEN_AREA_OPER.add("DATA_ANALYSIS_AREA_VIEW");

		HIDDEN_AREA_OPER.add("VIEW_AREA_EXCLUSIVE_ENTRUST");
		HIDDEN_AREA_OPER.add("ATTENDANCE_COUNT_VIEW_AREA");
		HIDDEN_AREA_OPER.add("AREA_CUST_DATA_EXCHANGE");
		HIDDEN_AREA_OPER.add("MANAGE_AREA_CASE_COOPERATE");
		HIDDEN_AREA_OPER.add("AREA_LINK_CUST_DATA_EXCHANGE");
		HIDDEN_AREA_OPER.add("VIEW_AREA_ACCOUNT");
		HIDDEN_AREA_OPER.add("REWARD_PUNISHMENT_INPUT_AREA");
		HIDDEN_AREA_OPER.add("REWARD_PUNISHMENT_AUDIT_AREA");
		HIDDEN_AREA_OPER.add("GENERATION_PAYMENT_INPUT_AREA");
		HIDDEN_AREA_OPER.add("GENERATION_PAYMENT_AUDIT_AREA");
		HIDDEN_AREA_OPER.add("VIEW_AREA_DEPT_FEE");
		HIDDEN_AREA_OPER.add("INPUT_AREA_DEPT_FEE");
		HIDDEN_AREA_OPER.add("AUDIT_AREA_DEPT_FEE");
		HIDDEN_AREA_OPER.add("ATTENDANCE_MANAGER_AREA");
		HIDDEN_AREA_OPER.add("ATTENDANCE_COUNT_MANAGER_AREA");
		HIDDEN_AREA_OPER.add("FUN_WAG_CHECK_AREA");
		HIDDEN_AREA_OPER.add("FUN_WAG_MANAGE_AREA");
		HIDDEN_AREA_OPER.add("MANAGE_AREA_BULLET");
		HIDDEN_AREA_OPER.add("AREA_HOUSE_DATA_EXCHANGE");
		HIDDEN_AREA_OPER.add("MANAGE_AREA_ORGANIZATION");
		HIDDEN_AREA_OPER.add("VIEW_AREA_DEAL");
		HIDDEN_AREA_OPER.add("EMPLOYEE_MANAGE_AREA");

		NO_OPEN_AREA_NEED_AREA_MAP.put("COMP_CUST_DATA_EXCHANGE","AREA_CUST_DATA_EXCHANGE");
		NO_OPEN_AREA_NEED_AREA_MAP.put("COMP_HOUSE_DATA_EXCHANGE","AREA_HOUSE_DATA_EXCHANGE");
		NO_OPEN_AREA_NEED_AREA_MAP.put("COMP_LINK_CUST_DATA_EXCHANGE","AREA_LINK_CUST_DATA_EXCHANGE");
		NO_OPEN_AREA_NEED_AREA_MAP.put("ATTENDANCE_COUNT_MANAGER_COMP","ATTENDANCE_COUNT_MANAGER_AREA");
		NO_OPEN_AREA_NEED_AREA_MAP.put("ATTENDANCE_COUNT_VIEW_COMP","ATTENDANCE_COUNT_VIEW_AREA");
		NO_OPEN_AREA_NEED_AREA_MAP.put("ATTENDANCE_MANAGER_COMP","ATTENDANCE_MANAGER_AREA");
		NO_OPEN_AREA_NEED_AREA_MAP.put("AUDIT_COMP_DEPT_FEE","AUDIT_AREA_DEPT_FEE");
		NO_OPEN_AREA_NEED_AREA_MAP.put("AUTO_EXAM_VIEW_COMP_CUST","AUTO_EXAM_VIEW_AREA_CUST");
		NO_OPEN_AREA_NEED_AREA_MAP.put("AUTO_EXAM_VIEW_COMP_HOUSE","AUTO_EXAM_VIEW_AREA_HOUSE");
		NO_OPEN_AREA_NEED_AREA_MAP.put("BIZ_DATA_EXAMIN_COMP","BIZ_DATA_EXAMIN_AREA");
		NO_OPEN_AREA_NEED_AREA_MAP.put("BIZ_DATA_VIEW_COMP","BIZ_DATA_VIEW_AREA");
		NO_OPEN_AREA_NEED_AREA_MAP.put("DATA_ANALYSIS_COMP_VIEW","DATA_ANALYSIS_AREA_VIEW");
		NO_OPEN_AREA_NEED_AREA_MAP.put("EDIT_COMP_CUST","EDIT_AREA_CUST");
		NO_OPEN_AREA_NEED_AREA_MAP.put("EDIT_COMP_HOUSE","EDIT_AREA_HOUSE");
		NO_OPEN_AREA_NEED_AREA_MAP.put("EMPLOYEE_MANAGE_COMP","EMPLOYEE_MANAGE_AREA");
		NO_OPEN_AREA_NEED_AREA_MAP.put("FUN_WAG_CHECK_COMP","FUN_WAG_CHECK_AREA");
		NO_OPEN_AREA_NEED_AREA_MAP.put("FUN_WAG_MANAGE_COMP","FUN_WAG_MANAGE_AREA");
		NO_OPEN_AREA_NEED_AREA_MAP.put("GENERATION_PAYMENT_AUDIT_COMP","GENERATION_PAYMENT_AUDIT_AREA");
		NO_OPEN_AREA_NEED_AREA_MAP.put("GENERATION_PAYMENT_INPUT_COMP","GENERATION_PAYMENT_INPUT_AREA");
		NO_OPEN_AREA_NEED_AREA_MAP.put("INPUT_COMP_DEPT_FEE","INPUT_AREA_DEPT_FEE");
		NO_OPEN_AREA_NEED_AREA_MAP.put("JOINT_CUSTOMER_COMP_VIEW","JOINT_CUSTOMER_AREA_VIEW");
		NO_OPEN_AREA_NEED_AREA_MAP.put("KEY_MANAGE_COMP","KEY_MANAGE_AREA");
		NO_OPEN_AREA_NEED_AREA_MAP.put("MANAGE_COMP_BULLET","MANAGE_AREA_BULLET");
		NO_OPEN_AREA_NEED_AREA_MAP.put("MANAGE_COMP_CASE_COOPERATE","MANAGE_AREA_CASE_COOPERATE");
		NO_OPEN_AREA_NEED_AREA_MAP.put("MANAGE_COMP_LOAN","MANAGE_AREA_LOAN");
		NO_OPEN_AREA_NEED_AREA_MAP.put("MANAGE_COMP_ORGANIZATION","MANAGE_AREA_ORGANIZATION");
		NO_OPEN_AREA_NEED_AREA_MAP.put("MGR_OTHER_BIZ_DATA_COMP","MGR_OTHER_BIZ_DATA_AREA");
		NO_OPEN_AREA_NEED_AREA_MAP.put("REWARD_PUNISHMENT_AUDIT_COMP","REWARD_PUNISHMENT_AUDIT_AREA");
		NO_OPEN_AREA_NEED_AREA_MAP.put("REWARD_PUNISHMENT_INPUT_COMP","REWARD_PUNISHMENT_INPUT_AREA");
		NO_OPEN_AREA_NEED_AREA_MAP.put("VIEW_COMP_ACCOUNT","VIEW_AREA_ACCOUNT");
		NO_OPEN_AREA_NEED_AREA_MAP.put("VIEW_COMP_CUST","VIEW_AREA_CUST");
		NO_OPEN_AREA_NEED_AREA_MAP.put("VIEW_COMP_CUST_LIST_INFO","VIEW_AREA_CUST_LIST_INFO");
		NO_OPEN_AREA_NEED_AREA_MAP.put("VIEW_COMP_DEAL","VIEW_AREA_DEAL");
		NO_OPEN_AREA_NEED_AREA_MAP.put("VIEW_COMP_DEPT_FEE","VIEW_AREA_DEPT_FEE");
		NO_OPEN_AREA_NEED_AREA_MAP.put("VIEW_COMP_EXCLUSIVE_ENTRUST","VIEW_AREA_EXCLUSIVE_ENTRUST");
		NO_OPEN_AREA_NEED_AREA_MAP.put("VIEW_COMP_HOUSE","VIEW_AREA_HOUSE");
		NO_OPEN_AREA_NEED_AREA_MAP.put("VIEW_COMP_HOUSE_LIST_INFO","VIEW_AREA_HOUSE_LIST_INFO");
		NO_OPEN_AREA_NEED_AREA_MAP.put("VIEW_COMP_RENOVATION_CUSTOMER","VIEW_AREA_RENOVATION_CUSTOMER");
	}

	/**
	 * 如果没有开通大区的公司那么默认还是要加上大区权限只不过不显示出来
	 * @author 陈文超
	 * @date Dec 8, 2015 12:22:18 PM
	 */
	public static void addDefAreaOper(String areaFlag,Set<String> aimOperSet, Set<String> srcOperSet){
		//如果没有开通大区那么默认还是要加一个大区的权限，只不过不显示，标准方便以后扩展
		if(!"1".equals(areaFlag)){
			//值拷贝
			Set<String> copySets = new HashSet<String>();
			copySets.addAll(srcOperSet);
			if(!copySets.isEmpty()){
				for(String operId : copySets){
					String areaOper = UserOpersUtils.NO_OPEN_AREA_NEED_AREA_MAP.get(operId);
					if(StringUtils.isNotBlank(areaOper)){
						aimOperSet.add(areaOper);
					}
				}
			}
		}
	}

	/**
	 * 如果没有开通大区的公司那么默认还是要加上大区权限只不过不显示出来
	 * @author 陈文超
	 * @date Dec 8, 2015 12:22:18 PM
	 */
	public static void addDefAreaOper(String areaFlag,Set<String> aimOperSet, String [] srcOperSet){
		//如果没有开通大区那么默认还是要加一个大区的权限，只不过不显示，标准方便以后扩展
		if(!"1".equals(areaFlag)){
			for(String operId : srcOperSet){
				String areaOper = UserOpersUtils.NO_OPEN_AREA_NEED_AREA_MAP.get(operId);
				if(StringUtils.isNotBlank(areaOper)){
					aimOperSet.add(areaOper);
				}
			}
		}
	}

	/**
	 * 如果没有开通大区的公司那么默认还是要加上大区权限只不过不显示出来
	 * @author 陈文超
	 * @date Dec 8, 2015 12:22:18 PM
	 */
	public static void addDefAreaOper(String areaFlag,Integer aimUserId , List<ErpUserOpers> aimOperList, String [] srcOperSet){
		//如果没有开通大区那么默认还是要加一个大区的权限，只不过不显示，标准方便以后扩展
		if(!"1".equals(areaFlag)){
			for(String operId : srcOperSet){
				String areaOper = UserOpersUtils.NO_OPEN_AREA_NEED_AREA_MAP.get(operId);
				if(StringUtils.isNotBlank(areaOper)){
					ErpUserOpers userOpersPO=new ErpUserOpers();
					userOpersPO.setUserId(aimUserId);
					userOpersPO.setOperId(areaOper);
					aimOperList.add(userOpersPO);
				}
			}
		}
	}

	/**
	 * 移除掉不需要的权限- 以前是隐藏， 根据版本或者角色的不同，有些权限不需要显示出来
	 * @author 陈文超
	 * @date Jan 8, 2016 2:45:18 PM
	 */
	public static void removeHiddenOper(List<ErpUserOpers> aimOpersPOs, Set<String> needHiddenOpers){
		List<ErpUserOpers> removeOpersPOs = new LinkedList<ErpUserOpers>();
		for(String removeOperId : needHiddenOpers){
			for(ErpUserOpers operPo : aimOpersPOs){
				if(removeOperId.equals(operPo.getOperId())){
					removeOpersPOs.add(operPo);
				}
			}
		}
		aimOpersPOs.removeAll(removeOpersPOs);
	}

	/**
	 * 移除掉不需要的权限- 以前是隐藏， 根据版本或者角色的不同，有些权限不需要显示出来
	 * @author 陈文超
	 * @date Jan 8, 2016 2:45:18 PM
	 */
	public static void removeHiddenOpers(Set<ErpFunOpersDto> aimOpersPOs, Set<String> needHiddenOpers){
		if(null == aimOpersPOs || aimOpersPOs.size() <= 0){
			return;
		}
		List<ErpFunOpers> removeOpersPOs = new LinkedList<ErpFunOpers>();
		for(String removeOperId : needHiddenOpers){
			for(ErpFunOpersDto operPo : aimOpersPOs){
				if(removeOperId.equals(operPo.getOperId())){
					removeOpersPOs.add(operPo);
				}
			}
		}
		aimOpersPOs.removeAll(removeOpersPOs);
	}


	public static void removeHiddenOpersNewOrg(Set<ErpCompRoleOpers> aimOpersPOs, Set<String> needHiddenOpers){
		if(null == aimOpersPOs || aimOpersPOs.size() <= 0){
			return;
		}
		List<ErpCompRoleOpers> removeOpersPOs = new LinkedList<ErpCompRoleOpers>();
		for(String removeOperId : needHiddenOpers){
			for(ErpCompRoleOpers operPo : aimOpersPOs){
				if(removeOperId.equals(operPo.getOperId())){
					removeOpersPOs.add(operPo);
				}
			}
		}
		aimOpersPOs.removeAll(removeOpersPOs);
	}

	public static void removeHiddenOpersNewOrg2(Set<ErpUserOpersDto> aimOpersPOs, Set<String> needHiddenOpers){
		if(null == aimOpersPOs || aimOpersPOs.size() <= 0){
			return;
		}
		List<ErpUserOpersDto> removeOpersPOs = new LinkedList<ErpUserOpersDto>();
		for(String removeOperId : needHiddenOpers){
			for(ErpUserOpersDto operPo : aimOpersPOs){
				if(removeOperId.equals(operPo.getOperId())){
					removeOpersPOs.add(operPo);
				}
			}
		}
		aimOpersPOs.removeAll(removeOpersPOs);
	}


	/**
	 * 预先处理一次不需要隐藏的权限，例如被人已经有全公司权限了，此时已经超出了公司参数范围
	 * 已经有的权限就不能被系统参数权限查看范围控制
	 * needHiddenOpers : 
	 * userHaveAvdOpers : 用户已经含有的权限不能删除
	 * @author 陈文超
	 * @date Jan 14, 2016 7:58:07 PM
	 */
	public static void beforeFilterHaveOpers(Set<String> needHiddenOpers, Set<String> userHaveAvdOpers,String areaFlag){
		for(String tmpoper : userHaveAvdOpers){
			// 没开通大区，有大区权限也不显示出来
			if(!"1".equals(areaFlag) && UserOpersUtils.HIDDEN_AREA_OPER.contains(tmpoper)){
				continue;
			}
			needHiddenOpers.remove(tmpoper);
		}
	}

	/**
	 * 不同模式下 角色所具备的权限的实际范围
	 * [0]:查看房源角色的最大允许范围
	 * [1]:查看客源角色的最大允许范围
	 */
	public static String [] sysRunModelRole(String roleId, boolean publicFun, boolean publicCust){
		if(Constants_DIC.DIC_ROLE_NAME_PROPERTY_SERVER.equals(roleId)||
				Constants_DIC.DIC_ROLE_NAME_DEPUTY_MANAGER.equals(roleId)){
			return	new String[]{
					Constants_DIC.DIC_LOOK_RANGE_1,
					Constants_DIC.DIC_LOOK_RANGE_1};
		} else if(Constants_DIC.DIC_ROLE_NAME_PRACTY_BIZ.equals(roleId)){
			return	new String[]{
					Constants_DIC.DIC_LOOK_RANGE_4,
					Constants_DIC.DIC_LOOK_RANGE_4};
		} else {
			if(publicFun && publicCust){//全公盘制
				if(Constants_DIC.DIC_ROLE_NAME_BIZ_GENERAL.equals(roleId)){
					return	new String[]{
							Constants_DIC.DIC_LOOK_RANGE_1,
							Constants_DIC.DIC_LOOK_RANGE_1};
				} else {
					return new String[]{
							Constants_DIC.DIC_LOOK_RANGE_2,
							Constants_DIC.DIC_LOOK_RANGE_3};
				}
			} else if(publicFun){//公房私客
				if(Constants_DIC.DIC_ROLE_NAME_BIZ_GENERAL.equals(roleId)){
					return	new String[]{
							Constants_DIC.DIC_LOOK_RANGE_1,
							Constants_DIC.DIC_LOOK_RANGE_2};
				} else if(Constants_DIC.DIC_ROLE_NAME_REGION_MANAGER.equals(roleId)
						|| Constants_DIC.DIC_ROLE_NAME_CUST_SERVER.equals(roleId)){
					return	new String[]{
							Constants_DIC.DIC_LOOK_RANGE_2,
							Constants_DIC.DIC_LOOK_RANGE_3};
				} else {
					return	new String[]{
							Constants_DIC.DIC_LOOK_RANGE_2,
							Constants_DIC.DIC_LOOK_RANGE_4};
				}
			} else if(publicCust){//公客私房
				if(Constants_DIC.DIC_ROLE_NAME_BIZ_GENERAL.equals(roleId)){
					return	new String[]{
							Constants_DIC.DIC_LOOK_RANGE_1,
							Constants_DIC.DIC_LOOK_RANGE_1};
				} else {
					return	new String[]{
							Constants_DIC.DIC_LOOK_RANGE_2,
							Constants_DIC.DIC_LOOK_RANGE_3};
				}
			} else {//私房私客
				if(Constants_DIC.DIC_ROLE_NAME_BIZ_GENERAL.equals(roleId)){
					return	new String[]{
							Constants_DIC.DIC_LOOK_RANGE_1,
							Constants_DIC.DIC_LOOK_RANGE_2};
				} else if(Constants_DIC.DIC_ROLE_NAME_REGION_MANAGER.equals(roleId)
						|| Constants_DIC.DIC_ROLE_NAME_CUST_SERVER.equals(roleId)){
					return	new String[]{
							Constants_DIC.DIC_LOOK_RANGE_2,
							Constants_DIC.DIC_LOOK_RANGE_3};
				} else {
					return	new String[]{
							Constants_DIC.DIC_LOOK_RANGE_2,
							Constants_DIC.DIC_LOOK_RANGE_4};
				}
			}
		}
	}

	/**
	 * 根据角色和盘别获取房源查看默认权限
	 * @param position 角色
	 * @param runModel 盘别
	 * @return
	 */
	public static Set<String> getViewHouseByPositionAndRunModel(String position, String runModel){
		int index = 0;
		if(Constants_DIC.DIC_ROLE_NAME_GENERAL_MANAGER.equals(position)){
			index = 1;
		}else if(Constants_DIC.DIC_ROLE_NAME_DEPUTY_MANAGER.equals(position)
				||Constants_DIC.DIC_ROLE_NAME_BIZ_GENERAL.equals(position)){
			index = 2;
		}else if(Constants_DIC.DIC_ROLE_NAME_REGION_MANAGER.equals(position)){
			index = 3;
		}else if(Constants_DIC.DIC_ROLE_NAME_BRANCH_MANAGER.equals(position)
				||Constants_DIC.DIC_ROLE_NAME_SECRETARIAL.equals(position)
				||Constants_DIC.DIC_ROLE_NAME_BIZ_MANAGER.equals(position)
				||Constants_DIC.DIC_ROLE_NAME_CUST_SERVER.equals(position)
				||Constants_DIC.DIC_ROLE_NAME_PROPERTY_SERVER.equals(position)
				||Constants_DIC.DIC_ROLE_NAME_COMMON_BIZ.equals(position)){
			index = 4;
		}else if(Constants_DIC.DIC_ROLE_NAME_PRACTY_BIZ.equals(position)){
			return new HashSet<String>();
		} else {
			return new HashSet<String>();
		}
		return getViewHouseAndCustByCaseTypeAndIndex("HOUSE", index);
	}

	/**
	 * 根据角色和盘别获取客源查看默认权限
	 * @param position 角色
	 * @param runModel 盘别
	 * @return
	 */
	public static Set<String> getViewCustByPositionAndRunModel(String position, String runModel){
		int index = 0;
		if(Constants_DIC.DIC_ROLE_NAME_GENERAL_MANAGER.equals(position)){
			index = 1;
		}else if(Constants_DIC.DIC_ROLE_NAME_DEPUTY_MANAGER.equals(position) 
				||Constants_DIC.DIC_ROLE_NAME_BIZ_GENERAL.equals(position)){
			index = 2;
		}else if(Constants_DIC.DIC_ROLE_NAME_REGION_MANAGER.equals(position)){
			index = 3;
		}else if(Constants_DIC.DIC_ROLE_NAME_BRANCH_MANAGER.equals(position) 
				||Constants_DIC.DIC_ROLE_NAME_SECRETARIAL.equals(position)
				||Constants_DIC.DIC_ROLE_NAME_CUST_SERVER.equals(position)
				||Constants_DIC.DIC_ROLE_NAME_PROPERTY_SERVER.equals(position)){
			index = 4;
		}else if(Constants_DIC.DIC_ROLE_NAME_BIZ_MANAGER.equals(position)){
			index = 5;
		}else if(Constants_DIC.DIC_ROLE_NAME_COMMON_BIZ.equals(position)){
			return new HashSet<String>();
		}else if(Constants_DIC.DIC_ROLE_NAME_PRACTY_BIZ.equals(position)){
			return new HashSet<String>();
		} else {
			return new HashSet<String>();
		}
		return getViewHouseAndCustByCaseTypeAndIndex("CUST", index);
	}
	
	/**
	 * 根据角色和盘别获取客源查看默认权限上限
	 * @param position
	 * @param runModel
	 * @return
	 */
	public static int getViewCustIndexByPositionAndRunModel(String position, String runModel){
		int index = 0;
		if(Constants_DIC.DIC_ROLE_NAME_GENERAL_MANAGER.equals(position)){
			index = 1;
		}else if(Constants_DIC.DIC_ROLE_NAME_DEPUTY_MANAGER.equals(position) 
				||Constants_DIC.DIC_ROLE_NAME_BIZ_GENERAL.equals(position)){
			index = 2;
		}else if(Constants_DIC.DIC_ROLE_NAME_REGION_MANAGER.equals(position)){
			index = 3;
		}else if(Constants_DIC.DIC_ROLE_NAME_BRANCH_MANAGER.equals(position) 
				||Constants_DIC.DIC_ROLE_NAME_SECRETARIAL.equals(position)
				||Constants_DIC.DIC_ROLE_NAME_CUST_SERVER.equals(position)
				||Constants_DIC.DIC_ROLE_NAME_PROPERTY_SERVER.equals(position)){
			index = 4;
		}else if(Constants_DIC.DIC_ROLE_NAME_BIZ_MANAGER.equals(position)){
			index = 5;
		}else if(Constants_DIC.DIC_ROLE_NAME_COMMON_BIZ.equals(position)){
		}else if(Constants_DIC.DIC_ROLE_NAME_PRACTY_BIZ.equals(position)){
		}
		return index;
	}
	
	

	/**
	 * 根据权限类型和下标获取对应权限
	 * @param caseType  权限类型 HOUSE 房源 CUST 客源
	 * @param index     下标
	 * @return
	 */
	private static Set<String> getViewHouseAndCustByCaseTypeAndIndex(String caseType, int index){
		Set<String> privilege = new HashSet<String>();
		if("HOUSE".equals(caseType)){
			for(int i=index; i<VIEW_HOUSE_ARRAY.length; i++){
				privilege.add(VIEW_HOUSE_ARRAY[i]);
			}
		}else if("CUST".equals(caseType)){
			for(int i=index; i<VIEW_CUST_ARRAY.length; i++){
				privilege.add(VIEW_CUST_ARRAY[i]);
			}
		}
		return privilege;
	}

//	/**
//	 * 用于控制私盘、抢盘、公盘的数据查询范围
//	 * 将两个Condition合并成一个or连接的条件 并导入 aimCondition 中
//	 * @author 陈文超
//	 * @date Jan 25, 2016 2:07:05 PM
//	 */
//	public static void mergedCondition4OrSysRun(Condition aimCondition,Condition condition1,Condition condition2){
//		if(condition1.size() > 0 && condition2.size() > 0){
//			Condition conditionMix = new Condition();
//			conditionMix.add(condition1);
//			conditionMix.add(Condition.OR,condition2);
//			aimCondition.add(conditionMix);//目标条件
//		}else if(condition1.size() > 0){
//			aimCondition.add(condition1);//目标条件
//		}else if(condition2.size() > 0){
//			aimCondition.add(condition2);//目标条件
//		}
//	}
	
	/**
	 * 根据角色和运行模式获取房客源查看权
	 * @param position
	 * @param runModel
	 * @author jsg
	 * @return
	 */
	public static Set<String> getViewOpersByPositionAndRunModel(String position, String runModel){
		Set<String> houseSet = getViewHouseByPositionAndRunModel(position, runModel);
		Set<String> custSet = getViewCustByPositionAndRunModel(position, runModel);
		houseSet.addAll(custSet);
		return houseSet;
	}

    public static void dealRoleOpersDefId(Integer cityId, Integer compId, Set<ErpFunOpersDto> funOpersPOList) {

    }
}

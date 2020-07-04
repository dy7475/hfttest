package com.myfun.service.business.erpdb.impl;

import com.extension.framework.codis.util.CacheUtil;
import com.myfun.erpWeb.managecenter.profit.WageTypeController;
import com.myfun.erpWeb.managecenter.sysmanager.param.OrganizatQueryParam;
import com.myfun.erpWeb.managecenter.userOpers.param.OpenCityManageParam;
import com.myfun.erpWeb.managecenter.userOpers.param.OperListParam;
import com.myfun.erpWeb.managecenter.userOpers.param.SaveCrossCompOperParam;
import com.myfun.erpWeb.managecenter.userOpers.vo.ErpOrganizationVO;
import com.myfun.erpWeb.managecenter.userOpers.vo.FunOpersVO;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.repository.admindb.dao.AdminAppRefreshUserMapper;
import com.myfun.repository.admindb.dao.AdminFunCompMapper;
import com.myfun.repository.admindb.po.AdminFunComp;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.ErpUserOpersDto;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.cache.CacheStructure;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.mybatis.cache.CacheUtilExt;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunErpUserGuideService;
import com.myfun.service.business.erpdb.*;
import com.myfun.service.jms.TaskQueueThread;
import com.myfun.service.jms.bean.TaskQueueMsg;
import com.myfun.utils.*;

import org.apache.commons.collections.CollectionUtils;
import scala.collection.generic.BitOperations.Int;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 方李骥
 * @since 2016年9月2日
 */
@Service
public class ErpUserOpersServiceImpl extends AbstractService<ErpUserOpers, Integer> implements ErpUserOpersService{
	@Autowired ErpUserOpersMapper erpUserOpersMapper;
	@Autowired
	ErpCompRolesMapper erpCompRolesMapper;
	@Autowired ErpSysParaMapper erpSysParaMapper;
	@Autowired ErpCompRoleOpersMapper erpCompRoleOpersMapper;
	@Autowired ErpFunUsersMapper erpFunUsersMapper;
	@Autowired ErpSysParaService erpSysParaService;
	@Autowired
	ErpFunUsersService erpFunUsersService;
	@Autowired
	AdminAppRefreshUserMapper adminAppRefreshUserMapper;
	@Autowired
	AdminFunErpUserGuideService adminFunErpUserGuideService;
	@Autowired
	ErpSystemSettingLogsService erpSystemSettingLogsService;
	@Autowired
	ErpFunEmployeeLogService erpFunEmployeeLogService;
	@Autowired
	WageTypeController wageTypeController;
	@Autowired
	ErpNoTransactionService erpNoTransactionService;
	@Autowired
	ErpFunRoleWageConfigMapper erpFunRoleWageConfigMapper;
	@Autowired
	ErpSalaryTypeRelativeMapper erpSalaryTypeRelativeMapper;
	@Autowired
	ErpFunWageMapper erpFunWageMapper;
	@Autowired
	ErpFunAssessmentStatisticsMapper erpFunAssessmentStatisticsMapper;
	@Autowired
	ErpMarketVirtualGeneralMapper erpMarketVirtualGeneralMapper;
	@Autowired
	private CacheUtil cacheUtil;
	@Autowired
	private ErpAuditUserTemplateMapper erpAuditUserTemplateMapper;
	@Autowired
	private ErpCompRolesService erpCompRolesService;
	@Autowired
	private ErpFunCompMapper erpFunCompMapper;
	@Autowired
	private AdminFunCompMapper adminFunCompMapper;
	@Autowired
	private ErpFunOrganizationDefinitionMapper erpFunOrganizationDefinitionMapper;
	@Autowired
	private ErpFunOrganizationMapper erpFunOrganizationMapper;
	@Autowired
	private ErpFunUserManageRangeMapper erpFunUserManageRangeMapper;
	@Autowired
	private ErpFunCrossCompStatusMapper erpFunCrossCompStatusMapper;
	@Autowired
	private ErpFunCrossCompUserOperMapper erpFunCrossCompUserOperMapper;
	@Autowired
	private ErpFunCrossCompUserMapper erpFunCrossCompUserMapper;
	@Autowired
	private ErpSystemSettingLogsMapper erpSystemSettingLogsMapper;
	@Autowired
	private ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	private ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	private ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
	@Autowired
	private ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	/**
	 * @author 方李骥
	 * @since 2016年9月2日
	 */
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpUserOpersMapper;
		
	}
	/**
	 * 根据权限名称查询某一个人的权限
	 * @author 方李骥
	 * @since 2016年9月2日
	 * @param cityId
	 * @param userId
	 * @param permissionName
	 * @return
	 */
	@Override
	public Boolean judgePermission(Integer cityId, Integer userId, String permissionName) {
		ErpUserOpers userOpers = erpUserOpersMapper.selectPerPermissionByName(cityId, userId, permissionName);
		if(userOpers!=null){
			return true;
		}
		return false;
	}
	
	public String conditionMixByOperRange(String plateTypeStr, String caseType, Integer cityId, Integer compId, Integer selfUid, Integer selfGrId, Integer compType, String userPosition) {
		boolean limitRange = false;
		if(Constants_DIC.DIC_PLATE_TYPE_PUBLIC_EN.equals(plateTypeStr) || Constants_DIC.DIC_PLATE_TYPE_SHARE_EN.equals(plateTypeStr)){
			if(Constants_DIC.DIC_PLATE_TYPE_PUBLIC_EN.equals(plateTypeStr)) { // 抢盘 public
				if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType) || Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) { // 房源
					limitRange = Constants_DIC.DIC_SHARE_PUBLIC_RANGE_1.equals(erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, selfUid, "PUBLIC_HOUSE_RANGE"));
				}else if(Constants_DIC.DIC_CASE_TYPE_BUY_CUST.equals(caseType) || Constants_DIC.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
					limitRange = Constants_DIC.DIC_SHARE_PUBLIC_RANGE_1.equals(erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, selfUid, "PUBLIC_CUST_RANGE"));
				}
			}else { // 公盘
				// 如果有查看公盘数据权，则不需要判断系统参数
				if(this.judgePermission(cityId, selfUid, "VIEW_SHARE_HOUSE_CUST")) {
					limitRange = true;
				} else {
					if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType) || Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) { // 房源
						limitRange = Constants_DIC.DIC_SHARE_PUBLIC_RANGE_1.equals(erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, selfUid, "SHARE_HOUSE_RANGE"));
					}else if(Constants_DIC.DIC_CASE_TYPE_BUY_CUST.equals(caseType) || Constants_DIC.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
						limitRange = Constants_DIC.DIC_SHARE_PUBLIC_RANGE_1.equals(erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, selfUid,"SHARE_CUST_RANGE"));
					}
				}
			}
		}else{
			if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType) || Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)){
				limitRange = Constants_DIC.DIC_SHARE_PUBLIC_RANGE_1.equals(erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, selfUid,"LOOK_HOUSE_RANGE"));
			}else if(Constants_DIC.DIC_CASE_TYPE_BUY_CUST.equals(caseType) || Constants_DIC.DIC_CASE_TYPE_RENT_CUST.equals(caseType)){
				limitRange = Constants_DIC.DIC_SHARE_PUBLIC_RANGE_1.equals(erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, selfUid,"LOOK_CUST_RANGE"));
			}
		}
		//权限控制全公司的话 就不限制查询出来的数据
		if(limitRange){
			return "COMP";
		}
		return this.conditionMixByOperRangeSub(plateTypeStr, caseType, cityId, compId, selfUid, selfGrId, compType, userPosition);
	}
	
	public String conditionMixByOperRangeSub(String infoPlateType, String caseType, Integer cityId, Integer compId, Integer selfUid, Integer selfGrId, Integer compType, String userPosition) {
		boolean crossUserQuery = false;//查阅本组他人数据权
		boolean crossGroupQuery = false;//查阅本店跨分组数据权
		boolean crossDeptQuery = false;//查阅本片区跨门店数据权
		boolean crossRegQuery = false;//查阅本大区跨大区数据权
		boolean crossAreaQuery = false;//查阅全公司跨大区数据权
		if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType) ||Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)){
			crossAreaQuery = this.judgePermission(cityId, selfUid, "VIEW_COMP_HOUSE_LIST_INFO");// 查阅全公司跨大区数据权
			if(!crossAreaQuery) {
				crossRegQuery = this.judgePermission(cityId, selfUid, "VIEW_AREA_HOUSE_LIST_INFO");// 查阅本大区跨片区数据权
				if(!crossRegQuery) {
					crossDeptQuery = this.judgePermission(cityId, selfUid, "VIEW_REG_HOUSE_LIST_INFO");// 查阅本片区跨门店数据权
					if(!crossDeptQuery) {
						crossGroupQuery = this.judgePermission(cityId, selfUid, "VIEW_DEPT_HOUSE_LIST_INFO");// 查阅本店跨分组数据权
						if(!crossGroupQuery) {
							crossUserQuery = this.judgePermission(cityId, selfUid, "VIEW_GROUP_HOUSE_LIST_INFO");//查阅本组他人数据权
						}
					}
				}
			}
		}else if(Constants_DIC.DIC_CASE_TYPE_BUY_CUST.equals(caseType) ||Constants_DIC.DIC_CASE_TYPE_RENT_CUST.equals(caseType)){
			// 如果没有权限才往下走
			crossAreaQuery = this.judgePermission(cityId, selfUid, "VIEW_COMP_CUST_LIST_INFO");// 查阅全公司跨大区数据权
			if(!crossAreaQuery) {
				crossRegQuery = this.judgePermission(cityId, selfUid, "VIEW_AREA_CUST_LIST_INFO");// 查阅本大区跨片区数据权
				if(!crossRegQuery) {
					crossDeptQuery = this.judgePermission(cityId, selfUid, "VIEW_REG_CUST_LIST_INFO");// 查阅本片区跨门店数据权
					if(!crossDeptQuery) {
						crossGroupQuery = this.judgePermission(cityId, selfUid, "VIEW_DEPT_CUST_LIST_INFO");// 查阅本店跨分组数据权
						if(!crossGroupQuery) {
							crossUserQuery = this.judgePermission(cityId, selfUid, "VIEW_GROUP_CUST_LIST_INFO");//查阅本组他人数据权
						}
					}
				}
			}
		}
		String paramIdHouse = "";
		String paramIdCust = "";
		// 2016-10-17 lcb 参数拆分
		if(Constants_DIC.DIC_PLATE_TYPE_PUBLIC_EN.equals(infoPlateType)){ // 抢盘
			if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType) || Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) { // 房源
				paramIdHouse = "PUBLIC_HOUSE_RANGE";
			}else if(Constants_DIC.DIC_CASE_TYPE_BUY_CUST.equals(caseType) || Constants_DIC.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) { // 客源
				paramIdCust = "PUBLIC_CUST_RANGE";
			}
		}else if(Constants_DIC.DIC_PLATE_TYPE_SHARE_EN.equals(infoPlateType)){ // 公盘
			if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType) || Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) { // 房源
				paramIdHouse = "SHARE_HOUSE_RANGE";
			}else if(Constants_DIC.DIC_CASE_TYPE_BUY_CUST.equals(caseType) || Constants_DIC.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) { // 客源
				paramIdCust = "SHARE_CUST_RANGE";
			}
		}else{
			paramIdHouse = "LOOK_HOUSE_RANGE";
			paramIdCust = "LOOK_CUST_RANGE";
		}
		String lookRange = null;
		if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType) || Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)){
			lookRange = erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, selfUid, paramIdHouse);
		}else if(Constants_DIC.DIC_CASE_TYPE_BUY_CUST.equals(caseType) || Constants_DIC.DIC_CASE_TYPE_RENT_CUST.equals(caseType)){
			lookRange = erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, selfUid, paramIdCust);
		}
		//查询公盘和抢盘范围的数据条件过滤 陈文超
		if(Constants_DIC.DIC_PLATE_TYPE_PUBLIC_EN.equals(infoPlateType)
				|| Constants_DIC.DIC_PLATE_TYPE_SHARE_EN.equals(infoPlateType)){
			if(Constants_DIC.DIC_SHARE_PUBLIC_RANGE_1.equals(lookRange)){
				crossAreaQuery = true;
			}else{
				//大区		公司设定范围是大区列表查看，用户不能有公司查看权时才有效
				if(Constants_DIC.DIC_SHARE_PUBLIC_RANGE_2.equals(lookRange) && !crossAreaQuery){
					crossRegQuery = true;
				//片区		公司设定范围是片区列表查看，用户不能有大区查看权时才有效
				}else if(Constants_DIC.DIC_SHARE_PUBLIC_RANGE_3.equals(lookRange) && !crossRegQuery){
					crossDeptQuery = true;
				//门店		公司设定范围是门店列表查看，用户不能有片区查看权时才有效
				}else if(Constants_DIC.DIC_SHARE_PUBLIC_RANGE_4.equals(lookRange) && !crossDeptQuery){
					crossGroupQuery = true;
				}
			}
		}else{
			if(Constants_DIC.DIC_LOOK_RANGE_1.equals(lookRange)){
				crossAreaQuery = true;
			}else{
				//大区		公司设定范围是大区列表查看，用户不能有公司查看权时才有效
				if(Constants_DIC.DIC_LOOK_RANGE_2.equals(lookRange) && !crossAreaQuery){
					crossRegQuery = true;
				//片区		公司设定范围是片区列表查看，用户不能有大区查看权时才有效
				}else if(Constants_DIC.DIC_LOOK_RANGE_3.equals(lookRange) && !crossRegQuery){
					crossDeptQuery = true;
				//门店		公司设定范围是门店列表查看，用户不能有片区查看权时才有效
				}else if(Constants_DIC.DIC_LOOK_RANGE_4.equals(lookRange) && !crossDeptQuery){
					crossGroupQuery = true;
				}else if(Constants_DIC.DIC_LOOK_RANGE_5.equals(lookRange) && !crossGroupQuery){
					crossUserQuery = true;
				}
			}
		}
		//赢销版的门店经理默认开放查看所有门店的列表数据  陈文超
		if(compType == StringUtil.parseInteger(Constants_DIC.DIC_COMP_TYPE_3, null)
				&& Constants_DIC.DIC_ROLE_NAME_BRANCH_MANAGER.equals(userPosition)){
			crossAreaQuery = true;
		}
		
		String resultRang = "COMP";
		//如果没有全公司的查看权限，则需要过滤范围
		if (!crossAreaQuery) {
			if (crossRegQuery) {
				resultRang = "AREA";
			} else if (crossDeptQuery) {
				resultRang = "REG";
			} else if (crossGroupQuery) {//查阅本店其他分组
				resultRang = "DEPT";
			} else if(crossUserQuery){
				if(!Constants_DIC.DIC_DEFAULT_GROUP_ID.equals(selfGrId)){
					resultRang = "GROUP";
				}else{
					resultRang = "USER";
				}
			}else{
				resultRang = "USER";
			}
		}
		return resultRang;
	}
	
	@Transactional
	@Override
	public void insertUserOpersByCreateUser(ErpFunUsers erpFunUsers, Byte compType) {
		erpUserOpersMapper.deleteByUserId(erpFunUsers.getCityId().intValue(), erpFunUsers.getUserId());
		List<ErpCompRoleOpers> userOpers = erpCompRoleOpersMapper.parseQueryColumnForUserOpers(erpFunUsers.getCityId().intValue(), erpFunUsers.getCompId(), erpFunUsers.getUserPosition());
		boolean croseGroup = false, croseDept = false, croseReg = false, croseArea = false, croseComp = false;
		for (ErpCompRoleOpers oper : userOpers) {
			Integer groupId = oper.getGroupId();
			Integer deptId = oper.getDeptId();
			Integer regId = oper.getRegId();
			Integer areaId = oper.getAreaId();
			Integer sourceCompId = oper.getSourceCompId();
			if(groupId != null && groupId.equals(erpFunUsers.getGrId())) {
				croseGroup = true;
			} else if(deptId != null && deptId.equals(erpFunUsers.getDeptId())) {
				croseDept = true;
			} else if(regId != null && regId.equals(erpFunUsers.getRegId())) {
				croseReg = true;
			} else if(areaId != null && areaId.equals(erpFunUsers.getAreaId())) {
				croseArea = true;
			} else if(sourceCompId != null && sourceCompId.equals(erpFunUsers.getCompId())) {
				croseComp = true;
			}
		}

		String columnName = null;
		Integer columnValue = null;
		if(croseGroup){
			columnName = "GROUP_ID";
			columnValue = erpFunUsers.getGrId();
		} else if( croseDept) {
			columnName = "DEPT_ID";
			columnValue = erpFunUsers.getDeptId();
		} else if(croseReg){
			columnName = "REG_ID";
			columnValue = erpFunUsers.getRegId();
		} else if(croseArea){
			columnName = "AREA_ID";
			columnValue = erpFunUsers.getAreaId();
		} else if(croseComp){
			columnName = "SOURCE_COMP_ID";
			columnValue = erpFunUsers.getCompId();
		}
		
		// story#11307 先判断当前公司是否说开了加盟模式，再判断当前这个人说在哪个组织，总部的就 要总部特殊的权限比如说加盟商管理权， 直营不管，如果说加盟商的人，那么要把特殊的加盟商公告管理权查出来
		List<Byte> flagList =  new ArrayList<Byte>();// 查询通用的权限，1=总部的，2=加盟商的
		flagList.add(Byte.valueOf("0"));
		ErpFunComp erpFunComp = erpFunCompMapper.selectByCompId(erpFunUsers.getCityId().intValue(), erpFunUsers.getCompId());
		if (null != erpFunComp && Byte.valueOf("1").equals(erpFunComp.getOpenPartner())) {
			if (Integer.valueOf(0).equals(erpFunUsers.getPartnerId())) {// 总部
				flagList.add(Byte.valueOf("1"));
				flagList.add(Byte.valueOf("3"));
			} else if (null != erpFunUsers.getPartnerId() && erpFunUsers.getPartnerId() > 0) {// 加盟商
				flagList.add(Byte.valueOf("2"));
			} else {// 加盟商模式下的直营
				flagList.add(Byte.valueOf("3"));
			}
		}
		
		if(columnName != null && columnValue != null) {
			erpUserOpersMapper.createByHaveCompRoleOper(erpFunUsers.getCityId().intValue(), erpFunUsers.getUserId(), erpFunUsers.getUserPosition(), erpFunUsers.getCompId(), columnName, columnValue, flagList);
			//修改跨店登录权限
			erpFunUsersMapper.updateUserAllDeptFlag(erpFunUsers.getCityId(),erpFunUsers.getUserId(),"LOGIN_OTHER_DEPTS",erpFunUsers.getCompId());
			//清理缓存
			erpFunUsersService.evictBaseInfoByCompId(erpFunUsers.getCityId().intValue(),erpFunUsers.getCompId());
		} else {
			//如果是管理员则需要包含高级权限
			if ("COMMON_ADMIN".equals(erpFunUsers.getUserPosition())) {
				erpUserOpersMapper.createByNoCompRoleOper(erpFunUsers.getCityId().intValue(), erpFunUsers.getUserId(), erpFunUsers.getUserPosition(), compType, true);
			} else {
				erpUserOpersMapper.createByNoCompRoleOper(erpFunUsers.getCityId().intValue(), erpFunUsers.getUserId(), erpFunUsers.getUserPosition(), compType, false);
			}
			this.addDefaultPrivilege(erpFunUsers.getCityId(), erpFunUsers.getUserId(), erpFunUsers.getUserPosition(), null);
		}
		if (!"GENERAL_MANAGER".equals(erpFunUsers.getUserPosition())) {
			// 不是总经理就删除投诉审核权
			ErpUserOpersExample erpUserOpersExample = new ErpUserOpersExample();
			erpUserOpersExample.setShardCityId(erpFunUsers.getCityId().intValue());
			erpUserOpersExample.createCriteria().andUserIdEqualTo(erpFunUsers.getUserId()).andOperIdEqualTo("AUDIT_HOUSE_COMPLAINT");
			erpUserOpersMapper.deleteByExample(erpUserOpersExample);
		}
		cacheUtil.del(CacheStructure.hfterpdb_userOpersCache_map_by_USER_ID+erpFunUsers.getUserId()+"_CITY_ID_"+erpFunUsers.getCityId());

	}

	/**
	 * 新版组织机构创建员工时增加权限
	 * @param null
	 * @author zangtie
	 * @since 2019/12/10 20:46
	 * @return
	 **/
	@Transactional
	@Override
	public void insertUserOpersByCreateUserNew(ErpFunUsers erpFunUsers, Byte compType) {
		erpUserOpersMapper.deleteByUserId(erpFunUsers.getCityId().intValue(), erpFunUsers.getUserId());
		List<ErpCompRoleOpers> userOpers = erpCompRoleOpersMapper.parseQueryColumnOrganizationForUserOpers(erpFunUsers.getCityId().intValue(), erpFunUsers.getCompId(), erpFunUsers.getUserPosition());
		Integer columnValue = userOpers.size() > 0 ? userOpers.get(0).getOrganizationId() : 0;
		String columnName = "ORGANIZATION_ID";

		// story#11307 先判断当前公司是否说开了加盟模式，再判断当前这个人说在哪个组织，总部的就 要总部特殊的权限比如说加盟商管理权， 直营不管，如果说加盟商的人，那么要把特殊的加盟商公告管理权查出来
		List<Byte> flagList =  new ArrayList<Byte>();// 查询通用的权限，1=总部的，2=加盟商的
		flagList.add(Byte.valueOf("0"));
		ErpFunComp erpFunComp = erpFunCompMapper.selectByCompId(erpFunUsers.getCityId().intValue(), erpFunUsers.getCompId());
		if (null != erpFunComp && Byte.valueOf("1").equals(erpFunComp.getOpenPartner())) {
			if (Integer.valueOf(0).equals(erpFunUsers.getPartnerId())) {// 总部
				flagList.add(Byte.valueOf("1"));
				flagList.add(Byte.valueOf("3"));
			} else if (null != erpFunUsers.getPartnerId() && erpFunUsers.getPartnerId() > 0) {// 加盟商
				flagList.add(Byte.valueOf("2"));
			} else {// 加盟商模式下的直营
				flagList.add(Byte.valueOf("3"));
			}
		}

		if(columnName != null && columnValue != null) {
			erpUserOpersMapper.createByHaveCompRoleOper(erpFunUsers.getCityId().intValue(), erpFunUsers.getUserId(), erpFunUsers.getUserPosition(), erpFunUsers.getCompId(), columnName, columnValue, flagList);
			//修改跨店登录权限
			erpFunUsersMapper.updateUserAllDeptFlag(erpFunUsers.getCityId(),erpFunUsers.getUserId(),"LOGIN_OTHER_DEPTS",erpFunUsers.getCompId());
			//清理缓存
			erpFunUsersService.evictBaseInfoByCompId(erpFunUsers.getCityId().intValue(),erpFunUsers.getCompId());
		} else {
			//如果是管理员则需要包含高级权限
			if ("COMMON_ADMIN".equals(erpFunUsers.getUserPosition())) {
				erpUserOpersMapper.createByNoCompRoleOper(erpFunUsers.getCityId().intValue(), erpFunUsers.getUserId(), erpFunUsers.getUserPosition(), compType, true);
			} else {
				erpUserOpersMapper.createByNoCompRoleOper(erpFunUsers.getCityId().intValue(), erpFunUsers.getUserId(), erpFunUsers.getUserPosition(), compType, false);
			}
			this.addDefaultPrivilege(erpFunUsers.getCityId(), erpFunUsers.getUserId(), erpFunUsers.getUserPosition(), null);
		}
		if (!"GENERAL_MANAGER".equals(erpFunUsers.getUserPosition())) {
			// 不是总经理就删除投诉审核权
			ErpUserOpersExample erpUserOpersExample = new ErpUserOpersExample();
			erpUserOpersExample.setShardCityId(erpFunUsers.getCityId().intValue());
			erpUserOpersExample.createCriteria().andUserIdEqualTo(erpFunUsers.getUserId()).andOperIdEqualTo("AUDIT_HOUSE_COMPLAINT");
			erpUserOpersMapper.deleteByExample(erpUserOpersExample);
		}
		cacheUtil.del(CacheStructure.hfterpdb_userOpersCache_map_by_USER_ID+erpFunUsers.getUserId()+"_CITY_ID_"+erpFunUsers.getCityId());

	}
	
	/**
	 * 添加用户 或者修改用户角色添加默认权限
	 * @param position  角色
	 * @param runModel  运行模式
	 * @throws Exception 
	 */
	public void addDefaultPrivilege(Short cityId, Integer userId, String position, String runModel) {
		List<ErpUserOpers> opersPo = new ArrayList<ErpUserOpers>();
		// 添加房源默认查看权
		Set<String> houseViewPrivilege = UserOpersUtils.getViewHouseByPositionAndRunModel(position, runModel);
		Iterator<String> houseViewPrivilegeIt = houseViewPrivilege.iterator();
		while (houseViewPrivilegeIt.hasNext()) {
			ErpUserOpers opersPO = new ErpUserOpers();
			opersPO.setUserId(userId);
			opersPO.setOperId(houseViewPrivilegeIt.next());
			opersPo.add(opersPO);
		}
		// 添加客源默认查看权
		Set<String> custViewPrivilege = UserOpersUtils.getViewCustByPositionAndRunModel(position, runModel);
		Iterator<String> custViewPrivilegeIt = custViewPrivilege.iterator();
		while (custViewPrivilegeIt.hasNext()) {
			ErpUserOpers opersPO = new ErpUserOpers();
			opersPO.setUserId(userId);
			opersPO.setOperId(custViewPrivilegeIt.next());
			opersPo.add(opersPO);
		}
		if (!opersPo.isEmpty()) {
			erpUserOpersMapper.addDefaultPrivilege(cityId, opersPo);
		}
	}
	
	@Transactional
	@Override
	public void setRegistManager(Integer cityId,Integer userId,Integer compId) {
		ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(cityId, userId);
		if(!Constants_DIC.DIC_ROLE_NAME_GENERAL_MANAGER.equals(erpFunUsers.getUserPosition())){
			erpUserOpersMapper.deleteOldManager(cityId,userId, compId);
			ErpUserOpers erpUserOpers = new ErpUserOpers();
			erpUserOpers.setUserId(userId);
			erpUserOpers.setShardCityId(cityId);
			erpUserOpers.setOperId("REGIST_MANAGE");
			erpUserOpersMapper.insertSelective(erpUserOpers);
		}else{
			throw new BusinessException("总经理账号 无需设置为注册管理员");
		}
	}
	
	@Override
	public boolean userGetPublicInfoCheckRange(Integer cityId,Integer compId,Integer userId,Integer infoDeptId, Integer infoRegId, Integer infoAreaId,
			Integer caseType,String areaFlag,Integer selfAreaId,Integer selfRegId,Integer selfDeptId) {
		String rangeNum = "";
		if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)
				|| Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
//			rangeNum = erpSysParaMapper.getParamValue(cityId, compId, "PUBLIC_HOUSE_RANGE");
			rangeNum = erpSysParaService.getMLSysParamValByUserDefZero(cityId, compId,userId, "PUBLIC_HOUSE_RANGE");
		} else if (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)
				|| Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
//			rangeNum = erpSysParaMapper.getParamValue(cityId, compId, "PUBLIC_CUST_RANGE");
			rangeNum = erpSysParaService.getMLSysParamValByUserDefZero(cityId, compId,userId,"PUBLIC_CUST_RANGE");
		}
		if(Constants_DIC.DIC_SHARE_PUBLIC_RANGE_1.equals(rangeNum)){
			//允许查看全公司的抢盘和公盘数据
			return true;
		}else if("1".equals(areaFlag) && Constants_DIC.DIC_SHARE_PUBLIC_RANGE_2.equals(rangeNum) && selfAreaId.equals(infoAreaId) ){
			//允许查看大区内的抢盘和公盘数据
			return true;
		}else if(Constants_DIC.DIC_SHARE_PUBLIC_RANGE_3.equals(rangeNum) && selfRegId.equals(infoRegId) ){
			//允许查看片区内的抢盘和公盘数据
			return true;
		}else if(Constants_DIC.DIC_SHARE_PUBLIC_RANGE_4.equals(rangeNum) && selfDeptId.equals(infoDeptId) ){
			//允许查看门店内的抢盘和公盘数据
			return true;
		}
		return false;
	}

	@Override
	public boolean getViewBizExaminLimit(Integer cityId, Integer compId,Integer caseType, String examName, 
			Integer infoAreaId, Integer infoRegId, Integer infoDeptId, Integer infoGroupId, Integer infoUserId,
			Integer selfAreaId, Integer selfRegId, Integer selfDeptId, Integer selfGroupId, Integer selfUserId) {
		//用户具备业务无需审核权限
		Set<String> tmpOpers = erpUserOpersMapper.getUsersOpersByUserId(cityId, selfUserId, null);
		// 判断审核权限
		boolean haveExaminLimit = false;
		if(selfDeptId.equals(infoDeptId) && selfGroupId.equals(infoGroupId)) {
			haveExaminLimit = tmpOpers.contains("BIZ_DATA_EXAMIN_GROUP");
		} else {
			if(selfDeptId.equals(infoDeptId)) {
				haveExaminLimit = tmpOpers.contains("BIZ_DATA_EXAMIN_DEPT");
			} else {
				if(selfRegId.equals(infoRegId)) {
					haveExaminLimit = tmpOpers.contains("BIZ_DATA_EXAMIN_REG");
				} else {
					if(selfAreaId.equals(infoAreaId)) {
						haveExaminLimit = tmpOpers.contains("BIZ_DATA_EXAMIN_AREA");
					} else {
						haveExaminLimit = tmpOpers.contains("BIZ_DATA_EXAMIN_COMP");
					}
				}
			}
		}
		// 具有审核权限直接返回自动审核，否则在判断是否无需审核等
		if(haveExaminLimit) {
			return true;
		}
		//公司系统参数是否有无需审核业务
		String[] params = new String[]{
				"SALE_AUTO_EXAM_APPLY", "LEASE_AUTO_EXAM_APPLY",
				"BUY_AUTO_EXAM_APPLY", "RENT_AUTO_EXAM_APPLY",
		};
		Map<String, ErpSysPara> sysParaMap = erpSysParaService.getByParams(cityId, compId, params, false);
		boolean saleAutoExamApply = sysParaMap.get("SALE_AUTO_EXAM_APPLY").getParamValue().contains(examName);
		boolean leaseAutoExamApply = sysParaMap.get("LEASE_AUTO_EXAM_APPLY").getParamValue().contains(examName);
		boolean buyAutoExamApply = sysParaMap.get("BUY_AUTO_EXAM_APPLY").getParamValue().contains(examName);
		boolean rentAutoExamApply = sysParaMap.get("RENT_AUTO_EXAM_APPLY").getParamValue().contains(examName);
		
		String applySelfLimit = "";
		String applyGroupLimit = "";
		String applyDeptLimit = "";
		String applyRegLimit = "";
		String applyAreaLimit = "";
		String applyCompLimit = "";
		if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType) ||Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)){
			applySelfLimit = "AUTO_EXAM_APPLY_SELF_HOUSE";			//本人房源业务申请无需审核
			applyGroupLimit = "AUTO_EXAM_APPLY_GROUP_HOUSE";		//本组房源业务申请无需审核
			applyDeptLimit = "AUTO_EXAM_APPLY_DEPT_HOUSE";		//本店房源业务申请无需审核
			applyRegLimit = "AUTO_EXAM_APPLY_REG_HOUSE";			//本片区房源业务申请无需审核
			applyAreaLimit = "AUTO_EXAM_APPLY_AREA_HOUSE";		//本大区房源业务申请无需审核
			applyCompLimit = "AUTO_EXAM_APPLY_COMP_HOUSE";	//全公司房源业务申请无需审核
		}else if(Constants_DIC.DIC_CASE_TYPE_BUY_CUST.equals(caseType) ||Constants_DIC.DIC_CASE_TYPE_RENT_CUST.equals(caseType)){
			applySelfLimit = "AUTO_EXAM_APPLY_SELF_CUST";			//本人房源业务申请无需审核
			applyGroupLimit = "AUTO_EXAM_APPLY_GROUP_CUST";		//本组房源业务申请无需审核
			applyDeptLimit = "AUTO_EXAM_APPLY_DEPT_CUST";			//本店客源业务申请无需审核
			applyRegLimit = "AUTO_EXAM_APPLY_REG_CUST";			//本片区客源业务申请无需审核
			applyAreaLimit = "AUTO_EXAM_APPLY_AREA_CUST";			//本大区客源业务申请无需审核
			applyCompLimit = "AUTO_EXAM_APPLY_COMP_CUST";		//全公司客源业务申请无需审核
		}
		
		boolean bizSysParam = ((caseType.equals(Constants_DIC.DIC_CASE_TYPE_SALE_FUN) && saleAutoExamApply)//出售业务自动审核
								|| (caseType.equals(Constants_DIC.DIC_CASE_TYPE_LEASE_FUN) && leaseAutoExamApply)//出租业务自动审核
								|| (caseType.equals(Constants_DIC.DIC_CASE_TYPE_BUY_CUST) && buyAutoExamApply)//求购业务自动审核
								|| (caseType.equals(Constants_DIC.DIC_CASE_TYPE_RENT_CUST) && rentAutoExamApply));
		
		//为空说明可能是私盘下的公盘或者抢盘数据---自己的数据检查是否需要审核
		if(infoUserId != null && selfUserId.equals(infoUserId)){
			return (tmpOpers.contains(applySelfLimit) && bizSysParam);
		}else if(selfGroupId.equals(infoGroupId) && infoDeptId.equals(selfDeptId)){
			//说明是本店范围内
			//用户具备查看核心信息无需审核权限
			return (tmpOpers.contains(applyGroupLimit) && bizSysParam);
		} else {
			if(!infoGroupId.equals(selfGroupId) && tmpOpers.contains(applyDeptLimit) && bizSysParam && infoDeptId.equals(selfDeptId) && infoRegId.equals(selfRegId) && infoAreaId.equals(selfAreaId)){
				return true;
			}else if(!infoDeptId.equals(selfDeptId) && tmpOpers.contains(applyRegLimit) && bizSysParam && infoRegId.equals(selfRegId) && infoAreaId.equals(selfAreaId)){
				return true;
			}else if(!infoRegId.equals(selfRegId) && tmpOpers.contains(applyAreaLimit) && bizSysParam && infoAreaId.equals(selfAreaId)){
				return true;
			}else if(!infoAreaId.equals(selfAreaId) && tmpOpers.contains(applyCompLimit) && bizSysParam){
				return true;
			}
		}
		return false;
	}
	/**
	 * 判断用户的查看核心信息范围控制
	 */
	@Override
	public boolean getViewPhoneExaminLimit(Integer cityId, Integer compId, Integer caseGrId, Integer caseDeptId,
			Integer caseRegId, Integer caseAreaId, Integer caseType, Integer selfAreaId, Integer selfRegId, Integer selfDeptId, Integer selfGrId, Integer selfUserId) {
		//公司系统参数是否有无需审核业务
		String[] params = new String[]{
			"SALE_AUTO_EXAM_VIEW", "LEASE_AUTO_EXAM_VIEW",
			"BUY_AUTO_EXAM_VIEW", "RENT_AUTO_EXAM_VIEW"
		};
		Map<String, ErpSysPara> sysParaMap = erpSysParaService.getByParams(cityId, compId, params, false);
		String saleAutoExamView = sysParaMap.get("SALE_AUTO_EXAM_VIEW").getParamValue();
		String leaseAutoExamView = sysParaMap.get("LEASE_AUTO_EXAM_VIEW").getParamValue();
		String buyAutoExamView = sysParaMap.get("BUY_AUTO_EXAM_VIEW").getParamValue();
		String rentAutoExamView = sysParaMap.get("RENT_AUTO_EXAM_VIEW").getParamValue();
		boolean examView = (caseType.equals(Const.DIC_CASE_TYPE_SALE_FUN) && "1".equals(saleAutoExamView)) // 出售核心信息查看自动审核
				|| (caseType.equals(Const.DIC_CASE_TYPE_LEASE_FUN) && "1".equals(leaseAutoExamView)) // 出租核心信息查看自动审核
				|| (caseType.equals(Const.DIC_CASE_TYPE_BUY_CUST) && "1".equals(buyAutoExamView)) // 求购核心信息查看自动审核
				|| (caseType.equals(Const.DIC_CASE_TYPE_RENT_CUST) && "1".equals(rentAutoExamView));
		if (examView) {
			return true;
		}
		// 查看电话无需审核
		String viewGroupLimit = "";
		String viewDeptLimit = "";
		String viewRegLimit = "";
		String viewAreaLimit = "";
		String viewCompLimit = "";
		if(Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType) 
				||Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)){
			viewGroupLimit = "AUTO_EXAM_VIEW_GROUP_HOUSE";
			viewDeptLimit = "AUTO_EXAM_VIEW_DEPT_HOUSE";
			viewRegLimit = "AUTO_EXAM_VIEW_REG_HOUSE";
			viewAreaLimit = "AUTO_EXAM_VIEW_AREA_HOUSE";
			viewCompLimit = "AUTO_EXAM_VIEW_COMP_HOUSE";
		}else if(Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType) 
				||Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)){
			viewGroupLimit = "AUTO_EXAM_VIEW_GROUP_CUST";
			viewDeptLimit = "AUTO_EXAM_VIEW_DEPT_CUST";
			viewRegLimit = "AUTO_EXAM_VIEW_REG_CUST";
			viewAreaLimit = "AUTO_EXAM_VIEW_AREA_CUST";
			viewCompLimit = "AUTO_EXAM_VIEW_COMP_CUST";
		}
		String[] viewLimit = new String[]{viewGroupLimit, viewDeptLimit, viewRegLimit, viewAreaLimit, viewCompLimit};
//		--自动审核电话查看权
//		AUTO_EXAM_VIEW
//		AUTO_EXAM_VIEW_DEPT		--查看他店电话自动审核
//		AUTO_EXAM_VIEW_REGION	--查看其他片区电话自动审核
//		AUTO_EXAM_VIEW_AREA		--查看其他大区电话自动审核
		Set<String> userOperList = erpUserOpersMapper.getUsersOpersByUserId(cityId, selfUserId, viewLimit);
		//说明是本组范围内
		boolean isCommonGroup = (caseGrId != null && caseGrId > 0 && caseGrId.equals(selfGrId) && caseDeptId.equals(selfDeptId));
		if(isCommonGroup){
			//用户具备查看核心信息无需审核权限
			return userOperList.contains(viewGroupLimit);
		} else {
			//跨门店时，用户所在大区和片区ID必须一样
			//本门店
			if(!isCommonGroup && userOperList.contains(viewDeptLimit) && caseDeptId.equals(selfDeptId) && caseRegId.equals(caseRegId) && caseAreaId.equals(selfAreaId)){
				return true;
			//本片区
			}else if(!caseDeptId.equals(selfDeptId) && userOperList.contains(viewRegLimit) && caseRegId.equals(selfDeptId) && caseAreaId.equals(selfAreaId)){
				return true;
			//本大区
			}else if(!caseRegId.equals(selfRegId) && userOperList.contains(viewAreaLimit) && caseAreaId.equals(selfAreaId)){
				return true;
			//公司范围内
			}else if(!caseAreaId.equals(selfAreaId) && userOperList.contains(viewCompLimit)){
				return true;
			}
		}
		return false;
	}

	/**
	 * 营销版每个门店只能有一个分行经理
	 * @author 朱科
	 */
	@Override
	public boolean judgeBranchManager(Integer cityId, Integer compId, Integer deptId, Integer compType, Integer selfDeptId) {
		if(!Const.DIC_COMP_TYPE_3.equals(compType)){
			return true;// 非营销版不判断
		}
		ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
		ErpFunUsersExample.Criteria example = erpFunUsersExample.createCriteria();
		example.andCompIdEqualTo(compId).andUserWriteoffEqualTo(false);
		if(null != deptId){
			example.andDeptIdEqualTo(deptId);
		} else {
			example.andDeptIdEqualTo(selfDeptId);
		}
		example.andUserPositionEqualTo(Const.DIC_ROLE_NAME_BRANCH_MANAGER);
		erpFunUsersExample.setShardCityId(cityId);
		List<ErpFunUsers> funUsersList = erpFunUsersMapper.selectByExample(erpFunUsersExample);
		if(null != funUsersList && funUsersList.size() <=3){
			return true;
		}
		return false;
	}

	// USER_ROLE_CHANGE = 1 表示这次是更换角色需要清空以前的权限重新添加， 0：编辑个人权限但不变换角色
	// 由于用户更换角色需要清空用户以前拥有的所有权限然后重新添加本次权限
	@Transactional
	@Override
	public void updateUserOpers(Integer cityId, Integer compId, Integer compType, Integer userId,  String areaFlag, String roleId,
								Integer userRoleChange, String delOpers, String addOpers, Integer currentUserId, Integer currentDeptId) {


		ErpCompRolesExample compRolesExample = new ErpCompRolesExample();
		compRolesExample.setShardCityId(cityId);
		compRolesExample.createCriteria().andCompIdEqualTo(compId).andRoleIdEqualTo(roleId);
		List<ErpCompRoles> erpCompRoleOpersList = erpCompRolesMapper.selectByExample(compRolesExample);
		if(erpCompRoleOpersList.size() == 0) {
			return;
		}
		ErpCompRoles erpCompRoleOpers = erpCompRoleOpersList.get(0);

		if (null != erpCompRoleOpers && 1 == erpCompRoleOpers.getIsDel().intValue()) {
			throw new BusinessException("该角色已删除，请重新选择！");
		}
		Boolean allDeptFlag = null;
		Set<String> limitParams = new HashSet<>();
		ErpFunUsers funUsers = erpFunUsersMapper.getFunUserByUserId(cityId, userId);
		List<ErpUserOpersDto> beforeList = erpUserOpersMapper.getUserOpersList(cityId, compId, userId, funUsers.getUserPosition());

		ErpFunUsers funUsersPO = erpFunUsersMapper.getUserInfoByUserId(cityId, userId);
		if (1 == userRoleChange) {
			//一个公司只能配置一个管理员角色
			if ("COMMON_ADMIN".equals(roleId)) {
				ErpFunUsersExample usersExample = new ErpFunUsersExample();
				usersExample.setShardCityId(cityId);
				usersExample.createCriteria().andCompIdEqualTo(compId).andUserPositionEqualTo("COMMON_ADMIN").andUserWriteoffEqualTo(false);
				int adminRoleCount = erpFunUsersMapper.countByExample(usersExample);
				if (adminRoleCount > 0) {
					throw new BusinessException("一个公司只能配置一个管理员");
				}
			} else if ("COMMON_ADMIN".equals(funUsers.getUserPosition())) {//修改角色判断人数
				erpFunUsersService.checkDeptUserNum(cityId, funUsers.getDeptId(), true, roleId);
			}
			// 删除用户权限
			erpUserOpersMapper.deleteByUserId(cityId, userId);
			cacheUtil.del(CacheStructure.hfterpdb_userOpersCache_map_by_USER_ID+userId+"_CITY_ID_"+cityId);
			// 修改角色初始化跨店登录权为无
			allDeptFlag = false;


		} else {
			//先删除要指定的权限再添加防止数据重复
//			PT_OPERS_4_DEL   本次要删除的普通权限
//			ADVANCE_OPERS_4_DEL		本次要删除的高级权限
//			if (StringUtils.isNotBlank(ptOperDel)) {
//				String[] ptOperDels = StringHelper.split(ptOperDel, ",");
//				if (ptOperDels.length > 0) {
//					for (String tmpStr : ptOperDels) {
//						limitParams.add(tmpStr);
//					}
//					UserOpersUtils.addDefAreaOper(areaFlag, limitParams, ptOperDels);
//				}
//			}
			if (StringUtils.isNotBlank(delOpers)) {
				String[] advanceOperDels = StringHelper.split(delOpers, ",");
				if (advanceOperDels.length > 0) {
					for (String tmpStr : advanceOperDels) {
						if (tmpStr.equals("LOGIN_OTHER_DEPTS")) {
							allDeptFlag = false;
						}
						limitParams.add(tmpStr);
					}
					UserOpersUtils.addDefAreaOper(areaFlag, limitParams, advanceOperDels);
				}
			}
		}

//		PT_OPERS_4_ADD  本次要添加的普通权限
//		ADVANCE_OPERS_4_ADD		本次要添加的高级权限
		List<ErpUserOpers> addOpersList = new ArrayList<>();
//		String[] ptOpers = StringHelper.split(addOpers, ",");
//		if (ptOpers.length > 0) {
//			for (int i = 0; i < ptOpers.length; i++) {
//				if (StringUtils.isNotBlank(ptOpers[i])) {
//					ErpUserOpers userOpersPO = new ErpUserOpers();
//					userOpersPO.setUserId(userId);
//					userOpersPO.setOperId(ptOpers[i]);
//					commonUserOpersPOs.add(userOpersPO);
//				}
//			}
//			//这个必须在这里执行
//			UserOpersUtils.addDefAreaOper(areaFlag, userId, commonUserOpersPOs, ptOpers);
//		}
		String[] advanceOpers = new String[]{};
		if(StringUtils.isNotBlank(addOpers)) {
			advanceOpers = StringHelper.split(addOpers, ",");
			if (advanceOpers.length > 0) {
				for (int i = 0; i < advanceOpers.length; i++) {
					String tmpStr = advanceOpers[i];
					if (StringUtils.isNotBlank(tmpStr)) {
						ErpUserOpers userOpersPO = new ErpUserOpers();
						userOpersPO.setUserId(userId);
						userOpersPO.setOperId(tmpStr);
						if (tmpStr.equals("LOGIN_OTHER_DEPTS")) {
							allDeptFlag = true;
						}
						addOpersList.add(userOpersPO);
					}
				}
				//这个必须在这里执行
				UserOpersUtils.addDefAreaOper(areaFlag, userId, addOpersList, advanceOpers);
			}
		}


		//先删除
		if (limitParams.size() > 0) {
			ErpUserOpersExample userOpersExample = new ErpUserOpersExample();
			userOpersExample.setShardCityId(cityId);
			userOpersExample.createCriteria().andUserIdEqualTo(userId).andOperIdIn(new ArrayList<>(limitParams));
			erpUserOpersMapper.deleteByExample(userOpersExample);
		} else {
			//这个必须在这里执行
			if(advanceOpers.length > 0) {
				UserOpersUtils.addDefAreaOper(areaFlag, limitParams, advanceOpers);
			}
		}

		if (1 == userRoleChange) {
			// 这里修改了角色
			funUsers.setUserPosition(roleId);
			erpFunUsersService.initWageData(funUsers, 2);
		}

		String oldPosition = funUsersPO.getUserPosition();
		if (1 == userRoleChange || null != allDeptFlag) {
			//更新用户权限
			ErpFunUsers updateFunUsersPO = new ErpFunUsers();
			updateFunUsersPO.setUserPosition(roleId);
			updateFunUsersPO.setAlldeptFlag(allDeptFlag);
			updateFunUsersPO.setUserLogtime(DateUtil.DateToString(new Date()));
			updateFunUsersPO.setUserId(funUsersPO.getUserId());
			updateFunUsersPO.setShardCityId(cityId);
			updateFunUsersPO.setUpdateTime(DateUtil.DateToString(new Date()));
			erpFunUsersMapper.updateByPrimaryKeySelective(updateFunUsersPO);
			// 清楚权限

			cacheUtil.del(CacheStructure.hfterpdb_funUsersBaseInfoCache_map_by_COMP_ID+compId+"_CITY_ID_"+cityId);
			cacheUtil.del(CacheStructure.hfterpdb_funUsersBaseInfoCache_notwriteoff_map_by_COMP_ID+compId+"_CITY_ID_"+cityId);
		}else {//修改权限 更新用户updateTime
			ErpFunUsers users = new ErpFunUsers();
			users.setUserId(funUsersPO.getUserId());
			users.setShardCityId(cityId);
			users.setUpdateTime(DateUtil.DateToString(new Date()));
			erpFunUsersMapper.updateByPrimaryKeySelective(users);
		}
		
		// 增加权限
		this.updateUserOpers(cityId, compId, compType, funUsersPO, addOpersList, userRoleChange, roleId);

		adminFunErpUserGuideService.insertUserSeniorGuide(funUsersPO.getUserId(), funUsersPO.getArchiveId());
		compRolesExample = new ErpCompRolesExample();
		compRolesExample.setShardCityId(cityId);
		compRolesExample.createCriteria().andCompIdEqualTo(compId).andRoleIdEqualTo(oldPosition);
		erpCompRoleOpersList = erpCompRolesMapper.selectByExample(compRolesExample);
		if(erpCompRoleOpersList.size() == 0) {
			throw new BusinessException("所选员工角色异常，请联系在线客服");
		}
		ErpCompRoles oldCompRoles = erpCompRoleOpersList.get(0);
		String choseRoleName = erpCompRoleOpers.getRoleName();
		if (choseRoleName.equals(oldCompRoles.getRoleName())) {
			// 判断权限是否修改
			if (StringUtils.isNotBlank(delOpers) || StringUtils.isNotBlank(addOpers)) {
				choseRoleName = "修改了用户权限";
				// 记录权限修改日志
				List<ErpUserOpersDto> afterList = erpUserOpersMapper.getUserOpersList(cityId, compId, userId, roleId);
				erpSystemSettingLogsService.insertSysLog(SystemOperateUtil.SSL_TYPE.OPERS_SETTING, userId, null, choseRoleName, beforeList, afterList, cityId, compId, currentDeptId, currentUserId);
			}
		} else {
			choseRoleName = "由" + oldCompRoles.getRoleName() + "角色调整为" + choseRoleName + "角色";
			// 1=入职 2=组织调动 3 = 权限修改 4=角色调动 5=离职
			erpFunEmployeeLogService.insertLog(cityId, compId, (byte)4, choseRoleName, funUsersPO.getArchiveId(), currentUserId, funUsersPO.getDeptId(),
					funUsersPO.getDeptId(), oldCompRoles.getRoleId(), erpCompRoleOpers.getRoleId(), funUsersPO.getGrId(), funUsersPO.getGrId());

//			// 只有角色调用影响薪资
//			BaseMapParam baseMapParam = new BaseMapParam();
//			baseMapParam.setInteger("userId", userId);
//			baseMapParam.setInteger("compId", compId);
//			baseMapParam.setInteger("cityId", cityId);
//			wageTypeController.resetWagetypeUserRelativeOffUserId(baseMapParam);
			// 判断销售版，总经理权限处理、
			String sellVersion = erpSysParaMapper.getParamValue(cityId, compId, "IS_SELL_VERSION");
			if ("1".equals(sellVersion)) {
				this.marketVirtualGeneralProcess(funUsers, currentUserId, oldPosition, roleId);
			}
		}
		// 权限里面是否包含了房源投诉处理权
		if (StringUtils.isNotBlank(addOpers) && addOpers.contains("AUDIT_HOUSE_COMPLAINT")) {
			ErpFunUsers user = erpFunUsersMapper.getGeneralManagerByCompId(cityId, compId);
			erpAuditUserTemplateMapper.addAuditHouseComplaint(cityId, compId, userId, user.getUserId());
		} else if (StringUtils.isNotBlank(delOpers) && delOpers.contains("AUDIT_HOUSE_COMPLAINT")) {
			erpAuditUserTemplateMapper.delAuditHouseComplaint(cityId, compId, userId);
		}
	}

	// USER_ROLE_CHANGE = 1 表示这次是更换角色需要清空以前的权限重新添加， 0：编辑个人权限但不变换角色
	// 由于用户更换角色需要清空用户以前拥有的所有权限然后重新添加本次权限
	@Transactional
	@Override
	public void updateUserOpersNewOrg(Integer cityId, Integer compId, Integer compType, Integer userId, String areaFlag, String roleId,
									  Integer userRoleChange, String delOpers, List<ErpUserOpers> updateOpersList, Integer currentUserId, Integer currentDeptId, String userName) {

		ErpCompRolesExample compRolesExample = new ErpCompRolesExample();
		compRolesExample.setShardCityId(cityId);
		compRolesExample.createCriteria().andCompIdEqualTo(compId).andRoleIdEqualTo(roleId);
		List<ErpCompRoles> erpCompRoleOpersList = erpCompRolesMapper.selectByExample(compRolesExample);
		if(erpCompRoleOpersList.size() == 0) {
			return;
		}
		ErpCompRoles erpCompRoleOpers = erpCompRoleOpersList.get(0);

		if (null != erpCompRoleOpers && 1 == erpCompRoleOpers.getIsDel().intValue()) {
			throw new BusinessException("该角色已删除，请重新选择！");
		}

		Boolean allDeptFlag = null;
		Set<String> limitParams = new HashSet<>();
		ErpFunUsers funUsers = erpFunUsersMapper.getFunUserByUserId(cityId, userId);
		List<ErpUserOpersDto> beforeList = erpUserOpersMapper.getUserOpersList(cityId, compId, userId, funUsers.getUserPosition());

		ErpFunUsers funUsersPO = erpFunUsersMapper.getUserInfoByUserId(cityId, userId);
		if (1 == userRoleChange) {
			//一个公司只能配置一个管理员角色
			if ("COMMON_ADMIN".equals(roleId)) {
				ErpFunUsersExample usersExample = new ErpFunUsersExample();
				usersExample.setShardCityId(cityId);
				usersExample.createCriteria().andCompIdEqualTo(compId).andUserPositionEqualTo("COMMON_ADMIN").andUserWriteoffEqualTo(false);
				int adminRoleCount = erpFunUsersMapper.countByExample(usersExample);
				if (adminRoleCount > 0) {
					throw new BusinessException("一个公司只能配置一个管理员");
				}
			} else if ("COMMON_ADMIN".equals(funUsers.getUserPosition())) {//修改角色判断人数
				erpFunUsersService.checkDeptUserNum(cityId, funUsers.getDeptId(), true, roleId);
			}
			// 删除用户权限
			erpUserOpersMapper.deleteByUserId(cityId, userId);
			cacheUtil.del(CacheStructure.hfterpdb_userOpersCache_map_by_USER_ID+userId+"_CITY_ID_"+cityId);
			// 修改角色初始化跨店登录权为无
			allDeptFlag = false;
		} else {

			if (StringUtils.isNotBlank(delOpers)) {
				String[] advanceOperDels = StringHelper.split(delOpers, ",");
				if (advanceOperDels.length > 0) {
					for (String tmpStr : advanceOperDels) {
						if (tmpStr.equals("LOGIN_OTHER_DEPTS")) {
							allDeptFlag = false;
						}
						limitParams.add(tmpStr);
					}
					UserOpersUtils.addDefAreaOper(areaFlag, limitParams, advanceOperDels);
				}
			}
		}
		List<String> needDelOperIdList = new ArrayList<>(limitParams);
		//先删除
		if (limitParams.size() > 0) {
			needDelOperIdList.addAll(limitParams);
		}
		List<String> updateOperIdList = new ArrayList<>();
		// 删除后新增
		if(updateOpersList.size() > 0) {
			updateOperIdList = updateOpersList.stream().collect(Collectors.mapping(val -> val.getOperId(), Collectors.toList()));
			needDelOperIdList.addAll(updateOperIdList);
			if (updateOperIdList.contains("LOGIN_OTHER_DEPTS")) {
				allDeptFlag = true;
			}
		}

		if(needDelOperIdList.size() > 0) {
			ErpUserOpersExample userOpersExample = new ErpUserOpersExample();
			userOpersExample.setShardCityId(cityId);
			userOpersExample.createCriteria().andUserIdEqualTo(userId).andOperIdIn(needDelOperIdList);
			erpUserOpersMapper.deleteByExample(userOpersExample);
		}

		if (1 == userRoleChange){
			// 这里修改了角色
			funUsers.setUserPosition(roleId);
			funUsers.setAreaId(0);
			funUsers.setDeptId(0);
			funUsers.setRegId(0);
			erpFunUsersService.initWageData(funUsers, 2);
		}

		String oldPosition = funUsersPO.getUserPosition();
		if (1 == userRoleChange || null != allDeptFlag) {
			//更新用户权限
			ErpFunUsers updateFunUsersPO = new ErpFunUsers();
			updateFunUsersPO.setUserPosition(roleId);
			updateFunUsersPO.setAlldeptFlag(allDeptFlag);
			updateFunUsersPO.setUserLogtime(DateUtil.DateToString(new Date()));
			updateFunUsersPO.setUserId(funUsersPO.getUserId());
			updateFunUsersPO.setShardCityId(cityId);
			updateFunUsersPO.setUpdateTime(DateUtil.DateToString(new Date()));
			erpFunUsersMapper.updateByPrimaryKeySelective(updateFunUsersPO);

			cacheUtil.del(CacheStructure.hfterpdb_funUsersBaseInfoCache_map_by_COMP_ID+compId+"_CITY_ID_"+cityId);
			cacheUtil.del(CacheStructure.hfterpdb_funUsersBaseInfoCache_notwriteoff_map_by_COMP_ID+compId+"_CITY_ID_"+cityId);
		}else {//修改权限 更新用户updateTime
			ErpFunUsers users = new ErpFunUsers();
			users.setUserId(funUsersPO.getUserId());
			users.setShardCityId(cityId);
			users.setUpdateTime(DateUtil.DateToString(new Date()));
			erpFunUsersMapper.updateByPrimaryKeySelective(users);
		}

		// 增加权限
		this.updateUserOpersNewOrg(cityId, compId, compType, funUsersPO, updateOpersList, userRoleChange, roleId);

		adminFunErpUserGuideService.insertUserSeniorGuide(funUsersPO.getUserId(), funUsersPO.getArchiveId());
		compRolesExample = new ErpCompRolesExample();
		compRolesExample.setShardCityId(cityId);
		compRolesExample.createCriteria().andCompIdEqualTo(compId).andRoleIdEqualTo(oldPosition);
		erpCompRoleOpersList = erpCompRolesMapper.selectByExample(compRolesExample);
		if(erpCompRoleOpersList.size() == 0) {
			throw new BusinessException("所选员工角色异常，请联系在线客服");
		}
		ErpCompRoles oldCompRoles = erpCompRoleOpersList.get(0);
		String choseRoleName = erpCompRoleOpers.getRoleName();
		if (choseRoleName.equals(oldCompRoles.getRoleName())) {
			// 判断权限是否修改
			if (StringUtils.isNotBlank(delOpers) || updateOpersList.size() > 0) {
				choseRoleName = "修改了用户权限";
				// 记录权限修改日志
				List<ErpUserOpersDto> afterList = erpUserOpersMapper.getUserOpersList(cityId, compId, userId, roleId);
				//erpSystemSettingLogsService.insertSysLog(SystemOperateUtil.SSL_TYPE.OPERS_SETTING, userId, null, choseRoleName, beforeList, afterList, cityId, compId, currentDeptId, currentUserId);
			    erpSystemSettingLogsService.insertSysLogNew(SystemOperateUtil.SSL_TYPE.OPERS_SETTING, userId, null, choseRoleName, beforeList, afterList, cityId, compId, currentDeptId, currentUserId,userName);
			}
		} else {
			choseRoleName = "由" + oldCompRoles.getRoleName() + "角色调整为" + choseRoleName + "角色";
			// 1=入职 2=组织调动 3 = 权限修改 4=角色调动 5=离职
			erpFunEmployeeLogService.insertLog(cityId, compId, (byte)4, choseRoleName, funUsersPO.getArchiveId(), currentUserId, funUsersPO.getDeptId(),
					funUsersPO.getDeptId(), oldCompRoles.getRoleId(), erpCompRoleOpers.getRoleId(), funUsersPO.getGrId(), funUsersPO.getGrId());

			// 判断销售版，总经理权限处理、
			String sellVersion = erpSysParaMapper.getParamValue(cityId, compId, "IS_SELL_VERSION");
			if ("1".equals(sellVersion)) {
				this.marketVirtualGeneralProcess(funUsers, currentUserId, oldPosition, roleId);
			}
		}

		if(delOpers.contains("AUDIT_HOUSE_COMPLAINT")) {
			erpAuditUserTemplateMapper.delAuditHouseComplaint(cityId, compId, userId);
		}

		if(updateOperIdList.size() > 0) {
			Integer count = erpAuditUserTemplateMapper.countAuditHouseComplaint(cityId, compId, userId);
			if(count == 0) {
				ErpFunUsers user = erpFunUsersMapper.getGeneralManagerByCompId(cityId, compId);
				erpAuditUserTemplateMapper.addAuditHouseComplaint(cityId, compId, userId, user.getUserId());
			}

		}
	}

	/**
	  * @Title  : 更新权限
	  * @author : lcb
	  * @Time   ： 2018/7/23
	  *
	  **/
	@Transactional
	public String updateUserOpers(Integer cityId, Integer compId, Integer compType, ErpFunUsers funUsersPO, List<ErpUserOpers> addOpersList ,
								  Integer userRoleChange, String roleId) {
		String salaryTypeId = null;
		Integer userId = funUsersPO.getUserId();

		if(roleId != null && roleId.equals(Constants_DIC.DIC_ROLE_NAME_BRANCH_MANAGER) && !judgeBranchManager(cityId, compId, funUsersPO.getDeptId(), compType, null)){
			throw new BusinessException("你是赢销版用户，1个门店最多只能创建3个分行经理账号！");
		}

		if(addOpersList.size()>0){
			for (ErpUserOpers erpUserOpers : addOpersList) {
				erpUserOpers.setShardCityId(cityId);
				try {
					erpUserOpersMapper.insertSelective(erpUserOpers);
				}catch (Exception e) {

				}
			}
		}
		//更新人员权限，给被更改的人员一个提示,2代表修改权限
		try {
			Object loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_ERP + funUsersPO.getArchiveId());
			if (loginKey != null) {
			    cacheUtil.put(loginKey, Const.LogInEnum.RoleOrOper_UP.getValue(), CacheUtilExt.INVALID_TIME_OUT);
			}
			loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_APP + funUsersPO.getArchiveId());
			if (loginKey != null) {
			    cacheUtil.put(loginKey, Const.LogInEnum.RoleOrOper_UP.getValue(), CacheUtilExt.INVALID_TIME_OUT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		TaskQueueMsg taskQueueMsg = new TaskQueueMsg();
		taskQueueMsg.setTaskType(new TaskQueueThread.TaskType[]{TaskQueueThread.TaskType.MERGE_APP_REFRESH_USER});
		taskQueueMsg.setTargetIds(new Integer[]{funUsersPO.getArchiveId()});
		TaskQueueThread.sendMessage(taskQueueMsg);
		//更新用户角色，清除基本信息集合
		if(!funUsersPO.getUserPosition().equals(roleId)){
			erpNoTransactionService.evictBaseInfoByCompId(cityId, compId);

		}
		if(null != userRoleChange && 1 == userRoleChange){
			addDefaultPrivilege(cityId.shortValue(), userId, roleId, null);
		}
		//清理缓存
		erpNoTransactionService.evictCacheableModelData(cityId, userId);
		return salaryTypeId;
	}

	/**
	 * @Title  : 更新权限
	 * @author : lcb
	 * @Time   ： 2018/7/23
	 *
	 **/
	@Transactional
	public String updateUserOpersNewOrg(Integer cityId, Integer compId, Integer compType, ErpFunUsers funUsersPO, List<ErpUserOpers> addOpersList ,
								  Integer userRoleChange, String roleId) {
		String salaryTypeId = null;
		Integer userId = funUsersPO.getUserId();

		if(roleId != null && roleId.equals(Constants_DIC.DIC_ROLE_NAME_BRANCH_MANAGER) && !judgeBranchManager(cityId, compId, funUsersPO.getDeptId(), compType, null)){
			throw new BusinessException("你是赢销版用户，1个门店最多只能创建3个分行经理账号！");
		}

		for (ErpUserOpers erpUserOpers : addOpersList) {
			try {
				erpUserOpers.setShardCityId(cityId);
				erpUserOpers.setUserId(funUsersPO.getUserId());
				erpUserOpersMapper.insertSelective(erpUserOpers);
			}catch (Exception e) {}
		}

		//更新人员权限，给被更改的人员一个提示,2代表修改权限
		try {
			Object loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_ERP + funUsersPO.getArchiveId());
			if (loginKey != null) {
				cacheUtil.put(loginKey, Const.LogInEnum.RoleOrOper_UP.getValue(), CacheUtilExt.INVALID_TIME_OUT);
			}
			loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_APP + funUsersPO.getArchiveId());
			if (loginKey != null) {
				cacheUtil.put(loginKey, Const.LogInEnum.RoleOrOper_UP.getValue(), CacheUtilExt.INVALID_TIME_OUT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		TaskQueueMsg taskQueueMsg = new TaskQueueMsg();
		taskQueueMsg.setTaskType(new TaskQueueThread.TaskType[]{TaskQueueThread.TaskType.MERGE_APP_REFRESH_USER});
		taskQueueMsg.setTargetIds(new Integer[]{funUsersPO.getArchiveId()});
		TaskQueueThread.sendMessage(taskQueueMsg);
		//更新用户角色，清除基本信息集合
		if(!funUsersPO.getUserPosition().equals(roleId)){
			erpNoTransactionService.evictBaseInfoByCompId(cityId, compId);

		}
		if(null != userRoleChange && 1 == userRoleChange){
			addDefaultPrivilege(cityId.shortValue(), userId, roleId, null);
		}
		//清理缓存
		erpNoTransactionService.evictCacheableModelData(cityId, userId);
		return salaryTypeId;
	}


	/**
	 * @tag 销售版
	 * @author 邓永洪
	 * @since 2018/10/16
	 */
	@Transactional
	@Override
	public void marketVirtualGeneralProcess(ErpFunUsers funUsers, Integer currentUserId, String oldPosition, String roleId) {
		Integer cityId = funUsers.getCityId().intValue();
		Integer compId = funUsers.getCompId();
		if ("GENERAL_MANAGER".equals(oldPosition)) {
			ErpMarketVirtualGeneralExample marketVirtualGeneralExample = new ErpMarketVirtualGeneralExample();
			marketVirtualGeneralExample.setShardCityId(cityId);
			marketVirtualGeneralExample.createCriteria().andCompIdEqualTo(compId).andUserIdEqualTo(funUsers.getUserId());
			erpMarketVirtualGeneralMapper.deleteByExample(marketVirtualGeneralExample);
		}
		if ("GENERAL_MANAGER".equals(roleId)) {
			ErpMarketVirtualGeneral marketVirtualGeneral = new ErpMarketVirtualGeneral();
			marketVirtualGeneral.setShardCityId(cityId);
			marketVirtualGeneral.setCityId(cityId);
			marketVirtualGeneral.setCompId(compId);
			marketVirtualGeneral.setAreaId(funUsers.getAreaId());
			marketVirtualGeneral.setRegId(funUsers.getRegId());
			marketVirtualGeneral.setDeptId(funUsers.getDeptId());
			marketVirtualGeneral.setGrId(funUsers.getGrId());
			marketVirtualGeneral.setUserId(funUsers.getUserId());
			marketVirtualGeneral.setArchiveId(funUsers.getArchiveId());
			marketVirtualGeneral.setCreateTime(new Date());
			marketVirtualGeneral.setCreateUser(currentUserId);
			erpMarketVirtualGeneralMapper.insertSelective(marketVirtualGeneral);
		}
	}
	@Override
	public void updateUserOpers(Integer cityId, Integer compId, List<String> roleIds, Set<String> deleteOpers,
			Set<String> repeatUpdateOperIds, Set<String> ptOperAdd) {

		if(cityId == null || compId == null ){
			return;
		}
		if(roleIds == null || roleIds.size() < 1){
			return;
		}
		Integer allDeptFlag = null;
		if(deleteOpers.contains("LOGIN_OTHER_DEPTS")){
			allDeptFlag = 0 ;
		}else if(repeatUpdateOperIds.contains("LOGIN_OTHER_DEPTS")){
			allDeptFlag = 1;
		}
		for (String roleId : roleIds) {
			//查询角色下有多少人
			if(deleteOpers !=null && deleteOpers.size() > 0){
				erpUserOpersMapper.deleteUserOper(cityId,compId,roleId,deleteOpers);
			}
			if(repeatUpdateOperIds !=null && repeatUpdateOperIds.size() > 0){
				erpUserOpersMapper.deleteUserOper(cityId,compId,roleId,repeatUpdateOperIds);
			}
			//添加权限
			List<Byte> flagList = Arrays.asList(Byte.valueOf("0"));// 公司角色权限中的权限类型设定为通用权限0,1=加盟商模式下的总部独有权限，2=加盟商模式下的加盟商独有权限
			erpCompRolesService.updateUserOpers(cityId,compId, "COMP_ID", "SOURCE_COMP_ID", compId+"", roleId, deleteOpers, ptOperAdd, flagList);
			
			updateUserInfoAndCache(cityId, compId, roleId,allDeptFlag);
		}
	}
	
	private void updateUserInfoAndCache(Integer cityId, Integer  compId, String roleId,Integer allDeptFlag){
		//更新用户的较色信息并更新缓存 --陈文超
		if(null != allDeptFlag){
			ErpFunUsers updateFunUSers = new ErpFunUsers();
			updateFunUSers.setAlldeptFlag(allDeptFlag > 0);
			
			ErpFunUsersExample usersExample = new ErpFunUsersExample();
			usersExample.setShardCityId(cityId);
			usersExample.createCriteria().andUserWriteoffEqualTo(false)
			.andUserPositionEqualTo(roleId).andCompIdEqualTo(compId);
			erpFunUsersMapper.updateByExampleSelective(updateFunUSers, usersExample);
		}
		Set<Integer> userIds = new HashSet<Integer>();
		ErpFunUsersExample usersExample = new ErpFunUsersExample();
		usersExample.setShardCityId(cityId);
		usersExample.createCriteria().andCompIdEqualTo(compId).andUserWriteoffEqualTo(false)
		.andUserPositionEqualTo(roleId);
		List<ErpFunUsers> userList = erpFunUsersMapper.selectByExample(usersExample);
		for(ErpFunUsers funUsersPO : userList){
			try {
				//更新人员权限，给被更改的人员一个提示,2代表修改权限
				Object loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_ERP + funUsersPO.getArchiveId());
				if (loginKey != null) {
				    cacheUtil.put(loginKey, Const.LogInEnum.RoleOrOper_UP.getValue(), CacheUtilExt.INVALID_TIME_OUT);
				}
				loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_APP + funUsersPO.getArchiveId());
				if (loginKey != null) {
				    cacheUtil.put(loginKey, Const.LogInEnum.RoleOrOper_UP.getValue(), CacheUtilExt.INVALID_TIME_OUT);
				}
			} catch (Exception e) {
				//这里不需要报出异常信息}
			}
			userIds.add(funUsersPO.getArchiveId());
			erpNoTransactionService.evictCacheableModelData(cityId, funUsersPO.getUserId());
		}
		TaskQueueMsg taskQueueMsg = new TaskQueueMsg();
		taskQueueMsg.setTaskType(new TaskQueueThread.TaskType[]{TaskQueueThread.TaskType.MERGE_APP_REFRESH_USER});
		taskQueueMsg.setTargetIds(userIds.toArray(new Integer[]{}));
		TaskQueueThread.sendMessage(taskQueueMsg);

		erpNoTransactionService.evictBaseInfoByCompId(cityId, compId);
	}

	/**
	 * 判断前端传值的组织orgId, 与自己权限判断范围的集合
	 * operId=需要查询的权限名称(例如 MANAGE_ORGANIZATION_CASE_COOPERATE, MGR_OTHER_BIZ_DATA_ORGANIZATION, VIEW_ORGANIZATION_HOUSE_LIST_INFO)
	 * queryOrgId=前端传上来的组织机构ID, 需要和自己的权限范围做判断
	 **/
	@Override
	public OrganizatQueryParam checkOrgIdAndOperNewOrg(Integer cityId, Integer compId, Integer currUserId, Byte caseType, String operId, Integer queryOrgId,boolean isSwitchCompLogin) {
		OrganizatQueryParam organizatQueryParam = new OrganizatQueryParam();
		//查询系统参数、权限范围、管理层级范围，注意：如果权限已经达到全公司范围了，则系统参数和管理层级的范围直接忽略-陈文超-2019-12-08
		Set<Integer> queryOrgIds = new HashSet<>();
		//机构层级表中的ID
		Integer currUserDefId = null;
		Integer userDefLevel = null;

		ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, currUserId);
		//如果是总经理直接返回最大范围
		if("GENERAL_MANAGER".equals(erpFunUsers.getUserPosition())){
			//如果权限为全公司范围，则不限制查询
			organizatQueryParam.setLimit(false);
			organizatQueryParam.setQueryOrgIds(queryOrgIds);
			return organizatQueryParam;
		}
		Integer userOrgId = erpFunUsers.getOrganizationId();
		String tissueLine = erpFunUsers.getTissueLine();

		ErpFunOrganization userOrg = erpFunOrganizationMapper.selectOrgByOrganizationId(cityId, userOrgId);
		if (userOrg != null && userOrg.getOrganizationDefinitionId() != null) {
			Integer userDefId = userOrg.getOrganizationDefinitionId();
			ErpFunOrganizationDefinition userDef = erpFunOrganizationDefinitionMapper.getOrganizationDefinitionId(cityId, compId, userDefId);
			if (userDef != null) {
				userDefLevel = userDef.getDefinitionLevel();
			}
		}

		if (currUserId == null || compId == null || cityId == null || StringUtils.isBlank(tissueLine)) {
			Assert.isNullThrow(true, "关键的条件ID不能为null");
		}

		// 有些判断是不需要房客源类型的
		if (caseType == null) {
			caseType = Constants_DIC.DIC_CASE_TYPE_SALE_FUN_BYTE;
		}

		// 权限指定的查询范围
		ErpUserOpers erpUserOpers = null;
		if (Constants_DIC.DIC_CASE_TYPE_SALE_FUN_BYTE.equals(caseType) || Constants_DIC.DIC_CASE_TYPE_LEASE_FUN_BYTE.equals(caseType)) {
			if (isSwitchCompLogin) {
				erpUserOpers = erpUserOpersMapper.getUserOperByUserIdOperIdSwitchLogin(cityId, currUserId, operId);
			} else {
				erpUserOpers = erpUserOpersMapper.getUserOperByUSerIdOperId(cityId, currUserId, operId);
			}
			if (erpUserOpers != null) {
				currUserDefId = erpUserOpers.getOrganizationDefinitionId();
			}
		} else if (Constants_DIC.DIC_CASE_TYPE_BUY_CUST_BYTE.equals(caseType) || Constants_DIC.DIC_CASE_TYPE_RENT_CUST_BYTE.equals(caseType)) {
			if (isSwitchCompLogin) {
				erpUserOpers = erpUserOpersMapper.getUserOperByUserIdOperIdSwitchLogin(cityId, currUserId, operId);
			} else {
				erpUserOpers = erpUserOpersMapper.getUserOperByUSerIdOperId(cityId, currUserId, operId);
			}
			if (erpUserOpers != null) {
				currUserDefId = erpUserOpers.getOrganizationDefinitionId();
			}
		}
		// 有权限，但是没有层级的，默认全公司兼容
		if (erpUserOpers != null && currUserDefId == null) {
			currUserDefId = 0;
		}

		if (currUserDefId != null) {
			if (currUserDefId == 0) {
				// 如果权限为全公司范围，则不限制查询
				organizatQueryParam.setLimit(false);
				return organizatQueryParam;
				// 为-2的时候系统参数代表的查询范围为：本人，这里只能用等于-2，不要用小于0，不知道以后是否会出现-1
			} else if (currUserDefId == -2) {
				organizatQueryParam.setLimit(true);
				// 机构ID集合为空集合
				if (userOrgId != null) {
					queryOrgIds.add(userOrgId);
				}
				organizatQueryParam.setQueryOrgIds(queryOrgIds);
				organizatQueryParam.setSelfUserId(currUserId);
				return organizatQueryParam;
			}

			// 当前用户权限的管理层级
			ErpFunOrganizationDefinition userOperDef = erpFunOrganizationDefinitionMapper.getOrganizationDefinitionId(cityId, compId, currUserDefId);
			Integer userOperDefLevel = userOperDef.getDefinitionLevel();

			// 人在片区级，只有权限在片区级及其以上，才能查看该片区下门店及其以下的数据，否则只能查看自己的数据
			if (userDefLevel != null && userOperDefLevel > userDefLevel) {
				organizatQueryParam.setLimit(true);
				// 机构ID集合为空集合
				if (userOrgId != null) {
					queryOrgIds.add(userOrgId);
				}
				organizatQueryParam.setQueryOrgIds(queryOrgIds);
				organizatQueryParam.setSelfUserId(currUserId);
				return organizatQueryParam;
			}

			// 前端传上来需要查询的范围
			List<ErpOrganizationVO> queryOrgVos = erpFunOrganizationMapper.getOrganizationVOs(cityId, compId, new HashSet<Integer>() {{
				add(queryOrgId);
			}});
			Integer finalLevel = null;
			if (CollectionUtils.isNotEmpty(queryOrgVos)) {
				ErpOrganizationVO queryOrgVo = queryOrgVos.get(0);
				Integer queryLevel = queryOrgVo.getDefinitionLevel();
				// 传上来的是大区级, 但是自己的权限是城市级->取大区级范围, 取范围小的那一个(level大的值)
				// 传上来的是城市级, 但是自己的权限是大区级->取大区级范围, 取范围小的那一个(level大的值)
				finalLevel = userOperDefLevel >= queryLevel ? userOperDefLevel : queryLevel;
			}

			// 用户允许的查询范围层级defId集合-这里将公司所有的层级数据查询出来-该数据量不大-暂不考虑性能问题
			ErpFunOrganizationDefinitionExample defIdExample = new ErpFunOrganizationDefinitionExample();
			defIdExample.setShardCityId(cityId);
			defIdExample.createCriteria().andCompIdEqualTo(compId).andDelFlagEqualTo(Byte.valueOf("0"));
			List<ErpFunOrganizationDefinition> defObjList = erpFunOrganizationDefinitionMapper.selectByExample(defIdExample);
			Map<Integer, Integer> defIdMapLevel = defObjList.stream().collect(Collectors.toMap(ErpFunOrganizationDefinition::getDefinitionId, ErpFunOrganizationDefinition::getDefinitionLevel));

			List<Integer> currentOrgIds = Arrays.stream(tissueLine.split(":"))
					.filter(it -> !":".equals(it) && StringUtils.isNotBlank(it))
					.map(Integer::valueOf)
					.collect(Collectors.toList());

			//系统参数指定的查询范围-查询级别高的机构
			ErpFunOrganizationExample example = new ErpFunOrganizationExample();
			example.setShardCityId(cityId);
			example.createCriteria().andCompIdEqualTo(compId).andOrganizationIdIn(currentOrgIds).andDelFlagEqualTo(Byte.valueOf("0"));
			List<ErpFunOrganization> orgObjList = erpFunOrganizationMapper.selectByExample(example);

			//系统参数指定的查询范围-查询级别低的机构
			example.clear();
			example.setShardCityId(cityId);
			example.createCriteria().andCompIdEqualTo(compId).andOrganizationPathLike("%:" + userOrgId + ":%").andDelFlagEqualTo(Byte.valueOf("0"));
			List<ErpFunOrganization> orgObjListTmp = erpFunOrganizationMapper.selectByExample(example);
			orgObjList.addAll(orgObjListTmp);

			if (!orgObjList.isEmpty()) {
				// 循环遍历当前用户所在机构的层级在允许范围内，层级越大级别越小
				for (ErpFunOrganization tmp : orgObjList) {
					Integer tmpDefId = tmp.getOrganizationDefinitionId();
					if (defIdMapLevel.containsKey(tmpDefId)) {
						Integer tmpDefLevel = defIdMapLevel.get(tmpDefId);
						// 范围层级不能小于等于
						if (finalLevel != null && tmpDefLevel >= finalLevel) {
							queryOrgIds.add(tmp.getOrganizationId());
						}
					}
				}
			}
		}

		//管理层级的机构范围
		List<ErpFunUserManageRange> erpFunUserManageRangeList = erpFunUserManageRangeMapper.selectByCompIdAndUserId(cityId, compId, currUserId);
		if (!erpFunUserManageRangeList.isEmpty()) {
			//新组织机构模式的rangId = organizationId
			List<Integer> rangIds = erpFunUserManageRangeList.stream().map(ErpFunUserManageRange::getRangeId).collect(Collectors.toList());
			queryOrgIds.addAll(rangIds);
		}

		organizatQueryParam.setLimit(true);
		organizatQueryParam.setQueryOrgIds(queryOrgIds);
		organizatQueryParam.setSelfUserId(currUserId);
		return organizatQueryParam;
	}
	
	
	@Override
	@Transactional
	public void saveCrossCompOper(SaveCrossCompOperParam param, Operator operator) {
		int cityId = operator.getCityId();
		//根据compId的开关，来处理operList中的权限的增删
		if (null == param.getUserId() || param.getOpenCityManage().isEmpty() ) {//|| param.getOperList().isEmpty()
			//throw new BusinessException("保存失败，请联系客服处理");
			return;
		}
		//自己不可给自己配置
		if(operator.getUserId().equals(param.getUserId())) {
			throw new BusinessException("自己不能给自己配置权限");
		}
		List<OpenCityManageParam> openCityManageParams = param.getOpenCityManage();
		for (OpenCityManageParam openCityManageParam : openCityManageParams) {
			ErpFunCompExample erpFunCompExample = new ErpFunCompExample();
			erpFunCompExample.createCriteria().andCompIdEqualTo(openCityManageParam.getCompId());
			erpFunCompExample.setShardCityId(cityId);
			List<ErpFunComp> erpFunComp = erpFunCompMapper.selectByExample(erpFunCompExample);
			
			if (openCityManageParam.getIsOpen() == 0) {
				//关闭此用户对此公司的权限标记、和删除此用户对应此公司的权限组
				//关闭个人对公司权限标记
				ErpFunCrossCompStatus updateCrossCompStatus = new ErpFunCrossCompStatus();
				updateCrossCompStatus.setOpenFlag((byte)0);
				ErpFunCrossCompStatusExample updateCompStatusExample = new ErpFunCrossCompStatusExample();
				updateCompStatusExample.createCriteria().andUserIdEqualTo(param.getUserId()).andCompIdEqualTo(openCityManageParam.getCompId());
				updateCompStatusExample.setShardCityId(cityId);
				erpFunCrossCompStatusMapper.updateByExampleSelective(updateCrossCompStatus, updateCompStatusExample);
				
				//移除此用户对此公司的所有跨城权限
				ErpFunCrossCompUserOperExample erpFunCrossCompUserOperExample = new ErpFunCrossCompUserOperExample();
				erpFunCrossCompUserOperExample.createCriteria().andUserIdEqualTo(param.getUserId()).andCompIdEqualTo(openCityManageParam.getCompId());
				erpFunCrossCompUserOperExample.setShardCityId(cityId);
				erpFunCrossCompUserOperMapper.deleteByExample(erpFunCrossCompUserOperExample);
				
				//逻辑删除此用户的跨城管理员表记录
				ErpFunCrossCompUser updateCrossCompUser = new ErpFunCrossCompUser();
				updateCrossCompUser.setDelFlag((byte)1);
				updateCrossCompUser.setUpdateTime(new Date());
				ErpFunCrossCompUserExample updateCrossCompUserExample = new ErpFunCrossCompUserExample();
				updateCrossCompUserExample.createCriteria().andUserIdEqualTo(param.getUserId()).andCompIdEqualTo(openCityManageParam.getCompId());
				updateCrossCompUserExample.setShardCityId(cityId);
				erpFunCrossCompUserMapper.updateByExampleSelective(updateCrossCompUser, updateCrossCompUserExample);
			} else if (openCityManageParam.getIsOpen() == 1) {
				//查询个人对公司权限标记表，如果没有：新增开启此用户对此公司的权限标记、和（如果传值）新增以及删除权限
				ErpFunCrossCompStatusExample erpFunCrossCompStatusExample = new ErpFunCrossCompStatusExample();
				erpFunCrossCompStatusExample.createCriteria().andUserIdEqualTo(param.getUserId()).andCompIdEqualTo(openCityManageParam.getCompId());
				erpFunCrossCompStatusExample.setShardCityId(cityId);
				List<ErpFunCrossCompStatus> erpFunCrossCompStatus = erpFunCrossCompStatusMapper.selectByExample(erpFunCrossCompStatusExample);
				if (!erpFunCrossCompStatus.isEmpty() && erpFunCrossCompStatus.size() > 0) {//有记录
					if(erpFunCrossCompStatus.get(0).getOpenFlag() == (byte)0) {//关闭状态：给开启
						ErpFunCrossCompStatus updateCompStatus = new ErpFunCrossCompStatus();
						updateCompStatus.setOpenFlag((byte)1);
						ErpFunCrossCompStatusExample updateCompStatusExample = new ErpFunCrossCompStatusExample();
						updateCompStatusExample.createCriteria().andIdEqualTo(erpFunCrossCompStatus.get(0).getId());//andUserIdEqualTo(param.getUserId()).andCompIdEqualTo(openCityManageParam.getCompId());
						updateCompStatusExample.setShardCityId(cityId);
						erpFunCrossCompStatusMapper.updateByExampleSelective(updateCompStatus, updateCompStatusExample);
					}
				} else {//没记录：新建
					ErpFunCrossCompStatus insertCrossCompStatus = new ErpFunCrossCompStatus();
					insertCrossCompStatus.setUserId(param.getUserId());
					insertCrossCompStatus.setCityId(erpFunComp.get(0).getCityId().intValue());
					insertCrossCompStatus.setCompId(openCityManageParam.getCompId());
					insertCrossCompStatus.setOpenFlag((byte)1);
					insertCrossCompStatus.setShardCityId(cityId);
					erpFunCrossCompStatusMapper.insertSelective(insertCrossCompStatus);
				}
				//然后处理权限组
				List<OperListParam> operListParams = param.getOperList();
				for (OperListParam operListParam : operListParams) {
					if (openCityManageParam.getCompId().equals(operListParam.getCompId())) {
						if(!StringUtil.isBlank(operListParam.getAddOpers())) {
							String []addOpers = operListParam.getAddOpers().split(",");
							for (String addOper : addOpers) {
								ErpFunCrossCompUserOper insertCrossCompUserOper = new ErpFunCrossCompUserOper();
								insertCrossCompUserOper.setUserId(param.getUserId());
								insertCrossCompUserOper.setCompId(openCityManageParam.getCompId());
								insertCrossCompUserOper.setOperId(addOper);
								insertCrossCompUserOper.setShardCityId(cityId);
								erpFunCrossCompUserOperMapper.insertSelective(insertCrossCompUserOper);
							}
						}
						if(!StringUtil.isBlank(operListParam.getDelOpers())) {
							String []delOpers = operListParam.getDelOpers().split(",");
							for (String delOper : delOpers) {
								ErpFunCrossCompUserOperExample deleteCrossCompUserOperExample = new ErpFunCrossCompUserOperExample();
								deleteCrossCompUserOperExample.createCriteria().andUserIdEqualTo(param.getUserId()).andCompIdEqualTo(openCityManageParam.getCompId()).andOperIdEqualTo(delOper);
								deleteCrossCompUserOperExample.setShardCityId(cityId);
								erpFunCrossCompUserOperMapper.deleteByExample(deleteCrossCompUserOperExample);
							}
						}
					}
				}
				//然后处理跨城管理员表
				ErpFunCrossCompUserExample erpFunCrossCompUserExample = new ErpFunCrossCompUserExample();
				erpFunCrossCompUserExample.createCriteria().andUserIdEqualTo(param.getUserId()).andCompIdEqualTo(openCityManageParam.getCompId());
				erpFunCrossCompUserExample.setShardCityId(cityId);
				List<ErpFunCrossCompUser> erpFunCrossCompUserList = erpFunCrossCompUserMapper.selectByExample(erpFunCrossCompUserExample);
				if (erpFunCrossCompUserList.size() < 1) {
					ErpFunCrossCompUser insertErpFunCrossCompUser = new ErpFunCrossCompUser();
					insertErpFunCrossCompUser.setUserId(param.getUserId());
					if (erpFunComp.size() > 0) {
						insertErpFunCrossCompUser.setCityId(erpFunComp.get(0).getCityId().intValue());
					}
					insertErpFunCrossCompUser.setCompId(openCityManageParam.getCompId());
					insertErpFunCrossCompUser.setCreationTime(new Date());
					insertErpFunCrossCompUser.setDelFlag((byte)0);
					insertErpFunCrossCompUser.setShardCityId(cityId);
					erpFunCrossCompUserMapper.insertSelective(insertErpFunCrossCompUser);
				} else if (erpFunCrossCompUserList.get(0).getDelFlag() == 1) {
					ErpFunCrossCompUser erpFunCrossCompUser = new ErpFunCrossCompUser();
					erpFunCrossCompUser.setId(erpFunCrossCompUserList.get(0).getId());
					erpFunCrossCompUser.setDelFlag((byte)0);
					erpFunCrossCompUser.setUpdateTime(new Date());
					erpFunCrossCompUser.setShardCityId(cityId);
					erpFunCrossCompUserMapper.updateByPrimaryKeySelective(erpFunCrossCompUser);
				}
			}
		}
				
		ErpSystemSettingLogs erpSystemSettingLogs = new ErpSystemSettingLogs();
		erpSystemSettingLogs.setCompId(operator.getCompId().intValue());
		erpSystemSettingLogs.setShardCityId(operator.getCityId());
		erpSystemSettingLogs.setCreateDept(null);//operator.getDeptId()
		erpSystemSettingLogs.setSslType((byte)1);
		erpSystemSettingLogs.setModular(1);
		erpSystemSettingLogs.setCreateUid(operator.getUserId());
		erpSystemSettingLogs.setInfluenceUid(param.getUserId());
		erpSystemSettingLogs.setCreateTime(DateUtil.DateToString(new Date()));
		erpSystemSettingLogs.setLogContent("修改了跨城用户权限");
		erpSystemSettingLogsMapper.insertSelective(erpSystemSettingLogs);

	}

	/**
	 * 1. 跟房客源没有关系的目标组织查看 caseId可不传, queryOrgId要传
	 * 2. 具体房客源的查看 caseId要传, queryOrgId传房客源的orgId
	 **/
	@Override
	public boolean checkOperNewOrg(Integer cityId, Integer compId, Integer currUserId, Integer caseId, Byte caseType, String operId, Integer queryOrgId,boolean isSwitchCompLogin) {
		OrganizatQueryParam queryParam = this.checkOrgIdAndOperNewOrg(cityId, compId, currUserId, caseType, operId, queryOrgId,isSwitchCompLogin);
		// 不受限制,那就默认有权限
		if (queryParam != null && !queryParam.getLimit()) {
			return true;
		}

		if (caseId != null) {
			Integer caseOrganizationId = null;
			Integer caseUserId = null;

			switch (caseType) {
				case 1: {
					ErpFunSale condition = new ErpFunSale();
					condition.setShardCityId(cityId);
					condition.setSaleId(caseId);
					ErpFunSale erpFunSale = erpFunSaleMapper.selectByPrimaryKey(condition);
					caseOrganizationId = erpFunSale.getOrganizationId();
					caseUserId = erpFunSale.getUserId();
					break;
				}
				case 2: {
					ErpFunLease condition = new ErpFunLease();
					condition.setShardCityId(cityId);
					condition.setLeaseId(caseId);
					ErpFunLease erpFunLease = erpFunLeaseMapper.selectByPrimaryKey(condition);
					caseOrganizationId = erpFunLease.getOrganizationId();
					caseUserId = erpFunLease.getUserId();
					break;
				}
				case 3: {
					ErpFunBuyCustomer condition = new ErpFunBuyCustomer();
					condition.setShardCityId(cityId);
					condition.setBuyCustId(caseId);
					ErpFunBuyCustomer erpFunBuyCustomer = erpFunBuyCustomerMapper.selectByPrimaryKey(condition);
					caseOrganizationId = erpFunBuyCustomer.getOrganizationId();
					caseUserId = erpFunBuyCustomer.getUserId();
					break;
				}
				case 4: {
					ErpFunRentCustomerKey condition = new ErpFunRentCustomerKey();
					condition.setShardCityId(cityId);
					condition.setRentCustId(caseId);
					ErpFunRentCustomer erpFunRentCustomer = erpFunRentCustomerMapper.selectByPrimaryKey(condition);
					caseOrganizationId = erpFunRentCustomer.getOrganizationId();
					caseUserId = erpFunRentCustomer.getUserId();
					break;
				}
				default: {

				}
			}

			// 有限制, 但是能查看或者操作的所有组织ID包含了当前房源, 或者没有包含时, 当前人为房客源所属人
			return queryParam != null && queryParam.getLimit()
					&& ((CollectionUtils.isNotEmpty(queryParam.getQueryOrgIds()) && queryParam.getQueryOrgIds().contains(caseOrganizationId))
					|| (CollectionUtils.isEmpty(queryParam.getQueryOrgIds()) && currUserId.equals(caseUserId)));
		} else {
			return queryParam != null && queryParam.getLimit()
					&& (CollectionUtils.isNotEmpty(queryParam.getQueryOrgIds()) && queryParam.getQueryOrgIds().contains(queryOrgId));
		}
	}
	

	/**
	 * 根据权限名称查询某一个人的权限
	 * @author 方李骥
	 * @since 2016年9月2日
	 * @param cityId
	 * @param userId
	 * @param permissionName
	 * @return
	 */
	@Override
	public boolean judgePermissionBySwitchLogin(Integer cityId, Integer userId, String permissionName,boolean isSwitchCompLogin) {
		if (isSwitchCompLogin) {
			ErpUserOpers userOpers = erpUserOpersMapper.getUserOperByUserIdOperIdSwitchLogin(cityId, userId, permissionName);
			if(userOpers!=null){
				return true;
			}
		} else {
			ErpUserOpers userOpers = erpUserOpersMapper.selectPerPermissionByName(cityId, userId, permissionName);
			if(userOpers!=null){
				return true;
			}
		}
		return false;
	}
}





package com.myfun.erpWeb.managecenter.profit;

import com.myfun.erpWeb.managecenter.profit.param.*;
import com.myfun.erpWeb.managecenter.profit.vo.*;
import com.myfun.erpWeb.managecenter.sysmanager.vo.ErpCompRoleLevelsVO;
import com.myfun.erpWeb.usercenter.param.GetBaseWageListParam;
import com.myfun.erpWeb.usercenter.vo.ErpFunBasewageVo;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.framework.web.utils.PoConverterToView;
import com.myfun.repository.admindb.dao.AdminFunRecalculateWageInfoMapper;
import com.myfun.repository.admindb.po.AdminFunRecalculateWageInfo;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.ErpFunBasewageDto;
import com.myfun.repository.erpdb.dto.ErpFunRoleWageConfigDto;
import com.myfun.repository.erpdb.dto.ErpFunWageTypeNewDto;
import com.myfun.repository.erpdb.dto.ErpWagetypeUserRelativeDto;
import com.myfun.repository.erpdb.param.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.erpdb.po.ErpFunWageTypeNewExample.Criteria;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.admindb.AdminFunCompService;
import com.myfun.service.business.erpdb.*;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.DateUtil;
import com.myfun.utils.SortUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 薪资方案控制器
 * @author 张宏利
 * @since 2017年5月16日
 */
@Api(tags ="薪资方案模块")
@RestController
@RequestMapping(value="/managecenter/profit")
public class WageTypeController extends BaseController {
	
	@Autowired ErpFunBasewageService erpFunBasewageService;
	@Autowired ErpFunWageTypeNewService erpFunWageTypeNewService;
	@Autowired ErpFunUsersService erpFunUsersService;
	@Autowired ErpFunUsersMapper erpFunUsersMapper;
	@Autowired ErpWagetypeUserRelativeService erpWagetypeUserRelativeService;
	@Autowired ErpSalaryTypeRelativeMapper erpSalaryTypeRelativeMapper;
	@Autowired ErpFunSalaryTypeMapper erpFunSalaryTypeMapper;
	@Autowired ErpFunBasewageMapper erpFunBasewageMapper;
	@Autowired ErpWagetypeUserRelativeMapper erpWagetypeUserRelativeMapper;
	@Autowired ErpFunWageTypeNewMapper erpFunWageTypeNewMapper;
	@Autowired ErpFunCountwageMapper erpFunCountwageMapper;
	@Autowired ErpUserOpersMapper erpUserOpersMapper;
	@Autowired private ErpRoleWagetypeRelativeMapper erpRoleWagetypeRelativeMapper;
	@Autowired
	ErpFunWageConfigService erpFunWageConfigService;
	@Autowired
	ErpFunWageConfigMapper erpFunWageConfigMapper;
	@Autowired
	ErpSysParaMapper erpSysParaMapper;
	@Autowired
	ErpFunRoleWageConfigService erpFunRoleWageConfigService;
	@Autowired
	ErpFunRoleWageConfigMapper erpFunRoleWageConfigMapper;
	@Autowired
	ErpFunRoleWageWorkcountMapper erpFunRoleWageWorkcount;
	@Autowired
	ErpFunRoleWageProfitMapper erpFunRoleWageProfitMapper;
	@Autowired
	ErpFunAssessmentStatisticsMapper erpFunAssessmentStatisticsMapper;
	@Autowired
	AdminFunRecalculateWageInfoMapper adminFunRecalculateWageInfoMapper;
	@Autowired
	ErpCompRolesMapper erpCompRolesMapper;
	@Autowired
	ErpFunRoleLevelsMapper erpFunRoleLevelsMapper;
	@Autowired
	AdminFunCompService adminFunCompService;

	/**
	 * 应用提成方案
	 * @author 张宏利
	 * @since 2017年5月16日
	 * @param deptId 门店ID
	 * @param userPosition 角色
	 * @param wageTypeId 方案ID，把这个方案应用到这个门店的角色上，门店和角色都可能没传
	 * 
	 * 2019-08-01标记为弃用-陈文超
	 */
	@ApiOperation(value = "应用提成方案", httpMethod = "POST")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@NotBlank({"wageTypeId"})
	@RequestMapping("/updateWagetypeUserRelative")
	@Deprecated
	public ResponseJson updateWagetypeUserRelative(@RequestBody SaveSalaryPlanRelativeUserParam param) {
		
		param.setCityId(getOperator().getCityId());
		param.setCompId(getOperator().getCompId());
		param.setCurrentUserId(getOperator().getUserId());
		param.setCurrentDeptId(getOperator().getDeptId());
		ErpFunSalaryType erpFunSalaryType = null;
		if(param.getId()!=null){
			ErpFunSalaryType id = new ErpFunSalaryType();
			id.setShardCityId(param.getCityId());
			id.setId(param.getId());
			erpFunSalaryType = erpFunSalaryTypeMapper.selectByPrimaryKey(id);
			param.setRoleId(erpFunSalaryType.getRoleId());
		}
		List<ErpFunUsers> userList = erpFunUsersMapper.getUserListByRole(getOperator().getCityId(), param.getRoleId(), getOperator().getCompId(), null, null, null, null);
		erpFunBasewageService.updateWagetypeUserRelative(param, userList, erpFunSalaryType);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 重设提成方案
	 * @author flj
	 * @since 2017年11月17日
	 * @param salaryTypeId 薪资方案ID
	 * @param userId 员工id
	 */
	@RequestMapping("/resetWagetypeUserRelativeOffUserId")
	public ResponseJson resetWagetypeUserRelativeOffUserId(@RequestBody BaseMapParam param) {
		Integer adminCompId = getOperator().getAdminCompId();
//		Integer salaryTypeId = param.getInteger("salaryTypeId");
		Integer userId = param.getInteger("userId");
		Integer compId = param.getInteger("compId");
		Integer cityId = param.getInteger("cityId");
		ErpFunUsers userInfoByUserId = erpFunUsersMapper.getUserInfoByUserId(cityId, userId);

		String wageAccountingDay = erpSysParaMapper.getParamValue(cityId, compId, "WAGE_ACCOUNTING_DAY");
		String assessMentMonth = DateUtil.getAssessMentMonth(wageAccountingDay, 0);

		// 新建员工获取角色变更会重新配置员工考核信息
		ErpFunRoleWageConfigExample erpFunRoleWageConfigExample = new ErpFunRoleWageConfigExample();
		erpFunRoleWageConfigExample.setShardCityId(cityId);
		erpFunRoleWageConfigExample.createCriteria().andCompIdEqualTo(compId).andRoleIdEqualTo(userInfoByUserId.getUserPosition()).
				andIsCheckEqualTo((byte)1).andAssessmentMonthEqualTo(assessMentMonth);
		List<ErpFunRoleWageConfig> roleWageConfigList = erpFunRoleWageConfigMapper.selectByExample(erpFunRoleWageConfigExample);
		if(roleWageConfigList.size() == 0) {
			// 删除考核统计
//			ErpFunAssessmentStatistics erpFunAssessmentStatistics = new ErpFunAssessmentStatistics();
//			erpFunAssessmentStatistics.setDealFlag((byte)1);
//			ErpFunAssessmentStatisticsExample erpFunAssessmentStatisticsExample = new ErpFunAssessmentStatisticsExample();
//			erpFunAssessmentStatisticsExample.setShardCityId(cityId);
//			erpFunAssessmentStatisticsExample.createCriteria().andCompIdEqualTo(compId).andUserIdEqualTo(userId).andAssessmentMonthEqualTo(assessMentMonth);
//			erpFunAssessmentStatisticsMapper.updateByExampleSelective(erpFunAssessmentStatistics, erpFunAssessmentStatisticsExample);
			return ErpResponseJson.ok();
		}

		ErpFunRoleWageConfig erpFunRoleWageConfig = roleWageConfigList.get(0);
		// 更新考勤统计数据
		erpFunAssessmentStatisticsMapper.updateAssessmentStatistic(cityId, compId, userId, assessMentMonth, erpFunRoleWageConfig.getId(), userInfoByUserId.getUserPosition());
		// 新增提一条关联关系
		ErpSalaryTypeRelative erpSalaryTypeRelative = new ErpSalaryTypeRelative();
		erpSalaryTypeRelative.setShardCityId(cityId);
		erpSalaryTypeRelative.setUserId(userId);
		erpSalaryTypeRelative.setRoleId(userInfoByUserId.getUserPosition());
		erpSalaryTypeRelative.setRegId(userInfoByUserId.getRegId());
		erpSalaryTypeRelative.setGrId(userInfoByUserId.getGrId());
		erpSalaryTypeRelative.setCreationTime(new Date());
		erpSalaryTypeRelative.setDeptId(userInfoByUserId.getDeptId());
		erpSalaryTypeRelative.setAreaId(userInfoByUserId.getAreaId());
		erpSalaryTypeRelative.setSalaryTypeId(erpFunRoleWageConfig.getId());
		erpSalaryTypeRelative.setCompId(compId);

		erpSalaryTypeRelativeMapper.insertSelective(erpSalaryTypeRelative);
		// 重新计算薪资

		AdminFunRecalculateWageInfo adminFunRecalculateWageInfo = new AdminFunRecalculateWageInfo();
		adminFunRecalculateWageInfo.setAssessmentMonth(assessMentMonth);
		adminFunRecalculateWageInfo.setCreationTime(new Date());
		adminFunRecalculateWageInfo.setRoleId(userInfoByUserId.getUserPosition());
		adminFunRecalculateWageInfo.setUserId(userId);
		adminFunRecalculateWageInfo.setCompId(compId);
		adminFunRecalculateWageInfo.setCityId(cityId);
		if(adminFunCompService.judgerIsFangjidi(adminCompId)){
			adminFunRecalculateWageInfo.setCustomizedType(1);
		}
		try {
			adminFunRecalculateWageInfoMapper.insertSelective(adminFunRecalculateWageInfo);
			// 这里加了数据库唯一锁  所以try一下
		}catch (Exception e) {

		}

		return ErpResponseJson.ok();
	}
	
	/**
	 * 获取薪资方案列表，按员工获取
	 * @author 张宏利
	 * @since 2017年5月16日
	 * @param deptId 门店ID
	 * @param userId 用户ID
	 */
	@ApiOperation(value = "获取薪资方案列表按员工获取", httpMethod = "POST")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@PostMapping("/getSalarySchemeListByUser")
	public ResponseJson getSalarySchemeListByUser(@Valid @RequestBody SalarySchemeListByUserParam param) {
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		param.setCityId(cityId);
		param.setCompId(compId);
		Integer deptId = param.getDeptId();
		Integer userId = param.getUserId();
		String roleId = param.getRoleId();
		// 获取基本薪资
		String startTime = DateTimeHelper.formatDatetoString(new Date());
		//判断当前登录人是否是薪资管理人员或者是总经理，满足可以查看全部，否则只能查看自己应用的（分配给自己的应用提成方案）
		boolean isGeneralManager = getOperator().isGeneralManager();
		//查询薪资管理人员
		ErpUserOpers wageConfigAuthority = null;
		wageConfigAuthority = erpUserOpersMapper.selectPerPermissionByName(cityId, userId, "FUN_WAGE_CONFIG");
		if (getOperator().isSwitchCompLogin()) {
			wageConfigAuthority = erpUserOpersMapper.getUserOperByUserIdOperIdSwitchLogin(cityId, userId, "FUN_WAGE_CONFIG");
		}
//		Integer salayManagerUserId = erpFunUsersMapper.selectSalaryManager(cityId,compId);
		boolean queryJurisdictionFlag = isGeneralManager || (null != wageConfigAuthority);
		List<ErpFunBasewageDto> funBasewageList = erpFunBasewageMapper.getUserBasewage(cityId, compId, deptId, userId, startTime , roleId);
		// 获取到业绩类别
		Set<Integer> userIdSet = funBasewageList.stream().collect(Collectors.mapping(ErpFunBasewageDto::getUserId, Collectors.toSet()));
		Integer[] userIds = userIdSet.toArray(new Integer[]{});
		// 获取薪资考核方案
		if (userIds != null && userIds.length > 0) {
			List<ErpSalaryTypeRelative> salaryTypeRelativeList = erpSalaryTypeRelativeMapper.getSalaryTypeByUserIds(cityId, userIds);
			Map<Integer, ErpSalaryTypeRelative> salaryTypeRelativeMap = salaryTypeRelativeList.stream().collect(Collectors.toMap(ErpSalaryTypeRelative::getUserId, val -> val));
			List<ErpFunSalaryType> salaryTypeList = erpFunSalaryTypeMapper.getSalaryTypeByCompId(cityId, compId);
			Map<Integer, ErpFunSalaryType> salaryTypeMap = salaryTypeList.stream().collect(Collectors.toMap(ErpFunSalaryType::getId, val -> val));
			List<ErpWagetypeUserRelativeDto> relativeDtoList = erpWagetypeUserRelativeMapper.getUserWageTypeList(cityId, userIds, null);
			Map<Integer, List<ErpWagetypeUserRelativeDto>> relativeDtoMap = relativeDtoList.stream().collect(Collectors.groupingBy(ErpWagetypeUserRelativeDto::getUserId));
			// 依据类型设置佣金类型中文
			for (ErpFunBasewageDto erpFunBasewageDto : funBasewageList) {
				Integer baseWageUserId = erpFunBasewageDto.getUserId();
				List<ErpWagetypeUserRelativeDto> userRelativeDtoList = relativeDtoMap.get(erpFunBasewageDto.getUserId());
				if(userRelativeDtoList != null) {
					for (ErpWagetypeUserRelativeDto userRelativeDto : userRelativeDtoList) {
						setPerformance(erpFunBasewageDto, userRelativeDto);
					}
				}
				// 设置薪资考核方案
				ErpSalaryTypeRelative salaryTypeRelative = salaryTypeRelativeMap.get(erpFunBasewageDto.getUserId());
				if(salaryTypeRelative != null) {
					ErpFunSalaryType funSalaryType = salaryTypeMap.get(salaryTypeRelative.getSalaryTypeId());
					if(funSalaryType != null) {
						erpFunBasewageDto.setSalaryTypeId(funSalaryType.getId());
						erpFunBasewageDto.setSalaryTypeName(funSalaryType.getSalaryTypeName());
					}
				}
				//权限判断
				if (!(getOperator().getUserId().equals(baseWageUserId) || queryJurisdictionFlag)) {
					erpFunBasewageDto.setBaseMoney("****");
				}
			}
			SortUtil.collectionsSort(funBasewageList, new String[]{"deptId", "userId"}, true);
		}
		return ErpResponseJson.ok(funBasewageList);
	}
	
	/**
	 * 获取薪资方案列表，按业务类型获取
	 * @author 张宏利
	 * @since 2017年5月16日
	 * @param performanceType 业绩类别，0=总业绩 1=过户 2=二手佣金 3=新房佣金 4=租赁租金 5=金融
	 * @param wageTypeId 方案ID
	 */
	@ApiOperation(value = "薪资方案列表按业务类型获取", httpMethod = "POST")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = SalarySchemeListByTypeVo.class, message = "成功")
	})
	@RequestMapping("/getSalarySchemeListByType")
	public ResponseJson getSalarySchemeListByType(@Valid @RequestBody SalarySchemeListByTypeParam param) {
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		Integer userId = getOperator().getUserId();
		Integer managePlan = param.getManagePlan();
		Integer performanceType = param.getPerformanceType();
		String wageTypeName = param.getWageTypeName();
		if (StringUtils.isNotBlank(wageTypeName)) {
			wageTypeName = "%" + wageTypeName + "%";
		}
		//判断当前登录人是否是薪资管理人员或者是总经理，满足可以查看全部，否则只能查看自己应用的（分配给自己的应用提成方案）
		boolean isGeneralManager = getOperator().isGeneralManager();
		//查询薪资管理人员
//		Integer salayManagerUserId = erpFunUsersMapper.selectSalaryManager(cityId,compId);
		// 薪资配置权
		ErpUserOpers wageConfigAuthority = erpUserOpersMapper.selectPerPermissionByName(cityId, userId, "FUN_WAGE_CONFIG");
		boolean queryJurisdictionFlag = isGeneralManager || (null != wageConfigAuthority);
		List<ErpFunWageTypeNew> wageTypeList = null;
		if (queryJurisdictionFlag) {
			ErpFunWageTypeNewExample example = new ErpFunWageTypeNewExample();
			Criteria criteria = example.createCriteria().andCompIdEqualTo(compId).andIsCheckEqualTo((byte)1);
			if (performanceType != null) {
				criteria.andPerformanceTypeEqualTo(performanceType.byteValue());
			}
			if (managePlan != null) {
				criteria.andManagePlanEqualTo(managePlan.byteValue());
			}
			if (StringUtils.isNotBlank(wageTypeName) ) {
				criteria.andWageTypeNameLike(wageTypeName);
			}
			example.setShardCityId(cityId);
			example.setOrderByClause("WAGE_TYPE_NAME asc,PERFORMANCE_TYPE asc");
			wageTypeList = erpFunWageTypeNewMapper.selectByExample(example);
		} else {
			//没有权限，查看自己应用的方案
			wageTypeList = erpFunWageTypeNewMapper.selectMyWageTypeList(cityId, compId, userId, managePlan, performanceType, wageTypeName);
		}
		return ErpResponseJson.ok(wageTypeList);
	}
	
	/**
	 * 获取薪资方案分配的员工列表
	 * @author 张宏利
	 * @since 2017年5月16日
	 * @param wageTypeId 薪资方案ID
	 */
	@ApiOperation(value = "获取薪资方案分配的员工列表", httpMethod = "POST")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = SalarySchemeUserListVo.class, message = "成功")
	})
	@RequestMapping("/getSalarySchemeUserList")
	public ResponseJson getSalarySchemeUserList(@Valid @RequestBody SalarySchemeUserListParam param) {
		Integer wageTypeId = param.getWageTypeId();
		List<ErpWagetypeUserRelativeDto> resultList = erpWagetypeUserRelativeMapper.getUserWageTypeList(getOperator().getCityId(), null, wageTypeId);
		return ErpResponseJson.ok(resultList);
	}
	
	/**
	 * 删除薪资方案
	 * @author 张宏利
	 * @since 2017年5月16日
	 * @param wageTypeId 薪资方案ID
	 */
	@ApiOperation(value = "删除薪资方案", httpMethod = "POST")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@RequestMapping("/deleteSalaryScheme")
	public ResponseJson deleteSalaryScheme(@Valid @RequestBody SalarySchemeUserListParam param) {
		Operator operator = getOperator();
		Integer wageTypeId = param.getWageTypeId();
		erpFunBasewageService.deleteSalaryScheme(operator.getCityId(), operator.getCompId(), wageTypeId);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 获取薪资提成方案名称列表
	 * @author 方李骥
	 * @since 2017年5月18日
	 * @param wageTypeId 薪资方案ID
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "获取薪资提成方案名称列表", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = GetSalaryPlanNameListVo.class, message = "成功")
    })
	@RequestMapping("/getSalaryPlanNameList")
	public ResponseJson getSalaryPlanNameList(@RequestBody SalaryPlanNameListParam param) {
		List<ErpFunWageTypeNew> resultList = erpFunWageTypeNewMapper.selectWageTypeNewListByComp(getOperator().getCityId(), getOperator().getCompId());
		return ErpResponseJson.ok(resultList);
	}
	
	/**
	 * 获取提成方案列表
	 * @author 方李骥
	 * @since 2017年5月18日
	 * @param wageTypeId 薪资方案ID
	 * @return
	 * @throws Exception
	 */
    @ApiOperation(value = "获取提成方案详情",httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = GetWageTypeDetailVo.class, message = "成功")
    })
	@RequestMapping("/getWageTypeDetail")
	@NotBlank("wagetypeId")
	public ResponseJson getWageTypeDetail(@Valid @RequestBody GetWageTypeDetailParam param) {
		String wagetypeIds = param.getWagetypeId();
		List<String> wagetypeIdList = new ArrayList<>();
		if (wagetypeIds.contains(",")){
			wagetypeIdList = Arrays.asList(wagetypeIds.split(","));
		}else{
			wagetypeIdList.add(wagetypeIds);
		}
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		Integer userId = getOperator().getUserId();
		//Map<String, Object> resultMap = new HashMap<>();
		//判断当前登录人是否是薪资管理人员或者是总经理，满足可以查看全部，否则只能查看自己应用的（分配给自己的应用提成方案）
		boolean isGeneralManager = getOperator().isGeneralManager();
		//查询薪资管理人员
		ErpUserOpers wageConfigAuthority = erpUserOpersMapper.selectPerPermissionByName(cityId, userId, "FUN_WAGE_CONFIG");
		boolean queryJurisdictionFlag = isGeneralManager || (null != wageConfigAuthority);
		//Integer.parseInt(wagetypeIdList.get(0)) 通级别，一个都没权限，其余的也无
		Integer wageTypeUserId = erpWagetypeUserRelativeMapper.selectWageTypeByWageTypeIdAndUserId(cityId,compId,Integer.parseInt(wagetypeIdList.get(0)),userId);
		if (!queryJurisdictionFlag && !(userId.equals(wageTypeUserId))) {
			//查询改该应用方案本人是否应用了改应用方案
			throw new BusinessException("您没有权限查看该提成方案!");
		}

		List<ErpFunWageTypeNew> erpFunWageTypeNew = erpFunWageTypeNewMapper.getMyWageTypeListByIds(cityId,compId,wagetypeIdList);
		List<ErpFunCountwage> countWageList = erpFunCountwageMapper.getFunCountwageListByWageTypeIds(getOperator().getCityId(), getOperator().getCompId(), wagetypeIdList);
		WageTypeDetailVo  wageTypeDetailVo = new WageTypeDetailVo();
		wageTypeDetailVo.setWageType(erpFunWageTypeNew);
		wageTypeDetailVo.setCountList(countWageList);
		return ErpResponseJson.ok(wageTypeDetailVo);
	}
	
	/**
	 * 获取基本薪资列表
	 * @author 方李骥
	 * @since 2017年5月17日
	 * @param deptId 门店ID
	 * @param userPosition 角色
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "获取基本薪资列表", httpMethod = "POST")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunBasewageVo.class, message = "成功")
	})
	@RequestMapping("/getBaseWageList")
	public ResponseJson getBaseWageList(@Valid @RequestBody GetBaseWageListParam param) {
		param.setCompId(getOperator().getCompId());
		Integer deptId = param.getDeptId();
		String userPosition = param.getRoleId();
		Calendar calendar = Calendar.getInstance();
		String nowTime = DateTimeHelper.formatDateTimetoString(calendar.getTime(), DateTimeHelper.FMT_yyyyMMddHHmmssS);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		String startTime = DateTimeHelper.formatDateTimetoString(calendar.getTime(),DateTimeHelper.FMT_yyyyMMdd);
		//查询基本工资列表
		List<ErpFunBasewageDto> resultList = erpFunBasewageMapper.getBaseWageList(getOperator().getCityId(),getOperator().getCompId(), deptId,userPosition,startTime,nowTime);
		/*if(list==null||list.isEmpty()){
			return list;
		}
		//加入门店ID
		Set<Integer> deptIds = new HashSet<Integer>();
		Set<Integer> userIds = new HashSet<Integer>(); 
		for(ErpFunBasewageDto dto:list){
			deptIds.add(dto.getDeptId());
			if("1".equals(dto.getChangeDeptFlag())){
				userIds.add(dto.getUserId());
			}
		}
		//查询员工异动列表
		List<ErpFunChangeUsersDto> changeUserList = erpFunUsersMapper.getChangeUsersNewDeptIds(cityId,compId,userIds);
		Map<Object,ErpFunChangeUsersDto> changeUserMap = BeanUtilsHelper.listToMapObjectOffKeyType(changeUserList, "userId");
		for(ErpFunChangeUsersDto dto:changeUserList){
			deptIds.add(dto.getDeptId());
		}
		List<ErpFunDepts> deptList = erpFunDeptsMapper.getDeptListByDeptIds(cityId, deptIds);
		Map<Object,ErpFunDepts> deptMap = BeanUtilsHelper.listToMapObjectOffKeyType(deptList, "deptId");
		for(ErpFunBasewageDto dto:list){
			Integer onceDeptId = dto.getDeptId();
			ErpFunDepts onceDept = deptMap.get(onceDeptId);
			if(onceDept!=null){
				dto.setOnceDeptName(onceDept.getDeptCname());
			}
			if("1".equals(dto.getChangeDeptFlag())){
				ErpFunChangeUsersDto changeUsersDto = changeUserMap.get(dto.getUserId());
				if(changeUsersDto!=null){
					Integer nowDeptId = changeUsersDto.getDeptId();
					ErpFunDepts nowDept = deptMap.get(nowDeptId);
					if(nowDept!=null){
						dto.setNowDeptName(nowDept.getDeptCname());
					}
				}
			}
		}*/
		return ErpResponseJson.ok(resultList);
	}
	
	/**
	 * 保存基本薪资
	 * @author 张宏利	
	 * @since 2017年5月16日
	 * @param wageTypeId 薪资方案ID
	 * @return
	 * @throws Exception
	 */
    @ApiOperation("保存基本薪资")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
	@RequestMapping("/updateBaseWage")
	@NotBlank({"baseWageJson"})
	public ResponseJson updateBaseWage(@Valid @RequestBody UpdateBaseWageParam param) throws Exception {
		String baseWageJson = param.getBaseWageJson();
		erpFunBasewageService.updateBaseWage(getOperator().getCityId(), getOperator().getCompId(), baseWageJson);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 新增或者更新提成方案
	 * @author 方李骥	
	 * @since 2017年5月16日
	 * @param wageTypeId 薪资方案ID
	 * @return
	 * @throws Exception
	 */
    @ApiOperation("新增或者更新提成方案")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
	@RequestMapping("/insertOrUpdateWageType")
	public ResponseJson insertOrUpdateWageType(@Valid @RequestBody CreateOrUpdateWageTypeNewParam param) throws Exception {
		param.setDeptId(getOperator().getDeptId());
		param.setCityId(getOperator().getCityId());
		param.setCompId(getOperator().getCompId());
		erpFunWageTypeNewService.insertOrUpdateWageType(param);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 设置薪资管理人员
	 * @author 方李骥	
	 * @since 2017年5月16日
	 * @param wageTypeId 薪资方案ID
	 * @return
	 * @throws Exception
	 */
    @ApiOperation("设置薪资管理人员")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
	@NotBlank({"userId"})
	@RequestMapping("/setSalaryPlanManager")
	public ResponseJson setSalaryPlanManager(@Valid @RequestBody SetSalaryPlanManagerParam param) {
		Integer userId = param.getUserId();
		param.setCityId(getOperator().getCityId());
		param.setCompId(getOperator().getCompId());
		erpFunUsersService.setSalaryPlanManager(param,userId);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 
	 * @author 方李骥	
	 * @since 2017年5月16日
	 * @param wageTypeId 薪资方案ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/setSalaryPlanForUsers")
	@NotBlank({"wagetypeId","userIds"})
	public ResponseJson setSalaryPlanUsers(@Valid @RequestBody BaseMapParam param) throws Exception {
		Integer wageTypeId = param.getInteger("wageTypeId");
		String userIds = param.getString("userIds");
		return ErpResponseJson.ok();
	}
/*	*//**
	 * 获取公司的提成方案
	 * @author 方李骥	
	 * @since 2017年5月16日
	 * @param wageTypeId 薪资方案ID
	 * @return
	 * @throws Exception
	 *//*
	@RequestMapping("/getSalaryPlanByComp")
	public ResponseJson getSalaryPlanByPerformanceType(@Valid @RequestBody BaseMapParam param) throws Exception {
		List<ErpFunWageTypeNew> list = erpFunWageTypeNewService.getSalaryPlanByComp(getOperator().getCityId(),getOperator().getCompId());
		return ErpResponseJson.ok(list);
	}*/
	
	/**
	 * 获取某一个员工的薪资方案
	 * @author 方李骥	
	 * @since 2017年5月16日
	 * @param wageTypeId 薪资方案ID
	 * @return
	 * @throws Exception
	 */
    @ApiOperation("获取某一个员工的薪资方案")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
	@NotBlank({"userId"})
	@RequestMapping("/getUserSalaryPlanList")
	public ResponseJson getUserSalaryPlanList(@Valid @RequestBody GetUserSalaryPlanListParam param) {
		Integer userId = param.getUserId();
		List<Map<String,Object>> list = erpWagetypeUserRelativeMapper.getSalaryPlanByUserId(getOperator().getCityId(),getOperator().getCompId(),userId);
		// 拼薪资考核方案
		Map<String, Object> salaryTypeMap = erpSalaryTypeRelativeMapper.getSalaryTypeAndNameByUserId(getOperator().getCityId(), userId);
		list.add(salaryTypeMap);
		return ErpResponseJson.ok(list);
	}
	
	/**
	 * 设置或者管理业绩更新员工的薪资方案
	 * @author 方李骥	
	 * @since 2017年5月19日
	 * @param wageTypeId 薪资方案ID
	 * @return
	 * @throws Exception
	 */
    @ApiOperation("设置或者管理业绩更新员工的薪资方案")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
	@RequestMapping("/insertOrUpdateUserSalaryPlan")
	@NotBlank({"userId","baseWage"})
	public ResponseJson insertOrUpdateUserSalaryPlan(@Valid @RequestBody CreateOrUpdateUserSalaryPlanParam param) {
		ErpFunUsers funUsers = erpFunUsersMapper.getUserInfoByUserId(getOperator().getCityId(), param.getUserId());
		erpWagetypeUserRelativeService.insertOrUpdateUserSalaryPlan(getOperator().getCityId(),
				getOperator().getCompId(), param, funUsers);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 查询一个薪资方案的分配的员工列表
	 * @author 方李骥	
	 * @since 2017年5月19日
	 * @param wageTypeId 薪资方案ID
	 * @return
	 * @throws Exception
	 */
    @ApiOperation("查询一个薪资方案的分配的员工列表")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
	@RequestMapping("/getOneSalaryPlanUserList")
	@NotBlank({"wagetypeId"})
	public ResponseJson getOneSalaryPlanUserList(@Valid @RequestBody GetOneSalaryPlanUserListParam param){
		Integer wageTypeId = param.getWagetypeId();
		Integer deptId = param.getDeptId();
		String userRole = param.getUserRole();
		Calendar calendar = Calendar.getInstance();
		String nowTime = DateTimeHelper.formatDateTimetoString(calendar.getTime(), DateTimeHelper.FMT_yyyyMMddHHmmssS);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		String startTime = DateTimeHelper.formatDateTimetoString(calendar.getTime(),DateTimeHelper.FMT_yyyyMMdd);
		List<Map<String,Object>> list = erpWagetypeUserRelativeMapper.getOneSalaryPlanUserList(getOperator().getCityId(),getOperator().getCompId(), wageTypeId, deptId, userRole, startTime, nowTime);
		return ErpResponseJson.ok(list);
	}
	
	/**
	 * 为一个薪资方案分配到具体员工
	 * @author 方李骥	
	 * @since 2017年5月19日
	 * @param wageTypeId 薪资方案ID
	 * @return
	 * @throws Exception
	 */
    @ApiOperation("一个薪资方案分配到具体员工")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
	@RequestMapping("/saveOneSalaryPlanRelativeUser")
	@NotBlank({"salaryPlanuserJson"})
	public ResponseJson saveOneSalaryPlanRelativeUser(@Valid @RequestBody SaveOneSalaryPlanRelativeUserParam param) throws Exception {
		String salaryPlanUserJson = param.getSalaryPlanuserJson();
		Integer wageTypeId = param.getWageTypeId();
		String royaltyRange = param.getRoyaltyRange();
		String delUsers = param.getDelUsers();
		erpWagetypeUserRelativeService.saveOneSalaryPlanRelativeUser(getOperator().getCityId(),getOperator().getCompId(),wageTypeId, royaltyRange, salaryPlanUserJson,delUsers);
		return ErpResponseJson.ok();
	}
	
	private void setPerformance(ErpFunBasewageDto erpFunBasewageDto, ErpWagetypeUserRelativeDto userRelativeDto){
		if(erpFunBasewageDto == null || userRelativeDto == null) {
			return;
		}
		String wageTypeName = userRelativeDto.getWageTypeName();
		String wageTypeId = userRelativeDto.getWageTypeId();
		Integer performanceType = userRelativeDto.getPerformanceType();
		// 业绩类别，0=总业绩 1=过户 2=二手佣金 3=新房佣金 4=租赁租金 5=金融
		if(userRelativeDto.getManagePlan() != null && userRelativeDto.getManagePlan() == 0) {// 业务业绩类型
			if(performanceType == null || performanceType == 0) {
				erpFunBasewageDto.setTotalPerformanceName(wageTypeName);
				erpFunBasewageDto.setTotalPerformanceId(wageTypeId);
			} else if(performanceType == 1) {
				erpFunBasewageDto.setTransferPerformanceName(wageTypeName);
				erpFunBasewageDto.setTransferPerformanceId(wageTypeId);
			} else if(performanceType == 2) {
				erpFunBasewageDto.setSecondhandPerformanceName(wageTypeName);
				erpFunBasewageDto.setSecondhandPerformanceId(wageTypeId);
			} else if(performanceType == 3) {
				erpFunBasewageDto.setNewhousePerformanceName(wageTypeName);
				erpFunBasewageDto.setNewhousePerformanceId(wageTypeId);
			} else if(performanceType == 4) {
				erpFunBasewageDto.setLeasePerformanceName(wageTypeName);
				erpFunBasewageDto.setLeasePerformanceId(wageTypeId);
			} else if(performanceType == 5) {
				erpFunBasewageDto.setFinancePerformanceName(wageTypeName);
				erpFunBasewageDto.setFinancePerformanceId(wageTypeId);
			}
		} else {// 管理业绩类型
			if(performanceType == null || performanceType == 0) {
				erpFunBasewageDto.setMgTotalPerformanceName(wageTypeName);
				erpFunBasewageDto.setMgTotalPerformanceId(wageTypeId);
			} else if(performanceType == 1) {
				erpFunBasewageDto.setMgTransferPerformanceName(wageTypeName);
				erpFunBasewageDto.setMgTransferPerformanceId(wageTypeId);
			} else if(performanceType == 2) {
				erpFunBasewageDto.setMgSecondhandPerformanceName(wageTypeName);
				erpFunBasewageDto.setMgSecondhandPerformanceId(wageTypeId);
			} else if(performanceType == 3) {
				erpFunBasewageDto.setMgNewhousePerformanceName(wageTypeName);
				erpFunBasewageDto.setMgNewhousePerformanceId(wageTypeId);
			} else if(performanceType == 4) {
				erpFunBasewageDto.setMgLeasePerformanceName(wageTypeName);
				erpFunBasewageDto.setMgLeasePerformanceId(wageTypeId);
			} else if(performanceType == 5) {
				erpFunBasewageDto.setMgFinancePerformanceName(wageTypeName);
				erpFunBasewageDto.setMgFinancePerformanceId(wageTypeId);
			}
		}
	}
	@RequestMapping("/getSalaryTypeRoleList")
	public ResponseJson getSalaryTypeRoleList(@Valid @RequestBody BaseMapParam param) throws Exception{
		List<Map<String,Object>> list = erpFunSalaryTypeMapper.getSalaryTypeNameList(getOperator().getCityId(),getOperator().getCompId());
		return ErpResponseJson.ok(list);
		
	}

	@RequestMapping("/getSalaryTypeRoleDetail")
	public ResponseJson getSalaryTypeRoleDetail(@Valid @RequestBody BaseMapParam param) throws Exception{
		String roleId = param.getString("roleId");
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		ErpFunSalaryType detailData = erpFunSalaryTypeMapper.selectSalaryTypeByRoleId(cityId ,compId , roleId);
		List<Map<String,Object>> returnList = null;
		Map<String,Object> returnMap = null;
		if(detailData!=null){
			returnMap = BeanUtil.objToMapObject(detailData);
			List<Map<String,Object>> wageTypeData = erpRoleWagetypeRelativeMapper.selectBySalaryId(getOperator().getCityId(),getOperator().getCompId(),detailData.getId());
			if (returnMap != null) {
				if (wageTypeData != null) {
					returnMap.put("roleRelative", wageTypeData);
					returnList = new ArrayList<>(); 
					returnList.add(returnMap);  
				}
			}
		}
		return ErpResponseJson.ok(returnList);
	}


	/**
	 * @Title 更新薪资配置
	 * @Author lcb
	 * @Date 2018/1/4
	 * @Param
	 **/
	@PostMapping("/updateWageConfig")
	public ResponseJson updateWageConfig(@RequestBody ErpFunWageConfigParam param) {
		Operator operator = getOperator();
		Integer res = erpFunWageConfigService.updateWageConfig(operator.getCityId(), operator.getCompId(), operator.getUserId(), param);
		return ErpResponseJson.ok(res);
	}


	/**
	 * @Title 获取基础薪资配置方案
	 * @Author lcb
	 * @Date 2018/1/4
	 * @Param
	 **/
	@ApiOperation(value = "获取基础薪资配置方案", httpMethod = "POST")
	@ApiResponses({@ApiResponse(code = 200,response = ErpFunWageConfig.class,message = "success")})
	@RequestMapping("/getWageConfig")
	public ResponseJson getWageConfig(@RequestBody ErpFunWageConfigParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();

		ErpFunWageConfig erpFunWageConfig = erpFunWageConfigMapper.selectThisMonthConfig(cityId, compId);

		return ErpResponseJson.ok(erpFunWageConfig);
	}

	/**
	 * @Title 修改角色薪资方案考核配置
	 * @Author lcb
	 * @Date 2018/1/5
	 * @Param
	 **/
	@ApiOperation(value = "修改角色薪资方案考核配置", httpMethod = "POST")
	@ApiResponses({@ApiResponse(code = 200, response = RoleWageConfigVo.class, message = "success")})
	@RequestMapping("/updateRoleWageConfig")
	public ResponseJson updateRoleWageConfig(@RequestBody RoleWageConfigParam roleWageConfigParam) {
		Operator operator = getOperator();
		boolean newOrganizationType = operator.newOrganizationType();
		Integer adminCompId = operator.getAdminCompId();
		Integer roleWageConfigId = null;
		if(newOrganizationType) {
			roleWageConfigId = erpFunRoleWageConfigService.updateRoleWageConfigNewOrg(adminCompId, operator.getCityId(), operator.getCompId(), operator.getUserId(), roleWageConfigParam);
		}else {
			roleWageConfigId = erpFunRoleWageConfigService.updateRoleWageConfig(adminCompId, operator.getCityId(), operator.getCompId(), operator.getUserId(), roleWageConfigParam);
		}
		RoleWageConfigVo res = new RoleWageConfigVo();
		res.setWageConfigId(roleWageConfigId);
		return ErpResponseJson.ok(res);
	}

	/**
	 * @throws Exception 
	 * @Title 获取角色薪资方案考核配置
	 * @Author lcb
	 * @Date 2018/1/5
	 * @Param
	 **/
	@ApiOperation(value = "获取角色薪资方案考核配置",httpMethod = "POST")
	@ApiResponses({@ApiResponse(code = 200, response = ErpFunRoleWageConfigDto.class, message = "success")})
	@RequestMapping("/getRoleWageConfig")
	public ResponseJson getRoleWageConfig(@RequestBody WageConfigParam param) throws Exception {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		String roleId = param.getRoleId();
		Integer roleLevelId = param.getRoleLevelId();//职级ID
		
		ErpFunRoleWageConfigDto erpFunRoleWageConfig = new ErpFunRoleWageConfigDto();
		//PARAM_VALUE 普通管控默认值
		String wageAccountingDay = erpSysParaMapper.getParamValue(cityId, compId, "WAGE_ACCOUNTING_DAY");
		String assessMentMonth = DateUtil.getAssessMentMonth(wageAccountingDay, 0);
		ErpCompRoles erpCompRoles = erpCompRolesMapper.getByRoleId(cityId,compId,param.getRoleId());
		
		//如果职级ID不为0或者空则先查询职级对应的配置，没有数据时再查询一次基本配置
		erpFunRoleWageConfig = erpFunRoleWageConfigService.getRoleWageConfigInfo(cityId, compId, roleId, roleLevelId, assessMentMonth);
		//展示业务人员和管理人员的薪资配置
		if (null != erpFunRoleWageConfig) {
			//查询出对应的职级集合
			ErpFunRoleWageConfigExample roleWageConfigExample = new ErpFunRoleWageConfigExample();
			roleWageConfigExample.setShardCityId(cityId);
			roleWageConfigExample.createCriteria().andCompIdEqualTo(compId).andAssessmentMonthEqualTo(assessMentMonth).andRoleIdEqualTo(roleId).andIsCheckEqualTo((byte)1);
			List<ErpFunRoleWageConfig> erpFunRoleWageConfigs = erpFunRoleWageConfigMapper.selectByExample(roleWageConfigExample);
			if(erpFunRoleWageConfigs != null && !erpFunRoleWageConfigs.isEmpty()){
				Map<Integer, ErpFunRoleWageConfig> tmpWageConfigMap = new HashMap<Integer, ErpFunRoleWageConfig>();
				for(ErpFunRoleWageConfig tmpWageConfig : erpFunRoleWageConfigs){
					//不为空切不是基本薪资配置的才放入集合
					if(tmpWageConfig.getRoleLevelId() != null && tmpWageConfig.getRoleLevelId() > 0){
						tmpWageConfigMap.put(tmpWageConfig.getRoleLevelId(), tmpWageConfig);
					}
				}
				Set<Integer> roleLevelIds = erpFunRoleWageConfigs.stream().collect(Collectors.mapping(ErpFunRoleWageConfig::getRoleLevelId, Collectors.toSet()));
				ErpFunRoleLevelsExample roleLevelExample = new ErpFunRoleLevelsExample();
				roleLevelExample.setShardCityId(cityId);
				roleLevelExample.createCriteria().andRoleLevelStatusEqualTo((byte)1).andCompIdEqualTo(compId).andRoleLevelIdIn(roleLevelIds.stream().collect(Collectors.toList()));
				List<ErpFunRoleLevels> erpFunRoleLevels = erpFunRoleLevelsMapper.selectByExample(roleLevelExample);
				List<ErpCompRoleLevelsVO> roleLevelList = new ArrayList<ErpCompRoleLevelsVO>();
				for(ErpFunRoleLevels tmp : erpFunRoleLevels){
					//组装职级ID对应的薪资配置ID
					Integer tmpRoleLevelId = tmp.getRoleLevelId();
					ErpCompRoleLevelsVO roleLevelVo = PoConverterToView.convertPoToVo(tmp, ErpCompRoleLevelsVO.class);
					if(tmpWageConfigMap.get(tmpRoleLevelId) != null){
						roleLevelVo.setWageConfigId(tmpWageConfigMap.get(tmpRoleLevelId).getId());
					}
					roleLevelList.add(roleLevelVo);
				}
				erpFunRoleWageConfig.setErpFunRoleLevelIds(roleLevelList);
			}
			
		    //角色的管理层级
		    erpFunRoleWageConfig.setErpCompRoles(erpCompRoles);

		    // 查询工作量的数据
			ErpFunRoleWageWorkcountExample erpFunRoleWageWorkcountExample = new ErpFunRoleWageWorkcountExample();
			erpFunRoleWageWorkcountExample.setOrderByClause("WORKCOUNT_SEQ desc");
			erpFunRoleWageWorkcountExample.setShardCityId(cityId);
			erpFunRoleWageWorkcountExample.createCriteria().andRoleWageConfigIdEqualTo(erpFunRoleWageConfig.getId()).andIsCheckEqualTo((byte) 1);
			List<ErpFunRoleWageWorkcount> erpFunRoleWageWorkcountList = erpFunRoleWageWorkcount.selectByExample(erpFunRoleWageWorkcountExample);

			// 查询绩效考核的数据 CHECK_TYPE 提成类型 1=本人 2=管理
			ErpFunRoleWageProfitExample erpFunRoleWageProfitExample = new ErpFunRoleWageProfitExample();
			erpFunRoleWageProfitExample.setOrderByClause("PROFIT_SEQ desc");
			erpFunRoleWageProfitExample.setShardCityId(cityId);
			erpFunRoleWageProfitExample.createCriteria().andRoleWageConfigIdEqualTo(erpFunRoleWageConfig.getId()).andIsCheckEqualTo((byte) 1);
			List<ErpFunRoleWageProfit> erpFunRoleWageProfitList = erpFunRoleWageProfitMapper.selectByExample(erpFunRoleWageProfitExample);

		    erpFunRoleWageConfig.setErpFunRoleWageWorkcountList(erpFunRoleWageWorkcountList);
		    erpFunRoleWageConfig.setErpFunRoleWageProfitList(erpFunRoleWageProfitList);

			// 查询提成数据
			ErpRoleWagetypeRelativeExample erpRoleWagetypeRelativeExample = new ErpRoleWagetypeRelativeExample();
			erpRoleWagetypeRelativeExample.setShardCityId(cityId);
			erpRoleWagetypeRelativeExample.createCriteria().andSalaryTypeIdEqualTo(erpFunRoleWageConfig.getId()).andIsCheckEqualTo((byte) 1).andCompIdEqualTo(compId);
			List<ErpRoleWagetypeRelative> erpRoleWagetypeRelativeList = erpRoleWagetypeRelativeMapper.selectByExample(erpRoleWagetypeRelativeExample);

			// 查询方案详情数据
			if (!CollectionUtils.isEmpty(erpRoleWagetypeRelativeList)) {
				List<String> wageTypeIds = new ArrayList<>();
				for (ErpRoleWagetypeRelative erpRoleWagetypeRelative : erpRoleWagetypeRelativeList) {
					wageTypeIds.add(erpRoleWagetypeRelative.getSecondhandId() + "");
					wageTypeIds.add(erpRoleWagetypeRelative.getFinanceId() + "");
					wageTypeIds.add(erpRoleWagetypeRelative.getLeaseId() + "");
					wageTypeIds.add(erpRoleWagetypeRelative.getNewhouseId() + "");
					wageTypeIds.add(erpRoleWagetypeRelative.getTransferId() + "");
					wageTypeIds.add(erpRoleWagetypeRelative.getTotalId() + "");
					wageTypeIds.add(erpRoleWagetypeRelative.getNewtotalId() + "");
				}
				
				wageTypeIds = wageTypeIds.stream().filter(val -> !"null".equals(val)).collect(Collectors.toList());
				List<ErpFunWageTypeNewDto> erpFunWageTypeNewDtoList = erpFunWageTypeNewMapper.getMyWageTypeDtoListByIds(cityId,compId,wageTypeIds);
				if (CollectionUtils.isEmpty(erpFunWageTypeNewDtoList)) {
					return ErpResponseJson.ok(erpFunRoleWageConfig);
				}
				
				List<ErpFunCountwage> erpFunCountwageList = erpFunCountwageMapper.getFunCountwageListByWageTypeIds(cityId,compId,wageTypeIds);
				if (!CollectionUtils.isEmpty(erpFunCountwageList)) {
					Map<Integer,List<ErpFunCountwage>> countWageMap = erpFunCountwageList.stream().collect(Collectors.groupingBy(ErpFunCountwage::getWagetypeId));
					for (ErpFunWageTypeNewDto erpFunWageTypeNewDto : erpFunWageTypeNewDtoList) {
						erpFunWageTypeNewDto.setErpFunCountwageList(countWageMap.get(erpFunWageTypeNewDto.getId()));
					}
				}
				erpFunRoleWageConfig.setErpFunWageTypeNewDtoList(erpFunWageTypeNewDtoList);
			}
			erpFunRoleWageConfig.setErpRoleWagetypeRelativeList(erpRoleWagetypeRelativeList);
		}
        return ErpResponseJson.ok(erpFunRoleWageConfig);
	}

	/**
     * 薪资配置模板保存并应用到其它角色
	 * (暂时只应用于移动端）
     * @param
     * @return
     */
    @ApiOperation(value = "薪资配置模板保存并应用到其它角色",httpMethod = "POST")
    @ApiResponses({@ApiResponse(code = 200,message = "success")})
    @ResponseBody
    @RequestMapping("/salaryConfigSaveAndApplyOtherRoles")
    @NotBlank({"otherRoleIds","roleId"})
    public ErpResponseJson salaryConfigApplyOtherRoles(@RequestBody @Valid RoleWageConfigParam roleWageConfigParam){
        Operator operator = getOperator();
        //增加了修改职级薪资配置的功能
        Integer adminCompId = operator.getAdminCompId();
        Integer roleWageId = null;
        if(operator.newOrganizationType()) {
			roleWageId = erpFunRoleWageConfigService.updateRoleWageConfig(adminCompId, operator.getCityId(), operator.getCompId(), operator.getUserId(), roleWageConfigParam);
		}else {
			roleWageId = erpFunRoleWageConfigService.updateRoleWageConfig(adminCompId, operator.getCityId(), operator.getCompId(), operator.getUserId(), roleWageConfigParam);
		}
        if(roleWageId != null && roleWageId > 0){
        	erpFunRoleWageConfigService.salaryConfigApplyOtherRoles(adminCompId, operator.getCityId(), operator.getCompId(), operator.getUserId(), roleWageConfigParam);
        }
        return ErpResponseJson.ok();
    }

}



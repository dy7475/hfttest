package com.myfun.erpWeb.homepage;

import com.github.pagehelper.PageHelper;
import com.google.common.base.Objects;
import com.myfun.erpWeb.homepage.param.*;
import com.myfun.erpWeb.homepage.vo.*;
import com.myfun.erpWeb.managecenter.profit.param.AssessCountDataParam;
import com.myfun.erpWeb.managecenter.profit.vo.AssessRoleCountDataVo;
import com.myfun.erpWeb.managecenter.userOpers.vo.ErpOrganizationVO;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dao.AdminFunCityMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.*;
import com.myfun.repository.erpdb.param.ErpFunProfitParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.reportdb.dao.ReportFunStatisticDetail1Mapper;
import com.myfun.repository.reportdb.dao.ReportFunStatisticTotleMapper;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.constant.Const.StatisticDetailType;
import com.myfun.service.business.admindb.AdminFunCompService;
import com.myfun.service.business.erpdb.ErpFunOrganizationService;
import com.myfun.service.business.erpdb.ErpFunPartnerConfigService;
import com.myfun.service.business.erpdb.ErpFunTrackService;
import com.myfun.service.business.erpdb.ErpSysParaService;
import com.myfun.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.auth.In;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 首页相关接口
 * @author 张宏利
 * @since 2018年2月7日
 */
@Api(tags = "首页接口")
@Controller
@RequestMapping("/homepage")
public class HomePageController extends BaseController {
	@Autowired private ReportFunStatisticTotleMapper reportFunStatisticTotleMapper;
	@Autowired private ErpFunDeptsgroupMapper erpFunDeptsgroupMapper;
	@Autowired private ErpSysParaMapper erpSysParaMapper;
	@Autowired private ErpFunRegionMapper erpFunRegionMapper;
	@Autowired private ErpFunAreaMapper erpFunAreaMapper;
	@Autowired private ErpFunWageMapper erpFunWageMapper;
	@Autowired private ErpCompRolesMapper erpCompRolesMapper;
	@Autowired private ErpFunUserManageRangeMapper erpFunUserManageRangeMapper;
	@Autowired private AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired private ErpFunSaleMapper erpFunSaleMapper;
	@Autowired private ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired private ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
	@Autowired private ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	@Autowired private ErpFunProfitTargetMapper erpFunProfitTargetMapper;
	@Autowired private ErpFunProfitMapper erpFunProfitMapper;
	@Autowired private ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired private ErpFunWorkcountTargetMapper erpFunWorkcountTargetMapper;
	@Autowired private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired private ErpAuditUserRuntimeMapper erpAuditUserRuntimeMapper;
	@Autowired private ErpFunTrackService erpFunTrackService;
	@Autowired private ErpFunTrackMapper erpFunTrackMapper;
	@Autowired private ErpFunCompMapper erpFunCompMapper;
	@Autowired private ErpFunDealMapper erpFunDealMapper;
	@Autowired private ErpFunOutdealMapper erpFunOutdealMapper;
	@Autowired private ReportFunStatisticDetail1Mapper reportFunStatisticDetail1Mapper;
	@Autowired private AdminFunCompService adminFunCompService;
	@Autowired private ErpUserOpersMapper erpUserOpersMapper;
	@Autowired private ErpFunPartnerConfigService erpFunPartnerConfigService;
	@Autowired private ErpFunOrganizationService erpFunOrganizationService;
	@Autowired private ErpFunOrganizationMapper erpFunOrganizationMapper;
	@Autowired private ErpFunOrganizationDefinitionMapper erpFunOrganizationDefinitionMapper;
	@Autowired private ErpSysParaService erpSysParaService;
	@Autowired private ErpFunKeyMapper erpFunKeyMapper;
	@Autowired private ErpFunEntrustMapper erpFunEntrustMapper;
	@Autowired private ErpFunPhotoMapper erpFunPhotoMapper;
	@Autowired private ErpFunPerformanceTypeMapper erpFunPerformanceTypeMapper;
	@Autowired private AdminFunCityMapper adminFunCityMapper;
	/**
	 * 修改职业签名
	 * @author 张宏利
	 * @since 2018年2月5日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateProfessionSub")
	public ResponseJson updateProfessionSub(@RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		String professionSub = param.getString("professionSub");
		AdminFunArchive adminFunArchive = new AdminFunArchive();
		adminFunArchive.setArchiveId(operator.getArchiveId());
		adminFunArchive.setProfessionSub(professionSub);
		adminFunArchiveMapper.updateByPrimaryKeySelective(adminFunArchive);
		return ErpResponseJson.ok();
	}

	/**
	 * 提醒关注数量获取
	 * @author 张宏利
	 * @since 2018年2月3日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getBasicFollowCount")
	public ResponseJson getBasicFollowCount(@RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Integer compId = operator.getCompId();
		Integer userId = operator.getUserId();
		Integer cityId = operator.getCityId();
		Integer deptId = operator.getDeptId();
		if (operator.isSwitchCompLogin()) {
			ErpFunUsers funUsers = erpFunUsersMapper.getGeneralManagerByCompId(cityId, compId);
			userId = funUsers.getUserId();
		}
		// 是否是新版组织机构版本
		boolean newOrganizationType = operator.newOrganizationType();

		// 初始化当前人的加盟商ID, 在后面的代码判断是否开启加盟商模式以及房源数据隔离, 来判断需不需要这个值
		Integer partnerId = operator.getPartnerId();
		// 需要判断加盟商信息(房源是否独立配置)
		CheckPartnerConfigDto houseConfigDto = erpFunPartnerConfigService.checkPartnerConfig(cityId, compId, partnerId, "houseDataApart");
		Byte houseOpenPartner = houseConfigDto.getOpenPartner();
		Byte houseIsApart = houseConfigDto.getIsApart();
		// 需要判断加盟商信息(客源是否独立配置)
		CheckPartnerConfigDto custConfigDto = erpFunPartnerConfigService.checkPartnerConfig(cityId, compId, partnerId, "custDataApart");
		Byte custOpenPartner = custConfigDto.getOpenPartner();
		Byte custIsApart = custConfigDto.getIsApart();

		// 房客源是可以分开管控的
		Integer housePartnerId = partnerId;
		Integer custPartnerId = partnerId;

		// 只要不是公司开启了加盟商模式, 或者房源数据隔离, 那么就按以前的逻辑走(不带加盟商ID查询)
		if (houseOpenPartner == 0 || houseIsApart == 0) {
			housePartnerId = null;
		}
		if (custOpenPartner == 0 || custIsApart == 0) {
			custPartnerId = null;
		}
		// 直营看直营, 加盟商看加盟商, 总部看所有
		if (partnerId == 0) {
			housePartnerId = null;
			custPartnerId = null;
		}

		ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, userId);
		Integer organizationId = erpFunUsers.getOrganizationId();

		// 管理范围
		Set<Integer> rangeIds = new HashSet<>();
		List<ErpFunUserManageRange> userManageRangeList = erpFunUserManageRangeMapper.getUserManageRange(cityId, compId, userId);
		Integer rangeType = 6;
		if(null == userManageRangeList || userManageRangeList.isEmpty()){
			if (!newOrganizationType) {
				rangeIds.add(userId);
			} else {
				if (organizationId != null && organizationId > 0) {
					rangeIds.add(organizationId);
				}
			}
		} else {
			rangeIds = userManageRangeList.stream().map(ErpFunUserManageRange::getRangeId).collect(Collectors.toSet());
			rangeType = userManageRangeList.get(0).getRangeType();
		}

		// 防止管理范围为空
		if (CollectionUtils.isEmpty(rangeIds)) {
			return ErpResponseJson.ok();
		}

		// 待跟房（出租、出售）
		Map<String, Integer> funSaleMap = erpFunSaleMapper.getSaleCountByFlag(cityId, compId, rangeType, rangeIds, housePartnerId, newOrganizationType);
		Map<String, Integer> funLeaseMap = erpFunLeaseMapper.getLeaseCountByFlag(cityId, compId, rangeType, rangeIds, housePartnerId, newOrganizationType);
		//待完善
		Integer saleImproveCount = funSaleMap == null?0:funSaleMap.get("needImprove");
		Integer leaseImproveCount = funLeaseMap == null?0:funLeaseMap.get("needImprove");

		Integer saleTrackCount = funSaleMap == null?0:funSaleMap.get("needTrackHouse");
		Integer leaseTrackCount = funLeaseMap == null?0:funLeaseMap.get("needTrackHouse");
		// 待跟客（求租、求购）
		Integer buyTrackCount = erpFunBuyCustomerMapper.getBuyCustCountByFlag(cityId, compId, rangeType, rangeIds, custPartnerId, newOrganizationType);
		Integer rentTrackCount = erpFunRentCustomerMapper.getRentCustCountByFlag(cityId, compId, rangeType, rangeIds, custPartnerId, newOrganizationType);

		String nowDate = DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy-MM-dd");
		Integer funSaleIncrement = 0;
		Integer funLeaseIncrement = 0;
		if (!newOrganizationType) {
			// 店内新增
			funSaleIncrement = erpFunSaleMapper.selectHotIncrementByDeptId(cityId, compId, deptId, nowDate, null, null, null, housePartnerId);
			funLeaseIncrement = erpFunLeaseMapper.selectHotIncrementByDeptId(cityId, compId, deptId, nowDate, null, null, null, housePartnerId);
		} else {
			// 组织内新增
			if (organizationId != null) {
				funSaleIncrement = erpFunSaleMapper.selectHotIncrementByOrgId(cityId, compId, organizationId, nowDate, null, null, null, housePartnerId);
				funLeaseIncrement = erpFunLeaseMapper.selectHotIncrementByOrgId(cityId, compId, organizationId, nowDate, null, null, null, housePartnerId);
			}
		}

		// 今日抢盘 2=私盘
		Integer funSaleDeptNew = erpFunSaleMapper.selectHotIncrementByDeptId(cityId, compId, null, null, nowDate, 1, null, housePartnerId);
		Integer funLeaseDeptNew = erpFunLeaseMapper.selectHotIncrementByDeptId(cityId, compId, null, null, nowDate, 1, null, housePartnerId);

		Integer saleModifyPriceCount = 0;
		Integer leaseModifyPriceEndCount = 0;

		if (!newOrganizationType) {
			// 调价房
			saleModifyPriceCount = erpFunSaleMapper.getModifyPriceEndCount(cityId, compId, DateTimeHelper.formatDateTimetoString(new Date()), deptId, userId);
			leaseModifyPriceEndCount = erpFunLeaseMapper.getModifyPriceEndCount(cityId, compId, DateTimeHelper.formatDateTimetoString(new Date()), deptId, userId);
		} else {
			// 调价房(组织内)
			if (organizationId != null) {
				saleModifyPriceCount = erpFunSaleMapper.getModifyPriceEndCountByOrg(cityId, compId, DateTimeHelper.formatDateTimetoString(new Date()), organizationId, userId);
				leaseModifyPriceEndCount = erpFunLeaseMapper.getModifyPriceEndCountByOrg(cityId, compId, DateTimeHelper.formatDateTimetoString(new Date()), organizationId, userId);
			}
		}

		// 范围内租售笋盘房源的总数量(以前的聚焦改为了笋盘)
		int saleFocusIncrement = 0;
		int leaseFocusIncrement = 0;

		if (!newOrganizationType) {
			// 店内笋盘房源统计数
			if(rangeType != null && (rangeType == 4 || rangeType == 5 || rangeType == 6)){
				saleFocusIncrement = erpFunSaleMapper.selectHotIncrementByDeptId(cityId, compId, deptId, null,
						null, null, Const.DIC_HOUSE_LEVEL_FOCUS.intValue(), housePartnerId);
				leaseFocusIncrement = erpFunLeaseMapper.selectHotIncrementByDeptId(cityId, compId, deptId, null,
						null, null, Const.DIC_HOUSE_LEVEL_FOCUS.intValue(), housePartnerId);
			}
		} else {
			// 组织内笋盘房源统计数
			if (organizationId != null) {
				saleFocusIncrement = erpFunSaleMapper.selectHotIncrementByOrgId(cityId, compId, organizationId, null,
						null, null, Const.DIC_HOUSE_LEVEL_FOCUS.intValue(), housePartnerId);
				leaseFocusIncrement = erpFunLeaseMapper.selectHotIncrementByOrgId(cityId, compId, organizationId, null,
						null, null, Const.DIC_HOUSE_LEVEL_FOCUS.intValue(), housePartnerId);
			}
		}

		//返回值
		Map<String, Integer> resultMap = new HashMap<>();
		resultMap.put("needTrackHouse", saleTrackCount + leaseTrackCount);// 待跟房（租售），红色警告和黄色警告的，RED_FLAG、ORANGE_FLAG
		resultMap.put("needTrackCust", buyTrackCount + rentTrackCount);// 待跟客（租售），红色警告和黄色警告的，RED_FLAG、ORANGE_FLAG
		resultMap.put("deptNew", funSaleIncrement + funLeaseIncrement);// 店内今日新增（租售），门店今日新增房源
		resultMap.put("todayPublic", funSaleDeptNew + funLeaseDeptNew);// 今日抢盘，门店今日跳抢的房源
		resultMap.put("modifyPrice", saleModifyPriceCount + leaseModifyPriceEndCount);// 调价房，最近涨价、降价房源（有调价图标的，参考系统参数）
		resultMap.put("deptFocusNum", saleFocusIncrement + leaseFocusIncrement);// 店内笋盘房源统计数
		// 待审批（店长）
		if(rangeType == 4){
			// 1 = 待我审批
			if (!operator.isSwitchCompLogin()) {
				String[] dateArr = DateUtil.getConditionDate("13");
				List<Integer> needAuditList = erpAuditUserRuntimeMapper.getAuditUserByMyselfCount(cityId, userId, 1, dateArr[0], dateArr[1]);
				Integer needAudit = 0;
				if(null != needAuditList){
					needAudit = needAuditList.size();
				}
				resultMap.put("needAudit", needAudit);// 待审批
			}
		}else{
			// 经纪人
			resultMap.put("needImprove", saleImproveCount + leaseImproveCount);// 待完善（租售），无任何图片、视频、VR的房源
		}
		return ErpResponseJson.ok(resultMap);
	}

	/**
	 * 提醒关注数量获取(现在调用的是statisWeb同名接口,加盟商相关修改在那边)
	 * @author 张宏利
	 * @since 2018年2月3日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@AccessReadonlyDb
	@RequestMapping("/getManageFollowCount")
	public ResponseJson getManageFollowCount(@RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer userId = operator.getUserId();
		if (operator.isSwitchCompLogin()) {
			ErpFunUsers funUsers = erpFunUsersMapper.getGeneralManagerByCompId(cityId, compId);
			userId = funUsers.getUserId();
		}
		// 初始化当前人的加盟商ID, 在后面的代码判断是否开启加盟商模式以及房源数据隔离, 来判断需不需要这个值
		Integer partnerId = operator.getPartnerId();
		// 需要判断加盟商信息(房源是否独立配置)
		CheckPartnerConfigDto houseConfigDto = erpFunPartnerConfigService.checkPartnerConfig(cityId, compId, partnerId, "houseDataApart");
		Byte houseOpenPartner = houseConfigDto.getOpenPartner();
		Byte houseIsApart = houseConfigDto.getIsApart();
		// 需要判断加盟商信息(客源是否独立配置)
		CheckPartnerConfigDto custConfigDto = erpFunPartnerConfigService.checkPartnerConfig(cityId, compId, partnerId, "custDataApart");
		Byte custOpenPartner = custConfigDto.getOpenPartner();
		Byte custIsApart = custConfigDto.getIsApart();

		// 房客源是可以分开管控的
		Integer housePartnerId = partnerId;
		Integer custPartnerId = partnerId;

		// 只要不是公司开启了加盟商模式, 或者房源数据隔离, 那么就按以前的逻辑走(不带加盟商ID查询)
		if (houseOpenPartner == 0 || houseIsApart == 0) {
			housePartnerId = null;
		}
		if (custOpenPartner == 0 || custIsApart == 0) {
			custPartnerId = null;
		}
		// 直营看直营, 加盟商看加盟商, 总部看所有
		if (partnerId == 0) {
			housePartnerId = null;
			custPartnerId = null;
		}

		Map<String, Integer> resultMap = new HashMap<>();
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
//		String startTime = DateTimeHelper.formatDatetoString(calendar.getTime());
		// 本周
		SimpleDateFormat startSdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		Calendar ca = Calendar.getInstance();
		ca.setFirstDayOfWeek(Calendar.MONDAY);
		ca.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		ca.set(ca.get(Calendar.YEAR), ca.get(Calendar.MONTH), ca.get(Calendar.DATE), 23, 59, 59);
		ca.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		ca.set(Calendar.HOUR_OF_DAY, 0);
		ca.set(Calendar.MINUTE, 0);
		ca.set(Calendar.SECOND, 0);
		String startTime = startSdf.format(ca.getTime());
		ErpCompRoles erpCompRoles = erpCompRolesMapper.getByRoleId(cityId, compId, operator.getUserPosition());
		if (erpCompRoles == null || erpCompRoles.getManageLevel() == 0 || erpCompRoles.getManageLevel() == 6) {
			return ErpResponseJson.ok();
		}
		Byte manageLevel = erpCompRoles.getManageLevel();
		List<ErpFunUserManageRange> userManageRange = erpFunUserManageRangeMapper.getUserManageRange(cityId, compId,
				userId);
		if (userManageRange == null || userManageRange.isEmpty()) {
			// 管理范围
			ErpFunUserManageRange rangDept = new ErpFunUserManageRange();
			rangDept.setRangeId(operator.getDeptId());
			userManageRange.add(rangDept);
		}
		// 管理范围
		Set<Integer> manageRangIds = userManageRange.stream().collect(Collectors.mapping(ErpFunUserManageRange::getRangeId, Collectors.toSet()));
		// 房源新增（出租、出售）
		Integer saleAddCount = erpFunSaleMapper.getSaleAddCount(cityId, compId, manageLevel, manageRangIds, startTime,null, null, null, housePartnerId);
		Integer leaseAddCount = erpFunLeaseMapper.getLeaseAddCount(cityId, compId, manageLevel, manageRangIds,startTime, null, null, null, housePartnerId);
		// 客源新增（求租、求购）
		Integer rentAddCount = erpFunRentCustomerMapper.getRentAddCount(cityId, compId, manageLevel, manageRangIds,startTime, custPartnerId);
		Integer buyAddCount = erpFunBuyCustomerMapper.getBuyAddCount(cityId, compId, manageLevel, manageRangIds,startTime, custPartnerId);
		// 成交量（出租、出售） -> 5=内成交
		Integer saleDealCount = erpFunSaleMapper.getSaleAddCount(cityId, compId, manageLevel, manageRangIds, null,startTime, 5, null, housePartnerId);
		Integer leaseDealCount = erpFunLeaseMapper.getLeaseAddCount(cityId, compId, manageLevel, manageRangIds, null,startTime, 5, null, housePartnerId);
		// 暂缓盘（出租、出售） 3=暂缓
		Integer saleRespiteCount = 0;
		Integer leaseRespiteCount = 0;
		List<Map<String,Object>> trackZhList = erpFunTrackMapper.getTrackZhList(cityId, compId, startTime);
		// 公司没有开启加盟商或者房源隔离, 才用fun_track去统计, 否则用fun_sale和自己的管理范围去查询
		if(null != trackZhList && trackZhList.size() >= 1000 && !(houseOpenPartner == 1 && houseIsApart == 1)){
			resultMap.put("respiteCount", trackZhList.size());// 本周暂缓盘（租售），管理范围暂缓房源量（管理范围，未设置时显示店内）
		} else if (null != trackZhList && trackZhList.size() > 0) {
			Map<Integer, List<Map<String, Object>>> zhTrackMap = trackZhList.stream()
					.collect(Collectors.groupingBy(map -> StringUtil.parseInteger(map.get("caseType"), 0)));
			List<Map<String, Object>> salelist = zhTrackMap.get(1); // 出售
			List<Map<String, Object>> leaselist = zhTrackMap.get(2); // 出租
			if(salelist != null && salelist.size() > 0) {
				Set<Integer> saleIdSet = salelist.stream().collect(Collectors.mapping(map -> StringUtil.parseInteger(map.get("caseId"), 0), Collectors.toSet()));
				saleRespiteCount = erpFunSaleMapper.getSaleZhAddCount(cityId, compId, manageLevel, manageRangIds, 3,startTime, saleIdSet, housePartnerId);
			}
			if(leaselist != null && leaselist.size() > 0) {
				Set<Integer> leaseIdList = leaselist.stream().collect(Collectors.mapping(map -> StringUtil.parseInteger(map.get("caseId"), 0), Collectors.toSet()));
				leaseRespiteCount = erpFunLeaseMapper.getLeaseZhAddCount(cityId, compId, manageLevel, manageRangIds, 3,startTime, leaseIdList, housePartnerId);
			}
			resultMap.put("respiteCount", saleRespiteCount + leaseRespiteCount);// 本周暂缓盘（租售），管理范围暂缓房源量（管理范围，未设置时显示店内）
		}
		// 外成交（出租、出售） -> 6=外成交
		Integer saleoutDealCount = erpFunSaleMapper.getSaleAddCount(cityId, compId, manageLevel, manageRangIds,null, startTime, 6, null, housePartnerId);
		Integer leaseoutDealCount = erpFunLeaseMapper.getLeaseAddCount(cityId, compId, manageLevel, manageRangIds,null, startTime, 6, null, housePartnerId);
		// 删除盘（出租、出售）7=注销
		Integer saleWriteoffCount = erpFunSaleMapper.getSaleAddCount(cityId, compId, manageLevel, manageRangIds,null, null, 7, startTime, housePartnerId);
		Integer leaseWriteoffCount = erpFunLeaseMapper.getLeaseAddCount(cityId, compId, manageLevel, manageRangIds,null, null, 7, startTime, housePartnerId);
		resultMap.put("houseNew", saleAddCount + leaseAddCount);// 房源新增（租售），本周新增的房源（管理范围，未设置时显示店内）
		resultMap.put("custNew", buyAddCount + rentAddCount);// 客源新增（租售），本周新增的客源（管理范围，未设置时显示店内）
		resultMap.put("dealCount", saleDealCount + leaseDealCount);// 本周成交单量（租售），本周内成交房源量（管理范围，未设置时显示店内）
		resultMap.put("outDeal", saleoutDealCount + leaseoutDealCount);// 本周外成交（租售），外成交房源量，（管理范围，未设置时显示店内）
		resultMap.put("writeoffCount", saleWriteoffCount + leaseWriteoffCount);// 删除盘，本周删除的房源量（管理范围，未设置时显示店内）
		return ErpResponseJson.ok(resultMap);
	}

//	@ResponseBody
//	@RequestMapping("/getWorkCountStatistic")
//	public ResponseJson getWorkCountStatistic(@RequestBody BaseMapParam param) {
//		// 时间类型，1=今日 2=本周
//		Integer dateType = param.getInteger("dateType");
//		Operator operator = getOperator();
//		String startTime = null;
//		if(dateType == 1) {
//			startTime = DateTimeHelper.formatDatetoString(new Date());
//		} else {
//			Calendar calendar = Calendar.getInstance();
//			calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
//			startTime = DateTimeHelper.formatDatetoString(calendar.getTime());
//		}
//		ErpCompRoles erpCompRoles = erpCompRolesMapper.getByRoleId(operator.getCityId(), operator.getCompId(), operator.getUserPosition());
//		if(erpCompRoles == null || erpCompRoles.getManageLevel() == 0) {
//			return ErpResponseJson.ok();
//		}
//		Byte manageLevel = erpCompRoles.getManageLevel();
//		Integer groupRange = erpCompRoles.getManageLevel().intValue();
//		List<ErpFunUserManageRange> manageRangeList = erpFunUserManageRangeMapper.getUserManageRange(operator.getCityId(), operator.getCompId(), operator.getUserId());
//		if (manageRangeList == null || manageRangeList.isEmpty()) {
//			// 6、有管理范围，没有配置管理的具体大区、片区、门店，则统计自己所在门店
//			// 6.1、如果只有一个分组，显示所有员工
//			// 6.2、多个分组则展示所有分组
//			ErpFunUserManageRange rangDept = new ErpFunUserManageRange();
//			if (manageLevel <= 4) {
//				rangDept.setRangeId(operator.getDeptId());
//				int groupCount = erpFunDeptsgroupMapper.getAllGroupCount(operator.getCityId(), operator.getCompId(), operator.getDeptId());
//				groupRange = (groupCount > 1) ? 5 : 6;
//			} else {
//				// 7、有管理范围，没有配置管理的具体分组，则只统计自己
//				groupRange = 6;
//				manageLevel = 6;
//				rangDept.setRangeId(operator.getUserId());
//			}
//			manageRangeList.add(rangDept);
//		} else {
//			AdminFunDeptsExample example = new AdminFunDeptsExample();
//			example.createCriteria().andCompIdEqualTo(operator.getAdminCompId()).andDeptFlagGreaterThan(0);
//			int adminDeptCount = adminFunDeptsMapper.countByExample(example);
//			if (adminDeptCount == 1) {
//				// 1.1、整个公司只有一个门店，正式或试用未到期的
//				// 1.1.1、如果只有一个分组，显示所有员工
//				// 1.1.2、多个分组则展示所有分组
//				int groupCount = erpFunDeptsgroupMapper.getAllGroupCount(operator.getCityId(), operator.getCompId(), null);
//				groupRange = (groupCount > 1) ? 5 : 6;
//			} else {
//				if(manageLevel == 1) {
//					int areaCount = erpFunAreaMapper.getAllAreaCount(operator.getCityId(), operator.getCompId());
//					if(areaCount > 1) {
//						groupRange = 2;
//					} else {
//						int regCount = erpFunRegionMapper.getAllRegCount(operator.getCityId(), operator.getCompId());
//						if(regCount > 1) {
//							groupRange = 3;
//						} else {
//							if(adminDeptCount > 1) {
//								groupRange = 4;
//							} else {
//								int groupCount = erpFunDeptsgroupMapper.getAllGroupCount(operator.getCityId(), operator.getCompId(), null);
//								// 没有分组时查所有人
//								groupRange = (groupCount > 1) ? 5 : 6;
//							}
//						}
//					}
//				} else {
//					// 管理层级是大区、片区、门店、分组，而且只管理着一个范围，统计维度加大一号
//					if (manageRangeList.size() <= 1) {
//						groupRange++;
//					}
//					if (erpCompRoles.getManageLevel() == 4) {
//						// 4、管理范围是门店
//						// 4.1、只管理了一个门店
//						// 4.1.1、如果只有一个分组，显示所有员工
//						// 4.1.2、多个分组则展示所有分组
//						// 4.2、多个门店则展示所有门店
//						if (manageRangeList.size() <= 1) {
//							int groupCount = erpFunDeptsgroupMapper.getAllGroupCount(operator.getCityId(), operator.getCompId(), null);
//							// 没有分组时查所有人
//							groupRange = (groupCount > 1) ? 5 : 6;
//						}
//					}
//				}
//			}
//		}
//		// 指定查询哪些工作量
//		Set<String> workColumns = new HashSet<>();
//
//		// TODO 指定列待查询数据库
//		workColumns.add("SUM(DJ_COUNT) djCount");
//		workColumns.add("SUM(GJ_COUNT) gjCount");
//		// 管理范围
//		Set<Integer> manageRangIds = manageRangeList.stream().collect(Collectors.mapping(ErpFunUserManageRange::getRangeId, Collectors.toSet()));
//		List<Map<String, String>> statistcList = reportFunStatisticTotleMapper.getUcenterWorkCount(
//				operator.getCityId(), operator.getCompId(), manageLevel, manageRangIds,
//				workColumns, groupRange, startTime);
//		return ErpResponseJson.ok(statistcList);
//	}

	/**
	 * 工作情况统计
	 * ==整体逻辑说明，略复杂==
	 * 1、管理范围是门店及以上的
	 * 		1.1、整个公司只有一个门店，正式或试用未到期的
	 * 			1.1.1、如果只有一个分组，显示所有员工
	 * 			1.1.2、多个分组则展示所有分组
	 * 		1.2、多个门店按具体管理范围统计
	 * 2、管理范围是大区，只管理了一个大区，显示所有片区，否则展示所有大区
	 * 3、管理范围是片区，只管理了一个片区，显示所有门店，否则展示所有片区
	 * 4、管理范围是门店
	 * 		4.1、只管理了一个门店
	 * 			4.1.1、如果只有一个分组，显示所有员工
	 * 			4.1.2、多个分组则展示所有分组
	 * 		4.2、多个门店则展示所有门店
	 * 5、管理范围是分组，只管理了一个分组，显示所有员工，否则展示所有分组
	 * 6、有管理范围，没有配置管理的具体大区、片区、门店，则统计自己所在门店
	 * 		6.1、如果只有一个分组，显示所有员工
	 * 		6.2、多个分组则展示所有分组
	 * 7、有管理范围，没有配置管理的具体分组，则只统计自己
	 * @author 张宏利
	 * @since 2018年2月5日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getWorkCountStatistic")
	public ResponseJson getWorkCountStatistic(@RequestBody BaseMapParam param) {
		// 时间类型，1=今日 2=本周
		Integer dateType = param.getInteger("dateType");
		Integer rangeType = param.getInteger("rangeType"); // 2:大区3：片区 4：门店 5：分组 6：到人
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer userId = operator.getUserId();
		String startTime = null;
		// 指定查询哪些工作量
		Set<String> workColumns = new HashSet<>();
		if(dateType == 1) {
			startTime = DateTimeHelper.formatDatetoString(new Date());
			workColumns.add("SUM(iif(case_type in (1,2), DGJ_COUNT, 0)) gjHouseCount");
			workColumns.add("SUM(iif(case_type in (3,4), DGJ_COUNT, 0)) gjCustomerCount");
			workColumns.add("SUM(TPSC_COUNT) tpScCount");
			workColumns.add("SUM(VR_COUNT) vrCount");
			workColumns.add("SUM(CKDH_COUNT) ckdhCount");
			workColumns.add("SUM(QFTG_COUNT) houseFafaCount");
			workColumns.add("SUM(PYQ_COUNT) postShareCount");
			workColumns.add("SUM(SPSC_COUNT) spCount");
			// 统计跟进
		} else {
			startTime = DateUtil.getConditionDate("12")[0];
			workColumns.add("SUM(iif(case_type in (1,2), DJ_COUNT, 0)) houseAdd");
			workColumns.add("SUM(iif(case_type in (3,4), DJ_COUNT, 0)) customerAdd");
			workColumns.add("SUM(FK_COUNT) fkCount");
			workColumns.add("SUM(FDK_COUNT) dkCount");
			workColumns.add("SUM(KFDP_COUNT) kkCount");
			workColumns.add("SUM(YSTJ_COUNT) ysCount");
			workColumns.add("SUM(WT_COUNT)+SUM(XSWT_COUNT)+SUM(DJWT_COUNT)+SUM(BZWT_COUNT)+SUM(PTWT_COUNT) wtCount");
			workColumns.add("SUM(CJ_COUNT) signDealCount");
		}
//		ErpCompRoles erpCompRoles = erpCompRolesMapper.getByRoleId(operator.getCityId(), operator.getCompId(), operator.getUserPosition());
//		if(erpCompRoles == null || erpCompRoles.getManageLevel() == 0) {
//			return ErpResponseJson.ok();
//		}
//		Byte manageLevel = erpCompRoles.getManageLevel();
//		Integer groupRange = erpCompRoles.getManageLevel().intValue();
		Set<Integer> rangeIds = new HashSet<>();
		List<ErpFunUserManageRange> manageRangeList = erpFunUserManageRangeMapper.getUserManageRange(operator.getCityId(), operator.getCompId(), operator.getUserId());
		Set<Integer> userManageRangeIds = new HashSet<>();
		Integer manageRangeRangeType = null;
		if(manageRangeList != null && manageRangeList.size() > 0) {
			ErpFunUserManageRange erpFunUserManageRange = manageRangeList.get(0);
			// 管理范围
			userManageRangeIds = manageRangeList.stream().collect(Collectors.mapping(val -> val.getRangeId(), Collectors.toSet()));
			manageRangeRangeType = erpFunUserManageRange.getRangeType();
		}
		if(null == rangeType || 7 == rangeType) {
			rangeIds.add(userId);
			rangeType = 6;
		}else if(userManageRangeIds.size()>0){
			// 查询管理范围内的分组
			if(2 == rangeType) {
				// 大区
				List<ErpFunArea> areaList = erpFunAreaMapper.selectAreaList(cityId, compId, manageRangeRangeType, userManageRangeIds, startTime);
				rangeIds = areaList.stream().collect(Collectors.mapping(val->val.getAreaId(), Collectors.toSet()));
			} else if(3==rangeType) {
				// 片区
				List<ErpFunRegion> regionList = erpFunRegionMapper.selectRegList(cityId, compId, manageRangeRangeType, userManageRangeIds, startTime);
				rangeIds = regionList.stream().collect(Collectors.mapping(val->val.getRegId(), Collectors.toSet()));
			} else if(4==rangeType) {
				// 门店
				List<ErpFunDepts> regionList = erpFunDeptsMapper.selectFunDeptsList(cityId, compId, manageRangeRangeType, userManageRangeIds);
				rangeIds = regionList.stream().collect(Collectors.mapping(val->val.getDeptId(), Collectors.toSet()));
			}else if(5==rangeType) {
				// 分组
				List<ErpFunDeptsgroup> groupList = erpFunDeptsgroupMapper.selectGroupList(cityId, compId, manageRangeRangeType, userManageRangeIds);
				rangeIds = groupList.stream().collect(Collectors.mapping(val->val.getGrId(), Collectors.toSet()));
			}else if(6==rangeType) {
				// 个人
				List<ErpFunUsers> groupList = erpFunUsersMapper.selectUserList(cityId, compId, null, manageRangeRangeType, userManageRangeIds,startTime );
				rangeIds = groupList.stream().collect(Collectors.mapping(val->val.getUserId(), Collectors.toSet()));
			}
		}
		// 管理范围
		List<Map<String, Object>> statistcList = null;
		if(rangeIds.size()>0){
			statistcList = reportFunStatisticTotleMapper.getUcenterWorkCount(cityId, compId, rangeType, rangeIds,workColumns, startTime);
		}
		// 为空数据时补充数据
		if(null == statistcList || statistcList.size() == 0) {
			for (Integer rangeId : rangeIds) {
				Map<String, Object> resMap = new HashMap<>();
				resMap.put("rangeId", rangeId);
				resMap.put("rangeType", rangeType);
				Map<String, Object> targetMapList = erpFunWorkcountTargetMapper.getSumWorkCountTargetList(cityId, compId, rangeType,  rangeId, dateType, startTime);
				if(null != targetMapList && !targetMapList.isEmpty()) {
					resMap.putAll(targetMapList);
				}
				statistcList.add(resMap);
			}
		}else {
			Set<Integer> rangeId = statistcList.stream().collect(Collectors.mapping(val -> Integer.valueOf(val.get("rangeId") + ""), Collectors.toSet()));
			Map<Integer, Map<String, Object>> paramMap = statistcList.stream().collect(Collectors.toMap(val -> StringUtil.parseInteger(val.get("rangeId")), val -> val));
			statistcList = new ArrayList<>();
			for (Integer rangeId2 : rangeIds) {
				if(!rangeId.contains(rangeId2)) {
					Map<String, Object> resMap = new HashMap<>();
					resMap.put("rangeId", rangeId2);
					resMap.put("rangeType", rangeType);
					Map<String, Object> targetMapList = erpFunWorkcountTargetMapper.getSumWorkCountTargetList(cityId, compId, rangeType,  rangeId2, dateType, startTime);
					if(null != targetMapList && !targetMapList.isEmpty()) {
						resMap.putAll(targetMapList);
					}
					statistcList.add(resMap);
				}else {
					Map<String, Object> map = paramMap.get(rangeId2);
					map.put("rangeType", rangeType);
					Map<String, Object> targetMapList = erpFunWorkcountTargetMapper.getSumWorkCountTargetList(cityId, compId, rangeType,  rangeId2, dateType, startTime);
					if(null != targetMapList && !targetMapList.isEmpty()) {
						map.putAll(targetMapList);
					}
					statistcList.add(map);
				}
			}
		}
//		Map<Integer, Integer> mapFunDeps = new HashMap<>();
//		if(groupRange == 5) {
//			// 查询门店数据
//			List<ErpFunDeptsgroup> resList = erpFunDeptsgroupMapper.getDeptGroupsByGrIds(cityId, compId, manageRangIds);
//			mapFunDeps = resList.stream().collect(Collectors.toMap(ErpFunDeptsgroup::getGrId, val -> val.getDeptId()));
//
//		}
		return ErpResponseJson.ok(statistcList);
	}

	/**
	 * 工作情况统计报表数据
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/7
	 *
	 *
	 */
	@ResponseBody
	@RequestMapping("/getWorkCountStatisticReport")
	public ResponseJson getWorkCountStatisticReport(@RequestBody BaseMapParam param) {
		//检索条件修改 部门 员工  角色 达标状态（全部0  达标1  未达标2） 日期
		Operator operator = getOperator();
		Integer dateType=param.getInteger("dateType");
		String startTime=param.getString("startTime");
		Integer standard = param.getInteger("standard");//达标状态
		standard = standard != null ? standard : 0;

		Integer cityId = operator.getCityId();
		Integer userId = param.getInteger("userId");

		String userPosition = param.getString("userPosition");//用户角色
		param.setString("userPosition", userPosition);

		param.setInteger("compId", operator.getCompId());
		param.setInteger("cityId", cityId);
		param.setInteger("userId", userId);
		//拿到userId范围
		List<ErpFunUsersDto> usersList = getUsersList(cityId, operator.getCompId(), userId, userPosition, param);
		List<Integer> userIds = usersList.stream().collect(Collectors.mapping(ErpFunUsersDto::getUserId, Collectors.toList()));
		Map<Integer, ErpFunUsersDto> usersMap = usersList.stream().collect(Collectors.toMap(ErpFunUsersDto::getUserId, val -> val));

		param.setObject("userIds", userIds);

		List<Map<String, Object>> statistcList = reportFunStatisticTotleMapper.getUcenterWorkCountReport(cityId, param.getMap());

		//目标工作工作量统计
		List<Map<String, Object>> targetList = erpFunWorkcountTargetMapper.getSumWorkCountTargetListReport(cityId, param.getMap());
		Map<Integer, Map<String, Object>> targetMap = targetList.stream().collect(Collectors.toMap(val -> StringUtil.parseInteger(val.get("userId")), val -> val));


		List<Map<String, Object>> resultList = new ArrayList<>();
		//达标状态（全部0  达标1  未达标2）
		//达标状态为0 合并数据  为1  移除未达标的用户后合并数据   为2移除达标的用户后合并数据
		if (null == statistcList || statistcList.size() == 0) {
			for (Integer userId2 : userIds) {
				//目标量不为空为完成量补数据
				setFinishDataSupplement(userId2,standard,targetMap,usersMap,resultList);
			}
		} else {
			Set<Integer> statistcListUserId = statistcList.stream().collect(Collectors.mapping(val -> Integer.valueOf(val.get("userId") + ""), Collectors.toSet()));
			Map<Integer, Map<String, Object>> paramMap = statistcList.stream().collect(Collectors.toMap(val -> StringUtil.parseInteger(val.get("userId")), val -> val));
			for (Integer userId2 : userIds) {
				if (!statistcListUserId.contains(userId2)) {
					//有目标量没有完成量为完成量补空
					setFinishDataSupplement(userId2,standard,targetMap,usersMap,resultList);
				} else {
					//有完成量如果没有目标量为目标量补空
					setTargetDataSupplement(userId2,standard,targetMap,usersMap,resultList,paramMap);

				}
			}
		}
		//日统计日期参数设置
		if (dateType==1){
			setDateParam(resultList,startTime);
		}

		ErpResponseJson responseJson = ErpResponseJson.ok(resultList);
		responseJson.setTotal(Long.valueOf(resultList.size()));
		return responseJson;
	}


	/**
	 * 设置日统计统一返回日期
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/13
	 */
	private void setDateParam(List<Map<String,Object>> resultList, String startTime) {
		if (resultList==null || resultList.size()==0){
			return;
		}
		startTime=startTime.substring(0,10);
		for (Map<String,Object> resultMap : resultList) {
			resultMap.put("coreTime",startTime);
		}
	}

	/**
	 * 达标数据统计
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/13
	 */
	private Map<String,Object> getStandardDate(Map<String,Object> statistcMap, Map<String,Object> targetMapList, Integer standard) {
		Integer count=0;//统计是否全部达标
		Map<String, Object> resMap = new HashMap<>();//存达标数据
		Map<String, Object> resMap2 = new HashMap<>();//存未达标数据
		Map<String, Object> resMap3 = new HashMap<>();//全部达标
		Iterator<String> iter1 = statistcMap.keySet().iterator();
		while (iter1.hasNext()) {
			String m1Key =  iter1.next();
			if (!m1Key.equals("userId") && !m1Key.equals("userName") && !m1Key.equals("userPosition")){
				Integer m1Vlue=(Integer) statistcMap.get(m1Key);
				Integer m2Vlue=(Integer) targetMapList.get(m1Key+"T");
				if (m1Vlue>=m2Vlue) {//达标
					count++;
				}
			}
		}
		if (count==8){//全部达标
			resMap.putAll(statistcMap);
			resMap.putAll(targetMapList);
		}else {//未达标数据
			resMap2.putAll(statistcMap);
			resMap2.putAll(targetMapList);
		}
		if (standard==1){
			if (resMap.size()>0){
				return resMap;//达标数据
			}
		}else if (standard==2){
			if (resMap2.size()>0){
				return resMap2;//未达标数据
			}
		}else {
			resMap3.putAll(statistcMap);
			resMap3.putAll(targetMapList);
			return resMap3;
		}
		return null;
	}

	/**
	 * 获取用户数据
	 * @param
	 * @param cityId
	 * @param compId
	 * @param userId
	 * @param userPosition
	 * @param param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/13
	 */
	private List<ErpFunUsersDto> getUsersList(Integer cityId, Integer compId, Integer userId, String userPosition, BaseMapParam param) {
		ErpFunUsers condition=new ErpFunUsers();
		condition.setUserId(userId);
		condition.setCompId(compId);
		condition.setAreaId(param.getInteger("areaId"));
		condition.setRegId(param.getInteger("regId"));
		condition.setDeptId(param.getInteger("deptId"));
		condition.setUserPosition(userPosition);
		condition.setGrId(param.getInteger("grId"));
		condition.setWriteoffTime(param.getString("startTime"));
		List<ErpFunUsersDto> usersDtoList=erpFunUsersMapper.getFunUsersDtoListWriteOff(cityId,condition);
		return usersDtoList;
	}

	/**
	 * 目标量不为空为完成量补数据
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/13
	 */
	private void setFinishDataSupplement(Integer userId2, Integer standard, Map<Integer,Map<String,Object>> targetMap, Map<Integer, ErpFunUsersDto> usersMap, List<Map<String,Object>> resultList) {
		Map<String, Object> resMap = new HashMap<>();
		Map<String, Object> targetMapList = targetMap.get(userId2);
		if (null != targetMapList && !targetMapList.isEmpty()) {
			//获取用户姓名、角色
			ErpFunUsersDto erpFunUsers = usersMap.get(userId2);
			if (erpFunUsers != null) {
				resMap.put("userId", erpFunUsers.getUserId());
				resMap.put("userName", erpFunUsers.getUserName());
				resMap.put("userPosition", erpFunUsers.getUserPosition());
			}
			//为完成量补空数据
			Iterator<String> iter1 = targetMapList.keySet().iterator();
			while (iter1.hasNext()) {
				String m1Key = iter1.next();
				if (!m1Key.equals("userId")) {
					String m2Key = m1Key.substring(0, m1Key.length() - 1);
					resMap.put(m2Key, 0);
				}
			}
			resMap.putAll(targetMapList);
			//未达标数据时或查全部时展示
			if (standard != 1) {
				resultList.add(resMap);
			}
		}
	}

	/**
	 * 目标量补空
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/13
	 */
	private void setTargetDataSupplement(Integer userId2, Integer standard, Map<Integer,Map<String,Object>> targetMap, Map<Integer, ErpFunUsersDto> usersMap, List<Map<String,Object>> resultList, Map<Integer, Map<String, Object>> paramMap) {
		Map<String, Object> resMap = new HashMap<>();//存达标数据
		Map<String, Object> targetMapList = targetMap.get(userId2);
		Map<String, Object> statistcMap = paramMap.get(userId2);
		//获取用户姓名、角色
		ErpFunUsersDto erpFunUsers = usersMap.get(userId2);
		if (erpFunUsers != null) {
			statistcMap.put("userId", erpFunUsers.getUserId());
			statistcMap.put("userName", erpFunUsers.getUserName());
			statistcMap.put("userPosition", erpFunUsers.getUserPosition());
		}
		if (null != targetMapList && !targetMapList.isEmpty()) {//有工作量有目标量
			//是否达标数据统计 standard为1返回达标数据，standard= 2 返回未达标数据  全部时直接合并返回
			Map<String, Object> StandardDate = getStandardDate(statistcMap, targetMapList, standard);
			if (StandardDate != null) {
				resultList.add(StandardDate);
			}
		} else {
			targetMapList = new HashMap<>();
			resMap.putAll(statistcMap);
			//为目标量补空数据
			Iterator<String> iter1 = statistcMap.keySet().iterator();
			while (iter1.hasNext()) {
				String m1Key = iter1.next();
				if (!m1Key.equals("userId") && !m1Key.equals("userName") && !m1Key.equals("userPosition")) {
					targetMapList.put(m1Key + "T", 0);
				}
			}
			resMap.putAll(targetMapList);
			if (standard != 2) {
				resultList.add(resMap);
			}

		}
	}


	/**
	 * 首页工作情况鼠标移动上去显示排名
	 * @author 朱科
	 * @since 2018年4月20日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getWorkCountStatisticRank")
	public ResponseJson getWorkCountStatisticRank(@RequestBody BaseMapParam param){
		// 时间类型，1=今日 2=本周
		Integer dateType = param.getInteger("dateType");
		// 排名类型
		Integer lookRankType = param.getInteger("lookRankType");
		// 排名范围
		Integer rangeId = param.getInteger("rangeId");
		// 排名范围类型
		Integer rangeType = param.getInteger("rangeType");
		if(null == lookRankType || lookRankType > 8 || lookRankType < 1){
			return ErpResponseJson.ok();
		}
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer userId = operator.getUserId();
		Integer deptId = null;
		Set<String> workColumns = new HashSet<>();
		String startTime = null;
		if (dateType == 1) {
			startTime = DateTimeHelper.formatDatetoString(new Date());
			if (lookRankType == 1) {
				workColumns.add("SUM(iif(case_type in (1,2), DGJ_COUNT, 0))");
			} else if (lookRankType == 2) {
				workColumns.add("SUM(iif(case_type in (3,4), DGJ_COUNT, 0))");
			} else if (lookRankType == 3) {
				workColumns.add("SUM(TPSC_COUNT)");
			} else if (lookRankType == 4) {
				workColumns.add("SUM(VR_COUNT)");
			} else if (lookRankType == 5) {
				workColumns.add("SUM(CKDH_COUNT)");
			} else if (lookRankType == 6) {
				workColumns.add("SUM(QFTG_COUNT)");
			} else if (lookRankType == 7) {
				workColumns.add("SUM(PYQ_COUNT)");
			} else if (lookRankType == 8) {
				workColumns.add("SUM(SPSC_COUNT)");
			}
			// 统计跟进
		} else {
			startTime = DateUtil.getConditionDate("12")[0];
			if (lookRankType == 1) {
				workColumns.add("SUM(iif(case_type in (1,2), DJ_COUNT, 0))");
			} else if (lookRankType == 2) {
				workColumns.add("SUM(iif(case_type in (3,4), DJ_COUNT, 0))");
			} else if (lookRankType == 3) {
				workColumns.add("SUM(FK_COUNT)");
			} else if (lookRankType == 4) {
				workColumns.add("SUM(FDK_COUNT)");
			} else if (lookRankType == 5) {
				workColumns.add("SUM(KFDP_COUNT)");
			} else if (lookRankType == 6) {
				workColumns.add("SUM(YSTJ_COUNT)");
			} else if (lookRankType == 7) {
				workColumns.add("SUM(WT_COUNT)+SUM(XSWT_COUNT)+SUM(DJWT_COUNT)+SUM(BZWT_COUNT)+SUM(PTWT_COUNT)");
			} else if (lookRankType == 8) {
				workColumns.add("SUM(CJ_COUNT)");
			}
		}
		Set<Integer> rangeIds = new HashSet<>();
		if(rangeType == 2 || rangeType == 3){ // 大区
			List<ErpFunDepts> deptsList = null;
			if(rangeType == 2){
				deptsList = erpFunDeptsMapper.selectFunDeptsListRank(cityId, compId, rangeId, null);
			} else if(rangeType == 3){
				deptsList = erpFunDeptsMapper.selectFunDeptsListRank(cityId, compId, null, rangeId);
			}
			if(null != deptsList && deptsList.size() > 1){
				rangeType = 4;
				rangeIds = deptsList.stream().collect(Collectors.mapping(val -> val.getDeptId(), Collectors.toSet()));
			} else if(null != deptsList && deptsList.size() == 1){
				List<ErpFunDeptsgroup> groupList = erpFunDeptsgroupMapper.selectGroupListRank(cityId, compId,deptsList.get(0).getDeptId(),startTime);
				if(null != groupList && groupList.size() > 1){
					deptId = deptsList.get(0).getDeptId();
					rangeType = 5;
					rangeIds = groupList.stream().collect(Collectors.mapping(val -> val.getGrId(), Collectors.toSet()));
					rangeIds.add(0);
				} else {
					rangeType = 6;
					List<ErpFunUsers> usersList = erpFunUsersMapper.getUserListByDeptId(cityId, deptsList.get(0).getDeptId());
					if(!usersList.isEmpty()){
						rangeIds = usersList.stream().collect(Collectors.mapping(ErpFunUsers::getUserId, Collectors.toSet()));
					}
					if(rangeIds.isEmpty()){
						rangeIds.add(userId);
					}
				}
			}
		} else if(rangeType == 4){ // 门店
			List<ErpFunDeptsgroup> groupList = erpFunDeptsgroupMapper.selectGroupListRank(cityId, compId,rangeId,startTime);
			if(null != groupList && groupList.size() > 1){
				deptId = groupList.get(0).getDeptId();
				rangeType = 5;
				rangeIds = groupList.stream().collect(Collectors.mapping(val -> val.getGrId(), Collectors.toSet()));
				rangeIds.add(0);
			} else {
				rangeType = 6;
				List<ErpFunUsers> usersList = erpFunUsersMapper.getUserListByDeptId(cityId, rangeId);
				if(!usersList.isEmpty()){
					rangeIds = usersList.stream().collect(Collectors.mapping(ErpFunUsers::getUserId, Collectors.toSet()));
				}
				if(rangeIds.isEmpty()){
					rangeIds.add(userId);
				}
			}
		} else if(rangeType == 5){ // 分组
			rangeIds.add(rangeId);
		} else {
			return ErpResponseJson.ok();
		}
		List<Map<String, Object>> statistcList = null;
		if (rangeIds.size() > 0) {
			statistcList = reportFunStatisticTotleMapper.getUcenterWorkCountRank(cityId, compId, workColumns, startTime,
					rangeType, rangeIds, deptId);
			for(Map<String, Object> result: statistcList){
				result.put("rangeType", rangeType);
			}
		}
		return ErpResponseJson.ok(statistcList);
	}


	/**
	 * 经纪人带看热度统计
	 * @author 张宏利
	 * @since 2018年2月7日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getBasicDaiKanHotrank")
	public ResponseJson getBasicDaiKanHotrank(@RequestBody BaseMapParam param){
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer userId = operator.getUserId();
		if (operator.isSwitchCompLogin()) {
			ErpFunUsers funUsers = erpFunUsersMapper.getGeneralManagerByCompId(cityId, compId);
			userId = funUsers.getUserId();
		}
		// 1=房源，2=客源
		Integer houseCust = param.getInteger("houseCust");
		// 本周一
		Calendar cal=new GregorianCalendar();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setTime(new Date());
		cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
		String startTime = DateTimeHelper.formatDatetoString(cal.getTime());
		//返回数据
		List<Map<String,Object>> resultList = erpFunTrackService.getBasicDaiKanHotrank(cityId, compId, userId, startTime, houseCust);
		return ErpResponseJson.ok(resultList);
	}

	/**
	 * 管理角色带看热度统计
	 * @author 张宏利
	 * @since 2018年2月7日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getManageDaiKanHotrank")
	public ResponseJson getManageDaiKanHotrank(@RequestBody BaseMapParam param){
		Operator operator = getOperator();
		// 1=房源，2=客源
		Integer houseCust = param.getInteger("houseCust");
		Calendar cal=new GregorianCalendar();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setTime(new Date());
		cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
		String startTime = DateTimeHelper.formatDatetoString(cal.getTime());
		List<ErpFunUserManageRange> manageRangeList = erpFunUserManageRangeMapper.getUserManageRange(operator.getCityId(), operator.getCompId(), operator.getUserId());
		Byte manageLevel = null;
		if (manageRangeList == null || manageRangeList.isEmpty()) {
			ErpCompRoles erpCompRoles = erpCompRolesMapper.getByRoleId(operator.getCityId(), operator.getCompId(), operator.getUserPosition());
			if(erpCompRoles == null || erpCompRoles.getManageLevel() == 0 || erpCompRoles.getManageLevel() == 6) {
				return ErpResponseJson.ok();
			}
			manageLevel = erpCompRoles.getManageLevel();
			ErpFunUserManageRange rangDept = new ErpFunUserManageRange();
			if (manageLevel <= 4) {
				rangDept.setRangeId(operator.getDeptId());
			} else {
				// 7、有管理范围，没有配置管理的具体分组，则只统计自己
				manageLevel = 6;
				rangDept.setRangeId(operator.getUserId());
			}
			manageRangeList.add(rangDept);
		} else {
			manageLevel = manageRangeList.get(0).getRangeType().byteValue();
		}
		// 管理范围
		Set<Integer> manageRangIds = manageRangeList.stream().collect(Collectors.mapping(ErpFunUserManageRange::getRangeId, Collectors.toSet()));
		String countColumn = (houseCust == 1) ? "DK_COUNT" : "FDK_COUNT";
		// userId,counts
		List<Map<String, Object>> rankList = reportFunStatisticTotleMapper.getManageDaiKanRank(operator.getCityId(),
				operator.getCompId(), manageLevel, manageRangIds, startTime, countColumn);
		// 明明完了还要去查询工资来拼！！
		if (rankList != null && rankList.size() > 0) {
			String wageAccountingDay = erpSysParaMapper.getParamValue(operator.getCityId(), operator.getCompId(), "WAGE_ACCOUNTING_DAY");
			String assessMentMonth = DateUtil.getAssessMentMonth(wageAccountingDay, 0);
			Set<Integer> userIdSet = rankList.stream().collect(Collectors.mapping(key -> StringUtil.parseInteger(key.get("userId")), Collectors.toSet()));
			List<Map<String,Object>> userPositionList = erpFunUsersMapper.getUserPosition(operator.getCityId(), userIdSet);
			Map<Integer, List<Map<String, Object>>> positionGrMap = userPositionList.stream().collect(Collectors.groupingBy(map -> StringUtil.parseInteger(map.get("userId"), 0)));
			Map<Integer, Map<String, Object>> userWageMap = erpFunWageMapper.getWageStatistic(operator.getCityId(),
					operator.getCompId(), userIdSet, assessMentMonth);
			for (Map<String, Object> rankMap : rankList) {
				Integer userId = StringUtil.parseInteger(rankMap.get("userId"));
				List<Map<String, Object>> list = positionGrMap.get(userId);
				rankMap.put("userPosition", list.get(0).get("roleName"));
				rankMap.put("grId", list.get(0).get("grId"));
				rankMap.put("deptId", list.get(0).get("deptId"));
				Map<String, Object> wageMap = userWageMap.get(userId);
				if(wageMap != null) {
					rankMap.put("totalWage", wageMap.get("totalWage"));
				}
			}
		}
		return ErpResponseJson.ok(rankList);
	}

	/**
	 * @Title 首页分组以上的层级看走势图(半年走势图)
	 * @Author lcb
	 * @Date 2018/2/10
	 * @Param
	 **/
	@RequestMapping("/getCompProfitMonth")
	@ResponseBody
	public ResponseJson getCompProfitOffHalfYear(@RequestBody ErpFunProfitParam param) throws Exception{
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		Integer userId = getOperator().getUserId();
		// 查询的范围 1:公司 2：大区 3：片区 4：门店

		//计算半年时间
		String[] timeArr = DateUtil.getFrontHalfYearEndByTodayTimeArr();
		param.setCompId(compId);
		param.setStartTime( timeArr[0]);
		param.setEndTime( timeArr[1]);

		// 查询范围
		List<ErpFunUserManageRange> userManageRange = erpFunUserManageRangeMapper.getUserManageRange(cityId, compId, userId);
		if(userManageRange.size() == 0) {
			return ErpResponseJson.ok();
		}

		Set<Integer> rangeIdSet = userManageRange.stream().collect(Collectors.mapping(val -> val.getRangeId(), Collectors.toSet()));

		// 查询的组织Id
		if(rangeIdSet.size() == 0) {
			return ErpResponseJson.ok();
		}

		param.setRangIds(rangeIdSet);
		// 查询数据
		List<Map<String, Object>> profitDataList = erpFunProfitMapper.getCompProfitOffHalfYearForHomePage(cityId, param);
		if (profitDataList != null && !profitDataList.isEmpty()) {
			Map<String, Object> baseMap = new HashMap<String, Object>();
			baseMap.put("receivableProfit", "0");
			baseMap.put("actualProfit", "0");
			// 补时间数据
			DataAnalysisUtil.repairDateForListMap(profitDataList, baseMap, timeArr[0], timeArr[1], "2", "dateCount");
		}
		return ErpResponseJson.ok(profitDataList);
	}

	/**
	 * @Title 查询业绩目标(有范围的)
	 * @Author lcb
	 * @Date 2018/2/6
	 * @Param
	 **/
	@ResponseBody
	@RequestMapping("/getProfitTargetAndProfit")
	public ResponseJson getProfitTargetAndProfit(@RequestBody ErpFunProfitParam param) {
		// 判断登录是否有管理范围
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		Integer userId = getOperator().getUserId();
		// 5 分组 6到人
		Integer rangeType = param.getRangeType();

		// 组织机构ids
		Set<Integer> rangeIds = new HashSet<>();
		// 查询定制参数
		// 0:应收 1：实收
		String indexProfitShowType = erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, userId,"INDEX_PROFIT_SHOW_TYPE");
		String column = "RECEIVABLE_MONEY";
		if("1".equals(indexProfitShowType)) {
			column = "PROFIT_MONEY";
		}
		/*if(rangeType == 5) {
			// 查询门店下有哪些分组
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("compId", compId);
			paramMap.put("deptId", deptId);
			paramMap.put("isDel", 0);
			List<ErpFunDeptsgroup> groupListByCondition = erpFunDeptsgroupMapper.getGroupListByCondition(cityId, paramMap);
			rangeIds = groupListByCondition.stream().collect(Collectors.mapping(val->val.getGrId(), Collectors.toSet()));
		}else {
			// 查询门店下有哪些人
			ErpFunUsers funUsers = new ErpFunUsers();
			funUsers.setCompId(compId);
			funUsers.setDeptId(deptId);
			funUsers.setUserWriteoff(false);
			List<ErpFunUsers> rangeUserList = erpFunUsersMapper.getRangeUserList(cityId, funUsers);
			rangeIds = rangeUserList.stream().collect(Collectors.mapping(val->val.getUserId(), Collectors.toSet()));
		}*/
		rangeIds.add(userId);
		// 查询本月
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date startTime = calendar.getTime();
		List<ErpFunProfitTargetDto> resList = null;
		if(rangeIds != null && rangeIds.size() > 0) {
			resList = erpFunProfitTargetMapper.getProfitTargetList(cityId, compId, startTime, rangeIds, rangeType);
			Set<Integer> existRangeIds = resList.stream().collect(Collectors.mapping(val->val.getRangeId(), Collectors.toSet()));
			// 初始化业绩目标（有可能没设置目标的初始化一下）
			for (Integer rangeId : rangeIds) {
				if(!existRangeIds.contains(rangeId)) {
					ErpFunProfitTargetDto erpFunProfitTargetDto = new ErpFunProfitTargetDto();
					erpFunProfitTargetDto.setRangeId(rangeId);
					erpFunProfitTargetDto.setRangeType(rangeType);
					erpFunProfitTargetDto.setTargetProfit(new BigDecimal(0));
					erpFunProfitTargetDto.setRangeType(rangeType);
					resList.add(erpFunProfitTargetDto);
				}
			}
			// 查询当月业绩
			List<ErpFunProfitDto> profitResList = erpFunProfitMapper.getProfitList(cityId, compId, startTime, rangeIds, rangeType, column);
			if(profitResList.size() > 0) {
				for (ErpFunProfitTargetDto erpFunProfitTargetDto : resList) {
					erpFunProfitTargetDto.setRangeType(rangeType);
					for (ErpFunProfitDto erpFunProfitDto : profitResList) {
						if(erpFunProfitTargetDto.getRangeId().equals(erpFunProfitDto.getRangeId())) {
							erpFunProfitTargetDto.setProfitMoney(erpFunProfitDto.getProfitMoney());
							continue;
						}
					}
				}
			}
		}
		return ErpResponseJson.ok(resList);
	}

	@ResponseBody
	@RequestMapping("/getPersonalRank")
	public ResponseJson getPersonalRank(@RequestBody ErpFunProfitParam param){
		// 判断登录是否有管理范围
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		Integer deptId = getOperator().getDeptId();
		Integer userId = getOperator().getUserId();
		Integer rangeType = param.getRangeType();
		if (getOperator().isSwitchCompLogin()) {
			cityId = getOperator().getSelfCityId();
			compId = getOperator().getSelfCompId();
		}
		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(Calendar.DAY_OF_MONTH, 1);
		String startTime1 = DateTimeHelper.formatDatetoString(calendar1.getTime());

		// 查询定制参数
		// 0:应收 1：实收
		String indexProfitShowType = erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, userId,"INDEX_PROFIT_SHOW_TYPE");
		String column = "RECEIVABLE_MONEY";
		if("1".equals(indexProfitShowType)) {
			column = "PROFIT_MONEY";
		}
		if(rangeType == 1) {
			List<Map<String,Object>> personalRank = erpFunProfitMapper.getPersonalRank(cityId, compId, startTime1, column);
			List<Map<String, Object>> resultList = null;
			if(null != personalRank && personalRank.size()>0 ){
				Map<Integer, List<Map<String, Object>>> userMap = personalRank.stream().collect(Collectors.groupingBy(map -> StringUtil.parseInteger(map.get("userId"), 0)));
				resultList = userMap.get(userId);
			}
			return ErpResponseJson.ok(resultList);
		}	else {
			// 组织机构ids
			Set<Integer> rangeIds = new HashSet<>();
			if(rangeType != 6){
				return ErpResponseJson.ok();
			}
			ErpFunUsers funUsers = new ErpFunUsers();
			funUsers.setCompId(compId);
			funUsers.setDeptId(deptId);
			funUsers.setUserWriteoff(false);
			List<ErpFunUsers> rangeUserList = erpFunUsersMapper.getRangeUserList(cityId, funUsers);
			rangeIds = rangeUserList.stream().collect(Collectors.mapping(val->val.getUserId(), Collectors.toSet()));
			// 查询本月
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			Date startTime = calendar.getTime();
			List<ErpFunProfitTargetDto> resList = erpFunProfitTargetMapper.getProfitTargetList(cityId, compId, startTime,  rangeIds, rangeType);
			Set<Integer> existRangeIds = resList.stream().collect(Collectors.mapping(val->val.getRangeId(), Collectors.toSet()));
			// 初始化业绩目标（有可能没设置目标的初始化一下）
			for (Integer rangeId : rangeIds) {
				if(!existRangeIds.contains(rangeId)) {
					ErpFunProfitTargetDto erpFunProfitTargetDto = new ErpFunProfitTargetDto();
					erpFunProfitTargetDto.setRangeId(rangeId);
					erpFunProfitTargetDto.setTargetProfit(new BigDecimal(0));
					resList.add(erpFunProfitTargetDto);
				}
			}
			if(resList.size() > 0) {
				// 查询当月业绩
				List<ErpFunProfitDto> profitResList = erpFunProfitMapper.getProfitList(cityId, compId, startTime, rangeIds, rangeType, column);
				if(profitResList.size() > 0) {
					for (ErpFunProfitTargetDto erpFunProfitTargetDto : resList) {
						erpFunProfitTargetDto.setRangeType(rangeType);
						for (ErpFunProfitDto erpFunProfitDto : profitResList) {
							if(erpFunProfitTargetDto.getRangeId().equals(erpFunProfitDto.getRangeId())) {
								erpFunProfitTargetDto.setProfitMoney(erpFunProfitDto.getProfitMoney());
								continue;
							}
						}
					}
				}
			}
			return ErpResponseJson.ok(resList);
		}
	}

	/**
	 * @Title 提醒关注二级页面(经纪人、店长)
	 * @Author zhuke
	 * @Date 2018/3/14
	 * @Param
	 **/
	@ResponseBody
	@RequestMapping("/getBasicCount")
	public ResponseJson getBasicCount(@RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Integer compId = operator.getCompId();
		Integer userId = operator.getUserId();
		Integer cityId = operator.getCityId();
		Integer deptId = operator.getDeptId();
		Integer countType = param.getInteger("countType");
		if(null == countType){
			return ErpResponseJson.ok();
		}

		// 是否是新版组织机构版本
		boolean newOrganizationType = operator.newOrganizationType();

		// 初始化当前人的加盟商ID, 在后面的代码判断是否开启加盟商模式以及房源数据隔离, 来判断需不需要这个值
		Integer partnerId = operator.getPartnerId();
		// 需要判断加盟商信息(房源是否独立配置)
		CheckPartnerConfigDto houseConfigDto = erpFunPartnerConfigService.checkPartnerConfig(cityId, compId, partnerId, "houseDataApart");
		Byte houseOpenPartner = houseConfigDto.getOpenPartner();
		Byte houseIsApart = houseConfigDto.getIsApart();
		// 需要判断加盟商信息(客源是否独立配置)
		CheckPartnerConfigDto custConfigDto = erpFunPartnerConfigService.checkPartnerConfig(cityId, compId, partnerId, "custDataApart");
		Byte custOpenPartner = custConfigDto.getOpenPartner();
		Byte custIsApart = custConfigDto.getIsApart();

		// 房客源是可以分开管控的
		Integer housePartnerId = partnerId;
		Integer custPartnerId = partnerId;

		// 只要不是公司开启了加盟商模式, 或者房源数据隔离, 那么就按以前的逻辑走(不带加盟商ID查询)
		if (houseOpenPartner == 0 || houseIsApart == 0) {
			housePartnerId = null;
		}
		if (custOpenPartner == 0 || custIsApart == 0) {
			custPartnerId = null;
		}
		// 直营看直营, 加盟商看加盟商, 总部看所有
		if (partnerId == 0) {
			housePartnerId = null;
			custPartnerId = null;
		}

		ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, userId);
		Integer organizationId = erpFunUsers.getOrganizationId();


		// 管理范围
		Set<Integer> rangeIds = new HashSet<>();
		List<ErpFunUserManageRange> userManageRangeList = erpFunUserManageRangeMapper.getUserManageRange(cityId, compId, userId);
		Integer rangeType = 6;
		if(null == userManageRangeList || userManageRangeList.isEmpty()){
			if (!newOrganizationType) {
				rangeIds.add(userId);
			} else {
				if (organizationId != null && organizationId > 0) {
					rangeIds.add(organizationId);
				}
			}
		} else {
			rangeIds = userManageRangeList.stream().map(ErpFunUserManageRange::getRangeId).collect(Collectors.toSet());
			rangeType = userManageRangeList.get(0).getRangeType();
		}

		// 防止管理范围为空
		if (CollectionUtils.isEmpty(rangeIds)) {
			return ErpResponseJson.ok();
		}

		//返回值
		Map<String, Integer> resultMap = new HashMap<>();
		if (1 == countType || 2 == countType) {
			// 待跟房（出租、出售）
			Map<String, Integer> funSaleMap = erpFunSaleMapper.getSaleCountByFlag(cityId, compId, rangeType, rangeIds, housePartnerId, newOrganizationType);
			Map<String, Integer> funLeaseMap = erpFunLeaseMapper.getLeaseCountByFlag(cityId, compId, rangeType, rangeIds, housePartnerId, newOrganizationType);
			Integer saleTrackCount = funSaleMap == null ? 0 : funSaleMap.get("needTrackHouse");
			Integer leaseTrackCount = funLeaseMap == null ? 0 : funLeaseMap.get("needTrackHouse");
			resultMap.put("saleTrackCount", saleTrackCount);// 待跟房（租售），红色警告和黄色警告的，RED_FLAG、ORANGE_FLAG
			resultMap.put("leaseTrackCount", leaseTrackCount);// 待跟房（租售），红色警告和黄色警告的，RED_FLAG、ORANGE_FLAG
			// 待审批（店长）
			if (rangeType == 4 && 2 == countType) {
				// 1 = 待我审批
				String[] dateArr = DateUtil.getConditionDate("13");
				List<Integer> needAuditList = erpAuditUserRuntimeMapper.getAuditUserByMyselfCount(cityId, userId, 1, dateArr[0], dateArr[1]);
				Integer needAudit = 0;
				if(null != needAuditList){
					needAudit = needAuditList.size();
				}
				resultMap.put("needAudit", needAudit);// 待审批
			} else {
				// 经纪人 待完善
				if (2 == countType) {
					Integer saleImproveCount = funSaleMap == null ? 0 : funSaleMap.get("needImprove");
					Integer leaseImproveCount = funLeaseMap == null ? 0 : funLeaseMap.get("needImprove");
					resultMap.put("saleImproveCount", saleImproveCount);// 待完善（租售），无任何图片、视频、VR的房源
					resultMap.put("leaseImproveCount", leaseImproveCount);// 待完善（租售），无任何图片、视频、VR的房源
				}
			}
		} else if (3 == countType) {
			// 待跟客（求租、求购）
			Integer buyTrackCount = erpFunBuyCustomerMapper.getBuyCustCountByFlag(cityId, compId, rangeType, rangeIds, custPartnerId, newOrganizationType);
			Integer rentTrackCount = erpFunRentCustomerMapper.getRentCustCountByFlag(cityId, compId, rangeType, rangeIds, custPartnerId, newOrganizationType);
			resultMap.put("buyTrackCount", buyTrackCount);// 待跟客（租售），红色警告和黄色警告的，RED_FLAG、ORANGE_FLAG
			resultMap.put("rentTrackCount", rentTrackCount);// 待跟客（租售），红色警告和黄色警告的，RED_FLAG、ORANGE_FLAG
		} else if (4 == countType) {
			// 店内新增
			String nowDate = DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy-MM-dd");

			Integer funSaleIncrement = 0;
			Integer funLeaseIncrement = 0;
			if (!newOrganizationType) {
				// 店内新增
				funSaleIncrement = erpFunSaleMapper.selectHotIncrementByDeptId(cityId, compId, deptId, nowDate, null, null, null, housePartnerId);
				funLeaseIncrement = erpFunLeaseMapper.selectHotIncrementByDeptId(cityId, compId, deptId, nowDate, null, null, null, housePartnerId);
			} else {
				// 组织内新增
				if (organizationId != null && organizationId > 0) {
					funSaleIncrement = erpFunSaleMapper.selectHotIncrementByOrgId(cityId, compId, organizationId, nowDate, null, null, null, housePartnerId);
					funLeaseIncrement = erpFunLeaseMapper.selectHotIncrementByOrgId(cityId, compId, organizationId, nowDate, null, null, null, housePartnerId);
				}
			}

			resultMap.put("funSaleIncrement", funSaleIncrement);// 店内今日新增（租售），门店今日新增房源
			resultMap.put("funLeaseIncrement", funLeaseIncrement);// 店内今日新增（租售），门店今日新增房源
		} else if (5 == countType) {
			// 今日抢盘 2=私盘
			String nowDate = DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy-MM-dd");
			Integer funSaleDeptNew = erpFunSaleMapper.selectHotIncrementByDeptId(cityId, compId, null, null, nowDate, 1, null, housePartnerId);
			Integer funLeaseDeptNew = erpFunLeaseMapper.selectHotIncrementByDeptId(cityId, compId, null, null, nowDate, 1, null, housePartnerId);
			resultMap.put("funSaleDeptNew", funSaleDeptNew);// 今日抢盘，门店今日跳抢的房源
			resultMap.put("funLeaseDeptNew", funLeaseDeptNew);// 今日抢盘，门店今日跳抢的房源
		} else if (6 == countType) {
			// 调价房
			Integer saleModifyPriceCount = 0;
			Integer leaseModifyPriceEndCount = 0;

			if (!newOrganizationType) {
				// 调价房
				saleModifyPriceCount = erpFunSaleMapper.getModifyPriceEndCount(cityId, compId, DateTimeHelper.formatDateTimetoString(new Date()), deptId, userId);
				leaseModifyPriceEndCount = erpFunLeaseMapper.getModifyPriceEndCount(cityId, compId, DateTimeHelper.formatDateTimetoString(new Date()), deptId, userId);
			} else {
				// 调价房(组织内)
				if (organizationId != null && organizationId > 0) {
					saleModifyPriceCount = erpFunSaleMapper.getModifyPriceEndCountByOrg(cityId, compId, DateTimeHelper.formatDateTimetoString(new Date()), organizationId, userId);
					leaseModifyPriceEndCount = erpFunLeaseMapper.getModifyPriceEndCountByOrg(cityId, compId, DateTimeHelper.formatDateTimetoString(new Date()), organizationId, userId);
				}
			}

			resultMap.put("saleModifyPriceCount", saleModifyPriceCount);// 调价房，最近涨价、降价房源（有调价图标的，参考系统参数）
			resultMap.put("leaseModifyPriceEndCount", leaseModifyPriceEndCount);// 调价房，最近涨价、降价房源（有调价图标的，参考系统参数）
		} else if (7 == countType) {
			// 范围内租售笋盘房源的总数量(以前的聚焦改为了笋盘)
			int saleFocusCount = 0;
			int leaseFocusCount = 0;

			if (!newOrganizationType) {
				// 店内笋盘房源(以前的聚焦改为了笋盘)
				saleFocusCount = erpFunSaleMapper.selectHotIncrementByDeptId(cityId, compId, deptId, null,
						null, null, Const.DIC_HOUSE_LEVEL_FOCUS.intValue(), housePartnerId);
				leaseFocusCount = erpFunLeaseMapper.selectHotIncrementByDeptId(cityId, compId, deptId, null, null,
						null, Const.DIC_HOUSE_LEVEL_FOCUS.intValue(), housePartnerId);
			} else {
				// 组织内笋盘房源统计数
				if (organizationId != null && organizationId > 0) {
					saleFocusCount = erpFunSaleMapper.selectHotIncrementByOrgId(cityId, compId, organizationId, null,
							null, null, Const.DIC_HOUSE_LEVEL_FOCUS.intValue(), housePartnerId);
					leaseFocusCount = erpFunLeaseMapper.selectHotIncrementByOrgId(cityId, compId, organizationId, null,
							null, null, Const.DIC_HOUSE_LEVEL_FOCUS.intValue(), housePartnerId);
				}
			}

			resultMap.put("saleFocusCount", saleFocusCount);// 笋盘房店内出售源统计量
			resultMap.put("leaseFocusCount", leaseFocusCount);// 笋盘店内出租房源统计量
		}
		return ErpResponseJson.ok(resultMap);
	}

	/**
	 * @Title 提醒关注二级页面(管理层)
	 * @Author zhuke
	 * @Date 2018/3/14
	 * @Param
	 **/
	@ResponseBody
	@RequestMapping("/getManagerCount")
	public ResponseJson getManagerCount(@RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer userId = operator.getUserId();
		Integer deptId = operator.getDeptId();
		Integer countType = param.getInteger("countType");
		if (null == countType) {
			return ErpResponseJson.ok();
		}

		// 初始化当前人的加盟商ID, 在后面的代码判断是否开启加盟商模式以及房源数据隔离, 来判断需不需要这个值
		Integer partnerId = operator.getPartnerId();
		// 需要判断加盟商信息(房源是否独立配置)
		CheckPartnerConfigDto houseConfigDto = erpFunPartnerConfigService.checkPartnerConfig(cityId, compId, partnerId, "houseDataApart");
		Byte houseOpenPartner = houseConfigDto.getOpenPartner();
		Byte houseIsApart = houseConfigDto.getIsApart();
		// 需要判断加盟商信息(客源是否独立配置)
		CheckPartnerConfigDto custConfigDto = erpFunPartnerConfigService.checkPartnerConfig(cityId, compId, partnerId, "custDataApart");
		Byte custOpenPartner = custConfigDto.getOpenPartner();
		Byte custIsApart = custConfigDto.getIsApart();

		// 房客源是可以分开管控的
		Integer housePartnerId = partnerId;
		Integer custPartnerId = partnerId;

		// 只要不是公司开启了加盟商模式, 或者房源数据隔离, 那么就按以前的逻辑走(不带加盟商ID查询)
		if (houseOpenPartner == 0 || houseIsApart == 0) {
			housePartnerId = null;
		}
		if (custOpenPartner == 0 || custIsApart == 0) {
			custPartnerId = null;
		}
		// 直营看直营, 加盟商看加盟商, 总部看所有
		if (partnerId == 0) {
			housePartnerId = null;
			custPartnerId = null;
		}

		// 本周
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
//		String startTime = DateTimeHelper.formatDatetoString(calendar.getTime());
		SimpleDateFormat startSdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		Calendar ca = Calendar.getInstance();
		ca.setFirstDayOfWeek(Calendar.MONDAY);
		ca.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		ca.set(ca.get(Calendar.YEAR), ca.get(Calendar.MONTH), ca.get(Calendar.DATE), 23, 59, 59);
		ca.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		ca.set(Calendar.HOUR_OF_DAY, 0);
		ca.set(Calendar.MINUTE, 0);
		ca.set(Calendar.SECOND, 0);
		String startTime = startSdf.format(ca.getTime());
		ErpCompRoles erpCompRoles = erpCompRolesMapper.getByRoleId(cityId, compId, operator.getUserPosition());
		if (erpCompRoles == null || erpCompRoles.getManageLevel() == 0 || erpCompRoles.getManageLevel() == 6) {
			return ErpResponseJson.ok();
		}
		Byte manageLevel = erpCompRoles.getManageLevel();
		List<ErpFunUserManageRange> userManageRange = erpFunUserManageRangeMapper.getUserManageRange(cityId, compId, userId);
		if (userManageRange == null || userManageRange.isEmpty()) {
			// 管理范围
			ErpFunUserManageRange rangDept = new ErpFunUserManageRange();
			rangDept.setRangeId(operator.getDeptId());
			userManageRange.add(rangDept);
		}
		// 管理范围
		Set<Integer> manageRangIds = userManageRange.stream().collect(Collectors.mapping(ErpFunUserManageRange::getRangeId, Collectors.toSet()));
		// 房源新增（出租、出售）
		Map<String, Integer> resultMap = new HashMap<>();
		if (1 == countType) {
			// 房源新增（出售、出租）
			Integer saleAddCount = erpFunSaleMapper.getSaleAddCount(cityId, compId, manageLevel, manageRangIds,startTime, null, null, null, housePartnerId);
			Integer leaseAddCount = erpFunLeaseMapper.getLeaseAddCount(cityId, compId, manageLevel, manageRangIds,startTime, null, null, null, housePartnerId);
			resultMap.put("saleAddCount", saleAddCount);
			resultMap.put("leaseAddCount", leaseAddCount);
		} else if (2 == countType) {
			// 客源新增（求租、求购）
			Integer rentAddCount = erpFunRentCustomerMapper.getRentAddCount(cityId, compId, manageLevel, manageRangIds, startTime, custPartnerId);
			Integer buyAddCount = erpFunBuyCustomerMapper.getBuyAddCount(cityId, compId, manageLevel, manageRangIds, startTime, custPartnerId);
			resultMap.put("rentAddCount", rentAddCount);
			resultMap.put("buyAddCount", buyAddCount);
		} else if (3 == countType) {
			// 成交量（出租、出售）
			Integer saleDealCount = erpFunSaleMapper.getSaleAddCount(cityId, compId, manageLevel, manageRangIds, null, startTime, 5, null, housePartnerId);
			Integer leaseDealCount = erpFunLeaseMapper.getLeaseAddCount(cityId, compId, manageLevel, manageRangIds, null, startTime, 5, null, housePartnerId);
			resultMap.put("saleDealCount", saleDealCount);
			resultMap.put("leaseDealCount", leaseDealCount);
		} else if (4 == countType) {
			// 暂缓盘（出租、出售） 3=暂缓
			Integer saleRespiteCount = 0;
			Integer leaseRespiteCount = 0;
			List<Map<String,Object>> trackZhList = erpFunTrackMapper.getTrackZhList(cityId, compId, startTime);
			if (null != trackZhList && trackZhList.size() > 0) {
				Map<Integer, List<Map<String, Object>>> zhTrackMap = trackZhList.stream().collect(Collectors.groupingBy(map -> StringUtil.parseInteger(map.get("caseType"), 0)));
				List<Map<String, Object>> salelist = zhTrackMap.get(1); // 出售
				List<Map<String, Object>> leaselist = zhTrackMap.get(2); // 出租
				if (salelist != null) {
					// 公司没有开启加盟商或者房源隔离, 才用fun_track去统计, 否则用fun_sale和自己的管理范围去查询
					if (salelist.size() >= 1000 && !(houseOpenPartner == 1 && houseIsApart == 1)) {
						saleRespiteCount = salelist.size();
					} else if (salelist.size() > 0) {
						Set<Integer> saleIdSet = salelist.stream().collect(Collectors.mapping(map -> StringUtil.parseInteger(map.get("caseId"), 0), Collectors.toSet()));
						saleRespiteCount = erpFunSaleMapper.getSaleZhAddCount(cityId, compId, manageLevel, manageRangIds, 3, startTime, saleIdSet, housePartnerId);
					}
				}
				if (leaselist != null) {
					// 公司没有开启加盟商或者房源隔离, 才用fun_track去统计, 否则用fun_lease和自己的管理范围去查询
					if (leaselist.size() >= 1000 && !(houseOpenPartner == 1 && houseIsApart == 1)) {
						leaseRespiteCount = leaselist.size();
					} else if (leaselist.size() > 0) {
						Set<Integer> leaseIdList = leaselist.stream().collect(Collectors.mapping(map -> StringUtil.parseInteger(map.get("caseId"), 0), Collectors.toSet()));
						leaseRespiteCount = erpFunLeaseMapper.getLeaseZhAddCount(cityId, compId, manageLevel, manageRangIds, 3, startTime, leaseIdList, housePartnerId);
					}
				}
			}
			resultMap.put("saleRespiteCount", saleRespiteCount);
			resultMap.put("leaseRespiteCount", leaseRespiteCount);
		} else if (5 == countType) {
			// 外成交（出租、出售）6=外成交
			Integer saleoutDealCount = erpFunSaleMapper.getSaleAddCount(cityId, compId, manageLevel, manageRangIds,null, startTime, 6, null, housePartnerId);
			Integer leaseoutDealCount = erpFunLeaseMapper.getLeaseAddCount(cityId, compId, manageLevel, manageRangIds,null, startTime, 6, null, housePartnerId);
			resultMap.put("saleoutDealCount", saleoutDealCount);
			resultMap.put("leaseoutDealCount", leaseoutDealCount);
		} else if (6 == countType) {
			// 删除盘（出租、出售）7=注销
			Integer saleWriteoffCount = erpFunSaleMapper.getSaleAddCount(cityId, compId, manageLevel, manageRangIds,null, null, 7, startTime, housePartnerId);
			Integer leaseWriteoffCount = erpFunLeaseMapper.getLeaseAddCount(cityId, compId, manageLevel, manageRangIds,null, null, 7, startTime, housePartnerId);
			resultMap.put("saleWriteoffCount", saleWriteoffCount);
			resultMap.put("leaseWriteoffCount", leaseWriteoffCount);
		} else if (7 == countType) {
			// 店内笋盘房源
			Integer saleFocusCount = erpFunSaleMapper.selectHotIncrementByDeptId(cityId, compId, deptId, null, null,
					null, Const.DIC_HOUSE_LEVEL_FOCUS.intValue(), housePartnerId);
			Integer leaseFocusCount = erpFunLeaseMapper.selectHotIncrementByDeptId(cityId, compId, deptId, null, null, null,
					Const.DIC_HOUSE_LEVEL_FOCUS.intValue(), housePartnerId);
			resultMap.put("saleFocusCount", saleFocusCount);// 笋盘房店内出售源统计量
			resultMap.put("leaseFocusCount", leaseFocusCount);// 笋盘店内出租房源统计量
		}
		return ErpResponseJson.ok(resultMap);
	}



	/**
	 * 手机端工作情况
	 * @author 朱科
	 * @since 2018年7月31日
	 * @return
	 */
	@ApiOperation("掌通工作详情")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = AppWorkCountResultDto.class, message = "成功")
	})
	@NotBlank("dateType")
	@ResponseBody
	@PostMapping("/getAppWorkCountStatistic")
	public ResponseJson getAppWorkCountStatistic(@RequestBody AppWorkAchieveParam param) {
		// 参考接口 /getWorkCountStatistic
		Operator operator = getOperator();
		if (operator.newOrganizationType()) {
			return getAppWorkCountStatisticForOrg(param);
		}
		Integer compId = operator.getCompId();
		Integer cityId = operator.getCityId();
		Integer rangeType = param.getRangeType(); // 2:大区3：片区 4：门店 5：分组 6：到人
		String rangeIds = param.getRangeIds(); // 排名范围id
		//加吧，加吧，查询时间段,
		String startTime = param.getStartDate();
		String endTime= param.getEndDate() + " 23:59:59";
		Integer dateType = param.getDateType(); // 考核类型，1=日考核2=周考核3=月考核
		Set<Integer> rangeIdset = new HashSet<>(); // 查询的范围Ids
		String[] idArr = rangeIds.split(",");
		for (String ids : idArr) {
			Integer rangeId = StringUtil.parseInteger(ids, 0);
			rangeIdset.add(rangeId);
		}
		if (rangeType == 1) {
			rangeIdset.add(operator.getCompId());
		}
		Integer deptId = param.getDeptId(); // 查询分组的时候传

		// 指定查询哪些工作量
		List<String> workColumns = new ArrayList<>();
		workColumns.add("ISNULL((SUM(iif(case_type in (1,2), DJ_COUNT, 0))),0) houseAdd"); // 房增
		workColumns.add("ISNULL((SUM(iif(case_type in (3,4), DJ_COUNT, 0))),0) customerAdd"); // 客增
		workColumns.add("ISNULL((SUM(FK_COUNT)),0) fkCount"); // 房堪
		workColumns.add("ISNULL((SUM(FDK_COUNT)),0) fdkCount"); // 带看
		workColumns.add("ISNULL((SUM(iif(case_type in (1,2), GJ_COUNT, 0))),0) gjHouseCount"); // 房源跟进
		workColumns.add("ISNULL((SUM(iif(case_type in (3,4), GJ_COUNT, 0))),0) gjCustomerCount"); // 客源跟进
		workColumns.add("ISNULL((SUM(YSTJ_COUNT)),0) ystjCount"); // 钥匙提交
		workColumns.add("ISNULL((SUM(KFDP_COUNT)),0) kfdpCount"); // 看房点评（空看）
		workColumns.add("ISNULL((SUM(WT_COUNT) + SUM(XSWT_COUNT) + SUM(DJWT_COUNT) + SUM(BZWT_COUNT) + SUM(PTWT_COUNT)),0) wtCount"); // 委托
		workColumns.add("ISNULL((SUM(CJ_COUNT)),0) cjCount"); // 签约
		workColumns.add("ISNULL((SUM(TPSC_COUNT)),0) tpscCount"); // 图片上传
		workColumns.add("ISNULL((SUM(VR_COUNT)),0) vrCount");// VR上传量
		workColumns.add("ISNULL((SUM(SPSC_COUNT)),0) spscCount"); // 视频上传
//		workColumns.add("ISNULL((SUM(CKDH_COUNT)),0) ckdhCount"); // 查看电话
		workColumns.add("ISNULL((SUM(QFTG_COUNT)),0) qftgCount"); // 群发推广
		workColumns.add("ISNULL((SUM(PYQ_COUNT)),0) pyqCount"); // 朋友圈分享
//		workColumns.add("ISNULL((SUM(IPCALL_COUNT)),0) ipcallCount");
		workColumns.add("ISNULL((SUM(iif(case_type in (1,2), MT_COUNT, 0))),0) mtHouseCount"); // 房源面谈
		workColumns.add("ISNULL((SUM(iif(case_type in (3,4), MT_COUNT, 0))),0) mtCustomerCount"); // 客源面谈
		workColumns.add("ISNULL((SUM(YJ_COUNT)),0) yjCount"); // 议价
		workColumns.add("ISNULL((SUM(KYYK_COUNT)),0) kyykCount"); // 约看
		workColumns.add("ISNULL((SUM(IPCALL_COUNT)),0) ipcallCount"); // 隐号拨打

		// 判断是否开启了加盟模式和查询工作量是否独立的开关（和系统管理-薪资管理共用参数） FUN_PARTNER_CONFIG  WAGE_APART
		Integer partnerIdRange = 0; // 0表示查询所有数据；-1表示查询PARTNER_ID的范围是0和-1；大于0，则表示查询范围是该字段实际的值
		boolean separationConfig = false;
		if (Objects.equal(operator.openPartner(), 1)) { // 开启了加盟模式
			PartnerConfigDto partnerConfigDto = erpFunPartnerConfigService.getPartnerConfiguration(cityId, compId);
			if (null != partnerConfigDto && Objects.equal(partnerConfigDto.getWageApart(), (byte)1)) { // 系统管理-薪资管理自行配置（绩效奖罚、提成配置 0=否 1=是
				partnerIdRange = operator.getPartnerId();
				separationConfig = true;
			}
		}

		// 查询完成数据
		List<LinkedHashMap<String, Object>> statistcMap  = reportFunStatisticTotleMapper.getUcenterWorkCountMap(cityId, compId, rangeType, rangeIdset, workColumns, startTime, deptId, endTime, separationConfig, partnerIdRange);
		// 为空时补数据
		if (statistcMap == null || statistcMap.isEmpty()) {
//			statistcMap = new LinkedHashMap<>();
			LinkedHashMap<String, Object> dataMap = new LinkedHashMap<>();
//			dataMap.put("rangeId", compId);
			dataMap.put("houseAdd", 0);
			dataMap.put("customerAdd", 0);
			dataMap.put("fkCount", 0);
			dataMap.put("fdkCount", 0);
			dataMap.put("gjHouseCount", 0);
//			dataMap.put("ipcallCount", 0);
			dataMap.put("gjCustomerCount", 0);
			dataMap.put("ystjCount", 0);
			dataMap.put("kfdpCount", 0);
			dataMap.put("wtCount", 0);
			dataMap.put("cjCount", 0);
			dataMap.put("tpscCount", 0);
			dataMap.put("vrCount", 0);
			dataMap.put("spscCount", 0);
//			dataMap.put("ckdhCount", 0);
			dataMap.put("qftgCount", 0);

			dataMap.put("pyqCount", 0);
			dataMap.put("mtHouseCount", 0);
			dataMap.put("mtCustomerCount", 0);
			dataMap.put("yjCount", 0);
			dataMap.put("kyykCount", 0);
			dataMap.put("ipcallCount", 0);

			statistcMap.add(dataMap);
		}
		Map<String, Object>  targetMap = erpFunWorkcountTargetMapper.getAppSumWorkCountTargetList(cityId, compId, deptId, rangeType, rangeIdset, dateType, startTime, endTime,separationConfig, partnerIdRange);
		if (targetMap==null){
			targetMap=new HashMap<>();
		}
		List<Map<String, Object>> resultList = new ArrayList<>();
		for(LinkedHashMap<String, Object> dataMap : statistcMap){
			dataMap.remove("rangeId");
			for (String key : dataMap.keySet()) {
				Map<String, Object> map = new HashMap<>();
//			map.put("rangeType", rangeType);
//			map.put("rangeId", rangeId);
				Object count = dataMap.get(key);
				map.put("count", count == null ? 0 : count);
				Object countT = targetMap.get(key + "T");
				map.put("countT", countT == null ? 0 : countT);
				lookRankTypeProcess(map, key);
				if("gjHouseCount".equals(key)){
					map.put("funCust", 1);
					map.put("lookRankType", 9);
				} else if("gjCustomerCount".equals(key)){
					map.put("funCust", 2);
					map.put("lookRankType", 9);
				} else if("houseAdd".equals(key)){
					map.put("funCust", 1);
					map.put("lookRankType", 1);
				} else if("customerAdd".equals(key)){
					map.put("funCust", 2);
					map.put("lookRankType", 1);
				} else if("mtHouseCount".equals(key)){
					map.put("funCust", 1);
					map.put("lookRankType", 46);
				} else if("mtCustomerCount".equals(key)){
					map.put("funCust", 2);
					map.put("lookRankType", 46);
				}
				resultList.add(map);
			}
		}
		//掌通需要这样返回
		Map<String,Object> result=new HashMap<>();
		result.put("list",resultList);
		return ErpResponseJson.ok(result);
	}

	public ResponseJson getAppWorkCountStatisticForOrg(AppWorkAchieveParam param) {
		// 参考接口 /getWorkCountStatistic
		Operator operator = getOperator();
		Integer compId = operator.getCompId();
		Integer cityId = operator.getCityId();
		//加吧，加吧，查询时间段,
		String startTime = param.getStartDate();
		String endTime= param.getEndDate() + " 23:59:59";
		Integer dateType = param.getDateType(); // 考核类型，1=日考核2=周考核3=月考核
		//================================组织架构改版===============================

		//===============================组织架构改版===============================
		// 指定查询哪些工作量
		List<String> workColumns = new ArrayList<>();
		workColumns.add("ISNULL((SUM(iif(case_type in (1,2), DJ_COUNT, 0))),0) houseAdd"); // 房增
		workColumns.add("ISNULL((SUM(iif(case_type in (3,4), DJ_COUNT, 0))),0) customerAdd"); // 客增
		workColumns.add("ISNULL((SUM(FK_COUNT)),0) fkCount"); // 房堪
		workColumns.add("ISNULL((SUM(FDK_COUNT)),0) fdkCount"); // 带看
		workColumns.add("ISNULL((SUM(iif(case_type in (1,2), GJ_COUNT, 0))),0) gjHouseCount"); // 房源跟进
		workColumns.add("ISNULL((SUM(iif(case_type in (3,4), GJ_COUNT, 0))),0) gjCustomerCount"); // 客源跟进
		workColumns.add("ISNULL((SUM(YSTJ_COUNT)),0) ystjCount"); // 钥匙提交
		workColumns.add("ISNULL((SUM(KFDP_COUNT)),0) kfdpCount"); // 看房点评（空看）
		workColumns.add("ISNULL((SUM(WT_COUNT) + SUM(XSWT_COUNT) + SUM(DJWT_COUNT) + SUM(BZWT_COUNT) + SUM(PTWT_COUNT)),0) wtCount"); // 委托
		workColumns.add("ISNULL((SUM(CJ_COUNT)),0) cjCount"); // 签约
		workColumns.add("ISNULL((SUM(TPSC_COUNT)),0) tpscCount"); // 图片上传
		workColumns.add("ISNULL((SUM(VR_COUNT)),0) vrCount");// VR上传量
		workColumns.add("ISNULL((SUM(SPSC_COUNT)),0) spscCount"); // 视频上传
//		workColumns.add("ISNULL((SUM(CKDH_COUNT)),0) ckdhCount"); // 查看电话
		workColumns.add("ISNULL((SUM(QFTG_COUNT)),0) qftgCount"); // 群发推广
		workColumns.add("ISNULL((SUM(PYQ_COUNT)),0) pyqCount"); // 朋友圈分享
//		workColumns.add("ISNULL((SUM(IPCALL_COUNT)),0) ipcallCount");
		workColumns.add("ISNULL((SUM(iif(case_type in (1,2), MT_COUNT, 0))),0) mtHouseCount"); // 房源面谈
		workColumns.add("ISNULL((SUM(iif(case_type in (3,4), MT_COUNT, 0))),0) mtCustomerCount"); // 客源面谈
		workColumns.add("ISNULL((SUM(YJ_COUNT)),0) yjCount"); // 议价
		workColumns.add("ISNULL((SUM(KYYK_COUNT)),0) kyykCount"); // 约看
		workColumns.add("ISNULL((SUM(IPCALL_COUNT)),0) ipcallCount"); // 隐号拨打

		// 判断是否开启了加盟模式和查询工作量是否独立的开关（和系统管理-薪资管理共用参数） FUN_PARTNER_CONFIG  WAGE_APART
		Integer partnerIdRange = 0; // 0表示查询所有数据；-1表示查询PARTNER_ID的范围是0和-1；大于0，则表示查询范围是该字段实际的值
		boolean separationConfig = false;
		if (Objects.equal(operator.openPartner(), 1)) { // 开启了加盟模式
			PartnerConfigDto partnerConfigDto = erpFunPartnerConfigService.getPartnerConfiguration(cityId, compId);
			if (null != partnerConfigDto && Objects.equal(partnerConfigDto.getWageApart(), (byte)1)) { // 系统管理-薪资管理自行配置（绩效奖罚、提成配置 0=否 1=是
				partnerIdRange = operator.getPartnerId();
				separationConfig = true;
			}
		}
		//指定人时defId=-2
		Integer defId = null;
		Integer orgId = null;
		if (null != param.getUserId()) {
			defId = -2;
			orgId = param.getUserId();
		}else if(null!=param.getOrganizationId() && param.getOrganizationId() > 0) {
			defId = 1;
			orgId =  param.getOrganizationId();
		}
		String mangeRangeWhereCauseB= erpFunOrganizationService.getMangeRangeWhereCause(cityId, compId, operator.getUserId(), "b", defId, orgId);
		String mangeRangeWhereCause = mangeRangeWhereCauseB.replaceAll("b\\.", "");

		// 查询完成数据
		List<LinkedHashMap<String, Object>> statistcMap  = reportFunStatisticTotleMapper.getUcenterWorkCountMapForOrg(cityId, compId, workColumns, startTime, endTime, separationConfig, partnerIdRange,mangeRangeWhereCause);
		// 为空时补数据
		if (statistcMap == null || statistcMap.isEmpty()) {
//			statistcMap = new LinkedHashMap<>();
			LinkedHashMap<String, Object> dataMap = new LinkedHashMap<>();
//			dataMap.put("rangeId", compId);
			dataMap.put("houseAdd", 0);
			dataMap.put("customerAdd", 0);
			dataMap.put("fkCount", 0);
			dataMap.put("fdkCount", 0);
			dataMap.put("gjHouseCount", 0);
//			dataMap.put("ipcallCount", 0);
			dataMap.put("gjCustomerCount", 0);
			dataMap.put("ystjCount", 0);
			dataMap.put("kfdpCount", 0);
			dataMap.put("wtCount", 0);
			dataMap.put("cjCount", 0);
			dataMap.put("tpscCount", 0);
			dataMap.put("vrCount", 0);
			dataMap.put("spscCount", 0);
//			dataMap.put("ckdhCount", 0);
			dataMap.put("qftgCount", 0);

			dataMap.put("pyqCount", 0);
			dataMap.put("mtHouseCount", 0);
			dataMap.put("mtCustomerCount", 0);
			dataMap.put("yjCount", 0);
			dataMap.put("kyykCount", 0);
			dataMap.put("ipcallCount", 0);

			statistcMap.add(dataMap);
		}
		Map<String, Object> targetMap = erpFunWorkcountTargetMapper.getAppSumWorkCountTargetListForOrg(cityId, compId, dateType, separationConfig, partnerIdRange,mangeRangeWhereCauseB, startTime,endTime);
		if (targetMap==null){
			targetMap=new HashMap<>();
		}
		List<Map<String, Object>> resultList = new ArrayList<>();
		for(LinkedHashMap<String, Object> dataMap : statistcMap){
			dataMap.remove("rangeId");
			for (String key : dataMap.keySet()) {
				Map<String, Object> map = new HashMap<>();
//			map.put("rangeType", rangeType);
//			map.put("rangeId", rangeId);
				Object count = dataMap.get(key);
				map.put("count", count == null ? 0 : count);
				Object countT = targetMap.get(key + "T");
				map.put("countT", countT == null ? 0 : countT);
				lookRankTypeProcess(map, key);
				if("gjHouseCount".equals(key)){
					map.put("funCust", 1);
					map.put("lookRankType", 9);
				} else if("gjCustomerCount".equals(key)){
					map.put("funCust", 2);
					map.put("lookRankType", 9);
				} else if("houseAdd".equals(key)){
					map.put("funCust", 1);
					map.put("lookRankType", 1);
				} else if("customerAdd".equals(key)){
					map.put("funCust", 2);
					map.put("lookRankType", 1);
				} else if("mtHouseCount".equals(key)){
					map.put("funCust", 1);
					map.put("lookRankType", 46);
				} else if("mtCustomerCount".equals(key)){
					map.put("funCust", 2);
					map.put("lookRankType", 46);
				}
				resultList.add(map);
			}
		}
		//掌通需要这样返回
		Map<String,Object> result=new HashMap<>();
		result.put("list",resultList);
		return ErpResponseJson.ok(result);
	}

	private static Set<Integer> deduceContainRange(List<ErpFunOrganization> orgList) {
		List<Integer> all = orgList.stream().map(ErpFunOrganization::getOrganizationId).collect(Collectors.toList());
		Map<Integer, String> map = orgList.stream().collect(Collectors.toMap(ErpFunOrganization::getOrganizationId, ErpFunOrganization::getOrganizationPath));
		List<Integer> sub = new ArrayList<>();
		for (int i = 0; i < all.size(); i++) {
			for (int j = 0; j < all.size(); j++) {
				String path1 = map.get(all.get(i));
				String path2 = map.get(all.get(j));
				if (!path1.equals(path2) && path2.contains(path1)) {
					sub.add(all.get(j));
				}
			}
		}
		all.removeAll(sub);
		return new HashSet<>(all);
	}


	public static void main(String[] args) {
		long l = System.currentTimeMillis();
		List<ErpFunOrganization> orgList = new ArrayList<>();
		ErpFunOrganization obj = new ErpFunOrganization();
		obj.setOrganizationId(1);
		obj.setOrganizationPath(":1:");
		ErpFunOrganization obj1 = new ErpFunOrganization();
		obj1.setOrganizationId(2);
		obj1.setOrganizationPath(":1:2:");

		ErpFunOrganization obj2 = new ErpFunOrganization();
		obj2.setOrganizationId(3);
		obj2.setOrganizationPath(":1:3:");

		ErpFunOrganization obj3 = new ErpFunOrganization();
		obj3.setOrganizationId(4);
		obj3.setOrganizationPath(":4:");
		orgList.add(obj);
		orgList.add(obj1);
		orgList.add(obj2);
		orgList.add(obj3);
		System.out.println(System.currentTimeMillis()-l);
		Set<Integer> integers = deduceContainRange(orgList);
		System.out.println(integers);
		long l1 = System.currentTimeMillis();
		System.out.println(l1-l);

	}


	private void lookRankTypeProcess(Map<String, Object> map, String key) {
		switch (key) {
			default:
				StatisticDetailType detailType = StatisticDetailType.serachIndexByName(key);
				if (detailType != null) {
					map.put("lookRankType", detailType.getIndex());
				}
			break;
		}
	}

	/**
	 * 手机端工作情况排名
	 * @author 朱科
	 * @since 2018年7月31日
	 * @return
	 */
	@ApiOperation("掌通工作详情排名")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = AppWorkCountResultDto.class, message = "成功")
	})
	@ResponseBody
	@PostMapping("/getAppWorkCountStatisticRank")
	public ResponseJson getAppWorkCountStatisticRank(@RequestBody AppWorkCountParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer dateType = param.getDateType(); // 时间类型，1=今日 2=本周
		Integer rangeType = param.getRangeType(); // 2:大区3：片区 4：门店 5：分组 6：到人
		Integer rangeId = param.getRangeId(); // 排名范围id
		//掌通需要这样返回
		Map<String,Object> result=new HashMap<>();
		if (rangeType == 1) {
			rangeId = operator.getCompId();
		}
		Integer achievementType = param.getAchievementType(); // 完成类型 1=完成量，2=完成率  3 =人均完成量 4=完成总量
		Integer lookRankType = param.getLookRankType();// 查看类型
		Integer funCust = param.getFunCust();// 区分房客源的参数
		Integer deptId=param.getDeptId(); //未分组的时候传
		// 分页查询还是TOP查询 参数待定
		if (null == lookRankType || dateType == null) {
			result.put("list", new ArrayList<>());
			return ErpResponseJson.ok(result);
		}
		//这里都是查单个指标
		String startTime = null;
		String[] detailTypeStr = this.assembleStatisticDetailType(lookRankType, funCust);
		String workColumn = detailTypeStr[0];
		String workTargetColumn = detailTypeStr[1];
		// dateType=1 今日，2=本周
		startTime = dateType == 1 ? DateTimeHelper.formatDatetoString(new Date()) : DateUtil.getConditionDate("12")[0];
		Set<Integer> rangeIds = new HashSet<>();
		Map<Integer, String> rangeNameMap = null;
		//获取所选范围范围下一级的内容
		switch (rangeType) {
			case 1:
				//没有开启大区时直接查片区
				if ("0".equals(operator.getAreaFlag())){
					List<ErpFunRegion> erpFunRegions = erpFunRegionMapper.selectRegListRank(cityId, compId, rangeId);
					if (erpFunRegions != null && erpFunRegions.size() > 0) {
						rangeIds = erpFunRegions.stream().collect(Collectors.mapping(val -> val.getRegId(), Collectors.toSet()));
						rangeNameMap = erpFunRegions.stream().collect(Collectors.toMap(ErpFunRegion::getRegId, val -> val.getRegName()));
					}
					break;
				}
				List<ErpFunArea> funAreaList = erpFunAreaMapper.getDataListByCompId(cityId, rangeId.toString());
				if (funAreaList != null && funAreaList.size() > 0){
					rangeIds=funAreaList.stream().collect(Collectors.mapping(val->val.getAreaId(),Collectors.toSet()));
					rangeNameMap=funAreaList.stream().collect(Collectors.toMap(ErpFunArea::getAreaId, val->val.getAreaName()));
				}
				break;
			case 2:
				List<ErpFunRegion> erpFunRegions = erpFunRegionMapper.selectRegListRank(cityId, compId, rangeId);
				if (erpFunRegions != null && erpFunRegions.size() > 0) {
					rangeIds = erpFunRegions.stream().collect(Collectors.mapping(val -> val.getRegId(), Collectors.toSet()));
					rangeNameMap = erpFunRegions.stream().collect(Collectors.toMap(ErpFunRegion::getRegId, val -> val.getRegName()));
				}
				break;
			case 3:
				List<ErpFunDepts> erpFunDepts = erpFunDeptsMapper.selectFunDeptsListRank(cityId, compId, null, rangeId);
				if (erpFunDepts != null && erpFunDepts.size() > 0) {
					rangeIds = erpFunDepts.stream().collect(Collectors.mapping(val -> val.getDeptId(), Collectors.toSet()));
					rangeNameMap = erpFunDepts.stream().collect(Collectors.toMap(ErpFunDepts::getDeptId, val -> val.getDeptName()));
				}
				break;
			case 4:
				List<ErpFunDeptsgroup> groupList = erpFunDeptsgroupMapper.selectGroupListRank(cityId, compId, rangeId, startTime);
				//门店下可能没有分组
				if (groupList == null) {
					groupList = new ArrayList<>();
				}
				rangeIds = groupList.stream().collect(Collectors.mapping(val -> val.getGrId(), Collectors.toSet()));
				rangeNameMap = groupList.stream().collect(Collectors.toMap(ErpFunDeptsgroup::getGrId, val -> val.getGrName()));
				//未分组的的情况
				List<ErpFunUsers> unGroupUserList = erpFunUsersMapper.getDeptUngroupUsers(cityId, compId, rangeId, startTime);
				if (unGroupUserList != null && unGroupUserList.size() > 0) {
					rangeIds.add(0);
					rangeNameMap.put(0, "未分组");
				}
				break;
			case 5:
				List<ErpFunUsers> funUsersList = erpFunUsersMapper.selectUserListRank(cityId, compId, rangeId, startTime,deptId);
				if (funUsersList != null && funUsersList.size() > 0) {
					rangeIds = funUsersList.stream().collect(Collectors.mapping(val -> val.getUserId(), Collectors.toSet()));
					rangeNameMap = funUsersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, val -> val.getUserName()));
				}
				break;
		}
		if (rangeIds == null || rangeIds.isEmpty()) {
			result.put("list", new ArrayList<>());
			return ErpResponseJson.ok(result);
		}
		List<Map<String, Object>> statistcList = null;
		//查询选择范围下一级
		rangeType += 1;
		if (rangeIds.size() > 0) {
			statistcList = reportFunStatisticTotleMapper.getAppUcenterWorkCountRank(cityId, compId, null,workColumn, startTime, null, rangeType, rangeIds,rangeId);
		}
		if (statistcList == null) {
			statistcList = new ArrayList<>();
		}
		//补数据
		Map<Integer, Map<String, Object>> statistcMap = statistcList.stream().collect(Collectors.toMap(val -> StringUtil.parseInteger(val.get("rangeId")), val -> val));
		for (Integer rangeIdIn : rangeIds) {
			if (statistcMap.get(rangeIdIn) != null) {
				continue;
			}
			Map<String, Object> map = new HashMap<>();
			map.put("rangeId", rangeIdIn);
			map.put("count", 0);
			statistcList.add(map);
		}
		List<Map<String, Integer>> targetCountList=new ArrayList<>();
		// lookRankType=16 语音日志 没有目标
		if (lookRankType != 16) {
			targetCountList = erpFunWorkcountTargetMapper.getUcenterWorkCountTargetList(cityId,
					compId, null, rangeType, rangeIds, dateType, startTime, workTargetColumn, rangeId);
		}
		//补数据
		Map<Integer, Map<String, Integer>> targetCountMap = targetCountList.stream().collect(Collectors.toMap(val -> val.get("rangeId"), val -> val));
		for (Integer rangeIdIn : rangeIds) {
			if (targetCountMap.get(rangeIdIn) != null) {
				continue;
			}
			Map<String, Integer> map = new HashMap<>();
			map.put("rangeId", rangeIdIn);
			map.put("countT", 0);
			map.put("countUser", 0);
			targetCountList.add(map);
		}
		targetCountMap = targetCountList.stream().collect(Collectors.toMap(val -> val.get("rangeId"), val -> val));
		for (Map<String, Object> map : statistcList) {
			Integer rangeIdTmp = (Integer) map.get("rangeId");
			String rangeName = rangeNameMap.get(rangeIdTmp);
			map.put("rangeName", rangeName);
			map.put("lookRankType", lookRankType);
			map.put("achievementType", achievementType);

			Map<String, Integer> targetMap = targetCountMap.get(rangeIdTmp);
			Integer countT = targetMap.get("countT");
			Integer countUser = targetMap.get("countUser");
			Integer count = (Integer) map.get("count");
			map.put("countT", countT);
			map.put("assessmentTotal", countUser);
			map.put("achievementTotalRank", count);
			//完成率
			if (achievementType == 2) {
				if (count == 0 || countT == 0) {
					map.put("completeRatio", 0.0);
					continue;
				}
				BigDecimal b1 = new BigDecimal(count);
				BigDecimal b2 = new BigDecimal(countT);
				double completeRatio = b1.divide(b2, 5, BigDecimal.ROUND_HALF_UP).doubleValue();
				map.put("completeRatio", completeRatio);
			}
			//完成量人均排名
			if (achievementType == 3) {
				if (countUser == 0 || count == 0) {
					map.put("achievementPersonalRank", 0.0);
					continue;
				}
				BigDecimal b1 = new BigDecimal(count);
				BigDecimal b2 = new BigDecimal(countUser);
				double achievementPersonalRank = b1.divide(b2, 5, BigDecimal.ROUND_HALF_UP).doubleValue();

				map.put("achievementPersonalRank", achievementPersonalRank);
			}
			//完成量总量排名
			if (achievementType == 4) {
				map.put("achievementTotalRank", count);
			}
		}
		//完成量人均排名 重新排序
		if (achievementType == 3) {
			statistcList.sort((o1, o2) -> {
				Double personalRank1 = (Double) o1.get("achievementPersonalRank");
				Double personalRank2 = (Double) o2.get("achievementPersonalRank");
				return personalRank2.compareTo(personalRank1);
			});
		}
		//完成率排名
		if (achievementType == 2) {
			statistcList.sort((o1, o2) -> {
				Double completeRatio1 = (Double) o1.get("completeRatio");
				Double completeRatio2 = (Double) o2.get("completeRatio");
				return completeRatio2.compareTo(completeRatio1);
			});
		}
		result.put("list",statistcList);
		return ErpResponseJson.ok(result);
	}

	private String[] assembleStatisticDetailType(Integer lookRankType, Integer funCust){
		String workColumn = null;
		String workTargetColumn = null;
		for (StatisticDetailType type : StatisticDetailType.values()) {
			Integer index = type.getIndex();
			if(lookRankType == 9 && funCust == 1){
				workColumn = "SUM(iif(case_type in (1,2), GJ_COUNT, 0))";
				workTargetColumn = "sum(GJ_HOUSE_COUNT)";
			} else if(lookRankType == 9 && funCust == 2){
				workColumn = "SUM(iif(case_type in (3,4), GJ_COUNT, 0))";
				workTargetColumn = "sum(GJ_CUSTOMER_COUNT)";
			} else if(lookRankType == 14){
				workColumn = "SUM(SPSC_COUNT)";
				workTargetColumn = "sum(SP_COUNT)";
			} else if(lookRankType == 30){
				workColumn = "SUM(QFTG_COUNT)";
				workTargetColumn = "sum(HOUSE_FAFA_COUNT)";
			} else if(lookRankType == 24){
				workColumn = "SUM(PYQ_COUNT)";
				workTargetColumn = "sum(POST_SHARE_COUNT)";
			} else if(lookRankType == 1 && funCust == 1){
				workColumn = "SUM(iif(case_type in (1,2), DJ_COUNT, 0))";
				workTargetColumn = "sum(HOUSE_ADD)";
			} else if(lookRankType == 1 && funCust == 2){
				workColumn = "SUM(iif(case_type in (3,4), DJ_COUNT, 0))";
				workTargetColumn = "sum(CUSTOMER_ADD)";
			} else if(lookRankType == 35){
				workColumn = "SUM(FDK_COUNT)";
				workTargetColumn = "sum(DK_COUNT)";
			} else if(lookRankType == 11){
				workColumn = "SUM(YSTJ_COUNT)";
				workTargetColumn = "sum(YS_COUNT)";
			} else if(lookRankType == 23){
				workColumn = "SUM(KFDP_COUNT)";
				workTargetColumn = "sum(KK_COUNT)";
			} else if(lookRankType == 8){
				workColumn = "SUM(WT_COUNT)+SUM(XSWT_COUNT)+SUM(DJWT_COUNT)+SUM(BZWT_COUNT)+SUM(PTWT_COUNT)";
				workTargetColumn = "SUM(WT_COUNT)";
			} else if(lookRankType == 20){
				workColumn = "SUM(CJ_COUNT)";
				workTargetColumn = "sum(SIGN_DEAL_COUNT)";
			} else if (lookRankType == 16) {//语音统计没有目标量
				workColumn = "SUM(IPCALL_COUNT)";
			} else if(lookRankType == 46 && funCust == 1){
				workColumn = "SUM(iif(case_type in (1,2), MT_COUNT, 0))";
				workTargetColumn = "sum(MT_HOUSE_COUNT)";
			} else if(lookRankType == 46 && funCust == 2){
				workColumn = "SUM(iif(case_type in (3,4), MT_COUNT, 0))";
				workTargetColumn = "sum(MT_CUSTOMER_COUNT)";
			} else if(lookRankType.equals(index)){
				String humpName = type.getHumpName();
				humpName = humpName.substring(0, humpName.length()-5)+ "_" + humpName.substring(humpName.length()-5, humpName.length());
				workColumn = "sum(" + humpName + ")";
				workTargetColumn = "sum(" + humpName + ")";
			}
		}
		return new String[]{workColumn, workTargetColumn};
	}

	/**
	 * 手机端人均完成量查询
	 * @author 朱科
	 * @since 2018年8月2日
	 * @return
	 */
	@ApiOperation("掌通工作详情排名")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = AppWorkCountResultDto.class, message = "成功")
	})
	@ResponseBody
	@PostMapping("/getAppWorkCountAverageStatistic")
	public ResponseJson getAppWorkCountAverageStatistic(@RequestBody AppWorkCountParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer dateType = param.getDateType(); // 时间类型，1=今日 2=本周
		Integer rangeType = param.getRangeType(); // 1:公司 2:大区3：片区 4：门店 5：分组 6：到人
		Integer rangeId = param.getRangeId(); // 排名范围id
		if (rangeType == 1) {
			rangeId = operator.getCompId();
		}
		Integer deptId = param.getDeptId(); //未分组的时候传
		List<Map<String,Object>> resultList = new ArrayList<>();
		Integer userCount = 1;
		if(null == rangeType){
			throw new BusinessException("范围低于门店，测试时抛异常！");
		}
		Map<String,Object> resultMap = new HashMap<>();
		String startTime = null;
		String rangeName = "";
		// 指定查询哪些工作量
		List<String> workColumns = new ArrayList<>();
		if(dateType == 1){
			workColumns.add("ISNULL((SUM(iif(case_type in (1,2), GJ_COUNT, 0))),0) gjHouseCount");
			workColumns.add("ISNULL((SUM(iif(case_type in (3,4), GJ_COUNT, 0))),0) gjCustomerCount");
			workColumns.add("ISNULL((SUM(TPSC_COUNT)),0) tpscCount");
			workColumns.add("ISNULL((SUM(SPSC_COUNT)),0) spscCount");
			workColumns.add("ISNULL((SUM(CKDH_COUNT)),0) ckdhCount");
			workColumns.add("ISNULL((SUM(IPCALL_COUNT)),0) ipcallCount");
			workColumns.add("ISNULL((SUM(VR_COUNT)),0) vrCount");
			workColumns.add("ISNULL((SUM(QFTG_COUNT)),0) qftgCount");
			workColumns.add("ISNULL((SUM(PYQ_COUNT)),0) pyqCount");
		} else {
			workColumns.add("ISNULL((SUM(iif(case_type in (1,2), DJ_COUNT, 0))),0) houseAdd");
			workColumns.add("ISNULL((SUM(iif(case_type in (3,4), DJ_COUNT, 0))),0) customerAdd");
			workColumns.add("ISNULL((SUM(FK_COUNT)),0) fkCount");
			workColumns.add("ISNULL((SUM(FDK_COUNT)),0) fdkCount");
			workColumns.add("ISNULL((SUM(YSTJ_COUNT)),0) ystjCount");
			workColumns.add("ISNULL((SUM(KFDP_COUNT)),0) kfdpCount");
			workColumns.add("ISNULL(((SUM(WT_COUNT)+SUM(XSWT_COUNT)+SUM(DJWT_COUNT)+SUM(BZWT_COUNT)+SUM(PTWT_COUNT))),0) wtCount");
			workColumns.add("ISNULL((SUM(CJ_COUNT)),0) cjCount");
		}
		if(dateType == 1) {
			startTime = DateTimeHelper.formatDatetoString(new Date()); // 今日
		} else {
			startTime = DateUtil.getConditionDate("12")[0]; // 本周
		}
		// 根据范围ID去查对应的名字
		if(1 == rangeType){
			ErpFunComp erpFunComp = new ErpFunComp();
			erpFunComp.setCompId(compId);
			erpFunComp.setShardCityId(cityId);
			erpFunComp = erpFunCompMapper.getCompInfoByCompId(erpFunComp);
			rangeName = erpFunComp.getCompCname();
		} else if(2 == rangeType){
			ErpFunArea erpFunArea = erpFunAreaMapper.getAreaByAreaId(cityId, compId, rangeId);
			rangeName = erpFunArea.getAreaName();
		} else if(3 == rangeType){
			ErpFunRegion erpFunRegion = erpFunRegionMapper.getDataById(cityId, rangeId);
			rangeName = erpFunRegion.getRegName();
		} else if(4 == rangeType){
			ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(cityId, rangeId);
			rangeName = erpFunDepts.getDeptName();
		} else if (5 == rangeType){
			if(null != deptId){
				rangeName = "未分组";
			} else {
				ErpFunDeptsgroup erpFunDeptsgroup = erpFunDeptsgroupMapper.getModelDataById(cityId, compId, rangeId);
				rangeName = erpFunDeptsgroup.getGrName();
			}
		} else if (6 == rangeType){
			ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(cityId, rangeId);
			rangeName = erpFunUsers.getUserName();
		}
		// 统计门店的总量 ,用LinkedHashMap是为了排序
		List<LinkedHashMap<String,Integer>> averageStatisticList = reportFunStatisticTotleMapper.getAppWorkCountAverageStatistic(cityId, compId, rangeId, rangeType, workColumns, startTime,deptId);
		if(null == averageStatisticList || averageStatisticList.size() <= 0){
			resultMap.put("list", averageStatisticList);
			return ErpResponseJson.ok(resultMap);
		}
		if(rangeType > 5){
			for (Map<String, Integer> statisticList : averageStatisticList) {
				for (String key : statisticList.keySet()) {
					Map<String, Object> subMap = new HashMap<>();
					lookRankTypeProcess(subMap, key);
					if("gjHouseCount".equals(key)){
						subMap.put("funCust", 1);
						subMap.put("lookRankType", 9);
					} else if("gjCustomerCount".equals(key)){
						subMap.put("funCust", 2);
						subMap.put("lookRankType", 9);
					} else if("houseAdd".equals(key)){
						subMap.put("funCust", 1);
						subMap.put("lookRankType", 1);
					} else if("customerAdd".equals(key)){
						subMap.put("funCust", 2);
						subMap.put("lookRankType", 1);
					}
					subMap.put("rangeId", rangeId);
					subMap.put("rangeType", rangeType);
					subMap.put("rangeName", rangeName);
					resultList.add(subMap);
				}}
			resultMap.put("list", resultList);
			return ErpResponseJson.ok(resultMap);
		}
		// 统计门店的总人数
		List<ErpFunUsers> userList = erpFunUsersMapper.getSpecifiedTimeUserList(cityId, compId, rangeType, rangeId,startTime,deptId);
		if(null != userList && !userList.isEmpty()){
			userCount = userList.size();
		}
		for (Map<String, Integer> statisticList : averageStatisticList) {
			for (String key : statisticList.keySet()) {
				Map<String, Object> subMap = new HashMap<>();
				lookRankTypeProcess(subMap, key);
				if("gjHouseCount".equals(key)){
					subMap.put("funCust", 1);
					subMap.put("lookRankType", 9);
				} else if("gjCustomerCount".equals(key)){
					subMap.put("funCust", 2);
					subMap.put("lookRankType", 9);
				} else if("houseAdd".equals(key)){
					subMap.put("funCust", 1);
					subMap.put("lookRankType", 1);
				} else if("customerAdd".equals(key)){
					subMap.put("funCust", 2);
					subMap.put("lookRankType", 1);
				}
				Integer value = statisticList.get(key);
				if (null == value) {
					value = 0;
				}
				Double doubleValue = value.doubleValue();
				String resultValue = NumberHelper.formatNumber(doubleValue / userCount, NumberHelper.NUMBER_IN_5);
				subMap.put("personalRatio", resultValue);
				subMap.put("rangeId", rangeId);
				subMap.put("rangeType", rangeType);
				subMap.put("rangeName", rangeName);
				//掌通的哥们说视频上传放在第一位
				if (subMap.get("lookRankType").equals(14)) {
					resultList.add(0, subMap);
				} else {
					resultList.add(subMap);
				}
			}
		}
		resultMap.put("list", resultList);
		return ErpResponseJson.ok(resultMap);
	}

	@ApiOperation("掌通运营情况工作量,需求=8459，作者：朱科")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = AppWorkCountStatisticsRankDto.class, message = "成功")
	})
	@ResponseBody
	@PostMapping("/getAppWorkCountAchieveStatisticsRangeRank")
	public ResponseJson getAppWorkCountAchieveStatisticsRangeRank(@RequestBody AppWorkCountStatisticsRankParam param) {
		Operator operator = getOperator();
		//---------------------------新版组织机构-------------------------------
		if (operator.newOrganizationType()) {
			OrganizationQueryParam paramNew = new OrganizationQueryParam();
			BeanUtils.copyProperties(param,paramNew);
			Map<String, Object> resultMap = getResultForOrganization(paramNew);
			return ErpResponseJson.ok(resultMap);
		}
		//---------------------------新版组织机构-------------------------------
		Integer compId = operator.getCompId();
		Integer cityId = operator.getCityId();
		String areaFlag = operator.getAreaFlag();
		Integer lookType = param.getLookType(); // 2=按大区3=按片区4=按门店5=按分组6按员工
		String rangeIds = param.getRangeIds(); // 管理范围ID
		Integer rangeType = param.getRangeType(); // 管理范围类型
		Integer lookRankType = param.getLookRankType();
		Integer funCust = param.getFunCust();
		Integer deptId = param.getDeptId();
		String startDate = param.getStartDate();
		String endDate = param.getEndDate() + " 23:59:59";
		Integer dateType = param.getDateType();
		Integer grId = param.getGrId();
		Integer areaId = param.getAreaId();
		Integer regId = param.getRegId();
		Integer fjdRangeType = param.getFjdRangeType();
		
		boolean isFjdFlag = false;
		if (adminFunCompService.judgerIsFangjidi(operator.getAdminCompId()) && null != fjdRangeType && Integer.valueOf(6).equals(param.getLookType())) {// 是房基地的公司
			ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(cityId, operator.getUserId());
			int userLevel = 0;
			if (null != erpFunUsers) {
				userLevel = erpFunUsers.getUserLevel();
			}
			String[] operArr = new String[]{"VIEW_ALL_ZX_WORK", "VIEW_T_ALL_NODE_ZX_WORK", "VIEW_T_ZX_WORK"};
			Set<String> userOpers = erpUserOpersMapper.getUsersOpersByUserId(cityId, operator.getUserId(), operArr);
			
			if (Integer.valueOf(1).equals(fjdRangeType)) {
				rangeType = 6;
				isFjdFlag = true;
				if (userOpers.isEmpty()) {
					rangeIds = operator.getUserId().toString();
				} else {
					AssessCountDataParam tempParam = new AssessCountDataParam();
					tempParam.setCompId(compId);
					tempParam.setUserId(operator.getUserId());
					if (userOpers.contains("VIEW_ALL_ZX_WORK")) {
						List<Integer> userIdList = erpFunUsersMapper.getAllCompUserIds(cityId, compId);
						rangeIds = userIdList.stream().filter(val -> null != val).map(val -> val.toString()).collect(Collectors.joining(","));
					} else if (userOpers.contains("VIEW_T_ALL_NODE_ZX_WORK")) {
						List<AssessRoleCountDataVo> userTreamList = erpFunUsersMapper.getUserTeamList(cityId, null, tempParam);
						rangeIds = userTreamList.stream().filter(val -> null != val.getUserId()).map(val -> val.getUserId().toString()).collect(Collectors.joining(","));
					} else if (userOpers.contains("VIEW_T_ZX_WORK")) {
						userLevel += 2;
						tempParam.setUserLevel(userLevel);
						List<AssessRoleCountDataVo> userTreamList = erpFunUsersMapper.getUserTeamList(cityId, null, tempParam);
						rangeIds = userTreamList.stream().filter(val -> null != val.getUserId()).map(val -> val.getUserId().toString()).collect(Collectors.joining(","));
					}
				}
			} else if (Integer.valueOf(2).equals(fjdRangeType)) {
				rangeType = 6;
				isFjdFlag = true;
				if (userOpers.isEmpty()) {
					rangeIds = operator.getUserId().toString();
				} else {
					AssessCountDataParam tempParam = new AssessCountDataParam();
					tempParam.setCompId(compId);
					tempParam.setUserId(operator.getUserId());
					if (userOpers.contains("VIEW_T_ALL_NODE_ZX_WORK")) {
						List<AssessRoleCountDataVo> userTreamList = erpFunUsersMapper.getUserTeamList(cityId, null, tempParam);
						rangeIds = userTreamList.stream().filter(val -> null != val.getUserId()).map(val -> val.getUserId().toString()).collect(Collectors.joining(","));
					} else if (userOpers.contains("VIEW_T_ZX_WORK")) {
						userLevel += 2;
						tempParam.setUserLevel(userLevel);
						List<AssessRoleCountDataVo> userTreamList = erpFunUsersMapper.getUserTeamList(cityId, null, tempParam);
						rangeIds = userTreamList.stream().filter(val -> null != val.getUserId()).map(val -> val.getUserId().toString()).collect(Collectors.joining(","));
					}
				}
			}
		}
		if(null == regId){
			regId = getOperator().getRegId();
		}
		if(null == areaId){
			areaId = getOperator().getAreaId();
		}
		Set<Integer> rangeIdset = new HashSet<>(); // 查询的范围Ids
		String[] idArr = rangeIds.split(",");
		for (String ids : idArr) {
			Integer rangeId = StringUtil.paseInteger(ids, 0);
			rangeIdset.add(rangeId);
		}
		//加盟商模式下
		List<Integer> partnerIds = deducePartnerWageRange(operator);
		// 查询对应的名字
		Map<Integer, String> areaMap = new HashMap<Integer, String>();
		Map<Integer, String> regMap = new HashMap<Integer, String>();
		Map<Integer, String> deptMap = new HashMap<Integer, String>();
		Map<Integer, Integer> deptRegMap = new HashMap<Integer, Integer>();
		Map<Integer, String> grMap = new HashMap<Integer, String>();
		Map<String, String> lookGrMap = new HashMap<String, String>();
		Map<Integer, ErpFunUsers> userMap = new HashMap<Integer, ErpFunUsers>();
		if (1 == rangeType) {
			rangeType = compId;
			// 查询公司是否开启大区
			// 开启了大区的公司才查大区
			// 查公司下面的大区
			List<ErpFunArea> areasList = erpFunAreaMapper.getDataListByCompId(cityId, compId.toString());
			areaMap = areasList.stream().collect(Collectors.toMap(ErpFunArea::getAreaId, ErpFunArea::getAreaName));
			rangeIdset = areasList.stream().collect(Collectors.mapping(ErpFunArea::getAreaId, Collectors.toSet()));
			rangeType = 2;
		} else if(2 == rangeType){
			List<ErpFunArea> areaList = erpFunAreaMapper.selectAreaList(cityId, compId, rangeType, rangeIdset, startDate);
			areaMap = areaList.stream().collect(Collectors.toMap(ErpFunArea::getAreaId, ErpFunArea::getAreaName));
			rangeIdset = areaList.stream().collect(Collectors.mapping(ErpFunArea::getAreaId, Collectors.toSet()));
			rangeType = 2;
		} else if(3 == rangeType){
			ErpFunRegionExample funRegionExample = new ErpFunRegionExample();
			funRegionExample.createCriteria().andCompIdEqualTo(compId).andRegIdIn(new ArrayList<>(rangeIdset)).andIsDelEqualTo((byte) 0);
			funRegionExample.setShardCityId(cityId);
			List<ErpFunRegion> regsList = erpFunRegionMapper.selectByExample(funRegionExample);
			regMap = regsList.stream().collect(Collectors.toMap(ErpFunRegion::getRegId, ErpFunRegion::getRegName));
			rangeIdset = regsList.stream().collect(Collectors.mapping(ErpFunRegion::getRegId, Collectors.toSet()));
			rangeType = 3;
		} else if(4 == rangeType){
			List<ErpFunDepts> funDeptsList = erpFunDeptsMapper.getDeptListByDeptIds(cityId, rangeIdset);
			//加盟商模式下
			if (java.util.Objects.nonNull(partnerIds) && !partnerIds.isEmpty()) {
				funDeptsList = funDeptsList.stream().filter(dept->partnerIds.contains(dept.getPartnerId())).collect(Collectors.toList());
			}
			deptMap = funDeptsList.stream().collect(Collectors.toMap(ErpFunDepts::getDeptId, ErpFunDepts::getDeptName));
			deptRegMap = funDeptsList.stream().collect(Collectors.toMap(ErpFunDepts::getDeptId, ErpFunDepts::getRegId));
			rangeIdset = funDeptsList.stream().collect(Collectors.mapping(ErpFunDepts::getDeptId, Collectors.toSet()));
			rangeType = 4;
		} else if(5 == rangeType){
//			ErpFunDeptsgroupExample example = new ErpFunDeptsgroupExample();
//			example.createCriteria().andCompIdEqualTo(compId).andGrIdIn(new ArrayList<>(rangeIdset)).andIsDelEqualTo((byte)0);
//			example.setShardCityId(cityId);
//			List<ErpFunDeptsgroup> groupList = erpFunDeptsgroupMapper.selectByExample(example);
//			rangeIdset = groupList.stream().collect(Collectors.mapping(ErpFunDeptsgroup::getGrId, Collectors.toSet()));
//			rangeType = 5;
//			if(rangeIdset.isEmpty()){
//				rangeIdset.add(0);
//			}
		} else {
			List<ErpFunUsers> usersList = erpFunUsersMapper.getUserListByUserIds(cityId, rangeIdset);
			//加盟商模式下
			if (java.util.Objects.nonNull(partnerIds) && !partnerIds.isEmpty()) {
				usersList = usersList.stream().filter(obj-> partnerIds.contains(obj.getPartnerId())).collect(Collectors.toList());
			}
			userMap = usersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, val -> val));
		}
		Map<Integer, Integer> grDeptMap = new HashMap<Integer, Integer>();
		if(null != lookType && 2 == lookType && "1".equals(areaFlag)){
			List<ErpFunArea> areaList = erpFunAreaMapper.selectAreaList(cityId, compId, rangeType, rangeIdset, null);
			areaMap = areaList.stream().collect(Collectors.toMap(ErpFunArea::getAreaId, ErpFunArea::getAreaName));
		} else if(null != lookType && 3 == lookType){
			List<ErpFunRegion> regList = erpFunRegionMapper.selectRegList(cityId, compId, rangeType, rangeIdset, null);
			regMap = regList.stream().collect(Collectors.toMap(ErpFunRegion::getRegId, ErpFunRegion::getRegName));
		} else {
			List<ErpFunDepts> deptsList = new ArrayList<>();
			if(null != lookType && 4 == lookType && rangeType < 5){
				deptsList = erpFunDeptsMapper.selectFunDeptsList(cityId, compId, rangeType, rangeIdset);
			} else {
				deptsList = erpFunDeptsMapper.getCacheableDeptListByCompId(cityId, compId);
			}
			//加盟商模式下
			if (java.util.Objects.nonNull(partnerIds) && !partnerIds.isEmpty()) {
				deptsList = deptsList.stream().filter(obj-> partnerIds.contains(obj.getPartnerId())).collect(Collectors.toList());
			}
			deptMap = deptsList.stream().collect(Collectors.toMap(ErpFunDepts::getDeptId, ErpFunDepts::getDeptName));
			deptRegMap = deptsList.stream().collect(Collectors.toMap(ErpFunDepts::getDeptId, ErpFunDepts::getRegId));
			List<ErpFunDeptsgroup> groupList = new ArrayList<>();
			if(6 != rangeType){
				groupList = erpFunDeptsgroupMapper.selectGroupList(cityId, compId, rangeType, rangeIdset);
			} else {
				List<ErpFunUsers> userList = erpFunUsersMapper.getUserListByUserIds(cityId, rangeIdset);
				Set<Integer> grIds = userList.stream().collect(Collectors.mapping(ErpFunUsers::getGrId, Collectors.toSet()));
				groupList = erpFunDeptsgroupMapper.selectGroupList(cityId, compId, 5, grIds);
			}
			//加盟商模式下
			if (java.util.Objects.nonNull(partnerIds) && !partnerIds.isEmpty()) {
				groupList = groupList.stream().filter(obj-> partnerIds.contains(obj.getPartnerId())).collect(Collectors.toList());
			}
			grMap = groupList.stream().collect(Collectors.toMap(ErpFunDeptsgroup::getGrId, ErpFunDeptsgroup::getGrName));
			if(null != lookType){
				lookGrMap = groupList.stream().collect(HashMap::new, (m, v) -> m.put(v.getDeptId() + "_" + v.getGrId(), v.getGrName()), HashMap::putAll);
				if(lookGrMap.isEmpty()){
					lookGrMap.put(operator.getDeptId() + "_" + operator.getGrId(), "未分组");
				}
			}
			grDeptMap = groupList.stream().collect(Collectors.toMap(ErpFunDeptsgroup::getGrId, ErpFunDeptsgroup::getDeptId));
			if(grDeptMap.isEmpty()){
				grDeptMap.put(0, operator.getDeptId());
			}
			// 备注，只有分组和个人范围才需要用到门店
			if(null != rangeType && rangeType < 5){
				deptId = null;
			}
			if(6 != rangeType){
				List<ErpFunUsers> usersList = erpFunUsersMapper.selectUserList(cityId, compId, deptId, rangeType, rangeIdset, startDate);
				//加盟商模式下
				if (java.util.Objects.nonNull(partnerIds) && !partnerIds.isEmpty()) {
					usersList = usersList.stream().filter(obj-> partnerIds.contains(obj.getPartnerId())).collect(Collectors.toList());
				}
				userMap = usersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, val -> val));
			}
		}
		String[] detailTypeStr = this.assembleStatisticDetailType(lookRankType, funCust);
		String workColumn = detailTypeStr[0];
		String workTargetColumn = detailTypeStr[1];
		List<Map<String, Integer>> targetCountList = new ArrayList<>();
		if (lookRankType != 16) {
			if(null != lookType){
				targetCountList =  erpFunWorkcountTargetMapper.getTargetList(cityId,
						compId, partnerIds, rangeType, rangeIdset, dateType, endDate, workTargetColumn, deptId, lookType);
			} else {
				targetCountList = erpFunWorkcountTargetMapper.getUcenterWorkCountTargetList(cityId,
						compId,partnerIds, rangeType, rangeIdset, dateType, endDate, workTargetColumn, deptId);
			}
		}
		// 完成量
		List<Map<String, Object>> statistcList = null;
		List<Map<String, Object>> grStatistcList = null;
		//查询选择范围下一级
		if (rangeIdset.size() > 0) {
			if(null != lookType){
				statistcList = reportFunStatisticTotleMapper.getAppUcenterWorkCountRankByType(cityId, compId,partnerIds, workColumn, startDate, endDate, rangeType, rangeIdset, deptId, lookType);
				if(lookType == 5){
					grStatistcList = reportFunStatisticTotleMapper.getLookTypeAppUcenterWorkCountRankByGrIds(cityId, compId,partnerIds, workColumn, startDate, endDate, rangeType, rangeIdset, deptId, lookType);
				}
			} else {
				// 分组单独处理
				statistcList = reportFunStatisticTotleMapper.getAppUcenterWorkCountRank(cityId, compId,partnerIds, workColumn, startDate, endDate, rangeType, rangeIdset, deptId);
				if(rangeType == 5){
					grStatistcList = reportFunStatisticTotleMapper.getAppUcenterWorkCountRankByGrIds(cityId, compId,partnerIds,workColumn, startDate, endDate, rangeType, rangeIdset, deptId);
				}
			}
		}
		if (statistcList == null) {
			statistcList = new ArrayList<>();
		}
		Map<Object, Map<String, Object>> statistcMap = new HashMap<>();
		Map<Object, Map<String, Object>> subMap = new HashMap<>();
		Map<Object, Map<String, Object>> grStatistcMap = new HashMap<>();
		if(null != lookType){
			if(lookType == 2){
				statistcMap = statistcList.stream().collect(HashMap::new, (m, v) -> m.put(v.get("AREA_ID"), v), HashMap::putAll);
			} else if(lookType == 3){
				statistcMap = statistcList.stream().collect(HashMap::new, (m, v) -> m.put(v.get("REG_ID"), v), HashMap::putAll);
			} else if(lookType == 4){
				statistcMap = statistcList.stream().collect(HashMap::new, (m, v) -> m.put(v.get("DEPT_ID"), v), HashMap::putAll);
			} else if(lookType == 5){
				statistcMap = statistcList.stream().collect(HashMap::new, (m, v) -> m.put(v.get("GR_ID"), v), HashMap::putAll);
				grStatistcMap = grStatistcList.stream().collect(Collectors.toMap(val -> (String)val.get("DEPT_GR_USER"), val -> val));
			} else if(lookType == 6){
				statistcMap = statistcList.stream().collect(HashMap::new, (m, v) -> m.put(v.get("USER_ID"), v), HashMap::putAll);
//				userStatistcMap = statistcList.stream().collect(Collectors.toMap(val -> (String)val.get("DEPT_GR_USER"), val -> StringUtil.parseInteger(val.get("count"))));
			}
		} else {
			if(rangeType == 6){
				statistcMap = statistcList.stream().filter(val -> StringUtil.parseInteger(val.get("count")) > 0).collect(Collectors.toMap(val -> (String)val.get("DEPT_GR_USER"), val -> val));
				subMap = statistcList.stream().collect(HashMap::new, (m, v) -> m.put(v.get("rangeId"), v), HashMap::putAll);
//				userStatistcMap = statistcList.stream().collect(Collectors.toMap(val -> StringUtil.parseInteger(val.get("rangeId")), val -> val));
			} else {
				statistcMap = statistcList.stream().collect(Collectors.toMap(val -> StringUtil.parseInteger(val.get("rangeId")), val -> val));
			}
			if(rangeType == 5){
				grStatistcMap = grStatistcList.stream().collect(Collectors.toMap(val -> (String)val.get("DEPT_GR_USER"), val -> val));
			}
//			if(rangeType == 6){
//				userStatistcMap = statistcList.stream().collect(Collectors.toMap(val -> (String)val.get("DEPT_GR_USER"), val -> StringUtil.parseInteger(val.get("count"))));
//			}
		}
		//补数据
		if(null != lookType){
			if(lookType == 2){
				for (Integer rangeId : areaMap.keySet()) {
					if (statistcMap.get(rangeId) != null) {
						continue;
					}
					Map<String, Object> map = new HashMap<>();
					map.put("AREA_ID", rangeId);
					map.put("count", 0);
					statistcList.add(map);
				}
			}	else if(lookType == 3){
				for (Integer rangeId : regMap.keySet()) {
					if (statistcMap.get(rangeId) != null) {
						continue;
					}
					Map<String, Object> map = new HashMap<>();
					map.put("REG_ID", rangeId);
					map.put("AREA_ID", areaId);
					map.put("count", 0);
					statistcList.add(map);
				}
			} else if(lookType == 4){
				for (Integer subDeptId : deptMap.keySet()) {
					if (statistcMap.get(subDeptId) != null) {
						continue;
					}
					Map<String, Object> map = new HashMap<>();
					map.put("DEPT_ID", subDeptId);
					map.put("REG_ID", regId);
					map.put("AREA_ID", areaId);
					map.put("count", 0);
					statistcList.add(map);
				}
			}else if(lookType == 5){
				for (String subGrId : lookGrMap.keySet()) {
					if (statistcMap.get(subGrId) != null) {
						continue;
					}
					Map<String, Object> map = new HashMap<>();
					map.put("GR_ID", subGrId);
					map.put("DEPT_ID", subGrId.split("_")[0]);
					map.put("rangId", subGrId.split("_")[1]);
					map.put("REG_ID", regId);
					map.put("count", 0);
					statistcList.add(map);
				}
			} else if(lookType == 6){
				for (Integer subUserId : userMap.keySet()) {
					if (statistcMap.get(subUserId) != null) {
						continue;
					}
					Map<String, Object> map = new HashMap<>();
					map.put("USER_ID", subUserId);
					map.put("count", 0);
					statistcList.add(map);
				}
			}
		} else {
			for (Integer rangeIdIn : rangeIdset) {
				if(6 == rangeType){
					if (subMap.get(rangeIdIn) != null) {
						continue;
					}
				} else {
					if (statistcMap.get(rangeIdIn) != null) {
						continue;
					}
				}
				Map<String, Object> map = new HashMap<>();
				map.put("rangeId", rangeIdIn);
				map.put("count", 0);
				statistcList.add(map);
			}
		}
		Map<Object, Map<String, Integer>> targetCountMap = new HashMap<>();
		if(null != lookType){
			if(lookType == 2){
				targetCountMap = targetCountList.stream().collect(HashMap::new, (m, v) -> m.put(v.get("AREA_ID"), v), HashMap::putAll);
			} else if(lookType == 3){
				targetCountMap = targetCountList.stream().collect(HashMap::new, (m, v) -> m.put(v.get("REG_ID"), v), HashMap::putAll);
			} else if(lookType == 4){
				targetCountMap = targetCountList.stream().collect(HashMap::new, (m, v) -> m.put(v.get("DEPT_ID"), v), HashMap::putAll);
			} else if(lookType == 5){
				targetCountMap = targetCountList.stream().collect(HashMap::new, (m, v) -> m.put(v.get("GR_ID"), v), HashMap::putAll);
			} else if(lookType == 6){
				targetCountMap = targetCountList.stream().collect(HashMap::new, (m, v) -> m.put(v.get("USER_ID"), v), HashMap::putAll);
			}
		} else {
			targetCountMap = targetCountList.stream().filter(val -> val != null ).collect(Collectors.toMap(val -> val.get("rangeId"), val -> val));
		}
		//补数据
		if(null != lookType){
			if(lookType == 2){
				for (Integer rangeId : areaMap.keySet()) {
					if (targetCountMap.get(rangeId) != null) {
						continue;
					}
					Map<String, Integer> map = new HashMap<>();
					map.put("AREA_ID", rangeId);
					map.put("count", 0);
					targetCountList.add(map);
				}
			}	else if(lookType == 3){
				for (Integer rangeId : regMap.keySet()) {
					if (targetCountMap.get(rangeId) != null) {
						continue;
					}
					Map<String, Integer> map = new HashMap<>();
					map.put("REG_ID", rangeId);
					map.put("count", 0);
					targetCountList.add(map);
				}
			} else if(lookType == 4){
				for (Integer subDeptId : deptMap.keySet()) {
					if (targetCountMap.get(subDeptId) != null) {
						continue;
					}
					Map<String, Integer> map = new HashMap<>();
					map.put("DEPT_ID", subDeptId);
					map.put("count", 0);
					targetCountList.add(map);
				}
			}else if(lookType == 5){
				for (Integer subGrId : grMap.keySet()) {
					if (targetCountMap.get(subGrId) != null) {
						continue;
					}
					Map<String, Integer> map = new HashMap<>();
					map.put("GR_ID", subGrId);
					map.put("count", 0);
					targetCountList.add(map);
				}
			} else if(lookType == 6){
				for (Integer subUserId : userMap.keySet()) {
					if (targetCountMap.get(subUserId) != null) {
						continue;
					}
					Map<String, Integer> map = new HashMap<>();
					map.put("USER_ID", subUserId);
					map.put("count", 0);
					targetCountList.add(map);
				}
			}
		} else {
			for (Integer rangeIdIn : rangeIdset) {
				if (targetCountMap.get(rangeIdIn) != null) {
					continue;
				}
				Map<String, Integer> map = new HashMap<>();
				map.put("rangeId", rangeIdIn);
				map.put("countT", 0);
				targetCountList.add(map);
			}
		}
		List<AppWorkCountStatisticsRankVo> resultList = new ArrayList<>();
		for (Map<String, Object> map : statistcList) {
			AppWorkCountStatisticsRankVo resultVo = new AppWorkCountStatisticsRankVo();
			Set<Integer> nextRangeIdset = new HashSet<>(); // 查询的范围Ids
			Integer rangeIdTmp = (Integer) map.get("rangeId");
			if(null != lookType){
				if(lookType == 2){
					rangeIdTmp = (Integer) map.get("AREA_ID");
				} else if(lookType == 3){
					rangeIdTmp = (Integer) map.get("REG_ID");
				} else if(lookType == 4){
					rangeIdTmp = (Integer) map.get("DEPT_ID");
				} else if(lookType == 5){
					deptId = StringUtil.parseInteger(map.get("DEPT_ID"));
					rangeIdTmp = StringUtil.parseInteger(map.get("rangId"));
				} else if(lookType == 6){
					rangeIdTmp = (Integer) map.get("USER_ID");
				}
			}
			for (String key : map.keySet()) {
				if("gjHouseCount".equals(key)){
					resultVo.setFunCust(1);
				} else if("gjCustomerCount".equals(key)){
					resultVo.setFunCust(2);
				} else if("houseAdd".equals(key)){
					resultVo.setFunCust(1);
				} else if("customerAdd".equals(key)){
					resultVo.setFunCust(2);
				}
				String rangeName = "";
				if(null != lookType){
					if(null == resultVo){
						continue;
					}
					if(2 == lookType){
						rangeName = areaMap.get(rangeIdTmp);
					} else if (3 == lookType){
						rangeName = regMap.get(rangeIdTmp);
						if(StringUtil.isBlank(rangeName)){
							resultVo = null;
							continue;
						}
					} else if (4 == lookType){
						rangeName = deptMap.get(rangeIdTmp);
						resultVo.setRegId(deptRegMap.get(rangeIdTmp));
						resultVo.setDeptId(rangeIdTmp);
					} else if (5 == lookType){
						if(null == deptId){
							resultVo = null;
							continue;
						}
						rangeName = grMap.get(rangeIdTmp);
						String deptName = deptMap.get(grDeptMap.get(rangeIdTmp));
						if(StringUtil.isBlank(rangeName)){
							rangeName = "未分组";
							if(StringUtil.isBlank(deptName)){
								deptName = deptMap.get(map.get("DEPT_ID"));
							}
						}
						resultVo.setDeptId(deptId);
						resultVo.setDeptName(deptName);
						resultVo.setGrName(rangeName);
						if(StringUtil.isBlank(deptName)){
							resultVo = null;
							continue;
						}
					} else if (6 == lookType){
						ErpFunUsers erpFunUsers = userMap.get(rangeIdTmp);
						if(null != erpFunUsers){
							if(erpFunUsers.getUserWriteoff()){
								Integer count = (Integer) map.get("count");
								if(0 == count){
									resultVo = null;
									continue;
								}
							}
							resultVo.setUserName(erpFunUsers.getUserName());
							resultVo.setUserPosition(erpFunUsers.getUserPosition());
							String grName = lookGrMap.get(erpFunUsers.getDeptId() + "_" +erpFunUsers.getGrId());
							if(StringUtil.isBlank(grName)){
								grName = "未分组";
							}
							resultVo.setGrId(erpFunUsers.getGrId());
							resultVo.setDeptId(erpFunUsers.getDeptId());
							resultVo.setUserWriteoff(erpFunUsers.getUserWriteoff()?1:0);
							resultVo.setUserPhoto(StringUtil.getBbsPhoto(erpFunUsers.getUserPhoto()));
							resultVo.setGrName(grName);
							resultVo.setDeptName(deptMap.get(erpFunUsers.getDeptId()));
						} else {
							resultVo = null;
							continue;
						}
					}
					if(lookType <= 4){
						if(StringUtil.isBlank(rangeName)){
							resultVo = null;
							continue;
						}
					}
				} else {
					if(null == resultVo){
						continue;
					}
					if(2 == rangeType){
						rangeName = areaMap.get(rangeIdTmp);
					} else if (3 == rangeType){
						rangeName = regMap.get(rangeIdTmp);
					} else if (4 == rangeType){
						rangeName = deptMap.get(rangeIdTmp);
						resultVo.setRegId(deptRegMap.get(rangeIdTmp));
						resultVo.setDeptId(rangeIdTmp);
					} else if (5 == rangeType){
						rangeName = grMap.get(rangeIdTmp);
						if(StringUtil.isBlank(rangeName)){
							rangeName = "未分组";
						}
						String deptName = deptMap.get(grDeptMap.get(rangeIdTmp));
						resultVo.setDeptId(rangeIdTmp);
						resultVo.setDeptName(deptName);
						resultVo.setGrName(rangeName);
						if(StringUtil.isBlank(deptName)){
							resultVo = null;
							continue;
						}
					} else if (6 == rangeType){
						ErpFunUsers erpFunUsers = userMap.get(rangeIdTmp);
						if(null != erpFunUsers){
							if(erpFunUsers.getUserWriteoff()){
								Integer count = (Integer) map.get("count");
								if(0 == count){
									resultVo = null;
									continue;
								}
							}
							resultVo.setUserName(erpFunUsers.getUserName());
							resultVo.setUserPosition(erpFunUsers.getUserPosition());
							String grName = grMap.get(erpFunUsers.getGrId());
							if(StringUtil.isBlank(grName)){
								grName = "未分组";
							}
							resultVo.setGrId(erpFunUsers.getGrId());
							resultVo.setDeptId(erpFunUsers.getDeptId());
							resultVo.setUserWriteoff(erpFunUsers.getUserWriteoff()?1:0);
							resultVo.setUserPhoto(StringUtil.getBbsPhoto(erpFunUsers.getUserPhoto()));
							resultVo.setGrName(grName);
							resultVo.setDeptName(deptMap.get(erpFunUsers.getDeptId()));
						} else {
							resultVo = null;
							continue;
						}
					}
					if(rangeType <= 4){
						if(StringUtil.isBlank(rangeName)){
							resultVo = null;
							continue;
						}
					}
				}
				resultVo.setLookRankType(lookRankType);
				Map<String, Integer> targetMap = targetCountMap.get(rangeIdTmp);
				if(null != lookType && 5 == lookType){
					targetMap = targetCountMap.get(deptId + "_" + rangeIdTmp);
				}
				if(null == targetMap){
					targetMap = new HashMap<>();
				}
				Integer countT = targetMap.get("countT");
				Integer count = (Integer) map.get("count");
//				Integer supplementFlag = supplementMap.get(rangeIdTmp);
//				Integer otherFlag = otherMap.get(rangeIdTmp);
				resultVo.setCountT(countT);
				if(6 == rangeType){
					if (isFjdFlag && null != fjdRangeType && Integer.valueOf(6).equals(param.getLookType())) {
						resultVo.setCount(count);
					} else {
						String deptGrId = (String) map.get("GR_ID");
						if(StringUtil.isNotBlank(deptGrId)){
							// 统计出的工作量组织机构等于目前的查询组织机构
							if(deptGrId.equals(deptId + "_" + grId)){
								resultVo.setCount(count);
							}
						}
					}
				} else if(4 == rangeType){
					Integer countRegId = StringUtil.parseInteger(map.get("REG_ID"));
					if(Objects.equal(0, countRegId) || regId.equals(countRegId)){
						resultVo.setCount(count);
					}
				} else if(3 == rangeType){
					Integer countAreaId = StringUtil.parseInteger(map.get("AREA_ID"));
					if(Objects.equal(0, countAreaId) || areaId.equals(countAreaId)){
						resultVo.setCount(count);
					}
				} else {
					resultVo.setCount(count);
				}
				resultVo.setRangeName(rangeName);
			}
			if(resultVo == null){
				continue;
			}
			// 查询下级
			nextRangeIdset = this.getNextRangeType(rangeType, rangeIdTmp, cityId, compId, startDate, resultVo, nextRangeIdset, deptId, lookType, statistcMap, grStatistcMap);
			StringBuilder sb = new StringBuilder();
			for(Integer ids :nextRangeIdset){
				if(sb.length() > 0){
					sb.append(",");
				}
				sb.append(ids);
			}
			if(null == rangeIdTmp){
				rangeIdTmp = 0;
			}
			resultVo.setRangeIds(rangeIdTmp.toString());
			resultVo.setRangeType(rangeType);
			if(null != lookType){
				resultVo.setRangeType(lookType);
			}
			resultVo.setNextRangeIds(sb.toString());
			resultList.add(resultVo);
		}
		resultList.sort((o1, o2) -> {
			Integer count = o1.getCountT() == null ? 0:o1.getCountT();
			Integer count2 = o2.getCountT() == null ? 0:o2.getCountT();
			return count2.compareTo(count);
		});
		resultList.sort((o1, o2) -> {
			Integer count = o1.getCount() == null ? 0:o1.getCount();
			Integer count2 = o2.getCount() == null ? 0:o2.getCount();
			return count2.compareTo(count);
		});
		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("list", resultList);
		return ErpResponseJson.ok(resultMap);
	}

	//-------------------------组织架构改版-------------------------


	private Map<String, Object> getResultForOrganization(OrganizationQueryParam param) {
		Operator op = getOperator();
		Integer cityId = op.getCityId();
		Integer compId = op.getCompId();
		//加盟商逻辑
		List<Integer> partnerIds = deducePartnerWageRange(op);
		//查询条件
		if (param.getDefId() == null) {
			param.setDefId(-2);
		}
		//查看的层级（按该层级分组统计）
		String groupByColumn = "USER_ID";
		if (param.getDefId() > 0) {
			ErpFunOrganizationDefinition lookDefLevel = erpFunOrganizationDefinitionMapper.selectByPrimaryKey(new ErpFunOrganizationDefinition(cityId, param.getDefId()));
			Assert.isNullThrow(lookDefLevel,"参数错误");
			groupByColumn = lookDefLevel.getMappingDbField();
		}
		Integer lookRankType = param.getLookRankType();
		Integer funCust = param.getFunCust();
		String[] detailTypeStr = assembleStatisticDetailType(param.getLookRankType(), param.getFunCust());
		String workColumn = detailTypeStr[0];
		String workTargetColumn = detailTypeStr[1];
		Assert.isNullThrow(workColumn,"参数错误");
		if (lookRankType != 16) {
			Assert.isNullThrow(workTargetColumn,"参数错误");
		}
		String rangeWhereCauseB = erpFunOrganizationService.getMangeRangeWhereCause(cityId, compId, op.getUserId(), "b", null, null);
		String rangeWhereCause = rangeWhereCauseB.replaceAll("b\\.", "");
		String startDate = param.getStartDate();
		String endDate = param.getEndDate() + " 23:59:59";
		Map<Integer,Map<String,Integer>> targetMap = Collections.emptyMap();
		if (lookRankType != 16) {
			targetMap =  erpFunWorkcountTargetMapper.getTargetListForOrg(op.getCityId(), op.getCompId(), partnerIds,
					param.getDateType(), endDate, workTargetColumn, rangeWhereCauseB,groupByColumn);
		}
		Map<Integer,Map<String,Integer>> workCountMap = reportFunStatisticTotleMapper.getAppUcenterWorkCountRankByTypeForOrg(op.getCityId(), op.getCompId(),
				partnerIds, workColumn, rangeWhereCause, groupByColumn,startDate, endDate);
		//默认数据为0
		List<WorkCountRankVo> list = new ArrayList<>();
		//设置名称及用户信息
		if (param.getDefId() > 0) { //查看的是组织部门
			String mangeOrgPathWhereCause = this.getMangeOrgPathWhereCause(cityId, compId, op.getUserId());
			if (StringUtil.isBlank(mangeOrgPathWhereCause)) {
				List<String> orgIds = Stream.of(op.getOrganizationPath().split(":")).filter(StringUtil::isNotBlank).collect(Collectors.toList());
				mangeOrgPathWhereCause =  "ORGANIZATION_ID in  (" + String.join(",",orgIds )+ ")";
			}
			List<ErpFunOrganization> organizationVOs = erpFunOrganizationMapper.selectOneLevelOrganization(cityId, compId, mangeOrgPathWhereCause,param.getDefId());
			List<Integer> allIds = organizationVOs.stream().map(ErpFunOrganization::getOrganizationId).collect(Collectors.toList());
			Map<Integer, String> idToName = organizationVOs.stream().collect(Collectors.toMap(ErpFunOrganization::getOrganizationId, ErpFunOrganization::getOrganizationName));
			for (Integer id : allIds) {
				WorkCountRankVo vo = new WorkCountRankVo();
				vo.setCount(Optional.ofNullable(workCountMap.get(id)).map(m->m.get("count")).orElse(0));
				vo.setCountT(Optional.ofNullable(targetMap.get(id)).map(m->m.get("countT")).orElse(0));
				vo.setDefId(param.getDefId());
				vo.setLookRankType(lookRankType);
				vo.setOrganizationName(idToName.get(id));
				vo.setOrganizationId(id);
				list.add(vo);
			}
		} else if (param.getDefId() == -2) { //查询员工
			List<ErpFunUsers> usersList = erpFunUsersMapper.getManagerUserListForOrg(cityId, compId,partnerIds,rangeWhereCause);
			List<Integer> allUserIds = usersList.stream().map(ErpFunUsers::getUserId).collect(Collectors.toList());
			Map<Integer, ErpFunUsers> userMap = usersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, Function.identity()));
			for (Integer uId : allUserIds) {
				WorkCountRankVo vo = new WorkCountRankVo();
				vo.setCount(Optional.ofNullable(workCountMap.get(uId)).map(m->m.get("count")).orElse(0));
				vo.setCountT(Optional.ofNullable(targetMap.get(uId)).map(m->m.get("countT")).orElse(0));
				vo.setDefId(-2);
				vo.setLookRankType(lookRankType);
				if (null == userMap.get(uId)) {continue;}
				//用户信息
				ErpFunUsers user = userMap.get(uId);
				vo.setOrganizationId(user.getOrganizationId());
				vo.setUserId(user.getUserId());
				vo.setUserName(user.getUserName());
				vo.setUserPhoto(user.getUserPhoto());
				vo.setUserPosition(user.getUserPosition());
				vo.setUserWriteoff(Optional.ofNullable(user.getUserWriteoff()).map(b -> b ? 1 : 0).orElse(0));
				list.add(vo);
			}
		}
		list = list.stream().sorted(Comparator
				.comparing(WorkCountRankVo::getCount, Comparator.nullsLast(Comparator.reverseOrder()))
				.thenComparing(WorkCountRankVo::getCountT, Comparator.nullsLast(Comparator.reverseOrder())))
			.collect(Collectors.toList());
		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("list", list);
		return resultMap;
	}
	//-------------------------组织架构改版-------------------------
	public String getMangeOrgPathWhereCause(Integer cityId,Integer compId,Integer userId) {
		List<String> inIds = new ArrayList<>();
		List<ErpFunUserManageRange> list = erpFunUserManageRangeMapper.getUserManageRange(cityId, compId, userId);
		List<Integer> set = list.stream().map(ErpFunUserManageRange::getRangeId).distinct().collect(Collectors.toList());
		List<String> whereList = new ArrayList<>();
		//全公司
		if (set.contains(0)) {
			return  "(COMP_ID = " + compId + ")";
		} else if(!set.isEmpty()){
			List<ErpFunOrganization> vos = erpFunOrganizationMapper.selectOrgByOrgIds(cityId, compId, set);
			for (ErpFunOrganization vo : vos) {
				String s = "(ORGANIZATION_PATH like  '" + vo.getOrganizationPath() + "%')";
				whereList.add(s);
				if (java.util.Objects.nonNull(vo.getOrganizationPath())) {
					List<String> pathIds = Stream.of(vo.getOrganizationPath().split(":")).filter(StringUtil::isNotBlank).collect(Collectors.toList());
					inIds.addAll(pathIds);
				}
			}
		}
		if (inIds.isEmpty()) {
			return "";
		}
		//合并父组织及子组织
		if (!inIds.isEmpty()) {
			inIds = inIds.stream().distinct().collect(Collectors.toList());
			String idInCause =  "(ORGANIZATION_ID in (" + String.join(",", inIds)+"))";
			whereList.add(idInCause);
		}
		return whereList.stream().collect(Collectors.joining(" OR ", "(", ")"));
	}
	/**
	 * 薪资相关是否分开管控，及查询范围
	 * 配置类/隔离时			总部查看范围		直营查看范围		加盟查看范围
	 * 考核配置				总部+直营		直营			加盟
	 * @param operator
	 * @return
	 */
	private List<Integer> deducePartnerWageRange(Operator operator) {
		List<Integer> partnerIds = new ArrayList<>();
		//是否是加盟模式
		if (!java.util.Objects.equals(operator.openPartner(), 1)) {
			return partnerIds;
		}
		//是否开启薪资分开管控参数
		PartnerConfigDto config = erpFunPartnerConfigService.getPartnerConfiguration(operator.getCityId(), operator.getCompId());
		if (java.util.Objects.isNull(config) || !java.util.Objects.equals(config.getWageApart(), (byte)1)) {
			return partnerIds;
		}
		//分开管控 -1默认直营，0默认总部，>0某指定加盟商
		Integer selfPartnerId = operator.getPartnerId();
		if (selfPartnerId == 0) {
			//总部
			partnerIds.add(-1);
			partnerIds.add(0);
		}else if(selfPartnerId>0) {
			//某指定加盟商
			partnerIds.add(selfPartnerId);
		}else {
			//直营
			partnerIds.add(-1);
		}
		return partnerIds;
	}
	
	private Set<Integer> getNextRangeType(Integer rangeType, Integer rangeIdTmp, Integer cityId, Integer compId, String startDate,
                                          AppWorkCountStatisticsRankVo appWorkCountStatisticsRankVo, Set<Integer> nextRangeIdset, Integer deptId, Integer lookType,
                                          Map<Object, Map<String, Object>> statistcMap, Map<Object, Map<String, Object>> grStatistcMap){
		Set<Integer> userManageRangeIds = new HashSet<>();
		if(rangeIdTmp == null){
			rangeIdTmp = 0;
		}
		userManageRangeIds.add(rangeIdTmp);
		if(2 == rangeType){
			if(null != lookType){
				if(2 == lookType){
					List<ErpFunRegion> regsList = erpFunRegionMapper.getRegListByAreaId(cityId, compId, rangeIdTmp);
					nextRangeIdset = regsList.stream().collect(Collectors.mapping(ErpFunRegion::getRegId, Collectors.toSet()));
				} else if(3 == lookType){
					List<ErpFunDepts> deptsList = erpFunDeptsMapper.selectFunDeptsList(cityId, compId, 3, userManageRangeIds);
					nextRangeIdset = deptsList.stream().collect(Collectors.mapping(ErpFunDepts::getDeptId, Collectors.toSet()));
				} else if (4 == lookType){
					List<ErpFunDeptsgroup> groupList = erpFunDeptsgroupMapper.selectGroupList(cityId, compId, 4, userManageRangeIds);
					nextRangeIdset = groupList.stream().collect(Collectors.mapping(ErpFunDeptsgroup::getGrId, Collectors.toSet()));
					Integer countUser = erpFunUsersMapper.countByRangeIds(cityId, compId, 4, userManageRangeIds);
					if(countUser > 0){
						nextRangeIdset.add(0);
					}
				} else if (5 == lookType){
					List<ErpFunUsers> userList = erpFunUsersMapper.getUsersByGrIds(cityId, compId, deptId, new ArrayList<>(userManageRangeIds));
					if(null != userList && !userList.isEmpty()){
						nextRangeIdset = userList.stream().collect(Collectors.mapping(ErpFunUsers::getUserId, Collectors.toSet()));
					}
					for(Entry<Object, Map<String, Object>> data : grStatistcMap.entrySet()){
						String key = (String)data.getKey();
						if(StringUtil.isNotBlank(key)){
							String[] split = key.split("_");
							if((split[0] + "_" +split[1]).equals(deptId + "_" + rangeIdTmp)){
								Map<String, Object> subData = data.getValue();
								Integer count = StringUtil.parseInteger(subData.get("count"), 0);
								if(count > 0){
									nextRangeIdset.add(Integer.valueOf(split[2]));
								}
							}
						}
					}
				} 
			} else {
				List<ErpFunRegion> regsList = erpFunRegionMapper.getRegListByAreaId(cityId, compId, rangeIdTmp);
				nextRangeIdset = regsList.stream().collect(Collectors.mapping(ErpFunRegion::getRegId, Collectors.toSet()));
			}
		} else if (3 == rangeType){
			if(null != lookType){
				if(3 == lookType){
					List<ErpFunDepts> deptsList = erpFunDeptsMapper.getDataList(cityId, compId, rangeIdTmp);
					nextRangeIdset = deptsList.stream().collect(Collectors.mapping(ErpFunDepts::getRegId, Collectors.toSet()));
				} else if (4 == lookType){
					List<ErpFunDeptsgroup> groupList = erpFunDeptsgroupMapper.selectGroupList(cityId, compId, 4, userManageRangeIds);
					nextRangeIdset = groupList.stream().collect(Collectors.mapping(ErpFunDeptsgroup::getGrId, Collectors.toSet()));
					Integer countUser = erpFunUsersMapper.countByRangeIds(cityId, compId, 4, userManageRangeIds);
					if(countUser > 0 ){
						nextRangeIdset.add(0);
					}
				} else if (5 == lookType){
					List<ErpFunUsers> userList = erpFunUsersMapper.getUsersByGrIds(cityId, compId, deptId, Arrays.asList(rangeIdTmp));
					if(null != userList && !userList.isEmpty()){
						nextRangeIdset = userList.stream().collect(Collectors.mapping(ErpFunUsers::getUserId, Collectors.toSet()));
					}
					for(Entry<Object, Map<String, Object>> data : grStatistcMap.entrySet()){
						String key = (String)data.getKey();
						if(StringUtil.isNotBlank(key)){
							String[] split = key.split("_");
							if((split[0] + "_" +split[1]).equals(deptId + "_" + rangeIdTmp)){
								Map<String, Object> subData = data.getValue();
								Integer count = StringUtil.parseInteger(subData.get("count"), 0);
								if(count > 0){
									nextRangeIdset.add(Integer.valueOf(split[2]));
								}
							}
						}
					}
				}
			} else {
				List<ErpFunDepts> deptsList = erpFunDeptsMapper.getDataList(cityId, compId, rangeIdTmp);
				nextRangeIdset = deptsList.stream().collect(Collectors.mapping(ErpFunDepts::getDeptId, Collectors.toSet()));
			}
		} else if (4 == rangeType){
			if(null != lookType){
				if(4 == lookType){
					List<ErpFunDeptsgroup> grList = erpFunDeptsgroupMapper.getAllGroupCount(cityId, compId, rangeIdTmp);
					nextRangeIdset = grList.stream().collect(Collectors.mapping(ErpFunDeptsgroup::getGrId, Collectors.toSet()));
					Integer countUser = erpFunUsersMapper.countByRangeIds(cityId, compId, 4, userManageRangeIds);
					if(countUser > 0){
						nextRangeIdset.add(0);
					}
				} else if (5 == lookType){
					List<ErpFunUsers> userList = erpFunUsersMapper.getUsersByGrIds(cityId, compId, deptId, Arrays.asList(rangeIdTmp));
					if(null != userList && !userList.isEmpty()){
						nextRangeIdset = userList.stream().collect(Collectors.mapping(ErpFunUsers::getUserId, Collectors.toSet()));
					}
					for(Entry<Object, Map<String, Object>> data : grStatistcMap.entrySet()){
						String key = (String)data.getKey();
						if(StringUtil.isNotBlank(key)){
							String[] split = key.split("_");
							if((split[0] + "_" +split[1]).equals(deptId + "_" + rangeIdTmp)){
								Map<String, Object> subData = data.getValue();
								Integer count = StringUtil.parseInteger(subData.get("count"), 0);
								if(count > 0){
									nextRangeIdset.add(Integer.valueOf(split[2]));
								}
							}
						}
					}
				}
			} else {
				List<ErpFunDeptsgroup> grList = erpFunDeptsgroupMapper.getAllGroupCount(cityId, compId, rangeIdTmp);
				nextRangeIdset = grList.stream().collect(Collectors.mapping(ErpFunDeptsgroup::getGrId, Collectors.toSet()));
				Integer countUser = erpFunUsersMapper.countByRangeIds(cityId, compId, 4, userManageRangeIds);
				if(countUser > 0){
					nextRangeIdset.add(0);
				}
			}
		} else if (5 == rangeType){
			List<ErpFunUsers> usersList = erpFunUsersMapper.getUsersByGrIds(cityId, compId, deptId, Arrays.asList(rangeIdTmp));
			if(null != usersList && !usersList.isEmpty()){
				nextRangeIdset = usersList.stream().collect(Collectors.mapping(ErpFunUsers::getUserId, Collectors.toSet()));
			}
			for(Entry<Object, Map<String, Object>> data : grStatistcMap.entrySet()){
				String key = (String)data.getKey();
				if(StringUtil.isNotBlank(key)){
					String[] split = key.split("_");
					if((split[0] + "_" +split[1]).equals(deptId + "_" + rangeIdTmp)){
						Map<String, Object> subData = data.getValue();
						Integer count = StringUtil.parseInteger(subData.get("count"), 0);
						if(count > 0){
							nextRangeIdset.add(Integer.valueOf(split[2]));
						}
					}
				}
			}
		}
		if(rangeType != 6){
			appWorkCountStatisticsRankVo.setNextRangeType(rangeType + 1);
		}
		if(null != lookType){
			appWorkCountStatisticsRankVo.setNextRangeType(lookType + 1);
		}
		if(4 == rangeType && nextRangeIdset .isEmpty()){
			List<ErpFunUsers> usersList = erpFunUsersMapper.getUserListByDeptId(cityId, rangeIdTmp);
			nextRangeIdset = usersList.stream().collect(Collectors.mapping(ErpFunUsers::getUserId, Collectors.toSet()));
			appWorkCountStatisticsRankVo.setNextRangeType(6);
		}
		return nextRangeIdset;
	}

	@ApiOperation("掌通工作量汇总表,需求=8459，作者：朱科")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = AppAchieveStatisticsSummaryRankDto.class, message = "成功")
	})
	@ResponseBody
	@PostMapping("/getAppWorkCountAchieveStatisticsSummaryRank")
	public ResponseJson getAppWorkCountAchieveStatisticsSummaryRank(@RequestBody AppAchieveStatisticsSummaryRankParam param) {
		Integer rangeType = param.getRangeType(); // 管理範圍類型
		Integer deptId = param.getDeptId();
		Operator operator = getOperator();
		if (operator.newOrganizationType()) {
			return getAppWorkCountAchieveStatisticsSummaryRankForOrg(param);
		}
		Integer compId = operator.getCompId();
		Integer cityId = operator.getCityId();
		if (rangeType == 1) {
			param.setRangeIds(compId.toString());
		}
		Integer dateType = param.getDateType(); // 考核类型，1=日考核2=周考核3=月考核
		String rangeIds = param.getRangeIds(); // 管理範圍,多个Id,用逗号隔开
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		// 指定查询哪些工作量
		String startDate = param.getStartDate();
		String endDate = param.getEndDate();
		String year = startDate.substring(0,4); // year
		String month = startDate.substring(5, 7); // month
		// 今日
		String nowTime = DateTimeHelper.formatDateTimetoString(new Date(), "yyyy-MM-dd");
		String nowEndTime = nowTime + " 23:59:59";
		// 本周
		String weekTime = DateConvert.getConditionDate(Constants_DIC.DIC_DATE_SEARCH_TYPE_BENWEEK)[0];
		String weekEndTime = DateConvert.getConditionDate(Constants_DIC.DIC_DATE_SEARCH_TYPE_BENWEEK)[1];
		// 本月
		String monthTime = DateConvert.getConditionDate(Constants_DIC.DIC_DATE_SEARCH_TYPE_BENMONTH)[0];
		String monthEndTime = DateConvert.getConditionDate(Constants_DIC.DIC_DATE_SEARCH_TYPE_BENMONTH)[1];
		if(1 == dateType){
			nowTime = startDate;
			nowEndTime = endDate;
		} else if (2 == dateType){
			weekTime = startDate;
			weekEndTime = endDate;
		} else if (3 == dateType){
			monthTime = DateConvert.getFirstDayOfMonth(StringUtil.parseInteger(year,2019), StringUtil.parseInteger(month, 10));
			monthEndTime = DateConvert.getLastDayOfMonth(StringUtil.parseInteger(year,2019), StringUtil.parseInteger(month, 10)) + "23:59:59";
		}
		Set<Integer> rangeIdset = new HashSet<>(); // 查询的范围Ids
		String[] idArr = rangeIds.split(",");
		for (String ids : idArr) {
			Integer rangeId = StringUtil.paseInteger(ids, 0);
			rangeIdset.add(rangeId);
		}
		// 判断是否开启了加盟模式和查询工作量是否独立的开关（和系统管理-薪资管理共用参数） FUN_PARTNER_CONFIG  WAGE_APART
		Integer partnerIdRange = 0; // 0表示查询所有数据；-1表示查询PARTNER_ID的范围是0和-1；大于0，则表示查询范围是该字段实际的值
		boolean separationConfig = false;
		if (Objects.equal(operator.openPartner(), 1)) { // 开启了加盟模式
			PartnerConfigDto partnerConfigDto = erpFunPartnerConfigService.getPartnerConfiguration(cityId, compId);
			if (null != partnerConfigDto && Objects.equal(partnerConfigDto.getWageApart(), (byte)1)) { // 系统管理-薪资管理自行配置（绩效奖罚、提成配置 0=否 1=是
				partnerIdRange = operator.getPartnerId();
				separationConfig = true;
			}
		}
		List<String> workColumns = new ArrayList<>();
		workColumns.add("ISNULL((SUM(iif(case_type in (1,2), DJ_COUNT, 0))),0) houseAdd"); // 房增
		workColumns.add("ISNULL((SUM(iif(case_type in (3,4), DJ_COUNT, 0))),0) customerAdd"); // 客增
		workColumns.add("ISNULL((SUM(FK_COUNT)),0) fkCount"); //
		workColumns.add("ISNULL((SUM(FDK_COUNT)),0) dkCount"); // 带看
		workColumns.add("ISNULL((SUM(iif(case_type in (1,2), GJ_COUNT, 0))),0) gjHouseCount");
		workColumns.add("ISNULL((SUM(iif(case_type in (3,4), GJ_COUNT, 0))),0) gjCustomerCount");
		workColumns.add("ISNULL((SUM(YSTJ_COUNT)),0) ystjCount"); // 钥匙提交
		workColumns.add("ISNULL((SUM(KFDP_COUNT)),0) kfdpCount"); // 看房点评（空看）
		workColumns.add("ISNULL((SUM(WT_COUNT) + SUM(XSWT_COUNT) + SUM(DJWT_COUNT) + SUM(BZWT_COUNT) + SUM(PTWT_COUNT)),0) wtCount"); // 委托
		workColumns.add("ISNULL((SUM(CJ_COUNT)),0) cjCount"); // 签约
		workColumns.add("ISNULL((SUM(TPSC_COUNT)),0) tpscCount");
		workColumns.add("ISNULL((SUM(VR_COUNT)),0) vrCount");
		workColumns.add("ISNULL((SUM(SPSC_COUNT)),0) spscCount");
		// 需求9686 取消查看电话
//		workColumns.add("ISNULL((SUM(CKDH_COUNT)),0) ckdhCount");
		workColumns.add("ISNULL((SUM(QFTG_COUNT)),0) qftgCount");
		workColumns.add("ISNULL((SUM(PYQ_COUNT)),0) pyqCount");

		// 需求9686 增加房源面谈，客源面谈，约看。隐号拨打
		workColumns.add("ISNULL((SUM(iif(case_type in (1,2), MT_COUNT, 0))),0) mtHouseCount");
		workColumns.add("ISNULL((SUM(iif(case_type in (3,4), MT_COUNT, 0))),0) mtCustomerCount");
		workColumns.add("ISNULL((SUM(KYYK_COUNT)),0) kyykCount");
		workColumns.add("ISNULL((SUM(IPCALL_COUNT)),0) ipcallCount");
		workColumns.add("ISNULL((SUM(YJ_COUNT)),0) yjCount");
			// 今日
		Map<String, Object> todayStatisticMap = reportFunStatisticTotleMapper.getAppWorkCountAchieveStatisticsSummaryRank(cityId, compId, rangeIdset, rangeType, workColumns, nowTime, nowEndTime, deptId, separationConfig,partnerIdRange);
			//this.getSctsConut(todayStatisticMap, nowTime);
			// 本週
		Map<String, Object>	weekStatisticMap = reportFunStatisticTotleMapper.getAppWorkCountAchieveStatisticsSummaryRank(cityId, compId, rangeIdset, rangeType, workColumns, weekTime, weekEndTime, deptId, separationConfig,partnerIdRange);
			//this.getSctsConut(weekStatisticMap, weekTime);
			// 本月month
		Map<String, Object> monthStatisticMap = reportFunStatisticTotleMapper.getAppWorkCountAchieveStatisticsSummaryRank(cityId, compId, rangeIdset, rangeType, workColumns, monthTime, monthEndTime, deptId, separationConfig,partnerIdRange);
			//this.getSctsConut(monthStatisticMap, monthTime);
			// 今日
		Map<String, Object>	todayTarget = erpFunWorkcountTargetMapper.getAppSumWorkCountTargetList(cityId, compId, deptId, rangeType, rangeIdset, 1, nowTime, nowEndTime, separationConfig,partnerIdRange);
		if (todayTarget == null) {
			todayTarget = new HashMap<>();
		}
			// 本周
		Map<String, Object>	weekTarget = erpFunWorkcountTargetMapper.getAppSumWorkCountTargetList(cityId, compId, deptId, rangeType, rangeIdset, 2, weekTime, weekEndTime, separationConfig,partnerIdRange);
		if (weekTarget == null) {
			weekTarget = new HashMap<>();
		}
			// 本月
		Map<String, Object>	monthTarget = erpFunWorkcountTargetMapper.getAppSumWorkCountTargetList(cityId, compId, deptId, rangeType, rangeIdset, 3, monthTime, monthEndTime,separationConfig, partnerIdRange);
		if (monthTarget == null) {
			monthTarget = new HashMap<>();
		}
		// 数据组装
		List<LinkedHashMap<String, Object>> resultList = this.assembleMap(todayStatisticMap, monthStatisticMap, weekStatisticMap, todayTarget, weekTarget, monthTarget);
		resultMap.put("list", resultList);
		return ErpResponseJson.ok(resultMap);
	}

	public ResponseJson getAppWorkCountAchieveStatisticsSummaryRankForOrg(AppAchieveStatisticsSummaryRankParam param) {
		Integer rangeType = param.getRangeType(); // 管理範圍類型
		Integer deptId = param.getDeptId();
		Operator operator = getOperator();
		Integer compId = operator.getCompId();
		Integer cityId = operator.getCityId();
		Integer dateType = param.getDateType(); // 考核类型，1=日考核2=周考核3=月考核
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		// 指定查询哪些工作量
		String startDate = param.getStartDate();
		String endDate = param.getEndDate();
		String year = startDate.substring(0,4); // year
		String month = startDate.substring(5, 7); // month
		// 今日
		String nowTime = DateTimeHelper.formatDateTimetoString(new Date(), "yyyy-MM-dd");
		String nowEndTime = nowTime + " 23:59:59";
		// 本周
		String weekTime = DateConvert.getConditionDate(Constants_DIC.DIC_DATE_SEARCH_TYPE_BENWEEK)[0];
		String weekEndTime = DateConvert.getConditionDate(Constants_DIC.DIC_DATE_SEARCH_TYPE_BENWEEK)[1];
		// 本月
		String monthTime = DateConvert.getConditionDate(Constants_DIC.DIC_DATE_SEARCH_TYPE_BENMONTH)[0];
		String monthEndTime = DateConvert.getConditionDate(Constants_DIC.DIC_DATE_SEARCH_TYPE_BENMONTH)[1];
		if(1 == dateType){
			nowTime = startDate;
			nowEndTime = endDate;
		} else if (2 == dateType){
			weekTime = startDate;
			weekEndTime = endDate;
		} else if (3 == dateType){
			monthTime = DateConvert.getFirstDayOfMonth(StringUtil.parseInteger(year,2019), StringUtil.parseInteger(month, 10));
			monthEndTime = DateConvert.getLastDayOfMonth(StringUtil.parseInteger(year,2019), StringUtil.parseInteger(month, 10)) + "23:59:59";
		}
		// 判断是否开启了加盟模式和查询工作量是否独立的开关（和系统管理-薪资管理共用参数） FUN_PARTNER_CONFIG  WAGE_APART
		Integer partnerIdRange = 0; // 0表示查询所有数据；-1表示查询PARTNER_ID的范围是0和-1；大于0，则表示查询范围是该字段实际的值
		boolean separationConfig = false;
		if (Objects.equal(operator.openPartner(), 1)) { // 开启了加盟模式
			PartnerConfigDto partnerConfigDto = erpFunPartnerConfigService.getPartnerConfiguration(cityId, compId);
			if (null != partnerConfigDto && Objects.equal(partnerConfigDto.getWageApart(), (byte)1)) { // 系统管理-薪资管理自行配置（绩效奖罚、提成配置 0=否 1=是
				partnerIdRange = operator.getPartnerId();
				separationConfig = true;
			}
		}
		List<String> workColumns = new ArrayList<>();
		workColumns.add("ISNULL((SUM(iif(case_type in (1,2), DJ_COUNT, 0))),0) houseAdd"); // 房增
		workColumns.add("ISNULL((SUM(iif(case_type in (3,4), DJ_COUNT, 0))),0) customerAdd"); // 客增
		workColumns.add("ISNULL((SUM(FK_COUNT)),0) fkCount"); //
		workColumns.add("ISNULL((SUM(FDK_COUNT)),0) dkCount"); // 带看
		workColumns.add("ISNULL((SUM(iif(case_type in (1,2), GJ_COUNT, 0))),0) gjHouseCount");
		workColumns.add("ISNULL((SUM(iif(case_type in (3,4), GJ_COUNT, 0))),0) gjCustomerCount");
		workColumns.add("ISNULL((SUM(YSTJ_COUNT)),0) ystjCount"); // 钥匙提交
		workColumns.add("ISNULL((SUM(KFDP_COUNT)),0) kfdpCount"); // 看房点评（空看）
		workColumns.add("ISNULL((SUM(WT_COUNT) + SUM(XSWT_COUNT) + SUM(DJWT_COUNT) + SUM(BZWT_COUNT) + SUM(PTWT_COUNT)),0) wtCount"); // 委托
		workColumns.add("ISNULL((SUM(CJ_COUNT)),0) cjCount"); // 签约
		workColumns.add("ISNULL((SUM(TPSC_COUNT)),0) tpscCount");
		workColumns.add("ISNULL((SUM(VR_COUNT)),0) vrCount");
		workColumns.add("ISNULL((SUM(SPSC_COUNT)),0) spscCount");
		// 需求9686 取消查看电话
//		workColumns.add("ISNULL((SUM(CKDH_COUNT)),0) ckdhCount");
		workColumns.add("ISNULL((SUM(QFTG_COUNT)),0) qftgCount");
		workColumns.add("ISNULL((SUM(PYQ_COUNT)),0) pyqCount");

		// 需求9686 增加房源面谈，客源面谈，约看。隐号拨打
		workColumns.add("ISNULL((SUM(iif(case_type in (1,2), MT_COUNT, 0))),0) mtHouseCount");
		workColumns.add("ISNULL((SUM(iif(case_type in (3,4), MT_COUNT, 0))),0) mtCustomerCount");
		workColumns.add("ISNULL((SUM(KYYK_COUNT)),0) kyykCount");
		workColumns.add("ISNULL((SUM(IPCALL_COUNT)),0) ipcallCount");
		workColumns.add("ISNULL((SUM(YJ_COUNT)),0) yjCount");
		//指定人时defId=-2
		Integer defId = null;
		Integer orgId = null;
		if (null != param.getUserId()) {
			defId = -2;
			orgId = param.getUserId();
		}else if(null!=param.getOrganizationId() && param.getOrganizationId() > 0) {
			defId = 1;
			orgId =  param.getOrganizationId();
		}
		String mangeRangeWhereCauseB = erpFunOrganizationService.getMangeRangeWhereCause(cityId, compId, operator.getUserId(), "b", defId, orgId);
		String manageRangeWhereCause = mangeRangeWhereCauseB.replaceAll("b\\.", "");
		Map<String, Object> todayStatisticMap  = reportFunStatisticTotleMapper.getAppWorkCountAchieveStatisticsSummaryRankForOrg(cityId, compId, workColumns, nowTime, nowEndTime, manageRangeWhereCause, separationConfig,partnerIdRange);
		// 本週
		Map<String, Object> weekStatisticMap = reportFunStatisticTotleMapper.getAppWorkCountAchieveStatisticsSummaryRankForOrg(cityId, compId,  workColumns, weekTime, weekEndTime, manageRangeWhereCause, separationConfig,partnerIdRange);
		// 本月month
		Map<String, Object> monthStatisticMap = reportFunStatisticTotleMapper.getAppWorkCountAchieveStatisticsSummaryRankForOrg(cityId, compId, workColumns, monthTime, monthEndTime, manageRangeWhereCause, separationConfig,partnerIdRange);

		Map<String, Object> todayTarget = erpFunWorkcountTargetMapper.getAppSumWorkCountTargetListForOrg(cityId, compId, 1, separationConfig,partnerIdRange,mangeRangeWhereCauseB,nowTime,nowEndTime);
		todayTarget = Optional.ofNullable(todayTarget).orElse(new HashMap<>());
		// 本周
		Map<String, Object> weekTarget = erpFunWorkcountTargetMapper.getAppSumWorkCountTargetListForOrg(cityId, compId,2,  separationConfig,partnerIdRange,mangeRangeWhereCauseB,weekEndTime, weekEndTime);
		weekTarget = Optional.ofNullable(weekTarget).orElse(new HashMap<>());
		// 本月
		Map<String, Object> monthTarget = erpFunWorkcountTargetMapper.getAppSumWorkCountTargetListForOrg(cityId, compId, 3,separationConfig,partnerIdRange,mangeRangeWhereCauseB, monthTime,monthEndTime);
		monthTarget = Optional.ofNullable(monthTarget).orElse(new HashMap<>());

		// 数据组装
		List<LinkedHashMap<String, Object>> resultList = this.assembleMap(todayStatisticMap, monthStatisticMap, weekStatisticMap, todayTarget, weekTarget, monthTarget);
		resultMap.put("list", resultList);
		return ErpResponseJson.ok(resultMap);
	}

    //上传图片房源套数统计
	private void getSctsConut(Map<String, Object> statisticMap, String startTime){
		Operator ope = getOperator();
		//以下是上传套数数据的查询以及转换
		Map<String,Object> mapForCount = new HashMap<>();
		mapForCount.put("compId",ope.getCompId());
		mapForCount.put("cityId",ope.getCityId());
		mapForCount.put("startTime",startTime);
		List<Map<String, Object>> mapsListForCount= reportFunStatisticDetail1Mapper.selectSctsCount(ope.getCityId(), mapForCount);

		List<Map<String, Object>> tempList = new ArrayList<>();
		mapsListForCount.stream().forEach(obj->{
			Map<String, Boolean> saveFlag = new HashMap<>();
			tempList.stream().forEach(var->{
				if(var.get("caseId").equals(obj.get("caseId")) && var.get("caseType").equals(obj.get("caseType"))){
					saveFlag.put("flag",false);
				}
			});
			if(saveFlag.get("flag") == null){
				tempList.add(obj);
			}
		});
		statisticMap.put("sctsConut",tempList.size());
	}
	
	// 兼容网站请求掌通工作量汇总数据查询	原getAppWorkCountAchieveStatisticsSummaryRank
	@ApiOperation("网站查询工作量汇总数据, 需求 = 兼容网站请求掌通工作量汇总表接口的查询, 作者：陈峰")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = AppAchieveStatisticsSummaryRankDto.class, message = "成功")})
	@ResponseBody
	@PostMapping("/getWebWorkCountAchieveStatisticsSummaryRank")
	public ResponseJson getWebWorkCountAchieveStatisticsSummaryRank(@RequestBody WebAchieveStatisticsSummaryRankParam param) {
		Integer rangeType = null != param.getRangeType() ? param.getRangeType() : 1; // 管理範圍類型,网站传传都是1
		Operator operator = getOperator();
		Integer compId = operator.getCompId();
		Integer cityId = operator.getCityId();
		boolean personalVersion = operator.isPersonalVersion();
		param.setRangeIds(compId.toString());
		String rangeIds = param.getRangeIds(); // 管理範圍,多个Id,用逗号隔开
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		// 指定查询哪些工作量
		String nowTime = DateTimeHelper.formatDateTimetoString(new Date(), "yyyy-MM-dd"); // 今日
		String weekTime = DateConvert.getConditionDate(Constants_DIC.DIC_DATE_SEARCH_TYPE_BENWEEK)[0]; // 本週
		String monthTime = DateConvert.getConditionDate(Constants_DIC.DIC_DATE_SEARCH_TYPE_BENMONTH)[0];// 本月
		Set<Integer> rangeIdset = new HashSet<>(); // 查询的范围Ids
		String[] idArr = rangeIds.split(",");
		for (String ids : idArr) {
			Integer rangeId = StringUtil.paseInteger(ids, 0);
			rangeIdset.add(rangeId);
		}
		List<String> workColumns = new ArrayList<>();
		workColumns.add("ISNULL((SUM(VR_COUNT)),0) vrCount"); // VR
		workColumns.add("ISNULL((SUM(iif(case_type in (1,2), DJ_COUNT, 0))),0) houseAdd"); // 房增
		workColumns.add("ISNULL((SUM(iif(case_type in (3,4), DJ_COUNT, 0))),0) customerAdd"); // 客增
		workColumns.add("ISNULL((SUM(FK_COUNT)),0) fkCount"); // 房勘
		workColumns.add("ISNULL((SUM(FDK_COUNT)),0) dkCount"); // 帶看
		workColumns.add("ISNULL((SUM(YSTJ_COUNT)),0) ystjCount");// 鑰匙
		workColumns.add("ISNULL((SUM(KFDP_COUNT)),0) kfdpCount"); // 空看
		// 今日
		Map<String, Object> todayStatisticMap = reportFunStatisticTotleMapper.getWebWorkCountAchieveStatisticsSummaryRank(cityId, compId, rangeIdset, rangeType, workColumns, nowTime, null);
		// 本週
		Map<String, Object> weekStatisticMap = reportFunStatisticTotleMapper.getWebWorkCountAchieveStatisticsSummaryRank(cityId, compId, rangeIdset, rangeType, workColumns, weekTime, null);
		// 本月month
		Map<String, Object> monthStatisticMap = reportFunStatisticTotleMapper.getWebWorkCountAchieveStatisticsSummaryRank(cityId, compId, rangeIdset, rangeType, workColumns, monthTime, null);
		// 买卖成交
		Map<String, Integer> saleMap = reportFunStatisticDetail1Mapper.getAppInnerData(cityId, compId, rangeIdset, rangeType, null, nowTime, weekTime, monthTime, 20, Const.DIC_CASE_TYPE_SALE_FUN, Const.DIC_HOUSE_STATUS_INNERDEAL);
		Map<String, Integer> buyCustomerMap = reportFunStatisticDetail1Mapper.getAppInnerData(cityId, compId, rangeIdset, rangeType, null, nowTime, weekTime, monthTime, 20, Const.DIC_CASE_TYPE_BUY_CUST, Const.DIC_HOUSE_STATUS_INNERDEAL);
		// 租赁成交
		Map<String, Integer> leaseMap = reportFunStatisticDetail1Mapper.getAppInnerData(cityId, compId, rangeIdset, rangeType, null, nowTime, weekTime, monthTime, 20, Const.DIC_CASE_TYPE_LEASE_FUN, Const.DIC_HOUSE_STATUS_INNERDEAL);
		Map<String, Integer> rentCustomerMap = reportFunStatisticDetail1Mapper.getAppInnerData(cityId, compId, rangeIdset, rangeType, null, nowTime, weekTime, monthTime, 20, Const.DIC_CASE_TYPE_RENT_CUST, Const.DIC_HOUSE_STATUS_INNERDEAL);
		Map<String, Integer> todayProfitMap = new HashMap<>();
		Map<String, Integer> weekProfitMap = new HashMap<>();
		Map<String, Integer> monthProfitMap = new HashMap<>();
		ErpFunProfitExample example = new ErpFunProfitExample();
		example.setShardCityId(cityId);
		example.createCriteria().andCompIdEqualTo(compId);
		int i = erpFunProfitMapper.countByExample(example);
		if (i > 0) {
			todayProfitMap = erpFunProfitMapper.getAppCompProfit(cityId, compId, rangeIdset, rangeType, nowTime, null);
			weekProfitMap = erpFunProfitMapper.getAppCompProfit(cityId, compId, rangeIdset, rangeType, weekTime, null);
			monthProfitMap = erpFunProfitMapper.getAppCompProfit(cityId, compId, rangeIdset, rangeType, monthTime, null);
		} else {
			todayProfitMap = erpFunOutdealMapper.getAppCompProfit(cityId, compId, rangeIdset, rangeType, nowTime, null);
			weekProfitMap = erpFunOutdealMapper.getAppCompProfit(cityId, compId, rangeIdset, rangeType, weekTime, null);
			monthProfitMap = erpFunOutdealMapper.getAppCompProfit(cityId, compId, rangeIdset, rangeType, monthTime, null);
		}
		List<LinkedHashMap<String, Object>> resultList = this.assembleMapFromWeb(todayStatisticMap, monthStatisticMap, weekStatisticMap, todayProfitMap, weekProfitMap, monthProfitMap, saleMap, buyCustomerMap, leaseMap, rentCustomerMap, personalVersion, rangeType);
		resultMap.put("list", resultList);
		return ErpResponseJson.ok(resultMap);
	}

	/**
	 * 网站工作量通汇总表数据格式组装
	 * @author 朱科
	 * @since 2018年9月3日
	 * @return
	 */
	private List<LinkedHashMap<String,Object>> assembleMapFromWeb(Map<String, Object> todayStatisticMap, Map<String, Object> monthStatisticMap, Map<String, Object> weekStatisticMap,Map<String, Integer> todayProfitMap,
			Map<String, Integer> weekProfitMap, Map<String, Integer> monthProfitMap, Map<String, Integer> saleMap, Map<String, Integer> buyCustomerMap, Map<String, Integer> leaseMap, Map<String, Integer> rentCustomerMap, Boolean personalVersion, Integer rangType){
		List<LinkedHashMap<String,Object>> vrCountStatisticList = new ArrayList<>();
		List<LinkedHashMap<String,Object>> houseAddStatisticList = new ArrayList<>();
		List<LinkedHashMap<String,Object>> customerAddStatisticList = new ArrayList<>();
		List<LinkedHashMap<String,Object>> fkCountStatisticList = new ArrayList<>();
		List<LinkedHashMap<String,Object>> dkCountStatisticList = new ArrayList<>();
		List<LinkedHashMap<String,Object>> ystjCountStatisticList = new ArrayList<>();
		List<LinkedHashMap<String,Object>> kfdpCountStatisticList = new ArrayList<>();
		List<LinkedHashMap<String,Object>> actualProfitList = new ArrayList<>();
		List<LinkedHashMap<String,Object>> receivableProfitList = new ArrayList<>();
		List<LinkedHashMap<String,Object>> saleBuyList = new ArrayList<>();
		List<LinkedHashMap<String,Object>> leaseRentList = new ArrayList<>();
		BigDecimal temp = new BigDecimal("0");
		// 数据组装
		LinkedHashMap<String,Object> houseAddMap = new LinkedHashMap<String,Object>();
		houseAddMap.put("typeName", "房增");
		houseAddStatisticList.add(houseAddMap);
		LinkedHashMap<String,Object> customerAddMap = new LinkedHashMap<String,Object>();
		customerAddMap.put("typeName", "客增");
		customerAddStatisticList.add(customerAddMap);
		LinkedHashMap<String,Object> fkCountMap = new LinkedHashMap<String,Object>();
		fkCountMap.put("typeName", "房勘");
		fkCountStatisticList.add(fkCountMap);
		LinkedHashMap<String,Object> dkCountMap = new LinkedHashMap<String,Object>();
		dkCountMap.put("typeName", "带看");
		dkCountStatisticList.add(dkCountMap);
		LinkedHashMap<String,Object> kfdpCountMap = new LinkedHashMap<String,Object>();
		kfdpCountMap.put("typeName", "空看");
		kfdpCountStatisticList.add(kfdpCountMap);
		LinkedHashMap<String,Object> ystjCountMap = new LinkedHashMap<String,Object>();
		ystjCountMap.put("typeName", "钥匙");
		ystjCountStatisticList.add(ystjCountMap);
		LinkedHashMap<String,Object> vrMap = new LinkedHashMap<String,Object>();
		vrMap.put("typeName", "VR");
		vrCountStatisticList.add(vrMap);
		LinkedHashMap<String,Object> saleBuyMap = new LinkedHashMap<String,Object>();
		saleBuyMap.put("typeName", "买卖成交");
		saleBuyList.add(saleBuyMap);
		saleBuyMap.put("todayTotal", saleMap.get("ncjHouseNow") + buyCustomerMap.get("ncjCustNow"));//  + saleMap.get("wcjHouseNow")+ buyCustomerMap.get("wcjCustNow"));
		saleBuyMap.put("weekTotal", saleMap.get("ncjHouseWeek") + buyCustomerMap.get("ncjCustWeek"));//  saleMap.get("wcjHouseWeek") ++ buyCustomerMap.get("wcjCustWeek"));
		saleBuyMap.put("monthTotal", saleMap.get("ncjHouseMonth") + buyCustomerMap.get("ncjCustMonth"));// + saleMap.get("wcjHouseMonth") + buyCustomerMap.get("wcjCustMonth"));
		LinkedHashMap<String,Object> leaseRentMap = new LinkedHashMap<String,Object>();
		leaseRentMap.put("typeName", "租赁成交");
		leaseRentList.add(leaseRentMap);
		leaseRentMap.put("todayTotal", leaseMap.get("ncjHouseNow") + rentCustomerMap.get("ncjCustNow"));// + saleMap.get("wcjHouseNow") + buyCustomerMap.get("wcjCustNow"));
		leaseRentMap.put("weekTotal", leaseMap.get("ncjHouseWeek") + rentCustomerMap.get("ncjCustWeek"));// + saleMap.get("wcjHouseWeek") + buyCustomerMap.get("wcjCustWeek"));
		leaseRentMap.put("monthTotal", leaseMap.get("ncjHouseMonth") + rentCustomerMap.get("ncjCustMonth"));//+ saleMap.get("wcjHouseMonth")  + buyCustomerMap.get("wcjCustMonth"));
		LinkedHashMap<String,Object> receivableProfitMap = new LinkedHashMap<String,Object>();
		receivableProfitList.add(receivableProfitMap);
		receivableProfitMap.put("typeName", "应收业绩");
		receivableProfitMap.put("todayTotal", todayProfitMap.get("receivableProfit") == null?temp:todayProfitMap.get("receivableProfit"));
		receivableProfitMap.put("weekTotal", weekProfitMap.get("receivableProfit") == null?temp:weekProfitMap.get("receivableProfit"));
		receivableProfitMap.put("monthTotal", monthProfitMap.get("receivableProfit") == null?temp:monthProfitMap.get("receivableProfit"));
		LinkedHashMap<String,Object> actualProfitMap = new LinkedHashMap<String,Object>();
		actualProfitList.add(actualProfitMap);
		actualProfitMap.put("typeName", "实收业绩");
		actualProfitMap.put("todayTotal", todayProfitMap.get("actualProfit")== null?temp:todayProfitMap.get("actualProfit"));
		actualProfitMap.put("weekTotal", weekProfitMap.get("actualProfit")== null?temp:weekProfitMap.get("actualProfit"));
		actualProfitMap.put("monthTotal", monthProfitMap.get("actualProfit")== null?temp:monthProfitMap.get("actualProfit"));
		for(Entry<String, Object> entry : todayStatisticMap.entrySet()){
			if(entry.getKey().equals("vrCount")){
				vrMap.put("todayTotal", entry.getValue());
			} else if(entry.getKey().equals("houseAdd")){
				houseAddMap.put("todayTotal", entry.getValue());
			} else if(entry.getKey().equals("customerAdd")){
				customerAddMap.put("todayTotal", entry.getValue());
			} else if(entry.getKey().equals("fkCount")){
				fkCountMap.put("todayTotal", entry.getValue());
			} else if(entry.getKey().equals("dkCount")){
				dkCountMap.put("todayTotal", entry.getValue());
			} else if(entry.getKey().equals("ystjCount")){
				ystjCountMap.put("todayTotal", entry.getValue());
			} else if(entry.getKey().equals("kfdpCount")){
				kfdpCountMap.put("todayTotal", entry.getValue());
			}
		}
		for(Entry<String, Object> entry : monthStatisticMap.entrySet()){
			if(entry.getKey().equals("vrCount")){
				vrMap.put("monthTotal", entry.getValue());
			} else if(entry.getKey().equals("houseAdd")){
				houseAddMap.put("monthTotal", entry.getValue());
			} else if(entry.getKey().equals("customerAdd")){
				customerAddMap.put("monthTotal", entry.getValue());
			} else if(entry.getKey().equals("fkCount")){
				fkCountMap.put("monthTotal", entry.getValue());
			} else if(entry.getKey().equals("dkCount")){
				dkCountMap.put("monthTotal", entry.getValue());
			} else if(entry.getKey().equals("ystjCount")){
				ystjCountMap.put("monthTotal", entry.getValue());
			} else if(entry.getKey().equals("kfdpCount")){
				kfdpCountMap.put("monthTotal", entry.getValue());
			}
		}
		for(Entry<String, Object> entry : weekStatisticMap.entrySet()){
			if(entry.getKey().equals("vrCount")){
				vrMap.put("weekTotal", entry.getValue());
			} else if(entry.getKey().equals("houseAdd")){
				houseAddMap.put("weekTotal", entry.getValue());
			} else if(entry.getKey().equals("customerAdd")){
				customerAddMap.put("weekTotal", entry.getValue());
			} else if(entry.getKey().equals("fkCount")){
				fkCountMap.put("weekTotal", entry.getValue());
			} else if(entry.getKey().equals("dkCount")){
				dkCountMap.put("weekTotal", entry.getValue());
			} else if(entry.getKey().equals("ystjCount")){
				ystjCountMap.put("weekTotal", entry.getValue());
			} else if(entry.getKey().equals("kfdpCount")){
				kfdpCountMap.put("weekTotal", entry.getValue());
			}
		}
		List<LinkedHashMap<String,Object>> resultList = new ArrayList<>();
		resultList.addAll(houseAddStatisticList);
		resultList.addAll(customerAddStatisticList);
		resultList.addAll(fkCountStatisticList);
		resultList.addAll(dkCountStatisticList);
		resultList.addAll(kfdpCountStatisticList);
		resultList.addAll(ystjCountStatisticList);
		resultList.addAll(vrCountStatisticList);
		resultList.addAll(saleBuyList);
		resultList.addAll(leaseRentList);
		if(!personalVersion && rangType != 6){
			resultList.addAll(receivableProfitList);
			resultList.addAll(actualProfitList);
		}
		return resultList;
	}




	/**
	 * 新组织机构掌通运营管理排行榜
	 * @param param
	 * @return
	 */
	public ResponseJson getAppAchieveMonthStatisticsRankForOrg(AppAchieveMonthStatisticsRankParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer assessmentType = param.getAssessmentType(); // 1=业绩2=房增3=客增4=带看5=钥匙
		String assessmentMonth = param.getAssessmentMonth();// 考勤月
		if(StringUtil.isBlank(assessmentMonth) || null == assessmentType){
			throw new BusinessException("参数错误");
		}

		String endTime = "";
		if(StringUtil.isNotBlank(assessmentMonth)){
			String year = assessmentMonth.substring(0,4); // year
			String month = assessmentMonth.substring(5, 7); // month
			endTime = DateConvert.getLastDayOfMonth(StringUtil.parseInteger(year,2018), StringUtil.parseInteger(month,8)) + "23:59:59";
		}
		//查询条件
		if (param.getDefId() == null) {
			param.setDefId(-2);
		}
		//查看的层级（按该层级分组统计）
		String groupByColumn = "USER_ID";
		if (param.getDefId() > 0) {
			ErpFunOrganizationDefinition lookDefLevel = erpFunOrganizationDefinitionMapper.selectByPrimaryKey(new ErpFunOrganizationDefinition(cityId, param.getDefId()));
			Assert.isNullThrow(lookDefLevel, "指定的查看层级不存在!");
			groupByColumn = lookDefLevel.getMappingDbField();
		}
		//加盟商
		List<Integer> partnerIds = deducePartnerWageRange(operator);
		// 查询对应的名字
		Integer profitValue = 0;
		if(1 == assessmentType){
			profitValue = StringUtil.paseInteger(erpSysParaService.getMLSysParamValByUserDefZero(cityId, compId,operator.getUserId(), "IS_SHOW_PROFIT_DATA"), 0);
		}
		// 1=业绩
		Integer profitShowType = 0;
		if(1 == assessmentType){
			profitShowType = StringUtil.paseInteger(erpSysParaService.getMLSysParamValByUserDefZero(cityId, compId,operator.getUserId(), "INDEX_PROFIT_SHOW_TYPE"), 0);
		}
		//统计数据类型
		List<String> workColumns = new ArrayList<>();
		if(2 == assessmentType){
			workColumns.add("ISNULL((SUM(iif(case_type in (1,2), DJ_COUNT, 0))),0) as num"); // 房增
		} else if(3 == assessmentType){
			workColumns.add("ISNULL((SUM(iif(case_type in (3,4), DJ_COUNT, 0))),0) as num"); // 客增
		} else if(4 == assessmentType){
			workColumns.add("ISNULL((SUM(FDK_COUNT)),0) as num"); // 帶看
		} else if(5 == assessmentType){
			workColumns.add("ISNULL((SUM(YSTJ_COUNT)),0) as num");// 鑰匙
		} else if(6 == assessmentType){
			workColumns.add("ISNULL((SUM(FK_COUNT)),0) as num");// 房勘
		}
		String mangeRangeWhereCauseB = erpFunOrganizationService.getMangeRangeWhereCause(cityId, compId, operator.getUserId(), "b", null, null);
		String mangeRangeWhereCause = mangeRangeWhereCauseB.replaceAll("b\\.", "");
		//查询
		List<Map<String, Object>> achievementRankList = Collections.emptyList();
		if(1 == assessmentType && profitValue > 0){
			// 1= 按实收统计,0= 按应收统计
			ErpFunProfitExample example = new ErpFunProfitExample();
			example.setShardCityId(cityId);
			example.createCriteria().andCompIdEqualTo(compId);
			int i = erpFunProfitMapper.countByExample(example);
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), false);
			if(i > 0){
				achievementRankList = erpFunDealMapper.getAppAchieveMonthStatisticsRankForOrg(cityId, compId, assessmentMonth, endTime, profitShowType,"b."+ groupByColumn,mangeRangeWhereCauseB);
			} else {
				achievementRankList = erpFunOutdealMapper.getOutDealStatisticsRankForOrg(cityId, compId, assessmentMonth, endTime, "b."+ groupByColumn, mangeRangeWhereCauseB);
			}
		} else if (1 != assessmentType){
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), false);
			achievementRankList = reportFunStatisticTotleMapper.getAppWorkCountAchieveStatisticsChooseRankForOrg(cityId, compId,partnerIds,workColumns,groupByColumn,mangeRangeWhereCause,assessmentType,assessmentMonth,endTime);
		}

		HashMap<Integer, Object> selectMap = achievementRankList.stream().collect(HashMap::new, (m, obj) -> m.put(Optional.ofNullable(obj.get("rangeId")).map(Object::toString).map(Integer::parseInt).orElse(0), obj.get("num")), Map::putAll);
		//查询的是组织层级
		List<AppMonthStatisticsRankForOrgDto> retList = new ArrayList<>();
		if (param.getDefId() > 0) {
			String mangeOrgPathWhereCause = this.getMangeOrgPathWhereCause(cityId, compId, operator.getUserId());
			if (StringUtil.isBlank(mangeOrgPathWhereCause)) {
				List<String> orgIds = Stream.of(operator.getOrganizationPath().split(":")).filter(StringUtil::isNotBlank).collect(Collectors.toList());
				mangeOrgPathWhereCause =  "ORGANIZATION_ID in  (" + String.join(",",orgIds )+ ")";
			}
			List<ErpFunOrganization> orgList = erpFunOrganizationMapper.selectOneLevelOrganization(cityId, compId,mangeOrgPathWhereCause,param.getDefId());
			for (ErpFunOrganization org : orgList) {
				AppMonthStatisticsRankForOrgDto dto = new AppMonthStatisticsRankForOrgDto();
				dto.setDefId(param.getDefId());
				dto.setOrganizationId(org.getOrganizationId());
				dto.setOrganizationName(org.getOrganizationName());
				dto.setCompleteTotal(Optional.ofNullable(selectMap.get(org.getOrganizationId())).map(Object::toString).orElse("0"));
				retList.add(dto);
			}
		} else if (param.getDefId() == -2) {//按员工查询
			List<ErpFunUsers> userList = erpFunUsersMapper.selectOrgUserList(cityId, compId,mangeRangeWhereCause, assessmentMonth);
			for (ErpFunUsers user : userList) {
				AppMonthStatisticsRankForOrgDto dto = new AppMonthStatisticsRankForOrgDto();
				dto.setDefId(-2);
				dto.setOrganizationId(user.getOrganizationId());
				dto.setUserId(user.getUserId());
				dto.setUserName(user.getUserName());
				dto.setUserPhoto(user.getUserPhoto());
				dto.setCompleteTotal(Optional.ofNullable(selectMap.get(user.getUserId())).map(Object::toString).orElse("0"));
				retList.add(dto);
			}
		}

		//倒序
		List<AppMonthStatisticsRankForOrgDto> sortedList = retList.stream()
				.sorted(Comparator.comparingDouble((AppMonthStatisticsRankForOrgDto obj) -> Double.parseDouble(obj.getCompleteTotal())).reversed())
				.collect(Collectors.toList());
		AppAchieveMonthStatisticsRankForOrgVo result = new AppAchieveMonthStatisticsRankForOrgVo();
		result.setAppAchieveMonthStatisticsRankVo(sortedList);
		return ErpResponseJson.ok(result);
	}

	@ApiOperation("掌通排行榜,需求=8459，作者：朱科")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = AppAchieveMonthStatisticsRankVo.class, message = "成功")
	})
	@ResponseBody
	@PostMapping("/getAppAchieveMonthStatisticsRank")
	public ResponseJson getAppAchieveMonthStatisticsRank(@RequestBody AppAchieveMonthStatisticsRankParam param) {
		Operator operator = getOperator();
		//======================新组织机构===========================
		if (operator.newOrganizationType()) {
			return getAppAchieveMonthStatisticsRankForOrg(param);
		}
		//======================新组织机构===========================
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer selfDeptId = operator.getDeptId();
		String areaFlag = operator.getAreaFlag(); // 是否开启大区标记
		Integer fjdRangeType = param.getFjdRangeType();// 房基地的查询范围
		String rangeIds = param.getRangeIds(); // 范围id（如rangeType为1,则rangeId为对应的compId,多个Id,用逗号隔开）
		Integer rangeType = param.getRangeType(); // 管理范围，1:公司 2:大区3：片区 4：门店 5：分组 6：到人

		Integer assessmentType = param.getAssessmentType(); // 1=业绩2=房增3=客增4=带看5=钥匙
		String assessmentMonth = param.getAssessmentMonth();// 考勤月
		Integer lookType = param.getLookType(); // 2=按大区3=按片区4=按门店5=按分组6按员工
		Integer deptId = param.getDeptId(); // 查询分组的情况把deptId带上，其他情况不传

		boolean isFjdFlag = false;
		if (adminFunCompService.judgerIsFangjidi(operator.getAdminCompId()) && null != fjdRangeType && Integer.valueOf(6).equals(param.getLookType())) {// 是房基地的公司
			ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(cityId, operator.getUserId());
			int userLevel = 0;
			if (null != erpFunUsers) {
				userLevel = erpFunUsers.getUserLevel();
			}
			String[] operArr = null;
			if (Integer.valueOf(1).equals(assessmentType)) {
				operArr = new String[]{"VIEW_ALL_ZX_PROFIT", "VIEW_T_ALL_NODE_ZX_PROFIT", "VIEW_T_ZX_PROFIT"};
			} else {
				operArr = new String[]{"VIEW_ALL_ZX_WORK", "VIEW_T_ALL_NODE_ZX_WORK", "VIEW_T_ZX_WORK"};
			}
			Set<String> userOpers = erpUserOpersMapper.getUsersOpersByUserId(cityId, operator.getUserId(), operArr);

			if (Integer.valueOf(1).equals(fjdRangeType)) {
				rangeType = 6;
				isFjdFlag = true;

				if (userOpers.isEmpty()) {
					rangeIds = operator.getUserId().toString();
				} else {
					AssessCountDataParam tempParam = new AssessCountDataParam();
					tempParam.setCompId(compId);
					tempParam.setUserId(operator.getUserId());
					if (Integer.valueOf(1).equals(assessmentType)) {
						if (userOpers.contains("VIEW_ALL_ZX_PROFIT")) {
							List<Integer> userIdList = erpFunUsersMapper.getAllCompUserIds(cityId, compId);
							rangeIds = userIdList.stream().filter(val -> null != val).map(val -> val.toString()).collect(Collectors.joining(","));
						} else if (userOpers.contains("VIEW_T_ALL_NODE_ZX_PROFIT")) {
							List<AssessRoleCountDataVo> userTreamList = erpFunUsersMapper.getUserTeamList(cityId, null, tempParam);
							rangeIds = userTreamList.stream().filter(val -> null != val.getUserId()).map(val -> val.getUserId().toString()).collect(Collectors.joining(","));
						} else if (userOpers.contains("VIEW_T_ZX_PROFIT")) {
							userLevel += 2;
							tempParam.setUserLevel(userLevel);
							List<AssessRoleCountDataVo> userTreamList = erpFunUsersMapper.getUserTeamList(cityId, null, tempParam);
							rangeIds = userTreamList.stream().filter(val -> null != val.getUserId()).map(val -> val.getUserId().toString()).collect(Collectors.joining(","));
						}
					} else {
						if (userOpers.contains("VIEW_ALL_ZX_WORK")) {
							List<Integer> userIdList = erpFunUsersMapper.getAllCompUserIds(cityId, compId);
							rangeIds = userIdList.stream().filter(val -> null != val).map(val -> val.toString()).collect(Collectors.joining(","));
						} else if (userOpers.contains("VIEW_T_ALL_NODE_ZX_WORK")) {
							List<AssessRoleCountDataVo> userTreamList = erpFunUsersMapper.getUserTeamList(cityId, null, tempParam);
							rangeIds = userTreamList.stream().filter(val -> null != val.getUserId()).map(val -> val.getUserId().toString()).collect(Collectors.joining(","));
						} else if (userOpers.contains("VIEW_T_ZX_WORK")) {
							userLevel += 2;
							tempParam.setUserLevel(userLevel);
							List<AssessRoleCountDataVo> userTreamList = erpFunUsersMapper.getUserTeamList(cityId, null, tempParam);
							rangeIds = userTreamList.stream().filter(val -> null != val.getUserId()).map(val -> val.getUserId().toString()).collect(Collectors.joining(","));
						}
					}
				}
			} else if (Integer.valueOf(2).equals(fjdRangeType)) {
				rangeType = 6;
				isFjdFlag = true;
				if (userOpers.isEmpty()) {
					rangeIds = operator.getUserId().toString();
				} else {
					AssessCountDataParam tempParam = new AssessCountDataParam();
					tempParam.setCompId(compId);
					tempParam.setUserId(operator.getUserId());
					if (Integer.valueOf(1).equals(assessmentType)) {
						if (userOpers.contains("VIEW_T_ALL_NODE_ZX_PROFIT")) {
							List<AssessRoleCountDataVo> userTreamList = erpFunUsersMapper.getUserTeamList(cityId, null, tempParam);
							rangeIds = userTreamList.stream().filter(val -> null != val.getUserId()).map(val -> val.getUserId().toString()).collect(Collectors.joining(","));
						} else if (userOpers.contains("VIEW_T_ZX_PROFIT")) {
							userLevel += 2;
							tempParam.setUserLevel(userLevel);
							List<AssessRoleCountDataVo> userTreamList = erpFunUsersMapper.getUserTeamList(cityId, null, tempParam);
							rangeIds = userTreamList.stream().filter(val -> null != val.getUserId()).map(val -> val.getUserId().toString()).collect(Collectors.joining(","));
						}
					} else {
						if (userOpers.contains("VIEW_T_ALL_NODE_ZX_WORK")) {
							List<AssessRoleCountDataVo> userTreamList = erpFunUsersMapper.getUserTeamList(cityId, null, tempParam);
							rangeIds = userTreamList.stream().filter(val -> null != val.getUserId()).map(val -> val.getUserId().toString()).collect(Collectors.joining(","));
						} else if (userOpers.contains("VIEW_T_ZX_WORK")) {
							userLevel += 2;
							tempParam.setUserLevel(userLevel);
							List<AssessRoleCountDataVo> userTreamList = erpFunUsersMapper.getUserTeamList(cityId, null, tempParam);
							rangeIds = userTreamList.stream().filter(val -> null != val.getUserId()).map(val -> val.getUserId().toString()).collect(Collectors.joining(","));
						}
					}
				}
			}
		}

		if(StringUtil.isBlank(assessmentMonth) || StringUtil.isBlank(rangeIds) || null == assessmentType || null == lookType){
			throw new BusinessException("参数错误");
		}
		List<String> workColumns = new ArrayList<>();
		if(2 == assessmentType){
			workColumns.add("ISNULL((SUM(iif(case_type in (1,2), DJ_COUNT, 0))),0) houseAdd"); // 房增
		} else if(3 == assessmentType){
			workColumns.add("ISNULL((SUM(iif(case_type in (3,4), DJ_COUNT, 0))),0) customerAdd"); // 客增
		} else if(4 == assessmentType){
			workColumns.add("ISNULL((SUM(FDK_COUNT)),0) dkCount"); // 帶看
		} else if(5 == assessmentType){
			workColumns.add("ISNULL((SUM(YSTJ_COUNT)),0) ystjCount");// 鑰匙
		} else if(6 == assessmentType){
			workColumns.add("ISNULL((SUM(FK_COUNT)),0) fkCount");// 房勘
		}
		String endTime = "";
		if(StringUtil.isNotBlank(assessmentMonth)){
			String year = assessmentMonth.substring(0,4); // year
			String month = assessmentMonth.substring(5, 7); // month
			endTime = DateConvert.getLastDayOfMonth(StringUtil.parseInteger(year,2018), StringUtil.parseInteger(month,8)) + "23:59:59";
		}
		Set<Integer> rangeIdset = new HashSet<>(); // 查询的范围Ids
		String[] idArr = rangeIds.split(",");
		for (String ids : idArr) {
			Integer rangeId = StringUtil.parseInteger(ids, 0);
			rangeIdset.add(rangeId);
		}
		// 查询对应的名字
		Map<Integer, String> areaMap = new HashMap<Integer, String>();
		Map<Integer, String> regMap = new HashMap<Integer, String>();
		Map<Integer, String> deptMap = new HashMap<Integer, String>();
		Map<Integer, String> grMap = new HashMap<Integer, String>();
		Map<Integer, Integer> grDeptMap = new HashMap<Integer, Integer>();
		Map<Integer, AdminFunArchive> archiveMap = new HashMap<>();
		Map<Integer, ErpFunUsers> userMap = new HashMap<>();
		Set<Integer> subAreaList = new HashSet<>();
		Set<Integer> subRegList = new HashSet<>();
		Set<Integer> subDeptList = new HashSet<>();
		Set<Integer> subGrList = new HashSet<>();
		Set<Integer> subUserList = new HashSet<>();
		// 2=按大区3=按片区4=按门店5=按分组6按员工
		// 补数据，补充管理层级下的数据
//		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), false);
		if(2 == lookType && "1".equals(areaFlag)){
			List<ErpFunArea> areaList = erpFunAreaMapper.selectAreaList(cityId, compId, rangeType, rangeIdset, assessmentMonth);
//			List<ErpFunArea> areaList = erpFunAreaMapper.getDataListByCompId(cityId, compId.toString());
			subAreaList = areaList.stream().collect(Collectors.mapping(ErpFunArea::getAreaId, Collectors.toSet()));
			areaMap = areaList.stream().collect(Collectors.toMap(ErpFunArea::getAreaId, ErpFunArea::getAreaName));
		} else if(3 == lookType){
			List<ErpFunRegion> regList = erpFunRegionMapper.selectRegList(cityId, compId, rangeType, rangeIdset, assessmentMonth);
//			List<ErpFunRegion> regList = erpFunRegionMapper.getCacheableRegionListByAreaId(cityId, compId);
			subRegList = regList.stream().collect(Collectors.mapping(ErpFunRegion::getRegId, Collectors.toSet()));
			regMap = regList.stream().collect(Collectors.toMap(ErpFunRegion::getRegId, ErpFunRegion::getRegName));
		} else {
//			List<ErpFunDepts> deptsList = erpFunDeptsMapper.selectFunDeptsList(cityId, compId, rangeType, rangeIdset);
			List<ErpFunDepts> deptsList = erpFunDeptsMapper.getCacheableDeptListByCompId(cityId, compId);
			subDeptList = deptsList.stream().collect(Collectors.mapping(ErpFunDepts::getDeptId, Collectors.toSet()));
			deptMap = deptsList.stream().collect(Collectors.toMap(ErpFunDepts::getDeptId, ErpFunDepts::getDeptName));
//			List<ErpFunDeptsgroup> groupList = erpFunDeptsgroupMapper.selectGroupList(cityId, compId, rangeType, rangeIdset);
//			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), false);
			List<ErpFunDeptsgroup> groupList = erpFunDeptsgroupMapper.getCacheableGroupListByCompId(cityId, compId, assessmentMonth);
			subGrList = groupList.stream().collect(Collectors.mapping(ErpFunDeptsgroup::getGrId, Collectors.toSet()));
			grMap = groupList.stream().collect(Collectors.toMap(ErpFunDeptsgroup::getGrId, ErpFunDeptsgroup::getGrName));
			grDeptMap = groupList.stream().collect(Collectors.toMap(ErpFunDeptsgroup::getGrId, ErpFunDeptsgroup::getDeptId));
		}
//		Integer sysParam = 0;
		Integer profitValue = 0;
		if(1 == assessmentType){
//			sysParam = StringUtil.parseInteger(erpSysParaMapper.getParamValue(cityId, compId, "SHOW_DEAL_PROFIT_TYPE"), 1);
			profitValue = StringUtil.paseInteger(erpSysParaService.getMLSysParamValByUserDefZero(cityId, compId,operator.getUserId(), "IS_SHOW_PROFIT_DATA"), 0);
		}
		// 返回值
		AppAchieveMonthStatisticsRankVo achieveMonthStatisticsRankVo = new AppAchieveMonthStatisticsRankVo();
		List<Map<String, Object>> achievementRankList = new ArrayList<>();
		// 管理层级为无或组时,列表默认显示本店员工的排行
		// 1=业绩
		Integer profitShowType = 0;
		if(1 == assessmentType){
			profitShowType = StringUtil.paseInteger(erpSysParaService.getMLSysParamValByUserDefZero(cityId, compId,operator.getUserId(), "INDEX_PROFIT_SHOW_TYPE"), 0);
		}
		if(1 == assessmentType && profitValue > 0){
			// 1= 按实收统计,0= 按应收统计
			ErpFunProfitExample example = new ErpFunProfitExample();
			example.setShardCityId(cityId);
			example.createCriteria().andCompIdEqualTo(compId);
			int i = erpFunProfitMapper.countByExample(example);
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), false);
			if(i > 0){
				achievementRankList = erpFunDealMapper.getAppAchieveMonthStatisticsRank(cityId, compId, deptId, lookType, rangeType, rangeIdset, assessmentMonth, endTime, selfDeptId, profitShowType, isFjdFlag);
			} else {
				achievementRankList = erpFunOutdealMapper.getOutDealStatisticsRank(cityId, compId, deptId, lookType, rangeType, rangeIdset, assessmentMonth, endTime, selfDeptId, profitShowType, isFjdFlag);
			}
		} else if (1 != assessmentType){
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), false);
			achievementRankList = reportFunStatisticTotleMapper.getAppWorkCountAchieveStatisticsChooseRank(cityId, compId, rangeIdset, rangeType, workColumns, assessmentMonth, endTime, deptId, lookType, assessmentType, selfDeptId, isFjdFlag);
		}
		if((null == achievementRankList || achievementRankList.isEmpty()) && null != param.getPageOffset() && 1 == param.getPageOffset()){
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("COMP_ID", compId.toString());
			resultMap.put("AREA_ID", subAreaList);
			resultMap.put("REG_ID", subRegList);
			resultMap.put("DEPT_ID", subDeptList);
			resultMap.put("GR_ID", subGrList);
			if(rangeType == 5 || rangeType == 6){
				List<ErpFunUsers> funUserslist = new ArrayList<ErpFunUsers>();
				if (rangeType == 6 && adminFunCompService.judgerIsFangjidi(operator.getAdminCompId()) && null != fjdRangeType && Integer.valueOf(6).equals(param.getLookType())) {
					funUserslist = erpFunUsersMapper.getErpFunUsersList(cityId, new ArrayList<>(rangeIdset));
				} else {
					// 管理层级为无或组时,列表默认显示本店员工的排行
					PageHelper.startPage(param.getPageOffset(), param.getPageRows(), false);
					funUserslist = erpFunUsersMapper.getUserListByDeptId(cityId, selfDeptId);
				}
//				String year = assessmentMonth.substring(0, 4); // year
//				String month = assessmentMonth.substring(5, 7); // month
//				String startTime = DateConvert.getFirstDayOfMonth(StringUtil.parseInteger(year,2018), StringUtil.parseInteger(month,12));
//				List<ErpFunUsers> funUserslist = erpFunUsersMapper.getUserListByDeptIdAndInWriteOffTime(cityId, selfDeptId, startTime, endTime);
				subUserList = funUserslist.stream().collect(Collectors.mapping(ErpFunUsers::getUserId, Collectors.toSet()));
				resultMap.put("USER_ID", subUserList);
			} else {
				PageHelper.startPage(param.getPageOffset(), param.getPageRows(), false);
				List<ErpFunUsers> funUserslist = erpFunUsersMapper.selectUserList(cityId, compId, deptId, rangeType, rangeIdset, endTime);
//				List<ErpFunUsers> funUserslist = erpFunUsersMapper.getUserListByTime(cityId, assessmentMonth, endTime, compId);
				subUserList = funUserslist.stream().collect(Collectors.mapping(ErpFunUsers::getUserId, Collectors.toSet()));
				resultMap.put("USER_ID", subUserList);
			}
			resultMap.put("RANGE", compId.toString());
			if(profitValue > 0){
				resultMap.put("DEAL_TOTAL_PROFIT", "0");
			}
			resultMap.put("supplementFlag", "1");
			achievementRankList.add(resultMap);
		}
		if(6 == lookType){
			if(achievementRankList.size() == 1 && achievementRankList.get(0).get("supplementFlag") != null){
				Set<Integer> idList = (HashSet<Integer>)achievementRankList.get(0).get("USER_ID");
				if (idList == null || idList.isEmpty()) {
					userMap = new HashMap<>();
				} else {
					List<ErpFunUsers> userList = erpFunUsersMapper.getUserListByUserIds(cityId, idList);
					userMap = userList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, val->val));
				}
			} else {
				Set<Integer> idList = achievementRankList.stream().collect(Collectors.mapping(map -> StringUtil.parseInteger(map.get("USER_ID")), Collectors.toSet()));
				if (idList == null || idList.isEmpty()) {
					userMap = new HashMap<>();
				} else {
					List<ErpFunUsers> userList = erpFunUsersMapper.getUserListByUserIds(cityId, idList);
					userMap = userList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, val->val));
				}
			}
		}
		List<AppAchieveMonthStatisticsRankDto> resultList = this.assembleChooseMap(achievementRankList, areaMap, regMap, deptMap, grMap, archiveMap, lookType, areaFlag, userMap, grDeptMap);
		achieveMonthStatisticsRankVo.setAppAchieveMonthStatisticsRankVo(resultList);
		// 补数据
		Set<String> deptGrIds = new HashSet<>();
		if(6 == lookType || 5 == lookType){
			List<ErpFunUsers> assessmentMonthUserList = erpFunUsersMapper.selectUserList(cityId, compId, null, rangeType, rangeIdset, assessmentMonth);
			userMap = assessmentMonthUserList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, val ->val));
			deptGrIds = assessmentMonthUserList.stream().collect(Collectors.mapping(val -> val.getDeptId() + "_" + val.getGrId(), Collectors.toSet()));
//			assessmentMonthUserList.stream().map(val -> val.getDeptId() + "" + val.getUserId()).collect(Collectors.toSet());
		}
		// 已有数据
		Set<Integer> userIds = resultList.stream().collect(Collectors.mapping(AppAchieveMonthStatisticsRankDto::getUserId, Collectors.toSet()));
		if(null != param.getPageOffset() && 1 == param.getPageOffset() && achievementRankList.size() < param.getPageRows()){
			this.subData(userMap, resultList, deptMap, lookType, userIds, areaMap, regMap, grMap, grDeptMap, deptGrIds);
		}
		Double tempDoub = new Double(0);
		resultList.sort((o1, o2) -> {
			String countT1 = o1.getCompleteTotal();
			String countT2 = o2.getCompleteTotal();
			if(StringUtil.paseInteger(countT1, 0) >=0 && StringUtil.paseInteger(countT2, 0) >=0){
				return StringUtil.paseInteger(countT2, 0).compareTo(StringUtil.paseInteger(countT1, 0));
			} else if(StringUtil.paseDouble(countT1, tempDoub) >= tempDoub && StringUtil.paseDouble(countT2, tempDoub) >= tempDoub){
				return StringUtil.paseDouble(countT2, tempDoub).compareTo(StringUtil.paseDouble(countT1, tempDoub));
			}
			return countT2.compareTo(countT1);
		});
		return ErpResponseJson.ok(achieveMonthStatisticsRankVo);
	}

	private void subData(Map<Integer, ErpFunUsers> userMap, List<AppAchieveMonthStatisticsRankDto> resultList, Map<Integer, String> deptMap, Integer lookType ,
                         Set<Integer> userIds, Map<Integer, String> areaMap, Map<Integer, String> regMap, Map<Integer, String> grMap, Map<Integer, Integer> grDeptMap, Set<String> deptGrIds){
		if(6 == lookType){
			for (Integer subUserId : userMap.keySet()) {
				if (userIds.contains(subUserId)) {
					continue;
				}
				ErpFunUsers erpFunUsers = userMap.get(subUserId);
				if(null != erpFunUsers.getUserWriteoff() && erpFunUsers.getUserWriteoff()){
					continue;
				}
				AppAchieveMonthStatisticsRankDto subData = new AppAchieveMonthStatisticsRankDto();
				subData.setLookType(lookType);
				subData.setLookTypeId(subUserId);
				subData.setCompleteTotal("0");
				subData.setUserId(subUserId);
				subData.setUserPhoto(StringUtil.getBbsPhoto(erpFunUsers.getUserPhoto()));
				subData.setDeptId(erpFunUsers.getDeptId());
				subData.setUserName(erpFunUsers.getUserName());
				String deptName = deptMap.get(erpFunUsers.getDeptId());
				if(StringUtil.isNotBlank(deptName)){
					subData.setDeptName(deptName);
				}
				resultList.add(subData);
			}
		} else if (5 == lookType){
			Set<String> resultGrIds = resultList.stream().collect(Collectors.mapping(val -> val.getDeptId() + "_" + val.getLookTypeId(), Collectors.toSet()));
			for (String subGrId : deptGrIds) {
				if(resultGrIds.contains(subGrId)){
					continue;
				}
				String[] split = subGrId.split("_");
				AppAchieveMonthStatisticsRankDto subData = new AppAchieveMonthStatisticsRankDto();
				subData.setLookType(lookType);
				subData.setLookTypeId(StringUtil.parseInteger(split[1]));
				subData.setCompleteTotal("0");
				subData.setDeptId(StringUtil.parseInteger(split[0]));
				subData.setDeptName(deptMap.get(StringUtil.parseInteger(split[0])));
				if(StringUtil.isBlank(grMap.get(StringUtil.parseInteger(split[1])))){
					subData.setUserName("未分组");
				} else {
					subData.setUserName(grMap.get(StringUtil.parseInteger(split[1])));
				}
				resultList.add(subData);
			}
		} else if (4 == lookType){
			Set<Integer> resultDeptIds = resultList.stream().collect(Collectors.mapping(val -> val.getLookTypeId(), Collectors.toSet()));
			for (Integer subDeptId : deptMap.keySet()) {
				if(resultDeptIds.contains(subDeptId)){
					continue;
				}
				AppAchieveMonthStatisticsRankDto subData = new AppAchieveMonthStatisticsRankDto();
				subData.setLookType(lookType);
				subData.setLookTypeId(subDeptId);
				subData.setCompleteTotal("0");
				subData.setDeptId(subDeptId);
				subData.setDeptName(deptMap.get(subDeptId));
				resultList.add(subData);
			}
		} else if (3 == lookType){
			Set<Integer> resultRegIds = resultList.stream().collect(Collectors.mapping(val -> val.getLookTypeId(), Collectors.toSet()));
			for (Integer subRegId : regMap.keySet()) {
				if(resultRegIds.contains(subRegId)){
					continue;
				}
				AppAchieveMonthStatisticsRankDto subData = new AppAchieveMonthStatisticsRankDto();
				subData.setLookType(lookType);
				subData.setLookTypeId(subRegId);
				subData.setCompleteTotal("0");
				subData.setDeptName(regMap.get(subRegId));
				resultList.add(subData);
			}
		} else if (2 == lookType){
			Set<Integer> resultRegIds = resultList.stream().collect(Collectors.mapping(val -> val.getLookTypeId(), Collectors.toSet()));
			for (Integer subAreaId : areaMap.keySet()) {
				if(resultRegIds.contains(subAreaId)){
					continue;
				}
				AppAchieveMonthStatisticsRankDto subData = new AppAchieveMonthStatisticsRankDto();
				subData.setLookType(lookType);
				subData.setLookTypeId(subAreaId);
				subData.setCompleteTotal("0");
				subData.setDeptName(areaMap.get(subAreaId));
				resultList.add(subData);
			}
		}
	}

	/**
	 * 运营中心排行榜数据组装
	 * @author 朱科
	 * @since 2018年9月3日
	 * @return
	 */
	private List<AppAchieveMonthStatisticsRankDto> assembleChooseMap(List<Map<String, Object>> achievementRankList, Map<Integer, String> areaMap, Map<Integer, String> regMap,
                                                                     Map<Integer, String> deptMap, Map<Integer, String> grMap, Map<Integer, AdminFunArchive> archiveMap, Integer lookType, String areaFlag, Map<Integer, ErpFunUsers> userMap, Map<Integer, Integer> grDeptMap){
		Integer tempValue = 0;
		String userName = "";
		List<AppAchieveMonthStatisticsRankDto> resultList = new ArrayList<>();
		if(achievementRankList.size() == 1 && achievementRankList.get(0).get("supplementFlag") != null){
			Map<String, Object> dataMap = achievementRankList.get(0);
			for(String key: dataMap.keySet()){
				Object object = dataMap.get(key);
				if("AREA_ID".equals(key) || "REG_ID".equals(key) || "DEPT_ID".equals(key) || "GR_ID".equals(key) || "USER_ID".equals(key)){
					Set<Integer> idList = (HashSet<Integer>) object;
					for (Integer id : idList) {
						AppAchieveMonthStatisticsRankDto appAchieveMonthStatisticsRankDto = new AppAchieveMonthStatisticsRankDto();
						appAchieveMonthStatisticsRankDto.setLookType(lookType);
						if(2 == lookType && "AREA_ID".equals(key)){
							appAchieveMonthStatisticsRankDto.setLookTypeId(id);
							appAchieveMonthStatisticsRankDto.setDeptName(areaMap.get(id));
							appAchieveMonthStatisticsRankDto.setCompleteTotal("0");
							resultList.add(appAchieveMonthStatisticsRankDto);
						} else if(3 == lookType && "REG_ID".equals(key)){
							appAchieveMonthStatisticsRankDto.setLookTypeId(id);
							appAchieveMonthStatisticsRankDto.setDeptName(regMap.get(id));
							appAchieveMonthStatisticsRankDto.setCompleteTotal("0");
							resultList.add(appAchieveMonthStatisticsRankDto);
						} else if(4 == lookType && "DEPT_ID".equals(key)){
							appAchieveMonthStatisticsRankDto.setLookTypeId(id);
							appAchieveMonthStatisticsRankDto.setDeptName(deptMap.get(id));
							appAchieveMonthStatisticsRankDto.setCompleteTotal("0");
							resultList.add(appAchieveMonthStatisticsRankDto);
						} else if(5 == lookType && "GR_ID".equals(key)){
							appAchieveMonthStatisticsRankDto.setLookTypeId(id);
							appAchieveMonthStatisticsRankDto.setUserName(grMap.get(id));
							Integer deptId = grDeptMap.get(id);
							if(null != deptId){
								appAchieveMonthStatisticsRankDto.setDeptName(deptMap.get(deptId));
								appAchieveMonthStatisticsRankDto.setDeptId(deptId);
							}
							appAchieveMonthStatisticsRankDto.setCompleteTotal("0");
							resultList.add(appAchieveMonthStatisticsRankDto);
						} else if(6 == lookType && "USER_ID".equals(key)){
							appAchieveMonthStatisticsRankDto.setLookTypeId(id);
							ErpFunUsers erpFunUsers = userMap.get(id);
							if(null != erpFunUsers){
								if(StringUtil.isNotBlank(erpFunUsers.getUserPhoto())){
									appAchieveMonthStatisticsRankDto.setUserPhoto(StringUtil.getBbsPhoto(erpFunUsers.getUserPhoto()));
								}
								appAchieveMonthStatisticsRankDto.setUserId(erpFunUsers.getUserId());
								appAchieveMonthStatisticsRankDto.setUserName(erpFunUsers.getUserName());
								appAchieveMonthStatisticsRankDto.setDeptName(deptMap.get(erpFunUsers.getDeptId()));
								appAchieveMonthStatisticsRankDto.setCompleteTotal("0");
								resultList.add(appAchieveMonthStatisticsRankDto);
							}
						}
					}
				}
			}
		} else {
			for (Map<String, Object> map : achievementRankList) {
				AppAchieveMonthStatisticsRankDto appAchieveMonthStatisticsRankDto = new AppAchieveMonthStatisticsRankDto();
				appAchieveMonthStatisticsRankDto.setLookType(lookType);
				String name = "";
				for (Entry<String, Object> entry : map.entrySet()) {
					String key = entry.getKey();
					Object value = entry.getValue();
					if("AREA_ID".equals(key) || "REG_ID".equals(key) || "DEPT_ID".equals(key) || "GR_ID".equals(key) || "USER_ID".equals(key)){
						tempValue = StringUtil.parseInteger(value, 0);
						if("DEPT_ID".equals(key)){
							appAchieveMonthStatisticsRankDto.setDeptId(tempValue);
						}
					}
					if (2 == lookType && "1".equals(areaFlag)) {
						if("AREA_ID".equals(key)){
							name = areaMap.get(tempValue);
							appAchieveMonthStatisticsRankDto.setLookTypeId(tempValue);
							appAchieveMonthStatisticsRankDto.setDeptName(name);
						}
					} else if (3 == lookType) {
						if("REG_ID".equals(key)){
							name = regMap.get(tempValue);
							appAchieveMonthStatisticsRankDto.setLookTypeId(tempValue);
							appAchieveMonthStatisticsRankDto.setDeptName(name);
						}
					} else if (4 == lookType) {
						if("DEPT_ID".equals(key)){
							name = deptMap.get(tempValue);
							appAchieveMonthStatisticsRankDto.setLookTypeId(tempValue);
							appAchieveMonthStatisticsRankDto.setDeptName(name);
						}
					} else if (5 == lookType) {
						if("GR_ID".equals(key)){
							appAchieveMonthStatisticsRankDto.setLookTypeId(tempValue);
							if(null == tempValue || 0 == tempValue){
								userName = "未分组";
							} else{
								userName = grMap.get(tempValue);
							}
							appAchieveMonthStatisticsRankDto.setUserName(userName);
						}
						if("DEPT_GR".equals(key)){
							String deptGr = (String)map.get(key);
							if(StringUtil.isNotBlank(deptGr)){
								String[] split = deptGr.split("_");
								appAchieveMonthStatisticsRankDto.setDeptId(StringUtil.parseInteger(split[0]));
								name = deptMap.get(StringUtil.parseInteger(split[0]));
								appAchieveMonthStatisticsRankDto.setDeptName(name);
							}
						}
					} else if (6 == lookType) {
						if("USER_ID".equals(key)){
							appAchieveMonthStatisticsRankDto.setLookTypeId(tempValue);
							ErpFunUsers erpFunUsers = userMap.get(tempValue);
							if(null != erpFunUsers){
								if(StringUtil.isNotBlank(erpFunUsers.getUserPhoto())){
									appAchieveMonthStatisticsRankDto.setUserPhoto(StringUtil.getBbsPhoto(erpFunUsers.getUserPhoto()));
								}
								appAchieveMonthStatisticsRankDto.setDeptId(erpFunUsers.getDeptId());
								appAchieveMonthStatisticsRankDto.setDeptName(deptMap.get(erpFunUsers.getDeptId()));
								appAchieveMonthStatisticsRankDto.setUserId(erpFunUsers.getUserId());
								appAchieveMonthStatisticsRankDto.setUserName(erpFunUsers.getUserName());
							}
						}
						if("DEPT_ID".equals(key)){
							name = deptMap.get(tempValue);
							appAchieveMonthStatisticsRankDto.setDeptName(name);
						}
					}
					if("DEAL_TOTAL_PROFIT".equals(key) || "houseAdd".equals(key) || "customerAdd".equals(key) || "dkCount".equals(key) || "ystjCount".equals(key) || "fkCount".equals(key)){
						appAchieveMonthStatisticsRankDto.setCompleteTotal(value.toString());
					}
				}
				resultList.add(appAchieveMonthStatisticsRankDto);
			}
		}
		for (int i = resultList.size() - 1; i >= 0; i--) {
			AppAchieveMonthStatisticsRankDto appAchieveMonthStatisticsRankDto = resultList.get(i);
			if(null != appAchieveMonthStatisticsRankDto && null == appAchieveMonthStatisticsRankDto.getDeptName()){
				resultList.remove(i);
			}
		}
		return resultList;
	}

	/**
	 * 掌通工作量通汇总表数据格式组装
	 * @author 朱科
	 * @since 2018年9月3日
	 * @return
	 */
	private List<LinkedHashMap<String,Object>> assembleMap(Map<String, Object> todayStatisticMap, Map<String, Object> monthStatisticMap, Map<String, Object> weekStatisticMap,
			Map<String, Object> todayTarget, Map<String, Object> weekTarget, Map<String, Object> monthTarget){
		List<LinkedHashMap<String,Object>> houseAddStatisticList = new ArrayList<>();
		List<LinkedHashMap<String,Object>> customerAddStatisticList = new ArrayList<>();
		List<LinkedHashMap<String,Object>> fkCountStatisticList = new ArrayList<>();
		List<LinkedHashMap<String,Object>> dkCountStatisticList = new ArrayList<>();
		List<LinkedHashMap<String,Object>> gjHouseCountStatisticList = new ArrayList<>();
		List<LinkedHashMap<String,Object>> gjCustomerCountStatisticList = new ArrayList<>();
		List<LinkedHashMap<String,Object>> ystjCountStatisticList = new ArrayList<>();
		List<LinkedHashMap<String,Object>> kfdpCountStatisticList = new ArrayList<>();
		List<LinkedHashMap<String,Object>> wtCountStatisticList = new ArrayList<>();
		List<LinkedHashMap<String,Object>> cjCountStatisticList = new ArrayList<>();
		List<LinkedHashMap<String,Object>> tpscCountStatisticList = new ArrayList<>();
		List<LinkedHashMap<String,Object>> vrCountStatisticList = new ArrayList<>();
		List<LinkedHashMap<String,Object>> spscCountStatisticList = new ArrayList<>();
//		List<LinkedHashMap<String,Object>> ckdhCountStatisticList = new ArrayList<>();
		List<LinkedHashMap<String,Object>> qftgCountStatisticList = new ArrayList<>();
		List<LinkedHashMap<String,Object>> pyqCountStatisticList = new ArrayList<>();

		List<LinkedHashMap<String,Object>> mtHouseCountStatisticList = new ArrayList<>();
		List<LinkedHashMap<String,Object>> mtCustomerStatisticList = new ArrayList<>();
		List<LinkedHashMap<String,Object>> kyykCountStatisticList = new ArrayList<>();
		List<LinkedHashMap<String,Object>> ipCallCountStatisticList = new ArrayList<>();
		List<LinkedHashMap<String,Object>> yjCountStatisticList = new ArrayList<>();
		// 数据组装
		LinkedHashMap<String,Object> houseAddMap = new LinkedHashMap<String,Object>();
		houseAddMap.put("typeName", "房增");
		houseAddStatisticList.add(houseAddMap);
		LinkedHashMap<String,Object> customerAddMap = new LinkedHashMap<String,Object>();
		customerAddMap.put("typeName", "客增");
		customerAddStatisticList.add(customerAddMap);
		LinkedHashMap<String,Object> fkCountMap = new LinkedHashMap<String,Object>();
		fkCountMap.put("typeName", "房勘");
		fkCountStatisticList.add(fkCountMap);
		LinkedHashMap<String,Object> dkCountMap = new LinkedHashMap<String,Object>();
		dkCountMap.put("typeName", "带看");
		dkCountStatisticList.add(dkCountMap);
		LinkedHashMap<String,Object> gjHouseCountMap = new LinkedHashMap<String,Object>();
		gjHouseCountMap.put("typeName", "房源去电");
		gjHouseCountStatisticList.add(gjHouseCountMap);
		LinkedHashMap<String,Object> gjCustomerCountMap = new LinkedHashMap<String,Object>();
		gjCustomerCountMap.put("typeName", "客源去电");
		gjCustomerCountStatisticList.add(gjCustomerCountMap);
		LinkedHashMap<String,Object> ystjCountMap = new LinkedHashMap<String,Object>();
		ystjCountMap.put("typeName", "钥匙提交");
		ystjCountStatisticList.add(ystjCountMap);
		LinkedHashMap<String,Object> kfdpCountMap = new LinkedHashMap<String,Object>();
		kfdpCountMap.put("typeName", "空看");
		kfdpCountStatisticList.add(kfdpCountMap);
		LinkedHashMap<String,Object> wtCountMap = new LinkedHashMap<String,Object>();
		wtCountMap.put("typeName", "委托");
		wtCountStatisticList.add(wtCountMap);
		LinkedHashMap<String,Object> cjCountMap = new LinkedHashMap<String,Object>();
		cjCountMap.put("typeName", "签约");
		cjCountStatisticList.add(cjCountMap);
		LinkedHashMap<String,Object> tpscCountMap = new LinkedHashMap<String,Object>();
		tpscCountMap.put("typeName", "上传套数");
		tpscCountStatisticList.add(tpscCountMap);
		LinkedHashMap<String,Object> vrCountMap = new LinkedHashMap<String,Object>();
		vrCountMap.put("typeName", "VR上传");
		vrCountStatisticList.add(vrCountMap);
		LinkedHashMap<String,Object> spscCountMap = new LinkedHashMap<String,Object>();
		spscCountMap.put("typeName", "视频上传");
		spscCountStatisticList.add(spscCountMap);
//		LinkedHashMap<String,Object> ckdhCountMap = new LinkedHashMap<String,Object>();
//		ckdhCountMap.put("typeName", "查看电话");
//		ckdhCountStatisticList.add(ckdhCountMap);
		LinkedHashMap<String,Object> qftgCountMap = new LinkedHashMap<String,Object>();
		qftgCountMap.put("typeName", "房源群发");
		qftgCountStatisticList.add(qftgCountMap);
		LinkedHashMap<String,Object> pyqCountMap = new LinkedHashMap<String,Object>();
		pyqCountMap.put("typeName", "朋友圈分享");
		pyqCountStatisticList.add(pyqCountMap);

		LinkedHashMap<String,Object> mtHouseCountMap = new LinkedHashMap<String,Object>();
		mtHouseCountMap.put("typeName", "房源面谈");
		mtHouseCountStatisticList.add(mtHouseCountMap);
		LinkedHashMap<String,Object> mtCustomerCountMap = new LinkedHashMap<String,Object>();
		mtCustomerCountMap.put("typeName", "客源面谈");
		mtCustomerStatisticList.add(mtCustomerCountMap);
		LinkedHashMap<String,Object> kyykCountMap = new LinkedHashMap<String,Object>();
		kyykCountMap.put("typeName", "约看");
		kyykCountStatisticList.add(kyykCountMap);
		LinkedHashMap<String,Object> ipCallCountMap = new LinkedHashMap<String,Object>();
		ipCallCountMap.put("typeName", "隐号拨打");
		ipCallCountStatisticList.add(ipCallCountMap);
		LinkedHashMap<String,Object> yjCountMap = new LinkedHashMap<String,Object>();
		yjCountMap.put("typeName", "议价");
		yjCountStatisticList.add(yjCountMap);

		// 暂时没想好优化思路
		for(Entry<String, Object> entry : todayStatisticMap.entrySet()){
			String key = entry.getKey();
			Object value = entry.getValue();
			String targetKey = key + "T";
			if(entry.getKey().equals("houseAdd")){
				houseAddMap.put("todayTotal", value);
				houseAddMap.put("todayTarget", todayTarget.get(targetKey));
				houseAddMap.put("lookRankType", 1);
				houseAddMap.put("funCust", 1);
			} else if(entry.getKey().equals("customerAdd")){
				customerAddMap.put("todayTotal", value);
				customerAddMap.put("todayTarget", todayTarget.get(targetKey));
				customerAddMap.put("lookRankType", 1);
				customerAddMap.put("funCust", 2);
			} else if(entry.getKey().equals("fkCount")){
				fkCountMap.put("todayTotal", value);
				fkCountMap.put("todayTarget", todayTarget.get(targetKey));
				lookRankTypeProcess(fkCountMap, key);
			} else if(entry.getKey().equals("dkCount")){
				dkCountMap.put("todayTotal", value);
				dkCountMap.put("todayTarget", todayTarget.get("fdkCountT"));
				lookRankTypeProcess(dkCountMap, "fdkCount");
			} else if(entry.getKey().equals("gjHouseCount")){
				gjHouseCountMap.put("todayTotal", value);
				gjHouseCountMap.put("todayTarget", todayTarget.get(targetKey));
				gjHouseCountMap.put("funCust", 1);
				gjHouseCountMap.put("lookRankType", 9);
			} else if(entry.getKey().equals("gjCustomerCount")){
				gjCustomerCountMap.put("todayTotal", value);
				gjCustomerCountMap.put("todayTarget", todayTarget.get(targetKey));
				gjCustomerCountMap.put("funCust", 2);
				gjCustomerCountMap.put("lookRankType", 9);
			} else if(entry.getKey().equals("ystjCount")){
				ystjCountMap.put("todayTotal", value);
				ystjCountMap.put("todayTarget", todayTarget.get(targetKey));
				lookRankTypeProcess(ystjCountMap, key);
			} else if(entry.getKey().equals("kfdpCount")){
				kfdpCountMap.put("todayTotal", value);
				kfdpCountMap.put("todayTarget", todayTarget.get(targetKey));
				lookRankTypeProcess(kfdpCountMap, key);
			} else if(entry.getKey().equals("wtCount")){
				wtCountMap.put("todayTotal", value);
				wtCountMap.put("todayTarget", todayTarget.get(targetKey));
				lookRankTypeProcess(wtCountMap, key);
			} else if(entry.getKey().equals("cjCount")){
				cjCountMap.put("todayTotal", value);
				cjCountMap.put("todayTarget", todayTarget.get(targetKey));
				lookRankTypeProcess(cjCountMap, key);
			} else if(entry.getKey().equals("tpscCount")){
				tpscCountMap.put("todayTotal", value);
				tpscCountMap.put("todayTarget", todayTarget.get(targetKey));
				lookRankTypeProcess(tpscCountMap, key);
			} else if(entry.getKey().equals("vrCount")){
				vrCountMap.put("todayTotal", value);
				vrCountMap.put("todayTarget", todayTarget.get(targetKey));
				lookRankTypeProcess(vrCountMap, key);
			} else if(entry.getKey().equals("spscCount")){
				spscCountMap.put("todayTotal", value);
				spscCountMap.put("todayTarget", todayTarget.get(targetKey));
				lookRankTypeProcess(spscCountMap, key);
			}
//			else if(entry.getKey().equals("ckdhCount")){
//				ckdhCountMap.put("todayTotal", value);
//				ckdhCountMap.put("todayTarget", todayTarget.get(targetKey));
//				lookRankTypeProcess(ckdhCountMap, key);
//			}
			else if(entry.getKey().equals("qftgCount")){
				qftgCountMap.put("todayTotal", value);
				qftgCountMap.put("todayTarget", todayTarget.get(targetKey));
				lookRankTypeProcess(qftgCountMap, key);
			} else if(entry.getKey().equals("pyqCount")){
				pyqCountMap.put("todayTotal", value);
				pyqCountMap.put("todayTarget", todayTarget.get(targetKey));
				lookRankTypeProcess(pyqCountMap, key);
			} else if(entry.getKey().equals("mtHouseCount")){

				mtHouseCountMap.put("todayTotal", value);
				mtHouseCountMap.put("todayTarget", todayTarget.get(targetKey));
				mtHouseCountMap.put("funCust", 1);
				mtHouseCountMap.put("lookRankType", 46);
//				lookRankTypeProcess(mtHouseCountMap, key);
			} else if(entry.getKey().equals("mtCustomerCount")){
				mtCustomerCountMap.put("todayTotal", value);
				mtCustomerCountMap.put("todayTarget", todayTarget.get(targetKey));
				mtHouseCountMap.put("funCust", 2);
				mtHouseCountMap.put("lookRankType", 46);
//				lookRankTypeProcess(mtCustomerCountMap, key);
			} else if(entry.getKey().equals("kyykCount")){
				kyykCountMap.put("todayTotal", value);
				kyykCountMap.put("todayTarget", todayTarget.get(targetKey));
				lookRankTypeProcess(kyykCountMap, key);
			} else if(entry.getKey().equals("ipcallCount")){
				ipCallCountMap.put("todayTotal", value);
				ipCallCountMap.put("todayTarget", todayTarget.get(targetKey));
				lookRankTypeProcess(ipCallCountMap, key);
			} else if(entry.getKey().equals("yjCount")){
				yjCountMap.put("todayTotal", value);
				yjCountMap.put("todayTarget", todayTarget.get(targetKey));
				lookRankTypeProcess(yjCountMap, key);
			}
		}
		for(Entry<String, Object> entry : monthStatisticMap.entrySet()){
			String key = entry.getKey();
			String targetKey = key + "T";
			if(entry.getKey().equals("houseAdd")){
				houseAddMap.put("monthTotal", entry.getValue());
				houseAddMap.put("monthTarget", monthTarget.get(targetKey));
				houseAddMap.put("lookRankType", 1);
				houseAddMap.put("funCust", 1);
			} else if(entry.getKey().equals("customerAdd")){
				customerAddMap.put("monthTotal", entry.getValue());
				customerAddMap.put("monthTarget", monthTarget.get(targetKey));
				customerAddMap.put("lookRankType", 1);
				customerAddMap.put("funCust", 2);
			} else if(entry.getKey().equals("fkCount")){
				fkCountMap.put("monthTotal", entry.getValue());
				fkCountMap.put("monthTarget", monthTarget.get(targetKey));
				lookRankTypeProcess(fkCountMap, key);
			} else if(entry.getKey().equals("dkCount")){
				dkCountMap.put("monthTotal", entry.getValue());
				dkCountMap.put("monthTarget", monthTarget.get("fdkCountT"));
				lookRankTypeProcess(dkCountMap, "fdkCount");
			} else if(entry.getKey().equals("gjHouseCount")){
				gjHouseCountMap.put("monthTotal", entry.getValue());
				gjHouseCountMap.put("monthTarget", monthTarget.get(targetKey));
				gjHouseCountMap.put("funCust", 1);
				gjHouseCountMap.put("lookRankType", 9);
			} else if(entry.getKey().equals("gjCustomerCount")){
				gjCustomerCountMap.put("monthTotal", entry.getValue());
				gjCustomerCountMap.put("monthTarget", monthTarget.get(targetKey));
				gjCustomerCountMap.put("funCust", 2);
				gjCustomerCountMap.put("lookRankType", 9);
			} else if(entry.getKey().equals("ystjCount")){
				ystjCountMap.put("monthTotal", entry.getValue());
				ystjCountMap.put("monthTarget", monthTarget.get(targetKey));
				lookRankTypeProcess(ystjCountMap, key);
			} else if(entry.getKey().equals("kfdpCount")){
				kfdpCountMap.put("monthTotal", entry.getValue());
				kfdpCountMap.put("monthTarget", monthTarget.get(targetKey));
				lookRankTypeProcess(kfdpCountMap, key);
			} else if(entry.getKey().equals("wtCount")){
				wtCountMap.put("monthTotal", entry.getValue());
				wtCountMap.put("monthTarget", monthTarget.get(targetKey));
				lookRankTypeProcess(wtCountMap, key);
			} else if(entry.getKey().equals("cjCount")){
				cjCountMap.put("monthTotal", entry.getValue());
				cjCountMap.put("monthTarget", monthTarget.get(targetKey));
				lookRankTypeProcess(cjCountMap, key);
			} else if(entry.getKey().equals("tpscCount")){
				tpscCountMap.put("monthTotal", entry.getValue());
				tpscCountMap.put("monthTarget", monthTarget.get(targetKey));
				lookRankTypeProcess(tpscCountMap, key);
			} else if(entry.getKey().equals("vrCount")){
				vrCountMap.put("monthTotal", entry.getValue());
				vrCountMap.put("monthTarget", monthTarget.get(targetKey));
				lookRankTypeProcess(vrCountMap, key);
			} else if(entry.getKey().equals("spscCount")){
				spscCountMap.put("monthTotal", entry.getValue());
				spscCountMap.put("monthTarget", monthTarget.get(targetKey));
				lookRankTypeProcess(spscCountMap, key);
			}
//			else if(entry.getKey().equals("ckdhCount")){
//				ckdhCountMap.put("monthTotal", entry.getValue());
//				ckdhCountMap.put("monthTarget", monthTarget.get(targetKey));
//				lookRankTypeProcess(ckdhCountMap, key);
//			}
			else if(entry.getKey().equals("qftgCount")){
				qftgCountMap.put("monthTotal", entry.getValue());
				qftgCountMap.put("monthTarget", monthTarget.get(targetKey));
				lookRankTypeProcess(qftgCountMap, key);
			} else if(entry.getKey().equals("pyqCount")){
				pyqCountMap.put("monthTotal", entry.getValue());
				pyqCountMap.put("monthTarget", monthTarget.get(targetKey));
				lookRankTypeProcess(pyqCountMap, key);
			} else if(entry.getKey().equals("mtHouseCount")){
				mtHouseCountMap.put("monthTotal", entry.getValue());
				mtHouseCountMap.put("monthTarget", todayTarget.get(targetKey));
				mtHouseCountMap.put("funCust", 1);
				mtHouseCountMap.put("lookRankType", 46);
//				lookRankTypeProcess(mtHouseCountMap, key);
			} else if(entry.getKey().equals("mtCustomerCount")){
				mtCustomerCountMap.put("monthTotal", entry.getValue());
				mtCustomerCountMap.put("monthTarget", todayTarget.get(targetKey));
				mtCustomerCountMap.put("funCust", 2);
				mtCustomerCountMap.put("lookRankType", 46);
//				lookRankTypeProcess(mtCustomerCountMap, key);
			} else if(entry.getKey().equals("kyykCount")){
				kyykCountMap.put("monthTotal", entry.getValue());
				kyykCountMap.put("monthTarget", todayTarget.get(targetKey));
				lookRankTypeProcess(kyykCountMap, key);
			} else if(entry.getKey().equals("ipcallCount")){
				ipCallCountMap.put("monthTotal", entry.getValue());
				ipCallCountMap.put("monthTarget", todayTarget.get(targetKey));
				lookRankTypeProcess(ipCallCountMap, key);
			} else if(entry.getKey().equals("yjCount")){
				yjCountMap.put("monthTotal", entry.getValue());
				yjCountMap.put("monthTarget", todayTarget.get(targetKey));
				lookRankTypeProcess(yjCountMap, key);
			}
		}
		for(Entry<String, Object> entry : weekStatisticMap.entrySet()){
			String key = entry.getKey();
			String targetKey = key + "T";
			if(entry.getKey().equals("houseAdd")){
				houseAddMap.put("weekTotal", entry.getValue());
				houseAddMap.put("weekTarget", weekTarget.get(targetKey));
				houseAddMap.put("lookRankType", 1);
				houseAddMap.put("funCust", 1);
			} else if(entry.getKey().equals("customerAdd")){
				customerAddMap.put("weekTotal", entry.getValue());
				customerAddMap.put("weekTarget", weekTarget.get(targetKey));
				customerAddMap.put("lookRankType", 1);
				customerAddMap.put("funCust", 2);
			} else if(entry.getKey().equals("fkCount")){
				fkCountMap.put("weekTotal", entry.getValue());
				fkCountMap.put("weekTarget", weekTarget.get(targetKey));
				lookRankTypeProcess(fkCountMap, key);
			} else if(entry.getKey().equals("dkCount")){
				dkCountMap.put("weekTotal", entry.getValue());
				dkCountMap.put("weekTarget", weekTarget.get("fdkCountT"));
				lookRankTypeProcess(dkCountMap, "fdkCount");
			} else if(entry.getKey().equals("gjHouseCount")){
				gjHouseCountMap.put("weekTotal", entry.getValue());
				gjHouseCountMap.put("weekTarget", weekTarget.get(targetKey));
				gjHouseCountMap.put("funCust", 1);
				gjHouseCountMap.put("lookRankType", 9);
				lookRankTypeProcess(dkCountMap, key);
			} else if(entry.getKey().equals("gjCustomerCount")){
				gjCustomerCountMap.put("weekTotal", entry.getValue());
				gjCustomerCountMap.put("weekTarget", weekTarget.get(targetKey));
				gjCustomerCountMap.put("funCust", 2);
				gjCustomerCountMap.put("lookRankType", 9);
				lookRankTypeProcess(dkCountMap, key);
			} else if(entry.getKey().equals("ystjCount")){
				ystjCountMap.put("weekTotal", entry.getValue());
				ystjCountMap.put("weekTarget", weekTarget.get(targetKey));
				lookRankTypeProcess(ystjCountMap, key);
			} else if(entry.getKey().equals("kfdpCount")){
				kfdpCountMap.put("weekTotal", entry.getValue());
				kfdpCountMap.put("weekTarget", weekTarget.get(targetKey));
				lookRankTypeProcess(kfdpCountMap, key);
			} else if(entry.getKey().equals("wtCount")){
				wtCountMap.put("weekTotal", entry.getValue());
				wtCountMap.put("weekTarget", weekTarget.get(targetKey));
				lookRankTypeProcess(wtCountMap, key);
			} else if(entry.getKey().equals("cjCount")){
				cjCountMap.put("weekTotal", entry.getValue());
				cjCountMap.put("weekTarget", weekTarget.get(targetKey));
				lookRankTypeProcess(cjCountMap, key);
			} else if(entry.getKey().equals("tpscCount")){
				tpscCountMap.put("weekTotal", entry.getValue());
				tpscCountMap.put("weekTarget", weekTarget.get(targetKey));
				lookRankTypeProcess(tpscCountMap, key);
			} else if(entry.getKey().equals("vrCount")){
				vrCountMap.put("weekTotal", entry.getValue());
				vrCountMap.put("weekTarget", weekTarget.get(targetKey));
				lookRankTypeProcess(vrCountMap, key);
			} else if(entry.getKey().equals("spscCount")){
				spscCountMap.put("weekTotal", entry.getValue());
				spscCountMap.put("weekTarget", weekTarget.get(targetKey));
				lookRankTypeProcess(spscCountMap, key);
			}
//			else if(entry.getKey().equals("ckdhCount")){
//				ckdhCountMap.put("weekTotal", entry.getValue());
//				ckdhCountMap.put("weekTarget", weekTarget.get(targetKey));
//				lookRankTypeProcess(ckdhCountMap, key);
//			}
			else if(entry.getKey().equals("qftgCount")){
				qftgCountMap.put("weekTotal", entry.getValue());
				qftgCountMap.put("weekTarget", weekTarget.get(targetKey));
				lookRankTypeProcess(qftgCountMap, key);
			} else if(entry.getKey().equals("pyqCount")){
				pyqCountMap.put("weekTotal", entry.getValue());
				pyqCountMap.put("weekTarget", weekTarget.get(targetKey));
				lookRankTypeProcess(pyqCountMap, key);
			}  else if(entry.getKey().equals("mtHouseCount")){
				mtHouseCountMap.put("weekTotal", entry.getValue());
				mtHouseCountMap.put("weekTarget", todayTarget.get(targetKey));
				mtHouseCountMap.put("funCust", 1);
				mtHouseCountMap.put("lookRankType", 46);
//				lookRankTypeProcess(mtHouseCountMap, key);
			} else if(entry.getKey().equals("mtCustomerCount")){
				mtCustomerCountMap.put("weekTotal", entry.getValue());
				mtCustomerCountMap.put("weekTarget", todayTarget.get(targetKey));
				mtCustomerCountMap.put("funCust", 2);
				mtCustomerCountMap.put("lookRankType", 46);
//				lookRankTypeProcess(mtCustomerCountMap, key);
			} else if(entry.getKey().equals("kyykCount")){
				kyykCountMap.put("weekTotal", entry.getValue());
				kyykCountMap.put("weekTarget", todayTarget.get(targetKey));
				lookRankTypeProcess(kyykCountMap, key);
			} else if(entry.getKey().equals("ipcallCount")){
				ipCallCountMap.put("weekTotal", entry.getValue());
				ipCallCountMap.put("weekTarget", todayTarget.get(targetKey));
				lookRankTypeProcess(ipCallCountMap, key);
			} else if(entry.getKey().equals("yjCount")){
				yjCountMap.put("weekTotal", entry.getValue());
				yjCountMap.put("weekTarget", todayTarget.get(targetKey));
				lookRankTypeProcess(yjCountMap, key);
			}
		}
		List<LinkedHashMap<String,Object>> resultList = new ArrayList<>();
		resultList.addAll(houseAddStatisticList);
		resultList.addAll(customerAddStatisticList);
		resultList.addAll(fkCountStatisticList);
		resultList.addAll(dkCountStatisticList);
		resultList.addAll(gjHouseCountStatisticList);
		resultList.addAll(gjCustomerCountStatisticList);
		resultList.addAll(ystjCountStatisticList);
		resultList.addAll(kfdpCountStatisticList);
		resultList.addAll(wtCountStatisticList);
		resultList.addAll(cjCountStatisticList);
		resultList.addAll(tpscCountStatisticList);
		resultList.addAll(vrCountStatisticList);
		resultList.addAll(spscCountStatisticList);
//		resultList.addAll(ckdhCountStatisticList);
		resultList.addAll(qftgCountStatisticList);
		resultList.addAll(pyqCountStatisticList);
		resultList.addAll(mtHouseCountStatisticList);
		resultList.addAll(mtCustomerStatisticList);
		resultList.addAll(kyykCountStatisticList);
		resultList.addAll(ipCallCountStatisticList);
		resultList.addAll(yjCountStatisticList);
		return resultList;
	}

	/**
	 * 首页获取业绩排行
	 * @author 黎桂良
	 * @since 2020年2月13日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getPortentialPerformanceRank")
	public ResponseJson getPortentialPerformanceRank(@RequestBody BaseMapParam param) {
		Byte rankType = param.getByte("rankType");
		Integer organizationId = param.getInteger("organizationId");
		if(Integer.valueOf("0").equals(organizationId)){
			organizationId = null;
		}
		Integer userId = param.getInteger("userId");
		String position = param.getString("position");
		Integer roleLevelId = param.getInteger("roleLevelId");
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		ErpFunUsersExample userExample  = new ErpFunUsersExample();
		userExample.setShardCityId(cityId);
		ErpFunUsersExample.Criteria criteria = userExample.createCriteria().andCompIdEqualTo(compId.intValue()).andUserWriteoffEqualTo(false);
		if(organizationId != null){
			criteria.andTissueLineLike("%:" + organizationId + ":%");
		}
		if(userId != null){
			criteria.andUserIdEqualTo(userId);
		}
		if(StringUtil.isNotBlank(position)){
			criteria.andUserPositionEqualTo(position);
		}else{
			position = null;
		}
		if(roleLevelId != null){
			criteria.andRoleLevelIdEqualTo(roleLevelId);
		}
		List<ErpFunUsers> organizationAllUser = erpFunUsersMapper.selectByExample(userExample);
		List<Map<String,String>>  tempData = new ArrayList<>();
		//获取组下所有人的ID
		Set<Integer> orgUserIds = new HashSet<>();
		organizationAllUser.stream().forEach(o->{
			orgUserIds.add(o.getUserId());
			Map<String,String> userData = new HashMap<>();
			userData.put("userId",o.getUserId().toString());//员工ID
			userData.put("userName",o.getUserName());//员工名字
			userData.put("userNo",o.getUserNo());//员工编号
			userData.put("userPhoto",o.getUserPhoto() != null? AppConfig.getHousePicDomainPath(o.getUserPhoto()) : null);//员工头像
			userData.put("isOperator","2");//是否当前操作人，1：是，2：否
			if(operator.getUserId().equals(o.getUserId())){
				userData.put("isOperator","1");//是否当前操作人，1：是，2：否
			}
			userData.put("portentialPerFormance","0");//单项业绩总额
			userData.put("portentialTotalPerFormance","0");//所有潜在业绩总额
			userData.put("offereeCount","0");//接盘数量
			userData.put("checkCount","0");//实勘数量
			userData.put("submitKeyCount","0");//提交钥匙数量
			userData.put("recordCount","0");//备案数量
			tempData.add(userData);
		});
		List<Map<String, Object>> userPortentialTotalPerFormance = new ArrayList<>();//统计总业绩的数据MAP
		List<Map<String, Object>> userPortentialPerFormance = new ArrayList<>();//统计所选类型业绩的数据MAP
		//获取个业绩类型的比例
		List<ErpFunPerformanceType> list = erpFunPerformanceTypeMapper.getDataListByCompId(cityId, 0);
		Map<String,BigDecimal> rateMap = new HashMap<>();
		list.stream().forEach(o->{
			if("接盘人".equals(o.getPerformanceName())){
				rateMap.put("offereeRate",o.getPerformanceProportion());
			}else if("钥匙人".equals(o.getPerformanceName())){
				rateMap.put("submitKeyRate",o.getPerformanceProportion());
			}else if("实勘人".equals(o.getPerformanceName())){
				rateMap.put("funCheckRate",o.getPerformanceProportion());
			}else if("备案人".equals(o.getPerformanceName())){
				rateMap.put("recordRate",o.getPerformanceProportion());
			}
		});
		AdminFunCity dataByCityId = adminFunCityMapper.getDataByCityId(cityId);
		BigDecimal portentialPerformanceCommissionRate = dataByCityId.getPortentialPerformanceCommissionRate();
		//接盘人
		List<Map<String, Object>> userOffereeMapSale = erpFunSaleMapper.countCroupeByUserId(cityId, compId, rateMap.get("offereeRate"), portentialPerformanceCommissionRate,organizationId, position, userId);
		List<Map<String, Object>> userOffereeMapLease = erpFunLeaseMapper.countCroupeByUserId(cityId, compId, rateMap.get("offereeRate"),organizationId, position, userId);
		//钥匙人
		List<Map<String, Object>> userKeyMoneyMap = erpFunKeyMapper.countCroupeByUserId(cityId, compId, rateMap.get("submitKeyRate"), portentialPerformanceCommissionRate,organizationId, position, userId);
		//备案人
		List<Map<String, Object>> userRecordMoneyMap = erpFunEntrustMapper.countCroupeByUserId(cityId, compId, rateMap.get("recordRate"), portentialPerformanceCommissionRate,organizationId, position, userId);
		//房堪人
		List<Map<String, Object>> userCheckMoneyMapSale = erpFunSaleMapper.countCheckCroupeByUserId(cityId, compId, rateMap.get("funCheckRate"), portentialPerformanceCommissionRate,organizationId, position, userId);
		List<Map<String, Object>> userCheckMoneyMapLease = erpFunLeaseMapper.countCheckCroupeByUserId(cityId, compId, rateMap.get("funCheckRate"), organizationId, position, userId);
		userPortentialTotalPerFormance.addAll(userOffereeMapSale);
		userPortentialTotalPerFormance.addAll(userOffereeMapLease);
		userPortentialTotalPerFormance.addAll(userKeyMoneyMap);
		userPortentialTotalPerFormance.addAll(userRecordMoneyMap);
		userPortentialTotalPerFormance.addAll(userCheckMoneyMapSale);
		userPortentialTotalPerFormance.addAll(userCheckMoneyMapLease);
		if(Byte.valueOf("1").equals(rankType)){//总业绩
			userPortentialPerFormance.addAll(userOffereeMapSale);
			userPortentialPerFormance.addAll(userOffereeMapLease);
			userPortentialPerFormance.addAll(userKeyMoneyMap);
			userPortentialPerFormance.addAll(userRecordMoneyMap);
			userPortentialPerFormance.addAll(userCheckMoneyMapSale);
			userPortentialPerFormance.addAll(userCheckMoneyMapLease);
		}else if(Byte.valueOf("2").equals(rankType)){//接盘人
			userPortentialPerFormance.addAll(userOffereeMapSale);
			userPortentialPerFormance.addAll(userOffereeMapLease);
		}else if(Byte.valueOf("3").equals(rankType)){//实勘人
			userPortentialPerFormance.addAll(userCheckMoneyMapSale);
			userPortentialPerFormance.addAll(userCheckMoneyMapLease);
		}else if(Byte.valueOf("4").equals(rankType)){//钥匙人
			userPortentialPerFormance.addAll(userKeyMoneyMap);
		}else if(Byte.valueOf("5").equals(rankType)){//备案人
			userPortentialPerFormance.addAll(userRecordMoneyMap);
		}

		List<Map<String, String>> resultData = tempData.stream().peek(o -> {
			//总业绩计算
			userPortentialTotalPerFormance.stream().filter(obj -> o.get("userId").equals(obj.get("userId").toString())).forEach(obj -> {
				//由于出租房源价格单位不一样，所以根据不同的单位化为每月的租金参与计算，出售的默认三个比例都为1
				String priceUnit = (obj.get("priceUnit") == null ? "null" : obj.get("priceUnit")).toString();
				Integer rentRate = 1;
				Integer areaRate = 1;
				Integer timeRate = 1;
				if("2".equals(priceUnit)){
					rentRate = 30;
				}else if("3".equals(priceUnit)){
					areaRate = areaRate * ((BigDecimal)obj.get("priceUnit")).intValue();
				}else if("4".equals(priceUnit)){
					rentRate = 30;
					areaRate = areaRate * ((BigDecimal)obj.get("priceUnit")).intValue();
				}else if("5".equals(priceUnit)){
					timeRate = 12;
				}
				Integer result =((BigDecimal) obj.get("money")).intValue() * rentRate * areaRate / timeRate;
				o.put("portentialTotalPerFormance", (Integer.valueOf(o.get("portentialTotalPerFormance")) + result) + "");
			});
			//类型业绩计算
			userPortentialPerFormance.stream().filter(obj -> o.get("userId").equals(obj.get("userId").toString())).forEach(obj -> {
				//由于出租房源价格单位不一样，所以根据不同的单位化为每月的租金参与计算，出售的默认三个比例都为1
				String priceUnit = (obj.get("priceUnit") == null ? "null" : obj.get("priceUnit")).toString();
				Integer rentRate = 1;
				Integer areaRate = 1;
				Integer timeRate = 1;
				if("2".equals(priceUnit)){
					rentRate = 30;
				}else if("3".equals(priceUnit)){
					areaRate = areaRate * ((BigDecimal)obj.get("priceUnit")).intValue();
				}else if("4".equals(priceUnit)){
					rentRate = 30;
					areaRate = areaRate * ((BigDecimal)obj.get("priceUnit")).intValue();
				}else if("5".equals(priceUnit)){
					timeRate = 12;
				}
				Integer result =((BigDecimal) obj.get("money")).intValue() * rentRate * areaRate / timeRate;
				o.put("portentialPerFormance", (Integer.valueOf(o.get("portentialPerFormance")) + result) + "");
			});
			//接盘数量统计
			userOffereeMapSale.stream().filter(obj -> o.get("userId").equals(obj.get("userId").toString())).forEach(obj -> {
				o.put("offereeCount", (Integer.valueOf(o.get("offereeCount")) + (Integer) obj.get("count")) + "");
			});
			userOffereeMapLease.stream().filter(obj -> o.get("userId").equals(obj.get("userId").toString())).forEach(obj -> {
				o.put("offereeCount", (Integer.valueOf(o.get("offereeCount")) + (Integer) obj.get("count")) + "");
			});
			//实勘数量统计
			userCheckMoneyMapSale.stream().filter(obj -> o.get("userId").equals(obj.get("userId").toString())).forEach(obj -> {
				o.put("checkCount", (Integer.valueOf(o.get("checkCount")) + (Integer) obj.get("count")) + "");
			});
			userCheckMoneyMapLease.stream().filter(obj -> o.get("userId").equals(obj.get("userId"))).forEach(obj -> {
				o.put("checkCount", (Integer.valueOf(o.get("checkCount")) + (Integer) obj.get("count")) + "");
			});
			//提交钥匙数量统计
			userKeyMoneyMap.stream().filter(obj -> o.get("userId").equals(obj.get("userId").toString())).forEach(obj -> {
				o.put("submitKeyCount", (Integer.valueOf(o.get("submitKeyCount")) + (Integer) obj.get("count")) + "");
			});
			//备案数量统计
			userRecordMoneyMap.stream().filter(obj -> o.get("userId").equals(obj.get("userId").toString())).forEach(obj -> {
				o.put("recordCount", (Integer.valueOf(o.get("recordCount")) + (Integer) obj.get("count")) + "");
			});
		}).sorted(new Comparator<Map<String, String>>() {
			@Override
			public int compare(Map<String, String> m1, Map<String, String> m2) {
				Double v1 = Double.valueOf(m1.get("portentialPerFormance"));
				Double v2 = Double.valueOf(m2.get("portentialPerFormance"));
				return Double.compare(v2, v1);
			}
		}).collect(Collectors.toList());

		//编号
		for (int i = 0; i < tempData.size(); i++) {
			resultData.get(i).put("num",(i+1)+"");
		}

		return ErpResponseJson.ok(resultData);
	}

	/**
	 * 获取个人业绩详情
	 * @author 黎桂良
	 * @since 2020年2月17日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getPersonnalPortentialPerformance")
	public ResponseJson getPersonnalPortentialPerformance(@RequestBody BaseMapParam param) {
		Integer userId = param.getInteger("userId");
		Integer pageNum = param.getInteger("pageNum");
		Integer pageRow = param.getInteger("pageRow");
		Byte caseType = param.getByte("caseType");
		if(userId == null || pageNum == null || pageRow == null){
			throw new BusinessException("参数不足。");
		}
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		//获取个业绩类型的比例
		List<ErpFunPerformanceType> list = erpFunPerformanceTypeMapper.getDataListByCompId(cityId, 0);
		Map<String,BigDecimal> rateMap = new HashMap<>();
		list.stream().forEach(o->{
			if("接盘人".equals(o.getPerformanceName())){
				rateMap.put("offereeRate",o.getPerformanceProportion());
			}else if("钥匙人".equals(o.getPerformanceName())){
				rateMap.put("submitKeyRate",o.getPerformanceProportion());
			}else if("实勘人".equals(o.getPerformanceName())){
				rateMap.put("funCheckRate",o.getPerformanceProportion());
			}else if("备案人".equals(o.getPerformanceName())){
				rateMap.put("recordRate",o.getPerformanceProportion());
			}
		});
		AdminFunCity dataByCityId = adminFunCityMapper.getDataByCityId(cityId);
		BigDecimal portentialPerformanceCommissionRate = dataByCityId.getPortentialPerformanceCommissionRate();
		List<Map<String, Object>> personnalPortentialPerformance = erpFunSaleMapper.getPersonnalPortentialPerformance(cityId, compId, userId, rateMap.get("offereeRate"), rateMap.get("submitKeyRate"), rateMap.get("funCheckRate"), rateMap.get("recordRate"),portentialPerformanceCommissionRate,caseType);
		List<PersonnalPortentialPerformanceVO> originalData = new ArrayList<>();
		Set<Integer> saleId = new HashSet<>();
		Set<Integer> leaseId = new HashSet<>();
		if(!personnalPortentialPerformance.isEmpty()){
			personnalPortentialPerformance.stream().forEach(o->{
				Map<String,Boolean> flagMap = new HashMap<>();
				flagMap.put("flag",true);
				if("1".equals(o.get("caseType"))){
					saleId.add((Integer)o.get("caseId"));
				}else{
					leaseId.add((Integer)o.get("caseId"));
				}
				originalData.stream().forEach(obj->{//结果集中有对应房源，增加部分信息，角色，录入时间，金额就可以了
					if(obj.getCaseId().equals((Integer)o.get("caseId")) && Integer.valueOf(obj.getCaseType().toString()).equals((Integer)o.get("caseType"))){
						flagMap.put("flag",false);
						Map<String,Object> detailMap = new HashMap<>();
						detailMap.put("position",o.get("position"));
						if(o.get("inputTime")==null){
							detailMap.put("inputTime","");
						}else{
							detailMap.put("inputTime",DateTimeHelper.formatDateTimetoString(o.get("inputTime").toString(),"yyyy-MM-dd HH:mm"));
						}
						//由于出租房源价格单位不一样，所以根据不同的单位化为每月的租金参与计算，出售的默认三个比例都为1
						String priceUnit = (o.get("priceUnit") == null ? "null" : o.get("priceUnit")).toString();
						Integer rentRate = 1;
						Integer areaRate = 1;
						Integer timeRate = 1;
						if("2".equals(priceUnit)){
							rentRate = 30;
						}else if("3".equals(priceUnit)){
							areaRate = areaRate * ((BigDecimal)o.get("priceUnit")).intValue();
						}else if("4".equals(priceUnit)){
							rentRate = 30;
							areaRate = areaRate * ((BigDecimal)o.get("priceUnit")).intValue();
						}else if("5".equals(priceUnit)){
							timeRate = 12;
						}
						Integer result =((BigDecimal) o.get("money")).intValue() * rentRate * areaRate / timeRate;
						detailMap.put("money",result);
						obj.getPerformanceDetail().add(detailMap);
					}
				});
				if(flagMap.get("flag")){//结果集没有对应的房源，新增一条数据录入
					PersonnalPortentialPerformanceVO personnalPortentialPerformanceVO = new PersonnalPortentialPerformanceVO();
					personnalPortentialPerformanceVO.setCaseId((Integer) o.get("caseId"));
					personnalPortentialPerformanceVO.setCaseType(Byte.valueOf(((Integer)o.get("caseType")).toString()));
					personnalPortentialPerformanceVO.setFunNum((String) o.get("funNum"));
					personnalPortentialPerformanceVO.setHouseType((String) o.get("houseType"));
					personnalPortentialPerformanceVO.setArea((BigDecimal) o.get("area"));
					//价格单位字段
					String priceUnitStr = "万";
					//由于出租房源价格单位不一样，所以根据不同的单位化为每月的租金参与计算，出售的默认三个比例都为1
					String priceUnit = (o.get("priceUnit") == null ? "null" : o.get("priceUnit")).toString();
					Integer rentRate = 1;
					Integer areaRate = 1;
					Integer timeRate = 1;
					if("1".equals(priceUnit)){
						priceUnitStr = "元/月";
					}else if("2".equals(priceUnit)){
						rentRate = 30;
						priceUnitStr = "元/天";
					}else if("3".equals(priceUnit)){
						areaRate = areaRate * ((BigDecimal)o.get("priceUnit")).intValue();
						priceUnitStr = "元/平米*月";
					}else if("4".equals(priceUnit)){
						rentRate = 30;
						areaRate = areaRate * ((BigDecimal)o.get("priceUnit")).intValue();
						priceUnitStr = "元/平米*天";
					}else if("5".equals(priceUnit)){
						timeRate = 12;
						priceUnitStr = "元/年";
					}
					personnalPortentialPerformanceVO.setTotalPrice(((BigDecimal)o.get("totalPrice")).intValue() + priceUnitStr);
					personnalPortentialPerformanceVO.setFunCreationTime(o.get("funCreationTime") == null ? new Date() : (Date)o.get("funCreationTime"));
					Map<String,Object> detailMap = new HashMap<>();
					detailMap.put("position",o.get("position"));
					if(o.get("inputTime")==null){
						detailMap.put("inputTime","");
					}else{
						detailMap.put("inputTime",DateTimeHelper.formatDateTimetoString(o.get("inputTime").toString(),"yyyy-MM-dd HH:mm"));
					}
					Integer result =((BigDecimal) o.get("money")).intValue() * rentRate * areaRate / timeRate;
					detailMap.put("money",result);
					List<Map<String,Object>>detailMapList = new ArrayList<>();
					detailMapList.add(detailMap);
					personnalPortentialPerformanceVO.setPerformanceDetail(detailMapList);
					originalData.add(personnalPortentialPerformanceVO);
				}

			});
		}
		List<PersonnalPortentialPerformanceVO> midData = originalData.stream().sorted(new Comparator<PersonnalPortentialPerformanceVO>() {
			@Override
			public int compare(PersonnalPortentialPerformanceVO p1, PersonnalPortentialPerformanceVO p2) {
				return Long.compare(p2.getFunCreationTime().getTime(),p1.getFunCreationTime().getTime());
			}
		}).collect(Collectors.toList());
		for (int i = 0; i < midData.size(); i++) {
			midData.get(i).setSortNum(i+1);
		}
		List<PersonnalPortentialPerformanceVO> resultData = new ArrayList<>();
		midData.stream().filter(o->o.getSortNum()>((pageNum-1) * pageRow) && o.getSortNum()<=(pageNum * pageRow)).forEach(o->{
			resultData.add(o);
		});
		//查出所有房源图片
		Map<Integer, List<ErpFunPhoto>> saleIdPhotoMap = new HashMap<>();
		if(!saleId.isEmpty()){
			List<Integer> saleIds = new ArrayList<>(saleId);
			ErpFunPhotoExample photoExample = new ErpFunPhotoExample();
			photoExample.setShardCityId(cityId);
			photoExample.createCriteria().andCompIdEqualTo(compId).andCaseTypeEqualTo(Byte.valueOf("1")).andCaseIdIn(saleIds);
			Map<Integer, List<ErpFunPhoto>> collect = erpFunPhotoMapper.selectByExample(photoExample).stream().collect(Collectors.groupingBy(ErpFunPhoto::getCaseId));
			saleIdPhotoMap.putAll(collect);
		}
		Map<Integer, List<ErpFunPhoto>> leaseIdPhotoMap = new HashMap<>();
		if(!leaseId.isEmpty()){
			List<Integer> leaseIds = new ArrayList<>(leaseId);
			ErpFunPhotoExample photoExample = new ErpFunPhotoExample();
			photoExample.setShardCityId(cityId);
			photoExample.createCriteria().andCompIdEqualTo(compId).andCaseTypeEqualTo(Byte.valueOf("2")).andCaseIdIn(leaseIds);
			Map<Integer, List<ErpFunPhoto>> collect = erpFunPhotoMapper.selectByExample(photoExample).stream().collect(Collectors.groupingBy(ErpFunPhoto::getCaseId));
			leaseIdPhotoMap.putAll(collect);
		}
		//查出带看次数
		List<Integer> saleIds = new ArrayList<>(saleId);
		List<Integer> leaseIds = new ArrayList<>(leaseId);
		if(saleIds.isEmpty()){
			saleIds = null;
		}
		if(leaseIds.isEmpty()){
			leaseIds = null;
		}
		List<Map<String, Object>> timesMapList = erpFunTrackMapper.countTakeLookTime(cityId, compId, userId, saleIds, leaseIds);
		//封装信息
		resultData.stream().forEach(o->{
			o.setTakeLookTimeCount(0);
			if(Byte.valueOf("1").equals(o.getCaseType())){
				List<String> photoAddrs = new ArrayList<>();
				if(saleIdPhotoMap.get(o.getCaseId()) != null){
					saleIdPhotoMap.get(o.getCaseId()).stream().filter(obj->StringUtil.isNotBlank(obj.getPhotoAddr())).forEach(obj->{
						photoAddrs.add(AppConfig.getHousePicDomainPath(obj.getPhotoAddr()));
					});
				}
				o.setFunPhotoList(photoAddrs);
			}else{
				List<String> photoAddrs = new ArrayList<>();
				if(leaseIdPhotoMap.get(o.getCaseId()) != null){
					leaseIdPhotoMap.get(o.getCaseId()).stream().filter(obj->StringUtil.isNotBlank(obj.getPhotoAddr())).forEach(obj->{
						photoAddrs.add(AppConfig.getHousePicDomainPath(obj.getPhotoAddr()));
					});
				}
				o.setFunPhotoList(photoAddrs);
			}
			timesMapList.stream().filter(obj->obj.get("caseId").equals(o.getCaseId()) && obj.get("caseType").equals(o.getCaseType())).forEach(obj->{
				o.setTakeLookTimeCount((Integer)obj.get("count"));
			});
		});
		return ErpResponseJson.ok(resultData);
	}
}


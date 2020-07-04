package com.myfun.erpWeb.match;

import java.util.*;
import java.util.stream.Collectors;

import com.github.pagehelper.PageHelper;
import com.myfun.erpWeb.match.param.MatchBuyCustPushParam;
import com.myfun.erpWeb.match.param.MatchLeasePushParam;
import com.myfun.erpWeb.match.param.MatchRentCustPushParam;
import com.myfun.erpWeb.match.param.MatchSalePushParam;
import com.myfun.erpWeb.match.vo.MatchBuyCustPushVo;
import com.myfun.erpWeb.match.vo.MatchLeasePushVo;
import com.myfun.erpWeb.match.vo.MatchRentCustPushVo;
import com.myfun.erpWeb.match.vo.MatchSalePushVo;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.ErpFunLeaseDto;
import com.myfun.repository.erpdb.dto.ErpFunSaleDto;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.myfun.framework.config.AppConfig;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunDeptsMapper;
import com.myfun.repository.admindb.po.AdminFunDepts;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import com.myfun.service.business.erpdb.ErpSysParaService;
import com.myfun.service.business.erpdb.ErpUserOpersService;
@Api(tags = "房客匹配模块")
@RestController
@RequestMapping(value = "/match", method=RequestMethod.POST)
public class MatchHouseCustController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(MatchHouseCustController.class);
	@Autowired
	ErpFunPrologsMapper erpFunPrologsMapper;
	@Autowired
	ErpFunMsgMapper erpFunMsgMapper;
	@Autowired
	ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
	@Autowired
	ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	@Autowired
	ErpUserOpersService erpUserOpersService;
	@Autowired
	AdminFunDeptsMapper adminFunDeptsMapper;
	@Autowired
	ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	ErpSysParaService erpSysParaService;
	@Autowired
	ErpSysParaMapper erpSysParaMapper;
	@Autowired
	ErpUserOpersMapper erpUserOpersMapper;
	@Autowired
	ErpFunCustRegsectionsMapper erpFunCustRegsectionsMapper;
	@Autowired
	ErpFunRegsectionControlMapper erpFunRegsectionControlMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;

	/**
	 * 全公司出售匹配列表信息
	 * @author 张宏利
	 * @param message
	 * @throws Exception
	 * @since 2016年9月5日
	 */
	@ApiOperation("全公司出售匹配列表信息")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = MatchSalePushVo.class, message = "成功")
	})
	@AccessReadonlyDb
	@PostMapping(value = "/getMatchSalePush")
	public ResponseJson getMatchSalePush(@RequestBody MatchSalePushParam mapParam) {
		Integer saleId = mapParam.getSaleId();
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer selfUid = operator.getUserId();
		Integer selfGrId = operator.getGrId();
		Integer compType = operator.getCompType();
		String userPosition = operator.getUserPosition();
		String caseType = Constants_DIC.DIC_CASE_TYPE_SALE_FUN;
		String plateTypeStr = Constants_DIC.DIC_PLATE_TYPE_ALL_EN;
		// 获取权限范围和范围ID
		String operRange = erpUserOpersService.conditionMixByOperRange(plateTypeStr, caseType, cityId, compId, selfUid, selfGrId, compType, userPosition);
		String[] rangeAndId = getRangeAndId(operRange, operator);
		operRange = rangeAndId[0];
		int operRangeId = StringUtil.parseInteger(rangeAndId[1], 0);
		String[] columns = new String[]{
				"SECTION_NAME", "SALE_TOTAL_PRICE", "SALE_AREA", "SALE_FITMENT", "SALE_NO", 
				"SALE_REG", "SECTION_ID", "BUILD_ID", "SALE_USEAGE", "SALE_ROOM", "THUMB_URL",
				"SALE_ID", "BUILD_NAME", "SALE_ROUND", "SALE_ROOM", "SALE_HALL", "SALE_FLOOR",
				"SALE_FLOORS",
				};
		// 获取房源信息，用于匹配
		ErpFunSale erpFunSale = erpFunSaleMapper.selectColumnById(cityId, saleId, compId, columns);
		Assert.isNullThrow(erpFunSale, "未找到该出售信息");
		// 时间减一个月
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		erpFunSale.setTrackTime(calendar.getTime());
		erpFunSale.setSaleCooperate(false);
		erpFunSale.setYouShareFlag((byte) 0);
		if(operator.isPerLogin()) {
			erpFunSale.setUserId(operator.getUserId());
		}
		// 匹配对应求购数据
		List<ErpFunBuyCustomer> matchList = erpFunBuyCustomerMapper.getMatchHouseCustList(cityId, compId, 
				operRange, operRangeId, erpFunSale);
		erpFunSale.setThumbUrl(CommonUtil.getHousePhoto(erpFunSale.getThumbUrl()));
		// 组装返回数据
		return ErpResponseJson.ok(packagResult(erpFunSale, matchList));
	}
	
	/**
	 * 全公司出租匹配列表信息
	 * @author 张宏利
	 * @param message
	 * @throws Exception
	 * @since 2016年9月5日
	 */
	@ApiOperation("全公司出租匹配列表信息")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = MatchLeasePushVo.class, message = "成功")
	})
	@AccessReadonlyDb
	@PostMapping(value = "/getMatchLeasePush")
	public ResponseJson getMatchLeasePush(@RequestBody MatchLeasePushParam mapParam)  {
		Integer leaseId = mapParam.getLeaseId();
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer selfUid = operator.getUserId();
		Integer selfGrId = operator.getGrId();
		Integer compType = operator.getCompType();
		String userPosition = operator.getUserPosition();
		String caseType = Constants_DIC.DIC_CASE_TYPE_LEASE_FUN;
		String plateTypeStr = Constants_DIC.DIC_PLATE_TYPE_ALL_EN;
		// 获取权限范围和范围ID
		String operRange = erpUserOpersService.conditionMixByOperRange(plateTypeStr, caseType, cityId, compId, selfUid, selfGrId, compType, userPosition);
		String[] rangeAndId = getRangeAndId(operRange, operator);
		operRange = rangeAndId[0];
		int operRangeId = StringUtil.parseInteger(rangeAndId[1], 0);
		String[] columns = new String[]{
				"SECTION_NAME", "LEASE_TOTAL_PRICE", "LEASE_AREA", "LEASE_FITMENT", "LEASE_NO", 
				"LEASE_REG", "SECTION_ID", "BUILD_ID", "LEASE_USEAGE", "LEASE_ROOM", "THUMB_URL",
				"LEASE_ID", "BUILD_NAME", "PRICE_UNIT", "LEASE_ROUND", "LEASE_HALL",
				"LEASE_FLOOR", "LEASE_FLOORS",
		};
		// 获取房源信息，用于匹配
		ErpFunLease erpFunLease = erpFunLeaseMapper.selectColumnById(cityId, leaseId, compId, columns);
		Assert.isNullThrow(erpFunLease, "未找到该出租信息");
		// 时间减一个月
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		erpFunLease.setTrackTime(calendar.getTime());
		erpFunLease.setLeaseCooperate(false);
		erpFunLease.setYouShareFlag((byte) 0);
		if(operator.isPerLogin()) {
			erpFunLease.setUserId(operator.getUserId());
		}
		// 匹配对应求租数据
		List<ErpFunRentCustomer> matchList = erpFunRentCustomerMapper.getMatchHouseCustList(cityId, compId, 
				operRange, operRangeId, erpFunLease);
		erpFunLease.setThumbUrl(CommonUtil.getHousePhoto(erpFunLease.getThumbUrl()));
		// 组装返回数据
		return ErpResponseJson.ok(packagResult(erpFunLease, matchList));
	}
	
	/**
	 * 全公司求购匹配列表信息
	 * @author 张宏利
	 * @param message
	 * @throws Exception
	 * @since 2016年9月5日
	 */
	@ApiOperation("全公司求购匹配列表信息")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = MatchBuyCustPushVo.class, message = "成功")
	})
	@AccessReadonlyDb
	@PostMapping(value = "/getMatchBuyCustPush")
	public ResponseJson getMatchBuyCustPush(@RequestBody MatchBuyCustPushParam mapParam){
		Integer buyCustId = mapParam.getBuyCustId();
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer selfUid = operator.getUserId();
		Integer selfGrId = operator.getGrId();
		Integer compType = operator.getCompType();
		String userPosition = operator.getUserPosition();
		String caseType = Constants_DIC.DIC_CASE_TYPE_BUY_CUST;
		String plateTypeStr = Constants_DIC.DIC_PLATE_TYPE_ALL_EN;
		// 获取权限范围和范围ID
		String operRange = erpUserOpersService.conditionMixByOperRange(plateTypeStr, caseType, cityId, compId, selfUid, selfGrId, compType, userPosition);
		String[] rangeAndId = getRangeAndId(operRange, operator);
		operRange = rangeAndId[0];
		int operRangeId = StringUtil.parseInteger(rangeAndId[1], 0);
		String[] columns = new String[]{
				"HOUSE_REGION", "SECTION_ID", "BUILD_ID", "HOUSE_USEAGE", "HOUSE_FITMENT", 
				"HOUSE_DIRECT", "HOUSE_FLOOR_LOW", "HOUSE_FLOOR_HIGH", "HOUSE_ROOM","HOUSE_ROOM_1",
				"HOUSE_AREA_LOW", "HOUSE_AREA_HIGH", "HOUSE_PRICE_LOW", "HOUSE_PRICE_HIGH",
				"REGION_NAME", "SECTION_NAME", "BUILD_NAME", "BUY_CUST_NO", "BUY_CUST_ID","DEPT_ID",
				"SECTION_ID"
		};
		// 获取客源信息，用于匹配
		ErpFunBuyCustomer funBuyCustomer = erpFunBuyCustomerMapper.selectColumnById(cityId, buyCustId, compId, columns);
		Assert.isNullThrow(funBuyCustomer, "未找到该求购信息");
		// 时间减一个月
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		funBuyCustomer.setTrackTime(DateTimeHelper.formatDateTimetoString(calendar.getTime()));
		// 匹配对应求购数据
		String regIds = getIdsStr(funBuyCustomer.getHouseRegion(), " ");
		String sections = getIdsStr(funBuyCustomer.getSectionId(), " ");
		String buildIds = getIdsStr(funBuyCustomer.getBuildId(), " ");
		String useages = getIdsStr(funBuyCustomer.getHouseUseage(), " ");
		// 随便组装一个条件，不然一个条件都不满足在里面怕报错
		if(funBuyCustomer.getBuildId() == null) {
			funBuyCustomer.setBuildId("0");
		}
		funBuyCustomer.setYouShareFlag((byte) 0);
		funBuyCustomer.setCooperateFlag(0);
		if(operator.isPerLogin()) {
			funBuyCustomer.setUserId(operator.getUserId());
		}
		// 匹配对应求购数据
		List<ErpFunSale> matchList = erpFunSaleMapper.getMatchHouseCustList(cityId, compId,
				operRange, operRangeId, regIds, sections, buildIds, useages, funBuyCustomer);
		if(matchList == null || matchList.size() < 3) {
			funBuyCustomer.setUserId(null);
			boolean isYouJia = false;
			// 是否是优家门店 YOUJIA_DEPT_FLAG
			if(!operator.isPersonalVersion()) {
				ErpFunDepts dept = new ErpFunDepts();
				dept.setDeptId(funBuyCustomer.getDeptId());
				dept.setShardCityId(cityId);
				ErpFunDepts erpFunDepts = erpFunDeptsMapper.selectByPrimaryKey(dept);
				AdminFunDepts adminFunDepts = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(erpFunDepts.getCompNo(), erpFunDepts.getDeptNo());
				// 开启优家
				if(1 == adminFunDepts.getYoujiaDeptFlag()) {
					funBuyCustomer.setYouShareFlag((byte) 1);
					List<ErpFunSale> matchListTemp = erpFunSaleMapper.getMatchHouseCustList(cityId, null,
							operRange, operRangeId, regIds, sections, buildIds, useages, funBuyCustomer);
					matchList.addAll(matchListTemp);
					isYouJia = true;
				}
			}
			if(!isYouJia){
//				ErpSysPara erpSysPara = erpSysParaService.getErpSysPara(compId, cityId, "ALLOW_CITY_COOPERATE");

//				ErpSysParaKey paraKey = new ErpSysParaKey();
//				paraKey.setCompId(compId);
//				paraKey.setParamId("ALLOW_CITY_COOPERATE");
//				paraKey.setShardCityId(cityId);
//				ErpSysPara erpSysPara =  erpSysParaMapper.selectByPrimaryKey(paraKey);

				ErpSysPara erpSysPara = erpSysParaService.getMLSysParamByUserType(cityId, compId, selfUid, "ALLOW_CITY_COOPERATE");

				// 开启需求中心
				if(erpSysPara != null && "1".equals(erpSysPara.getParamValue())) {
					funBuyCustomer.setCooperateFlag(1);
					List<ErpFunSale> matchListTemp = erpFunSaleMapper.getMatchHouseCustList(cityId, null,
							operRange, operRangeId, regIds, sections, buildIds, useages, funBuyCustomer);
					matchList.addAll(matchListTemp);
				}
			}
		}
		for (ErpFunSale erpFunSale : matchList) {
			erpFunSale.setThumbUrl(CommonUtil.getHousePhoto(erpFunSale.getThumbUrl()));
		}
		// 组装返回数据
		return ErpResponseJson.ok(packagResult(funBuyCustomer, matchList));
	}
	
	/**
	 * 全公司求租匹配列表信息
	 * @author 张宏利
	 * @param message
	 * @throws Exception
	 * @since 2016年9月5日
	 */
	@ApiOperation("全公司求租匹配列表信息")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = MatchRentCustPushVo.class, message = "成功")
	})
	@AccessReadonlyDb
	@RequestMapping(value = "/getMatchRentCustPush")
	public ResponseJson getMatchRentCustPush(@RequestBody MatchRentCustPushParam mapParam) throws Exception {
		Integer rentCustId = mapParam.getRentCustId();
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer selfUid = operator.getUserId();
		Integer selfGrId = operator.getGrId();
		Integer compType = operator.getCompType();
		String userPosition = operator.getUserPosition();
		String caseType = Constants_DIC.DIC_CASE_TYPE_RENT_CUST;
		String plateTypeStr = Constants_DIC.DIC_PLATE_TYPE_ALL_EN;
		// 获取权限范围和范围ID
		String operRange = conditionMixByOperRange(plateTypeStr, caseType, cityId, compId, selfUid, selfGrId, compType, userPosition);


		String[] rangeAndId = getRangeAndId(operRange, operator);
		operRange = rangeAndId[0];
		int operRangeId = StringUtil.parseInteger(rangeAndId[1], 0);
		String[] columns = new String[]{
				"HOUSE_REGION", "SECTION_ID", "BUILD_ID", "HOUSE_USEAGE", "HOUSE_FITMENT", 
				"HOUSE_DIRECT", "HOUSE_FLOOR_LOW", "HOUSE_FLOOR_HIGH", "HOUSE_ROOM","HOUSE_ROOM_1",
				"HOUSE_AREA_LOW", "HOUSE_AREA_HIGH", "HOUSE_PRICE_LOW", "HOUSE_PRICE_HIGH",
				"REGION_NAME", "SECTION_NAME", "BUILD_NAME", "RENT_CUST_NO", "RENT_CUST_ID","DEPT_ID",
				"HOUSE_REGION"
		};
		// 获取客源信息，用于匹配
		ErpFunRentCustomer funRentCustomer = erpFunRentCustomerMapper.selectColumnById(cityId, rentCustId, compId, columns);
		Assert.isNullThrow(funRentCustomer, "未找到该求租信息");
		// 时间减一个月
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		funRentCustomer.setTrackTime(calendar.getTime());
		// 匹配对应求购数据
		String regIds = getIdsStr(funRentCustomer.getHouseRegion(), " ");
		String sections = getIdsStr(funRentCustomer.getSectionId(), " ");
		String buildIds = getIdsStr(funRentCustomer.getBuildId(), " ");
		String useages = getIdsStr(funRentCustomer.getHouseUseage(), " ");
		// 随便组装一个条件，不然一个条件都不满足在里面怕报错
		if(funRentCustomer.getBuildId() == null) {
			funRentCustomer.setBuildId("0");
		}
		funRentCustomer.setYouShareFlag((byte) 0);
		funRentCustomer.setCooperateFlag(0);
		if(operator.isPerLogin()) {
			funRentCustomer.setUserId(operator.getUserId());
		}
		// 匹配对应求购数据
		List<ErpFunLease> matchList = erpFunLeaseMapper.getMatchHouseCustList(cityId, compId,
				operRange, operRangeId, regIds, sections, buildIds, useages, funRentCustomer);
		if(matchList == null || matchList.size() < 3) {
			funRentCustomer.setUserId(null);
			boolean isYouJia = false;
			// 是否是优家门店 YOUJIA_DEPT_FLAG
			if(!operator.isPersonalVersion()) {
				ErpFunDepts dept = new ErpFunDepts();
				dept.setDeptId(funRentCustomer.getDeptId());
				dept.setShardCityId(cityId);
				ErpFunDepts erpFunDepts = erpFunDeptsMapper.selectByPrimaryKey(dept);
				AdminFunDepts adminFunDepts = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(erpFunDepts.getCompNo(), erpFunDepts.getDeptNo());
				// 开启优家
				if(1 == adminFunDepts.getYoujiaDeptFlag()) {
					funRentCustomer.setYouShareFlag((byte) 1);
					List<ErpFunLease> matchListTemp = erpFunLeaseMapper.getMatchHouseCustList(cityId, null,
							operRange, operRangeId, regIds, sections, buildIds, useages, funRentCustomer);
					matchList.addAll(matchListTemp);
					isYouJia = true;
				}
			}
			if(!isYouJia){
//				ErpSysParaKey paraKey = new ErpSysParaKey();
//				paraKey.setCompId(compId);
//				paraKey.setParamId("ALLOW_CITY_COOPERATE");
//				paraKey.setShardCityId(cityId);
//				ErpSysPara erpSysPara = erpSysParaMapper.selectByPrimaryKey(paraKey);

				ErpSysPara erpSysPara = erpSysParaService.getMLSysParamByUserType(cityId, compId, selfUid, "ALLOW_CITY_COOPERATE");

				// 开启需求中心
				if(erpSysPara != null && "1".equals(erpSysPara.getParamValue())) {
					funRentCustomer.setCooperateFlag(1);
					List<ErpFunLease> matchListTemp = erpFunLeaseMapper.getMatchHouseCustList(cityId, null,
							operRange, operRangeId, regIds, sections, buildIds, useages, funRentCustomer);
					matchList.addAll(matchListTemp);
				}
			}
		}
		for (ErpFunLease erpFunLease : matchList) {
			erpFunLease.setThumbUrl(CommonUtil.getHousePhoto(erpFunLease.getThumbUrl()));
		}
		// 组装返回数据
		return ErpResponseJson.ok(packagResult(funRentCustomer, matchList));
	}

	/**
	 * @tag 求租客源匹配房源
	 * @author 邓永洪
	 * @since 2018/7/4
	 * 
	 * 该方法2019-11-22由陈文超停用并移植到houseCustWeb
	 */
	@AccessReadonlyDb
	@RequestMapping(value = "/getMatchLeaseList")
	@Deprecated
	public ResponseJson getMatchLeaseList(@RequestBody BaseMapParam param) throws Exception {
		if(true){
	        //陈文超
            throw new BusinessException("方法已经移植到houseCustWeb，且pc和移动前端都已更换接口地址，请查看接口中的注释说明。2019-11-25");
        }
		this.matchParamProcess(param);
		String date = param.getString("date");
		Integer bound = param.getInteger("bound");
		Integer currentGrId = param.getInteger("currentGrId");
		String orderBy = param.getString("orderBy");
		Integer caseId = param.getInteger("caseId");
		Integer cityId = param.getInteger("cityId");
		Integer currentCompId = param.getInteger("currentCompId");
		String userPosition = param.getString("userPosition");
		String matchItem = param.getString("matchItem");
		Integer currentUserId = param.getInteger("currentUserId");
		Integer compType = param.getInteger("compType");

		String custTimeColumn = erpSysParaService.getHouseCustTimeColumn(cityId, getOperator().getCompId());
		param.setObject("custTimeColumn", custTimeColumn);
		if (StringUtil.isNotBlank(date)) {
			String[] conStr = DateConvert.getConditionDate(date);
			param.setString("creationTime1", conStr[0]);
			param.setString("creationTime2", conStr[1]);
		}
		ErpFunRentCustomer rentCustomer = erpFunRentCustomerMapper.getRentCustomerByCustId(cityId, caseId);
		if (rentCustomer == null) {
			throw new BusinessException("请求的客源未找到");
		}
		String buildId = rentCustomer.getBuildId();
		if (StringUtils.isNotBlank(buildId)) {
			param.setObject("buildId", Arrays.stream(buildId.split(" ")).map(val -> StringUtil.paseInteger(val)).collect(Collectors.toList()));
		}
		// 写字楼，厂房，仓库三个用途可以不需要地域限制。
		String usage = rentCustomer.getHouseUseage();
		String regionIds = param.getString("regionIds");
		List<Integer> regionIdList = null;
		// 前端文档是逗号分隔
		if (StringUtils.isNotBlank(regionIds)) {
			regionIdList = Arrays.stream(regionIds.split(",")).map(val -> StringUtil.paseInteger(val)).collect(Collectors.toList());
		} else {// 前端没传时默认全部
			// 数据库里面是空格分隔
			regionIds = rentCustomer.getHouseRegion();
			if (StringUtils.isNotBlank(regionIds)) {
				regionIdList = Arrays.stream(regionIds.split(" ")).map(val -> StringUtil.paseInteger(val)).collect(Collectors.toList());
			}
		}
		if (StringUtils.isNotBlank(regionIds) && (usage.indexOf(" " + Const.DIC_HOUSE_USEAGE_OFFICE + " ") > 0
				|| usage.indexOf(" " + Const.DIC_HOUSE_USEAGE_MANUFACT + " ") > 0
				|| usage.indexOf(" " + Const.DIC_HOUSE_USEAGE_STORE + " ") > 0)) {
			this.createCustSectionIdsByRegionIdsCondition(caseId, regionIdList, param, Const.DIC_CASE_TYPE_RENT_CUST);
		} else if (StringUtils.isNotBlank(regionIds)) {
			this.createCustSectionIdsByRegionIdsCondition(caseId, regionIdList, param, Const.DIC_CASE_TYPE_RENT_CUST);
			if (StringUtils.isNotBlank(usage)) {
				param.setObject("leaseUsage", Arrays.stream(usage.split(" ")).map(val -> StringUtil.parseByte(val)).collect(Collectors.toList()));
			}
		}
		// 这个不能为null
		if (StringUtils.isBlank(matchItem)) {
			matchItem = "";
		}
		if (matchItem.contains("AREA")) {
			param.setObject("houseAreaLow", rentCustomer.getHouseAreaLow());
			param.setObject("houseAreaHigh", rentCustomer.getHouseAreaHigh());
		}
		if (matchItem.contains("FLOOR")) {
			param.setObject("houseFloorLow", rentCustomer.getHouseFloorLow());
			param.setObject("houseFloorHigh", rentCustomer.getHouseFloorHigh());
		}
		if (matchItem.contains("PRICE")) {
			param.setObject("housePriceLow", rentCustomer.getHousePriceLow());
			param.setObject("housePriceHigh", rentCustomer.getHousePriceHigh());
		}
		if (matchItem.contains("ROOM")) {
			param.setObject("houseRoom", rentCustomer.getHouseRoom());
			param.setObject("houseRoom1", rentCustomer.getHouseRoom1());
		}
		String range = erpUserOpersService.conditionMixByOperRange(Constants_DIC.DIC_PLATE_TYPE_ALL_EN, Constants_DIC.DIC_CASE_TYPE_BUY_CUST, cityId, currentCompId, currentUserId, currentGrId, compType, userPosition);
		if ("GROUP".equals(range)) {
			range = "GR";
		}
		range = range + "_ID";
		String isRegSectionControllStr = erpSysParaMapper.getParamValue(cityId, currentCompId, "IS_REG_SECTION_CONTROLL");
		param.setObject("isRegSectionControllStr", isRegSectionControllStr);
		if ("1".equals(isRegSectionControllStr)) {
			String regSectionflag = this.buildHouseListQueryRegSection(param, Const.DIC_CASE_TYPE_LEASE_FUN,
					param.getInteger("areaId"), param.getInteger("regId"), param.getInteger("deptId"), param.getInteger("grId"), null, range);
			param.setObject("regSectionflag", regSectionflag);
		}
		if (StringUtils.isBlank(orderBy)) {
			param.setObject("orderBy", "TRACK_TIME DESC");
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows());
		List<ErpFunLeaseDto> funLeaseDtoList = erpFunLeaseMapper.getMatchLeaseList(cityId, param.getMap());

		if (bound == null || bound == 0 ||funLeaseDtoList.isEmpty()) {
			return ErpResponseJson.ok(funLeaseDtoList);
		}
		Set<Integer> userIds = new HashSet<>();
		if (funLeaseDtoList != null && funLeaseDtoList.size() > 0) {
			userIds = funLeaseDtoList.stream().map(ErpFunLease::getUserId).collect(Collectors.toSet());
		}
		List<ErpFunUsers> erpFunUsers = erpFunUsersMapper.getUserListByUserIds(cityId,userIds);
		Map<Integer, ErpFunUsers> funUsersMap = erpFunUsers.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, val -> val));
		funLeaseDtoList.forEach(lease -> {
			ErpFunUsers funUsers = funUsersMap.get(lease.getUserId());
			if (funUsers != null) {
				lease.setUserName(funUsers.getUserName());
				lease.setUserNo(funUsers.getUserNo());
			}
//			if (lease.getLeaseCooperate()!=null && lease.getLeaseCooperate()) {
				Integer floors = lease.getLeaseFloors();// 获取总楼层
				Integer floor = StringUtil.parseInteger(lease.getLeaseFloor());// 获取当前楼层
				String floorType = CommonUtil.getBuildFloorsType(floor, floors);
				lease.setFloorsType(floorType);
//			}
			// 合作房源返回FLOORS_TYPE
		});
		return ErpResponseJson.ok(funLeaseDtoList);
	}

	/**
	 * 2019-11-22停用并移植到houseCustWeb
	 * @author 陈文超
	 * @date 2019年11月22日 下午4:33:13
	 */
	@AccessReadonlyDb
	@RequestMapping(value = "/getMatchSaleList")
	@Deprecated
	public ResponseJson getMatchSaleList(@RequestBody BaseMapParam param) throws Exception {
		if(true){
	        //陈文超
            throw new BusinessException("方法已经移植到houseCustWeb，且pc和移动前端都已更换接口地址，请查看接口中的注释说明。2019-11-25");
        }
		this.matchParamProcess(param);
		String date = param.getString("date");
		Integer bound = param.getInteger("bound");
		Integer currentGrId = param.getInteger("currentGrId");
		String orderBy = param.getString("orderBy");
		Integer caseId = param.getInteger("caseId");
		Integer cityId = param.getInteger("cityId");
		Integer currentCompId = param.getInteger("currentCompId");
		String userPosition = param.getString("userPosition");
		String matchItem = param.getString("matchItem");
		Integer currentUserId = param.getInteger("currentUserId");
		Integer compType = param.getInteger("compType");

		String custTimeColumn = erpSysParaService.getHouseCustTimeColumn(cityId, getOperator().getCompId());
		param.setObject("custTimeColumn", custTimeColumn);
		if (StringUtil.isNotBlank(date)) {
			String[] conStr = DateConvert.getConditionDate(date);
			param.setString("creationTime1", conStr[0]);
			param.setString("creationTime2", conStr[1]);
		}
		ErpFunBuyCustomer buyCustomer = erpFunBuyCustomerMapper.getFunBuyCustomer(cityId, caseId);
		if (buyCustomer == null) {
			throw new BusinessException("请求的客源未找到");
		}
		String buildId = buyCustomer.getBuildId();
		if (StringUtils.isNotBlank(buildId)) {
			param.setObject("buildId", Arrays.stream(buildId.split(" ")).map(val -> StringUtil.paseInteger(val)).collect(Collectors.toList()));
		}
		// 写字楼，厂房，仓库三个用途可以不需要地域限制。
		String usage = buyCustomer.getHouseUseage();
		String regionIds = param.getString("regionIds");
		List<Integer> regionIdList = null;
		// 前端文档是逗号分隔
		if (StringUtils.isNotBlank(regionIds)) {
			regionIdList = Arrays.stream(regionIds.split(",")).map(val -> StringUtil.paseInteger(val)).collect(Collectors.toList());
		} else {// 前端没传时默认全部
			// 数据库里面是空格分隔
			regionIds = buyCustomer.getHouseRegion();
			if (StringUtils.isNotBlank(regionIds)) {
				regionIdList = Arrays.stream(regionIds.split(" ")).map(val -> StringUtil.paseInteger(val)).collect(Collectors.toList());
			}
		}
		if (StringUtils.isNotBlank(regionIds) && (usage.indexOf(" " + Const.DIC_HOUSE_USEAGE_OFFICE + " ") > 0
				|| usage.indexOf(" " + Const.DIC_HOUSE_USEAGE_MANUFACT + " ") > 0
				|| usage.indexOf(" " + Const.DIC_HOUSE_USEAGE_STORE + " ") > 0)) {
			this.createCustSectionIdsByRegionIdsCondition(caseId, regionIdList, param, Const.DIC_CASE_TYPE_BUY_CUST);
		} else if (StringUtils.isNotBlank(regionIds)) {
			this.createCustSectionIdsByRegionIdsCondition(caseId, regionIdList, param, Const.DIC_CASE_TYPE_BUY_CUST);
			if (StringUtils.isNotBlank(usage)) {
				param.setObject("saleUsage", Arrays.stream(usage.split(" ")).map(val -> StringUtil.parseByte(val)).collect(Collectors.toList()));
			}
		}
		// 这个不能为null
		if (StringUtils.isBlank(matchItem)) {
			matchItem = "";
		}
		if (matchItem.contains("AREA")) {
			param.setObject("houseAreaLow", buyCustomer.getHouseAreaLow());
			param.setObject("houseAreaHigh", buyCustomer.getHouseAreaHigh());
		}
		if (matchItem.contains("FLOOR")) {
			param.setObject("houseFloorLow", buyCustomer.getHouseFloorLow());
			param.setObject("houseFloorHigh", buyCustomer.getHouseFloorHigh());
		}
		if (matchItem.contains("PRICE")) {
			param.setObject("housePriceLow", buyCustomer.getHousePriceLow());
			param.setObject("housePriceHigh", buyCustomer.getHousePriceHigh());
		}
		if (matchItem.contains("ROOM")) {
			param.setObject("houseRoom", buyCustomer.getHouseRoom());
			param.setObject("houseRoom1", buyCustomer.getHouseRoom1());
		}

		String range = erpUserOpersService.conditionMixByOperRange(Constants_DIC.DIC_PLATE_TYPE_ALL_EN, Constants_DIC.DIC_CASE_TYPE_SALE_FUN, cityId, currentCompId, currentUserId, currentGrId, compType, userPosition);
		if ("GROUP".equals(range)) {
			range = "GR";
		}
		range = range + "_ID";
		String isRegSectionControllStr = erpSysParaMapper.getParamValue(cityId, currentCompId, "IS_REG_SECTION_CONTROLL");
		param.setObject("isRegSectionControllStr", isRegSectionControllStr);
		if ("1".equals(isRegSectionControllStr)) {
			String regSectionflag = this.buildHouseListQueryRegSection(param, Const.DIC_CASE_TYPE_SALE_FUN,
					param.getInteger("areaId"), param.getInteger("regId"), param.getInteger("deptId"), param.getInteger("grId"), null, range);
			param.setObject("regSectionflag", regSectionflag);
		}
		if (StringUtils.isBlank(orderBy)) {
			param.setObject("orderBy", "TRACK_TIME DESC");
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows());
		List<ErpFunSaleDto> funSaleDtoList = erpFunSaleMapper.getMatchSaleList(cityId, param.getMap());
		if (bound == null || bound == 0|| funSaleDtoList.isEmpty()) {
			return ErpResponseJson.ok(funSaleDtoList);
		}
		Set<Integer> userIds = new HashSet<>();
		if (funSaleDtoList != null && funSaleDtoList.size() > 0) {
			userIds = funSaleDtoList.stream().map(ErpFunSale::getUserId).collect(Collectors.toSet());
		}
		List<ErpFunUsers> erpFunUsers = erpFunUsersMapper.getUserListByUserIds(cityId, userIds);
		Map<Integer, ErpFunUsers> funUsersMap = erpFunUsers.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, val -> val));
		funSaleDtoList.forEach(sale -> {
			ErpFunUsers funUsers = funUsersMap.get(sale.getUserId());
			if (funUsers != null) {
				sale.setUserName(funUsers.getUserName());
				sale.setUserNo(funUsers.getUserNo());
			}
//			if (sale.getSaleCooperate()!=null && sale.getSaleCooperate()) {
				Integer floors = sale.getSaleFloors();// 获取总楼层
				Integer floor = StringUtil.parseInteger(sale.getSaleFloor());// 获取当前楼层
				String floorType = CommonUtil.getBuildFloorsType(floor, floors);
				sale.setFloorsType(floorType);
//			}
			// 合作房源返回FLOORS_TYPE

		});
		return ErpResponseJson.ok(funSaleDtoList);
	}

	private void matchParamProcess(BaseMapParam param){
		param.setInteger("cityId", getOperator().getCityId());
		param.setInteger("currentUserId", getOperator().getUserId());
		param.setInteger("currentGrId", getOperator().getGrId());
		param.setInteger("currentDeptId", getOperator().getDeptId());
		param.setInteger("currentRegId", getOperator().getRegId());
		param.setInteger("currentAreaId", getOperator().getAreaId());
		param.setInteger("currentCompId", getOperator().getCompId());
		param.setInteger("compType", getOperator().getCompType());
		param.setString("userPosition", getOperator().getUserPosition());
		param.setObject("isPerLogin", getOperator().isPerLogin());
		if (null != getOperator().getAttribute("compIds")) {
			String[] compIds = ((String) getOperator().getAttribute("compIds")).split(",");
			param.setObject("compIds", compIds);
		}
	}
	private String buildHouseListQueryRegSection(BaseMapParam param, Integer caseType, Integer areaId, Integer regId,
												 Integer deptId, Integer grId, Integer userId, String range) {
		String result = "0";
		String queryRange = "COMP_ID";
		Integer queryRangeId = getOperator().getCompId();
		if (grId != null) {// 加盟和非加盟类型通用
			queryRange = "GR_ID";
			queryRangeId = grId;
		} else if (deptId != null) {
			queryRange = "DEPT_ID";
			queryRangeId = deptId;
		} else if (regId != null) {
			queryRange = "REG_ID";
			queryRangeId = regId;
		} else if (areaId != null) {
			queryRange = "AREA_ID";
			queryRangeId = areaId;
		}
		if (userId != null && !userId.equals("PUBLIC") && !userId.equals("SHARE")) {
			queryRange = "USER_ID";
			queryRangeId = userId;
		}
		Integer queryLevel = Const.RANGE_LEVEL.get(queryRange);
		Integer operQueryLevel = Const.RANGE_LEVEL.get(range);
		if ("COMP_ID".equals(queryRange)) {
			if ("COMP_ID".equals(range)) {
				return "0";
			}
		} else {
			param.setObject("queryRange", queryRange);
			param.setObject("queryRangeId", queryRangeId);
			boolean flag = isOperatorFlag(operQueryLevel, queryLevel, range, queryRange, queryRangeId);
			if (!flag) {
				result = "2";
			} else {
				if (queryLevel > operQueryLevel) {

				} else {
					return "0";
				}
			}
		}
		String regFieldName = "LEASE_REG";
		String sectionFieldName = "SECTION_ID";
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			regFieldName = "SALE_REG";
		}
		List<Map<String, String>> mapList = erpFunRegsectionControlMapper.getRegsectionControl(getOperator().getCityId(), getOperator().getCompId(), getOperator().getDeptId());
		if (mapList != null && !mapList.isEmpty()) {
			param.setObject("compId", getOperator().getCompId());
			//String[] regionArr = BeanUtil.buildQueryKeysOffDataObject(dataList, "REGION_ID");
			List<String> regionIds = mapList.stream().map(val -> val.get("REGION_ID")).collect(Collectors.toList());
			Map<String, Boolean> regFlagMap = new HashMap<>();
			for (String regionId : regionIds) {
				regFlagMap.put(regionId, true);
			}
			List<String> orList2 = new ArrayList<>();
			for (Map<String, String> map : mapList) {
				String regSectionInfo = map.get("REG_SECTION");
				if (StringUtils.isNotBlank(regSectionInfo)) {
					String[] regSectionArr = regSectionInfo.split("_");
					String inStr = "";
					String str1 = "";
					String str2 = "";
					if (regFlagMap.get(regSectionArr[0])) {
						regFlagMap.put(regSectionArr[0], false);
						str1 += "(" + regFieldName + " =" + regSectionArr[0];
					}
					if (regSectionArr.length == 2) {
						if (StringUtils.isBlank(str1)) {
							str2 += "(";
						} else {
							str2 += " and ";
						}
						str2 += sectionFieldName + "=" + regSectionArr[1] + ")";
					}
					if (StringUtils.isNotBlank(str1) && StringUtils.isBlank(str2)) {
						str1 += ")";
					}
					inStr = str1 + str2;
					if (StringUtils.isNotBlank(inStr)) {
						orList2.add(inStr);
					}
				}
			}
			param.setObject("orList2", orList2);
		}
		return result;
	}

	private boolean isOperatorFlag(Integer operLevel, Integer queryLevel, String operRange, String queryRange, Integer queryRangeId) {
		if (!"COMP_ID".equals(operRange)) {
			Integer deptId = null;
			if ("GR_ID".equals(operRange)) {
				deptId = getOperator().getDeptId();
			}
			Map obj = erpFunRegsectionControlMapper.getUsersByOperRange(getOperator().getCityId(), queryRange, operRange, getOperator()
					.getCompId(), queryRangeId, getOperator().getAttribute(operRange.toString()), deptId);
			if (obj == null) {
				return false;
			}
		}
		return true;
	}

	private void createCustSectionIdsByRegionIdsCondition(Integer caseId, List<Integer> regionIdList, BaseMapParam param, Integer caseType) {
		if (null == regionIdList || regionIdList.isEmpty()) {
			return;
		}
		//行政区字段名板块字段名
		String regFieldName = "LEASE_REG";
		String sectionFieldName = "SECTION_ID";
		if (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
			regFieldName = "SALE_REG";
		}
		Map<String, Boolean> regFlagMap = new HashMap<>();
		for (Integer regId : regionIdList) {
			regFlagMap.put(regId.toString(), true);
		}
		List<Map<String, String>> custSectionIds = erpFunCustRegsectionsMapper.selectCustSectionIdsByRegionIds(getOperator().getCityId(),
				getOperator().getCompId(), 4, caseId, regionIdList);
		if (custSectionIds != null && !custSectionIds.isEmpty()) {
			List<String> orList = new ArrayList<>();
			for (Map<String, String> dataObject : custSectionIds) {
				String regSectionInfo = dataObject.get("REG_SECTION");
				if (StringUtils.isNotBlank(regSectionInfo)) {
					String[] regSectionArr = regSectionInfo.split("_");
					String inStr = "";
					String str1 = "";
					String str2 = "";
					if (regFlagMap.get(regSectionArr[0])) {
						regFlagMap.put(regSectionArr[0], false);
						str1 += "(" + regFieldName + " =" + regSectionArr[0];
					}
					if (regSectionArr.length == 2) {
						if (StringUtils.isBlank(str1)) {
							str2 += "(";
						} else {
							str2 += " and ";
						}
						str2 += sectionFieldName + "=" + regSectionArr[1] + ")";
					}
					if (StringUtils.isNotBlank(str1) && StringUtils.isBlank(str2)) {
						str1 += ")";
					}
					inStr = str1 + str2;
					if (StringUtils.isNotBlank(inStr)) {
						orList.add(inStr);
					}
				}
			}
			param.setObject("orList", orList);
		}
	}

	public String conditionMixByOperRange(String plateTypeStr, String caseType, Integer cityId, Integer compId, Integer selfUid, Integer selfGrId, Integer compType, String userPosition) throws Exception{
		boolean limitRange = false;
		if(Constants_DIC.DIC_PLATE_TYPE_PUBLIC_EN.equals(plateTypeStr) || Constants_DIC.DIC_PLATE_TYPE_SHARE_EN.equals(plateTypeStr)){
			if(Constants_DIC.DIC_PLATE_TYPE_PUBLIC_EN.equals(plateTypeStr)) { // 抢盘 public
				if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType) || Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) { // 房源
					limitRange = Constants_DIC.DIC_SHARE_PUBLIC_RANGE_1.equals(erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, selfUid,  "PUBLIC_HOUSE_RANGE"));
				}else if(Constants_DIC.DIC_CASE_TYPE_BUY_CUST.equals(caseType) || Constants_DIC.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
					limitRange = Constants_DIC.DIC_SHARE_PUBLIC_RANGE_1.equals(erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, selfUid, "PUBLIC_CUST_RANGE"));
				}
			}else { // 公盘
				// 如果有查看公盘数据权，则不需要判断系统参数

				if(null != erpUserOpersMapper.selectPerPermissionByName(cityId, selfUid, "VIEW_SHARE_HOUSE_CUST")) {
					limitRange = true;
				} else {
					if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType) || Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) { // 房源
						limitRange = Constants_DIC.DIC_SHARE_PUBLIC_RANGE_1.equals(erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, selfUid, "SHARE_HOUSE_RANGE"));
					}else if(Constants_DIC.DIC_CASE_TYPE_BUY_CUST.equals(caseType) || Constants_DIC.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
						limitRange = Constants_DIC.DIC_SHARE_PUBLIC_RANGE_1.equals(erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, selfUid,  "SHARE_CUST_RANGE"));
					}
				}
			}
		}else{
			if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType) || Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)){
				limitRange = Constants_DIC.DIC_SHARE_PUBLIC_RANGE_1.equals(erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId,selfUid, "LOOK_HOUSE_RANGE"));
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

	public String conditionMixByOperRangeSub(String infoPlateType, String caseType, Integer cityId, Integer compId, Integer selfUid, Integer selfGrId, Integer compType, String userPosition) throws Exception{
		boolean crossUserQuery = false;//查阅本组他人数据权
		boolean crossGroupQuery = false;//查阅本店跨分组数据权
		boolean crossDeptQuery = false;//查阅本片区跨门店数据权
		boolean crossRegQuery = false;//查阅本大区跨大区数据权
		boolean crossAreaQuery = false;//查阅全公司跨大区数据权
		if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType) ||Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)){
			crossAreaQuery = null != erpUserOpersMapper.selectPerPermissionByName(cityId, selfUid, "VIEW_COMP_HOUSE_LIST_INFO");// 查阅全公司跨大区数据权
			if(!crossAreaQuery) {
				crossRegQuery = null != erpUserOpersMapper.selectPerPermissionByName(cityId, selfUid, "VIEW_AREA_HOUSE_LIST_INFO");// 查阅本大区跨片区数据权
				if(!crossRegQuery) {
					crossDeptQuery = null != erpUserOpersMapper.selectPerPermissionByName(cityId, selfUid, "VIEW_REG_HOUSE_LIST_INFO");// 查阅本片区跨门店数据权
					if(!crossDeptQuery) {
						crossGroupQuery = null != erpUserOpersMapper.selectPerPermissionByName(cityId, selfUid, "VIEW_DEPT_HOUSE_LIST_INFO");// 查阅本店跨分组数据权
						if(!crossGroupQuery) {
							crossUserQuery = null != erpUserOpersMapper.selectPerPermissionByName(cityId, selfUid, "VIEW_GROUP_HOUSE_LIST_INFO");//查阅本组他人数据权
						}
					}
				}
			}
		}else if(Constants_DIC.DIC_CASE_TYPE_BUY_CUST.equals(caseType) ||Constants_DIC.DIC_CASE_TYPE_RENT_CUST.equals(caseType)){
			// 如果没有权限才往下走
			crossAreaQuery = null != erpUserOpersMapper.selectPerPermissionByName(cityId, selfUid, "VIEW_COMP_CUST_LIST_INFO");// 查阅全公司跨大区数据权
			if(!crossAreaQuery) {
				crossRegQuery = null != erpUserOpersMapper.selectPerPermissionByName(cityId, selfUid, "VIEW_AREA_CUST_LIST_INFO");// 查阅本大区跨片区数据权
				if(!crossRegQuery) {
					crossDeptQuery = null != erpUserOpersMapper.selectPerPermissionByName(cityId, selfUid, "VIEW_REG_CUST_LIST_INFO");// 查阅本片区跨门店数据权
					if(!crossDeptQuery) {
						crossGroupQuery = null != erpUserOpersMapper.selectPerPermissionByName(cityId, selfUid, "VIEW_DEPT_CUST_LIST_INFO");// 查阅本店跨分组数据权
						if(!crossGroupQuery) {
							crossUserQuery = null != erpUserOpersMapper.selectPerPermissionByName(cityId, selfUid, "VIEW_GROUP_CUST_LIST_INFO");//查阅本组他人数据权
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
	
	/**
	 * 组装返回数据
	 * @author 张宏利
	 * @since 2017年2月25日
	 * @param matchInfo
	 * @param matchList
	 * @return
	 */
	private List<Map<String, Object>> packagResult(Object matchInfo, Object matchList) {
		List<Map<String, Object>> dataList = new LinkedList<>();
		Map<String, Object> infoMap = new HashMap<>();
		infoMap.put("matchInfo", matchInfo);
		dataList.add(infoMap);
		Map<String, Object> matchMap = new HashMap<>();
		matchMap.put("matchList", matchList);
		dataList.add(matchMap);
		return dataList;
	}
	
	private String getIdsStr(String source, String split) {
		if(source == null || split == null) {
			return null;
		}
		String[] arr = source.split(split);
		StringBuilder resultStr = new StringBuilder();
		for (String string : arr) {
			if(StringUtils.isEmpty(string)) {
				continue;
			}
			if(resultStr.length() > 0) {
				resultStr.append(",");
			}
			resultStr.append(string);
		}
		if(resultStr.length() == 0) {
			return null;
		}
		return resultStr.toString();
	}
	
	/**
	 * 获取真实维度和维度ID
	 * @author 张宏利
	 * @since 2017年2月25日
	 * @param operRange
	 * @param erpFunUsers
	 * @return
	 */
	private String[] getRangeAndId(String operRange, Operator operator) {
		Integer operRangeId = null;
		if("COMP".equals(operRange)) {
			operRange = "COMP_ID";
			operRangeId = operator.getCompId();
		} else if("AREA".equals(operRange)) {
			operRange = "AREA_ID";
			operRangeId = operator.getAreaId();
		} else if("REG".equals(operRange)) {
			operRange = "REG_ID";
			operRangeId = operator.getRegId();
		} else if("DEPT".equals(operRange)) {
			operRange = "DEPT_ID";
			operRangeId = operator.getDeptId();
		} else if("GROUP".equals(operRange)) {
			operRange = "GR_ID";
			operRangeId = operator.getGrId();
		} else if("USER".equals(operRange)) {
			operRange = "USER_ID";
			operRangeId = operator.getUserId();
		} else {
			return null;
		}
		return new String[]{operRange, String.valueOf(operRangeId)};
	}
}



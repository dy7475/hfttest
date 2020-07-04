package com.myfun.erpWeb.app;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.myfun.erpWeb.app.param.AppAchieveMonthStatisticsRankDetailParam;
import com.myfun.erpWeb.app.param.AppAchieveStatisticsCountTotalParam;
import com.myfun.erpWeb.app.vo.*;
import com.myfun.erpWeb.managecenter.userOpers.vo.ErpOrganizationVO;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.PartnerConfigDto;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.reportdb.dao.ReportFunStatisticDetail1Mapper;
import com.myfun.repository.reportdb.dao.ReportFunStatisticTotleMapper;
import com.myfun.repository.reportdb.po.ReportFunStatisticDetail1;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.erpdb.ErpFunOrganizationService;
import com.myfun.service.business.erpdb.ErpFunPartnerConfigService;
import com.myfun.service.business.erpdb.ErpSysParaService;
import com.myfun.utils.Assert;
import com.myfun.utils.DateConvert;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.apache.zookeeper.Op;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 掌通相关接口
 * @author 朱科
 * @since 2018年10月22日
 * @return
 */
@Api(tags = "掌通接口")
@Controller
@RequestMapping("/appOperateCenter")
public class AppOperateCenterController extends BaseController {
	
	@Autowired private ReportFunStatisticTotleMapper reportFunStatisticTotleMapper;
	@Autowired private ReportFunStatisticDetail1Mapper reportFunStatisticDetail1Mapper;
	@Autowired private ErpUserOpersMapper erpUserOpersMapper;
	@Autowired private ErpSysParaMapper erpSysParaMapper;
	@Autowired private ErpFunSaleMapper erpFunSaleMapper;
	@Autowired private ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired private ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
	@Autowired private ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	@Autowired private ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired private ErpFunTrackMapper erpFunTrackMapper;
	@Autowired private ErpFunKeyMapper erpFunKeyMapper;
	@Autowired private ErpFunTrackExtendMapper erpFunTrackExtendMapper;
	@Autowired private ErpMakeLookHouseMapper erpMakeLookHouseMapper;
	@Autowired private ErpFunPartnerConfigService erpFunPartnerConfigService;
	@Autowired private ErpFunOrganizationMapper erpFunOrganizationMapper;
	@Autowired private ErpFunOrganizationDefinitionMapper erpFunOrganizationDefinitionMapper;
	@Autowired private ErpFunOrganizationService erpFunOrganizationService;
	@Autowired private ErpSysParaService erpSysParaService;
	/**
	 * 掌通运营分析排行榜房增、客增、带看、钥匙、房勘总量
	 * @author 朱科
	 * @since 2018年10月22日
	 * @return
	 */
	@ApiOperation("掌通排行榜点击进入详情,需求=8769，作者：朱科")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = AppAchieveStatisticsCountTotalVo.class, message = "成功")
	})
	@ResponseBody
	@PostMapping("/getStatisticsRankCountTotal")
	public ErpResponseJson getStatisticsRankCountTotal(@RequestBody AppAchieveStatisticsCountTotalParam param){
		Operator operator = getOperator();
		//==================新盘组织架构----------------------------
		if (operator.newOrganizationType()) {
			return getStatisticsRankCountTotalForOrg(param);
		}
		Integer compId = operator.getCompId();
		Integer cityId = operator.getCityId();
		Integer selfDeptId = operator.getDeptId();
		Integer deptId = param.getDeptId();
		Integer lookType = param.getLookType();
		Integer lookTypeId = param.getLookTypeId();
		String assessmentMonth = param.getAssessmentMonth();
		List<String> workColumns = new ArrayList<>();
		workColumns.add("ISNULL((SUM(iif(case_type = 1, DJ_COUNT, 0))),0) saleAddTotal"); // 出售新增
		workColumns.add("ISNULL((SUM(iif(case_type = 2, DJ_COUNT, 0))),0) leaseAddTotal"); // 出租新增
		workColumns.add("ISNULL((SUM(iif(case_type = 3, DJ_COUNT, 0))),0) buyAddTotal"); // 求购新增
		workColumns.add("ISNULL((SUM(iif(case_type = 4, DJ_COUNT, 0))),0) rentAddTotal"); // 求租新增
		workColumns.add("ISNULL((SUM(iif(case_type = 3, FDK_COUNT, 0))),0) buyDkTotal"); // 求购带看
		workColumns.add("ISNULL((SUM(iif(case_type = 4, FDK_COUNT, 0))),0) rentDkTotal"); // 求租带看
		workColumns.add("ISNULL((SUM(iif(case_type = 1, YSTJ_COUNT, 0))),0) saleYsTotal"); // 出售钥匙提交
		workColumns.add("ISNULL((SUM(iif(case_type = 2, YSTJ_COUNT, 0))),0) leaseYsTotal"); // 出租钥匙提交
		workColumns.add("ISNULL((SUM(iif(case_type = 1, FK_COUNT, 0))),0) saleFunCanTotal"); // 出售房勘
		workColumns.add("ISNULL((SUM(iif(case_type = 2, FK_COUNT, 0))),0) leaseFunCanTotal"); // 出租房勘
		workColumns.add("ISNULL((SUM(iif(case_type = 3, KYYK_COUNT, 0))),0) buyKyykTotal"); // 求购约看
		workColumns.add("ISNULL((SUM(iif(case_type = 4, KYYK_COUNT, 0))),0) rentKyykTotal"); // 求组约看
		String endTime = "";
		if(StringUtil.isNotBlank(assessmentMonth)){
			String year = assessmentMonth.substring(0,4); // year
			String month = assessmentMonth.substring(5, 7); // month
			endTime = DateConvert.getLastDayOfMonth(StringUtil.parseInteger(year, 2019), StringUtil.parseInteger(month, 1)) + "23:59:59";
		} else {
			String startTime = param.getStartTime();
			if(StringUtil.isNotBlank(startTime)){
				assessmentMonth = startTime;
			}
			if(StringUtil.isNotBlank(param.getEndTime())){
				endTime = param.getEndTime() + " 23:59:59";
			}
		}
		// 判断是否开启了加盟模式和查询工作量是否独立的开关（和系统管理-薪资管理共用参数） FUN_PARTNER_CONFIG  WAGE_APART
		Integer partnerIdRange = 0; // 0表示查询所有数据；-1表示查询PARTNER_ID的范围是0和-1；大于0，则表示查询范围是该字段实际的值
		boolean separationConfig = false;
		if (Objects.equals(operator.openPartner(), 1)) { // 开启了加盟模式
			PartnerConfigDto partnerConfigDto = erpFunPartnerConfigService.getPartnerConfiguration(cityId, compId);
			if (null != partnerConfigDto && Objects.equals(partnerConfigDto.getWageApart(), (byte)1)) { // 系统管理-薪资管理自行配置（绩效奖罚、提成配置 0=否 1=是
				partnerIdRange = operator.getPartnerId();
				separationConfig = true;
			}
		}
		Map<String, Integer> totalCount = reportFunStatisticTotleMapper.getStatisticsRankCountTotal(cityId, compId, lookType, lookTypeId, workColumns, assessmentMonth, endTime,
				deptId, selfDeptId,separationConfig,partnerIdRange);
		AppAchieveStatisticsCountTotalVo appAchieveStatisticsCountTotalVo = JSON.parseObject(JSON.toJSONString(totalCount), AppAchieveStatisticsCountTotalVo.class);
		appAchieveStatisticsCountTotalVo.setHouseAddTotal(appAchieveStatisticsCountTotalVo.getSaleAddTotal() + appAchieveStatisticsCountTotalVo.getLeaseAddTotal());
		appAchieveStatisticsCountTotalVo.setCustomerAddTotal(appAchieveStatisticsCountTotalVo.getBuyAddTotal() + appAchieveStatisticsCountTotalVo.getRentAddTotal());
		appAchieveStatisticsCountTotalVo.setDaiKanTotal(appAchieveStatisticsCountTotalVo.getBuyDkTotal() + appAchieveStatisticsCountTotalVo.getRentDkTotal());
		appAchieveStatisticsCountTotalVo.setYaoShiTotal(appAchieveStatisticsCountTotalVo.getSaleYsTotal() + appAchieveStatisticsCountTotalVo.getLeaseYsTotal());
		appAchieveStatisticsCountTotalVo.setFunCanTotal(appAchieveStatisticsCountTotalVo.getSaleFunCanTotal() + appAchieveStatisticsCountTotalVo.getLeaseFunCanTotal());
		return ErpResponseJson.ok(appAchieveStatisticsCountTotalVo);
	}

	public ErpResponseJson getStatisticsRankCountTotalForOrg(@RequestBody AppAchieveStatisticsCountTotalParam param){
		Operator operator = getOperator();
		Integer compId = operator.getCompId();
		Integer cityId = operator.getCityId();
		Integer selfDeptId = operator.getDeptId();
		Integer deptId = param.getDeptId();
		Integer lookType = param.getLookType();
		Integer lookTypeId = param.getLookTypeId();
		String assessmentMonth = param.getAssessmentMonth();
		List<String> workColumns = new ArrayList<>();
		workColumns.add("ISNULL((SUM(iif(case_type = 1, DJ_COUNT, 0))),0) saleAddTotal"); // 出售新增
		workColumns.add("ISNULL((SUM(iif(case_type = 2, DJ_COUNT, 0))),0) leaseAddTotal"); // 出租新增
		workColumns.add("ISNULL((SUM(iif(case_type = 3, DJ_COUNT, 0))),0) buyAddTotal"); // 求购新增
		workColumns.add("ISNULL((SUM(iif(case_type = 4, DJ_COUNT, 0))),0) rentAddTotal"); // 求租新增
		workColumns.add("ISNULL((SUM(iif(case_type = 3, FDK_COUNT, 0))),0) buyDkTotal"); // 求购带看
		workColumns.add("ISNULL((SUM(iif(case_type = 4, FDK_COUNT, 0))),0) rentDkTotal"); // 求租带看
		workColumns.add("ISNULL((SUM(iif(case_type = 1, YSTJ_COUNT, 0))),0) saleYsTotal"); // 出售钥匙提交
		workColumns.add("ISNULL((SUM(iif(case_type = 2, YSTJ_COUNT, 0))),0) leaseYsTotal"); // 出租钥匙提交
		workColumns.add("ISNULL((SUM(iif(case_type = 1, FK_COUNT, 0))),0) saleFunCanTotal"); // 出售房勘
		workColumns.add("ISNULL((SUM(iif(case_type = 2, FK_COUNT, 0))),0) leaseFunCanTotal"); // 出租房勘
		workColumns.add("ISNULL((SUM(iif(case_type = 3, KYYK_COUNT, 0))),0) buyKyykTotal"); // 求购约看
		workColumns.add("ISNULL((SUM(iif(case_type = 4, KYYK_COUNT, 0))),0) rentKyykTotal"); // 求组约看
		String endTime = "";
		if(StringUtil.isNotBlank(assessmentMonth)){
			String year = assessmentMonth.substring(0,4); // year
			String month = assessmentMonth.substring(5, 7); // month
			endTime = DateConvert.getLastDayOfMonth(StringUtil.parseInteger(year, 2019), StringUtil.parseInteger(month, 1)) + "23:59:59";
		} else {
			String startTime = param.getStartTime();
			if(StringUtil.isNotBlank(startTime)){
				assessmentMonth = startTime;
			}
			if(StringUtil.isNotBlank(param.getEndTime())){
				endTime = param.getEndTime() + " 23:59:59";
			}
		}
		// 判断是否开启了加盟模式和查询工作量是否独立的开关（和系统管理-薪资管理共用参数） FUN_PARTNER_CONFIG  WAGE_APART
		Integer partnerIdRange = 0; // 0表示查询所有数据；-1表示查询PARTNER_ID的范围是0和-1；大于0，则表示查询范围是该字段实际的值
		boolean separationConfig = false;
		if (Objects.equals(operator.openPartner(), 1)) { // 开启了加盟模式
			PartnerConfigDto partnerConfigDto = erpFunPartnerConfigService.getPartnerConfiguration(cityId, compId);
			if (null != partnerConfigDto && Objects.equals(partnerConfigDto.getWageApart(), (byte)1)) { // 系统管理-薪资管理自行配置（绩效奖罚、提成配置 0=否 1=是
				partnerIdRange = operator.getPartnerId();
				separationConfig = true;
			}
		}
		//可查询指定组织下的数据
		Integer defId = null;
		Integer orgId = null;
		if (param.getUserId()!=null) {
			defId = -2;
			orgId = param.getUserId();
		} else if (param.getOrganizationId() != null) {
			defId = 1;
			orgId = param.getOrganizationId();
		}
		String mangeRangeWhereCause = erpFunOrganizationService.getMangeRangeWhereCause(cityId, compId, operator.getUserId(), null, defId, orgId);
		Map<String, Object> totalCount = reportFunStatisticTotleMapper.getAppWorkCountAchieveStatisticsSummaryRankForOrg(cityId, compId, workColumns, assessmentMonth, endTime,mangeRangeWhereCause, separationConfig, partnerIdRange);
		AppAchieveStatisticsCountTotalVo appAchieveStatisticsCountTotalVo = JSON.parseObject(JSON.toJSONString(totalCount), AppAchieveStatisticsCountTotalVo.class);
		appAchieveStatisticsCountTotalVo.setHouseAddTotal(appAchieveStatisticsCountTotalVo.getSaleAddTotal() + appAchieveStatisticsCountTotalVo.getLeaseAddTotal());
		appAchieveStatisticsCountTotalVo.setCustomerAddTotal(appAchieveStatisticsCountTotalVo.getBuyAddTotal() + appAchieveStatisticsCountTotalVo.getRentAddTotal());
		appAchieveStatisticsCountTotalVo.setDaiKanTotal(appAchieveStatisticsCountTotalVo.getBuyDkTotal() + appAchieveStatisticsCountTotalVo.getRentDkTotal());
		appAchieveStatisticsCountTotalVo.setYaoShiTotal(appAchieveStatisticsCountTotalVo.getSaleYsTotal() + appAchieveStatisticsCountTotalVo.getLeaseYsTotal());
		appAchieveStatisticsCountTotalVo.setFunCanTotal(appAchieveStatisticsCountTotalVo.getSaleFunCanTotal() + appAchieveStatisticsCountTotalVo.getLeaseFunCanTotal());
		return ErpResponseJson.ok(appAchieveStatisticsCountTotalVo);
	}
	/**
	 * 掌通运营分析排行榜详情:房增
	 * @author 朱科
	 * @since 2018年10月22日
	 * @return
	 */
	@ApiOperation("掌通排行榜点击进入详情,需求=8769，作者：朱科")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = AppAchieveMonthStatisticsRankDetailHouseAddVo.class, message = "成功")
	})
	@ResponseBody
	@RequestMapping("/getAppAchieveMonthStatisticsRankDetailHouseAdd")
	public ErpResponseJson getAppAchieveMonthStatisticsRankDetailHouseAdd(@RequestBody AppAchieveMonthStatisticsRankDetailParam param) throws Exception{
		AppAchieveMonthStatisticsRankDetailHouseAddVo resultData = new AppAchieveMonthStatisticsRankDetailHouseAddVo();
		List<AppAchieveMonthStatisticsRankDetailHouseAddDto> resultList = new ArrayList<AppAchieveMonthStatisticsRankDetailHouseAddDto>();
		// 房增详情 FUN_STATISTIC_DETAIL_1
		Operator operator = getOperator();
		//加盟商范围
		List<Integer> partnerIds = deducePartnerWageRange(operator);
		//-------------------新版组织机构-------------------------
		getHouseAddDataForOrg(resultData,param,partnerIds,operator);
		return ErpResponseJson.ok(resultData);
		//-------------------新版组织机构-------------------------
	}


	private void getHouseAddDataForOrg(AppAchieveMonthStatisticsRankDetailHouseAddVo resultData, AppAchieveMonthStatisticsRankDetailParam param, List<Integer> partnerIds, Operator operator)throws Exception {
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer statisticType = 1; // 登记详情
		String assessmentMonth = param.getAssessmentMonth();
		Integer caseType = param.getCaseType();
		if(null == caseType){
			caseType = Const.DIC_CASE_TYPE_SALE_FUN;
		}
		String endTime = "";
		if(StringUtil.isNotBlank(assessmentMonth)){
			String year = assessmentMonth.substring(0,4); // year
			String month = assessmentMonth.substring(5, 7); // month
			endTime = DateConvert.getLastDayOfMonth(StringUtil.parseInteger(year, 2020), StringUtil.parseInteger(month, 1)) + "23:59:59";
		} else {
			String startTime = param.getStartTime();
			if(StringUtil.isNotBlank(startTime)){
				assessmentMonth = startTime;
			}
			if(StringUtil.isNotBlank(param.getEndTime())){
				endTime = param.getEndTime() + " 23:59:59";
			}
		}

		Integer defId = null;
		Integer orgId = null;
		if (param.getUserId()!=null) {
			defId = -2;
			orgId = param.getUserId();
		} else if (param.getOrganizationId() != null) {
			defId = 1;
			orgId = param.getOrganizationId();
		}
		//工作量范围
		String mangeRangeWhereCause = erpFunOrganizationService.getMangeRangeWhereCause(cityId, compId, operator.getUserId(), null, defId, orgId);
		List<ReportFunStatisticDetail1> datalList =reportFunStatisticDetail1Mapper.getAppAchieveMonthStatisticsRankDetailHouseAddForOrg(cityId,compId, partnerIds, assessmentMonth, endTime, statisticType, caseType,mangeRangeWhereCause);
		//查看的经纪人范围
		Set<Integer> caseIds = datalList.stream().map(ReportFunStatisticDetail1::getCaseId).collect(Collectors.toSet());
		List<AppAchieveMonthStatisticsRankDetailHouseAddDto> resultList = new ArrayList<>();
		if (caseIds.isEmpty()) {
			resultData.setList(resultList);
			return;
		}
		String userCause = erpFunOrganizationService.getMangeRangeWhereCause(cityId, compId, operator.getUserId(), null, null, null);
		List<ErpFunUsers> usersList = erpFunUsersMapper.getManagerUserListForOrg(cityId, compId,partnerIds,userCause);
		//
		Map<Integer, ErpFunUsers> usersMap = usersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, Function.identity()));

		Map<Integer, ReportFunStatisticDetail1> detailMap = datalList.stream().collect(Collectors.toMap(ReportFunStatisticDetail1::getCaseId, val -> val));
		if(Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)){
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
			List<ErpFunSale> saleList = erpFunSaleMapper.getAppAchieveMonthStatisticsRankDetailHouseAdd(cityId, compId, caseIds, null,null, null);
			for (ErpFunSale erpFunSale : saleList) {
				AppAchieveMonthStatisticsRankDetailHouseAddDto achieveMonthStatisticsRankDetailHouseAddDto = (AppAchieveMonthStatisticsRankDetailHouseAddDto) this.assembleDetailMap(erpFunSale, null);
				ReportFunStatisticDetail1 reportFunStatisticDetail1 = detailMap.get(erpFunSale.getSaleId());
				if(null == reportFunStatisticDetail1){
					continue;
				}
				ErpFunUsers user = usersMap.get(reportFunStatisticDetail1.getUserId());
				if(Objects.isNull(user)){
					continue;
				}
				achieveMonthStatisticsRankDetailHouseAddDto.setUserId(user.getUserId());
				achieveMonthStatisticsRankDetailHouseAddDto.setUserName(user.getUserName());
				achieveMonthStatisticsRankDetailHouseAddDto.setOrganizationId(user.getOrganizationId());
				resultList.add(achieveMonthStatisticsRankDetailHouseAddDto);
			}
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)){
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
			List<ErpFunLease> leaseList = erpFunLeaseMapper.getAppAchieveMonthStatisticsRankDetailHouseAdd(cityId, compId, caseIds, null, null, null);
			for (ErpFunLease erpFunLease : leaseList) {
				AppAchieveMonthStatisticsRankDetailHouseAddDto achieveMonthStatisticsRankDetailHouseAddDto = (AppAchieveMonthStatisticsRankDetailHouseAddDto) this.assembleDetailMap(erpFunLease, null);
				ReportFunStatisticDetail1 reportFunStatisticDetail1 = detailMap.get(erpFunLease.getLeaseId());
				if(null == reportFunStatisticDetail1){
					continue;
				}
				ErpFunUsers user = usersMap.get(reportFunStatisticDetail1.getUserId());
				if(Objects.isNull(user)){
					continue;
				}
				achieveMonthStatisticsRankDetailHouseAddDto.setUserId(user.getUserId());
				achieveMonthStatisticsRankDetailHouseAddDto.setOrganizationId(user.getOrganizationId());
				achieveMonthStatisticsRankDetailHouseAddDto.setUserName(user.getUserName());
				resultList.add(achieveMonthStatisticsRankDetailHouseAddDto);
			}
		}
		resultList.sort((o1, o2) -> {
			String creationTime1 = o1.getCreationTime();
			String creationTime2 = o2.getCreationTime();
			return creationTime2.compareTo(creationTime1);
		});
		resultData.setList(resultList);
	}
	private void getCustAddDataForOrg(AppAchieveMonthStatisticsRankDetailCustomerAddVo resultData, AppAchieveMonthStatisticsRankDetailParam param, List<Integer> partnerIds, Operator operator)throws Exception {
		List<AppAchieveMonthStatisticsRankDetailCustomerAddDto> resultList = new ArrayList<>();
		resultData.setList(resultList);
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer statisticType = 1; // 登记详情
		String assessmentMonth = param.getAssessmentMonth();
		Integer caseType = param.getCaseType();
		if(null == caseType){
			caseType = Const.DIC_CASE_TYPE_SALE_FUN;
		}
		String endTime = "";
		if(StringUtil.isNotBlank(assessmentMonth)){
			String year = assessmentMonth.substring(0,4); // year
			String month = assessmentMonth.substring(5, 7); // month
			endTime = DateConvert.getLastDayOfMonth(StringUtil.parseInteger(year, 2019), StringUtil.parseInteger(month, 1)) + "23:59:59";
		} else {
			String startTime = param.getStartTime();
			if(StringUtil.isNotBlank(startTime)){
				assessmentMonth = startTime;
			}
			if(StringUtil.isNotBlank(param.getEndTime())){
				endTime = param.getEndTime() + " 23:59:59";
			}
		}
		//----
		Integer defId = null;
		Integer orgId = null;
		if (param.getUserId()!=null) {
			defId = -2;
			orgId = param.getUserId();
		} else if (param.getOrganizationId() != null) {
			defId = 1;
			orgId = param.getOrganizationId();
		}
		String isShowCustfullname = erpSysParaMapper.getParamValue(cityId, compId, "IS_SHOW_CUSTFULLNAME");
		String mangeRangeWhereCause = erpFunOrganizationService.getMangeRangeWhereCause(cityId, compId, operator.getUserId(), null, defId, orgId);
		List<ReportFunStatisticDetail1> dataList =reportFunStatisticDetail1Mapper.getAppAchieveMonthStatisticsRankDetailHouseAddForOrg(cityId,compId, partnerIds, assessmentMonth, endTime, statisticType, caseType,mangeRangeWhereCause);
		if(null == dataList || dataList.isEmpty()){
			return;
		}
		String userCause = erpFunOrganizationService.getMangeRangeWhereCause(cityId, compId, operator.getUserId(), null, null, null);
		List<ErpFunUsers> usersList = erpFunUsersMapper.getManagerUserListForOrg(cityId, compId, partnerIds, userCause);
		Map<Integer, ErpFunUsers> usersMap = usersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, Function.identity()));
		Set<Integer> caseIds = dataList.stream().map(ReportFunStatisticDetail1::getCaseId).collect(Collectors.toSet());
		if (caseIds.isEmpty()) {
			return;
		}
		Map<Integer, ReportFunStatisticDetail1> detailMap = dataList.stream().collect(Collectors.toMap(ReportFunStatisticDetail1::getCaseId, val -> val, (o,n)->n));
		if(Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)){
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
			List<ErpFunBuyCustomer> buyCustomerList = erpFunBuyCustomerMapper.getAppAchieveMonthStatisticsRankDetailCustomerAdd(cityId, compId, caseIds, null, null, null);
			for (ErpFunBuyCustomer erpFunBuyCustomer : buyCustomerList) {
				AppAchieveMonthStatisticsRankDetailCustomerAddDto appAchieveMonthStatisticsRankDetailCustomerAddDto = (AppAchieveMonthStatisticsRankDetailCustomerAddDto) this.assembleDetailMap(erpFunBuyCustomer, isShowCustfullname);
				ReportFunStatisticDetail1 reportFunStatisticDetail1 = detailMap.get(erpFunBuyCustomer.getBuyCustId());
				if(null == reportFunStatisticDetail1){
					continue;
				}
				ErpFunUsers user = usersMap.get(reportFunStatisticDetail1.getUserId());
				if(Objects.isNull(user)){
					continue;
				}
				appAchieveMonthStatisticsRankDetailCustomerAddDto.setUserId(user.getUserId());
				appAchieveMonthStatisticsRankDetailCustomerAddDto.setOrganizationId(user.getOrganizationId());
				appAchieveMonthStatisticsRankDetailCustomerAddDto.setUserName(user.getUserName());
				resultList.add(appAchieveMonthStatisticsRankDetailCustomerAddDto);
			}
		} else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)){
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
			List<ErpFunRentCustomer> rentCustomerList = erpFunRentCustomerMapper.getAppAchieveMonthStatisticsRankDetailCustomerAdd(cityId, compId, caseIds, null, null, null);
			for (ErpFunRentCustomer erpFunRentCustomer : rentCustomerList) {
				AppAchieveMonthStatisticsRankDetailCustomerAddDto appAchieveMonthStatisticsRankDetailCustomerAddDto = (AppAchieveMonthStatisticsRankDetailCustomerAddDto) this.assembleDetailMap(erpFunRentCustomer, isShowCustfullname);
				ReportFunStatisticDetail1 reportFunStatisticDetail1 = detailMap.get(erpFunRentCustomer.getRentCustId());
				if(null == reportFunStatisticDetail1){
					continue;
				}
				ErpFunUsers user = usersMap.get(reportFunStatisticDetail1.getUserId());
				if(Objects.isNull(user)){
					continue;
				}
				appAchieveMonthStatisticsRankDetailCustomerAddDto.setUserId(user.getUserId());
				appAchieveMonthStatisticsRankDetailCustomerAddDto.setOrganizationId(user.getOrganizationId());

				appAchieveMonthStatisticsRankDetailCustomerAddDto.setUserName(user.getUserName());
				resultList.add(appAchieveMonthStatisticsRankDetailCustomerAddDto);
			}
		}
		resultList.sort((o1, o2) -> {
			String creationTime1 = o1.getCreationTime();
			String creationTime2 = o2.getCreationTime();
			return creationTime2.compareTo(creationTime1);
		});
		resultData.setList(resultList);
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
		if (!Objects.equals(operator.openPartner(), 1)) {
			return partnerIds;
		}
		//是否开启薪资分开管控参数
		PartnerConfigDto config = erpFunPartnerConfigService.getPartnerConfiguration(operator.getCityId(), operator.getCompId());
		if (Objects.isNull(config) || !Objects.equals(config.getWageApart(), (byte)1)) {
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

	/**
	 * 掌通运营分析排行榜详情:客增
	 * @author 朱科
	 * @since 2018年10月22日
	 * @return
	 */
	@ApiOperation("掌通排行榜点击进入详情,需求=8769，作者：朱科")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = AppAchieveMonthStatisticsRankDetailCustomerAddVo.class, message = "成功")
	})
	@ResponseBody
	@PostMapping("/getAppAchieveMonthStatisticsRankDetailCustomerAdd")
	public ErpResponseJson getAppAchieveMonthStatisticsRankDetailCustomerAdd(@RequestBody AppAchieveMonthStatisticsRankDetailParam param) throws Exception{
		AppAchieveMonthStatisticsRankDetailCustomerAddVo resultData = new AppAchieveMonthStatisticsRankDetailCustomerAddVo();
		List<AppAchieveMonthStatisticsRankDetailCustomerAddDto> resultList = new ArrayList<AppAchieveMonthStatisticsRankDetailCustomerAddDto>();
		// 房增详情 FUN_STATISTIC_DETAIL_1
		Operator operator = getOperator();
		//加盟商范围
		List<Integer> partnerIds = deducePartnerWageRange(operator);
		//-------------------新版组织机构-------------------------
		if (operator.newOrganizationType()) {
			resultData.setList(resultList);
			getCustAddDataForOrg(resultData,param,partnerIds,operator);
			return ErpResponseJson.ok(resultData);
		}
		//-------------------新版组织机构-------------------------
		Integer compId = operator.getCompId();
		Integer areaId = operator.getAreaId();
		Integer regId = operator.getRegId();
		Integer selfDeptId = operator.getDeptId();
		Integer grId = operator.getGrId();
		Integer userId = operator.getUserId();
		Integer cityId = operator.getCityId();
		Integer statisticType = 1; // 登记详情
		Integer deptId = param.getDeptId();
		Integer lookType = param.getLookType();
		Integer lookTypeId = param.getLookTypeId();
		String assessmentMonth = param.getAssessmentMonth();
		Integer caseType = param.getCaseType();
		if(null == caseType){
			caseType = Const.DIC_CASE_TYPE_BUY_CUST;
		}
		String endTime = "";
		if(StringUtil.isNotBlank(assessmentMonth)){
			String year = assessmentMonth.substring(0,4); // year
			String month = assessmentMonth.substring(5, 7); // month
			endTime = DateConvert.getLastDayOfMonth(StringUtil.parseInteger(year, 2019), StringUtil.parseInteger(month, 1)) + "23:59:59";
		} else {
			String startTime = param.getStartTime();
			if(StringUtil.isNotBlank(startTime)){
				assessmentMonth = startTime;
			}
			if(StringUtil.isNotBlank(param.getEndTime())){
				endTime = param.getEndTime() + " 23:59:59";
			}
		}

		// 获取自己的列表查看权
		String isShowCustfullname = erpSysParaMapper.getParamValue(cityId, compId, "IS_SHOW_CUSTFULLNAME");
		// 客源抢盘
//		String publicCustRange = erpSysParaMapper.getParamValue(cityId, compId, "PUBLIC_CUST_RANGE");
//		String publicHouseRange = erpSysParaMapper.getParamValue(cityId, compId, "PUBLIC_HOUSE_RANGE");
		Integer[] lookRange = this.getSelfLookRange(cityId, compId, areaId, regId, selfDeptId, grId, userId, caseType);
		Integer trueViewRang = lookRange[0];
		Integer trueViewRangId = lookRange[1];
		List<ReportFunStatisticDetail1> deatailList = reportFunStatisticDetail1Mapper.getAppAchieveMonthStatisticsRankDetailHouseAdd(compId, partnerIds, assessmentMonth, endTime, lookType, lookTypeId, statisticType, caseType, selfDeptId, deptId);
		if(null == deatailList || deatailList.isEmpty()){
			return ErpResponseJson.ok(resultData);
		}
		List<ErpFunDepts> deptsList = erpFunDeptsMapper.getCacheableDeptListByCompId(cityId, compId);
		Map<Integer, String> deptsMap = deptsList.stream().collect(Collectors.toMap(ErpFunDepts::getDeptId, ErpFunDepts::getDeptName));
		Set<Integer> lookSet = new HashSet<>();
		lookSet.add(lookTypeId);
		List<ErpFunUsers> usersList = erpFunUsersMapper.selectUserList(cityId, compId, deptId, lookType, lookSet, assessmentMonth);
		
		Map<Integer, String> usersMap = usersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, ErpFunUsers::getUserName));
		Set<Integer> caseIds = deatailList.stream().collect(Collectors.mapping(ReportFunStatisticDetail1::getCaseId, Collectors.toSet()));
		Map<Integer, ReportFunStatisticDetail1> detailMap = deatailList.stream().collect(Collectors.toMap(ReportFunStatisticDetail1::getCaseId, val -> val, (o,n)->n));
		if(Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)){
		    PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
			List<ErpFunBuyCustomer> buyCustomerList = erpFunBuyCustomerMapper.getAppAchieveMonthStatisticsRankDetailCustomerAdd(cityId, compId, caseIds, trueViewRang, trueViewRangId, deptId);
			for (ErpFunBuyCustomer erpFunBuyCustomer : buyCustomerList) {
				AppAchieveMonthStatisticsRankDetailCustomerAddDto appAchieveMonthStatisticsRankDetailCustomerAddDto = (AppAchieveMonthStatisticsRankDetailCustomerAddDto) this.assembleDetailMap(erpFunBuyCustomer, isShowCustfullname);
				ReportFunStatisticDetail1 reportFunStatisticDetail1 = detailMap.get(erpFunBuyCustomer.getBuyCustId());
				if(null == reportFunStatisticDetail1){
					continue;
				}
				String deptName = deptsMap.get(reportFunStatisticDetail1.getDeptId());
				if(StringUtil.isBlank(deptName)){
					continue;
				}
				String userName = usersMap.get(reportFunStatisticDetail1.getUserId());
				if(StringUtil.isBlank(userName)){
					continue;
				}
				appAchieveMonthStatisticsRankDetailCustomerAddDto.setUserName(userName);
				appAchieveMonthStatisticsRankDetailCustomerAddDto.setDeptName(deptName);
				resultList.add(appAchieveMonthStatisticsRankDetailCustomerAddDto);
			}
		} else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)){
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
			List<ErpFunRentCustomer> rentCustomerList = erpFunRentCustomerMapper.getAppAchieveMonthStatisticsRankDetailCustomerAdd(cityId, compId, caseIds, trueViewRang, trueViewRangId, deptId);
			for (ErpFunRentCustomer erpFunRentCustomer : rentCustomerList) {
				AppAchieveMonthStatisticsRankDetailCustomerAddDto appAchieveMonthStatisticsRankDetailCustomerAddDto = (AppAchieveMonthStatisticsRankDetailCustomerAddDto) this.assembleDetailMap(erpFunRentCustomer, isShowCustfullname);
				ReportFunStatisticDetail1 reportFunStatisticDetail1 = detailMap.get(erpFunRentCustomer.getRentCustId());
				if(null == reportFunStatisticDetail1){
					continue;
				}
				String deptName = deptsMap.get(reportFunStatisticDetail1.getDeptId());
				if(StringUtil.isBlank(deptName)){
					continue;
				}
				String userName = usersMap.get(reportFunStatisticDetail1.getUserId());
				if(StringUtil.isBlank(userName)){
					continue;
				}
				appAchieveMonthStatisticsRankDetailCustomerAddDto.setUserName(userName);
				appAchieveMonthStatisticsRankDetailCustomerAddDto.setDeptName(deptName);
				resultList.add(appAchieveMonthStatisticsRankDetailCustomerAddDto);
			}
		}
		resultList.sort((o1, o2) -> {
			String creationTime1 = o1.getCreationTime();
			String creationTime2 = o2.getCreationTime();
			return creationTime2.compareTo(creationTime1);
		});
		resultData.setList(resultList);
		return ErpResponseJson.ok(resultData);
	}
	
	/**
	 * 掌通运营分析排行榜详情:带看
	 * @author 朱科
	 * @since 2018年10月22日
	 * @return
	 */
	@ApiOperation("掌通排行榜点击进入详情,需求=8769，作者：朱科")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = AppAchieveMonthStatisticsRankDetailDkVo.class, message = "成功")
	})
	@ResponseBody
	@PostMapping("/getAppAchieveMonthStatisticsRankDetailDk")
	public ErpResponseJson getAppAchieveMonthStatisticsRankDetailDk(@RequestBody AppAchieveMonthStatisticsRankDetailParam param) throws Exception{
		AppAchieveMonthStatisticsRankDetailDkVo resultData = new AppAchieveMonthStatisticsRankDetailDkVo();
		List<AppAchieveMonthStatisticsRankDetailDkDto> resultList = new ArrayList<AppAchieveMonthStatisticsRankDetailDkDto>();
//		List<AppAchieveMonthStatisticsRankDetailDkSubDto> list
		Operator operator = getOperator();
		//--------------------新版组织机构----------------------------
		if (operator.newOrganizationType()) {
			return getAppAchieveMonthStatisticsRankDetailDkForOrg(param);
		}
		//--------------------新版组织机构----------------------------
		Integer compId = operator.getCompId();
		Integer areaId = operator.getAreaId();
		Integer regId = operator.getRegId();
		Integer selfDeptId = operator.getDeptId();
		Integer grId = operator.getGrId();
		Integer userId = operator.getUserId();
		Integer cityId = operator.getCityId();
		Integer deptId = param.getDeptId();
		Integer lookType = param.getLookType();
		Integer lookTypeId = param.getLookTypeId();
		String assessmentMonth = param.getAssessmentMonth();
		// 房带看详情 FUN_STATISTIC_DETAIL_35
		Integer caseType = param.getCaseType();
		if(null == caseType){
			caseType = Const.DIC_CASE_TYPE_BUY_CUST; // 默认求购
		}
		//加盟商模式下看到的门店范围
		List<Integer> partnerIds = deducePartnerWageRange(operator);
		Set<Integer> deptIds = null;
		List<ErpFunDepts> deptList = null;
		Integer lookGrId = null;
		Integer lookUserId = null;
		if(lookType == 2){
			deptList = erpFunDeptsMapper.getDeptList(cityId, compId, partnerIds, "AREA_ID", lookTypeId);
		} else if (lookType == 3){
			deptList = erpFunDeptsMapper.getDeptList(cityId, compId, partnerIds, "REG_ID", lookTypeId);
		} else if (lookType == 4){
			deptIds = new HashSet<>();
			deptIds.add(lookTypeId);
		} else if (lookType == 5){
			deptIds = new HashSet<>();
			deptIds.add(deptId);
			lookGrId = lookTypeId;
		} else if (lookType == 6){
			lookUserId = lookTypeId;
		}
		if(null != deptList && !deptList.isEmpty()){
			deptIds = deptList.stream().collect(Collectors.mapping(ErpFunDepts::getDeptId, Collectors.toSet()));
		}
		String endTime = "";
		if(StringUtil.isNotBlank(assessmentMonth)){
			String year = assessmentMonth.substring(0,4); // year
			String month = assessmentMonth.substring(5, 7); // month
			endTime = DateConvert.getLastDayOfMonth(StringUtil.parseInteger(year,2018), StringUtil.parseInteger(month,8)) + "23:59:59";
		} else {
			String startTime = param.getStartTime();
			if(StringUtil.isNotBlank(startTime)){
				assessmentMonth = startTime;
			}
			if(StringUtil.isNotBlank(param.getEndTime())){
				endTime = param.getEndTime() + " 23:59:59";
			}
		}
		// 获取自己的列表查看权
		Integer[] lookRange = this.getSelfLookRange(cityId, compId, areaId, regId, selfDeptId, grId, userId, caseType);
		Integer trueViewRang = lookRange[0];
		Integer trueViewRangId = lookRange[1];
		// 带看跟进
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<ErpFunTrack> tracksList = erpFunTrackMapper.getFunTrackByCaseIds(cityId, compId, null, caseType, Const.DIC_TRACK_TYPE_DAIKAN, deptIds, lookGrId, lookUserId, assessmentMonth, endTime);
		if(null == tracksList || tracksList.isEmpty()){
			return ErpResponseJson.ok(resultData);
		}
		// 客源信息
		Set<Integer> caseIds = tracksList.stream().collect(Collectors.mapping(ErpFunTrack::getCaseId, Collectors.toSet()));
		// 带看房源信息
		Set<Integer> targetIds = tracksList.stream().filter(val -> val.getTargetId() != null ).collect(Collectors.mapping(ErpFunTrack::getTargetId, Collectors.toSet()));
		if(null == targetIds || targetIds.isEmpty()){
			return ErpResponseJson.ok(resultData);
		}
		// 一客一人一天算一个量
		Map<String, List<ErpFunTrack>> trackMap = new HashMap<>();
		Map<Integer, Integer> caseMap = new HashMap<>();
		tracksList.forEach(erpFunTrack -> {
			String creationTime = erpFunTrack.getCreationTime();
			try {
				creationTime = DateTimeHelper.formatDatetoString(creationTime);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Integer caseId = erpFunTrack.getCaseId();
			caseMap.put(erpFunTrack.getTrackId(), caseId);
			Integer creatorUid = erpFunTrack.getCreatorUid();
			String key = caseId + "_" + creatorUid + "_" + creationTime;
			List<ErpFunTrack> list = trackMap.get(key);
			if (null == list) {
				list = new ArrayList<>();
			}
			list.add(erpFunTrack);
			trackMap.put(key, list);
		});
		// 组织机构信息
		String isShowCustfullname = erpSysParaMapper.getParamValue(cityId, compId, "IS_SHOW_CUSTFULLNAME");
		List<ErpFunDepts> deptsList = erpFunDeptsMapper.getCacheableDeptListByCompId(cityId, compId);
		Map<Integer, String> deptsMap = deptsList.stream().collect(Collectors.toMap(ErpFunDepts::getDeptId, ErpFunDepts::getDeptName));
		Set<Integer> lookSet = new HashSet<>();
		lookSet.add(lookTypeId);
		List<ErpFunUsers> usersList = erpFunUsersMapper.selectUserList(cityId, compId, deptId, lookType, lookSet, assessmentMonth);
		Map<Integer, String> usersMap = usersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, ErpFunUsers::getUserName));
		if(Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)){
			// 客源信息
			List<ErpFunBuyCustomer> buyCustomerList = erpFunBuyCustomerMapper.getAppAchieveMonthStatisticsRankDetailCustomerAdd(cityId, compId, caseIds, trueViewRang, trueViewRangId, deptId);
			Map<Integer, ErpFunBuyCustomer> buyCustMap = buyCustomerList.stream().collect(Collectors.toMap(ErpFunBuyCustomer::getBuyCustId, val -> val));
			// 房源信息
			List<ErpFunSale> saleList = erpFunSaleMapper.getAppAchieveMonthStatisticsRankDetailHouseAdd(cityId, compId, targetIds, trueViewRang, trueViewRangId, deptId);
			Map<Integer, ErpFunSale> saleMap = saleList.stream().collect(Collectors.toMap(ErpFunSale::getSaleId, val -> val));
			for (Entry<String, List<ErpFunTrack>> tracks : trackMap.entrySet()) {
				List<ErpFunTrack> trackSubList = tracks.getValue();
				if(trackSubList.isEmpty()){
					continue;
				}
				ErpFunTrack funTrack = trackSubList.get(0);
				if(null == funTrack){
					continue;
				}
				Integer caseId = funTrack.getCaseId();
				ErpFunBuyCustomer erpFunBuyCustomer = buyCustMap.get(caseId);
				if(null == erpFunBuyCustomer){
					continue;
				}
				AppAchieveMonthStatisticsRankDetailDkDto achieveMonthStatisticsRankDetailDkDto = new AppAchieveMonthStatisticsRankDetailDkDto();
				achieveMonthStatisticsRankDetailDkDto.setBuildId(StringUtil.parseInteger(erpFunBuyCustomer.getBuildId()));
				achieveMonthStatisticsRankDetailDkDto.setBuildName(erpFunBuyCustomer.getBuildName());
				achieveMonthStatisticsRankDetailDkDto.setCaseId(erpFunBuyCustomer.getBuyCustId());
				achieveMonthStatisticsRankDetailDkDto.setCaseType(caseType);
				if(!"1".equals(isShowCustfullname) && StringUtil.isNotBlank(erpFunBuyCustomer.getBuyCustName())){
					achieveMonthStatisticsRankDetailDkDto.setCustName(erpFunBuyCustomer.getBuyCustName().substring(0, 1));
				}
				achieveMonthStatisticsRankDetailDkDto.setHouseAreaHigh(erpFunBuyCustomer.getHouseAreaHigh());
				achieveMonthStatisticsRankDetailDkDto.setHouseAreaLow(erpFunBuyCustomer.getHouseAreaLow());
				achieveMonthStatisticsRankDetailDkDto.setHouseRoom(erpFunBuyCustomer.getHouseRoom());
				achieveMonthStatisticsRankDetailDkDto.setHouseRoom1(erpFunBuyCustomer.getHouseRoom1());
				achieveMonthStatisticsRankDetailDkDto.setHouseUseage(erpFunBuyCustomer.getHouseUseage());
				achieveMonthStatisticsRankDetailDkDto.setRegionName(erpFunBuyCustomer.getRegionName());
				achieveMonthStatisticsRankDetailDkDto.setSectionName(erpFunBuyCustomer.getSectionName());
				achieveMonthStatisticsRankDetailDkDto.setHouseTotalPrice(erpFunBuyCustomer.getHousePriceHigh());
				achieveMonthStatisticsRankDetailDkDto.setHouseLowestPrice(erpFunBuyCustomer.getHousePriceLow());
				achieveMonthStatisticsRankDetailDkDto.setDeptId(funTrack.getDeptId());
				achieveMonthStatisticsRankDetailDkDto.setDeptName(deptsMap.get(funTrack.getDeptId()));
				achieveMonthStatisticsRankDetailDkDto.setUserId(funTrack.getCreatorUid());
				if(StringUtil.isBlank(usersMap.get(funTrack.getCreatorUid()))){
					continue;
				}
				achieveMonthStatisticsRankDetailDkDto.setUserName(usersMap.get(funTrack.getCreatorUid()));
				achieveMonthStatisticsRankDetailDkDto.setCreationTime(DateTimeHelper.formatDateTimetoString(funTrack.getCreationTime()));
				Integer custSex = (null != erpFunBuyCustomer.getBuyCustSex() && erpFunBuyCustomer.getBuyCustSex())?1:0;
				achieveMonthStatisticsRankDetailDkDto.setCustSex(custSex);
				List<AppAchieveMonthStatisticsRankDetailDkSubDto> dkSubList = new ArrayList<AppAchieveMonthStatisticsRankDetailDkSubDto>();
				for (ErpFunTrack erpFunTrack: trackSubList) {
					AppAchieveMonthStatisticsRankDetailDkSubDto subData = new AppAchieveMonthStatisticsRankDetailDkSubDto();
					subData.setCaseType(erpFunTrack.getTargetType()); // 求购对应的出售
					subData.setCaseId(erpFunTrack.getTargetId());
					ErpFunSale erpFunSale = saleMap.get(erpFunTrack.getTargetId());
					if(null == erpFunSale){
						continue;
					}
					subData.setCreationTime(DateTimeHelper.formatDateTimetoString(erpFunTrack.getCreationTime()));
					subData.setBuildId(erpFunSale.getBuildId());
					subData.setBuildName(erpFunSale.getBuildName());
					subData.setDeptId(erpFunTrack.getDeptId());
					subData.setDeptName(deptsMap.get(erpFunTrack.getDeptId()));
					subData.setUserId(erpFunTrack.getCreatorUid());
					String userName = usersMap.get(erpFunTrack.getCreatorUid());
					if(StringUtil.isBlank(userName)){
						continue;
					}
					subData.setUserName(userName);
					subData.setDkPhotoCount(erpFunTrack.getDkPhotoCount());
					subData.setTrackResult(erpFunTrack.getTrackResult());
					subData.setHouseArea(erpFunSale.getSaleArea());
					subData.setHouseRoom(erpFunSale.getSaleRoom());
					subData.setHouseTotalPrice(erpFunSale.getSaleTotalPrice());
					subData.setHouseLowestPrice(erpFunSale.getSaleLowestPrice());
					subData.setTrackId(erpFunTrack.getTrackId());
					subData.setTrackType(erpFunTrack.getTrackType());
					dkSubList.add(subData);
				}
				achieveMonthStatisticsRankDetailDkDto.setList(dkSubList);
				resultList.add(achieveMonthStatisticsRankDetailDkDto);
			}
		} else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)){
			// 客源信息
			List<ErpFunRentCustomer> funRentList = erpFunRentCustomerMapper.getAppAchieveMonthStatisticsRankDetailCustomerAdd(cityId, compId, caseIds, trueViewRang, trueViewRangId, deptId);
			Map<Integer, ErpFunRentCustomer> rentCustMap = funRentList.stream().collect(Collectors.toMap(ErpFunRentCustomer::getRentCustId, val ->val));
			// 房源信息
			List<ErpFunLease> leaseList = erpFunLeaseMapper.getAppAchieveMonthStatisticsRankDetailHouseAdd(cityId, compId, targetIds, trueViewRang, trueViewRangId, deptId);
			Map<Integer, ErpFunLease> leaseMap = leaseList.stream().collect(Collectors.toMap(ErpFunLease::getLeaseId, val -> val));
			for (Entry<String, List<ErpFunTrack>> tracks : trackMap.entrySet()) {
				List<ErpFunTrack> trackSubList = tracks.getValue();
				if(trackSubList.isEmpty()){
					continue;
				}
				ErpFunTrack funTrack = trackSubList.get(0);
				if(null == funTrack){
					continue;
				}
				Integer caseId = funTrack.getCaseId();
				ErpFunRentCustomer erpFunRentCustomer = rentCustMap.get(caseId);
				if(null == erpFunRentCustomer){
					continue;
				}
				AppAchieveMonthStatisticsRankDetailDkDto achieveMonthStatisticsRankDetailDkDto = new AppAchieveMonthStatisticsRankDetailDkDto();
				achieveMonthStatisticsRankDetailDkDto.setBuildId(StringUtil.parseInteger(erpFunRentCustomer.getBuildId()));
				achieveMonthStatisticsRankDetailDkDto.setBuildName(erpFunRentCustomer.getBuildName());
				achieveMonthStatisticsRankDetailDkDto.setCaseId(erpFunRentCustomer.getRentCustId());
				achieveMonthStatisticsRankDetailDkDto.setCaseType(caseType);
				if(!"1".equals(isShowCustfullname) && StringUtil.isNotBlank(erpFunRentCustomer.getRentCustName())){
					achieveMonthStatisticsRankDetailDkDto.setCustName(erpFunRentCustomer.getRentCustName().substring(0, 1));
				}
				achieveMonthStatisticsRankDetailDkDto.setHouseAreaHigh(erpFunRentCustomer.getHouseAreaHigh());
				achieveMonthStatisticsRankDetailDkDto.setHouseAreaLow(erpFunRentCustomer.getHouseAreaLow());
				achieveMonthStatisticsRankDetailDkDto.setHouseRoom(erpFunRentCustomer.getHouseRoom());
				achieveMonthStatisticsRankDetailDkDto.setHouseRoom1(erpFunRentCustomer.getHouseRoom1());
				achieveMonthStatisticsRankDetailDkDto.setHouseUseage(erpFunRentCustomer.getHouseUseage());
				achieveMonthStatisticsRankDetailDkDto.setRegionName(erpFunRentCustomer.getRegionName());
				achieveMonthStatisticsRankDetailDkDto.setSectionName(erpFunRentCustomer.getSectionName());
				achieveMonthStatisticsRankDetailDkDto.setHouseTotalPrice(erpFunRentCustomer.getHousePriceHigh());
				achieveMonthStatisticsRankDetailDkDto.setHouseLowestPrice(erpFunRentCustomer.getHousePriceLow());
				achieveMonthStatisticsRankDetailDkDto.setDeptId(funTrack.getDeptId());
				achieveMonthStatisticsRankDetailDkDto.setDeptName(deptsMap.get(funTrack.getDeptId()));
				achieveMonthStatisticsRankDetailDkDto.setUserId(funTrack.getCreatorUid());
				if(StringUtil.isBlank(usersMap.get(funTrack.getCreatorUid()))){
					continue;
				}
				achieveMonthStatisticsRankDetailDkDto.setUserName(usersMap.get(funTrack.getCreatorUid()));
				achieveMonthStatisticsRankDetailDkDto.setCreationTime(DateTimeHelper.formatDateTimetoString(funTrack.getCreationTime()));
				Integer custSex = (null != erpFunRentCustomer.getRentCustSex() && erpFunRentCustomer.getRentCustSex())?1:0;
				achieveMonthStatisticsRankDetailDkDto.setCustSex(custSex);
				List<AppAchieveMonthStatisticsRankDetailDkSubDto> dkSubList = new ArrayList<AppAchieveMonthStatisticsRankDetailDkSubDto>();
				for (ErpFunTrack erpFunTrack: trackSubList) {
					AppAchieveMonthStatisticsRankDetailDkSubDto subData = new AppAchieveMonthStatisticsRankDetailDkSubDto();
					subData.setCaseType(erpFunTrack.getTargetType()); // 求购对应的出售
					subData.setCaseId(erpFunTrack.getTargetId());
					ErpFunLease erpFunLease = leaseMap.get(erpFunTrack.getTargetId());
					if(null == erpFunLease){
						continue;
					}
					subData.setCreationTime(DateTimeHelper.formatDateTimetoString(erpFunTrack.getCreationTime()));
					subData.setBuildId(erpFunLease.getBuildId());
					subData.setBuildName(erpFunLease.getBuildName());
					subData.setDeptId(erpFunTrack.getDeptId());
					subData.setDeptName(deptsMap.get(erpFunTrack.getDeptId()));
					subData.setUserId(erpFunTrack.getCreatorUid());
					String userName = usersMap.get(erpFunTrack.getCreatorUid());
					if(StringUtil.isBlank(userName)){
						continue;
					}
					subData.setDkPhotoCount(erpFunTrack.getDkPhotoCount());
					subData.setTrackResult(erpFunTrack.getTrackResult());
					subData.setHouseArea(erpFunLease.getLeaseArea());
					subData.setHouseRoom(erpFunLease.getLeaseRoom());
					subData.setHouseTotalPrice(erpFunLease.getLeaseTotalPrice());
					subData.setHouseLowestPrice(erpFunLease.getLeaseLowestPrice());
					subData.setPriceUnit(erpFunLease.getPriceUnit());
					subData.setTrackId(erpFunTrack.getTrackId());
					subData.setTrackType(erpFunTrack.getTrackType());
					dkSubList.add(subData);
				}
				achieveMonthStatisticsRankDetailDkDto.setList(dkSubList);
				resultList.add(achieveMonthStatisticsRankDetailDkDto);
			}
		}
		resultList.sort((o1, o2) -> {
			String creationTime1 = o1.getCreationTime();
			String creationTime2 = o2.getCreationTime();
			return creationTime2.compareTo(creationTime1);
		});
		resultData.setList(resultList);
		return ErpResponseJson.ok(resultData);
	}

	/** 为什么代码这么长 应为是抄过来的
	 * 新版组织机构
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public ErpResponseJson getAppAchieveMonthStatisticsRankDetailDkForOrg(AppAchieveMonthStatisticsRankDetailParam param) throws Exception{
		AppAchieveMonthStatisticsRankDetailDkVo resultData = new AppAchieveMonthStatisticsRankDetailDkVo();
		List<AppAchieveMonthStatisticsRankDetailDkDto> resultList = new ArrayList<AppAchieveMonthStatisticsRankDetailDkDto>();
		resultData.setList(resultList);
		Operator operator = getOperator();
		Integer compId = operator.getCompId();
		Integer userId = operator.getUserId();
		Integer cityId = operator.getCityId();
		String assessmentMonth = param.getAssessmentMonth();
		// 房带看详情 FUN_STATISTIC_DETAIL_35
		Integer caseType = param.getCaseType();
		if(null == caseType){
			caseType = Const.DIC_CASE_TYPE_BUY_CUST; // 默认求购
		}
		//加盟商模式下看到的门店范围
		List<Integer> partnerIds = deducePartnerWageRange(operator);
		String endTime = "";
		if(StringUtil.isNotBlank(assessmentMonth)){
			String year = assessmentMonth.substring(0,4); // year
			String month = assessmentMonth.substring(5, 7); // month
			endTime = DateConvert.getLastDayOfMonth(StringUtil.parseInteger(year,2018), StringUtil.parseInteger(month,8)) + "23:59:59";
		} else {
			String startTime = param.getStartTime();
			if(StringUtil.isNotBlank(startTime)){
				assessmentMonth = startTime;
			}
			if(StringUtil.isNotBlank(param.getEndTime())){
				endTime = param.getEndTime() + " 23:59:59";
			}
		}
		Integer defId = null;
		Integer orgId = null;
		if (param.getUserId()!=null) {
			defId = -2;
			orgId = param.getUserId();
		} else if (param.getOrganizationId() != null) {
			defId = 1;
			orgId = param.getOrganizationId();
		}
		String mangeRangePathWhereCause = erpFunOrganizationService.getMangeRangePathWhereCause(cityId, compId, userId, null, null, defId, orgId);
		mangeRangePathWhereCause = mangeRangePathWhereCause.replaceAll("USER_ID", "CREATOR_UID");
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<ErpFunTrack> tracksList = erpFunTrackMapper.getFunTrackByCaseIdsForOrg(cityId, compId, partnerIds,null, caseType, Const.DIC_TRACK_TYPE_DAIKAN, mangeRangePathWhereCause, null, assessmentMonth, endTime);
		if(null == tracksList || tracksList.isEmpty()){
			return ErpResponseJson.ok(resultData);
		}
		// 客源信息
		Set<Integer> caseIds = tracksList.stream().map(ErpFunTrack::getCaseId).collect(Collectors.toSet());
		// 带看房源信息
		Set<Integer> targetIds = tracksList.stream().filter(val -> val.getTargetId() != null ).map(ErpFunTrack::getTargetId).collect(Collectors.toSet());
		if(targetIds.isEmpty()){
			return ErpResponseJson.ok(resultData);
		}
		// 一客一人一天算一个量
		Map<String, List<ErpFunTrack>> trackMap = tracksList.stream().collect(Collectors.groupingBy(obj -> {
			String creationTime = obj.getCreationTime();
			try {
				creationTime = DateTimeHelper.formatDatetoString(creationTime);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return obj.getCaseId() + "_" + obj.getCreatorUid() + "_" + creationTime;
		}));

		// 组织机构信息
		String isShowCustfullname = erpSysParaMapper.getParamValue(cityId, compId, "IS_SHOW_CUSTFULLNAME");
		mangeRangePathWhereCause = erpFunOrganizationService.getMangeRangePathWhereCause(cityId, compId, userId, null, null, null, null);
		List<ErpFunUsers> usersList = erpFunUsersMapper.getManagerUserListForOrg(cityId, compId, partnerIds, mangeRangePathWhereCause);
		Map<Integer, String> userNameMap = usersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, ErpFunUsers::getUserName));
		Map<Integer, ErpFunUsers> userMap = usersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, Function.identity()));
		//组织信息
		List<ErpFunOrganization> orgList = erpFunOrganizationMapper.selectOrgByOrgIds(cityId, compId,null);
		HashMap<Integer, ErpFunOrganization> allOrgMap = orgList.stream().collect(HashMap::new, (m, obj) -> m.put(obj.getOrganizationId(), obj), Map::putAll);
		if(Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)){
			// 客源信息
			List<ErpFunBuyCustomer> buyCustomerList = erpFunBuyCustomerMapper.getAppAchieveMonthStatisticsRankDetailCustomerAdd(cityId, compId, caseIds, null,null,null);
			Map<Integer, ErpFunBuyCustomer> buyCustMap = buyCustomerList.stream().collect(Collectors.toMap(ErpFunBuyCustomer::getBuyCustId, val -> val));
			// 房源信息
			List<ErpFunSale> saleList = erpFunSaleMapper.getAppAchieveMonthStatisticsRankDetailHouseAdd(cityId, compId, targetIds, null,null,null);
			Map<Integer, ErpFunSale> saleMap = saleList.stream().collect(Collectors.toMap(ErpFunSale::getSaleId, val -> val));
			for (Entry<String, List<ErpFunTrack>> tracks : trackMap.entrySet()) {
				List<ErpFunTrack> trackSubList = tracks.getValue();
				if(trackSubList.isEmpty()){continue;}
				ErpFunTrack funTrack = trackSubList.get(0);
				if(null == funTrack){ continue;}
				Integer caseId = funTrack.getCaseId();
				ErpFunBuyCustomer erpFunBuyCustomer = buyCustMap.get(caseId);
				if(null == erpFunBuyCustomer){continue;}
				AppAchieveMonthStatisticsRankDetailDkDto achieveMonthStatisticsRankDetailDkDto = new AppAchieveMonthStatisticsRankDetailDkDto();
				String buildIds = Optional.ofNullable(erpFunBuyCustomer.getBuildId()).map(String::trim).orElse("0");
				String[] ids = buildIds.split("\\s+");
				achieveMonthStatisticsRankDetailDkDto.setBuildId(StringUtil.parseInteger(ids[0], 0));
				achieveMonthStatisticsRankDetailDkDto.setBuildName(erpFunBuyCustomer.getBuildName());
				achieveMonthStatisticsRankDetailDkDto.setCaseId(erpFunBuyCustomer.getBuyCustId());
				achieveMonthStatisticsRankDetailDkDto.setCaseType(caseType);
				if(!"1".equals(isShowCustfullname) && StringUtil.isNotBlank(erpFunBuyCustomer.getBuyCustName())){
					achieveMonthStatisticsRankDetailDkDto.setCustName(erpFunBuyCustomer.getBuyCustName().substring(0, 1));
				}
				achieveMonthStatisticsRankDetailDkDto.setHouseAreaHigh(erpFunBuyCustomer.getHouseAreaHigh());
				achieveMonthStatisticsRankDetailDkDto.setHouseAreaLow(erpFunBuyCustomer.getHouseAreaLow());
				achieveMonthStatisticsRankDetailDkDto.setHouseRoom(erpFunBuyCustomer.getHouseRoom());
				achieveMonthStatisticsRankDetailDkDto.setHouseRoom1(erpFunBuyCustomer.getHouseRoom1());
				achieveMonthStatisticsRankDetailDkDto.setHouseUseage(erpFunBuyCustomer.getHouseUseage());
				achieveMonthStatisticsRankDetailDkDto.setRegionName(erpFunBuyCustomer.getRegionName());
				achieveMonthStatisticsRankDetailDkDto.setSectionName(erpFunBuyCustomer.getSectionName());
				achieveMonthStatisticsRankDetailDkDto.setHouseTotalPrice(erpFunBuyCustomer.getHousePriceHigh());
				achieveMonthStatisticsRankDetailDkDto.setHouseLowestPrice(erpFunBuyCustomer.getHousePriceLow());
				//组织名称及id
				ErpFunUsers erpFunUsers = userMap.get(funTrack.getCreatorUid());
				if(erpFunUsers == null){continue;}
				ErpFunOrganization org = allOrgMap.get(erpFunUsers.getOrganizationId());
				if(org == null){continue;}
				achieveMonthStatisticsRankDetailDkDto.setOrganizationId(org.getOrganizationId());
				achieveMonthStatisticsRankDetailDkDto.setUserId(funTrack.getCreatorUid());
				achieveMonthStatisticsRankDetailDkDto.setUserName(erpFunUsers.getUserName());
				achieveMonthStatisticsRankDetailDkDto.setCreationTime(DateTimeHelper.formatDateTimetoString(funTrack.getCreationTime()));
				Integer custSex = (null != erpFunBuyCustomer.getBuyCustSex() && erpFunBuyCustomer.getBuyCustSex())?1:0;
				achieveMonthStatisticsRankDetailDkDto.setCustSex(custSex);
				List<AppAchieveMonthStatisticsRankDetailDkSubDto> dkSubList = new ArrayList<AppAchieveMonthStatisticsRankDetailDkSubDto>();
				for (ErpFunTrack erpFunTrack: trackSubList) {
					AppAchieveMonthStatisticsRankDetailDkSubDto subData = new AppAchieveMonthStatisticsRankDetailDkSubDto();
					subData.setCaseType(erpFunTrack.getTargetType()); // 求购对应的出售
					subData.setCaseId(erpFunTrack.getTargetId());
					ErpFunSale erpFunSale = saleMap.get(erpFunTrack.getTargetId());
					if(null == erpFunSale){
						continue;
					}
					subData.setCreationTime(DateTimeHelper.formatDateTimetoString(erpFunTrack.getCreationTime()));
					subData.setBuildId(erpFunSale.getBuildId());
					subData.setBuildName(erpFunSale.getBuildName());
					ErpFunUsers erpFunUsersInner = userMap.get(erpFunTrack.getCreatorUid());
					if(erpFunUsersInner==null){continue;}
					ErpFunOrganization orgInner = allOrgMap.get(erpFunUsersInner.getOrganizationId());
					if(orgInner == null){continue;}
					achieveMonthStatisticsRankDetailDkDto.setOrganizationId(orgInner.getOrganizationId());
//					achieveMonthStatisticsRankDetailDkDto.setDeptName(orgInner.getOrganizationName());
					subData.setUserId(erpFunTrack.getCreatorUid());
					String userName = userNameMap.get(erpFunTrack.getCreatorUid());
					subData.setUserName(erpFunUsersInner.getUserName());
					subData.setDkPhotoCount(erpFunTrack.getDkPhotoCount());
					subData.setTrackResult(erpFunTrack.getTrackResult());
					subData.setHouseArea(erpFunSale.getSaleArea());
					subData.setHouseRoom(erpFunSale.getSaleRoom());
					subData.setHouseTotalPrice(erpFunSale.getSaleTotalPrice());
					subData.setHouseLowestPrice(erpFunSale.getSaleLowestPrice());
					subData.setTrackId(erpFunTrack.getTrackId());
					subData.setTrackType(erpFunTrack.getTrackType());
					dkSubList.add(subData);
				}
				achieveMonthStatisticsRankDetailDkDto.setList(dkSubList);
				resultList.add(achieveMonthStatisticsRankDetailDkDto);
			}
		} else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)){
			// 客源信息
			List<ErpFunRentCustomer> funRentList = erpFunRentCustomerMapper.getAppAchieveMonthStatisticsRankDetailCustomerAdd(cityId, compId, caseIds, null,null,null);
			Map<Integer, ErpFunRentCustomer> rentCustMap = funRentList.stream().collect(Collectors.toMap(ErpFunRentCustomer::getRentCustId, val ->val));
			// 房源信息
			List<ErpFunLease> leaseList = erpFunLeaseMapper.getAppAchieveMonthStatisticsRankDetailHouseAdd(cityId, compId, targetIds, null,null,null);
			Map<Integer, ErpFunLease> leaseMap = leaseList.stream().collect(Collectors.toMap(ErpFunLease::getLeaseId, val -> val));
			for (Entry<String, List<ErpFunTrack>> tracks : trackMap.entrySet()) {
				List<ErpFunTrack> trackSubList = tracks.getValue();
				if(trackSubList.isEmpty()){
					continue;
				}
				ErpFunTrack funTrack = trackSubList.get(0);
				if(null == funTrack){
					continue;
				}
				Integer caseId = funTrack.getCaseId();
				ErpFunRentCustomer erpFunRentCustomer = rentCustMap.get(caseId);
				if(null == erpFunRentCustomer){
					continue;
				}
				AppAchieveMonthStatisticsRankDetailDkDto achieveMonthStatisticsRankDetailDkDto = new AppAchieveMonthStatisticsRankDetailDkDto();
				String buildIds = Optional.ofNullable(erpFunRentCustomer.getBuildId()).map(String::trim).orElse("0");
				String[] ids = buildIds.split("\\s+");
				achieveMonthStatisticsRankDetailDkDto.setBuildId(StringUtil.parseInteger(ids[0], 0));
				achieveMonthStatisticsRankDetailDkDto.setBuildName(erpFunRentCustomer.getBuildName());
				achieveMonthStatisticsRankDetailDkDto.setCaseId(erpFunRentCustomer.getRentCustId());
				achieveMonthStatisticsRankDetailDkDto.setCaseType(caseType);
				if(!"1".equals(isShowCustfullname) && StringUtil.isNotBlank(erpFunRentCustomer.getRentCustName())){
					achieveMonthStatisticsRankDetailDkDto.setCustName(erpFunRentCustomer.getRentCustName().substring(0, 1));
				}
				achieveMonthStatisticsRankDetailDkDto.setHouseAreaHigh(erpFunRentCustomer.getHouseAreaHigh());
				achieveMonthStatisticsRankDetailDkDto.setHouseAreaLow(erpFunRentCustomer.getHouseAreaLow());
				achieveMonthStatisticsRankDetailDkDto.setHouseRoom(erpFunRentCustomer.getHouseRoom());
				achieveMonthStatisticsRankDetailDkDto.setHouseRoom1(erpFunRentCustomer.getHouseRoom1());
				achieveMonthStatisticsRankDetailDkDto.setHouseUseage(erpFunRentCustomer.getHouseUseage());
				achieveMonthStatisticsRankDetailDkDto.setRegionName(erpFunRentCustomer.getRegionName());
				achieveMonthStatisticsRankDetailDkDto.setSectionName(erpFunRentCustomer.getSectionName());
				achieveMonthStatisticsRankDetailDkDto.setHouseTotalPrice(erpFunRentCustomer.getHousePriceHigh());
				achieveMonthStatisticsRankDetailDkDto.setHouseLowestPrice(erpFunRentCustomer.getHousePriceLow());
				//组织名称及id
				ErpFunUsers erpFunUsers = userMap.get(funTrack.getCreatorUid());
				if(erpFunUsers == null){continue;}
				ErpFunOrganization org = allOrgMap.get(erpFunUsers.getOrganizationId());
				if(org == null){continue;}
				achieveMonthStatisticsRankDetailDkDto.setOrganizationId(org.getOrganizationId());
				achieveMonthStatisticsRankDetailDkDto.setUserId(funTrack.getCreatorUid());
				String s = userNameMap.get(funTrack.getCreatorUid());
				achieveMonthStatisticsRankDetailDkDto.setUserName(erpFunUsers.getUserName());
				achieveMonthStatisticsRankDetailDkDto.setCreationTime(DateTimeHelper.formatDateTimetoString(funTrack.getCreationTime()));
				Integer custSex = (null != erpFunRentCustomer.getRentCustSex() && erpFunRentCustomer.getRentCustSex())?1:0;
				achieveMonthStatisticsRankDetailDkDto.setCustSex(custSex);
				List<AppAchieveMonthStatisticsRankDetailDkSubDto> dkSubList = new ArrayList<AppAchieveMonthStatisticsRankDetailDkSubDto>();
				for (ErpFunTrack erpFunTrack: trackSubList) {
					AppAchieveMonthStatisticsRankDetailDkSubDto subData = new AppAchieveMonthStatisticsRankDetailDkSubDto();
					subData.setCaseType(erpFunTrack.getTargetType()); // 求购对应的出售
					subData.setCaseId(erpFunTrack.getTargetId());
					ErpFunLease erpFunLease = leaseMap.get(erpFunTrack.getTargetId());
					if(null == erpFunLease){
						continue;
					}
					subData.setCreationTime(DateTimeHelper.formatDateTimetoString(erpFunTrack.getCreationTime()));
					subData.setBuildId(erpFunLease.getBuildId());
					subData.setBuildName(erpFunLease.getBuildName());
//					subData.setDeptName(deptsMap.get(erpFunTrack.getDeptId()));
					ErpFunUsers erpFunUsersInner = userMap.get(funTrack.getCreatorUid());
					if(erpFunUsersInner == null){continue;}
					ErpFunOrganization orgInner = allOrgMap.get(erpFunUsersInner.getOrganizationId());
					if(orgInner == null){continue;}
					achieveMonthStatisticsRankDetailDkDto.setOrganizationId(orgInner.getOrganizationId());
					subData.setUserId(erpFunTrack.getCreatorUid());
					subData.setUserName(erpFunUsersInner.getUserName());
					subData.setDkPhotoCount(erpFunTrack.getDkPhotoCount());
					subData.setTrackResult(erpFunTrack.getTrackResult());
					subData.setHouseArea(erpFunLease.getLeaseArea());
					subData.setHouseRoom(erpFunLease.getLeaseRoom());
					subData.setHouseTotalPrice(erpFunLease.getLeaseTotalPrice());
					subData.setHouseLowestPrice(erpFunLease.getLeaseLowestPrice());
					subData.setPriceUnit(erpFunLease.getPriceUnit());
					subData.setTrackId(erpFunTrack.getTrackId());
					subData.setTrackType(erpFunTrack.getTrackType());
					dkSubList.add(subData);
				}
				achieveMonthStatisticsRankDetailDkDto.setList(dkSubList);
				resultList.add(achieveMonthStatisticsRankDetailDkDto);
			}
		}
		resultList.sort((o1, o2) -> {
			String creationTime1 = o1.getCreationTime();
			String creationTime2 = o2.getCreationTime();
			return creationTime2.compareTo(creationTime1);
		});
		resultData.setList(resultList);
		return ErpResponseJson.ok(resultData);
	}
	/**
	 * 根据组织ID拼where条件 eg:  ((ORGANIZATION_PATH LIKE '%:12345:12346:12347:%') OR (ORGANIZATION_PATH LIKE '%:22345:22346:22347:%'))
	 * @param cityId
	 * @param compId
	 * @param orgIds
	 * @param columnName
	 * @return
	 */
	String getPathLikeWhereCause(Integer cityId, Integer compId, Set<Integer> orgIds,String columnName) {
		Assert.isEmptyThrow(orgIds, "组织ID为空");
		List<ErpFunOrganization> vos = erpFunOrganizationMapper.selectOrgByOrgIds(cityId, compId, new ArrayList<>(orgIds));
		Assert.isEmptyThrow(vos, "未找到组织");

		String columnField = Optional.ofNullable(columnName).filter(StringUtil::isNotBlank).orElse("ORGANIZATION_PATH");
		List<String> sqlList = new ArrayList<>();
		for (ErpFunOrganization vo : vos) {
			sqlList.add("("+columnName + " LIKE %" + vo.getOrganizationPath() + "%)");
		}
		return String.format("(%s)", String.join(" OR ", sqlList));
	}
	
	/**
	 * 掌通运营分析排行榜详情:钥匙
	 * @author 朱科
	 * @since 2018年10月22日
	 * @return
	 */
	@ApiOperation("掌通排行榜点击进入详情,需求=8769，作者：朱科")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = AppAchieveMonthStatisticsRankDetailYsVo.class, message = "成功")
	})
	@ResponseBody
	@PostMapping("/getAppAchieveMonthStatisticsRankDetailYs")
	public ErpResponseJson getAppAchieveMonthStatisticsRankDetailYs(@RequestBody AppAchieveMonthStatisticsRankDetailParam param) throws Exception{
		AppAchieveMonthStatisticsRankDetailYsVo resultData = new AppAchieveMonthStatisticsRankDetailYsVo();
		List<AppAchieveMonthStatisticsRankDetailYsDto> resultList = new ArrayList<AppAchieveMonthStatisticsRankDetailYsDto>();
		// 钥匙提交详情 FUN_STATISTIC_DETAIL_11
		Integer statisticType = 11; // 钥匙提交详情
		Operator operator = getOperator();
		//-----------------------新版组织机构---------------------
		if (operator.newOrganizationType()) {
			return getAppAchieveMonthStatisticsRankDetailYsForOrg(param);
		}
		//-----------------------新版组织机构---------------------
		Integer compId = operator.getCompId();
		Integer areaId = operator.getAreaId();
		Integer regId = operator.getRegId();
		Integer selfDeptId = operator.getDeptId();
		Integer grId = operator.getGrId();
		Integer userId = operator.getUserId();
		Integer cityId = operator.getCityId();
		Integer deptId = param.getDeptId();
		Integer lookType = param.getLookType();
		Integer lookTypeId = param.getLookTypeId();
		String assessmentMonth = param.getAssessmentMonth();
		Integer caseType = param.getCaseType();
		if(null == caseType){
			caseType = Const.DIC_CASE_TYPE_SALE_FUN; // 默认出售
		}
		String endTime = "";
		if(StringUtil.isNotBlank(assessmentMonth)){
			String year = assessmentMonth.substring(0,4); // year
			String month = assessmentMonth.substring(5, 7); // month
			endTime = DateConvert.getLastDayOfMonth(StringUtil.parseInteger(year,2018), StringUtil.parseInteger(month,8)) + "23:59:59";
		} else {
			String startTime = param.getStartTime();
			if(StringUtil.isNotBlank(startTime)){
				assessmentMonth = startTime;
			}
			if(StringUtil.isNotBlank(param.getEndTime())){
				endTime = param.getEndTime() + " 23:59:59";
			}
		}
		//加盟商范围
		List<Integer> partnerIds = deducePartnerWageRange(operator);
		// 获取自己的列表查看权
		Integer[] lookRange = this.getSelfLookRange(cityId, compId, areaId, regId, selfDeptId, grId, userId, caseType);
		Integer trueViewRang = lookRange[0];
		Integer trueViewRangId = lookRange[1];
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<ReportFunStatisticDetail1> deatailList = reportFunStatisticDetail1Mapper.getAppAchieveMonthStatisticsRankDetailHouseAdd(compId,partnerIds, assessmentMonth, endTime, lookType, lookTypeId, statisticType, caseType, selfDeptId, deptId);
		if(null == deatailList || deatailList.isEmpty()){
			return ErpResponseJson.ok(resultData);
		}
		List<ErpFunDepts> deptsList = erpFunDeptsMapper.getCacheableDeptListByCompId(cityId, compId);
		Map<Integer, String> deptsMap = deptsList.stream().collect(Collectors.toMap(ErpFunDepts::getDeptId, ErpFunDepts::getDeptName));
		Set<Integer> lookSet = new HashSet<>();
		lookSet.add(lookTypeId);
		List<ErpFunUsers> usersList = erpFunUsersMapper.selectUserList(cityId, compId, deptId, lookType, lookSet, assessmentMonth);
		Map<Integer, String> usersMap = usersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, ErpFunUsers::getUserName));
		//
//		Set<String> detailSet = new HashSet<>();
//		deatailList.forEach(reportFunStatisticDetail1 -> {
//			Integer caseId = reportFunStatisticDetail1.getCaseId();
//			Integer caseUserId = reportFunStatisticDetail1.getCaseUserId();
//			detailSet.add(caseId + "_" + caseUserId);
//		});
		// 
		Set<Integer> caseIds = deatailList.stream().collect(Collectors.mapping(ReportFunStatisticDetail1::getCaseId, Collectors.toSet()));
		List<ErpFunTrack> tracksList = erpFunTrackMapper.getYsTrackByCaseIds(cityId, compId, caseIds, caseType, Const.DIC_TRACK_TYPE_SUBMIT_KEY);
		// 一人一房，一个跟进
		if(null == tracksList || tracksList.isEmpty()){
			return ErpResponseJson.ok(resultData);
		}
		Map<String, Integer> trackMap = new HashMap<>();
		tracksList.forEach(erpFunTrack -> {
			Integer caseId = erpFunTrack.getCaseId();
			Integer creatorUid = erpFunTrack.getCreatorUid();
			trackMap.put(caseId + "_" + creatorUid, erpFunTrack.getTrackId());
		});
		Set<Integer> trackIdsSet = new HashSet<>();
		for (Entry<String, Integer> trackId : trackMap.entrySet()) {
			trackIdsSet.add(trackId.getValue());
		}
		// 查询钥匙相关信息
		ErpFunKeyExample example = new ErpFunKeyExample();
		example.createCriteria().andCompIdEqualTo(compId).andTrackIdIn(new ArrayList<>(trackIdsSet));
		example.setShardCityId(cityId);
		List<ErpFunKey> funKeyList = erpFunKeyMapper.selectByExample(example);
		Map<Integer, ErpFunKey> keyMap = funKeyList.stream().collect(Collectors.toMap(ErpFunKey::getTrackId, val -> val));
		// 最终的返回跟进
//		Set<Integer> resultTrackIds = new HashSet<>();
//		for(String key: detailSet){
//			resultTrackIds.add(trackMap.get(key));
//		}
		ErpFunTrackExample erpFunTrackExample = new ErpFunTrackExample();
		erpFunTrackExample.createCriteria().andCompIdEqualTo(compId).andTrackIdIn(new ArrayList<>(trackIdsSet));
		erpFunTrackExample.setShardCityId(cityId);
		List<ErpFunTrack> resultTrackList = erpFunTrackMapper.selectByExample(erpFunTrackExample);
		// 最终返回的数据
		if(Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)){
			List<ErpFunSale> saleList = erpFunSaleMapper.getAppAchieveMonthStatisticsRankDetailHouseAdd(cityId, compId, caseIds, trueViewRang, trueViewRangId, deptId);
			Map<Integer, ErpFunSale> saleMap = saleList.stream().collect(Collectors.toMap(ErpFunSale::getSaleId, val -> val));
			for (ErpFunTrack erpFunTrack : resultTrackList) {
				ErpFunSale erpFunSale = saleMap.get(erpFunTrack.getCaseId());
				if(null == erpFunSale){
					continue;
				}
				AppAchieveMonthStatisticsRankDetailYsDto achieveMonthStatisticsRankDetailYsDto = new AppAchieveMonthStatisticsRankDetailYsDto();
				// 房源属性
				achieveMonthStatisticsRankDetailYsDto.setBuildId(erpFunSale.getSaleId());
				achieveMonthStatisticsRankDetailYsDto.setBuildName(erpFunSale.getBuildName());
				achieveMonthStatisticsRankDetailYsDto.setCaseId(erpFunTrack.getCaseId());
				achieveMonthStatisticsRankDetailYsDto.setCaseType(caseType);
				achieveMonthStatisticsRankDetailYsDto.setHouseArea(erpFunSale.getSaleArea());
				achieveMonthStatisticsRankDetailYsDto.setHouseRoom(erpFunSale.getSaleRoom());
				achieveMonthStatisticsRankDetailYsDto.setHouseHall(erpFunSale.getSaleHall());
				achieveMonthStatisticsRankDetailYsDto.setHouseTotalPrice(erpFunSale.getSaleTotalPrice());
				achieveMonthStatisticsRankDetailYsDto.setHouseLowestPrice(erpFunSale.getSaleLowestPrice());
				achieveMonthStatisticsRankDetailYsDto.setHouseUseage(erpFunSale.getSaleUseage());
				achieveMonthStatisticsRankDetailYsDto.setRegionName(erpFunSale.getRegionName());
				achieveMonthStatisticsRankDetailYsDto.setSectionName(erpFunSale.getSectionName());
				// 跟进创建人属性
				achieveMonthStatisticsRankDetailYsDto.setCreationTime(DateTimeHelper.formatDateTimetoString(erpFunTrack.getCreationTime()));
				achieveMonthStatisticsRankDetailYsDto.setDeptId(erpFunTrack.getDeptId());
				achieveMonthStatisticsRankDetailYsDto.setDeptName(deptsMap.get(erpFunTrack.getDeptId()));
				achieveMonthStatisticsRankDetailYsDto.setUserId(erpFunTrack.getCreatorUid());
				achieveMonthStatisticsRankDetailYsDto.setUserName(usersMap.get(erpFunTrack.getCreatorUid()));
				ErpFunKey erpFunKey = keyMap.get(erpFunTrack.getTrackId());
				if(null != erpFunKey){
					achieveMonthStatisticsRankDetailYsDto.setKeyNo(erpFunKey.getKeyNum());
					if(null != erpFunKey.getKeyDeptId()){
						achieveMonthStatisticsRankDetailYsDto.setKeyDeptId(erpFunKey.getKeyDeptId());
						String keyDeptName = deptsMap.get(erpFunKey.getKeyDeptId());
						achieveMonthStatisticsRankDetailYsDto.setKeyDeptName(keyDeptName);
					}
				}
				resultList.add(achieveMonthStatisticsRankDetailYsDto);
			}
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)){
			List<ErpFunLease> leaseList = erpFunLeaseMapper.getAppAchieveMonthStatisticsRankDetailHouseAdd(cityId, compId, caseIds, trueViewRang, trueViewRangId, deptId);
			Map<Integer, ErpFunLease> leaseMap = leaseList.stream().collect(Collectors.toMap(ErpFunLease::getLeaseId, val -> val));
			for (ErpFunTrack erpFunTrack : resultTrackList) {
				ErpFunLease erpFunLease = leaseMap.get(erpFunTrack.getCaseId());
				if(null == erpFunLease){
					continue;
				}
				AppAchieveMonthStatisticsRankDetailYsDto achieveMonthStatisticsRankDetailYsDto = new AppAchieveMonthStatisticsRankDetailYsDto();
				// 房源属性
				achieveMonthStatisticsRankDetailYsDto.setBuildId(erpFunLease.getLeaseId());
				achieveMonthStatisticsRankDetailYsDto.setBuildName(erpFunLease.getBuildName());
				achieveMonthStatisticsRankDetailYsDto.setCaseId(erpFunTrack.getCaseId());
				achieveMonthStatisticsRankDetailYsDto.setCaseType(caseType);
				achieveMonthStatisticsRankDetailYsDto.setHouseArea(erpFunLease.getLeaseArea());
				achieveMonthStatisticsRankDetailYsDto.setHouseRoom(erpFunLease.getLeaseRoom());
				achieveMonthStatisticsRankDetailYsDto.setHouseHall(erpFunLease.getLeaseHall());
				achieveMonthStatisticsRankDetailYsDto.setHouseTotalPrice(erpFunLease.getLeaseTotalPrice());
				achieveMonthStatisticsRankDetailYsDto.setHouseLowestPrice(erpFunLease.getLeaseLowestPrice());
				achieveMonthStatisticsRankDetailYsDto.setHouseUseage(erpFunLease.getLeaseUseage());
				achieveMonthStatisticsRankDetailYsDto.setRegionName(erpFunLease.getRegionName());
				achieveMonthStatisticsRankDetailYsDto.setSectionName(erpFunLease.getSectionName());
				achieveMonthStatisticsRankDetailYsDto.setPriceUnit(erpFunLease.getPriceUnit());
				// 跟进创建人属性
				achieveMonthStatisticsRankDetailYsDto.setCreationTime(DateTimeHelper.formatDateTimetoString(erpFunTrack.getCreationTime()));
				achieveMonthStatisticsRankDetailYsDto.setDeptId(erpFunTrack.getDeptId());
				achieveMonthStatisticsRankDetailYsDto.setDeptName(deptsMap.get(erpFunTrack.getDeptId()));
				achieveMonthStatisticsRankDetailYsDto.setUserId(erpFunTrack.getCreatorUid());
				achieveMonthStatisticsRankDetailYsDto.setUserName(usersMap.get(erpFunTrack.getCreatorUid()));
				ErpFunKey erpFunKey = keyMap.get(erpFunTrack.getTrackId());
				if(null != erpFunKey){
					achieveMonthStatisticsRankDetailYsDto.setKeyNo(erpFunKey.getKeyNum());
					if(null != erpFunKey.getKeyDeptId()){
						achieveMonthStatisticsRankDetailYsDto.setKeyDeptId(erpFunKey.getKeyDeptId());
						String keyDeptName = deptsMap.get(erpFunKey.getKeyDeptId());
						achieveMonthStatisticsRankDetailYsDto.setKeyDeptName(keyDeptName);
					}
				}
				resultList.add(achieveMonthStatisticsRankDetailYsDto);
			}
		}
		resultList.sort((o1, o2) -> {
			String creationTime1 = o1.getCreationTime();
			String creationTime2 = o2.getCreationTime();
			return creationTime2.compareTo(creationTime1);
		});
		resultData.setList(resultList);
		return ErpResponseJson.ok(resultData);
	}


	public ErpResponseJson getAppAchieveMonthStatisticsRankDetailYsForOrg(AppAchieveMonthStatisticsRankDetailParam param) throws Exception{
		AppAchieveMonthStatisticsRankDetailYsVo resultData = new AppAchieveMonthStatisticsRankDetailYsVo();
		List<AppAchieveMonthStatisticsRankDetailYsDto> resultList = new ArrayList<AppAchieveMonthStatisticsRankDetailYsDto>();
		resultData.setList(resultList);
		// 钥匙提交详情 FUN_STATISTIC_DETAIL_11
		Integer statisticType = 11; // 钥匙提交详情
		Operator operator = getOperator();
		Integer compId = operator.getCompId();
		Integer selfDeptId = operator.getDeptId();
		Integer userId = operator.getUserId();
		Integer cityId = operator.getCityId();
		String assessmentMonth = param.getAssessmentMonth();
		Integer caseType = param.getCaseType();
		if(null == caseType){
			caseType = Const.DIC_CASE_TYPE_SALE_FUN; // 默认出售
		}
		String endTime = "";
		if(StringUtil.isNotBlank(assessmentMonth)){
			String year = assessmentMonth.substring(0,4); // year
			String month = assessmentMonth.substring(5, 7); // month
			endTime = DateConvert.getLastDayOfMonth(StringUtil.parseInteger(year,2018), StringUtil.parseInteger(month,8)) + "23:59:59";
		} else {
			String startTime = param.getStartTime();
			if(StringUtil.isNotBlank(startTime)){
				assessmentMonth = startTime;
			}
			if(StringUtil.isNotBlank(param.getEndTime())){
				endTime = param.getEndTime() + " 23:59:59";
			}
		}
		//加盟商范围
		List<Integer> partnerIds = deducePartnerWageRange(operator);
		// 获取自己的列表查看权
		Integer defId = null;
		Integer orgId = null;
		if (param.getUserId()!=null) {
			defId = -2;
			orgId = param.getUserId();
		} else if (param.getOrganizationId() != null) {
			defId = 1;
			orgId = param.getOrganizationId();
		}
		String mangeRangeWhereCauseB= erpFunOrganizationService.getMangeRangeWhereCause(cityId, compId, operator.getUserId(), null, defId, orgId);

		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<ReportFunStatisticDetail1> deatailList = reportFunStatisticDetail1Mapper.getAppAchieveMonthStatisticsRankDetailHouseAddForOrg(cityId,compId,partnerIds, assessmentMonth, endTime, statisticType, caseType, mangeRangeWhereCauseB);
		if(null == deatailList || deatailList.isEmpty()){
			return ErpResponseJson.ok(resultData);
		}
		//组织机构查看条件
		//未指定时默认本组织
		String userManagerCause = erpFunOrganizationService.getMangeRangeWhereCause(cityId, compId, userId, null, null, null);
		List<ErpFunUsers> usersList = erpFunUsersMapper.getManagerUserListForOrg(cityId, compId, partnerIds,userManagerCause);
		Map<Integer, ErpFunUsers> userMap = usersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, Function.identity()));
		Map<Integer, String> userNameMap = usersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, ErpFunUsers::getUserName));
		Set<Integer> caseIds = deatailList.stream().map(ReportFunStatisticDetail1::getCaseId).collect(Collectors.toSet());
		List<ErpFunTrack> tracksList = erpFunTrackMapper.getYsTrackByCaseIds(cityId, compId, caseIds, caseType, Const.DIC_TRACK_TYPE_SUBMIT_KEY);
		// 一人一房，一个跟进
		if(null == tracksList || tracksList.isEmpty()){
			return ErpResponseJson.ok(resultData);
		}
		Map<String, Integer> trackMap = new HashMap<>();
		tracksList.forEach(erpFunTrack -> {
			Integer caseId = erpFunTrack.getCaseId();
			Integer creatorUid = erpFunTrack.getCreatorUid();
			trackMap.put(caseId + "_" + creatorUid, erpFunTrack.getTrackId());
		});
		Set<Integer> trackIdsSet = new HashSet<>();
		for (Entry<String, Integer> trackId : trackMap.entrySet()) {
			trackIdsSet.add(trackId.getValue());
		}
		// 查询钥匙相关信息
		ErpFunKeyExample example = new ErpFunKeyExample();
		example.createCriteria().andCompIdEqualTo(compId).andTrackIdIn(new ArrayList<>(trackIdsSet));
		example.setShardCityId(cityId);
		List<ErpFunKey> funKeyList = erpFunKeyMapper.selectByExample(example);
		Map<Integer, ErpFunKey> keyMap = funKeyList.stream().collect(Collectors.toMap(ErpFunKey::getTrackId, val -> val));
		// 最终的返回跟进
		ErpFunTrackExample erpFunTrackExample = new ErpFunTrackExample();
		erpFunTrackExample.createCriteria().andCompIdEqualTo(compId).andTrackIdIn(new ArrayList<>(trackIdsSet));
		erpFunTrackExample.setShardCityId(cityId);
		List<ErpFunTrack> resultTrackList = erpFunTrackMapper.selectByExample(erpFunTrackExample);
		//组织信息
		List<ErpFunOrganization> allOrgList = erpFunOrganizationMapper.selectOrgByOrgIds(cityId, compId, null);
		Map<Integer, ErpFunOrganization> allOrgMap = allOrgList.stream().collect(Collectors.toMap(ErpFunOrganization::getOrganizationId, Function.identity()));
		// 最终返回的数据
		if(Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)){
			List<ErpFunSale> saleList = erpFunSaleMapper.getAppAchieveMonthStatisticsRankDetailHouseAdd(cityId, compId, caseIds, null, null, null);
			Map<Integer, ErpFunSale> saleMap = saleList.stream().collect(Collectors.toMap(ErpFunSale::getSaleId, val -> val));
			for (ErpFunTrack erpFunTrack : resultTrackList) {
				ErpFunSale erpFunSale = saleMap.get(erpFunTrack.getCaseId());
				if(null == erpFunSale){continue;}
				AppAchieveMonthStatisticsRankDetailYsDto achieveMonthStatisticsRankDetailYsDto = new AppAchieveMonthStatisticsRankDetailYsDto();
				// 房源属性
				achieveMonthStatisticsRankDetailYsDto.setBuildId(erpFunSale.getSaleId());
				achieveMonthStatisticsRankDetailYsDto.setBuildName(erpFunSale.getBuildName());
				achieveMonthStatisticsRankDetailYsDto.setCaseId(erpFunTrack.getCaseId());
				achieveMonthStatisticsRankDetailYsDto.setCaseType(caseType);
				achieveMonthStatisticsRankDetailYsDto.setHouseArea(erpFunSale.getSaleArea());
				achieveMonthStatisticsRankDetailYsDto.setHouseRoom(erpFunSale.getSaleRoom());
				achieveMonthStatisticsRankDetailYsDto.setHouseHall(erpFunSale.getSaleHall());
				achieveMonthStatisticsRankDetailYsDto.setHouseTotalPrice(erpFunSale.getSaleTotalPrice());
				achieveMonthStatisticsRankDetailYsDto.setHouseLowestPrice(erpFunSale.getSaleLowestPrice());
				achieveMonthStatisticsRankDetailYsDto.setHouseUseage(erpFunSale.getSaleUseage());
				achieveMonthStatisticsRankDetailYsDto.setRegionName(erpFunSale.getRegionName());
				achieveMonthStatisticsRankDetailYsDto.setSectionName(erpFunSale.getSectionName());
				// 跟进创建人属性
				achieveMonthStatisticsRankDetailYsDto.setCreationTime(DateTimeHelper.formatDateTimetoString(erpFunTrack.getCreationTime()));
				//
				ErpFunUsers user = userMap.get(erpFunTrack.getCreatorUid());
				if (user == null) {continue;}
				ErpFunOrganization org = allOrgMap.get(user.getOrganizationId());
				if (org == null) {continue;}
				achieveMonthStatisticsRankDetailYsDto.setOrganizationId(org.getOrganizationId());
				achieveMonthStatisticsRankDetailYsDto.setUserId(erpFunTrack.getCreatorUid());
				achieveMonthStatisticsRankDetailYsDto.setUserName(userNameMap.get(erpFunTrack.getCreatorUid()));
				ErpFunKey erpFunKey = keyMap.get(erpFunTrack.getTrackId());
				if(null != erpFunKey){
					achieveMonthStatisticsRankDetailYsDto.setKeyNo(erpFunKey.getKeyNum());
					if(null != erpFunKey.getUserId()){
						ErpFunUsers keyUser = userMap.get(erpFunKey.getUserId());
						ErpFunOrganization keyOrg = Optional.ofNullable(keyUser).map(ErpFunUsers::getOrganizationId).map(allOrgMap::get).orElse(null);
						Optional.ofNullable(keyOrg).map(ErpFunOrganization::getOrganizationId).ifPresent(achieveMonthStatisticsRankDetailYsDto::setOrganizationId);
					}
				}
				resultList.add(achieveMonthStatisticsRankDetailYsDto);
			}
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)){
			List<ErpFunLease> leaseList = erpFunLeaseMapper.getAppAchieveMonthStatisticsRankDetailHouseAdd(cityId, compId, caseIds, null, null, null);
			Map<Integer, ErpFunLease> leaseMap = leaseList.stream().collect(Collectors.toMap(ErpFunLease::getLeaseId, val -> val));
			for (ErpFunTrack erpFunTrack : resultTrackList) {
				ErpFunLease erpFunLease = leaseMap.get(erpFunTrack.getCaseId());
				if(null == erpFunLease){
					continue;
				}
				AppAchieveMonthStatisticsRankDetailYsDto achieveMonthStatisticsRankDetailYsDto = new AppAchieveMonthStatisticsRankDetailYsDto();
				// 房源属性
				achieveMonthStatisticsRankDetailYsDto.setBuildId(erpFunLease.getLeaseId());
				achieveMonthStatisticsRankDetailYsDto.setBuildName(erpFunLease.getBuildName());
				achieveMonthStatisticsRankDetailYsDto.setCaseId(erpFunTrack.getCaseId());
				achieveMonthStatisticsRankDetailYsDto.setCaseType(caseType);
				achieveMonthStatisticsRankDetailYsDto.setHouseArea(erpFunLease.getLeaseArea());
				achieveMonthStatisticsRankDetailYsDto.setHouseRoom(erpFunLease.getLeaseRoom());
				achieveMonthStatisticsRankDetailYsDto.setHouseHall(erpFunLease.getLeaseHall());
				achieveMonthStatisticsRankDetailYsDto.setHouseTotalPrice(erpFunLease.getLeaseTotalPrice());
				achieveMonthStatisticsRankDetailYsDto.setHouseLowestPrice(erpFunLease.getLeaseLowestPrice());
				achieveMonthStatisticsRankDetailYsDto.setHouseUseage(erpFunLease.getLeaseUseage());
				achieveMonthStatisticsRankDetailYsDto.setRegionName(erpFunLease.getRegionName());
				achieveMonthStatisticsRankDetailYsDto.setSectionName(erpFunLease.getSectionName());
				achieveMonthStatisticsRankDetailYsDto.setPriceUnit(erpFunLease.getPriceUnit());
				// 跟进创建人属性
				achieveMonthStatisticsRankDetailYsDto.setCreationTime(DateTimeHelper.formatDateTimetoString(erpFunTrack.getCreationTime()));
				ErpFunUsers user = userMap.get(erpFunTrack.getCreatorUid());
				Optional<ErpFunOrganization> erpFunOrganization = Optional.ofNullable(user).map(ErpFunUsers::getOrganizationId).map(allOrgMap::get);
				if (erpFunOrganization.isPresent()) {
					achieveMonthStatisticsRankDetailYsDto.setDeptName(erpFunOrganization.get().getOrganizationName());
					achieveMonthStatisticsRankDetailYsDto.setOrganizationId(erpFunOrganization.get().getOrganizationId());
					achieveMonthStatisticsRankDetailYsDto.setOrganizationName(erpFunOrganization.get().getOrganizationName());
				}
				achieveMonthStatisticsRankDetailYsDto.setUserId(erpFunTrack.getCreatorUid());
				achieveMonthStatisticsRankDetailYsDto.setUserName(userNameMap.get(erpFunTrack.getCreatorUid()));
				ErpFunKey erpFunKey = keyMap.get(erpFunTrack.getTrackId());
				if(null != erpFunKey){
					achieveMonthStatisticsRankDetailYsDto.setKeyNo(erpFunKey.getKeyNum());
					if(null != erpFunKey.getUserId()){
						ErpFunUsers keyUser = userMap.get(erpFunKey.getUserId());
						ErpFunOrganization keyOrg = Optional.ofNullable(keyUser).map(ErpFunUsers::getOrganizationId).map(allOrgMap::get).orElse(null);
						Optional.ofNullable(keyOrg).map(ErpFunOrganization::getOrganizationId).ifPresent(achieveMonthStatisticsRankDetailYsDto::setOrganizationId);
					}
				}
				resultList.add(achieveMonthStatisticsRankDetailYsDto);
			}
		}
		resultList.sort((o1, o2) -> {
			String creationTime1 = o1.getCreationTime();
			String creationTime2 = o2.getCreationTime();
			return creationTime2.compareTo(creationTime1);
		});
		resultData.setList(resultList);
		return ErpResponseJson.ok(resultData);
	}
	
	/**
	 * 掌通运营分析排行榜详情:房勘
	 * @author 朱科
	 * @since 2018年10月22日
	 * @return
	 */
	@ApiOperation("掌通排行榜点击进入详情,需求=8769，作者：朱科")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = AppAchieveMonthStatisticsRankDetailFunCanVo.class, message = "成功")
	})
	@ResponseBody
	@PostMapping("/getAppAchieveMonthStatisticsRankDetailFunCan")
	public ErpResponseJson getAppAchieveMonthStatisticsRankDetailFunCan(@RequestBody AppAchieveMonthStatisticsRankDetailParam param) throws Exception{
		if (getOperator().newOrganizationType()) {
			return getDetailFunCanData(param);
		}
		AppAchieveMonthStatisticsRankDetailFunCanVo resultData = new AppAchieveMonthStatisticsRankDetailFunCanVo();
		List<AppAchieveMonthStatisticsRankDetailFunCanDto> resultList = new ArrayList<AppAchieveMonthStatisticsRankDetailFunCanDto>();
		// 房勘详情 FUN_STATISTIC_DETAIL_10
		Integer statisticType = 10; // 房勘详情
		Operator operator = getOperator();
		Integer compId = operator.getCompId();
		Integer areaId = operator.getAreaId();
		Integer regId = operator.getRegId();
		Integer selfDeptId = operator.getDeptId();
		Integer grId = operator.getGrId();
		Integer userId = operator.getUserId();
		Integer cityId = operator.getCityId();
		String selfUserName = operator.getUserName();
		Integer deptId = param.getDeptId();
		Integer lookType = param.getLookType();
		Integer lookTypeId = param.getLookTypeId();
		String assessmentMonth = param.getAssessmentMonth();
		Integer caseType = param.getCaseType();
		if (null == caseType) {
			caseType = Const.DIC_CASE_TYPE_SALE_FUN; // 默认出售
		}
		String endTime = "";
		if (StringUtil.isNotBlank(assessmentMonth)) {
			String year = assessmentMonth.substring(0,4); // year
			String month = assessmentMonth.substring(5, 7); // month
			endTime = DateConvert.getLastDayOfMonth(StringUtil.parseInteger(year, 2019), StringUtil.parseInteger(month, 1)) + "23:59:59";
		} else {
			String startTime = param.getStartTime();
			if (StringUtil.isNotBlank(startTime)) {
				assessmentMonth = startTime;
			}
			if (StringUtil.isNotBlank(param.getEndTime())) {
				endTime = param.getEndTime() + " 23:59:59";
			}
		}
		//加盟商范围
		List<Integer> partnerIds = deducePartnerWageRange(operator);
		// 获取自己的列表查看权
		Integer[] lookRange = this.getSelfLookRange(cityId, compId, areaId, regId, selfDeptId, grId, userId, caseType);
		Integer trueViewRang = lookRange[0];
		Integer trueViewRangId = lookRange[1];
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<ReportFunStatisticDetail1> deatailList = reportFunStatisticDetail1Mapper.getAppAchieveMonthStatisticsRankDetailHouseAdd(compId, partnerIds, assessmentMonth, endTime, lookType, lookTypeId, statisticType, caseType, selfDeptId, deptId);
		if(null == deatailList || deatailList.isEmpty()){
			return ErpResponseJson.ok(resultData);
		}
		//
		List<ErpFunDepts> deptsList = erpFunDeptsMapper.getCacheableDeptListByCompId(cityId, compId);
		Map<Integer, String> deptsMap = deptsList.stream().collect(Collectors.toMap(ErpFunDepts::getDeptId, ErpFunDepts::getDeptName));
		Set<Integer> lookSet = new HashSet<>();
		lookSet.add(lookTypeId);
		List<ErpFunUsers> usersList = erpFunUsersMapper.selectUserList(cityId, compId, deptId, lookType, lookSet, assessmentMonth);
		Map<Integer, String> usersMap = usersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, ErpFunUsers::getUserName));
		//
		Set<Integer> caseIds = deatailList.stream().collect(Collectors.mapping(ReportFunStatisticDetail1::getCaseId, Collectors.toSet()));
		List<ErpFunTrack> tracksList = erpFunTrackMapper.getFunTrackByCaseIds(cityId, compId, caseIds, caseType, Const.DIC_TRACK_TYPE_FUNCAN, null, null, null, null, null);
		// 一房一人一天
		Set<Integer> trackIds = tracksList.stream().collect(Collectors.mapping(ErpFunTrack::getTrackId, Collectors.toSet()));
		List<ErpFunTrackExtend> trackExtendList = erpFunTrackExtendMapper.getFunTrackExtendListByTrackIds(cityId, compId, trackIds);
		Map<Integer, ErpFunTrackExtend> trackExtendMap = trackExtendList.stream().collect(Collectors.toMap(ErpFunTrackExtend::getTrackId, val -> val));
		Map<String, List<ErpFunTrack>> trackMap = new HashMap<>();
		Map<Integer, Integer> caseMap = new HashMap<>();
		tracksList.forEach(erpFunTrack -> {
			String creationTime = erpFunTrack.getCreationTime();
			try {
				creationTime = DateTimeHelper.formatDatetoString(creationTime);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Integer caseId = erpFunTrack.getCaseId();
			caseMap.put(erpFunTrack.getTrackId(), caseId);
			Integer creatorUid = erpFunTrack.getCreatorUid();
			String key = caseId + "_" + creatorUid + "_" + creationTime;
			List<ErpFunTrack> list = trackMap.get(key);
			if (null == list) {
				list = new ArrayList<>();
			}
			list.add(erpFunTrack);
			trackMap.put(key, list);
		});
		if(trackMap.isEmpty()){
			return ErpResponseJson.ok(resultData);
		}
		// 最终返回的数据
		if(Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)){
			List<ErpFunSale> saleList = erpFunSaleMapper.getAppAchieveMonthStatisticsRankDetailHouseAdd(cityId, compId, caseIds, trueViewRang, trueViewRangId, deptId);
			Map<Integer, ErpFunSale> saleMap = saleList.stream().collect(Collectors.toMap(ErpFunSale::getSaleId, val -> val));
			for (Entry<String, List<ErpFunTrack>> tracks : trackMap.entrySet()) {
				List<ErpFunTrack> trackSubList = tracks.getValue();
				if(trackSubList.isEmpty()){
					continue;
				}
				Integer caseId = trackSubList.get(0).getCaseId();
				ErpFunSale erpFunSale = saleMap.get(caseId);
				if(null == erpFunSale){
					continue;
				}
				AppAchieveMonthStatisticsRankDetailFunCanDto funCandata = new AppAchieveMonthStatisticsRankDetailFunCanDto();
				funCandata.setBuildId(caseId);
				funCandata.setBuildName(erpFunSale.getBuildName());
				funCandata.setCaseId(caseId);
				funCandata.setCaseType(caseType);
				funCandata.setHouseArea(erpFunSale.getSaleArea());
				funCandata.setHouseRoom(erpFunSale.getSaleRoom());
				funCandata.setHouseHall(erpFunSale.getSaleHall());
				funCandata.setHouseTotalPrice(erpFunSale.getSaleTotalPrice());
				funCandata.setHouseLowestPrice(erpFunSale.getSaleLowestPrice());
				funCandata.setHouseUseage(erpFunSale.getSaleUseage());
				funCandata.setRegionName(erpFunSale.getRegionName());
				funCandata.setSectionName(erpFunSale.getSectionName());
				funCandata.setCreationTime(trackSubList.get(0).getCreationTime());
				List<AppAchieveMonthStatisticsRankDetailFunCanSubDto> subList = new ArrayList<AppAchieveMonthStatisticsRankDetailFunCanSubDto>();
				for (ErpFunTrack erpFunTrack : trackSubList) {
					AppAchieveMonthStatisticsRankDetailFunCanSubDto subData = new AppAchieveMonthStatisticsRankDetailFunCanSubDto();
					subData.setCaseId(caseId);
					subData.setCaseType(caseType);
					subData.setTrackId(erpFunTrack.getTrackId());
					subData.setDeptId(erpFunTrack.getDeptId());
					subData.setDeptName(deptsMap.get(erpFunTrack.getDeptId()));
					subData.setUserId(erpFunTrack.getCreatorUid());
					subData.setUserName(StringUtil.isBlank(usersMap.get(erpFunTrack.getCreatorUid()))?selfUserName:usersMap.get(erpFunTrack.getCreatorUid()));
					subData.setCreationTime(DateTimeHelper.formatDateTimetoString(erpFunTrack.getCreationTime()));
					subData.setTrackResult(erpFunTrack.getTrackResult());
					subData.setFkPhotoCount(erpFunTrack.getFkPhotoCount());
					subData.setVrPhoto(erpFunTrack.getVrPhoto());
					subData.setTrackType(erpFunTrack.getTrackType());
					ErpFunTrackExtend erpFunTrackExtend = trackExtendMap.get(erpFunTrack.getTrackId());
					if(null != erpFunTrackExtend){
						subData.setCoreSellPoint(erpFunTrackExtend.getCoreSellPoint());
						subData.setFitmentDescribe(erpFunTrackExtend.getFitmentDescribe());
						subData.setLayoutIntroduce(erpFunTrackExtend.getLayoutIntroduce());
						subData.setPropertyRights(erpFunTrackExtend.getPropertyRights());
						subData.setOtherInfo(erpFunTrackExtend.getOtherInfo());
					}
					subList.add(subData);
				}
				funCandata.setList(subList);
				resultList.add(funCandata);
			}
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)){
			List<ErpFunLease> leaseList = erpFunLeaseMapper.getAppAchieveMonthStatisticsRankDetailHouseAdd(cityId, compId, caseIds, trueViewRang, trueViewRangId, deptId);
			Map<Integer, ErpFunLease> leaseMap = leaseList.stream().collect(Collectors.toMap(ErpFunLease::getLeaseId, val -> val));
			for (Entry<String, List<ErpFunTrack>> tracks : trackMap.entrySet()) {
				List<ErpFunTrack> trackSubList = tracks.getValue();
				if(trackSubList.isEmpty()){
					continue;
				}
				Integer caseId = trackSubList.get(0).getCaseId();
				ErpFunLease erpFunLease = leaseMap.get(caseId);
				if(null == erpFunLease){
					continue;
				}
				AppAchieveMonthStatisticsRankDetailFunCanDto funCandata = new AppAchieveMonthStatisticsRankDetailFunCanDto();
				funCandata.setBuildId(erpFunLease.getLeaseId());
				funCandata.setBuildName(erpFunLease.getBuildName());
				funCandata.setCaseId(caseId);
				funCandata.setCaseType(caseType);
				funCandata.setHouseArea(erpFunLease.getLeaseArea());
				funCandata.setHouseRoom(erpFunLease.getLeaseRoom());
				funCandata.setHouseHall(erpFunLease.getLeaseHall());
				funCandata.setHouseTotalPrice(erpFunLease.getLeaseTotalPrice());
				funCandata.setHouseLowestPrice(erpFunLease.getLeaseLowestPrice());
				funCandata.setHouseUseage(erpFunLease.getLeaseUseage());
				funCandata.setRegionName(erpFunLease.getRegionName());
				funCandata.setSectionName(erpFunLease.getSectionName());
				funCandata.setPriceUnit(erpFunLease.getPriceUnit());
				funCandata.setCreationTime(trackSubList.get(0).getCreationTime());
				List<AppAchieveMonthStatisticsRankDetailFunCanSubDto> subList = new ArrayList<AppAchieveMonthStatisticsRankDetailFunCanSubDto>();
				for (ErpFunTrack erpFunTrack : trackSubList) {
					AppAchieveMonthStatisticsRankDetailFunCanSubDto subData = new AppAchieveMonthStatisticsRankDetailFunCanSubDto();
					subData.setCaseId(caseId);
					subData.setCaseType(caseType);
					subData.setTrackId(erpFunTrack.getTrackId());
					subData.setDeptId(erpFunTrack.getDeptId());
					subData.setDeptName(deptsMap.get(erpFunTrack.getDeptId()));
					subData.setUserId(erpFunTrack.getCreatorUid());
					subData.setUserName(StringUtil.isBlank(usersMap.get(erpFunTrack.getCreatorUid()))?selfUserName:usersMap.get(erpFunTrack.getCreatorUid()));
					subData.setCreationTime(DateTimeHelper.formatDateTimetoString(erpFunTrack.getCreationTime()));
					subData.setTrackResult(erpFunTrack.getTrackResult());
					subData.setFkPhotoCount(erpFunTrack.getFkPhotoCount());
					subData.setVrPhoto(erpFunTrack.getVrPhoto());
					subData.setTrackType(erpFunTrack.getTrackType());
					ErpFunTrackExtend erpFunTrackExtend = trackExtendMap.get(erpFunTrack.getTrackId());
					if(null != erpFunTrackExtend){
						subData.setCoreSellPoint(erpFunTrackExtend.getCoreSellPoint());
						subData.setFitmentDescribe(erpFunTrackExtend.getFitmentDescribe());
						subData.setLayoutIntroduce(erpFunTrackExtend.getLayoutIntroduce());
						subData.setPropertyRights(erpFunTrackExtend.getPropertyRights());
						subData.setOtherInfo(erpFunTrackExtend.getOtherInfo());
					}
					subList.add(subData);
				}
				funCandata.setList(subList);
				resultList.add(funCandata);
			}
		}
		resultList.sort((o1, o2) -> {
			String creationTime1 = o1.getCreationTime();
			String creationTime2 = o2.getCreationTime();
			return creationTime2.compareTo(creationTime1);
		});
		resultData.setList(resultList);
		return ErpResponseJson.ok(resultData);
	}

	private ErpResponseJson getDetailFunCanData(AppAchieveMonthStatisticsRankDetailParam param) throws Exception {
		AppAchieveMonthStatisticsRankDetailFunCanVo resultData = new AppAchieveMonthStatisticsRankDetailFunCanVo();
		List<AppAchieveMonthStatisticsRankDetailFunCanDto> resultList = new ArrayList<AppAchieveMonthStatisticsRankDetailFunCanDto>();
		resultData.setList(resultList);
		// 房勘详情 FUN_STATISTIC_DETAIL_10
		Integer statisticType = 10; // 房勘详情
		Operator operator = getOperator();
		Integer compId = operator.getCompId();
		Integer cityId = operator.getCityId();
		String selfUserName = operator.getUserName();
		String assessmentMonth = param.getAssessmentMonth();
		Integer caseType = param.getCaseType();
		if (null == caseType) {
			caseType = Const.DIC_CASE_TYPE_SALE_FUN; // 默认出售
		}
		String endTime = "";
		//加盟商范围
		List<Integer> partnerIds = deducePartnerWageRange(operator);
		// 获取自己的列表查看权
		if(StringUtil.isNotBlank(assessmentMonth)){
			String year = assessmentMonth.substring(0,4); // year
			String month = assessmentMonth.substring(5, 7); // month
			endTime = DateConvert.getLastDayOfMonth(StringUtil.parseInteger(year, 2020), StringUtil.parseInteger(month, 1)) + "23:59:59";
		} else {
			String startTime = param.getStartTime();
			if(StringUtil.isNotBlank(startTime)){
				assessmentMonth = startTime;
			}
			if(StringUtil.isNotBlank(param.getEndTime())){
				endTime = param.getEndTime() + " 23:59:59";
			}
		}

		//指定人时defId=-2
		Integer defId = null;
		Integer orgId = null;
		if (null != param.getUserId()) {
			defId = -2;
			orgId = param.getUserId();
		}else if(null!=param.getOrganizationId()) {
			defId = 1;
			orgId =  param.getOrganizationId();
		}
		String mangeRangeWhereCauseB= erpFunOrganizationService.getMangeRangeWhereCause(cityId, compId, operator.getUserId(), null, defId, orgId);
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<ReportFunStatisticDetail1> datalList =reportFunStatisticDetail1Mapper.getAppAchieveMonthStatisticsRankDetailHouseAddForOrg(cityId, compId, partnerIds, assessmentMonth, endTime, statisticType, caseType,mangeRangeWhereCauseB);
        mangeRangeWhereCauseB = erpFunOrganizationService.getMangeRangeWhereCause(cityId, compId, operator.getUserId(), null, null, null);
		List<ErpFunUsers> usersList = erpFunUsersMapper.getManagerUserListForOrg(cityId, compId, partnerIds, mangeRangeWhereCauseB);
		Map<Integer, ErpFunUsers> usersMap = usersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, Function.identity()));
		Set<Integer> caseIds = datalList.stream().map(ReportFunStatisticDetail1::getCaseId).collect(Collectors.toSet());
		if (caseIds.isEmpty()) {
			return ErpResponseJson.ok(resultData);
		}
		Map<Integer, ReportFunStatisticDetail1> detailMap = datalList.stream().collect(Collectors.toMap(ReportFunStatisticDetail1::getCaseId, val -> val));
		//
		List<ErpFunTrack> tracksList = erpFunTrackMapper.getFunTrackByCaseIds(cityId, compId, caseIds, caseType, Const.DIC_TRACK_TYPE_FUNCAN, null, null, null, null, null);
		// 一房一人一天
		Set<Integer> trackIds = tracksList.stream().map(ErpFunTrack::getTrackId).collect(Collectors.toSet());
		List<ErpFunTrackExtend> trackExtendList = erpFunTrackExtendMapper.getFunTrackExtendListByTrackIds(cityId, compId, trackIds);
		Map<Integer, ErpFunTrackExtend> trackExtendMap = trackExtendList.stream().collect(Collectors.toMap(ErpFunTrackExtend::getTrackId, val -> val));
		Map<String, List<ErpFunTrack>> trackMap = new HashMap<>();
		Map<Integer, Integer> caseMap = new HashMap<>();
		tracksList.forEach(erpFunTrack -> {
			String creationTime = erpFunTrack.getCreationTime();
			try {
				creationTime = DateTimeHelper.formatDatetoString(creationTime);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Integer caseId = erpFunTrack.getCaseId();
			caseMap.put(erpFunTrack.getTrackId(), caseId);
			Integer creatorUid = erpFunTrack.getCreatorUid();
			String key = caseId + "_" + creatorUid + "_" + creationTime;
			List<ErpFunTrack> list = trackMap.get(key);
			if (null == list) {
				list = new ArrayList<>();
			}
			list.add(erpFunTrack);
			trackMap.put(key, list);
		});
		if(trackMap.isEmpty()){
			return ErpResponseJson.ok(resultData);
		}

		List<ErpFunOrganization> orgQueryList = erpFunOrganizationMapper.selectOrgByOrgIds(cityId, compId,null);
		Map<Integer,ErpFunOrganization>  orgMap = orgQueryList.stream().collect(Collectors.toMap(ErpFunOrganization::getOrganizationId,Function.identity()));

		// 最终返回的数据
		if(Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)){
			List<ErpFunSale> saleList = erpFunSaleMapper.getAppAchieveMonthStatisticsRankDetailHouseAdd(cityId, compId, caseIds, null, null, null);
			Map<Integer, ErpFunSale> saleMap = saleList.stream().collect(Collectors.toMap(ErpFunSale::getSaleId, val -> val));
			//跟进创建人的组织id
			List<Integer> uIds = tracksList.stream().map(ErpFunTrack::getCreatorUid).collect(Collectors.toList());
			for (Entry<String, List<ErpFunTrack>> tracks : trackMap.entrySet()) {
				List<ErpFunTrack> trackSubList = tracks.getValue();
				if(trackSubList.isEmpty()){
					continue;
				}
				Integer caseId = trackSubList.get(0).getCaseId();
				ErpFunSale erpFunSale = saleMap.get(caseId);
				if(null == erpFunSale){
					continue;
				}
				AppAchieveMonthStatisticsRankDetailFunCanDto funCandata = new AppAchieveMonthStatisticsRankDetailFunCanDto();
				funCandata.setBuildId(caseId);
				funCandata.setBuildName(erpFunSale.getBuildName());
				funCandata.setCaseId(caseId);
				funCandata.setCaseType(caseType);
				funCandata.setHouseArea(erpFunSale.getSaleArea());
				funCandata.setHouseRoom(erpFunSale.getSaleRoom());
				funCandata.setHouseHall(erpFunSale.getSaleHall());
				funCandata.setHouseTotalPrice(erpFunSale.getSaleTotalPrice());
				funCandata.setHouseLowestPrice(erpFunSale.getSaleLowestPrice());
				funCandata.setHouseUseage(erpFunSale.getSaleUseage());
				funCandata.setRegionName(erpFunSale.getRegionName());
				funCandata.setSectionName(erpFunSale.getSectionName());
				funCandata.setCreationTime(trackSubList.get(0).getCreationTime());
				List<AppAchieveMonthStatisticsRankDetailFunCanSubDto> subList = new ArrayList<AppAchieveMonthStatisticsRankDetailFunCanSubDto>();
				for (ErpFunTrack erpFunTrack : trackSubList) {
					AppAchieveMonthStatisticsRankDetailFunCanSubDto subData = new AppAchieveMonthStatisticsRankDetailFunCanSubDto();
					subData.setCaseId(caseId);
					subData.setCaseType(caseType);
					subData.setTrackId(erpFunTrack.getTrackId());
					ErpFunUsers erpFunUsers = usersMap.get(erpFunTrack.getCreatorUid());
					if (Objects.isNull(erpFunUsers)) {
						continue;
					}
					Integer organizationId = erpFunUsers.getOrganizationId();
					ErpFunOrganization trackCreatorOrg = orgMap.get(organizationId);
					if(trackCreatorOrg==null){
						continue;
					}
					subData.setOrganizationId(trackCreatorOrg.getOrganizationId());
					subData.setOrganizationName(trackCreatorOrg.getOrganizationName());
					subData.setUserId(erpFunTrack.getCreatorUid());
					subData.setUserName(erpFunUsers.getUserName());
					subData.setCreationTime(DateTimeHelper.formatDateTimetoString(erpFunTrack.getCreationTime()));
					subData.setTrackResult(erpFunTrack.getTrackResult());
					subData.setFkPhotoCount(erpFunTrack.getFkPhotoCount());
					subData.setVrPhoto(erpFunTrack.getVrPhoto());
					subData.setTrackType(erpFunTrack.getTrackType());
					ErpFunTrackExtend erpFunTrackExtend = trackExtendMap.get(erpFunTrack.getTrackId());
					if(null != erpFunTrackExtend){
						subData.setCoreSellPoint(erpFunTrackExtend.getCoreSellPoint());
						subData.setFitmentDescribe(erpFunTrackExtend.getFitmentDescribe());
						subData.setLayoutIntroduce(erpFunTrackExtend.getLayoutIntroduce());
						subData.setPropertyRights(erpFunTrackExtend.getPropertyRights());
						subData.setOtherInfo(erpFunTrackExtend.getOtherInfo());
					}
					subList.add(subData);
				}
				funCandata.setList(subList);
				resultList.add(funCandata);
			}
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)){
			List<ErpFunLease> leaseList = erpFunLeaseMapper.getAppAchieveMonthStatisticsRankDetailHouseAdd(cityId, compId, caseIds, null, null, null);
			Map<Integer, ErpFunLease> leaseMap = leaseList.stream().collect(Collectors.toMap(ErpFunLease::getLeaseId, val -> val));
			for (Entry<String, List<ErpFunTrack>> tracks : trackMap.entrySet()) {
				List<ErpFunTrack> trackSubList = tracks.getValue();
				if(trackSubList.isEmpty()){
					continue;
				}
				Integer caseId = trackSubList.get(0).getCaseId();
				ErpFunLease erpFunLease = leaseMap.get(caseId);
				if(null == erpFunLease){
					continue;
				}
				AppAchieveMonthStatisticsRankDetailFunCanDto funCandata = new AppAchieveMonthStatisticsRankDetailFunCanDto();
				funCandata.setBuildId(erpFunLease.getLeaseId());
				funCandata.setBuildName(erpFunLease.getBuildName());
				funCandata.setCaseId(caseId);
				funCandata.setCaseType(caseType);
				funCandata.setHouseArea(erpFunLease.getLeaseArea());
				funCandata.setHouseRoom(erpFunLease.getLeaseRoom());
				funCandata.setHouseHall(erpFunLease.getLeaseHall());
				funCandata.setHouseTotalPrice(erpFunLease.getLeaseTotalPrice());
				funCandata.setHouseLowestPrice(erpFunLease.getLeaseLowestPrice());
				funCandata.setHouseUseage(erpFunLease.getLeaseUseage());
				funCandata.setRegionName(erpFunLease.getRegionName());
				funCandata.setSectionName(erpFunLease.getSectionName());
				funCandata.setPriceUnit(erpFunLease.getPriceUnit());
				funCandata.setCreationTime(trackSubList.get(0).getCreationTime());
				List<AppAchieveMonthStatisticsRankDetailFunCanSubDto> subList = new ArrayList<AppAchieveMonthStatisticsRankDetailFunCanSubDto>();
				for (ErpFunTrack erpFunTrack : trackSubList) {
					AppAchieveMonthStatisticsRankDetailFunCanSubDto subData = new AppAchieveMonthStatisticsRankDetailFunCanSubDto();
					subData.setCaseId(caseId);
					subData.setCaseType(caseType);
					subData.setTrackId(erpFunTrack.getTrackId());
					ErpFunUsers erpFunUsers = usersMap.get(erpFunTrack.getCreatorUid());
					if (Objects.isNull(erpFunUsers)) {
						continue;
					}
					Integer organizationId = erpFunUsers.getOrganizationId();
					ErpFunOrganization trackCreatorOrg = orgMap.get(organizationId);
					if(Objects.isNull(trackCreatorOrg)){
						continue;
					}
					subData.setOrganizationId(trackCreatorOrg.getOrganizationId());
					subData.setOrganizationName(trackCreatorOrg.getOrganizationName());
					subData.setCreationTime(DateTimeHelper.formatDateTimetoString(erpFunTrack.getCreationTime()));
					subData.setTrackResult(erpFunTrack.getTrackResult());
					subData.setFkPhotoCount(erpFunTrack.getFkPhotoCount());
					subData.setVrPhoto(erpFunTrack.getVrPhoto());
					subData.setTrackType(erpFunTrack.getTrackType());
					ErpFunTrackExtend erpFunTrackExtend = trackExtendMap.get(erpFunTrack.getTrackId());
					if(null != erpFunTrackExtend){
						subData.setCoreSellPoint(erpFunTrackExtend.getCoreSellPoint());
						subData.setFitmentDescribe(erpFunTrackExtend.getFitmentDescribe());
						subData.setLayoutIntroduce(erpFunTrackExtend.getLayoutIntroduce());
						subData.setPropertyRights(erpFunTrackExtend.getPropertyRights());
						subData.setOtherInfo(erpFunTrackExtend.getOtherInfo());
					}
					subList.add(subData);
				}
				funCandata.setList(subList);
				resultList.add(funCandata);
			}
		}
		resultList.sort((o1, o2) -> {
			String creationTime1 = o1.getCreationTime();
			String creationTime2 = o2.getCreationTime();
			return creationTime2.compareTo(creationTime1);
		});
		resultData.setList(resultList);
		return ErpResponseJson.ok(resultData);
	}

	/**
	 * 获取自己的房客源列表权限
	 * @author 朱科
	 * @since 2018年10月22日
	 * @return
	 */
	public Integer[] getSelfLookRange(Integer cityId, Integer compId, Integer areaId, Integer regId, Integer deptId, Integer grId, Integer userId, Integer caseType){
		if(Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType) || Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)){
			caseType = 1;
		} else if (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType) || Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)){
			caseType = 3;
		} else {
			return null;
		}
		String lookHouseOrCustomerRange = "LOOK_HOUSE_RANGE";
		if(caseType == 3){
			lookHouseOrCustomerRange = "LOOK_CUST_RANGE";
		}
		Integer lookHouseRange = StringUtil.parseInteger(erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId,userId, lookHouseOrCustomerRange), 6);
//		String runModel = erpSysParaMapper.getParamValue(cityId, compId, "SYSTEM_RUN_MODEL");
		List<ErpUserOpers> userOpersList = erpUserOpersMapper.getListById(cityId, userId);
		Map<String, String> opersMap = userOpersList.stream().collect(Collectors.toMap(ErpUserOpers::getOperId, ErpUserOpers::getOperId));
		boolean compListFlag = false;
		boolean areaListFlag = false;
		boolean regListFlag = false;
		boolean deptListFlag = false;
		boolean groupListFlag = false;
		if(caseType == 1){
			compListFlag = (null != opersMap.get("VIEW_COMP_HOUSE_LIST_INFO"));
			areaListFlag = (null != opersMap.get("VIEW_AREA_HOUSE_LIST_INFO"));
			regListFlag = (null != opersMap.get("VIEW_REG_HOUSE_LIST_INFO"));
			deptListFlag = (null != opersMap.get("VIEW_DEPT_HOUSE_LIST_INFO"));
			groupListFlag = (null != opersMap.get("VIEW_GROUP_HOUSE_LIST_INFO"));
		} else if (caseType == 3){
			compListFlag = (null != opersMap.get("VIEW_COMP_CUST_LIST_INFO"));
			areaListFlag = (null != opersMap.get("VIEW_AREA_CUST_LIST_INFO"));
			regListFlag = (null != opersMap.get("VIEW_REG_CUST_LIST_INFO"));
			deptListFlag = (null != opersMap.get("VIEW_DEPT_CUST_LIST_INFO"));
			groupListFlag = (null != opersMap.get("VIEW_GROUP_CUST_LIST_INFO"));
		}
		Integer trueViewRang = 6;
		Integer trueViewRangId = userId;
//		if("PRIVATE".equals(runModel)){
			if(compListFlag || lookHouseRange == 1){
				trueViewRang = 1;
			} else if (areaListFlag || lookHouseRange == 2){
				trueViewRang = 2;
			} else if (regListFlag || lookHouseRange == 3){
				trueViewRang = 3;
			} else if (deptListFlag || lookHouseRange == 4){
				trueViewRang = 4;
			} else if (groupListFlag || lookHouseRange == 5){
				trueViewRang = 5;
			} 
//		} else {
//			if(compListFlag){
//				trueViewRang = lookHouseRange;
//				trueViewRangId = compId;
//			} else if(areaListFlag){
//				if(lookHouseRange >= 2){
//					trueViewRang = lookHouseRange;
//				} else{
//					trueViewRang = 2;
//				}
//			} else if(regListFlag){
//				if(lookHouseRange >= 3){
//					trueViewRang = lookHouseRange;
//				} else{
//					trueViewRang = 3;
//				}
//			} else if(deptListFlag){
//				if(lookHouseRange >= 4){
//					trueViewRang = lookHouseRange;
//				} else{
//					trueViewRang = 4;
//				}
//			} else if(groupListFlag){
//				if(lookHouseRange >= 5){
//					trueViewRang = lookHouseRange;
//				} else{
//					trueViewRang = 5;
//				}
//			}
//		}
		if(trueViewRang == 1){
			trueViewRangId = compId;
		} else if (trueViewRang == 2){
			trueViewRangId = areaId;
		} else if (trueViewRang == 3){
			trueViewRangId = regId;
		} else if (trueViewRang == 4){
			trueViewRangId = deptId;
		} else if (trueViewRang == 5){
			trueViewRangId = grId;
		}
		return new Integer[]{trueViewRang, trueViewRangId};
	}
	
	private <T> Object assembleDetailMap(T Object, String isShowCustfullname) throws Exception{
		if(Object instanceof ErpFunSale){
			AppAchieveMonthStatisticsRankDetailHouseAddDto resultData = new AppAchieveMonthStatisticsRankDetailHouseAddDto();
			ErpFunSale erpFunSale = (ErpFunSale) Object;
			resultData.setCaseType(Const.DIC_CASE_TYPE_SALE_FUN);
			resultData.setBuildId(erpFunSale.getBuildId());
			resultData.setBuildName(erpFunSale.getBuildName());
			resultData.setCaseId(erpFunSale.getSaleId());
			resultData.setUserId(erpFunSale.getUserId());
			resultData.setArchiveId(erpFunSale.getArchiveId());
			resultData.setHouseArea(erpFunSale.getSaleArea());
			resultData.setRegionName(erpFunSale.getRegionName());// erpFunSale
			resultData.setSectionName(erpFunSale.getSectionName());
			resultData.setCreationTime(DateTimeHelper.formatDateTimetoString(erpFunSale.getCreationTime()));
			resultData.setHouseUseage(erpFunSale.getSaleUseage());
			resultData.setHouseRoom(erpFunSale.getSaleRoom());
			resultData.setHouseWei(erpFunSale.getSaleWei());
			resultData.setHouseYang(erpFunSale.getSaleYang());
			resultData.setHouseHall(erpFunSale.getSaleHall());
			resultData.setHouseTotalPrice(erpFunSale.getSaleTotalPrice());
			resultData.setHouseLowestPrice(erpFunSale.getSaleLowestPrice());
			// 这里subject是标题，charact是描述。后面产品改成的标题
			resultData.setHouseCharact(erpFunSale.getSaleSubject());
			resultData.setHouseFloor(erpFunSale.getSaleFloor());
			resultData.setHouseFloors(erpFunSale.getSaleFloors());
			resultData.setThumbUrl(StringUtil.getBbsPhoto(erpFunSale.getThumbUrl()));
			return resultData;
		} else if (Object instanceof ErpFunLease){
			AppAchieveMonthStatisticsRankDetailHouseAddDto resultData = new AppAchieveMonthStatisticsRankDetailHouseAddDto();
			ErpFunLease erpFunLease = (ErpFunLease) Object;
			resultData.setCaseType(Const.DIC_CASE_TYPE_LEASE_FUN);			
			resultData.setBuildId(erpFunLease.getBuildId());
			resultData.setBuildName(erpFunLease.getBuildName());
			resultData.setCaseId(erpFunLease.getLeaseId());
			resultData.setUserId(erpFunLease.getUserId());
			resultData.setArchiveId(erpFunLease.getArchiveId());
			resultData.setHouseArea(erpFunLease.getLeaseArea());
			resultData.setRegionName(erpFunLease.getRegionName());// erpFunLease
			resultData.setSectionName(erpFunLease.getSectionName());
			resultData.setCreationTime(DateTimeHelper.formatDateTimetoString(erpFunLease.getCreationTime()));
			resultData.setHouseUseage(erpFunLease.getLeaseUseage());
			resultData.setHouseRoom(erpFunLease.getLeaseRoom());
			resultData.setHouseHall(erpFunLease.getLeaseHall());
			resultData.setHouseWei(erpFunLease.getLeaseWei());
			resultData.setHouseYang(erpFunLease.getLeaseYang());
			resultData.setHouseTotalPrice(erpFunLease.getLeaseTotalPrice());
			resultData.setHouseLowestPrice(erpFunLease.getLeaseLowestPrice());
			resultData.setPriceUnit(erpFunLease.getPriceUnit());
			// 这里subject是标题，charact是描述。后面产品改成的标题
			resultData.setHouseCharact(erpFunLease.getLeaseSubject());
			resultData.setHouseFloor(erpFunLease.getLeaseFloor());
			resultData.setHouseFloors(erpFunLease.getLeaseFloors());
			resultData.setThumbUrl(StringUtil.getBbsPhoto(erpFunLease.getThumbUrl()));
			return resultData;
		} else if (Object instanceof ErpFunBuyCustomer){
			AppAchieveMonthStatisticsRankDetailCustomerAddDto resultData = new AppAchieveMonthStatisticsRankDetailCustomerAddDto();
			ErpFunBuyCustomer erpFunBuyCustomer = (ErpFunBuyCustomer) Object;
			String buildIds = Optional.ofNullable(erpFunBuyCustomer.getBuildId()).map(String::trim).orElse("0");
			String[] ids = buildIds.split("\\s+");
			Integer buildId = StringUtil.parseInteger(ids[0], 0);
			resultData.setBuildId(buildId);
			resultData.setBuildName(erpFunBuyCustomer.getBuildName());
			resultData.setCaseType(Const.DIC_CASE_TYPE_BUY_CUST);
			resultData.setCaseId(erpFunBuyCustomer.getBuyCustId());
			resultData.setUserId(erpFunBuyCustomer.getUserId());
			resultData.setArchiveId(erpFunBuyCustomer.getArchiveId());
			resultData.setHouseAreaHigh(erpFunBuyCustomer.getHouseAreaHigh());
			resultData.setHouseAreaLow(erpFunBuyCustomer.getHouseAreaLow());
			resultData.setRegionName(erpFunBuyCustomer.getRegionName());// erpFunBuyCustomer
			resultData.setSectionName(erpFunBuyCustomer.getSectionName());
			resultData.setCreationTime(DateTimeHelper.formatDateTimetoString(erpFunBuyCustomer.getCreationTime()));
			resultData.setHouseUseage(erpFunBuyCustomer.getHouseUseage());
			resultData.setHouseRoom(erpFunBuyCustomer.getHouseRoom());
			resultData.setHouseRoom1(erpFunBuyCustomer.getHouseRoom1());
			resultData.setHouseTotalPrice(erpFunBuyCustomer.getHousePriceHigh());
			resultData.setHouseLowestPrice(erpFunBuyCustomer.getHousePriceLow());
			if(!"1".equals(isShowCustfullname) && StringUtil.isNotBlank(erpFunBuyCustomer.getBuyCustName())){
				resultData.setCustName(erpFunBuyCustomer.getBuyCustName().substring(0, 1));
			}
			Integer customerSex = (null != erpFunBuyCustomer.getBuyCustSex() && erpFunBuyCustomer.getBuyCustSex())?1:0;
			resultData.setCustomerSex(customerSex);
			return resultData;
		} else if (Object instanceof ErpFunRentCustomer){
			AppAchieveMonthStatisticsRankDetailCustomerAddDto resultData = new AppAchieveMonthStatisticsRankDetailCustomerAddDto();
			ErpFunRentCustomer erpFunRentCustomer = (ErpFunRentCustomer) Object;
			resultData.setCaseType(Const.DIC_CASE_TYPE_RENT_CUST);
			String buildIds = Optional.ofNullable(erpFunRentCustomer.getBuildId()).map(String::trim).orElse("0");
			String[] ids = buildIds.split("\\s+");
			Integer buildId = StringUtil.parseInteger(ids[0], 0);
			resultData.setBuildId(buildId);
			resultData.setBuildName(erpFunRentCustomer.getBuildName());
			resultData.setCaseId(erpFunRentCustomer.getRentCustId());
			resultData.setUserId(erpFunRentCustomer.getUserId());
			resultData.setArchiveId(erpFunRentCustomer.getArchiveId());
			resultData.setHouseAreaHigh(erpFunRentCustomer.getHouseAreaHigh());
			resultData.setHouseAreaLow(erpFunRentCustomer.getHouseAreaLow());
			resultData.setRegionName(erpFunRentCustomer.getRegionName());// erpFunRentCustomer
			resultData.setSectionName(erpFunRentCustomer.getSectionName());
			resultData.setCreationTime(DateTimeHelper.formatDateTimetoString(erpFunRentCustomer.getCreationTime()));
			resultData.setHouseUseage(erpFunRentCustomer.getHouseUseage());
			resultData.setHouseRoom(erpFunRentCustomer.getHouseRoom());
			resultData.setHouseRoom1(erpFunRentCustomer.getHouseRoom1());
			resultData.setHouseTotalPrice(erpFunRentCustomer.getHousePriceHigh());
			resultData.setHouseLowestPrice(erpFunRentCustomer.getHousePriceLow());
			if(!"1".equals(isShowCustfullname) && StringUtil.isNotBlank(erpFunRentCustomer.getRentCustName())){
				resultData.setCustName(erpFunRentCustomer.getRentCustName().substring(0, 1));
			}
			Integer customerSex = (null != erpFunRentCustomer.getRentCustSex() && erpFunRentCustomer.getRentCustSex())?1:0;
			resultData.setCustomerSex(customerSex);
			return resultData;
		}
		return null;
	}

	/**
	  * @title 掌通运营分析排行榜详情:约看
	  * @author lcb
	  * @date 2019/5/24
	  * @param
	  * @return
	  */
	@ApiOperation("掌通排行榜点击进入详情,需求=9686，作者：李成兵")
	@ApiResponses(value = {
		@ApiResponse(code = Const.ResponseCode.SUCCESS, response = AppAchieveMonthStatisticsRankDetailYkVo.class, message = "成功")
	})
	@ResponseBody
	@PostMapping("/getAppAchieveMonthStatisticsRankDetailYk")
	public ErpResponseJson getAppAchieveMonthStatisticsRankDetailYk(@RequestBody AppAchieveMonthStatisticsRankDetailParam param) throws Exception{
		AppAchieveMonthStatisticsRankDetailYkVo resultData = new AppAchieveMonthStatisticsRankDetailYkVo();
		List<AppAchieveMonthStatisticsRankDetailYkDto> resultList = new ArrayList<>();

		Operator operator = getOperator();
        if (operator.newOrganizationType()) {
            return getAppAchieveMonthStatisticsRankDetailYkForOrg(param);
        }
		Integer compId = operator.getCompId();
		Integer areaId = operator.getAreaId();
		Integer regId = operator.getRegId();
		Integer selfDeptId = operator.getDeptId();
		Integer grId = operator.getGrId();
		Integer userId = operator.getUserId();
		Integer cityId = operator.getCityId();
		Integer deptId = param.getDeptId();
		// 查看范围 2：大区 3：片区 4：门店 5：分组 6个人
		Integer lookType = param.getLookType();
		Integer lookTypeId = param.getLookTypeId();
		String assessmentMonth = param.getAssessmentMonth();
		Integer caseType = param.getCaseType();
		Assert.isTrueThrow(null == caseType, "房客类型为空");

		Set<Integer> deptIds = null;
		List<ErpFunDepts> deptList = null;
		Integer lookGrId = null;
		Integer lookUserId = null;

		//加盟商模式下各分组下查看范围
		List<Integer> partnerIds = deducePartnerWageRange(operator);
		if(lookType == 2){
			deptList = erpFunDeptsMapper.getDeptList(cityId, compId,partnerIds, "AREA_ID", lookTypeId);
		} else if (lookType == 3){
			deptList = erpFunDeptsMapper.getDeptList(cityId, compId, partnerIds, "REG_ID", lookTypeId);
		} else if (lookType == 4){
			deptIds = new HashSet<>();
			deptIds.add(lookTypeId);
		} else if (lookType == 5){
			deptIds = new HashSet<>();
			deptIds.add(deptId);
			lookGrId = lookTypeId;
		} else if (lookType == 6){
			lookUserId = lookTypeId;
		}
		if(null != deptList && !deptList.isEmpty()){
			deptIds = deptList.stream().collect(Collectors.mapping(ErpFunDepts::getDeptId, Collectors.toSet()));
		}

		// 查询时间
		String endTime = "";
		if(StringUtil.isNotBlank(assessmentMonth)){
			String year = assessmentMonth.substring(0,4); // year
			String month = assessmentMonth.substring(5, 7); // month
			endTime = DateConvert.getLastDayOfMonth(StringUtil.parseInteger(year,2018), StringUtil.parseInteger(month,8)) + "23:59:59";
		} else {
			String startTime = param.getStartTime();
			if(StringUtil.isNotBlank(startTime)){
				assessmentMonth = startTime;
			}
			if(StringUtil.isNotBlank(param.getEndTime())){
				endTime = param.getEndTime() + " 23:59:59";
			}
		}

		// 获取自己的列表查看权
		Integer[] lookRange = this.getSelfLookRange(cityId, compId, areaId, regId, selfDeptId, grId, userId, caseType);
		Integer trueViewRang = lookRange[0];
		Integer trueViewRangId = lookRange[1];

		// 带看跟进
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<ErpFunTrack> tracksList = erpFunTrackMapper.getFunTrackByCaseIds(cityId, compId, null, caseType, Const.DIC_TRACK_MAKE_LOOK, deptIds, lookGrId, lookUserId, assessmentMonth, endTime);
		if(null == tracksList || tracksList.isEmpty()){
			return ErpResponseJson.ok(resultData);
		}

		// 客源信息
		Set<Integer> caseIds = tracksList.stream().collect(Collectors.mapping(ErpFunTrack::getCaseId, Collectors.toSet()));
		// 约看Id
		List<Integer> makeLookIdSet = tracksList.stream().filter(val -> val.getMakeLookId() != null ).collect(Collectors.mapping(ErpFunTrack::getMakeLookId, Collectors.toList()));
		if(null == makeLookIdSet || makeLookIdSet.isEmpty()){
			return ErpResponseJson.ok(resultData);
		}
		// 带看房源信息
		Set<Integer> targetIds = new HashSet<>();
		// 查询房源ID
		ErpMakeLookHouseExample makeLookHouseExample = new ErpMakeLookHouseExample();
		makeLookHouseExample.setShardCityId(cityId);
		makeLookHouseExample.createCriteria().andIdIn(makeLookIdSet);
		List<ErpMakeLookHouse> erpMakeLookHouses = erpMakeLookHouseMapper.selectByExample(makeLookHouseExample);
		if(null == erpMakeLookHouses || erpMakeLookHouses.isEmpty()){
			return ErpResponseJson.ok(resultData);
		}

		Map<Integer, ErpMakeLookHouse> makeLookHouseMap = erpMakeLookHouses.stream().collect(Collectors.toMap(ErpMakeLookHouse::getId, val->val));
		// 一个约看对应多个房源
		Map<Integer, Set<Integer>> makeIdHouseIdsMap = new HashMap<>();
		// 解析房源ID
		erpMakeLookHouses.forEach(val-> {
			String houseIds = val.getHouseIds();
			if(StringUtils.isNotBlank(houseIds)) {
				Set<Integer> houseIdSet = new HashSet<>();
				String[] houseIdsArray = houseIds.split(",");
				for(String houseIdStr : houseIdsArray) {
					houseIdSet.add(Integer.valueOf(houseIdStr));
				}
				targetIds.addAll(houseIdSet);
				makeIdHouseIdsMap.put(val.getId(), houseIdSet);
			}
		});

		// 组织机构信息
		String isShowCustfullname = erpSysParaMapper.getParamValue(cityId, compId, "IS_SHOW_CUSTFULLNAME");
		List<ErpFunDepts> deptsList = erpFunDeptsMapper.getCacheableDeptListByCompId(cityId, compId);
		Map<Integer, String> deptsMap = deptsList.stream().collect(Collectors.toMap(ErpFunDepts::getDeptId, ErpFunDepts::getDeptName));
		Set<Integer> lookSet = new HashSet<>();
		lookSet.add(lookTypeId);
		List<ErpFunUsers> usersList = erpFunUsersMapper.selectUserList(cityId, compId, deptId, lookType, lookSet, assessmentMonth);
		Map<Integer, String> usersMap = usersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, ErpFunUsers::getUserName));
		
		if(Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)){
			// 客源信息
			List<ErpFunBuyCustomer> buyCustomerList = erpFunBuyCustomerMapper.getAppAchieveMonthStatisticsRankDetailCustomerAdd(cityId, compId, caseIds, trueViewRang, trueViewRangId, deptId);
			Map<Integer, ErpFunBuyCustomer> buyCustMap = buyCustomerList.stream().collect(Collectors.toMap(ErpFunBuyCustomer::getBuyCustId, val -> val));
			// 房源信息
			List<ErpFunSale> saleList = null;
			Map<Integer, ErpFunSale> saleMap = new HashMap<Integer, ErpFunSale>();
			
			//手填外部房源 没有房源id，或者房源ID为空的情况-陈文超改
			if(null != targetIds && !targetIds.isEmpty()){
				saleList = erpFunSaleMapper.getAppAchieveMonthStatisticsRankDetailHouseAdd(cityId, compId, targetIds, trueViewRang, trueViewRangId, deptId);
				saleMap = saleList.stream().collect(Collectors.toMap(ErpFunSale::getSaleId, val -> val));
			}
			
			for (ErpFunTrack erpFunTrack : tracksList) {
				Integer caseId = erpFunTrack.getCaseId();
				ErpFunBuyCustomer erpFunBuyCustomer = buyCustMap.get(caseId);
				if(null == erpFunBuyCustomer){
					continue;
				}

				// 约看记录
				ErpMakeLookHouse erpMakeLookHouse = makeLookHouseMap.get(erpFunTrack.getMakeLookId());
				if(null == erpMakeLookHouse){
					continue;
				}
				AppAchieveMonthStatisticsRankDetailYkDto appAchieveMonthStatisticsRankDetailYkDto = new AppAchieveMonthStatisticsRankDetailYkDto();
				appAchieveMonthStatisticsRankDetailYkDto.setBuildId(StringUtil.parseInteger(erpFunBuyCustomer.getBuildId()));
				appAchieveMonthStatisticsRankDetailYkDto.setBuildName(erpFunBuyCustomer.getBuildName());
				appAchieveMonthStatisticsRankDetailYkDto.setCaseId(erpFunBuyCustomer.getBuyCustId());
				appAchieveMonthStatisticsRankDetailYkDto.setCaseType(caseType);
				if(!"1".equals(isShowCustfullname) && StringUtil.isNotBlank(erpFunBuyCustomer.getBuyCustName())){
					appAchieveMonthStatisticsRankDetailYkDto.setCustName(erpFunBuyCustomer.getBuyCustName().substring(0, 1));
				}
				appAchieveMonthStatisticsRankDetailYkDto.setHouseAreaHigh(erpFunBuyCustomer.getHouseAreaHigh());
				appAchieveMonthStatisticsRankDetailYkDto.setHouseAreaLow(erpFunBuyCustomer.getHouseAreaLow());
				appAchieveMonthStatisticsRankDetailYkDto.setHouseRoom(erpFunBuyCustomer.getHouseRoom());
				appAchieveMonthStatisticsRankDetailYkDto.setHouseRoom1(erpFunBuyCustomer.getHouseRoom1());
				appAchieveMonthStatisticsRankDetailYkDto.setHouseUseage(erpFunBuyCustomer.getHouseUseage());
				appAchieveMonthStatisticsRankDetailYkDto.setRegionName(erpFunBuyCustomer.getRegionName());
				appAchieveMonthStatisticsRankDetailYkDto.setSectionName(erpFunBuyCustomer.getSectionName());
				appAchieveMonthStatisticsRankDetailYkDto.setHouseTotalPrice(erpFunBuyCustomer.getHousePriceHigh());
				appAchieveMonthStatisticsRankDetailYkDto.setHouseLowestPrice(erpFunBuyCustomer.getHousePriceLow());
				appAchieveMonthStatisticsRankDetailYkDto.setDeptId(erpFunTrack.getDeptId());
				appAchieveMonthStatisticsRankDetailYkDto.setDeptName(deptsMap.get(erpFunTrack.getDeptId()));
				appAchieveMonthStatisticsRankDetailYkDto.setUserId(erpFunTrack.getCreatorUid());
				if(StringUtil.isBlank(usersMap.get(erpFunTrack.getCreatorUid()))){
					continue;
				}
				appAchieveMonthStatisticsRankDetailYkDto.setUserName(usersMap.get(erpFunTrack.getCreatorUid()));
				appAchieveMonthStatisticsRankDetailYkDto.setCreationTime(DateTimeHelper.formatDateTimetoString(erpMakeLookHouse.getLookTime()));
				Integer custSex = (null != erpFunBuyCustomer.getBuyCustSex() && erpFunBuyCustomer.getBuyCustSex())?1:0;
				appAchieveMonthStatisticsRankDetailYkDto.setCustSex(custSex);
				List<AppAchieveMonthStatisticsRankDetailYkSubDto> ykSubDtos = new ArrayList<AppAchieveMonthStatisticsRankDetailYkSubDto>();

				// 处理房源信息
				Set<Integer> houseIdSet = makeIdHouseIdsMap.get(erpFunTrack.getMakeLookId());
				if (null != houseIdSet) {
					for (Integer houseId : houseIdSet) {
						AppAchieveMonthStatisticsRankDetailYkSubDto subData = new AppAchieveMonthStatisticsRankDetailYkSubDto();
						subData.setCaseType(Const.DIC_CASE_TYPE_SALE_FUN); // 求购对应的出售
						subData.setCaseId(houseId);
						ErpFunSale erpFunSale = saleMap.get(houseId);
						if(null == erpFunSale){
							continue;
						}
						subData.setCreationTime(DateTimeHelper.formatDateTimetoString(erpMakeLookHouse.getLookTime()));
						subData.setBuildId(erpFunSale.getBuildId());
						subData.setBuildName(erpFunSale.getBuildName());
						subData.setDeptId(erpFunTrack.getDeptId());
						subData.setDeptName(deptsMap.get(erpFunTrack.getDeptId()));
						subData.setUserId(erpFunTrack.getCreatorUid());
						String userName = usersMap.get(erpFunTrack.getCreatorUid());
						if(StringUtil.isBlank(userName)){
							continue;
						}
						subData.setUserName(userName);
						subData.setDkPhotoCount(erpFunTrack.getDkPhotoCount());
						subData.setTrackResult(erpFunTrack.getTrackResult());
						subData.setHouseArea(erpFunSale.getSaleArea());
						subData.setHouseRoom(erpFunSale.getSaleRoom());
						subData.setHouseTotalPrice(erpFunSale.getSaleTotalPrice());
						subData.setHouseLowestPrice(erpFunSale.getSaleLowestPrice());
						subData.setTrackId(erpFunTrack.getTrackId());
						subData.setTrackType(erpFunTrack.getTrackType());
						ykSubDtos.add(subData);
					}
				}
				// 房源列表
				appAchieveMonthStatisticsRankDetailYkDto.setList(ykSubDtos);
				resultList.add(appAchieveMonthStatisticsRankDetailYkDto);
			}
		} else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)){
			// 客源信息
			List<ErpFunRentCustomer> funRentList = erpFunRentCustomerMapper.getAppAchieveMonthStatisticsRankDetailCustomerAdd(cityId, compId, caseIds, trueViewRang, trueViewRangId, deptId);
			Map<Integer, ErpFunRentCustomer> rentCustMap = funRentList.stream().collect(Collectors.toMap(ErpFunRentCustomer::getRentCustId, val ->val));
			// 房源信息
			List<ErpFunLease> leaseList = null;
			Map<Integer, ErpFunLease> leaseMap = new HashMap<Integer, ErpFunLease>();
			//手填外部房源 没有房源id，或者房源ID为空的情况-陈文超改
			if(null != targetIds && !targetIds.isEmpty()){
				leaseList = erpFunLeaseMapper.getAppAchieveMonthStatisticsRankDetailHouseAdd(cityId, compId, targetIds, trueViewRang, trueViewRangId, deptId);
				leaseMap = leaseList.stream().collect(Collectors.toMap(ErpFunLease::getLeaseId, val -> val));
			}
			
			for (ErpFunTrack erpFunTrack : tracksList) {
				Integer caseId = erpFunTrack.getCaseId();
				ErpFunRentCustomer erpFunRentCustomer = rentCustMap.get(caseId);
				if(null == erpFunRentCustomer){
					continue;
				}

				ErpMakeLookHouse erpMakeLookHouse = makeLookHouseMap.get(erpFunTrack.getMakeLookId());
				if(null == erpMakeLookHouse){
					continue;
				}
				AppAchieveMonthStatisticsRankDetailYkDto appAchieveMonthStatisticsRankDetailYkDto = new AppAchieveMonthStatisticsRankDetailYkDto();
				appAchieveMonthStatisticsRankDetailYkDto.setBuildId(StringUtil.parseInteger(erpFunRentCustomer.getBuildId()));
				appAchieveMonthStatisticsRankDetailYkDto.setBuildName(erpFunRentCustomer.getBuildName());
				appAchieveMonthStatisticsRankDetailYkDto.setCaseId(erpFunRentCustomer.getRentCustId());
				appAchieveMonthStatisticsRankDetailYkDto.setCaseType(caseType);
				if(!"1".equals(isShowCustfullname) && StringUtil.isNotBlank(erpFunRentCustomer.getRentCustName())){
					appAchieveMonthStatisticsRankDetailYkDto.setCustName(erpFunRentCustomer.getRentCustName().substring(0, 1));
				}
				appAchieveMonthStatisticsRankDetailYkDto.setHouseAreaHigh(erpFunRentCustomer.getHouseAreaHigh());
				appAchieveMonthStatisticsRankDetailYkDto.setHouseAreaLow(erpFunRentCustomer.getHouseAreaLow());
				appAchieveMonthStatisticsRankDetailYkDto.setHouseRoom(erpFunRentCustomer.getHouseRoom());
				appAchieveMonthStatisticsRankDetailYkDto.setHouseRoom1(erpFunRentCustomer.getHouseRoom1());
				appAchieveMonthStatisticsRankDetailYkDto.setHouseUseage(erpFunRentCustomer.getHouseUseage());
				appAchieveMonthStatisticsRankDetailYkDto.setRegionName(erpFunRentCustomer.getRegionName());
				appAchieveMonthStatisticsRankDetailYkDto.setSectionName(erpFunRentCustomer.getSectionName());
				appAchieveMonthStatisticsRankDetailYkDto.setHouseTotalPrice(erpFunRentCustomer.getHousePriceHigh());
				appAchieveMonthStatisticsRankDetailYkDto.setHouseLowestPrice(erpFunRentCustomer.getHousePriceLow());
				appAchieveMonthStatisticsRankDetailYkDto.setDeptId(erpFunTrack.getDeptId());
				appAchieveMonthStatisticsRankDetailYkDto.setDeptName(deptsMap.get(erpFunTrack.getDeptId()));
				appAchieveMonthStatisticsRankDetailYkDto.setUserId(erpFunTrack.getCreatorUid());
				if(StringUtil.isBlank(usersMap.get(erpFunTrack.getCreatorUid()))){
					continue;
				}
				appAchieveMonthStatisticsRankDetailYkDto.setUserName(usersMap.get(erpFunTrack.getCreatorUid()));
				appAchieveMonthStatisticsRankDetailYkDto.setCreationTime(DateTimeHelper.formatDateTimetoString(erpMakeLookHouse.getLookTime()));
				Integer custSex = (null != erpFunRentCustomer.getRentCustSex() && erpFunRentCustomer.getRentCustSex())?1:0;
				appAchieveMonthStatisticsRankDetailYkDto.setCustSex(custSex);
				List<AppAchieveMonthStatisticsRankDetailYkSubDto> ykSubDtos = new ArrayList<AppAchieveMonthStatisticsRankDetailYkSubDto>();

				// 处理房源信息
				Set<Integer> houseIdSet = makeIdHouseIdsMap.get(erpFunTrack.getMakeLookId());
				if(houseIdSet != null){
					for (Integer houseId : houseIdSet) {
						AppAchieveMonthStatisticsRankDetailYkSubDto subData = new AppAchieveMonthStatisticsRankDetailYkSubDto();
						subData.setCaseType(Const.DIC_CASE_TYPE_LEASE_FUN); // 求购对应的出售
						subData.setCaseId(houseId);
						ErpFunLease erpFunLease = leaseMap.get(houseId);
						if(null == erpFunLease){
							continue;
						}
						subData.setCreationTime(DateTimeHelper.formatDateTimetoString(erpMakeLookHouse.getLookTime()));
						subData.setBuildId(erpFunLease.getBuildId());
						subData.setBuildName(erpFunLease.getBuildName());
						subData.setDeptId(erpFunTrack.getDeptId());
						subData.setDeptName(deptsMap.get(erpFunTrack.getDeptId()));
						subData.setUserId(erpFunTrack.getCreatorUid());
						String userName = usersMap.get(erpFunTrack.getCreatorUid());
						if(StringUtil.isBlank(userName)){
							continue;
						}
						subData.setDkPhotoCount(erpFunTrack.getDkPhotoCount());
						subData.setTrackResult(erpFunTrack.getTrackResult());
						subData.setHouseArea(erpFunLease.getLeaseArea());
						subData.setHouseRoom(erpFunLease.getLeaseRoom());
						subData.setHouseTotalPrice(erpFunLease.getLeaseTotalPrice());
						subData.setHouseLowestPrice(erpFunLease.getLeaseLowestPrice());
						subData.setPriceUnit(erpFunLease.getPriceUnit());
						subData.setTrackId(erpFunTrack.getTrackId());
						subData.setTrackType(erpFunTrack.getTrackType());
						ykSubDtos.add(subData);
					}
				}
				appAchieveMonthStatisticsRankDetailYkDto.setList(ykSubDtos);
				resultList.add(appAchieveMonthStatisticsRankDetailYkDto);
			}
		}
		resultList.sort((o1, o2) -> {
			String creationTime1 = o1.getCreationTime();
			String creationTime2 = o2.getCreationTime();
			return creationTime2.compareTo(creationTime1);
		});
		resultData.setList(resultList);
		return ErpResponseJson.ok(resultData);
	}


	public ErpResponseJson getAppAchieveMonthStatisticsRankDetailYkForOrg(AppAchieveMonthStatisticsRankDetailParam param) throws Exception{
		AppAchieveMonthStatisticsRankDetailYkVo resultData = new AppAchieveMonthStatisticsRankDetailYkVo();
		List<AppAchieveMonthStatisticsRankDetailYkDto> resultList = new ArrayList<>();
		resultData.setList(resultList);
		Operator operator = getOperator();
		Integer compId = operator.getCompId();
		Integer userId = operator.getUserId();
		Integer cityId = operator.getCityId();
		// 查看范围 2：大区 3：片区 4：门店 5：分组 6个人
		String assessmentMonth = param.getAssessmentMonth();
		Integer caseType = param.getCaseType();
		Assert.isTrueThrow(null == caseType, "房客类型为空");

		//加盟商模式下各分组下查看范围
		List<Integer> partnerIds = deducePartnerWageRange(operator);
		// 查询时间
		String endTime = "";
		if(StringUtil.isNotBlank(assessmentMonth)){
			String year = assessmentMonth.substring(0,4); // year
			String month = assessmentMonth.substring(5, 7); // month
			endTime = DateConvert.getLastDayOfMonth(StringUtil.parseInteger(year,2018), StringUtil.parseInteger(month,8)) + "23:59:59";
		} else {
			String startTime = param.getStartTime();
			if(StringUtil.isNotBlank(startTime)){
				assessmentMonth = startTime;
			}
			if(StringUtil.isNotBlank(param.getEndTime())){
				endTime = param.getEndTime() + " 23:59:59";
			}
		}

		// 获取自己的列表查看权
		//组织机构查看条件
		Integer defId = null;
		Integer orgId = null;
		if (param.getUserId()!=null) {
			defId = -2;
			orgId = param.getUserId();
		} else if (param.getOrganizationId() != null) {
			defId = 1;
			orgId = param.getOrganizationId();
		}
		// 带看跟进
		String mangeRangePathWhereCause = erpFunOrganizationService.getMangeRangePathWhereCause(cityId, compId, userId, null, null,defId, orgId);
		mangeRangePathWhereCause = mangeRangePathWhereCause.replaceAll("USER_ID", "CREATOR_UID");
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<ErpFunTrack> tracksList = erpFunTrackMapper.getFunTrackByCaseIdsForOrg(cityId, compId, partnerIds,null, caseType, Const.DIC_TRACK_MAKE_LOOK, mangeRangePathWhereCause, null, assessmentMonth, endTime);
		if(null == tracksList || tracksList.isEmpty()){
			return ErpResponseJson.ok(resultData);
		}
		// 客源信息
		Set<Integer> caseIds = tracksList.stream().map(ErpFunTrack::getCaseId).collect(Collectors.toSet());
		// 约看Id
		List<Integer> makeLookIdSet = tracksList.stream().filter(val -> val.getMakeLookId() != null).map(ErpFunTrack::getMakeLookId).collect(Collectors.toList());
		if(makeLookIdSet.isEmpty()){
			return ErpResponseJson.ok(resultData);
		}
		// 带看房源信息
		Set<Integer> targetIds = new HashSet<>();
		// 查询房源ID
		ErpMakeLookHouseExample makeLookHouseExample = new ErpMakeLookHouseExample();
		makeLookHouseExample.setShardCityId(cityId);
		makeLookHouseExample.createCriteria().andIdIn(makeLookIdSet);
		List<ErpMakeLookHouse> erpMakeLookHouses = erpMakeLookHouseMapper.selectByExample(makeLookHouseExample);
		if(null == erpMakeLookHouses || erpMakeLookHouses.isEmpty()){
			return ErpResponseJson.ok(resultData);
		}
		Map<Integer, ErpMakeLookHouse> makeLookHouseMap = erpMakeLookHouses.stream().collect(Collectors.toMap(ErpMakeLookHouse::getId, val->val));
		// 一个约看对应多个房源
		Map<Integer, Set<Integer>> makeIdHouseIdsMap = new HashMap<>();
		// 解析房源ID
		erpMakeLookHouses.forEach(val-> {
			String houseIds = val.getHouseIds();
			if(StringUtils.isNotBlank(houseIds)) {
				Set<Integer> houseIdSet = new HashSet<>();
				String[] houseIdsArray = houseIds.split(",");
				for(String houseIdStr : houseIdsArray) {
					houseIdSet.add(Integer.valueOf(houseIdStr));
				}
				targetIds.addAll(houseIdSet);
				makeIdHouseIdsMap.put(val.getId(), houseIdSet);
			}
		});

		// 组织机构信息
		String isShowCustfullname = erpSysParaMapper.getParamValue(cityId, compId, "IS_SHOW_CUSTFULLNAME");
		String userManagerCause = erpFunOrganizationService.getMangeRangeWhereCause(cityId, compId, userId, null, null, null);
		List<ErpFunUsers> usersList = erpFunUsersMapper.getManagerUserListForOrg(cityId, compId,partnerIds, userManagerCause);
		Map<Integer, ErpFunUsers> usersMap = usersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, Function.identity()));
		List<ErpFunOrganization> allOrgList = erpFunOrganizationMapper.selectOrgByOrgIds(cityId, compId, null);
		Map<Integer, ErpFunOrganization> allOrgMap = allOrgList.stream().collect(Collectors.toMap(ErpFunOrganization::getOrganizationId, Function.identity()));
		if(Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)){
			// 客源信息
			List<ErpFunBuyCustomer> buyCustomerList = erpFunBuyCustomerMapper.getAppAchieveMonthStatisticsRankDetailCustomerAdd(cityId, compId, caseIds, null, null, null);
			Map<Integer, ErpFunBuyCustomer> buyCustMap = buyCustomerList.stream().collect(Collectors.toMap(ErpFunBuyCustomer::getBuyCustId, val -> val));
			// 房源信息
			List<ErpFunSale> saleList = null;
			Map<Integer, ErpFunSale> saleMap = new HashMap<Integer, ErpFunSale>();

			//手填外部房源 没有房源id，或者房源ID为空的情况-陈文超改
			if(!targetIds.isEmpty()){
				saleList = erpFunSaleMapper.getAppAchieveMonthStatisticsRankDetailHouseAdd(cityId, compId, targetIds, null, null, null);
				saleMap = saleList.stream().collect(Collectors.toMap(ErpFunSale::getSaleId, val -> val));
			}
			for (ErpFunTrack erpFunTrack : tracksList) {
				Integer caseId = erpFunTrack.getCaseId();
				ErpFunBuyCustomer erpFunBuyCustomer = buyCustMap.get(caseId);
				if(null == erpFunBuyCustomer){continue;}
				// 约看记录
				ErpMakeLookHouse erpMakeLookHouse = makeLookHouseMap.get(erpFunTrack.getMakeLookId());
				if(null == erpMakeLookHouse){continue;}
				AppAchieveMonthStatisticsRankDetailYkDto appAchieveMonthStatisticsRankDetailYkDto = new AppAchieveMonthStatisticsRankDetailYkDto();
				String buildIds = Optional.ofNullable(erpFunBuyCustomer.getBuildId()).orElse("0");
				String[] ids = buildIds.split("\\s+");
				appAchieveMonthStatisticsRankDetailYkDto.setBuildId(StringUtil.parseInteger(ids[0],0));
				appAchieveMonthStatisticsRankDetailYkDto.setBuildName(erpFunBuyCustomer.getBuildName());
				appAchieveMonthStatisticsRankDetailYkDto.setCaseId(erpFunBuyCustomer.getBuyCustId());
				appAchieveMonthStatisticsRankDetailYkDto.setCaseType(caseType);
				if(!"1".equals(isShowCustfullname) && StringUtil.isNotBlank(erpFunBuyCustomer.getBuyCustName())){
					appAchieveMonthStatisticsRankDetailYkDto.setCustName(erpFunBuyCustomer.getBuyCustName().substring(0, 1));
				}
				appAchieveMonthStatisticsRankDetailYkDto.setHouseAreaHigh(erpFunBuyCustomer.getHouseAreaHigh());
				appAchieveMonthStatisticsRankDetailYkDto.setHouseAreaLow(erpFunBuyCustomer.getHouseAreaLow());
				appAchieveMonthStatisticsRankDetailYkDto.setHouseRoom(erpFunBuyCustomer.getHouseRoom());
				appAchieveMonthStatisticsRankDetailYkDto.setHouseRoom1(erpFunBuyCustomer.getHouseRoom1());
				appAchieveMonthStatisticsRankDetailYkDto.setHouseUseage(erpFunBuyCustomer.getHouseUseage());
				appAchieveMonthStatisticsRankDetailYkDto.setRegionName(erpFunBuyCustomer.getRegionName());
				appAchieveMonthStatisticsRankDetailYkDto.setSectionName(erpFunBuyCustomer.getSectionName());
				appAchieveMonthStatisticsRankDetailYkDto.setHouseTotalPrice(erpFunBuyCustomer.getHousePriceHigh());
				appAchieveMonthStatisticsRankDetailYkDto.setHouseLowestPrice(erpFunBuyCustomer.getHousePriceLow());
				//
				ErpFunUsers trackUser = usersMap.get(erpFunTrack.getCreatorUid());
				if (trackUser == null) {continue;}
				ErpFunOrganization trackOrg = allOrgMap.get(trackUser.getOrganizationId());
				if(trackOrg == null){continue;}
				appAchieveMonthStatisticsRankDetailYkDto.setOrganizationId(trackOrg.getOrganizationId());
				appAchieveMonthStatisticsRankDetailYkDto.setUserId(erpFunTrack.getCreatorUid());
				appAchieveMonthStatisticsRankDetailYkDto.setUserName(trackUser.getUserName());
				appAchieveMonthStatisticsRankDetailYkDto.setCreationTime(DateTimeHelper.formatDateTimetoString(erpMakeLookHouse.getLookTime()));
				Integer custSex = (null != erpFunBuyCustomer.getBuyCustSex() && erpFunBuyCustomer.getBuyCustSex())?1:0;
				appAchieveMonthStatisticsRankDetailYkDto.setCustSex(custSex);
				List<AppAchieveMonthStatisticsRankDetailYkSubDto> ykSubDtos = new ArrayList<AppAchieveMonthStatisticsRankDetailYkSubDto>();

				// 处理房源信息
				Set<Integer> houseIdSet = makeIdHouseIdsMap.get(erpFunTrack.getMakeLookId());
				if (null != houseIdSet) {
					for (Integer houseId : houseIdSet) {
						AppAchieveMonthStatisticsRankDetailYkSubDto subData = new AppAchieveMonthStatisticsRankDetailYkSubDto();
						subData.setCaseType(Const.DIC_CASE_TYPE_SALE_FUN); // 求购对应的出售
						subData.setCaseId(houseId);
						ErpFunSale erpFunSale = saleMap.get(houseId);
						if(null == erpFunSale){
							continue;
						}
						subData.setCreationTime(DateTimeHelper.formatDateTimetoString(erpMakeLookHouse.getLookTime()));
						subData.setBuildId(erpFunSale.getBuildId());
						subData.setBuildName(erpFunSale.getBuildName());
						trackUser = usersMap.get(erpFunTrack.getCreatorUid());
						if (trackUser == null) {continue;}
						trackOrg = allOrgMap.get(trackUser.getUserId());
						if(trackOrg == null){continue;}
						subData.setOrganizationId(trackOrg.getOrganizationId());
						subData.setUserName(trackUser.getUserName());
						subData.setUserId(erpFunTrack.getCreatorUid());
						subData.setDkPhotoCount(erpFunTrack.getDkPhotoCount());
						subData.setTrackResult(erpFunTrack.getTrackResult());
						subData.setHouseArea(erpFunSale.getSaleArea());
						subData.setHouseRoom(erpFunSale.getSaleRoom());
						subData.setHouseTotalPrice(erpFunSale.getSaleTotalPrice());
						subData.setHouseLowestPrice(erpFunSale.getSaleLowestPrice());
						subData.setTrackId(erpFunTrack.getTrackId());
						subData.setTrackType(erpFunTrack.getTrackType());
						ykSubDtos.add(subData);
					}
				}
				// 房源列表
				appAchieveMonthStatisticsRankDetailYkDto.setList(ykSubDtos);
				resultList.add(appAchieveMonthStatisticsRankDetailYkDto);
			}
		} else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)){
			// 客源信息
			List<ErpFunRentCustomer> funRentList = erpFunRentCustomerMapper.getAppAchieveMonthStatisticsRankDetailCustomerAdd(cityId, compId, caseIds, null, null, null);
			Map<Integer, ErpFunRentCustomer> rentCustMap = funRentList.stream().collect(Collectors.toMap(ErpFunRentCustomer::getRentCustId, val ->val));
			// 房源信息
			List<ErpFunLease> leaseList = null;
			Map<Integer, ErpFunLease> leaseMap = new HashMap<Integer, ErpFunLease>();
			//手填外部房源 没有房源id，或者房源ID为空的情况-陈文超改
			if(!targetIds.isEmpty()){
				leaseList = erpFunLeaseMapper.getAppAchieveMonthStatisticsRankDetailHouseAdd(cityId, compId, targetIds, null, null, null);
				leaseMap = leaseList.stream().collect(Collectors.toMap(ErpFunLease::getLeaseId, val -> val));
			}

			for (ErpFunTrack erpFunTrack : tracksList) {
				Integer caseId = erpFunTrack.getCaseId();
				ErpFunRentCustomer erpFunRentCustomer = rentCustMap.get(caseId);
				if(null == erpFunRentCustomer){
					continue;
				}

				ErpMakeLookHouse erpMakeLookHouse = makeLookHouseMap.get(erpFunTrack.getMakeLookId());
				if(null == erpMakeLookHouse){
					continue;
				}
				AppAchieveMonthStatisticsRankDetailYkDto appAchieveMonthStatisticsRankDetailYkDto = new AppAchieveMonthStatisticsRankDetailYkDto();
				String buildIds = Optional.ofNullable(erpFunRentCustomer.getBuildId()).orElse("0");
				String[] ids = buildIds.split("\\s+");
				appAchieveMonthStatisticsRankDetailYkDto.setBuildId(StringUtil.parseInteger(ids[0],0));
				appAchieveMonthStatisticsRankDetailYkDto.setBuildName(erpFunRentCustomer.getBuildName());
				appAchieveMonthStatisticsRankDetailYkDto.setCaseId(erpFunRentCustomer.getRentCustId());
				appAchieveMonthStatisticsRankDetailYkDto.setCaseType(caseType);
				if(!"1".equals(isShowCustfullname) && StringUtil.isNotBlank(erpFunRentCustomer.getRentCustName())){
					appAchieveMonthStatisticsRankDetailYkDto.setCustName(erpFunRentCustomer.getRentCustName().substring(0, 1));
				}
				appAchieveMonthStatisticsRankDetailYkDto.setHouseAreaHigh(erpFunRentCustomer.getHouseAreaHigh());
				appAchieveMonthStatisticsRankDetailYkDto.setHouseAreaLow(erpFunRentCustomer.getHouseAreaLow());
				appAchieveMonthStatisticsRankDetailYkDto.setHouseRoom(erpFunRentCustomer.getHouseRoom());
				appAchieveMonthStatisticsRankDetailYkDto.setHouseRoom1(erpFunRentCustomer.getHouseRoom1());
				appAchieveMonthStatisticsRankDetailYkDto.setHouseUseage(erpFunRentCustomer.getHouseUseage());
				appAchieveMonthStatisticsRankDetailYkDto.setRegionName(erpFunRentCustomer.getRegionName());
				appAchieveMonthStatisticsRankDetailYkDto.setSectionName(erpFunRentCustomer.getSectionName());
				appAchieveMonthStatisticsRankDetailYkDto.setHouseTotalPrice(erpFunRentCustomer.getHousePriceHigh());
				appAchieveMonthStatisticsRankDetailYkDto.setHouseLowestPrice(erpFunRentCustomer.getHousePriceLow());
				ErpFunUsers trackUser = usersMap.get(erpFunTrack.getCreatorUid());
				if (trackUser == null) {continue;}
				ErpFunOrganization trackOrg = allOrgMap.get(trackUser.getOrganizationId());
				if(trackOrg == null){continue;}
				appAchieveMonthStatisticsRankDetailYkDto.setOrganizationId(trackOrg.getOrganizationId());
				appAchieveMonthStatisticsRankDetailYkDto.setUserId(erpFunTrack.getCreatorUid());
				appAchieveMonthStatisticsRankDetailYkDto.setUserName(trackUser.getUserName());
				appAchieveMonthStatisticsRankDetailYkDto.setCreationTime(DateTimeHelper.formatDateTimetoString(erpMakeLookHouse.getLookTime()));
				Integer custSex = (null != erpFunRentCustomer.getRentCustSex() && erpFunRentCustomer.getRentCustSex())?1:0;
				appAchieveMonthStatisticsRankDetailYkDto.setCustSex(custSex);
				List<AppAchieveMonthStatisticsRankDetailYkSubDto> ykSubDtos = new ArrayList<>();

				// 处理房源信息
				Set<Integer> houseIdSet = makeIdHouseIdsMap.get(erpFunTrack.getMakeLookId());
				if(houseIdSet != null){
					for (Integer houseId : houseIdSet) {
						AppAchieveMonthStatisticsRankDetailYkSubDto subData = new AppAchieveMonthStatisticsRankDetailYkSubDto();
						subData.setCaseType(Const.DIC_CASE_TYPE_LEASE_FUN); // 求购对应的出售
						subData.setCaseId(houseId);
						ErpFunLease erpFunLease = leaseMap.get(houseId);
						if(null == erpFunLease){
							continue;
						}
						subData.setCreationTime(DateTimeHelper.formatDateTimetoString(erpMakeLookHouse.getLookTime()));
						subData.setBuildId(erpFunLease.getBuildId());
						subData.setBuildName(erpFunLease.getBuildName());
						trackUser = usersMap.get(erpFunTrack.getCreatorUid());
						if (trackUser == null) {continue;}
						trackOrg = allOrgMap.get(trackUser.getUserId());
						if(trackOrg == null){continue;}
						subData.setOrganizationId(trackOrg.getOrganizationId());
						subData.setUserName(trackUser.getUserName());
						subData.setUserId(erpFunTrack.getCreatorUid());
						subData.setDkPhotoCount(erpFunTrack.getDkPhotoCount());
						subData.setTrackResult(erpFunTrack.getTrackResult());
						subData.setHouseArea(erpFunLease.getLeaseArea());
						subData.setHouseRoom(erpFunLease.getLeaseRoom());
						subData.setHouseTotalPrice(erpFunLease.getLeaseTotalPrice());
						subData.setHouseLowestPrice(erpFunLease.getLeaseLowestPrice());
						subData.setPriceUnit(erpFunLease.getPriceUnit());
						subData.setTrackId(erpFunTrack.getTrackId());
						subData.setTrackType(erpFunTrack.getTrackType());
						ykSubDtos.add(subData);
					}
				}
				appAchieveMonthStatisticsRankDetailYkDto.setList(ykSubDtos);
				resultList.add(appAchieveMonthStatisticsRankDetailYkDto);
			}
		}
		resultList.sort((o1, o2) -> {
			String creationTime1 = o1.getCreationTime();
			String creationTime2 = o2.getCreationTime();
			return creationTime2.compareTo(creationTime1);
		});
		resultData.setList(resultList);
		return ErpResponseJson.ok(resultData);
	}
}

package com.myfun.erpWeb.managecenter.profit;
/**
 * 业绩相关的业务
 * flj
 * 2017
 * @author Administrator
 *
 */

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.Valid;

import com.myfun.erpWeb.managecenter.profit.vo.*;
import com.myfun.repository.erpdb.dao.ErpFunOrganizationMapper;
import com.myfun.repository.erpdb.dao.ErpFunWorkcountTargetOrgTemplateMapper;
import com.myfun.repository.erpdb.dto.PartnerConfigDto;
import com.myfun.repository.erpdb.po.*;
import com.myfun.service.business.erpdb.ErpFunPartnerConfigService;
import com.myfun.service.business.erpdb.impl.ErpFunWorkcountTargetServiceImpl;
import com.myfun.utils.Assert;
import com.myfun.utils.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.constract.param.InsertDealInfoParam;
import com.myfun.erpWeb.managecenter.profit.param.AppFunWorkCountTargetDetailParam;
import com.myfun.erpWeb.managecenter.profit.param.AppFunWorkCountTargetParam;
import com.myfun.erpWeb.managecenter.profit.param.HandProfitListParam;
import com.myfun.erpWeb.managecenter.profit.param.InsertProfitTargetListParam;
import com.myfun.erpWeb.managecenter.profit.param.MgrProfiTargetParam;
import com.myfun.erpWeb.managecenter.profit.param.MgrProfiTargetParamForInsert;
import com.myfun.erpWeb.managecenter.profit.param.ProfitBaseInfoParam;
import com.myfun.erpWeb.managecenter.profit.param.ProfitDetailInfoListParam;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunCompMapper;
import com.myfun.repository.admindb.po.AdminFunComp;
import com.myfun.repository.erpdb.dao.ErpFunAreaMapper;
import com.myfun.repository.erpdb.dao.ErpFunDealMapper;
import com.myfun.repository.erpdb.dao.ErpFunDealRecordMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsgroupMapper;
import com.myfun.repository.erpdb.dao.ErpFunPerformanceTypeMapper;
import com.myfun.repository.erpdb.dao.ErpFunProfitDetailMapper;
import com.myfun.repository.erpdb.dao.ErpFunProfitMapper;
import com.myfun.repository.erpdb.dao.ErpFunProfitShareDetailMapper;
import com.myfun.repository.erpdb.dao.ErpFunProfitTargetMapper;
import com.myfun.repository.erpdb.dao.ErpFunRegionMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpFunWorkcountTargetMapper;
import com.myfun.repository.erpdb.dao.ErpFunWorkcountTargetTemplateMapper;
import com.myfun.repository.erpdb.dao.ErpProcessFinancMapper;
import com.myfun.repository.erpdb.dao.ErpSysParaMapper;
import com.myfun.repository.erpdb.dto.ErpFunDealDto;
import com.myfun.repository.erpdb.dto.ErpFunDealDtoTemp;
import com.myfun.repository.erpdb.dto.ErpFunWorkCountTargetDto;
import com.myfun.repository.erpdb.param.CreateOrUpdateByHandProfitParam;
import com.myfun.repository.erpdb.param.ErpFunProfitDetailParam;
import com.myfun.repository.erpdb.param.ErpFunWorkCountTargetParam;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.admindb.AdminFunCompService;
import com.myfun.service.business.admindb.AdminJmsMessageService;
import com.myfun.service.business.erpdb.ErpFunAreaService;
import com.myfun.service.business.erpdb.ErpFunProfitService;
import com.myfun.service.business.erpdb.ErpFunProfitTargetService;
import com.myfun.service.business.erpdb.ErpFunWorkcountTargetService;
import com.myfun.service.business.erpdb.ErpNoTransactionService;
import com.myfun.service.business.erpdb.ErpUserOpersService;
import com.myfun.service.jms.bean.UpdateFunProfitMessage;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.BeanUtilsHelper;
import com.myfun.utils.CommonUtil;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.DateUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "业绩相关")
@RestController
	@RequestMapping("/profit")
public class ProfitBusinessController extends BaseController {
	private transient static final Logger logger = LoggerFactory.getLogger(ProfitBusinessController.class);

	@Autowired
    ErpFunDealMapper erpFunDealMapper;
	@Autowired
    ErpFunProfitService erpFunProfitService;
	@Autowired
    ErpFunDealRecordMapper ErpFunDealRecordMapper;
	@Autowired
    ErpFunProfitDetailMapper erpFunProfitDetailMapper;
	@Autowired
    ErpSysParaMapper erpSysParaMapper;
	@Autowired
    ErpFunProfitMapper erpFunProfitMapper;
	@Autowired
    ErpProcessFinancMapper erpProcessFinancMapper;
	@Autowired
    ErpFunWorkcountTargetMapper erpFunWorkcountTargetMapper;
	@Autowired
    ErpFunWorkcountTargetTemplateMapper erpFunWorkcountTargetTemplateMapper;
	@Autowired
    ErpFunWorkcountTargetService erpFunWorkcountTargetService;
	@Autowired
    ErpFunPerformanceTypeMapper erpFunPerformanceTypeMapper;
	@Autowired
    ErpFunAreaService erpFunAreaService;
	@Autowired
    ErpFunRegionMapper erpFunRegionMapper;
	@Autowired
    ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
    ErpFunDeptsgroupMapper erpFunDeptsgroupMapper;
	@Autowired
    ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
    ErpFunProfitTargetMapper erpFunProfitTargetMapper;
	@Autowired
    ErpFunAreaMapper erpFunAreaMapper;
	@Autowired
    ErpUserOpersService erpUserOpersService;
	@Autowired
    ErpFunProfitTargetService erpFunProfitTargetService;
	@Autowired
    ErpNoTransactionService erpNoTransactionService;
	@Autowired
    AdminJmsMessageService adminJmsMessageService;
	@Autowired
	AdminFunCompMapper adminFunCompMapper;
	@Autowired
	ErpFunProfitShareDetailMapper erpFunProfitShareDetailMapper;
	@Autowired
	AdminFunCompService adminFunCompService;
	@Autowired
	private ErpFunPartnerConfigService erpFunPartnerConfigService;
    @Autowired
    private ErpFunOrganizationMapper erpFunOrganizationMapper;
    @Autowired
    private ErpFunWorkcountTargetOrgTemplateMapper erpFunWorkcountTargetOrgTemplateMapper;


	/**
	 * 创建手动录入的业绩
	 * @return
	 * @throws Exception
	 *//*
	@RequestMapping("/createByHandProfit")
	public ResponseJson createByHandProfit(@RequestBody CreateOrUpdateByHandProfitParam param) throws Exception{

		return null;

	}*/

	/***
	 * 编辑手动录入的业绩
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("编辑手动录入的业绩")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@PostMapping("/updateByHandProfit")
	public ResponseJson updateByHandProfit(@RequestBody CreateOrUpdateByHandProfitParam param) throws Exception {
		Operator operator = getOperator();
		Integer dealId = param.getDealId();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		param.setTotalNeedIncome(param.getTotalNeedPerformance());
		param.setTotalRealIncome(param.getTotalRealPerformance());
		boolean operateFlag = erpUserOpersService.judgePermission(cityId, operator.getUserId(), "DISTRIBUTE_PROFIT");
		if (!operateFlag) {
			throw new BusinessException("您没有权限操作此功能！请联系管理员开通！");
		}

		GeneralParam generalParam = new GeneralParam(operator);
		generalParam.setCurrDeptUserName(getCurrentUserName());
		erpFunProfitService.updateByHandProfit(generalParam, param);

		// 查询已审核的实收
		List<ErpProcessFinanc> processFinancPOList = erpProcessFinancMapper.getProcessFinancListByDealId(cityId, operator.getCompId(), dealId);

		ErpFunProfitDetailExample example = new ErpFunProfitDetailExample();
		example.setShardCityId(cityId);
		example.createCriteria().andCompIdEqualTo(operator.getCompId()).andDealIdEqualTo(dealId);
		ErpFunProfitDetail erpFunProfitDetail = new ErpFunProfitDetail();
		erpFunProfitDetail.setDelData(DateTimeHelper.getSystemDate());
		erpFunProfitDetail.setDelFlag((byte) 1);
		erpFunProfitDetailMapper.updateByExampleSelective(erpFunProfitDetail, example);

		if (adminFunCompService.judgerIsFangjidi(operator.getAdminCompId())) {
			erpFunProfitShareDetailMapper.deleteProfitDetail(cityId, compId, dealId);
		}
		
		if(processFinancPOList.size() > 0) {
			String pfIds = "";
			for (ErpProcessFinanc processFinancPO : processFinancPOList) {
				pfIds += processFinancPO.getPfId()+",";
			}

			if(StringUtils.isNotBlank(pfIds)) {
				pfIds = pfIds.substring(0, pfIds.length()-1);
				// 发送消息到jms
//				Map<String, Object> content = new HashMap<>();
//				content.put("cityId", cityId);
//				content.put("compId", operator.getCompId());
//				content.put("dealId", dealId);
//				content.put("pfIds", pfIds);
//				content.put("dealOpType", "1");
//				adminJmsMessageService.createProfitDetail(cityId,content);
				UpdateFunProfitMessage message = new UpdateFunProfitMessage();
				message.setCityId(cityId);
				message.setCompId(operator.getCompId());
				message.setDealId(dealId);
				message.setPfIds(pfIds);
				message.setDealOpType(1);
				adminJmsMessageService.createProfitDetail(message);
			}
		}

		return ErpResponseJson.ok();
	}

	/**
	 * 获取手动录入业绩列表
	 * @author HeWei
	 * @since 2018年7月18日 下午5:30:11
	 * @param param
	 * @return
	 * @throws Exception
	 * Modified XXX HeWei 2018年7月18日
	 */
	@ApiOperation("获取手动录入业绩列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = HandProfitListVo.class, message = "成功")
	})
	@PostMapping("/getByHandProfitList")
	public ResponseJson getByHandProfitList(@RequestBody HandProfitListParam param) throws Exception{
		Operator operator = getOperator();
		Integer dealId = param.getDealId();
		Integer cityId = operator.getCityId();
		Integer compId = getOperator().getCompId();
		HandProfitListVo resultVo = new HandProfitListVo();
		ErpFunProfitExample erpFunProfitExample = new ErpFunProfitExample();
		erpFunProfitExample.setShardCityId(cityId);
		erpFunProfitExample.createCriteria().andDealIdEqualTo(dealId);
		List<ErpFunProfit> profitList = erpFunProfitMapper.selectByExample(erpFunProfitExample);
        
        Boolean isHouseBase = this.isHouseBase(operator.getAdminCompId());
        /*****判断是否房基地，如果是，则需要将所有业绩类别都返回，无论有没有人*****/
		if(isHouseBase){
			ErpFunProfitExample houseBaseProfitExample = new ErpFunProfitExample();
			houseBaseProfitExample.setShardCityId(cityId);
			houseBaseProfitExample.createCriteria().andDealIdEqualTo(dealId).andProfitTypeEqualTo((byte) 0);
			profitList = erpFunProfitMapper.selectByExample(houseBaseProfitExample);
			/***查询该公司所有业绩类别****/
			List<Byte> performanceTypeList = new ArrayList<Byte>();
			for (ErpFunProfit erpFunProfit : profitList) {
				if(!performanceTypeList.contains(erpFunProfit.getPerformanceType())) {
					performanceTypeList.add(erpFunProfit.getPerformanceType());
				}
			}
			ErpFunPerformanceTypeExample erpFunPerformanceTypeExample = new ErpFunPerformanceTypeExample();
			erpFunPerformanceTypeExample.setShardCityId(cityId);
			erpFunPerformanceTypeExample.createCriteria().andCompIdEqualTo(compId).andCollectionTypeIn(performanceTypeList).andIsDelEqualTo((byte) 0);
			List<ErpFunPerformanceType> list = erpFunPerformanceTypeMapper.selectByExample(erpFunPerformanceTypeExample);
			if (list.isEmpty()) {//如果没有业绩类别，则初始化一份
				erpFunPerformanceTypeMapper.insertFunPerforManceType(getOperator().getCityId(), getOperator().getCompId());
				list = erpFunPerformanceTypeMapper.getDataListByCompId(cityId, compId);
			}
			
			for (ErpFunPerformanceType erpFunPerformanceType : list) {
				
				
				boolean hasProfit = false;
				for (ErpFunProfit erpFunProfit : profitList) {
					if(erpFunPerformanceType.getPerformanceId().equals(erpFunProfit.getPerformanceId())) {
						hasProfit = true;
					}
				}
				if(!hasProfit) {
					if(null != erpFunPerformanceType.getCollectionType()) {
						ErpFunProfit erpFunProfit = new ErpFunProfit();
						erpFunProfit.setProfitProportion(erpFunPerformanceType.getPerformanceProportion());
						erpFunProfit.setCompId(compId);
						erpFunProfit.setDealId(dealId);
						erpFunProfit.setPerformanceName(erpFunPerformanceType.getPerformanceName());
						erpFunProfit.setPerformanceId(erpFunPerformanceType.getPerformanceId());
						erpFunProfit.setPerformanceType(erpFunPerformanceType.getCollectionType());
						profitList.add(erpFunProfit);
					}
				}
			}
		}
		
		resultVo.setProfitList(profitList);
		ErpFunDealExample erpFunDealExample = new ErpFunDealExample();
		erpFunDealExample.setShardCityId(cityId);
		erpFunDealExample.createCriteria().andDealIdEqualTo(dealId);
		List<ErpFunDeal> erpFunDealList = erpFunDealMapper.selectByExample(erpFunDealExample);
		
		List<ErpFunDealDtoTemp> dealInfoList = new ArrayList<ErpFunDealDtoTemp>();
		if (erpFunDealList.size() > 0) {
			ErpFunDeal erpFunDeal = erpFunDealList.get(0);
			ErpFunDealDtoTemp erpFunDealDtoTemp = new ErpFunDealDtoTemp();
			BeanUtilsHelper.copyProperties(erpFunDealDtoTemp, erpFunDeal);
			String pfTime = erpProcessFinancMapper.getPfTimeByDealId(cityId, operator.getCompId(), dealId);
			erpFunDealDtoTemp.setPfTime(DateTimeHelper.formatDateTimetoString(pfTime, DateTimeHelper.FMT_yyyyMMdd));
			dealInfoList.add(erpFunDealDtoTemp);
		}
		resultVo.setDealInfo(dealInfoList);
		return ErpResponseJson.ok(resultVo);

	}

	private Boolean isHouseBase(Integer adminCompId) {
		/*****判断是否房基地，如果是，则需要将所有业绩类别都返回，无论有没有人*****/
        AdminFunComp adminFunComp = adminFunCompMapper.selectByPrimaryKey(adminCompId);
		if(null != adminFunComp){
			if(adminFunComp.getCompManagementModel() == 2 && adminFunComp.getCustomizedType() == 1){
				return true;
			}
		}
		return false;
	}

	/***
	 * 合同详情页的---查询业绩明细
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getProfitList")
	public ResponseJson getProfitList(@RequestBody ErpFunProfitDetailParam param) {
		Operator operator = getOperator();
		param.setCompId(operator.getCompId());
		Long totalCount = 0L;
		Set<String> assessMonthSet = new HashSet<>();
		if(StringUtils.isNotBlank(param.getStartTime()) && StringUtils.isNotBlank(param.getEndTime())) {
			if(param.getStartTime().equals(param.getEndTime())) {
				assessMonthSet.add(param.getStartTime());
			}else {
				assessMonthSet = splitAssessmentMonth(param.getStartTime(), param.getEndTime());
			}
		}
		param.setIsNewOrganization(getOperator().newOrganizationType());
		if(param.getIsExport() == 0 && param.getPageOffset() == 1) {
			totalCount = erpFunProfitDetailMapper.getProfitCount(operator.getCityId(), param, assessMonthSet);
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), false);
		List<ErpFunDealDto> erpFunDealDtoList = erpFunProfitDetailMapper.getProfitList(operator.getCityId(), param, assessMonthSet);

		Set<Integer> collect = erpFunDealDtoList.stream().collect(Collectors.mapping(val -> val.getDealId(), Collectors.toSet()));
		// 统计此条件下的数据,分成业绩
		Map<String, Object> resCountMap = new HashMap<>();
		// 分成业绩
		Map<String, Object> dealDataMap = erpFunProfitDetailMapper.getDealDataMap(operator.getCityId(), param, assessMonthSet);
		// 加个结算
		List<Integer> jsDealIdList = erpFunProfitDetailMapper.countJsAmount(operator.getCityId(), param, assessMonthSet);

		if(collect.size() > 0) {
			// 统计应收、实收金额
			Map<String, Object> ysAmount = erpFunDealMapper.sumYsSsAmount(operator.getCityId(), 0, param, assessMonthSet, collect);
			if(null != ysAmount){
				resCountMap.put("ysAmount", ysAmount.get("ysAmount"));
			}
		}
		if(collect.size() > 0) {
			Map<String, Object> ssAmount = erpFunDealMapper.sumYsSsAmount(operator.getCityId(), 1, param, assessMonthSet, collect);
			if (null != ssAmount) {
				resCountMap.put("ssAmount", ssAmount.get("ssAmount"));
			}
		}
		if(null != dealDataMap) {
			resCountMap.putAll(dealDataMap);
		}
		if(null != jsDealIdList && jsDealIdList.size() > 0) {
			// 统计实收金额
			Map<String, Object> jsAmount = erpFunDealMapper.sumJsAmount(operator.getCityId(), jsDealIdList);
			resCountMap.put("jsAmount", jsAmount.get("jsAmount"));
		}
		PageInfo<ErpFunDealDto> pageInfo = new PageInfo<>(erpFunDealDtoList);
		ErpResponseJson ok = ErpResponseJson.ok(pageInfo);
		// 设置返回值
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("dataList", erpFunDealDtoList);
		paramMap.put("countData", resCountMap);
		ok.setData(paramMap);
		ok.setTotal(totalCount);
		return ok;
	}

	private static Set<String> splitAssessmentMonth(String startTime, String endTime) {
		Set<String> resSet = new HashSet<>();
		String startMonth = startTime+"-01";
		String endMonth = endTime+"-01";

		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(DateUtil.StringToDate(startMonth, "yyyy-MM-dd"));
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(DateUtil.StringToDate(endMonth, "yyyy-MM-dd"));

		while(!startCalendar.equals(endCalendar)) {
			Integer year = startCalendar.get(Calendar.YEAR);
			Integer month = startCalendar.get(Calendar.MONTH)+1;
			String m = month + "";
			if(month < 10) {
				m = "0"+month;
			}
			String time = year + "-" + m;
			resSet.add(time);
			startCalendar.add(Calendar.MONTH, 1);
		}
		resSet.add(endTime);
		return resSet;
	}

	/***
	 * 业绩详细信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getProfitDetail")
	public ResponseJson getProfitDetail(@RequestBody ErpFunProfitDetailParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer dealId = param.getDealId();

		// 查询实收款项
		ErpProcessFinancExample erpProcessFinancExample = new ErpProcessFinancExample();
		erpProcessFinancExample.setShardCityId(cityId);
		erpProcessFinancExample.setOrderByClause("PF_ID ");
		ErpProcessFinancExample.Criteria criteria = erpProcessFinancExample.createCriteria().andCompIdEqualTo(compId).andDealIdEqualTo(dealId).andPfActualEqualTo((byte) 1);
		if(null != param.getPerformanceId()) {
			criteria.andPerformanceTypeEqualTo(param.getPerformanceId());
		}
		List<ErpProcessFinanc> financList = erpProcessFinancMapper.selectByExample(erpProcessFinancExample);

		// 查询业绩明细
		ErpFunProfitExample erpFunProfitExample = new ErpFunProfitExample();
		erpFunProfitExample.setShardCityId(cityId);
		ErpFunProfitExample.Criteria criteria1 = erpFunProfitExample.createCriteria().andCompIdEqualTo(compId).andDealIdEqualTo(dealId);
		if(null != param.getPerformanceId()) {
			criteria1.andPerformanceTypeEqualTo(param.getPerformanceId());
		}
		List<ErpFunProfit> erpFunProfits = erpFunProfitMapper.selectByExample(erpFunProfitExample);
		Map<String, Object> resMap = new HashMap<>();
		resMap.put("profitList", erpFunProfits);
		resMap.put("processFinancList", financList);
		return ErpResponseJson.ok(resMap);
	}

	/**
	 * @Title 根据结算日和月份计算时间段
	 * @Author lcb
	 * @Date 2018/1/31
	 * @Param
	 **/
	private static Date[] getWageCycleDate2(String aountDay, String assessMonth) {

		if(StringUtils.isBlank(aountDay)) {
			aountDay = "01";
		}
		if(StringUtils.isBlank(assessMonth)) {
			return new Date[]{null,null};
		}
		// 分割日
		String splitDay = assessMonth+"-"+aountDay;
		Date date = DateUtil.StringToDate(splitDay, "yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		Date startTime = calendar.getTime();

		calendar.add(Calendar.MONTH, 1);
		Date endTime = calendar.getTime();
		return new Date[]{startTime, endTime};
	}

	public static void main(String[] args) {
//		Date[] wageCycleDate2 = getWageCycleDate2("05", "2017-08");
		String orgIds = ":12001:12:12:";
		orgIds = orgIds.substring(1,orgIds.length() -1);
		Integer a = 1;
		Integer b = null;

		System.out.println(orgIds);
	}

	/***
	 * 周考核日考核列表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getWorkCountTargetList")
	public ResponseJson getWorkCountTargetList(@RequestBody ErpFunWorkCountTargetParam param) throws Exception{
		Operator operator = getOperator();

		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
//		if(param.getIsExport() == 0) {
//			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
//		}
		param.setCityId(cityId);
		param.setCompId(compId);
//		List<ErpFunWorkCountTargetDto> resList = erpNoTransactionService.getWorkCountTargetList(param);
		//加盟商逻辑
		setPartnerIdsForQuery(param, operator);
		List<ErpFunWorkCountTargetDto> resList = erpFunWorkcountTargetMapper.getWorkCountTargetList(cityId, param);
		PageInfo pageInfo = new PageInfo<>(resList);
		return ErpResponseJson.ok(pageInfo);
	}

	private void setPartnerIdsForQuery(ErpFunWorkCountTargetParam param, Operator operator) {
		if (!Objects.equals(operator.openPartner(), 1)) {
			return;
		}
		//隔离参数是否独立配置
		PartnerConfigDto configuration = erpFunPartnerConfigService.getPartnerConfiguration(operator.getCityId(),operator.getCompId());
		if (Objects.isNull(configuration) || !Objects.equals(configuration.getWageApart(), (byte)1)) {
			return;
		}
		Integer selfPartner = operator.getPartnerId();
		if (selfPartner == 0) {
			//总部可查看所有;
		} else if (selfPartner > 0) {
			//加盟查看对应加盟商数据
			param.setPartnerIds(Collections.singletonList(selfPartner));
		}else {
			//直营查看直营及总部数据
			param.setPartnerIds(Arrays.asList(-1,0));
		}
	}

	/***
	 * 设置考核目标
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateWorkCountTargetDetail")
	public ResponseJson updateWorkCountTargetDetail(@RequestBody ErpFunWorkCountTargetParam param) throws Exception{
		Operator operator = getOperator();
		Integer resCount = erpFunWorkcountTargetService.updateWorkCountTargetDetail(operator.getCityId(), getOperator().getCompId(), param);
		return ErpResponseJson.ok(resCount);
	}

	/***
	 * 设置考核目标
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/appUpdateWorkCountTargetDetail")
	@ApiOperation("掌通设置考核目标 需求：")
	@ResponseBody
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	public ResponseJson appUpdateWorkCountTargetDetail(@RequestBody AppFunWorkCountTargetParam param) throws Exception{
		Operator operator = getOperator();
		//无限组织机构模式
		erpFunWorkcountTargetService.updateWorkCountTargetForOrg(operator.getCityId(), getOperator().getCompId(), param);
		return ErpResponseJson.ok();
	}

	private void setPartnerIdsForOrgUpdate(AppFunWorkCountTargetParam param, Operator operator) {
		if (!Objects.equals(operator.openPartner(), 1)) {
			param.setSeparationConfig(false);
			param.setPartnerId(-1);
			return;
		}
		PartnerConfigDto configuration = erpFunPartnerConfigService.getPartnerConfiguration(operator.getCityId(), operator.getCompId());
		if (Objects.isNull(configuration) || !Objects.equals(configuration.getWageApart(), (byte)1)) {
			param.setSeparationConfig(false);
			param.setPartnerId(-1);
			return;
		}
		//总部设置加盟商或直营时门店对应的partnerId
		param.setSeparationConfig(true);
		ErpFunOrganization org = null;
		Integer orgPartnerId = -1;
		if (Objects.nonNull(param.getOrganizationId()) && param.getOrganizationId() > 0) {
			org = erpFunOrganizationMapper.selectOrgByOrgId(operator.getCityId(), operator.getCompId(), param.getOrganizationId());
			orgPartnerId = org.getPartnerId();
		}
		Integer selfPartner = operator.getPartnerId();
		if (selfPartner == 0) {
			if (orgPartnerId <= 0) {
				param.setPartnerIds(Arrays.asList(-1,0));
			}else {
				param.setPartnerIds(Collections.singletonList(orgPartnerId));
			}
		} else if (selfPartner > 0) {
			//加盟
			if (null != org) {
				Assert.isTrueThrow(!selfPartner.equals(org.getPartnerId()), "不能修改其他分组门店配置!");
			}
			param.setPartnerIds(Collections.singletonList(orgPartnerId));
		}else {
			//直营
			Assert.isTrueThrow(!selfPartner.equals(param.getPartnerId()), "不能修改其他分组门店配置!");
			param.setPartnerIds(Collections.singletonList(-1));
		}
	}

	private void setPartnerIdsForUpdate(AppFunWorkCountTargetParam param, Operator operator) {
		if (!Objects.equals(operator.openPartner(), 1)) {
			param.setSeparationConfig(false);
			param.setPartnerId(-1);
			return;
		}
		PartnerConfigDto configuration = erpFunPartnerConfigService.getPartnerConfiguration(operator.getCityId(), operator.getCompId());
		if (Objects.isNull(configuration) || !Objects.equals(configuration.getWageApart(), (byte)1)) {
			param.setSeparationConfig(false);
			param.setPartnerId(-1);
			return;
		}
		//总部设置加盟商或直营时门店对应的partnerId
		param.setSeparationConfig(true);
		ErpFunDepts erpFunDepts = null;
		if (Objects.nonNull(param.getDeptId())) {
			erpFunDepts = erpFunDeptsMapper.selectByPrimaryKey(new ErpFunDepts(operator.getCityId(), param.getDeptId()));
			Assert.isNullThrow(erpFunDepts,"门店不存在!");
			param.setPartnerId(erpFunDepts.getPartnerId());
		}
		Integer selfPartner = operator.getPartnerId();
		Integer paramPartner = param.getPartnerId();
		if (selfPartner == 0) {
			//总部可修改加盟数据
			if (paramPartner <= 0) {
				param.setPartnerIds(Arrays.asList(-1,0));
			}else {
				param.setPartnerIds(Collections.singletonList(paramPartner));
			}
		} else if (selfPartner > 0) {
			//加盟
			if (null != erpFunDepts) {
				Assert.isTrueThrow(!selfPartner.equals(erpFunDepts.getPartnerId()), "不能修改其他分组门店配置!");
			}
			param.setPartnerIds(Collections.singletonList(paramPartner));
		}else {
			//直营
			Assert.isTrueThrow(!selfPartner.equals(param.getPartnerId()), "不能修改其他分组门店配置!");
			param.setPartnerIds(Collections.singletonList(-1));
		}
	}

	@RequestMapping("/getWorkCountTargetDetail")
	@ApiOperation("通过范围和角色获取考核目标数据,作者:陈峰,需求:9250")
	@ResponseBody
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = AppFunWorkCountTargetDetailVO.class, message = "成功")
	})
	public ResponseJson getWorkCountTargetDetail(@RequestBody @Valid AppFunWorkCountTargetDetailParam param) throws Exception {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Byte rangeType = param.getRangeType();
		Integer rangeId = param.getRangeId();
		String userPosition = param.getUserPosition();
		
		/**
		 * rangeType = 1 的时候 rangeId = null  全公司
		 * rangeType = 4 的时候 rangeId = 111（必须有值）	某一门店
		 * 
		 * userPosition	= "" 的时候 全角色
		 * userPosition	= "GENERL_MANAGER" 的时候 某一角色
		 * 
		 * 同样对应四种创建配置的情况。
		 */
		param.setPartnerId(operator.getPartnerId());
		setPartnerId(operator,param);
		AppFunWorkCountTargetDetailVO vo = new AppFunWorkCountTargetDetailVO();
		if (operator.newOrganizationType() && !Objects.equals(param.getRangeType(),(byte)6)) {
			getWorkCountTargetTemplateForOrgModel(cityId, compId, param, vo);
		} else {
			getWorkCountTargetTemplateForDeptModel(cityId, compId, param, vo);
		}

		return ErpResponseJson.ok(vo);
	}



	private void getWorkCountTargetTemplateForOrgModel(Integer cityId, Integer compId, AppFunWorkCountTargetDetailParam param, AppFunWorkCountTargetDetailVO vo) {
		String userPosition = Optional.ofNullable(param.getUserPosition()).orElse("");
		Integer partnerId = param.getPartnerId();
		Integer orgId = Optional.ofNullable(param.getOrganizationId()).orElse(0);
		List<Integer> queryOrgIds = new ArrayList<>();
		queryOrgIds.add(0);//全司默认
		ErpFunOrganization organization = null;
		if (orgId != 0) {
			organization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, orgId);
			Assert.isNullThrow(organization, "组织不存在!");
			String orgPath = organization.getOrganizationPath();
			List<Integer> orgIds = Stream.of(orgPath.split(":")).filter(StringUtil::isNotBlank).map(Integer::parseInt).collect(Collectors.toList());
			if (!orgIds.isEmpty()) {
				List<ErpFunOrganization> orgList = erpFunOrganizationMapper.selectOrgByOrgIds(cityId, compId, orgIds);
				if (param.isSeparationConfig() && param.getPartnerId() >= 0) {//加盟商情况下过滤掉非上层非加盟商组织
					orgList = orgList.stream().filter(obj -> Objects.equals(obj.getPartnerId(), partnerId)).collect(Collectors.toList());
					final List<Integer> ids = orgList.stream().map(ErpFunOrganization::getOrganizationId).collect(Collectors.toList());
					orgIds = orgIds.stream().filter(id->!ids.contains(id)).collect(Collectors.toList());
				}
				queryOrgIds.addAll(orgIds);
			}
		}
		ErpFunWorkcountTargetOrgTemplateExample ex = new ErpFunWorkcountTargetOrgTemplateExample();
		ex.setShardCityId(cityId);
		ex.createCriteria().andCompIdEqualTo(compId).andUserPositionIn(Arrays.asList(userPosition, "")).andOrganizationIdIn(queryOrgIds);
		List<ErpFunWorkcountTargetOrgTemplate> list = erpFunWorkcountTargetOrgTemplateMapper.selectByExample(ex);
		AppFunWorkCountTargetSubVo dayTemplate = deduceTargetTemplate(list, queryOrgIds, userPosition, (byte) 1);//日工作目标
		AppFunWorkCountTargetSubVo weekTemplate = deduceTargetTemplate(list, queryOrgIds, userPosition, (byte) 2);//周工作目标
		AppFunWorkCountTargetSubVo monthTemplate = deduceTargetTemplate(list, queryOrgIds, userPosition, (byte) 3);//月工作目标
		vo.setDayDetail(dayTemplate);
		vo.setWeekDetail(weekTemplate);
		vo.setMonthDetail(monthTemplate);
	}

	/**
	 * 逻辑见：
	 * @see ErpFunWorkcountTargetServiceImpl#updateWorkCountTargetForOrg(Integer, Integer, AppFunWorkCountTargetParam)
	 * @param list
	 * @param queryOrgIds
	 * @param userPosition
	 * @param targetType
	 * @return
	 */
	private AppFunWorkCountTargetSubVo deduceTargetTemplate(List<ErpFunWorkcountTargetOrgTemplate> list, List<Integer> queryOrgIds,final String userPosition,final byte targetType) {
		//由下向上查找
		Map<Integer, ErpFunWorkcountTargetOrgTemplate> map = list.stream()
				.filter(obj -> Objects.equals(obj.getTargetType(), targetType))
				.filter(obj-> Objects.equals(obj.getUserPosition(), userPosition) || Objects.equals(obj.getUserPosition(), ""))
				.collect(Collectors.toMap(ErpFunWorkcountTargetOrgTemplate::getOrganizationId, Function.identity(), (e1, e2) -> {
					if (Objects.equals(e1.getUserPosition(), userPosition)) {//优先使用userPosition相等的，再考虑为''的
						return e1;
					}else {
						return e2;
					}
				}));

		ListIterator<Integer> lIt = queryOrgIds.listIterator(queryOrgIds.size());
		while (lIt.hasPrevious()) {
			Integer id = lIt.previous();
			ErpFunWorkcountTargetOrgTemplate template = map.get(id);
			if (Objects.nonNull(template)) {
				AppFunWorkCountTargetSubVo vo = new AppFunWorkCountTargetSubVo();
				BeanUtils.copyProperties(template,vo);
				return vo;
			}
		}
		return null;
	}

	/**
	 * 原门店版
	 * @param cityId
	 * @param compId
	 * @param param
	 * @param appFunWorkCountTargetDetailVO
	 * @throws Exception
	 */
	private void getWorkCountTargetTemplateForDeptModel(Integer cityId, Integer compId, AppFunWorkCountTargetDetailParam param, AppFunWorkCountTargetDetailVO appFunWorkCountTargetDetailVO) throws Exception {
		Byte rangeType = param.getRangeType();
		Integer rangeId = param.getRangeId();
		String userPosition = param.getUserPosition();
		List<ErpFunWorkcountTarget> erpFunWorkcountTargetList = new ArrayList<ErpFunWorkcountTarget>();
		if(null != rangeType && rangeType != 6){
			if (1 == rangeType && null == rangeId && StringUtils.isBlank(userPosition)) {// 全公司全角色查询
				erpFunWorkcountTargetList = getTarget(cityId, compId, param.isSeparationConfig(),param.getPartnerId(), rangeType, 0, userPosition);
			} else if (1 == rangeType && null == rangeId && StringUtils.isNotBlank(userPosition)) {// 全公司某一角色
				erpFunWorkcountTargetList = getTarget(cityId, compId,  param.isSeparationConfig(), param.getPartnerId(), rangeType, 0, userPosition);
			} else if (1 != rangeType && null != rangeId && StringUtils.isBlank(userPosition)) {// 某一范围和全部角色
				erpFunWorkcountTargetList = getTarget(cityId, compId,  param.isSeparationConfig(), param.getPartnerId(), rangeType, rangeId, userPosition);
			} else if (1 != rangeType && null != rangeId && StringUtils.isNotBlank(userPosition)) {// 某一范围某一角色
				erpFunWorkcountTargetList = getTarget(cityId, compId,  param.isSeparationConfig(), param.getPartnerId(), rangeType, rangeId, userPosition);
			}
		} else if (null != rangeType && rangeType == 6){
			erpFunWorkcountTargetList = erpFunWorkcountTargetMapper.getWorkCountOutOfUseTarget(cityId, compId, rangeType, rangeId, userPosition);
		}
		if (erpFunWorkcountTargetList.isEmpty()) {
			return;
		}
		Map<Byte, ErpFunWorkcountTarget> targetTypeMap = erpFunWorkcountTargetList.stream().collect(Collectors.toMap(ErpFunWorkcountTarget:: getTargetType, val -> val, (o, n) -> o));
		if (null != targetTypeMap) {
			ErpFunWorkcountTarget dayDetailWorkcountTarget = targetTypeMap.get(Byte.valueOf("1"));
			AppFunWorkCountTargetSubVo appFunWorkCountTargetSubVo;
			if (null != dayDetailWorkcountTarget) {
				appFunWorkCountTargetSubVo = new AppFunWorkCountTargetSubVo();
				BeanUtil.copyObject(dayDetailWorkcountTarget, appFunWorkCountTargetSubVo);
				appFunWorkCountTargetDetailVO.setDayDetail(appFunWorkCountTargetSubVo);
			}
			ErpFunWorkcountTarget weekDetailWorkcountTarget = targetTypeMap.get(Byte.valueOf("2"));
			if (null != weekDetailWorkcountTarget) {
				appFunWorkCountTargetSubVo = new AppFunWorkCountTargetSubVo();
				BeanUtil.copyObject(weekDetailWorkcountTarget, appFunWorkCountTargetSubVo);
				appFunWorkCountTargetDetailVO.setWeekDetail(appFunWorkCountTargetSubVo);
			}
			ErpFunWorkcountTarget monthDetailWorkcountTarget = targetTypeMap.get(Byte.valueOf("3"));
			if (null != monthDetailWorkcountTarget) {
				appFunWorkCountTargetSubVo = new AppFunWorkCountTargetSubVo();
				BeanUtil.copyObject(monthDetailWorkcountTarget, appFunWorkCountTargetSubVo);
				appFunWorkCountTargetDetailVO.setMonthDetail(appFunWorkCountTargetSubVo);
			}
		}
	}

	private void setPartnerId(Operator operator,AppFunWorkCountTargetDetailParam param) {


		Integer deptId = null;//总部查询门店
		if (Objects.equals((byte)4, param.getRangeType())) {
			deptId = param.getRangeId();
		}
		if (!Objects.equals(operator.openPartner(), 1)) {
			param.setSeparationConfig(false);
			return;
		}
		PartnerConfigDto configuration = erpFunPartnerConfigService.getPartnerConfiguration(operator.getCityId(), operator.getCompId());
		if (Objects.isNull(configuration) || !Objects.equals(configuration.getWageApart(), (byte)1)) {
			param.setSeparationConfig(false);
			return;
		}
		//总部设置加盟商或直营时门店对应的partnerId
		param.setSeparationConfig(true);
		Integer partnerId = operator.getPartnerId();
		param.setPartnerId(partnerId);
		ErpFunDepts erpFunDepts = null;
		if (Objects.nonNull(deptId)) {
			erpFunDepts = erpFunDeptsMapper.selectByPrimaryKey(new ErpFunDepts(operator.getCityId(),deptId));
			Assert.isNullThrow(erpFunDepts,"门店不存在!");
//			if (!Objects.equals(operator.getPartnerId(), 0) && !Objects.equals(erpFunDepts.getPartnerId(), partnerId)) {
//				throw new BusinessException("您无权查看该门店工作目标配置!");
//			}
			param.setPartnerId(erpFunDepts.getPartnerId());
		}
	}

	/**
	 * 获取配置的目标量   这些配置可能在门店或者公司级别
	 * @param cityId
	 * @param compId
	 * @param rangeType
	 * @param deptId
	 * @param userPosition
	 */
	private List<ErpFunWorkcountTarget> getTarget(Integer cityId, Integer compId, boolean  separationConfig, Integer partnerId, Byte rangeType, Integer deptId, String userPosition) {
		List<ErpFunWorkcountTargetTemplate> erpFunWorkcountTargetTemplateList = erpFunWorkcountTargetTemplateMapper.getWorkcountTargetTemplate(cityId, compId,separationConfig,partnerId, rangeType, deptId, userPosition);
		List<ErpFunWorkcountTarget> erpFunWorkcountTargetList = new ArrayList<ErpFunWorkcountTarget>();
		try {
			for (ErpFunWorkcountTargetTemplate erpFunWorkcountTargetTemplate : erpFunWorkcountTargetTemplateList) {
				ErpFunWorkcountTarget erpFunWorkcountTarget = new ErpFunWorkcountTarget();
				BeanUtil.copyObject(erpFunWorkcountTargetTemplate, erpFunWorkcountTarget);
				erpFunWorkcountTargetList.add(erpFunWorkcountTarget);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return erpFunWorkcountTargetList;
	}

	/**
	 * @Title 合同相关流水信息查询
	 * @Author lcb
	 * @Date 2018/3/8
	 * @Param
	 **/
	@RequestMapping("/getDealProfitDetailList")
	public ResponseJson getDealProfitDetailList(@RequestBody ErpFunProfitDetailParam param) throws Exception{
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer dealId = param.getDealId();

		// 查询本合同流水信息
		ErpFunProfitDetailExample example = new ErpFunProfitDetailExample();
		example.setShardCityId(cityId);
		example.createCriteria().andCompIdEqualTo(compId).andDealIdEqualTo(dealId).andDelFlagEqualTo((byte) 0);
		example.setOrderByClause(" ID ASC");

		List<ErpFunProfitDetail> resList = erpFunProfitDetailMapper.selectByExample(example);
		Map<String, Object> resMap = new HashMap<>();
		if(resList.size() > 0) {
			ErpFunDeal erpFunDeal = new ErpFunDeal();
			erpFunDeal.setShardCityId(cityId);
			erpFunDeal.setDealId(dealId);
			erpFunDeal = erpFunDealMapper.selectByPrimaryKey(erpFunDeal);

			resMap.put("dealData", erpFunDeal);
			resMap.put("profitDetailList", resList);
			Set<Integer> pfIdSet = resList.stream().collect(Collectors.mapping(ErpFunProfitDetail::getPfId, Collectors.toSet()));
			// 查询款项
			ErpProcessFinancExample erpProcessFinancExample = new ErpProcessFinancExample();
			erpProcessFinancExample.setShardCityId(cityId);
			erpProcessFinancExample.createCriteria().andDealIdEqualTo(dealId).andPfIdIn(new ArrayList<>(pfIdSet));
			erpProcessFinancExample.setOrderByClause(" AUDIT_TIME ASC");
			List<ErpProcessFinanc> processFinancList = erpProcessFinancMapper.selectByExample(erpProcessFinancExample);
			resMap.put("processFinancList", processFinancList);



			ErpFunProfitExample erpFunProfitExample = new ErpFunProfitExample();
			erpFunProfitExample.setShardCityId(cityId);
			erpFunProfitExample.createCriteria().andCompIdEqualTo(compId).andDealIdEqualTo(dealId);

			List<ErpFunProfit> erpFunProfits = erpFunProfitMapper.selectByExample(erpFunProfitExample);

			resMap.put("funProfitList", erpFunProfits);
		}

		return ErpResponseJson.ok(resMap);
	}

    /**
     * @author 邓永洪
     * @tag 获取业绩类别列表
     * @since 2018/4/17
     */
	@ApiOperation("获取业绩类别列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunPerformanceTypeResultVo.class, message = "成功")
	})
    @PostMapping("/getFunPerformanceTypeList")
    public ResponseJson getFunPerformanceTypeList() {
        Integer compId = getOperator().getCompId();
        Integer cityId = getOperator().getCityId();
        List<ErpFunPerformanceType> list = erpFunPerformanceTypeMapper.getDataListByCompId(cityId, compId);
        if (list.isEmpty()) {
        	erpFunPerformanceTypeMapper.insertFunPerforManceType(getOperator().getCityId(), getOperator().getCompId());
            list = erpFunPerformanceTypeMapper.getDataListByCompId(cityId, compId);
        }
		ErpFunPerformanceTypeResultVo resultVo = new ErpFunPerformanceTypeResultVo();
        resultVo.setList(list);
        return ErpResponseJson.ok(resultVo);
    }
	
	@ApiOperation("app获取业绩类别列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = AppFunPerformanceTypeListResultVO.class, message = "成功")
	})
    @PostMapping("/getAppFunPerformanceTypeList")
    public ResponseJson getAppFunPerformanceTypeList() {
        Integer compId = getOperator().getCompId();
        Integer cityId = getOperator().getCityId();
        List<ErpFunPerformanceType> list = erpFunPerformanceTypeMapper.getDataListByCompId(cityId, compId);
        if (list.isEmpty()) {
        	erpFunPerformanceTypeMapper.insertFunPerforManceType(getOperator().getCityId(), getOperator().getCompId());
            list = erpFunPerformanceTypeMapper.getDataListByCompId(cityId, compId);
        }
        List<AppFunPerformanceTypeVO> performanceTypeListVO = new ArrayList<>();
        for (int i = 0;i<list.size();i++){
        	ErpFunPerformanceType erpFunPerformanceType = list.get(i);
        	AppFunPerformanceTypeVO appFunPerformanceTypeVO = new AppFunPerformanceTypeVO();
        	BeanUtils.copyProperties(erpFunPerformanceType, appFunPerformanceTypeVO);
        	performanceTypeListVO.add(appFunPerformanceTypeVO);
        }
        AppFunPerformanceTypeListResultVO appFunPerformanceTypeListResultVO = new AppFunPerformanceTypeListResultVO();
        appFunPerformanceTypeListResultVO.setPerformanceTypeList(performanceTypeListVO);
        return ErpResponseJson.ok(appFunPerformanceTypeListResultVO);
    }
	


    /**
     * @author 邓永洪
     * @tag 获取业绩目标列表
     * @since 2018/4/17
     */
	@ApiOperation("获取业绩目标列表，作者=邓永洪")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = MgrProfiTargetVo.class, message = "成功")
	})
    @PostMapping("/getMgrProfiTarget")
    public ResponseJson getMgrProfiTarget(@RequestBody MgrProfiTargetParam param) {
		Operator operator = getOperator();
        Integer profitType = param.getProfitType();
        String date = param.getTime();
		Integer userId = param.getUserId();
		Integer grId = param.getGrId();
		Integer deptId = param.getDeptId();
		Integer regId = param.getRegId();
		Integer areaId = param.getAreaId();
		Integer defId = param.getDefId();
		Integer organizationId = param.getOrganizationId();
		if(operator.newOrganizationType()){
			profitType = Const.DIC_PROFIT_COUNT_TYPE_NEW_ORGANIZATION;
		}
		// 起止时间
		Calendar calendar = Calendar.getInstance();
		if (StringUtils.isNotBlank(date)) {
			calendar.setTime(DateTimeHelper.parseToDate(date));
		}
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		String startTime = DateTimeHelper.formatDateTimetoString(calendar.getTime(), DateTimeHelper.FMT_yyyyMMdd);
		calendar.add(Calendar.MONTH, 1);
		String endTime = DateTimeHelper.formatDateTimetoString(calendar.getTime(), DateTimeHelper.FMT_yyyyMMdd);
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("profitType", profitType);
		paramMap.put("compId", getOperator().getCompId());
		paramMap.put("userId", userId);
		paramMap.put("date", date);
		paramMap.put("grId", grId);
		paramMap.put("deptId", deptId);
		paramMap.put("regId", regId);
		paramMap.put("areaId", areaId);
		paramMap.put("startTime", startTime);
		paramMap.put("endTime", endTime);
		paramMap.put("defId", param.getDefId());
		paramMap.put("organizationId", param.getOrganizationId());
		List<ErpFunProfitTarget> funProfits = erpFunProfitTargetMapper.getProfitListByMap(getOperator().getCityId(), paramMap);
		List<ErpFunProfitTarget> resultList = new ArrayList();
		Set<Integer> rangeSet = null;
		rangeSet = getRangeIdsByProfitType(getOperator().getCompId().toString(), areaId, regId, deptId, grId, userId, profitType, date,defId,organizationId);

		Map<Integer, ErpFunProfitTarget> fptMap = buildProfitTargetMapByType(funProfits, profitType);
		for (Integer rangeId : rangeSet) {
			ErpFunProfitTarget funProfitTarget = fptMap.get(rangeId);
			if (CommonUtil.isnull(funProfitTarget)) {
				funProfitTarget = new ErpFunProfitTarget();
				funProfitTarget.setProfitType(profitType.byteValue());
				funProfitTarget.setTargetProfit(new BigDecimal(0));
				funProfitTarget.setAreaId(areaId);
				funProfitTarget.setRegId(regId);
				funProfitTarget.setDeptId(deptId);
				funProfitTarget.setUserId(userId);
				if (Const.DIC_PROFIT_COUNT_TYPE_AREA == profitType && rangeId != null) {
					funProfitTarget.setAreaId(rangeId);
				} else if (Const.DIC_PROFIT_COUNT_TYPE_REG == profitType && rangeId != null) {
					funProfitTarget.setRegId(rangeId);
				} else if (Const.DIC_PROFIT_COUNT_TYPE_DEPT == profitType && rangeId != null) {
					funProfitTarget.setDeptId(rangeId);
				} else if (Const.DIC_PROFIT_COUNT_TYPE_GROUP == profitType && rangeId != null) {
					funProfitTarget.setGrId(rangeId);
				} else if (Const.DIC_PROFIT_COUNT_TYPE_USER == profitType && rangeId != null) {
					funProfitTarget.setUserId(rangeId);
				} else if (Const.DIC_PROFIT_COUNT_TYPE_NEW_ORGANIZATION == profitType && rangeId != null){
					if(null != defId && "-2".equals(defId)){//员工
						funProfitTarget.setUserId(rangeId);
					} else {
						funProfitTarget.setOrganizationId(rangeId);
					}
				}
			}
			resultList.add(funProfitTarget);
		}
		MgrProfiTargetVo vo = new MgrProfiTargetVo();
		if (!CollectionUtils.isEmpty(resultList)) {
			vo.getResultList().addAll(resultList);
		}
		return ErpResponseJson.ok(vo);
	}

	/**
	 * @author 邓永洪
	 * @tag 业绩信息-获取某个人的业绩详细信息
	 * @since 2018/4/18
	 */
	@ApiOperation("获取某个人的业绩详细信息")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ProfitDetailListInfoVo.class, message = "成功")
	})
	@PostMapping("/getProfitDetailInfoList")
	public ResponseJson getProfitDetailInfoList(@RequestBody ProfitDetailInfoListParam param) {
		String startTime = param.getDate1();
		if (startTime.length() > "2015-05".length()) {//前端有时候传 2015-05 有时候传 2015-05-01 这里做兼容处理
			startTime = startTime.substring(0, "2015-05".length());
		}
		startTime = startTime + "-01";
		String endTime = CommonUtil.getFirstDateOfNextMonth(param.getDate2() + "-01");

		Integer userId = param.getUserId();
		Integer deptId = param.getDeptId();
		Integer dealType = param.getDealType();
		Integer dealStatus = param.getDealStatus();
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("compId", getOperator().getCompId());
		paramMap.put("userId", userId);
		paramMap.put("deptId", deptId);
		paramMap.put("dealType", dealType);
		paramMap.put("dealStatus", dealStatus);
		paramMap.put("startTime", startTime);
		paramMap.put("endTime", endTime);
		List<ProfitDetailVo> data = erpFunProfitMapper.getProfitDetailInfoList(getOperator().getCityId(), paramMap);
		ProfitDetailListInfoVo resultVo = new ProfitDetailListInfoVo();
		resultVo.setList(data);
		return ErpResponseJson.ok(resultVo);
	}

	/**
	 * @author 邓永洪
	 * @tag 获取业绩信息
	 * @since 2018/4/18
	 */
	@ApiOperation("获取业绩信息")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ResponseJson.class, message = "成功")
	})
	@RequestMapping("/getProfitBaseInfoList")
	public ResponseJson getProfitBaseInfoList(@RequestBody ProfitBaseInfoParam param) {
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		String date1 = CommonUtil.getFirstDateOfMonth(param.getDate1() + "-01");
		String date2 = CommonUtil.getFirstDateOfNextMonth(param.getDate2() + "-01") + " 23:59:59";
		param.setDate1(date1);
		param.setDate2(date2);
		param.setCompId(compId);
		param.setIsNewOrganization(getOperator().newOrganizationType());
		Integer totalCount = erpFunProfitMapper.countProfitBaseInfo(cityId, param);
		//获取业绩统计
		List<ProfitBaseInfoDto> baseInfoList = new ArrayList<>();
		if (totalCount > 0) {
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), false);
			baseInfoList = erpFunProfitMapper.getProfitBaseInfoList(cityId, param);
		}
		Map<String, Object> statisticsMap = erpFunProfitMapper.getProfitStatistics(cityId, param);
		ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
		erpFunUsersExample.setShardCityId(cityId);
		erpFunUsersExample.createCriteria().andCompIdEqualTo(compId);
		List<ErpFunUsers> funUsersList = erpFunUsersMapper.selectByExample(erpFunUsersExample);
		Map<String, ErpFunUsers> userMap = BeanUtil.listObjToMapObj(funUsersList, "userId");
		for (ProfitBaseInfoDto baseInfoDto : baseInfoList) {
			ErpFunUsers usersPO = userMap.get(baseInfoDto.getUserId().toString());
			if (usersPO == null) {
				logger.info("不存在的用户: " + baseInfoDto.getUserId());
				continue;
			}
			baseInfoDto.setUserName(usersPO.getUserName());
		}
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("resultList", baseInfoList);
		resultMap.put("money", statisticsMap);
		List<Map<String, Object>> ret = new ArrayList<>();
		ret.add(resultMap);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo(ret);
		pageInfo.setTotal(totalCount);
		return ErpResponseJson.ok(pageInfo);
	}

	/**
	 * 插入业绩目标
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/23
	 */
	@ApiOperation("插入业绩目标")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@PostMapping("/insertMgrProfiTarget")
	public ResponseJson insertMgrProfiTarget(@RequestBody InsertProfitTargetListParam param) {
		int i = 1;
		List<MgrProfiTargetParamForInsert> targetList = param.getTargetList();
		if (CollectionUtils.isEmpty(targetList)) {
			return ErpResponseJson.ok();
		}
		String profitDate = param.getTargetDate();// 业绩的月份
		Integer cityId=getOperator().getCityId();
		Integer compId=getOperator().getCompId();
		List<ErpFunProfitTarget> profitTargetPOList = new ArrayList<>();
		Boolean newOrg = getOperator().newOrganizationType();//判断是否是新组织
		Byte profitType =null;
		List<ErpFunUsers> usersList=erpFunUsersMapper.getFunUsersListByCompId(cityId,compId);
		Map<Integer, ErpFunUsers> usersMap=usersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, val->val));
		double profitMoneySum = 0;
		for (MgrProfiTargetParamForInsert targetParam : targetList){
			profitType = targetParam.getProfitType();// 同一批业绩必须是同一类型的业绩
			ErpFunProfitTarget temProfitTargetPO = new ErpFunProfitTarget();// 构造一个业绩
			if(newOrg){
				profitType = Const.DIC_PROFIT_COUNT_TYPE_NEW_ORGANIZATION.byteValue();

				String orgPath = "";
				Integer nowOrgId = 0;
				if(null != targetParam.getUserId()){
					ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, targetParam.getUserId());
					if(null != erpFunUsers){
						orgPath = erpFunUsers.getTissueLine();
						nowOrgId = erpFunUsers.getOrganizationId();
						temProfitTargetPO.setDefId(-2);
					}
				} else if (null != targetParam.getOrganizationId()){
					ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, targetParam.getOrganizationId());
					if(null != erpFunOrganization){
						orgPath = erpFunOrganization.getOrganizationPath();
						nowOrgId = erpFunOrganization.getOrganizationId();
					}
					temProfitTargetPO.setDefId(erpFunOrganization.getOrganizationDefinitionId());
				}
				if(StringUtil.isNotEmpty(orgPath)){
					orgPath = orgPath.substring(1,orgPath.length() -1);
					orgPath = orgPath.replaceAll(":",",");
					List<ProfiTargetNewOrgVO> orgs = erpFunOrganizationMapper.selectOrgByOrgPath(cityId, compId, orgPath);
					if(null != orgs) {
						for (ProfiTargetNewOrgVO profiTargetNewOrgVO : orgs) {
							// 对应字段名
							String columnName = profiTargetNewOrgVO.getMappingDbField();
							columnName = StringUtil.setMethodName(columnName);
							// 找指定的组织机构ID
							try{
								Method[] methods = temProfitTargetPO.getClass().getMethods();
								for (Method method : methods) {
									if(columnName.equals(method.getName())) {
										method.invoke(temProfitTargetPO,profiTargetNewOrgVO.getOrgId());
									}
								}
							}catch (Exception e) {
								e.printStackTrace();
							}
						}
						temProfitTargetPO.setOrganizationId(nowOrgId);
						temProfitTargetPO.setOrganizationPath(orgPath);
					}
				}
			}
			String profitMoneyValue = targetParam.getTargetProfit();
			temProfitTargetPO.setTargetDate(DateTimeHelper.parseToDate(profitDate));// 业绩的月份
			temProfitTargetPO.setCreateTime(new Date());// 业绩创建时间
			temProfitTargetPO.setTargetProfit(new BigDecimal(profitMoneyValue));
			temProfitTargetPO.setCompId(compId);
			temProfitTargetPO.setAreaId(targetParam.getAreaId());
			temProfitTargetPO.setRegId(targetParam.getRegId());
			temProfitTargetPO.setDeptId(targetParam.getDeptId());
			temProfitTargetPO.setGrId(targetParam.getGrId());
			Integer userId = targetParam.getUserId();
			temProfitTargetPO.setUserId(userId);
			if(userId!=null){
				ErpFunUsers funUsersPO = usersMap.get(userId);
				if(funUsersPO != null){
					temProfitTargetPO.setGrId(funUsersPO.getGrId());
					temProfitTargetPO.setArchiveId(funUsersPO.getArchiveId());
				}
			}
			temProfitTargetPO.setProfitType(profitType);
			temProfitTargetPO.setId(targetParam.getId());// 主键,有的话就是更新,没有就是新增
			profitMoneySum += Double.valueOf(profitMoneyValue);//将目标业绩值累加,用于判断是否符合上级规定的业绩
			profitTargetPOList.add(temProfitTargetPO);
			i++;
		}
		if(profitTargetPOList==null){
			throw new BusinessException("没有设置任何业绩");
		}
		//这个逻辑无限层级处理不了，咨询了大白，就不要正好逻辑了
		if(Const.DIC_PROFIT_COUNT_TYPE_AREA.byteValue()!=profitType && Const.DIC_PROFIT_COUNT_TYPE_NEW_ORGANIZATION.byteValue()!=profitType){
			double upperProfitMoney = this.getUpperProfitTarget(cityId,compId,profitType,profitTargetPOList.get(0),profitDate);// 获取该时间上级业绩目标(因为当前业绩都是同级的,所以拿一个作为标本获取其上级业绩)
			if(profitMoneySum < upperProfitMoney){
				DecimalFormat format = new DecimalFormat("0.##");
				throw new BusinessException("业绩目标"+format.format(profitMoneySum)+"小于上级规定的"+format.format(upperProfitMoney));
			}
		}
		erpFunProfitTargetService.insertOrUpdateProfitTarget(cityId,profitTargetPOList, profitType, profitDate);
		return ErpResponseJson.ok();
	}

	/**
	 * 录入业绩
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/24
	 */
	@ApiOperation("录入业绩")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@PostMapping("/insertMgrProfi")
	public ResponseJson insertMgrProfi(@RequestBody InsertDealInfoParam param) throws Exception{
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		param.setSelfDeptId(operator.getDeptId());
		param.setSelfDeptName(operator.getDeptName());
		param.setSelfUserId(operator.getUserId());
		GeneralParam generalParam = new GeneralParam(getOperator());
		Map<String,Object> map = erpFunProfitService.insertMgrProfit(generalParam,param);
		Integer dealId = (Integer)map.get("dealId");
		List<ErpProcessFinanc> list =  (List<ErpProcessFinanc>)map.get("list");
		if( list != null && list.size() > 0) {
			for (ErpProcessFinanc financ : list) {
				if (null != financ.getPfActual() && financ.getPfActual()== 0) {
					//创建总应收合同流水
					String pfIds1 = financ.getPfId() + "";
					createJMSmessage(compId, cityId, dealId, pfIds1, 4);
				} else if (null != financ.getPfActual() && financ.getPfActual() == 1) {
					//创建总实收合同流水
					String pfIds2 = financ.getPfId() + "";
					createJMSmessage(compId, cityId, dealId, pfIds2, 1);
				}
			}
		}
		return ErpResponseJson.ok();
	}

    /**
     * 创建jms信息
     * @param compId
     * @param cityId
     * @param dealId
     * @param pfIds
     * @param dealOpType
     */
    private void createJMSmessage(Integer compId, Integer cityId, Integer dealId, String pfIds, Integer dealOpType) {
//        Map<String, Object> content = new HashMap<>();
//        content.put("cityId", cityId);
//        content.put("compId", compId);
//        content.put("dealId", dealId);
//        content.put("pfIds", pfIds);
//        content.put("dealOpType", dealOpType);
//        adminJmsMessageService.createProfitDetail(cityId,content);

        UpdateFunProfitMessage message = new UpdateFunProfitMessage();
		message.setCityId(cityId);
		message.setCompId(compId);
		message.setDealId(dealId);
		message.setPfIds(pfIds);
		message.setDealOpType(dealOpType);
		adminJmsMessageService.createProfitDetail(message);


    }
	/**
	 * 获取指定业绩的上级业绩目标
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/23
	 */
	private double getUpperProfitTarget(Integer cityId, Integer compId, Byte profitType, ErpFunProfitTarget funProfitTargetPO, String profitDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateTimeHelper.parseToDate(profitDate));
		calendar.set(Calendar.DAY_OF_MONTH,1);
		String startTime= DateTimeHelper.formatDateTimetoString(calendar.getTime(), DateTimeHelper.FMT_yyyyMMdd);
		calendar.add(Calendar.MONTH,1);
		String endTime= DateTimeHelper.formatDateTimetoString(calendar.getTime(), DateTimeHelper.FMT_yyyyMMdd);
		if (Const.DIC_PROFIT_COUNT_TYPE_REG.equals(profitType)) {
			profitType = Const.DIC_PROFIT_COUNT_TYPE_AREA.byteValue();
		} else if (Const.DIC_PROFIT_COUNT_TYPE_DEPT.equals(profitType)) {
			profitType = Const.DIC_PROFIT_COUNT_TYPE_REG.byteValue();
		} else if (Constants_DIC.DIC_PROFIT_COUNT_TYPE_GROUP.equals(profitType)) {
			profitType = Const.DIC_PROFIT_COUNT_TYPE_DEPT.byteValue();
		} else if (Constants_DIC.DIC_PROFIT_COUNT_TYPE_USER.equals(profitType)) {
			profitType = Const.DIC_PROFIT_COUNT_TYPE_GROUP.byteValue();
		}
		ErpFunProfitTarget profitTarget = erpFunProfitTargetMapper.getProfitTargetByCondition(cityId,compId,profitType,startTime,endTime,funProfitTargetPO);
		if(profitTarget!=null && profitTarget.getTargetProfit()!=null){// 注意可能不存在业绩目标
			return profitTarget.getTargetProfit().doubleValue();
		}else{
			return 0;
		}
	}

	/**
	 * @author 邓永洪
	 * @tag 获取业绩目标的范围ID
	 * @since 2018/4/18
	 */
	private Set<Integer> getRangeIdsByProfitType(String compId, Integer areaId, Integer regId, Integer deptId, Integer grId,
												 Integer userId, Integer profitType, String targetDate,
												 Integer defId,Integer organizationId) {
		Set<Integer> resultSet = new HashSet<>();
		if (userId != null) {
			resultSet.add(userId);
			return resultSet;
		}
		if (Const.DIC_PROFIT_COUNT_TYPE_AREA.equals(profitType)) {
			List<ErpFunArea> funAreaList = erpFunAreaMapper.getDataListByCompId(getOperator().getCityId(), compId);
			if (funAreaList != null && funAreaList.size() > 0) {
				resultSet = funAreaList.stream().map(val -> val.getAreaId()).collect(Collectors.toSet());
			}
		} else if (Const.DIC_PROFIT_COUNT_TYPE_REG.equals(profitType)) {
			List<ErpFunRegion> funRegionList = erpFunRegionMapper.getCacheableRegionListByAreaId(getOperator().getCityId(), getOperator().getCompId());
			if (!CollectionUtils.isEmpty(funRegionList)) {
				if (areaId != null) {
					resultSet = funRegionList.stream().filter(val -> areaId.equals(val.getAreaId())).map(val -> val.getRegId()).collect(Collectors.toSet());
				} else {
					resultSet = funRegionList.stream().map(val -> val.getRegId()).collect(Collectors.toSet());
				}
			}
		} else if (Const.DIC_PROFIT_COUNT_TYPE_DEPT.equals(profitType)) {
			List<ErpFunDepts> funDeptsList = erpFunDeptsMapper.getCacheableDeptListByCompId(getOperator().getCityId(), getOperator().getCompId());
			if (funDeptsList != null && funDeptsList.size() > 0) {
				if (regId != null) {
					resultSet = funDeptsList.stream().filter(val -> regId.equals(val.getRegId())).map(val -> val.getDeptId()).collect(Collectors.toSet());
				}else {
					resultSet = funDeptsList.stream().map(val -> val.getDeptId()).collect(Collectors.toSet());
				}
			}
		} else if (Const.DIC_PROFIT_COUNT_TYPE_GROUP.equals(profitType)) {
			List<ErpFunDeptsgroup> funDeptsgroupList = erpFunDeptsgroupMapper.getCacheableGroupListByCompId(getOperator().getCityId(), getOperator().getCompId(), null);
			if (funDeptsgroupList != null && funDeptsgroupList.size() > 0) {
				if(deptId != null){
					resultSet = funDeptsgroupList.stream().filter(val -> deptId.equals(val.getDeptId())).map(val -> val.getGrId()).collect(Collectors.toSet());
				}else {
					resultSet = funDeptsgroupList.stream().map(val -> val.getGrId()).collect(Collectors.toSet());
				}
			}
		} else if (Const.DIC_PROFIT_COUNT_TYPE_USER.equals(profitType)) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(DateTimeHelper.parseToDate(targetDate));
			calendar.add(Calendar.MONTH, 1);
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("compId", compId);
			paramMap.put("deptId", deptId);
			paramMap.put("grId", grId);
			paramMap.put("writeOffTimeStart", targetDate + " 00:00:00");
			paramMap.put("writeOffTimeEnd", DateTimeHelper.formatDateTimetoString(calendar.getTime(), DateTimeHelper.FMT_yyyyMMdd) + " 23:59:59");
			List<ErpFunUsers> funUsersList = erpFunUsersMapper.getFunUsersListByMap(getOperator().getCityId(), paramMap);
			resultSet = funUsersList.stream().map(val -> val.getUserId()).collect(Collectors.toSet());
		} else if (Const.DIC_PROFIT_COUNT_TYPE_NEW_ORGANIZATION.equals(profitType)){//无限组织架构
			if(null != defId && "-2".equals(defId)){//查询员工
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(DateTimeHelper.parseToDate(targetDate));
				calendar.add(Calendar.MONTH, 1);
				calendar.add(Calendar.DAY_OF_MONTH, -1);
				Map<String, Object> paramMap = new HashMap<>();
				paramMap.put("compId", compId);
				paramMap.put("deptId", deptId);
				paramMap.put("grId", grId);
				paramMap.put("writeOffTimeStart", targetDate + " 00:00:00");
				paramMap.put("writeOffTimeEnd", DateTimeHelper.formatDateTimetoString(calendar.getTime(), DateTimeHelper.FMT_yyyyMMdd) + " 23:59:59");
				List<ErpFunUsers> funUsersList = erpFunUsersMapper.getFunUsersListByMap(getOperator().getCityId(), paramMap);
				resultSet = funUsersList.stream().map(val -> val.getUserId()).collect(Collectors.toSet());
			} else {
				List<ErpFunOrganization> erpFunOrganizations = erpFunOrganizationMapper.selectOrgInfoByDefAndOrgId(getOperator().getCityId(),compId,defId,organizationId);
				resultSet = erpFunOrganizations.stream().map(val -> val.getOrganizationId()).collect(Collectors.toSet());
			}
		} else {
			throw new BusinessException("异常的统计方式" + profitType);
		}
		return resultSet;
	}

	private Map<Integer, ErpFunProfitTarget> buildProfitTargetMapByType(List<ErpFunProfitTarget> fptPoList, Integer profitType) {
		Map<Integer, ErpFunProfitTarget> resultMap = new HashMap();
		for (ErpFunProfitTarget po : fptPoList) {
			Integer key = null;
			if (Const.DIC_PROFIT_COUNT_TYPE_AREA.equals(profitType)) {
				key = po.getAreaId();
			} else if (Const.DIC_PROFIT_COUNT_TYPE_REG.equals(profitType)) {
				key = po.getRegId();
			} else if (Const.DIC_PROFIT_COUNT_TYPE_DEPT.equals(profitType)) {
				key = po.getDeptId();
			} else if (Const.DIC_PROFIT_COUNT_TYPE_GROUP.equals(profitType)) {
				key = po.getGrId();
			} else if (Const.DIC_PROFIT_COUNT_TYPE_USER.equals(profitType)) {
				key = po.getUserId();
			} else if (Const.DIC_PROFIT_COUNT_TYPE_NEW_ORGANIZATION.equals(profitType)){
				key = po.getOrganizationId();
			} else {
				continue;
			}
			if (!CommonUtil.isnull(po)) {
				resultMap.put(key, po);
			}
		}
		return resultMap;
	}
}

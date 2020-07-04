package com.myfun.erpWeb.managecenter.profit;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.profit.param.*;
import com.myfun.erpWeb.managecenter.profit.vo.*;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.*;
import com.myfun.repository.erpdb.param.AuditWageParam;
import com.myfun.repository.erpdb.param.ErpFunWageParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.erpdb.ErpFunProfitService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.service.business.erpdb.ErpFunWageService;
import com.myfun.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
@Api(tags = "薪资模块")
@RestController
@RequestMapping("/funWage")
public class FunWageController extends BaseController {

	@Autowired
	ErpFunWageMapper erpFunWageMapper;
	@Autowired
	ErpFunRewardPunishmentMapper erpFunRewardPunishmentMapper;
	@Autowired
	ErpFunGenerationPaymentMapper  erpFunGenerationPaymentMapper;
	@Autowired
	ErpFunProfitDetailMapper erpFunProfitDetailMapper;
	@Autowired
	ErpFunWageService erpFunWageService;
	@Autowired
	ErpSysParaMapper erpSysParaMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpFunUsersService erpFunUsersService;
	@Autowired
	ErpFunProfitService erpFunProfitService;
	@Autowired
	ErpFunWageTypeNewMapper erpFunWageTypeNewMapper;
	@Autowired
	ErpFunCountwageMapper erpFunCountwageMapper;
	@Autowired
	ErpFunWageLogMapper erpFunWageLogMapper;
	@Autowired
	ErpFunRoleLevelsMapper erpFunRoleLevelsMapper;
	@Autowired
	ErpFunProfitShareDetailMapper erpFunProfitShareDetailMapper;

	/**
	 * @Title 由筛选条件(部门、员工、月份、角色）获取员工薪资列表
	 * @Author lcb
	 * @Date 2018/1/24
	 * @Param
	 **/
	@ApiOperation(value = "由筛选条件获取员工薪资列表",httpMethod = "POST")
	@ApiResponses({@ApiResponse(code = 200, response = FunWageListVo.class ,message = "success")})
	@RequestMapping("/getFunWageList")
	public ErpResponseJson getFunWageList(@Valid @RequestBody FunWageListParam param){
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		param.setCompId(compId);
		String assessmentMonth = param.getAssessmentMonth();
		Set<String> assessMonthSet = new HashSet<>();
		if (StringUtil.isNotBlank(assessmentMonth) && assessmentMonth.contains(",")) {
			String[] split = assessmentMonth.split(",");
			if(split[0].equals(split[1])) {
				assessMonthSet.add(split[0]);
			}else {
				assessMonthSet = splitAssessmentMonth(split);
			}
		}else if (StringUtil.isNotBlank(assessmentMonth)){
			assessMonthSet.add(assessmentMonth);
		}
		if(param.getUserId() != null){
			ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(cityId, param.getUserId());
			if(erpFunUsers != null &&erpFunUsers.getUserLevel() !=null){
				param.setUserLevel(erpFunUsers.getUserLevel()+2);
			}
		}
		if(0 == param.getIsExport()) {
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.getNeedCount());
		}
		//避免前端上传空字符串
		if(StringUtil.isEmpty(param.getRoleId())){
			param.setRoleId(null);
		}
		param.setNewOrganization(operator.newOrganizationType());
		List<ErpFunWageDto> resList = new ArrayList<>();
		if (operator.newOrganizationType()) {	//新版组织架构优化查询薪资
			resList =  erpFunWageMapper.getFunWageListNewOrg(cityId, param, assessMonthSet);
		}else {
			resList =  erpFunWageMapper.getFunWageList(cityId, param, assessMonthSet);
		}

		if(resList.size() > 0) {
			// 统计加上奖罚数据
			Set<Integer> allUserIdSet = resList.stream().collect(Collectors.mapping(val -> val.getUserId(), Collectors.toSet()));
			List<Integer> roleLevelIds = resList.stream().collect(Collectors.mapping(val -> val.getRoleLevelId(), Collectors.toList()));

			ErpFunRoleLevelsExample example = new ErpFunRoleLevelsExample();
			example.setShardCityId(cityId);
			//该查询不能排除已删除数据，历史的薪资信息对应的职级也需要展示
			example.createCriteria().andCompIdEqualTo(compId).andRoleLevelIdIn(roleLevelIds);
			List<ErpFunRoleLevels> erpFunRoleLevelDatas = erpFunRoleLevelsMapper.selectByExample(example);
			Map<Integer, ErpFunRoleLevels> roleLevelIdMap = new HashMap<Integer, ErpFunRoleLevels>();
			if(erpFunRoleLevelDatas != null && !erpFunRoleLevelDatas.isEmpty()){
				roleLevelIdMap = erpFunRoleLevelDatas.stream().collect(Collectors.toMap(ErpFunRoleLevels::getRoleLevelId, val -> val));
			}

			List<FunWageTmpDataDto> rewardPuinshmentList = erpFunRewardPunishmentMapper.getAllUserRewardPuishmentData(cityId, getOperator().getCompId(), allUserIdSet, assessMonthSet);
			Map<Integer, FunWageTmpDataDto> userRewardPunishmentMap  = new HashMap<>();
			if(rewardPuinshmentList.size() > 0) {
				userRewardPunishmentMap = rewardPuinshmentList.stream().collect(Collectors.toMap(FunWageTmpDataDto::getUserId, val -> val));
			}

			// 统计加上代扣代缴的数据
			List<FunWageTmpDataDto> generationList = erpFunGenerationPaymentMapper.getAllUserGenerationData(cityId, getOperator().getCompId(), allUserIdSet, assessMonthSet);
			Map<Integer, FunWageTmpDataDto> userGenerationMap = new HashMap<>();
			if(generationList.size() > 0) {
				userGenerationMap = generationList.stream().collect(Collectors.toMap(FunWageTmpDataDto::getUserId, val -> val));
			}

			// 查询异常量
			ErpFunProfitDetailExample erpFunProfitDetailExample = new ErpFunProfitDetailExample();
			erpFunProfitDetailExample.setShardCityId(cityId);
			erpFunProfitDetailExample.createCriteria().andUserIdIn(new ArrayList<>(allUserIdSet)).andAbnormalMonthEqualTo(param.getAssessmentMonth());

			// 异常数据
			List<FunWageTmpDataDto> userDatamapList = erpFunProfitDetailMapper.abnormalCount(cityId, compId, allUserIdSet, param.getAssessmentMonth());
			Map<Integer, Integer> wageTmpDataDtoMap = new HashMap<>();

			if(userDatamapList.size() > 0) {
				wageTmpDataDtoMap = userDatamapList.stream().collect(Collectors.toMap(FunWageTmpDataDto::getUserId, val -> val.getCount1()));
			}

			for (ErpFunWageDto erpFunWageDto : resList) {
				Integer roleLevelId = erpFunWageDto.getRoleLevelId();

				//拼装职级名称
				ErpFunRoleLevels roleLevelPo = roleLevelIdMap.get(roleLevelId);
				if(null != roleLevelPo) {
					erpFunWageDto.setRoleLevelName(roleLevelPo.getRoleLevelName());
				}

				// 奖罚
				FunWageTmpDataDto funWageTmpDataDto = userRewardPunishmentMap.get(erpFunWageDto.getUserId());
				if(null != funWageTmpDataDto) {
					erpFunWageDto.setRewardAmount(funWageTmpDataDto.getAmount1());
					erpFunWageDto.setPunishmentAmount(funWageTmpDataDto.getAmount2());
				}

				// 代扣代缴
				funWageTmpDataDto = userGenerationMap.get(erpFunWageDto.getUserId());
				if(null != funWageTmpDataDto) {
					erpFunWageDto.setGenerationAmount(funWageTmpDataDto.getAmount1());
				}
				Integer count = wageTmpDataDtoMap.get(erpFunWageDto.getUserId());
				erpFunWageDto.setAbormalFlag(count);
			}
		}
		PageInfo<ErpFunWageDto> pageInfo = new PageInfo<>(resList);
		return ErpResponseJson.ok(pageInfo);
	}

	private static Set<String> splitAssessmentMonth(String[] strings) {
		Set<String> resSet = new HashSet<>();
		String startMonth = strings[0]+"-01";
		String endMonth = strings[1]+"-01";

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
		resSet.add(strings[1]);
		return resSet;
	}

	public static void main(String[] args) {
		Set<String> strings = splitAssessmentMonth(new String[]{"2018-10", "2019-02"});
		for (String s :strings) {
			System.out.println(s);
		}
	}

	/**
	 * @Title 查询业绩提成发放下拉列表
	 * @Author lcb
	 * @Date 2018/1/24
	 * @Param
	 **/
	@ApiOperation(value = "查询业绩提成发放下拉列表",httpMethod = "POST")
	@ApiResponses({@ApiResponse(code = 200,responseContainer = "List",response = ErpFunProfitDetailDto.class, message = "success")})
	@RequestMapping("/getPersonFunProfitDetailList")
	public ErpResponseJson getAbormalFunProfitDetailList(@RequestBody AbormalFunProfitDetailListParam param){
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		param.setCompId(compId);
		// 查询计算方式 1=签约比例实收发  2：签约比例结算发 3：实收比例结算发 4：实收比例实收发 5:结算比例结算发
		String payrollSettlementType = erpSysParaMapper.getParamValue(cityId, compId, "PAYROLL_SETTLEMENT_TYPE");
		String queryMonth = "SETTLEMENT_MONTH";
		if(StringUtils.isBlank(payrollSettlementType) || "5".equals(payrollSettlementType) || "2".equals(payrollSettlementType ) || "3".equals(payrollSettlementType)) {
			queryMonth="SETTLEMENT_MONTH";
		}else if("1".equals(payrollSettlementType) || "4".equals(payrollSettlementType )) {
			queryMonth="INCOME_MONTH";
		}
		param.setQueryMonth(queryMonth);
		if(null != param.getUserId()) {
			ErpFunUsers userInfoByUserId = erpFunUsersMapper.getUserInfoByUserId(cityId, param.getUserId());
			param.setArchiveId(userInfoByUserId.getArchiveId());
		}
		List<ErpFunProfitDetailDto> resList = erpFunProfitDetailMapper.getPersonFunProfitDetailList(cityId, param);
		if (!CollectionUtils.isEmpty(resList)) {
			resList.forEach(val ->{
				val.setPayrollSettlementType(payrollSettlementType);
			});
		}
		return ErpResponseJson.ok(resList);
	}
	
	/**
	 * @Title 查询业绩提成发放下拉列表
	 * @Author lcb
	 * @Date 2018/1/24
	 * @Param
	 **/
	@ApiOperation(value = "查询业绩分润发放下拉列表",httpMethod = "POST")
	@ApiResponses({@ApiResponse(code = 200,responseContainer = "List",response = PersonShareProfitDetailVO.class, message = "success")})
	@RequestMapping("/getPersonShareProfitDetailList")
	public ErpResponseJson getPersonShareProfitDetailList(@RequestBody AbormalFunProfitDetailListParam param){
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		param.setCompId(compId);
		if(null != param.getUserId()) {
			ErpFunUsers userInfoByUserId = erpFunUsersMapper.getUserInfoByUserId(cityId, param.getUserId());
			param.setArchiveId(userInfoByUserId.getArchiveId());
		}
		List<PersonShareProfitDetailVO> resList = erpFunProfitShareDetailMapper.getPersonShareProfitDetailList(cityId,param);
		PersonShareProfitDetailListVO resultVO = new PersonShareProfitDetailListVO();
		resultVO.setList(resList);
		return ErpResponseJson.ok(resultVO);
	}
	
	/**
	 * @Title 审核薪资
	 * @Author lcb
	 * @Date 2018/1/24
	 * @Param
	 **/
	@RequestMapping("/auditFunWageDetail")
	public ErpResponseJson auditFunWageDetail(@Valid @RequestBody AuditWageParam param){
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer userId = operator.getUserId();
		String userName = operator.getUserName();

		Assert.isBlankThrow(param.getWageIds(), "功能已更新，请升级您的软件");

		List<AuditWageVO> resList = erpFunWageService.auditFunWage(cityId, compId, userId, userName, param.getWageIds());

		resList.stream().forEach(val-> {
			JSONObject paramData = new JSONObject();
			paramData.put("templateId", 65);
			paramData.put("receiver", val.getArchiveId());
			paramData.put("title", "工资确认");
			String m = val.getMonth();
			paramData.put("content", "您"+m.split("-")[0]+"年"+m.split("-")[1]+"月的工资单已生成，请查收");
			paramData.put("url", AppConfig.getProperty("common.uuhfWebNet.path")+"/B/Home/ZtPay/ztPayDetail?" +
					"userId="+val.getUserId()+"&month="+m+"&needfullscreen=1");
			Map<String,Object> paramExt = new HashMap<String,Object>();
			paramExt.put("paramExt", paramData.toJSONString());
			HttpUtil.postJson(AppConfig.getProperty("common.pushWeb.path")+"/openApi/push/pushMsg", paramExt);
		});

		return ErpResponseJson.ok();
	}

	/**
	 * 由用户id和结算月获取薪资详情
     * 或  由薪资id获取薪资详情
	 * @Author lcb
	 * @Date 2018/1/24
	 * @Param
	 **/
	@ApiOperation(value = "薪资详情",httpMethod = "POST")
	@ApiResponses({@ApiResponse(code =200, response = FunWageDetailVo.class,message ="success" )})
	@RequestMapping("/getFunWageDetail")
	public ErpResponseJson getFunWageDetail(@RequestBody FunWageDetailParam param){
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		String assessmentMonth = param.getAssessmentMonth();
		Set<String> assessMonthSet = new HashSet<>();
		if (StringUtils.isNotBlank(assessmentMonth) && assessmentMonth.contains(",")) {
			String[] split = assessmentMonth.split(",");
			if(split[0].equals(split[1])) {
				assessMonthSet.add(split[0]);
			}else {
				assessMonthSet = splitAssessmentMonth(split);
			}
		} else if(StringUtils.isNotBlank(assessmentMonth)){
			assessMonthSet.add(assessmentMonth);
		}
		ErpFunWageDto erpFunWageDto = erpFunWageMapper.getFunWageDetail(cityId, param,assessMonthSet);
		erpFunWageDto.setInDirectCommission(BigDecimal.ZERO);
		erpFunWageDto.setDirectCommission(BigDecimal.ZERO);
		if (null != erpFunWageDto) {
			List<ErpFunProfitShareDetail> resList = erpFunProfitShareDetailMapper.getShareProfitDetailList(cityId, operator.getCompId(), erpFunWageDto.getUserId(), erpFunWageDto.getAssessmentMonth());
			BigDecimal directCommission = BigDecimal.ZERO;
			BigDecimal inDirectCommission = BigDecimal.ZERO;
			for (ErpFunProfitShareDetail detail : resList) {
				if ((Byte.valueOf("0").equals(detail.getUpLeaderType()) || Byte.valueOf("1").equals(detail.getUpLeaderType())) && detail.getProfitShareProfit()!=null && detail.getProfitShareProfit().compareTo(BigDecimal.ZERO)>0) {
					directCommission = directCommission.add(detail.getProfitShareProfit());
				}
				if (Byte.valueOf("2").equals(detail.getUpLeaderType()) && detail.getProfitShareProfit()!=null && detail.getProfitShareProfit().compareTo(BigDecimal.ZERO)>0) {
					inDirectCommission = inDirectCommission.add(detail.getProfitShareProfit());
				}
			}
			if (erpFunWageDto.getPersonCommsionAmount()!=null && erpFunWageDto.getPersonCommsionAmount().compareTo(BigDecimal.ZERO)>0) {
				erpFunWageDto.setPersonCommsionAmount(erpFunWageDto.getPersonCommsionAmount().subtract(directCommission));
				erpFunWageDto.setPersonCommsionAmount(erpFunWageDto.getPersonCommsionAmount().subtract(inDirectCommission));
				erpFunWageDto.setInDirectCommission(inDirectCommission);
				erpFunWageDto.setDirectCommission(directCommission);
			} else {
				erpFunWageDto.setInDirectCommission(BigDecimal.ZERO);
				erpFunWageDto.setDirectCommission(BigDecimal.ZERO);
			}
			/*		resList.stream().filter(detail->{
				return (Byte.valueOf("1").equals(detail.getUpLeaderType()) || Byte.valueOf("2").equals(detail.getUpLeaderType())) && detail.getProfitShareProfit()!=null && detail.getProfitShareProfit().compareTo(BigDecimal.ZERO)>0;
			} ).collect(Collectors.mapping(ErpFunProfitShareDetail::getProfitShareProfit, Collectors.summarizingDouble(mapper)));
	*/		
			Set<Integer> userIdSet = new HashSet<>();
			assessMonthSet.add(erpFunWageDto.getAssessmentMonth());
			userIdSet.add(erpFunWageDto.getUserId());
			// 查询代扣代缴的统计
			List<FunWageTmpDataDto> rewardPuishmentData = erpFunRewardPunishmentMapper.getAllUserRewardPuishmentData(cityId, operator.getCompId(), userIdSet, assessMonthSet);
			if (null != rewardPuishmentData && rewardPuishmentData.size() > 0) {
				FunWageTmpDataDto funWageTmpDataDto = rewardPuishmentData.get(0);
				erpFunWageDto.setRewardAmount(funWageTmpDataDto.getAmount1());
				erpFunWageDto.setPunishmentAmount(funWageTmpDataDto.getAmount2());
			}
			// 查询代扣数据
			List<FunWageTmpDataDto> allUserGenerationData = erpFunGenerationPaymentMapper.getAllUserGenerationData(cityId, operator.getCompId(), userIdSet, assessMonthSet);
			if (null != allUserGenerationData && allUserGenerationData.size() > 0) {
				FunWageTmpDataDto funWageTmpDataDto = allUserGenerationData.get(0);
				erpFunWageDto.setGenerationAmount(funWageTmpDataDto.getAmount1());
			}


			// 判断该条数据是否有日志记录
			ErpFunWageLogExample erpFunWageLogExample = new ErpFunWageLogExample();
			erpFunWageLogExample.setShardCityId(cityId);
			erpFunWageLogExample.createCriteria().andWageIdEqualTo(erpFunWageDto.getWageId());
			Integer i = erpFunWageLogMapper.countByExample(erpFunWageLogExample);
			erpFunWageDto.setIsHaveWageLog(i > 0 ? 1: 0);
		}
		return ErpResponseJson.ok(erpFunWageDto);
	}

	/**
	 * @Title 修改应发金额，现在只是修改应发，以后可能扩展，所以名字。。
	 * @Author lcb
	 * @Date 2018/1/24
	 * @Param
	 **/
	@ApiOperation("工资调整")
	@ApiResponses(value = {@ApiResponse(code = 200,response = ErpResponseJson.class,message = "成功")})
	@RequestMapping("/updateFunWageDetail")
	public ErpResponseJson updateFunWageDetail(@Valid @RequestBody ErpFunWageParam param){
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer userId = operator.getUserId();
		String userName = operator.getUserName();
		param.setCompId(compId);
		Integer res = erpFunWageService.updateFunWageRealWage(cityId, userId, userName, param);
		return ErpResponseJson.ok(res);
	}

	/**
	 * 获取工资审核人
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/21
	 */
	@RequestMapping("/getUserListByShenHe")
	public ErpResponseJson getUserListByShenHe(@Valid @RequestBody ErpFunWageParam param){
		Integer compId=getOperator().getCompId();
		Integer cityId=getOperator().getCityId();
		Integer deptId=param.getDeptId();
		List<ErpFunUsers> erpFunUsers=erpFunUsersMapper.getUserListByShenHe(cityId,compId,deptId);
		return ErpResponseJson.ok(erpFunUsers);
	}

	/**
	 * 更新工资审核人
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/21
	 */
	@ApiOperation("更新工资审核人")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@ResponseBody
	@PostMapping("/updateShenheUserFlag")
	public ErpResponseJson updateShenheUserFlag(@Valid @RequestBody FunWageParam param){
		Integer compId=getOperator().getCompId();
		Integer cityId=getOperator().getCityId();
		String[] userIds;
		if (StringUtil.isNotBlank(param.getUserids())){
			userIds = param.getUserids().split(",");
			if (userIds.length <= 0) {
				throw new BusinessException("没有可更新的信息");
			}
			erpFunUsersService.updateShenheUserFlag(cityId,compId,userIds);
		}
		return ErpResponseJson.ok();
	}

	/**
	 * 保存未发和待发工资列表
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/8/1
	 * todo
	 * 前端废弃不用的接口
	 */
	@ResponseBody
	@RequestMapping("/saveProfitCheckFlag")
	public ErpResponseJson saveProfitCheckFlag(@Valid @RequestBody BaseMapParam param){
		String checkedIds = param.getString("profitIds");
		String createDate=param.getString("createDate");
		Integer grId=param.getInteger("grId");
		Integer compId=getOperator().getCompId();
		Integer cityId=getOperator().getCityId();
		String[] profitIds = new String[0];
		if(StringUtil.isNotBlank(checkedIds)){
			profitIds = checkedIds.split(",");
		}
		Integer userId = param.getInteger("userId");
		erpFunProfitService.checkedProfitByUserId(cityId,compId,userId,createDate,profitIds);
		String startDate = CommonUtil.getFirstDateOfMonth(createDate);
		String endDate = CommonUtil.getFirstDateOfNextMonth(createDate);
		String subDate = CommonUtil.getFirstDateOfMonth();// 以本月1号为分界线,如果结束时间小于本月1号,则值查询前半段
		if(DateTimeHelper.parseToDate(endDate).before(DateTimeHelper.parseToDate(subDate))){
			subDate = endDate;
		}
		List<ErpFunWageDto> resultList = new ArrayList<>();
		int totalSize = 0;
		if(DateTimeHelper.parseToDate(startDate).before(DateTimeHelper.parseToDate(subDate))){// 起始时间小于本月1号才进行查询历史薪资
			Map<Integer,ErpFunCountwageDto> wageCountMap = this.getWageCountMapNew(cityId,compId);// 获取本公司所有的提成类型
			resultList = erpFunWageService.getStaticWageVOListForUser(cityId,compId,grId,userId,startDate,subDate,param.getPageOffset(),param.getPageRows(),wageCountMap);// 直接查询薪资报表
//			totalSize += service.getStaticWageVOListTotalSize(null,userId,startDate, subDate);
		}
		if(DateTimeHelper.parseToDate(subDate).before(DateTimeHelper.parseToDate(endDate))){// 结束时间大于本月1号才进行查询动态薪资
//			Map<String, WageCountVO> wageCountMap = funWageTypeNewService.getWageCountMapNew();// 获取本公司所有的提成类型
//			List<WageBaseInfoVO> userVO = this.getWageVOListNew(null,userId,subDate,endDate,wageCountMap);// 动态生成某个人当月薪资信息
//			if(userVO!=null){
//				resultList.addAll(userVO);
//				totalSize += userVO.size();
//			}
		}



		return ErpResponseJson.ok();
	}

	/**
	 * 获取本公司所有的提成类型
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/8/1
	 */
	private Map<Integer,ErpFunCountwageDto> getWageCountMapNew(Integer cityId,Integer compId) {
		List<ErpFunWageTypeNew> list = erpFunWageTypeNewMapper.getFunWageTypeNewByComp(cityId,compId);
		List<Integer> wageTypeIds=list.stream().collect(Collectors.mapping(ErpFunWageTypeNew::getId,Collectors.toList()));
		List<ErpFunCountwage> erpFunCountwageList =erpFunCountwageMapper.getFunCountwageByCompIdAndWageTypeIds(cityId,compId,wageTypeIds);
		Map<Integer, ErpFunCountwageDto> resultMap = new HashMap<>();
		for (ErpFunWageTypeNew funWageTypeNewPO : list) {
			ErpFunCountwageDto vo = new ErpFunCountwageDto();
			Integer wageTypeId = funWageTypeNewPO.getId();
			vo.setFunWageTypeNew(funWageTypeNewPO);
			vo.setFunCountwageList(erpFunCountwageList);
			resultMap.put(wageTypeId, vo);
		}
		return resultMap;
	}

	/**
	 * 由薪资ID获取薪资最新日志
	 * @param
	 * @return
	 */
	@ApiOperation("由薪资ID获取薪资最新日志")
	@ApiResponses({@ApiResponse(code = 200,response = ErpFunWageLog.class,message = "success")})
	@PostMapping("/getWageLogList")
	public ErpResponseJson  getErpFunWageLogListByFunWageId(@RequestBody WageLogListParam param) {
		Operator operator = getOperator();
		param.setCompId(operator.getCompId());
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);

		if (StringUtils.isNotBlank(param.getStartTime())) {
			param.setStartTime(param.getStartTime() + " 00:00:00");
		}

		if (StringUtils.isNotBlank(param.getEndTime())) {
			param.setEndTime(param.getEndTime() + " 23:59:59");
		}
		param.setNewOrganization(operator.newOrganizationType());
		List<ErpFunWageLog> erpFunWageLog = erpFunWageLogMapper.getFunWageLogList(operator.getCityId(),param);
		PageInfo pageInfo = new PageInfo(erpFunWageLog);

		WageLogListVO wageLogListVO = new WageLogListVO();
		wageLogListVO.setList(erpFunWageLog);
		ErpResponseJson json = new ErpResponseJson(pageInfo);
        json.setData(wageLogListVO);
		return json;
	}

	/**
	 * @desc 设置薪资管理员
	 * @since 2019/11/5
	 * @author lcb
	 * @param param
	 * @return
	 */
	@ApiOperation("设置薪资管理员")
	@ApiResponses({@ApiResponse(code = 200,response = SetWageManagerVO.class,message = "success")})
	@PostMapping("/setWageManager")
	public ErpResponseJson setWageManager(@RequestBody SetWageManagerParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		// 先取消已设置的管理员
		ErpFunUsers erpFunUsers = new ErpFunUsers();
		erpFunUsers.setWageFlag(false);
		ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
		erpFunUsersExample.setShardCityId(cityId);
		ErpFunUsersExample.Criteria criteria = erpFunUsersExample.createCriteria();
		criteria.andCompIdEqualTo(compId);
		erpFunUsersMapper.updateByExampleSelective(erpFunUsers, erpFunUsersExample);

		if(StringUtil.isBlank(param.getUserids())) {
			return ErpResponseJson.ok();
		}
		String[] userIds = param.getUserids().split(",");
		
		List<Integer> userIdList = new ArrayList<>();
		for (String userId : userIds) {
			userIdList.add(Integer.valueOf(userId));
		}
		erpFunUsers.setWageFlag(true);
		criteria.andUserIdIn(userIdList);
		erpFunUsersMapper.updateByExampleSelective(erpFunUsers, erpFunUsersExample);
		return ErpResponseJson.ok();
	}

}


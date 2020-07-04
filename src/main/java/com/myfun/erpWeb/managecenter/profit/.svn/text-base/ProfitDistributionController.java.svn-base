package com.myfun.erpWeb.managecenter.profit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.myfun.erpWeb.managecenter.profit.param.FinancAuditListParam;
import com.myfun.erpWeb.managecenter.profit.param.SignStatisticsListParam;
import com.myfun.erpWeb.managecenter.profit.vo.*;
import com.myfun.erpWeb.managecenter.sysmanager.vo.GetRoleWageMaxProVo;
import com.myfun.erpWeb.managecenter.sysmanager.vo.GetRoyaltyInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.profit.param.AssessCountDataParam;
import com.myfun.erpWeb.managecenter.profit.param.ProfitDistributionParam;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.erpdb.dao.ErpCompRolesMapper;
import com.myfun.repository.erpdb.dao.ErpFunCountwageMapper;
import com.myfun.repository.erpdb.dao.ErpFunDealMapper;
import com.myfun.repository.erpdb.dao.ErpFunPerformanceTypeMapper;
import com.myfun.repository.erpdb.dao.ErpFunProfitDetailMapper;
import com.myfun.repository.erpdb.dao.ErpFunProfitDynamicDetailMapper;
import com.myfun.repository.erpdb.dao.ErpFunProfitDynamicShareDetailMapper;
import com.myfun.repository.erpdb.dao.ErpFunProfitMapper;
import com.myfun.repository.erpdb.dao.ErpFunProfitShareDetailMapper;
import com.myfun.repository.erpdb.dao.ErpFunRoleWageConfigMapper;
import com.myfun.repository.erpdb.dao.ErpFunUserRankExaminationMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpFunWageTypeNewMapper;
import com.myfun.repository.erpdb.dao.ErpRoleWagetypeRelativeMapper;
import com.myfun.repository.erpdb.dao.ErpSysParaMapper;
import com.myfun.repository.erpdb.dao.ErpUserOpersMapper;
import com.myfun.repository.erpdb.dao.ErpUserRoleExamineLogMapper;
import com.myfun.repository.erpdb.dao.ErpZxRoleConfigHisMapper;
import com.myfun.repository.erpdb.dao.ErpZxRoleConfigMapper;
import com.myfun.repository.erpdb.dto.ErpAssessCountDataDto;
import com.myfun.repository.erpdb.dto.ErpCountWageTypeDto;
import com.myfun.repository.erpdb.dto.ErpLeaderAssessCountDataDto;
import com.myfun.repository.erpdb.dto.WageCountTypePackDto;
import com.myfun.repository.erpdb.po.ErpCompRoles;
import com.myfun.repository.erpdb.po.ErpCompRolesExample;
import com.myfun.repository.erpdb.po.ErpFunCountwage;
import com.myfun.repository.erpdb.po.ErpFunCountwageExample;
import com.myfun.repository.erpdb.po.ErpFunDeal;
import com.myfun.repository.erpdb.po.ErpFunDealExample;
import com.myfun.repository.erpdb.po.ErpFunPerformanceType;
import com.myfun.repository.erpdb.po.ErpFunPerformanceTypeExample;
import com.myfun.repository.erpdb.po.ErpFunProfit;
import com.myfun.repository.erpdb.po.ErpFunProfitDynamicDetail;
import com.myfun.repository.erpdb.po.ErpFunProfitDynamicDetailExample;
import com.myfun.repository.erpdb.po.ErpFunProfitDynamicShareDetail;
import com.myfun.repository.erpdb.po.ErpFunProfitDynamicShareDetailExample;
import com.myfun.repository.erpdb.po.ErpFunProfitExample;
import com.myfun.repository.erpdb.po.ErpFunUserRankExamination;
import com.myfun.repository.erpdb.po.ErpFunUserRankExaminationExample;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpFunUsersExample;
import com.myfun.repository.erpdb.po.ErpFunWageTypeNew;
import com.myfun.repository.erpdb.po.ErpFunWageTypeNewExample;
import com.myfun.repository.erpdb.po.ErpRoleWagetypeRelative;
import com.myfun.repository.erpdb.po.ErpRoleWagetypeRelativeExample;
import com.myfun.repository.erpdb.po.ErpSysPara;
import com.myfun.repository.erpdb.po.ErpUserOpers;
import com.myfun.repository.erpdb.po.ErpUserOpersExample;
import com.myfun.repository.erpdb.po.ErpUserRoleExamineLog;
import com.myfun.repository.erpdb.po.ErpZxRoleConfig;
import com.myfun.repository.erpdb.po.ErpZxRoleConfigExample;
import com.myfun.repository.erpdb.po.ErpZxRoleConfigHis;
import com.myfun.repository.erpdb.po.ErpZxRoleConfigHisExample;
import com.myfun.service.business.erpdb.ErpFunRoleWageConfigService;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.DateUtil;
import com.myfun.utils.NumberHelper;
import com.myfun.utils.StringUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 分销薪资、业绩等相关方法
 * 该模式是玛雅公司的模式，目前接入到好房通的系统中
 * @Package com.myfun.erpWeb.managecenter.profit 
 * @author 陈文超
 * @date 2019年8月28日 下午8:05:33
 * 该类中的计算涉及的数据库表：ZX_ROLE_CONFIG
 * 
 *	业绩计算使用到的数据库表，由于关联关系较为复杂，现将以下关联表进行梳理
 *	业绩类别情况表，包含：业绩类型、业绩分成比例
 * 	SELECT * FROM FUN_PERFORMANCE_TYPE WHERE COMP_ID = 57434
 *  财务款项配置表
	SELECT * FROM FUN_FINANC_PAYMENT WHERE COMP_ID = 57434
	财务分配表
	SELECT * FROM PROCESS_FINANC WHERE COMP_ID= 57434
	--薪资配置表
	SELECT * FROM FUN_ROLE_WAGE_CONFIG WHERE ID = 18517
	select * from FUN_ROLE_WAGE_CONFIG where id = 18511
	将薪资配置、人员、角色关联起来-并且每个月一份/人
	SELECT * FROM SALARY_TYPE_RELATIVE WHERE COMP_ID = 57434 and SALARY_TYPE_ID = --FUN_ROLE_WAGE_CONFIG的ID
	--合并提成-NEWTOTAL_ID = FUN_WAGE_TYPE_NEW 的ID、分业务提成
	SELECT NEWTOTAL_ID, * FROM ROLE_WAGETYPE_RELATIVE WHERE and SALARY_TYPE_ID = --FUN_ROLE_WAGE_CONFIG的ID
	select * from FUN_WAGE_TYPE_NEW where ID = 19223 --NEWTOTAL_ID
	计算提成时：按照业绩的类别将业绩分组
	Map<Integer, List<ErpFunProfitDetail>> groupByPerformanceType = erpFunProfitDetailListTotal.stream().collect(Collectors.groupingBy(ErpFunProfitDetail::getPerformanceId));
	// 有哪些类别
	Set<Integer> perfermanceTypeSet = erpFunProfitDetailListTotal.stream().collect(Collectors.mapping(val -> val.getPerformanceId(), Collectors.toSet()));
	找到当前用户的// 个人提成配置
	ErpRoleWagetypeRelative erpRoleWagetypeRelative = erpRoleWagetypeRelativeList.get(0);
	然后遍历找到对应的ID和业绩提成区间数据
	ErpFunWageTypeNew erpFunWageTypeNew = getFunWageTypeByPerformanceId(cityId, erpRoleWagetypeRelative, perfermanceType);
	// 总实收-应收-用于计算提成
	Double totalIncome = 0d;
	if(erpFunProfitDetailList.size() > 0) {
		totalIncome = erpFunProfitDetailList.stream().collect(Collectors.summingDouble(val->val.getIncomeAmount().doubleValue()));
	}
	switch (performanceType) {
		case 1:
			relativeId = erpRoleWagetypeRelative.getTransferId();
			break;
		case 2:
			relativeId = erpRoleWagetypeRelative.getSecondhandId();
			break;
		case 3:
			relativeId = erpRoleWagetypeRelative.getNewhouseId();
			break;
		case 4:
			relativeId = erpRoleWagetypeRelative.getLeaseId();
			break;
		case 5:
			relativeId = erpRoleWagetypeRelative.getFinanceId();
			break;
		case 6:
			relativeId = erpRoleWagetypeRelative.getTotalId();
			break;
		case 7:
			relativeId = erpRoleWagetypeRelative.getNewtotalId();
			break;
	}
	然后查询FunWageTypeNew数据，再查询提成区间计算数据fun_countwage
	ErpFunWageTypeNew erpFunWageTypeNew = new ErpFunWageTypeNew();
	erpFunWageTypeNew.setId(relativeId);
	erpFunWageTypeNew.setShardCityId(cityId);
	result = erpFunWageTypeNewMapper.selectByPrimaryKey(erpFunWageTypeNew);
 */
@Api(tags = "分销模式的业绩相关")
@RestController
@RequestMapping("/profitDistribution")
public class ProfitDistributionController extends BaseController {
	
	@Autowired
	private ErpCompRolesMapper erpCompRolesMapper;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private ErpFunProfitDetailMapper erpFunProfitDetailMapper;
	@Autowired
	private ErpFunProfitDynamicShareDetailMapper erpFunProfitDynamicShareDetailMapper;
	@Autowired
	private ErpFunProfitDynamicDetailMapper erpFunProfitDynamicDetailMapper;
	@Autowired
	private ErpFunRoleWageConfigMapper erpFunRoleWageConfigMapper;
	@Autowired
	private ErpZxRoleConfigMapper erpZxRoleConfigMapper;
	@Autowired
	private ErpRoleWagetypeRelativeMapper erpRoleWagetypeRelativeMapper;
	@Autowired
	private ErpFunCountwageMapper erpFunCountwageMapper;
	@Autowired
	private ErpUserRoleExamineLogMapper erpUserRoleExamineLogMapper;
	@Autowired
	private ErpFunDealMapper erpFunDealMapper;
	@Autowired
	private ErpFunProfitMapper erpFunProfitMapper;
	@Autowired
	private AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired
	private ErpFunRoleWageConfigService erpFunRoleWageConfigService;
	@Autowired
	private ErpFunPerformanceTypeMapper erpFunPerformanceTypeMapper;
	@Autowired
	private ErpFunWageTypeNewMapper erpFunWageTypeNewMapper;
	@Autowired
	private ErpFunProfitShareDetailMapper erpFunProfitShareDetailMapper;
	@Autowired
	private ErpZxRoleConfigHisMapper erpZxRoleConfigHisMapper;
	@Autowired
	private ErpUserOpersMapper erpUserOpersMapper;
	@Autowired
	private ErpFunUserRankExaminationMapper erpFunUserRankExaminationMapper;
	@Autowired
	private ErpSysParaMapper erpSysParaMapper;
	/**
	 * 查询个人战绩数据
	 * 分为：实发提成、应发提成、签约提成
	 * @Package com.myfun.erpWeb.managecenter.profit 
	 * @author 陈文超   
	 * @date 2019年8月28日 下午8:42:05
	 */
	@ApiOperation(value = "查询个人战绩数据", httpMethod = "POST")
	@ApiResponses({@ApiResponse(code = 200, response = ProfitDistributionListVo.class, message = "success")})
	@RequestMapping("/getPersonProfit")
	public ErpResponseJson getPersonProfit(@Valid @RequestBody ProfitDistributionParam param){
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		Integer currUserId = Integer.parseInt(param.getUserId());
		if(currUserId != null && currUserId <= 0){
			return ErpResponseJson.ok(); 
		}
		
		Integer currArchiveId = erpFunUsersMapper.getUserInfoByUserId(cityId, currUserId).getArchiveId();
		String queryMonth = param.getMonthStr();
		if(StringUtil.isBlank(queryMonth)){
			queryMonth = DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy-MM");
		}
		
//		查询类型：1实发提成、2应发提成、3签约提成，默认：1
//		实发提成：本月结算实收业绩的计算出的提成
//		应发提成：本月实收业绩计算出的提成
//		签约提成：本月签约的合同应收业绩计算出的提成
		Byte queryType = param.getQueryType();
		
		//个人业绩
		List<ProfitDistributionVo> personProfit = new ArrayList<ProfitDistributionVo>();
		//直接培育业绩
		List<ProfitDistributionVo> personDirectProfit = new ArrayList<ProfitDistributionVo>();
		//间接培育业绩
		List<ProfitDistributionVo> personIndirectProfit = new ArrayList<ProfitDistributionVo>();
		
		//用于查询相关联的用户
		List<Integer> userIds = new ArrayList<Integer>();
		userIds.add(currUserId);
		//合同ID集合
		List<Integer> dealIds = new ArrayList<Integer>();
		//profitDynamic-profitIds，使用该数据查询ErpFunProfitDynamicDetail中的profit_id数据
		//erpFunProfitDynamicShareDetail中的 profitId 不是 fun_profit的id，需要关联ErpFunProfitDynamicDetail表才能查询出具体的fun_profit的id
		List<Integer> profitDynamIds = new ArrayList<Integer>();
		//业绩ID集合
		List<Integer> profitIds = new ArrayList<Integer>();
		//只存放个人业绩的业绩类别集合，通过查询的这一批业绩获得
		Set<Integer> perosonPerformanceType = new HashSet<>();
		
		//查询计算个人提成需要的数据
		ErpFunProfitDynamicDetailExample examplePerson = new ErpFunProfitDynamicDetailExample();
		examplePerson.setShardCityId(cityId);
		ErpFunProfitDynamicDetailExample.Criteria criteria = examplePerson.createCriteria();
		//查询本人业绩的时候必须使用archiveId-例如：员工调店后业绩数据会跟着以前的门店走-陈文超
		criteria.andCompIdEqualTo(compId).andArchiveIdEqualTo(currArchiveId).andDelFlagEqualTo((byte)0);
		if(queryType == 1){
			criteria.andSettlementMonthEqualTo(queryMonth);
			criteria.andIncomeAmountTypeEqualTo((byte)1);
		}else if(queryType == 2){
			criteria.andIncomeMonthEqualTo(queryMonth);
			criteria.andIncomeAmountTypeEqualTo((byte)1);
		}else if(queryType == 3){
			criteria.andSignMonthEqualTo(queryMonth);
			criteria.andIncomeAmountTypeEqualTo((byte)0);
		}
		List<ErpFunProfitDynamicDetail> personProfitPo = erpFunProfitDynamicDetailMapper.selectByExample(examplePerson);
		for(ErpFunProfitDynamicDetail tmp : personProfitPo){
			if(!dealIds.contains(tmp.getDealId())){
				dealIds.add(tmp.getDealId());
			}
			if(!profitIds.contains(tmp.getProfitId())){
				profitIds.add(tmp.getProfitId());
			}
		}
		//流水中的PerformanceId = PerformanceType，注意区分，有点隐蔽，历史遗留问题
		perosonPerformanceType = personProfitPo.stream().collect(Collectors.mapping(val -> val.getPerformanceId(), Collectors.toSet()));
		
		//查询计算直接培育提成需要的数据
		List<Byte> upLeaderTypeList = new ArrayList<Byte>();
		upLeaderTypeList.add((byte) 0);
		upLeaderTypeList.add((byte) 1);
		ErpFunProfitDynamicShareDetailExample examplePersonDirect = new ErpFunProfitDynamicShareDetailExample();
		examplePersonDirect.setShardCityId(cityId);
		ErpFunProfitDynamicShareDetailExample.Criteria criteriaDirect = examplePersonDirect.createCriteria();
		criteriaDirect.andCompIdEqualTo(compId).andUpLeaderUserEqualTo(currUserId).andDelFlagEqualTo((byte)0).andUpLeaderTypeIn(upLeaderTypeList);
		if(queryType == 1){
			criteriaDirect.andSettlementMonthEqualTo(queryMonth);
			criteriaDirect.andIncomeAmountTypeEqualTo((byte)1);
		}else if(queryType == 2){
			criteriaDirect.andIncomeMonthEqualTo(queryMonth);
			criteriaDirect.andIncomeAmountTypeEqualTo((byte)1);
		}else if(queryType == 3){
			criteriaDirect.andSignMonthEqualTo(queryMonth);
			criteriaDirect.andIncomeAmountTypeEqualTo((byte)0);
		}
		List<ErpFunProfitDynamicShareDetail> personProfitDirectPo = erpFunProfitDynamicShareDetailMapper.selectByExample(examplePersonDirect);
		this.processPfofitData(personProfitDirectPo);
		for(ErpFunProfitDynamicShareDetail tmp : personProfitDirectPo){
			if(!userIds.contains(tmp.getUserId())){
				userIds.add(tmp.getUserId());
			}
			if(!dealIds.contains(tmp.getDealId())){
				dealIds.add(tmp.getDealId());
			}
			if(!profitDynamIds.contains(tmp.getProfitId())){
				profitDynamIds.add(tmp.getProfitId());
			}
		}
		
		//查询计算间接培育提成需要的数据
		ErpFunProfitDynamicShareDetailExample examplePersonIndirect = new ErpFunProfitDynamicShareDetailExample();
		examplePersonIndirect.setShardCityId(cityId);
		ErpFunProfitDynamicShareDetailExample.Criteria criteriaIndirect = examplePersonIndirect.createCriteria();
		criteriaIndirect.andCompIdEqualTo(compId).andUpLeaderUserEqualTo(currUserId).andDelFlagEqualTo((byte)0).andUpLeaderTypeEqualTo((byte)2);
		if(queryType == 1){
			criteriaIndirect.andSettlementMonthEqualTo(queryMonth);
			criteriaIndirect.andIncomeAmountTypeEqualTo((byte)1);
		}else if(queryType == 2){
			criteriaIndirect.andIncomeMonthEqualTo(queryMonth);
			criteriaIndirect.andIncomeAmountTypeEqualTo((byte)1);
		}else if(queryType == 3){
			criteriaIndirect.andSignMonthEqualTo(queryMonth);
			criteriaIndirect.andIncomeAmountTypeEqualTo((byte)0);
		}
		
		List<ErpFunProfitDynamicShareDetail> personProfitIndirect = erpFunProfitDynamicShareDetailMapper.selectByExample(examplePersonIndirect);
		for(ErpFunProfitDynamicShareDetail tmp : personProfitIndirect){
			if(!userIds.contains(tmp.getUserId())){
				userIds.add(tmp.getUserId());
			}
			if(!dealIds.contains(tmp.getDealId())){
				dealIds.add(tmp.getDealId());
			}
			if(!profitDynamIds.contains(tmp.getProfitId())){
				profitDynamIds.add(tmp.getProfitId());
			}
		}
		
		//将业绩数据和直接培育、间接培育的数据进行关联，用于后面查询业绩来源
		Map<Integer, Integer> profitDynamicMappingShareProfitDynamic = new HashMap<>();
		if(!profitDynamIds.isEmpty()){
			ErpFunProfitDynamicDetailExample erpFunProfitDynamicDetailExample = new ErpFunProfitDynamicDetailExample();
			erpFunProfitDynamicDetailExample.setShardCityId(cityId);
			erpFunProfitDynamicDetailExample.createCriteria().andCompIdEqualTo(compId).andIdIn(profitDynamIds);
			List<ErpFunProfitDynamicDetail> tmpErpFunProfitDynamicDetailList = erpFunProfitDynamicDetailMapper.selectByExample(erpFunProfitDynamicDetailExample);
			for(ErpFunProfitDynamicDetail tmp : tmpErpFunProfitDynamicDetailList){
				if(!profitIds.contains(tmp.getProfitId())){
					profitIds.add(tmp.getProfitId());
				}
				profitDynamicMappingShareProfitDynamic.put(tmp.getId(), tmp.getProfitId());
			}
		}
		
		//组装人员信息、合同物业信息合同编号、应收业绩、业绩类别信息
		//查询人员数据集合
		ErpFunUsersExample exampleUser = new ErpFunUsersExample();
		exampleUser.setShardCityId(cityId);
		exampleUser.createCriteria().andCompIdEqualTo(compId).andUserIdIn(userIds);
		List<ErpFunUsers> userList = erpFunUsersMapper.selectByExample(exampleUser);
		//KEY:archiveId，value：userPo
		Map<Integer, ErpFunUsers> archiveIdMap = userList.stream().collect(Collectors.toMap(ErpFunUsers::getArchiveId, val -> val));

		//查询合同集合
		List<ErpFunDeal> dealList = new ArrayList<ErpFunDeal>();
		if(!dealIds.isEmpty()){
			ErpFunDealExample exampleDeal = new ErpFunDealExample();
			exampleDeal.setShardCityId(cityId);
			exampleDeal.createCriteria().andCompIdEqualTo(compId).andDealIdIn(dealIds);
			dealList = erpFunDealMapper.selectByExample(exampleDeal);
		}
		Map<Integer, ErpFunDeal> dealIdMap = dealList.stream().collect(Collectors.toMap(ErpFunDeal::getDealId, val -> val));
		
		//查询业绩信息
		List<ErpFunProfit> profitList = new ArrayList<ErpFunProfit>();
		if(!profitIds.isEmpty()){
			ErpFunProfitExample exampleProfit = new ErpFunProfitExample();
			exampleProfit.setShardCityId(cityId);
			exampleProfit.createCriteria().andCompIdEqualTo(compId).andProfitIdIn(profitIds);
			profitList = erpFunProfitMapper.selectByExample(exampleProfit);
		}
		Map<Integer, ErpFunProfit> profitIdMap = profitList.stream().collect(Collectors.toMap(ErpFunProfit::getProfitId, val -> val));
		
		//公司角色数据集合
		List<ErpCompRoles> compRoleList = erpCompRolesMapper.getAllCompRole(cityId, compId);
		if(compRoleList.isEmpty()){
			return ErpResponseJson.ok();
		}
		Map<String, ErpCompRoles> compRoleMap = compRoleList.stream().collect(Collectors.toMap(ErpCompRoles::getRoleId, val -> val));
		//业绩类别-这里查询出全公司历史有的，不能排除删除和停用的，由于是查询全公司，后期可能这个数据会比较多，但影响不大只是需要注意
		ErpFunPerformanceTypeExample exampleFunperforType = new ErpFunPerformanceTypeExample();
		exampleFunperforType.setShardCityId(cityId);
		exampleFunperforType.createCriteria().andCompIdEqualTo(compId);
		List<ErpFunPerformanceType> funperforTypeList = erpFunPerformanceTypeMapper.selectByExample(exampleFunperforType);
		Map<Integer, ErpFunPerformanceType> funperforTypeMap = new HashMap<>();
		if(funperforTypeList != null && funperforTypeList.size() > 0){
			//这里要注意业绩流水上的PerformanceId实际是FUN_PERFORMANCE_TYPE表的CollectionType
			funperforTypeMap = funperforTypeList.stream().collect(Collectors.toMap(ErpFunPerformanceType::getPerformanceId, val -> val));
		}
		String roleIdtmp = archiveIdMap.get(currArchiveId).getUserPosition();
		//查询当前用户角色的直接和间接分润配置
		ErpZxRoleConfig erpZxRoleConfig = this.getErpZxRoleConfigData(cityId, compId, queryMonth, roleIdtmp).get(roleIdtmp);
		
		//个人的统计数据不需要userMap数据
		personProfit.addAll(this.mixPersonProfitData((byte) 1, personProfitPo, null, dealIdMap, profitIdMap, compRoleMap, null, funperforTypeMap, null,cityId,compId));
		personDirectProfit.addAll(this.mixPersonProfitData((byte) 2, personProfitDirectPo, archiveIdMap, dealIdMap, profitIdMap, compRoleMap, erpZxRoleConfig, funperforTypeMap, profitDynamicMappingShareProfitDynamic,cityId,compId));
		personIndirectProfit.addAll(this.mixPersonProfitData((byte) 3, personProfitIndirect, archiveIdMap, dealIdMap, profitIdMap, compRoleMap, erpZxRoleConfig, funperforTypeMap, profitDynamicMappingShareProfitDynamic,cityId,compId));
		
		ProfitDistributionListVo result = new ProfitDistributionListVo();
		//数据不可能为null，没有数据默认为：0
		result.setPersonProfit(personProfit);//List
		result.setPersonDirectProfit(personDirectProfit);//List
		result.setPersonIndirectProfit(personIndirectProfit);//List

		//计算合计
		//个人提成（sumIncome），根据总业绩（sumDivideProfit） 结合 提成比例计算
		//查询当前用户的提成区间
		//performanceId 与 funwagetypenew对应的map，这里只涉及到个人
		Map<Byte, WageCountTypePackDto> wageTypeMap = erpFunRoleWageConfigService.getUserFunCountWageType(compId, cityId, currUserId, queryMonth, perosonPerformanceType);
		Byte performanceTypeReset = null;
		//当前用户为合并业绩提成的方式
		if(wageTypeMap != null){
			if(wageTypeMap.keySet().contains(Byte.valueOf("7"))){
				performanceTypeReset = Byte.valueOf("7");
			}
		}
		BigDecimal sumIncome = BigDecimal.ZERO;
		//分成业绩合计
		BigDecimal sumDivideProfit = BigDecimal.ZERO;
		for(ProfitDistributionVo tmp : result.getPersonProfit()){
			sumDivideProfit = sumDivideProfit.add(tmp.getDivideProfit());
			if(performanceTypeReset != null){
				tmp.setPerformanceType(performanceTypeReset);
			}
		}
		
		//计算个人总提成-分别计算个人不同业绩类别的提成，再合并计算
		Map<Byte, List<ProfitDistributionVo>> groupByPerformanceType = result.getPersonProfit().stream().collect(Collectors.groupingBy(ProfitDistributionVo::getPerformanceType));
		if(wageTypeMap != null){
			for(Map.Entry<Byte, List<ProfitDistributionVo>> tmpValue : groupByPerformanceType.entrySet()){
				Byte tmpTypeKey = tmpValue.getKey();
				List<ProfitDistributionVo> tmpProfitValue = tmpValue.getValue();
				Double totalIncome = 0.0d;
				if(tmpProfitValue != null && tmpProfitValue.size() > 0) {
					totalIncome = tmpProfitValue.stream().collect(Collectors.summingDouble(val -> val.getDivideProfit().doubleValue()));
				}
				
				if(wageTypeMap != null){
					Byte wageCountType = null;
					List<ErpFunCountwage> erpFunCountwages = new ArrayList<>();
					WageCountTypePackDto tmpPackDto = wageTypeMap.get(tmpTypeKey);
					if(null != tmpPackDto){
						wageCountType = tmpPackDto.getErpFunWageTypeNew().getWageCountType();
						erpFunCountwages = tmpPackDto.getCountWageTypeList();
					}
					if(erpFunCountwages != null){
						boolean isSubsectionMathIncome = false;
						if(wageCountType != null && wageCountType == 1){
							sumIncome = this.getSubsectionMathIncome(BigDecimal.valueOf(totalIncome), erpFunCountwages,cityId,compId);
							isSubsectionMathIncome = true;
						}else if(wageCountType != null && wageCountType == 2){
							sumIncome = this.getMatchComminsionAndBonus(BigDecimal.valueOf(totalIncome), erpFunCountwages,cityId,compId);
						}
						for(ProfitDistributionVo tmp1 : tmpProfitValue){
							if(tmp1.getDataType() == 1){
								if(isSubsectionMathIncome){
									//阶梯提成时需要将个人单独的业绩设置为默认值：“-”，因为是根据业绩总和来计算提成的，与通提不一样不能把每笔业绩的提成相加得到
									tmp1.setIncomeProfit("-");
								}else{
									tmp1.setIncomeProfit(this.getMatchComminsionAndBonus(BigDecimal.valueOf(StringUtil.parseDouble(tmp1.getIncomeProfit())), erpFunCountwages, cityId, compId).toString());
								}
							}
						}
					}
				}
			}
		}
		
		//直接和间接提成直接根据分润比例计算，不像个人提成计算那么麻烦
		//直接提成
		BigDecimal sumDirectIncome = BigDecimal.ZERO;
		//直接贡献绩效合计
		BigDecimal sumDirectContribution = BigDecimal.ZERO;
		for(ProfitDistributionVo tmp : result.getPersonDirectProfit()){
			sumDirectContribution = sumDirectContribution.add(tmp.getContributionProfit());
			//计算提成
			sumDirectIncome = sumDirectIncome.add(BigDecimal.valueOf(Double.parseDouble(tmp.getIncomeProfit())));
		}
		
		//传承提成
		BigDecimal sumIndirectIncome = BigDecimal.ZERO;
		//传承贡献绩效合计
		BigDecimal sumIndirectContribution = BigDecimal.ZERO;
		for(ProfitDistributionVo tmp : result.getPersonIndirectProfit()){
			sumIndirectContribution = sumIndirectContribution.add(tmp.getContributionProfit());
			//计算提成
			sumIndirectIncome = sumIndirectIncome.add(BigDecimal.valueOf(Double.parseDouble(tmp.getIncomeProfit())));
		}
		
		result.setSumIncome(sumIncome);
		result.setSumDivideProfit(sumDivideProfit);
		result.setSumDirectIncome(sumDirectIncome);
		result.setSumDirectContribution(sumDirectContribution);
		result.setSumIndirectIncome(sumIndirectIncome);
		result.setSumIndirectContribution(sumIndirectContribution);
		
		//顶部数据
		result.setProfitMoney(sumIncome);
		result.setDirectProfitMoney(sumDirectIncome);
		result.setIndirectProfitMoney(sumIndirectIncome);
		result.setSumProfitMoney(result.getProfitMoney().add(result.getDirectProfitMoney().add(result.getIndirectProfitMoney())));

		//初始化一个传承团队人数
		Integer userTeamNumber = 0;

		//设置用户信息
		ErpFunUsers erpFunUsers = archiveIdMap.get(currArchiveId);
		if(erpFunUsers != null){
			userTeamNumber = erpFunUsers.getUserTeamNumber() - 1;
			//查询员工信息
			result.setUserName(erpFunUsers.getUserName());
			//查询角色名称
			ErpCompRoles role = erpCompRolesMapper.getByRoleId(cityId, compId, erpFunUsers.getUserPosition());
			result.setRoleName(role.getRoleName());
			//查询头像地址
			AdminFunArchive archive = adminFunArchiveMapper.getArchiveById(erpFunUsers.getArchiveId());
			result.setUserPhotoUrl(AppConfig.getUserPhotoPicDomainPath(archive.getUserPhoto()));
		}

		//----房基地二期添加代码(掌通使用):查询直接团队人数与传承团队人数  2019-9-20
		ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
		erpFunUsersExample.setShardCityId(cityId);
		erpFunUsersExample.createCriteria().andCurrentPIdEqualTo(currUserId).andUserWriteoffEqualTo(false);
		//查询个人和直接、传承的提成最大值
		//当前月份
		String assessmentMonth = DateUtil.DateToString(new Date(),"yyyy-MM");
		//个人提成百分比最大值
		BigDecimal maxPros = erpFunRoleWageConfigMapper.getRoleWageMaxPro(cityId,compId,assessmentMonth,erpFunUsers.getUserPosition());
		//提成和升降级
		RoyaltyInfoVO royaltyInfoVos = erpZxRoleConfigMapper.getRoyaltyInfo(cityId,compId,erpFunUsers.getUserPosition());
		result.setPersonPercent(maxPros);
		if(null != royaltyInfoVos){
			result.setPersonDirectPercent(royaltyInfoVos.getPersonDirectPercent());
			result.setPersonIndirectPercent(royaltyInfoVos.getPersonIndirectPercent());
		}
		//直接团队人数
		Integer directUserNum = erpFunUsersMapper.countByExample(erpFunUsersExample);
		//传承团队人数
		Integer indirectUserNum = userTeamNumber - directUserNum < 0 ? 0 : userTeamNumber - directUserNum;
		result.setDirectUserNum(directUserNum);
		result.setIndirectUserNum(indirectUserNum);
		return ErpResponseJson.ok(result);
	}
	
	/**
	 * 查询个人提成、直接培育提成、间接培育提成
	 * 这里只计算已结算的合同业绩
	 * @Package com.myfun.erpWeb.managecenter.profit 
	 * @author 陈文超   
	 * @date 2019年8月28日 下午8:42:05
	 */
	@ApiOperation(value = "查询个人提成-业绩、直接培育提成-业绩、间接培育提成-业绩", httpMethod = "POST")
	@ApiResponses({@ApiResponse(code = 200, response = ProfitSumIncomeVo.class, message = "success")})
	@RequestMapping("/getPersonProfitSum")
	public ErpResponseJson getPersonProfitSum(){
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		Integer userId = getOperator().getUserId();
		Integer currArchiveId = getOperator().getArchiveId();
		BigDecimal directRoyalty = BigDecimal.ZERO;//直接提成比例
		BigDecimal indirectRoyalty = BigDecimal.ZERO;//间接提成比例

		ProfitSumIncomeVo result = new ProfitSumIncomeVo();
		//当前月份
		String queryMonth = DateUtil.DateToString(new Date(),"yyyy-MM");
		//查询员工信息
		ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, userId);
		String roleIdtmp = erpFunUsers.getUserPosition();
		//查询该角色配置
		ErpZxRoleConfig erpZxRoleConfig = this.getErpZxRoleConfigData(cityId, compId, queryMonth, roleIdtmp).get(roleIdtmp);
		String compProportion = erpSysParaMapper.getParamValue(cityId, compId, "SIPHON_TOTAL_PERFORMANCE_PERCENTAGE"); 
		if(null != erpZxRoleConfig){
			if(null != erpZxRoleConfig.getDirectRoyalty()){
				directRoyalty = erpZxRoleConfig.getDirectRoyalty();
				if(StringUtil.isNotEmpty(compProportion)){
					directRoyalty = directRoyalty.subtract(directRoyalty.multiply(new BigDecimal(compProportion)).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP));
				}
			}
			if(null != erpZxRoleConfig.getIndirectRoyalty()){
				indirectRoyalty = erpZxRoleConfig.getIndirectRoyalty();
				if(StringUtil.isNotEmpty(compProportion)){
					indirectRoyalty = indirectRoyalty.subtract(indirectRoyalty.multiply(new BigDecimal(compProportion)).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP));
				}
			}
		}
		
//		 SELECT SUM(ISNULL(INCOME_AMOUNT,0)) AS sumIncome FROM FUN_PROFIT_DYNAMIC_DETAIL
//		 WHERE COMP_ID = #{compId} AND DEL_FLAG = 0 AND INCOME_AMOUNT_TYPE = 1 AND SETTLEMENT_MONTH = #{queryMonth} AND USER_ID = #{userId}
		//个人业绩总和-查询个人业绩必须使用currArchiveId
		BigDecimal sumProfit = erpFunProfitDynamicDetailMapper.selectSumUserIncome(cityId, compId, currArchiveId, queryMonth);
		
        //邀请人和直接培育业绩总和
		BigDecimal sumDirectProfit = BigDecimal.ZERO;
		//查询计算直接培育提成需要的数据
		List<Byte> upLeaderTypeList = new ArrayList<Byte>();
		upLeaderTypeList.add((byte) 0);
		upLeaderTypeList.add((byte) 1);
		ErpFunProfitDynamicShareDetailExample examplePersonDirect = new ErpFunProfitDynamicShareDetailExample();
		examplePersonDirect.setShardCityId(cityId);
		ErpFunProfitDynamicShareDetailExample.Criteria criteriaDirect = examplePersonDirect.createCriteria();
		criteriaDirect.andCompIdEqualTo(compId).andUpLeaderUserEqualTo(userId).andDelFlagEqualTo((byte)0).andUpLeaderTypeIn(upLeaderTypeList);
		criteriaDirect.andSettlementMonthEqualTo(queryMonth);
		criteriaDirect.andIncomeAmountTypeEqualTo((byte) 1);
		List<ErpFunProfitDynamicShareDetail> personProfitDirectPo = erpFunProfitDynamicShareDetailMapper.selectByExample(examplePersonDirect);
		//过滤掉邀请人和直接培育人相同的数据
		this.processPfofitData(personProfitDirectPo);
		for(ErpFunProfitDynamicShareDetail tmp : personProfitDirectPo){
			sumDirectProfit = sumDirectProfit.add(tmp.getIncomeAmount());
		}
		
		//传承培育业绩总和
		BigDecimal sumIndirectProfit = erpFunProfitDynamicShareDetailMapper.selectSumIndirectIncome(cityId, compId, userId, queryMonth);
		sumProfit = Optional.ofNullable(sumProfit).orElse(BigDecimal.ZERO);
		sumDirectProfit = Optional.ofNullable(sumDirectProfit).orElse(BigDecimal.ZERO);
		sumIndirectProfit = Optional.ofNullable(sumIndirectProfit).orElse(BigDecimal.ZERO);
		
		//查询计算个人提成需要的数据
		ErpFunProfitDynamicDetailExample examplePerson = new ErpFunProfitDynamicDetailExample();
		examplePerson.setShardCityId(cityId);
		ErpFunProfitDynamicDetailExample.Criteria criteria = examplePerson.createCriteria();
		criteria.andCompIdEqualTo(compId).andArchiveIdEqualTo(currArchiveId).andDelFlagEqualTo((byte) 0);
		criteria.andSettlementMonthEqualTo(queryMonth);
		criteria.andIncomeAmountTypeEqualTo((byte) 1);
		List<ErpFunProfitDynamicDetail> personProfitPoList = erpFunProfitDynamicDetailMapper.selectByExample(examplePerson);

		//个人提成 结合 提成比例计算
		//流水中的PerformanceId = PerformanceType，注意区分，有点隐蔽，历史遗留问题
		Set<Integer> perosonPerformanceType = personProfitPoList.stream().collect(Collectors.mapping(val -> val.getPerformanceId(), Collectors.toSet()));
		//计算合计
		//查询当前用户的提成区间
		Map<Byte, WageCountTypePackDto> wageTypeMap = erpFunRoleWageConfigService.getUserFunCountWageType(compId, cityId, userId, queryMonth, perosonPerformanceType);
		Integer performanceTypeReset = null;
		if(wageTypeMap != null){
			//当前用户为合并业绩提成的方式
			if(wageTypeMap.keySet().contains(Byte.valueOf("7"))){
				performanceTypeReset = 7;
			}
			if(performanceTypeReset != null){
				for(ErpFunProfitDynamicDetail tmp : personProfitPoList){
					tmp.setPerformanceId(performanceTypeReset);
				}
			}
		}
		//计算个人总提成-分别计算个人不同业绩类别的提成，再合并计算
		Map<Integer, List<ErpFunProfitDynamicDetail>> groupByPerformanceType = personProfitPoList.stream().collect(Collectors.groupingBy(ErpFunProfitDynamicDetail::getPerformanceId));
		
		BigDecimal sumIncome = BigDecimal.ZERO;
		for(Map.Entry<Integer, List<ErpFunProfitDynamicDetail>> tmpValue : groupByPerformanceType.entrySet()){
			Byte tmpTypeKey = tmpValue.getKey().byteValue();
			List<ErpFunProfitDynamicDetail> tmpProfitValue = tmpValue.getValue();
			Double totalIncome = 0.0d;
			if(tmpProfitValue != null && tmpProfitValue.size() > 0) {
				totalIncome = tmpProfitValue.stream().collect(Collectors.summingDouble(val -> val.getIncomeAmount().doubleValue()));
			}
			
			if(wageTypeMap != null){
				WageCountTypePackDto tmpPackDto = wageTypeMap.get(tmpTypeKey);
				Byte wageCountType = null;
				List<ErpFunCountwage> erpFunCountwages = new ArrayList<>();
				if(null != tmpPackDto){
					wageCountType = tmpPackDto.getErpFunWageTypeNew().getWageCountType();
					erpFunCountwages = tmpPackDto.getCountWageTypeList();
				}
				if(erpFunCountwages != null){
					if(wageCountType != null && wageCountType == 1){
						sumIncome = this.getSubsectionMathIncome(BigDecimal.valueOf(totalIncome), erpFunCountwages,cityId,compId);
					}else if(wageCountType != null && wageCountType == 2){
						sumIncome = this.getMatchComminsionAndBonus(BigDecimal.valueOf(totalIncome), erpFunCountwages,cityId,compId);
					}
				}
			}
		}
		
		result.setSumIncome(sumIncome);
		result.setSumDirectIncome(sumDirectProfit.multiply(directRoyalty).divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_EVEN));
		result.setSumIndirectIncome(sumIndirectProfit.multiply(indirectRoyalty).divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_EVEN));
		Integer userRank = 0;
		Byte levelChange = 0;
		//查询业绩排名
		List<CompPerformanceRankingVO> rankingVOS = erpFunProfitDynamicDetailMapper.selectCompPerformanceRanking(cityId,compId,queryMonth);
		if(null != rankingVOS && rankingVOS.size() > 0){
			Map<Integer, Integer> ranks = rankingVOS.stream().filter(val -> val.getUserId() != null && val.getUserId() > 0).collect(Collectors.toMap(CompPerformanceRankingVO::getUserId, val -> val.getRank()));
			userRank = null == ranks.get(userId) ? 0 : ranks.get(userId);
		}
		//查询之前的排名情况
        Integer oldUserRank = erpFunUserRankExaminationMapper.selectUserRank(cityId, compId, userId);
        if(null != oldUserRank && !"0".equals(oldUserRank.toString())){
			if(oldUserRank > userRank){
				levelChange = 1;//上升
			} else if (oldUserRank < userRank){
				levelChange = 2;//下降
			}
        }
		result.setProfitRanking(userRank);//业绩排名
		result.setSumAllProfit(sumProfit.add(sumDirectProfit).add(sumIndirectProfit));//个人 + 直接 + 间接培育业绩的合计
		result.setLevelChange(levelChange);
		return ErpResponseJson.ok(result);
	}


	/**
	 * 个人的升降情况数据展示
	 * 个人业绩、团队业绩、团队人数
	 * 
	 * 该接口目前移动端在使用
	 * @Package com.myfun.erpWeb.managecenter.profit 
	 * @author 陈文超   
	 * @date 2019年8月29日 下午3:55:05
	 */
	@ApiOperation(value = "个人的升降情况数据展示", httpMethod = "POST")
	@ApiResponses({@ApiResponse(code = 200, response = FluctuantDetailVo.class, message = "success")})
	@RequestMapping("/getFluctuantDetail")
	public ErpResponseJson getFluctuantDetail(){
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		Integer userId = getOperator().getUserId();
		Integer archiveId = getOperator().getArchiveId();
		FluctuantDetailVo result = new FluctuantDetailVo();
		Set<Integer> archiveIds = new HashSet<Integer>();
		archiveIds.add(archiveId);
		
		Set<Integer> userIds = new HashSet<Integer>();
		userIds.add(userId);
		//查询员工信息
		ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, userId);
		result.setUserName(erpFunUsers.getUserName());
		//查询角色名称
		ErpCompRoles role = erpCompRolesMapper.getByRoleId(cityId, compId, erpFunUsers.getUserPosition());
		result.setRoleName(role.getRoleName());
		//查询头像地址
		AdminFunArchive archive = adminFunArchiveMapper.getArchiveById(archiveId);
		result.setUserPhotoUrl(AppConfig.getUserPhotoPicDomainPath(archive.getUserPhoto()));
		
		String roleIdtmp = erpFunUsers.getUserPosition();
		//查询个人业绩目标和团队业绩目标
		ErpZxRoleConfig erpZxRoleConfig = this.getErpZxRoleConfigData(cityId, compId, null, roleIdtmp).get(roleIdtmp);
		result.setuOpernFalg(1);//网页判断这个不为1就是没开
		if(null == erpZxRoleConfig || erpZxRoleConfig.getuOpernFalg().equals(false)){//如果没有设置，或者自动升级为否就直接返回
			result.setuOpernFalg(0);
			return ErpResponseJson.ok(result);
		}
		if(null != erpZxRoleConfig.getuPersonalAchievement()){//个人业绩目标
			result.setPersonProfitAim(BigDecimal.valueOf(erpZxRoleConfig.getuPersonalAchievement()));
		}
		if(null != erpZxRoleConfig.getuTeamAchievement()){//团队业绩目标
			result.setTeamProfitAim(BigDecimal.valueOf(erpZxRoleConfig.getuTeamAchievement()));
		}
		if(null != erpZxRoleConfig.getuTeamMembers()){//团队人数目标
			result.setTeamPeopleAim(erpZxRoleConfig.getuTeamMembers());
		}
		//自动升级个人业绩是否选中 0 否 1 是
		result.setPersonProfitShow(erpZxRoleConfig.getuPersonalAchievementChose());
		//自动升级团队业绩人数是否选中 0 否 1 是
		result.setTeamProfitShow(erpZxRoleConfig.getuTeamAchievementChose());
		//自动升级团队人数是否选中 0 否 1 是
		result.setTeamPeopleShow(erpZxRoleConfig.getuTeamMembersChose());
		//查询个人业绩数据
		List<UserProfitVo> personProfitVos = erpFunProfitDetailMapper.getUserAllIncomeAmount(cityId, compId, archiveIds);
		for (UserProfitVo personProfitVo : personProfitVos) {
			//分成业绩需要先减去公司提成部分
			result.setPersonProfit(personProfitVo.getIncomeAmount());
		}
		
		//查询团队业绩数据
		List<UserProfitVo> treamProfitVos = erpFunProfitShareDetailMapper.getUserTeamAmount(cityId, compId, userIds);
		for (UserProfitVo treamProfitVo : treamProfitVos) {
			result.setTeamProfit(treamProfitVo.getIncomeAmount());
		}

		//团队人数
		result.setTeamPeople(erpFunUsers.getUserTeamNumber());
		ErpCompRoles uRole = erpCompRolesMapper.getByRoleId(cityId, compId, erpZxRoleConfig.getuRoleId());
		String tip = "该职级未配置升级规则";
		if(null != uRole && StringUtil.isNotEmpty(uRole.getRoleName())){
			tip = judgeTip(result,uRole.getRoleName(),erpZxRoleConfig.getuConditionFalg());
		}
		result.setGetToAimTip(tip);
		return ErpResponseJson.ok(result);
	}

	/**
	 * 考核数据统计
	 * 根据条件查询：个人、团队、月份范围内的数据
	 * 
	 * 数据含有：个人提成、直接培育、传承培育、提成合计
	 * @Package com.myfun.erpWeb.managecenter.profit 
	 * @author 陈文超   
	 * @date 2019年8月30日 下午2:04:53
	 */
	@ApiOperation(value = "考核统计数据", httpMethod = "POST")
	@ApiResponses({@ApiResponse(code = 200, response = AssessCountDataListVo.class, message = "success")})
	@RequestMapping("/getAssessCountData")
	public ErpResponseJson getAssessCountData(@Valid @RequestBody AssessCountDataParam param){
		
		Integer currUserId = getOperator().getUserId();
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		String roleIdParam = param.getRoleId();
		String queryMonth = param.getMonthStr();
		//判断选择的是个人还是团队
		param.setCompId(compId);
		if(StringUtil.isBlank(queryMonth)){
			queryMonth = DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy-MM");
		}
		//移动端的请求需要单独判断查询权限范围
		if(param.getQueryDevice() == 1){
			ErpUserOpersExample example = new ErpUserOpersExample();
			example.setShardCityId(cityId);
			example.createCriteria().andUserIdEqualTo(currUserId).andOperIdIn(new ArrayList<String>(Arrays.asList("VIEW_ALL_ZX_PROFIT", "VIEW_T_ALL_NODE_ZX_PROFIT", "VIEW_T_ZX_PROFIT")));
			List<ErpUserOpers> erpUserOpersList = erpUserOpersMapper.selectByExample(example);
			if(erpUserOpersList.size() > 0){
				List<String> operIds = erpUserOpersList.stream().collect(Collectors.mapping(val -> val.getOperId(), Collectors.toList()));
				if(operIds.contains("VIEW_ALL_ZX_PROFIT")){//全部
					param.setUserId(null);
				}else if(operIds.contains("VIEW_T_ALL_NODE_ZX_PROFIT")){//下级团队
					param.setQueryType((byte) 2);
					param.setQueryRange((byte) 2);
					param.setUserId(currUserId);
				}else if(operIds.contains("VIEW_T_ZX_PROFIT")){//团队
					param.setQueryType((byte) 2);
					param.setQueryRange((byte) 3);
					param.setUserId(currUserId);
				}
			}else{
				//只能查询本人
				param.setQueryType((byte) 1);
				param.setUserId(currUserId);
			}
		}
		
		//公司角色数据集合
		List<ErpCompRoles> compRoleList = erpCompRolesMapper.getAllCompRole(cityId, compId);
		if(compRoleList.isEmpty()){
			return ErpResponseJson.ok();
		}
		Map<String, ErpCompRoles> compRoleMap = compRoleList.stream().collect(Collectors.toMap(ErpCompRoles::getRoleId, val -> val));
		
		//查询人员数据集合
		ErpFunUsersExample example = new ErpFunUsersExample();
		example.setShardCityId(cityId);
		example.setOrderByClause("USER_ID");
		ErpFunUsersExample.Criteria queryCondition = example.createCriteria().andCompIdEqualTo(compId).andUserWriteoffEqualTo(false);
		
		List<AssessRoleCountDataVo> assessRoleCountDataVos = this.getUserQueryCondition(cityId, param);
		
		List<Integer> queryUserIds = new ArrayList<>();
		for(AssessRoleCountDataVo tmp : assessRoleCountDataVos){
			queryUserIds.add(tmp.getUserId());
		}
		if(queryUserIds.size() > 0){
			queryCondition.andUserIdIn(queryUserIds);
		}else{
			return ErpResponseJson.ok(); 
		}
		
		//移动端专用角色查询
		if(param.getQueryDevice() == 1 && !StringUtil.isBlank(roleIdParam)){
			queryCondition.andUserPositionEqualTo(roleIdParam);
		}
		
		//用户信息分页
		List<ErpFunUsers> userList = erpFunUsersMapper.selectByExample(example);
		if(userList.isEmpty()){
			return ErpResponseJson.ok();
		}
		Map<Integer, ErpFunUsers> userIdMap = userList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, val -> val));
		//档案ID对应的用户对象
		Map<Integer, ErpFunUsers> archiveIdMap = userList.stream().collect(Collectors.toMap(ErpFunUsers::getArchiveId, val -> val));
		
		
		List<AssessCountDataVo> assessCountDataList = new ArrayList<AssessCountDataVo>();
		//先创建公司员工信息，再拼接统计数据
		for(ErpFunUsers tmp : userList){
			AssessCountDataVo dataDetailVo = new AssessCountDataVo();
			String roleIdTmp = tmp.getUserPosition();
			Integer recommendUserId = tmp.getCurrentPId();
			dataDetailVo.setUserId(tmp.getUserId());
			dataDetailVo.setArchiveId(tmp.getArchiveId());
			dataDetailVo.setUserName(tmp.getUserName());
			dataDetailVo.setRoleId(roleIdTmp);
			ErpCompRoles roleObj = compRoleMap.get(roleIdTmp);
			if(roleObj != null){
				dataDetailVo.setRoleName(roleObj.getRoleName());
			}
			
			//推荐人
			ErpFunUsers recommUser = userIdMap.get(recommendUserId);
			if(recommUser != null){
				dataDetailVo.setRecommendUserId(recommUser.getUserId());
				dataDetailVo.setRecommendUserName(recommUser.getUserName());
			}else{
				dataDetailVo.setRecommendUserName("无");
			}
			assessCountDataList.add(dataDetailVo);
		}
		//通过FUN_PROFIT_DYNAMIC_SHARE_DETAIL、FUN_PROFIT_DYNAMIC_DETAIL 和 FUN_PROFIT_DETAIL 表进行计算
		//个人应收统计数据用：FUN_PROFIT_DYNAMIC_DETAIL
		//个人实收统计数据用：FUN_PROFIT_DETAIL
		//直接培育和间接培育用：FUN_PROFIT_DYNAMIC_SHARE_DETAIL
		
		//查询统计数据然后与用户信息进行拼装
		if(assessCountDataList.isEmpty()){
			return ErpResponseJson.ok();
		}
		
		//查询角色的直接和间接分润配置
		//角色的分润配置
		Map<String, ErpZxRoleConfig> roleZxConfigMap = this.getErpZxRoleConfigData(cityId, compId, queryMonth, null);
		
		//查询个人业绩收入统计数据
		List<ErpAssessCountDataDto> assessCountList = erpFunProfitDetailMapper.getAssessCountData(cityId, compId, queryMonth);
		Map<String, List<ErpAssessCountDataDto>> assessMapData = BeanUtil.listObjToMapObjPackForList(assessCountList, "archiveId");
		
		//查询直接培育提成统计数据、查询间接培育提成统计数据-该统计只统计了0和2类型的数据
		List<ErpLeaderAssessCountDataDto> leaderAssessCountData = erpFunProfitDynamicShareDetailMapper.getLeaderAssessCountData(cityId, compId, queryMonth);
		Map<String, List<ErpLeaderAssessCountDataDto>> leaderAssessMapData = BeanUtil.listObjToMapObjPackForList(leaderAssessCountData, "upLeaderUser");
		
		List<ErpCountWageTypeDto> countWageTypeList = erpFunRoleWageConfigMapper.queryRoleWagetypeInfo(cityId, compId, queryMonth);
		//WagetypeRelativeId 对应的 业绩类别数据
		Map<Integer, Map<Byte, Integer>> wagetypeRelativeIdMapwageTypeNewId = new HashMap<>();
		//用户关联业绩提成区间类型表（FUN_WAGE_TYPE_NEW ）getWagetypeRelativeId = ErpRoleWagetypeRelative 的主键ID
		Map<Integer, Integer> countWageTypeMap = countWageTypeList.stream().collect(Collectors.toMap(ErpCountWageTypeDto::getUserId, val -> val.getWagetypeRelativeId()));
		List<Integer> roleWagetypeRelativeIds = countWageTypeList.stream().collect(Collectors.mapping(val -> val.getWagetypeRelativeId(), Collectors.toList()));
		//使用countWageTypeMap 和 erpRoleWagetypeRelativeMap 形成userId的映射wagetypeRelativeId，wagetypeRelativeId再从erpRoleWagetypeRelativeMap获取关联薪资提成类型的ID的( totalId or newtotalId)(FUN_WAGE_TYPE_NEW的ID)
		//直接查询FunCountwage提成配置表，分为通提和阶提
		//查查流程 userId ---> WagetypeRelativeId ---> erpRoleWagetypeRelativeMap的ID ---> 根据RoyaltyType判断 totalId or newtotalId为总业绩的提成配置 wagetypeId
		List<Integer> wageTypeIds = new ArrayList<>();
		if(roleWagetypeRelativeIds != null && !roleWagetypeRelativeIds.isEmpty()){
			// 查询到个人的提成业绩
			ErpRoleWagetypeRelativeExample erpRoleWagetypeRelativeExample = new ErpRoleWagetypeRelativeExample();
			erpRoleWagetypeRelativeExample.setShardCityId(cityId);
			erpRoleWagetypeRelativeExample.createCriteria().andIdIn(roleWagetypeRelativeIds).andCountTypeEqualTo((byte) 0).andIsCheckEqualTo((byte) 1);
			List<ErpRoleWagetypeRelative> erpRoleWagetypeRelativeList = erpRoleWagetypeRelativeMapper.selectByExample(erpRoleWagetypeRelativeExample);
			//角色模板（关联业绩提成）
			for(ErpRoleWagetypeRelative tmp : erpRoleWagetypeRelativeList){
				// performanceType 1=过户 2=二手佣金 3=新房佣金 4=租赁租金 5=金融 6是总业绩 7新的总业绩
//				1：erpRoleWagetypeRelative.getTransferId();
//				2：erpRoleWagetypeRelative.getSecondhandId();
//				3：erpRoleWagetypeRelative.getNewhouseId();
//				4：erpRoleWagetypeRelative.getLeaseId();
//				5：erpRoleWagetypeRelative.getFinanceId();
//				6：erpRoleWagetypeRelative.getTotalId();
//				7:erpRoleWagetypeRelative.getNewtotalId();
				Map<Byte, Integer> tmpWagetypeRelative = new HashMap<>();
				if(tmp.getTransferId() != null){
					wageTypeIds.add(tmp.getTransferId());
					tmpWagetypeRelative.put(Byte.valueOf("1"), tmp.getTransferId());
				}
				if(tmp.getSecondhandId() != null){
					wageTypeIds.add(tmp.getSecondhandId());
					tmpWagetypeRelative.put(Byte.valueOf("2"), tmp.getSecondhandId());
				}
				if(tmp.getNewhouseId() != null){
					wageTypeIds.add(tmp.getNewhouseId());
					tmpWagetypeRelative.put(Byte.valueOf("3"), tmp.getNewhouseId());
				}
				if(tmp.getLeaseId() != null){
					wageTypeIds.add(tmp.getLeaseId());
					tmpWagetypeRelative.put(Byte.valueOf("4"), tmp.getLeaseId());
				}
				if(tmp.getFinanceId() != null){
					wageTypeIds.add(tmp.getFinanceId());
					tmpWagetypeRelative.put(Byte.valueOf("5"), tmp.getFinanceId());
				}
				
				if(tmp.getTotalId() != null){
					wageTypeIds.add(tmp.getTotalId());
					tmpWagetypeRelative.put(Byte.valueOf("6"), tmp.getTotalId());
				}
				//合并计算
				if(tmp.getNewtotalId() != null && tmp.getRoyaltyType() == 2){
					wageTypeIds.add(tmp.getNewtotalId());
					tmpWagetypeRelative.put(Byte.valueOf("7"), tmp.getNewtotalId());
				}
				wagetypeRelativeIdMapwageTypeNewId.put(tmp.getId(), tmpWagetypeRelative);
			}
		}
		
		//查询提成配置数据
		Map<String, List<ErpFunCountwage>> funCountwageMap = new HashMap<>();
		//查询提成类别数据
		Map<Integer, ErpFunWageTypeNew> erpFunWageTypeNewMap = new HashMap<>();
		if(wageTypeIds != null && wageTypeIds.size() > 0){
			//查询提成类型数据：FUN_WAGE_TYPE_NEW
			ErpFunWageTypeNewExample exampleFunWageTypeNew = new ErpFunWageTypeNewExample();
			exampleFunWageTypeNew.setShardCityId(cityId);
			exampleFunWageTypeNew.createCriteria().andCompIdEqualTo(compId).andIdIn(wageTypeIds);
			List<ErpFunWageTypeNew> erpFunWageTypeNewList = erpFunWageTypeNewMapper.selectByExample(exampleFunWageTypeNew);
			erpFunWageTypeNewMap = erpFunWageTypeNewList.stream().collect(Collectors.toMap(ErpFunWageTypeNew::getId, val -> val));
			
			ErpFunCountwageExample erpFunCountwageExample = new ErpFunCountwageExample();
			erpFunCountwageExample.setShardCityId(cityId);
			erpFunCountwageExample.createCriteria().andWagetypeIdIn(wageTypeIds);
			erpFunCountwageExample.setOrderByClause("SEQ asc");
			List<ErpFunCountwage> erpFunCountwages = erpFunCountwageMapper.selectByExample(erpFunCountwageExample);
			funCountwageMap = BeanUtil.listObjToMapObjPackForList(erpFunCountwages, "wagetypeId");
		}
		String compProportion = erpSysParaMapper.getParamValue(cityId, compId, "SIPHON_TOTAL_PERFORMANCE_PERCENTAGE"); 
		for(AssessCountDataVo tmp : assessCountDataList){
			String roleIdTmp = tmp.getRoleId();
			Integer archiveIdTmp = tmp.getArchiveId();
			
			ErpZxRoleConfig tmpZxRoleConfig = roleZxConfigMap.get(roleIdTmp);
			BigDecimal directRoyalty = BigDecimal.ZERO;
			BigDecimal indirectRoyalty = BigDecimal.ZERO;
			
			if(tmpZxRoleConfig != null){
				if(tmpZxRoleConfig.getDirectRoyalty() != null){
					directRoyalty = tmpZxRoleConfig.getDirectRoyalty();
					if(StringUtil.isNotEmpty(compProportion)){
						directRoyalty = directRoyalty.subtract(directRoyalty.multiply(new BigDecimal(compProportion)).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP));
					}

				}
				if(tmpZxRoleConfig.getIndirectRoyalty() != null){
					indirectRoyalty = tmpZxRoleConfig.getIndirectRoyalty();
					if(StringUtil.isNotEmpty(compProportion)){
						indirectRoyalty = indirectRoyalty.subtract(indirectRoyalty.multiply(new BigDecimal(compProportion)).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP));
					}
				}
			}
			
			//直接和间接培育人业绩
//			直接培育业绩
//			应收业绩：本月下级人员的签约应收业绩合计
//			入账实收：本月下级人员的实收业绩合计
//			结盘实收：本月下级人员的结算实收业绩合计
//			传承培育业绩
//			应收业绩：本月下下级人员的签约应收业绩合计
//			入账实收：本月下下级人员的实收业绩业绩合计
//			结盘实收：本月下下级人员的结算实收业绩合计
			this.mixAssessCountData(tmp, leaderAssessMapData);
			
			//====================个人业绩提成计算代码====开始======================
			//本月签约应收业绩、本月下级人员的签约应收业绩合计、本月直接下级人员的签约应收业绩合计、本月传承下级人员的签约应收业绩合计
			List<ErpAssessCountDataDto> tmpCountData = assessMapData.get(archiveIdTmp.toString());
			if(tmpCountData != null){
				//计算个人业绩总和
				Map<String, Double> personProfitSumMap = tmpCountData.stream().collect(Collectors.groupingBy(ErpAssessCountDataDto::getCountType, Collectors.summingDouble(val -> val.getSumIncomeAmount().doubleValue())));
				tmp.setTheoryProfit(BigDecimal.valueOf(Optional.ofNullable(personProfitSumMap.get("SIGN_VALUE")).orElse(0.0d)));
				tmp.setEnterPaid(BigDecimal.valueOf(Optional.ofNullable(personProfitSumMap.get("INCOME_VALUE")).orElse(0.0d)));
				tmp.setOverPaid(BigDecimal.valueOf(Optional.ofNullable(personProfitSumMap.get("SETTLEMENT_VALUE")).orElse(0.0d)));
				
				ErpFunUsers tmpUserPoValue = archiveIdMap.get(archiveIdTmp);
				Integer userIdTmp = null;
				if(tmpUserPoValue != null){
					userIdTmp = tmpUserPoValue.getUserId();
				}
				//分别计算个人业绩提成
				Integer roleWagetypeRelativeId = countWageTypeMap.get(userIdTmp);
				//为null说明还没有配置提成
				Map<Byte, Integer> tmpWagetypeRelative = null;
				if(roleWagetypeRelativeId != null){
					tmpWagetypeRelative = wagetypeRelativeIdMapwageTypeNewId.get(roleWagetypeRelativeId);
					//如果为6或者7，那么该用户必定是使用的总业绩来计算提成
					if(tmpWagetypeRelative != null){
						Integer performanceIdReset = null;
						if(tmpWagetypeRelative.keySet().contains(Byte.valueOf("7"))){
							performanceIdReset = 7;
						}else if(tmpWagetypeRelative.keySet().contains(Byte.valueOf("6"))){
							performanceIdReset = 6;
						}
						if(performanceIdReset != null){
							for(ErpAssessCountDataDto tmpValue : tmpCountData){
								tmpValue.setPerformanceId(performanceIdReset);
							}
						}
					}
				}
				if(tmpWagetypeRelative != null){
					//实收、应收等业绩分类
					Map<String, List<ErpAssessCountDataDto>> groupByErpAssessCountDataDto = tmpCountData.stream().collect(Collectors.groupingBy(ErpAssessCountDataDto::getCountType));
					List<ErpAssessCountDataDto> enterPaidList = groupByErpAssessCountDataDto.get("INCOME_VALUE");
					if(enterPaidList != null){
						//各个业绩类别的业绩总和
						Map<Integer, Double> enterPaidPerformanceSumMap = enterPaidList.stream().collect(Collectors.groupingBy(ErpAssessCountDataDto::getPerformanceId, Collectors.summingDouble(val -> val.getSumIncomeAmount().doubleValue())));
						//根据业绩类别获得提成区间数据
						for(Map.Entry<Integer, Double> tmpValue : enterPaidPerformanceSumMap.entrySet()){
							Byte tmpKey = tmpValue.getKey().byteValue();
							Double tmpSumValue = tmpValue.getValue();
							Integer tmpwageTypeNewId = tmpWagetypeRelative.get(tmpKey);
							if(tmpwageTypeNewId != null){
								ErpFunWageTypeNew erpFunWageTypeNewTmp = erpFunWageTypeNewMap.get(tmpwageTypeNewId);
								List<ErpFunCountwage> countwageListTmp = funCountwageMap.get(tmpwageTypeNewId.toString());
								if(erpFunWageTypeNewTmp.getWageCountType() == 1){
									tmp.setTheoryBonus(tmp.getTheoryBonus().add(this.getSubsectionMathIncome(BigDecimal.valueOf(tmpSumValue), countwageListTmp,cityId,compId)));
								}else if(erpFunWageTypeNewTmp.getWageCountType() == 2){
									tmp.setTheoryBonus(tmp.getTheoryBonus().add(this.getMatchComminsionAndBonus(BigDecimal.valueOf(tmpSumValue), countwageListTmp,cityId,compId)));
								}
							}
						}
					}
					
					List<ErpAssessCountDataDto> overPaidList = groupByErpAssessCountDataDto.get("SETTLEMENT_VALUE");
					if(overPaidList != null){
						Map<Integer, Double> overPaidPerformanceSumMap = overPaidList.stream().collect(Collectors.groupingBy(ErpAssessCountDataDto::getPerformanceId, Collectors.summingDouble(val -> val.getSumIncomeAmount().doubleValue())));
						for(Map.Entry<Integer, Double> tmpValue : overPaidPerformanceSumMap.entrySet()){
							Byte tmpKey = tmpValue.getKey().byteValue();
							Double tmpSumValue = tmpValue.getValue();
							Integer tmpwageTypeNewId = tmpWagetypeRelative.get(tmpKey);
							if(tmpwageTypeNewId != null){
								ErpFunWageTypeNew erpFunWageTypeNewTmp = erpFunWageTypeNewMap.get(tmpwageTypeNewId);
								List<ErpFunCountwage> countwageListTmp = funCountwageMap.get(tmpwageTypeNewId.toString());
								if(erpFunWageTypeNewTmp.getWageCountType() == 1){
									tmp.setPracticalBonus(tmp.getPracticalBonus().add(this.getSubsectionMathIncome(BigDecimal.valueOf(tmpSumValue), countwageListTmp,cityId,compId)));
								}else if(erpFunWageTypeNewTmp.getWageCountType() == 2){
									tmp.setPracticalBonus(tmp.getPracticalBonus().add(this.getMatchComminsionAndBonus(BigDecimal.valueOf(tmpSumValue), countwageListTmp,cityId,compId)));
								}
							}
						}
					}
				}
			}
			//====================个人业绩提成计算代码====结束======================
			
			//直接和间接业绩数据提成
			tmp.setDirectTheoryBonus(tmp.getDirectEnterPaid().multiply(directRoyalty).divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_EVEN));
			tmp.setDirectPracticalBonus(tmp.getDirectOverPaid().multiply(directRoyalty).divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_EVEN));
			tmp.setIndirectTheoryBonus(tmp.getIndirectEnterPaid().multiply(indirectRoyalty).divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_EVEN));
			tmp.setIndirectPracticalBonus(tmp.getIndirectOverPaid().multiply(indirectRoyalty).divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_EVEN));
			//以下数据一定不会出现null，0是默认值
//			应发=个人应发提成+直接应发提成+传承应发提成
			tmp.setSumTheoryBonus(tmp.getTheoryBonus().add(tmp.getDirectTheoryBonus().add(tmp.getIndirectTheoryBonus())));
//			实发=个人实发提成+直接实发发提成+传承实发提成
			tmp.setSumPracticalBonus(tmp.getPracticalBonus().add(tmp.getDirectPracticalBonus().add(tmp.getIndirectPracticalBonus())));
		}
		
		AssessCountDataListVo assessRoleCountDataListVo =new AssessCountDataListVo(); 
		assessRoleCountDataListVo.setAssessCountDataList(assessCountDataList);
		ErpResponseJson erpResponseJson = ErpResponseJson.ok(new PageInfo<>(assessCountDataList));
		erpResponseJson.setData(assessRoleCountDataListVo);
		return erpResponseJson;
	}
	
	
	/**
	 * 职级考核数据统计
	 * 根据条件查询：个人、团队、月份范围内的数据
	 * 展示员工的晋级情况数据和降级情况数据
	 * @Package com.myfun.erpWeb.managecenter.profit
	 * @author 陈文超   
	 * @date 2019年8月30日 下午2:04:53
	 */
	@ApiOperation(value = "职级考核数据统计", httpMethod = "POST")
	@ApiResponses({@ApiResponse(code = 200, response = AssessRoleCountDataListVo.class, message = "success")})
	@RequestMapping("/getAssessRoleCountData")
	public ErpResponseJson getAssessRoleCountData(@Valid @RequestBody AssessCountDataParam param){
		
		Integer compId = getOperator().getCompId();
		Integer cityId = getOperator().getCityId();
		String monthStr = param.getMonthStr();
		param.setCompId(getOperator().getCompId());
		//判断选择的是个人还是团队
		List<AssessRoleCountDataVo> assessRoleCountDataVos = this.getUserQueryCondition(cityId, param);
		if(assessRoleCountDataVos.isEmpty()){
			return ErpResponseJson.ok();
		}
		Set<Integer> recommendUserIds = new HashSet<Integer>(); //推荐人
		Set<String> roleIds = new HashSet<String>(); //角色
		Set<Integer> userIds = new HashSet<Integer>();
		if(assessRoleCountDataVos !=null && assessRoleCountDataVos.size() > 0){
			for (AssessRoleCountDataVo assessRoleCountDataVo : assessRoleCountDataVos) {
				if(assessRoleCountDataVo.getRecommendUserId() !=null){
					recommendUserIds.add(assessRoleCountDataVo.getRecommendUserId());
				}
				roleIds.add(assessRoleCountDataVo.getRoleId());
				userIds.add(assessRoleCountDataVo.getUserId());
			}
			
			//个人业绩，团队业绩
			Map<Integer, ErpFunUserRankExamination> userRankExaminationMap  = new HashMap<Integer,ErpFunUserRankExamination>();
			ErpFunUserRankExaminationExample erpFunUserRankExaminationExample = new ErpFunUserRankExaminationExample();
			erpFunUserRankExaminationExample.setShardCityId(cityId);
			erpFunUserRankExaminationExample.createCriteria().andCompIdEqualTo(compId)
			.andCityIdEqualTo(cityId).andUserIdIn(new ArrayList<>(userIds));
			List<ErpFunUserRankExamination> erpFunUserRankExaminations = erpFunUserRankExaminationMapper.selectByExample(erpFunUserRankExaminationExample);
			if(erpFunUserRankExaminations !=null){
				userRankExaminationMap = erpFunUserRankExaminations.stream().collect(Collectors.toMap(ErpFunUserRankExamination::getUserId, a->a));
			}
			
			//查询角色配置
			Map<String,ErpZxRoleConfig> roleConfigMap = this.getErpZxRoleConfigData(cityId, compId, monthStr, null);
			Map<String,ErpCompRoles> roleNameMap = new HashMap<String,ErpCompRoles>();
			if(roleIds.size() > 0){
				ErpCompRolesExample compRolesExample = new ErpCompRolesExample();
				compRolesExample.setShardCityId(getOperator().getCityId());
				compRolesExample.createCriteria().andCompIdEqualTo(param.getCompId()).andIsDelEqualTo((byte)0);
				List<ErpCompRoles> compRoles = erpCompRolesMapper.selectByExample(compRolesExample);
				if(compRoles != null && compRoles.size() > 0){
					roleNameMap = compRoles.stream().collect(Collectors.toMap(ErpCompRoles::getRoleId, a->a));
				}
			}
			
			//查询团队领导
			Map<Integer,ErpFunUsers> treamLreaderNameMap = new HashMap<Integer,ErpFunUsers>();
			if(recommendUserIds.size() > 0){
				ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
				erpFunUsersExample.setShardCityId(getOperator().getCityId());	
				erpFunUsersExample.createCriteria().andCompIdEqualTo(param.getCompId()).andUserWriteoffEqualTo(false)
				.andUserIdIn(new ArrayList<>(recommendUserIds));
				List<ErpFunUsers> userNameList = erpFunUsersMapper.selectByUserNameExample(erpFunUsersExample);
				if(userNameList !=null && userNameList.size() > 0){
					treamLreaderNameMap = userNameList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, a->a));
				}
			}
			//查询人的升降情况
			Map<Integer,ErpUserRoleExamineLog> examineLoMap = new HashMap<Integer,ErpUserRoleExamineLog>();
			Date time = DateUtil.addMonth(new Date(),-1);
			List<ErpUserRoleExamineLog> erpUserRoleExamineLogs = erpUserRoleExamineLogMapper.getListLog(getOperator().getCityId(),getOperator().getCompId(),time,userIds);
			
			if(erpUserRoleExamineLogs != null && erpUserRoleExamineLogs.size() > 0){
				examineLoMap = erpUserRoleExamineLogs.stream().collect(Collectors.toMap(ErpUserRoleExamineLog::getUserId, a->a));
			}

			for (AssessRoleCountDataVo assessRoleCountDataVo : assessRoleCountDataVos) {
				if(StringUtil.isNotEmpty(assessRoleCountDataVo.getRegisterDate())){
					assessRoleCountDataVo.setRegisterDate(DateUtil.formatDateTimetoString(DateUtil.StringToDate(assessRoleCountDataVo.getRegisterDate(),"yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd"));
				}
				//个人业绩,团队业绩
				Integer userId = assessRoleCountDataVo.getUserId();
				if(userRankExaminationMap.containsKey(userId)){
					ErpFunUserRankExamination erpFunUserRankExamination = userRankExaminationMap.get(userId);
					assessRoleCountDataVo.setIncomeReach(erpFunUserRankExamination.getPersonAchievement());
					assessRoleCountDataVo.setIncomeReachDemotion(erpFunUserRankExamination.getPersonAchievementNow());
					assessRoleCountDataVo.setTeamIncomeReach(erpFunUserRankExamination.getTeamAchievement());
					assessRoleCountDataVo.setTeamIncomeReachDemotion(erpFunUserRankExamination.getTeamAchievementNow());
				}else{
					assessRoleCountDataVo.setIncomeReach(BigDecimal.ZERO);
					assessRoleCountDataVo.setIncomeReachDemotion(BigDecimal.ZERO);
					assessRoleCountDataVo.setTeamIncomeReach(BigDecimal.ZERO);
					assessRoleCountDataVo.setTeamIncomeReachDemotion(BigDecimal.ZERO);
				}
				 
				//角色配置
				String roleId = assessRoleCountDataVo.getRoleId();
				if(StringUtil.isNotEmpty(roleId) && roleConfigMap.containsKey(roleId)){
					ErpZxRoleConfig erpZxRoleConfig = roleConfigMap.get(roleId);
					assessRoleCountDataVo.setIncomeAim(BigDecimal.valueOf(Optional.ofNullable(erpZxRoleConfig.getuPersonalAchievement()).orElse(0)));
					assessRoleCountDataVo.setTeamIncomeAim(BigDecimal.valueOf(Optional.ofNullable(erpZxRoleConfig.getuTeamAchievement()).orElse(0)));
					assessRoleCountDataVo.setTeamPeopleAim(Optional.ofNullable(erpZxRoleConfig.getuTeamMembers()).orElse(0));
					assessRoleCountDataVo.setIncomeAimDemotion(BigDecimal.valueOf(Optional.ofNullable(erpZxRoleConfig.getdPersonalAchievement()).orElse(0)));
					assessRoleCountDataVo.setTeamIncomeAimDemotion(BigDecimal.valueOf(Optional.ofNullable(erpZxRoleConfig.getdTeamAchievement()).orElse(0)));
					assessRoleCountDataVo.setTeamPeopleAimDemotion(Optional.ofNullable(erpZxRoleConfig.getdTeamMembers()).orElse(0));
				}else{
					assessRoleCountDataVo.setIncomeAim(BigDecimal.ZERO);
					assessRoleCountDataVo.setTeamIncomeAim(BigDecimal.ZERO);
					assessRoleCountDataVo.setTeamPeopleAim(0);
					assessRoleCountDataVo.setIncomeAimDemotion(BigDecimal.ZERO);
					assessRoleCountDataVo.setTeamIncomeAimDemotion(BigDecimal.ZERO);
					assessRoleCountDataVo.setTeamPeopleAimDemotion(0);
				}
				if(StringUtil.isNotEmpty(roleId) && roleNameMap.containsKey(roleId)){
					ErpCompRoles compRoles = roleNameMap.get(roleId);
					assessRoleCountDataVo.setRoleName(compRoles.getRoleName());
				}
				
				//团队leader
				Integer recommendUserId = assessRoleCountDataVo.getRecommendUserId();
				if(recommendUserId != null && treamLreaderNameMap.containsKey(recommendUserId)){
					ErpFunUsers erpFunUsers = treamLreaderNameMap.get(recommendUserId);
					if(StringUtil.isNotBlank(erpFunUsers.getUserName())){
						assessRoleCountDataVo.setRecommendUserName(erpFunUsers.getUserName());
					}else{
						assessRoleCountDataVo.setRecommendUserName("无");
					}
				}else{
					assessRoleCountDataVo.setRecommendUserName("无");
				}
				if(examineLoMap.containsKey(userId)){
					ErpUserRoleExamineLog erpUserRoleExamineLog = examineLoMap.get(userId);
					
					if("1".equals(erpUserRoleExamineLog.getExamineResult().toString())){
						assessRoleCountDataVo.setRoleResultStr("达成");
					}else{
						assessRoleCountDataVo.setRoleResultStr("降级");
					}
				}else{
					assessRoleCountDataVo.setRoleResultStr("保级");
				}
				//直接计算三个的差距
				assessRoleCountDataVo.setIncomeGap(assessRoleCountDataVo.getIncomeAim().subtract(assessRoleCountDataVo.getIncomeReach()));
				assessRoleCountDataVo.setTeamIncomeGap(assessRoleCountDataVo.getTeamIncomeAim().subtract(assessRoleCountDataVo.getTeamIncomeReach()));
				assessRoleCountDataVo.setTeamPeopleGap(assessRoleCountDataVo.getTeamPeopleAim() - assessRoleCountDataVo.getTeamPeopleReach());
				assessRoleCountDataVo.setTeamPeopleAimDemotion(assessRoleCountDataVo.getTeamPeopleReach());
			}
		}
		
		AssessRoleCountDataListVo assessRoleCountDataListVo =new AssessRoleCountDataListVo(); 
		assessRoleCountDataListVo.setAssessRoleCountDataList(assessRoleCountDataVos);
		ErpResponseJson erpResponseJson = ErpResponseJson.ok(new PageInfo<>(assessRoleCountDataVos));
		erpResponseJson.setData(assessRoleCountDataListVo);
		return erpResponseJson;
	}
	
	/**
	 * 根据提成标准计算出提成金额
	 * 通提的计算方式
	 * @Package com.myfun.erpWeb.managecenter.profit 
	 * @author 陈文超   
	 * @date 2019年9月3日 下午8:37:36
	 */
	private BigDecimal getMatchComminsionAndBonus(BigDecimal profitValue, List<ErpFunCountwage> erpFunCountwages,Integer cityId,Integer compId) {
		//房基地 业绩展示以3100%展示，计算的时候要减去公司的提成在计算
		String compProportion = erpSysParaMapper.getParamValue(cityId, compId, "SIPHON_TOTAL_PERFORMANCE_PERCENTAGE"); 
		if(StringUtil.isNotEmpty(compProportion)){
			profitValue = profitValue.subtract(profitValue.multiply(new BigDecimal(compProportion)).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP));
		}
		ErpFunCountwage result = null;
		for (ErpFunCountwage erpFunCountwage : erpFunCountwages) {
			BigDecimal minValue = erpFunCountwage.getMinValue();
			BigDecimal maxValue = erpFunCountwage.getMaxValue();
			if(null != maxValue) {
				if(profitValue.doubleValue() > minValue.doubleValue() && maxValue.doubleValue() >= profitValue.doubleValue()) {
					result = erpFunCountwage;
					break;
				}
			}else {
				if(profitValue.doubleValue() > minValue.doubleValue()) {
					result = erpFunCountwage;
					break;
				}
			}
		}
		if(result == null){
			return BigDecimal.ZERO;
		}
		return profitValue.multiply(new BigDecimal(result.getPro())).divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_EVEN);
	}
	
	/**
	 * 阶梯提成计算方法
	 * @Package com.myfun.erpWeb.managecenter.profit 
	 * @author 陈文超   
	 * @date 2019年9月6日 下午4:57:17
	 */
	private BigDecimal getSubsectionMathIncome(BigDecimal profitValue, List<ErpFunCountwage> erpFunCountwages,Integer cityId,Integer compId){
		// 总分成金额（已经计算过的）
		// 当前实收总额
		// 阶梯计算,拿总实收取算
		//房基地 业绩展示以100%展示，计算的时候要减去公司的提成在计算
		String compProportion = erpSysParaMapper.getParamValue(cityId, compId, "SIPHON_TOTAL_PERFORMANCE_PERCENTAGE"); 
		if(StringUtil.isNotEmpty(compProportion)){
			profitValue = profitValue.subtract(profitValue.multiply(new BigDecimal(compProportion)).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP));
		}
		
		BigDecimal currentIncomeAmount = profitValue;
		BigDecimal currentDivideAmount = BigDecimal.ZERO;
		for (ErpFunCountwage erpFunCountwage : erpFunCountwages) {
			// 可能计算完了
			if(currentIncomeAmount.doubleValue() > 0) {
				// 可能第一个就是开区间
				if(null == erpFunCountwage.getMaxValue()) {
					BigDecimal div = currentIncomeAmount.multiply(new BigDecimal(erpFunCountwage.getPro())).divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_EVEN);
					currentDivideAmount = currentDivideAmount.add(div);
					break;
				}else {
					BigDecimal subtract = erpFunCountwage.getMaxValue().subtract(erpFunCountwage.getMinValue());
					if(null != erpFunCountwage.getMinValue() && erpFunCountwage.getMinValue().intValue() != 0) {
						subtract = subtract.add(BigDecimal.ONE);
					}
					if(currentIncomeAmount.doubleValue() < subtract.doubleValue() ) {
						subtract = currentIncomeAmount;
					}
					// 减去区间金额
					currentIncomeAmount = currentIncomeAmount.subtract(subtract);
					BigDecimal div = subtract.multiply(new BigDecimal(erpFunCountwage.getPro()).divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_EVEN));
					currentDivideAmount = currentDivideAmount.add(div);
				}
			}
		}
		return currentDivideAmount;
	}
	
	/**
	 * 组装个人战绩详细数据
	 * @Package com.myfun.erpWeb.managecenter.profit 
	 * @author 陈文超   
	 * @date 2019年9月5日 下午3:26:29
	 */
	private <T> List<ProfitDistributionVo> mixPersonProfitData(Byte dataType, List<T> listDataObj, 
											Map<Integer, ErpFunUsers> archiveIdMap, 
											Map<Integer, ErpFunDeal> dealIdMap, 
											Map<Integer, ErpFunProfit> profitIdMap,
											Map<String, ErpCompRoles> compRoleMap,
											ErpZxRoleConfig erpZxRoleConfig,
											Map<Integer, ErpFunPerformanceType> funperforTypeMap,
											Map<Integer, Integer> profitDynamicMappingShareProfitDynamic,Integer cityId,Integer compId ){
		List<ProfitDistributionVo> result = new ArrayList<ProfitDistributionVo>();
		for(T value : listDataObj){
			Integer dealId = null;
			Integer profitId = null;
			Integer archiveId = null;
			Integer dataId = null;
			String dataStr = null;
			Byte performanceType = null;
			
			//查询直接和间接培育业绩提成比例
			BigDecimal directRoyalty = BigDecimal.ZERO;
			BigDecimal indirectRoyalty = BigDecimal.ZERO;
			
			
			//房基地 业绩展示以3100%展示，计算的时候要减去公司的提成在计算
			String compProportion = erpSysParaMapper.getParamValue(cityId, compId, "SIPHON_TOTAL_PERFORMANCE_PERCENTAGE"); 
			
			if(erpZxRoleConfig != null){
				if(erpZxRoleConfig.getDirectRoyalty() != null){
					directRoyalty = erpZxRoleConfig.getDirectRoyalty();
					if(StringUtil.isNotEmpty(compProportion)){
						directRoyalty = directRoyalty.subtract(directRoyalty.multiply(new BigDecimal(compProportion)).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP));
					}
				}
				if(erpZxRoleConfig.getIndirectRoyalty() != null){
					indirectRoyalty = erpZxRoleConfig.getIndirectRoyalty();
					if(StringUtil.isNotEmpty(compProportion)){
						indirectRoyalty = indirectRoyalty.subtract(indirectRoyalty.multiply(new BigDecimal(compProportion)).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP));
					}
				}
			}
			
			BigDecimal divideProfit = BigDecimal.ZERO;
			if(value instanceof ErpFunProfitDynamicDetail){
				ErpFunProfitDynamicDetail tmp = (ErpFunProfitDynamicDetail) value;
				dealId = tmp.getDealId();
				profitId = tmp.getProfitId();
				archiveId = tmp.getArchiveId();
				divideProfit = tmp.getIncomeAmount();
				dataId = tmp.getId();
				dataStr = "d";
				//这里注意区分type和id，命名是id实际用的是业绩类别（1=过户 2=二手房佣金 3=新房佣金 4=租赁租金 5=金融 。。。。）
				performanceType = tmp.getPerformanceId().byteValue();
			}else if(value instanceof ErpFunProfitDynamicShareDetail){
				ErpFunProfitDynamicShareDetail tmp = (ErpFunProfitDynamicShareDetail) value;
				dealId = tmp.getDealId();
				//直接和间接培育的业绩ID，需要找到主业绩数据才能找到业绩ID，看FUN_PROFIT_DYNAMIC_DETAIL 和 FUN_PROFIT_DYNAMIC_SHARE_DETAIL的 profit_id关系
				profitId = profitDynamicMappingShareProfitDynamic.get(tmp.getProfitId());
				archiveId = tmp.getArchiveId();
				divideProfit = tmp.getIncomeAmount();
				dataId = tmp.getId();
				dataStr = "ds";
				performanceType = tmp.getPerformanceId().byteValue();
			}
			
			ProfitDistributionVo tmpResult = new ProfitDistributionVo();
			tmpResult.setCountDataId(dataId);
			tmpResult.setCountDataStr(dataStr);
			tmpResult.setDataType(dataType);
			tmpResult.setPerformanceType(performanceType);
			ErpFunDeal tmpDeal = dealIdMap.get(dealId);
			if(tmpDeal != null){
				tmpResult.setDealNo(tmpDeal.getContractNo());
                tmpResult.setBuildName(tmpDeal.getBuildName());
				tmpResult.setHouseAddr(tmpDeal.getHouseaddress());
				//应收业绩
				tmpResult.setCommissionMoney(tmpDeal.getTotalNeedPerformance());
			}
			
			//组装业绩信息
			ErpFunProfit tmpProfit = profitIdMap.get(profitId);
			if(tmpProfit != null){
				ErpFunPerformanceType tmpFunPerObj = funperforTypeMap.get(tmpProfit.getPerformanceId());
				if(tmpFunPerObj != null){
					tmpResult.setProfitSource(tmpFunPerObj.getAlias());
				}
			}
			
			//业绩所属人就是当前人，个人业绩的不展示业绩所属人
			if(dataType != 1){
				String userName = null;
				String roleName = null;
				String roleId = null;
				ErpFunUsers userBean = archiveIdMap.get(archiveId);
				if(userBean != null){
					roleId = userBean.getUserPosition();
					userName = userBean.getUserName();
					ErpCompRoles compRole = compRoleMap.get(roleId);
					if(compRole != null){
						roleName = compRole.getRoleName();
					}
				}
				if(roleName != null && userName != null){
					tmpResult.setDivideUserName(userName + "(" + roleName + ")");
				}
			}
			String signDate = null;
			String dealVerifyTime = null;
			if(!StringUtil.isBlank(tmpDeal.getSignDate())){
				signDate = DateTimeHelper.formatDateTimetoString(tmpDeal.getSignDate(), "yyyy-MM-dd");
			}
			if(!StringUtil.isBlank(tmpDeal.getDealVerifyTime())){
				dealVerifyTime = DateTimeHelper.formatDateTimetoString(tmpDeal.getDealVerifyTime(), "yyyy-MM-dd");
			}
			tmpResult.setSignDate(signDate);
			tmpResult.setOverDate(dealVerifyTime);
			//分成业绩和提成金额
			tmpResult.setDivideProfit(divideProfit);
			tmpResult.setContributionProfit(divideProfit);//贡献业绩 和 分成业绩 是同一个数据，只是直接和间接培育人展示的不一样
			if(dataType == 2){
				tmpResult.setIncomeProfit(NumberHelper.formatNumber(tmpResult.getDivideProfit().multiply(directRoyalty).divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_EVEN).doubleValue(), NumberHelper.NUMBER_IN_2));
			}else if(dataType == 3){
				tmpResult.setIncomeProfit(NumberHelper.formatNumber(tmpResult.getDivideProfit().multiply(indirectRoyalty).divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_EVEN).doubleValue(), NumberHelper.NUMBER_IN_2));
			}else if(dataType == 1){
				//个人提成专用默认值，由于与直接培育和间接培育提成计算的方式不一样
				//个人业绩部分-通提才展示数据，阶梯提成用"-"代替
				tmpResult.setIncomeProfit(NumberHelper.formatNumber(tmpResult.getDivideProfit().doubleValue(), NumberHelper.NUMBER_IN_2));
			}
			result.add(tmpResult);
		}
		return result;
	}
	
	/**
	 * 个人战绩-组装考核统计数据
	 * 该方法由：getAssessCountData调用
	 * 
	 * countType
	 * 个人战绩的数据类型
	 *	1、统计应收数据-签约月-SIGN_VALUE
	 *	2、统计实收数据-实收月-INCOME_VALUE
	 *	3、结盘实收数据-结算月-SETTLEMENT_VALUE
	 * 
	 * @Package com.myfun.erpWeb.managecenter.profit 
	 * @author 陈文超   
	 * @param <T>
	 * @date 2019年9月3日 下午5:26:12
	 */
	private void mixAssessCountData(AssessCountDataVo resultVo, Map<String, List<ErpLeaderAssessCountDataDto>> mapDataObj){
		Integer userId = resultVo.getUserId();
		//mapDataObj一定不会为null
		List<ErpLeaderAssessCountDataDto> listObj = mapDataObj.get(userId.toString());
		if(listObj != null && !listObj.isEmpty()){
			for(ErpLeaderAssessCountDataDto tmp : listObj){
				BigDecimal tmpValue = BigDecimal.valueOf(0);
				String tmpCountType = null;
				boolean isDirect = false;//是否是直接培育人业绩提成
				ErpLeaderAssessCountDataDto value = (ErpLeaderAssessCountDataDto) tmp;
				tmpValue = value.getSumIncomeAmount();
				tmpCountType = value.getCountType();
				//0为直接培育人、1为直接推荐人，这两种情况都算直接培育的业绩，这里将0和1进行了合并统计为：1
				//2为间接培育人
				isDirect = value.getUpLeaderType().byteValue() == 1;
				//是否是直接和间接培育人业绩统计数据
				if(isDirect){
					if("SIGN_VALUE".equals(tmpCountType)){
						resultVo.setDirectTheoryProfit(tmpValue);
					}else if("INCOME_VALUE".equals(tmpCountType)){
						resultVo.setDirectEnterPaid(tmpValue);
					}else if("SETTLEMENT_VALUE".equals(tmpCountType)){
						resultVo.setDirectOverPaid(tmpValue);
					}	
				}else{
					if("SIGN_VALUE".equals(tmpCountType)){
						resultVo.setIndirectTheoryProfit(tmpValue);
					}else if("INCOME_VALUE".equals(tmpCountType)){
						resultVo.setIndirectEnterPaid(tmpValue);
					}else if("SETTLEMENT_VALUE".equals(tmpCountType)){
						resultVo.setIndirectOverPaid(tmpValue);
					}
				}
			}
		}
	}
	
	/**
	 * 根据月份获取角色的分润配置
	 * 每个月都需要单独保存
	 * 
	 * monthStr:格式2019-01
	 * @Package com.myfun.erpWeb.managecenter.profit 
	 * @author 陈文超   
	 * @date 2019年9月8日 下午4:35:04
	 */
	private Map<String, ErpZxRoleConfig> getErpZxRoleConfigData(Integer cityId, Integer compId, String monthStr, String roleId){
		String currMonth = DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy-MM");
		Map<String, ErpZxRoleConfig> result = new HashMap<>();
		//如果查询月份为null，则查询最新当前数据
		if(monthStr == null || currMonth.equals(monthStr)){
			//查询当前用户角色的直接和间接分润配置
			ErpZxRoleConfigExample zxRoleExample = new ErpZxRoleConfigExample();
			zxRoleExample.setShardCityId(cityId);
			if(!StringUtil.isBlank(roleId)){
				zxRoleExample.createCriteria().andCompIdEqualTo(compId).andRoleIdEqualTo(roleId);
			}else{
				zxRoleExample.createCriteria().andCompIdEqualTo(compId);
			}
			List<ErpZxRoleConfig> erpZxRoleConfigList = erpZxRoleConfigMapper.selectByExample(zxRoleExample);
			result = erpZxRoleConfigList.stream().collect(Collectors.toMap(ErpZxRoleConfig::getRoleId, val -> val));
		}else{
			//历史的分润配置
			//查询当前用户角色的直接和间接分润配置
			ErpZxRoleConfigHisExample zxRoleHisExample = new ErpZxRoleConfigHisExample();
			zxRoleHisExample.setShardCityId(cityId);
			if(!StringUtil.isBlank(roleId)){
				zxRoleHisExample.createCriteria().andCompIdEqualTo(compId).andMonthStrEqualTo(monthStr).andRoleIdEqualTo(roleId);
			}else{
				zxRoleHisExample.createCriteria().andCompIdEqualTo(compId).andMonthStrEqualTo(monthStr);
			}
			List<ErpZxRoleConfigHis> erpZxRoleConfigList = erpZxRoleConfigHisMapper.selectByExample(zxRoleHisExample);
			for(ErpZxRoleConfigHis tmp : erpZxRoleConfigList){
				ErpZxRoleConfig roleConfig = new ErpZxRoleConfig();
				BeanUtils.copyProperties(tmp, roleConfig);
				roleConfig.setConfigId(null);//避免主键使用错误
				result.put(tmp.getdRoleId(), roleConfig);
			}
		}
		return result;
	}
	
	/**
	 * 获取个人战绩和战绩考核的用户查询条件
	 * @Package com.myfun.erpWeb.managecenter.profit 
	 * @author 陈文超   
	 * @date 2019年9月9日 下午8:55:30
	 */
	private List<AssessRoleCountDataVo> getUserQueryCondition(Integer cityId, AssessCountDataParam param){
		//移动端的查询
		if("1".equals(param.getQueryType().toString())){ //按员工
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
			if(param.getUserId() != null){
				return erpFunUsersMapper.getUserTeamList(cityId, param.getUserId(), param);
			}else{
				//员工类型的查询全部
				return erpFunUsersMapper.getUserTeamList(cityId, null, param);
			}
		}else if("2".equals(param.getQueryType().toString()) //下级团队
				|| "3".equals(param.getQueryType().toString())){ //团队
			if(param.getUserId() != null){
				if("3".equals(param.getQueryRange().toString())){ //团队
					ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, param.getUserId());
					param.setUserLevel(erpFunUsers.getUserLevel() + 2);
				}
			}
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
			return erpFunUsersMapper.getUserTeamList(cityId, null, param);
		}else{
			return new ArrayList<>();
		}
	}
	
	/**
	 * 将邀请人和直接培育人重复的记录去掉
	 * 
	 * 计算业绩时候，如果邀请人和直接培育人是同一个人，则只选择其一
	 * @Package com.myfun.erpWeb.managecenter.profit 
	 * @author 陈文超   
	 * @date 2019年9月16日 下午1:53:42
	 */
	private void processPfofitData(List<ErpFunProfitDynamicShareDetail> sourceObjList){
		//筛选出邀请人的业绩数据
		List<ErpFunProfitDynamicShareDetail> inviteList = new ArrayList<>();
		//直接培育人的业绩数据
		List<ErpFunProfitDynamicShareDetail> leaderList = new ArrayList<>();
		//需要移除的数据
		List<ErpFunProfitDynamicShareDetail> needRemoveData = new ArrayList<>();
		
		for(ErpFunProfitDynamicShareDetail tmp : sourceObjList){
			if(tmp.getUpLeaderType() == 0){//直接培育人
				leaderList.add(tmp);
			}
			if(tmp.getUpLeaderType() == 1){//邀请人
				inviteList.add(tmp);
			}
		}
		
		//邀请人和直接培育人相同的数据，以邀请人的数据为主，移除直接培育人
		for(ErpFunProfitDynamicShareDetail tmp1 : inviteList){
			for(ErpFunProfitDynamicShareDetail tmp2 : leaderList){
				//这里重写了ErpFunProfitDynamicShareDetail的equals方法，具体点进去看
				if(tmp1.equals(tmp2)){
					needRemoveData.add(tmp2);
				}
			}
		}
		
		if(!needRemoveData.isEmpty()){
			sourceObjList.removeAll(needRemoveData);
		}
	}

	/**
	 * 判断该返回哪种提示
	 * @return
	 */																		//自动升级条件 0满足所有勾选 1.满足勾选的任何一条
	private String judgeTip(FluctuantDetailVo result, String uRoleName,Byte uConditionFalg) {
		Integer flag = 0;
		String tip = "";
		Integer choose  = result.getPersonProfitShow() + result.getTeamProfitShow() + result.getTeamPeopleShow();
		if(result.getPersonProfitShow() == 1){
			if (result.getPersonProfit().compareTo(result.getPersonProfitAim()) >= 0) {//个人业绩
				flag++;
			} else {
				tip = "个人业绩还差" + result.getPersonProfitAim().subtract(result.getPersonProfit()) + "元就可升级到" + uRoleName + "了";
			}
		}
		if(result.getTeamProfitShow() == 1){
			if (result.getTeamProfit().compareTo(result.getTeamProfitAim()) >= 0) {//团队业绩
				flag++;
			} else {
				tip = "团队业绩还差" + result.getTeamProfitAim().subtract(result.getTeamProfit()) + "元就可升级到" + uRoleName + "了";
			}
		}
		if(result.getTeamPeopleShow() == 1){
			if (result.getTeamPeople().compareTo(result.getTeamPeopleAim()) >= 0) {//团队人数
				flag++;
			} else {
				tip = "再邀请" + (result.getTeamPeopleAim() - result.getTeamPeople()) + "人就可升级到" + uRoleName + "了";
			}
		}
		if(uConditionFalg == 0){
			if(choose == flag){
				return "恭喜您已完成本职级考核！";
			}else if(choose - flag > 1){
				return "再接再厉！离升级" + uRoleName + "还有的拼哟！";
			}else if (choose - flag == 1){
				return tip;
			}else{
				return "该职级未配置升级规则";
			}
		}else{
			if(flag > 0){
				return "恭喜您已完成本职级考核！";
			}else if (choose ==1  && flag == 0) {
				return tip;
			}else if (choose > 1 && flag == 0){
				return "再接再厉！离升级" + uRoleName + "还有的拼哟！";
			}else{
				return "该职级未配置升级规则";
			}
		}

	}
}
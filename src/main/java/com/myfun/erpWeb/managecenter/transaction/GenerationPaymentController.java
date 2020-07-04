package com.myfun.erpWeb.managecenter.transaction;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.profit.vo.PaymentModuleDetailListVo;
import com.myfun.erpWeb.managecenter.transaction.param.PaymentModuleDetailListParam;
import com.myfun.erpWeb.statisticalAnalysis.param.GetSelectNmaesParam;
import com.myfun.erpWeb.statisticalAnalysis.param.GetSelectWhereParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.ErpFunGenerationPaymentDto;
import com.myfun.repository.erpdb.dto.ErpFunRewardPunishmentDto;
import com.myfun.repository.erpdb.param.ErpFunGenerationPaymentClassParam;
import com.myfun.repository.erpdb.param.ErpFunGenerationPaymentParam;
import com.myfun.repository.erpdb.param.ErpFunRewardPunishmentClassParam;
import com.myfun.repository.erpdb.param.ErpFunRewardPunishmentParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.service.business.erpdb.ErpFunGenerationPaymentClassService;
import com.myfun.service.business.erpdb.ErpFunGenerationPaymentService;
import com.myfun.service.business.erpdb.ErpFunOrganizationService;
import com.myfun.service.business.erpdb.ErpFunRewardPunishmentClassService;
import com.myfun.service.business.erpdb.ErpFunRewardPunishmentService;
import com.myfun.utils.DateUtil;
import com.myfun.utils.StringUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Title 代缴管理
 * @Author lcb
 * @Date 2017/12/26
 * @Param
 **/

@Controller
@RequestMapping("/managerCenter/transaction/generationPaymentModule")
public class GenerationPaymentController extends BaseController {

	@Autowired
	ErpFunGenerationPaymentMapper erpFunGenerationPaymentMapper;
	@Autowired
	ErpFunGenerationPaymentService erpFunGenerationPaymentService;
	@Autowired
	ErpFunGenerationPaymentClassService erpFunGenerationPaymentClassService;
	@Autowired
	ErpFunGenerationPaymentClassMapper erpFunGenerationPaymentClassMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpFunOrganizationService erpFunOrganizationService;

	/**
	 * @Title 代扣款列表(营销版)
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param compId 公司Id
	 * @Param areaId 大区Id
	 * @Param regId 片区Id
	 * @Param deptId 门店Id
	 * @Param grId 分组Id
	 * @Param userId 被奖罚人
	 * @Param rewardPunishmentType 奖罚类型 1奖励2罚款
	 * @Param rewardPunishmentClass 奖罚分类
	 * @Param occStartTime 奖罚时间1
	 * @Param occEndTime 奖罚时间2
	 * @Param updateStartTime 更新时间1
	 * @Param updateEndTime 更新时间2
	 * @Param auditStartTime 审核时间1
	 * @Param auditEndTime 审核时间2
	 * @Param auditEndTime 审核时间2
	 * @Param auditStatus 审核状态 1：已审核 0 未审核
	 **/
	@ApiOperation(value = "代扣款列表",httpMethod = "POST")
	@ApiResponses({@ApiResponse(code = 200,response = PaymentModuleDetailListVo.class,message = "success")})
	@RequestMapping("/getPaymentModuleDetailList")
	@ResponseBody
	public ErpResponseJson getPaymentModuleDetailList(@RequestBody PaymentModuleDetailListParam param) {
		Operator operator = getOperator();

		param.setNewOrganization(operator.newOrganizationType());
		param.setCompId(operator.getCompId());
		String startTime = param.getStartTime();
		String endTime = param.getEndTime();
		if(StringUtils.isNotBlank(startTime) && StringUtils.isNotBlank(endTime)) {
			startTime = startTime + " 00:00:00";
			endTime = endTime + " 23:59:59";
			param.setStartTimeDate(DateUtil.StringToDate(startTime));
			param.setEndTimeDate(DateUtil.StringToDate(endTime));
		}


		if(param.getIsExport() == 0) {
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.getNeedCoun());
		}
		//param.setCompId(operator.getCompId());
		List<ErpFunGenerationPaymentDto> erpFunGenerationPaymentDtoList = null;
		if(operator.newOrganizationType()) {
			if(null != param.getOrganizationId() && 0 == param.getOrganizationId()) {
				param.setOrganizationId(null);
			}
			erpFunGenerationPaymentDtoList = erpFunGenerationPaymentMapper.getGenerationPaymentListNewOrg(operator.getCityId(), param);
		} else {
			erpFunGenerationPaymentDtoList = erpFunGenerationPaymentMapper.getGenerationPaymentList(operator.getCityId(), param);
		}

		if(erpFunGenerationPaymentDtoList.size() > 0) {
			Set<Integer> classIdSet = erpFunGenerationPaymentDtoList.stream().collect(Collectors.mapping(ErpFunGenerationPaymentDto::getGenerationPaymentClass, Collectors.toSet()));
			ErpFunGenerationPaymentClassExample erpFunGenerationPaymentClassExample = new ErpFunGenerationPaymentClassExample();
			erpFunGenerationPaymentClassExample.setShardCityId(operator.getCityId());
			erpFunGenerationPaymentClassExample.createCriteria().andIdIn(new ArrayList<>(classIdSet));
			List<ErpFunGenerationPaymentClass> erpFunRewardPunishmentClasses = erpFunGenerationPaymentClassMapper.selectByExample(erpFunGenerationPaymentClassExample);
			if(erpFunRewardPunishmentClasses.size() > 0) {
				Map<Integer, ErpFunGenerationPaymentClass> erpFunRewardPunishmentClassMap = erpFunRewardPunishmentClasses.stream().collect(Collectors.toMap(ErpFunGenerationPaymentClass::getId, val -> val));
				for (ErpFunGenerationPaymentDto erpFunGenerationPaymentDto : erpFunGenerationPaymentDtoList) {
					ErpFunGenerationPaymentClass erpFunGenerationPaymentClass = erpFunRewardPunishmentClassMap.get(erpFunGenerationPaymentDto.getGenerationPaymentClass());
					erpFunGenerationPaymentDto.setClassName(erpFunGenerationPaymentClass.getClassName());
				}
			}
			// dyh 增加返回 archiveId IM需要
			Set<Integer> auditUserIds = erpFunGenerationPaymentDtoList.stream().collect(Collectors.mapping(val -> val.getAuditUid(), Collectors.toSet()));
			Set<Integer> userIds = erpFunGenerationPaymentDtoList.stream().collect(Collectors.mapping(val -> val.getUserId(), Collectors.toSet()));
			userIds.addAll(auditUserIds);
			List<ErpFunUsers> usersList = erpFunUsersMapper.getUserListByUserIds(operator.getCityId(), userIds);
			Map<Integer, Integer> archiveIdMap = usersList.stream().collect(Collectors.toMap(user -> user.getUserId(), user -> user.getArchiveId()));
			erpFunGenerationPaymentDtoList.forEach(funGenerationPaymentDto -> {
				funGenerationPaymentDto.setArchiveId(archiveIdMap.get(funGenerationPaymentDto.getUserId()));
				funGenerationPaymentDto.setAuditArchiveId(archiveIdMap.get(funGenerationPaymentDto.getAuditUid()));
			});
			Map<Integer, Integer> orgIdMap = usersList.stream().collect(Collectors.toMap(user -> user.getUserId(), user -> user.getOrganizationId()));
			erpFunGenerationPaymentDtoList.forEach(funGenerationPaymentDto -> {
				funGenerationPaymentDto.setOrganizationId(orgIdMap.get(funGenerationPaymentDto.getUserId()));
			});
		}
		return ErpResponseJson.ok(new PageInfo<>(erpFunGenerationPaymentDtoList));
	}
	
	/**
	 * @Title 奖罚列表(Link版)
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param compId 公司Id
	 * @Param areaId 大区Id
	 * @Param regId 片区Id
	 * @Param deptId 门店Id
	 * @Param grId 分组Id
	 * @Param userId 被奖罚人
	 * @Param rewardPunishmentType 奖罚类型 1奖励2罚款
	 * @Param rewardPunishmentClass 奖罚分类
	 * @Param occStartTime 奖罚时间1
	 * @Param occEndTime 奖罚时间2
	 * @Param updateStartTime 更新时间1
	 * @Param updateEndTime 更新时间2
	 * @Param auditStartTime 审核时间1
	 * @Param auditEndTime 审核时间2
	 * @Param auditEndTime 审核时间2
	 * @Param auditStatus 审核状态 1：已审核 0 未审核
	 **/
	@RequestMapping("/getDetailList")
	@ResponseBody
	public ErpResponseJson getDetailList(@Valid @RequestBody PaymentModuleDetailListParam param) {
		Operator operator = getOperator();

		param.setCompId(operator.getCompId());
		String startTime = param.getStartTime();
		String endTime = param.getEndTime();
		if(StringUtils.isNotBlank(startTime) && StringUtils.isNotBlank(endTime)) {
			startTime = startTime + " 00:00:00";
			endTime = endTime + " 23:59:59";
			param.setStartTimeDate(DateUtil.StringToDate(startTime));
			param.setEndTimeDate(DateUtil.StringToDate(endTime));
		}
		
		
		if(param.getIsExport() == 0) {
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.getNeedCoun());
		}
		//param.setCompId(operator.getCompId());
		List<ErpFunGenerationPaymentDto> erpFunGenerationPaymentDtoList = null;
		if(operator.newOrganizationType()) {
			if(null != param.getOrganizationId() && 0 == param.getOrganizationId()) {
				param.setOrganizationId(null);
			}
			erpFunGenerationPaymentDtoList = erpFunGenerationPaymentMapper.getGenerationPaymentListNewOrg(operator.getCityId(), param);
		} else {
			erpFunGenerationPaymentDtoList = erpFunGenerationPaymentMapper.getGenerationPaymentList(operator.getCityId(), param);
		}
		
		if(erpFunGenerationPaymentDtoList.size() > 0) {
			Set<Integer> classIdSet = erpFunGenerationPaymentDtoList.stream().collect(Collectors.mapping(ErpFunGenerationPaymentDto::getGenerationPaymentClass, Collectors.toSet()));
			ErpFunGenerationPaymentClassExample erpFunGenerationPaymentClassExample = new ErpFunGenerationPaymentClassExample();
			erpFunGenerationPaymentClassExample.setShardCityId(operator.getCityId());
			erpFunGenerationPaymentClassExample.createCriteria().andIdIn(new ArrayList<>(classIdSet));
			List<ErpFunGenerationPaymentClass> erpFunRewardPunishmentClasses = erpFunGenerationPaymentClassMapper.selectByExample(erpFunGenerationPaymentClassExample);
			if(erpFunRewardPunishmentClasses.size() > 0) {
				Map<Integer, ErpFunGenerationPaymentClass> erpFunRewardPunishmentClassMap = erpFunRewardPunishmentClasses.stream().collect(Collectors.toMap(ErpFunGenerationPaymentClass::getId, val -> val));
				for (ErpFunGenerationPaymentDto erpFunGenerationPaymentDto : erpFunGenerationPaymentDtoList) {
					ErpFunGenerationPaymentClass erpFunGenerationPaymentClass = erpFunRewardPunishmentClassMap.get(erpFunGenerationPaymentDto.getGenerationPaymentClass());
					erpFunGenerationPaymentDto.setClassName(erpFunGenerationPaymentClass.getClassName());
				}
			}
			
		}
		
		return ErpResponseJson.ok(new PageInfo<>(erpFunGenerationPaymentDtoList));
	}

	/**
	 * @Title 录入代扣代缴
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param
	 **/
	@RequestMapping("/addGenerationPayment")
	@ResponseBody
	public ErpResponseJson addEditRewardPunishment(@Valid @RequestBody ErpFunGenerationPaymentParam erpFunGenerationPaymentParam) {
		Operator operator = getOperator();
		erpFunGenerationPaymentParam.setNewOrganization(operator.newOrganizationType());
		Integer res = erpFunGenerationPaymentService.addGenerationPayment(operator.getCityId(), operator.getCompId(), operator.getUserId(), operator.getUserName(), erpFunGenerationPaymentParam);
		return ErpResponseJson.ok(res);
	}

	/**
	 * 代扣代缴批量导入
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/17
	 */	
	@RequestMapping("/importGenerationPayment")
	@ResponseBody
	public ErpResponseJson importEditRewardPunishment(@Valid @RequestBody ErpFunGenerationPaymentParam erpFunGenerationPaymentParam) {
		Operator operator = getOperator();
		Integer res = erpFunGenerationPaymentService.importGenerationPayment(operator.getCityId(), operator.getCompId(), operator.getUserId(), erpFunGenerationPaymentParam);
		List<Map<String,Integer>> returnList = new ArrayList<>();
		Map<String,Integer> returnMap = new HashMap<>();
		returnMap.put("importCount",res);
		returnList.add(returnMap);
		return ErpResponseJson.ok(returnMap);
	}

	/**
	 * @Title 删除奖罚数据
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param
	 **/
	@RequestMapping("/delGenerationPaymentInfo")
	@ResponseBody
	public ErpResponseJson delGenerationPaymentInfo(@Valid @RequestBody ErpFunGenerationPaymentParam erpFunGenerationPaymentParam) {
		Operator operator = getOperator();
		Integer res = erpFunGenerationPaymentService.delGenerationPaymentInfo(operator.getCityId(), operator.getUserId(), erpFunGenerationPaymentParam);
		return ErpResponseJson.ok(res);
	}

	/**
	 * @Title 审核代扣代缴
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param auditStatus 1审核 2反审核
	 **/
	@RequestMapping("/auditGenerationPaymentInfo")
	@ResponseBody
	public ErpResponseJson addEditGenerationPayment(@Valid @RequestBody ErpFunGenerationPaymentParam erpFunGenerationPaymentParam) {
		Operator operator = getOperator();
		Integer res = erpFunGenerationPaymentService.auditGenerationPaymentInfo(operator.getCityId(), operator.getUserId(), erpFunGenerationPaymentParam);
		return ErpResponseJson.ok(res);
	}

	/**
	 * @Title 编辑类别
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param auditStatus 1审核 2反审核
	 **/
	@RequestMapping("/addEditGenerationPaymentClass")
	@ResponseBody
	public ErpResponseJson addEditRewardPunishmentClass(@Valid @RequestBody ErpFunGenerationPaymentClassParam erpFunRewardPunishmentClassParam) {
		Operator operator = getOperator();
		erpFunGenerationPaymentClassService.addEditGenerationPaymentClass(operator.getCityId(), operator.getCompId(), erpFunRewardPunishmentClassParam);
		return ErpResponseJson.ok();
	}

	/**
	 * @Title 删除类别
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param auditStatus 1审核 2反审核
	 **/
	@RequestMapping("/delGenerationPaymentClass")
	@ResponseBody
	public ErpResponseJson delRewardPunishmentClass(@Valid @RequestBody ErpFunGenerationPaymentClassParam erpFunGenerationPaymentClassParam) {
		Operator operator = getOperator();
		erpFunGenerationPaymentClassService.delGenerationPaymentClass(operator.getCityId(), operator.getCompId(), erpFunGenerationPaymentClassParam);
		return ErpResponseJson.ok();
	}

	/**
	 * @Title 查询类别
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param auditStatus 1审核 2反审核
	 **/
	@RequestMapping("/getGenerationPaymentClassList")
	@ResponseBody
	public ErpResponseJson getGenerationPaymentClassList(@Valid @RequestBody ErpFunGenerationPaymentClassParam erpFunGenerationPaymentClassParam) {
		Operator operator = getOperator();

		ErpFunGenerationPaymentClassExample erpFunGenerationPaymentClassExample = new ErpFunGenerationPaymentClassExample();
		erpFunGenerationPaymentClassExample.setShardCityId(operator.getCityId());
		ErpFunGenerationPaymentClassExample.Criteria criteria = erpFunGenerationPaymentClassExample.createCriteria();
		erpFunGenerationPaymentClassExample.setOrderByClause(" CLASS_SEQ desc ");
		criteria.andCompIdEqualTo(operator.getCompId()).andIsDelEqualTo((byte) 0);
		List<ErpFunGenerationPaymentClass> erpFunGenerationPaymentClasseList = erpFunGenerationPaymentClassMapper.selectByExample(erpFunGenerationPaymentClassExample);
		return ErpResponseJson.ok(erpFunGenerationPaymentClasseList);
	}

	/**
	 * @Title 代扣汇总
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param auditStatus 1审核 2反审核
	 **/
	@RequestMapping("/summaryGenerationPaymentList")
	@ResponseBody
	public ErpResponseJson summaryGenerationPaymentList(@Valid @RequestBody ErpFunGenerationPaymentParam param) {
		Operator operator = getOperator();
		param.setCompId(operator.getCompId());

		param.setNewOrganization(operator.newOrganizationType());
		if(operator.newOrganizationType()) {
			param.setDimension("ORGANIZATION");
			if(null != param.getOrganizationId()){//拼装WHERE 条件,如果不是COMP_ID就说明前端传了某个组织的ID，比如传了大区ID，就把这个大区的组织查出来把NAME拿出来拼装成WHERE条件
				GetSelectWhereParam getSelectWhereParam = new GetSelectWhereParam();
				getSelectWhereParam.setCityId(operator.getCityId());
				getSelectWhereParam.setUserId(param.getUserId());
				getSelectWhereParam.setPrefix("b.");
				getSelectWhereParam.setOrganizationId(param.getOrganizationId());
				param.setRangeColumn(erpFunOrganizationService.getSelectWhereTwo(getSelectWhereParam)); //COMP_ID   /USER_ID = 12001 AND b.ORG_1 = 
				if(0 == param.getOrganizationId()){//代表查询全公司
					param.setSerchRangeId(operator.getCompId());
				} else {
					param.setSerchRangeId(param.getOrganizationId());
				}
			}
			//调用方法拼装查询SQL
			GetSelectNmaesParam selectNmaesParam = new GetSelectNmaesParam();//这里就是拼装查询数据和GROUP BY条件，前端查什么都会传一个defId，根据这个组织拿到他和他上级所有的NAME来GROUP BY
			selectNmaesParam.setCompId(operator.getCompId());
			selectNmaesParam.setCityId(operator.getCityId());
			selectNmaesParam.setDefId(param.getDefId());//285;
			String selectNames = erpFunOrganizationService.getSelectNames(selectNmaesParam); //ORG_1,ORG_2,ORG_3,ORG_4,ORG_5
			String dbField = selectNames.substring(selectNames.lastIndexOf(",") + 1,selectNames.length());//ORG_5
			param.setRangeColumn(dbField + " IS NOT NULL AND b." + param.getRangeColumn()); //ORG_5 IS NOT NULL AND b.USER_ID = 12001 AND b.ORG_1 = 
			String selectColumnStr = erpFunOrganizationService.getSelectSqlTwo(dbField,null,"b"); //b.ORG_5(convert(varchar,isnull(ORG_5,0))) as range
			param.setSelectColumnStr(selectColumnStr);
			String gropuByStr = erpFunOrganizationService.getSelectSqlTwo(selectNames,"0","b");
			param.setGroupColumn(gropuByStr);
			
			
			/*GetSelectNmaesParam getSelectNmaesParam = new GetSelectNmaesParam();
			getSelectNmaesParam.setCityId(operator.getCityId());
			getSelectNmaesParam.setDefId(param.getDefId());
			getSelectNmaesParam.setCompId(operator.getCompId());
			String groupColumn = erpFunOrganizationService.getSelectNames(getSelectNmaesParam);
			param.setGroupColumn("COMP_ID,b."+groupColumn.replaceAll("\\,", ",b."));
			
			if(StringUtil.isBlank(param.getDimension())) {
				param.setDimension("USER");
			}*/
			Long totalPage = 0L;
			if (param.getIsExport() == 0) {
				if(1 == param.getPageOffset()) {
					// 手动查询总条数
					totalPage = erpFunGenerationPaymentMapper.summaryGenerationPaymentCountNewOrg(operator.getCityId(), param);
				}
				PageHelper.startPage(param.getPageOffset(), param.getPageRows(), false);
			}

			List<Map<String, Object>> resMapList = erpFunGenerationPaymentMapper.summaryGenerationPaymentListNewOrg(operator.getCityId(), param);
			PageInfo<Map<String, Object>> mapPageInfo = new PageInfo<>(resMapList);
			if (totalPage >= 0) {
				mapPageInfo.setTotal(totalPage);
			}
			return ErpResponseJson.ok(mapPageInfo);
		}
		
		
		if(StringUtil.isBlank(param.getDimension())) {
			param.setDimension("USER");
		}
		Long totalPage = 0L;
		if (param.getIsExport() == 0) {
			if(1 == param.getPageOffset()) {
				// 手动查询总条数
				totalPage = erpFunGenerationPaymentMapper.summaryGenerationPaymentCount(operator.getCityId(), param);
			}
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), false);
		}

		List<Map<String, Object>> resMapList = erpFunGenerationPaymentMapper.summaryGenerationPaymentList(operator.getCityId(), param);
		PageInfo<Map<String, Object>> mapPageInfo = new PageInfo<>(resMapList);
		if (totalPage >= 0) {
			mapPageInfo.setTotal(totalPage);
		}
		return ErpResponseJson.ok(mapPageInfo);
	}




}

package com.myfun.erpWeb.managecenter.transaction;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.profit.vo.RewardPunishmentDetailListVo;
import com.myfun.erpWeb.managecenter.transaction.param.RewardPunishmentDetailListParam;
import com.myfun.erpWeb.statisticalAnalysis.param.GetSelectNmaesParam;
import com.myfun.erpWeb.statisticalAnalysis.param.GetSelectWhereParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.erpdb.dao.ErpFunOrganizationDefinitionMapper;
import com.myfun.repository.erpdb.dao.ErpFunOrganizationMapper;
import com.myfun.repository.erpdb.dao.ErpFunRewardPunishmentClassMapper;
import com.myfun.repository.erpdb.dao.ErpFunRewardPunishmentMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dto.ErpFunRewardPunishmentDto;
import com.myfun.repository.erpdb.param.ErpFunRewardPunishmentClassParam;
import com.myfun.repository.erpdb.param.ErpFunRewardPunishmentParam;
import com.myfun.repository.erpdb.po.ErpFunRewardPunishmentClass;
import com.myfun.repository.erpdb.po.ErpFunRewardPunishmentClassExample;
import com.myfun.repository.erpdb.po.ErpFunUsers;
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
 * @Title 奖罚管理类
 * @Author lcb
 * @Date 2017/12/26
 * @Param
 **/

@Controller
@RequestMapping("/managerCenter/transaction/rewardPunishmentModule")
public class RewardPunishmentController extends BaseController {

	@Autowired
	ErpFunRewardPunishmentMapper erpFunRewardPunishmentMapper;
	@Autowired
	ErpFunRewardPunishmentService erpFunRewardPunishmentService;
	@Autowired
	ErpFunRewardPunishmentClassService erpFunRewardPunishmentClassService;
	@Autowired
	ErpFunRewardPunishmentClassMapper erpFunRewardPunishmentClassMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpFunOrganizationMapper erpFunOrganizationMapper;
	@Autowired
	ErpFunOrganizationDefinitionMapper erpFunOrganizationDefinitionMapper;
	@Autowired
	ErpFunOrganizationService erpFunOrganizationService;

	/**
	 * @Title 奖罚列表(营销版)
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
	@ApiOperation(value = "奖罚列表(营销版)",httpMethod = "POST")
	@ApiResponses({@ApiResponse(code = 200,response = RewardPunishmentDetailListVo.class, message = "success")})
	@RequestMapping("/getRewardPunishmentDetailList")
	@ResponseBody
	public ErpResponseJson getRewardPunishmentDetailList(@Valid @RequestBody RewardPunishmentDetailListParam param) {
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
		
		if(param.getIsExport() == 0) { //是否导出，不导出就分页
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.getNeedCoun());
		}
		//--------------------------
		List<ErpFunRewardPunishmentDto> erpFunRewardPunishments = null;
		if(operator.newOrganizationType()) {
			if(null != param.getOrganizationId() && 0 == param.getOrganizationId()) {
				param.setOrganizationId(null);
			}
			erpFunRewardPunishments = erpFunRewardPunishmentMapper.getRewardPunishmentListNewOrg(operator.getCityId(), param);//all data
		}else {
			erpFunRewardPunishments = erpFunRewardPunishmentMapper.getRewardPunishmentList(operator.getCityId(), param);//all data
		}
		
		if(erpFunRewardPunishments.size() > 0) {
			Set<Integer> classIdSet = erpFunRewardPunishments.stream().collect(Collectors.mapping(ErpFunRewardPunishmentDto::getRewardPunishmentClass, Collectors.toSet()));
			ErpFunRewardPunishmentClassExample erpFunRewardPunishmentClassExample = new ErpFunRewardPunishmentClassExample();
			erpFunRewardPunishmentClassExample.setShardCityId(operator.getCityId());
			erpFunRewardPunishmentClassExample.createCriteria().andIdIn(new ArrayList<>(classIdSet));
			//业绩达标 不达标 早退
			List<ErpFunRewardPunishmentClass> erpFunRewardPunishmentClasses = erpFunRewardPunishmentClassMapper.selectByExample(erpFunRewardPunishmentClassExample);
			if(erpFunRewardPunishmentClasses.size() > 0) {
				Map<Integer, ErpFunRewardPunishmentClass> erpFunRewardPunishmentClassMap = erpFunRewardPunishmentClasses.stream().collect(Collectors.toMap(ErpFunRewardPunishmentClass::getId, val -> val));
				for (ErpFunRewardPunishmentDto erpFunRewardPunishmentDto : erpFunRewardPunishments) {
					//[2020/03/14] 李中国 前端固定了一个id为-1的形象惩罚类目，用于KPI里的形象是否达标处理 需求id#11736 PC&APP美联KPI
					if (erpFunRewardPunishmentDto.getRewardPunishmentClass() == -1){
						erpFunRewardPunishmentDto.setClassName("形象");
					} else {
						ErpFunRewardPunishmentClass erpFunRewardPunishmentClass = erpFunRewardPunishmentClassMap.get(erpFunRewardPunishmentDto.getRewardPunishmentClass());
						erpFunRewardPunishmentDto.setClassName(erpFunRewardPunishmentClass.getClassName());
					}
				}
			}
			// dyh 增加返回 archiveId IM需要
			Set<Integer> createUserIds = erpFunRewardPunishments.stream().collect(Collectors.mapping(val -> val.getCreateUid(), Collectors.toSet()));
			Set<Integer> userIds = erpFunRewardPunishments.stream().collect(Collectors.mapping(val -> val.getUserId(), Collectors.toSet()));
			userIds.addAll(createUserIds);
			if (userIds.isEmpty()) {
				return ErpResponseJson.ok(new PageInfo<>(erpFunRewardPunishments));
			}
			List<ErpFunUsers> usersList = erpFunUsersMapper.getUserListByUserIds(operator.getCityId(), userIds);
			Map<Integer, Integer> archiveIdMap = usersList.stream().collect(Collectors.toMap(user -> user.getUserId(), user -> user.getArchiveId()));
			erpFunRewardPunishments.forEach(erpFunRewardPunishmentDto -> {
				erpFunRewardPunishmentDto.setArchiveId(archiveIdMap.get(erpFunRewardPunishmentDto.getUserId()));
				erpFunRewardPunishmentDto.setCreateArchiveId(archiveIdMap.get(erpFunRewardPunishmentDto.getCreateUid()));
			});
			Map<Integer, Integer> orgIdMap = usersList.stream().collect(Collectors.toMap(user -> user.getUserId(), user -> user.getOrganizationId()));
			erpFunRewardPunishments.forEach(erpFunRewardPunishmentDto -> {
				erpFunRewardPunishmentDto.setOrganizationId(orgIdMap.get(erpFunRewardPunishmentDto.getUserId()));
			});
		}
		return ErpResponseJson.ok(new PageInfo<>(erpFunRewardPunishments));
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
	@ApiOperation(value = "奖罚列表(Link版)",httpMethod = "POST")
	@ApiResponses({@ApiResponse(code = 200,response = RewardPunishmentDetailListVo.class, message = "success")})
	@ResponseBody
	@RequestMapping("/getDetailList")
	public ErpResponseJson getDetailList(@RequestBody RewardPunishmentDetailListParam param) {
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
		
		//--------------------------
		List<ErpFunRewardPunishmentDto> erpFunRewardPunishments = null;
		if(operator.newOrganizationType()) {
			if(null != param.getOrganizationId() && 0 == param.getOrganizationId()) {
				param.setOrganizationId(null);
			}
			erpFunRewardPunishments = erpFunRewardPunishmentMapper.getRewardPunishmentListNewOrg(operator.getCityId(), param);//all data
		}else {
			erpFunRewardPunishments = erpFunRewardPunishmentMapper.getRewardPunishmentList(operator.getCityId(), param);//all data
		}

		if(erpFunRewardPunishments.size() > 0) {
			Set<Integer> classIdSet = erpFunRewardPunishments.stream().collect(Collectors.mapping(ErpFunRewardPunishmentDto::getRewardPunishmentClass, Collectors.toSet()));
			ErpFunRewardPunishmentClassExample erpFunRewardPunishmentClassExample = new ErpFunRewardPunishmentClassExample();
			erpFunRewardPunishmentClassExample.setShardCityId(operator.getCityId());
			erpFunRewardPunishmentClassExample.createCriteria().andIdIn(new ArrayList<>(classIdSet));
			List<ErpFunRewardPunishmentClass> erpFunRewardPunishmentClasses = erpFunRewardPunishmentClassMapper.selectByExample(erpFunRewardPunishmentClassExample);
			if(erpFunRewardPunishmentClasses.size() > 0) {
				Map<Integer, ErpFunRewardPunishmentClass> erpFunRewardPunishmentClassMap = erpFunRewardPunishmentClasses.stream().collect(Collectors.toMap(ErpFunRewardPunishmentClass::getId, val -> val));
				for (ErpFunRewardPunishmentDto erpFunRewardPunishmentDto : erpFunRewardPunishments) {
					ErpFunRewardPunishmentClass erpFunRewardPunishmentClass = erpFunRewardPunishmentClassMap.get(erpFunRewardPunishmentDto.getRewardPunishmentClass());
					erpFunRewardPunishmentDto.setClassName(erpFunRewardPunishmentClass.getClassName());
				}
			}

		}
		return ErpResponseJson.ok(new PageInfo<>(erpFunRewardPunishments));
	}

	/**
	 * @Title 批量录入修改数据
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param
	 **/
	@RequestMapping("/addRewardPunishment")
	@ResponseBody
	public ErpResponseJson addRewardPunishment(@Valid @RequestBody ErpFunRewardPunishmentParam erpFunRewardPunishmentParam) {
		Operator operator = getOperator();
//		erpFunRewardPunishmentParam.setAssessmentMonth(DateUtil.getAssessMentMonth(DateUtil.DateToString(erpFunRewardPunishmentParam.getOccurrenceTime()), 0));
		erpFunRewardPunishmentParam.setNewOrganization(operator.newOrganizationType());
		Integer res = erpFunRewardPunishmentService.addRewardPunishment(operator.getCityId(), operator.getCompId(), operator.getUserId(), operator.getUserName(), erpFunRewardPunishmentParam);
		return ErpResponseJson.ok(res);
	}

	/**
	 * 奖罚批量导入
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/17
	 */
	@RequestMapping("/importRewardPunishment")
	@ResponseBody
	public ErpResponseJson importRewardPunishment(@Valid @RequestBody ErpFunRewardPunishmentParam erpFunRewardPunishmentParam) {
		Operator operator = getOperator();
		Integer res =erpFunRewardPunishmentService.importRewardPunishment(operator.getCityId(), operator.getCompId(), operator.getUserId(), erpFunRewardPunishmentParam);
		List<Map<String,Integer>> returnList = new ArrayList<>();
		Map<String,Integer> returnMap = new HashMap<>();
		returnMap.put("importCount",res);
		returnList.add(returnMap);
		return ErpResponseJson.ok(returnList);
	}

	/**
	 * @Title 批量录入修改数据
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param
	 **/
	@RequestMapping("/editRewardPunishment")
	@ResponseBody
	public ErpResponseJson editRewardPunishment(@Valid @RequestBody ErpFunRewardPunishmentParam erpFunRewardPunishmentParam) {
		Operator operator = getOperator();
		Integer res = erpFunRewardPunishmentService.editRewardPunishment(operator.getCityId(), operator.getCompId(), operator.getUserId(), erpFunRewardPunishmentParam);
		return ErpResponseJson.ok(res);
	}

	/**
	 * @Title 删除奖罚数据
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param
	 **/
	@RequestMapping("/delRewardPunishmentInfo")
	@ResponseBody
	public ErpResponseJson delRewardPunishmentInfo(@Valid @RequestBody ErpFunRewardPunishmentParam erpFunRewardPunishmentParam) {
		Operator operator = getOperator();
		Integer res = erpFunRewardPunishmentService.delRewardPunishmentInfo(operator.getCityId(), operator.getUserId(), erpFunRewardPunishmentParam);
		return ErpResponseJson.ok(res);
	}

	/**
	 * @Title 审核奖罚
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param auditStatus 1审核 2反审核
	 **/
	@RequestMapping("/auditRewardPunishmentInfo")
	@ResponseBody
	public ErpResponseJson auditRewardPunishmentInfo(@Valid @RequestBody ErpFunRewardPunishmentParam erpFunRewardPunishmentParam) {
		Operator operator = getOperator();
		Integer res = erpFunRewardPunishmentService.auditRewardPunishmentInfo(operator.getCityId(), operator.getUserId(), erpFunRewardPunishmentParam);
		return ErpResponseJson.ok(res);
	}

	/**
	 * @Title 编辑类别
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param auditStatus 1审核 2反审核
	 **/
	@RequestMapping("/addEditRewardPunishmentClass")
	@ResponseBody
	public ErpResponseJson addEditRewardPunishmentClass(@Valid @RequestBody ErpFunRewardPunishmentClassParam erpFunRewardPunishmentClassParam) {
		Operator operator = getOperator();
		erpFunRewardPunishmentClassService.addEditRewardPunishmentClass(operator.getCityId(), operator.getCompId(), erpFunRewardPunishmentClassParam);
		return ErpResponseJson.ok();
	}

	/**
	 * @Title 删除类别
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param auditStatus 1审核 2反审核
	 **/
	@RequestMapping("/delRewardPunishmentClass")
	@ResponseBody
	public ErpResponseJson delRewardPunishmentClass(@Valid @RequestBody ErpFunRewardPunishmentClassParam erpFunRewardPunishmentClassParam) {
		Operator operator = getOperator();
		erpFunRewardPunishmentClassService.delRewardPunishmentClass(operator.getCityId(), operator.getCompId(), erpFunRewardPunishmentClassParam);
		return ErpResponseJson.ok();
	}

	/**
	 * @Title 查询类别
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param auditStatus 1审核 2反审核
	 **/
	@RequestMapping("/getRewardPunishmentClassList")
	@ResponseBody
	public ErpResponseJson getRewardPunishmentClassList(@Valid @RequestBody ErpFunRewardPunishmentClassParam erpFunRewardPunishmentClassParam) {
		Operator operator = getOperator();

		ErpFunRewardPunishmentClassExample erpFunRewardPunishmentClassExample = new ErpFunRewardPunishmentClassExample();
		erpFunRewardPunishmentClassExample.setShardCityId(operator.getCityId());
		ErpFunRewardPunishmentClassExample.Criteria criteria = erpFunRewardPunishmentClassExample.createCriteria();
		erpFunRewardPunishmentClassExample.setOrderByClause(" CLASS_SEQ desc ");
		criteria.andCompIdEqualTo(operator.getCompId()).andIsDelEqualTo((byte) 0);
		if(null != erpFunRewardPunishmentClassParam.getRewardPunishmentType()) {
			criteria.andRewardPunishmentTypeEqualTo(erpFunRewardPunishmentClassParam.getRewardPunishmentType());
		}
		List<ErpFunRewardPunishmentClass> erpFunRewardPunishmentClasses = erpFunRewardPunishmentClassMapper.selectByExample(erpFunRewardPunishmentClassExample);
		return ErpResponseJson.ok(erpFunRewardPunishmentClasses);
	}

	/**
	 * @Title 奖罚汇总
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param auditStatus 1审核 2反审核
	 **/
	@RequestMapping("/summaryRewardPunishmentList")
	@ResponseBody
	public ErpResponseJson summaryRewardPunishmentList(@Valid @RequestBody ErpFunRewardPunishmentParam param) {
		Operator operator = getOperator();
		
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
			
			param.setCompId(operator.getCompId());
			Long totalPage = 0L;
			if (param.getIsExport() == 0) {
				if(1 == param.getPageOffset()) {
					// 手动查询总条数
					totalPage = erpFunRewardPunishmentMapper.summaryRewardPunishmentCountNewOrg(operator.getCityId(), param);
				}
				PageHelper.startPage(param.getPageOffset(), param.getPageRows(), false);
			}

			List<Map<String, Object>> resMapList = erpFunRewardPunishmentMapper.summaryRewardPunishmentListNewOrg(operator.getCityId(), param);
			PageInfo<Map<String, Object>> mapPageInfo = new PageInfo<>(resMapList);

			if (totalPage >= 0) {
				mapPageInfo.setTotal(totalPage);
			}
			return ErpResponseJson.ok(mapPageInfo);
			
		}

		param.setCompId(operator.getCompId());
		if(StringUtil.isBlank(param.getDimension())) {
			param.setDimension("USER");
		}
		Long totalPage = 0L;
		if (param.getIsExport() == 0) {
			if(1 == param.getPageOffset()) {
				// 手动查询总条数
				totalPage = erpFunRewardPunishmentMapper.summaryRewardPunishmentCount(operator.getCityId(), param);
			}
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), false);
		}

		List<Map<String, Object>> resMapList = erpFunRewardPunishmentMapper.summaryRewardPunishmentList(operator.getCityId(), param);
		PageInfo<Map<String, Object>> mapPageInfo = new PageInfo<>(resMapList);

		if (totalPage >= 0) {
			mapPageInfo.setTotal(totalPage);
		}
		return ErpResponseJson.ok(mapPageInfo);
	}




}

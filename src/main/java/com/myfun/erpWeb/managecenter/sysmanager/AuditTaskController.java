package com.myfun.erpWeb.managecenter.sysmanager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.extension.framework.codis.util.CacheUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.deal.param.DealAuditCommonParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.GetAuditListParam;
import com.myfun.erpWeb.managecenter.sysmanager.vo.AttachmentVo;
import com.myfun.erpWeb.managecenter.sysmanager.vo.AuditDetailCommentVO;
import com.myfun.erpWeb.managecenter.sysmanager.vo.ErpAuditUserTransmitLogVO;
import com.myfun.erpWeb.managecenter.transaction.param.ProcessFinancStatusParam;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.ConfirmException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.*;
import com.myfun.repository.erpdb.param.AuditConfigParam;
import com.myfun.repository.erpdb.param.AuditParam;
import com.myfun.repository.erpdb.param.ErpOaLeaveAuditParam;
import com.myfun.repository.erpdb.param.ErpOaOutAuditParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.admindb.AdminFunCompService;
import com.myfun.service.business.erpdb.ErpAuditRuntimeService;
import com.myfun.service.business.erpdb.ErpAuditTemplateService;
import com.myfun.service.business.erpdb.ErpDicDefdinitionsService;
import com.myfun.service.business.erpdb.ErpFunTrackService;
import com.myfun.service.business.erpdb.ErpSysParaService;
import com.myfun.utils.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 审核任务相关接口
 * @author 张宏利
 * @since 2017年10月16日
 */
@RestController
@RequestMapping("/managerCenter/auditTask")
public class AuditTaskController extends BaseController {
	@Autowired ErpSysParaService erpSysParaService;
	@Autowired ErpAuditTemplateMapper erpAuditTemplateMapper;
	@Autowired ErpAuditTemplateService erpAuditTemplateService;
	@Autowired ErpAuditUserTemplateMapper erpAuditUserTemplateMapper;
	@Autowired ErpAuditRuntimeService erpAuditRuntimeService;
	@Autowired ErpAuditRuntimeMapper erpAuditRuntimeMapper;
	@Autowired ErpAuditRuntimeCaseMapper erpAuditRuntimeCaseMapper;
	@Autowired ErpFunSaleMapper erpFunSaleMapper;
	@Autowired AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired ErpAuditTrackMapper erpAuditTrackMapper;
	@Autowired ErpFunTrackService erpFunTrackService;
	@Autowired ErpAuditUserRuntimeMapper erpAuditUserRuntimeMapper;
	@Autowired ErpFunPhotoMapper erpFunPhotoMapper;
	@Autowired ErpFunEntrustmentPhotoMapper erpFunEntrustmentPhotoMapper;
	@Autowired ErpFunUsersMapper erpFunUsersMapper;
	@Autowired ErpTrackVideoMapper erpTrackVideoMapper;
	@Autowired ErpFunVideoMapper erpFunVideoMapper;
	@Autowired ErpFunTrackExtendMapper erpFunTrackExtendMapper;
	@Autowired ErpOutLogMapper erpOutLogMapper;
	@Autowired
	ErpMakeLookHouseMapper erpMakeLookHouseMapper;
	@Autowired
	ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
	@Autowired
	ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	@Autowired
	ErpProcessFinancMapper erpProcessFinancMapper;
	@Autowired
	ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	ErpDicDefdinitionsService erpDicDefdinitionsService;
	@Autowired
    ErpAuditCommentMapper erpAuditCommentMapper;
	@Autowired
    ErpAuditCommentFileMapper erpAuditCommentFileMapper;
	@Autowired
	AdminFunCompService adminFunCompService;
	@Autowired
	ErpDicDefinitionsMapper erpDicDefinitionsMapper;
	@Resource
	private ErpAuditProcessMapper erpAuditProcessMapper;
	@Autowired
	private CacheUtil cacheUtil;
	@Autowired
	private ErpSystemSettingLogsMapper erpSystemSettingLogsMapper;
	@Autowired
	private ErpFunEntrustRecordNoMapper erpFunEntrustRecordNoMapper;
	@Autowired
	private ErpAuditUserTransmitLogMapper erpAuditUserTransmitLogMapper;
	
	/**
	 * 获取业务审核流程信息
	 * @author 张宏利
	 * @since 2017年10月16日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAuditTemplate")
	public ErpResponseJson getAuditTemplate(@Valid @RequestBody BaseMapParam param) {
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		Integer caseType = param.getInteger("caseType");
		Integer auditResource = param.getInteger("auditResource", 1);
		
		List<ErpAuditTemplateDto> auditList = erpAuditTemplateMapper.getBusinessAuditTemplate(cityId, compId, caseType, auditResource);
		List<ErpAuditUserTemplate> auditUserList = null;
		Map<Integer, ErpAuditTemplateDto> auditMap = new HashMap<>(0);
		if(auditList != null && !auditList.isEmpty()) {
			Set<Integer> auditIdSet = auditList.stream().collect(Collectors.mapping(ErpAuditTemplateDto::getId, Collectors.toSet()));
			auditUserList = erpAuditUserTemplateMapper.getBusinessAuditTemplate(cityId, auditIdSet);
			auditMap = auditList.stream().collect(Collectors.toMap(ErpAuditTemplateDto::getAuditType, val -> val));
		}
		// 不同类型，有的没有
		Map<Byte, String> allAuditType = this.getAuditType(auditResource, caseType);
		// 公盘制时不要私盘移交审核流程
		if(erpSysParaService.getSysRunModelIsPublic(caseType, cityId, compId)) {
			allAuditType.remove(Const.DIC_TRACK_TYPE_PRIVATE_TRANSFER);
		}
		// 组装名字和不存在的项
		List<ErpAuditTemplateDto> resultAuditList = new LinkedList<>();
		for (Entry<Byte, String> entry : allAuditType.entrySet()) {
			ErpAuditTemplateDto erpAuditTemplate = auditMap.get(entry.getKey().intValue());
			if(erpAuditTemplate == null) {
				erpAuditTemplate = new ErpAuditTemplateDto();
				erpAuditTemplate.setAuditType(entry.getKey().intValue());
			}
			erpAuditTemplate.setAuditName(entry.getValue());
			erpAuditTemplate.setCaseType(caseType);
			erpAuditTemplate.setAuditResource(auditResource.byteValue());
			resultAuditList.add(erpAuditTemplate);
		}
		// 数据组装
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("auditList", resultAuditList);
		resultMap.put("auditUserList", auditUserList);
		return ErpResponseJson.ok(resultMap);
	}
	
	/**
	 * 保存业务审核流程信息
	 * @author 张宏利
	 * @since 2017年10月16日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/saveAuditTemplate")
	public ErpResponseJson saveAuditTemplate(@Valid @RequestBody BaseMapParam param) {
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		String templateListStr = param.getString("templateList");
		erpAuditTemplateService.saveAuditTemplate(templateListStr, cityId, compId);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 拷贝审核流程信息
	 * @author 张宏利
	 * @since 2017年11月27日
	 * @param caseType 当前房客源类型，出售拷贝到出租，caseType传出租
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/copyAuditTemplate")
	public ErpResponseJson copyAuditTemplate(@Valid @RequestBody BaseMapParam param) {
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		Integer fromCaseType = param.getInteger("fromCaseType");
		Integer toCaseType = param.getInteger("toCaseType");
		// 获取需要和拷贝项和执行拷贝
		Set<Byte> auditTypeSet = this.getAuditType(1, toCaseType).keySet();
		erpAuditTemplateMapper.copyAuditTemplate(cityId, compId, fromCaseType, toCaseType, auditTypeSet);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 拷贝OA请假审核流程信息
	 * @author 张宏利
	 * @since 2018年01月17日
	 * @param caseType 当前房客源类型，出售拷贝到出租，caseType传出租
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/copyTemplateForOaLeave")
	public ErpResponseJson copyAuditTemplateForOaLeave(@Valid @RequestBody BaseMapParam param) {
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		Integer templateId = param.getInteger("templateId");
		Byte templateAuditType = param.getByte("templateAuditType");
		Set<Byte> auditTypeSet = this.getAuditType(2, null).keySet();
		auditTypeSet.remove(templateAuditType);// 移除掉自己
		erpAuditTemplateMapper.copyAuditTemplateForOa(cityId, compId, 2, templateId, auditTypeSet);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 拷贝OA外出审核流程信息
	 * @author 张宏利
	 * @since 2018年01月17日
	 * @param caseType 当前房客源类型，出售拷贝到出租，caseType传出租
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/copyTemplateForOaOut")
	public ErpResponseJson copyAuditTemplateForOaOut(@Valid @RequestBody BaseMapParam param) {
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		Integer templateId = param.getInteger("templateId");
		Byte templateAuditType = param.getByte("templateAuditType");
		Set<Byte> auditTypeSet = this.getAuditType(3, null).keySet();
		auditTypeSet.remove(templateAuditType);// 移除掉自己
		erpAuditTemplateMapper.copyAuditTemplateForOa(cityId, compId, 3, templateId, auditTypeSet);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 为角色创建审核人，当审核状态为待审，但该角色没有审核人的情况下操作
	 * @author 张宏利
	 * @since 2017年11月14日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/createAuditUserForRole")
	public ErpResponseJson createAuditUserForRole(@RequestBody BaseMapParam param) {
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		String roleId = param.getString("roleId");
		Integer userId = param.getInteger("userId");
		
		erpAuditRuntimeService.createAuditUserForUserChange(cityId, compId, roleId, userId);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 对流程进行跟进操作
	 * @author 张宏利
	 * @since 2017年10月16日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/createAuditTrack")
	public ErpResponseJson createAuditTrack(@Valid @RequestBody BaseMapParam param) {
		Integer cityId = getOperator().getCityId();
		Integer userId = getOperator().getUserId();
		Integer auditId = param.getInteger("auditId");
		String trackContent = param.getString("trackContent");
		erpAuditRuntimeService.createAuditTrack(cityId, auditId, userId, (byte) 0, trackContent);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 对流程进行撤回操作
	 * @author 张宏利
	 * @since 2017年10月20日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/auditRevokeRuntime")
	public ErpResponseJson auditRevokeRuntime(@Valid @RequestBody BaseMapParam param) {
		Integer cityId = getOperator().getCityId();
		Integer userId = getOperator().getUserId();
		Integer auditId = param.getInteger("auditId");
		String trackContent = param.getString("trackContent");
		erpAuditRuntimeService.auditRevokeRuntime(cityId, auditId, userId, trackContent);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 对流程进行审核操作
	 * @author 张宏利
	 * @since 2017年10月16日
	 * @param param
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("/auditRuntime")
	public ErpResponseJson auditRuntime(@Valid @RequestBody BaseMapParam param) throws Exception {
		Integer cityId = getOperator().getCityId();
		Integer userId = getOperator().getUserId();
		Integer auditId = param.getInteger("auditId");
		Integer auditStatus = param.getInteger("auditStatus");
		String trackContent = param.getString("trackContent");
		String targetTimeStr = param.getString("targetTime");
		String targetNo = param.getString("targetNo");
		Integer sureToAviliable = param.getInteger("sureToAviliable");

		Date targetTime = null;
		if(StringUtils.isNotBlank(targetTimeStr)) {
			targetTime = DateTimeHelper.parseToDate(targetTimeStr);
		}

		ErpAuditRuntime erpAuditRuntimeParam = new ErpAuditRuntime();
		erpAuditRuntimeParam.setId(auditId);
		erpAuditRuntimeService.auditRuntime(cityId, erpAuditRuntimeParam, userId, auditStatus.byteValue(), trackContent,
				targetTime, targetNo, sureToAviliable);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 获取审核流程跟进列表
	 * @author 张宏利
	 * @since 2017年10月16日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAuditTrackList")
	public ErpResponseJson getAuditTrackList(@Valid @RequestBody BaseMapParam param) {
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		Integer auditId = param.getInteger("auditId");
		ErpAuditRuntime auditRuntime = erpAuditRuntimeMapper.selectById(cityId, compId, auditId);
		Assert.isNullThrow(auditRuntime, "无权查看该跟进");
		List<ErpAuditTrack> trackList = erpAuditTrackMapper.getAuditTrackList(cityId, auditId);
		return ErpResponseJson.ok(trackList);
	}
	
	/**
	 * 获取所有审核列表，系统监控使用
	 * @author 张宏利
	 * @since 2017年10月20日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAuditTaskList")
	public ErpResponseJson getAuditTaskList(@Valid @RequestBody GetAuditListParam param) {
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		//如果是美联的需求会走这一段逻辑
		if(getOperator().isMeiLianApi()){
			String record = (String)cacheUtil.get("/erpWeb/managerCenter/auditTask/getAuditTaskList"
					+ getOperator().getArchiveId()+DateTimeHelper.formatDateTimetoString(new Date(),"yyy-MM-dd"));
			if(StringUtil.isBlank(record)){
				ErpSystemSettingLogs erpSystemSettingLogs = new ErpSystemSettingLogs();
				erpSystemSettingLogs.setCompId(getOperator().getCompId().intValue());
				erpSystemSettingLogs.setShardCityId(getOperator().getCityId());
				erpSystemSettingLogs.setCreateDept(getOperator().getDeptId());
				erpSystemSettingLogs.setSslType((byte)42);
				erpSystemSettingLogs.setModular(9);
				erpSystemSettingLogs.setCreateUid(getOperator().getUserId());
				erpSystemSettingLogs.setCreateTime(DateUtil.DateToString(new Date()));
				erpSystemSettingLogs.setLogContent("查看了审核任务");
				erpSystemSettingLogsMapper.insertSelective(erpSystemSettingLogs);
				cacheUtil.put("/erpWeb/managerCenter/auditTask/getAuditTaskList"
						+ getOperator().getArchiveId()+DateTimeHelper.formatDateTimetoString(new Date(),"yyy-MM-dd"),"1",86400);
			}
		}
		//**********************组织架构改版********************************
		if (getOperator().newOrganizationType()) {       //zt组织机构
			if (null != param.getOrganizationId() && param.getOrganizationId() == 0) {
				param.setOrganizationId(null);
			}
		}
//**********************组织架构改版********************************
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());

		if(StringUtils.isNotBlank(param.getAuditType())) {
			param.setAuditTypeArr(StringUtil.toStringList(param.getAuditType(), ","));
		}
		List<ErpAuditRuntime> auditRuntimeList = erpAuditRuntimeMapper.getAuditTaskList(cityId, compId, param);
		PageInfo<ErpAuditRuntime> infoList = new PageInfo<>(auditRuntimeList);
		return ErpResponseJson.ok(infoList);
	}
	
	/**
	 * 获取待我审核的审核列表
	 * @author 张宏利
	 * @since 2017年10月20日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getWaitMyAuditList")
	public ErpResponseJson getWaitMyAuditList(@Valid @RequestBody GetAuditListParam param) throws Exception {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer userId = operator.getUserId();
		String dataType = param.getDataType();
		String auditType = param.getAuditType();

		param.setCompId(compId);

		String[] dateArr = DateUtil.getConditionDate(dataType);
		param.setStartTime(dateArr[0]);
		param.setEndTime(dateArr[1]);
		if(StringUtils.isNotBlank(auditType)) {
			param.setAuditTypeArr(Arrays.asList(auditType.split(",")));
		}
		if (param.getAuditResource() != null && param.getAuditResource().equals(Const.AUDIT_RESOURCE.AUDIT_RESOURCE_COMMON)) {
			List<Integer> templateIds = new ArrayList<>();
			if (param.getClassId() != null) {
				if (param.getTemplateId() == null) {
					ErpAuditTemplateExample erpAuditTemplateExample = new ErpAuditTemplateExample();
					erpAuditTemplateExample.setShardCityId(cityId);
					erpAuditTemplateExample.createCriteria().andClassIdEqualTo(param.getClassId());
					List<ErpAuditTemplate> auditTemplates = erpAuditTemplateMapper.selectByExample(erpAuditTemplateExample);
					if (CollectionUtils.isNotEmpty(auditTemplates)) {
						templateIds = auditTemplates.stream().map(ErpAuditTemplate::getId).collect(Collectors.toList());
					}
				}
			}
			if (param.getTemplateId() != null) {
				templateIds.add(param.getTemplateId());
			}
			param.setTemplateIds(templateIds);
		}
		
		//**********************组织架构改版********************************
		if (operator.newOrganizationType()) {       //代表查询新组织架构*
			if (null != param.getOrganizationId() && param.getOrganizationId() == 0) {
				param.setOrganizationId(null);
			}
		}
		//**********************组织架构改版********************************

		//12328 5.20上线 PC&APP审核页面、系统监控-类型增加新增房源、建筑面积修改、委托资料 #3
        if(StringUtil.isNotBlank(param.getCaseNo())){
            List<Integer> caseIds = erpFunEntrustRecordNoMapper.selectByRecordNo(cityId,compId,param.getCaseNo());
			if(null != caseIds && caseIds.size() > 0){
				String caseIdStr = caseIds.stream().map(Objects::toString).collect(Collectors.joining(","));
				param.setCaseIds("(" + caseIdStr + ")");
			}
        }
		// 获取审核的ID列表

		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<Integer> auditIdList = erpAuditUserRuntimeMapper.getMyAuditList(cityId, userId, 1, param);
		if(auditIdList== null || auditIdList.isEmpty()) {
			return ErpResponseJson.ok();
		}
		PageInfo<Integer> infoList = new PageInfo<>(auditIdList);
		// 通过ID查询列表
		List<ErpAuditRuntime> auditRuntimeList = erpAuditRuntimeMapper.selectListByIds(cityId, compId, auditIdList);
		//投诉类型字典
		Map<String, ErpDicDefinitions> dicMap = Collections.emptyMap();
		boolean containComplain = auditRuntimeList.stream()
				.map(ErpAuditRuntime::getAuditResource)
				.anyMatch(obj -> Objects.equals(obj, Const.AUDIT_RESOURCE.AUDIT_RESOURCE_HOUSE_COMPLAIN));
		if (containComplain) {
			dicMap = getHouseComplainDicMap();
		}
		for (ErpAuditRuntime obj : auditRuntimeList) {
			//房源投诉
			setHouseComplainDesc(dicMap, obj);
		}

		ErpResponseJson responseJson = ErpResponseJson.ok(infoList);
		responseJson.setData(auditRuntimeList);
		return responseJson;
	}

	/**
	 * houseComplain 投诉字典
	 * @return
	 * @throws Exception
	 */
	private Map<String, ErpDicDefinitions> getHouseComplainDicMap() throws Exception {
		ErpDicDefinitions erpDicDefinitions = new ErpDicDefinitions();
		erpDicDefinitions.setShardCityId(getOperator().getCityId());
		erpDicDefinitions.setDicType("HOUSE_COMPLAINT_TYPE");
		List<ErpDicDefinitions> dic = erpDicDefdinitionsService.getDicDefinitionsByCondition(erpDicDefinitions);
		return dic.stream().distinct().collect(Collectors.toMap(ErpDicDefinitions::getDicValue, obj -> obj));
	}

	/**
	 * 投诉信息
	 * @param dicMap
	 * @param obj
	 */
	private void setHouseComplainDesc(Map<String, ErpDicDefinitions> dicMap, ErpAuditRuntime obj) {
		if (Objects.isNull(obj)|| !Objects.equals(obj.getAuditResource(), Const.AUDIT_RESOURCE.AUDIT_RESOURCE_HOUSE_COMPLAIN)
				|| Objects.isNull(obj.getAuditType())) {
			return;
		}
		String complainType = obj.getAuditType().toString();
		ErpDicDefinitions def = dicMap.get(complainType);
		if (Objects.nonNull(def) && StringUtil.isNotBlank(def.getDicCnMsg())) {
			obj.setAuditExplain(String.format("#%s# %s", def.getDicCnMsg(), obj.getAuditExplain()));
		}
	}
	/**
	 * 获取我审核的审核列表
	 * @author 张宏利
	 * @since 2017年10月20日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getMyAuditList")
	public ErpResponseJson getMyAuditList(@Valid @RequestBody GetAuditListParam param) throws Exception {
        Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer userId = operator.getUserId();
		String dataType = param.getDataType();
		String auditType = param.getAuditType();

		param.setCompId(compId);
		String[] dateArr = DateUtil.getConditionDate(dataType);
		param.setStartTime(dateArr[0]);
		param.setEndTime(dateArr[1]);
		if(StringUtils.isNotBlank(auditType)) {
			param.setAuditTypeArr(Arrays.asList(auditType.split(",")));
		}
		if (param.getAuditResource() != null && param.getAuditResource().equals(Const.AUDIT_RESOURCE.AUDIT_RESOURCE_COMMON)) {
			List<Integer> templateIds = new ArrayList<>();
			if (param.getClassId() != null) {
				if (param.getTemplateId() == null) {
					ErpAuditTemplateExample erpAuditTemplateExample = new ErpAuditTemplateExample();
					erpAuditTemplateExample.setShardCityId(cityId);
					erpAuditTemplateExample.createCriteria().andClassIdEqualTo(param.getClassId());
					List<ErpAuditTemplate> auditTemplates = erpAuditTemplateMapper.selectByExample(erpAuditTemplateExample);
					if (CollectionUtils.isNotEmpty(auditTemplates)) {
						templateIds = auditTemplates.stream().map(ErpAuditTemplate::getId).collect(Collectors.toList());
					}
				}
			}
			if (param.getTemplateId() != null) {
				templateIds.add(param.getTemplateId());
			}
			param.setTemplateIds(templateIds);
		}
        
        //**********************组织架构改版********************************
        if (operator.newOrganizationType()) {       //代表查询新组织架构*
            if (null != param.getOrganizationId() && param.getOrganizationId() == 0) {
                param.setOrganizationId(null);
            }
        }
        //**********************组织架构改版********************************

		//12328 5.20上线 PC&APP审核页面、系统监控-类型增加新增房源、建筑面积修改、委托资料 #3
		if(StringUtil.isNotBlank(param.getCaseNo())){
			List<Integer> caseIds = erpFunEntrustRecordNoMapper.selectByRecordNo(cityId,compId,param.getCaseNo());
			if(null != caseIds && caseIds.size() > 0){
				String caseIdStr = caseIds.stream().map(Objects::toString).collect(Collectors.joining(","));
				param.setCaseIds("(" + caseIdStr + ")");
			}
		}
		
		// 获取审核的ID列表
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<Integer> auditIdList = erpAuditUserRuntimeMapper.getMyAuditList(cityId, userId, 2, param);
		if(auditIdList== null || auditIdList.isEmpty()) {
			return ErpResponseJson.ok();
		}
		PageInfo<Integer> infoList = new PageInfo<>(auditIdList);
		// 通过ID查询列表
		List<ErpAuditRuntime> auditRuntimeList = erpAuditRuntimeMapper.selectListByIds(cityId, compId, auditIdList);

		//投诉类型字典
		Map<String, ErpDicDefinitions> dicMap = Collections.emptyMap();
		boolean containComplain = auditRuntimeList.stream()
				.map(ErpAuditRuntime::getAuditResource)
				.anyMatch(resourceType -> Objects.equals(resourceType, Const.AUDIT_RESOURCE.AUDIT_RESOURCE_HOUSE_COMPLAIN));
		if (containComplain) {
			dicMap = getHouseComplainDicMap();
		}
		for (ErpAuditRuntime obj : auditRuntimeList) {
			//房源投诉
			setHouseComplainDesc(dicMap, obj);
		}
		ErpResponseJson responseJson = ErpResponseJson.ok(infoList);
		responseJson.setData(auditRuntimeList);
		return responseJson;
	}
	
	/**
	 * 获取我发起的审核列表
	 * @author 张宏利
	 * @since 2017年10月20日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getMyCreateAuditList")
	public ErpResponseJson getMyCreateAuditList(@Valid @RequestBody GetAuditListParam param) throws Exception {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer userId = operator.getUserId();
		String dataType = param.getDataType();
		String auditType = param.getAuditType();

		param.setCompId(compId);
		String[] dateArr = DateUtil.getConditionDate(dataType);
		param.setStartTime(dateArr[0]);
		param.setEndTime(dateArr[1]);
		if(StringUtils.isNotBlank(auditType)) {
			param.setAuditTypeArr(Arrays.asList(auditType.split(",")));
		}
		param.setUserId(userId);
		if (param.getAuditResource() != null && param.getAuditResource().equals(Const.AUDIT_RESOURCE.AUDIT_RESOURCE_COMMON)) {
			List<Integer> templateIds = new ArrayList<>();
			if (param.getClassId() != null) {
				if (param.getTemplateId() == null) {
					ErpAuditTemplateExample erpAuditTemplateExample = new ErpAuditTemplateExample();
					erpAuditTemplateExample.setShardCityId(cityId);
					erpAuditTemplateExample.createCriteria().andClassIdEqualTo(param.getClassId());
					List<ErpAuditTemplate> auditTemplates = erpAuditTemplateMapper.selectByExample(erpAuditTemplateExample);
					if (CollectionUtils.isNotEmpty(auditTemplates)) {
						templateIds = auditTemplates.stream().map(ErpAuditTemplate::getId).collect(Collectors.toList());
					}
				}
			}
			if (param.getTemplateId() != null) {
				templateIds.add(param.getTemplateId());
			}
			param.setTemplateIds(templateIds);
		}
		
		//**********************组织架构改版********************************
		if (operator.newOrganizationType()) {       //代表查询新组织架构*
			if (null != param.getOrganizationId() && param.getOrganizationId() == 0) {
				param.setOrganizationId(null);
			}
		}
		//**********************组织架构改版********************************

		//12328 5.20上线 PC&APP审核页面、系统监控-类型增加新增房源、建筑面积修改、委托资料 #3
		if(StringUtil.isNotBlank(param.getCaseNo())){
			List<Integer> caseIds = erpFunEntrustRecordNoMapper.selectByRecordNo(cityId,compId,param.getCaseNo());
			if(null != caseIds && caseIds.size() > 0){
				String caseIdStr = caseIds.stream().map(Objects::toString).collect(Collectors.joining(","));
				param.setCaseIds("(" + caseIdStr + ")");
			}
		}
		
		// 通过ID查询列表
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<ErpAuditRuntime> auditRuntimeList = erpAuditRuntimeMapper.getAuditTaskList(cityId, compId, param);

		//投诉类型字典
		Map<String, ErpDicDefinitions> dicMap = new HashMap<>();
		Map<Integer,ErpFunLease> funLeaseMap = new HashMap<>();
		Map<Integer,ErpFunSale> funSaleMap = new HashMap<>();
		Map<String, ErpDicDefinitions> priceUnitMap = new HashMap<>();
		getMappingInfo(auditRuntimeList,dicMap,funLeaseMap,funSaleMap,priceUnitMap);
		for (ErpAuditRuntime obj : auditRuntimeList) {
			//针对房源投诉
			setHouseComplainExplain(dicMap, funSaleMap, funLeaseMap, priceUnitMap, obj);
		}
		PageInfo<ErpAuditRuntime> infoList = new PageInfo<>(auditRuntimeList);
		return ErpResponseJson.ok(infoList);
	}

	/**
	 * 获取字典数据 房源投诉
	 * @param auditRuntimeList
	 * @param dicMap
	 * @param funLeaseMap
	 * @param funSaleMap
	 * @param priceUnitMap
	 * @throws Exception
	 */
	private void getMappingInfo(List<ErpAuditRuntime> auditRuntimeList,Map<String, ErpDicDefinitions> dicMap,
							Map<Integer,ErpFunLease> funLeaseMap,Map<Integer,ErpFunSale> funSaleMap,
						 Map<String, ErpDicDefinitions> priceUnitMap) throws Exception {
		if (Objects.isNull(auditRuntimeList) || auditRuntimeList.isEmpty()) {
			return;
		}
		//是否有房源投诉的审核
		boolean hasHouseComplain = auditRuntimeList.stream()
				.map(ErpAuditRuntime::getAuditResource)
				.anyMatch(obj -> Objects.equals(obj, Const.AUDIT_RESOURCE.AUDIT_RESOURCE_HOUSE_COMPLAIN));

		if (!hasHouseComplain) {
			return;
		}
		Map<Integer, List<ErpAuditRuntime>> funInfoMap = auditRuntimeList.stream()
				.filter(obj -> Objects.equals(obj.getAuditResource(), Const.AUDIT_RESOURCE.AUDIT_RESOURCE_HOUSE_COMPLAIN))
				.collect(Collectors.groupingBy(ErpAuditRuntime::getCaseType));
		List<ErpAuditRuntime> caseSale = funInfoMap.get(Const.DIC_CASE_TYPE_SALE_FUN);
		List<ErpAuditRuntime> caseLease = funInfoMap.get(Const.DIC_CASE_TYPE_LEASE_FUN);
		//投诉类型
		dicMap.putAll(getHouseComplainDicMap());
		//出售
		if (Objects.nonNull(caseSale)) {
			List<Integer> saleIds = caseSale.stream().map(ErpAuditRuntime::getCaseId).collect(Collectors.toList());
			ErpFunSaleExample example = new ErpFunSaleExample();
			example.setShardCityId(getOperator().getCityId());
			example.createCriteria().andSaleIdIn(saleIds);
			List<ErpFunSale> erpFunSales = erpFunSaleMapper.selectByExample(example);
			Map<Integer, ErpFunSale> saleMap = erpFunSales.stream().collect(Collectors.toMap(ErpFunSale::getSaleId, obj -> obj, (old, newObj) -> newObj));
			//出售映射
			funSaleMap.putAll(saleMap);
		}
		//出租
		if (Objects.nonNull(caseLease)) {
			List<Integer> leaseIds = caseLease.stream().map(ErpAuditRuntime::getCaseId).collect(Collectors.toList());
			ErpFunLeaseExample example = new ErpFunLeaseExample();
			example.setShardCityId(getOperator().getCityId());
			example.createCriteria().andLeaseIdIn(leaseIds);
			List<ErpFunLease> erpFunLeases = erpFunLeaseMapper.selectByExample(example);
			Map<Integer, ErpFunLease> leaseMap = erpFunLeases.stream().collect(Collectors.toMap(ErpFunLease::getLeaseId, obj -> obj, (old, newObj) -> newObj));
			funLeaseMap.putAll(leaseMap);
			List<String> priceUnits = erpFunLeases.stream().map(ErpFunLease::getPriceUnit).filter(Objects::nonNull).map(String::valueOf).distinct().collect(Collectors.toList());
			List<ErpDicDefinitions> priceUnit = erpDicDefdinitionsService.getDicValues(getOperator().getCityId(), "PRICE_UNIT", priceUnits);
			Map<String, ErpDicDefinitions> priceMap = priceUnit.stream().collect(Collectors.toMap(ErpDicDefinitions::getDicValue, obj -> obj, (e1, e2) -> e2));
			//出租映射
			priceUnitMap.putAll(priceMap);
		}
	}
	/**
	 * 针对房源投诉 显示
	 * @param dicMap
	 * @param funSaleMap
	 * @param funLeaseMap
	 * @param priceUnitMap
	 * @param obj
	 */
	private void setHouseComplainExplain(Map<String, ErpDicDefinitions> dicMap, Map<Integer, ErpFunSale> funSaleMap, Map<Integer, ErpFunLease> funLeaseMap, Map<String, ErpDicDefinitions> priceUnitMap, ErpAuditRuntime obj) {
		if(!Objects.equals(obj.getAuditResource(), Const.AUDIT_RESOURCE.AUDIT_RESOURCE_HOUSE_COMPLAIN)){
			return;
		}
		String complainTypeCn = "";
		if (Objects.nonNull(obj.getAuditType())) {
			ErpDicDefinitions def = dicMap.get(obj.getAuditType().toString());
			complainTypeCn = def.getDicCnMsg();
		}
		//出售
		if (Objects.equals(obj.getCaseType(), Const.DIC_CASE_TYPE_SALE_FUN)) {
			ErpFunSale erpFunSale = funSaleMap.get(obj.getCaseId());
			if (Objects.nonNull(erpFunSale)) {
				BigDecimal saleTotalPrice = erpFunSale.getSaleTotalPrice();
				String price = "";
				if (Objects.nonNull(saleTotalPrice)) {
					price = new DecimalFormat("#0.##").format(saleTotalPrice.doubleValue());
				}
				String houseInfo = String.format("您投诉房源 %s %d室 %d㎡ %s万 #%s#", erpFunSale.getBuildName(),
						erpFunSale.getSaleRoom(), Optional.ofNullable(erpFunSale.getSaleArea())
								.orElse(new BigDecimal(0)).intValue(), price,complainTypeCn);
				houseInfo = houseInfo.replaceAll("(null.\\s)|(##)", "");
				obj.setAuditExplain(houseInfo);
			}
			//出租
		} else if (Objects.equals(Const.DIC_CASE_TYPE_LEASE_FUN, obj.getCaseType())) {
			ErpFunLease erpFunLease = funLeaseMap.get(obj.getCaseId());
			if (Objects.nonNull(erpFunLease)) {
				String priceUnitCn = "";
				if(Objects.nonNull(erpFunLease.getPriceUnit())){
					ErpDicDefinitions definitions = priceUnitMap.get(erpFunLease.getPriceUnit().toString());
					if(Objects.nonNull(definitions)){
						priceUnitCn = definitions.getDicCnMsg();
					}
				}
				//出租价格及单位
				String price = NumberHelper.formatNumber(erpFunLease.getLeaseTotalPrice().toString(), NumberHelper.NUMBER_IN_2) + (StringUtil.isEmpty(priceUnitCn) ? "元/月" : priceUnitCn);
				String houseInfo = String.format("您投诉房源 %s %d室 %d㎡ %s #%s#", erpFunLease.getBuildName(),
						erpFunLease.getLeaseRoom(), Optional.ofNullable(erpFunLease.getLeaseArea())
								.orElse(new BigDecimal(0)).intValue(), price,complainTypeCn);
				houseInfo = houseInfo.replaceAll("(null.\\s)|(##)", "");
				//描述信息
				obj.setAuditExplain(houseInfo);
			}
		}
	}

	/**
	 * 获取审核任务图片列表
	 * @author 张宏利
	 * @since 2017年11月8日
	 * @param param
	 * @return
	 */
	/**
	 * 获取审核任务图片列表
	 * @author 张宏利
	 * @since 2017年11月8日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAuditPhoto")
	public ErpResponseJson getAuditPhoto(@RequestBody BaseMapParam param) {
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		Integer userId = getOperator().getUserId();
		Integer auditId = param.getInteger("auditId");
		ErpAuditRuntime auditRuntime = erpAuditRuntimeMapper.selectById(cityId, compId, auditId);
		Assert.isNullThrow(auditRuntime, "该审核不存在");
		Byte auditStatus = auditRuntime.getAuditStatus();
		// 审核失败或撤回，只有本人才能查看委托书
		if(auditStatus == 2 || auditStatus == 3) {
			if(Const.DIC_TRACK_TYPE_LIMITED.equals(auditRuntime.getAuditType())
					|| Const.DIC_TRACK_TYPE_ALONE.equals(auditRuntime.getAuditType())
					|| Const.DIC_TRACK_TYPE_RENT.equals(auditRuntime.getAuditType())
					|| Const.DIC_TRACK_TYPE_GENERAL_ENTRUSTMENT.equals(auditRuntime.getAuditType())) {
				if(!auditRuntime.getUserId().equals(userId)) {
					throw new ConfirmException("您没有权限查看该委托书！");
				}
			}
		}
		List<String> photoUrlsList = null;
		Map<String, ErpDicDefinitions> dicMap = new HashMap<String, ErpDicDefinitions>();
		Map<String, ErpFunPhoto> photoAddrListMap = new HashMap<String, ErpFunPhoto>();
		if (StringUtils.isNotBlank(auditRuntime.getPhotoIds())) {
			List<String> photoIdStrList = Arrays.asList(auditRuntime.getPhotoIds().split(","));
			List<Integer> photoIdList = photoIdStrList.stream().collect(Collectors.mapping(val -> StringUtil.parseInteger(val), Collectors.toList()));
			byte auditType = auditRuntime.getAuditType().byteValue();
			// 房堪
			if (Const.DIC_TRACK_TYPE_FUNCAN.equals(auditType)) {
				ErpFunPhotoExample example = new ErpFunPhotoExample();
				example.setShardCityId(cityId);
				example.createCriteria().andCompIdEqualTo(compId).andPhotoIdIn(photoIdList);
				List<ErpFunPhoto> fkPhotoList = erpFunPhotoMapper.selectByExample(example);
				photoUrlsList = fkPhotoList.stream().collect(Collectors.mapping(ErpFunPhoto::getPhotoAddr, Collectors.toList()));
				// 带看和委托
			} else if (Const.DIC_TRACK_TYPE_DAIKAN.equals(auditType)
					|| Const.DIC_TRACK_TYPE_GENERAL_ENTRUSTMENT.equals(auditType)
					|| Const.DIC_TRACK_TYPE_ALONE.equals(auditType)
					|| Const.DIC_TRACK_TYPE_LIMITED.equals(auditType)
					|| Const.DIC_TRACK_TYPE_RENT.equals(auditType)) {
				ErpFunEntrustmentPhotoExample example = new ErpFunEntrustmentPhotoExample();
				example.setShardCityId(cityId);
				example.createCriteria().andCompIdEqualTo(compId).andIdIn(photoIdList);
				List<ErpFunEntrustmentPhoto> entrustmentPhotoList = erpFunEntrustmentPhotoMapper.selectByExample(example);
				photoUrlsList = entrustmentPhotoList.stream().collect(Collectors.mapping(ErpFunEntrustmentPhoto::getPhotoAddr, Collectors.toList()));
			}
			// 普通
		} else if (StringUtils.isNotBlank(auditRuntime.getPhotoUrls())) {
			boolean json = isJson(auditRuntime.getPhotoUrls());
			if (json) {
				List<ErpFunPhoto> erpFunPhotos = JSON.parseArray(auditRuntime.getPhotoUrls(), ErpFunPhoto.class);
				if(erpFunPhotos.size() > 0) {
					photoUrlsList = erpFunPhotos.stream().collect(Collectors.mapping(ErpFunPhoto::getPhotoAddr, Collectors.toList()));
					if(Const.DIC_TRACK_TYPE_LIMITED.equals(auditRuntime.getAuditType())
							|| Const.DIC_TRACK_TYPE_ALONE.equals(auditRuntime.getAuditType())
							|| Const.DIC_TRACK_TYPE_RENT.equals(auditRuntime.getAuditType())
							|| Const.DIC_TRACK_TYPE_GENERAL_ENTRUSTMENT.equals(auditRuntime.getAuditType())) {
						List<Byte> photoTypeList = erpFunPhotos.stream().collect(Collectors.mapping(ErpFunPhoto::getPhotoType, Collectors.toList()));
						List<ErpDicDefinitions> dicList = erpDicDefinitionsMapper.getDicListByDicValues(cityId, "HOUSE_FILE", photoTypeList);
						dicMap = dicList.stream().collect(Collectors.toMap(ErpDicDefinitions :: getDicValue, val -> val));
						photoAddrListMap = erpFunPhotos.stream().collect(Collectors.toMap(ErpFunPhoto :: getPhotoAddr, val -> val, (oldVal, newVal) -> oldVal));
					}
				}
			}else {
				photoUrlsList = Arrays.asList(auditRuntime.getPhotoUrls().split(","));
			}
		}
		List<Map<String, Object>> photoList = new LinkedList<>();
		if (photoUrlsList!=null) {
			for (String photoAddr : photoUrlsList) {
				if (StringUtils.isNotBlank(photoAddr)) {
					Map<String, Object> map = new HashMap<>();
					map.put("url", CommonUtil.getHousePhoto(photoAddr));
					if(Const.DIC_TRACK_TYPE_LIMITED.equals(auditRuntime.getAuditType())
							|| Const.DIC_TRACK_TYPE_ALONE.equals(auditRuntime.getAuditType())
							|| Const.DIC_TRACK_TYPE_RENT.equals(auditRuntime.getAuditType())
							|| Const.DIC_TRACK_TYPE_GENERAL_ENTRUSTMENT.equals(auditRuntime.getAuditType())) {
						if (null != photoAddrListMap) {
							ErpFunPhoto erpFunPhoto = photoAddrListMap.get(photoAddr);
							if (null != erpFunPhoto && null != dicMap) {
								ErpDicDefinitions erpDicDefinitions = dicMap.get(null != erpFunPhoto.getPhotoType() ? erpFunPhoto.getPhotoType().toString() : "");
								if (null != erpDicDefinitions) {
									map.put("fileClassName", erpDicDefinitions.getDicCnMsg2());
									map.put("fileTypeName", erpDicDefinitions.getDicCnMsg());
								}
							}
						}
					}
					photoList.add(map);
				}
			}
		}
		return ErpResponseJson.ok(photoList);
	}

	public boolean isJson(String content){
		try {
			JSONObject.parseArray(content);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 获取审核任务视频列表
	 * @author 张宏利
	 * @since 2017年11月8日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAuditVideo")
	public ErpResponseJson getAuditVideo(@RequestBody BaseMapParam param) {
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		Integer auditId = param.getInteger("auditId");
		ErpAuditRuntime auditRuntime = erpAuditRuntimeMapper.selectById(cityId, compId, auditId);
		byte auditType = auditRuntime.getAuditType().byteValue();
		List<Map<String,Object>> videoUrlList = new LinkedList<>();
		if (Const.DIC_TRACK_TYPE_DAIKAN.equals(auditType)) {
			if (StringUtils.isNotBlank(auditRuntime.getVideoUrls())) {
				Map<String,Object> videoUrlMap = new HashMap<>();
				videoUrlMap.put("url", CommonUtil.getVideoUrl(auditRuntime.getVideoUrls()));
				videoUrlMap.put("location", auditRuntime.getVideoLocations());
				videoUrlMap.put("videoShootingTime", auditRuntime.getVideoShootingTimes());
				videoUrlMap.put("uploadUser", auditRuntime.getUserId());
				videoUrlList.add(videoUrlMap);
			}
		} else if (Const.DIC_TRACK_TYPE_FUNCAN.equals(auditType)) {
			if (StringUtils.isNotBlank(auditRuntime.getVideoIds())) {
				String videoIds = auditRuntime.getVideoIds();
				List<Integer> videoIdList = Arrays.asList(videoIds.split(",")).stream()
						.collect(Collectors.mapping(val -> StringUtil.parseInteger(val, 0), Collectors.toList()));
				if (!videoIdList.isEmpty()) {
					ErpFunVideoExample example = new ErpFunVideoExample();
					example.setShardCityId(cityId);
					example.createCriteria().andVideoIdIn(videoIdList);
					List<ErpFunVideo> erpFunVideoList = erpFunVideoMapper.selectByExample(example);
					erpFunVideoList.stream().forEach(video->{
						Map<String,Object> videoUrlMap = new HashMap<>();
						videoUrlMap.put("url", CommonUtil.getVideoUrl(video.getVideoAddr()));
						videoUrlMap.put("location", video.getLocation());
						videoUrlMap.put("videoShootingTime", video.getVideoShootingTime());
						videoUrlMap.put("uploadUser", video.getUploadUser());
						videoUrlList.add(videoUrlMap);
					});
					
				}
			}
		}
		return ErpResponseJson.ok(videoUrlList);
	}
	
	/**
	 * 获取审核任务VR列表
	 * @author 张宏利
	 * @since 2017年11月8日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAuditVr")
	public ErpResponseJson getAuditVr(@RequestBody BaseMapParam param) {
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		Integer auditId = param.getInteger("auditId");
		ErpAuditRuntime auditRuntime = erpAuditRuntimeMapper.selectById(cityId, compId, auditId);
		List<Map<String, Object>> vrList = new LinkedList<>();
		if (StringUtils.isNotBlank(auditRuntime.getVrIds())) {
			String[] vrUrls = auditRuntime.getVrIds().split(",");
			for (String vrUrl : vrUrls) {
				Map<String, Object> map = new HashMap<>();
				map.put("url", vrUrl.replaceAll("\\\\", "/") + "front.jpg");
				vrList.add(map);
			}
		}
		return ErpResponseJson.ok(vrList);
	}
	
	/**
	 * 获取审核任务详情
	 * @author 张宏利
	 * @since 2017年10月27日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAuditDetail")
	public ErpResponseJson getAuditDetail(@Valid @RequestBody BaseMapParam param) throws Exception{
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		Integer userId = getOperator().getUserId();
		Integer auditId = param.getInteger("auditId");
		Map<String, Object> resultMap = new HashMap<>();
		ErpAuditRuntimeDto auditRuntime = erpAuditRuntimeMapper.selectById(cityId, compId, auditId);
		Assert.isNullThrow(auditRuntime, "无权查看该详情");
		List<ErpAuditUserRuntimeDto> auditUserTempList = erpAuditUserRuntimeMapper.getUserListByAuditId(cityId, auditId, userId);
		// 相关房客源信息，当前只有外出审核才有
		if(auditRuntime.getAuditResource() == 3) {
			List<ErpAuditRuntimeCase> caseList = erpAuditRuntimeCaseMapper.selectByAuditId(cityId, compId, auditId);
			if (caseList != null && !caseList.isEmpty()) {
				// 对数据进行租售类型分组
				Map<Integer, List<ErpAuditRuntimeCase>> caseMap = caseList.stream().collect(Collectors.groupingBy(ErpAuditRuntimeCase::getCaseType));
				for (Entry<Integer, List<ErpAuditRuntimeCase>> entry : caseMap.entrySet()) {
					List<Integer> caseIdList = entry.getValue().stream().collect(Collectors.mapping(ErpAuditRuntimeCase::getCaseId, Collectors.toList()));
					if (caseIdList == null || caseIdList.size() <= 0) {
						continue;
					}
					param.setObject("caseIdList",caseIdList);
					param.setInteger("caseType", entry.getKey());
					// 依据不同类型查询房客源信息
					List<Map<String, Object>> caseSelList = erpFunSaleMapper.getCaseList(cityId, param.getMap());
					if (Const.DIC_CASE_TYPE_SALE_FUN.equals(entry.getKey())) {
						resultMap.put("saleList", caseSelList);
					} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(entry.getKey())) {
						resultMap.put("leaseList", caseSelList);
					} else if (Const.DIC_CASE_TYPE_BUY_CUST.equals(entry.getKey())) {
						resultMap.put("buyList", caseSelList);
					} else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(entry.getKey())) {
						resultMap.put("rentList", caseSelList);
					}
				}
			}
			// 外出审核查看签到记录
			List<ErpOutLogDto> checkRecordList = erpOutLogMapper.getOutLogAuditCheckRecordList(cityId, compId, auditId);
			if(null != checkRecordList && !checkRecordList.isEmpty()){
				for(int i = checkRecordList.size()-1;i>=0;i--){
					ErpOutLogDto erpOutLogDto = checkRecordList.get(i);
					if(null == erpOutLogDto){
						checkRecordList.remove(i);
						continue;
					}
					erpOutLogDto.setPhotoPath(CommonUtil.getCommonPhotoUrl(erpOutLogDto.getPhotoPath()));
				}
				resultMap.put("checkRecordList", checkRecordList);
//				for (ErpOutLogDto erpOutLogDto : checkRecordList) {
//					if (erpOutLogDto!=null)
//					erpOutLogDto.setPhotoPath(CommonUtil.getCommonPhotoUrl(erpOutLogDto.getPhotoPath()));
//				}
//				resultMap.put("checkRecordList", checkRecordList);
			}
		} else if (Objects.equals(Byte.valueOf("2"), auditRuntime.getAuditResource())) {
			auditRuntime.setLeaveDay(NumberHelper.formatNumber(Optional.ofNullable(auditRuntime.getTargetDay()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_1));
			auditRuntime.setLeaveStartTime(null != auditRuntime.getTargetStartTime() ? (DateTimeHelper.formatDateTimetoString(auditRuntime.getTargetStartTime(), DateTimeHelper.FMT_yyyyMMdd)) : null);
			auditRuntime.setLeaveEndTime(null != auditRuntime.getTargetEndTime() ? (DateTimeHelper.formatDateTimetoString(auditRuntime.getTargetEndTime(), DateTimeHelper.FMT_yyyyMMdd)) : null);
			auditRuntime.setLeaveName(null != auditRuntime.getClassName() ? auditRuntime.getClassName() : "");
			auditRuntime.setLeaveStartType(auditRuntime.getTargetStartType());
			auditRuntime.setLeaveEndType(auditRuntime.getTargetEndType());
			auditRuntime.setLeaveId(auditRuntime.getClassId());
		} else if (auditRuntime.getAuditResource() == 1 && auditRuntime.getAuditType() == 3) {
			// 房堪的话要显示附件图片(移动端传的ID, ERP端传的urls)
			String photoIds = auditRuntime.getPhotoIds();
			if (StringUtil.isNotBlank(photoIds)) {
				String[] photoIdArr = photoIds.split(",");
				List<Integer> photoIdList = Arrays.stream(photoIdArr).map(Integer::valueOf).collect(Collectors.toList());

				ErpFunPhotoExample funPhotoExample = new ErpFunPhotoExample();
				funPhotoExample.setShardCityId(getOperator().getCityId());
				funPhotoExample.createCriteria().andPhotoIdIn(photoIdList);
				List<ErpFunPhoto> fkPhotoList = erpFunPhotoMapper.selectByExample(funPhotoExample);
				List<String> photoUrlsList = fkPhotoList.stream().map(ErpFunPhoto::getPhotoAddr).collect(Collectors.toList());

				if (CollectionUtils.isNotEmpty(photoUrlsList)) {
					String photoUrls = String.join(",", photoUrlsList.stream().map(CommonUtil::getCommonPhotoUrl).collect(Collectors.toList()));
					auditRuntime.setPhotoUrls(photoUrls);
				}
			}
            /*
             * 1. []
             * 2. [{"photoAddr":"oss/online/tmp/2019/01/25/36b5772ac06540e18f610294df9cf7a2.jpg","photoType":"0"},
             *    {"photoAddr":"oss/online/tmp/2019/01/25/fd17792784da4fe7a7f8b83d55c4eb14.jpg","photoType":"1"}]
             *
             * 3.[{"photoAddr":"","photoType":"1"}]
             * 4.oss/dev/tmp/2019/01/22/7c1b582f82cb412796b728ad3e671c47.png
             * 5.NULL或者空字符串
             */
            String photoUrls = auditRuntime.getPhotoUrls();

            if (StringUtils.isNotBlank(photoUrls)) {
				List<String> photoUrlsList = new ArrayList<>();

                if (!photoUrls.startsWith("[]")) {
                    // oss开头的老数据
                    if (photoUrls.startsWith("oss")) {
                        photoUrls = CommonUtil.getCommonPhotoUrl(photoUrls);
                        auditRuntime.setPhotoUrls(photoUrls);
                    } else if (photoUrls.startsWith("[{")) {
                        JSONArray jsonArray = JSON.parseArray(photoUrls);

                        if (jsonArray.size() > 0) {
                            for (int i = 0; i < jsonArray.size(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                if (jsonObject.containsKey("photoAddr")) {
                                    String photoAddr = jsonObject.getString("photoAddr");
                                    if (StringUtils.isNotBlank(photoAddr)) {
                                        photoUrlsList.add(photoAddr);
                                    }
                                }
                            }
                        }
                        if (CollectionUtils.isNotEmpty(photoUrlsList)) {
                            photoUrls = String.join(",", photoUrlsList.stream().map(CommonUtil::getCommonPhotoUrl).collect(Collectors.toList()));
                            auditRuntime.setPhotoUrls(photoUrls);
                        }
                    }
                }
            }
            
            // 房堪上传的视频
            String videoUrls = auditRuntime.getVideoUrls();
            if (StringUtil.isNotBlank(videoUrls)) {
				auditRuntime.setVideoUrls(CommonUtil.getCommonPhotoUrl(videoUrls));
			}
            
        } else if (auditRuntime.getAuditResource() == 1 && Arrays.asList(6, 7, 9, 19).contains(auditRuntime.getAuditType())) {// 委托审核中的图片处理
            String photoUrls = auditRuntime.getPhotoUrls();
            if (StringUtils.isNotBlank(photoUrls)) {
        		List<String> photoUrlsList = new ArrayList<String>();
        		if (isJson(photoUrls)) {
        			JSONArray jsonArray = JSONObject.parseArray(photoUrls);
					for (Object obj : jsonArray) {
						JSONObject parseObject = JSONObject.parseObject(obj.toString());
						String entrustPhotoAddr = parseObject.getString("photoAddr");
						if (StringUtils.isNotBlank(entrustPhotoAddr)) {
							photoUrls = CommonUtil.getCommonPhotoUrl(entrustPhotoAddr);
							photoUrlsList.add(photoUrls);
						}
					}
        		} else {
        			String[] photoUrlsArr = photoUrls.split(",");
        			if (photoUrlsArr.length > 0) {
        				for (String photoUrl : photoUrlsArr) {
        					if (StringUtil.isNotBlank(photoUrl)) {
        						photoUrls = CommonUtil.getCommonPhotoUrl(photoUrl);
        						photoUrlsList.add(photoUrls);
        					}
        				}
        			}
        		}
        		auditRuntime.setPhotoUrls(photoUrlsList.stream().map(val -> val).collect(Collectors.joining(",")));
            }
		} else if (auditRuntime.getAuditResource() == 6) {
			String photoUrls = auditRuntime.getPhotoUrls();

			List<String> photoUrlsList = new ArrayList<>();
			if (StringUtils.isNotBlank(photoUrls)) {
				String[] photoUrlsArr = photoUrls.split(",");
				if (photoUrlsArr.length > 0) {
					for (String photoUrl : photoUrlsArr) {
						if (StringUtil.isNotBlank(photoUrl)) {
							photoUrl = CommonUtil.getCommonPhotoUrl(photoUrl);
							photoUrlsList.add(photoUrl);
						}
					}
				}
				auditRuntime.setPhotoUrls(String.join(",", photoUrlsList));
			}

			// 通用审核路径json
			String attachmentUrls = auditRuntime.getAttachmentUrls();
			List<AttachmentVo> attachmentList = new ArrayList<>();

			if (StringUtils.isNotEmpty(attachmentUrls)) {
				// 通用审核附件路径列表
				attachmentList = JSON.parseObject(attachmentUrls, new TypeReference<List<AttachmentVo>>() {
				});
				if (CollectionUtils.isNotEmpty(attachmentList)) {
					for (AttachmentVo attachmentVo : attachmentList) {
						if (attachmentVo != null) {
							String attachmentUrl = attachmentVo.getAttachmentUrl();
							if (StringUtils.isNotEmpty(attachmentUrl)) {
								attachmentUrl = AppConfig.getHousePicDomainPath(attachmentUrl);
								attachmentVo.setAttachmentUrl(attachmentUrl);
							}
						}
					}
				}
			}
			auditRuntime.setAttachmentUrls(JSON.toJSONString(attachmentList));
		}

		if (auditRuntime.getAuditResource() == 5) {
			String photoUrls = auditRuntime.getPhotoUrls();
			if (StringUtils.isNotBlank(photoUrls)) {
				// oss开头的老数据
				String[] urlArr = photoUrls.split(",");
				photoUrls = Stream.of(urlArr).filter(StringUtil::isNotBlank).map(url->{
					if (url.startsWith("oss")) {
						url = CommonUtil.getCommonPhotoUrl(url);
					}
					return url;
				}).collect(Collectors.joining(","));
				auditRuntime.setPhotoUrls(photoUrls);
			}
		}

		if(null != auditRuntime.getAuditType() && null != auditRuntime.getMakeLookId()) {
			// 查询约看记录
			Integer makeLookId = auditRuntime.getMakeLookId();
			ErpMakeLookHouse erpMakeLookHouse = new ErpMakeLookHouse();
			erpMakeLookHouse.setId(makeLookId);
			erpMakeLookHouse.setShardCityId(cityId);
			erpMakeLookHouse = erpMakeLookHouseMapper.selectByPrimaryKey(erpMakeLookHouse);
			auditRuntime.setMakeLookRichTitle(erpMakeLookHouse.getMakeLookRichTitle());
		}

		//detail task#12447 [20-5-26] wc 转交日志
		ErpAuditUserTransmitLogExample example = new ErpAuditUserTransmitLogExample();
		example.setShardCityId(cityId);
		example.createCriteria().andCompIdEqualTo(compId).andAuditIdEqualTo(auditId);
		List<ErpAuditUserTransmitLog> logs = erpAuditUserTransmitLogMapper.selectByExample(example);
		List<ErpAuditUserTransmitLogVO> transmitLog = new ArrayList<>();
		Map<Integer, Integer> userArch = new HashMap<>();
		Map<Integer, String> userPhoto = new HashMap<>();
		if(logs.size() > 0){
			//头像
			Set<Integer> userIds = logs.stream().collect(Collectors.mapping(v -> v.getSourceUserid(), Collectors.toSet()));
			if(userIds.size() > 0){
				List<ErpFunUsers> users = erpFunUsersMapper.getUserListByUserIds(cityId, userIds);
				if (users.size() > 0) {
					userArch = users.stream().collect(Collectors.toMap(v -> v.getUserId(), v -> v.getArchiveId()));
					List<Integer> archiveIds = users.stream().collect(Collectors.mapping(v -> v.getArchiveId(), Collectors.toList()));
					List<AdminFunArchive> userInfo = adminFunArchiveMapper.getArchiveInfosByIds(archiveIds);
					if (userInfo.size() > 0) {
						userPhoto = userInfo.stream().collect(HashMap::new, (m, p) -> m.put(p.getArchiveId(), p.getUserPhoto()), HashMap::putAll);
					}
				}
			}
			for(ErpAuditUserTransmitLog v : logs){
				ErpAuditUserTransmitLogVO logVO = new ErpAuditUserTransmitLogVO();
				org.springframework.beans.BeanUtils.copyProperties(v, logVO);
				logVO.setBbsPhoto(AppConfig.getUserPhotoPicDomainPath(userPhoto.get(userArch.get(logVO.getSourceUserid()))));
				if (StringUtils.isNotBlank(v.getTransmitPhoto())) {
					List<ErpAuditCommentFile> transmitPhotos = JSON.parseArray(v.getTransmitPhoto(), ErpAuditCommentFile.class);
					transmitPhotos.forEach(photo ->{
						photo.setFileAddr(AppConfig.getHousePicDomainPath(photo.getFileAddr()));
					});
					logVO.setFileList(transmitPhotos);
				}
				transmitLog.add(logVO);
			}
		}

		Set<Integer> userIds = new HashSet<>();
		Set<String> auditSeqSet = new HashSet<>();
		Set<Integer> nowAuditUserIds = new HashSet<>();
		List<ErpAuditUserRuntimeDto> auditUserList = new LinkedList<>();
		for (ErpAuditUserRuntimeDto erpAuditUserRuntime : auditUserTempList) {
			// 指定人审批
			if (erpAuditUserRuntime.getAuditUserType() == 1) {
				auditUserList.add(erpAuditUserRuntime);
			} else {
				// 顺序+角色=多角色单条唯一，多个SEQ相同的则为角色审核类型，只需要保留一个即可
				String tempSeq = erpAuditUserRuntime.getAuditSeq() + "_" + erpAuditUserRuntime.getAuditUserType() + "_" + erpAuditUserRuntime.getAuditRoleId();
				if (!auditSeqSet.contains(tempSeq)) {
					auditSeqSet.add(tempSeq);
					auditUserList.add(erpAuditUserRuntime);
				}
			}
			if(erpAuditUserRuntime.getAuditUserId() != null) {
				userIds.add(erpAuditUserRuntime.getAuditUserId());
			}
			// 待审核人中有自己则可以审核此任务
			if(erpAuditUserRuntime.getAuditStatus() == 1) {
				if(erpAuditUserRuntime.getAuditUserId() != null) {
					nowAuditUserIds.add(erpAuditUserRuntime.getAuditUserId());
				}
				if(userId.equals(erpAuditUserRuntime.getAuditUserId())) {
					auditRuntime.setCanAuditTask(1);// 可以审核
				}
			}
		}
		// 这一坨代码只为拼审核相关人头像
		userIds.add(auditRuntime.getUserId());
		List<ErpFunUsers> userList = erpFunUsersMapper.getUserListByUserIds(cityId, userIds);
		String nowAuditUsers = userList.stream().filter(val -> {
			return nowAuditUserIds.contains(val.getUserId());
		}).collect(Collectors.mapping(ErpFunUsers::getUserName, Collectors.joining(",")));
		// 防止太多人
		if (nowAuditUsers != null && nowAuditUsers.length() > 500) {
			nowAuditUsers = nowAuditUsers.substring(0, 500) + "...";
		}
		auditRuntime.setNowAuditUsers(nowAuditUsers);
		
		Map<Integer, Integer> userArchiveMap = userList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, val -> val.getArchiveId()));
		List<Integer> archiveIds = userList.stream().collect(Collectors.mapping(ErpFunUsers::getArchiveId, Collectors.toList()));
		List<AdminFunArchive> archiveList = adminFunArchiveMapper.getArchiveInfosByIds(archiveIds);
		Map<Integer, String> archiveMap = archiveList.stream()
				.collect(Collectors.toMap(AdminFunArchive::getArchiveId, val -> {
					return val.getUserPhoto() == null ? "" : val.getUserPhoto();
				}));
		Integer archiveId = userArchiveMap.get(auditRuntime.getUserId());
		auditRuntime.setUserPhoto(CommonUtil.getBbsPhoto(archiveMap.get(archiveId)));
		for (ErpAuditUserRuntimeDto erpAuditUserRuntime : auditUserList) {
			// 如果是当前人或者指定人或者已审核
			if (userId.equals(erpAuditUserRuntime.getAuditUserId()) || erpAuditUserRuntime.getAuditUserType() == 1
					|| erpAuditUserRuntime.getAuditStatus() == 2) {
				archiveId = userArchiveMap.get(erpAuditUserRuntime.getAuditUserId());
				erpAuditUserRuntime.setUserPhoto(CommonUtil.getBbsPhoto(archiveMap.get(archiveId)));
				continue;
			}

			// 待审核的有人的就显示头像  前端分类
			if(null != erpAuditUserRuntime.getAuditUserId() && 1 == erpAuditUserRuntime.getAuditStatus()) {
				archiveId = userArchiveMap.get(erpAuditUserRuntime.getAuditUserId());
				erpAuditUserRuntime.setUserPhoto(CommonUtil.getBbsPhoto(archiveMap.get(archiveId)));
			}

		}
		// 设置房源的信息到审核详情
		this.setCaseInfoForAudit(cityId, auditRuntime);
		this.setCaseSummaryInfo(auditRuntime);
        this.dealAuditCommentData(cityId, compId, auditRuntime);
		// 增加返回所属人archiveId  IM用
		Integer houseCustUserId = auditRuntime.getHouseCustUserId();
		ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(cityId, houseCustUserId);
		if (erpFunUsers != null) {
			auditRuntime.setHouseCustArchiveId(erpFunUsers.getArchiveId());
		}
		resultMap.put("auditInfo", auditRuntime);
		resultMap.put("auditUser", auditUserList);
		resultMap.put("transmitLogVO", transmitLog);
		return ErpResponseJson.ok(resultMap);
	}

	private void dealAuditCommentData(Integer cityId, Integer compId, ErpAuditRuntimeDto erpAuditRuntimeDto) {
		// 查询评论数据
		ErpAuditCommentExample erpAuditCommentExample = new ErpAuditCommentExample();
		erpAuditCommentExample.setShardCityId(cityId);
		erpAuditCommentExample.setOrderByClause(" CREATION_TIME ASC ");
		erpAuditCommentExample.createCriteria().andCompIdEqualTo(compId).andAuditIdEqualTo(erpAuditRuntimeDto.getId());
		List<ErpAuditComment> erpAuditComments = erpAuditCommentMapper.selectByExample(erpAuditCommentExample);
		List<Integer> commentIdList = erpAuditComments.stream().collect(Collectors.mapping(val -> val.getCommentId(), Collectors.toList()));
		if(commentIdList.size() > 0) {

			List<Integer> archiveIdList = erpAuditComments.stream().collect(Collectors.mapping(val -> val.getArchiveId(), Collectors.toList()));

			Map<Integer, AdminFunArchive> archiveMap = new HashMap<>();
			if(archiveIdList.size() > 0) {
				List<AdminFunArchive> archiveInfosByIds = adminFunArchiveMapper.getArchiveInfosByIds(archiveIdList);
				archiveMap = archiveInfosByIds.stream().collect(Collectors.toMap(val->val.getArchiveId(), val->val));
			}

			List<AuditDetailCommentVO> commentVOList = new ArrayList<>();
			ErpAuditCommentFileExample erpAuditCommentFileExample = new ErpAuditCommentFileExample();
			erpAuditCommentFileExample.setOrderByClause(" FILE_SEQ ");
			erpAuditCommentFileExample.setShardCityId(cityId);
			erpAuditCommentFileExample.createCriteria().andCompIdEqualTo(compId).andCommentIdIn(commentIdList);
			List<ErpAuditCommentFile> erpAuditCommentFiles = erpAuditCommentFileMapper.selectByExample(erpAuditCommentFileExample);
			Map<Integer, List<ErpAuditCommentFile>> collect = erpAuditCommentFiles.stream().collect(Collectors.groupingBy(val -> val.getCommentId(), Collectors.toList()));
			Map<Integer, AdminFunArchive> finalArchiveMap = archiveMap;
			erpAuditComments.stream().forEach(val-> {
                try {
                    AuditDetailCommentVO map = new AuditDetailCommentVO();
                    BeanUtils.copyProperties(map, val);
                    List<ErpAuditCommentFile> commentFileList = collect.get(val.getCommentId());
                    if(null != commentFileList && commentFileList.size() > 0) {
						// 处理地址
						commentFileList.stream().forEach(file -> {
							if(StringUtils.isNotBlank(file.getFileAddr())) {
								file.setFileAddr(AppConfig.getHousePicDomainPath(file.getFileAddr()));
							}
						});
					}
					AdminFunArchive adminFunArchive = finalArchiveMap.get(map.getArchiveId());
                    if(null != adminFunArchive) {
						if(StringUtils.isNotBlank(adminFunArchive.getUserPhoto())) {
							map.setUserPhoto(AppConfig.getUserPhotoPicDomainPath(adminFunArchive.getUserPhoto()));
						}
						map.setUserName(adminFunArchive.getUserName());
					}
					map.setFileList(commentFileList);
                    commentVOList.add(map);
                } catch (Exception e) {
                    e.printStackTrace();
                }

			});
            erpAuditRuntimeDto.setAuditCommentList(commentVOList);
		}
	}

	/**
	 * @Title 修改审批的描述文字
	 * @Author lcb
	 * @Time 2019/7/4 11:49
	 * @Desc
	 **/
	private void extendDealAuditRuntime(Integer cityId, ErpAuditRuntime auditRuntime) {

		DealAuditCommonParam dealParam = JSON.parseObject(auditRuntime.getParamJson(), DealAuditCommonParam.class);
		Integer auditType = dealParam.getAuditType();

		if(auditType != 8 &&
			auditType != 9 &&
			auditType != 10 &&
			auditType != 11 ) {
			return ;
		}


		String auditExplain = auditRuntime.getAuditExplain();
		GeneralParam generalParam = dealParam.getGeneralParam();

		ProcessFinancStatusParam processFinancStatusParam = dealParam.getProcessFinancStatusParam();
		String pfIds = processFinancStatusParam.getPfIds();
		if(StringUtils.isBlank(pfIds)) {
			return;
		}

		List<ErpProcessFinanc> erpProcessFinancs = erpProcessFinancMapper.selectProcessFinancByPfIds(cityId, generalParam.getCompId(), processFinancStatusParam.getPfActual(), processFinancStatusParam.getDealId(), processFinancStatusParam.getPfIds().split(","));

		if(erpProcessFinancs.size() == 0) {
			return;
		}
		// 1客户 2.业主
		List<ErpProcessFinanc> customerProcessFinanceList = erpProcessFinancs.stream().filter(val -> "1".equals(val.getPfPayer())).collect(Collectors.toList());
		List<ErpProcessFinanc> ownerProcessFinanceList = erpProcessFinancs.stream().filter(val -> "2".equals(val.getPfPayer())).collect(Collectors.toList());
		if(customerProcessFinanceList.size() > 0) {
			BigDecimal money = customerProcessFinanceList.stream().map(ErpProcessFinanc::getPayAmount).reduce(BigDecimal.ZERO, BigDecimal::add);

			if(new BigDecimal(money.intValue()).compareTo(money)==0){
				auditExplain +="：客户佣金"+money.intValue()+"元";
			}else{
				auditExplain +="：客户佣金"+money.doubleValue()+"元";
			}

		}

		if(ownerProcessFinanceList.size() > 0) {
			BigDecimal money = ownerProcessFinanceList.stream().map(ErpProcessFinanc::getPayAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
			if(auditExplain.contains("：")) {
				if(new BigDecimal(money.intValue()).compareTo(money)==0) {
					auditExplain +="，业主佣金"+money.intValue()+"元";
				}else {
					auditExplain +="，业主佣金"+money.doubleValue()+"元";
				}

			}else {
				if(new BigDecimal(money.intValue()).compareTo(money)==0) {
					auditExplain +="：业主佣金"+money.intValue()+"元";
				}else {
					auditExplain +="：业主佣金"+money.doubleValue()+"元";
				}

			}

		}
		auditRuntime.setAuditExplain(auditExplain);
	}
	
	/**
	 * 外出申请
	 * @author 张宏利
	 * @since 2017年10月16日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/createAuditForOaOut")
	public ErpResponseJson createAuditForOaOut(@Valid @RequestBody ErpOaOutAuditParam param) {
		Operator operator = getOperator();
		param.setCityId(operator.getCityId());
		param.setCompId(operator.getCompId());
		param.setSelfAreaId(operator.getAreaId());
		param.setSelfRegId(operator.getRegId());
		param.setSelfDeptId(operator.getDeptId());
		param.setSelfUserId(operator.getUserId());
		param.setSelfUserName(operator.getUserName());
		param.setSelfDeptName(operator.getDeptName());
		param.setSelfArchiveId(operator.getArchiveId());
		param.setSelfGrId(operator.getGrId());
		param.setCreateAuditDeptId(operator.getDeptId());
		param.setCreateAuditUserId(operator.getUserId());
		CreateAuditResultDto auditResultDto = erpAuditRuntimeService.createAuditRuntimeForOaOut(param);
		return ErpResponseJson.ok(auditResultDto);
	}
	
	/**
	 * 请假申请
	 * @author 张宏利
	 * @since 2017年10月16日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/createAuditForOaLeave")
	public ErpResponseJson createAuditForOaLeave(@Valid @RequestBody ErpOaLeaveAuditParam param) {
		Operator operator = getOperator();
		param.setCityId(operator.getCityId());
		param.setCompId(operator.getCompId());
		param.setSelfAreaId(operator.getAreaId());
		param.setSelfRegId(operator.getRegId());
		param.setSelfDeptId(operator.getDeptId());
		param.setSelfUserId(operator.getUserId());
		param.setSelfUserName(operator.getUserName());
		param.setSelfDeptName(operator.getDeptName());
		param.setSelfArchiveId(operator.getArchiveId());
		param.setSelfGrId(operator.getGrId());
		param.setCreateAuditDeptId(operator.getDeptId());
		param.setCreateAuditUserId(operator.getUserId());
		CreateAuditResultDto auditResultDto = erpAuditRuntimeService.createAuditRuntimeForOaLeave(param);
		return ErpResponseJson.ok(auditResultDto);
	}
	
	/**
	 * 根据租售类型获取需要审核的项
	 * @param caseType
	 * @param caseType2 
	 * @return
	 */
	private Map<Byte, String> getAuditType(Integer auditResource, Integer caseType) {
		/**这里的增删改要同步给前端的筛选*/
		Map<Byte, String> allAuditType = new LinkedHashMap<>();
		if(auditResource == 1) {
			allAuditType.putAll(Const.AUDIT_TRACK_TYPE_MAP);
			if(Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
				allAuditType.remove(Const.DIC_TRACK_TYPE_DAIKAN);
				allAuditType.remove(Const.DIC_TRACK_TYPE_STATUS_TRANSSALE);
				allAuditType.remove(Const.DIC_TRACK_TYPE_RENT);
			} else if(Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
				allAuditType.remove(Const.DIC_TRACK_TYPE_DAIKAN);
				allAuditType.remove(Const.DIC_TRACK_TYPE_STATUS_TRANSLEASE);
			} else if(Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType) || Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
				allAuditType.remove(Const.DIC_TRACK_TYPE_FUNCAN);
				allAuditType.remove(Const.DIC_TRACK_TYPE_LIMITED);
				allAuditType.remove(Const.DIC_TRACK_TYPE_ALONE);
				allAuditType.remove(Const.DIC_TRACK_TYPE_STATUS_TRANSSALE);
				allAuditType.remove(Const.DIC_TRACK_TYPE_STATUS_TRANSLEASE);
				allAuditType.remove(Const.DIC_TRACK_TYPE_GENERAL_ENTRUSTMENT);
				allAuditType.remove(Const.DIC_TRACK_TYPE_UPDATE_HOUSE_BUILD);
				allAuditType.remove(Const.DIC_TRACK_TYPE_SUBMIT_KEY);
				allAuditType.remove(Const.DIC_TRACK_TYPE_BORROW_KEY);
				allAuditType.remove(Const.DIC_TRACK_TYPE_RETURN_KEY);
				allAuditType.remove(Const.DIC_TRACK_TYPE_DESTROY_KEY);
				allAuditType.remove(Const.DIC_TRACK_TYPE_RENT);
				allAuditType.remove(Const.DIC_TRACK_TYPE_BARGAIN);
				allAuditType.remove(Const.DIC_TRACK_TYPE_PRIVATE_TRANSFER);
			}
		/**这里的增删改要同步给前端的筛选*/
		} else if(auditResource == 2) {
			allAuditType.putAll(Const.AUDIT_OA_LEAVE_TYPE_MAP);
		} else if(auditResource == 3) {
			allAuditType.putAll(Const.AUDIT_OA_OUT_TYPE_MAP);
		}
		return allAuditType;
	}
	
	/**
	 * 设置房源的信息到审核详情
	 * @author 张宏利
	 * @since 2017年11月13日
	 * @param cityId
	 * @param auditRuntime
	 */
	private void setCaseInfoForAudit(Integer cityId, ErpAuditRuntimeDto auditRuntime) {
		Integer caseId = auditRuntime.getCaseId();
		Integer caseType = auditRuntime.getCaseType();
		CaseInfoDto caseInfoDto = erpFunTrackService.getCaseInfoById(cityId, caseId, caseType);
		if(Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			ErpFunSale erpFunSale = caseInfoDto.getErpFunSale();
			auditRuntime.setBuildName(erpFunSale.getBuildName());
			auditRuntime.setUseage(erpFunSale.getSaleUseage());
			auditRuntime.setHouseArea(erpFunSale.getSaleArea());
			auditRuntime.setHouseRoom(erpFunSale.getSaleRoom());
			auditRuntime.setHouseHall(erpFunSale.getSaleHall());
			auditRuntime.setHouseFitment(erpFunSale.getSaleFitment());
			auditRuntime.setHouseDirect(erpFunSale.getSaleDirect());
			auditRuntime.setHouseTotalPrice(erpFunSale.getSaleTotalPrice());
			auditRuntime.setHouseCustUserId(erpFunSale.getUserId());
			auditRuntime.setHouseCustDeptId(erpFunSale.getDeptId());
		}else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			ErpFunLease erpFunLease = caseInfoDto.getErpFunLease();
			auditRuntime.setBuildName(erpFunLease.getBuildName());
			auditRuntime.setUseage(erpFunLease.getLeaseUseage());
			auditRuntime.setHouseArea(erpFunLease.getLeaseArea());
			auditRuntime.setHouseRoom(erpFunLease.getLeaseRoom());
			auditRuntime.setHouseHall(erpFunLease.getLeaseHall());
			auditRuntime.setHouseFitment(erpFunLease.getLeaseFitment());
			auditRuntime.setHouseDirect(erpFunLease.getLeaseDirect());
			auditRuntime.setHouseTotalPrice(erpFunLease.getLeaseTotalPrice());
			auditRuntime.setHousePriceUnit(erpFunLease.getPriceUnit());
			auditRuntime.setHouseCustUserId(erpFunLease.getUserId());
			auditRuntime.setHouseCustDeptId(erpFunLease.getDeptId());
		}else if(Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
			ErpFunBuyCustomer erpFunBuyCustomer= caseInfoDto.getErpFunBuyCustomer();
			auditRuntime.setHouseAreaLow(erpFunBuyCustomer.getHouseAreaLow());
			auditRuntime.setHouseAreaHigh(erpFunBuyCustomer.getHouseAreaHigh());
			auditRuntime.setHousePriceLow(erpFunBuyCustomer.getHousePriceLow());
			auditRuntime.setHousePriceHigh(erpFunBuyCustomer.getHousePriceHigh());
			auditRuntime.setHouseFitment(erpFunBuyCustomer.getHouseFitment());
			auditRuntime.setHouseCustUserId(erpFunBuyCustomer.getUserId());
			auditRuntime.setHouseRoomLow(erpFunBuyCustomer.getHouseRoom());
			auditRuntime.setHouseRoomHigh(erpFunBuyCustomer.getHouseRoom1());
			auditRuntime.setCustName(erpFunBuyCustomer.getBuyCustName());
			auditRuntime.setHouseCustDeptId(erpFunBuyCustomer.getDeptId());
			auditRuntime.setUserSex(erpFunBuyCustomer.getBuyCustSex() != null && erpFunBuyCustomer.getBuyCustSex() ? 1 : 0);
		}else if(Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
			ErpFunRentCustomer erpFunRentCustomer = caseInfoDto.getErpFunRentCustomer();
			auditRuntime.setHouseAreaLow(erpFunRentCustomer.getHouseAreaLow());
			auditRuntime.setHouseAreaHigh(erpFunRentCustomer.getHouseAreaHigh());
			auditRuntime.setHousePriceLow(erpFunRentCustomer.getHousePriceLow());
			auditRuntime.setHousePriceHigh(erpFunRentCustomer.getHousePriceHigh());
			auditRuntime.setHouseRoomLow(erpFunRentCustomer.getHouseRoom());
			auditRuntime.setHouseRoomHigh(erpFunRentCustomer.getHouseRoom1());
			auditRuntime.setHouseFitment(erpFunRentCustomer.getHouseFitment());
			auditRuntime.setHouseCustUserId(erpFunRentCustomer.getUserId());
			auditRuntime.setCustName(erpFunRentCustomer.getRentCustName());
			auditRuntime.setHouseCustDeptId(erpFunRentCustomer.getDeptId());
			auditRuntime.setUserSex(erpFunRentCustomer.getRentCustSex() != null && erpFunRentCustomer.getRentCustSex() ? 1 : 0);
		}
		if(Const.DIC_CASE_TYPE_SALE_FUN.equals(auditRuntime.getCaseType())||Const.DIC_CASE_TYPE_LEASE_FUN.equals(auditRuntime.getCaseType())) {
			List<ErpFunTrackExtend> erpFunTrackExtendList = erpFunTrackExtendMapper.selectByAuditId(cityId, auditRuntime.getCompId(), auditRuntime.getId());
			if(null != erpFunTrackExtendList && erpFunTrackExtendList.size() > 0 ){
				ErpFunTrackExtend erpFunTrackExtend = erpFunTrackExtendList.get(0);
				auditRuntime.setFitmentDescribe(erpFunTrackExtend.getFitmentDescribe());
				auditRuntime.setCoreSellPoint(erpFunTrackExtend.getCoreSellPoint());
				auditRuntime.setLayoutIntroduce(erpFunTrackExtend.getLayoutIntroduce());
				auditRuntime.setPropertyRights(erpFunTrackExtend.getPropertyRights());
				auditRuntime.setOtherInfo(erpFunTrackExtend.getOtherInfo());
			}
		}
	}
	
	private void setCaseSummaryInfo(ErpAuditRuntimeDto auditRuntime) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer houseId = auditRuntime.getCooperateTargetId();
        Byte auditResource = auditRuntime.getAuditResource();
        if (houseId == null&&auditResource!=8) {
			houseId = auditRuntime.getTargetId();
		}
		Integer caseType = auditRuntime.getCaseType();
		if (null != houseId) {
			String caseSummaryInfo = "";
			if (caseType == Const.HouseCustType.BUY_CUST) {
				ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, houseId);
				String buildName = erpFunSale.getBuildName();
				Byte room = erpFunSale.getSaleRoom();
				Double area = erpFunSale.getSaleArea().doubleValue();
				Double totalPrice = erpFunSale.getSaleTotalPrice().doubleValue();
				caseSummaryInfo = buildName + " " + (room == null ? "" : (room + "室 ")) 
						+ NumberHelper.formatNumber(area,NumberHelper.NUMBER_IN_2) + "㎡ "
						+ NumberHelper.formatNumber(totalPrice,NumberHelper.NUMBER_IN_2) + "万";
			}else if (caseType == Const.HouseCustType.RENT_CUST) {
				ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, houseId);
				String buildName = erpFunLease.getBuildName();
				Byte room = erpFunLease.getLeaseRoom();
				Double area = erpFunLease.getLeaseArea().doubleValue();
				Double totalPrice = erpFunLease.getLeaseTotalPrice() == null ? 0 : erpFunLease.getLeaseTotalPrice().doubleValue();
				caseSummaryInfo = buildName + " " + (room == null ? "" : (room + "室 ")) 
						+ NumberHelper.formatNumber(area,NumberHelper.NUMBER_IN_2) + "㎡ "
						+ NumberHelper.formatNumber(totalPrice,NumberHelper.NUMBER_IN_2)
						+ erpDicDefdinitionsService.getErpDicCnMsg("PRICE_UNIT", StringUtil.parseInteger(erpFunLease.getPriceUnit()), cityId);
			}
			auditRuntime.setCaseSummaryInfo(caseSummaryInfo);
		} else {
			auditRuntime.setCaseSummaryInfo(auditRuntime.getDkHouseInfo());
		}
	}

	/**
	 * 查询合同详情
	 * lcb
	 *  @Param
	 * **/
	@ApiOperation("查询合同审批配置")
	@PostMapping("/getAuditConfigList")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = AuditConfigVO.class, message = "成功")
	})
	@ResponseBody
	public ResponseJson getAuditConfigList(@RequestBody AuditConfigParam param) {
		AuditConfigVO dealAuditConfigVO = new AuditConfigVO();

		/**
		 * 1.查询审批模板
		 * 2.查询审核人模板
		 * 3.组装数据，有审批且有审核人的才算有效配置
		 **/
		Operator operator = getOperator();
		boolean isFangJidi = operator.isFangJidi();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		// 审批模板
		List<ErpAuditTemplateDto> businessAuditTemplate = erpAuditTemplateMapper.getBusinessAuditTemplate(cityId, compId, null, param.getAuditResource());
		Map<Integer, ErpAuditTemplateDto> auditTemplateDtoMap = new HashMap<>();
		Map<Integer, List<ErpAuditUserTemplate>> auditUserTemplateHashMap = new HashMap<>();
		List<ErpAuditUserTemplate> erpAuditUserTemplates = new ArrayList<>();
		if(businessAuditTemplate.size() > 0) {
			List<Integer> classIdList = businessAuditTemplate.stream().collect(Collectors.mapping(val->val.getClassId(), Collectors.toList()));
			auditTemplateDtoMap = businessAuditTemplate.stream().collect(Collectors.toMap(val->val.getAuditType(), val->val,(o, n) -> n));

			if (isFangJidi) {
				ErpAuditProcessExample erpAuditProcessExample = new ErpAuditProcessExample();
				erpAuditProcessExample.setShardCityId(cityId);
				erpAuditProcessExample.createCriteria().andCompIdEqualTo(compId)
						.andAuditResourceEqualTo(param.getAuditResource().byteValue()).andIsDelEqualTo((byte) 0);
				List<ErpAuditProcess> auditProcesses = erpAuditProcessMapper.selectByExample(erpAuditProcessExample);

				List<Integer> processIds = auditProcesses.stream().map(ErpAuditProcess::getId).collect(Collectors.toList());
				if (CollectionUtils.isNotEmpty(processIds)) {
					// 查询审核人员
					ErpAuditUserTemplateExample userTemplateExample = new ErpAuditUserTemplateExample();
					userTemplateExample.setShardCityId(cityId);
					userTemplateExample.createCriteria().andAuditProcessIdIn(processIds);
					erpAuditUserTemplates = erpAuditUserTemplateMapper.selectByExample(userTemplateExample);
					// 这里为了找下环节有没有配置审核人
					auditUserTemplateHashMap = erpAuditUserTemplates.stream().collect(Collectors.groupingBy(ErpAuditUserTemplate::getAuditProcessId, Collectors.toList()));
				}
			} else {
				// 查询审核人员
				ErpAuditUserTemplateExample userTemplateExample = new ErpAuditUserTemplateExample();
				userTemplateExample.setShardCityId(cityId);
				userTemplateExample.createCriteria().andClassIdIn(classIdList);
				erpAuditUserTemplates = erpAuditUserTemplateMapper.selectByExample(userTemplateExample);
				// 这里为了找下环节有没有配置审核人
				auditUserTemplateHashMap = erpAuditUserTemplates.stream().collect(Collectors.groupingBy(val->val.getClassId(), Collectors.toList()));
			}
		}

		List<AuditConfigTypeVO> list = new ArrayList<>();
		// 所有配置
		Set<Integer> auditTypeSet = Const.AUDIT_DEAL_TYPE_MAP.keySet();
		for (Integer auditType : auditTypeSet) {
			String auditTypeDesc = Const.AUDIT_DEAL_TYPE_MAP.get(auditType);
			AuditConfigTypeVO dealAuditConfigTypeVO = new AuditConfigTypeVO();
			dealAuditConfigTypeVO.setAuditType(auditType);

			switch (auditType) {
                case 1: {
                    auditTypeDesc = "合同初审";
                    break;
                }
                case 2: {
                    auditTypeDesc = "合同复审";
                    break;
                }
                case 3: {
                    auditTypeDesc = "合同结算";
                    break;
                }
				case 8: {
					auditTypeDesc = "应收应付审核";
					break;
				}
				case 9: {
					auditTypeDesc = "实收实付审核";
					break;
				}
				case 10: {
					auditTypeDesc = "撤销应收应付审核";
					break;
				}
				case 11: {
					auditTypeDesc = "撤销实收实付审核";
					break;
				}
			}
			dealAuditConfigTypeVO.setAuditTypeDes(auditTypeDesc);
			dealAuditConfigTypeVO.setConfigured(0);
			ErpAuditTemplateDto erpAuditTemplateDto = auditTemplateDtoMap.get(auditType);
			if (isFangJidi) {
				if(null != erpAuditTemplateDto) {
					List<ErpAuditUserTemplate> erpAuditUserTemplates1 = auditUserTemplateHashMap.get(erpAuditTemplateDto.getAuditProcessId());
					if(null != erpAuditUserTemplates1 && erpAuditUserTemplates1.size() > 0) {
						dealAuditConfigTypeVO.setConfigured(1);
					}
				}
			} else {
				if(null != erpAuditTemplateDto) {
					List<ErpAuditUserTemplate> erpAuditUserTemplates1 = auditUserTemplateHashMap.get(erpAuditTemplateDto.getClassId());
					if(null != erpAuditUserTemplates1 && erpAuditUserTemplates1.size() > 0) {
						dealAuditConfigTypeVO.setConfigured(1);
					}
				}
			}

			list.add(dealAuditConfigTypeVO);
		}
		dealAuditConfigVO.setList(list);
		return ErpResponseJson.ok(dealAuditConfigVO);
	}

	/**
	 * 审核合同类审批
	 * lcb
	 *  @Param
	 * **/
	@ApiOperation("审核")
	@PostMapping("/audit")
	@ApiResponses(value = {
		@ApiResponse(code = Const.ResponseCode.SUCCESS, response = AuditVO.class, message = "成功")
	})
	@ResponseBody
	public ResponseJson audit(@RequestBody AuditParam param) throws Exception{
		Operator operator = getOperator();
		erpAuditRuntimeService.audit(operator.getCityId(), param.getId(),operator.getUserId(), param.getAuditStatus(),param.getTrackContent(),operator.newOrganizationType());
		return ErpResponseJson.ok();
	}

	public static void main(String[] args) {
		BigDecimal b = new BigDecimal("5241.0");
		if(new BigDecimal(b.intValue()).compareTo(b)==0){
			System.out.println("b 是整数");
			System.out.println(b.intValue());
		}else{
			System.out.println("b 是小数");
		}
	}


}



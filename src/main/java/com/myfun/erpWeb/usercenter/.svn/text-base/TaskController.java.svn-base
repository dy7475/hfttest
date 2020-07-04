package com.myfun.erpWeb.usercenter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.extension.framework.codis.util.CacheUtil;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dao.AdminFunCityMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.utils.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dto.ErpFunTaskDto;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.erpdb.ErpFunKeyService;
import com.myfun.service.business.erpdb.ErpFunTaskService;

import static com.myfun.utils.DateTimeHelper.getTimeNow;

/**
 * 任务控制器
 * @author 臧铁
 * @since 2017年7月4日
 */
@Controller
@RequestMapping("/usercenter")
public class TaskController extends BaseController{
	@Autowired private ErpFunOpersMapper erpFunOpersMapper;
	@Autowired private ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired private ErpFunTaskMapper erpFunTaskMapper;
	@Autowired private ErpFunTaskService erpFunTaskService;
	@Autowired private ErpFunSaleMapper erpFunSaleMapper;
	@Autowired private ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired private ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	@Autowired private ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
	@Autowired private ErpFunTrackMapper erpFunTrackMapper;
	@Autowired private ErpTrackUsersMapper erpTrackUsersMapper;
	@Autowired private ErpFunKeyMapper erpFunKeyMapper;
	@Autowired private ErpFunKeyService erpFunKeyService;
	@Autowired private ErpFunHouseBiddingMapper erpFunHouseBiddingMapper;
	@Autowired private ErpAuditUserRuntimeMapper erpAuditUserRuntimeMapper;
	@Autowired private AdminFunCityMapper adminFunCityMapper;
	@Autowired private AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired private ErpDicDefinitionsMapper erpDicDefinitionsMapper;
	@Autowired private CacheUtil cacheUtil;
	@Autowired private ErpSystemSettingLogsMapper erpSystemSettingLogsMapper;


	/**
	 * 获取审核任务列表
	 * @author 臧铁
	 * @param param  time 时间（全部=空 一周=2 一月=3 一季=4）	taskStatus   未审=1 已审=3 失效=4 全部=空
	 * @param param  deptId  部门ID	caseType   出售=1 出租=2 求购=3 求租=4 出售合同=101 出租合同=102
	 * @param param  trackType  跟进类型 	caseNO   任务编号
	 * @param param  userId  员工ID	userType   申请方还是接收方0=申请1=接收
	 * @since 2017年6月27日
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTaskList")
	public ResponseJson getTaskList(@Valid @RequestBody BaseMapParam param)  {
		param.setObject("taskType", Constants_DIC.DIC_TASK_TYPE_FLAG_1);
		param.setInteger("cityId", getOperator().getCityId());// 必须封装到param中  后面的方法会用到
		param.setInteger("curUserId", getOperator().getUserId());
		param.setInteger("curCompId", getOperator().getCompId());
		Integer curUserId = param.getInteger("curUserId");
		Integer cityId = param.getInteger("cityId");
		String timeS = param.getString("time");
		String taskStatus = param.getString("taskStatus");
		String trackType = param.getString("trackType");
		Integer deptId = param.getInteger("deptId");
		Integer curCompId = param.getInteger("curCompId");
		String caseNo = param.getString("caseNo");
		String caseType = param.getString("caseType");
		Set<String> userOpersMap = erpFunOpersMapper.getOpersByUserId(cityId, curUserId);
		boolean bizDataExamin = true;// 业务申请审核权
		boolean canExaminView = true;// 业务申请查看权
		boolean keyManage = true;// 钥匙接收、注销权
		if (!userOpersMap.contains("BIZ_DATA_EXAMIN_COMP") && !userOpersMap.contains("BIZ_DATA_EXAMIN_AREA")
				&& !userOpersMap.contains("BIZ_DATA_EXAMIN_REG") && !userOpersMap.contains("BIZ_DATA_EXAMIN_DEPT")
				&& !userOpersMap.contains("BIZ_DATA_EXAMIN_GROUP")) {
			bizDataExamin = false;
		}
		if (!userOpersMap.contains("BIZ_DATA_VIEW_COMP") && !userOpersMap.contains("BIZ_DATA_VIEW_AREA")
				&& !userOpersMap.contains("BIZ_DATA_VIEW_REG") && !userOpersMap.contains("BIZ_DATA_VIEW_DEPT")
				&& !userOpersMap.contains("BIZ_DATA_VIEW_GROUP")) {
			canExaminView = false;
		}
		if (!userOpersMap.contains("KEY_MANAGE_COMP") && !userOpersMap.contains("KEY_MANAGE_AREA")
				&& !userOpersMap.contains("KEY_MANAGE_REG") && !userOpersMap.contains("KEY_MANAGE_DEPT")) {
			keyManage = false;
		}

		this.packTaskCondition(deptId, caseType, param);
		String[] timeArr = DateConvert.getConditionDate(timeS);
		param.setString("colCreationTime1", timeArr[0]);
		param.setString("colCreationTime2", timeArr[1]);
		// 未审 1 NEW 处理中 2 DEAL 已审 3 COMPLETE 取消 4 CANCEL
		if (StringUtils.isNotBlank(taskStatus)) {
			param.setString("colTaskStatus", taskStatus);
		}
		if (StringUtils.isNotBlank(caseNo)) {
			param.setString("colCaseNo", caseNo);
		}
		// 只能查看钥匙的审核任务
		if (!bizDataExamin && !canExaminView && keyManage) {
			param.setObject("sqlTrackTypeInKey", new Byte[] {
					Const.DIC_TRACK_TYPE_KEY,//钥匙的提交
					Const.DIC_TRACK_TYPE_KEY_BORROW,//钥匙的借用
					Const.DIC_TRACK_TYPE_KEY_RETURN });//钥匙的归还
		} else {
			if (null != trackType && trackType.equals("WEITUO")) {// 委托管理查询
				param.setByte("colTrackType1", Const.DIC_TRACK_TYPE_LIMITED);
				param.setByte("colTrackType2", Const.DIC_TRACK_TYPE_RENT);
			} else if (null != trackType && trackType.equals("KEY")) {// 钥匙管理查询
				param.setObject("colTrackType3", new Byte[] {
						Const.DIC_TRACK_TYPE_KEY,
						Const.DIC_TRACK_TYPE_KEY_BORROW,
						Const.DIC_TRACK_TYPE_KEY_RETURN });
			} else if (null != trackType && trackType.equals("VIEW")) {// 核心信息查看
				param.setByte("colTrackType4", Constants_DIC.DIC_TASK_TYPE_VIEWEXAMIN);
			} else if (null != trackType) {
				if (trackType.equals("FUNCAN")) {// 房勘任务
					param.setByte("colTrackType5", Const.DIC_TRACK_TYPE_FUNCAN);
				} else if (trackType.equals("DAIKAN")) {// 带看任务
					param.setByte("colTrackType6", Const.DIC_TRACK_TYPE_DAIKAN);
				} else if ("STATUS".equals(trackType)) {// 修改状态的审核任务
					param.setByte("colTrackType7", Const.DIC_TRACK_TYPE_STATUS);
				} else {
					param.setString("colTrackType8", trackType);
				}
			}
		}
		param.setString("colTypeFlag", Constants_DIC.DIC_TASK_TYPE_FLAG_1);// 表示是审核任务
		param.setInteger("colCompId", curCompId);
		// 如果这些权限都不具备那么只能查询出自己创建的审核任务，方便查看审核结果和处理过程。
		if (!bizDataExamin && !keyManage && !canExaminView) {
			param.setInteger("colCreatorUid", curUserId);
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<ErpFunTaskDto> erpFunTaskDtos = erpFunTaskMapper.getNewExaminTask(cityId, param.getMap());		
		Set<Integer> userIdSet = new HashSet<>();
		erpFunTaskDtos.stream().forEach(dto -> {
			userIdSet.add(dto.getCreatorUid());
		});
		if (userIdSet.size() > 0) {
			List<ErpFunUsers> userList = erpFunUsersMapper.getUserListByUserIds(cityId, userIdSet);
			// list转map
			Map<Integer, ErpFunUsers> userMap = userList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, user -> user));
			Set<Integer> deptIdset = new HashSet<>();
			userList.stream().forEach(user -> {
				deptIdset.add(user.getDeptId());
			});
			Map<Integer, ErpFunDepts> deptMap = new HashMap<>();
			if (userIdSet.size() > 0) {
				List<ErpFunDepts> deptList = erpFunDeptsMapper.getDeptListByDeptIds(cityId,deptIdset);
				deptMap = deptList.stream().collect(Collectors.toMap(ErpFunDepts::getDeptId, dept -> dept));
			}
			// 遍历组装数据
			for (ErpFunTaskDto erpFunTaskDto : erpFunTaskDtos) {
				if (!Constants_DIC.DIC_SYSTEM_USERID_999_INT.equals(erpFunTaskDto.getCreatorUid())) {
					ErpFunUsers erpFunUsers = userMap.get(erpFunTaskDto.getCreatorUid());// 发送人
					if (null != erpFunUsers) {
						erpFunTaskDto.setUserName(erpFunUsers.getUserName());
						ErpFunDepts erpFunDepts = deptMap.get(erpFunUsers.getDeptId());// 发送人所在门店
						if (null != erpFunDepts) {
							erpFunTaskDto.setDeptName(erpFunDepts.getDeptName());
						}
					}
				}
			}
		}
		PageInfo<ErpFunTaskDto> pageInfo = new PageInfo<ErpFunTaskDto>(erpFunTaskDtos);
		return ErpResponseJson.ok(pageInfo);
	}
	
	/**
	 * 审核任务和提醒任务包装查询任务条件
	 * @author 臧铁
	 * @param param  deptId  门店ID  caseType  类型
	 * @since 2017年6月28日
	 * @return
	 */
	private void packTaskCondition(Integer deptId, String caseType, BaseMapParam param) {
		String userType = param.getString("userType");// 申请方还是接收方0申请1接收
		Integer areaId = param.getInteger("areaId");
		Integer regId = param.getInteger("regId");
		Integer grId = param.getInteger("grId");
		String userId = param.getString("userId");
		String taskType = param.getString("taskType");
		Integer curCompId = param.getInteger("curCompId");
		Integer cityId = param.getInteger("cityId");
		if (StringUtils.isBlank(userId)) {
			userId = param.getString("cUserId");
		}
		if (StringUtils.isNotBlank(userType)) {
			if (StringUtils.isNotBlank(userId) && !"ALL".equals(userId)) {
				if ("0".equals(userType)) {// 申请方
					param.setString("pubColCreatorUid", userId);
				} else if ("1".equals(userType)) {// 接收方
					param.setString("pubColTaskOwner", userId);
				}
			} else {
				if ("0".equals(userType)) {// 申请方
					if (null != deptId) {
						param.setInteger("pubSqlCreatorUidInDeptId", deptId);
					} else {
						Set<Integer> deptIds = new HashSet<Integer>();
						if (null != regId || null != areaId) {
							ErpFunDepts erpFunDepts = new ErpFunDepts();
							erpFunDepts.setCompId(curCompId);
							erpFunDepts.setShardCityId(cityId);
							if (null != regId) {// 片区
								erpFunDepts.setRegId(regId);
							} else if (null != areaId) {// 大区
								erpFunDepts.setAreaId(areaId);
							}
							List<ErpFunDepts> list = erpFunDeptsMapper.getDeptListByCompId(erpFunDepts);
							for (ErpFunDepts dept : list) {
								deptIds.add(dept.getDeptId());
							}
						}
						if (null != deptIds && deptIds.size() > 0) {
							param.setObject("pubSqlCreatorUidInDepts", deptIds);
						} else if (null != grId) {// 分组
							param.setInteger("pubSqlCreatorUidInGrId", grId);
						}
					}
				} else if ("1".equals(userType)) {// 接收方
					if (null != deptId) {
						if (Constants_DIC.DIC_TASK_TYPE_FLAG_1.equals(taskType)) {
							param.setInteger("pubColDeptId", deptId);
						} else {
							param.setObject("pubSqlTaskOwnerInDeptId", deptId);
						}
					} else {
						Set<Integer> deptIds = new HashSet<Integer>();
						if (null != regId || null != areaId) {
							ErpFunDepts erpFunDepts = new ErpFunDepts();
							erpFunDepts.setCompId(curCompId);
							erpFunDepts.setShardCityId(cityId);
							if (null != regId) {// 片区
								erpFunDepts.setRegId(regId);
							} else if (null != areaId) {// 大区
								erpFunDepts.setAreaId(areaId);
							}
							List<ErpFunDepts> list = erpFunDeptsMapper.getDeptListByCompId(erpFunDepts);
							for (ErpFunDepts dept : list) {
								deptIds.add(dept.getDeptId());
							}
						}
						if (null != deptIds && deptIds.size() > 0) {
							if (Constants_DIC.DIC_TASK_TYPE_FLAG_1.equals(taskType)) {
								param.setObject("pubSqlDeptIdInDepts", deptIds);
							} else {
								param.setObject("pubSqlTaskOwnerInDepts", deptIds);
							}
						} else if (null != grId) {// 分组
							param.setInteger("pubSqlTaskOwnerInGrId", grId);
						}
					}
				}
			}
		}
		if (StringUtils.isNotBlank(caseType)) {
			if (caseType.contains(",")) {
				String[] caseTypeArr = caseType.split(",");
				param.setObject("pubSqlCaseTypeInArr", caseTypeArr);
			} else {
				param.setString("pubColCaseType", caseType);
			}
		}
	}
	
	/**
	 * 首页查询代办提醒列表
	 * @author 张宏利
	 * @since 2018年5月22日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getHomePageTaskList")
	public ResponseJson getHomePageTaskList(@Valid @RequestBody BaseMapParam param){
		param.setInteger("remindType", 1);
		param.setInteger("isRead", 0);
		param.setInteger("indexShow", 1);
		param.setString("time", Const.DIC_DATE_SEARCH_TYPE_MONTH);
		param.setPageOffset(1);
		param.setPageRows(10);
		return getWarmTaskListCommon(param);
	}
	
	/**
	 * 查询提醒我的任务列表
	 * @author 张宏利
	 * @since 2017年12月7日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getWarmMyTaskList")
	public ResponseJson getWarmMyTaskList(@Valid @RequestBody BaseMapParam param){
		param.setInteger("remindType", 1);
		return getWarmTaskListCommon(param);
	}
	
	/**
	 * 我创建的提醒列表
	 * @author 张宏利
	 * @since 2017年12月7日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getMyCreateWarmList")
	public ResponseJson getMyCreateWarmList(@Valid @RequestBody BaseMapParam param){
		param.setInteger("remindType", 2);
		return getWarmTaskListCommon(param);
	}
	
	/**
	 * 获取所有的提醒列表
	 * @author 张宏利
	 * @since 2017年12月7日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getWarmTaskList")
	public ResponseJson getWarmTaskList(@Valid @RequestBody BaseMapParam param){
		//如果是美联的需求会走这一段逻辑
		if(getOperator().isMeiLianApi()){
			String record = (String)cacheUtil.get("/erpWeb/usercenter/getWarmTaskList"
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
				erpSystemSettingLogs.setLogContent("查看了提醒任务");
				erpSystemSettingLogsMapper.insertSelective(erpSystemSettingLogs);
				cacheUtil.put("/erpWeb/usercenter/getWarmTaskList"
						+ getOperator().getArchiveId()+DateTimeHelper.formatDateTimetoString(new Date(),"yyy-MM-dd"),"1",86400);
			}
		}
		param.setInteger("remindType", 3);
		return getWarmTaskListCommon(param);
	}
	
	/**
	 * 查询提醒任务列表
	 * @author 臧铁
	 * @since 2017年7月4日
	 * @return
	 */
	public ResponseJson getWarmTaskListCommon(BaseMapParam param){
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer curCompId = operator.getCompId();
		Integer curUserId = operator.getUserId();
		String caseType = param.getString("caseType");
		String timeStr = param.getString("time");
		String keyword = param.getString("keyword");
		String startTime = param.getString("startTime");
		String endTime = param.getString("endTime");
		Integer isRead = param.getInteger("isRead", null);// 转成整形，失败赋值为null
		
		param.setInteger("isRead", isRead);
		param.setInteger("compId", curCompId);
		param.setInteger("curCompId", curCompId);
		param.setInteger("curUserId", curUserId);
		if(StringUtils.isNotBlank(timeStr)) {
			String[] timeArr = DateConvert.getConditionDate(timeStr);// timeS为空时返回当前时间-1985
			param.setString("startTime", timeArr[0]);
			param.setString("endTime", timeArr[1]);
		}
		if (StringUtils.isNotBlank(keyword)) {
			param.setString("keyword", "%" + keyword + "%");
		}
		if (getOperator().isPerLogin()) {
			param.setObject("taskTypeNotIn", new String[] { Constants_DIC.DIC_TASK_TYPE_WARRANT_REMIND});
			param.setObject("caseTypeNotIn", new String[] { Constants_DIC.DIC_CASE_TYPE_SALE_DEAL, Constants_DIC.DIC_CASE_TYPE_RENT_DEAL });
		}
		if (StringUtils.isNotBlank(caseType)) {
			param.setObject("caseTypes", caseType.split(","));
		}
		//朱科
		if (StringUtils.isBlank(timeStr)) {
			if (StringUtils.isNotBlank(startTime)) {
				param.setString("startTime", startTime + " 00:00:00");
			}
			if (StringUtils.isNotBlank(endTime)) {
				param.setString("endTime", endTime + " 23:59:59");
			}
		}
		//**********************组织架构改版********************************
		if (operator.newOrganizationType()) {       //代表查询新组织架构*
			if (null != param.getInteger("organizationId") && param.getInteger("organizationId") == 0) {
				param.setInteger("organizationId", null);
			}
			param.setInteger("organizationType",1);
		}
		//**********************组织架构改版********************************
		
		//结束时间统一比当前时间小
		param.setString("endTime",DateTimeHelper.formatDateTimetoString(new Date()));
		PageInfo<ErpFunTaskDto> pageInfo = erpFunTaskService.getWarmTaskList(cityId, param);
		List<ErpFunTaskDto> erpFunTaskDtos = pageInfo.getList();
		if (erpFunTaskDtos == null || erpFunTaskDtos.size() <= 0) {
			return ErpResponseJson.ok(pageInfo);
		}
		// 获取未读信息
		Set<Integer> taskIdSet = erpFunTaskDtos.stream().collect(Collectors.mapping(ErpFunTaskDto::getTaskId, Collectors.toSet()));
		List<Map<String, Object>> userCountList = erpFunTaskMapper.getNotReadUserCount(cityId, taskIdSet);
		Map<Integer, Integer> userCountMap = userCountList.stream().collect(Collectors.toMap(
				map -> StringUtil.parseInteger(map.get("taskId")),
				val -> StringUtil.parseInteger(val.get("counts"))));
		
		// 遍历每个提醒，以类型分类
		Map<Integer, ErpFunSale> saleMap = null;
		Map<Integer, ErpFunLease> leaseMap = null;
		Map<Integer, ErpFunBuyCustomer> buyMap = null;
		Map<Integer, ErpFunRentCustomer> rentMap = null;
		
		Map<Byte, List<ErpFunTaskDto>> caseTypeMap = erpFunTaskDtos.stream().filter(task -> null != task.getCaseType()).collect(Collectors.groupingBy(ErpFunTaskDto :: getCaseType));
		if (null != caseTypeMap) {
			List<ErpFunTaskDto> saleTask = caseTypeMap.get(Byte.valueOf("1"));
			List<ErpFunTaskDto> leaseTask = caseTypeMap.get(Byte.valueOf("2"));
			List<ErpFunTaskDto> buyTask = caseTypeMap.get(Byte.valueOf("3"));
			List<ErpFunTaskDto> rentTask = caseTypeMap.get(Byte.valueOf("4"));
			if (null != saleTask) {
				List<Integer> saleIdList = saleTask.stream().map(ErpFunTaskDto :: getCaseId).collect(Collectors.toList());
				if (!saleIdList.isEmpty()) {
					ErpFunSaleExample erpFunSaleExample = new ErpFunSaleExample();
					erpFunSaleExample.setShardCityId(cityId);
					erpFunSaleExample.createCriteria().andSaleIdIn(saleIdList);
					List<ErpFunSale> erpFunSaleList = erpFunSaleMapper.selectByExample(erpFunSaleExample);
					saleMap = erpFunSaleList.stream().collect(Collectors.toMap(ErpFunSale :: getSaleId, val -> val, (oldVal, newVal) -> oldVal));
				}
			}
			if (null != leaseTask) {
				List<Integer> leaseIdList = leaseTask.stream().map(ErpFunTaskDto :: getCaseId).collect(Collectors.toList());
				if (!leaseIdList.isEmpty()) {
					ErpFunLeaseExample erpFunLeaseExample = new ErpFunLeaseExample();
					erpFunLeaseExample.setShardCityId(cityId);
					erpFunLeaseExample.createCriteria().andLeaseIdIn(leaseIdList);
					List<ErpFunLease> erpFunLeaseList = erpFunLeaseMapper.selectByExample(erpFunLeaseExample);
					leaseMap = erpFunLeaseList.stream().collect(Collectors.toMap(ErpFunLease :: getLeaseId, val -> val, (oldVal, newVal) -> oldVal));
				}
			}
			if (null != buyTask) {
				List<Integer> buyIdList = buyTask.stream().map(ErpFunTaskDto :: getCaseId).collect(Collectors.toList());
				if (!buyIdList.isEmpty()) {
					ErpFunBuyCustomerExample erpFunBuyCustomerExample = new ErpFunBuyCustomerExample();
					erpFunBuyCustomerExample.setShardCityId(cityId);
					erpFunBuyCustomerExample.createCriteria().andBuyCustIdIn(buyIdList);
					List<ErpFunBuyCustomer> erpFunBuyCustomerList = erpFunBuyCustomerMapper.selectByExample(erpFunBuyCustomerExample);
					buyMap = erpFunBuyCustomerList.stream().collect(Collectors.toMap(ErpFunBuyCustomer :: getBuyCustId, val -> val, (oldVal, newVal) -> oldVal));
				}
			}
			if (null != rentTask) {
				List<Integer> rentIdList = rentTask.stream().map(ErpFunTaskDto :: getCaseId).collect(Collectors.toList());
				if (!rentIdList.isEmpty()) {
					ErpFunRentCustomerExample erpFunRentCustomerExample = new ErpFunRentCustomerExample();
					erpFunRentCustomerExample.setShardCityId(cityId);
					erpFunRentCustomerExample.createCriteria().andRentCustIdIn(rentIdList);
					List<ErpFunRentCustomer> erpFunRentCustomerList = erpFunRentCustomerMapper.selectByExample(erpFunRentCustomerExample);
					rentMap = erpFunRentCustomerList.stream().collect(Collectors.toMap(ErpFunRentCustomer :: getRentCustId, val -> val, (oldVal, newVal) -> oldVal));
				}
			}
		}
		
		// 查询人员信息
		Set<Integer> userIdSet = new HashSet<>();
		for (ErpFunTaskDto funTask : erpFunTaskDtos) {
			userIdSet.add(funTask.getCreatorUid());
			if(funTask.getTaskOwner() != null) {
				userIdSet.add(funTask.getTaskOwner());
			}
			String caseName = null;
			String caseArea = null;
			String casePrice = null;
			Byte room = null;
			String taskSubject = funTask.getTaskSubject();
			Byte caseTypeTemp = funTask.getCaseType();
			String caseNo = funTask.getCaseNo();
			if ((null != taskSubject && (taskSubject.contains("QZ") || taskSubject.contains("QG") || taskSubject.contains("CS") || taskSubject.contains("CZ"))) || StringUtil.isNotBlank(caseNo)) {
				if (Byte.valueOf("1").equals(caseTypeTemp) && null != saleMap) {
					ErpFunSale erpFunSale = saleMap.get(funTask.getCaseId());
					if (null != erpFunSale) {
						caseName = erpFunSale.getBuildName();
						caseArea = NumberHelper.formatNumber(Optional.ofNullable(erpFunSale.getSaleArea()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2) + "㎡ ";
						casePrice = NumberHelper.formatNumber(Optional.ofNullable(erpFunSale.getSaleTotalPrice()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2) + "万 ";
						room = erpFunSale.getSaleRoom();
					}
				}
				if (Byte.valueOf("2").equals(caseTypeTemp) && null != leaseMap) {
					ErpFunLease erpFunLease = leaseMap.get(funTask.getCaseId());
					if (null != erpFunLease) {
						String priceUnitStr = "元/月";
						if (null != erpFunLease.getPriceUnit()) {
							priceUnitStr = erpDicDefinitionsMapper.getDicCnMsg(cityId, "PRICE_UNIT", String.valueOf(erpFunLease.getPriceUnit()));
						}
						caseName = erpFunLease.getBuildName();
						caseArea = NumberHelper.formatNumber(Optional.ofNullable(erpFunLease.getLeaseArea()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2) + "㎡ ";
						casePrice = NumberHelper.formatNumber(Optional.ofNullable(erpFunLease.getLeaseTotalPrice()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2) + priceUnitStr + " ";
						room = erpFunLease.getLeaseRoom();
					}
				}
				if (Byte.valueOf("3").equals(caseTypeTemp) && null != buyMap) {
					ErpFunBuyCustomer erpFunBuyCustomer = buyMap.get(funTask.getCaseId());
					if (null != erpFunBuyCustomer) {
						caseName = erpFunBuyCustomer.getBuyCustName();
						Boolean caseSex = erpFunBuyCustomer.getBuyCustSex();
						caseName = StringUtil.isNotBlank(caseName) ? (caseName.substring(0, 1) + ((null != caseSex && caseSex) ? "先生" : "女士")) : caseName;
						String caseAreaLow = NumberHelper.formatNumber(Optional.ofNullable(erpFunBuyCustomer.getHouseAreaLow()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2);
						String caseAreaHigh = NumberHelper.formatNumber(Optional.ofNullable(erpFunBuyCustomer.getHouseAreaHigh()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2);
						caseArea = caseAreaLow + "-" + caseAreaHigh + "㎡ ";
						String casePriceLow = NumberHelper.formatNumber(Optional.ofNullable(erpFunBuyCustomer.getHousePriceLow()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2);
						String casePriceHigh = NumberHelper.formatNumber(Optional.ofNullable(erpFunBuyCustomer.getHousePriceHigh()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2);
						casePrice = casePriceLow + "-" + casePriceHigh + "万 ";
						room = erpFunBuyCustomer.getHouseRoom();
					}
				}
				if (Byte.valueOf("4").equals(caseTypeTemp) && null != rentMap) {
					ErpFunRentCustomer erpFunRentCustomer = rentMap.get(funTask.getCaseId());
					if (null != erpFunRentCustomer) {
						caseName = erpFunRentCustomer.getRentCustName();
						Boolean caseSex = erpFunRentCustomer.getRentCustSex();
						caseName = StringUtil.isNotBlank(caseName) ? (caseName.substring(0, 1) + ((null != caseSex && caseSex) ? "先生" : "女士")) : caseName;
						String caseAreaLow = NumberHelper.formatNumber(Optional.ofNullable(erpFunRentCustomer.getHouseAreaLow()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2);
						String caseAreaHigh = NumberHelper.formatNumber(Optional.ofNullable(erpFunRentCustomer.getHouseAreaHigh()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2);
						caseArea = caseAreaLow + "-" + caseAreaHigh + "㎡ ";
						String casePriceLow = NumberHelper.formatNumber(Optional.ofNullable(erpFunRentCustomer.getHousePriceLow()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2);
						String casePriceHigh = NumberHelper.formatNumber(Optional.ofNullable(erpFunRentCustomer.getHousePriceHigh()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2);
						casePrice = casePriceLow + "-" + casePriceHigh + "元 ";
						room = erpFunRentCustomer.getHouseRoom();
					}
				}
				String caseSummaryInfo = (null != caseName ? " " + caseName + " " : "") + (null != room ? room + "室 " : "") + (null != caseArea ? caseArea : "") + (null != casePrice ? casePrice : "");
				taskSubject = replaceTaskSubjectByRegex(taskSubject, caseSummaryInfo);
				funTask.setCaseSummaryInfo(caseSummaryInfo);
				funTask.setTaskSubject(taskSubject);
				funTask.setTaskDesc(replaceTaskSubjectByRegex(funTask.getTaskDesc(), caseSummaryInfo));
			}
			
			// 下面注释的代码为以前单种情况的逻辑，通用可用即可删
/*			String caseName = funTask.getCaseName();
			if ("3".equals(caseType) || "4".equals(caseType)) {
				Boolean caseSex = funTask.getCaseSex();
				caseName = StringUtil.isNotBlank(caseName) ? (caseName.substring(0, 1) + ((null != caseSex && caseSex) ? "先生" : "女士")) : caseName;
			}
			String caseArea = funTask.getCaseArea();
			String casePrice = funTask.getCasePrice();
			Byte room = funTask.getRoom();
			if (null != taskSubject && (taskSubject.contains("QZ") || taskSubject.contains("QG") || taskSubject.contains("CS") || taskSubject.contains("CZ"))) {
				if (null != caseArea) {
					if ("3".equals(caseType) || "4".equals(caseType)) {
						String caseAreaLow = null;
						String caseAreaHigh = null;
						String[] caseAreaArr = caseArea.split("-");
						if (caseAreaArr.length >= 2) {
							caseAreaLow = NumberHelper.formatNumber(StringUtil.parseDouble(caseAreaArr[0]), NumberHelper.NUMBER_IN_2);
							caseAreaHigh = NumberHelper.formatNumber(StringUtil.parseDouble(caseAreaArr[1]), NumberHelper.NUMBER_IN_2);
						}
						caseArea = (null != caseAreaLow && null != caseAreaHigh) ? caseAreaLow + "-" + caseAreaHigh + "㎡ " : "";
					} else {
						caseArea = NumberHelper.formatNumber(StringUtil.parseDouble(caseArea), NumberHelper.NUMBER_IN_2) + "㎡ ";
					}
				}
				if (null != casePrice) {
					if ("3".equals(caseType) || "4".equals(caseType)) {
						String casePriceLow = null;
						String casePriceHigh = null;
						String[] casePriceArr = casePrice.split("-");
						if (casePriceArr.length >= 2) {
							casePriceLow = NumberHelper.formatNumber(StringUtil.parseDouble(casePriceArr[0]), NumberHelper.NUMBER_IN_2);
							casePriceHigh = NumberHelper.formatNumber(StringUtil.parseDouble(casePriceArr[1]), NumberHelper.NUMBER_IN_2);
						}
						casePrice = (null != casePriceLow && null != casePriceHigh) ? casePriceLow + "-" + casePriceHigh + ("3".equals(caseType) ? "万 " : "元 ") : "";
					} else {
						String priceUnitStr = "元/月 ";
						if (null != funTask.getPriceUnit()) {
							priceUnitStr = erpDicDefinitionsMapper.getDicCnMsg(cityId, "PRICE_UNIT", String.valueOf(funTask.getPriceUnit()));
						}
						casePrice = NumberHelper.formatNumber(StringUtil.parseDouble(casePrice), NumberHelper.NUMBER_IN_2) + ("1".equals(caseType) ? "万 " : priceUnitStr);
					}
				}
				String caseSummaryInfo = " " + (null != caseName ? caseName : "") + " " + (null != room ? room + "室 " : "") + caseArea + casePrice;
				taskSubject = replaceTaskSubjectByRegex(taskSubject, caseSummaryInfo);
				funTask.setCaseSummaryInfo(caseSummaryInfo);
				funTask.setTaskSubject(taskSubject);
				funTask.setTaskDesc(replaceTaskSubjectByRegex(funTask.getTaskDesc(), caseSummaryInfo));
			}*/
		}
		
		List<ErpFunUsers> userList = erpFunUsersMapper.getUserListByUserIds(cityId, userIdSet);
		Map<Integer, ErpFunUsers> userMap = userList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, user -> user));
		// 遍历组装数据
		for (ErpFunTaskDto erpFunTaskDto : erpFunTaskDtos) {
			if (Const.DIC_SYSTEM_USERID_998.equals(erpFunTaskDto.getCreatorUid())) {
				erpFunTaskDto.setUserName(Const.DIC_SYSTEM_USERNAME_998);
			} else if (Const.DIC_SYSTEM_USERID_999.equals(erpFunTaskDto.getCreatorUid())) {
				erpFunTaskDto.setUserName("系统");
			} else {
				ErpFunUsers erpFunUsers = userMap.get(erpFunTaskDto.getCreatorUid());
				if (null != erpFunUsers) {
					erpFunTaskDto.setUserName(erpFunUsers.getUserName());
				}
			}
			// 设置提醒人，没有的时候再使用查询到的
			if (StringUtils.isBlank(erpFunTaskDto.getWarmUsers())) {
				ErpFunUsers erpFunUsers = userMap.get(erpFunTaskDto.getTaskOwner());
				if (null != erpFunUsers) {
					erpFunTaskDto.setWarmUsers(erpFunUsers.getUserName());
				}
			}
			// 未读人数
			erpFunTaskDto.setNotReadCount(userCountMap.get(erpFunTaskDto.getTaskId()));
		}
		return ErpResponseJson.ok(pageInfo);
	}
	
	/**
	 * 通过正则替换标题中的编号为房源概要信息
	 * @param taskSubject 标题
	 * @param caseSummaryInfo 概要信息
	 * @return
	 */
	private String replaceTaskSubjectByRegex(String taskSubject, String caseSummaryInfo) {
		if (StringUtils.isNotBlank(taskSubject)) {
			String regex = "编号为\\s*[CQ][GSZ][A-Z]{2}\\d{13}|[CQ][GSZ][A-Z]{2}\\d{13}";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(taskSubject);
			taskSubject = matcher.replaceAll(caseSummaryInfo);
		}
		return  taskSubject;
	}

	/**
	 * 获取一个任务的详细信息
	 * @author 臧铁
	 * @since 2017年7月5日
	 * @param param  taskId 任务ID
	 * @return
	 * @
	 */
	@ResponseBody
	@RequestMapping("/getTaskDetailInfo")
	public ResponseJson getTaskDetailInfo(@Valid @RequestBody BaseMapParam param) {
		Integer taskId = param.getInteger("taskId");
		Integer cityId = getOperator().getCityId();
		Integer curUserId = getOperator().getUserId();
		Integer curCompId = getOperator().getCompId();
		ErpFunTaskDto erpFunTaskDto = new ErpFunTaskDto();
		erpFunTaskDto.setShardCityId(cityId);
		erpFunTaskDto.setTaskId(taskId);
		erpFunTaskDto = erpFunTaskMapper.selectDtoByPrimaryKey(erpFunTaskDto);
		// 普通的提醒任务自动改为已阅
		// 申诉和合作回复不自动完成
		if (!Constants_DIC.DIC_TASK_TYPE_EXAMIN_INT.equals(erpFunTaskDto.getTaskType()) && curUserId.equals(erpFunTaskDto.getTaskOwner()) &&
			!Constants_DIC.DIC_TASK_TYPE_COMPLAINT_INT.equals(erpFunTaskDto.getTaskType()) && !Constants_DIC.DIC_TASK_TYPE_COLL_REMIND_INT.equals(erpFunTaskDto.getTaskType()) &&
			null != erpFunTaskDto.getIsRead() && false == erpFunTaskDto.getIsRead()) {// 跟踪审核、投诉提醒、合作提醒、非已读
			if (null != erpFunTaskDto.getTrackWarm() && false == erpFunTaskDto.getTrackWarm()) {// 跟进提醒
				erpFunTaskDto.setTaskStatus(Constants_DIC.DIC_TASK_STATUS_COMPLETE_BYTE);
				erpFunTaskDto.setIsRead(true);// 普通提醒任务直接标记为已读
				erpFunTaskDto.setUpdateUid(curUserId);
				erpFunTaskDto.setUpdateTime(new Date());
				erpFunTaskDto.setCompId(curCompId);
				erpFunTaskDto.setShardCityId(cityId);
				erpFunTaskMapper.updateByPrimaryKeySelective(erpFunTaskDto);
			}
		} else {// 不是自动标记为已读的查询 AREA_ID REG_ID
			// 这里应该返回房源的而不是房源创建人的
			Integer regId = null;
			Integer areaId = null;
			Integer grId = null;
			if (Constants_DIC.DIC_CASE_TYPE_SALE_FUN_BYTE.equals(erpFunTaskDto.getCaseType())) {
				ErpFunSale erpFunSale = new ErpFunSale();
				erpFunSale.setShardCityId(cityId);
				erpFunSale.setSaleId(erpFunTaskDto.getCaseId());
				ErpFunSale funSale = erpFunSaleMapper.selectByPrimaryKey(erpFunSale);
				if (null != funSale) {
					regId = funSale.getRegId();
					areaId = funSale.getAreaId();
					grId = funSale.getGrId();
				}
			} else if (Constants_DIC.DIC_CASE_TYPE_LEASE_FUN_BYTE.equals(erpFunTaskDto.getCaseType())) {
				ErpFunLease erpFunLease = new ErpFunLease();
				erpFunLease.setShardCityId(cityId);
				erpFunLease.setLeaseId(erpFunTaskDto.getCaseId());
				ErpFunLease funLease = erpFunLeaseMapper.selectByPrimaryKey(erpFunLease);
				if (null != funLease) {
					regId = funLease.getRegId();
					areaId = funLease.getAreaId();
					grId = funLease.getGrId();
				}
			} else if (Constants_DIC.DIC_CASE_TYPE_BUY_CUST_BYTE.equals(erpFunTaskDto.getCaseType())) {
				ErpFunBuyCustomer erpFunBuyCustomer = new ErpFunBuyCustomer();
				erpFunBuyCustomer.setShardCityId(cityId);
				erpFunBuyCustomer.setBuyCustId(erpFunTaskDto.getCaseId());
				ErpFunBuyCustomer buyCustomer = erpFunBuyCustomerMapper.selectByPrimaryKey(erpFunBuyCustomer);
				if (null != buyCustomer) {
					regId = buyCustomer.getRegId();
					areaId = buyCustomer.getAreaId();
					grId = buyCustomer.getGrId();
				}
			} else if (Constants_DIC.DIC_CASE_TYPE_RENT_CUST_BYTE.equals(erpFunTaskDto.getCaseType())) {
				ErpFunRentCustomerKey erpFunRentCustomer = new ErpFunRentCustomerKey();
				erpFunRentCustomer.setShardCityId(cityId);
				erpFunRentCustomer.setRentCustId(erpFunTaskDto.getCaseId());
				ErpFunRentCustomer rentCustomer = erpFunRentCustomerMapper.selectByPrimaryKey(erpFunRentCustomer);
				if (null != rentCustomer) {
					regId = rentCustomer.getRegId();
					areaId = rentCustomer.getAreaId();
					grId = rentCustomer.getGrId();
				}
			}
			erpFunTaskDto.setRegId(regId);
			erpFunTaskDto.setAreaId(areaId);
			erpFunTaskDto.setGrId(grId);
		}
		if (Constants_DIC.DIC_SYSTEM_USERID_998_INT.equals(erpFunTaskDto.getCreatorUid())) {
			erpFunTaskDto.setUserName(Constants_DIC.DIC_SYSTEM_USERNAME_998);
		} else if (!Constants_DIC.DIC_SYSTEM_USERID_999_INT.equals(erpFunTaskDto.getCreatorUid())) {// 任务里会出现999的userId
			ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(cityId,erpFunTaskDto.getCreatorUid());
			if (null != erpFunUsers) {
				erpFunTaskDto.setUserName(erpFunUsers.getUserName());
			}
		} else {
			erpFunTaskDto.setUserName("系统");
		}
		Integer trackId = erpFunTaskDto.getTrackId();
		if (null != trackId && trackId != 0) {
			ErpFunTrack erpFunTrack = new ErpFunTrack();
			erpFunTrack.setShardCityId(cityId);
			erpFunTrack.setTrackId(trackId);
			erpFunTrack = erpFunTrackMapper.selectByPrimaryKey(erpFunTrack);
			if (Const.DIC_TRACK_TYPE_DAIKAN.equals(erpFunTrack.getTrackType())) {
				// 查询带看的跟进人
				// 获取带看对象
				List<ErpTrackUsers> trackUsersList = erpTrackUsersMapper. getListByTrackIdAndCompId(cityId,trackId,curCompId);
				Map<String,List<String>> deptUsersMap = new HashMap<String,List<String>>();// 构造本条跟进的带看人部门和姓名map
				for (ErpTrackUsers trackUser : trackUsersList) {
					String deptName = trackUser.getDeptName();
					if (null == deptUsersMap.get(deptName)) {
						deptUsersMap.put(deptName, new ArrayList<String>());
					}
					deptUsersMap.get(deptName).add(trackUser.getUserName());
				}
				this.addTrackDeptsAndUsers(erpFunTaskDto,deptUsersMap);//为erpFunTaskDto添加trackDepts以及trackUsers
			} else if (Const.DIC_TRACK_TYPE_KEY.equals(erpFunTaskDto.getTrackType())) {
				// 1代表有钥匙的跟进,要审核的任务生成一把钥匙.
				// 0代表钥匙已经退还,这个时候不需要再次查询钥匙.
				String keyNum = "";
				if (Constants_DIC.DIC_TASK_STATUS_NEW_BYTE.equals(erpFunTaskDto.getTaskStatus()) && null != erpFunTrack.getTrackKey() && true == erpFunTrack.getTrackKey()) {// 为true说明钥匙还没有被注销或者退还
					ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(cityId,erpFunTaskDto.getCreatorUid());
					// 新生成钥匙编号
					keyNum = erpFunTrack.getKeyNum();// 使用提交任务时的钥匙编号
					if(StringUtils.isBlank(keyNum)){
						keyNum = erpFunKeyService.getKeyNum(null, null, 1,curCompId,erpFunUsers.getDeptId(),cityId);//以提交钥匙申请人的DEPTID和USERID为主
					}
					if (null != erpFunTrack.getTargetDept()) {
						erpFunTaskDto.setKeyDeptId(erpFunTrack.getTargetDept());// 使用提交任务时的门店ID
					} else {// 默认钥匙的所属门店为任务的创建人
						erpFunTaskDto.setKeyDeptId(erpFunUsers.getDeptId());// 以提交钥匙申请人的DEPTID和USERID为主
					}
				} else if (Constants_DIC.DIC_TASK_STATUS_NEW_BYTE.equals(erpFunTaskDto.getTaskStatus()) && null != erpFunTrack.getTrackKey() && false == erpFunTrack.getTrackKey()) {// 退换钥匙任务
					// 查询出已有的钥匙编号-一般是作为查看历史审核任务 -- 钥匙借用和归还使用
					ErpFunKey conditionModel = new ErpFunKey();
					conditionModel.setCaseId(erpFunTrack.getCaseId());
					conditionModel.setCaseType(erpFunTrack.getCaseType());
					conditionModel.setCompId(curCompId);
					conditionModel = erpFunKeyMapper.selectKey(cityId, conditionModel);
					keyNum = conditionModel.getKeyNum();
					erpFunTaskDto.setKeyDeptId(conditionModel.getKeyDeptId());
				} else if (Constants_DIC.DIC_TASK_STATUS_COMPLETE_BYTE.equals(erpFunTaskDto.getTaskStatus()) && null != erpFunTaskDto.getKeyId()) {
					// 任务已审核
					ErpFunKey conditionModel = new ErpFunKey();
					conditionModel.setKeyId(erpFunTaskDto.getKeyId());
					conditionModel.setShardCityId(cityId);
					ErpFunKey erpFunKey = erpFunKeyMapper.selectByPrimaryKey(conditionModel);
					if (null != erpFunKey) {
						erpFunTaskDto.setKeyDeptId(erpFunKey.getKeyDeptId());
						keyNum = erpFunKey.getKeyNum();
					}
					keyNum = conditionModel.getKeyNum();
				}
				erpFunTrack.setKeyNum(keyNum);
			} 
//			erpFunTrack.setTrackWarm(null);
//			erpFunTrack.setDeptId(null);
			erpFunTaskDto.setCaseId(erpFunTrack.getCaseId());
			erpFunTaskDto.setCaseType(erpFunTrack.getCaseType());
			erpFunTaskDto.setCaseUserId(erpFunTrack.getCaseUserId());
			erpFunTaskDto.setProxyUrl(erpFunTrack.getProxyUrl());
			erpFunTaskDto.setKeyNum(erpFunTrack.getKeyNum());
			erpFunTaskDto.setCaseDeptId(erpFunTrack.getCaseDeptId());
			erpFunTaskDto.setCaseStatus(erpFunTrack.getCaseStatus());
			erpFunTaskDto.setDkPhotoCount(erpFunTrack.getDkPhotoCount());
			erpFunTaskDto.setIsDeltrack(erpFunTrack.getIsDeltrack());
			erpFunTaskDto.setIsUserTrack(erpFunTrack.getIsUserTrack());
			erpFunTaskDto.setTargetDept(erpFunTrack.getTargetDept());
			erpFunTaskDto.setTargetFlag(erpFunTrack.getTargetFlag());
			erpFunTaskDto.setTargetId(erpFunTrack.getTargetId());
			erpFunTaskDto.setTargetNo(erpFunTrack.getTargetNo());
			erpFunTaskDto.setTargetType(erpFunTrack.getTargetType());
			erpFunTaskDto.setTargetUseage(erpFunTrack.getTargetUseage());
			erpFunTaskDto.setTargetUserId(erpFunTrack.getTargetUserId());
			erpFunTaskDto.setTrackClassic(erpFunTrack.getTrackClassic());
			erpFunTaskDto.setTrackContent(erpFunTrack.getTrackContent());
			erpFunTaskDto.setTrackNo(erpFunTrack.getTrackNo());
			erpFunTaskDto.setTrackResult(erpFunTrack.getTrackResult());
			erpFunTaskDto.setTrackKey(erpFunTrack.getTrackKey());
			erpFunTaskDto.setIsDel(erpFunTrack.getIsDel());
			erpFunTaskDto.setFkPhotoCount(erpFunTrack.getFkPhotoCount());
		} else if (Const.DIC_TRACK_TYPE_KEY_BORROW.equals(erpFunTaskDto.getTrackType()) || Const.DIC_TRACK_TYPE_KEY_RETURN.equals(erpFunTaskDto.getTrackType())) {// 借用钥匙和归还钥匙
			if (null != erpFunTaskDto.getKeyId()) {
				ErpFunKey conditionModel = new ErpFunKey();
				conditionModel.setKeyId(erpFunTaskDto.getKeyId());
				conditionModel.setShardCityId(cityId);
				ErpFunKey erpFunKey = erpFunKeyMapper.selectByPrimaryKey(conditionModel);;
				if (null == erpFunKey) {
					throw new BusinessException("该钥匙可能已被注销！");
				}
				erpFunTaskDto.setKeyDeptId(erpFunKey.getKeyDeptId());
				erpFunTaskDto.setKeyNum(erpFunKey.getKeyNum());
			}
		}
		erpFunTaskDto.setBiddingStatus(0);
		Integer caseUserId = null;
		// 增加房源是否推广
		if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN_BYTE.equals(erpFunTaskDto.getCaseType())) {
			ErpFunSale erpFunSale = new ErpFunSale();
			erpFunSale.setShardCityId(cityId);
			erpFunSale.setSaleId(erpFunTaskDto.getCaseId());
			erpFunSale = erpFunSaleMapper.selectByPrimaryKey(erpFunSale);
			if (null != erpFunSale) {
				caseUserId = erpFunSale.getUserId();
				if (null != erpFunSale.getSendtoYouyou() && 1 == erpFunSale.getSendtoYouyou()) {
					// 查询是否有竞价
					ErpFunHouseBidding erpFunHouseBidding = new ErpFunHouseBidding();
					erpFunHouseBidding.setShardCityId(cityId);
					erpFunHouseBidding.setYyStatus(Constants_DIC.HOUSE_BIDDING_YY_STATUS_1_BYTE);
					erpFunHouseBidding.setHouseId(erpFunTaskDto.getCaseId());
					erpFunHouseBidding.setSaleLease(erpFunTaskDto.getCaseType());
					List<ErpFunHouseBidding> resList = erpFunHouseBiddingMapper.getBiddingListByCondition(erpFunHouseBidding);
					if (null != resList && resList.size() > 0) {
						erpFunTaskDto.setBiddingStatus(1);
					}
				}
			}
		}else if(Constants_DIC.DIC_CASE_TYPE_LEASE_FUN_BYTE.equals(erpFunTaskDto.getCaseType())) {
			ErpFunLease erpFunLease = new ErpFunLease();
			erpFunLease.setShardCityId(cityId);
			erpFunLease.setLeaseId(erpFunTaskDto.getCaseId());
			erpFunLease = erpFunLeaseMapper.selectByPrimaryKey(erpFunLease);
			if (null != erpFunLease) {
				caseUserId = erpFunLease.getUserId();
				if(null != erpFunLease.getSendtoYouyou() && 1 == erpFunLease.getSendtoYouyou()) {
					ErpFunHouseBidding erpFunHouseBidding = new ErpFunHouseBidding();
					erpFunHouseBidding.setShardCityId(cityId);
					erpFunHouseBidding.setYyStatus(Constants_DIC.HOUSE_BIDDING_YY_STATUS_1_BYTE);
					erpFunHouseBidding.setHouseId(erpFunTaskDto.getCaseId());
					erpFunHouseBidding.setSaleLease(erpFunTaskDto.getCaseType());
					List<ErpFunHouseBidding> resList = erpFunHouseBiddingMapper.getBiddingListByCondition(erpFunHouseBidding);
					if(null != resList && resList.size() > 0) {
						erpFunTaskDto.setBiddingStatus(1);
					}
				}
			}
		}
		erpFunTaskDto.setCaseUserId(caseUserId);
		erpFunTaskDto.setProxyUrl(StringUtils.isBlank(erpFunTaskDto.getProxyUrl()) ? "0" : "1");
		return ErpResponseJson.ok(erpFunTaskDto);
	}

	/**
	 * 更新提醒任务状态
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/9
	 */
	@ResponseBody
	@RequestMapping("/updateTaskWarmState")
	public ResponseJson updateTaskWarmState(@Valid @RequestBody BaseMapParam param) {
		String operType = param.getString("operType");
		Integer cityId=getOperator().getCityId();
		param.setString("warmTime",getTimeNow());
		param.setInteger("userId",getOperator().getUserId());
		param.setInteger("compId",getOperator().getCompId());

		String[] taskIds=null;
		if (operType==null) {
			throw new BusinessException("批量完成提醒任务时出错！原因：OPER_TYPE为空");
		}
		if ("BAT_TASK".equals(operType)) {// 批量完成指定的提醒任务
			String taskId = param.getString("taskIds");
			if (taskId==null) {
				throw new BusinessException("批量完成提醒任务时出错！原因：TASK_IDS为空");
			}
			taskIds=taskId.split(",");
		}
		param.setObject("taskIds",taskIds);
		erpFunTaskService.updateTaskStatus(cityId,param.getMap());
		return ErpResponseJson.ok();
	}

	/**
	 * 获取任务数量
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/8/6
	 */
	@ResponseBody
	@RequestMapping("/getTaskCount")
	public ResponseJson getTaskCount(@Valid @RequestBody BaseMapParam param) {
		Integer userId=getOperator().getUserId();
		Integer compId=getOperator().getCompId();
		Integer cityId=getOperator().getCityId();
		Integer archiveId=getOperator().getArchiveId();

		String times[] = DateConvert.getConditionDate(Const.DIC_DATE_SEARCH_TYPE_MONTH);
		int warmTask =erpFunTaskMapper.getWarmTaskCount(cityId,compId,userId,times[0],times[1]);
		int dealing = erpAuditUserRuntimeMapper.getAuditCount(cityId,userId,times[0],times[1]);
		String deptSuperEnd = (String) getOperator().getAttribute("deptSuperEnd");

		int superDue =this.detectSuperDue(cityId,archiveId,deptSuperEnd);

		HashMap<String,Object> hm = new HashMap<>();
		hm.put("warmingtask", warmTask);
		hm.put("dealingtask", dealing);
		hm.put("pastdue", superDue);
		List<Map<String, Object>> returnList = new ArrayList<>();
		returnList.add(hm);
		return ErpResponseJson.ok(returnList);
	}

	/**
	 * 检测增值服务是否过期
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/8/6
	 */
	private int detectSuperDue(Integer cityId, Integer archiveId, String deptSuperEnd) {
		String nowTime =getTimeNow();
		if (StringUtils.isNotBlank(deptSuperEnd)) {
			int deptDays = (int) DateTimeHelper.getDaysOfTwoDate(DateTimeHelper.parseToDate(deptSuperEnd), DateTimeHelper.parseToDate(nowTime));
			if (deptDays > 3) {
				return 0;
			}
		}
		AdminFunCity adminFunCity=adminFunCityMapper.getDataByCityId(cityId);
		if (adminFunCity.getSuperUser()) {
			return 0;
		}
		String superEnd=DateTimeHelper.formatDateTimetoString(DateTimeHelper.addDays(DateTimeHelper.getSystemDate(), -3), "yyyy-MM-dd");
		List<AdminFunArchive> adminFunArchiveList=adminFunArchiveMapper.getArchiveList(archiveId,nowTime,superEnd);
		if (adminFunArchiveList == null || adminFunArchiveList.isEmpty()) {
			return 0;
		} else {
			AdminFunArchive userEL = adminFunArchiveList.get(0);
			superEnd = DateTimeHelper.formatDateTimetoString(userEL.getSuperEnd(), "yyyy-MM-dd");
			int days = (int) DateTimeHelper.getDaysOfTwoDate(DateTimeHelper.parseToDate(superEnd),
					DateTimeHelper.parseToDate(nowTime));
			if (days > 0 && days <= 3) {
				return days;
			} else if (days > -3 && days <= 0) {
				return days - 1;
			}
		}
		return 0;

	}
	
	/**
	 * 生成带看人和带看门店
	 * @author 臧铁
	 * @since 2017年7月12日
	 * @param funTaskVO
	 * @param deptUsersMap
	 */
	private void addTrackDeptsAndUsers(ErpFunTaskDto erpFunTaskDto, Map<String, List<String>> deptUsersMap) {
		String daikanUsers = "";
		for(String deptName : deptUsersMap.keySet()){
			String userNameTmp = "";
			for(String userName : deptUsersMap.get(deptName)){
				userNameTmp = userNameTmp + userName + ",";
			}
			if(StringUtils.isNotBlank(userNameTmp)){
				userNameTmp = userNameTmp.substring(0,userNameTmp.length() - 1);
				daikanUsers = deptName + " " + userNameTmp + ";";
			}
		}
		if(StringUtils.isNotBlank(daikanUsers)){
			daikanUsers = daikanUsers.substring(0,daikanUsers.length() - 1);
		}
		erpFunTaskDto.setTrackUser(daikanUsers);
	}
	public static void main(String[] args) {
		ErpFunUsers erpFunUsers = null;
		String userName = (null != erpFunUsers?erpFunUsers.getUserName():"");
		System.err.println(userName);
	}
}
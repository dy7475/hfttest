package com.myfun.erpWeb.businesstools.keymanage;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.businesstools.param.BorrowKeyDetailParam;
import com.myfun.erpWeb.businesstools.param.GetKeyLogListParam;
import com.myfun.erpWeb.businesstools.vo.BorrowKeyDetailVO;
import com.myfun.erpWeb.businesstools.vo.ErpFunKeyOperationLogVo;
import com.myfun.erpWeb.managecenter.sysmanager.param.OrganizatQueryParam;
import com.myfun.erpWeb.usercenter.vo.ErpFunKeyOperationLogDto;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.CheckPartnerConfigDto;
import com.myfun.repository.erpdb.dto.ErpFunDeptsDto;
import com.myfun.repository.erpdb.dto.ErpFunKeyDto;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.mybatis.condition.BaseQuery;
import com.myfun.repository.support.mybatis.condition.Condition;
import com.myfun.repository.support.mybatis.condition.ConditionItem;
import com.myfun.service.business.erpdb.ErpFunKeyService;
import com.myfun.service.business.erpdb.ErpFunPartnerConfigService;
import com.myfun.service.business.erpdb.ErpUserOpersService;
import com.myfun.service.business.erpdb.bean.param.BorrowOrReturnKeyParam;
import com.myfun.service.business.erpdb.bean.param.CreateHouseKeyParam;
import com.myfun.service.business.erpdb.bean.param.DestroyKeyParam;
import com.myfun.service.business.erpdb.bean.param.ErpFunKeyParam;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
@Api(tags ="钥匙管理模块")
@RequestMapping(value="/businesstools/keyManage",method=RequestMethod.POST)
@RestController
public class FunKeyController extends BaseController{
	@Autowired
	ErpFunKeyService erpFunKeyService;
	@Autowired
	ErpFunKeyMapper erpFunKeyMapper;
	@Autowired
	ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	ErpFunKeyLogMapper erpFunKeyLogMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired
	ErpFunKeyOperationLogMapper erpFunKeyOperationLogMapper;
	@Autowired
	ErpFunPropertyKeyLogMapper erpFunPropertyKeyLogMapper;
	@Autowired
	private ErpFunPartnerConfigService erpFunPartnerConfigService;
	@Autowired
	private ErpUserOpersService erpUserOpersService;
	@Autowired
	private ErpBuildPermissionsMapper erpBuildPermissionsMapper;
	@Autowired
	private ErpFunOrganizationMapper erpFunOrganizationMapper;
	@Autowired
	private ErpFunOrganizationManagerMapper erpFunOrganizationManagerMapper;
	
	/**
	 * 获取出售钥匙管理列表
	 * @author 何传强
	 * @since 2017年9月1日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("获取出售钥匙管理列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunKeyDto.class, message = "成功")
	})
	@RequestMapping("/getSaleKeyManageList")
	public ResponseJson getSaleKeyManageList(@Valid @RequestBody ErpFunKeyParam param) {
		param.setCaseType(Const.DIC_CASE_TYPE_SALE_FUN);
		return getKeyManageListCommon(param);
	}

	@ApiOperation("出租钥匙列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunKeyDto.class, message = "成功")
	})
	@RequestMapping("/getLeaseKeyManageList")
	public ResponseJson getLeaseKeyManageList(@Valid @RequestBody ErpFunKeyParam param) {
		param.setCaseType(Const.DIC_CASE_TYPE_LEASE_FUN);
		return getKeyManageListCommon(param);
	}
	
	public ResponseJson getKeyManageListCommon(@RequestBody ErpFunKeyParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		param.setCompId(operator.getCompId());
		param.setCityId(operator.getCityId());
		// 精英版登录要使用用户ID查询
		param.setUserId(operator.isPersonalVersion() ? operator.getUserId() : null);
//		param.setUserId(null);
		Integer caseType = param.getCaseType();
		String tableType = Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType) ? "SALE" : "LEASE";

		Condition condition = new Condition();
		boolean isPersonalVersion = operator.isPersonalVersion();
		Integer organizationId = param.getOrganizationId();
		if (isPersonalVersion && param.getUserId() != null) {
			condition.add(new ConditionItem("A.USER_ID", "=", param.getUserId()));
		} else {
			condition.add(new ConditionItem("A.COMP_ID", "=", param.getCompId()));
			if ("BY_INFO".equals(param.getOperateType())) {// operateType代表根据钥匙所属还是房源所属来查byInfo代表按房源所属
				if (param.getAreaId() != null) {
					condition.add(new ConditionItem("B.AREA_ID", "=", param.getAreaId()));
				}
				if (param.getRegId() != null) {
					condition.add(new ConditionItem("B.REG_ID", "=", param.getRegId()));
				}
				if (param.getDeptId() != null) {
					condition.add(new ConditionItem("B.DEPT_ID", "=", param.getDeptId()));
				}
				if (null != organizationId && organizationId > 0) {
					condition.add(new ConditionItem("B.TISSUE_LINE", "LIKE", "%:"+param.getOrganizationId()+":%"));
				}
			} else {
				if (organizationId != null && organizationId > 0) {
					condition.add(new ConditionItem("A.KEY_DEPT_ID", "=", organizationId));
				}
			}
		}
		String keyNum = param.getKeyNo();
		if (StringUtils.isNotBlank(keyNum)) {
			condition.add(new ConditionItem("A.KEY_NUM", "=", keyNum));
		}
		String caseNo = param.getHouseNo();
		if (StringUtils.isBlank(caseNo)) {
			caseNo = param.getCaseNo();
		}
		if (StringUtils.isNotBlank(caseNo)) {
			String regex=".*[a-zA-Z]+.*";
			Matcher m= Pattern.compile(regex).matcher(caseNo);

			if (((caseNo.toUpperCase().startsWith("CS") || caseNo.toUpperCase().startsWith("CZ")) && caseNo.length() == 17) || m.matches()) {
				condition.add(new ConditionItem("A.CASE_NO", "=", caseNo));
			} else {
				condition.add(new ConditionItem("B.INNER_NO", "=", StringUtil.parseInteger(caseNo, 0).toString()));
			}
		}
		condition.add(new ConditionItem("A.KEY_STATUS", "!=", 3));
		if (param.getKeyType() != null) {
			condition.add(new ConditionItem("A.KEY_TYPE", "=", param.getKeyType()));
		}
		if(null == param.getOrganizationId()) {
			param.setOrganizationId(0);
		}
		if (param.getOrganizationId() != null && param.getOrganizationId() == 0) {
			OrganizatQueryParam queryParam = erpUserOpersService.checkOrgIdAndOperNewOrg(operator.getCityId(), operator.getCompId(), operator.getUserId(),
					caseType.byteValue(), "VIEW_ORGANIZATION_HOUSE_LIST_INFO", param.getOrganizationId(), operator.isSwitchCompLogin());

			if (queryParam != null && queryParam.getLimit() && CollectionUtils.isNotEmpty(queryParam.getQueryOrgIds())) {
				Set<Integer> orgIds = queryParam.getQueryOrgIds();
				condition.add(new ConditionItem("B.ORGANIZATION_ID", "IN", orgIds));
			}
		}

		BaseQuery baseQuery = new BaseQuery();
		baseQuery.addCondition(condition);
		baseQuery.setColumns(new String[] { 
				"A.*", "B.DEPT_ID as houseDeptId",
				"B." + tableType + "_ROOM as room",
				"B." + tableType + "_HALL as hall",
				"B." + tableType + "_WEI as wei",
				"B." + tableType + "_YANG as yang",
				"B." + tableType + "_FLOOR as floor",
				"B." + tableType + "_FLOORS as floors",
				"B." + tableType + "_AREA as area", 
				"B." + tableType + "_CHARACT as charact",
				"B." + tableType + "_TOTAL_PRICE as totalPrice",
				"B." + tableType + "_USEAGE as useage",
				"B." + tableType + "_LEVEL as houseLevel",
				"B." + tableType + "_STATUS as houseStatus",
				"B.USER_ID as houseUserId",
				"B.ORGANIZATION_ID as houseOrganizationId",
				"B.PLATE_TYPE as housePlateType",
				"B.BUILD_NAME",
				"B.BUILD_ID",
			});
		String tableName = "FUN_KEY A join FUN_" + tableType + " B on A.COMP_ID=B.COMP_ID AND A.CASE_ID=B." + tableType + "_ID"
				+ " AND A.CASE_TYPE=" + caseType;
		baseQuery.setTableName(tableName);
		baseQuery.setOrderByField("A.KEY_NUM ASC");
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<ErpFunKeyDto> list = erpFunKeyMapper.selectListByCondition(param.getCityId(), baseQuery);
			//添加判断是否钥匙提交人自己或直属领导,没有直属领导算上上级领导
		Set<Integer> keyUserIds = new HashSet<>();
		list.stream().filter(o->o.getUserId() != null).forEach(o->{
			keyUserIds.add(o.getUserId());
		});
		if(!keyUserIds.isEmpty()){
			List<ErpFunUsers> keyUsers = erpFunUsersMapper.getUserListByUserIds(cityId, keyUserIds);
			//获取直属领导管理的组织IDS，在获取直属领导对应的管理数据
			List<Integer> directlyManagerOrgIds = keyUsers.stream().map(ErpFunUsers::getOrganizationId).collect(Collectors.toList());
			Map<Integer, ErpFunUsers> keyUsersMap = keyUsers.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, o -> o));
			ErpFunOrganizationManagerExample managerExample = new ErpFunOrganizationManagerExample();
			managerExample.setShardCityId(cityId);
			managerExample.createCriteria().andCompIdEqualTo(operator.getCompId()).andOrganizationIdIn(directlyManagerOrgIds);
			List<ErpFunOrganizationManager> directlyLeaderManagers = erpFunOrganizationManagerMapper.selectByExample(managerExample);
			//获取直属领导的IDS，再查询直属领导的信息，确认是否被注销了
			List<Integer> directlyLeaderUserId = directlyLeaderManagers.stream().map(ErpFunOrganizationManager::getUserId).collect(Collectors.toList());
			List<Integer> directlyLeaderIdsNotWriteoff = new ArrayList<>();
			if(!directlyLeaderUserId.isEmpty()){
				ErpFunUsersExample userExample = new ErpFunUsersExample();
				userExample.setShardCityId(cityId);
				userExample.createCriteria().andCompIdEqualTo(operator.getCompId()).andUserIdIn(directlyLeaderUserId).andUserWriteoffEqualTo(false);
				List<ErpFunUsers> directlyLeaders = erpFunUsersMapper.selectByExample(userExample);
				if(!directlyLeaders.isEmpty()){
					List<Integer> collect = directlyLeaders.stream().map(ErpFunUsers::getUserId).collect(Collectors.toList());
					directlyLeaderIdsNotWriteoff.addAll(collect);
				}
			}
			//获取上上领导管理的组织IDS，在获取上上领导对应的管理数据
			List<Integer> upLeaderManagerOrgIds = keyUsers.stream().filter(o -> o.getTissueLine().split(":").length > 2)
					.map(o -> Integer.valueOf(o.getTissueLine().split(":")[o.getTissueLine().split(":").length - 2])).collect(Collectors.toList());
			List<ErpFunOrganizationManager> upLeaderManagers = new ArrayList<>();
			if(upLeaderManagerOrgIds.size()>0){
				managerExample.clear();
				managerExample.setShardCityId(cityId);
				managerExample.createCriteria().andCompIdEqualTo(operator.getCompId()).andOrganizationIdIn(upLeaderManagerOrgIds);
				upLeaderManagers.addAll(erpFunOrganizationManagerMapper.selectByExample(managerExample));
			}
			list.stream().forEach(o->{
				if(operator.getUserId().equals(o.getUserId())){
					o.setDirectlyLeaderOrSelf(Byte.valueOf("1"));
				}else if(o.getUserId() != null && o.getUserId() != 0){
					for (int i = 0; i < directlyLeaderManagers.size(); i++) {//如果是直属领导
						if(operator.getUserId().equals(directlyLeaderManagers.get(i).getUserId())
								&& directlyLeaderManagers.get(i).getOrganizationId().equals(keyUsersMap.get(o.getUserId()) == null ? -10086 : keyUsersMap.get(o.getUserId()).getOrganizationId())){
							o.setDirectlyLeaderOrSelf(Byte.valueOf("1"));
							break;
						}
					}
					List<ErpFunOrganizationManager> directlyLeaderManegersTemp = new ArrayList<>();
					directlyLeaderManagers.stream().filter(obj->obj.getOrganizationId().equals(keyUsersMap.get(o.getUserId()) == null ? -10086 : keyUsersMap.get(o.getUserId()).getOrganizationId())).forEach(obj->{
						if(directlyLeaderIdsNotWriteoff.contains(obj.getUserId())){//未注销的userIds包含当前的管理数据，包含则算有直属领导
							directlyLeaderManegersTemp.add(obj);
						}
					});
					if(directlyLeaderManegersTemp.isEmpty()){//如果没有直属领导找上上级领导
						for (int i = 0; i < upLeaderManagers.size(); i++) {
							if(operator.getUserId().equals(upLeaderManagers.get(i).getUserId()) && keyUsersMap.get(o.getUserId()) != null && keyUsersMap.get(o.getUserId()).getTissueLine().split(":").length >2
									&& upLeaderManagers.get(i).getOrganizationId()
									.equals(Integer.valueOf(keyUsersMap.get(o.getUserId()).getTissueLine().split(":")[keyUsersMap.get(o.getUserId()).getTissueLine().split(":").length-2]))){
								o.setDirectlyLeaderOrSelf(Byte.valueOf("1"));
								break;
							}
						}
					}
				};
			});
		}
		PageInfo<ErpFunKeyDto> pageInfo = new PageInfo<ErpFunKeyDto>(list);
		// 精英版直接返回
		if (isPersonalVersion) {
			return ErpResponseJson.ok(pageInfo);
		}
		
		// 获取能否查看钥匙凭证
		boolean canViewKeyVoucher = erpFunKeyService.judgeCanViewKeyVoucher(cityId, operator.getUserId(), caseType, null);
		
		List<ErpFunKeyDto> returnList = pageInfo.getList();
		// 盘源权限
		dealBuildPermissions(returnList);
		Set<Integer> keyIds = new HashSet<Integer>();//
		Set<Integer> deptIds = new HashSet<Integer>();//
		Set<Integer> userIds = new HashSet<Integer>();
		for (ErpFunKeyDto dto : returnList) {
			if (dto.getKeyId() != null) {
				keyIds.add(dto.getKeyId());
			}
			if (dto.getHouseOrganizationId() != null) {
				deptIds.add(dto.getHouseOrganizationId());
			}
			if (dto.getUserId() != null) {
				userIds.add(dto.getUserId());
			}
			if (!canViewKeyVoucher) {
				dto.setKeyVoucher(null);
			}
		}
		Map<Integer, ErpFunUsers> userMap = new HashMap<>();
		Map<Integer, ErpFunOrganization> organizationMap = new HashMap<>();
		Map<Integer, ErpFunKeyOperationLog> logMap = new HashMap<>();
		if (keyIds != null && !keyIds.isEmpty()) {
			List<ErpFunKeyOperationLog> erpFunKeyOperationLogList = erpFunKeyOperationLogMapper.getListByKeyIds(param.getCityId(), param.getCompId(), keyIds);
			if(null != erpFunKeyOperationLogList && erpFunKeyOperationLogList.size() > 0){
				for(ErpFunKeyOperationLog erpFunKeyOperationLog: erpFunKeyOperationLogList){
					logMap.put(erpFunKeyOperationLog.getKeyId(), erpFunKeyOperationLog);
					userIds.add(erpFunKeyOperationLog.getConfirmUser());
					userIds.add(erpFunKeyOperationLog.getOperationUser());
				}
			}
		}
		if (!userIds.isEmpty()) {
			List<ErpFunUsers> userList = erpFunUsersMapper.getUserListByUserIds(param.getCityId(),userIds);
			userMap = userList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, val -> val));
			userList.stream().forEach(user -> deptIds.add(user.getOrganizationId()));
		}
		if (CollectionUtils.isNotEmpty(deptIds)) {
			List<ErpFunOrganization> organizationlist = erpFunOrganizationMapper.selectOrgByOrgWithOrgIds(cityId, new ArrayList<>(deptIds));
			organizationMap = organizationlist.stream().collect(Collectors.toMap(ErpFunOrganization::getOrganizationId, val -> val));
		}
		List<Integer> outTimeIds = new ArrayList<>();
		for (ErpFunKeyDto dto : returnList) {
			//判断是否是外借 添加外借信息
			if (Const.OUT_BORROW.equals(dto.getLogType())){
				ErpFunPropertyKeyLog erpFunPropertyKeyLog = erpFunPropertyKeyLogMapper.selectKeyStatus(cityId,dto.getKeyLogId());
				if (erpFunPropertyKeyLog != null){
					if (erpFunPropertyKeyLog.getKeyStatus().equals(Const.LENDING)){
						if(System.currentTimeMillis() > erpFunPropertyKeyLog.getMaxBorrowTime().getTime()){
							erpFunPropertyKeyLog.setKeyStatus(Const.OUT_TIME);
							outTimeIds.add(erpFunPropertyKeyLog.getFunPropertyKeyLogId());
						}
					}
					dto.setKeyStatus(erpFunPropertyKeyLog.getKeyStatus().byteValue());
					dto.setBorrowUser(erpFunPropertyKeyLog.getBorrowName());
					dto.setLendUser(erpFunPropertyKeyLog.getUserName());
					dto.setBorrowTime(DateTimeHelper.formatDateTimetoString(erpFunPropertyKeyLog.getCreationTime()));
				}
			}
			if (organizationMap.size() > 0) {
				ErpFunOrganization organization = organizationMap.get(dto.getHouseOrganizationId());
				if (organization != null) {
					dto.setDeptName(organization.getOrganizationName());
				}
			}
			ErpFunUsers erpFunUsers = userMap.get(dto.getUserId());
			if (erpFunUsers != null) {
				dto.setCommitUser(erpFunUsers.getUserName());
				ErpFunOrganization erpFunOrganization = organizationMap.get(erpFunUsers.getOrganizationId());
				if(null != erpFunOrganization){
					dto.setCommitUserOrgName(erpFunOrganization.getOrganizationName());
				}

			}
			// 要是借出Constants_DIC.DIC_KEY_STATUS_LEND
			int keyStatus = Optional.ofNullable(dto.getKeyStatus()).orElse((byte)0).intValue();
			if (Const.DIC_KEY_STATUS_LEND.equals(keyStatus)) {
				ErpFunKeyOperationLog erpFunKeyOperationLog = logMap.get(dto.getKeyId());
				if (erpFunKeyOperationLog != null) {
					Integer borrowUser = erpFunKeyOperationLog.getOperationUser();
					Integer confirmUser = erpFunKeyOperationLog.getConfirmUser();
					if (userMap != null) {
						ErpFunUsers userTmp = userMap.get(borrowUser);
						if (userTmp != null) {
							if (dto.getBorrowUser() == null){
								dto.setBorrowUser(userTmp.getUserName());
							}
							dto.setBorrowUserMobile(userTmp.getUserMobile());
						}
						ErpFunUsers comfirmTemp = userMap.get(confirmUser);
						if(comfirmTemp != null){
							dto.setLendUser(comfirmTemp.getUserName());
						}
					}
					if (dto.getBorrowTime() == null){
						dto.setBorrowTime(DateTimeHelper.formatDateTimetoString(erpFunKeyOperationLog.getCreationTime()));
					}
				}
			}
		}
		//更新超时钥匙的日志状态
		if (!outTimeIds.isEmpty()){
			erpFunPropertyKeyLogMapper.updatePropertyKeyLogByIdIn(cityId,outTimeIds,Const.OUT_TIME);
		}
		return ErpResponseJson.ok(pageInfo);
	}
	
	/**
	 * 盘源权限
	 * @param list
	 */
    private void dealBuildPermissions(List<ErpFunKeyDto> list) {
    	Operator operator = getOperator();
		if (CollectionUtils.isEmpty(list)) {
			return;
		}
		List<Integer> buildIdList  = new ArrayList<>(list.stream().map(ErpFunKeyDto::getBuildId).collect(Collectors.toSet()));
		ErpBuildPermissionsExample erpBuildPermissionsExample = new ErpBuildPermissionsExample();
		erpBuildPermissionsExample.setShardCityId(operator.getCityId());
		erpBuildPermissionsExample.createCriteria().andCompIdEqualTo(operator.getCompId()).andOrganizationIdEqualTo(operator.getOrganizationId())
			.andBuildIdIn(buildIdList).andIsDelEqualTo(Byte.valueOf("0")).andViewPermissionEqualTo(Byte.valueOf("1"));
		List<ErpBuildPermissions> buildPermissionsList = erpBuildPermissionsMapper.selectByExample(erpBuildPermissionsExample);
		Map<Integer, ErpBuildPermissions> buildPermissionsMap = buildPermissionsList.stream().collect(HashMap::new,
				(m,b) -> m.put(b.getBuildId(), b), HashMap::putAll);
		for (ErpFunKeyDto erpFunKeyDto : list) {
			Integer buildId = erpFunKeyDto.getBuildId();
			String useage = StringUtil.toString(erpFunKeyDto.getUseage(), "");
			ErpBuildPermissions erpBuildPermissions = buildPermissionsMap.get(buildId);
			if (erpBuildPermissions != null && erpBuildPermissions.getHouseUseage().contains(useage)) {
				erpFunKeyDto.setViewPermission(1);
			}
		}
	}
	
	/**
	 * 获取钥匙日志列表
	 * @author 何传强
	 * @since 2017年9月1日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("获取钥匙日志列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunKeyOperationLogVo.class, message = "成功")
	})
	@RequestMapping("/getKeyLogList")
	@NotBlank({"keyId"})
	public ResponseJson getKeyLogList(@RequestBody GetKeyLogListParam param) throws Exception{
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer currentUserId = operator.getUserId();
		Integer currentDeptId = operator.getDeptId();
		PageHelper.startPage(param.getPageOffset(),param.getPageRows(), param.isNeedCount());
		List<ErpFunKeyOperationLogDto> list = erpFunKeyOperationLogMapper.getFunKeyOperationLogRecordList(getOperator().getCityId(), getOperator().getCompId(), param.getKeyId());
		list = judgeOutBorrow(list,cityId,currentUserId,currentDeptId);
//		Set<Integer> userIds = new HashSet<Integer>();
//		for(ErpFunKeyOperationLogDto keyDto:list ){
//			if(keyDto.getOperationUser()!=null){
//				userIds.add(keyDto.getOperationUser());
//			}
//			if(keyDto.getConfirmUser()!=null){
//				userIds.add(keyDto.getConfirmUser());
//			}
//		}
//		if(!userIds.isEmpty()){
//			List<ErpFunUsers> userList = erpFunUsersMapper.getUserListByUserIds(getOperator().getCityId(), userIds);
//			Map<Object,ErpFunUsers> userMap = BeanUtilsHelper.listToMapObjectOffKeyType(userList,"userId");
//			for(ErpFunKeyOperationLogDto keyDto:list ){
//				if(keyDto.getOperationUser()!=null){
//					ErpFunUsers usersPo = userMap.get(keyDto.getOperationUser());
//					if(usersPo!=null){
//						keyDto.setBorrowUserName(usersPo.getUserName());
//					}
//				}
//				if(keyDto.getLendUser()!=null){
//					ErpFunUsers usersPo = userMap.get(keyDto.getLendUser());
//					if(usersPo!=null){
//						keyDto.setLendUserName(usersPo.getUserName());
//					}
//				}
//				if(keyDto.getReturnUser()!=null){
//					ErpFunUsers usersPo = userMap.get(keyDto.getReturnUser());
//					if(usersPo!=null){
//						keyDto.setReturnUserName(usersPo.getUserName());
//					}
//				}
//				if(keyDto.getConfirmUser()!=null){
//					ErpFunUsers usersPo = userMap.get(keyDto.getConfirmUser());
//					if(usersPo!=null){
//						keyDto.setConfirmUserName(usersPo.getUserName());
//					}
//				}
//			}
//		}
		PageInfo<ErpFunKeyOperationLogDto> pageInfo = new PageInfo<ErpFunKeyOperationLogDto>(list);
		return ErpResponseJson.ok(pageInfo);
	}

	private List<ErpFunKeyOperationLogDto> judgeOutBorrow(List<ErpFunKeyOperationLogDto> list,Integer cityId,
														  Integer currentUserId,Integer currentDeptId) {
		//得到当前用户权限
		String roleDesc = erpFunUsersMapper.selectByUserId(cityId,currentUserId).getUserPosition().trim();
		for (ErpFunKeyOperationLogDto erpFunKeyOperationLogDto:list) {
				if (Const.OUT_BORROW.equals(erpFunKeyOperationLogDto.getBorrowType())){
					String desc = erpFunKeyOperationLogDto.getOperationDesc();
					String phoneNum = desc.split("-")[1];
					String newPhoneNum = phoneNum.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
					erpFunKeyOperationLogDto.setOperationDesc(desc.replace(phoneNum,newPhoneNum));
					if (Const.DIC_ROLE_NAME_GENERAL_MANAGER.equals(roleDesc)){
						erpFunKeyOperationLogDto.setOperationDesc(desc);
					}
					if (Const.DIC_ROLE_NAME_BRANCH_MANAGER.equals(roleDesc)){
						if (erpFunKeyOperationLogDto.getDeptId().equals(currentDeptId)){
							erpFunKeyOperationLogDto.setOperationDesc(desc);
						}
					}
//					if (Const.DIC_ROLE_NAME_COMMON_BIZ.equals(roleDesc) || Const.DIC_ROLE_NAME_PROPERTY_SERVER.equals(roleDesc)){
//						if (currentUserId.equals(erpFunKeyOperationLogDto.getConfirmUser())){
//							erpFunKeyOperationLogDto.setOperationDesc(desc);
//						}
//					}
				}
		}
		return list;
	}

	/**
	 * 提交一条钥匙写跟进
	 * @author 方李骥
	 * @since 2016年8月29日
	 * @return
	 */
	@RequestMapping("/createHouseKeyTrack")
	public ResponseJson createHouseKeyTrack(@RequestBody CreateHouseKeyParam param) throws Exception{
		param.setCurrentUserName(getCurrentUserName());
		param.setCurrentUserId(getOperator().getUserId());
		param.setUserName(getOperator().getUserName());
		param.setCurrentDeptId(getOperator().getDeptId());
		if("1".equals(param.getKey())){
			if(getOperator().isPerLogin()){
				erpFunKeyService.createHouseKeyTrackPer(getOperator().getCityId(), getOperator().getCompId(), param);
			}else{
				erpFunKeyService.createHouseKeyTrack(getOperator().getCityId(),getOperator().getCompId(),param);
			}
		}else{
			erpFunKeyService.createNoKeyTrack(getOperator().getCityId(),getOperator().getCompId(),param);
		}
		return ErpResponseJson.ok();
	}
	
	/**
	 * 退还钥匙写跟进
	 * @author 方李骥
	 * @since 2016年8月29日
	 * @return  updateHouseRollBackKey
	 */
	@RequestMapping("/updateHouseRollBackKey")
	public ResponseJson updateHouseRollBackKey(@RequestBody BorrowOrReturnKeyParam param) throws Exception{
		param.setCityId(getOperator().getCityId());
		param.setCompId(getOperator().getCompId());
		param.setCurrentUserName(getCurrentUserName());
		param.setCurrentUserId(getOperator().getUserId());
		param.setUserName(getOperator().getUserName());
		param.setCurrentDeptId(getOperator().getDeptId());
		if(getOperator().isPerLogin()){
			erpFunKeyService.destroyKeyPer(param);
		}else{
			erpFunKeyService.returnHouseKey(getOperator().getCityId(),getOperator().getCompId(),param);
		}
		return ErpResponseJson.ok();
	}
	
	/**
	 * 注销钥匙写跟进
	 * @author 方李骥
	 * @since 2016年8月29日
	 * @return
	 */
	@RequestMapping("/destroyKey")
	public ResponseJson destroyKey(@RequestBody DestroyKeyParam param) throws Exception{
		param.setCurrentUserName(getCurrentUserName());
		param.setCurrentUserId(getOperator().getUserId());
		param.setUserName(getOperator().getUserName());
		param.setCurrentDeptId(getOperator().getDeptId());
		param.setCurrentDeptName(getOperator().getDeptName());
		param.setCityId(getOperator().getCityId());
		param.setCompId(getOperator().getCompId());
		param.setHongJICompModel(String.valueOf(getOperator().getHongJICompModel()));
		erpFunKeyService.destroyKey(param);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 借用钥匙写跟进
	 * @author 方李骥
	 * @since 2016年8月29日
	 * @return
	 */
	@RequestMapping("/borrowOrReturnKey")
	public ResponseJson borrowOrReturnKey(@RequestBody BorrowOrReturnKeyParam param) throws Exception{
		param.setCurrentUserName(getCurrentUserName());
		param.setCurrentUserId(getOperator().getUserId());
		param.setUserName(getOperator().getUserName());
		param.setCurrentDeptId(getOperator().getDeptId());
		param.setCityId(getOperator().getCityId());
		param.setCompId(getOperator().getCompId());
		erpFunKeyService.borrowKey(param);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 提交钥匙判重
	 * @author 何传强
	 * @since 2017年8月16日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/judgeKeyRepet")
	public ResponseJson judgeKeyRepet(@RequestBody BaseMapParam param) throws Exception{
		param.setInteger("compId", getOperator().getCompId());
		ErpFunKey keyInfo = erpFunKeyMapper.getKeyInfoByKeyNum(getOperator().getCityId(),param.getMap());
		Map<String, Integer> resultMap = new HashMap<>();
		if (keyInfo != null) { // 重复
			resultMap.put("keyFlag", 2);
		} else { // 不重复
			resultMap.put("keyFlag", 1);
		}
		return ErpResponseJson.ok(resultMap);
	}
	
	/**
	 * 获取钥匙默认编号
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/4/19
	 */
	@RequestMapping("/getKeyDefaultNum")
	public ResponseJson getKeyDefaultNum(@RequestBody BaseMapParam param) {
		Integer deptId = StringUtil.parseInteger(param.getString("deptId"));
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		ErpFunDepts erpFunDept = erpFunDeptsMapper.getByDeptId(cityId, deptId);
		// 根据部门ID拿到部门编号
		if (erpFunDept == null) {
			throw new BusinessException("生成钥匙编号时出错，门店未找到");
		}
		String keyNum = erpFunKeyService.getNewKeyNum(cityId, compId, deptId, erpFunDept.getDeptNo(),null);
		Map<String, String> map = new HashMap<String, String>();
		map.put("keyNum", keyNum);
		return ErpResponseJson.ok(map);
	}

	/**
	 * @auther zy
	 * @param borrowKeyDetailParam
	 * @return
	 */
	@ApiOperation("获取外借详情")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = BorrowKeyDetailVO.class, message = "成功")
	})
	@RequestMapping("/getBorrowKeyDetail")
	public ResponseJson getBorrowKeyDetail(@RequestBody BorrowKeyDetailParam borrowKeyDetailParam){
		Operator operator = getOperator();
		Integer keyId = borrowKeyDetailParam.getKeyId();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		//获取当前用户，当前门店
		Integer currentUserId = operator.getUserId();
		Integer currentDeptId = operator.getDeptId();
		//判断当前用户角色
		String roleDesc = erpFunUsersMapper.selectByUserId(cityId,currentUserId).getUserPosition().trim();
		ErpFunKey erpFunKey = erpFunKeyMapper.getErpFunKeyById(cityId,compId,keyId);
		Integer commitUserId = erpFunKey.getUserId();
		ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(cityId,commitUserId);
		if (erpFunKey != null){
			if (Const.OUT_BORROW.equals(erpFunKey.getLogType())){
				Integer keyLogId = erpFunKey.getKeyLogId();
				ErpFunPropertyKeyLog erpFunPropertyKeyLog = erpFunPropertyKeyLogMapper.selectByPrimaryKey(new ErpFunPropertyKeyLog(cityId,keyLogId));
				if (erpFunPropertyKeyLog != null){
					BorrowKeyDetailVO borrowKeyDetailVO = getBorrowKeyDetailVO(erpFunPropertyKeyLog,erpFunKey.getKeyNum(),
																				roleDesc,currentDeptId,currentUserId,cityId);
					borrowKeyDetailVO.setSubmitName(erpFunUsers.getUserName());
					borrowKeyDetailVO.setSubmitPhone(erpFunUsers.getUserMobile());
					return ErpResponseJson.ok(borrowKeyDetailVO);
				}
			}
		}
		return ErpResponseJson.ok();
	}

	/**
	 * 获取BorrowKeyDetailVO
	 * @param erpFunPropertyKeyLog
	 * @param keyNo
	 * @return
	 */
	private BorrowKeyDetailVO getBorrowKeyDetailVO(ErpFunPropertyKeyLog erpFunPropertyKeyLog,String keyNo,
												   String roleDesc,Integer currentDeptId,Integer currentUserId,Integer cityId) {
		BorrowKeyDetailVO borrowKeyDetailVO = new BorrowKeyDetailVO();
		if (erpFunPropertyKeyLog != null){
			borrowKeyDetailVO.setBorrowName(erpFunPropertyKeyLog.getBorrowName());
			//总经理
			String phoneNum = erpFunPropertyKeyLog.getBorrowPhone()
					.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");;
			if (Const.DIC_ROLE_NAME_GENERAL_MANAGER.equals(roleDesc)){
				phoneNum = erpFunPropertyKeyLog.getBorrowPhone();
			}
			//如果是门店经理判断门店Id
			if (Const.DIC_ROLE_NAME_BRANCH_MANAGER.equals(roleDesc)){
				//获取登记人门店ID
				Integer deptId = erpFunPropertyKeyLog.getDeptId();
				if (deptId.intValue() == currentDeptId){
					phoneNum = erpFunPropertyKeyLog.getBorrowPhone();
				}
			}
			//如果是经纪人判断登记人再返不返
//			if (Const.DIC_ROLE_NAME_COMMON_BIZ.equals(roleDesc)){
//				Integer userId = erpFunPropertyKeyLog.getUserId();
//				if (userId.intValue() == currentUserId.intValue()){
//					phoneNum = erpFunPropertyKeyLog.getBorrowPhone();
//				}
//			}
			borrowKeyDetailVO.setCurrentDepositStatus(erpFunPropertyKeyLog.getDepositStatus());
			borrowKeyDetailVO.setBorrowPhone(phoneNum);
			borrowKeyDetailVO.setCurrentDeposit(erpFunPropertyKeyLog.getCurrentDeposit());
			borrowKeyDetailVO.setKeyNo(keyNo);
			borrowKeyDetailVO.setKeyStatus(erpFunPropertyKeyLog.getKeyStatus());
			borrowKeyDetailVO.setReviewName(erpFunPropertyKeyLog.getUserName());
			borrowKeyDetailVO.setBorrowName(erpFunPropertyKeyLog.getBorrowName());
			ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(cityId,erpFunPropertyKeyLog.getDeptId());
			borrowKeyDetailVO.setDeptName(erpFunDepts.getDeptName());
		}
		return borrowKeyDetailVO;
	}


}
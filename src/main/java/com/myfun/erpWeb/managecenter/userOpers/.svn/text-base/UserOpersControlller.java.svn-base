package com.myfun.erpWeb.managecenter.userOpers;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.myfun.erpWeb.managecenter.param.ManageLevelParam;
import com.myfun.erpWeb.managecenter.userOpers.param.*;
import com.myfun.erpWeb.managecenter.userOpers.vo.*;
import com.myfun.erpWeb.managecenter.vo.ManageLevelVo;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dao.AdminFunCityMapper;
import com.myfun.repository.admindb.dao.AdminFunCompMapper;
import com.myfun.repository.admindb.dao.AdminFunDeptsMapper;
import com.myfun.repository.admindb.dao.AdminSysParaMapper;
import com.myfun.repository.admindb.dto.AdminYoujiaReserveHouseEvaDto;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.admindb.po.AdminFunComp;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.ErpFunOpersDto;
import com.myfun.repository.erpdb.dto.ErpFunUsersDto;
import com.myfun.repository.erpdb.dto.ErpUserOpersDto;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.constant.Const.LogInEnum;
import com.myfun.service.business.admindb.AdminFunCompService;
import com.myfun.service.business.erpdb.*;
import com.myfun.utils.*;

import cn.hutool.extra.tokenizer.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * 用户权限模块
 * @author lcb
 * @date 2018/7/17
 * @return
 */
@Api(tags = "用户权限模块")
@Controller
@RequestMapping("/manageCenter/userOpersModule")
public class UserOpersControlller extends BaseController {
    @Autowired
    ErpFunDeptsgroupMapper erpFunDeptsgroupMapper;
    @Autowired
    ErpFunUsersMapper erpFunUsersMapper;
    @Autowired
    ErpCompRoleOpersMapper erpCompRoleOpersMapper;
    @Autowired
    ErpSysParaMapper erpSysParaMapper;
    @Autowired
    ErpFunOpersMapper erpFunOpersMapper;
    @Autowired
    AdminFunDeptsMapper adminFunDeptsMapper;
    @Autowired
    AdminFunCityMapper adminFunCityMapper;
    @Autowired
    ErpFunDeptsMapper erpFunDeptsMapper;
    @Autowired
    ErpFunRegionMapper erpFunRegionMapper;
    // 带事务的
    @Autowired
    ErpUserOpersService erpUserOpersService;
    @Autowired
    ErpFunUserManageRangeService erpFunUserManageRangeService;
    @Autowired
    ErpCompRoleOpersService erpCompRoleOpersService;

    /** 本Service不带事务，别乱用哦**/
    @Autowired
    ErpNoTransactionService erpNoTransactionService;
    @Autowired
    ErpCompRolesMapper erpCompRolesMapper;
    @Autowired
    AdminFunArchiveMapper adminFunArchiveMapper;
    @Autowired
    ErpFunRolesMapper erpFunRolesMapper;
    @Autowired
    ErpUserOpersMapper erpUserOpersMapper;
    @Autowired
    ErpMarketVirtualGeneralMapper erpMarketVirtualGeneralMapper;
    @Autowired
	private ErpFunCompMapper erpFunCompMapper;
    @Autowired
	private  AdminFunCompMapper adminFunCompMapper;
    @Autowired
	private AdminFunCompService adminFunCompService;
    @Autowired
   	private ErpFunCompPermissionMapper erpFunCompPermissionMapper;
    @Autowired
    private ErpFunCompPermissionTemplateMapper erpFunCompPermissionTemplateMapper;
    @Autowired
    private ErpFunCompRolesPermissionTemplateRelateMapper erpFunCompRolesPermissionTemplateRelateMapper;
    @Autowired
    private ErpFunOrganizationMapper erpFunOrganizationMapper;
    @Autowired
	private ErpFunOrganizationDefinitionService erpFunOrganizationDefinitionService;
    @Autowired
    private ErpFunOrganizationDefinitionMapper erpFunOrganizationDefinitionMapper;
    @Autowired
    private ErpFunCrossCompUserMapper erpFunCrossCompUserMapper;
    @Autowired
    private ErpFunCrossCompStatusMapper erpFunCrossCompStatusMapper;
    @Autowired
    private ErpFunCrossCompUserOperMapper erpFunCrossCompUserOperMapper;
    @Autowired
    private ErpFunCrossCompOperMapper erpFunCrossCompOperMapper;
    @Autowired
    private ErpFunUsersService erpFunUsersService;
    @Autowired
    private AdminSysParaMapper adminSysParaMapper;
    

    /**
     * @Title  : 获取用户的权限列表
     * @author : lcb
     * @Time   ： 2018/7/24
     *
     **/
    @ApiOperation("获取用户的权限列表,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpResponseJson.class, message = "成功")})
    @RequestMapping("/updateUsersOpers")
    @ResponseBody
    @NotBlank({"userId","roleId"})
	public ResponseJson updateUsersOpers(@RequestBody UpdateUsersOpersParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer compType = operator.getCompType();
		String userName = null;		
		if (getOperator().isSwitchCompLogin()){  //后续换成isSwitchCompLogin
			userName = operator.getUserName() + "(" +operator.getCompName()+")";
		}

		String areaFlag = operator.getAreaFlag();
		Integer userId = param.getUserId();
		Integer currentUserId = getOperator().getUserId();
		String roleId = param.getRoleId();
		String rangeIds = param.getRangeIds();
		Integer rangeType = param.getRangeType();
		Integer userRoleChange = param.getUserRoleChange();
		String delOpers = param.getDelOpers();
		String addOpers = param.getAddOpers();

		boolean newOrganizationType = operator.newOrganizationType();
		if(newOrganizationType) {
			String updateOpers = param.getUpdateOpers();
			List<ErpUserOpers> updateOpersList = new ArrayList<>();
			if(StringUtils.isNotBlank(updateOpers)) {
				updateOpersList = JSON.parseObject(updateOpers, new TypeReference<List<ErpUserOpers>>() {});
			}
			erpUserOpersService.updateUserOpersNewOrg(cityId, compId, compType, userId, areaFlag, roleId, userRoleChange, delOpers, updateOpersList, currentUserId, getOperator().getDeptId(), userName);
		}else {
			erpUserOpersService.updateUserOpers(cityId, compId, compType, userId, areaFlag, roleId, userRoleChange, delOpers, addOpers, currentUserId, getOperator().getDeptId());
		}

		if (operator.isFangJidi()) {
			erpFunUserManageRangeService.updateFangjiDiUserManageRange(cityId, compId, currentUserId, rangeType, rangeIds, roleId, operator.isFangJidi());
		} else {
			if(!newOrganizationType) {
				// 这里不做判断，前端沒传说明无管理范围，直接刪除就是
				erpFunUserManageRangeService.updateUserManageRange(cityId, compId, userId, rangeType, rangeIds, roleId, operator.isFangJidi());
			}
		}
		HashMap<String, Object> resultMap = new HashMap<>();
		return ErpResponseJson.ok(resultMap);
	}


    @ApiOperation("获取角色模板权限")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpResponseJson.class, message = "成功")})
    @RequestMapping("/getPermissionTemplate")
    @ResponseBody
    @NotBlank({"permissionTemplateId"})
    public ResponseJson getPermissionTemplate(@Validated @RequestBody GetPermissionTemplateParam param){
    	Operator operator = getOperator();
    	/*
    	ErpFunCompPermissionExample compPermissionExample = new ErpFunCompPermissionExample();
    	compPermissionExample.setShardCityId(operator.getCityId());    	
    	compPermissionExample.createCriteria().andCompIdEqualTo(operator.getCompId()).andTemplateIdEqualTo(param.getPermissionTemplateId());
    	
    	*/
    	List<ErpFunOpersDto>  operIds = erpFunCompPermissionMapper.getTemplateOperList(operator.getCityId(),operator.getCompId(),param.getPermissionTemplateId());
    	
    	/*List<ErpUserOpers> operIds = new ArrayList<ErpUserOpers>();
    	
    	if(erpFunCompPermissions != null && erpFunCompPermissions.size() > 0){
    		for (ErpFunCompPermission erpFunCompPermission : erpFunCompPermissions) {
    			ErpUserOpers erpUserOpers = new ErpUserOpers();
    			erpUserOpers.setOperId(erpFunCompPermission.getOperId());
    			operIds.add(erpUserOpers);
			}
    	}*/
    	PermissionTemplateRoleVo templateVo = new PermissionTemplateRoleVo();
    	templateVo.setOperIds(operIds);
    	return ErpResponseJson.ok(templateVo);
    }

    @ApiOperation("修改模板权限")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpResponseJson.class, message = "成功")})
    @RequestMapping("/updatePermissionTemplate")
    @ResponseBody
    @NotBlank({"permissionTemplateId"})
    public ResponseJson updatePermissionTemplate(@Validated @RequestBody UpdatePermissionTemplateParam param){
    	Operator operator = getOperator();
        String opersAddStr = param.getAddOpers();
        String opersDelStr = param.getDelOpers();
         
        Integer isNewSetOper = param.getIsNewSetOper();
	  
        
        Integer areaId = null;
        Integer regId = null;
        Integer deptId = null;
        Integer grId = null;

        Integer compId = operator.getCompId();
        
    	Set<String> opersAdd = new HashSet<>();
        if(StringUtils.isNotBlank(opersAddStr)) {
            opersAdd = Arrays.stream(StringHelper.split(opersAddStr, ",")).collect(Collectors.toSet());
        }

        Set<String> opersDel = new HashSet<>();
        if (StringUtils.isNotBlank(opersDelStr)) {
            opersDel = Arrays.stream(StringHelper.split(opersDelStr, ",")).collect(Collectors.toSet());
        }
        //要添加的权限
        if(Objects.equals(1,isNewSetOper)){
            opersAdd.addAll(UserOpersUtils.PUBLIC_OPERS);
        }
	 

        String[] queryParam = parseQueryParamForAll(compId, areaId, regId, deptId, grId);
       
        erpCompRoleOpersService.updateCompRoleTemplateOpers(operator,queryParam,opersAdd,opersDel,param);
        
    	return ErpResponseJson.ok();
    }
    /**
     * @Title  : 修改角色模板权限
     * @author : lcb
     * @Time   ： 2018/7/24
     *
     **/
    @ApiOperation("修改角色权限,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpResponseJson.class, message = "成功")})
    @RequestMapping("/updateRoleOpers")
    @ResponseBody
    @NotBlank({"roleId"})
    public ResponseJson updateRoleOpers(@Validated @RequestBody UpdateRoleOperaParam param) {

//		List<FunOpersVO> updateOpersList = new ArrayList<>();
//		FunOpersVO vo1 = new FunOpersVO();
//		vo1.setOperId("VIEW_ORGANIZATION_HOUSE_LIST_INFO");
//		vo1.setOrganizationDefinitionId(0);
//		updateOpersList.add(vo1);
//
//		param.setOrganizationId(0);


//		param.setUpdateOpers(JSON.toJSONString(updateOpersList));

		Operator operator = getOperator();
		// 权限
		if(adminFunCompService.judgerIsFangjidi(operator.getAdminCompId())){
			return ErpResponseJson.warn("请升级到最新版本");
		}

		boolean newOrganizationType = operator.newOrganizationType();
		if(newOrganizationType) {
			// 新版组织机构角色权限保存
			return updateCompRoleOpersNewOrg(param);
		}else {
			return updateCompRoleOpers(param);
		}
    }

	private ErpResponseJson updateCompRoleOpersNewOrg(UpdateRoleOperaParam param) {
		Operator operator = getOperator();

		// NEW_SET_OPER = 1 表示这次是第一次添加， 0：编辑以往有的角色权限配置
		Integer isNewSetOper = param.getIsNewSetOper();
		Integer isCompRole = param.getIsCompRole();
		Integer effectRange = param.getEffectRange();
		String roleId = param.getRoleId();
		Integer currentUserId = getOperator().getUserId();
		Byte partStatistCount = param.getPartStatistCount();
		Integer organizationId = param.getOrganizationId();


		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();

		// 需要纯删除的权限
		String delOpers = param.getDelOpers();

		Set<String> opersDel = new HashSet<>();
		if (StringUtils.isNotBlank(delOpers)) {
			opersDel = Arrays.stream(StringHelper.split(delOpers, ",")).collect(Collectors.toSet());
		}

		ErpCompRoles erpCompRoleOpers = erpCompRolesMapper.getByRoleId(cityId, compId, roleId);
		if(null != partStatistCount && !partStatistCount.equals(erpCompRoleOpers.getPartStatistCount())) {
			ErpCompRoles erpCompRoles = new ErpCompRoles();
			erpCompRoles.setAutoId(erpCompRoleOpers.getAutoId());
			erpCompRoles.setPartStatistCount(partStatistCount);
			erpCompRoles.setShardCityId(cityId);
			erpCompRolesMapper.updateByPrimaryKeySelective(erpCompRoles);
		}

		String updateOpers = param.getUpdateOpers();
		if(StringUtils.isBlank(updateOpers)) {
			return ErpResponseJson.ok();
		}

		// 需要更新或者新增的权限，（后面这个列表的处理是根据 effectRange 是否保留原有配置来决定）
		List<FunOpersVO> updateOpersList = JSON.parseObject(updateOpers, new TypeReference<List<FunOpersVO>>() {});

		//要添加的权限
		if(Objects.equals(1,isNewSetOper)){
			Set<String> publicOpers = UserOpersUtils.PUBLIC_OPERS;
			for (String publicOper : publicOpers) {
				FunOpersVO opVO = new FunOpersVO();
				opVO.setOperId(publicOper);
				updateOpersList.add(opVO);
			}
		}

		// 总经理不让改
		if (roleId.equals("GENERAL_MANAGER")) {
			return ErpResponseJson.ok();
		}

		Assert.isNullThrow(organizationId, "请选择权限生效范围");
		
		String createUserName = null;
		if (getOperator().isSwitchCompLogin()){  //后续改为isSwitchCompLogin
			createUserName = operator.getUserName()+"("+operator.getCompName()+")";
		}

		erpCompRoleOpersService.updateCompRoleOpersNewOrg(cityId, compId, currentUserId, getOperator().getDeptId(),
				effectRange, roleId, updateOpersList, isNewSetOper, isCompRole, organizationId, opersDel,createUserName);
		//布尔值先写死，后续根据operator中的值判断是否是跨公司登录
		return ErpResponseJson.ok();
	}

    private ErpResponseJson updateCompRoleOpers(UpdateRoleOperaParam param) {
		Operator operator = getOperator();

		String opersAddStr = param.getAddOpers();
		String opersDelStr = param.getDelOpers();
		// NEW_SET_OPER = 1 表示这次是第一次添加， 0：编辑以往有的角色权限配置
		Integer isNewSetOper = param.getIsNewSetOper();
		Integer isCompRole = param.getIsCompRole();
		// 应用范围 保留员工配置1否则0
		Integer effectRange = param.getEffectRange();
		String roleId = param.getRoleId();
		Integer currentUserId = getOperator().getUserId();
		Byte partStatistCount = param.getPartStatistCount();

		// 应用范围
		Integer areaId = param.getAreaId();
		Integer regId = param.getRegId();
		Integer deptId = param.getDeptId();
		Integer grId = param.getGrId();

		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer compType = operator.getCompType();


		Set<String> opersAdd = new HashSet<>();
		if(StringUtils.isNotBlank(opersAddStr)) {
			opersAdd = Arrays.stream(StringHelper.split(opersAddStr, ",")).collect(Collectors.toSet());
		}

		Set<String> opersDel = new HashSet<>();
		if (StringUtils.isNotBlank(opersDelStr)) {
			opersDel = Arrays.stream(StringHelper.split(opersDelStr, ",")).collect(Collectors.toSet());
		}

		//要添加的权限
		if(Objects.equals(1,isNewSetOper)){
			opersAdd.addAll(UserOpersUtils.PUBLIC_OPERS);
		}
		if (roleId.equals("GENERAL_MANAGER")) {
			if (null != partStatistCount) {//总经理不修改权限
				ErpCompRoles erpCompRoleOpers = erpCompRolesMapper.getByRoleId(cityId, compId, roleId);
				ErpCompRoles erpCompRoles = new ErpCompRoles();
				erpCompRoles.setAutoId(erpCompRoleOpers.getAutoId());
				erpCompRoles.setPartStatistCount(partStatistCount);
				erpCompRoles.setShardCityId(cityId);
				erpCompRolesMapper.updateByPrimaryKeySelective(erpCompRoles);
			}
			return ErpResponseJson.ok();
		}

		String[] queryParam = parseQueryParamForAll(compId, areaId, regId, deptId, grId);
		erpCompRoleOpersService.updateCompRoleOpers(cityId, compId, compType, currentUserId, getOperator().getDeptId(),
				effectRange, roleId, opersAdd, opersDel, queryParam, isNewSetOper, isCompRole,param.getPartStatistCount());
		return ErpResponseJson.ok();
	}

    /**
     * 权限管理-获取用户列表
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/4/17
     */
    @RequestMapping("/getMgrUserList")
    @ResponseBody
	public ErpResponseJson getMgrUserList(@Valid @RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		if (null != param.getInteger("cityId")) {
			cityId = param.getInteger("cityId");
		}
		Integer compId = operator.getCompId();
		if (null != param.getInteger("compId")) {
			compId = param.getInteger("compId");
		}
		// 这个参数必传
		Integer deptId = param.getInteger("deptId");
		Integer userId = param.getInteger("userId");
		Integer organizationId = param.getInteger("organizationId");
		String userPosition = operator.getUserPosition();
		if (operator.isSwitchCompLogin()) {
			userPosition = "GENERAL_MANAGER";
		}
		if(null != organizationId && 0 == organizationId) {
			organizationId = null;
		}
		boolean isMix = Const.DIC_DEPT_TYPE_3.equals(operator.getCompType());
		List<ErpCompRoles> lowerRoleList = erpCompRolesMapper.getLowerRolesList(cityId, compId,
				userPosition, isMix, false);
		if (lowerRoleList == null || lowerRoleList.isEmpty()) {
			return ErpResponseJson.ok();
		}
		Map<String, ErpCompRoles> lowerRoleMap = lowerRoleList.stream()
				.collect(Collectors.toMap(ErpCompRoles::getRoleId, val -> val));
		List<ErpFunUsers> userList = new ArrayList<>();
		if (null != userId) {
			ErpFunUsers erpFunUsers = erpFunUsersMapper.selectDataByUserId(cityId, compId, userId);
			if (null == erpFunUsers) {
				throw new BusinessException("数据异常，请联系在线客服");
			}
			userList.add(erpFunUsers);
		} else if (null != deptId) {
			userList = erpFunUsersMapper.getUserListByDeptId(cityId, deptId);
		} else if (null != organizationId) {
			userList = erpFunUsersMapper.getUserListByOrganizationId(cityId, compId, organizationId);
		} else {
			userList = erpFunUsersMapper.getRecordsByCompIdAndUserWriteOff(cityId, compId, 0);
		}
		List<ErpFunUsersDto> erpFunUsersDtos = new ArrayList<>();
		if (userList.size() > 0) {
			List<Integer> collect = userList.stream()
					.collect(Collectors.mapping(val -> val.getArchiveId(), Collectors.toList()));
			collect.add(operator.getArchiveId());
			// 查询头像
			List<AdminFunArchive> archiveInfosByIds = adminFunArchiveMapper.getArchiveInfosByIds(collect);
			Map<Integer, AdminFunArchive> archiveMap = archiveInfosByIds.stream()
					.collect(Collectors.toMap(val -> val.getArchiveId(), val -> val));
			for (ErpFunUsers funUsers : userList) {
				if (lowerRoleMap.containsKey(funUsers.getUserPosition())) {
					ErpFunUsersDto funUsersTmp = new ErpFunUsersDto();
					funUsersTmp.setRoleId(funUsers.getUserPosition());
					ErpCompRoles compRoles = lowerRoleMap.get(funUsers.getUserPosition());
					funUsersTmp.setSeqNo(compRoles.getSeqNo());
					funUsersTmp.setRoleName(compRoles.getRoleName());
					funUsersTmp.setUserName(funUsers.getUserName());
					funUsersTmp.setUserId(funUsers.getUserId());
					funUsersTmp.setDeptId(funUsers.getDeptId());
					AdminFunArchive adminFunArchive = archiveMap.get(funUsers.getArchiveId());
					funUsersTmp.setUserPhoto(AppConfig.getPicDomainUrl() + adminFunArchive.getUserPhoto());
					erpFunUsersDtos.add(funUsersTmp);
				}
			}
			if (null != deptId && deptId.equals(getOperator().getDeptId())) {
				ErpCompRoles ownerRoles = erpCompRolesMapper.getByRoleId(cityId, compId, operator.getUserPosition());
				ErpFunUsersDto owner = new ErpFunUsersDto();
				owner.setRoleId(ownerRoles.getRoleId());
				owner.setSeqNo(ownerRoles.getSeqNo());
				owner.setRoleName(ownerRoles.getRoleName());
				owner.setUserName(operator.getUserName());
				owner.setUserId(operator.getUserId());
				AdminFunArchive adminFunArchive = archiveMap.get(operator.getArchiveId());
				owner.setUserPhoto(AppConfig.getPicDomainUrl() + adminFunArchive.getUserPhoto());
				erpFunUsersDtos.add(0, owner);
			}

			if (0 == param.getInteger("organizationId")) {
				ErpFunUsers adminUser = erpFunUsersMapper.selectByUserId(cityId, operator.getUserId());
				ErpCompRoles ownerRoles = erpCompRolesMapper.getByRoleId(adminUser.getCityId().intValue(), adminUser.getCompId(), operator.getUserPosition());
				//ErpCompRoles ownerRoles = erpCompRolesMapper.getByRoleId(cityId, compId, operator.getUserPosition());
				ErpFunUsersDto owner = new ErpFunUsersDto();
				if (null != ownerRoles) {
					owner.setRoleId(ownerRoles.getRoleId());
					owner.setSeqNo(ownerRoles.getSeqNo());
					owner.setRoleName(ownerRoles.getRoleName());
				}
				owner.setUserName(operator.getUserName());
				owner.setUserId(operator.getUserId());
				AdminFunArchive adminFunArchive = archiveMap.get(operator.getArchiveId());
				owner.setUserPhoto(AppConfig.getPicDomainUrl() + adminFunArchive.getUserPhoto());
				erpFunUsersDtos.add(0, owner);
			}

			if (null != organizationId && organizationId.equals(getOperator().getOrganizationId())) {
				ErpCompRoles ownerRoles = erpCompRolesMapper.getByRoleId(cityId, compId, operator.getUserPosition());
				ErpFunUsersDto owner = new ErpFunUsersDto();
				if (null != ownerRoles) {
					owner.setRoleId(ownerRoles.getRoleId());
					owner.setSeqNo(ownerRoles.getSeqNo());
					owner.setRoleName(ownerRoles.getRoleName());
				}
				owner.setUserName(operator.getUserName());
				owner.setUserId(operator.getUserId());
				AdminFunArchive adminFunArchive = archiveMap.get(operator.getArchiveId());
				owner.setUserPhoto(AppConfig.getPicDomainUrl() + adminFunArchive.getUserPhoto());
				erpFunUsersDtos.add(0, owner);
			}
		}
		return ErpResponseJson.ok(erpFunUsersDtos);
	}


    /**
     * @Title  : 获取用户的权限列表
     * @author : lcb
     * @Time   ： 2018/7/24
     *
     **/
    @ApiOperation("获取用户的权限列表,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = UsersOpersListVo.class, message = "成功")})
    @RequestMapping("/getUsersOpersList")
    @ResponseBody
    @NotBlank({"userId"})
	public ResponseJson getUsersOpersList(@RequestBody GetUsersOpersListParam param) {
		Operator operator = getOperator();

		if (operator.isNewHouseEdition() && getOperator().isMobileApi()) {
    		return ErpResponseJson.ok();
    	}

		boolean newOrganizationType = operator.newOrganizationType();

		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		boolean mobileApi = operator.isMobileApi();
		Integer userId = param.getUserId();
		Integer compType = operator.getCompType();
		ErpFunUsers users = erpFunUsersMapper.getUserInfoByUserId(cityId, userId);
		String roleId = users.getUserPosition();

		// 查询是否是自定义角色
		ErpFunRoles erpFunRoles = new ErpFunRoles();
		erpFunRoles.setRoleId(roleId);
		erpFunRoles.setShardCityId(cityId);
		erpFunRoles = erpFunRolesMapper.selectByPrimaryKey(erpFunRoles);

		Integer isCompRole = 1;
		if (null != erpFunRoles) {
			isCompRole = 0;
		}
		
		// story#11307 先判断当前公司是否说开了加盟模式，再判断当前这个人说在哪个组织，总部的就 要总部特殊的权限比如说加盟商管理权， 直营不管，如果说加盟商的人，那么要把特殊的加盟商公告管理权查出来
		List<Byte> flagList =  new ArrayList<Byte>();// 查询通用的权限，1=总部的，2=加盟商的
		flagList.add(Byte.valueOf("0"));
		if (Integer.valueOf(1).equals(getOperator().openPartner())) {
			if (Integer.valueOf(0).equals(users.getPartnerId())) {// 总部
				flagList.add(Byte.valueOf("1"));
				flagList.add(Byte.valueOf("3"));
			} else if (users.getPartnerId() > 0) {// 加盟商
				flagList.add(Byte.valueOf("2"));
			} else {
				flagList.add(Byte.valueOf("3"));
			}
		}
		Set<ErpFunOpersDto> compRoleOpersList = new HashSet<>();
		if(newOrganizationType) {
			Integer organizationId = getQueryColumnByCompOpersNewOrg(cityId, compId, roleId, users);
			compRoleOpersList = erpFunOpersMapper.getRoleOpersListNewOrg(cityId, compId, organizationId, roleId, mobileApi, flagList);
		}else {
			String[] queryColumn = getQueryColumnByCompOpers(cityId, compId, roleId, users);
			// 所选角色模板权限(包含基础权限和高级权限)
			compRoleOpersList = erpFunOpersMapper.getRoleOpersList(cityId, compId, queryColumn[0], queryColumn[1], roleId, mobileApi, flagList);
		}

		List<ErpSysPara> sysParaList = erpSysParaMapper.selectSysParaByCompId(cityId, compId);
		Map<String, ErpSysPara> sysParaMap = sysParaList.stream()
				.collect(Collectors.toMap(ErpSysPara::getParamId, val -> val));
		if (isCompRole == 1) {
			users.setUserPosition(Const.DIC_ROLE_NAME_DEPUTY_MANAGER);
		}
		// 获登陆取用户拥有的所有权限
		List<ErpUserOpersDto> ownOpersPOs = erpUserOpersMapper.getUsersOpers(cityId, getOperator().getUserId());
		
		// 在加盟商模式下，当前登录人的权限ownOpers里面需要增加加盟商管理权和加盟商公告管理权，目的仅仅是为了能在配置界面能为总部或加盟商配置对应的权限
		if (!ownOpersPOs.isEmpty() && Integer.valueOf(1).equals(operator.openPartner())) {
			if(newOrganizationType) {
				ErpFunOrganizationDefinitionExample erpFunOrganizationDefinitionExample = new ErpFunOrganizationDefinitionExample();
				erpFunOrganizationDefinitionExample.setShardCityId(cityId);
				erpFunOrganizationDefinitionExample.createCriteria().andCompIdEqualTo(compId).andPartnerLevelEqualTo(Byte.valueOf("1")).andDelFlagNotEqualTo(Byte.valueOf("1"));
				List<ErpFunOrganizationDefinition> partnerOrganizationDefinitionList = erpFunOrganizationDefinitionMapper.selectByExample(erpFunOrganizationDefinitionExample);
				ErpFunOrganizationDefinition erpFunOrganizationDefinition = null;
				if (!partnerOrganizationDefinitionList.isEmpty()) {
					erpFunOrganizationDefinition = partnerOrganizationDefinitionList.get(0);
				}
				
				Set<String> getOpers = ownOpersPOs.stream().filter(a -> "MANAGE_ORGANIZATION_BULLET".equals(a.getOperId()) || "PARTNER_MANAGE_OPER".equals(a.getOperId())).map(ErpUserOpersDto :: getOperId).collect(Collectors.toSet());
				if (!getOpers.contains("MANAGE_ORGANIZATION_BULLET")) {
					ErpUserOpersDto managePartnerBulletOper = new ErpUserOpersDto();
					managePartnerBulletOper.setOperId("MANAGE_ORGANIZATION_BULLET");
					managePartnerBulletOper.setUserId(userId);
					if (null != erpFunOrganizationDefinition) {
						managePartnerBulletOper.setDefinitionLevel(erpFunOrganizationDefinition.getDefinitionLevel());
						managePartnerBulletOper.setDefinitionName(erpFunOrganizationDefinition.getDefinitionName());
						managePartnerBulletOper.setOrganizationDefinitionId(erpFunOrganizationDefinition.getDefinitionId());
					}
					ownOpersPOs.add(managePartnerBulletOper);
				}
				if (!getOpers.contains("PARTNER_MANAGE_OPER")) {
					ErpUserOpersDto partnerManageOper = new ErpUserOpersDto();
					partnerManageOper.setOperId("PARTNER_MANAGE_OPER");
					partnerManageOper.setUserId(userId);
					if (null != erpFunOrganizationDefinition) {
						partnerManageOper.setDefinitionLevel(erpFunOrganizationDefinition.getDefinitionLevel());
						partnerManageOper.setDefinitionName(erpFunOrganizationDefinition.getDefinitionName());
						partnerManageOper.setOrganizationDefinitionId(erpFunOrganizationDefinition.getDefinitionId());
					}
					ownOpersPOs.add(partnerManageOper);
				}
			} else {
				Set<String> getOpers = ownOpersPOs.stream().filter(a -> "MANAGE_PARTNER_BULLET".equals(a.getOperId()) || "PARTNER_MANAGE_OPER".equals(a.getOperId())).map(ErpUserOpersDto :: getOperId).collect(Collectors.toSet());
				if (!getOpers.contains("MANAGE_PARTNER_BULLET")) {
					ErpUserOpersDto managePartnerBulletOper = new ErpUserOpersDto();
					managePartnerBulletOper.setOperId("MANAGE_PARTNER_BULLET");
					managePartnerBulletOper.setUserId(userId);
					ownOpersPOs.add(managePartnerBulletOper);
				}
				if (!getOpers.contains("PARTNER_MANAGE_OPER")) {
					ErpUserOpersDto partnerManageOper = new ErpUserOpersDto();
					partnerManageOper.setOperId("PARTNER_MANAGE_OPER");
					partnerManageOper.setUserId(userId);
					ownOpersPOs.add(partnerManageOper);
				}
			}
		}

		// 获取角色应该有的权限
		Set<ErpFunOpersDto> metaRoleOpers = new HashSet<>();
		// 这个是模板权限
		if (isCompRole == 1) {
			metaRoleOpers = erpFunOpersMapper.getOpersListByRoleId(cityId, Const.DIC_ROLE_NAME_DEPUTY_MANAGER, compType, null, mobileApi, flagList, newOrganizationType);
		} else {
			metaRoleOpers = erpFunOpersMapper.getOpersListByRoleId(cityId, roleId, compType, null, mobileApi, flagList, newOrganizationType);
		}

		Map<String, ErpFunOpersDto> modelOpersMap = metaRoleOpers.stream().collect(Collectors.toMap(val -> val.getOperId(), val -> val));
		// 查询所选员工的权限
		List<ErpFunOpersDto> checkedOpersList = erpFunOpersMapper.getFunOpersDtoListById(cityId, userId,
				users.getUserPosition(), mobileApi, flagList);
		Map<String, ErpFunOpersDto> userOpersMap = checkedOpersList.stream()
				.collect(Collectors.toMap(val -> val.getOperId(), val -> val));
		Set<String> personOperSet = new HashSet<>();
		if (!userOpersMap.isEmpty()) {
			personOperSet = userOpersMap.keySet();
		}
		for (ErpFunOpersDto erpFunOpersDto : compRoleOpersList) {
			ErpFunOpersDto erpFunOpersDto1 = userOpersMap.get(erpFunOpersDto.getOperId());
			if (null == erpFunOpersDto1 && !modelOpersMap.containsKey(erpFunOpersDto.getOperId())) {
				metaRoleOpers.add(erpFunOpersDto.clone());
			}
		}
		// 需要移除的权限
		Set<String> opers = new HashSet<>();
		// 个人求购 求售 出租 出售 权公有 DEL_COMMUNIC_INFO 是部分拥有
		opers.addAll(getNeedHiddenOper(cityId, compId, 1 == isCompRole ? Const.DIC_ROLE_NAME_DEPUTY_MANAGER : roleId, sysParaMap, newOrganizationType));

//		opers.addAll(needHiddenOpersByCustomized(sysParaMap));
		//这个权限限制全部公司都有了 只有公盘制的屏掉
		if(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBLIC.equals(getSysParaValue(sysParaMap.get("SYSTEM_RUN_MODEL")))) {
			opers.add("VIEW_SHARE_HOUSE_CUST");
		}

		// 单店版去权限
		if(Const.DIC_COMP_TYPE_6.equals(compType) && !newOrganizationType) {
			opers.addAll(getSignleDeptOpers());
		}

		ErpFunComp erpFunComp = erpFunCompMapper.selectByCompId(cityId, compId);

		ErpFunDeptsExample erpFunDeptsExample = new ErpFunDeptsExample();
		erpFunDeptsExample.setShardCityId(cityId);
		erpFunDeptsExample.createCriteria().andCompIdEqualTo(compId);
		List<ErpFunDepts> depts = erpFunDeptsMapper.selectByExample(erpFunDeptsExample);
		// 不是物业版和LINK版下有物业门店
		boolean remove = !(Const.DIC_COMP_TYPE_5.equals(compType) || (erpFunComp != null && erpFunComp.getCompType() == 1
				&& depts != null && depts.stream().anyMatch(it -> it.getSupportPropertyFlag() != null && it.getSupportPropertyFlag() == 1)));
		// 物业版和LINK版下的物业门店有权限, 其他的去权限
		if (remove) {
			opers.addAll(getWuyeDeptOpers(newOrganizationType));
		}

		if (newOrganizationType) {
			if (flagList.size() > 1) {// 加盟商的权限需要对应类型区移除
				if (flagList.contains(Byte.valueOf("2"))) {// 加盟商需要移除加盟商管理权
					opers.add("PARTNER_MANAGE_OPER");
				}
			} else {
				opers.add("PARTNER_MANAGE_OPER");
			}
		} else {
			if (flagList.size() > 1) {// 加盟商的权限需要对应类型区移除
				if (flagList.contains(Byte.valueOf("2"))) {// 加盟商需要移除加盟商管理权
					opers.add("PARTNER_MANAGE_OPER");
				} else {// 总部和直营需要移除加盟商公告管理权
					opers.add("MANAGE_PARTNER_BULLET");
				}
			} else {
				opers.addAll(Arrays.asList("MANAGE_PARTNER_BULLET", "PARTNER_MANAGE_OPER"));
			}
		}

		Set<String> modealSet = new HashSet<>();
		Set<String> higherThanModelOpers = new HashSet<>();
		if (metaRoleOpers.size() > 0) {
			modealSet = metaRoleOpers.stream().collect(Collectors.mapping(val -> val.getOperId(), Collectors.toSet()));
			for (String operId : personOperSet) {
				if (!modealSet.contains(operId)) {
					higherThanModelOpers.add(operId);
				}
			}
		}
		UserOpersUtils.removeHiddenOpers(metaRoleOpers, opers);
		// 个人高于模板的展示列表
		Set<ErpFunOpersDto> erpFunOpersDtos = new HashSet<>();
		Map<String, Object> resList = new HashMap<>();
		// 这里兼容老数据，有可能是改版前高权限，改版后去掉某些权限的人的数据
		if (higherThanModelOpers.size() > 0) {
			// 这个是模板权限
			if (isCompRole == 1) {
				erpFunOpersDtos = erpFunOpersMapper.getOpersListByRoleId3(cityId, compId,
						Const.DIC_ROLE_NAME_DEPUTY_MANAGER, higherThanModelOpers, mobileApi);
			} else {
				erpFunOpersDtos = erpFunOpersMapper.getOpersListByRoleId3(cityId, compId, roleId, higherThanModelOpers, mobileApi);
			}
		}
//		metaRoleOpers.
		List<ErpFunOpersDto> higherSortList = new ArrayList<>(erpFunOpersDtos);
		higherSortList.sort((val1, val2) -> {
			return Optional.ofNullable(val1.getSeqNo()).orElse(0) - Optional.ofNullable(val2.getSeqNo()).orElse(0);
		});
		List<ErpFunOpersDto> metaSortList = new ArrayList<>(metaRoleOpers);
		List<ErpFunOpersDto> compSortList = new ArrayList<>(compRoleOpersList);
		// 处理下范围
		if(newOrganizationType) {
			List<ErpFunOrganizationDefinition> allEffectiveOrganizationDefinition = erpFunOrganizationDefinitionService.getAllEffectiveOrganizationDefinition(cityId, compId);
			Map<Integer, ErpFunOrganizationDefinition> definitionMap = allEffectiveOrganizationDefinition.stream().collect(Collectors.toMap(ErpFunOrganizationDefinition::getDefinitionId, val -> val));
			metaSortList.forEach(val-> {
				if(null != val.getOrganizationDefinitionId()) {
					if(val.getOrganizationDefinitionId() > 0) {
						ErpFunOrganizationDefinition erpFunOrganizationDefinition = definitionMap.get(val.getOrganizationDefinitionId());
						if(null != erpFunOrganizationDefinition) {
							val.setDefinitionName(erpFunOrganizationDefinition.getDefinitionName());
							val.setDefinitionLevel(erpFunOrganizationDefinition.getDefinitionLevel());
						}
					}else {
						val.setDefinitionLevel(0);
					}

				}
			});

			compSortList.forEach(val-> {
				if(null != val.getOrganizationDefinitionId() ) {
					if(val.getOrganizationDefinitionId() > 0) {
						ErpFunOrganizationDefinition erpFunOrganizationDefinition = definitionMap.get(val.getOrganizationDefinitionId());
						if(null != erpFunOrganizationDefinition) {
							val.setDefinitionName(erpFunOrganizationDefinition.getDefinitionName());
							val.setDefinitionLevel(erpFunOrganizationDefinition.getDefinitionLevel());
						}
					}else {
						val.setDefinitionLevel(0);
					}

				}
			});

			checkedOpersList.forEach(val-> {
				if(null != val.getOrganizationDefinitionId() ) {
					if(val.getOrganizationDefinitionId() > 0) {
						ErpFunOrganizationDefinition erpFunOrganizationDefinition = definitionMap.get(val.getOrganizationDefinitionId());
						if(null != erpFunOrganizationDefinition) {
							val.setDefinitionName(erpFunOrganizationDefinition.getDefinitionName());
							val.setDefinitionLevel(erpFunOrganizationDefinition.getDefinitionLevel());
						}
					}else {
						val.setDefinitionLevel(0);
					}
					if ("MANAGE_ORGANIZATION_BULLET".equals(val.getOperId())) {// 公告权限的层级名称单独写死
						if (Integer.valueOf(0).equals(val.getOrganizationDefinitionId())) {
							val.setDefinitionName("公司");
						} else if (Integer.valueOf(1).equals(val.getOrganizationDefinitionId())) {
							val.setDefinitionName("本组织");
						} else if (Integer.valueOf(-1).equals(val.getOrganizationDefinitionId())) {
							val.setDefinitionName("本加盟商");
						}
					}
				}
			});
		}

		metaSortList.sort((val1, val2) -> {
			return Optional.ofNullable(val1.getSeqNo()).orElse(0) - Optional.ofNullable(val2.getSeqNo()).orElse(0);
		});
		List<ErpFunOpersDto> checkedSortList = new ArrayList<>(checkedOpersList);
		checkedSortList.sort((val1, val2) -> {
			return Optional.ofNullable(val1.getSeqNo()).orElse(0) - Optional.ofNullable(val2.getSeqNo()).orElse(0);
		});

		compSortList.sort((val1, val2) -> {
			return Optional.ofNullable(val1.getSeqNo()).orElse(0) - Optional.ofNullable(val2.getSeqNo()).orElse(0);
		});
		AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(erpFunComp.getCompNo());
		if(("2".equals(adminFunComp.getCompManagementModel().toString())
				&&"1".equals(adminFunComp.getCustomizedType().toString()))){
			fjdOperNamereplace(higherSortList);
			fjdOperNamereplace(metaSortList);
			fjdOperNamereplace(checkedSortList);
			fjdOperNamereplace(compSortList);
		}
		resList.put("higherThanModelOpersList", higherSortList);
		resList.put("modelOpersList", metaSortList);
		resList.put("checkedUserOpersList", checkedSortList);
		resList.put("loginUserOpersList", ownOpersPOs);
		resList.put("defaultOpersList", compSortList);
		return ErpResponseJson.ok(resList);


	}

    private void fjdOperNamereplace(List<ErpFunOpersDto> operList){
    	if(operList !=null && operList.size() > 0){
    		for (ErpFunOpersDto erpFunOpersDto : operList) {
				if("VIEW_REG_CUST".equals(erpFunOpersDto.getOperId())){  //查看片区客源核心信息权
					if(StringUtil.isNotEmpty(erpFunOpersDto.getOperDesc())){
						erpFunOpersDto.setOperDesc(erpFunOpersDto.getOperDesc().replace("片区", "下级团队"));
					}
				}else if("VIEW_DEPT_CUST".equals(erpFunOpersDto.getOperId())){  //查看门店客源核心信息权
					if(StringUtil.isNotEmpty(erpFunOpersDto.getOperDesc())){
						erpFunOpersDto.setOperDesc(erpFunOpersDto.getOperDesc().replace("门店", "团队"));
					}
				}else if("AUTO_EXAM_VIEW_REG_CUST".equals(erpFunOpersDto.getOperId())){  //查看片区客源电话无需审核
					if(StringUtil.isNotEmpty(erpFunOpersDto.getOperDesc())){
						erpFunOpersDto.setOperDesc(erpFunOpersDto.getOperDesc().replace("片区", "下级团队"));
					}
				}else if("AUTO_EXAM_VIEW_DEPT_CUST".equals(erpFunOpersDto.getOperId())){  //查看门店客源电话无需审核
					if(StringUtil.isNotEmpty(erpFunOpersDto.getOperDesc())){
						erpFunOpersDto.setOperDesc(erpFunOpersDto.getOperDesc().replace("门店", "团队"));
					}
				}else if("JOINT_CUSTOMER_REG_VIEW".equals(erpFunOpersDto.getOperId())){  //查看片区联动客户信息权
					if(StringUtil.isNotEmpty(erpFunOpersDto.getOperDesc())){
						erpFunOpersDto.setOperDesc(erpFunOpersDto.getOperDesc().replace("片区", "下级团队"));
					}
				}else if("JOINT_CUSTOMER_DEPT_VIEW".equals(erpFunOpersDto.getOperId())){  //查看门店联动客户信息权
					if(StringUtil.isNotEmpty(erpFunOpersDto.getOperDesc())){
						erpFunOpersDto.setOperDesc(erpFunOpersDto.getOperDesc().replace("门店", "团队"));
					}
				}else if("DATA_ANALYSIS_REG_VIEW".equals(erpFunOpersDto.getOperId())){  //查看片区统计分析权
					if(StringUtil.isNotEmpty(erpFunOpersDto.getOperDesc())){
						erpFunOpersDto.setOperDesc(erpFunOpersDto.getOperDesc().replace("片区", "下级团队"));
					}
				}else if("DATA_ANALYSIS_DEPT_VIEW".equals(erpFunOpersDto.getOperId())){  //查看门店统计分析权
					if(StringUtil.isNotEmpty(erpFunOpersDto.getOperDesc())){
						erpFunOpersDto.setOperDesc(erpFunOpersDto.getOperDesc().replace("门店", "团队"));
					}
				}else if("VIEW_REG_DEAL".equals(erpFunOpersDto.getOperId())){  //片区合同查看权
					if(StringUtil.isNotEmpty(erpFunOpersDto.getOperDesc())){
						erpFunOpersDto.setOperDesc(erpFunOpersDto.getOperDesc().replace("片区", "下级团队"));
					}
				}else if("VIEW_DEPT_DEAL".equals(erpFunOpersDto.getOperId())){  //门店合同查看权
					if(StringUtil.isNotEmpty(erpFunOpersDto.getOperDesc())){
						erpFunOpersDto.setOperDesc(erpFunOpersDto.getOperDesc().replace("门店", "团队"));
					}
				}else if("REG_EARBEST_MONEY_MANAGE".equals(erpFunOpersDto.getOperId())){  //片区诚意金定金管理权
					if(StringUtil.isNotEmpty(erpFunOpersDto.getOperDesc())){
						erpFunOpersDto.setOperDesc(erpFunOpersDto.getOperDesc().replace("片区", "下级团队"));
					}
				}else if("DEPT_EARBEST_MONEY_MANAGE".equals(erpFunOpersDto.getOperId())){  //门店诚意金定金管理权
					if(StringUtil.isNotEmpty(erpFunOpersDto.getOperDesc())){
						erpFunOpersDto.setOperDesc(erpFunOpersDto.getOperDesc().replace("门店", "团队"));
					}
				}else if("EARBEST_MONEY_VIEW_REG".equals(erpFunOpersDto.getOperId())){  //片区诚意金定金查看权
					if(StringUtil.isNotEmpty(erpFunOpersDto.getOperDesc())){
						erpFunOpersDto.setOperDesc(erpFunOpersDto.getOperDesc().replace("片区", "下级团队"));
					}
				}else if("EARBEST_MONEY_VIEW_DEPT".equals(erpFunOpersDto.getOperId())){  //门店诚意金定金查看权
					if(StringUtil.isNotEmpty(erpFunOpersDto.getOperDesc())){
						erpFunOpersDto.setOperDesc(erpFunOpersDto.getOperDesc().replace("门店", "团队"));
					}
				}else if("EARBEST_MONEY_FIC_MANAGE_REG".equals(erpFunOpersDto.getOperId())){  //片区诚意金定金财务管理权
					if(StringUtil.isNotEmpty(erpFunOpersDto.getOperDesc())){
						erpFunOpersDto.setOperDesc(erpFunOpersDto.getOperDesc().replace("片区", "下级团队"));
					}
				}else if("EARBEST_MONEY_FIC_MANAGE_DEPT".equals(erpFunOpersDto.getOperId())){  //门店诚意金定金财务管理权
					if(StringUtil.isNotEmpty(erpFunOpersDto.getOperDesc())){
						erpFunOpersDto.setOperDesc(erpFunOpersDto.getOperDesc().replace("门店", "团队"));
					}
				}else if("FUN_WAG_CHECK_REG".equals(erpFunOpersDto.getOperId())){  //片区薪资查看权
					if(StringUtil.isNotEmpty(erpFunOpersDto.getOperDesc())){
						erpFunOpersDto.setOperDesc(erpFunOpersDto.getOperDesc().replace("片区", "下级团队"));
					}
				}else if("FUN_WAG_CHECK_DEPT".equals(erpFunOpersDto.getOperId())){  //门店薪资查看权
					if(StringUtil.isNotEmpty(erpFunOpersDto.getOperDesc())){
						erpFunOpersDto.setOperDesc(erpFunOpersDto.getOperDesc().replace("门店", "团队"));
					}
				}
			}
    	}
    }
    
	/**
	 * 物业版和LINK版下的物业门店有此权限, 其他的去权限
	 *
	 * **/
	private Set<String> getWuyeDeptOpers(Boolean newOrganization) {
		Set<String> hiddenOpers = new HashSet<>();
		if(newOrganization) {
			// 访客管理权
			hiddenOpers.add("MANAGE_ORGANIZATION_VISITOR");
		}else {
			// 访客管理权
			hiddenOpers.add("MANAGE_COMP_VISITOR");
			hiddenOpers.add("MANAGE_AREA_VISITOR");
			hiddenOpers.add("MANAGE_REG_VISITOR");
			hiddenOpers.add("MANAGE_DEPT_VISITOR");
		}

		// 项目管理员设置权
		hiddenOpers.add("EDIT_PROPERTY_MANAGER");
		return hiddenOpers;
	}

	/**
	 * 物业版和LINK版下的物业门店有此权限, 其他的去权限,新版组织的
	 *
	 * **/
	private Set<FunOpersVO> getWuyeDeptOpersWithOrganization(List<ErpFunOrganizationDefinition> allEffectiveOrganizationDefinition) {
		Set<FunOpersVO> hiddenOpers = new HashSet<>();

		for (ErpFunOrganizationDefinition erpFunOrganizationDefinition : allEffectiveOrganizationDefinition) {
			FunOpersVO funOpersVO = new FunOpersVO();
			funOpersVO.setOperId("MANAGE_ORGANIZATION_VISITOR");
			funOpersVO.setDefinitionLevel(erpFunOrganizationDefinition.getDefinitionLevel());
			funOpersVO.setOrganizationDefinitionId(erpFunOrganizationDefinition.getDefinitionId());
			hiddenOpers.add(funOpersVO);
		}
		// 公司
		FunOpersVO funOpersVO = new FunOpersVO();
		funOpersVO.setOperId("MANAGE_ORGANIZATION_VISITOR");
		funOpersVO.setDefinitionLevel(0);
		funOpersVO.setOrganizationDefinitionId(-1);
		hiddenOpers.add(funOpersVO);

		funOpersVO = new FunOpersVO();
		funOpersVO.setOperId("MANAGE_ORGANIZATION_VISITOR");
		funOpersVO.setOrganizationDefinitionId(-2);
		funOpersVO.setDefinitionLevel(15);
		hiddenOpers.add(funOpersVO);


		// 访客管理权
		funOpersVO = new FunOpersVO();
		funOpersVO.setOperId("EDIT_PROPERTY_MANAGER");

		hiddenOpers.add(funOpersVO);
		return hiddenOpers;
	}

	/**
	 * 单店版去权限
	 *
	 * **/
	private Set<String> getSignleDeptOpers() {

		Set<String> hiddenOpers = new HashSet<>();
		hiddenOpers.add("VIEW_OTHERCOMP_INFO");
		hiddenOpers.add("VIEW_COMP_HOUSE");
		hiddenOpers.add("VIEW_REG_HOUSE");
		hiddenOpers.add("VIEW_AREA_HOUSE");
		hiddenOpers.add("VIEW_AREA_CUST");
		hiddenOpers.add("VIEW_REG_CUST");
		hiddenOpers.add("VIEW_COMP_CUST");
		hiddenOpers.add("EDIT_AREA_HOUSE");
		hiddenOpers.add("EDIT_REG_HOUSE");
		hiddenOpers.add("EDIT_COMP_HOUSE");
		hiddenOpers.add("EDIT_REG_CUST");
		hiddenOpers.add("EDIT_COMP_CUST");
		hiddenOpers.add("EDIT_AREA_CUST");
		hiddenOpers.add("AUTO_EXAM_VIEW_REG_HOUSE");
		hiddenOpers.add("AUTO_EXAM_VIEW_AREA_HOUSE");
		hiddenOpers.add("AUTO_EXAM_VIEW_COMP_HOUSE");
		hiddenOpers.add("AUTO_EXAM_VIEW_REG_CUST");
		hiddenOpers.add("AUTO_EXAM_VIEW_COMP_CUST");
		hiddenOpers.add("AUTO_EXAM_VIEW_AREA_CUST");
		hiddenOpers.add("MGR_OTHER_BIZ_DATA_AREA");
		hiddenOpers.add("MGR_OTHER_BIZ_DATA_COMP");
		hiddenOpers.add("MGR_OTHER_BIZ_DATA_REG");
		hiddenOpers.add("BIZ_DATA_VIEW_AREA");
		hiddenOpers.add("BIZ_DATA_VIEW_COMP");
		hiddenOpers.add("BIZ_DATA_VIEW_REG");
		hiddenOpers.add("BIZ_DATA_EXAMIN_AREA");
		hiddenOpers.add("BIZ_DATA_EXAMIN_COMP");
		hiddenOpers.add("BIZ_DATA_EXAMIN_REG");
		hiddenOpers.add("KEY_MANAGE_AREA");
		hiddenOpers.add("KEY_MANAGE_COMP");
		hiddenOpers.add("KEY_MANAGE_REG");
		hiddenOpers.add("VIEW_COMP_CUST_LIST_INFO");
		hiddenOpers.add("VIEW_REG_CUST_LIST_INFO");
		hiddenOpers.add("VIEW_AREA_CUST_LIST_INFO");
		hiddenOpers.add("VIEW_AREA_HOUSE_LIST_INFO");
		hiddenOpers.add("VIEW_REG_HOUSE_LIST_INFO");
		hiddenOpers.add("VIEW_COMP_HOUSE_LIST_INFO");
		hiddenOpers.add("JOINT_CUSTOMER_AREA_VIEW");
		hiddenOpers.add("JOINT_CUSTOMER_COMP_VIEW");
		hiddenOpers.add("JOINT_CUSTOMER_REG_VIEW");
		hiddenOpers.add("DATA_ANALYSIS_AREA_VIEW");
		hiddenOpers.add("DATA_ANALYSIS_COMP_VIEW");
		hiddenOpers.add("DATA_ANALYSIS_REG_VIEW");
		hiddenOpers.add("VIEW_COMP_DEAL");
		hiddenOpers.add("VIEW_REG_DEAL");
		hiddenOpers.add("VIEW_AREA_DEAL");
		hiddenOpers.add("MANAGE_AREA_LOAN");
		hiddenOpers.add("MANAGE_COMP_LOAN");
		hiddenOpers.add("MANAGE_REG_LOAN");
		hiddenOpers.add("VIEW_COMP_ACCOUNT");
		hiddenOpers.add("VIEW_AREA_ACCOUNT");
		hiddenOpers.add("VIEW_REG_ACCOUNT");
		hiddenOpers.add("VIEW_COMP_EXCLUSIVE_ENTRUST");
		hiddenOpers.add("VIEW_REG_EXCLUSIVE_ENTRUST");
		hiddenOpers.add("VIEW_AREA_EXCLUSIVE_ENTRUST");
		hiddenOpers.add("ATTENDANCE_COUNT_MANAGER_AREA");
		hiddenOpers.add("ATTENDANCE_COUNT_MANAGER_COMP");
		hiddenOpers.add("ATTENDANCE_COUNT_MANAGER_REG");
		hiddenOpers.add("ATTENDANCE_COUNT_VIEW_AREA");
		hiddenOpers.add("ATTENDANCE_COUNT_VIEW_COMP");
		hiddenOpers.add("ATTENDANCE_COUNT_VIEW_REG");
		hiddenOpers.add("ATTENDANCE_MANAGER_AREA");
		hiddenOpers.add("ATTENDANCE_MANAGER_COMP");
		hiddenOpers.add("ATTENDANCE_MANAGER_REG");
		hiddenOpers.add("REWARD_PUNISHMENT_INPUT_AREA");
		hiddenOpers.add("REWARD_PUNISHMENT_INPUT_COMP");
		hiddenOpers.add("REWARD_PUNISHMENT_INPUT_REG");
		hiddenOpers.add("REWARD_PUNISHMENT_AUDIT_AREA");
		hiddenOpers.add("REWARD_PUNISHMENT_AUDIT_COMP");
		hiddenOpers.add("REWARD_PUNISHMENT_AUDIT_REG");
		hiddenOpers.add("EMPLOYEE_MANAGE_AREA");
		hiddenOpers.add("EMPLOYEE_MANAGE_COMP");
		hiddenOpers.add("EMPLOYEE_MANAGE_REG");
		hiddenOpers.add("GENERATION_PAYMENT_INPUT_AREA");
		hiddenOpers.add("GENERATION_PAYMENT_INPUT_COMP");
		hiddenOpers.add("GENERATION_PAYMENT_INPUT_REG");
		hiddenOpers.add("GENERATION_PAYMENT_AUDIT_AREA");
		hiddenOpers.add("GENERATION_PAYMENT_AUDIT_COMP");
		hiddenOpers.add("GENERATION_PAYMENT_AUDIT_REG");
		hiddenOpers.add("AREA_HOUSE_DATA_EXCHANGE");
		hiddenOpers.add("COMP_HOUSE_DATA_EXCHANGE");
		hiddenOpers.add("REG_HOUSE_DATA_EXCHANGE");
		hiddenOpers.add("COMP_CUST_DATA_EXCHANGE");
		hiddenOpers.add("AREA_CUST_DATA_EXCHANGE");
		hiddenOpers.add("REG_CUST_DATA_EXCHANGE");
		hiddenOpers.add("AREA_LINK_CUST_DATA_EXCHANGE");
		hiddenOpers.add("COMP_LINK_CUST_DATA_EXCHANGE");
		hiddenOpers.add("REG_LINK_CUST_DATA_EXCHANGE");
		hiddenOpers.add("FUN_WAG_MANAGE_AREA");
		hiddenOpers.add("FUN_WAG_MANAGE_COMP");
		hiddenOpers.add("FUN_WAG_MANAGE_REG");
		hiddenOpers.add("FUN_WAG_CHECK_AREA");
		hiddenOpers.add("FUN_WAG_CHECK_COMP");
		hiddenOpers.add("FUN_WAG_CHECK_REG");
		hiddenOpers.add("MANAGE_COMP_BULLET");
		hiddenOpers.add("VIEW_AREA_RENOVATION_CUSTOMER");
		hiddenOpers.add("VIEW_REG_RENOVATION_CUSTOMER");
		hiddenOpers.add("VIEW_COMP_RENOVATION_CUSTOMER");
		hiddenOpers.add("VIEW_COMP_DEPT_FEE");
		hiddenOpers.add("VIEW_REG_DEPT_FEE");
		hiddenOpers.add("VIEW_AREA_DEPT_FEE");
		hiddenOpers.add("INPUT_AREA_DEPT_FEE");
		hiddenOpers.add("INPUT_COMP_DEPT_FEE");
		hiddenOpers.add("INPUT_REG_DEPT_FEE");
		hiddenOpers.add("AUDIT_AREA_DEPT_FEE");
		hiddenOpers.add("AUDIT_COMP_DEPT_FEE");
		hiddenOpers.add("AUDIT_REG_DEPT_FEE");
		hiddenOpers.add("MANAGE_COMP_CASE_COOPERATE");
		hiddenOpers.add("MANAGE_AREA_CASE_COOPERATE");
		hiddenOpers.add("MANAGE_REG_CASE_COOPERATE");
		hiddenOpers.add("MANAGE_AREA_ORGANIZATION");
		hiddenOpers.add("MANAGE_REG_ORGANIZATION");
		hiddenOpers.add("MANAGE_COMP_ORGANIZATION");
		hiddenOpers.add("REG_EARBEST_MONEY_MANAGE");
		hiddenOpers.add("AREA_EARBEST_MONEY_MANAGE");
		hiddenOpers.add("COMP_EARBEST_MONEY_MANAGE");
		hiddenOpers.add("BIZ_CARD_MANAGE");
		hiddenOpers.add("WARRANT_MANAGE");
		hiddenOpers.add("VIEW_WARRANT_INFO");
		hiddenOpers.add("DEAL_UPDATE_TRANSFER_DATE");
		hiddenOpers.add("EDIT_DEAL_FINANCE");
		hiddenOpers.add("DEAL_FINANC_REVIEW_MUST");
		hiddenOpers.add("DEAL_FINANC_REVIEW_ACTUAL");
		hiddenOpers.add("DEPT_EARBEST_MONEY_MANAGE");
		hiddenOpers.add("GROUP_EARBEST_MONEY_MANAGE");
		hiddenOpers.add("ACCOUNT_MANAGE");
		hiddenOpers.add("AUDIT_DEPT_DEPT_FEE");
		hiddenOpers.add("AUDIT_GROUP_DEPT_FEE");
		hiddenOpers.add("BILL_MANAGER");
		hiddenOpers.add("DEPT_CHARGE_CONFIG");
		hiddenOpers.add("DEPT_CHARGE_EXAMINE");
		hiddenOpers.add("DEPT_CHARGE_INSERT");
		hiddenOpers.add("DEPT_CHARGE_QUERY");
		hiddenOpers.add("GENERATION_PAYMENT_AUDIT_DEPT");
		hiddenOpers.add("GENERATION_PAYMENT_AUDIT_GROUP");
		hiddenOpers.add("GENERATION_PAYMENT_INPUT_DEPT");
		hiddenOpers.add("GENERATION_PAYMENT_INPUT_GROUP");
		hiddenOpers.add("INPUT_DEPT_DEPT_FEE");
		hiddenOpers.add("INPUT_GROUP_DEPT_FEE");
		hiddenOpers.add("PERFORMANCE_STATE");
		hiddenOpers.add("REWARD_PUNISHMENT_AUDIT_DEPT");
		hiddenOpers.add("REWARD_PUNISHMENT_AUDIT_GROUP");
		hiddenOpers.add("REWARD_PUNISHMENT_CONFIG");
		hiddenOpers.add("REWARD_PUNISHMENT_INPUT_DEPT");
		hiddenOpers.add("REWARD_PUNISHMENT_INPUT_GROUP");
		hiddenOpers.add("VIEW_DEPT_ACCOUNT");
		hiddenOpers.add("VIEW_DEPT_DEPT_FEE");
		hiddenOpers.add("VIEW_DEPT_GROUP_FEE");
		hiddenOpers.add("VIEW_GR_ACCOUNT");
		hiddenOpers.add("EMPLYEER_MANEUVER");
		hiddenOpers.add("LOGIN_OTHER_DEPTS");
		return hiddenOpers;
	}

 

    /**
     * @Title  : 获取角色的权限列表
     * @author : lcb
     * @Time   ： 2018/7/24
     *
     **/
    @ApiOperation("获取角色的权限列表,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpRoleOpersVo.class, message = "成功")})
    @RequestMapping("/getRoleOpersList")
    @ResponseBody
	public ResponseJson getRoleOpersList(@RequestBody GetRoleOpersParam param) {
	    return getRoleOPers(param);
    }

	private ErpResponseJson getRoleOPers(@RequestBody GetRoleOpersParam param) {
		Operator operator = getOperator();
		// 否是新版组织
		boolean newOrganizationType = operator.newOrganizationType();

		if(newOrganizationType) {
			return getRoleOPersNewOrg(param);
		}else {
			return getRoleOPersOldOrg(param);
		}
	}

	/**
	 * @Desc 旧版组织机构
	 * @Time 2019/11/28
	 * @Author lcb
	 **/
	private ErpResponseJson getRoleOPersOldOrg(GetRoleOpersParam param) {
		Operator operator = getOperator();
		Integer userId = operator.getUserId();
		String roleId = param.getRoleId();
		Integer compType = operator.getCompType();
		boolean mobileApi = operator.isMobileApi();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer areaId = param.getAreaId();
		Integer regId = param.getRegId();
		Integer deptId = param.getDeptId();
		Integer grId = param.getGrId();
		String[] queryColumn = this.parseQueryParam(cityId, compId, areaId, regId, deptId, grId, roleId);
		Integer isCompRole = param.getIsCompRole();
		String columnName = queryColumn[0];
		String columnValue = queryColumn[1];
		// 自定义的权限

		// story#11307 先判断当前公司是否说开了加盟模式，再判断当前这个人说在哪个组织，总部的就 要总部特殊的权限比如说加盟商管理权， 直营不管，如果说加盟商的人，那么要把特殊的加盟商公告管理权查出来
		List<Byte> flagList =  new ArrayList<Byte>();// 查询通用的权限，1=总部的，2=加盟商的
		flagList.add(Byte.valueOf("0"));
		if (Integer.valueOf(1).equals(operator.openPartner())) {
			if (Integer.valueOf(0).equals(operator.getPartnerId())) {// 总部
				flagList.add(Byte.valueOf("1"));
				flagList.add(Byte.valueOf("3"));
			} else if (operator.getPartnerId() > 0) {// 加盟商
				flagList.add(Byte.valueOf("2"));
			} else {
				flagList.add(Byte.valueOf("3"));
			}
		}

		// 根据组织机构来调整, 新版组织机构的组合权限查新权限，旧组织机构的查询就版权限
		Set<ErpFunOpersDto> compRoleOpers = erpFunOpersMapper.getRoleOpersList(cityId, compId, columnName, columnValue, roleId, mobileApi, flagList);

		Map<String, ErpFunOpersDto> compRoleOpersMap = new HashMap<>();
		if (compRoleOpers.size() > 0) {
			compRoleOpersMap = compRoleOpers.stream().collect(Collectors.toMap(val -> val.getOperId(), val -> val));
		}
		List<ErpSysPara> sysParaList = erpSysParaMapper.selectSysParaByCompId(cityId, compId);
		Map<String, ErpSysPara> sysParaMap = sysParaList.stream().collect(Collectors.toMap(ErpSysPara::getParamId, val -> val));
		// 模板全权限
		Set<ErpFunOpersDto> funOpersPOList = new HashSet<>();
		if (isCompRole == 1) {
			roleId = Const.DIC_ROLE_NAME_DEPUTY_MANAGER;
		}

		funOpersPOList = erpFunOpersMapper.getOpersListByRoleId(cityId, roleId, compType, null, mobileApi, flagList, false);

		// 返回结果
		Map<String, Object> resList = new HashMap<>();

		// 本人的权限列表
		List<ErpUserOpersDto> ownOpers = erpUserOpersMapper.getUsersOpers(cityId, userId);
		
		// 在加盟商模式下，当前登录人的权限ownOpers里面需要增加加盟商管理权和加盟商公告管理权，目的仅仅是为了能在配置界面能为总部或加盟商配置对应的权限
		if (!ownOpers.isEmpty() && Integer.valueOf(1).equals(operator.openPartner())) {
			Set<String> getOpers = ownOpers.stream().filter(a -> "MANAGE_PARTNER_BULLET".equals(a.getOperId()) || "PARTNER_MANAGE_OPER".equals(a.getOperId())).map(ErpUserOpersDto :: getOperId).collect(Collectors.toSet());
			if (!getOpers.contains("MANAGE_PARTNER_BULLET")) {
				ErpUserOpersDto managePartnerBulletOper = new ErpUserOpersDto();
				managePartnerBulletOper.setOperId("MANAGE_PARTNER_BULLET");
				managePartnerBulletOper.setUserId(userId);
				ownOpers.add(managePartnerBulletOper);
			}
			if (!getOpers.contains("PARTNER_MANAGE_OPER")) {
				ErpUserOpersDto partnerManageOper = new ErpUserOpersDto();
				partnerManageOper.setOperId("PARTNER_MANAGE_OPER");
				partnerManageOper.setUserId(userId);
				ownOpers.add(partnerManageOper);
			}
		}

		// 移除不应该显示的权限
		Set<String> opers = new HashSet<>();

		// 单店版去权限, 新版组织机构不用去单店版权限，因为层级就只有门店级别
		if(Const.DIC_COMP_TYPE_6.equals(compType)) {
			opers.addAll(getSignleDeptOpers());
		}

		ErpFunComp erpFunComp = erpFunCompMapper.selectByCompId(cityId, compId);
		ErpFunDeptsExample erpFunDeptsExample = new ErpFunDeptsExample();
		erpFunDeptsExample.setShardCityId(cityId);
		erpFunDeptsExample.createCriteria().andCompIdEqualTo(compId);
		List<ErpFunDepts> depts = erpFunDeptsMapper.selectByExample(erpFunDeptsExample);
		// 不是物业版和LINK版下有物业门店
		boolean remove = !(Const.DIC_COMP_TYPE_5.equals(compType) || (erpFunComp != null && erpFunComp.getCompType() == 1
				&& depts != null && depts.stream().anyMatch(it -> it.getSupportPropertyFlag() != null && it.getSupportPropertyFlag() == 1)));
		// 物业版和LINK版下的物业门店有权限, 其他的去权限
		if (remove) {
			// 新组织机构权限区别
			opers.addAll(getWuyeDeptOpers(false));
		}

		opers.addAll(getNeedHiddenOper(cityId, compId, roleId, sysParaMap, false));

		if (Integer.valueOf(1).equals(operator.openPartner())) {// 加盟商的权限需要对应类型移除
			if (null != param.getUserId()) {
				ErpFunUsers beOperUsers = erpFunUsersMapper.getFunUserByUserId(cityId, param.getUserId());// 被操作人的信息
				if (null != beOperUsers) {
					if (null != beOperUsers.getPartnerId() && beOperUsers.getPartnerId() > 0) {// 加盟商需要移除加盟商管理权
						opers.add("PARTNER_MANAGE_OPER");
					} else {// 总部和直营需要移除加盟商公告管理权
						opers.add("MANAGE_PARTNER_BULLET");
					}
				}
			}
		} else {
			opers.addAll(Arrays.asList("MANAGE_PARTNER_BULLET", "PARTNER_MANAGE_OPER"));
		}

		UserOpersUtils.removeHiddenOpers(funOpersPOList, opers);

		// 被配置的主体权限清单
		Set<ErpFunOpersDto> checkedOpersList = new HashSet<>();

		// 模板上都没有就删除掉
		Set<String> viewHouseAndCustOpers = UserOpersUtils.getViewOpersByPositionAndRunModel(roleId, null);

		Boolean compRoleOperEmpty = compRoleOpers.size() == 0;
		for (ErpFunOpersDto erpFunOpersDto : funOpersPOList) {
			boolean compHave = compRoleOpersMap.containsKey(erpFunOpersDto.getOperId());
			// 如果是给用户配权限，而且公司模板有这个权限配置
			if ((compRoleOperEmpty && viewHouseAndCustOpers.contains(erpFunOpersDto.getOperId())) || compHave) {
				checkedOpersList.add(erpFunOpersDto.clone());
			}
		}

		List<ErpFunOpersDto> modelOpersList = new ArrayList<>(funOpersPOList);
		modelOpersList.sort((val1, val2) -> {
			return Optional.ofNullable(val1.getSeqNo()).orElse(0) - Optional.ofNullable(val2.getSeqNo()).orElse(0);
		});
		List<ErpFunOpersDto> checkedRoleOpersList = new ArrayList<>(checkedOpersList);
		checkedRoleOpersList.sort((val1, val2) -> {
			return Optional.ofNullable(val1.getSeqNo()).orElse(0) - Optional.ofNullable(val2.getSeqNo()).orElse(0);
		});

		ErpCompRoles erpCompRoles = erpCompRolesMapper.getByRoleId(cityId, compId, param.getRoleId());

		if(null != erpCompRoles) {
			resList.put("partStatistCount", erpCompRoles.getPartStatistCount()); // 全部的模板权限
		}

		AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(erpFunComp.getCompNo());
		if(("2".equals(adminFunComp.getCompManagementModel().toString())
				&&"1".equals(adminFunComp.getCustomizedType().toString()))){
			fjdOperNamereplace(modelOpersList);
			fjdOperNamereplace(checkedRoleOpersList);
		}

		// 房基地权限模板的查询
		Integer templateId = erpFunCompRolesPermissionTemplateRelateMapper.getTemplateIdByRoleId(cityId, compId, param.getRoleId());
		if (null != templateId) {
			ErpFunCompPermissionTemplate erpFunCompPermissionTemplate = new ErpFunCompPermissionTemplate();
			erpFunCompPermissionTemplate.setShardCityId(cityId);
			erpFunCompPermissionTemplate.setId(templateId);
			erpFunCompPermissionTemplate = erpFunCompPermissionTemplateMapper.selectByPrimaryKey(erpFunCompPermissionTemplate);
			if (null != erpFunCompPermissionTemplate) {
				resList.put("permissionTemplateId", erpFunCompPermissionTemplate.getId());// 房基地权限模板id
				resList.put("permissionTemplateName", erpFunCompPermissionTemplate.getPermissionTemplateName());// 房基地权限模板名称
			}
		}

		resList.put("modelOpersList", modelOpersList); // 全部的模板权限
		resList.put("checkedRoleOpersList", checkedRoleOpersList); // 给用户配权限，而且公司模板有的权限配置
		resList.put("loginUserOpersList", ownOpers); // // 本人的权限列表
		resList.put("newSetOper", queryColumn[2]); // 1代表本次操作时新的权限配置，必须把本次要修改的权限全部提交上来
		return ErpResponseJson.ok(resList);
	}

	/**
	 * @Desc 新版组织权限查询
	 * @Time 2019/11/28
	 * @Author lcb
	 **/
	private ErpResponseJson getRoleOPersNewOrg(GetRoleOpersParam param) {
		Operator operator = getOperator();
		Integer userId = operator.getUserId();
		String roleId = param.getRoleId();
		Integer compType = operator.getCompType();
		boolean mobileApi = operator.isMobileApi();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		
		Integer isCompRole = param.getIsCompRole();
		Integer organizationId = param.getOrganizationId();
		String isNewSetOpers = this.judgeIsFirstSetOper(cityId, compId, organizationId, roleId);
		// 自定义的权限

		// story#11307 先判断当前公司是否说开了加盟模式，再判断当前这个人说在哪个组织，总部的就 要总部特殊的权限比如说加盟商管理权， 直营不管，如果说加盟商的人，那么要把特殊的加盟商公告管理权查出来
		List<Byte> flagList =  new ArrayList<Byte>();// 查询通用的权限，1=总部的，2=加盟商的
		flagList.add(Byte.valueOf("0"));
		if (Integer.valueOf(1).equals(operator.openPartner())) {
			if (Integer.valueOf(0).equals(operator.getPartnerId())) {// 总部
				flagList.add(Byte.valueOf("1"));
				flagList.add(Byte.valueOf("3"));
			} else if (operator.getPartnerId() > 0) {// 加盟商
				flagList.add(Byte.valueOf("2"));
			} else {
				flagList.add(Byte.valueOf("3"));
			}
		}

		// 这里查询新版组织架构的权限，条件是organization is null(表示单个权限的，单个权限是新老板通用) 或者organization =1 新版权限
		Set<ErpFunOpersDto> compRoleOpers = erpFunOpersMapper.getRoleOpersListNewOrg(cityId, compId, organizationId, roleId, mobileApi, flagList);

		Map<String, ErpFunOpersDto> compRoleOpersMap = new HashMap<>();
		if (compRoleOpers.size() > 0) {
			compRoleOpersMap = compRoleOpers.stream().collect(Collectors.toMap(val -> val.getOperId(), val -> val));
		}

		List<ErpSysPara> sysParaList = erpSysParaMapper.selectSysParaByCompId(cityId, compId);
		Map<String, ErpSysPara> sysParaMap = sysParaList.stream().collect(Collectors.toMap(ErpSysPara::getParamId, val -> val));
		// 模板全权限
		Set<ErpFunOpersDto> funOpersPOList = new HashSet<>();
		if (isCompRole == 1) {
			roleId = Const.DIC_ROLE_NAME_DEPUTY_MANAGER;
		}

		funOpersPOList = erpFunOpersMapper.getOpersListByRoleId(cityId, roleId, compType, null, mobileApi, flagList, true);
		// 这里要根据角色进行通用级别处理
		erpCompRoleOpersService.dealRoleOpersDefId(cityId, compId, roleId, funOpersPOList, true);

		// 返回结果
		Map<String, Object> resList = new HashMap<>();

		// 本人的权限列表
		List<ErpUserOpersDto> ownOpers = erpUserOpersMapper.getUsersOpers(cityId, userId);

		// 在加盟商模式下，当前登录人的权限ownOpers里面需要增加加盟商管理权和加盟商公告管理权，目的仅仅是为了能在配置界面能为总部或加盟商配置对应的权限
		if (!ownOpers.isEmpty() && Integer.valueOf(1).equals(operator.openPartner())) {
			
			ErpFunOrganizationDefinitionExample erpFunOrganizationDefinitionExample = new ErpFunOrganizationDefinitionExample();
			erpFunOrganizationDefinitionExample.setShardCityId(cityId);
			erpFunOrganizationDefinitionExample.createCriteria().andCompIdEqualTo(compId).andPartnerLevelEqualTo(Byte.valueOf("1")).andDelFlagNotEqualTo(Byte.valueOf("1"));
			List<ErpFunOrganizationDefinition> partnerOrganizationDefinitionList = erpFunOrganizationDefinitionMapper.selectByExample(erpFunOrganizationDefinitionExample);
			ErpFunOrganizationDefinition erpFunOrganizationDefinition = null;
			if (!partnerOrganizationDefinitionList.isEmpty()) {
				erpFunOrganizationDefinition = partnerOrganizationDefinitionList.get(0);
			}
			
			Set<String> getOpers = ownOpers.stream().filter(a -> "MANAGE_ORGANIZATION_BULLET".equals(a.getOperId()) || "PARTNER_MANAGE_OPER".equals(a.getOperId())).map(ErpUserOpersDto :: getOperId).collect(Collectors.toSet());
			if (!getOpers.contains("MANAGE_ORGANIZATION_BULLET")) {
				ErpUserOpersDto managePartnerBulletOper = new ErpUserOpersDto();
				managePartnerBulletOper.setOperId("MANAGE_ORGANIZATION_BULLET");
				managePartnerBulletOper.setUserId(userId);
				if (null != erpFunOrganizationDefinition) {
					managePartnerBulletOper.setDefinitionLevel(erpFunOrganizationDefinition.getDefinitionLevel());
					managePartnerBulletOper.setDefinitionName(erpFunOrganizationDefinition.getDefinitionName());
					managePartnerBulletOper.setOrganizationDefinitionId(erpFunOrganizationDefinition.getDefinitionId());
				}
				ownOpers.add(managePartnerBulletOper);
			}
			if (!getOpers.contains("PARTNER_MANAGE_OPER")) {
				ErpUserOpersDto partnerManageOper = new ErpUserOpersDto();
				partnerManageOper.setOperId("PARTNER_MANAGE_OPER");
				partnerManageOper.setUserId(userId);
				if (null != erpFunOrganizationDefinition) {
					partnerManageOper.setDefinitionLevel(erpFunOrganizationDefinition.getDefinitionLevel());
					partnerManageOper.setDefinitionName(erpFunOrganizationDefinition.getDefinitionName());
					partnerManageOper.setOrganizationDefinitionId(erpFunOrganizationDefinition.getDefinitionId());
				}
				ownOpers.add(partnerManageOper);
			}
		}

		// 移除不应该显示的权限
		Set<String> opers = new HashSet<>();

		ErpFunComp erpFunComp = erpFunCompMapper.selectByCompId(cityId, compId);
		ErpFunDeptsExample erpFunDeptsExample = new ErpFunDeptsExample();
		erpFunDeptsExample.setShardCityId(cityId);
		erpFunDeptsExample.createCriteria().andCompIdEqualTo(compId);
		List<ErpFunDepts> depts = erpFunDeptsMapper.selectByExample(erpFunDeptsExample);
		// 不是物业版和LINK版下有物业门店
		boolean remove = !(Const.DIC_COMP_TYPE_5.equals(compType) || (erpFunComp != null && erpFunComp.getCompType() == 1
				&& depts != null && depts.stream().anyMatch(it -> it.getSupportPropertyFlag() != null && it.getSupportPropertyFlag() == 1)));
		// 物业版和LINK版下的物业门店有权限, 其他的去权限
		if (remove) {
			// 新组织机构权限区别
			opers.addAll(getWuyeDeptOpers(true));
		}
	
		// 这里其实有点粗暴，只用了几个系统参数 却查询了所有参数
		opers.addAll(getNeedHiddenOper(cityId, compId, roleId, sysParaMap, true));

		if (Integer.valueOf(1).equals(operator.openPartner())) {// 加盟商的权限需要对应类型移除
			if (null != param.getUserId()) {
				ErpFunUsers beOperUsers = erpFunUsersMapper.getFunUserByUserId(cityId, param.getUserId());// 被操作人的信息
				if (null != beOperUsers) {
					if (null != beOperUsers.getPartnerId() && beOperUsers.getPartnerId() > 0) {// 加盟商需要移除加盟商管理权
						opers.add("PARTNER_MANAGE_OPER");
					}/* else {// 总部和直营需要移除加盟商公告管理权		无限组织将公告管理权合并为一个了，所有这里不隐藏该权限了，权限上的应用级别就可以判断能否用加盟商权限
						opers.add("MANAGE_ORGANIZATION_BULLET");
					}*/
				}
			}
		} else {
			opers.add("PARTNER_MANAGE_OPER");
		}
		List<ErpFunOrganizationDefinition> allEffectiveOrganizationDefinition = erpFunOrganizationDefinitionService.getAllEffectiveOrganizationDefinition(cityId, compId);
		Map<Integer, ErpFunOrganizationDefinition> definitionMap = allEffectiveOrganizationDefinition.stream().collect(Collectors.toMap(ErpFunOrganizationDefinition::getDefinitionId, val -> val));
		UserOpersUtils.removeHiddenOpers(funOpersPOList, opers);

		// 被配置的主体权限清单
		Set<ErpFunOpersDto> checkedOpersList = new HashSet<>();

		Boolean compRoleOperEmpty = compRoleOpers.size() == 0;
		for (ErpFunOpersDto erpFunOpersDto : funOpersPOList) {
			ErpFunOpersDto compHave = compRoleOpersMap.get(erpFunOpersDto.getOperId());
			
			if ("MANAGE_ORGANIZATION_BULLET".equals(erpFunOpersDto.getOperId())) {// 公告权限的层级名称单独写死
				if (Integer.valueOf(0).equals(erpFunOpersDto.getOrganizationDefinitionId())) {
					erpFunOpersDto.setDefinitionName("公司");
				} else if (Integer.valueOf(1).equals(erpFunOpersDto.getOrganizationDefinitionId())) {
					erpFunOpersDto.setDefinitionName("本组织");
				} else if (Integer.valueOf(-1).equals(erpFunOpersDto.getOrganizationDefinitionId())) {
					erpFunOpersDto.setDefinitionName("本加盟商");
				}
			}
			
			// 如果是给用户配权限，而且公司模板有这个权限配置
			if (compRoleOperEmpty || null != compHave) {
				ErpFunOpersDto clone = erpFunOpersDto.clone();
				if(null != compHave && null != compHave.getOrganizationDefinitionId()) {
					clone.setOrganizationDefinitionId(compHave.getOrganizationDefinitionId());
				}
				checkedOpersList.add(clone);
			}
		}



		List<ErpFunOpersDto> modelOpersList = new ArrayList<>(funOpersPOList);
		modelOpersList.sort((val1, val2) -> {
			return Optional.ofNullable(val1.getSeqNo()).orElse(0) - Optional.ofNullable(val2.getSeqNo()).orElse(0);
		});

		checkedOpersList.stream().forEach(val-> {
			Byte operType = val.getOperType();
			Integer organizationDefinitionId = val.getOrganizationDefinitionId();
			// 判断是组合权限，并且层级定义是具体组织的  0是公司  -2是个人
			if(null != operType && operType > 0 && null != organizationDefinitionId && organizationDefinitionId > 0) {
				ErpFunOrganizationDefinition erpFunOrganizationDefinition = definitionMap.get(organizationDefinitionId);
				if(null != erpFunOrganizationDefinition) {
					val.setDefinitionLevel(erpFunOrganizationDefinition.getDefinitionLevel());
					val.setDefinitionName(erpFunOrganizationDefinition.getDefinitionName());
				}
			}
		});

		List<ErpFunOpersDto> checkedRoleOpersList = new ArrayList<>(checkedOpersList);

		ownOpers.stream().forEach(val-> {
			Integer organizationDefinitionId = val.getOrganizationDefinitionId();
			if(null != organizationDefinitionId && 0 == organizationDefinitionId) {
				val.setDefinitionLevel(0);
			}
			// 判断是组合权限，并且层级定义是具体组织的  0是公司  -2是个人
			if(null != organizationDefinitionId && organizationDefinitionId > 0) {
				ErpFunOrganizationDefinition erpFunOrganizationDefinition = definitionMap.get(organizationDefinitionId);
				if(null != erpFunOrganizationDefinition) {
					val.setDefinitionLevel(erpFunOrganizationDefinition.getDefinitionLevel());
					val.setDefinitionName(erpFunOrganizationDefinition.getDefinitionName());
				}
			}
		});

		checkedRoleOpersList.sort((val1, val2) -> {
			return Optional.ofNullable(val1.getSeqNo()).orElse(0) - Optional.ofNullable(val2.getSeqNo()).orElse(0);
		});

		ErpCompRoles erpCompRoles = erpCompRolesMapper.getByRoleId(cityId, compId, param.getRoleId());

		if(null != erpCompRoles) {
			resList.put("partStatistCount", erpCompRoles.getPartStatistCount()); // 全部的模板权限
		}

		AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(erpFunComp.getCompNo());
		if(("2".equals(adminFunComp.getCompManagementModel().toString())
				&&"1".equals(adminFunComp.getCustomizedType().toString()))){
			fjdOperNamereplace(modelOpersList);
			fjdOperNamereplace(checkedRoleOpersList);
		}

		// 房基地权限模板的查询
		Integer templateId = erpFunCompRolesPermissionTemplateRelateMapper.getTemplateIdByRoleId(cityId, compId, param.getRoleId());
		if (null != templateId) {
			ErpFunCompPermissionTemplate erpFunCompPermissionTemplate = new ErpFunCompPermissionTemplate();
			erpFunCompPermissionTemplate.setShardCityId(cityId);
			erpFunCompPermissionTemplate.setId(templateId);
			erpFunCompPermissionTemplate = erpFunCompPermissionTemplateMapper.selectByPrimaryKey(erpFunCompPermissionTemplate);
			if (null != erpFunCompPermissionTemplate) {
				resList.put("permissionTemplateId", erpFunCompPermissionTemplate.getId());// 房基地权限模板id
				resList.put("permissionTemplateName", erpFunCompPermissionTemplate.getPermissionTemplateName());// 房基地权限模板名称
			}
		}

		resList.put("modelOpersList", modelOpersList); // 全部的模板权限
		resList.put("checkedRoleOpersList", checkedRoleOpersList); // 给用户配权限，而且公司模板有的权限配置
		resList.put("loginUserOpersList", ownOpers); // // 本人的权限列表
		resList.put("newSetOper", isNewSetOpers); // 1代表本次操作时新的权限配置，必须把本次要修改的权限全部提交上来
		return ErpResponseJson.ok(resList);
	}


	@ApiOperation("获取角色的权限列表,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpRoleOpersVo.class, message = "成功")})
	@RequestMapping("/getAppRoleOpersList")
	@ResponseBody
	public ResponseJson getAppRoleOpersList(@RequestBody GetRoleOpersParam param) {
		ErpResponseJson roleOpersList = getRoleOPers(param);
		Map<String, Object> resList = (Map<String, Object>) roleOpersList.getData();
		List<ErpFunOpersDto> modelOpersList = (List<ErpFunOpersDto>) resList.get("modelOpersList");// 全部的模板权限
		List<ErpFunOpersDto> checkedRoleOpersList = (List<ErpFunOpersDto>) resList.get("checkedRoleOpersList");// 给用户配权限，而且公司模板有的权限配置
		List<ErpFunOpers> loginUserOpersList = (List<ErpFunOpers>) resList.get("loginUserOpersList");// // 本人的权限列表
		String newSetOper = (String) resList.get("newSetOper");// 1代表本次操作时新的权限配置，必须把本次要修改的权限全部提交上来
		
		AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(getOperator().getCompNo());
		if(("2".equals(adminFunComp.getCompManagementModel().toString())
        		&&"1".equals(adminFunComp.getCustomizedType().toString()))){
			fjdOperNamereplace(modelOpersList);
			fjdOperNamereplace(checkedRoleOpersList);
		}
		
		Integer permissionTemplateId = null != resList.get("permissionTemplateId") ? (Integer) resList.get("permissionTemplateId") : null;
		String permissionTemplateName = null != resList.get("permissionTemplateName") ? (String) resList.get("permissionTemplateName") : null;
		
		ErpRoleOpersVo erpRoleOpersVo = new ErpRoleOpersVo();
		erpRoleOpersVo.setModelOpersList(modelOpersList);
		erpRoleOpersVo.setLoginUserOpersList(loginUserOpersList);
		erpRoleOpersVo.setCheckedRoleOpersList(checkedRoleOpersList);
		erpRoleOpersVo.setNewSetOper(newSetOper);
		erpRoleOpersVo.setPermissionTemplateId(permissionTemplateId);
		erpRoleOpersVo.setPermissionTemplateName(permissionTemplateName);
		roleOpersList.setData(erpRoleOpersVo);
		return roleOpersList;
	}
//    /**
//      * @Title  : 获取权限列表
//      * @author : lcb
//      * @Time   ： 2018/7/24
//      *
//      **/
//    @RequestMapping("/getBaseOpersList")
//    @ResponseBody
//	@Deprecated // 这个接口应该没地方使用了2019-11-19
//    public ResponseJson getBaseOpersList(@RequestBody BaseMapParam param) {
//        Integer userId = param.getInteger("userId");
//        String roleId = param.getString("roleId");
//        Integer isCompRole = param.getInteger("isCompRole");
//        List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
//        Integer cityId = getOperator().getCityId();
//        Integer compId = getOperator().getCompId();
//        boolean mobileApi = getOperator().isMobileApi();
//
//        // story#11307 先判断当前公司是否说开了加盟模式，再判断当前这个人说在哪个组织，总部的就 要总部特殊的权限比如说加盟商管理权， 直营不管，如果说加盟商的人，那么要把特殊的加盟商公告管理权查出来
//        List<Byte> flagList =  new ArrayList<Byte>();// 查询通用的权限，1=总部的，2=加盟商的
//        flagList.add(Byte.valueOf("0"));
//        if (Integer.valueOf(1).equals(getOperator().openPartner())) {
//        	if (Integer.valueOf(0).equals(getOperator().getPartnerId())) {// 总部
//				flagList.add(Byte.valueOf("1"));
//				flagList.add(Byte.valueOf("3"));
//			} else if (getOperator().getPartnerId() > 0) {// 加盟商
//				flagList.add(Byte.valueOf("2"));
//			} else {// 加盟商模式下的直营
//				flagList.add(Byte.valueOf("3"));
//			}
//        }
//
//        Map<String, Object> hm = new HashMap<>();
//        if (userId != null) {
//            ErpFunUsers users = erpFunUsersMapper.getUserInfoByUserId(cityId, userId);
//            String[] queryColumn = getQueryColumnByCompOpers(cityId, compId,roleId, users);
//            List<ErpCompRoleOpers> compRoleOpersList = erpCompRoleOpersMapper.getCheckedCommonMapOpers(cityId, compId, queryColumn[0], queryColumn[1], roleId, 0, flagList);
//
//            Map<String, ErpCompRoleOpers> compRoleOpersPOMap = compRoleOpersList.stream().collect(Collectors.toMap(ErpCompRoleOpers::getOperId, val -> val));
//
//            List<ErpSysPara> sysParaList = erpSysParaMapper.selectSysParaByCompId(cityId, compId);
//            Map<String, ErpSysPara> sysParaMap = sysParaList.stream().collect(Collectors.toMap(ErpSysPara::getParamId, val -> val));
//
//            if (isCompRole == 1) {
//                users.setUserPosition(Const.DIC_ROLE_NAME_DEPUTY_MANAGER);
//            }
//
//            // 获取选中用户当前角色拥有的普通权限
////            Map<String, ErpFunOpers> funOpersPOs = this.getUsersCommonOperMapByUser(cityId, users, 0);
//            // 获登陆取用户拥有的所有权限
//            List<ErpFunOpers> ownOpersPOs = erpFunOpersMapper.getFunOpersListById(cityId, getOperator().getUserId(), mobileApi);
//            Map<String, ErpFunOpers> ownOperMap = ownOpersPOs.stream().collect(Collectors.toMap(ErpFunOpers::getOperId, val -> val));
//
//            // 获取角色应该有的权限
//            Set<ErpFunOpersDto> metaRoleOpers = new HashSet<>();
//            Integer compType = getOperator().getCompType();
//            // 自定义权限
//            if (isCompRole == 1) {
//                metaRoleOpers = erpFunOpersMapper.getOpersListByRoleId(cityId, Const.DIC_ROLE_NAME_DEPUTY_MANAGER, compType, 0, mobileApi, flagList, false);
//            } else {
//                metaRoleOpers = erpFunOpersMapper.getOpersListByRoleId(cityId, roleId, compType, 0, mobileApi, flagList, false);
//            }
//
//            // 需要移除的权限
//            Set<String> opers = new HashSet<String>();
//
//            List<ErpFunOpersDto> list = new ArrayList<>();
//            // 个人求购 求售 出租 出售 权公有 DEL_COMMUNIC_INFO 是部分拥有
//            opers.addAll(getNeedHiddenOper(cityId, compId, roleId, sysParaMap, ));
//            opers.addAll(needHiddenOpersByRoleAndSysRun(cityId, compId, roleId));
//
//            int count = adminFunDeptsMapper.getYouDeptCountByCompNo(getOperator().getCompNo());
//            if (count <= 0) {
//                opers.add("CITY_PUBLIC_MANAGEMENT");// 城市公盘管理权，公司下面有门店开通了优家才显示此权限，否则就隐藏
//            }
//            opers.addAll(needHiddenOpersByCustomized(sysParaMap));
//            UserOpersUtils.removeHiddenOpers(metaRoleOpers, opers);
//
//            ErpFunOpersDto funOpersVO = null;
//            // 查询系统参数 判断当前公司是否可以修改基础权限
//            String custRole = erpSysParaMapper.getParamValue(cityId, compId, "CUST_ROLE");
//            for (ErpFunOpers funOpersPO : metaRoleOpers) {
//                funOpersVO = new ErpFunOpersDto();
//                try {
//                    BeanUtil.copyObject(funOpersPO, funOpersVO);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
////                if (funOpersPOs.containsKey(funOpersPO.getOperId())) {
////                    funOpersVO.setChecked("CHECKED");
////                    list.add(funOpersVO);
////                } else {
////                    funOpersVO.setChecked("");
////                    if (compRoleOpersPOMap.isEmpty() || compRoleOpersPOMap.containsKey(funOpersPO.getOperId())) {
////                        list.add(funOpersVO);
////                    }
////                }
//                // 判断当前权限是否可以被修改 如果可以修改 则隐藏固定的基本权限
////                if (!"1".equals(custRole)) {
////                    funOpersVO.setDisabled("DISABLED");
////                } else {
////                    // 1:只能操作自己有的权限
////                    // 2:如果是自己的则不允许编辑
////                    if (!ownOperMap.containsKey(funOpersPO.getOperId()) || getOperator().getUserId().equals(userId)) {
////                        funOpersVO.setDisabled("DISABLED");
////                    }
////                }
//            }
//            hm.put("opers", list);
//            returnList.add(hm);
//        } else {
//            String[] queryColumn = this.parseQueryParam(cityId, compId, getOperator().getAreaId(), getOperator().getRegId(), getOperator().getDeptId(), getOperator().getGrId(), roleId);
//            String columnName = queryColumn[0];
//            String columnValue = queryColumn[1];
//            getOperator().getParamMap().put("NEW_SET_OPER", queryColumn[2]);
//            List<ErpFunOpersDto> funOpersDtoList = getCheckedCommonOpersList4AllUse(cityId, compId, getOperator().getCompType(), getOperator().getUserId(), columnValue, columnName, roleId, isCompRole, 0,null, mobileApi, flagList);
//            hm.put("opers", funOpersDtoList);
//            Map<String, String> newOper = new HashMap<>();
//            newOper.put("newSetOper", getOperator().getParamMap().get("NEW_SET_OPER"));
//            hm.put("newSetOper", newOper);
//            returnList.add(hm);
//        }
//        return ErpResponseJson.ok(returnList);
//    }


    /**
      * @Title  : 高级权限
      * @author : lcb
      * @Time   ： 2018/7/20
      *
      **/
//    @RequestMapping("/getAdvanceOpersList")
//    @ResponseBody
//	@Deprecated
//    public ResponseJson getAdvanceOpersList(@RequestBody BaseMapParam param) {
//        Integer userId = param.getInteger("userId");
//        String roleId = param.getString("roleId");
//        Integer cityId = getOperator().getCityId();
//        Integer compId = getOperator().getCompId();
//        boolean mobileApi = getOperator().isMobileApi();
//        Integer isCompRole = param.getInteger("isCompRole");
//        List<ErpFunOpersDto> resList = new ArrayList<>();
//
//	     // story#11307 先判断当前公司是否说开了加盟模式，再判断当前这个人说在哪个组织，总部的就 要总部特殊的权限比如说加盟商管理权， 直营不管，如果说加盟商的人，那么要把特殊的加盟商公告管理权查出来
//		List<Byte> flagList =  new ArrayList<Byte>();// 查询通用的权限，1=总部的，2=加盟商的
//		flagList.add(Byte.valueOf("0"));
//		if (Integer.valueOf(1).equals(getOperator().openPartner())) {
//			if (Integer.valueOf(0).equals(getOperator().getPartnerId())) {// 总部
//				flagList.add(Byte.valueOf("1"));
//				flagList.add(Byte.valueOf("3"));
//			} else if (getOperator().getPartnerId() > 0) {// 加盟商
//				flagList.add(Byte.valueOf("2"));
//			} else {
//				flagList.add(Byte.valueOf("3"));// 加盟商模式下的直营
//			}
//		}
//
//        if (null != userId) {
//            ErpFunUsers funUsersPO = erpFunUsersMapper.getUserInfoByUserId(cityId, userId);
//            String[] queryColumn = getQueryColumnByCompOpers(cityId, compId,roleId, funUsersPO);
//            List<ErpCompRoleOpers> compRoleOpersList = erpCompRoleOpersMapper.getCheckedCommonMapOpers(cityId, compId, queryColumn[0], queryColumn[1], roleId, 1, flagList);
//
//            Map<String, ErpCompRoleOpers> compRoleOpersPOMap = compRoleOpersList.stream().collect(Collectors.toMap(ErpCompRoleOpers::getOperId, val -> val));
//
//            List<ErpSysPara> sysParaList = erpSysParaMapper.selectSysParaByCompId(cityId, compId);
//            Map<String, ErpSysPara> sysParaMap = sysParaList.stream().collect(Collectors.toMap(ErpSysPara::getParamId, val -> val));
//
//            if (1 == isCompRole) {
//                funUsersPO.setUserPosition(Constants_DIC.DIC_ROLE_NAME_DEPUTY_MANAGER);
//            }
//
//            //客户的高级权限列表
////            Map<String, ErpFunOpers> funOpersPOs = this.getUsersCommonOperMapByUser(cityId, funUsersPO, 1);
//            // 获取选中用户当前角色拥有的普通权限
//            // 获登陆取用户拥有的所有权限
//            List<ErpFunOpers> ownOpersPOs = erpFunOpersMapper.getFunOpersListById(cityId, getOperator().getUserId(), mobileApi);
//            Map<String, ErpFunOpers> ownOperMap = ownOpersPOs.stream().collect(Collectors.toMap(ErpFunOpers::getOperId, val -> val));
//
//            //获取角色的高级权限
//            //重新复制避免修改到内存引用(可能有BUG后面检查) 陈文超
//            Integer compType = getOperator().getCompType();
//            Set<ErpFunOpersDto> metaRoleOpers = new HashSet<>();
//            // 自定义权限
//            if (isCompRole == 1) {
//                metaRoleOpers = erpFunOpersMapper.getOpersListByRoleId(cityId, Const.DIC_ROLE_NAME_DEPUTY_MANAGER, compType, 1, mobileApi, flagList, false);
//            } else {
//                metaRoleOpers = erpFunOpersMapper.getOpersListByRoleId(cityId, roleId, compType, 1, mobileApi, flagList, false);
//            }
//
//            // 需要移除的权限
//            Set<String> opers = new HashSet<String>();
//
//            opers.addAll(getNeedHiddenOper(cityId, compId, roleId, sysParaMap));
//            opers.addAll(needHiddenOpersByRoleAndSysRun(cityId, compId, roleId));
//            //以用户本人的权限为主 陈文超
//            //因为在修改权限之前有些权限可能已经配置了，但是后期严格控制后会直接隐藏一部分权限，但是必须先显示出用户已经具备的权限
//            //只有这里需要添加，其他查询权限的地方不需要添加
//            opers.addAll(hiddenOpersBySysParam(cityId, sysParaMap));
////            UserOpersUtils.beforeFilterHaveOpers(opers, funOpersPOs.keySet(), getOperator().getAreaFlag());
//            // 必须放在UserOpersUtils.beforeFilterHaveOpers下面
//            int count = adminFunDeptsMapper.getYouDeptCountByCompNo(getOperator().getCompNo());
//            if (count <= 0) {
//                opers.add("CITY_PUBLIC_MANAGEMENT");// 城市公盘管理权，公司下面有门店开通了优家才显示此权限，否则就隐藏
//            }
//            UserOpersUtils.removeHiddenOpers(metaRoleOpers, opers);
//            for (ErpFunOpers funOpersPO : metaRoleOpers) {
//                ErpFunOpersDto funOpersVO = new ErpFunOpersDto();
//                try {
//                    BeanUtil.copyObject(funOpersPO, funOpersVO);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }else {
//            String [] queryColumn  = this.parseQueryParam(cityId, compId, getOperator().getAreaId(), getOperator().getRegId(), getOperator().getDeptId(), getOperator().getGrId(), roleId);
//            String columnName = queryColumn[0];
//            String columnValue = queryColumn[1];
//            resList = this.getCheckedAdvanceOpers4AllUse(cityId, compId, getOperator().getCompType(), getOperator().getUserId(), columnValue, columnName, roleId, isCompRole, 1, null, mobileApi, flagList);
//        }
//
//        return ErpResponseJson.ok(resList);
//    }

    /**
     * 查询出高级权限
     * 陈文超
     * aimUserId：被修改人的权限
     * @throws Exception
     */
//    @Deprecated
//    private List<ErpFunOpersDto> getCheckedAdvanceOpers4AllUse(Integer cityId, Integer compId, Integer compType, Integer userId, String columnValue, String columnName,String roleId, Integer isCompRole, Integer operType,String aimUserId, Boolean mobileApi, List<Byte> flagList) {
//        //查询该角色勾选了的权限
//        //先判断 COMP_ROLE_OPERS查询该角色的所有可选的权限,如果没有择查询ROLE_OPERS
//        List<ErpCompRoleOpers> compRoleOpers = erpCompRoleOpersMapper.getCheckedCommonMapOpers(cityId,compId,columnName,columnValue,roleId, operType, flagList);
//        Map<String,ErpCompRoleOpers> compRoleOpersPOMap = compRoleOpers.stream().collect(Collectors.toMap(ErpCompRoleOpers::getOperId,val->val));
//        List<ErpSysPara> sysParaList = erpSysParaMapper.selectSysParaByCompId(cityId, compId);
//        Map<String,ErpSysPara> sysParaMap =sysParaList.stream().collect(Collectors.toMap(ErpSysPara::getParamId,val->val));
//
//        //重新复制避免修改到内存引用(可能有BUG后面检查) 陈文超
//        Set<ErpFunOpersDto> funOpersPOList = new HashSet<>();
//        // 自定义权限
//        if(1 == isCompRole){
//            // 给用户换角色，如果是自定义角色而且没有配置角色权限返回空
//            if(StringUtils.isNotBlank(aimUserId) && (compRoleOpersPOMap == null || compRoleOpersPOMap.size() == 0)){
//                return null;
//            }
//            roleId = Constants_DIC.DIC_ROLE_NAME_DEPUTY_MANAGER;
//        }
////        funOpersPOList = getEpCommonOperByRoleId(cityId, roleId, compType, operType);
//        funOpersPOList = erpFunOpersMapper.getOpersListByRoleId(cityId, roleId, compType, operType, mobileApi, flagList, false);
//        //本人的高级权限列表
//        List<ErpFunOpers> ownOpers = erpFunOpersMapper.getFunOpersListById(cityId, userId, mobileApi);
//        Map<String,ErpFunOpers> ownOpersPOs =ownOpers.stream().collect(Collectors.toMap(ErpFunOpers::getOperId,val->val));
//
//        Set<String> opers = new HashSet<String>();
//        opers.addAll(getNeedHiddenOper(cityId, compId, roleId, sysParaMap));
//        opers.addAll(needHiddenOpersByRoleAndSysRun(cityId, compId, roleId));
//        int count = adminFunDeptsMapper.getYouDeptCountByCompNo(getOperator().getCompNo());
//        if(count <= 0){
//            opers.add("CITY_PUBLIC_MANAGEMENT");// 城市公盘管理权，公司下面有门店开通了优家才显示此权限，否则就隐藏
//        }
//        UserOpersUtils.removeHiddenOpers(funOpersPOList, opers);
//
//        //当前模式和角色的默认房客源查看权限范围集合
//        Set<String> viewHouseAndCustOpers = UserOpersUtils.getViewOpersByPositionAndRunModel(roleId, null);
//
//        //添加CHECKED
//        boolean compRoleOperEmpty = compRoleOpersPOMap.isEmpty();
//        List<ErpFunOpersDto> funOpersVOList = new ArrayList<ErpFunOpersDto>();
//        for(ErpFunOpers funOpersPO : funOpersPOList){
//            boolean comHave = compRoleOpersPOMap.containsKey(funOpersPO.getOperId());
//            boolean ownHave = ownOpersPOs.containsKey(funOpersPO.getOperId());
//            ErpFunOpersDto funOpersVO = new ErpFunOpersDto();
//            // 如果是给用户配权限，而且公司模板有这个权限配置
//            if(compRoleOperEmpty || comHave || StringUtils.isBlank(aimUserId)){
//                try {
//                    BeanUtil.copyObject(funOpersPO,funOpersVO);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                funOpersVOList.add(funOpersVO);
//            } else {
//                continue;
//            }
//            //如果没有公司模版 则根据角色和运行默认设置房客源默认查看权限
////            if(comHave || (compRoleOperEmpty && viewHouseAndCustOpers.contains(funOpersPO.getOperId()))){
////                funOpersVO.setChecked("CHECKED");
////            }
////            //aimUserId 为空则代表是 角色权限配置 那边调用的查询，否则是在权限编辑他人权限中调用
////            //1:只能操作自己有的权限,如果连自己都没这个权限的话，则不能操作别人的该项权限
////            //2:如果是自己的则不允许编辑
////            if(!ownHave || getOperator().getUserId().equals(aimUserId)){
////                funOpersVO.setDisabled("DISABLED");
////            }
//        }
//        return funOpersVOList;
//    }


    /**
     * 查询出普通权限
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/6/20
     */
//    @Deprecated
//    private List<ErpFunOpersDto> getCheckedCommonOpersList4AllUse(Integer cityId, Integer compId, Integer compType,Integer userId, String columnValue, String columnName, String roleId, Integer isCompRole, Integer operType, String aimUserId, Boolean mobileApi, List<Byte> flagList) {
//        //查询该角色勾选了的权限
//        //先判断 COMP_ROLE_OPERS查询该角色的所有可选的权限,如果没有择查询ROLE_OPERS
//        List<ErpCompRoleOpers> compRoleOpers = erpCompRoleOpersMapper.getCheckedCommonMapOpers(cityId,compId,columnName,columnValue,roleId, operType, flagList);
//        Map<String,ErpCompRoleOpers> compRoleOpersPOMap = compRoleOpers.stream().collect(Collectors.toMap(ErpCompRoleOpers::getOperId,val->val));
//        List<ErpSysPara> sysParaList = erpSysParaMapper.selectSysParaByCompId(cityId, compId);
//        Map<String,ErpSysPara> sysParaMap =sysParaList.stream().collect(Collectors.toMap(ErpSysPara::getParamId,val->val));
//        //重新复制避免修改到内存引用(可能有BUG后面检查)
//        Set<ErpFunOpersDto> funOpersPOList = new HashSet<>();
//        if(isCompRole==1){
//            // 给用户换角色，如果是自定义角色而且没有配置角色权限返回空
//            if(compRoleOpersPOMap.isEmpty() && StringUtils.isNotBlank(aimUserId)){
//                return null;
//            }
//            roleId = Const.DIC_ROLE_NAME_DEPUTY_MANAGER;
//        }
//
//        funOpersPOList =  erpFunOpersMapper.getOpersListByRoleId(cityId, roleId, compType, operType, mobileApi, flagList, false);
//        //本人的高级权限列表
//        List<ErpFunOpers> ownOpers = erpFunOpersMapper.getFunOpersListById(cityId, userId, mobileApi);
//        Map<String,ErpFunOpers> ownOpersPOs =ownOpers.stream().collect(Collectors.toMap(ErpFunOpers::getOperId,val->val));
//        //查询系统参数 判断当前公司是否可以修改基础权限
//        boolean custRole = "1".equals(erpSysParaMapper.getParamValue(cityId,compId,"CUST_ROLE"));
//        // 移除不应该显示的权限
//        Set<String> opers = new HashSet<>();
//        opers.addAll(getNeedHiddenOper(cityId, compId, roleId, sysParaMap));
//        opers.addAll(needHiddenOpersByRoleAndSysRun(cityId, compId, roleId));
//        int count = adminFunDeptsMapper.getYouDeptCountByCompNo(getOperator().getCompNo());
//        if(count <= 0){
//            opers.add("CITY_PUBLIC_MANAGEMENT");// 城市公盘管理权，公司下面有门店开通了优家才显示此权限，否则就隐藏
//        }
//        UserOpersUtils.removeHiddenOpers(funOpersPOList, opers);
//        //添加CHECKED
//        boolean compRoleOperEmpty = compRoleOpersPOMap.isEmpty();
//        List<ErpFunOpersDto> funOpersVOList = new ArrayList<>();
//        for(ErpFunOpers funOpersPO : funOpersPOList){
//            boolean compHave = compRoleOpersPOMap.containsKey(funOpersPO.getOperId());
//            boolean ownHave = ownOpersPOs.containsKey(funOpersPO.getOperId());
//            ErpFunOpersDto funOpersVO = new ErpFunOpersDto();
//            // 如果是给用户配权限，而且公司模板有这个权限配置
//            if(compRoleOperEmpty || compHave || StringUtils.isBlank(aimUserId)){
//                try {
//                    BeanUtil.copyObject(funOpersPO,funOpersVO);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                funOpersVOList.add(funOpersVO);
//            } else {
//                continue;
//            }
////            if(compRoleOperEmpty || compHave || StringUtils.isBlank(aimUserId)){
////                funOpersVO.setChecked("CHECKED");
////            }
////            //公司不允许编辑基本权限
////            if(!custRole){
////                funOpersVO.setDisabled("DISABLED");
////            }else{
////                //aimUserId 为空则代表是 角色权限配置 那边调用的查询，否则是在权限编辑他人权限中调用
////                //1:只能操作自己有的权限,如果连自己都没这个权限的话，则不能操作别人的该项权限
////                //2:如果是自己的则不允许编辑
////                if(!ownHave || getOperator().getUserId().equals(aimUserId)){
////                    funOpersVO.setDisabled("DISABLED");
////                }
////            }
//        }
//        return funOpersVOList;
//    }

    /**
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/6/20
     */
//    @Deprecated
//    public Set<String> needHiddenOpersByRoleAndSysRun(Integer cityId, Integer compId, String roleId) {
//        //		5:分组 < 4:门店 < 3:片区 < 2:大区 < 1:全公司
////		OPER_RANGE_TYPE ：1,2,3
//        Set<String> opers = new HashSet<>();
//        //见习经纪人只有门店和分组的权限，默认到个人
//        if(Const.DIC_ROLE_NAME_PRACTY_BIZ.equals(roleId)){
//            //门店以上的权限全部移除
//            List<ErpFunOpers> tmps = getOpersByRoleId(cityId, Const.DIC_OPER_RANGE_LEVEL_SEQ_4);
//
//            if(tmps.size() > 0) {
//                opers = tmps.stream().collect(Collectors.mapping(val-> val.getOperId(), Collectors.toSet()));
//            }
//            return opers;
//        }else{
//            boolean publicFun = getSysRunModelIsPublic(cityId, compId, Const.DIC_CASE_TYPE_SALE_FUN);
//            boolean publicCust = getSysRunModelIsPublic(cityId, compId, Const.DIC_CASE_TYPE_BUY_CUST);
//            //查询出所有的房客源查看的权限，再进行筛选
//            Set<Integer> operTypes = new HashSet<>();
//            operTypes.add(Const.DIC_FUN_OPERS_OPER_TYPE_1);
//            operTypes.add(Const.DIC_FUN_OPERS_OPER_TYPE_2);
//            List<ErpFunOpers> tmps = getOpersByOperType(cityId, operTypes);
//            //过滤掉需要隐藏的权限
//            for(ErpFunOpers funOpersPO : tmps){
//                //片区经理所有的系统运行模式下都要移除的权限
//                if(Const.DIC_ROLE_NAME_REGION_MANAGER.equals(roleId)){
//                    removeHouseViewCompOper(cityId, compId, opers,funOpersPO);
//                    removeCustViewCompOper(cityId, compId, opers,funOpersPO);
//                    removeCustViewAreaOper(cityId, compId, opers,funOpersPO);
//                } else if(Const.DIC_ROLE_NAME_CUST_SERVER.equals(roleId)){
//                    //客服专员
//                    //房源去掉全公司、客源去掉全公司和大区
//                    removeHouseViewCompOper(cityId, compId, opers,funOpersPO);
//                    removeCustViewCompOper(cityId, compId, opers,funOpersPO);
//                    removeCustViewAreaOper(cityId, compId, opers,funOpersPO);
//                } else {
//                    //全公盘制
//                    if(publicFun && publicCust){
//                        sysRunAllPublicPlate(cityId, compId, roleId, opers, funOpersPO);
//                        //房源公房制 -- 客源私盘制【公房私客制下】
//                    } else if(publicFun){
//                        sysRunPublicHousePlate(cityId, compId, roleId, opers, funOpersPO);
//                        //客源公客制 -- 房源私盘制【公客私房制下】
//                    } else if(publicCust){
//                        sysRunPublicCustPlate(cityId, compId, roleId, opers, funOpersPO);
//                    } else {
//                        sysRunPublicHousePlate(cityId, compId, roleId, opers, funOpersPO);
//                    }
//                }
//            }
//        }
//        return opers;
//    }

    /**
     * 公房私客权限控制
     * @param roleId
     * @param opers
     * @param funOpersPO
     */
//    @Deprecated
//    private void sysRunPublicCustPlate(Integer cityId, Integer compId, String roleId,Set<String> opers,ErpFunOpers funOpersPO){
//        //私房公客制下的门店经理
//        if(Const.DIC_ROLE_NAME_BRANCH_MANAGER.equals(roleId)){
//            //房源去掉全公司、客源去掉全公司和大区
//            this.removeHouseViewCompOper(cityId, compId, opers,funOpersPO);
//            this.removeCustViewCompOper(cityId, compId, opers,funOpersPO);
//            this.removeCustViewAreaOper(cityId, compId, opers,funOpersPO);
//        } else if(Const.DIC_ROLE_NAME_SECRETARIAL.equals(roleId)){
//            //店务秘书
//            //房源去掉全公司、客源去掉全公司、大区
//            this.removeHouseViewCompOper(cityId, compId, opers,funOpersPO);
//            this.removeCustViewAreaOper(cityId, compId, opers,funOpersPO);
//            this.removeCustViewCompOper(cityId, compId, opers,funOpersPO);
//        } else if(Const.DIC_ROLE_NAME_BIZ_MANAGER.equals(roleId)){
//            //销售组长
//            //房源去掉全公司、客源去掉全公司、大区
//            this.removeHouseViewCompOper(cityId, compId, opers,funOpersPO);
//            this.removeCustViewCompOper(cityId, compId, opers,funOpersPO);
//            this.removeCustViewAreaOper(cityId, compId, opers,funOpersPO);
//        } else if(Const.DIC_ROLE_NAME_COMMON_BIZ.equals(roleId)){
//            //正式经纪人
//            //房源去掉全公司、客源去掉全公司和大区
//            this.removeHouseViewCompOper(cityId, compId, opers,funOpersPO);
//            this.removeCustViewCompOper(cityId, compId, opers,funOpersPO);
//            this.removeCustViewAreaOper(cityId, compId, opers,funOpersPO);
//        }
//    }

    /**
     * 公房私客权限控制
     * @author
     * @date Jan 14, 2016 3:56:26 PM
     */
//    @Deprecated
//    private void sysRunPublicHousePlate(Integer cityId, Integer compId, String roleId,Set<String> opers,ErpFunOpers funOpersPO){
//        //大区经理
//        //客源去掉全公司
//        if(Const.DIC_ROLE_NAME_BIZ_GENERAL.equals(roleId)){
//            this.removeCustViewCompOper(cityId, compId, opers,funOpersPO);
//        }else if(Const.DIC_ROLE_NAME_BRANCH_MANAGER.equals(roleId)){
//            //门店经理
//            //房源去掉全公司、客源去掉全公司、大区和片区
//            this.removeHouseViewCompOper(cityId, compId, opers,funOpersPO);
//            this.removeCustViewCompOper(cityId, compId, opers,funOpersPO);
//            this.removeCustViewAreaOper(cityId, compId, opers,funOpersPO);
//            this.removeCustViewRegOper(opers,funOpersPO);
//        } else if(Const.DIC_ROLE_NAME_SECRETARIAL.equals(roleId)){
//            //店务秘书
//            //房源去掉全公司、客源去掉全公司、大区和片区
//            this.removeHouseViewCompOper(cityId, compId, opers,funOpersPO);
//            this.removeCustViewCompOper(cityId, compId, opers,funOpersPO);
//            this.removeCustViewAreaOper(cityId, compId, opers,funOpersPO);
//            this.removeCustViewRegOper(opers,funOpersPO);
//        } else if(Const.DIC_ROLE_NAME_BIZ_MANAGER.equals(roleId)){
//            //销售组长
//            //房源去掉全公司、客源去掉全公司、大区和片区
//            this.removeHouseViewCompOper(cityId, compId, opers,funOpersPO);
//            this.removeCustViewCompOper(cityId, compId, opers,funOpersPO);
//            this.removeCustViewAreaOper(cityId, compId, opers,funOpersPO);
//            this.removeCustViewRegOper(opers,funOpersPO);
//        } else if(Const.DIC_ROLE_NAME_COMMON_BIZ.equals(roleId)){
//            //正式经纪人
//            //房源去掉全公司、客源去掉全公司、大区和片区
//            this.removeHouseViewCompOper(cityId, compId, opers,funOpersPO);
//            this.removeCustViewCompOper(cityId, compId, opers,funOpersPO);
//            this.removeCustViewAreaOper(cityId, compId, opers,funOpersPO);
//            this.removeCustViewRegOper(opers,funOpersPO);
//        }
//    }
//
//    @Deprecated
//    private void sysRunAllPublicPlate(Integer cityId, Integer compId, String roleId, Set<String> opers, ErpFunOpers funOpersPO) {
//        if(Const.DIC_ROLE_NAME_BRANCH_MANAGER.equals(roleId)){
//            //门店经理
//            //房源去掉全公司、客源去掉全公司和大区
//            removeHouseViewCompOper(cityId, compId, opers,funOpersPO);
//            removeCustViewCompOper(cityId, compId, opers,funOpersPO);
//            removeCustViewAreaOper(cityId, compId, opers,funOpersPO);
//        } else if(Const.DIC_ROLE_NAME_SECRETARIAL.equals(roleId)){
//            //店务秘书
//            //房源去掉全公司、客源去掉全公司和大区
//            removeHouseViewCompOper(cityId, compId, opers,funOpersPO);
//            removeCustViewCompOper(cityId, compId, opers,funOpersPO);
//            removeCustViewAreaOper(cityId, compId, opers,funOpersPO);
//        } else if(Const.DIC_ROLE_NAME_BIZ_MANAGER.equals(roleId)){
//            //销售组长
//            //房源去掉全公司、客源去掉全公司和大区
//            removeHouseViewCompOper(cityId, compId, opers,funOpersPO);
//            removeCustViewCompOper(cityId, compId, opers,funOpersPO);
//            removeCustViewAreaOper(cityId, compId, opers,funOpersPO);
//        } else if(Const.DIC_ROLE_NAME_COMMON_BIZ.equals(roleId)){
//            //正式经纪人
//            //房源去掉全公司、客源去掉全公司和大区
//            removeHouseViewCompOper(cityId, compId, opers,funOpersPO);
//            removeCustViewCompOper(cityId, compId, opers,funOpersPO);
//            removeCustViewAreaOper(cityId, compId, opers,funOpersPO);
//        }
//    }

    /**
     * 移除查看大区范围客源核心信息的权限
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/6/20
     */
//    @Deprecated
//    private void removeCustViewAreaOper(Integer cityId, Integer compId, Set<String> hiddeOpers, ErpFunOpers funOpersPO) {
//        if(funOpersPO.getOperType().intValue() == Const.DIC_FUN_OPERS_OPER_TYPE_2
//                && funOpersPO.getOperRangeLevelSeq().intValue() == Const.DIC_OPER_RANGE_LEVEL_SEQ_2){
//            hiddeOpers.add(funOpersPO.getOperId());
//        }
//    }

    /**
     * 移除查看公司范围客源核心信息的权限
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/6/20
     */
//    @Deprecated
//    private void removeCustViewCompOper(Integer cityId, Integer compId, Set<String> hiddeOpers, ErpFunOpers funOpersPO) {
//        if(funOpersPO.getOperType().intValue() == Const.DIC_FUN_OPERS_OPER_TYPE_2
//                && funOpersPO.getOperRangeLevelSeq().intValue() ==Const.DIC_OPER_RANGE_LEVEL_SEQ_1){
//            hiddeOpers.add(funOpersPO.getOperId());
//        }
//    }

    /**
     * 移除查看片区范围客源核心信息的权限
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/6/20
     */
//    @Deprecated
//    private void removeCustViewRegOper(Set<String> hiddeOpers, ErpFunOpers funOpersPO) {
//        if(funOpersPO.getOperType()==Const.DIC_FUN_OPERS_OPER_TYPE_2
//                && funOpersPO.getOperRangeLevelSeq() ==Const.DIC_OPER_RANGE_LEVEL_SEQ_3){
//            hiddeOpers.add(funOpersPO.getOperId());
//        }
//    }

    /**
     * 移除查看公司范围房源核心信息的权限
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/6/20
     */
//    @Deprecated
//    private void removeHouseViewCompOper(Integer cityId,Integer compId, Set<String> hiddeOpers,ErpFunOpers funOpersPO){
//        String paramValue = erpSysParaMapper.getParamValue(cityId, compId,"SPECIAL_OPEN_ALL_OPERS");//鸿基定制功能查看房源核心信息都要开放到全公司;
//        if("0".equals(paramValue)){
//            if(funOpersPO.getOperType().intValue()== Const.DIC_FUN_OPERS_OPER_TYPE_1
//                    && funOpersPO.getOperRangeLevelSeq().intValue() == Const.DIC_OPER_RANGE_LEVEL_SEQ_1){
//                hiddeOpers.add(funOpersPO.getOperId());
//            }
//        }
//    }

    /**
     * 需求移除的权限
     * @detail [2020-03-19]  陈峰  去掉公客数据查看权  需求id#11916 APP&PC美联客户查看逻辑修改
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/6/20
	 * eg 1.定制权限，当某个公司有定制权限，那就系统参数增加个参数，没有参数的公司就可以在此方法过滤定制权限
	 * 	  2.
     */
    public Set<String> getNeedHiddenOper(Integer cityId, Integer compId, String roleId, Map<String,ErpSysPara> sysParaMap, Boolean newOrganization) {
        Set<String> opers = new HashSet<String>();
        opers.add("SALE_MANAGE");
        opers.add("LEASE_MANAGE");
        opers.add("BUY_MANAGE");
        opers.add("RENT_MANAGE");
        opers.add("SHARE_CUST_RANGE_OPER");// [2020-03-19]  陈峰  去掉原来公客数据查看权  需求id#11916 APP&PC美联客户查看逻辑修改
        
        opers.add("ML_NEW_BUILD_VIEW"); //美联暂时移除该权限（不知道这个权限是做啥的）2020-2-21
        Integer isOpenTrack = getOperator().getHongJICompModel();
        //非美联公司则需要提出权限
        if(!getOperator().isMeiLianApi()){
        	opers.add("UPLOAD_HOUSE_PIC");  //房源图片上传权
            opers.add("UPLOAD_HOUSE_LAYOUT_PIC"); //户型图上传权
            opers.add("EXAMINE_HOUSE_MATERIAL"); //房源资料审核权
            opers.add("DEL_HOUSE_MATERIAL"); //房源资料删除权
        }
        if(Const.DIC_IS_HONGJI_COMP_MODEL_INT != isOpenTrack){// 非鸿基公司模式的不显示以下权限
            opers.add("VIEW_OTHER_CUSTTRACK");//查看他人客源跟进 IS_OPEN_TRACK控制
        }
        AdminFunCity adminFunCity = adminFunCityMapper.getDataByCityId(cityId);
        if(null != adminFunCity || adminFunCity.getPaFinanceFlag()!=1) {
            opers.add("VIEW_DEPT_LOAN_COMMISSION");// 门店贷款分拥查看权，城市没开就隐藏这个权限
        }

        //判断当前是否是加盟模式，并且是总公司
        boolean isJoinCompModel = Const.DIC_IS_KEWEI_COMP_MODEL.equals(getOperator().getCompModel());
        boolean isJoinAttr = "1".equals(getOperator().getCompAttr());
        //根据公司模式或者定制过滤掉一些权限
        if(!isJoinCompModel){
            //如果不是科威模式则不显示整两个权限
            opers.add("PUB_BULLETIN_INFO_OPER");
            opers.add("VIEW_OTHERCOMP_INFO");
        }else{
            //是科威公司但不是总公司的没有加盟圈的修改权限
            if(!isJoinAttr){
                opers.add("PUB_BULLETIN_INFO_OPER");
            }
        }
        // 如果这个公司没有广告房源发布的系统参数，则影藏“广告房源发布权”/“广告房源撤销权”权限配置
        if(!"1".equals(getSysParaValue(sysParaMap.get("AD_PUBLISH_AUTH")))){
            opers.add("ADD_ADS_CAST");
            opers.add("CANCLE_ADS_CAST");
        }
        
        if(!"1".equals(getSysParaValue(sysParaMap.get("OPEN_ENCRYPTION_HOUSE_CONTROL")))){
        	if(newOrganization) {
				opers.add("VIEW_ORGANIZATION_ENCRYPTION_HOUSE");
			}else {
				opers.add("VIEW_COMP_ENCRYPTION_HOUSE");
				opers.add("VIEW_AREA_ENCRYPTION_HOUSE");
				opers.add("VIEW_REG_ENCRYPTION_HOUSE");
				opers.add("VIEW_DEPT_ENCRYPTION_HOUSE");
				opers.add("VIEW_GROUP_ENCRYPTION_HOUSE");
			}

		}

        //非房基地不展示
        try {
        	String openTransCity = adminSysParaMapper.selectParamVlue("OPEN_TRANS_CITY");
        	ErpFunComp erpFunComp =  erpFunCompMapper.selectByCompId(cityId, compId);
        	if (!"1".equals(openTransCity) || !Byte.valueOf("1").equals(erpFunComp.getMainComp())) {
    			opers.add("TRANS_CITY_CONFIG");
    		}
            AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(erpFunComp.getCompNo());
            
            if(!("2".equals(adminFunComp.getCompManagementModel().toString())
            		&&"1".equals(adminFunComp.getCustomizedType().toString()))){
            	
				if(newOrganization) {
					opers.add("AUDIT_ORGANIZATION_REGISTRATION");
				}else {
					opers.add("AUDIT_COMP_REGISTRATION");
					opers.add("AUDIT_AREA_REGISTRATION");
					opers.add("AUDIT_REG_REGISTRATION");
					opers.add("AUDIT_DEPT_REGISTRATION");
					opers.add("AUDIT_GROUP_REGISTRATION");
				}

                opers.add("SHARING_CENTER_DATA_LOOK");

                //直销模式工作数据查看权
                opers.add("VIEW_T_ZX_WORK");
                opers.add("VIEW_T_ALL_NODE_ZX_WORK");
                opers.add("VIEW_ALL_ZX_WORK");
                
                //直销模式业绩数据查看权
                opers.add("VIEW_ALL_ZX_PROFIT");
                opers.add("VIEW_T_ALL_NODE_ZX_PROFIT");
                opers.add("VIEW_T_ZX_PROFIT");
                
                //投诉审核权
                opers.add("AUDIT_HOUSE_COMPLAINT");
            }

            if(("2".equals(adminFunComp.getCompManagementModel().toString())
            		&&"1".equals(adminFunComp.getCustomizedType().toString()))){
                //查看客源核心信息权【移除 大区，和分组】
                opers.add("VIEW_AREA_CUST");
                opers.add("VIEW_GROUP_CUST");
                //查看客源电话无需审核
                opers.add("AUTO_EXAM_VIEW_AREA_CUST");
                opers.add("AUTO_EXAM_VIEW_GROUP_CUST");
                //查看联动客户信息权
                opers.add("JOINT_CUSTOMER_AREA_VIEW");
                opers.add("JOINT_CUSTOMER_GROUP_VIEW");
                //查看统计分析权
                opers.add("DATA_ANALYSIS_AREA_VIEW");
                opers.add("DATA_ANALYSIS_GROUP_VIEW");
                //合同查看权
                opers.add("VIEW_AREA_DEAL");
                opers.add("VIEW_GROUP_DEAL");
                //诚意金定金查看权
                opers.add("EARBEST_MONEY_VIEW_AREA");
                opers.add("EARBEST_MONEY_VIEW_GROUP");
                //诚意金定金管理权
                opers.add("AREA_EARBEST_MONEY_MANAGE");
                opers.add("GROUP_EARBEST_MONEY_MANAGE");
                //诚意金定金财务管理权
                opers.add("EARBEST_MONEY_FIC_MANAGE_AREA");
                opers.add("EARBEST_MONEY_FIC_MANAGE_GROUP");
                //薪资查看权
                opers.add("FUN_WAG_CHECK_AREA");
                opers.add("FUN_WAG_CHECK_GROUP");
            }
		} catch (Exception e) {
		}
        
        // 装修客户管理功能
        if(!"1".equals(getSysParaValue(sysParaMap.get("RENOVATION_CUSTOMER_IS_OPEN")))){
			opers.add("RENOVATION_CUSTOMER_MANAGE");
        	if(newOrganization) {
				opers.add("VIEW_ORGANIZATION_RENOVATION_CUSTOMER");
			}else {
				opers.add("VIEW_COMP_RENOVATION_CUSTOMER");
				opers.add("VIEW_AREA_RENOVATION_CUSTOMER");
				opers.add("VIEW_REG_RENOVATION_CUSTOMER");
				opers.add("VIEW_DEPT_RENOVATION_CUSTOMER");
				opers.add("VIEW_GROUP_RENOVATION_CUSTOMER");
			}

        }
        // 如果这个公司没有门店业绩的系统参数，则影藏门店业绩相关权限配置
        if(!"1".equals(getSysParaValue(sysParaMap.get("OPEN_DEPT_FEE_MODULE")))){
            opers.add("DEPT_CHARGE_QUERY");
            opers.add("DEPT_CHARGE_INSERT");
            opers.add("DEPT_CHARGE_EXAMINE");
            opers.add("DEPT_CHARGE_CONFIG");
        }
        // 责任盘管理权，没开启则隐藏权限
        if(!"1".equals(getSysParaValue(sysParaMap.get("DUTY_BUILD_IS_OPEN")))){
            opers.add("DUTY_BUILD_MANAGE");
        }

        String paramValue = getSysParaValue(sysParaMap.get("SPECIAL_OPEN_ALL_OPERS"));//1:开放特殊的客源查询列表权限
        // 修改，普通经纪人和未开放特殊权限的都要隐藏公司客源列表查看权
        if("0".equals(paramValue) && !newOrganization){
            opers.add("VIEW_COMP_CUST_LIST_INFO");//客源列表的公司查看权限移除
        }
        if(getOperator().getCompType().equals(Const.DIC_COMP_TYPE_2)){
            opers.add("LOGIN_OTHER_DEPTS");
        }

        // 旧组织才有这些权限
        if(!"1".equals(getOperator().getAreaFlag()) && !newOrganization){
            opers.addAll(UserOpersUtils.HIDDEN_AREA_OPER);
        }

        //如果当前城市没有开通金融权限  则不显示金融申请审核 1为企业版，2 专业版 ，3 营销版
        //finacFlg是否开启金融申请流程  {1=是，0=否}
        //cityFinacFlg
        String cityFinacFlg = (String) getOperator().getAttribute("CITY_FINAC_FLAG");
        String finacFlg = (String) getOperator().getAttribute("FINAC_FLAG");
        if (!"1".equals(cityFinacFlg) || !"1".equals(finacFlg)) {
            opers.add("FINANCIAL_MANAGE");
        }
		Object isHideOldAttendance = getOperator().getAttribute("IS_HIDE_OLD_ATTENDANCE");
		if(null != isHideOldAttendance && "1".equals(isHideOldAttendance + "")) {
			opers.add("CHECK_STATE");
			opers.add("EMPLOYEE_CHECK");
			opers.add("CHECK_RECORD_MANAGE");
			opers.add("ATTENDANCE_MANAGER_SENIOR");
		}

		// 角色的范围全部放出来，需求--9090
		if (true) {
			return opers;
		}
//        boolean publicFun = getSysRunModelIsPublic(cityId, compId, Const.DIC_CASE_TYPE_SALE_FUN);
//        boolean publicCust =getSysRunModelIsPublic(cityId, compId, Const.DIC_CASE_TYPE_BUY_CUST);
//
//        //总经理不需要根据参数范围移除权限
//        if(!Const.DIC_ROLE_NAME_GENERAL_MANAGER.equals(roleId)){
//            List<ErpFunOpers> funopersPoList = new ArrayList<ErpFunOpers>();
//            String [] lookRange = UserOpersUtils.sysRunModelRole(roleId,publicFun,publicCust);
//            String houseLookRange = null;
//            String custLookRange = null;
//            if("1".equals(paramValue)){//鸿基定制功能 结合 该类的removeHouseViewCompOper方法进行查看
//                houseLookRange = getSysParaValue(sysParaMap.get("LOOK_HOUSE_RANGE"));
//                custLookRange = getSysParaValue(sysParaMap.get("LOOK_CUST_RANGE"));
//                //如果不等于1则按照系统设置的权限进行过滤，
//                if(!Const.DIC_LOOK_RANGE_1.equals(houseLookRange)){
//                    houseLookRange = lookRange[0];
//                }
//                if(!Const.DIC_LOOK_RANGE_1.equals(custLookRange)){
//                    custLookRange = lookRange[1];
//                }
//            }else{
//                houseLookRange = lookRange[0];
//                custLookRange = lookRange[1];
//            }
//
//            if(!Const.DIC_LOOK_RANGE_1.equals(houseLookRange)){
//                // 查询出需要过滤的权限，根据查看数据的范围
//                funopersPoList.addAll(getOpersBySysParamListInfo(cityId, Const.DIC_OPER_RANGE_TYPE_1,houseLookRange));
//            }
//            if(!Constants_DIC.DIC_LOOK_RANGE_1.equals(custLookRange)){
//                //查询出需要过滤的权限，根据查看数据的范围
//                funopersPoList.addAll(getOpersBySysParamListInfo(cityId, Const.DIC_OPER_RANGE_TYPE_2,custLookRange));
//            }
//            opers.addAll(hiddenOpersBySysParam(cityId, sysParaMap));
//            if(!funopersPoList.isEmpty()){
//                for(ErpFunOpers tmp : funopersPoList){
//                    opers.add(tmp.getOperId());
//                }
//            }
//        }

        return opers;
    }

    /**
     * 根据公司范围系统参数控制房客源的列表显示
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/6/20
     */
//    public Set<String> hiddenOpersBySysParam(Integer cityId, Map<String, ErpSysPara> sysParaMap) {
//        Set<String> opers = new HashSet<String>();
//        //列表权限的控制范围， 需要从公司系统参数中获取
//        String compSysHouseLook = getSysParaValue(sysParaMap.get("LOOK_HOUSE_RANGE"));
//        String compSysCustLook = getSysParaValue(sysParaMap.get("LOOK_CUST_RANGE"));
//        List<ErpFunOpers> funopersPoList = new ArrayList<>();
//        if(Const.DIC_LOOK_RANGE_1.equals(compSysCustLook)){
//            //列表查看范围是全公司的话，不需要显示列表查看权限 		禅道需求ID：1785
//            Set<Integer> operTypes = new HashSet<>();
//            operTypes.add(Const.DIC_FUN_OPERS_OPER_TYPE_13);
//            funopersPoList.addAll(getOpersByOperType(cityId, operTypes));
//        }
//        if(Constants_DIC.DIC_LOOK_RANGE_1.equals(compSysHouseLook)){
//            //列表查看范围是全公司的话，不需要显示列表查看权限 		禅道需求ID：1785
//            Set<Integer> operTypes = new HashSet<>();
//            operTypes.add(Const.DIC_FUN_OPERS_OPER_TYPE_14);
//            funopersPoList.addAll(getOpersByOperType(cityId, operTypes));
//        }
//        opers.addAll(needHiddenOpersByCustomized(sysParaMap));
//        if(!funopersPoList.isEmpty()){
//            for(ErpFunOpers tmp : funopersPoList){
//                opers.add(tmp.getOperId());
//            }
//        }
//        return opers;
//    }

    /**
     * 删除定制的权限，需要通过系统参数等控制权限是否显示的放这里面
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/6/20
     */
    public Set<String> needHiddenOpersByCustomized(Map<String, ErpSysPara> sysParaMap) {
        Set<String> opers = new HashSet<>();
        // 如果这个公司有公盘数据查看权的系统参数
        if("1".equals(getSysParaValue(sysParaMap.get("VIEW_SHARE_HOUSE_CUST")))){
            // 但运行模式是全公盘制也影藏
            if(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBLIC.equals(getSysParaValue(sysParaMap.get("SYSTEM_RUN_MODEL")))) {
                opers.add("VIEW_SHARE_HOUSE_CUST");
            }
        } else {
            opers.add("VIEW_SHARE_HOUSE_CUST");// 如果这个公司没有公盘数据查看权的系统参数，则影藏“公盘数据查看权”权限配置
        }
        return opers;
    }

    /**
     * 查看数据的范围
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/6/20
     */
    private List<ErpFunOpers> getOpersByOperType(Integer cityId, Set<Integer> operTypes) {
        List<ErpFunOpers> tmp = new ArrayList<>();
        List<ErpFunOpers> metaFunOpers = erpFunOpersMapper.getOpersList(cityId);
        for(ErpFunOpers operTmp : metaFunOpers){
            Byte operType = operTmp.getOperType();
            if(operType!=null){
                if(operTypes.contains(operType.intValue())){
                    tmp.add(operTmp);
                }
            }
        }
        return tmp;
    }

//    @Deprecated
//    private List<ErpFunOpers> getOpersByRoleId(Integer cityId, Integer operRangeLevelSeqArg) {
//        List<ErpFunOpers> tmp = new ArrayList<>();
//        List<ErpFunOpers> metaFunOpers = erpFunOpersMapper.getOpersList(cityId);
//        for (Integer i=metaFunOpers.size() -1 ; i >= 0;i--) {
//            ErpFunOpers erpFunOpers = metaFunOpers.get(0);
//            Byte operRangeType = erpFunOpers.getOperRangeType();
//            Byte operRangeLevelSeq = erpFunOpers.getOperRangeLevelSeq();
//            if(null != operRangeType && null != operRangeLevelSeq){
//                if(operRangeType.intValue() > 0 && (operRangeLevelSeq.intValue() < operRangeLevelSeqArg.intValue())){
//                    tmp.add(erpFunOpers);
//                }
//            }
//        }
//        return tmp;
//    }


    /**
     *	查询出需要过滤的权限，根据查看数据的范围
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/6/20
     */
//    private List<ErpFunOpers> getOpersBySysParamListInfo(Integer cityId, Integer operRangeTypeArg, String operRangeLevelSeqArg) {
//        List<ErpFunOpers> tmp = new ArrayList<>();
//        List<ErpFunOpers> metaFunOpers = erpFunOpersMapper.getOpersList(cityId);
//        for (ErpFunOpers operTmp : metaFunOpers) {
//            Byte operRangeType = operTmp.getOperRangeType();
//            Byte operRangeLevelSeq = operTmp.getOperRangeLevelSeq();
//            Byte operType = operTmp.getOperType();
//            //这两个OPER_TYPE是单独控制  列表查看权限控制方式不一样
//            if(operType!=null && operType!=Const.DIC_FUN_OPERS_OPER_TYPE_13	&& operType!=Const.DIC_FUN_OPERS_OPER_TYPE_14){
//                if(operRangeType!=null && operRangeLevelSeq!=null){
//                    if(operRangeTypeArg==operRangeType.intValue()
//                            && (operRangeLevelSeq < StringUtil.paseInteger(operRangeLevelSeqArg))){
//                        tmp.add(operTmp);
//                    }
//                }
//            }
//        }
//        return tmp;
//    }

    /**
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/6/20
     */
//    private boolean getSysRunModelIsPublic(Integer cityId,Integer compId, Integer caseType) {
//        String sysRunModel =erpSysParaMapper.getParamValue(cityId , compId,"SYSTEM_RUN_MODEL");
//        //是否是公盘模式
//        boolean isPublicModel = ((caseType.equals(Const.DIC_CASE_TYPE_SALE_FUN) || caseType.equals(Const.DIC_CASE_TYPE_LEASE_FUN))
//                && sysRunModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBFUN))//仅公房制
//                || ((caseType.equals(Const.DIC_CASE_TYPE_BUY_CUST) || caseType.equals(Const.DIC_CASE_TYPE_RENT_CUST))
//                && sysRunModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBCUST))//仅公客制
//                || Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBLIC.equals(sysRunModel);//全公盘制
//        return isPublicModel;
//    }

    /**
     * 获取系统参数值
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/6/20
     */
    private String getSysParaValue(ErpSysPara sysParaPO) {
        if(sysParaPO != null) {
            return sysParaPO.getParamValue();
        }
        return null;
    }

    /**
     * 获取查询列表
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/6/19
     */
    private String[] getQueryColumnByCompOpers(Integer cityId, Integer compId, String roleId, ErpFunUsers erpFunUsers) {
        Map<String, Set<Integer>> tmpSetMap = getCurrRoleCompOpersByRangId(cityId, compId, roleId);
        Set<Integer> areaIds = tmpSetMap.get("area");
        Set<Integer> regionIds = tmpSetMap.get("region");
        Set<Integer> deptIds = tmpSetMap.get("dept");
        Set<Integer> compIds = tmpSetMap.get("comp");
        if (deptIds.contains(erpFunUsers.getDeptId())) {
            return new String[] { "DEPT_ID", StringUtil.toString(erpFunUsers.getDeptId()) };
        } else if (regionIds.contains(erpFunUsers.getRegId())) {
            return new String[] { "REG_ID", StringUtil.toString(erpFunUsers.getRegId()) };
        } else if (areaIds.contains(erpFunUsers.getAreaId())) {
            return new String[] { "AREA_ID", StringUtil.toString(erpFunUsers.getAreaId()) };
        } else if (compIds.contains(getOperator().getCompId())) {
            return new String[] { "SOURCE_COMP_ID", StringUtil.toString(getOperator().getCompId()) };
        } else {
            return new String[] { "SOURCE_COMP_ID", StringUtil.toString(getOperator().getCompId()) };
        }
    }

	/**
	 * @Desc 新版组织机构查询
	 * @Time 2019/11/28
	 * @Author lcb
	 **/
	private Integer getQueryColumnByCompOpersNewOrg(Integer cityId, Integer compId, String roleId, ErpFunUsers erpFunUsers) {
		// 取组织机构ID
		List<ErpCompRoleOpers> tmps = erpCompRoleOpersMapper.parseQueryColumnOrganizationForUserOpers(cityId, compId, roleId);
		// 公司级别是0
		if(tmps.size() == 0) {
			return 0;
		}

		// 公司级别是0
		if(tmps.size() == 1 && 0 == tmps.get(0).getOrganizationId()) {
			return 0;
		}

		List<Integer> organizationIdList = tmps.stream().collect(Collectors.mapping(val -> val.getOrganizationId(), Collectors.toList()));
		Map<Integer, List<ErpCompRoleOpers>> organizationIdRoleOpersMap = tmps.stream().collect(Collectors.groupingBy(ErpCompRoleOpers::getOrganizationId));

		ErpFunOrganizationExample erpFunOrganizationExample = new ErpFunOrganizationExample();
		erpFunOrganizationExample.setShardCityId(cityId);
		erpFunOrganizationExample.createCriteria().andCompIdEqualTo(compId).andOrganizationIdIn(organizationIdList);
		List<ErpFunOrganization> erpFunOrganizations = erpFunOrganizationMapper.selectByExample(erpFunOrganizationExample);

		// 根据模板Id归类
		Map<Integer, List<ErpFunOrganization>> denifitionIdMap = erpFunOrganizations.stream().collect(Collectors.groupingBy(ErpFunOrganization::getOrganizationDefinitionId));

		List<ErpFunOrganizationDefinition> allEffectiveOrganizationDefinition = erpFunOrganizationDefinitionService.getAllEffectiveOrganizationDefinition(cityId, compId);

		for (ErpFunOrganizationDefinition erpFunOrganizationDefinition : allEffectiveOrganizationDefinition) {
			// 根据层级来遍历组织机构
			List<ErpFunOrganization> denfinitionIdOrg = denifitionIdMap.get(erpFunOrganizationDefinition.getDefinitionId());
			if(null != denfinitionIdOrg) {
				for (ErpFunOrganization erpFunOrganization : denfinitionIdOrg) {
					List<ErpCompRoleOpers> erpCompRoleOpers = organizationIdRoleOpersMap.get(erpFunOrganization.getOrganizationId());
					if(null != erpCompRoleOpers && erpCompRoleOpers.size() > 0) {
						// 对应字段名
						String columnName = erpFunOrganizationDefinition.getMappingDbField();
						columnName = StringUtil.getMethodName(columnName);
						Integer columnValue = 0;
						// 找指定的组织机构ID
						try{
							Method[] methods = erpFunUsers.getClass().getMethods();
							for (Method method : methods) {
								if(columnName.equals(method.getName())) {
									Object invoke = method.invoke(erpFunUsers);
									if(null != invoke) {
										columnValue = (Integer) invoke;
										break;
									}
								}
							}
//							Method method = erpFunUsers.getClass().getMethod(columnName, ErpFunUsers.class);
//							Object o = method.invoke(erpFunUsers);
//							if(null != o) {
//								columnValue = (Integer) o;
//							}
						}catch (Exception e) {
							e.printStackTrace();
						}

						return columnValue;
					}
				}
			}
		}
		// 公司的organizationId = 0
		return 0;
	}

    private String [] parseQueryParam(Integer cityId, Integer compId, Integer areaId, Integer regId, Integer deptId, Integer grId,String roleId){
        String [] querpColumn = this.parseQueryParamForAll(compId, areaId, regId, deptId, grId);
        String columnName = querpColumn[0];
        Integer columnValue = StringUtil.paseInteger(querpColumn[1]);
        //这里需要判断查询范围的层级 COMP > AREA > REG > DEPT
        // DEPT 范围时   先找REG范围，如果没有继续找AREA范围，还没有继续找COMP，在没有就直接设置当前范围
        // REG 范围时		 先找AREA范围，还没有继续找COMP，在没有就直接设置当前范围
        // AREA 范围时   先找COMP范围，如果没有就直接设置当前范围
        // COMP 范围时   直接设置当前范围 CompRoleOpersService
        Map<String ,Set<Integer>> rangerTmp = getCurrRoleCompOpersByRangId(cityId, compId, roleId);
        Set<Integer> tmpCompRange = rangerTmp.get("comp");//这里指定该范围的上一级
        Set<Integer> tmpAreaRange =	rangerTmp.get("area");
        Set<Integer> tmpRegRange =	rangerTmp.get("region");
        Set<Integer> tmpDeptsRange = rangerTmp.get("dept");
        Set<Integer> tmpGroupRange = rangerTmp.get("group");
        //1代表本次操作时新的权限配置，必须把本次要修改的权限全部提交上来，
        //这个发给前端，前端再传回来即可。统一由服务器端来控制本次是否全部提交,而不差量提交
        String newSetOper = "1";
        if(columnValue!=null && UserOpersUtils.COMP_ROLE_OPERS_AREA_ID.equals(columnName)){
            if (tmpAreaRange.contains(columnValue)) {
                newSetOper = "0";
            } else if(tmpCompRange!=null){
                //如果有的话直接使用上一级范围的权限配置
                columnName = "SOURCE_COMP_ID";
                columnValue = getOperator().getCompId();
            }
        }else if(columnValue!=null && UserOpersUtils.COMP_ROLE_OPERS_REG_ID.equals(columnName)){
            ErpFunRegion regPo =	erpFunRegionMapper.selectByRegId(getOperator().getCityId(),getOperator().getCompId(),null,columnValue);
            Integer areaIdTmp = regPo.getAreaId();
            if (tmpRegRange.contains(columnValue)) {
                newSetOper = "0";
            }else if(tmpAreaRange!=null && tmpAreaRange.contains(areaIdTmp)){
                //如果有的话直接使用上一级范围的权限配置
                columnName = "AREA_ID";
                columnValue = areaIdTmp;
            } else if(!CommonUtil.isnull(tmpCompRange)){
                //AREA没有则继续找寻COMP
                columnName = "SOURCE_COMP_ID";
                columnValue = getOperator().getCompId();
            }
        }else if(columnValue!=null && UserOpersUtils.COMP_ROLE_OPERS_DEPT_ID.equals(columnName)){
            ErpFunDepts regPo = erpFunDeptsMapper.getDeptByCompIdAndDeptId(getOperator().getCityId(),getOperator().getCompId(),columnValue);
            Integer areaIdTmp = regPo.getAreaId();
            Integer regIdTmp = regPo.getRegId();
            if(tmpDeptsRange.contains(columnValue)){
                newSetOper = "0";
            }else if(tmpRegRange!=null && tmpRegRange.contains(regIdTmp)){
                //如果有的话直接使用上一级范围的权限配置
                columnName = "REG_ID";
                columnValue = regIdTmp;
            } else if(tmpAreaRange!=null && tmpAreaRange.contains(areaIdTmp)){
                //REG没有则继续找寻AREA
                columnName = "AREA_ID";
                columnValue = areaIdTmp;
            } else if(tmpCompRange!=null){
                //AREA没有则继续找寻COMP
                columnName = "SOURCE_COMP_ID";
                columnValue = getOperator().getCompId();
            }
        }else if(columnValue!=null && UserOpersUtils.COMP_ROLE_OPERS_GROUP_ID.equals(columnName)){
            ErpFunDeptsgroup groupPo = erpFunDeptsgroupMapper.getModelDataById(cityId, compId,columnValue);
            Integer grIdTmp = groupPo.getGrId();
            ErpFunDepts regPo = erpFunDeptsMapper.getDeptByCompIdAndDeptId(cityId, compId,groupPo.getDeptId());
            Integer areaIdTmp = regPo.getAreaId();
            Integer regIdTmp = regPo.getRegId();
            Integer deptIdTmp = regPo.getDeptId();
            if(tmpGroupRange.contains(grIdTmp)){
                newSetOper = "0";
                //是否包含本组的门店如果有直接返回门店上的权限
            }else if(tmpDeptsRange.contains(deptIdTmp)){
                columnName = "DEPT_ID";
                columnValue = deptIdTmp;
            }else if(tmpRegRange!=null && tmpRegRange.contains(regIdTmp)){
                //如果有的话直接使用上一级范围的权限配置
                columnName = "REG_ID";
                columnValue = regIdTmp;
            } else if(tmpAreaRange!=null && tmpAreaRange.contains(areaIdTmp)){
                //REG没有则继续找寻AREA
                columnName = "AREA_ID";
                columnValue =areaIdTmp;
            } else if(tmpCompRange!=null){
                //AREA没有则继续找寻COMP
                columnName = "SOURCE_COMP_ID";
                columnValue = getOperator().getCompId();
            }
        }else if(columnValue!=null){
            if(tmpCompRange.size() >0){
                newSetOper = "0";
            }
        }
        return new String[]{columnName,StringUtil.toString(columnValue), newSetOper};
    }

    /**
     * @Desc 新版组织的角色权限范围 organizationId = null 代表全公司
     * @Time 2019/11/25
     * @Author lcb
     **/
	private String judgeIsFirstSetOper(Integer cityId, Integer compId, Integer organizationId, String roleId){
		// 这个验证这一套有没有被应用
		// 查询有没有层级已经应用过此套配置
		List<ErpCompRoleOpers> tmps = erpCompRoleOpersMapper.parseQueryColumnOrganizationForUserOpers(cityId, compId, roleId);
		if(tmps.size() == 0) {
			return "1";
		}

		Set<Integer> organizationIdList = tmps.stream().collect(Collectors.mapping(val -> val.getOrganizationId(), Collectors.toSet()));

		if(organizationIdList.contains(organizationId)) {
			return "0";
		}

		return "1";

	}

    private String[] parseQueryParamForAll(Integer compId, Integer areaIdParam, Integer regIdParam, Integer deptIdParam, Integer grIdParam) {
        Integer grId = grIdParam;
        Integer sourceCompId = null;
        Integer deptId = null;
        Integer areaId = null;
        Integer regId = null;
        if (grId == null) {
            deptId = deptIdParam;
            if (deptId == null) {
                regId = regIdParam;
                if (regId == null) {
                    areaId = areaIdParam;
                    if (areaId == null) {
                        sourceCompId = compId;
                    }
                }
            }
        }
        String columnName = "";
        Integer columnValue = null;
        if (areaId != null) {
            columnName = "AREA_ID";
            columnValue = areaId;
            // 要查询出该片区下面的门店
        } else if (regId != null) {
            columnName = "REG_ID";
            columnValue = regId;
        } else if (deptId != null) {
            columnName = "DEPT_ID";
            columnValue = deptId;
        } else if (grId != null) {
            columnName = "GROUP_ID";
            columnValue = grId;
        } else if (sourceCompId != null) {
            columnName = "SOURCE_COMP_ID";
            columnValue = sourceCompId;
        }
        return new String[] { columnName, StringUtil.toString(columnValue) };
    }

    /**
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/6/20
     */
    private Map<String, Set<Integer>> getCurrRoleCompOpersByRangId(Integer cityId, Integer compId, String roleId) {
        List<ErpCompRoleOpers> tmps = erpCompRoleOpersMapper.parseQueryColumnForUserOpers(cityId, compId, roleId);
        Set<Integer> grIds = new HashSet<>();
        Set<Integer> deptIds = new HashSet<>();
        Set<Integer> regionIds = new HashSet<>();
        Set<Integer> areaIds = new HashSet<>();
        Set<Integer> compIds = new HashSet<>();
        Map<String, Set<Integer>> tmpIds = new HashMap<>();
        for (ErpCompRoleOpers tmpOpers : tmps) {
            Integer tmpAreaId = tmpOpers.getAreaId();
            Integer tmpRegionId = tmpOpers.getRegId();
            Integer tmpDeptId = tmpOpers.getDeptId();
            Integer tmpgrId = tmpOpers.getGroupId();
            Integer tmpComptId = tmpOpers.getSourceCompId();
            if (null != tmpAreaId) {
                areaIds.add(tmpAreaId);
            }
            if (null != tmpRegionId) {
                regionIds.add(tmpRegionId);
            }
            if (null != tmpDeptId) {
                deptIds.add(tmpDeptId);
            }
            if (null != tmpgrId) {
                grIds.add(tmpgrId);
            }
            if (null != tmpComptId) {
                compIds.add(tmpComptId);
            }
        }
        tmpIds.put("area", areaIds);
        tmpIds.put("region", regionIds);
        tmpIds.put("dept", deptIds);
        tmpIds.put("group", grIds);
        tmpIds.put("comp", compIds);
        return tmpIds;
    }
    
    /**
     * 权限模板上判断某权限范围是否存在权限的逻辑
     * @param cityId
     * @param compId
     * @param areaId
     * @param regId
     * @param deptId
     * @param grId
     * @param roleId
     * @return
     */
    private String [] parseQueryParamForFangjidi(Integer cityId, Integer compId, Integer areaId, Integer regId, Integer deptId, Integer grId, Integer permissionTemplateId){
        String [] querpColumn = this.parseQueryParamForAll(compId, areaId, regId, deptId, grId);
        String columnName = querpColumn[0];
        Integer columnValue = StringUtil.paseInteger(querpColumn[1]);
        //这里需要判断查询范围的层级 COMP > AREA > REG > DEPT
        // DEPT 范围时   先找REG范围，如果没有继续找AREA范围，还没有继续找COMP，在没有就直接设置当前范围
        // REG 范围时		 先找AREA范围，还没有继续找COMP，在没有就直接设置当前范围
        // AREA 范围时   先找COMP范围，如果没有就直接设置当前范围
        // COMP 范围时   直接设置当前范围 CompRoleOpersService
        Map<String ,Set<Integer>> rangerTmp = getCurrTemplateOpersByRangId(cityId, compId, permissionTemplateId);
        Set<Integer> tmpCompRange = rangerTmp.get("comp");//这里指定该范围的上一级
        Set<Integer> tmpAreaRange =	rangerTmp.get("area");
        Set<Integer> tmpRegRange =	rangerTmp.get("region");
        Set<Integer> tmpDeptsRange = rangerTmp.get("dept");
        Set<Integer> tmpGroupRange = rangerTmp.get("group");
        //1代表本次操作时新的权限配置，必须把本次要修改的权限全部提交上来，
        //这个发给前端，前端再传回来即可。统一由服务器端来控制本次是否全部提交,而不差量提交
        String newSetOper = "1";
        if(columnValue != null && UserOpersUtils.COMP_ROLE_OPERS_AREA_ID.equals(columnName)){
            if (tmpAreaRange.contains(columnValue)) {
                newSetOper = "0";
            } else if(tmpCompRange!=null){
                //如果有的话直接使用上一级范围的权限配置
                columnName = "SOURCE_COMP_ID";
                columnValue = getOperator().getCompId();
            }
        }else if(columnValue != null && columnValue > 0 && UserOpersUtils.COMP_ROLE_OPERS_REG_ID.equals(columnName)){
            ErpFunRegion regPo =	erpFunRegionMapper.selectByRegId(getOperator().getCityId(),getOperator().getCompId(),null,columnValue);
            Integer areaIdTmp = regPo.getAreaId();
            if (tmpRegRange.contains(columnValue)) {
                newSetOper = "0";
            }else if(tmpAreaRange!=null && tmpAreaRange.contains(areaIdTmp)){
                //如果有的话直接使用上一级范围的权限配置
                columnName = "AREA_ID";
                columnValue = areaIdTmp;
            } else if(!CommonUtil.isnull(tmpCompRange)){
                //AREA没有则继续找寻COMP
                columnName = "SOURCE_COMP_ID";
                columnValue = getOperator().getCompId();
            }
        }else if(columnValue != null && columnValue > 0 && UserOpersUtils.COMP_ROLE_OPERS_DEPT_ID.equals(columnName)){
            ErpFunDepts regPo = erpFunDeptsMapper.getDeptByCompIdAndDeptId(getOperator().getCityId(),getOperator().getCompId(),columnValue);
            Integer areaIdTmp = regPo.getAreaId();
            Integer regIdTmp = regPo.getRegId();
            if(tmpDeptsRange.contains(columnValue)){
                newSetOper = "0";
            }else if(tmpRegRange!=null && tmpRegRange.contains(regIdTmp)){
                //如果有的话直接使用上一级范围的权限配置
                columnName = "REG_ID";
                columnValue = regIdTmp;
            } else if(tmpAreaRange!=null && tmpAreaRange.contains(areaIdTmp)){
                //REG没有则继续找寻AREA
                columnName = "AREA_ID";
                columnValue = areaIdTmp;
            } else if(tmpCompRange!=null){
                //AREA没有则继续找寻COMP
                columnName = "SOURCE_COMP_ID";
                columnValue = getOperator().getCompId();
            }
        }else if(columnValue != null && columnValue > 0 && UserOpersUtils.COMP_ROLE_OPERS_GROUP_ID.equals(columnName)){
            ErpFunDeptsgroup groupPo = erpFunDeptsgroupMapper.getModelDataById(cityId, compId,columnValue);
            Integer grIdTmp = groupPo.getGrId();
            ErpFunDepts regPo = erpFunDeptsMapper.getDeptByCompIdAndDeptId(cityId, compId,groupPo.getDeptId());
            Integer areaIdTmp = regPo.getAreaId();
            Integer regIdTmp = regPo.getRegId();
            Integer deptIdTmp = regPo.getDeptId();
            if(tmpGroupRange.contains(grIdTmp)){
                newSetOper = "0";
                //是否包含本组的门店如果有直接返回门店上的权限
            }else if(tmpDeptsRange.contains(deptIdTmp)){
                columnName = "DEPT_ID";
                columnValue = deptIdTmp;
            }else if(tmpRegRange!=null && tmpRegRange.contains(regIdTmp)){
                //如果有的话直接使用上一级范围的权限配置
                columnName = "REG_ID";
                columnValue = regIdTmp;
            } else if(tmpAreaRange!=null && tmpAreaRange.contains(areaIdTmp)){
                //REG没有则继续找寻AREA
                columnName = "AREA_ID";
                columnValue =areaIdTmp;
            } else if(tmpCompRange!=null){
                //AREA没有则继续找寻COMP
                columnName = "SOURCE_COMP_ID";
                columnValue = getOperator().getCompId();
            }
        }else if(columnValue!=null){
            if(tmpCompRange.size() >0){
                newSetOper = "0";
            }
        }
        return new String[]{columnName,StringUtil.toString(columnValue), newSetOper};
    }
    
    private Map<String, Set<Integer>> getCurrTemplateOpersByRangId(Integer cityId, Integer compId, Integer permissionTemplateId) {
        Set<Integer> grIds = new HashSet<>();
        List<ErpCompRoleOpers> tmps = erpCompRoleOpersMapper.getQueryColumnForUserOpers(cityId, compId, permissionTemplateId);
        Set<Integer> deptIds = new HashSet<>();
        Set<Integer> regionIds = new HashSet<>();
        Set<Integer> areaIds = new HashSet<>();
        Set<Integer> compIds = new HashSet<>();
        Map<String, Set<Integer>> tmpIds = new HashMap<>();
        for (ErpCompRoleOpers tmpOpers : tmps) {
            Integer tmpAreaId = tmpOpers.getAreaId();
            Integer tmpRegionId = tmpOpers.getRegId();
            Integer tmpDeptId = tmpOpers.getDeptId();
            Integer tmpgrId = tmpOpers.getGroupId();
            Integer tmpComptId = tmpOpers.getSourceCompId();
            if (null != tmpAreaId) {
                areaIds.add(tmpAreaId);
            }
            if (null != tmpRegionId) {
                regionIds.add(tmpRegionId);
            }
            if (null != tmpDeptId) {
                deptIds.add(tmpDeptId);
            }
            if (null != tmpgrId) {
                grIds.add(tmpgrId);
            }
            if (null != tmpComptId) {
                compIds.add(tmpComptId);
            }
        }
        tmpIds.put("area", areaIds);
        tmpIds.put("region", regionIds);
        tmpIds.put("dept", deptIds);
        tmpIds.put("group", grIds);
        tmpIds.put("comp", compIds);
        return tmpIds;
    }
    
    /**
     * 读取用户变更角色的高级权限
     * @author HeWei
     * @since 2018年7月24日 下午2:22:48
     * @param param
     * @return
     * @throws Exception
     * Modified XXX HeWei 2018年7月24日
     */
//    @RequestMapping("/getMgrUserRoleAdvanceOpersList")
//	@ResponseBody
//	@Deprecated // 这个接口应该没地方使用了2019-11-19
//	public  ResponseJson getMgrUserRoleAdvanceOpersList(@RequestBody BaseMapParam param) throws Exception {
//		Integer compId = getOperator().getCompId();
//		Integer cityId = getOperator().getCityId();
//		Integer compType = getOperator().getCompType();
//		boolean mobileApi = getOperator().isMobileApi();
//		Integer userId = param.getInteger("userId");
//		Integer isCompRole = param.getInteger("isCompRole");
//
//		// story#11307 先判断当前公司是否说开了加盟模式，再判断当前这个人说在哪个组织，总部的就 要总部特殊的权限比如说加盟商管理权， 直营不管，如果说加盟商的人，那么要把特殊的加盟商公告管理权查出来
//		List<Byte> flagList =  new ArrayList<Byte>();// 查询通用的权限，1=总部的，2=加盟商的
//		flagList.add(Byte.valueOf("0"));
//		if (Integer.valueOf(1).equals(getOperator().openPartner())) {
//			if (Integer.valueOf(0).equals(getOperator().getPartnerId())) {// 总部
//				flagList.add(Byte.valueOf("1"));
//				flagList.add(Byte.valueOf("3"));
//			} else if (getOperator().getPartnerId() > 0) {// 加盟商
//				flagList.add(Byte.valueOf("2"));
//			} else {
//				flagList.add(Byte.valueOf("3"));
//			}
//		}
//
//		ErpFunUsers funUserByUserId = erpFunUsersMapper.getFunUserByUserId(cityId, userId);
//		ErpCompRoleOpers paramObj = getParamObj(ErpCompRoleOpers.class);
//		String[] queryColumn = erpCompRoleOpersService.parseQueryColumnByCompOpers(paramObj.getRoleId(), funUserByUserId,compId,cityId);
//		String columnName = queryColumn[0];
//		String columnValue = queryColumn[1];
//		List<ErpFunOpersDto> checkedAdvanceOpers4AllUse = this.getCheckedAdvanceOpers4AllUse(cityId,compId,compType,userId,columnValue, columnName, paramObj.getRoleId(),isCompRole,1, null, mobileApi, flagList);
//		return ErpResponseJson.ok(checkedAdvanceOpers4AllUse);
//	}
//
    /**
     * 读取用户变更角色的普通权限
     * @author HeWei
     * @since 2018年7月24日 下午2:35:02
     * @param param
     * @return
     * @throws Exception
     * Modified XXX HeWei 2018年7月24日
     */
//    @RequestMapping("/getMgrUserRoleNormalOpersList")
//    @ResponseBody
//	@Deprecated // 这个接口应该没地方使用了2019-11-19
//    public  ResponseJson getMgrUserRoleNormalOpersList(@RequestBody BaseMapParam param) throws Exception {
//    	Integer compId = getOperator().getCompId();
//    	Integer cityId = getOperator().getCityId();
//    	Integer compType = getOperator().getCompType();
//    	boolean mobileApi = getOperator().isMobileApi();
//    	Integer userId = param.getInteger("userId");
//    	Integer isCompRole = param.getInteger("isCompRole");
//
//    	// story#11307 先判断当前公司是否说开了加盟模式，再判断当前这个人说在哪个组织，总部的就 要总部特殊的权限比如说加盟商管理权， 直营不管，如果说加盟商的人，那么要把特殊的加盟商公告管理权查出来
//    	List<Byte> flagList =  new ArrayList<Byte>();// 查询通用的权限，1=总部的，2=加盟商的
//    	flagList.add(Byte.valueOf("0"));
//    	if (Integer.valueOf(1).equals(getOperator().openPartner())) {
//    		if (Integer.valueOf(0).equals(getOperator().getPartnerId())) {// 总部
//    			flagList.add(Byte.valueOf("1"));
//    			flagList.add(Byte.valueOf("3"));
//    		} else if (getOperator().getPartnerId() > 0) {// 加盟商
//    			flagList.add(Byte.valueOf("2"));
//    		} else {
//    			flagList.add(Byte.valueOf("3"));
//    		}
//    	}
//
//    	ErpFunUsers funUserByUserId = erpFunUsersMapper.getFunUserByUserId(cityId, userId);
//    	ErpCompRoleOpers paramObj = getParamObj(ErpCompRoleOpers.class);
//    	String[] queryColumn = erpCompRoleOpersService.parseQueryColumnByCompOpers(paramObj.getRoleId(), funUserByUserId,compId,cityId);
//    	String columnName = queryColumn[0];
//    	String columnValue = queryColumn[1];
//    	List<ErpFunOpersDto> checkedAdvanceOpers4AllUse = this.getCheckedCommonOpersList4AllUse(cityId,compId,compType,userId,columnValue, columnName, paramObj.getRoleId(),isCompRole,0, null, mobileApi, flagList);
//    	return ErpResponseJson.ok(checkedAdvanceOpers4AllUse);
//    }

    /**
     * 员工权限-高级权限说明
     * @author ZangTie
     * @since 2018年7月24日 下午1:55:31
     * @param param
     * @return
     * Modified XXX ZangTie 2018年7月24日
     */
    @ApiOperation("获取权限描述")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunOpersVo.class, message = "成功")
    })
	@PostMapping("/getMgrRoleDescription")
	@ResponseBody
	public ResponseJson getMgrRoleDescription(@RequestBody BaseMapParam param) {
		List<ErpFunOpers> list = erpFunOpersMapper.getALLAdvanceOperDescription(getOperator().getCityId());
        ErpFunOpersVo resultVo = new ErpFunOpersVo();
        resultVo.setList(list);
		return ErpResponseJson.ok(resultVo);
	}
	
    /**
     * @desc 查询模块的权限
     * @author lcb
     * @date 2018/11/12 11:36
     */
    @ApiOperation("根据模块码查询权限")
    @ApiResponses(value = {
        @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ManageLevelVo.class, message = "成功")
    })
    @PostMapping("/getManageLevelByModelCode")
    @ResponseBody
    @NotBlank("modelCode")
	public ResponseJson getMgrRoleDescription(@RequestBody ManageLevelParam param) {
    	Operator operator = getOperator();
		Integer compId = operator.getCompId();
		String userPosition = operator.getUserPosition();
		Integer cityId = operator.getCityId();
		Integer userId = operator.getUserId();
		Map<String, Object> resultMap = new HashMap<>();
		String versionFlag = erpSysParaMapper.getParamValue(cityId, compId, "IS_SELL_VERSION");
		// 判断销售公司假总经理
		if("GENERAL_MANAGER".equals(userPosition) && "1".equals(versionFlag)){
			ErpMarketVirtualGeneralExample example = new ErpMarketVirtualGeneralExample();
			example.createCriteria().andCompIdEqualTo(compId).andUserIdEqualTo(userId);
			example.setShardCityId(cityId);
			Integer count = erpMarketVirtualGeneralMapper.countByExample(example);
			if(count > 0){
				return ErpResponseJson.ok(resultMap);
			}
		} else if (!"GENERAL_MANAGER".equals(userPosition) && "1".equals(versionFlag)){
			return ErpResponseJson.ok(resultMap);
		}
		String[] operIdArr = null;
		switch (param.getModelCode()) {
		case 1000:
			operIdArr = new String[] { "MANAGE_COMP_ORGANIZATION", "MANAGE_AREA_ORGANIZATION",
					"MANAGE_REG_ORGANIZATION", "MANAGE_DEPT_ORGANIZATION", "MANAGE_GROUP_ORGANIZATION" };
			break;
		}
		if (null == operIdArr) {
			return ErpResponseJson.ok();
		}
		ManageLevelVo manageLevelVo = this.judgeLevelByOperList(cityId, userId, param.getModelCode(), operIdArr);
		return ErpResponseJson.ok(manageLevelVo);
	}

    /**
     * @desc 根据权限判断层级
     * @author lcb
     * @date 2018/11/12 13:46
     */
	public ManageLevelVo judgeLevelByOperList(Integer cityId, Integer selfUserId, Integer modelCode, String[] operIdArr) {
		if (null == operIdArr || operIdArr.length <= 0) {
			return null;
		}
		Set<String> roleIds = erpUserOpersMapper.getUsersOpersByUserId(cityId, selfUserId, operIdArr);
		ManageLevelVo manageLevelVo = new ManageLevelVo();
		if (null == roleIds || roleIds.size() == 0) {
			return manageLevelVo;
		} else {
			manageLevelVo.setCanOper(1);
		}
		switch (modelCode) {
		case 1000:
			if (roleIds.contains("MANAGE_COMP_ORGANIZATION")) {
				manageLevelVo.setOperLevel(1);
			} else if (roleIds.contains("MANAGE_AREA_ORGANIZATION")) {
				manageLevelVo.setOperLevel(2);
			} else if (roleIds.contains("MANAGE_REG_ORGANIZATION")) {
				manageLevelVo.setOperLevel(3);
			} else if (roleIds.contains("MANAGE_DEPT_ORGANIZATION")) {
				manageLevelVo.setOperLevel(4);
			} else if (roleIds.contains("MANAGE_GROUP_ORGANIZATION")) {
				manageLevelVo.setOperLevel(5);
			}
			break;
		}
		return manageLevelVo;
	}
	
	@ApiOperation("房基地两端-权限配置与角色配置区分：保存角色选择权限模板，同步经纪人权限， 需求:11167，作者:陈峰")
 	@ApiResponses(value = {@ApiResponse(code = 200, message = "成功")})
	@RequestMapping("/updateRolePermissionTemplate")
	@ResponseBody
 	public ResponseJson updateRolePermissionTemplate(@RequestBody @Valid UpdateRolePermissionTemplateParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		
		Byte partStatistCount = param.getPartStatistCount();// 是否加入统计
		String roleId = param.getRoleId();// 角色id
		param.setCurDeptId(operator.getDeptId());
		param.setCurUserId(operator.getUserId());
		
		if (roleId.equals("GENERAL_MANAGER")) {
			if (null != partStatistCount) {//总经理不修改权限
				ErpCompRoles erpCompRoleOpers = erpCompRolesMapper.getByRoleId(cityId, compId, roleId);
				ErpCompRoles erpCompRoles = new ErpCompRoles();
				erpCompRoles.setAutoId(erpCompRoleOpers.getAutoId());
				erpCompRoles.setPartStatistCount(partStatistCount);
				erpCompRoles.setShardCityId(cityId);
				erpCompRolesMapper.updateByPrimaryKeySelective(erpCompRoles);
			}
			return ErpResponseJson.ok();
		}
		erpCompRoleOpersService.updateRolePermissionTemplate(cityId, compId, param);
 		return ErpResponseJson.ok();
 	}
	
	@ApiOperation("房基地两端-权限配置与角色配置区分：查询公司所有权限模板应用范围列表， 需求:11167，作者:陈峰")
 	@ApiResponses(value = {@ApiResponse(code = 200, response = GetPermissionTemplateScopeListVO.class, message = "成功")})
	@RequestMapping("/getPermissionTemplateScope")
	@ResponseBody
 	public ResponseJson getPermissionTemplateScope() {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		
		List<GetPermissionTemplateScopeVO> scopeList = erpFunCompPermissionTemplateMapper.getPermissionTemplateScope(cityId, compId);
		
		GetPermissionTemplateScopeListVO getPermissionTemplateScopeListVO = new GetPermissionTemplateScopeListVO();
		if (!scopeList.isEmpty()) {
			List<GetPermissionTemplateScopeVO> scopelist = new ArrayList<GetPermissionTemplateScopeVO>();
			Map<Integer, List<GetPermissionTemplateScopeVO>> permissionTemplateIdMap = scopeList.stream().collect(Collectors.groupingBy(GetPermissionTemplateScopeVO :: getPermissionTemplateId));
			Set<Entry<Integer,List<GetPermissionTemplateScopeVO>>> entrySet = permissionTemplateIdMap.entrySet();
			Iterator<Entry<Integer, List<GetPermissionTemplateScopeVO>>> iterator = entrySet.iterator();
			while (iterator.hasNext()) {
				Entry<Integer, List<GetPermissionTemplateScopeVO>> next = iterator.next();
				Integer key = next.getKey();
				List<GetPermissionTemplateScopeVO> value = next.getValue();
				GetPermissionTemplateScopeVO getPermissionTemplateScopeVO = new GetPermissionTemplateScopeVO();
				getPermissionTemplateScopeVO.setPermissionTemplateId(key);
				getPermissionTemplateScopeVO.setPermissionTemplateName(value.get(0).getPermissionTemplateName());
				getPermissionTemplateScopeVO.setRoleNames(value.stream().filter(a -> StringUtil.isNotBlank(a.getRoleNames())).map(a -> a.getRoleNames()).collect(Collectors.joining("、")));
				scopelist.add(getPermissionTemplateScopeVO);
			}
			List<GetPermissionTemplateScopeVO> scopeSortList = scopelist.stream().sorted(Comparator.comparing(GetPermissionTemplateScopeVO :: getPermissionTemplateId)).collect(Collectors.toList());
			getPermissionTemplateScopeListVO.setScopelist(scopeSortList);
		} else {
			getPermissionTemplateScopeListVO.setScopelist(Collections.emptyList());
		}
 		return ErpResponseJson.ok(getPermissionTemplateScopeListVO);
 	}
	
	@ApiOperation("房基地两端-权限配置与角色配置区分：查询权限模板配置信息， 需求:11167，作者:陈峰")
 	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpRoleOpersVo.class, message = "成功")})
	@RequestMapping("/getTemplatePermissionInfo")
	@ResponseBody
 	public ResponseJson getTemplatePermissionInfo(@RequestBody GetTemplatePermissionInfoParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer permissionTemplateId = param.getPermissionTemplateId();

		boolean newOrganizationType = operator.newOrganizationType();

		// story#11307 先判断当前公司是否说开了加盟模式，再判断当前这个人说在哪个组织，总部的就 要总部特殊的权限比如说加盟商管理权， 直营不管，如果说加盟商的人，那么要把特殊的加盟商公告管理权查出来
		List<Byte> flagList =  new ArrayList<Byte>();// 查询0=通用的权限，1=总部的，2=加盟商的
		flagList.add(Byte.valueOf("0"));
		if (Integer.valueOf(1).equals(getOperator().openPartner())) {
			if (Integer.valueOf(0).equals(getOperator().getPartnerId())) {// 总部
				flagList.add(Byte.valueOf("1"));
				flagList.add(Byte.valueOf("3"));
			} else if (getOperator().getPartnerId() > 0) {// 加盟商
				flagList.add(Byte.valueOf("2"));
			} else {
				flagList.add(Byte.valueOf("3"));
			}
		}
		
		List<ErpSysPara> sysParaList = erpSysParaMapper.selectSysParaByCompId(cityId, compId);
		Map<String, ErpSysPara> sysParaMap = sysParaList.stream()
				.collect(Collectors.toMap(ErpSysPara::getParamId, val -> val));
		// 模板全权限
		Set<ErpFunOpersDto> funOpersPOList = erpFunOpersMapper.getOpersListByRoleId(cityId, Const.DIC_ROLE_NAME_DEPUTY_MANAGER, operator.getCompType(), null, null, flagList, newOrganizationType);

		// 本人的权限列表
		List<ErpFunOpers> ownOpers = erpFunOpersMapper.getFunOpersListById(cityId, operator.getUserId(), null);
		// 移除不应该显示的权限
		Set<String> opers = new HashSet<>();

		ErpFunComp erpFunComp = erpFunCompMapper.selectByCompId(cityId, compId);
		ErpFunDeptsExample erpFunDeptsExample = new ErpFunDeptsExample();
		erpFunDeptsExample.setShardCityId(cityId);
		erpFunDeptsExample.createCriteria().andCompIdEqualTo(compId);
		List<ErpFunDepts> depts = erpFunDeptsMapper.selectByExample(erpFunDeptsExample);
		// 不是物业版和LINK版下有物业门店
		boolean remove = !(Const.DIC_COMP_TYPE_5.equals(operator.getCompType()) || (erpFunComp != null && erpFunComp.getCompType() == 1
				&& depts != null && depts.stream().anyMatch(it -> it.getSupportPropertyFlag() != null && it.getSupportPropertyFlag() == 1)));
		// 物业版和LINK版下的物业门店有权限, 其他的去权限
		if (remove) {
			opers.addAll(getWuyeDeptOpers(newOrganizationType));
		}
		opers.addAll(getNeedHiddenOper(cityId, compId, Const.DIC_ROLE_NAME_DEPUTY_MANAGER, sysParaMap, newOrganizationType));

		UserOpersUtils.removeHiddenOpers(funOpersPOList, opers);
		
		// 模板的权限
		List<ErpFunOpersDto> modelOpersList = new ArrayList<>(funOpersPOList);
		modelOpersList.sort((val1, val2) -> {
			return Optional.ofNullable(val1.getSeqNo()).orElse(0) - Optional.ofNullable(val2.getSeqNo()).orElse(0);
		});
		
		// 选择的权限
		List<ErpFunOpersDto> checkedRoleOpersList = new ArrayList<ErpFunOpersDto>();
		if (null != permissionTemplateId) {
			ErpFunCompPermissionExample compPermissionExample = new ErpFunCompPermissionExample();
			compPermissionExample.setShardCityId(cityId);
			compPermissionExample.createCriteria().andCompIdEqualTo(compId).andTemplateIdEqualTo(permissionTemplateId);
			List<ErpFunCompPermission> erpFunCompPermissions = erpFunCompPermissionMapper.selectByExample(compPermissionExample);
			
//			Set<String> OperIds = new HashSet<String>();
			if(erpFunCompPermissions != null && erpFunCompPermissions.size() > 0){
//				OperIds = erpFunCompPermissions.stream().collect(Collectors.mapping(ErpFunCompPermission::getOperId, Collectors.toSet()));
				erpFunCompPermissions.stream().forEach(a -> {
					ErpFunOpersDto erpFunOpersDto = new ErpFunOpersDto();
					erpFunOpersDto.setOperId(a.getOperId());
					erpFunOpersDto.setOperType(null != a.getOperType() ? a.getOperType().byteValue() : null);
					checkedRoleOpersList.add(erpFunOpersDto);
				});
			}
			/*if (!OperIds.isEmpty()) {
				checkedRoleOpersList = erpFunOpersMapper.getOpersListByOperIdList(cityId, compId, OperIds);
			}*/
		}
		
		AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(erpFunComp.getCompNo());
		if(("2".equals(adminFunComp.getCompManagementModel().toString())
        		&&"1".equals(adminFunComp.getCustomizedType().toString()))){
			fjdOperNamereplace(modelOpersList);
		}
		
		String[] queryColumn = this.parseQueryParamForFangjidi(cityId, compId, operator.getAreaId(), operator.getRegId(), operator.getDeptId(), operator.getGrId(), param.getPermissionTemplateId());
		
		
		ErpRoleOpersVo erpRoleOpersVo = new ErpRoleOpersVo();
		erpRoleOpersVo.setCheckedRoleOpersList(checkedRoleOpersList);
		erpRoleOpersVo.setLoginUserOpersList(ownOpers);
		erpRoleOpersVo.setModelOpersList(modelOpersList);
		erpRoleOpersVo.setNewSetOper(queryColumn[2]);
		return ErpResponseJson.ok(erpRoleOpersVo);
	}
	
	
	/**
	 * 获取所有组织——美联
	 * @author lzg
	 * @since 2019年12月23日
	 * @return
	 */
	@ApiOperation("获取所有部门列表")
 	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = GetAllOrganizationListVO.class, message = "成功")})
	//@RequestMapping("/getAllOrganizationList") 用陈锋的：一个接口改两个
	@ResponseBody
	public ErpResponseJson getAllOrganizationList() {
		//compId,compName,organizationId,organizationName,pid
		//int compId = getOperator().getCompId();
		int cityId = getOperator().getCityId();
		ErpFunCompExample erpFunCompExample = new ErpFunCompExample();
		erpFunCompExample.createCriteria().andMainCompIsNotNull();
		erpFunCompExample.setShardCityId(cityId);
		List<ErpFunComp> erpFunCompList = erpFunCompMapper.selectByExample(erpFunCompExample);
		GetAllOrganizationListVO result = new GetAllOrganizationListVO();
		if(null != erpFunCompList && erpFunCompList.size() > 0) {
			for (ErpFunComp erpFunComp : erpFunCompList) {
				ErpFunOrganizationExample erpFunOrganizationExample = new ErpFunOrganizationExample();
				erpFunOrganizationExample.createCriteria().andCompIdEqualTo(erpFunComp.getCompId()).andDelFlagEqualTo((byte)0);
				erpFunOrganizationExample.setShardCityId(cityId);
				List<ErpFunOrganization> erpFunOrganizationList = erpFunOrganizationMapper.selectByExample(erpFunOrganizationExample);
				if (erpFunOrganizationList.size() > 0) {
					List<GetAllOrganizationVO> list = new ArrayList<GetAllOrganizationVO>();
					for (ErpFunOrganization erpFunOrganization : erpFunOrganizationList) {
						GetAllOrganizationVO vo = new GetAllOrganizationVO();
						vo.setCompId(erpFunComp.getCompId());
						vo.setCompName(erpFunComp.getCompName());
						vo.setOrganizationId(erpFunOrganization.getOrganizationId());
						vo.setOrganizationName(erpFunOrganization.getOrganizationName());
						vo.setPid(erpFunOrganization.getPid());
						list.add(vo);
					}
					result.setList(list);
				}
			}
		}
		
		return ErpResponseJson.ok(result);
	}
	
	/**
	 * 获取对应组织下的所有人员——美联
	 * @author lzg
	 * @since 2019年12月23日
	 * @return
	 */
	@ApiOperation("获取对应组织下的所有人员")
 	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = GetOrgUsersListVO.class, message = "成功")})
	@RequestMapping("/getOrgUsersList")
	@ResponseBody
	public ErpResponseJson getOrgUsersList(@RequestBody GetOrgUsersListParam param) {
		//接口2：获取对应下的所有人员，条件：compId、organizationId、userNam(名字筛选)，三个条件，至少一个
		int cityId = getOperator().getCityId();
		/*if (null == param.getCompId() && null == param.getOrganizationId() && StringUtil.isBlank(param.getUserName())) {
			return ErpResponseJson.ok();
		}*/
		
		ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
		ErpFunUsersExample.Criteria funUsersExampleCriteria = erpFunUsersExample.createCriteria();
		if (null != param.getCompId() && StringUtil.isBlank(param.getUserName())) {//公司下的所有人
			funUsersExampleCriteria.andCompIdEqualTo(param.getCompId());
		} else if (null != param.getOrganizationId()) {//部门下的所有人
			funUsersExampleCriteria.andOrganizationIdEqualTo(param.getOrganizationId());
		} else if (StringUtil.isNotBlank(param.getUserName())) {//名字对应的人
			funUsersExampleCriteria.andUserNameLike("%" + param.getUserName() + "%");
			if (null != param.getCompId()) {
				funUsersExampleCriteria.andCompIdEqualTo(param.getCompId());
			}
		}
		funUsersExampleCriteria.andCompIdGreaterThan(1000).andUserWriteoffEqualTo(false);
		erpFunUsersExample.setShardCityId(cityId);
		List<ErpFunUsers> erpFunUserList = erpFunUsersMapper.selectByExample(erpFunUsersExample);
		GetOrgUsersListVO result = new GetOrgUsersListVO();
		if (erpFunUserList.size() > 0) {
			List<GetOrgUsersVO> list = new ArrayList<GetOrgUsersVO>();
			for (ErpFunUsers erpFunUsers : erpFunUserList) {
				GetOrgUsersVO vo = new GetOrgUsersVO();
				vo.setCompId(erpFunUsers.getCompId());
				vo.setUserId(erpFunUsers.getUserId());
				vo.setUserName(erpFunUsers.getUserName());
				vo.setUserPhoto(erpFunUsers.getUserPhoto());
				vo.setOrganizationId(erpFunUsers.getOrganizationId());
				
				ErpCompRolesExample erpCompRolesExample = new ErpCompRolesExample();
				erpCompRolesExample.createCriteria().andRoleIdEqualTo(erpFunUsers.getUserPosition()).andCompIdEqualTo(erpFunUsers.getCompId()).andIsDelEqualTo((byte)0);
				erpCompRolesExample.setShardCityId(cityId);
				List<ErpCompRoles> roleList = erpCompRolesMapper.selectByExample(erpCompRolesExample);
				if (!roleList.isEmpty() && roleList.size() > 0) {
					vo.setRoleName(roleList.get(0).getRoleName());
				}
				list.add(vo);
			}
			result.setList(list);
		}
		
		return ErpResponseJson.ok(result);
	}

	/**
	 * 保存对应用户的跨城权限列表（新增、修改）——美联
	 * @author lzg
	 * @since 2019年12月24日
	 * @param param
	 * @return
	 */
	@ApiOperation("保存对应用户的跨城权限列表（新增、修改）")
 	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")})//SaveCrossCompOperVO
	@PostMapping("/saveCrossCompOper")
	@ResponseBody
	@NotBlank("userId")
	public ErpResponseJson saveCrossCompOper(@RequestBody SaveCrossCompOperParam param) {
		/*  {
			  "operList":[
			    {"compId":"10001","addOpers":"sfd,sde","delOpers":""},
			    {"compId":"10002","addOpers":"","delOpers":""}
			  ],
			  "openCityManage"[
			    {"compId":10001,"isOpen":1},
			    {"compId":10002,"isOpen":0}
			  ]
			}
		 */
		erpUserOpersService.saveCrossCompOper(param, getOperator());
		/**
		 * 修改了管理权限要踢人的
		 */
		ErpFunUsers users = erpFunUsersMapper.selectByUserId(getOperator().getCityId(), param.getUserId());
		erpFunUsersService.endLoginUser(users.getArchiveId(), users.getUserMobile(), LogInEnum.RoleOrOper_UP);
		return ErpResponseJson.ok();
	}
	
	
	
	/**
	 * @brief 获取所有跨城管理员列表——美联
	 * @detail [2020/03/10] 李中国 给头像参数增加域名前缀
	 * @author lzg
	 * @since 2019年12月23日
	 * @param param
	 * @return
	 */
	@ApiOperation("获取所有跨城管理员列表")
 	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = GetCrossCompUserListVO.class, message = "成功")})
	@RequestMapping("/getCrossCompUserList")
	@ResponseBody
	public ErpResponseJson getCrossCompUserList() {
		//compId、userID、userName、rolse
		int cityId = getOperator().getCityId();
		
		List<ErpFunCrossCompUser> erpFunCrossCompUserList = erpFunCrossCompUserMapper.getCrossCompUser(cityId);
		GetCrossCompUserListVO result = new GetCrossCompUserListVO();
		if(!erpFunCrossCompUserList.isEmpty() && erpFunCrossCompUserList.size() > 0) {
			List<GetCrossCompUserVO> list = new ArrayList<GetCrossCompUserVO>();
			for (ErpFunCrossCompUser erpFunCrossCompUser : erpFunCrossCompUserList) {
				GetCrossCompUserVO getCrossCompUserVO = erpFunUsersMapper.selectUserRoleByUserID(cityId, erpFunCrossCompUser.getUserId());
				if (null != getCrossCompUserVO) {
					if (StringUtil.isNotBlank(getCrossCompUserVO.getUserPhoto())) {
						getCrossCompUserVO.setUserPhoto(AppConfig.getPicDomainUrl() + getCrossCompUserVO.getUserPhoto());
					}
					list.add(getCrossCompUserVO);
				}
			}
			result.setList(list);
		}
		
		return ErpResponseJson.ok(result);
	}
	
	/**
	 * 获取跨城权限模板、以及获取对应用户的跨城权限列表——美联
	 * @author lzg
	 * @since 2019年12月23日
	 * @return
	 */
	@ApiOperation("获取跨城权限模板、以及获取对应用户的跨城权限列表")
 	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = GetCrossCompUserOperListVO.class, message = "成功")})
	@RequestMapping("/getCrossCompUserOper")
	@ResponseBody
	public ErpResponseJson getCrossCompUserOper(@RequestBody GetCrossCompUserOperParam param) {
		int cityId = getOperator().getCityId();
		int compId = getOperator().getCompId();
		
		//获取跨城权限模板
		ErpFunCrossCompOperExample erpFunCrossCompOperExample = new ErpFunCrossCompOperExample();
		erpFunCrossCompOperExample.createCriteria();
		erpFunCrossCompOperExample.setShardCityId(cityId);
		List<ErpFunCrossCompOper> crossCompOperList = erpFunCrossCompOperMapper.selectByExample(erpFunCrossCompOperExample);
		List<GetCrossCompOperVO> getCrossCompOperVOList = new ArrayList<GetCrossCompOperVO>();
		for (ErpFunCrossCompOper crossCompOper : crossCompOperList) {
			GetCrossCompOperVO vo = new GetCrossCompOperVO();
			vo.setOperType(crossCompOper.getOperType().intValue());
			vo.setOperId(crossCompOper.getOperId());
			vo.setOperName(crossCompOper.getOperName());
			getCrossCompOperVOList.add(vo);
		}
		GetCrossCompUserOperListVO result = new GetCrossCompUserOperListVO();
		result.setCrossCompOperModel(getCrossCompOperVOList);
		
		//获取对应用户的跨城权限列表
		ErpFunCrossCompStatusExample erpFunCrossCompStatusExample = new ErpFunCrossCompStatusExample();
		erpFunCrossCompStatusExample.createCriteria().andUserIdEqualTo(param.getUserId()).andOpenFlagEqualTo((byte)1);//.andCompIdNotEqualTo(compId).andCompIdNotEqualTo(主公司)
		erpFunCrossCompStatusExample.setShardCityId(cityId);
		List<ErpFunCrossCompStatus> erpFunCrossCompStatuList = erpFunCrossCompStatusMapper.selectByExample(erpFunCrossCompStatusExample);
		List<GetCrossCompUserOperVO> getCrossCompUserOperVOList = new ArrayList<GetCrossCompUserOperVO>();
		if(erpFunCrossCompStatuList.size() > 0) {
			for (ErpFunCrossCompStatus erpFunCrossCompStatus : erpFunCrossCompStatuList) {
				ErpFunCrossCompUserOperExample erpFunCrossCompUserOperExample = new ErpFunCrossCompUserOperExample();
				erpFunCrossCompUserOperExample.createCriteria().andUserIdEqualTo(param.getUserId()).andCompIdEqualTo(erpFunCrossCompStatus.getCompId());
				erpFunCrossCompUserOperExample.setShardCityId(cityId);
				List<ErpFunCrossCompUserOper> erpFunCrossCompUserOperList = erpFunCrossCompUserOperMapper.selectByExample(erpFunCrossCompUserOperExample);
				String opers = "";
				for (ErpFunCrossCompUserOper erpFunCrossCompUserOper : erpFunCrossCompUserOperList) {
					opers += erpFunCrossCompUserOper.getOperId() + ",";
				}
				GetCrossCompUserOperVO vo = new GetCrossCompUserOperVO();
				vo.setCompId(erpFunCrossCompStatus.getCompId());
				vo.setOpers(opers);
				getCrossCompUserOperVOList.add(vo);
			}
		}
		result.setCrossCompUserOpers(getCrossCompUserOperVOList);
		return ErpResponseJson.ok(result);
	}
	
	
}

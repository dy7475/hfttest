package com.myfun.erpWeb.managecenter.sysmanager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.common.vo.OrganizationDefinitionVO;
import com.myfun.erpWeb.common.vo.OrganizationVO;
import com.myfun.erpWeb.homepage.vo.KaCompDeptPayVo;
import com.myfun.erpWeb.managecenter.axn.param.UnBindNumberParam;
import com.myfun.erpWeb.managecenter.param.AddCompInviteRegistParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.*;
import com.myfun.erpWeb.managecenter.sysmanager.vo.*;
import com.myfun.erpWeb.managecenter.userOpers.UserOpersControlller;
import com.myfun.erpWeb.managecenter.userOpers.param.CreateOrUpdatePermissionTemplateParam;
import com.myfun.erpWeb.managecenter.userOpers.param.DeletePermissionTemplateParam;
import com.myfun.erpWeb.managecenter.userOpers.vo.GetPermissionTemplateListVO;
import com.myfun.erpWeb.managecenter.userOpers.vo.PermissionTemplateVO;
import com.myfun.erpWeb.managecenter.vo.ErpInviteUserLogVo;
import com.myfun.erpWeb.managecenter.vo.ManageLevelVo;
import com.myfun.erpWeb.openApi.user.param.DealNewOrgUserCountMessage;
import com.myfun.erpWeb.usercenter.UserCenterController;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.framework.web.utils.PoConverterToView;
import com.myfun.repository.admindb.dao.*;
import com.myfun.repository.admindb.dto.AdminFunDeptsDto;
import com.myfun.repository.admindb.dto.SoftContractDto;
import com.myfun.repository.admindb.po.*;
import com.myfun.repository.agencydb.dao.AgencyFunCustMapper;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.*;
import com.myfun.repository.erpdb.param.DeleteUsersParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.admindb.AdminFunArchiveService;
import com.myfun.service.business.admindb.AdminFunCompService;
import com.myfun.service.business.admindb.AdminMobileKeyService;
import com.myfun.service.business.erpdb.*;
import com.myfun.service.business.erpdb.bean.vo.UserOrganizationInfoVO;
import com.myfun.service.business.erpdb.impl.ErpFunDeptsServiceImpl;
import com.myfun.service.business.report.ReportFunSaleMinService;
import com.myfun.service.business.taskJob.HttpRequestTask;
import com.myfun.service.jms.activeMQ.ActiveMqPublisher;
import com.myfun.utils.*;
import com.myfun.utils.rijindael.AESHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.builder.BuilderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;


/**
 * @author lcb
 * @TODO 组织机构模块
 * @2016-10-18 下午6:00:17
 * 
 * 职级对应的薪资处理逻辑也包含在这里面。查看：deleteWageRoleLevel方法
 * 陈文超
 */
@Api(tags = "组织机构模块")
@RestController
@RequestMapping("/managerCenter/organization")
public class OrganizationController extends BaseController {
    Logger logger = LoggerFactory.getLogger(ErpFunDeptsServiceImpl.class);
    @Autowired
    AdminFunArchiveMapper adminFunArchiveMapper;
    @Autowired
    ErpFunAreaService erpFunAreaService;
    @Autowired
    ErpFunUsersService erpFunUsersService;
    @Autowired
    HttpRequestTask httpRequestTask;
    @Autowired
    AdminInviteRegistErpMapper adminInviteRegistErpMapper;
    @Autowired
    AdminMobileKeyService adminMobileKeyService;
    @Autowired
    ErpFunAreaMapper erpFunAreaMapper;
    @Autowired
    ErpFunRegionMapper erpFunRegionMapper;
    @Autowired
    ErpFunCompMapper erpFunCompMapper;
    @Autowired
    ErpFunDeptsMapper erpFunDeptsMapper;
    @Autowired
    ErpFunRegMapper erpFunRegMapper;
    @Autowired
    ErpFunUsersMapper erpFunUsersMapper;
    @Autowired
    ErpFunUserManageRangeMapper erpFunUserManageRangeMapper;
    @Autowired
    ErpFunUserManageRangeService erpFunUserManageRangeService;
    @Autowired
    ErpFunDeptsgroupMapper erpFunDeptsgroupMapper;
    @Autowired
    ErpCompRolesMapper erpCompRolesMapper;
    @Autowired
    ErpMarketVirtualGeneralMapper erpMarketVirtualGeneralMapper;
    @Autowired
    ErpCompRolesService erpCompRolesService;
    @Autowired
    ErpFunPersonnelLevelsMapper erpFunPersonnelLevelsMapper;
    @Autowired
    ErpFunRecruitmentChannelMapper erpFunRecruitmentChannelMapper;
    @Autowired
    ErpFunRegsectionControlMapper erpFunRegsectionControlMapper;
    @Autowired
    ErpFunRegsectionControlService erpFunRegsectionControlService;
    @Autowired
    ErpFunRegionService erpFunRegionService;
    @Autowired
    ErpFunDeptsService erpFunDeptsService;
    @Autowired
    ErpSystemSettingLogsService erpSystemSettingLogsService;
    @Autowired
    ErpFunSaleService erpFunSaleService;
    @Autowired
    ErpFunLeaseService erpFunLeaseService;
    @Autowired
    ErpFunSaleMapper erpFunSaleMapper;
    @Autowired
    ErpFunLeaseMapper erpFunLeaseMapper;
    @Autowired
    ErpFunBuyCustomerService erpFunBuyCustomerService;
    @Autowired
    ErpFunRentCustomerService erpFunRentCustomerService;
    @Autowired
    ErpCompRoleOpersService erpCompRoleOpersService;
    @Autowired
    ErpFunDeptsGroupService erpFunDeptsGroupService;
    @Autowired
    ErpFunEmployeeLogMapper erpFunEmployeeLogMapper;
    @Autowired
    ErpFunRecruitmentChannelService erpFunRecruitmentChannelService;
    @Autowired
    ErpFunPersonnelLevelsService erpFunPersonnelLevelsService;
    @Autowired
    ErpFunRentCustomerMapper erpFunRentCustomerMapper;
    @Autowired
    ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
    @Autowired
    AgencyFunCustMapper agencyFunCustMapper;
    @Autowired
    ErpFunAttendanceGroupBizService erpFunAttendanceGroupBizService;
    @Autowired
    ErpFunAttendanceGroupBizPersonService erpFunAttendanceGroupBizPersonService;
    @Autowired
    ErpFunAttendanceScopeBizPersonService erpFunAttendanceScopeBizPersonService;
    @Autowired
    ErpFunAttendanceScopeBizService erpFunAttendanceScopeBizService;
    @Autowired
    AdminMobileKeyMapper adminMobileKeyMapper;
    @Autowired
    AdminSysParaMapper adminSysParaMapper;
    @Autowired
    ErpAuditRuntimeService erpAuditRuntimeService;
    @Autowired
    ErpCompRoleOpersMapper erpCompRoleOpersMapper;
    @Autowired
    ErpSysParaMapper erpSysParaMapper;
    @Autowired
    ErpUserOpersMapper erpUserOpersMapper;
    @Autowired
    ErpRoleOpersMapper erpRoleOpersMapper;
    @Autowired
    ErpFunOpersMapper erpFunOpersMapper;
    @Autowired
    AdminFunCityMapper adminFunCityMapper;
    @Autowired
    AdminFunDeptsMapper adminFunDeptsMapper;
    @Autowired
    AdminAddDeptsApplyMapper adminAddDeptsApplyMapper;
    @Autowired
    UserCenterController userCenterController;
    @Autowired
    ErpFunSectionMapper erpFunSectionMapper;
    @Autowired
    UserOpersControlller userOpersControlller;
    @Autowired
    ErpNoTransactionService erpNoTransactionService;
    @Autowired
    AdminFunArchiveService adminFunArchiveService;
    @Autowired
    AdminFunCompMapper adminFunCompMapper;
    @Autowired
    ErpFunRolesMapper erpFunRolesMapper;
    @Autowired
    ErpFunUsersInvitedMapper erpFunUsersInvitedMapper;
    @Autowired
    AdminCrmFunContractMapper adminCrmFunContractMapper;
    @Autowired
    ErpFunEmployeeDocMapper erpFunEmployeeDocMapper;
    @Autowired
    ErpBuildingInfoMapper erpBuildingInfoMapper;
    @Autowired
    ErpFunEmployeeFileMapper erpFunEmployeeFileMapper;
    @Autowired
    ErpFunUserResumeMapper erpFunUserResumeMapper;
    @Autowired
    AdminFunCompSkinMapper adminFunCompSkinMapper;
    @Autowired
    ErpFunRoleLevelsMapper erpFunRoleLevelsMapper;
    @Autowired
    ErpFunRoleLevelsService erpFunRoleLevelsService;
    @Autowired
    ErpFunRoleWageConfigMapper erpFunRoleWageConfigMapper;
    @Autowired
    ErpFunRoleWageConfigService erpFunRoleWageConfigService;
    @Autowired
    private AdminPropertyBuildMapMapper adminPropertyBuildMapMapper;
    @Autowired
    private ErpInviteUserLogMapper erpInviteUserLogMapper;
    @Autowired
    private ErpZxRoleConfigMapper erpZxRoleConfigMapper;
    @Autowired
    private AdminFunCompService adminFunCompService;
    @Autowired
   	private ReportFunSaleMinService reportFunSaleMinService;
    @Autowired
    private ErpFunCompPermissionTemplateMapper erpFunCompPermissionTemplateMapper;
    @Autowired
    private ErpFunCompRolesPermissionTemplateRelateMapper erpFunCompRolesPermissionTemplateRelateMapper;
	@Autowired
	private ErpFunOrganizationMapper erpFunOrganizationMapper;
	@Autowired
	private ErpFunOrganizationService erpFunOrganizationService;
	@Autowired
	private ErpAuditUserTemplateMapper erpAuditUserTemplateMapper;
	@Autowired
	private ActiveMqPublisher activeMqPublisher;
	@Autowired
	ErpFunOrganizationDefinitionMapper erpFunOrganizationDefinitionMapper;
	@Autowired
	private ErpAliyunPhoneService erpAliyunPhoneService;
	@Autowired
	ErpFunOrganizationManagerMapper erpFunOrganizationManagerMapper;
	@Autowired
	ErpFunCrossCompUserMapper erpFunCrossCompUserMapper;
	@Autowired
	ErpFunSalePublishInfoMapper erpFunSalePublishInfoMapper;
	@Autowired
	ErpFunLeasePublishInfoMapper erpFunLeasePublishInfoMapper;

    /**
     * 邀请注册列表
     * @param param
     * @return
     * @throws Exception
     */
	@ApiOperation("邀请注册列表")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpInviteUserLogVo.class, message = "成功")})
	@ResponseBody
	@RequestMapping("/getInvitationRegList")
	public ErpResponseJson getInvitationRegList(@Valid @RequestBody GetInvitationRegListParam param) throws Exception {
		//查询当前人的权限
		
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer userId = operator.getUserId();
		List<String> operIds = new ArrayList<String>();
		operIds.add("AUDIT_COMP_REGISTRATION");
		operIds.add("AUDIT_AREA_REGISTRATION");
		operIds.add("AUDIT_REG_REGISTRATION");
		operIds.add("AUDIT_DEPT_REGISTRATION");
		operIds.add("AUDIT_GROUP_REGISTRATION");

		ErpUserOpersExample erpUserOpersExample = new ErpUserOpersExample();
		erpUserOpersExample.setShardCityId(cityId);
		erpUserOpersExample.createCriteria().andUserIdEqualTo(userId).andOperIdIn(operIds);
		List<ErpUserOpers> erpUserOpers =  erpUserOpersMapper.selectByExample(erpUserOpersExample);
		if(erpUserOpers == null || erpUserOpers.size() < 0){
			return ErpResponseJson.ok();
		}
		Set<String> userOperIds = new HashSet<String>();
		for (ErpUserOpers userOper : erpUserOpers) {
			userOperIds.add(userOper.getOperId());
		}
		
		Integer compId =  operator.getCompId();
		Integer areaId = operator.getAreaId();
		Integer rgId = operator.getRegId();
		Integer deptId = operator.getDeptId();
		Integer groupId = operator.getGrId();
		if(userOperIds.contains("AUDIT_COMP_REGISTRATION")){
			param.setCompId(compId);
		}else if(userOperIds.contains("AUDIT_AREA_REGISTRATION")){
			param.setCompId(compId);
			param.setAreaId(areaId);
		}else if(userOperIds.contains("AUDIT_REG_REGISTRATION")){
			param.setCompId(compId);
			param.setAreaId(areaId);
			param.setRgId(rgId);
		}else if(userOperIds.contains("AUDIT_DEPT_REGISTRATION")){
			param.setCompId(compId);
			param.setAreaId(areaId);
			param.setRgId(rgId);
			param.setDeptId(deptId);
		}else if(userOperIds.contains("AUDIT_GROUP_REGISTRATION")){
			param.setCompId(compId);
			param.setAreaId(areaId);
			param.setRgId(rgId);
			param.setDeptId(deptId);
			param.setGroupId(groupId);
		}else{
			return ErpResponseJson.ok();
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<ErpInviteUserLogVo> erpInviteUserLogs = erpInviteUserLogMapper.getInvitationRegList(cityId,param);
		Set<Integer> userIds = new HashSet<Integer>();
		if(erpInviteUserLogs !=null &&erpInviteUserLogs.size() > 0){
			for (ErpInviteUserLogVo erpInviteUserLog : erpInviteUserLogs) {
				userIds.add(erpInviteUserLog.getInviteUserId());
			}
		}
		
		if(userIds.size() > 0){
			ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
			erpFunUsersExample.setShardCityId(cityId);
			erpFunUsersExample.createCriteria().andCompIdEqualTo(compId).andUserIdIn(new ArrayList<>(userIds)).andUserWriteoffEqualTo(false);
			List<ErpFunUsers> erpFunUsers = erpFunUsersMapper.selectByUserNameExample(erpFunUsersExample);
			if(erpFunUsers !=null && erpFunUsers.size() > 0){
				Map<Integer,String> userNameMap = erpFunUsers.stream().collect(Collectors.toMap(ErpFunUsers::getUserId,ErpFunUsers->ErpFunUsers.getUserName()));
				for (ErpInviteUserLogVo erpInviteUserLog : erpInviteUserLogs) {
					if(userNameMap.containsKey(erpInviteUserLog.getInviteUserId())){
						erpInviteUserLog.setInvitUserName(userNameMap.get(erpInviteUserLog.getInviteUserId()));
					}
				}
			}
		}
		ErpResponseJson  responseJson = ErpResponseJson.ok(new PageInfo<>(erpInviteUserLogs)); 
		Map<String,Object> returnData = new HashMap<String,Object>();
		returnData.put("dataList", responseJson.getData());
		responseJson.setData(returnData);
		return responseJson;
	}
    
    
    
	/**
	 * 组织机构  --获取大区信息列表
	 * @author lcb
	 * @2016-10-18 下午6:23:24
	 */
	@ApiOperation("组织机构获取大区信息列表,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpFunAreaVo.class, message = "成功")})
	@ResponseBody
	@RequestMapping("/getAreaList")
	public ErpResponseJson getAreaList(@Valid @RequestBody GetAreaListParam param) throws Exception {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer selfUserId = operator.getUserId();
		Integer selfAreaId = operator.getAreaId();
		ErpFunArea erpFunArea = new ErpFunArea();
		erpFunArea.setCompId(operator.getCompId());
		erpFunArea.setShardCityId(operator.getCityId());
		erpFunArea.setIsDel((byte) 0);
		List<ErpFunAreaDto> areaDtoList = erpFunAreaMapper.selectByCondition(erpFunArea);
		String[] operIdArr = new String[] { "MANAGE_COMP_ORGANIZATION", "MANAGE_AREA_ORGANIZATION",
				"MANAGE_REG_ORGANIZATION", "MANAGE_DEPT_ORGANIZATION", "MANAGE_GROUP_ORGANIZATION" };
		ManageLevelVo manageLevelVo = userOpersControlller.judgeLevelByOperList(cityId, selfUserId, 1000, operIdArr);
		Integer canOper = manageLevelVo.getCanOper();
		Integer operLevel = manageLevelVo.getOperLevel();
		if(canOper == 0){
			operLevel = 6;
		}
		// 获取片区列表
		ErpFunRegion erpFunRegion = new ErpFunRegion();
		erpFunRegion.setCompId(operator.getCompId());
		erpFunRegion.setShardCityId(operator.getCityId());
		erpFunRegion.setIsDel((byte) 0);
		List<ErpFunRegionDto> regList = erpFunRegionMapper.selectListByCondition(erpFunRegion);
		// 转换成map结构
		Map<Integer, List<ErpFunRegion>> funRegionMap = regList.stream().collect(Collectors.groupingBy(ErpFunRegion::getAreaId));
		for (ErpFunAreaDto funArea : areaDtoList) {
			List<ErpFunRegion> regionList = funRegionMap.get(funArea.getAreaId());
			if (regionList != null && regionList.size() > 0) {
				String regNameStr = regionList.stream().collect(Collectors.mapping(ErpFunRegion::getRegName, Collectors.joining(",")));
				funArea.setRegName(regNameStr);
			}
			if(operLevel > 2 || (operLevel == 2 && !selfAreaId.equals(funArea.getAreaId()))){
				funArea.setAreaAdmin("");
				funArea.setAreaTele("");
			}
		}
		// 将自己所在的大区置顶，重新排序
		areaDtoList.sort((val1, val2) -> {
			if (operator.getAreaId().equals(val1.getAreaId())) {
				return -1;
			} else if (operator.getAreaId().equals(val2.getAreaId())) {
				return 1;
			}
			return Optional.ofNullable(val1.getSeqNo()).orElse(0) - Optional.ofNullable(val2.getSeqNo()).orElse(0);
		});
		Integer countUser = param.getCountUser();
		ErpFunAreaVo erpFunAreaVo = new ErpFunAreaVo();
		if (countUser == null || countUser != 1) {
			erpFunAreaVo.setAreaList(areaDtoList);
			return ErpResponseJson.ok(erpFunAreaVo);
		}
		// 统计大区人数  dyh  2018/7/26
		List<Map<String, Integer>> countAreaUserList = erpFunUsersMapper.countUserByArea(operator.getCityId(), operator.getCompId());
		if (countAreaUserList == null) {
			erpFunAreaVo.setAreaList(areaDtoList);
			return ErpResponseJson.ok(erpFunAreaVo);
		}
		Map<Integer, Map<String, Integer>> countUserMap = countAreaUserList.stream().collect(Collectors.toMap(map -> map.get("areaId"), val -> val));
		areaDtoList.forEach(areaDto -> {
			Map<String, Integer> map = countUserMap.get(areaDto.getAreaId());
			if (map != null) {
				areaDto.setCountUser(map.get("count"));
			} else {
				areaDto.setCountUser(0);
			}
		});
		erpFunAreaVo.setAreaList(areaDtoList);
		return ErpResponseJson.ok(erpFunAreaVo);
	}

    /**
     * @TODO 组织机构  --获取公司信息  --未开大区时的默认显示信息
     * @author lcb
     * @2016-10-18 下午6:23:24
     * @Param compId
     */
    @ApiOperation("获取公司信息")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunComp.class, message = "成功")
    })
    @PostMapping("/getCompanyData")
    @ResponseBody
    public ErpResponseJson getCompanyData(@Valid @RequestBody BaseMapParam param) {
        Operator operator = getOperator();
        Integer compId = operator.getCompId();
        ErpFunComp erpFunComp = new ErpFunComp(operator.getCityId(), compId);

        //为了确保万无一失，这里还是取admin库的areaFlag
        AdminFunComp adminFunComp = adminFunCompMapper.selectByCompId(operator.getAdminCompId());
		ErpFunCompDto funComp = erpFunCompMapper.getCompInfoByCompNo(operator.getCityId(), adminFunComp.getCompNo());
        if(null != adminFunComp) {
            funComp.setAreaFlag(adminFunComp.getAreaFlag());
			funComp.setPlaintPwd(adminFunComp.getPlaintPwd());
        }
        
        // 获取公司自定义的头像
        AdminFunCompSkinExample adminFunCompSkinExample = new AdminFunCompSkinExample();
        adminFunCompSkinExample.createCriteria().andCompNoEqualTo(operator.getCompNo())
        	.andClientTypeEqualTo(0).andSkinPicUrlTypeEqualTo(1);
		List<AdminFunCompSkin> adminFunCompSkinList = adminFunCompSkinMapper.selectByExample(adminFunCompSkinExample);
		if(adminFunCompSkinList.size() > 0) {
			adminFunCompSkinList.stream().forEach(val-> {
				if(StringUtil.isNotBlank(val.getSkinType()) && "ERP_LOGIN_ICON_200".equals(val.getSkinType()) && StringUtil.isNotBlank(val.getSkinPicUrl())) {
					funComp.setLogoPath(AppConfig.getPicDomainUrl() + val.getSkinPicUrl());
				} else if (StringUtil.isNotBlank(val.getSkinType()) && "ERP_LOGIN_ICON".equals(val.getSkinType()) && StringUtil.isNotBlank(val.getSkinPicUrl())) {
					funComp.setLogoPath(AppConfig.getPicDomainUrl() + val.getSkinPicUrl());
				}
			});
		}
        return ErpResponseJson.ok(funComp);
    }



    @ApiOperation("更新總部名字")
    @ApiResponses(value = {@ApiResponse( code = Const.ResponseCode.SUCCESS,response = ErpResponseJson.class,message = "成功")})
    @PostMapping("/updateCompHeadName")
    @ResponseBody
    public ErpResponseJson updateCompHeadName(@Valid @RequestBody UpdateCompNameParam updateCompNameParam){
        Operator operator = getOperator();
        Integer compId = operator.getCompId();
        // 若是传""则设为null
        String headName = updateCompNameParam.getHeadName();
        String businessName = updateCompNameParam.getBusinessName();
        if (headName == null && businessName == null){
            return ErpResponseJson.ok();
        }
        erpFunCompMapper.updateCompHeadNameOrBusinessNameByCompId(operator.getCityId(),headName,businessName,compId);
        return ErpResponseJson.ok();
    }


	/**
	 * @TODO 组织机构  --获取大区信息列表
	 * @author lcb
	 * @2016-10-18 下午6:23:24
	 */
	@ApiOperation("组织机构,获取片区信息列表,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpFunRegionVo.class, message = "成功")})
	@ResponseBody
	@RequestMapping("/getRangeList")
	public ErpResponseJson getRangeList(@Valid @RequestBody GetRegionListParam param) throws Exception {
		Operator operator = getOperator();
		Integer areaId = param.getAreaId();
		Integer cityId = operator.getCityId();
		Integer selfUserId = operator.getUserId();
		Integer selfRegId = operator.getRegId();
		Integer countUser = param.getCountUser();
		ErpFunRegion erpFunRegion = new ErpFunRegion();
		erpFunRegion.setShardCityId(operator.getCityId());
		erpFunRegion.setCompId(operator.getCompId());
		erpFunRegion.setAreaId(areaId);
		erpFunRegion.setIsDel((byte) 0);
		List<ErpFunRegionDto> erpFunRegionList = erpFunRegionMapper.selectListByCondition(erpFunRegion);
		String[] operIdArr = new String[] { "MANAGE_COMP_ORGANIZATION", "MANAGE_AREA_ORGANIZATION",
				"MANAGE_REG_ORGANIZATION", "MANAGE_DEPT_ORGANIZATION", "MANAGE_GROUP_ORGANIZATION" };
		ManageLevelVo manageLevelVo = userOpersControlller.judgeLevelByOperList(cityId, selfUserId, 1000, operIdArr);
		Integer canOper = manageLevelVo.getCanOper();
		Integer operLevel = manageLevelVo.getOperLevel();
		if(canOper == 0){
			operLevel = 6;
		}
		// 查询门店列表
		ErpFunDepts erpFunDepts = new ErpFunDepts();
		erpFunDepts.setCompId(operator.getCompId());
		erpFunDepts.setShardCityId(operator.getCityId());
		List<ErpFunDepts> deptList = erpFunDeptsMapper.getDeptListByCompId(erpFunDepts);
		Map<Integer, List<ErpFunDepts>> deptMap = deptList.stream().collect(Collectors.groupingBy(ErpFunDepts::getRegId));
		for (ErpFunRegionDto tempRegion : erpFunRegionList) {
			List<ErpFunDepts> deptsList = deptMap.get(tempRegion.getRegId());
			if (deptsList != null) {
				String deptNameStr = deptsList.stream().collect(Collectors.mapping(ErpFunDepts::getDeptName, Collectors.joining(",")));
				tempRegion.setDeptName(deptNameStr);
			}
			if(operLevel > 3 || (operLevel == 3 && !selfRegId.equals(tempRegion.getRegId()))){
				tempRegion.setRegAdmin("");
				tempRegion.setRegTele("");
			}
		}
		// 将自己所在的大区置顶，重新排序
		erpFunRegionList.sort((val1, val2) -> {
			if (operator.getRegId().equals(val1.getRegId())) {
				return -1;
			} else if (operator.getRegId().equals(val2.getRegId())) {
				return 1;
			}
			return Optional.ofNullable(val1.getSeqNo()).orElse(0) - Optional.ofNullable(val2.getSeqNo()).orElse(0);
		});
		ErpFunRegionVo erpFunRegionVo = new ErpFunRegionVo();
		if (countUser == null || countUser != 1) {
			erpFunRegionVo.setFunRegionList(erpFunRegionList);
			return ErpResponseJson.ok(erpFunRegionVo);
		}
		// 统计片区人数  dyh
		List<Map<String, Integer>> countRegUserList = erpFunUsersMapper.countUserByRegion(operator.getCityId(), operator.getCompId(), areaId);
		if (countRegUserList == null) {
			erpFunRegionVo.setFunRegionList(erpFunRegionList);
			return ErpResponseJson.ok(erpFunRegionVo);
		}
		Map<Integer, Map<String, Integer>> countUserMap = countRegUserList.stream().collect(Collectors.toMap(map -> map.get("regId"), val -> val));
		erpFunRegionList.forEach(regionDto -> {
			Map<String, Integer> map = countUserMap.get(regionDto.getRegId());
			if (map != null) {
				regionDto.setCountUser(map.get("count"));
			} else {
				regionDto.setCountUser(0);
			}
		});
		erpFunRegionVo.setFunRegionList(erpFunRegionList);
		return ErpResponseJson.ok(erpFunRegionVo);
	}

    /**
     * @TODO 组织机构 --根据区域Id 获取分店列表
     * @author lcb
     * @2016-10-18 下午6:23:24
     */
	@ApiOperation("组织机构根据区域Id获取分店列表,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpFunDeptsVo.class, message = "成功")})
    @RequestMapping("/getDeptListByReg")
    @ResponseBody
    public ErpResponseJson getDeptListByReg(@Valid @RequestBody GetDeptListParam param) throws Exception {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = param.getCompId();
		Integer regId = param.getRegId();
		Integer countUser = param.getCountUser();
        Byte isHeadquarters = param.getIsHeadQuarters();
        if(null == isHeadquarters){
        	isHeadquarters = 0;
        }
        if (compId == null){compId = operator.getCompId();}
        ErpFunDeptsVo erpFunDeptsVo = new ErpFunDeptsVo();
        ErpFunDepts erpFunDepts = new ErpFunDepts();
        erpFunDepts.setCompId(compId);
        erpFunDepts.setIsHeadquarters(isHeadquarters);
        if (null != regId) {
            erpFunDepts.setRegId(regId);
        }
        erpFunDepts.setShardCityId(operator.getCityId());
        List<ErpFunDeptsDto> funDeptsDtoList = erpFunDeptsMapper.getDeptDtoListByCompId(erpFunDepts);
        //查询门店验证码
		List<String> deptNoList = funDeptsDtoList.stream().collect(Collectors.mapping(dept -> dept.getDeptNo(), Collectors.toList()));
		Map<String, AdminFunDepts> pwdDescMap =null;
		if (deptNoList.size() > 0) {
			AdminFunDeptsExample adminFunDeptsExample = new AdminFunDeptsExample();
			adminFunDeptsExample.createCriteria().andCompNoEqualTo(operator.getCompNo()).andDeptNoIn(deptNoList);
			List<AdminFunDepts> adminFunDepts = adminFunDeptsMapper.selectByExample(adminFunDeptsExample);
			pwdDescMap = adminFunDepts.stream().collect(Collectors.toMap(dept -> dept.getDeptNo(), dept -> dept));
		}
		erpFunDepts.setShardCityId(operator.getCityId());
		List<Integer> propertyDeptIds = new ArrayList<>();
		List<Integer> serviceBuildIds = new ArrayList<>();
		for (ErpFunDeptsDto temp : funDeptsDtoList) {
            ErpFunReg pReg = new ErpFunReg();
            pReg.setRegId(temp.getRegionId());
            pReg.setShardCityId(operator.getCityId());
            ErpFunReg regPO = erpFunRegMapper.selectByPrimaryKey(pReg);
            if (regPO == null) {
                logger.warn("FunReg >>REG_ID:{}为空", temp.getRegionId());
            } else {
                temp.setRegionName(regPO.getRegName());
            }
            // 验证码信息
			if (pwdDescMap != null) {
				AdminFunDepts adminFunDepts =  pwdDescMap.get(temp.getDeptNo());
				String pwdDesc = adminFunDepts.getPwdDesc();
				temp.setPwdDesc(pwdDesc);
				temp.setSupportPropertyFlag(adminFunDepts.getSupportPropertyFlag());
				temp.setContactPhone(adminFunDepts.getContactPhone());
				temp.setDeptContact(adminFunDepts.getDeptContact());
				if (Byte.valueOf("1").equals(adminFunDepts.getSupportPropertyFlag()) || Const.DIC_COMP_TYPE_5.toString().equals(String.valueOf(operator.getAttribute("COMP_TYPE")))) {
					if (adminFunDepts.getServiceBuildId()!=null) {
						serviceBuildIds.add(adminFunDepts.getServiceBuildId());
						temp.setBuildId(adminFunDepts.getServiceBuildId());
					}
					propertyDeptIds.add(temp.getDeptId());
				}
			}
        }
		Map<Integer, String> buildNameMap = null;
		if (!serviceBuildIds.isEmpty()) {
			ErpBuildingInfoExample example = new ErpBuildingInfoExample();
			example.setShardCityId(cityId);
			example.createCriteria().andBuildIdIn(serviceBuildIds);
			List<ErpBuildingInfo> buildList = erpBuildingInfoMapper.selectByExample(example);
			buildNameMap = buildList.stream().collect(Collectors.toMap(ErpBuildingInfo::getBuildId, val->val.getBuildName()));
		}
		Map<Integer, Integer> propertyManagerMap = null;
		if (!propertyDeptIds.isEmpty()) {
			ErpFunUsersExample userExample = new ErpFunUsersExample();
			userExample.setShardCityId(cityId);
			userExample.createCriteria().andCompIdEqualTo(compId).andDeptIdIn(propertyDeptIds).andUserWriteoffEqualTo(false).andPropertyManagerEqualTo(Byte.valueOf("1"));
			List<ErpFunUsers> userList = erpFunUsersMapper.selectByExample(userExample);
			propertyManagerMap = userList.stream().collect(Collectors.toMap(ErpFunUsers::getDeptId, val->val.getUserId()));
		}
		for (ErpFunDeptsDto temp : funDeptsDtoList) {
			if (buildNameMap!=null) {
				temp.setBuildName(buildNameMap.get(temp.getBuildId()));
			}
			if (propertyManagerMap!=null) {
				temp.setBuildManager(propertyManagerMap.get(temp.getDeptId()));
			}
		}
		
        funDeptsDtoList.sort((val1, val2) -> {
            if (operator.getDeptId().equals(val1.getDeptId())) {
                return -1;
            } else if (operator.getDeptId().equals(val2.getDeptId())) {
                return 1;
            }
            return Optional.ofNullable(val1.getSeqNo()).orElse(0) - Optional.ofNullable(val2.getSeqNo()).orElse(0);
        });
        //获取未审核的门店
//		AdminAddDeptsApplyExample addDeptsApplyExample=new AdminAddDeptsApplyExample();
//		AdminAddDeptsApplyExample.Criteria criteria = addDeptsApplyExample.createCriteria();
//		criteria.andCompIdEqualTo(compId).andValidityFlagEqualTo((byte) 0);
//		if (regId != null) {
//			criteria.andRegIdEqualTo(regId);
//		}
        //List<AdminAddDeptsApply> adminAddDeptsApplies = adminAddDeptsApplyMapper.selectByExample(addDeptsApplyExample);
	/*	Map<String,Object> result=new HashMap<>();
		result.put("useDeptList",funDeptsDtoList);*/
        //result.put("auditDeptList",adminAddDeptsApplies);
        //List<AdminAddDeptsApply> adminAddDeptsApplies = adminAddDeptsApplyMapper.selectByExample(addDeptsApplyExample);
       // Map<String, Object> result = new HashMap<>();
//		result.put("auditDeptList",adminAddDeptsApplies);
        erpFunDeptsVo.setFunDeptsList(funDeptsDtoList);
        if (countUser == null || countUser != 1) {
            return ErpResponseJson.ok(erpFunDeptsVo);
        }
        // 统计门店人数  dyh
        List<Map<String, Integer>> countDeptUserList = erpFunUsersMapper.countUserByDept(operator.getCityId(), operator.getCompId(), regId,isHeadquarters);
        if (countDeptUserList == null) {
            return ErpResponseJson.ok(erpFunDeptsVo);
        }
        Map<Integer, Map<String, Integer>> countUserMap = countDeptUserList.stream().collect(Collectors.toMap(map -> map.get("deptId"),val -> val));
        funDeptsDtoList.forEach(funDeptsDto -> {
            Map<String, Integer> map = countUserMap.get(funDeptsDto.getDeptId());
            if (map != null) {
                funDeptsDto.setCountUser(map.get("count"));
            } else {
                funDeptsDto.setCountUser(0);
            }
        });

        // FDD门店列表
        String isOpenFdd = operator.getAttribute("IS_OPEN_FDD") + "";
        if(StringUtils.isNotBlank(isOpenFdd) && "1".equals(isOpenFdd)) {
            List<ErpFunDeptsDto> fddAddDeptList = adminAddDeptsApplyMapper.selectDeptApplyList(cityId, operator.getCompNo(), regId);
            funDeptsDtoList.addAll(fddAddDeptList);
        }

        return ErpResponseJson.ok(erpFunDeptsVo);
    }
	
	/**
     * @TODO 组织机构 --根据区域Id 获取分店列表
     * @author lcb
     * @2016-10-18 下午6:23:24
     */
	@ApiOperation("组织机构根据区域Id获取分店列表,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpFunDeptsVo.class, message = "成功")})
    @RequestMapping("/getDeptListByPartnerId")
    @ResponseBody
    public ErpResponseJson getDeptListByPartnerId(@Valid @RequestBody GetPartnerDeptListParam param) throws Exception {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
		Integer countUser = param.getCountUser();
		Integer partnerId = param.getPartnerId();
        ErpFunDeptsVo erpFunDeptsVo = new ErpFunDeptsVo();
        List<ErpFunDeptsDto> funDeptsDtoList = erpFunDeptsMapper.getDeptDtoListByPartnerId(cityId, compId, param.getPartnerId());
        //查询门店验证码
		List<String> deptNoList = funDeptsDtoList.stream().collect(Collectors.mapping(dept -> dept.getDeptNo(), Collectors.toList()));
		Map<String, AdminFunDepts> pwdDescMap =null;
		if (deptNoList.size() > 0) {
			AdminFunDeptsExample adminFunDeptsExample = new AdminFunDeptsExample();
			adminFunDeptsExample.createCriteria().andCompNoEqualTo(operator.getCompNo()).andDeptNoIn(deptNoList);
			List<AdminFunDepts> adminFunDepts = adminFunDeptsMapper.selectByExample(adminFunDeptsExample);
			pwdDescMap = adminFunDepts.stream().collect(Collectors.toMap(dept -> dept.getDeptNo(), dept -> dept));
		}
		List<Integer> propertyDeptIds = new ArrayList<>();
		List<Integer> serviceBuildIds = new ArrayList<>();
		for (ErpFunDeptsDto temp : funDeptsDtoList) {
          /*  ErpFunReg pReg = new ErpFunReg();
            pReg.setRegId(temp.getRegionId());
            pReg.setShardCityId(operator.getCityId());
            ErpFunReg regPO = erpFunRegMapper.selectByPrimaryKey(pReg);
            if (regPO == null) {
                logger.warn("FunReg >>REG_ID:{}为空", temp.getRegionId());
            } else {
                temp.setRegionName(regPO.getRegName());
            }*/
            // 验证码信息
			if (pwdDescMap != null) {
				AdminFunDepts adminFunDepts =  pwdDescMap.get(temp.getDeptNo());
				String pwdDesc = adminFunDepts.getPwdDesc();
				temp.setPwdDesc(pwdDesc);
				temp.setSupportPropertyFlag(adminFunDepts.getSupportPropertyFlag());
				temp.setContactPhone(adminFunDepts.getContactPhone());
				temp.setDeptContact(adminFunDepts.getDeptContact());
				if (Byte.valueOf("1").equals(adminFunDepts.getSupportPropertyFlag()) || Const.DIC_COMP_TYPE_5.toString().equals(String.valueOf(operator.getAttribute("COMP_TYPE")))) {
					if (adminFunDepts.getServiceBuildId()!=null) {
						serviceBuildIds.add(adminFunDepts.getServiceBuildId());
						temp.setBuildId(adminFunDepts.getServiceBuildId());
					}
					propertyDeptIds.add(temp.getDeptId());
				}
			}
        }
		Map<Integer, String> buildNameMap = null;
		if (!serviceBuildIds.isEmpty()) {
			ErpBuildingInfoExample example = new ErpBuildingInfoExample();
			example.setShardCityId(cityId);
			example.createCriteria().andBuildIdIn(serviceBuildIds);
			List<ErpBuildingInfo> buildList = erpBuildingInfoMapper.selectByExample(example);
			buildNameMap = buildList.stream().collect(Collectors.toMap(ErpBuildingInfo::getBuildId, val->val.getBuildName()));
		}
		Map<Integer, Integer> propertyManagerMap = null;
		if (!propertyDeptIds.isEmpty()) {
			ErpFunUsersExample userExample = new ErpFunUsersExample();
			userExample.setShardCityId(cityId);
			userExample.createCriteria().andCompIdEqualTo(compId).andDeptIdIn(propertyDeptIds).andUserWriteoffEqualTo(false).andPropertyManagerEqualTo(Byte.valueOf("1"));
			List<ErpFunUsers> userList = erpFunUsersMapper.selectByExample(userExample);
			propertyManagerMap = userList.stream().collect(Collectors.toMap(ErpFunUsers::getDeptId, val->val.getUserId()));
		}
		for (ErpFunDeptsDto temp : funDeptsDtoList) {
			if (buildNameMap!=null) {
				temp.setBuildName(buildNameMap.get(temp.getBuildId()));
			}
			if (propertyManagerMap!=null) {
				temp.setBuildManager(propertyManagerMap.get(temp.getDeptId()));
			}
		}
		
        funDeptsDtoList.sort((val1, val2) -> {
            if (operator.getDeptId().equals(val1.getDeptId())) {
                return -1;
            } else if (operator.getDeptId().equals(val2.getDeptId())) {
                return 1;
            }
            return Optional.ofNullable(val1.getSeqNo()).orElse(0) - Optional.ofNullable(val2.getSeqNo()).orElse(0);
        });
        //获取未审核的门店
//		AdminAddDeptsApplyExample addDeptsApplyExample=new AdminAddDeptsApplyExample();
//		AdminAddDeptsApplyExample.Criteria criteria = addDeptsApplyExample.createCriteria();
//		criteria.andCompIdEqualTo(compId).andValidityFlagEqualTo((byte) 0);
//		if (regId != null) {
//			criteria.andRegIdEqualTo(regId);
//		}
        //List<AdminAddDeptsApply> adminAddDeptsApplies = adminAddDeptsApplyMapper.selectByExample(addDeptsApplyExample);
	/*	Map<String,Object> result=new HashMap<>();
		result.put("useDeptList",funDeptsDtoList);*/
        //result.put("auditDeptList",adminAddDeptsApplies);
        //List<AdminAddDeptsApply> adminAddDeptsApplies = adminAddDeptsApplyMapper.selectByExample(addDeptsApplyExample);
       // Map<String, Object> result = new HashMap<>();
//		result.put("auditDeptList",adminAddDeptsApplies);
        erpFunDeptsVo.setFunDeptsList(funDeptsDtoList);
        if (countUser == null || countUser != 1) {
            return ErpResponseJson.ok(erpFunDeptsVo);
        }
        // 统计门店人数  dyh
        List<Map<String, Integer>> countDeptUserList = erpFunUsersMapper.countUserByPartnerId(cityId, compId, partnerId);
        if (countDeptUserList == null) {
            return ErpResponseJson.ok(erpFunDeptsVo);
        }
        Map<Integer, Map<String, Integer>> countUserMap = countDeptUserList.stream().collect(Collectors.toMap(map -> map.get("deptId"),val -> val));
        funDeptsDtoList.forEach(funDeptsDto -> {
            Map<String, Integer> map = countUserMap.get(funDeptsDto.getDeptId());
            if (map != null) {
                funDeptsDto.setCountUser(map.get("count"));
            } else {
                funDeptsDto.setCountUser(0);
            }
        });

        /*// FDD门店列表
        String isOpenFdd = operator.getAttribute("IS_OPEN_FDD") + "";
        if(StringUtils.isNotBlank(isOpenFdd) && "1".equals(isOpenFdd)) {
            List<ErpFunDeptsDto> fddAddDeptList = adminAddDeptsApplyMapper.selectDeptApplyList(cityId, operator.getCompNo(), regId);
            funDeptsDtoList.addAll(fddAddDeptList);
        }*/

        return ErpResponseJson.ok(erpFunDeptsVo);
    }
	
	@ApiOperation("导出全员档案")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunUsersVo.class, message = "成功")})
	@PostMapping("/getUserListInfoForExport")
	@ResponseBody
	public ErpResponseJson getUserListInfoForExport(@Valid @RequestBody UserListInfoParam param) {
		param.setIsExport(Byte.valueOf("1"));
		ErpFunUsersVo erpFunUsersVo = this.getUserListInfoCommon(param);
		PageInfo<ErpFunUsersDto> pageInfo = erpFunUsersVo.getList();
		if (null != pageInfo) {
			List<ErpFunUsersDto> funUsersList = pageInfo.getList();
			Set<Integer> archiveIds = funUsersList.stream().map(ErpFunUsersDto::getArchiveId).collect(Collectors.toSet());
			List<Integer> userIds = funUsersList.stream().map(ErpFunUsersDto::getUserId).collect(Collectors.toList());
			List<AdminFunArchive> archiveList = new ArrayList<AdminFunArchive>();
			List<ErpFunUsers> userList = new ArrayList<ErpFunUsers>();
			List<ErpFunEmployeeDoc> employeeDocList = new ArrayList<ErpFunEmployeeDoc>();
			List<ErpFunEmployeeFile> employeeFileList = new ArrayList<ErpFunEmployeeFile>();
			List<ErpFunUserResume> userResumeList = new ArrayList<ErpFunUserResume>();
			
			List<ErpFunReg> regList = erpFunRegMapper.getRegListByCityId(getOperator().getCityId());
			// 取出行政片区数据
			Map<Integer, ErpFunReg> regIdMap = regList.stream().collect(Collectors.toMap(ErpFunReg::getRegId, val -> val, (oldVal, newVal) -> oldVal));
			
			ErpFunAreaExample erpFunAreaExample = new ErpFunAreaExample();
			erpFunAreaExample.setShardCityId(getOperator().getCityId());
			erpFunAreaExample.createCriteria().andCompIdEqualTo(getOperator().getCompId()).andIsDelEqualTo(Byte.valueOf("0"));
			List<ErpFunArea> erpFunAreaList = erpFunAreaMapper.selectByExample(erpFunAreaExample);
			// 取出大区数据
			Map<Integer, ErpFunArea> areaIdMap = erpFunAreaList.stream().collect(Collectors.toMap(ErpFunArea::getAreaId, val -> val, (oldVal, newVal) -> oldVal));
			
			if (archiveIds.size() > 0) {
				archiveList = batchSerachArchiveData(new ArrayList<>(archiveIds));
			}
			
			archiveList.stream().forEach(a -> {
				String serviceReg = a.getServiceReg();
				if (StringUtil.isNotBlank(serviceReg) && null != regIdMap) {
					StringBuilder sb = new StringBuilder();
					if (serviceReg.trim().indexOf(" ") > -1) {
						String[] regIdArr = serviceReg.trim().split(" ");
						Arrays.asList(regIdArr).stream().forEach(b -> {
							Integer regId = StringUtil.paseInteger(b, 0);
							ErpFunReg erpFunReg = regIdMap.get(regId);
							if (null != erpFunReg) {
								sb.append(erpFunReg.getRegName()).append("、");
							}
						});
					} else {
						ErpFunReg erpFunReg = regIdMap.get(StringUtil.paseInteger(serviceReg.trim(), 0));
						if (null != erpFunReg) {
							sb.append(erpFunReg.getRegName()).append("、");
						}
					}
					String regNames = sb.toString();
					if (StringUtil.isNotBlank(regNames)) {
						String regName = regNames.substring(0, regNames.length() - 1);
						a.setServiceReg(regName);
					}
				}
			});
			
			// 取出经纪人基本信息
			Map<Integer, AdminFunArchive> archiveIdMap = archiveList.stream().collect(Collectors.toMap(AdminFunArchive::getArchiveId, val -> val, (oldVal, newVal) -> oldVal));
			if (userIds.size() > 0) {
				userList = batchSerachUserData(getOperator().getCityId(), getOperator().getCompId(), userIds);
			}
			// 取出员工的信息
			Map<Integer, ErpFunUsers> userIdMap = userList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, val -> val, (oldVal, newVal) -> oldVal));
			if (archiveIds.size() > 0) {
				employeeDocList = batchSerachEmployeeDocData(getOperator().getCityId(), getOperator().getCompId(), userIds);
			}
			// 取出员工档案信息
			Map<Integer, ErpFunEmployeeDoc> employeeDocMap = employeeDocList.stream().collect(Collectors.toMap(ErpFunEmployeeDoc::getArchiveId, val -> val, (oldVal, newVal) -> oldVal));
			
			List<Integer> employeeDocIds = employeeDocList.stream().map(ErpFunEmployeeDoc::getId).collect(Collectors.toList());
			if (employeeDocIds.size() > 0) {
				employeeFileList = batchSerachEmployeeFileData(getOperator().getCityId(), getOperator().getCompId(), employeeDocIds);
			}
			// 取出员工的附件信息，key为档案id
			Map<Integer, List<ErpFunEmployeeFile>> employeeFileListMap = employeeFileList.stream().collect(Collectors.groupingBy(ErpFunEmployeeFile :: getEmployeeDocId));
			
			// 查询员工历程信息
			if (archiveIds.size() > 0) {
				userResumeList = batchSerachUserResumeData(getOperator().getCityId(), getOperator().getCompId(), new ArrayList<>(archiveIds));
			}
			List<ErpFunUserResumeDto> userResumeDtoList = new ArrayList<ErpFunUserResumeDto>();
			userResumeList.stream().forEach(a -> {
				ErpFunUserResumeDto erpFunUserResumeDto = new ErpFunUserResumeDto();
				erpFunUserResumeDto.setArchiveId(a.getArchiveId());
				erpFunUserResumeDto.setEventExplain(a.getEventExplain());
				if (null != a.getOccurrenceTime()) {
					erpFunUserResumeDto.setOccurrenceTimeStr(DateTimeHelper.formatDateTimetoString(a.getOccurrenceTime(), DateTimeHelper.FMT_yyyyMMdd_1));
				}
				userResumeDtoList.add(erpFunUserResumeDto);
			});
			
			ErpFunDeptsgroupExample erpFunDeptsgroupExample = new ErpFunDeptsgroupExample();
			erpFunDeptsgroupExample.setShardCityId(getOperator().getCityId());
			erpFunDeptsgroupExample.createCriteria().andCompIdEqualTo(getOperator().getCompId());
			List<ErpFunDeptsgroup> deptsgroupList = erpFunDeptsgroupMapper.selectByExample(erpFunDeptsgroupExample);
			
			// 取出分组的数据
			Map<Integer, ErpFunDeptsgroup> deptsgroupIdMap = deptsgroupList.stream().collect(Collectors.toMap(ErpFunDeptsgroup :: getGrId, val -> val, (oldVal, newVal) -> oldVal));
			
			List<ErpFunRegion> regionList = erpFunRegionMapper.selectByCompId(getOperator().getCityId(), getOperator().getCompId());
			
			// 取出公司片区数据
			Map<Integer, ErpFunRegion> regionIdMap = regionList.stream().collect(Collectors.toMap(ErpFunRegion :: getRegId, val -> val, (oldVal, newVal) -> oldVal));
			
			
			// 组装员工历程信息
			if (!userResumeDtoList.isEmpty()) {
				Map<String, List<ErpFunUserResumeDto>> userResumeDtoListMap = userResumeDtoList.stream().collect(Collectors.groupingBy(a -> String.valueOf(a.getArchiveId())));
				erpFunUsersVo.setResumeMap(userResumeDtoListMap);
			}
			funUsersList.stream().forEach(a -> {
				Integer archiveId = a.getArchiveId();
				Integer userId = a.getUserId();
				if (null != archiveIdMap) {
					AdminFunArchive adminFunArchive = archiveIdMap.get(a.getArchiveId());
					if (null != adminFunArchive) {
						a.setUserAddress(adminFunArchive.getUserAddress());
						a.setUserQq(adminFunArchive.getUserQq());
						a.setUserEmail(adminFunArchive.getUserEmail());
						a.setUserFixedph(adminFunArchive.getUserFixedph());
						a.setUserOfficeph(adminFunArchive.getUserOfficeph());
						a.setUserField(adminFunArchive.getUserField());
						a.setUserSchool(adminFunArchive.getUserSchool());
						a.setUserIccode(adminFunArchive.getUserIccode());
						if (null != adminFunArchive.getUserBirthday()) {
							a.setUserBirthdayStr(DateTimeHelper.formatDateTimetoString(adminFunArchive.getUserBirthday(), DateTimeHelper.FMT_yyyyMMdd_2));
						}
						a.setServiceZone(adminFunArchive.getServiceZone());
						if (StringUtil.isNotBlank(adminFunArchive.getServiceReg()) && !adminFunArchive.getServiceReg().startsWith(" ") && !adminFunArchive.getServiceReg().endsWith(" ")) {
							a.setServiceReg(adminFunArchive.getServiceReg());
						}
						String userPolity = adminFunArchive.getUserPolity();
						if (StringUtil.isNotBlank(userPolity)) {
							if ("1".equals(userPolity)) {
								a.setUserPolity("群众");
							} else if ("2".equals(userPolity)) {
								a.setUserPolity("团员");
							} else if ("3".equals(userPolity)) {
								a.setUserPolity("党员");
							} else if ("4".equals(userPolity)) {
								a.setUserPolity("其它");
							}
						}
					}
				}
				if (null != userIdMap) {
					ErpFunUsers erpFunUsers = userIdMap.get(userId);
					if (null != erpFunUsers) {
						a.setRecruitmentChannel(erpFunUsers.getRecruitmentChannel());
						a.setPersonnelLevels(erpFunUsers.getPersonnelLevels());
						if (null != regionIdMap && null != erpFunUsers.getRegId()) {
							ErpFunRegion erpFunRegion = regionIdMap.get(erpFunUsers.getRegId());
							if (null != erpFunRegion) {
								a.setRegName(erpFunRegion.getRegName());
							}
						}
						if (null != deptsgroupIdMap && null != erpFunUsers.getGrId()) {
							ErpFunDeptsgroup erpFunDeptsgroup = deptsgroupIdMap.get(erpFunUsers.getGrId());
							if (null != erpFunDeptsgroup) {
								a.setGrName(erpFunDeptsgroup.getGrName());
							}
						}
						if (null != erpFunUsers.getUserSex()) {
							a.setUserSexStr(erpFunUsers.getUserSex() ? "男" : "女");
						}
					}
				}
				
				if (null != areaIdMap) {
					ErpFunArea erpFunArea = areaIdMap.get(a.getAreaId());
					if (null != erpFunArea) {
						a.setAreaName(erpFunArea.getAreaName());
					}
				}
				
				// 是否有身份证附件
				boolean hasIdCardAttachment = false;
				// 是否有学历证书附件
				boolean hasEducationAttachment = false;
				// 是否有荣誉证书附件
				boolean hasHonorAttachment = false;
				// 是否有档案附件
				boolean hasArchiveAttachment = false;
				// 是否有其他附件
				boolean hasOtherAttachment = false;
				
				if (null != employeeDocMap) {
					ErpFunEmployeeDoc erpFunEmployeeDoc = employeeDocMap.get(archiveId);
					if (null != erpFunEmployeeDoc) {
						Integer id = erpFunEmployeeDoc.getId();
						if (null != employeeFileListMap) {
							List<ErpFunEmployeeFile> userFileList = employeeFileListMap.get(id);
							if (null != userFileList) {
								for (ErpFunEmployeeFile file : userFileList) {
									// 文件类型，1=身份证 2=学历证书 3=荣誉证书 4=档案资料 5=其他资料
									Byte fileType = file.getFileType();
									if (Byte.valueOf("1").equals(fileType)) {
										hasIdCardAttachment = true;
									}
									if (Byte.valueOf("2").equals(fileType)) {
										hasEducationAttachment = true;
									}
									if (Byte.valueOf("3").equals(fileType)) {
										hasHonorAttachment = true;
									}
									if (Byte.valueOf("4").equals(fileType)) {
										hasArchiveAttachment = true;
									}
									if (Byte.valueOf("5").equals(fileType)) {
										hasOtherAttachment = true;
									}
								}
							}
						}
						a.setRemarkInfo(erpFunEmployeeDoc.getRemarkInfo());
						a.setChannelDescription(erpFunEmployeeDoc.getChannelDescription());
						a.setBankAccount(erpFunEmployeeDoc.getBankAccount());
						a.setSocialSecurityAccount(erpFunEmployeeDoc.getSocialSecurityAccount());
						if (null != erpFunEmployeeDoc.getGraduationTime()) {
							a.setGraduationTimeStr(DateTimeHelper.formatDateTimetoString(erpFunEmployeeDoc.getGraduationTime(), DateTimeHelper.FMT_yyyyMMdd_2));
						}
						String userSchlrecord = erpFunEmployeeDoc.getUserSchlrecord();
						if (StringUtil.isNotBlank(userSchlrecord)) {
							if ("1".equals(userSchlrecord)) {
								a.setUserSchlrecord("初中");
							} else if ("2".equals(userSchlrecord)) {
								a.setUserSchlrecord("高中");
							} else if ("3".equals(userSchlrecord)) {
								a.setUserSchlrecord("中职");
							} else if ("4".equals(userSchlrecord)) {
								a.setUserSchlrecord("大专");
							} else if ("5".equals(userSchlrecord)) {
								a.setUserSchlrecord("本科");
							} else if ("6".equals(userSchlrecord)) {
								a.setUserSchlrecord("硕士");
							} else if ("7".equals(userSchlrecord)) {
								a.setUserSchlrecord("博士");
							}
						}
						Byte maritalStatus = erpFunEmployeeDoc.getMaritalStatus();
						if (null != maritalStatus) {// 婚姻状况 0= 未婚   1= 已婚 2：丧偶 3：离异
							if (Byte.valueOf("0").equals(maritalStatus)) {
								a.setMaritalStatus("未婚");
							} else if (Byte.valueOf("1").equals(maritalStatus)) {
								a.setMaritalStatus("已婚");
							} else if (Byte.valueOf("2").equals(maritalStatus)) {
								a.setMaritalStatus("丧偶");
							} else if (Byte.valueOf("3").equals(maritalStatus)) {
								a.setMaritalStatus("离异");
							}
						}
						a.setPlaceOfOrigin(erpFunEmployeeDoc.getPlaceOfOrigin());
						a.setNation(erpFunEmployeeDoc.getNation());
						if (null != erpFunEmployeeDoc.getWriteoffTime()) {
							a.setWriteoffTime(DateTimeHelper.formatDateTimetoString(erpFunEmployeeDoc.getWriteoffTime(), DateTimeHelper.FMT_yyyyMMdd_2));
						}
						if (null != erpFunEmployeeDoc.getUserJobDate()) {
							a.setUserJobDateStr(DateTimeHelper.formatDateTimetoString(erpFunEmployeeDoc.getUserJobDate(), DateTimeHelper.FMT_yyyyMMdd_2));
						}
					}
				}
				a.setIdCardAttachment(hasIdCardAttachment ? "已上传" : "未上传");
				a.setEducationAttachment(hasEducationAttachment ? "已上传" : "未上传");
				a.setHonorAttachment(hasHonorAttachment ? "已上传" : "未上传");
				a.setArchiveAttachment(hasArchiveAttachment ? "已上传" : "未上传");
				a.setOtherAttachment(hasOtherAttachment ? "已上传" : "未上传");
			});
			PageInfo<ErpFunUsersDto> usersDtoPageInfo = new PageInfo<>(funUsersList);
			usersDtoPageInfo.setList(funUsersList);
			erpFunUsersVo.setList(usersDtoPageInfo);
		}
		return ErpResponseJson.ok(erpFunUsersVo);
	}
	
	/**
	 * 分批次查询经纪人信息数据
	 */
	private List<AdminFunArchive>  batchSerachArchiveData(List<Integer> idList) {
		int batchDataCount = 1000;
		int remainingDataCount = idList.size();
		if (!idList.isEmpty()) {
			List<AdminFunArchive> archiveList = new ArrayList<AdminFunArchive>();
			for (int i = 0; i < idList.size(); i = i + batchDataCount) {
				if (remainingDataCount < batchDataCount) {
					batchDataCount = remainingDataCount;
				}
				List<Integer> serachTargetList = idList.subList(i, i + batchDataCount);
				List<AdminFunArchive> archiveListTemp = adminFunArchiveMapper.getArchiveInfosByIds(serachTargetList);
				archiveList.addAll(archiveListTemp);
				remainingDataCount = remainingDataCount - batchDataCount;
			}
			return archiveList;
		}
		return Collections.emptyList();
	}
	
	/**
	 * 分批次查询用户信息数据
	 */
	private List<ErpFunUsers> batchSerachUserData(Integer cityId, Integer compId, List<Integer> idList) {
		int batchDataCount = 1000;
		int remainingDataCount = idList.size();
		if (!idList.isEmpty()) {
			List<ErpFunUsers> userList = new ArrayList<ErpFunUsers>();
			for (int i = 0; i < idList.size(); i = i + batchDataCount) {
				if (remainingDataCount < batchDataCount) {
					batchDataCount = remainingDataCount;
				}
				List<Integer> serachTargetList = idList.subList(i, i + batchDataCount);
				ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
				erpFunUsersExample.setShardCityId(cityId);
				erpFunUsersExample.createCriteria().andCompIdEqualTo(compId).andUserIdIn(serachTargetList);
				List<ErpFunUsers> userListTemp = erpFunUsersMapper.selectByExample(erpFunUsersExample);
				userList.addAll(userListTemp);
				remainingDataCount = remainingDataCount - batchDataCount;
			}
			return userList;
		}
		return Collections.emptyList();
	}
	
	/**
	 * 分批次查询员工档案数据
	 */
	private List<ErpFunEmployeeDoc> batchSerachEmployeeDocData(Integer cityId, Integer compId, List<Integer> idList) {
		int batchDataCount = 1000;
		int remainingDataCount = idList.size();
		if (!idList.isEmpty()) {
			List<ErpFunEmployeeDoc> employeeDocList = new ArrayList<ErpFunEmployeeDoc>();
			for (int i = 0; i < idList.size(); i = i + batchDataCount) {
				if (remainingDataCount < batchDataCount) {
					batchDataCount = remainingDataCount;
				}
				List<Integer> serachTargetList = idList.subList(i, i + batchDataCount);
				List<ErpFunEmployeeDoc> employeeDocListTemp = erpFunEmployeeDocMapper.getEmployeeDocByUserIds(cityId, compId, serachTargetList);
				employeeDocList.addAll(employeeDocListTemp);
				remainingDataCount = remainingDataCount - batchDataCount;
			}
			return employeeDocList;
		}
		return Collections.emptyList();
	}
	
	/**
	 * 分批次查询员工文件附件数据
	 */
	private List<ErpFunEmployeeFile> batchSerachEmployeeFileData(Integer cityId, Integer compId, List<Integer> idList) {
		int batchDataCount = 1000;
		int remainingDataCount = idList.size();
		if (!idList.isEmpty()) {
			List<ErpFunEmployeeFile> employeeFileList = new ArrayList<ErpFunEmployeeFile>();
			for (int i = 0; i < idList.size(); i = i + batchDataCount) {
				if (remainingDataCount < batchDataCount) {
					batchDataCount = remainingDataCount;
				}
				List<Integer> serachTargetList = idList.subList(i, i + batchDataCount);
				ErpFunEmployeeFileExample erpFunEmployeeFileExample = new ErpFunEmployeeFileExample();
				erpFunEmployeeFileExample.setShardCityId(cityId);
				erpFunEmployeeFileExample.createCriteria().andCompIdEqualTo(compId).andFileStatusEqualTo(Byte.valueOf("0")).andEmployeeDocIdIn(serachTargetList);
				List<ErpFunEmployeeFile> employeeFileListTemp = erpFunEmployeeFileMapper.selectByExample(erpFunEmployeeFileExample);
				employeeFileList.addAll(employeeFileListTemp);
				remainingDataCount = remainingDataCount - batchDataCount;
			}
			return employeeFileList;
		}
		return Collections.emptyList();
	}
	
	
	/**
	 * 分批次查询员工历程数据
	 */
	private List<ErpFunUserResume> batchSerachUserResumeData(Integer cityId, Integer compId, List<Integer> idList) {
		int batchDataCount = 1000;
		int remainingDataCount = idList.size();
		if (!idList.isEmpty()) {
			List<ErpFunUserResume> userResumeList = new ArrayList<ErpFunUserResume>();
			for (int i = 0; i < idList.size(); i = i + batchDataCount) {
				if (remainingDataCount < batchDataCount) {
					batchDataCount = remainingDataCount;
				}
				List<Integer> serachTargetList = idList.subList(i, i + batchDataCount);
				List<ErpFunUserResume> userResumeListTemp = erpFunUserResumeMapper.getUserResumeListByIds(cityId, compId, serachTargetList);
				userResumeList.addAll(userResumeListTemp);
				remainingDataCount = remainingDataCount - batchDataCount;
			}
			return userResumeList;
		}
		return Collections.emptyList();
	}
	
	/**
	 * 获取员工档案信息或者导出员工档案信息
	 * @param param
	 * @return
	 */
	public ErpFunUsersVo getUserListInfoCommon(UserListInfoParam param) {
		Operator operator = getOperator();
		boolean newOrganization = operator.newOrganizationType();
		//门店是否是总部的标志 1是
		Byte isHeadquarters = null;
        Integer cityId=operator.getCityId();
		Integer compId = operator.getCompId();
		Integer grId = param.getGrId();
		grId = grId == null ? 0 : grId;
		Integer deptId = param.getDeptId();
		String keyWord = param.getKeyWord();
		String roleId = param.getRoleId();
		Integer teamUserFlag = param.getTeamUserFlag();
		String notInviteRole = param.getNotInviteRole();//无推荐人
		Integer isNeedOpers = param.getIsNeedOpers();
		Integer isNeedUserLog = param.getIsNeedUserLog();
		Integer isNeedRoleAndDeptName = param.getIsNeedRoleAndDeptName();
		Integer userWriteoff = param.getUserWriteoff();
		Integer allUsersFlag = param.getAllUsersFlag(); // 全员档案的标记
		allUsersFlag = allUsersFlag == null ? 0 : allUsersFlag;
		// 帐号状态，DD:USER_STATUS 3=冻结
		Integer sortType = param.getSortType(); // 1=按姓名2=按角色3=按入职时间4=按离职时间5=按员工状态
		String orderBy = param.getOrderBy(); // 排序方式,DESC降序,ASC升序
		String headCharacter = param.getHeadCharacter(); // 首字母，传对应的字母，#就传#
		if(StringUtil.isNotBlank(headCharacter)){
			if(ValidationUtil.isEnglish(headCharacter)){
				headCharacter+="%";
			} else {
				headCharacter = "[^A-Z]%";
			}
		}
		// 查询用户列表/
		List<ErpFunUsersDto> tempList ;
		ErpFunUsers condition = new ErpFunUsers();
		
		if (newOrganization && null != param.getCompId() && param.getCompId() > 0) {// 跨城需要查询其他公司的人员信息，所以需要重置compId
			compId = param.getCompId();
		}
		param.setCompId(compId);
		condition.setCompId(compId);
		param.setNewOrganization(operator.newOrganizationType());
		if (!newOrganization) {
			// 旧组织架构才有
			condition.setAreaId(param.getAreaId());
			condition.setRegId(param.getRegId());
			condition.setDeptId(deptId);
			if (grId > 0) {
				condition.setGrId(grId);
			}
		} else {
			Integer organizationId = param.getOrganizationId();
			if(null != organizationId && organizationId > 0) {
				condition.setOrganizationId(organizationId);
			}
		}
		//根据角色查询条件
		if(StringUtils.isNotBlank(roleId)){
			condition.setUserPosition(roleId);
		}
		//只根据用户名筛选
		if (StringUtils.isNotBlank(keyWord)) {
			condition.setUserName(keyWord);
		}

		//如果门店为空的话，可能是大区或者片区去查询门店，此时需要剔除门店是总部的人
		if (null == deptId && grId == 0 && allUsersFlag == 0) {
			isHeadquarters = 0;
		}
		if(null == userWriteoff || userWriteoff == 0){
			condition.setUserWriteoff(false);
		} else if ((null != sortType && sortType == 4) || Objects.equals(1, userWriteoff)){
			condition.setUserWriteoff(true);
		}
		// 加个逻辑是大圆说的：提升用户体验感
		if(null != sortType && sortType == 5 && !condition.getUserWriteoff()){
			ErpFunUsersExample example = new ErpFunUsersExample();
			ErpFunUsersExample.Criteria criteria = example.createCriteria();
			criteria.andCompIdEqualTo(compId).andUserWriteoffEqualTo(false).andUserStatusEqualTo((byte)3);
			if(null != param.getAreaId()){
				criteria.andAreaIdEqualTo(param.getAreaId());
			}
			if(null != param.getRegId()){
				criteria.andRegIdEqualTo(param.getRegId());
			}
			if(null != param.getDeptId()){
				criteria.andDeptIdEqualTo(param.getDeptId());
			}
			if(null != param.getGrId()){
				criteria.andGrIdEqualTo(param.getGrId());
			}
			if(StringUtil.isNotBlank(headCharacter)){
				criteria.andUserCodeLike(headCharacter);
			}
			example.setShardCityId(cityId);
			int count = erpFunUsersMapper.countByExample(example);
			if(count == 0){
				orderBy = "DESC";
			}
		}
		if(StringUtil.isBlank(orderBy) && allUsersFlag == 1){
			orderBy = "DESC";
		}
		//查询某员工部门所有人
		Integer userLevel = null;
		if(null != param.getTeamUserFlag() && 1 == param.getTeamUserFlag()){
			ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, param.getUserId());
			if(null != erpFunUsers){
				userLevel = erpFunUsers.getUserLevel() + 2;
			}
		}
		if (!Byte.valueOf("1").equals(param.getIsExport())) {
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		}
		tempList = erpFunUsersMapper.getFunUsersDtoList(operator.getCityId(), condition, sortType, orderBy, headCharacter, isHeadquarters, allUsersFlag, notInviteRole, teamUserFlag, userLevel, param.getUserId());
		ErpFunUsersVo erpFunUsersVo = new ErpFunUsersVo();
		//查询在职离职员工数量
		Map<String, Integer> serviceSeparations = erpFunUsersMapper.getObtainingTheNumberOfInServiceSeparations(cityId, compId, headCharacter, keyWord);
		Map<String, Integer> separations = erpFunUsersMapper.getObtainingTheNumberOfInServiceSeparations(cityId, compId, null, null);
		if(null == userWriteoff || userWriteoff == 0){
			if(serviceSeparations!=null){
				erpFunUsersVo.setNumberOfEmployees(serviceSeparations.get("working"));
			}else {
				erpFunUsersVo.setNumberOfEmployees(0);
			}
			if(separations!=null){
				erpFunUsersVo.setNumberOfEmployeesLeft(separations.get("leave"));
			}else {
				erpFunUsersVo.setNumberOfEmployeesLeft(0);
			}
		}else {
			if(serviceSeparations!=null){
				erpFunUsersVo.setNumberOfEmployeesLeft(serviceSeparations.get("leave"));
			}else {
				erpFunUsersVo.setNumberOfEmployeesLeft(0);
			}
			if(separations!=null){
				erpFunUsersVo.setNumberOfEmployees(separations.get("working"));
			}else {
				erpFunUsersVo.setNumberOfEmployees(0);
			}
		}
		if (tempList == null || tempList.isEmpty()) {
			return erpFunUsersVo;
		}
		List<ErpFunUsersDto> list = new ArrayList<>();
		Set<Integer> archiveIds = tempList.stream().map(ErpFunUsersDto::getArchiveId).collect(Collectors.toSet());
		Set<Integer> userIds = tempList.stream().map(ErpFunUsersDto::getUserId).collect(Collectors.toSet());
		List<AdminFunArchive> archiveList = new ArrayList<>();
		if (archiveIds.size() > 0) {
//			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
			archiveList = adminFunArchiveMapper.getArchiveInfosByIds(new ArrayList<>(archiveIds));
		}
		Map<Integer, AdminFunArchive> archiveIdMap = archiveList.stream().collect(Collectors.toMap(AdminFunArchive::getArchiveId, val -> val));
		//员工异动
		Map<Integer, ErpFunEmployeeLog> employeeLogMap = null;
		if (archiveIds.size() > 0 && (isNeedUserLog == null || isNeedUserLog != 0)) {
			List<ErpFunEmployeeLog> erpFunEmployeeLogs = erpFunEmployeeLogMapper.selectFunEmployeeLogByArchiveIds(operator.getCityId(), compId, new ArrayList<>(archiveIds));
			if (erpFunEmployeeLogs!=null&&erpFunEmployeeLogs.size()>0){
				employeeLogMap = erpFunEmployeeLogs.stream().collect(Collectors.toMap(ErpFunEmployeeLog::getArchiveId, val -> val));
			}
		}
		//管理范围
		List<ErpFunUserManageRange> manageRanges = new ArrayList<>();
		if (userIds.size() > 0) {
			manageRanges = erpFunUserManageRangeMapper.getListByUserId(operator.getCityId(), compId, userIds, null);
		}
		Map<Integer, String> rangeIdMap = manageRanges.stream().collect(Collectors.toMap(val -> val.getUserId(),
				val -> val.getRangeId() + "", (val1, val2) -> val1 + "," + val2));
		Map<Integer, Integer> rangeTypeMap = new HashMap<>();
		if(!newOrganization) {
			rangeTypeMap = manageRanges.stream().collect(Collectors.toMap(val -> val.getUserId(),
					val -> val.getRangeType(), (val1, val2) -> val2));
		}

		//权限
		Map<String, ErpSysPara> sysParaMap=new HashMap<>();
		Map<String, List<ErpCompRoleOpers>> compRoleOpersMapByRoleId = new HashMap<>();
		List<ErpCompRoleOpers> compRoleOpersList = new ArrayList<ErpCompRoleOpers>();
		List<ErpFunOpers> opersList = new ArrayList<>();
		if (!Byte.valueOf("1").equals(param.getIsExport())) {
			if (isNeedOpers != null && isNeedOpers == 1) {
				opersList = erpFunOpersMapper.getOpersList(cityId);
				List<ErpSysPara> sysParaList = erpSysParaMapper.selectSysParaByCompId(cityId, compId);
				sysParaMap = sysParaList.stream().collect(Collectors.toMap(ErpSysPara::getParamId, val -> val));
				ErpCompRoleOpersExample example = new ErpCompRoleOpersExample();
				example.setShardCityId(cityId);
				example.createCriteria().andCompIdEqualTo(compId);
				compRoleOpersList = erpCompRoleOpersMapper.selectByExample(example);
				if(compRoleOpersList.size() > 0) {
					compRoleOpersMapByRoleId = compRoleOpersList.stream().collect(Collectors.groupingBy(ErpCompRoleOpers::getRoleId));
				}
			}
		}
        //角色和门店名称
		Map<String, ErpCompRoles> compRolesMap = null;
		Map<Integer, ErpFunDepts> funDeptsMap = null;

		//职级对应的集合
		Map<Integer, ErpFunRoleLevels> erpRoleLevelMap = null;
		
		ErpFunRoleLevelsExample roleLevelExample = new ErpFunRoleLevelsExample();
		roleLevelExample.setShardCityId(cityId);
		roleLevelExample.createCriteria().andCompIdEqualTo(compId).andRoleLevelStatusEqualTo((byte)1);
		List<ErpFunRoleLevels> roleLevelList = erpFunRoleLevelsMapper.selectByExample(roleLevelExample);
		if(roleLevelList != null && !roleLevelList.isEmpty()){
			erpRoleLevelMap = roleLevelList.stream().collect(Collectors.toMap(roleLevel -> roleLevel.getRoleLevelId(), roleLevel -> roleLevel));
		}
		
		if ((isNeedRoleAndDeptName != null && isNeedRoleAndDeptName == 1 ) || null != sortType) {
			compRolesMap = this.getUserRoleListMap(cityId,compId,tempList);
			//门店
			funDeptsMap = this.getUserDeptListMap(cityId,compId,tempList);
		}
		
		// story#11536 PC跨城管理-查询人员的组织信息
		Map<Integer, UserOrganizationInfoVO> userOrganizationInfoMap = null;
		if (!userIds.isEmpty()) {
			userOrganizationInfoMap = erpFunUsersService.getUserOrganizationInfoByUserIds(cityId, new ArrayList<Integer>(userIds));
		}
		
		List<ErpFunUsersDto> sublist = new ArrayList<>();

		for (ErpFunUsersDto funUsersDto : tempList) {
			AdminFunArchive funArchivePO = archiveIdMap.get(funUsersDto.getArchiveId());// 不判空，如果报错直接反馈客户
			if(null == funArchivePO){
				continue;
			}
			funUsersDto.setUserPhoto(CommonUtil.getPhotoUrl(funUsersDto.getUserPhoto()));
			funUsersDto.setUserPhotoMin(CommonUtil.getPhotoUrl(funArchivePO.getUserPhotoMin()));
			funUsersDto.setUserRight(funArchivePO.getUserRight());
			funUsersDto.setUserHonest(funArchivePO.getUserHonest());
			funUsersDto.setMobileValided(funArchivePO.getMobileValided());
			funUsersDto.setFaceRecognitionFlag(funArchivePO.getFaceRecognitionFlag());
			funUsersDto.setUserArchivePhoto(CommonUtil.getPhotoUrl(funArchivePO.getUserPhoto()));
			if (employeeLogMap != null) {
				ErpFunEmployeeLog funEmployeeLog = employeeLogMap.get(funUsersDto.getArchiveId());
				if (null != funEmployeeLog) {
					funUsersDto.setUserLastContent(DateTimeHelper.formatDatetoString(funEmployeeLog.getCreationTime()) + funEmployeeLog.getContent());
				}
			}
			
			if (null != userOrganizationInfoMap) {
				UserOrganizationInfoVO userOrganizationInfoVO = userOrganizationInfoMap.get(funUsersDto.getUserId());
				if (null != userOrganizationInfoVO) {
					funUsersDto.setOrganizationId(userOrganizationInfoVO.getOrganizationId());
					funUsersDto.setOrganizationName(userOrganizationInfoVO.getOrganizationName());
					funUsersDto.setCompName(userOrganizationInfoVO.getCompName());
					funUsersDto.setErpCompName(userOrganizationInfoVO.getCompName());
				}
			}

			// 加上管理范围的信息，网站部需要，这里做兼容
			Integer range = rangeTypeMap.get(funUsersDto.getUserId());
			funUsersDto.setRangeType(range);
			String rangeIds = rangeIdMap.get(funUsersDto.getUserId());
			funUsersDto.setRangeIds(rangeIds);
			if (!Byte.valueOf("1").equals(param.getIsExport())) {
				if (isNeedOpers != null && isNeedOpers == 1) {
					List<ErpCompRoleOpers> erpCompRoleOpers = compRoleOpersMapByRoleId.get(funUsersDto.getUserPosition());
	               if(newOrganization) {
					   this.userOpersProcessNewOrg(funUsersDto, sysParaMap, erpCompRoleOpers, opersList);
				   }else {
	
					   this.userOpersProcess(funUsersDto, sysParaMap, erpCompRoleOpers, opersList);
				   }
				}
			}
			//加上门店和角色名称
			if (compRolesMap != null) {
				ErpCompRoles compRoles = compRolesMap.get(funUsersDto.getUserPosition());
				if (compRoles != null) {
					funUsersDto.setRoleName(compRoles.getRoleName());
				}
			}
			//加上职级名称
			if (erpRoleLevelMap != null && funUsersDto.getRoleLevelId() != null) {
				ErpFunRoleLevels roleLevelPo = erpRoleLevelMap.get(funUsersDto.getRoleLevelId());
				if (roleLevelPo != null) {
					funUsersDto.setRoleLevelName(roleLevelPo.getRoleLevelName());
				}
			}
			if (funDeptsMap != null) {
				ErpFunDepts funDepts = funDeptsMap.get(funUsersDto.getDeptId());
				if (funDepts != null) {
					funUsersDto.setDeptName(funDepts.getDeptName());
				}
			}
			// 自己显示在第一个
			if (funUsersDto.getUserId().equals(operator.getUserId()) && null == sortType && StringUtil.isBlank(headCharacter) && allUsersFlag == 0) {
				list.add(0, funUsersDto);
			} else {
				if(StringUtil.isNotBlank(funUsersDto.getUserCode()) && funUsersDto.getUserCode().length() >= 1 && ValidationUtil.isEnglish(funUsersDto.getUserCode().substring(0,1))){
					list.add(funUsersDto);
				} else {
					sublist.add(funUsersDto);
				}
			}
		}
		list.addAll(sublist);
		// 员工调店会新增一条离职信息
//		if (null != condition.getUserWriteoff() && condition.getUserWriteoff() && archiveIds.size() > 0) {
//			ErpFunUsersExample example = new ErpFunUsersExample();
//			example.createCriteria().andCompIdEqualTo(compId).andArchiveIdIn(new ArrayList<>(archiveIds));
//			example.setShardCityId(cityId);
//			List<ErpFunUsers> userList = erpFunUsersMapper.selectByExample(example);
//			if (null != userList && !userList.isEmpty()) {
//				List<Integer> docUserIds = userList.stream() .collect(Collectors.mapping(ErpFunUsers::getUserId, Collectors.toList()));
//				List<ErpFunEmployeeDoc> docList = erpFunEmployeeDocMapper.getEmployeeDocByUserIds(cityId, compId, docUserIds);
//				Map<Integer, ErpFunEmployeeDoc> docMap = new HashMap<>();
//				if (null != docList && docList.size() > 0) {
//					docMap = docList.stream().collect(Collectors.toMap(ErpFunEmployeeDoc::getUserId, val -> val));
//				}
//				for (int i = list.size() - 1; i >= 0; i--) {
//					ErpFunUsersDto erpFunUsersDto = list.get(i);
//					ErpFunEmployeeDoc erpFunEmployeeDoc = docMap.get(erpFunUsersDto.getUserId());
//					if (null == erpFunEmployeeDoc) {
//						list.remove(i);
//					}
//				}
//			}
//		}
		PageInfo<ErpFunUsersDto> pageInfo = new PageInfo<>(tempList);
		pageInfo.setList(list);
		erpFunUsersVo.setList(pageInfo);
		return erpFunUsersVo;
	}

	/**
	 * @TODO 获取用户列表
	 * @author lcb
	 * @2016-10-18 下午6:23:24
	 */
	@ApiOperation("获取员工列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunUsersVo.class, message = "成功")
	})
	@PostMapping("/getUserListInfo")
	@ResponseBody
	public ErpResponseJson getUserInfoList(@Valid @RequestBody UserListInfoParam param) {
		param.setIsExport(Byte.valueOf("0"));
		return ErpResponseJson.ok(this.getUserListInfoCommon(param));
	}

	/**
	 * @TODO 获取离职用户列表
	 * @author lcb
	 * @2016-10-18 下午6:23:24
	 */
	@ApiOperation("获取离职用户列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunUsersVo.class, message = "成功")
	})
	@PostMapping("/getWriteoffUserListInfo")
	@ResponseBody
	public ErpResponseJson getWriteoffUserListInfo(@Valid @RequestBody WriteoffUserListInfoParam param) {
		return ErpResponseJson.ok(this.getWriteoffUserCommon(param));
	}

	private List<WriteoffUserListVO> getWriteoffUserCommon(WriteoffUserListInfoParam param){
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		//1、按离职时间倒序排列；
		//2、离职人员后面增加工号、当时所在组织、**年**月**日离职，例如：张三（19.2.5离职-编号-组织）；
		Date date = DateUtil.addMonth(new Date(), -param.getMonth());
		List<WriteoffUserListVO> writeoffUserListVOS = erpFunUsersMapper.selectWriteoffUserList(cityId,compId,date);
		return writeoffUserListVOS;
	}

    private Map<Integer, ErpFunDepts> getUserDeptListMap(Integer cityId, Integer compId, List<ErpFunUsersDto> tempList) {
        Set<Integer> deptIds = tempList.stream().collect(Collectors.mapping(user -> user.getDeptId(), Collectors.toSet()));
        ErpFunDeptsExample erpFunDeptsExample = new ErpFunDeptsExample();
        erpFunDeptsExample.setShardCityId(cityId);
        erpFunDeptsExample.createCriteria().andCompIdEqualTo(compId).andDeptIdIn(new ArrayList<>(deptIds));
        List<ErpFunDepts> deptsList = erpFunDeptsMapper.selectByExample(erpFunDeptsExample);
        return deptsList.stream().collect(Collectors.toMap(dept -> dept.getDeptId(), dept -> dept));
    }

    private Map<String, ErpCompRoles> getUserRoleListMap(Integer cityId, Integer compId, List<ErpFunUsersDto> tempList) {
        Set<String> userPositions = tempList.stream().collect(Collectors.mapping(user -> user.getUserPosition(), Collectors.toSet()));
        ErpCompRolesExample erpCompRolesExample = new ErpCompRolesExample();
        erpCompRolesExample.setShardCityId(cityId);
        erpCompRolesExample.createCriteria().andCompIdEqualTo(compId).andRoleIdIn(new ArrayList<>(userPositions));
        List<ErpCompRoles> rolesList = erpCompRolesMapper.selectByExample(erpCompRolesExample);
        return rolesList.stream().collect(Collectors.toMap(role -> role.getRoleId(), role -> role));
    }

    /**
     * @tag 权限列表处理
     * @author 邓永洪
     * @since 2018/8/8
     */
    private void userOpersProcess(ErpFunUsersDto user, Map<String, ErpSysPara> sysParaMap, List<ErpCompRoleOpers> erpCompRoleOpers, List<ErpFunOpers> opersList) {
        if (null == erpCompRoleOpers) {
            erpCompRoleOpers = new ArrayList<>();
        }

        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        String userPosition = user.getUserPosition();
        Integer userId = user.getUserId();
		boolean isGeneralManager = "GENERAL_MANAGER".equals(userPosition); //总经理都是基本权限
		List<ErpUserOpersDto> userOpers = erpUserOpersMapper.getUsersOpers(cityId,userId);
		
		Map<String, String> operNameMap = opersList.stream().collect(Collectors.toMap(oper -> oper.getOperId(), oper -> oper.getOperName()));
		Map<String, Integer> operTypeMap =new HashMap<>();
		if (!isGeneralManager) {
			if (erpCompRoleOpers != null) {
				operTypeMap = erpCompRoleOpers.stream().collect(Collectors.toMap(oper -> oper.getOperId(), oper -> oper.getOperType(), (oper, oper2) -> oper));
			}
		}
		for (ErpUserOpersDto opersDto : userOpers) {
			String operId = opersDto.getOperId();

			opersDto.setOperName(operNameMap.get(operId));
			if (!isGeneralManager){
				opersDto.setOperType(operTypeMap.get(operId) + "");
			}else {
				opersDto.setOperType("0");
			}
		}
		
        Set<String> hiddenOperIds = new HashSet<>();
        //  移除隐藏权限
        hiddenOperIds.addAll(userOpersControlller.getNeedHiddenOper(cityId, compId, userPosition, sysParaMap, operator.newOrganizationType()));
        hiddenOperIds.addAll(userOpersControlller.needHiddenOpersByCustomized(sysParaMap));

        List<ErpFunOpers> baseOperList = new ArrayList<>();
        List<ErpFunOpers> advanceOperList = new ArrayList<>();
        //总经理只有基本权限
        if ("GENERAL_MANAGER".equals(userPosition)) {
            Set<String> roleOpersIds = erpCompRoleOpers.stream().collect(Collectors.mapping(val -> val.getOperId(), Collectors.toSet()));
            Set<String> operIds = userOpers.stream().collect(Collectors.mapping(val -> val.getOperId(), Collectors.toSet()));
            this.removeHiddenOpers(roleOpersIds, hiddenOperIds);
            this.removeHiddenOpers(operIds, hiddenOperIds);
            List<String> baseOperIds = new ArrayList<>();
            for (String operId : roleOpersIds) {
                if (!operIds.contains(operId)) {
                    baseOperIds.add(operId);
                }
            }
            if (baseOperIds.size() > 0) {
                ErpFunOpersExample opersExample = new ErpFunOpersExample();
                opersExample.setShardCityId(getOperator().getCityId());
                ErpFunOpersExample.Criteria criteria = opersExample.createCriteria();
                criteria.andOperIdIn(baseOperIds);
                baseOperList = erpFunOpersMapper.selectByExample(opersExample);
            }
            user.setAdvanceOperList(advanceOperList);
            user.setBaseOperList(baseOperList);
            return;
        }

        //获取角色里的 普通权限
        Set<String> roleBaseOpersSet = erpCompRoleOpers.stream().filter(val -> 0 == val.getOperType())
                .collect(Collectors.mapping(val -> val.getOperId(), Collectors.toSet()));
        this.removeHiddenOpers(roleBaseOpersSet, hiddenOperIds);
        // 获取user 已有的普通和高于默认的高级权限
        //operType=null 表示该角色没有此权限
        Set<String> advanceOperIds = userOpers.stream().filter(val -> "1".equals(val.getOperType()))
                .collect(Collectors.mapping(val -> val.getOperId(), Collectors.toSet()));
        this.removeHiddenOpers(advanceOperIds, hiddenOperIds);

        if (advanceOperIds.size() > 0) {
            ErpFunRoles erpFunRoles = new ErpFunRoles();
            erpFunRoles.setShardCityId(cityId);
            erpFunRoles.setRoleId(userPosition);
            erpFunRoles = erpFunRolesMapper.selectByPrimaryKey(erpFunRoles);
            String roleId = userPosition;
            if (erpFunRoles == null) {//自定义角色时默认查副总经理
                roleId = "DEPUTY_MANAGER";
            }
            ErpRoleOpersExample roleOpersExample = new ErpRoleOpersExample();
            roleOpersExample.setShardCityId(cityId);
            roleOpersExample.createCriteria().andOperIdIn(new ArrayList<>(advanceOperIds)).andRoleIdEqualTo(roleId).andOperTypeEqualTo(true);
            List<ErpRoleOpers> erpRoleOpers = erpRoleOpersMapper.selectByExample(roleOpersExample);
            advanceOperIds = erpRoleOpers.stream().collect(Collectors.mapping(val -> val.getOperId(), Collectors.toSet()));
        }
        Set<String> baseOperIds = userOpers.stream().filter(val -> "0".equals(val.getOperType()))
                .collect(Collectors.mapping(val -> val.getOperId(), Collectors.toSet()));
        this.removeHiddenOpers(baseOperIds, hiddenOperIds);

        List<String> advanceOperIdsAfter = new ArrayList<>(advanceOperIds);
        List<String> baseOperIdsAfter = new ArrayList<>();

        for (String operId : roleBaseOpersSet) {
            if (!baseOperIds.contains(operId)) {
                baseOperIdsAfter.add(operId);
            }
        }
        ErpFunOpersExample opersExample = new ErpFunOpersExample();
        if (advanceOperIdsAfter.size() > 0) {
            opersExample.setShardCityId(getOperator().getCityId());
            opersExample.createCriteria().andOperIdIn(advanceOperIdsAfter);
            advanceOperList = erpFunOpersMapper.selectByExample(opersExample);
        }
        if (baseOperIdsAfter.size() > 0) {
            opersExample = new ErpFunOpersExample();
            opersExample.setShardCityId(getOperator().getCityId());
            opersExample.createCriteria().andOperIdIn(baseOperIdsAfter);
            baseOperList = erpFunOpersMapper.selectByExample(opersExample);
        }
        user.setAdvanceOperList(advanceOperList);
        user.setBaseOperList(baseOperList);
    }

	/**
	 * @title 新版组织全选处理
	 * @author Lee
	 * @date 2019/12/14 18:32
	 ***/
	private void userOpersProcessNewOrg(ErpFunUsersDto user, Map<String, ErpSysPara> sysParaMap, List<ErpCompRoleOpers> erpCompRoleOpers, List<ErpFunOpers> opersList) {
		if (null == erpCompRoleOpers) {
			erpCompRoleOpers = new ArrayList<>();
		}

		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		String userPosition = user.getUserPosition();
		Integer userId = user.getUserId();
		//总经理都是基本权限
		boolean isGeneralManager = "GENERAL_MANAGER".equals(userPosition);
		if(isGeneralManager) {
			return;
		}

		// 查询高级权限还是低级权限的东西
		ErpFunRoles erpFunRoles = new ErpFunRoles();
		erpFunRoles.setShardCityId(cityId);
		erpFunRoles.setRoleId(userPosition);
		erpFunRoles = erpFunRolesMapper.selectByPrimaryKey(erpFunRoles);
		String temRole = user.getUserPosition();
		if(null == erpFunRoles) {
			temRole = Const.DIC_ROLE_NAME_DEPUTY_MANAGER;
		}

		ErpRoleOpersExample erpRoleOpersExample = new ErpRoleOpersExample();
		erpRoleOpersExample.setShardCityId(cityId);
		erpRoleOpersExample.createCriteria().andRoleIdEqualTo(temRole);
		List<ErpRoleOpers> erpRoleOpers = erpRoleOpersMapper.selectByExample(erpRoleOpersExample);

		Map<String, Boolean> operTypeMap = erpRoleOpers.stream().collect(Collectors.toMap(ErpRoleOpers::getOperId, ErpRoleOpers::getOperType));

		// 个人权限
		List<ErpUserOpersDto> userOpers = erpUserOpersMapper.getUserOpersList(cityId, compId, userId, userPosition);


		// 全权限的ID 名称 是否是组合权限等
		Map<String, ErpFunOpers> operNameMap = opersList.stream().collect(Collectors.toMap(oper -> oper.getOperId(), oper -> oper));
		Map<String, ErpUserOpersDto> userOperMap = userOpers.stream().collect(Collectors.toMap(oper -> oper.getOperId(), val -> val, (o,n)->n));

		for (ErpUserOpersDto userOper : userOpers) {
			Boolean aBoolean = operTypeMap.get(userOper.getOperId());
			if(null == aBoolean) {
				userOper.setOperType("1");
			}else {
				userOper.setOperType(aBoolean ? "1" : "0");
			}
		}

		// 公司权限的高级还是低级
		Map<String, ErpCompRoleOpers> compRoleOpersMap =  erpCompRoleOpers.stream().collect(Collectors.toMap(oper -> oper.getOperId(), oper -> oper, (oper, oper2) -> oper));


		// 设置是感觉权限还是低级权限
//		for (ErpUserOpersDto opersDto : userOpers) {
//			String operId = opersDto.getOperId();
//
//			opersDto.setOperName(operNameMap.get(operId));
//			if (!isGeneralManager){
//				opersDto.setOperType(operTypeMap.get(operId) + "");
//			}else {
//				opersDto.setOperType("0");
//			}
//		}

		Set<String> hiddenOperIds = new HashSet<>();
		//  移除隐藏权限
		hiddenOperIds.addAll(userOpersControlller.getNeedHiddenOper(cityId, compId, userPosition, sysParaMap, operator.newOrganizationType()));
		hiddenOperIds.addAll(userOpersControlller.needHiddenOpersByCustomized(sysParaMap));


		List<OpersVO> baseOperList = new ArrayList<>();
		List<OpersVO> advanceOperList = new ArrayList<>();
//
//		//总经理只有基本权限
//		if ("GENERAL_MANAGER".equals(userPosition)) {
//			// 模板权限
//			Set<String> roleOpersIds = erpCompRoleOpers.stream().collect(Collectors.mapping(val -> val.getOperId(), Collectors.toSet()));
//			// 个人权限
//			Set<String> operIds = userOpers.stream().collect(Collectors.mapping(val -> val.getOperId(), Collectors.toSet()));
//			this.removeHiddenOpers(roleOpersIds, hiddenOperIds);
//			this.removeHiddenOpers(operIds, hiddenOperIds);
//
//			List<String> baseOperIds = new ArrayList<>();
//			for (String operId : roleOpersIds) {
//				if (!operIds.contains(operId)) {
//					baseOperIds.add(operId);
//				}
//			}
//			if (baseOperIds.size() > 0) {
//				ErpFunOpersExample opersExample = new ErpFunOpersExample();
//				opersExample.setShardCityId(getOperator().getCityId());
//				ErpFunOpersExample.Criteria criteria = opersExample.createCriteria();
//				criteria.andOperIdIn(baseOperIds);
//				baseOperList = erpFunOpersMapper.selectByExample(opersExample);
//			}
//			user.setAdvanceOperList(advanceOperList);
//			user.setBaseOperList(baseOperList);
//			return;
//		}

		//获取角色里的 普通权限
		Set<ErpCompRoleOpers> roleBaseOpersSet = erpCompRoleOpers.stream().filter(val -> 0 == val.getOperType()).collect(Collectors.mapping(val -> val, Collectors.toSet()));
		UserOpersUtils.removeHiddenOpersNewOrg(roleBaseOpersSet, hiddenOperIds);

		// 获取user 已有的普通和高于默认的高级权限
		//operType=null 表示该角色没有此权限
		Set<ErpUserOpersDto> advanceOperIds = userOpers.stream().filter(val -> "1".equals(val.getOperType())).collect(Collectors.mapping(val -> val, Collectors.toSet()));
		UserOpersUtils.removeHiddenOpersNewOrg2(advanceOperIds, hiddenOperIds);

		// 低于模板的
		for (ErpCompRoleOpers erpCompRoleOper : roleBaseOpersSet) {
			ErpUserOpersDto userOpersDto = userOperMap.get(erpCompRoleOper.getOperId());
			ErpFunOpers erpFunOpers = operNameMap.get(erpCompRoleOper.getOperId());
			Integer templateDefId = erpCompRoleOper.getOrganizationDefinitionId();
			// 直接缺失的
			if(null == userOpersDto) {
				OpersVO opersVO = new OpersVO();
				opersVO.setOperId(erpCompRoleOper.getOperId());
				opersVO.setTemplateOperDefId(erpCompRoleOper.getOrganizationDefinitionId());
				opersVO.setOperName(erpFunOpers.getOperName());
				opersVO.setOperType(erpFunOpers.getOperType());
				baseOperList.add(opersVO);
			}else {
				if(null != templateDefId && !templateDefId.equals(userOpersDto.getOrganizationDefinitionId())) {
					OpersVO opersVO = new OpersVO();
					opersVO.setOperId(erpCompRoleOper.getOperId());
					opersVO.setTemplateOperDefId(erpCompRoleOper.getOrganizationDefinitionId());
					opersVO.setOperName(erpFunOpers.getOperName());
					opersVO.setOperType(erpFunOpers.getOperType());
					opersVO.setUserOperDefId(userOpersDto.getOrganizationDefinitionId());
					baseOperList.add(opersVO);
				}
			}
		}

		// 高于模板的
		for (ErpUserOpersDto userAdvanceOper : advanceOperIds) {
			ErpFunOpers erpFunOpers = operNameMap.get(userAdvanceOper.getOperId());
			if(null == erpFunOpers) {
				continue;
			}
			// 去模板找有没有
			ErpCompRoleOpers erpCompRoleOper = compRoleOpersMap.get(userAdvanceOper.getOperId());
			if(null == erpCompRoleOper) {
				OpersVO opersVO = new OpersVO();
				opersVO.setOperId(userAdvanceOper.getOperId());
				opersVO.setUserOperDefId(userAdvanceOper.getOrganizationDefinitionId());
				opersVO.setOperName(erpFunOpers.getOperName());
				opersVO.setOperType(erpFunOpers.getOperType());
				advanceOperList.add(opersVO);
			}else{
				Integer userOperDefId = userAdvanceOper.getOrganizationDefinitionId();
				if(null != userOperDefId && !userOperDefId.equals(erpCompRoleOper.getOrganizationDefinitionId())) {
					OpersVO opersVO = new OpersVO();
					opersVO.setOperId(erpCompRoleOper.getOperId());
					opersVO.setTemplateOperDefId(erpCompRoleOper.getOrganizationDefinitionId());
					opersVO.setOperName(erpFunOpers.getOperName());
					opersVO.setOperType(erpFunOpers.getOperType());
					opersVO.setUserOperDefId(userAdvanceOper.getOrganizationDefinitionId());
					advanceOperList.add(opersVO);
				}
			}
		}

		// 处理层级名称
		List<OrganizationDefinitionVO> organizationDefinitionList = erpFunOrganizationDefinitionMapper.getOrganizationDefinitionList(cityId, compId);
		Map<Integer, OrganizationDefinitionVO> definitionVOMap = organizationDefinitionList.stream().collect(Collectors.toMap(val -> val.getDefinitionId(), val -> val));


		for (OpersVO opersVO : baseOperList) {
			Integer templateOperDefId = opersVO.getTemplateOperDefId();
			if(null != templateOperDefId) {
				OrganizationDefinitionVO organizationDefinitionVO = definitionVOMap.get(templateOperDefId);
				if(null != organizationDefinitionVO) {
					opersVO.setDefinitionName(organizationDefinitionVO.getDefinitionName());
				}
			}
		}

		for (OpersVO opersVO : advanceOperList) {
			Integer userOperDefId = opersVO.getUserOperDefId();
			if(null != userOperDefId) {
				OrganizationDefinitionVO organizationDefinitionVO = definitionVOMap.get(userOperDefId);
				if(null != organizationDefinitionVO) {
					opersVO.setDefinitionName(organizationDefinitionVO.getDefinitionName());
				}
			}
		}
//		if (advanceOperIds.size() > 0) {
//			ErpFunRoles erpFunRoles = new ErpFunRoles();
//			erpFunRoles.setShardCityId(cityId);
//			erpFunRoles.setRoleId(userPosition);
//			erpFunRoles = erpFunRolesMapper.selectByPrimaryKey(erpFunRoles);
//			String roleId = userPosition;
//			if (erpFunRoles == null) {//自定义角色时默认查副总经理
//				roleId = "DEPUTY_MANAGER";
//			}
//			ErpRoleOpersExample roleOpersExample = new ErpRoleOpersExample();
//			roleOpersExample.setShardCityId(cityId);
//			roleOpersExample.createCriteria().andOperIdIn(new ArrayList<>(advanceOperIds)).andRoleIdEqualTo(roleId).andOperTypeEqualTo(true);
//			List<ErpRoleOpers> erpRoleOpers = erpRoleOpersMapper.selectByExample(roleOpersExample);
//			advanceOperIds = erpRoleOpers.stream().collect(Collectors.mapping(val -> val.getOperId(), Collectors.toSet()));
//		}
//		Set<String> baseOperIds = userOpers.stream().filter(val -> "0".equals(val.getOperType()))
//				.collect(Collectors.mapping(val -> val.getOperId(), Collectors.toSet()));
//		this.removeHiddenOpers(baseOperIds, hiddenOperIds);
//
//		List<String> advanceOperIdsAfter = new ArrayList<>(advanceOperIds);
//		List<String> baseOperIdsAfter = new ArrayList<>();
//
//		for (String operId : roleBaseOpersSet) {
//			if (!baseOperIds.contains(operId)) {
//				baseOperIdsAfter.add(operId);
//			}
//		}
//		ErpFunOpersExample opersExample = new ErpFunOpersExample();
//		if (advanceOperIdsAfter.size() > 0) {
//			opersExample.setShardCityId(getOperator().getCityId());
//			opersExample.createCriteria().andOperIdIn(advanceOperIdsAfter);
//			advanceOperList = erpFunOpersMapper.selectByExample(opersExample);
//		}
//		if (baseOperIdsAfter.size() > 0) {
//			opersExample = new ErpFunOpersExample();
//			opersExample.setShardCityId(getOperator().getCityId());
//			opersExample.createCriteria().andOperIdIn(baseOperIdsAfter);
//			baseOperList = erpFunOpersMapper.selectByExample(opersExample);
//		}
		user.setAdvanceOperNewOrgList(advanceOperList);
		user.setBaseOperNewOrgList(baseOperList);
	}

    /**
     * @tag 移除需要隐藏的权限
     * @author 邓永洪
     * @since 2018/8/8
     */
    private void removeHiddenOpers(Set<String> opersIds, Set<String> hiddenOperIds) {
        if (null == opersIds || opersIds.size() <= 0) {
            return;
        }
        List<String> removeOpers = new LinkedList<>();
        for (String removeOperId : hiddenOperIds) {
            if (opersIds.contains(removeOperId)) {
                removeOpers.add(removeOperId);
            }
        }
        opersIds.removeAll(removeOpers);
    }

    /**
     * @tag 修改员工角色
     * @author 邓永洪
     * @since 2018/8/8
     */
    @ApiOperation("修改员工角色")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/updateUserRole")
    @NotBlank({"roleId"})
    public ErpResponseJson updateUserRole(@Valid @RequestBody UpdateUserRoleParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        Integer adminCompId = operator.getAdminCompId();
        Integer userId = param.getUserId();
        String roleId = param.getRoleId();
        Integer currentUserId = operator.getUserId();
        Integer roleLevelId = param.getRoleLevelId();
        Integer inviteId = param.getInviteId();
        String createUserName = null;
        if (getOperator().isSwitchCompLogin()){  //后续换成isSwitchCompLogin
        	createUserName = getOperator().getUserName()+"("+getOperator().getCompName()+")";
        }
        erpFunUsersService.updateUserRole(cityId, compId, userId, roleId, roleLevelId, currentUserId,inviteId,createUserName);
        return ErpResponseJson.ok();
    }

    @ApiOperation("设置公司管理员")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/updateCompConmmonAdmin")
    @NotBlank({"userId"})
    public ErpResponseJson setCompConmmonAdmin(@Valid @RequestBody UpdateUserRoleParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        Integer compType = operator.getCompType();
        Integer currentUserId = operator.getUserId();
        boolean isFangJidi = operator.isFangJidi();
        ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, param.getUserId());
        String userPosition  = erpFunUsers.getUserPosition();
        if (StringUtil.isNotEmpty(userPosition) && "GENERAL_MANAGER".equals(userPosition)) {
            throw new BusinessException("总经理角色不可更改！");
        }
        erpFunUsersService.setCompConmmonAdmin(cityId, compId, compType, param.getUserId(), currentUserId, isFangJidi);
        return ErpResponseJson.ok();
    }

	/**
	 * @TODO 新增大区
	 * @author lcb
	 * @2016-10-18 下午6:23:24
	 */
	@ApiOperation("新增大区,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpResponseJson.class, message = "成功")})
	@RequestMapping("/insertMgrArea")
	@ResponseBody
	@NotBlank({"areaName"})
	public ErpResponseJson insertMgrArea(@Valid @RequestBody CreateAreaParam param) {
		Operator operator = getOperator();
		param.setCityId(operator.getCityId());
		param.setCompId(operator.getCompId());
		param.setDeptId(operator.getDeptId());
		param.setUserId(operator.getUserId());
		Integer areaId = erpFunAreaService.insertMgrArea(param);
		Map<String, Object> resMap = new HashMap<>();
		resMap.put("areaId", areaId);
		return ErpResponseJson.ok(resMap);
	}

    /**
     * @TODO 查询用户详细信息
     * @author lcb
     * @2016-10-18 下午6:23:24
     */
    @ResponseBody
    @RequestMapping("/getUserInfoData")
    @NotBlank({"archiveId"})
    public ErpResponseJson getUserInfoData(@Valid @RequestBody BaseMapParam param) throws Exception {
        Operator operator = getOperator();
        Integer archiveId = param.getInteger("archiveId");
        AdminFunArchive adminFunArchive = adminFunArchiveMapper.getArchiveById(archiveId);
        adminFunArchive.setUserPhoto(CommonUtil.getPhotoUrl(adminFunArchive.getUserPhoto())); // 临时看格式是否需要处理
        adminFunArchive.setUserPhotoMin(CommonUtil.getPhotoUrl(adminFunArchive.getUserPhotoMin()));
        // 查询funUsersDto
        ErpFunUsersDto erpFunUsersDto = erpFunUsersMapper.getFunUserByArchiveId(operator.getCityId(), archiveId);
        org.springframework.beans.BeanUtils.copyProperties(adminFunArchive, erpFunUsersDto);
        ErpCompRoles erpCompRoles = erpCompRolesMapper.getCompRoleByUserEdition(operator.getCityId(), erpFunUsersDto.getUserPosition(), operator.getCompId());
        erpFunUsersDto.setRoleName(erpCompRoles.getRoleName());
        return ErpResponseJson.ok(erpFunUsersDto);
    }

    /**
     * @TODO 获取员工职级和底薪配置
     * @author lcb
     * @2016-10-18 下午6:23:24
     */
    @RequestMapping("/getPersonnelLevelList")
    @ResponseBody
    public ErpResponseJson getPersonnelLevelList(@Valid @RequestBody BaseMapParam param) throws Exception {
        Operator operator = getOperator();
        ErpFunPersonnelLevels erpFunPersonnelLevels = new ErpFunPersonnelLevels();
        erpFunPersonnelLevels.setCompId(operator.getCompId());
        erpFunPersonnelLevels.setLevelsStatus((byte) 1);
        erpFunPersonnelLevels.setShardCityId(operator.getCityId());
        List<ErpFunPersonnelLevels> resList = erpFunPersonnelLevelsMapper.selectListByCondition(erpFunPersonnelLevels);
        return ErpResponseJson.ok(resList);
    }

    /**
     * @TODO 入职渠道列表
     * @author lcb
     * @2016-10-18 下午6:23:24
     */
    @ApiOperation("入职渠道列表,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpFunRecruitmentChannelVo.class, message = "成功")})
    @RequestMapping("/getRecruitmentChannelList")
    @ResponseBody
    public ErpResponseJson getRecruitmentChannelList(@Valid @RequestBody BaseMapParam param) throws Exception {
        Operator operator = getOperator();
        ErpFunRecruitmentChannel recruitmentChannel = new ErpFunRecruitmentChannel();
        recruitmentChannel.setShardCityId(operator.getCityId());
        recruitmentChannel.setCompId(operator.getCompId());
        recruitmentChannel.setChannelStatus((byte) 1);
        List<ErpFunRecruitmentChannel> resList = erpFunRecruitmentChannelMapper.selectListByCondition(recruitmentChannel);
        ErpFunRecruitmentChannelVo channelVo = new ErpFunRecruitmentChannelVo();
        channelVo.setResList(resList);
        return ErpResponseJson.ok(channelVo);
    }


    /**
     * @TODO 删除职级
     * @author lcb
     * @2016-10-18 下午6:23:24
     */
    @RequestMapping("/delPersonnelLevel")
    @ResponseBody
    @NotBlank({"levelsId"})
    public ErpResponseJson delPersonnelLevel(@Valid @RequestBody BaseMapParam param) throws Exception {
        param.setInteger("cityId", getOperator().getCityId());
        Integer res = erpFunUsersService.delPersonnelLevel(param);
        return ErpResponseJson.ok(res);
    }

    /**
     * @TODO 删除入职渠道
     * @author lcb
     * @2016-10-18 下午6:23:24
     */
    @ResponseBody
    @RequestMapping("/delRecruitmentChannel")
    @NotBlank({"channelId"})
    public ErpResponseJson delRecruitmentChannel(@Valid @RequestBody BaseMapParam param) throws Exception {
        param.setInteger("cityId", getOperator().getCityId());
        Integer res = erpFunUsersService.delRecruitmentChannel(param);
        return ErpResponseJson.ok(res);
    }

    /**
     * @TODO 查询门店人数许可
     * @author lcb
     * @2016-10-18 下午6:23:24
     */
    @ResponseBody
    @NotBlank({"deptId"})
    @RequestMapping("/getRegisterUserStatus")
    public ErpResponseJson getRegisterUserStatus(@Valid @RequestBody BaseMapParam param) throws Exception {
        Integer deptId = param.getInteger("deptId");
        String roleId = param.getString("roleId");
        if("COMMON_ADMIN".equals(roleId)){
//        	ErpFunUsers commonAdminUser = erpFunUsersMapper.getUserByCompIdAndUserPositionAndUserWriteoff(getOperator().getCompNo(), getOperator().getCompId(), roleId, "0");
        	ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
        	erpFunUsersExample.createCriteria().andCompIdEqualTo(getOperator().getCompId()).andUserWriteoffEqualTo(false).andUserPositionEqualTo(roleId);
        	erpFunUsersExample.setShardCityId(getOperator().getCityId());
        	Integer countUser = erpFunUsersMapper.countByExample(erpFunUsersExample);
        	if(countUser <= 0){
        		return ErpResponseJson.ok();
        	} else {
        		throw new BusinessException("一个公司只能配置一个管理员");
        	}
        }
        ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(getOperator().getCityId(), deptId);

        // 查询admin门店装
        // 查询门店是否是租用或者新营销版
        ErpFunDepts byDeptId = erpFunDeptsMapper.getByDeptId(getOperator().getCityId(), deptId);
        AdminFunDepts deptByCompNoAndDeptNo = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(byDeptId.getCompNo(), byDeptId.getDeptNo());

        Integer userNum = null;
        if ((null != deptByCompNoAndDeptNo.getDeptType() && 4 == deptByCompNoAndDeptNo.getDeptType().intValue()) ||
                (null != deptByCompNoAndDeptNo.getPayType() && 5 == deptByCompNoAndDeptNo.getPayType().intValue())) {
            userNum = erpFunUsersMapper.countUserNumberForRentDept(getOperator().getCityId(), deptId);
        } else {
            // 查询门店人数
            userNum = erpFunUsersMapper.count(getOperator().getCityId(), deptId);
        }

        Integer deptsUserNum = null;
        if (erpFunDepts != null) {
            deptsUserNum = erpFunDepts.getUserNum();
        }
        if (CommonUtil.isnull(deptsUserNum)) {
            throw new BusinessException("DEPTID：" + deptId + "门店用户数量限制字段为空");
        }
        if (deptsUserNum <= userNum) {
            throw new BusinessException("用户注册已经达到许可的最大值，请联系客服");
        }
        return ErpResponseJson.ok();
    }

	/**
	 * @TODO  添加分组
	 * @author lcb
	 * @2016-10-18 下午6:23:24
	 */
	@ApiOperation("新建分组信息,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpResponseJson.class, message = "成功")})
	@RequestMapping("/insertMgrGroupData")
	@ResponseBody
	public ErpResponseJson insertMgrGroupData(@Valid @RequestBody InsertGroupData param) throws Exception{
		param.setSelfDeptId(getOperator().getDeptId());
		param.setUserId(getOperator().getUserId());
		param.setCityId(getOperator().getCityId());
		param.setCompId(getOperator().getCompId());
		erpFunUsersService.insertMgrGroupData(param);
		HashMap<String, Object> resultMap = new HashMap<>();
		return ErpResponseJson.ok(resultMap);
	}

    /**
     * @TODO 删除分组
     * @author lcb
     * @2016-10-18 下午6:23:24
     */
    @RequestMapping("/deleteMgrGroupData")
    @ResponseBody
    @NotBlank({"grId"})
    public ErpResponseJson deleteMgrGroupData(@Valid @RequestBody BaseMapParam param) throws Exception {
        param.setInteger("userId", getOperator().getUserId());
        param.setInteger("cityId", getOperator().getCityId());
        param.setInteger("compId", getOperator().getCompId());
        Integer res = erpFunUsersService.deleteMgrGroupData(param);
        return ErpResponseJson.ok(res);
    }

	/**
	 * @TODO 查询分组
	 * @author lcb
	 * @2016-10-18 下午6:23:24
			*/
	@RequestMapping("/getGroupData")
	@ResponseBody
	@NotBlank({"grId"})
	@ApiOperation("查询分组信息,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, responseContainer = "List", response = ErpFunDeptsGroupVo.class, message = "成功")})
	public ErpResponseJson getGroupData(@Valid @RequestBody GetDeptsGroupDataParam param) throws Exception{
		Operator operator = getOperator();
		HashMap<String, Object> resultMap = new HashMap<>();
		// 查询本分组下的所有用户
		Integer deptId = param.getDeptId();
		Integer grId = param.getGrId();
		BaseMapParam dataParam = new BaseMapParam();
		dataParam.setInteger("deptId", deptId);
		dataParam.setInteger("grId", grId);
		ErpFunUsers erpFunusers = new ErpFunUsers();
		erpFunusers.setDeptId(deptId);
		erpFunusers.setShardCityId(operator.getCityId());
		erpFunusers.setGrId(grId);
		erpFunusers.setUserWriteoff(false);
		List<ErpFunUsers> erpFunusersList = erpFunUsersMapper.getUserListByNotNull(erpFunusers);
		List<ErpFunDeptsgroup> deptgroups = erpFunDeptsgroupMapper.getGroupListByCondition(operator.getCityId(), dataParam.getMap());
		if(null == deptgroups || deptgroups.isEmpty()){
			return ErpResponseJson.ok(resultMap);
		}
		ErpFunDeptsgroup funDeptGroup = deptgroups.get(0);
//		StringBuilder namebuilder = new StringBuilder();
		StringBuilder idbuilder = new StringBuilder();
		String nameStr = new String();
//		String idStr = new String();
		if (null != erpFunusersList && erpFunusersList.size() > 0) {
			nameStr = erpFunusersList.stream().collect(Collectors.mapping(ErpFunUsers::getUserName, Collectors.joining(",")));
//			idStr = erpFunusersList.stream().collect(Collectors.mapping(ErpFunUsers::getUserId, Collectors.joining(",")));
			for (ErpFunUsers usersPO : erpFunusersList) {
//					namebuilder.append(usersPO.getUserName() + ",");
					if(null == usersPO){
						continue;
					}
					if(idbuilder.length() > 0){
						idbuilder.append(",");
					}
					idbuilder.append(usersPO.getUserId());
				}
			}
		Map<String, Object> resMap = new HashMap<>();
		BeanUtil.beanToMap(funDeptGroup, resMap);
		resMap.put("grMemberName", nameStr);
		resMap.put("grMember", idbuilder.toString());
		List<Map<String, Object>> funDeptsgroupList = new LinkedList<>();
		funDeptsgroupList.add(resMap);
		resultMap.put("funDeptsgroupList", funDeptsgroupList);
		return ErpResponseJson.ok(resultMap);
	}

    /**
     * @TODO 重置密码
     * @author lcb
     * @2016-10-18 下午6:23:24
     */
    @RequestMapping("/updateMgrResetUserPWData")
    @ResponseBody
    public ErpResponseJson updateMgrResetUserPWData(@Valid @RequestBody BaseMapParam param) throws Exception {
        param.setInteger("cityId", getOperator().getCityId());
        param.setString("userName", getOperator().getUserName());
        param.setInteger("uaId", getOperator().getUaId());
        param.setInteger("archiveId", getOperator().getArchiveId());
        param.setInteger("compId", getOperator().getCompId());
        param.setInteger("adminDeptId", getOperator().getAdminDeptId());
        erpFunUsersService.updateMgrResetUserPWData(param);
        return ErpResponseJson.ok();
    }

	/**
	 * 冻结账户
	 *
	 * @author lcb @2016-10-18 下午6:23:24
	 */
	@ApiOperation("冻结账户,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpResponseJson.class, message = "成功")})
	@ResponseBody
	@RequestMapping("/updateMgrUserUseState")
	public ErpResponseJson updateMgrUserUseState(@Valid @RequestBody UpdateUserStateParam param) {
		Integer cityId = getOperator().getCityId();
		Integer userId = param.getUserId();
		Byte newStatus = param.getUserStatus();
		// 处理暂停或启用
		ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, userId);
		BaseMapParam dataMap = new BaseMapParam();
		dataMap.setInteger("cityId", cityId);
		dataMap.setInteger("compId", getOperator().getCompId());
		dataMap.setInteger("selfDeptId", getOperator().getDeptId());
		dataMap.setInteger("selfUserId", getOperator().getUserId());
		dataMap.setInteger("userId", userId);
		dataMap.setByte("userStatus", newStatus);
		
		String userName = null;
		if (getOperator().isSwitchCompLogin()){  //后续换成isSwitchCompLogin
			userName = getOperator().getUserName()+"("+getOperator().getCompName()+")";
		}
		
		erpFunUsersService.updateMgrUserUseState(dataMap, erpFunUsers,userName);
		// 发送消息通知手机端
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("cityId", erpFunUsers.getCityId());
		paramMap.put("compId", erpFunUsers.getCompId());
		paramMap.put("deptId", erpFunUsers.getDeptId());
		paramMap.put("archiveId", erpFunUsers.getArchiveId());
		paramMap.put("userId", erpFunUsers.getUserId());
		paramMap.put("roleId", erpFunUsers.getUserPosition());
		paramMap.put("writeUserId", erpFunUsers.getUserId());
		String url = (newStatus == 1) ? "approveOpenApi/yxTeam/newEmp" : "approveOpenApi/yxTeam/empLeave";
		HttpUtil.post(AppConfig.getHftMoblieUrl() + url, paramMap);
		return ErpResponseJson.ok();
	}

    /**
     * @TODO 更新门店信息
     * @author lcb
     * @2016-10-18 下午6:23:24
     */
    @RequestMapping("/updateMgrDeptData")
    @ResponseBody
    public ErpResponseJson updateMgrDeptData(@Valid @RequestBody BaseMapParam param) throws Exception {
        param.setInteger("cityId", getOperator().getCityId());
        param.setString("userName", getOperator().getUserName());
        param.setInteger("compId", getOperator().getCompId());
        erpFunUsersService.updateMgrDeptData(param);
        return ErpResponseJson.ok();
    }

    /**
     * 邀请注册
     *
     * @return
     * @throws Exception
     * @author 张宏利
     * @since 2017年5月9日
     */
    @ApiOperation("邀请注册")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @ResponseBody
    @RequestMapping("/inviteRegist")
    @NotBlank(value = {"userMobile", "userSex", "deptId"})
    public ErpResponseJson inviteRegist(HttpServletRequest request, @Valid @RequestBody InviteRegistParam param) throws Exception {
        Operator operator = getOperator();
        String userMobile = param.getUserMobile();
        AdminFunArchive adminFunArchive = adminFunArchiveMapper.getArchiveByMobile(userMobile);
        if (adminFunArchive != null) {
            if (adminFunArchive.getUserEdition() != 2) {
                return ErpResponseJson.warn("该用户已注册门店版");
            }
            if (!operator.getCityId().equals(adminFunArchive.getCityId().intValue())) {
                return ErpResponseJson.warn("该用户已经在其他城市注册");
            }
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, -24);
        AdminInviteRegistErpExample example = new AdminInviteRegistErpExample();
        example.createCriteria().andUserMobileEqualTo(userMobile)
                .andCreateTimeGreaterThan(calendar.getTime());
        Integer inviteCount = adminInviteRegistErpMapper.countByExample(example);
        if (inviteCount != null && inviteCount >= 3) {
            return ErpResponseJson.warn("一天一个用户最多只能邀请三次");
        }
        String compNo = operator.getCompNo();
        Integer deptId = param.getDeptId();
        String userName = param.getUserName();
        Integer userSex = param.getUserSex();
        String userPosition = param.getUserPosition();
        Integer groupId = param.getGroupId();
        String uuidCode = StringUtil.getUUIDBySub();
        Set<Integer> deptIdsSet = new HashSet<Integer>();
        deptIdsSet.add(deptId);
        List<ErpFunDepts> list = erpFunDeptsMapper.getDeptListByDeptIds(operator.getCityId(),deptIdsSet);
        if (list != null && list.size() > 0) {
            ErpFunDepts erpFunDepts = list.get(0);
            Assert.isNullThrow(erpFunDepts, "未找到该门店信息");
            AdminInviteRegistErp record = new AdminInviteRegistErp();
            record.setCreateTime(new Date());
            record.setDeptNo(erpFunDepts.getDeptNo());
            record.setCompNo(compNo);
            record.setCityId(operator.getCityId());
            record.setGrId(groupId);
            record.setUserMobile(userMobile);
            record.setUserName(userName);
            record.setRoleId(userPosition);
            record.setUserSex(userSex.byteValue());
            record.setRegistStatus((byte) 0);
            record.setUuid(uuidCode);
            record.setCreateUserId(operator.getUserId());
            record.setCreateUserName(operator.getUserName());
            adminInviteRegistErpMapper.insertSelective(record);
            String mobileKey = adminMobileKeyService.creatMobileKeyAndInsert(userMobile, getClientIpAddr(request),
                    "您注册 “门店版”的账号验证码为：%s，完成后同时为您开通“精英版”，账号为手机号码，密码一致");
            // 发送短信给被邀请人
            String url = AppConfig.getErpWebUrl() + "/openApi/inviteRegist/regist?code=" + uuidCode;
            String ddzUrl = HttpUtil.createDdz(url);
            String content = String.format("【好房通】%s，我是你的同事%s，邀请你加入%s，本次邀请验证码为：%s，点击填写资料%s，此链接将于24小时后失效", userName,
                    operator.getUserName(), erpFunDepts.getDeptName(), mobileKey, ddzUrl);
            adminMobileKeyService.sendNoticeSms(userMobile, null, content);
            // 组装数据返回
            Map<String, String> result = new HashMap<>(1);
            result.put("url", ddzUrl);
            return ErpResponseJson.ok(result);
        }
        return ErpResponseJson.ok();
    }

    /**
     * 依据角色获取员工列表
     *
     * @author 张宏利
     */
    @ResponseBody
    @NotBlank(value = {"roleId"})
    @RequestMapping("/getUserListByRoleId")
    @ApiResponses({
		    @ApiResponse(code = 200, message = "", response = UserListRoleVO.class)
    })
    public ErpResponseJson getUserListByRoleId(@Valid @RequestBody GetRoleParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        String roleId = param.getRoleId();
        Integer userId = param.getUserId();
        // 获取员工列表
        List<ErpFunUsers> userList = erpFunUsersMapper.getUserListForRole(cityId, roleId, userId, compId);
        if (userList == null || userList.size() <= 0) {
            return ErpResponseJson.ok();
        }

	    // 获取管理范围列表
        Set<Integer> userIds = userList.stream().collect(Collectors.mapping(ErpFunUsers::getUserId, Collectors.toSet()));
        List<ErpFunUserManageRange> rangList = erpFunUserManageRangeMapper.getListByUserId(cityId, compId, userIds, 1);
        // 组装数据
	    UserListRoleVO vo = new UserListRoleVO();
	    vo.setUserList(userList);
	    vo.setRangList(rangList);
        return ErpResponseJson.ok(vo);
    }

    /**
     * 给用户配置管理范围
     *
     * @param param
     * @return
     * @author 张宏利
     * @since 2017年11月1日
     */
    @ResponseBody
    @NotBlank(value = {"userId"})
    @RequestMapping("/updateUserManageRange")
    @ApiResponses({
		    @ApiResponse(code = 200, message = "", response = UserListRoleVO.class)
    })
    public ErpResponseJson updateUserManageRange(@RequestBody BaseMapParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        boolean isFangJidi = operator.isFangJidi();
        Integer rangeType = param.getInteger("rangeType");
        Integer userId = param.getInteger("userId");
        String rangeIds = param.getString("rangeIds");
        String roleId = param.getString("roleId");
		boolean newOrganizationType = operator.newOrganizationType();
		if(newOrganizationType) {
			erpFunUserManageRangeService.updateUserManageRangeNewOrg(cityId, compId, userId,  rangeIds, roleId);
		}else {
			erpFunUserManageRangeService.updateUserManageRange(cityId, compId, userId, rangeType, rangeIds, roleId, isFangJidi);
		}

        return ErpResponseJson.ok();
    }

	/**
	 * 给用户配置管理范围
	 *
	 * @param param
	 * @return
	 * @author 张宏利
	 * @since 2017年11月1日
	 */
	@ResponseBody
	@NotBlank(value = {"userId"})
	@RequestMapping("/appUpdateUserManageRange")
	@ApiResponses({
			@ApiResponse(code = 200, message = "", response = ResponseJson.class)
	})
	public ErpResponseJson updateUserManageRange(@RequestBody UpdateUserManageParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer rangeType = param.getRangeType();
		Integer userId = param.getUserId();
		String rangeIds = param.getRangeIds();
		String roleId = param.getRoleId();
		erpFunUserManageRangeService.updateUserManageRange(cityId, compId, userId, rangeType, rangeIds, roleId, operator.isFangJidi());
		return ErpResponseJson.ok();
	}

    /**
     * 修改角色管理层级
     *
     * @param param
     * @return
     * @author 张宏利
     * @since 2017年11月1日
     */
    @ResponseBody
    @RequestMapping("/updateRoleManageLevel")
    @NotBlank(value = {"roleId", "manageLevel"})
    @ApiResponses({
		    @ApiResponse(code = 200, message = "",response = ErpResponseJson.class)
    })
    public ErpResponseJson updateRoleManageLevel(@RequestBody UpdateRoleManageParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        String roleId = param.getRoleId();
        Integer manageLevel = param.getManageLevel();
        erpCompRolesService.updateRoleManageLevel(cityId, compId, roleId, manageLevel.byteValue());
        return ErpResponseJson.ok();
    }

    /**
     * 修改角色顺序
     *
     * @param param
     * @return
     * @author 张宏利
     * @since 2017年11月1日
     */
    @ResponseBody
    @RequestMapping("/updateRoleSeq")
    @ApiResponses({
		    @ApiResponse(code = 200, message = "",response = ErpResponseJson.class)
    })
    public ErpResponseJson updateRoleSeq(@RequestBody UpdateRoleSeqParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        String roleIds = param.getRoleIds();
        // 去掉总经理，逗号不能去，去掉总经理，防止总经理顺序都改了
        roleIds = roleIds.replace("GENERAL_MANAGER,", "");
        String[] roleIdArr = roleIds.split(",");
        erpCompRolesMapper.updateRoleSeq(cityId, compId, roleIdArr);
        return ErpResponseJson.ok();
    }

    /**
     * 增加公司角色
     *
     * @param param
     * @return
     * @author 张宏利
     * @since 2017年11月1日
     */
    @ResponseBody
    @RequestMapping("/addCompRoles")
    @NotBlank(value = {"roleName"})
    @ApiResponses({
		    @ApiResponse(code = 200, message = "", response = RoleIdVO.class)
    })
    public ErpResponseJson addCompRoles(@RequestBody AddRoleParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        Integer deptId = operator.getDeptId();
        Integer userId = operator.getUserId();
        String roleName = param.getRoleName();
        Integer manageLevel = param.getManageLevel();
        String beforRoleId = param.getBeforRoleId();
        Byte partStatistCount = param.getPartStatistCount();
	    String roleId = erpCompRolesService.addCompRoles(cityId, compId, deptId, userId, roleName, manageLevel, beforRoleId, partStatistCount);
	    RoleIdVO roleIdVO = new RoleIdVO();
	    roleIdVO.setRoleId(roleId);
        return ErpResponseJson.ok(roleIdVO);
    }

    /**
     * 查询门店配置的行政区商圈控制
     *
     * @param param
     * @return
     * @author 方李骥
     * @since 2017年11月1日
     */
    @ResponseBody
    @RequestMapping("/getDeptRegSectionCotrolList")
    public ErpResponseJson getDeptRegSectionCotrolList(@RequestBody BaseMapParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        Integer regId = param.getInteger("regId");
        Integer deptId = param.getInteger("deptId");
        ErpFunRegsectionControlExample example = new ErpFunRegsectionControlExample();
        example.setShardCityId(cityId);
        example.createCriteria().andCompIdEqualTo(compId);
        if (regId != null) {
            example.createCriteria().andRegIdEqualTo(regId);
        } else if (deptId != null) {
            example.createCriteria().andDeptIdEqualTo(deptId);
        }
        List<ErpFunRegsectionControl> list = erpFunRegsectionControlMapper.selectByExample(example);
        return ErpResponseJson.ok(list);
    }

    /**
     * 保存行政区商圈控制
     * @param param
     * @return
     * @author 方李骥
     * @since 2017年11月1日
     */
    @ResponseBody
    @RequestMapping("/saveDeptRegSectionCotrolList")
    public ErpResponseJson saveDeptRegSectionCotrolList(@RequestBody BaseMapParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        Integer creatorUid = operator.getUserId();
        Integer creatorDeptId = operator.getDeptId();
        Integer deptId = param.getInteger("deptId");
        String controllType = param.getString("controllType");
        String cotrolJsonListStr = param.getString("cotrolJsonList");
        String currentUserName = operator.getDeptName() + " " + operator.getUserName();
        erpFunRegsectionControlService.saveFunRegsectionControlOffDept(cityId, compId, deptId, creatorUid, creatorDeptId, cotrolJsonListStr, currentUserName, controllType);
        return ErpResponseJson.ok();
    }

	/**
	 * 获取全部的公司角色
	 * @author 张宏利
	 * @since 2017年11月1日
	 * @return
	 * @throws Exception 
	 */
	@ApiOperation("获取全部的公司角色,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = AllCompRoleVo.class, message = "成功")})
	@RequestMapping("/getAllCompRole")
	@ResponseBody
	public ErpResponseJson getAllCompRole() throws Exception {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
        Integer compType = operator.getCompType();
        boolean signleDeptFlag = Const.DIC_COMP_TYPE_6.equals(compType);
        List<ErpCompRoles> erpCompRolesList = erpCompRolesMapper.getAllCompRole(cityId, compId);

        for(Integer i = erpCompRolesList.size()-1; i>=0;i-- ){
            ErpCompRoles next = erpCompRolesList.get(i);
            if (signleDeptFlag && ("BIZ_GENERAL".equals(next.getRoleId()) || "REGION_MANAGER".equals(next.getRoleId()))) {
                erpCompRolesList.remove(next);
            }
        }
        AllCompRoleVo allCompRoleVo = new AllCompRoleVo();
		allCompRoleVo.setErpCompRolesList(erpCompRolesList);
		
		//查询职级数据
		ErpFunRoleLevelsExample roleLevelExample = new ErpFunRoleLevelsExample();
		roleLevelExample.setShardCityId(cityId);
		roleLevelExample.setOrderByClause("SEQ_NO asc");
		roleLevelExample.createCriteria().andCompIdEqualTo(compId).andRoleLevelStatusEqualTo((byte) 1);
		List<ErpFunRoleLevels> erpFunRoleLevelList = erpFunRoleLevelsMapper.selectByExample(roleLevelExample);
		List<ErpCompRoleLevelsVO> erpCompRoleLevelsVOList = new ArrayList<>();
		for (ErpFunRoleLevels erpFunRoleLevel : erpFunRoleLevelList) {
			ErpCompRoleLevelsVO compRoleLevelsVO = PoConverterToView.convertPoToVo(erpFunRoleLevel, ErpCompRoleLevelsVO.class);
			erpCompRoleLevelsVOList.add(compRoleLevelsVO);
		}
		allCompRoleVo.setCompRoleLevelList(erpCompRoleLevelsVOList);
		return ErpResponseJson.ok(allCompRoleVo);
	}
	

    /**
     * 移动端专用
     * 该接口与/getAllCompRole 功能重复了，如果后期有影响再修改该方法
     * 2019-08-02被陈文超标记为取消
     * 
     * @Title 查询角色
     * @Author lcb
     * @Time 2018/8/20
     **/
    @ApiOperation(value = "获取角色列表",httpMethod = "POST")
    @ApiResponses({@ApiResponse(code = 200,responseContainer = "List",response = ErpCompRoles.class, message = "success")})
    @RequestMapping("/getFunRolesList")
    @Deprecated
    public ResponseJson getFunRolesList(@RequestBody FunRolesListParam param) {
        Operator operator = getOperator();
        List<ErpCompRoles> resList = erpCompRolesMapper.getAllCompRole(operator.getCityId(), operator.getCompId());
        return ErpResponseJson.ok(resList);
    }

    /**
     * 编辑已有角色名字
     * @param param
     * @return
     * @author 张宏利
     * @since 2017年11月1日
     */
    @ResponseBody
    @RequestMapping("/updateCompRolesName")
    public ErpResponseJson updateCompRolesName(@RequestBody UpdateRoleNameParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        Integer userId = operator.getUserId();
        Integer deptId = operator.getDeptId();
        String userName = operator.getUserName();
        String roleName = param.getRoleName(); //现在要改成的角色名
        String roleId = param.getRoleId();
        Byte partStatistCount = param.getPartStatistCount();
        erpCompRolesService.updateCompRolesName(cityId, compId, deptId, userId, roleId, roleName, userName, partStatistCount);
        return ErpResponseJson.ok();
    }

	/**
	 * 编辑片区信息
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/4/18
	 */
	@ApiOperation("编辑片区信息,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpResponseJson.class, message = "成功")})
	@ResponseBody
	@RequestMapping("/updateMgrRangeData")
	public ErpResponseJson updateMgrRangeData(@RequestBody UpdateRangeData param) {
		param.setCityId(getOperator().getCityId());
		param.setCompId(getOperator().getCompId());
		param.setDeptId(getOperator().getDeptId());
		param.setUserId(getOperator().getUserId());
		erpFunRegionService.updateMgrRegion(param);
		HashMap<String, Object> resultMap = new HashMap<>();
		return ErpResponseJson.ok(resultMap);
	}

	/**
	 * 删除片区
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/4/23
	 */
	@ApiOperation("删除片区信息,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpResponseJson.class, message = "成功")})
	@ResponseBody
	@RequestMapping("/deleteMgrRangeData")
	public ErpResponseJson deleteMgrRangeData(@RequestBody DeleteRegionDataParam param) {
		Integer regId = param.getRegId();
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		BaseMapParam mapParam = new BaseMapParam();
		mapParam.setInteger("cityId", cityId);
		mapParam.setInteger("compId", compId);
		mapParam.setInteger("deptId", getOperator().getDeptId());
		mapParam.setInteger("userId", getOperator().getUserId());
		// 查询当前片区是不是最后一个 如果只剩下一个则不能删除jiangsonggui
		List<ErpFunRegion> funRegionPOs = erpFunRegionMapper.getCacheableRegionListByAreaId(cityId, compId);
		if (funRegionPOs.size() < 1) {
			throw new BusinessException("至少要保留一个片区!");
		}
		List<ErpFunDepts> erpFunDepts = erpFunDeptsMapper.getDataList(cityId, compId, regId);
		if (erpFunDepts.size() != 0) {
			throw new BusinessException("该片区下还有门店，请将门店更改片区后再删除");
		}
		String content = null;
		for (ErpFunRegion funRegion : funRegionPOs) {
			if (regId.equals(funRegion.getRegId())) {
				content = "删除了" + funRegion.getRegName() + "片区";
				break;
			}
		}
		erpFunRegionService.deleteRegionInfo(mapParam,regId,content);
		HashMap<String, Object> resultMap = new HashMap<>();
		return ErpResponseJson.ok(resultMap);
	}

	/**
	 * 新建片区信息
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/26
	 * @return
	 *
	 */
	@ApiOperation("新建片区信息,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpFunRegion.class, message = "成功")})
	@ResponseBody
	@PostMapping("/insertMgrRangeData")
	@NotBlank("regName")
	public ErpResponseJson insertMgrRangeData(@RequestBody InsertFunRegData param) {
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		Integer areaId = param.getAreaId();
		if (areaId == null) {
			//如果没有传大区ID就拿公司大区(取ID最小的)
			areaId = erpFunAreaMapper.getCompAreaId(cityId,compId);
		}
		String regName = param.getRegName();
		param.setCityId(cityId);
		param.setCompId(compId);
		param.setDeptId(getOperator().getDeptId());
		param.setUserId(getOperator().getUserId());
		ErpFunRegion erpFunRegion = new ErpFunRegion();
		erpFunRegion.setAdminUser(param.getAdminUser());
		erpFunRegion.setRegAdmin(param.getRegAdmin());
		erpFunRegion.setRegDesc(param.getRegDesc());
		erpFunRegion.setRegName(regName);
		erpFunRegion.setRegTele(param.getRegTele());
		erpFunRegion.setSeqNo(param.getSeqNo());
		erpFunRegion.setAreaId(areaId);
		erpFunRegion.setUpdateUid(getOperator().getUserId());
		erpFunRegion.setUpdateTime(DateTimeHelper.getTimeNow());
		erpFunRegion.setShardCityId(getOperator().getCityId());
		erpFunRegion.setCompId(getOperator().getCompId());
		// 新建片区判重
		Integer count = erpFunRegionMapper.countRegionByRegName(cityId, compId, areaId, regName.trim());
		if (count > 0) {
			throw new BusinessException("片区名称重复请重新输入");
		}
		erpFunRegionService.insertMgrRegion(erpFunRegion,param);
		Map<String, Object> regMap = new HashMap<String, Object>();
		regMap.put("regId", erpFunRegion.getRegId());
		return ErpResponseJson.ok(regMap);
	}

	/**
	 * 编辑大区
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/17
	 */
	@ApiOperation("编辑大区,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpResponseJson.class, message = "成功")})
	@RequestMapping("/updateMgrArea")
	@ResponseBody
	public ErpResponseJson updateMgrArea(@Valid @RequestBody UpdateAreaData param) {
		param.setCityId(getOperator().getCityId());
		param.setCompId(getOperator().getCompId());
		param.setDeptId(getOperator().getDeptId());
		param.setUserId(getOperator().getUserId());
		erpFunAreaService.updateMgrArea(param);
		HashMap<String, Object> resultMap = new HashMap<>();
		return ErpResponseJson.ok(resultMap);
	}

    /**
     * @tag 增加员工职级和底薪配置
     * @author 胡坤
     * @since 2018/5/18
     */
    @PostMapping("/addOrEditPersonnelLevel")
    public ResponseJson addOrEditPersonnelLevel(@RequestBody BaseMapParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        String paramJson = param.getString("personLevelList");
        List<ErpFunPersonnelLevels> paramList = JSON.parseArray(paramJson, ErpFunPersonnelLevels.class);
        erpFunPersonnelLevelsService.addOrEditPersonnelLevel(cityId, compId, paramList);
        return ErpResponseJson.ok();
    }

    /**
     * 注销用户账号
     * @detail [2020-03-19]  陈峰  直接改用SelfCityId、SelfCompId查询当前人信息  需求id#11704  门店配置化需求同步修改
     * @param cityId 城市id
     * @param compId 公司id
     * @return 
     * @auther 胡坤
     * @since 2018/5/19
     */
	@ApiOperation("注销用户账号,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpResponseJson.class, message = "成功")})
	@PostMapping("/deleteUser")
    public ResponseJson deleteUser(@RequestBody DeleteUsersParam param) {
        Integer cityId = param.getCityId();
        Integer compId = param.getCompId();
        if (null == cityId){
        	cityId = getOperator().getCityId();
        }
        if (null == compId){
        	compId = getOperator().getCompId();
        }

        param.setCityId(cityId);
        param.setSelfUserId(getOperator().getUserId());
        param.setCompId(compId);
		param.setCompType(getOperator().getCompType());
		param.setMeiLianFlag(getOperator().isMeiLianApi());

		if (getOperator().isSwitchCompLogin()){   //如果切换了公司
			param.setSelfCityId(getOperator().getSelfCityId());
			param.setSelfCompId(getOperator().getSelfCompId());
		} else {// [2020-03-19]  陈峰  直接改用SelfCityId、SelfCompId查询当前人信息  需求id#11704  门店配置化需求同步修改
			param.setSelfCityId(getOperator().getCityId());
			param.setSelfCompId(getOperator().getCompId());
		}
		param.setSwitchCompLogin(getOperator().isSwitchCompLogin());
		this.deleteUserCommon(param);
        return ErpResponseJson.ok();
    }

    /**
     * @Title 注销公用方法
     * @detail [2020-03-19]  陈峰  直接改用SelfCityId、SelfCompId查询当前人信息  需求id#11704  门店配置化需求同步修改
     * @Author lcb
     * @Time 2020/2/21
     *
     * **/
    public void deleteUserCommon(DeleteUsersParam param) {
		Integer userId = param.getUserId();
		//这里要用会话中的cityId和compId去查
		//ErpFunUsers selfUser = erpFunUsersMapper.selectDataByUserId(cityId, compId, getOperator().getUserId());

		// [2020-03-19]  陈峰  直接改用SelfCityId、SelfCompId查询当前人信息  需求id#11704  门店配置化需求同步修改
		ErpFunUsers selfUser = erpFunUsersMapper.selectDataByUserId(param.getSelfCityId(), param.getSelfCompId(), param.getSelfUserId());

		ErpFunOrganization organization = erpFunOrganizationMapper.selectOrgByOrganizationId(param.getCityId(), selfUser.getOrganizationId());
		param.setOrganizationId(organization.getOrganizationId());
		param.setOrganizationPath(organization.getOrganizationPath());
		param.setOrganizationName(organization.getOrganizationName());
		param.setSelfUser(selfUser);
		// 判断是否可以注销
		//ErpFunUsers funUsersSel = erpFunUsersMapper.selectDataByUserId(getOperator().getCityId(), compId, userId);
		ErpFunUsers funUsersSel = erpFunUsersMapper.selectDataByUserId(param.getCityId(), param.getCompId(), userId);
		if (userId.equals(selfUser.getUserId())) {
			throw new BusinessException("不能注销自己！");
		}

		String createUserName = null;
		/*jsg 202002-05-31注释if (getOperator().isSwitchCompLogin()){ //后续改为isSwitchCompLogin
			createUserName = getOperator().getUserName()+"("+getOperator().getCompName()+")";
		}*/

		List<HouseCaseIdDto> saleIds = erpFunSalePublishInfoMapper.getUserSalesOnWebsite(param.getCityId(), funUsersSel.getUserId());
		List<HouseCaseIdDto> leaseIds = erpFunLeasePublishInfoMapper.getUserLeasesOnWebsite(param.getCityId(), funUsersSel.getUserId());

		Assert.isNullThrow(param.getCityId(), "城市参数为空");
		Assert.isNullThrow(param.getCompId(), "公司参数为空");
		erpFunUsersService.writeOffUser(param, funUsersSel, createUserName);
		//处理如果当前注销人员是原有审核中主管的审核逻辑处理 flj 2020-06-24
		erpAuditRuntimeService.createAuditUserForOrgManagerChange(param.getCityId(), param.getCompId(), funUsersSel.getUserId()); 
		//维护门店经纪人数量 INCUMBENCY_NUMBER
		ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(param.getCityId(), funUsersSel.getDeptId());
		AdminFunDepts adminFunDepts = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(erpFunDepts.getCompNo(), erpFunDepts.getDeptNo());
		adminFunDeptsMapper.updateIncumbencyNumberByDeptId(adminFunDepts.getDeptId(), 0);

		// 后续操作
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("cityId", funUsersSel.getCityId());
		paramMap.put("compId", funUsersSel.getCompId());
		paramMap.put("deptId", funUsersSel.getDeptId());
		paramMap.put("archiveId", funUsersSel.getArchiveId());
		paramMap.put("userId", funUsersSel.getUserId());
		paramMap.put("roleId", funUsersSel.getUserPosition());
		paramMap.put("writeUserId", funUsersSel.getUserId());
		// 注销门店版用户，自动移交该用户名下的平安普惠业务订单到相应负责人名下
		HttpUtil.post(AppConfig.getCrmWebUrl() + "crmOpenApi/pinganFinance/changeLoanBrokerOfPa", paramMap);
		HttpUtil.post(AppConfig.getHftMoblieUrl() + "approveOpenApi/yxTeam/empLeave", paramMap);
		//删除离职员工配置的审核流程 2020-06-11 flj修改
		ErpAuditUserTemplateExample example = new ErpAuditUserTemplateExample();
		example.setShardCityId(param.getCityId());
		example.createCriteria().andAuditUserIdEqualTo(userId);
		erpAuditUserTemplateMapper.deleteByExample(example);
		//下架离职员工发发房源
		activeMqPublisher.removeListing(param.getCityId(),funUsersSel.getArchiveId(),userId);
		//修改新盘驻场人员
		erpFunOrganizationService.updateFieldStaff(param.getCityId(),userId,funUsersSel.getOrganizationId(),funUsersSel.getCompId());
		try {
			erpAliyunPhoneService.deleteUnBindNumber(param.getCityId(), userId, param.getSelfUserId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		//下架官网房源
		erpFunSaleService.downHouseFormWebSite(funUsersSel, saleIds, leaseIds);

		// 删除管理范围
		ErpFunOrganizationManagerExample erpFunOrganizationManagerExample = new ErpFunOrganizationManagerExample();
		erpFunOrganizationManagerExample.setShardCityId(param.getCityId());
		erpFunOrganizationManagerExample.createCriteria().andUserIdEqualTo(param.getUserId());
		erpFunOrganizationManagerMapper.deleteByExample(erpFunOrganizationManagerExample);

		ErpFunCrossCompUser erpFunCrossCompUser = new ErpFunCrossCompUser();
		erpFunCrossCompUser.setDelFlag((byte) 1);
		ErpFunCrossCompUserExample erpFunCrossCompUserExample = new ErpFunCrossCompUserExample();
		erpFunCrossCompUserExample.setShardCityId(param.getCityId());
		erpFunCrossCompUserExample.createCriteria().andUserIdEqualTo(param.getUserId());
		erpFunCrossCompUserMapper.updateByExampleSelective(erpFunCrossCompUser, erpFunCrossCompUserExample);
	}

    /**
     * 判断是否能注销
     *
     * @param cityId
     * @param compId
     * @param userId
     * @param archiveId
     * @author 张宏利
     * @since 2018年6月7日
     */
    private void judgeWriteOffUser(Integer cityId, Integer compId, Integer userId, Integer archiveId) {
        Integer salePOs = erpFunSaleMapper.countByUserId(cityId, compId, userId);
        if (salePOs > 0) {
            throw new BusinessException("该用户还有出售房源数据未移交，不能注销！");
        }
        Integer leasePOs = erpFunLeaseMapper.countByUserId(cityId, compId, userId);
        if (leasePOs > 0) {
            throw new BusinessException("该用户还有出租房源数据未移交，不能注销！");
        }
        Integer rentCustomerPOs = erpFunRentCustomerMapper.countByUserId(cityId, compId, userId);
        if (rentCustomerPOs > 0) {
            throw new BusinessException("该用户还有求租数据未移交，不能注销！");
        }
        int buyCustomerPOs = erpFunBuyCustomerMapper.countByUserId(cityId, compId, userId);
        if (buyCustomerPOs > 0) {
            throw new BusinessException("该用户还有求购数据未移交，不能注销！");
        }
        Integer custCount = agencyFunCustMapper.getCustCount(cityId, compId, archiveId);
        if (custCount > 0) {
            throw new BusinessException("该用户还有分销客户数据未移交，不能注销！");
        }
    }

    /**
     * 员工调店操作
     *
     * @param param
     * @return
     * @author 张宏利
     * @since 2018年4月23日
     */
    @PostMapping("/moveUserToNewDept")
    public ErpResponseJson moveUserToNewDept(@RequestBody MoveUserToNewDeptParam param) {
    	if (getOperator().newOrganizationType()) {
    		return moveUserToNewOrg(param);
    	}
    	ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(getOperator().getCityId(), param.getUserId());
        param.setSelfUserId(getOperator().getUserId());
        param.setCityId(getOperator().getCityId());
        param.setCompId(getOperator().getCompId());
        param.setCompType(getOperator().getCompType());
        
        if(param.getNewUserId() !=null){
        	ErpFunUsers newErpFunUsers = erpFunUsersMapper.getFunUserByUserId(getOperator().getCityId(), param.getNewUserId());
        	if(newErpFunUsers == null){
        		return  ErpResponseJson.warn("参数信息错误");
        	}
        	param.setNewGrId(newErpFunUsers.getGrId());
        }
        
        erpFunDeptsService.moveUserToNewDept(param);
        HashMap<String, Object> resultMap = new HashMap<>();
        Map<String, Object> changeDeptInfo = new HashMap<>();
        if (null != erpFunUsers) {
        	changeDeptInfo.put("cityId", param.getCityId());
        	changeDeptInfo.put("compId", param.getCompId());
        	changeDeptInfo.put("newDept", param.getNewDeptId());
        	changeDeptInfo.put("oldDept", erpFunUsers.getDeptId());
        	changeDeptInfo.put("archiveId", erpFunUsers.getArchiveId());
        	httpRequestTask.postToMobileWeb("approveOpenApi/yxTeam/changeDept", changeDeptInfo);
        }
        
    	//员工团队处理（只处理玛雅房基地）
		AdminFunComp adminFunComp =  adminFunCompMapper.selectByCompNo(getOperator().getCompNo());
		if(adminFunComp !=null){
			if("2".equals(adminFunComp.getCompManagementModel().toString()) && "1".equals(adminFunComp.getCustomizedType().toString())){
				Map<String,Object> changeUserParam = new HashMap<String,Object>();
				changeUserParam.put("cityId", param.getCityId());
				changeUserParam.put("userId", param.getUserId());
				changeUserParam.put("newUserId", param.getNewUserId());
				changeUserParam.put("newGrId", param.getNewGrId());
				HttpUtil.postNewErp(AppConfig.getZxWeb()+"/broker/org/moveUserToNewDept", param,getOperator().getClientKey());				
			}
		}
		try {
			erpAliyunPhoneService.transAxn(getOperator().getCityId(), param.getUserId());
		} catch (Exception e) {
			e.printStackTrace();
		}
        return ErpResponseJson.ok(resultMap);
    }
    
    public ErpResponseJson moveUserToNewOrg(@RequestBody MoveUserToNewDeptParam param) {
    	Operator operator = getOperator();
		param.setSelfUserId(operator.getUserId());
		param.setCityId(getOperator().getCityId());
		param.setCompId(getOperator().getCompId());
		param.setCompType(getOperator().getCompType());
		param.setSwitchComp(getOperator().isSwitchCompLogin());
		param.setUserName(operator.getUserName());
		this.moveUserToNewOrgCommon(param);
    	return ErpResponseJson.ok();
    }

    /**
     * @Title 调店逻辑公用方法
     * @Author lcb
     * @Time 2020/2/21
     *
     * **/
	public void moveUserToNewOrgCommon(MoveUserToNewDeptParam param) {
		ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(param.getCityId(), param.getUserId());

		reportFunSaleMinService.judgeOperatorTransferShop(param.getCompNo(), param.getCityId(), param.getCompId(),
				erpFunUsers.getUserId().toString(), 6, null,null);
		Integer newOrgId = param.getNewOrganizationId();
		Integer oldOrgId = param.getOrganizationId();
		ErpFunUsers users = erpFunUsersMapper.getFunUserByUserId(param.getCityId(), erpFunUsers.getUserId());

		String createUserName = null;
		if (param.isSwitchComp()){ //后续改为isSwitchCompLogin
			createUserName = param.getUserName()+"("+param.getCompName()+")";
		}

		Map<String,Integer> resultMap = erpFunOrganizationService.moveUserNewOrganization(param.getCityId(), erpFunUsers.getCompId(), param.getSelfUserId(), erpFunUsers.getUserId(), oldOrgId, newOrgId,createUserName);
		Map<String, Object> changeDeptInfo = new HashMap<>();
		if (null != users) {
			changeDeptInfo.put("cityId", param.getCityId());
			changeDeptInfo.put("compId", param.getCompId());
			changeDeptInfo.put("newOrgId", resultMap.get("lookNewLevelId"));
			changeDeptInfo.put("oldOrgId", resultMap.get("lookOldLevelId"));
			changeDeptInfo.put("archiveId", erpFunUsers.getArchiveId());
			httpRequestTask.postToMobileWeb("approveOpenApi/yxTeam/changeOrg", changeDeptInfo);
		}
		try {
			erpAliyunPhoneService.transAxn(param.getCityId(), param.getUserId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    /**
     * 组织机构 --更新分店
     *
     * @param param
     * @return
     * @author 张宏利
     * @since 2018年4月27日
     */
	@ApiOperation("组织机构 更新分店,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpResponseJson.class, message = "成功")})
	@PostMapping("/updateDeptInformation")
    public ErpResponseJson updateDeptInformation(@RequestBody FunDeptsParam param) {
        param.setSelfUserId(getOperator().getUserId());
        param.setCityId(getOperator().getCityId());
        param.setCompId(getOperator().getCompId());
        param.setCompNo(getOperator().getCompNo());
        param.setUserName(getOperator().getUserName());
        erpFunDeptsService.updateDept(param);
        HashMap<String, Object> resultMap = new HashMap<>();
        return ErpResponseJson.ok(resultMap);
    }

    /**
     * 组织机构 --更新分组
     *
     * @param param
     * @return
     * @author 张宏利
     * @since 2018年4月27日
     */
	@ApiOperation("组织机构,更新分组,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpResponseJson.class, message = "成功")})
	@PostMapping("/updateGroupInformation")
    public ErpResponseJson moveUserToNewGroup(@RequestBody MoveUserToNewGroupParam param) {
        param.setCityId(getOperator().getCityId());
        param.setCompId(getOperator().getCompId());
        param.setSelfUserName(getOperator().getUserName());
        param.setSelfUserId(getOperator().getUserId());
        Integer grId = erpFunDeptsGroupService.moveUserToNewGroup(param);
        HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("grId", grId);
		return ErpResponseJson.ok(resultMap);
    }

    /**
     * 组织机构 --删除分组
     *
     * @param param
     * @return
     * @author 张宏利
     * @since 2018年4月27日
     */
	@ApiOperation("组织机构，删除分组,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpResponseJson.class, message = "成功")})
	@PostMapping("/deleteGroupInformation")
    public ErpResponseJson deleteGroupInformation(@RequestBody DeleteGroupParam param) {
        param.setCityId(getOperator().getCityId());
        param.setCompId(getOperator().getCompId());
        param.setSelfUserId(getOperator().getUserId());
        erpFunDeptsGroupService.deleteGroup(param);
        HashMap<String, Object> resultMap = new HashMap<>();
        return ErpResponseJson.ok(resultMap);
    }

    /**
     * @tag 删除大区
     * @author 邓永洪
     * @since 2018/5/17
     */
	@ApiOperation("删除大区,需求:8592,作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpResponseJson.class, message = "成功")})
	@PostMapping("/deleteMgrArea")
    @NotBlank(value = {"areaId"})
    public ResponseJson deleteMgrArea(@RequestBody DeleteAreaDataParam param) {
        Operator operator = getOperator();
        param.setCityId(operator.getCityId());
        param.setCompId(operator.getCompId());
        param.setUserId(operator.getUserId());
        param.setDeptId(operator.getDeptId());
        erpFunAreaService.deleteMgrArea(param);
        HashMap<String, Object> resultMap = new HashMap<>();
        return ErpResponseJson.ok(resultMap);
    }

    /**
     * @tag 增加修改入职渠道
     * @author 邓永洪
     * @since 2018/5/18
     */
    @PostMapping("/addOrEditRecruitmentChannel")
    public ResponseJson addOrEditRecruitmentChannel(@RequestBody BaseMapParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        String paramJson = param.getString("channelList");
        List<ErpFunRecruitmentChannel> paramList = JSON.parseArray(paramJson, ErpFunRecruitmentChannel.class);
        if (paramList != null && !paramList.isEmpty()) {
            erpFunRecruitmentChannelService.addOrEditRecruitmentChannel(cityId, compId, paramList);
        }
        return ErpResponseJson.ok();
    }

//	/**
//	 * 判断注销人是否有当前公司的联动数据
//	 *
//	 * @param funUsersPO
//	 * @return
//	 */
//	public boolean hasDistributeData(ErpFunUsers funUsersPO) {
//		// 判断当前公司当前用户是否有数据
//		funUsersPO = erpFunUsersMapper.selectDataByUserId(getOperator().getCityId(), funUsersPO.getUserId());
//		Integer custCount = agencyFunCustMapper.getCustCount(funUsersPO.getShardCityId(), funUsersPO.getCompId(), funUsersPO.getArchiveId());
//		if (custCount > 0) {
//			return true;
//		}
//		return false;
//	}

    /**
     * @tag 管理功能新建员工时验证手机
     * @author 邓永洪
     * @since 2018/5/19
     */
    @PostMapping("/updateMgrVerifyPhone")
    public ResponseJson registUserPhoneValid(@RequestBody UserPhoneValidParam param, HttpServletRequest request) {
        param.setCityId(getOperator().getCityId());
        param.setCompId(getOperator().getCompId());
        Map<String, Object> resultMap = new HashMap<>();
        String action = param.getAction();
        // 验证手机号是否可以注册
        if ("0".equals(action)) {
            resultMap = validMobileIsRegist(param);
        } else if ("1".equals(action)) {
            resultMap = validMobileKey(param);
        } else if ("2".equals(action)) {
            String ipAddr = getClientIpAddr(request);
            resultMap = userCenterController.sendMsgAndValidateCountMap(ipAddr, param.getType(), param.getMobile());
        }
        resultMap.put("action", action);// 回传ACTION 供前端验证
        List<Map<String, Object>> list = new ArrayList<>();
        list.add(resultMap);
        return ErpResponseJson.ok(list);
    }

    /**
     * @tag 新增用户
     * @author 邓永洪
     * @since 2018/5/19
     */
    @ApiOperation("新增用户,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpFunUsers.class, message = "成功")})
	@PostMapping("/addUser")
    public ResponseJson createUser(@RequestBody CreateUserParam param) {
        Operator operator = getOperator();
        param.setCurrentCityId(operator.getCityId());
        param.setCurrentCompId(operator.getCompId());
        param.setCurrentUserId(operator.getUserId());
        param.setCurrentCompType(operator.getCompType());
        param.setCurrentDeptId(operator.getDeptId());
        param.setCurrentUserEdition(StringUtil.parseInteger(operator.getAttribute("USER_EDITION")));
        param.setProvinceId(operator.getProvinceId());
        param.setSelUid(StringUtil.parseInteger(operator.getAttribute("SEL_UID")));
        param.setPerLogin(operator.isPerLogin());
        param.setCompType(operator.getCompType());
        param.setOrganizationType(operator.newOrganizationType() ? "1" : null);// 开启无限组织机构
        ErpFunUsers newUser = getParamObj(ErpFunUsers.class);
        newUser.setCompId(operator.getCompId());
        newUser.setCityId(operator.getCityId().shortValue());
        // 物业版门店经理给管理范围
        if (operator.isPropertyEdition()) {
        	if (Const.DIC_ROLE_NAME_BRANCH_MANAGER.equals(param.getUserPosition())) {
        		param.setRangeIds(param.getDeptId() + "");
        		param.setRangeType(4);
        	}
        }
        ErpFunUsers createUser = erpFunUsersService.createUser(newUser, param, null, operator.isFangJidi());
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("cityId", param.getCurrentCityId());
        userInfo.put("compId", param.getCurrentCompId());
        userInfo.put("archiveId", createUser.getArchiveId());
        userInfo.put("deptId", createUser.getDeptId());
        httpRequestTask.postToMobileWeb("approveOpenApi/yxTeam/newEmp", userInfo);
        return ErpResponseJson.ok(createUser);
    }

    /**
     * 验证码校验
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/6/29
     */
    @PostMapping("/validKey")
    public ResponseJson validKey(@RequestBody UserPhoneValidParam param) {
        param.setCityId(getOperator().getCityId());
        param.setCompId(getOperator().getCompId());
        Map<String, Object> resultMap = isValidKey(param);
        List<Map<String, Object>> list = new ArrayList<>();
        list.add(resultMap);
        return ErpResponseJson.ok(list);
    }

    /**
     * 验证码校验
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/6/29
     */
    private Map<String, Object> isValidKey(UserPhoneValidParam param) {
        String userMobile = param.getMobile();
        String validateKey = param.getKey();
        String checkFlag = param.getFlag();
        validateKey = validateKey == null ? "" : validateKey;
        checkFlag = checkFlag == null ? "" : checkFlag;
        Map<String, Object> resultMap = new HashMap<>();
        boolean isValid = false;
        if (!"".equals(validateKey)) {// 检测电话号码是否通过
            // 这里判断是否有定制参数
            String notValidteMsgCodeTime = erpSysParaMapper.getParamValue(param.getCityId(), param.getCompId(), "NOT_VALIDTE_MSG_CODE_TIME");
            // 时间未过期
            if (StringUtils.isNotBlank(notValidteMsgCodeTime)) {
                boolean notValidMsgCode = DateUtil.StringToDate(notValidteMsgCodeTime).after(new Date());

                if (notValidMsgCode) {
                    String commonMsgCode = erpSysParaMapper.getParamValue(param.getCityId(), param.getCompId(), "COMMON_MSG_CODE");
                    if (StringUtils.isNotBlank(commonMsgCode) && commonMsgCode.equals(validateKey)) {
                        isValid = true;
                    }
                }
            }

            // 如果用了通用码就不再验证了
            if (!isValid) {
                isValid = adminMobileKeyService.validateSmsCode(validateKey, userMobile);
            }
        } else {// 如果没有输入验证码 检测是否打过电话认证
            isValid = adminMobileKeyService.checkMobileDialToday(userMobile);
        }
        if (isValid) {
            if ("EXIST".equals(checkFlag)) {
                //获取该用户的档案信息
                AdminFunArchive funArchive = adminFunArchiveMapper.getArchiveByMobile(userMobile);
                if (funArchive != null) {
                    resultMap.put("flag", "EXIST");
                    resultMap.put("serviceReg", funArchive.getServiceReg());
                    resultMap.put("serviceZone", funArchive.getServiceZone());
                } else {
                    resultMap.put("flag", "NEW");
                }
            } else {
                resultMap.put("flag", "NEW");
            }
        } else {
            resultMap.put("flag", "ERROR");
            resultMap.put("reson", "验证没有通过,请稍后重试");
        }
        return resultMap;
    }


    /**
     * @tag 验证电话号码和验证码是否正确 如果flag EXIST 的话就返回fun_archive的信息
     * @author 邓永洪
     * @since 2018/5/19
     */
    private Map<String, Object> validMobileKey(UserPhoneValidParam param) {
        String userMobile = param.getMobile();
        String validateKey = param.getKey();
        String checkFlag = param.getFlag();
        validateKey = validateKey == null ? "" : validateKey;
        checkFlag = checkFlag == null ? "" : checkFlag;
        Map<String, Object> resultMap = new HashMap<>();
        boolean isValid = false;
        if (!"".equals(validateKey)) {// 检测电话号码是否通过
            isValid = adminMobileKeyService.validateSmsCode(validateKey, userMobile);
        } else {// 如果没有输入验证码 检测是否打过电话认证
            isValid = adminMobileKeyService.checkMobileDialToday(userMobile);
        }
        if (isValid) {
            if ("EXIST".equals(checkFlag)) {
                //获取该用户的档案信息
                AdminFunArchive funArchive = adminFunArchiveMapper.getArchiveByMobile(userMobile);
                if (funArchive != null) {
                    resultMap = BeanUtil.objToObjMap(funArchive);
                    ErpFunUsers funUsers = erpFunUsersMapper.getFunUserByArchiveId(param.getCityId(), funArchive.getArchiveId());
                    if (funUsers != null) {
                        if (!funUsers.getCityId().equals(param.getCityId().shortValue())) {
                            throw new BusinessException("用户在其他城市已经注册");
                        } else if (funUsers.getCompId().equals(param.getCompId())) {
                            throw new BusinessException("用户已在公司就职");
                        } else if (!funUsers.getCompId().equals(funUsers.getCityId().intValue())) {
                            throw new BusinessException("用户已在该城市其他门店就职");
                        }
                        resultMap.put("userId", funUsers.getUserId());
                    } else {
                        throw new BusinessException("用户数据异常");
                    }
                    resultMap.put("flag", "EXIST");
                } else {
                    resultMap.put("flag", "NEW");
                }
            } else {
                resultMap.put("flag", "NEW");
            }
        } else {
            resultMap.put("flag", "ERROR");
            resultMap.put("reson", "验证没有通过,请稍后重试");
        }
        return resultMap;
    }

    /**
     * @tag 验证用户是否已经注册
     * @author 邓永洪
     * @since 2018/5/19
     */
    private Map<String, Object> validMobileIsRegist(UserPhoneValidParam param) {
        Map<String, Object> resultMap = new HashMap<>();
        String mobile = param.getMobile();
        if (StringUtils.isBlank(mobile)) {
            mobile = param.getUserMobile();
        }
        AdminFunArchive funArchive = adminFunArchiveMapper.getArchiveByMobile(mobile);
        String returnStr = "NOTEXIST";
        Integer archiveId = null;
        if (funArchive != null) {
            if (funArchive.getUserEdition() == 2) {// 精英版
                if (!param.getCityId().equals(funArchive.getCityId().intValue())) {
                    returnStr = "该电话在其他城市已经注册，请联系客服处理！";
                } else {
                    returnStr = "EXIST";
                    archiveId = funArchive.getArchiveId();
                }
            } else {
                returnStr = "该电话已经注册门店版，请更换号码！";
            }
        }
        if ("NOTEXIST".equals(returnStr) || "EXIST".equals(returnStr)) {
            resultMap.put("flag", 1);
            resultMap.put("reson", returnStr);
            resultMap.put("archiveId", archiveId);
        } else {
            resultMap.put("flag", 0);
            resultMap.put("reson", returnStr);
        }
        return resultMap;
    }

    /**
     * @tag 修改用户信息
     * @author 朱科
     * @since 2018/5/15
     */
    @RequestMapping("/updateUserInformation")
    public ResponseJson updateUserInformation(@RequestBody UpdateUserInfoParam param) {
        Operator operator = getOperator();
        param.setSelfArchiveId(operator.getArchiveId());
        param.setSelfCityId(operator.getCityId());
        param.setSelfUserId(operator.getUserId());
        param.setSelfCompId(operator.getCompId());
        param.setSelfDeptId(operator.getDeptId());
        param.setCompType(operator.getCompType());
        param.setProvinceId(operator.getProvinceId());
        param.setSelUid(StringUtil.parseInteger(operator.getAttribute("SEL_UID")));
        param.setFangJidi(operator.isFangJidi());
        erpFunUsersService.updateUserInfo(param);
        HashMap<String, Object> resultMap = new HashMap<>();
        return ErpResponseJson.ok(resultMap);
    }

	/**
	 * @tag 新增门店
	 * @author 邓永洪
	 * @since 2018/7/5
	 */
	@ApiOperation("新增门店信息，作者：邓永洪")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@PostMapping("/addDeptInfo")
	@NotBlank({"deptName"})
	public ResponseJson addDept(@RequestBody AddDeptParam param) {
		Operator operator = getOperator();
		param.setArchiveId(operator.getArchiveId());
		param.setCityId(operator.getCityId());
		param.setCompId(operator.getAdminCompId());
		param.setCompName(operator.getCompName());
		param.setCompNo(operator.getCompNo());
        param.setDeptNo(operator.getDeptNo());
        param.setProvinceId(operator.getProvinceId());
		param.setAddType(1);
		if(null == param.getRegId()){
			param.setRegId(operator.getRegId());
		}
		if(StringUtil.isEmpty(param.getDeptAddr())){
			ErpFunComp erpFunComp = erpFunCompMapper.selectByCompId(operator.getCityId(), operator.getCompId());
			param.setDeptAddr(erpFunComp.getCompAddr());
		}
		if(StringUtil.isEmpty(param.getDeptCname())){
			param.setDeptCname(param.getDeptName());
		}
		//String result = HttpUtil.post("http://172.16.140.108:8080/crmWeb/crmOpenApi/commonOpenApiController/addDeptsForComp",param);
		//门店判重，只判断试用和正式的
		AdminFunDeptsExample deptsExample=new AdminFunDeptsExample();
		deptsExample.createCriteria().andCompIdEqualTo(operator.getAdminCompId()).andDeptNameEqualTo(param.getDeptName())
				.andDeptFlagIn(Arrays.asList(new Integer[]{1,2}));
		int count = adminFunDeptsMapper.countByExample(deptsExample);
		if (count>0){
			throw new BusinessException("当前门店名称与公司已有门店名称重复，请修改后再提交！");
		}
		//String result = HttpUtil.post(AppConfig.getCrmWebUrl() + "crmOpenApi/deptsManage/addDeptsForComp", param);
		String result = HttpUtil.post(AppConfig.getCrmWebUrl()+ "/crmOpenApi/deptsManage/addDeptsForComp", param);
		JSONObject jsonObject = JSON.parseObject(result);
		if (jsonObject == null) {
			throw new BusinessException("数据异常，请重试或联系在线客服！");
		}
		Object errorCode = jsonObject.get("code");
		if (null != errorCode && !(Const.ResponseCode.SUCCESS==StringUtil.paseInteger(errorCode.toString()))) {
			throw new BusinessException("数据异常，请重试或联系在线客服！");
		} else {
			return ErpResponseJson.ok(jsonObject.get("data"));
		}
	}

    @ApiOperation("KA公司购买门店，作者：邓永洪")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = KaCompDeptPayVo.class, message = "成功")
    })
    @PostMapping("/kaCompDeptPay")
    @NotBlank({"deptNo"})
    public ResponseJson kaCompDeptPay(@RequestBody KaCompDeptPayParam param) {
        Operator operator = getOperator();
		KaCompDeptPayVo result =new KaCompDeptPayVo();
		result.setDeptNo(param.getDeptNo());
		AdminFunComp funComp = adminFunCompMapper.selectByCompNo(operator.getCompNo());
		if (funComp.getKaDeptNums() <= 0) { // 表示可直接开的门店已用完，直接让客户付款购买
			result.setFlag(0);
			return ErpResponseJson.ok(result);
		}
		AdminFunDepts adminFunDepts = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(operator.getCompNo(), param.getDeptNo());
        SoftContractDto softContractDto = adminCrmFunContractMapper.getSoftContract(adminFunDepts.getDeptId());
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("contractId",softContractDto.getContractId());
        paramMap.put("deptId",adminFunDepts.getDeptId());
        paramMap.put("source","0");
        String url = AppConfig.getCrmWebUrl()+ "/crmOpenApi/deptsManage/erpPayForKaDepts";
		//String url = "http://192.168.5.186:8081/crmWeb/crmOpenApi/deptsManage/erpPayForKaDepts";
        String postResult = HttpUtil.post(url, paramMap);
        JSONObject jsonObject = JSON.parseObject(postResult);
        if (jsonObject != null) {
            if (!(jsonObject.getInteger("code") == 200)) {
               throw  new BusinessException(jsonObject.getString("msg"));
            }
        } else {
            throw new BusinessException("系统错误");
        }
		result.setFlag(1);
        return ErpResponseJson.ok(result);
    }


    /**
     * @tag 获取城市行政区列表
     * @author 邓永洪
     * @since 2018/7/25
     */
    @RequestMapping("/getCityRegList")
    public ResponseJson getCityRegList(@RequestBody BaseMapParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer regId = param.getInteger("regId");
        ErpFunRegExample funRegExample = new ErpFunRegExample();
        funRegExample.setShardCityId(cityId);
        ErpFunRegExample.Criteria criteria = funRegExample.createCriteria();
        criteria.andCityIdEqualTo(cityId.shortValue());
        if (regId != null) {
            criteria.andRegIdEqualTo(regId);
        }
        criteria.andVertifyFlagEqualTo((byte) 1);
        funRegExample.setOrderByClause("SEQ_NO asc");
        List<ErpFunReg> erpFunRegs = erpFunRegMapper.selectByExample(funRegExample);
        return ErpResponseJson.ok(erpFunRegs);
    }

    /**
     * @tag 获取商圈列表
     * @author 邓永洪
     * @since 2018/7/25
     */
    @RequestMapping("/getRegSectionList")
    public ResponseJson getSectionList(@RequestBody BaseMapParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer regId = param.getInteger("regId");
        Integer sectionId = param.getInteger("sectionId");
        String sectionCode = param.getString("sectionCode");
        ErpFunSectionExample funSectionExample = new ErpFunSectionExample();
        funSectionExample.setShardCityId(cityId);
        ErpFunSectionExample.Criteria criteria = funSectionExample.createCriteria();
        criteria.andCityIdEqualTo(cityId.shortValue());
        if (regId != null) {
            criteria.andRegIdEqualTo(regId);
        }
        if (sectionId != null) {
            criteria.andSectionIdEqualTo(sectionId);
        }
        if (StringUtils.isNotBlank(sectionCode)) {
            criteria.andSectionCodeEqualTo(sectionCode);
        }
        criteria.andVertifyFlagEqualTo((byte) 1);
        List<ErpFunSection> erpFunSections = erpFunSectionMapper.selectByExample(funSectionExample);
        return ErpResponseJson.ok(erpFunSections);
    }

	/**
	 * @tag 获取门店分组列表
	 * @author 邓永洪
	 * @since 2018/7/25
	 */
	@ApiOperation("获取门店分组列表,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpFunDeptsGroupVo.class, message = "成功")})
	@RequestMapping("/getDeptGroupList")
	public ResponseJson getDeptGroupList(@RequestBody GetDeptGroupListParam param) {
		Operator operator = getOperator();
		Integer selfUserId = operator.getUserId();
		Integer selfGrId = operator.getGrId();
		Integer deptId = param.getDeptId();
		Integer countUser = param.getCountUser();
		List<ErpFunDeptsgroupDto> deptsgroups = erpFunDeptsgroupMapper.getGroupListByDeptId(operator.getCityId(), operator.getCompId(), deptId);
		String[] operIdArr = new String[] { "MANAGE_COMP_ORGANIZATION", "MANAGE_AREA_ORGANIZATION",
				"MANAGE_REG_ORGANIZATION", "MANAGE_DEPT_ORGANIZATION", "MANAGE_GROUP_ORGANIZATION" };
		ManageLevelVo manageLevelVo = userOpersControlller.judgeLevelByOperList(operator.getCityId(), selfUserId, 1000, operIdArr);
		Integer canOper = manageLevelVo.getCanOper();
		Integer operLevel = manageLevelVo.getOperLevel();
		if (canOper == 0) {
			operLevel = 6;
		}
		for (ErpFunDeptsgroupDto erpFunDeptsgroupDto : deptsgroups) {
			if(operLevel > 5 || (operLevel == 5 && selfGrId != null && !selfGrId.equals(erpFunDeptsgroupDto.getGrId()))){
				erpFunDeptsgroupDto.setGrContact("");
				erpFunDeptsgroupDto.setGrTele("");
			}
		}
		ErpFunDeptsGroupVo erpFunDeptsGroupVo = new ErpFunDeptsGroupVo();
		erpFunDeptsGroupVo.setFunDeptsgroupList(deptsgroups);
		if (countUser == null || countUser != 1) {
			return ErpResponseJson.ok(erpFunDeptsGroupVo);
		}
		// 统计分组人数
		List<Map<String, Integer>> countUserList = erpFunUsersMapper.countUserByGroup(operator.getCityId(),
				operator.getCompId(), deptId);
		Map<Integer, Map<String, Integer>> countUserMap = countUserList.stream()
				.collect(Collectors.toMap(map -> map.get("grId"), val -> val));
		deptsgroups.forEach(groupDto -> {
			Map<String, Integer> map = countUserMap.get(groupDto.getGrId());
			if (map != null) {
				groupDto.setCountUser(map.get("count"));
			} else {
				groupDto.setCountUser(0);
			}
		});
		return ErpResponseJson.ok(erpFunDeptsGroupVo);
	}

 
	/**
	 * 删除角色
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/8/2
	 */
	@ApiOperation("删除角色")
	@ApiResponses({@ApiResponse(code = 200,response = ErpResponseJson.class,message = "success")})
	@PostMapping("/deleteCompRoles")
	public ResponseJson deleteCompRoles(@RequestBody CompRolesParam param) {
		Integer autoId = param.getAutoId();
		String roleName = param.getRoleName();
		Integer compId=getOperator().getCompId();
		Integer cityId=getOperator().getCityId();
		String compNo=getOperator().getCompNo();
		ErpCompRoles erpCompRole=new ErpCompRoles();
		erpCompRole.setAutoId(autoId);
		erpCompRole.setShardCityId(cityId);
		ErpCompRoles erpCompRoles=erpCompRolesMapper.selectByPrimaryKey(erpCompRole);
		if (erpCompRoles==null){
			throw  new BusinessException("未找到该角色！");
		}
		int count = erpFunUsersMapper.countFunUsers(cityId,compId,erpCompRoles.getRoleId());
		if (count>0){
			AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(compNo);
			if(adminFunCompService.judgerIsFangjidi(adminFunComp.getCompId())){
				throw new BusinessException("已有员工使用此职级，请先更改此类员工职级后再删除！");
			}
			throw new BusinessException("已有员工使用此角色，请先更改此类员工角色后再删除！");
		}
        param.setCityId(cityId);
		param.setCompId(compId);
		param.setUserId(getOperator().getUserId());
		param.setDeptId(getOperator().getDeptId());
		erpCompRolesService.deleteCompRoles(param,autoId,erpCompRoles.getRoleName(),erpCompRoles.getRoleId());
		return ErpResponseJson.ok();
	}

    /**
     * 判断删除该角色是否在分润配置涉及到了其他角色的升降级
     * @return
     */
	@ApiOperation("删除角色前判断其他角色升降级是否牵涉该角色")
	@ApiResponses({@ApiResponse(code = 200,response = ErpResponseJson.class,message = "success")})
	@PostMapping("/judgeDelRole")
	public ResponseJson judgeDelRole(@RequestBody JudgeDelRoleParam param){
		String roleId = param.getRoleId();
		Integer compId=getOperator().getCompId();
		String compNo=getOperator().getCompNo();
		Integer cityId=getOperator().getCityId();
		Integer autoId = param.getAutoId();
		ErpCompRoles erpCompRole=new ErpCompRoles();
		erpCompRole.setAutoId(autoId);
		erpCompRole.setShardCityId(cityId);
		ErpCompRoles erpCompRoles=erpCompRolesMapper.selectByPrimaryKey(erpCompRole);
		AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(compNo);
		boolean fjd = adminFunCompService.judgerIsFangjidi(adminFunComp.getCompId());
		if (erpCompRoles==null){
			if(fjd){
				return ErpResponseJson.warn("未找到该职级！");
			}
			return ErpResponseJson.warn("未找到该角色！");
		}
		int count = erpFunUsersMapper.countFunUsers(cityId,compId,erpCompRoles.getRoleId());
		if (count>0){
			if(fjd){
				return ErpResponseJson.warn("已有员工使用此职级，请先更改此类员工职级后再删除！");
			}
			return ErpResponseJson.warn("已有员工使用此角色，请先更改此类员工角色后再删除！");
		}
		//1.低于2个职级应用时
		//该职级删除后，将关闭职级1、职级2的自动升级或降级功能！
		// 2.超过2个职级应用时增加‘等职级’
		//该职级删除后，将关闭职级1、职级2等职级的自动升级或降级功能！
			List<String> relevanceRoles = erpZxRoleConfigMapper.getRelevanceRole(cityId, compId, roleId);
			if(null != relevanceRoles && relevanceRoles.size() > 0){
				Integer num = 0;
				String roleNames = "";
				for (String relevanceRole : relevanceRoles) {
					ErpCompRoles role = erpCompRolesMapper.getByRoleId(cityId, compId, relevanceRole);
					roleNames += "、" + role.getRoleName();
					num++;
					if(num==2){
						break;
					}
				}
				roleNames = roleNames.substring(1);
				if(relevanceRoles.size() > 2){
					roleNames += "等职级";
				}
				return new ErpResponseJson(-999, "该职级删除后，将关闭"+roleNames+"的自动升级或降级功能！");
			}
		return ErpResponseJson.ok();
    }

    /**
     * @tag 编辑员工信息，网站部用
     * @author 邓永洪
     * @since 2018/7/25
     */
	@ApiOperation("新建片区信息,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpResponseJson.class, message = "成功")})
	@RequestMapping("/editUserInfo")
    @NotBlank({"userId", "archiveId"})
	@Deprecated
    public ResponseJson editUserInfo(@RequestBody EditUserInfoParam param) {
		//陈文超写
		if(true){
			throw new BuilderException("网站接口的业务已经移植到APP中，该接口弃用-2019-07-30");
		}
        Operator operator = getOperator();
        param.setCityId(operator.getCityId().shortValue());
        param.setCompId(operator.getCompId());
        param.setSelfUserId(operator.getUserId());
        Integer archiveId = param.getArchiveId();
        String userName = param.getUserName();
        Boolean userSexBool = param.getUserSex();
        Byte userSex = null;
        if (userSexBool != null) {
            userSex = (byte) (userSexBool ? 1 : 0);
        }
        if (StringUtils.isNotBlank(userName) || userSex != null) {
            AdminFunArchive funArchive = adminFunArchiveMapper.getArchiveById(archiveId);
            if (funArchive.getUserRight() == 1) {
                String oldUserName = funArchive.getUserName();
                Byte oldUserSex = funArchive.getUserSex();
                if (StringUtils.isNotBlank(userName) && !oldUserName.equals(userName)) {
                    throw new BusinessException("实名认证后不能修改基本信息！");
                }
                if (userSex != null && !oldUserSex.equals(userSex)) {
                    throw new BusinessException("实名认证后不能修改基本信息！");
                }
            }
        }
        erpFunUsersService.editUserInfo(new GeneralParam(operator), param);
        return ErpResponseJson.ok();
    }

    /**
     * @tag 获取用户权限列表，网站部用
     * @author 邓永洪
     * @since 2018/8/15
     */
    @PostMapping("/getUserOpers")
    public ResponseJson getUserOpers(@RequestBody BaseMapParam param) {
        Integer userId = param.getInteger("userId");
        Operator operator = getOperator();
//		String[] opers = new String[]{"MANAGE_AREA_ORGANIZATION",
//				"MANAGE_COMP_ORGANIZATION",
//				"MANAGE_DEPT_ORGANIZATION",
//				"MANAGE_GROUP_ORGANIZATION",
//				"MANAGE_REG_ORGANIZATION",
//				"ROLE_MANAGE"};
        ErpUserOpersExample userOpersExample = new ErpUserOpersExample();
        userOpersExample.setShardCityId(operator.getCityId());
        userOpersExample.createCriteria().andUserIdEqualTo(userId);
        List<ErpUserOpers> userOpers = erpUserOpersMapper.selectByExample(userOpersExample);
        return ErpResponseJson.ok(userOpers);
    }

	@ApiOperation("新建片区信息,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = InviteLinkVo.class, message = "成功")})
	@RequestMapping("/getInviteLink")
	public ResponseJson getInviteLink(@RequestBody BaseMapParam param) throws Exception{
		Operator operator = getOperator();
		String compNo = operator.getCompNo();
		Integer cityId = operator.getCityId();
		String userName = operator.getUserName();
		String compName = operator.getCompName();
//		String deptName = operator.getDeptName();
		String userSex = operator.getUserSex();
		Integer compId = operator.getCompId();
//		AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(compNo);
//        Byte isOpenFdd = adminFunComp.getIsOpenFdd();
        // 判断是否是玛雅房屋
//        String leaguesType = operator.getString("LEAGUES_TYPE");
        String leaguesType = operator.getAttribute("LEAGUES_TYPE")+"";
//		String erpWebUrl = "http://test3.haofang.net:11016/erpWeb/openApi/inviteRegist/"+"getCompInvite.htm?param=";
        String erpWebUrl = AppConfig.getErpWebUrl() + "openApi/inviteRegist/getCompInvite.htm?param=";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("cityId", cityId);
        paramMap.put("compId", compId);
        paramMap.put("compNo", compNo);
        // 优先判断房多多
//        paramMap.put("isFdd", isOpenFdd);

        if("0".equals(leaguesType)) {
            leaguesType = null;
        }
        paramMap.put("leaguesType", leaguesType);
        erpWebUrl += AESHelper.encode(JSON.toJSONString(paramMap));
        String s = UrlUtils.genShortUrl(erpWebUrl);
        if (StringUtils.isBlank(s) && StringUtils.isNotBlank(erpWebUrl)) {
            s = erpWebUrl;
        }
        Map<String, String> resMap = new HashMap<>();
        resMap.put("inviteLink", s);
		resMap.put("shareIcon", "http://img01-uat.m1200.com.cn/oss/online/nihao/2019/12/30/2b7da02045574e2cbb7961fdac47b21e.png");

		resMap.put("content", "房源搜索、一键群发、VR看房、房源微拍等，移动智能化房管系统帮您提升效率，月月拿销冠！");
		if("1".equals(userSex)){
			userSex = "先生";
		} else{
			userSex = "女士";
		}
		resMap.put("title", userName + userSex + "邀请您加入" + compName);
        return ErpResponseJson.ok(resMap);
    }

    public static void main(String[] args) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("cityId", 91);
        paramMap.put("compId", 65147);
        paramMap.put("compNo", "E2N0");
        try {
            String erpWebUrl = "http://erpweb.myfun7.com/erpWeb/openApi/inviteRegist/getCompInvite.htm?param=" + AESHelper.encode(JSON.toJSONString(paramMap));
            System.out.println(erpWebUrl);
        } catch (Exception e) {

        }
    }


	@ApiOperation("邀请注册接口")
	@ApiResponses(value = {
		@ApiResponse(code = Const.ResponseCode.SUCCESS,  message = "成功")
	})
	@ResponseBody
	@PostMapping("/addInviteUserInfo")
	public ResponseJson addInviteUserInfo(@RequestBody AddCompInviteRegistParam param) throws Exception {
        Operator operator = getOperator();
        //针对跨城管理公司需求：前端有传用前端的，没传就用会话的
        Integer cityId = operator.getCityId();
        if (null != param.getCityId()) {
			cityId = param.getCityId();
		}
        String compNo = operator.getCompNo();
        if (StringUtils.isNotBlank(param.getCompNo())) {
			compNo = param.getCompNo();
		}
        Integer compId = operator.getCompId();
        if (null != param.getCompId()) {
			compId = param.getCompId();
		}
        // 物业版门店经理的管理范围就是本店
        if (operator.getCompType() != null && operator.getCompType() == 5 && "BRANCH_MANAGER".equals(param.getUserPosition())) {
        	param.setRangeIds(String.valueOf(StringUtil.parseInteger(param.getDeptId(), 0)));
        }
        // 验证安全，别公司在职人员不能邀请
        AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByMobile(param.getUserMobile());
        if (null != adminFunArchive && 2 != adminFunArchive.getUserEdition()) {
            throw new BusinessException("该电话已经注册门店版，请更换号码！");
        }
		AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(compNo);
        if(null != param.getCurrentPId()){
			if(adminFunCompService.judgerIsFangjidi(adminFunComp.getCompId())){
				ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, param.getCurrentPId());
				if(null == erpFunUsers || null == erpFunUsers.getDeptId()){
					throw new BusinessException("团队管理人数据错误，请稍后重试或联系在线客服！");
				}
				if(!erpFunUsers.getDeptId().toString().equals(param.getDeptId().toString())){
					throw new BusinessException("所选组织与所选团队组织不一致！");
				}
			}
		}
		// 首先查询下待验证列表
        ErpFunUsersInvitedExample example = new ErpFunUsersInvitedExample();
        example.setShardCityId(cityId);
        example.createCriteria().andUserMobileEqualTo(param.getUserMobile()).andCompIdEqualTo(compId).andCompNoEqualTo(compNo).andCityIdEqualTo(cityId).andInviteStatusEqualTo((byte) 0);
        List<ErpFunUsersInvited> resList = erpFunUsersInvitedMapper.selectByExample(example);
        if (resList.size() > 0) {
            ErpFunUsersInvited erpFunUsersInvited = resList.get(0);
            ErpFunUsersInvited updatePo = new ErpFunUsersInvited();
            updatePo.setShardCityId(cityId);
            updatePo.setId(erpFunUsersInvited.getId());
            updatePo.setUpdateTime(new Date());
            updatePo.setInviteStatus((byte) 2);
            erpFunUsersInvitedMapper.updateByPrimaryKeySelective(updatePo);
        }
        ErpFunUsersInvited erpFunUsersInvited = new ErpFunUsersInvited();
		//**********************组织架构改版********************************

//		if (operator.newOrganizationType()) {       //zt组织机构
//			param.setRangeIds(null);// 先置空 后面统一处理
//		}
		if (param.getAreaId() == null  && !operator.newOrganizationType()) {
			ErpFunDepts funDepts = erpFunDeptsMapper.getByDeptId(cityId, param.getDeptId());
			param.setAreaId(funDepts.getAreaId());
		}
		//**********************组织架构改版********************************
		erpFunUsersInvited.setAreaId(0);
        erpFunUsersInvited.setRegId(0);
        erpFunUsersInvited.setCityId(cityId);
        erpFunUsersInvited.setCompId(compId);
        erpFunUsersInvited.setCompNo(compNo);
        erpFunUsersInvited.setDeptId(param.getDeptId());
        erpFunUsersInvited.setGrId(0);
        erpFunUsersInvited.setInviteStatus((byte) 0);
        erpFunUsersInvited.setRangeIds(param.getRangeIds());
        erpFunUsersInvited.setRangeType(param.getRangeType());
        erpFunUsersInvited.setServiceReg(param.getServiceReg());
        erpFunUsersInvited.setServiceZone(param.getServiceZone());
        erpFunUsersInvited.setUserMobile(param.getUserMobile());
        erpFunUsersInvited.setUserPosition(param.getUserPosition());
        erpFunUsersInvited.setUserSex(param.getUserSex());
        erpFunUsersInvited.setServiceZoneIds(param.getServiceZoneIds());
        erpFunUsersInvited.setShardCityId(cityId);
        erpFunUsersInvited.setCreateTime(new Date());
        erpFunUsersInvited.setUserName(param.getUserName());
        erpFunUsersInvited.setCreateUid(operator.getUserId());
        erpFunUsersInvited.setRoleLevelId(param.getRoleLevelId());
        erpFunUsersInvited.setCurrentPId(param.getCurrentPId());
		if (null != param.getOrganizationId() && param.getOrganizationId() == 0) {
			throw new BusinessException("部门选择有误");
		}
		erpFunUsersInvited.setOrganizationId(param.getOrganizationId());
//		ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, param.getOrganizationId());
		ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrganizationId(cityId, param.getOrganizationId());
		if (erpFunOrganization != null) {
			erpFunUsersInvited.setOrganizationPath(erpFunOrganization.getOrganizationPath());
		}
        erpFunUsersInvitedMapper.insertSelective(erpFunUsersInvited);
		HashMap<String, Object> resultMap = new HashMap<>();
		return ErpResponseJson.ok(resultMap);
    }

    /**
     * 设置某一门店为总部或设置某一总部门店为一般门店
     *
     * @return
     */
    @ApiOperation("设置某一门店为总部或取消总部门店")
    @ApiResponses(value = {@ApiResponse(code = 200, response = ErpResponseJson.class, message = "成功")})
    @PostMapping("/setOrCancleDeptHeadquarters")
    @NotBlank({"isDeptHeadquarters", "deptId"})
    public ErpResponseJson setOrCancleDeptHeadquarters(@RequestBody SetDeptHeadquartersParam param) {
        Integer cityId = getOperator().getCityId();
        erpFunDeptsService.setOrCancleDeptHeadquarters(cityId, param.getIsDeptHeadquarters(), param.getDeptId());
        return ErpResponseJson.ok();
    }

    @ApiOperation("获取大区详情,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpFunArea.class,  message = "成功") })
	@ResponseBody
	@PostMapping("/getAreaDetailInfo")
	public ErpResponseJson getAreaDetailInfo(@RequestBody GetAreaDetailInfoParam param){
		Operator operator = getOperator();
		Integer compId = operator.getCompId();
		Integer cityId = operator.getCityId();
		Integer areaId = param.getAreaId();
		if(null == areaId){
			return ErpResponseJson.ok();
		}
		ErpFunArea areaByAreaId = erpFunAreaMapper.getAreaByAreaId(cityId, compId, areaId);
		return ErpResponseJson.ok(areaByAreaId);
	}
	
	@ApiOperation("获取大区详情,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpFunRegionDto.class,  message = "成功") })
	@ResponseBody
	@PostMapping("/getRegionDetailInfo")
	public ErpResponseJson getRegionDetailInfo(@RequestBody GetRegionDetailInfoParam param){
		Operator operator = getOperator();
		Integer compId = operator.getCompId();
		Integer cityId = operator.getCityId();
		Integer regId = param.getRegId();
		if(null == regId){
			return ErpResponseJson.ok();
		}
		ErpFunRegion funRegion = erpFunRegionMapper.selectByRegId(cityId, compId, null, regId);
		if(null == funRegion){
			return ErpResponseJson.ok();
		}
		Integer areaId = funRegion.getAreaId();
		ErpFunRegionDto erpFunRegionDto = new ErpFunRegionDto();
		try {
			BeanUtil.copyObject(funRegion, erpFunRegionDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ErpFunArea erpFunArea = erpFunAreaMapper.getAreaByAreaId(cityId, compId, areaId);
		erpFunRegionDto.setAreaName(erpFunArea.getAreaName());
		return ErpResponseJson.ok(erpFunRegionDto);
	}
	
	@ApiOperation("获取大区详情,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpFunDeptsDto.class,  message = "成功") })
	@ResponseBody
	@PostMapping("/getDeptDetailInfo")
	public ErpResponseJson getDeptDetailInfo(@RequestBody GetDeptDetailInfoParam param){
		Operator operator = getOperator();
		Integer compId = operator.getCompId();
		Integer cityId = operator.getCityId();
		Integer deptId = param.getDeptId();
		if(null == deptId){
			return ErpResponseJson.ok();
		}
		ErpFunDepts erpFunDepts = erpFunDeptsMapper.getDeptByCompIdAndDeptId(cityId, compId, deptId);
		if(erpFunDepts == null){
			return ErpResponseJson.ok();
		}
		Integer regId = erpFunDepts.getRegId();
		Integer areaId = erpFunDepts.getAreaId();
		ErpFunDeptsDto erpFunDeptsDto = new ErpFunDeptsDto();
		BeanUtils.copyProperties(erpFunDepts, erpFunDeptsDto);
		ErpFunArea erpFunArea = erpFunAreaMapper.getAreaByAreaId(cityId, compId, areaId);
		ErpFunRegion erpFunRegion = erpFunRegionMapper.selectByRegId(cityId, compId, null, regId);
		erpFunDeptsDto.setRegionName(erpFunRegion.getRegName());
		erpFunDeptsDto.setAreaName(erpFunArea.getAreaName());

        String compNo = erpFunDepts.getCompNo();
        String deptNo = erpFunDepts.getDeptNo();
        AdminFunDepts dept = adminFunDeptsMapper.getDataByCompNoAndDeptNo(compNo, deptNo);
        if (dept != null) {
            Integer adminCompId = dept.getCompId();
            Integer adminDeptId = dept.getDeptId();

            AdminPropertyBuildMapExample adminPropertyBuildMapExample = new AdminPropertyBuildMapExample();
            adminPropertyBuildMapExample.createCriteria().andCompIdEqualTo(adminCompId).andDeptIdEqualTo(adminDeptId);
            List<AdminPropertyBuildMap> list = adminPropertyBuildMapMapper.selectByExample(adminPropertyBuildMapExample);

            if (CollectionUtils.isNotEmpty(list)) {
                AdminPropertyBuildMap adminPropertyBuildMap = list.get(0);
                Integer archiveId = adminPropertyBuildMap.getArchiveId();
                // 有可能 archiveId 对应的这个项目管理员已经被注销, 这个地方要取门店经理
                ErpFunUsers funUsers = erpFunUsersMapper.getUserInfoByArchiveId(cityId, archiveId);

                if (funUsers != null && funUsers.getCompId().equals(compId)) {
                    erpFunDeptsDto.setBuildManager(funUsers.getUserId());
                } else if (funUsers == null) {
                    ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
                    erpFunUsersExample.setShardCityId(cityId);
                    erpFunUsersExample.createCriteria().andCompIdEqualTo(compId).andDeptIdEqualTo(deptId)
                            .andUserWriteoffEqualTo(false).andUserPositionEqualTo("BRANCH_MANAGER");
                    // 保证取出来的门店经理是按照USER_ID排的第一个, 和 mobileWeb(getBuildAndPropertyManagerList接口, erpWeb getDeptDetailInfo接口取的门店经理一致)
                    erpFunUsersExample.setOrderByClause("USER_ID");
                    List<ErpFunUsers> userList = erpFunUsersMapper.selectByExample(erpFunUsersExample);
                    if (CollectionUtils.isNotEmpty(userList)) {
                        ErpFunUsers users = userList.get(0);
                        erpFunDeptsDto.setBuildManager(users.getUserId());
                    }
                }
            }
        }

		return ErpResponseJson.ok(erpFunDeptsDto);
	}
	
	@ApiOperation("数据移交临时请求接口,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ResponseJson.class,  message = "成功") })
	@ResponseBody
	@PostMapping("/transDataForChois")
	public ResponseJson transDataForChois(@RequestBody TransDataForChoisParam param){
		Operator operator = getOperator();
		Map<String, Object> data = new HashMap<>(16);
		data.put("CITY_ID", operator.getCityId());
		data.put("USER_MOBILE", operator.getUserMobile());
		data.put("ARCHIVE_ID", operator.getArchiveId());
		data.put("CLIENTKEY", operator.getClientKey());
		data.put("TRANS_DATA_TYPE", param.getTransDataType());
		data.put("SRC_USER_ID", param.getSrcUserId());
		data.put("TRANS_RESON", param.getTransReson());
		data.put("ACCEPT_DEPT_IDS", param.getAcceptDeptIds());
		data.put("ACCEPT_USER_IDS", param.getAcceptUserIds());
		data.put("ACCEPT_GR_ID", param.getAcceptGrId());
		data.put("SRC_DEPT_ID", param.getSrcDeptId());
//		String url = AppConfig.getErpDomainRoot() + "/hftWebService/webservices";
		HttpUtil.postToWebService(AppConfig.gethftWebServiceDomainRoot() + "/webservices", "transDataForChois", data);
		HashMap<String, Object> resultMap = new HashMap<>();
		return ErpResponseJson.ok(resultMap);
	}
	
	@ApiOperation("获取自己角色的seqNo和别编辑人的seqNo,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = GetEditedUserSeqNoVo.class,  message = "成功") })
	@ResponseBody
	@PostMapping("/getEditedUserSeqNo")
	public ResponseJson getEditedUserSeqNo(@RequestBody GetEditedUserSeqNoParam param){
		HashMap<String, Object> resultMap = new HashMap<>();
		Operator operator = getOperator();
		Integer compId = operator.getCompId();
		Integer cityId = operator.getCityId();
		Integer userId = param.getUserId();
		ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(cityId, userId);
		if(null == erpFunUsers){
			return ErpResponseJson.ok(resultMap);
		}
		if("GENERAL_MANAGER".equals(erpFunUsers.getUserPosition())){
			ErpMarketVirtualGeneralExample erpMarketVirtualGeneralExample = new ErpMarketVirtualGeneralExample();
			erpMarketVirtualGeneralExample.createCriteria().andCityIdEqualTo(cityId).andCompIdEqualTo(compId).andUserIdEqualTo(userId);
			erpMarketVirtualGeneralExample.setShardCityId(cityId);
			Integer count = erpMarketVirtualGeneralMapper.countByExample(erpMarketVirtualGeneralExample);
			if(count > 0){
				resultMap.put("generalFlag", 0);
			} else {
				resultMap.put("generalFlag", 1);
			}
		}
		ErpCompRoles aimCompRoles = erpCompRolesMapper.getByRoleId(cityId, compId, erpFunUsers.getUserPosition());
		String userPosition = operator.getUserPosition();
		ErpCompRoles selfCompRoles = erpCompRolesMapper.getByRoleId(cityId, compId, userPosition);
		resultMap.put("selfSeqNo", selfCompRoles.getSeqNo());
		resultMap.put("aimSeqNo", aimCompRoles.getSeqNo());
		return ErpResponseJson.ok(resultMap);
	}
	
	@ApiOperation("ERP中新增门店支持删除,需求:9416，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ResponseJson.class,  message = "成功") })
	@ResponseBody
	@PostMapping("/deletePaymentFailureDept")
	public ResponseJson deletePaymentFailureDept(@RequestBody DeletePaymentFailureDeptParam param){
		Integer deptId = param.getDeptId();
		ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(getOperator().getCityId(), deptId);
		if(null == erpFunDepts || StringUtil.isBlank(erpFunDepts.getDeptName())){
			throw new BusinessException("门店信息错误,请联系客服");
		}
		AdminFunDeptsDto adminFunDept = adminFunDeptsMapper.getDataByCompNoAndDeptNo(erpFunDepts.getCompNo(), erpFunDepts.getDeptNo());
		Integer adminDeptId = adminFunDept.getDeptId();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("deptId", adminDeptId);
		HttpUtil.post(AppConfig.getCrmWebUrl() + "/crmOpenApi/deptsManage/deleteErpAddDept", paramMap);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 组织机构中-新增职级功能
	 * @Package com.myfun.erpWeb.managecenter.sysmanager 
	 * @author 陈文超   
	 * @throws Exception 
	 * @date 2019年7月30日 下午3:57:05
	 */
	@ApiOperation("组织机构中-新增和更新职级功能，需求:10258，作者:陈文超")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpCompRolesVoListVO.class,  message = "成功") })
	@ResponseBody
	@PostMapping("/createOrUpdateRoleLevel")
	public ResponseJson createOrUpdateRoleLevel(@RequestBody RoleLevelListParam paramList) throws Exception{
		String repeatTips = "同一角色下的职级名称不能重复！";
		List<RoleLevelParam> roleLevelList = paramList.getRoleLevelList();
		if(roleLevelList == null || roleLevelList.isEmpty()){
			return ErpResponseJson.ok();
		}
		
		//集合中的roleId都一样
		String roleId = roleLevelList.get(0).getRoleId();
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		
		List<String> sameNames = new ArrayList<String>();
		for(RoleLevelParam tmp : roleLevelList){
			tmp.setRoleLevelName(StringHelper.replaceAll(tmp.getRoleLevelName(), " ", ""));
			if(StringUtil.isBlank(tmp.getRoleLevelName())){
				throw new BusinessException("职级名称不能为空");
			}
			if(sameNames.contains(tmp.getRoleLevelName())){
				throw new BusinessException(repeatTips);
			}
			sameNames.add(tmp.getRoleLevelName());
		}
		
		//与老数据判断重复
		ErpFunRoleLevelsExample roleLevelExample = new ErpFunRoleLevelsExample();
		roleLevelExample.setShardCityId(cityId);
		roleLevelExample.createCriteria().andRoleIdEqualTo(roleId)
										 .andCompIdEqualTo(compId)
										 .andRoleLevelStatusEqualTo((byte)1);
		List<ErpFunRoleLevels> tmpList = erpFunRoleLevelsMapper.selectByExample(roleLevelExample);
		if(tmpList != null && tmpList.size() > 0){
			for(ErpFunRoleLevels tmp : tmpList){
				String roleLevelName = tmp.getRoleLevelName();
				Integer roleLevelId = tmp.getRoleLevelId();
				for(RoleLevelParam tmpInner : roleLevelList){
					String innerLevelName = tmpInner.getRoleLevelName();
					Integer innerRoleLevelId = tmpInner.getRoleLevelId();
					//名称不能重复，通过ID排除自己，创建时innerRoleLevelId可能为null
					if(innerLevelName.equals(roleLevelName) 
							&& !roleLevelId.equals(innerRoleLevelId)){
						throw new BusinessException(repeatTips);
					}
				}
			}
		}
		
		//添加和修改职级
		erpFunRoleLevelsService.addOrEditRoleLevelData(cityId, compId, roleId, roleLevelList);
		
		roleLevelExample = new ErpFunRoleLevelsExample();
		roleLevelExample.setShardCityId(cityId);
		roleLevelExample.setOrderByClause("SEQ_NO asc");
		roleLevelExample.createCriteria().andRoleIdEqualTo(roleId).andCompIdEqualTo(compId).andRoleLevelStatusEqualTo((byte) 1);
		List<ErpFunRoleLevels> erpFunRoleLevelList = erpFunRoleLevelsMapper.selectByExample(roleLevelExample);
		List<ErpCompRoleLevelsVO> erpCompRoleLevelsVOList = new ArrayList<>();
		for (ErpFunRoleLevels erpFunRoleLevel : erpFunRoleLevelList) {
			ErpCompRoleLevelsVO compRoleLevelsVO = PoConverterToView.convertPoToVo(erpFunRoleLevel, ErpCompRoleLevelsVO.class);
			erpCompRoleLevelsVOList.add(compRoleLevelsVO);
		}
		
		ErpCompRolesVoListVO voResult = new ErpCompRolesVoListVO();
		voResult.setCompRoleLevelList(erpCompRoleLevelsVOList);
		return ErpResponseJson.ok(voResult);
	}
	
	/**
	 * 组织机构中-删除职级功能
	 * @Package com.myfun.erpWeb.managecenter.sysmanager 
	 * @author 陈文超   
	 * @date 2019年7月30日 下午3:57:30
	 */
	@ApiOperation("组织机构中-删除职级功能，需求:10258，作者:陈文超")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ResponseJson.class,  message = "成功") })
	@ResponseBody
	@PostMapping("/deleteRoleLevel")
	@NotBlank({"roleLevelId"})
	public ResponseJson deleteRoleLevel(@RequestBody RoleLevelParam param){
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		Integer roleLevelId = param.getRoleLevelId();
		
		String tips = "已有员工使用此职级，请先更改此类员工职级后再删除！";
		ErpFunUsersExample roleLevelExist = new ErpFunUsersExample();
		roleLevelExist.setShardCityId(cityId);
		roleLevelExist.createCriteria().andCompIdEqualTo(compId).andUserWriteoffEqualTo(false).andRoleLevelIdEqualTo(roleLevelId);
		int i = erpFunUsersMapper.countByExample(roleLevelExist);
		if(i > 0){
			throw new BusinessException(tips);
		}
		
		ErpFunRoleLevels record = new ErpFunRoleLevels();
		record.setRoleLevelStatus((byte) 0);
		ErpFunRoleLevelsExample example = new ErpFunRoleLevelsExample();
		example.setShardCityId(cityId);
		example.createCriteria().andCompIdEqualTo(compId).andRoleLevelIdEqualTo(roleLevelId).andRoleLevelStatusEqualTo((byte) 1);
		//有效才更新
		erpFunRoleLevelsMapper.updateByExampleSelective(record, example);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 修改员工职级
	 * @Package com.myfun.erpWeb.managecenter.sysmanager 
	 * @author 陈文超   
	 * @date 2019年7月30日 下午4:03:47
	 */
    @ApiOperation("修改员工职级")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/updateUserRoleLevel")
    @NotBlank({"userId", "roleLevelId"})
    public ErpResponseJson updateUserRoleLevel(@Valid @RequestBody UpdateUserRoleLevelParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        Integer currentUserId = operator.getUserId();
        Integer userId = param.getUserId();
        Integer roleLevelId = param.getRoleLevelId();
        
		ErpFunRoleLevelsExample example = new ErpFunRoleLevelsExample();
		example.setShardCityId(cityId);
		example.createCriteria().andCompIdEqualTo(compId).andRoleLevelIdEqualTo(roleLevelId).andRoleLevelStatusEqualTo((byte) 1);
		int i = erpFunRoleLevelsMapper.countByExample(example);
		if(i <= 0){
			throw new BusinessException("您所设置的职级已被删除，请重试！");
		}
        
        erpFunUsersService.updateUserRoleLevel(cityId, compId, userId, roleLevelId, currentUserId);
        return ErpResponseJson.ok();
    }
    
    /**
	 * 删除一个薪资配置中的职级
	 * @Package com.myfun.erpWeb.managecenter.sysmanager 
	 * @author 陈文超   
	 * @date 2019年7月30日 下午4:03:47
	 */
    @ApiOperation("删除一个薪资配置中的职级")
    @ApiResponses(value = {
    		@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/deleteWageRoleLevel")
    @NotBlank({"wageConfigId"})
    public ErpResponseJson deleteWageRoleLevel(@Valid @RequestBody DeleteRoleLevelWageParam param) {
    	
    	Integer oldWageConfigId = param.getWageConfigId();
    	if(param.getWageConfigId() == null || param.getWageConfigId() <= 0){
    		return ErpResponseJson.ok(); 
    	}
    	
    	Integer compId = getOperator().getCompId();
    	Integer cityId = getOperator().getCityId();
    	ErpFunRoleWageConfig recordInfo = new ErpFunRoleWageConfig();
    	recordInfo.setShardCityId(cityId);
    	recordInfo.setId(param.getWageConfigId());
    	ErpFunRoleWageConfig queryRecord = erpFunRoleWageConfigMapper.selectByPrimaryKey(recordInfo);
    	if(queryRecord == null){
    		return ErpResponseJson.ok();
    	}
    	
    	String baseRoleId = queryRecord.getRoleId();
    	Integer roleLevel = queryRecord.getRoleLevelId();
    	if(roleLevel == null || roleLevel == 0){
    		//该判断防止误删除薪资的基本配置
    		return ErpResponseJson.ok(); 
    	}
    	
    	String assessmentMonth = queryRecord.getAssessmentMonth();
		ErpFunRoleWageConfigExample roleWageConfigExample = new ErpFunRoleWageConfigExample();
		roleWageConfigExample.setShardCityId(cityId);
		roleWageConfigExample.createCriteria().andCompIdEqualTo(compId)
												.andRoleLevelIdEqualTo(0)
												.andRoleIdEqualTo(baseRoleId)
												.andAssessmentMonthEqualTo(assessmentMonth)
												.andIsCheckEqualTo((byte) 1);
		//查询当月的基础配置，基础配置不为空且配置数据有效的情况下，有且只有一个条/月-陈文超
		List<ErpFunRoleWageConfig> erpFunRoleWageConfigs = erpFunRoleWageConfigMapper.selectByExample(roleWageConfigExample);
		if(erpFunRoleWageConfigs.isEmpty() || erpFunRoleWageConfigs.size() > 1){
			//该判断防止误删除薪资的基本配置
			throw new BusinessException("删除职级对应的薪资配置时出错，请重试！");
		}
		
		Integer baseWageConfigId = erpFunRoleWageConfigs.get(0).getId();
    	ErpFunRoleWageConfigExample example = new ErpFunRoleWageConfigExample();
    	example.setShardCityId(cityId);
    	example.createCriteria().andCompIdEqualTo(compId).andIdEqualTo(param.getWageConfigId());
    	ErpFunRoleWageConfig record = new ErpFunRoleWageConfig();
    	record.setIsCheck((byte) 0);
    	if (erpFunRoleWageConfigMapper.updateByExampleSelective(record, example) > 0){
    		//将原有数据更新到基本薪资配置上
    		erpFunRoleWageConfigService.deleteWageRoleLevelAfterInitBase(oldWageConfigId, baseWageConfigId, compId, cityId, baseRoleId, roleLevel);
    	}
    	
        return ErpResponseJson.ok();
    }
    
    /**
     * 职级配置列表
     */
    @ApiOperation("职级配置列表")
    @ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = LevelInformationVo.class, message = "成功")})
    @PostMapping("/levelInformation")
    public ErpResponseJson levelInformation(){
    	LevelInformationVo levelInformationVo = new LevelInformationVo();
    	Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        //当前月份
        String assessmentMonth = DateUtil.DateToString(new Date(),"yyyy-MM");
        //公司角色
        List<GetRoleByCompIdVo> compRoles = erpCompRolesMapper.getRoleByCompId(cityId,compId);
        levelInformationVo.setCompRoles(compRoles);
        //公司角色权限
        List<GetCompRoleInfoVo> compRoleOpers = new ArrayList<>();
        //循环取每个角色的权限，每个角色只取4个
        for (GetRoleByCompIdVo getRoleByCompIdVo : compRoles) {
        	List<GetCompRoleInfoVo> roleOpers = erpCompRoleOpersMapper.getTOP4RoleOpers(cityId,getRoleByCompIdVo.getRoleId());
        	compRoleOpers.addAll(0,roleOpers);
		}
        levelInformationVo.setCompRoleOpers(compRoleOpers);
        //薪资
        List<GetCompRoleWageInfoVo> compRoleWage = erpFunRoleWageConfigMapper.getCompRoleWageInfo(cityId,compId,assessmentMonth);
        levelInformationVo.setCompRoleWage(compRoleWage);
        //提成
        List<GetCompRoleCountWageVo> compRoleCountWage = erpFunRoleWageConfigMapper.getCompRoleCountWage(cityId,compId,assessmentMonth);
        levelInformationVo.setCompRoleCountWage(compRoleCountWage);
        return ErpResponseJson.ok(levelInformationVo);
        
    }

    @ApiOperation("公司未注册员工的角色")
    @ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = GetCompNotInviteUserRoleVo.class, message = "成功")})
    @PostMapping("/compNotInviteUserRole")
    public ErpResponseJson compNotInviteUserRole(){
    	Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        //获取公司未注销的员工
        List<GetCompNotInviteUserRoleVo> compUserRoles = erpFunUsersMapper.getCompUserRole(cityId,compId);
        //获取邀请验证未验证的人员
		List<GetCompNotInviteUserRoleVo> notConsentUsers = erpFunUsersInvitedMapper.getNotConsentUser(cityId,compId);
		if(null != notConsentUsers || notConsentUsers.size() > 0){
			compUserRoles.addAll(notConsentUsers);
		}
        return ErpResponseJson.ok(compUserRoles);
    }
    
    
    
    @ApiOperation("查询公司员工")
    @ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = GetCompNotInviteUserRoleVo.class, message = "成功")})
    @PostMapping("/findUser")
    public ErpResponseJson findUser(@RequestBody FindUserParam param){
    	Operator operator = getOperator();
    	Integer cityId = operator.getCityId();
    	if (null != param.getCityId()) {
			cityId = param.getCityId();
		}
    	Integer compId = operator.getCompId();
    	if (null != param.getCompId()) {
			compId = param.getCompId();
		}
    	List<GetAllCompUserVo> allCompUserVos = erpFunUsersMapper.getAllCompUser(cityId,compId,param.getUserName(),param.getRoleId());
    	return ErpResponseJson.ok(allCompUserVos);
    }
    
    @ApiOperation("查询分享注册地址")
    @ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = GetCompNotInviteUserRoleVo.class, message = "成功")})
    @PostMapping("/shareRegisterUrl")
    public ErpResponseJson shareRegisterUrl(){
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer userId = operator.getUserId();
        ShareRegisterUrlVo registerUrlVo = new ShareRegisterUrlVo();
        long time = System.currentTimeMillis();
        registerUrlVo.setShareRegisterUrl(AppConfig.getErpWebUrl() + "openApi/inviteRegist/fjdShareLogin?cityId=" + cityId +"&userId=" + userId + "&time=" + time);
        return ErpResponseJson.ok(registerUrlVo);
    }

    @ApiOperation("修改是否第一次登陆")
    @ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = GetCompNotInviteUserRoleVo.class, message = "成功")})
    @PostMapping("/changeFirstIn")
    public ErpResponseJson changeFirstIn(){
        Operator operator = getOperator();
        Integer adminCompId = operator.getAdminCompId();
        adminFunCompMapper.updateByCompFirstIn(adminCompId,1);
    	return ErpResponseJson.ok();
    }
    

 	@ApiOperation("房基地两端-权限配置与角色配置区分：查询权限模板列表， 需求:11167，作者:陈峰")
 	@ApiResponses(value = {@ApiResponse(code = 200, response = GetPermissionTemplateListVO.class, message = "成功")})
     @RequestMapping("/getPermissionTemplateList")
     @ResponseBody
 	public ResponseJson getPermissionTemplateList() {
 		Operator operator = getOperator();
 		Integer cityId = operator.getCityId();
 		Integer compId = operator.getCompId();
 		ErpFunCompPermissionTemplateExample erpFunCompPermissionTemplateExample = new ErpFunCompPermissionTemplateExample();
 		erpFunCompPermissionTemplateExample.setShardCityId(cityId);
 		erpFunCompPermissionTemplateExample.setOrderByClause("CREATION_TIME");
 		erpFunCompPermissionTemplateExample.createCriteria().andCompIdEqualTo(compId).andIsDelEqualTo(Byte.valueOf("0"));
 		
 		List<ErpFunCompPermissionTemplate> erpFunCompPermissionTemplateList = erpFunCompPermissionTemplateMapper.selectByExample(erpFunCompPermissionTemplateExample);
 		GetPermissionTemplateListVO getPermissionTemplateListVO = new GetPermissionTemplateListVO();
 		if (erpFunCompPermissionTemplateList.isEmpty()) {
 			getPermissionTemplateListVO.setList(Collections.emptyList());
 		} else {
 			List<PermissionTemplateVO> list = new ArrayList<PermissionTemplateVO>();
 			erpFunCompPermissionTemplateList.stream().forEach(a -> {
 				PermissionTemplateVO permissionTemplateVO = new PermissionTemplateVO();
 				permissionTemplateVO.setPermissionTemplateId(a.getId());
 				permissionTemplateVO.setPermissionTemplateName(a.getPermissionTemplateName());
 				list.add(permissionTemplateVO);
 			});
 			getPermissionTemplateListVO.setList(list);
 		}
 		return ErpResponseJson.ok(getPermissionTemplateListVO);
 	}
 	
 	@ApiOperation("房基地两端-权限配置与角色配置区分：新增或编辑权限模板（增加、修改权限模板名字）， 需求:11167，作者:陈峰")
 	@ApiResponses(value = {@ApiResponse(code = 200, response = CreatePermissionTemplateVO.class, message = "成功")})
     @RequestMapping("/createOrUpdatePermissionTemplate")
     @ResponseBody
     @NotBlank({"permissionTemplateName"})
 	public ResponseJson createOrUpdatePermissionTemplate(@RequestBody CreateOrUpdatePermissionTemplateParam param) {
 		Operator operator = getOperator();
 		Integer cityId = operator.getCityId();
 		Integer compId = operator.getCompId();
 		
 		Integer permissionTemplateId = param.getPermissionTemplateId();
 		String permissionTemplateName = param.getPermissionTemplateName();
 		
 		ErpFunCompPermissionTemplateExample erpFunCompPermissionTemplateExample = new ErpFunCompPermissionTemplateExample();
 		erpFunCompPermissionTemplateExample.setShardCityId(cityId);
 		erpFunCompPermissionTemplateExample.createCriteria().andCompIdEqualTo(compId).andPermissionTemplateNameEqualTo(permissionTemplateName).andIsDelEqualTo(Byte.valueOf("0"));
 		int useCount = erpFunCompPermissionTemplateMapper.countByExample(erpFunCompPermissionTemplateExample);
 		if (useCount > 0) {
 			throw new BusinessException("该权限模板名称已经存在");
 		}
 		
 		if (null != permissionTemplateId) {// 权限模板id不为空，表示是修改权限模板名字
 			ErpFunCompPermissionTemplate erpFunCompPermissionTemplate = new ErpFunCompPermissionTemplate();
 			erpFunCompPermissionTemplate.setShardCityId(cityId);
 			erpFunCompPermissionTemplate.setId(permissionTemplateId);
 			erpFunCompPermissionTemplate.setPermissionTemplateName(permissionTemplateName);
 			erpFunCompPermissionTemplate.setUpdateTime(DateTimeHelper.formatDateTimetoString(new Date(), DateTimeHelper.FMT_yyyyMMddHHmmss));
 			erpFunCompPermissionTemplateMapper.updateByPrimaryKeySelective(erpFunCompPermissionTemplate);
 		} else {
 			ErpFunCompPermissionTemplate erpFunCompPermissionTemplate = new ErpFunCompPermissionTemplate();
 			erpFunCompPermissionTemplate.setShardCityId(cityId);
 			erpFunCompPermissionTemplate.setCompId(compId);
 			erpFunCompPermissionTemplate.setCreationTime(DateTimeHelper.formatDateTimetoString(new Date(), DateTimeHelper.FMT_yyyyMMddHHmmss));
 			erpFunCompPermissionTemplate.setIsDel(Byte.valueOf("0"));
 			erpFunCompPermissionTemplate.setPermissionTemplateName(permissionTemplateName);
 			erpFunCompPermissionTemplateMapper.insertSelective(erpFunCompPermissionTemplate);
 			CreatePermissionTemplateVO createPermissionTemplateVO = new CreatePermissionTemplateVO();
 			createPermissionTemplateVO.setPermissionTemplateId(erpFunCompPermissionTemplate.getId());
 			return ErpResponseJson.ok(createPermissionTemplateVO);
 		}
 		return ErpResponseJson.ok();
 	}
 	
 	@ApiOperation("房基地两端-权限配置与角色配置区分：删除权限模板， 需求:11167，作者:陈峰")
 	@ApiResponses(value = {@ApiResponse(code = 200, message = "成功")})
     @RequestMapping("/deletePermissionTemplate")
     @ResponseBody
 	public ResponseJson deletePermissionTemplate(@RequestBody @Valid DeletePermissionTemplateParam param) {
 		Operator operator = getOperator();
 		Integer cityId = operator.getCityId();
 		Integer compId = operator.getCompId();
 		
 		Integer permissionTemplateId = param.getPermissionTemplateId();
 		
 		ErpFunCompRolesPermissionTemplateRelateExample erpFunCompRolesPermissionTemplateRelateExample = new ErpFunCompRolesPermissionTemplateRelateExample();
 		erpFunCompRolesPermissionTemplateRelateExample.setShardCityId(cityId);
 		erpFunCompRolesPermissionTemplateRelateExample.createCriteria().andCompIdEqualTo(compId).andTemplateIdEqualTo(permissionTemplateId);
 		int useCount = erpFunCompRolesPermissionTemplateRelateMapper.countByExample(erpFunCompRolesPermissionTemplateRelateExample);
 		if (useCount > 0) {
 			List<ErpFunCompRolesPermissionTemplateRelate> relateList = erpFunCompRolesPermissionTemplateRelateMapper.selectByExample(erpFunCompRolesPermissionTemplateRelateExample);
 			List<String> roleIdList = relateList.stream().map(ErpFunCompRolesPermissionTemplateRelate :: getRoleId).collect(Collectors.toList());
 			ErpCompRolesExample erpCompRolesExample = new ErpCompRolesExample();
 			erpCompRolesExample.setShardCityId(cityId);
 			erpCompRolesExample.createCriteria().andCompIdEqualTo(compId).andIsDelEqualTo(Byte.valueOf("0")).andRoleIdIn(roleIdList);
 			
 			int enabledRoleCount = erpCompRolesMapper.countByExample(erpCompRolesExample);
 			if (enabledRoleCount > 0) {
 				throw new BusinessException("此权限模板正在使用中");
 			}
 		}
 		ErpFunCompPermissionTemplate erpFunCompPermissionTemplate = new ErpFunCompPermissionTemplate();
 		erpFunCompPermissionTemplate.setShardCityId(cityId);
 		erpFunCompPermissionTemplate.setId(permissionTemplateId);
 		erpFunCompPermissionTemplate.setIsDel(Byte.valueOf("1"));
 		erpFunCompPermissionTemplate.setUpdateTime(DateTimeHelper.formatDateTimetoString(new Date(), DateTimeHelper.FMT_yyyyMMddHHmmss));
 		erpFunCompPermissionTemplateMapper.updateByPrimaryKeySelective(erpFunCompPermissionTemplate);
 		return ErpResponseJson.ok();
 	}
}
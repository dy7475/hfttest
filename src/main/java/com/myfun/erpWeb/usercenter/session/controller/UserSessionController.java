package com.myfun.erpWeb.usercenter.session.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.extension.framework.codis.util.CacheUtil;
import com.myfun.erpWeb.common.vo.OrganizationDefinitionVO;
import com.myfun.erpWeb.homepage.vo.AppAchieveMonthStatisticsRankVo;
import com.myfun.erpWeb.usercenter.session.param.LoginParam;
import com.myfun.erpWeb.usercenter.session.param.SwitchCompLoginParam;
import com.myfun.erpWeb.usercenter.session.vo.AppLoginVo;
import com.myfun.erpWeb.usercenter.session.vo.LoginLockVO;
import com.myfun.erpWeb.usercenter.session.vo.PerLoginVo;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminAppLoginMapper;
import com.myfun.repository.admindb.dao.AdminCompGiftCoinRecordMapper;
import com.myfun.repository.admindb.dao.AdminCrmUserMapper;
import com.myfun.repository.admindb.dao.AdminCustomLeaguesMapper;
import com.myfun.repository.admindb.dao.AdminCustomLeaguesSkinModelMapper;
import com.myfun.repository.admindb.dao.AdminFddCityMapper;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dao.AdminFunCityMapper;
import com.myfun.repository.admindb.dao.AdminFunCompJoinMapper;
import com.myfun.repository.admindb.dao.AdminFunCompMapper;
import com.myfun.repository.admindb.dao.AdminFunDeptsActivityPaidMapper;
import com.myfun.repository.admindb.dao.AdminFunDeptsMapper;
import com.myfun.repository.admindb.dao.AdminFunErpUserGuideMapper;
import com.myfun.repository.admindb.dao.AdminFunMacMapper;
import com.myfun.repository.admindb.dao.AdminFunProvinceMapper;
import com.myfun.repository.admindb.dao.AdminFunShareCompMapper;
import com.myfun.repository.admindb.dao.AdminFunUserAccountMapper;
import com.myfun.repository.admindb.dao.AdminKjlCityRelaMapper;
import com.myfun.repository.admindb.dao.AdminSysParaMapper;
import com.myfun.repository.admindb.dao.AdminYouBorkerArchiveMapper;
import com.myfun.repository.admindb.dao.AdminZfbRentHouseCityMapper;
import com.myfun.repository.admindb.dto.AdminFunDeptsDto;
import com.myfun.repository.admindb.po.AdminAppLogin;
import com.myfun.repository.admindb.po.AdminCompGiftCoinRecordExample;
import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.admindb.po.AdminFddCity;
import com.myfun.repository.admindb.po.AdminFddCityExample;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.admindb.po.AdminFunComp;
import com.myfun.repository.admindb.po.AdminFunCompJoin;
import com.myfun.repository.admindb.po.AdminFunDepts;
import com.myfun.repository.admindb.po.AdminFunDeptsActivityPaid;
import com.myfun.repository.admindb.po.AdminFunDeptsActivityPaidExample;
import com.myfun.repository.admindb.po.AdminFunMac;
import com.myfun.repository.admindb.po.AdminFunProvince;
import com.myfun.repository.admindb.po.AdminFunShareComp;
import com.myfun.repository.admindb.po.AdminFunUserAccount;
import com.myfun.repository.admindb.po.AdminKjlCityRela;
import com.myfun.repository.admindb.po.AdminSysPara;
import com.myfun.repository.admindb.po.AdminYouBorkerArchive;
import com.myfun.repository.admindb.po.AdminZfbRentHouseCityExample;
import com.myfun.repository.agencydb.dao.AgencyBuildingInfoMapper;
import com.myfun.repository.agencydb.dao.AgencySysParaMapper;
import com.myfun.repository.erpdb.dao.ErpAttendanceMapper;
import com.myfun.repository.erpdb.dao.ErpBussinessTypePlotSwitchMapper;
import com.myfun.repository.erpdb.dao.ErpCompRolesMapper;
import com.myfun.repository.erpdb.dao.ErpFunCompMapper;
import com.myfun.repository.erpdb.dao.ErpFunCrossCompStatusMapper;
import com.myfun.repository.erpdb.dao.ErpFunCrossCompUserOperMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsgroupMapper;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunOrganizationDefinitionMapper;
import com.myfun.repository.erpdb.dao.ErpFunOrganizationMapper;
import com.myfun.repository.erpdb.dao.ErpFunPartnerMapper;
import com.myfun.repository.erpdb.dao.ErpFunPrologsMapper;
import com.myfun.repository.erpdb.dao.ErpFunRegMapper;
import com.myfun.repository.erpdb.dao.ErpFunRegsectionControlMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.dao.ErpFunSectionMapper;
import com.myfun.repository.erpdb.dao.ErpFunUserManageRangeMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpMarketVirtualGeneralMapper;
import com.myfun.repository.erpdb.dao.ErpSysParaMapper;
import com.myfun.repository.erpdb.dao.ErpUserOpersChangeCityMapper;
import com.myfun.repository.erpdb.dao.ErpUserOpersMapper;
import com.myfun.repository.erpdb.dto.ErpUserOpersDto;
import com.myfun.repository.erpdb.po.ErpAttendanceExample;
import com.myfun.repository.erpdb.po.ErpBussinessTypePlotSwitch;
import com.myfun.repository.erpdb.po.ErpBussinessTypePlotSwitchExample;
import com.myfun.repository.erpdb.po.ErpCompRoles;
import com.myfun.repository.erpdb.po.ErpFunComp;
import com.myfun.repository.erpdb.po.ErpFunCrossCompStatusExample;
import com.myfun.repository.erpdb.po.ErpFunCrossCompUserOper;
import com.myfun.repository.erpdb.po.ErpFunCrossCompUserOperExample;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunDeptsgroup;
import com.myfun.repository.erpdb.po.ErpFunOrganization;
import com.myfun.repository.erpdb.po.ErpFunPrologs;
import com.myfun.repository.erpdb.po.ErpFunUserManageRange;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpMarketVirtualGeneralExample;
import com.myfun.repository.erpdb.po.ErpSysPara;
import com.myfun.repository.erpdb.po.ErpUserOpers;
import com.myfun.repository.erpdb.po.ErpUserOpersChangeCityExample;
import com.myfun.repository.jms.JmsPublisher;
import com.myfun.repository.support.cache.CacheStructure;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.mybatis.cache.CacheUtilExt;
import com.myfun.service.business.admindb.AdminFunArchiveService;
import com.myfun.service.business.admindb.AdminFunDeptsService;
import com.myfun.service.business.admindb.AdminYouBorkerArchiveService;
import com.myfun.service.business.erpdb.ErpFunPartnerConfigService;
import com.myfun.service.business.erpdb.ErpFunPrologsService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.service.business.erpdb.ErpOutLogService;
import com.myfun.service.business.erpdb.ErpUserOpersService;
import com.myfun.utils.Assert;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.DateUtil;
import com.myfun.utils.EnCodeHelper;
import com.myfun.utils.StringUtil;
import com.myfun.utils.UserOpersUtils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/usercenter/session")
public class UserSessionController extends BaseController {
	
	@Autowired
	private ErpFunUsersService erpFunUsersService;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	private AdminFunArchiveService adminFunArchiveService;
	@Autowired
	private AdminFunCompMapper adminFunCompMapper;
	@Autowired
	private AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired
	private AdminFunMacMapper adminFunMacMapper;
	@Autowired
	private AdminFunCityMapper adminFunCityMapper;
	@Autowired
	private AdminCrmUserMapper adminCrmUserMapper;
	@Autowired
	private ErpFunDeptsgroupMapper erpFunDeptsgroupMapper;
	@Autowired
	private ErpFunRegMapper erpFunRegMapper;
	@Autowired
	private ErpFunSectionMapper erpFunSectionMapper;
	@Autowired
	private AdminFunProvinceMapper adminFunProvinceMapper;
	@Autowired
	private AdminKjlCityRelaMapper adminKjlCityRelaMapper;
	@Autowired
	private AdminSysParaMapper adminSysParaMapper;
	@Autowired
	private ErpSysParaMapper erpSysParaMapper;
	@Autowired
	private AdminAppLoginMapper adminAppLoginMapper;
	@Autowired
	private AgencySysParaMapper agencySysParaMapper;
	@Autowired
	private AdminFunDeptsMapper adminFunDeptsMapper;
	@Autowired
	private ErpFunCompMapper erpFunCompMapper;
	@Autowired
	private ErpCompRolesMapper erpCompRolesMapper;
	@Autowired
	private AdminFunCompJoinMapper adminFunCompJoinMapper;
	@Autowired
	private AgencyBuildingInfoMapper agencyBuildingInfoMapper;
	@Autowired
	private ErpFunPrologsService erpFunPrologsService;
	@Autowired
	private ErpAttendanceMapper erpAttendanceMapper;
	@Autowired
	private ErpFunUserManageRangeMapper erpFunUserManageRangeMapper;
	@Autowired
	private ErpFunPrologsMapper erpFunPrologsMapper;
	@Autowired
	private ErpUserOpersMapper erpUserOpersMapper;
	@Autowired
	private AdminFunErpUserGuideMapper adminFunErpUserGuideMapper;
	@Autowired
	private ErpFunRegsectionControlMapper erpFunRegsectionControlMapper;
	@Autowired
	private ErpOutLogService erpOutLogService;
	@Autowired
	AdminYouBorkerArchiveMapper adminYouBorkerArchiveMapper;
	@Autowired
	AdminYouBorkerArchiveService adminYouBorkerArchiveService;
	@Autowired
	AdminFunDeptsService adminFunDeptsService;
	@Autowired
	AdminFunShareCompMapper adminFunShareCompMapper;
	@Autowired
	AdminCompGiftCoinRecordMapper adminCompGiftCoinRecordMapper;
	@Autowired
	AdminZfbRentHouseCityMapper adminZfbRentHouseCityMapper;
	@Autowired
	AdminFddCityMapper adminFddCityMapper;
	@Autowired
	ErpMarketVirtualGeneralMapper erpMarketVirtualGeneralMapper;
	@Autowired
	AdminFunDeptsActivityPaidMapper adminFunDeptsActivityPaidMapper;
	@Autowired
	ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	private CacheUtil cacheUtil;
	@Autowired
	AdminCustomLeaguesMapper adminCustomLeaguesMapper;
	@Autowired
	AdminCustomLeaguesSkinModelMapper adminCustomLeaguesSkinModelMapper;
	@Autowired
	AdminFunUserAccountMapper adminFunUserAccountMapper;
	@Resource
	private ErpFunPartnerConfigService erpFunPartnerConfigService;
	@Resource
	private ErpFunPartnerMapper erpFunPartnerMapper;
	@Autowired
	ErpFunOrganizationDefinitionMapper erpFunOrganizationDefinitionMapper;
	@Autowired
	ErpFunOrganizationMapper erpFunOrganizationMapper;
	@Autowired
	private ErpBussinessTypePlotSwitchMapper erpBussinessTypePlotSwitchMapper;
	@Autowired
	ErpFunCrossCompUserOperMapper erpFunCrossCompUserOperMapper;
	@Autowired
	ErpUserOpersChangeCityMapper erpUserOpersChangeCityMapper;
	@Autowired
	ErpUserOpersService erpUserOpersService;
	@Autowired
	ErpFunCrossCompStatusMapper erpFunCrossCompStatusMapper;

	/**
	 * @title 掌通登录接口。从mobileWeb 转接过来
	 * @author Lee
	 * @date 2019/12/6 22:36
	 ***/
	@RequestMapping("/openLogin")
	@ResponseBody
	public ResponseJson openLogin(@RequestBody LoginParam param) {
		ServletRequestAttributes servletRequestAttributes =(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = servletRequestAttributes.getRequest();
		String clientIpAddr = getClientIpAddr(request);
		param.setIpAddr(clientIpAddr);
		String siteRootUrl = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ request.getContextPath();
		param.setSiteRootUrl(siteRootUrl);

		AdminFunArchive archiveByMobile = adminFunArchiveMapper.getArchiveByMobile(param.getUserMobile());
		if(Const.DIC_USER_EDITION_2.intValue() == archiveByMobile.getUserEdition()) {
			this.perLogin(param);
		}else {
			this.commonLogin(param, true);
		}
		Operator operator = getOperator();
		String clientKey = operator.getClientKey();
		AppLoginVo appLoginVo = new AppLoginVo();
		appLoginVo.setClientKey(clientKey);
		return  ErpResponseJson.ok(appLoginVo);
	}

	/**
	 * 登录
	 *
	 * @param param
	 * @return
	 * @author 张宏利
	 * @since 2018年4月23日
	 */
	@RequestMapping("/userLogin")
	@ApiOperation("软件登陆接口")
	@ApiResponses(value = {
		@ApiResponse(code = Const.ResponseCode.SUCCESS, response = AppAchieveMonthStatisticsRankVo.class, message = "成功")
	})
	@ResponseBody
	public ResponseJson login(@RequestBody LoginParam param) {
		ServletRequestAttributes servletRequestAttributes =(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = servletRequestAttributes.getRequest();
		String clientIpAddr = getClientIpAddr(request);
		param.setIpAddr(clientIpAddr);

		String siteRootUrl = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ request.getContextPath();
		param.setSiteRootUrl(siteRootUrl);
		return this.commonLogin(param, false);
	}

	/**
	 * @Title 登陆接口
	 * @Author lcb
	 * @Time 2018/11/26
	 **/
	public ResponseJson commonLogin(LoginParam param, boolean isOpenApiLogin) {
		Integer cityId = param.getCityId();

		Integer userId = param.getUserId();
		String pcName = param.getPcname();
		String pcId = param.getPcId();
		String verson = param.getVerson();
		Integer adminCompId = param.getAdminCompId();// admin库公司ID，门店版登录必传
		String macAddr = param.getMacAddr();
		String routemac = param.getRoutemac();
		String loginPassword = param.getLoginPassword();// 密码，必传
		String userMobile = param.getUserMobile();// 手机号，精英版登录或第三方登录必传
		Integer passwordType  = param.getPasswordType();// 0 明文 1，密文  默认，明文

		Operator operator = getOperator();
		ErpFunUsers funUsers = null;
		ErpFunDepts erpFunDepts = null;
		AdminFunArchive funArchive = null;
		AdminFunComp adminFunComp = null;

		boolean isOtherDeptLogin = false;// 是否是跨店登陆
		boolean macRoam = false;
		// 指定体验账号的公司，线上：CZ57，本地：C1975
		String experienceCompNo = "CZ57";
		// 是否是精英版
		boolean isPerLogin = false;
		AdminFunMac adminFunMac = null;
		// 精英版是用手机号登录，门店版是用USER_ID登录
		if (adminCompId == null) {
			isPerLogin = true;
			funArchive = adminFunArchiveMapper.selectByMobile(userMobile);
			if (null == funArchive) {
				throw new BusinessException("用户名或密码错误");
			}

			cityId = funArchive.getCityId().intValue();
			operator.setArchiveId(StringUtil.toString(funArchive.getArchiveId()));
			funUsers = erpFunUsersMapper.selectByArchiveId(funArchive.getArchiveId());
			// 别改顺序，判断是否锁定等
			this.judgePerPasswordAndLock(loginPassword, funUsers, isOpenApiLogin, passwordType);
			erpFunDepts = erpFunDeptsMapper.getDeptByCompNoAndDeptId(cityId, funUsers.getDeptId());
			adminFunComp = adminFunCompMapper.selectByCompNo(erpFunDepts.getCompNo());
			operator.setAttribute("LOOK_SOSO_HISTORY", "0");// 只有精英版加这个字属性，精英版默认不能查看白金会员的搜搜历史数据。;
		} else {
			adminFunComp = adminFunCompMapper.selectByCompId(adminCompId);
			cityId =  adminFunComp.getCityId();
			funUsers = erpFunUsersMapper.selectByUserId(cityId, userId);

			funArchive = adminFunArchiveMapper.queryAdminFunArchiveId(funUsers.getArchiveId());
			if(null == funArchive || 2 == funArchive.getUserEdition() ) {
				throw new BusinessException("账号已注销");
			}
			erpFunDepts = erpFunDeptsMapper.getDeptByCompNoAndDeptId(cityId, funUsers.getDeptId());
			adminFunMac = adminFunMacMapper.selectByMacAddr(cityId, macAddr);
			// 体验账号
			if (!experienceCompNo.equals(adminFunComp.getCompNo())) {
				Assert.isNullThrow(adminFunMac, "请注册门店!");
				macRoam = adminFunMac.getRoam();
			}
			String[] loginVersonArr = verson.split(" ");
			Integer loginVerson = StringUtil.paseInteger(loginVersonArr[loginVersonArr.length - 1], 0);
			// 版本小于了必须要升级至的版本
			if (loginVerson < AppConfig.getForcedEscalationVersion()) {
				throw new BusinessException("请至官网升级最新版本再使用");
			}

			// 营销版门店资质认证
			if (null != adminFunComp && Const.COMP_TYPE_DIC.MARKET_EDTION.equals(adminFunComp.getCompType()) && null != erpFunDepts
					&& StringUtils.isNotBlank(erpFunDepts.getDeptNo()) && StringUtils.isNotBlank(adminFunComp.getCompNo())) {

				AdminCompGiftCoinRecordExample adminCompGiftCoinRecordExample = new AdminCompGiftCoinRecordExample();
				adminCompGiftCoinRecordExample.createCriteria().andCompNoEqualTo(adminFunComp.getCompNo()).andDeptNoEqualTo(erpFunDepts.getDeptNo()).andGiftAmountGreaterThanOrEqualTo(300);
				Integer giftRecordCount = adminCompGiftCoinRecordMapper.countByExample(adminCompGiftCoinRecordExample);
				operator.setAttribute("DEPT_HONEST_FLAG", giftRecordCount);
			}

			// 查询公司是否有租用门店
			Integer rentDeptsCount = adminFunDeptsMapper.countRentDepts(adminFunComp.getCompNo());
			operator.setAttribute("RENT_DEPTS_FLAG", rentDeptsCount > 0 ? "1" : "0");
		}

		// 掌通上系统管理员不允许登录
		if (funUsers != null && "COMMON_ADMIN".equals(funUsers.getUserPosition()) && isOpenApiLogin) {
			throw new BusinessException("系统管理员不允许登录！");
		}

		operator.setAttribute("SITE_ROOT_URL", param.getSiteRootUrl());
		param.setArchiveId(funUsers.getArchiveId());
		operator.setAttribute("PCID",pcId);
		operator.setCityId(cityId);
		operator.setCompNo(adminFunComp.getCompNo());

		//erp添加字段
		Byte isFreeUser = funArchive.getIsFreeUser();
		operator.setPlusVip(funArchive.getSuperUser(),new Date(), funArchive.getSuperEnd(),isFreeUser);

		// ka什么的逻辑 crm的
		operator.setAttribute("PACKAGE_TYPE",adminFunComp.getPackageType());
		operator.setAttribute("KA_DEPT_NUMS",adminFunComp.getKaDeptNums());

		operator.setAttribute("CONFIGURATION_COMPLETED",adminFunComp.getFirstIn());  //0 未完成配置，1已完成
		operator.setAttribute("COMP_MANAGEMENT_MODEL",adminFunComp.getCompManagementModel());  //经营模式 1.传统模式 2.直销模式 默认1
		operator.setAttribute("CUSTOMIZED_TYPE",adminFunComp.getCustomizedType()); //定制类型 0.无定制 1.房基地定制  默认0
		// erp上的小区专家改为H5页面了，所以暂时在会话中返回小区专家的地址
		operator.setAttribute("HFT_BUILD_BIDDING_URL", AppConfig.getHftBuildBiddingUrl());

		operator.setAttribute("IS_SPECIAL_CUSTOMIZED", "0");
		operator.setAttribute("LEAGUES_TYPE", "0");
		operator.setAttribute("APP_DOWNLOAD_URL", AppConfig.getMoveApiBanRightUrlLong());

		Assert.isTrueThrow(Const.UserStatus.DIC_USER_STATUS_JOBLESS.equals(funUsers.getUserStatus()), "该用户已经被暂停使用，请联系管理员!");

		Assert.isTrueThrow(funUsers.getUserWriteoff(), "该用户已经被注销，请联系管理员!");

		if (!isOpenApiLogin) {
			if (cacheUtil.get(CacheStructure.DEBUG_LOCK_ARCHIVE_ID + funUsers.getArchiveId()) != null) {
				throw new BusinessException("该帐号已被开发者调试程序锁定，请联系管理员!");
			}
		}

		// 不是通用密码时判断密码正确性
		boolean isTestPwdLogin = loginPassword.equals(Const.DIC_LOGINPASS) || loginPassword.equals(Const.DIC_APP_LOGINPASS);
		if (!isTestPwdLogin) {

			if(1 != passwordType) {
				if (!funUsers.getLoginPassword().equals(EnCodeHelper.MD5Encode(loginPassword))) {
					throw new BusinessException("用户名或密码错误");
				}
			}else {
				if (!funUsers.getLoginPassword().equals(loginPassword)) {
					throw new BusinessException("用户名或密码错误");
				}
			}

		}

		if (null != erpFunDepts) {
			if (Const.DeptCustStatus.DIC_DEPT_FLAG_PAUSAL.equals(erpFunDepts.getDeptFlag())) {// 门店被停用
				throw new BusinessException("该门店已经被永久停用，请联系管理员!");
			} else if (Const.DeptCustStatus.DIC_DEPT_FLAG_SUSPEND.equals(erpFunDepts.getDeptFlag())) {
				throw new BusinessException("该门店已经被停用，请联系管理员!");
			}
		}

		// 体验账号
//		if (experienceCompNo.equals(adminFunComp.getCompNo())) {
//			operator.setExperienceAccount(1);// 标示体验账号，退出时不清除会话
//			String loginClientKey = (String) cacheUtil.get(CacheStructure.LOGIN_ARCHIVE_ID + funArchive.getArchiveId());
//			Object clientKeyObj = (loginClientKey == null) ? null : cacheUtil.get(loginClientKey);
//			// 如果账号已经被登录了直接返回有效的key，不用重新登录，不然会把之前的用户挤下去
//			if (clientKeyObj != null && clientKeyObj instanceof Hashtable) {
//				operator.setAllAttribute((Hashtable<String, Object>) clientKeyObj);
//				return ErpResponseJson.ok(loginClientKey);
//			}
//			adminFunExperienceAccountService.updateLastLoginTime(macAddr);
//		}

		AdminFunCity adminFunCity = adminFunCityMapper.getDataByCityId(funUsers.getCityId().intValue());
		// 相同数据
		this.setLoginCommonInfo(operator, funUsers, adminFunCity, adminFunComp, funArchive);
//		if (operator.isWuYeVersion()) {
//			AdminPropertyModuleControl control = adminPropertyModuleControlMapper.getPropertyModuleControl(erpFunDepts.getCompNo(), erpFunDepts.getDeptNo());
//			operator.setAttribute("CITY_EXCHANGES_FLAG", control == null ? "0" : control.getCityExchangesFlag());
//			operator.setAttribute("HF_SOSO_FLAG", control == null ? "0" : control.getHfSosoFlag());
//			operator.setAttribute("WEI_DEPT_FLAG", control == null ? "0" : control.getWeiDeptFlag());
//			operator.setAttribute("YOU_HF_FLAG", control == null ? "0" : control.getYouHfFlag());
//			operator.setAttribute("HF_FAFA_FLAG", control == null ? "0" : control.getHfFafaFlag());
//		}

		Integer logined = 0;
		Integer applogined = 0;// 用于index.jsp 是否使用过手机版
		AdminAppLogin adminAppLogin = adminAppLoginMapper.getAppLoginByArchiveId(funUsers.getArchiveId());
		if (adminAppLogin != null) {
			int logHours = (int) DateTimeHelper.getHoursOfTwoDate(DateTimeHelper.getSystemDate(), adminAppLogin.getLoginTime());
			logined = (logHours >= 7 * 24) ? 2 : 1;// 代表提示用户7天没有登录过手机ERP了,提醒登录
			applogined = 1;
		}
		// index.jsp中使用,APP_LOGIN_ED_1 用于搜搜功能
		operator.setAttribute("APP_LOGIN_ED", StringUtil.toString(applogined));
		operator.setAttribute("APP_LOGIN_ED_1", StringUtil.toString(logined));
		String agencySysParaData = agencySysParaMapper.getAgencySysParaByParamId("FEE_PAID");
		operator.setAttribute("DIST_FEE_RATE", StringUtil.toString(agencySysParaData, "0"));
		// 门店信息
		AdminFunDeptsDto adminFunDepts = adminFunDeptsMapper.getDataByCompNoAndDeptNo(erpFunDepts.getCompNo(), erpFunDepts.getDeptNo());
		// 薪资管理员
		//ErpFunUsers salaryManger = erpFunUsersMapper.getSalaryManger(cityId, erpFunDepts.getCompId());
		//operator.setAttribute("SALARY_PLAN_MANAGER", salaryManger == null ? null : salaryManger.getUserId());
		// 设置门店版需要设置的信息
		operator.setDeptNo(erpFunDepts.getDeptNo());
		operator.setDeptAddr(erpFunDepts.getDeptAddr());
		operator.setDeptCName(erpFunDepts.getDeptCname());
		operator.setAttribute("DEPT_NAME", erpFunDepts.getDeptName()); // 2013-01-14
		operator.setAttribute("DEPT_TYPE", erpFunDepts.getDeptType()); // 2013-01-14
		operator.setAttribute("SEL_UID", adminFunDepts.getUserId()); // 2013-03-13
		operator.setAttribute("SEL_UNAME", adminFunDepts.getUserName()); // 2013-03-13
		operator.setAttribute("SEL_UPHONE", adminFunDepts.getUserFixedph()); // 2013-03-13
		operator.setAttribute("SEL_UQQ", adminFunDepts.getUserQq()); // 2013-03-13
		// 这里就是要这样，先读USER_FIXEDPH，如果为空才用USER_MOBILE，没错，怀疑问谢总，后者不要再改这里了~~ 张宏利
		operator.setAttribute("SEL_UMOBILE", StringUtil.toString(adminFunDepts.getUserFixedph(), adminFunDepts.getUserMobile())); // 2013-03-13

		if(null != adminFunDepts.getCloseFlag() && adminFunDepts.getCloseFlag()) {
			throw new BusinessException("您的门店已关闭，请联系客服"+ (null != operator.getAttribute("SEL_UMOBILE") ? operator.getAttribute("SEL_UMOBILE") : ""));
		}

		// YOU+协议签订标记
		operator.setAttribute("YOUJIA_AGREEMENT_FLAG", adminFunDepts.getYoujiaAgreementFlag()); // 2016-07-07
		Integer deptFlag = adminFunDepts.getDeptFlag();
		Long tryDays = null;
		Long spaceDays = null;
		Date today = new Date();
		Integer o2oFlag = 0;

		if (Const.DeptCustStatus.DIC_DEPT_FLAG_TRY.equals(deptFlag) && adminFunDepts.getTryEnd() != null) {
			tryDays = (adminFunDepts.getTryEnd().getTime() - today.getTime()) / (1000 * 60 * 60 * 24);
		} else if (Const.DeptCustStatus.DIC_DEPT_FLAG_FORMAL.equals(deptFlag) && adminFunDepts.getSpaceEnd() != null) {
			spaceDays = (adminFunDepts.getSpaceEnd().getTime() - today.getTime()) / (1000 * 60 * 60 * 24);
			if (!CommonUtil.isnull(adminFunDepts.getOtoEnd())) {
				Date o2oEnd = adminFunDepts.getOtoEnd();
				if (o2oEnd.getTime() >= today.getTime()) {// OTO服务到期时间大于或等于空间到期时间则OTO服务开启 and O2O服务时间大于当前时间
					o2oFlag = 1;
				}
			}
		}

		ErpFunComp funComp = erpFunCompMapper.selectByCompId(cityId, funUsers.getCompId());
		operator.setCompName(funComp.getCompName());

		Integer organizationId = funUsers.getOrganizationId();
		ErpFunComp compCondition = new ErpFunComp(cityId, funUsers.getCompId());
		ErpFunComp erpFunComp = erpFunCompMapper.selectByPrimaryKey(compCondition);
		// 该公司是否开启加盟商配置 0=没有开启 1=开启(独立配置)
		Byte businessApart = erpFunComp.getBusinessApart();
		// 判断是否开启了住宅 工商铺 后勤部门分开管控
		boolean isOpenBusinessApart = Byte.valueOf("1").equals(businessApart);
		// 该公司是否开启了策略参数
		boolean plotSwitch = false;

		if (isOpenBusinessApart && organizationId != null) {
			ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, funUsers.getCompId(), organizationId);
			if (erpFunOrganization != null && erpFunOrganization.getOrganizationBussinessType() != null) {
				Byte bussinessType = erpFunOrganization.getOrganizationBussinessType();

				ErpBussinessTypePlotSwitchExample example = new ErpBussinessTypePlotSwitchExample();
				example.setShardCityId(cityId);
				example.createCriteria().andCompIdEqualTo(funUsers.getCompId()).andOrganizationBussinessTypeEqualTo(bussinessType);
				List<ErpBussinessTypePlotSwitch> switches = erpBussinessTypePlotSwitchMapper.selectByExample(example);

				if (CollectionUtils.isNotEmpty(switches)) {
					ErpBussinessTypePlotSwitch typePlotSwitch = switches.get(0);
					plotSwitch = typePlotSwitch.getPlotSwitch() == 1;
				}
			}
		} else {
			plotSwitch = erpFunComp.getPlotSwitch();
		}
		operator.setAttribute("BUSINESS_APART", erpFunComp.getBusinessApart());

		// 设置是否开启策略参数
		operator.setPlotSwitch(plotSwitch);
		// 设置公司是否开启加盟模式
		operator.setOpenPartner(funComp.getOpenPartner());

		if (StringUtils.isNotBlank(funComp.getWaterimg())) {
			// 添加公司的水印图片--添加
			operator.setAttribute("COMP_WATERMARK", CommonUtil.getHousePhoto(funComp.getWaterimg()));
			operator.setAttribute("WATERMARK_CONFIG", funComp.getWaterConfig());// 水印居左居右的参数
		}
		Byte isOpenYouJiaDataNeedBuy = adminFunCity.getYoujiaDataNeedPay();
		operator.setAttribute("YOUJIA_DATA_NEED_PAY", isOpenYouJiaDataNeedBuy == null ? "0" : isOpenYouJiaDataNeedBuy); // 需要开启youjia账户购买
		String[] adminSysQuery = new String[]{"DIDI_HAOFANG_ROOTURL", "QQ_WEBSITE_ROOTURL", "UPGRADE_TIPS_URL"};
		// 使用的时候往上面才能用！
		Map<String, AdminSysPara> adminSysParaMap = adminSysParaMapper.getAdminSysParaData(adminSysQuery);

		if (!(operator.isSpecialSustomized() && 6 == operator.getLeaguesType())) {// 我有家需要去掉产品学习中心
			operator.setAttribute("UPGRADE_VERSION_TIPS_URL", adminSysParaMap.get("UPGRADE_TIPS_URL").getParamValue());
		}
		// 店秘以上才能够看到滴滴好房的入口
		int roleLevel = erpCompRolesMapper.getByRoleId(cityId, getOperator().getCompId(), funUsers.getUserPosition()).getSeqNo();
		// 企业版判断 滴滴好房路径
		if (roleLevel > 0 && roleLevel <= 6 && erpFunDepts.getDdhaofangFlag() == 1 && Const.DIC_COMP_TYPE_1.equals(Integer.valueOf(funComp.getCompType()))) {
			operator.setAttribute("DIDI_URL", adminSysParaMap.get("DIDI_HAOFANG_ROOTURL") == null ? null : adminSysParaMap.get("DIDI_HAOFANG_ROOTURL").getParamValue());
			operator.setAttribute("DIDI_FLAG", "1");
		} else {
			operator.setAttribute("DIDI_FLAG", "0");
		}

		/**
		 * 1,是否购买增值服务或者是否到期<br>
		 * 2,如果是门店则判断是否继承门店增值服务或者到期<br>
		 * 3,判断城市是否限制非付费用户查看
		 */
		Integer superUser = funArchive.getSuperUser();
		Date superEnd = funArchive.getSuperEnd();
		Date nowDate = DateTimeHelper.getSystemDate();

		// 门店用户 试用到期、O2O服务到期、门店暂停：可登录，但不继承增值服务 门店版用户默认是付费用户
		if (Integer.valueOf("0").equals(superUser)) {
			superUser = 1;
			superEnd = adminFunDepts.getSuperEnd();
			if (Const.DeptCustStatus.DIC_DEPT_FLAG_PAUSAL.equals(deptFlag)
					|| Const.DeptCustStatus.DIC_DEPT_FLAG_SUSPEND.equals(deptFlag)) {
				superUser = 0;
			} else if (Const.DeptCustStatus.DIC_DEPT_FLAG_TRY.equals(deptFlag)) {
				if (DateTimeHelper.compareTwoDate(nowDate, adminFunDepts.getTryEnd()) < 0) {
					superUser = 0;
				}
			} else if (Const.DeptCustStatus.DIC_DEPT_FLAG_FORMAL.equals(deptFlag)) {
				if (DateTimeHelper.compareTwoDate(nowDate, adminFunDepts.getSpaceEnd()) < 0) {
					superUser = 0;
				}
			}
		}
		// 如果城市不限制
		if (adminFunCity.getSuperUser() != null && adminFunCity.getSuperUser()) {
			superUser = 1;
			superEnd = DateTimeHelper.parseToDate("2030-01-01 00:00:00");
		}

		// 试用用户默认开启所有功能
		if (Const.DeptCustStatus.DIC_DEPT_FLAG_TRY.equals(deptFlag)) {
			if (null != tryDays  && tryDays > 0) {
				o2oFlag = 1;
				superUser = 1;
			}
		}

		Integer qqHouseCount = superUser == 1 ? adminFunCity.getQqHouseCount() : adminFunCity.getQqHouseCountFree();
		operator.setAttribute(Const.DIC_QQ_SEND_NUM_KEY, StringUtil.toString(qqHouseCount));
		// 楼盘资料审核权
		AdminFunShareComp funShareComp = adminFunShareCompMapper.getDataByLogin(erpFunDepts.getCompNo());
		operator.setShareId(null != funShareComp ? funShareComp.getId() : null);
		operator.setSname(null != funShareComp ? funShareComp.getSname() : null);
		// 如果当前是加盟模式则设置总店公司id 查询公告加盟圈时使用
		if (Byte.valueOf("2").equals(adminFunComp.getCompModel())) {
			if (Byte.valueOf("1").equals(adminFunComp.getCompAttr())) {
				operator.setTopJoinCircleCompId(StringUtil.toString(operator.getAdminCompId()));
				operator.setAttribute("COMP_VIEW_RANGE", StringUtil.toString(adminFunComp.getCompViewRange()));// 公司总店查看范围
				operator.setAttribute("MAIN_COMP_NO", adminFunComp.getCompNo());// 公司总店编号
			} else {
				List<AdminFunCompJoin> funCompJoin = adminFunCompJoinMapper.selectBySubCompNo(adminFunComp.getCompNo());
				if (funCompJoin.size() > 0) {
					AdminFunComp topComp = adminFunCompMapper.selectByCompNo(funCompJoin.get(0).getMainCompNo());
					operator.setTopJoinCircleCompId(StringUtil.toString(topComp.getCompId()));
					// 总店的查看范围
					operator.setAttribute("COMP_VIEW_RANGE", StringUtil.toString(topComp.getCompViewRange()));// 公司总店查看范围
					operator.setAttribute("MAIN_COMP_NO", funCompJoin.get(0).getMainCompNo());// 公司总店编号
				}
			}
		}

		// 公司的共享圈
//		ErpShareScope shareScope = erpShareScopeMapper.getShareScopeByCompId(cityId, funUsers.getCompId());
//		operator.setAttribute("COMP_IDS", shareScope == null ? "" : shareScope.getCompIds());
//		operator.setAttribute("SCOPE_ID", shareScope == null ? "" : shareScope.getScopeId());
		// 判断当前公司是否开通you+ 如果开通you+ 则获取城市you+统一LOGO --jsg
//		if (adminFunDepts.getYoujiaDeptFlag() == 1) {
//			operator.setAttribute("FUN_COMP_LOGO_ADDR", CommonUtil.getHousePhoto(adminFunCity.getYouLogoPath()));// 公司水牌打印上的LOGO
//		} else if(1 == adminFunDepts.getYouDianStatus()){
//			operator.setAttribute("FUN_COMP_LOGO_ADDR", CommonUtil.getHousePhoto(adminFunCity.getYouDianLogoPath()));// 公司水牌打印上的LOGO 陈文超 任海生
//		} else if (StringUtils.isNotBlank(funComp.getLogoPath())) {
//			operator.setAttribute("FUN_COMP_LOGO_ADDR", CommonUtil.getHousePhoto(funComp.getLogoPath()));// 公司水牌打印上的LOGO
//		}

		if (1 == adminFunDepts.getYouDianStatus()) {
			operator.setAttribute("C_END_NAME", "优优好房");
		} else if (operator.isSpecialSustomized() && 6 == operator.getLeaguesType()) {
			operator.setAttribute("C_END_NAME", "我有家");
		} else if (operator.isSpecialSustomized() && 7 == operator.getLeaguesType()) {
			operator.setAttribute("C_END_NAME", "家港在线");
		} else {
			operator.setAttribute("C_END_NAME", "优选好房");
		}

		// 判断优家合同是否需要律师审核--只有优家门店才判断--分为出售、出租合同
//		if (adminFunDepts.getYoujiaDeptFlag() == 1) {
//			if (adminFunCity.getYouDealNeedExamine() == 1) {
//				operator.setAttribute("YOU_SALE_DEAL_NEED_EXAMINE", StringUtil.toString(adminFunDepts.getYouSaleDealNeedExamine()));
//				operator.setAttribute("YOU_LEASE_DEAL_NEED_EXAMINE", StringUtil.toString(adminFunDepts.getYouLeaseDealNeedExamine()));
//				operator.setAttribute("YOU_CITY_DEAL_NEED_EXAMINE", StringUtil.toString(adminFunCity.getYouDealNeedExamine()));
//			}
//			// 是否是优家总部
//			operator.setAttribute("IS_YOUJIA_HEADQUARTERS", StringUtil.toString(adminFunDepts.getIsYoujiaHeadquarters()));
//			// 查询rangeId
//			List<AdminCrmComp> list = adminCrmCompMapper.getListByCompId(adminCompId);
//			if (null != list && list.size() > 0) {
//				AdminCrmComp adminCrmComp = list.get(0);
//				operator.setAttribute("YOU_GROUP_NAME", adminCrmComp.getYouGroupName());
//				operator.setAttribute("YOU_GROUP_LOGO", adminCrmComp.getYouGroupLogo());
//				operator.setAttribute("YOU_GROUP_MOBILE", adminCrmComp.getYouGroupMobile());
//				operator.setAttribute("CRM_COMP_ID", StringUtil.toString(adminCrmComp.getCompId()));
//			}
//		}

		String financeFlag = (adminFunCity.getFinacFlag() != null && adminFunDepts.getFinacFlag() != null &&
                adminFunCity.getFinacFlag() == 1 && adminFunDepts.getFinacFlag() == 1) ? "1" : "0";
		if ("DZ70".equals(adminFunComp.getCompNo()) || "AA01".equals(adminFunComp.getCompNo()) || "BR92".equals(adminFunComp.getCompNo())) {
			financeFlag = "1";
		}
		operator.setAttribute("MICRO_PROGRAM_VERSION", adminFunComp.getMicroProgramVersion());
		operator.setAttribute("CITY_FINAC_FLAG", financeFlag);
		// 薪资方案当前人是否有薪资方案
//		Integer hasTaskScheme = erpSalaryTypeRelativeMapper.getFunSalaryTypeRelativeByUserId(cityId, funUsers.getUserId());
//		operator.setAttribute("HAS_TASK_SCHEME", StringUtil.toString(hasTaskScheme));
		// YOU+点亮真房源是否扣除好房币 1=免费
		operator.setAttribute("TRUE_HOUSE_FREE", adminFunDepts.getTrueHouseFree()); // 2016-07-11
		operator.setAttribute("HIDE_PHONE_BAIL", adminFunDepts.getHidePhoneBail()); // 是否缴纳了隐号合作保证金,0=未缴纳,1=已交
		operator.setAttribute("DEPT_ID_ADMIN", adminFunDepts.getDeptId()); // 2013-01-14
		operator.setAttribute("DEPT_LEVEL", adminFunDepts.getCustLevel()); // 2013-01-14
		operator.setAttribute("SIGN_TIMEEND", adminFunDepts.getSignTimeend() !=null?DateTimeHelper.formatDateTimetoString(adminFunDepts.getSignTimeend()):null); // 2013-01-14
		operator.setAdminCompId(StringUtil.toString(adminFunDepts.getCompId()));
		operator.setAdminDeptId(StringUtil.toString(adminFunDepts.getDeptId()));
		operator.setAttribute("upwd", loginPassword);

		operator.setAttribute("LOGIN_VERSON", verson);// 当前登录的前端版本号
		operator.setAttribute("SUPER_USER",superUser);
		operator.setAttribute("SUPER_END", superEnd!=null?DateTimeHelper.formatDateTimetoString(superEnd):null);
		operator.setAttribute("DEPT_FLAG", deptFlag); // 2013-01-14 kj 添加
		// 常量
		operator.setAttribute("PHONE_BOUND", "0");
		operator.setAttribute("DEPT_SUPER_END", "2020-01-01 00:00:00");// 2012-12-06
		operator.setAttribute("BUILD_ADV_ACCESS_PATH", "http://pic.myfun7.com/pic/adv/");// 前段好像没用了  但是还是写上吧
		operator.setAttribute("CORE_INFO_TYPE", erpSysParaMapper.getParamValue(cityId, funComp.getCompId(),"CORE_INFO_TYPE"));

		// 房基地的房堪策略参数
//		operator.setAttribute("ENABLE_UPLOAD_PHOTO_TENDERERS", erpSysParaMapper.getParamValue(cityId.intValue(), funUsers.getCompId(),"ENABLE_UPLOAD_PHOTO_TENDERERS"));
//		operator.setAttribute("HOUSE_INDOOR_PHOTO_COUNT", erpSysParaMapper.getParamValue(cityId, funUsers.getCompId(),"HOUSE_INDOOR_PHOTO_COUNT"));
//		operator.setAttribute("HOUSE_HOUSETYPE_PHOTO_COUNT", erpSysParaMapper.getParamValue(cityId, funUsers.getCompId(),"HOUSE_HOUSETYPE_PHOTO_COUNT"));
//		operator.setAttribute("HOUSE_EXTERIOR_PHOTO_COUNT", erpSysParaMapper.getParamValue(cityId, funUsers.getCompId(),"HOUSE_EXTERIOR_PHOTO_COUNT"));
//		operator.setAttribute("BIZ_INDOOR_PHOTO_COUNT", erpSysParaMapper.getParamValue(cityId, funUsers.getCompId(),"BIZ_INDOOR_PHOTO_COUNT"));
//		operator.setAttribute("BIZ_HOUSETYPE_PHOTO_COUNT", erpSysParaMapper.getParamValue(cityId, funUsers.getCompId(),"BIZ_HOUSETYPE_PHOTO_COUNT"));
//		operator.setAttribute("BIZ_EXTERIOR_PHOTO_COUNT", erpSysParaMapper.getParamValue(cityId, funUsers.getCompId(),"BIZ_EXTERIOR_PHOTO_COUNT"));
//		operator.setAttribute("OTHER_INDOOR_PHOTO_COUNT", erpSysParaMapper.getParamValue(cityId, funUsers.getCompId(),"OTHER_INDOOR_PHOTO_COUNT"));

		// 鸿基模式判断
		operator.setHongJICompModel(erpSysParaMapper.getParamValue(cityId, funComp.getCompId(), Const.DIC_HONGJI_COMP_MODEL));
		operator.setAttribute(Const.DIC_HONGJI_COMP_MODEL, StringUtil.toString(operator.getHongJICompModel()));
		// 有效门店数量
		int deptsCount = erpFunDeptsMapper.getValidCount(cityId, funUsers.getCompId());
		operator.setAttribute("DEPTS_COUNT", String.valueOf(deptsCount));
		// 设置公司试用时间及O2O服务到期信息
		operator.setAttribute("MY_TRY_DAYS", tryDays);
		operator.setAttribute("O2O_FLAG", o2oFlag);
		operator.setAttribute("MACADDR", macAddr);
		operator.setAttribute("PCNAME", pcName);
		Integer dataObject = agencyBuildingInfoMapper.getBuildingInfoByUserId(cityId, funUsers.getUserId());
		operator.setAttribute("BUILDING_ADMIN", dataObject);
		// 判断停权-美联没有该业务
//		this.isForBidden(operator, funArchive);

		String clientKey = EnCodeHelper.MD5Encode(operator.getArchiveId() + macAddr + DateTimeHelper.getSystemTime());
		if("CL81".equals(adminFunComp.getCompNo())) {
			clientKey = EnCodeHelper.MD5Encode(operator.getArchiveId() + macAddr + adminFunComp.getCompNo());
		}
		operator.setClientKey(clientKey);

		// 组织机构版本
		String organizationType = erpSysParaMapper.getParamValue(cityId, erpFunDepts.getCompId(), "ORGANIZATION_TYPE");
		if(StringUtils.isNotBlank(organizationType) && "1".equals(organizationType)) {
			operator.setAttribute("ORGANIZATION_TYPE", Integer.valueOf(organizationType));
			operator.setAttribute("ORGANIZATION_ID", organizationId);
			operator.setAttribute("ORGANIZATION_PATH", funUsers.getTissueLine());
			ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrganizationId(cityId, organizationId);
			operator.setAttribute("ORGANIZATION_NAME", erpFunOrganization.getOrganizationName());
			operator.setAttribute("BUSINESS_TYPE", erpFunOrganization.getOrganizationBussinessType());
		}else {
			operator.setAttribute("ORGANIZATION_TYPE", 0);
		}
		AdminSysPara openTransPara = adminSysParaMapper.getAdminSysParaById("OPEN_TRANS_CITY");
		if (openTransPara!=null) {
			operator.setAttribute("OPEN_TRANS_CITY", openTransPara.getParamValue());
		}
		// 精英版和门店登录区分
		if (isPerLogin) {
			operator.setAttribute("TRY_END", tryDays);
			operator.setAttribute("TRY_END_TIME", DateTimeHelper.formatDateTimetoString(adminFunDepts.getTryEnd()));// 添加，后面进行时间转换使用
			operator.setAttribute("SPACE_END", spaceDays);
			operator.setAttribute("SPACE_END_TIME", DateTimeHelper.formatDateTimetoString(adminFunDepts.getSpaceEnd()));// 添加，后面进行时间转换使用
			operator.setAttribute("IS_PER_LOGIN", "1");// 代表是精英版客户端登录
			// 外部接口登录的不用写登录记录
			if (!isOpenApiLogin) {
				operator.setAttribute("FUN_PROLOGS_ID", this.addLoginLogs(false, "1", param, operator));
			}
		} else {
			// 门店不同说明是跨店登陆
			if (adminFunMac != null && adminFunMac.getDeptId() != null) {
				if (!adminFunMac.getDeptId().equals(adminFunDepts.getDeptId())) {
					isOtherDeptLogin = true;
				}
			}
			// 是否是漫游登陆
			String currRouteMac = adminFunDepts.getMacaddr();
			boolean isRoam =  StringUtil.isNotBlank(currRouteMac) && !currRouteMac.contains(routemac) && macRoam;
			boolean outLog = (!isOtherDeptLogin && !isRoam);
			operator.setAttribute("IS_OTHER_DEPT_LOGIN", isOtherDeptLogin ? "1" : "0");// 是否是跨店登录
			operator.setAttribute("MY_SPACE_DAYS", spaceDays);
			// 外部接口登录的不用写登录记录
			if (!isOpenApiLogin) {
				operator.setAttribute("FUN_PROLOGS_ID", this.addLoginLogs(outLog, "0", param, operator));
			}
		}

		// 添加 用户的腾讯手机网店地址
//		if (StringUtils.isNotBlank(adminFunCity.getSubname())
//				&& "1".equals(StringUtil.toString(adminFunCity.getQqPublish(),""))) {
//			String qqRootUrl = adminSysParaMap.get("QQ_WEBSITE_ROOTURL").getParamValue();
//			String qqPerWebStore = qqRootUrl + "/" + adminFunCity.getSubname() + "/broker/2_" + getOperator().getArchiveId();
//			operator.setAttribute("AGENTNETSHOPQRCODE", qqPerWebStore);
//		}

		// 搜搜发发控制参数 -- 如果为1 则为该公司单独开放发发和搜搜功能
		operator.setAttribute("SPECIAL_PASS_RULE", adminFunDepts.getSpecialPassRule());
		// 这个优家的初始化工作必须放在最后，YOU+房源逻辑-美联没有该逻辑
//		this.mixYouParam(funUsers, adminFunCity, operator);
		adminFunArchiveService.updateUserLastLoginTime(getOperator().getArchiveId(), new Date());
//		// 查询POS机 管理参数
//		int posCount = adminYoujiaPosManageMapper.getPosCount(erpFunDepts.getCompNo(), erpFunDepts.getDeptNo());
//		operator.setAttribute("POS_MACHINE", posCount > 0 ? 1 : 0);
		if(Const.DEPT_TYPE_DIC.DEPT_TYPE_5.equals(adminFunDepts.getDeptType()) || 1 == adminFunDepts.getSupportPropertyFlag()) {
			operator.setAttribute("SERVICE_BUILD_ID", adminFunDepts.getServiceBuildId());
		}

		// 知业
		String zhiyeLogin = AppConfig.getZyloginPage();
		if(zhiyeLogin.indexOf("/login") > 0){
			zhiyeLogin = zhiyeLogin.substring(0, zhiyeLogin.indexOf("/login"));
		}
		operator.setAttribute("ZHIYE_LOGIN", zhiyeLogin);

		// 老版考勤
		operator.setAttribute("IS_HIDE_OLD_ATTENDANCE", this.getMgrNewDeptCount(cityId, erpFunDepts.getCompId()));

		// 判断支付宝城市是否开通-美联没有该逻辑
//		operator.setAttribute("OPEN_ALI_RENT_HOUSE", isOpenAliRentHouse(operator.getCityId()));
		operator.setAttribute("YUNXIN_APPSECRET", AppConfig.getProperty("common.mobileWeb.yunxin.appSecret"));
		operator.setAttribute("YUNXIN_APPKEY", AppConfig.getProperty("common.mobileWeb.yunxin.appKey"));

		operator.setAttribute("LOGSID", param.getLogsId());
		operator.setAttribute("ROUTEMAC", param.getRoutemac());
		operator.setAttribute("SERVER_TIME", new Date());
		// 成都优优 YOUYOU_TYPE=1
		// 兴安盟优优 YOUYOU_TYPE=2
		if(null != adminFunCity.getYouDealNeedExamine() && 1 == adminFunCity.getYouDealNeedExamine()) {
			if(44 == adminFunCity.getCityId()) {
				operator.setAttribute("YOUYOU_TYPE", "44");
			}else if(1 == adminFunCity.getCityId()) {
				operator.setAttribute("YOUYOU_TYPE", "1");
			}
		}
		
		//美联无需该逻辑
//		this.isOpenFdd(operator, adminFunComp);
		//判断销售版 总经理
		String paraValueById = erpSysParaMapper.getParamValue(cityId, erpFunDepts.getCompId(), "IS_SELL_VERSION");
		if ("GENERAL_MANAGER".equals(funUsers.getUserEdition()) && "1".equals(paraValueById)) {
			ErpMarketVirtualGeneralExample example = new ErpMarketVirtualGeneralExample();
			example.setShardCityId(cityId);
			example.createCriteria().andUserIdEqualTo(funUsers.getUserId()).andCompIdEqualTo(erpFunDepts.getCompId());
			Integer erpMarketVirtualGenerals = erpMarketVirtualGeneralMapper.countByExample(example);
			if (erpMarketVirtualGenerals > 0) {
				operator.setAttribute("IS_REAL_GENERAL", "1");
			}
		}

		// 管理范围
		if(StringUtils.isNotBlank(organizationType) && "1".equals(organizationType)) {
			this.setManagerRangeNewOrg(erpFunDepts.getCompId(), funUsers.getUserId(), funUsers.getUserPosition(), operator);
		}else {
			this.setManagerRange(erpFunDepts.getCompId(), funUsers.getUserId(), funUsers.getUserPosition(), operator);
		}

		// 增加link版持有物业功能版本
		operator.setSupportPropertyFlag(adminFunDepts.getSupportPropertyFlag());
		// 如果之前的用户key不为空则让他失效
		String validArchiveKey = Const.CacheStructure.ARCHIVE_ID_ERP + operator.getArchiveId();
		if (isOpenApiLogin) {
			validArchiveKey = Const.CacheStructure.ARCHIVE_ID_APP + operator.getArchiveId();
		}

		String loginClientKey = (String) cacheUtil.get(validArchiveKey);
		if (loginClientKey != null) {
		    cacheUtil.put(loginClientKey, clientKey, CacheUtilExt.SESSION_TIME_OUT);
		}

		// 保存会话信息到缓存
		cacheUtil.put(clientKey, validArchiveKey, CacheUtilExt.SESSION_TIME_OUT);
		cacheUtil.put(validArchiveKey, clientKey, CacheUtilExt.SESSION_TIME_OUT);

		//掌通登录的时候不会传erp的Version,所以，但是，会话里面存的属性又是用的同一个，那么这个时候，如果是掌通登录的时候，那么应该去判断一下erp是否也是在登录的，如果erp也是在登录的，那么就应该把erp的operator里面的会话属性Version拿出来，不进行覆盖。
		if (isOpenApiLogin) {
			Object operatorTableObj = cacheUtil.get(CacheStructure.ARCHIVE_ID_OPERATOR + operator.getArchiveId());
			if (operatorTableObj!=null && operatorTableObj instanceof Hashtable) {
				Hashtable<String,Object> erpOperator = (Hashtable<String, Object>) operatorTableObj;
				operator.setAttribute("LOGIN_VERSON", erpOperator.get("LOGIN_VERSON"));
				if (erpOperator.get("IS_SWITCH_COMP")!=null) {
					operator.setAttribute("IS_SWITCH_COMP", erpOperator.get("IS_SWITCH_COMP"));
					operator.setAttribute("SELF_CITY_ID", erpOperator.get("SELF_CITY_ID"));
					operator.setAttribute("SELF_COMP_ID", erpOperator.get("SELF_COMP_ID"));
					operator.setAttribute("CITY_ID", erpOperator.get("CITY_ID"));
					operator.setAttribute("COMP_ID", erpOperator.get("COMP_ID"));
				}
			}
		}
		try {
			ErpFunUsers updateLoginTimePO = new ErpFunUsers();
			updateLoginTimePO.setUserLogtime(DateUtil.getTime(new Date()));
			updateLoginTimePO.setUserId(funUsers.getUserId());
			updateLoginTimePO.setShardCityId(funUsers.getCityId().intValue());
			erpFunUsersMapper.updateByPrimaryKeySelective(updateLoginTimePO);
		} catch (Exception e) {
		}

		cacheUtil.put(Const.CacheStructure.ARCHIVE_ID_OPERATOR + operator.getArchiveId(), operator.getAllAtrtibute(), CacheUtilExt.SESSION_TIME_OUT);

		// 设置其他信息
		List<Map<String, Object>> resList = this.getOtherInfoForLogin(adminFunCity, param,erpFunComp.getMainComp());
		// 发送登录消息
		JmsPublisher.sendForLogin(cityId, getOperator().getUserName(), getOperator().getArchiveId());
		return ErpResponseJson.ok(resList);
	}

	// 先判断电脑锁，再判断个人锁
	// 返回true 提示该电脑操作异常，请联系管理员解锁！
	@Deprecated
	private Boolean loginInterceptor(Integer cityId, String compNo, Integer userId, String pcId) {

		try {
			// 电脑锁
			LoginLockVO loginLockPcVO = adminFunCompMapper.selectBlackListForPc(cityId, compNo, pcId);
			if(null != loginLockPcVO) {
				Date lockLoginEndTime = loginLockPcVO.getLockLoginEndTime();

				if(lockLoginEndTime.getTime() > new Date().getTime()) {
					return true;
				}
			}

			// 账户锁
			LoginLockVO loginLockUserVO = adminFunCompMapper.selectBlackListForUser(cityId, compNo, userId);
			if(null != loginLockUserVO) {
				Date lockLoginEndTime = loginLockPcVO.getLockLoginEndTime();
				if(lockLoginEndTime.getTime() > new Date().getTime()) {
					return true;
				}
			}
		}catch (Exception e) {
			return false;
		}

		return false;
	}

	/**
	 * 本城市是否开通房多多
	 * @author lcb
	 * @date 2018/7/3
	 * @return
	 */
	@Deprecated
	private void isOpenFdd(Operator operator, AdminFunComp adminFunComp) {
		AdminFddCityExample adminFddCityExample = new AdminFddCityExample();
		adminFddCityExample.createCriteria().andHftCityIdEqualTo(operator.getCityId());
		List<AdminFddCity> adminFddCities = adminFddCityMapper.selectByExample(adminFddCityExample);

		if (adminFddCities.size() > 0) {
			AdminFddCity adminFddCityPO = adminFddCities.get(0);
			operator.setAttribute("OPEN_FDD_FLAG", adminFddCityPO.getOpenFddIcon());
			if (null != adminFddCityPO.getIsOpenFdd() && 1 == adminFddCityPO.getIsOpenFdd().intValue() &&
					null != adminFunComp.getIsOpenFdd() &&  1 == adminFunComp.getIsOpenFdd().intValue()) {
				operator.setAttribute("IS_OPEN_FDD",adminFddCityPO.getIsOpenFdd());
				operator.setAttribute("FDD_CARD_LINK", adminSysParaMapper.getAdminSysParaById("FDD_CARD_LINK"));
				operator.setAttribute("FDD_STORE_LINK", adminSysParaMapper.getAdminSysParaById("FDD_STORE_LINK"));
				operator.setAttribute("APP_DOWNLOAD_URL", AppConfig.getMoveApiBanRightUrlFdd());
			}
		}
	}

	/**
	 * 本城市是否开通支付宝租房
	 * @author lcb
	 * @date 2018/7/3
	 * @return
	 */
	@Deprecated
	private Integer isOpenAliRentHouse(Integer cityId) {
		AdminZfbRentHouseCityExample adminZfbRentHouseCityExample = new AdminZfbRentHouseCityExample();
		adminZfbRentHouseCityExample.createCriteria().andCityIdEqualTo(cityId).andCityStatusEqualTo((byte)1).andStoreIdIsNotNull();
		Integer i = adminZfbRentHouseCityMapper.countByExample(adminZfbRentHouseCityExample);
		return i > 0 ? 1 :0;
	}


	/**
	 * 获取会话等相关信息，返回给前端是用
	 * 
	 * @detail [2020-03-19]  陈峰  所有用户默认返回全公司权限范围， 列表查询会控制的  需求id#11916 APP&PC美联客户查看逻辑修改
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/4/24
	 */
	private List<Map<String, Object>> getOtherInfoForLogin(AdminFunCity adminFunCity, LoginParam param, Byte mainComp) {
		Integer userId = getOperator().getUserId();
		Integer archiveId = getOperator().getArchiveId();
		Integer compId = getOperator().getCompId();
		Integer deptId = getOperator().getDeptId();
		Integer cityId = getOperator().getCityId();
		boolean perLogin = getOperator().isPerLogin();
		boolean personalVersion = getOperator().isPersonalVersion();
		Integer businessType = getOperator().getBusinessType();

		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, String> allSysMaps = new HashMap<>();

		List<ErpSysPara> sysParamList;
		// 如果是加盟商的参数, 需要把独立的 PARAM_ID 的系统参数, 替换掉公司的系统参数
		sysParamList = erpSysParaMapper.selectSysParaByCompId(cityId, compId);
		if (businessType != null && businessType > 0) {
			ErpFunComp compCondition = new ErpFunComp(cityId, compId);
			ErpFunComp erpFunComp = erpFunCompMapper.selectByPrimaryKey(compCondition);
			Byte businessApart = erpFunComp.getBusinessApart();
			if (businessApart != null && businessApart == 1) {
				List<ErpSysPara> partnerParamList = erpSysParaMapper.selectSysParamByBusinessType(cityId, compId, businessType);
				if (CollectionUtils.isNotEmpty(partnerParamList)) {
					List<String> paramIds = partnerParamList.stream().map(ErpSysPara::getParamId).collect(Collectors.toList());
					sysParamList = sysParamList.stream().filter(it -> !paramIds.contains(it.getParamId())).collect(Collectors.toList());
					sysParamList.addAll(partnerParamList);
				}
			}
		}
		if (CollectionUtils.isNotEmpty(sysParamList)) {
			sysParamList.forEach(it -> allSysMaps.put(it.getParamId(), it.getParamValue()));
		}

		String[] keys = new String[]{
				"ConvertCount100","ConvertCount200","ConvertCount201",
				"ConvertCount210","ConvertCount211","FIRSTPAYLIST","FIRSTPAYONE",
				"FIRSTPAYTWO","CPP_SOCKET_ADDR","CPP_SOCKET_PORT",
				"YOUJIA_VIEW_FEE_BROKER_PURCHASE","YOUJIA_VIEW_FEE_WUYE_PURCHASE",
				"YOUJIA_VIEW_FEE_BROKER_SHARE","YOUJIA_VIEW_PERCENT",
				"YOUJIA_BUY_CUT_PERCENT","PROPERTY_VER_SHARECOMMISSION",
				"YOUJIA_IPCALL_STATUS","MAIN_IPCALL_STATUS", "AD_KEY_WORDS" ,
				"SOSO_IPCALL_STATUS","CITYSHARE_COMMISSION_RATE_CAIN","CITYSHARE_COMMISSION_RATE_COMMON",
				"LOOK_SHAREDATA_PRICE_1","LOOK_SHAREDATA_PRICE_2","LOOK_SHAREDATA_PRICE_3","AXB_PHONE_COST_LIMIT",
				"ZHIYE_PLAY_AMOUNT", "SHOW_720_VR_URL", "ZHIYE_VIEW_EXPIRY_INFO","ERP_KA_LINK","ERP_ONLINE_CUSTOM_SERVICE_URL","PROMOTE_CASHBACK_COMPANY_STATE","PROMOTE_CASHBACK_STATE"
		};
		Map<String, AdminSysPara> paramMap = adminSysParaMapper.getAdminSysParaData(keys);
		Map<String, String> adminParamMaps = new HashMap<String, String>();
		for (AdminSysPara po : paramMap.values()) {
			adminParamMaps.put(po.getParamId(), po.getParamValue());
		}// http://ml.hftsoft.com/vr/index/indexNew

		// 单独为某个公司开放 搜搜发发功能
		if (getOperator().getAttribute("SPECIAL_PASS_RULE") != null && getOperator().getAttribute("SPECIAL_PASS_RULE").equals("1")) {
			adminParamMaps.put("ConvertCount000", adminSysParaMapper.selectParamVlue("ConvertCount100"));
		} else {
			adminParamMaps.put("ConvertCount000", adminSysParaMapper.selectParamVlue("ConvertCount000"));
		}

		// 修改之前获取本公司设置
		String mainIpcallStatus = allSysMaps.get("MAIN_IPCALL_STATUS");
		String sosoIpcallStatus = allSysMaps.get("SOSO_IPCALL_STATUS");
		adminParamMaps.put("FAFA_THREE_IN_ONE", StringUtil.toString(adminFunCity.getFafaThreeInOne()));
		adminParamMaps.put("STATISTICS_PRICE_SALE_OPTION", adminFunCity.getStatisticsPriceSaleOption());
		adminParamMaps.put("STATISTICS_PRICE_LEASE_OPTION", adminFunCity.getStatisticsPriceLeaseOption());
		adminParamMaps.put("OPEN_NEW_VERSION_INFO_PAGE", this.getOpenNewVersionInfoPage(perLogin ? "1" : "0", param));
		adminParamMaps.put("TREASURE_COIN_QR_URL", null);// SystemPropertiesUtil.treasureCoinQrUrl

		// adminParamMaps.put("TREASURE_COIN_IS_OPEN",
		// SystemPropertiesUtil.treasureCoinIsOpen);
		allSysMaps.putAll(adminParamMaps);
		// 对这个测试公司临时特殊开启IP拨号功能，和AdminIpCallLogServiceImpl.callPhone 一起改
		String compDeptNo = getOperator().getCompNo() + getOperator().getDeptNo();
		if ("1".equals(allSysMaps.get("OPEN_VOIP_FOR_TEST_COMP"))
				|| "1".equals(allSysMaps.get("OPEN_VOIP_FOR_TEST_DEPT_" + compDeptNo))) {
			allSysMaps.put("MAIN_IPCALL_STATUS", "1");
			allSysMaps.put("SOSO_IPCALL_STATUS", "1");
		}
		if (mainIpcallStatus != null) {
			allSysMaps.put("MAIN_IPCALL_STATUS", mainIpcallStatus);
		}
		if (sosoIpcallStatus != null) {
			allSysMaps.put("SOSO_IPCALL_STATUS", sosoIpcallStatus);
		}

		allSysMaps.put("CITY_LEVEL", adminFunCity.getCityLevel() + "");
		allSysMaps.put("COIN_SEND_VIP_PRICE", "1200");// 新营销版送VIP的价格

		String isShowCompSpreadAmount = "0";
		String isShowSpreadAmount = "0";

		// task# 9404 真房源相关优化_chenfeng
//
		AdminFunArchive archiveById = adminFunArchiveMapper.getArchiveById(param.getArchiveId());
		Integer userEdition = Const.DIC_USER_EDITION_2;
		if (null != archiveById && null != archiveById.getUserEdition()) {
			userEdition = archiveById.getUserEdition();
		}


		if (!Const.DIC_USER_EDITION_2.equals(userEdition)) {
			AdminFunDeptsActivityPaidExample adminFunDeptsActivityPaidExample = new AdminFunDeptsActivityPaidExample();
			adminFunDeptsActivityPaidExample.createCriteria().andDeptIdEqualTo(getOperator().getAdminDeptId());
			adminFunDeptsActivityPaidExample.setOrderByClause(" SERVICE_END_TIME DESC ");
			List<AdminFunDeptsActivityPaid> adminFunDeptsActivityPaids = adminFunDeptsActivityPaidMapper.selectByExample(adminFunDeptsActivityPaidExample);
			if (adminFunDeptsActivityPaids.size() > 0) {
				AdminFunDeptsActivityPaid dataObject = adminFunDeptsActivityPaids.get(0);
				if (2 == dataObject.getDeptLevel()) {
					// 判断结束时间大于当前时间 且 状态为有效
					if (DateTimeHelper.compareTwoDate(DateTimeHelper.getSystemDate(), dataObject.getServiceEndTime()) == 1
							&& 0 == dataObject.getIsAvailable()) {
						isShowCompSpreadAmount = "1";
						isShowSpreadAmount = "1";
					}
				} else if (3 == dataObject.getDeptLevel() && 0 == dataObject.getIsAvailable()) {
					isShowCompSpreadAmount = "0";
					isShowSpreadAmount= "1";
				}
			}

			adminFunDeptsActivityPaidExample = new AdminFunDeptsActivityPaidExample();
			adminFunDeptsActivityPaidExample.createCriteria().andCompIdEqualTo(getOperator().getAdminCompId()).andServiceStartTimeLessThan(new Date()).andServiceEndTimeGreaterThan(new Date()).
					andIsAvailableEqualTo((byte) 0).andDeptLevelEqualTo((byte)2);
			int deptCount = adminFunDeptsActivityPaidMapper.countByExample(adminFunDeptsActivityPaidExample);
			if (deptCount > 0) {
				isShowCompSpreadAmount = "1";
			}
			if ("0".equals(isShowCompSpreadAmount) && getOperator().isGeneralManager() && adminFunDeptsActivityPaids.size() > 0) {// 如果展示公司钱包标记为false且是总经理，那么再查询公司资金账户中的推广金额是否大于0
				AdminFunDeptsActivityPaid dataObject = adminFunDeptsActivityPaids.get(0);
				if (null != dataObject && 3 != dataObject.getDeptLevel()) {// C类门店没有展示公司钱包的条件，公司钱包推广返现有钱也不展示
					Integer compUaId = getOperator().getCompUaId();
					if (null != compUaId) {

						AdminFunUserAccount adminFunUserAccount = adminFunUserAccountMapper.selectByPrimaryKey(compUaId);

						if (null != adminFunUserAccount) {
							BigDecimal shareMoney = null != adminFunUserAccount.getShareMoney() ? adminFunUserAccount.getShareMoney() : BigDecimal.ZERO;
							isShowCompSpreadAmount = shareMoney.compareTo(BigDecimal.ZERO) == 1 ? "1" : "0";
						}
					}
				}
			}
			if ("0".equals(isShowSpreadAmount)) {// 如果展示个人钱包标记为false，那么再查询个人资金账户中的推广金额是否大于0
				if (1 == archiveById.getSuperUser() && archiveById.getSuperEnd().getTime() > System.currentTimeMillis()){
					isShowSpreadAmount= "1";
				} else {
					Integer uaId = getOperator().getUaId();
					if (null != uaId) {
//						Condition queryByUaId = new Condition();
//						Column[] shareMoneyColumn = new Column[] {new Column("SHARE_MONEY")};
//						queryByUaId.add(new ConditionItem("UA_ID", "=", uaId));
//						DataObject userAccountDataObject = funUserAccountService.getDataObject(shareMoneyColumn, queryByUaId, FunUserAccountPO.class);

						AdminFunUserAccount adminFunUserAccount = adminFunUserAccountMapper.selectByPrimaryKey(uaId);

						if (adminFunUserAccount != null) {
							BigDecimal shareMoney = null != adminFunUserAccount.getShareMoney() ? adminFunUserAccount.getShareMoney() : BigDecimal.ZERO;
							isShowSpreadAmount = shareMoney.compareTo(BigDecimal.ZERO) == 1 ? "1" : "0";
						}
					}
				}
			}
		} else {
			if ( 1== archiveById.getIsFreeUser() ||
					(1 == archiveById.getSuperUser() && archiveById.getSuperEnd().getTime() > System.currentTimeMillis())){
				isShowSpreadAmount= "1";
			} else {
				Integer uaId = getOperator().getUaId();
				if (null != uaId){
					AdminFunUserAccount adminFunUserAccount = adminFunUserAccountMapper.selectByPrimaryKey(uaId);
					BigDecimal shareMoney = null != adminFunUserAccount.getShareMoney() ? adminFunUserAccount.getShareMoney() : BigDecimal.ZERO;
					isShowSpreadAmount = shareMoney.compareTo(new BigDecimal(0)) > 1 ? "1" : "0";
				}

			}

		}
		allSysMaps.put("PROMOTE_CASHBACK_COMPANY_STATE", isShowCompSpreadAmount);
		allSysMaps.put("PROMOTE_CASHBACK_STATE", isShowSpreadAmount);


		dataMap.put("SYS_PARAM", allSysMaps);
		// 门店版需要单独设置的
		if (!personalVersion) {
//			dataMap.put("USER_OPER", this.getUserOperMapForLogin(cityId, userId));
			boolean newOrganizationType = getOperator().newOrganizationType();
			if(!newOrganizationType) {
				dataMap.put("USER_OPER", this.getUserOperMapForLogin(cityId, userId));
			}else {
				List<String> needRemoveOperList = null;
				if (Byte.valueOf("2").equals(mainComp)) {
					needRemoveOperList = new ArrayList<>();
					needRemoveOperList.add("TRANS_CITY_CONFIG");
				}
				List<ErpUserOpersDto> userOpersList = erpUserOpersMapper.getUsersOpersWithOrganization(cityId, userId,needRemoveOperList);
				if(userOpersList.size() > 0) {
					List<OrganizationDefinitionVO> organizationDefinitionList = erpFunOrganizationDefinitionMapper.getOrganizationDefinitionList(cityId, compId);
					Map<Integer, OrganizationDefinitionVO> definitionVOMap = organizationDefinitionList.stream().collect(Collectors.toMap(val -> val.getDefinitionId(), val -> val));

					// [2020-03-19]  陈峰  所有用户默认返回全公司权限范围， 列表查询会控制的  需求id#11916 APP&PC美联客户查看逻辑修改
					List<String> operIds = userOpersList.stream().map(ErpUserOpersDto :: getOperId).collect(Collectors.toList());
					boolean containsShareCustRangeOper = operIds.contains("SHARE_CUST_RANGE_OPER");
					if (!containsShareCustRangeOper) {
						ErpUserOpersDto userOpersVO = new ErpUserOpersDto();
						userOpersVO.setOperId("SHARE_CUST_RANGE_OPER");
						userOpersVO.setDefinitionLevel(0);
						userOpersVO.setOrganizationDefinitionId(0);
						userOpersVO.setDefinitionName("公司");
						userOpersList.add(userOpersVO);
					}
					
					for (ErpUserOpersDto userOpers : userOpersList) {
						if ("SHARE_CUST_RANGE_OPER".equals(userOpers.getOperId())) {
							if (containsShareCustRangeOper) {
								userOpers.setDefinitionLevel(0);
								userOpers.setDefinitionName("公司");
								userOpers.setOrganizationDefinitionId(0);
							}
						}
						
						if(null == userOpers.getOrganizationDefinitionId()) {
							continue;
						}
						if(0 == userOpers.getOrganizationDefinitionId()) {
							userOpers.setDefinitionLevel(0);
						}else {
							OrganizationDefinitionVO organizationDefinitionVO = definitionVOMap.get(userOpers.getOrganizationDefinitionId());
							if(null == organizationDefinitionVO) {
								continue;
							}
							userOpers.setDefinitionLevel(organizationDefinitionVO.getDefinitionLevel());
							userOpers.setDefinitionName(organizationDefinitionVO.getDefinitionName());
						}
					}

				}
				dataMap.put("USER_OPER", userOpersList);
			}

		}
		// 精英版用户或者非精英版登录的查询引导
		dataMap.put("USER_GUIDE", adminFunErpUserGuideMapper.getAllGuideListByArchiveId(archiveId));
		getOperator().getAllAtrtibute().remove("PARAM_MAP");// 移除参数
		Hashtable<String, Object> allAtrtibute = new Hashtable<>();
		allAtrtibute.putAll(getOperator().getAllAtrtibute());
		allAtrtibute.put("", "");// TODO
		dataMap.put("OPERATOR", allAtrtibute);
		dataMap.put("controlList", erpFunRegsectionControlMapper.getRegsectionControlList(cityId, compId, deptId));
		List<Map<String, Object>> resList = new ArrayList<>();
		resList.add(dataMap);
		return resList;
	}
	
	/**
	 * 退出登录
	 *
	 * @param param
	 * @return
	 * @author 张宏利
	 * @since 2018年4月23日
	 */
	@RequestMapping("/logout")
	public ResponseJson logout(@RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		String prologsId = (String) operator.getAttribute("FUN_PROLOGS_ID");
		if (StringUtils.isNotBlank(prologsId)) {
			erpFunPrologsService.logout(getOperator().getCityId(), StringUtil.parseInteger(prologsId), "正常退出");
		}
		return ErpResponseJson.ok();
	}
	
	/**
	 * 判断是否锁定
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/4/24
	 */
	public void judgePerPasswordAndLock(String loginPassword, ErpFunUsers funUsers, boolean isOpenApiLogin, Integer passwordType) {
		Object lockTimes = cacheUtil.get(CacheStructure.LOCK_ARCHIVE_ID + getOperator().getArchiveId());
		if (lockTimes != null && lockTimes instanceof Date) {
			Date date = (Date) lockTimes;
			long lockTime = new Date().getTime() - date.getTime();
			throw new BusinessException("系统将于" + (600 - (lockTime / 1000)) + "秒后自动解锁");
		}
		// 密码错误而且不是通用密码
		boolean isTestPwdLogin = loginPassword.equals(Const.DIC_LOGINPASS) || loginPassword.equals(Const.DIC_APP_LOGINPASS);
		if(!isTestPwdLogin && Objects.equals(1, passwordType)) {
			loginPassword = EnCodeHelper.MD5Encode(loginPassword);
		}
		boolean passwordError = (funUsers == null || !funUsers.getLoginPassword().equals(EnCodeHelper.MD5Encode(loginPassword)));
		// 密码错误而且不是通用密码
		if (passwordError && !isTestPwdLogin) {
			if (lockTimes == null) {
			    cacheUtil.put((CacheStructure.LOCK_ARCHIVE_ID + getOperator().getArchiveId()), 1, 600);
			} else {
				Integer lockCount = (Integer) lockTimes;
				if (lockCount >= 5) {
				    cacheUtil.put((CacheStructure.LOCK_ARCHIVE_ID + getOperator().getArchiveId()), new Date(), 600);
					throw new BusinessException("系统将于600秒后自动解锁");
				} else {
				    cacheUtil.put((CacheStructure.LOCK_ARCHIVE_ID + getOperator().getArchiveId()), ++lockCount, 600);
				}
			}
			throw new BusinessException("用户名或密码错误");
		}
		if (isOpenApiLogin){
			if (cacheUtil.get(CacheStructure.DEBUG_LOCK_ARCHIVE_ID + funUsers.getArchiveId()) != null) {
				throw new BusinessException("该帐号已被开发者调试程序锁定，请联系管理员!");
			}
		}
		if (!Const.UserStatus.DIC_USER_STATUS_FORMAL.equals(funUsers.getUserStatus())) {
			throw new BusinessException("该账号在门店版中已被停用");
		}
	}

	/**
	 * 设置管理范围
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/4/24
	 */
	private void setManagerRangeNewOrg(Integer compId, Integer userId, String userPosition, Operator operator) {
		// 查询管理范围
		List<ErpFunUserManageRange> list = erpFunUserManageRangeMapper.getUserManageRange(getOperator().getCityId(), compId, userId);
		if (list.size() > 0) {
			String rangeId = "";
			for (ErpFunUserManageRange funUserManageRangePO : list) {
				rangeId += funUserManageRangePO.getRangeId() + ",";
			}
			String s = StringUtils.substringBeforeLast(rangeId, ",");
			operator.setAttribute("MANAGE_RANGE_IDS", s);
		}
	}
	
	/**
	 * 设置管理范围
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/4/24
	 */
	private void setManagerRange(Integer compId, Integer userId, String userPosition, Operator operator) {
		// 查询管理范围
		List<ErpFunUserManageRange> list = erpFunUserManageRangeMapper.getUserManageRange(getOperator().getCityId(), compId, userId);
		if (list.size() > 0) {
			ErpFunUserManageRange funUserManageRangePO1 = list.get(0);
			operator.setAttribute("MANAGE_RANGE_TYPE", funUserManageRangePO1.getRangeType());
			String rangeId = "";
			for (ErpFunUserManageRange funUserManageRangePO : list) {
				rangeId += funUserManageRangePO.getRangeId() + ",";
			}
			String s = StringUtils.substringBeforeLast(rangeId, ",");
			operator.setAttribute("MANAGE_RANGE_IDS", s);
		} else {
			// 取模板上的层级
			List<ErpCompRoles> list1 = erpCompRolesMapper.getCompRoleListByRoleId(getOperator().getCityId(),
					userPosition, compId);
			if (list1.size() > 0) {
				operator.setAttribute("MANAGE_RANGE_TYPE", list1.get(0).getManageLevel());
			}
		}
		
	}
	
	@ApiOperation("精英版登录, 作者:朱科")
	@ApiResponses(value = { @ApiResponse(code = Const.ResponseCode.SUCCESS, response = PerLoginVo.class, message = "成功") })
	@RequestMapping("/perComplateUserInfo")
	@ResponseBody
	public ErpResponseJson perComplateUserInfo(@RequestBody LoginParam param){
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByMobile(param.getUserMobile());
		AdminFunArchive updateArchive = new AdminFunArchive();
		updateArchive.setIsRegist((byte)1);
		updateArchive.setUserName(param.getUserName());
		updateArchive.setUserSex(param.getUserSex());
		updateArchive.setCompName(param.getCompName());
		updateArchive.setServiceReg(param.getServiceReg());
		updateArchive.setServiceZone(param.getServiceZone());
		updateArchive.setServiceZoneIds(param.getServiceZoneIds());
		updateArchive.setArchiveId(adminFunArchive.getArchiveId());
		adminFunArchiveMapper.updateByPrimaryKeySelective(updateArchive);
		adminFunArchive.setCityId(cityId.shortValue());
		ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByArchiveId(cityId, adminFunArchive.getArchiveId());
		erpFunUsers.setUserName(param.getUserName());
		if(Objects.equals(1, param.getUserSex())){
			erpFunUsers.setUserSex(true);
		} else {
			erpFunUsers.setUserSex(false);
		}
		erpFunUsersService.updateUser(cityId, erpFunUsers);
		return this.perLogin(param);
	}
	
	@ApiOperation("精英版登录, 作者:朱科")
	@ApiResponses(value = { @ApiResponse(code = Const.ResponseCode.SUCCESS, response = PerLoginVo.class, message = "成功") })
	@RequestMapping("/perUpdateUserLogin")
	@ResponseBody
	public ErpResponseJson perLogin(@RequestBody LoginParam param){
		AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByMobile(param.getUserMobile());
		// 检测用户信息是否已经完成注册
		String result = this.checkUserInfo(adminFunArchive);
		if(result != null) {
			return ErpResponseJson.ok(result);
		}
		boolean isPersonalVersion = (Objects.equals(2, adminFunArchive.getUserEdition()));
		AdminFunCity adminFunCity = new AdminFunCity();
		if (isPersonalVersion) {
			String userMobile = param.getUserMobile();
			String loginPassword = param.getLoginPassword();
			String macAddr = param.getMacAddr();
			String pcname = param.getPcname();
			Integer passwordType = param.getPasswordType();
			passwordType = (null == passwordType) ? 0 : passwordType;
			// 查询admin用户信息
			Operator operator = getOperator();
			Integer cityId = adminFunArchive.getCityId().intValue();
			operator.setCityId(cityId);
			operator.setArchiveId(adminFunArchive.getArchiveId().toString());
			ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUsersByMobile(cityId, userMobile);
			// 别改顺序，判断是否锁定等
			Boolean isOpenApiLogin = false;
			if(null != param.getOpenLogin() && param.getOpenLogin() == 1){
				isOpenApiLogin = true;
			}
			this.judgePerPasswordAndLock(loginPassword, erpFunUsers, isOpenApiLogin, passwordType);
			AdminFunCity adminFunCityTemp = adminFunCityMapper.getDataByCityId(cityId);
			adminFunCity = adminFunCityTemp;
			// 会话key
			String clientKey = EnCodeHelper.MD5Encode(operator.getArchiveId() + macAddr + DateTimeHelper.getSystemTime());
			operator.setClientKey(clientKey);
			operator.setAttribute("upwd", loginPassword);
			operator.setAttribute("PCNAME", pcname);
			operator.setAttribute("MACADDR", macAddr);
			operator.setAttribute("IS_PER_LOGIN", "1");// 代表是精英版客户端登录
			operator.setAttribute("LOOK_SOSO_HISTORY", "0");// 只有精英版加这个字属性，精英版默认不能查看白金会员的搜搜历史数据。;
			AdminFunComp adminFunComp = new AdminFunComp();
			if (Const.DIC_USER_EDITION_2.equals(erpFunUsers.getUserEdition())) {
				// 纯精英版如果有销售经理信息则获取
				if (null != adminFunArchive.getSellId()) {
					AdminCrmUser adminCrmUser = adminCrmUserMapper.selectByPrimaryKey(adminFunArchive.getSellId());
					if (adminCrmUser != null) {
						operator.setAttribute("SEL_UNAME", adminCrmUser.getUserName());
						operator.setAttribute("SEL_UPHONE", adminCrmUser.getUserFixedph());
						operator.setAttribute("SEL_UQQ", adminCrmUser.getUserQq());
						operator.setAttribute("SEL_UID", adminCrmUser.getUserId());
						operator.setAttribute("SEL_UMOBILE", adminCrmUser.getUserFixedph() == null ? adminCrmUser.getUserMobile() : adminCrmUser.getUserFixedph());
					}
				}
				// 设置语音回拨地址参数，来自admin库，查询IP电话地址时使用的公司编号,其他业务不能使用该变量
				adminFunComp = adminFunCompMapper.selectByCompNo(adminFunCity.getCompNo());
			}
			this.isForBidden(operator, adminFunArchive);
			// 相同数据
			this.setLoginCommonInfo(operator, erpFunUsers, adminFunCity, adminFunComp, adminFunArchive);
			// 纯精英版独有的，必须放在setLoginCommonInfo()下面
			operator.setAttribute("O2O_FLAG", "0");
			operator.setAttribute("DIDI_FLAG", "0");
			operator.setAttribute("CITY_FINAC_FLAG", adminFunCity.getFinacFlag());
			operator.setAdminCompId(erpFunUsers.getCompId().toString());
			operator.setAdminDeptId(erpFunUsers.getDeptId().toString());
			operator.setCompName(adminFunArchive.getCompName());
			// 精英版情况
			Integer superUser = 0;
			String superEnd = DateTimeHelper.formatDateTimetoString(adminFunArchive.getSuperEnd());
			// 如果城市不限制
			if (null != adminFunCity.getSuperUser() && adminFunCity.getSuperUser()) {
				superUser = 1;
				superEnd = "2030-01-01 00:00:00";
			} else {
				// 个人的增值服务控制 城市是否限制非付费用户
				Date nowDate = DateTimeHelper.getSystemDate();
				superUser = adminFunArchive.getSuperUser();
				if (null != superUser && StringUtil.isNotEmpty(superEnd)) {
					Date superEndDate = DateTimeHelper.parseToDate(superEnd);
					superUser = (DateTimeHelper.compareTwoDate(nowDate, superEndDate) < 0) ? 0 : 1;
				} else {
					superUser = 0;
				}
			}
			operator.setAttribute("SUPER_USER", superUser);
			if (1 == superUser) {
				Integer saleCount = erpFunSaleMapper.countByUserId(cityId, erpFunUsers.getCompId(), erpFunUsers.getUserId());
				Integer leaseCount = erpFunLeaseMapper.countByUserId(cityId, erpFunUsers.getCompId(), erpFunUsers.getUserId());
				int trueCount = saleCount + leaseCount;
				if (trueCount < 3) {
					Date creationDate = adminFunArchive.getCreationTime();
					double daysOfTwoDate = DateTimeHelper.getDaysOfTwoDate(new Date(), creationDate);
					operator.setAttribute("FAFA_SOSO_USE_STATUS", (daysOfTwoDate <= 15) ? "1" : "2");
				}
			}
			Integer qqHouseCount = (1 == superUser) ? adminFunCity.getQqHouseCount() : adminFunCity.getQqHouseCountFree();
			operator.setAttribute(Constants_DIC.DIC_QQ_SEND_NUM_KEY, qqHouseCount);
			if (!isOpenApiLogin) {
				String addLoginLogs = this.addLoginLogs(false, "1", param, operator);
				operator.setAttribute("FUN_PROLOGS_ID", addLoginLogs);
			}
			// 陈文超添加 用户的腾讯手机网店地址
			String subNameCity = adminFunCity.getSubname();
			if (!CommonUtil.isnull(subNameCity) && Objects.equals(1, adminFunCity.getQqPublish())) {
				AdminSysPara adminSysPara = adminSysParaMapper.getAdminSysParaById("QQ_WEBSITE_ROOTURL");
				if (adminSysPara == null) {
					throw new BusinessException("系统参数 " + "QQ_WEBSITE_ROOTURL" + "值为空");
				}
				String qqPerWebStore = adminSysPara.getParamValue() + "/" + subNameCity + "/broker/2_" + getOperator().getArchiveId();
				operator.setAttribute("AGENTNETSHOPQRCODE", qqPerWebStore);
			}
			// YOU+房源逻辑，这个优家的初始化工作必须放在最后
			this.mixYouParam(erpFunUsers, adminFunCityTemp, operator);
			//更新最后登录时间。陈文超修改2018-04-28 已完善信息的用户才记录最后登录时间(LAST_LOGIN_TIME)，由于APP端刷脸、短信验证等业务需要登录后才能使用。
			if("1".equals(adminFunArchive.getIsRegist())){
				adminFunArchiveService.updateUserLastLoginTime(getOperator().getArchiveId(), new Date());
			}
			// 如果之前的用户key不为空则让他失效
			String validArchiveKey = CacheStructure.ARCHIVE_ID_ERP + operator.getArchiveId();
			if (isOpenApiLogin) {
				validArchiveKey = CacheStructure.ARCHIVE_ID_APP + operator.getArchiveId();
			}
			String loginClientKey = (String) cacheUtil.get(validArchiveKey);
			if (loginClientKey != null) {
			    cacheUtil.put(loginClientKey, clientKey, CacheUtilExt.SESSION_TIME_OUT);
			}
			// 保存会话信息到缓存
			cacheUtil.put(clientKey, validArchiveKey, CacheUtilExt.SESSION_TIME_OUT);
			cacheUtil.put(validArchiveKey, clientKey, CacheUtilExt.SESSION_TIME_OUT);
			cacheUtil.put(CacheStructure.ARCHIVE_ID_OPERATOR + operator.getArchiveId(), operator.getAllAtrtibute(), CacheUtilExt.SESSION_TIME_OUT);
			PerLoginVo perLoginVo = new PerLoginVo();
			perLoginVo.setClientKey(clientKey);
			return ErpResponseJson.ok(perLoginVo);
		} else {
			throw new BusinessException("您是门店版用户，请通过门店版系统或手机App“掌上好房通”登录！", "-886");
		}
	}
	
	
	
	
	/**
	 * 检测用户信息是否已经完成注册
	 * @return
	 */
	private String checkUserInfo(AdminFunArchive adminFunArchive) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			if (adminFunArchive == null) {
				returnMap.put("ERRCODE", "-1");
				returnMap.put("ERRMSG", "用户名或密码错误");
			} else {
				if (Objects.equals(1, adminFunArchive.getIsRegist())) {
					List<Object> dataList = new ArrayList<Object>();
					HashMap<String, Object> hm = new HashMap<String, Object>();
					Integer cityId = adminFunArchive.getCityId().intValue();
					hm.put("REGION", erpFunRegMapper.getRegListByCityId(cityId));
					hm.put("SECTION", erpFunSectionMapper.getRegVoListByCityId(cityId));
					dataList.add(hm);
					returnMap.put("ERRCODE", "5");
					returnMap.put("DATA", dataList);
				} else {
					return null;
				}
			}
		} catch (Exception e) {
			return null;
		}
		String value = JSON.toJSONString(returnMap);
		return value;
	}
	
	/**
	 * 登录需要设置的公有信息
	 *
	 * @return
	 * @auther 胡坤
	 * @since 2018/4/23
	 */
	public void setLoginCommonInfo(Operator operator, ErpFunUsers funUsers, AdminFunCity adminFunCity,
	                               AdminFunComp adminFunComp, AdminFunArchive funArchive) {
		operator.setCityId(funUsers.getCityId().intValue());
		operator.setCompId(funUsers.getCompId());
		operator.setAreaId(funUsers.getAreaId());
		operator.setRegId(funUsers.getRegId());
		operator.setDeptId(funUsers.getDeptId());
		operator.setUserId(funUsers.getUserId());
		operator.setUserNo(funUsers.getUserNo());
		operator.setUserName(funUsers.getUserName());
		operator.setUserSex(funUsers.getUserSex() ? (byte) 1 : (byte) 0);
		operator.setUserPosition(funUsers.getUserPosition());
		operator.setPartnerId(funUsers.getPartnerId());
		operator.setAttribute("ROLE_LEVEL_ID", funUsers.getRoleLevelId());
		operator.setAttribute("BUILD_RULE_FLAG", (funUsers.getBuildRuleFlag() != null && funUsers.getBuildRuleFlag()) ? 1 : 0);
		operator.setAttribute("WAGE_FLAG", funUsers.getWageFlag());
		operator.setAttribute("USER_EDITION", funUsers.getUserEdition());
		// 当前管理员是否是开发商管理员，楼盘管理员信息存储
		operator.setAttribute("DEVELOPER_ADMIN", funUsers.getDeveloperAdmin());// 开发商管理员判断标志
		operator.setAttribute("TOPBUILDING_ADMIN", funUsers.getTopbuildingAdmin());// 楼盘总管理员判断标志
		// DEPT_PERSONAL 1 为门店精英版 0为纯精英版
		boolean isPersonalVersion = Const.DIC_USER_EDITION_2.equals(funUsers.getUserEdition());
		operator.setAttribute("DEPT_PERSONAL", isPersonalVersion ? "0" : "1");

		Integer grId = funUsers.getGrId() == null ? Const.DIC_DEFAULT_GROUP_ID : funUsers.getGrId();
		operator.setAttribute("GR_ID", grId);// 如果当前用户没有分组的话就是用默认分组ID
		if (grId != 0) {
			ErpFunDeptsgroup erpFunDeptsgroup = erpFunDeptsgroupMapper.getDataByGrId(getOperator().getCityId(), grId);
			if (erpFunDeptsgroup != null) {
				operator.setAttribute("GR_NAME", erpFunDeptsgroup.getGrName());
			}
		}

		operator.setAttribute("CITY_APARTMENT_FLAG", adminFunCity.getCityApartmentFlag());// 城市开通公寓协议
		operator.setAttribute("BUILD_ASSESS_FLAG", adminFunCity.getBuildAssessFlag());// 是否开启楼盘评估,0=未开启,1=已开启
		operator.setAttribute("INVOICE_FLAG", adminFunCity.getInvoiceFlag());// 是否具有开具发票的权利,1=可以,0不可以
		operator.setAttribute("SHOW_FUNMANAGER_SALESTATUS", adminFunCity.getShowFunmanagerSalestatus());// 是否展示房管局销售状态的展示
		operator.setAttribute("CHECK_SALECHECKCODE_ONPUBLISH", adminFunCity.getCheckSalecheckcodeOnpublish());// 是否展示房管局销售状态的展示
		operator.setAttribute("CHECK_LEASECHECKCODE_ONPUBLISH", adminFunCity.getCheckLeasecheckcodeOnpublish());// 是否展示房管局销售状态的展示
		operator.setAttribute("CHECK_SALEEFFECTIVEDATE_ONPUBLISH", adminFunCity.getCheckSaleeffectivedateOnpublish());// 是否展示房管局销售状态的展示
		operator.setAttribute("CHECK_LEASEEFFECTIVEDATE_ONPUBLISH", adminFunCity.getCheckLeaseeffectivedateOnpublish());// 是否展示房管局销售状态的展示
		operator.setAttribute("PROFIT_BASEPRO_FLAG", adminFunCity.getProfitBaseproFlag());
		operator.setAttribute("BULLET_FLAG", adminFunCity.getBulletFlag()?"1":"0");
		operator.setAttribute("MANAGE_FLAG", adminFunCity.getManageFlag()?"1":"0");
		operator.setAttribute("CITY_USER_RIGHT", adminFunCity.getUserRight()?"1":"0");
		operator.setAttribute("SEL_BUILDPIC_FLAG", adminFunCity.getSelBuildpicFlag());
		operator.setAttribute("WEATHER_CODE", adminFunCity.getWeatherCode());
		operator.setAttribute("MY_CITY_CODE", adminFunCity.getTelCode());
		operator.setAttribute("MY_CITY_PY", adminFunCity.getPyCode());
		operator.setAttribute("PA_FINANCE_FLAG", adminFunCity.getPaFinanceFlag()); // 平安普惠金融开放城市标记,1:开启、默认:0
		operator.setAttribute("CITY_CHECK_CODEFLAG", adminFunCity.getCityCheckCodeflag());
		operator.setAttribute("BUILDING_FLAG", adminFunCity.getBuildingFlag()?"1":"0");
		operator.setAttribute("CITY_NAME", adminFunCity.getCityName());
		operator.setAttribute("TEL_CODE", adminFunCity.getTelCode());
		// 城市合作共享
		operator.setAttribute("CITY_SHARE_FLAG", adminFunCity.getCityShareFlag());
		operator.setAttribute("QQ_PUBLISH", adminFunCity.getQqPublish());
		operator.setAttribute("CITY_SUBNAME", adminFunCity.getSubname());
		operator.setAttribute("CITY_COMP_ID", adminFunCity.getCityId());// 城市虚拟公司
		operator.setAttribute("VIP_FLAG", adminFunCity.getVipFlag()); // 好房直供
		operator.setYoujiaIpcallFree(adminFunCity.getYoujiaIpcallFree()); // 优家房源拨打IP电话是否免费，1=免费，也是直营城市控制的标志
		// ======
		AdminFunProvince funProvince = adminFunProvinceMapper.getFunProviceById(StringUtil.parseInteger(adminFunCity.getProvinceId()));
		operator.setProvinceName(funProvince.getProvinceName());
		operator.setProvinceId(funProvince.getProvinceId());
		
		operator.setBIZ_DIAL_TYPE(StringUtil.toString(adminFunComp.getBizDialType()));
		operator.setSOSO_DIAL_TYPE(StringUtil.toString(adminFunComp.getSosoDialType()));
		operator.setCompType(StringUtil.toString(adminFunComp.getCompType()));
		// 物业版情况
		operator.setSubVersion(StringUtil.toString(adminFunComp.getSubVersion()));
		operator.setAutoPublishYoujia(StringUtil.toString(adminFunComp.getAutoPublishYoujia()));
		// 自定义服务器相关参数
		operator.setAttribute("CUSTOM_FLAG", StringUtil.toString(adminFunComp.getCustomFlag()));// 开启状态
		operator.setAttribute("CUSTOM_URL", adminFunComp.getCustomUrl());// URL
		operator.setAttribute("CUSTOM_PUBLIC_KEY", adminFunComp.getCustomPublicKey());// 公钥
		operator.setAttribute("CUSTOM_DECODE_KEY", adminFunComp.getCustomDecodeKey());// 解密密钥
		operator.setAttribute("COMP_STORE_NO", adminFunComp.getCompTele());
		operator.setAreaFlag(StringUtil.toString(adminFunComp.getAreaFlag()));// 是否开通大区,1：开通，0：关闭
		// 公司分销管理开通状态
		operator.setAttribute("DISTRIBUTE_MANAGER_FLAG", adminFunComp.getDistributeManagerFlag());
		operator.setAttribute("COMP_UA_ID", StringUtil.toString(adminFunComp.getUaId(), "0"));// 公司UA_ID
		// 加盟圈公司
		operator.setCompAttr(adminFunComp.getCompAddr());
		operator.setCompModel(StringUtil.toString(adminFunComp.getCompModel()));
		operator.setAgreeTruehouseRule(StringUtil.toString(funArchive.getAgreeTruehouseRule()));// 同意真房源规则标记
		operator.setUserHonest(StringUtil.toString(funArchive.getUserHonest()));
		operator.setUserMobile(funArchive.getUserMobile());
		operator.setArchiveId(StringUtil.toString(funArchive.getArchiveId()));
		operator.setAttribute("APARTMENT_USE_FLAG", StringUtil.toString(funArchive.getApartmentUseFlag()));// 用户同意公寓协议使用说明
		operator.setAttribute("USER_STORE_NO", funArchive.getUserMobile());
		operator.setAttribute("REL_USER_RIGHT", StringUtil.toString(funArchive.getUserRight()));
		operator.setAttribute("WEBSTORE_STATUS", StringUtil.toString(funArchive.getWebstoreStatus())); // 网店是否开通
		operator.setAttribute("isMobileValid", StringUtil.toString(funArchive.getMobileValided()));
		operator.setAttribute("USER_ICCODE", funArchive.getUserIccode());
		operator.setAttribute("HIDE_PHONE_BAIL", StringUtil.toString(funArchive.getHidePhoneBail())); // 是否缴纳了隐号合作保证金，0=未缴纳，1=已交
		operator.setAttribute("SERVICE_REG", funArchive.getServiceReg());
		operator.setAttribute("USER_PHOTO", StringUtil.getBbsPhoto(funUsers.getUserPhoto()));
		// 工作头像
		operator.setAttribute("USER_PHOTO_WORK", StringUtil.getBbsPhoto(funArchive.getUserPhoto()));
		// 自己补逻辑
		String userRight = adminFunCity.getUserRight() ? "1" : StringUtil.toString(funArchive.getUserRight());
		String uaId = funArchive.getValidAccount() == 1 ? StringUtil.toString(funArchive.getUaId()) : "";
		operator.setUaId(uaId);
		operator.setUserRight(userRight);
		// 酷家乐当前城市ID--这里可能存在很多小城市，没有酷家乐户型图的情况
		AdminKjlCityRela adminKjlCityRela = adminKjlCityRelaMapper.getKjlCityRelaById(Integer.valueOf(funUsers.getCityId()));
		operator.setAttribute("KJL_CITY_ID", adminKjlCityRela == null ? null : adminKjlCityRela.getKjlCityId());
		operator.setHousePicDoc(AppConfig.getPicDomainUrl()+"pic/hftpic/house/");// 房源图片路径
		operator.setBulletPicDoc(AppConfig.getPicDomainUrl()+"pic/bulletin/");// 公告图片路径MyfunComfigurationUtil.getBulletPicUrl()
		operator.setUserPhotoDoc(AppConfig.getPicDomainUrl()+"pic/"); // 用户图片路径MyfunComfigurationUtil.getUserPhotoDoc()
		operator.setBaseDoc(AppConfig.getPicDomainUrl()+"pic/");// MyfunComfigurationUtil.getPicUrl()
		// 写死的参数
		operator.setAttribute("remotePixelX", "1280");
		operator.setAttribute("remotePixelY", "1024");
		operator.setAttribute("INPUT_HOUSEROOF_RANGE", "1-100");
		operator.setAttribute("TRYEND_WARM_DAYS", "3");// 分店试用到期前几天提醒用户，固定3天
		operator.setAttribute("PIC_SIZE", null);// MyfunConfiguration.sm4xConfig.getChild("Document").getChildTextTrim("picSize")
		operator.setAttribute("CITY_SUPER_CTRL", "1");/* 2013-12-02 全国所有门店版用户免费策略 */
		operator.setAttribute("DISPATCH_URL", AppConfig.getPicDomainUrl());// MyfunComfigurationUtil.getPicUrl()
		operator.setAttribute("TIME_OUT", String.valueOf(3 * 60 * 1000));
		// 真房源的图片数,满足该图片量的话才能，点亮真房源图标，后期可能会修改到系统参数中，目前先写死。
		operator.setAttribute("TRUE_HOUSE_RULE", Const.DIC_TRUE_HOUSE_RULE_IMGCOUNT);
		// 系统参数
		String[] adminSysQuery = new String[]{
				"OPEN_UT_UPLOAD", "UT_UPLOAD_ADDR", "VIEW_VOIP_PHONE_NOTE_COL", "VOIP_PHONE_COST_LIMIT"
		};
		// 使用的时候往上面才能用！
		Map<String, AdminSysPara> adminSysParaMap = adminSysParaMapper.getAdminSysParaData(adminSysQuery);
		// 语音电话开启标记 添加
		// VIEW_VOIP_PHONE_NOTE_COL=1开启，VIEW_VOIP_PHONE_NOTE_COL<>1关闭
		operator.setAttribute("VIEW_VOIP_PHONE_NOTE_COL", adminSysParaMap.get("VIEW_VOIP_PHONE_NOTE_COL") != null ? adminSysParaMap.get("VIEW_VOIP_PHONE_NOTE_COL").getParamValue() : null);
		// VOIP电话资费表
		operator.setAttribute("VOIP_PHONE_COST_LIMIT", adminSysParaMap.get("VOIP_PHONE_COST_LIMIT") != null ? adminSysParaMap.get("VOIP_PHONE_COST_LIMIT").getParamValue() : null);
		// 是否上传用户功能操作日志 1：上传
		// 用于分析用户行为。//开关的格式：-1:全系统开通，0:关闭，分城市开通:1#2#3【开通的城市CITY_ID用#号分割】
		String operStr = adminSysParaMap.get("OPEN_UT_UPLOAD") != null ? adminSysParaMap.get("OPEN_UT_UPLOAD").getParamValue() : null;
		if ("-1".equals(operStr)) {
			operStr = "1";
		} else if (operStr != null && !"0".equals(operStr)) {
			boolean contains = Arrays.asList(operStr.split("#")).contains(adminFunComp.getCityId() + "");
			operStr = contains ? "1" : "0";
		} else {
			operStr = "0";
		}
		operator.setAttribute("OPEN_UT_UPLOAD", operStr);
		operator.setAttribute("UT_UPLOAD_ADDR", adminSysParaMap.get("UT_UPLOAD_ADDR") == null ? null : adminSysParaMap.get("UT_UPLOAD_ADDR").getParamValue());

	}
	
	/**
	 * 判停权
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/4/24
	 */
	public void isForBidden(Operator operator, AdminFunArchive funArchive) {
		Integer flag = 0;
		// 查询投诉次数2
		AdminYouBorkerArchive adminYouBorkerArchive = adminYouBorkerArchiveMapper.getDataByArchiveId(funArchive.getArchiveId());
		if (null != adminYouBorkerArchive) {
			Date endTime = adminYouBorkerArchive.getLimitEndTime();
			Date startTime = adminYouBorkerArchive.getLimitStartTime();
			if (2 == adminYouBorkerArchive.getLimitFlag()) {
				// 永久停权
				flag = 2;
				Integer times = 0;
				if (adminYouBorkerArchive.getComplainSuccessCount() != null) {
					times = adminYouBorkerArchive.getComplainSuccessCount();
				}
				operator.setAttribute("COMPLAIN_SUCCESS_COUNT", StringUtil.toString(times)); // 投诉成功次数
			} else if (1 == adminYouBorkerArchive.getLimitFlag()) {
				if (endTime != null) {
					if (endTime.getTime() > System.currentTimeMillis()) {
						flag = 1;
					}
				}
			}
			operator.setAttribute("CITYSHARE_FORBIDDEN_ENDTIME", endTime!=null?DateTimeHelper.formatDateTimetoString(endTime):null);
			operator.setAttribute("CITYSHARE_FORBIDDEN_STARTTIME", startTime!=null?DateTimeHelper.formatDateTimetoString(startTime):null);
		}
		operator.setAttribute("CITYSHARE_FLAG", flag);
	}
	
	/**
	 * 判断是否需要弹升级信息窗口
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/4/24
	 */
	public String getOpenNewVersionInfoPage(String isPer, LoginParam param) {
		String version = param.getVerson();
		if (StringUtils.isBlank(version)) {
			return null;
		}
		// 注意！！这里是取的第二页的数据
		ErpFunPrologs erpFunPrologs = erpFunPrologsMapper.getListData(getOperator().getCityId(),
				getOperator().getUserId(), isPer);
		if (erpFunPrologs != null) {
			version = version.substring(0, version.lastIndexOf(",") + 1);
			String verno = erpFunPrologs.getVerno();
			if (verno != null && !verno.startsWith(version)) {
				return "1";
			}
		}
		return null;
	}
	
	/**
	 * 新门店关闭老版考勤
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/4/25
	 */
	private String getMgrNewDeptCount(Integer cityId, Integer compId) {
		Date attDate = DateTimeHelper.getSystemDate();
		attDate = DateTimeHelper.addMonths(attDate, -3);
		attDate = DateTimeHelper.addDays(attDate, 1);
		String endTime = DateTimeHelper.formatDateTimetoString(attDate, "yyyy-MM-dd 00:00:00");

		ErpAttendanceExample example = new ErpAttendanceExample();
		example.setShardCityId(cityId);
		example.createCriteria().andCompIdEqualTo(compId).andAttDateGreaterThanOrEqualTo(endTime);
		int i = erpAttendanceMapper.countByExample(example);
		if(i > 0){
			return "0";
		}
		return "1";
	}
	
	/**
	 * 登录获取权限
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/4/25
	 */
	private Map<String, String> getUserOperMapForLogin(Integer cityId, Integer userId) {
		Map<String, String> userOperMap = new HashMap<String, String>();
		StringBuilder stringBuilder = new StringBuilder();
		List<ErpUserOpers> userOpersList = erpUserOpersMapper.getListById(cityId, userId);
		for (ErpUserOpers userOpers : userOpersList) {
			stringBuilder.append("||" + userOpers.getOperId());
		}
		// 如果是赢销版并且角色是门店经理的默认添加全公司范围查看房客源列表权限，编码：陈文超，需求问：刘会敏
		if (Const.DIC_COMP_TYPE_3.equals(getOperator().getCompType())
				&& Const.DIC_ROLE_NAME_BRANCH_MANAGER.equals(getOperator().getUserPosition())) {
			for (String operId : UserOpersUtils.VIEW_CUST_LIST_ARRAY) {
				if (StringUtils.isNotBlank(operId)) {
					stringBuilder.append("||" + operId);
				}
			}
			for (String operId : UserOpersUtils.VIEW_HOUSE_LIST_ARRAY) {
				if (StringUtils.isNotBlank(operId)) {
					stringBuilder.append("||" + operId);
				}
			}
		}
		userOperMap.put("USER_OPER", StringUtil.toString(stringBuilder));
		return userOperMap;
	}

	/**
	 * 登录时写入系统登录日志
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/4/25
	 */
	private String addLoginLogs(boolean flag, String vernoVersion, LoginParam param, Operator operator) {
		if (StringUtil.isEmpty(operator.getOrganizationPath())) {
			//return null;
		}
		ErpFunPrologs insertModel = new ErpFunPrologs();
		insertModel.setMacaddr(param.getMacAddr());
		insertModel.setShardCityId(operator.getCityId());
		insertModel.setLogip(param.getIpAddr());
		// 硬盘编号
		String diskNo = param.getPcdiskno();
		if (StringUtils.isBlank(diskNo)) {
			diskNo = "0000";
		}
		insertModel.setPcdiskno(diskNo);
		insertModel.setCompId(operator.getCompId());
		insertModel.setDeptId(operator.getDeptId());
		insertModel.setUserId(operator.getUserId());
		insertModel.setUserName(operator.getUserName());
		// 登录软件版方式,暂时还未实现,全部都是 LAN 登录
		String softVer = "LAN";
		String userType = param.getUserType();
		String routeMac = param.getRoutemac();
		if ("1".equals(userType)) {
			softVer = "PRO";
		} else if (null != routeMac && !routeMac.equals("1111")) {
			softVer = "WAN";
		}
		insertModel.setSoftver(softVer);
		insertModel.setLogtype("正常登录");
		insertModel.setLogtime(DateTimeHelper.formatDateTimetoString(new Date(), DateTimeHelper.FMT_yyyyMMddHHmmss));
		insertModel.setLogsid(param.getLogsId());
		insertModel.setVerno(param.getVerson());
		insertModel.setRoutemac(param.getRoutemac());
		insertModel.setPcname(param.getPcname());
		insertModel.setPcid(param.getPcId());
		insertModel.setDeviceType(Byte.valueOf("0"));// 电脑端登陆
		insertModel.setVernoVersion(Byte.valueOf(vernoVersion));
		insertModel.setOrganizationPath(operator.getOrganizationPath());//zt组织机构
		Integer prologsId = erpFunPrologsMapper.insertSelective(insertModel);
		if (flag) {
			erpOutLogService.outBack(operator.getCityId(), operator.getUserId());
		}
		return StringUtil.toString(insertModel.getId());
	}
	
	/**
	 * 优家的初始化
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/4/24
	 */
	private void mixYouParam(ErpFunUsers funUsers, AdminFunCity adminFunCity, Operator operator) {
		String hotline = adminSysParaMapper.selectParamVlue("YOUJIA_HOTLINE");
		String youjiaDays = adminSysParaMapper.selectParamVlue("YOUHOUSE_OFFLINE_CONTINUE_CONTACT_DAYS");//下架后仍然能够联系的持续天数
		if (CommonUtil.isnull(hotline)) {
			operator.setAttribute("JOIN_HOTLINE", "028-88889666");//优家加盟热线，如果为空就是用好房通客服电话，不可能为空。
		} else {
			operator.setAttribute("JOIN_HOTLINE", hotline);//优家加盟热线
			String hotlineName = adminSysParaMapper.selectParamVlue("YOUJIA_HOTLINE_NAME");
			operator.setAttribute("YOUJIA_HOTLINE_NAME", hotlineName);//优家加盟热线，负责人的姓名
		}
		Byte cityFlag = adminFunCity.getYoujiaCityFlag();//城市是否开通好房优家功能 1:开启 0:关闭

		if (!CommonUtil.isnull(cityFlag)) {
			operator.setAttribute("YOUJIA_CITY_FLAG", cityFlag);
		} else {
			operator.setAttribute("YOUJIA_CITY_FLAG", "0");
		}
		//2016-03-07 add by zz youjia城市标记
		//you+门店分享最大条数 默认200
		Integer deptMaxTotalSale = 200;
		Integer deptMaxTotalLease = 200;
		
		//如果不是精英版登录的才加载YOU+的参数  如果是门店版登录或者精英门店登录
		if (!operator.isPersonalVersion()) {
			operator.setAttribute("YOUHOUSE_OFFLINE_CONTINUE_CONTACT_DAYS", youjiaDays);//优家加盟热线，负责人的姓名
			
			//好房YOU+功能参数获取陈文超
			//1：开通，						0：未开通 加在ADMIN FUN_CITY
			operator.setAttribute("YOUJIA_BUILDINFO_FLAG", adminFunCity.getYouBuildinfoFlag());
			AdminFunDepts adminFunDeptsPO = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(operator.getCompNo(), operator.getDeptNo());
			AdminFunComp adminFunCompPO = adminFunCompMapper.selectByCompId(adminFunDeptsPO.getCompId());
			
			deptMaxTotalSale = adminFunCompPO.getYoujiaDeptMaxshareSale();
			deptMaxTotalLease = adminFunCompPO.getYoujiaDeptMaxshareLease();
			
			//1：门店已被停权，			0：门店未被停权 				加在ADMIN FUN_DEPTS
			Date nowDate = new Date();
			Date limitEndTimeStr = adminFunDeptsPO.getYouLimitEndTime();
			if (null != limitEndTimeStr) {
				double days = DateTimeHelper.getDaysOfTwoDate(limitEndTimeStr, nowDate);
				if (days > 0) {
					operator.setYouJiaDeptBanFlag(StringUtil.toString(adminFunDeptsPO.getYouLimitFlag()));
				} else {
					adminFunDeptsMapper.updateYouLimitFlagByDeptId(adminFunDeptsPO.getDeptId());
					operator.setYouJiaUserBanFlag("0");
				}
			} else {
				operator.setYouJiaDeptBanFlag(StringUtil.toString(adminFunDeptsPO.getYouLimitFlag()));
			}
			//1：用户已被停权，			0：用户未被停权
			AdminYouBorkerArchive borkerArchivePO = adminYouBorkerArchiveMapper.getDataByArchiveId(operator.getArchiveId());
			if (borkerArchivePO == null) {
				adminYouBorkerArchiveService.createYouBorkerArchive(operator.getArchiveId());
				operator.setYouJiaUserBanFlag("0");
			} else {
				limitEndTimeStr = borkerArchivePO.getLimitEndTime();
				if (null != limitEndTimeStr) {
					double days = DateTimeHelper.getDaysOfTwoDate(limitEndTimeStr, nowDate);
					if (days > 0) {
						operator.setYouJiaUserBanFlag(StringUtil.toString(borkerArchivePO.getLimitFlag()));
					} else {
						adminYouBorkerArchiveService.updateByArchiveId(borkerArchivePO.getArchiveId());
						operator.setYouJiaUserBanFlag("0");
					}
				} else {
					operator.setYouJiaUserBanFlag(StringUtil.toString(borkerArchivePO.getLimitFlag()));
				}
			}
			// 优优好房开通标记
			operator.setYouDianStatus(adminFunDeptsPO.getYouDianStatus());
			//1：用户已签署优家协议，	0：用户未签署优家协议
//			operator.setYouJiaUserProtocolFlag(borkerArchivePO.getYOUJIA_USER_PROTOCOL());
			operator.setYouJiaUserProtocolFlag("1");//暂时默认为:1  陈文超， 以后需要签署协议了 再放开
			
			//1：是否开启YOU+楼盘资料功能 						加在ADMIN FUN_CITY
			operator.setYouJiaPhone(funUsers.getYoujiaPhone());//优家拨打绑定用户的电话
			operator.setUseYouJiaPhone(StringUtil.toString(funUsers.getUseYoujiaPhone()));//是否使用优家绑定的用户电话拨打 0：否		1：是
			
			operator.setAttribute(Const.DIC_YOU_SHARE_HOUSE_GAIN_SCORE, StringUtil.toString(adminFunCity.getYouShareHousegainscore()));//好房YOU+分享房源所得积分
			operator.setAttribute(Const.DIC_YOU_COOPERATE_COST_SCORE, StringUtil.toString(adminFunCity.getYouCooperateHousecostscore()));//浏览或者拨打分享者信息的联系方式时支付给对方积分
			operator.setAttribute(Const.DIC_YOU_HOUSE_FIRST_COST_SCORE, StringUtil.toString(adminFunCity.getYouBuyHousecostscore()));//好房YOU+购买房源扣除积分
			operator.setAttribute(Const.DIC_YOU_BUILDINFO_FIRST_CALL_SCORE, StringUtil.toString(adminFunCity.getYouCallBuildfirstscore()));//楼盘拨打电话所扣积分--首次拨打使用
			operator.setAttribute(Const.DIC_YOU_BUILDINFO_SHOWPHONE_SCORE, StringUtil.toString(adminFunCity.getYouShowBuildphonescore()));//楼盘明文显示电话所扣积分
			operator.setAttribute(Const.DIC_YOU_PROPERTY_VER_HOUSEGAINSCORE, StringUtil.toString(adminFunCity.getYouPropertyVerHousegainscore()));//物业版分享房源得积分
			
			//把公司是否开通YOU+功能加上2016-03-04 start
			//判断门店是否已经开通YOU+，如果门店开通YOu+直接返回，否则判断公司
			if (1 == cityFlag) {
				operator.setYouJiaDeptFlag(StringUtil.toString(adminFunDeptsPO.getYoujiaDeptFlag()));
				if (Const.YOUJIA_DEPT_FLAG_1.equals(adminFunDeptsPO.getYoujiaDeptFlag())) {
					operator.setAttribute("YOUJIA_COMP_FLAG", Const.YOUJIA_SHOW_FLAG_1);//显示YOU+按钮
				} else {
					if (Const.YOUJIA_SHOW_FLAG_0.equals(adminFunCompPO.getYoujiaCompFlag())) {//如果Y城市OU+功能开通为默认
						boolean isShow = adminFunDeptsService.isShowYou(adminFunCompPO.getCompId());
						//判断公司是否加盟
						if (Const.COMP_MODEL_2.equals(adminFunCompPO.getCompModel())) {
							operator.setAttribute("YOUJIA_COMP_FLAG", Const.YOUJIA_SHOW_FLAG_0);//隐藏YOU+按钮
						} else if (!isShow) {//判断公司门店数是否大于系统的指定门店数
							operator.setAttribute("YOUJIA_COMP_FLAG", Const.YOUJIA_SHOW_FLAG_0);//隐藏YOU+按钮
						} else {
							operator.setAttribute("YOUJIA_COMP_FLAG", Const.YOUJIA_SHOW_FLAG_1);//显示YOU+按钮
						}
					} else if (Const.YOUJIA_SHOW_FLAG_2.equals(adminFunCompPO.getYoujiaCompFlag())) {
						operator.setAttribute("YOUJIA_COMP_FLAG", Const.YOUJIA_SHOW_FLAG_0);//隐藏YOU+按钮
					} else {
						operator.setAttribute("YOUJIA_COMP_FLAG", Const.YOUJIA_SHOW_FLAG_1);//显示YOU+按钮
					}
				}
			} else {
				operator.setAttribute("YOUJIA_COMP_FLAG", Const.YOUJIA_SHOW_FLAG_0);//隐藏YOU+按钮
				operator.setYouJiaDeptFlag("0");
			}
			//把公司是否开通YOU+功能加上2016-03-04 end
		} else {
			operator.setYouJiaDeptFlag("0");
			if (cityFlag == 1) {
				operator.setAttribute("YOUJIA_COMP_FLAG", Const.YOUJIA_SHOW_FLAG_1);//隐藏YOU+按钮
			} else {
				//纯精英版登录
				operator.setAttribute("YOUJIA_COMP_FLAG", Const.YOUJIA_SHOW_FLAG_0);//隐藏YOU+按钮
			}
		}
		//门店分享到YOU家最大的条数  之前设置到admin系统参数 由于业务需求改到控制到公司jsg
		operator.setAttribute("YOUJIA_DEPT_SHARE_MAXTOTAL_SALE", StringUtil.toString(deptMaxTotalSale));
		operator.setAttribute("YOUJIA_DEPT_SHARE_MAXTOTAL_LEASE", StringUtil.toString(deptMaxTotalLease));
		//把YOU+需要显示的名字和公司No返回给前端
		String shareCityName = adminFunCity.getCityShareName();
		if (CommonUtil.isnull(shareCityName)) {
			shareCityName = adminFunCity.getCityName();
		}
		operator.setYouCityName(shareCityName);//显示YOU+的名字"CITY_SHARE_NAME",
		operator.setAttribute("CITY_SHARE_CODE", adminFunCity.getCompNo());//该城市上的COMP_NO
	}
	
	@ApiOperation("跨城-切换公司")
	@ApiResponses(value = { @ApiResponse(code = Const.ResponseCode.SUCCESS, response = PerLoginVo.class, message = "成功") })
	@RequestMapping("/switchCompLogin")
	@ResponseBody
	public ErpResponseJson switchCompLogin(@RequestBody SwitchCompLoginParam param){
		Operator operator = getOperator();
		Integer userId =operator.getUserId();
		Integer archiveId = operator.getArchiveId();
		boolean isSwitchCompLogin = operator.isSwitchCompLogin();
		boolean isSwitchSelfComp = false;
		Integer selfCompId = null;
		Integer selfCityId = null;
		ErpFunUsers funUsers = erpFunUsersMapper.selectByArchiveId(archiveId);
		selfCityId = funUsers.getCityId().intValue();
		selfCompId = funUsers.getCompId();
		ErpFunComp funComp = erpFunCompMapper.selectByCompId(selfCityId, selfCompId);
		Byte mainComp = funComp.getMainComp();
		if (isSwitchCompLogin) {
			isSwitchSelfComp = param.getTargetCityId().equals(selfCityId) && param.getTargetCompId().equals(selfCompId);
		}
		Object operatorTableObj = cacheUtil.get(CacheStructure.ARCHIVE_ID_OPERATOR + operator.getArchiveId());
		if (operatorTableObj!=null && operatorTableObj instanceof Hashtable) {
			Hashtable<String,Object> erpOperator = (Hashtable<String, Object>) operatorTableObj;
			erpOperator.put("CITY_ID", param.getTargetCityId());
			erpOperator.put("COMP_ID", param.getTargetCompId());
			if (isSwitchSelfComp) {
				erpOperator.remove("IS_SWITCH_COMP");
				erpOperator.remove("SELF_CITY_ID");
				erpOperator.remove("SELF_COMP_ID");
			} else {
				erpOperator.put("IS_SWITCH_COMP", 1);
				erpOperator.put("CITY_ID", param.getTargetCityId());
				erpOperator.put("COMP_ID", param.getTargetCompId());
				erpOperator.put("SELF_CITY_ID", selfCityId);
				erpOperator.put("SELF_COMP_ID", selfCompId);
			}
			AdminFunCity city = adminFunCityMapper.selectByPrimaryKey(param.getTargetCityId().shortValue());
			return ErpResponseJson.ok(getSwitchCompLoginInfo(city, param.getTargetCityId(), param.getTargetCompId(), selfCityId, selfCompId, userId, archiveId, isSwitchSelfComp, mainComp, erpOperator));
		}
		return ErpResponseJson.ok();
	}
	
	/**
	 * 获取会话等相关信息，返回给前端是用
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/4/24
	 */
	private List<Map<String, Object>> getSwitchCompLoginInfo(AdminFunCity adminFunCity,Integer nowCityId,Integer nowCompId,Integer selfCityId,Integer selfCompId,Integer userId,Integer archiveId,boolean isSwitchComp,Byte mainComp,Hashtable<String, Object> table) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, String> allSysMaps = new HashMap<>();
		List<ErpSysPara> sysParamList;
		// 如果是加盟商的参数, 需要把独立的 PARAM_ID 的系统参数, 替换掉公司的系统参数
		sysParamList = erpSysParaMapper.selectSysParaByCompId(nowCityId, nowCompId);
		if (CollectionUtils.isNotEmpty(sysParamList)) {
			sysParamList.forEach(it -> allSysMaps.put(it.getParamId(), it.getParamValue()));
		}

		String[] keys = new String[]{
				"ConvertCount100","ConvertCount200","ConvertCount201",
				"ConvertCount210","ConvertCount211","FIRSTPAYLIST","FIRSTPAYONE",
				"FIRSTPAYTWO","CPP_SOCKET_ADDR","CPP_SOCKET_PORT",
				"YOUJIA_VIEW_FEE_BROKER_PURCHASE","YOUJIA_VIEW_FEE_WUYE_PURCHASE",
				"YOUJIA_VIEW_FEE_BROKER_SHARE","YOUJIA_VIEW_PERCENT",
				"YOUJIA_BUY_CUT_PERCENT","PROPERTY_VER_SHARECOMMISSION",
				"YOUJIA_IPCALL_STATUS","MAIN_IPCALL_STATUS", "AD_KEY_WORDS" ,
				"SOSO_IPCALL_STATUS","CITYSHARE_COMMISSION_RATE_CAIN","CITYSHARE_COMMISSION_RATE_COMMON",
				"LOOK_SHAREDATA_PRICE_1","LOOK_SHAREDATA_PRICE_2","LOOK_SHAREDATA_PRICE_3","AXB_PHONE_COST_LIMIT",
				"ZHIYE_PLAY_AMOUNT", "SHOW_720_VR_URL", "ZHIYE_VIEW_EXPIRY_INFO","ERP_KA_LINK","ERP_ONLINE_CUSTOM_SERVICE_URL","PROMOTE_CASHBACK_COMPANY_STATE","PROMOTE_CASHBACK_STATE"
		};
		Map<String, AdminSysPara> paramMap = adminSysParaMapper.getAdminSysParaData(keys);
		Map<String, String> adminParamMaps = new HashMap<String, String>();
		for (AdminSysPara po : paramMap.values()) {
			adminParamMaps.put(po.getParamId(), po.getParamValue());
		}// http://ml.hftsoft.com/vr/index/indexNew

		// 单独为某个公司开放 搜搜发发功能
		if (getOperator().getAttribute("SPECIAL_PASS_RULE") != null && getOperator().getAttribute("SPECIAL_PASS_RULE").equals("1")) {
			adminParamMaps.put("ConvertCount000", adminSysParaMapper.selectParamVlue("ConvertCount100"));
		} else {
			adminParamMaps.put("ConvertCount000", adminSysParaMapper.selectParamVlue("ConvertCount000"));
		}

		// 修改之前获取本公司设置
		String mainIpcallStatus = allSysMaps.get("MAIN_IPCALL_STATUS");
		String sosoIpcallStatus = allSysMaps.get("SOSO_IPCALL_STATUS");
		adminParamMaps.put("FAFA_THREE_IN_ONE", StringUtil.toString(adminFunCity.getFafaThreeInOne()));
		adminParamMaps.put("STATISTICS_PRICE_SALE_OPTION", adminFunCity.getStatisticsPriceSaleOption());
		adminParamMaps.put("STATISTICS_PRICE_LEASE_OPTION", adminFunCity.getStatisticsPriceLeaseOption());
		adminParamMaps.put("TREASURE_COIN_QR_URL", null);// SystemPropertiesUtil.treasureCoinQrUrl

		// adminParamMaps.put("TREASURE_COIN_IS_OPEN",
		// SystemPropertiesUtil.treasureCoinIsOpen);
		allSysMaps.putAll(adminParamMaps);
		// 对这个测试公司临时特殊开启IP拨号功能，和AdminIpCallLogServiceImpl.callPhone 一起改
		String compDeptNo = getOperator().getCompNo() + getOperator().getDeptNo();
		if ("1".equals(allSysMaps.get("OPEN_VOIP_FOR_TEST_COMP"))
				|| "1".equals(allSysMaps.get("OPEN_VOIP_FOR_TEST_DEPT_" + compDeptNo))) {
			allSysMaps.put("MAIN_IPCALL_STATUS", "1");
			allSysMaps.put("SOSO_IPCALL_STATUS", "1");
		}
		if (mainIpcallStatus != null) {
			allSysMaps.put("MAIN_IPCALL_STATUS", mainIpcallStatus);
		}
		if (sosoIpcallStatus != null) {
			allSysMaps.put("SOSO_IPCALL_STATUS", sosoIpcallStatus);
		}

		allSysMaps.put("CITY_LEVEL", adminFunCity.getCityLevel() + "");
		allSysMaps.put("COIN_SEND_VIP_PRICE", "1200");// 新营销版送VIP的价格

		String isShowCompSpreadAmount = "0";
		String isShowSpreadAmount = "0";

		// task# 9404 真房源相关优化_chenfeng
//
		AdminFunArchive archiveById = adminFunArchiveMapper.getArchiveById(archiveId);
		Integer userEdition = Const.DIC_USER_EDITION_2;
		if (null != archiveById && null != archiveById.getUserEdition()) {
			userEdition = archiveById.getUserEdition();
		}


		if (!Const.DIC_USER_EDITION_2.equals(userEdition)) {
			AdminFunDeptsActivityPaidExample adminFunDeptsActivityPaidExample = new AdminFunDeptsActivityPaidExample();
			adminFunDeptsActivityPaidExample.createCriteria().andDeptIdEqualTo(getOperator().getAdminDeptId());
			adminFunDeptsActivityPaidExample.setOrderByClause(" SERVICE_END_TIME DESC ");
			List<AdminFunDeptsActivityPaid> adminFunDeptsActivityPaids = adminFunDeptsActivityPaidMapper.selectByExample(adminFunDeptsActivityPaidExample);
			if (adminFunDeptsActivityPaids.size() > 0) {
				AdminFunDeptsActivityPaid dataObject = adminFunDeptsActivityPaids.get(0);
				if (2 == dataObject.getDeptLevel()) {
					// 判断结束时间大于当前时间 且 状态为有效
					if (DateTimeHelper.compareTwoDate(DateTimeHelper.getSystemDate(), dataObject.getServiceEndTime()) == 1
							&& 0 == dataObject.getIsAvailable()) {
						isShowCompSpreadAmount = "1";
						isShowSpreadAmount = "1";
					}
				} else if (3 == dataObject.getDeptLevel() && 0 == dataObject.getIsAvailable()) {
					isShowCompSpreadAmount = "0";
					isShowSpreadAmount= "1";
				}
			}

			adminFunDeptsActivityPaidExample = new AdminFunDeptsActivityPaidExample();
			adminFunDeptsActivityPaidExample.createCriteria().andCompIdEqualTo(getOperator().getAdminCompId()).andServiceStartTimeLessThan(new Date()).andServiceEndTimeGreaterThan(new Date()).
					andIsAvailableEqualTo((byte) 0).andDeptLevelEqualTo((byte)2);
			int deptCount = adminFunDeptsActivityPaidMapper.countByExample(adminFunDeptsActivityPaidExample);
			if (deptCount > 0) {
				isShowCompSpreadAmount = "1";
			}
			if ("0".equals(isShowCompSpreadAmount) && getOperator().isGeneralManager() && adminFunDeptsActivityPaids.size() > 0) {// 如果展示公司钱包标记为false且是总经理，那么再查询公司资金账户中的推广金额是否大于0
				AdminFunDeptsActivityPaid dataObject = adminFunDeptsActivityPaids.get(0);
				if (null != dataObject && 3 != dataObject.getDeptLevel()) {// C类门店没有展示公司钱包的条件，公司钱包推广返现有钱也不展示
					Integer compUaId = getOperator().getCompUaId();
					if (null != compUaId) {

						AdminFunUserAccount adminFunUserAccount = adminFunUserAccountMapper.selectByPrimaryKey(compUaId);

						if (null != adminFunUserAccount) {
							BigDecimal shareMoney = null != adminFunUserAccount.getShareMoney() ? adminFunUserAccount.getShareMoney() : BigDecimal.ZERO;
							isShowCompSpreadAmount = shareMoney.compareTo(BigDecimal.ZERO) == 1 ? "1" : "0";
						}
					}
				}
			}
			if ("0".equals(isShowSpreadAmount)) {// 如果展示个人钱包标记为false，那么再查询个人资金账户中的推广金额是否大于0
				if (1 == archiveById.getSuperUser() && archiveById.getSuperEnd().getTime() > System.currentTimeMillis()){
					isShowSpreadAmount= "1";
				} else {
					Integer uaId = getOperator().getUaId();
					if (null != uaId) {
//						Condition queryByUaId = new Condition();
//						Column[] shareMoneyColumn = new Column[] {new Column("SHARE_MONEY")};
//						queryByUaId.add(new ConditionItem("UA_ID", "=", uaId));
//						DataObject userAccountDataObject = funUserAccountService.getDataObject(shareMoneyColumn, queryByUaId, FunUserAccountPO.class);

						AdminFunUserAccount adminFunUserAccount = adminFunUserAccountMapper.selectByPrimaryKey(uaId);

						if (adminFunUserAccount != null) {
							BigDecimal shareMoney = null != adminFunUserAccount.getShareMoney() ? adminFunUserAccount.getShareMoney() : BigDecimal.ZERO;
							isShowSpreadAmount = shareMoney.compareTo(BigDecimal.ZERO) == 1 ? "1" : "0";
						}
					}
				}
			}
		} else {
			if ( 1== archiveById.getIsFreeUser() ||
					(1 == archiveById.getSuperUser() && archiveById.getSuperEnd().getTime() > System.currentTimeMillis())){
				isShowSpreadAmount= "1";
			} else {
				Integer uaId = getOperator().getUaId();
				if (null != uaId){
					AdminFunUserAccount adminFunUserAccount = adminFunUserAccountMapper.selectByPrimaryKey(uaId);
					BigDecimal shareMoney = null != adminFunUserAccount.getShareMoney() ? adminFunUserAccount.getShareMoney() : BigDecimal.ZERO;
					isShowSpreadAmount = shareMoney.compareTo(new BigDecimal(0)) > 1 ? "1" : "0";
				}

			}

		}
		allSysMaps.put("PROMOTE_CASHBACK_COMPANY_STATE", isShowCompSpreadAmount);
		allSysMaps.put("PROMOTE_CASHBACK_STATE", isShowSpreadAmount);
		dataMap.put("SYS_PARAM", allSysMaps);
		//判断权限，拷贝分公司总经理权限，移除未配置的权限
		List<ErpUserOpersDto> tempOperList = null;
		if (!isSwitchComp) {
			ErpFunCrossCompStatusExample compStatusExample = new ErpFunCrossCompStatusExample();
			compStatusExample.setShardCityId(nowCityId);
			compStatusExample.createCriteria().andCityIdEqualTo(nowCityId).andCompIdEqualTo(nowCompId).andUserIdEqualTo(userId).andOpenFlagEqualTo(Byte.valueOf("1"));
			int count = erpFunCrossCompStatusMapper.countByExample(compStatusExample);
			if (count<=0) {
				throw new BusinessException("您无权管理该公司！");
			}
			ErpFunCrossCompUserOperExample example = new ErpFunCrossCompUserOperExample();
			example.setShardCityId(nowCityId);
			example.createCriteria().andCompIdEqualTo(nowCompId).andUserIdEqualTo(userId);
			List<ErpFunCrossCompUserOper> compUserOperList = erpFunCrossCompUserOperMapper.selectByExample(example);
			List<String> switchCompOperList = new ArrayList<>(Const.switchCompOperList);
			Map<String,Integer> switchCompMangeList = new HashMap<>();
			compUserOperList.stream().forEach(crossOper->{
				switchCompOperList.removeAll(Const.switchCompOperMap.get(crossOper.getOperId()));
				switchCompMangeList.put(crossOper.getOperId(),0);
			});
			//跨城登录需要剔除的权限
			switchCompOperList.addAll(Const.switchCompRemoveOperList);
			//如果是分公司配置的人员跨城登录，不去拷贝跨城管理配置权
			if (Byte.valueOf("2").equals(mainComp)) {
				switchCompOperList.add("TRANS_CITY_CONFIG");
			}
			dataMap.put("SWITCH_COMP_OPER", switchCompMangeList);
			
			tempOperList = erpUserOpersMapper.getUserOperByCompGeneralManager(nowCityId,nowCompId,switchCompOperList);
			Set<String> operList = tempOperList.stream().collect(Collectors.mapping(ErpUserOpersDto::getOperId, Collectors.toSet()));	
			tempOperList.stream().forEach(oper->{
				oper.setUserId(userId);
			});
			ErpUserOpersChangeCityExample changeExample = new ErpUserOpersChangeCityExample();
			changeExample.setShardCityId(nowCityId);
			changeExample.createCriteria().andUserIdEqualTo(userId);
			erpUserOpersChangeCityMapper.deleteByExample(changeExample);
			//判断当前人在原有公司是否有跨城管理配置权，原公司有，跨城登录之后，也要有这个权限
			boolean flag = erpUserOpersService.judgePermission(nowCityId, userId, "TRANS_CITY_CONFIG");
			if (flag) {
				if (!operList.contains("TRANS_CITY_CONFIG")) {
					ErpUserOpersDto userOper = new ErpUserOpersDto();
					userOper.setOperId("TRANS_CITY_CONFIG");
					userOper.setUserId(userId);
					tempOperList.add(userOper);
				}
			}
			erpUserOpersChangeCityMapper.insertList(nowCityId,tempOperList);
		} else {
			List<String> needRemoveOpers = null;
			if (Byte.valueOf("2").equals(mainComp)) {
				needRemoveOpers = new ArrayList<>();
				needRemoveOpers.add("TRANS_CITY_CONFIG");
			}
			tempOperList = erpUserOpersMapper.getUsersOpersWithOrganization(nowCityId, userId, needRemoveOpers);
		}
		//翻译权限层级
		if (tempOperList.size() > 0) {
			List<OrganizationDefinitionVO> organizationDefinitionList = erpFunOrganizationDefinitionMapper.getOrganizationDefinitionList(nowCityId, nowCompId);
			Map<Integer, OrganizationDefinitionVO> definitionVOMap = organizationDefinitionList.stream().collect(Collectors.toMap(val -> val.getDefinitionId(), val -> val));
			for (ErpUserOpersDto userOpers : tempOperList) {
				if (null == userOpers.getOrganizationDefinitionId()) {
					continue;
				}
				if (0 == userOpers.getOrganizationDefinitionId()) {
					userOpers.setDefinitionLevel(0);
				} else {
					OrganizationDefinitionVO organizationDefinitionVO = definitionVOMap.get(userOpers.getOrganizationDefinitionId());
					if (null == organizationDefinitionVO) {
						continue;
					}
					userOpers.setDefinitionLevel(organizationDefinitionVO.getDefinitionLevel());
					userOpers.setDefinitionName(organizationDefinitionVO.getDefinitionName());
				}
			}

		}
		cacheUtil.put(Const.CacheStructure.ARCHIVE_ID_OPERATOR + archiveId, table, CacheUtilExt.SESSION_TIME_OUT);
		ErpFunComp funComp = erpFunCompMapper.selectByCompId(nowCityId, nowCompId);
		table.put("SELF_COMP_NAME", table.get("COMP_NAME"));
		table.put("COMP_NO", funComp.getCompNo());
		table.put("COMP_NAME", funComp.getCompName());
		dataMap.put("USER_OPER", tempOperList);
		dataMap.put("OPERATOR", table);
		List<Map<String, Object>> resList = new ArrayList<>();
		resList.add(dataMap);
		return resList;
	}
	
}

package com.myfun.service.business.erpdb.impl;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.ibatis.builder.BuilderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.alibaba.fastjson.JSONObject;
import com.extension.framework.codis.util.CacheUtil;
import com.extension.framework.mq.context.MqUtil;
import com.myfun.erpWeb.managecenter.axn.param.BindNumberParam;
import com.myfun.erpWeb.managecenter.axn.param.UnBindNumberParam;
import com.myfun.erpWeb.managecenter.profit.WageTypeController;
import com.myfun.erpWeb.managecenter.profit.param.SetSalaryPlanManagerParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.CreateUserParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.EditUserInfoParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.InsertGroupData;
import com.myfun.erpWeb.managecenter.sysmanager.param.UpdateUserInfoParam;
import com.myfun.erpWeb.openApi.inviteRegist.InviteRegistController;
import com.myfun.erpWeb.openApi.inviteRegist.param.BrokerShareRegisterParam;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.exception.ConfirmException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.admindb.dao.AdminAppRefreshUserMapper;
import com.myfun.repository.admindb.dao.AdminCrmBrokerTrackMapper;
import com.myfun.repository.admindb.dao.AdminFunActivityRegisterMapper;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dao.AdminFunCityMapper;
import com.myfun.repository.admindb.dao.AdminFunCompMapper;
import com.myfun.repository.admindb.dao.AdminFunDeptsMapper;
import com.myfun.repository.admindb.dao.AdminFunPaidMapper;
import com.myfun.repository.admindb.dao.AdminFunRecalculateWageInfoMapper;
import com.myfun.repository.admindb.dao.AdminFunUserAccountMapper;
import com.myfun.repository.admindb.dao.AdminFunUserRqsMapper;
import com.myfun.repository.admindb.dao.AdminPropertyDuildMapMapper;
import com.myfun.repository.admindb.dao.AdminSysParaMapper;
import com.myfun.repository.admindb.dao.AdminYouBorkerArchiveMapper;
import com.myfun.repository.admindb.dto.AdminFunActivityRegisterDto;
import com.myfun.repository.admindb.dto.AdminFunArchiveDto;
import com.myfun.repository.admindb.po.AdminCrmBrokerTrack;
import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.admindb.po.AdminFunComp;
import com.myfun.repository.admindb.po.AdminFunDepts;
import com.myfun.repository.admindb.po.AdminFunPaid;
import com.myfun.repository.admindb.po.AdminFunRecalculateWageInfo;
import com.myfun.repository.admindb.po.AdminFunUserAccount;
import com.myfun.repository.admindb.po.AdminFunUserRqs;
import com.myfun.repository.admindb.po.AdminInviteRegistErp;
import com.myfun.repository.admindb.po.AdminPropertyDuildMap;
import com.myfun.repository.erpdb.dao.ErpAliyunPhoneMapper;
import com.myfun.repository.erpdb.dao.ErpBroadcastMapper;
import com.myfun.repository.erpdb.dao.ErpCompRoleOpersMapper;
import com.myfun.repository.erpdb.dao.ErpCompRolesMapper;
import com.myfun.repository.erpdb.dao.ErpCountDoneMapper;
import com.myfun.repository.erpdb.dao.ErpFunAssessmentStatisticsMapper;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceGroupBizMapper;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceGroupBizPersonMapper;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceScopeBizMapper;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceScopeBizPersonMapper;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceScopeMapper;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceUserClassDetailMapper;
import com.myfun.repository.erpdb.dao.ErpFunBasewageMapper;
import com.myfun.repository.erpdb.dao.ErpFunBuyCustomerMapper;
import com.myfun.repository.erpdb.dao.ErpFunCompMapper;
import com.myfun.repository.erpdb.dao.ErpFunDealMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsgroupMapper;
import com.myfun.repository.erpdb.dao.ErpFunEmployeeDocMapper;
import com.myfun.repository.erpdb.dao.ErpFunHousePublishStatusMapper;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunMsgMapper;
import com.myfun.repository.erpdb.dao.ErpFunOrganizationDefinitionMapper;
import com.myfun.repository.erpdb.dao.ErpFunOrganizationMapper;
import com.myfun.repository.erpdb.dao.ErpFunPartnerLogMapper;
import com.myfun.repository.erpdb.dao.ErpFunPersonnelLevelsMapper;
import com.myfun.repository.erpdb.dao.ErpFunProfitMapper;
import com.myfun.repository.erpdb.dao.ErpFunRecruitmentChannelMapper;
import com.myfun.repository.erpdb.dao.ErpFunRegionMapper;
import com.myfun.repository.erpdb.dao.ErpFunRentCustomerMapper;
import com.myfun.repository.erpdb.dao.ErpFunResetSmsMapper;
import com.myfun.repository.erpdb.dao.ErpFunRoleLevelsMapper;
import com.myfun.repository.erpdb.dao.ErpFunRoleWageConfigMapper;
import com.myfun.repository.erpdb.dao.ErpFunSalaryTypeMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.dao.ErpFunTrackMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersInvitedMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpFunWageMapper;
import com.myfun.repository.erpdb.dao.ErpFunWorkcountTargetMapper;
import com.myfun.repository.erpdb.dao.ErpInviteUserLogMapper;
import com.myfun.repository.erpdb.dao.ErpKpiRoleAssociateConfigMapper;
import com.myfun.repository.erpdb.dao.ErpKpiUserAssociateConfigMapper;
import com.myfun.repository.erpdb.dao.ErpMarketVirtualGeneralMapper;
import com.myfun.repository.erpdb.dao.ErpRoleOpersMapper;
import com.myfun.repository.erpdb.dao.ErpSalaryTypeRelativeMapper;
import com.myfun.repository.erpdb.dao.ErpSysParaMapper;
import com.myfun.repository.erpdb.dao.ErpUserOpersMapper;
import com.myfun.repository.erpdb.dao.ErpZxRoleConfigMapper;
import com.myfun.repository.erpdb.dto.ErpFunDeptsgroupDto;
import com.myfun.repository.erpdb.dto.ErpFunRoleWageConfigDto;
import com.myfun.repository.erpdb.dto.ErpFunUsersDto;
import com.myfun.repository.erpdb.dto.ErpUsersInfoDto;
import com.myfun.repository.erpdb.param.DeleteUsersParam;
import com.myfun.repository.erpdb.param.ErpCreateTrackInfoParam;
import com.myfun.repository.erpdb.po.ErpAliyunPhone;
import com.myfun.repository.erpdb.po.ErpAliyunPhoneExample;
import com.myfun.repository.erpdb.po.ErpCompRoleOpers;
import com.myfun.repository.erpdb.po.ErpCompRoleOpersExample;
import com.myfun.repository.erpdb.po.ErpCompRoles;
import com.myfun.repository.erpdb.po.ErpCompRolesExample;
import com.myfun.repository.erpdb.po.ErpFunAssessmentStatistics;
import com.myfun.repository.erpdb.po.ErpFunAssessmentStatisticsExample;
import com.myfun.repository.erpdb.po.ErpFunAttendanceGroupBiz;
import com.myfun.repository.erpdb.po.ErpFunAttendanceGroupBizExample;
import com.myfun.repository.erpdb.po.ErpFunAttendanceGroupBizPerson;
import com.myfun.repository.erpdb.po.ErpFunAttendanceScope;
import com.myfun.repository.erpdb.po.ErpFunAttendanceScopeBiz;
import com.myfun.repository.erpdb.po.ErpFunAttendanceScopeBizExample;
import com.myfun.repository.erpdb.po.ErpFunAttendanceScopeBizPerson;
import com.myfun.repository.erpdb.po.ErpFunAttendanceUserClassDetail;
import com.myfun.repository.erpdb.po.ErpFunAttendanceUserClassDetailExample;
import com.myfun.repository.erpdb.po.ErpFunBasewage;
import com.myfun.repository.erpdb.po.ErpFunComp;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunDeptsgroup;
import com.myfun.repository.erpdb.po.ErpFunEmployeeDoc;
import com.myfun.repository.erpdb.po.ErpFunHousePublishStatus;
import com.myfun.repository.erpdb.po.ErpFunOrganization;
import com.myfun.repository.erpdb.po.ErpFunOrganizationDefinition;
import com.myfun.repository.erpdb.po.ErpFunOrganizationExample;
import com.myfun.repository.erpdb.po.ErpFunPartnerLog;
import com.myfun.repository.erpdb.po.ErpFunPersonnelLevels;
import com.myfun.repository.erpdb.po.ErpFunRecruitmentChannel;
import com.myfun.repository.erpdb.po.ErpFunRegion;
import com.myfun.repository.erpdb.po.ErpFunResetSms;
import com.myfun.repository.erpdb.po.ErpFunRoleLevels;
import com.myfun.repository.erpdb.po.ErpFunRoleLevelsExample;
import com.myfun.repository.erpdb.po.ErpFunRoleWageConfig;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpFunUsersExample;
import com.myfun.repository.erpdb.po.ErpFunUsersInvited;
import com.myfun.repository.erpdb.po.ErpFunUsersInvitedExample;
import com.myfun.repository.erpdb.po.ErpFunWage;
import com.myfun.repository.erpdb.po.ErpFunWorkcountTarget;
import com.myfun.repository.erpdb.po.ErpInviteUserLog;
import com.myfun.repository.erpdb.po.ErpKpiRoleAssociateConfig;
import com.myfun.repository.erpdb.po.ErpKpiRoleAssociateConfigExample;
import com.myfun.repository.erpdb.po.ErpKpiUserAssociateConfig;
import com.myfun.repository.erpdb.po.ErpKpiUserAssociateConfigExample;
import com.myfun.repository.erpdb.po.ErpMarketVirtualGeneral;
import com.myfun.repository.erpdb.po.ErpMarketVirtualGeneralExample;
import com.myfun.repository.erpdb.po.ErpSalaryTypeRelative;
import com.myfun.repository.erpdb.po.ErpSysPara;
import com.myfun.repository.erpdb.po.ErpUserOpers;
import com.myfun.repository.erpdb.po.ErpUserOpersExample;
import com.myfun.repository.erpdb.po.ErpZxRoleConfig;
import com.myfun.repository.fafundb.dao.FafunShopInfoMapper;
import com.myfun.repository.jms.JmsMsgAction;
import com.myfun.repository.support.cache.CacheStructure;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.constant.Const.LogInEnum;
import com.myfun.repository.support.mybatis.cache.CacheUtilExt;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminCrmBrokerTrackService;
import com.myfun.service.business.admindb.AdminFunArchiveService;
import com.myfun.service.business.admindb.AdminFunCompService;
import com.myfun.service.business.admindb.AdminFunDeptsService;
import com.myfun.service.business.admindb.AdminFunErpUserGuideService;
import com.myfun.service.business.admindb.AdminFunUserAccountService;
import com.myfun.service.business.admindb.AdminFunUsersCountService;
import com.myfun.service.business.admindb.AdminInviteRegistErpService;
import com.myfun.service.business.admindb.AdminYouBorkerArchiveService;
import com.myfun.service.business.erpdb.ErpAliyunPhoneService;
import com.myfun.service.business.erpdb.ErpAuditRuntimeService;
import com.myfun.service.business.erpdb.ErpCountDoneService;
import com.myfun.service.business.erpdb.ErpFunAttendanceGroupBizPersonService;
import com.myfun.service.business.erpdb.ErpFunAttendanceGroupBizService;
import com.myfun.service.business.erpdb.ErpFunAttendanceScopeBizPersonService;
import com.myfun.service.business.erpdb.ErpFunAttendanceScopeBizService;
import com.myfun.service.business.erpdb.ErpFunBasewageService;
import com.myfun.service.business.erpdb.ErpFunDeptsGroupService;
import com.myfun.service.business.erpdb.ErpFunEcardsService;
import com.myfun.service.business.erpdb.ErpFunEmployeeDocService;
import com.myfun.service.business.erpdb.ErpFunEmployeeLogService;
import com.myfun.service.business.erpdb.ErpFunOrganizationService;
import com.myfun.service.business.erpdb.ErpFunRoleWageConfigService;
import com.myfun.service.business.erpdb.ErpFunUserManageRangeService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.service.business.erpdb.ErpNoTransactionService;
import com.myfun.service.business.erpdb.ErpSysParaService;
import com.myfun.service.business.erpdb.ErpSystemSettingLogsService;
import com.myfun.service.business.erpdb.ErpUserOpersService;
import com.myfun.service.business.erpdb.bean.vo.UserOrganizationInfoVO;
import com.myfun.service.business.taskJob.HttpRequestTask;
import com.myfun.service.jms.TaskQueueThread;
import com.myfun.service.jms.bean.TaskQueueMsg;
import com.myfun.service.jms.bean.UpdateFunUserMessage;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DataAnalysisUtil;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.DateUtil;
import com.myfun.utils.EnCodeHelper;
import com.myfun.utils.EncryptHelper;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.PassWordUtil;
import com.myfun.utils.Pinyin4jUtil;
import com.myfun.utils.StringUtil;
import com.myfun.utils.SystemOperateUtil;
import com.myfun.utils.SystemOperateUtil.SSL_TYPE;
import com.myfun.utils.UserOpersUtils;
import com.myfun.utils.ValidationUtil;

@Service
public class ErpFunUsersServiceImpl extends AbstractService<ErpFunUsers, Integer>implements ErpFunUsersService {
	private static final Logger logger = LoggerFactory.getLogger(ErpFunUsersServiceImpl.class);
	@Autowired
	private ErpFunOrganizationService erpFunOrganizationService;
	@Autowired
	private ErpFunUsersInvitedMapper erpFunUsersInvitedMapper;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired
	AdminFunActivityRegisterMapper activityRegisterMapper;
	@Autowired
	ErpFunUsersMapper usersMapper;
	@Autowired
	AdminCrmBrokerTrackMapper crmBrokerTrackMapper;
	@Autowired
	ErpCompRolesMapper erpCompRolesMapper;
	@Autowired
	ErpFunPersonnelLevelsMapper erpFunPersonnelLevelsMapper;
	@Autowired
	ErpFunRecruitmentChannelMapper erpFunRecruitmentChannelMapper;
	@Autowired
	ErpFunDeptsgroupMapper erpFunDeptsgroupMapper;
    @Autowired
    ErpFunResetSmsMapper erpFunResetSmsMapper;
    @Autowired
    AdminFunUserAccountService adminFunUserAccountService;
	@Autowired
    ErpSystemSettingLogsService erpSystemSettingLogsService;
	@Autowired
    ErpFunSaleMapper erpFunSaleMapper;
    @Autowired
    ErpFunLeaseMapper erpFunLeaseMapper;
    @Autowired
    ErpFunRentCustomerMapper erpFunRentCustomerMapper;
    @Autowired
    HttpRequestTask httpRequestTask;
    @Autowired
    ErpFunCompMapper erpFunCompMapper;
    @Autowired
    ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
    @Autowired
    ErpFunRegionMapper erpFunRegionMapper;
    @Autowired
    ErpFunDeptsMapper erpFunDeptsMapper;
    @Autowired
    ErpFunDealMapper erpFunDealMapper;
    @Autowired AdminFunCompMapper adminFunCompMapper;
    @Autowired AdminFunArchiveService adminFunArchiveService;
    @Autowired ErpFunUserManageRangeService erpFunUserManageRangeService;
	@Autowired AdminFunCityMapper adminFunCityMapper;
	@Autowired AdminCrmBrokerTrackService adminCrmBrokerTrackService;
	@Autowired ErpUserOpersService erpUserOpersService;
	@Autowired ErpUserOpersMapper erpUserOpersMapper;
	@Autowired AdminFunErpUserGuideService adminFunErpUserGuideService;
	@Autowired ErpFunBasewageMapper erpFunBasewageMapper;
	@Autowired ErpFunEcardsService erpFunEcardsService;
	@Autowired ErpFunBasewageService erpFunBasewageService;
	@Autowired AdminInviteRegistErpService adminInviteRegistErpService;
	@Autowired AdminAppRefreshUserMapper adminAppRefreshUserMapper;
	@Autowired AdminFunUsersCountService adminFunUsersCountService;
	@Autowired AdminSysParaMapper adminSysParaMapper;
	@Autowired AdminFunDeptsMapper adminFunDeptsMapper;
	@Autowired AdminYouBorkerArchiveMapper adminYouBorkerArchiveMapper;
	@Autowired
	AdminYouBorkerArchiveService adminYouBorkerArchiveService;
	@Autowired
	AdminFunDeptsService adminFunDeptsService;
	@Autowired
	ErpFunAttendanceGroupBizService erpFunAttendanceGroupBizService;
	@Autowired ErpFunAttendanceGroupBizPersonService erpFunAttendanceGroupBizPersonService;
	@Autowired ErpFunAttendanceScopeBizPersonService erpFunAttendanceScopeBizPersonService;
	@Autowired ErpFunAttendanceScopeBizService erpFunAttendanceScopeBizService;
	@Autowired ErpFunSalaryTypeMapper erpFunSalaryTypeMapper;
	@Autowired ErpSalaryTypeRelativeMapper erpSalaryTypeRelativeMapper;
	@Autowired ErpFunEmployeeDocService erpFunEmployeeDocService;
	@Autowired ErpFunEmployeeLogService erpFunEmployeeLogService;
	@Autowired ErpFunAttendanceScopeMapper erpFunAttendanceScopeMapper;
	@Autowired ErpFunAttendanceScopeBizMapper erpFunAttendanceScopeBizMapper;
	@Autowired ErpBroadcastMapper erpBroadcastMapper;
	@Autowired ErpFunAttendanceScopeBizPersonMapper erpFunAttendanceScopeBizPersonMapper;
	@Autowired ErpFunAttendanceGroupBizMapper  erpFunAttendanceGroupBizMapper;
	@Autowired ErpFunAttendanceGroupBizPersonMapper erpFunAttendanceGroupBizPersonMapper;
	@Autowired
	ErpFunMsgMapper erpFunMsgMapper;
	@Autowired
	AdminFunUserRqsMapper adminFunUserRqsMapper;
	@Autowired
	ErpCountDoneService erpCountDoneService;
	@Autowired
	ErpFunHousePublishStatusMapper erpFunHousePublishStatusMapper;
	@Autowired
	ErpFunEmployeeDocMapper erpFunEmployeeDocMapper;
	@Autowired
	ErpAuditRuntimeService erpAuditRuntimeService;
	@Autowired
	ErpSysParaMapper erpSysParaMapper;
	@Autowired
	ErpCompRoleOpersMapper erpCompRoleOpersMapper;
	@Autowired
	WageTypeController wageTypeController;
	@Autowired
	ErpFunDeptsGroupService erpFunDeptsgroupService;
	@Autowired
	ErpFunAttendanceUserClassDetailMapper erpFunAttendanceUserClassDetailMapper;
	@Autowired
	ErpFunWorkcountTargetMapper erpFunWorkcountTargetMapper;
	@Autowired
	ErpFunUsersService erpFunUsersService;
	@Autowired
	ErpRoleOpersMapper erpRoleOpersMapper;
	@Autowired
	ErpFunRoleWageConfigMapper erpFunRoleWageConfigMapper;
	@Autowired
	ErpFunWageMapper erpFunWageMapper;
	@Autowired
	ErpFunAssessmentStatisticsMapper erpFunAssessmentStatisticsMapper;
	@Autowired
	ErpMarketVirtualGeneralMapper erpMarketVirtualGeneralMapper;
	@Autowired
	ErpNoTransactionService erpNoTransactionService;
	@Autowired
	private CacheUtil cacheUtil;
	@Autowired
	AdminFunRecalculateWageInfoMapper adminFunRecalculateWageInfoMapper;
	@Autowired
    AdminPropertyDuildMapMapper adminPropertyDuildMapMapper;
	@Autowired
	MqUtil mqUtil;
	@Autowired
	FafunShopInfoMapper fafunShopInfoMapper;
	@Autowired
	ErpCountDoneMapper erpCountDoneMapper;
	@Autowired
	ErpFunRoleLevelsMapper erpFunRoleLevelsMapper;
	@Autowired
	ErpFunRoleWageConfigService erpFunRoleWageConfigService;
	@Autowired
	ErpInviteUserLogMapper erpInviteUserLogMapper;
	@Autowired
	ErpZxRoleConfigMapper erpZxRoleConfigMapper;
	@Autowired
	InviteRegistController inviteRegistController;
	@Autowired
	AdminFunCompService adminFunCompService;
	@Autowired
	AdminFunPaidMapper adminFunPaidMapper;
	@Autowired
	AdminFunUserAccountMapper adminFunUserAccountMapper;
    @Autowired
    ErpFunTrackMapper erpFunTrackMapper;
    @Autowired
    ErpFunProfitMapper erpFunProfitMapper;
    @Autowired
    private ErpFunOrganizationMapper erpFunOrganizationMapper;
    @Autowired
    private ErpSysParaService erpSysParaService;
    @Autowired
    private ErpFunOrganizationDefinitionMapper erpFunOrganizationDefinitionMapper;
    @Autowired
    private ErpAliyunPhoneMapper erpAliyunPhoneMapper;
    @Autowired
	private ErpAliyunPhoneService erpAliyunPhoneService;
    @Autowired
	private ErpKpiRoleAssociateConfigMapper erpKpiRoleAssociateConfigMapper;
    @Autowired
	private ErpKpiUserAssociateConfigMapper erpKpiUserAssociateConfigMapper;
    @Autowired
	private ErpFunPartnerLogMapper erpFunPartnerLogMapper;


	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunUsersMapper;
	}

	/**
	 * @see ErpFunUsersService#editPwd(String, String)
	 */
	@Transactional
	@Override
	public void editPwd(String mobile, String loginPwd) {

		// 0：成功 1：格式有误 2：没有用户
		String flag = "0";
		if (!ValidationUtil.checkPassword(loginPwd)) {
			flag = "2";
		}
		if (flag.equals("0")) {
			try {
				// 更新密码
				AdminFunArchive adminFunArchive = adminFunArchiveMapper.getArchiveByMobile(mobile);
				ErpFunUsers erpFunUsers = erpFunUsersMapper.getValidUserByArchiveId(adminFunArchive.getArchiveId());
				if (erpFunUsers != null) {
					ErpFunUsers upUsers = new ErpFunUsers();
					upUsers.setShardCityId((int)adminFunArchive.getCityId());
					upUsers.setUserId(erpFunUsers.getUserId());
					upUsers.setLoginPassword(EncryptHelper.encryptHftPassword(loginPwd));
					upUsers.setUpdateTime(DateUtil.DateToString(new Date()));
					erpFunUsersMapper.updateByPrimaryKeySelective(upUsers);
				} else {
					flag = "1";
				}
			} catch (Exception e) {
				logger.error("", e);
				flag = "1";
			}
		}

		String content = "";
		if (flag.equals("0")) {
			content = "您的登录密码已修改成功.";
		} else if (flag.equals("1")) {
			content = "您的手机号码还未注册.";
		} else if (flag.equals("2")) {
			content = "您的提交的密码格式有误，请重新发送短信修改密码.";
		}

		try {
			// 获取短信地址 发送短信
			String smsPath = AppConfig.getSendMsgPath();
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("action", "sendSms");
			param.put("phone", mobile);
			try {
				content = URLEncoder.encode(URLEncoder.encode(content, "UTF-8"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
			}
			param.put("content", content);
			String result = HttpUtil.post(smsPath, param);
			if (result.indexOf("response>1</response") == -1) {
				logger.error("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$短信发送失败\r\n" + result);
				logger.error("RRRRR_SMS_URL ：" + smsPath);
			}
		} catch (Exception e) {
			logger.error("发送短信失败" , e);
		}
	}

	@Override
	public ErpFunUsers selectObjectByMobile(String shardCityId, String userMobile) {
		ErpFunUsers erpFunUsers = erpFunUsersMapper.selectObjectByMobile(shardCityId, userMobile);
		return erpFunUsers;
	}

	@Override
	public ErpFunUsers getUserInfoByUserId(Integer cityId, Integer ccUserId) {
		ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, ccUserId);
		return erpFunUsers;
	}

	/***
	 * 获取公众号报名经纪人列表
	 * @author 熊财
	 */
	@Override
	public List<AdminFunActivityRegisterDto> getRegisterList(ErpFunUsers usersParam) {
		AdminFunActivityRegisterDto adminFunActivityRegister = new AdminFunActivityRegisterDto();
		adminFunActivityRegister.setCompId(usersParam.getCompId());
		adminFunActivityRegister.setDeptId(usersParam.getDeptId());
		List<AdminFunActivityRegisterDto> achiveIDList=activityRegisterMapper.getAchiveIDsByCompIDAndDeptID(adminFunActivityRegister);
		usersParam.setShardCompId(usersParam.getCompId());
		usersParam.setDeptId(null);
		List<ErpFunUsers> list=erpFunUsersMapper.getUserListByNotNull(usersParam);
		for (ErpFunUsers erpFunUsers : list) {
			for (AdminFunActivityRegisterDto registerDto : achiveIDList) {
				if(registerDto.getArchiveId()==erpFunUsers.getArchiveId()){
					registerDto.setFunUsers(erpFunUsers);
				}
			}
		}
		return achiveIDList;
	}

	@Override
	public ErpFunUsers selectObjectByMobileAndCompId(Short cityId, Integer compId, String userMobile) {
		ErpFunUsers erpFunUsers = erpFunUsersMapper.selectObjectByMobileAndCompId(cityId, compId, userMobile);
		return erpFunUsers;
	}

	/**
	 * 根据archiveId查询用户信息
	 */
	@Override
	public ErpFunUsers selectByArchiveId(Short cityId, Integer archiveId) {
		ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByArchiveId(archiveId);
		return erpFunUsers;
	}

	@Override
	public ErpFunUsers getUserByArchiveId(String archiveId, String shardCityId) {
		ErpFunUsers erpFunUsers = erpFunUsersMapper.queryinfoByArchiveId(Short.parseShort(shardCityId), Integer.parseInt(archiveId));
		return erpFunUsers;
	}

	@Override
	public ErpFunUsersDto getUsersByArchiveId(Integer archiveId, Integer cityId) {
		return erpFunUsersMapper.getUsersByArchiveId(cityId, archiveId);
	}

	/**
	 * 重置用户密码
	 * @author XC
	 */
	@Transactional
	@Override
	public int resetPwd(Integer archiveId, AdminCrmUser user) throws ParseException {
		AdminFunArchiveDto funArchiveDto = adminFunArchiveMapper.getBrokerInfoByArchiveId(archiveId);
		ErpFunUsers erpFunUsers = new ErpFunUsers();
		erpFunUsers.setArchiveId(archiveId);
		erpFunUsers.setShardCityId(Integer.parseInt(String.valueOf(funArchiveDto.getCityId())));
		erpFunUsers.setLoginPassword("f9a7b11de7f38a166504bfd6eec7be43");
		erpFunUsers.setUpdateTime(DateUtil.DateToString(new Date()));
		erpFunUsersMapper.updateByArchiveIdSelective(erpFunUsers);
		AdminCrmBrokerTrack brokerTrack = new AdminCrmBrokerTrack();
		brokerTrack.setArchiveId(archiveId);
		brokerTrack.setProvinceId(funArchiveDto.getProvinceId());
		brokerTrack.setCityId(Integer.parseInt(String.valueOf(funArchiveDto.getCityId())));
		brokerTrack.setCompId(user.getCompId());
		brokerTrack.setDeptId(user.getDeptId());
		brokerTrack.setTrackDesc("[重置密码]");
		brokerTrack.setTrackContent(user.getUserName()+"重置了该用户密码");
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		brokerTrack.setTrackTime(time.parse(time.format(date)));
		brokerTrack.setTrackId(crmBrokerTrackMapper.getId()+1);
		crmBrokerTrackMapper.insertSelective(brokerTrack);
		return 1;
	}

	@Override
	public int getCountByUserNo(Short cityId, String userNo) {
		return erpFunUsersMapper.getCountByUserNo(cityId, userNo);
	}

	@Override
	public int updateByMobile(ErpFunUsers erpFunUsers) {
		return erpFunUsersMapper.getCountByUserNo(erpFunUsers);
	}

	/**
	 * @author 方李骥
	 * @since 2016年8月29日
	 * @param cityId
	 * @param creatorUid
	 * @return
	 */
	@Override
	public ErpFunUsers selectUserNameByUserId(Integer cityId, Integer creatorUid) {
		return erpFunUsersMapper.selectUserNameByUserId(cityId,creatorUid);
	}

	/**
	 * @TODO 获取楼盘管理员
	 * @author lcb
	 * @2016-9-20 上午10:24:03
	 */
	@Override
	public ErpFunUsers getDistCompRealAdmin(BaseMapParam param) {
		List<ErpFunUsers> resList = erpFunUsersMapper.getDeveloperAdmin(param.getInteger("cityId"), param.getInteger("compId"), 1);
		if(null != resList && resList.size() > 0) {
			return resList.get(0);
		}
		return null;
	}

	@Override
	public ErpFunUsers getDistBuildInfoAdmin(BaseMapParam param) {
		List<ErpFunUsers> resList = erpFunUsersMapper.getDeveloperAdmin(param.getInteger("cityId"),  param.getInteger("compId"), 2);
		if(null != resList && resList.size() > 0) {
			return resList.get(0);
		}
		return null;
	}

	@Transactional
	@Override
	public Integer setDistCompRealAdmin(BaseMapParam param) {
		Integer res = 0;
		Map<String, Object> pMap = param.getMap();
		// 先取消旧的楼盘管理员
		if(null != pMap.get("oldUserId")) {
			ErpFunUsers record = new ErpFunUsers();
			record.setShardCityId(param.getInteger("cityId"));
			record.setDeveloperAdmin(Byte.valueOf("0"));
			record.setUserId(Integer.valueOf(pMap.get("oldUserId") + ""));
			record.setUpdateTime(DateUtil.DateToString(new Date()));
			erpFunUsersMapper.updateByPrimaryKeySelective(record );
			// 踢下线
		}
		// 设置信管理员
		//设置新的管理员
		ErpFunUsers funUsersPO = new ErpFunUsers();
		funUsersPO.setUserId(Integer.valueOf(pMap.get("newUserId") + ""));
		funUsersPO.setDeveloperAdmin(Byte.valueOf("1"));
		funUsersPO.setShardCityId(param.getInteger("cityId"));
		funUsersPO.setUpdateTime(DateUtil.DateToString(new Date()));
		res = erpFunUsersMapper.updateByPrimaryKeySelective(funUsersPO );
		// 清除缓存和踢下线
		return res;
	}

	@Override
	public ErpFunUsers selectUserByUserMobile(Integer cityId, Integer compId, String[] phoneArr) {
		if (phoneArr != null && phoneArr.length > 0) {
			ErpFunUsers funUsers = erpFunUsersMapper.selectUserByUserMobile(cityId, compId, phoneArr);
			return funUsers;
		}
		return null;
	}


	@Override
	public List<ErpFunUsers> getUserListByCompId(Integer cityId, Integer compId) {
		return erpFunUsersMapper.getRecordsByCompIdAndUserWriteOff(cityId, compId, 0);
	}



	/**
	 * @TODO query the detail infomation for funusers
	 * @author lcb
	 * @2016-10-19 下午2:01:30
	 */
	@Override
	public ErpFunUsersDto getUserInfoData(BaseMapParam param) throws Exception{
		Integer archiveId = param.getInteger("archiveId");
		AdminFunArchive adminFunArchive = adminFunArchiveMapper.getArchiveById(archiveId);
		adminFunArchive.setUserPhoto(CommonUtil.getPhotoUrl(adminFunArchive.getUserPhoto())); // 临时看格式是否需要处理
		adminFunArchive.setUserPhotoMin(CommonUtil.getPhotoUrl(adminFunArchive.getUserPhotoMin()));
		// 查询funUsersDto
		ErpFunUsersDto erpFunUsersDto = erpFunUsersMapper.getFunUserByArchiveId(param.getInteger("cityId"),archiveId);
		org.springframework.beans.BeanUtils.copyProperties(adminFunArchive, erpFunUsersDto);
		ErpCompRoles erpCompRoles = erpCompRolesMapper.getCompRoleByUserEdition(param.getInteger("cityId"),erpFunUsersDto.getUserPosition(),param.getInteger("compId"));
		erpFunUsersDto.setRoleName(erpCompRoles.getRoleName());
		return erpFunUsersDto;
	}

	/**
	 * @TODO 查询员工职级
	 * @author lcb
	 * @2016-10-19 下午3:54:23
	 */
	@Override
	public List<ErpFunPersonnelLevels> getPersonnelLevelList(BaseMapParam param) {
		ErpFunPersonnelLevels erpFunPersonnelLevels = new ErpFunPersonnelLevels();
		erpFunPersonnelLevels.setCompId(param.getInteger("compId"));
		erpFunPersonnelLevels.setLevelsStatus(new Byte("1"));
		erpFunPersonnelLevels.setShardCityId(param.getInteger("cityId"));
		return erpFunPersonnelLevelsMapper.selectListByCondition(erpFunPersonnelLevels);
	}

	/**
	 * @TODO 入职渠道列表
	 * @author lcb
	 * @2016-10-19 下午4:18:57
	 */
	@Override
	public List<ErpFunRecruitmentChannel> getRecruitmentChannelList(BaseMapParam param) {
		ErpFunRecruitmentChannel recruitmentChannel = new ErpFunRecruitmentChannel();
		recruitmentChannel.setShardCityId(param.getInteger("cityId"));
		recruitmentChannel.setCompId(param.getInteger("compId"));
		recruitmentChannel.setChannelStatus(new Byte("1"));
		return erpFunRecruitmentChannelMapper.selectListByCondition(recruitmentChannel);
	}

	/**
	 * @TODO 删除职级
	 * @author lcb
	 * @2016-10-19 下午4:30:33
	 */
	@Override
	public Integer delPersonnelLevel(BaseMapParam param) {
		ErpFunPersonnelLevels erpFunPersonnelLevels = new ErpFunPersonnelLevels();
		erpFunPersonnelLevels.setLevelsId(param.getInteger("levelsId"));
		erpFunPersonnelLevels.setShardCityId(param.getInteger("cityId"));
		erpFunPersonnelLevels.setLevelsStatus(new Byte("0"));
		return erpFunPersonnelLevelsMapper.updateByPrimaryKeySelective(erpFunPersonnelLevels);
	}

	@Override
	public Integer delRecruitmentChannel(BaseMapParam param) {
		ErpFunRecruitmentChannel recruitmentChannel = new ErpFunRecruitmentChannel();
		recruitmentChannel.setShardCityId(param.getInteger("cityId"));
		recruitmentChannel.setChannelId(param.getInteger("channelId"));
		recruitmentChannel.setChannelStatus(new Byte("0"));
		return erpFunRecruitmentChannelMapper.updateByPrimaryKeySelective(recruitmentChannel);
	}

	/**
	 * @TODO
	 * @author lcb
	 * @2016-10-19 下午5:11:51
	 */
	@Override
	public Integer getRegisterUserStatus(BaseMapParam param) {
//		Map<String, Object> pMap = param.getMap();
//		Integer deptId = param.getInteger("deptId");
//		// 查询门店人数
//		Integer count = erpFunUsersMapper.count(param.getInteger("cityId"), deptId);
		return null;
	}

	/**
	 * @TODO 添加分组/修改
	 * @Author lcb
	 * @2016-10-21 下午5:06:51
	 **/
	@Transactional
	@Override
	public Integer insertMgrGroupData(InsertGroupData param) throws Exception{
		String grMember = param.getGrMember(); // 分组成员
		Object grId = param.getGrId(); // 分组Id
		Integer compId = param.getCompId();
		Integer cityId = param.getCityId();
		if(null != grId){//修改
			// 清空分组下的用户到默认分组
			param.setnGrId(Const.DIC_DEFAULT_GROUP_ID);
//			param.setString("nGrId", Constants_DIC.DIC_DEFAULT_GROUP_ID); // 默认分组
			erpFunUsersMapper.updateGroupMember(cityId, param); // 清除缓存!!!!!!!!
			// 更新分组详情信息
//			ErpFunDeptsgroup erpFunDeptsgroup = new ErpFunDeptsgroup();
//			BeanUtil.copyObject(param, erpFunDeptsgroup);
////			erpFunDeptsgroup.setUpdateUid(param.getUserId());
////			erpFunDeptsgroup.setUpdateTime(DateTimeHelper.formatDateTimetoString(new Date()));
////			erpFunDeptsgroup.setAdminUser(param.getAdminUser());
////			erpFunDeptsgroup.setGrContact(param.getGrContact());
////			erpFunDeptsgroup.setGrDesc(param.getGrDesc());
////			erpFunDeptsgroup.setSeqNo(param.getSeqNo());
////			erpFunDeptsgroup.setGrTele(param.getGrTele());
////			erpFunDeptsgroup.setGrName(param.getGrName());
////			erpFunDeptsgroup.set
			erpFunDeptsgroupMapper.updateBaseInfo(cityId, param);
		} else {//新增
			ErpFunDeptsgroup erpFunDeptsgroup = new ErpFunDeptsgroup();
			BeanUtil.copyObject(param, erpFunDeptsgroup);
			erpFunDeptsgroup.setUpdateUid(param.getUserId());
			erpFunDeptsgroup.setUpdateTime(DateTimeHelper.formatDateTimetoString(new Date()));
//			ErpFunDeptsgroup erpFunDeptsgroup = BeanUtil.map2Bean(param.getMap(), ErpFunDeptsgroup.class);
			erpFunDeptsgroup.setShardCityId(cityId);
			erpFunDeptsgroupMapper.insertSelective(erpFunDeptsgroup);
			erpFunDeptsgroup.setGrId(erpFunDeptsgroup.getGrId());
		}
		if(StringUtils.isNotBlank(grMember)){
			erpFunUsersMapper.addMemberGroup(cityId, param);
		}
		erpFunDeptsgroupService.evictCacheableModelData(compId, cityId);
		return null;
	}

	/**
	 * @TODO 删除分组
	 * @Author lcb
	 * @2016-10-21 下午6:26:00
	 **/
	@Transactional
	@Override
	public Integer deleteMgrGroupData(BaseMapParam param) {
//		Map<String, Object> pMap = param.getMap();
		ErpFunDeptsgroup funDeptsgroup = new ErpFunDeptsgroup();
		funDeptsgroup.setIsDel(new Byte("1"));
		funDeptsgroup.setGrId(param.getInteger("grId"));
		funDeptsgroup.setUpdateTime(DateUtil.DateToString(new Date(),"yyyy-MM-dd HH:mm:ss"));
		funDeptsgroup.setUpdateUid(param.getInteger("userId"));
		erpFunDeptsgroupMapper.updateByPrimaryKeySelective(funDeptsgroup);
		// 转移群众
		param.setString("nGrId", Constants_DIC.DIC_DEFAULT_GROUP_ID);
		InsertGroupData deleteParam = new InsertGroupData();
		deleteParam.setnGrId(Const.DIC_DEFAULT_GROUP_ID);
		deleteParam.setGrId(param.getInteger("grId"));
		deleteParam.setDeptId(param.getInteger("deptId"));
		deleteParam.setCompId(param.getInteger("compId"));
		erpFunUsersMapper.updateGroupMember(param.getInteger("cityId"), deleteParam); // 清除缓存!!!!!!!!
		return null;
	}

	@Override
	public Map<String, Object> getRegistManagerUser(Integer cityId,Integer compId) {
		Integer userId = erpFunUsersMapper.getRegistManagerUser(cityId,compId);
		Map<String,Object> dataMap = new HashMap<String,Object>();
		dataMap.put("userId", userId);
		return dataMap;
	}

	@Override
	public List<ErpFunUsers> getRangeUserList(ErpFunUsers condition, Integer cityId) {
		return erpFunUsersMapper.getRangeUserList(cityId, condition);
	}


	/**
	 * @TODO
	 * @Author lcb
	 * @2016-10-22 上午10:53:31
	 **/
	@Override
	public ErpFunDeptsgroupDto getGroupData(BaseMapParam param) {
		// 查询本分组下的所有用户
//		Map<String, Object> pMap = param.getMap();
		ErpFunUsers erpFunusers = new ErpFunUsers();
		erpFunusers.setDeptId(param.getInteger("deptId"));
		erpFunusers.setShardCityId(param.getInteger("cityId"));
		erpFunusers.setGrId(param.getInteger("grId"));
		List<ErpFunUsers> erpFunusersList = erpFunUsersMapper.getUserListByNotNull(erpFunusers);
		// Map<String, List<FunUsersPO>>
		// userMap=funUsersService.getCacheableUserForGroupByDeptId(getModel().getDEPT_ID());
		// FunDeptsgroupPO funDeptsgroupPO=service.getModelData(getModel());
		ErpFunDeptsgroup funDeptGroup = erpFunDeptsgroupMapper.getGroupListByCondition(param.getInteger("cityId"), param.getMap()).get(0);
		ErpFunDeptsgroupDto vo = new ErpFunDeptsgroupDto();
		// List<FunUsersPO> userList=userMap.get(funDeptsgroupPO.getGR_ID());
		StringBuilder namebuilder = new StringBuilder();
		StringBuilder idbuilder = new StringBuilder();
		if (null != erpFunusersList && erpFunusersList.size() > 0) {
			for (ErpFunUsers usersPO : erpFunusersList) {
				namebuilder.append(usersPO.getUserName() + ",");
				idbuilder.append(usersPO.getUserId() + ",");
			}
		}
		Map<String, Object> resMap = new HashMap<>();
		BeanUtil.beanToMap(funDeptGroup, resMap);
		resMap.put("grMemberName", namebuilder.toString());
		resMap.put("grMember", idbuilder.toString());
		vo = BeanUtil.map2Bean(resMap, ErpFunDeptsgroupDto.class);
		return vo;
	}

	/**
	 * @tag 系统参数修改后,所有用户需要重新登录
	 * @author 邓永洪
	 * @since 2018/7/23
	 */
	@Transactional
	@Override
	public void updateUserStatusBySysPara(Integer userId, Integer cityId, Integer compId) {
		List<ErpFunUsers> usersList = erpFunUsersMapper.getRecordsByCompIdAndUserWriteOff(cityId,compId,0);
		Set<Integer> userIds = new HashSet<>();
		for (ErpFunUsers funUsers : usersList) {
			if(userId.equals(funUsers.getUserId())) {
				continue;
			}
			Object loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_ERP + funUsers.getArchiveId());
			if (loginKey != null) {
			    cacheUtil.put(loginKey, LogInEnum.SystemPara_UP.getValue(), CacheUtilExt.INVALID_TIME_OUT);
			}
			loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_APP + funUsers.getArchiveId());
			if (loginKey != null) {
			    cacheUtil.put(loginKey, LogInEnum.SystemPara_UP.getValue(), CacheUtilExt.INVALID_TIME_OUT);
			}
			userIds.add(funUsers.getArchiveId());
		}
		TaskQueueMsg taskQueueMsg=new TaskQueueMsg();
		taskQueueMsg.setTaskType(new TaskQueueThread.TaskType[]{TaskQueueThread.TaskType.MERGE_APP_REFRESH_USER});
		taskQueueMsg.setTargetIds(userIds.toArray(new Integer[] {}));
		TaskQueueThread.sendMessage(taskQueueMsg);

	}

	/**
	 * @tag 系统参数修改后,用户需要重新登录
	 * @author 邓永洪
	 * @since 2018/7/23
	 */
	@Transactional
	@Override
	public void updateUserStatusBySysParaByOrg(Integer userId, Integer cityId, Integer compId, List<Integer> orgIds) {

		ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
		erpFunUsersExample.setShardCityId(cityId);
		erpFunUsersExample.createCriteria().andCompIdEqualTo(compId).andOrganizationIdIn(orgIds).andUserWriteoffEqualTo(false);
		List<ErpFunUsers> usersList = erpFunUsersMapper.selectByExample(erpFunUsersExample);
		Set<Integer> userIds = new HashSet<>();
		for (ErpFunUsers funUsers : usersList) {
			if(userId.equals(funUsers.getUserId())) {
				continue;
			}
			Object loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_ERP + funUsers.getArchiveId());
			if (loginKey != null) {
				cacheUtil.put(loginKey, LogInEnum.SystemPara_UP.getValue(), CacheUtilExt.INVALID_TIME_OUT);
			}
			loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_APP + funUsers.getArchiveId());
			if (loginKey != null) {
				cacheUtil.put(loginKey, LogInEnum.SystemPara_UP.getValue(), CacheUtilExt.INVALID_TIME_OUT);
			}
			userIds.add(funUsers.getArchiveId());
		}
		TaskQueueMsg taskQueueMsg=new TaskQueueMsg();
		taskQueueMsg.setTaskType(new TaskQueueThread.TaskType[]{TaskQueueThread.TaskType.MERGE_APP_REFRESH_USER});
		taskQueueMsg.setTargetIds(userIds.toArray(new Integer[] {}));
		TaskQueueThread.sendMessage(taskQueueMsg);

	}

	@Override
	@Transactional
	public Integer updateMgrResetUserPWData(BaseMapParam param) throws Exception {
//		Map<String, Object> pMap = param.getMap();
		Integer userId = param.getInteger("userId");
		String strUserId = param.getString("userId");
		ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(param.getInteger("cityId"), userId);
		String newPlantPwd = PassWordUtil.generatePwd(6);
		// String newPwd = EnCodeHelper.MD5Encode(newPlantPwd);
		// 发送短信
		String smsContent = "好房客服提示您:" + param.getString("userName") + "重置了您的ERP密码。新密码为：" + newPlantPwd + "，请尽快登录系统并修改密码。";
		ErpFunResetSms funResetSmsPO = new ErpFunResetSms();
		funResetSmsPO.setMobile(param.getString("mobile"));
		funResetSmsPO.setReceiveUserId(erpFunUsers.getUserId());
		funResetSmsPO.setSmsMsg(smsContent);
		generateSmsRecord(funResetSmsPO, param);
		erpSystemSettingLogsService.insertLog(SystemOperateUtil.SSL_TYPE.RESET_PWD, strUserId, smsContent,null, null, param);
		return null;
	}

	private void generateSmsRecord(ErpFunResetSms erpFunResetSms, BaseMapParam param) throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("sendUserId", param.getInteger("userId"));
		pMap.put("startTime", DateUtil.formatDateTimetoString(calendar.getTime(), "yyyy-MM-dd 00:00:00"));
		pMap.put("endTime", DateUtil.formatDateTimetoString(calendar.getTime(), "yyyy-MM-dd 23:59:59"));
		if (erpFunResetSmsMapper.countMsg(param.getInteger("cityId"), pMap) > 3) {
			throw new BusinessException("每人每天只能发送3条重置密码短信");
		}
		pMap.remove("sendUserId");
		pMap.put("receiveUserId", erpFunResetSms.getReceiveUserId());
		if (erpFunResetSmsMapper.countMsg(param.getInteger("cityId"), pMap) > 2) {
			throw new BusinessException("每人每天只能接收2条重置密码短信");
		}
		// 资金账户检查扣费 并存放总金额
		Integer paid = adminFunUserAccountService.checkSendSMSAndCharge(1, param);
		try {
			String msgHost = AppConfig.getSendMsgPath();
			String result = HttpUtil.get(msgHost + "action=sendSms&phone=" + erpFunResetSms.getMobile() + "&content="
					+ URLEncoder.encode(URLEncoder.encode(erpFunResetSms.getSmsMsg())), null);
			// 短信处理结果失败
			if (result.indexOf("response>1</response") <= 0) {
				logger.error("短信发送失败\r\n" + result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 写记录
		erpFunResetSms.setCreateTime(new Date());
		erpFunResetSms.setUaId(param.getInteger("uaId"));
		erpFunResetSms.setPaId(paid);
		erpFunResetSms.setSendUserId(param.getInteger("userId"));
		erpFunResetSms.setShardCityId(param.getInteger("cityId"));
		erpFunResetSmsMapper.insertSelective(erpFunResetSms);
	}

	/***
	 * 冻结用户
	 */
	@Transactional
	@Override
	public void updateMgrUserUseState(BaseMapParam param, ErpFunUsers erpFunUsers, String userName) {
		Integer cityId = param.getInteger("cityId");
		Integer compId = param.getInteger("compId");
		Integer userId = param.getInteger("userId");
		Byte newStatus = param.getByte("userStatus");
		Integer selfUserId = param.getInteger("selfUserId");
		Integer selfDeptId = param.getInteger("selfDeptId");
		BaseMapParam dataMap = new BaseMapParam();
		dataMap.setInteger("cityId", cityId);
		dataMap.setInteger("compId", compId);
		dataMap.setInteger("userId", selfUserId);
		dataMap.setInteger("deptId", selfDeptId);
		// 状态相等则不管
		if (erpFunUsers.getUserStatus().equals(newStatus)) {
			return;
		}
		if (newStatus == 1) {// 启用
			//erpSystemSettingLogsService.insertLog(SystemOperateUtil.SSL_TYPE.ENABLE_USER, userId + "", null, null, null, dataMap);
			erpSystemSettingLogsService.insertLogNew(SystemOperateUtil.SSL_TYPE.ENABLE_USER, userId + "", null, null, null, dataMap,userName);

			// 如果是从暂停到启用更新房客源的策略参数
			this.updateOthersbyUserPauseToNormal(erpFunUsers.getStatusTime(), erpFunUsers.getUserId(),
					erpFunUsers.getCompId(), erpFunUsers.getDeptId(), erpFunUsers.getCityId().intValue());
		} else {// 冻结
			//erpSystemSettingLogsService.insertLog(SystemOperateUtil.SSL_TYPE.DISABLE_USER, userId + "", null, null, null, dataMap);
			erpSystemSettingLogsService.insertLogNew(SystemOperateUtil.SSL_TYPE.DISABLE_USER, userId + "", null, null, null, dataMap,userName);

		}
		// 更新用户
		ErpFunUsers funUsers = new ErpFunUsers();
		funUsers.setUserId(erpFunUsers.getUserId());
		funUsers.setUserStatus(newStatus.byteValue());
		funUsers.setShardCityId(cityId);
		funUsers.setStatusTime(DateUtil.formatDateTimetoString(new Date(), "yyyy-MM-dd HH:mm:ss"));
		funUsers.setUpdateTime(DateUtil.DateToString(new Date()));
		erpFunUsersMapper.updateByPrimaryKeySelective(funUsers);
		this.endLoginUser(erpFunUsers.getArchiveId(), null, LogInEnum.UserStatus_UP);
	}

	/**
	 * 需要服务器中的STATUS_TIME USER_ID 用户从暂停到启用业务数据更新
	 */
	private void updateOthersbyUserPauseToNormal(String statusTime, Integer userId, Integer compId, Integer deptId, Integer cityId) {
		int timeZone = (int) DateTimeHelper.getDaysOfTwoDate(DateTimeHelper.getSystemDate(), DateTimeHelper.parseToDate(statusTime));
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("userId", userId);
		pMap.put("deptId", deptId);
		pMap.put("compId", compId);
		pMap.put("timeZone", timeZone);
		erpFunSaleMapper.updateOthersbyUserPauseToNormal(cityId, pMap);
		erpFunLeaseMapper.updateOthersbyUserPauseToNormal(cityId, pMap);
		erpFunBuyCustomerMapper.updateOthersbyUserPauseToNormal(cityId, pMap);
		erpFunRentCustomerMapper.updateOthersbyUserPauseToNormal(cityId, pMap);
	}

	/***
	 * 更新门店信息
	 */
	@Transactional
	@Override
	public void updateMgrDeptData(BaseMapParam param) throws Exception {
		Map<String, Object> paramMap = param.getMap();
		ErpFunDepts erpFunDepts = BeanUtil.map2Bean(paramMap, ErpFunDepts.class);
		Integer cityId = param.getInteger("cityId");
		Integer compId = param.getInteger("compId");
		Integer regId = param.getInteger("regId");
		Integer deptId = param.getInteger("deptId");
		Integer userId = param.getInteger("userId");
		// 客户端错误，没有更新AREA_ID 如果客户端修改完成后删除以下两行代码
		ErpFunRegion erpFunRegion = new ErpFunRegion();
		erpFunRegion.setShardCityId(cityId);
		erpFunRegion.setRegId(regId);
		erpFunRegion = erpFunRegionMapper.selectByPrimaryKey(erpFunRegion);
		erpFunDepts.setAreaId(erpFunRegion.getAreaId());
		erpFunDepts.setShardCityId(cityId);
		ErpFunDepts tmpFunDepts = erpFunDeptsMapper.getByDeptId(cityId, deptId);
		String content = "修改了" + tmpFunDepts.getDeptName() + "门店信息";
		erpFunDepts.setUpdateUid(userId);
		erpFunDepts.setUpdateTime(DateUtil.DateToString(new Date()));
		erpSystemSettingLogsService.insertLog(SystemOperateUtil.SSL_TYPE.UPDATE_DEPT, null, content, erpFunDepts, tmpFunDepts, param);
		// 更新门店信息
		erpFunDeptsMapper.updateByPrimaryKeySelective(erpFunDepts);
		if (!tmpFunDepts.getRegId().equals(erpFunDepts.getRegId())) {
			// 门店下的抢盘和公盘数据，只能跟着门店进行级联更新，其他的通过用户信息修改时级联更新 陈文超
			paramMap.put("areaId", erpFunDepts.getAreaId());
			erpFunSaleMapper.updateHouseForReg(cityId, paramMap);
			erpFunLeaseMapper.updateHouseForReg(cityId, paramMap);
			erpFunBuyCustomerMapper.updateHouseForReg(cityId, paramMap);
			erpFunRentCustomerMapper.updateHouseForReg(cityId, paramMap);
			// 合同只需要在这里更新
			erpFunDealMapper.updateHouseForReg(cityId, paramMap);
			erpFunUsersMapper.updateHouseForReg(cityId, paramMap);
			// 修改了门店片区信息时踢掉全店所有员工 陈文超
			this.endLoginDeptUser(cityId, compId, deptId, LogInEnum.AREA_CHANGE);
		}
	}

	/**
	 * 查询用户列表
	 * */
	@Override
	public Map<String, Object> getUserInfoList(BaseMapParam param) {
		// 查询用户列表
		Integer deptId = param.getInteger("deptId");
		Integer grId = param.getInteger("grId");
		Integer cityId = param.getInteger("cityId");
		String keyWord = param.getString("keyWord");
		List<ErpFunUsers> tempList = new ArrayList<ErpFunUsers>();
		List<ErpFunUsers> tempListTemp = new ArrayList<ErpFunUsers>();
		ErpFunUsers condition = new ErpFunUsers();
		condition.setDeptId(deptId);
		if (null != grId) {
			condition.setGrId(grId);
		}
		tempListTemp = erpFunUsersMapper.getRangeUserList(cityId, condition);
		/**
		 * 张宏利 名字、拼音关键词查询时过滤匹配，内存中过滤
		 */
		if (null != keyWord) {
			String keyWordFirst = null;
			if (!Character.isLetter(keyWord.charAt(0)))
				keyWordFirst = Pinyin4jUtil.converterToFirstSpell(keyWord);
			for (int i = 0; i < tempListTemp.size(); i++) {
				String userName = tempListTemp.get(i).getUserName();
				if (keyWordFirst != null) {
					String userNameFirst = Pinyin4jUtil.converterToFirstSpell(userName);
					if (userNameFirst.indexOf(keyWordFirst) >= 0)
						tempList.add(tempListTemp.get(i));
				} else {
					if (userName.indexOf(keyWord) >= 0)
						tempList.add(tempListTemp.get(i));
				}
			}
		} else {
			tempList.addAll(tempListTemp);
		}
		List<ErpFunUsersDto> list = new ArrayList<ErpFunUsersDto>();
		ErpFunUsersDto funUsersVO = new ErpFunUsersDto();
		List<Integer> archiveId = new ArrayList<>();
		for (ErpFunUsers erpFunUsers : tempList) {
			archiveId.add(erpFunUsers.getArchiveId());
		}
		List<AdminFunArchive> archiveList = adminFunArchiveMapper.getArchiveInfosByIds(archiveId);
		Map<Integer, AdminFunArchive> archiveIdMap = new LinkedHashMap<>(archiveList.size());
		for (AdminFunArchive ad : archiveList) {
			archiveIdMap.put(ad.getArchiveId(), ad);
		}
		for (ErpFunUsers funUsersPO : tempList) {
			Map<String, Object> funUsersMap = new HashMap<>();
			BeanUtil.beanToMap(funUsersPO, funUsersMap);
			AdminFunArchive funArchivePO = archiveIdMap.get(funUsersPO.getArchiveId());// 不判空，如果报错直接反馈客户
			funArchivePO.setUserPhoto(CommonUtil.getPhotoUrl(funArchivePO.getUserPhoto())); // 临时看格式是否需要处理
			funArchivePO.setUserPhotoMin(CommonUtil.getPhotoUrl(funArchivePO.getUserPhotoMin()));
			BeanUtil.beanToMap(funArchivePO, funUsersMap);
			funUsersVO = BeanUtil.map2Bean(funUsersMap, ErpFunUsersDto.class);
			// 自己显示在第一个
			if (funUsersPO.getUserId().equals(param.getInteger("userId"))) {
				list.add(0, funUsersVO);
			} else {
				list.add(funUsersVO);
			}
		}
		// 查询分组列表
		List<ErpFunDeptsgroup> groupList = erpFunDeptsgroupMapper.getGroupListByCondition(param.getInteger("cityId"), param.getMap());
		Map<String, Object> resMap = new HashMap<>();
		resMap.put("userList", tempList);
		resMap.put("grList", groupList);
		return resMap;
	}

	@Override
	public List<ErpFunUsers> getUserListByUserIds(Integer cityId,
			Set<Integer> userIds) {
		return erpFunUsersMapper.getUserListByUserIds(cityId,userIds);
	}

	@Override
	public String getCurrUserName(Integer cityId, Integer userId, Integer deptId) {
		return erpFunUsersMapper.getCurrUserName(cityId,userId,deptId);
	}

	@Transactional
	@Override
	public boolean registByInvite(AdminInviteRegistErp inviteRegistErp, String serviceReg, String serviceZone, String serviceZoneIds, String pwd, ErpFunDepts erpFunDepts) {
		// 判断是否已注册
		// 注册用户，写记录
		// 改邀请信息
		Byte userSex = inviteRegistErp.getUserSex();
		String timeNow = DateTimeHelper.formatDateTimetoString(new Date());
		ErpFunUsers erpFunUsers = new ErpFunUsers();
		erpFunUsers.setCityId(inviteRegistErp.getCityId().shortValue());
		erpFunUsers.setShardCityId(inviteRegistErp.getCityId());
		erpFunUsers.setUserWriteoff(false);
		erpFunUsers.setLoginUserid(inviteRegistErp.getUserMobile());
		erpFunUsers.setUserMobile(inviteRegistErp.getUserMobile());
		erpFunUsers.setUserName(inviteRegistErp.getUserName());
		erpFunUsers.setUserPosition(inviteRegistErp.getRoleId());
		erpFunUsers.setUserSex(userSex != null && userSex == 1);
		erpFunUsers.setUserJobDate(DateUtil.DateToString(new Date()));
		erpFunUsers.setCompId(erpFunDepts.getCompId());
		erpFunUsers.setAreaId(erpFunDepts.getAreaId());
		erpFunUsers.setRegId(erpFunDepts.getRegId());
		erpFunUsers.setDeptId(erpFunDepts.getDeptId());
		if(inviteRegistErp.getGrId() == null || inviteRegistErp.getGrId() <= 0) {
			erpFunUsers.setGrId(0);
		} else {
			erpFunUsers.setGrId(inviteRegistErp.getGrId());
		}
		AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(inviteRegistErp.getCompNo());
		if(adminFunComp == null) {
			return false;
		}
		Integer userEdition = 2;
		Byte compType = adminFunComp.getCompType();
		if (compType == 1) {
			userEdition = 0;
		} else if (compType == 2) {
			userEdition = 1;
		} else if (compType == 3) {
			userEdition = -1;
		}else {
			userEdition=2;
		}
		erpFunUsers.setUserEdition(userEdition);
		erpFunUsers.setUpdateTime(timeNow);
		erpFunUsers.setAlldeptFlag(false);
		erpFunUsers.setStatusTime(timeNow);
		erpFunUsers.setUserStatus((byte) 1);
		AdminFunCity adminFunCity = adminFunCityMapper.selectByPrimaryKey(inviteRegistErp.getCityId().shortValue());
		AdminFunArchive adminFunArchive = adminFunArchiveService.createOrUpdateByErpCreateUser(
				inviteRegistErp.getCityId(), serviceReg, serviceZone, serviceZoneIds, erpFunUsers,null,null, (byte) 7);
		Integer count = erpFunUsersMapper.count(inviteRegistErp.getCityId(), erpFunDepts.getDeptId());
		if(count >= erpFunDepts.getUserNum()) {
			throw new ConfirmException("超过最大员工数<br/>请联系门店管理员处理！");
		}
		ErpFunUsers funUserSelect = erpFunUsersMapper.selectObjectByMobile(String.valueOf(inviteRegistErp.getCityId()), inviteRegistErp.getUserMobile());
		String trackContent = null;
		erpFunUsers.setArchiveId(adminFunArchive.getArchiveId());
		if(funUserSelect == null) {
			if(StringUtils.isNotBlank(pwd)) {
				erpFunUsers.setLoginPassword(EnCodeHelper.MD5Encode(pwd));
			} else {
				throw new ConfirmException("请先输入密码！");
			}
			int userId = erpFunUsersMapper.selectSeqUserId(inviteRegistErp.getCityId());
			erpFunUsers.setUserId(userId);
			String userNoStr = adminFunCity.getCompNo() + String.format("%07d", userId);
			erpFunUsers.setUserNo(userNoStr);
			erpFunUsers.setPartnerId(erpFunDepts.getPartnerId());
			erpFunUsersMapper.insertSelective(erpFunUsers);
			trackContent = "通过邀请注册建立了该用户帐号";
			adminFunUserAccountService.createByCreateUser(erpFunUsers);
			adminFunUsersCountService.createBycreateArchiveId(erpFunUsers.getArchiveId());
			// 获取到邀请人信息
			ErpFunUsers funUserCreate = erpFunUsersMapper.selectByUserId(inviteRegistErp.getCityId(), inviteRegistErp.getCreateUserId());
			if(funUserCreate == null) {// 获取不到就赋值为自己吧
				funUserCreate = erpFunUsers;
			}
			// 写操作日志
			Integer deptId = funUserCreate.getDeptId();
			Integer compId = funUserCreate.getCompId();
			Integer cityId = funUserCreate.getCityId().intValue();
			Integer createUserId = funUserCreate.getUserId();
			erpSystemSettingLogsService.insertSysLog(SSL_TYPE.CREATE_USER, userId, erpFunUsers.getDeptId(), null, null, null, cityId, compId, deptId, createUserId);
		} else {
			//关联门店操作
			erpFunUsers.setUserId(funUserSelect.getUserId());
			erpFunUsers.setUpdateTime(DateUtil.DateToString(new Date()));
			erpFunUsersMapper.updateByPrimaryKeySelective(erpFunUsers);
			// 修改userEdition
			AdminFunArchive archiveUpdate = new AdminFunArchive();
			archiveUpdate.setArchiveId(adminFunArchive.getArchiveId());
			archiveUpdate.setUserEdition(userEdition);
			adminFunArchiveService.updateByPrimaryKeySelective(archiveUpdate);
			trackContent = "通过邀请注册将该用户与门店版进行了绑定";
		}
		adminCrmBrokerTrackService.createRegisterTrack(adminFunArchive.getArchiveId(), trackContent);
		erpUserOpersService.insertUserOpersByCreateUser(erpFunUsers, compType);
		adminFunErpUserGuideService.insertUserSeniorGuide(erpFunUsers.getUserId(), erpFunUsers.getArchiveId());
		//写员工电子名片
		erpFunEcardsService.insertEcards(erpFunUsers, erpFunDepts);
		//新建基本薪资
		erpFunBasewageService.creatBasewage(erpFunUsers);
		// 修改邀请注册状态
		adminInviteRegistErpService.updateRegistStatus(inviteRegistErp.getId());
		this.endLoginUser(adminFunArchive.getArchiveId(), adminFunArchive.getUserMobile(), LogInEnum.DEPT_CHANGE);
		this.evictBaseInfoByCompId(inviteRegistErp.getCityId(), erpFunDepts.getCompId());
		return true;
	}

	@Override
	public void endLoginUser(Integer archiveId, String userMobile, LogInEnum logInEnum) {
		Object loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_ERP + archiveId);
		if (loginKey != null) {
		    cacheUtil.put(loginKey, LogInEnum.RoleOrOper_UP.getValue(), CacheUtilExt.INVALID_TIME_OUT);
		}
		loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_APP + archiveId);
		if (loginKey != null) {
		    cacheUtil.put(loginKey, LogInEnum.RoleOrOper_UP.getValue(), CacheUtilExt.INVALID_TIME_OUT);
		}
		TaskQueueThread.sendMessageMergeAppRefreshUser(logInEnum, archiveId);
	}



	@Override
	public void endLoginDeptUser(Integer cityId, Integer compId, Integer deptId, LogInEnum logInEnum) {
		ErpFunUsers condition = new ErpFunUsers();
		condition.setShardCityId(cityId);
		condition.setCompId(compId);
		condition.setDeptId(deptId);
		/*// 如果之前的用户key不为空则让他失效
				String validArchiveKey = CacheStructure.ARCHIVE_ID_ERP + operator.getArchiveId();
				if (isOpenApiLogin) {
					validArchiveKey = CacheStructure.ARCHIVE_ID_APP + operator.getArchiveId();
				}
				String loginClientKey = (String) RedisUtil.get(validArchiveKey);
				if (loginClientKey != null) {
					RedisUtil.put(loginClientKey, clientKey, RedisUtil.SESSION_TIME_OUT);
				}
				// 保存会话信息到缓存
				RedisUtil.put(clientKey, validArchiveKey, RedisUtil.SESSION_TIME_OUT);
				RedisUtil.put(validArchiveKey, clientKey, RedisUtil.SESSION_TIME_OUT);*/
		List<ErpFunUsers> deptUserList = erpFunUsersMapper.getRangeUserNotUserWriteoffList(cityId, condition);
		//clienkey来clear
		for (ErpFunUsers erpFunUsers : deptUserList) {
			Object loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_ERP + erpFunUsers.getArchiveId());
			if (loginKey != null) {
			    cacheUtil.put(loginKey, logInEnum.getValue(), CacheUtilExt.INVALID_TIME_OUT);
			}
			loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_APP + erpFunUsers.getArchiveId());
			if (loginKey != null) {
			    cacheUtil.put(loginKey, logInEnum.getValue(), CacheUtilExt.INVALID_TIME_OUT);
			}
		}
		Set<Integer> collect = deptUserList.stream().collect(Collectors.mapping(ErpFunUsers::getArchiveId, Collectors.toSet()));
		TaskQueueThread.sendMessageMergeAppRefreshUser(logInEnum, collect.toArray(new Integer[]{}));
	}

	@Transactional
	@Override
	public void setSalaryPlanManager(SetSalaryPlanManagerParam param, Integer userId) {
		ErpFunUsers erpFunUsers = erpFunUsersMapper.getSalaryPlanManager(param.getCityId(), param.getCompId());
		if (erpFunUsers != null && !userId.equals(erpFunUsers.getUserId())) {
			ErpFunUsers updateModel = new ErpFunUsers();
			updateModel.setShardCityId(param.getCityId());
			updateModel.setUserId(erpFunUsers.getUserId());
			updateModel.setSalaryPlanManager((byte)0);
			updateModel.setUpdateTime(DateUtil.DateToString(new Date()));
			erpFunUsersMapper.updateByPrimaryKeySelective(updateModel);
			this.endLoginUser(erpFunUsers.getArchiveId(), erpFunUsers.getUserMobile(), LogInEnum.RoleOrOper_UP);
		}
		ErpFunUsers updateModel = new ErpFunUsers();
		updateModel.setShardCityId(param.getCityId());
		updateModel.setUserId(userId);
		updateModel.setSalaryPlanManager(Byte.valueOf("1"));
		updateModel.setUpdateTime(DateUtil.DateToString(new Date()));
		erpFunUsersMapper.updateByPrimaryKeySelective(updateModel);
	}

	@Override
	public void evict(ErpFunUsers erpFunUsers) {
		if(erpFunUsers.getCompId() != null){//如果DEPT_ID 为空 COMP_ID 不为空 则清理全公司缓存
			this.evictBaseInfoByCompId(erpFunUsers.getCityId().intValue(), erpFunUsers.getCompId());
		}
	}

	@Override
	public Map<String, Integer> getUserCountByRange(Integer cityId, Integer compId,
			String serchRange, Integer serchRangeId, String dimension, Integer writeoff,Integer userId
			) {
		List<Map<String, Integer>> userCountByRange = erpFunUsersMapper.getUserCountByRange(cityId, compId, serchRange, serchRangeId, dimension, writeoff,userId);
		Map<String, Integer> userCountMap = userCountByRange.stream().collect(Collectors.toMap(val -> String.valueOf(val.get("dim")), val -> val.get("counts")));
		return userCountMap;
	}

	@Override
	public Map<String, Map<String, Integer>> getUserCountDateList(Integer cityId, Integer compId,
			String serchRange, Integer serchRangeId, String dimension, Integer writeoff,
			String dateCountType, String startTime, String endTime
			) {
		String dateListSql = DataAnalysisUtil.getUserCountDateListSql(startTime, endTime, dateCountType);
		if("GROUP".equals(serchRange)){
			serchRange ="GR";
		}
		List<Map<String, Integer>> userCountByRange = erpFunUsersMapper.getUserCountByRangeAndDate(cityId, compId, serchRange, serchRangeId, dimension, writeoff, startTime, endTime, dateListSql);
		Map<String, Map<String, Integer>> userCountMap = userCountByRange.stream().collect(Collectors.toMap(val -> String.valueOf(val.get("dim")), val -> val));
		return userCountMap;
	}

	@Override
	public Integer getUserCountByTimeRange(Integer cityId, Integer compId,
			String serchRange, Integer serchRangeId, String startTime, String endTime
			) {
		return erpFunUsersMapper.getUserCountByTimeRange(cityId, compId, serchRange, serchRangeId, startTime, endTime);
	}

	@Override
	public void evictBaseInfoByCompId(Integer cityId, Integer compId) {
	    cacheUtil.del(CacheStructure.hfterpdb_funUsersBaseInfoCache + compId + "_CITY_ID_" + cityId);
	    cacheUtil.del(CacheStructure.hfterpdb_funUsersBaseInfoCache_notwriteoff_map_by_COMP_ID + compId + "_CITY_ID_" + cityId);
	}

	@Override
	public ErpUsersInfoDto getUserInfoByUserId(Integer cityId, Integer compId, Integer userId, boolean areaFlagVal) {
		Integer flag = areaFlagVal?1:0;
		return erpFunUsersMapper.getUserInfoByUserIdForDeal(cityId,compId,userId,flag);
	}

	/**
	 * title ：设置预约带看管理员
	 * athor：lcb
	 * date  : 2017/11/2
	 */
	@Override
	public Integer setBespokeModuleManager(Integer cityId, Integer compId, Integer userId) {
//		ErpFunUsers erpFunUsers = new ErpFunUsers();
//		erpFunUsers.setShardCityId(cityId);
//		erpFunUsers.setBespokeManager(new Byte("1"));
//		erpFunUsers.setUserId(userId);
		erpFunUsersMapper.setBespokerManage(cityId, compId, userId);
		return userId;
	}

	@Override
	public String getCurrUserName(ErpCreateTrackInfoParam param) {
		String currUname = param.getSelfUserName();
		// 不是纯精英版也不是专业版 才写门店名称
		if (Integer.valueOf(Constants_DIC.DIC_COMP_TYPE_2)!= param.getCompType() && param.getIsPersonalVersion()) {
			currUname = param.getDeptNames() + " " + currUname;
		}
		return currUname;
	}

	@Override
	public List<Integer> getManageUserByUp(Integer cityId, Integer compId, String roleId, Integer areaId,
			Integer regId, Integer deptId, Integer grId, Optional<Integer> nowRange) {
		ErpFunUsers erpFunUsers = erpFunUsersMapper.getLastUserByUp(cityId, compId, roleId, areaId, regId, deptId, grId);
		if(erpFunUsers == null) {
			return new ArrayList<>(0);
		}
		List<ErpFunUsers> userListByRole = null;
		// 查询顺序不能改！
		if(erpFunUsers.getGrId() == 0) {
			nowRange = Optional.of(5);
			userListByRole = erpFunUsersMapper.getUserListByRole(cityId, roleId, compId, areaId, regId, deptId, grId);
		} else if(erpFunUsers.getDeptId() == 0) {
			nowRange = Optional.of(4);
			userListByRole = erpFunUsersMapper.getUserListByRole(cityId, roleId, compId, areaId, regId, deptId, null);
		} else if(erpFunUsers.getRegId() == 0) {
			nowRange = Optional.of(3);
			userListByRole = erpFunUsersMapper.getUserListByRole(cityId, roleId, compId, areaId, regId, null, null);
		} else if(erpFunUsers.getAreaId() == 0) {
			nowRange = Optional.of(2);
			userListByRole = erpFunUsersMapper.getUserListByRole(cityId, roleId, compId, areaId, null, null, null);
		} else {
			nowRange = Optional.of(1);
			userListByRole = erpFunUsersMapper.getUserListByRole(cityId, roleId, compId, null, null, null, null);
		}
		if(userListByRole == null || userListByRole.isEmpty()) {
			return new ArrayList<>(0);
		}
		List<Integer> userIdList = userListByRole.stream().collect(Collectors.mapping(ErpFunUsers::getUserId, Collectors.toList()));
		return userIdList;
	}

	@Override
	public List<Integer> getHaveAuditUserListForKey(Integer cityId, Integer compId, Integer areaId, Integer regId,
			Integer deptId, Integer grId) {
		Map<String, String> operMap = new HashMap<>();
		operMap.put("comp", "KEY_MANAGE_COMP");
		operMap.put("area", "KEY_MANAGE_AREA");
		operMap.put("reg", "KEY_MANAGE_REG");
		operMap.put("dept", "KEY_MANAGE_DEPT");
		operMap.put("group", "KEY_MANAGE_GROUP");
		return this.getHaveAuditUserListCommon(cityId, compId, areaId, regId, deptId, grId, operMap);
	}

	@Override
	public List<Integer> getHaveAuditUserListForExamin(Integer cityId, Integer compId, Integer areaId, Integer regId,
			Integer deptId, Integer grId) {
		Map<String, String> operMap = new HashMap<>();
		operMap.put("comp", "BIZ_DATA_EXAMIN_COMP");
		operMap.put("area", "BIZ_DATA_EXAMIN_AREA");
		operMap.put("reg", "BIZ_DATA_EXAMIN_REG");
		operMap.put("dept", "BIZ_DATA_EXAMIN_DEPT");
		operMap.put("group", "BIZ_DATA_EXAMIN_GROUP");
		return this.getHaveAuditUserListCommon(cityId, compId, areaId, regId, deptId, grId, operMap);
	}

	public List<Integer> getHaveAuditUserListCommon(Integer cityId, Integer compId, Integer areaId, Integer regId,
			Integer deptId, Integer grId, Map<String, String> operMap) {
		grId = (grId == null) ? 0 : grId;
		ErpFunUsers erpFunUsers = erpFunUsersMapper.getLastUserByUpForAudit(cityId, compId, operMap, areaId, regId, deptId, grId);
		if(erpFunUsers == null) {
			return new ArrayList<>(0);
		}
		List<ErpFunUsers> userListByRole = null;
		// 查询顺序不能改！
		if(erpFunUsers.getGrId() == 0) {
			userListByRole = erpFunUsersMapper.getUserListByAudit(cityId, operMap, compId, areaId, regId, deptId, grId);
		} else if(erpFunUsers.getDeptId() == 0) {
			userListByRole = erpFunUsersMapper.getUserListByAudit(cityId, operMap, compId, areaId, regId, deptId, null);
		} else if(erpFunUsers.getRegId() == 0) {
			userListByRole = erpFunUsersMapper.getUserListByAudit(cityId, operMap, compId, areaId, regId, null, null);
		} else if(erpFunUsers.getAreaId() == 0) {
			userListByRole = erpFunUsersMapper.getUserListByAudit(cityId, operMap, compId, areaId, null, null, null);
		} else {
			userListByRole = erpFunUsersMapper.getUserListByAudit(cityId, operMap, compId, null, null, null, null);
		}
		if(userListByRole == null || userListByRole.isEmpty()) {
			return new ArrayList<>(0);
		}
		List<Integer> userIdList = userListByRole.stream().collect(Collectors.mapping(ErpFunUsers::getUserId, Collectors.toList()));
		return userIdList;
	}

	@Transactional
	@Override
	public ErpFunUsers writeOffUser(DeleteUsersParam param, ErpFunUsers funUsersSel, String createUserName) {
		ErpFunUsers selfUser = param.getSelfUser();
/*		Integer cityId = selfUser.getCityId().intValue();
		Integer selfCompId = selfUser.getCompId();*/

        Integer cityId = param.getCityId();
        Integer selfCompId = param.getCompId();

		Integer selfUserId = selfUser.getUserId();

		AdminFunCity adminFunCityPO = adminFunCityMapper.getDataByCityId(cityId);
		param.setSelfProvinceId(adminFunCityPO.getProvinceId().intValue());
		// 注销用户
		this.writeOffUserOperator(funUsersSel, adminFunCityPO.getCompNo(), param);
		String trackContent = null;

		Integer orgId = funUsersSel.getOrganizationId();
			//这里又要根据被注销人的cityId和compId去查
		ErpFunOrganization orgInfo = erpFunOrganizationMapper.selectOrgByOrgId(cityId, selfCompId, orgId);
		trackContent = selfUser.getUserName() + "将该用户帐号从 " + orgInfo.getOrganizationName() + " 注销";
		erpFunOrganizationService.updateBelongOrgUserCount(cityId, selfCompId, orgId , -1);
		//erpFunEmployeeLogService.insertLogNew(cityId, selfCompId, (byte)5, trackContent, funUsersSel.getArchiveId(), selfUserId, funUsersSel.getOrganizationId(), null, funUsersSel.getUserPosition(), null);
		erpFunEmployeeLogService.insertLogNewNew(cityId, selfCompId, (byte)5, trackContent, funUsersSel.getArchiveId(), selfUserId, funUsersSel.getOrganizationId(), null, funUsersSel.getUserPosition(), null,createUserName);		// 写跟进
		adminCrmBrokerTrackService.createWriwriteOffUserTrack(funUsersSel.getArchiveId(), trackContent, param);
		// 踢用户
		this.endLoginUser(funUsersSel.getArchiveId(), funUsersSel.getUserMobile(), LogInEnum.WriteOff_UP);
		// 处理考勤数据
		ErpFunAttendanceScopeBiz erpFunAttendanceScopeBizPO = new ErpFunAttendanceScopeBiz();
		erpFunAttendanceScopeBizPO.setBizId(funUsersSel.getUserId());
		erpFunAttendanceScopeBizPO.setCompId(funUsersSel.getCompId());
		erpFunAttendanceScopeBizPO.setShardCityId(cityId);
		erpFunAttendanceScopeBizMapper.updateByUserId(erpFunAttendanceScopeBizPO);
		// 删除帖子提醒
		erpBroadcastMapper.deleteByArchiveId(cityId, funUsersSel.getArchiveId());
		// 为角色创建审核人，当审核状态为待审，但该角色没有审核人的情况下操作，老版本里面调用的新版，新版直接掉方法
		erpAuditRuntimeService.createAuditUserForUserChange(cityId, selfUser.getCompId(),
				funUsersSel.getUserPosition(), funUsersSel.getUserId());
		//清理下个月考勤信息  dyh  2018/08/14
		ErpFunAttendanceUserClassDetail attendanceUserClassDetail = new ErpFunAttendanceUserClassDetail();
		attendanceUserClassDetail.setShardCityId(cityId);
		attendanceUserClassDetail.setIsDel((byte) 1);
		attendanceUserClassDetail.setDelTime(new Date());
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		ErpFunAttendanceUserClassDetailExample attendanceUserClassDetailExample = new ErpFunAttendanceUserClassDetailExample();
		attendanceUserClassDetailExample.setShardCityId(cityId);
		attendanceUserClassDetailExample.createCriteria().andCompIdEqualTo(funUsersSel.getCompId())
				.andUserIdEqualTo(funUsersSel.getUserId()).andAttTimeGreaterThanOrEqualTo(calendar.getTime());
		erpFunAttendanceUserClassDetailMapper.updateByExampleSelective(attendanceUserClassDetail, attendanceUserClassDetailExample);

        //退还多余好房豆至公司账户
        this.giveBackBeanToComp(funUsersSel);
        //移交房客源数据至公盘
		//this.translateData(funUsersSel,param);
    	this.translateDataNew(funUsersSel,param);    //新组织架构移交数据
        // 删除钥匙相关业绩
        erpFunProfitMapper.deleteFunProfitByKey(cityId, selfCompId, funUsersSel.getUserId());
        //注销经纪人kpi方案
		invalidKpiConfig(cityId, param, funUsersSel);
        return funUsersSel;
    }

    //失效kpi配置方案
	private void invalidKpiConfig(Integer cityId, DeleteUsersParam param,ErpFunUsers deleteUser) {
		try {
			//删除经纪人kpi配置方案
			erpKpiUserAssociateConfigMapper.invalidConfig(cityId, deleteUser.getUserId(), new Date());
			//log
			ErpFunPartnerLog log = new ErpFunPartnerLog();
			log.setShardCityId(cityId);
			log.setCompId(deleteUser.getCompId());
			log.setCreateUid(param.getSelfUserId());
			log.setPartnerId(0);
			log.setModular((byte)0);
			log.setCreateTime(new Date());
			//log.setAfterModification("{num:" + count + "}");
			log.setLogContent(deleteUser.getUserName() + "离职注销配置kpi方案 userId="+deleteUser.getUserId());
			erpFunPartnerLogMapper.insertSelective(log);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	/**
	 * 移交房客源数据至对应组别的公盘
	 *
	 * @return
	 */
	private void translateDataNew(ErpFunUsers funUsersSel, DeleteUsersParam param) {
		Integer cityId = funUsersSel.getCityId().intValue();
		Integer compId = funUsersSel.getCompId();
		Integer userId = funUsersSel.getUserId();

        Integer saleCount = erpFunSaleMapper.getSaleCount(cityId, compId, userId);  //私盘出售房源数量
		Integer leaseCount = erpFunLeaseMapper.getLeaseCount(cityId, compId, userId);  //私盘出租房源数量
		Integer buyCount = erpFunBuyCustomerMapper.getBuyCustCount(cityId, compId, userId); //私盘求购客源数量
		Integer rentCount = erpFunRentCustomerMapper.getRentCustCount(cityId, compId, userId); //私盘求租客源数量

		//查被注销人的层级，而不是会话里面的层级
        ErpSysPara paraHouse = erpSysParaService.getMLErpSysParamByOrgId(cityId, compId, funUsersSel.getOrganizationId(),"TRANS_WRITEOFF_USERR_HOUSE_DATA");   //房源参数
        ErpSysPara paraCust = erpSysParaService.getMLErpSysParamByOrgId(cityId, compId, funUsersSel.getOrganizationId(), "TRANS_WRITEOFF_USERR_CUST_DATA");     //客源参数

		//查系统参数 查到对应的层级主键id
        boolean houseParamIsNull = (null == paraHouse || null == paraHouse.getParamValue());    //房源参数取出来是否为空，为空为true,为0是跳公司级
        boolean custParamIsNull = (null == paraCust || null == paraCust.getParamValue());

        Integer defHouseId = 0;
        Integer deCustId = 0;
        if (!houseParamIsNull){
	        defHouseId = Integer.parseInt(paraHouse.getParamValue());   //房源移交到的defId，取出来不为空就直接用（可能会为0），为空就去查用户所在层级的defId
        }else{     //参数为空移交到本级公盘
        	defHouseId = erpFunOrganizationMapper.selectDefIdByOrgId(cityId, compId, funUsersSel.getOrganizationId());
        }
        if (!custParamIsNull){
	        deCustId = Integer.parseInt(paraCust.getParamValue());      //客源移交到的defId
        }else{    //参数为空移交到本级公盘
        	deCustId = erpFunOrganizationMapper.selectDefIdByOrgId(cityId, compId, funUsersSel.getOrganizationId());
        }

        ErpFunOrganizationDefinition erpFunOrganizationDefinitionHouse = null;//房客源的ErpFunOrganizationDefinition
        ErpFunOrganizationDefinition erpFunOrganizationDefinitionCust = null;
        Integer houseDefId = null;//要移到的房客源层级的defId
        Integer custDefId = null;
        Integer houseLevel = null;//要移交到的房源层级
        Integer custLevel = null;

        if (0 == defHouseId){  //如果房源是移到公司级（为0）,设置defId和level为0
        	houseDefId = 0;
        	houseLevel = 0;
        }else{
    	    //再根据id查到FUN_ORGANIZATION_DEFINITION的  DEFINITION_LEVEL
    	    //房源的ErpFunOrganizationDefinition
    	    erpFunOrganizationDefinitionHouse = erpFunOrganizationDefinitionMapper.getOrganizationDefinitionByDefId(cityId,compId,defHouseId);
    	    houseDefId = erpFunOrganizationDefinitionHouse.getDefinitionId(); //要移到到的房源层级的defId
    	    houseLevel = erpFunOrganizationDefinitionHouse.getDefinitionLevel();  //要移交到的房源层级
        }

        if (0 == deCustId){  //如果客源是移到公司级（为0）,设置defId和level为0
        	custDefId = 0;
        	custLevel = 0;

        }else{
    	    //客源的ErpFunOrganizationDefinition
    	    erpFunOrganizationDefinitionCust = erpFunOrganizationDefinitionMapper.getOrganizationDefinitionByDefId(cityId,compId,deCustId);
    	    custDefId = erpFunOrganizationDefinitionCust.getDefinitionId();  //要移到到的客源层级的defId
    	    custLevel  = erpFunOrganizationDefinitionCust.getDefinitionLevel();  //要移交到的客源层级
        }

	    String tissueLine =  funUsersSel.getTissueLine(); //被删除人的组织架构线
	    String [] tissueLines = tissueLine.split(":");    //分割组织架构线
	    ErpFunOrganization organizationHouse = erpFunOrganizationMapper.selectOrgByTissueLine(cityId, compId, tissueLines, defHouseId); //查房源移交到哪一级
	    ErpFunOrganization organizationCust  = erpFunOrganizationMapper.selectOrgByTissueLine(cityId, compId ,tissueLines, deCustId);   //查客源移交到哪一级
	    String tissueLineHouse = null;
	    String tissueLineCust = null;
	    Integer organizationIdHouse = 0;
	    Integer organizationIdCust = 0;
	    if (null != organizationHouse){
	    organizationIdHouse = organizationHouse.getOrganizationId();//房源要移交的到organizationId
	    tissueLineHouse = organizationHouse.getOrganizationPath(); //房源移交到那一级的组织架构线（如果用户层级高于设置层级的时候会查不到，所以要判空）
	    }
	    if (null != organizationCust){
	    organizationIdCust = organizationCust.getOrganizationId();//客源要移交的到organizationId
	    tissueLineCust = organizationCust.getOrganizationPath();   //客源移交到那一级的组织架构线
	    }

	    Integer funUsersSelLevel = erpFunOrganizationDefinitionMapper.getUserLevelByOrgId(cityId,compId,funUsersSel.getOrganizationId());//查用户所在的层级(1,2,3)
	    if (funUsersSelLevel<houseLevel){ //被注销人的层级高于要移到的房源层级,要改成用户本级的
	    	Integer userDefId = erpFunOrganizationMapper.selectDefIdByOrgId(cityId, compId, funUsersSel.getOrganizationId());   //被注销人本级defId
	    	houseDefId = userDefId;
	    	organizationHouse = erpFunOrganizationMapper.selectOrgByTissueLine(cityId, compId, tissueLines, userDefId); //查被注销人在的FunOrganization
	    	tissueLineHouse = organizationHouse.getOrganizationPath(); //被注销人所在的组织架构线
	    	organizationIdHouse = organizationHouse.getOrganizationId(); //被注销人的organizationId

	    }

	    if (funUsersSelLevel<custLevel){  //被注销人的层级高于要移到的客源层级，要改成用户本级的
	    	Integer userDefId = erpFunOrganizationMapper.selectDefIdByOrgId(cityId, compId, funUsersSel.getOrganizationId());   //被注销人本级defId
	    	custDefId = userDefId;
	    	organizationCust  = erpFunOrganizationMapper.selectOrgByTissueLine(cityId, compId, tissueLines, userDefId);   //查被注销人在的FunOrganization
	    	tissueLineCust = organizationCust.getOrganizationPath();   //被注销人所在的组织架构线
	    	organizationIdCust = organizationCust.getOrganizationId();//被注销人的organizationId
	    }

        if (0 == defHouseId){  //如果房源是移到公司级（为0）,设置组织架构线和orgId为0
        	tissueLineHouse = "0";
        	organizationIdHouse = 0;
        }

        if (0 == deCustId){  //如果客源是移到公司级（为0）
        	tissueLineCust = "0";
        	organizationIdCust = 0;
        }

	    //要改的字段
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("now", new Date());  //移交时间
		paramMap.put("userId", userId);  //被注销人的用户id

		ErpFunUsers selfUser = param.getSelfUser();
        Integer createUserId = selfUser.getUserId();   //操作人的信息，用来写跟进
        Integer createDeptId = selfUser.getDeptId();
        Integer createOrganizationId = param.getOrganizationId();
        String  createOrganizationName = param.getOrganizationName();
        String  createOrganizationPath = param.getOrganizationPath();
        String createUsername = selfUser.getUserName();

    	 //如果出售私盘房源不为null和0，则移交和写跟进
		if(saleCount != null && saleCount > 0){
			paramMap.put("tissueLineHouse", tissueLineHouse);
			//paramMap.put("userLevel", houseLevel);     //对应的level
			paramMap.put("userLevel", houseDefId);     //对应的level ,房客源表存的是defId
			paramMap.put("organizationId", organizationIdHouse);
			//这边查询出来INSERT，数据量大于2000条报错了，就修改为INSERT SELECT了。
//            ErpFunSaleExample funSaleExample = new ErpFunSaleExample();
//            //根据compId和userId先查询出来出售房源的列表
//            funSaleExample.setShardCityId(cityId);
//            funSaleExample.createCriteria().andCompIdEqualTo(compId).andUserIdEqualTo(userId);
//            List<ErpFunSale> erpFunSalesForTrans = erpFunSaleMapper.selectByExample(funSaleExample);
            //写跟进用的以前的
            erpFunTrackMapper.insertBatchForTransForSale(cityId, compId, createUserId, createDeptId, Const.DIC_CASE_TYPE_SALE_FUN, Const.DIC_TRACK_TYPE_JUMP_SHARE,
                    "[ 房源移交 ]", "注销员工("+funUsersSel.getUserName()+")，将出售房源数据移交至对应级别的公盘", userId, createOrganizationId,createOrganizationName,createOrganizationPath,organizationIdHouse,createUsername);
            erpFunSaleMapper.transSaleData(cityId, paramMap);
		}

		//出租的私盘
		if(leaseCount != null && leaseCount > 0){
			paramMap.put("tissueLineHouse", tissueLineHouse);
			//paramMap.put("userLevel", houseLevel);     //对应的level
			paramMap.put("userLevel", houseDefId);
			paramMap.put("organizationId", organizationIdHouse);
			//这边查询出来INSERT，数据量大于2000条报错了，就修改为INSERT SELECT了。
//            ErpFunLeaseExample funLeaseExample = new ErpFunLeaseExample();
//            funLeaseExample.setShardCityId(cityId);
//            funLeaseExample.createCriteria().andCompIdEqualTo(compId).andUserIdEqualTo(userId);
//            List<ErpFunLease> erpFunLeasesForTrans = erpFunLeaseMapper.selectByExample(funLeaseExample);
            erpFunTrackMapper.insertBatchForTransForLease(cityId, compId, createUserId, createDeptId, Const.DIC_CASE_TYPE_LEASE_FUN, Const.DIC_TRACK_TYPE_JUMP_SHARE,
                    "[ 房源移交 ]", "注销员工("+funUsersSel.getUserName()+")，将出租房源数据移交至对应级别的公盘", userId,  createOrganizationId,createOrganizationName,createOrganizationPath,organizationIdHouse,createUsername);
            erpFunLeaseMapper.transLeaseData(cityId, paramMap);
		}

		//买房客源
		if(buyCount != null && buyCount > 0){
			paramMap.put("tissueLineCust", tissueLineCust);
			//paramMap.put("userLevel", custLevel);     //对应的level
			paramMap.put("userLevel", custDefId);
			paramMap.put("organizationId", organizationIdCust);
			//这边查询出来INSERT，数据量大于2000条报错了，就修改为INSERT SELECT了。
//            ErpFunBuyCustomerExample buyCustExample = new ErpFunBuyCustomerExample();
//            buyCustExample.setShardCityId(cityId);
//            buyCustExample.createCriteria().andCompIdEqualTo(compId).andUserIdEqualTo(userId);
//            List<ErpFunBuyCustomer> erpFunBuyCustomerForTrans = erpFunBuyCustomerMapper.selectByExample(buyCustExample);
            erpFunTrackMapper.insertBatchForTransForBuyCust(cityId, compId, createUserId, createDeptId, Const.DIC_CASE_TYPE_BUY_CUST, Const.DIC_TRACK_TYPE_JUMP_SHARE,
                    "[ 客源移交 ]", "注销员工("+funUsersSel.getUserName()+")，将求购客源数据移交至对应级别的公盘", userId,  createOrganizationId,createOrganizationName,createOrganizationPath,organizationIdCust,createUsername);
			erpFunBuyCustomerMapper.transBuyData(cityId, paramMap);
		}

		//租房客源
		if(rentCount != null && rentCount > 0){
			paramMap.put("tissueLineCust", tissueLineCust);
			//paramMap.put("userLevel", custLevel);     //对应的level
			paramMap.put("userLevel", custDefId);
			paramMap.put("organizationId", organizationIdCust);
			//这边查询出来INSERT，数据量大于2000条报错了，就修改为INSERT SELECT了。
//            ErpFunRentCustomerExample rentCustExample = new ErpFunRentCustomerExample();
//            rentCustExample.setShardCityId(cityId);
//            rentCustExample.createCriteria().andCompIdEqualTo(compId).andUserIdEqualTo(userId);
//            List<ErpFunRentCustomer> erpFunRentCustomerForTrans = erpFunRentCustomerMapper.selectByExample(rentCustExample);
            erpFunTrackMapper.insertBatchForTransForRentCust(cityId, compId, createUserId, createDeptId, Const.DIC_CASE_TYPE_RENT_CUST, Const.DIC_TRACK_TYPE_JUMP_SHARE,
                    "[ 客源移交 ]", "注销员工("+funUsersSel.getUserName()+")，将求租客源数据移交至对应级别的公盘", userId,  createOrganizationId,createOrganizationName,createOrganizationPath,organizationIdCust,createUsername);
            erpFunRentCustomerMapper.transRentData(cityId, paramMap);
		}

		//throw new BusinessException("测试中断程序");

	}






	/**
	 * 移交房客源数据至对应组织的公盘
	 *
	 * @return
	 */
	/*private void translateData(ErpFunUsers funUsersSel, DeleteUsersParam param) {
		Integer cityId = funUsersSel.getCityId().intValue();
		Integer compId = funUsersSel.getCompId();
		Integer userId = funUsersSel.getUserId();
		Integer areaId = funUsersSel.getAreaId();
		Integer regId = funUsersSel.getRegId();
		Integer deptId = funUsersSel.getDeptId();
		Integer grId = funUsersSel.getGrId();
		String deptName = null;
		String grName = null;
		//获取组名和部门名
		if(deptId!=null){
            ErpFunDeptsExample deptExample = new ErpFunDeptsExample();
            deptExample.setShardCityId(cityId);
            deptExample.createCriteria().andCompIdEqualTo(compId).andDeptIdEqualTo(deptId);
            List<ErpFunDepts> erpFunDepts = erpFunDeptsMapper.selectByExample(deptExample);
            if(!erpFunDepts.isEmpty() && erpFunDepts.get(0)!=null){
                deptName = erpFunDepts.get(0).getDeptName();
            }
        }
        if(grId!=null){
            ErpFunDeptsgroupExample grExample = new ErpFunDeptsgroupExample();
            grExample.setShardCityId(cityId);
            grExample.createCriteria().andCompIdEqualTo(compId).andDeptIdEqualTo(deptId).andGrIdEqualTo(grId);
            List<ErpFunDeptsgroup> erpFunDeptsgroups = erpFunDeptsgroupMapper.selectByExample(grExample);
            if(!erpFunDeptsgroups.isEmpty() && erpFunDeptsgroups.get(0)!=null){
                grName = erpFunDeptsgroups.get(0).getGrName();
            }
        }
        Integer saleCount = erpFunSaleMapper.getSaleCount(cityId, compId, userId);
		Integer leaseCount = erpFunLeaseMapper.getLeaseCount(cityId, compId, userId);
		Integer buyCount = erpFunBuyCustomerMapper.getBuyCustCount(cityId, compId, userId);
		Integer rentCount = erpFunRentCustomerMapper.getRentCustCount(cityId, compId, userId);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("now", new Date());
		paramMap.put("areaId", areaId);
		paramMap.put("regId", regId);
		paramMap.put("deptId", deptId);
		paramMap.put("grId", grId);
		paramMap.put("userId", userId);

		Integer operatorUserId = param.getOperatorUserId();
		ErpFunUsers operator = erpFunUsersMapper.selectByUserId(cityId, operatorUserId);
		String operatorUserName = operator.getUserName();
		String tissueLine = operator.getTissueLine();
		Integer organizationId = operator.getOrganizationId();
		Integer organizationIdDelUser = funUsersSel.getOrganizationId();
		ErpFunOrganizationExample orgExample = new ErpFunOrganizationExample();
		orgExample.setShardCityId(cityId);
		orgExample.createCriteria().andCompIdEqualTo(compId).andOrganizationIdEqualTo(organizationIdDelUser);
		List<ErpFunOrganization> erpFunOrganizations = erpFunOrganizationMapper.selectByExample(orgExample);
		String organizationName = erpFunOrganizations.get(0).getOrganizationName();
		//分别对各数据进行转盘修改，以及写跟进
		if(saleCount != null && saleCount > 0){
            ErpFunSaleExample funSaleExample = new ErpFunSaleExample();
            funSaleExample.setShardCityId(cityId);
            funSaleExample.createCriteria().andCompIdEqualTo(compId).andUserIdEqualTo(userId);
            List<ErpFunSale> erpFunSalesForTrans = erpFunSaleMapper.selectByExample(funSaleExample);
            erpFunTrackMapper.insertBatchForTransForSale(cityId, compId, param.getUserId(), funUsersSel.getDeptId(), Const.DIC_CASE_TYPE_SALE_FUN, Const.DIC_TRACK_TYPE_JUMP_SHARE,
                    "[ 房源移交 ]", "注销员工，将出售房源数据移交至对应组织的公盘", funUsersSel.getUserId(), funUsersSel.getDeptId(),grName,funUsersSel.getGrId(),
					deptName, erpFunSalesForTrans,tissueLine,organizationId,organizationName,operatorUserName);
            erpFunSaleMapper.transDataForDeleteUser(cityId, paramMap);
		}
		if(leaseCount != null && leaseCount > 0){
            ErpFunLeaseExample funLeaseExample = new ErpFunLeaseExample();
            funLeaseExample.setShardCityId(cityId);
            funLeaseExample.createCriteria().andCompIdEqualTo(compId).andUserIdEqualTo(userId);
            List<ErpFunLease> erpFunLeasesForTrans = erpFunLeaseMapper.selectByExample(funLeaseExample);
            erpFunTrackMapper.insertBatchForTransForLease(cityId, compId, param.getUserId(), funUsersSel.getDeptId(), Const.DIC_CASE_TYPE_LEASE_FUN, Const.DIC_TRACK_TYPE_JUMP_SHARE,
                    "[ 房源移交 ]", "注销员工，将出租房源数据移交至对应组织的公盘", funUsersSel.getUserId(), funUsersSel.getDeptId(),grName,funUsersSel.getGrId(),
					deptName, erpFunLeasesForTrans,tissueLine,organizationId,organizationName,operatorUserName);
            erpFunLeaseMapper.transDataForDeleteUser(cityId, paramMap);
		}
		if(buyCount != null && buyCount > 0){
            ErpFunBuyCustomerExample buyCustExample = new ErpFunBuyCustomerExample();
            buyCustExample.setShardCityId(cityId);
            buyCustExample.createCriteria().andCompIdEqualTo(compId).andUserIdEqualTo(userId);
            List<ErpFunBuyCustomer> erpFunBuyCustomerForTrans = erpFunBuyCustomerMapper.selectByExample(buyCustExample);
            erpFunTrackMapper.insertBatchForTransForBuyCust(cityId, compId, param.getUserId(), funUsersSel.getDeptId(), Const.DIC_CASE_TYPE_BUY_CUST, Const.DIC_TRACK_TYPE_JUMP_SHARE,
                    "[ 客源移交 ]", "注销员工，将求购客源数据移交至对应组织的公盘", funUsersSel.getUserId(), funUsersSel.getDeptId(),grName,funUsersSel.getGrId(),
					deptName, erpFunBuyCustomerForTrans,tissueLine,organizationId,organizationName,operatorUserName);
			erpFunBuyCustomerMapper.transDataForDeleteUser(cityId, paramMap);
		}
		if(rentCount != null && rentCount > 0){
            ErpFunRentCustomerExample rentCustExample = new ErpFunRentCustomerExample();
            rentCustExample.setShardCityId(cityId);
            rentCustExample.createCriteria().andCompIdEqualTo(compId).andUserIdEqualTo(userId);
            List<ErpFunRentCustomer> erpFunRentCustomerForTrans = erpFunRentCustomerMapper.selectByExample(rentCustExample);
            erpFunTrackMapper.insertBatchForTransForRentCust(cityId, compId, param.getUserId(), funUsersSel.getDeptId(), Const.DIC_CASE_TYPE_RENT_CUST, Const.DIC_TRACK_TYPE_JUMP_SHARE,
                    "[ 客源移交 ]", "注销员工，将求租客源数据移交至对应组织的公盘", funUsersSel.getUserId(), funUsersSel.getDeptId(),grName,funUsersSel.getGrId(),
					deptName, erpFunRentCustomerForTrans,tissueLine,organizationId,organizationName,operatorUserName);
            erpFunRentCustomerMapper.transDataForDeleteUser(cityId, paramMap);
		}
		//throw new BusinessException("测试中断程序");
	}*/

        /**
     * 退还多余好房豆至公司账户
     *
     * @return
     */
    private void giveBackBeanToComp(ErpFunUsers funUsersSel) {
        //获取被注销人的adminComp
        Integer cityId = funUsersSel.getCityId().intValue();
        Integer deptId = funUsersSel.getDeptId();
        ErpFunDepts erpFunDepts = erpFunDeptsMapper.selectByPrimaryKey(new ErpFunDepts(cityId, deptId));
        String compNo = erpFunDepts.getCompNo();
        String deptNo = erpFunDepts.getDeptNo();
        AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(compNo);
        AdminFunDepts adminFunDepts = adminFunDeptsMapper.selectByDeptNoAndCompNo(deptNo, compNo);
        Date filterTime = null;
        Date joinDeptTime = funUsersSel.getJoinDeptTime();
        if (joinDeptTime == null) {
            filterTime = funUsersSel.getCreationTime();
        } else {
            filterTime = joinDeptTime;
        }
        ArrayList<Integer> archiveIds = new ArrayList<>();
        archiveIds.add(funUsersSel.getArchiveId());
        List<AdminFunArchive> listByArchiveIds = adminFunArchiveMapper.getListByArchiveIds(archiveIds);
        if (listByArchiveIds != null && listByArchiveIds.size() > 0 && listByArchiveIds.get(0).getUaId() != null) {
        	Integer uaId = listByArchiveIds.get(0).getUaId();
        	Integer compUaId = adminFunComp.getUaId();
            //获取奖励的好房豆
            Float gotBean = adminFunPaidMapper.sumBeanGot(cityId, uaId, filterTime);
            if (gotBean != null && gotBean > 0F) {
                //获取个人消费的好房豆
                String allHaofangAmount = adminFunPaidMapper.getAllHaofangAmount(uaId, true, filterTime).getSumAmount();
                Double consumeBean = Double.parseDouble(allHaofangAmount);
                Double diff = gotBean - consumeBean;
                if (consumeBean != null && diff != null && diff > 0F) {
					if (adminFunComp != null && compUaId != null) {
                    	Date date = new Date();
						AdminFunUserAccount userAccount = adminFunUserAccountMapper.selectByPrimaryKey(uaId);
                    	AdminFunUserAccount compAccount = adminFunUserAccountMapper.selectByPrimaryKey(compUaId);
                    	adminFunUserAccountMapper.rechargeHaofangAmount(uaId, -diff);
                    	adminFunUserAccountMapper.rechargeHaofangAmount(compUaId, diff);
                        // 添加个人明细
                        AdminFunPaid userAdminFunPaid = new AdminFunPaid();
                        userAdminFunPaid.setUaId(uaId);
                        userAdminFunPaid.setArchiveId(funUsersSel.getArchiveId());
                        userAdminFunPaid.setCityId(cityId.shortValue());
                        userAdminFunPaid.setPaidCatigory("PAY");
                        userAdminFunPaid.setPaidType("WORKCOUNT_BEAN_USER_RETURN");
                        userAdminFunPaid.setAmount(diff);
                        userAdminFunPaid.setPadiTime(date);
                        userAdminFunPaid.setDesc("量化分配的好房豆，员工离职后退回公司账户");
                        userAdminFunPaid.setAmountBefore(userAccount.getHaofangAmount().doubleValue());
                        userAdminFunPaid.setAmountAfter(userAccount.getHaofangAmount().doubleValue() - diff);
                        userAdminFunPaid.setAmountQuan(diff);
                        userAdminFunPaid.setDeptId(adminFunDepts.getDeptId());
                        adminFunPaidMapper.insertSelective(userAdminFunPaid);
                        //添加公司明细
                        AdminFunPaid compAdminFunPaid = new AdminFunPaid();
                        compAdminFunPaid.setUaId(compUaId);
//                        compAdminFunPaid.setArchiveId(funUsersSel.getArchiveId());
                        compAdminFunPaid.setCityId(cityId.shortValue());
                        compAdminFunPaid.setPaidCatigory("INCOME");
                        compAdminFunPaid.setPaidType("WORKCOUNT_BEAN_USER_RETURN");
                        compAdminFunPaid.setAmount(diff);
                        compAdminFunPaid.setPadiTime(date);
                        compAdminFunPaid.setDesc("量化分配的好房豆，员工离职后退回公司账户");
                        compAdminFunPaid.setAmountBefore(compAccount.getHaofangAmount().doubleValue());
                        compAdminFunPaid.setAmountAfter(compAccount.getHaofangAmount().doubleValue() + diff);
                        compAdminFunPaid.setAmountQuan(diff);
                        compAdminFunPaid.setDeptId(adminFunDepts.getDeptId());
                        adminFunPaidMapper.insertSelective(compAdminFunPaid);
                    }
                }
            }
        }/* else {
            throw new BusinessException("无此用户档案表");
        }*/
    }


	/**
	 * 对指定账户执行注销流程
	 * @return
	 * @throws Exception
	 */
	private ErpFunUsers writeOffUserOperator(ErpFunUsers funUsersPO, String cityCompNo, DeleteUsersParam param) {
		Integer cityId = funUsersPO.getCityId().intValue();

		Integer isCrmDelete = param.getIsCrmDelete();
		ErpFunUsers selfUser = param.getSelfUser();

		// 注销当前用户
		erpFunUsersMapper.updateByUserIdAndDeptId(cityId, funUsersPO.getUserId());
		//维护门店经纪人数量

		// 修改归属信息为当前城市ID
//		ErpFunUsers funUsersPOTemp = new ErpFunUsers();
//		try {
//			BeanUtil.copyObject(funUsersPO, funUsersPOTemp);
//		} catch (Exception e) {
//			throw new ConfirmException("对象拷贝失败", e);
//		}
//		funUsersPOTemp.setCompId(cityId);
//		funUsersPOTemp.setDeptId(cityId);
//		funUsersPOTemp.setAreaId(cityId);
//		funUsersPOTemp.setRegId(cityId);
//		funUsersPOTemp.setGrId(Const.DIC_DEFAULT_GROUP_ID);
//		funUsersPOTemp.setUserEdition(2);
//		funUsersPOTemp.setUserStatus((byte) 1);
//		funUsersPOTemp.setShardCityId(cityId);
//		erpFunUsersMapper.insertSelective(funUsersPOTemp);
//		// 更新员工编号
//		String userNoString = cityCompNo + String.format("%07d", funUsersPOTemp.getUserId());
//		funUsersPOTemp.setUserNo(userNoString);
//		funUsersPOTemp.setUpdateTime(DateUtil.DateToString(new Date()));
//		erpFunUsersMapper.updateByPrimaryKeySelective(funUsersPOTemp);
//
//		// 新营销版用户，数据跟着人走
//		if(isCrmDelete != null && isCrmDelete == 1) {
//			// crm调用的注销用户，需要把数据全部放到总经理名下
//			erpFunUsersMapper.updateDataToGeneralManager(cityId, funUsersPO.getUserId(), selfUser);
//		} else {
//			erpFunUsersMapper.updateDataToPersonal(cityId, funUsersPOTemp.getUserId(), funUsersPOTemp.getArchiveId());
//		}

		/* 注销用户时 更新用户的档案信息 资质信息等 */
		AdminFunArchive adminFunArchive = new AdminFunArchive();
		adminFunArchive.setArchiveId(funUsersPO.getArchiveId());
		adminFunArchive.setUserHonest(0);
		adminFunArchive.setFriendFlag(1);
		adminFunArchive.setSellId(0);
		adminFunArchive.setPlateType((byte) 2);
		//adminFunArchive.setUserEdition(2); jsg 2020-06-03注释 美联没有精英版
		adminFunArchiveMapper.updateByPrimaryKeySelective(adminFunArchive);
		AdminFunUserRqs adminFunUserRqs = new AdminFunUserRqs();
		adminFunUserRqs.setArchiveId(funUsersPO.getArchiveId());
		adminFunUserRqs.setRqsAptitudeStatus(0);
		adminFunUserRqsMapper.updateByPrimaryKeySelective(adminFunUserRqs);
		// 清除掉发发的房源数据，用户账号信息不能删除。
		//delete from COUNT_DONE where S_ID in (select S_ID from SHOP_INFO where ARCHIVE_ID = #{archiveId})
		/*FafunShopInfoExample example = new FafunShopInfoExample();
		example.createCriteria().andArchiveIdEqualTo(funUsersPO.getArchiveId());
		List<FafunShopInfo> fafunShopInfos = fafunShopInfoMapper.selectByExample(example);
		if(fafunShopInfos !=null && fafunShopInfos.size() > 0){
			List<Integer> sIds = new ArrayList<Integer>();
			for (FafunShopInfo fafunShopInfo : fafunShopInfos) {
				sIds.add(fafunShopInfo.getsId());
			}
			if(sIds.size() > 0){
				ErpCountDoneExample countDoneExample = new ErpCountDoneExample();
				countDoneExample.setShardArchiveId(funUsersPO.getArchiveId());
				countDoneExample.createCriteria().andSIdIn(sIds);
				erpCountDoneMapper.deleteByExample(countDoneExample);
			}
		}*/
		fafunShopInfoMapper.deleteUserWriteOffFaFaData(funUsersPO.getArchiveId());
		/* 清除掉用户的上架房源 开始 */
		ErpFunHousePublishStatus funHousePublishStatusPO = new ErpFunHousePublishStatus();
		funHousePublishStatusPO.setSyncFlag(0);
		funHousePublishStatusPO.setUpdateTime(new Date());
		funHousePublishStatusPO.setPublishSite(Const.DIC_QQ_PUBLISH_SITE_OFFLINE);
		funHousePublishStatusPO.setArchiveId(funUsersPO.getArchiveId());
		funHousePublishStatusPO.setCityId(cityId);
		funHousePublishStatusPO.setShardCityId(cityId);
		erpFunHousePublishStatusMapper.updateByArchiveId(funHousePublishStatusPO);
		/* 清除掉用户的上架房源 结束 */
		// 更新员工档案
		ErpFunEmployeeDoc erpFunEmployeeDocPO = new ErpFunEmployeeDoc();
		erpFunEmployeeDocPO.setWriteoffTime(new Date());
		erpFunEmployeeDocPO.setUpdateTime(new Date());
		erpFunEmployeeDocPO.setCompId(funUsersPO.getCompId());
		erpFunEmployeeDocPO.setArchiveId(funUsersPO.getArchiveId());
		erpFunEmployeeDocPO.setShardCityId(cityId);
		erpFunEmployeeDocMapper.updateByArchiveId(erpFunEmployeeDocPO);
		this.evictBaseInfoByCompId(cityId, funUsersPO.getCompId());
		return funUsersPO;
	}

	/**
	 * @tag
	 * @author 邓永洪
	 * @since 2018/5/19
	 */
	@Transactional
	@Override
	public ErpFunUsers createUser(ErpFunUsers newUser, CreateUserParam param, Integer currentPId, boolean isFangJidi) {
		Integer cityId = param.getCurrentCityId();
		String rangeIds = param.getRangeIds();
		Integer rangeType = param.getRangeType();
		ErpFunUsers selfUser = erpFunUsersMapper.getFunUserByUserId(cityId, param.getCurrentUserId());
		newUser.setCityId(cityId.shortValue());
		newUser.setLoginUserid(newUser.getUserMobile());
		newUser.setLoginPassword(EnCodeHelper.MD5Encode(newUser.getLoginPassword()));
		newUser.setUpdateUid(param.getCurrentUserId());
		newUser.setShardCityId(cityId);
		//添加职级ID
		newUser.setRoleLevelId(param.getRoleLevelId());
		// 体验版用户创建的账号也是体验版用户
		if (selfUser.getExperienceUser() == 1) {
			newUser.setExperienceUser((byte) 1);
		}
		ErpFunUsers funUsers = this.createOrUpdateUser(newUser, param);
		this.updateUserManageRange(funUsers.getUserId(), funUsers.getUserPosition(), rangeIds, rangeType, param, isFangJidi);
		// 初始化员工考勤，先初始化考勤地点
		List<ErpFunAttendanceScope> attendanceScopeList = erpFunAttendanceScopeMapper.getAttendanceScopeByCompIdDeptId(cityId, param.getCurrentCompId(), funUsers.getDeptId());
		ErpFunAttendanceScope funAttendanceScope = null;
		if (attendanceScopeList != null && attendanceScopeList.size() > 0)
			funAttendanceScope = attendanceScopeList.get(0);
		if (null != funAttendanceScope) {
			ErpFunAttendanceScopeBizExample attendanceScopeBizExample = new ErpFunAttendanceScopeBizExample();
			attendanceScopeBizExample.setShardCityId(cityId);
			attendanceScopeBizExample.createCriteria().andAttScopeIdEqualTo(funAttendanceScope.getAttScopeId())
					.andCompIdEqualTo(param.getCurrentCompId()).andChooseTypeEqualTo(1).andIsDelEqualTo((byte) 0)
					.andBizIdEqualTo(funAttendanceScope.getDeptId());
			List<ErpFunAttendanceScopeBiz> attendanceScopeBizs = erpFunAttendanceScopeBizMapper.selectByExample(attendanceScopeBizExample);
			if (!attendanceScopeBizs.isEmpty() && attendanceScopeBizs.get(0) != null) {
				ErpFunAttendanceScopeBiz attendanceScopeBiz = attendanceScopeBizs.get(0);
				ErpFunAttendanceScopeBizPerson erpFunAttendanceScopeBizPerson = new ErpFunAttendanceScopeBizPerson();
				erpFunAttendanceScopeBizPerson.setShardCityId(cityId);
				erpFunAttendanceScopeBizPerson.setAttScopeId(funAttendanceScope.getAttScopeId());
				erpFunAttendanceScopeBizPerson.setCreateTime(new Date());
				erpFunAttendanceScopeBizPerson.setScopBizId(attendanceScopeBiz.getBizId());
				erpFunAttendanceScopeBizPerson.setUserId(funUsers.getUserId());
				erpFunAttendanceScopeBizPerson.setUserName(funUsers.getUserName());
				erpFunAttendanceScopeBizPersonMapper.insertSelective(erpFunAttendanceScopeBizPerson);
			}
		}

		// 初始化考勤组
		ErpFunAttendanceGroupBizExample attendanceGroupBizExample = new ErpFunAttendanceGroupBizExample();
		attendanceGroupBizExample.setShardCityId(cityId);
		attendanceGroupBizExample.createCriteria().andCompIdEqualTo(param.getCurrentCompId()).andChooseTypeEqualTo(1)
				.andBizIdEqualTo(funUsers.getDeptId()).andIsDelEqualTo((byte) 0);
		List<ErpFunAttendanceGroupBiz> erpFunAttendanceGroupBizs = erpFunAttendanceGroupBizMapper.selectByExample(attendanceGroupBizExample);
		if (erpFunAttendanceGroupBizs != null&& !erpFunAttendanceGroupBizs.isEmpty() && erpFunAttendanceGroupBizs.get(0) != null) {
			ErpFunAttendanceGroupBiz attendanceGroupBiz = erpFunAttendanceGroupBizs.get(0);
			ErpFunAttendanceGroupBizPerson erpFunAttendanceGroupBizPerson = new ErpFunAttendanceGroupBizPerson();
			erpFunAttendanceGroupBizPerson.setShardCityId(cityId);
			erpFunAttendanceGroupBizPerson.setAttGroupId(attendanceGroupBiz.getAttGroupId());
			erpFunAttendanceGroupBizPerson.setCreateTime(new Date());
			erpFunAttendanceGroupBizPerson.setGroupBizId(attendanceGroupBiz.getId());
			erpFunAttendanceGroupBizPerson.setUserId(funUsers.getUserId());
			erpFunAttendanceGroupBizPerson.setUserName(funUsers.getUserName());
			erpFunAttendanceGroupBizPersonMapper.insertSelective(erpFunAttendanceGroupBizPerson);
		}
		//员工注册完成 判断公司是否需要审核
//		try {
//			sendRegistrationAuditMsg(funUsers,currentPId,cityId);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		return funUsers;
	}

	/**
	 * 新版组织机构创建员工
	 * @param newUser 带很多属性
	 * @param param 参数集
	 * @param currentPId 直接管理人
	 * @param isFangJidi 是否是房基地
	 * @author zangtie
	 * @since 2019/12/9 11:35
	 * @return com.myfun.repository.erpdb.po.ErpFunUsers
	 **/
	@Transactional
	@Override
	public ErpFunUsers createUserNew(ErpFunUsers newUser, CreateUserParam param, Integer currentPId, boolean isFangJidi,
									 String createUserName) {

		Integer cityId = param.getCurrentCityId();
//		String rangeIds = param.getRangeIds();
//		Integer rangeType = param.getRangeType();
//		ErpFunUsers selfUser = erpFunUsersMapper.getFunUserByUserId(cityId, param.getCurrentUserId());
		newUser.setCityId(cityId.shortValue());
		newUser.setLoginUserid(newUser.getUserMobile());
		newUser.setLoginPassword(EnCodeHelper.MD5Encode(newUser.getLoginPassword()));
		newUser.setUpdateUid(param.getCurrentUserId());
		newUser.setShardCityId(cityId);
		//添加职级ID
		newUser.setRoleLevelId(param.getRoleLevelId());

		ErpFunUsers funUsers = this.createOrUpdateUserNew(newUser, param, createUserName);
		// zt组织机构待定
//		this.updateUserManageRange(funUsers.getUserId(), funUsers.getUserPosition(), rangeIds, rangeType, param, isFangJidi);
		// 初始化员工考勤，先初始化考勤地点
		List<ErpFunAttendanceScope> attendanceScopeList = erpFunAttendanceScopeMapper.getAttendanceScopeByCompIdDeptIdNew(cityId, param.getCurrentCompId(), funUsers.getOrganizationId());
		ErpFunAttendanceScope funAttendanceScope = null;
		if (attendanceScopeList != null && attendanceScopeList.size() > 0)
			funAttendanceScope = attendanceScopeList.get(0);
		if (null != funAttendanceScope) {
			ErpFunAttendanceScopeBizExample attendanceScopeBizExample = new ErpFunAttendanceScopeBizExample();
			attendanceScopeBizExample.setShardCityId(cityId);
			attendanceScopeBizExample.createCriteria().andAttScopeIdEqualTo(funAttendanceScope.getAttScopeId())
					.andCompIdEqualTo(param.getCurrentCompId()).andChooseTypeEqualTo(1).andIsDelEqualTo((byte) 0)
					.andBizIdEqualTo(funAttendanceScope.getOrganizationId());
			List<ErpFunAttendanceScopeBiz> attendanceScopeBizs = erpFunAttendanceScopeBizMapper.selectByExample(attendanceScopeBizExample);
			if (!attendanceScopeBizs.isEmpty() && attendanceScopeBizs.get(0) != null) {
				ErpFunAttendanceScopeBiz attendanceScopeBiz = attendanceScopeBizs.get(0);
				ErpFunAttendanceScopeBizPerson erpFunAttendanceScopeBizPerson = new ErpFunAttendanceScopeBizPerson();
				erpFunAttendanceScopeBizPerson.setShardCityId(cityId);
				erpFunAttendanceScopeBizPerson.setAttScopeId(funAttendanceScope.getAttScopeId());
				erpFunAttendanceScopeBizPerson.setCreateTime(new Date());
				erpFunAttendanceScopeBizPerson.setScopBizId(attendanceScopeBiz.getBizId());
				erpFunAttendanceScopeBizPerson.setUserId(funUsers.getUserId());
				erpFunAttendanceScopeBizPerson.setUserName(funUsers.getUserName());
				erpFunAttendanceScopeBizPersonMapper.insertSelective(erpFunAttendanceScopeBizPerson);
			}
		}

		// 初始化考勤组
		ErpFunAttendanceGroupBizExample attendanceGroupBizExample = new ErpFunAttendanceGroupBizExample();
		attendanceGroupBizExample.setShardCityId(cityId);
		attendanceGroupBizExample.createCriteria().andCompIdEqualTo(param.getCurrentCompId()).andChooseTypeEqualTo(1)
				.andBizIdEqualTo(funUsers.getOrganizationId()).andIsDelEqualTo((byte) 0);
		List<ErpFunAttendanceGroupBiz> erpFunAttendanceGroupBizs = erpFunAttendanceGroupBizMapper.selectByExample(attendanceGroupBizExample);
		if (erpFunAttendanceGroupBizs != null&& !erpFunAttendanceGroupBizs.isEmpty() && erpFunAttendanceGroupBizs.get(0) != null) {
			ErpFunAttendanceGroupBiz attendanceGroupBiz = erpFunAttendanceGroupBizs.get(0);
			ErpFunAttendanceGroupBizPerson erpFunAttendanceGroupBizPerson = new ErpFunAttendanceGroupBizPerson();
			erpFunAttendanceGroupBizPerson.setShardCityId(cityId);
			erpFunAttendanceGroupBizPerson.setAttGroupId(attendanceGroupBiz.getAttGroupId());
			erpFunAttendanceGroupBizPerson.setCreateTime(new Date());
			erpFunAttendanceGroupBizPerson.setGroupBizId(attendanceGroupBiz.getId());
			erpFunAttendanceGroupBizPerson.setUserId(funUsers.getUserId());
			erpFunAttendanceGroupBizPerson.setUserName(funUsers.getUserName());
			erpFunAttendanceGroupBizPersonMapper.insertSelective(erpFunAttendanceGroupBizPerson);
		}

		//detail [2020-05-25] yz  初始化kpi方案
		logger.info("-------------KPI经纪人信息----------------"+funUsers.getUserId() + "-----" +funUsers.getUserMobile() +"--------------"+funUsers.getUserName()+"----"+funUsers.getUserPosition());
		try {
			configureUserKPI(cityId, funUsers);
			//wirte log
			ErpFunPartnerLog log = new ErpFunPartnerLog();
			log.setShardCityId(cityId);
			log.setCompId(funUsers.getCompId());
			log.setCreateUid(param.getSelUid());
			log.setPartnerId(0);
			log.setModular((byte)0);
			log.setCreateTime(new Date());
			log.setLogContent(funUsers.getUserName() + " 配置kpi方案 userId = " + funUsers.getUserId());
			erpFunPartnerLogMapper.insertSelective(log);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return funUsers;
	}

	/**
	 * 经纪人配置kpi
	 * @param cityId
	 * @param funUsers
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void configureUserKPI(Integer cityId, ErpFunUsers funUsers) {
		logger.info("-------------KPI经纪人信息----------------"+funUsers.getUserId() + "-----" +funUsers.getUserMobile() +"--------------"+funUsers.getUserName()+"----"+funUsers.getUserPosition());
		//
		initKpiStatisticRecord(cityId, funUsers.getUserId());
		if (StringUtil.isBlank(funUsers.getUserPosition())) {
			return;
		}
		ErpKpiRoleAssociateConfigExample kre = new ErpKpiRoleAssociateConfigExample();
		kre.setShardCityId(cityId);
		kre.createCriteria().andCompIdEqualTo(funUsers.getCompId()).andRoleIdEqualTo(funUsers.getUserPosition()).andIsDelEqualTo(0);
		List<ErpKpiRoleAssociateConfig> roleAssociateConfigs = erpKpiRoleAssociateConfigMapper.selectByExample(kre);
		//初始化正在使用中的配置
		if (!roleAssociateConfigs.isEmpty()) {
			logger.info("初始化kpi中的配置:" + roleAssociateConfigs.get(0).getRoleId());
			ErpKpiUserAssociateConfigExample kue = new ErpKpiUserAssociateConfigExample();
			kue.setShardCityId(cityId);
			kue.createCriteria().andUserIdEqualTo(funUsers.getUserId()).andIsDelEqualTo(0);
			ErpKpiUserAssociateConfig updateModel = new ErpKpiUserAssociateConfig();
			updateModel.setShardCityId(cityId);
			updateModel.setIsDel(1);
			updateModel.setStatus(0);
			updateModel.setUpdateTime(new Date());
			erpKpiUserAssociateConfigMapper.updateByExampleSelective(updateModel, kue);
			//执行中的配置
			Optional<ErpKpiRoleAssociateConfig> inProgress = roleAssociateConfigs.stream().filter(obj -> Objects.equals(obj.getStatus(), 1)).findFirst();
			if (inProgress.isPresent()) {
				ErpKpiRoleAssociateConfig roleAssociateConfig = inProgress.get();
				logger.info("初始化 status=1 kpi中的配置:" + roleAssociateConfig.getRoleId());
				insertKpiConfig(cityId, funUsers, roleAssociateConfig);
			}
			//定时生效的配置
			Optional<ErpKpiRoleAssociateConfig> futureProgress = roleAssociateConfigs.stream().filter(obj -> Objects.equals(obj.getStatus(), 0)).findFirst();
			if (futureProgress.isPresent()) {
				ErpKpiRoleAssociateConfig roleAssociateConfig = futureProgress.get();
				logger.info("初始化 status=0 kpi中的配置:" + roleAssociateConfig.getRoleId());
				insertKpiConfig(cityId, funUsers, roleAssociateConfig);
			}
		}
		//是否是减半目标
		if (LocalDate.now().getDayOfMonth() > 15) {
			AdminFunArchive archive = adminFunArchiveMapper.getArchiveById(funUsers.getArchiveId());
			if (Objects.isNull(archive)) {
				return;
			}
			String idNo = archive.getUserIccode();
			String month = DateFormatUtils.format(new Date(),"yyyy-MM");
			int activeType = 1;
			Date createTime = new Date();
			if (StringUtil.isEmpty(idNo)) {
				idNo = funUsers.getUserId()+"";
			}
			erpKpiUserAssociateConfigMapper.insertHalfKPITarget(cityId, funUsers.getUserId(), idNo, month, activeType, createTime);
		}

	}
	
	public void configureUserKPIForPositionModify(Integer cityId, ErpFunUsers funUsers) {
		logger.info("-------------经纪人角色变更----------------"+funUsers.getUserId() + "-----" +funUsers.getUserMobile() +"--------------"+funUsers.getUserName()+"----"+funUsers.getUserPosition());
		ErpKpiRoleAssociateConfigExample kre = new ErpKpiRoleAssociateConfigExample();
		kre.setShardCityId(cityId);
		kre.createCriteria().andCompIdEqualTo(funUsers.getCompId()).andRoleIdEqualTo(funUsers.getUserPosition()).andIsDelEqualTo(0);
		List<ErpKpiRoleAssociateConfig> roleAssociateConfigs = erpKpiRoleAssociateConfigMapper.selectByExample(kre);
		//初始化正在使用中的配置
		if (!roleAssociateConfigs.isEmpty()) {
			//执行中的配置
			Optional<ErpKpiRoleAssociateConfig> inProgress = roleAssociateConfigs.stream().filter(obj -> Objects.equals(obj.getStatus(), 1)).findFirst();
			if (inProgress.isPresent()) {
				ErpKpiRoleAssociateConfig roleAssociateConfig = inProgress.get();
				logger.info("经纪人角色变更 初始化 status=1 kpi中的配置:" + roleAssociateConfig.getRoleId());
				insertKpiConfig(cityId, funUsers, roleAssociateConfig);
			}
			//定时生效的配置
			Optional<ErpKpiRoleAssociateConfig> futureProgress = roleAssociateConfigs.stream().filter(obj -> Objects.equals(obj.getStatus(), 0)).findFirst();
			if (futureProgress.isPresent()) {
				ErpKpiRoleAssociateConfig roleAssociateConfig = futureProgress.get();
				logger.info("经纪人角色变更 初始化 status=0 kpi中的配置:" + roleAssociateConfig.getRoleId());
				insertKpiConfig(cityId, funUsers, roleAssociateConfig);
			}
		}
	}

	/**
	 * 配置kpi执行方案
	 * @param cityId
	 * @param funUsers
	 * @param config
	 */
	private void insertKpiConfig(Integer cityId, ErpFunUsers funUsers, ErpKpiRoleAssociateConfig config) {
		ErpKpiUserAssociateConfig userAssociateConfig = new ErpKpiUserAssociateConfig();
		userAssociateConfig.setShardCityId(cityId);
		userAssociateConfig.setCityId(cityId);
		userAssociateConfig.setCompId(funUsers.getCompId());
		userAssociateConfig.setConfigId(config.getConfigId());
		userAssociateConfig.setIsDel(0);
		userAssociateConfig.setConfigType(config.getConfigType());
		userAssociateConfig.setUserId(funUsers.getUserId());
		userAssociateConfig.setStatus(config.getStatus());
		userAssociateConfig.setUpdateTime(new Date());
		erpKpiUserAssociateConfigMapper.notExistThenInsert(cityId,userAssociateConfig);
	}

	@Override
	public void initKpiStatisticRecord(Integer cityId,Integer userId) {
		LocalDate now = LocalDate.now();
		LocalDate with = now.with(TemporalAdjusters.firstDayOfMonth());
		Instant start = with.atStartOfDay(ZoneId.systemDefault()).toInstant();
		Date monthStart = Date.from(start);
		Date currentDayStart = Date.from(now.atStartOfDay(ZoneId.systemDefault()).toInstant());
		erpKpiUserAssociateConfigMapper.initKpiStatisticRecord(cityId, userId, currentDayStart, monthStart);
	}

	/**
	 * 失效某个经纪人kpi配置方案
	 * @param cityId
	 * @param userId
	 */
	@Override
	public void invalidOriginKpiConfig(Integer cityId, Integer userId){
		//失效原配置
		erpKpiUserAssociateConfigMapper.invalidConfig(cityId, userId, new Date());
	}

	@Transactional
	@Override
	public Map<String,Object> createInvitedUser(BrokerShareRegisterParam param) {
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByMobile(param.getUserMobile());
		ErpFunDepts funDepts = erpFunDeptsMapper.getByDeptId(cityId, param.getDeptId());
		String compNo = funDepts.getCompNo();
		if(StringUtils.isBlank(param.getServiceReg()) || StringUtils.isBlank(param.getServiceZoneIds())) {
			throw new BusinessException("请选择服务范围");
		}
		// 验证安全，别公司在职人员不能邀请
		if (null != adminFunArchive && 2 != adminFunArchive.getUserEdition()) {
			throw new BusinessException("该电话已经注册门店版，请更换号码！");
		}
		// 首先查询下待验证列表
		ErpFunUsersInvitedExample example = new ErpFunUsersInvitedExample();
		example.setShardCityId(cityId);
		example.createCriteria().andUserMobileEqualTo(param.getUserMobile()).andCompIdEqualTo(compId).andCompNoEqualTo(compNo).andCityIdEqualTo(cityId).andInviteStatusEqualTo((byte) 0);
		List<ErpFunUsersInvited> resList = erpFunUsersInvitedMapper.selectByExample(example);
		if(null != resList && resList.size() > 0) {
			ErpFunUsersInvited erpFunUsersInvited = resList.get(0);
			ErpFunUsersInvited updatePo = new ErpFunUsersInvited();
			updatePo.setShardCityId(cityId);
			updatePo.setId(erpFunUsersInvited.getId());
			updatePo.setUpdateTime(new Date());
			updatePo.setInviteStatus((byte) 2);
			erpFunUsersInvitedMapper.updateByPrimaryKeySelective(updatePo);
		}
		ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, param.getInviteId());
		ErpFunUsersInvited newInvitedUser = new ErpFunUsersInvited();
		if (erpFunUsers.getAreaId() == null) {
			erpFunUsers.setAreaId(funDepts.getAreaId());
		}

		if (null != param.getOrganizationId()) {
			ErpFunOrganizationExample erpFunOrganizationExample = new ErpFunOrganizationExample();
			erpFunOrganizationExample.setShardCityId(cityId);
			erpFunOrganizationExample.createCriteria().andOrganizationIdEqualTo(param.getOrganizationId());
			List<ErpFunOrganization> erpFunOrganizationList = erpFunOrganizationMapper.selectByExample(erpFunOrganizationExample);
			if (!erpFunOrganizationList.isEmpty()) {
				param.setOrganizationPath(erpFunOrganizationList.get(0).getOrganizationPath());
			}
		}

		//获取该公司职级最低的角色
		String roleId = erpCompRolesMapper.getLowRole(cityId, compId);
		newInvitedUser.setAreaId(erpFunUsers.getAreaId());
		newInvitedUser.setRegId(erpFunUsers.getRegId());
		newInvitedUser.setCityId(cityId);
		newInvitedUser.setCompId(compId);
		newInvitedUser.setCompNo(compNo);
		newInvitedUser.setDeptId(param.getDeptId());
		newInvitedUser.setGrId(null == erpFunUsers.getGrId() ? 0 : erpFunUsers.getGrId());
		newInvitedUser.setInviteStatus((byte) 0);
		newInvitedUser.setServiceReg(param.getServiceReg());
		newInvitedUser.setServiceZone(param.getServiceZone());
		newInvitedUser.setUserMobile(param.getUserMobile());
		newInvitedUser.setServiceZoneIds(param.getServiceZoneIds());
		newInvitedUser.setUserPosition(roleId);
		newInvitedUser.setUserSex(param.getUserSex());
		newInvitedUser.setShardCityId(cityId);
		newInvitedUser.setCreateTime(new Date());
		newInvitedUser.setUserName(param.getUserName());
		newInvitedUser.setCreateUid(param.getInviteId());
		newInvitedUser.setCurrentPId(param.getInviteId());
		newInvitedUser.setOrganizationId(param.getOrganizationId());
		newInvitedUser.setOrganizationPath(param.getOrganizationPath());
		erpFunUsersInvitedMapper.insertSelective(newInvitedUser);
		//维护门店经纪人数量 INCUMBENCY_NUMBER
		Integer deptId = param.getDeptId();
		ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(cityId, deptId);
		AdminFunDepts adminFunDepts = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(erpFunDepts.getCompNo(), erpFunDepts.getDeptNo());
		adminFunDeptsMapper.updateIncumbencyNumberByDeptId(adminFunDepts.getDeptId(), 1);
		//----
		AdminFunCity adminFunCity = adminFunCityMapper.getDataByCityId(cityId);
		AdminFunArchive funArchive = adminFunArchiveMapper.selectLastArchive(erpFunUsers.getArchiveId());

		// 调新增员工接口
		CreateUserParam addParam = new CreateUserParam();
		addParam.setCurrentCityId(cityId);
		addParam.setCurrentCompId(compId);
		addParam.setCurrentUserId(erpFunUsers.getUserId());
		addParam.setServiceReg(param.getServiceReg());
		addParam.setServiceZone(param.getServiceZone());
		addParam.setServiceZoneIds(param.getServiceZoneIds());

		AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(compNo);
		addParam.setCurrentCompType(adminFunComp.getCompType().intValue());
		addParam.setCurrentDeptId(newInvitedUser.getDeptId());
		addParam.setCurrentUserEdition(erpFunUsers.getUserEdition());
		addParam.setProvinceId(adminFunCity.getProvinceId().intValue());
		addParam.setSelUid(funArchive.getSellId());
		addParam.setPerLogin(false);
		addParam.setCompType(adminFunComp.getCompType().intValue());
		addParam.setOrganizationId(param.getOrganizationId());
		String organizationType = erpSysParaMapper.getParamValue(cityId, compId, "ORGANIZATION_TYPE");// 1=开启无限组织机构
		addParam.setOrganizationType(organizationType);
		addParam.setTissueLine(param.getOrganizationPath());

		// 根据电话查询
		AdminFunArchive addArchive = adminFunArchiveMapper.selectByMobile(param.getUserMobile());
		ErpFunUsers newUser = new ErpFunUsers();
		if(null != addArchive) {
			if(2 != addArchive.getUserEdition()) {
				throw new BusinessException("操作失败，您已加入门店了");
			}
			newUser = erpFunUsersMapper.selectByArchiveId(addArchive.getArchiveId());
		}

		if(null == newUser) {
			newUser = new ErpFunUsers();
		}
//        		ErpFunUsers newUser = getParamObj(ErpFunUsers.class);
		newUser.setCompId(compId);
		newUser.setCityId(cityId.shortValue());
		newUser.setUserName(newInvitedUser.getUserName());
		newUser.setGrId(newInvitedUser.getGrId());
		newUser.setAreaId(newInvitedUser.getAreaId());


		// 检查大区是否删除
		if(null != newInvitedUser.getRegId()) {
			ErpFunRegion dataById = erpFunRegionMapper.getDataById(cityId, newInvitedUser.getRegId());
			if(null != dataById && 0 == dataById.getIsDel()) {
				newUser.setRegId(newInvitedUser.getRegId());
			}else {
				// 查找一个默认大区
				List<ErpFunRegion> cacheableRegionListByAreaId = erpFunRegionMapper.getCacheableRegionListByAreaId(cityId, compId);
				if(cacheableRegionListByAreaId.size() > 0) {
					newUser.setRegId(cacheableRegionListByAreaId.get(0).getRegId());
				}
			}
		}

		newUser.setCompId(newInvitedUser.getCompId());
		newUser.setDeptId(newInvitedUser.getDeptId());
		newUser.setUserMobile(newInvitedUser.getUserMobile());
		newUser.setUserStatus((byte) 1);

		// 检查下管理范围是否失效
		addParam.setUserPosition(newInvitedUser.getUserPosition());
		newUser.setUserPosition(newInvitedUser.getUserPosition());
		newUser.setLoginPassword(param.getPassword());
		newUser.setUserSex(null != newInvitedUser.getUserSex() && 1 == newInvitedUser.getUserSex());
		inviteRegistController.validateManageRange(cityId, compId, newInvitedUser.getRangeType(), newInvitedUser.getRangeIds(), addParam);
		if (adminFunComp.getCompType() == Const.DIC_COMP_TYPE_5.intValue()) {
			if (Const.DIC_ROLE_NAME_BRANCH_MANAGER.equals(newInvitedUser.getUserPosition())) {
				addParam.setRangeIds(newInvitedUser.getDeptId() + "");
				addParam.setRangeType(4);
			}
		}
		//添加职级ID
		addParam.setRoleLevelId(newInvitedUser.getRoleLevelId());
        //----房基地二期修改，需要添加一个页面，但是如果后面的程序出了未知错误，这个请求的无法回滚，就先创建成注销的账号，在后面的接口成功后再修改为未注销   2019年9月24日
        newUser.setUserWriteoff(true);
        newUser.setWriteoffType((byte) 1);
        boolean isFangJidi = this.judgerIsFangjidi(adminFunComp.getCompId());
		ErpFunUsers createUser = erpFunUsersService.createUser(newUser, addParam, param.getInviteId(), isFangJidi);

		Map<String, Object> userInfo = new HashMap<>();
		userInfo.put("cityId", createUser.getCityId());
		userInfo.put("compId", createUser.getCompId());
		userInfo.put("archiveId", createUser.getArchiveId());
		userInfo.put("deptId", createUser.getDeptId());
		httpRequestTask.postToMobileWeb("approveOpenApi/yxTeam/newEmp", userInfo);

		// 删除带邀请
		ErpFunUsersInvited updateFunUserInvited = new ErpFunUsersInvited();
		updateFunUserInvited.setUpdateTime(new Date());
		updateFunUserInvited.setInviteStatus((byte) 2);
		ErpFunUsersInvitedExample updateExample = new ErpFunUsersInvitedExample();
		updateExample.setShardCityId(cityId);
		updateExample.createCriteria().andUserMobileEqualTo(newInvitedUser.getUserMobile());
		erpFunUsersInvitedMapper.updateByExampleSelective(updateFunUserInvited, updateExample);
		Map<String,Object> map = new HashMap<>();
		map.put("userId",createUser.getUserId());
		map.put("cityId", createUser.getCityId());
		map.put("compId",createUser.getCompId());
		map.put("deptId",createUser.getDeptId());
		map.put("archiveId", createUser.getArchiveId());
		map.put("compType",adminFunComp.getCompType());
		map.put("inviteId",param.getInviteId());
		return map;
	}

	public boolean judgerIsFangjidi(Integer adminCompId) {
		boolean isHouseBase = false;
		if (null != adminCompId) {
			AdminFunComp adminFunComp = adminFunCompMapper.selectByPrimaryKey(adminCompId);
			if (null != adminFunComp) {
				if (Byte.valueOf("2").equals(adminFunComp.getCompManagementModel()) && Integer.valueOf(1).equals(adminFunComp.getCustomizedType())) {
					isHouseBase = true;
				}
			}
		}
		return isHouseBase;
	}

	/**
	 * 发送审核信息
	 * @param funUsers
	 */
	@Override
	public void sendRegistrationAuditMsg(ErpFunUsers funUsers,Integer currentPId,Integer cityId){
		if(currentPId !=null){

			ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, currentPId);
			erpFunUsers.setShardCityId(erpFunUsers.getCityId().intValue());
			erpFunUsers.setUserTeamNumber(erpFunUsers.getUserTeamNumber() + 1);//邀请人团队人数
			erpFunUsersMapper.updateByPrimaryKey(erpFunUsers);

			String recommendName = "";
			if(erpFunUsers == null){
				return ;
			}
			recommendName = erpFunUsers.getUserName();
			//设置层级
			Integer userLevel = erpFunUsers.getUserLevel();
			String 	tissueLine = erpFunUsers.getTissueLine();
			tissueLine = tissueLine +":"+funUsers.getUserId()+":";

			ErpFunUsers updateErpFunUsers = new ErpFunUsers();
			updateErpFunUsers.setUserId(funUsers.getUserId());
			updateErpFunUsers.setShardCityId(funUsers.getCityId().intValue());
			updateErpFunUsers.setUserLevel(userLevel+1);//用户层级
			updateErpFunUsers.setInviteUserId(erpFunUsers.getUserId());//邀请人
			updateErpFunUsers.setCurrentPId(erpFunUsers.getUserId()); //上级团队
			updateErpFunUsers.setTissueLine(tissueLine);//组织线

			//判断是否需要考核
			String roleId = funUsers.getUserPosition();
			Integer dayNum = 31;
			ErpSysPara erpSysParaNew = erpSysParaService.getMLSysParamByUserType(cityId, funUsers.getCompId(), funUsers.getUserId(), "NEW_USER_WAGE_ASSESSMENT");
			if(erpSysParaNew != null && StringUtil.isNotEmpty(erpSysParaNew.getParamValue())){
				dayNum = StringUtil.parseInteger(erpSysParaNew.getParamValue());
			}
			Integer nowDay = DateUtil.getDay(new Date());
			ErpZxRoleConfig erpZxRoleConfig =  erpZxRoleConfigMapper.getCompRoleCofig(cityId,funUsers.getCompId(),roleId);
            if (erpZxRoleConfig != null && "1".equals(erpZxRoleConfig.getdOpernFalg().toString())) {
                updateErpFunUsers.setdAssessmentFlag((byte) 1);
                //需要考核
                if (dayNum > nowDay) {
                    updateErpFunUsers.setdAssessmentTime(DateUtil.StringToDate(DateUtil.getFirstDateOfMonth(), "yyyy-MM-dd"));
                } else {
                    updateErpFunUsers.setdAssessmentTime(DateUtil.StringToDate(DateUtil.getFirstDateOfNextMonth(), "yyyy-MM-dd"));
                }
            }
            erpFunUsersMapper.updateByPrimaryKeySelective(updateErpFunUsers);


//            ErpSysParaKey erpSysParaKey = new ErpSysParaKey();
//			erpSysParaKey.setShardCityId(cityId);
//			erpSysParaKey.setCompId(funUsers.getCompId());
//			erpSysParaKey.setParamId("INVITE_AUDIT_FLAG");
//			ErpSysPara erpSysPara = erpSysParaMapper.selectByPrimaryKey(erpSysParaKey);
			ErpSysPara erpSysPara = erpSysParaMapper.getValueById(cityId, funUsers.getCompId(), "INVITE_AUDIT_FLAG");

			ErpInviteUserLog erpInviteUserLog = new ErpInviteUserLog();
			erpInviteUserLog.setShardCityId(cityId);
			erpInviteUserLog.setCompId(funUsers.getCompId());
			erpInviteUserLog.setInviteUserId(currentPId);
			erpInviteUserLog.setInviteTime(new Date());
			erpInviteUserLog.setCreateTime(new Date());
			erpInviteUserLog.setInvitedUserId(funUsers.getUserId());
			erpInviteUserLog.setInvitedUserName(funUsers.getUserName());
			erpInviteUserLog.setInvitedUserMobile(funUsers.getUserMobile());
			if(erpSysPara !=null && "1".equals(erpSysPara.getParamValue())){
				erpInviteUserLog.setAuditFlag((byte)1);
			}
			erpInviteUserLogMapper.insertSelective(erpInviteUserLog);

			Set<Integer> archiveIds = new HashSet<Integer>();

			//查询当前分组拥有审核权的人
			if(funUsers.getGrId() > 0){
				List<Integer> archiveIdGr =  erpFunUsersMapper.getAuditGroupList(funUsers.getCityId().intValue(),funUsers.getCompId(),funUsers.getGrId(),"AUDIT_GROUP_REGISTRATION");
				if(archiveIdGr !=null && archiveIdGr.size() > 0){
					archiveIds.addAll(archiveIdGr);
				}
			}
			//门店
			if(funUsers.getDeptId() > 0){
				List<Integer> archiveIdDp =  erpFunUsersMapper.getAuditDeptList(funUsers.getCityId().intValue(),funUsers.getCompId(),funUsers.getDeptId(),"AUDIT_DEPT_REGISTRATION");
				if(archiveIdDp !=null && archiveIdDp.size() > 0){
					archiveIds.addAll(archiveIdDp);
				}
			}
			//片区
			if(funUsers.getRegId() > 0){
				List<Integer> archiveIdRg =  erpFunUsersMapper.getAuditRegList(funUsers.getCityId().intValue(),funUsers.getCompId(),funUsers.getRegId(),"AUDIT_REG_REGISTRATION");
				if(archiveIdRg !=null && archiveIdRg.size() > 0){
					archiveIds.addAll(archiveIdRg);
				}
			}
			//大区
			if(funUsers.getArchiveId() > 0){
				List<Integer> archiveIdAr =  erpFunUsersMapper.getAuditAreaList(funUsers.getCityId().intValue(),funUsers.getCompId(),funUsers.getAreaId(),"AUDIT_AREA_REGISTRATION");
				if(archiveIdAr !=null && archiveIdAr.size() > 0){
					archiveIds.addAll(archiveIdAr);
				}
			}
			//公司
			if(funUsers.getCompId() > 0){
				List<Integer> archiveIdCp =  erpFunUsersMapper.getAuditCompList(funUsers.getCityId().intValue(),funUsers.getCompId(),"AUDIT_COMP_REGISTRATION");
				if(archiveIdCp !=null && archiveIdCp.size() > 0){
					archiveIds.addAll(archiveIdCp);
				}
			}

			if(archiveIds !=null && archiveIds.size() >0){
				String content= recommendName+"推荐"+funUsers.getUserName()+"加入了团队";
				if(erpSysPara !=null && "1".equals(erpSysPara.getParamValue())){
					content = funUsers.getUserName()+"申请加入团队，请尽快审核";
				}
				for (Integer archiveId : archiveIds) {
					Map<String,Object> param = new HashMap<String,Object>();
			    	param.put("templateId", "118");
			    	param.put("receiver", archiveId);
			    	param.put("userName", funUsers.getUserName());
			    	param.put("recommendName",recommendName);
			    	param.put("content", content);
			    	param.put("userId",funUsers.getUserId());
			    	param.put("recommendId",erpFunUsers.getUserId());

			    	Map<String,String> paramData = new HashMap<String,String>();
			    	paramData.put("paramExt", JSONObject.toJSONString(param));
			    	HttpUtil.postJson(AppConfig.getPushWebDomain()+"/systemApi/im/send/kafka/pushMsg",JSONObject.toJSONString(paramData));
				}
			}
		}else{
			ErpFunUsers erpFunUsers = new ErpFunUsers();
			erpFunUsers.setCityId(funUsers.getCityId());
			erpFunUsers.setShardCityId(funUsers.getCityId().intValue());
			erpFunUsers.setUserId(funUsers.getUserId());
			erpFunUsers.setUserLevel(1);
			erpFunUsers.setTissueLine(":"+funUsers.getUserId()+":");
			erpFunUsersMapper.updateByPrimaryKeySelective(erpFunUsers);
		}
	}

	/**
	 * @tag 组织机构-用户创建或关联门店
	 * @author 邓永洪
	 * @since 2018/5/25
	 */
	private ErpFunUsers createOrUpdateUser(ErpFunUsers user, CreateUserParam param) {
		Integer cityId = param.getCurrentCityId();
		String userPosition = user.getUserPosition();
		boolean judgeBranchManager = erpUserOpersService.judgeBranchManager(cityId, param.getCurrentCompId(), param.getCurrentDeptId(), param.getCurrentCompType(), user.getDeptId());
		if (Const.DIC_ROLE_NAME_BRANCH_MANAGER.equals(userPosition) && !judgeBranchManager) {
			throw new BusinessException("你是赢销版用户，1个门店最多只能创建3个分行经理账号！");
		}
		ErpCompRoles compRoles = erpCompRolesMapper.getCompRoleByUserEdition(cityId, userPosition, param.getCurrentCompId());
		if (compRoles != null && compRoles.getIsDel() == 1) {
			throw new BusinessException("该角色已删除，请重新选择！");
		}
		//一个公司只能配置一个管理员角色
		if ("COMMON_ADMIN".equals(userPosition)) {
			ErpFunUsersExample usersExample = new ErpFunUsersExample();
			usersExample.setShardCityId(cityId);
			usersExample.createCriteria().andCompIdEqualTo(param.getCurrentCompId()).andUserPositionEqualTo("COMMON_ADMIN").andUserWriteoffEqualTo(false);
			int adminRoleCount = erpFunUsersMapper.countByExample(usersExample);
			if (adminRoleCount > 0) {
				throw new BusinessException("一个公司只能配置一个管理员");
			}
		}
        String userJobDate = param.getUserJobDate();
        if (userJobDate == null) {
            user.setUserJobDate(userJobDate);
        }
		// 创建用户和加入门店时分组ID默认为0，在门店版中认为是未分组
		if (user.getGrId() == null) {
			user.setGrId(Const.DIC_DEFAULT_GROUP_ID);
		}
		Integer compType = param.getCurrentCompType();
		int userEdition;
		if (compType.equals(Const.DIC_COMP_TYPE_1) || compType.equals(Const.DIC_COMP_TYPE_4) || compType.equals(Const.DIC_COMP_TYPE_5)
				|| compType.equals(Const.DIC_COMP_TYPE_6) || compType.equals(Const.DIC_COMP_TYPE_7) ) {
			userEdition = 0;
		} else if (compType.equals(Const.DIC_COMP_TYPE_2)) {
			userEdition = 1;
		} else if (compType.equals(Const.DIC_COMP_TYPE_3)) {
			userEdition = -1;
		} else {
			userEdition = 2;
		}
		if (userEdition != param.getCurrentUserEdition()) {
			throw new BusinessException("数据有误，软件版本类型不匹配，请联系你的销售顾问！");
		}
		user.setUpdateTime(DateTimeHelper.getTimeNow());
		user.setUserEdition(userEdition);
		user.setAlldeptFlag(false);// 新建用户时默认都不能跨店登录
		AdminFunArchive funArchive = adminFunArchiveService.createOrUpdateByErpCreateUser(cityId, param.getServiceReg(),
				param.getServiceZone(), param.getServiceZoneIds(), user, param.getProvinceId(), param.getSelUid(), (byte) 3);
		if (null == user.getStatusTime()) {
			user.setStatusTime(DateTimeHelper.getTimeNow());
		}
		user.setCityId(param.getCurrentCityId().shortValue());

		// 判断数量
		checkDeptUserNum(param.getCurrentCityId(), user.getDeptId(),false, userPosition);

		ErpFunDepts funDeptsTmp = erpFunDeptsMapper.getByDeptId(cityId, user.getDeptId());

		//物业版操作
		//1.公司创建时，总经理默认为项目管理员，所在门店增加了项目经理后，项目管理员若为总经理自动更换为项目经理
		//
		//2.加店时，所在门店第一个人默认为项目管理员
		if (Objects.equals(5, param.getCompType())) {
			Integer userCount = erpFunUsersMapper.count(cityId, user.getDeptId());
			if (Objects.equals(0, userCount)) {
				user.setPropertyManager((byte) 1);

				ErpFunDepts funDepts = erpFunDeptsMapper.getByDeptId(cityId, user.getDeptId());
				AdminFunDepts adminFunDepts = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(funDepts.getCompNo(), funDepts.getDeptNo());
				Integer archiveId = funArchive.getArchiveId();
				AdminPropertyDuildMap propertyDuildMap = new AdminPropertyDuildMap();
				propertyDuildMap.setDeptId(adminFunDepts.getDeptId());
				propertyDuildMap.setArchiveId(archiveId);
				adminPropertyDuildMapMapper.updateByPrimaryKeySelective(propertyDuildMap);
			} else {
				ErpFunUsers generaUser = erpFunUsersMapper.getGeneralUser(cityId, user.getCompId());
				int branchCount = erpFunUsersMapper.countByRoleId(cityId, user.getCompId(), user.getDeptId(), "BRANCH_MANAGER");
				if (Objects.equals(user.getDeptId(), generaUser.getDeptId()) &&
						Objects.equals("BRANCH_MANAGER", user.getUserPosition()) && branchCount == 0) {
					user.setPropertyManager((byte) 1);
					ErpFunUsers generaUserUpdate = new ErpFunUsers();
					generaUserUpdate.setShardCityId(user.getCityId().intValue());
					generaUserUpdate.setPropertyManager((byte) 0);
					generaUserUpdate.setUserId(generaUser.getUserId());
					erpFunUsersMapper.updateByPrimaryKeySelective(generaUserUpdate);

					ErpFunDepts funDepts = erpFunDeptsMapper.getByDeptId(cityId, user.getDeptId());
					AdminFunDepts adminFunDepts = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(funDepts.getCompNo(), funDepts.getDeptNo());
					Integer archiveId = funArchive.getArchiveId();
					AdminPropertyDuildMap propertyDuildMap = new AdminPropertyDuildMap();
					propertyDuildMap.setDeptId(adminFunDepts.getDeptId());
					propertyDuildMap.setArchiveId(archiveId);
					adminPropertyDuildMapMapper.updateByPrimaryKeySelective(propertyDuildMap);
				}
			}
		}

		// 获取无限组织架构下的组织的加盟商id
		Integer partnerId = this.getPartnerIdByOrgOrDept(cityId, param, funDeptsTmp);

		if (user.getUserId() == null) {// 注册
			user.setArchiveId(funArchive.getArchiveId());
			Integer userId = erpFunUsersMapper.selectSeqUserId(cityId);
			user.setUserId(userId);
			user.setJoinDeptTime(new Date());
			user.setUserNo(generateUserNo(cityId, userId));
			user.setCreationTime(new Date());
			user.setShardCityId(cityId);
			user.setPartnerId(partnerId);
			user.setTissueLine(param.getTissueLine());
			erpFunUsersMapper.insertSelective(user);
			// 新建资金账户
			adminFunUserAccountService.createByCreateUser(user);
			// 新建积分记录
			adminFunUsersCountService.createBycreateArchiveId(funArchive.getArchiveId());
			// 用户首次注册后,自动关注小区和新盘顾问
			Map<String, Object> userInfo = new HashMap<>();
			userInfo.put("archiveId", funArchive.getArchiveId());
			httpRequestTask.postToMobileWeb("approveOpenApi/mobileBiz/autoAttentionBuildBiddInfo", userInfo);
		} else {
			// 关联门店操作
//			user.setLoginPassword(null);
			user.setLoginUserid(null);
			user.setJoinDeptTime(new Date());
			user.setCompId(param.getCurrentCompId());
			user.setUpdateTime(DateUtil.DateToString(new Date()));
			user.setPartnerId(partnerId);
			user.setTissueLine(param.getTissueLine());
			erpFunUsersMapper.updateByPrimaryKeySelective(user);
			// 修改fun_archive的用户版本信息
			adminFunArchiveMapper.updateUserEdition(userEdition + "", new String[] { user.getArchiveId() + "" });
			// TODO 精英版加入门店房源标号重新生成
		}
		//维护门店经纪人数量 INCUMBENCY_NUMBER
		ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(cityId, user.getDeptId());
		AdminFunDepts adminFunDepts = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(erpFunDepts.getCompNo(), erpFunDepts.getDeptNo());
		adminFunDeptsMapper.updateIncumbencyNumberByDeptId(adminFunDepts.getDeptId(), 1);
		// 处理经纪人薪资关联
		this.initWageData(user, 1);
		ErpFunWorkcountTarget erpFunWorkcountTarget = new ErpFunWorkcountTarget();
		erpFunWorkcountTarget.setShardCityId(cityId);
		erpFunWorkcountTarget.setCompId(user.getCompId());
		erpFunWorkcountTarget.setTargetType((byte)1);
		erpFunWorkcountTarget.setUserId(user.getUserId());
		erpFunWorkcountTarget.setArchiveId(user.getArchiveId());
		erpFunWorkcountTarget.setCreateTime(new Date());
		erpFunWorkcountTargetMapper.insertSelective(erpFunWorkcountTarget);
		erpFunWorkcountTarget.setTargetType((byte)2);
		erpFunWorkcountTarget.setId(null);
		erpFunWorkcountTarget.setShardCityId(cityId);
		erpFunWorkcountTargetMapper.insertSelective(erpFunWorkcountTarget);
		erpFunWorkcountTarget.setTargetType((byte)3);
		erpFunWorkcountTarget.setId(null);
		erpFunWorkcountTarget.setShardCityId(cityId);
		erpFunWorkcountTargetMapper.insertSelective(erpFunWorkcountTarget);

		erpFunEmployeeDocService.updateOrCreateEmployeeDoc(cityId, user);
		ErpFunDepts funDepts = erpFunDeptsMapper.getByDeptId(cityId, user.getDeptId());
		String trackCotent = "加入门店:" + funDepts.getDeptName() + "  职位:" + compRoles.getRoleName();
		// 1=入职 2=组织调动 3 = 权限修改 4=角色调动 5=离职
		erpFunEmployeeLogService.insertLog(cityId, param.getCurrentCompId(), (byte) 1, trackCotent, user.getArchiveId(),
				param.getCurrentUserId(), null, user.getDeptId(), null, compRoles.getRoleId(), null, user.getGrId());
		// 记录经纪人跟进
		adminCrmBrokerTrackService.createRegisterTrack(user.getArchiveId(), trackCotent, "[用户注册]");
		// 写用户基本权限表
		erpUserOpersService.insertUserOpersByCreateUser(user, param.getCurrentCompType().byteValue());
		adminFunErpUserGuideService.insertUserSeniorGuide(user.getUserId(), user.getArchiveId());

		this.evictBaseInfoByCompId(cityId, funDepts.getCompId());
		this.endLoginUser(funArchive.getArchiveId(), funArchive.getUserMobile(), LogInEnum.DEPT_CHANGE);
		return user;
	}

	/**
	*  新版组织机构创建员工账号
	* @author zangtie
	* @since 2019/12/9 11:43
	* @return
	**/
	private ErpFunUsers createOrUpdateUserNew(ErpFunUsers user, CreateUserParam param, String createUserName) {

		Integer cityId = param.getCurrentCityId();
		String userPosition = user.getUserPosition();
		ErpCompRoles compRoles = erpCompRolesMapper.getCompRoleByUserEdition(cityId, userPosition, param.getCurrentCompId());
		if (compRoles != null && compRoles.getIsDel() == 1) {
			throw new BusinessException("该角色已删除，请重新选择！");
		}
		//一个公司只能配置一个管理员角色
		if ("COMMON_ADMIN".equals(userPosition)) {
			ErpFunUsersExample usersExample = new ErpFunUsersExample();
			usersExample.setShardCityId(cityId);
			usersExample.createCriteria().andCompIdEqualTo(param.getCurrentCompId()).andUserPositionEqualTo("COMMON_ADMIN").andUserWriteoffEqualTo(false);
			int adminRoleCount = erpFunUsersMapper.countByExample(usersExample);
			if (adminRoleCount > 0) {
				throw new BusinessException("一个公司只能配置一个管理员");
			}
		}

		String userJobDate = param.getUserJobDate();
		if (StringUtil.isNotBlank(userJobDate)) {
			user.setUserJobDate(userJobDate);
		}

		Integer compType = param.getCurrentCompType();
		int userEdition;
		if (compType.equals(Const.DIC_COMP_TYPE_1) || compType.equals(Const.DIC_COMP_TYPE_4) || compType.equals(Const.DIC_COMP_TYPE_5)
				|| compType.equals(Const.DIC_COMP_TYPE_6) || compType.equals(Const.DIC_COMP_TYPE_7) ) {
			userEdition = 0;
		} else if (compType.equals(Const.DIC_COMP_TYPE_2)) {
			userEdition = 1;
		} else if (compType.equals(Const.DIC_COMP_TYPE_3)) {
			userEdition = -1;
		} else {
			userEdition = 2;
		}

		if (userEdition != param.getCurrentUserEdition()) {
			throw new BusinessException("数据有误，软件版本类型不匹配，请联系你的销售顾问！");
		}
		user.setUpdateTime(DateTimeHelper.getTimeNow());
		user.setUserEdition(userEdition);
		user.setAlldeptFlag(false);// 新建用户时默认都不能跨店登录
		AdminFunArchive funArchive = adminFunArchiveService.createOrUpdateByErpCreateUserNew(cityId, param.getServiceReg(),
				param.getServiceZone(), param.getServiceZoneIds(), user, param.getProvinceId(), param.getSelUid(), (byte) 3);
		if (null == user.getStatusTime()) {
			user.setStatusTime(DateTimeHelper.getTimeNow());
		}
		user.setCityId(param.getCurrentCityId().shortValue());

		// 获取无限组织架构下的组织的加盟商id
		Integer partnerId = this.getPartnerIdByOrgOrDept(cityId, param, null);

		//处理DEPT_ID  可能有多个一级组织 存对应的一级组织的orgId
		String[] split = user.getTissueLine().split(":");
		user.setDeptId(Integer.valueOf(split[1]));// 第一个是空支付串 第二个就是

		if (user.getUserId() == null) {// 注册
			user.setArchiveId(funArchive.getArchiveId());
			Integer userId = erpFunUsersMapper.selectSeqUserId(cityId);
			user.setUserId(userId);
			user.setJoinDeptTime(new Date());

			if(StringUtils.isBlank(user.getUserNo())) {
				user.setUserNo(generateUserNo(cityId, userId));
			}

			user.setCreationTime(new Date());
			user.setShardCityId(cityId);
			user.setPartnerId(partnerId);
			if(StringUtils.isBlank(user.getUserJobDate())) {
				user.setUserJobDate(DateUtil.getDate(new Date()));
			}
			erpFunUsersMapper.insertSelective(user);
			erpFunOrganizationService.updateBelongOrgUserCount(user.getCityId().intValue(), user.getCompId(),user.getOrganizationId(),1);
			// 新建资金账户
			adminFunUserAccountService.createByCreateUser(user);
			// 新建积分记录
			adminFunUsersCountService.createBycreateArchiveId(funArchive.getArchiveId());
			// 用户首次注册后,自动关注小区和新盘顾问
			Map<String, Object> userInfo = new HashMap<>();
			userInfo.put("archiveId", funArchive.getArchiveId());
			httpRequestTask.postToMobileWeb("approveOpenApi/mobileBiz/autoAttentionBuildBiddInfo", userInfo);
		} else {
			// 关联门店操作
//			user.setLoginPassword(null);
			user.setLoginUserid(null);
			user.setJoinDeptTime(new Date());
			user.setCompId(param.getCurrentCompId());
			user.setUpdateTime(DateUtil.DateToString(new Date()));
			user.setPartnerId(partnerId);
			erpFunUsersMapper.updateByPrimaryKeySelective(user);
			// 修改fun_archive的用户版本信息
			adminFunArchiveMapper.updateUserEdition(userEdition + "", new String[] { user.getArchiveId() + "" });
			// TODO 精英版加入门店房源标号重新生成
		}
		//**********************组织架构改版********************************
		//zt组织机构
		String updateSql = erpFunOrganizationService.createUpdateSql(user.getCityId().intValue(), user.getCompId(), user.getTissueLine());
		// 更新FUN_USERS表上的ORG_1到ORG_14的值
		erpFunUsersMapper.updateOrg1To14ByTissueLine(user.getCityId().intValue(),user.getUserId(),updateSql);
		// 更新组织机构上的人数
		// 通过organizationId设置新的管理范围ID
//		String validResult = this.validateManageRangeNew(cityId, compId, addParam);

		//**********************组织架构改版********************************


		// 处理经纪人薪资关联
		this.initWageDataNew(user, 1);
		ErpFunWorkcountTarget erpFunWorkcountTarget = new ErpFunWorkcountTarget();
		erpFunWorkcountTarget.setShardCityId(cityId);
		erpFunWorkcountTarget.setCompId(user.getCompId());
		erpFunWorkcountTarget.setTargetType((byte)1);
		erpFunWorkcountTarget.setUserId(user.getUserId());
		erpFunWorkcountTarget.setArchiveId(user.getArchiveId());
		erpFunWorkcountTarget.setCreateTime(new Date());
		erpFunWorkcountTargetMapper.insertSelective(erpFunWorkcountTarget);
		erpFunWorkcountTarget.setTargetType((byte)2);
		erpFunWorkcountTarget.setId(null);
		erpFunWorkcountTarget.setShardCityId(cityId);
		erpFunWorkcountTargetMapper.insertSelective(erpFunWorkcountTarget);
		erpFunWorkcountTarget.setTargetType((byte)3);
		erpFunWorkcountTarget.setId(null);
		erpFunWorkcountTarget.setShardCityId(cityId);
		erpFunWorkcountTargetMapper.insertSelective(erpFunWorkcountTarget);

		erpFunEmployeeDocService.updateOrCreateEmployeeDoc(cityId, user);

		ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, user.getCompId(), user.getOrganizationId());
		String trackCotent = "加入组织:" + erpFunOrganization.getOrganizationName() + "  职位:" + compRoles.getRoleName();
		// 1=入职 2=组织调动 3 = 权限修改 4=角色调动 5=离职
	//	erpFunEmployeeLogService.insertLogNew(cityId, param.getCurrentCompId(), (byte) 1, trackCotent, user.getArchiveId(),
		//		param.getCurrentUserId(), null, user.getOrganizationId(), null, compRoles.getRoleId());

		erpFunEmployeeLogService.insertLogNewNew(cityId, param.getCurrentCompId(), (byte) 1, trackCotent, user.getArchiveId(),
				param.getCurrentUserId(), null, user.getOrganizationId(), null, compRoles.getRoleId(),createUserName);

		// 记录经纪人跟进
		adminCrmBrokerTrackService.createRegisterTrack(user.getArchiveId(), trackCotent, "[用户注册]");
		// 写用户基本权限表
		erpUserOpersService.insertUserOpersByCreateUserNew(user, param.getCurrentCompType().byteValue());
		adminFunErpUserGuideService.insertUserSeniorGuide(user.getUserId(), user.getArchiveId());

		this.evictBaseInfoByCompId(cityId, user.getCompId());
		this.endLoginUser(funArchive.getArchiveId(), funArchive.getUserMobile(), LogInEnum.DEPT_CHANGE);
		return user;
	}

	/**
	 * 获取无限组织架构或原有组织架构下的加盟商id
	 * @param cityId
	 * @param param
	 * @param funDepts
	 * @return partnerId
	 */
	private Integer getPartnerIdByOrgOrDept(Integer cityId, CreateUserParam param, ErpFunDepts funDepts) {
		Integer partnerId = null;
		ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, param.getCompId(), param.getOrganizationId());
		if (null != erpFunOrganization) {
			partnerId = erpFunOrganization.getPartnerId();
		}
		return partnerId;
	}

	@Override
	public void initWageData(Integer cityId, Integer userId, Integer opType) {
		ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, userId);
		this.initWageData(erpFunUsers, opType);
	}

	/** 初始化薪资数据 **/
	@Transactional
	@Override
	/**
	 * opType: = 1 员工新增  2：修改
	 *
	 * **/
	public void initWageData(ErpFunUsers funUsersPO, Integer opType) {
		Integer cityId = funUsersPO.getCityId().intValue();
		Integer compId = funUsersPO.getCompId();
		String userPosition = funUsersPO.getUserPosition();
		Integer roleLevelId = funUsersPO.getRoleLevelId();
		// 查询结算日
		String wstWageAccountingDay = erpSysParaService.getMLSysParamValByUserDefZero(cityId, compId,funUsersPO.getUserId(), "WAGE_ACCOUNTING_DAY");
		String assessMentMonth = DateUtil.getAssessMentMonth(wstWageAccountingDay, 0);
		ErpFunRoleWageConfigDto roleWageConfig = erpFunRoleWageConfigService.getRoleWageConfigInfo(cityId, compId,  userPosition, roleLevelId, assessMentMonth);

		if(null == roleWageConfig) {
			ErpFunRoleWageConfig erpFunRoleWageConfig = new ErpFunRoleWageConfig();
			erpFunRoleWageConfig.setAssessmentMonth(assessMentMonth);
			erpFunRoleWageConfig.setCompId(compId);
			erpFunRoleWageConfig.setCreateTime(Calendar.getInstance().getTime());
			erpFunRoleWageConfig.setIsCheck((byte) 1);
			erpFunRoleWageConfig.setRoleId(userPosition);
			erpFunRoleWageConfig.setShardCityId(cityId);
			erpFunRoleWageConfig.setBaseWage(BigDecimal.ZERO);
			erpFunRoleWageConfig.setCreateUid(funUsersPO.getUserId());
			erpFunRoleWageConfigMapper.insertSelective(erpFunRoleWageConfig);
			roleWageConfig = new ErpFunRoleWageConfigDto();
			roleWageConfig.setId(erpFunRoleWageConfig.getId());
			roleWageConfig.setBaseWage(erpFunRoleWageConfig.getBaseWage());
		}

		// 本月生效
		Integer effectiveThisMonth = 1;
		// 新员工处理
		if(null == opType || 1 == opType) {
			// 查询系统参数 新员工是否参与配置
			String newUserWageAssessment = erpSysParaService.getMLSysParamValByUserDefZero(cityId, compId,funUsersPO.getUserId(), "NEW_USER_WAGE_ASSESSMENT");
			if(StringUtil.isNotBlank(newUserWageAssessment) && StringUtil.parseInteger(newUserWageAssessment, 0 ) > 0) {
				// 判断经纪人配置参数
				Integer day = StringUtil.parseInteger(newUserWageAssessment, 0);

				Calendar calendar = Calendar.getInstance();
				Integer nowDay = calendar.get(Calendar.DAY_OF_MONTH);
				if(nowDay >= day) {
					effectiveThisMonth = 0;
				}
			}
		}
		// 防止有错误数据，直接清除掉
		ErpSalaryTypeRelative salaryTypeRelative = new ErpSalaryTypeRelative();
		salaryTypeRelative.setAreaId(0);
		salaryTypeRelative.setRegId(0);
		salaryTypeRelative.setDeptId(0);
		salaryTypeRelative.setGrId(0);
		salaryTypeRelative.setUserId(funUsersPO.getUserId());
		salaryTypeRelative.setRoleId(userPosition);
		salaryTypeRelative.setCreationTime(new Date());
		salaryTypeRelative.setSalaryTypeId(roleWageConfig.getId());
		salaryTypeRelative.setDelFlag(0);
		salaryTypeRelative.setCompId(compId);
		salaryTypeRelative.setShardCityId(cityId);
		erpSalaryTypeRelativeMapper.insertSelective(salaryTypeRelative);

		ErpFunWage erpFunWage = erpFunWageMapper.getFunWageByUserId(cityId, compId, funUsersPO.getUserId(), assessMentMonth);
		if(null != erpFunWage) {
			ErpFunAssessmentStatisticsExample assessmentStatisticsExample = new ErpFunAssessmentStatisticsExample();
			assessmentStatisticsExample.setShardCityId(cityId);
			assessmentStatisticsExample.createCriteria().andCompIdEqualTo(compId).andUserIdEqualTo(funUsersPO.getUserId()).andAssessmentMonthEqualTo(assessMentMonth);
			int i = erpFunAssessmentStatisticsMapper.countByExample(assessmentStatisticsExample);

			if(i  > 0) {
				ErpFunAssessmentStatistics erpFunAssessmentStatistics = new ErpFunAssessmentStatistics();
				erpFunAssessmentStatistics.setUserPosition(funUsersPO.getUserPosition());
				erpFunAssessmentStatistics.setRoleWageConfigId(roleWageConfig.getId());
				erpFunAssessmentStatistics.setAreaId(funUsersPO.getAreaId());
				erpFunAssessmentStatistics.setRegId(funUsersPO.getRegId());
				erpFunAssessmentStatistics.setDeptId(funUsersPO.getDeptId());
				erpFunAssessmentStatistics.setGrId(funUsersPO.getGrId());
				erpFunAssessmentStatisticsMapper.updateByExampleSelective(erpFunAssessmentStatistics, assessmentStatisticsExample);
			}else {
				erpFunAssessmentStatisticsMapper.initAssessmentStaticsData(cityId, compId, funUsersPO.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(),1, 1, 1, 1);
				erpFunAssessmentStatisticsMapper.initAssessmentStaticsData(cityId, compId, funUsersPO.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(),1, 2, 1, 1);
				erpFunAssessmentStatisticsMapper.initAssessmentStaticsData(cityId, compId, funUsersPO.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(),2, 1, 1, 1);
				erpFunAssessmentStatisticsMapper.initAssessmentStaticsData(cityId, compId, funUsersPO.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(),2, 2, 1, 1);
			}

			// 从新计算
			AdminFunRecalculateWageInfo adminFunRecalculateWageInfo = new AdminFunRecalculateWageInfo();
			adminFunRecalculateWageInfo.setAssessmentMonth(assessMentMonth);
			adminFunRecalculateWageInfo.setCreationTime(new Date());
			adminFunRecalculateWageInfo.setRoleId(funUsersPO.getUserPosition());
			adminFunRecalculateWageInfo.setUserId(funUsersPO.getUserId());
			adminFunRecalculateWageInfo.setCompId(compId);
			adminFunRecalculateWageInfo.setCityId(cityId);
			try {
				adminFunRecalculateWageInfoMapper.insertSelective(adminFunRecalculateWageInfo);
				// 这里加了数据库唯一锁  所以try一下
			}catch (Exception e) {

			}
		}else {
			// 初始化薪资数据
			erpFunWageMapper.initWageByUserId(cityId, compId, funUsersPO.getUserId(), roleWageConfig.getBaseWage(), assessMentMonth, effectiveThisMonth);
			erpFunAssessmentStatisticsMapper.initAssessmentStaticsData(cityId, compId, funUsersPO.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(),1, 1, effectiveThisMonth, 1);
			erpFunAssessmentStatisticsMapper.initAssessmentStaticsData(cityId, compId, funUsersPO.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(),1, 2, effectiveThisMonth, 1);
			erpFunAssessmentStatisticsMapper.initAssessmentStaticsData(cityId, compId, funUsersPO.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(),2, 1, effectiveThisMonth, 1);
			erpFunAssessmentStatisticsMapper.initAssessmentStaticsData(cityId, compId, funUsersPO.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(),2, 2, effectiveThisMonth, 1);
		}
	}

	/**
	* 新版组织机构初始化薪资数据
	* @param funUsersPO
	* @param opType opType: = 1 员工新增  2：修改
	* @author zangtie
	* @since 2019/12/9 15:20
	* @return void
	**/
	public void initWageDataNew(ErpFunUsers funUsersPO, Integer opType) {
		Integer cityId = funUsersPO.getCityId().intValue();
		Integer compId = funUsersPO.getCompId();
		String userPosition = funUsersPO.getUserPosition();
		Integer roleLevelId = funUsersPO.getRoleLevelId();
		// 查询结算日
		String wstWageAccountingDay = erpSysParaService.getMLSysParamValByUserDefZero(cityId, compId,funUsersPO.getUserId(), "WAGE_ACCOUNTING_DAY");
		String assessMentMonth = DateUtil.getAssessMentMonth(wstWageAccountingDay, 0);
		ErpFunRoleWageConfigDto roleWageConfig = erpFunRoleWageConfigService.getRoleWageConfigInfo(cityId, compId,  userPosition, roleLevelId, assessMentMonth);

		if(null == roleWageConfig) {
			ErpFunRoleWageConfig erpFunRoleWageConfig = new ErpFunRoleWageConfig();
			erpFunRoleWageConfig.setAssessmentMonth(assessMentMonth);
			erpFunRoleWageConfig.setCompId(compId);
			erpFunRoleWageConfig.setCreateTime(Calendar.getInstance().getTime());
			erpFunRoleWageConfig.setIsCheck((byte) 1);
			erpFunRoleWageConfig.setRoleId(userPosition);
			erpFunRoleWageConfig.setShardCityId(cityId);
			erpFunRoleWageConfig.setBaseWage(BigDecimal.ZERO);
			erpFunRoleWageConfig.setCreateUid(funUsersPO.getUserId());
			erpFunRoleWageConfigMapper.insertSelective(erpFunRoleWageConfig);
			roleWageConfig = new ErpFunRoleWageConfigDto();
			roleWageConfig.setId(erpFunRoleWageConfig.getId());
			roleWageConfig.setBaseWage(erpFunRoleWageConfig.getBaseWage());
		}

		// 本月生效
		Integer effectiveThisMonth = 1;
		// 新员工处理
		if(null == opType || 1 == opType) {
			// 查询系统参数 新员工是否参与配置
			String newUserWageAssessment = erpSysParaService.getMLSysParamValByUserDefZero(cityId, compId,funUsersPO.getUserId(), "NEW_USER_WAGE_ASSESSMENT");
			if(StringUtil.isNotBlank(newUserWageAssessment) && StringUtil.parseInteger(newUserWageAssessment, 0 ) > 0) {
				// 判断经纪人配置参数
				Integer day = StringUtil.parseInteger(newUserWageAssessment, 0);

				Calendar calendar = Calendar.getInstance();
				Integer nowDay = calendar.get(Calendar.DAY_OF_MONTH);
				if(nowDay >= day) {
					effectiveThisMonth = 0;
				}
			}
		}
		// 防止有错误数据，直接清除掉
		ErpSalaryTypeRelative salaryTypeRelative = new ErpSalaryTypeRelative();
		salaryTypeRelative.setAreaId(0);
		salaryTypeRelative.setRegId(0);
		salaryTypeRelative.setDeptId(funUsersPO.getDeptId());
		salaryTypeRelative.setGrId(0);
		salaryTypeRelative.setUserId(funUsersPO.getUserId());
		salaryTypeRelative.setRoleId(userPosition);
		salaryTypeRelative.setCreationTime(new Date());
		salaryTypeRelative.setSalaryTypeId(roleWageConfig.getId());
		salaryTypeRelative.setDelFlag(0);
		salaryTypeRelative.setCompId(compId);
		salaryTypeRelative.setShardCityId(cityId);
		erpSalaryTypeRelativeMapper.insertSelective(salaryTypeRelative);

		ErpFunWage erpFunWage = erpFunWageMapper.getFunWageByUserId(cityId, compId, funUsersPO.getUserId(), assessMentMonth);
		if(null != erpFunWage) {
			ErpFunAssessmentStatisticsExample assessmentStatisticsExample = new ErpFunAssessmentStatisticsExample();
			assessmentStatisticsExample.setShardCityId(cityId);
			assessmentStatisticsExample.createCriteria().andCompIdEqualTo(compId).andUserIdEqualTo(funUsersPO.getUserId()).andAssessmentMonthEqualTo(assessMentMonth);
			int i = erpFunAssessmentStatisticsMapper.countByExample(assessmentStatisticsExample);

			if(i  > 0) {
				ErpFunAssessmentStatistics erpFunAssessmentStatistics = new ErpFunAssessmentStatistics();
				erpFunAssessmentStatistics.setUserPosition(funUsersPO.getUserPosition());
				erpFunAssessmentStatistics.setRoleWageConfigId(roleWageConfig.getId());
//				erpFunAssessmentStatistics.setAreaId(funUsersPO.getAreaId());
//				erpFunAssessmentStatistics.setRegId(funUsersPO.getRegId());
//				erpFunAssessmentStatistics.setDeptId(funUsersPO.getDeptId());
//				erpFunAssessmentStatistics.setGrId(funUsersPO.getGrId());
				erpFunAssessmentStatistics.setOrganizationId(funUsersPO.getOrganizationId());
				erpFunAssessmentStatistics.setOrganizationPath(funUsersPO.getTissueLine());
				erpFunAssessmentStatisticsMapper.updateByExampleSelective(erpFunAssessmentStatistics, assessmentStatisticsExample);
			}else {
				erpFunAssessmentStatisticsMapper.initAssessmentStaticsDataNew(cityId, compId, funUsersPO.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(),1, 1, 1, 1);
				erpFunAssessmentStatisticsMapper.initAssessmentStaticsDataNew(cityId, compId, funUsersPO.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(),1, 2, 1, 1);
				erpFunAssessmentStatisticsMapper.initAssessmentStaticsDataNew(cityId, compId, funUsersPO.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(),2, 1, 1, 1);
				erpFunAssessmentStatisticsMapper.initAssessmentStaticsDataNew(cityId, compId, funUsersPO.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(),2, 2, 1, 1);
			}

			// 从新计算
			AdminFunRecalculateWageInfo adminFunRecalculateWageInfo = new AdminFunRecalculateWageInfo();
			adminFunRecalculateWageInfo.setAssessmentMonth(assessMentMonth);
			adminFunRecalculateWageInfo.setCreationTime(new Date());
			adminFunRecalculateWageInfo.setRoleId(funUsersPO.getUserPosition());
			adminFunRecalculateWageInfo.setUserId(funUsersPO.getUserId());
			adminFunRecalculateWageInfo.setCompId(compId);
			adminFunRecalculateWageInfo.setCityId(cityId);
			try {
				adminFunRecalculateWageInfoMapper.insertSelective(adminFunRecalculateWageInfo);
				// 这里加了数据库唯一锁  所以try一下
			}catch (Exception e) {

			}
		}else {
			// 初始化薪资数据
			erpFunWageMapper.initWageByUserId(cityId, compId, funUsersPO.getUserId(), roleWageConfig.getBaseWage(), assessMentMonth, effectiveThisMonth);
			erpFunAssessmentStatisticsMapper.initAssessmentStaticsDataNew(cityId, compId, funUsersPO.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(),1, 1, effectiveThisMonth, 1);
			erpFunAssessmentStatisticsMapper.initAssessmentStaticsDataNew(cityId, compId, funUsersPO.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(),1, 2, effectiveThisMonth, 1);
			erpFunAssessmentStatisticsMapper.initAssessmentStaticsDataNew(cityId, compId, funUsersPO.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(),2, 1, effectiveThisMonth, 1);
			erpFunAssessmentStatisticsMapper.initAssessmentStaticsDataNew(cityId, compId, funUsersPO.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(),2, 2, effectiveThisMonth, 1);
		}
	}

	/**
	 * @tag 插入并更新员工编号
	 * @author 邓永洪
	 * @since 2018/5/25
	 */
	private String generateUserNo(Integer cityId, Integer userId) {
		AdminFunCity adminFunCity=adminFunCityMapper.getDataByCityId(cityId);
		String userNoString=adminFunCity.getCompNo()+String.format("%07d", userId);
		return userNoString;
	}

	public int checkDeptUserNum(Integer cityId,Integer deptId,boolean updateRoleFlag,String roleId) {
		// 查询门店是否是租用或者新营销版
		ErpFunDepts byDeptId = erpFunDeptsMapper.getByDeptId(cityId, deptId);
		AdminFunDepts deptByCompNoAndDeptNo = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(byDeptId.getCompNo(), byDeptId.getDeptNo());
		Integer deptsUserNum = byDeptId.getUserNum();
		Integer userNum = null;
		if ((null != deptByCompNoAndDeptNo.getDeptType() && 4 == deptByCompNoAndDeptNo.getDeptType().intValue()) ||
				(null != deptByCompNoAndDeptNo.getPayType() && 5 == deptByCompNoAndDeptNo.getPayType().intValue())) {
			userNum = erpFunUsersMapper.countUserNumberForRentDept(cityId, deptId);
			if ("COMMON_ADMIN".equals(roleId) && deptsUserNum.equals(userNum)) { //租用门店新增管理员时 特别判断
				return userNum;
			}
		}else {
			if (updateRoleFlag) {
				return 0;
			}
			ErpFunUsersExample usersExample=new ErpFunUsersExample();
			usersExample.setShardCityId(cityId);
			usersExample.createCriteria().andDeptIdEqualTo(deptId).andUserWriteoffEqualTo(false);
			userNum=erpFunUsersMapper.countByExample(usersExample);
		}
		if (deptsUserNum==null){
			throw new BusinessException("DEPTID："+deptId+"门店用户数量限制字段为空");
		}
		if (deptsUserNum<=userNum){
			throw new BusinessException("用户注册已经达到许可的最大值，请联系客服");
		}
		return userNum;
	}

	@Transactional
	public void updateUserManageRange(Integer userId, String userPosition, String rangeIds, Integer rangeType, CreateUserParam param, boolean isFangJidi) {
		ErpCompRoles compRoles = erpCompRolesMapper.getByRoleId(param.getCurrentCityId(), param.getCurrentCompId(), userPosition);
		if (compRoles != null && compRoles.getManageLevel() == 1) {
			rangeType = 1;
		}
		if (rangeType != null && rangeType == 1) {
			rangeIds = param.getCurrentCompId().toString();
		}
		if (StringUtils.isBlank(userPosition) && null != userId) {
			return;
		}
		erpFunUserManageRangeService.updateUserManageRange(param.getCurrentCityId(), param.getCurrentCompId(), userId,
				rangeType, rangeIds, userPosition, isFangJidi);
	}

	@Transactional
	@Override
	public void updateUserInfo(UpdateUserInfoParam param) {
		String newRole = param.getUserPosition();
		String oldRole = param.getOldUserPosition();
		Integer cityId = param.getSelfCityId();
		Integer userId = param.getUserId();
		Integer compId = param.getSelfCompId();
		Integer selfDeptId = param.getSelfDeptId();
		ErpCompRoles compRoles = null;
		// 修改用户状态、角色、权限时要重新登录
		boolean isChange = false;
		LogInEnum userReloginTypeDesc = LogInEnum.UserStatus_UP;
		ErpFunUsers oldFunUsers = erpFunUsersMapper.getFunUserByUserId(cityId, userId);
		// 当帐号从暂停到启用时，更新房、客源信息表的策略参数控制字段
		Integer userStatus = Optional.ofNullable(param.getUserStatus()).orElse(0);
		if (!userStatus.equals(param.getOldUserStatus())) {
			if(1 == userStatus){
				// TODO
			}
			isChange = true;
		}
		if (StringUtil.isNotBlank(oldRole) && StringUtil.isNotBlank(newRole) && !oldRole.equals(newRole)) {
			if (Const.DIC_ROLE_NAME_BRANCH_MANAGER.equals(newRole) && !erpUserOpersService.judgeBranchManager(cityId,
					compId, param.getDeptId(), param.getCompType(), selfDeptId)) {
				throw new BusinessException("你是赢销版用户，1个门店最多只能创建3个分行经理账号！");
			}
			compRoles = erpCompRolesMapper.getByRoleId(cityId, compId, newRole);
			if (null != compRoles && Byte.valueOf("1").equals(compRoles.getIsDel())) {
				throw new BusinessException("该角色已删除，请重新选择！");
			}
			erpUserOpersMapper.deleteByUserId(cityId, userId);
			// 添加新角色的权限
			erpUserOpersService.insertUserOpersByCreateUser(oldFunUsers, param.getCompType().byteValue());
			adminFunErpUserGuideService.insertUserSeniorGuide(userId, param.getArchiveId());
			isChange = true;
			userReloginTypeDesc = LogInEnum.RoleOrOper_UP;
		}
		// 分组修改了，也要踢人
		if (null != param.getGrId() && !param.getGrId().equals(oldFunUsers.getGrId())) {
			isChange = true;
			userReloginTypeDesc = LogInEnum.RoleOrOper_UP;
		}
		// 更新用户基本工资
		if (StringUtil.isNotBlank(param.getBaseMoney())) {
			ErpFunBasewage updateModel = new ErpFunBasewage();
			updateModel.setUserId(param.getUserId());
			updateModel.setShardCityId(cityId);
			String baseMoney = param.getBaseMoney();
			int index = baseMoney.indexOf(".");
			if (index >= 0) {
				baseMoney.substring(0, index);// 整形限制，需求变了记得改这里！
			}
			updateModel.setBaseMoney(StringUtil.parseInteger(baseMoney));
			erpFunBasewageMapper.updateByPrimaryKeySelective(updateModel);
		}
		// 更新档案
		adminFunArchiveService.createOrUpdateByErpCreateUser(cityId, null, null, null, oldFunUsers, param.getProvinceId(), param.getSelUid(), (byte)3);
		if (isChange) {
			endLoginUser(param.getArchiveId(), oldFunUsers.getUserMobile(), userReloginTypeDesc);
		}
		// 更新用户信息以及缓存
		ErpFunUsers erpFunUsers = new ErpFunUsers();
		erpFunUsers.setUserId(userId);
		erpFunUsers.setUserPhotoMin(null);
		erpFunUsers.setAlldeptFlag(null);
		erpFunUsers.setArchiveId(null);
		erpFunUsers.setCompId(null);
		erpFunUsers.setLoginPassword(null);
		erpFunUsers.setLoginUserid(null);
		erpFunUsers.setUserNo(null);
		erpFunUsers.setShardCityId(cityId);
		updateByPrimaryKeySelective(erpFunUsers);
		if (oldFunUsers.getDeptId() != null || // 判断是否清除公司集合
				oldFunUsers.getCompId() != null || oldFunUsers.getAreaId() != null || oldFunUsers.getRegId() != null
				|| oldFunUsers.getGrId() != null || oldFunUsers.getUserPosition() != null
				|| oldFunUsers.getUserName() != null || oldFunUsers.getWageFlag() != null
				|| oldFunUsers.getUserStatus() != null || oldFunUsers.getUserSex() != null) {
			evictBaseInfoByCompId(cityId, compId);
		}
		// 修改了角色，且角色管理范围为公司时重新生成管理范围（其他都是手动改）
		if (StringUtil.isNotBlank(oldRole) && !oldRole.equals(newRole)) {
			if (param.isFangJidi()) {
				erpFunUserManageRangeService.updateFangjiDiUserManageRange(cityId, compId, userId, 1, compId.toString(),
						oldRole, param.isFangJidi());
			} else {
				if (null != compRoles && Byte.valueOf("1").equals(compRoles.getManageLevel())) {
					// 管理范围为公司
					erpFunUserManageRangeService.updateUserManageRange(cityId, compId, userId, 1, compId.toString(),
							oldRole, param.isFangJidi());
				}
			}
		}
	}

	/**
	 * @tag
	 * 获取提醒人列表
	 * taskType:
	 * 0=只需要合同上的流程总负责人，签约人，签约主管，创建人
	 * 1=流程总负责人，签约人，签约主管，创建人，财务审核人
	 * 2=流程总负责人，签约人，签约主管，创建人，财务审核人，税费更新人
	 * @author 邓永洪
	 * @since 2018/6/6
	 */
	@Transactional
	@Override
	public List<ErpFunUsers> getTaskUserList(Integer cityId, Integer dealId, Integer taskType, Integer compId, Integer userId) {
		List<Map<String, Integer>> taskUserList = erpFunUsersMapper.getTaskUserList(cityId,dealId, taskType, compId);
		Set<Integer> set = new HashSet<>();
		for (Map<String, Integer> map : taskUserList) {
			Integer signUserId = map.get("SIGN_USER_ID");
			if (null != signUserId) {
				set.add(signUserId);
			}
			Integer signManagerId = map.get("SIGN_MANAGER_ID");
			if (null != signManagerId) {
				set.add(signManagerId);
			}
			Integer dealUserId = map.get("DEAL_USER_ID");
			if (null != dealUserId) {
				set.add(dealUserId);
			}
			Integer creatorUid = map.get("CREATOR_UID");
			if (null != creatorUid) {
				set.add(creatorUid);
			}
			// 这个AUDIT_USER 默认是一个String 需要做以下处理
			Object auditUserInt = map.get("AUDIT_USER");
			String auditUser = auditUserInt == null ? null : auditUserInt + "";
			if (StringUtils.isNotBlank(auditUser)) {
				set.add(StringUtil.paseInteger(auditUser));
			}
			Integer updateUser = map.get("UPDATE_USER");
			if (null != updateUser) {
				set.add(updateUser);
			}
		}
		set.remove(userId);
		if (set.isEmpty()) {
			return new ArrayList<ErpFunUsers>();
		}
		return erpFunUsersMapper.getUserListByUserIds(cityId,set);
	}

	/**
	 * @tag 个人中心-修改用户手机号
	 * @author 邓永洪
	 * @since 2018/6/8
	 */
	@Transactional
	@Override
	public void updateForMobile(GeneralParam generalParam, String mobile) {
		ErpFunUsers users=new ErpFunUsers();
		users.setShardCityId(generalParam.getCityId());
		users.setUserId(generalParam.getUserId());
		users.setUserMobile(mobile);
		erpFunUsersMapper.updateByPrimaryKeySelective(users);
		evictBaseInfoByCompId(generalParam.getCityId(), generalParam.getCompId());
	}

	@Transactional
	@Override
	public void refreshUserOperator(Integer archiveId, Integer cityId, String compNo, String deptNo, Integer refreshType) {
		Operator operator = new Operator();
		ErpResponseJson responseJson = new ErpResponseJson();
		AdminFunArchive adminFunArchive = adminFunArchiveMapper.getArchiveById(archiveId);
		AdminFunDepts adminFunDepts = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(compNo, deptNo);
		// 精英版是用手机号登录，门店版是用USER_ID登录
		if (StringUtil.isBlank(compNo) && StringUtil.isBlank(deptNo)) {
			ErpFunUsers erpFunUsers = erpFunUsersMapper.getValidUserByArchiveId(archiveId);
			ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(cityId, erpFunUsers.getDeptId());
			adminFunDepts = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(erpFunDepts.getCompNo(), erpFunDepts.getDeptNo());
		}
		if(1 == refreshType){
			this.refreshVIPAndO2O(responseJson, operator, adminFunArchive, adminFunDepts, cityId);
		}
		cacheUtil.put(CacheStructure.ARCHIVE_ID_OPERATOR + archiveId, operator.getAllAtrtibute(), CacheUtilExt.SESSION_TIME_OUT);
	}

	@Transactional
	@Override
	public void updateShenheUserFlag(Integer cityId, Integer compId, String[] userIds) {
		// 先清除本公司的原本审核人
		erpFunUsersMapper.updateUserFlag(cityId,compId);
		// 设置薪资审核人
		erpFunUsersMapper.updateShenheUserFlag(cityId,compId,userIds);
		evictBaseInfoByCompId(cityId, compId);
	}

	@Transactional
	@Override
	public void updateUserStatus(Integer cityId, Integer compId, Integer userId, Integer closeOrOpen) {
		erpSysParaMapper.updateOaramValueByCompId(cityId,StringUtil.toString(closeOrOpen),StringUtil.toString(closeOrOpen),compId,"BUILD_IMPLICIT_CALL");
		this.evictCacheableCompId(cityId, compId);
		// 开启时强制重新登录
		if(closeOrOpen == 1) {
			ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
			erpFunUsersExample.createCriteria().andCompIdEqualTo(compId).andUserWriteoffEqualTo(false);
			erpFunUsersExample.setShardCityId(cityId);
			List<ErpFunUsers> funUsersPOs = erpFunUsersMapper.selectByExample(erpFunUsersExample);
			Set<Integer> userIds = new HashSet<>();

			for (ErpFunUsers funUsersPO : funUsersPOs) {
				if(userId.equals(funUsersPO.getUserId())) {
					continue;
				}
				Object loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_ERP + funUsersPO.getArchiveId());
				if (loginKey != null) {
				    cacheUtil.put(loginKey, LogInEnum.RoleOrOper_UP.getValue(), CacheUtilExt.INVALID_TIME_OUT);
				}
				loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_APP + funUsersPO.getArchiveId());
				if (loginKey != null) {
				    cacheUtil.put(loginKey, LogInEnum.RoleOrOper_UP.getValue(), CacheUtilExt.INVALID_TIME_OUT);
				}
				userIds.add(funUsersPO.getArchiveId());
			}

			TaskQueueMsg taskQueueMsg=new TaskQueueMsg();
			taskQueueMsg.setTaskType(new TaskQueueThread.TaskType[]{TaskQueueThread.TaskType.MERGE_APP_REFRESH_USER});
			taskQueueMsg.setTargetIds(userIds.toArray(new Integer[] {}));
			TaskQueueThread.sendMessage(taskQueueMsg);
		}


	}

	private void evictCacheableCompId(Integer cityId, Integer compId) {
	    cacheUtil.del(CacheStructure.hfterpdb_sysParaCache_map_by_CompId + compId + "_CITY_ID_" + cityId);
	}

    /**
     * 楼盘资料-设置楼盘资料管理员
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/7/18
     */
    @Transactional
    @Override
    public void updateFloorMgrManager(Integer cityId, Integer compId, String userId, String deptId) {
        String[] userIds = userId.split(",");
        String[] deptIds = deptId.split(",");
        //将现有的门店的楼盘资料管理员取消起权限//当页数据 BUILD_RULE_FLAG
        erpFunUsersMapper.updatesBuildRuleFalg(cityId, compId, deptIds);
        // 添加当前所选的楼盘资料管理员权限
        erpFunUsersMapper.updatesBuildRuleFalgByUserId(cityId, compId, userIds);
        this.evictBaseInfoByCompId(cityId, compId);
    }

	private void refreshVIPAndO2O(ErpResponseJson responseJson, Operator operator, AdminFunArchive adminFunArchive, AdminFunDepts adminFunDepts, Integer cityId){
		if(null != adminFunArchive){
			Integer superUser = adminFunArchive.getSuperUser();
			Date superEnd = adminFunArchive.getSuperEnd();
			Integer deptFlag = 0;
			Date tryEnd = null;
			Date spaceEnd = null;
			Date otoEnd = null;
			if(null != adminFunDepts){
				deptFlag = adminFunDepts.getDeptFlag();
				tryEnd = adminFunDepts.getTryEnd();
				spaceEnd = adminFunDepts.getSpaceEnd();
				otoEnd = adminFunDepts.getOtoEnd();
			}
			String tryDays = DateTimeHelper.formatDateTimetoString(tryEnd);
			String spaceDays = DateTimeHelper.formatDateTimetoString(spaceEnd);
			Date today = DateTimeHelper.parseToDate(DateTimeHelper.formatDateTimetoString(new Date(), DateTimeHelper.FMT_yyyyMMdd));
			Integer o2oFlag = 0;
			if (Const.DIC_DEPT_FLAG_1.equals(deptFlag) && StringUtil.isNotEmpty(tryDays)) {
				Date tryDaysDate = DateTimeHelper.parseToDate(DateTimeHelper.formatDateTimetoString(tryDays, DateTimeHelper.FMT_yyyyMMdd));
				tryDays = String.valueOf((tryDaysDate.getTime() - today.getTime()) / (1000 * 60 * 60 * 24));
//				if (StringUtil.paseInteger(tryDays, 0) < 0) {
//					throw new JthinkBusinessWarnException("试用已到期,请联系销售顾问！");
//				}
				spaceDays = null;
			} else if (Const.DIC_DEPT_FLAG_2.equals(deptFlag) && null != spaceDays) {
				tryDays = null;
				Date spaceDaysDate = DateTimeHelper.parseToDate(DateTimeHelper.formatDateTimetoString(spaceDays, DateTimeHelper.FMT_yyyyMMdd));
				spaceDays = String.valueOf((spaceDaysDate.getTime() - today.getTime()) / (1000 * 60 * 60 * 24));
				if (StringUtil.isNotEmpty(DateTimeHelper.formatDateTimetoString(otoEnd))) {
					Date o2oEnd = DateTimeHelper.parseToDate(DateTimeHelper.formatDateTimetoString(otoEnd, DateTimeHelper.FMT_yyyyMMdd));
					if (o2oEnd.getTime() >= today.getTime()) {// OTO服务到期时间大于或等于空间到期时间则OTO服务开启 and O2O服务时间大于当前时间
						o2oFlag = 1;
					}
				}
//				if (!isPerLogin && StringUtil.paseInteger(spaceDays, 0) < 0){
//					throw new JthinkBusinessWarnException("您的O2O服务已到期,请尽快充值！");
//				}
			} else {
				tryDays = "";
				spaceDays = "";
			}
			// 门店用户 试用到期、O2O服务到期、门店暂停：可登录，但不继承增值服务 门店版用户默认是付费用户
			if (1 == superUser) {
				superUser = 1;
				if(null != adminFunDepts){
					superEnd = adminFunDepts.getSuperEnd();
				}
				if (Const.DIC_DEPT_FLAG__2.equals(deptFlag) || Const.DIC_DEPT_FLAG_0.equals(deptFlag)) {
					superUser = 0;
				} else if (Const.DIC_DEPT_FLAG_1.equals(deptFlag)) {
					Date tryEndDate = tryEnd;
					if (DateTimeHelper.compareTwoDate(new Date(), tryEndDate) < 0) {
						superUser = 0;
					}
				} else if (Const.DIC_DEPT_FLAG_2.equals(deptFlag)) {
					Date spaceEndDate = spaceEnd;
					if (DateTimeHelper.compareTwoDate(new Date(), spaceEndDate) < 0) {
						superUser = 0;
					}
				}
			}
			AdminFunCity adminFunCity = adminFunCityMapper.selectByPrimaryKey(cityId.shortValue());
			// 如果城市不限制
			if (null != adminFunCity.getSuperUser() && adminFunCity.getSuperUser()) {
				superUser = 1;
				superEnd = DateTimeHelper.parseToDate("2020-01-01 00:00:00");
			}
			// 试用用户默认开启所有功能
			if (Const.DIC_DEPT_FLAG_1.equals(deptFlag)) {
				int tryDaysNum = StringUtil.paseInteger(tryDays, -1);
				if (tryDaysNum >= 0) {
					o2oFlag = 1;
					superUser = 1;
				}
			}
			Object operatorTableObj = cacheUtil.get(CacheStructure.ARCHIVE_ID_OPERATOR + adminFunArchive.getArchiveId());
			if(operatorTableObj == null) {
				responseJson.setErrMsg("登录已失效，请重新登录！");
				return;
			}
			Hashtable hashtable = (Hashtable<String, Object>) operatorTableObj ;
			operator.setAllAttribute(hashtable);
			operator.setAttribute("SUPER_END", superEnd);
			operator.setAttribute("SUPER_USER", superUser);
			operator.setAttribute("O2O_FLAG", o2oFlag);
		}
	}

	/**
	 * @tag 修改员工角色
	 * @author 邓永洪
	 * @since 2018/8/8
	 */
	@Override
	@Transactional
	public void updateUserRole(Integer cityId, Integer compId, Integer userId, String roleId, Integer roleLevelId,
							   Integer currentUserId,Integer inviteId, String createUserName) {
		if(null != inviteId){
			ErpFunUsersInvited erpFunUsersInvited = erpFunUsersInvitedMapper.getUserByinviteId(cityId,inviteId);
			if(null == erpFunUsersInvited){
				throw new BusinessException("该用户不存在！");
			}
			erpFunUsersInvited.setUserPosition(roleId);
			erpFunUsersInvited.setShardCityId(cityId);
			erpFunUsersInvitedMapper.updateByPrimaryKeySelective(erpFunUsersInvited);
			return;
		}
		ErpFunUsers funUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, userId);
		if (funUsers == null) {
			throw new BusinessException("该用户不存在！");
		}

		String oldPosition = funUsers.getUserPosition();
		if (StringUtils.isNotBlank(oldPosition) && oldPosition.equals(roleId)) {
			return;
		}

		//一个公司只能配置一个管理员角色
		if ("COMMON_ADMIN".equals(roleId)) {
			ErpFunUsersExample usersExample = new ErpFunUsersExample();
			usersExample.setShardCityId(cityId);
			usersExample.createCriteria().andCompIdEqualTo(compId).andUserPositionEqualTo("COMMON_ADMIN").andUserWriteoffEqualTo(false);
			int adminRoleCount = erpFunUsersMapper.countByExample(usersExample);
			if (adminRoleCount > 0) {
				throw new BusinessException("一个公司只能配置一个管理员");
			}
		} else if ("COMMON_ADMIN".equals(oldPosition)) {
			// 判断人数
			checkDeptUserNum(cityId, funUsers.getDeptId(), true, roleId);
		}

		ErpCompRolesExample compRolesExample = new ErpCompRolesExample();
		compRolesExample.setShardCityId(cityId);
		compRolesExample.createCriteria().andCompIdEqualTo(compId).andRoleIdEqualTo(roleId);
		List<ErpCompRoles> erpCompRoleOpersList = erpCompRolesMapper.selectByExample(compRolesExample);
		if (erpCompRoleOpersList.size() == 0) {
			return;
		}
		//兼容标准版在职级设置调整角色没有roleLevelId的情况,就设置一个该角色职级最低的上去
		if(null == roleLevelId){
			roleLevelId = erpFunRoleLevelsMapper.getRoleLowRoleLeveLId(cityId,roleId,compId);
		}

		if(null == roleLevelId){
			roleLevelId = 0;
		}

		ErpCompRoles erpCompRoleOpers = erpCompRoleOpersList.get(0);
		//先删除再新增
		ErpFunUsers updateModel = new ErpFunUsers();
		updateModel.setShardCityId(cityId);
		updateModel.setUserId(userId);
		updateModel.setUserPosition(roleId);

		//会出现修改角色后该角色下没有任何的职级，那么需要把员工原来的数据清空
		ErpFunRoleLevelsExample example = new ErpFunRoleLevelsExample();
		example.setShardCityId(cityId);
		example.createCriteria().andRoleIdEqualTo(roleId).andCompIdEqualTo(compId).andRoleLevelStatusEqualTo((byte)1);
		int roleLevelDatas = erpFunRoleLevelsMapper.countByExample(example);
		//避免前端传空 造成原有数据被清空
		if(roleLevelId != null && roleLevelId > 0){
			updateModel.setRoleLevelId(roleLevelId);
		}

		//如果该角色下有职级，前端必须传一个默认的，如果修改过程中，该职级已被删除则修改失败
		if(roleLevelId != null && roleLevelId > 0 && roleLevelDatas > 0){
			// 修改角色初始化跨店登录权为无
			updateModel.setAlldeptFlag(false);
			updateModel.setUserLogtime(DateUtil.DateToString(new Date()));
			updateModel.setUpdateTime(DateUtil.DateToString(new Date()));
		} else if(roleLevelDatas <= 0){
			//必须写sql的方式将职级字段更新为null，sql中修改的其他字段与上面的updateModel一致-陈文超
			erpFunUsersMapper.updateChangeUserRoleProccess(cityId, compId, userId, roleId);
		} else {
			if(roleLevelId != null && roleLevelId > 0){
//				如果修改过程中，该职级已被删除则修改失败
				throw new BusinessException("修改员工角色失败，原因：指定的职级无效");
			}else{
				//以上情况都不满足，这种情况几乎不可能出现，出现则需要检查数据，或者还有其他关联的更新业务未考虑到
				throw new BusinessException("修改员工角色失败");
			}
		}

		cacheUtil.del(CacheStructure.hfterpdb_funUsersBaseInfoCache_map_by_COMP_ID + compId + "_CITY_ID_" + cityId);
		cacheUtil.del(CacheStructure.hfterpdb_funUsersBaseInfoCache_notwriteoff_map_by_COMP_ID + compId + "_CITY_ID_" + cityId);
		erpUserOpersMapper.deleteByUserId(cityId, userId);
		cacheUtil.del(CacheStructure.hfterpdb_userOpersCache_map_by_USER_ID + userId + "_CITY_ID_" + cityId);

		//管理员角色直接重模板权限里面获取
		if ("COMMON_ADMIN".equals(roleId)) {
			erpUserOpersMapper.createByNoCompRoleOper(cityId, userId,roleId, (byte) 1,true);
			// 销售版的时候处理总经理权限
		} else if ("GENERAL_MANAGER".equals(roleId) && "1".equals(erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, userId,"IS_SELL_VERSION"))) {
			ErpFunUsers genealUser = null;
			ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
			erpFunUsersExample.setShardCityId(cityId);
			erpFunUsersExample.createCriteria().andCompIdEqualTo(compId).andUserWriteoffEqualTo(false).andUserPositionEqualTo("GENERAL_MANAGER");
			List<ErpFunUsers> funUsersList = erpFunUsersMapper.selectByExample(erpFunUsersExample);
			ErpMarketVirtualGeneralExample marketVirtualGeneralExample = new ErpMarketVirtualGeneralExample();
			marketVirtualGeneralExample.setShardCityId(cityId);
			marketVirtualGeneralExample.createCriteria().andCompIdEqualTo(compId);
			List<ErpMarketVirtualGeneral> erpMarketVirtualGenerals = erpMarketVirtualGeneralMapper.selectByExample(marketVirtualGeneralExample);
			List<Integer> userIds = erpMarketVirtualGenerals.stream().collect(Collectors.mapping(val -> val.getUserId(), Collectors.toList()));
			for (ErpFunUsers user : funUsersList) {
				if (!userIds.contains(user.getUserId()) && !userId.equals(user.getUserId())) {
					genealUser = user;
				}
			}
			erpUserOpersMapper.copyGeneralOperToUser(cityId,genealUser.getUserId(),userId);
		} else {
			// story#11307 先判断当前公司是否说开了加盟模式，再判断当前这个人说在哪个组织，总部的就 要总部特殊的权限比如说加盟商管理权， 直营不管，如果说加盟商的人，那么要把特殊的加盟商公告管理权查出来
			List<Byte> flagList =  new ArrayList<Byte>();// 查询通用的权限，1=总部的，2=加盟商的
			flagList.add(Byte.valueOf("0"));
			ErpFunComp erpFunComp = erpFunCompMapper.selectByCompId(cityId, compId);
			if (null != erpFunComp && Byte.valueOf("1").equals(erpFunComp.getOpenPartner())) {
				if (Integer.valueOf(0).equals(funUsers.getPartnerId())) {// 总部
					flagList.add(Byte.valueOf("1"));
					flagList.add(Byte.valueOf("3"));
				} else if (null != funUsers.getPartnerId() && funUsers.getPartnerId() > 0) {// 加盟商
					flagList.add(Byte.valueOf("2"));
				} else {
					flagList.add(Byte.valueOf("3"));
				}
			}

			Integer rangeOrganizationId = 0;
			Integer organizationId = funUsers.getOrganizationId();
			ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrganizationId(cityId, organizationId);
			String organizationPath = erpFunOrganization.getOrganizationPath();
			String[] split = organizationPath.split(":");
			// 寻找最小级的组织

			ErpCompRoleOpersExample compRoleOpersExample = new ErpCompRoleOpersExample();
			compRoleOpersExample.setShardCityId(cityId);
			compRoleOpersExample.createCriteria().andCompIdEqualTo(compId).andRoleIdEqualTo(roleId).andPartnerOperIn(flagList);
			List<ErpCompRoleOpers> roleOpersList = erpCompRoleOpersMapper.selectByExample(compRoleOpersExample);

			Set<Integer> organizationIdList = roleOpersList.stream().collect(Collectors.mapping(val -> val.getOrganizationId(), Collectors.toSet()));

			for (Integer i = split.length-1;i>=0; i-- ) {
				String orgStr = split[i];
				if(StringUtils.isNotBlank(orgStr)) {
					Integer org = Integer.valueOf(orgStr);
					if(organizationIdList.contains(org)) {
						rangeOrganizationId = org;
						break;
					}
				}

			}

			Integer finalRangeOrganizationId = rangeOrganizationId;
			roleOpersList = roleOpersList.stream().filter(val-> finalRangeOrganizationId.equals(val.getOrganizationId())).collect(Collectors.toList());
			//为了防止重复权限，把它放到set里面
			Set<ErpCompRoleOpers> opersSet = roleOpersList.stream().collect(Collectors.mapping(val -> val, Collectors.toSet()));
			if (opersSet.size()>0){
				erpUserOpersMapper.insertUserOpperByOpers(cityId,userId,opersSet);
			}
		}
		compRolesExample = new ErpCompRolesExample();
		compRolesExample.setShardCityId(cityId);
		compRolesExample.createCriteria().andCompIdEqualTo(compId).andRoleIdEqualTo(oldPosition);
		erpCompRoleOpersList = erpCompRolesMapper.selectByExample(compRolesExample);
		if (erpCompRoleOpersList.size() == 0) {
			throw new BusinessException("所选员工角色异常，请联系在线客服");
		}
		ErpCompRoles oldCompRoles = erpCompRoleOpersList.get(0);
		String choseRoleName = erpCompRoleOpers.getRoleName();
		choseRoleName = "由" + oldCompRoles.getRoleName() + "角色调整为" + choseRoleName + "角色";

		//erpFunEmployeeLogService.insertLog(cityId, compId, (byte) 4, choseRoleName, funUsers.getArchiveId(), currentUserId, funUsers.getDeptId(),
				//funUsers.getDeptId(), oldCompRoles.getRoleId(), erpCompRoleOpers.getRoleId(), funUsers.getGrId(), funUsers.getGrId());
		if (erpUserOpersMapper.selectPerPermissionByName(cityId, userId, "LOGIN_OTHER_DEPTS")!=null){
			updateModel.setAlldeptFlag(true);
		}
		erpFunUsersMapper.updateByPrimaryKeySelective(updateModel);
		erpFunEmployeeLogService.insertLogAddCreateUser(cityId, compId, (byte) 4, choseRoleName, funUsers.getArchiveId(), currentUserId, funUsers.getDeptId(),
				funUsers.getDeptId(), oldCompRoles.getRoleId(), erpCompRoleOpers.getRoleId(), funUsers.getGrId(), funUsers.getGrId(),createUserName);

		//处理管理范围
		this.UserManageRangeProcess(cityId, compId, funUsers, roleId, false);
		// 判断销售版，总经理权限处理、
		String sellVersion = erpSysParaMapper.getParamValue(cityId, compId, "IS_SELL_VERSION");
		if ("1".equals(sellVersion)) {
			erpUserOpersService.marketVirtualGeneralProcess(funUsers, currentUserId, oldPosition, roleId);
		}
		//处理考核
		String firstDay = DateUtil.getFirstDateOfMonth().substring(0, 10)+" 00:00:00";
        Date assessmentTime = DateUtil.StringToDate(firstDay);//处理一下时间
		erpFunUsersMapper.updateAssessment(cityId,assessmentTime,1,userId);

		//踢人
		try {
			Object loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_ERP + funUsers.getArchiveId());
			if (loginKey != null) {
			    cacheUtil.put(loginKey, Const.LogInEnum.RoleOrOper_UP.getValue(), CacheUtilExt.INVALID_TIME_OUT);
			}
			loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_APP + funUsers.getArchiveId());
			if (loginKey != null) {
			    cacheUtil.put(loginKey, Const.LogInEnum.RoleOrOper_UP.getValue(), CacheUtilExt.INVALID_TIME_OUT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		TaskQueueMsg taskQueueMsg = new TaskQueueMsg();
		taskQueueMsg.setTaskType(new TaskQueueThread.TaskType [] {TaskQueueThread.TaskType.MERGE_APP_REFRESH_USER});
		taskQueueMsg.setTargetIds(new Integer [] {funUsers.getArchiveId()});
		TaskQueueThread.sendMessage(taskQueueMsg);
		//更新用户角色，清除基本信息集合
		if(!funUsers.getUserPosition().equals(roleId)){
			erpNoTransactionService.evictBaseInfoByCompId(cityId, compId);
		}
		/*if(!funUsers.getUserPosition().equals(roleId)){
			this.addDefaultPrivilege(cityId.shortValue(), userId, roleId, null);
		}*/
		//清理缓存
		erpNoTransactionService.evictCacheableModelData(cityId, userId);
		erpFunUsersService.initWageData(cityId, userId, 2);

		try {
			//判断是否是房基地公司，如果是房基地公司怎判断是否需要考核，并且设置考核时间
			ErpFunComp comp = erpFunCompMapper.selectByCompId(cityId, compId);
			if(comp != null){
				AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(comp.getCompNo());
				if("2".equals(adminFunComp.getCompManagementModel().toString())&& "1".equals(adminFunComp.getCustomizedType().toString())){
					//设置升降级
					setUserDrole(cityId,compId,userId);
				}
			}
		} catch (Exception e) {
		}
		/**
		 * -----------------------修改kpi配置方案------------------------
		 */
		erpFunEmployeeDocService.reConfigureUserKPIScheme(cityId, funUsers, roleId);
	}

	private void setUserDrole(Integer cityId,Integer compId,Integer userId){

		//查询最新角色信息
		//查询配置
		//判断是否开启自动降级
		//判断考核时间
		//设置员工考核时间
		ErpFunUsers  erpFunUsers = erpFunUsersMapper.getFunUserByUserId(cityId, userId);
		if(erpFunUsers == null){
			return;
		}
		String userPosition  = erpFunUsers.getUserPosition();
		if(StringUtil.isNotEmpty(userPosition)){
			return;
		}
		ErpZxRoleConfig  erpZxRoleConfig = erpZxRoleConfigMapper.getCompRoleCofig(cityId, erpFunUsers.getCompId(), userPosition);
		if(erpZxRoleConfig == null){
			return;
		}
		ErpFunUsers  updateErpFunUsers = new ErpFunUsers();
		updateErpFunUsers.setShardCityId(cityId);
		updateErpFunUsers.setUserId(userId);
		String opFalg = erpZxRoleConfig.getdOpernFalg().toString();
		if("1".equals(opFalg)){  //开启的升级
			String valueStr = erpSysParaService.getMLSysParamValByUserDefZero(cityId, compId, userId,"UPDATE_WAGE_CONFIG_EFFECTIVE");
			Integer daySet = 31;
			if(StringUtil.isEmpty(valueStr)){
				daySet = StringUtil.parseInteger(valueStr);
			}
			Integer dayNow = DateUtil.getDay(new Date());
			if(dayNow <= daySet){
				//考核时间在当月
				updateErpFunUsers.setdAssessmentTime(DateUtil.StringToDate(DateUtil.getFirstDateOfMonth(new Date()),"yyyy-MM-dd"));
				updateErpFunUsers.setdAssessmentFlag((byte)1);
			}else{
				//考核时间在下月
				updateErpFunUsers.setdAssessmentTime(DateUtil.StringToDate(DateUtil.getFirstDateOfNextMonth(new Date()),"yyyy-MM-dd"));
				updateErpFunUsers.setdAssessmentFlag((byte)1);
			}
		}else{
			updateErpFunUsers.setdAssessmentFlag((byte)0);
		}
		erpFunUsersMapper.updateByPrimaryKeySelective(updateErpFunUsers);
	}

	/**
	 * @tag 组织机构修改角色时，处理用户管理范围
	 * @author 邓永洪
	 * @since 2018/9/28
	 */
	private void UserManageRangeProcess(Integer cityId, Integer compId, ErpFunUsers funUsers, String roleId, boolean isFangJidi) {
		ErpCompRoles compRoles = erpCompRolesMapper.getByRoleId(cityId, compId, roleId);
		Byte rangeType = compRoles.getManageLevel();
		Integer rangeId = null;
		switch (rangeType) {
			case 1:
				rangeId = funUsers.getCompId();
				break;
			case 2:
				rangeId = funUsers.getAreaId();
				break;
			case 3:
				rangeId = funUsers.getRegId();
				break;
			case 4:
				rangeId = funUsers.getDeptId();
				break;
			case 5:
				Integer grId = funUsers.getGrId();
				if (grId != null && grId != 0) {
					rangeId = grId;
				}
				break;
			default:
				break;
		}
		String rangeIds = rangeId == null ? null : rangeId + "";
		erpFunUserManageRangeService.updateUserManageRange(cityId, compId, funUsers.getUserId(), rangeType.intValue(), rangeIds, roleId, isFangJidi);
	}


	/**
	 * @tag 编辑员工信息，网站部用
	 * @author 邓永洪
	 * @since 2018/7/25
	 */
	@Transactional
	@Override
	@Deprecated
	public void editUserInfo(GeneralParam generalParam, EditUserInfoParam param) {
		if(true){
			//陈文超写
			throw new BuilderException("网站接口的业务已经移植到APP中，该接口弃用-2019-07-30");
		}
		Integer cityId = generalParam.getCityId();
		Integer compId = generalParam.getCompId();
		//fun_user修改信息
		ErpFunUsers erpFunUsers = param;
		erpFunUsers.setUpdateTime(DateTimeHelper.getTimeNow());
		erpFunUsers.setShardCityId(cityId);
		erpFunUsersMapper.updateByPrimaryKeySelective(erpFunUsers);
		//改角色需要跟新权限
		if (StringUtils.isNotBlank(param.getUserPosition())) {


			List<ErpUserOpers> currentUserOpers = erpFunUsersService.getUpdateUserOpers(cityId, generalParam.getUserId());
			ErpFunUsers funUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, param.getUserId());
			List<String> currentUserOperIds = currentUserOpers.stream().collect(Collectors.mapping(val -> val.getOperId(), Collectors.toList()));
			if (currentUserOperIds.contains("MANAGE_GROUP_ORGANIZATION") && generalParam.getGrId().equals(funUsers.getGrId())) {
				ErpCompRoles currentUserRole = erpCompRolesMapper.getByRoleId(cityId, compId, generalParam.getUserPosition());
				ErpCompRoles userRole = erpCompRolesMapper.getByRoleId(cityId, compId, funUsers.getUserPosition());
				if (currentUserRole.getSeqNo() < userRole.getSeqNo()) {
//					this.updateUserRole(cityId, generalParam.getCompId(), generalParam.getCompType(), param.getUserId(), param.getUserPosition(), generalParam.getUserId());
				}
			} else if (currentUserOperIds.contains("MANAGE_DEPT_ORGANIZATION") && generalParam.getDeptId().equals(funUsers.getDeptId())) {
				ErpCompRoles currentUserRole = erpCompRolesMapper.getByRoleId(cityId, compId, generalParam.getUserPosition());
				ErpCompRoles userRole = erpCompRolesMapper.getByRoleId(cityId, compId, funUsers.getUserPosition());
				if (currentUserRole.getSeqNo() < userRole.getSeqNo()) {
//					this.updateUserRole(cityId, generalParam.getCompId(), generalParam.getCompType(), param.getUserId(), param.getUserPosition(), generalParam.getUserId());
				}
			} else if (currentUserOperIds.contains("MANAGE_REG_ORGANIZATION") && generalParam.getRegId().equals(funUsers.getRegId())) {
				ErpCompRoles currentUserRole = erpCompRolesMapper.getByRoleId(cityId, compId, generalParam.getUserPosition());
				ErpCompRoles userRole = erpCompRolesMapper.getByRoleId(cityId, compId, funUsers.getUserPosition());
				if (currentUserRole.getSeqNo() < userRole.getSeqNo()) {
//					this.updateUserRole(cityId, generalParam.getCompId(), generalParam.getCompType(), param.getUserId(), param.getUserPosition(), generalParam.getUserId());
				}
			} else if (currentUserOperIds.contains("MANAGE_AREA_ORGANIZATION") && generalParam.getAreaId().equals(funUsers.getAreaId())) {
				ErpCompRoles currentUserRole = erpCompRolesMapper.getByRoleId(cityId, compId, generalParam.getUserPosition());
				ErpCompRoles userRole = erpCompRolesMapper.getByRoleId(cityId, compId, funUsers.getUserPosition());
				if (currentUserRole.getSeqNo() < userRole.getSeqNo()) {
//					this.updateUserRole(cityId, generalParam.getCompId(), generalParam.getCompType(), param.getUserId(), param.getUserPosition(), generalParam.getUserId());
				}
			} else if (currentUserOperIds.contains("MANAGE_COMP_ORGANIZATION")) {
				ErpCompRoles currentUserRole = erpCompRolesMapper.getByRoleId(cityId, compId, generalParam.getUserPosition());
				ErpCompRoles userRole = erpCompRolesMapper.getByRoleId(cityId, compId, funUsers.getUserPosition());
				if (currentUserRole.getSeqNo() < userRole.getSeqNo()) {
//					this.updateUserRole(cityId, generalParam.getCompId(), generalParam.getCompType(), param.getUserId(), param.getUserPosition(), generalParam.getUserId());
				}
			}
		}
		AdminFunArchive adminFunArchive = new AdminFunArchive();
		adminFunArchive.setArchiveId(param.getArchiveId());
		adminFunArchive.setUserName(param.getUserName());
		Boolean userSex = param.getUserSex();
		if (userSex != null) {
			byte sex = userSex ? (byte) 1 : (byte) 0;
			adminFunArchive.setUserSex(sex);
		}
		//更新服务区
		if (StringUtils.isNotBlank(param.getServiceReg()) && StringUtils.isNotBlank(param.getServiceZoneIds())) {
			if (StringUtils.isNotBlank(param.getServiceZone())) {
				adminFunArchive.setServiceZone(" " + param.getServiceZone().trim() + " ");
				adminFunArchive.setServiceReg(" " + param.getServiceReg().trim() + " ");
			}
			if (StringUtils.isNotBlank(param.getServiceZoneIds())) {
				adminFunArchive.setServiceZoneIds(" " + param.getServiceZoneIds().trim() + " ");
			}
		}
		// 更新档案信息
		if (StringUtils.isNotBlank(param.getUserName()) || param.getUserSex() != null || StringUtils.isNotBlank(param.getServiceReg()))	{
			adminFunArchiveService.updatePersonalInfoByUcenter(cityId, adminFunArchive);
		}
		//清理缓存
		erpFunUsersService.evictBaseInfoByCompId(cityId,param.getCompId());
		//前端没用传grId说明没有调组
		if (param.getGrId()==null){
			return;
		}
		ErpFunUsers user = erpFunUsersMapper.getFunUserByUserId(cityId, param.getUserId());
		ErpFunDepts depts = erpFunDeptsMapper.getByDeptId(cityId, user.getDeptId());
		ErpFunDeptsgroup oldGroup = null;
		if (user.getGrId() != null && user.getGrId() > 0) {
			oldGroup = erpFunDeptsgroupMapper.getModelDataById(cityId, param.getCompId(), user.getGrId());
		}
		ErpFunDeptsgroup newGroup = erpFunDeptsgroupMapper.getModelDataById(cityId, param.getCompId(), param.getGrId());
		Integer oldGrId = (null != oldGroup ? oldGroup.getGrId() : 0);
		Integer newGrId = newGroup.getGrId();
		//写日志
		if (!oldGrId.equals(newGrId)) {
			String oldGroupName = (null != oldGroup) ? oldGroup.getGrName() : "未分组";
			String content = "将该员工从" + depts.getDeptName() + "-" + oldGroupName + "调动至" + depts.getDeptName() + "-" + newGroup.getGrName();
			erpFunEmployeeLogService.insertLog(cityId, param.getCompId(), Const.DIC_STAFF_MOVE_TO_NEWGROUP,
					content, user.getArchiveId(), param.getSelfUserId(), user.getDeptId(),
					user.getDeptId(), user.getUserPosition(),
					user.getUserPosition(), oldGrId, newGrId);
			//处理数据
			Set<Integer> allChangedUserSet = new HashSet<>();
			allChangedUserSet.add(param.getUserId());
			if (allChangedUserSet.size() > 0) {
				// 异步执行，发送jms消息修改数据所属
				TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
					@Override
					public void afterCommit() {
						sendForUpdateUser(param.getCityId().intValue(), new ArrayList<>(allChangedUserSet), param.getCompId(), param.getCompId(), null, null);
					}
				});
			}
		}
	}

	@Override
	public List<ErpUserOpers> getUpdateUserOpers(Integer cityId, Integer userId) {
		//List<ErpUserOpers> userOpers = erpUserOpersMapper.getListById(getOperator().getCityId(), userId);
		String[] opers = new String[]{"MANAGE_AREA_ORGANIZATION",
				"MANAGE_COMP_ORGANIZATION",
				"MANAGE_DEPT_ORGANIZATION",
				"MANAGE_GROUP_ORGANIZATION",
				"MANAGE_REG_ORGANIZATION",
				"ROLE_MANAGE"};
		ErpUserOpersExample userOpersExample = new ErpUserOpersExample();
		userOpersExample.setShardCityId(cityId);
		userOpersExample.createCriteria().andUserIdEqualTo(userId).andOperIdIn(Arrays.asList(opers));
		return erpUserOpersMapper.selectByExample(userOpersExample);
	}

	@Override
	public ErpFunUsers getGeneralManagerByCompId(Integer cityId, Integer compId) {
		ErpFunUsers funUsers = null;
		if ("1".equals(erpSysParaMapper.getParamValue(cityId, compId, "IS_SELL_VERSION"))) {
			ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
			erpFunUsersExample.setShardCityId(cityId);
			erpFunUsersExample.createCriteria().andCompIdEqualTo(compId).andUserWriteoffEqualTo(false).andUserPositionEqualTo("GENERAL_MANAGER");
			List<ErpFunUsers> funUsersList = erpFunUsersMapper.selectByExample(erpFunUsersExample);
			ErpMarketVirtualGeneralExample marketVirtualGeneralExample = new ErpMarketVirtualGeneralExample();
			marketVirtualGeneralExample.setShardCityId(cityId);
			marketVirtualGeneralExample.createCriteria().andCompIdEqualTo(compId);
			List<ErpMarketVirtualGeneral> erpMarketVirtualGenerals = erpMarketVirtualGeneralMapper.selectByExample(marketVirtualGeneralExample);
			List<Integer> userIds = erpMarketVirtualGenerals.stream().collect(Collectors.mapping(val -> val.getUserId(), Collectors.toList()));
			for (ErpFunUsers user : funUsersList) {
				if (!userIds.contains(user.getUserId())) {
					funUsers = user;
					break;
				}
			}
		} else {
			funUsers = erpFunUsersMapper.getGeneralManagerByCompId(cityId, compId);
		}
		return funUsers;
	}

	public void addDefaultPrivilege(Short cityId, Integer userId, String position, String runModel) {
		List<ErpUserOpers> opersPo = new ArrayList<ErpUserOpers>();
		// 添加房源默认查看权
		Set<String> houseViewPrivilege = UserOpersUtils.getViewHouseByPositionAndRunModel(position, runModel);
		Iterator<String> houseViewPrivilegeIt = houseViewPrivilege.iterator();
		while (houseViewPrivilegeIt.hasNext()) {
			ErpUserOpers opersPO = new ErpUserOpers();
			opersPO.setUserId(userId);
			opersPO.setOperId(houseViewPrivilegeIt.next());
			opersPo.add(opersPO);
		}
		// 添加客源默认查看权
		Set<String> custViewPrivilege = UserOpersUtils.getViewCustByPositionAndRunModel(position, runModel);
		Iterator<String> custViewPrivilegeIt = custViewPrivilege.iterator();
		while (custViewPrivilegeIt.hasNext()) {
			ErpUserOpers opersPO = new ErpUserOpers();
			opersPO.setUserId(userId);
			opersPO.setOperId(custViewPrivilegeIt.next());
			opersPo.add(opersPO);
		}
		if (!opersPo.isEmpty()) {
			erpUserOpersMapper.addDefaultPrivilege(cityId, opersPo);
		}
	}

	@Override
	public void updateUser(Integer cityId, ErpFunUsers updateModel) {
		updateModel.setShardCityId(cityId);
		erpFunUsersMapper.updateByPrimaryKeySelective(updateModel);
	}

	/**
	 * @tag 设置公司管理员
	 * @author 邓永洪
	 * @since 2018/10/25
	 */
	@Transactional
	@Override
	public void setCompConmmonAdmin(Integer cityId, Integer compId, Integer compType, Integer userId, Integer currentUserId, boolean isFangJidi) {
		//把之前的管理员改为正式经纪人
		ErpFunUsersExample erpFunUsersExample=new ErpFunUsersExample();
		erpFunUsersExample.setShardCityId(cityId);
		erpFunUsersExample.createCriteria().andCompIdEqualTo(compId).andUserPositionEqualTo("COMMON_ADMIN").andUserWriteoffEqualTo(false);
		List<ErpFunUsers> adminUsers = erpFunUsersMapper.selectByExample(erpFunUsersExample);
		if (adminUsers.size() > 0) {
			ErpFunUsers funUsers = adminUsers.get(0);

			ErpFunRoleLevelsExample roleLevelExample = new ErpFunRoleLevelsExample();
			roleLevelExample.setShardCityId(cityId);
			roleLevelExample.setOrderByClause("SEQ_NO asc");
			roleLevelExample.createCriteria().andCompIdEqualTo(compId).andRoleIdEqualTo("COMMON_ADMIN").andRoleLevelStatusEqualTo((byte) 1);
			List<ErpFunRoleLevels> erpFunRoleLevelList = erpFunRoleLevelsMapper.selectByExample(roleLevelExample);
			Integer defRoleLevelId = null;
			if(erpFunRoleLevelList != null && !erpFunRoleLevelList.isEmpty()){
				defRoleLevelId = erpFunRoleLevelList.get(0).getRoleLevelId();
			}
			String smallRole = "COMMON_BIZ";
			Integer isFjdFalg = 0;
			ErpFunComp erpFunComp  = erpFunCompMapper.selectByCompId(cityId, compId);
			if(erpFunComp !=null){
				AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(erpFunComp.getCompNo());
				if(adminFunComp != null){
					if(adminFunCompService.judgerIsFangjidi(adminFunComp.getCompId())){ //房基地公司则取房基地最小角色
						isFjdFalg = 1;
						smallRole = erpCompRolesMapper.getLowRole(cityId, erpFunComp.getCompId());
						if(StringUtil.isEmpty(smallRole)){
							throw new BusinessException("请先添加公司角色");
						}
						if("COMMON_ADMIN".equals(smallRole)){
							throw new BusinessException("请先添加公司角色");
						}
					}
				}
			}
			if(isFjdFalg == 0){ //非房基地
				//判断公司是否存在经纪人角色，若是不存在则查询公司最小的角色
				if(erpCompRolesMapper.getByRoleId(cityId, compId, smallRole) == null){
					smallRole = erpCompRolesMapper.getLowRole(cityId, erpFunComp.getCompId());
					if(StringUtil.isEmpty(smallRole)){
						throw new BusinessException("请先添加公司角色");
					}
					if("COMMON_ADMIN".equals(smallRole)){
						throw new BusinessException("请先添加公司角色");
					}
				}
			}
			ErpCompRoles roles = erpCompRolesMapper.getByRoleId(cityId, compId, smallRole);
			changeUserPosition(cityId, compId, compType, funUsers.getUserId(), currentUserId, isFangJidi, funUsers,smallRole,roles.getRoleName());
		}
		ErpFunUsers funUsers = erpFunUsersMapper.getFunUserByUserId(cityId, userId);
		changeUserPosition(cityId, compId, compType, userId, currentUserId, isFangJidi, funUsers,"COMMON_ADMIN",null);
	}

	private void changeUserPosition(Integer cityId, Integer compId, Integer compType, Integer userId,
			Integer currentUserId, boolean isFangJidi, ErpFunUsers funUsers,String roleId,String roleName) {
		String oldPosition = funUsers.getUserPosition();
		//先删除再新增
		cacheUtil.del(CacheStructure.hfterpdb_funUsersBaseInfoCache_map_by_COMP_ID + compId + "_CITY_ID_" + cityId);
		cacheUtil.del(CacheStructure.hfterpdb_funUsersBaseInfoCache_notwriteoff_map_by_COMP_ID + compId + "_CITY_ID_" + cityId);
		erpUserOpersMapper.deleteByUserId(cityId, userId);
		cacheUtil.del(CacheStructure.hfterpdb_userOpersCache_map_by_USER_ID + userId + "_CITY_ID_" + cityId);
		erpUserOpersMapper.createByNoCompRoleOper(cityId, userId,roleId, compType.byteValue(),true);
		ErpFunUsers updateModel = new ErpFunUsers();
		updateModel.setShardCityId(cityId);
		updateModel.setUserId(userId);
		updateModel.setUserPosition(roleId);
		if (erpUserOpersMapper.selectPerPermissionByName(cityId, userId, "LOGIN_OTHER_DEPTS")!=null){
			updateModel.setAlldeptFlag(true);
		}
		// 修改角色初始化跨店登录权为无,管理员默认就有跨店登录权
		updateModel.setUserLogtime(DateUtil.DateToString(new Date()));
		updateModel.setUpdateTime(DateUtil.DateToString(new Date()));
		erpFunUsersMapper.updateByPrimaryKeySelective(updateModel);
		ErpCompRolesExample compRolesExample = new ErpCompRolesExample();
		compRolesExample = new ErpCompRolesExample();
		compRolesExample.setShardCityId(cityId);
		compRolesExample.createCriteria().andCompIdEqualTo(compId).andRoleIdEqualTo(oldPosition);
		List<ErpCompRoles> erpCompRoleOpersList = erpCompRolesMapper.selectByExample(compRolesExample);
		if (erpCompRoleOpersList.size() == 0) {
			throw new BusinessException("所选员工角色异常，请联系在线客服");
		}
		ErpCompRoles oldCompRoles = erpCompRoleOpersList.get(0);
		String choseRoleName = "系统管理员";
		if (roleName!=null) {
			choseRoleName = roleName;
		}
		choseRoleName = "由" + oldCompRoles.getRoleName() + "角色调整为" + choseRoleName + "角色";

		erpFunEmployeeLogService.insertLog(cityId, compId, (byte) 4, choseRoleName, funUsers.getArchiveId(), currentUserId, funUsers.getDeptId(),
				funUsers.getDeptId(), oldCompRoles.getRoleId(), roleId, funUsers.getGrId(), funUsers.getGrId());

		// 只有角色调动影响薪资
//		BaseMapParam baseMapParam = new BaseMapParam();
//		baseMapParam.setInteger("userId", userId);
//		baseMapParam.setInteger("compId", compId);
//		baseMapParam.setInteger("cityId", cityId);
//		wageTypeController.resetWagetypeUserRelativeOffUserId(baseMapParam);

		//处理管理范围
		this.UserManageRangeProcess(cityId, compId, funUsers, roleId, isFangJidi);
		// 判断销售版，总经理权限处理、
		String sellVersion = erpSysParaMapper.getParamValue(cityId, compId, "IS_SELL_VERSION");
		if ("1".equals(sellVersion)) {
			erpUserOpersService.marketVirtualGeneralProcess(funUsers, currentUserId, oldPosition, roleId);
		}
		//踢人
		try {
			Object loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_ERP + funUsers.getArchiveId());
			if (loginKey != null) {
			    cacheUtil.put(loginKey, Const.LogInEnum.RoleOrOper_UP.getValue(), CacheUtilExt.INVALID_TIME_OUT);
			}
			loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_APP + funUsers.getArchiveId());
			if (loginKey != null) {
			    cacheUtil.put(loginKey, Const.LogInEnum.RoleOrOper_UP.getValue(), CacheUtilExt.INVALID_TIME_OUT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		TaskQueueMsg taskQueueMsg = new TaskQueueMsg();
		taskQueueMsg.setTaskType(new TaskQueueThread.TaskType[]{TaskQueueThread.TaskType.MERGE_APP_REFRESH_USER});
		taskQueueMsg.setTargetIds(new Integer[]{funUsers.getArchiveId()});
		TaskQueueThread.sendMessage(taskQueueMsg);
		//更新用户角色，清除基本信息集合
		if(!funUsers.getUserPosition().equals(roleId)){
			erpNoTransactionService.evictBaseInfoByCompId(cityId, compId);

		}
		/*if(!funUsers.getUserPosition().equals(roleId)){
			this.addDefaultPrivilege(cityId.shortValue(), userId, roleId, null);
		}*/
		//清理缓存
		erpNoTransactionService.evictCacheableModelData(cityId, userId);

		erpFunUsersService.initWageData(cityId, userId, 2);
	}


	public void sendForUpdateUser(Integer cityId, List<Integer> userIds, Integer oldCompId, Integer newCompId, Integer delUserId, String updateRange) {
		Integer[] allChangedUserIdArr = userIds.toArray(new Integer[] {});
		StringBuilder userIdSb = new StringBuilder();
		for (Integer userIdTmp : allChangedUserIdArr) {
			if(userIdSb.length() > 0) {
				userIdSb.append(",");
			}
			userIdSb.append(userIdTmp);
		}

		UpdateFunUserMessage message = new UpdateFunUserMessage();
		message.setUserIds(userIdSb.toString());
		message.setUpdateRange(updateRange);
		message.setOldCompId(oldCompId);
		message.setNewCompId(newCompId);
		message.setDelUserId(delUserId);
		message.setCityId(cityId);
		message.setQueneName(JmsMsgAction.UPDATE_AREA_REG_DEPT_GROUP_INFO);
		mqUtil.sendMessage(message);

	}

	@Override
	@Transactional
	public void updateUserRoleLevel(Integer cityId, Integer compId, Integer userId, Integer roleLevelId, Integer currentUserId) {
		ErpFunUsers funUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, userId);
		if (funUsers == null) {
			throw new BusinessException("该用户不存在！");
		}

		Integer oldRoleLevelId = funUsers.getRoleLevelId();
		//如果一样则不需要修改
		if (oldRoleLevelId != null && oldRoleLevelId.equals(roleLevelId)) {
			return;
		}

		ErpFunRoleLevelsExample roleLevelExample = new ErpFunRoleLevelsExample();
		roleLevelExample.setShardCityId(cityId);
		roleLevelExample.createCriteria().andCompIdEqualTo(compId).andRoleIdEqualTo(funUsers.getUserPosition()).andRoleLevelStatusEqualTo((byte) 1);
		List<ErpFunRoleLevels> erpRoleLevelList = erpFunRoleLevelsMapper.selectByExample(roleLevelExample);
		if (erpRoleLevelList == null || erpRoleLevelList.isEmpty()) {
			//如果修改的职级无效，那么直接返回
			return;
		}else{
			Set<Integer> roleLevelIds = erpRoleLevelList.stream().collect(Collectors.mapping(val -> val.getRoleLevelId(), Collectors.toSet()));
			if(!roleLevelIds.contains(roleLevelId)){
				//如果修改的职级无效，那么直接返回
				return;
			}
		}

		//更新用户职级
		ErpFunUsers updateModel = new ErpFunUsers();
		updateModel.setShardCityId(cityId);
		updateModel.setUserId(userId);
		updateModel.setRoleLevelId(roleLevelId);
		updateModel.setUpdateTime(DateUtil.DateToString(new Date()));
		if(erpFunUsersMapper.updateByPrimaryKeySelective(updateModel) > 0){
			String oldRoleLevelName = "";
			String newRoleLevelName = "";
			for(ErpFunRoleLevels erpFunRoleLevels : erpRoleLevelList){
				if(erpFunRoleLevels.getRoleLevelId().equals(oldRoleLevelId)){
					oldRoleLevelName = erpFunRoleLevels.getRoleLevelName();
				}else if(erpFunRoleLevels.getRoleLevelId().equals(roleLevelId)){
					newRoleLevelName = erpFunRoleLevels.getRoleLevelName();
				}
			}

			String choseRoleLevelName = null;
			if(StringUtil.isEmpty(oldRoleLevelName)){
				choseRoleLevelName = "职级调整为" + newRoleLevelName;
			}else{
				choseRoleLevelName = "职级由" + oldRoleLevelName + "调整为" + newRoleLevelName;
			}
			erpFunEmployeeLogService.insertLog4RoleLevel(cityId, compId, (byte) 8, choseRoleLevelName, funUsers.getArchiveId(), currentUserId, oldRoleLevelId, roleLevelId);
			erpFunUsersService.initWageData(cityId, userId, 2);
		}
	}

	@Override
	public void endLoginCompUser(Integer cityId, Integer compId, LogInEnum logInEnum) {
		ErpFunUsers condition = new ErpFunUsers();
		condition.setShardCityId(cityId);
		condition.setCompId(compId);
		List<ErpFunUsers> deptUserList = erpFunUsersMapper.getRangeUserNotUserWriteoffList(cityId, condition);
		//clienkey来clear
		for (ErpFunUsers erpFunUsers : deptUserList) {
			Object loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_ERP + erpFunUsers.getArchiveId());
			if (loginKey != null) {
			    cacheUtil.put(loginKey, logInEnum.getValue(), CacheUtilExt.INVALID_TIME_OUT);
			}
			loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_APP + erpFunUsers.getArchiveId());
			if (loginKey != null) {
			    cacheUtil.put(loginKey, logInEnum.getValue(), CacheUtilExt.INVALID_TIME_OUT);
			}
		}
		Set<Integer> collect = deptUserList.stream().collect(Collectors.mapping(ErpFunUsers::getArchiveId, Collectors.toSet()));
		TaskQueueThread.sendMessageMergeAppRefreshUser(logInEnum, collect.toArray(new Integer[]{}));
	}

	/**
	 * orgId 调动的最上层的组织机构id
	 * @param cityId
	 * @param compId
	 * @param orgId
	 * @param logInEnum
	 */
	public void endLoginMoveOrgUser(Integer cityId, Integer compId, Integer orgId, LogInEnum logInEnum) {
		String orgIdStr = ":" + orgId + ":";
		ErpFunUsersExample usersExample = new ErpFunUsersExample();
		usersExample.setShardCityId(cityId);
		usersExample.createCriteria().andCompIdEqualTo(compId).andTissueLineLike(orgIdStr).andUserWriteoffEqualTo(false);
		List<ErpFunUsers> users = erpFunUsersMapper.selectByExample(usersExample);
		users.stream().forEach(user->{
			Object loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_ERP + user.getArchiveId());
			if (loginKey != null) {
			    cacheUtil.put(loginKey, logInEnum.getValue(), CacheUtilExt.INVALID_TIME_OUT);
			}
			loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_APP + user.getArchiveId());
			if (loginKey != null) {
			    cacheUtil.put(loginKey, logInEnum.getValue(), CacheUtilExt.INVALID_TIME_OUT);
			}
		});
		Set<Integer> collect = users.stream().collect(Collectors.mapping(ErpFunUsers::getArchiveId, Collectors.toSet()));
		TaskQueueThread.sendMessageMergeAppRefreshUser(logInEnum, collect.toArray(new Integer[]{}));
	}

	@Override
	public Map<Integer, UserOrganizationInfoVO> getUserOrganizationInfoByUserIds(Integer cityId, List<Integer> userIdList) {
		if (null != userIdList && userIdList.size() > 0) {
			List<UserOrganizationInfoVO> userOrganizationInfoVOList = erpFunUsersMapper.getUserOrganizationInfoByUserIds(cityId, userIdList);
			Map<Integer, UserOrganizationInfoVO> map = userOrganizationInfoVOList.stream().collect(Collectors.toMap(UserOrganizationInfoVO :: getUserId, val -> val));
			return map;
		}
		return null;
	}

	@Override
	public void modifyUserUserMobile(Integer cityId, Integer archiveId, String userMobile, Integer selfUserId) {

		// modify lcb 修改于 2020/5/25 已经被注册的手机号不允许再次注册成
		List<AdminFunArchive> adminFunArchives = adminFunArchiveMapper.getValidMobileIsRegist(userMobile);
		if (adminFunArchives.size() > 0) {
			throw new BusinessException("该手机号码已注册");
		}

		AdminFunArchive funArchive=new AdminFunArchive();
		funArchive.setArchiveId(archiveId);
		funArchive.setUserMobile(userMobile);
		adminFunArchiveMapper.updateByPrimaryKeySelective(funArchive);

		ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByArchiveId(cityId, archiveId);

		ErpFunUsers users = new ErpFunUsers();
		users.setShardCityId(cityId);
		users.setUserId(erpFunUsers.getUserId());
		users.setUserMobile(userMobile);
		erpFunUsersMapper.updateByPrimaryKeySelective(users);

		ErpFunUsers operatorUser = erpFunUsersMapper.selectByUserId(cityId, selfUserId);

		// 写一条empLog
		String removeContent = operatorUser.getUserName() + "更新了"+erpFunUsers.getUserName()+"的手机号码,从" + erpFunUsers.getUserMobile() + ">>"+ userMobile;
		erpFunEmployeeLogService.insertLog(cityId, erpFunUsers.getCompId(), Const.DIC_STAFF_EDIT_EMPLOYEEDOC, removeContent,
				erpFunUsers.getArchiveId(), selfUserId, erpFunUsers.getDeptId(),
				erpFunUsers.getDeptId(), erpFunUsers.getUserPosition(), erpFunUsers.getUserPosition(),
				erpFunUsers.getGrId(), erpFunUsers.getGrId());

		// 解绑手机号
		ErpAliyunPhoneExample erpAliyunPhoneExample = new ErpAliyunPhoneExample();
		erpAliyunPhoneExample.setShardCityId(cityId);
		erpAliyunPhoneExample.createCriteria().andBindUserIdEqualTo(erpFunUsers.getUserId()).andNumberStateEqualTo((byte) 1);
		List<ErpAliyunPhone> erpAliyunPhones = erpAliyunPhoneMapper.selectByExample(erpAliyunPhoneExample);
		if(erpAliyunPhones.size() > 0) {
			ErpAliyunPhone erpAliyunPhone = erpAliyunPhones.get(0); 
			UnBindNumberParam param = new UnBindNumberParam();
			param.setBindX(erpAliyunPhone.getBindX());
			param.setCityId(cityId);
			param.setCompId(erpFunUsers.getCompId());
			param.setOperateUserId(erpFunUsers.getUserId());
			try {
				erpAliyunPhoneService.unBindNumber(param);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//解绑了再绑定同一个
			BindNumberParam bindNumberParam = new BindNumberParam();
			bindNumberParam.setCityId(cityId);
			bindNumberParam.setCompId(erpFunUsers.getCompId());
			bindNumberParam.setOperateUserId(erpFunUsers.getUserId());
			bindNumberParam.setBindX(erpAliyunPhone.getBindX());
			bindNumberParam.setBindA(userMobile);
			bindNumberParam.setUserId(erpFunUsers.getUserId());
			try {
				erpAliyunPhoneService.bindNumber(bindNumberParam);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


		// modify lcb 修改于 2020/5/25 踢人
		cacheUtil.del(Const.CacheStructure.ARCHIVE_ID_OPERATOR + archiveId);
	}

}


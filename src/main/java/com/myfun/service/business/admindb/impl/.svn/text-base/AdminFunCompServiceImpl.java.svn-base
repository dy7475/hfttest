package com.myfun.service.business.admindb.impl;

import java.math.BigDecimal;
import java.util.*;

import javax.annotation.PostConstruct;

import com.extension.framework.web.response.ResponseJson;
import com.myfun.erpWeb.common.param.DeleteCompParam;
import com.myfun.erpWeb.common.param.UpdateChileCompParam;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.session.RequestSourceConst;
import com.myfun.framework.util.StringUtil;
import com.myfun.repository.admindb.dao.*;
import com.myfun.repository.admindb.po.*;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.param.ErpFunLeaseParam;
import com.myfun.repository.erpdb.param.ErpFunSaleParam;
import com.myfun.repository.erpdb.param.ErpFunUsersParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.utils.*;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.repository.admindb.dto.AdminFunCompDto;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunCompService;

@Service
public class AdminFunCompServiceImpl extends AbstractService<AdminFunComp, Integer>implements AdminFunCompService {
	@Autowired
	private AdminFunCompMapper adminFunCompMapper;
	@Autowired
	private AdminFunDeptsMapper adminFunDeptsMapper;
	@Autowired
	private AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired
	private AdminFunUserRqsMapper adminFunUserRqsMapper;
	@Autowired
	private AdminFunUserAccountMapper adminFunUserAccountMapper;
	@Autowired
	private AdminSysParaMapper adminSysParaMapper;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private AdminFunCityMapper adminFunCityMapper;
	@Autowired
	private ErpLimiteParaMapper erpLimiteParaMapper;
	@Autowired
	private AdminFunErpUserGuideMapper adminFunErpUserGuideMapper;
	@Autowired
	private AdminCrmParasMapper adminCrmParasMapper;
	@Autowired
	private AdminCrmDeptsMapMapper adminCrmDeptsMapMapper;
	@Autowired
	private AdminFunCompNosMapper adminFunCompNosMapper;
	@Autowired
	private AdminFunDatasourceConfigMapper adminFunDatasourceConfigMapper;
	@Autowired
	private ErpFunCompMapper erpFunCompMapper;
	@Autowired
	private ErpFunOrganizationDefinitionMapper erpFunOrganizationDefinitionMapper;
	@Autowired
	private ErpFunOrganizationMapper erpFunOrganizationMapper;
	@Autowired
	private ErpCompRolesMapper erpCompRolesMapper;
	@Autowired
	private ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	private ErpUserOpersMapper erpUserOpersMapper;
	@Autowired
	private ErpFunUserManageRangeMapper erpFunUserManageRangeMapper;
	@Autowired
	private ErpSysParaMapper erpSysParaMapper;
	@Autowired
	private ErpFunBasewageMapper erpFunBasewageMapper;
	@Autowired
	private ErpFunContractCategoryMapper erpFunContractCategoryMapper;
	@Autowired
	private ErpFunDealTaxesFatherMapper erpFunDealTaxesFatherMapper;
	@Autowired
	private ErpFunDealTaxesSubMapper erpFunDealTaxesSubMapper;
	@Autowired
	private ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	private ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	private ErpFunPhoneMapper erpFunPhoneMapper;
	@Autowired
	private ErpFunAttendanceParamMapper erpFunAttendanceParamMapper;
	@Autowired
	private ErpFunEmployeeDocMapper erpFunEmployeeDocMapper;
	@Autowired
	private ErpFunWageMapper erpFunWageMapper;
	@Autowired
	private ErpFunWorkcountTargetMapper erpFunWorkcountTargetMapper;
	@Autowired
	private ErpCompRoleOpersMapper erpCompRoleOpersMapper;



	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminFunCompMapper;
	}
	
	@Override
	public Integer updateAdminFunComp(Integer brandId) {
		return adminFunCompMapper.updateAdminFunComp(brandId);
	}
	
	@Override
	public PageInfo<AdminFunCompDto> getCompManageList(String compNo, Integer openStatus, Integer type, Integer pageNum, Integer pageSize, Map<String, Object> paramMap) {
		pageNum = null == pageNum ? 1 : pageNum;
		pageSize = null == pageSize ? 50 : pageSize;
		PageHelper.startPage(pageNum, pageSize, true);
		paramMap.put("compNo", compNo);
		paramMap.put("distributeManagerFlag", openStatus);
		paramMap.put("compViewRange", type);
		return new PageInfo<AdminFunCompDto>(adminFunCompMapper.getCompManageList(paramMap));
	}

	@Override
	public Integer updateFunComp(Integer compId, Integer manageFlag) {
		AdminFunComp afc = new AdminFunComp();
		afc.setCompId(compId);
		afc.setDistributeManagerFlag(manageFlag.byteValue());
		return adminFunCompMapper.updateByPrimaryKeySelective(afc);
	}

	@Override
	public AdminFunComp getFunCompByCompId(Integer compId) {
		return adminFunCompMapper.selectByPrimaryKey(compId);
	}

	@Override
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

	@Override
	public boolean judgeRequestFromNewVersionIn930(boolean isMobileApi, String appVersionNo, String appSource, String deviceType, Integer erpVersionNo) {
		if (isMobileApi) {
			if (StringUtil.isNotBlank(appVersionNo) && StringUtil.isNotBlank(appSource) && StringUtil.isNotBlank(deviceType)) {
//				1新版掌通、4开单豹APP、5房口袋、6友邻通、8、玛雅好房
				if (RequestSourceConst.APP_SOURCE_ANDROID_API.equals(appSource) || RequestSourceConst.APP_SOURCE_IOS_API.equals(appSource)) {// 新版掌通
					if ("1".equals(deviceType)) {// android
						return Integer.parseInt(appVersionNo.replaceAll("\\.", "")) >= 100;
					} else {// ios
						return Integer.parseInt(appVersionNo.replaceAll("\\.", "")) >= 100;
					}
				}
			} else {
				return false;
			}
		}
		return false;
	}

    @Override
	@Transactional
    public String createSubComp(AdminFunComp adminFunComp, AdminFunDepts adminFunDepts)  throws Exception {

		Date date = new Date();
		AdminFunArchive archive = null;
		Integer userId = null;
		Integer archiveId = null;
		Integer deptId = null;
		Integer erpCompId = null;
		archive = adminFunArchiveMapper.getArchiveByMobile(adminFunDepts.getContactPhone());

		if (archive != null) {
			archiveId = archive.getArchiveId();
			Integer userEdition = archive.getUserEdition();
			if (userEdition != null && userEdition != 2) {
				return "HAS"; // 新开库不能是已经注册门店版的用户
			} else {
				int cityId = archive.getCityId();
				if (cityId != adminFunDepts.getCityId()) {
					return "CITY"; // 该用户注册城市与开库城市不在同一城市
				}
			}
			// 如果当前用户已实名认证 则自动通过资质认证
			Integer userRight = archive.getUserRight();
			if (userRight == 1) {
				AdminFunArchive funArchive = new AdminFunArchive();
				funArchive.setArchiveId(archiveId);
				funArchive.setUserHonest(1);
				funArchive.setCompName(adminFunComp.getCompName());
				adminFunArchiveMapper.updateByPrimaryKeySelective(funArchive);
				// 更新请求信息
				AdminFunUserRqs funUserRqs = new AdminFunUserRqs();
				funUserRqs.setArchiveId(archiveId);
				funUserRqs.setRqsAptitudeStatus(1);
				funUserRqs.setRqsAptitudeDesc("恭喜！你的实名认证已通过。");
				funUserRqs.setRqsAptitudeTime(new Date());
				adminFunUserRqsMapper.updateByPrimaryKeySelective(funUserRqs);
			}
		}
		// 如果不存在则新建一个精英版账户
		Object[] value = null;
		if (archive == null) {
			value = this.registerPersonal(adminFunDepts);
			if (value == null) {
				throw new RuntimeException("注册发生错误，请稍后重试！");
			}
			archiveId = (Integer) value[0];
			userId = (Integer) value[1];
		}

		adminFunComp.setOrganizationType(1);//表示新组织架构
		adminFunComp.setCompDepts(1);
		adminFunComp.setFirstIn(0);
		adminFunComp.setGeneralArchive(archiveId);
		adminFunComp.setStoreNo(adminFunDepts.getDeptTele());
		adminFunComp.setIsVip((byte) 0);
		adminFunComp.setCompType(adminFunDepts.getDeptType());
		adminFunComp.setDeptStatus(Const.getDeptCustStatus.DIC_DEPT_FLAG_FORMAL);

		// 门店
		adminFunDepts.setStoreTimeBeg(date);
		adminFunDepts.setStoreTimeEnd(DateUtil.StringToDate("2020-12-31"));
		adminFunDepts.setTransFlag(false);
		adminFunDepts.setTryFlag(date);
		adminFunDepts.setSrvStatus((byte) 0);
		adminFunDepts.setCionGift((byte) 0);
		adminFunDepts.setTrainCount((byte) 0);
		adminFunDepts.setPrivateCount((byte) 0);
		adminFunDepts.setRedFlag((byte) 0);
		adminFunDepts.setOrangeFlag((byte) 0);
		if (adminFunDepts.getDeptType() == 100) {
			adminFunDepts.setAgentFlag(true);
		} else {
			adminFunDepts.setAgentFlag(false);
		}

		adminFunDepts.setDeptStatus(Const.getDeptCustStatus.DIC_CUST_STATUS_FORMAL);
		adminFunDepts.setDeptFlag(2);
		adminFunDepts.setOtoEnd(DateUtil.addDay(date, 99999));
		adminFunDepts.setSpaceEnd(DateUtil.addDay(date, 99999));
		adminFunDepts.setFormTime(date);
		adminFunDepts.setSuperStart(date);
		adminFunDepts.setSuperEnd(DateUtil.addDay(date, 7));


		AdminCrmParasKey crmParasKey = new AdminCrmParasKey();
		crmParasKey.setParamId("INSTALL_LICENSE");
		crmParasKey.setCompId(1);
		String installLicense = adminCrmParasMapper.selectCrmParaValue(crmParasKey).getParamValue();
		adminFunDepts.setInstallCount(com.myfun.utils.StringUtil.parseInteger(installLicense));
		adminFunDepts.setInstallLicense(com.myfun.utils.StringUtil.parseInteger(installLicense));
		adminFunDepts.setScoreFlag(new Byte("1"));
		adminFunDepts.setDeptLevel("A");

		// 更新地图标记
		AdminCrmDeptsMap crmDeptsMap = new AdminCrmDeptsMap();
		crmDeptsMap.setCityId(adminFunDepts.getCityId());
		crmDeptsMap.setDeptName(adminFunDepts.getDeptName());
		crmDeptsMap.setDeptAddr(adminFunDepts.getDeptAddr());
		crmDeptsMap.setDeptContact(adminFunDepts.getDeptContact());
		crmDeptsMap.setDeptTele(adminFunDepts.getDeptTele());
		crmDeptsMap.setContactPhone(adminFunDepts.getContactPhone());
		crmDeptsMap.setDeptFlag(1); // 门店标记 1-试用
		crmDeptsMap.setDeptDescrip(adminFunDepts.getDeptDesc());
		crmDeptsMap.setUpdateUid(999);
		crmDeptsMap.setUpdateTime(date);
		// 0 =好房通Link. 1=好房通Pro. -1=赢销版 2=纯个人版 USER_EDITION(精英版)
		// 1:企业 2:专业 3:营销版 0:精英版 DEPT_TYPE
		Integer deptType = (int) adminFunDepts.getDeptType();
		Integer userEdition = 0;
		AdminFunArchive funArchive = new AdminFunArchive();
		funArchive.setArchiveId(archiveId);
		funArchive.setUserEdition(userEdition);
		funArchive.setUserAddress(adminFunDepts.getDeptAddr());
		// 本地库公司表
		KeyBean keyBean = new KeyBean();
		ErpFunComp erpFunComp = new ErpFunComp();
		erpFunComp.setMainComp(adminFunComp.getMainComp());
		erpFunComp.setShardCityId(adminFunDepts.getCityId());
		erpFunComp.setInstallPwd(keyBean.getkeyBeanofStr(adminFunDepts.getPwdDesc()));
		erpFunComp.setCityId(adminFunDepts.getCityId().shortValue());
		erpFunComp.setCompName(adminFunComp.getCompName());
		erpFunComp.setCompCname(adminFunComp.getCompCname());
		erpFunComp.setCompAddr(adminFunComp.getCompAddr());
		erpFunComp.setCompTele(adminFunComp.getCompTele());
		erpFunComp.setCompContact(adminFunComp.getCompContact());
		erpFunComp.setPlaintPwd(adminFunDepts.getPwdDesc());
		erpFunComp.setCompDesc(adminFunDepts.getDeptDesc());
		erpFunComp.setRegistFlag(false);
		erpFunComp.setCompType(adminFunDepts.getDeptType());
		erpFunComp.setPlotSwitch(false);
		erpFunComp.setAreaFlag((byte) 0);
		erpFunComp.setStoreNo(adminFunComp.getCompTele());
		erpFunComp.setUpdateTime(DateUtil.DateToString(date, "yyyy-MM-dd HH:mm:ss"));
		erpFunComp.setUpdateUid(999);
		// 本地库门店表
		ErpFunDepts erpFunDepts = new ErpFunDepts();
		erpFunDepts.setShardCityId(adminFunDepts.getCityId());
		erpFunDepts.setRegionId(adminFunDepts.getRegionId());
		erpFunDepts.setSeqNo(1);
		erpFunDepts.setDeptName(adminFunDepts.getDeptName());
		erpFunDepts.setDeptCname(adminFunDepts.getDeptCname());
		if (deptType == 1 || deptType == 6) {
			erpFunDepts.setRoamNum((byte) 1);
		} else {
			erpFunDepts.setRoamNum((byte) 0);
		}
		erpFunDepts.setDeptAddr(adminFunDepts.getDeptAddr());
		erpFunDepts.setDeptTele(adminFunDepts.getDeptTele());
		erpFunDepts.setDeptContact(adminFunDepts.getDeptContact());
		erpFunDepts.setDeptDesc(adminFunDepts.getDeptDesc());
		erpFunDepts.setDeptType(adminFunDepts.getDeptType());
		erpFunDepts.setDeptFlag(2);
		erpFunDepts.setCustLevel((byte) 0);
		erpFunDepts.setUpdateTime(DateUtil.DateToString(date, "yyyy-MM-dd HH:mm:ss"));
		erpFunDepts.setUpdateUid(999);
		// 本地库用户信息表
		ErpFunUsers erpFunUsers = new ErpFunUsers();
		erpFunUsers.setShardCityId(adminFunDepts.getCityId());
		erpFunUsers.setCityId(adminFunDepts.getCityId().shortValue());
		erpFunUsers.setUserEdition(userEdition);
		erpFunUsers.setUserRoam(true);
		erpFunUsers.setWageFlag(true);
		erpFunUsers.setAlldeptFlag(true);
		erpFunUsers.setUserJobDate(DateUtil.DateToString(date, "yyyy-MM-dd HH:mm:ss"));
		erpFunUsers.setUserPosition("GENERAL_MANAGER");
		erpFunUsers.setCreationTime(new Date());
		if (adminFunDepts.getContactSex() != null) {
			erpFunUsers.setUserSex(adminFunDepts.getContactSex() == 1);
		}
		if (userId == null) {
			ErpFunUsers funUsers = erpFunUsersMapper.selectByArchiveId(archiveId);
			if (funUsers != null) {
				if (funUsers != null) {
					userId = funUsers.getUserId();
				}
			} else {
				return "未在本地库查找到用户 \"" + adminFunDepts.getDeptContact() + "\" 信息！";
			}
		}
		if (archiveId == null) {
			throw new RuntimeException("error_1");
		}
		boolean hasException = false;


		/*** 开库存储过程admin***/
		String compDeptNoUserNum = "";
		try {
			compDeptNoUserNum = this.procCreateComp(adminFunComp, adminFunDepts, adminFunComp.getCompId(), adminFunDepts.getDeptId(), null);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("生成编号时出错");
		}
		String[] values = compDeptNoUserNum.split("\\|");
		String erpCompNo = values[0];
		String erpDeptNo = values[1];
		String userNum = values[2];
		if (com.myfun.utils.StringUtil.isEmpty(erpCompNo) || com.myfun.utils.StringUtil.isEmpty(erpCompNo)) {
			throw new RuntimeException("公司门店编号生成失败！");
		}

		adminFunCompMapper.insertSelective(adminFunComp);
		adminFunDepts.setCompId(adminFunComp.getCompId());
		adminFunDeptsMapper.insertSelective(adminFunDepts);
		/***更新admin FUN_COMP***/
		adminFunCompMapper.updateByPrimaryKeySelective(adminFunComp);
		/*** 更新admin FUN_DEPTS***/
		adminFunDeptsMapper.updateByPrimaryKeySelective(adminFunDepts);
		/*** 更改当前用户的FUN_ARCHIVE USER_EDITION ***/
		adminFunArchiveMapper.updateByPrimaryKeySelective(funArchive);
		/***更新admin CRM_DEPTS_MAP地图标记***/
		crmDeptsMap.setDeptId(adminFunDepts.getDeptId());
		adminCrmDeptsMapMapper.updateByDeptId(crmDeptsMap);


		// 新建公司 erp 库
		erpFunComp.setCompNo(erpCompNo);
		erpFunComp.setCompId(adminFunComp.getCompId());
		//erpFunCompMapper.insertSelective(erpFunComp); jsg 注释
		erpFunCompMapper.insertSelectiveNew(erpFunComp);
		erpCompId = erpFunComp.getCompId();


		// 创建公司链接
		AdminFunDatasourceConfig compConfig = adminFunDatasourceConfigMapper.selectByPrimaryKey(adminFunComp.getCompId());
		AdminFunDatasourceConfig config = adminFunDatasourceConfigMapper.selectByPrimaryKey(adminFunDepts.getCityId());
		config.setCompId(adminFunComp.getCompId());
		if (compConfig == null) {
			adminFunDatasourceConfigMapper.insertSelective(config);
		} else {
			adminFunDatasourceConfigMapper.updateByPrimaryKeySelective(config);
		}

		Integer organizationId = adminFunDeptsMapper.GetOrganizationId();
		//1.初始化组织层级
		//2.初始化一个第一级的组织
		//3.更新总经理ERP库的FUN_USERS拓展字段
		//初始化组织层级
		Integer levelOneId = this.creationCompOrganizationDefinition(adminFunDepts.getCityId(), erpCompId,1);
		//初始化组织-城市级
		ErpFunOrganization organizationByOne = new ErpFunOrganization();
		organizationByOne.setShardCityId(adminFunDepts.getCityId());
		organizationByOne.setOrganizationId(adminFunDepts.getDeptId());
		organizationByOne.setOrganizationNo("D1");
		organizationByOne.setCityId(adminFunDepts.getCityId());
		organizationByOne.setCompId(erpCompId);
		organizationByOne.setPid(0);
		organizationByOne.setOrganizationName(adminFunDepts.getDeptName());//组织名称
		organizationByOne.setDelFlag((byte) 0);//是否删除
		organizationByOne.setOrganizationDefinitionId(levelOneId);//组织层级ID
		organizationByOne.setContactNumber(adminFunDepts.getContactPhone());//组织联系电话 组织公盘房客源展示使用
		organizationByOne.setOrganizationAddr(adminFunDepts.getDeptAddr());//地址
		organizationByOne.setCreationTime(new Date());
		organizationByOne.setOrganizationSeq(1);//序号
		organizationByOne.setOrganizationUserNum(1);//人数
		erpFunOrganizationMapper.insertSelectiveNew(organizationByOne);

		//反更新组织上面的综合查询字段
		organizationByOne.setShardCityId(adminFunDepts.getCityId());
		organizationByOne.setOrganizationPath(":" + organizationByOne.getOrganizationId() + ":");//综合查询字段
		erpFunOrganizationMapper.updateByPrimaryKeySelectiveNew(organizationByOne);
		//更新总经理ERP库的FUN_USERS拓展字段
		erpFunUsers.setOrg1(organizationByOne.getOrganizationId());
		erpFunUsers.setOrganizationId(organizationByOne.getOrganizationId());
		// 新建公司角色
		ErpCompRoles erpCompRoles = erpCompRolesMapper.getByCompId(adminFunDepts.getCityId(), erpCompId);
		if (erpCompRoles == null) {
			erpFunCompMapper.insertCompRoles(adminFunDepts.getCityId(), erpCompId);
		}
		// 新建分店
		erpFunDepts.setCompId(erpCompId);
		erpFunDepts.setDeptId(adminFunDepts.getDeptId());//admin序列
		erpFunDepts.setDeptNo(erpDeptNo);
		erpFunDepts.setCompNo(erpCompNo);
		String contractVersion = adminSysParaMapper.selectByPrimaryKey("ERP_SYSTEM_DEPT_USER_NUM").getParamValue();
		erpFunDepts.setUserNum(com.myfun.utils.StringUtil.parseInteger(contractVersion)); // @by XIONG CAI 2018-04-19试用开库账号数量修改为20个         2018-08-17改为系统参数默认
		erpFunDepts.setDeptCode(Pinyin4jUtil.converterToFirstSpell(adminFunDepts.getDeptName()));
		if (erpFunDepts.getDeptCode().length() >= 30) {
			throw new RuntimeException("门店名称超长！");
		}
		erpFunDepts.setUserNum(9999);
		erpFunDeptsMapper.insertSelectiveNew(erpFunDepts);
		deptId = erpFunDepts.getDeptId();
		/**** 初始化门店合同模版 ***/
		erpFunDeptsMapper.importFunContractTemplae(erpFunDepts.getCompId(), adminFunDepts.getCityId());
		// 更新用户信息
		erpFunUsers.setCompId(erpCompId);
		erpFunUsers.setDeptId(deptId);
		erpFunUsers.setUserPosition("GENERAL_MANAGER");
		erpFunUsers.setUserId(userId);
		erpFunUsers.setUserName(funArchive.getUserName());
		erpFunUsers.setUpdateTime(DateUtil.DateToString(new Date(),"yyyy-MM-dd HH:mm:ss"));
		// 房基地定制
		AdminFunComp adminFunCompModel = adminFunCompMapper.selectByPrimaryKey(adminFunComp.getCompId());

		//设置用户层级
		erpFunUsers.setUserLevel(1);
		erpFunUsers.setTissueLine(":"+organizationByOne.getOrganizationId()+":");
		erpFunUsers.setOrganizationId(organizationByOne.getOrganizationId());
		erpFunUsersMapper.updateByPrimaryKeySelective(erpFunUsers);
		// 总经理权限
		erpUserOpersMapper.deleteByUserId(adminFunDepts.getCityId(), userId);
		erpUserOpersMapper.insertUserOpperNew(adminFunDepts.getCityId(), userId, deptType,1);
		//修改总经理权限的新版组合权限的层级ID为0
		erpUserOpersMapper.updateUserOpperDefId(adminFunDepts.getCityId(), userId);
		/*** 初始化总经理范围 ***/
		erpFunUserManageRangeMapper.initGeneralManagerange(erpFunUsers.getCityId(), erpFunUsers.getUserId(), erpFunUsers.getCompId());
		/*** 如果该公司之前进行过关店操作，需要先清除erp库的SYS_PARA参数 ***/
		erpSysParaMapper.deleteByCompId(adminFunDepts.getCityId(), erpCompId);
		/* 系统参数 */
		//先初始化公司系统参数
		erpSysParaMapper.insertSysParaComp(adminFunDepts.getCityId(), erpCompId);
		//1.查询出特定的参数，判断值是否是6，因为老版组织架构6代表个人，新版-2代表个人，需要更新6的参数值为-2
		List<ErpSysPara> sysParams = erpSysParaMapper.selectByParamIds(adminFunDepts.getCityId(), erpCompId,this.initializeParamIds("2",null));
		this.switchValues(adminFunDepts.getCityId(),erpCompId,sysParams);
		//2.插入新增的新版组合参数
		this.insertNewOrgSys(adminFunDepts.getCityId(), erpCompId);
		//3.转换几个范围参数，因为模板初始化是level，下面的代码就是把lavel转换为层级ID
		//把范围默认值(level)转换为层级ID
		erpSysParaMapper.updateSysParaLevelToDefId(adminFunDepts.getCityId(), erpCompId,this.initializeParamIds("1","A."));

		// 1:企业 2:专业 3:营销版 0:精英版 DEPT_TYPE
		// 如果是专业版，系统参数：各类信息必须进入“抢盘”状态后方可注销 默认为“否”,是否允许录入电话
		for (int i = 0; i <= 7; i++) {
			ErpSysPara erpSysPara = new ErpSysPara();
			erpSysPara.setShardCityId(adminFunDepts.getCityId());
			erpSysPara.setCompId(erpCompId);
			if (i == 0) {
				erpSysPara.setParamId("FUN_PROVINCE");
				erpSysPara.setParamValue(adminFunDepts.getProvinceId().toString());
				erpSysPara.setDefaultValue(adminFunDepts.getProvinceId().toString());
			} else if (i == 1) {
				erpSysPara.setParamId("FUN_CITY");
				erpSysPara.setParamValue(adminFunDepts.getCityId().toString());
				erpSysPara.setDefaultValue(adminFunDepts.getCityId().toString());
			} else if (i == 2) {
				erpSysPara.setParamId("COMP_NO");
				erpSysPara.setParamValue(erpCompNo);
				erpSysPara.setDefaultValue(erpCompNo);
			} else if (i == 3) {
				erpSysPara.setParamId("COMP_NAME");
				erpSysPara.setParamValue(adminFunDepts.getDeptName());
				erpSysPara.setDefaultValue(adminFunDepts.getDeptName());
			} else if (i == 4) {
				erpSysPara.setParamId("DEPT_NAME");
				erpSysPara.setParamValue(adminFunDepts.getDeptName());
				erpSysPara.setDefaultValue(adminFunDepts.getDeptName());
			} else if (i == 5) {
				erpSysPara.setParamId("DEPT_NO");
				erpSysPara.setParamValue(erpDeptNo);
				erpSysPara.setDefaultValue(erpDeptNo);
			} else if (i == 6) {
				if (deptType == 2 || deptType == 3 || deptType == 4) {
					erpSysPara.setParamId("ALLOW_INPUT_PHONE");
					erpSysPara.setParamValue("0");
					erpSysPara.setDefaultValue("0");
				} else {
					erpSysPara.setParamId("FAFA_VEIW_RANGE");
					erpSysPara.setParamValue("3");
					erpSysPara.setDefaultValue("3");
				}
			} else if (i == 7) {
				erpSysPara.setParamId("FAFA_VEIW_RANGE");
				erpSysPara.setParamValue("3");
				erpSysPara.setDefaultValue("3");
			}
			erpSysParaMapper.updateSysParaComp(erpSysPara);
		}
		if(adminFunDepts.getDeptType() == 1){
			AdminFunErpUserGuide adminFunErpUserGuide = new AdminFunErpUserGuide();
			adminFunErpUserGuide.setArchiveId(archiveId);
			adminFunErpUserGuide.setCreationTime(date);
			adminFunErpUserGuide.setStatus((byte) 0);
			adminFunErpUserGuide.setGuideType(11);
			adminFunErpUserGuideMapper.insertSelective(adminFunErpUserGuide);
		}


		// 先删除后插入
		ErpFunBasewage erpFunBasewage = new ErpFunBasewage();
		erpFunBasewage.setShardCityId(adminFunDepts.getCityId());
		erpFunBasewage.setUserId(userId);
		erpFunBasewageMapper.deleteByPrimaryKey(erpFunBasewage);
		ErpFunBasewage basewage = new ErpFunBasewage();
		basewage.setShardCityId(adminFunDepts.getCityId());
		basewage.setUserId(userId);
		basewage.setCompId(erpCompId);
		basewage.setDeptId(deptId);
		basewage.setBaseMoney(0);
		// basewage.setWagetypeId(0);
		erpFunBasewageMapper.insertSelective(basewage);
		// 调用开库附加逻辑
		if (!tryBeginPostProcess(adminFunDepts.getCityId(), erpCompId, false)) {
			throw new RuntimeException("试用开库执行附加逻辑出错");
		}
		// 如果是精英版开库转门店版 则更新所有的业务数据
		if (archive != null && !hasException) {
			/**更新出售房源数据**/
			ErpFunSaleParam erpFunSale = new ErpFunSaleParam();
			erpFunSale.setShardCityId(adminFunDepts.getCityId());
			erpFunSale.setUserId(userId);
			erpFunSale.setArchiveId(archiveId);
			erpFunSale.setCompId(erpCompId);
			erpFunSale.setDeptId(deptId);
			erpFunSaleMapper.updateByArchiveIdAndUserId(erpFunSale);
			//更新出租房源数据
			ErpFunLeaseParam erpFunLease = new ErpFunLeaseParam();
			erpFunLease.setShardCityId(adminFunDepts.getCityId());
			erpFunLease.setUserId(userId);
			erpFunLease.setArchiveId(archiveId);
			erpFunLease.setCompId(erpCompId);
			erpFunLease.setDeptId(deptId);
			erpFunLeaseMapper.updateByArchiveIdAndUserId(erpFunLease);
			// 更新funPhone信息
			ErpFunPhoneExample erpFunPhoneExample = new ErpFunPhoneExample();
			erpFunPhoneExample.createCriteria().andUserIdEqualTo(userId);
			ErpFunPhone erpFunPhone = new ErpFunPhone();
			erpFunPhone.setCompId(erpCompId);
			erpFunPhone.setDeptId(deptId);
			erpFunPhoneMapper.updateByExampleSelectiveForCityId(erpFunPhone, erpFunPhoneExample, adminFunDepts.getCityId());
			/**更新ERP库经纪人信息**/
			ErpFunUsersParam users = new ErpFunUsersParam();
			users.setShardCityId(adminFunDepts.getCityId());
			users.setUserId(userId);
			users.setCompId(erpCompId);
			users.setDeptId(deptId);
			users.setArchiveId(archiveId);
			users.setDeptName(adminFunDepts.getDeptName());
			erpFunUsersMapper.updateRelevantBusiness(users);
		}
		// 初始化erp门店坐标
		// 添加考勤扣款配置
		erpFunAttendanceParamMapper.addDataList(adminFunDepts.getCityId(), erpFunComp.getCompId());
		// 员工档案表
		ErpFunEmployeeDoc erpFunEmployeeDoc = new ErpFunEmployeeDoc();
		erpFunEmployeeDoc.setShardCityId(adminFunDepts.getCityId());
		erpFunEmployeeDoc.setCompId(erpFunComp.getCompId());
		erpFunEmployeeDoc.setArchiveId(archiveId);
		erpFunEmployeeDoc.setCreationTime(new Date());
		erpFunEmployeeDoc.setUpdateTime(new Date());
		erpFunEmployeeDoc.setUserId(userId);
		erpFunEmployeeDoc.setUserJobDate(date);
		erpFunEmployeeDocMapper.insertSelective(erpFunEmployeeDoc);
		/**************** ERP初始化开库数据-start*******************/
		/*** 初始化薪资表**/
		String assessMentMonth = this.getAssessMentMonth(null, 0);
		ErpFunWage erpFunWage = new ErpFunWage();
		erpFunWage.setCompId(erpFunUsers.getCompId());
		erpFunWage.setDeptId(erpFunUsers.getDeptId());
		erpFunWage.setProfitWage(new BigDecimal(0));
		erpFunWage.setWageMoney(new BigDecimal(0));
		erpFunWage.setDelWage(new BigDecimal(0));
		erpFunWage.setUserId(erpFunUsers.getUserId());
		erpFunWage.setCreateDate(DateUtil.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
		erpFunWage.setAssessmentMonth(assessMentMonth);
		erpFunWage.setShardCityId(erpFunUsers.getCityId().intValue());
		erpFunWageMapper.insertSelective(erpFunWage);
		ErpFunWorkcountTarget erpFunWorkcountTarget = new ErpFunWorkcountTarget();
		erpFunWorkcountTarget.setArchiveId(archiveId);
		erpFunWorkcountTarget.setCompId(erpFunUsers.getCompId());
		erpFunWorkcountTarget.setUserId(erpFunUsers.getUserId());
		erpFunWorkcountTarget.setTargetType((byte) 1);
		erpFunWorkcountTarget.setCreateTime(new Date());
		erpFunWorkcountTarget.setShardCityId(erpFunUsers.getCityId().intValue());
		erpFunWorkcountTargetMapper.insertSelective(erpFunWorkcountTarget);
		ErpFunWorkcountTarget workcountTarget = new ErpFunWorkcountTarget();
		workcountTarget.setArchiveId(archiveId);
		workcountTarget.setCompId(erpFunUsers.getCompId());
		workcountTarget.setUserId(erpFunUsers.getUserId());
		workcountTarget.setTargetType((byte) 2);
		workcountTarget.setCreateTime(new Date());
		workcountTarget.setShardCityId(erpFunUsers.getCityId().intValue());
		erpFunWorkcountTargetMapper.insertSelective(workcountTarget);
		String param = erpSysParaMapper.getParamByCompNo(erpFunUsers.getCityId().intValue(), erpFunDepts.getCompNo(), "PAYROLL_SETTLEMENT_TYPE");
		if (com.myfun.utils.StringUtil.isEmpty(param)) {
			erpSysParaMapper.insertWageTypeForComp(erpFunUsers.getCityId(), erpFunUsers.getCompId());
		}

		/*** 门店参数初始化 【权限】***/
		this.deleteCompRoleOpersByCompId(adminFunDepts.getCityId(), erpCompId, Integer.valueOf(adminFunDepts.getDeptType()),true);

		/******************* ERP初始化开库数据-end*************/
		return "OK";
    }

	@Override
	public String updateCompInfo(UpdateChileCompParam param) {
		ErpFunComp erpFunComp = erpFunCompMapper.selectByCompId(param.getCityId(), param.getCompId());
		if (erpFunComp == null) {
			return "该公司不存在";
		}
		AdminFunComp upFunComp = new AdminFunComp();
		upFunComp.setCompName(param.getCompName());
		upFunComp.setCompCname(param.getCompName());
		upFunComp.setCompAddr(param.getContactAddress());
		upFunComp.setCompTele(param.getContactPhoneNumber());
		upFunComp.setCompContact(param.getUserName());
		upFunComp.setContactPhone(param.getContactPhoneNumber());
		ErpFunComp upErpFunComp = new ErpFunComp();
		upErpFunComp.setCompName(param.getCompName());
		upErpFunComp.setCompCname(param.getCompName());
		upErpFunComp.setCompAddr(param.getContactAddress());
		upErpFunComp.setCompTele(param.getContactPhoneNumber());
		upErpFunComp.setCompContact(param.getUserName());
		upErpFunComp.setCompNo(erpFunComp.getCompNo());
		upErpFunComp.setShardCompNo(erpFunComp.getCompNo());

		AdminFunComp funComp = adminFunCompMapper.selectByCompNo(erpFunComp.getCompNo());
		upFunComp.setCompId(funComp.getCompId());
		if (funComp == null) {
			return "该公司不存在";
		}
		ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByArchiveId(funComp.getGeneralArchive());
		if (erpFunUsers == null) {
			return "总经理不存在";
		}
		ErpFunUsers newFunUsers = erpFunUsersMapper.selectByUserId(param.getCityId(), param.getUserId());
		if (newFunUsers == null) {
			return "新总经理不存在";
		}
		if (newFunUsers.getUserWriteoff()) {
			return "员工已离职";
		}
		if (!erpFunUsers.getCompId().equals(newFunUsers.getCompId())) {
			return "两人不在同一公司";
		}

		adminFunCompMapper.updateByPrimaryKeySelective(upFunComp);
		erpFunCompMapper.updateByCompNo(upErpFunComp);
		int res = erpFunCompMapper.proc_AlterGeneralmanager(erpFunComp.getCompNo(), erpFunComp.getCompNo(), erpFunUsers.getUserId(), newFunUsers.getUserId(), 999);
		if (res == 1) {
			return "OK";
		} else {
			return "更换总经理失败，请联系客服";
		}
	}


	private Object[] registerPersonal(AdminFunDepts adminFunDepts) throws Exception {
		Date date = new Date();
		// 检测资金账户如果没有则创建资金账户
		AdminFunUserAccount account = adminFunUserAccountMapper.selectByUserMoblie(adminFunDepts.getContactPhone());
		Integer uaId = null;
		AdminSysPara sysPara = adminSysParaMapper.selectByPrimaryKey("GIVE_HAOFANG_QUAN_NUM");
		if (account != null) {
			int uaCount = adminFunArchiveMapper.countArchiveByUaId(account.getUaId());	//判断资金账户是否绑定了经纪人，如果未绑定，那就绑定在这个号码上，如果已绑定，那就资金账户为空
			if (uaCount == 0) {
				uaId = account.getUaId();
			}
		} else {
			AdminFunUserAccount funUserAccount = new AdminFunUserAccount();
			funUserAccount.setUserMobile(adminFunDepts.getContactPhone());
			funUserAccount.setEnable(true);
			funUserAccount.setBalance(new BigDecimal(0.00));
			funUserAccount.setAmount(new BigDecimal(0.00));
			funUserAccount.setConsumpt(new BigDecimal(0.00));
			funUserAccount.setScores(0);
			funUserAccount.setCityId(adminFunDepts.getCityId().shortValue());
			funUserAccount.setUaType((byte) 2);
			// funUserAccount.setHaofangAmount(new BigDecimal(sysPara == null ? 0 :
			// StringUtil.parseInteger(sysPara.getParamValue())));
			funUserAccount.setHaofangAmount(new BigDecimal(0));
			funUserAccount.setHighAmount(new BigDecimal(2));
			funUserAccount.setAmountSmslock(new BigDecimal(0));
			funUserAccount.setUsedCompHf(new BigDecimal(0));
			funUserAccount.setHaofangAmountTicket(new BigDecimal(0));
			adminFunUserAccountMapper.insertSelective(funUserAccount);
			uaId = funUserAccount.getUaId();
		}
		AdminFunArchive adminFunArchive = new AdminFunArchive();
		adminFunArchive.setUaId(uaId);
		adminFunArchive.setValidAccount((byte) 1);
		adminFunArchive.setUserName(adminFunDepts.getDeptContact());
		adminFunArchive.setUserSex((adminFunDepts.getContactSex() == null ? null : adminFunDepts.getContactSex().byteValue()));
		adminFunArchive.setUserMobile(adminFunDepts.getContactPhone());
		adminFunArchive.setUserQq(adminFunDepts.getContactQq());
		adminFunArchive.setCityId(adminFunDepts.getCityId().shortValue());
		adminFunArchive.setProvinceId(adminFunDepts.getProvinceId());
		adminFunArchive.setServiceReg(" " + adminFunDepts.getRegionId() + " ");
		// adminFunArchive.setServiceZone(adminFunDepts.getRegionId() + "");
		adminFunArchive.setCreationTime(date);
		adminFunArchive.setSuperUser(0);
		adminFunArchive.setSuperStart(date);
		adminFunArchive.setSuperEnd(date);
		adminFunArchive.setSuperDays(0);
		adminFunArchive.setUserRight(0);
		adminFunArchive.setUserHonest(0);
		adminFunArchive.setNickName("好房达人");
		adminFunArchive.setUserEdition(2);
		adminFunArchive.setUserBidding(0);
		adminFunArchive.setHouseBidding(0);
		adminFunArchive.setMobileValided((byte) 1);
		adminFunArchive.setWebstoreStatus(1);
		adminFunArchive.setFriendFlag(1);
		adminFunArchive.setRegFrom((byte) 3);
		adminFunArchive.setSellComp(1);
		adminFunArchive.setSellId(999);
		adminFunArchive.setLastTrackTime(new Date());
		adminFunArchiveMapper.insertSelective(adminFunArchive);


		AdminFunArchive funArchive = adminFunArchiveMapper.selectByMobile(adminFunDepts.getContactPhone());



		// 创建用户记录
		ErpFunUsers erpFunUsers = new ErpFunUsers();
		int userId = erpFunUsersMapper.selectSeqUserId(adminFunDepts.getCityId());
		String userNo = generatorUserNo(adminFunDepts.getCityId(), userId);
		erpFunUsers.setShardCityId(adminFunDepts.getCityId());
		erpFunUsers.setUserId(userId);
		erpFunUsers.setUserNo(userNo);
		erpFunUsers.setArchiveId(funArchive.getArchiveId());
		erpFunUsers.setCityId(adminFunDepts.getCityId().shortValue());
		erpFunUsers.setCompId(adminFunDepts.getCityId());
		erpFunUsers.setDeptId(adminFunDepts.getCityId());
		erpFunUsers.setUserName(adminFunDepts.getDeptContact());
		erpFunUsers.setLoginUserid(adminFunDepts.getContactPhone());
		erpFunUsers.setLoginPassword("f9a7b11de7f38a166504bfd6eec7be43");
		erpFunUsers.setUserSex(Boolean.parseBoolean(adminFunDepts.getContactSex() == null ? "0" : adminFunDepts.getContactSex().toString()));
		erpFunUsers.setUserPosition("COMMON_BIZ");
		erpFunUsers.setUserMobile(adminFunDepts.getContactPhone());
		erpFunUsers.setUserStatus((byte) 1);
		erpFunUsers.setUserWriteoff(false);
		erpFunUsers.setUserEdition(2);
		erpFunUsers.setUpdateTime(DateUtil.DateToString(date, "yyyy-MM-dd HH:mm:ss"));
		erpFunUsers.setTissueLine(":"+userId+":");
		erpFunUsersMapper.insertSelectiveNotSeq(erpFunUsers);

		// 查询是否存在记录 如果没有则新建
		ErpLimitePara limitePara = new ErpLimitePara();
		limitePara.setShardCityId(adminFunDepts.getCityId());
		limitePara.setSaleCoopView(0);
		limitePara.setLeaseCoopView(0);
		limitePara.setDaySaleCoop(0);
		limitePara.setDayLeaseCoop(0);
		limitePara.setLimiteDate(date);
		limitePara.setArchiveId(funArchive.getArchiveId());
		erpLimiteParaMapper.insertSelective(limitePara);

		/********** 初始化用户引导记录 ***********/
		AdminFunErpUserGuide insertModel = new AdminFunErpUserGuide();
		insertModel.setArchiveId(funArchive.getArchiveId());
		insertModel.setCreationTime(new Date());
		insertModel.setStatus((byte) 0);
		// 引导类型，1=房源管理 2=客源管理 3=好房搜搜 4=好房发发 5=好房推广 6=组织机构 7=权限配置 8=系统参数
		// 新建经纪人默认引导这几种
		String[] guideType = new String[] { "1", "2", "3", "4", "6", "7", "8" };
		for (String type : guideType) {
			insertModel.setGuideType(com.myfun.utils.StringUtil.parseInteger(type));
			adminFunErpUserGuideMapper.insertSelective(insertModel);
		}

		return new Object[] { funArchive.getArchiveId(), userId };
	}

	public String generatorUserNo(Integer cityId, Integer userId) throws Exception {
		String cityCode = adminFunCityMapper.selectByPrimaryKey(cityId.shortValue()).getCompNo();
		return cityCode + String.format("%1$07d", userId);
	}

	private String procCreateComp(AdminFunComp adminFunComp, AdminFunDepts funDepts,Integer compId, Integer deptId, AdminCrmUser adminCrmUser) throws Exception {
		Integer deptType = (int) funDepts.getDeptType();
		AdminFunArchive funArchive = adminFunArchiveMapper.selectByMobile(funDepts.getContactPhone());
		if (funArchive == null) {
			throw new RuntimeException("请先注册精英版");
		}
		String compNo = adminFunCompNosMapper.selectCompNo();
		String deptNo = "D1";
		adminFunComp.setCompNo(compNo);
		adminFunCompNosMapper.updateBeUseByCompNo(compNo);
		// 获取城市参数

		int userNum = 40;
		int superDays = 30;
		Date startTime = new Date();
		// 创建资金账号
		AdminFunUserAccount userAccount = new AdminFunUserAccount();
		userAccount.setCityId(funDepts.getCityId().shortValue());
		userAccount.setUserMobile(String.valueOf(compId));
		userAccount.setAmount(new BigDecimal("0"));
		userAccount.setConsumpt(new BigDecimal("0"));
		userAccount.setEnable(true);
		userAccount.setAmountSmslock(new BigDecimal("0"));
		userAccount.setHaofangAmount(new BigDecimal("0"));
		userAccount.setHaofangBuy(new BigDecimal("0"));
		userAccount.setHaofangAmountTicket(new BigDecimal("0"));
		userAccount.setUaType((byte) 1);
		userAccount.setUsedCompHf(new BigDecimal("0"));
		userAccount.setAvailableDate(startTime);
		userAccount.setHighAmount(new BigDecimal("2"));
		userAccount.setBalance(new BigDecimal("0"));
		adminFunUserAccountMapper.insertSelective(userAccount);
		// 修改公司信息

		adminFunComp.setCompNo(compNo);
		adminFunComp.setCompType(deptType.byteValue());
		adminFunComp.setUaId(userAccount.getUaId());
		adminFunComp.setCompId(compId);
		//adminFunCompMapper.updateByPrimaryKeySelective(funComp);
		// 修改门店信息

		funDepts.setCompNo(compNo);
		funDepts.setDeptNo(deptNo);
		funDepts.setStoreNo("");
		funDepts.setStoreTimeBeg(startTime);
		funDepts.setStoreTimeEnd(DateUtil.StringToDate("2020-12-31"));
		//depts.setDeptFlag(1);
		funDepts.setTryTime(startTime);
		funDepts.setTryEnd(DateUtil.addDay(startTime, superDays));
		funDepts.setSpuerDept((byte) 0);
		funDepts.setSuperStart(startTime);
		funDepts.setSuperEnd(DateUtil.addDay(startTime, superDays));
		//depts.setDeptType(deptType.byteValue());
		//depts.setDeptStatus(Const.getDeptCustStatus.DIC_CUST_STATUS_TRY);
		funDepts.setTrackTime(startTime);
		funDepts.setActionTime(startTime);


		return compNo + "|" + deptNo + "|" + userNum;
	}

	/**
	 * 初始化公司组织层级
	 * @return
	 */
	private Integer creationCompOrganizationDefinition(Integer cityId,Integer compId,Integer level){
		Integer levelOneId = null;
		//根据模板公司的层级初始化一个当前公司的组织层级出来，拿出第一级的层级ID返回去初始化组织
		ErpFunOrganizationDefinitionExample definitionExample = new ErpFunOrganizationDefinitionExample();
		definitionExample.setShardCityId(1);
		definitionExample.createCriteria().andCompIdEqualTo(0);
		List<ErpFunOrganizationDefinition> erpFunOrganizationDefinitions = erpFunOrganizationDefinitionMapper.selectByExample(definitionExample);
		if(null != erpFunOrganizationDefinitions && erpFunOrganizationDefinitions.size() > 0){
			for (ErpFunOrganizationDefinition erpFunOrganizationDefinition : erpFunOrganizationDefinitions) {
				ErpFunOrganizationDefinition definition = new ErpFunOrganizationDefinition();
				ConvertUtils.register(new DateConverter(null), java.util.Date.class);
				BeanUtils.copyProperties(erpFunOrganizationDefinition, definition);
				definition.setShardCityId(cityId);
				definition.setCompId(compId);
				definition.setCreationTime(new Date());
				definition.setDelFlag((byte) 0);
				erpFunOrganizationDefinitionMapper.insertSelective(definition);
				if(null != definition.getDefinitionLevel() && level == definition.getDefinitionLevel()){
					levelOneId = definition.getDefinitionId();
				}
			}
		}
		return levelOneId;
	}


	private  String initializeParamIds(String type,String petName){
		//A.PARAM_ID = 'LOOK_CUST_RANGE' OR A.PARAM_ID = 'LOOK_HOUSE_RANGE'
		String paramIds = "";
		String pName = com.myfun.utils.StringUtil.isNotEmpty(petName) ? petName : "";

		List<String> paramIdList = new ArrayList<>();
		//1的是ERP的新版组合参数需要改paramValue为层级ID，还有一般、中级、强管控这些都要转换为层级ID
		if("1".equals(type)){
			paramIdList.add("LOOK_CUST_RANGE");//列表信息显示范围  客源
			paramIdList.add("LOOK_HOUSE_RANGE");//列表信息显示范围  房源
			paramIdList.add("HOUSEDATA_MUSTBE_ONLYONE");//房源是否允许录入重复电话*
			paramIdList.add("HOUSE_REPEAT_RANGE");//房源重复数据判重范围*
			paramIdList.add("CUST_REPEAT_RANGE");//客源重复数据判重范围
			paramIdList.add("SHARE_HOUSE_RANGE");//公盘查看及可抢盘范围：房源
			paramIdList.add("SHARE_CUST_RANGE");//公盘查看及可抢盘范围：客源
			paramIdList.add("PUBLIC_HOUSE_RANGE");//抢盘查看及可抢盘范围：房源
			paramIdList.add("PUBLIC_CUST_RANGE");//抢盘查看及可抢盘范围：客源
			paramIdList.add("SHARE_CUST_CORE_DEPT_DEF_ID");
			paramIdList.add("SHARE_CUST_CORE_OTHER_DEF_ID");
			paramIdList.add("SHARE_FUN_CORE_DEPT_DEF_ID");
			paramIdList.add("SHARE_FUN_CORE_OTHER_DEF_ID");
			paramIdList.add("IPCALL_AREA_HIDEPHONE_COUNT_DEF_ID");
		} else if ("2".equals(type)){//这些需要判断如果为员工就修改为-2
			paramIdList.add("LOOK_CUST_RANGE");
			paramIdList.add("LOOK_HOUSE_RANGE");
			paramIdList.add("SHARE_HOUSE_RANGE");
			paramIdList.add("SHARE_CUST_RANGE");
			paramIdList.add("PUBLIC_HOUSE_RANGE");
			paramIdList.add("PUBLIC_CUST_RANGE");
		}
		for (String paramId : paramIdList) {
			paramIds += pName + "PARAM_ID = '" + paramId + "' OR ";
		}
		paramIds = "(" + paramIds.substring(0,paramIds.length() - 4) + ")";
		return paramIds;
	}

	private void switchValues(Integer cityId,Integer erpCompId,List<ErpSysPara> sysParams){
		List<String> paramIds = new ArrayList<>();
		List<String> defaultIds = new ArrayList<>();
		List<String> mediumIds = new ArrayList<>();
		List<String> seniorIds = new ArrayList<>();
		sysParams.stream().forEach(param -> {//循环把默认参数值为6的都拿出来放到相应的集合里面，相应更改为-2
			if("6".equals(param.getParamValue())){
				paramIds.add(param.getParamId());
			}
			if("6".equals(param.getDefaultValue())){
				defaultIds.add(param.getParamId());
			}
			if("6".equals(param.getMediumValue())){
				mediumIds.add(param.getMediumValue());
			}
			if("6".equals(param.getSeniorValue())){
				seniorIds.add(param.getSeniorValue());
			}
		});
		if(null != paramIds && paramIds.size() > 0){
			erpSysParaMapper.updateParamValues(cityId, erpCompId,paramIds);
		}
		if(null != defaultIds && defaultIds.size() > 0){
			erpSysParaMapper.updateDefaultValues(cityId, erpCompId,defaultIds);
		}
		if(null != mediumIds && mediumIds.size() > 0){
			erpSysParaMapper.updateMediumIdsValues(cityId, erpCompId,mediumIds);
		}
		if(null != seniorIds && seniorIds.size() > 0){
			erpSysParaMapper.updateSeniorIdsValues(cityId, erpCompId,seniorIds);
		}
	}


	private void insertNewOrgSys(Integer cityId,Integer compId){
		ErpFunOrganizationDefinition definition = erpFunOrganizationDefinitionMapper.getLastDef(cityId, compId);
		String paramValue = definition == null ? "4" : String.valueOf(definition.getDefinitionId());

		ErpSysPara sysPara = new ErpSysPara();
		sysPara.setShardCityId(cityId);
		sysPara.setCompId(compId);
		sysPara.setParamId("SHARE_CUST_CORE_DEPT_DEF_ID");
		sysPara.setParamValue(paramValue);
		sysPara.setParamType("int");
		sysPara.setDefaultValue(paramValue);
		sysPara.setParamDesc("每人每天可查看公客核心信息最大条数层级");
		sysPara.setNeedRelogin((byte) 0);
		sysPara.setMediumValue(paramValue);
		sysPara.setSeniorValue(paramValue);
		sysPara.setPartnerId(0);
        sysPara.setOrganizationId(0);
		erpSysParaMapper.insertSelective(sysPara);

		ErpSysPara sysPara1 = new ErpSysPara();
		sysPara1.setCompId(compId);
		sysPara1.setParamValue(paramValue);
		sysPara1.setParamType("int");
		sysPara1.setDefaultValue(paramValue);
		sysPara1.setNeedRelogin((byte) 0);
		sysPara1.setMediumValue(paramValue);
		sysPara1.setSeniorValue(paramValue);
		sysPara1.setPartnerId(0);
		sysPara1.setOrganizationId(0);
		sysPara1.setShardCityId(cityId);
		sysPara1.setParamId("SHARE_CUST_CORE_OTHER_DEF_ID");
		sysPara1.setParamDesc("每人每天可查看其他公客核心信息最大条数层级");
		erpSysParaMapper.insertSelective(sysPara1);

		ErpSysPara sysPara2 = new ErpSysPara();
		sysPara2.setCompId(compId);
		sysPara2.setParamValue(paramValue);
		sysPara2.setParamType("int");
		sysPara2.setDefaultValue(paramValue);
		sysPara2.setNeedRelogin((byte) 0);
		sysPara2.setMediumValue(paramValue);
		sysPara2.setSeniorValue(paramValue);
		sysPara2.setPartnerId(0);
		sysPara2.setOrganizationId(0);
		sysPara2.setShardCityId(cityId);
		sysPara2.setParamId("SHARE_FUN_CORE_DEPT_DEF_ID");
		sysPara2.setParamDesc("每人每天可查看公房核心信息最大条数层级");
		erpSysParaMapper.insertSelective(sysPara2);

		ErpSysPara sysPara3 = new ErpSysPara();
		sysPara3.setCompId(compId);
		sysPara3.setParamValue(paramValue);
		sysPara3.setParamType("int");
		sysPara3.setDefaultValue(paramValue);
		sysPara3.setNeedRelogin((byte) 0);
		sysPara3.setMediumValue(paramValue);
		sysPara3.setSeniorValue(paramValue);
		sysPara3.setPartnerId(0);
		sysPara3.setOrganizationId(0);
		sysPara3.setShardCityId(cityId);
		sysPara3.setParamId("SHARE_FUN_CORE_OTHER_DEF_ID");
		sysPara3.setParamDesc("每人每天可查看其他公房核心信息最大条数层级");
		erpSysParaMapper.insertSelective(sysPara3);

		ErpSysPara sysPara4 = new ErpSysPara();
		sysPara4.setCompId(compId);
		sysPara4.setParamType("int");
		sysPara4.setNeedRelogin((byte) 0);
		sysPara4.setPartnerId(0);
		sysPara4.setOrganizationId(0);
		sysPara4.setShardCityId(cityId);
		sysPara4.setParamId("IPCALL_AREA_HIDEPHONE_COUNT_DEF_ID");
		sysPara4.setParamValue("2");
		sysPara4.setDefaultValue("2");
		sysPara4.setMediumValue("2");
		sysPara4.setSeniorValue("2");
		sysPara4.setParamDesc("每人每天可查看其他公房核心信息最大条数层级");
		erpSysParaMapper.insertSelective(sysPara4);

	}

	/**
	 * 试用开库附加处理逻辑
	 *
	 * @param cityId
	 * @param erpCompId
	 * @return
	 */
	public boolean tryBeginPostProcess(Integer cityId, Integer erpCompId,Boolean isFjd) {
		try {
			// 添加附加资料财务状态和合同分类 (税费大类) (税费子类) jiangsonggui 2015-11-19
			// 为每个公司生成默认的财务状态数据
			// 为每个公司生成默认的财务款项数据
			erpFunContractCategoryMapper.insertProfitComp(cityId, erpCompId);
			// 为每个公司生成默认的业绩类别数据
			if(isFjd){
				erpFunContractCategoryMapper.generateDefaultPerformanceCategories(cityId, erpCompId,-1);
			}else {
				erpFunContractCategoryMapper.generateDefaultPerformanceCategories(cityId, erpCompId,0);
			}

			Integer id = erpFunDealTaxesFatherMapper.insertTaxesFatherComp(cityId, erpCompId, "过户");
			erpFunDealTaxesSubMapper.insertTaxesSubComp(cityId, erpCompId, id);

			id = erpFunDealTaxesFatherMapper.insertTaxesFatherComp(cityId, erpCompId, "售房税费");
			erpFunDealTaxesSubMapper.insertTaxesSubCompTax(cityId, erpCompId, id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	public static String getAssessMentMonth(String wageAccountingDay, Integer addMonth) {
		if (StringUtils.isBlank(wageAccountingDay)) {
			wageAccountingDay = "01";
		}
		// 15号为中间点 大于15号算下月 15号以内算当月
		Calendar calendar = Calendar.getInstance();
		Integer accountDay = com.myfun.utils.StringUtil.parseInteger(wageAccountingDay);
		// 获取系统参数
		if (calendar.get(Calendar.DAY_OF_MONTH) < accountDay) {
			// 上月
		} else {
			// 本月
			calendar.add(Calendar.MONTH, 1);
		}
		Integer month = calendar.get(Calendar.MONTH);
		if (month == 0) {
			month = 12;
			calendar.add(Calendar.YEAR, -1);
		}
		String m = month + "";
		if (month < 10) {
			m = "0" + month;
		}
		return calendar.get(Calendar.YEAR) + "-" + m;
	}

	/**
	 * 门店参数初始化方法（将存储过程proc_deleteRoleOpers翻译成代码）
	 * @author HuangJiang
	 * @since 2019年4月28日 上午10:01:50
	 * @param cityId
	 * @param erpCompId
	 * @param compType(deptType)
	 * Modified XXX HuangJiang 2019年4月28日
	 */
	private void deleteCompRoleOpersByCompId(Integer cityId, Integer erpCompId, Integer compType, boolean infinite) {
		compType = 1; // 暂时固定为1
		// 1.删除公司角色权限
		erpCompRoleOpersMapper.deleteErpCompRoleOpersByErpCompId(cityId, erpCompId);

		// 2.插入公司角色权限
		if(infinite){//无限组织架构添加公司角色权限
			erpCompRoleOpersMapper.insertErpCompRoleOpersNew(cityId, erpCompId);

			/***无限组织架构更新新组织权限level***/
			erpCompRoleOpersMapper.updateManageOper(cityId, erpCompId);//将总经理和副总经理的新组织架构的组合权限范围更新为公司,其他经理更新相应权限范围 列：门店经理就更新为门店级的范围

			erpCompRoleOpersMapper.deleteOpers(cityId, erpCompId);//将不是管理员的新组合权限权限全部删除
		} else {
			erpCompRoleOpersMapper.insertErpCompRoleOpers(cityId, erpCompId);
		}

		// 3.删除角色DEPUTY_MANAGER权限
		String roleId1 = "DEPUTY_MANAGER";
		String operId1 = "'VIEW_AREA_HOUSE_LIST_INFO','VIEW_REG_HOUSE_LIST_INFO','VIEW_DEPT_HOUSE_LIST_INFO','VIEW_GROUP_HOUSE_LIST_INFO','QUERY_OTHER_SALE_PHONE','QUERY_OTHER_LEASE_PHONE','QUREY_OTHER_SALE_TRACK','QUERY_OTHER_LEASE_TRACK','SALE_MANAGE','LEASE_MANAGE','VIEW_WRITEOFF_DATA','CANCLE_ADS_CAST','ADD_ADS_CAST','VIEW_AREA_CUST_LIST_INFO','VIEW_REG_CUST_LIST_INFO','VIEW_DEPT_CUST_LIST_INFO','VIEW_GROUP_CUST_LIST_INFO','QUERY_OTHER_BUY_PHONE','QUERY_OTHER_RENT_PHONE','QUERY_OTHER_BUY_TRACK','QUERY_OTHER_RENT_TRACK','BUY_MANAGE','RENT_MANAGE','JOINT_CUSTOMER_AREA_VIEW','JOINT_CUSTOMER_REG_VIEW','JOINT_CUSTOMER_DEPT_VIEW','JOINT_CUSTOMER_GROUP_VIEW','VIEW_AREA_RENOVATION_CUSTOMER','VIEW_REG_RENOVATION_CUSTOMER','VIEW_DEPT_RENOVATION_CUSTOMER','VIEW_GROUP_RENOVATION_CUSTOMER','RENOVATION_CUSTOMER_MANAGE','MGR_OTHER_BIZ_DATA_AREA','MGR_OTHER_BIZ_DATA_REG','MGR_OTHER_BIZ_DATA_DEPT','DATA_ANALYSIS_AREA_VIEW','DATA_ANALYSIS_REG_VIEW','DATA_ANALYSIS_DEPT_VIEW','DATA_ANALYSIS_GROUP_VIEW','BIZ_DATA_VIEW_AREA','BIZ_DATA_VIEW_REG','BIZ_DATA_VIEW_DEPT','BIZ_DATA_VIEW_GROUP','LISTEN_VOICE_NOTES','SYSTEM_LOGS','PHONE_LOGS','LOCK_BUILDING','VIEW_AREA_EXCLUSIVE_ENTRUST','VIEW_REG_EXCLUSIVE_ENTRUST','VIEW_DEPT_EXCLUSIVE_ENTRUST','VIEW_GROUP_EXCLUSIVE_ENTRUST','DAY_JOB_LOGS','JOB_LOGS_AUDIT','EDIT_DEAL','PERFORMANCE_STATE','ATTENDANCE_COUNT_VIEW_AREA','ATTENDANCE_COUNT_VIEW_REG','ATTENDANCE_COUNT_VIEW_DEPT','ATTENDANCE_COUNT_VIEW_GROUP','ATTENDANCE_MANAGER_SENIOR'";
		if(infinite){
			erpCompRoleOpersMapper.deleteRoleOpersByCompIdAndRoleNew(cityId, erpCompId, roleId1, operId1);
		} else {
			erpCompRoleOpersMapper.deleteRoleOpersByCompIdAndRole(cityId, erpCompId, roleId1, operId1);
		}

		// 4.删除角色BIZ_GENERAL权限
		String roleId2 = "BIZ_GENERAL";
		String operId2 = "'VIEW_AREA_HOUSE_LIST_INFO','VIEW_REG_HOUSE_LIST_INFO','VIEW_DEPT_HOUSE_LIST_INFO','VIEW_GROUP_HOUSE_LIST_INFO','QUERY_OTHER_SALE_PHONE','QUERY_OTHER_LEASE_PHONE','QUREY_OTHER_SALE_TRACK','QUERY_OTHER_LEASE_TRACK','SALE_MANAGE','LEASE_MANAGE','VIEW_WRITEOFF_DATA','CANCLE_ADS_CAST','ADD_ADS_CAST','VIEW_AREA_CUST_LIST_INFO','VIEW_REG_CUST_LIST_INFO','VIEW_DEPT_CUST_LIST_INFO','VIEW_GROUP_CUST_LIST_INFO','QUERY_OTHER_BUY_PHONE','QUERY_OTHER_RENT_PHONE','QUERY_OTHER_BUY_TRACK','QUERY_OTHER_RENT_TRACK','BUY_MANAGE','RENT_MANAGE','JOINT_CUSTOMER_AREA_VIEW','JOINT_CUSTOMER_REG_VIEW','JOINT_CUSTOMER_DEPT_VIEW','JOINT_CUSTOMER_GROUP_VIEW','VIEW_AREA_RENOVATION_CUSTOMER','VIEW_REG_RENOVATION_CUSTOMER','VIEW_DEPT_RENOVATION_CUSTOMER','VIEW_GROUP_RENOVATION_CUSTOMER','RENOVATION_CUSTOMER_MANAGE','MGR_OTHER_BIZ_DATA_AREA','MGR_OTHER_BIZ_DATA_REG','MGR_OTHER_BIZ_DATA_DEPT','DATA_ANALYSIS_AREA_VIEW','DATA_ANALYSIS_REG_VIEW','DATA_ANALYSIS_DEPT_VIEW','DATA_ANALYSIS_GROUP_VIEW','BIZ_DATA_VIEW_AREA','BIZ_DATA_VIEW_REG','BIZ_DATA_VIEW_DEPT','BIZ_DATA_VIEW_GROUP','LISTEN_VOICE_NOTES','SYSTEM_LOGS','PHONE_LOGS','LOCK_BUILDING','VIEW_AREA_EXCLUSIVE_ENTRUST','VIEW_REG_EXCLUSIVE_ENTRUST','VIEW_DEPT_EXCLUSIVE_ENTRUST','VIEW_GROUP_EXCLUSIVE_ENTRUST','DAY_JOB_LOGS','JOB_LOGS_AUDIT','EDIT_DEAL','PERFORMANCE_STATE','ATTENDANCE_COUNT_VIEW_AREA','ATTENDANCE_COUNT_VIEW_REG','ATTENDANCE_COUNT_VIEW_DEPT','ATTENDANCE_COUNT_VIEW_GROUP','ATTENDANCE_MANAGER_SENIOR'";
		if(infinite){
			erpCompRoleOpersMapper.deleteRoleOpersByCompIdAndRoleNew(cityId, erpCompId, roleId2, operId2);
		} else {
			erpCompRoleOpersMapper.deleteRoleOpersByCompIdAndRole(cityId, erpCompId, roleId2, operId2);
		}

		// 5.删除角色REGION_MANAGER权限
		String roleId3 = "REGION_MANAGER";
		String operId3 = "'MANAGE_REG_CASE_COOPERATE','MANAGE_DEPT_CASE_COOPERATE','MANAGE_GROUP_CASE_COOPERATE','VIEW_REG_CUST_LIST_INFO','VIEW_DEPT_CUST_LIST_INFO','VIEW_GROUP_CUST_LIST_INFO','VIEW_REG_HOUSE_LIST_INFO','VIEW_DEPT_HOUSE_LIST_INFO','VIEW_GROUP_HOUSE_LIST_INFO','MANAGE_REG_ORGANIZATION','MANAGE_DEPT_ORGANIZATION','MANAGE_GROUP_ORGANIZATION','VIEW_REG_HOUSE_LIST_INFO','VIEW_DEPT_HOUSE_LIST_INFO','VIEW_GROUP_HOUSE_LIST_INFO','QUERY_OTHER_SALE_PHONE','QUERY_OTHER_LEASE_PHONE','QUREY_OTHER_SALE_TRACK','QUERY_OTHER_LEASE_TRACK','SALE_MANAGE','LEASE_MANAGE','VIEW_WRITEOFF_DATA','CANCLE_ADS_CAST','ADD_ADS_CAST','VIEW_REG_CUST_LIST_INFO','VIEW_DEPT_CUST_LIST_INFO','VIEW_GROUP_CUST_LIST_INFO','QUERY_OTHER_BUY_PHONE','QUERY_OTHER_RENT_PHONE','QUERY_OTHER_BUY_TRACK','QUERY_OTHER_RENT_TRACK','BUY_MANAGE','RENT_MANAGE','JOINT_CUSTOMER_REG_VIEW','JOINT_CUSTOMER_DEPT_VIEW','JOINT_CUSTOMER_GROUP_VIEW','VIEW_REG_RENOVATION_CUSTOMER','VIEW_DEPT_RENOVATION_CUSTOMER','VIEW_GROUP_RENOVATION_CUSTOMER','RENOVATION_CUSTOMER_MANAGE','MGR_OTHER_BIZ_DATA_REG','MGR_OTHER_BIZ_DATA_DEPT','DATA_ANALYSIS_REG_VIEW','DATA_ANALYSIS_DEPT_VIEW','DATA_ANALYSIS_GROUP_VIEW','BIZ_DATA_VIEW_REG','BIZ_DATA_VIEW_DEPT','BIZ_DATA_VIEW_GROUP','LISTEN_VOICE_NOTES','SYSTEM_LOGS','PHONE_LOGS','LOCK_BUILDING','VIEW_REG_EXCLUSIVE_ENTRUST','VIEW_DEPT_EXCLUSIVE_ENTRUST','VIEW_GROUP_EXCLUSIVE_ENTRUST','DAY_JOB_LOGS','JOB_LOGS_AUDIT','EDIT_DEAL','PERFORMANCE_STATE','ATTENDANCE_COUNT_VIEW_REG','ATTENDANCE_COUNT_VIEW_DEPT','ATTENDANCE_COUNT_VIEW_GROUP','ATTENDANCE_MANAGER_SENIOR'";
		if(infinite){
			erpCompRoleOpersMapper.deleteRoleOpersByCompIdAndRoleNew(cityId, erpCompId, roleId3, operId3);
		} else {
			erpCompRoleOpersMapper.deleteRoleOpersByCompIdAndRole(cityId, erpCompId, roleId3, operId3);
		}

		// 6.删除角色BRANCH_MANAGER权限
		String roleId4 = "BRANCH_MANAGER";
		String operId4 = "'MANAGE_REG_CASE_COOPERATE','MANAGE_DEPT_CASE_COOPERATE','VIEW_DEPT_CUST_LIST_INFO','VIEW_GROUP_CUST_LIST_INFO','VIEW_DEPT_HOUSE_LIST_INFO','VIEW_GROUP_HOUSE_LIST_INFO','MANAGE_DEPT_ORGANIZATION','MANAGE_GROUP_ORGANIZATION','VIEW_DEPT_HOUSE_LIST_INFO','VIEW_GROUP_HOUSE_LIST_INFO','QUERY_OTHER_SALE_PHONE','QUERY_OTHER_LEASE_PHONE','QUREY_OTHER_SALE_TRACK','QUERY_OTHER_LEASE_TRACK','SALE_MANAGE','LEASE_MANAGE','CANCLE_ADS_CAST','ADD_ADS_CAST','VIEW_DEPT_CUST_LIST_INFO','VIEW_GROUP_CUST_LIST_INFO','QUERY_OTHER_BUY_PHONE','QUERY_OTHER_RENT_PHONE','QUERY_OTHER_BUY_TRACK','QUERY_OTHER_RENT_TRACK','BUY_MANAGE','RENT_MANAGE','JOINT_CUSTOMER_DEPT_VIEW','JOINT_CUSTOMER_GROUP_VIEW','VIEW_DEPT_RENOVATION_CUSTOMER','VIEW_GROUP_RENOVATION_CUSTOMER','RENOVATION_CUSTOMER_MANAGE','MGR_OTHER_BIZ_DATA_DEPT','DATA_ANALYSIS_DEPT_VIEW','DATA_ANALYSIS_GROUP_VIEW','BIZ_DATA_VIEW_DEPT','BIZ_DATA_VIEW_GROUP','LISTEN_VOICE_NOTES','SYSTEM_LOGS','PHONE_LOGS','LOCK_BUILDING','VIEW_DEPT_EXCLUSIVE_ENTRUST','VIEW_GROUP_EXCLUSIVE_ENTRUST','DAY_JOB_LOGS','JOB_LOGS_AUDIT','EDIT_DEAL','PERFORMANCE_STATE','ATTENDANCE_COUNT_VIEW_DEPT','ATTENDANCE_COUNT_VIEW_GROUP','ATTENDANCE_MANAGER_SENIOR'";
		if(compType == 5){
			operId4 = "'KEY_MANAGE_DEPT','KEY_MANAGE_GROUP','EDIT_DEPT_HOUSE','VIEW_GROUP_HOUSE','VIEW_DEPT_HOUSE','AUTO_EXAM_VIEW_DEPT_HOUSE','AUTO_EXAM_VIEW_GROUP_HOUSE','EDIT_DEPT_HOUSE', 'EDIT_GROUP_HOUSE','MANAGE_DEPT_CASE_COOPERATE','VIEW_DEPT_CUST_LIST_INFO','VIEW_GROUP_CUST_LIST_INFO','VIEW_DEPT_HOUSE_LIST_INFO','VIEW_GROUP_HOUSE_LIST_INFO','MANAGE_DEPT_ORGANIZATION','MANAGE_GROUP_ORGANIZATION','VIEW_DEPT_HOUSE_LIST_INFO','VIEW_GROUP_HOUSE_LIST_INFO','QUERY_OTHER_SALE_PHONE','QUERY_OTHER_LEASE_PHONE','QUREY_OTHER_SALE_TRACK','QUERY_OTHER_LEASE_TRACK','SALE_MANAGE','LEASE_MANAGE','CANCLE_ADS_CAST','ADD_ADS_CAST','VIEW_DEPT_CUST_LIST_INFO','VIEW_GROUP_CUST_LIST_INFO','QUERY_OTHER_BUY_PHONE','QUERY_OTHER_RENT_PHONE','QUERY_OTHER_BUY_TRACK','QUERY_OTHER_RENT_TRACK','BUY_MANAGE','RENT_MANAGE','JOINT_CUSTOMER_DEPT_VIEW','JOINT_CUSTOMER_GROUP_VIEW','VIEW_DEPT_RENOVATION_CUSTOMER','VIEW_GROUP_RENOVATION_CUSTOMER','RENOVATION_CUSTOMER_MANAGE','MGR_OTHER_BIZ_DATA_DEPT','DATA_ANALYSIS_DEPT_VIEW','DATA_ANALYSIS_GROUP_VIEW','BIZ_DATA_VIEW_DEPT','BIZ_DATA_VIEW_GROUP','LISTEN_VOICE_NOTES','SYSTEM_LOGS','PHONE_LOGS','LOCK_BUILDING','VIEW_DEPT_EXCLUSIVE_ENTRUST','VIEW_GROUP_EXCLUSIVE_ENTRUST','DAY_JOB_LOGS','JOB_LOGS_AUDIT','EDIT_DEAL','PERFORMANCE_STATE','ATTENDANCE_COUNT_VIEW_DEPT','ATTENDANCE_COUNT_VIEW_GROUP','ATTENDANCE_MANAGER_SENIOR'";
		}
		if(infinite){
			erpCompRoleOpersMapper.deleteRoleOpersByCompIdAndRoleNew(cityId, erpCompId, roleId4, operId4);
		} else {
			erpCompRoleOpersMapper.deleteRoleOpersByCompIdAndRole(cityId, erpCompId, roleId4, operId4);
		}
		// 7.删除角色PROPERTY_SERVER权限
		String roleId5 = "PROPERTY_SERVER";
		String operId5 = "'DEAL_LOCK_VIEW','QUERY_OTHER_SALE_PHONE','QUERY_OTHER_LEASE_PHONE','QUREY_OTHER_SALE_TRACK','QUERY_OTHER_LEASE_TRACK','SALE_MANAGE','LEASE_MANAGE','QUERY_OTHER_BUY_PHONE','QUERY_OTHER_RENT_PHONE','QUERY_OTHER_BUY_TRACK','QUERY_OTHER_RENT_TRACK','BUY_MANAGE','RENT_MANAGE','DAY_JOB_LOGS','VIEW_COMP_DEAL','VIEW_AREA_DEAL','VIEW_REG_DEAL','VIEW_DEPT_DEAL','VIEW_GROUP_DEAL','EDIT_DEAL','DEAL_LOCK_VIEW','WARRANT_MANAGE','VIEW_WARRANT_INFO','EDIT_DEAL_WARRANTS_PROCESS','DEAL_UPDATE_TRANSFER_DATE'";
		if(compType == 5){
			operId5 = "'EDIT_DEAL','EDIT_DEAL_FINANCE','EDIT_DEAL_WARRANTS_PROCESS','EDIT_COMP_CUST','EDIT_COMP_HOUSE','EDIT_AREA_CUST','EDIT_AREA_HOUSE','EDIT_REG_CUST','EDIT_REG_HOUSE','EDIT_DEPT_CUST','EDIT_DEPT_HOUSE','EDIT_GROUP_CUST','EDIT_GROUP_HOUSE','VIEW_COMP_CUST_LIST_INFO','VIEW_AREA_CUST_LIST_INFO','VIEW_REG_CUST_LIST_INFO','VIEW_DEPT_CUST_LIST_INFO','VIEW_GROUP_CUST_LIST_INFO','VIEW_COMP_HOUSE_LIST_INFO','VIEW_AREA_HOUSE_LIST_INFO','VIEW_REG_HOUSE_LIST_INFO','VIEW_DEPT_HOUSE_LIST_INFO','VIEW_GROUP_HOUSE_LIST_INFO','VIEW_GROUP_HOUSE','VIEW_DEPT_HOUSE','VIEW_COMP_HOUSE','VIEW_GROUP_CUST','VIEW_DEPT_CUST','VIEW_COMP_CUST','AUTO_EXAM_VIEW_DEPT_HOUSE','AUTO_EXAM_VIEW_GROUP_HOUSE','AUTO_EXAM_VIEW_COMP_HOUSE','AUTO_EXAM_VIEW_AREA_HOUSE','AUTO_EXAM_VIEW_REG_HOUSE','AUTO_EXAM_VIEW_DEPT_CUST','AUTO_EXAM_VIEW_GROUP_CUST','AUTO_EXAM_VIEW_COMP_CUST','AUTO_EXAM_VIEW_REG_CUST','AUTO_EXAM_VIEW_AREA_CUST','DEAL_LOCK_VIEW','QUERY_OTHER_SALE_PHONE','QUERY_OTHER_LEASE_PHONE','QUERY_OTHER_BUY_PHONE','QUERY_OTHER_RENT_PHONE','QUREY_OTHER_SALE_TRACK','QUERY_OTHER_LEASE_TRACK','SALE_MANAGE','LEASE_MANAGE','QUERY_OTHER_BUY_PHONE','QUERY_OTHER_RENT_PHONE','QUERY_OTHER_BUY_TRACK','QUERY_OTHER_RENT_TRACK','BUY_MANAGE','RENT_MANAGE','DAY_JOB_LOGS','VIEW_COMP_DEAL','VIEW_AREA_DEAL','VIEW_REG_DEAL','VIEW_DEPT_DEAL','VIEW_GROUP_DEAL','EDIT_DEAL','DEAL_LOCK_VIEW','WARRANT_MANAGE','VIEW_WARRANT_INFO','EDIT_DEAL_WARRANTS_PROCESS','DEAL_UPDATE_TRANSFER_DATE'";
		}
		if(infinite){
			erpCompRoleOpersMapper.deleteRoleOpersByCompIdAndRoleNew(cityId, erpCompId, roleId5, operId5);
		} else {
			erpCompRoleOpersMapper.deleteRoleOpersByCompIdAndRole(cityId, erpCompId, roleId5, operId5);
		}
		// 8.删除角色SECRETARIAL权限
		String roleId6 = "SECRETARIAL";
		String operId6 = "'MANAGE_REG_CASE_COOPERATE','MANAGE_DEPT_CASE_COOPERATE','VIEW_DEPT_CUST_LIST_INFO','VIEW_GROUP_CUST_LIST_INFO','VIEW_DEPT_HOUSE_LIST_INFO','VIEW_GROUP_HOUSE_LIST_INFO','MANAGE_DEPT_ORGANIZATION','MANAGE_GROUP_ORGANIZATION','VIEW_DEPT_HOUSE_LIST_INFO','VIEW_GROUP_HOUSE_LIST_INFO','QUERY_OTHER_SALE_PHONE','QUERY_OTHER_LEASE_PHONE','QUREY_OTHER_SALE_TRACK','QUERY_OTHER_LEASE_TRACK','SALE_MANAGE','LEASE_MANAGE','CANCLE_ADS_CAST','ADD_ADS_CAST','VIEW_DEPT_CUST_LIST_INFO','VIEW_GROUP_CUST_LIST_INFO','QUERY_OTHER_BUY_PHONE','QUERY_OTHER_RENT_PHONE','QUERY_OTHER_BUY_TRACK','QUERY_OTHER_RENT_TRACK','BUY_MANAGE','RENT_MANAGE','JOINT_CUSTOMER_DEPT_VIEW','JOINT_CUSTOMER_GROUP_VIEW','VIEW_DEPT_RENOVATION_CUSTOMER','VIEW_GROUP_RENOVATION_CUSTOMER','RENOVATION_CUSTOMER_MANAGE','MGR_OTHER_BIZ_DATA_DEPT','DATA_ANALYSIS_DEPT_VIEW','DATA_ANALYSIS_GROUP_VIEW','BIZ_DATA_VIEW_DEPT','BIZ_DATA_VIEW_GROUP','LISTEN_VOICE_NOTES','SYSTEM_LOGS','PHONE_LOGS','LOCK_BUILDING','VIEW_DEPT_EXCLUSIVE_ENTRUST','VIEW_GROUP_EXCLUSIVE_ENTRUST','DAY_JOB_LOGS','PERFORMANCE_STATE','ATTENDANCE_COUNT_VIEW_DEPT','ATTENDANCE_COUNT_VIEW_GROUP','ATTENDANCE_MANAGER_SENIOR'";
		if(infinite){
			erpCompRoleOpersMapper.deleteRoleOpersByCompIdAndRoleNew(cityId, erpCompId, roleId6, operId6);
		} else {
			erpCompRoleOpersMapper.deleteRoleOpersByCompIdAndRole(cityId, erpCompId, roleId6, operId6);
		}
		// 9.删除角色CUST_SERVER权限
		String roleId7 = "CUST_SERVER";
		String operId7 = "'VIEW_DEPT_CUST_LIST_INFO','VIEW_GROUP_CUST_LIST_INFO','VIEW_DEPT_HOUSE_LIST_INFO','VIEW_GROUP_HOUSE_LIST_INFO','ATTENDANCE_MANAGER_SENIOR','VIEW_DEPT_EXCLUSIVE_ENTRUST','VIEW_GROUP_EXCLUSIVE_ENTRUST','VIEW_DEPT_HOUSE_LIST_INFO','VIEW_GROUP_HOUSE_LIST_INFO','QUERY_OTHER_SALE_PHONE','QUERY_OTHER_LEASE_PHONE','QUREY_OTHER_SALE_TRACK','QUERY_OTHER_LEASE_TRACK','SALE_MANAGE','LEASE_MANAGE','VIEW_DEPT_CUST_LIST_INFO','VIEW_GROUP_CUST_LIST_INFO','QUERY_OTHER_BUY_PHONE','QUERY_OTHER_RENT_PHONE','QUERY_OTHER_BUY_TRACK','QUERY_OTHER_RENT_TRACK','BUY_MANAGE','RENT_MANAGE','JOINT_CUSTOMER_DEPT_VIEW','JOINT_CUSTOMER_GROUP_VIEW','VIEW_GROUP_RENOVATION_CUSTOMER','RENOVATION_CUSTOMER_MANAGE','DATA_ANALYSIS_DEPT_VIEW','DATA_ANALYSIS_GROUP_VIEW','BIZ_DATA_VIEW_DEPT','BIZ_DATA_VIEW_GROUP','VIEW_DEPT_EXCLUSIVE_ENTRUST','VIEW_GROUP_EXCLUSIVE_ENTRUST','DAY_JOB_LOGS','ATTENDANCE_MANAGER_SENIOR'";
		if(infinite){
			erpCompRoleOpersMapper.deleteRoleOpersByCompIdAndRoleNew(cityId, erpCompId, roleId7, operId7);
		} else {
			erpCompRoleOpersMapper.deleteRoleOpersByCompIdAndRole(cityId, erpCompId, roleId7, operId7);
		}
		// 10.删除角色BIZ_MANAGER权限
		String roleId8 = "BIZ_MANAGER";
		String operId8 = "'VIEW_DEPT_CUST_LIST_INFO','VIEW_GROUP_CUST_LIST_INFO','VIEW_DEPT_HOUSE_LIST_INFO','VIEW_GROUP_HOUSE_LIST_INFO','ATTENDANCE_MANAGER_SENIOR','VIEW_DEPT_EXCLUSIVE_ENTRUST','VIEW_GROUP_EXCLUSIVE_ENTRUST','VIEW_DEPT_HOUSE_LIST_INFO','VIEW_GROUP_HOUSE_LIST_INFO','QUERY_OTHER_SALE_PHONE','QUERY_OTHER_LEASE_PHONE','QUREY_OTHER_SALE_TRACK','QUERY_OTHER_LEASE_TRACK','SALE_MANAGE','LEASE_MANAGE','VIEW_DEPT_CUST_LIST_INFO','VIEW_GROUP_CUST_LIST_INFO','QUERY_OTHER_BUY_PHONE','QUERY_OTHER_RENT_PHONE','QUERY_OTHER_BUY_TRACK','QUERY_OTHER_RENT_TRACK','BUY_MANAGE','RENT_MANAGE','JOINT_CUSTOMER_DEPT_VIEW','JOINT_CUSTOMER_GROUP_VIEW','VIEW_GROUP_RENOVATION_CUSTOMER','RENOVATION_CUSTOMER_MANAGE','DATA_ANALYSIS_DEPT_VIEW','DATA_ANALYSIS_GROUP_VIEW','BIZ_DATA_VIEW_DEPT','BIZ_DATA_VIEW_GROUP','VIEW_DEPT_EXCLUSIVE_ENTRUST','VIEW_GROUP_EXCLUSIVE_ENTRUST','DAY_JOB_LOGS','ATTENDANCE_MANAGER_SENIOR'";
		if(infinite){
			erpCompRoleOpersMapper.deleteRoleOpersByCompIdAndRoleNew(cityId, erpCompId, roleId8, operId8);
		} else {
			erpCompRoleOpersMapper.deleteRoleOpersByCompIdAndRole(cityId, erpCompId, roleId8, operId8);
		}
		// 11.删除角色COMMON_BIZ权限
		String roleId9 = "COMMON_BIZ";
		String operId9 = "'VIEW_DEPT_HOUSE_LIST_INFO','VIEW_GROUP_HOUSE_LIST_INFO','VIEW_DEPT_HOUSE_LIST_INFO','VIEW_GROUP_HOUSE_LIST_INFO','QUERY_OTHER_SALE_PHONE','QUERY_OTHER_LEASE_PHONE','QUREY_OTHER_SALE_TRACK','QUERY_OTHER_LEASE_TRACK','SALE_MANAGE','LEASE_MANAGE','VIEW_DEPT_CUST_LIST_INFO','VIEW_GROUP_CUST_LIST_INFO','QUERY_OTHER_BUY_PHONE','QUERY_OTHER_RENT_PHONE','QUERY_OTHER_BUY_TRACK','QUERY_OTHER_RENT_TRACK','BUY_MANAGE','RENT_MANAGE','DAY_JOB_LOGS'";
		if(compType == 5){
			operId9 = "'EDIT_DEPT_HOUSE','EDIT_GROUP_HOUSE','VIEW_GROUP_HOUSE','VIEW_DEPT_HOUSE','VIEW_DEPT_HOUSE_LIST_INFO','VIEW_GROUP_HOUSE_LIST_INFO','QUERY_OTHER_SALE_PHONE','QUERY_OTHER_LEASE_PHONE','QUREY_OTHER_SALE_TRACK','QUERY_OTHER_LEASE_TRACK','SALE_MANAGE','LEASE_MANAGE','QUERY_OTHER_BUY_TRACK','QUERY_OTHER_RENT_TRACK','BUY_MANAGE','RENT_MANAGE','DAY_JOB_LOGS'";
		}
		erpCompRoleOpersMapper.deleteRoleOpersByCompIdAndRole(cityId, erpCompId, roleId9, operId9);
		if(infinite){
			erpCompRoleOpersMapper.deleteRoleOpersByCompIdAndRoleNew(cityId, erpCompId, roleId9, operId9);
		} else {
			erpCompRoleOpersMapper.deleteRoleOpersByCompIdAndRole(cityId, erpCompId, roleId9, operId9);
		}
		// 12.删除角色PRACTY_BIZ权限
		String roleId10 = "PRACTY_BIZ";
		String operId10 = "'VIEW_DEPT_CUST_LIST_INFO','VIEW_GROUP_CUST_LIST_INFO','VIEW_DEPT_HOUSE_LIST_INFO','VIEW_GROUP_HOUSE_LIST_INFO','DAY_JOB_LOGS','QUERY_OTHER_LEASE_PHONE','QUERY_OTHER_SALE_PHONE','VIEW_DEPT_HOUSE_LIST_INFO','VIEW_GROUP_HOUSE_LIST_INFO','QUERY_OTHER_SALE_PHONE','QUERY_OTHER_LEASE_PHONE','SALE_MANAGE','LEASE_MANAGE','BUY_MANAGE','RENT_MANAGE','DAY_JOB_LOGS'";
		if(infinite){
			erpCompRoleOpersMapper.deleteRoleOpersByCompIdAndRoleNew(cityId, erpCompId, roleId10, operId10);
		} else {
			erpCompRoleOpersMapper.deleteRoleOpersByCompIdAndRole(cityId, erpCompId, roleId10, operId10);
		}
	}

	@Override
	public boolean judgerIsMeiLian(Integer adminCompId, String compNo) {
		
		AdminFunComp adminFunComp = null;
		if(StringUtil.isNotEmpty(compNo)){
			adminFunComp = adminFunCompMapper.selectByCompNo(compNo);
		}else {
			adminFunComp = adminFunCompMapper.selectByPrimaryKey(adminCompId);
		}
		if(adminFunComp !=null && "2".equals(adminFunComp.getCustomizedType().toString())){
			return true;
		}
		return false;
	}
}

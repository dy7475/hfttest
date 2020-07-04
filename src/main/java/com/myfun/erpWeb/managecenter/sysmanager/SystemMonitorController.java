package com.myfun.erpWeb.managecenter.sysmanager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.extension.framework.codis.util.CacheUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.sysmanager.param.GetAppLoginDeviceListParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.GetLogListParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.GetMgrInstallListParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.GetMgrPhoneListParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.GetMgrSubmitKeyLogParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.GetSysLoginLogsParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.SystemMonitorParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.UpdateDeviceStatusParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.ZtGetAppLoginLogsParam;
import com.myfun.erpWeb.managecenter.sysmanager.vo.ErpAppLoginDeviceVo;
import com.myfun.erpWeb.managecenter.sysmanager.vo.ErpFunPrologsVo;
import com.myfun.erpWeb.managecenter.sysmanager.vo.ErpFunViewLogVo;
import com.myfun.erpWeb.managecenter.sysmanager.vo.ErpSystemSettingLogsVo;
import com.myfun.erpWeb.managecenter.sysmanager.vo.LogListVo;
import com.myfun.erpWeb.managecenter.sysmanager.vo.ZtAppLoginListVo;
import com.myfun.erpWeb.managecenter.sysmanager.vo.ZtGetAppLoginLogsVo;
import com.myfun.erpWeb.usercenter.vo.ErpFunKeyOperationLogDto;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpAppLoginDeviceMapper;
import com.myfun.repository.erpdb.dao.ErpAttendanceChangeRecordMapper;
import com.myfun.repository.erpdb.dao.ErpBuildPermissionsMapper;
import com.myfun.repository.erpdb.dao.ErpDicDefinitionsMapper;
import com.myfun.repository.erpdb.dao.ErpFunAdsContentMapper;
import com.myfun.repository.erpdb.dao.ErpFunCompMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunKeyLogMapper;
import com.myfun.repository.erpdb.dao.ErpFunKeyMapper;
import com.myfun.repository.erpdb.dao.ErpFunKeyOperationLogMapper;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunMacMapper;
import com.myfun.repository.erpdb.dao.ErpFunOrganizationMapper;
import com.myfun.repository.erpdb.dao.ErpFunPrologsMapper;
import com.myfun.repository.erpdb.dao.ErpFunPropertyKeyLogMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.dao.ErpFunTrackMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpFunViewLogMapper;
import com.myfun.repository.erpdb.dao.ErpSysParaMapper;
import com.myfun.repository.erpdb.dao.ErpSystemSettingLogsMapper;
import com.myfun.repository.erpdb.dao.ErpTrackUsersMapper;
import com.myfun.repository.erpdb.dto.CheckPartnerConfigDto;
import com.myfun.repository.erpdb.dto.ErpAppLoginDeviceDto;
import com.myfun.repository.erpdb.dto.ErpAttendanceChangeRecordDto;
import com.myfun.repository.erpdb.dto.ErpFunAdsContentDto;
import com.myfun.repository.erpdb.dto.ErpFunKeyDto;
import com.myfun.repository.erpdb.dto.ErpFunMacDto;
import com.myfun.repository.erpdb.dto.ErpFunTrackDto;
import com.myfun.repository.erpdb.dto.ErpFunViewLogDto;
import com.myfun.repository.erpdb.dto.ErpSystemSettingLogsDto;
import com.myfun.repository.erpdb.dto.ErpTrackUsersDto;
import com.myfun.repository.erpdb.param.FunAdsParam;
import com.myfun.repository.erpdb.po.ErpBuildPermissions;
import com.myfun.repository.erpdb.po.ErpBuildPermissionsExample;
import com.myfun.repository.erpdb.po.ErpFunBuyCustomer;
import com.myfun.repository.erpdb.po.ErpFunComp;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunLeaseExample;
import com.myfun.repository.erpdb.po.ErpFunOrganization;
import com.myfun.repository.erpdb.po.ErpFunPrologs;
import com.myfun.repository.erpdb.po.ErpFunPropertyKeyLog;
import com.myfun.repository.erpdb.po.ErpFunRentCustomer;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.repository.erpdb.po.ErpFunSaleExample;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpSysPara;
import com.myfun.repository.erpdb.po.ErpSystemSettingLogs;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.admindb.AdminFunMacService;
import com.myfun.service.business.erpdb.ErpAppLoginDeviceService;
import com.myfun.service.business.erpdb.ErpAttendanceChangeRecordService;
import com.myfun.service.business.erpdb.ErpFunAdsContentService;
import com.myfun.service.business.erpdb.ErpFunCompService;
import com.myfun.service.business.erpdb.ErpFunKeyLogService;
import com.myfun.service.business.erpdb.ErpFunMacService;
import com.myfun.service.business.erpdb.ErpFunPartnerConfigService;
import com.myfun.service.business.erpdb.ErpFunPrologsService;
import com.myfun.service.business.erpdb.ErpFunTrackService;
import com.myfun.service.business.erpdb.ErpFunViewLogService;
import com.myfun.service.business.erpdb.ErpSystemSettingLogsService;
import com.myfun.service.business.erpdb.ErpUserOpersService;
import com.myfun.utils.BaseUtil;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.BeanUtilsHelper;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.DateUtil;
import com.myfun.utils.EncryptHelper;
import com.myfun.utils.NumberHelper;
import com.myfun.utils.StringUtil;
import com.myfun.utils.rijindael.AESHelper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
* @ClassName: SystemMonitorController 
* @Description: 系统监控模块
* @author 方李骥
* @date 2016-10-20 下午3:45:30
 */
@Api(tags = "系统监控模块")
@RestController
@RequestMapping("/managerCenter/systemMonitor")
public class SystemMonitorController extends BaseController{

	@Autowired
	ErpFunViewLogService erpFunViewLogService;
	@Autowired
	ErpFunTrackService erpFunTrackService;
	@Autowired  
	ErpSystemSettingLogsService erpSystemSettingLogsService;
	@Autowired
	ErpFunMacService erpFunMacService;
	@Autowired
	ErpFunAdsContentService erpFunAdsContentService;
	@Autowired
	ErpFunKeyLogService erpFunKeyLogService;
	@Autowired
	ErpFunPrologsService erpFunPrologsService;
	@Autowired
	ErpAttendanceChangeRecordService erpAttendanceChangeRecordService;
	@Autowired
	ErpAppLoginDeviceService erpAppLoginDeviceService;
	@Autowired
	ErpAppLoginDeviceMapper erpAppLoginDeviceMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpFunViewLogMapper erpFunViewLogMapper;
	@Autowired
	ErpFunKeyMapper erpFunKeyMapper;
	@Autowired
	ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	ErpFunMacMapper erpFunMacMapper;
	@Autowired
	ErpSystemSettingLogsMapper erpSystemSettingLogsMapper;
	@Autowired
	ErpFunAdsContentMapper erpFunAdsContentMapper;
	@Autowired
	ErpFunPrologsMapper erpFunPrologsMapper;
	@Autowired
	ErpAttendanceChangeRecordMapper erpAttendanceChangeRecordMapper;
	@Autowired
	ErpSysParaMapper erpSysParaMapper;
	@Autowired
	ErpFunTrackMapper erpFunTrackMapper;
	@Autowired
	ErpTrackUsersMapper erpTrackUsersMapper;
	@Autowired
	ErpFunCompMapper erpFunCompMapper;
	@Autowired
	ErpFunCompService erpFunCompService;
	@Autowired
	ErpUserOpersService erpUserOpersService;
	@Autowired
	ErpFunKeyLogMapper erpFunKeyLogMapper;
	@Autowired
	ErpFunKeyOperationLogMapper erpFunKeyOperationLogMapper;
	@Autowired
	AdminFunMacService adminFunMacService;
	@Autowired
	ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	ErpFunPropertyKeyLogMapper erpFunPropertyKeyLogMapper;
	@Autowired
	ErpDicDefinitionsMapper erpDicDefinitionsMapper;
	@Autowired
	private CacheUtil cacheUtil;
	@Autowired
	private ErpFunPartnerConfigService erpFunPartnerConfigService;
	@Autowired
	private ErpFunOrganizationMapper erpFunOrganizationMapper;
	@Autowired
	private ErpBuildPermissionsMapper erpBuildPermissionsMapper;

	/**
	* @Date:2016-10-20
	* @Athor:方李骥
	* @Title: getMgrInstallList 
	* @Description: (查询安装列表) 
	* @param param
	* @return   
	* @return ErpResponseJson  返回类型 
	* @throws
	 */
	@RequestMapping("/getMgrInstallList")
	public ErpResponseJson getMgrInstallList(@Valid @RequestBody GetMgrInstallListParam param) {
		Operator operator = getOperator();
		//如果是美联的需求会走这一段逻辑
		if (getOperator().isMeiLianApi()) {
			String record = (String) cacheUtil.get("/erpWeb/managerCenter/systemMonitor/getMgrInstallList"
					+ operator.getArchiveId() + DateTimeHelper.formatDateTimetoString(new Date(), "yyy-MM-dd"));
			if (StringUtil.isBlank(record)) {
				ErpSystemSettingLogs erpSystemSettingLogs = new ErpSystemSettingLogs();
				erpSystemSettingLogs.setCompId(operator.getCompId().intValue());
				erpSystemSettingLogs.setShardCityId(operator.getCityId());
				erpSystemSettingLogs.setCreateDept(operator.getDeptId());
				erpSystemSettingLogs.setSslType((byte) 42);
				erpSystemSettingLogs.setModular(9);
				erpSystemSettingLogs.setCreateUid(operator.getUserId());
				erpSystemSettingLogs.setCreateTime(DateUtil.DateToString(new Date()));
				erpSystemSettingLogs.setLogContent("查看了设备管理");
				erpSystemSettingLogsMapper.insertSelective(erpSystemSettingLogs);
				cacheUtil.put("/erpWeb/managerCenter/systemMonitor/getMgrInstallList"
						+ operator.getArchiveId() + DateTimeHelper.formatDateTimetoString(new Date(), "yyy-MM-dd"), "1", 86400);
			}
		}

		param.setCompId(operator.getCompId());
//		param.setDeptId(operator.getDeptId());
		//**********************组织架构改版********************************
		if (operator.newOrganizationType()) {// zt组织机构
			if (null != param.getOrganizationId() && param.getOrganizationId() == 0) {
				param.setOrganizationId(null);
			}
		}
		//**********************组织架构改版********************************

		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<ErpFunMacDto> list = erpFunMacMapper.selectMgrInstallList(getOperator().getCityId(), param);
		for (ErpFunMacDto dto : list) {
			//电脑ID,从数据库取MAC明文地址，显示列表加密,不影响数据库
			String pcId = EncryptHelper.encryptMD5(dto.getMacaddr());
			dto.setPcId(pcId);
		}
		return ErpResponseJson.ok(new PageInfo<>(list));
	}
	
	/**
	* @Date:2016-10-20
	* @Athor:方李骥
	* @Title: updateMgrReg 
	* @Description: (修改备注) 
	* @param param
	* @return   
	* @return ErpResponseJson    返回类型 
	* @throws
	 */
	@RequestMapping("/updateMgrReg")
	@NotBlank({"owner"})
	public ErpResponseJson updateMgrReg(@Valid @RequestBody BaseMapParam param){
		param.setString("currentUserName", getCurrentUserName());
		param.setString("userName",getOperator().getUserName());
		param.setInteger("currentDeptId", getOperator().getDeptId());
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("currentUserId",getOperator().getUserId());
		param.setInteger("cityId", getOperator().getCityId());
		erpFunMacService.updateMgrReg(param);
		return ErpResponseJson.ok();
	}
	
	/**
	 * @Date:2016-10-20
	 * @Athor:方李骥
	 * @Title: updateMgrchgLoginType 
	 * @Description: (是否允许登陆) 
	 * @param param
	 * @return   
	 * @return ErpResponseJson    返回类型 
	 * @throws
	 */
	@RequestMapping("/updateMgrchgLoginType")
	@NotBlank({"loginType","macaddr"})
	public ErpResponseJson updateMgrchgLoginType(@Valid @RequestBody BaseMapParam param){
		param.setString("currentUserName", getCurrentUserName());
		param.setString("userName",getOperator().getUserName());
		param.setInteger("currentDeptId", getOperator().getDeptId());
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("currentUserId",getOperator().getUserId());
		param.setInteger("cityId", getOperator().getCityId());
		erpFunMacService.updateMgrchgLoginType(param);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 开启漫游
	 * @author 张宏利
	 * @since 2017年10月16日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateMgrRoamUser")
	public ErpResponseJson updateMgrRoamUser(@Valid @RequestBody BaseMapParam param) throws Exception{
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		String macaddr = param.getString("macaddr");
		Integer roamUserId = param.getInteger("roamUser");
		erpFunMacService.updateMgrRoamUser(cityId, 1, compId, roamUserId, macaddr);
		return ErpResponseJson.ok();
	}
	
	/**
	 * title ：
	 * author：lcb
	 * date  : 2017/10/12
	 */
	@RequestMapping("/updateMgrchgCruise")
	public ErpResponseJson updateMgrchgCruise(@Valid @RequestBody BaseMapParam param) throws Exception {
		Operator operator = getOperator();
		Integer roamUser = param.getInteger("roamUser");
		Integer roam = param.getInteger("roam");
		String macaddr = param.getString("macaddr");
		erpFunMacService.updateMgrRoamUser(operator.getCityId(), roam, operator.getCompId(), roamUser, macaddr);
		return ErpResponseJson.ok();
	}
	
	/**
	* @Date:2016-10-21
	* @Athor:方李骥
	* @Title: deleteMgrReg 
	* @Description:(删除个人MAC注册) 
	* @param param
	* @return
	* @throws Exception   
	* @return ErpResponseJson    返回类型 
	* @throws
	 */
	@RequestMapping("/deleteMgrReg")
	@NotBlank({"macaddr","deptId"})
	public ErpResponseJson deleteMgrReg(@Valid @RequestBody BaseMapParam param) throws Exception{
		param.setString("currentUserName", getCurrentUserName());
		param.setString("userName",getOperator().getUserName());
		param.setInteger("currentDeptId", getOperator().getDeptId());
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("currentUserId",getOperator().getUserId());
		param.setInteger("cityId", getOperator().getCityId());
		erpFunMacService.deleteMgrReg(param);
		return ErpResponseJson.ok();
	}
	
	/**
	* @Date:2016-10-21
	* @Athor:方李骥
	* @Title: updateMgrchgRegist 
	* @Description:(禁止或允许注册) 
	* @param param
	* @return
	* @throws Exception   
	* @return ErpResponseJson    返回类型 
	* @throws
	 */
	@RequestMapping("/updateMgrchgRegist")
	@NotBlank({"registFlag"})
	public ErpResponseJson updateMgrchgRegist(@Valid @RequestBody BaseMapParam param) throws Exception{
		param.setString("currentUserName", getCurrentUserName());
		param.setString("userName",getOperator().getUserName());
		param.setInteger("currentDeptId", getOperator().getDeptId());
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("currentUserId",getOperator().getUserId());
		param.setInteger("cityId", getOperator().getCityId());
		erpFunMacService.updateMgrchgRegist(param);
		return ErpResponseJson.ok();
	}
	
	/**
	* @Date:2016-10-21
	* @Athor:方李骥
	* @Title: setMgrRegistManager 
	* @Description:(设置安装列表管理员) 
	* @param param
	* @return
	* @throws Exception   
	* @return ErpResponseJson    返回类型 
	* @throws
	 */
	@RequestMapping("/setMgrRegistManager")
//	@NotBlank({"registFlag"})
	public ErpResponseJson setMgrRegistManager(@Valid @RequestBody BaseMapParam param) throws Exception{
		param.setString("currentUserName", getCurrentUserName());
		param.setString("userName",getOperator().getUserName());
		param.setInteger("currentDeptId", getOperator().getDeptId());
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("currentUserId",getOperator().getUserId());
		param.setInteger("cityId", getOperator().getCityId());
		erpFunMacService.setMgrRegistManager(param);
		return ErpResponseJson.ok();
	}
	
	/**
	* @Date:2016-10-24
	* @Athor:方李骥
	* @Title: getRegistManagerUser 
	* @Description:(获取安装列表管理员) 
	* @param param
	* @return
	* @throws Exception   
	* @return ErpResponseJson    返回类型 
	* @throws
	 */
	@RequestMapping("/getRegistManagerUser")
	public ErpResponseJson getRegistManagerUser(@Valid @RequestBody BaseMapParam param) throws Exception{
		param.setString("currentUserName", getCurrentUserName());
		param.setString("userName",getOperator().getUserName());
		param.setInteger("currentDeptId", getOperator().getDeptId());
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("currentUserId",getOperator().getUserId());
		param.setInteger("cityId", getOperator().getCityId());
		Map<String,Object> dataObject = erpFunMacService.getRegistManagerUser(param);
		return ErpResponseJson.ok(dataObject);
	}
	
	/**
	 * 获取电话查看列表
	 * @author 何传强
	 * @since 2017年8月28日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("获取电话查看列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunViewLogVo.class, message = "成功")
	})
	@RequestMapping("/getMgrPhoneList")
	public ErpResponseJson getMgrPhoneList(@Valid @RequestBody GetMgrPhoneListParam param) throws Exception {
		//如果是美联的需求会走这一段逻辑
		if(getOperator().isMeiLianApi()){
			String record = (String)cacheUtil.get("/erpWeb/managerCenter/systemMonitor/getMgrPhoneList"
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
				erpSystemSettingLogs.setLogContent("查看了电话查看");
				erpSystemSettingLogsMapper.insertSelective(erpSystemSettingLogs);
				cacheUtil.put("/erpWeb/managerCenter/systemMonitor/getMgrPhoneList"
						+ getOperator().getArchiveId()+DateTimeHelper.formatDateTimetoString(new Date(),"yyy-MM-dd"),"1",86400);
			}
		}
		param.setCompId(getOperator().getCompId());
		String date2 = param.getDate2();
		Integer caseType = param.getCaseType();
		if (StringUtil.isNotBlank(date2)) {
			param.setDate2(date2+" 23:59:59");
		}

		String order = "";
		// 查看对象TARGET_NO    所属经纪人OWNER_ID  查勘人VIEW_USER  查看时间VIEW_TIME
		String orderEnum = param.getOrderEnum();
		String orderRule = param.getOrderRule(); // 0:升序 1:降序
		if(StringUtils.isNotBlank(orderEnum) && StringUtils.isNotBlank(orderRule)) {
			String orderStr = "1".equals(orderRule) ? "DESC" : "ASC";
			if("TARGET_NO".equals(orderEnum)) {
				order = " A.TARGET_NO " + orderStr;
			}
			if("OWNER_ID".equals(orderEnum)) {
				order = " A.OWNER_ID " + orderStr;
			}
			if("VIEW_USER".equals(orderEnum)) {
				order = " A.VIEW_USER " + orderStr;
			}
			if("VIEW_TIME".equals(orderEnum)) {
				order = " A.VIEW_TIME " + orderStr;
			}
		}
		param.setOrderStr(order);

		Integer partnerId = getOperator().getPartnerId();
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		if (caseType == Const.DIC_CASE_TYPE_SALE_FUN.intValue() || caseType == Const.DIC_CASE_TYPE_LEASE_FUN.intValue()) {
			// 需要判断加盟商信息(房源是否独立配置)
			CheckPartnerConfigDto houseConfigDto = erpFunPartnerConfigService.checkPartnerConfig(cityId, compId, partnerId, "houseDataApart");
			Byte houseOpenPartner = houseConfigDto.getOpenPartner();
			Byte houseIsApart = houseConfigDto.getIsApart();

			// 只要不是公司开启了加盟商模式, 或者房源数据隔离, 那么就按以前的逻辑走(不带加盟商ID查询)
			// 直营看直营, 加盟商看加盟商, 总部看所有
			if (houseOpenPartner == 0 || houseIsApart == 0 || partnerId == 0) {
				partnerId = null;
			}
		} else if (caseType == Const.DIC_CASE_TYPE_RENT_CUST.intValue() || caseType == Const.DIC_CASE_TYPE_BUY_CUST.intValue()) {
			// 需要判断加盟商信息(客源是否独立配置)
			CheckPartnerConfigDto custConfigDto = erpFunPartnerConfigService.checkPartnerConfig(cityId, compId, partnerId, "custDataApart");
			Byte custOpenPartner = custConfigDto.getOpenPartner();
			Byte custIsApart = custConfigDto.getIsApart();

			// 只要不是公司开启了加盟商模式, 或者房源数据隔离, 那么就按以前的逻辑走(不带加盟商ID查询)
			// 直营看直营, 加盟商看加盟商, 总部看所有
			if (custOpenPartner == 0 || custIsApart == 0 || partnerId == 0) {
				partnerId = null;
			}
		}
		param.setPartnerId(partnerId);
		param.setNewOrganization(getOperator().newOrganizationType());
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<ErpFunViewLogDto> mgrPhoneList = erpFunViewLogMapper.getMgrPhoneList(param, getOperator().getCityId());
		if (!mgrPhoneList.isEmpty()){
			mgrPhoneList.stream().forEach(a -> {
				String caseName = a.getCaseName();
				if (Objects.equals(Const.DIC_CASE_TYPE_BUY_CUST, caseType) || Objects.equals(Const.DIC_CASE_TYPE_RENT_CUST, caseType)) {
					Boolean caseSex = a.getCaseSex();
					caseName = StringUtil.isNotBlank(caseName) ? (caseName.substring(0, 1) + ((null != caseSex && caseSex) ? "先生" : "女士")) : caseName;
				}
				Byte room = a.getRoom();
				String caseArea = a.getCaseArea();
				if (null != caseArea) {
					if (Objects.equals(Const.DIC_CASE_TYPE_BUY_CUST, caseType) || Objects.equals(Const.DIC_CASE_TYPE_RENT_CUST, caseType)) {
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
				String casePrice = a.getCasePrice();
				if (null != casePrice) {
					if (Objects.equals(Const.DIC_CASE_TYPE_BUY_CUST, caseType) || Objects.equals(Const.DIC_CASE_TYPE_RENT_CUST, caseType)) {
						String casePriceLow = null;
						String casePriceHigh = null;
						String[] casePriceArr = casePrice.split("-");
						if (casePriceArr.length >= 2) {
							casePriceLow = NumberHelper.formatNumber(StringUtil.parseDouble(casePriceArr[0]), NumberHelper.NUMBER_IN_2);
							casePriceHigh = NumberHelper.formatNumber(StringUtil.parseDouble(casePriceArr[1]), NumberHelper.NUMBER_IN_2);
						}
						casePrice = (null != casePriceLow && null != casePriceHigh) ? casePriceLow + "-" + casePriceHigh + (Objects.equals(Const.DIC_CASE_TYPE_BUY_CUST, caseType) ? "万 " : "元 ") : "";
					} else {
						String priceUnitStr = "元/月 ";
						if (null != a.getPriceUnit()) {
							priceUnitStr = erpDicDefinitionsMapper.getDicCnMsg(getOperator().getCityId(), "PRICE_UNIT", String.valueOf(a.getPriceUnit()));
						}
						casePrice = NumberHelper.formatNumber(StringUtil.parseDouble(casePrice), NumberHelper.NUMBER_IN_2) + (Objects.equals(Const.DIC_CASE_TYPE_SALE_FUN, caseType) ? "万 " : priceUnitStr);
					}
				}
				String caseSummaryInfo = (null != caseName ? " " + caseName + " " : "") + (null != room ? room + "室 " : "") + (null != caseArea ? caseArea : "") + (null != casePrice ? casePrice : "");
				a.setCaseSummaryInfo(caseSummaryInfo);
			});
		}
		dealPhoneBuildPermissions(mgrPhoneList);
		PageInfo<ErpFunViewLogDto> pageInfo = new PageInfo<>(mgrPhoneList);
		
		return ErpResponseJson.ok(pageInfo);
	}
	
    /**
     * 盘源权限
     * @param list
     */
    private void dealPhoneBuildPermissions(List<ErpFunViewLogDto> mgrPhoneList) {
    	Operator operator = getOperator();
		if (mgrPhoneList == null || mgrPhoneList.isEmpty()) {
			return;
		}
		List<Integer> saleIdList = new ArrayList<>();
		List<Integer> leaseIdList = new ArrayList<>();
		for (ErpFunViewLogDto erpFunViewLogDto : mgrPhoneList) {
			if (erpFunViewLogDto.getTargetType() == Const.HouseCustType.SALE) {
				saleIdList.add(erpFunViewLogDto.getTargetId());
			} else if (erpFunViewLogDto.getTargetType() == Const.HouseCustType.LEASE) {
				leaseIdList.add(erpFunViewLogDto.getTargetId());
			}
		}
		if (!saleIdList.isEmpty()) {
			ErpFunSaleExample erpFunSaleExample = new ErpFunSaleExample();
			erpFunSaleExample.setShardCityId(operator.getCityId());
			erpFunSaleExample.createCriteria().andSaleIdIn(saleIdList);
			List<ErpFunSale> saleList = erpFunSaleMapper.selectByExample(erpFunSaleExample);
			Map<Integer, ErpFunSale> salesMap = saleList.stream().collect(Collectors.toMap(ErpFunSale::getSaleId, o -> o));
			List<Integer> buildIdList  = new ArrayList<>(saleList.stream().map(ErpFunSale::getBuildId).collect(Collectors.toSet()));
			ErpBuildPermissionsExample erpBuildPermissionsExample = new ErpBuildPermissionsExample();
			erpBuildPermissionsExample.setShardCityId(operator.getCityId());
			erpBuildPermissionsExample.createCriteria().andCompIdEqualTo(operator.getCompId()).andOrganizationIdEqualTo(operator.getOrganizationId())
				.andBuildIdIn(buildIdList).andIsDelEqualTo(Byte.valueOf("0")).andViewPermissionEqualTo(Byte.valueOf("1"));
			List<ErpBuildPermissions> buildPermissionsList = erpBuildPermissionsMapper.selectByExample(erpBuildPermissionsExample);
			Map<Integer, ErpBuildPermissions> buildPermissionsMap = buildPermissionsList.stream().collect(HashMap::new,
					(m,b) -> m.put(b.getBuildId(), b), HashMap::putAll);
			for (ErpFunViewLogDto erpFunViewLogDto : mgrPhoneList) {
				if (erpFunViewLogDto.getTargetType() == Const.HouseCustType.SALE) {
					ErpFunSale erpFunSale = salesMap.get(erpFunViewLogDto.getTargetId());
					if (erpFunSale == null) {
						continue;
					}
					Integer buildId = erpFunSale.getBuildId();
					String useage = StringUtil.toString(erpFunSale.getSaleUseage(), "");
					ErpBuildPermissions erpBuildPermissions = buildPermissionsMap.get(buildId);
					if (erpBuildPermissions != null && erpBuildPermissions.getHouseUseage().contains(useage)) {
						erpFunViewLogDto.setViewPermission(1);
					}
					erpFunViewLogDto.setHouseLevel(erpFunSale.getSaleLevel());
					erpFunViewLogDto.setHousePlateType(erpFunSale.getPlateType());
					erpFunViewLogDto.setHouseOrganizationId(erpFunSale.getOrganizationId());
					erpFunViewLogDto.setHouseUserId(erpFunSale.getUserId());
					erpFunViewLogDto.setHouseStatus(erpFunSale.getSaleStatus());
				}
			}
		}
		if (!leaseIdList.isEmpty()) {
			ErpFunLeaseExample erpFunLeaseExample = new ErpFunLeaseExample();
			erpFunLeaseExample.setShardCityId(operator.getCityId());
			erpFunLeaseExample.createCriteria().andLeaseIdIn(leaseIdList);
			List<ErpFunLease> leaseList = erpFunLeaseMapper.selectByExample(erpFunLeaseExample);
			Map<Integer, ErpFunLease> leasesMap = leaseList.stream().collect(Collectors.toMap(ErpFunLease::getLeaseId, o -> o));
			List<Integer> buildIdList  = new ArrayList<>(leaseList.stream().map(ErpFunLease::getBuildId).collect(Collectors.toSet()));
			ErpBuildPermissionsExample erpBuildPermissionsExample = new ErpBuildPermissionsExample();
			erpBuildPermissionsExample.setShardCityId(operator.getCityId());
			erpBuildPermissionsExample.createCriteria().andCompIdEqualTo(operator.getCompId()).andOrganizationIdEqualTo(operator.getOrganizationId())
				.andBuildIdIn(buildIdList).andIsDelEqualTo(Byte.valueOf("0")).andViewPermissionEqualTo(Byte.valueOf("1"));
			List<ErpBuildPermissions> buildPermissionsList = erpBuildPermissionsMapper.selectByExample(erpBuildPermissionsExample);
			Map<Integer, ErpBuildPermissions> buildPermissionsMap = buildPermissionsList.stream().collect(HashMap::new,
					(m,b) -> m.put(b.getBuildId(), b), HashMap::putAll);
			for (ErpFunViewLogDto erpFunViewLogDto : mgrPhoneList) {
				if (erpFunViewLogDto.getTargetType() == Const.HouseCustType.LEASE) {
					ErpFunLease erpFunLease = leasesMap.get(erpFunViewLogDto.getTargetId());
					if (erpFunLease == null) {
						continue;
					}
					Integer buildId = erpFunLease.getBuildId();
					String useage = StringUtil.toString(erpFunLease.getLeaseUseage(), "");
					ErpBuildPermissions erpBuildPermissions = buildPermissionsMap.get(buildId);
					if (erpBuildPermissions != null && erpBuildPermissions.getHouseUseage().contains(useage)) {
						erpFunViewLogDto.setViewPermission(1);
					}
					erpFunViewLogDto.setHouseLevel(erpFunLease.getLeaseLevel());
					erpFunViewLogDto.setHousePlateType(erpFunLease.getPlateType());
					erpFunViewLogDto.setHouseOrganizationId(erpFunLease.getOrganizationId());
					erpFunViewLogDto.setHouseUserId(erpFunLease.getUserId());
					erpFunViewLogDto.setHouseStatus(erpFunLease.getLeaseStatus().byteValue());
				}
			}
		}
	}
	
	/**
	 * 获取移交求租数据列表
	 * @author 张宏利
	 * @since 2017年12月8日
	 * @param param
	 * @return
	 */
	@RequestMapping("/getTransDataList")
	public ErpResponseJson getTransDataList(@RequestBody BaseMapParam param) {
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		Integer id = param.getInteger("id");
		
		param.setInteger("compId", compId);
		ErpSystemSettingLogs settingLogsKey = new ErpSystemSettingLogs();
		settingLogsKey.setId(id);
		settingLogsKey.setShardCityId(cityId);
		ErpSystemSettingLogs settingLogs = erpSystemSettingLogsMapper.selectByPrimaryKey(settingLogsKey);
		if(settingLogs == null) {
			return ErpResponseJson.ok();
		}
		switch(settingLogs.getSslType()) {
			case 31:
				param.setObject("caseType", Const.DIC_CASE_TYPE_SALE_FUN);
				break;
			case 32:
				param.setObject("caseType", Const.DIC_CASE_TYPE_LEASE_FUN);
				break;
			case 33:
				param.setObject("caseType", Const.DIC_CASE_TYPE_BUY_CUST);
				break;
			case 34:
				param.setObject("caseType", Const.DIC_CASE_TYPE_RENT_CUST);
				break;
			default:
				return ErpResponseJson.ok();
		}
		String modification = settingLogs.getBeforeModification();
		if (modification == null) {
			return ErpResponseJson.ok();
		}
		param.setObject("caseIdList", modification.split(","));
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<Map<String, Object>> caseList = erpFunSaleMapper.getCaseList(cityId, param.getMap());
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(caseList);
		return ErpResponseJson.ok(pageInfo);
	}
	
	/**
	 * 获取操作日志列表
	 * 张雨
	 * @throws Exception 
	 * **/
	@ApiOperation("获取操作日志列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = LogListVo.class, message = "成功")
	})
	@RequestMapping("/getMgrOperateLog")
	public ErpResponseJson getLogList(@Valid @RequestBody GetLogListParam param) {
		//如果是美联的需求会走这一段逻辑
		if(getOperator().isMeiLianApi()){
			String record = (String)cacheUtil.get("/erpWeb/managerCenter/systemMonitor/getMgrOperateLog"
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
				erpSystemSettingLogs.setLogContent("查看了操作日志");
				erpSystemSettingLogsMapper.insertSelective(erpSystemSettingLogs);
				cacheUtil.put("/erpWeb/managerCenter/systemMonitor/getMgrOperateLog"
						+ getOperator().getArchiveId()+DateTimeHelper.formatDateTimetoString(new Date(),"yyy-MM-dd"),"1",86400);
			}
		}
		param.setCompId(getOperator().getCompId());
		if(param.getTime2()!=null){
			if(StringUtils.isNotBlank(param.getTime2())){
				param.setTime2(param.getTime2()+" 23:59:59");
			}
		}
		String order = "CREATE_TIME DESC";
		if(param.getOrderEnum()!=null && param.getOrderRule()!=null){
			String orderEnum = param.getOrderEnum();
			Integer orderRule = param.getOrderRule(); // 0:升序 1:降序
			/**  处理排序 **/
			// 时间:CREATION_TIME 操作人CREATE_UID  类型SSL_TYPE 影响人INFLUENCE_UID
			if(StringUtils.isNotBlank(orderEnum) && orderRule!=null) {
				String orderStr = orderRule == 1 ? "DESC" : "ASC";
				if("CREATION_TIME".equals(orderEnum)) {
					order = " CREATE_TIME " + orderStr;
				}
				if("CREATE_UID".equals(orderEnum)) {
					order = " CREATE_UID " + orderStr;
				}
				if("SSL_TYPE".equals(orderEnum)) {
					order = " SSL_TYPE " + orderStr;
				}
				if("INFLUENCE_UID".equals(orderEnum)) {
					order = " INFLUENCE_UID " + orderStr;
				}
			}
		}
		param.setOrderBy(order);
		param.setSslTypeNotIn(new Byte[] { 9, 29, 30 });// 排除不需要展示的项
		//**********************组织架构改版********************************
		if (getOperator().newOrganizationType()) {       //zt组织机构

			if (null != param.getOrganizationId() && param.getOrganizationId() == 0) {
				param.setOrganizationId(null);
			}
		}
		//**********************组织架构改版********************************
		Integer totalCount = null;
		if(null != param.getPageOffset() && 1 == param.getPageOffset().intValue()) {
			totalCount = erpSystemSettingLogsMapper.getListCount(param,getOperator().getCityId());
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), false);
		List<ErpSystemSettingLogsDto> erpSystemSettingLogs = erpSystemSettingLogsMapper.getLogList(param,getOperator().getCityId());
		Set<Integer> userIds = new HashSet<Integer>();
		for(ErpSystemSettingLogsDto dto:erpSystemSettingLogs){
			userIds.add(dto.getCreateUid());
			userIds.add(dto.getInfluenceUid());
		}
		if (!userIds.isEmpty()) {
			List<ErpFunUsers> list = erpFunUsersMapper.getUserListByUserIds(getOperator().getCityId(), userIds);
			Map<Integer, ErpFunUsers> userMap = list.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, val -> val));
			Byte[] haveDetail = new Byte[] { 1, 3, 14, 15, 16, 19, 31, 32, 33, 34, 37, 38,43};
			Set<Byte> haveDetailSet = new HashSet<>(Arrays.asList(haveDetail));
			for (ErpSystemSettingLogsDto dto : erpSystemSettingLogs) {
				ErpFunUsers user = userMap.get(dto.getCreateUid());
				if (user != null) {
					dto.setCreateUname(user.getUserName());
				}
				user = userMap.get(dto.getInfluenceUid());
				if (user != null) {
					dto.setInfluenceUname(user.getUserName());
				}
				if (haveDetailSet.contains(dto.getSslType())) {
					dto.setHaveDetail(1);// 表示有详情
				}
			}
		}
		PageInfo<ErpSystemSettingLogsDto> pageInfo = new PageInfo<ErpSystemSettingLogsDto>(erpSystemSettingLogs);
		if(null != totalCount) {
			pageInfo.setTotal(totalCount);
		}
		return ErpResponseJson.ok(pageInfo);
	}

	/**
	 * 钥匙日志列表
	 * @author 何传强
	 * @since 2017年8月28日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("钥匙日志列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunKeyDto.class, message = "成功")
	})
	@RequestMapping("/getMgrSubmitKeyLog")
	public ErpResponseJson getMgrSubmitKeyLog(@Valid @RequestBody GetMgrSubmitKeyLogParam param) {
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		String sDate1 = param.getsDate1();
		String sDate2 = param.getsDate2();
		String houseNo = param.getHouseNo();

		// 是否是新版组织机构版本
		param.setNewOrganizatione(getOperator().newOrganizationType());
		param.setOrganizationId(param.getOrganizationId());

		//如果是美联的需求会走这一段逻辑
		if(getOperator().isMeiLianApi()){
			String record = (String)cacheUtil.get("/erpWeb/managerCenter/systemMonitor/getMgrSubmitKeyLog"
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
				erpSystemSettingLogs.setLogContent("查看了钥匙日志");
				erpSystemSettingLogsMapper.insertSelective(erpSystemSettingLogs);
				cacheUtil.put("/erpWeb/managerCenter/systemMonitor/getMgrSubmitKeyLog"
						+ getOperator().getArchiveId()+DateTimeHelper.formatDateTimetoString(new Date(),"yyy-MM-dd"),"1",86400);
			}
		}

		// 初始化当前人的加盟商ID, 在后面的代码判断是否开启加盟商模式以及房源数据隔离, 来判断需不需要这个值
		Integer partnerId = getOperator().getPartnerId();
		// 需要判断加盟商信息
		CheckPartnerConfigDto configDto = erpFunPartnerConfigService.checkPartnerConfig(cityId, compId, partnerId, "houseDataApart");
		Byte openPartner = configDto.getOpenPartner();
		Byte isApart = configDto.getIsApart();

		// 只要不是公司开启了加盟商模式, 或者房源数据隔离, 那么就按以前的逻辑走(不带加盟商ID查询)
		// 直营看直营, 加盟商看加盟商, 总部看所有
		if (openPartner == 0 || isApart == 0 || partnerId == 0) {
			partnerId = null;
		}
		param.setPartnerId(partnerId);
		param.setCompId(compId);
		if (StringUtil.isNotBlank(sDate1)) {
			param.setStartTime(sDate1 + " 00:00:00");
		}
		if (StringUtil.isNotBlank(sDate2)) {
			param.setEndTime(sDate2 + " 23:59:59");
		}
		if (StringUtil.isNotBlank(houseNo)) {
			param.setHouseNo("%" + houseNo + "%");
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<ErpFunKeyDto> resList = erpFunKeyMapper.getMgrSubmitKeyLogList(cityId, param);
		PageInfo<ErpFunKeyDto> pageInfo = new PageInfo<>(resList);
		// 处理关联数据
		Set<Integer> saleIdSet = resList.stream()
				.filter(val -> Const.DIC_CASE_TYPE_SALE_FUN.equals(val.getCaseType().intValue()))
				.collect(Collectors.mapping(ErpFunKeyDto::getCaseId, Collectors.toSet()));
		Set<Integer> leaseIdSet = resList.stream()
				.filter(val -> Const.DIC_CASE_TYPE_LEASE_FUN.equals(val.getCaseType().intValue()))
				.collect(Collectors.mapping(ErpFunKeyDto::getCaseId, Collectors.toSet()));
		Map<Integer, ErpFunSale> saleMap = new HashMap<>();
		Map<Integer, ErpFunLease> leaseMap = new HashMap<>();
		// 查询房源数据
		if (saleIdSet.size() > 0) {
			String[] queryColumn = new String[] {
				"SALE_ID", "BUILD_NAME", "SALE_FLOOR", "SALE_FLOORS", "SALE_HALL", "SALE_ROOM",
				"SALE_WEI", "SALE_YANG", "SALE_TOTAL_PRICE", "SALE_USEAGE", "SALE_NO", "SALE_AREA"
			};
			List<ErpFunSale> funSaleList = erpFunSaleMapper.selectSaleListByIds(cityId, saleIdSet.toArray(new Integer[]{}), queryColumn, compId);
			saleMap = funSaleList.stream().collect(Collectors.toMap(ErpFunSale::getSaleId, val -> val));
		}
		// 查询房源数据
		if (leaseIdSet.size() > 0) {
			String[] queryColumn = new String[] {
				"LEASE_ID", "LEASE_TOTAL_PRICE", "BUILD_NAME", "LEASE_FLOOR", "LEASE_FLOORS", "LEASE_HALL",
				"LEASE_ROOM", "LEASE_WEI", "LEASE_YANG", "LEASE_USEAGE", "LEASE_NO", "LEASE_AREA", "PRICE_UNIT"
			};
			List<ErpFunLease> funLeaseList = erpFunLeaseMapper.selectLeaseListByIds(cityId, leaseIdSet.toArray(new Integer[]{}), queryColumn, compId);
			leaseMap = funLeaseList.stream().collect(Collectors.toMap(ErpFunLease::getLeaseId, val -> val));
		}
		for (ErpFunKeyDto funKeyDto : resList) {
			if (Const.DIC_CASE_TYPE_SALE_FUN.equals(funKeyDto.getCaseType().intValue())) {
				ErpFunSale erpFunSale = saleMap.get(funKeyDto.getCaseId());
				if (erpFunSale != null) {
					BigDecimal totalPrice = Optional.ofNullable(erpFunSale.getSaleTotalPrice()).orElse(BigDecimal.ZERO);
					funKeyDto.setBuildName(erpFunSale.getBuildName());
					funKeyDto.setFloor(StringUtil.parseInteger(erpFunSale.getSaleFloor()));
					funKeyDto.setFloors(StringUtil.parseInteger(erpFunSale.getSaleFloors()));
					funKeyDto.setHall(erpFunSale.getSaleHall());
					funKeyDto.setRoom(erpFunSale.getSaleRoom());
					funKeyDto.setWei(erpFunSale.getSaleWei());
					funKeyDto.setYang(erpFunSale.getSaleYang());
					funKeyDto.setTotalPrice(totalPrice.doubleValue());
					funKeyDto.setHouseUsage(erpFunSale.getSaleUseage());
					funKeyDto.setCaseNo(erpFunSale.getSaleNo());
					funKeyDto.setArea(erpFunSale.getSaleArea());
					String caseArea = NumberHelper.formatNumber(Optional.ofNullable(erpFunSale.getSaleArea()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2) + "㎡ ";
					String casePrice = NumberHelper.formatNumber(totalPrice.doubleValue(), NumberHelper.NUMBER_IN_2) + "万 ";
					String caseSummaryInfo = (null != erpFunSale.getBuildName() ? " " + erpFunSale.getBuildName() + " " : "") + (null != erpFunSale.getSaleRoom() ? erpFunSale.getSaleRoom() + "室 " : "") + caseArea + casePrice;
					funKeyDto.setCaseSummaryInfo(caseSummaryInfo);
				}
			} else {
				ErpFunLease erpFunLease = leaseMap.get(funKeyDto.getCaseId());
				if (erpFunLease != null) {
					BigDecimal totalPrice = Optional.ofNullable(erpFunLease.getLeaseTotalPrice()).orElse(BigDecimal.ZERO);
					funKeyDto.setBuildName(erpFunLease.getBuildName());
					funKeyDto.setFloor(StringUtil.parseInteger(erpFunLease.getLeaseFloor()));
					funKeyDto.setFloors(StringUtil.parseInteger(erpFunLease.getLeaseFloors()));
					funKeyDto.setHall(erpFunLease.getLeaseHall());
					funKeyDto.setRoom(erpFunLease.getLeaseRoom());
					funKeyDto.setWei(erpFunLease.getLeaseWei());
					funKeyDto.setYang(erpFunLease.getLeaseYang());
					funKeyDto.setTotalPrice(totalPrice.doubleValue());
					funKeyDto.setHouseUsage(erpFunLease.getLeaseUseage());
					funKeyDto.setCaseNo(erpFunLease.getLeaseNo());
					funKeyDto.setArea(erpFunLease.getLeaseArea());
					String caseArea = NumberHelper.formatNumber(Optional.ofNullable(erpFunLease.getLeaseArea()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2) + "㎡ ";
					String priceUnitStr = "元/月 ";
					if (null != erpFunLease.getPriceUnit()) {
						priceUnitStr = erpDicDefinitionsMapper.getDicCnMsg(cityId, "PRICE_UNIT", String.valueOf(erpFunLease.getPriceUnit()));
					}
					String casePrice = NumberHelper.formatNumber(totalPrice.doubleValue(), NumberHelper.NUMBER_IN_2) + priceUnitStr;
					String caseSummaryInfo = (null != erpFunLease.getBuildName() ? " " + erpFunLease.getBuildName() + " " : "") + (null != erpFunLease.getLeaseRoom() ? erpFunLease.getLeaseRoom() + "室 " : "") + caseArea + casePrice;
					funKeyDto.setCaseSummaryInfo(caseSummaryInfo);
				}
			}
			//判断是否外借
			if (funKeyDto != null){
				if (Const.OUT_BORROW.equals(funKeyDto.getLogType())){
					if (null != funKeyDto.getKeyLogId()){
						ErpFunPropertyKeyLog erpFunPropertyKeyLog = erpFunPropertyKeyLogMapper
																	.selectByPrimaryKey(new ErpFunPropertyKeyLog(cityId,funKeyDto.getKeyLogId()));
						if (erpFunPropertyKeyLog != null){
							funKeyDto.setDepositStatus(erpFunPropertyKeyLog.getDepositStatus());
						}
					}
				}
			}
		}
		dealKeyBuildPermissions(resList);
		return ErpResponseJson.ok(pageInfo);
	}
	
    /**
     * 盘源权限
     * @param list
     */
    private void dealKeyBuildPermissions(List<ErpFunKeyDto> resList) {
    	Operator operator = getOperator();
		if (resList == null || resList.isEmpty()) {
			return;
		}
		List<Integer> saleIdList = new ArrayList<>();
		List<Integer> leaseIdList = new ArrayList<>();
		for (ErpFunKeyDto erpFunKeyDto : resList) {
			if (erpFunKeyDto.getCaseType() == Const.HouseCustType.SALE) {
				saleIdList.add(erpFunKeyDto.getCaseId());
			} else if (erpFunKeyDto.getCaseType() == Const.HouseCustType.LEASE) {
				leaseIdList.add(erpFunKeyDto.getCaseId());
			}
		}
		if (!saleIdList.isEmpty()) {
			ErpFunSaleExample erpFunSaleExample = new ErpFunSaleExample();
			erpFunSaleExample.setShardCityId(operator.getCityId());
			erpFunSaleExample.createCriteria().andSaleIdIn(saleIdList);
			List<ErpFunSale> saleList = erpFunSaleMapper.selectByExample(erpFunSaleExample);
			Map<Integer, ErpFunSale> salesMap = saleList.stream().collect(Collectors.toMap(ErpFunSale::getSaleId, o -> o));
			List<Integer> buildIdList  = new ArrayList<>(saleList.stream().map(ErpFunSale::getBuildId).collect(Collectors.toSet()));
			ErpBuildPermissionsExample erpBuildPermissionsExample = new ErpBuildPermissionsExample();
			erpBuildPermissionsExample.setShardCityId(operator.getCityId());
			erpBuildPermissionsExample.createCriteria().andCompIdEqualTo(operator.getCompId()).andOrganizationIdEqualTo(operator.getOrganizationId())
				.andBuildIdIn(buildIdList).andIsDelEqualTo(Byte.valueOf("0")).andViewPermissionEqualTo(Byte.valueOf("1"));
			List<ErpBuildPermissions> buildPermissionsList = erpBuildPermissionsMapper.selectByExample(erpBuildPermissionsExample);
			Map<Integer, ErpBuildPermissions> buildPermissionsMap = buildPermissionsList.stream().collect(HashMap::new,
					(m,b) -> m.put(b.getBuildId(), b), HashMap::putAll);
			for (ErpFunKeyDto erpFunKeyDto : resList) {
				if (erpFunKeyDto.getCaseType() == Const.HouseCustType.SALE) {
					ErpFunSale erpFunSale = salesMap.get(erpFunKeyDto.getCaseId());
					if (erpFunSale == null) {
						continue;
					}
					Integer buildId = erpFunSale.getBuildId();
					String useage = StringUtil.toString(erpFunSale.getSaleUseage(), "");
					ErpBuildPermissions erpBuildPermissions = buildPermissionsMap.get(buildId);
					if (erpBuildPermissions != null && erpBuildPermissions.getHouseUseage().contains(useage)) {
						erpFunKeyDto.setViewPermission(1);
					}
					erpFunKeyDto.setHouseLevel(erpFunSale.getSaleLevel());
					erpFunKeyDto.setHousePlateType(erpFunSale.getPlateType());
					erpFunKeyDto.setHouseOrganizationId(erpFunSale.getOrganizationId());
					erpFunKeyDto.setHouseUserId(erpFunSale.getUserId());
					erpFunKeyDto.setHouseStatus(erpFunSale.getSaleStatus());
				}
			}
		}
		if (!leaseIdList.isEmpty()) {
			ErpFunLeaseExample erpFunLeaseExample = new ErpFunLeaseExample();
			erpFunLeaseExample.setShardCityId(operator.getCityId());
			erpFunLeaseExample.createCriteria().andLeaseIdIn(leaseIdList);
			List<ErpFunLease> leaseList = erpFunLeaseMapper.selectByExample(erpFunLeaseExample);
			Map<Integer, ErpFunLease> leasesMap = leaseList.stream().collect(Collectors.toMap(ErpFunLease::getLeaseId, o -> o));
			List<Integer> buildIdList  = new ArrayList<>(leaseList.stream().map(ErpFunLease::getBuildId).collect(Collectors.toSet()));
			ErpBuildPermissionsExample erpBuildPermissionsExample = new ErpBuildPermissionsExample();
			erpBuildPermissionsExample.setShardCityId(operator.getCityId());
			erpBuildPermissionsExample.createCriteria().andCompIdEqualTo(operator.getCompId()).andOrganizationIdEqualTo(operator.getOrganizationId())
				.andBuildIdIn(buildIdList).andIsDelEqualTo(Byte.valueOf("0")).andViewPermissionEqualTo(Byte.valueOf("1"));
			List<ErpBuildPermissions> buildPermissionsList = erpBuildPermissionsMapper.selectByExample(erpBuildPermissionsExample);
			Map<Integer, ErpBuildPermissions> buildPermissionsMap = buildPermissionsList.stream().collect(HashMap::new,
					(m,b) -> m.put(b.getBuildId(), b), HashMap::putAll);
			for (ErpFunKeyDto erpFunKeyDto : resList) {
				if (erpFunKeyDto.getCaseType() == Const.HouseCustType.LEASE) {
					ErpFunLease erpFunLease = leasesMap.get(erpFunKeyDto.getCaseId());
					if (erpFunLease == null) {
						continue;
					}
					Integer buildId = erpFunLease.getBuildId();
					String useage = StringUtil.toString(erpFunLease.getLeaseUseage(), "");
					ErpBuildPermissions erpBuildPermissions = buildPermissionsMap.get(buildId);
					if (erpBuildPermissions != null && erpBuildPermissions.getHouseUseage().contains(useage)) {
						erpFunKeyDto.setViewPermission(1);
					}
					erpFunKeyDto.setHouseLevel(erpFunLease.getLeaseLevel());
					erpFunKeyDto.setHousePlateType(erpFunLease.getPlateType());
					erpFunKeyDto.setHouseOrganizationId(erpFunLease.getOrganizationId());
					erpFunKeyDto.setHouseUserId(erpFunLease.getUserId());
					erpFunKeyDto.setHouseStatus(erpFunLease.getLeaseStatus().byteValue());
				}
			}
		}
	}
	
	/**
	 * 系统登陆日志列表
	 * 张雨
	 */
	@ApiOperation("系统登陆日志列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunPrologsVo.class, message = "成功")
	})
	@PostMapping("/getMgrSysLoginLogs")
	public ErpResponseJson getSysLoginLogs(@Valid @RequestBody GetSysLoginLogsParam param) {
		//如果是美联的需求会走这一段逻辑
		if(getOperator().isMeiLianApi()){
			String record = (String)cacheUtil.get("/erpWeb/managerCenter/systemMonitor/getMgrSysLoginLogs"
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
				erpSystemSettingLogs.setLogContent("查看了系统登录");
				erpSystemSettingLogsMapper.insertSelective(erpSystemSettingLogs);
				cacheUtil.put("/erpWeb/managerCenter/systemMonitor/getMgrSysLoginLogs"
						+ getOperator().getArchiveId()+DateTimeHelper.formatDateTimetoString(new Date(),"yyy-MM-dd"),"1",86400);
			}
		}
		param.setCompId(getOperator().getCompId());
		param.setDeviceType(0);// 默认为erp端登陆
		if (param.getDate2() != null) {
			param.setDate2(param.getDate2() + " 23:59:59");
		}
		//**********************组织架构改版********************************
		if (getOperator().newOrganizationType()) {       //zt组织机构
			if (null != param.getOrganizationId() && param.getOrganizationId() == 0) {
				param.setOrganizationId(null);
			}
		}
		//**********************组织架构改版********************************

		//导出最多 导出2000条
		if ( param.getIsExport() != null && 1 == param.getIsExport()){
			param.setPageRows(2000);
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
			List<ErpFunPrologs> sysLoginLogs = erpFunPrologsMapper.getSysLoginLogs(param, getOperator().getCityId());
			PageInfo<ErpFunPrologs> pageInfo = new PageInfo<>(sysLoginLogs);
			ErpFunPrologsVo resultListVo = new ErpFunPrologsVo(pageInfo);
			return ErpResponseJson.ok(resultListVo);
		} else {
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
			List<ErpFunPrologs> sysLoginLogs = erpFunPrologsMapper.getSysLoginLogs(param, getOperator().getCityId());
			PageInfo<ErpFunPrologs> pageInfo = new PageInfo<>(sysLoginLogs);
			ErpFunPrologsVo resultListVo = new ErpFunPrologsVo(pageInfo);
			return ErpResponseJson.ok(resultListVo);
		}
	}
	
	/**
	 * 手机APP登陆日志列表
	 * flj
	 */
	@ApiOperation("手机APP登陆日志列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunPrologsVo.class, message = "成功")
	})
	@PostMapping("/getAppLoginLogs")
	public ErpResponseJson getAppLoginLogs(@Valid @RequestBody GetSysLoginLogsParam param) {
		param.setCompId(getOperator().getCompId());
		if (param.getDate2() != null) {
			param.setDate2(param.getDate2() + " 23:59:59");
		}
		//**********************组织架构改版********************************
		if (getOperator().newOrganizationType()) {       //zt组织机构
			if (null != param.getOrganizationId() && param.getOrganizationId() == 0) {
				param.setOrganizationId(null);
			}
		}
		//**********************组织架构改版********************************
		if (param.getIsExport() != null && param.getIsExport() == 1) {
			param.setPageRows(2000);
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
			List<ErpFunPrologs> sysLoginLogs = erpFunPrologsMapper.getSysLoginLogs(param, getOperator().getCityId());
			PageInfo<ErpFunPrologs> pageInfo = new PageInfo<>(sysLoginLogs);
			ErpFunPrologsVo resultListVo = new ErpFunPrologsVo(pageInfo);
			return ErpResponseJson.ok(resultListVo);
		} else {
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
			List<ErpFunPrologs> sysLoginLogs = erpFunPrologsMapper.getSysLoginLogs(param, getOperator().getCityId());
			PageInfo<ErpFunPrologs> pageInfo = new PageInfo<>(sysLoginLogs);
			ErpFunPrologsVo resultListVo = new ErpFunPrologsVo(pageInfo);
			return ErpResponseJson.ok(resultListVo);
		}
	}
	
	/**
	 * 掌通获取手机APP登陆日志列表（详情页共用这个接口，需要前端传USER_ID参数）
	 * @author HuangJiang
	 * @since 2019年7月1日 上午9:38:48
	 * @param param
	 * @return
	 * Modified XXX HuangJiang 2019年7月1日
	 */
	@ApiOperation("掌通获取手机APP登陆日志列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ZtGetAppLoginLogsVo.class, message = "成功")
	})
	@PostMapping("/ztGetAppLoginLogs")
	public ErpResponseJson ztGetAppLoginLogs(@Valid @RequestBody ZtGetAppLoginLogsParam param) {
		if (null == param.getCompId()){
			param.setCompId(getOperator().getCompId());
		}
		if (null != param.getEndTime()) {
			param.setEndTime(param.getEndTime() + " 23:59:59");
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<ZtAppLoginListVo> list = erpFunPrologsMapper.getZtAppLoginLogList(param, getOperator().getCityId());
		PageInfo<ZtAppLoginListVo> pageInfo = new PageInfo<>(list);
		ZtGetAppLoginLogsVo vo = new ZtGetAppLoginLogsVo(pageInfo);
		return ErpResponseJson.ok(vo);
	}
	
	/**
	 * 考勤修改日志列表
	 * 张雨
	 */
	@RequestMapping("/getAttendanceRecordList")
	public ErpResponseJson getAttendanceRecordList(@Valid @RequestBody BaseMapParam param) {
		//如果是美联的需求会走这一段逻辑
		if(getOperator().isMeiLianApi()){
			String record = (String)cacheUtil.get("/erpWeb/managerCenter/systemMonitor/getAttendanceRecordList"
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
				erpSystemSettingLogs.setLogContent("查看了考勤修改");
				erpSystemSettingLogsMapper.insertSelective(erpSystemSettingLogs);
				cacheUtil.put("/erpWeb/managerCenter/systemMonitor/getAttendanceRecordList"
						+ getOperator().getArchiveId()+DateTimeHelper.formatDateTimetoString(new Date(),"yyy-MM-dd"),"1",86400);
			}
		}
		Map<String, Object> pMap = param.getMap();
		pMap.put("compId", getOperator().getCompId());
		if(pMap.get("date2")!=null){
			if(org.apache.commons.lang.StringUtils.isNotBlank(String.valueOf(pMap.get("date2")))){
				pMap.put("date2", pMap.get("date2")+" 23:59:59");
			}
		}
//		ErpSysParaKey paraKey = new ErpSysParaKey();
//		paraKey.setCompId(getOperator().getCompId());
//		paraKey.setParamId("ATTENDANCE_MODEL");
//		paraKey.setShardCityId(getOperator().getCityId());
//		ErpSysPara erpSysPara = erpSysParaMapper.selectByPrimaryKey(paraKey);
		ErpSysPara erpSysPara = erpSysParaMapper.getValueById(getOperator().getCityId(), getOperator().getCompId(), "ATTENDANCE_MODEL");

		Boolean attendanceFlag = false;
		if(erpSysPara != null){
			attendanceFlag = "1".equals(erpSysPara.getParamValue()) ;
		}
		//**********************组织架构改版********************************
		if (getOperator().newOrganizationType()) {       //zt组织机构
			if (null != param.getInteger("organizationId") && param.getInteger("organizationId") == 0) {
				param.setInteger("organizationId",null);
			}
		}
		//**********************组织架构改版********************************
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<ErpAttendanceChangeRecordDto> attendanceRecordList = erpAttendanceChangeRecordMapper.getAttendanceRecordList(pMap, getOperator().getCityId());
		for(ErpAttendanceChangeRecordDto dto : attendanceRecordList){
			String workDetailType = dto.getWorkDetailType();
			if(Const.DIC_WORK_TYPE_ONWORK.equals(workDetailType)||Const.DIC_WORK_TYPE_FREE.equals(workDetailType)){
				if(attendanceFlag&&Const.DIC_WORK_TYPE_ONWORK.equals(workDetailType)){
					dto.setWorkDetailType("早班");
				}else{
					dto.setWorkDetailType("正常");
				}
			}else if(Const.DIC_WORK_TYPE_DUTYWORK.equals(workDetailType)||Const.DIC_WORK_TYPE_DUTYFREE.equals(workDetailType)){
				dto.setWorkDetailType("值班");
			}else if(Const.DIC_WORK_TYPE_LATEWORK.equals(workDetailType)||Const.DIC_WORK_TYPE_EARYFREE.equals(workDetailType)){
				dto.setWorkDetailType("晚班");
			}else{
				dto.setWorkDetailType("空");
			}
		}
		PageInfo<ErpAttendanceChangeRecordDto> pageInfo = new PageInfo<ErpAttendanceChangeRecordDto>(attendanceRecordList);
		return ErpResponseJson.ok(pageInfo);
	}
	
	/**
	 * 跟进日志列表
	 * flj
	 * @throws Exception 
	 */
	@RequestMapping("/getMgrTrackList")
	public ErpResponseJson getMgrTrackList(@Valid @RequestBody BaseMapParam param) throws Exception {
		// Map<String,Object> map = erpFunTrackService.selectMgrTrackList(param,
		// getOperator());
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> map = param.getMap();
		map.put("compId", operator.getCompId());
		if (map.get("date2") != null
				&& org.apache.commons.lang.StringUtils.isNotBlank(String.valueOf(map.get("date2")))) {
			map.put("date2", map.get("date2") + " 23:59:59");
		}
		List<ErpFunTrackDto> list = erpFunTrackMapper.selectMgrTrackList(map, operator.getCityId());
		if (null == list || list.isEmpty()) {
			return ErpResponseJson.ok();
		}
		resultMap.put("total", list.size());
		resultMap.put("trackList", list);
		Set<Integer> queryKeyList = new HashSet<Integer>();
		if ("BY_USER".equals(String.valueOf(param.getString("operType")))) {
			if (!BaseUtil.isEmpty(list)) {
				for (ErpFunTrackDto vo : list) {
					queryKeyList.add(vo.getCaseId());
				}
			}
		}
		Map<String, Object> ownerUserMap = null;
		String delContent = "该房源跟进已被管理员删除";
		String caseType = param.getString("caseType");
		if (Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			delContent = "该房源跟进已被管理员删除";
		} else if (Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			delContent = "该房源跟进已被管理员删除";
		} else if (Constants_DIC.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
			delContent = "该客源跟进已被管理员删除";
		} else if (Constants_DIC.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
			delContent = "该客源跟进已被管理员删除";
		}
		if (!BaseUtil.isEmpty(queryKeyList)) {
			if (Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
				List<Map<String, Object>> saleList = erpFunSaleMapper.selectFunSaleListByIds(operator.getCityId(),
						queryKeyList.toArray(new Integer[] {}), new String[] { "USER_ID", "SALE_ID" },
						operator.getCompId());
				ownerUserMap = BeanUtilsHelper.listMapToMapObject(saleList, "SALE_ID");
			} else if (Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
				List<Map<String, Object>> leaseList = erpFunLeaseMapper.selectFunLeaseListByIds(operator.getCityId(),
						queryKeyList.toArray(new Integer[] {}), new String[] { "USER_ID", "LEASE_ID" },
						operator.getCompId());
				ownerUserMap = BeanUtilsHelper.listMapToMapObject(leaseList, "LEASE_ID");
			} else if (Constants_DIC.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
				List<Map<String, Object>> leaseList = erpFunLeaseMapper.selectFunLeaseListByIds(operator.getCityId(),
						queryKeyList.toArray(new Integer[] {}), new String[] { "USER_ID", "BUY_CUST_ID" },
						operator.getCompId());
				ownerUserMap = BeanUtilsHelper.listMapToMapObject(leaseList, "BUY_CUST_ID");
			} else if (Constants_DIC.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
				List<Map<String, Object>> leaseList = erpFunLeaseMapper.selectFunLeaseListByIds(operator.getCityId(),
						queryKeyList.toArray(new Integer[] {}), new String[] { "USER_ID", "RENT_CUST_ID" },
						operator.getCompId());
				ownerUserMap = BeanUtilsHelper.listMapToMapObject(leaseList, "RENT_CUST_ID");
			}
		}
		List<ErpFunUsers> userList = erpFunUsersMapper.getRecordsByCompIdAndUserWriteOff(cityId, compId, 0);
		Map<Object, ErpFunUsers> userMap = BeanUtilsHelper.listToMapObjectOffKeyType(userList, "userId");
		for (ErpFunTrackDto dto : list) {
			Integer trackUserId = dto.getCreatorUid();
			ErpFunUsers usersPO = userMap.get(trackUserId);
			if (usersPO != null) {
				dto.setViewName(usersPO.getUserName());
			}
			if (!"1".equals(String.valueOf(dto.getIsDel()))) {
				continue;
			}
			if (ownerUserMap != null) {
				Integer ownerUserId = null;
				if (Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
					ErpFunSale funSalePO = (ErpFunSale) ownerUserMap.get(dto.getCaseId());
					if (funSalePO != null) {
						ownerUserId = funSalePO.getUserId();
					}
				} else if (Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
					ErpFunLease funLeasePO = (ErpFunLease) ownerUserMap.get(dto.getCaseId());
					if (funLeasePO != null) {
						ownerUserId = funLeasePO.getUserId();
					}
				} else if (Constants_DIC.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
					ErpFunBuyCustomer funBuyCustomerPO = (ErpFunBuyCustomer) ownerUserMap.get(dto.getCaseId());
					if (funBuyCustomerPO != null) {
						ownerUserId = funBuyCustomerPO.getUserId();
					}
				} else if (Constants_DIC.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
					ErpFunRentCustomer funRentCustomerPO = (ErpFunRentCustomer) ownerUserMap.get(dto.getCaseId());
					if (funRentCustomerPO != null) {
						ownerUserId = funRentCustomerPO.getUserId();
					}
				}

				if (operator.getUserId().equals(ownerUserId) || operator.getUserId().equals(dto.getCreatorUid())) {
					dto.setCanView("1");
				} else {
					String trackConent = dto.getTrackContent();
					trackConent = buildDelTrackContent(trackConent);
					trackConent += delContent;
					dto.setTrackContent(trackConent);
				}
				dto.setOwnerUserId(ownerUserId);
			} else {
				if (operator.getUserId().equals(dto.getOwnerUserId())
						|| operator.getUserId().equals(dto.getCreatorUid())) {
					dto.setCanView("1");
				} else {
					String trackConent = dto.getTrackContent();
					trackConent = buildDelTrackContent(trackConent);
					trackConent += delContent;
					dto.setTrackContent(trackConent);
				}
			}
		}
		Set<Integer> trackIds = new HashSet<Integer>(list.size());
		for (ErpFunTrackDto dto : list) {
			if (Const.DIC_TRACK_TYPE_DAIKAN.equals(dto.getTrackType())) {
				trackIds.add(dto.getTrackId());
			}
		}
		if (!BaseUtil.isEmpty(trackIds)) {

			List<ErpTrackUsersDto> trackUserList = erpTrackUsersMapper.getTrackUsersListByTrackIds(operator.getCityId(),
					trackIds.toArray(new Integer[] {}), new String[] { "TRACK_ID", "USER_NAME" }, operator.getCompId());
			Map<Integer, String> trackUserMap = new HashMap<Integer, String>();
			for (ErpTrackUsersDto trackUserDto : trackUserList) {
				Integer trackId = trackUserDto.getTrackId();
				String userName = trackUserMap.get(trackId);
				if (StringUtil.isNotBlank(userName)) {
					userName = userName + "," + trackUserDto.getUsername();
				} else {
					trackUserMap.put(trackId, trackUserDto.getUsername());
				}
			}
			resultMap.put("userList", trackUserList);
		}
		ErpResponseJson erpResponseJson = new ErpResponseJson(resultMap);
		String total = String.valueOf(resultMap.get("total"));
		if (StringUtils.isNotBlank(total)) {
			erpResponseJson.setTotal(Long.valueOf(total));
		}
		erpResponseJson.setPageNum(param.getPageOffset());
		erpResponseJson.setPageSize(param.getPageRows());
		return erpResponseJson;
	}
	
	/**
	 * 获取app登录设备审核列表
	 * @author 何传强
	 * @since 2017年6月12日
	 * @param deptId 门店ID
	 * @returns
	 * @throws Exception
	 */
    @ApiOperation("获取app登录设备审核列表")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpAppLoginDeviceVo.class, message = "成功")
    })
	@RequestMapping("/getAppLoginDeviceList")
	public ErpResponseJson getAppLoginDeviceList(@Valid @RequestBody GetAppLoginDeviceListParam param) {
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		param.setCompId(getOperator().getCompId());
		List<ErpAppLoginDeviceDto> appLoginDeviceList = erpAppLoginDeviceMapper.getAppLoginDeviceList(getOperator().getCityId(), param);
		if(appLoginDeviceList == null || appLoginDeviceList.size() <= 0) {
			return ErpResponseJson.ok();
		}
		Set<Integer> userIds = new HashSet<>();
		appLoginDeviceList.stream().forEach(dieice -> {
			userIds.add(dieice.getUserId());
			userIds.add(dieice.getCheckUserId());
		});
		// 获取员工列表
		if(userIds.size() > 0) {
			List<ErpFunUsers> userList = erpFunUsersMapper.getUserListByUserIds(getOperator().getCityId(), userIds);
			Map<Integer, ErpFunUsers> userMap = userList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, user -> user));
			for (ErpAppLoginDeviceDto erpAppLoginDevice : appLoginDeviceList) {
				ErpFunUsers erpFunUsers = userMap.get(erpAppLoginDevice.getUserId());
				if (erpFunUsers != null) {
					erpAppLoginDevice.setUserName(erpFunUsers.getUserName());
				}
				erpFunUsers = userMap.get(erpAppLoginDevice.getCheckUserId());
				if (erpFunUsers != null) {
					erpAppLoginDevice.setCheckUserName(erpFunUsers.getUserName());
				}
			}
		}
		PageInfo<ErpAppLoginDeviceDto> pageInfo = new PageInfo<ErpAppLoginDeviceDto>(appLoginDeviceList);
		return ErpResponseJson.ok(pageInfo);
	}
	
	/**
	 * 审核app设备是否登录
	 * @author 熊刚
	 * @since 2017年6月9日
	 * @param deviceStatus 审核状态  loginId app登录设备审核表主键ID  userId 用户id 
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("审核app设备是否登录")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@RequestMapping("/updateDeviceStatus")
	@NotBlank({ "loginId", "deviceStatus" })
	public ErpResponseJson updateDeviceStatus(@Valid @RequestBody UpdateDeviceStatusParam param) {
		param.setCompId(getOperator().getCompId());
		param.setCityId(getOperator().getCityId());
		erpAppLoginDeviceService.updateDeviceStatus(param);
		return ErpResponseJson.ok();
	}

	private String buildDelTrackContent(String trackContent) throws Exception{
		int startIndex = trackContent.lastIndexOf("跟进内容：");
		if(startIndex!=-1){
			trackContent = trackContent.substring(0, startIndex+"跟进内容：".length());
		}else{
			startIndex = trackContent.lastIndexOf("查看原因：");
			if(startIndex!=-1){
				trackContent = trackContent.substring(0, startIndex+"查看原因：".length());
			}
		}
		return trackContent;
	}
	
	/**
	 * 删除跟进日志
	 * @author 熊刚
	 * @since 2017年9月21日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteFunTrack")
	public ErpResponseJson deleteFunTrack(@Valid @RequestBody BaseMapParam param) throws Exception {
		param.setInteger("userId", getOperator().getUserId());
		param.setString("userName", getOperator().getUserName());
		param.setInteger("cityId", getOperator().getCityId());
		erpFunTrackService.deleteFunTrack(getOperator().getCityId(), param);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 获取监控密码
	 * @author 熊刚
	 * @since 2017年9月21日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getMgrInstallPwd")
	public ErpResponseJson getMgrInstallPwd(@Valid @RequestBody BaseMapParam param) throws Exception {
		Operator operator = getOperator();
		boolean newOrganizationType = operator.newOrganizationType();
		Integer deptId = param.getInteger("deptId"); // 门店
		Integer organizationId = param.getInteger("organizationId"); // 门店
		List<Map<String, String>> returnList = new ArrayList<Map<String, String>>();
		ErpFunComp erpFunComp = new ErpFunComp();
		erpFunComp.setCompId(getOperator().getCompId());
		erpFunComp.setShardCityId(getOperator().getCityId());
		erpFunComp = erpFunCompMapper.getCompInfoByCompId(erpFunComp);
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("compNo", getOperator().getCompNo());
		if(newOrganizationType) {
			ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(operator.getCityId(), operator.getCompId(), organizationId);
			if(null != erpFunOrganization) {
				resultMap.put("organizationId", erpFunOrganization.getOrganizationNo());
			}

		}else {
			ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(getOperator().getCityId(), deptId);
			resultMap.put("deptNo", erpFunDepts.getDeptNo());
		}

		resultMap.put("plaintPwd", erpFunComp.getPlaintPwd()); // 取明文密码
		returnList.add(resultMap);
		return ErpResponseJson.ok(returnList);
	}
	
	/**
	 * 获取注册管理员信息
	 * @author 熊刚
	 * @since 2017年9月25日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getMgrRegistManagerUser")
	public ErpResponseJson getMgrRegistManagerUser(@Valid @RequestBody BaseMapParam param) throws Exception {
		List<ErpFunUsers> erpFunUsersList =erpFunUsersMapper.getMgrRegistManagerUser(getOperator().getCityId(),getOperator().getCompId());
		return ErpResponseJson.ok(erpFunUsersList);
	}
	
	/**
	 * 获取指定公司的注册标记
	 * @author 熊刚
	 * @since 2017年9月25日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getMgrRegistFlag")
	public ErpResponseJson getMgrRegistFlag(@Valid @RequestBody BaseMapParam param) throws Exception {
		List<Map<String,Object>> RegistFlagMap =erpFunCompMapper.getMgrRegistFlag(getOperator().getCityId(),getOperator().getCompId());
		return ErpResponseJson.ok(RegistFlagMap);
	}
	
	/**
	 * 设置安装列表管理员
	 * @author 熊刚
	 * @since 2017年9月25日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/setRegistManager")
	public ErpResponseJson setRegistManager(@Valid @RequestBody BaseMapParam param) throws Exception {
		erpUserOpersService.setRegistManager(getOperator().getCityId(),param.getInteger("userId"),getOperator().getCompId());
		return ErpResponseJson.ok();
	}
	
	/**
	 * 允许或者禁止注册
	 * @author 熊刚
	 * @since 2017年9月25日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/chgRegist")
	public ErpResponseJson chgRegist(@Valid @RequestBody BaseMapParam param) throws Exception {
		erpFunCompService.chgRegist(getOperator().getCityId(),getOperator().getCompId(),getOperator().getCompNo(),param.getInteger("registFlag"));
		return ErpResponseJson.ok();
	}

	/**
	 * 管理中心-钥匙借用列表
	 * @author lcb
	 * @since 2017-09-28
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getMgrBorrowKeyLog")
	public ErpResponseJson getMgrBorrowKeyLog(@Valid @RequestBody BaseMapParam param) throws Exception {
		Map<String, Object> paramMap = param.getMap();
		Operator operator = getOperator();
		paramMap.put("compId", operator.getCompId());

		// 是否是新版组织架构 0=否 1=是
		paramMap.put("newOrganizationType", getOperator().newOrganizationType() ? 1 : 0);

		Integer partnerId = operator.getPartnerId();
		// 需要判断加盟商信息
		CheckPartnerConfigDto configDto = erpFunPartnerConfigService.checkPartnerConfig(operator.getCityId(), operator.getCompId(), partnerId, "houseDataApart");
		Byte openPartner = configDto.getOpenPartner();
		Byte isApart = configDto.getIsApart();

		// 只要不是公司开启了加盟商模式, 或者房源数据隔离, 那么就按以前的逻辑走(不带加盟商ID查询)
		// 直营看直营, 加盟商看加盟商, 总部看所有
		if (openPartner == 0 || isApart == 0 || partnerId == 0) {
			partnerId = null;
		}
		paramMap.put("partnerId", partnerId);

		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<ErpFunKeyOperationLogDto> funKeyOperationLogList = erpFunKeyOperationLogMapper.getFunKeyOperationLogList(operator.getCityId(), paramMap);
		
		// 遍历每个提醒，以类型分类
		Map<Integer, ErpFunSale> saleMap = null;
		Map<Integer, ErpFunLease> leaseMap = null;
		Map<Integer, List<ErpFunKeyOperationLogDto>> caseTypeMap = funKeyOperationLogList.stream().filter(log -> null != log.getCaseType()).collect(Collectors.groupingBy(ErpFunKeyOperationLogDto :: getCaseType));
		if (null != caseTypeMap) {
			List<ErpFunKeyOperationLogDto> saleLog = caseTypeMap.get(1);
			List<ErpFunKeyOperationLogDto> leaseLog = caseTypeMap.get(2);
			if (null != saleLog) {
				List<Integer> saleIdList = saleLog.stream().map(ErpFunKeyOperationLogDto :: getCaseId).collect(Collectors.toList());
				if (!saleIdList.isEmpty()) {
					ErpFunSaleExample erpFunSaleExample = new ErpFunSaleExample();
					erpFunSaleExample.setShardCityId(operator.getCityId());
					erpFunSaleExample.createCriteria().andSaleIdIn(saleIdList);
					List<ErpFunSale> erpFunSaleList = erpFunSaleMapper.selectByExample(erpFunSaleExample);
					saleMap = erpFunSaleList.stream().collect(Collectors.toMap(ErpFunSale :: getSaleId, val -> val, (oldVal, newVal) -> oldVal));
				}
			}
			if (null != leaseLog) {
				List<Integer> leaseIdList = leaseLog.stream().map(ErpFunKeyOperationLogDto :: getCaseId).collect(Collectors.toList());
				if (!leaseIdList.isEmpty()) {
					ErpFunLeaseExample erpFunLeaseExample = new ErpFunLeaseExample();
					erpFunLeaseExample.setShardCityId(operator.getCityId());
					erpFunLeaseExample.createCriteria().andLeaseIdIn(leaseIdList);
					List<ErpFunLease> erpFunLeaseList = erpFunLeaseMapper.selectByExample(erpFunLeaseExample);
					leaseMap = erpFunLeaseList.stream().collect(Collectors.toMap(ErpFunLease :: getLeaseId, val -> val, (oldVal, newVal) -> oldVal));
				}
			}
		}
		
		for (ErpFunKeyOperationLogDto erpFunKeyOperationLogDto : funKeyOperationLogList) {
			if(StringUtils.isNotBlank(erpFunKeyOperationLogDto.getOperationDesc())) {
				erpFunKeyOperationLogDto.setOperationDesc(erpFunKeyOperationLogDto.getOperationDesc().replaceAll("\\n",""));
			}
			// 10254 系统监控等跟进、任务列表，房、客源编号统一更换为房、客源简要信息（点击链接保留）
			String caseName = null;
			String caseArea = null;
			String casePrice = null;
			Byte room = null;
			Integer caseType = erpFunKeyOperationLogDto.getCaseType();
			Integer caseId = erpFunKeyOperationLogDto.getCaseId();
			if (null != caseType && null != caseId) {
				if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType) && null != saleMap) {
					ErpFunSale erpFunSale = saleMap.get(caseId);
					if (null != erpFunSale) {
						caseName = erpFunSale.getBuildName();
						caseArea = NumberHelper.formatNumber(Optional.ofNullable(erpFunSale.getSaleArea()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2) + "㎡ ";
						casePrice = NumberHelper.formatNumber(Optional.ofNullable(erpFunSale.getSaleTotalPrice()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2) + "万 ";
						room = erpFunSale.getSaleRoom();
					}
				}
				if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType) && null != leaseMap) {
					ErpFunLease erpFunLease = leaseMap.get(caseId);
					if (null != erpFunLease) {
						String priceUnitStr = "元/月";
						if (null != erpFunLease.getPriceUnit()) {
							priceUnitStr = erpDicDefinitionsMapper.getDicCnMsg(operator.getCityId(), "PRICE_UNIT", String.valueOf(erpFunLease.getPriceUnit()));
						}
						caseName = erpFunLease.getBuildName();
						caseArea = NumberHelper.formatNumber(Optional.ofNullable(erpFunLease.getLeaseArea()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2) + "㎡ ";
						casePrice = NumberHelper.formatNumber(Optional.ofNullable(erpFunLease.getLeaseTotalPrice()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2) + priceUnitStr + " ";
						room = erpFunLease.getLeaseRoom();
					}
				}
				String caseSummaryInfo = (null != caseName ? " " + caseName + " " : "") + (null != room ? room + "室 " : "") + (null != caseArea ? caseArea : "") + (null != casePrice ? casePrice : "");
				erpFunKeyOperationLogDto.setCaseSummaryInfo(caseSummaryInfo);
			}
		}
		PageInfo pageInfo = new PageInfo<>(funKeyOperationLogList);
		return ErpResponseJson.ok(pageInfo);
	}
	
	/**
	 * 系统监控-获取操作日志对比记录列表
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/4/13
	 */
	@ApiOperation("获取操作日志对比记录列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpSystemSettingLogsVo.class, message = "成功")
	})
	@PostMapping("/getOperateLogDetail")
	@NotBlank("id")
	public ErpResponseJson getOperateLogDetail(@Valid @RequestBody SystemMonitorParam param) {
		Integer cityId = getOperator().getCityId();
		Integer id = param.getId();
		Map<String, Object> resultMap = new HashMap<>();
		
		ErpSystemSettingLogs settingLogsKey = new ErpSystemSettingLogs();
		settingLogsKey.setId(id);
		settingLogsKey.setShardCityId(cityId);
		ErpSystemSettingLogs settingLogs = erpSystemSettingLogsMapper.selectByPrimaryKey(settingLogsKey);
		String sslType = null;
		if (settingLogs.getSslType() != null) {
			sslType = settingLogs.getSslType().toString();
		}
		String beforeJson = BeanUtil.underlineToCamelKey(settingLogs.getBeforeModification());
		String afterJson = BeanUtil.underlineToCamelKey(settingLogs.getAfterModification());
		Map<String, Object> beforeJsonMap= (Map<String, Object>)JSON.parse(beforeJson);
		Map<String, Object> afterJsonMap=(Map<String, Object>)JSON.parse(afterJson);

		if (beforeJsonMap == null || afterJsonMap == null) {
			resultMap.put("oldVal", "");
			resultMap.put("newVal", "");
		}
		//增加类型 前端要求这个写
		JSONObject jsonObject = new JSONObject();
		ArrayList<JSONObject> list = new ArrayList<>();
		jsonObject.put("modular", settingLogs.getModular());
		list.add(jsonObject);
		resultMap.put("modular", list);

		switch (sslType) {
			case "1":// 用户权限
				resultMap.put("oldVal", beforeJsonMap.get("userOpersList"));
				resultMap.put("newVal", afterJsonMap.get("userOpersList"));
				break;
			case "3":// 用户信息
				resultMap.put("oldVal", beforeJsonMap.get("funUsers"));
				resultMap.put("newVal", afterJsonMap.get("funUsers"));
				break;
			case "14":// 大区修改
				resultMap.put("oldVal",  beforeJsonMap.get("funArea"));
				resultMap.put("newVal",  afterJsonMap.get("funArea"));
				break;
			case "15":// 片区修改
				resultMap.put("oldVal", beforeJsonMap.get("funRegion"));
				resultMap.put("newVal", afterJsonMap.get("funRegion"));
				break;
			case "16":// 门店修改
				resultMap.put("oldVal",  beforeJsonMap.get("funDepts"));
				resultMap.put("newVal",  afterJsonMap.get("funDepts"));
				break;
			case "19":// 系统参数
				resultMap.put("oldVal", beforeJsonMap.get("sysparaList"));
				resultMap.put("newVal", afterJsonMap.get("sysparaList"));
				break;
			case "43":
				resultMap.put("oldVal", beforeJsonMap.get("kpiconfig"));
				resultMap.put("newVal", afterJsonMap.get("kpiconfig"));
			default:
				break;
		}
		return ErpResponseJson.ok(resultMap);
	}


	/**
	 * title ：获得审核任务列表
	 * athor：lcb
	 * date  : 2017/10/16
	 */
	@RequestMapping("/getMgrNewExaminTask")
	public ErpResponseJson getMgrNewExaminTask(@Valid @RequestBody BaseMapParam param) throws Exception {
//		Condition condition = new Condition();
//		condition.add(new ConditionItem("TYPE_FLAG", "=", taskFlag));// Constants_DIC.DIC_TASK_TYPE_FLAG_1));
//		condition.add(new ConditionItem("COMP_ID", "=", getOperator().getCompId()));
//		// 时间段
//		String startDate = getString("CREATION_TIME1");
//		String endDate = getString("CREATION_TIME2");
//		if (!CommonUtil.isnull(startDate)) {
//			if (CommonUtil.isnull(endDate)) {
//				endDate = startDate;
//			}
//			Myfun7Helper.builderTimeAreaCondition(condition, startDate,endDate, "CREATION_TIME");
//		}
//		String deptId = getString("DEPT_ID");
//		String caseType = getString("C_CASE_TYPE");
//
//		// 已审和未审
//		String taskStatus = getString("SH_TASK_STATUS");
//		if (Constants_DIC.DIC_TASK_STATUS_NEW.equals(taskStatus)) {
//			condition.add(new ConditionItem("TASK_STATUS", "=",Constants_DIC.DIC_TASK_STATUS_NEW));
//		} else if (Constants_DIC.DIC_TASK_STATUS_COMPLETE.equals(taskStatus)) {
//			condition.add(new ConditionItem("TASK_STATUS", "=",Constants_DIC.DIC_TASK_STATUS_COMPLETE));
//		}
//		String caseNo = getString("C_HOUSENO");
//		if (!CommonUtil.isnull(caseNo)) {
//			condition.add(new ConditionItem("CASE_NO", "LIKE", "%" + caseNo + "%"));
//		}
//		this.packTaskCondition(deptId, caseType, condition);
//
//		List<FunTaskPO> taskList = service.getTaskList(null, condition);
//		List<FunTaskVO> resultList = new ArrayList<FunTaskVO>();
//		Map<String, FunDeptsPO> deptMap = funDeptsService.getCacheableDeptMapByCompId(getOperator().getCompId());
//		Map<String, FunUsersPO> userMap = funUsersService.getCacheableBaseInfoByCompId(getOperator().getCompId());
//		for (FunTaskPO po : taskList) {
//			FunTaskVO vo = new FunTaskVO();
//			resultList.add(vo);
//			vo.setFunTaskPO(po);
//			// 部门名
//			FunDeptsPO funDept = deptMap.get(po.getDEPT_ID());
//			if (!CommonUtil.isnull(funDept)) {
//				vo.setDEPT_NAME(funDept.getDEPT_NAME());
//			}
//			// 申请人,创建人
//			FunUsersPO funUser = userMap.get(po.getCREATOR_UID());
//			if (!CommonUtil.isnull(funUser)) {
//				vo.setSEND_USER(funUser.getUSER_NAME());
//			}
//		}
		return ErpResponseJson.ok();
	}
//
//	/**
//	 * 获得审核任务列表
//	 * @author 熊刚
//	 * @since 2017年9月25日
//	 * @param param
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("/getNewExaminTask")
//	public ErpResponseJson getNewExaminTask(@Valid @RequestBody BaseMapParam param) throws Exception {
//		param.setInteger("compId", getOperator().getCompId());
//		List<ErpFunTrack> erpFunTrackList = erpFunTrackService.getNewExaminTask(getOperator().getCityId(),param);
//		return ErpResponseJson.ok();
//	}


	/**
	 * 发布广告房源
	 *
	 * @author 熊刚
	 * @since 2017年6月16日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "发布广告房源",httpMethod = "POST")
	@ApiResponses({@ApiResponse(code = 200,response = ErpResponseJson.class, message = "success")})
	@ResponseBody
	@RequestMapping("/addCaseAds")
	public ResponseJson addFunAds(@Valid @RequestBody FunAdsParam param) throws Exception {
		Operator ope = getOperator();
		param.setCompId(ope.getCompId());
		param.setDeptId(ope.getDeptId());
		param.setDeptName(ope.getDeptName());
		param.setUserName(ope.getUserName());
		param.setUserId(ope.getUserId());
		erpFunAdsContentService.creatFunAds(ope.getCityId(), param);
		return ErpResponseJson.ok();
	}

	/**
	 * 取消广告房源
	 *
	 * @author 熊刚
	 * @since 2017年6月16日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "取消广告房源",httpMethod = "POST")
	@ApiResponses({@ApiResponse(code = 200,response = ErpResponseJson.class, message = "success")})
	@ResponseBody
	@RequestMapping("/cancleAdsCase")
	public ResponseJson cancelFunAds(@Valid @RequestBody FunAdsParam param) throws Exception {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer deptId = operator.getDeptId();
		Integer userId = operator.getUserId();
		Integer compId = operator.getCompId();

		param.setUserId(userId);
		param.setDeptId(deptId);
		param.setCompId(compId);

		if (param.getAdsContentIds() != null) {
			//单选或者多选
			erpFunAdsContentService.cancelListFunAds(getOperator().getCityId(), param);
		}else{
			//全部撤销
			erpFunAdsContentService.cancelAllFunAds(getOperator().getCityId(), param);
		}
		return ErpResponseJson.ok();
	}

	/**
	 * 广告房源列表
	 * 李成兵
	 * **/
	@RequestMapping("/getAdsCaseList")
	public ErpResponseJson getFunAdsList(@Valid @RequestBody BaseMapParam param) {
		//如果是美联的需求会走这一段逻辑
		if(getOperator().isMeiLianApi()){
			String record = (String)cacheUtil.get("/erpWeb/managerCenter/systemMonitor/getAdsCaseList"
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
				erpSystemSettingLogs.setLogContent("查看了广告房源");
				erpSystemSettingLogsMapper.insertSelective(erpSystemSettingLogs);
				cacheUtil.put("/erpWeb/managerCenter/systemMonitor/getAdsCaseList"
						+ getOperator().getArchiveId()+DateTimeHelper.formatDateTimetoString(new Date(),"yyy-MM-dd"),"1",86400);
			}
		}
		Operator operator = getOperator();
		Integer caseType = param.getInteger("caseType");// 类别
		Map<String, Object> pMap = param.getMap();
		pMap.put("compId", operator.getCompId());
		pMap.put("date1", pMap.get("date1") + " 00:00:00");
		pMap.put("date2", pMap.get("date2") + " 23:59:59");
		pMap.put("newOrganization", getOperator().newOrganizationType() ? "1" : "0");

		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<ErpFunAdsContentDto> resList = erpFunAdsContentMapper.getAdsList(pMap, operator.getCityId());

		for (ErpFunAdsContentDto funAdsContentVO : resList) {
			String erpWebRootUrl = AppConfig.getErpWebUrl() +"/house/houseCheckQrCode";
			// 判断有没有核验编号
			if(StringUtils.isNotBlank(funAdsContentVO.getCheckCodeFun())) {
				Map<String, Object> paramMap = new HashMap<>();
				paramMap.put("compNo", getOperator().getCompNo());
				paramMap.put("caseType", caseType);
				paramMap.put("caseId", funAdsContentVO.getCaseId());
				paramMap.put("cityId", getOperator().getCityId());
				String s = JSON.toJSONString(paramMap);
				String encode = null;
				try {
					encode = AESHelper.encode(s);
				} catch (Exception e) {
					e.printStackTrace();
				}
				erpWebRootUrl+="?param="+encode;
				funAdsContentVO.setCheckCodeUrl(erpWebRootUrl);
			}
		}
		PageInfo<ErpFunAdsContentDto> pageInfo = new PageInfo<>(resList);
		return ErpResponseJson.ok(pageInfo);
	}

	/**
	 * 导出广告房源
	 * @author 熊刚
	 * @since 2017年6月20日
	 * @param param
	 * @return
	 */
	@RequestMapping("/getAdsCaseListForExport")
	public ErpResponseJson getAdsCaseListForExport(@Valid @RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Map<String, Object> pMap = param.getMap();
		pMap.put("compId", operator.getCompId());
		pMap.put("date1", pMap.get("date1") + " 00:00:00");
		pMap.put("date2", pMap.get("date2") + " 23:59:59");
		List<ErpFunAdsContentDto> resList = erpFunAdsContentMapper.getAdsList(pMap, operator.getCityId());
		return ErpResponseJson.ok(resList);
	}

	/**
	 * @tag 获取有漫游权限的用户列表
	 * @author 邓永洪
	 * @since 2018/6/7
	 */
	@RequestMapping("/getAuthRoamUserList")
	public ErpResponseJson getAuthRoamUserList(@Valid @RequestBody BaseMapParam param) {
		Operator operator=getOperator();
		List<ErpFunUsers> usersList=erpFunUsersMapper.getAuthRoamUserList(operator.getCityId(),operator.getCompId());
		return ErpResponseJson.ok(usersList);
	}
}


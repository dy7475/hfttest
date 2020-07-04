package com.myfun.erpWeb.openApi.user;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.myfun.erpWeb.openApi.user.param.UpdateOrgUserNumParam;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.service.business.erpdb.ErpFunOrganizationService;
import com.myfun.service.business.erpdb.ErpFunPartnerDeptService;
import com.myfun.service.business.erpdb.bean.vo.MoveOrganizationServiceVO;
import com.myfun.utils.Assert;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myfun.erpWeb.common.CommonController;
import com.myfun.erpWeb.common.param.AddSubOrganizationParam;
import com.myfun.erpWeb.common.param.UpdateChileCompParam;
import com.myfun.erpWeb.common.vo.AddSubOrganizationVO;
import com.myfun.erpWeb.managecenter.sysmanager.param.PartnerDeptsParam;
import com.myfun.erpWeb.openApi.user.param.DealNewOrgUserCountMessage;
import com.myfun.erpWeb.openApi.user.param.OpenHeaderQuqrtersParam;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.session.Operator;
import com.myfun.framework.util.DateTimeHelper;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.json.DefaultResponseJson;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.param.DeleteUsersParam;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.erpdb.ErpFunPartnerService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.service.business.erpdb.ErpSysParaService;
import com.myfun.service.business.erpdb.ErpUserOpersService;
import com.myfun.service.business.report.ReportFunSaleMinService;
import com.myfun.service.business.taskJob.HttpRequestTask;
import com.myfun.service.jms.activeMQ.ActiveMqPublisher;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.StringUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 用户管理相关的开放接口
 * @author 张宏利
 * @since 2018年6月11日
 */

@RequestMapping("/openApi/user")
@Api(tags = "支付宝房源预约控制器", value = "alipayHouseBiz")
@Controller
public class UserManageOpController {
	Logger logger = LoggerFactory.getLogger(UserManageOpController.class);

	@Autowired private ErpFunUsersService erpFunUsersService;
	@Autowired private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired private ErpFunCompMapper erpFunCompMapper;
	@Autowired private ErpFunPartnerConfigMapper erpFunPartnerConfigMapper;
	@Autowired private ErpUserOpersService erpUserOpersService;
	@Autowired private ReportFunSaleMinService reportFunSaleMinService;
	@Autowired private ErpFunPartnerService erpFunPartnerService;
	@Autowired private ErpFunPartnerDeptService erpFunPartnerDeptService;
	@Autowired private ErpFunSaleMapper erpFunSaleMapper;
	@Autowired private ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired private ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
	@Autowired private ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	@Autowired private ErpSysParaMapper erpSysParaMapper;
	@Autowired private ErpSysParaService erpSysParaService;
	@Autowired private ActiveMqPublisher publisher;
	@Autowired private ErpFunOrganizationService erpFunOrganizationService;
	@Autowired private ErpFunOrganizationMapper erpFunOrganizationMapper;
	@Autowired
	private HttpRequestTask httpRequestTask;
	@Autowired
	ActiveMqPublisher mqPublisher;
	@Autowired
    private CommonController commonController;
	@Autowired
    ActiveMqPublisher activeMqPublisher;
	@Autowired
	ErpFunEntrustMapper erpFunEntrustMapper;
	@Autowired
	ErpFunEntrustRecordNoMapper erpFunEntrustRecordNoMapper;

	@PostMapping("/updateUserOpers")
	@ResponseBody
	public ResponseJson updateUserOpers(Integer cityId,Integer compId,	 String  roleIdsStr,
			String  deleteOpersStr ,
			 String  repeatUpdateOperIdsStr, String  ptOperAddStr) {
		List<String> roleIds = new ArrayList<String>();
		Set<String>  deleteOpers = new HashSet<String>();
		Set<String>  repeatUpdateOperIds = new HashSet<String>();
		Set<String>  ptOperAdd = new HashSet<String>();
		if(StringUtil.isNotEmpty(roleIdsStr)){
			if(roleIdsStr.indexOf(",")> -1){
				String[] roleIdsStrs = roleIdsStr.split(",");
				for (String roleId : roleIdsStrs) {
					roleIds.add(roleId.trim());
				}
			}else{
				roleIds.add(roleIdsStr.trim());
			}
		}
		if(StringUtil.isNotEmpty(deleteOpersStr)){
			if(deleteOpersStr.indexOf(",")> -1){
				String[] deleteOpersStrs = deleteOpersStr.split(",");
				for (String deleteOper : deleteOpersStrs) {
					deleteOpers.add(deleteOper.trim());
				}
			}else{
				deleteOpers.add(deleteOpersStr.trim());
			}
		}

		if(StringUtil.isNotEmpty(repeatUpdateOperIdsStr)){
			if(repeatUpdateOperIdsStr.indexOf(",")> -1){
				String[] repeatUpdateOperIdsStrs = repeatUpdateOperIdsStr.split(",");
				for (String repeatUpdateOperId : repeatUpdateOperIdsStrs) {
					repeatUpdateOperIds.add(repeatUpdateOperId.trim());
				}
			}else{
				repeatUpdateOperIds.add(repeatUpdateOperIdsStr.trim());
			}
		}

		if(StringUtil.isNotEmpty(ptOperAddStr)){
			if(ptOperAddStr.indexOf(",")> -1){
				String[] ptOperAddStrs = ptOperAddStr.split(",");
				for (String ptOper : ptOperAddStrs) {
					ptOperAdd.add(ptOper.trim());
				}
			}else{
				ptOperAdd.add(ptOperAddStr.trim());
			}
		}
		erpUserOpersService.updateUserOpers(cityId, compId, roleIds, deleteOpers, repeatUpdateOperIds, ptOperAdd);
		return ErpResponseJson.ok();
	}

	/**
	 * 注销用户账号，给crm调用
	 */
	@PostMapping("/deleteUser")
	@ResponseBody
	public ResponseJson deleteUser(DeleteUsersParam param) {
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		Integer userId = param.getUserId();
		// 默认为总经理账号去注销
		ErpFunUsers generalManager = erpFunUsersService.getGeneralManagerByCompId(cityId, compId);
		//ErpFunUsers generalManager = erpFunUsersMapper.getGeneralManagerByCompId(cityId, compId);
		if(generalManager == null) {
			return ErpResponseJson.warn("当前公司没有总经理，注销员工失败");
		}

		ErpFunOrganization organization = erpFunOrganizationMapper.selectOrgByOrganizationId(param.getCityId(), generalManager.getOrganizationId());
		param.setOrganizationId(organization.getOrganizationId());
		param.setOrganizationPath(organization.getOrganizationPath());
		param.setOrganizationName(organization.getOrganizationName());

		ErpFunComp erpFunComp = erpFunCompMapper.selectByCompId(cityId, compId);

		param.setIsCrmDelete(1);
		param.setSelfUser(generalManager);
		param.setCompType(erpFunComp.getCompType().intValue());
		// 判断是否可以注销
		ErpFunUsers funUsersSel = erpFunUsersMapper.selectDataByUserId(cityId, compId,userId);
		if(null != funUsersSel && "GENERAL_MANAGER".equals(funUsersSel.getUserPosition())){
			return ErpResponseJson.warn("该账号为总经理账号，无法脱离门店");
		}
		// 总经理需要判断是否还有员工，有员工则不能注销
		if (Const.DIC_ROLE_NAME_GENERAL_MANAGER.equals(funUsersSel.getUserPosition())) {
			Integer userCount = erpFunUsersMapper.getUserCountByRangeId(cityId, compId, null, null, null, null);
			// 说明除了自己以外还有人
			if (userCount != null && userCount > 1) {
				return ErpResponseJson.warn("当前公司还有员工，不能注销总经理");
			}
		}
		// 注销用户
		Assert.isNullThrow(param.getCityId(), "城市参数为空");
		Assert.isNullThrow(param.getCompId(), "公司参数为空");
		erpFunUsersService.writeOffUser(param, funUsersSel, null);  //CRM用的，createName写的空
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
		//下架离职员工发发房源
		publisher.removeListing(cityId,funUsersSel.getArchiveId(),userId);
		//修改新盘驻场人员
		erpFunOrganizationService.updateFieldStaff(cityId,userId,funUsersSel.getOrganizationId(),funUsersSel.getCompId());
		return ErpResponseJson.ok();
	}

	/**
	 * 刷新会话中指定的参数
	 * @param archiveId
	 * @param cityId
	 * @param compNo
	 * @param deptNo
	 * @param refreshType
	 * @return
	 */
	@GetMapping("/refreshUserOperator")
	@ResponseBody
	public ResponseJson refreshUserOperator(Integer archiveId, Integer cityId, String compNo, String deptNo, Integer refreshType){
		if(null == archiveId || null == cityId || null == refreshType){
			return ErpResponseJson.ok();
		}
		erpFunUsersService.refreshUserOperator(archiveId, cityId, compNo, deptNo, refreshType);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 刷新会话中指定的参数
	 * @param archiveId
	 * @param cityId
	 * @param compNo
	 * @param deptNo
	 * @param refreshType
	 * @return
	 */
	@GetMapping("/canOpenHeadquarters")
	@ApiOperation(value = "能否操作开启或者关闭总部 errCode 200操作成功，-1不能操作，这个时候取errMsg提示出来")
	@ApiImplicitParam(dataTypeClass = OpenHeaderQuqrtersParam.class)
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value={
		@ApiResponse(code = 0, message = "", response = ErpResponseJson.class)
	})
	@ResponseBody
	public ResponseJson canOpenHeadquarters(@Valid OpenHeaderQuqrtersParam param){
		reportFunSaleMinService.judgeOperatorTransferShop(param.getCompNo(), param.getCityId(), param.getCompId(), null, 5, null, Integer.valueOf(0).equals(param.getOperatorType())?-1:0);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 刷新会话中指定的参数
	 * @param archiveId
	 * @param cityId
	 * @param compNo
	 * @param deptNo
	 * @param refreshType
	 * @return
	 */
	@PostMapping("/operaterOpenHeadquarters")
	@ApiOperation(value = "开启总部 errCode 200操作成功，-1不能操作，这个时候取errMsg提示出来")
	@ApiImplicitParam(dataTypeClass = OpenHeaderQuqrtersParam.class)
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value={
			@ApiResponse(code = 0, message = "", response = ErpResponseJson.class)
	})
	@ResponseBody
	public ResponseJson operaterOpenHeadquarters(@Valid OpenHeaderQuqrtersParam param){
		reportFunSaleMinService.judgeOperatorTransferShop(param.getCompNo(), param.getCityId(), param.getCompId(), null, 5, null, Integer.valueOf(0).equals(param.getOperatorType())?-1:0);
		   //加盟商相关修改
		PartnerDeptsParam param1 = new PartnerDeptsParam();
		param1.setCityId(param.getCityId());
		param1.setCompId(param.getCompId());
		param1.setCompNo(param.getCompNo());
		param1.setPartnerId(param.getOperatorType());
		param1.setDeptId(param.getDeptId());
		param1.setSelfUserId(0);
		param1.setPartnerType(Integer.valueOf(param.getOperatorType()).equals(0)?Byte.valueOf("2"):Byte.valueOf("0"));
		erpFunPartnerDeptService.updatePartnerInfo(param1);
		return ErpResponseJson.ok();
	}

	/**
	 * 刷新会话中指定的参数
	 * @param archiveId
	 * @param cityId
	 * @param compNo
	 * @param deptNo
	 * @param refreshType
	 * @return
	 */
	@GetMapping("/openPartner")
	@ApiOperation(value = "开启加盟模式 errCode 200操作成功")
	@ApiImplicitParam(dataTypeClass = OpenHeaderQuqrtersParam.class)
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value={
		@ApiResponse(code = 0, message = "", response = ErpResponseJson.class)
	})
	@ResponseBody
	public ResponseJson openPartner(Integer cityId,Integer compId){
		ErpFunUsers users = erpFunUsersService.getGeneralManagerByCompId(cityId, compId);
		ErpUserOpers userOpers = new ErpUserOpers();
		userOpers.setShardCityId(cityId);
		userOpers.setOperId("PARTNER_MANAGE_OPER");
		userOpers.setUserId(users.getUserId());
		erpUserOpersService.insertSelective(userOpers);
		erpFunUsersService.endLoginCompUser(cityId, compId, Const.LogInEnum.VERSION_CHANGE);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 策略参数测试框架
	 * 1.首先根据api需要传入房源编号，或者，客源编号，获取房源的partnerId,公司id,查询公司是否是加盟模式，如果是加盟模式的情况下，我需要判断参数是否独立配置，
	 * 独立查独立的配置嘛
	 */
	
	/**
	 * 刷新会话中指定的参数
	 * @param archiveId
	 * @param cityId
	 * @param compNo
	 * @param deptNo
	 * @param refreshType
	 * @return
	 * @throws IOException 
	 */
	@GetMapping("/getCaseExcutestrategy")
	@ApiOperation(value = "获取这条信息的执行情况")
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value={
		@ApiResponse(code = 0, message = "", response = ErpResponseJson.class)
	})
	public void getCaseExcutestrategy(HttpServletResponse response,Integer caseType,Integer caseId,String caseNo) throws IOException{
		Date dateNow = new Date();
		StringBuilder strategyInfo = new StringBuilder("该信息");
		List<Integer> partnerIds = new ArrayList<>();
		partnerIds.add(0);
		if (caseType!=null && caseId!=null) {
			List<String> sysParaList = new ArrayList<>();
			if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
				strategyInfo.append("为出售房源");
				ErpFunSale id = new ErpFunSale();
				if (caseId!=null) {
					id.setShardCityId(1);
					id.setSaleId(caseId);
					id = erpFunSaleMapper.selectByPrimaryKey(id);
				} else {
					id = erpFunSaleMapper.selectSaleInfoByCaseNo(1,caseNo);
				}
				ErpFunComp compInfo = erpFunCompMapper.selectByCompId(1, id.getCompId());
				if (Byte.valueOf("1").equals(compInfo.getOpenPartner())) {
					strategyInfo.append("公司编号为").append(compInfo.getCompNo()).append("开启了加盟模式");
				}
				strategyInfo.append("该信息属于");
				if (id.getPartnerId()<1){
					strategyInfo.append("组织：").append(Integer.valueOf("-1").equals(id.getPartnerId())?"直营":"总部");
				} else {
					ErpFunPartner partnerid = new ErpFunPartner();
					partnerid.setShardCityId(compInfo.getCityId().intValue());
					partnerid.setId(id.getPartnerId());
					partnerid = erpFunPartnerService.selectByPrimaryKey(partnerid);
					strategyInfo.append("组织：").append(partnerid.getPartnerName()).append("加盟商id:").append(partnerid.getId());
				}
				partnerIds.add(id.getPartnerId());
				//id.getIsIgnore()
				sysParaList.add("FANGKAN_RED_SELL");//红色警告时间
				/**
				 *    A.SALE_EXPLRTH = 0 AND 未房堪
				      A.RED_FLAG     = 0 AND 无红色标记
				      A.SALE_STATUS  = 1 AND 有效房源
				      A.PUBLIC_COUNT = 0 AND 未跳过抢
					  A.IS_IGNORE	 = 0 
				 */
				sysParaList.add("RED_FANGKAN_PUBLIC_SELL");//跳抢时间
				sysParaList.add("TRACK_RED_SELL");//跟进时间间隔的黄色警告时间
				sysParaList.add("RED_TRACK_PUBLIC_SELL");//橙色警告之后跳抢时间
				sysParaList.add("GET_PUBLIC_RED_SELL");//获取抢盘之后多少时间不跟进变橙色警告
				sysParaList.add("GET_RED_TRACK_PUBLIC_SELL");//获取抢盘之后多少时间不跟进跳抢盘
				sysParaList.add("PUBLIC_CANCEL_SELL");//信息多少跳抢多少次之后变为公盘
				sysParaList.add("PUBLIC_NOTGET_CANCEL_SELL");//抢盘信息多少天没有人抢变为公盘
				ErpSysParaExample example = new ErpSysParaExample();
				example.setShardCityId(id.getCityId());
				example.createCriteria().andCompIdEqualTo(id.getCompId()).andParamIdIn(sysParaList).andPartnerIdIn(partnerIds);
				example.setOrderByClause("PARTNER_ID");
				List<ErpSysPara> paraList = erpSysParaMapper.selectByExample(example);
				Map<String,String> map = new HashMap<>();
				for (ErpSysPara sysPara:paraList) {
					map.put(sysPara.getParamId(), sysPara.getParamValue());
				}
				judgeHouseCanRegWarnOneCondition(dateNow, id.getActionTime(), StringUtil.parseInteger(map.get("FANGKAN_RED_SELL"), 0), 0, id.getSaleExplrth()==null?false:id.getSaleExplrth(), id.getRedFlag()==null?Byte.valueOf("0"):id.getRedFlag()?Byte.valueOf("1"):Byte.valueOf("0"), id.getSaleStatus(), id.getPublicCount(), id.getIsIgnore(), strategyInfo);
				judgeHouseCanRegCondition(dateNow, id.getActionTime(), StringUtil.parseInteger(map.get("RED_FANGKAN_PUBLIC_SELL"), 0), id.getSaleExplrth()==null?false:id.getSaleExplrth(), id.getPlateType(), id.getSaleStatus(), id.getPublicCount(),  id.getIsIgnore(), strategyInfo);
				if (id.getPrivateTime()!=null) {
					judgeHouseHasPublicCanRegWarnTwoCondition(dateNow, id.getPrivateTime(), StringUtil.parseInteger(map.get("FANGKAN_RED_SELL"), 0), id.getSaleExplrth()==null?false:id.getSaleExplrth(), id.getRedFlag()==null?Byte.valueOf("0"):id.getRedFlag()?Byte.valueOf("1"):Byte.valueOf("0"), id.getPlateType(), id.getSaleStatus(), id.getPublicCount(),id.getIsIgnore(), strategyInfo);
					judgeHouseHasPublicCanRegFlagTwoCondition(dateNow, id.getPrivateTime(), StringUtil.parseInteger(map.get("RED_FANGKAN_PUBLIC_SELL"), 0), id.getSaleExplrth()==null?false:id.getSaleExplrth(), id.getPlateType(), id.getSaleStatus(), id.getPublicCount(),  id.getIsIgnore(), strategyInfo);
				}
				judgeHouseCanOrangeFlagOneCondition(dateNow, id.getTrackTime(),StringUtil.parseInteger(map.get("TRACK_RED_SELL"), 0), id.getPlateType(), id.getOrangeFlag()==null?false:id.getOrangeFlag(), id.getSaleStatus(), id.getFromPublic()==null?Integer.valueOf("0"):id.getFromPublic()?Integer.valueOf("1"):Integer.valueOf("0"), id.getIsIgnore(), strategyInfo);
				judgeHouseCanPublicOrangeOneCondition(dateNow, id.getTrackTime(),StringUtil.parseInteger(map.get("RED_TRACK_PUBLIC_SELL"), 0), id.getPlateType(), id.getSaleStatus(), id.getFromPublic()==null?Integer.valueOf("0"):id.getFromPublic()?Integer.valueOf("1"):Integer.valueOf("0"), id.getIsIgnore(), strategyInfo);
				judgeHouseHasPublicCanOrangeFlagOneCondition(dateNow, id.getTrackTime(), StringUtil.parseInteger(map.get("GET_PUBLIC_RED_SELL"), 0), id.getPlateType(), id.getOrangeFlag()==null?false:id.getOrangeFlag(), id.getSaleStatus(), id.getFromPublic()==null?Integer.valueOf("0"):id.getFromPublic()?Integer.valueOf("1"):Integer.valueOf("0"),id.getIsIgnore(), strategyInfo);
				judgeHouseHasPublicCanOrangeTwoCondition(dateNow, id.getTrackTime(), StringUtil.parseInteger(map.get("GET_RED_TRACK_PUBLIC_SELL"), 0), id.getPlateType(), id.getSaleStatus(), id.getFromPublic()==null?Integer.valueOf("0"):id.getFromPublic()?Integer.valueOf("1"):Integer.valueOf("0"), id.getIsIgnore(), strategyInfo);
				judgeHouseCanShareOneCondition(StringUtil.parseInteger(map.get("PUBLIC_CANCEL_SELL"), 0), id.getPlateType(), id.getSaleStatus(), id.getPublicCount(), id.getIsIgnore(), strategyInfo);
			} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
				ErpFunLease id = new ErpFunLease();
				if (caseId!=null) {
					id.setShardCityId(1);
					id.setLeaseId(caseId);
					id = erpFunLeaseMapper.selectByPrimaryKey(id);
				} else {
					id = erpFunLeaseMapper.selectLeaseByCaseNo(1, caseNo);
				}
				ErpFunComp compInfo = erpFunCompMapper.selectByCompId(1, id.getCompId());
				if (Byte.valueOf("1").equals(compInfo.getOpenPartner())) {
					strategyInfo.append("公司编号为").append(compInfo.getCompNo()).append("开启了加盟模式");
				}
				strategyInfo.append("该信息属于");
				if (id.getPartnerId()<1){
					strategyInfo.append("组织：").append(Integer.valueOf("-1").equals(id.getPartnerId())?"直营":"总部");
				} else {
					ErpFunPartner partnerid = new ErpFunPartner();
					partnerid.setShardCityId(compInfo.getCityId().intValue());
					partnerid.setId(id.getPartnerId());
					partnerid = erpFunPartnerService.selectByPrimaryKey(partnerid);
					strategyInfo.append("组织：").append(partnerid.getPartnerName()).append("加盟商id:").append(partnerid.getId());
				}
				partnerIds.add(id.getPartnerId());
				sysParaList.add("FANGKAN_RED_LEASE");//房堪红色警告时间
				sysParaList.add("RED_FANGKAN_PUBLIC_LEASE");//房堪跳抢时间
				sysParaList.add("TRACK_RED_LEASE");//跟进时间间隔的黄色警告时间
				sysParaList.add("RED_TRACK_PUBLIC_LEASE");//橙色警告之后跳抢时间
				sysParaList.add("GET_PUBLIC_RED_LEASE");//获取抢盘之后多少时间不跟进变橙色警告
				sysParaList.add("GET_RED_TRACK_PUBLIC_LEASE");//获取抢盘之后多少时间不跟进跳抢盘
				sysParaList.add("PUBLIC_CANCEL_LEASE");//信息多少跳抢多少次之后变为公盘
				ErpSysParaExample example = new ErpSysParaExample();
				example.setShardCityId(id.getCityId());
				example.createCriteria().andCompIdEqualTo(id.getCompId()).andParamIdIn(sysParaList).andPartnerIdIn(partnerIds);
				example.setOrderByClause("PARTNER_ID");
				List<ErpSysPara> paraList = erpSysParaMapper.selectByExample(example);
				Map<String,String> map = new HashMap<>();
				for (ErpSysPara sysPara:paraList) {
					map.put(sysPara.getParamId(), sysPara.getParamValue());
				}
				strategyInfo.append("为出租房源");
				judgeHouseCanRegWarnOneCondition(dateNow, id.getActionTime(), StringUtil.parseInteger(map.get("FANGKAN_RED_LEASE"), 0), 0, id.getLeaseExplrth()==null?false:id.getLeaseExplrth(), id.getRedFlag()==null?Byte.valueOf("0"):id.getRedFlag()?Byte.valueOf("1"):Byte.valueOf("0"), id.getLeaseStatus().byteValue(), id.getPublicCount(), id.getIsIgnore(), strategyInfo);
				judgeHouseCanRegCondition(dateNow, id.getActionTime(), StringUtil.parseInteger(map.get("RED_FANGKAN_PUBLIC_LEASE"), 0), id.getLeaseExplrth()==null?false:id.getLeaseExplrth(), id.getPlateType(), id.getLeaseStatus().byteValue(), id.getPublicCount(),  id.getIsIgnore(), strategyInfo);
				if (id.getPrivateTime()!=null) {
					judgeHouseHasPublicCanRegWarnTwoCondition(dateNow, id.getPrivateTime(), StringUtil.parseInteger(map.get("FANGKAN_RED_LEASE"), 0), id.getLeaseExplrth()==null?false:id.getLeaseExplrth(), id.getRedFlag()==null?Byte.valueOf("0"):id.getRedFlag()?Byte.valueOf("1"):Byte.valueOf("0"), id.getPlateType(), id.getLeaseStatus().byteValue(), id.getPublicCount(),id.getIsIgnore(), strategyInfo);
					judgeHouseHasPublicCanRegFlagTwoCondition(dateNow, id.getPrivateTime(), StringUtil.parseInteger(map.get("RED_FANGKAN_PUBLIC_LEASE"), 0), id.getLeaseExplrth()==null?false:id.getLeaseExplrth(), id.getPlateType(), id.getLeaseStatus().byteValue(), id.getPublicCount(),  id.getIsIgnore(), strategyInfo);
				}
				judgeHouseCanOrangeFlagOneCondition(dateNow, id.getTrackTime(),StringUtil.parseInteger(map.get("TRACK_RED_LEASE"), 0), id.getPlateType(), id.getOrangeFlag()==null?false:id.getOrangeFlag(), id.getLeaseStatus().byteValue(), id.getFromPublic()==null?Integer.valueOf("0"):id.getFromPublic()?Integer.valueOf("1"):Integer.valueOf("0"), id.getIsIgnore(), strategyInfo);
				judgeHouseCanPublicOrangeOneCondition(dateNow, id.getTrackTime(),StringUtil.parseInteger(map.get("RED_TRACK_PUBLIC_LEASE"), 0), id.getPlateType(), id.getLeaseStatus().byteValue(), id.getFromPublic()==null?Integer.valueOf("0"):id.getFromPublic()?Integer.valueOf("1"):Integer.valueOf("0"), id.getIsIgnore(), strategyInfo);
				judgeHouseHasPublicCanOrangeFlagOneCondition(dateNow, id.getTrackTime(), StringUtil.parseInteger(map.get("GET_PUBLIC_RED_LEASE"), 0), id.getPlateType(), id.getOrangeFlag()==null?false:id.getOrangeFlag(), id.getLeaseStatus().byteValue(), id.getFromPublic()==null?Integer.valueOf("0"):id.getFromPublic()?Integer.valueOf("1"):Integer.valueOf("0"),id.getIsIgnore(), strategyInfo);
				judgeHouseHasPublicCanOrangeTwoCondition(dateNow, id.getTrackTime(), StringUtil.parseInteger(map.get("GET_RED_TRACK_PUBLIC_LEASE"), 0), id.getPlateType(), id.getLeaseStatus().byteValue(), id.getFromPublic()==null?Integer.valueOf("0"):id.getFromPublic()?Integer.valueOf("1"):Integer.valueOf("0"), id.getIsIgnore(), strategyInfo);
				judgeHouseCanShareOneCondition(StringUtil.parseInteger(map.get("PUBLIC_CANCEL_LEASE"), 0), id.getPlateType(), id.getLeaseStatus().byteValue(), id.getPublicCount(), id.getIsIgnore(), strategyInfo);

			} else if (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
				ErpFunBuyCustomer id = new ErpFunBuyCustomer();
				if (caseId!=null) {
					id.setShardCityId(1);
					id.setBuyCustId(caseId);
					id = erpFunBuyCustomerMapper.selectByPrimaryKey(id);
				} else {
					ErpFunBuyCustomerExample example = new ErpFunBuyCustomerExample();
					example.setShardCityId(1);
					example.createCriteria().andBuyCustNoEqualTo(caseNo);
					List <ErpFunBuyCustomer> idList = erpFunBuyCustomerMapper.selectByExample(example);
					id = idList.get(0);
				}
				sysParaList.add("FANGKAN_RED_BUY");//未带看红色警告时间
				sysParaList.add("RED_FANGKAN_PUBLIC_BUY");//未带看跳抢时间
				sysParaList.add("TRACK_RED_BUY");//跟进时间间隔的黄色警告时间
				sysParaList.add("RED_TRACK_PUBLIC_BUY");//橙色警告之后跳抢时间
				sysParaList.add("GET_PUBLIC_RED_BUY");//获取抢盘之后多少时间不跟进变橙色警告
				sysParaList.add("GET_RED_TRACK_PUBLIC_BUY");//获取抢盘之后多少时间不跟进跳抢盘
				sysParaList.add("PUBLIC_CANCEL_BUY");//信息多少跳抢多少次之后变为公盘
				strategyInfo.append("为求购客源");
				ErpSysParaExample example = new ErpSysParaExample();
				example.setShardCityId(id.getCityId());
				example.createCriteria().andCompIdEqualTo(id.getCompId()).andParamIdIn(sysParaList).andPartnerIdIn(partnerIds);
				example.setOrderByClause("PARTNER_ID");
				List<ErpSysPara> paraList = erpSysParaMapper.selectByExample(example);
				Map<String,String> map = new HashMap<>();
				for (ErpSysPara sysPara:paraList) {
					map.put(sysPara.getParamId(), sysPara.getParamValue());
				}
				Byte orangeFlag = Optional.ofNullable(id.getOrangeFlag()).orElse(false)?Byte.valueOf("1"):Byte.valueOf("0");
				Byte redFlag = Optional.ofNullable(id.getRedFlag()).orElse(false)?Byte.valueOf("1"):Byte.valueOf("0");
				Integer fromPublic = Optional.ofNullable(id.getFromPublic()).orElse(false)?Integer.valueOf("1"):Integer.valueOf("0");
				judgeCustCanRegWarnOneCondition(dateNow, DateTimeHelper.parseToDate(id.getActionTime()), StringUtil.parseInteger(map.get("FANGKAN_RED_BUY"), 0), Optional.ofNullable(id.getHouseLook()).orElse(false),  id.getRedFlag()==null?Byte.valueOf("0"):id.getRedFlag()?Byte.valueOf("1"):Byte.valueOf("0"), id.getBuyCustStatus(), id.getPublicCount(), id.getIsIgnore(), strategyInfo);
				judgeCustCanRegCondition(dateNow, DateTimeHelper.parseToDate(id.getActionTime()), StringUtil.parseInteger(map.get("RED_FANGKAN_PUBLIC_BUY"), 0), Optional.ofNullable(id.getHouseLook()).orElse(false),  id.getRedFlag()==null?Byte.valueOf("0"):id.getRedFlag()?Byte.valueOf("1"):Byte.valueOf("0"), id.getBuyCustStatus(), id.getPublicCount(), id.getIsIgnore(), strategyInfo);
				if (id.getPrivateTime()!=null) {
					judgeCustHasPublicCanRegFlagTwoCondition(dateNow, DateTimeHelper.parseToDate(id.getPrivateTime()), StringUtil.parseInteger(map.get("TRACK_RED_BUY"), 0), Optional.ofNullable(id.getHouseLook()).orElse(false),  id.getPlateType(), id.getBuyCustStatus(), redFlag, id.getPublicCount(), id.getIsIgnore(), strategyInfo);
					judgeCustHasPublicCanRegFlagTwoCondition11(dateNow, DateTimeHelper.parseToDate(id.getPrivateTime()), StringUtil.parseInteger(map.get("RED_TRACK_PUBLIC_BUY"), 0), Optional.ofNullable(id.getHouseLook()).orElse(false), id.getPlateType(), id.getBuyCustStatus(), id.getPublicCount(), id.getIsIgnore(), strategyInfo);
				}
				judgeCustCanOrangeFlagOneCondition(dateNow, DateTimeHelper.parseToDate(id.getTrackTime()),orangeFlag,StringUtil.parseInteger(map.get("GET_PUBLIC_RED_BUY"),0), id.getPlateType(), id.getBuyCustStatus(), fromPublic, id.getIsIgnore(), strategyInfo);
				judgeCustCanPublicOrangeOneCondition(dateNow, DateTimeHelper.parseToDate(id.getTrackTime()), StringUtil.parseInteger(map.get("GET_RED_TRACK_PUBLIC_BUY"), 0), id.getPlateType(), id.getBuyCustStatus(), fromPublic, id.getIsIgnore(), strategyInfo);
				judgeHouseCanShareOneCondition(StringUtil.parseInteger(map.get("PUBLIC_CANCEL_BUY"), 0), id.getPlateType(), id.getBuyCustStatus().byteValue(), id.getPublicCount(), id.getIsIgnore(), strategyInfo);
			} else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
				ErpFunRentCustomerKey idkey = new ErpFunRentCustomerKey();
				idkey.setShardCityId(1);
				idkey.setRentCustId(caseId);
				ErpFunRentCustomer id = null;
				if (caseId!=null) {
					id = erpFunRentCustomerMapper.selectByPrimaryKey(idkey);
				} else {
					ErpFunRentCustomerExample example = new ErpFunRentCustomerExample();
					example.setShardCityId(1);
					example.createCriteria().andRentCustNoEqualTo(caseNo);
					List<ErpFunRentCustomer> rentList = erpFunRentCustomerMapper.selectByExample(example);
					id = rentList.get(0);
				}
				sysParaList.add("FANGKAN_RED_RENT");//未带看红色警告时间
				sysParaList.add("RED_FANGKAN_PUBLIC_RENT");//未带看跳抢时间
				sysParaList.add("TRACK_RED_RENT");//跟进时间间隔的黄色警告时间
				sysParaList.add("RED_TRACK_PUBLIC_RENT");//橙色警告之后跳抢时间
				sysParaList.add("GET_PUBLIC_RED_RENT");//获取抢盘之后多少时间不跟进变橙色警告
				sysParaList.add("GET_RED_TRACK_PUBLIC_RENT");//获取抢盘之后多少时间不跟进跳抢盘
				sysParaList.add("PUBLIC_CANCEL_RENT");//信息多少跳抢多少次之后变为公盘
				strategyInfo.append("为求租客源");
				ErpSysParaExample example = new ErpSysParaExample();
				example.setShardCityId(id.getCityId());
				example.createCriteria().andCompIdEqualTo(id.getCompId()).andParamIdIn(sysParaList).andPartnerIdIn(partnerIds);
				example.setOrderByClause("PARTNER_ID");
				List<ErpSysPara> paraList = erpSysParaMapper.selectByExample(example);
				Map<String,String> map = new HashMap<>();
				for (ErpSysPara sysPara:paraList) {
					map.put(sysPara.getParamId(), sysPara.getParamValue());
				}
				Byte orangeFlag = Optional.ofNullable(id.getOrangeFlag()).orElse(false)?Byte.valueOf("1"):Byte.valueOf("0");
				Byte redFlag = Optional.ofNullable(id.getRedFlag()).orElse(false)?Byte.valueOf("1"):Byte.valueOf("0");
				Integer fromPublic = Optional.ofNullable(id.getFromPublic()).orElse(false)?Integer.valueOf("1"):Integer.valueOf("0");
				judgeCustCanRegWarnOneCondition(dateNow, id.getActionTime(), StringUtil.parseInteger(map.get("FANGKAN_RED_RENT"), 0), Optional.ofNullable(id.getHouseLook()).orElse(false),  id.getRedFlag()==null?Byte.valueOf("0"):id.getRedFlag()?Byte.valueOf("1"):Byte.valueOf("0"), id.getRentCustStatus(), id.getPublicCount(), id.getIsIgnore(), strategyInfo);
				judgeCustCanRegCondition(dateNow, id.getActionTime(), StringUtil.parseInteger(map.get("RED_FANGKAN_PUBLIC_RENT"), 0), Optional.ofNullable(id.getHouseLook()).orElse(false),  id.getRedFlag()==null?Byte.valueOf("0"):id.getRedFlag()?Byte.valueOf("1"):Byte.valueOf("0"), id.getRentCustStatus(), id.getPublicCount(), id.getIsIgnore(), strategyInfo);
				if (id.getPrivateTime()!=null) {
					judgeCustHasPublicCanRegFlagTwoCondition(dateNow, id.getPrivateTime(), StringUtil.parseInteger(map.get("TRACK_RED_RENT"), 0), Optional.ofNullable(id.getHouseLook()).orElse(false),  id.getPlateType(), id.getRentCustStatus(), redFlag, id.getPublicCount(), id.getIsIgnore(), strategyInfo);
					judgeCustHasPublicCanRegFlagTwoCondition11(dateNow, id.getPrivateTime(), StringUtil.parseInteger(map.get("RED_TRACK_PUBLIC_RENT"), 0), Optional.ofNullable(id.getHouseLook()).orElse(false), id.getPlateType(), id.getRentCustStatus(), id.getPublicCount(), id.getIsIgnore(), strategyInfo);
				}
				judgeCustCanOrangeFlagOneCondition(dateNow, id.getTrackTime(),orangeFlag,StringUtil.parseInteger(map.get("GET_PUBLIC_RED_RENT"),0), id.getPlateType(), id.getRentCustStatus(), fromPublic, id.getIsIgnore(), strategyInfo);
				judgeCustCanPublicOrangeOneCondition(dateNow, id.getTrackTime(), StringUtil.parseInteger(map.get("GET_RED_TRACK_PUBLIC_RENT"), 0), id.getPlateType(), id.getRentCustStatus(), fromPublic, id.getIsIgnore(), strategyInfo);
				judgeHouseCanShareOneCondition(StringUtil.parseInteger(map.get("PUBLIC_CANCEL_RENT"), 0), id.getPlateType(), id.getRentCustStatus(), id.getPublicCount(), id.getIsIgnore(), strategyInfo);
			}
		} else {
			throw new BusinessException("信息不对！");
		}
		strategyInfo.append("</table>");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.getWriter().print(strategyInfo.toString());
	}
	
	@GetMapping("/excuteSys")
	@ResponseBody
	public ResponseJson excuteSys(Integer caseType,String caseNo,Integer operatorType,Integer days) {
		//1=修改ACTION_TIME 2=修改TRACK_TIME 3=PRIVATE_TIME
		
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			erpFunSaleMapper.updateByCaseNo(1,caseNo,operatorType,days);
		} /*else if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			erpFunLeaseMapper.updateByCaseNo(1,caseNo,operatorType);
		} else if (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
			erpFunBuyCustomerMapper.updateByCaseNo(1,caseNo,operatorType);
		} else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
			erpFunRentCustomerMapper.updateByCaseNo(1,caseNo,operatorType);
		}*/
		erpSysParaMapper.excuteSys(1);
		return null;
		
	}
	
	/**
	 * 刷新会话中指定的参数
	 * @param archiveId
	 * @param cityId
	 * @param compNo
	 * @param deptNo
	 * @param refreshType
	 * @return
	 * @throws IOException 
	 */
	@GetMapping("/getSysInfo")
	@ApiOperation(value = "获取这条信息的执行情况")
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value={
			@ApiResponse(code = 0, message = "", response = ErpResponseJson.class)
	})
	
	public void getSysInfo(HttpServletResponse response,String compNo ,String userIds,String archiveIds,String userName,String paramIds,String paramType) throws IOException{
		StringBuilder strategyInfo = new StringBuilder("<table border='1'>");
		ErpFunComp compInfo = erpFunCompMapper.getCompByCompNo(compNo);
		List<Integer> userIdList = new ArrayList<>();
		List<Integer> archiveList = new ArrayList<>();
		List<String> userNames = new ArrayList<>();
		if (userIds!=null) {
			String[] userIdArr = userIds.split(",");
			userIdList = new ArrayList<>();
			for (String userId:userIdArr) {
				if (StringUtils.isNotBlank(userId)) {
					userIdList.add(Integer.valueOf(userId));
				}
			}
		}
		if (archiveIds!=null) {
			String[] archiveIdArr = archiveIds.split(",");
			for (String archiveId:archiveIdArr) {
				if (StringUtils.isNotBlank(archiveId)) {
					archiveList.add(Integer.valueOf(archiveId));
				}
			}
		}
		if (userName!=null) {
			String[] userNameArr = userName.split(",");
			for (String userNamea:userNameArr) {
				if (StringUtils.isNotBlank(userNamea)) {
					userNames.add(userNamea);
				}
			}
		}
		List<String> paramIdList = new ArrayList<>();
		if (paramIds!=null) {
			String[] paramIdArr = paramIds.split(",");
			for (String paramId:paramIdArr) {
				if (StringUtils.isNotBlank(paramId)) {
					paramIdList.add(paramId);
				}
			}
		}
		if (paramType!=null) {
			paramIdList = Const.PartnerConfig.PARTNER_DEPART_PARAM.get(paramType);
		}
		if (Integer.valueOf(1).equals(compInfo.getOpenPartner().intValue())) {
			strategyInfo.append("公司编号为").append(compNo).append("开启了加盟模式<br/>");
			ErpFunPartnerConfigExample example = new ErpFunPartnerConfigExample();
			example.setShardCityId(1);
			example.createCriteria().andCompIdEqualTo(compInfo.getCompId()).andIsDelEqualTo(Byte.valueOf("0"));
			example.setOrderByClause("UPDATE_TIME DESC");
			List<ErpFunPartnerConfig> paidConfigList = erpFunPartnerConfigMapper.selectByExample(example);
			if (!paidConfigList.isEmpty()) {
				ErpFunPartnerConfig paidConfig = paidConfigList.get(0);
				if (Byte.valueOf("1").equals(paidConfig.getHouseDataApart())) {
					strategyInfo.append("房源数据隔离").append("开启<br/>");
				}
				if (Byte.valueOf("1").equals(paidConfig.getCustDataApart())) {
					strategyInfo.append("客源数据隔离").append("开启<br/>");
				}
				if (Byte.valueOf("1").equals(paidConfig.getBusinessDataApart())) {
					strategyInfo.append("业务管理-交易数据是否分开管控 0=否 1=是 ").append("开启<br/>");
				}
				if (Byte.valueOf("1").equals(paidConfig.getOrganizationApart())) {
					strategyInfo.append("系统管理-是否需管理组织架构（新建账号、自行修改门店组别信息 ").append("开启<br/>");
				}
				if (Byte.valueOf("1").equals(paidConfig.getDealApart())) {
					strategyInfo.append("系统管理-合同信息自行配置（合同签约主体、合同模板等 0=否 1=是 ").append("开启<br/>");
				}
				if (Byte.valueOf("1").equals(paidConfig.getWageApart())) {
					strategyInfo.append("系统管理-薪资管理自行配置（绩效奖罚、提成配置 0=否 1=是 ").append("开启<br/>");
				}
				if (Byte.valueOf("1").equals(paidConfig.getImplicitCallApart())) {
					strategyInfo.append("系统参数-隐号拨打自行配置 0=否 1=是 ").append("开启<br/>");
				}
				if (Byte.valueOf("1").equals(paidConfig.getTransPlateRuleApart())) {
					strategyInfo.append("系统参数-转盘规则独立配置").append("开启<br/>");
				}
				if (Byte.valueOf("1").equals(paidConfig.getPlateRangeApart())) {
					strategyInfo.append("系统参数-公盘抢盘规则自行配置").append("开启<br/>");
				}
				if (Byte.valueOf("1").equals(paidConfig.getCoreInfoApart())) {
					strategyInfo.append("系统参数-核心信息查看条数自行配置").append("开启<br/>");
				}
				if (Byte.valueOf("1").equals(paidConfig.getStrategyParamApart())) {
					strategyInfo.append("系统参数-	策略参数自行配自行配置").append("开启<br/>");
				}
				if (Byte.valueOf("1").equals(paidConfig.getDealConfigApart())) {
					strategyInfo.append("合同相关自行配置").append("开启<br/>");
				}
				if (Byte.valueOf("1").equals(paidConfig.getAttendanceApart())) {
					strategyInfo.append("考勤管理自行配置").append("开启<br/>");
				}
			}
			List<ErpFunUsers> userInfoList = new ArrayList<>();
			if (userIds!=null) {
				userInfoList = erpFunUsersMapper.selectUserListByIds(compInfo.getCityId().intValue(), compInfo.getCompId(), userIdList);
			} else if (archiveIds!=null) {
				userInfoList = erpFunUsersMapper.selectUserListByArchiveIds(compInfo.getCityId().intValue(), compInfo.getCompId(), archiveList);
			} else if (userName!=null) {
				userInfoList = erpFunUsersMapper.selectUserListByUserName(compInfo.getCityId().intValue(), compInfo.getCompId(), userNames);
			}
			if (userInfoList.size()==1) {
				ErpFunUsers erpFunUser1 = userInfoList.get(0);
				strategyInfo.append("<tr>");
				strategyInfo.append("<td>人员userId：").append(erpFunUser1.getUserId()).append("</td>");
				strategyInfo.append("</tr>");
				strategyInfo.append("<tr>");
				strategyInfo.append("<td>姓名：").append(erpFunUser1.getUserName()).append("</td>");
				strategyInfo.append("</tr>");
				strategyInfo.append("<tr>");
				if (erpFunUser1.getPartnerId()!=null && erpFunUser1.getPartnerId()<1) {
					strategyInfo.append("<td>组织：").append(Integer.valueOf("-1").equals(erpFunUser1.getPartnerId())?"直营":"总部").append("</td>");
				} else {
					ErpFunPartner id = new ErpFunPartner();
					id.setShardCityId(compInfo.getCityId().intValue());
					id.setId(erpFunUser1.getPartnerId());
					id = erpFunPartnerService.selectByPrimaryKey(id);
					strategyInfo.append("<td>组织：").append(id.getPartnerName()).append("加盟商id:").append(id.getId()).append("</td>");
				}
				strategyInfo.append("</tr>");
				if (paramIdList!=null &&!paramIdList.isEmpty()) {
					Map<String,String> sysPara = erpSysParaService.getMLSysParamMapByUserType(compInfo.getCityId().intValue(), compInfo.getCompId(), erpFunUser1.getUserId(), paramIdList);
					for (String key:paramIdList) {
						strategyInfo.append("<tr>");
						strategyInfo.append("<td>参数：").append(Const.PartnerConfig.PARTNER_TRANS_PARAM.get(key)).append("：值：").append(sysPara.get(key)).append("</td>");
						strategyInfo.append("</tr>");
					}
				}
			}
			if (userInfoList.size()==2) {
				ErpFunUsers erpFunUser1 = userInfoList.get(0);
				ErpFunUsers erpFunUser2 = userInfoList.get(1);
				strategyInfo.append("<tr>");
				strategyInfo.append("<td>人员id：").append(erpFunUser1.getUserId()).append("</td>");
				strategyInfo.append("<td>").append(erpFunUser2.getUserId()).append("</td>");
				strategyInfo.append("</tr>");
				strategyInfo.append("<tr>");
				strategyInfo.append("<td>姓名：").append(erpFunUser1.getUserName()).append("</td>");
				strategyInfo.append("<td>姓名：").append(erpFunUser2.getUserName()).append("</td>");
				strategyInfo.append("</tr>");
				strategyInfo.append("<tr>");
				if (erpFunUser1.getPartnerId()!=null && erpFunUser1.getPartnerId()<1) {
					strategyInfo.append("<td>组织：").append(Integer.valueOf("-1").equals(erpFunUser1.getPartnerId())?"直营":"总部").append("</td>");
				} else {
					ErpFunPartner id = new ErpFunPartner();
					id.setShardCityId(compInfo.getCityId().intValue());
					id.setId(erpFunUser1.getPartnerId());
					id = erpFunPartnerService.selectByPrimaryKey(id);
					strategyInfo.append("<td>组织：").append(id.getPartnerName()).append("加盟商id:").append(id.getId()).append("</td>");
				}
				if (erpFunUser2.getPartnerId()!=null && erpFunUser2.getPartnerId()<1) {
					strategyInfo.append("<td>组织：").append(Integer.valueOf("-1").equals(erpFunUser2.getPartnerId())?"直营":"总部").append("</td>");
				} else {
					ErpFunPartner id = new ErpFunPartner();
					id.setShardCityId(compInfo.getCityId().intValue());
					id.setId(erpFunUser2.getPartnerId());
					id = erpFunPartnerService.selectByPrimaryKey(id);
					strategyInfo.append("<td>组织：").append(id.getPartnerName()).append("加盟商id:").append(id.getId()).append("</td>");
				}
				strategyInfo.append("</tr>");
				if (paramIdList!=null &&!paramIdList.isEmpty()) {
					Map<String,String> sysPara1 = erpSysParaService.getMLSysParamMapByUserType(compInfo.getCityId().intValue(), compInfo.getCompId(), erpFunUser1.getUserId(), paramIdList);
					Map<String,String> sysPara2 = erpSysParaService.getMLSysParamMapByUserType(compInfo.getCityId().intValue(), compInfo.getCompId(), erpFunUser2.getUserId(), paramIdList);
					for (String key:paramIdList) {
						strategyInfo.append("<tr>");
						strategyInfo.append("<td>参数：").append(Const.PartnerConfig.PARTNER_TRANS_PARAM.get(key)).append("：值：").append(sysPara1.get(key)).append("</td>");
						strategyInfo.append("<td>").append(sysPara2.get(key)).append("</td>");
						strategyInfo.append("</tr>");
					}
				}
			}
			
			if (userInfoList.size()==3) {
				ErpFunUsers erpFunUser1 = userInfoList.get(0);
				ErpFunUsers erpFunUser2 = userInfoList.get(1);
				ErpFunUsers erpFunUser3 = userInfoList.get(2);
				strategyInfo.append("<tr>");
				strategyInfo.append("<td>人员id：").append(erpFunUser1.getUserId()).append("</td>");
				strategyInfo.append("<td>").append(erpFunUser2.getUserId()).append("</td>");
				strategyInfo.append("<td>").append(erpFunUser3.getUserId()).append("</td>");
				strategyInfo.append("</tr>");
				strategyInfo.append("<tr>");
				strategyInfo.append("<td>姓名：").append(erpFunUser1.getUserName()).append("</td>");
				strategyInfo.append("<td>姓名：").append(erpFunUser2.getUserName()).append("</td>");
				strategyInfo.append("<td>姓名：").append(erpFunUser3.getUserName()).append("</td>");
				strategyInfo.append("</tr>");
				strategyInfo.append("<tr>");
				if (erpFunUser1.getPartnerId()!=null && erpFunUser1.getPartnerId()<1) {
					strategyInfo.append("<td>组织：").append(Integer.valueOf("-1").equals(erpFunUser1.getPartnerId())?"直营":"总部").append("</td>");
				} else {
					ErpFunPartner id = new ErpFunPartner();
					id.setShardCityId(compInfo.getCityId().intValue());
					id.setId(erpFunUser1.getPartnerId());
					id = erpFunPartnerService.selectByPrimaryKey(id);
					strategyInfo.append("<td>组织：").append(id.getPartnerName()).append("加盟商id:").append(id.getId()).append("</td>");
				}
				if (erpFunUser2.getPartnerId()!=null && erpFunUser2.getPartnerId()<1) {
					strategyInfo.append("<td>组织：").append(Integer.valueOf("-1").equals(erpFunUser2.getPartnerId())?"直营":"总部").append("</td>");
				} else {
					ErpFunPartner id = new ErpFunPartner();
					id.setShardCityId(compInfo.getCityId().intValue());
					id.setId(erpFunUser2.getPartnerId());
					id = erpFunPartnerService.selectByPrimaryKey(id);
					strategyInfo.append("<td>组织：").append(id.getPartnerName()).append("加盟商id:").append(id.getId()).append("</td>");
				}
				if (erpFunUser3.getPartnerId()!=null && erpFunUser3.getPartnerId()<1) {
					strategyInfo.append("<td>组织：").append(Integer.valueOf("-1").equals(erpFunUser3.getPartnerId())?"直营":"总部").append("</td>");
				} else {
					ErpFunPartner id = new ErpFunPartner();
					id.setShardCityId(compInfo.getCityId().intValue());
					id.setId(erpFunUser3.getPartnerId());
					id = erpFunPartnerService.selectByPrimaryKey(id);
					strategyInfo.append("<td>组织：").append(id.getPartnerName()).append("加盟商id:").append(id.getId()).append("</td>");
				}
				strategyInfo.append("</tr>");
				if (paramIdList!=null &&!paramIdList.isEmpty()) {
					Map<String,String> sysPara1 = erpSysParaService.getMLSysParamMapByUserType(compInfo.getCityId().intValue(), compInfo.getCompId(), erpFunUser1.getUserId(), paramIdList);
					Map<String,String> sysPara2 = erpSysParaService.getMLSysParamMapByUserType(compInfo.getCityId().intValue(), compInfo.getCompId(), erpFunUser2.getUserId(), paramIdList);
					Map<String,String> sysPara3 = erpSysParaService.getMLSysParamMapByUserType(compInfo.getCityId().intValue(), compInfo.getCompId(), erpFunUser3.getUserId(), paramIdList);
					for (String key:paramIdList) {
						strategyInfo.append("<tr>");
						strategyInfo.append("<td>参数：").append(Const.PartnerConfig.PARTNER_TRANS_PARAM.get(key)).append("：值：").append(sysPara1.get(key)).append("</td>");
						strategyInfo.append("<td>").append(sysPara2.get(key)).append("</td>");
						strategyInfo.append("<td>").append(sysPara3.get(key)).append("</td>");
						strategyInfo.append("</tr>");
					}
				}
			}
		}
		strategyInfo.append("</table>");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.getWriter().print(strategyInfo.toString());
		
	}
	
	private boolean judgeHouseCanRegWarnOneCondition (Date dateNow,Date actionTime,Integer redWarndays, Integer redDays,boolean hasFangKan,Byte redFlag,Byte status,Integer publicCount,Byte isIgnore, StringBuilder builder) {
		/**
		 *    A.SALE_EXPLRTH = 0 AND 未房堪
		      A.RED_FLAG     = 0 AND 无红色标记
		      A.SALE_STATUS  = 1 AND 有效房源
		      A.PUBLIC_COUNT = 0 AND 未跳过抢
			  A.IS_IGNORE	 = 0 
		 */
		if (!hasFangKan && Byte.valueOf("0").equals(redFlag) && Byte.valueOf("1").equals(status) && Integer.valueOf("0").equals(publicCount) && Byte.valueOf("0").equals(isIgnore)) {
			builder.append("该房源actionTime,未房堪执行策略参数起始时间节点::").append(DateTimeHelper.formatDateTimetoString(actionTime));
			Double days = com.myfun.utils.DateUtil.getDaysOfTwoDate(dateNow, actionTime);
			if (days.compareTo(redWarndays.doubleValue())>=0) {
				builder.append("该新登记信息未变过抢盘的满足变红色警告条件！执行一下策略参数即可");
				return true;
			} else {
				builder.append("当前登记信息过抢盘的离跳红色警告还有"+(redWarndays.doubleValue()-days)+"天");
			}
		} else {
			builder.append("该新登记信息未变过抢盘的不满足变红色警告条件！正确条件为为房堪，无红色警告，有效房源，未跳过抢");
		}
		builder.append("<br/>");
		return false;
		
	}
	
	/**
	 * 未房堪跳抢
	 * @param dateNow
	 * @param actionTime
	 * @param redWarndays
	 * @param redDays
	 * @param hasFangKan
	 * @param redFlag
	 * @param status
	 * @param publicCount
	 * @param isIgnore
	 * @param builder
	 * @return
	 */
	private boolean judgeHouseCanRegCondition (Date dateNow,Date actionTime, Integer redDays,boolean hasFangKan,Byte plateType,Byte status,Integer publicCount,Byte isIgnore, StringBuilder builder) {
		/**
		 *       A.SALE_EXPLRTH = 0 AND
      A.SALE_STATUS  = 1 AND
      A.PLATE_TYPE   = 2 AND 
      A.PUBLIC_COUNT = 0 AND
	  A.IS_IGNORE	 = 0
		 */
		if (!hasFangKan && Byte.valueOf("2").equals(plateType) && Byte.valueOf("1").equals(status) && Integer.valueOf("0").equals(publicCount) && Byte.valueOf("0").equals(isIgnore)) {
			builder.append("该房源actionTime,未房堪执行策略参数起始时间节点::").append(DateTimeHelper.formatDateTimetoString(actionTime));
			Double days = com.myfun.utils.DateUtil.getDaysOfTwoDate(dateNow, actionTime);
			if (days.compareTo(redDays.doubleValue())>=0) {
				builder.append("该新登记信息未变过抢盘的满足未房堪跳抢盘的条件！执行一下策略参数即可");
			} else {
				builder.append("当前登记信息离未变过抢盘的未房堪跳抢还有"+days+"天");
			}
		} else {
			builder.append("该新登记信息未变过抢盘的不满足未房堪跳抢条件！正确条件为为房堪，有效房源，未跳过抢，私盘");
		}
		builder.append("<br/>");
		return hasFangKan;
		
	}
	
	/**
	 * 抢盘日起未房堪变红色警告
	 * @param dateNow
	 * @param actionTime
	 * @param redWarndays
	 * @param redDays
	 * @param hasFangKan
	 * @param redFlag
	 * @param status
	 * @param publicCount
	 * @param isIgnore
	 * @param builder
	 * @return
	 */
	private boolean judgeHouseHasPublicCanRegWarnTwoCondition (Date dateNow,Date privateTime, Integer redDays,boolean hasFangKan,Byte redFlag,Byte plateType,Byte status,Integer publicCount,Byte isIgnore, StringBuilder builder) {
		/**
		 *         A.SALE_EXPLRTH = 0 AND
				  	A.RED_FLAG     = 0 AND
				  A.SALE_STATUS  = 1 AND
				  A.PLATE_TYPE   = 2 AND 
				  A.PUBLIC_COUNT > 0 AND
				  A.IS_IGNORE	 = 0
		 */
		if (!hasFangKan &&  Byte.valueOf("0").equals(redFlag) && Byte.valueOf("2").equals(plateType) && Byte.valueOf("1").equals(status) && Integer.valueOf("0").compareTo(publicCount)>0 && Byte.valueOf("0").equals(isIgnore)) {
			builder.append("所抢房源转私盘时间privateTime,未房堪执行策略参数起始时间节点::").append(DateTimeHelper.formatDateTimetoString(privateTime));
			Double days = com.myfun.utils.DateUtil.getDaysOfTwoDate(dateNow, privateTime);
			if (days.compareTo(redDays.doubleValue())>=0) {
				builder.append("所抢房源信息未房堪变红色警告条件！执行一下策略参数即可");
			} else {
				builder.append("所抢房源信息未房堪变红色警告条件！"+days+"天");
			}
		} else {
			builder.append("所抢房源信息未房堪变红色警告不满足未房堪变红色警告时间！正确条件为为房堪，无红色警告，有效房源，之前跳过抢，私盘");
		}
		builder.append("<br/>");
		return hasFangKan;
		
	}
	
	/**
	 * 抢盘日起未房堪跳抢
	 * @param dateNow
	 * @param actionTime
	 * @param redWarndays
	 * @param redDays
	 * @param hasFangKan
	 * @param redFlag
	 * @param status
	 * @param publicCount
	 * @param isIgnore
	 * @param builder
	 * @return
	 */
	private boolean judgeHouseHasPublicCanRegFlagTwoCondition (Date dateNow,Date privateTime, Integer redDays,boolean hasFangKan,Byte plateType,Byte status,Integer publicCount,Byte isIgnore, StringBuilder builder) {
		/**
		       A.SALE_EXPLRTH = 0 AND
      A.SALE_STATUS  = 1 AND
      A.PLATE_TYPE   = 2 AND 
      A.PUBLIC_COUNT > 0 AND
	  A.IS_IGNORE    = 0
		 */
		if (!hasFangKan  && Byte.valueOf("2").equals(plateType) && Byte.valueOf("1").equals(status) && Integer.valueOf("0").compareTo(publicCount)>0 && Byte.valueOf("0").equals(isIgnore)) {
			builder.append("所抢房源转私盘时间privateTime,未房堪执行策略参数起始时间节点::").append(DateTimeHelper.formatDateTimetoString(privateTime));
			Double days = com.myfun.utils.DateUtil.getDaysOfTwoDate(dateNow, privateTime);
			if (days.compareTo(redDays.doubleValue())>=0) {
				builder.append("所抢房源信息未房堪跳抢条件！执行一下策略参数即可");
			} else {
				builder.append("所抢房源信息未房堪跳抢条件！"+days+"天");
			}
		} else {
			builder.append("所抢房源信息未房堪变红色警告不满足未房堪跳抢！正确条件为未房堪，有效房源，之前跳过抢，私盘");
		}
		builder.append("<br/>");
		return hasFangKan;
	}
	
	/**
	 * 该新登记信息未变过抢盘的多少天未跟进间隔变黄色警告
	 * @param dateNow
	 * @param actionTime
	 * @param redWarndays
	 * @param redDays
	 * @param hasFangKan
	 * @param redFlag
	 * @param status
	 * @param publicCount
	 * @param isIgnore
	 * @param builder
	 * @return
	 */
	private boolean judgeHouseCanOrangeFlagOneCondition (Date dateNow,Date trackTime, Integer orangeDays,Byte plateType,boolean orangeFlag,Byte status,Integer fromPublic,Byte isIgnore, StringBuilder builder) {
		/**
 A.SALE_STATUS = 1 AND 
      A.ORANGE_FLAG = 0 AND 
      A.FROM_PUBLIC = 0 AND
	  A.IS_IGNORE   = 0		 */
		if (Byte.valueOf("1").equals(status) && !orangeFlag && Integer.valueOf("0").equals(fromPublic) && Byte.valueOf("0").equals(isIgnore)) {
			builder.append("该新登记信息未变过抢盘的多少天未跟进间隔变黄色警告策略参数起始时间节点::").append(DateTimeHelper.formatDateTimetoString(trackTime));
			Double days = com.myfun.utils.DateUtil.getDaysOfTwoDate(dateNow, trackTime);
			if (days.compareTo(orangeDays.doubleValue())>=0) {
				builder.append("该房源信息未变过抢盘的多少天未跟进间隔变黄色警告满足条件！执行一下策略参数即可");
			} else {
				builder.append("该房源信息未变过抢盘的多少天未跟进间隔变黄色警告不满足条件！"+days+"天");
			}
		} else {
			builder.append("所抢房源信息未房堪变红色警告不满足未房堪跳抢！正确条件为有效房源，不是抢盘，没有黄色标记");
		}
		builder.append("<br/>");
		return false;
	}
	/**
	 * 该新登记信息未变过抢盘的多少天未跟进间隔跳抢
	 * @param dateNow
	 * @param actionTime
	 * @param redWarndays
	 * @param redDays
	 * @param hasFangKan
	 * @param redFlag
	 * @param status
	 * @param publicCount
	 * @param isIgnore
	 * @param builder
	 * @return
	 */
	private boolean judgeHouseCanPublicOrangeOneCondition (Date dateNow,Date trakTime, Integer orangeDays,Byte plateType,Byte status,Integer fromPublic,Byte isIgnore, StringBuilder builder) {
		/**
		 *         A.SALE_STATUS = 1 AND 
      A.PLATE_TYPE  = 2 AND 
      A.FROM_PUBLIC = 0 AND
	  A.IS_IGNORE   = 0
		 */
		if ( Byte.valueOf("2").equals(plateType) && Byte.valueOf("1").equals(status) && Integer.valueOf("0").equals(fromPublic) && Byte.valueOf("0").equals(isIgnore)) {
			builder.append("该新登记信息未变过抢盘的多少天未跟进间隔跳抢参数起始时间节点::").append(DateTimeHelper.formatDateTimetoString(trakTime));
			Double days = com.myfun.utils.DateUtil.getDaysOfTwoDate(dateNow, trakTime);
			if (days.compareTo(orangeDays.doubleValue())>=0) {
				builder.append("该新登记信息未变过抢盘的多少天未跟进间隔跳抢满足条件！执行一下策略参数即可");
			} else {
				builder.append("该新登记信息未变过抢盘的多少天未跟进间隔跳抢不满足条件！"+days+"天");
			}
		} else {
			builder.append("该新登记信息未变过抢盘的多少天未跟进间隔跳抢不满足条件！正确条件为为有效，私盘，");
		}
		builder.append("<br/>");
		return false;
		
	}
	
	/**
	 * 所抢信息多少天未跟进间隔变黄色警告
	 * @param dateNow
	 * @param actionTime
	 * @param redWarndays
	 * @param redDays
	 * @param hasFangKan
	 * @param redFlag
	 * @param status
	 * @param publicCount
	 * @param isIgnore
	 * @param builder
	 * @return
	 */
	private boolean judgeHouseHasPublicCanOrangeFlagOneCondition (Date dateNow,Date trackTime, Integer orangeDays,Byte plateType,boolean orangeFlag,Byte status,Integer fromPublic,Byte isIgnore, StringBuilder builder) {
		/**
       A.SALE_STATUS = 1 AND 
      A.PLATE_TYPE  = 2 AND 
      A.ORANGE_FLAG = 0 AND
      A.FROM_PUBLIC = 1 AND
	  A.IS_IGNORE   = 0		 */
		if (Byte.valueOf("1").equals(status)&& Byte.valueOf("2").equals(plateType) && !orangeFlag && Integer.valueOf("1").equals(fromPublic) && Byte.valueOf("0").equals(isIgnore)) {
			builder.append("所抢信息多少天未跟进间隔变黄色警告策略参数起始时间节点::").append(DateTimeHelper.formatDateTimetoString(trackTime));
			Double days = com.myfun.utils.DateUtil.getDaysOfTwoDate(dateNow, trackTime);
			if (days.compareTo(orangeDays.doubleValue())>=0) {
				builder.append("所抢信息多少天未跟进间隔变黄色警告满足条件！执行一下策略参数即可");
			} else {
				builder.append("所抢信息多少天未跟进间隔变黄色警告不满足条件！"+days+"天");
			}
		} else {
			builder.append("所抢信息多少天未跟进间隔变黄色警告！正确条件为有效房源，私盘，没有黄色标记，之前是抢盘,现在是私盘");
		}
		builder.append("<br/>");
		return false;
	}
	/**
	 * 所抢信息多少天未跟进间隔跳抢
	 * @param dateNow
	 * @param actionTime
	 * @param redWarndays
	 * @param redDays
	 * @param hasFangKan
	 * @param redFlag
	 * @param status
	 * @param publicCount
	 * @param isIgnore
	 * @param builder
	 * @return
	 */
	private boolean judgeHouseHasPublicCanOrangeTwoCondition (Date dateNow,Date trakTime, Integer orangeDays,Byte plateType,Byte status,Integer fromPublic,Byte isIgnore, StringBuilder builder) {
		/**
		 *          A.SALE_STATUS = 1 AND 
      A.PLATE_TYPE  = 2 AND 
      A.FROM_PUBLIC = 1 AND
	  A.IS_IGNORE   = 0
		 */
		if ( Byte.valueOf("2").equals(plateType) && Byte.valueOf("1").equals(status) && Integer.valueOf("1").equals(fromPublic) && Byte.valueOf("0").equals(isIgnore)) {
			builder.append("所抢信息多少天未跟进间隔跳抢参数起始时间节点::").append(DateTimeHelper.formatDateTimetoString(trakTime));
			Double days = com.myfun.utils.DateUtil.getDaysOfTwoDate(dateNow, trakTime);
			if (days.compareTo(orangeDays.doubleValue())>=0) {
				builder.append("所抢信息多少天未跟进间隔跳抢满足条件！执行一下策略参数即可");
			} else {
				builder.append("所抢信息多少天未跟进间隔跳抢不满足条件！"+days+"天");
			}
		} else {
			builder.append("所抢信息多少天未跟进间隔跳抢不满足条件！正确条件为为有效，私盘，之前是抢盘，现在是私盘");
		}
		builder.append("<br/>");
		return false;
		
	}
	
	/**
	 * 信息多少次之后变公盘
	 * @param dateNow
	 * @param actionTime
	 * @param redWarndays
	 * @param redDays
	 * @param hasFangKan
	 * @param redFlag
	 * @param status
	 * @param publicCount
	 * @param isIgnore
	 * @param builder
	 * @return
	 */
	private boolean judgeHouseCanShareOneCondition (Integer shareCount,Byte plateType,Byte status,Integer publicCount,Byte isIgnore, StringBuilder builder) {
		if (Byte.valueOf("1").equals(plateType) && Byte.valueOf("1").equals(status)  && Byte.valueOf("0").equals(isIgnore)) {
			if (publicCount>=shareCount) {
				builder.append("信息多少次之后变公盘！执行一下策略参数即可");
			} else {
				builder.append("信息多少次之后变公盘不满足条件！"+(shareCount-publicCount)+"天");
			}
		} else {
			builder.append("信息多少次之后变公盘不满足条件！正确条件为为抢盘");
		}
		builder.append("<br/>");
		return false;
	}
	
	/**
	 * 客源录入日起未带看-变红色警告
	 * @param dateNow
	 * @param actionTime
	 * @param redWarndays
	 * @param redDays
	 * @param hasFangKan
	 * @param redFlag
	 * @param status
	 * @param publicCount
	 * @param isIgnore
	 * @param builder
	 * @return
	 */
	private boolean judgeCustCanRegWarnOneCondition (Date dateNow,Date actionTime,Integer redWarndays,boolean hasLook,Byte redFlag,Byte status,Integer publicCount,Byte isIgnore, StringBuilder builder) {
		/**
		 *    	A.HOUSE_LOOK		= 0 AND
      			A.RED_FLAG		= 0 AND
      			A.BUY_CUST_STATUS	= 1 AND
      			A.PUBLIC_COUNT    = 0 AND
	  			A.IS_IGNORE		= 0 
		 */
		if (!hasLook && Byte.valueOf("0").equals(redFlag) && Byte.valueOf("1").equals(status) && Integer.valueOf("0").equals(publicCount) && Byte.valueOf("0").equals(isIgnore)) {
			builder.append("该客源actionTime,未带看执行策略参数起始时间节点::").append(DateTimeHelper.formatDateTimetoString(actionTime));
			Double days = com.myfun.utils.DateUtil.getDaysOfTwoDate(dateNow, actionTime);
			if (days.compareTo(redWarndays.doubleValue())>=0) {
				builder.append("该新登记客源信息未变过抢盘的未带看满足变红色警告条件！执行一下策略参数即可");
				return true;
			} else {
				builder.append("当前登记客源信息为带看的离跳红色警告还有"+days+"天");
			}
		} else {
			builder.append("该新登记客源信息未变过抢盘的不满足未带看变红色警告条件！正确条件为为未带看，无红色警告，有效客源，未跳过抢");
		}
		builder.append("<br/>");
		return false;
		
	}
	
	/**
	 * 客源未带看跳抢
	 * @param dateNow
	 * @param actionTime
	 * @param redWarndays
	 * @param redDays
	 * @param hasFangKan
	 * @param redFlag
	 * @param status
	 * @param publicCount
	 * @param isIgnore
	 * @param builder
	 * @return
	 */
	private boolean judgeCustCanRegCondition (Date dateNow,Date actionTime, Integer redDays,boolean hasLook,Byte plateType,Byte status,Integer publicCount,Byte isIgnore, StringBuilder builder) {
		/**
		 *          HOUSE_LOOK       = 0 AND
      BUY_CUST_STATUS  = 1 AND
      PLATE_TYPE       = 2 AND
      PUBLIC_COUNT     = 0 AND
	  A.IS_IGNORE	   = 0 
		 */
		if (!hasLook && Byte.valueOf("2").equals(plateType) && Byte.valueOf("1").equals(status) && Integer.valueOf("0").equals(publicCount) && Byte.valueOf("0").equals(isIgnore)) {
			builder.append("该客源actionTime,未带看执行策略参数起始时间节点::").append(DateTimeHelper.formatDateTimetoString(actionTime));
			Double days = com.myfun.utils.DateUtil.getDaysOfTwoDate(dateNow, actionTime);
			if (days.compareTo(redDays.doubleValue())>=0) {
				builder.append("该登记信息未变过抢盘的满足未带看跳抢盘的条件！执行一下策略参数即可");
			} else {
				builder.append("当前登记信息离未变过抢盘的未带看跳抢还有"+days+"天");
			}
		} else {
			builder.append("该新登记信息未变过抢盘的不满足未带看跳抢条件！正确条件为未带看，有效客源，未跳过抢，私盘");
		}
		builder.append("<br/>");
		return false;
		
	}
	
	/**
	 * 抢盘日起未带看变红色警告
	 * @param dateNow
	 * @param actionTime
	 * @param redWarndays
	 * @param redDays
	 * @param hasFangKan
	 * @param redFlag
	 * @param status
	 * @param publicCount
	 * @param isIgnore
	 * @param builder
	 * @return
	 */
	private boolean judgeCustHasPublicCanRegFlagTwoCondition (Date dateNow,Date privateTime, Integer redDays,boolean hasLook,Byte redFlag,Byte plateType,Byte status,Integer publicCount,Byte isIgnore, StringBuilder builder) {
		/**
		 *  A.HOUSE_LOOK   = 0 AND
      		A.RED_FLAG     = 0 AND
      		A.BUY_CUST_STATUS = 1 AND
      		A.PLATE_TYPE   = 2 AND 
      		A.PUBLIC_COUNT > 0 AND
	  		A.IS_IGNORE    = 0 
		 */
		if (!hasLook &&  Byte.valueOf("0").equals(redFlag) && Byte.valueOf("2").equals(plateType) && Byte.valueOf("1").equals(status) && Integer.valueOf("0").compareTo(publicCount)>0 && Byte.valueOf("0").equals(isIgnore)) {
			builder.append("所抢客源转私盘时间privateTime,未房堪执行策略参数起始时间节点::").append(DateTimeHelper.formatDateTimetoString(privateTime));
			Double days = com.myfun.utils.DateUtil.getDaysOfTwoDate(dateNow, privateTime);
			if (days.compareTo(redDays.doubleValue())>=0) {
				builder.append("所抢客源信息未带看变红色警告条件！执行一下策略参数即可");
			} else {
				builder.append("所抢房源信息未带看变红色警告条件！"+days+"天");
			}
		} else {
			builder.append("所抢客源信息变红色警告不满足未带看变红色警告时间！正确条件为未带看，无红色警告，有效客源，之前跳过抢，现在是私盘");
		}
		builder.append("<br/>");
		return false;
		
	}
	
	/**
	 * 抢盘日起未带看跳抢
	 * @param dateNow
	 * @param actionTime
	 * @param redWarndays
	 * @param redDays
	 * @param hasFangKan
	 * @param redFlag
	 * @param status
	 * @param publicCount
	 * @param isIgnore
	 * @param builder
	 * @return
	 */
	private boolean judgeCustHasPublicCanRegFlagTwoCondition11 (Date dateNow,Date privateTime, Integer redDays,boolean hasLook,Byte plateType,Byte status,Integer publicCount,Byte isIgnore, StringBuilder builder) {
		/**
		        A.HOUSE_LOOK      = 0 AND
      A.BUY_CUST_STATUS = 1 AND
      A.PLATE_TYPE      = 2 AND 
      A.PUBLIC_COUNT    > 0 AND
	  A.IS_IGNORE		= 
		 */
		if (!hasLook  && Byte.valueOf("2").equals(plateType) && Byte.valueOf("1").equals(status) && Integer.valueOf("0").compareTo(publicCount)>0 && Byte.valueOf("0").equals(isIgnore)) {
			builder.append("所抢客源转私盘时间privateTime,未带看执行策略参数起始时间节点::").append(DateTimeHelper.formatDateTimetoString(privateTime));
			Double days = com.myfun.utils.DateUtil.getDaysOfTwoDate(dateNow, privateTime);
			if (days.compareTo(redDays.doubleValue())>=0) {
				builder.append("所抢客源信息未带看跳抢条件！执行一下策略参数即可");
			} else {
				builder.append("所抢客源信息未带看跳抢条件！"+days+"天");
			}
		} else {
			builder.append("所抢房源信息未房堪变红色警告不满足未房堪跳抢！正确条件为未房堪，有效房源，之前跳过抢，私盘");
		}
		builder.append("<br/>");
		return false;
	}
	
	/**
	 * 该新登记信息未变过抢盘的多少天未跟进间隔变黄色警告
	 * @param dateNow
	 * @param actionTime
	 * @param redWarndays
	 * @param redDays
	 * @param hasFangKan
	 * @param redFlag
	 * @param status
	 * @param publicCount
	 * @param isIgnore
	 * @param builder
	 * @return
	 */
	private boolean judgeCustCanOrangeFlagOneCondition (Date dateNow,Date trackTime,Byte orangeFlag, Integer orangeDays,Byte plateType,Byte status,Integer fromPublic,Byte isIgnore, StringBuilder builder) {
		/**
       A.BUY_CUST_STATUS = 1 AND 
      A.ORANGE_FLAG     = 0 AND 
      A.FROM_PUBLIC     = 0 AND
	  A.IS_IGNORE		= 0 */
		if (Byte.valueOf("1").equals(status)&& Byte.valueOf("0").equals(orangeFlag) && Integer.valueOf("0").equals(fromPublic) && Byte.valueOf("0").equals(isIgnore)) {
			builder.append("该新登记客源未变过抢盘的多少天未跟进间隔变黄色警告策略参数起始时间节点::").append(DateTimeHelper.formatDateTimetoString(trackTime));
			Double days = com.myfun.utils.DateUtil.getDaysOfTwoDate(dateNow, trackTime);
			if (days.compareTo(orangeDays.doubleValue())>=0) {
				builder.append("该客源信息未变过抢盘的多少天未跟进间隔变黄色警告满足条件！执行一下策略参数即可");
			} else {
				builder.append("该客源信息未变过抢盘的多少天未跟进间隔变黄色警告不满足条件！"+days+"天");
			}
		} else {
			builder.append("该客源所抢房源未变过抢盘的多少天未跟进间隔变黄色警告！正确条件为有效客源，不是来自抢盘，没有黄色标记");
		}
		builder.append("<br/>");
		return false;
	}
	/**
	 * 该新登记客源信息未变过抢盘的多少天未跟进间隔跳抢
	 * @param dateNow
	 * @param actionTime
	 * @param redWarndays
	 * @param redDays
	 * @param hasFangKan
	 * @param redFlag
	 * @param status
	 * @param publicCount
	 * @param isIgnore
	 * @param builder
	 * @return
	 */
	private boolean judgeCustCanPublicOrangeOneCondition (Date dateNow,Date trakTime, Integer orangeDays,Byte plateType,Byte status,Integer fromPublic,Byte isIgnore, StringBuilder builder) {
		/**
		 *               A.BUY_CUST_STATUS = 1 AND 
      A.PLATE_TYPE      = 2 AND 
      A.FROM_PUBLIC     = 0 AND
	  A.IS_IGNORE		= 0 
		 */
		if ( Byte.valueOf("2").equals(plateType) && Byte.valueOf("1").equals(status) && Integer.valueOf("0").equals(fromPublic) && Byte.valueOf("0").equals(isIgnore)) {
			builder.append("该新登记客源信息未变过抢盘的多少天未跟进间隔跳抢参数起始时间节点::").append(DateTimeHelper.formatDateTimetoString(trakTime));
			Double days = com.myfun.utils.DateUtil.getDaysOfTwoDate(dateNow, trakTime);
			if (days.compareTo(orangeDays.doubleValue())>=0) {
				builder.append("该新登记客源信息未变过抢盘的多少天未跟进间隔跳抢满足条件！执行一下策略参数即可");
			} else {
				builder.append("该新登记客源信息未变过抢盘的多少天未跟进间隔跳抢不满足条件！"+days+"天");
			}
		} else {
			builder.append("该新登记信息未变过抢盘的多少天未跟进间隔跳抢不满足条件！正确条件为为有效，私盘，不是来自抢盘");
		}
		builder.append("<br/>");
		return false;
		
	}
	
	/**
	 * 所抢信息多少天未跟进间隔变黄色警告
	 * @param dateNow
	 * @param actionTime
	 * @param redWarndays
	 * @param redDays
	 * @param hasFangKan
	 * @param redFlag
	 * @param status
	 * @param publicCount
	 * @param isIgnore
	 * @param builder
	 * @return
	 */
	private boolean judgeCustHasPublicCanOrangeFlagOneCondition (Date dateNow,Date trackTime, Integer orangeDays,Byte plateType,Byte orangeFlag,Byte status,Integer fromPublic,Byte isIgnore, StringBuilder builder) {
		/**
             A.BUY_CUST_STATUS = 1 AND 
      A.PLATE_TYPE      = 2 AND 
      A.ORANGE_FLAG     = 0 AND
      A.FROM_PUBLIC     = 1	AND
	  A.IS_IGNORE		= 0 		 	 */
		if (Byte.valueOf("1").equals(status)&& Byte.valueOf("2").equals(plateType) && Byte.valueOf("0").equals(orangeFlag) && Integer.valueOf("1").equals(fromPublic) && Byte.valueOf("0").equals(isIgnore)) {
			builder.append("所抢客源信息多少天未跟进间隔变黄色警告策略参数起始时间节点::").append(DateTimeHelper.formatDateTimetoString(trackTime));
			Double days = com.myfun.utils.DateUtil.getDaysOfTwoDate(dateNow, trackTime);
			if (days.compareTo(orangeDays.doubleValue())>=0) {
				builder.append("所抢客源信息多少天未跟进间隔变黄色警告满足条件！执行一下策略参数即可");
			} else {
				builder.append("所抢客源信息多少天未跟进间隔变黄色警告不满足条件！"+days+"天");
			}
		} else {
			builder.append("所抢客源信息多少天未跟进间隔变黄色警告！正确条件为有效客源，私盘，没有黄色标记，之前是抢盘,现在是私盘");
		}
		builder.append("<br/>");
		return false;
	}
	/**
	 * 所抢信息多少天未跟进间隔跳抢
	 * @param dateNow
	 * @param actionTime
	 * @param redWarndays
	 * @param redDays
	 * @param hasFangKan
	 * @param redFlag
	 * @param status
	 * @param publicCount
	 * @param isIgnore
	 * @param builder
	 * @return
	 */
	private boolean judgeCustHasPublicCanOrangeTwoCondition (Date dateNow,Date trakTime, Integer orangeDays,Byte plateType,Byte status,Integer fromPublic,Byte isIgnore, StringBuilder builder) {
		/**
		 *          A.BUY_CUST_STATUS = 1 AND 
      A.PLATE_TYPE      = 2 AND 
      A.FROM_PUBLIC     = 1	AND
	  A.IS_IGNORE		= 0 
		 */
		if ( Byte.valueOf("2").equals(plateType) && Byte.valueOf("1").equals(status) && Integer.valueOf("1").equals(fromPublic) && Byte.valueOf("0").equals(isIgnore)) {
			builder.append("所抢客源信息多少天未跟进间隔跳抢参数起始时间节点::").append(DateTimeHelper.formatDateTimetoString(trakTime));
			Double days = com.myfun.utils.DateUtil.getDaysOfTwoDate(dateNow, trakTime);
			if (days.compareTo(orangeDays.doubleValue())>=0) {
				builder.append("所抢客源信息多少天未跟进间隔跳抢满足条件！执行一下策略参数即可");
			} else {
				builder.append("所抢客源信息多少天未跟进间隔跳抢不满足条件！"+days+"天");
			}
		} else {
			builder.append("所抢客源信息多少天未跟进间隔跳抢不满足条件！正确条件为为有效，私盘，之前是抢盘，现在是私盘");
		}
		return false;
		
	}
	
	
	/**
	 * 刷新会话中指定的参数
	 * @param archiveId
	 * @param cityId
	 * @param compNo
	 * @param deptNo
	 * @param refreshType
	 * @return
	 * @throws IOException 
	 */
	@GetMapping("/dealOrgPath")
	@ApiOperation(value = "获取这条信息的执行情况")
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value={
			@ApiResponse(code = 0, message = "", response = ErpResponseJson.class)
	})
	@ResponseBody
	public ErpResponseJson dealOrgPath(Integer cityId ,Integer compId,Integer orgId) throws IOException{
		if (cityId!=null && compId!=null && orgId!=null) {
			publisher.sendMoveOrgMsg(cityId, compId, orgId, null);
		}
		return ErpResponseJson.ok();
	}
	
	/**
	 * 刷新会话中指定的参数
	 * @param archiveId
	 * @param cityId
	 * @param compNo
	 * @param deptNo
	 * @param refreshType
	 * @return
	 * @throws IOException 
	 */
	@PostMapping("/dealNewOrgUserCount")
	@ApiOperation(value = "获取这条信息的执行情况")
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value={
			@ApiResponse(code = 0, message = "", response = ErpResponseJson.class)
	})
	@ResponseBody
	public ErpResponseJson dealNewOrgUserCount(@RequestBody DealNewOrgUserCountMessage param) throws IOException{
		if (param.getCityId()!=null && param.getCompId()!=null ) {
			if (Integer.valueOf(1).equals(param.getDealType())) {
				Map<String,Integer> resultMap = erpFunOrganizationService.moveUserNewOrganization(param.getCityId(), param.getCompId(), param.getSelfUserId(), param.getMoveUserId(), param.getOldOrgId(), param.getNewOrgId(), null);
				Map<String, Object> changeDeptInfo = new HashMap<>();
				changeDeptInfo.put("cityId", param.getCityId());
				changeDeptInfo.put("compId", param.getCompId());
				changeDeptInfo.put("newOrgId", resultMap.get("lookNewLevelId"));
				changeDeptInfo.put("oldOrgId", resultMap.get("lookOldLevelId"));
				changeDeptInfo.put("archiveId", param.getMoveArchiveId());
				httpRequestTask.postToMobileWeb("approveOpenApi/yxTeam/changeOrg", changeDeptInfo);
			} else {
				MoveOrganizationServiceVO moveOrganizationServiceVO = erpFunOrganizationService.moveOrganization(param.getCityId(), param.getCompId(), param.getSelfUserId(), param.getMoveOrgId(), param.getOldPid(), param.getNewPid());
			}
		}
		return ErpResponseJson.ok();
	}
	
	@ResponseBody
    @RequestMapping(value = "/createComp")
    public ResponseJson createComp(@RequestBody UpdateChileCompParam param) {
        try {
            return commonController.createChildComp(param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DefaultResponseJson(Const.ResponseCode.OTHER_FAIL, "创建失败");
    }
	
    @PostMapping("/addSubOrganization")
    @ResponseBody
    public ErpResponseJson addSubOrganization(@RequestBody @Valid AddSubOrganizationParam param) {
        Integer newOrganizationId = erpFunOrganizationService.insertOrganizationInfo(param,"系统");
        activeMqPublisher.sendMoveOrgMsg(param.getCityId(), param.getCompId(), newOrganizationId, null);
        AddSubOrganizationVO vo = new AddSubOrganizationVO();
        vo.setOrganizationId(newOrganizationId);
        return ErpResponseJson.ok(vo);
    }
    
    @GetMapping("/getThreadMintor")
    @ResponseBody
    public String getThreadMintor() {
    	ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        bean.setThreadContentionMonitoringEnabled(true);
        ThreadInfo[] threads = bean.dumpAllThreads(true, true);
        StringBuilder sb = new StringBuilder();
        for (ThreadInfo thread : threads) {
            StackTraceElement[] stackTrace = thread.getStackTrace();
            sb.append("-------------------------------------------------------\r\n");
            for (int i = 0; i < stackTrace.length; i++) {
                StackTraceElement element = stackTrace[i];
                sb.append(element.toString()).append("\r\n");
            }
        }
        System.out.println(sb.toString());
    	return sb.toString();
    }

    @GetMapping("/updateOrgUserNum")
    @ResponseBody
    public ErpResponseJson updateOrgUserNum(UpdateOrgUserNumParam param) {
		mqPublisher.UpdateOrgUserNum(param.getCityId(), param.getCompId(),param.getMovePath());
    	return ErpResponseJson.ok();
    }

	@GetMapping("/updateSupplementaryDataRecordNo")
	@ResponseBody
	public ErpResponseJson updateSupplementaryDataRecordNo(Integer type) {
		if(type == 1){
			return ErpResponseJson.ok("成功");
		}
		List<ErpFunEntrust> recordNos = erpFunEntrustMapper.selectSupplementaryDataRecordNo(1);
		for (ErpFunEntrust recordNo : recordNos) {
			String[] split = recordNo.getRecordNo().split(",");
			for (String dimension : split) {
				if(StringUtil.isBlank(dimension)){
					continue;
				}
				ErpFunEntrustRecordNo funEntrustRecordNo = new ErpFunEntrustRecordNo();
				funEntrustRecordNo.setShardCityId(recordNo.getCityId());
				funEntrustRecordNo.setEntrustId(recordNo.getEntrustId());
				funEntrustRecordNo.setRecordNo(dimension);
				erpFunEntrustRecordNoMapper.insertSelective(funEntrustRecordNo);
			}
		}
		return ErpResponseJson.ok("完美");
	}
}



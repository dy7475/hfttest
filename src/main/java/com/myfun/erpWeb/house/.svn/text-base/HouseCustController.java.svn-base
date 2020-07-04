package com.myfun.erpWeb.house;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myfun.erpWeb.house.param.GetHouseCustCountParam;
import com.myfun.erpWeb.house.vo.HouseCustCountVo;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dto.AdminFunArchiveDto;
import com.myfun.repository.agencydb.dao.AgencyFunCustMapper;
import com.myfun.repository.erpdb.dto.ErpFunTaskDto;
import com.myfun.repository.erpdb.param.ErpCreateTrackInfoParam;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.erpdb.ErpFunKeyService;
import com.myfun.service.business.erpdb.ErpFunTaskService;
import com.myfun.service.business.erpdb.ErpFunTrackService;
import com.myfun.service.business.erpdb.ErpSysParaService;
import com.myfun.utils.DateConvert;
import com.myfun.utils.DateTimeHelper;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 房客源公共控制器
 */
@Controller
@RequestMapping(value = "/houseCust", method = RequestMethod.POST)
public class HouseCustController extends BaseController {

	@Autowired
	ErpFunRoadsInfoMapper erpFunRoadsInfoMapper;
	@Autowired
	ErpFunTrackService erpFunTrackService;
	@Autowired
	ErpFunTrackMapper erpFunTrackMapper;
	@Autowired
	ErpFunTaskMapper erpFunTaskMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
	@Autowired
	ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	@Autowired
	AgencyFunCustMapper agencyFunCustMapper;
	@Autowired
	ErpTrackUsersMapper erpTrackUsersMapper;
	@Autowired
	ErpFunKeyService erpFunKeyService;
	@Autowired
	ErpFunKeyMapper erpFunKeyMapper;
	@Autowired
	ErpFunTaskService erpFunTaskService;
	@Autowired
	ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	ErpFunTaskTimedMapper erpFunTaskTimedMapper;
	@Autowired
	AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired
	ErpUserOpersMapper erpUserOpersMapper;
	@Autowired
	private ErpFunOrganizationMapper erpFunOrganizationMapper;
    @Autowired
    private ErpSysParaService erpSysParaService;
	
	/**
	 * 查看核心信息判断
	 * @author 张宏利
	 * @since 2017年11月9日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/judgeViewCoreInfo")
	public ResponseJson judgeViewCoreInfo(@RequestBody ErpCreateTrackInfoParam param) {
		param.setTrackType(Const.DIC_TRACK_TYPE_VIEW_PHONE);
		return this.createTrackInfo(param);
	}
	
	/**
	 * 获取房客源和分销数据数量
	 * @author 张宏利
	 * @since 2018年1月30日
	 * @param param
	 * @return
	 */
	@ApiOperation("获取房客源和分销数据数量,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = HouseCustCountVo.class, message = "成功")})
	@ResponseBody
	@RequestMapping("/getHouseCustCount")
	public ResponseJson getHouseCustCount(@RequestBody GetHouseCustCountParam param) {
		
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
        if (null == cityId){
        	cityId = getOperator().getCityId();
        }
        if (null == compId){
        	compId = getOperator().getCompId();
        }
		
		Operator operator = getOperator();
		Integer userId = param.getUserId();
/*		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();*/
		// 是否是新版组织
		boolean newOrganizationType = operator.newOrganizationType();

		//ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(cityId, userId);
		ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserIdNew(cityId,compId, userId);  //跨城后要根据cityId和compId去查
		Integer saleCount = erpFunSaleMapper.getSaleCount(cityId, compId, userId);
		Integer leaseCount = erpFunLeaseMapper.getLeaseCount(cityId, compId, userId);
		ErpFunUsers selfUsers = new ErpFunUsers();

		if (!newOrganizationType) {
			selfUsers.setAreaId(operator.getAreaId());
			selfUsers.setRegId(operator.getRegId());
			selfUsers.setDeptId(operator.getDeptId());
			selfUsers.setGrId(operator.getGrId());
		} else {
			selfUsers.setOrganizationId(operator.getOrganizationId());
		}
		selfUsers.setUserId(operator.getUserId());
		selfUsers.setCompId(compId);
		selfUsers.setCityId(cityId.shortValue());
		// 判断移交权限
		if(saleCount > 0 || leaseCount > 0){
			Boolean exchangeFlag;
			if (newOrganizationType) {
				exchangeFlag = this.getDataExchangeOperNewOrg(cityId, Const.DIC_CASE_TYPE_SALE_FUN, selfUsers, erpFunUsers);
			} else {
				exchangeFlag = this.getDataExchangeOper(cityId, Const.DIC_CASE_TYPE_SALE_FUN, selfUsers, erpFunUsers);
			}
			if(!exchangeFlag){
				throw new BusinessException("你没有数据移交权限，不能移交数据！");
			}
		}
		Integer buyCount = erpFunBuyCustomerMapper.getBuyCustCount(cityId, compId, userId);
		Integer rentCount = erpFunRentCustomerMapper.getRentCustCount(cityId, compId, userId);
		if(buyCount > 0 || rentCount > 0){
			Boolean exchangeFlag;
			if (newOrganizationType) {
				exchangeFlag = this.getDataExchangeOperNewOrg(cityId, Const.DIC_CASE_TYPE_BUY_CUST, selfUsers, erpFunUsers);
			} else {
				exchangeFlag = this.getDataExchangeOper(cityId, Const.DIC_CASE_TYPE_BUY_CUST, selfUsers, erpFunUsers);
			}
			if(!exchangeFlag){
				throw new BusinessException("你没有数据移交权限，不能移交数据！");
			}
		}
		Integer custCount = agencyFunCustMapper.getCustCount(cityId, compId, erpFunUsers.getArchiveId());
		if(custCount > 0){
			Boolean exchangeFlag;
			if (newOrganizationType) {
				exchangeFlag = this.getDataExchangeOperNewOrg(cityId, null, selfUsers, erpFunUsers);
			} else {
				exchangeFlag = this.getDataExchangeOper(cityId, null, selfUsers, erpFunUsers);
			}

			if(!exchangeFlag){
				throw new BusinessException("你没有数据移交权限，不能移交数据！");
			}
		}
		
		
		
		
		//查被注销人的层级，而不是会话里面的层级
        ErpSysPara paraHouse = erpSysParaService.getMLErpSysParamByOrgId(cityId, compId, erpFunUsers.getOrganizationId(),"TRANS_WRITEOFF_USERR_HOUSE_DATA");   //房源参数
        ErpSysPara paraCust = erpSysParaService.getMLErpSysParamByOrgId(cityId, compId, erpFunUsers.getOrganizationId(), "TRANS_WRITEOFF_USERR_CUST_DATA");     //客源参数
        
/*        boolean houseParamIsNull = (null == paraHouse || null == paraHouse.getParamValue() || "0".equals(paraHouse.getParamValue()));    //房源参数取出来是否为空，为空为true
        boolean custParamIsNull = (null == paraCust || null == paraCust.getParamValue() || "0".equals(paraCust.getParamValue()));*/
        
        boolean houseParamIsNull = (null == paraHouse || null == paraHouse.getParamValue());    //房源参数取出来是否为空，为空为true,为0是跳公司级
        boolean custParamIsNull = (null == paraCust || null == paraCust.getParamValue());
        
        if (!houseParamIsNull){   //如果设置了参数,则房源和客源直接给前端返回0
        	saleCount = 0;
        	leaseCount = 0;
        }
        if (!custParamIsNull){
        	buyCount = 0;
        	rentCount = 0;
        }
        
		
		// 组装成MAP
		Map<String, Integer> resultMap = new HashMap<>();
		resultMap.put("saleCount", saleCount);
		resultMap.put("leaseCount", leaseCount);
		resultMap.put("buyCount", buyCount);
		resultMap.put("rentCount", rentCount);
		resultMap.put("custCount", custCount);
		return ErpResponseJson.ok(resultMap);
	}
	
	/**
	 * 获取房客源数据移交权限
	 * @author 朱科
	 * @since 2018年11月14日
	 * @return
	 */
	private Boolean getDataExchangeOper(Integer cityId, Integer caseType, ErpFunUsers selfUsers, ErpFunUsers destUsers){
		Integer selfUserId = selfUsers.getUserId();
		String[] opersArr = null;
		if(Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType) || Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)){
			opersArr = new String[]{"COMP_HOUSE_DATA_EXCHANGE","AREA_HOUSE_DATA_EXCHANGE","REG_HOUSE_DATA_EXCHANGE","DEPT_HOUSE_DATA_EXCHANGE","GROUP_HOUSE_DATA_EXCHANGE"};
		} else if (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType) || Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)){
			opersArr = new String[]{"COMP_CUST_DATA_EXCHANGE","AREA_CUST_DATA_EXCHANGE","REG_CUST_DATA_EXCHANGE","DEPT_CUST_DATA_EXCHANGE","GROUP_CUST_DATA_EXCHANGE"};
		} else {// 分销客户
			opersArr = new String[]{"COMP_LINK_CUST_DATA_EXCHANGE","AREA_LINK_CUST_DATA_EXCHANGE","REG_LINK_CUST_DATA_EXCHANGE","DEPT_LINK_CUST_DATA_EXCHANGE","GROUP_LINK_CUST_DATA_EXCHANGE"};
		}
		Set<String> OpersSet = erpUserOpersMapper.getUsersOpersByUserId(cityId, selfUserId, opersArr);
		if(OpersSet == null || OpersSet.isEmpty()){
			return false;
		}
		Set<String> tempOpersSet = new HashSet<>();
		for (String operId : OpersSet) {
			tempOpersSet.add(operId.substring(0, 3));
		}
		Integer rangType = 6;
		if(tempOpersSet.contains("COM")){
			rangType = 1;
		} else if(tempOpersSet.contains("ARE")){
			rangType = 2;
		} else if(tempOpersSet.contains("REG")){
			rangType = 3;
		} else if(tempOpersSet.contains("DEP")){
			rangType = 4;
		} else if(tempOpersSet.contains("GRO")){
			rangType = 5;
		}
		if(rangType == 1){
			return true;
		} else if (rangType == 2 && selfUsers.getAreaId().equals(destUsers.getAreaId())){
			return true;
		} else if(rangType == 3 && selfUsers.getRegId().equals(destUsers.getRegId())){
			return true;
		} else if(rangType == 4 && selfUsers.getDeptId().equals(destUsers.getDeptId())){
			return true;
		} else if(rangType == 5 && selfUsers.getGrId() != null && selfUsers.getGrId() != 0 &&selfUsers.getGrId().equals(destUsers.getGrId())){
			return true;
		}
		return false;
	}

	/**
	 * 获取房客源数据移交权限-新版组织
	 *
	 */
	private Boolean getDataExchangeOperNewOrg(Integer cityId, Integer caseType, ErpFunUsers selfUsers, ErpFunUsers targetUsers) {
		Integer selfUserId = selfUsers.getUserId();
		Integer compId = selfUsers.getCompId();
		Integer targetOrgId = targetUsers.getOrganizationId();

		String operId;
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType) || Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			operId = "ORGANIZATION_HOUSE_DATA_EXCHANGE";
		} else if (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType) || Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
			operId = "ORGANIZATION_CUST_DATA_EXCHANGE";
		} else {
			// 分销客户
			operId = "ORGANIZATION_LINK_CUST_DATA_EXCHANGE";
		}

		// 判断是否有房源数据移交权
		boolean hasAuth = false;
		if (selfUserId != null) {
			ErpUserOpers erpUserOpers = erpUserOpersMapper.getUserOperByUSerIdOperId(cityId, selfUserId, operId);
			if (erpUserOpers != null) {
				// 0代表全公司
				if (Integer.valueOf("0").equals(erpUserOpers.getOrganizationDefinitionId())) {
					return true;
				}
				//机构层级表中的ID
				ErpFunOrganizationExample example = new ErpFunOrganizationExample();
				example.setShardCityId(cityId);
				example.createCriteria().andCompIdEqualTo(compId).andOrganizationDefinitionIdEqualTo(erpUserOpers.getOrganizationDefinitionId()).andDelFlagEqualTo((byte) 0);
				List<ErpFunOrganization> orgObjList = erpFunOrganizationMapper.selectByExample(example);
				if (!orgObjList.isEmpty()) {
					hasAuth = orgObjList.stream().map(ErpFunOrganization::getOrganizationId).collect(Collectors.toSet()).contains(targetOrgId);
				}
			}
		}

		return hasAuth;
	}
	
	/**
	 * 所有创建跟进的方法
	 * @author 张宏利
	 * @since 2017年10月11日
	 * @param param
	 * @return
	 * @ 
	 */
	@ResponseBody
	@RequestMapping("/createTrackInfo")
	public ResponseJson createTrackInfo(@Valid @RequestBody ErpCreateTrackInfoParam param) {
	    if(true) {
            throw new BusinessException("请将软件升级到最新版!");
        }
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
		param.setCompType(operator.getCompType());
		param.setIsPersonalVersion(operator.isPersonalVersion());
		param.setAreaFlag(operator.getAreaFlag());
		param.setPcname(operator.getAttribute("PCNAME") + "");
		param.setUserPosition(operator.getUserPosition());
		param.setIsGeneralManager(operator.isGeneralManager());
		Object crmCompId = operator.getAttribute("CRM_COMP_ID");
		if(null != crmCompId) {
			param.setCrmCompId(Integer.valueOf(crmCompId+""));
		}
		// 这个做个转换,和前端对接了取消
		if (Const.DIC_TRACK_TYPE_STATUS_INNERDEAL.equals(param.getTrackType())// 内成交-28
				|| Const.DIC_TRACK_TYPE_STATUS_OUTDEAL.equals(param.getTrackType())// 外成交-29
				|| Const.DIC_TRACK_TYPE_STATUS_WRITEOFF.equals(param.getTrackType())) {
			if (null == param.getMakeSure()) {
				if (null != param.getSyncSaleLeaseStatus()) {
					param.setMakeSure(param.getSyncSaleLeaseStatus());
				} else {
					param.setMakeSure((byte) 0);
				}
			}
		}
		// 以上参数组装的增删可能要同步HouseController.generatorParamForKey()
		Map<String, Object> resultMap = erpFunTrackService.createTrackInfo(param);
		// 增加工作量
		erpFunTrackService.sendJmsMessageForWorkCount(param);
		return ErpResponseJson.ok(resultMap);
	}
	
	/**
	 * 创建跟进提醒
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/createTrackWarmTask")
	public ResponseJson createTrackWarmTask(@Valid @RequestBody ErpCreateTrackInfoParam param) {
		Operator operator = getOperator();
		param.setCityId(operator.getCityId());
		param.setCompId(operator.getCompId());
		param.setSelfUserId(getOperator().getUserId());
		param.setSelfDeptId(getOperator().getDeptId());
		// 设置用户门店名+用户名
		String currUserName = erpFunTrackService.getCurrUserName(operator.getDeptName(), operator.getUserName(), operator.getCompType(), operator.isPersonalVersion());
		param.setSelfCurrUserName(currUserName);
		param.setCreateCurrUserName(currUserName);
		ErpFunUsers createUsers = erpFunUsersMapper.selectByUserId(operator.getCityId(), getOperator().getUserId());
		param.setCreateAuditUser(createUsers);
		erpFunTaskService.createWarmTask(param, null, (byte) 0);
		return ErpResponseJson.ok();
	}
	
	/***
	 * 获取提醒列表
	 * @author 熊刚
	 * @since 2017年11月8日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTrackWarmTaskList")
	public ResponseJson getTrackWarmTaskList(@Valid @RequestBody BaseMapParam param) {
		String[] conStr = DateConvert.getConditionDate(param.getString("time"));
		param.setString("startTime", conStr[0]);
		param.setString("endTime", conStr[1]);
		String caseType = String.valueOf(param.getInteger("caseType"));	
		String[] caseTypeList =null;
		if(param.getInteger("taskOwner")!=null && !getOperator().isPerLogin()){
		}else if (getOperator().isPerLogin()){
			if(StringUtils.isNotBlank(caseType)){
				caseType = caseType.replaceAll(",101,102", "");
				caseType = caseType.replaceAll("101,102", "");
				if (caseType.contains(",")) {
					caseTypeList =  caseType.split(",");
					param.setObject("caseTypeList", caseTypeList);
				}
			}
		}
		List<ErpFunTaskDto> erpFunTaskDtoList = erpFunTaskMapper.getErpFunTaskList(getOperator().getCityId(),getOperator().getCompId(),param.getMap());
		List<Integer>  userIdList = erpFunTaskDtoList.stream().map(ErpFunTaskDto :: getTaskOwner).collect(Collectors.toList());
		Map<Integer, ErpFunUsers> userInfoMap = new HashMap<Integer, ErpFunUsers>();
		if(!getOperator().isPersonalVersion()){
			List<ErpFunUsers> erpFunUsersList = erpFunUsersMapper.getErpFunUsersList(getOperator().getCityId(),userIdList);
			userInfoMap = erpFunUsersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, dept -> dept)); 
		}else{
			ErpFunUsers erpFunUsers = new ErpFunUsers();
			erpFunUsers.setUserId(getOperator().getUserId());
			erpFunUsers.setUserName(getOperator().getUserName());
			userInfoMap.put(getOperator().getUserId(), erpFunUsers);
		}
		for(ErpFunTaskDto erpFunTaskDto : erpFunTaskDtoList){
			//erpFunTaskDto.setErpFunTask(erpFunTaskStr);
			erpFunTaskDto.setCreationTime(DateTimeHelper.formatDateTimetoString(erpFunTaskDto.getCreationTime(), "yyyy-MM-dd HH:mm:ss"));
			if(Const.DIC_SYSTEM_USERID_998.equals(erpFunTaskDto.getCreatorUid())){
				erpFunTaskDto.setUserName(Const.DIC_SYSTEM_USERNAME_998);
			} else if (!erpFunTaskDto.getCreatorUid().equals(Const.DIC_SYSTEM_USERID_999)) {
				ErpFunUsers  erpFunUsers = userInfoMap.get(erpFunTaskDto.getCreatorUid());
				if(erpFunUsers!=null){
					erpFunTaskDto.setUserName(erpFunUsers.getUserName());
				}
			} else{
				erpFunTaskDto.setUserName("系统");
			}
			erpFunTaskDtoList.add(erpFunTaskDto);
		}
		return ErpResponseJson.ok(erpFunTaskDtoList);
	}
	
	/**
	 * 获取提醒任务详情
	 * @author 熊刚
	 * @since 2017年11月9日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTaskDetailInfo")
	public ResponseJson getTaskDetailInfo(@Valid @RequestBody BaseMapParam param) {
		Integer taskId = param.getInteger("taskId");
		ErpFunTaskDto erpFunTaskDto = erpFunTaskMapper.getErpFunTaskById(getOperator().getCityId(),getOperator().getCompId(),taskId);
		Integer cityId = getOperator().getCityId();
		Integer caseId = erpFunTaskDto.getCaseId();
		Integer caseType = erpFunTaskDto.getCaseType().intValue();
		Byte saleLeaseId =0;
		Integer saleLeaseType =0;
		
		if(erpFunTaskDto.getTaskType().equals(Const.DIC_TASK_TYPE_EXAMIN)
			&& getOperator().getUserId().equals(erpFunTaskDto.getTaskOwner())
			&& erpFunTaskDto.getTaskType().equals(Const.DIC_TASK_TYPE_COMPLAINT)// 投诉提醒
			&& erpFunTaskDto.getTaskType().equals(Const.DIC_TASK_TYPE_COLL_REMIND)// 合作提醒
			&& !erpFunTaskDto.getIsRead()){
				if(!erpFunTaskDto.getTrackWarm()){
					erpFunTaskDto.setTaskStatus(Const.DIC_TASK_STATUS_COMPLETE);
					erpFunTaskDto.setIsRead(true);
				}
				erpFunTaskMapper.updateByPrimaryKeySelective(erpFunTaskDto);
		}else{
			if(Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)){
				ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(cityId,caseId);
				saleLeaseId = erpFunSale.getIsSaleLease();
				saleLeaseType = Const.DIC_CASE_TYPE_LEASE_FUN;
				erpFunTaskDto.setRegId(erpFunSale.getRegId());
				erpFunTaskDto.setAreaId(erpFunSale.getAreaId());
				erpFunTaskDto.setGrId(erpFunSale.getGrId());
			} else if(Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)){
				ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, caseId);
				saleLeaseId = erpFunLease.getSaleLeaseId().byteValue();
				saleLeaseType = Const.DIC_CASE_TYPE_SALE_FUN;
				erpFunTaskDto.setRegId(erpFunLease.getRegId());
				erpFunTaskDto.setAreaId(erpFunLease.getAreaId());
				erpFunTaskDto.setGrId(erpFunLease.getGrId());
			} else if(Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)){
				ErpFunBuyCustomer erpFunBuyCustomer = erpFunBuyCustomerMapper.getFunBuyCustomer(cityId, caseId);
				erpFunTaskDto.setRegId(erpFunBuyCustomer.getRegId());
				erpFunTaskDto.setAreaId(erpFunBuyCustomer.getAreaId());
				erpFunTaskDto.setGrId(erpFunBuyCustomer.getGrId());
			} else if(Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)){
				ErpFunRentCustomer erpFunRentCustomer = erpFunRentCustomerMapper.getRentCustomerByCustId(cityId, caseId);
				erpFunTaskDto.setRegId(erpFunRentCustomer.getRegId());
				erpFunTaskDto.setAreaId(erpFunRentCustomer.getAreaId());
				erpFunTaskDto.setGrId(erpFunRentCustomer.getGrId());
			}
		}
		if(Const.DIC_SYSTEM_USERID_998.equals(erpFunTaskDto.getCreatorUid())){
			erpFunTaskDto.setUserName(Const.DIC_SYSTEM_USERNAME_998);
		} else if (!erpFunTaskDto.getCreatorUid().equals(Const.DIC_SYSTEM_USERID_999)) {
			ErpFunUsers  erpFunUsers = erpFunUsersMapper.getFunUserByUserId(cityId, erpFunTaskDto.getCreatorUid());
			if(erpFunUsers!=null){
				erpFunTaskDto.setUserName(erpFunUsers.getUserName());
			}
		} else{
			erpFunTaskDto.setUserName("系统");
		}	
		Integer trackId = erpFunTaskDto.getTrackId();
		if(trackId!=null){
			ErpFunTrack erpFunTrack = erpFunTrackMapper.getTrackResultById(cityId, trackId);
			if (Const.DIC_TRACK_TYPE_DAIKAN.equals(erpFunTaskDto.getTrackType())) {
				// 查询带看的跟进人
				// 获取带看对象
				List<ErpTrackUsers> erpTrackUsersList= erpTrackUsersMapper.getListByTrackIdAndCompId(cityId, trackId, getOperator().getCompId());
				Map<String,List<String>> deptUsersMap = new HashMap<String,List<String>>();// 构造本条跟进的带看人部门和姓名map
				for(ErpTrackUsers erpTrackUsers : erpTrackUsersList){
					String deptName = erpTrackUsers.getDeptName();
					if(deptUsersMap.get(deptName) == null){
						deptUsersMap.put(deptName, new ArrayList<String>());
					}
					deptUsersMap.get(deptName).add(erpTrackUsers.getUserName());
				}
				this.addTrackDeptsAndUsers(erpFunTaskDto,deptUsersMap);//为trackVO添加trackDepts以及trackUsers
			}else if(Const.DIC_TRACK_TYPE_KEY.equals(erpFunTaskDto.getTrackType())){
				// 1代表有钥匙的跟进,要审核的任务生成一把钥匙.
				// 0代表钥匙已经退还,这个时候不需要再次查询钥匙.
				String keyNum = "";
				if (Const.DIC_TASK_STATUS_NEW.equals(erpFunTaskDto.getTaskStatus())	&& erpFunTrack.getTrackKey()) {// 为1说明钥匙还没有被注销或者退还
					ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, erpFunTaskDto.getCreatorUid());
					// 新生成钥匙编号
					keyNum = erpFunTrack.getKeyNum();
					if(StringUtils.isBlank(keyNum)){
						keyNum = erpFunKeyService.getKeyNum(0, (byte) 0, 1,erpFunUsers.getDeptId(),saleLeaseId.intValue(),saleLeaseType);//以提交钥匙申请人的DEPTID和USERID为主
					}
					if(erpFunTrack.getTargetDept()>0){
						erpFunTaskDto.setKeyDeptId(erpFunTrack.getTargetDept());	
					}else{//默认钥匙的所属门店为任务的创建人
						erpFunTaskDto.setKeyDeptId(erpFunUsers.getDeptId());
					}
				}else if (Const.DIC_TASK_STATUS_NEW.equals(erpFunTaskDto.getTaskStatus()) && !erpFunTrack.getTrackKey()) {// 退换钥匙任务
					// 查询出已有的钥匙编号-一般是作为查看历史审核任务 -- 钥匙借用和归还使用
					ErpFunKey	erpFunKey = erpFunKeyMapper.getKeyModel(cityId,getOperator().getCompId(),erpFunTrack.getCaseType(),erpFunTrack.getCaseId(),saleLeaseType,saleLeaseId);
					if(erpFunKey!=null){
						keyNum = erpFunKey.getKeyNum();
						erpFunTaskDto.setKeyDeptId(erpFunKey.getKeyDeptId());
					}
				}
			}else if(Const.DIC_TRACK_TYPE_KEY_BORROW.equals(erpFunTaskDto.getTrackType())
					||Const.DIC_TRACK_TYPE_KEY_RETURN.equals(erpFunTaskDto.getTrackType())){//借用钥匙和归还钥匙
				if(erpFunTaskDto.getKeyId()>0){
					ErpFunKey erpFunKey = erpFunKeyMapper.getErpFunKeyById(cityId,getOperator().getCompId(),erpFunTaskDto.getKeyId());
					if(erpFunKey ==null ) {
						
					}
					erpFunTaskDto.setKeyDeptId(erpFunKey.getKeyDeptId());
					erpFunTaskDto.setKeyNum(erpFunKey.getKeyNum());
				}
			}
			erpFunTaskDto.setBiddingStatus(0);
			Integer caseUserId = 0;
			// 增加房源是否推广
			if(Const.DIC_CASE_TYPE_SALE_FUN.equals(erpFunTaskDto.getCaseType())) {
				ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, erpFunTaskDto.getCaseId());
				if(erpFunSale!=null){
					caseUserId=erpFunSale.getUserId();
					if(1==erpFunSale.getSendtoYouyou().intValue()){
						// 查询是否有竞价
//						List<FunHouseBiddingPO> resList = funHouseBiddingService.getBiddingListByCaseIds(new Integer[]{Integer.valueOf(taskPo.getCASE_ID())}, getOperator().getCityId(), taskPo.getCASE_TYPE(), Constants_DIC.HOUSE_BIDDING_YY_STATUS_1);
//						if(null != resList && resList.size() > 0) {
//							funTaskVO.setBIDDING_STATUS("1");
//						}
					}
				}
			}else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(erpFunTaskDto.getCaseType())) {
				ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, erpFunTaskDto.getCaseId());
				if(erpFunLease!=null){
					caseUserId=erpFunLease.getUserId();
					if(1==erpFunLease.getSendtoYouyou().intValue()){
						// 查询是否有竞价
//						List<FunHouseBiddingPO> resList = funHouseBiddingService.getBiddingListByCaseIds(new Integer[]{Integer.valueOf(taskPo.getCASE_ID())}, getOperator().getCityId(), taskPo.getCASE_TYPE(), Constants_DIC.HOUSE_BIDDING_YY_STATUS_1);
//						if(null != resList && resList.size() > 0) {
//							funTaskVO.setBIDDING_STATUS("1");
//						}
						
					}
				}
			}
			if(erpFunTrack!=null){
				erpFunTrack.setCaseUserId(caseUserId);
				String proxyUrl =StringUtils.isBlank(erpFunTrack.getProxyUrl()) ? "0" : "1";
				erpFunTrack.setProxyUrl(proxyUrl);
			}
		}
		return ErpResponseJson.ok(erpFunTaskDto);
	}
	/**
	 * 根据指定的长度切取字符串
	 */
	private String formatStr(String source, int width) {
		String result = "";
		if (source != null && !source.equals("")) {
			for (int i = 0, w = 0; i < source.length() && w < width; i++) {
				char charCi = source.charAt(i);
				if (charCi > 255) {
					w += 2;
				} else {
					w++;
				}
				result += charCi;
			}
		} else {
			result = "&nbsp;";
		}
		return result;
	}
	
	/**
	 * 生成带看人和带看门店
	 * @author 
	 * @date 
	 */
	private void addTrackDeptsAndUsers(ErpFunTaskDto erpFunTaskDto, Map<String, List<String>> deptUsersMap) {
		String daikanUsers = "";
		for(String deptName : deptUsersMap.keySet()){
			String userNameTmp = "";
			for(String userName : deptUsersMap.get(deptName)){
				userNameTmp = userNameTmp + userName + ",";
			}
			if(userNameTmp !=null){
				userNameTmp = userNameTmp.substring(0,userNameTmp.length() - 1);
				daikanUsers = deptName + " " + userNameTmp + ";";
			}
		}
		if(daikanUsers!=null){
			daikanUsers = daikanUsers.substring(0,daikanUsers.length() - 1);
		}
		erpFunTaskDto.setTrackUser(daikanUsers);
	}
	
	/**
	 * 获取详细人员的已读未读情况
	 * @param taskId 任务id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTaskWarmUserList")
	public ResponseJson getTaskWarmUserList(@Valid @RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer taskId = param.getInteger("taskId");
		List<Map<String,Object>> taskUserList = erpFunTaskTimedMapper.selectTaskTimedUserInfoListByTaskId (cityId,compId,taskId);
		List<String> archiveIdList = taskUserList.stream().collect(Collectors.mapping(map -> String.valueOf(map.get("archiveId")), Collectors.toList()));
		//查询出对应的AdminFunArchiveDto
		if (null!=archiveIdList && !archiveIdList.isEmpty()) {
			List<AdminFunArchiveDto> adminFunArchiveDtoList = adminFunArchiveMapper.getAdminFunArchiveDtoList(archiveIdList);
			Map<Integer, AdminFunArchiveDto> AdminFunArchiveDtoMap = adminFunArchiveDtoList.stream().collect(Collectors.toMap(AdminFunArchiveDto::getArchiveId, val -> val));
			//拼装头像
			taskUserList.stream().forEach((Map<String,Object> dataMap) -> {
				String archiveId = dataMap.get("archiveId").toString();
				AdminFunArchiveDto adminFunArchive = AdminFunArchiveDtoMap.get(Integer.valueOf(archiveId));
				if (adminFunArchive != null) {
					dataMap.put("userPhoto", CommonUtil.getBbsPhoto(adminFunArchive.getUserPhoto()));
				}
			});
		}
		return ErpResponseJson.ok(taskUserList);
	}
	
}

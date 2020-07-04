package com.myfun.erpWeb.managecenter.sysmanager;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.myfun.repository.erpdb.po.*;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.extension.framework.codis.util.CacheUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.sysmanager.param.MgrVoiceUrlParam;
import com.myfun.erpWeb.managecenter.sysmanager.vo.MgrVoiceUrlVo;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminIpCallLogMapper;
import com.myfun.repository.admindb.dto.AdminIpCallLogDto;
import com.myfun.repository.admindb.po.AdminIpCallLog;
import com.myfun.repository.erpdb.dao.ErpBuildPermissionsMapper;
import com.myfun.repository.erpdb.dao.ErpDicDefinitionsMapper;
import com.myfun.repository.erpdb.dao.ErpFunBuyCustomerMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunRentCustomerMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpSystemSettingLogsMapper;
import com.myfun.repository.erpdb.dto.CheckPartnerConfigDto;
import com.myfun.repository.erpdb.dto.ErpFunDeptsDto;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.admindb.AdminIpCallLogService;
import com.myfun.service.business.erpdb.ErpFunPartnerConfigService;
import com.myfun.utils.BeanUtilsHelper;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.DateUtil;
import com.myfun.utils.NumberHelper;
import com.myfun.utils.StringUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author 方李骥
 * @ClassName: TrackLogController
 * @Description: 跟进日志
 * @date 2016-10-22 下午5:08:30
 */
@RestController
@RequestMapping("/managerCenter/voiceLog")
public class VoiceLogController extends BaseController {
    @Autowired
    AdminIpCallLogService adminIpCallLogService;
    @Autowired
    ErpFunDeptsMapper erpFunDeptsMapper;
    @Autowired
    ErpFunUsersMapper erpFunUsersMapper;
    @Autowired
    AdminIpCallLogMapper adminIpCallLogMapper;
    @Autowired
    ErpFunSaleMapper erpFunSaleMapper;
    @Autowired
    ErpFunLeaseMapper erpFunLeaseMapper;
    @Autowired
    ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
    @Autowired
    ErpFunRentCustomerMapper erpFunRentCustomerMapper;
    @Autowired
    ErpDicDefinitionsMapper erpDicDefinitionsMapper;
    @Autowired
    CacheUtil cacheUtil;
    @Autowired
    ErpSystemSettingLogsMapper erpSystemSettingLogsMapper;
    @Autowired
    private ErpFunPartnerConfigService erpFunPartnerConfigService;
    @Autowired
    private ErpBuildPermissionsMapper erpBuildPermissionsMapper;


    @RequestMapping("/getMgrVoiceNoteLog")
    public ResponseJson getMgrVoiceNoteLog(@Valid @RequestBody BaseMapParam param) throws Exception {
        //如果是美联的需求会走这一段逻辑
        if(getOperator().isMeiLianApi()){
            String record = (String)cacheUtil.get("/erpWeb/managerCenter/voiceLog/getMgrVoiceNoteLog"
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
                erpSystemSettingLogs.setLogContent("查看了语音日志");
                erpSystemSettingLogsMapper.insertSelective(erpSystemSettingLogs);
                cacheUtil.put("/erpWeb/managerCenter/voiceLog/getMgrVoiceNoteLog"
                        + getOperator().getArchiveId()+DateTimeHelper.formatDateTimetoString(new Date(),"yyy-MM-dd"),"1",86400);
            }
        }
        Integer cityId = getOperator().getCityId();
        Integer compId = getOperator().getCompId();
        param.setInteger("cityId", cityId);
        param.setInteger("compId", compId);
        Integer deptId = param.getInteger("deptId");
        Integer areaId = param.getInteger("areaId");
        Integer regId = param.getInteger("regId");
        Integer grId = param.getInteger("grId");
        Integer userId = param.getInteger("userId");

        // 是否是新版组织机构版本 0=否 1=是
        // 为新版组织机构的时候, 前端筛选要传组织机构ID: organizationId
        param.setInteger("newOrganizationType", getOperator().newOrganizationType() ? 1 : 0);

        //通话时长筛选条件处理
        //先以输入的分钟数为条件，若为空则用模板条件
        String timeLowerLimitStr = param.getString("timeLowerLimit");
        String timeUpperLimitStr = param.getString("timeUpperLimit");
        String timeLengthTypeStr = param.getString("timeLengthType");
        Integer timeLowerLimit=null;
        Integer timeUpperLimit=null;
        Integer timeLengthType=null;
        if (StringUtil.isNotBlank(timeLowerLimitStr)) {
            timeLowerLimit=Integer.parseInt(timeLowerLimitStr);
        }
        if (StringUtil.isNotBlank(timeUpperLimitStr)) {
            timeUpperLimit=Integer.parseInt(timeUpperLimitStr);
        }
        if (StringUtil.isNotBlank(timeLengthTypeStr)) {
            timeLengthType=Integer.parseInt(timeLengthTypeStr);
        }
        if (timeLowerLimit != null && timeUpperLimit != null) {
            if (timeLowerLimit >= timeUpperLimit || timeUpperLimit <= 0 || timeLowerLimit < 0) {
                throw new BusinessException("请选择正确的时间区间");
            }
        } else if (timeLowerLimit != null && timeUpperLimit == null) {
            if (timeLowerLimit < 0) {
                throw new BusinessException("请选择正确的时间区间");
            }
        } else if (timeLowerLimit == null && timeUpperLimit != null) {
            if (timeUpperLimit <= 0) {
                throw new BusinessException("请选择正确的时间区间");
            }
        } else {
            if (timeLengthType != null) {
                switch (timeLengthType) {
                    case 1:
                        timeUpperLimit = 1;
                        break;
                    case 2:
                        timeLowerLimit = 1;
                        timeUpperLimit = 5;
                        break;
                    case 3:
                        timeLowerLimit = 5;
                        timeUpperLimit = 10;
                        break;
                    case 4:
                        timeLowerLimit = 10;
                        timeUpperLimit = 30;
                        break;
                    case 5:
                        timeLowerLimit = 30;
                        timeUpperLimit = 60;
                        break;
                    default:
                        timeLowerLimit = 60;
                        break;
                }
            }
        }
        if (timeLowerLimit != null) {
            param.setInteger("timeLowerLimit", timeLowerLimit * 60);
            if(timeLowerLimit==0){
                param.setInteger("timeLowerLimit",1);
            }
        }else{
            param.setInteger("timeLowerLimit",null);
        }
        if (timeUpperLimit != null) {
            param.setInteger("timeUpperLimit", timeUpperLimit * 60);
        }else{
            param.setInteger("timeUpperLimit",null);
        }
        
        String dateFlag = param.getString("dateFlag");
		String time1 = param.getString("time1");
		String time2 = param.getString("time2");
        if(StringUtil.isNotEmpty(dateFlag)){
			Date date = new Date();
			String nowDayStr = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd");
			time2 = nowDayStr;
			if("day".equals(dateFlag)){ // 今日
				time1 = nowDayStr;
			} else if("week".equals(dateFlag)){ // 一周内
				time1 = DateTimeHelper.formatDateTimetoString(DateTimeHelper.addDays(date, -7), "yyyy-MM-dd");
			} else if("month".equals(dateFlag)){ // 一月内
				time1 = DateTimeHelper.formatDateTimetoString(DateTimeHelper.addMonths(date, -1), "yyyy-MM-dd");
			} else if("quarter".equals(dateFlag)){ // 一季内（3个月）
				time1 = DateTimeHelper.formatDateTimetoString(DateTimeHelper.addMonths(date, -3), "yyyy-MM-dd");
			}
		}
		param.setString("time1", DateTimeHelper.getFullTimeStr(time1, true));
        param.setString("time2", DateTimeHelper.getFullTimeStr(time2, false));

        Integer partnerId = getOperator().getPartnerId();
        Integer caseType = param.getInteger("targetType");
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

        List<Integer> deptIds = new ArrayList<>();
        List<Integer> userIds = new ArrayList<>();
        if (grId!=null){
			param.setObject("grId", grId);
			/*ErpFunUsers erpFunUsers = new ErpFunUsers();
			erpFunUsers.setShardCityId(cityId);
			erpFunUsers.setCompId(compId);
			erpFunUsers.setGrId(grId);
			List<ErpFunUsers> erpFunUsersList = erpFunUsersMapper.getRangeUserList(cityId, erpFunUsers);
			if(erpFunUsersList != null && erpFunUsersList.size() > 0){
				userIds = erpFunUsersList.stream().map(ErpFunUsers::getUserId).collect(Collectors.toList());
				param.setObject("userIds",userIds);
			}*/
		} else if (deptId!=null){
			param.setObject("deptId", deptId);
			deptIds.add(deptId);
		} else if (regId!=null){
			param.setObject("regId", regId);
			ErpFunDepts erpFunDepts = new ErpFunDepts();
			erpFunDepts.setCompId(compId);
			erpFunDepts.setRegId(regId);
            // 如果是直营或者是加盟商, 查询出旗下的门店, 再去 IP_CALL_LOG 筛选相应记录
            if (partnerId != null) {
                erpFunDepts.setPartnerId(partnerId);
            }
			erpFunDepts.setShardCityId(cityId);
			List<ErpFunDeptsDto> list = erpFunDeptsMapper.getDeptDtoListByCompId(erpFunDepts);
			deptIds = list.stream().map(ErpFunDeptsDto::getDeptId).collect(Collectors.toList());
		} else if (areaId!=null){
			param.setObject("areaId", areaId);
			ErpFunDepts erpFunDepts = new ErpFunDepts();
			erpFunDepts.setCompId(compId);
			erpFunDepts.setAreaId(areaId);
			// 如果是直营或者是加盟商, 查询出旗下的门店, 再去 IP_CALL_LOG 筛选相应记录
			if (partnerId != null) {
                erpFunDepts.setPartnerId(partnerId);
            }
			erpFunDepts.setShardCityId(cityId);
			List<ErpFunDeptsDto> list = erpFunDeptsMapper.getDeptDtoListByCompId(erpFunDepts);
			deptIds = list.stream().map(ErpFunDeptsDto::getDeptId).collect(Collectors.toList());
		} else if (userId == null) {
            // 查询全公司(总部的不走下面的代码,用compId去查,直营和加盟商按全公司查询的时候查询自己范围内的门店的数据)
            if (partnerId != null) {
                ErpFunDepts erpFunDepts = new ErpFunDepts();
                erpFunDepts.setCompId(compId);
                // 如果是直营或者是加盟商, 查询出旗下的门店, 再去 IP_CALL_LOG 筛选相应记录
                erpFunDepts.setPartnerId(partnerId);
                erpFunDepts.setShardCityId(cityId);
                List<ErpFunDeptsDto> list = erpFunDeptsMapper.getDeptDtoListByCompId(erpFunDepts);
                deptIds = list.stream().map(ErpFunDeptsDto::getDeptId).collect(Collectors.toList());
            }
        }
        param.setObject("deptIds", deptIds);
        if (param.getInteger("userId") != null) {
        	userIds = new ArrayList<>();
            userIds.add(param.getInteger("userId"));
            param.setObject("userIds", userIds);
        }
        if (param.getInteger("pageRows") != null) {
            PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
        }
        
        if(StringUtil.isNotEmpty(param.getString("targetType"))){
			List<Integer> caseTypeList = StringUtil.toIntList(param.getString("targetType"));
			param.setObject("caseTypeList", caseTypeList);
		}
        List<AdminIpCallLog> list = adminIpCallLogMapper.getMgrVoiceNoteLog(param.getMap());

        // detail [2020-3-11] 陈志强 备注: 拨打人组织信息取拨打人上的信息，返回到 callDeptId 字段
        if (CollectionUtils.isNotEmpty(list)) {
            Set<Integer> callUserIds = list.stream().filter(it -> it.getCallUserId() != null).map(AdminIpCallLog::getCallUserId).collect(Collectors.toSet());
            if (CollectionUtils.isNotEmpty(callUserIds)) {
                List<ErpFunUsers> erpFunUsers = erpFunUsersMapper.getUserListByUserIds(cityId, callUserIds);
                for (AdminIpCallLog adminIpCallLog : list) {
                    Integer callUserId = adminIpCallLog.getCallUserId();
                    if (callUserId != null) {
                        Optional<ErpFunUsers> usersOptional = erpFunUsers.stream().filter(it -> callUserId.equals(it.getUserId())).findFirst();
                        usersOptional.ifPresent(erpFunUsers1 -> adminIpCallLog.setCallDeptId(erpFunUsers1.getOrganizationId()));
                    }
                }
            }
        }

        PageInfo<AdminIpCallLog> logInfo = new PageInfo<>(list);
        List<Integer> caseIds = list.stream().map(AdminIpCallLog::getTargetId).distinct().collect(Collectors.toList());

        Map<Integer, ErpFunSale> funSaleMap = null;
        Map<Integer, ErpFunLease> funLeaseMap = null;
        Map<Integer, ErpFunBuyCustomer> funBuyCustomerMap = null;
        Map<Integer, ErpFunRentCustomer> funRentCustomerMap = null;
        if (!caseIds.isEmpty() && null != param.getInteger("targetType")) {
        	List<Integer> caseTypeList = StringUtil.toIntList(param.getString("targetType"));
			if (caseTypeList.contains(Const.DIC_CASE_TYPE_SALE_FUN)) {
				String[] queryColumn = new String[] {
						"SALE_ID", "BUILD_NAME", "SALE_FLOOR", "SALE_FLOORS", "SALE_HALL", "SALE_ROOM",
						"SALE_WEI", "SALE_YANG", "SALE_TOTAL_PRICE", "SALE_USEAGE", "SALE_NO", "SALE_AREA","SALE_STATUS","USER_ID",
						"PLATE_TYPE","SALE_LEVEL","ORGANIZATION_ID","BUILD_ID","SALE_USEAGE"
						};
				List<ErpFunSale> erpFunSaleList = erpFunSaleMapper.selectSaleListByIds(cityId, caseIds.toArray(new Integer[]{}), queryColumn, compId);
				funSaleMap = erpFunSaleList.stream().collect(Collectors.toMap(ErpFunSale :: getSaleId, val -> val, (oldVal, newVal) -> oldVal));
			}
			if (caseTypeList.contains(Const.DIC_CASE_TYPE_LEASE_FUN)) {
				String[] queryColumn = new String[] {
						"LEASE_ID", "LEASE_TOTAL_PRICE", "BUILD_NAME", "LEASE_FLOOR", "LEASE_FLOORS", "LEASE_HALL",
						"LEASE_ROOM", "LEASE_WEI", "LEASE_YANG", "LEASE_USEAGE", "LEASE_NO", "LEASE_AREA", "PRICE_UNIT","LEASE_STATUS","USER_ID",
						"PLATE_TYPE","LEASE_LEVEL","ORGANIZATION_ID","BUILD_ID","LEASE_USEAGE"
					};
				List<ErpFunLease> erpFunLeaseList = erpFunLeaseMapper.selectLeaseListByIds(cityId, caseIds.toArray(new Integer[]{}), queryColumn, compId);
				funLeaseMap = erpFunLeaseList.stream().collect(Collectors.toMap(ErpFunLease :: getLeaseId, val -> val, (oldVal, newVal) -> oldVal));
			}
			if (caseTypeList.contains(Const.DIC_CASE_TYPE_BUY_CUST)) {
				List<ErpFunBuyCustomer> erpFunBuyCustomerList = erpFunBuyCustomerMapper.getFunBuyCustListByCompIdAndCaseIds(cityId, compId, new HashSet<Integer>(caseIds));
				funBuyCustomerMap = erpFunBuyCustomerList.stream().collect(Collectors.toMap(ErpFunBuyCustomer :: getBuyCustId, val -> val, (oldVal, newVal) -> oldVal));
			}
			if (caseTypeList.contains(Const.DIC_CASE_TYPE_RENT_CUST)) {
				List<ErpFunRentCustomer> erpFunRentCustomerList = erpFunRentCustomerMapper.getFunRentCustListByCompIdAndCaseIds(cityId, compId, new HashSet<Integer>(caseIds));
				funRentCustomerMap = erpFunRentCustomerList.stream().collect(Collectors.toMap(ErpFunRentCustomer :: getRentCustId, val -> val, (oldVal, newVal) -> oldVal));
			}
        }

        List<AdminIpCallLogDto> resultList = new ArrayList<AdminIpCallLogDto>();
        for (AdminIpCallLog adminIpCallLog : list) {
            if (adminIpCallLog.getCallRecordUrl() != null) {
                adminIpCallLog.setCallRecordUrl(CommonUtil.getPhotoUrl(adminIpCallLog.getCallRecordUrl()));
            }
            if(StringUtil.isNotEmpty(adminIpCallLog.getCalledPhone())){
				adminIpCallLog.setCalledPhone(adminIpCallLog.getCalledPhone().substring(0, 2) + "*******" + adminIpCallLog.getCalledPhone().substring(9));
			}

            String caseName = null;
            String caseArea = null;
            String casePrice = null;
            Byte room = null;
            AdminIpCallLogDto adminIpCallLogDto = new AdminIpCallLogDto();
            if (null != adminIpCallLog) {
                Byte targetType = adminIpCallLog.getTargetType();
                Integer targetId = adminIpCallLog.getTargetId();
                if (Objects.equals(Byte.valueOf("1"), targetType) && null != funSaleMap) {
                    ErpFunSale erpFunSale = funSaleMap.get(targetId);
                    if (null != erpFunSale) {
                        adminIpCallLogDto.setCaseSourceUserId(erpFunSale.getUserId());
                        caseName = erpFunSale.getBuildName();
                        caseArea = NumberHelper.formatNumber(Optional.ofNullable(erpFunSale.getSaleArea()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2) + "㎡ ";
                        casePrice = NumberHelper.formatNumber(Optional.ofNullable(erpFunSale.getSaleTotalPrice()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2) + "万 ";
                        room = erpFunSale.getSaleRoom();
                        if(adminIpCallLog.getTargetCaseStatus()==null){
                            adminIpCallLog.setTargetCaseStatus(erpFunSale.getSaleStatus());
                        }
                    }
                    adminIpCallLogDto.setHouseLevel(erpFunSale.getSaleLevel());
                    adminIpCallLogDto.setHouseOrganizationId(erpFunSale.getOrganizationId());
                    adminIpCallLogDto.setHousePlateType(erpFunSale.getPlateType());
                    adminIpCallLogDto.setHouseUserId(erpFunSale.getUserId());
                    adminIpCallLogDto.setHouseStatus(erpFunSale.getSaleStatus());
                    adminIpCallLogDto.setHouseBuildId(erpFunSale.getBuildId());
                    adminIpCallLogDto.setHouseUseage(erpFunSale.getSaleUseage());
                } else if (Objects.equals(Byte.valueOf("2"), targetType) && null != funLeaseMap) {
                    ErpFunLease erpFunLease = funLeaseMap.get(targetId);
                    if (null != erpFunLease) {
                        adminIpCallLogDto.setCaseSourceUserId(erpFunLease.getUserId());
                        caseName = erpFunLease.getBuildName();
                        caseArea = NumberHelper.formatNumber(Optional.ofNullable(erpFunLease.getLeaseArea()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2) + "㎡ ";
                        String priceUnitStr = "元/月 ";
                        if (null != erpFunLease.getPriceUnit()) {
                            priceUnitStr = erpDicDefinitionsMapper.getDicCnMsg(cityId, "PRICE_UNIT", String.valueOf(erpFunLease.getPriceUnit()));
                        }
                        casePrice = NumberHelper.formatNumber(Optional.ofNullable(erpFunLease.getLeaseTotalPrice()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2) + priceUnitStr;
                        room = erpFunLease.getLeaseRoom();
                        if(adminIpCallLog.getTargetCaseStatus()==null){
                            if(erpFunLease.getLeaseStatus()!=null){
                                if(erpFunLease.getLeaseStatus()!=null){
                                    adminIpCallLog.setTargetCaseStatus(erpFunLease.getLeaseStatus().byteValue());
                                }
                            }
                        }
                        adminIpCallLogDto.setHouseLevel(erpFunLease.getLeaseLevel());
                        adminIpCallLogDto.setHouseOrganizationId(erpFunLease.getOrganizationId());
                        adminIpCallLogDto.setHousePlateType(erpFunLease.getPlateType());
                        adminIpCallLogDto.setHouseUserId(erpFunLease.getUserId());
                        adminIpCallLogDto.setHouseStatus(erpFunLease.getLeaseStatus().byteValue());
                        adminIpCallLogDto.setHouseBuildId(erpFunLease.getBuildId());
                        adminIpCallLogDto.setHouseUseage(erpFunLease.getLeaseUseage());
                    }
                } else if (Objects.equals(Byte.valueOf("3"), targetType) && null != funBuyCustomerMap) {
                    ErpFunBuyCustomer erpFunBuyCustomer = funBuyCustomerMap.get(targetId);
                    if (null != erpFunBuyCustomer) {
                        adminIpCallLogDto.setCaseSourceUserId(erpFunBuyCustomer.getUserId());
                        caseName = erpFunBuyCustomer.getBuyCustName();
                        Boolean caseSex = erpFunBuyCustomer.getBuyCustSex();
                        caseName = StringUtil.isNotBlank(caseName) ? (caseName.substring(0, 1) + ((null != caseSex && caseSex) ? "先生" : "女士")) : caseName;
                        String caseAreaLow = NumberHelper.formatNumber(Optional.ofNullable(erpFunBuyCustomer.getHouseAreaLow()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2);
                        String caseAreaHigh = NumberHelper.formatNumber(Optional.ofNullable(erpFunBuyCustomer.getHouseAreaHigh()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2);
                        caseArea = (null != caseAreaLow && null != caseAreaHigh) ? caseAreaLow + "-" + caseAreaHigh + "㎡ " : "";
                        String casePriceLow = NumberHelper.formatNumber(Optional.ofNullable(erpFunBuyCustomer.getHousePriceLow()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2);
                        String casePriceHigh = NumberHelper.formatNumber(Optional.ofNullable(erpFunBuyCustomer.getHousePriceHigh()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2);
                        casePrice = (null != casePriceLow && null != casePriceHigh) ? casePriceLow + "-" + casePriceHigh + "万 " : "";
                        room = erpFunBuyCustomer.getHouseRoom();
                        if(adminIpCallLog.getTargetCaseStatus()==null){
                            adminIpCallLog.setTargetCaseStatus(erpFunBuyCustomer.getBuyCustStatus());
                        }
                    }
                } else if (Objects.equals(Byte.valueOf("4"), targetType) && null != funRentCustomerMap) {
                    ErpFunRentCustomer erpFunRentCustomer = funRentCustomerMap.get(targetId);
                    if (null != erpFunRentCustomer) {
                        adminIpCallLogDto.setCaseSourceUserId(erpFunRentCustomer.getUserId());
                        caseName = erpFunRentCustomer.getRentCustName();
                        Boolean caseSex = erpFunRentCustomer.getRentCustSex();
                        caseName = StringUtil.isNotBlank(caseName) ? (caseName.substring(0, 1) + ((null != caseSex && caseSex) ? "先生" : "女士")) : caseName;
                        String caseAreaLow = NumberHelper.formatNumber(Optional.ofNullable(erpFunRentCustomer.getHouseAreaLow()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2);
                        String caseAreaHigh = NumberHelper.formatNumber(Optional.ofNullable(erpFunRentCustomer.getHouseAreaHigh()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2);
                        caseArea = (null != caseAreaLow && null != caseAreaHigh) ? caseAreaLow + "-" + caseAreaHigh + "㎡ " : "";
                        String casePriceLow = NumberHelper.formatNumber(Optional.ofNullable(erpFunRentCustomer.getHousePriceLow()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2);
                        String casePriceHigh = NumberHelper.formatNumber(Optional.ofNullable(erpFunRentCustomer.getHousePriceHigh()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2);
                        casePrice = (null != casePriceLow && null != casePriceHigh) ? casePriceLow + "-" + casePriceHigh + "元 " : "";
                        room = erpFunRentCustomer.getHouseRoom();
                        if(adminIpCallLog.getTargetCaseStatus()==null){
                            adminIpCallLog.setTargetCaseStatus(erpFunRentCustomer.getRentCustStatus());
                        }
                    }
                }
            }
            String caseSummaryInfo = (null != caseName ? " " + caseName + " " : "") + (null != room ? room + "室 " : "") + (null != caseArea ? caseArea : "") + (null != casePrice ? casePrice : "");
//			BeanUtils.copyProperties(adminIpCallLog,adminIpCallLogDto);
            BeanUtilsHelper.copyProperties(adminIpCallLogDto, adminIpCallLog);
            adminIpCallLogDto.setCaseSummaryInfo(caseSummaryInfo);
            // 掌通上分开传两个字段
 			adminIpCallLogDto.setCaseName(caseName);
 			String caseInfo = (null != room ? room + "室 " : "") + (null != caseArea ? caseArea : "") + (null != casePrice ? casePrice : "");
 			adminIpCallLogDto.setCaseInfo(caseInfo);
 			resultList.add(adminIpCallLogDto);
        }
        // 盘源权限
        dealBuildPermissions(resultList);
        PageInfo<AdminIpCallLogDto> dataInfo = new PageInfo<>(resultList);
        dataInfo.setTotal(logInfo.getTotal());
        dataInfo.setPages(logInfo.getPages());
        dataInfo.setPageNum(logInfo.getPageNum());
        return ErpResponseJson.ok(dataInfo);

    }
    
    /**
     * 盘源权限
     * @param list
     */
    private void dealBuildPermissions(List<AdminIpCallLogDto> list) {
    	Operator operator = getOperator();
		if (CollectionUtils.isEmpty(list)) {
			return;
		}
		List<Integer> buildIdList  = new ArrayList<>(list.stream().map(AdminIpCallLogDto::getHouseBuildId).filter(x -> x !=null ).collect(Collectors.toSet()));
		if (buildIdList.size() == 0) {
		    return;
        }
		ErpBuildPermissionsExample erpBuildPermissionsExample = new ErpBuildPermissionsExample();
		erpBuildPermissionsExample.setShardCityId(operator.getCityId());
		erpBuildPermissionsExample.createCriteria().andCompIdEqualTo(operator.getCompId()).andOrganizationIdEqualTo(operator.getOrganizationId())
			.andBuildIdIn(buildIdList).andIsDelEqualTo(Byte.valueOf("0")).andViewPermissionEqualTo(Byte.valueOf("1"));
		List<ErpBuildPermissions> buildPermissionsList = erpBuildPermissionsMapper.selectByExample(erpBuildPermissionsExample);
		Map<Integer, ErpBuildPermissions> buildPermissionsMap = buildPermissionsList.stream().collect(HashMap::new,
				(m,b) -> m.put(b.getBuildId(), b), HashMap::putAll);
		for (AdminIpCallLogDto adminIpCallLogDto : list) {
			Integer buildId = adminIpCallLogDto.getHouseBuildId();
			if (buildId == null) {
				continue;
			}
			String useage = StringUtil.toString(adminIpCallLogDto.getHouseUseage(), "");
			ErpBuildPermissions erpBuildPermissions = buildPermissionsMap.get(buildId);
			if (erpBuildPermissions != null && erpBuildPermissions.getHouseUseage().contains(useage)) {
				adminIpCallLogDto.setViewPermission(1);
			}
		}
	}

    public static void main(String[] args) {
        AdminIpCallLogDto adminIpCallLogDto = new AdminIpCallLogDto();
        AdminIpCallLog adminIpCallLog = new AdminIpCallLog();
        adminIpCallLogDto.setCaseSourceUserId(123);
        try {
            BeanUtilsHelper.copyProperties(adminIpCallLogDto, adminIpCallLog);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(adminIpCallLogDto.getCaseSourceUserId());
    }

    /**
     * @brief 系统监控-获取语音播放地址
     * @detail [2020-3-3] lxt  修改ml生产环境报错的问题
     * @param 未知
     * @return 未知
     * @author 胡坤
     * @note 2018/7/14
     **/
    @ApiOperation("系统监控-获取语音播放地址")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = MgrVoiceUrlVo.class, message = "成功")
    })
    @PostMapping("/getMgrVoiceUrl")
    public ResponseJson getMgrVoiceUrl(@Valid @RequestBody MgrVoiceUrlParam param) {
        MgrVoiceUrlVo voiceUrlVo = new MgrVoiceUrlVo();
        voiceUrlVo.setCallRecordUrl("");
        String voipId = param.getLogId();
        if (StringUtil.isBlank(voipId)) {
            throw new BusinessException("编号不能为空");
        }
        AdminIpCallLog conditionModel = adminIpCallLogMapper.selectByLogId(voipId);
        if (conditionModel == null) {
            return ErpResponseJson.ok(voiceUrlVo);
        }
        if (Const.DIC_VOIP_VOIC_DOWNLOAD != conditionModel.getIsDownloadRecord()) {
            Date endTime = conditionModel.getEndTime();
            if (endTime != null) {
                double time = DateTimeHelper.getMinutesOfTwoDate(new Date(), endTime);
                if (time <= 15) {// 标记为未下载且挂机时间小于15分钟
                    throw new BusinessException("音频生成中，最长15分钟可听取");
                } else {
                    if (null == conditionModel.getCallId()) {
                        return ErpResponseJson.ok(voiceUrlVo);// 大于15分钟直接返回空地址
                    }
                }
            }
        }
        if (conditionModel.getCallRecordUrl() != null) {
            voiceUrlVo.setCallRecordUrl(CommonUtil.getPhotoUrl(conditionModel.getCallRecordUrl()));
        }
        return ErpResponseJson.ok(voiceUrlVo);
    }

    private String encodePhone(String calledPhone) {
        String resultStr = null;
        if (!StringUtil.isBlank(calledPhone)) {
            if (calledPhone.length() > 6) {
                resultStr = calledPhone.substring(0, 3) + "****" + calledPhone.substring(calledPhone.length() - 4, calledPhone.length());
            }
        }
        return resultStr;

    }
}

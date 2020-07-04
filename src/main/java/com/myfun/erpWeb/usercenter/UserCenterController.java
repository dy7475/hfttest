package com.myfun.erpWeb.usercenter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.extension.framework.codis.util.CacheUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.businesstools.builddic.vo.ErpRegisterBuildFloorListVO;
import com.myfun.erpWeb.statisticalAnalysis.param.GetSelectNmaesParam;
import com.myfun.erpWeb.statisticalAnalysis.param.GetSelectWhereParam;
import com.myfun.erpWeb.usercenter.param.*;
import com.myfun.erpWeb.usercenter.vo.*;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.session.RequestSourceConst;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.DefaultResponseJson;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.*;
import com.myfun.repository.admindb.dto.*;
import com.myfun.repository.admindb.po.*;
import com.myfun.repository.agencydb.dao.AgencyAmountHistoryMapper;
import com.myfun.repository.agencydb.dao.AgencyFunCustDealMapper;
import com.myfun.repository.agencydb.dao.AgencyPaFinanceCashauditMapper;
import com.myfun.repository.agencydb.dao.AgencyPaFinanceMapper;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.ErpFunUsersDto;
import com.myfun.repository.erpdb.param.AddOrUpdateIssueInvoiceParam;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunPaidConfig;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpFunUsersExample;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.constant.Const.CacheStructure;
import com.myfun.repository.support.constant.Const.LogInEnum;
import com.myfun.repository.support.mybatis.cache.CacheUtilExt;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.admindb.*;
import com.myfun.service.business.agencydb.AgencyFunCustDealService;
import com.myfun.service.business.erpdb.ErpFunOrganizationService;
import com.myfun.service.business.erpdb.ErpFunPaidConfigService;
import com.myfun.service.business.erpdb.ErpUserOpersService;
import com.myfun.service.jms.TaskQueueThread;
import com.myfun.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.csource.FastdfsManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

@Api(tags = "用户模块")
@RestController
@RequestMapping("/usercenter")
public class UserCenterController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserCenterController.class);

    @Autowired
    private AdminFunIssueInvoiceService adminFunIssueInvoiceService;
    @Autowired
    private AdminFunPaidService adminFunPaidService;
    @Autowired
    private AdminExitCompApplyMapper adminExitCompApplyMapper;
    @Autowired
    private AdminMobileKeyService adminMobileKeyService;
    @Autowired
    private AdminExitCompApplyService adminExitCompApplyService;
    @Autowired
    private ErpFunUsersMapper erpFunUsersMapper;
    @Autowired
    private AdminIpCallLogMapper adminIpCallLogMapper;
    @Autowired
    private AdminSysParaMapper adminSysParaMapper;
    @Autowired
    private AdminFunPaidMapper adminFunPaidMapper;
    @Autowired
    private AdminTruehouseBondRecordMapper adminTruehouseBondRecordMapper;
    @Autowired
    private AdminFunInvoiceEnclosureMapper adminFunInvoiceEnclosureMapper;
    @Autowired
    private AdminDicDefinitionsMapper dicDefinitionsMapper;
    @Autowired
    private AdminYouBorkerArchiveMapper adminYouBorkerArchiveMapper;
    @Autowired
    private AdminFunArchiveMapper adminFunArchiveMapper;
    @Autowired
    private AdminFunRegMapper adminFunRegMapper;
    @Autowired
    private AdminFunUserRqsMapper adminFunUserRqsMapper;
    @Autowired
    private AdminFunArchiveService adminFunArchiveService;
    @Autowired
    private AgencyFunCustDealService agencyFunCustService;
    @Autowired
    private AdminFunUserAccountMapper adminFunUserAccountMapper;
    @Autowired
    private AdminCrmGiftMapper adminCrmGiftMapper;
    @Autowired
    private AdminFunDeptsMapper adminFunDeptsMapper;
    @Autowired
    private AdminFunCompMapper adminFunCompMapper;
    @Autowired
    private AdminCrmFunContractMapper adminCrmFunContractMapper;
    @Autowired
    private AdminCrmTaskService adminCrmTaskService;
    @Autowired
    private AdminWeixinContractMapper adminWeixinContractMapper;
    @Autowired
    private AgencyFunCustDealMapper agencyFunCustDealMapper;
    @Autowired
    private AgencyAmountHistoryMapper agencyAmountHistoryMapper;
    @Autowired
    private AgencyPaFinanceMapper agencyPaFinanceMapper;
    @Autowired
    private AgencyPaFinanceCashauditMapper agencyPaFinanceCashauditMapper;
    @Autowired
    private AdminFunPaidAduitMapper adminFunPaidAduitMapper;
    @Autowired
    private AdminSysParaService adminSysParaService;
    @Autowired
    private AdminFunErpUserGuideService adminFunErpUserGuideService;
    @Autowired
    private ErpFunDeptsMapper erpFunDeptsMapper;
    @Autowired
    AdminMobileKeyMapper adminMobileKeyMapper;
    @Autowired
    AdminMobileKeyLoginMapper adminMobileKeyLoginMapper;
    @Autowired
    ErpFunPaidConfigMapper erpFunPaidConfigMapper;
    @Autowired
    ErpFunPaidConfigService erpFunPaidConfigService;
    @Autowired
    ErpSysParaMapper erpSysParaMapper;
    @Autowired
	private CacheUtil cacheUtil;
    @Autowired
    private AdminCustomLeaguesMapper adminCustomLeaguesMapper;
    @Autowired
	AdminFunUserMessageMapper adminFunUserMessageMapper;
    @Autowired
    ErpFunOrganizationService erpFunOrganizationService;
    @Autowired
    ErpFunOrganizationDefinitionMapper erpFunOrganizationDefinitionMapper;
    @Resource
    private ErpUserOpersService erpUserOpersService;

	/**
	 * 获取发票详情
	 *
	 * @param param
	 * @return
	 * @
	 */
	@ApiOperation("获取发票详情,需求:8214,作者:陈峰")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "", response = GetInvoiceDetailVo.class)})
	@ResponseBody
	@RequestMapping("/getInvoiceDetail")
	public ResponseJson getInvoiceDetail(@Valid @RequestBody ApplyIssueInvoiceParam param) {
		Integer invoiceId = param.getInvoiceId();
		GetInvoiceDetailVo getInvoiceDetailVo = new GetInvoiceDetailVo();
		List<AdminFunIssueInvoiceDto> list = adminFunIssueInvoiceService.getInvoiceDetail(invoiceId);
		getInvoiceDetailVo.setList(list);
		return ErpResponseJson.ok(getInvoiceDetailVo);
	}

	/**
	 * 获取收据详情
	 *
	 * @param param
	 * @return
	 * @
	 */
	@ApiOperation("获取收据详情,需求:8214,作者:陈峰")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "", response = GetInvoiceDetailVo.class)})
	@ResponseBody
	@RequestMapping("/getReceiptDetail")
	public ResponseJson getReceiptDetail(@Valid @RequestBody ApplyIssueInvoiceParam param) {
		Integer invoiceId = param.getInvoiceId();
		GetInvoiceDetailVo getInvoiceDetailVo = new GetInvoiceDetailVo();
		List<AdminFunIssueInvoiceDto> list = adminFunIssueInvoiceService.getInvoiceDetail(invoiceId);
		getInvoiceDetailVo.setList(list);
		return ErpResponseJson.ok(getInvoiceDetailVo);
	}


    /**
     * 个人中心最近交易记录
     *
     * @param param
     * @return
     */
    @ResponseBody
    @RequestMapping("/getPaidList")
    public ResponseJson getPaidList(@Valid @RequestBody GetPaidListParam param) {
        param.setSelfArchiveId(getOperator().getArchiveId());
        param.setSelfUaId(getOperator().getUaId());
        param.setSelfCompUaId(getOperator().getCompUaId());
        param.setSelfUserPosition(getOperator().getUserPosition());
        Integer paidAccount = Optional.ofNullable(param.getPaidAccount()).orElse(0);
        // 非总经理查看公司账户消费记录时直接返回空
        if ("GENERAL_MANAGER".equals(getOperator().getUserPosition()) && 2 == paidAccount) {
            return ErpResponseJson.ok();
        }
        PageInfo<AdminFunPaidVo> paidList = adminFunPaidService.getPaidList(param);
        return ErpResponseJson.ok(paidList);
    }

    /**
     * 现金收支记录列表
     *
     * @param param
     * @return
     * @author 胡坤
     * @since 2018年5月22日
     */
    @ResponseBody
    @RequestMapping("/getIncomePayRecordList")
    public ResponseJson getIncomePayRecordList(@RequestBody UcenterIncomePayRecordParam param) throws Exception {
        Integer balanceType = param.getBalanceType();// 1:新房联动 2：收益金 3:贷款
        param.setCompId(getOperator().getCompId());
        param.setArchiveId(getOperator().getArchiveId());
        param.setUserId(getOperator().getUserId());
        param.setCityId(getOperator().getCityId());
        param.setCompNo(getOperator().getCompNo());
        param.setUaId(getOperator().getUaId());
        param.setCompUaId(getOperator().getCompUaId());

        String timeRange = param.getTimeRange();
        String incomePay = param.getIncomePay();
        Integer accountType = param.getAccountType();
        if (StringUtil.isNotBlank(timeRange)) {
            String[] timeRange1 = DateUtil.getTimeRange(timeRange);
            param.setStartTime(timeRange1[0]);
            param.setEndTime(timeRange1[1]);
        }


        List<Map<String, Object>> resList = new ArrayList<>();
        switch (balanceType) {
            case Const.BALANCE_TYPE_NEW_HOUSE: // 新房
                resList = getBalanceTypeNewHouseList(param, incomePay);
                break;
            case Const.BALANCE_TYPE_PINGAN:// 平安
                resList = getBalanceTypePingan(param, incomePay, accountType);
                break;
            case Const.BALANCE_TYPE_CITY_PLATE: // 城市公盘
                resList = getBalanceTypeCityPlate(param, incomePay);
                break;
            case Const.USER_ACCOUNT_CASH_MONEY://现金
                resList = getUserAccountCashMoney(param, accountType);
                break;
        }
//		for (Map<String, Object> incomePayRecordMap : resList) {
//			incomePayRecordMap.put("balanceType", balanceType);
//		}
        return ErpResponseJson.ok(resList);
    }



	/**
	 * 检查发票的数量
	 *
	 * @return
	 */
	@ApiOperation("检查发票的数量,需求:8214,作者:陈峰")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "", response = AddIssueInvoiceResultVo.class)})
	@ResponseBody
	@RequestMapping("/checkInvoiceCount")
	public ResponseJson checkInvoiceCount() {
		AddIssueInvoiceResultVo addIssueInvoiceResultVo = new AddIssueInvoiceResultVo();
		List<ApplyIssueInvoiceVo> list = adminFunIssueInvoiceService.checkInvoiceCount();
		addIssueInvoiceResultVo.setList(list);
		return ErpResponseJson.ok(addIssueInvoiceResultVo);
	}

	/**
	 * 开具发票
	 *
	 * @param param
	 * @return
	 */
	@ApiOperation("开具发票,需求:8214,作者:陈峰")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "", response = AddIssueInvoiceResultVo.class)})
	@ResponseBody
	@RequestMapping("/addIssueInvoice")
	public ResponseJson addIssueInvoice(@Valid @RequestBody AddOrUpdateIssueInvoiceParam param) {
		param.setUserId(getOperator().getUserId());
		param.setUaid(getOperator().getUaId());
		param.setGeneralManager(getOperator().isGeneralManager());
		param.setDeptNo(getOperator().getDeptNo());
		param.setCompNo(getOperator().getCompNo());
		param.setCityId(getOperator().getCityId());
		param.setArchiveId(getOperator().getArchiveId());
		param.setUserName(getOperator().getUserName());
		AddIssueInvoiceResultVo addIssueInvoiceResultVo = new AddIssueInvoiceResultVo();
		List<ApplyIssueInvoiceVo> list = adminFunIssueInvoiceService.addIssueInvoice(param);
		addIssueInvoiceResultVo.setList(list);
		return ErpResponseJson.ok(addIssueInvoiceResultVo);
	}

	/**
	 * 删除发票附件
	 *
	 * @param param
	 * @return
	 * @
	 */
	@ApiOperation("删除发票附件,需求:8214,作者:陈峰")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")})
	@ResponseBody
	@RequestMapping("/delFunInvoiceEnclosure")
	public ResponseJson delFunInvoiceEnclosure(@RequestBody @Valid DelFunInvoiceEnclosureParam param) {
		adminFunIssueInvoiceService.delIssueInvoice(param);
		return ErpResponseJson.ok();
	}

	/**
	 * 更新发票信息
	 *
	 * @param param
	 * @return
	 * @
	 */
	@ApiOperation("更新发票信息,需求:8214,作者:陈峰")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "", response = AddIssueInvoiceResultVo.class)})
	@ResponseBody
	@RequestMapping("/updateInvoice")
	public ResponseJson updateInvoice(@Valid @RequestBody AddOrUpdateIssueInvoiceParam param) {
		AddIssueInvoiceResultVo addIssueInvoiceResultVo = new AddIssueInvoiceResultVo();
		List<ApplyIssueInvoiceVo> list = adminFunIssueInvoiceService.editIssueInvoice(param);
		addIssueInvoiceResultVo.setList(list);
		return ErpResponseJson.ok(addIssueInvoiceResultVo);
	}

	/**
	 * 申请发票信息
	 *
	 * @param param
	 * @return
	 * @
	 */
	@ApiOperation("申请发票信息,需求:8214,作者:陈峰")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "", response = ApplyIssueInvoiceVo.class)})
	@ResponseBody
	@RequestMapping("/applyIssueInvoice")
	public ResponseJson applyIssueInvoice(@Valid @RequestBody AddOrUpdateIssueInvoiceParam param) {
		ApplyIssueInvoiceVo applyIssueInvoiceVo = adminFunIssueInvoiceService.applyIssueInvoice(param);
		return ErpResponseJson.ok(applyIssueInvoiceVo);
	}

	/**
	 * 查询提交信息
	 *
	 * @param param
	 * @return
	 * @
	 * @author 何传强
	 * @since 2017年8月25日
	 */
	@ResponseBody
	@RequestMapping("/getAuditInfo")
	public ResponseJson getAuditInfo(@Valid @RequestBody BaseMapParam param) {
		Integer userId = getOperator().getUserId();
		Integer compId = getOperator().getCompId();
		Integer cityId = getOperator().getCityId();
		AdminExitCompApply exitCompApply = adminExitCompApplyMapper.getAuditInfo(userId, compId, cityId);
		if (exitCompApply != null) {
			exitCompApply.setEcardAddr(FastdfsManager.getHttpAccessDomain() + exitCompApply.getEcardAddr());
		}
		return ErpResponseJson.ok(exitCompApply);
	}

	/**
	 * 解除绑定
	 *
	 * @param param
	 * @return
	 * @
	 * @author 何传强
	 * @since 2017年8月25日
	 */
	@ResponseBody
	@RequestMapping("/removeBinding")
	public ResponseJson removeBinding(@Valid @RequestBody BaseMapParam param) {
		String smsCode = param.getString("smsCode");
		String mobile = getOperator().getUserMobile();
		String ecardAddr = param.getString("ecardAddr");
		//验证验证码
		boolean isSuccess = adminMobileKeyService.validateSmsCode(smsCode, mobile);
		if (!isSuccess) {
			throw new BusinessException("验证失败");
		}
		AdminExitCompApply exitCompApply = new AdminExitCompApply();
		exitCompApply.setCityId(getOperator().getCityId());
		exitCompApply.setCompId(getOperator().getCompId());
		exitCompApply.setArchiveId(getOperator().getArchiveId());
		exitCompApply.setUserId(getOperator().getUserId());
		exitCompApply.setEcardAddr(ecardAddr);
		exitCompApply.setCreationTime(new Date());
		exitCompApply.setAuditStatus(0);
		adminExitCompApplyService.removeBinding(exitCompApply);
		return ErpResponseJson.ok();
	}
    /**
     * 今天不再提示打卡时间
     *
     * @param param
     * @return
     * @author 臧铁
     * @since 2017年9月7日
     */
    @RequestMapping("/updatePromptTimeByUserId")
    @ResponseBody
    public ResponseJson updatePromptTimeByUserId(@Valid @RequestBody BaseMapParam param) {
        ErpFunUsers erpFunUsers = new ErpFunUsers();
        erpFunUsers.setPromptTime(new Date());//勾选不再提醒后  将该字段设置为当前时间
        erpFunUsers.setShardCityId(getOperator().getCityId());
        erpFunUsers.setUserId(getOperator().getUserId());
        erpFunUsers.setUpdateTime(DateUtil.DateToString(new Date()));
        erpFunUsersMapper.updateByPrimaryKeySelective(erpFunUsers);
        return ErpResponseJson.ok();
    }

    /**
     * 隐号(IP)拨打统计报表
     *
     * @param param dimension:组织机构维度  startTime：开始时间  endTime：结束时间
     *              serchRange：范围  serchRangeId：范围Id
     * @return
     * @author 臧铁
     * @since 2017年9月11日
     */
    @RequestMapping("/getIpCallLogReport")
    @ResponseBody
    public ResponseJson getIpCallLogReport(@Valid @RequestBody BaseMapParam param) {
        ArrayList<Map<String, Object>> resultList = getIpCallLogReportIndex(param);
        ErpResponseJson responseJson = new ErpResponseJson(resultList);
        responseJson.setExtra(param.getString("dimension"));
        return responseJson;
    }

    /**
     * 获取隐号(IP)拨打统计数据
     *
     * @param param
     * @return
     * @author 臧铁
     * @since 2017年9月12日
     */
    private ArrayList<Map<String, Object>> getIpCallLogReportIndex(BaseMapParam param) {
        Operator operator = getOperator();
        Integer cityId = getOperator().getCityId();
        Integer compId = getOperator().getCompId();
        Integer serchRangeId = param.getInteger("serchRangeId");
        Integer organizationId = param.getInteger("organizationId");
        Integer defId = param.getInteger("defId");
        Integer userId = param.getInteger("userId");
        String serchRange = param.getString("serchRange");
        String startTime = param.getString("startTime");
        String endTime = param.getString("endTime");
        String dimension = param.getString("dimension");
        param.setInteger("cityId", cityId);
        param.setInteger("compId", compId);
        Integer archiveId = null;
        if (StringUtil.isNotBlank(startTime)) {
            param.setString("startTime", startTime + " 00:00:00");
        }
        if (StringUtil.isNotBlank(endTime)) {
            param.setString("endTime", endTime + " 23:59:59");
        }
        if ("USER".equals(serchRange)) {// 补数据用
            archiveId = getOperator().getArchiveId();
        }
        List<Map<String, Object>> rangeList = new ArrayList<>();
        //**********************组织架构改版********************************
        if(operator.newOrganizationType()){       //代表查询新组织架构*
            param.setString("dimension","ORGANIZATION");
            if(null != organizationId){//拼装WHERE 条件,如果不是COMP_ID就说明前端传了某个组织的ID，比如传了大区ID，就把这个大区的组织查出来把NAME拿出来拼装成WHERE条件
                GetSelectWhereParam getSelectWhereParam = new GetSelectWhereParam();
                getSelectWhereParam.setCityId(cityId);
                getSelectWhereParam.setUserId(userId);
                getSelectWhereParam.setFileName("CALL_USER_ID");
                getSelectWhereParam.setOrganizationId(organizationId);
                param.setString("serchRange",erpFunOrganizationService.getSelectWhere(getSelectWhereParam));
                if(0 == organizationId){//代表查询全公司
                    param.setInteger("serchRangeId",compId);
                } else {
                    param.setInteger("serchRangeId",organizationId);
                }
            }
            //调用方法拼装查询SQL
            GetSelectNmaesParam selectNmaesParam = new GetSelectNmaesParam();//这里就是拼装查询数据和GROUP BY条件，前端查什么都会传一个defId，根据这个组织拿到他和他上级所有的NAME来GROUP BY
            selectNmaesParam.setCompId(compId);
            selectNmaesParam.setCityId(cityId);
            selectNmaesParam.setDefId(defId);
            selectNmaesParam.setSelectName("CALL_USER_ID");
            String selectNames = erpFunOrganizationService.getSelectNames(selectNmaesParam);
            String dbField = selectNames.substring(selectNames.lastIndexOf(",") + 1,selectNames.length());
            param.setString("serchRange",dbField + " IS NOT NULL AND " + param.getString("serchRange"));
            param.setString("queryDimension", erpFunOrganizationService.getSelectSql(dbField,null,null));//大写带小写别名
            if("-2".equals(defId.toString())){
                param.setString("groupbyDimension", erpFunOrganizationService.getSelectSql(dbField,"0",null));
                String rangeColumn = param.getString("serchRange").replaceAll("AND ","AND A.");
                rangeColumn = rangeColumn.replaceAll("CALL_USER_ID ","USER_ID ");
                rangeList = erpFunUsersMapper.selectByOrg(cityId,compId,rangeColumn,param.getInteger("serchRangeId"));
            } else {
                param.setString("groupbyDimension", erpFunOrganizationService.getSelectSql(selectNames,"0",null));
                rangeList = erpFunOrganizationDefinitionMapper.selectByDefId(cityId,compId,defId);
            }
            param.setString("serchRange",param.getString("serchRange").replaceAll("COMP_ID","CALL_COMP_ID"));
            param.setString("groupbyDimension",param.getString("groupbyDimension").replaceAll("COMP_ID","CALL_COMP_ID"));
            //**********************组织架构改版********************************
        } else {
            // 补数据
            rangeList = erpFunUsersMapper.getRangeListDaTaOfCompAreaToZero(cityId, compId, archiveId, dimension, serchRange, serchRangeId, getOperator().getAreaFlag(), "0", param.getString("userId"));
            param.setString("queryDimension", getRangeQueryStr(dimension));
            param.setString("groupbyDimension", getRangeGroupbyStr(dimension));
            changeSerchRange(param);
        }

        // 根据组织机构维度等条件查出统计列表
        List<Map<String, Object>> adminIpCallLogs = adminIpCallLogMapper.getIpCallLogReport(param.getMap());
        Map<String, Map<String, Object>> listRange = BeanUtil.listMapObjecttoMap(rangeList, "range");
        // 补数据通过RANGE作为key来对应数据
        for (Map<String, Object> dataMap : adminIpCallLogs) {
            Object key = dataMap.get("range");
            if (key != null) {
                String keyStr = key.toString();
                listRange.put(keyStr, dataMap);
            }
        }
        ArrayList<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>(listRange.values());
        // 排序
        resultList.sort((val1, val2) -> {
            return String.valueOf(val1.get("range")).compareTo(String.valueOf(val2.get("range")));
        });
        return resultList;
    }

    /**
     * 处理查询范围
     *
     * @param param
     * @author 臧铁
     * @since 2017年9月11日
     */
    public void changeSerchRange(BaseMapParam param) {
        String serchRange = param.getString("serchRange");
        if ("COMP".equals(serchRange)) {
            param.setString("serchRange", "CALL_COMP_ID");
            param.setInteger("serchRangeId", getOperator().getCompId());// 做兼容  前端可能不传serchRangeId
        } else if ("AREA".equals(serchRange)) {
            param.setString("serchRange", "CALL_AREA_ID");
        } else if ("REG".equals(serchRange)) {
            param.setString("serchRange", "CALL_REG_ID");
        } else if ("DEPT".equals(serchRange)) {
            param.setString("serchRange", "CALL_DEPT_ID");
        } else if ("GROUP".equals(serchRange)) {
            param.setString("serchRange", "CALL_GR_ID");
        } else if ("USER".equals(serchRange)) {
            param.setString("serchRange", "CALL_USER_ID");
        } else {
            param.setString("serchRange", "CALL_COMP_ID");
            param.setInteger("serchRangeId", getOperator().getCompId());
        }
    }

    /**
     * 获取需要查询的组织机构列
     *
     * @param groupby
     * @return
     * @author 臧铁
     * @since 2017年9月11日
     */
    public String getRangeQueryStr(String groupby) {
        String resultStr = "";
        if ("COMP".equals(groupby)) {
            resultStr = "CALL_COMP_ID as compId";
        } else if ("AREA".equals(groupby)) {
            resultStr = "CALL_AREA_ID as areaId,CONCAT(CALL_AREA_ID,'') as range";
        } else if ("REG".equals(groupby)) {
            resultStr = "CALL_AREA_ID as areaId,CALL_REG_ID as regId,CONCAT(CALL_AREA_ID,'_',CALL_REG_ID,'') as range";
        } else if ("DEPT".equals(groupby)) {
            resultStr = "CALL_AREA_ID as areaId,CALL_REG_ID as regId,CALL_DEPT_ID as deptId,"
                    + "CONCAT(CALL_AREA_ID,'_',CALL_REG_ID,'_',CALL_DEPT_ID) as range";
        } else if ("GROUP".equals(groupby)) {
            resultStr = "CALL_AREA_ID as areaId,CALL_REG_ID as regId,CALL_DEPT_ID as deptId,CALL_GR_ID as grId,"
                    + "CONCAT(CALL_AREA_ID,'_',CALL_REG_ID,'_',CALL_DEPT_ID,'_',CALL_GR_ID) as range";
        } else if ("USER".equals(groupby)) {
            resultStr = "CALL_AREA_ID as areaId,CALL_REG_ID as regId,CALL_DEPT_ID as deptId,CALL_GR_ID as grId,CALL_USER_ID as userId,"
                    + "CONCAT(CALL_AREA_ID,'_',CALL_REG_ID,'_',CALL_DEPT_ID,'_',CALL_GR_ID,'_',CALL_USER_ID) as range";
        }
        if (!"1".equals(getOperator().getAreaFlag())) {// 系统参数控制是否显示大区
            resultStr = resultStr.replaceAll("CALL_AREA_ID,'_',", "").replaceAll("CALL_AREA_ID as areaId,", "");
        }
        return resultStr;
    }

    /**
     * 获取需要groupby的组织机构列
     *
     * @param groupby
     * @return
     * @author 臧铁
     * @since 2017年9月14日
     */
    public String getRangeGroupbyStr(String groupby) {
        String resultStr = "";
        if ("COMP".equals(groupby)) {
            resultStr = "CALL_COMP_ID";
        } else if ("AREA".equals(groupby)) {
            resultStr = "CALL_AREA_ID,CONCAT(CALL_AREA_ID,'')";
        } else if ("REG".equals(groupby)) {
            resultStr = "CALL_AREA_ID,CALL_REG_ID,CONCAT(CALL_AREA_ID,'_',CALL_REG_ID,'')";
        } else if ("DEPT".equals(groupby)) {
            resultStr = "CALL_AREA_ID,CALL_REG_ID,CALL_DEPT_ID,"
                    + "CONCAT(CALL_AREA_ID,'_',CALL_REG_ID,'_',CALL_DEPT_ID)";
        } else if ("GROUP".equals(groupby)) {
            resultStr = "CALL_AREA_ID,CALL_REG_ID,CALL_DEPT_ID,CALL_GR_ID,"
                    + "CONCAT(CALL_AREA_ID,'_',CALL_REG_ID,'_',CALL_DEPT_ID,'_',CALL_GR_ID)";
        } else if ("USER".equals(groupby)) {
            resultStr = "CALL_AREA_ID,CALL_REG_ID,CALL_DEPT_ID,CALL_GR_ID,CALL_USER_ID,"
                    + "CONCAT(CALL_AREA_ID,'_',CALL_REG_ID,'_',CALL_DEPT_ID,'_',CALL_GR_ID,'_',CALL_USER_ID)";
        }
        if (!"1".equals(getOperator().getAreaFlag())) {// 系统参数控制是否显示大区
            resultStr = resultStr.replaceAll("CALL_AREA_ID,'_',", "").replaceAll("CALL_AREA_ID,", "");
        }
        return resultStr;
    }

    /**
     * 查询需要开发票的消费记录
     * @param param
     * @return InvoiceNotWritedVo
     * @author 王淳
     * @since 2018-10-25
     */
    @ApiOperation("查询需要开发票的消费记录")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = InvoiceNotWritedDto.class, message = "成功")
    })
    @PostMapping("/getInvoiceNotWritedList")
    @ResponseBody
    public ResponseJson getInvoiceNotWritedList(@RequestBody InvoiceWritedParam param) {
        Operator operator = getOperator();
        param.setArchiveId(operator.getArchiveId());
        param.setCompId(operator.getCompId());
		/*
		 * 根据当前月份判断padiTime时间范围 1、当现在在1-2月时：paidTime的范围是去年的11-01至今
		 * 2、当现在在3-12月时：paidTime的范围是今年的01-01至今 Integer month =
		 * Calendar.getInstance().get(Calendar.MONTH)+1; Integer year =
		 * Calendar.getInstance().get(Calendar.YEAR);
		 * 
		 * if (3 <= month && month <= 12) { canIssueInvoiceDate =
		 * DateTimeHelper.parseToDate(year + "-01-01 00:00:00"); } else {
		 * canIssueInvoiceDate = DateTimeHelper.parseToDate(year - 1 +
		 * "-11-01 00:00:00"); }
		 */

		/*
		 * 开发票时间为改为消费后一年内均可开具发票
		 */
        Date canIssueInvoiceDate = DateTimeHelper.addYears(new Date(), -1);
        String dateData = DateTimeHelper.formatDateTimetoString(canIssueInvoiceDate, "yyyy-MM-dd HH:mm:ss");
        param.setDateData(dateData);
		/*
		 * 判断是否是总经理
		 */
		List<InvoiceNotWritedVo> returnList = new ArrayList<>();
		if (operator.isGeneralManager()) {
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
			returnList = adminFunPaidMapper.getInvoiceNotWritedListForGeneral(operator.getCityId(), param);
		} else {
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
			returnList = adminFunPaidMapper.getInvoiceNotWritedListForUser(operator.getCityId(), param);
		}
		GetInvoiceNotWritedListVo getInvoiceNotWritedListVo = new GetInvoiceNotWritedListVo();
		getInvoiceNotWritedListVo.setList(returnList);
		return ErpResponseJson.ok(getInvoiceNotWritedListVo);
    }

/*    public static void main(String[] args) {
	    Integer month = Calendar.getInstance().get(Calendar.MONTH)+1;
	    Integer year = Calendar.getInstance().get(Calendar.YEAR);
	    Date canIssueInvoiceDate = null;
	    if (3 <= month && month <= 12) {
	        canIssueInvoiceDate = DateTimeHelper.parseToDate(year + "-01-01 00:00:00");
	    } else {
	        canIssueInvoiceDate = DateTimeHelper.parseToDate(year - 1 + "-11-01 00:00:00");
	    }
	    String dateData = DateTimeHelper.formatDateTimetoString(canIssueInvoiceDate, "yyyy-MM-dd HH:mm:ss");
	    System.out.println(dateData);
	    Date date1 =new Date();
	    try {
	        Thread.sleep(50);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    Date date2 = new Date();
	    System.out.println(date1.compareTo(date2));
	}*/

	/**
	 * 查询历史发票的消费记录
	 *
	 * @param param
	 * @return
	 * @author 熊刚
	 * @since 2017年9月30日
	 */
//	@ResponseBody
//	@RequestMapping("/getInvoiceHasWritedList")
//	public ResponseJson getInvoiceHasWritedList(@RequestBody InvoiceWritedParam param) {
//		Operator operator = getOperator();
//		param.setArchiveId(operator.getArchiveId());
//		param.setCompId(operator.getCompId());
//		Integer canIssueInvoiceDay = StringUtil.parseInteger(adminSysParaMapper.selectParamVlue("CAN_ISSUE_INVOICE_DAY"));
//		Date date = DateTimeHelper.addDays(new Date(), 0 - canIssueInvoiceDay);
//		String dateData = DateTimeHelper.formatDateTimetoString(date, "yyyy-MM-dd HH:mm:ss");
//		param.setDateData(dateData);
//		List<AdminFunPaidDto> returnList = new ArrayList<>();
//		if (getOperator().isGeneralManager()) {
//			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
//			returnList = adminFunPaidMapper.getManagerInvoiceHasWritedList(param);
//		} else {
//			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
//			returnList = adminFunPaidMapper.getInvoiceHasWritedList(param);
//		}
//		PageInfo<AdminFunPaidDto> pageInfo = new PageInfo<>(returnList);
//		return ErpResponseJson.ok(pageInfo);
//	}

	/**
	 * 查看附件列表
	 *
	 * @param param
	 * @return
	 * @author 熊刚
	 * @since 2017年10月10日
	 */
	@ApiOperation("查看附件列表,需求:8214,作者:陈峰")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "", response = GetInvoiceEnclosureListVo.class)})
	@ResponseBody
	@RequestMapping("/getInvoiceEnclosureList")
	public ResponseJson getInvoiceEnclosureList(@Valid @RequestBody GetInvoiceEnclosureListParam param) {
		List<AdminFunInvoiceEnclosure> adminFunInvoiceEnclosurelist = adminFunInvoiceEnclosureMapper.getAdminFunInvoiceEnclosurelist(param);
		for (AdminFunInvoiceEnclosure adminFunInvoiceEnclosure : adminFunInvoiceEnclosurelist) {
			adminFunInvoiceEnclosure.setEsPath(CommonUtil.getPhotoUrl(adminFunInvoiceEnclosure.getEsPath()));
		}
		GetInvoiceEnclosureListVo getInvoiceEnclosureListVo = new GetInvoiceEnclosureListVo();
		getInvoiceEnclosureListVo.setList(adminFunInvoiceEnclosurelist);
		return ErpResponseJson.ok(getInvoiceEnclosureListVo);
	}

    /**
     * 修改绑定资金账户
     *
     * @param param
     * @return
     * @author 张宏利
     * @since 2018年4月25日
     */
    @ResponseBody
    @RequestMapping("/updateUserAccount")
    public ResponseJson updateUserAccount(@RequestBody BaseMapParam param) {
        Operator operator = getOperator();
        Integer archiveId = operator.getArchiveId();
        String key = param.getString("key");
        String userMobile = param.getString("userMobile");

        String payUrl = AppConfig.getAdminWebUrl() + "/userAccountBiz/updateUserAccount";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("archiveId", archiveId);
        paramMap.put("userMobile", userMobile);
        paramMap.put("key", key);
        String resultStr = HttpUtil.post(payUrl, paramMap);
		if (resultStr != null) {
			DefaultResponseJson responseJson = JSON.parseObject(resultStr, DefaultResponseJson.class);
			if (responseJson != null) {
				if (Const.ResponseCode.SUCCESS == responseJson.getErrCode()) {
					AdminFunArchive adminFunArchive = adminFunArchiveMapper.getArchiveById(archiveId);
					if (adminFunArchive != null) {
						operator.setUaId(String.valueOf(adminFunArchive.getUaId()));//刷新会话
						cacheUtil.put(CacheStructure.ARCHIVE_ID_OPERATOR + operator.getArchiveId(), operator.getAllAtrtibute(), CacheUtilExt.SESSION_TIME_OUT);
					}
					return ErpResponseJson.ok((adminFunArchive != null) ? adminFunArchive.getUaId() : null);
				}
				if (Const.ResponseCode.OTHER_FAIL != responseJson.getErrCode()
						&& StringUtils.isNotBlank(responseJson.getErrMsg())) {
					return ErpResponseJson.warn(responseJson.getErrMsg());
				}
			}
		}
        return ErpResponseJson.warn("修改失败");
    }

    /**
     * 分享费、查看费消费记录
     *
     * @param param
     * @return
     * @author 胡坤
     * @since 2018年4月10日
     */
    @ResponseBody
    @RequestMapping("/getShareMoneyPaidList")
    public ResponseJson getShareMoneyPaidList(@Valid @RequestBody BaseMapParam param) {
        PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
        List<AdminFunPaid> adminFunPaids = adminFunPaidMapper.getShareMoneyPaidList(getOperator().getArchiveId());

        Map<String, AdminDicDefinitions> definitionsMap = dicDefinitionsMapper.getDicDefMapByDicType("PAID_TYPE");
        if (adminFunPaids.size() > 0) {
            for (AdminFunPaid adminFunPaid : adminFunPaids) {
                AdminDicDefinitions definitions = definitionsMap.get(adminFunPaid.getPaidType());
                if (definitions != null) {
                    adminFunPaid.setPaidType(definitions.getDicCnMsg());
                }
            }
        }
        return ErpResponseJson.ok(adminFunPaids);
    }

    /**
     * 保证金流水记录查询
     *
     * @param param
     * @return
     * @author 张宏利
     * @since 2018年3月19日
     */
    @ResponseBody
    @RequestMapping("/getTrueHousePiadList")
    public ResponseJson getTrueHousePiadList(@Valid @RequestBody BaseMapParam param) {
        Integer archiveId = getOperator().getArchiveId();

        PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
        List<AdminFunPaid> returnList = adminFunPaidMapper.getTrueHousePiadList(archiveId);
        PageInfo<AdminFunPaid> pageInfo = new PageInfo<AdminFunPaid>(returnList);
        return ErpResponseJson.ok(pageInfo);
    }


    /**
     * 保证金可提现列表查询
     *
     * @param param
     * @return
     * @author 张宏利
     * @since 2018年3月19日
     */
    @ResponseBody
    @RequestMapping("/getTrueHouseBondList")
    public ResponseJson getTrueHouseBondList(@Valid @RequestBody BaseMapParam param) {
        Integer archiveId = getOperator().getArchiveId();

        PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
        List<AdminTruehouseBondRecord> returnList = adminTruehouseBondRecordMapper.getTrueHousePiadList(archiveId, 1);
        PageInfo<AdminTruehouseBondRecord> pageInfo = new PageInfo<AdminTruehouseBondRecord>(returnList);
        return ErpResponseJson.ok(pageInfo);
    }

	/**
	 * 查询发票消费详情
	 *
	 * @param param
	 * @return
	 * @author 熊刚
	 * @since 2017年10月11日
	 */
	@ApiOperation("查询发票消费详情,需求:8214,作者:陈峰")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "", response = GetDetailPaidListVo.class)})
	@RequestMapping("/getDetailPaidList")
	@ResponseBody
	@AccessReadonlyDb
	public ResponseJson getDetailPaidList(@Valid @RequestBody ApplyIssueInvoiceParam param) {
		GetDetailPaidListVo getDetailPaidListVo = new GetDetailPaidListVo();
		List<AdminFunPaidDto> adminFunPaidList = adminFunPaidMapper.getDetailPaidList(param.getInvoiceId());
		getDetailPaidListVo.setList(adminFunPaidList);
		return ErpResponseJson.ok(getDetailPaidListVo);
	}
    /**
     * 获取可提现分享费金额
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/4/10
     */
    @ResponseBody
    @RequestMapping("/getYouShareMoney")
    public ResponseJson getYouShareMoney(@Valid @RequestBody BaseMapParam param) {
        AdminYouBorkerArchive adminYouBorkerArchive = adminYouBorkerArchiveMapper.selectByPrimaryKey(getOperator().getArchiveId());
        double money = 0;
        if (adminYouBorkerArchive.getYouAmount() != null) {
            money = adminYouBorkerArchive.getYouAmount().doubleValue();
        }
        if (money <= 0) {
            return ErpResponseJson.ok();
        }
        List<Map<String, String>> list = new LinkedList<Map<String, String>>();
        Map<String, String> map = new HashMap<String, String>();
        int trueCount = 0;
        map.put("totleMoney", String.valueOf(money));
        if (trueCount > 0) {
            money = money - 100;
            map.put("haveTrue", "1");
        }
        if (money >= 0) {
            map.put("canWithdrawalsMoney", String.valueOf(money));
        }
        list.add(map);
        return ErpResponseJson.ok(list);
    }

    /**
     * @author 邓永洪
     * @tag 个人中心更新档案信息
     * @since 2018/4/12
     */
    @ResponseBody
    @RequestMapping("/updatePersonalInfo")
    public ResponseJson updatePersonalInfo(@RequestBody BaseMapParam param) {
        Integer archiveId = getOperator().getArchiveId();
        Integer cityId = getOperator().getCityId();
        if (getOperator().isSwitchCompLogin()) {
        	cityId = getOperator().getSelfCityId();
        }
        String regIds = param.getString("serviceReg");
        String sectionIds = param.getString("serviceZoneIds");
        String serviceZone = param.getString("serviceZone");
        String compName = param.getString("compName");
        AdminFunArchive adminFunArchive = getParamObj(AdminFunArchive.class);
        adminFunArchive.setArchiveId(archiveId);
        if (StringUtils.isNotBlank(serviceZone)) {
            adminFunArchive.setServiceZone(" " + serviceZone.trim() + " ");
            adminFunArchive.setServiceReg(" " + regIds.trim() + " ");
        }
        if (StringUtils.isNotBlank(sectionIds)) {
            adminFunArchive.setServiceZoneIds(" " + sectionIds.trim() + " ");
        }
        if (getOperator().isPersonalVersion() && StringUtil.isNotBlank(compName)) {
            adminFunArchive.setCompName(compName);
        }
        adminFunArchiveService.updatePersonalInfoByUcenter(cityId, adminFunArchive);
        return ErpResponseJson.ok();
    }

    /**
     * 获取个人基本信息
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/4/12
     */
    @ResponseBody
    @RequestMapping("/getPersonalInfo")
    public ResponseJson getPersonalInfo(@Valid @RequestBody BaseMapParam param) {
        Integer archiveId = getOperator().getArchiveId();
        AdminFunArchiveDto adminFunArchive = adminFunArchiveMapper.getDtoByArchiveId(archiveId);
        adminFunArchive.setIcPhoto1(CommonUtil.getBbsPhoto(adminFunArchive.getIcPhoto1()));
        adminFunArchive.setIcPhoto2(CommonUtil.getBbsPhoto(adminFunArchive.getIcPhoto2()));
        adminFunArchive.setUserPhoto(CommonUtil.getBbsPhoto(adminFunArchive.getUserPhoto()));
        adminFunArchive.setUserPhotoMin(CommonUtil.getBbsPhoto(adminFunArchive.getUserPhotoMin()));
        adminFunArchive.setCardPhoto(CommonUtil.getBbsPhoto(adminFunArchive.getCardPhoto()));
        adminFunArchive.setBbsPhoto(CommonUtil.getBbsPhoto(adminFunArchive.getBbsPhoto()));
        adminFunArchive.setShopInnerPhoto(CommonUtil.getBbsPhoto(adminFunArchive.getShopInnerPhoto()));
        adminFunArchive.setShopOuterPhoto(CommonUtil.getBbsPhoto(adminFunArchive.getShopOuterPhoto()));
        // 充值终生VIP时间
        Date freeUserTime = adminFunArchive.getFreeUserTime();
        Byte isFreeUser = Optional.ofNullable(adminFunArchive.getIsFreeUser()).orElse((byte) 0);
        if (freeUserTime != null && isFreeUser == 1// 终身用户
                && !"1".equals(getOperator().getUserRight())) {// 但未实名认证
            // 加上7天为最后实名认证期限，期限一过会去掉他的终生VIP
            Date addDays = DateTimeHelper.addDays(freeUserTime, 7);
            adminFunArchive.setLastFreeUserTime(addDays);
        }
        String serviceRegIds = adminFunArchive.getServiceReg();
        //
        if (StringUtils.isNotBlank(serviceRegIds)) {
        	// 这个值可能有问题，需要try catch serviceRegIds flj 修改 2020-06-09
            try {
				List<Integer> serviceRegIdList = StringUtil.toIntList(serviceRegIds, " ");
				if (serviceRegIdList.size() > 0) {
				    List<AdminFunReg> regList = adminFunRegMapper.getFunRegList(serviceRegIdList);
				    String serviceRegNames = regList.stream().collect(Collectors.mapping(AdminFunReg::getRegName, Collectors.joining(" ")));
				    adminFunArchive.setServiceRegNames(serviceRegNames);
				}
			} catch (Exception e) {
			}
        }
        AdminFunUserRqs adminFunUserRqs = adminFunUserRqsMapper.selectByPrimaryKey(archiveId);
        if (adminFunUserRqs != null) {
            adminFunArchive.setRqsActualStatus(adminFunUserRqs.getRqsActualStatus());
            adminFunArchive.setRqsAptitudeStatus(adminFunUserRqs.getRqsAptitudeStatus());
            adminFunArchive.setRqsActualDesc(adminFunUserRqs.getRqsActualDesc());
            adminFunArchive.setRqsAptitudeDesc(adminFunUserRqs.getRqsAptitudeDesc());
        }
        return ErpResponseJson.ok(adminFunArchive);
    }

    /**
     * IP电话拨打记录
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/4/12
     */
    @ResponseBody
    @RequestMapping("/getUcenterVoiceList")
    public ResponseJson getUcenterVoiceList(@RequestBody UcenterVoiceParam param) {
        String dateRange = param.getDateRange();
        String date = param.getDate();
        Operator operator = getOperator();
        param.setCityId(operator.getCityId());
        param.setCompId(operator.getCompId());
        param.setArchiveId(operator.getArchiveId());
        if (dateRange != null) {
            String[] val = dateRange.split("~");
            // 必须是两个单位
            if (val.length == 2 && val[0] != null && val[1] != null) {
                Date rangeDateStart = DateUtil.StringToDate(val[0]);
                Date rangeDateEnd = DateUtil.StringToDate(val[1] + " 23:59:59");
                param.setRangeDateEnd(rangeDateEnd);
                param.setRangeDateStart(rangeDateStart);
            }
        } else if (date != null) {
            String[] conStr = DateUtil.getConditionDate(date);
            String creationTime1 = conStr[0];
            String creationTime2 = conStr[1];
            if (creationTime1 != null) {
                Date dateStart = DateUtil.StringToDate(creationTime2);
                param.setDateStart(dateStart);
            }
            if (creationTime2 != null) {
                Date dateEnd = DateUtil.StringToDate(creationTime2);
                param.setDateEnd(dateEnd);
            }
        }
        PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
        List<AdminIpCallLog> ipCallLogList = adminIpCallLogMapper.getAdminIpCallLogList(param);
        PageInfo<AdminIpCallLog> pageInfo = new PageInfo<>(ipCallLogList);
        // 隐藏手机号
        if (ipCallLogList != null && ipCallLogList.size() > 0) {
            ipCallLogList.stream().forEach(funVoipLog -> {
                String phone = funVoipLog.getCalledPhone();
                if (StringUtil.isNotEmpty(phone) && phone.length() > 6) {
                    funVoipLog.setCalledPhone(phone.substring(0, 3) + "****" + phone.substring(phone.length() - 4, phone.length()));
                }
            });
        }
        return ErpResponseJson.ok(pageInfo);
    }

    /**
     * 修改密码
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/4/16
     */
    @ResponseBody
    @RequestMapping("/modifyPwd")
    public ResponseJson modifyPwd(@RequestBody BaseMapParam param) {
        String oldLoginPassword = param.getString("oldLoginPassword");
        String loginPassword = param.getString("loginPassword");
        Operator operator = getOperator();
        Integer cityId = getOperator().getCityId();
        if (getOperator().isSwitchCompLogin()) {
        	cityId = getOperator().getSelfCityId();
        }
        Integer userId = getOperator().getUserId();
        Integer archiveId = operator.getArchiveId();

        ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(cityId, userId);
        if (erpFunUsers.getLoginPassword().equals(EnCodeHelper.MD5Encode(oldLoginPassword))) {
            //修改密码
            erpFunUsersMapper.modifyPwd(cityId, EnCodeHelper.MD5Encode(loginPassword), userId);
            //手机端同步的需求101表示修改了密码-2017-03-02yzx说加的
            TaskQueueThread.sendMessageMergeAppRefreshUser(LogInEnum.MODIFY_PWD, erpFunUsers.getArchiveId());
            // 更新operator
            operator.setAttribute("upwd", erpFunUsers.getLoginPassword());
            cacheUtil.put(CacheStructure.ARCHIVE_ID_OPERATOR + archiveId, operator.getAllAtrtibute(), CacheUtilExt.SESSION_TIME_OUT);
        } else {
            return ErpResponseJson.warn("原密码不正确");
        }
        return ErpResponseJson.ok();
    }

    @ApiOperation(value = "有权限的人可以重置【他人】密码")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
    })
    @PostMapping(value = "/modifyPassword")
    @ResponseBody
    public ResponseJson modifyPassword(@RequestBody ModifyPasswordParam param) {
        // 有权限的人，密码统一修改为123456
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        Integer currentUserId = operator.getUserId();

        // 需要修改密码的用户信息
        Integer needModifyUserId = param.getNeedModifyUserId();
        ErpFunUsers needModifyUser = erpFunUsersMapper.getFunUserByUserId(cityId, needModifyUserId);
        if (needModifyUser == null) {
            throw new BusinessException("该用户不存在！");
        }
        Integer needModifyArchiveId = needModifyUser.getArchiveId();
        Integer needModifyUserOrgId = needModifyUser.getOrganizationId();

        boolean hasAuth = erpUserOpersService.checkOperNewOrg(cityId, compId, currentUserId, null, null,
                "MODIFY_PASSWORD", needModifyUserOrgId, false);

        if (!hasAuth) {
            throw new BusinessException("您没有权限修改密码！");
        }

        //修改密码
        erpFunUsersMapper.modifyPwd(cityId, EnCodeHelper.MD5Encode("123456"), needModifyUserId);
        //手机端同步的需求101表示修改了密码-2017-03-02yzx说加的
        TaskQueueThread.sendMessageMergeAppRefreshUser(LogInEnum.MODIFY_PWD, needModifyArchiveId);
        // 更新operator
        operator.setAttribute("upwd", "123456");
    	//更新人员权限，给被更改的人员一个提示,2代表修改权限
        //2020-06-11 flj 修改重置权限之后，将员工强制下线
		try {
			Object loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_ERP + needModifyArchiveId);
			if (loginKey != null) {
				cacheUtil.del(loginKey);
			}
			loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_APP + needModifyArchiveId);
			if (loginKey != null) {
				cacheUtil.del(loginKey);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return ErpResponseJson.ok();
    }

    /**
     * 验证手机号
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/6/8
     */
    @ResponseBody
    @RequestMapping("/isRegister")
    public ResponseJson isRegister(@RequestBody BaseMapParam param) {
    	Map<String, Object> resultMap = new HashMap<>();
        Integer isFlag = param.getInteger("isFlag");
        isFlag = isFlag != null ? isFlag : 0;
        String mobile = param.getString("mobile");
        AdminFunArchive adminFunArchives = adminFunArchiveMapper.getArchiveByMobile(mobile);
        Integer isRegister = 0;
        Map<String, Object> userInfoMap = new HashMap<>();
        Map<String, Object> isRegisterMap = new HashMap<>();
        String returnStr = "NOTEXIST";
        if (adminFunArchives != null) {
            isRegister = 1;
            if (adminFunArchives.getUserEdition() == 2) {
                if (!getOperator().getCityId().equals(adminFunArchives.getCityId().intValue())) {
                    returnStr = "该电话在其他城市已经注册，请联系客服处理！";
                } else {
                    returnStr = "EXIST";
                }
            } else {
                returnStr = "该电话已经注册门店版，请更换号码！";
            }
            if (isFlag == 1) {
                userInfoMap = BeanUtil.objToObjMap(adminFunArchives);
                ErpFunUsers funUsers = erpFunUsersMapper.getFunUserByArchiveId(getOperator().getCityId(), adminFunArchives.getArchiveId());
                if (funUsers != null) {
                    userInfoMap.put("userId", funUsers.getUserId());
                }
                isRegisterMap.putAll(userInfoMap);
            }
        }
        if ("NOTEXIST".equals(returnStr) || "EXIST".equals(returnStr)) {
            isRegisterMap.put("flag", 1);
            isRegisterMap.put("reson", returnStr);
        } else {
            isRegisterMap.put("flag", 0);
            isRegisterMap.put("reson", returnStr);
        }
        isRegisterMap.put("isRegister", isRegister);
        List<Map<String, Object>> list = new ArrayList<>();
        list.add(isRegisterMap);
        resultMap.put("resultList", list);
        return ErpResponseJson.ok(resultMap);
    }


    /**
     * 发送验证接口
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/6/8
     */
    @ResponseBody
    @RequestMapping("/sendValid")
    public ResponseJson sendValid(@RequestBody BaseMapParam param, HttpServletRequest request) {
        String userMobile = param.getString("userMobile");
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();

        String ipAddr = getClientIpAddr(request);
        //验证码类型
        String type = param.getString("type");
        int sendCount = 1;

        // 这里判断是否有定制参数
        String notValidteMsgCodeTime = erpSysParaMapper.getParamValue(cityId, compId, "NOT_VALIDTE_MSG_CODE_TIME");
        if (StringUtils.isNotBlank(notValidteMsgCodeTime)) {
            // 时间未过期
            boolean needValidMsg = DateUtil.StringToDate(notValidteMsgCodeTime).before(new Date());

            if (needValidMsg) {
                //统计发送验证码次数
                Map<String, Object> resultMap = this.sendMsgAndValidateCountMap(ipAddr, type, userMobile);
                sendCount = (Integer) resultMap.get("sendCount");
            }
        } else {
            //统计发送验证码次数
            Map<String, Object> resultMap = this.sendMsgAndValidateCountMap(ipAddr, type, userMobile);
            sendCount = (Integer) resultMap.get("sendCount");
        }

        int canSendFromSamePH = Integer.parseInt(adminSysParaService.getSysParamToString("CANSEND_FROMSAMEPH"));
        if (sendCount > canSendFromSamePH) {
            int num = (canSendFromSamePH - sendCount);
            throw new BusinessException("同一电话最多可以发送" + canSendFromSamePH + "次,还剩 " + (num <= 0 ? 0 : num) + " 次");
        }
        Map<String, Object> sendCountMap = new HashMap<>();
        sendCountMap.put("sendCount", sendCount);
        List<Map<String, Object>> list = new ArrayList<>();
        list.add(sendCountMap);
        return ErpResponseJson.ok(list);
    }

    public Map<String, Object> sendMsgAndValidateCountMap(String ipAddr, String regFrom, String mobile) {
        Map<String, Object> resultMap = new HashMap<>();
        int sendSamePHCount = this.getSendNumSamePH(mobile);
        int canSendFromSamePH = Integer.parseInt(adminSysParaService.getSysParamToString("CANSEND_FROMSAMEPH"));
        if (sendSamePHCount >= canSendFromSamePH) {
            int num = (canSendFromSamePH - sendSamePHCount);
            resultMap.put("flag", 0);// 验证码的次数上限
            resultMap.put("reson", "同一电话最多可以发送" + canSendFromSamePH + "次,还剩 " + (num <= 0 ? 0 : num) + " 次");
            resultMap.put("sendCount", sendSamePHCount);
        } else {
            int sendedcount = this.getSendNumToday(ipAddr);
            int canSendFromSameIP = Integer.parseInt(adminSysParaService.getSysParamToString("CANSEND_FROMSAMEIP"));
            if (sendedcount >= canSendFromSameIP) {
                int num = canSendFromSameIP - sendedcount;
                resultMap.put("flag", 0);
                resultMap.put("reson", "同一IP最多可以发送" + canSendFromSameIP + "次,还剩 " + (num <= 0 ? 0 : num) + " 次");
                resultMap.put("sendCount", sendedcount);
            } else {
            	Operator operator = getOperator();
            	String compNo = "";
            	if (operator != null) {
            		compNo = operator.getCompNo();
            	}
                sendSamePHCount += 1;
                this.createMobileKeyAndSend(ipAddr, regFrom, mobile , compNo);
                resultMap.put("flag", 1);// 验证成功
                resultMap.put("sendCount", sendSamePHCount);
                int num = (canSendFromSamePH - sendSamePHCount);
                resultMap.put("reson", "同一电话最多可以发送" + canSendFromSamePH + "次,还剩 " + (num <= 0 ? 0 : num) + " 次");
            }
        }
        resultMap.put("mobile", mobile);
        return resultMap;
    }

    public int getSendNumToday(String ipAddr) {
        Date[] timeArr = DateTimeHelper.getTodayTime();
        AdminMobileKeyExample example = new AdminMobileKeyExample();
        example.createCriteria().andIpAddrEqualTo(ipAddr)
                .andCreateTimeBetween(timeArr[0], timeArr[1])
                .andKeyNotEqualTo("");
        int mobileKeyCount = adminMobileKeyMapper.countByExample(example);
        return mobileKeyCount;
    }

    public int getSendNumSamePH(String mobile) {
        Date[] timeArr = DateTimeHelper.getTodayTime();
        AdminMobileKeyExample example = new AdminMobileKeyExample();
        example.createCriteria().andMobileEqualTo(mobile)
                .andCreateTimeBetween(timeArr[0], timeArr[1])
                .andKeyNotEqualTo("");
        int mobileKeyCount = adminMobileKeyMapper.countByExample(example);
        return mobileKeyCount;
    }

    /**
     */
    public void createMobileKeyAndSend(String ipAddr, String regFrom, final String mobile, String compNo) {
        int key = new Random().nextInt(999999);
        while (true) {
            if ((key + "").length() == 6) {
                break;
            } else {
                key = new Random().nextInt(999999);
            }
        }
        String keyStr = String.valueOf(key);
        final String content;
        String web = "";
        String smsModel = null;
        boolean isHongji = false;
        AdminCustomLeagues adminCustomLeagues = null; //是否是定制公司
        if (StringUtil.isNotEmpty(compNo)) {
        	AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(compNo);
        	if (adminFunComp != null && Byte.valueOf("1").equals(adminFunComp.getSpecialCustomized())) {
        		AdminCustomLeaguesExample adminCustomLeaguesExample = new AdminCustomLeaguesExample();
        		adminCustomLeaguesExample.createCriteria().andCompNoEqualTo(compNo);
        		List<AdminCustomLeagues> list = adminCustomLeaguesMapper.selectByExample(adminCustomLeaguesExample);
        		if (list.size() > 0) {
        			adminCustomLeagues = list.get(0);
        		}
        	}
        }
        if ("house".equals(regFrom)) {// 网站发布房源
            content = "您本次发布验证码为：" + key + "，以后可通过本手机随时撤销委托，如非本人获取请直接忽略";
        } else if ("mgrhouse".equals(regFrom)) { // 网站管理个人房源
            content = "您本次管理房源的验证码为：" + key + " 输入后确定，即可管理本手机号码关联的相关房源，如非本人获取请直接忽略";
        } else if ("web".equals(regFrom)) { // 网站管理个人房源
            content = "您本次操作验证码为：" + key + "，如非本人获取请直接忽略";
        } else if ("password".equals(regFrom)) {
            content = "您的随机登录密码为：" + key + "，您可以使用该密码登录[好房在线]，如非本人获取请直接忽略";
        } else if ("ent".equals(regFrom)) { // 来自于企业注册
            content = "您申请试用“好房通”的手机校验码为：" + key + "，请完善注册资料，我们将人工为您开通免费试用，如非本人获取请直接忽略";
        } else if ("business".equals(regFrom)) {
            content = "您申请代理的手机校验码为：" + key + "，如非本人获取请直接忽略";
        } else if ("modifyua".equals(regFrom)) {
            smsModel = "DX1509499549507";
            content = "您正在申请变更用户资金账户,验证码：" + key + "，如非本人获取请直接忽略";
            if (adminCustomLeagues != null) {
    			if (adminCustomLeagues.getLeaguesType() == RequestSourceConst.FKD_CUSTOM_LEAGUES) {
    				smsModel = "DX1559298252775";
    			} else if (adminCustomLeagues.getLeaguesType() == RequestSourceConst.YLT_CUSTOM_LEAGUES) {
    				smsModel = "DX1560870000167";
    			} else if (adminCustomLeagues.getLeaguesType() == RequestSourceConst.WYJ_CUSTOM_LEAGUES) {
    				smsModel = "DX15708724221011";
    			}
            }
        } else if ("modifymobile".equals(regFrom)) {
            smsModel = "DX1509499624122";
            if (adminCustomLeagues != null) {
    			if (adminCustomLeagues.getLeaguesType() == RequestSourceConst.FKD_CUSTOM_LEAGUES) {
    				smsModel = "DX1559298211289";
    			} else if (adminCustomLeagues.getLeaguesType() == RequestSourceConst.YLT_CUSTOM_LEAGUES) {
    				smsModel = "DX1560870000166";
    			} else if (adminCustomLeagues.getLeaguesType() == RequestSourceConst.WYJ_CUSTOM_LEAGUES) {
    				smsModel = "DX15708724221010";
    			}
            }
            content = "您正在申请绑定手机号码,验证码：" + key + "，如非本人获取请直接忽略";
        } else if ("unbinddept".equals(regFrom)) {
            content = "您正在申请脱离门店,验证码：" + key + "，如非本人获取请直接忽略";
        } else if ("registerAcc".equals(regFrom)) {
            smsModel = "DX1509499624122";
            if (adminCustomLeagues != null) {
    			if (adminCustomLeagues.getLeaguesType() == RequestSourceConst.FKD_CUSTOM_LEAGUES) {
    				smsModel = "DX1559298211289";
    			} else if (adminCustomLeagues.getLeaguesType() == RequestSourceConst.YLT_CUSTOM_LEAGUES) {
    				smsModel = "DX1560870000166";
    			} else if (adminCustomLeagues.getLeaguesType() == RequestSourceConst.WYJ_CUSTOM_LEAGUES) {
    				smsModel = "DX15708724221010";
    			}
            }
            content = "您注册 “门店版”的账号验证码为：" + key + "，完成后同时为您开通“精英版”，账号为手机号码，密码一致";
        } else if ("youjiaDept".equals(regFrom)) {
            content = "您正在设置门店电话，本次验证码为：" + key + "，如非本人获取请直接忽略";
        } else if ("withdrawalsYouShareMoney".equals(regFrom)) {
            content = "您正在申请提现，校验码：" + key + "，请勿泄露！";
        } else if ("exitComp".equals(regFrom)) {// 自定义内容，非特殊情况不要使用
            content = "您正在申请退出当前公司，校验码：" + key + "，如非本人获取请直接忽略";
        } else {
            smsModel = "DX1509499624122";
            if (adminCustomLeagues != null) {
    			if (adminCustomLeagues.getLeaguesType() == RequestSourceConst.FKD_CUSTOM_LEAGUES) {
    				smsModel = "DX1559298211289";
    			} else if (adminCustomLeagues.getLeaguesType() == RequestSourceConst.YLT_CUSTOM_LEAGUES) {
    				smsModel = "DX1560870000166";
    			} else if (adminCustomLeagues.getLeaguesType() == RequestSourceConst.WYJ_CUSTOM_LEAGUES) {
    				smsModel = "DX15708724221010";
    			}
            }
            content = "您本次注册账号的验证码为：" + key + "，填写完资料后自动开通，账号为手机号码 ，如非本人获取请直接忽略";
        }
        try {
            if (smsModel != null) {
                Map<String, Object> paramMap = new HashMap<>();
                paramMap.put("phone", mobile);
                paramMap.put("key", smsModel);
                paramMap.put("reqProject", "3");
                Map<String, String> jsonMap = new HashMap<>();
                jsonMap.put("mobileKey", String.valueOf(key));
                paramMap.put("paramJson", jsonMap);
                String s = HttpUtil.postJson(AppConfig.getPushWebDomain() + "systemApi/mobileMsg/send", paramMap);
                System.out.println(s);
            } else {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // 获取短信发送地址
                            String sendMess = AppConfig.getSendMsgPath();
                            String contentEncode = null;
                            try {
                                contentEncode = URLEncoder.encode(URLEncoder.encode(content, "UTF-8"), "UTF-8");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            Map<String, Object> param = new HashMap<String, Object>();
                            param.put("action", "sendSms");
                            param.put("phone", mobile);
                            param.put("content", contentEncode);
                            String result = HttpUtil.post(sendMess, param);
                            LOGGER.error("sms send info==url:{} result:{}", sendMess, result);
                            if (StringUtils.isBlank(result) || result.indexOf("response>1</response") == -1) {
                                LOGGER.error("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$短信发送失败\r\n" + result);
                                LOGGER.error("RRRRR_SMS_URL : " + sendMess);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        AdminMobileKey record = new AdminMobileKey();
        record.setMobile(mobile);
        record.setKey(keyStr);
        record.setIpAddr(ipAddr);
        record.setContent(content);
        if (!"".endsWith(web)) {
            record.setWeb(Integer.parseInt(web));
        }
        // 把验证码写入数据库中
        if (isHongji) {// 鸿基登录发送验证码存另一张表
            AdminMobileKeyLogin record2 = new AdminMobileKeyLogin();
            record2.setMobile(mobile);
            record2.setKey(keyStr);
            record2.setIpAddr(ipAddr);
            record2.setContent(content);
            record2.setWeb(Integer.parseInt(web));
            adminMobileKeyLoginMapper.insertSelective(record2);
        } else {
            adminMobileKeyMapper.insertSelective(record);
        }
    }

    /**
     * 更换手机号
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/6/8
     */
    @ResponseBody
    @RequestMapping("/changeMobile")
    public ResponseJson changeMobile(@RequestBody BaseMapParam param) {
        String mobile = param.getString("userMobile");
        List<AdminFunArchive> adminFunArchives = adminFunArchiveMapper.getValidMobileIsRegist(mobile);
        if (adminFunArchives.size() > 0) {
            throw new BusinessException("该手机号码已注册");
        }
        return ErpResponseJson.ok();
    }

    /**
     * 获取资金账户信息
     *
     * @param param
     * @return
     * @author 张宏利
     * @since 2018年5月21日
     */
    @ResponseBody
    @RequestMapping("/getAllUaInfo")
    public ResponseJson getAllUaInfo(@Valid @RequestBody BaseMapParam param) {
        Operator operator = getOperator();
        String adminDeptNo = param.getString("adminDeptNo");

        AllUaInfoDto allUaInfo = new AllUaInfoDto();
        // 新房佣金，分可提现的和可提现加冻结的
        GeneralParam generalParam = new GeneralParam(operator);
        if (operator.isSwitchCompLogin()) {
        	generalParam.setCityId(operator.getSelfCityId());
        	generalParam.setCompId(operator.getSelfCompId());
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        BigDecimal[] personAmount = agencyFunCustService.getFunCustDealData(generalParam, 1); // 个人
        // 获取个人资金信息
        AdminFunUserAccount userAccount = adminFunUserAccountMapper.selectByPrimaryKey(operator.getUaId());
        if (userAccount != null) {
            allUaInfo.setPerAmount(userAccount.getHaofangAmount());
            allUaInfo.setUaUserMobile(userAccount.getUserMobile());
            allUaInfo.setPerAmountCoin(userAccount.getHaofangBuy());
            allUaInfo.setTrueHouseDeposit(userAccount.getTrueHouseDeposit());
            allUaInfo.setPerAmountPrice(NumberHelper.sub(userAccount.getHaofangAmount().doubleValue(), userAccount.getHaofangBuy().doubleValue()));
            allUaInfo.setPerExtractAmount(personAmount[0]);
            allUaInfo.setPerExtractAmountAll(personAmount[1]);
            allUaInfo.setPerCashMoney(userAccount.getCashMoney());
            allUaInfo.setPerShareMoney(userAccount.getShareMoney());
            allUaInfo.setPerShareMoneyTotal(userAccount.getShareMoney());
           /* Date lastShareMoney = userAccount.getLastShareMoney();
            BigDecimal curMonthShareMoney = userAccount.getCurMonthShareMoney();
            allUaInfo.setPerShareMoney(userAccount.getShareMoney());
            if (null != lastShareMoney) {
                if (lastShareMoney.after(calendar.getTime())) {
                    BigDecimal shareMoney = userAccount.getShareMoney().subtract(curMonthShareMoney);
                    allUaInfo.setPerShareMoney(shareMoney);
                }
            }*/
        }
        // 计算个人培训券 CRM_GIFT
        Integer sumQuan = adminCrmGiftMapper.getSumTrainQuan(operator.getArchiveId());
        allUaInfo.setPerQuanCount(sumQuan == null ? 0 : sumQuan);
        //获取you+积分信息
        AdminYouBorkerArchive youBorkerArchive = adminYouBorkerArchiveMapper.getDataByArchiveId(operator.getArchiveId());
        if (youBorkerArchive != null) {
            allUaInfo.setYouAmount(youBorkerArchive.getYouAmount());
        }
        //获取门店O2O情况
        AdminFunArchive funArchive = adminFunArchiveMapper.selectByPrimaryKey(operator.getArchiveId());
        if (funArchive.getUserEdition() == 2) {
            allUaInfo.setSuperEnd(funArchive.getSuperEnd());
        } else {
            BigDecimal[] compAmount = agencyFunCustService.getFunCustDealData(generalParam, 2);
            if (StringUtils.isBlank(adminDeptNo)) {
                adminDeptNo = operator.getDeptNo();
            }
            AdminFunDepts funDepts = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(operator.getCompNo(), adminDeptNo);
            AdminFunComp funComp = adminFunCompMapper.selectByCompId(operator.getAdminCompId());
            Integer compUaId = funComp.getUaId();
            if (compUaId != null) {
                // 获取公司资金信息
                AdminFunUserAccount funUserAccount = adminFunUserAccountMapper.selectByPrimaryKey(compUaId);
                if (funUserAccount != null) {
                    allUaInfo.setCompAcount(funUserAccount.getHaofangAmount());
                    allUaInfo.setCompAmountCoin(funUserAccount.getHaofangBuy());
                    allUaInfo.setCompAmountPrice(NumberHelper.sub(funUserAccount.getHaofangAmount().doubleValue(), funUserAccount.getHaofangBuy().doubleValue()));
                    allUaInfo.setCompExtractAmount(compAmount[0]);
                    allUaInfo.setCompExtractAmountAll(compAmount[1]);
                    allUaInfo.setCompCashMoney(funUserAccount.getCashMoney());
                    allUaInfo.setCompShareMoneyTotal(funUserAccount.getShareMoney());
                    allUaInfo.setCompShareMoney(funUserAccount.getShareMoney());
                   /* Date lastShareMoney = funUserAccount.getLastShareMoney();
                    BigDecimal curMonthShareMoney = funUserAccount.getCurMonthShareMoney();
                    allUaInfo.setCompShareMoney(funUserAccount.getShareMoney());
                    if (null != lastShareMoney) {

                        if (lastShareMoney.after(calendar.getTime())) {
                            BigDecimal shareMoney = funUserAccount.getShareMoney().subtract(curMonthShareMoney);
                            allUaInfo.setCompShareMoney(shareMoney);
                        }
                    }*/
                }
                allUaInfo.setCompUaId(compUaId);
                allUaInfo.setOtoEnd(funDepts.getOtoEnd());
                allUaInfo.setSpaceEnd(funDepts.getSpaceEnd());
                allUaInfo.setSuperEnd(funDepts.getSuperEnd());
                allUaInfo.setContractId(funDepts.getContractId());
                allUaInfo.setTryEnd(funDepts.getTryEnd());
                allUaInfo.setStopTime(funDepts.getStopTime());
                allUaInfo.setCompPayStatus(funComp.getCompPayStatus());

                // 会员等级，0=普通会员{default=0 ;1=黄金会员 2=超级房源库}
                allUaInfo.setCustLevel(funDepts.getCustLevel());
                // CUST_LEVEL=2时，这个代表超级房源库到期时间
                allUaInfo.setCustEndTime(funDepts.getCustEndTime());
                // 软件款支付方式，1：一次性,3=签约，4=定金支付，5=租用年付
                allUaInfo.setPayType(funDepts.getPayType());
                // 小程序版本 1=普通版 2=Pro版
                allUaInfo.setMicroProgramVersion(funComp.getMicroProgramVersion());
                // 小程序开通状态 0:未开通,1资料已提交，2，已开通
                allUaInfo.setMicroProgramStatus(funComp.getMicroProgramStatus());
                // 微店购买方式 1=一次性；2=年付
                allUaInfo.setWxPayType(funComp.getWxPayType());
                // 微店到期时间
                allUaInfo.setWxEndTime(funComp.getWxEndTime());
                // 微店付款状态 1=已支付 ；0=未支付
                allUaInfo.setCompPayStatus(funComp.getCompPayStatus());
            }
        }
        SoftContractDto softContract = adminCrmFunContractMapper.getSoftContract(operator.getAdminDeptId());
        if (softContract != null) {
            allUaInfo.setWeiContractNo(softContract.getWeiContractNo());
            allUaInfo.setContractStatus(softContract.getContractStatus());
            allUaInfo.setWeiContractId(softContract.getWeiContractId());
            if (softContract.getWeiContractId() != null && softContract.getWeiContractId() != 0) {
                AdminWeixinContract weixinContract = adminWeixinContractMapper.getRecordByWeiDeptId(operator.getAdminDeptId());
                if (weixinContract != null) {
                    String weiContractHtml = weixinContract.getWeiContractHtml();
                    if (StringUtils.isNotBlank(weiContractHtml)) {
                        if (weiContractHtml.startsWith("/") || weiContractHtml.startsWith("\\")) {
                            weiContractHtml = weiContractHtml.substring(1, weiContractHtml.length());
                        }
                        allUaInfo.setWeiContractHtml((AppConfig.getPicDomainUrl() + weiContractHtml).replaceAll("\\\\", "/"));
                    }
                }
            }
        }
        //统计应支付款项
        Integer payNum = adminFunDeptsMapper.getPayNum(operator.getAdminCompId());
        allUaInfo.setPayNum(payNum);
        // 总经理返回经纪人账号数
        if (operator.isGeneralManager()) {
            List<String> roleIds = Arrays.asList("SYSTEM_MANAGE", "GENERAL_MANAGER", "COMMON_ADMIN");
            allUaInfo.setTotalUserNumber(erpFunUsersMapper.getAgentOnlineCount(operator.getCityId(), operator.getCompId(), roleIds));
        }
        allUaInfo.setPlusEndTime(funArchive.getSuperEnd());
        return ErpResponseJson.ok(allUaInfo);
    }

    /**
     * 新房收支记录
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/5/23
     */
    private List<Map<String, Object>> getBalanceTypeNewHouseList(UcenterIncomePayRecordParam param, String incomePay) {
        List<Map<String, Object>> resList = new ArrayList<>();

        if ("INCOME".equalsIgnoreCase(incomePay)) { // 收入记录
            PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
            resList = agencyFunCustDealMapper.getFunCustDealList(param);
            Map<Integer, Map<String, Object>> resMap = resList.stream().collect(Collectors.toMap(val -> StringUtil.parseInteger(val.get("archiveId")), val -> val));
            List<Integer> archiveIds = new ArrayList<>();
            for (Map.Entry<Integer, Map<String, Object>> entry : resMap.entrySet()) {
                Map<String, Object> funCustDealMap = entry.getValue();
                funCustDealMap.put("des", "客户" + funCustDealMap.get("custName") + "的新房佣金收入");
                funCustDealMap.put("accountType", param.getAccountType());
                funCustDealMap.put("incomePay", "INCOME");
                // 状态*
                Integer archiveId = (Integer) funCustDealMap.get("archiveId");
                archiveIds.add(archiveId);
            }
            if (archiveIds.size() > 0) {
                List<AdminFunArchive> archiveList = adminFunArchiveMapper.getListByArchiveIds(archiveIds);
                for (AdminFunArchive funArchivePO : archiveList) {
                    Map<String, Object> funCustDealMap = resMap.get(funArchivePO.getArchiveId());
                    funCustDealMap.put("borkerName", funArchivePO.getUserName());
                }
            }
            return resList;
        } else { // 提现记录
            PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
            resList = agencyAmountHistoryMapper.getAmountHistoryList(param);
            return resList;
        }
    }

    /**
     * 平安收支记录
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/5/23
     */
    private List<Map<String, Object>> getBalanceTypePingan(UcenterIncomePayRecordParam param, String incomePay, Integer accountType) {
        List<Map<String, Object>> resList = new ArrayList<>();
        if ("INCOME".equalsIgnoreCase(incomePay)) { // 收入记录
            PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
            resList = agencyPaFinanceMapper.getFinanceList(param);
            Map<Integer, Map<String, Object>> resMap = resList.stream().collect(Collectors.toMap(val -> StringUtil.parseInteger(val.get("archiveId")), val -> val));
            List<Integer> archiveIds = new ArrayList<>();
            for (Map.Entry<Integer, Map<String, Object>> entry : resMap.entrySet()) {
                archiveIds.add(entry.getKey());
                Map<String, Object> paFinanceMap = entry.getValue();
                paFinanceMap.put("incomePay", "INCOME");//DECIMAL
                Integer accountType2 = (Integer) Optional.ofNullable(paFinanceMap.get("accountType")).orElse(null);
                if (accountType2 == 1) {
                    paFinanceMap.put("amount", paFinanceMap.get("rakebackPrice"));
                    paFinanceMap.put("isExtract", paFinanceMap.get("isCash"));
					/*if (isCash == 1) {
						paFinanceMap.put("isExtract", 3);
					}
					if (isCash == 0) {
						paFinanceMap.put("isExtract", 0);
					}
					if (isCash == 2) {
						paFinanceMap.put("isExtract", 2);
					}*/
                } else {
                    paFinanceMap.put("amount", paFinanceMap.get("compRakebackPrice"));
                    paFinanceMap.put("isExtract", paFinanceMap.get("compIsCash"));
					/*if (compIsCash == 1) {
						paFinanceMap.put("isExtract", 3);
					}
					if (compIsCash == 0) {
						paFinanceMap.put("isExtract", 0);
					}
					if (compIsCash == 2) {
						paFinanceMap.put("isExtract", 2);
					}*/
                }
                paFinanceMap.put("des", "客户" + paFinanceMap.get("custName") + "的贷款佣金收入");
            }
            if (archiveIds.size() > 0) {
                List<ErpFunUsers> list = erpFunUsersMapper.getFunUsersBydept(getOperator().getCityId(), archiveIds);
                if (list.size() > 0) {
                    for (ErpFunUsers funUsersPO : list) {
                        Map<String, Object> map = resMap.get(funUsersPO.getArchiveId());
                        map.put("borketName", funUsersPO.getUserName());
                    }
                }
            }
            return resList;
        } else {
            if (accountType == 1) {
                param.setTimeString("CREATION_TIME");
                PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
                resList = agencyPaFinanceCashauditMapper.getFinanceAduitList(param);
            } else {
                param.setTimeString("pc.CREATION_TIME");
                PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
                resList = agencyPaFinanceCashauditMapper.getFinanceAduitList2(param);
            }
            Map<Integer, Map<String, Object>> resMap = resList.stream().collect(Collectors.toMap(val -> StringUtil.parseInteger(val.get("cashId")), val -> val));
            for (Map.Entry<Integer, Map<String, Object>> entry : resMap.entrySet()) {
                Map<String, Object> paFinanceMap = entry.getValue();
                paFinanceMap.put("payStatus", paFinanceMap.get("auditStatus"));
				/*if (3==auditStatus) {
					paFinanceMap.put("payStatus", 1);
				}
				if (1==auditStatus) {
					paFinanceMap.put("payStatus", 2);
				}
				if (0==auditStatus) {
					paFinanceMap.put("payStatus", 0);
				}*/
            }
            return resList;

        }
    }

    /**
     * 城市公盘收支记录
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/5/23
     */
    private List<Map<String, Object>> getBalanceTypeCityPlate(UcenterIncomePayRecordParam param, String incomePay) {
        List<Map<String, Object>> resList = new ArrayList<>();
        if ("INCOME".equalsIgnoreCase(incomePay)) { // 收入记录
            resList = adminFunPaidMapper.getFunPaidRecordList(param);
            Map<Integer, Map<String, Object>> resMap = resList.stream().collect(Collectors.toMap(val -> StringUtil.parseInteger(val.get("cdId")), val -> val));
            for (Map.Entry<Integer, Map<String, Object>> entry : resMap.entrySet()) {
                Map<String, Object> paFinanceMap = entry.getValue();
                paFinanceMap.put("incomePay", "INCOME");
            }
        } else { // 支出，只有提现
            resList = adminFunPaidAduitMapper.getAduitRecordList(param);
            Map<Integer, Map<String, Object>> resMap = resList.stream().collect(Collectors.toMap(val -> StringUtil.parseInteger(val.get("aduitId")), val -> val));
            for (Map.Entry<Integer, Map<String, Object>> entry : resMap.entrySet()) {
                Map<String, Object> funPaidAduitMap = entry.getValue();
                Integer uaType = (Integer) Optional.ofNullable(funPaidAduitMap.get("uaType")).orElse(null);
                Integer payStatus = (Integer) Optional.ofNullable(funPaidAduitMap.get("payStatus")).orElse(null);
                funPaidAduitMap.put("compFlag", 1);
                if (uaType == 1) {
                    funPaidAduitMap.put("compFlag", 0);
                }
                funPaidAduitMap.put("payStatus", payStatus);
				/*if (payStatus == 3) {
					funPaidAduitMap.put("payStatus", 0); //审核中
				} else if (payStatus == 2) {
					funPaidAduitMap.put("payStatus", 1); // 已到账
				} else if (payStatus == 1) {
					funPaidAduitMap.put("payStatus", 2); // 转账中
				}*/
            }
        }
        return resList;
    }

    /**
     * 现金收支记录
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/5/23
     */
    private List<Map<String, Object>> getUserAccountCashMoney(UcenterIncomePayRecordParam param, Integer accountType) {
        List<Map<String, Object>> resList = new ArrayList<>();
        Integer uaId = null;
        if (accountType == 1) {
            uaId = getOperator().getUaId();
        } else {
            uaId = getOperator().getCompUaId();
        }
        if (uaId != null) {
            param.setUaId(uaId);
            PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
            resList = adminFunPaidMapper.getCashMoneyRecord(param);
            if (resList != null && resList.size() > 0) {
                resList.stream().map(map -> map.put("accountType", accountType));
            }
        }
        return resList;
    }

    /**
     * @tag 修改注册手机号
     * @author 邓永洪
     * @since 2018/6/8
     */
    @ResponseBody
    @RequestMapping("/registerMobileVerify")
    public ResponseJson registerMobileVerify(@Valid @RequestBody BaseMapParam param) {
        Operator operator = getOperator();
        String mobile = param.getString("userMobile");
        String key = param.getString("key");
        isRegister(mobile);
        boolean isValid = false;
        if (StringUtils.isNotBlank(key)) {//检测电话号码是否通过
            isValid = adminMobileKeyService.validateSmsCode(key, mobile);
        } else {//如果没有输入验证码 检测是否打过电话认证
            isValid = adminMobileKeyService.checkMobileDialToday(mobile);
        }
        if (isValid) {//检测通过执行电话号码变更
            if (operator.isGeneralManager()) {
                throw new BusinessException("总经理不可变更联系方式，如有需要请联系客服！");
            }
            AdminFunArchive archive = adminFunArchiveMapper.selectByPrimaryKey(operator.getArchiveId());
            if (archive!=null && Byte.valueOf("1").equals(archive.getIsFreeUser())) {
            	throw new BusinessException("终身vip不可变更联系方式！");
            }
            GeneralParam generalParam = new GeneralParam(operator);
            adminFunArchiveService.updateUserMobile(generalParam, mobile);
            // 更新会话信息
            operator.setUserMobile(mobile);
            operator.setAttribute("USER_STORE_NO", mobile);
            cacheUtil.put(CacheStructure.ARCHIVE_ID_OPERATOR + operator.getArchiveId(), operator.getAllAtrtibute(), CacheUtilExt.SESSION_TIME_OUT);
        } else {
            throw new BusinessException("验证错误,请重试");
        }
        return ErpResponseJson.ok();
    }

    private void isRegister(String mobile) {
        List<AdminFunArchive> adminFunArchives = adminFunArchiveMapper.getValidMobileIsRegist(mobile);
        if (adminFunArchives.size() > 0) {
            throw new BusinessException("该手机号码已注册");
        }
    }

    /**
     * 新版个人中心，现金收支记录
     *
     * @param param
     * @return
     */
    @ResponseBody
    @RequestMapping("/getCashRecordList")
    public ResponseJson getCashRecordList(@RequestBody CashRecordParam param) {
        Operator operator = getOperator();
        param.setSelfUserId(operator.getUserId());
        param.setSelfArchiveId(operator.getArchiveId());
        param.setSelfUaId(operator.getUaId());
        param.setSelfCompUaId(operator.getCompUaId());
        param.setIsGeneralManager(0);
        if (operator.isGeneralManager()) {
            param.setIsGeneralManager(1);
        }
        if (operator.isSwitchCompLogin()) {
        	param.setSelfCityId(operator.getSelfCityId());
        } else {
        	param.setSelfCityId(operator.getCityId());
        }
        param.setSelfCompType(operator.getCompType());
        PageInfo<AdminFunPaidVo> cashRecordList = adminFunPaidService.getCashRecordList(param);
        return ErpResponseJson.ok(cashRecordList);
    }

    /**
     * 新版个人中心，好房豆收支记录
     *
     * @param param
     * @return
     */
    @ResponseBody
    @RequestMapping("/getHfCoinRecordList")
    public ResponseJson getHfCoinRecordList(@RequestBody CashRecordParam param) {
        Operator operator = getOperator();
        param.setSelfUserId(operator.getUserId());
        param.setSelfArchiveId(operator.getArchiveId());
        param.setSelfUaId(operator.getUaId());
        param.setSelfCompUaId(operator.getCompUaId());
        param.setIsGeneralManager(0);
        if (operator.isGeneralManager()) {
            param.setIsGeneralManager(1);
        }
        param.setSelfCityId(operator.getCityId());
        param.setSelfCompType(operator.getCompType());
        PageInfo<AdminFunPaidVo> hfCoinRecordList = adminFunPaidService.getHfCoinRecordList(param);
        return ErpResponseJson.ok(hfCoinRecordList);
    }

    /**
     * 新版个人中心，保证金收支记录
     *
     * @param param
     * @return
     */
    @ResponseBody
    @RequestMapping("/getTrueHouseLightRecordList")
    public ResponseJson getTrueHouseLightRecordList(@RequestBody CashRecordParam param) {
        Operator operator = getOperator();
        param.setSelfUserId(operator.getUserId());
        param.setSelfArchiveId(operator.getArchiveId());
        param.setSelfUaId(operator.getUaId());
        param.setSelfCompUaId(operator.getCompUaId());
        param.setIsGeneralManager(0);
        if (operator.isGeneralManager()) {
            param.setIsGeneralManager(1);
        }
        param.setSelfCityId(operator.getCityId());
        param.setSelfCompType(operator.getCompType());
        PageInfo<AdminFunPaidVo> trueHouseLightRecordList = adminFunPaidService.getTrueHouseLightRecordList(param);
        return ErpResponseJson.ok(trueHouseLightRecordList);
    }

    /**
     * 新版个人中心，推广返现收支记录
     *
     * @param param
     * @return
     */
    @ResponseBody
    @RequestMapping("/getBrokerInvitePrizeRecordList")
    public ResponseJson getBrokerInvitePrizeRecordList(@RequestBody CashRecordParam param) {
        Operator operator = getOperator();
        param.setSelfUserId(operator.getUserId());
        param.setSelfArchiveId(operator.getArchiveId());
        param.setSelfUaId(operator.getUaId());
        param.setSelfCompUaId(operator.getCompUaId());
        param.setIsGeneralManager(0);
        if (operator.isGeneralManager()) {
            param.setIsGeneralManager(1);
        }
        param.setSelfCityId(operator.getCityId());
        param.setSelfCompType(operator.getCompType());
        PageInfo<AdminFunPaidVo> brokerInvitePrizeRecordList = adminFunPaidService.getBrokerInvitePrizeRecordList(param);
        return ErpResponseJson.ok(brokerInvitePrizeRecordList);
    }

    /**
     * 新版个人中心，O2O收支记录
     *
     * @param param
     * @return
     */
    @ResponseBody
    @RequestMapping("/getO2ORecordList")
    public ResponseJson getO2ORecordList(@RequestBody CashRecordParam param) {
        Operator operator = getOperator();
        param.setSelfUserId(operator.getUserId());
        param.setSelfArchiveId(operator.getArchiveId());
        param.setSelfUaId(operator.getUaId());
        param.setSelfCompUaId(operator.getCompUaId());
        param.setIsGeneralManager(0);
        if (operator.isGeneralManager()) {
            param.setIsGeneralManager(1);
        }
        param.setSelfCityId(operator.getCityId());
        param.setSelfCompType(operator.getCompType());
        param.setSelfCompNo(operator.getCompNo());
        param.setSelfDeptNo(operator.getDeptNo());
        PageInfo<AdminFunPaidVo> trueHouseLightRecordList = adminFunPaidService.getO2ORecordList(param);
        return ErpResponseJson.ok(trueHouseLightRecordList);
    }

    /**
     * 新版个人中心，VIP增值服务记录
     *
     * @param param
     * @return
     */
    @ResponseBody
    @RequestMapping("/getSRVRecordList")
    public ResponseJson getSRVRecordList(@RequestBody CashRecordParam param) {
        Operator operator = getOperator();
        param.setSelfUserId(operator.getUserId());
        param.setSelfArchiveId(operator.getArchiveId());
        param.setSelfUaId(operator.getUaId());
        param.setSelfCityId(operator.getCityId());
        PageInfo<AdminFunPaidVo> SRVRecordList = adminFunPaidService.getSRVRecordList(param);
        return ErpResponseJson.ok(SRVRecordList);
        //2019-2-25 (plus 会员门店版也可以查看个人的消费，取消限制)
        /*if (operator.isPersonalVersion()) {
            PageInfo<AdminFunPaidVo> SRVRecordList = adminFunPaidService.getSRVRecordList(param);
            return ErpResponseJson.ok(SRVRecordList);
        } else {
            return ErpResponseJson.ok();
        }*/
    }

    /**
     * 个人中心修改头像（修改的工作头像fun_archive user_photo）
     *
     * @param param
     * @return
     */
    @ResponseBody
    @RequestMapping("/uploadUserPhoto")
    public ResponseJson uploadUserPhoto(@RequestBody BaseMapParam param) {
        Integer archiveId = param.getInteger("archiveId");
        String photoPath = param.getString("photoPath");
        if (null == archiveId) {
            archiveId = getOperator().getArchiveId();
        }
        // 修改工作头像
        adminFunArchiveService.updateUserPhoto(archiveId, photoPath);
        
        //如果档案头像为空(erp fun_users user_photo)，则同步修改
		ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
		erpFunUsersExample.setShardCityId(getOperator().getCityId());
		erpFunUsersExample.createCriteria().andUserIdEqualTo(getOperator().getUserId()).andUserPhotoIsNull();
		ErpFunUsers erpFunUsers = new ErpFunUsers();
		erpFunUsers.setUserPhoto(photoPath);
		erpFunUsers.setUpdateTime(DateUtil.DateToString(new Date()));
		erpFunUsersMapper.updateByExampleSelective(erpFunUsers, erpFunUsersExample);
        return ErpResponseJson.ok();
    }

    /**
     * 修改引导状态
     *
     * @return
     * @author 朱科
     * @since 2018年7月12日
     */
    @ResponseBody
    @RequestMapping("/updateUserGuide")
    public ResponseJson updateUserGuide(@RequestBody BaseMapParam param) {
        Integer status = param.getInteger("status"); // 1=已被跳过 2=引导成功
        String guideType = param.getString("guideType"); // 引导类型，ALL=全部跳过 指定类型请查看表：FUN_ERP_USER_GUIDE
        adminFunErpUserGuideService.updateUserGuide(status, getOperator().getArchiveId(), guideType);
        return ErpResponseJson.ok();
    }


	/**
	 * @tag 个人中心-获取合同列表
	 * @author 邓永洪
	 * @since 2018/7/13
	 */
	@ApiOperation("个人中心-获取合同列表,需求:8214,作者:陈峰")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "", response = GetCrmFunContractListVo.class)})
	@ResponseBody
	@RequestMapping("/getDeptListForContract")
	public ResponseJson getCrmFunContractList(@RequestBody CrmFunContractParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer adminCompId = operator.getAdminCompId();
		param.setCompId(adminCompId);
		if (param.getDeptId() != null) {
			ErpFunDepts erpFunDepts = erpFunDeptsMapper.getDeptByCompIdAndDeptId(cityId, operator.getCompId(), param.getDeptId());
			if (erpFunDepts != null) {
				param.setDeptNo(erpFunDepts.getDeptNo());
			}
		}

		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<AdminCrmFunContrackDto> deptListForContracts = adminFunDeptsMapper.getDeptListForContract(param);
		List<Integer> ids = deptListForContracts.stream().filter(it -> it.getContractId() != null).map(AdminFunDepts::getContractId).collect(Collectors.toList());
		String contractIds = StringUtils.join(ids, ",");

		String result = "";
		try {
			Map<String, Object> reqParam = new HashMap<>();
			reqParam.put("compId", adminCompId);
			reqParam.put("token", EncryptHelper.encryptMD5(adminCompId.toString()));
			reqParam.put("contractIds", contractIds);
//			"http://gray.51vfang.cn/crmWeb/"
			result = HttpUtil.post(AppConfig.getCrmWebUrl() + "crmOpenApi/deptsManage/selectContractUrl", reqParam);
			System.out.println("s:" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (StringUtils.isNotBlank(result)) {
			JSONObject resultJson = JSON.parseObject(result);
			JSONArray data = resultJson.getJSONArray("data");

			if (data.size() > 0) {
				for (int i = 0; i < data.size(); i++) {
					JSONObject jsonObject = data.getJSONObject(i);
					Integer contractId = jsonObject.getInteger("contractId");
					String url = jsonObject.getString("url");
					// 1:图片 2:制式模板页面 3:静态HTML页面
					Integer type = jsonObject.getInteger("type");

					for (AdminCrmFunContrackDto dto : deptListForContracts) {
						Integer dtoContractId = dto.getContractId();
						if (contractId.equals(dtoContractId)) {
							dto.setContractVersion(url);
							dto.setContractHtml(url);
							dto.setFileType(type);
						}
						if (dto != null && StringUtils.isNotBlank(dto.getSafetyPath())) {
							Integer deptId = dto.getDeptId();
							String token = new MD5Helper().getMD5ofStr(deptId.toString());
							String paramStr = "?deptId=" + deptId + "&token=" + token;
							String safetyPath = dto.getSafetyPath();
							if(safetyPath.indexOf("contractManager/finance") < 0){
								safetyPath = AppConfig.getCrmWebUrl()+"contractManager/finance/contract/template/" + dto.getSafetyPath()+paramStr;
							}
							dto.setSafetyPath(safetyPath);
						}
					}
				}
			}
		}

		GetCrmFunContractListVo getCrmFunContractListVo = new GetCrmFunContractListVo();
		getCrmFunContractListVo.setList(deptListForContracts);
		return ErpResponseJson.ok(getCrmFunContractListVo);
	}

	
	/**
	 * 查看发票记录
	 * @author 朱科
	 * @since 2018年7月13日
	 * @return
	 */
	@ApiOperation(value = "查看发票记录,需求:8219,作者:陈峰")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "", response = GetInvoiceNotWritedListVo.class)})
	@ResponseBody
	@RequestMapping("/getInvoiceHasWritedList")
	public ResponseJson getInvoiceHasWritedList(@RequestBody @Valid GetInvoiceHasWritedListParam param) {
		Operator operator = getOperator();
		Integer archiveId = operator.getArchiveId();
		Integer compId = operator.getCompId();
		boolean generalManagerFlag = operator.isGeneralManager();
		Integer invoiceType = param.getInvoiceType();// 1=需要开发票的消费记录
														// 2=已经开了发票的历史记录表
		if (null == invoiceType) {
			invoiceType = 2;
		}
		String padiTimeStart = null;
		if (2 == invoiceType) {
			Integer canIssueInvoiceDay = StringUtil
					.parseInteger(adminSysParaMapper.selectParamVlue("CAN_ISSUE_INVOICE_DAY"), 60);
			Date date = DateTimeHelper.addDays(new Date(), 0 - canIssueInvoiceDay);
			padiTimeStart = DateTimeHelper.formatDateTimetoString(date, DateTimeHelper.FMT_yyyyMMddHHmmss);
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows());
		List<AdminFunPaidDto> paidList = adminFunPaidMapper.getInvoiceList(operator.getCityId(),archiveId,invoiceType, compId,
				generalManagerFlag, padiTimeStart);
		GetInvoiceHasWritedListVo getInvoiceNotWritedListVo = new GetInvoiceHasWritedListVo();
		getInvoiceNotWritedListVo.setList(paidList);
		return ErpResponseJson.ok(getInvoiceNotWritedListVo);
	}
	
	/**
	 * 查询待开发票的消费记录
	 * @author 朱科
	 * @since 2018年7月16日
	 * @return
	 */
	@ApiOperation("查询发票消费详情,需求:8214,作者:陈峰")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "", response = GetDetailPaidListVo.class)})
	@ResponseBody
	@RequestMapping("/getPaidDetailList")
	public ResponseJson getPaidDetailList(@RequestBody ApplyIssueInvoiceParam param){
		GetDetailPaidListVo getDetailPaidListVo = new GetDetailPaidListVo();
		List<AdminFunPaidDto> adminFunPaidList = adminFunPaidMapper.getPaidDetailList(param.getInvoiceId());
		getDetailPaidListVo.setList(adminFunPaidList);
		return ErpResponseJson.ok(getDetailPaidListVo);
	}
	
	/**
	 * 个人中心提醒顾问联系用户
	 * @author 朱科
	 * @since 2018年7月20日
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getRemindConsultant")
	public ResponseJson remindConsultant(@RequestBody BaseMapParam param){
		Operator operator = getOperator();
		String selUid = (String)operator.getAttribute("SEL_UID");
		String isOTOweixin = param.getString("isOTOweixin");
		StringBuilder warmContent = new StringBuilder();
		if("0".equals(isOTOweixin)){
			warmContent.append("客户咨询软件费用，发送人：");
		} else if("1".equals(isOTOweixin)){
			warmContent.append("客户咨询微店费用，发送人：");
		} else if("2".equals(isOTOweixin)){
			warmContent.append("客户咨询精英版费用，发送人：");
		}
		warmContent.append(operator.getUserName()).append(" 电话：").append(operator.getUserMobile());
		adminCrmTaskService.remindConsultant(operator.getAdminCompId(), operator.getAdminDeptId(), selUid, warmContent.toString());
		return ErpResponseJson.ok();
	}

    /**
     * 获取好房豆量化配置
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/8/29
     */
    @ApiOperation("获取好房豆量化配置")
    @ResponseBody
    @RequestMapping("/getPaidConfig")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunPaidConfigVo.class, message = "成功")
    })
    public ResponseJson getPaidConfig() {
        Integer compId = getOperator().getCompId();
        Integer cityId = getOperator().getCityId();
        ErpFunPaidConfig erpFunPaidConfig = erpFunPaidConfigMapper.getFunPaidConfig(cityId, compId);
        if (null == erpFunPaidConfig) {
            ErpFunPaidConfig funPaidConfig = erpFunPaidConfigMapper.getFunPaidConfig(cityId, 0);
            funPaidConfig.setShardCityId(cityId);
            funPaidConfig.setId(null);
            erpFunPaidConfigMapper.insertSelective(funPaidConfig);
            erpFunPaidConfig = funPaidConfig;

        }
        return ErpResponseJson.ok(erpFunPaidConfig);
    }

    /**
     * 保存好房豆量化配置
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/8/29
     */
    @ApiOperation("保存好房豆量化配置")
    @ResponseBody
    @RequestMapping("/savePaidConfig")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    public ResponseJson savePaidConfig(@RequestBody ErpFunPaidConfigParam param) {
        Integer cityId = getOperator().getCityId();
        Integer compId = getOperator().getCompId();
        ErpFunPaidConfig erpFunPaidConfig = new ErpFunPaidConfig();
        try {
            BeanUtilsHelper.copyProperties(erpFunPaidConfig, param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        erpFunPaidConfig.setUpdateTime(new Date());
        erpFunPaidConfig.setUpdateUid(getOperator().getUserId());
        erpFunPaidConfigService.savePaidConfig(cityId, compId, erpFunPaidConfig);
        return ErpResponseJson.ok();
    }

    /**
     * 恢复好房豆量化配置默认
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/8/29
     */
    @ApiOperation("恢复好房豆量化配置默认")
    @ResponseBody
    @RequestMapping("/revertPaidConfig")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunPaidConfigVo.class, message = "成功")
    })
    public ResponseJson revertPaidConfig(@RequestBody RevertFunPaidConfigParam param) {
        Integer cityId = getOperator().getCityId();
        ErpFunPaidConfig erpFunPaidConfig = erpFunPaidConfigMapper.getFunPaidConfig(cityId, 0);
        return ErpResponseJson.ok(erpFunPaidConfig);
    }

    /**
     * 个人中心获取租用门店列表
     *
     * @return
     * @author 朱科
     * @since 2018年9月5日
     */
    @ApiOperation("个人中心获取租用门店列表,作者：朱科，需求：8559")
    @ResponseBody
    @RequestMapping("/getRentDeptsList")
    @ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = AdminRentDeptsDto.class, message = "成功")})
    public ResponseJson getRentDeptsList(@RequestBody BaseMapParam param) {
        Operator operator = getOperator();
        boolean generalManager = operator.isGeneralManager();
        if (!generalManager) {
            throw new BusinessException("非总经理，不能查看!");
        }
        String compNo = operator.getCompNo();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        PageHelper.startPage(param.getPageOffset(), param.getPageRows(), false);
        List<AdminFunDepts> rentDeptsList = adminFunDeptsMapper.getRentDeptsList(compNo, 5, DateTimeHelper.formatDateTimetoString(new Date()));
        if (null == rentDeptsList || rentDeptsList.isEmpty()) {
            return ErpResponseJson.ok();
        }
        List<AdminRentDeptsDto> resultList = new ArrayList<>();
        for (AdminFunDepts adminFunDepts : rentDeptsList) {
            AdminRentDeptsDto adminRentDeptsDto = new AdminRentDeptsDto();
            adminRentDeptsDto.setRentEndTime(DateTimeHelper.formatDateTimetoString(adminFunDepts.getRentEndTime()));
            adminRentDeptsDto.setCompNo(compNo);
            adminRentDeptsDto.setDeptNo(adminFunDepts.getDeptNo());
            resultList.add(adminRentDeptsDto);
        }
        List<String> deptNos = rentDeptsList.stream().collect(Collectors.mapping(AdminFunDepts::getDeptNo, Collectors.toList()));
        List<ErpFunDepts> funDeptsList = erpFunDeptsMapper.getDeptListByDeptNos(cityId, compId, deptNos);
        // 通过admin库的门店编号查询erp库的门店
        Map<String, ErpFunDepts> deptMap = funDeptsList.stream().collect(Collectors.toMap(ErpFunDepts::getDeptNo, val -> val));
        List<Integer> deptIds = funDeptsList.stream().collect(Collectors.mapping(ErpFunDepts::getDeptId, Collectors.toList()));
        // 统计门店有多少个用户
        List<ErpFunUsersDto> usersList = erpFunUsersMapper.getCountUsersByDeptIds(cityId, compId, deptIds);
        Map<Integer, Integer> userMap = usersList.stream().collect(Collectors.toMap(ErpFunUsersDto::getDeptId, ErpFunUsersDto::getCountUsers));
        for (AdminRentDeptsDto result : resultList) {
            String deptNo = result.getDeptNo();
            ErpFunDepts erpFunDepts = deptMap.get(deptNo);
            Integer deptId = erpFunDepts.getDeptId();
            result.setDeptId(deptId);
            result.setRentDeptName(erpFunDepts.getDeptName());
            result.setTotalUserNum(erpFunDepts.getUserNum());
            Integer countUser = userMap.get(deptId);
            if (null == countUser) {
                countUser = 0;
            }
            result.setUsedUserNum(countUser);
        }
        ErpResponseJson responseJson = new ErpResponseJson();
        responseJson.setTotal(Long.valueOf(resultList.size()));
        responseJson.setData(resultList);
        return responseJson;
    }

    /**
     * @author 邓永洪
     * @tag 获取用户头像地址
     * @since 2018/4/16
     */
    @ApiOperation("获取用户头像地址，作者=邓永洪")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = UserHeadPicDto.class, message = "成功")
    })
    @ResponseBody
    @PostMapping("/getUserHeadPic")
    public ResponseJson getUserHeadPic(@RequestBody UserHeadPicParam param) {
        String[] userIds = param.getUserIds().split(",");
        Map<Integer, Integer> archiveUserMap = new HashMap<>();
        List<UserHeadPicDto> usersPhotoList = new LinkedList<>();
        if (userIds != null && userIds.length >= 0) {
            List<ErpFunUsersDto> usersDtolist = erpFunUsersMapper.getUserArchiveList(getOperator().getCityId(), getOperator().getCompId(), userIds);
            archiveUserMap = usersDtolist.stream().collect(Collectors.toMap(ErpFunUsersDto::getArchiveId, ErpFunUsersDto::getUserId));
        }
        if (archiveUserMap.isEmpty()) {
            return ErpResponseJson.ok(usersPhotoList);
        }
        Integer[] archiveIds = archiveUserMap.keySet().toArray(new Integer[]{});
        List<AdminFunArchive> archiveList = adminFunArchiveMapper.getArchiveInfosByIds(Arrays.asList(archiveIds));
		Map<Integer, AdminFunArchive> archiveMap = archiveList.stream().collect(Collectors.toMap(AdminFunArchive::getArchiveId, val -> val));
        for (Map.Entry<Integer, Integer> entry : archiveUserMap.entrySet()) {
            AdminFunArchive adminFunArchive = archiveMap.get(entry.getKey());
			if (adminFunArchive == null) {
				continue;
			}
			if (StringUtils.isBlank(adminFunArchive.getUserPhoto())) {
				continue;
			}

			UserHeadPicDto usersPhoto = new UserHeadPicDto();
            usersPhoto.setUserId(entry.getValue());
            usersPhoto.setUserPhoto(StringUtil.getBbsPhoto(adminFunArchive.getUserPhoto()));
            usersPhotoList.add(usersPhoto);
        }

        return ErpResponseJson.ok(usersPhotoList);
    }

	/**
	 * @author lcb
	 * @tag  
	 * @since 2019/11/6
	 */
	@ApiOperation("删除本地数据中的红点")
	@ResponseBody
	@RequestMapping("/deleteMessageMessage")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = DeleteMessageMessageVO.class, message = "成功")})
	public ResponseJson deleteMessageMessage(@RequestBody DeleteMessageMessageParam param) {
		Operator operator = getOperator();
		adminFunUserMessageMapper.deleteMessageByCondition(operator.getArchiveId(), param.getCaseId(), param.getCaseType(), param.getMsgModule());
		return ErpResponseJson.ok(new ArrayList<>());
	}

    /**
     * @author lcb
     * @tag 获取socket未读列表-基本信息
     * @since 2019/11/6
     */
    @ApiOperation("获取socket未读列表-基本信息")
    @ResponseBody
    @RequestMapping("/getMessageBaseInfoList")
    @ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = MessageBaseInfoListVo.class, message = "成功")})
    public ResponseJson getMessageBaseInfoList(@RequestBody MessageBaseInfoListParam param) {
        Operator operator = getOperator();
        Integer archiveId = operator.getArchiveId();
        List<AdminFunUserMessage> resList = adminFunUserMessageMapper.getMessageBaseInfoList(archiveId);
        return ErpResponseJson.ok(resList);
    }

    /**
     * @author lcb
     * @tag 获取socket未读列表-基本信息
     * @since 2019/11/6
     */
    @ApiOperation("获取socket未读列表-基本信息")
    @ResponseBody
    @RequestMapping("/getMessageRichInfoList")
    @ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = MessageRichInfoListVO.class, message = "成功")})
    public ResponseJson getMessageRichInfoList(@RequestBody MessageRichInfoListParam param) {
        Operator operator = getOperator();

        PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
        List<AdminFunUserMessage> resList = adminFunUserMessageMapper.getMessageRichInfoList(operator.getArchiveId(), param.getMsgModule());
        // 删除自己的所有消息
        adminFunUserMessageMapper.deleteMessageByCondition(operator.getArchiveId(), null, null, param.getMsgModule());
        return ErpResponseJson.ok(new PageInfo<>(resList));
    }

    /**
     * @author 蔡春林
     * @date 2020/1/15 0015
     * @param param
     * @return com.myfun.framework.web.json.ResponseJson
     */
    @ApiOperation("获取新组织架构下的所有经纪人信息")
    @ResponseBody
    @RequestMapping("/getOrganizationUserList")
    @ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = GetOrganizationUserVo.class, message = "成功")})
    public ResponseJson getOrganizationUserList(@RequestBody @Validated GetOrganizationUserListParam param) {
        GetOrganizationUserListVo vo = new GetOrganizationUserListVo();
        List<GetOrganizationUserVo> GetOrganizationUserList = new ArrayList<>();
        Operator operator = getOperator();
        String[] split = param.getOrganizations().split(",");
        if (split == null || split.length == 0) {
            throw new BusinessException("参数错误！");
        }
        List<String> Organizations = Arrays.asList(split);
        for (String organization : Organizations) {
            GetOrganizationUserList.addAll(erpFunUsersMapper.getUserByOrganizationId(operator.getCityId(), operator.getCompId(), StringUtil.paseInteger(organization)));
        }
        //遍历数组去掉重复的
        List<GetOrganizationUserVo> voList = new ArrayList<>();
        HashMap<Integer, GetOrganizationUserVo> map = new HashMap<>();
        if (GetOrganizationUserList.size() > 0) {
            for (GetOrganizationUserVo getOrganizationUserVo : GetOrganizationUserList) {
                if (map.get(getOrganizationUserVo.getUserId()) == null) {
                    voList.add(getOrganizationUserVo);
                } else {
                    map.put(getOrganizationUserVo.getUserId(), getOrganizationUserVo);
                }
            }
        }
        vo.setUserList(voList);
        return ErpResponseJson.ok(vo);
    }
}



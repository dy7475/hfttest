package com.myfun.erpWeb.managecenter.transaction;

import static com.myfun.utils.DateTimeHelper.getTimeNow;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.myfun.erpWeb.common.CommonController;
import com.myfun.erpWeb.statisticalAnalysis.FaFaCountController;
import com.myfun.erpWeb.statisticalAnalysis.param.GetSelectWhereParam;
import com.myfun.framework.session.RequestSourceConst;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.service.business.erpdb.*;
import com.myfun.service.business.erpdb.bean.vo.UserOrganizationInfoVO;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.lang.StringUtils;
import org.apache.zookeeper.Op;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.constract.param.InsertDealInfoParam;
import com.myfun.erpWeb.managecenter.constract.param.TaxesDataOutParamDto;
import com.myfun.erpWeb.managecenter.deal.param.DealAuditCommonParam;
import com.myfun.erpWeb.managecenter.deal.param.DealBussinessCommonParam;
import com.myfun.erpWeb.managecenter.deal.vo.DealAuditCommonVO;
import com.myfun.erpWeb.managecenter.financialStatements.vo.InsertMgrWarrantProcessVo;
import com.myfun.erpWeb.managecenter.param.AppMgrWarrantStepListParam;
import com.myfun.erpWeb.managecenter.profit.param.FinancAuditListParam;
import com.myfun.erpWeb.managecenter.profit.param.SignStatisticsListParam;
import com.myfun.erpWeb.managecenter.profit.vo.FinancAuditListVO;
import com.myfun.erpWeb.managecenter.profit.vo.SignStatisticsListVO;
import com.myfun.erpWeb.managecenter.transaction.param.AppDealProfitListParam;
import com.myfun.erpWeb.managecenter.transaction.param.AppEditBrokerageIncomeParam;
import com.myfun.erpWeb.managecenter.transaction.param.ChangeProfitInMobileParam;
import com.myfun.erpWeb.managecenter.transaction.param.ContractLockStatusParam;
import com.myfun.erpWeb.managecenter.transaction.param.CounterMgrSettleDealParam;
import com.myfun.erpWeb.managecenter.transaction.param.CreateProcessModelParam;
import com.myfun.erpWeb.managecenter.transaction.param.DealBusinessParam;
import com.myfun.erpWeb.managecenter.transaction.param.DealCodeListParam;
import com.myfun.erpWeb.managecenter.transaction.param.DealContractParam;
import com.myfun.erpWeb.managecenter.transaction.param.DealFianacByPerformanceParam;
import com.myfun.erpWeb.managecenter.transaction.param.DealFianacListParam;
import com.myfun.erpWeb.managecenter.transaction.param.DelDealProfitParam;
import com.myfun.erpWeb.managecenter.transaction.param.DelProcessStepParam;
import com.myfun.erpWeb.managecenter.transaction.param.DeleteFunPerformanceTypeParam;
import com.myfun.erpWeb.managecenter.transaction.param.DynamicInsertProcessStepParam;
import com.myfun.erpWeb.managecenter.transaction.param.EditBrokerageIncomeParam;
import com.myfun.erpWeb.managecenter.transaction.param.FinaDataOfReceivableInMobileParam;
import com.myfun.erpWeb.managecenter.transaction.param.FinaDataOfReceivableParam;
import com.myfun.erpWeb.managecenter.transaction.param.GetContractDealParam;
import com.myfun.erpWeb.managecenter.transaction.param.InsertMgrStepModelParam;
import com.myfun.erpWeb.managecenter.transaction.param.InsertRunTimeStepParam;
import com.myfun.erpWeb.managecenter.transaction.param.InsertWarrantProcessParam;
import com.myfun.erpWeb.managecenter.transaction.param.MgrWarrantStepListParam;
import com.myfun.erpWeb.managecenter.transaction.param.PrintDataofTaxAndFeeParam;
import com.myfun.erpWeb.managecenter.transaction.param.ProcessFinancStatusParam;
import com.myfun.erpWeb.managecenter.transaction.param.SettlementDealParam;
import com.myfun.erpWeb.managecenter.transaction.param.TaxesDataParam;
import com.myfun.erpWeb.managecenter.transaction.param.UpdateDealTaxesAuditStatusParam;
import com.myfun.erpWeb.managecenter.transaction.param.UpdateFunPerformanceParam;
import com.myfun.erpWeb.managecenter.transaction.param.UpdateMgrWarrantStepDataParam;
import com.myfun.erpWeb.managecenter.transaction.param.UpdateModelStepRelateParam;
import com.myfun.erpWeb.managecenter.transaction.param.UpdateOrInsertDealTaxesParam;
import com.myfun.erpWeb.managecenter.transaction.param.UpdateRuntimeStepParam;
import com.myfun.erpWeb.managecenter.transaction.param.UpdateRuntimeStepSeqParam;
import com.myfun.erpWeb.managecenter.transaction.param.WarrantStepParam;
import com.myfun.erpWeb.managecenter.transaction.param.changeProfitParam;
import com.myfun.erpWeb.managecenter.transaction.param.changeWarrantParam;
import com.myfun.erpWeb.managecenter.transaction.param.completionProcessParam;
import com.myfun.erpWeb.managecenter.transaction.param.insertUpdateMgrStepParam;
import com.myfun.erpWeb.managecenter.transaction.vo.AppDealProfitListResultVO;
import com.myfun.erpWeb.managecenter.transaction.vo.AppDealProfitVO;
import com.myfun.erpWeb.managecenter.transaction.vo.CommssionVO;
import com.myfun.erpWeb.managecenter.transaction.vo.ContractTaskListOfTransactVo;
import com.myfun.erpWeb.managecenter.transaction.vo.CreateProcessModelVo;
import com.myfun.erpWeb.managecenter.transaction.vo.DealContractDto;
import com.myfun.erpWeb.managecenter.transaction.vo.DealContractListResultVO;
import com.myfun.erpWeb.managecenter.transaction.vo.DealContractRsultVo;
import com.myfun.erpWeb.managecenter.transaction.vo.DealContractVO;
import com.myfun.erpWeb.managecenter.transaction.vo.DealFianacListVo;
import com.myfun.erpWeb.managecenter.transaction.vo.DealListVo;
import com.myfun.erpWeb.managecenter.transaction.vo.DealTaxVO;
import com.myfun.erpWeb.managecenter.transaction.vo.ErpFunDealCodeVO;
import com.myfun.erpWeb.managecenter.transaction.vo.ErpFunProfitStandVo;
import com.myfun.erpWeb.managecenter.transaction.vo.ErpOutdealVo;
import com.myfun.erpWeb.managecenter.transaction.vo.ErpProcessRuntimeStepDto;
import com.myfun.erpWeb.managecenter.transaction.vo.ErpProcessRuntimeStepVo;
import com.myfun.erpWeb.managecenter.transaction.vo.ErpUserDeptNameVo;
import com.myfun.erpWeb.managecenter.transaction.vo.FianacMoneyVo;
import com.myfun.erpWeb.managecenter.transaction.vo.FinancVO;
import com.myfun.erpWeb.managecenter.transaction.vo.FunDealTaxesFatherVO;
import com.myfun.erpWeb.managecenter.transaction.vo.FunDealTaxesRecordVO;
import com.myfun.erpWeb.managecenter.transaction.vo.FunDealTaxesSubVO;
import com.myfun.erpWeb.managecenter.transaction.vo.FunDealTaxesVO;
import com.myfun.erpWeb.managecenter.transaction.vo.HouseBriefInfoVO;
import com.myfun.erpWeb.managecenter.transaction.vo.InsertRunTimeStepVO;
import com.myfun.erpWeb.managecenter.transaction.vo.MgrWarrantStepListVO;
import com.myfun.erpWeb.managecenter.transaction.vo.NewStandardProfitVo;
import com.myfun.erpWeb.managecenter.transaction.vo.PrintDataofTaxAndFeeResultVO;
import com.myfun.erpWeb.managecenter.transaction.vo.ProcessModelStepListResultVO;
import com.myfun.erpWeb.managecenter.transaction.vo.ProcessModelStepVO;
import com.myfun.erpWeb.managecenter.transaction.vo.RuntimeStepVO;
import com.myfun.erpWeb.managecenter.transaction.vo.UpdateAppMgrFinaDataOfReceiveVo;
import com.myfun.erpWeb.managecenter.vo.AppMgrWarrantStepListResultVO;
import com.myfun.erpWeb.managecenter.vo.DealBusinessVo;
import com.myfun.erpWeb.managecenter.vo.GetProcessModelListResultVO;
import com.myfun.erpWeb.managecenter.vo.GetProcessModelListVO;
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
import com.myfun.repository.admindb.dao.AdminFunCompMapper;
import com.myfun.repository.admindb.dao.AdminFunShareRelevanceMapper;
import com.myfun.repository.admindb.dao.AdminOnlinePaymentReceiptFileMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminFunComp;
import com.myfun.repository.admindb.po.AdminFunShareRelevance;
import com.myfun.repository.admindb.po.AdminOnlinePaymentReceiptFile;
import com.myfun.repository.admindb.po.AdminOnlinePaymentReceiptFileExample;
import com.myfun.repository.erpdb.dto.ErpFunDealCodeDto;
import com.myfun.repository.erpdb.dto.ErpFunDealDto;
import com.myfun.repository.erpdb.dto.ErpFunDealExtVO;
import com.myfun.repository.erpdb.dto.ErpModelStepDetailDto;
import com.myfun.repository.erpdb.dto.ErpOutdealDto;
import com.myfun.repository.erpdb.dto.ErpProcessFinancDto;
import com.myfun.repository.erpdb.param.ErpFunOutdealParam;
import com.myfun.repository.erpdb.param.ErpFunPerformanceTypeParam;
import com.myfun.repository.erpdb.param.QueryDealListParam;
import com.myfun.repository.erpdb.param.QueryDealPfActualParam;
import com.myfun.repository.erpdb.po.ErpDealUserRelative;
import com.myfun.repository.erpdb.po.ErpDealUserRelativeExample;
import com.myfun.repository.erpdb.po.ErpFunBrokerageIncome;
import com.myfun.repository.erpdb.po.ErpFunBuyCustomer;
import com.myfun.repository.erpdb.po.ErpFunComp;
import com.myfun.repository.erpdb.po.ErpFunDeal;
import com.myfun.repository.erpdb.po.ErpFunDealPaytype;
import com.myfun.repository.erpdb.po.ErpFunDealTaxes;
import com.myfun.repository.erpdb.po.ErpFunDealTaxesExample;
import com.myfun.repository.erpdb.po.ErpFunDealTaxesFather;
import com.myfun.repository.erpdb.po.ErpFunDealTaxesFatherExample;
import com.myfun.repository.erpdb.po.ErpFunDealTaxesRecord;
import com.myfun.repository.erpdb.po.ErpFunDealTaxesRecordExample;
import com.myfun.repository.erpdb.po.ErpFunDealTaxesSub;
import com.myfun.repository.erpdb.po.ErpFunDealTaxesSubExample;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunDeptsgroup;
import com.myfun.repository.erpdb.po.ErpFunDeptsgroupExample;
import com.myfun.repository.erpdb.po.ErpFunFinancPayment;
import com.myfun.repository.erpdb.po.ErpFunFinancPaymentExample;
import com.myfun.repository.erpdb.po.ErpFunFinancStatus;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunOutdeal;
import com.myfun.repository.erpdb.po.ErpFunPerformanceType;
import com.myfun.repository.erpdb.po.ErpFunPerformanceTypeExample;
import com.myfun.repository.erpdb.po.ErpFunProcessLog;
import com.myfun.repository.erpdb.po.ErpFunProcessRecord;
import com.myfun.repository.erpdb.po.ErpFunProfit;
import com.myfun.repository.erpdb.po.ErpFunProfitExample;
import com.myfun.repository.erpdb.po.ErpFunRentCustomer;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpFunUsersExample;
import com.myfun.repository.erpdb.po.ErpModelStepRelate;
import com.myfun.repository.erpdb.po.ErpModelStepRelateExample;
import com.myfun.repository.erpdb.po.ErpOutdeal;
import com.myfun.repository.erpdb.po.ErpProcessFinanc;
import com.myfun.repository.erpdb.po.ErpProcessFinancExample;
import com.myfun.repository.erpdb.po.ErpProcessModel;
import com.myfun.repository.erpdb.po.ErpProcessModelExample;
import com.myfun.repository.erpdb.po.ErpProcessModelStep;
import com.myfun.repository.erpdb.po.ErpProcessModelStepExample;
import com.myfun.repository.erpdb.po.ErpProcessRuntimeStep;
import com.myfun.repository.erpdb.po.ErpProcessRuntimeStepExample;
import com.myfun.repository.erpdb.po.ErpSsqContract;
import com.myfun.repository.erpdb.po.ErpSsqContractExample;
import com.myfun.repository.erpdb.po.ErpUserOpers;
import com.myfun.repository.erpdb.po.ErpUserOpersExample;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.admindb.AdminFunCompService;
import com.myfun.service.business.admindb.AdminJmsMessageService;
import com.myfun.service.jms.bean.UpdateFunProfitMessage;
import com.myfun.utils.Assert;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.BeanUtilsHelper;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateConvert;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.DateUtil;
import com.myfun.utils.NumberHelper;
import com.myfun.utils.StringUtil;
import com.myfun.utils.SyncUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "合同模块")
@RestController
@RequestMapping("/managerCenter/transaction/deal")
public class DealBusinessController extends BaseController {
    @Autowired
    ErpFunDealMapper erpFunDealMapper;
    @Autowired
    ErpFunProfitMapper erpFunProfitMapper;
    @Autowired
    ErpFunUsersMapper erpFunUsersMapper;
    @Autowired
    ErpFunFinancStatusMapper erpFunFinancStatusMapper;
    @Autowired
    ErpProcessFinancMapper erpProcessFinancMapper;
    @Autowired
    ErpFunFinancPaymentMapper erpFunFinancPaymentMapper;
    @Autowired
    ErpUserOpersService erpUserOpersService;
    @Autowired
    ErpProcessModelMapper erpProcessModelMapper;
    @Autowired
    ErpProcessModelService erpProcessModelService;
    @Autowired
    ErpProcessRuntimeStepMapper erpProcessRuntimeStepMapper;
    @Autowired
    ErpModelStepRelateMapper erpModelStepRelateMapper;
    @Autowired
    ErpProcessModelStepMapper erpProcessModelStepMapper;
    @Autowired
    ErpFunDealTaxesMapper erpFunDealTaxesMapper;
    @Autowired
    ErpFunDealTaxesFatherMapper erpFunDealTaxesFatherMapper;
    @Autowired
    ErpFunDealTaxesSubMapper erpFunDealTaxesSubMapper;
    @Autowired
    ErpFunDealTaxesRecordMapper erpFunDealTaxesRecordMapper;
    @Autowired
    ErpFunDealPaytypeMapper erpFunDealPaytypeMapper;
    @Autowired
    ErpFunBrokerageMapper erpFunBrokerageMapper;
    @Autowired
    ErpFunProcessLogMapper erpFunProcessLogMapper;
    @Autowired
    ErpModelStepRelateService erpModelStepRelateService;
    @Autowired
    ErpFunPerformanceTypeMapper erpFunPerformanceTypeMapper;
    @Autowired
    ErpFunUsersService erpFunUsersService;
    @Autowired
    ErpFunDealTaxesRecordService erpFunDealTaxesRecordService;
    @Autowired
    ErpProcessRuntimeStepService erpProcessRuntimeStepService;
    @Autowired
    ErpFunDealService erpFunDealService;
    @Autowired
    ErpFunProcessRecordService erpFunProcessRecordService;
    @Autowired
    ErpFunTaskService erpFunTaskService;
    @Autowired
    ErpFunDealRecordService erpFunDealRecordService;
    @Autowired
    ErpFunProfitService erpFunProfitService;
    @Autowired
    ErpSysParaMapper erpSysParaMapper;
    @Autowired
    ErpFunWageMapper erpFunWageMapper;
    @Autowired
    AdminJmsMessageService adminJmsMessageService;
    @Autowired
    ErpFunDealCodeMapper erpFunDealCodeMapper;
    @Autowired
    ErpFunBillMapper erpFunBillMapper;
    @Autowired
    ErpProcessFinanceService erpProcessFinanceService;
    @Autowired
    ErpFunBrokerageService erpFunBrokerageService;
    @Autowired
    ErpFunBrokerageIncomeService erpFunBrokerageIncomeService;
    @Autowired
    AdminFunShareRelevanceMapper adminFunShareRelevanceMapper;
    @Autowired
    ErpFunCompMapper erpFunCompMapper;
    @Autowired
    ErpOutdealMapper erpOutdealMapper;
    @Autowired
    ErpFunSaleMapper erpFunSaleMapper;
    @Autowired
    ErpFunLeaseMapper erpFunLeaseMapper;
    @Autowired
    ErpFunRentCustomerMapper erpFunRentCustomerMapper;
    @Autowired
    ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
    @Autowired
    ErpUserOpersMapper erpUserOpersMapper;
    @Autowired
    ErpDealUserRelativeMapper erpDealUserRelativeMapper;
    @Autowired
    ErpAuditRuntimeService erpAuditRuntimeService;
    @Autowired
    AdminFunArchiveMapper adminFunArchiveMapper;
    @Autowired
    ErpFunProcessRecordMapper erpFunProcessRecordMapper;
    @Autowired
    ErpFunDeptsgroupMapper erpFunDeptsgroupMapper;
    @Autowired
    AdminOnlinePaymentReceiptFileMapper adminOnlinePaymentReceiptFileMapper;
    @Autowired
    AdminFunCompMapper adminFunCompMapper;
    @Autowired
    AdminFunCompService adminFunCompService;
    @Autowired
    ErpFunPerformanceTypeExtMapper erpFunPerformanceTypeExtMapper;
    @Resource
    private ErpSsqContractMapper erpSsqContractMapper;
    @Autowired
    ErpFunHouseFileMapper erpFunHouseFileMapper;
    @Autowired
	ErpFunDeptsMapper erpFunDeptsMapper;
    @Autowired
    private ErpAuditTemplateMapper erpAuditTemplateMapper;
    @Autowired
    private ErpFunOrganizationService erpFunOrganizationService;
    @Autowired
    private ErpSysParaService erpSysParaService;
    /**
     * 获取合同列表
     * flj
     * 2017/09/26
     *
     * @return
     */
    @ApiOperation("获取合同列表")
    @RequestMapping("/getDealList")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = DealListVo.class, message = "成功")
    })
    @ResponseBody
    public ResponseJson getDealList(@RequestBody QueryDealListParam param) {
        Operator operator = getOperator();
        param.setCompId(operator.getCompId());
        param.setCurrentUserId(operator.getUserId());
        param.setNewOrganization(operator.newOrganizationType());
        Integer cityId = operator.getCityId();
        Integer userId = param.getUserId();
        Integer financStatusId = param.getFinancStatusId();
        ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, userId);
        if (userId != null) {
            if (userId.equals(param.getCurrentUserId())) {
                param.setArichveId(operator.getArchiveId());
            } else {
                param.setArichveId(erpFunUsers.getArchiveId());
            }
            param.setUserLevel(erpFunUsers.getUserLevel()+2); 
        }

        if (null != financStatusId) {
            ErpFunFinancStatus id = new ErpFunFinancStatus();
            id.setShardCityId(cityId);
            id.setFinancStatusId(financStatusId);
            ErpFunFinancStatus erpFunFinancStatus = erpFunFinancStatusMapper.selectByPrimaryKey(id);
            String financName = erpFunFinancStatus.getFinancName();

            if ("待结清".equals(financName)) {
                param.setFinancName(financName);
            }
        }

        // 判断下支付方式
        if (null != param.getPayTypeId()) {
            ErpFunDealPaytype erpFunDealPaytype = new ErpFunDealPaytype();
            erpFunDealPaytype.setPaytypeId(param.getPayTypeId());
            erpFunDealPaytype.setShardCityId(cityId);
            erpFunDealPaytype = erpFunDealPaytypeMapper.selectByPrimaryKey(erpFunDealPaytype);
            if (null != erpFunDealPaytype) {
                // 特殊处理优家新版合同的定制
                String paytypeName = erpFunDealPaytype.getPaytypeName();
                if ("一次性".equals(paytypeName)) {
                    param.setYoujiaPayTypeId(1);
                } else if ("贷款".equals(paytypeName)) {
                    param.setYoujiaPayTypeId(2);
                }
            }
        }
        //0=本人 1=本人团队 2=下级所有  (房基地参数)
		if(param.getUserId() !=null){
			List<ErpFunUsers> funUsers = null;
			if(param.getOperLevel() !=null && "1".equals(param.getOperLevel().toString())){
				funUsers = erpFunUsersMapper.getUserAllTeamList(cityId,param.getCompId() ,param.getUserId(),param.getUserLevel());
				//condition.add(new ConditionItem("B.ARCHIVE_ID", "IN", "SELECT ARCHIVE_ID FROM FUN_USERS WHERE COMP_ID = "+queryDealListParam.getCompId()+" AND  TISSUE_LINE LIKE '%:"+userId+":%' AND USER_LEVEL <="+queryDealListParam.getUserLevel()));
			}else if(param.getOperLevel() !=null && "2".equals(param.getOperLevel().toString())){
				funUsers = erpFunUsersMapper.getUserAllTeamList(cityId,param.getCompId() ,param.getUserId(),null);
				//condition.add(new ConditionItem("B.ARCHIVE_ID", "IN", "SELECT ARCHIVE_ID FROM FUN_USERS WHERE COMP_ID = "+queryDealListParam.getCompId()+" AND  TISSUE_LINE LIKE '%:"+userId+":%' "));
			}
			if(funUsers !=null && funUsers.size() >0){
				Set<Integer> archiveIds = new HashSet<Integer>();
				for (ErpFunUsers userInfo : funUsers) {
					archiveIds.add(userInfo.getArchiveId());
				}
				param.setArchiveIds(archiveIds);
			}
			 
		}
		//新版组织架构兼容老版，将deptId复制到organizationId
        if (operator.newOrganizationType()) {
            if (param.getDeptId() != null) {
                param.setOrganizationId(param.getDeptId());
            }
        }
        // 查询下部统计条
        Map<String, Object> dataMap = erpFunDealMapper.getDealTotalPrice(cityId, param);
        int totalCount = erpFunDealMapper.getDealTotalCount(cityId, param);
        List<ErpFunDealExtVO> list = new ArrayList<>();
        if (totalCount > 0) {
            list = erpFunDealMapper.getDealList(cityId, param);
        }

        // 判断权限，是否可以具有查看电话的权限
        boolean firstAuditFlag = erpUserOpersService.judgePermissionBySwitchLogin(getOperator().getCityId(), getOperator().getUserId(), "DEAL_INITIAL_REVIEW",getOperator().isSwitchCompLogin());
        boolean repeatAuditFlag = erpUserOpersService.judgePermissionBySwitchLogin(getOperator().getCityId(), getOperator().getUserId(), "DEAL_REPEAT_REVIEW",getOperator().isSwitchCompLogin());
        for (ErpFunDealExtVO dealPO : list) {
            if (!isShowPhone(dealPO.getDealStatus(), firstAuditFlag, repeatAuditFlag)) {
                String phone = SyncUtil.getDecodePhone(dealPO.getSellOwnerPhoneencode());
                dealPO.setSellOwnerPhone(phone);
                dealPO.setSellOwnerPhoneencode(phone);
                phone = SyncUtil.getDecodePhone(dealPO.getBuyCustomerPhoneencode());
                dealPO.setBuyCustomerPhone(phone);
                dealPO.setBuyCustomerPhoneencode(phone);
            }

            if (null != dealPO && 56907 == dealPO.getCompId() && 8 == cityId) {
                dealPO.setSellOwnerPhone("****");
                dealPO.setSellOwnerPhoneencode("****");
                dealPO.setBuyCustomerPhone("****");
                dealPO.setBuyCustomerPhoneencode("****");
            }
        }
        if (list.size() > 0 && "8".equals(param.getFlag())) {
        this.judgeProfitPerson(getOperator(), list);
        }

        if (getOperator().isMobileApi()) {
            this.changePhoneInfoByPerson(operator, list);
            list.forEach(it -> {
                String dealUserName = it.getDealUserName();
                if (StringUtils.isNotBlank(dealUserName)) {
                    if (dealUserName.contains("(")) {
                        it.setDealUserName(dealUserName.substring(0, dealUserName.indexOf("(")));
                    }
                    if (dealUserName.contains("（")) {
                        it.setDealUserName(dealUserName.substring(0, dealUserName.indexOf("（")));
                    }
                }
            });

            DealListVo dealListVo = new DealListVo();
            dealListVo.setList(list);
            dealListVo.setPageNum(param.getPageOffset());
            dealListVo.setPageSize(param.getPageRows());
            dealListVo.setTotal((long) totalCount);
            dealListVo.setExtra(dataMap);
            return ErpResponseJson.ok(dealListVo);
        } else {
            // ERP端宽列表增加数据
            if (Byte.valueOf("1").equals(param.getIsWideList())) {
                if (!list.isEmpty()) {
                    List<Integer> dealIdList = list.stream().collect(Collectors.mapping(ErpFunDealExtVO::getDealId, Collectors.toList()));
                    List<Integer> archiveIdList = list.stream().collect(Collectors.mapping(ErpFunDealExtVO::getSignUserArchive, Collectors.toList()));
                    Map<Integer, ErpFunSale> saleMap = new HashMap<Integer, ErpFunSale>();// 出售房源信息
                    Map<Integer, ErpFunLease> leaseMap = new HashMap<Integer, ErpFunLease>();// 出租房源信息
                    Map<Integer, List<RuntimeStepVO>> runtimeStepVOMap = new HashMap<Integer, List<RuntimeStepVO>>();// 出售的权证流程信息
                    Map<Integer, AdminFunArchive> archiveMap = new HashMap<Integer, AdminFunArchive>();// 经纪人的头像信息

                    // 查询经纪人的头像信息
                    if (!archiveIdList.isEmpty()) {
                        List<AdminFunArchive> adminFunArchiveList = adminFunArchiveMapper.selectUserPhoto(archiveIdList);
                        archiveMap = adminFunArchiveList.stream().collect(Collectors.toMap(AdminFunArchive::getArchiveId, val -> val, (oldVal, newVal) -> oldVal));
                    }

                    if ("101".equals(param.getDealType())) {
                        List<Integer> saleIdList = list.stream().collect(Collectors.mapping(ErpFunDealExtVO::getDealHouseId, Collectors.toList()));
                        if (!saleIdList.isEmpty()) {
                            String[] queryColumn = new String[]{"SALE_ID", "SALE_ROOF_T", "SALE_UNIT_T", "SALE_NUM_T", "SALE_ROOM"};
                            List<ErpFunSale> erpFunSaleList = erpFunSaleMapper.selectSaleListByIds(cityId, saleIdList.toArray(new Integer[]{}), queryColumn, getOperator().getCompId());
                            saleMap = erpFunSaleList.stream().collect(Collectors.toMap(ErpFunSale::getSaleId, val -> val, (oldVal, newVal) -> oldVal));
                        }
                    } else if ("102".equals(param.getDealType())) {
                        List<Integer> leaseIdList = list.stream().collect(Collectors.mapping(ErpFunDealExtVO::getDealHouseId, Collectors.toList()));
                        if (!leaseIdList.isEmpty()) {
                            String[] queryColumn = new String[]{"LEASE_ID", "LEASE_ROOF_T", "LEASE_UNIT_T", "LEASE_NUM_T", "LEASE_ROOM"};
                            List<ErpFunLease> erpFunLeaseList = erpFunLeaseMapper.selectLeaseListByIds(cityId, leaseIdList.toArray(new Integer[]{}), queryColumn, getOperator().getCompId());
                            leaseMap = erpFunLeaseList.stream().collect(Collectors.toMap(ErpFunLease::getLeaseId, val -> val, (oldVal, newVal) -> oldVal));
                        }
                    }

                    // 权证流程步骤	只有出售才有权证，出租的是审批流程，前端自己拼接
                    if ("101".equals(param.getDealType())) {
                        List<RuntimeStepVO> runtimeStepVOList = erpProcessRuntimeStepMapper.getRuntimeStepListByDealIds(cityId, getOperator().getCompId(), dealIdList);
                        runtimeStepVOMap = runtimeStepVOList.stream().collect(Collectors.groupingBy(RuntimeStepVO::getDealId));
                    }

                    // 应收实收列表
                    List<ErpProcessFinanc> processFinancList = erpProcessFinancMapper.getProcessFinancByDealIds(cityId, getOperator().getCompId(), dealIdList);

                    for (ErpFunDealExtVO deal : list) {
                        Integer dealId = deal.getDealId();
                        Integer houseId = deal.getDealHouseId();
                        Integer signUserArchive = deal.getSignUserArchive();
                        if ("101".equals(param.getDealType()) && !saleMap.isEmpty()) {
                            ErpFunSale erpFunSale = saleMap.get(houseId);
                            if (null != erpFunSale) {
                                HouseBriefInfoVO houseBriefInfoVO = new HouseBriefInfoVO();
                                houseBriefInfoVO.setHouseId(erpFunSale.getSaleId());
                                houseBriefInfoVO.setHouseNum(erpFunSale.getSaleNumT());
                                houseBriefInfoVO.setHouseRoof(erpFunSale.getSaleRoofT());
                                houseBriefInfoVO.setHouseRoom(erpFunSale.getSaleRoom());
                                houseBriefInfoVO.setHouseUnit(erpFunSale.getSaleUnitT());
                                deal.setHouseInfo(houseBriefInfoVO);
                            }
                        } else if ("102".equals(param.getDealType()) && !leaseMap.isEmpty()) {
                            ErpFunLease erpFunLease = leaseMap.get(houseId);
                            if (null != erpFunLease) {
                                HouseBriefInfoVO houseBriefInfoVO = new HouseBriefInfoVO();
                                houseBriefInfoVO.setHouseId(erpFunLease.getLeaseId());
                                houseBriefInfoVO.setHouseNum(erpFunLease.getLeaseNumT());
                                houseBriefInfoVO.setHouseRoof(erpFunLease.getLeaseRoofT());
                                houseBriefInfoVO.setHouseRoom(erpFunLease.getLeaseRoom());
                                houseBriefInfoVO.setHouseUnit(erpFunLease.getLeaseUnitT());
                                deal.setHouseInfo(houseBriefInfoVO);
                            }
                        }
                        if (!runtimeStepVOMap.isEmpty()) {
                            List<RuntimeStepVO> runtimeStepList = runtimeStepVOMap.get(dealId);
                            if (null != runtimeStepList) {
                                deal.setRuntimeStepVOList(runtimeStepList);
                            }
                        }
                        if (null != signUserArchive && !archiveMap.isEmpty()) {
                            AdminFunArchive adminFunArchive = archiveMap.get(signUserArchive);
                            if (null != adminFunArchive && StringUtil.isNotBlank(adminFunArchive.getUserPhoto())) {
                                deal.setSignUserPhoto(AppConfig.getUserPhotoPicDomainPath(adminFunArchive.getUserPhoto()));
                            }
                        }

                        // 业主应收
                        BigDecimal ownerReceivable = processFinancList.stream().filter(val -> (dealId.equals(val.getDealId()) && Byte.valueOf("0").equals(val.getPfActual()) && "2".equals(val.getPfPayer()) && null != val.getPayAmount())).map(ErpProcessFinanc::getPayAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
                        deal.setOwnerReceivable(ownerReceivable);
                        // 业主实收
                        BigDecimal ownerActualReceiptCapital = processFinancList.stream().filter(val -> (dealId.equals(val.getDealId()) && Byte.valueOf("1").equals(val.getPfActual()) && "2".equals(val.getPfPayer()) && null != val.getPayAmount())).map(ErpProcessFinanc::getPayAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
                        deal.setOwnerActualReceiptCapital(ownerActualReceiptCapital);
                        // 客户应收
                        BigDecimal custReceivable = processFinancList.stream().filter(val -> (dealId.equals(val.getDealId()) && Byte.valueOf("0").equals(val.getPfActual()) && "1".equals(val.getPfPayer()) && null != val.getPayAmount())).map(ErpProcessFinanc::getPayAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
                        deal.setCustReceivable(custReceivable);
                        // 客户实收
                        BigDecimal custActualReceiptCapital = processFinancList.stream().filter(val -> (dealId.equals(val.getDealId()) && Byte.valueOf("1").equals(val.getPfActual()) && "1".equals(val.getPfPayer()) && null != val.getPayAmount())).map(ErpProcessFinanc::getPayAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
                        deal.setCustActualReceiptCapital(custActualReceiptCapital);
                    }
                }
            }
            this.changePhoneInfoByPerson(operator, list);
            //  处理分成人电话数据
            ErpResponseJson responseJson = new ErpResponseJson(list);
            responseJson.setPageNum(param.getPageOffset());
            responseJson.setPageSize(param.getPageRows());
            responseJson.setTotal((long) totalCount);
            responseJson.setExtra(JSON.toJSONString(dataMap));
            return responseJson;
        }
    }

    /**
     * 对个手机信息根据系统参数，合同状态，以及是否房客源所属经纪人进行具体控制
     * 作者：黎桂良
     * 时间：2019/10/15
     **/
    private void changePhoneInfoByPerson(Operator operator, List<ErpFunDealExtVO> list) {
//        String showPhonenum = erpSysParaMapper.getParamValue(operator.getCityId(), operator.getCompId(), "DEAL_WILL_SHOW_PHONENUM");
        String showPhonenum = erpSysParaService.getMLSysParamValByUserDefEmpty(operator.getCityId(), operator.getCompId(),operator.getUserId(), "DEAL_WILL_SHOW_PHONENUM");
        //查询对应的上上签合同
        List<Integer> dealIdList = list.stream().collect(Collectors.mapping(ErpFunDealExtVO::getDealId, Collectors.toList()));
        List<ErpSsqContract> erpSsqContracts = new ArrayList<>();
        ErpSsqContractExample ssqCondition = new ErpSsqContractExample();
        ssqCondition.setShardCityId(operator.getCityId());
        if (!dealIdList.isEmpty()) {
            ssqCondition.createCriteria().andDealIdIn(dealIdList).andIsDelEqualTo((byte) 0);
            erpSsqContracts = erpSsqContractMapper.selectByExample(ssqCondition);
        }
        Map<Integer, List<ErpSsqContract>> listMap = erpSsqContracts.stream().collect(Collectors.groupingBy(val -> val.getDealId()));
        list.stream().forEach(obj -> {
                    if (!operator.getUserId().equals(obj.getCustUserUid())) {
                        if ("1".equals(showPhonenum)) {//系统参数为显示电话号码
                            if (listMap.get(obj.getDealId()) != null) {//此合同开通了在线签约
                                ErpSsqContract erpSsqContract = new ErpSsqContract();
                                erpSsqContract = listMap.get(obj.getDealId()).get(0);
                                //如果未初审或者初审中，或者房客源所属经纪人，设置信息为***
                                if (erpSsqContract.getContractStatus() == null || erpSsqContract.getContractStatus() == 0 || Byte.valueOf("0").equals(obj.getDealAuditStatus()) || Byte.valueOf("5").equals(obj.getDealAuditStatus())
                                        || operator.getUserId().equals(obj.getHouseUserUid())) {
                                    obj.setSellOwnerPhone("***");
                                    obj.setBuyCustomerPhone("***");
                                    obj.setSellOwnerPhoneBak("***");
                                    obj.setBuyCustomerPhoneBak("***");
                                }
                            } else {//此合同未开通在线签约
                                if (Byte.valueOf("0").equals(obj.getDealAuditStatus()) || Byte.valueOf("5").equals(obj.getDealAuditStatus()) || operator.getUserId().equals(obj.getHouseUserUid())) {
                                    obj.setSellOwnerPhone("***");
                                    obj.setBuyCustomerPhone("***");
                                    obj.setSellOwnerPhoneBak("***");
                                    obj.setBuyCustomerPhoneBak("***");
                                }
                            }
                        } else if ("0".equals(showPhonenum)) {//系统参数为不显示
                            obj.setSellOwnerPhone(null);
                            obj.setBuyCustomerPhone(null);
                            obj.setSellOwnerPhoneBak(null);
                            obj.setBuyCustomerPhoneBak(null);
                        }
                    }
                }
        );
    }

    /**
     * 判断是否1.仅仅是分成人
     **/
    private void judgeProfitPerson(Operator operator, List<ErpFunDealExtVO> list) {

        // 先全部置为业绩分成人，后面再一个一个取消
        list.stream().forEach(val -> {
            val.setProfitPerson(true);
        });
        List<Integer> dealIdList = list.stream().collect(Collectors.mapping(ErpFunDealExtVO::getDealId, Collectors.toList()));
        // 先判断当前登录人是否仅仅是分成人
        // 先查询是否是合同相关人
        List<ErpDealUserRelative> erpDealUserRelativeListTemp = new ArrayList<>();
        if (!dealIdList.isEmpty()) {
            ErpDealUserRelativeExample erpDealUserRelativeExample = new ErpDealUserRelativeExample();
            erpDealUserRelativeExample.setShardCityId(operator.getCityId());
            erpDealUserRelativeExample.createCriteria().andDealIdIn(dealIdList).
                    andCompIdEqualTo(operator.getCompId());
            erpDealUserRelativeListTemp = erpDealUserRelativeMapper.selectByExample(erpDealUserRelativeExample);
        }
        List<ErpDealUserRelative> erpDealUserRelativeList = erpDealUserRelativeListTemp;
        Map<Integer, List<ErpDealUserRelative>> dealRelativeListMap = erpDealUserRelativeList.stream().collect(Collectors.groupingBy(val -> val.getDealId()));

        list.stream().filter(val -> val.getProfitPerson()).forEach(val -> {
            List<ErpDealUserRelative> relativeList = dealRelativeListMap.get(val.getDealId());

            if (null != relativeList && relativeList.size() > 0) {

                for (ErpDealUserRelative erpDealUserRelative : relativeList) {
                    if (erpDealUserRelative.getUserId().equals(operator.getUserId())) {
                        val.setProfitPerson(false);
                        break;
                    }
                }

            }
        });

        // 查询个人权限，有权限的话不用考虑是否仅仅分层人或者房客源所属经纪人，都可以查看
        List<String> operIds = Arrays.asList(new String[]{"VIEW_GROUP_DEAL", "VIEW_DEPT_DEAL", "VIEW_COMP_DEAL", "VIEW_AREA_DEAL", "VIEW_REG_DEAL"});
        ErpUserOpersExample erpUserOpersExample = new ErpUserOpersExample();
        erpUserOpersExample.setShardCityId(operator.getCityId());
        erpUserOpersExample.createCriteria().andOperIdIn(operIds).andUserIdEqualTo(operator.getUserId());
        List<ErpUserOpers> erpUserOpers = erpUserOpersMapper.selectByExample(erpUserOpersExample);
        // 没有权限，列表能查询出来，肯定是分层人
        if (erpUserOpers.size() > 0) {
            Set<String> collect = erpUserOpers.stream().collect(Collectors.mapping(ErpUserOpers::getOperId, Collectors.toSet()));
            // 这里可以查看全公司了
            if (collect.contains("VIEW_COMP_DEAL")) {
                list.stream().forEach(val -> {
                    val.setProfitPerson(false);
                });
            } else if (collect.contains("VIEW_AREA_DEAL")) {
                list.stream().filter(val -> val.getProfitPerson()).forEach(val -> {
                    Set<Integer> areaIdSet = erpDealUserRelativeList.stream().filter(vel -> vel.getDealId().equals(val.getDealId())).collect(Collectors.mapping(vel -> vel.getAreaId(), Collectors.toSet()));
                    if (areaIdSet.size() > 0 && areaIdSet.contains(operator.getAreaId())) {
                        val.setProfitPerson(false);
                    }
                });

            } else if (collect.contains("VIEW_REG_DEAL")) {
                list.stream().filter(val -> val.getProfitPerson()).forEach(val -> {
                    Set<Integer> regIdSet = erpDealUserRelativeList.stream().filter(vel -> vel.getDealId().equals(val.getDealId())).collect(Collectors.mapping(vel -> vel.getRegId(), Collectors.toSet()));
                    if (regIdSet.size() > 0 && regIdSet.contains(operator.getRegId())) {
                        val.setProfitPerson(false);
                    }
                });

            } else if (collect.contains("VIEW_DEPT_DEAL")) {
                list.stream().filter(val -> val.getProfitPerson()).forEach(val -> {
                    Set<Integer> deptIdSet = erpDealUserRelativeList.stream().filter(vel -> vel.getDealId().equals(val.getDealId())).collect(Collectors.mapping(vel -> vel.getDeptId(), Collectors.toSet()));
                    if (deptIdSet.size() > 0 && deptIdSet.contains(operator.getDeptId())) {
                        val.setProfitPerson(false);
                    }
                });

            } else if (collect.contains("VIEW_GROUP_DEAL")) {
                list.stream().filter(val -> val.getProfitPerson()).forEach(val -> {
                    Set<Integer> grIdSet = erpDealUserRelativeList.stream().filter(vel -> vel.getDealId().equals(val.getDealId())).collect(Collectors.mapping(vel -> vel.getGrId(), Collectors.toSet()));
                    if (grIdSet.size() > 0 && grIdSet.contains(operator.getGrId())) {
                        val.setProfitPerson(false);
                    }
                });
            }
        }

        list.stream().filter(val -> val.getProfitPerson()).forEach(val -> {
            val.setSellOwnerPhone("***");
            val.setSellOwnerName("***");
            val.setBuyCustomerPhone("***");
            val.setBuyOwnerName("***");
            val.setBuyIdCard("***");
            val.setSellIdCard("***");
            val.setSellAddress("***");
        });
    }

    /**
     * 权证流程 - 合同列表页获取权证流程列表
     *
     * @author czq
     * @since 2019/3/11
     */
    @ApiOperation("合同列表页获取权证流程列表(按照dealId聚合,按照stepSeq排序)")
    @PostMapping("/getMgrWarrantStepListInMobile")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpProcessRuntimeStepVo.class, message = "成功")
    })
    @ResponseBody
    public ResponseJson getMgrWarrantStepListInMobile(@RequestBody WarrantStepParam param) {
        Integer cityId = getOperator().getCityId();
        Integer compId = getOperator().getCompId();
        String dealIds = param.getDealIds();
        String[] ids = dealIds.split(",");

        ErpProcessRuntimeStepVo erpProcessRuntimeStepVo = new ErpProcessRuntimeStepVo();

        if (ids.length == 0) {
            return ErpResponseJson.ok(erpProcessRuntimeStepVo);
        }
        List<ErpProcessRuntimeStepDto> runtimeStepDtoList = erpProcessRuntimeStepMapper.getMgrWarrantStepListByIds(cityId, compId, ids);
        // 获取执行人列表
        Set<Integer> executorSet = runtimeStepDtoList.stream().map(ErpProcessRuntimeStepDto::getExecutor).collect(Collectors.toSet());

        if (executorSet.isEmpty()) {
            erpProcessRuntimeStepVo.setSteps(runtimeStepDtoList);
            return ErpResponseJson.ok(erpProcessRuntimeStepVo);
        }

        List<ErpFunUsers> usersList = erpFunUsersMapper.getUserListByUserIds(cityId, executorSet);
        Map<Integer, Integer> archiveIdMap = usersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, ErpFunUsers::getArchiveId));
        runtimeStepDtoList.forEach(stepDto -> {
            stepDto.setExecutorArchiveId(archiveIdMap.get(stepDto.getExecutor()));

            String executorName = stepDto.getExecutorName();
            if (StringUtils.isNotBlank(executorName)) {
                if (executorName.contains("(")) {
                    stepDto.setExecutorName(executorName.substring(0, executorName.indexOf("(")));
                }
                if (executorName.contains("（")) {
                    stepDto.setExecutorName(executorName.substring(0, executorName.indexOf("（")));
                }
            }
        });

        erpProcessRuntimeStepVo.setSteps(runtimeStepDtoList);
        return ErpResponseJson.ok(erpProcessRuntimeStepVo);
    }

    private boolean isShowPhone(Byte dealStatus, boolean firstAuditFlag, boolean repeatAuditFlag) {
        String dealAuditStatus = String.valueOf(dealStatus);
        if (firstAuditFlag || repeatAuditFlag) {
            return true;
        }
        if (Constants_DIC.DIC_DEAL_FIRSTCOMPLETE_OK.equals(dealAuditStatus)) {
            return true;
        } else return Constants_DIC.DIC_DEAL_REPEATCOMPLETE_OK.equals(dealAuditStatus);
    }

    /**
     * 获取财务列表
     * flj
     * 2017/09/26
     *
     * @return
     */
    @ApiOperation("获取财务列表")
    @ApiResponses({@ApiResponse(code = 200, response = DealFianacListVo.class, message = "success")})
    @RequestMapping("/getDealFianacList")
    @NotBlank(value = {"dealId"})
    public ResponseJson getDealFianacList(@RequestBody DealFianacListParam param) {

        Operator operator = getOperator();
        Integer dealId = param.getDealId();
        // 关联查询
        List<ErpProcessFinancDto> resList = erpProcessFinancMapper.getList(operator.getCityId(), operator.getCompId(), dealId);
        // 处理以前老数据的
        ErpFunDeal baseDealInfo = erpFunDealMapper.getBaseDealInfo(operator.getCityId(), dealId);
        List<Integer> receiptFileIds = new ArrayList<>(resList.size());
        for (ErpProcessFinancDto ysPo : resList) {
            // 应收
            if ("0".equals(ysPo.getPfActual().toString())) {
                for (ErpProcessFinancDto shPo : resList) {
                    if (Byte.valueOf("1").equals(shPo.getPfActual()) && ysPo.getPfPayer() != null && ysPo.getPfPayer().equals(shPo.getPfPayer()) &&
                            ysPo.getPaymentId() != null && ysPo.getPaymentId().equals(shPo.getPaymentId())) {
                        // 已支付
                        ysPo.setPayStatus(1);
                    }
                }
            }
            String billPhotoUrl = ysPo.getBillPhoto();
            ysPo.setBillPhoto(CommonUtil.getHousePhoto(billPhotoUrl));
            if (null != ysPo.getOnlinePaymentReceiptFileId()) {
                receiptFileIds.add(ysPo.getOnlinePaymentReceiptFileId());
            }
        }

//		Integer dealId = param.getInteger("dealId");
//		Integer cityId = getOperator().getCityId();
        Map<String, Object> returnData = new HashMap<>();
//		ErpProcessFinancExample example = new ErpProcessFinancExample();
//		example.setShardCityId(cityId);
//		example.setOrderByClause("PF_ID");
//		example.createCriteria().andCompIdEqualTo(getOperator().getCompId()).andDealIdEqualTo(dealId);
//		List<ErpProcessFinanc> list = erpProcessFinancMapper.selectByExample(example);
        BigDecimal realTotalMoney = erpFunProfitMapper.getTolalRealProfitByDealId(operator.getCityId(), dealId);

        Map<Integer, AdminOnlinePaymentReceiptFile> collect = new HashMap<>();
        // 处理回单数据
        if (receiptFileIds.size() > 0) {
            // 查询文件
            AdminOnlinePaymentReceiptFileExample fileExample = new AdminOnlinePaymentReceiptFileExample();
            fileExample.createCriteria().andFileIdIn(receiptFileIds).andDownCompletedEqualTo((byte) 1);
            List<AdminOnlinePaymentReceiptFile> adminOnlinePaymentReceiptFiles = adminOnlinePaymentReceiptFileMapper.selectByExample(fileExample);

            collect = adminOnlinePaymentReceiptFiles.stream().collect(Collectors.toMap(val -> val.getFileId(), val -> val));
        }


        for (ErpProcessFinancDto ysPo : resList) {
            Integer onlinePaymentReceiptFileId = ysPo.getOnlinePaymentReceiptFileId();

            if (null != onlinePaymentReceiptFileId) {
                AdminOnlinePaymentReceiptFile adminOnlinePaymentReceiptFile = collect.get(onlinePaymentReceiptFileId);
                if (null != adminOnlinePaymentReceiptFile && StringUtils.isNotBlank(adminOnlinePaymentReceiptFile.getFilePath())) {
                    ysPo.setReceiptFilePath(CommonUtil.getHousePhoto(adminOnlinePaymentReceiptFile.getFilePath()));
                }
            }

            // 1:客户2:业主
            String pfPayer = ysPo.getPfPayer();
            if (Const.DIC_PFMAN_BUY.equals(pfPayer)) {
                ysPo.setPayerName(baseDealInfo.getBuyOwnerName());
            }

            if (Const.DIC_PFMAN_SELL.equals(pfPayer)) {
                ysPo.setPayerName(baseDealInfo.getSellOwnerName());
            }

        }
        if (getOperator().isMobileApi()) {
            DealFianacListVo vo = new DealFianacListVo();
            vo.setRealProfit(realTotalMoney);
            vo.setProFianclist(resList);
            return ErpResponseJson.ok(vo);
        } else {
            returnData.put("proFianclist", resList);
            returnData.put("realProfit", realTotalMoney);
            return ErpResponseJson.ok(returnData);
        }
    }

    @ApiOperation("根据业绩类别查询该合同应收实收总金额,员工业绩分配比例,公司业绩分配比例")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = FianacMoneyVo.class, message = "成功")
    })
    @RequestMapping("/getDealFianacByPerformance")
    public ResponseJson getDealFianacByPerformance(@RequestBody DealFianacByPerformanceParam param) {
        Operator operator = getOperator();

        Integer dealId = param.getDealId();
        Byte performanceType = param.getPerformanceType();
        FianacMoneyVo vo = new FianacMoneyVo();

        List<ErpProcessFinancDto> list = erpProcessFinancMapper.getList(operator.getCityId(), operator.getCompId(), dealId);
        List<ErpProcessFinancDto> dtoList = list.stream().filter(it -> it.getPerformanceType().equals(performanceType)).collect(Collectors.toList());

        BigDecimal receivableMoney = BigDecimal.ZERO;
        BigDecimal actualMoney = BigDecimal.ZERO;

        if (dtoList.size() > 0) {
            // 应收总金额
            List<ErpProcessFinancDto> receivableList = dtoList.stream().filter(it -> it.getPfActual() == 0 && it.getPayAmount() != null).collect(Collectors.toList());
            // 实收总金额
            List<ErpProcessFinancDto> actualList = dtoList.stream().filter(it -> it.getPfActual() == 1 && it.getPayAmount() != null).collect(Collectors.toList());

            for (ErpProcessFinancDto erpProcessFinancDto : receivableList) {
                receivableMoney = receivableMoney.add(erpProcessFinancDto.getPayAmount());
            }
            for (ErpProcessFinancDto erpProcessFinancDto : actualList) {
                actualMoney = actualMoney.add(erpProcessFinancDto.getPayAmount());
            }
        }

        AdminFunComp adminFunComp = adminFunCompMapper.selectByCompId(operator.getAdminCompId());
        if (null != adminFunComp) {
            if (adminFunComp.getCompManagementModel() == 2 && adminFunComp.getCustomizedType() == 1) {
                ErpFunProfitExample compExample = new ErpFunProfitExample();
                compExample.setShardCityId(operator.getCityId());
                compExample.createCriteria().andDealIdEqualTo(dealId).andProfitTypeEqualTo((byte) 1).andCompIdEqualTo(operator.getCompId()).andPerformanceTypeEqualTo(performanceType);
                List<ErpFunProfit> compProfitList = erpFunProfitMapper.selectByExample(compExample);
                BigDecimal compReceivableMoney = new BigDecimal(0);
                for (ErpFunProfit erpFunProfit : compProfitList) {
                    compReceivableMoney = compReceivableMoney.add(erpFunProfit.getReceivableMoney());
                }
                receivableMoney = receivableMoney.subtract(compReceivableMoney);
            }
        }

        vo.setReceivableMoney(receivableMoney);
        vo.setActualMoney(actualMoney);

        BigDecimal userProfitProportion = BigDecimal.ZERO;
        BigDecimal compProfitProportion = BigDecimal.ZERO;

        ErpFunProfitExample example = new ErpFunProfitExample();
        example.setShardCityId(getOperator().getCityId());
        example.createCriteria().andDealIdEqualTo(dealId).andPerformanceTypeEqualTo(performanceType);
        List<ErpFunProfit> profitList = erpFunProfitMapper.selectByExample(example);

        // 获取该业绩类别员工业绩总比例
        List<ErpFunProfit> userProfitList = profitList.stream().filter(it -> it.getProfitProportion() != null && it.getProfitType() == 0).collect(Collectors.toList());
        // 获取该业绩类别公司业绩总比例
        List<ErpFunProfit> compProfitList = profitList.stream().filter(it -> it.getProfitProportion() != null && it.getProfitType() == 1).collect(Collectors.toList());

        BigDecimal compReceivableMoney = BigDecimal.ZERO;
        BigDecimal compActualMoney = BigDecimal.ZERO;
        BigDecimal userReceivableMoney = BigDecimal.ZERO;
        BigDecimal userActualMoney = BigDecimal.ZERO;

        if (userProfitList.size() > 0) {
            for (ErpFunProfit erpFunProfit : userProfitList) {
                userProfitProportion = userProfitProportion.add(erpFunProfit.getProfitProportion());
                userReceivableMoney.add(erpFunProfit.getReceivableMoney());
                userActualMoney.add(erpFunProfit.getProfitMoney());
            }
        }
        if (compProfitList.size() > 0) {
            for (ErpFunProfit erpFunProfit : compProfitList) {
                compProfitProportion = compProfitProportion.add(erpFunProfit.getProfitProportion());
                compReceivableMoney.add(erpFunProfit.getReceivableMoney());
                compActualMoney.add(erpFunProfit.getProfitMoney());
            }
        }

        vo.setUserProfitProportion(userProfitProportion);
        vo.setCompProfitProportion(compProfitProportion);
        vo.setCompReceivableMoney(compReceivableMoney);
        vo.setCompActualMoney(compActualMoney);
        vo.setUserReceivableMoney(userReceivableMoney);
        vo.setUserActualMoney(userActualMoney);
        return ErpResponseJson.ok(vo);
    }

    /**
     * 获取财务列表
     * flj
     * 2017/09/26
     *
     * @return
     */
    @RequestMapping("/getDealProfitList")
    @NotBlank(value = {"dealId"})
    public ResponseJson getDealProfitList(@RequestBody BaseMapParam param) {
        Integer dealId = param.getInteger("dealId");
        Integer cityId = getOperator().getCityId();
        ErpFunProfitExample example = new ErpFunProfitExample();
        example.setShardCityId(cityId);
        example.createCriteria().andDealIdEqualTo(dealId);
        List<ErpFunProfit> profitList = erpFunProfitMapper.selectByExample(example);
        return ErpResponseJson.ok(profitList);
    }

    @ApiOperation("根据业绩大类型获取业绩类别信息列表")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunPerformanceType.class, message = "成功")
    })
    @PostMapping("/getPerformanceListByType")
    @NotBlank(value = {"performanceType"})
    public ResponseJson getPerFormanceListByType(@RequestBody BaseMapParam param) throws Exception {
        Integer compId = getOperator().getCompId();
        Integer cityId = getOperator().getCityId();
        Byte performanceType = param.getByte("performanceType");
        ErpFunPerformanceTypeExample erpFunPerformanceTypeExample = new ErpFunPerformanceTypeExample();
        erpFunPerformanceTypeExample.setShardCityId(cityId);
        erpFunPerformanceTypeExample.createCriteria().andCompIdEqualTo(compId).andCollectionTypeEqualTo(performanceType).andIsDelEqualTo((byte) 0);
        /***查询该公司所有业绩类别****/
        List<ErpFunPerformanceType> list = erpFunPerformanceTypeMapper.selectByExample(erpFunPerformanceTypeExample);

        /**********判断是否为房基地，如果是则初始化委托超出部分百分比扣除**********/
//        Boolean isHouseBase = this.isHouseBase(getOperator().getAdminCompId());
//        if(isHouseBase){
//        	ErpFunPerformanceTypeExtExample erpFunPerformanceTypeExtExample = new ErpFunPerformanceTypeExtExample();
//    		erpFunPerformanceTypeExtExample.createCriteria().andIdDelEqualTo((byte) 0).andCompIdEqualTo(compId).andTargetPerformanceIdIsNotNull();
//    		erpFunPerformanceTypeExtExample.setShardCityId(cityId);
//    		List<ErpFunPerformanceTypeExt> erpFunPerformanceTypeExtsList = erpFunPerformanceTypeExtMapper.selectByExample(erpFunPerformanceTypeExtExample);
//    		if(!erpFunPerformanceTypeExtsList.isEmpty()){
//    			for (ErpFunPerformanceType erpFunPerformanceType : list) {
//    				for (ErpFunPerformanceTypeExt erpFunPerformanceTypeExt : erpFunPerformanceTypeExtsList) {
//    					if(erpFunPerformanceTypeExt.getExtType() == 2 && erpFunPerformanceTypeExt.getPerformanceId().equals(erpFunPerformanceType.getPerformanceId())){
//							if(erpFunPerformanceTypeExt.getPerformanceProportion().compareTo(BigDecimal.ZERO) > 0) {
//								for (ErpFunPerformanceType typeDto : list) {
//									if(typeDto.getPerformanceId().equals(erpFunPerformanceTypeExt.getTargetPerformanceId())){
//										typeDto.setPerformanceProportion(typeDto.getPerformanceProportion().subtract(erpFunPerformanceTypeExt.getPerformanceProportion()));
//									}
//								}
//							}
//    					}
//    				}
//    			}
//    		}
//        }
        return ErpResponseJson.ok(list);
    }

    private Boolean isHouseBase(Integer adminCompId) {
        /*****判断是否房基地，如果是，则需要将所有业绩类别都返回，无论有没有人*****/
    	try {
    		AdminFunComp adminFunComp = adminFunCompMapper.selectByPrimaryKey(adminCompId);
    		if (null != adminFunComp) {
    			if (adminFunComp.getCompManagementModel() == 2 && adminFunComp.getCustomizedType() == 1) {
    				return true;
    			}
    		}
		} catch (Exception e) {
			return false;
		}
        return false;
    }

    @ApiOperation("根据合同ID获取公司平台拆佣金额及比例")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = Map.class, message = "成功")
    })
    @PostMapping("/getCompCommissionByDealId")
    public ResponseJson getCompCommissionByDealId(@RequestBody BaseMapParam param) throws Exception {
        Integer compId = getOperator().getCompId();
        Integer cityId = getOperator().getCityId();
        boolean isFjd = isHouseBase(getOperator().getAdminCompId());
        if (null == param.getInteger("dealId")) {
            String compPerformanceProportion = erpSysParaMapper.getParamValue(cityId, compId, "SIPHON_TOTAL_PERFORMANCE_PERCENTAGE");
            compPerformanceProportion = StringUtil.isEmpty(compPerformanceProportion) ? "0" : compPerformanceProportion;
            Map<String, Object> map = new HashMap<String, Object>();
            if(isFjd){compPerformanceProportion = "0";}
            map.put("compReceivableMoney", 0);
            map.put("compProfitProportion", compPerformanceProportion);
            return ErpResponseJson.ok(map);
        }
        Integer dealId = param.getInteger("dealId");
        /***查询公司业绩****/
        ErpFunProfitExample compExample = new ErpFunProfitExample();
        compExample.setShardCityId(cityId);
        compExample.createCriteria().andDealIdEqualTo(dealId).andProfitTypeEqualTo((byte) 1).andCompIdEqualTo(compId);
        List<ErpFunProfit> compProfitList = erpFunProfitMapper.selectByExample(compExample);
        BigDecimal compReceivableMoney = new BigDecimal(0);
        BigDecimal compProfitMoney = new BigDecimal(0);
        BigDecimal compProfitProportion = new BigDecimal(0);
        if (null != compProfitList && compProfitList.size() > 0) {
            compProfitProportion = compProfitList.get(0).getProfitProportion();
            for (ErpFunProfit erpFunProfit : compProfitList) {
                compReceivableMoney = compReceivableMoney.add(erpFunProfit.getReceivableMoney());
                compProfitMoney = compProfitMoney.add(erpFunProfit.getProfitMoney());
            }
        }
        Map<String, Object> map = new HashMap<String, Object>();
        if(isFjd){compProfitProportion = new BigDecimal(0);}
        map.put("compReceivableMoney", compReceivableMoney);
        map.put("compProfitMoney", compProfitMoney);
        map.put("compProfitProportion", compProfitProportion);
        return ErpResponseJson.ok(map);
    }

    /***
     * 最新标准版获取财务列表（兼容房基地）
     * @author XIONG CAI
     * @since 2019年8月31日 上午11:17:13
     * @param param
     * @return
     * @throws Exception
     * Modified XXX XIONG CAI 2019年8月31日
     */
    @ApiOperation("最新标准版获取业绩分配列表（兼容房基地）")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = NewStandardProfitVo.class, message = "成功")
    })
    @PostMapping("/getDealCustomizedProfitList")
    @NotBlank(value = {"dealId"})
    public ResponseJson getDealCustomizedProfitList(@RequestBody BaseMapParam param) throws Exception {
        Integer compId = getOperator().getCompId();
        Integer cityId = getOperator().getCityId();
        Integer dealId = param.getInteger("dealId");
        /***查询该公司所有业绩类别****/
        List<ErpFunPerformanceType> list = erpFunPerformanceTypeMapper.getDataListByCompId(cityId, compId);
        if (list.isEmpty()) {//如果没有业绩类别，则初始化一份
            if(isHouseBase(getOperator().getAdminCompId())){
                erpFunPerformanceTypeMapper.insertFunPerforManceTypeForFjd(cityId, compId);
            }else {
                erpFunPerformanceTypeMapper.insertFunPerforManceType(cityId,compId);
            }
            list = erpFunPerformanceTypeMapper.getDataListByCompId(cityId, compId);
        }
        if(isHouseBase(getOperator().getAdminCompId())) {
        	list = erpFunPerformanceTypeMapper.getFjdDataListByCompId(cityId, compId);
        }
        
        Map<Integer, ErpFunPerformanceType> performanceTypeMap = list.stream().collect(Collectors.toMap(ErpFunPerformanceType::getPerformanceId, ErpFunPerformanceType -> ErpFunPerformanceType));
        /****查询合同的所有财务款项汇总****/
        ErpProcessFinancDto erpProcessFinancDto = erpProcessFinancMapper.getProcessFinancDtoByDealId(cityId, dealId);
        if (null == erpProcessFinancDto) {
            erpProcessFinancDto = new ErpProcessFinancDto();
        }
        if (null == erpProcessFinancDto.getTransferNeedPerformance()) {
            erpProcessFinancDto.setTransferNeedPerformance(BigDecimal.ZERO);
        }
        if (null == erpProcessFinancDto.getSecondhandNeedPerformance()) {
            erpProcessFinancDto.setSecondhandNeedPerformance(BigDecimal.ZERO);
        }
        if (null == erpProcessFinancDto.getNewhouseNeedPerformance()) {
            erpProcessFinancDto.setNewhouseNeedPerformance(BigDecimal.ZERO);
        }
        if (null == erpProcessFinancDto.getLeaseNeedPerformance()) {
            erpProcessFinancDto.setLeaseNeedPerformance(BigDecimal.ZERO);
        }
        if (null == erpProcessFinancDto.getFinanceNeedPerformance()) {
            erpProcessFinancDto.setFinanceNeedPerformance(BigDecimal.ZERO);
        }
        if (null == erpProcessFinancDto.getTransferRealPerformance()) {
            erpProcessFinancDto.setTransferRealPerformance(BigDecimal.ZERO);
        }
        if (null == erpProcessFinancDto.getSecondhandRealPerformance()) {
            erpProcessFinancDto.setSecondhandRealPerformance(BigDecimal.ZERO);
        }
        if (null == erpProcessFinancDto.getNewhouseRealPerformance()) {
            erpProcessFinancDto.setNewhouseRealPerformance(BigDecimal.ZERO);
        }
        if (null == erpProcessFinancDto.getLeaseRealPerformance()) {
            erpProcessFinancDto.setLeaseRealPerformance(BigDecimal.ZERO);
        }
        if (null == erpProcessFinancDto.getFinanceRealPerformance()) {
            erpProcessFinancDto.setFinanceRealPerformance(BigDecimal.ZERO);
        }
        if (null == erpProcessFinancDto.getTotalNeedPerformance()) {
            erpProcessFinancDto.setTotalNeedPerformance(BigDecimal.ZERO);
        }
        if (null == erpProcessFinancDto.getTotalRealPerformance()) {
            erpProcessFinancDto.setTotalRealPerformance(BigDecimal.ZERO);
        }
        if (null == erpProcessFinancDto.getTotalNeedIncome()) {
            erpProcessFinancDto.setTotalNeedIncome(BigDecimal.ZERO);
        }
        if (null == erpProcessFinancDto.getTotalRealIncome()) {
            erpProcessFinancDto.setTotalRealIncome(BigDecimal.ZERO);
        }

        List<NewStandardProfitVo> standardProfitVos = new ArrayList<NewStandardProfitVo>();
        List<Integer> typeList = new ArrayList<>();
        /*****初始化整合最外层数据结构*****/
        for (ErpFunPerformanceType erpFunPerformanceType : list) {
            if (null != erpFunPerformanceType.getCollectionType()) {
				NewStandardProfitVo newStandardProfitVo  = new NewStandardProfitVo();
				if(erpFunPerformanceType.getCollectionType() == 1) {
					if(erpProcessFinancDto.getTransferNeedPerformance().doubleValue() <=0 && erpProcessFinancDto.getTransferRealPerformance().doubleValue() <=0) {
						continue;
					}
				}else if(erpFunPerformanceType.getCollectionType() == 2) {
					if(erpProcessFinancDto.getSecondhandNeedPerformance().doubleValue() <=0 && erpProcessFinancDto.getSecondhandRealPerformance().doubleValue() <=0) {
						continue;
					}
				}else if(erpFunPerformanceType.getCollectionType() == 3) {
					if(erpProcessFinancDto.getNewhouseNeedPerformance().doubleValue() <=0 && erpProcessFinancDto.getNewhouseRealPerformance().doubleValue() <=0) {
						continue;
					}
				}else if(erpFunPerformanceType.getCollectionType() == 4) {
					if(erpProcessFinancDto.getLeaseNeedPerformance().doubleValue() <=0 && erpProcessFinancDto.getLeaseRealPerformance().doubleValue() <=0) {
						continue;
					}
				}else if(erpFunPerformanceType.getCollectionType() == 5) {
					if(erpProcessFinancDto.getFinanceNeedPerformance().doubleValue() <=0 && erpProcessFinancDto.getFinanceRealPerformance().doubleValue() <=0) {
						continue;
					}
				}
                newStandardProfitVo.setPerformanceType(erpFunPerformanceType.getCollectionType().intValue());
                newStandardProfitVo.setTotalProportion(BigDecimal.ZERO);
                newStandardProfitVo.setTotalProfitMoney(BigDecimal.ZERO);
                newStandardProfitVo.setTotalReceivableMoney(BigDecimal.ZERO);
                newStandardProfitVo.setTotalCompReceivableMoney(BigDecimal.ZERO);
                newStandardProfitVo.setTotalCompProfitMoney(BigDecimal.ZERO);
                newStandardProfitVo.setTotalMoney(BigDecimal.ZERO);
                if (!typeList.contains(erpFunPerformanceType.getCollectionType().intValue())) {
                    typeList.add(erpFunPerformanceType.getCollectionType().intValue());
                    standardProfitVos.add(newStandardProfitVo);
                }
            }
        }

        ErpFunProfitExample erpFunProfitExample = new ErpFunProfitExample();
        erpFunProfitExample.setShardCityId(cityId);
        ErpFunProfitExample.Criteria criteria = erpFunProfitExample.createCriteria();
        criteria.andDealIdEqualTo(dealId);
        /***判断是否玛雅房基地定制***/
        AdminFunComp adminFunComp = adminFunCompMapper.selectByPrimaryKey(getOperator().getAdminCompId());
        if (null != adminFunComp) {
            if (adminFunComp.getCompManagementModel() == 2 && adminFunComp.getCustomizedType() == 1) {
				List<Byte> profitTypeList = new ArrayList<Byte>();
				profitTypeList.add((byte) 0);
				profitTypeList.add((byte) 2);
				criteria.andProfitTypeIn(profitTypeList);
            }
        }
        /***查询到业绩列表元数据****/
        List<ErpFunProfit> profitList = erpFunProfitMapper.selectByExample(erpFunProfitExample);
        List<Integer> userIdList = new ArrayList<>();
        List<Integer> archiveIdList = new ArrayList<>();
        List<Integer> grIdList = new ArrayList<>();
        List<ErpFunProfitStandVo> profitListVo = new ArrayList<ErpFunProfitStandVo>();
        /***对业绩列表元数据进行循环，处理业绩所属人分组信息，业绩类别的别名****/
    	typeList = new ArrayList<>();
        for (ErpFunProfit erpFunProfit : profitList) {
    		if(!typeList.contains(erpFunProfit.getPerformanceType().intValue())) {
    			typeList.add(erpFunProfit.getPerformanceType().intValue());
    		}
            ErpFunProfitStandVo erpFunProfitStandVo = new ErpFunProfitStandVo();
            ConvertUtils.register(new DateConverter(null), java.util.Date.class);
            BeanUtils.copyProperties(erpFunProfitStandVo, erpFunProfit);    //PO复制，把前面的复制给后面
            if (null != erpFunProfitStandVo.getPerformanceId()) {
                if (null != performanceTypeMap.get(erpFunProfitStandVo.getPerformanceId())) {
                    erpFunProfitStandVo.setPerformanceNameAlias(performanceTypeMap.get(erpFunProfitStandVo.getPerformanceId()).getAlias());
                }
            } else {
                erpFunProfitStandVo.setPerformanceNameAlias("");
            }
            profitListVo.add(erpFunProfitStandVo);
            if (null != erpFunProfit.getUserId()) {
                if (!userIdList.contains(erpFunProfit.getUserId())) {
                    userIdList.add(erpFunProfit.getUserId());
                }
                if (!grIdList.contains(erpFunProfit.getGrId())) {
                    grIdList.add(erpFunProfit.getGrId());
                }
            }
            if (null != erpFunProfit.getArchiveId()) {
                if (!archiveIdList.contains(erpFunProfit.getArchiveId())) {
                    archiveIdList.add(erpFunProfit.getArchiveId());
                }
            }
        }
    	/****如果财务款项被全部删除，则根据业绩类型初始化款项记录****/
        if(standardProfitVos.size() == 0) {
        	for (Integer type : typeList) {
        		NewStandardProfitVo newStandardProfitVo  = new NewStandardProfitVo();
        		newStandardProfitVo.setPerformanceType(type);
				newStandardProfitVo.setTotalProportion(BigDecimal.ZERO);
				newStandardProfitVo.setTotalProfitMoney(BigDecimal.ZERO);
				newStandardProfitVo.setTotalReceivableMoney(BigDecimal.ZERO);
				newStandardProfitVo.setTotalCompReceivableMoney(BigDecimal.ZERO);
				newStandardProfitVo.setTotalCompProfitMoney(BigDecimal.ZERO);
				newStandardProfitVo.setTotalMoney(BigDecimal.ZERO);
				standardProfitVos.add(newStandardProfitVo);
			}
        }
        /*****查询员工姓名及是否注销******/
        if (userIdList.size() > 0) {
            ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
            erpFunUsersExample.setShardCityId(cityId);
            erpFunUsersExample.createCriteria().andCompIdEqualTo(compId).andUserIdIn(userIdList);
            List<ErpFunUsers> erpFunUsers = erpFunUsersMapper.selectByExample(erpFunUsersExample);
            /****获取员工门店名称VO*****/
            List<ErpUserDeptNameVo> deptNameVos = erpFunUsersMapper.getDeptNameByUserIds(cityId, compId, userIdList);
            Map<Integer, ErpFunUsers> funUserMap = new HashMap<Integer, ErpFunUsers>();
            Map<Integer, String> userDeptNameMap = new HashMap<Integer, String>();
            if (null != erpFunUsers && erpFunUsers.size() > 0) {
                funUserMap = erpFunUsers.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, ErpFunUsers -> ErpFunUsers));
                if (null != deptNameVos && deptNameVos.size() > 0) {
                    /****员工门店名称VO List转化为map****/
                    userDeptNameMap = deptNameVos.stream().collect(Collectors.toMap(ErpUserDeptNameVo::getUserId, ErpUserDeptNameVo::getDeptName));
                }
                /*****将员工名称，离职状态，门店名称放入业绩VO*****/
                for (ErpFunProfitStandVo funProfitStandVo : profitListVo) {
                    if (null != funProfitStandVo.getUserId()) {
                        funProfitStandVo.setUserName(funUserMap.get(funProfitStandVo.getUserId()).getUserName());
                        funProfitStandVo.setUserWriteOff(funUserMap.get(funProfitStandVo.getUserId()).getUserWriteoff());
                        /****门店名称***/
                        funProfitStandVo.setDeptName(userDeptNameMap.get(funProfitStandVo.getUserId()));
                    } else {
                        funProfitStandVo.setUserName("");
                        /****门店名称***/
                        funProfitStandVo.setDeptName("");
                    }
                }
            }
        }
        /****查询员工当前最新的门店ID******/
        if (archiveIdList.size() > 0) {
            ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
            erpFunUsersExample.setShardCityId(cityId);
            erpFunUsersExample.createCriteria().andArchiveIdIn(archiveIdList).andUserWriteoffEqualTo(false);
            List<ErpFunUsers> erpFunUsers = erpFunUsersMapper.selectByExample(erpFunUsersExample);
            Map<Integer, ErpFunUsers> funUserMap = new HashMap<Integer, ErpFunUsers>();
            if (null != erpFunUsers && erpFunUsers.size() > 0) {
                funUserMap = erpFunUsers.stream().collect(Collectors.toMap(ErpFunUsers::getArchiveId, ErpFunUsers -> ErpFunUsers));
                for (ErpFunProfitStandVo funProfitStandVo : profitListVo) {
                    if (null != funProfitStandVo.getArchiveId()) {
                        if (null != funUserMap.get(funProfitStandVo.getArchiveId())) {
                            funProfitStandVo.setUserRealDeptId(funUserMap.get(funProfitStandVo.getArchiveId()).getDeptId());
                        }
                    }
                }
            }
        }
        /*****查询员工分组名称******/
        if (grIdList.size() > 0) {
            ErpFunDeptsgroupExample deptsgroupExample = new ErpFunDeptsgroupExample();
            deptsgroupExample.setShardCityId(cityId);
            deptsgroupExample.createCriteria().andCompIdEqualTo(compId).andGrIdIn(grIdList);
            List<ErpFunDeptsgroup> deptsgroups = erpFunDeptsgroupMapper.selectByExample(deptsgroupExample);
            Map<Integer, String> groupMap = new HashMap<Integer, String>();
            if (null != deptsgroups && deptsgroups.size() > 0) {
                groupMap = deptsgroups.stream().collect(Collectors.toMap(ErpFunDeptsgroup::getGrId, ErpFunDeptsgroup::getGrName));
                for (ErpFunProfitStandVo funProfitStandVo : profitListVo) {
                    if (null != funProfitStandVo.getUserId()) {
                        funProfitStandVo.setGrName(groupMap.get(funProfitStandVo.getUserId()));
                    }
                }
            }
        }

        for (ErpFunPerformanceType erpFunPerformanceType : list) {
            boolean hasProfit = false;
            for (ErpFunProfitStandVo erpFunProfit : profitListVo) {
                if (erpFunPerformanceType.getPerformanceId().equals(erpFunProfit.getPerformanceId()) || erpFunPerformanceType.getAlias().equals(erpFunProfit.getPerformanceName())) {
                    hasProfit = true;
                }
            }
            if (!hasProfit) {
                if (null != erpFunPerformanceType.getCollectionType()) {
                    ErpFunProfitStandVo erpFunProfit = new ErpFunProfitStandVo();
                    erpFunProfit.setProfitProportion(erpFunPerformanceType.getPerformanceProportion());
                    erpFunProfit.setCompId(compId);
                    erpFunProfit.setDealId(dealId);
                    erpFunProfit.setPerformanceName(erpFunPerformanceType.getAlias());
                    erpFunProfit.setPerformanceId(erpFunPerformanceType.getPerformanceId());
                    erpFunProfit.setPerformanceType(erpFunPerformanceType.getCollectionType());
                    profitListVo.add(erpFunProfit);
                }
            }
        }

        /***查询公司业绩****/
        ErpFunProfitExample compExample = new ErpFunProfitExample();
        compExample.setShardCityId(cityId);
        compExample.createCriteria().andDealIdEqualTo(dealId).andProfitTypeEqualTo((byte) 1).andCompIdEqualTo(compId);
        List<ErpFunProfit> compProfitList = erpFunProfitMapper.selectByExample(compExample);
        BigDecimal compReceivableMoney = new BigDecimal(0);
        for (ErpFunProfit erpFunProfit : compProfitList) {
            compReceivableMoney = compReceivableMoney.add(erpFunProfit.getReceivableMoney());
        }

        for (NewStandardProfitVo newStandardProfitVo : standardProfitVos) {
            List<ErpFunProfitStandVo> profitStandVosByType = new ArrayList<>();
            for (ErpFunProfitStandVo erpFunProfit : profitListVo) {
                if (erpFunProfit.getPerformanceType().intValue() == newStandardProfitVo.getPerformanceType()) {
                    profitStandVosByType.add(erpFunProfit);
                    if (erpFunProfit.getProfitId() != null) {
                        newStandardProfitVo.setTotalProportion(newStandardProfitVo.getTotalProportion().add(erpFunProfit.getProfitProportion()));
                        newStandardProfitVo.setTotalProfitMoney(newStandardProfitVo.getTotalProfitMoney().add(erpFunProfit.getProfitMoney()));
                        newStandardProfitVo.setTotalReceivableMoney(newStandardProfitVo.getTotalReceivableMoney().add(null == erpFunProfit.getReceivableMoney() ? BigDecimal.ZERO : erpFunProfit.getReceivableMoney()));
                        newStandardProfitVo.setTotalMoney(newStandardProfitVo.getTotalMoney().add(erpFunProfit.getProfitMoney()));
                    }
                }
            }
            /***计算该业绩列表公司的拆佣金额及比例****/
            for (ErpFunProfit erpFunProfit : compProfitList) {
                if (erpFunProfit.getPerformanceType().intValue() == newStandardProfitVo.getPerformanceType()) {
                    newStandardProfitVo.setCompProportion(erpFunProfit.getProfitProportion());
                    if(isHouseBase(getOperator().getAdminCompId())){
                    	newStandardProfitVo.setCompProportion(BigDecimal.ZERO);
                    }
                    newStandardProfitVo.setTotalCompReceivableMoney(newStandardProfitVo.getTotalCompReceivableMoney().add(erpFunProfit.getReceivableMoney()));
                    newStandardProfitVo.setTotalCompProfitMoney(newStandardProfitVo.getTotalCompProfitMoney().add(erpFunProfit.getProfitMoney()));
                }
            }
            newStandardProfitVo.setProfitListVo(profitStandVosByType);
        }

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("compReceivableMoney", compReceivableMoney);
        resultMap.put("erpProcessFinancDto", erpProcessFinancDto);
        resultMap.put("profitList", standardProfitVos);

        return ErpResponseJson.ok(resultMap);
    }

    /**
     * 查询业绩
     *
     * @param param
     * @return
     */
    @ApiOperation("查询业绩")
    @ApiResponses({@ApiResponse(code = 200, response = AppDealProfitListResultVO.class, message = "success")})
    @PostMapping("/getAppDealProfitList")
    public ResponseJson getAppDealProfitList(@RequestBody AppDealProfitListParam param) {
        Integer dealId = param.getDealId();
        Integer cityId = getOperator().getCityId();
        ErpFunProfitExample example = new ErpFunProfitExample();
        example.setShardCityId(cityId);
        if (param.getProfitType() == null) {
            example.createCriteria().andDealIdEqualTo(dealId);
        } else {
            example.createCriteria().andDealIdEqualTo(dealId).andProfitTypeEqualTo(param.getProfitType());
        }
        List<ErpFunProfit> profitList = erpFunProfitMapper.selectByExample(example);
        List<AppDealProfitVO> list = new ArrayList<>();
        for (int i = 0; i < profitList.size(); i++) {
            ErpFunProfit erpFunProfit = profitList.get(i);
            AppDealProfitVO appDealProfitVO = new AppDealProfitVO();
            org.springframework.beans.BeanUtils.copyProperties(erpFunProfit, appDealProfitVO);
            list.add(appDealProfitVO);
        }
        AppDealProfitListResultVO appDealProfitListResultVO = new AppDealProfitListResultVO();
        appDealProfitListResultVO.setDealProfitListVO(list);
        return ErpResponseJson.ok(appDealProfitListResultVO);
    }


    /**
     * 权证流程 - 获取全公司流程模板列表
     * flj
     * 2017/09/26
     *
     * @return
     */
    @RequestMapping("/getProcessModelList")
    public ResponseJson getProcessModelList(@RequestBody BaseMapParam param) {
        Integer cityId = getOperator().getCityId();
        Integer compId = getOperator().getCompId();
        ErpProcessModelExample example = new ErpProcessModelExample();
        example.setShardCityId(cityId);
        example.createCriteria().andCompIdEqualTo(compId);
        int count = erpProcessModelMapper.countByExample(example);
        //首先查询数量，如果当前没有数量那么就先初始化公司模板数据
        if (count <= 0) {
            //初始化公司模板数据
            erpProcessModelService.initCompProcessModelList(cityId, compId);
            count = erpProcessModelMapper.countByExample(example);
        }
        List<Map<String, Object>> processModelList = erpProcessModelMapper.selectProcessModelListByCompId(cityId, compId, param.getPageOffset(), param.getPageRows());
        ErpResponseJson responseJson = new ErpResponseJson();
        responseJson.setData(processModelList);
        responseJson.setTotal(Long.valueOf(count));
        return responseJson;
    }

    /**
     * app获取全公司流程模板列表
     *
     * @return
     */
    @ApiOperation("app获取全公司流程模板列表")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = GetProcessModelListResultVO.class, message = "成功")
    })
    @PostMapping("/getAppProcessModelList")
    public ResponseJson getAppProcessModelList() {
        Integer cityId = getOperator().getCityId();
        Integer compId = getOperator().getCompId();
        ErpProcessModelExample example = new ErpProcessModelExample();
        example.setShardCityId(cityId);
        example.createCriteria().andCompIdEqualTo(compId);
        int count = erpProcessModelMapper.countByExample(example);
        //首先查询数量，如果当前没有数量那么就先初始化公司模板数据
        if (count <= 0) {
            //初始化公司模板数据
            erpProcessModelService.initCompProcessModelList(cityId, compId);
        }
        List<Map<String, Object>> processModelList = erpProcessModelMapper.selectProcessModelListByCompId(cityId, compId, 1, 1000);
        List<GetProcessModelListVO> list = new ArrayList<>();
        for (int i = 0; i < processModelList.size(); i++) {
            Map<String, Object> map = processModelList.get(i);
            GetProcessModelListVO getProcessModelListVO = new GetProcessModelListVO();
            try {
                BeanUtils.populate(getProcessModelListVO, map);
            } catch (Exception e) {
                e.printStackTrace();
            }
            list.add(getProcessModelListVO);
        }
        GetProcessModelListResultVO getProcessModelListResultVO = new GetProcessModelListResultVO();
        getProcessModelListResultVO.setProcessModelListVO(list);
        return ErpResponseJson.ok(getProcessModelListResultVO);
    }

    /**
     * 权证流程 - 获取公司生成的权证流程列表
     * flj
     * 2017/09/26
     *
     * @return
     */
    @ApiOperation("pc获取合同流程列表")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = MgrWarrantStepListVO.class, message = "成功")
    })
    @PostMapping("/getMgrWarrantStepList")
    public ResponseJson getMgrWarrantStepList(@RequestBody MgrWarrantStepListParam param) {
        Integer cityId = getOperator().getCityId();
        Integer compId = getOperator().getCompId();
        Integer dealId = param.getDealId();
        MgrWarrantStepListVO returnVO = new MgrWarrantStepListVO();
		/*ErpProcessRuntimeStepExample example = new ErpProcessRuntimeStepExample();
		example.setShardCityId(cityId);
		example.createCriteria().andCompIdEqualTo(compId).andDelFlagEqualTo(new Byte("0")).andDealIdEqualTo(dealId);
		example.setOrderByClause("SEQ_SORT asc, STEP_SEQ asc");
		List<ErpProcessRuntimeStep> list = erpProcessRuntimeStepMapper.selectByExample(example);*/
        // dyh 返回 执行人，提醒人的archiveId IM用
        List<ErpProcessRuntimeStepDto> runtimeStepDtoList = erpProcessRuntimeStepMapper.getMgrWarrantStepList(cityId, compId, dealId);
        //执行人
        Set<Integer> executorSet = runtimeStepDtoList.stream().collect(Collectors.mapping(step -> step.getExecutor(), Collectors.toSet()));
        //提醒人
        Set<Integer> reminderSet = runtimeStepDtoList.stream().collect(Collectors.mapping(step -> step.getReminderId(), Collectors.toSet()));
        //指定提醒人
        Set<Integer> warnerSet = runtimeStepDtoList.stream().collect(Collectors.mapping(step -> step.getWarner(), Collectors.toSet()));

        Set<Integer> updateUsetSet = runtimeStepDtoList.stream().collect(Collectors.mapping(step -> step.getUpdateUser(), Collectors.toSet()));
        Set<Integer> userIdSet = new HashSet<>();
        userIdSet.addAll(executorSet);
        userIdSet.addAll(reminderSet);
        userIdSet.addAll(warnerSet);
        userIdSet.addAll(updateUsetSet);
        returnVO.setList(runtimeStepDtoList);
        if (userIdSet.isEmpty()) {
            return ErpResponseJson.ok(returnVO);
        }
        List<ErpFunUsers> usersList = erpFunUsersMapper.getUserListByUserIds(cityId, userIdSet);
        Map<Integer, Integer> archiveIdMap = usersList.stream().collect(Collectors.toMap(user -> user.getUserId(), user -> user.getArchiveId()));
        runtimeStepDtoList.forEach(stepDto -> {
            stepDto.setExecutorArchiveId(archiveIdMap.get(stepDto.getExecutor()));
            stepDto.setReminderArchiveId(archiveIdMap.get(stepDto.getReminderId()));
            stepDto.setWarnerArchiveId(archiveIdMap.get(stepDto.getWarner()));
            stepDto.setUpdateUserArchiveId(archiveIdMap.get(stepDto.getUpdateUser()));
        });

        // 查询条件步骤
        ErpProcessModel erpProcessModel = erpProcessModelMapper.getModelByDealId(cityId, dealId);
        if (null != erpProcessModel) {
            returnVO.setConditionStepId(erpProcessModel.getConditionStepId());
            returnVO.setConditionStepIds(erpProcessModel.getConditionStepIds());
        }
        return ErpResponseJson.ok(returnVO);
    }

    @ApiOperation("app获取公司生成的权证流程列表")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = AppMgrWarrantStepListResultVO.class, message = "成功")
    })
    @PostMapping("/getAppMgrWarrantStepList")
    public ResponseJson getAppMgrWarrantStepList(@RequestBody AppMgrWarrantStepListParam param) {
        Integer cityId = getOperator().getCityId();
        Integer compId = getOperator().getCompId();
        Integer dealId = param.getDealId();
        AppMgrWarrantStepListResultVO appMgrWarrantStepListResultVO = new AppMgrWarrantStepListResultVO();
		/*ErpProcessRuntimeStepExample example = new ErpProcessRuntimeStepExample();
		example.setShardCityId(cityId);
		example.createCriteria().andCompIdEqualTo(compId).andDelFlagEqualTo(new Byte("0")).andDealIdEqualTo(dealId);
		example.setOrderByClause("SEQ_SORT asc, STEP_SEQ asc");
		List<ErpProcessRuntimeStep> list = erpProcessRuntimeStepMapper.selectByExample(example);*/
        // dyh 返回 执行人，提醒人的archiveId IM用
        List<ErpProcessRuntimeStepDto> runtimeStepDtoList = erpProcessRuntimeStepMapper.getMgrWarrantStepList(cityId, compId, dealId);
        //执行人
        Set<Integer> executorSet = runtimeStepDtoList.stream().map(ErpProcessRuntimeStep::getExecutor).collect(Collectors.toSet());
        //提醒人
        Set<Integer> reminderSet = runtimeStepDtoList.stream().map(ErpProcessRuntimeStep::getReminderId).collect(Collectors.toSet());
        //指定提醒人
        Set<Integer> warnerSet = runtimeStepDtoList.stream().map(ErpProcessRuntimeStep::getWarner).collect(Collectors.toSet());

        Set<Integer> updateUsetSet = runtimeStepDtoList.stream().map(ErpProcessRuntimeStep::getUpdateUser).collect(Collectors.toSet());
        Set<Integer> userIdSet = new HashSet<>();
        userIdSet.addAll(executorSet);
        userIdSet.addAll(reminderSet);
        userIdSet.addAll(warnerSet);
        userIdSet.addAll(updateUsetSet);

        List<ErpProcessRuntimeStepDto> appmgrwarrantsteplist = new ArrayList<>();
        if (userIdSet.isEmpty()) {
            appMgrWarrantStepListResultVO.setStepList(appmgrwarrantsteplist);
            return ErpResponseJson.ok(appMgrWarrantStepListResultVO);
        }
        List<ErpFunUsers> usersList = erpFunUsersMapper.getUserListByUserIds(cityId, userIdSet);
        Map<Integer, Integer> archiveIdMap = usersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, ErpFunUsers::getArchiveId));

        runtimeStepDtoList.forEach(stepDto -> {
            stepDto.setExecutorArchiveId(archiveIdMap.get(stepDto.getExecutor()));
            stepDto.setReminderArchiveId(archiveIdMap.get(stepDto.getReminderId()));
            stepDto.setWarnerArchiveId(archiveIdMap.get(stepDto.getWarner()));
            stepDto.setUpdateUserArchiveId(archiveIdMap.get(stepDto.getUpdateUser()));
            ErpProcessRuntimeStepDto appMgrWarrantStepListVO = new ErpProcessRuntimeStepDto();
            org.springframework.beans.BeanUtils.copyProperties(stepDto, appMgrWarrantStepListVO);

            if (getOperator().isMobileApi()) {
                String executorName = stepDto.getExecutorName();
                if (StringUtils.isNotBlank(executorName)) {
                    if (executorName.contains("(")) {
                        appMgrWarrantStepListVO.setExecutorName(executorName.substring(0, executorName.indexOf("(")));
                    }
                    if (executorName.contains("（")) {
                        appMgrWarrantStepListVO.setExecutorName(executorName.substring(0, executorName.indexOf("（")));
                    }
                }
                String updateUsername = stepDto.getUpdateUsername();
                if (StringUtils.isNotBlank(updateUsername)) {
                    if (updateUsername.contains("(")) {
                        appMgrWarrantStepListVO.setUpdateUsername(updateUsername.substring(0, updateUsername.indexOf("(")));
                    }
                    if (updateUsername.contains("（")) {
                        appMgrWarrantStepListVO.setUpdateUsername(updateUsername.substring(0, updateUsername.indexOf("（")));
                    }
                }
            }

            if (StringUtil.isNotEmpty(appMgrWarrantStepListVO.getTimelimitdate())) {
                appMgrWarrantStepListVO.setTimelimitdate(DateTimeHelper.formatDateTimetoString(appMgrWarrantStepListVO.getTimelimitdate(), "yyyy-MM-dd"));

                try {
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(appMgrWarrantStepListVO.getTimelimitdate());
                    Date nowDate = new SimpleDateFormat("yyyy-MM-dd").parse(LocalDate.now().toString());
                    if (nowDate.after(date)) {
                        appMgrWarrantStepListVO.setExpired(Byte.valueOf("1"));
                    } else {
                        appMgrWarrantStepListVO.setExpired(Byte.valueOf("0"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (StringUtil.isNotEmpty(appMgrWarrantStepListVO.getUpdateTime())) {
                appMgrWarrantStepListVO.setUpdateTime(DateTimeHelper.formatDateTimetoString(appMgrWarrantStepListVO.getUpdateTime(), "yyyy-MM-dd"));
            }
            if (StringUtil.isNotEmpty(appMgrWarrantStepListVO.getWarnTime())) {
                appMgrWarrantStepListVO.setWarnTime(DateTimeHelper.formatDateTimetoString(appMgrWarrantStepListVO.getWarnTime(), "yyyy-MM-dd"));
            }
            appmgrwarrantsteplist.add(appMgrWarrantStepListVO);
        });
        appMgrWarrantStepListResultVO.setStepList(appmgrwarrantsteplist);
        // 查询条件步骤
        ErpProcessModel erpProcessModel = erpProcessModelMapper.getModelByDealId(cityId, dealId);
        if (null != erpProcessModel) {
            appMgrWarrantStepListResultVO.setConditionStepIds(erpProcessModel.getConditionStepIds());
        }
        return ErpResponseJson.ok(appMgrWarrantStepListResultVO);
    }

    /**
     * 流程配置 - 获取公司生成的权证流程列表
     * flj
     * 2017/09/26
     *
     * @return
     */
    @RequestMapping("/getMgrStepModelDetail")
    public ResponseJson getMgrStepModelDetail(@RequestBody BaseMapParam param) {
        Integer cityId = getOperator().getCityId();
        Integer modelId = param.getInteger("modelId");
        List<ErpModelStepDetailDto> modelStepDetailList = erpModelStepRelateMapper.getMgrStepModelDetail(cityId, modelId);
        return ErpResponseJson.ok(modelStepDetailList);
    }

    /**
     * 流程配置 - 获取公司生成的权证流程列表
     * flj
     * 2017/09/26
     *
     * @return
     */
    @RequestMapping("/getMgrAllStepModelList")
    @ApiOperation("获取公司所有的步骤")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpProcessModelStep.class, message = "成功")
    })
    public ResponseJson getMgrAllStepModelList(@RequestBody BaseMapParam param) {
        Integer cityId = getOperator().getCityId();
        Integer compId = getOperator().getCompId();
        List<ErpProcessModelStep> list = erpProcessModelStepMapper.getMgrAllStepModelList(cityId, compId);
        return ErpResponseJson.ok(list);
    }

    @ApiOperation("app获取公司生成的权证流程步骤")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ProcessModelStepListResultVO.class, message = "成功")
    })
    @PostMapping("/getAppMgrAllStepModelList")
    public ResponseJson getAppMgrAllStepModelList() {
        Integer cityId = getOperator().getCityId();
        Integer compId = getOperator().getCompId();
        List<ProcessModelStepVO> list = erpProcessModelStepMapper.getProcessModelStepList(cityId, compId);
//		List<ProcessModelStepVO> processModelStepListVO = new ArrayList<>();
//		for(int i = 0;i<list.size();i++){
//			ErpProcessModelStep erpProcessModelStep = list.get(i);
//			ProcessModelStepVO processModelStepVO = new ProcessModelStepVO();
//			org.springframework.beans.BeanUtils.copyProperties(erpProcessModelStep, processModelStepVO);
//			processModelStepListVO.add(processModelStepVO);
//		}
        ProcessModelStepListResultVO processModelStepListResultVO = new ProcessModelStepListResultVO();
        processModelStepListResultVO.setProcessModelStepListVO(list);
        return ErpResponseJson.ok(processModelStepListResultVO);
    }

    /**
     * 税费信息，查询税费信息
     * flj
     * 2017/10/09
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/getPrintDataofTaxAndFee")
    public ResponseJson getPrintDataofTaxAndFee(@RequestBody BaseMapParam param) throws Exception {
        Integer cityId = getOperator().getCityId();
        Integer compId = getOperator().getCompId();
        Integer dealId = param.getInteger("dealId");
        Map<String, Object> returnMap = new HashMap<String, Object>();
        ErpFunDealTaxesExample example = new ErpFunDealTaxesExample();
        example.setShardCityId(cityId);
        example.createCriteria().andDealIdEqualTo(dealId).andPayTypeEqualTo(new Byte("0"));
        List<ErpFunDealTaxes> dealBuyTaxesList = erpFunDealTaxesMapper.selectByExample(example);
        Map<String, Object> fianacMap = new HashMap<String, Object>();
        Map<String, Object> commissionDataMap = getFinancCommissionInfo(cityId, compId, dealId);
        if (commissionDataMap != null) {
            fianacMap.putAll(commissionDataMap);
        }
        returnMap.put("buyTaxesinfo", dealBuyTaxesList);
        List<Map<String, Object>> commissionDataList = erpProcessFinancMapper.getFinancComssionInfoNameByDealId(cityId, compId, dealId);
        StringBuilder buyCommissionName = new StringBuilder();
        StringBuilder sellCommissionName = new StringBuilder();
        for (Map<String, Object> dataMap : commissionDataList) {
            Object pfPayerObject = dataMap.get("pfPayer");
            if (pfPayerObject != null) {
                String pfPayer = pfPayerObject.toString();
                Object pfNameObject = dataMap.get("pfName");
                if (pfNameObject != null) {
                    String pfName = pfNameObject.toString();
                    if (Constants_DIC.DIC_PFMAN_BUY.equals(pfPayer)) {
                        buyCommissionName.append(pfName).append(",");
                    } else if (Constants_DIC.DIC_PFMAN_SELL.equals(pfPayer)) {
                        sellCommissionName.append(pfName).append(",");
                    }
                }
            }
        }
        Map<String, Object> commissionMap = new HashMap<String, Object>();
        commissionMap.put("sellCommissionName", sellCommissionName);
        commissionMap.put("buyCommissionName", buyCommissionName);
        returnMap.put("commssion", commissionMap);
        ErpFunDealTaxesRecordExample erpFunDealTaxesRecordExample = new ErpFunDealTaxesRecordExample();
        erpFunDealTaxesRecordExample.setShardCityId(cityId);
        erpFunDealTaxesRecordExample.createCriteria().andDealIdEqualTo(dealId);
        List<ErpFunDealTaxesRecord> list = erpFunDealTaxesRecordMapper.selectByExample(erpFunDealTaxesRecordExample);
        for (ErpFunDealTaxesRecord erpFunDealTaxesRecord : list) {
            if ("0".equals(String.valueOf(erpFunDealTaxesRecord.getFeeType()))) {
                returnMap.put("buyTaxesRecord", erpFunDealTaxesRecord);
            } else if ("1".equals(String.valueOf(erpFunDealTaxesRecord.getFeeType()))) {
                returnMap.put("sellTaxesRecord", erpFunDealTaxesRecord);
            }
        }
        //买方税费打印单
        if (dealBuyTaxesList.isEmpty()) {
            ErpFunDealTaxesFatherExample funDealTaxesFatherExample = new ErpFunDealTaxesFatherExample();
            funDealTaxesFatherExample.setShardCityId(cityId);
            funDealTaxesFatherExample.createCriteria().andCompIdEqualTo(compId).andPayTypeEqualTo(new Byte("0"));
            List<ErpFunDealTaxesFather> fartherDealTaxesList = erpFunDealTaxesFatherMapper.selectByExample(funDealTaxesFatherExample);
            if (!fartherDealTaxesList.isEmpty()) {
                List<Integer> fartherList = BeanUtil.buildQueryTempKeys(fartherDealTaxesList, "id");
                if (!fartherList.isEmpty()) {
                    ErpFunDealTaxesSubExample funDealTaxesSubExample = new ErpFunDealTaxesSubExample();
                    funDealTaxesSubExample.setShardCityId(cityId);
                    funDealTaxesSubExample.createCriteria().andCompIdEqualTo(compId).andFatherIdIn(fartherList);
                    List<ErpFunDealTaxesSub> subDealTaxesList = erpFunDealTaxesSubMapper.selectByExample(funDealTaxesSubExample);
                    returnMap.put("getbuytaxestypedata", fartherDealTaxesList);
                    returnMap.put("getbuytaxesdetaileddata", subDealTaxesList);
                }
            }
            createInitProcessFinanc(cityId, compId, dealId, fianacMap);
        }
        returnMap.put("financ", fianacMap);
        example = new ErpFunDealTaxesExample();
        example.setShardCityId(cityId);
        example.createCriteria().andDealIdEqualTo(dealId).andPayTypeEqualTo(new Byte("1"));
        List<ErpFunDealTaxes> dealSellTaxesList = erpFunDealTaxesMapper.selectByExample(example);
        returnMap.put("sellTaxesinfo", dealSellTaxesList);
        if (dealSellTaxesList.isEmpty()) {
            ErpFunDealTaxesFatherExample funDealTaxesFatherExample = new ErpFunDealTaxesFatherExample();
            funDealTaxesFatherExample.setShardCityId(cityId);
            funDealTaxesFatherExample.createCriteria().andCompIdEqualTo(compId).andPayTypeEqualTo(new Byte("1"));
            List<ErpFunDealTaxesFather> fartherDealTaxesList = erpFunDealTaxesFatherMapper.selectByExample(funDealTaxesFatherExample);
            List<Integer> fartherList = BeanUtil.buildQueryTempKeys(fartherDealTaxesList, "id");
            if (!fartherList.isEmpty()) {
                ErpFunDealTaxesSubExample funDealTaxesSubExample = new ErpFunDealTaxesSubExample();
                funDealTaxesSubExample.setShardCityId(cityId);
                funDealTaxesSubExample.createCriteria().andCompIdEqualTo(compId).andFatherIdIn(fartherList);
                List<ErpFunDealTaxesSub> subDealTaxesList = erpFunDealTaxesSubMapper.selectByExample(funDealTaxesSubExample);
                returnMap.put("getselltaxestypedata", fartherDealTaxesList);
                returnMap.put("getselltaxesdetaileddata", subDealTaxesList);
            }
        }
        return ErpResponseJson.ok(returnMap);
    }

    @ApiOperation("税费信息，app查询税费信息")
    @ApiResponses({@ApiResponse(code = 200, response = PrintDataofTaxAndFeeResultVO.class, message = "success")})
    @PostMapping("/getAppPrintDataofTaxAndFee")
    public ResponseJson getAppPrintDataofTaxAndFee(@RequestBody PrintDataofTaxAndFeeParam param) throws Exception {
        Integer cityId = getOperator().getCityId();
        Integer compId = getOperator().getCompId();
        Integer dealId = param.getDealId();
        PrintDataofTaxAndFeeResultVO printDataofTaxAndFeeResultVO = new PrintDataofTaxAndFeeResultVO();

        ErpFunDealTaxesExample example = new ErpFunDealTaxesExample();
        example.setShardCityId(cityId);
        example.createCriteria().andDealIdEqualTo(dealId).andPayTypeEqualTo(new Byte("0")).andCheckFlagEqualTo(Byte.valueOf("1"));
        List<ErpFunDealTaxes> dealBuyTaxesList = erpFunDealTaxesMapper.selectByExample(example);
        if (!dealBuyTaxesList.isEmpty()) {
            List<FunDealTaxesVO> buyTaxesinfo = new ArrayList<>();
            for (int i = 0; i < dealBuyTaxesList.size(); i++) {
                ErpFunDealTaxes erpFunDealTaxes = dealBuyTaxesList.get(i);
                FunDealTaxesVO funDealTaxesVO = new FunDealTaxesVO();
                org.springframework.beans.BeanUtils.copyProperties(erpFunDealTaxes, funDealTaxesVO);
                if (StringUtil.isNotEmpty(funDealTaxesVO.getCreateTime())) {
                    funDealTaxesVO.setCreateTime(DateTimeHelper.formatDateTimetoString(funDealTaxesVO.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
                }
                buyTaxesinfo.add(funDealTaxesVO);
            }
            printDataofTaxAndFeeResultVO.setBuyTaxesinfo(buyTaxesinfo);
        }

        List<Map<String, Object>> commissionDataList = erpProcessFinancMapper.getFinancComssionInfoNameByDealId(cityId,
                compId, dealId);
        StringBuilder buyCommissionName = new StringBuilder();
        StringBuilder sellCommissionName = new StringBuilder();
        for (Map<String, Object> dataMap : commissionDataList) {
            Object pfPayerObject = dataMap.get("pfPayer");
            if (pfPayerObject != null) {
                String pfPayer = pfPayerObject.toString();
                Object pfNameObject = dataMap.get("pfName");
                if (pfNameObject != null) {
                    String pfName = pfNameObject.toString();
                    if (Constants_DIC.DIC_PFMAN_BUY.equals(pfPayer)) {
                        buyCommissionName.append(pfName).append(",");
                    } else if (Constants_DIC.DIC_PFMAN_SELL.equals(pfPayer)) {
                        sellCommissionName.append(pfName).append(",");
                    }
                }
            }
        }
        CommssionVO commssionVO = new CommssionVO();
        commssionVO.setSellCommissionName(sellCommissionName.toString());
        commssionVO.setBuyCommissionName(buyCommissionName.toString());
        printDataofTaxAndFeeResultVO.setCommssion(commssionVO);

        ErpFunDealTaxesRecordExample erpFunDealTaxesRecordExample = new ErpFunDealTaxesRecordExample();
        erpFunDealTaxesRecordExample.setShardCityId(cityId);
        erpFunDealTaxesRecordExample.createCriteria().andDealIdEqualTo(dealId);
        List<ErpFunDealTaxesRecord> list = erpFunDealTaxesRecordMapper.selectByExample(erpFunDealTaxesRecordExample);
        for (ErpFunDealTaxesRecord erpFunDealTaxesRecord : list) {
            FunDealTaxesRecordVO funDealTaxesRecordVO = new FunDealTaxesRecordVO();
            if ("0".equals(String.valueOf(erpFunDealTaxesRecord.getFeeType()))) {
                org.springframework.beans.BeanUtils.copyProperties(erpFunDealTaxesRecord, funDealTaxesRecordVO);
                printDataofTaxAndFeeResultVO.setBuyTaxesRecord(funDealTaxesRecordVO);
            } else if ("1".equals(String.valueOf(erpFunDealTaxesRecord.getFeeType()))) {
                org.springframework.beans.BeanUtils.copyProperties(erpFunDealTaxesRecord, funDealTaxesRecordVO);
                printDataofTaxAndFeeResultVO.setSellTaxesRecord(funDealTaxesRecordVO);
            }
        }
        Map<String, Object> fianacMap = new HashMap<String, Object>();
        Map<String, Object> commissionDataMap = getFinancCommissionInfo(cityId, compId, dealId);
        if (commissionDataMap != null) {
            fianacMap.putAll(commissionDataMap);
        }

        // 买方税费打印单
        if (dealBuyTaxesList.isEmpty()) {
            ErpFunDealTaxesFatherExample funDealTaxesFatherExample = new ErpFunDealTaxesFatherExample();
            funDealTaxesFatherExample.setShardCityId(cityId);
            funDealTaxesFatherExample.createCriteria().andCompIdEqualTo(compId).andPayTypeEqualTo(new Byte("0"));
            List<ErpFunDealTaxesFather> fartherDealTaxesList = erpFunDealTaxesFatherMapper
                    .selectByExample(funDealTaxesFatherExample);
            if (!fartherDealTaxesList.isEmpty()) {
                List<Integer> fartherList = BeanUtil.buildQueryTempKeys(fartherDealTaxesList, "id");
                if (!fartherList.isEmpty()) {
                    ErpFunDealTaxesSubExample funDealTaxesSubExample = new ErpFunDealTaxesSubExample();
                    funDealTaxesSubExample.setShardCityId(cityId);
                    funDealTaxesSubExample.createCriteria().andCompIdEqualTo(compId).andFatherIdIn(fartherList);
                    List<ErpFunDealTaxesSub> subDealTaxesList = erpFunDealTaxesSubMapper
                            .selectByExample(funDealTaxesSubExample);
                    List<FunDealTaxesFatherVO> getbuytaxestypedata = new ArrayList<>();
                    List<FunDealTaxesSubVO> getbuytaxesdetaileddata = new ArrayList<>();
                    for (int i = 0; i < fartherDealTaxesList.size(); i++) {
                        ErpFunDealTaxesFather erpFunDealTaxesFather = fartherDealTaxesList.get(i);
                        FunDealTaxesFatherVO funDealTaxesFatherVO = new FunDealTaxesFatherVO();
                        org.springframework.beans.BeanUtils.copyProperties(erpFunDealTaxesFather, funDealTaxesFatherVO);
                        getbuytaxestypedata.add(funDealTaxesFatherVO);
                    }
                    for (int i = 0; i < subDealTaxesList.size(); i++) {
                        ErpFunDealTaxesSub erpFunDealTaxesSub = subDealTaxesList.get(i);
                        FunDealTaxesSubVO funDealTaxesSubVO = new FunDealTaxesSubVO();
                        org.springframework.beans.BeanUtils.copyProperties(erpFunDealTaxesSub, funDealTaxesSubVO);
                        getbuytaxesdetaileddata.add(funDealTaxesSubVO);
                    }
                    printDataofTaxAndFeeResultVO.setGetbuytaxestypedata(getbuytaxestypedata);
                    printDataofTaxAndFeeResultVO.setGetbuytaxesdetaileddata(getbuytaxesdetaileddata);
                }
            }
            createInitProcessFinanc(cityId, compId, dealId, fianacMap);
        }

        FinancVO financ = new FinancVO();
        BeanUtils.populate(financ, fianacMap);
        printDataofTaxAndFeeResultVO.setFinanc(financ);

        example = new ErpFunDealTaxesExample();
        example.setShardCityId(cityId);
        example.createCriteria().andDealIdEqualTo(dealId).andPayTypeEqualTo(new Byte("1")).andCheckFlagEqualTo(Byte.valueOf("1"));
        List<ErpFunDealTaxes> dealSellTaxesList = erpFunDealTaxesMapper.selectByExample(example);
        if (!dealSellTaxesList.isEmpty()) {
            List<FunDealTaxesVO> sellTaxesinfo = new ArrayList<>();
            for (int i = 0; i < dealSellTaxesList.size(); i++) {
                ErpFunDealTaxes erpFunDealTaxes = dealSellTaxesList.get(i);
                FunDealTaxesVO funDealTaxesVO = new FunDealTaxesVO();
                org.springframework.beans.BeanUtils.copyProperties(erpFunDealTaxes, funDealTaxesVO);
                if (StringUtil.isNotEmpty(funDealTaxesVO.getCreateTime())) {
                    funDealTaxesVO.setCreateTime(DateTimeHelper.formatDateTimetoString(funDealTaxesVO.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
                }
                sellTaxesinfo.add(funDealTaxesVO);
            }
            printDataofTaxAndFeeResultVO.setSellTaxesinfo(sellTaxesinfo);
        }

        if (dealSellTaxesList.isEmpty()) {
            ErpFunDealTaxesFatherExample funDealTaxesFatherExample = new ErpFunDealTaxesFatherExample();
            funDealTaxesFatherExample.setShardCityId(cityId);
            funDealTaxesFatherExample.createCriteria().andCompIdEqualTo(compId).andPayTypeEqualTo(new Byte("1"));
            List<ErpFunDealTaxesFather> fartherDealTaxesList = erpFunDealTaxesFatherMapper
                    .selectByExample(funDealTaxesFatherExample);
            List<Integer> fartherList = BeanUtil.buildQueryTempKeys(fartherDealTaxesList, "id");
            if (!fartherList.isEmpty()) {
                ErpFunDealTaxesSubExample funDealTaxesSubExample = new ErpFunDealTaxesSubExample();
                funDealTaxesSubExample.setShardCityId(cityId);
                funDealTaxesSubExample.createCriteria().andCompIdEqualTo(compId).andFatherIdIn(fartherList);
                List<ErpFunDealTaxesSub> subDealTaxesList = erpFunDealTaxesSubMapper
                        .selectByExample(funDealTaxesSubExample);

                List<FunDealTaxesFatherVO> getselltaxestypedata = new ArrayList<>();
                List<FunDealTaxesSubVO> getselltaxesdetaileddata = new ArrayList<>();
                for (int i = 0; i < fartherDealTaxesList.size(); i++) {
                    ErpFunDealTaxesFather erpFunDealTaxesFather = fartherDealTaxesList.get(i);
                    FunDealTaxesFatherVO funDealTaxesFatherVO = new FunDealTaxesFatherVO();
                    org.springframework.beans.BeanUtils.copyProperties(erpFunDealTaxesFather, funDealTaxesFatherVO);
                    getselltaxestypedata.add(funDealTaxesFatherVO);
                }
                for (int i = 0; i < subDealTaxesList.size(); i++) {
                    ErpFunDealTaxesSub erpFunDealTaxesSub = subDealTaxesList.get(i);
                    FunDealTaxesSubVO funDealTaxesSubVO = new FunDealTaxesSubVO();
                    org.springframework.beans.BeanUtils.copyProperties(erpFunDealTaxesSub, funDealTaxesSubVO);
                    getselltaxesdetaileddata.add(funDealTaxesSubVO);
                }
                printDataofTaxAndFeeResultVO.setGetselltaxestypedata(getselltaxestypedata);
                printDataofTaxAndFeeResultVO.setGetselltaxesdetaileddata(getselltaxesdetaileddata);
            }
        }
        return ErpResponseJson.ok(printDataofTaxAndFeeResultVO);
    }


    private void createInitProcessFinanc(Integer cityId, Integer compId, Integer dealId, Map<String, Object> returnMap) {
        Map<String, Object> dataMap = erpProcessFinancMapper.getInitProcessFinanc(cityId, compId, dealId);
        if (dataMap != null) {
            returnMap.put("mortgageAgencyFee", dataMap.get("paymentMortgage"));
            returnMap.put("transferAgencyFee", dataMap.get("paymentTransfer"));
            returnMap.put("havePaidDeposit", dataMap.get("paymentDeposit"));
        }
    }

    public Map<String, Object> getFinancCommissionInfo(Integer cityId, Integer compId, Integer dealId) {
        Map<String, Object> commisionInfoMap = erpProcessFinancMapper.getFinancComssionInfoByDealId(cityId, compId, dealId);
        return commisionInfoMap;
    }

    /**
     * 流程配置 - 获取公司生成的权证流程列表
     * flj
     * 2017/09/26
     *
     * @return
     */
    @ApiOperation("获取公司生成的权证流程列表")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = DealBusinessVo.class, message = "成功")
    })
    @PostMapping("/getDealPfActualList")
    public ResponseJson getDealPfActualList(@RequestBody QueryDealPfActualParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        String dateType = param.getDateType();
        param.setCityId(cityId);
        param.setCompId(compId);
        param.setCurrentUserId(operator.getUserId());
        param.setIsNewOrganization(getOperator().newOrganizationType());
        List<Map<String, Object>> returnList = new ArrayList<>();
        Map<String, Object> dataMap = new HashMap<>();
        ErpResponseJson responseJson = new ErpResponseJson();
        if (param.getPaymentId() != null) {
            if ("commission".equals(param.getPaymentId())) {
                ErpFunFinancPaymentExample example = new ErpFunFinancPaymentExample();
                example.setShardCityId(cityId);
                List<String> paymentNameList = new ArrayList<>();
                paymentNameList.add("佣金");
                paymentNameList.add("佣金包段");
                paymentNameList.add("佣金全包");
                example.createCriteria().andCompIdEqualTo(compId).andCanDelEqualTo(0).andPaymentNameIn(paymentNameList);
                List<ErpFunFinancPayment> list = erpFunFinancPaymentMapper.selectByExample(example);
                if (!list.isEmpty()) {
                    List<Integer> paymentIdList = list.stream().collect(Collectors.mapping(ErpFunFinancPayment::getPaymentId, Collectors.toList()));
                    param.setPaymentIds(paymentIdList.toArray());
                }
            }
        }
        if (dateType != null) {
            if ("AUDIT_DATE".equals(dateType)) {
                dateType = "B.AUDIT_TIME";
            } else {
                dateType = "A." + dateType;
            }
            param.setDateType(dateType);
        }
        String orderBy = param.getOrderBy();
        if (orderBy == null) {
            param.setOrderBy("A.DEAL_ID");
        } else {
            param.setOrderBy(BeanUtil.camelToUnderline(orderBy));
        }
        if(param.getUserId() !=null ){
			ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, param.getUserId());
			if(erpFunUsers.getUserLevel() !=null){
				param.setUserLevel(erpFunUsers.getUserLevel() + 2);
			}
		}

        //**********************统计分析组织架构改版********************************
        if(operator.newOrganizationType()){       //代表查询新组织架构*
            if(null != param.getOrganizationId()){//拼装WHERE 条件,如果不是COMP_ID就说明前端传了某个组织的ID，比如传了大区ID，就把这个大区的组织查出来把NAME拿出来拼装成WHERE条件
                GetSelectWhereParam getSelectWhereParam = new GetSelectWhereParam();
                getSelectWhereParam.setCityId(cityId);
                getSelectWhereParam.setUserId(param.getUserId());
                getSelectWhereParam.setPrefix("C.");
                getSelectWhereParam.setOrganizationId(param.getOrganizationId());
                param.setRangeColumn(erpFunOrganizationService.getSelectWhereTwo(getSelectWhereParam));
                if(0 == param.getOrganizationId()){//代表查询全公司
                    param.setRangeId(compId);
                } else {
                    param.setRangeId(param.getOrganizationId());
                }
            }
            //**********************组织架构改版********************************
        }
        Integer countTotal = null;
        List<ErpFunDeal> dealList = null;
        //1.查询合同列表
        if (!"1".equals(param.getIsExport())) {
            countTotal = erpFunDealMapper.getPfActualOffDealCount(cityId, param);
            if (countTotal == 0) {
                return responseJson;
            }
            PageHelper.startPage(param.getPageOffset(), param.getPageRows(), false);
        }
        dealList = erpFunDealMapper.getPfActualOffDealList(cityId, param);
        dataMap.put("dealList", dealList);
        int dealSize = dealList.size();
        if (dealSize > 0) {
            param.setDealSize(dealSize);
            List<Integer> dealIds = dealList.stream().collect(Collectors.mapping(ErpFunDeal::getDealId, Collectors.toList()));
            param.setDealIds(dealIds);
            //2.查询财务信息列表
            if (dealIds.size() > 0) {
                List<ErpProcessFinanc> processFinancList = erpProcessFinancMapper.getPfActualListOffDeal(cityId, param);
                dataMap.put("processfinancList", processFinancList);
            }
        }
        returnList.add(dataMap);
        responseJson.setData(returnList);
        if (null != countTotal) {
            responseJson.setTotal(Long.valueOf(countTotal));
        }
        return responseJson;
    }

    /**
     * 更新 税费类别
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/5/14
     */
    @ApiOperation("更新税费类别")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
    })
    @PostMapping("/insertTaxesData")
    public ErpResponseJson insertTaxesData(@RequestBody TaxesDataParam param) {
        List<TaxesDataOutParamDto> taxesSubList = param.getTaxesSubList();
        if (taxesSubList == null || taxesSubList.isEmpty()) {
            return ErpResponseJson.ok();
        }

        erpFunDealService.insertTaxesData(taxesSubList, getOperator().getCompId(), getOperator().getCityId());

        return ErpResponseJson.ok();
    }

    /**
     * 更新业绩类别列表
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/5/15
     */
    @ApiOperation("更新业绩类别列表")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/updateFunPerformanceTypeList")
    public ErpResponseJson updateFunPerformanceTypeList(@RequestBody ErpFunPerformanceTypeParam param) {
        List<ErpFunPerformanceType> list = JSON.parseArray(param.getPerformanceJson(), ErpFunPerformanceType.class);
        if (list.isEmpty()) {
            return ErpResponseJson.ok();
        }
        updatePerformanceList(list);
        return ErpResponseJson.ok();
    }

    /**
     * 更新业绩类别列表
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/5/15
     */
    @ApiOperation("更新APP业绩类别列表")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/updateAppFunPerformanceTypeList")
    public ErpResponseJson updateAPPFunPerformanceTypeList(@RequestBody UpdateFunPerformanceParam param) {
        List<ErpFunPerformanceType> list = param.getPerformanceTypeList();
        if (list.isEmpty()) {
            return ErpResponseJson.ok();
        }

        updatePerformanceList(list);
        return ErpResponseJson.ok();
    }

    private void updatePerformanceList(List<ErpFunPerformanceType> updatePerformanceList) {
        Integer compId = getOperator().getCompId();
        Integer cityId = getOperator().getCityId();
        Integer index = 0;
        for (ErpFunPerformanceType funPerformanceTypePO : updatePerformanceList) {

            if (StringUtil.isBlank(funPerformanceTypePO.getPerformanceName())) {
                continue;
            }

            index++;

            funPerformanceTypePO.setSeqNo(index);
            funPerformanceTypePO.setShardCityId(cityId);

            if (null == funPerformanceTypePO.getPerformanceId()) {// 不存在时新增
                funPerformanceTypePO.setCreateTime(new Date());
                funPerformanceTypePO.setCompId(compId);
                Integer hasunPerformanceTypeId = erpFunPerformanceTypeMapper.getHasunPerformanceTypeId(cityId, compId, funPerformanceTypePO.getPerformanceName());
                if (null == hasunPerformanceTypeId) {
                    funPerformanceTypePO.setCanDel(1);
                    erpFunPerformanceTypeMapper.insertSelective(funPerformanceTypePO);
                } else {
                    ErpFunPerformanceType erpFunPerformanceType = new ErpFunPerformanceType();
                    erpFunPerformanceType.setSeqNo(index);
                    erpFunPerformanceType.setPerformanceId(hasunPerformanceTypeId);
                    erpFunPerformanceType.setShardCityId(cityId);
                    erpFunPerformanceTypeMapper.updateByPrimaryKeySelective(erpFunPerformanceType);
                }
            } else {// 存在时通过主键修改
                erpFunPerformanceTypeMapper.updateByPrimaryKeySelective(funPerformanceTypePO);
            }
        }
    }

    /**
     * 获取权证流程列表-已办结列表
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/5/15
     */
    @ApiOperation("权证流程已办结列表")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ContractTaskListOfTransactVo.class, message = "成功")
    })
    @PostMapping("/getDealContractTaskListOfTransact")
    public ErpResponseJson getDealContractTaskListOfTransact(@RequestBody DealContractParam param) throws Exception {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        param.setCompId(operator.getCompId());
        param.setNewOrganization(operator.newOrganizationType());
        if (param.getDate() != null && param.getDate() != 4) {
            Map<String, String> returnMap = getTimeByDate(param.getDate());
            param.setStartTime(returnMap.get("START_TIME"));
            param.setStartTime(returnMap.get("END_TIME"));
        }
        if(param.getUserId() != null){
			ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, param.getUserId());
			if(erpFunUsers !=null){
				param.setUserLevel(erpFunUsers.getUserLevel() + 2);
			}
		}
        Integer count = erpFunDealMapper.getDealByMap(cityId, param);
        String orderBy = param.getOrderBy();
        if (StringUtils.isNotBlank(orderBy)) {
            param.setOrderBy(Const.dealContractTaskTransactOrderMap.get(orderBy) + param.getOrderType());
        }
        //PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
        List<ErpFunDealDto> returnList = erpFunDealMapper.getListOFExcuteByMap(cityId, param);
        //查询总条数，设置总条数
		/*Integer count=0;
		if (erpFunDealMap!=null) {
			count = Optional.ofNullable(erpFunDealMap.getAttr()).orElse(( 0));
			if (count==0) {
				return ErpResponseJson.ok();
			}
			//ThreadLocalUtil.setTOTAL(count);
		}*/
        if (returnList.isEmpty()) {
            return ErpResponseJson.ok();
        }
        List<Integer> repeatDealIds = returnList.stream().collect(Collectors.mapping(val -> val.getRepeatDealId(), Collectors.toList()));
        if (repeatDealIds.size() > 0) {
            List<ErpProcessRuntimeStep> proList = erpProcessRuntimeStepMapper.getListData(cityId, repeatDealIds);
            Map<Integer, Integer> returnMap = proList.stream().collect(Collectors.toMap(val -> val.getDealId(), val -> val.getStepSeq()));
            for (ErpFunDealDto erpFunDealDto : returnList) {
                Integer stepSeq = returnMap.get(erpFunDealDto.getRepeatDealId());
                if (stepSeq != null) {
                    erpFunDealDto.setStepNum(stepSeq);
                }
            }
        }
        PageInfo<ErpFunDealDto> pageInfo = new PageInfo<>(returnList);
        pageInfo.setTotal(count);
        ContractTaskListOfTransactVo contractTaskListOfTransactVo = new ContractTaskListOfTransactVo(pageInfo);
        return ErpResponseJson.ok(contractTaskListOfTransactVo);
    }

    /**
     * @tag 权证流程列表
     * @author 邓永洪
     * @since 2018/5/14
     */
    @ApiOperation("权证流程列表")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = DealContractRsultVo.class, message = "成功")
    })
    @PostMapping("/getDealContractTaskList")
    public ResponseJson getDealContractTaskList(@RequestBody DealContractParam param) throws Exception {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        String orderBy = param.getOrderBy();
        Integer date = param.getDate();
        String dateType = param.getDateType();
        String startTime = param.getStartTime();
        String endTime = param.getEndTime();
        param.setCompId(operator.getCompId());
        param.setNewOrganization(operator.newOrganizationType());
        
        if (StringUtils.isBlank(orderBy)) {
            param.setOrderBy("A.DEAL_ID,B.STEP_SEQ");
        } else {
            param.setOrderBy(Const.dealContractTaskOrderMap.get(orderBy) + param.getOrderType());
        }
        if (date != null) {
            if (date == 4) {
                param.setDateParam(DateTimeHelper.formatDateTimetoString(getTimeNow(), "yyyy-MM-dd" + " 00:00:00"));
                if ("TIMELIMITDATE".equalsIgnoreCase(dateType)) {
                    param.setDateColumn("B.TIMELIMITDATE");
                } else if ("UPDATE_TIME".equalsIgnoreCase(dateType)) {
                    param.setDateColumn("B.UPDATE_TIME");
                }
            } else {
                Map<String, String> returnMap = getTimeByDate(date);
                param.setStartTime(DateTimeHelper.formatDateTimetoString(returnMap.get("START_TIME"), "yyyy-MM-dd" + " 00:00:00"));
                param.setEndTime(DateTimeHelper.formatDateTimetoString(returnMap.get("END_TIME"), "yyyy-MM-dd" + " 00:00:00"));
                if ("TIMELIMITDATE".equalsIgnoreCase(dateType)) {
                    param.setDateColumn("B.TIMELIMITDATE");
                } else if ("UPDATE_TIME".equalsIgnoreCase(dateType)) {
                    param.setDateColumn("B.UPDATE_TIME");
                } else if ("SIGN_DATE".equalsIgnoreCase(dateType)) {
                    param.setDateColumn("A.SIGN_DATE");
                }
            }
        } else {
            param.setStartTime(DateTimeHelper.formatDateTimetoString(startTime, "yyyy-MM-dd" + " 00:00:00"));
            param.setEndTime(DateTimeHelper.formatDateTimetoString(endTime, "yyyy-MM-dd" + " 00:00:00"));
            if ("TIMELIMITDATE".equalsIgnoreCase(dateType)) {
                param.setDateColumn("B.TIMELIMITDATE");
            } else if ("UPDATE_TIME".equalsIgnoreCase(dateType)) {
                param.setDateColumn("B.UPDATE_TIME");
            } else if ("SIGN_DATE".equalsIgnoreCase(dateType)) {
                param.setDateColumn("A.SIGN_DATE");
            }
        }
		if(param.getUserId() != null){
			ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, param.getUserId());
			if(erpFunUsers !=null){
				param.setUserLevel(erpFunUsers.getUserLevel() + 2);
			}
		}
        PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
        List<Integer> repeatDealIds = erpFunDealMapper.getRepeatDealIds(cityId, param);
        if (repeatDealIds.isEmpty()) {
            return ErpResponseJson.ok();
        }
		PageInfo<Integer> dealIdsPageInfo = new PageInfo<>(repeatDealIds);
        param.setRepeatDealIds(repeatDealIds);
//		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
        List<DealContractDto> dealContractDtos = erpFunDealMapper.getDealContractList(cityId, param);
        PageInfo<DealContractDto> pageInfo = new PageInfo<>(dealContractDtos);
		pageInfo.setTotal(dealIdsPageInfo.getTotal());
		pageInfo.setPageNum(param.getPageOffset());
		pageInfo.setPageSize(param.getPageRows());
		pageInfo.setPages(dealIdsPageInfo.getPages());
        DealContractRsultVo resultListVo = new DealContractRsultVo(pageInfo);
        return ErpResponseJson.ok(resultListVo);
    }

    @ApiOperation("权证流程列表")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = DealContractListResultVO.class, message = "成功")})
    @PostMapping("/getAppDealContractTaskList")
    public ResponseJson getAppDealContractTaskList(@RequestBody DealContractParam param) throws Exception {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer date = param.getDate();
        String dateType = param.getDateType();
        String startTime = param.getStartTime();
        String endTime = param.getEndTime();
        param.setCompId(operator.getCompId());
        if (date != null) {
            if (date == 4) {
                param.setDateParam(DateTimeHelper.formatDateTimetoString(getTimeNow(), "yyyy-MM-dd" + " 00:00:00"));
                if ("TIMELIMITDATE".equalsIgnoreCase(dateType)) {
                    param.setDateColumn("B.TIMELIMITDATE");
                } else if ("UPDATE_TIME".equalsIgnoreCase(dateType)) {
                    param.setDateColumn("B.UPDATE_TIME");
                }
            } else {
                Map<String, String> returnMap = getTimeByDate(date);
                param.setStartTime(
                        DateTimeHelper.formatDateTimetoString(returnMap.get("START_TIME"), "yyyy-MM-dd" + " 00:00:00"));
                param.setEndTime(
                        DateTimeHelper.formatDateTimetoString(returnMap.get("END_TIME"), "yyyy-MM-dd" + " 00:00:00"));
                if ("TIMELIMITDATE".equalsIgnoreCase(dateType)) {
                    param.setDateColumn("B.TIMELIMITDATE");
                } else if ("UPDATE_TIME".equalsIgnoreCase(dateType)) {
                    param.setDateColumn("B.UPDATE_TIME");
                } else if ("SIGN_DATE".equalsIgnoreCase(dateType)) {
                    param.setDateColumn("A.SIGN_DATE");
                }
            }
        } else {
            param.setStartTime(DateTimeHelper.formatDateTimetoString(startTime, "yyyy-MM-dd" + " 00:00:00"));
            param.setEndTime(DateTimeHelper.formatDateTimetoString(endTime, "yyyy-MM-dd" + " 00:00:00"));
            if ("TIMELIMITDATE".equalsIgnoreCase(dateType)) {
                param.setDateColumn("B.TIMELIMITDATE");
            } else if ("UPDATE_TIME".equalsIgnoreCase(dateType)) {
                param.setDateColumn("B.UPDATE_TIME");
            } else if ("SIGN_DATE".equalsIgnoreCase(dateType)) {
                param.setDateColumn("A.SIGN_DATE");
            }
        }
        if(param.getUserId() != null){
			ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, param.getUserId());
			if(erpFunUsers !=null){
				param.setUserLevel(erpFunUsers.getUserLevel() + 2);
			}
		}
		
		//放到xml中
//		Integer userType = param.getUserType();
//		if(userType!=null) {
//			if (1==userType) {
//				param.setJoinStr(" join fun_users c on A.DEAL_USER_ID = c.USER_ID");
//			} else if (2==userType) {
//				param.setJoinStr(" join fun_users c on B.UPDATE_USER = c.USER_ID");
//			} else if (3==userType) {
//				param.setJoinStr(" join fun_users c on A.SIGN_USER_ID = c.USER_ID");
//			} else if (4==userType) {
//				param.setJoinStr(" join fun_users c on A.CREATOR_UID = c.USER_ID");
//			}
//		}
        param.setNewOrganization(operator.newOrganizationType());
        PageHelper.startPage(param.getPageOffset(), param.getPageRows(), false);
        List<Integer> distinctDealIdList = erpFunDealMapper.getDistinctDealIds(cityId, param);

        DealContractListResultVO dealContractListResultVO = new DealContractListResultVO();
        if (distinctDealIdList.isEmpty()) {
            return ErpResponseJson.ok(dealContractListResultVO);
        }
        List<DealContractVO> dealcontractlistvo = new ArrayList<>();
        List<ErpFunDeal> erpFunDealList = erpFunDealMapper.getFunDealByDealIds(cityId, distinctDealIdList);
        // 查询房源
        List<Integer> saleIds = erpFunDealList.stream()
                .map(ErpFunDeal::getDealHouseId).collect(Collectors.toList());
        List<ErpFunSale> saleList = erpFunSaleMapper.getDealSaleList(cityId, saleIds);
        Map<Integer, ErpFunSale> saleMap = saleList.stream()
                .collect(Collectors.toMap(ErpFunSale::getSaleId, val -> val));

        erpFunDealList = erpFunDealList.stream().sorted((val1, val2) -> val2.getSignDate().compareTo(val1.getSignDate())).collect(Collectors.toList());

        for (ErpFunDeal erpFunDeal : erpFunDealList) {
            DealContractVO dealContractVO = new DealContractVO();
            org.springframework.beans.BeanUtils.copyProperties(erpFunDeal, dealContractVO);

            if (operator.isMobileApi()) {
                String dealUserName = dealContractVO.getDealUserName();
                if (StringUtils.isNotBlank(dealUserName)) {
                    if (dealUserName.contains("(")) {
                        dealContractVO.setDealUserName(dealUserName.substring(0, dealUserName.indexOf("(")));
                    }
                    if (dealUserName.contains("（")) {
                        dealContractVO.setDealUserName(dealUserName.substring(0, dealUserName.indexOf("（")));
                    }
                }
            }

            if (saleMap.get(erpFunDeal.getDealHouseId()) != null) {
                ErpFunSale erpFunSale = saleMap.get(erpFunDeal.getDealHouseId());
                dealContractVO.setBuildName(erpFunSale.getBuildName());
                dealContractVO.setHouseRoom(erpFunSale.getSaleRoom());
                dealContractVO.setHouseArea(
                        NumberHelper.formatNumber(erpFunSale.getSaleArea().doubleValue(), NumberHelper.NUMBER_IN_2));
                dealContractVO.setHouseTotalPrice(NumberHelper
                        .formatNumber(erpFunSale.getSaleTotalPrice().doubleValue(), NumberHelper.NUMBER_IN_2));
                if (dealContractVO.getSignDate() != null) {
                    dealContractVO.setSignDate(DateTimeHelper.formatDateTimetoString(dealContractVO.getSignDate(), "yyyy.MM.dd"));
                }
            }
            dealcontractlistvo.add(dealContractVO);
        }

        dealContractListResultVO.setDealContractListVO(dealcontractlistvo);
        return ErpResponseJson.ok(dealContractListResultVO);
    }

    /**
     * @tag 权证流程 - 更新某个流程中的子流程排序
     * @author 邓永洪
     * @since 2018/5/14
     */
    @ApiOperation("权证流程 - 更新某个流程中的子流程排序")
    @ApiResponses({@ApiResponse(code = 200, response = ErpResponseJson.class, message = "success")})
    @PostMapping("/updateMgrProStepSort")
    public ResponseJson updateMgrProStepSort(@RequestBody InsertMgrStepModelParam param) {
        Operator operator = getOperator();
        Integer compId = operator.getCompId();
        Integer cityId = operator.getCityId();
        String[] stepIds = param.getStepIds().split(",");
        int i = 1;
        for (String stepId : stepIds) {
            Map<String, Object> map = new HashMap<>();
            map.put("stepSeq", i);
            map.put("stepId", stepId);
            map.put("modelId", param.getModelId());
            map.put("compId", compId);
            if (i == 1) {
                map.put("timelimitType", "1");
                map.put("timelimit", "24");
            }
            erpModelStepRelateMapper.updateModelStepRelateByMap(cityId, map);
            i++;
        }

        if (null != param.getConditionStepIds()) {
            ErpProcessModelExample example = new ErpProcessModelExample();
            example.setShardCityId(cityId);
            example.createCriteria().andCompIdEqualTo(compId).andModelIdEqualTo(param.getModelId());

            ErpProcessModel erpProcessModel = new ErpProcessModel();
            erpProcessModel.setConditionStepIds(param.getConditionStepIds());
            erpProcessModelMapper.updateByExampleSelective(erpProcessModel, example);
        } else {
            erpProcessModelMapper.updateConditionStepIdToNull(cityId, compId, param.getModelId(), null);
        }
        return ErpResponseJson.ok();
    }

    /**
     * @tag 权证流程 - 向某个流程插入步骤
     * @author 邓永洪
     * @since 2018/5/14
     */
    @ApiOperation("向某个流程插入步骤")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/insertMgrStepModelToPro")
    public ResponseJson insertMgrStepModelToPro(@RequestBody InsertMgrStepModelParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer userId = operator.getUserId();
        ErpModelStepRelate modelStepRelate = getParamObj(ErpModelStepRelate.class);
        modelStepRelate.setCompId(operator.getCompId());
        String currUname = getCurrentUserName();
        erpProcessModelService.insertMgrStepModelToPro(cityId, userId, currUname, modelStepRelate, param);
        return ErpResponseJson.ok();
    }

    /**
     * @tag 删除某个流程中的步骤
     * @author 邓永洪
     * @since 2018/5/15
     */
    @ApiOperation("删除某个流程中的步骤")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/deleteMgrStepModelFromPro")
    public ResponseJson deleteMgrStepModelFromPro(@RequestBody InsertMgrStepModelParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        Integer userId = operator.getUserId();
        ErpModelStepRelate modelStepRelate = getParamObj(ErpModelStepRelate.class);
        modelStepRelate.setCompId(compId);
        ErpModelStepRelate model = erpModelStepRelateMapper.selectModelStepRelate(cityId, modelStepRelate);
        if (null == model) {
            throw new BusinessException("不存在的步骤");
        }
        String currUname = getCurrentUserName();
        erpModelStepRelateService.deleteMgrStepModelFromPro(cityId, compId, model, userId, currUname);
        return ErpResponseJson.ok();
    }

    /**
     * @tag 创建公司权证流程模版
     * @author 邓永洪
     * @since 2018/11/17
     */
    @ApiOperation("创建公司权证流程模版")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = CreateProcessModelVo.class, message = "成功")
    })
    @PostMapping("/createProcessModel")
    public ResponseJson createProcessModel(@RequestBody CreateProcessModelParam param) {
        Operator operator = getOperator();
        ErpProcessModel processModel = new ErpProcessModel();
        processModel.setCompId(operator.getCompId());
        processModel.setProName(param.getProName());
        processModel.setModelNo((short) (this.getModelNO("MIN") - 1));
        String stepIds = param.getStepIds();

        int modelId = erpFunDealService.createProcessModel(processModel, stepIds);

        CreateProcessModelVo resultVo = new CreateProcessModelVo();
        resultVo.setModelId(modelId);
        return ErpResponseJson.ok(resultVo);
    }

    /**
     * @tag 获取公司模版的排序序号, 分最小和最大两种, 不存在时返回0
     * @author 邓永洪
     * @since 2018/11/17
     */
    private int getModelNO(String type) {
        Map<String, Integer> map = erpProcessModelMapper.getMinMaxVal(getOperator().getCityId(), getOperator().getCompId());
        if ("MIN".equals(type)) {
            Integer minValue = map.get("minValue");
            return minValue == null ? 0 : minValue;
        } else {
            Integer maxValue = map.get("maxValue");
            return maxValue == null ? 0 : maxValue;
        }
    }


    /**
     * @tag 删除权证流程模版
     * @author 邓永洪
     * @since 2018/5/15
     */
    @ApiOperation("删除权证流程模版")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
    })
    @PostMapping("/deleteProcessModel")
    @NotBlank("modelId")
    public ResponseJson deleteProcessModel(@RequestBody DealBusinessParam param) {
        Integer modelId = param.getModelId();
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        // 权证流程管理权
        boolean operateFlag = erpUserOpersService.judgePermission(cityId, operator.getUserId(), "WARRANT_MANAGE");
        Assert.isTrueThrow(!operateFlag, "您没有权限操作此功能！请联系管理员开通！");

        Integer compId = operator.getCompId();
        erpProcessModelService.deleteProcessModel(cityId, compId, modelId);

        ErpFunProcessLog erpFunProcessLog = new ErpFunProcessLog();
        erpFunProcessLog.setCompId(operator.getCompId());
        erpFunProcessLog.setCreateTime(new Date());
        erpFunProcessLog.setInfluenceId(modelId);
        erpFunProcessLog.setUserId(operator.getUserId());
        erpFunProcessLog.setInfluenceType((byte) 1);
        String currUname = getCurrentUserName();
        erpFunProcessLog.setContent(currUname + "删除了流程步骤");
        erpFunProcessLog.setShardCityId(cityId);
        erpFunProcessLogMapper.insertSelective(erpFunProcessLog);
        return ErpResponseJson.ok();
    }

    /**
     * @tag 删除步骤模板
     * @author 邓永洪
     * @since 2018/5/15
     */
    @ApiOperation("删除步骤模板")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
    })
    @PostMapping("/deleteMgrStepModel")
    public ResponseJson deleteMgrStepModel(@RequestBody DealBusinessParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        // 权证流程管理权
        boolean operateFlag = erpUserOpersService.judgePermission(cityId, operator.getUserId(), "WARRANT_MANAGE");
        Assert.isTrueThrow(!operateFlag, "您没有权限操作此功能！请联系管理员开通！");

        Integer compId = operator.getCompId();
        Integer stepId = param.getStepId();
        int modelCount = erpModelStepRelateMapper.countModelStepRelateByStepId(cityId, compId, stepId);
        Assert.isTrueThrow(modelCount > 0, "请先删除模板中引用的该步骤");

        ErpProcessModelStepExample processModelStepExample = new ErpProcessModelStepExample();
        processModelStepExample.setShardCityId(cityId);
        processModelStepExample.createCriteria().andCompIdEqualTo(compId).andStepIdEqualTo(stepId);
        erpProcessModelStepMapper.deleteByExample(processModelStepExample);
        return ErpResponseJson.ok();
    }

    /**
     * @tag 添加或更新步骤模板
     * @author 邓永洪
     * @since 2018/5/15
     */
    @ApiOperation("添加或更新步骤模板")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
    })
    @PostMapping("/insertUpdateMgrStepModel")
    public ResponseJson insertUpdateMgrStepModel(@RequestBody insertUpdateMgrStepParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();

        // 权证流程管理权
        boolean operateFlag = erpUserOpersService.judgePermission(cityId, operator.getUserId(), "WARRANT_MANAGE");
        Assert.isTrueThrow(!operateFlag, "您没有权限操作此功能！请联系管理员开通！");

        Integer compId = operator.getCompId();
        ErpProcessModelStep model = getParamObj(ErpProcessModelStep.class);
        model.setCompId(compId);
        model.setShardCityId(cityId);

        // 不可以创建或者修改为名称相同  条件 compId stepName
        ErpProcessModelStepExample erpProcessModelStepExample = new ErpProcessModelStepExample();
        erpProcessModelStepExample.setShardCityId(cityId);
        ErpProcessModelStepExample.Criteria criteria = erpProcessModelStepExample.createCriteria();
        criteria.andCompIdEqualTo(compId).andStepNameEqualTo(model.getStepName());
        if (null != model.getStepId()) {
            criteria.andStepIdNotEqualTo(model.getStepId());
        }
        int count = erpProcessModelStepMapper.countByExample(erpProcessModelStepExample);
        Assert.isTrueThrow(count > 0, "不可添加重复步骤");

        if (null == model.getStepId()) {
            erpProcessModelStepMapper.insertSelective(model);
        } else {
            if (model.getWarnType() == null) {
                model.setWarnType((byte) 0);
            }
            erpProcessModelStepMapper.updateByPrimaryKeySelective(model);
        }
        return ErpResponseJson.ok();
    }

    /**
     * @tag 获取买方税费类别
     * @author 邓永洪
     * @since 2018/5/29
     */
    @ApiOperation("获取买方税费类别")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = DealTaxVO.class, message = "成功")
    })
    @PostMapping("/getBuyTaxesTypeData")
    public ResponseJson getBuyTaxesTypeData() {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();

        List<ErpFunDealTaxesFather> dealTaxesFathers = erpFunDealTaxesFatherMapper.getDealTaxesFatherByCompId(cityId, compId, 0);
        List<Integer> fatherIds = new ArrayList<>();
        if (dealTaxesFathers.size() > 0) {
            fatherIds = dealTaxesFathers.stream().map(ErpFunDealTaxesFather::getId).collect(Collectors.toList());
        }
        ErpFunDealTaxesSubExample erpFunDealTaxesSubExample = new ErpFunDealTaxesSubExample();
        ErpFunDealTaxesSubExample.Criteria example = erpFunDealTaxesSubExample.createCriteria();
        example.andCompIdEqualTo(compId);
        if (!fatherIds.isEmpty()) {
            example.andFatherIdIn(fatherIds);
        }
        erpFunDealTaxesSubExample.setShardCityId(cityId);
        List<ErpFunDealTaxesSub> erpFunDealTaxesSubs = erpFunDealTaxesSubMapper.selectByExample(erpFunDealTaxesSubExample);
        DealTaxVO dealTaxVO = new DealTaxVO();
        dealTaxVO.setGettaxesdetaileddata(erpFunDealTaxesSubs);
        dealTaxVO.setGettaxestypedata(dealTaxesFathers);
        return ErpResponseJson.ok(dealTaxVO);
    }

    /**
     * @tag 删除税费类别
     * @author 邓永洪
     * @since 2018/5/29
     */
    @ApiOperation("删除税费类别")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/deleteTaxesTypeData")
    @NotBlank({"id"})
    public ResponseJson deleteTaxesTypeData(@RequestBody DealBusinessParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        Integer deleteType = param.getDeleteType();
        Integer delId = param.getId();
        if (deleteType != null && deleteType == 1) {
            //删除一个大类，包含子类时提示不能删除
            ErpFunDealTaxesSubExample erpFunDealTaxesSubExample = new ErpFunDealTaxesSubExample();
            erpFunDealTaxesSubExample.setShardCityId(cityId);
            erpFunDealTaxesSubExample.createCriteria().andCompIdEqualTo(compId).andIdEqualTo(delId);
            int count = erpFunDealTaxesSubMapper.countByExample(erpFunDealTaxesSubExample);
            if (count > 0) {
                throw new BusinessException("该大类下已有子类，不能直接删除，请先删除子类");
            }

            ErpFunDealTaxesFatherExample funDealTaxesFatherExample = new ErpFunDealTaxesFatherExample();
            funDealTaxesFatherExample.setShardCityId(cityId);
            funDealTaxesFatherExample.createCriteria().andCompIdEqualTo(compId).andIdEqualTo(delId);
            erpFunDealTaxesFatherMapper.deleteByExample(funDealTaxesFatherExample);
        } else {
            //只删除一个子类
            ErpFunDealTaxesSubExample funDealTaxesSubExample = new ErpFunDealTaxesSubExample();
            funDealTaxesSubExample.setShardCityId(cityId);
            funDealTaxesSubExample.createCriteria().andCompIdEqualTo(compId).andIdEqualTo(delId);
            erpFunDealTaxesSubMapper.deleteByExample(funDealTaxesSubExample);
        }
        return ErpResponseJson.ok();
    }

    /**
     * @tag 获取卖方税费类别
     * @author 邓永洪
     * @since 2018/5/29
     */
    @ApiOperation("获取卖方税费类别")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = DealTaxVO.class, message = "成功")
    })
    @PostMapping("/getSellTaxesTypeData")
    public ResponseJson getSellTaxesTypeData() {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        List<ErpFunDealTaxesFather> dealTaxesFathers = erpFunDealTaxesFatherMapper.getDealTaxesFatherByCompId(cityId, compId, 1);
        List<Integer> fatherIds = dealTaxesFathers.stream().map(ErpFunDealTaxesFather::getId).collect(Collectors.toList());
        ErpFunDealTaxesSubExample erpFunDealTaxesSubExample = new ErpFunDealTaxesSubExample();
        ErpFunDealTaxesSubExample.Criteria example = erpFunDealTaxesSubExample.createCriteria();
        example.andCompIdEqualTo(compId);
        if (!fatherIds.isEmpty()) {
            example.andFatherIdIn(fatherIds);
        }
        erpFunDealTaxesSubExample.setShardCityId(cityId);
        List<ErpFunDealTaxesSub> erpFunDealTaxesSubs = erpFunDealTaxesSubMapper.selectByExample(erpFunDealTaxesSubExample);

        DealTaxVO dealTaxVO = new DealTaxVO();
        dealTaxVO.setGettaxesdetaileddata(erpFunDealTaxesSubs);
        dealTaxVO.setGettaxestypedata(dealTaxesFathers);
        return ErpResponseJson.ok(dealTaxVO);
    }

    /**
     * @tag 删除业绩类别
     * @author 邓永洪
     * @since 2018/5/29
     */
    @ApiOperation("删除业绩类别")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/deleteFunPerformanceType")
    @NotBlank("performanceId")
    public ResponseJson deleteFunPerformanceType(@RequestBody DeleteFunPerformanceTypeParam param) {
        Integer performanceId = param.getPerformanceId();
        ErpFunPerformanceType erpFunPerformanceType = new ErpFunPerformanceType();
        erpFunPerformanceType.setShardCityId(getOperator().getCityId());
        erpFunPerformanceType.setPerformanceId(performanceId);
        erpFunPerformanceType.setIsDel((byte) 1);
        erpFunPerformanceTypeMapper.updateByPrimaryKeySelective(erpFunPerformanceType);
        return ErpResponseJson.ok();
    }

    /**
     * @tag 修改或新增税费列表
     * @author 邓永洪
     * @since 2018/6/6
     */
    @ApiOperation("修改或新增税费列表")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
    })
    @PostMapping("/updateOrInsertDealTaxes")
    @NotBlank({"dealId"})
    public ResponseJson updateOrInsertDealTaxes(@RequestBody UpdateOrInsertDealTaxesParam param) {
        Operator operator = getOperator();
        param.setCityId(operator.getCityId());
        param.setCompId(operator.getCompId());
        param.setUserName(operator.getUserName());
        param.setUserId(operator.getUserId());
        param.setDeptId(operator.getDeptId());
        param.setCurrUserName(getCurrentUserName());
        ErpFunDealTaxesRecord dealTaxesRecord = getParamObj(ErpFunDealTaxesRecord.class);
        erpFunDealTaxesRecordService.updateOrInsertDealTaxes(param, dealTaxesRecord);
        return ErpResponseJson.ok();
    }

    /**
     * @tag 动态删除流程
     * @author 邓永洪
     * @since 2018/6/20
     */
    @RequestMapping("/dynamicDelProcessStep")
    public ResponseJson dynamicDelProcessStep(@RequestBody DelProcessStepParam param) {
        Operator operator = getOperator();
        param.setCityId(operator.getCityId());
        param.setCompId(operator.getCompId());
        param.setUserName(operator.getUserName());
        param.setDeptId(operator.getDeptId());
        param.setUserId(operator.getUserId());
        param.setCurrUserName(getCurrentUserName());
        erpProcessRuntimeStepService.dynamicDelProcessStep(param);
        return ErpResponseJson.ok();
    }

    /**
     * @tag 权证流程 -全流程办结
     * @author 邓永洪
     * @since 2018/6/20
     */
    @ApiOperation("权证流程 -全流程办结")
    @ApiResponses({@ApiResponse(code = 200, response = ErpResponseJson.class, message = "success")})
    @PostMapping("/makingDeal")
    public ResponseJson updateMgrWarrantCompelete(@RequestBody changeWarrantParam param) {
        GeneralParam generalParam = new GeneralParam(getOperator());
        Integer dealId = param.getDealId();
        String currUserName = getCurrentUserName();
        generalParam.setCurrDeptUserName(currUserName);
        erpFunDealService.makingDeal(generalParam, dealId);
        return ErpResponseJson.ok();
    }

    /**
     * @tag 流程
     * @author 邓永洪
     * @since 2018/6/20
     */
    @ApiOperation("流程反办结")
    @ApiResponses({@ApiResponse(code = 200, response = ErpResponseJson.class, message = "success")})
    @PostMapping("/completionProcess")
    public ResponseJson completionProcess(@RequestBody completionProcessParam param) {
        GeneralParam generalParam = new GeneralParam(getOperator());
        Integer dealId = param.getDealId();
        String modelName = param.getModelName();
        String currUserName = getCurrentUserName();
        generalParam.setCurrDeptUserName(currUserName);
        erpFunDealService.completionProcess(generalParam, dealId, modelName);
        return ErpResponseJson.ok();
    }

    /**
     * @tag 动态插入流程
     * @author 邓永洪
     * @since 2018/6/21
     */
    @ApiOperation("动态插入流程")
    @RequestMapping("/dynamicInsertProcessStep")
    public ResponseJson dynamicInsertProcessStep(@RequestBody DynamicInsertProcessStepParam param) {
        GeneralParam generalParam = new GeneralParam(getOperator());
        String currUserName = getCurrentUserName();
        generalParam.setCurrDeptUserName(currUserName);
        ErpProcessRuntimeStep model = getParamObj(ErpProcessRuntimeStep.class);
        // 因为后台时间为Sting类型 防止前端传空字符串，导致跟新后时间为1900-01-01
        if (StringUtils.isBlank(model.getUpdateTime()))
            model.setUpdateTime(null);
        if (StringUtils.isBlank(model.getTimelimitdate()))
            model.setTimelimitdate(null);
        if (StringUtils.isBlank(model.getWarnTime()))
            model.setWarnTime(null);
        erpProcessRuntimeStepService.dynamicInsertProcessStep(generalParam, model);
        return ErpResponseJson.ok();
    }

    /**
     * @tag 更新合同中的子步骤数据
     * @author 邓永洪
     * @since 2018/6/21
     */
    @ApiOperation("更新合同中的子步骤数据")
    @RequestMapping("/updateMgrWarrantStepData")
    public ResponseJson updateMgrWarrantStepData(@RequestBody UpdateMgrWarrantStepDataParam param) {
        GeneralParam generalParam = new GeneralParam(getOperator());
        String currUserName = getCurrentUserName();
        generalParam.setCurrDeptUserName(currUserName);
        ErpProcessRuntimeStep model = getParamObj(ErpProcessRuntimeStep.class);
        // 因为后台时间为Sting类型 防止前端传空字符串，导致跟新后时间为1900-01-01
        if (StringUtils.isBlank(model.getUpdateTime()))
            model.setUpdateTime(null);
        if (StringUtils.isBlank(model.getTimelimitdate()))
            model.setTimelimitdate(null);
        if (StringUtils.isBlank(model.getWarnTime()))
            model.setWarnTime(null);
        String runstepName = param.getRunstepName();
        erpProcessRuntimeStepService.updateMgrWarrantStepData(generalParam, model, runstepName);
        return ErpResponseJson.ok();
    }

    /**
     * @tag 更新合同过户日期、取证日期、放款日期 和流程负责人信息的变更
     * @author 邓永洪
     * @since 2018/6/22
     */
    @ApiOperation("更新合同过户日期、取证日期、放款日期 和流程负责人信息的变更")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/updateWarrantsDates")
    public ResponseJson updateWarrantsDates(@RequestBody InsertDealInfoParam param) {
        GeneralParam generalParam = new GeneralParam(getOperator());
        generalParam.setCurrDeptUserName(getCurrentUserName());
        ErpFunDeal model = getParamObj(ErpFunDeal.class);
        erpFunDealService.updateWarrantsDates(generalParam, model);
        return ErpResponseJson.ok();
    }

    /**
     * @tag 创建流程并声称流程总负责人
     * @author 邓永洪
     * @since 2018/6/25
     */
    @ApiOperation("生成流程")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = InsertMgrWarrantProcessVo.class, message = "成功")
    })
    @PostMapping("/insertMgrWarrantProcess")
    public ResponseJson insertMgrWarrantProcess(@RequestBody InsertWarrantProcessParam param) {
        Operator operator = getOperator();
        ErpProcessRuntimeStep model = getParamObj(ErpProcessRuntimeStep.class);
        String trackContent = getCurrentUserName() + " 为该合同创建了" + param.getModelName() + "流程";

        GeneralParam generalParam = new GeneralParam(operator);
        erpProcessRuntimeStepService.insertMgrWarrantProcess(param, model, generalParam, trackContent);

        return ErpResponseJson.ok(getProcessRuntimeStepListByDealId(model.getDealId()));
    }

    /**
     * @tag 更新权证流程
     * @author 邓永洪
     * @since 2018/6/29
     */
    @ApiOperation("更新权证流程")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/changeWarrant")
    public ResponseJson changeWarrant(@RequestBody changeWarrantParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        ErpFunDeal dealInfo = erpFunDealMapper.getBaseDealInfo(cityId, param.getDealId());
        ErpProcessRuntimeStep model = getParamObj(ErpProcessRuntimeStep.class);

        GeneralParam generalParam = new GeneralParam(operator);
        String modelName = param.getModelName();
        String trackContent = getCurrentUserName() + " 将流程" + dealInfo.getModelName() + "更换为" + modelName + "流程";
        erpFunDealService.changeWarrant(cityId, operator.getCompId(), param, model, generalParam, trackContent);

        return ErpResponseJson.ok(getProcessRuntimeStepListByDealId(model.getDealId()));
    }

    /**
     * @tag 合同结算
     * @author 邓永洪
     * @since 2018/6/30
     */
    @ApiOperation("合同结算")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = DealAuditCommonVO.class, message = "成功")
    })
    @PostMapping("/settlementDeal")
    public ResponseJson settlementDeal(@RequestBody SettlementDealParam param, HttpServletRequest request) throws Exception {
        Operator operator = getOperator();

		// 提前刷新是否需要审核
		erpFunDealService.checkCanSettleDeal(operator.getCityId(), param.getDealId());
		GeneralParam generalParam = new GeneralParam(operator);
        generalParam.setCurrDeptUserName(this.getCurrentUserName());
        DealAuditCommonVO dealAuditCommonVO = new DealAuditCommonVO();
        // 创建审核，抽象一个合同审核通用的审核类
        DealAuditCommonParam erpAuditRuntime = new DealAuditCommonParam();
        erpAuditRuntime.setSettlementDealParam(param);
        erpAuditRuntime.setGeneralParam(generalParam);
        erpAuditRuntime.setClassId(param.getClassId());
        erpAuditRuntime.setFangJidi(operator.isFangJidi());

        // 9.3.0版本下的版本, 提示：请升级到最新版本
        if ((operator.isFangJidi() && param.getClassId() == null)) {
            // 先判断如果要审核的情况下，用共享中心配置还是统一配置
            Byte shareFlag = erpAuditTemplateMapper.selectAuditProcess(operator.getCityId(), operator.getCompId(), (byte) 4, erpAuditRuntime.getAuditType(), 0);
            if (shareFlag != null) {
                // 表示此次请求走的共享中心配置, 但是没有选择 classId
                if (Byte.valueOf("0").equals(shareFlag)) {
                    String[] erpVersionNoArr = String.valueOf(operator.getAttribute("LOGIN_VERSON")).split(" ");
                    Integer erpVersionNo = StringUtil.paseInteger(erpVersionNoArr[erpVersionNoArr.length - 1], 0);
                    boolean versionMore930 = adminFunCompService.judgeRequestFromNewVersionIn930(operator.isMobileApi(), request.getHeader("versionNo"),
                            request.getHeader("appSource"), request.getHeader("deviceType"), erpVersionNo);
                    // 安卓9.3.0下的提示升级
                    if (!versionMore930 && RequestSourceConst.APP_SOURCE_ANDROID_API.equals(request.getHeader("appSource"))) {
                        throw new BusinessException("请升级到最新版本！");
                    }
                    // 苹果9.3.0下的提示使用安卓或者ERP操作
                    if (!versionMore930 && RequestSourceConst.APP_SOURCE_IOS_API.equals(request.getHeader("appSource"))) {
                        throw new BusinessException("苹果版程序正在审核中，可在link电脑版上进行操作！");
                    }
                }
            }
        }

        Integer result = erpAuditRuntimeService.commonCreateDealAudit(erpAuditRuntime);
        if (1 == result) {
            dealAuditCommonVO.setNeedAudit(0);
            // 无需审核
            DealBussinessCommonParam commonParam = new DealBussinessCommonParam();
            // 区分审核类型
            commonParam.setAuditType(3);


            commonParam.setGeneralParam(generalParam);
            commonParam.setSettlementDealParam(param);
            erpFunDealService.doBussiness(commonParam);
        } else if (2 == result) {
            // 自己审核通过
            dealAuditCommonVO.setNeedAudit(0);
        } else if (3 == result || 4 == result) {
            // 处理成审核中
            // 创建审核成功
            dealAuditCommonVO.setNeedAudit(1);
            dealAuditCommonVO.setId(erpAuditRuntime.getId());
        } else if (5 == result) {
            dealAuditCommonVO.setNeedRefresh(1);
        } else if (6 == result) {
            dealAuditCommonVO.setNeedConfig(1);
        }

        return ErpResponseJson.ok(dealAuditCommonVO);
    }

    /**
     * @tag 合同反结算
     * @author 邓永洪
     * @since 2018/6/30
     */
    @ApiOperation("合同反结算")
    @ApiResponses({@ApiResponse(code = 200, response = DealAuditCommonVO.class, message = "success")})
    @PostMapping("/counterMgrSettleDeal")
    public ResponseJson counterMgrSettleDeal(@RequestBody CounterMgrSettleDealParam param, HttpServletRequest request) throws Exception {
        Operator operator = getOperator();
        GeneralParam generalParam = new GeneralParam(getOperator());
        String currentDeptUserName = this.getCurrentUserName();
        generalParam.setCurrDeptUserName(currentDeptUserName);
        DealAuditCommonVO dealAuditCommonVO = new DealAuditCommonVO();
        // 创建审核，抽象一个合同审核通用的审核类
        DealAuditCommonParam erpAuditRuntime = new DealAuditCommonParam();
        erpAuditRuntime.setCounterMgrSettleDealParam(param);
        erpAuditRuntime.setGeneralParam(generalParam);
        erpAuditRuntime.setClassId(param.getClassId());
        erpAuditRuntime.setFangJidi(operator.isFangJidi());

        // 9.3.0版本下的版本, 提示：请升级到最新版本
        if ((operator.isFangJidi() && param.getClassId() == null)) {
            // 先判断如果要审核的情况下，用共享中心配置还是统一配置
            Byte shareFlag = erpAuditTemplateMapper.selectAuditProcess(operator.getCityId(), operator.getCompId(), (byte) 4, erpAuditRuntime.getAuditType(), 0);
            if (shareFlag != null) {
                // 表示此次请求走的共享中心配置, 但是没有选择 classId
                if (Byte.valueOf("0").equals(shareFlag)) {
                    String[] erpVersionNoArr = String.valueOf(operator.getAttribute("LOGIN_VERSON")).split(" ");
                    Integer erpVersionNo = StringUtil.paseInteger(erpVersionNoArr[erpVersionNoArr.length - 1], 0);
                    boolean versionMore930 = adminFunCompService.judgeRequestFromNewVersionIn930(operator.isMobileApi(), request.getHeader("versionNo"),
                            request.getHeader("appSource"), request.getHeader("deviceType"), erpVersionNo);
                    // 安卓9.3.0下的提示升级
                    if (!versionMore930 && RequestSourceConst.APP_SOURCE_ANDROID_API.equals(request.getHeader("appSource"))) {
                        throw new BusinessException("请升级到最新版本！");
                    }
                    // 苹果9.3.0下的提示使用安卓或者ERP操作
                    if (!versionMore930 && RequestSourceConst.APP_SOURCE_IOS_API.equals(request.getHeader("appSource"))) {
                        throw new BusinessException("苹果版程序正在审核中，可在link电脑版上进行操作！");
                    }
                }
            }
        }

        Integer result = erpAuditRuntimeService.commonCreateDealAudit(erpAuditRuntime);
        if (1 == result) {
            dealAuditCommonVO.setNeedAudit(0);
            // 无需审核
            DealBussinessCommonParam commonParam = new DealBussinessCommonParam();
            // 区分审核类型
            commonParam.setAuditType(7);


            commonParam.setGeneralParam(generalParam);
            commonParam.setCounterMgrSettleDealParam(param);
            erpFunDealService.doBussiness(commonParam);
        } else if (2 == result) {
            // 自己审核通过
            dealAuditCommonVO.setNeedAudit(0);
        } else if (3 == result || 4 == result) {
            // 处理成审核中
            // 创建审核成功
            dealAuditCommonVO.setNeedAudit(1);
            dealAuditCommonVO.setId(erpAuditRuntime.getId());

        } else if (5 == result) {
            dealAuditCommonVO.setNeedRefresh(1);
        } else if (6 == result) {
            dealAuditCommonVO.setNeedConfig(1);
        }

        return ErpResponseJson.ok(dealAuditCommonVO);
    }

    /**
     * 权证流程-获取未领用合同列表
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/7/11
     */
    @ApiOperation("获取未领用合同列表")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunDealCodeVO.class, message = "成功")
    })
    @PostMapping("/getMatchNotAllocatedDealCodeList")
    public ResponseJson getMatchNotAllocatedDealCodeList(@RequestBody DealCodeListParam param) {
        Integer dealType = param.getDealType();
        String dealNo = param.getContractNo();
        Integer deptId = param.getDeptId();
        Integer compId = getOperator().getCompId();
        Integer cityId = getOperator().getCityId();
        List<ErpFunDealCodeDto> erpFunDealList = erpFunDealCodeMapper.getFunDealCodeList(cityId, compId, deptId, dealType, dealNo);
        ErpFunDealCodeVO resultVo = new ErpFunDealCodeVO();
        resultVo.setList(erpFunDealList);
        return ErpResponseJson.ok(resultVo);
    }

    /**
     * 应收实收审核以及反审核
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/7/11
     */
    @ApiOperation("应收实收审核以及反审核")
    @ApiResponses({@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")})
    @PostMapping("/updateProcessFinancStatus")
    public ResponseJson updateProcessFinancStatus(@RequestBody ProcessFinancStatusParam param, HttpServletRequest request) throws Exception {
        Operator operator = getOperator();
        //检查是否有转佣金款项 转佣金款项不能撤销审核
		checkBrokerageItem(param);
        GeneralParam generalParam = new GeneralParam(getOperator());
        generalParam.setCurrDeptUserName(getCurrentUserName());
        DealAuditCommonVO dealAuditCommonVO = new DealAuditCommonVO();
        // 创建审核，抽象一个合同审核通用的审核类
        DealAuditCommonParam erpAuditRuntime = new DealAuditCommonParam();
        erpAuditRuntime.setProcessFinancStatusParam(param);
        erpAuditRuntime.setGeneralParam(generalParam);
        erpAuditRuntime.setClassId(param.getClassId());
        erpAuditRuntime.setFangJidi(operator.isFangJidi());

        // 9.3.0版本下的版本, 提示：请升级到最新版本
        if ((operator.isFangJidi() && param.getClassId() == null)) {
            // 先判断如果要审核的情况下，用共享中心配置还是统一配置
            Byte shareFlag = erpAuditTemplateMapper.selectAuditProcess(operator.getCityId(), operator.getCompId(), (byte) 4, erpAuditRuntime.getAuditType(), 0);
            if (shareFlag != null) {
                // 表示此次请求走的共享中心配置, 但是没有选择 classId
                if (Byte.valueOf("0").equals(shareFlag)) {
                    String[] erpVersionNoArr = String.valueOf(operator.getAttribute("LOGIN_VERSON")).split(" ");
                    Integer erpVersionNo = StringUtil.paseInteger(erpVersionNoArr[erpVersionNoArr.length - 1], 0);
                    boolean versionMore930 = adminFunCompService.judgeRequestFromNewVersionIn930(operator.isMobileApi(), request.getHeader("versionNo"),
                            request.getHeader("appSource"), request.getHeader("deviceType"), erpVersionNo);
                    // 安卓9.3.0下的提示升级
                    if (!versionMore930 && RequestSourceConst.APP_SOURCE_ANDROID_API.equals(request.getHeader("appSource"))) {
                        throw new BusinessException("请升级到最新版本！");
                    }
                    // 苹果9.3.0下的提示使用安卓或者ERP操作
                    if (!versionMore930 && RequestSourceConst.APP_SOURCE_IOS_API.equals(request.getHeader("appSource"))) {
                        throw new BusinessException("苹果版程序正在审核中，可在link电脑版上进行操作！");
                    }
                }
            }
        }

        Integer result = erpAuditRuntimeService.commonCreateDealAudit(erpAuditRuntime);
        if (1 == result) {
            dealAuditCommonVO.setNeedAudit(0);
            // 无需审核
            DealBussinessCommonParam commonParam = new DealBussinessCommonParam();
            // 区分审核类型
            if (0 == param.getPfActual()) {
                if (1 == param.getAuditStatus()) {
                    commonParam.setAuditType(8);
                } else {
                    commonParam.setAuditType(10);
                }
            } else {
                if (1 == param.getAuditStatus()) {
                    commonParam.setAuditType(9);
                } else {
                    commonParam.setAuditType(11);
                }
            }
            String currentDeptUserName = this.getCurrUserName();
            generalParam.setCurrDeptUserName(currentDeptUserName);
            commonParam.setGeneralParam(generalParam);
            commonParam.setProcessFinancStatusParam(param);
            erpFunDealService.doBussiness(commonParam);
        } else if (2 == result) {
            // 自己审核通过
            dealAuditCommonVO.setNeedAudit(0);
        } else if (3 == result || 4 == result) {
            // 创建审核成功
            dealAuditCommonVO.setNeedAudit(1);
            dealAuditCommonVO.setId(erpAuditRuntime.getId());

        } else if (5 == result) {
            dealAuditCommonVO.setNeedRefresh(1);
        } else if (6 == result) {
            dealAuditCommonVO.setNeedConfig(1);
        }

        return ErpResponseJson.ok(dealAuditCommonVO);

    }

	private void checkBrokerageItem(ProcessFinancStatusParam param) {
		if (!Objects.equals(0, param.getAuditStatus()) || StringUtil.isBlank(param.getPfIds())) {
			return;
		}
		//包含转佣金的财务款项不能撤销审核
		Operator op = getOperator();
		List<String> ids = Arrays.asList(param.getPfIds().trim().split(","));
		List<Integer> list = ids.stream().map(Integer::parseInt).collect(Collectors.toList());
		ErpProcessFinancExample example = new ErpProcessFinancExample();
		example.setShardCityId(op.getCityId());
		example.createCriteria().andCompIdEqualTo(op.getCompId()).andPfIdIn(list);
		List<ErpProcessFinanc> result = erpProcessFinancMapper.selectByExample(example);
		for (ErpProcessFinanc obj : result) {
			//1.诚意金转佣金，2.定金转佣金

			if (Objects.nonNull(obj.getItemSource()) && (obj.getItemSource()==1 || obj.getItemSource() == 2) && Objects.nonNull(obj.getSourceId())) {
				throw new BusinessException("不能撤销转佣金的款项!");
			}
		}
	}

    /**
     * 删除业绩
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/7/11
     */
    @ApiOperation("删除业绩")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/delDealProfit")
    @NotBlank({"dealId", "profitId"})
    public ResponseJson delDealProfit(@RequestBody DelDealProfitParam param) {
        Integer profitId = param.getProfitId();
        Integer dealId = param.getDealId();
        Integer cityId = getOperator().getCityId();
        Integer compId = getOperator().getCompId();
        ErpFunProfit erpFunProfit = new ErpFunProfit();
        erpFunProfit.setProfitId(profitId);
        erpFunProfit.setShardCityId(cityId);

        GeneralParam generalParam = new GeneralParam(getOperator());
        String currentDeptUserName = this.getCurrUserName();
        String trackContent = this.getCurrUserName() + " 将该合同业绩删除";
        ErpFunProfit funProfitPO = erpFunProfitMapper.getFunProfit(cityId, compId, profitId);
        erpFunProfitService.delDealProfit(erpFunProfit, funProfitPO, generalParam, dealId, currentDeptUserName, trackContent);

        return ErpResponseJson.ok();
    }

    @ApiOperation("移动端删除业绩")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/delDealProfitInMobile")
    @NotBlank({"dealId", "profitId"})
    public ResponseJson delDealProfitInMobile(@RequestBody DelDealProfitParam param) {
        Integer profitId = param.getProfitId();
        Integer dealId = param.getDealId();
        Integer cityId = getOperator().getCityId();
        Integer compId = getOperator().getCompId();
        ErpFunProfit erpFunProfit = new ErpFunProfit();
        erpFunProfit.setProfitId(profitId);
        erpFunProfit.setShardCityId(cityId);

        GeneralParam generalParam = new GeneralParam(getOperator());

        // 按照扣除公司业绩的部分计算员工业绩比例的设置 + 删除公司业绩 = 重新计算员工业绩
        List<ErpFunProfit> list = erpFunProfitService.generateNewProfitListWhenDelete(generalParam, param);
        changeProfitParam profitParam = new changeProfitParam();
        profitParam.setDealId(param.getDealId());
        profitParam.setProfitJson(JSON.toJSONString(list));
        changeProfitCommon(profitParam);
        System.out.println("profitParam: " + profitParam);

        String currentDeptUserName = this.getCurrUserName();
        String trackContent = this.getCurrUserName() + " 将该合同业绩删除";
        ErpFunProfit funProfitPO = erpFunProfitMapper.getFunProfit(cityId, compId, profitId);
        erpFunProfitService.delDealProfit(erpFunProfit, funProfitPO, generalParam, dealId, currentDeptUserName, trackContent);

        return ErpResponseJson.ok();
    }

    /**
     * 财务数据收讫
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/7/12
     */
    @ApiOperation("财务数据收讫")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/finaDataReceived")
    public ResponseJson finaDataReceived(@RequestBody FinaDataOfReceivableParam param) {
        String jsonStr = param.getFinancJson();
        GeneralParam generalParam = new GeneralParam(getOperator());
        if (StringUtils.isNotBlank(jsonStr)) {
            List<ErpProcessFinanc> paramList = JSON.parseArray(jsonStr, ErpProcessFinanc.class);
            erpProcessFinanceService.finaDataReceived(paramList, generalParam);
        }
        return ErpResponseJson.ok();
    }

    @ApiOperation("移动端财务数据收讫")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/finaDataReceivedInMobile")
    public ResponseJson finaDataReceivedInMobile(@RequestBody FinaDataOfReceivableInMobileParam param) {
        List<ErpProcessFinanc> list = param.getFinancJson();
        GeneralParam generalParam = new GeneralParam(getOperator());

        if (list != null && list.size() > 0) {
            erpProcessFinanceService.finaDataReceived(list, generalParam);
        }

        return ErpResponseJson.ok();
    }

    /**
     * 添加实收数据
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/7/12
     */
    @ApiOperation("添加实收数据")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/updateMgrFinaDataOfReceive")
    public ResponseJson updateMgrFinaDataOfReceive(@RequestBody FinaDataOfReceivableParam param) {
        param.setPfActual(1);
        GeneralParam generalParam = new GeneralParam(getOperator());
        erpProcessFinanceService.insertOrUpdateFinacList(generalParam, param);

        return ErpResponseJson.ok();
    }

    /**
     * 审核税费
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/7/16
     */
    @ApiOperation("审核税费")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/updateDealTaxesAuditStatus")
    public ResponseJson updateDealTaxesAuditStatus(@RequestBody UpdateDealTaxesAuditStatusParam param) {
        Integer dealId = param.getDealId();
        Integer taxesAuditStatus = param.getTaxesAuditStatus();
        Integer cityId = getOperator().getCityId();
        String userName = getOperator().getUserName();
        ErpFunDeal funBaseInfoDealPo = erpFunDealMapper.getBaseDealInfo(cityId, dealId);
        List<ErpFunUsers> userList = null;
        String currentDeptUserName = this.getCurrUserName();
        String taskSubJect = currentDeptUserName + " 审核了编号" + funBaseInfoDealPo.getContractNo() + "的合同的税费";
        String taskContent = currentDeptUserName + " 审核了编号" + funBaseInfoDealPo.getContractNo() + "的合同的税费";
        userList = erpFunUsersService.getTaskUserList(cityId, dealId, 1, getOperator().getCompId(),
                getOperator().getUserId());
        String trackContent = this.getCurrUserName() + " 审核了该合同的税费";
        ErpFunDeal erpFunDeal = new ErpFunDeal();
        erpFunDeal.setTaxesAuditStatus(taxesAuditStatus.byteValue());
        if (taxesAuditStatus.intValue() == 1) {
            erpFunDeal.setTaxesAuditName(userName);
            erpFunDeal.setTaxesAuditUser(getOperator().getUserId());
            erpFunDeal.setTaxesAuditTime(new Date());
            ErpFunDealTaxesRecordExample erpFunDealTaxesRecordExample = new ErpFunDealTaxesRecordExample();
            erpFunDealTaxesRecordExample.setShardCityId(cityId);
            erpFunDealTaxesRecordExample.createCriteria().andDealIdEqualTo(dealId);
            List<ErpFunDealTaxesRecord> list = erpFunDealTaxesRecordMapper.selectByExample(erpFunDealTaxesRecordExample);
            if (list != null) {
                ErpFunDealTaxesRecord erpFunDealTaxesRecord = list.get(0);
                if (StringUtil.isNotBlank(erpFunDealTaxesRecord.getAuditUserName())) {
                    String[] nameArr = erpFunDealTaxesRecord.getAuditUserName().split(",");
                    if (nameArr.length == 2) {
                        erpFunDealTaxesRecord.setAuditUserName((nameArr[1] + "," + userName));
                    } else {
                        erpFunDealTaxesRecord.setAuditUserName((nameArr[0] + "," + userName));
                    }
                } else {
                    erpFunDealTaxesRecord.setAuditUserName(userName);
                }
                erpFunDealTaxesRecordMapper.updateByDealId(cityId, erpFunDealTaxesRecord.getAuditUserName(), dealId);
            }
        } else {
            trackContent = this.getCurrUserName() + " 撤销了该合同的税费审核";
            taskSubJect = currentDeptUserName + " 撤销了编号" + funBaseInfoDealPo.getContractNo() + "的合同的税费审核";
            taskContent = currentDeptUserName + " 撤销了编号" + funBaseInfoDealPo.getContractNo() + "的合同的税费审核";
        }

        erpFunDeal.setDealId(dealId);
        erpFunDeal.setShardCityId(cityId);
        erpFunDeal.setCompId(getOperator().getCompId());
        erpFunDealMapper.updateByPrimaryKeySelective(erpFunDeal);

        erpFunTaskService.createDealWarmTask(funBaseInfoDealPo.getDealType(), dealId, funBaseInfoDealPo.getContractNo(),
                userList, taskSubJect, Const.DIC_TASK_TYPE_CONTRACT_REMIND, taskContent,
                getOperator().getUserId(), cityId, getOperator().getDeptId(), getOperator().getCompId());

        erpFunDealRecordService.writeDealRecord(new GeneralParam(getOperator()), dealId, null, Const.DIC_DEAL_UPDATE_CLASSIC_TAXESADULT,
                (byte) 0, trackContent, 1, null, false, null);
        return ErpResponseJson.ok();
    }

    /**
     * 权证流程-业绩分配  修改业绩
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/7/19
     */
    @ApiOperation("业绩分配修改业绩")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
    })
    @PostMapping("/changeProfit")
    @NotBlank("profitJson")
    public ResponseJson changeProfit(@RequestBody changeProfitParam param) {
        // erp端编辑走以前逻辑,移动端处理好profitJson参数走这个逻辑
        return changeProfitCommon(param);
    }

    private ResponseJson changeProfitCommon(changeProfitParam param) {
        Integer dealId = param.getDealId();
        Integer cityId = getOperator().getCityId();
        Integer compId = getOperator().getCompId();
        Integer no = erpFunProfitMapper.countProfitByDealId(cityId, dealId);
        //容错操作  避免因为不是实时同步导致数据出错
        if (no > 0) {
            throw new BusinessException("已发放的业绩，不允许修改！");
        }
		
		boolean isFangJidi = adminFunCompService.judgerIsFangjidi(getOperator().getAdminCompId());
        GeneralParam generalParam = new GeneralParam(getOperator());
        erpFunProfitService.m4ChangeProfit(generalParam, param, 0, cityId, dealId);

       // 查询已审核的实收
		List<ErpProcessFinanc> processFinancPOList = erpProcessFinancMapper.getProcessFinancListByDealId(cityId, compId, dealId);
		List<ErpProcessFinanc> actualProcessList = processFinancPOList.stream().filter(processFinanc->Byte.valueOf("1").equals(processFinanc.getPfActual())).collect(Collectors.toList());
		List<ErpProcessFinanc> recProcessList = processFinancPOList.stream().filter(processFinanc->Byte.valueOf("0").equals(processFinanc.getPfActual())).collect(Collectors.toList());
		//改动完了，等下测一下
		if(actualProcessList.size() > 0) {
			String pfIds = "";
			for (ErpProcessFinanc processFinancPO : actualProcessList) {
				pfIds += processFinancPO.getPfId()+",";
			}
			if(StringUtils.isNotBlank(pfIds)) {
				pfIds = pfIds.substring(0, pfIds.length()-1);
				// 发送消息到jms
//				Map<String, Object> content = new HashMap<>();
//				content.put("cityId", cityId);
//				content.put("compId",compId);
//				content.put("dealId", dealId);
//				content.put("pfIds", pfIds);
//				content.put("dealOpType", "1");
//				adminJmsMessageService.createProfitDetail(cityId,content);

				UpdateFunProfitMessage message = new UpdateFunProfitMessage();
				message.setCityId(cityId);
				message.setCompId(compId);
				message.setDealId(dealId);
				message.setPfIds(pfIds);
				message.setDealOpType(1);
				adminJmsMessageService.createProfitDetail(message);
			}
		}
        if (isFangJidi) {
			
			if (recProcessList.size() > 0) {
				String pfIds = "";
				for (ErpProcessFinanc processFinancPO : recProcessList) {
					pfIds += processFinancPO.getPfId()+",";
				}
				if(StringUtils.isNotBlank(pfIds)) {
					pfIds = pfIds.substring(0, pfIds.length()-1);
					// 发送消息到jms
	//				Map<String, Object> content = new HashMap<>();
	//				content.put("cityId", cityId);
	//				content.put("compId",compId);
	//				content.put("dealId", dealId);
	//				content.put("pfIds", pfIds);
	//				content.put("dealOpType", "1");
	//				adminJmsMessageService.createProfitDetail(cityId,content);
					
					UpdateFunProfitMessage message = new UpdateFunProfitMessage();
					message.setCityId(cityId);
					message.setCompId(compId);
					message.setDealId(dealId);
					message.setPfIds(pfIds);
					message.setDealOpType(4);
					adminJmsMessageService.createProfitDetail(message);
				}
			}
		}
        return ErpResponseJson.ok();
    }

    @ApiOperation("移动端业绩分配修改业绩")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
    })
    @PostMapping("/changeProfitInMobile")
    @NotBlank("profitJson")
    public ResponseJson changeProfitInMobile(@RequestBody ChangeProfitInMobileParam param) {
        GeneralParam generalParam = new GeneralParam(getOperator());

        // 测试用
//		String profitJson = param.getProfitJson();
//		ChangeProfitInMobileParam mobileParam = new ChangeProfitInMobileParam();
//		List<ErpFunProfit> list2 = JSON.parseArray(profitJson, ErpFunProfit.class);
//		mobileParam.setProfitJson(list2.subList(2, 3));
//		mobileParam.setDealId(param.getDealId());

        List<ErpFunProfit> list = erpFunProfitService.generateNewProfitList(generalParam, param);

        changeProfitParam profitParam = new changeProfitParam();
        profitParam.setDealId(param.getDealId());
        profitParam.setProfitJson(JSON.toJSONString(list));

        // erp端编辑走以前逻辑,移动端处理好profitJson参数走这个逻辑
        return changeProfitCommon(profitParam);
    }

    /**
     * @tag 编辑分佣比例
     * @author 邓永洪
     * @since 2018/7/23
     */
    @ApiOperation("编辑分佣比例")
    @ApiResponses({@ApiResponse(code = 200, message = "success")})
    @PostMapping("/editBrokerageIncome")
    public ResponseJson editBrokerageIncome(@RequestBody EditBrokerageIncomeParam param) {
        Operator operator = getOperator();
        String list = param.getCommionList();
        String profitPercentRule = param.getProfitPercentRule();
        List<ErpFunBrokerageIncome> pList = null;
        if (StringUtils.isNotBlank(list)) {
            pList = JSON.parseArray(list, ErpFunBrokerageIncome.class);
        }
        erpFunBrokerageIncomeService.updateBrokerageIncome(operator.getUserId(), operator.getCityId(), operator.getCompId(), pList, profitPercentRule);
        return ErpResponseJson.ok();
    }

    /**
     * @tag 编辑分佣比例
     * @author 邓永洪
     * @since 2018/7/23
     */
    @ApiOperation("app编辑分佣比例")
    @ApiResponses({@ApiResponse(code = 200, message = "success")})
    @PostMapping("/appEditBrokerageIncome")
    public ResponseJson editAppBrokerageIncome(@RequestBody AppEditBrokerageIncomeParam param) {
        Operator operator = getOperator();
        String profitPercentRule = param.getProfitPercentRule();
        List<ErpFunBrokerageIncome> pList = param.getBrokerageIncomeList();
        erpFunBrokerageIncomeService.updateBrokerageIncome(operator.getUserId(), operator.getCityId(), operator.getCompId(), pList, profitPercentRule);
        return ErpResponseJson.ok();
    }

    /**
     * 参数设置
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/7/11
     */
    private void createDealFinancStatus(Map<String, Object> dealUpdateMap, String type) {
        ErpFunFinancStatus erpFunFinancStatus = erpFunFinancStatusMapper.getFunFinancStatus(getOperator().getCityId(), getOperator().getCompId(), type);
        if (erpFunFinancStatus != null) {
            dealUpdateMap.put("financStatusId", erpFunFinancStatus.getFinancStatusId());
            dealUpdateMap.put("financName", type);
        }
    }

    /**
     * 通用的获取部门加用户名的方法
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/7/11
     */
    public String getCurrUserName() {
        String currUname = getOperator().getUserName();
        // 不是纯精英版也不是专业版 才写门店名称
        if (!Const.DIC_COMP_TYPE_2.equals(getOperator().getCompType()) && !getOperator().isPersonalVersion()) {
            currUname = getOperator().getDeptName() + " " + currUname;
        }
        return currUname;
    }

    /**
     * @tag 获取步骤列表
     * @author 邓永洪
     * @since 2018/6/29
     */
    private List<ErpProcessRuntimeStep> getProcessRuntimeStepListByDealId(Integer dealId) {
        ErpProcessRuntimeStepExample processRuntimeStepExample = new ErpProcessRuntimeStepExample();
        processRuntimeStepExample.setShardCityId(getOperator().getCityId());
        processRuntimeStepExample.createCriteria().andDealIdEqualTo(dealId).andDelFlagEqualTo((byte) 0);
        processRuntimeStepExample.setOrderByClause("SEQ_SORT asc, STEP_SEQ asc");
        return erpProcessRuntimeStepMapper.selectByExample(processRuntimeStepExample);
    }

    /**
     * @tag 根据不同date类型返回不同得时间段
     * @author 邓永洪
     * @since 2018/5/15
     */
    private Map<String, String> getTimeByDate(Integer date) throws Exception {
        Map<String, String> returnMap = new HashMap<String, String>();
        String timeNow = getTimeNow();
        if (date == 0) {// 今天
            returnMap.put("END_TIME", timeNow);
            returnMap.put("START_TIME", DateTimeHelper.formatDateTimetoString(timeNow, "yyyy-MM-dd" + " 00:00:00"));
        } else if (date == 1) {// 明天
            Date dt = new Date();
            returnMap.put("END_TIME",
                    DateTimeHelper.formatDateTimetoString(DateTimeHelper.addDays(dt, 1), "yyyy-MM-dd" + " 23:59:59"));
            returnMap.put("START_TIME",
                    DateTimeHelper.formatDateTimetoString(DateTimeHelper.addDays(dt, 1), "yyyy-MM-dd" + " 00:00:00"));
        } else if (date == 2) {// 本周
            Calendar cal = Calendar.getInstance();
            int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 2;
            cal.add(Calendar.DATE, -day_of_week);
            cal.add(Calendar.DATE, 6);
            returnMap.put("END_TIME", DateTimeHelper.formatDateTimetoString(cal.getTime(), "yyyy-MM-dd" + " 23:59:59"));
            returnMap.put("START_TIME", DateTimeHelper.formatDateTimetoString(timeNow, "yyyy-MM-dd" + " 00:00:00"));
        } else if (date == 4) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(DateUtil.getMonday());
            returnMap.put("START_TIME",
                    DateTimeHelper.formatDateTimetoString(cal.getTime(), "yyyy-MM-dd" + " 00:00:00"));
            cal.add(Calendar.DATE, 6);
            returnMap.put("END_TIME", DateTimeHelper.formatDateTimetoString(cal.getTime(), "yyyy-MM-dd" + " 23:59:59"));
        }
        return returnMap;

    }

    /**
     * 权证流程-添加或更新财务数据(应收)
     *
     * @param param
     * @return Modified XXX HeWei 2018年7月20日
     * @author HeWei
     * @since 2018年7月20日 下午1:55:04
     */
    @ApiOperation("添加或更新财务数据(应收)")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/updateMgrFinaDataOfReceivable")
    public ResponseJson updateMgrFinaDataOfReceivable(@RequestBody FinaDataOfReceivableParam param) {
        param.setPfActual(0);
        GeneralParam generalParam = new GeneralParam(getOperator());
        erpProcessFinanceService.insertOrUpdateFinacList(generalParam, param);
        return ErpResponseJson.ok();
    }

    @ApiOperation("移动端编辑应收数据(款项,付方,金额,业绩类别,应收日期为必填项)")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/updateAppMgrFinaDataOfReceivable")
    public ResponseJson updateAppMgrFinaDataOfReceivable(@RequestBody FinaDataOfReceivableInMobileParam param) {
        param.setPfActual(0);
        GeneralParam generalParam = new GeneralParam(getOperator());
        FinaDataOfReceivableParam receivableParam = transParam(param);
        List<ErpProcessFinanc> list = param.getFinancJson();

        if (list != null && list.size() > 0) {
            // 新增和编辑移动端只会传一条数据,删除的时候传空数组
            ErpProcessFinancExample example = new ErpProcessFinancExample();
            ErpProcessFinanc erpProcessFinanc = list.get(0);
            Integer pfId = erpProcessFinanc.getPfId();
            int count;

            if (pfId == null) {
                // 新增数据
                example.setShardCityId(getOperator().getCityId());
                example.createCriteria()
                        .andCompIdEqualTo(getOperator().getCompId())
                        .andDealIdEqualTo(param.getDealId())
                        .andPfNameEqualTo(erpProcessFinanc.getPfName())
                        .andPfPayerEqualTo(erpProcessFinanc.getPfPayer())
                        .andPfActualEqualTo(Byte.valueOf("0"));
                count = erpProcessFinancMapper.countByExample(example);
            } else {
                // 编辑数据
                example.setShardCityId(getOperator().getCityId());
                example.createCriteria()
                        .andCompIdEqualTo(getOperator().getCompId())
                        .andDealIdEqualTo(param.getDealId())
                        .andPfIdNotEqualTo(pfId)
                        .andPfNameEqualTo(erpProcessFinanc.getPfName())
                        .andPfPayerEqualTo(erpProcessFinanc.getPfPayer())
                        .andPfActualEqualTo(Byte.valueOf("0"));
                count = erpProcessFinancMapper.countByExample(example);
            }

            if (count > 0) {
                throw new BusinessException("款项名称 支付方不允许同时重复，请重新填写！");
            }
        }

        erpProcessFinanceService.insertOrUpdateFinacList(generalParam, receivableParam);
        return ErpResponseJson.ok();
    }

    @ApiOperation("移动端编辑实收数据(款项,付方,金额,业绩类别,实收日期为必填项)")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = UpdateAppMgrFinaDataOfReceiveVo.class, message = "成功")
    })
    @RequestMapping("/updateAppMgrFinaDataOfReceive")
    public ResponseJson updateAppMgrFinaDataOfReceive(@RequestBody FinaDataOfReceivableInMobileParam param) {
        param.setPfActual(1);
        GeneralParam generalParam = new GeneralParam(getOperator());
        FinaDataOfReceivableParam receivableParam = transParam(param);
        // 移动端 financJson 只会传一条，只会返回一个pfId
        String pfId = erpProcessFinanceService.insertOrUpdateFinacList(generalParam, receivableParam);
        UpdateAppMgrFinaDataOfReceiveVo vo = new UpdateAppMgrFinaDataOfReceiveVo();
        vo.setPfId(pfId);
        return ErpResponseJson.ok(vo);
    }

    private FinaDataOfReceivableParam transParam(FinaDataOfReceivableInMobileParam param) {
        FinaDataOfReceivableParam receivableParam = new FinaDataOfReceivableParam();
        receivableParam.setPfActual(param.getPfActual());
        receivableParam.setDealId(param.getDealId());
        receivableParam.setDelFinancIds(param.getDelFinancIds());
        receivableParam.setFinancJson(JSON.toJSONString(param.getFinancJson()));
        return receivableParam;
    }

    /**
     * @param param dealId=合同ID  lockFlag=合同锁定标志 1=锁定 0=解锁
     *              目前PC端锁定，掌通锁定都走此接口
     * @return
     * @title 合同锁定功能
     * @author lcb
     * @date 2019/5/22
     */
    @ApiOperation("合同详情页-合同锁定功能")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/updateMrgContractLockStatus")
    public ResponseJson updateMrgContractLockStatus(@RequestBody ContractLockStatusParam param) {
        Operator operator = getOperator();
        // 判断是否有锁定权限,
        boolean operateFlag = erpUserOpersService.judgePermission(operator.getCityId(), operator.getUserId(), "DEAL_LOCK_VIEW");
        if (!operateFlag) {
            throw new BusinessException("您没有权限操作此功能！请联系管理员开通！");
        }
        Integer dealId = param.getDealId();
        Byte lockFlag = param.getLockFlag();
        Integer cityId = getOperator().getCityId();
        ErpFunDeal erpFunDeal = new ErpFunDeal();
        erpFunDeal.setLockFlag(lockFlag);
        erpFunDeal.setDealId(dealId);
        erpFunDeal.setShardCityId(cityId);
        erpFunDealMapper.updateByPrimaryKeySelective(erpFunDeal);
        return ErpResponseJson.ok();

    }

    @ApiOperation("查询外成交列表")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpOutdealVo.class, message = "成功")
    })
    @RequestMapping("/getMgrOutDealList")
    public ResponseJson getMgrOutDealList(@RequestBody ErpFunOutdealParam param) {
        Map<Integer, ErpFunUsers> users = new HashMap<>();
        Integer cityId = getOperator().getCityId();
        Integer shareCompId = null;
        List<Integer> shareCompIds = null;
        List<String> shareCompNos = null;
        Integer shareId = param.getShareId();
        String compNo = param.getCompNo();
        String date = param.getDate();
        if ((StringUtil.isNotBlank(compNo) || shareId != null) && Const.DIC_IS_KEWEI_COMP_MODEL.equals(getOperator().getCompModel())) {
            String shareCompNo = param.getCompNo();
            if (StringUtil.isBlank(shareCompNo)) {
                throw new BusinessException("加盟圈查询条件错误！");
            }
            if (shareId != null) {
                List<AdminFunShareRelevance> adminFunShareRelevanceList = adminFunShareRelevanceMapper.getCompIdsByShareId(shareId);
                if (adminFunShareRelevanceList != null) {
                    shareCompNos = adminFunShareRelevanceList.stream().collect(Collectors.mapping(AdminFunShareRelevance::getShareCompNo, Collectors.toList()));
                    shareCompIds = erpFunCompMapper.getCompIdsByCompNos(cityId, shareCompNos);
                    if (shareCompIds == null) {
                        return ErpResponseJson.ok(new ArrayList<ErpFunOutdeal>());
                    }
                }
            } else if (StringUtil.isBlank(shareCompNo)) {
                ErpFunComp erpFunComp = erpFunCompMapper.getCompByCompNo(shareCompNo);
                shareCompId = erpFunComp.getCompId();
            }
        }

        // 将分页和查询日期作为条件,只支持整月查询,传过来的日期字段只有年月
        if (StringUtil.isNotBlank(date)) {
            String[] conStr = DateConvert.getConditionDate(date);
            param.setStartTime(conStr[0]);
            param.setEndTime(conStr[1]);
        }

        String dataRange = param.getDateRange();
        if (StringUtil.isNotBlank(dataRange)) {
            String[] val = dataRange.split("~");
            // 必须是两个单位
            if (val.length == 2 && val[0] != null && val[1] != null) {
                param.setStartTime(val[0] + " 00:00:00");
                param.setEndTime(val[1] + " 23:59:59");// 这里必须添加时间结束;
            }
        }

        if (shareCompId != null && shareCompIds == null) {//加盟圈查询某个公司
            List<ErpFunUsers> erpFunUsersList = erpFunUsersMapper.getFunUsersListByCompId(cityId, shareCompId);
            users = erpFunUsersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, val -> val));
        } else if (shareCompIds != null) {//加盟圈
            for (Integer compId : shareCompIds) {
                List<ErpFunUsers> erpFunUsersList = erpFunUsersMapper.getFunUsersListByCompId(cityId, compId);
                users = erpFunUsersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, val -> val));
            }
        } else {
            // 非共享圈查询的情况要加上公司条件
            List<ErpFunUsers> erpFunUsersList = erpFunUsersMapper.getFunUsersListByCompId(cityId, getOperator().getCompId());
            users = erpFunUsersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, val -> val));
        }
        param.setShareCompId(shareCompId);
        param.setShareCompIds(shareCompIds);
        param.setCompId(getOperator().getCompId());
        PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
        List<ErpOutdeal> list = erpOutdealMapper.getOutDealInfo(cityId, param);

        List<ErpOutdealDto> funOutdealVOs = new ArrayList<>();
        Set<Integer> caseIds = new HashSet<>();
        for (ErpOutdeal funOutdealPO : list) {
            caseIds.add(funOutdealPO.getCaseId());
        }
        Map<Integer, Map<Integer, String>> caseNoMap = this.getCaseNoMapByCaseIds(caseIds);
        for (ErpOutdeal funOutdealPO : list) {
            ErpOutdealDto funOutdealVO = new ErpOutdealDto();
            funOutdealVOs.add(funOutdealVO);
            try {
                BeanUtilsHelper.copyProperties(funOutdealVO, funOutdealPO);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ErpFunUsers funUsersPO = users.get(funOutdealPO.getCreatorUserId());
            if (funUsersPO == null) {
                funUsersPO = erpFunUsersMapper.getUserInfoByUserId(cityId, funOutdealPO.getCreatorUserId());
            }
            if (funUsersPO != null) {
                funOutdealVO.setUserName(funUsersPO.getUserName());
            }
            Map<Integer, String> childMap = caseNoMap.get(funOutdealPO.getCaseType());
            if (childMap == null) {
//				logger.info(funOutdealPO.getCASE_ID() + " 未知的类型 " + funOutdealPO.getCASE_TYPE());
                continue;
            }
            String caseNO = childMap.get(funOutdealPO.getCaseId());
            if (caseNO == null) {
//				logger.info(funOutdealPO.getCASE_TYPE() + " 未知的主键 " + funOutdealPO.getCASE_ID());
                continue;
            }
            funOutdealVO.setCaseNo(caseNO);
        }
        return ErpResponseJson.ok(funOutdealVOs);
    }


    /**
     * 获取合同成交列表
     *
     * @param:
     * @return:
     * @auther: 胡坤
     * @date: 2018/9/6
     */
    @ApiOperation("获取合同成交列表,需求=8491，作者=胡坤")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpOutdealVo.class, message = "成功")
    })
    @RequestMapping("/getContractDealList")
    public ResponseJson getContractDealList(@RequestBody GetContractDealParam param) {
        Integer cityId = getOperator().getCityId();
        param.setCompId(getOperator().getCompId());
        String dataRange = param.getDateRange();

        String date = param.getDate();
        // 将分页和查询日期作为条件,只支持整月查询,传过来的日期字段只有年月
        if (StringUtil.isNotBlank(date)) {
            String[] conStr = DateConvert.getConditionDate(date);
            param.setStartTime(conStr[0]);
            param.setEndTime(conStr[1]);
        }

        if (StringUtil.isNotBlank(dataRange)) {
            String[] val = dataRange.split("~");
            // 必须是两个单位
            if (val.length == 2 && val[0] != null && val[1] != null) {
                param.setStartTime(val[0] + " 00:00:00");
                param.setEndTime(val[1] + " 23:59:59");// 这里必须添加时间结束;
            }
        }
        if(param.getUserId() !=null ){
        	ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, param.getUserId());
        	if(erpFunUsers !=null){
        		param.setUserLevel(erpFunUsers.getUserLevel()+2);
        	}
        }
        
        param.setNewOrganization(getOperator().newOrganizationType());
        //1.分页查询成交列表
        PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
        List<ErpOutdeal> list = erpOutdealMapper.getContractDealList(cityId, param);
        List<ErpOutdealDto> resultList = new ArrayList<ErpOutdealDto>();
        if (!list.isEmpty()) {
        	List<Integer> userIdList = list.stream().map(ErpOutdeal :: getCaseUser).collect(Collectors.toList());
        	if (!userIdList.isEmpty()) {
        		Map<Integer, UserOrganizationInfoVO> userOrganizationInfoMap = erpFunUsersService.getUserOrganizationInfoByUserIds(cityId, userIdList);
        		if (null != userOrganizationInfoMap) {
        			list.stream().forEach(a -> {
        				Integer userId = a.getCaseUser();
        				ErpOutdealDto erpOutdealDto = new ErpOutdealDto();
        				try {
        					BeanUtilsHelper.copyProperties(erpOutdealDto, a);
        				} catch (Exception e) {
        					e.printStackTrace();
        				}
        				UserOrganizationInfoVO userOrganizationInfoVO = userOrganizationInfoMap.get(userId);
        				if (null != userOrganizationInfoVO) {
        					erpOutdealDto.setUserName(userOrganizationInfoVO.getUserName());
        					erpOutdealDto.setOrganizationId(userOrganizationInfoVO.getOrganizationId());
        					erpOutdealDto.setOrganizationName(userOrganizationInfoVO.getOrganizationName());
        					erpOutdealDto.setCompName(userOrganizationInfoVO.getCompName());
        				}
        				resultList.add(erpOutdealDto);
        			});
        		}
        	}
        }
        PageInfo<ErpOutdealDto> pageInfo = new PageInfo<>(resultList);

        //2.统计成交金额，应收业绩
        Map<String, Object> dataMap = erpOutdealMapper.getContractDealTotalPrice(cityId, param);

        ErpResponseJson responseJson = new ErpResponseJson(resultList);
        responseJson.setPageNum(param.getPageOffset());
        responseJson.setPageSize(param.getPageRows());
        responseJson.setTotal(pageInfo.getTotal());
        responseJson.setExtra(JSON.toJSONString(dataMap));
        return responseJson;
    }

    /**
     * 根据caseId和caseType获取目标信息
     *
     * @param:
     * @return:
     * @auther: 胡坤
     * @date: 2018/9/5
     */
    private Map<Integer, Map<Integer, String>> getCaseNoMapByCaseIds(Set<Integer> caseIds) {
        Map<Integer, Map<Integer, String>> resultMap = new HashMap<>();
        if (caseIds == null || caseIds.size() <= 0) {
            return resultMap;
        }
        Integer cityId = getOperator().getCityId();
        Integer compId = getOperator().getCompId();
        // 出售房源
        List<ErpFunSale> saleList = erpFunSaleMapper.getFunSaleListByCompIdAndCaseIds(cityId, compId, caseIds);
        Map<Integer, String> caseMap = new HashMap<>();
        for (ErpFunSale salePO : saleList) {
            caseMap.put(salePO.getSaleId(), salePO.getSaleNo());
        }
        resultMap.put(Const.DIC_CASE_TYPE_SALE_FUN, caseMap);

        // 出租房源
        List<ErpFunLease> leaseList = erpFunLeaseMapper.getFunLeaseListByCompIdAndCaseIds(cityId, compId, caseIds);
        caseMap = new HashMap<>();
        for (ErpFunLease po : leaseList) {
            caseMap.put(po.getLeaseId(), po.getLeaseNo());
        }
        resultMap.put(Const.DIC_CASE_TYPE_LEASE_FUN, caseMap);
        // 求购客户
        List<ErpFunBuyCustomer> buyCustList = erpFunBuyCustomerMapper.getFunBuyCustListByCompIdAndCaseIds(cityId, compId, caseIds);
        caseMap = new HashMap<>();
        for (ErpFunBuyCustomer po : buyCustList) {
            caseMap.put(po.getBuyCustId(), po.getBuyCustNo());
        }
        resultMap.put(Const.DIC_CASE_TYPE_BUY_CUST, caseMap);
        // 求租客户
        List<ErpFunRentCustomer> rentCustList = erpFunRentCustomerMapper.getFunRentCustListByCompIdAndCaseIds(cityId, compId, caseIds);
        caseMap = new HashMap<>();
        for (ErpFunRentCustomer po : rentCustList) {
            caseMap.put(po.getRentCustId(), po.getRentCustNo());
        }
        resultMap.put(Const.DIC_CASE_TYPE_RENT_CUST, caseMap);
        return resultMap;
    }

    /**
     * @Title 更新流程实例的执行步骤顺序
     * @Author lcb
     * @Time 2019/6/21 14:59
     * @Desc
     **/
    @ApiOperation("更新流程实例的执行步骤顺序(因为涉及状态同步，目前只支持两个步骤对调)，需求：9960  李成兵")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
    })
    @RequestMapping("/updateRuntimeStepSeq")
    public ResponseJson updateRuntimeStepSeq(@RequestBody UpdateRuntimeStepParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        /**
         * 1.按照格式解析json数据
         * 2.查询出原步骤数据，注意两个步骤的状态，未完成步骤在前的话会被置为跳过
         * 2.按照stepId 修改stepNO 数据
         * 3.更新合同的updateTime
         * 4.写入流程日志数据
         * **/
        List<UpdateRuntimeStepSeqParam> stepList = param.getStepList();
        Assert.isTrueThrow(null == stepList || stepList.size() < 2, "流程参数有误，请联系在线客服");
        // 流程实例Id
        List<Integer> runTimeStepIdList = stepList.stream().collect(Collectors.mapping(val -> val.getRunStepId(), Collectors.toList()));
        ErpProcessRuntimeStepExample stepExample = new ErpProcessRuntimeStepExample();
        stepExample.setShardCityId(cityId);
        stepExample.createCriteria().andRunstepIdIn(runTimeStepIdList);
        List<ErpProcessRuntimeStep> erpProcessRuntimeSteps = erpProcessRuntimeStepMapper.selectByExample(stepExample);

        // 转成Map好赋值
        Map<Integer, ErpProcessRuntimeStep> runtimeStepMap = erpProcessRuntimeSteps.stream().collect(Collectors.toMap(val -> val.getRunstepId(), val -> val));

        // 处理步骤的状态
        dealRuntimeStepStatus(cityId, param.getDealId(), stepList, runtimeStepMap);
        // 处理步骤的计划完成时间
        dealRuntimeStepPlanFinishDate(cityId, param.getDealId(), erpProcessRuntimeSteps);

        ErpProcessRuntimeStep updatePo = new ErpProcessRuntimeStep();
        updatePo.setShardCityId(cityId);
        for (UpdateRuntimeStepSeqParam stepSeqParam : stepList) {
            updatePo.setRunstepId(stepSeqParam.getRunStepId());
            updatePo.setStepSeq(stepSeqParam.getStepSeq());
            updatePo.setRunstepStatus(stepSeqParam.getRunstepStatus());
            erpProcessRuntimeStepMapper.updateByPrimaryKeySelective(updatePo);
        }

        // 修改合同的更新时间
        ErpFunDeal erpFunDeal = new ErpFunDeal();
        erpFunDeal.setDealId(param.getDealId());
        erpFunDeal.setShardCityId(cityId);
        erpFunDeal.setUpdateTime(new Date());
        erpFunDeal.setUpdateUid(operator.getUserId());
        erpFunDeal.setUpdateUsername(operator.getUserName());
        erpFunDealMapper.updateByPrimaryKeySelective(erpFunDeal);

        // 写权证流程日志
        String content = getCurrUserName() + "调整了步骤[%s]和步骤[%s]的顺序";
        ErpFunProcessRecord record = new ErpFunProcessRecord();
        record.setDealId(param.getDealId());
        record.setDeptId(operator.getDeptId());
        record.setCompId(operator.getCompId());
        record.setTrackContent(String.format(content, erpProcessRuntimeSteps.get(0).getStepName(), erpProcessRuntimeSteps.get(1).getStepName()));
        record.setUpdateClassic(Const.DIC_DEAL_UPDATE_CLASSIC_PROCESSUPDATE);
        record.setUpdateUid(operator.getUserId());
        record.setUpdateUserName(operator.getUserName());
        record.setUpdateDate(DateTimeHelper.getTimeNow());
        record.setShardCityId(operator.getCityId());
        erpFunProcessRecordMapper.insertSelective(record);

        return ErpResponseJson.ok();
    }

    /**
     * @Title 维护状态
     * @Author lcb
     * @Time 2019/6/24 11:40
     * @Desc
     **/
    private void dealRuntimeStepStatus(Integer cityId, Integer dealId, List<UpdateRuntimeStepSeqParam> stepList, Map<Integer, ErpProcessRuntimeStep> runtimeStepMap) {
        // 执行状态 1:未处理 2:待处理 3:已处理 4跳过
        // 前端传过来的是已经调了序的数据
        // 状态是一样的都不用处理
        if (runtimeStepMap.get(stepList.get(0).getRunStepId()).getRunstepStatus().equals(runtimeStepMap.get(stepList.get(1).getRunStepId()).getRunstepStatus())) {
            return;
        }


        // 跳过和完成更换
        if (Const.DIC_RUNSTEP_STATUS_SUCCESS.equals(runtimeStepMap.get(stepList.get(0).getRunStepId()).getRunstepStatus()) && Const.DIC_RUNSTEP_STATUS_SKIP.equals(runtimeStepMap.get(stepList.get(1).getRunStepId()).getRunstepStatus())) {
            // 只有next步骤是未处理或者待处理，步骤才变为未处理  否则时跳过
            ErpProcessRuntimeStep nextRuntimeStep = erpProcessRuntimeStepMapper.getNextRuntimeStep(cityId, dealId, stepList.get(1).getStepSeq());
            if (null != nextRuntimeStep) {
                if (Const.DIC_RUNSTEP_STATUS_WAITDOING.equals(nextRuntimeStep.getRunstepStatus()) || Const.DIC_RUNSTEP_STATUS_NOTDOING.equals(nextRuntimeStep.getRunstepStatus())) {
                    stepList.get(1).setRunstepStatus(Const.DIC_RUNSTEP_STATUS_NOTDOING);
                } else {
                    stepList.get(1).setRunstepStatus(Const.DIC_RUNSTEP_STATUS_SKIP);
                }
            }


        }

        // 待(未)处理和完成更换
        if ((Const.DIC_RUNSTEP_STATUS_WAITDOING.equals(runtimeStepMap.get(stepList.get(0).getRunStepId()).getRunstepStatus())
                || Const.DIC_RUNSTEP_STATUS_NOTDOING.equals(runtimeStepMap.get(stepList.get(0).getRunStepId()).getRunstepStatus())) && Const.DIC_RUNSTEP_STATUS_SUCCESS.equals(runtimeStepMap.get(stepList.get(1).getRunStepId()).getRunstepStatus())) {
            stepList.get(0).setRunstepStatus(Const.DIC_RUNSTEP_STATUS_SKIP);
        }

    }

    /**
     * @Title 维护计划完成时间
     * @Author lcb
     * @Time 2019/6/24 11:40
     * @Desc
     **/
    private void dealRuntimeStepPlanFinishDate(Integer cityId, Integer dealId, List<ErpProcessRuntimeStep> stepList) {

        // 1:成交后多少天  2=前置步骤完成后多少天
        // 都是成交后的话  直接跳过
        if (1 == stepList.get(0).getTimelimit() && 1 == stepList.get(1).getTimelimit()) {
            return;
        }

        for (Integer i = 0; i < 2; i++) {
            if (1 == stepList.get(0).getTimelimit()) {
                if (2 == stepList.get(1).getTimelimit()) {
                    // 去找上一步
                    ErpProcessRuntimeStep beforeRuntimeStep = erpProcessRuntimeStepMapper.getBeforeRuntimeStep(cityId, dealId, stepList.get(0).getStepSeq());
                    if (null != beforeRuntimeStep && StringUtils.isNotBlank(beforeRuntimeStep.getTimelimitdate())) {
                        Date date = DateUtil.addDay(DateUtil.StringToDate(beforeRuntimeStep.getTimelimitdate()), stepList.get(1).getTimelimit());
                        stepList.get(1).setTimelimitdate(DateUtil.DateToString(date));
                    }
                }
            } else {
                if (1 == stepList.get(1).getTimelimit()) {
                    // 去找上一步
                    ErpProcessRuntimeStep beforeRuntimeStep = stepList.get(1);
                    if (null != beforeRuntimeStep && StringUtils.isNotBlank(beforeRuntimeStep.getTimelimitdate())) {
                        Date date = DateUtil.addDay(DateUtil.StringToDate(beforeRuntimeStep.getTimelimitdate()), stepList.get(1).getTimelimit());
                        stepList.get(0).setTimelimitdate(DateUtil.DateToString(date));
                    }
                } else {
                    // 两个都是前置流程多少天
                    // 去找上一步
                    ErpProcessRuntimeStep beforeRuntimeStep = erpProcessRuntimeStepMapper.getBeforeRuntimeStep(cityId, dealId, stepList.get(0).getStepSeq());
                    if (null != beforeRuntimeStep && StringUtils.isNotBlank(beforeRuntimeStep.getTimelimitdate())) {
                        Date date = DateUtil.addDay(DateUtil.StringToDate(beforeRuntimeStep.getTimelimitdate()), stepList.get(1).getTimelimit());
                        stepList.get(1).setTimelimitdate(DateUtil.DateToString(date));

                        stepList.get(0).setTimelimitdate(DateUtil.DateToString(DateUtil.addDay(date, stepList.get(0).getTimelimit())));
                    } else {
                        if (StringUtils.isNotBlank(stepList.get(1).getTimelimitdate())) {
                            Date date = DateUtil.addDay(DateUtil.StringToDate(stepList.get(1).getTimelimitdate()), stepList.get(0).getTimelimit());
                            stepList.get(0).setTimelimitdate(DateUtil.DateToString(date));
                        }
                    }
                }
            }
        }
    }

    /**
     * @Title 更新流程实例的执行步骤顺序
     * @Author lcb
     * @Time 2019/6/21 14:59
     * @Desc
     **/
    @ApiOperation("添加流程实例步骤，需求：9960  李成兵")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = InsertRunTimeStepVO.class, message = "成功")
    })
    @RequestMapping("/insertRunTimeStep")
    public ResponseJson insertRunTimeStep(@RequestBody InsertRunTimeStepParam param) throws Exception {
        Operator operator = getOperator();
        param.setCityId(operator.getCityId());
        param.setCompId(operator.getCompId());
        param.setUserId(operator.getUserId());
        param.setDeptId(operator.getDeptId());
        String currentUserName = getCurrentUserName();
        param.setCurrentUserName(currentUserName);
        param.setUserName(operator.getUserName());
        InsertRunTimeStepVO insertRunTimeStepVO = new InsertRunTimeStepVO();
        /**
         * 1.查询步骤模板
         * 2.处理执行时间，执行人添加为相关人
         * 3.写入权证流程日志
         * 4.*****考虑调整顺序，或者插入已完成步骤前状态问题
         * **/
        erpProcessRuntimeStepService.insertRunTimeStep(param, insertRunTimeStepVO);
        return ErpResponseJson.ok(insertRunTimeStepVO);
    }

    /**
     * @tag 添加或更新步骤模板
     * @author 邓永洪
     * @since 2018/5/15
     */
    @ApiOperation("添加或更新步骤模板")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
    })
    @PostMapping("/updateModelStepRelate")
    public ResponseJson updateModelStepRelate(@RequestBody UpdateModelStepRelateParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();

        // 权证流程管理权
        boolean operateFlag = erpUserOpersService.judgePermission(cityId, operator.getUserId(), "WARRANT_MANAGE");
        Assert.isTrueThrow(!operateFlag, "您没有权限操作此功能！请联系管理员开通！");

        Integer compId = operator.getCompId();
        ErpProcessModelStep model = getParamObj(ErpProcessModelStep.class);
        model.setCompId(compId);
        model.setShardCityId(cityId);

        // 是关联表更新来的
        if (null != param.getModelId()) {
            // 更新执行时间
            ErpModelStepRelateExample erpModelStepRelateExample = new ErpModelStepRelateExample();
            erpModelStepRelateExample.setShardCityId(cityId);
            erpModelStepRelateExample.createCriteria().andCompIdEqualTo(compId).andModelIdEqualTo(param.getModelId()).andStepIdEqualTo(param.getStepId());
            ErpModelStepRelate updatePo = new ErpModelStepRelate();

            updatePo.setTimelimit(param.getTimelimit());
            updatePo.setRpevstepId(param.getRpevstepId());
            updatePo.setRpevstepName(param.getRpevstepName());
            updatePo.setTimelimitType(param.getTimelimitType());
            erpModelStepRelateMapper.updateByExampleSelective(updatePo, erpModelStepRelateExample);
        }

        model.setRpevstepName(null);
        model.setRpevstepId(null);
        model.setTimelimit(null);
        model.setTimelimitType(null);
        erpProcessModelStepMapper.updateByPrimaryKeySelective(model);
        return ErpResponseJson.ok();
    }
@ApiOperation(value = "签约统计报表", httpMethod = "POST")
	@ApiResponses({@ApiResponse(code = 200, response = SignStatisticsListVO.class, message = "success")})
	@RequestMapping("/signStatisticsList")
	public ErpResponseJson signStatisticsList(@Valid @RequestBody SignStatisticsListParam param){
		Integer compId = getOperator().getCompId();
		Integer cityId = getOperator().getCityId();
		Integer userId = getOperator().getUserId();
		//如果没传就默认本月
		if(StringUtil.isEmpty(param.getStartTime())){
			param.setStartTime(DateUtil.DateToString(new Date()));
			param.setEndTime(DateUtil.DateToString(new Date()));
		}
		String firstDateOfMonth = DateTimeHelper.getFirstDayOfMonth(param.getStartTime());
		String lastdayOfMonth = DateTimeHelper.getLastDayOfMonth(param.getEndTime());
		param.setStartTime(firstDateOfMonth);
		param.setEndTime(lastdayOfMonth);
		List<SignStatisticsListVO> result = new ArrayList<>();
		Map<String,Object> res = new HashMap<>();
		//为空了就默认按门店
		if(null == param.getStatisticsType()){
			param.setStatisticsType(1);
		}
		//必须要用前面这条SQL分页，后面的需要GROUP BY
		PageHelper.startPage(param.getPageNum(), param.getPageSize(), true);
		List<Integer> groupByIds = erpFunDealMapper.selectGroupByDeptOrGr(cityId,compId,param.getStatisticsType());
		if(null == groupByIds || groupByIds.size() < 1){
			return ErpResponseJson.ok(res);
		}
		Set<Integer> ids = new HashSet(groupByIds);
		List<ErpFunDeptsgroup> grList = new ArrayList<>();
		List<ErpFunDepts> deptList = new ArrayList<>();
		//这条SQL查询的是门店或分组的租售的成交笔数
		List<SignStatisticsListVO> leaseAndSellDealNumVO = erpFunDealMapper.selectLeaseAndSellDealNum(cityId,compId,param.getStartTime(),param.getEndTime(),param.getStatisticsType(),groupByIds);
		//这条SQL查询的是主业主业入账实收
		result = erpFunDealMapper.selectSignList(cityId,param.getStartTime(),param.getEndTime(),param.getStatisticsType(),groupByIds);
		if(param.getStatisticsType() == 1){
			deptList = erpFunDeptsMapper.getDeptListByDeptIds(cityId, ids);
		} else if(param.getStatisticsType() == 2){
			Set<Integer> deptIds = new HashSet();
			grList = erpFunDeptsgroupMapper.getGrByGrIdsDel(cityId,compId,ids);
			for (ErpFunDeptsgroup gr : grList) {
				deptIds.add(gr.getDeptId());
			}
			deptList = erpFunDeptsMapper.getDeptListByDeptIds(cityId, deptIds);
		}

		for (SignStatisticsListVO resultVO : result ) {
			for (ErpFunDepts dept : deptList ) {
				if(resultVO.getSignSiteDept().toString().equals(dept.getDeptId().toString()) && StringUtil.isNotEmpty(dept.getDeptName())){
					resultVO.setSignSite(dept.getDeptCname());
				}
			}
			if(param.getStatisticsType() == 2){
				for (ErpFunDeptsgroup gr : grList ) {
					if(resultVO.getSignSiteGr().toString().equals(gr.getGrId().toString()) && StringUtil.isNotEmpty(gr.getGrName())){
						resultVO.setSignSite(resultVO.getSignSite()+"-"+gr.getGrName());
					}
				}
				for (SignStatisticsListVO leaseAndSellDealNum : leaseAndSellDealNumVO ) {
					if(resultVO.getSignSiteGr().toString().equals(leaseAndSellDealNum.getSignSiteGr().toString())){
						if(null != leaseAndSellDealNum.getDealType() && "101".equals(leaseAndSellDealNum.getDealType().toString())){
							resultVO.setSellDealNum(leaseAndSellDealNum.getNum());
						} else if (null != leaseAndSellDealNum.getDealType() && "102".equals(leaseAndSellDealNum.getDealType().toString())){
							resultVO.setLeaseDealNum(leaseAndSellDealNum.getNum());
						}
					}
				}
			}else {
				for (SignStatisticsListVO leaseAndSellDealNum : leaseAndSellDealNumVO ) {
					if(resultVO.getSignSiteDept().toString().equals(leaseAndSellDealNum.getSignSiteDept().toString())){
						if(null != leaseAndSellDealNum.getDealType() && "101".equals(leaseAndSellDealNum.getDealType().toString())){
							resultVO.setSellDealNum(leaseAndSellDealNum.getNum());
						} else if (null != leaseAndSellDealNum.getDealType() && "102".equals(leaseAndSellDealNum.getDealType().toString())){
							resultVO.setLeaseDealNum(leaseAndSellDealNum.getNum());
						}
					}
				}
			}
		}

		res.put("list",result);
		return ErpResponseJson.ok(res);
	}


	@ApiOperation(value = "财务审核列表", httpMethod = "POST")
	@ApiResponses({@ApiResponse(code = 200, response = FinancAuditListVO.class, message = "success")})
	@RequestMapping("/financAuditList")
	public ErpResponseJson financAuditList(@Valid @RequestBody FinancAuditListParam param){
		Integer compId = getOperator().getCompId();
		Integer cityId = getOperator().getCityId();

		if(StringUtil.isNotEmpty(param.getStartTime())){
			/***起始时间***/
			param.setStartTime(param.getStartTime() + " 00:00:00" );
			/***结束时间***/
			param.setEndTime(param.getEndTime() + " 23:59:59");
		}
		PageHelper.startPage(param.getPageNum(), param.getPageSize(), true);
		List<FinancAuditListVO> financAuditListVOS = erpFunDealMapper.selectFinancAuditList(cityId,compId,param);
		for (FinancAuditListVO financAuditListVO : financAuditListVOS) {
			financAuditListVO.setPerformanceName(this.judgePerformanceType(financAuditListVO.getPerformanceType(),null,null,null));
			financAuditListVO.setPfPayerName(this.judgePerformanceType(null,financAuditListVO.getPfPayer(),null,null));
			financAuditListVO.setPfGeterName(this.judgePerformanceType(null,null,financAuditListVO.getPfGeter(),null));
			financAuditListVO.setAuditName(this.judgePerformanceType(null,null,null,financAuditListVO.getAuditStatus()));
		}
		Map<String,Object> res = new HashMap<>();
		res.put("list",financAuditListVOS);
		return ErpResponseJson.ok(res);
	}

	public String judgePerformanceType(Byte performanceType,String pfPayer,String pfGeter,String auditStatus){
		//performanceType  1=过户 2=二手佣金 3=新房佣金 4=租赁租金 5=金融
		//pfPayer    付款方，1:客户 2:业主 3:中介   dic:PROCESS_FINANC_PAYER
		//pfGeter   收款方，1:客户 2:业主 3:中介 4：房管局 5：银行 6：评估公司 7：其他   dic:PROCESS_FINANC_GETER
		//auditStatus   财务款项审核状态0未审，1已审核  2=审核中 3=撤销审核中
		if(null != performanceType){
			if ("1".equals(performanceType.toString())){
				return "过户";
			} else if ("2".equals(performanceType.toString())){
				return "二手佣金";
			} else if ("3".equals(performanceType.toString())){
				return "新房佣金";
			} else if ("4".equals(performanceType.toString())){
				return "租赁租金";
			} else if ("5".equals(performanceType.toString())){
				return "金融";
			}
		}

		if(StringUtil.isNotEmpty(pfPayer)){
			if ("1".equals(pfPayer)){
				return "客户";
			} else if ("2".equals(pfPayer)){
				return "业主";
			} else if ("3".equals(pfPayer)){
				return "中介";
			}
		}

		if(StringUtil.isNotEmpty(pfGeter)){
			if ("1".equals(pfGeter)){
				return "客户";
			} else if ("2".equals(pfGeter)){
				return "业主";
			} else if ("3".equals(pfGeter)){
				return "中介";
			} else if ("4".equals(pfGeter)){
				return "房管局";
			} else if ("5".equals(pfGeter)){
				return "银行";
			} else if ("6".equals(pfGeter)){
				return "评估公司";
			} else if ("7".equals(pfGeter)){
				return "其他";
			}
		}
		if(StringUtil.isNotEmpty(auditStatus)){
			if("0".equals(auditStatus)){
				return "未审";
			} else if ("1".equals(auditStatus)){
				return "已审核";
			} else if ("2".equals(auditStatus)){
				return "审核中";
			} else if ("3".equals(auditStatus)){
				return "撤销审核中";
			}
		}
		return null;
	}
}
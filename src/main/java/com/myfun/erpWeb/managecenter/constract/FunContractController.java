package com.myfun.erpWeb.managecenter.constract;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.extension.framework.mq.context.MqUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.constract.param.*;
import com.myfun.erpWeb.managecenter.constract.vo.*;
import com.myfun.erpWeb.managecenter.deal.param.DealAuditCommonParam;
import com.myfun.erpWeb.managecenter.deal.param.DealBussinessCommonParam;
import com.myfun.erpWeb.managecenter.deal.vo.DealAuditCommonVO;
import com.myfun.erpWeb.managecenter.profit.param.HandProfitListParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.DeleteDealPayParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.EditBankParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.GetLoanBankParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.IdParam;
import com.myfun.erpWeb.managecenter.transaction.param.HouseOrCustomerEnclosureParam;
import com.myfun.erpWeb.managecenter.transaction.vo.EnclosureVo;
import com.myfun.erpWeb.managecenter.transaction.vo.HouseBriefInfoVO;
import com.myfun.erpWeb.managecenter.transaction.vo.HouseOrCustomerEnclosureVo;
import com.myfun.erpWeb.managecenter.transaction.vo.RuntimeStepVO;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.session.RequestSourceConst;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.*;
import com.myfun.repository.admindb.dto.AdminJrFinanceInfoDto;
import com.myfun.repository.admindb.po.*;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.*;
import com.myfun.repository.erpdb.param.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.erpdb.po.ErpFunDealRecordExample.Criteria;
import com.myfun.repository.jms.JmsMsgAction;
import com.myfun.repository.jms.JmsPublisher;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.admindb.AdminFunCompService;
import com.myfun.service.business.admindb.AdminFunDeptsService;
import com.myfun.service.business.admindb.AdminJmsMessageService;
import com.myfun.service.business.admindb.AdminMobileKeyService;
import com.myfun.service.business.erpdb.*;
import com.myfun.service.business.erpdb.bean.vo.UserOrganizationInfoVO;
import com.myfun.service.jms.TaskQueueThread;
import com.myfun.service.jms.activeMQ.ActiveMqPublisher;
import com.myfun.service.jms.bean.YouJiaWxPushMessage;
import com.myfun.service.push.YoujiaWXPushUtil;
import com.myfun.utils.*;
import io.swagger.annotations.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 管理中心合同模块
 * lcb
 */
@Api(tags = "管理中心合同模块")
@RequestMapping(value = "/managerCenter/contract")
@RestController
public class FunContractController extends BaseController {

    @Autowired
    ErpFunContractIndexMapper erpFunContractIndexMapper;
    @Autowired
    ErpFunContractTemplaeMapper erpFunContractTemplaeMapper;
    @Autowired
    ErpFunIndexTemplateMapper erpFunIndexTemplateMapper;
    @Autowired
    ErpFunIndexValueMapper erpFunIndexValueMapper;
    @Autowired
    ErpFunContractMapper erpFunContractMapper;
    @Autowired
    ErpFunContractTagMapper erpFunContractTagMapper;
    @Autowired
    ErpFunDealMapper erpFunDealMapper;
    @Autowired
    AdminWeiUserInfoMapper adminWeiUserInfoMapper;
    @Autowired
    ErpFunContractIndexService erpFunContractIndexService;
    @Autowired
    ErpFunContractTemplateService erpFunContractTemplateService;
    @Autowired
    ErpUserOpersMapper erpUserOpersMapper;
    @Autowired
    ErpDealUserRelativeMapper erpDealUserRelativeMapper;
    @Autowired
    ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
    @Autowired
    ErpFunRentCustomerMapper erpFunRentCustomerMapper;
    @Autowired
    ErpFunSaleMapper erpFunSaleMapper;
    @Autowired
    ErpFunLeaseMapper erpFunLeaseMapper;
    @Autowired
    AdminFunCompMapper adminFunCompMapper;
    @Autowired
    AdminSysParaMapper adminSysParaMapper;
    @Autowired
    AdminFunDeptsMapper adminFunDeptsMapper;
    @Autowired
    ErpFunDeptsMapper erpFunDeptsMapper;
    @Autowired
    AdminFunDeptsService adminFunDeptsService;
    @Autowired
    ErpFunUsersMapper erpFunUsersMapper;
    @Autowired
    ErpFunBrokerageIncomeMapper erpFunBrokerageIncomeMapper;
    @Autowired
    ErpFunBrokerageIncomeService erpFunBrokerageIncomeServie;
    @Autowired
    ErpFunBrokerageMapper erpFunBrokerageMapper;
    @Autowired
    ErpFunContractCategoryMapper erpFunContractCategoryMapper;
    @Autowired
    ErpFunContractCategoryService erpFunContractCategoryService;
    @Autowired
    ErpFunFinancPaymentMapper erpFunFinancPaymentMapper;
    @Autowired
    ErpFunFinancPaymentService erpFunFinancPaymentService;
    @Autowired
    ErpFunFinanceStatusMapper erpFunFinanceStatusMapper;
    @Autowired
    ErpFunFinanceStatusService erpFunFinanceStatusService;
    @Autowired
    ErpFunDealPaytypeMapper erpFunDealPaytypeMapper;
    @Autowired
    ErpFunDealPaytypeService erpFunDealPaytypeService;
    @Autowired
    ErpFunLoanBankMapper erpFunLoanBankMapper;
    @Autowired
    ErpFunLoanBankService erpFunLoanBankService;
    @Autowired
    ErpFunDealPhotoMapper erpFunDealPhotoMapper;
    @Autowired
    AdminJrFinanceInfoMapper adminJrFinanceInfoMapper;
    @Autowired
    ErpSysParaMapper erpSysParaMapper;
    @Autowired
    ErpFunDealCodelogMapper erpFunDealCodelogMapper;
    @Autowired
    ErpFunDealCodeMapper erpFunDealCodeMapper;
    @Autowired
    ErpFunContractDealMapper erpFunContractDealMapper;
    @Autowired
    ErpFunContractService erpFunContractService;
    @Autowired
    ErpFunRegMapper erpFunRegMapper;
    @Autowired
    ErpUserOpersService erpUserOpersService;
    @Autowired
    ErpFunSaleToLeaseMapper erpFunSaleToLeaseMapper;
    @Autowired
    ErpBuildingInfoMapper erpBuildingInfoMapper;
    @Autowired
    ErpFunDealService erpFunDealService;
    @Autowired
    AdminJmsMessageService adminJmsMessageService;
    @Autowired
    ErpFunDealRecordService erpFunDealRecordService;
    @Autowired
    ErpFunDealPhotoService erpFunDealPhotoService;
    @Autowired
    ErpFunUsersService erpFunUsersService;
    @Autowired
    ErpFunTaskService erpFunTaskService;
    @Autowired
    ErpPosPaymentOrderMapper erpPosPaymentOrderMapper;
    @Autowired
    ErpFunContractTagService erpFunContractTagService;
    @Autowired
    AdminMobileKeyService adminMobileKeyService;
    @Autowired
    ErpFunDealRecordMapper erpFunDealRecordMapper;
    @Autowired
    ErpFunLeaseToSaleMapper erpFunLeaseToSaleMapper;
    @Autowired
    ErpFunDealTaxesRecordMapper erpFunDealTaxesRecordMapper;
    @Autowired
    ErpProcessRuntimeStepService erpProcessRuntimeStepService;
    @Autowired
    ErpDealUserRelativeService erpDealUserRelativeService;
    @Autowired
    MqUtil mqUtil;
    @Autowired
    AdminFunArchiveMapper adminFunArchiveMapper;
    @Autowired
    ErpProcessFinancMapper erpProcessFinancMapper;
    @Autowired
    ErpFunProfitMapper erpFunProfitMapper;
    @Autowired
    ErpProcessRuntimeStepMapper erpProcessRuntimeStepMapper;
    @Autowired
    ErpAuditRuntimeService erpAuditRuntimeService;
    @Autowired
    ErpFunDealTrackMapper erpFunDealTrackMapper;
    @Autowired
    ErpFunTaskMapper erpFunTaskMapper;
    @Autowired
    ErpFunCompMapper erpFunCompMapper;
    @Autowired
    ErpFunUserManageRangeMapper erpFunUserManageRangeMapper;
    @Resource
    private ErpSsqContractMapper erpSsqContractMapper;
    @Autowired
    ErpDicDefinitionsMapper erpDicDefinitionsMapper;
    @Autowired
    ErpFunHouseFileMapper erpFunHouseFileMapper;
    @Autowired
    ErpFunDeptsgroupMapper erpFunDeptsgroupMapper;
    @Autowired
    AdminFunCompService adminFunCompService;
    @Autowired
    ErpFunCustFileMapper erpFunCustFileMapper;
    @Autowired
    ErpProcessFinanceService erpProcessFinanceService;
    @Autowired
    ErpFunDepositService erpFunDepositService;
    @Autowired
    ErpFunEarbestMoneyService erpFunEarbestMoneyService;
    @Autowired
    ActiveMqPublisher activeMqPublisher;
    @Autowired
    private ErpAuditTemplateMapper erpAuditTemplateMapper;
    @Autowired
    private ErpFunOrganizationMapper erpFunOrganizationMapper;
    @Autowired
    private ErpFunOrganizationDefinitionMapper erpFunOrganizationDefinitionMapper;
    @Autowired
    private ErpSysParaService erpSysParaService;

    /**
     * 查询指标参数列表
     * lcb
     **/
    @RequestMapping("/getTemplateParamList")
    public ResponseJson getTemplateParamList() {
        Operator operator = getOperator();
        ErpFunContractIndexExample erpFunContractIndexExample = new ErpFunContractIndexExample();
        erpFunContractIndexExample.setShardCityId(operator.getCityId());
        ErpFunContractIndexExample.Criteria criteria = erpFunContractIndexExample.createCriteria();
        criteria.andCompIdEqualTo(operator.getCompId());
        criteria.andIndexStatusEqualTo(new Byte(Constants_DIC.DIC_CONTRACT_INDEX_STATUS_1));
        List<ErpFunContractIndex> resList = erpFunContractIndexMapper.selectByExample(erpFunContractIndexExample);
        return ErpResponseJson.ok(resList);
    }

    /**
     * 查询合同模板列表
     * lcb
     **/
    @RequestMapping("/getContractTemplateList")
    public ResponseJson getContractTemplateList(@RequestBody ErpFunContractTemplaeParam erpFunContractTemplae) {
        Operator operator = getOperator();
        Boolean youJiaDeptFlag = getOperator().youJiaDeptFlag();
        String youCityDealNeedExamine = "0";
        if ("1".equals(String.valueOf(operator.getAttribute("YOU_CITY_DEAL_NEED_EXAMINE"))) &&
                ("1".equals(String.valueOf(operator.getAttribute("YOU_SALE_DEAL_NEED_EXAMINE"))) || "1".equals(String.valueOf(operator.getAttribute("YOU_LEASE_DEAL_NEED_EXAMINE"))))) {
            youCityDealNeedExamine = "1";
        }
        if (null == erpFunContractTemplae) {
            return ErpResponseJson.ok();
        }
        PageHelper.startPage(erpFunContractTemplae.getPageOffset(), erpFunContractTemplae.getPageRows(), erpFunContractTemplae.isNeedCount());
        List<ErpFunContractTemplae> resList = erpFunContractTemplaeMapper.getTemplatList(operator.getCityId(), youCityDealNeedExamine, youJiaDeptFlag, erpFunContractTemplae.getTemplateType(), operator.getCompId());
        return ErpResponseJson.ok(resList);
    }

    /**
     * 查询单个模板
     * lcb
     **/
    @RequestMapping("/getTemplate")
    public ResponseJson getTemplate(@RequestBody ErpFunContractTemplaeParam erpFunContractTemplaeParam) {
        Map<String, Object> resMap = new HashMap<>();
        Operator operator = getOperator();
        ErpFunContractTemplae erpFunContractTemplae = new ErpFunContractTemplae();
        erpFunContractTemplae.setShardCityId(operator.getCityId());
        erpFunContractTemplae.setTemplateId(erpFunContractTemplaeParam.getTemplateId());
        // 查询模板基本数据
        erpFunContractTemplae = erpFunContractTemplaeMapper.selectByPrimaryKey(erpFunContractTemplae);

        // 查询模板参数列表
        ErpFunContractIndexExample erpFunContractIndexExample = new ErpFunContractIndexExample();
        erpFunContractIndexExample.setShardCityId(operator.getCityId());
        erpFunContractIndexExample.createCriteria().andTemplateIdEqualTo(erpFunContractTemplaeParam.getTemplateId());
        List<ErpFunContractIndex> erpFunContractIndices = erpFunContractIndexMapper.selectByExample(erpFunContractIndexExample);

        resMap.put("template", erpFunContractTemplae);
        resMap.put("indexList", erpFunContractIndices);
        return ErpResponseJson.ok(resMap);
    }

    /**
     * 查询系统指标列表
     * lcb
     *
     * @Param caseType 101/102
     **/

    @RequestMapping("/getSystemIndexList")
    public ResponseJson getSystemIndexList(@RequestBody ErpFunContractTemplaeParam erpFunContractTemplaeParam) {
        Operator operator = getOperator();
        ErpFunContractIndexExample erpFunContractIndexExample = new ErpFunContractIndexExample();
        erpFunContractIndexExample.setShardCityId(operator.getCityId());
        ErpFunContractIndexExample.Criteria criteria = erpFunContractIndexExample.createCriteria();
        criteria.andIndexStatusEqualTo(new Byte(Constants_DIC.DIC_CONTRACT_INDEX_STATUS_1)).andUniqueKeyIsNull()
                .andFunDealFieldIsNotNull().andCompIdEqualTo(0).
                andCaseTypeEqualTo(erpFunContractTemplaeParam.getCaseType().byteValue());
        erpFunContractIndexExample.setOrderByClause(" INDEX_SEQ ASC ");
        List<ErpFunContractIndex> resList = erpFunContractIndexMapper.selectByExample(erpFunContractIndexExample);

        for (ErpFunContractIndex erpFunContractIndex : resList) {
            String funDealField = erpFunContractIndex.getFunDealField();
            if (StringUtils.isNotBlank(funDealField)) {

                erpFunContractIndex.setFunDealField(StringUtil.changeUnderLine(funDealField));
            }
        }
        return ErpResponseJson.ok(resList);
    }

    /**
     * 查询指定合同数据
     * lcb
     *
     * @Param
     **/

    @RequestMapping("/getContract")
    public ResponseJson getContract(@RequestBody ErpFunContractTemplaeParam erpFunContractTemplaeParam) {
        Integer contractId = Integer.valueOf(erpFunContractTemplaeParam.getContractIds());
        Operator operator = getOperator();
        // 合同内容
        ErpFunContract erpFunContract = new ErpFunContract();
        erpFunContract.setShardCityId(operator.getCityId());
        erpFunContract.setContractId(Integer.valueOf(contractId));
        erpFunContract = erpFunContractMapper.selectByPrimaryKey(erpFunContract);

        List<Integer> contractIds = Arrays.asList(new Integer[]{contractId});
        // 指标值
        List<ErpFunIndexValueDto> indexValueList = erpFunIndexValueMapper.getIndexValueList(operator.getCityId(), contractIds, null);

        // 查询合同信息
        ErpFunDeal erpFunDeal = erpFunDealMapper.selectFunDealByContractId(operator.getCityId(), operator.getCompId(), contractId);

        List<ErpFunContractTagDto> resList = new ArrayList<>();
        Byte eight = new Byte("8");
        Byte three = new Byte("3");
        Boolean flag = eight.equals(erpFunDeal.getDealAuditStatus()) || three.equals(erpFunDeal.getDealAuditStatus()) ||
                eight.equals(erpFunDeal.getYouAduitStatusProtocol()) || three.equals(erpFunDeal.getYouAduitStatusProtocol());
        // 等待一审 或者 一审未通过
        if (null != erpFunDeal && flag) {
            // 查询标注列表
            resList = erpFunContractTagMapper.selectListDto(operator.getCityId(), contractId, operator.getCompId(), operator.getDeptId());

            Set<Integer> laywerId = new HashSet<>();
            // 关联律师信息
            for (ErpFunContractTag erpFunContractTag : resList) {
                laywerId.add(erpFunContractTag.getCreateUid());
            }

            if (laywerId.size() > 0) {
                AdminWeiUserInfoExample adminWeiUserInfoExample = new AdminWeiUserInfoExample();
                adminWeiUserInfoExample.createCriteria().andWeiUserIdIn(new ArrayList<>(laywerId));
                List<AdminWeiUserInfo> laywerList = adminWeiUserInfoMapper.selectByExample(adminWeiUserInfoExample);
                for (ErpFunContractTagDto erpFunContractTagDto : resList) {
                    for (AdminWeiUserInfo adminWeiUserInfo : laywerList) {
                        if (erpFunContractTagDto.getCreateUid().equals(adminWeiUserInfo.getWeiUserId())) {
                            erpFunContractTagDto.setLaywerName(adminWeiUserInfo.getUserName());
                        }
                    }
                }
            }
        }
        // 批注列表
        Map<String, Object> resMap = new HashMap<>();
        if (null != erpFunContract && null != erpFunContract.getTemletId()) {
            // 判断模板
            ErpFunContractTemplae erpFunContractTemplae = new ErpFunContractTemplae();
            erpFunContractTemplae.setTemplateId(erpFunContract.getTemletId());
            erpFunContractTemplae = erpFunContractTemplaeMapper.selectByPrimaryKey(erpFunContractTemplae);
            if (null != erpFunContractTemplae && StringUtils.isNotBlank(erpFunContractTemplae.getTemplateContent())) {
                erpFunContract.setContractContent(erpFunContractTemplae.getTemplateContent());
            }
        }
        resMap.put("contract", erpFunContract);
        resMap.put("indexList", indexValueList);
        resMap.put("tagList", resList);
        return ErpResponseJson.ok(resMap);
    }

    /**
     * 检测合同是否生成
     * lcb
     *
     * @Param caseType 101/102
     **/

    @RequestMapping("/checkContractStatus")
    public ResponseJson checkContractStatus(@RequestBody ErpFunContractTemplaeParam erpFunContractTemplaeParam) {
        Map<String, Object> rMap = new HashMap<>();
        String contractStatus = "0";
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();

        ErpFunDeal erpFunDeal = erpFunDealMapper.selectByDealId(cityId, erpFunContractTemplaeParam.getDealId(), new String[]{"CONTRACT_ID", "PROTOCOL_ID"});
        if (null != erpFunDeal) {
            Integer contractId = erpFunDeal.getContractId();
            if ("2".equals(erpFunContractTemplaeParam.getContentType())) {
                contractId = erpFunDeal.getProtocolId();
            }
            if (null != erpFunDeal && null != contractId) {
                ErpFunContract erpFunContract = new ErpFunContract();
                erpFunContract.setShardCityId(cityId);
                erpFunContract.setContractId(contractId);
                Map<String, Object> resMap = erpFunContractMapper.getLinkInfo(erpFunContract);
                contractStatus = "1";
                rMap.put("creationTime", resMap.get("creationTime"));
                rMap.put("deptName", resMap.get("deptName"));
                rMap.put("userId", resMap.get("userId"));
                rMap.put("userName", resMap.get("userName"));
            }
        }
        rMap.put("contractStatus", contractStatus);

        return ErpResponseJson.ok(rMap);
    }

    /**
     * 删除合同指标
     * lcb
     *
     * @Param
     **/

    @RequestMapping("/delTemplateParam")
    public ResponseJson delTemplateParam(@RequestBody ErpFunContractTemplaeParam erpFunContractTemplaeParam) {
        ErpFunContractIndex erpFunContractIndex = new ErpFunContractIndex();
        erpFunContractIndex.setIndexStatus(new Byte("0"));

        ErpFunContractIndexExample erpFunContractIndexExample = new ErpFunContractIndexExample();
        erpFunContractIndexExample.setShardCityId(getOperator().getCityId());
        erpFunContractIndexExample.createCriteria().andIndexIdEqualTo(erpFunContractTemplaeParam.getIndexId()).andCompIdEqualTo(getOperator().getCompId());
        erpFunContractIndexMapper.updateByExampleSelective(erpFunContractIndex, erpFunContractIndexExample);
        return ErpResponseJson.ok();
    }

    /**
     * 删除合同模板列表
     * lcb
     *
     * @Param
     **/

    @RequestMapping("/delContractTemplate")
    public ResponseJson delContractTemplate(@RequestBody ErpFunContractTemplaeParam erpFunContractTemplaeParam) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        ErpFunContractTemplae erpFunContractKey = new ErpFunContractTemplae();
        erpFunContractKey.setShardCityId(cityId);
        erpFunContractKey.setTemplateId(erpFunContractTemplaeParam.getTemplateId());
        ErpFunContractTemplae erpFunContractModel = erpFunContractTemplaeMapper.selectByPrimaryKey(erpFunContractKey);
        ErpFunContractTemplae erpFunContractTemplae = new ErpFunContractTemplae();
        erpFunContractTemplae.setTemplateStatus(new Byte("0"));
        String youCityDealNeedExamine = "0";
        if ("1".equals(String.valueOf(operator.getAttribute("YOU_CITY_DEAL_NEED_EXAMINE"))) && ("1".equals(String.valueOf(operator.getAttribute("YOU_SALE_DEAL_NEED_EXAMINE"))) || "1".equals(String.valueOf(operator.getAttribute("YOU_LEASE_DEAL_NEED_EXAMINE"))))) {
            youCityDealNeedExamine = "1";
        }
        boolean youJiaDeptFlag = getOperator().youJiaDeptFlag();
        int templeteCount = erpFunContractTemplaeMapper.countContractTemplete(cityId, compId, youCityDealNeedExamine, youJiaDeptFlag, erpFunContractModel.getTemplateType());
        if (templeteCount == 1) {
            throw new BusinessException("当前只剩下一个模板了，不允许删除！");
        }
        ErpFunContractTemplaeExample erpFunContractTemplaeExample = new ErpFunContractTemplaeExample();
        erpFunContractTemplaeExample.setShardCityId(getOperator().getCityId());
        erpFunContractTemplaeExample.createCriteria().andTemplateIdEqualTo(erpFunContractTemplaeParam.getTemplateId()).andCompIdEqualTo(getOperator().getCompId());
        erpFunContractTemplaeMapper.updateByExampleSelective(erpFunContractTemplae, erpFunContractTemplaeExample);
        return ErpResponseJson.ok();
    }

    /**
     * 添加参数指标
     * lcb
     *
     * @Param
     **/

    @RequestMapping("/addOrEditTemplateParam")
    public ResponseJson addOrEditTemplateParam(@RequestBody ErpFunContractIndexParam erpFunContractIndexParam) {
        Operator operator = getOperator();
        List<ErpFunContractIndex> paramList = JSONObject.parseArray(erpFunContractIndexParam.getIndexList(), ErpFunContractIndex.class);
        // 需要事务控制
        String ids = erpFunContractIndexService.addOrEditTemplate(operator.getCityId(), operator.getCompId(), paramList);
        return ErpResponseJson.ok(ids);
    }

    /**
     * 添加编辑模板
     * lcb
     *
     * @Param
     **/
    @RequestMapping("/addOrEditContractTemplate")
    public ResponseJson addOrEditContractTemplate(@RequestBody ErpFunContractTemplaeParam erpFunContractTemplaeParam) {
        Operator operator = getOperator();

        // 内容复制
        ErpFunContractTemplae erpFunContractTemplae = new ErpFunContractTemplae();
        BeanUtils.copyProperties(erpFunContractTemplaeParam, erpFunContractTemplae);

        List<ErpFunContractIndex> paramList = JSONObject.parseArray(erpFunContractTemplaeParam.getIndexList(), ErpFunContractIndex.class);
        // 需要事务控制

        erpFunContractTemplae.setShardCityId(operator.getCityId());
        erpFunContractTemplateService.addOrEditContractTemplate(operator.getCityId(), operator.getCompId(), erpFunContractTemplae, paramList);

        return ErpResponseJson.ok(null);
    }

    /**
     * 添加合同
     * lcb
     *
     * @Param
     **/

    @RequestMapping("/saveContract")
    public ResponseJson saveContract(@RequestBody ErpFunContractTemplaeParam erpFunContractTemplaeParam) throws Exception {
        Operator operator = getOperator();
        Integer contractId = erpFunContractTemplateService.saveContract(operator.getCityId(), operator.getCompId(),
                erpFunContractTemplaeParam, operator.getDeptId(), operator.getUserId(), operator.getUserName());
        return ErpResponseJson.ok(contractId);
    }

    ///////////////////////////////以上是优家的接口////////////////////////////////////

    /**
     * 查询合同详情
     * lcb
     *
     * @Param
     **/
    @ApiOperation("查询合同详情")
    @RequestMapping("/getMgrDealDetailedData")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunDealDtoVo.class, message = "成功")
    })
    @ResponseBody
    public ResponseJson getMgrDealDetailedData(@RequestBody ErpFunDealDetailParam param) throws Exception {
        Operator operator = getOperator();
        ErpFunDealDtoVo erpFunDealDtoVo = new ErpFunDealDtoVo();
        Integer cityId = operator.getCityId();
        if (operator.newOrganizationType()) {
            this.checkAuthSeeDealNewOrg(operator, param.getDealId(), erpFunDealDtoVo); // 检查合同能否查看
        } else {
            this.checkAuthSeeDeal(operator, param.getDealId(), erpFunDealDtoVo); // 检查合同能否查看
        }

        ErpFunDeal erpFunDeal = new ErpFunDeal();
        erpFunDeal.setShardCityId(operator.getCityId());
        erpFunDeal.setDealId(param.getDealId());
        ErpFunDealDto erpFundealDto = erpFunDealMapper.getFunDealDto(erpFunDeal);
        Byte rentPayMethod = erpFundealDto.getRentPayMethod();
        String rent_account = erpDicDefinitionsMapper.getDicCnMsg(cityId, "RENT_ACCOUNT", rentPayMethod + "");
        erpFunDealDtoVo.setRentPayMethodText(rent_account);
        Integer ownerStyle = erpFundealDto.getOwnerStyle();
        String houseRight = erpDicDefinitionsMapper.getDicCnMsg(cityId, "HOUSE_RIGHT", ownerStyle + "");
        erpFunDealDtoVo.setOwnerStyleText(houseRight);
        erpFunDealDtoVo.setAreaText(erpFundealDto.getArea() + "㎡");
        if (erpFundealDto.getDealType() == 102) {
            erpFunDealDtoVo.setDealMoney(erpFundealDto.getRentDealMoney() + "");
        } else {
            erpFunDealDtoVo.setDealMoney(erpFundealDto.getSellDealMoney() + "");
        }
        String uuHaofang = AppConfig.getUuHaofang();
        Integer contractId = erpFundealDto.getContractId();
        String contractUrl = uuHaofang + "B/Home/ZtContract/editContract?cityId="
                + cityId + "&dealId=" + param.getDealId() + "&caseType=" + erpFundealDto.getDealType() + "&contractId=" + contractId;
        erpFunDealDtoVo.setContractUrl(contractUrl);// 在线签约合同地址。
//        if (null != contractId) {
//            String qrcodeUrl = uuHaofang + "Api/QrApi/onlineContractQrCode?archiveId=" + operator.getArchiveId() + "&contractId=" + contractId;
//            erpFunDealDtoVo.setAppletQrcode(qrcodeUrl);
//        }
//        http://uuweb.hftsoft.com/Api/QrApi/onlineContractQrCode?archiveId=558818&dealId=12&cityId=1&erpCompId=12001&userId=19584
        String qrcodeUrl = uuHaofang + "Api/QrApi/onlineContractQrCode?archiveId=" + operator.getArchiveId() + "&dealId=" + param.getDealId() +
                "&cityId=" + cityId + "&erpCompId=" + operator.getErpCompId() + "&userId=" + operator.getUserId();
        erpFunDealDtoVo.setAppletQrcode(qrcodeUrl);

        Integer compId = operator.getAdminCompId();
        AdminFunComp adminFunComp = adminFunCompMapper.selectByCompId(compId);
        erpFunDealDtoVo.setThirdcompName(adminFunComp.getCompName());//用户公司名称
        erpFunDealDtoVo.setThirdaddress(adminFunComp.getCompAddr());// 用户公司地址
        erpFunDealDtoVo.setThirdcompPhoneNum(adminFunComp.getCompTele());//用户公司电话


        if (null != erpFundealDto) {
            //查询合同介绍人和合同促成人
            if (erpFundealDto.getIntroducerId() != null) {
                ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, erpFundealDto.getIntroducerId());
                if (erpFunUsers != null) {
                    erpFundealDto.setIntroducerName(erpFunUsers.getUserName());
                    erpFundealDto.setIntroducerPhone(erpFunUsers.getUserMobile());
                }
            }
            if (erpFundealDto.getAdultPromotionId() != null) {
                ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, erpFundealDto.getAdultPromotionId());
                if (erpFunUsers != null) {
                    erpFundealDto.setAdultPromotionName(erpFunUsers.getUserName());
                    erpFundealDto.setAdultPromotionPhone(erpFunUsers.getUserMobile());
                }
            }
            //签约地点
            if (erpFundealDto.getSignSiteDept() != null) {
                ErpFunDepts erpFunDepts = erpFunDeptsMapper.getDeptByCompNoAndDeptId(cityId, erpFundealDto.getSignSiteDept());
                if (erpFunDepts != null) {
                    erpFundealDto.setSignSiteDeptName(erpFunDepts.getDeptCname());
                }
            }
            if (erpFundealDto.getSignSiteGr() != null) {
                ErpFunDeptsgroup deptsgroup = erpFunDeptsgroupMapper.getDataByGrId(cityId, erpFundealDto.getSignSiteGr());
                if (deptsgroup != null) {
                    erpFundealDto.setSignSiteGrName(deptsgroup.getGrName());
                }
            }
            if (!Const.DIC_DEAL_STATUS_DEALOVER.equals(erpFundealDto.getDealStatus())
                    && !Const.DIC_DEAL_COMPLETE_FAIL.equals(erpFundealDto.getDealAuditStatus())) {
                erpFundealDto.setCustomerphoneCanUpgrade(isCustInfoUpdate(operator.getCityId(), operator.getCompId(), erpFundealDto));
                erpFundealDto.setOwnerphoneCanUpgrade(isHouseInfoUpdate(operator.getCityId(), erpFundealDto));
            }
            List<String> operIds = Arrays.asList(new String[]{"DEAL_INITIAL_REVIEW", "DEAL_REPEAT_REVIEW"});
            ErpUserOpersExample erpUserOpersExample = new ErpUserOpersExample();
            erpUserOpersExample.setShardCityId(operator.getCityId());
            erpUserOpersExample.createCriteria().andUserIdEqualTo(operator.getUserId()).andOperIdIn(operIds);
            List<ErpUserOpers> erpUserOpers = erpUserOpersMapper.selectByExample(erpUserOpersExample);

            if (!isShowPhone(erpFundealDto.getDealAuditStatus(), erpUserOpers)) {
                if (null != erpFundealDto.getDealHouseId()) {
                    String phone = SyncUtil.getDecodePhone(erpFundealDto.getSellOwnerPhoneencode());
                    erpFundealDto.setSellOwnerPhone(phone);
                    phone = SyncUtil.getDecodePhone(erpFundealDto.getSellOwnerNameBak());
                    erpFundealDto.setSellOwnerPhoneBak(phone);
                } else {
                    if (StringUtils.isNotBlank(erpFundealDto.getSellOwnerPhone())) {
                        String phone = SyncUtil.getDecodePhone(erpFundealDto.getSellOwnerPhoneencode());
                        erpFundealDto.setSellOwnerPhone(phone);
                    }
                    if (StringUtils.isNotBlank(erpFundealDto.getSellOwnerPhoneBak())) {
                        String phone = SyncUtil.getDecodePhone(erpFundealDto.getSellOwnerPhoneBak());
                        erpFundealDto.setSellOwnerPhoneBak(phone);
                    }
                }
                if (null != erpFundealDto.getDealCustomerId()) {
                    String phone = SyncUtil.getDecodePhone(erpFundealDto.getBuyCustomerPhoneencode());
                    erpFundealDto.setBuyCustomerPhone(phone);
                } else {
                    if (StringUtils.isNotBlank(erpFundealDto.getBuyCustomerPhone())) {
                        String phone = SyncUtil.getDecodePhone(erpFundealDto.getBuyCustomerPhoneencode());
                        erpFundealDto.setBuyCustomerPhone(phone);
                    }
                }
            }

            erpFundealDto.setSellOwnerPhoneencode(null);
            erpFundealDto.setBuyCustomerPhoneencode(null);
//			funDealQRCodeVO.setFunDealPO(funDealPO);
            if (Constants_DIC.DIC_CASE_TYPE_SALE_DEAL.equals(erpFundealDto.getDealType().toString())) {
                // 无企业微店的公司，合同文本页增加二维码显示
                //if (getCompWeixinStatus(operator)) {}
                String hftQrAddr = adminSysParaMapper.selectParamVlue("HFT_QR_URL");
                hftQrAddr = hftQrAddr + "/" + getOperator().getAdminCompId() + "/" + erpFundealDto.getContractNo();
                erpFundealDto.setHftdealQraddr(hftQrAddr);
            }

            ErpFunDepts erpFunDepts = new ErpFunDepts();
            erpFunDepts.setShardCityId(operator.getCityId());
            erpFunDepts.setDeptId(erpFundealDto.getDeptId());
            // 查询优家对接人
            erpFunDepts = erpFunDeptsMapper.selectByPrimaryKey(erpFunDepts);

            List<AdminWeiUserInfo> youConnectorList = adminFunDeptsService.getYouConnectorList(erpFunDepts.getCompNo(), erpFunDepts.getDeptNo());
            if (youConnectorList.size() > 0) {
                AdminWeiUserInfo adminWeiUserInfoPO = youConnectorList.get(0);
                erpFundealDto.setYouDockingUid(adminWeiUserInfoPO.getUserName());
                erpFundealDto.setYouDockingMobile(adminWeiUserInfoPO.getUserMobile());
            }

            // 查询并设置签约人电话

            ErpFunUsers funUsersPO = erpFunUsersMapper.getFunUsersBaseInfo(erpFundealDto.getSignUserId(), operator.getCityId());
            if (funUsersPO != null) {
                erpFundealDto.setSignUserPhone(funUsersPO.getUserMobile());
            }

            // 如果是优家的，判断是否有贷款信息，如果有 返回贷款合同的ID
            if (operator.youJiaDeptFlag()) {
                // 查询金融对象
                AdminJrFinanceInfoExample adminJrFinanceInfoExample = new AdminJrFinanceInfoExample();
                adminJrFinanceInfoExample.createCriteria().andCompNoEqualTo(operator.getCompNo())
                        .andDeptNoEqualTo(operator.getDeptNo()).andDealIdEqualTo(erpFundealDto.getDealId());
                List<AdminJrFinanceInfo> adminJrFinanceInfos = adminJrFinanceInfoMapper.selectByExample(adminJrFinanceInfoExample);
                if (adminJrFinanceInfos.size() > 0) {
                    erpFundealDto.setJrFinanceId(adminJrFinanceInfos.get(0).getId());
                }
            }

            // 查询合同处理关系
            ErpFunContractDealExample erpFunContractDealExample = new ErpFunContractDealExample();
            erpFunContractDealExample.setShardCityId(operator.getCityId());
            erpFunContractDealExample.createCriteria().andDealIdEqualTo(erpFunDeal.getDealId());
            erpFunContractDealExample.setOrderByClause("CONTRACT_TYPE ASC");
            List<ErpFunContractDeal> erpFunContractDeals = erpFunContractDealMapper.selectByExample(erpFunContractDealExample);
            String contractIds = "";
            for (ErpFunContractDeal erpFunContractDeal : erpFunContractDeals) {
                contractIds += erpFunContractDeal.getContractId() + ",";
            }
            if (contractIds.endsWith(",")) {
                contractIds = StringUtils.stripEnd(contractIds, ",");
            }
            erpFundealDto.setContractIds(contractIds);
            // dyh 处理主办人，签约人和房客源经纪人的archiveId IM要用
            Set<Integer> userIdSet = new HashSet<>();
            userIdSet.add(erpFundealDto.getHouseUserUid());
            userIdSet.add(erpFundealDto.getCustUserUid());
            userIdSet.add(erpFundealDto.getSignUserId());
            userIdSet.add(erpFundealDto.getDealUserId());
            userIdSet.add(erpFundealDto.getSignManagerId());

            BeanUtils.copyProperties(erpFundealDto, erpFunDealDtoVo);
//            添加到copy后面，erpFundealDto里面有signType,这样不会变空。
            // 设置合同签约类型 如果fun_deal signType 为空，从category表取
            Byte signType = erpFundealDto.getSignType();
            if (signType == null) {
                Integer categoryId = erpFundealDto.getCategoryId();
                if (categoryId != null) {
                    ErpFunContractCategory condition = new ErpFunContractCategory();
                    condition.setCategoryId(categoryId);
                    condition.setShardCityId(cityId);
                    ErpFunContractCategory erpFunContractCategory = erpFunContractCategoryMapper.selectByPrimaryKey(condition);
                    erpFunDealDtoVo.setSignType(erpFunContractCategory.getSignType());
                } else {
                    erpFunDealDtoVo.setSignType((byte) 0);
                }
            }
            // 设置上上签合同完成状态, 如果是线上才有上上签状态
            if (null != erpFunDealDtoVo.getSignType() && 1 == erpFunDealDtoVo.getSignType()) {// 线上
                ErpSsqContractExample ssqCondition = new ErpSsqContractExample();
                ssqCondition.setShardCityId(cityId);
                ssqCondition.createCriteria().andDealIdEqualTo(param.getDealId()).andIsDelEqualTo((byte) 0);
                List<ErpSsqContract> erpSsqContracts = erpSsqContractMapper.selectByExample(ssqCondition);
                if (CollectionUtils.isNotEmpty(erpSsqContracts)) {
                    erpFunDealDtoVo.setContractStatus(erpSsqContracts.get(0).getContractStatus());
                } else {
                    erpFunDealDtoVo.setContractStatus(0);
                }
            }
            if (erpFundealDto.getCommercialLoanDate() != null) {
                erpFunDealDtoVo.setCommercialLoanDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss").format(erpFundealDto.getCommercialLoanDate()));
            }
            if (erpFundealDto.getCommercialLenderDate() != null) {
                erpFunDealDtoVo.setCommercialLenderDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss").format(erpFundealDto.getCommercialLenderDate()));
            }

            if (getOperator().isMobileApi()) {
                String dealUserName = erpFunDealDtoVo.getDealUserName();
                if (StringUtils.isNotBlank(dealUserName)) {
                    if (dealUserName.contains("(")) {
                        erpFunDealDtoVo.setDealUserName(dealUserName.substring(0, dealUserName.indexOf("(")));
                    }
                    if (dealUserName.contains("（")) {
                        erpFunDealDtoVo.setDealUserName(dealUserName.substring(0, dealUserName.indexOf("（")));
                    }
                }
            }

            if (userIdSet.isEmpty()) {
                return ErpResponseJson.ok(erpFunDealDtoVo);
            }
            List<ErpFunUsers> usersList = erpFunUsersMapper.getUserListByUserIds(operator.getCityId(), userIdSet);
            Map<Integer, Integer> archiveMap = usersList.stream().collect(Collectors.toMap(user -> user.getUserId(), user -> user.getArchiveId()));
            erpFunDealDtoVo.setHouseArchiveId(archiveMap.get(erpFundealDto.getHouseUserUid()));
            erpFunDealDtoVo.setCustArchiveId(archiveMap.get(erpFundealDto.getCustUserUid()));
            erpFunDealDtoVo.setSignArchiveId(archiveMap.get(erpFundealDto.getSignUserId()));
            erpFunDealDtoVo.setDealArchiveId(archiveMap.get(erpFundealDto.getDealUserId()));
            erpFunDealDtoVo.setSignManagerArchiveId(archiveMap.get(erpFundealDto.getSignManagerId()));

            Map<Integer, Integer> orgMap = usersList.stream().collect(Collectors.toMap(user -> user.getUserId(), user -> user.getOrganizationId()));
            erpFunDealDtoVo.setDealUserOrgId(orgMap.get(erpFundealDto.getDealUserId()));
            // 查询厅数据
            Byte dealType = erpFundealDto.getDealType();
            Integer dealHouseId = erpFundealDto.getDealHouseId();
            if (0 == erpFundealDto.getDealSellStyle() && null != dealHouseId) {
                Byte houseRoom = null;
                if (Const.DIC_CASE_TYPE_SALE_DEAL_BYTE.equals(dealType)) {
                    ErpFunSale houseBaseInfo = erpFunSaleMapper.getHouseBaseInfo(cityId, dealHouseId);
                    if(houseBaseInfo != null) {
                        houseRoom = houseBaseInfo.getSaleRoom();
                    }
                } else {
                    ErpFunLease houseBaseInfo = erpFunLeaseMapper.getHouseBaseInfo(cityId, dealHouseId);
                    if(houseBaseInfo != null) {
                        houseRoom = houseBaseInfo.getLeaseRoom();
                    }
                }
                erpFunDealDtoVo.setHouseRoom(houseRoom);
            }

        }

        if (erpFunDealDtoVo.getProfitPerson()) {
            // 隐藏电话  姓名
            erpFunDealDtoVo.setSellOwnerPhone("*****");
            erpFunDealDtoVo.setSellOwnerName("***");
            erpFunDealDtoVo.setBuyCustomerPhone("*****");
            erpFunDealDtoVo.setBuyOwnerName("***");
            erpFunDealDtoVo.setBuyIdCard("*****");
            erpFunDealDtoVo.setSellIdCard("*****");
        }

        if (null != erpFundealDto && erpFundealDto.getDealArchiveId() != null) {
            AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByPrimaryKey(erpFundealDto.getDealArchiveId());
            if (StringUtil.isNotEmpty(adminFunArchive.getUserPhoto())) {
                erpFunDealDtoVo.setDealUserPhoto(AppConfig.getUserPhotoPicDomainPath(adminFunArchive.getUserPhoto()));
            }
        }

        ErpProcessFinancExample erpProcessFinancExample = new ErpProcessFinancExample();
        erpProcessFinancExample.setShardCityId(operator.getCityId());
        erpProcessFinancExample.createCriteria().andCompIdEqualTo(operator.getCompId()).andDealIdEqualTo(erpFunDeal.getDealId());
        List<ErpProcessFinanc> erpProcessFinancs = erpProcessFinancMapper.selectByExample(erpProcessFinancExample);

        // 应付（付款方为中介）
        BigDecimal needPay = erpProcessFinancs.stream().filter(val -> (val.getPfActual().intValue() == 0 && "3".equals(val.getPfPayer()))).map(ErpProcessFinanc::getPayAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
        // 实付（付款方为中介）
        BigDecimal realPay = erpProcessFinancs.stream().filter(val -> (val.getPfActual().intValue() == 1 && "3".equals(val.getPfPayer()))).map(ErpProcessFinanc::getPayAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
        // 应代收（收款和付款都不是中介） 代替
        BigDecimal insteadNeedIncome = erpProcessFinancs.stream().filter(val -> (val.getPfActual().intValue() == 0 && !"3".equals(val.getPfPayer()) && !"3".equals(val.getPfGeter()))).map(ErpProcessFinanc::getPayAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
        // 实代收（收款和付款都不是中介）
        BigDecimal insteadRealIncome = erpProcessFinancs.stream().filter(val -> (val.getPfActual().intValue() == 1 && !"3".equals(val.getPfPayer()) && !"3".equals(val.getPfGeter()))).map(ErpProcessFinanc::getPayAmount).reduce(BigDecimal.ZERO, BigDecimal::add);

        ErpSsqContractExample erpSsqContractExample = new ErpSsqContractExample();
        erpSsqContractExample.setShardCityId(cityId);
        erpSsqContractExample.createCriteria().andDealIdEqualTo(param.getDealId()).andIsDelEqualTo((byte) 1).andContractStatusEqualTo(1);
        List<ErpSsqContract> contracts = erpSsqContractMapper.selectByExample(erpSsqContractExample);

        //获取对应未作废的上上签,设置对应的签约状态
        erpSsqContractExample.createCriteria().andDealIdEqualTo(param.getDealId()).andIsDelEqualTo((byte) 0);
        List<ErpSsqContract> erpSsqContractForJudge = erpSsqContractMapper.selectByExample(erpSsqContractExample);
        if (erpSsqContractForJudge != null && (!erpSsqContractForJudge.isEmpty())) {
            erpFunDealDtoVo.setContractStatus(erpSsqContractForJudge.get(0).getContractStatus());
        }
        List<String> invalidContracts = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(contracts)) {
            for (ErpSsqContract contract : contracts) {
                String ssqContractId = contract.getSsqContractId();
                String content = "本合同签订之日起，之前签署的上上签合同编号为" + ssqContractId + "的合同自动作废。";
                invalidContracts.add(content);
            }
        }
        List<ErpFunDealDtoVo> erpFunDealDtoVoforMakeInfo = new ArrayList<>();
        erpFunDealDtoVoforMakeInfo.add(erpFunDealDtoVo);
        this.changePhoneInfoByPerson(operator, erpFunDealDtoVoforMakeInfo);
        // 处理应收实收，代付，等数据
        erpFunDealDtoVo.setNeedPay(needPay);
        erpFunDealDtoVo.setRealPay(realPay);
        erpFunDealDtoVo.setInsteadNeedIncome(insteadNeedIncome);
        erpFunDealDtoVo.setInsteadRealIncome(insteadRealIncome);
        erpFunDealDtoVo.setInvalidContracts(invalidContracts);
        if (AppConfig.isOnline() && !"BW70".equals(operator.getCompNo())) {
            erpFunDealDtoVo.setShowOnlineSign(Byte.valueOf("0"));
            erpFunDealDtoVo.setContractUrl("");
        } else {
            erpFunDealDtoVo.setShowOnlineSign(Byte.valueOf("1"));
        }
        //美联增加楼盘推广名
        if(operator.isMeiLianApi() && erpFundealDto.getDealHouseId() != null){
            if(Byte.valueOf("101").equals(erpFundealDto.getDealType())){
                ErpFunSaleExample funSaleExample = new ErpFunSaleExample();
                funSaleExample.setShardCityId(cityId);
                funSaleExample.createCriteria().andCompIdEqualTo(compId).andSaleIdEqualTo(erpFundealDto.getDealHouseId());
                List<ErpFunSale> funSaleForBuildId = erpFunSaleMapper.selectByExample(funSaleExample);
                if (funSaleForBuildId.size() > 0) {
                    ErpBuildingInfoDto buildInfoById = erpBuildingInfoMapper.getBuildInfoById(cityId, funSaleForBuildId.get(0).getBuildId().toString());
                    if(buildInfoById != null && StringUtil.isNotBlank(buildInfoById.getPromotionName())){
                        erpFunDealDtoVo.setPromotionName(buildInfoById.getPromotionName());
                    }
                }
            }else{
                ErpFunLeaseExample funLeaseExample = new ErpFunLeaseExample();
                funLeaseExample.setShardCityId(cityId);
                funLeaseExample.createCriteria().andCompIdEqualTo(compId).andLeaseIdEqualTo(erpFundealDto.getDealHouseId());
                List<ErpFunLease> funLeaseForBuildId = erpFunLeaseMapper.selectByExample(funLeaseExample);
                if (funLeaseForBuildId.size() > 0) {
                    ErpBuildingInfoDto buildInfoById = erpBuildingInfoMapper.getBuildInfoById(cityId, funLeaseForBuildId.get(0).getBuildId().toString());
                    if(buildInfoById != null && StringUtil.isNotBlank(buildInfoById.getPromotionName())){
                        erpFunDealDtoVo.setPromotionName(buildInfoById.getPromotionName());
                    }
                }
            }
        }
        CanSeeFunDealPhotoParam canSeeFunDealPhotoParam = new CanSeeFunDealPhotoParam();
        canSeeFunDealPhotoParam.setDealId(param.getDealId());
        GeneralParam generalParam = new GeneralParam(operator);
        Integer canSee = 0;
        if (operator.isSwitchCompLogin()) {
            canSee = 1;
        } else {
            canSee = erpFunDealService.canSeeFunDealPhoto(canSeeFunDealPhotoParam, generalParam);
        }
        erpFunDealDtoVo.setCanSee(canSee);
        return ErpResponseJson.ok(erpFunDealDtoVo);
    }

    /**
     * 对个手机信息根据系统参数，合同状态，以及是否房客源所属经纪人进行具体控制
     * 作者：黎桂良
     * 时间：2019/10/17
     **/
    private void changePhoneInfoByPerson(Operator operator, List<ErpFunDealDtoVo> list) {
//        String showPhonenum = erpSysParaMapper.getParamValue(operator.getCityId(), operator.getCompId(), "DEAL_WILL_SHOW_PHONENUM");
        String showPhonenum = erpSysParaService.getMLSysParamValByUserDefEmpty(operator.getCityId(), operator.getCompId(),operator.getUserId(), "DEAL_WILL_SHOW_PHONENUM");
        //查询对应的上上签合同
        List<Integer> dealIdList = list.stream().collect(Collectors.mapping(ErpFunDealDtoVo::getDealId, Collectors.toList()));
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
                                    obj.setSellOwnerPhone("*****");
                                    obj.setBuyCustomerPhone("*****");
                                    obj.setSellOwnerPhoneBak("*****");
                                    obj.setBuyCustomerPhoneBak("*****");
                                }
                            } else {//此合同未开通在线签约
                                if (Byte.valueOf("0").equals(obj.getDealAuditStatus()) || Byte.valueOf("5").equals(obj.getDealAuditStatus())
                                        || (operator.getUserId().equals(obj.getHouseUserUid()) && !obj.isHasAuth())) {
                                    obj.setSellOwnerPhone("*****");
                                    obj.setBuyCustomerPhone("*****");
                                    obj.setSellOwnerPhoneBak("*****");
                                    obj.setBuyCustomerPhoneBak("*****");
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
    public boolean getCompWeixinStatus(Operator operator) throws Exception {

        if (operator.isPersonalVersion()) {//精英版没有该信息
            return false;
        }
        AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(operator.getCompNo());
        Integer weixinOpenStatus = adminFunComp.getCompWeixinStatus();
        if (5 == weixinOpenStatus) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isShowPhone(Byte dealAuditStatus, List<ErpUserOpers> userOpers) {
        if (userOpers.size() > 0) {
            return true;
        }
        if (Constants_DIC.DIC_DEAL_FIRSTCOMPLETE_OK.equals(dealAuditStatus.toString())) {
            return true;
        } else if (Constants_DIC.DIC_DEAL_REPEATCOMPLETE_OK.equals(dealAuditStatus.toString())) {
            return true;
        }
        return false;
    }

    /**
     * 判断业主电话是否发生改变
     *
     * @return
     * @throws Exception
     */
    private Integer isHouseInfoUpdate(Integer cityId, ErpFunDealDto erpFunDealDto) throws Exception {
        Integer houseId = erpFunDealDto.getDealHouseId();
        if (null != houseId) {
            if (Constants_DIC.DIC_CASE_TYPE_SALE_DEAL.equals(erpFunDealDto.getDealType().toString())) {
                ErpFunSale funSalePO = erpFunSaleMapper.getHouseBaseInfo(cityId, houseId);
                //加一个空判断，老的数据的话，可能是转租了，以前转租之后，这个数据就查不了
                if (funSalePO == null) {
                    return 0;
                }
                if (StringUtils.isNotBlank(funSalePO.getCellPhone()) && !"&&&".equals(funSalePO.getCellPhone())) {
                    String phone = SyncUtil.decodePhoneForHouseDetailOfFirst(funSalePO.getCellPhone(), false);
                    if (StringUtils.isNotBlank(phone)) {
                        String sellOwnerComparePhone = null;
                        String sellOwnerPhone = erpFunDealDto.getSellOwnerPhone();
                        if (StringUtils.isNotBlank(sellOwnerPhone)) {
                            String[] sellOwnerPhoneArr = sellOwnerPhone.split(":");
                            if(sellOwnerPhoneArr.length > 1) {
                                if (sellOwnerPhoneArr.length == 1) {
                                    sellOwnerComparePhone = sellOwnerPhoneArr[0].trim();
                                } else if (sellOwnerPhoneArr.length == 2) {
                                    sellOwnerComparePhone = sellOwnerPhoneArr[1].trim();
                                }
                            }
                        }
                        String[] split = phone.split(":");
                        if (split.length > 1 && !phone.split(":")[1].trim().equals(sellOwnerComparePhone)) {
                            return 1;
                        }
                    }
                }
            } else {
                ErpFunLease erpFunLease = erpFunLeaseMapper.getHouseBaseInfo(cityId, houseId);
                if (erpFunLease == null) {
                    return 0;
                }
                if (StringUtils.isNotBlank(erpFunLease.getCellPhone())
                        && !"&&&".equals(erpFunLease.getCellPhone())) {
                    String phone = SyncUtil.decodePhoneForHouseDetailOfFirst(erpFunLease.getCellPhone(), false);
                    if (StringUtils.isNotBlank(phone)) {
                        String sellOwnerComparePhone = null;
                        String sellOwnerPhone = erpFunDealDto.getSellOwnerPhone();
                        if (StringUtils.isNotBlank(sellOwnerPhone)) {
                            String[] sellOwnerPhoneArr = sellOwnerPhone.split(":");
                            if (sellOwnerPhoneArr.length == 1) {
                                sellOwnerComparePhone = sellOwnerPhoneArr[0].trim();
                            } else if (sellOwnerPhoneArr.length == 2) {
                                sellOwnerComparePhone = sellOwnerPhoneArr[1].trim();
                            }
                        }
                        if (!phone.split(":")[1].trim().equals(sellOwnerComparePhone)) {
                            return 1;
                        }
                    }
                }
            }
        }
        return 0;
    }

    private Integer isCustInfoUpdate(Integer cityId, Integer compId, ErpFunDealDto erpFunDealDto) throws Exception {
        Integer custId = erpFunDealDto.getDealCustomerId();
        if (null != custId) {
            // 出售合同=101
            if (Constants_DIC.DIC_CASE_TYPE_SALE_DEAL.equals(erpFunDealDto.getDealType().toString())) {
                ErpFunBuyCustomer fbcp = new ErpFunBuyCustomer();
                fbcp.setBuyCustId(custId);
                fbcp.setShardCityId(cityId);
                fbcp = erpFunBuyCustomerMapper.selectByPrimaryKey(fbcp);

                if (StringUtils.isNotBlank(fbcp.getCellPhone()) && !"&&&".equals(fbcp.getCellPhone())) {
                    String phone = SyncUtil.decodePhoneForHouseDetailOfFirst(fbcp.getCellPhone(), false);
                    if (StringUtils.isNotBlank(phone)) {
                        String buyCustomerComparePhone = null;
                        String buyCustomerPhone = erpFunDealDto.getBuyCustomerPhone();
                        if (StringUtils.isNotBlank(buyCustomerPhone)) {
                            String[] sellOwnerPhoneArr = buyCustomerPhone.split(":");
                            if (sellOwnerPhoneArr.length == 1) {
                                buyCustomerComparePhone = sellOwnerPhoneArr[0].trim();
                            } else if (sellOwnerPhoneArr.length == 2) {
                                buyCustomerComparePhone = sellOwnerPhoneArr[1].trim();
                            }
                        }
                        if (!phone.split(":")[1].trim().equals(buyCustomerComparePhone)) {
                            return 1;
                        }
                    }
                }
            } else {
                ErpFunRentCustomerKey erpFunRentCustomerKey = new ErpFunRentCustomerKey();
                erpFunRentCustomerKey.setShardCityId(cityId);
                erpFunRentCustomerKey.setRentCustId(custId);
                erpFunRentCustomerKey.setCompId(compId);
                ErpFunRentCustomer frcp = erpFunRentCustomerMapper.selectByPrimaryKey(erpFunRentCustomerKey);
                if (StringUtils.isNotBlank(frcp.getCellPhone()) && !"&&&".equals(frcp.getCellPhone())) {
                    String phone = SyncUtil.decodePhoneForHouseDetailOfFirst(frcp.getCellPhone(), false);
                    if (StringUtils.isNotBlank(phone)) {
                        String buyCustomerComparePhone = null;
                        String buyCustomerPhone = erpFunDealDto.getBuyCustomerPhone();
                        if (StringUtils.isNotBlank(buyCustomerPhone)) {
                            String[] sellOwnerPhoneArr = buyCustomerPhone.split(":");
                            if (sellOwnerPhoneArr.length == 1) {
                                buyCustomerComparePhone = sellOwnerPhoneArr[0].trim();
                            } else if (sellOwnerPhoneArr.length == 2) {
                                buyCustomerComparePhone = sellOwnerPhoneArr[1].trim();
                            }
                        }
                        if (!phone.split(":")[1].trim().equals(buyCustomerComparePhone)) {
                            return 1;
                        }
                    }
                }
            }
        }
        return 0;
    }


    /**
     * 设置是否仅为分层人，是否相关人，是否有此合同的查看权限
     **/
    private void checkAuthSeeDeal(Operator operator, Integer dealId, ErpFunDealDtoVo erpFunDealDtoVo) {
        ErpFunDealExample erpFunDealExample = new ErpFunDealExample();
        erpFunDealExample.setShardCityId(operator.getCityId());
        erpFunDealExample.createCriteria().andDealIdEqualTo(dealId);
        List<ErpFunDeal> erpFunDeals = erpFunDealMapper.selectByExample(erpFunDealExample);
        ErpFunDeal erpFunDeal = erpFunDeals.size() > 0 ? erpFunDeals.get(0) : null;
        if (erpFunDeal != null && null != erpFunDeal.getIsbyhand() && 1 == erpFunDeal.getIsbyhand().intValue()) {
            throw new BusinessException("非权证合同不能查看!");
        }

        erpFunDealDtoVo.setRelated(false);
        erpFunDealDtoVo.setProfitPerson(true);
        // 先查询是否是合同相关人
        ErpDealUserRelativeExample erpDealUserRelativeExample = new ErpDealUserRelativeExample();
        erpDealUserRelativeExample.setShardCityId(operator.getCityId());
        erpDealUserRelativeExample.createCriteria().andDealIdEqualTo(erpFunDeal.getDealId()).andCompIdEqualTo(operator.getCompId());

        List<ErpDealUserRelative> erpDealUserRelatives = erpDealUserRelativeMapper.selectByExample(erpDealUserRelativeExample);
        boolean isRelated = (int) erpDealUserRelatives.stream().filter(v -> operator.getUserId().equals(v.getUserId())).count() > 0;
        //除自己身为房源相关人之外的其他合同相关人数量
        int relOutOfSelfHouUserCon = (int) erpDealUserRelatives.stream().filter(v -> !(Byte.valueOf("6").equals(v.getRelateType()) && operator.getUserId().equals(v.getUserId()))).count();

        // 查询个人权限,有权限设置为false，不隐藏
        List<String> operIds = Arrays.asList(new String[]{"VIEW_GROUP_DEAL", "VIEW_DEPT_DEAL", "VIEW_COMP_DEAL", "VIEW_AREA_DEAL", "VIEW_REG_DEAL"});
        ErpUserOpersExample erpUserOpersExample = new ErpUserOpersExample();
        erpUserOpersExample.setShardCityId(operator.getCityId());
        erpUserOpersExample.createCriteria().andOperIdIn(operIds).andUserIdEqualTo(operator.getUserId());
        List<ErpUserOpers> erpUserOpers = erpUserOpersMapper.selectByExample(erpUserOpersExample);
        Boolean profitPerson = false;
        if (erpUserOpers.size() > 0) {
            Set<String> collect = erpUserOpers.stream().collect(Collectors.mapping(ErpUserOpers::getOperId, Collectors.toSet()));
            // 合同相关人
            if (erpDealUserRelatives.size() == 0) {
                // 判断是否是分成人
                profitPerson = this.isProfitPerson(operator.getCityId(), dealId, operator.getArchiveId());
                if (profitPerson) {
                    erpFunDealDtoVo.setProfitPerson(profitPerson);
                } else {
                    throw new BusinessException("没有权限,请联系管理员开通!");
                }
            }
            if (collect.contains("VIEW_COMP_DEAL")) {
                erpFunDealDtoVo.setProfitPerson(false);
            } else if (collect.contains("VIEW_AREA_DEAL")) {
                Set<Integer> areaIdSet = erpDealUserRelatives.stream().collect(Collectors.mapping(val -> val.getAreaId(), Collectors.toSet()));
                relOutOfSelfHouUserCon = (int) erpDealUserRelatives.stream().filter(v -> !(Byte.valueOf("6").equals(v.getRelateType()) && operator.getUserId().equals(v.getUserId())) && operator.getAreaId().equals(v.getAreaId())).count();
                if (areaIdSet.size() == 0 || !areaIdSet.contains(operator.getAreaId())) {
                    // 判断是否是分成人
                    profitPerson = this.isProfitPerson(operator.getCityId(), dealId, operator.getArchiveId());
                    if (profitPerson) {
                        erpFunDealDtoVo.setProfitPerson(profitPerson);
                    } else {
                        throw new BusinessException("没有权限,请联系管理员开通!");
                    }
                } else {
                    erpFunDealDtoVo.setProfitPerson(false);
                }
            } else if (collect.contains("VIEW_REG_DEAL")) {
                Set<Integer> regIdSet = erpDealUserRelatives.stream().collect(Collectors.mapping(val -> val.getRegId(), Collectors.toSet()));
                relOutOfSelfHouUserCon = (int) erpDealUserRelatives.stream().filter(v -> !(Byte.valueOf("6").equals(v.getRelateType()) && operator.getUserId().equals(v.getUserId())) && operator.getRegId().equals(v.getRegId())).count();
                if (regIdSet.size() == 0 || !regIdSet.contains(operator.getRegId())) {
                    // 判断是否是分成人
                    profitPerson = this.isProfitPerson(operator.getCityId(), dealId, operator.getArchiveId());
                    if (profitPerson) {
                        erpFunDealDtoVo.setProfitPerson(profitPerson);
                    } else {
                        throw new BusinessException("没有权限,请联系管理员开通!");
                    }
                } else {
                    erpFunDealDtoVo.setProfitPerson(false);
                }
            } else if (collect.contains("VIEW_DEPT_DEAL")) {
                Set<Integer> deptIdSet = erpDealUserRelatives.stream().collect(Collectors.mapping(val -> val.getDeptId(), Collectors.toSet()));
                relOutOfSelfHouUserCon = (int) erpDealUserRelatives.stream().filter(v -> !(Byte.valueOf("6").equals(v.getRelateType()) && operator.getUserId().equals(v.getUserId())) && operator.getDeptId().equals(v.getDeptId())).count();
                if (deptIdSet.size() == 0 || !deptIdSet.contains(operator.getDeptId())) {
                    // 判断是否是分成人
                    profitPerson = this.isProfitPerson(operator.getCityId(), dealId, operator.getArchiveId());
                    if (profitPerson) {
                        erpFunDealDtoVo.setProfitPerson(profitPerson);
                    } else {
                        throw new BusinessException("没有权限,请联系管理员开通!");
                    }
                } else {
                    erpFunDealDtoVo.setProfitPerson(false);
                }
            } else if (collect.contains("VIEW_GROUP_DEAL")) {
                Set<Integer> grIdSet = erpDealUserRelatives.stream().collect(Collectors.mapping(val -> val.getGrId(), Collectors.toSet()));
                relOutOfSelfHouUserCon = (int) erpDealUserRelatives.stream().filter(v -> !(Byte.valueOf("6").equals(v.getRelateType()) && operator.getUserId().equals(v.getUserId())) && operator.getGrId().equals(v.getGrId())).count();
                if (grIdSet.size() == 0 || !grIdSet.contains(operator.getGrId())) {
                    // 判断是否是分成人
                    profitPerson = this.isProfitPerson(operator.getCityId(), dealId, operator.getArchiveId());
                    if (profitPerson) {
                        erpFunDealDtoVo.setProfitPerson(profitPerson);
                    } else {
                        throw new BusinessException("没有权限,请联系管理员开通!");
                    }
                } else {
                    erpFunDealDtoVo.setProfitPerson(false);
                }
            }
        } else {
            // 判断是否是分成人
            profitPerson = this.isProfitPerson(operator.getCityId(), dealId, operator.getArchiveId());
            relOutOfSelfHouUserCon = (int) erpDealUserRelatives.stream().filter(v -> !Byte.valueOf("6").equals(v.getRelateType()) && operator.getUserId().equals(v.getUserId())).count();
            if (profitPerson) {
                erpFunDealDtoVo.setProfitPerson(profitPerson);
            } else if(!isRelated){
                throw new BusinessException("没有权限,请联系管理员开通!");
            }
        }

        if (isRelated) {
            erpFunDealDtoVo.setRelated(true);
            erpFunDealDtoVo.setProfitPerson(false);
        }
        erpFunDealDtoVo.setHasAuth(relOutOfSelfHouUserCon > 0 || profitPerson);
    }
    
    /**
     * @Author XIONG CAI
     * @Description //TODO 新组织架构合同权限查看判断
     * @Date 2019/12/18 23:25
     * @Param [operator, dealId, erpFunDealDtoVo]
     * @return void
    **/
    private void checkAuthSeeDealNewOrg(Operator operator, Integer dealId, ErpFunDealDtoVo erpFunDealDtoVo) {
        ErpFunDealExample erpFunDealExample = new ErpFunDealExample();
        erpFunDealExample.setShardCityId(operator.getCityId());
        erpFunDealExample.createCriteria().andDealIdEqualTo(dealId);
        List<ErpFunDeal> erpFunDeals = erpFunDealMapper.selectByExample(erpFunDealExample);
        ErpFunDeal erpFunDeal = erpFunDeals.size() > 0 ? erpFunDeals.get(0) : null;
        if (erpFunDeal != null && null != erpFunDeal.getIsbyhand() && 1 == erpFunDeal.getIsbyhand().intValue()) {
            throw new BusinessException("非权证合同不能查看!");
        }

        erpFunDealDtoVo.setRelated(false);
        erpFunDealDtoVo.setProfitPerson(true);
        // 先查询是否是合同相关人
        ErpDealUserRelativeExample erpDealUserRelativeExample = new ErpDealUserRelativeExample();
        erpDealUserRelativeExample.setShardCityId(operator.getCityId());
        erpDealUserRelativeExample.createCriteria().andDealIdEqualTo(erpFunDeal.getDealId()).andCompIdEqualTo(operator.getCompId());

        List<ErpDealUserRelative> erpDealUserRelatives = erpDealUserRelativeMapper.selectByExample(erpDealUserRelativeExample);
        boolean isRelated = (int) erpDealUserRelatives.stream().filter(v -> operator.getUserId().equals(v.getUserId())).count() > 0;
        //除自己身为房源相关人之外的其他合同相关人数量
        int relOutOfSelfHouUserCon = (int) erpDealUserRelatives.stream().filter(v -> !(Byte.valueOf("6").equals(v.getRelateType()) && operator.getUserId().equals(v.getUserId()))).count();
        if (operator.isSwitchCompLogin()) {
        	ErpUserOpers userOpers = erpUserOpersMapper.getUserOperByUserIdOperIdSwitchLogin(operator.getCityId(), operator.getUserId(), "VIEW_ORGANIZATION_DEAL");
        	if (userOpers!=null) {
        		erpFunDealDtoVo.setHasAuth(true);
        		erpFunDealDtoVo.setRelated(true);
                erpFunDealDtoVo.setProfitPerson(false);
        	} else {
        		erpFunDealDtoVo.setHasAuth(false);
        	}
        	return;
        }
        // 查询个人权限,有权限设置为false，不隐藏
        List<String> operIds = Arrays.asList(new String[]{"VIEW_ORGANIZATION_DEAL"});
        ErpUserOpersExample erpUserOpersExample = new ErpUserOpersExample();
        erpUserOpersExample.setShardCityId(operator.getCityId());
        erpUserOpersExample.createCriteria().andOperIdIn(operIds).andUserIdEqualTo(operator.getUserId());
        List<ErpUserOpers> erpUserOpers = erpUserOpersMapper.selectByExample(erpUserOpersExample);
        Boolean profitPerson = false;
        if (erpUserOpers.size() > 0) {
            Set<String> collect = erpUserOpers.stream().collect(Collectors.mapping(ErpUserOpers::getOperId, Collectors.toSet()));
            // 合同相关人
            if (erpDealUserRelatives.size() == 0) {
                // 判断是否是分成人
                profitPerson = this.isProfitPerson(operator.getCityId(), dealId, operator.getArchiveId());
                if (profitPerson) {
                    erpFunDealDtoVo.setProfitPerson(profitPerson);
                } else {
                    throw new BusinessException("没有权限,请联系管理员开通!");
                }
            }
            if(collect.contains("VIEW_ORGANIZATION_DEAL")){
                ErpUserOpers userOpers = erpUserOpersMapper.getUserOperByUSerIdOperId(operator.getCityId(), operator.getUserId(), "VIEW_ORGANIZATION_DEAL");
                if(null == userOpers.getOrganizationDefinitionId()){
                    throw new BusinessException("没有权限,请联系管理员开通!");
                } else if(0 == userOpers.getOrganizationDefinitionId()){
                    erpFunDealDtoVo.setProfitPerson(false);
                } else if(-2 == userOpers.getOrganizationDefinitionId()){
                    // 判断是否是分成人
                    profitPerson = this.isProfitPerson(operator.getCityId(), dealId, operator.getArchiveId());
                    relOutOfSelfHouUserCon = (int) erpDealUserRelatives.stream().filter(v -> !Byte.valueOf("6").equals(v.getRelateType()) && operator.getUserId().equals(v.getUserId())).count();
                    if (profitPerson) {
                        erpFunDealDtoVo.setProfitPerson(profitPerson);
                    } else if(!isRelated){
                        throw new BusinessException("没有权限,请联系管理员开通!");
                    }
                } else{
                    //当前组织层级
                    ErpFunOrganizationDefinition definition = new ErpFunOrganizationDefinition();
                    definition.setShardCityId(operator.getCityId());
                    definition.setDefinitionId(userOpers.getOrganizationDefinitionId());
                    ErpFunOrganizationDefinition erpFunOrganizationDefinition = erpFunOrganizationDefinitionMapper.selectByPrimaryKey(definition);
                    Integer userOrgId = erpFunUsersMapper.selectByDynamicOrg(operator.getCityId(),operator.getUserId(),erpFunOrganizationDefinition.getMappingDbField());
                    // 判断是否是分成人
                    profitPerson = this.isProfitPerson(operator.getCityId(), dealId, operator.getArchiveId());
                    relOutOfSelfHouUserCon = (int) erpDealUserRelatives.stream().filter(v -> !(Byte.valueOf("6").equals(v.getRelateType()) && operator.getUserId().equals(v.getUserId())) && StringUtil.isNotEmpty(v.getOrganizationPath()) && v.getOrganizationPath().contains(":"+userOrgId+":")).count();
                    if (profitPerson) {
                        erpFunDealDtoVo.setProfitPerson(profitPerson);
                    } else if(!isRelated){
                        throw new BusinessException("没有权限,请联系管理员开通!");
                    }
                }
            }
        } else {
            // 判断是否是分成人
            profitPerson = this.isProfitPerson(operator.getCityId(), dealId, operator.getArchiveId());
            relOutOfSelfHouUserCon = (int) erpDealUserRelatives.stream().filter(v -> !Byte.valueOf("6").equals(v.getRelateType()) && operator.getUserId().equals(v.getUserId())).count();
            if (profitPerson) {
                erpFunDealDtoVo.setProfitPerson(profitPerson);
            } else if(!isRelated){
                throw new BusinessException("没有权限,请联系管理员开通!");
            }
        }

        if (isRelated) {
            erpFunDealDtoVo.setRelated(true);
            erpFunDealDtoVo.setProfitPerson(false);
        }
        erpFunDealDtoVo.setHasAuth(relOutOfSelfHouUserCon > 0 || profitPerson);
    }

    /**
     * 判断是否是业绩分成人
     **/
    private Boolean isProfitPerson(Integer cityId, Integer dealId, Integer archiveId) {
        Operator operator = getOperator();
        Integer compId = operator.getCompId();
        Integer userId = operator.getUserId();
        Integer deptId = operator.getDeptId();
        //查询出该合同的分层情况
        ErpFunProfitExample erpFunProfitExample = new ErpFunProfitExample();
        erpFunProfitExample.setShardCityId(cityId);
        erpFunProfitExample.createCriteria().andDealIdEqualTo(dealId);
        List<ErpFunProfit> profitCount = erpFunProfitMapper.selectByExample(erpFunProfitExample);
        //当前操作人是否在合同分层里面
        long count = profitCount.stream().filter(val -> archiveId.equals(val.getArchiveId())).count();

        if (count > 0) {//在分层里面设置为true
            return true;
        } else {
            List<ErpFunUserManageRange> mangerRangeList = erpFunUserManageRangeMapper.getUserManageRange(cityId, compId, userId);//员工管理范围
            if (mangerRangeList.size() > 0) {
                if (operator.newOrganizationType()) {//@TODO 新组织架构判断业绩分成人，正确性有待验证
                    for (ErpFunUserManageRange userManageRange : mangerRangeList) {
                        for (ErpFunProfit erpFunProfit : profitCount) {
                            if (erpFunProfit.getOrganizationPath() != null && userManageRange.getRangeId() != null) {
                                if (erpFunProfit.getOrganizationPath().contains(userManageRange.getRangeId()+"")) {
                                    return count > 0;
                                }
                            }
                        }
                    }
                    return false;
                }
                ErpFunUserManageRange erpFunUserManageRange = mangerRangeList.get(0);
                Integer rangeType = erpFunUserManageRange.getRangeType();//员工管理	范围类型：1=公司 2=大区 3=片区 4=门店 5=分组
                List<Integer> collect = mangerRangeList.stream().collect(Collectors.mapping(val -> val.getRangeId(), Collectors.toList()));//获取范围ID集合
                switch (rangeType) {
                    case 1:
                        return true;
                    case 2:
                        count = profitCount.stream().filter(val -> collect.contains(val.getAreaId())).count();
                        return count > 0;
                    case 3:
                        count = profitCount.stream().filter(val -> collect.contains(val.getRegId())).count();
                        return count > 0;
                    case 4:
                        count = profitCount.stream().filter(val -> collect.contains(val.getDeptId())).count();
                        return count > 0;
                    case 5:
                        count = profitCount.stream().filter(val -> collect.contains(val.getGrId())).count();
                        return count > 0;
                    default:
                        count = profitCount.stream().filter(val -> (deptId != null && deptId.equals(val.getDeptId()) && collect.contains(val.getGrId()))).count();
                        return count > 0;
                }
            } else {
                return false;
            }
        }
    }


    /**
     * 查询合同附件
     * lcb
     *
     * @Param
     **/
    @ApiOperation("查询合同附件")
    @RequestMapping("/getFunDealPhotoList")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunDealPhotoDto.class, message = "成功")
    })
    public ResponseJson getFunDealPhotoList(@RequestBody ErpFunDealParam erpFunDealParam) {
        List<ErpFunDealPhotoDto> resList = this.getFunDealPhotos(erpFunDealParam);
        return ErpResponseJson.ok(resList);
    }

    /**
     * 查询查询合同附件类型
     *
     * @param erpFunDealParam
     * @return Modified XXX XIONG CAI 2019年9月23日
     * @author XIONG CAI
     * @since 2019年9月23日 下午7:31:43
     */
    @ApiOperation("查询合同附件类型")
    @RequestMapping("/getFunDealPhotoTypeList")
    public ResponseJson getFunDealPhotoTypeList(@RequestBody ErpFunDealTypeParam erpFunDealParam) {
        String dicType = "HOUSE_FILE";
        if (erpFunDealParam.getPhotoType() == null) {
            dicType = "HOUSE_FILE";
        } else if ("0".equals(erpFunDealParam.getPhotoType().toString())) {
            dicType = "CUST_FILE";
        } else if ("1".equals(erpFunDealParam.getPhotoType().toString())) {
            dicType = "HOUSE_FILE";
        } else if ("2".equals(erpFunDealParam.getPhotoType().toString())) {
            dicType = "DEAL_OTHER_FILE";
        }
        ErpDicDefinitionsExample definitionsExample = new ErpDicDefinitionsExample();
        definitionsExample.createCriteria().andIsDelEqualTo((byte) 0).andDicTypeEqualTo(dicType);
        List<ErpDicDefinitions> houseFileTypes = erpDicDefinitionsMapper.selectByExample(definitionsExample);
        return ErpResponseJson.ok(houseFileTypes);
    }

    @ApiOperation("移动端查询合同附件")
    @RequestMapping("/getFunDealPhotoListInMobile")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunDealPhotoVo.class, message = "成功")
    })
    @ResponseBody
    public ResponseJson getFunDealPhotoListInMobile(@RequestBody ErpFunDealParam erpFunDealParam) {
        List<ErpFunDealPhotoDto> resList = getFunDealPhotos(erpFunDealParam);
        ErpFunDealPhotoVo dealPhotoVo = new ErpFunDealPhotoVo();
        this.checkAuthSeeAndDelPhotos(getOperator(), resList, erpFunDealParam);
        dealPhotoVo.setDealPhotos(resList);
        return ErpResponseJson.ok(dealPhotoVo);
    }

    private List<ErpFunDealPhotoDto> getFunDealPhotos(ErpFunDealParam erpFunDealParam) {
        Operator operator = getOperator();
        List<Integer> photoTypes = new ArrayList<>();
        String photoTypeStr = erpFunDealParam.getPhotoType();
        if (StringUtils.isNotBlank(photoTypeStr)) {
            String[] s = photoTypeStr.split(",");
            for (String photoType : s) {
                photoTypes.add(Integer.valueOf(photoType));
            }
        } else {
            photoTypes.addAll(Arrays.asList(0, 1, 2, 3, 4));
        }
        //业主类图片类型
        List<ErpFunDealPhotoDto> resList = erpFunDealPhotoMapper.getDealPhotoList(operator.getCityId(), erpFunDealParam.getDealId(), photoTypes);
        ErpDicDefinitionsExample definitionsExample = new ErpDicDefinitionsExample();
        definitionsExample.createCriteria().andIsDelEqualTo((byte) 0).andDicTypeEqualTo("HOUSE_FILE");
        definitionsExample.setShardCityId(operator.getCityId());
        //客户类图片类型
        List<ErpDicDefinitions> houseFileTypes = erpDicDefinitionsMapper.selectByExample(definitionsExample);
        ErpDicDefinitionsExample custExample = new ErpDicDefinitionsExample();
        custExample.createCriteria().andIsDelEqualTo((byte) 0).andDicTypeEqualTo("CUST_FILE");
        custExample.setShardCityId(operator.getCityId());
        List<ErpDicDefinitions> custFileTypes = erpDicDefinitionsMapper.selectByExample(custExample);
        //合同其他图片类型
        ErpDicDefinitionsExample dealOtherExample = new ErpDicDefinitionsExample();
        dealOtherExample.createCriteria().andIsDelEqualTo((byte) 0).andDicTypeEqualTo("DEAL_OTHER_FILE");
        dealOtherExample.setShardCityId(operator.getCityId());
        List<ErpDicDefinitions> dealOtherFileTypes = erpDicDefinitionsMapper.selectByExample(dealOtherExample);

        Map<String, ErpDicDefinitions> custFileTypeMap = new HashMap<String, ErpDicDefinitions>();
        Map<String, ErpDicDefinitions> houseFileTypeMap = new HashMap<String, ErpDicDefinitions>();
        Map<String, ErpDicDefinitions> dealOtherFileTypeMap = new HashMap<String, ErpDicDefinitions>();
        if (!houseFileTypes.isEmpty()) {
            houseFileTypeMap = houseFileTypes.stream().collect(Collectors.toMap(ErpDicDefinitions::getDicValue, ErpDicDefinitions -> ErpDicDefinitions));
        }
        if (!custFileTypes.isEmpty()) {
            custFileTypeMap = custFileTypes.stream().collect(Collectors.toMap(ErpDicDefinitions::getDicValue, ErpDicDefinitions -> ErpDicDefinitions));
        }
        if (!dealOtherFileTypes.isEmpty()) {
            dealOtherFileTypeMap = dealOtherFileTypes.stream().collect(Collectors.toMap(ErpDicDefinitions::getDicValue, ErpDicDefinitions -> ErpDicDefinitions));
        }
        for (ErpFunDealPhotoDto erpFunDealPhotoDto : resList) {
            String photoAddr = erpFunDealPhotoDto.getPhotoAddr();
            erpFunDealPhotoDto.setPhotoAddr(CommonUtil.getHousePhoto(photoAddr));
            if (null != erpFunDealPhotoDto.getFileSubType()) {
                if ("0".equals(erpFunDealPhotoDto.getPhotoType().toString())) {//0=客户资料表
                    if (custFileTypeMap.containsKey(erpFunDealPhotoDto.getFileSubType().toString())) {
                        erpFunDealPhotoDto.setFileSubTypeText(custFileTypeMap.get(erpFunDealPhotoDto.getFileSubType().toString()).getDicCnMsg());
                        erpFunDealPhotoDto.setFileTypeText(custFileTypeMap.get(erpFunDealPhotoDto.getFileSubType().toString()).getDicValue2());
                    } else {
                        erpFunDealPhotoDto.setFileSubTypeText("未命名");
                        erpFunDealPhotoDto.setFileTypeText("未命名");
                    }
                } else if ("1".equals(erpFunDealPhotoDto.getPhotoType().toString())) {//1=业主资料表
                    if (houseFileTypeMap.containsKey(erpFunDealPhotoDto.getFileSubType().toString())) {
                        erpFunDealPhotoDto.setFileSubTypeText(houseFileTypeMap.get(erpFunDealPhotoDto.getFileSubType().toString()).getDicCnMsg());
                        erpFunDealPhotoDto.setFileTypeText(houseFileTypeMap.get(erpFunDealPhotoDto.getFileSubType().toString()).getDicValue2());
                    } else {
                        erpFunDealPhotoDto.setFileSubTypeText("未命名");
                        erpFunDealPhotoDto.setFileTypeText("未命名");
                    }
                } else if ("2".equals(erpFunDealPhotoDto.getPhotoType().toString())) {//2=其他资料表
                    if (dealOtherFileTypeMap.containsKey(erpFunDealPhotoDto.getFileSubType().toString())) {
                        erpFunDealPhotoDto.setFileSubTypeText(dealOtherFileTypeMap.get(erpFunDealPhotoDto.getFileSubType().toString()).getDicCnMsg());
                        erpFunDealPhotoDto.setFileTypeText(dealOtherFileTypeMap.get(erpFunDealPhotoDto.getFileSubType().toString()).getDicValue2());
                    } else {
                        erpFunDealPhotoDto.setFileSubTypeText("未命名");
                        erpFunDealPhotoDto.setFileTypeText("未命名");
                    }
                }
            } else {
                erpFunDealPhotoDto.setFileSubTypeText("未命名");
                erpFunDealPhotoDto.setFileTypeText("未命名");
            }
        }
        //检查图片是否能查看
        this.checkAuthSeeAndDelPhotos(operator, resList, erpFunDealParam);
        return resList;
    }

    /**
     * @Title 判断合同附件图片能否查看, 删除
     * @Author 黎桂良
     * @Time 2019/11/08
     * @Desc
     **/
    private void checkAuthSeeAndDelPhotos(Operator operator, List<ErpFunDealPhotoDto> resList, ErpFunDealParam erpFunDealParam) {
        Integer cityId = operator.getCityId();
        Integer userId = operator.getUserId();
        Integer dealId = erpFunDealParam.getDealId();
        ErpFunDeal condition = new ErpFunDeal(cityId, dealId);
        ErpFunDeal erpFunDeal = erpFunDealMapper.selectByPrimaryKey(condition);
        if (erpFunDeal == null) {
            throw new BusinessException("合同不存在！");
        }

        // DEAL_INITIAL_REVIEW: 合同初审权, DEAL_REPEAT_REVIEW: 合同复审权, WARRANT_MANAGE: 权证流程管理权, DEAL_SETTLEMENT_DEAL: 合同结算权
        List<String> opers = Arrays.asList("DEAL_INITIAL_REVIEW", "DEAL_REPEAT_REVIEW", "WARRANT_MANAGE", "DEAL_SETTLEMENT_DEAL");

        List<String> opers2 = Arrays.asList("EDIT_DEAL");

        boolean canView = false;
        Map<String, Boolean> dealViewAuthMap = this.getDealViewAuthMap(cityId, userId);
        if (dealViewAuthMap != null && dealViewAuthMap.size() > 0 && erpFunDeal.getCustUserUid() != null) {
            ErpFunUsers custUser = erpFunUsersMapper.selectDataByUserId(cityId, operator.getCompId(), erpFunDeal.getCustUserUid());
            ErpFunUsers selfUser = erpFunUsersMapper.selectDataByUserId(cityId, operator.getCompId(), userId);

            String viewCompOper = "VIEW_COMP_DEAL";
            String viewAreaOper = "VIEW_AREA_DEAL";
            String viewRegOper = "VIEW_REG_DEAL";
            String viewDeptOper = "VIEW_DEPT_DEAL";
            String viewGrOper = "VIEW_GROUP_DEAL";
            // 自己拥有的合同查看权范围
            boolean viewCompDeal = dealViewAuthMap.get(viewCompOper);
            boolean viewAreaDeal = dealViewAuthMap.get(viewAreaOper);
            boolean viewRegDeal = dealViewAuthMap.get(viewRegOper);
            boolean viewDeptDeal = dealViewAuthMap.get(viewDeptOper);
            boolean viewGrDeal = dealViewAuthMap.get(viewGrOper);

            if (operator.newOrganizationType()) {//@TODO 我感觉这个地方不是这么改的，但是不知道怎么改
            	if (custUser!=null && selfUser!=null) {
            		boolean isSameOrg = custUser.getTissueLine().contains(selfUser.getOrganizationId()+"");
            		canView = viewCompDeal || (viewAreaDeal && isSameOrg) || (viewRegDeal && isSameOrg) || (viewDeptDeal && isSameOrg) || (viewGrDeal && isSameOrg);
            	}
            }else{
                boolean isSameArea = selfUser.getAreaId().equals(custUser.getAreaId());
                boolean isSameReg = selfUser.getRegId().equals(custUser.getRegId());
                boolean isSameDept = selfUser.getDeptId().equals(custUser.getDeptId());
                boolean isSameGr = !selfUser.getGrId().equals(0) && !custUser.getGrId().equals(0) && selfUser.getGrId().equals(custUser.getGrId());
                canView = viewCompDeal || (viewAreaDeal && isSameArea) || (viewRegDeal && isSameReg) || (viewDeptDeal && isSameDept) || (viewGrDeal && isSameGr);
            }
        }
        boolean haveRight = canView;
        ErpUserOpersExample erpFunOpersExample = new ErpUserOpersExample();
        erpFunOpersExample.setShardCityId(cityId);
        erpFunOpersExample.createCriteria().andUserIdEqualTo(userId).andOperIdIn(opers);
        int count = erpUserOpersMapper.countByExample(erpFunOpersExample);

        ErpUserOpersExample erpFunOpersExample2 = new ErpUserOpersExample();
        erpFunOpersExample2.setShardCityId(cityId);
        erpFunOpersExample2.createCriteria().andUserIdEqualTo(userId).andOperIdIn(opers2);
        int count2 = erpUserOpersMapper.countByExample(erpFunOpersExample2);
        resList.stream().forEach(obj -> {
            obj.setCanSee(0);
            obj.setCanDel(0);
            if (count > 0 || obj.getUploadUser().equals(userId) || haveRight) {
                obj.setCanSee(1);
            }
        });

        Byte signType = erpFunDeal.getSignType();
        Byte dealAuditStatus = erpFunDeal.getDealAuditStatus();
        // 线上和线下都没有签约,直接所有人都不能看
        if (signType == null) {
            Integer categoryId = erpFunDeal.getCategoryId();
            if (categoryId != null) {
                ErpFunContractCategory category = new ErpFunContractCategory();
                category.setCategoryId(categoryId);
                category.setShardCityId(cityId);
                ErpFunContractCategory erpFunContractCategory = erpFunContractCategoryMapper.selectByPrimaryKey(category);
                if (erpFunContractCategory != null) {
                    Byte type = erpFunContractCategory.getSignType();

                    if (type == null) {
                        signType = 0;
                    } else {
                        signType = type;
                    }
                } else {
                    signType = 0;
                }
            } else {
                signType = 0;
            }
        }

        // 线下签约 且在初审后
        if (signType == 0 && dealAuditStatus != null && dealAuditStatus != 0) {
            //如果为流程总负责人，执行人，签约人，签约人主管，客源方经纪人，在初审后可以查看
            if (userId.equals(erpFunDeal.getDealUserId()) || userId.equals(erpFunDeal.getExecutor()) || userId.equals(erpFunDeal.getSignUserId())
                    || userId.equals(erpFunDeal.getSignManagerId()) || userId.equals(erpFunDeal.getCustUserUid())) {
                resList.stream().forEach(obj -> {
                    obj.setCanSee(1);
                });
            }
        }

        if (signType == 1) {
            // 在线签约, 双方签约前
            ErpSsqContractExample erpSsqContractExample = new ErpSsqContractExample();
            erpSsqContractExample.setShardCityId(cityId);
            erpSsqContractExample.createCriteria().andDealIdEqualTo(dealId).andIsDelEqualTo((byte) 0);
            List<ErpSsqContract> ssqContracts = erpSsqContractMapper.selectByExample(erpSsqContractExample);
            if (!CollectionUtils.isEmpty(ssqContracts)) {
                if (ssqContracts.get(0).getContractStatus() != null && Integer.valueOf("1").equals(ssqContracts.get(0).getContractStatus())) {
                    //如果为流程总负责人，执行人，签约人，签约人主管，客源方经纪人，在签约后可以查看
                    if (userId.equals(erpFunDeal.getDealUserId()) || userId.equals(erpFunDeal.getExecutor()) || userId.equals(erpFunDeal.getSignUserId())
                            || userId.equals(erpFunDeal.getSignManagerId()) || userId.equals(erpFunDeal.getCustUserUid())) {
                        resList.stream().forEach(obj -> {
                            obj.setCanSee(1);
                        });
                    }
                }
            }
        }
        //初审中初审后均不可删除，只有初审前，且有合同编辑权才可以删除
        if (count2 != 0 && dealAuditStatus != null && dealAuditStatus == 0) {
            resList.stream().forEach(obj -> {
                obj.setCanDel(1);
            });
        }
    }

    // 合同查看权
    private Map<String, Boolean> getDealViewAuthMap(Integer cityId, Integer userId) {
        String viewCompOper = "VIEW_COMP_DEAL";
        String viewAreaOper = "VIEW_AREA_DEAL";
        String viewRegOper = "VIEW_REG_DEAL";
        String viewDeptOper = "VIEW_DEPT_DEAL";
        String viewGrOper = "VIEW_GROUP_DEAL";

        Map<String, Boolean> dealViewAuthMap = new HashMap<>();
        dealViewAuthMap.put(viewCompOper, false);
        dealViewAuthMap.put(viewAreaOper, false);
        dealViewAuthMap.put(viewRegOper, false);
        dealViewAuthMap.put(viewDeptOper, false);
        dealViewAuthMap.put(viewGrOper, false);

        List<String> operList = new ArrayList<>();
        operList.add(viewCompOper);
        operList.add(viewAreaOper);
        operList.add(viewRegOper);
        operList.add(viewDeptOper);
        operList.add(viewGrOper);

        ErpUserOpersExample operExample = new ErpUserOpersExample();
        operExample.setShardCityId(cityId);
        operExample.createCriteria().andUserIdEqualTo(userId).andOperIdIn(operList);
        List<ErpUserOpers> userOperList = erpUserOpersMapper.selectByExample(operExample);
        if (CollectionUtils.isNotEmpty(userOperList)) {
            Map<String, Boolean> userOperMap = userOperList.stream().collect(Collectors.toMap(ErpUserOpers::getOperId, a -> true));
            dealViewAuthMap.putAll(userOperMap);
        }
        return dealViewAuthMap;
    }

    /**
     * 查询shou佣比例
     * lcb
     *
     * @Param
     **/

    @RequestMapping("/getBrokerageIncomeByComp")
    public ResponseJson getBrokerageIncomeByComp(@RequestBody ErpFunDealParam erpFunDealParam) throws Exception {
        Operator operator = getOperator();

        ErpFunBrokerageIncomeExample erpFunBrokerageIncomeExample = new ErpFunBrokerageIncomeExample();
        erpFunBrokerageIncomeExample.setShardCityId(operator.getCityId());

        ErpFunBrokerageIncomeExample.Criteria criteria = erpFunBrokerageIncomeExample.createCriteria();
        criteria.andCompIdEqualTo(operator.getCompId());
        List<ErpFunBrokerageIncome> erpFunBrokerageIncomes = erpFunBrokerageIncomeMapper.selectByExample(erpFunBrokerageIncomeExample);
        if (erpFunBrokerageIncomes.size() == 0 && 0 != operator.getCompId()) {

            erpFunBrokerageIncomeExample = new ErpFunBrokerageIncomeExample();
            erpFunBrokerageIncomeExample.setShardCityId(operator.getCityId());
            erpFunBrokerageIncomeExample.createCriteria().andCompIdEqualTo(0);
            erpFunBrokerageIncomes = erpFunBrokerageIncomeMapper.selectByExample(erpFunBrokerageIncomeExample);
            for (ErpFunBrokerageIncome erpFunBrokerageIncome : erpFunBrokerageIncomes) {
                erpFunBrokerageIncome.setCompId(operator.getCompId());
                erpFunBrokerageIncome.setId(null);
                erpFunBrokerageIncome.setCreationTime(new Date());
            }

            if (erpFunBrokerageIncomes.size() > 0) {
                erpFunBrokerageIncomeServie.initBrokerageIncomeByCompId(operator.getCityId(), erpFunBrokerageIncomes);
            }

        }

        for (ErpFunBrokerageIncome po : erpFunBrokerageIncomes) {
            po.setHouseRate(po.getHouseRate().setScale(2, BigDecimal.ROUND_HALF_UP));
            po.setCustomerRate(po.getCustomerRate().setScale(2, BigDecimal.ROUND_HALF_UP));
        }
        return ErpResponseJson.ok(erpFunBrokerageIncomes);
    }

    /**
     * 查询佣比例
     * lcb
     *
     * @Param
     **/
    @ApiOperation("查询收佣列表")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = SaveBrokerageParamAndVo.class, message = "成功")
    })
    @PostMapping("/getBrokerageByComp")
    public ResponseJson getBrokerageByComp() {
        Operator operator = getOperator();
        SaveBrokerageParamAndVo resultVo = new SaveBrokerageParamAndVo();
        resultVo = erpFunBrokerageIncomeServie.getBrokerageByComp(operator.getCityId(), operator.getCompId());
        return ErpResponseJson.ok(resultVo);
    }

    /**
     * @tag 合同收佣标准保存
     * @author 邓永洪
     * @since 2018/7/5
     */
    @ApiOperation("合同收佣标准编辑保存")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/saveBrokerage")
    public ResponseJson saveBrokerage(@RequestBody SaveBrokerageParamAndVo param) {
        Integer cityId = getOperator().getCityId();
        ErpFunBrokerage leaseBrokerage = param.getLeaseBrokerage();
        ErpFunBrokerage saleBrokerage = param.getSaleBrokerage();

        erpFunDealService.saveBrokerage(leaseBrokerage, saleBrokerage, cityId);

        return ErpResponseJson.ok();
    }

    /**
     * 查询合同类别
     *
     * @Paramc
     **/
    @ApiOperation("查询合同类别")
    @RequestMapping("/getFunContractCategoryList")
    public ResponseJson getFunContractCategoryList() {
        List<ErpFunContractCategory> erpFunContractCategories = getErpFunContractCategories();
        return ErpResponseJson.ok(erpFunContractCategories);
    }

    private List<ErpFunContractCategory> getErpFunContractCategories() {
        Operator operator = getOperator();
        ErpFunContractCategoryExample erpFunContractExample = new ErpFunContractCategoryExample();
        erpFunContractExample.setShardCityId(operator.getCityId());
        erpFunContractExample.createCriteria().andCompIdEqualTo(operator.getCompId()).andIsDelEqualTo(new Byte("0"));
        erpFunContractExample.setOrderByClause("SEQ_NO ASC");
        return erpFunContractCategoryMapper.selectByExample(erpFunContractExample);
    }

    @ApiModelProperty("手机端合同类别列表")
    @RequestMapping("/getAppFunContractCategoryList")
    @ApiResponses({
            @ApiResponse(code = 200, message = "", response = ContractCateGoryVO.class)
    })
    public ResponseJson getAppFunContractCategoryList() {
        List<ErpFunContractCategory> erpFunContractCategories = getErpFunContractCategories();
        ContractCateGoryVO vo = new ContractCateGoryVO();
        vo.setContractCategories(erpFunContractCategories);
        return ErpResponseJson.ok(vo);
    }

    /**
     * 删除合同类别
     *
     * @Paramc
     **/
    @ApiOperation("删除合同类别")
    @ApiResponses({@ApiResponse(code = 200, response = ErpResponseJson.class, message = "success")})
    @PostMapping("/deleteContractProfit")
    public ResponseJson deleteContractProfit(@RequestBody ErpFunDealParam erpFunDealParam) {
        ErpFunContractCategory erpFunContractCategory = new ErpFunContractCategory();
        erpFunContractCategory.setCategoryId(erpFunDealParam.getCategoryId());
        erpFunContractCategory.setIsDel((byte) 1);
        erpFunContractCategory.setShardCityId(getOperator().getCityId());
        erpFunContractCategoryMapper.updateByPrimaryKeySelective(erpFunContractCategory);
        return ErpResponseJson.ok();
    }

    /**
     * 添加编辑合同类别
     *
     * @Paramc
     **/
    @ApiOperation("添加编辑合同类别")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/createOrUpdateFunContractCategory")
    public ResponseJson createOrUpdateFunContractCategory(@RequestBody FunContractCategoryListParam param) {
        List<ErpFunContractCategory> paramList = param.getCategoryList();
        Integer res = erpFunContractCategoryService.createOrUpdateFunContractCategory(getOperator().getCityId(), getOperator().getCompId(), paramList);
        return ErpResponseJson.ok();
    }

    @ApiOperation("获取财务款项列表")
    @RequestMapping("/getFinancePaymentList")
    public ResponseJson getFinancePaymentList() {
        List<ErpFunFinancPayment> erpFunFinancePayments = getErpFunFinancePayments();
        return ErpResponseJson.ok(erpFunFinancePayments);
    }

    @ApiOperation("获取财务款项列表")
    @RequestMapping("/getAppFinancePaymentList")
    @ApiResponses({
            @ApiResponse(code = 200, message = "", response = FinancePaymentListVO.class)
    })
    public ResponseJson getAppFinancePaymentList() {
        List<ErpFunFinancPayment> erpFunFinancePayments = getErpFunFinancePayments();
        FinancePaymentListVO vo = new FinancePaymentListVO();
        vo.setFinancePayments(erpFunFinancePayments);
        return ErpResponseJson.ok(vo);
    }

    private List<ErpFunFinancPayment> getErpFunFinancePayments() {
        Operator operator = getOperator();

        ErpFunFinancPaymentExample erpFunFinancPaymentExample = new ErpFunFinancPaymentExample();
        erpFunFinancPaymentExample.setShardCityId(operator.getCityId());
        erpFunFinancPaymentExample.createCriteria().andCompIdEqualTo(operator.getCompId()).andIsDelEqualTo(new Byte("0"));
        erpFunFinancPaymentExample.setOrderByClause("SEQ_NO");

        List<ErpFunFinancPayment> erpFunFinancePayments = erpFunFinancPaymentMapper.selectByExample(erpFunFinancPaymentExample);
        if (erpFunFinancePayments.size() == 0) {
            erpFunFinancPaymentService.createCompTempleteFinancPaymentList(operator.getCityId(), operator.getCompId());
            erpFunFinancePayments = erpFunFinancPaymentMapper.selectByExample(erpFunFinancPaymentExample);
        }
        return erpFunFinancePayments;
    }


    /**
     * 查询财务状态列表
     *
     * @Paramc
     **/
    @ApiOperation("查询财务状态列表")
    @RequestMapping("/getFunFinancStatusList")
    public ResponseJson getFunFinancStatusList() {
        List<ErpFunFinanceStatus> erpFunFinanceStatuses = getErpFunFinanceStatuses();
        return ErpResponseJson.ok(erpFunFinanceStatuses);
    }

    @ApiOperation("查询财务状态列表")
    @RequestMapping("/getAppFunFinancStatusList")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = FinanstatusListVO.class, message = "成功")
    })
    public ResponseJson getAppFunFinancStatusList() {
        List<ErpFunFinanceStatus> erpFunFinanceStatuses = getErpFunFinanceStatuses();
        FinanstatusListVO vo = new FinanstatusListVO();
        vo.setFinanceStatuses(erpFunFinanceStatuses);
        return ErpResponseJson.ok(vo);
    }

    private List<ErpFunFinanceStatus> getErpFunFinanceStatuses() {
        Operator operator = getOperator();

        ErpFunFinanceStatusExample erpFunFinanceStatusExample = new ErpFunFinanceStatusExample();
        erpFunFinanceStatusExample.setShardCityId(operator.getCityId());
        erpFunFinanceStatusExample.createCriteria().andCompIdEqualTo(operator.getCompId()).andIsDelEqualTo(new Byte("0"));
        erpFunFinanceStatusExample.setOrderByClause("SEQ_NO");

        List<ErpFunFinanceStatus> erpFunFinanceStatuses = erpFunFinanceStatusMapper.selectByExample(erpFunFinanceStatusExample);
        if (erpFunFinanceStatuses.size() == 0) {
            erpFunFinanceStatusService.createCompTempleteFinancStatusList(operator.getCityId(), operator.getCompId());
            erpFunFinanceStatuses = erpFunFinanceStatusMapper.selectByExample(erpFunFinanceStatusExample);
        }
        return erpFunFinanceStatuses;
    }

    /**
     * @tag 删除财务状态
     * @author 邓永洪
     * @since 2018/5/29
     */
    @ApiOperation("删除财务状态")
    @ApiResponses({@ApiResponse(code = 200, response = ErpResponseJson.class, message = "success")})
    @PostMapping("/deleteFunFinancStatus")
    public ResponseJson deleteFunFinancStatus(@RequestBody FunFinancStatusParam param) {
        Integer financeStatusId = param.getFinancStatusId();
        ErpFunFinanceStatus funFinanceStatus = new ErpFunFinanceStatus();
        funFinanceStatus.setShardCityId(getOperator().getCityId());
        funFinanceStatus.setFinancStatusId(financeStatusId);
        funFinanceStatus.setIsDel((byte) 1);
        erpFunFinanceStatusMapper.updateByPrimaryKeySelective(funFinanceStatus);
        return ErpResponseJson.ok();
    }

    /**
     * 财务款项编辑保存
     *
     * @Paramc
     **/

    @RequestMapping("/updateFinancPaymentList")
    public ResponseJson updateFinancPaymentList(@RequestBody BaseMapParam param) {
        Operator operator = getOperator();
        String paramJson = param.getString("paymentJson");
        List<ErpFunFinancPayment> paramList = JSON.parseArray(paramJson, ErpFunFinancPayment.class);
        erpFunFinancPaymentService.updateFinancPaymentList(operator.getCityId(), operator.getCompId(), paramList);
        return ErpResponseJson.ok();
    }

    @ApiOperation("财务款项编辑保存")
    @RequestMapping("/updateAppFinancPaymentList")
    @ApiResponses({@ApiResponse(code = 200, response = ErpResponseJson.class, message = "success")})
    public ResponseJson updateAppFinancPaymentList(@RequestBody UpdateFinanceParam param) {
        Operator operator = getOperator();
        List<ErpFunFinancPayment> paramList = param.getFinanceList();
        erpFunFinancPaymentService.updateFinancPaymentList(operator.getCityId(), operator.getCompId(), paramList);
        return ErpResponseJson.ok();
    }

    /**
     * 更新支付方式列表
     *
     * @Paramc
     **/

    @RequestMapping("/updateFunDealPaytype")
    public ResponseJson updateFunDealPaytype(@RequestBody BaseMapParam param) {
        Operator operator = getOperator();
        String paramJson = param.getString("paytypeList");
        List<ErpFunDealPaytype> paramList = JSON.parseArray(paramJson, ErpFunDealPaytype.class);
        erpFunDealPaytypeService.updateFunDealPaytype(operator.getCityId(), operator.getCompId(), paramList);
        return ErpResponseJson.ok();
    }


    /**
     * 更新支付方式列表
     *
     * @Paramc
     **/

    @RequestMapping("/updateAppFunDealPaytype")
    public ResponseJson updateAppFunDealPaytype(@RequestBody UpdateAppFunDealPay param) {
        Operator operator = getOperator();
        List<ErpFunDealPaytype> paramList = param.getFunDealPaytypeList();
        erpFunDealPaytypeService.updateFunDealPaytype(operator.getCityId(), operator.getCompId(), paramList);
        return ErpResponseJson.ok();
    }

    /**
     * 财务款项编辑保存
     *
     * @Paramc
     **/

    @RequestMapping("/createFunFinancStatus")
    public ResponseJson createFunFinancStatus(@RequestBody BaseMapParam param) {
        Operator operator = getOperator();
        String paramJson = param.getString("financstatusJson");
        List<ErpFunFinanceStatus> paramList = JSON.parseArray(paramJson, ErpFunFinanceStatus.class);
        erpFunFinanceStatusService.createFunFinancStatus(operator.getCityId(), operator.getCompId(), paramList);
        return ErpResponseJson.ok();
    }

    @ApiOperation("财务款项编辑保存")
    @RequestMapping("/createAppFunFinancStatus")
    public ResponseJson createAppFunFinancStatus(@RequestBody FinanceStatusListParam param) {
        Operator operator = getOperator();
        List<ErpFunFinanceStatus> paramList = param.getFinanceStatusList();
        erpFunFinanceStatusService.createFunFinancStatus(operator.getCityId(), operator.getCompId(), paramList);
        return ErpResponseJson.ok();
    }

    @ApiOperation("获取支付方式列表")
    @RequestMapping("/getFunDealPayTypeList")
    public ResponseJson getFunDealPayTypeList() {
        List<ErpFunDealPaytype> payTypes = getFunDealPayTypes();
        return ErpResponseJson.ok(payTypes);
    }

    @ApiOperation("移动端获取支付方式列表")
    @RequestMapping("/getFunDealPayTypeListInMobile")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunDealPayTypeVo.class, message = "成功")
    })
    @ResponseBody
    public ResponseJson getFunDealPayTypeListInMobile() {
        List<ErpFunDealPaytype> payTypes = getFunDealPayTypes();
        ErpFunDealPayTypeVo payTypeVo = new ErpFunDealPayTypeVo();
        payTypeVo.setPayTypes(payTypes);
        return ErpResponseJson.ok(payTypeVo);
    }

    private List<ErpFunDealPaytype> getFunDealPayTypes() {
        Operator operator = getOperator();

        ErpFunDealPaytypeExample erpFunDealPaytypeExample = new ErpFunDealPaytypeExample();
        erpFunDealPaytypeExample.setShardCityId(operator.getCityId());
        erpFunDealPaytypeExample.createCriteria().andCompIdEqualTo(operator.getCompId()).andIsDelEqualTo(new Byte("0"));
        erpFunDealPaytypeExample.setOrderByClause("SEQ_NO");

        List<ErpFunDealPaytype> payTypes = erpFunDealPaytypeMapper.selectByExample(erpFunDealPaytypeExample);
        if (payTypes.size() == 0) {
            erpFunDealPaytypeService.createCompTempleteDealPayTypeList(operator.getCityId(), operator.getCompId());
            payTypes = erpFunDealPaytypeMapper.selectByExample(erpFunDealPaytypeExample);
        }
        return payTypes;
    }

    /**
     * 查询贷款银行列表
     *
     * @Paramc
     **/
    @ApiOperation("查询贷款银行列表")
    @RequestMapping("/getLoanBankList")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, responseContainer = "List", response = ErpFunLoanBank.class, message = "成功")
    })
    @ResponseBody
    public ResponseJson getLoanBankList(@RequestBody GetLoanBankParam param) {
        Operator operator = getOperator();
        String bankName = param.getBankName();
        Set<String> bkNameSet = new HashSet<>();
        if (StringUtils.isNotBlank(bankName)) {
            Collections.addAll(bkNameSet, bankName.split(","));
        }

        List<ErpFunLoanBank> erpFunLoanBanks = erpFunLoanBankMapper.getList(operator.getCityId(), operator.getCompId(), bkNameSet);
//		if(StringUtils.isBlank(bankName) && erpFunLoanBanks.size() == 0){
//			erpFunLoanBankMapper.initLoadBankList(operator.getCityId(), operator.getCompId());
//			ErpFunLoanBankExample erpFunLoanBankExample = new ErpFunLoanBankExample();
//			erpFunLoanBankExample.setShardCityId(operator.getCityId());
//			erpFunLoanBankExample.createCriteria().andCompIdEqualTo(operator.getCompId());
//			erpFunLoanBanks = erpFunLoanBankMapper.selectByExample(erpFunLoanBankExample);
//		}
        return ErpResponseJson.ok(erpFunLoanBanks);
    }


    @ApiOperation("移动端查询贷款银行列表")
    @RequestMapping("/getLoanBankListInMobile")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunLoanBankVo.class, message = "成功")
    })
    @ResponseBody
    public ResponseJson getLoanBankListInMobile(@RequestBody GetLoanBankParam param) {
        Operator operator = getOperator();
        String bankName = param.getBankName();
        Set<String> bkNameSet = new HashSet<>();
        if (StringUtils.isNotBlank(bankName)) {
            Collections.addAll(bkNameSet, bankName.split(","));
        }

        List<ErpFunLoanBank> erpFunLoanBanks = erpFunLoanBankMapper.getList(operator.getCityId(), operator.getCompId(), bkNameSet);
        ErpFunLoanBankVo vo = new ErpFunLoanBankVo();
        vo.setBanks(erpFunLoanBanks);

        return ErpResponseJson.ok(vo);
    }

    /**
     * 删除贷款银行
     *
     * @Paramc
     **/

    @RequestMapping("/delLoandBank")
    public ResponseJson delLoandBank(@RequestBody IdParam param) {
        Operator operator = getOperator();
        Integer id = param.getId();
        ErpFunLoanBank erpFunLoanBank = new ErpFunLoanBank();
        erpFunLoanBank.setBankStatus(new Byte("0"));

        ErpFunLoanBankExample erpFunLoanBankExample = new ErpFunLoanBankExample();
        erpFunLoanBankExample.setShardCityId(operator.getCityId());
        erpFunLoanBankExample.createCriteria().andBankStatusEqualTo(new Byte("1")).andIdEqualTo(id);
        erpFunLoanBankMapper.updateByExampleSelective(erpFunLoanBank, erpFunLoanBankExample);
        return ErpResponseJson.ok();
    }

    /**
     * 添加编辑贷款银行
     *
     * @Paramc
     **/

    @RequestMapping("/addEditLoanBank")
    public ResponseJson addEditLoanBank(@RequestBody EditBankParam param) {

        Operator operator = getOperator();
        String bankList = param.getBankList();
        List<ErpFunLoanBank> paramList = JSON.parseArray(bankList, ErpFunLoanBank.class);

        erpFunLoanBankService.addEditLoanBank(operator.getCityId(), operator.getCompId(), paramList);
        return ErpResponseJson.ok();
    }

    /**
     * 手机端添加编辑贷款银行
     *
     * @Paramc
     **/

    @RequestMapping("/addEditLoanBankApp")
    public ResponseJson addEditLoanBankApp(@RequestBody EditBankListParam param) {
        Operator operator = getOperator();
        List<ErpFunLoanBank> paramList = param.getBankList();
        erpFunLoanBankService.addEditLoanBank(operator.getCityId(), operator.getCompId(), paramList);
        return ErpResponseJson.ok();
    }

    /**
     * 查询公司LOGO
     *
     * @Paramc
     **/
    @ApiOperation(value = "查询公司LOGO等图片")
    @RequestMapping("/getDealLogoByComp")
    public ResponseJson getDealLogoByComp(@RequestBody BaseMapParam param) throws Exception {

        Operator operator = getOperator();
        Byte photoType = param.getByte("photoType");
        if (null == photoType) {
            photoType = (byte) 3;
        }
        ErpFunDealPhotoExample erpFunDealPhotoExample = new ErpFunDealPhotoExample();
        erpFunDealPhotoExample.setShardCityId(operator.getCityId());
        erpFunDealPhotoExample.createCriteria().andCompIdEqualTo(operator.getCompId()).
                andPhotoTypeEqualTo(photoType).andTransmitFlagEqualTo(new Byte("0"));

        List<ErpFunDealPhoto> erpFunDealPhotos = erpFunDealPhotoMapper.selectByExample(erpFunDealPhotoExample);

        ErpFunDealPhoto erpFunDealPhoto = new ErpFunDealPhotoDto();
        if (erpFunDealPhotos.size() > 0) {
            erpFunDealPhoto = erpFunDealPhotos.get(0);
            erpFunDealPhoto.setPhotoAddr(CommonUtil.getHousePhoto(erpFunDealPhoto.getPhotoAddr()));
        }

        return ErpResponseJson.ok(erpFunDealPhoto);
    }


    /**
     * 删除贷款方式
     *
     * @Paramc
     **/

    @RequestMapping("/deleteFunDealPayType")
    public ResponseJson deleteFunDealPayType(@RequestBody DeleteDealPayParam param) {
        Operator operator = getOperator();

        ErpFunDealPaytype deleteModel = new ErpFunDealPaytype();
        deleteModel.setPaytypeId(param.getPaytypeId());
        deleteModel.setIsDel(new Byte("1"));
        deleteModel.setShardCityId(operator.getCityId());
        erpFunDealPaytypeMapper.updateByPrimaryKeySelective(deleteModel);
        return ErpResponseJson.ok();
    }

    /**
     * title ：查询贷款过户信息
     * author：lcb
     * date  : 2017/10/13
     */

    @RequestMapping("/getFinanceTransferInfo")
    public ResponseJson getFinanceTransferInfo(@RequestBody BaseMapParam param) throws Exception {
        Map<String, Object> resMap = new HashMap<>();
        Operator operator = getOperator();
        Integer dealId = param.getInteger("dealId");

        ErpFunDeal erpFunDeal = new ErpFunDeal();
        erpFunDeal.setDealId(dealId);
        erpFunDeal.setShardCityId(operator.getCityId());
        erpFunDeal = erpFunDealMapper.selectByPrimaryKey(erpFunDeal);

        // 查询贷款过户信息
        AdminJrFinanceInfoDto adminJrFinanceInfoDto = adminJrFinanceInfoMapper.getTransferInfoByDealId(operator.getCityId(), operator.getCompNo(), operator.getDeptNo(), dealId);

        resMap.put("transferInfo", adminJrFinanceInfoDto);
        resMap.put("dealInfo", erpFunDeal);
        return ErpResponseJson.ok(resMap);
    }

    /**
     * title ：手动录入时 根据系统参数判断 合同号是否可用
     * author：lcb
     * date  : 2017/10/13
     */
    @ApiOperation("手动录入时 根据系统参数判断 合同号是否可用")
    @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ContractNoAvailableVo.class, message = "成功")
    @PostMapping("/checkMaualContractNoAvailable")
    public ResponseJson checkMaualContractNoAvailable(@RequestBody ContractNoAvailableParam param) throws Exception {
        ContractNoAvailableVo resultVo = new ContractNoAvailableVo();
        Integer result;
        Operator operator = getOperator();
        String contractNo = param.getContractNo(); // 合同号

        // 1重复
        ErpFunDealCodelogExample erpFunDealCodelogExample = new ErpFunDealCodelogExample();
        erpFunDealCodelogExample.setShardCityId(operator.getCityId());
        erpFunDealCodelogExample.createCriteria().andCompIdEqualTo(operator.getCompId()).andCodeNoEqualTo(contractNo).andUseStatusEqualTo(new Byte("1"));
        List<ErpFunDealCodelog> erpFunDealCodelogs = erpFunDealCodelogMapper.selectByExample(erpFunDealCodelogExample);

        if (erpFunDealCodelogs.size() > 0) {
            result = 1; //
        } else {
            String allowUnuseDealnoIsbyhand = erpSysParaMapper.getParamValue(operator.getCityId(), operator.getCompId(), "ALLOW_UNUSE_DEALNO_ISBYHAND");
            // 先判断是否被使用了
            // 不允许手动录入
            if (StringUtils.isBlank(allowUnuseDealnoIsbyhand) || "0".equals(allowUnuseDealnoIsbyhand)) {

                // 查询规则
                ErpFunDealCodeExample erpFunDealCodeExample = new ErpFunDealCodeExample();
                erpFunDealCodeExample.setShardCityId(operator.getCityId());
                erpFunDealCodeExample.createCriteria().andCompIdEqualTo(operator.getCompId()).andStatusEqualTo(new Byte("1"));
                List<ErpFunDealCode> erpFunDealCodes = erpFunDealCodeMapper.selectByExample(erpFunDealCodeExample);
                // 2：规则外
                result = 2;
                for (ErpFunDealCode erpFunDealCode : erpFunDealCodes) {
                    if (contractNo.startsWith(erpFunDealCode.getCodePrefix())) {
                        result = 3;
                        if (erpFunDealCode.getUsedCount().intValue() >= erpFunDealCode.getTotalCount()) {
                            result = 4;
                        }
                        break;
                    }
                }

            } else {
                // 3可以使用
                result = 3;
            }
        }
        resultVo.setResult(result);
        return ErpResponseJson.ok(resultVo);
    }


    /**
     * 新版获取模板内容
     * lcb
     **/
    @RequestMapping("/getTemplateListNew")
    public ResponseJson getTemplateListNew(@RequestBody BaseMapParam baseMapParam) {

        List<Map<String, Object>> resList = new ArrayList<>();

        Operator operator = getOperator();

        ErpFunContractTemplaeExample erpFunContractTemplaeExample = new ErpFunContractTemplaeExample();
        erpFunContractTemplaeExample.setShardCityId(operator.getCityId());
        ErpFunContractTemplaeExample.Criteria criteria = erpFunContractTemplaeExample.createCriteria();

        // 优家
        criteria.andTemplateIdEqualTo(baseMapParam.getInteger("templateId"));

        // 查询模板基本数据
        List<ErpFunContractTemplae> erpFunContractTemplaes = erpFunContractTemplaeMapper.selectByExampleWithBLOBs(erpFunContractTemplaeExample);

        Set<Integer> tempeletIds = new HashSet<>();
        for (ErpFunContractTemplae erpFunContractTemplae : erpFunContractTemplaes) {
            tempeletIds.add(erpFunContractTemplae.getTemplateId());
        }

        // 查询模板参数列表
        ErpFunContractIndexExample erpFunContractIndexExample = new ErpFunContractIndexExample();
        erpFunContractIndexExample.setShardCityId(operator.getCityId());
        erpFunContractIndexExample.createCriteria().andTemplateIdIn(new ArrayList<>(tempeletIds));
        List<ErpFunContractIndex> erpFunContractIndices = erpFunContractIndexMapper.selectByExample(erpFunContractIndexExample);

        // 分组处理
        for (ErpFunContractTemplae erpFunContractTemplae : erpFunContractTemplaes) {

            List<ErpFunContractIndex> erpFunContractIndexList = new ArrayList<>();
            Map<String, Object> resMap = new HashMap<>();

            for (ErpFunContractIndex erpFunContractIndex : erpFunContractIndices) {
                if (erpFunContractTemplae.getTemplateId().equals(erpFunContractIndex.getTemplateId())) {
                    erpFunContractIndexList.add(erpFunContractIndex);
                    // 处理字段
                    String funDealField = erpFunContractIndex.getFunDealField();
                    if (StringUtils.isNotBlank(funDealField)) {
                        erpFunContractIndex.setFunDealField(StringUtil.changeUnderLine(funDealField));
                    }
                }
            }

            resMap.put("template", erpFunContractTemplae);
            resMap.put("indexList", erpFunContractIndexList);
            resList.add(resMap);
        }

        return ErpResponseJson.ok(resList);
    }

    /**
     * 新版的查询合同
     * lcb
     *
     * @Param
     **/

    @RequestMapping("/getContractNew")
    @NotBlank({"dealId"})
    public ResponseJson getContractNew(@RequestBody ErpFunContractTemplaeParam erpFunContractTemplaeParam) {
        Operator operator = getOperator();
        // 总的结果
        List<Map<String, Object>> resultList = new ArrayList<>();
        erpFunContractTemplaeParam.setCompId(operator.getCompId());
        erpFunContractTemplaeParam.setDeptId(operator.getDeptId());

        ErpFunContractDealExample erpFunContractDealExample = new ErpFunContractDealExample();
        erpFunContractDealExample.setShardCityId(operator.getCityId());
        ErpFunContractDealExample.Criteria criteria = erpFunContractDealExample.createCriteria();
        criteria.andDealIdEqualTo(erpFunContractTemplaeParam.getDealId()).andCaseTypeEqualTo(erpFunContractTemplaeParam.getCaseType().byteValue());
        if (null != erpFunContractTemplaeParam.getContentType()) {
            criteria.andContractTypeEqualTo(erpFunContractTemplaeParam.getContentType().byteValue());
        }
        List<ErpFunContractDeal> erpFunContractDeals = erpFunContractDealMapper.selectByExample(erpFunContractDealExample);
        // 签约门店
        ErpFunDeal erpFunDeal = erpFunDealMapper.getBaseDealInfo(operator.getCityId(), erpFunContractTemplaeParam.getDealId());
        Assert.isNullThrow(erpFunDeal, "合同数据有误");

        Integer signUserDeptId = erpFunDeal.getSignUserDeptId();
        // 签约门店
        ErpFunDepts depts = erpFunDeptsMapper.getByDeptId(operator.getCityId(), signUserDeptId);
        Assert.isNullThrow(depts, "签约门店信息有误");
        AdminFunDepts adminFunDepts = adminFunDeptsMapper.selectByDeptNoAndCompNo(depts.getDeptNo(), depts.getCompNo());
        Assert.isNullThrow(adminFunDepts, "门店信息有误");

        Byte youjiaDeptFlag = adminFunDepts.getYoujiaDeptFlag();
        Byte youSaleDealNeedExamine = adminFunDepts.getYouSaleDealNeedExamine();
        Byte youLeaseDealNeedExamine = adminFunDepts.getYouLeaseDealNeedExamine();

        if (erpFunContractDeals.size() == 0 && (null != youjiaDeptFlag && 1== youjiaDeptFlag) && "1".equals(operator.getAttribute("YOU_CITY_DEAL_NEED_EXAMINE").toString()) && (null != youSaleDealNeedExamine && 1 == youSaleDealNeedExamine || (null != youLeaseDealNeedExamine && 1 == youLeaseDealNeedExamine))) {
            resultList = erpFunContractService.generatorContract(erpFunContractTemplaeParam, operator.getCityId(), operator.getUserId(), operator.getUserName());
        } else {
            List<Integer> contractId = new ArrayList<>();
            for (ErpFunContractDeal erpFunContractDeal : erpFunContractDeals) {
                contractId.add(erpFunContractDeal.getContractId());
            }
            if (contractId.size() > 0) {
                // 合同内容
                ErpFunContractExample erpFunContractExample = new ErpFunContractExample();
                erpFunContractExample.setShardCityId(operator.getCityId());
                erpFunContractExample.createCriteria().andContractIdIn(new ArrayList<>(contractId));
                List<ErpFunContract> erpFunContract = erpFunContractMapper.selectByExampleWithBLOBs(erpFunContractExample);

                // 指标值
                List<ErpFunIndexValueDto> indexValueList = erpFunIndexValueMapper.getIndexValueList(operator.getCityId(), contractId, null);

                for (ErpFunContract contract : erpFunContract) {

                    Map<String, Object> resMap = new HashMap<>();
                    // 批注列表
                    resMap.put("contract", contract);
                    List<ErpFunIndexValueDto> indexList = new ArrayList<>();

                    for (ErpFunIndexValueDto erpFunIndexValue : indexValueList) {

                        if (erpFunIndexValue.getContractId().equals(contract.getContractId())) {
                            if (StringUtils.isNotBlank(erpFunIndexValue.getFunDealField())) {
                                erpFunIndexValue.setFunDealField(StringUtil.changeUnderLine(erpFunIndexValue.getFunDealField()));
                            }
                            indexList.add(erpFunIndexValue);
                        }
                    }
                    resMap.put("indexList", indexList);
                    // 第一个是合同或者协议，有批注信息
                    if (contractId.get(0).equals(contract.getContractId())) {
                        // 查询合同信息（只有第一个有批注）
                        // 查询关联表

                        erpFunDeal = erpFunDealMapper.selectFunDealByContractId(operator.getCityId(), operator.getCompId(), contractId.get(0));

                        List<ErpFunContractTagDto> resList = new ArrayList<>();
                        Byte eight = new Byte("8");
                        Byte three = new Byte("3");
                        Boolean flag = eight.equals(erpFunDeal.getYouAduitStatus()) || three.equals(erpFunDeal.getYouAduitStatus()) ||
                                eight.equals(erpFunDeal.getYouAduitStatusProtocol()) || three.equals(erpFunDeal.getYouAduitStatusProtocol());
                        // 等待一审 或者 一审未通过
                        if (null != erpFunDeal && flag) {
                            // 查询标注列表
                            resList = erpFunContractTagMapper.selectListDto(operator.getCityId(), contractId.get(0), operator.getCompId(), operator.getDeptId());

                            Set<Integer> laywerId = new HashSet<>();
                            // 关联律师信息
                            for (ErpFunContractTag erpFunContractTag : resList) {
                                laywerId.add(erpFunContractTag.getCreateUid());
                            }

                            if (laywerId.size() > 0) {
                                AdminWeiUserInfoExample adminWeiUserInfoExample = new AdminWeiUserInfoExample();
                                adminWeiUserInfoExample.createCriteria().andWeiUserIdIn(new ArrayList<>(laywerId));
                                List<AdminWeiUserInfo> laywerList = adminWeiUserInfoMapper.selectByExample(adminWeiUserInfoExample);
                                for (ErpFunContractTagDto erpFunContractTagDto : resList) {
                                    for (AdminWeiUserInfo adminWeiUserInfo : laywerList) {
                                        if (erpFunContractTagDto.getCreateUid().equals(adminWeiUserInfo.getWeiUserId())) {
                                            erpFunContractTagDto.setLaywerName(adminWeiUserInfo.getUserName());
                                        }
                                    }
                                }
                            }
                        }

                        resMap.put("tagList", resList);
                    }
                    resultList.add(resMap);
                }
            }
        }
        return ErpResponseJson.ok(resultList);
    }

    /**
     * 更新合同
     * lcb
     *
     * @Param
     **/

    @RequestMapping("/resetContract")
    @NotBlank({"dealId"})
    public ResponseJson resetContract(@RequestBody ErpFunContractTemplaeParam erpFunContractTemplaeParam) {
        Operator operator = getOperator();
        // 删除关联关系
        erpFunContractService.deleteLink(operator.getCityId(), erpFunContractTemplaeParam.getDealId());
        ResponseJson contractNew = getContractNew(erpFunContractTemplaeParam);
        return contractNew;
    }

    /**
     * 删除财务类别配置
     * lcb
     *
     * @Param
     **/

    @ApiOperation("删除财务类别配置")
    @RequestMapping("/deleteFinancPayment")
    @NotBlank({"paymentId"})
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    public ResponseJson deleteFinancPayment(@Validated @RequestBody PaymentIdParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer res = erpFunFinancPaymentService.deletePaymentById(cityId, param.getPaymentId());
        return ErpResponseJson.ok(res);
    }

    /**
     * @param
     * @return
     * @title erp和掌通新增合同
     * @author lcb
     * @date 2019/5/22
     */
    @ApiOperation("新增合同")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = InsertIntoDealInfoVo.class, message = "成功")
    })
    @PostMapping("/insertIntoDealInfo")
    public ErpResponseJson insertIntoDealInfo(@RequestBody InsertDealInfoParam param) throws Exception {
//  房源审核不通过，创建合同
        if (Const.DIC_CASE_TYPE_SALE_FUN.equals(param.getCaseType())) {
            ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(param.getCityId(), param.getDealHouseId());

            if(!Const.HOUSE_VERIFY_0.equals(erpFunSale.getHouseVerify())&&erpFunSale.getHouseVerify()!=null){
                throw new BusinessException("房源未审核通过，暂不能录入成交信息");
            }

        } else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(param.getCaseType())) {
            ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(param.getCityId(), param.getDealHouseId());

            if(!Const.HOUSE_VERIFY_0.equals(erpFunLease.getHouseVerify())&&erpFunLease.getHouseVerify()!=null){
                throw new BusinessException("房源未审核通过，暂不能录入成交信息");
            }
        }
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        Integer userId = operator.getUserId();
        Integer compType = operator.getCompType();
        String deptType = StringUtil.toString(operator.getAttribute("DEPT_TYPE")) ;
        if (compType == 6 && "6".equals(deptType)) {
            deptType = "6";
        } else {
            deptType = "1";
        }
        param.setDeptType(Byte.valueOf(deptType));
        param.setPersonalVersion(operator.isPersonalVersion());
        param.setSelfCompType(operator.getCompType());
        param.setSelfDeptName(operator.getDeptName());
        param.setSelfUserName(operator.getUserName());
        param.setSelfUserId(operator.getUserId());
        param.setSelfDeptId(operator.getDeptId());
        param.setSelfCompId(operator.getCompId());
        param.setSelfArchiveId(operator.getArchiveId());
        param.setSelfGrId(operator.getGrId());
        param.setSelfAreaId(operator.getAreaId());
        param.setSelfRegId(operator.getRegId());
        param.setCityId(cityId);

        //判断是否是房基地
        if (adminFunCompService.judgerIsFangjidi(operator.getAdminCompId())) {
            if (param.getDealBuyStyle() != null && "0".equals(param.getDealBuyStyle().toString())
                    && param.getDealSellStyle() != null && "0".equals(param.getDealSellStyle().toString())) { //都是內部合作
                //判断佣金是否小于总共的90%
                if (!erpProcessFinanceService.chackCommission(cityId, operator.getCompId(), param.getDealType(), param.getSellDealMoney(), param.getRentDealMoney(), param.getRentPriceUnit(), param.getArea(), param.getSellOwnerCommsion(), param.getBuyCustomerCommsion())) {
                    return ErpResponseJson.warn("业主与客户付佣的总金额 不能低于 业主与客户付佣金额标准的90%！");
                }
            }
            if (null != param.getIntroducerId()) {
                if (null != param.getCustUserUid() && param.getIntroducerId().equals(param.getCustUserUid())) {
                    return ErpResponseJson.warn("转介人不可与客源所属经纪人相同！");
                }
                if (null != param.getHouseUserUid() && param.getIntroducerId().equals(param.getHouseUserUid())) {
                    return ErpResponseJson.warn("转介人不可与房源所属经纪人相同！");
                }
            }
            if (null != param.getAdultPromotionId()) {
                if (null != param.getCustUserUid() && param.getAdultPromotionId().equals(param.getCustUserUid())) {
                    return ErpResponseJson.warn("销售助攻不可与客源所属经纪人相同！");
                }
            }
        }
        Integer dealId = this.insetDealInfo(param);
        copyPhoto(dealId, param);
        sysHousePic(cityId, userId, compId, dealId, param);
        InsertIntoDealInfoVo vo = new InsertIntoDealInfoVo();
        vo.setDealId(dealId);
        return ErpResponseJson.ok(vo);
    }

    private void sysHousePic(Integer cityId, Integer userId, Integer compId, Integer dealId, InsertDealInfoParam param) {
        //判断合同是出售还是出租
        List<ErpFunCustFile> erpFunCustFiles = null;   //客源
        List<ErpFunHouseFile> erpFunHouseFiles = null; //房源
        ErpFunCustFileExample erpFunCustFileExample = new ErpFunCustFileExample();  //客源
        erpFunCustFileExample.setShardCityId(cityId);
        ErpFunHouseFileExample erpFunHouseFileExample = new ErpFunHouseFileExample(); //房源
        erpFunHouseFileExample.setShardCityId(cityId);
        if ("101".equals(param.getDealType().toString())) {// 出售： 101
            if (null != param.getDealBuyStyle() && "0".equals(param.getDealBuyStyle().toString())) {
                Integer dealCustomerId = param.getDealCustomerId();//客源ID
                List<Byte> fileClass = new ArrayList<Byte>();
                fileClass.add((byte) 1);
                fileClass.add((byte) 2);
                List<Byte> fileType = new ArrayList<Byte>();
                fileType.add((byte) 1);
                fileType.add((byte) 2);
                fileType.add((byte) 3);
                fileType.add((byte) 4);
                fileType.add((byte) 5);
                fileType.add((byte) 6);
                fileType.add((byte) 7);
                fileType.add((byte) 8);
                erpFunCustFileExample.createCriteria().andCompIdEqualTo(compId)
                        .andCityIdEqualTo(cityId).andCaseIdEqualTo(dealCustomerId)
                        .andCaseTypeEqualTo((byte) 3).andDelFlagEqualTo((byte) 0)
                        .andFileClassIn(fileClass).andFileTypeIn(fileType);
                erpFunCustFiles = erpFunCustFileMapper.selectByExample(erpFunCustFileExample);
            }
            if (null != param.getDealSellStyle() && "0".equals(param.getDealSellStyle().toString())) {
                Integer dealHouseId = param.getDealHouseId();//房源ID
                List<Byte> fileClass = new ArrayList<Byte>();
                fileClass.add((byte) 2);
                fileClass.add((byte) 3);
                List<Byte> fileType = new ArrayList<Byte>();
                fileType.add((byte) 5);
                fileType.add((byte) 6);
                fileType.add((byte) 9);
                fileType.add((byte) 10);
                fileType.add((byte) 11);
                fileType.add((byte) 12);
                fileType.add((byte) 13);
                fileType.add((byte) 15);
                fileType.add((byte) 16);
                fileType.add((byte) 18);
                erpFunHouseFileExample.createCriteria().andCityIdEqualTo(cityId).andCompIdEqualTo(compId)
                        .andCaseIdEqualTo(dealHouseId).andCaseTypeEqualTo((byte) 1).andDelFlagEqualTo((byte) 0)
                        .andFileClassIn(fileClass).andFileTypeIn(fileType);
                erpFunHouseFiles = erpFunHouseFileMapper.selectByExample(erpFunHouseFileExample);
            }
        } else if ("102".equals(param.getDealType().toString())) { //出租 102
            if (null != param.getDealBuyStyle() && "0".equals(param.getDealBuyStyle().toString())) {
                List<Byte> fileClass = new ArrayList<Byte>();
                fileClass.add((byte) 1);
                List<Byte> fileType = new ArrayList<Byte>();
                fileType.add((byte) 1);
                fileType.add((byte) 2);
                Integer dealCustomerId = param.getDealCustomerId();//客源ID
                erpFunCustFileExample.createCriteria().andCompIdEqualTo(compId)
                        .andCityIdEqualTo(cityId).andCaseIdEqualTo(dealCustomerId)
                        .andCaseTypeEqualTo((byte) 4).andDelFlagEqualTo((byte) 0)
                        .andFileClassIn(fileClass).andFileTypeIn(fileType);
                erpFunCustFiles = erpFunCustFileMapper.selectByExample(erpFunCustFileExample);
            }
            if (null != param.getDealSellStyle() && "0".equals(param.getDealSellStyle().toString())) {
                Integer dealHouseId = param.getDealHouseId();//房源ID
                List<Byte> fileClass = new ArrayList<Byte>();
                fileClass.add((byte) 2);
                fileClass.add((byte) 3);
                List<Byte> fileType = new ArrayList<Byte>();
                fileType.add((byte) 5);
                fileType.add((byte) 6);
                fileType.add((byte) 8);
                fileType.add((byte) 9);
                fileType.add((byte) 10);
                fileType.add((byte) 11);
                fileType.add((byte) 14);
                fileType.add((byte) 15);
                erpFunHouseFileExample.createCriteria().andCityIdEqualTo(cityId).andCompIdEqualTo(compId)
                        .andCaseIdEqualTo(dealHouseId).andCaseTypeEqualTo((byte) 2).andDelFlagEqualTo((byte) 0)
                        .andFileClassIn(fileClass).andFileTypeIn(fileType);
                erpFunHouseFiles = erpFunHouseFileMapper.selectByExample(erpFunHouseFileExample);

            }
        }
        if (erpFunCustFiles != null && erpFunCustFiles.size() > 0) {
            for (ErpFunCustFile erpFunCustFile : erpFunCustFiles) {
                ErpFunDealPhoto erpFunDealPhoto = new ErpFunDealPhotoDto();
                erpFunDealPhoto.setShardCityId(cityId);
                erpFunDealPhoto.setCompId(compId);
                erpFunDealPhoto.setDealId(dealId);
                erpFunDealPhoto.setPhotoAddr(erpFunCustFile.getFileAddr());
                erpFunDealPhoto.setPhotoType((byte) 0);
                erpFunDealPhoto.setUseageType((byte) 1);
                erpFunDealPhoto.setUploadUser(userId);
                erpFunDealPhoto.setUploadDate(new Date());
                erpFunDealPhoto.setTransmitFlag((byte) 0);
                erpFunDealPhoto.setFileType(erpFunCustFile.getFileClass());
                erpFunDealPhoto.setFileSubType(erpFunCustFile.getFileType());
                erpFunDealPhotoMapper.insertSelective(erpFunDealPhoto);
            }
        }
        if (erpFunHouseFiles != null && erpFunHouseFiles.size() > 0) {
            for (ErpFunHouseFile erpFunHouseFile : erpFunHouseFiles) {
                ErpFunDealPhoto erpFunDealPhoto = new ErpFunDealPhotoDto();
                erpFunDealPhoto.setShardCityId(cityId);
                erpFunDealPhoto.setCompId(compId);
                erpFunDealPhoto.setDealId(dealId);
                erpFunDealPhoto.setPhotoAddr(erpFunHouseFile.getFileAddr());
                erpFunDealPhoto.setPhotoType((byte) 1);
                erpFunDealPhoto.setUseageType((byte) 1);
                erpFunDealPhoto.setUploadUser(userId);
                erpFunDealPhoto.setUploadDate(new Date());
                erpFunDealPhoto.setTransmitFlag((byte) 0);
                erpFunDealPhoto.setFileType(erpFunHouseFile.getFileClass());
                erpFunDealPhoto.setFileSubType(erpFunHouseFile.getFileType());
                erpFunDealPhotoMapper.insertSelective(erpFunDealPhoto);
            }
        }
    }


    public static void main(String[] args) {

        List<ErpDealUserRelative> erpDealUserRelatives = new ArrayList<>();
        boolean isRelated = (int) erpDealUserRelatives.stream().filter(v -> Integer.valueOf("1").equals(v.getUserId())).count() > 0;
        int relOutOfSelfHouUserCon = (int) erpDealUserRelatives.stream().filter(v -> !(Byte.valueOf("6").equals(v.getRelateType()) && Integer.valueOf("1").equals(v.getUserId())) && Integer.valueOf("1").equals(v.getRegId())).count();
        System.out.println(isRelated);
        System.out.println(relOutOfSelfHouUserCon);
    }

    /**
     * @tag 获取单条合同信息, 例如合同详情生成权证流程的时候会调用
     * @author 邓永洪
     * @since 2018/6/14
     */
    @ApiOperation("获取单条合同信息")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = MgrDealListOneVo.class, message = "成功")
    })
    @PostMapping("/getMgrDealListOne")
    public ResponseJson getMgrDealListOne(@RequestBody MgrDealListOneParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        Integer dealId = param.getDealId();
        Integer dealType = param.getDealType();
        Integer userId = operator.getUserId();

        List<ErpFunDealDto> dealList = erpFunDealMapper.getDealListOne(cityId, compId, dealId);

        boolean firstAuditFlag = erpUserOpersService.judgePermission(cityId, userId, "DEAL_INITIAL_REVIEW");
        boolean repeatAuditFlag = erpUserOpersService.judgePermission(cityId, userId, "DEAL_REPEAT_REVIEW");

        for (ErpFunDeal deal : dealList) {
            if (!isShowPhone(deal.getDealAuditStatus(), firstAuditFlag, repeatAuditFlag)) {
                String phone = SyncUtil.getDecodePhone(deal.getSellOwnerPhone());
                deal.setSellOwnerPhone(phone);
                deal.setSellOwnerPhoneencode(phone);
                phone = SyncUtil.getDecodePhone(deal.getBuyCustomerPhone());
                deal.setBuyCustomerPhone(phone);
                deal.setBuyCustomerPhoneencode(phone);
            }
        }

        //出租需要额外获取委托租金单位
        if (Const.DIC_CASE_TYPE_RENT_DEAL.equals(dealType)) {
            Set<Integer> houseIds = dealList.stream().collect(Collectors.mapping(ErpFunDeal::getDealHouseId, Collectors.toSet()));
            if (houseIds != null && !houseIds.isEmpty()) {
                List<ErpFunLease> leases = erpFunLeaseMapper.getPriceUnitLease(cityId, compId, houseIds);
                LinkedHashMap<Integer, Byte> priceUnitMap = leases.stream().collect(Collectors.toMap(ErpFunLease::getLeaseId, ErpFunLease::getPriceUnit,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
                for (ErpFunDealDto dealMap : dealList) {
                    Byte housePriceUnit = priceUnitMap.get(dealMap.getDealHouseId());
                    if (housePriceUnit != null) {
                        dealMap.setHousePriceUnit(housePriceUnit);
                    }
                }
            }
        }

        // ERP端宽列表增加数据
        if (Byte.valueOf("1").equals(param.getIsWideList())) {
            if (!dealList.isEmpty()) {
                List<Integer> dealIdList = dealList.stream().collect(Collectors.mapping(ErpFunDealDto::getDealId, Collectors.toList()));
                List<Integer> archiveIdList = dealList.stream().collect(Collectors.mapping(ErpFunDealDto::getSignUserArchive, Collectors.toList()));
                Map<Integer, ErpFunSale> saleMap = new HashMap<Integer, ErpFunSale>();// 出售房源信息
                Map<Integer, ErpFunLease> leaseMap = new HashMap<Integer, ErpFunLease>();// 出租房源信息
                Map<Integer, List<RuntimeStepVO>> runtimeStepVOMap = new HashMap<Integer, List<RuntimeStepVO>>();// 出售的权证流程信息
                Map<Integer, AdminFunArchive> archiveMap = new HashMap<Integer, AdminFunArchive>();// 经纪人的头像信息

                // 查询经纪人的头像信息
                if (!archiveIdList.isEmpty()) {
                    List<AdminFunArchive> adminFunArchiveList = adminFunArchiveMapper.selectUserPhoto(archiveIdList);
                    archiveMap = adminFunArchiveList.stream().collect(Collectors.toMap(AdminFunArchive::getArchiveId, val -> val, (oldVal, newVal) -> oldVal));
                }

                if (Integer.valueOf(101).equals(dealType)) {
                    List<Integer> saleIdList = dealList.stream().collect(Collectors.mapping(ErpFunDealDto::getDealHouseId, Collectors.toList()));
                    if (!saleIdList.isEmpty()) {
                        String[] queryColumn = new String[]{"SALE_ID", "SALE_ROOF_T", "SALE_UNIT_T", "SALE_NUM_T", "SALE_ROOM"};
                        List<ErpFunSale> erpFunSaleList = erpFunSaleMapper.selectSaleListByIds(cityId, saleIdList.toArray(new Integer[]{}), queryColumn, getOperator().getCompId());
                        saleMap = erpFunSaleList.stream().collect(Collectors.toMap(ErpFunSale::getSaleId, val -> val, (oldVal, newVal) -> oldVal));
                    }
                } else if (Integer.valueOf(102).equals(dealType)) {
                    List<Integer> leaseIdList = dealList.stream().collect(Collectors.mapping(ErpFunDealDto::getDealHouseId, Collectors.toList()));
                    if (!leaseIdList.isEmpty()) {
                        String[] queryColumn = new String[]{"LEASE_ID", "LEASE_ROOF_T", "LEASE_UNIT_T", "LEASE_NUM_T", "LEASE_ROOM"};
                        List<ErpFunLease> erpFunLeaseList = erpFunLeaseMapper.selectLeaseListByIds(cityId, leaseIdList.toArray(new Integer[]{}), queryColumn, getOperator().getCompId());
                        leaseMap = erpFunLeaseList.stream().collect(Collectors.toMap(ErpFunLease::getLeaseId, val -> val, (oldVal, newVal) -> oldVal));
                    }
                }

                // 权证流程步骤
                if (Integer.valueOf(101).equals(dealType)) {
                    List<RuntimeStepVO> runtimeStepVOList = erpProcessRuntimeStepMapper.getRuntimeStepListByDealIds(cityId, getOperator().getCompId(), dealIdList);
                    runtimeStepVOMap = runtimeStepVOList.stream().collect(Collectors.groupingBy(RuntimeStepVO::getDealId));
                }

                // 应收实收列表
                List<ErpProcessFinanc> processFinancList = erpProcessFinancMapper.getProcessFinancByDealIds(cityId, getOperator().getCompId(), dealIdList);

                for (ErpFunDealDto deal : dealList) {
                    Integer dealIdTmp = deal.getDealId();
                    Integer houseId = deal.getDealHouseId();
                    Integer signUserArchive = deal.getSignUserArchive();
                    if (Integer.valueOf(101).equals(dealType) && null != saleMap) {
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
                    } else if (Integer.valueOf(102).equals(dealType) && null != leaseMap) {
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
                    if (null != runtimeStepVOMap) {
                        List<RuntimeStepVO> runtimeStepList = runtimeStepVOMap.get(dealIdTmp);
                        if (null != runtimeStepList) {
                            deal.setRuntimeStepVOList(runtimeStepList);
                        }
                    }
                    if (null != signUserArchive && null != archiveMap) {
                        AdminFunArchive adminFunArchive = archiveMap.get(signUserArchive);
                        if (null != adminFunArchive && null != adminFunArchive.getUserPhoto()) {
                            deal.setSignUserPhoto(AppConfig.getUserPhotoPicDomainPath(adminFunArchive.getUserPhoto()));
                        }
                    }

                    // 业主应收
                    BigDecimal ownerReceivable = processFinancList.stream().filter(val -> (dealIdTmp.equals(val.getDealId()) && Byte.valueOf("0").equals(val.getPfActual()) && "2".equals(val.getPfPayer()))).map(ErpProcessFinanc::getPayAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
                    deal.setOwnerReceivable(ownerReceivable);
                    // 业主实收
                    BigDecimal ownerActualReceiptCapital = processFinancList.stream().filter(val -> (dealIdTmp.equals(val.getDealId()) && Byte.valueOf("1").equals(val.getPfActual()) && "2".equals(val.getPfPayer()))).map(ErpProcessFinanc::getPayAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
                    deal.setOwnerActualReceiptCapital(ownerActualReceiptCapital);
                    // 客户应收
                    BigDecimal custReceivable = processFinancList.stream().filter(val -> (dealIdTmp.equals(val.getDealId()) && Byte.valueOf("0").equals(val.getPfActual()) && "1".equals(val.getPfPayer()))).map(ErpProcessFinanc::getPayAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
                    deal.setCustReceivable(custReceivable);
                    // 客户实收
                    BigDecimal custActualReceiptCapital = processFinancList.stream().filter(val -> (dealIdTmp.equals(val.getDealId()) && Byte.valueOf("1").equals(val.getPfActual()) && "1".equals(val.getPfPayer()))).map(ErpProcessFinanc::getPayAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
                    deal.setCustActualReceiptCapital(custActualReceiptCapital);
                }
            }
        }
        MgrDealListOneVo resultVo = new MgrDealListOneVo();
        resultVo.setList(dealList);
        return ErpResponseJson.ok(resultVo);
    }

    /**
     * @tag 审核合同初审, 复审, 作废
     * @author 邓永洪
     * @since 2018/6/14
     */
    @ApiOperation("审核合同初审,复审,作废统一接口")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/updateMgrDealAduitStatus")
    public ResponseJson updateMgrDealAduitStatus(@RequestBody UpdateDealAuditStatusParam param, HttpServletRequest request) throws Exception {
        Operator operator = getOperator();
        GeneralParam generalParam = new GeneralParam(operator);
        generalParam.setCurrDeptUserName(getCurrentUserName());
        DealAuditCommonVO dealAuditCommonVO = new DealAuditCommonVO();
        // 创建审核，抽象一个合同审核通用的审核类
        DealAuditCommonParam erpAuditRuntime = new DealAuditCommonParam();
        erpAuditRuntime.setUpdateDealAuditStatusParam(param);
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
            commonParam.setAuditType(erpAuditRuntime.getAuditType());

            String currentDeptUserName = this.getCurrentUserName();
            generalParam.setCurrDeptUserName(currentDeptUserName);
            commonParam.setGeneralParam(generalParam);
            commonParam.setUpdateDealAuditStatusParam(param);
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

        // 这个接口只有合同作废 (auditType 4=作废)
        if ((1 == result || 2 == result) && erpAuditRuntime.getAuditType() == 4) {
            // 无需审核时发送微信模板消息和短信
            erpFunContractService.sendMsg(operator.getCityId(), param.getDealId(), erpAuditRuntime.getAuditType());
        }

        return ErpResponseJson.ok(dealAuditCommonVO);
    }


    /**
     * @tag 合同反审核
     * @author 邓永洪
     * @since 2018/7/12
     */
    @ApiOperation("合同反审核")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = DealAuditCommonVO.class, message = "成功")
    })
    @PostMapping("/updateMgrDealAduitStatusByCounter")
    public ResponseJson updateMgrDealAduitStatusByCounter(@RequestBody UpdateDealAuditStatusParam param, HttpServletRequest request) throws Exception {
        Operator operator = getOperator();
        GeneralParam generalParam = new GeneralParam(getOperator());
        String currentDeptUserName = this.getCurrentUserName();
        generalParam.setCurrDeptUserName(currentDeptUserName);
        DealAuditCommonVO dealAuditCommonVO = new DealAuditCommonVO();
        // 创建审核，抽象一个合同审核通用的审核类
        DealAuditCommonParam erpAuditRuntime = new DealAuditCommonParam();
        erpAuditRuntime.setUpdateDealAuditStatusParam(param);
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
            commonParam.setAuditType(erpAuditRuntime.getAuditType());
            commonParam.setGeneralParam(generalParam);
            commonParam.setUpdateDealAuditStatusParam(param);
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

//		erpFunDealService.updateMgrDealAduitStatusByCounter(param, oldModel, model, generalParam, taskUserList);

        // (auditType 5=撤销初审)
        if ((1 == result || 2 == result) && erpAuditRuntime.getAuditType() == 5) {
            // 无需审核时发送微信模板消息和短信
            erpFunContractService.sendMsg(getOperator().getCityId(), param.getDealId(), erpAuditRuntime.getAuditType());
        }

        return ErpResponseJson.ok(dealAuditCommonVO);
    }

    /**
     * @tag 修改优家的合同审核状态
     * @author 邓永洪
     * @since 2018/7/13
     */
    @ApiOperation("修改优家的合同审核状态")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/updateYouJiaDealAduitStatus")
    public ResponseJson updateYouJiaDealAduitStatus(@RequestBody YouJiaDealAduitStatusParam param) throws Exception {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer dealId = param.getDealId();
        Byte contentType = param.getContentType();
        ErpFunDeal oldModel = erpFunDealMapper.getFunDealById(cityId, operator.getCompId(), dealId);
        String trackContent = getCurrentUserName();
        String fileName = "合同";
        String updateClassic = Const.DIC_DEAL_UPDATE_CLASSIC_ADUIT;
        if (contentType != null && Constants_DIC.DIC_FUN_DEAL_FILE_TYPE_2.equals(contentType.intValue())) {
            fileName = "协议";
            updateClassic = Constants_DIC.DIC_DEAL_UPDATE_CLASSIC_ADUIT2;
        }

        String taskSubJect = Const.DIC_TASK_TYPE_AUTHORITY_REMIND_STR + " " + trackContent + " 将编号" + oldModel.getContractNo()
                + "的" + fileName + "提交内部审核";
        trackContent += " 将该" + fileName + "提交内部审核";
        if (null == oldModel.getContractId()) {
            throw new BusinessException("请填写" + fileName + "文本后再提交内部审核！");
        }
        ErpFunDealPhotoExample dealPhotoExample = new ErpFunDealPhotoExample();
        dealPhotoExample.setShardCityId(cityId);
        dealPhotoExample.createCriteria().andCompIdEqualTo(operator.getCompId()).
                andDealIdEqualTo(dealId).andTransmitFlagEqualTo((byte) 0).andPhotoTypeEqualTo((byte) 0);
        int count = erpFunDealPhotoMapper.countByExample(dealPhotoExample);
        // 未上传客户证件：“请上传客户证件后再提交律师审核！”
        if (count == 0) {
            throw new BusinessException("请上传客户证件后再提交律师审核！");
        }
        dealPhotoExample.clear();
        dealPhotoExample.createCriteria().andCompIdEqualTo(operator.getCompId()).
                andDealIdEqualTo(dealId).andTransmitFlagEqualTo((byte) 0).andPhotoTypeEqualTo((byte) 1);
        count = erpFunDealPhotoMapper.countByExample(dealPhotoExample);
        if (count == 0) {
            throw new BusinessException("请上传业主证件后再提交内部审核！");
        }

        GeneralParam generalParam = new GeneralParam(operator);
        erpFunDealService.updateYouJiaDealAduitStatus(oldModel, generalParam, dealId, contentType, taskSubJect, updateClassic, trackContent);

        Set<String> userMobiles = new HashSet<>();
        ErpFunDepts funDepts = new ErpFunDepts();
        funDepts.setShardCityId(cityId);
        funDepts.setDeptId(oldModel.getDeptId());
        funDepts = erpFunDeptsMapper.selectByPrimaryKey(funDepts);
        if (funDepts == null) {
            return ErpResponseJson.ok();
        }
        List<AdminWeiUserInfo> youConnectorList = adminFunDeptsService.getYouConnectorList(funDepts.getCompNo(), funDepts.getDeptNo());
        if (youConnectorList.size() > 0) {
            AdminWeiUserInfo adminWeiUserInfo = youConnectorList.get(0);
            userMobiles.add(adminWeiUserInfo.getUserMobile());
            adminMobileKeyService.sendSmsForYouJiaDealStatusChange(userMobiles, Const.DIC_YOU_ADUIT_STATUS_SEVEN_INSTANCE, "",
                    oldModel.getSignUserDeptName(), oldModel.getContractNo(), fileName);
            // 微信推送
            Object crmCompId = getOperator().getAttribute("CRM_COMP_ID");
            if (StringUtils.isNotBlank(adminWeiUserInfo.getWeixinOpenId()) && null == crmCompId) {
                String action = "noticeLawyer";
                String typeStr = Const.DIC_CASE_TYPE_SALE_DEAL.byteValue() == oldModel.getDealType() ? "出售合同"
                        : "出租合同";
                String paramOne = "您有一个" + fileName + "需要审核,点击立即处理";
                Map<String, Object> bMap = new HashMap<>();
                bMap.put("action", action); // 取模板ID
                bMap.put("paramOne", paramOne); // 标题
                bMap.put("paramTwo", oldModel.getContractNo()); // 编号
                bMap.put("paramThree", typeStr); // 类别
                bMap.put("paramFour", oldModel.getSignUserDeptName()); // 签约门店
                bMap.put("paramFive", DateTimeHelper.getTimeNow()); // 签约人员
                bMap.put("paramSix", "等待内审"); // 审核状态
                bMap.put("remark", "请及时处理!"); // remark
                bMap.put("openIds", adminWeiUserInfo.getWeixinOpenId());
                String path = "information";
                if (null != contentType && Const.DIC_FUN_DEAL_FILE_TYPE_2 == contentType) {
                    path = "sideAgreement";
                }
                String href = "http://youjia.haofang.net/Home/Contract/" + path + ".html?deal_id="
                        + oldModel.getDealId();
                bMap.put("href", URLEncoder.encode(href, "UTF-8"));


                YouJiaWxPushMessage youJiaWxPushMessage = new YouJiaWxPushMessage();
                youJiaWxPushMessage.setAction(action);
                youJiaWxPushMessage.setParamOne(paramOne);
                youJiaWxPushMessage.setParamTwo(oldModel.getContractNo());
                youJiaWxPushMessage.setParamThree(typeStr);
                youJiaWxPushMessage.setParamFour(oldModel.getSignUserDeptName());
                youJiaWxPushMessage.setParamFive(DateUtil.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
                youJiaWxPushMessage.setParamSix("等待内审");
                youJiaWxPushMessage.setRemark("请及时处理!");
                youJiaWxPushMessage.setOpenIds(adminWeiUserInfo.getWeixinOpenId());
                youJiaWxPushMessage.setHrefhref(URLEncoder.encode(href, "UTF-8"));
                youJiaWxPushMessage.setDealId(dealId);
                youJiaWxPushMessage.setCityId(cityId);

                YoujiaWXPushUtil.getInstance().sendMessage(youJiaWxPushMessage);
            }
        }
        return ErpResponseJson.ok();
    }

    /**
     * @tag 更新业主或者客户信息
     * @author 邓永洪
     * @since 2018/7/19
     */
    @ApiOperation("更新业主或者客户信息")
    @RequestMapping("/updateHouseOrCustInfo")
    @ApiResponses({
            @ApiResponse(code = 200, message = "")
    })
    public ResponseJson updateHouseOrCustInfo(@RequestBody UpdateHouseOrCustInfoParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        boolean flag = false;
        Integer dealId = param.getDealId();
        Integer updateFlag = param.getUpdateFlag();
        Integer dealHouseId = param.getDealHouseId();
        Integer dealCustomerId = param.getDealCustomerId();
        byte dealType = param.getDealType();
        ErpFunDeal model = new ErpFunDeal();
        if (null == dealId) {
            throw new BusinessException("参数DEAL_ID未传，请检查！");
        }
        ErpFunDeal funDeal = erpFunDealMapper.getBaseDealInfo(cityId, dealId);
        if (updateFlag == 0 && dealHouseId != null) {
            if (101 == dealType) {
                ErpFunSale funSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, dealHouseId);
                if (funSale == null) {
                    ErpFunSaleToLease saleToLease = erpFunSaleToLeaseMapper.getFunSaleToLeaseById(cityId, dealHouseId);
                    if (saleToLease != null) throw new BusinessException("该出售房源已被转为出租，编号：" + saleToLease.getLeaseNo());
                } else {
                    if (!"&&&".equals(funSale.getCellPhone())) {
                        flag = true;
                        String phone = SyncUtil.decodePhoneForHouseDetailOfFirst(funSale.getCellPhone(), false);
                        model.setSellOwnerPhoneencode(phone);
                        model.setSellOwnerPhone(phone);
                    }
                }
            } else {
                ErpFunLease funLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, dealHouseId);
                if (funLease == null) {
                    ErpFunLeaseToSale leaseToSale = erpFunLeaseToSaleMapper.getFunLeaseToSaleById(cityId, dealHouseId);
                    if (leaseToSale != null) throw new BusinessException("该出租房源已被转为出售，编号：" + leaseToSale.getSaleNo());
                } else {
                    if (!"&&&".equals(funLease.getCellPhone())) {
                        flag = true;
                        String phone = SyncUtil.decodePhoneForHouseDetailOfFirst(funLease.getCellPhone(), false);
                        model.setSellOwnerPhoneencode(phone);
                        model.setSellOwnerPhone(phone);
                    }
                }
            }
        } else if (updateFlag == 1 && dealCustomerId != null) {
            if (101 == dealType) {
                ErpFunBuyCustomer buyCustomer = erpFunBuyCustomerMapper.getFunBuyCustomer(cityId, dealCustomerId);
                if (!"&&&".equals(buyCustomer.getCellPhone())) {
                    flag = true;
                    String phone = SyncUtil.decodePhoneForHouseDetailOfFirst(buyCustomer.getCellPhone(), false);
                    model.setBuyCustomerPhoneencode(phone);
                    model.setBuyCustomerPhone(phone);
                } else {
                    ErpFunRentCustomer rentCustomer = erpFunRentCustomerMapper.getRentCustomerByCustId(cityId, dealCustomerId);
                    if (!"&&&".equals(rentCustomer.getCellPhone())) {
                        flag = true;
                        String phone = SyncUtil.decodePhoneForHouseDetailOfFirst(rentCustomer.getCellPhone(), false);
                        model.setBuyCustomerPhoneencode(phone);
                        model.setBuyCustomerPhone(phone);
                    }
                }
            }
        }
        if (flag) {
            model.setDealId(dealId);
            model.setShardCityId(cityId);
            erpFunDealMapper.updateByPrimaryKeySelective(model);
        }
        boolean firstAuditFlag = erpUserOpersService.judgePermission(cityId, operator.getUserId(), "DEAL_INITIAL_REVIEW");
        boolean repeatAuditFlag = erpUserOpersService.judgePermission(cityId, operator.getUserId(), "DEAL_REPEAT_REVIEW");
        if (!isShowPhone(funDeal.getDealAuditStatus(), firstAuditFlag, repeatAuditFlag)) {
            String phone = SyncUtil.getDecodePhone(model.getSellOwnerPhoneencode());
            model.setSellOwnerPhone(phone);
            phone = SyncUtil.getDecodePhone(model.getBuyCustomerPhoneencode());
            model.setBuyCustomerPhone(phone);
        } else {
            model.setSellOwnerPhone(model.getSellOwnerPhone());
            model.setBuyCustomerPhone(model.getBuyCustomerPhone());
        }
        model.setBuyCustomerPhoneencode(null);
        model.setSellOwnerPhoneencode(null);
        ErpFunDealTaxesRecordExample dealTaxesRecordExample = new ErpFunDealTaxesRecordExample();
        dealTaxesRecordExample.setShardCityId(cityId);
        ErpFunDealTaxesRecordExample.Criteria criteria = dealTaxesRecordExample.createCriteria();
        criteria.andDealIdEqualTo(dealId).andCompIdEqualTo(operator.getCompId());
        if (updateFlag == 0) {// 业主 卖方
            criteria.andFeeTypeEqualTo((byte) 1);
        } else if (updateFlag == 1) { // 客户 买方
            criteria.andFeeTypeEqualTo((byte) 0);
        }
        // 出售合同才有税费单
        if (101 == dealType) {
            List<ErpFunDealTaxesRecord> dealTaxesRecords = erpFunDealTaxesRecordMapper.selectByExample(dealTaxesRecordExample);
            ErpFunDealTaxesRecord dealTaxesRecord = null;
            if (dealTaxesRecords != null && dealTaxesRecords.size() > 0) dealTaxesRecord = dealTaxesRecords.get(0);
            if (dealTaxesRecord != null) {
                if (updateFlag == 0 && StringUtils.isNotBlank(model.getSellOwnerPhone())) { // 业主
                    // 卖方
                    dealTaxesRecord.setCallPhone(model.getSellOwnerPhone().trim());
                    // 客户
                } else if (updateFlag != null && updateFlag == 1 && StringUtils.isNotBlank(model.getBuyCustomerPhone())) {
                    // 买方
                    dealTaxesRecord.setCallPhone(model.getBuyCustomerPhone().trim());
                }
                dealTaxesRecord.setTaxesRecordId(null);
                erpFunDealTaxesRecordMapper.updateByExampleSelective(dealTaxesRecord, dealTaxesRecordExample);
                // 税费更新日志 税费日志类型为更新日志
                String trackContent = null;
                if (0 == updateFlag) {// 业主 卖方
                    trackContent = getCurrentUserName() + " 更新了卖方税费电话";
                    erpFunDealRecordService.writeDealRecord(new GeneralParam(operator), dealId, null,
                            Const.DIC_DEAL_UPDATE_CLASSIC_TAXESUPDATE, (byte) 5, trackContent, 1, null, true, "1");
                }
                if (1 == updateFlag) {// 客户 买方
                    trackContent = getCurrentUserName() + " 更新了买方税费电话";
                    erpFunDealRecordService.writeDealRecord(new GeneralParam(operator), dealId, null,
                            Const.DIC_DEAL_UPDATE_CLASSIC_TAXESUPDATE, (byte) 4, trackContent, 1, null, true, "0");
                }
            }
        }
        return ErpResponseJson.ok(model);
    }

    /**
     * @tag 获取合同记录详细
     * @author 邓永洪
     * @since 2018/7/19
     */
    @ApiOperation("获取合同记录详细")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = DealNoteDataDto.class, message = "成功")
    })
    @PostMapping("/getMgrDealNoteData")
    public ResponseJson getMgrDealNoteData(@RequestBody DealNoteDataParam param) {
        Operator operator = getOperator();
        Integer dealId = param.getDealId();
        Integer recordId = param.getRecordId();
        Map<String, Object> retMap = new HashMap<>();
        ErpFunDealRecordExample dealRecordExample = new ErpFunDealRecordExample();
        dealRecordExample.setShardCityId(operator.getCityId());
        dealRecordExample.createCriteria().andAgreementNoEqualTo(dealId.toString()).andRecordIdEqualTo(recordId).andCompIdEqualTo(operator.getCompId());
        List<ErpFunDealRecord> erpFunDealRecords = erpFunDealRecordMapper.selectByExampleWithBLOBs(dealRecordExample);
        if (erpFunDealRecords == null || erpFunDealRecords.isEmpty()) {
            return ErpResponseJson.ok();
        }
        ErpFunDealRecord erpFunDealRecord = erpFunDealRecords.get(0);
        String updateContent = erpFunDealRecord.getUpdateContent();
        Byte updateType = erpFunDealRecord.getUpdateType();
        if (StringUtils.isNotBlank(updateContent)) {
            JSONObject jsonMap = JSON.parseObject(updateContent);
            switch (updateType) {
                case 1:
                    retMap.put("updateType", updateType);
                    retMap.put("newVal", jsonMap.get("PROCESS_FINANC"));
                    retMap.put("newFianacId", jsonMap.get("FIANAC_ID"));
                    break;
                case 2:
                    retMap.put("updateType", updateType);
                    retMap.put("newVal", jsonMap.get("FUN_PROFIT"));
                    break;
                case 4:
                    retMap.put("updateType", updateType);
                    retMap.put("newVal", jsonMap.get("FUN_TAXES_RECORD"));
                    retMap.put("newTaxesVal", jsonMap.get("FUN_TAXES"));
                    break;
                case 5:
                    retMap.put("updateType", updateType);
                    retMap.put("newVal", jsonMap.get("FUN_TAXES_RECORD"));
                    retMap.put("newTaxesVal", jsonMap.get("FUN_TAXES"));
                    break;
                default:
                    Object funDealObj = jsonMap.get("FUN_DEAL");
                    if (funDealObj instanceof String) {
                        funDealObj = JSON.parse((String) funDealObj);
                    }
                    retMap.put("updateType", updateType);
                    retMap.put("newVal", funDealObj);
            }
            Integer frontRecordId = erpFunDealRecord.getFrontRecordId();
            if (frontRecordId == null) {
                return ErpResponseJson.ok(retMap);
            }
            ErpFunDealRecordExample erpFunDealRecordExample = new ErpFunDealRecordExample();
            erpFunDealRecordExample.setShardCityId(operator.getCityId());
            erpFunDealRecordExample.createCriteria().andAgreementNoEqualTo(dealId.toString()).andRecordIdEqualTo(frontRecordId).andCompIdEqualTo(operator.getCompId());
            List<ErpFunDealRecord> funDealRecords = erpFunDealRecordMapper.selectByExampleWithBLOBs(erpFunDealRecordExample);
            if (funDealRecords == null || funDealRecords.isEmpty()) {
                return ErpResponseJson.ok(retMap);
            }
            ErpFunDealRecord funDealRecord = funDealRecords.get(0);
            updateContent = funDealRecord.getUpdateContent();
            if (StringUtils.isBlank(updateContent)) {
                return ErpResponseJson.ok(retMap);
            }
            jsonMap = JSON.parseObject(updateContent);
            if (1 == updateType) {
                retMap.put("oldVal", jsonMap.get("PROCESS_FINANC"));
                retMap.put("oldFianacId", jsonMap.get("FIANAC_ID"));
            } else if (2 == updateType) {
                retMap.put("oldVal", jsonMap.get("FUN_PROFIT"));
            } else if (4 == updateType || 5 == updateType) {
                retMap.put("updateType", updateType);
                retMap.put("oldVal", jsonMap.get("FUN_TAXES_RECORD"));
                retMap.put("oldTaxesVal", jsonMap.get("FUN_TAXES"));
            } else {
                Object funDealObj = jsonMap.get("FUN_DEAL");
                if (funDealObj instanceof String) {
                    funDealObj = JSON.parse((String) funDealObj);
                }
                retMap.put("oldVal", funDealObj);
            }
        }
        return ErpResponseJson.ok(retMap);
    }


    /**
     * 判断是否是有电话展示权限
     *
     * @param dealAuditStatus
     * @return
     * @throws Exception
     */
    private boolean isShowPhone(Byte dealAuditStatus, boolean firstAuditFlag, boolean repeatAuditFlag) {
        if (firstAuditFlag || repeatAuditFlag) {
            return true;
        }
        if (Const.DIC_DEAL_FIRSTCOMPLETE_OK.equals(dealAuditStatus)) {
            return true;
        } else if (Const.DIC_DEAL_REPEATCOMPLETE_OK.equals(dealAuditStatus)) {
            return true;
        }
        return false;
    }

    private void copyPhoto(Integer dealId, InsertDealInfoParam param) {
        String custDataAttachment = param.getCustDataAttachment();
        String ownerDataAttachment = param.getOwnerDataAttachment();
        String otherDataAttachment = param.getOtherDataAttachment();
        // 判断是否有图片
        if (BeanUtil.allIsNullBuilder(custDataAttachment, ownerDataAttachment, otherDataAttachment)) {
            return;
        }
        List<ErpFunDealPhoto> dealPhotos = new ArrayList<>();
        ErpFunDealPhoto tempDealPhoto;
        if (StringUtils.isNotBlank(custDataAttachment)) {
            String photoArr[] = custDataAttachment.split(";");
            for (int i = 0; i < photoArr.length; i++) {
                tempDealPhoto = new ErpFunDealPhoto();
                try {
                    tempDealPhoto.setDealId(dealId);
                    String photoPath = photoArr[i];
                    tempDealPhoto.setPhotoAddr(photoPath);
                    tempDealPhoto.setUploadUser(getOperator().getUserId());
                    tempDealPhoto.setTransmitFlag((byte) 0);
                    tempDealPhoto.setUseageType((byte) 1);
                    tempDealPhoto.setUploadDate(new Date());
                    tempDealPhoto.setPhotoType((byte) 0);
                    tempDealPhoto.setCompId(this.getOperator().getCompId());
                    dealPhotos.add(tempDealPhoto);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (StringUtils.isNotBlank(ownerDataAttachment)) {
            String photoArr[] = ownerDataAttachment.split(";");
            for (int i = 0; i < photoArr.length; i++) {
                tempDealPhoto = new ErpFunDealPhoto();
                try {
                    tempDealPhoto.setDealId(dealId);
                    String photoPath = photoArr[i];
                    tempDealPhoto.setPhotoAddr(photoPath);
                    tempDealPhoto.setUploadUser(getOperator().getUserId());
                    tempDealPhoto.setTransmitFlag((byte) 0);
                    tempDealPhoto.setUseageType((byte) 1);
                    tempDealPhoto.setUploadDate(new Date());
                    tempDealPhoto.setPhotoType((byte) 1);
                    tempDealPhoto.setCompId(getOperator().getCompId());
                    dealPhotos.add(tempDealPhoto);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (StringUtils.isNotBlank(otherDataAttachment)) {
            String photoArr[] = otherDataAttachment.split(";");
            for (int i = 0; i < photoArr.length; i++) {
                tempDealPhoto = new ErpFunDealPhoto();
                try {
                    tempDealPhoto.setDealId(dealId);
                    String photoPath = photoArr[i];
                    tempDealPhoto.setPhotoAddr(photoPath);
                    tempDealPhoto.setUploadUser(getOperator().getUserId());
                    tempDealPhoto.setTransmitFlag((byte) 0);
                    tempDealPhoto.setUseageType((byte) 1);
                    tempDealPhoto.setUploadDate(new Date());
                    tempDealPhoto.setPhotoType((byte) 2);
                    tempDealPhoto.setCompId(getOperator().getCompId());
                    dealPhotos.add(tempDealPhoto);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        if (!dealPhotos.isEmpty()) {
            dealPhotos.stream().forEach(dealPhoto -> {
                dealPhoto.setShardCityId(param.getCityId());
                erpFunDealPhotoMapper.insertSelective(dealPhoto);
            });
        }
    }

    /**
     * @param
     * @return
     * @title 创建合同
     * @author lcb
     * @date 2019/5/27
     */
    private Integer insetDealInfo(InsertDealInfoParam param) throws Exception {
        Operator operator = getOperator();
        param.setFangJidi(operator.isFangJidi());
        GeneralParam generalParam = new GeneralParam(operator);
        Integer cityId = param.getCityId();
        String trackContent = param.getTrackContent();
        ErpFunDeal funDeal = param;
        if (StringUtils.isBlank(funDeal.getEvidenceDate())) {
            funDeal.setEvidenceDate(null);
        }
        if (StringUtils.isBlank(funDeal.getTransferDate())) {
            funDeal.setTransferDate(null);
        }
        if (getOperator().isYouJiaUser()) {
            funDeal.setYouDealFlag((byte) 1);
        }
        if (funDeal.getBuildRegId() != null) {
            ErpFunRegExample funRegExample = new ErpFunRegExample();
            funRegExample.setShardCityId(cityId);
            funRegExample.createCriteria().andCityIdEqualTo(cityId.shortValue()).andRegIdEqualTo(funDeal.getBuildRegId());
            ErpFunReg funReg = erpFunRegMapper.selectByExample(funRegExample).get(0);
            if (funReg != null) {
                funDeal.setBuildRegName(funReg.getRegName());
            }
        }

        funDeal.setDealStatus((byte) 0);
        createConstarctNoForYouJia(funDeal);// 为优家需要律师审核的合同生成自动编号，必须在判重之前调用
        Integer repeatFlag = isRepeatConstarctNo(funDeal, cityId)[0];
        if (repeatFlag == 1) {
            throw new BusinessException("该号段与已分配编码有重复，请重新分配");
        }
        if (repeatFlag == 2) {
            throw new BusinessException("不可手动录入未使用的自动分配的合同编号");
        }
        // 不填写签约地址的话,将会直接把SELL_ADDRESS写到HOUSEADDRESSi
        if (funDeal.getSellAddress() == null) {
            funDeal.setSellAddress(funDeal.getHouseaddress());
        }
        // 合同创建人信息
        funDeal.setIsbyhand((byte) 0);
        funDeal.setCreatorUid(operator.getUserId());
        funDeal.setCreatorName(operator.getUserName());
        funDeal.setDealId(operator.getDeptId());
        funDeal.setRegId(operator.getRegId());
        funDeal.setDeptId(operator.getDeptId());
        funDeal.setCompId(operator.getCompId());
        funDeal.setAreaId(operator.getAreaId());
        Integer signUser = funDeal.getSignUserId();
        Integer signManageUser = funDeal.getSignManagerId();

        // 签约人
        if (signUser != null) {
            ErpFunUsers funUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, signUser);
            funDeal.setSignUserArchive(funUsers.getArchiveId());
            funDeal.setSignUserName(funUsers.getUserName());
            if (operator.newOrganizationType()) {
                ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, funUsers.getCompId(), funUsers.getOrganizationId());
                funDeal.setSignUserDeptId(erpFunOrganization.getOrganizationId());
                funDeal.setSignUserDeptName(erpFunOrganization.getOrganizationName());
            } else {
                ErpFunDepts funDepts = erpFunDeptsMapper.getByDeptId(cityId, funUsers.getDeptId());
                funDeal.setSignUserDeptId(funDepts.getDeptId());
                funDeal.setSignUserDeptName(funDepts.getDeptName());
            }
        }
        if (signManageUser != null) {
            ErpFunUsers funUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, signManageUser);
            funDeal.setSignManagerName(funUsers.getUserName());
            if (operator.newOrganizationType()) {
                ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, funUsers.getCompId(), funUsers.getOrganizationId());
                funDeal.setSignManagerDeptId(erpFunOrganization.getOrganizationId());
                funDeal.setSignManagerDeptName(erpFunOrganization.getOrganizationName());
            } else {
                ErpFunDepts funDepts = erpFunDeptsMapper.getByDeptId(cityId, funUsers.getDeptId());
                funDeal.setSignManagerDeptName(funDepts.getDeptName());
                funDeal.setSignManagerDeptId(funDepts.getDeptId());
            }
        }
        funDeal.setCreatorDate(funDeal.getSignDate());
        funDeal.setSystemRecordTime(DateTimeHelper.getTimeNow());
        funDeal.setUpdateTime(new Date());
        funDeal.setDealAuditStatus(Const.DIC_DEAL_COMPLETE_INIT);
        funDeal.setProcessStatus(Const.DIC_DEAL_STATUS_NODO);
        Integer dealId = erpFunDealMapper.selectSeqDealId(cityId);
        funDeal.setDealId(dealId);
        byte dealType = funDeal.getDealType();// 当前提交的合同类型
        String dealTypeTmp = "S";
        if (dealType == Const.DIC_CASE_TYPE_SALE_DEAL.byteValue()) {
            dealTypeTmp = "S";
        } else if (dealType == Const.DIC_CASE_TYPE_RENT_DEAL.byteValue()) {
            dealTypeTmp = "R";
        }
        // 合同的系统编号
        String dealNo = dealTypeTmp + dealId
                + DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyMMdd");
        funDeal.setAgreementNo(dealNo);
        // 创建合同
        Integer customerId = funDeal.getDealCustomerId();
        Integer houseId = funDeal.getDealHouseId();
        if (customerId != null) {

            // 判断前端传入修改后的号码
            if (StringUtils.isNotBlank(param.getBuyCustomerPhone()) && !param.getBuyCustomerPhone().contains("*")) {
                funDeal.setBuyCustomerPhone(param.getBuyCustomerPhone());
                funDeal.setBuyCustomerPhoneencode(param.getBuyCustomerPhone());
            } else {
                if (dealType == 101) {
                    ErpFunBuyCustomer funBuyCustomer = erpFunBuyCustomerMapper.getFunBuyCustomer(cityId, customerId);
                    if (!"&&&".equals(funBuyCustomer.getCellPhone())) {
                        String phone = SyncUtil.decodePhoneForHouseDetailOfFirst(funBuyCustomer.getCellPhone(), false);
                        funDeal.setBuyCustomerPhone(phone);
                        funDeal.setBuyCustomerPhoneencode(phone);
                    }
                } else {
                    ErpFunRentCustomer funRentCustomer = erpFunRentCustomerMapper.getRentCustomerByCustId(cityId, customerId);
                    if (!"&&&".equals(funRentCustomer.getCellPhone())) {
                        String phone = SyncUtil.decodePhoneForHouseDetailOfFirst(funRentCustomer.getCellPhone(), false);
                        funDeal.setBuyCustomerPhone(phone);
                        funDeal.setBuyCustomerPhoneencode(phone);
                    }
                }
            }

        } else {
            funDeal.setBuyCustomerPhoneencode(funDeal.getBuyCustomerPhone());
        }

        Integer oldStatus = null;

        if (houseId != null) {
            // 判断前端传入修改后的号码
            if (StringUtils.isNotBlank(param.getSellOwnerPhone()) && !param.getSellOwnerPhone().contains("*")) {
                funDeal.setSellOwnerPhoneencode(param.getSellOwnerPhone());
                funDeal.setSellOwnerPhone(param.getSellOwnerPhone());
            } else {
                if (dealType == 101) {
                    ErpFunSale funSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, houseId);
                    if (funSale == null) {
                        ErpFunSaleToLease funSaleToLease = erpFunSaleToLeaseMapper.getFunSaleToLeaseById(cityId, houseId);
                        if (funSaleToLease != null) {
                            throw new BusinessException("该出售房源已被转为出租，编号：" + funSaleToLease.getLeaseNo());
                        }
                    } else {
                        funDeal.setSectionId(funSale.getSectionId());
                        if (!"&&&".equals(funSale.getCellPhone())) {
                            String phone = SyncUtil.decodePhoneForHouseDetailOfFirst(funSale.getCellPhone(), false);
                            funDeal.setSellOwnerPhoneencode(phone);
                            funDeal.setSellOwnerPhone(phone);
                        }
                        if (StringUtils.isBlank(funDeal.getSellOwnerPhoneBak())) {
                            if (!"&&&".equals(funSale.getJointCellPhone())) {
                                String phone = SyncUtil.decodePhoneForHouseDetailOfFirst(funSale.getJointCellPhone(), false);
                                funDeal.setSellOwnerPhoneBak(phone);
                            }
                        }

                        oldStatus = funSale.getSaleStatus().intValue();
                    }
                } else {
                    ErpFunLease funLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, houseId);
                    if (funLease == null) {
                        ErpFunSaleToLease funSaleToLease = erpFunSaleToLeaseMapper.getFunSaleToLeaseById(cityId, houseId);
                        if (funSaleToLease != null) {
                            throw new BusinessException("该出售房源已被转为出租，编号：" + funSaleToLease.getLeaseNo());
                        }
                    } else {
                        funDeal.setSectionId(funLease.getSectionId());
                        if (!"&&&".equals(funLease.getCellPhone())) {
                            String phone = SyncUtil.decodePhoneForHouseDetailOfFirst(funLease.getCellPhone(), false);
                            funDeal.setSellOwnerPhone(phone);
                            funDeal.setSellOwnerPhoneencode(phone);
                        }
                        if (StringUtils.isBlank(funDeal.getSellOwnerPhoneBak())) {
                            if (!"&&&".equals(funLease.getJointCellPhone())) {
                                String phone = SyncUtil.decodePhoneForHouseDetailOfFirst(funLease.getJointCellPhone(),
                                        false);
                                funDeal.setSellOwnerPhoneBak(phone);
                            }
                        }

                        oldStatus = funLease.getLeaseStatus();
                    }
                }
            }

        } else {
            if (funDeal.getBuildId() != null) {
                ErpBuildingInfo buildingInfo = erpBuildingInfoMapper.getErpBuildInfoByid(cityId, funDeal.getBuildId());
                funDeal.setSectionId(buildingInfo.getSectionId());
            }
            funDeal.setSellOwnerPhoneencode(funDeal.getSellOwnerPhone());
        }

        // 创建合同智能检索字段
        createDealIntelligentSearch(funDeal);

        ErpFunFinanceStatusExample erpFunFinanceStatusExample = new ErpFunFinanceStatusExample();
        erpFunFinanceStatusExample.setShardCityId(cityId);
        erpFunFinanceStatusExample.createCriteria().andCompIdEqualTo(operator.getCompId()).andFinancNameEqualTo("待结清");
        ErpFunFinanceStatus financeStatus = erpFunFinanceStatusMapper.selectByExample(erpFunFinanceStatusExample).get(0);
        if (financeStatus != null) {
            funDeal.setFinancStatusId(financeStatus.getFinancStatusId());
            funDeal.setFinancName("待结清");
        }
        Map<String, Object> resultMap = new HashMap<>();

        erpFunDealService.createAgreement(cityId, funDeal, trackContent, resultMap, param);
        try {
            erpFunDepositService.updateDepositDeal(generalParam, funDeal.getDealId(), funDeal.getContractNo(), param.getDepositId());
            erpFunEarbestMoneyService.updateEarnestDeal(generalParam, funDeal.getDealId(), funDeal.getContractNo(), param.getEarbestId());
        } catch (Exception e) {
            e.printStackTrace();
            //优先保证合同创建成功
        }
        writeDealRecordOffInsertDeal(funDeal.getDealId());
//        sendJmsMessage(funDeal, param, resultMap);
        List<ErpFunTrack> trackList = (List<ErpFunTrack>) resultMap.get("trackList");
        for (ErpFunTrack funTrack : trackList) {
            if (funTrack != null) {
//                adminJmsMessageService.addWorkCount(Const.StatisticDetailType.CJ_COUNT,
//                        DateUtil.StringToDate(funTrack.getCreationTime(), DateTimeHelper.FMT_yyyyMMddHHmmssS), funTrack.getCreatorUid(),
//                        funTrack.getCaseType().intValue(), funTrack.getCaseId(), funTrack.getTrackId().toString(), 1, cityId);
                activeMqPublisher.sendWorkCountMessageForCaseStatusChange(cityId, Const.StatisticDetailType.CJ_COUNT, DateUtil.StringToDate(funTrack.getCreationTime(), DateTimeHelper.FMT_yyyyMMddHHmmssS),
                        funTrack.getCreatorUid(), funTrack.getCaseType().intValue(), funTrack.getCaseId(), funTrack.getTrackId(),
                        funTrack.getCaseType().intValue() == 1 || funTrack.getCaseType().intValue() == 3 ? funDeal.getSellDealMoney().doubleValue() : funDeal.getRentDealMoney().doubleValue(), oldStatus, funDeal.getDealId());
            }
        }
        // 这个地方可以取消了，因为jms没干什么
        if (resultMap.containsKey("messages")) {
            List<AdminFunUserMessage> messages = (List<AdminFunUserMessage>) resultMap.get("messages");
            TaskQueueThread.sendMessageList(messages);
        }

        return funDeal.getDealId();
    }

    private void writeDealRecordOffInsertDeal(Integer dealId) {
        GeneralParam param = new GeneralParam(getOperator());
        String dealContent = getCurrentUserName() + " 创建了该合同";
        erpFunDealRecordService.writeDealRecord(param, dealId, null, Constants_DIC.DIC_DEAL_UPDATE_CLASSIC_DEALCREATE, (byte) 0,
                dealContent, 1, null, false, null);
        String profitContent = " 系统创建了该财务款项";
        erpFunDealRecordService.writeDealRecord(param, dealId, Constants_DIC.DIC_SYSTEM_USERID_999,
                Constants_DIC.DIC_DEAL_UPDATE_CLASSIC_PROCESSFIANACCREATE, (byte) 1, profitContent, 1, null, false, null);
        String processContent = " 系统创建了该业绩";
        erpFunDealRecordService.writeDealRecord(param, dealId, Constants_DIC.DIC_SYSTEM_USERID_999,
                Constants_DIC.DIC_DEAL_UPDATE_CLASSIC_PROFITCREATE, (byte) 2, processContent, 1, null, false, null);
    }


    private void sendJmsMessage(ErpFunDeal funDeal, InsertDealInfoParam param, Map<String, Object> resultMap) {
        if (funDeal == null) {
            return;
        }
        Map<String, Object> content = new HashMap<>();
        content.put("dealId", param.getDealId());
        content.put("compId", param.getCompId());
        content.put("cityId", getOperator().getCityId());
        content.put("isTrackWarm", param.isTrackWarm());
        content.put("warmContent", param.getWarmContent());
        content.put("warmTime", param.getWarmTime());
        content.put("regId", getOperator().getRegId());
        content.put("areaId", getOperator().getAreaId());
        content.put("adminCompId", getOperator().getAdminCompId());
        content.put("adminDeptId", getOperator().getAdminDeptId());
        content.put("compName", getOperator().getCompName());
        content.put("currentOperatorName", getCurrentUserName());
        Object commissionReceivable = getOperator().getAttribute("COMMISSION_RECEIVABLE");
        content.put("commissionReceivable", String.valueOf(StringUtil.parseDouble(String.valueOf(commissionReceivable), 0.0)));
        if (resultMap != null) {
            content.putAll(resultMap);
        }
        AdminJmsMessage adminJmsMessage = new AdminJmsMessage();
        adminJmsMessage.setMsgSource("ERP");
        adminJmsMessage.setAction(JmsMsgAction.ADD_BUSINESS_BEYONDDEAL);
        adminJmsMessage.setCreateTime(new Date());
        adminJmsMessage.setCityId(getOperator().getCityId());
        adminJmsMessage.setDelaySeconds(null);
        adminJmsMessage.setSendProducer(Const.DIC_JMS_SEND_PRODUCER_1);
        adminJmsMessage.setMsgContent(JSON.toJSONString(content));
        // 发送消息给JMS服务器，发送失败不回滚插入的数据
        JmsPublisher.sendMessage(adminJmsMessage);

//		BusinessBeyondDealMessage message = new BusinessBeyondDealMessage();
//		message.setDealId(param.getDealId());
//		message.setCompId(param.getCompId());
//		message.setCityId(getOperator().getCityId());
//		message.setTrackWarm(param.isTrackWarm());
//		message.setWarmContent(param.getWarmContent());
//		message.setWarmTime(param.getWarmTime());
//		message.setRegId(getOperator().getRegId());
//		message.setAreaId(getOperator().getAreaId());
//		message.setAdminCompId(getOperator().getAdminCompId());
//		message.setAdminDeptId(getOperator().getAdminDeptId());
//		message.setCompName(getOperator().getCompName());
//		message.setCurrentOperatorName(getCurrentUserName());
//		message.setCommissionReceivable( String.valueOf(StringUtil.parseDouble(String.valueOf(commissionReceivable), 0.0)));
//		message.setQueneName(JmsMsgAction.ADD_BUSINESS_BEYONDDEAL);
//		mqUtil.sendMessage(message);

    }

    private void createDealIntelligentSearch(ErpFunDeal funDeal) {
        StringBuilder intelligentSearchBuilder = new StringBuilder();
        if (!CommonUtil.isnull(funDeal.getContractNo())) {
            intelligentSearchBuilder.append(funDeal.getContractNo());
            intelligentSearchBuilder.append(",");
        }
        if (!CommonUtil.isnull(funDeal.getBuyOwnerName())) {
            intelligentSearchBuilder.append(funDeal.getBuyOwnerName());
            intelligentSearchBuilder.append(",");
        }
        if (!CommonUtil.isnull(funDeal.getHouseaddress())) {
            intelligentSearchBuilder.append(funDeal.getHouseaddress());
            intelligentSearchBuilder.append(",");
        }
        if (!CommonUtil.isnull(funDeal.getSellOwnerName())) {
            intelligentSearchBuilder.append(funDeal.getSellOwnerName());
            intelligentSearchBuilder.append(",");
        }
        if (!CommonUtil.isnull(funDeal.getSellAddress())) {
            intelligentSearchBuilder.append(funDeal.getSellAddress());
            intelligentSearchBuilder.append(",");
        }
        if (!CommonUtil.isnull(funDeal.getDealHouseNo())) {
            intelligentSearchBuilder.append(funDeal.getDealHouseNo());
            intelligentSearchBuilder.append(",");
        }
        if (!CommonUtil.isnull(funDeal.getDealCustomerNo())) {
            intelligentSearchBuilder.append(funDeal.getDealCustomerNo());
            intelligentSearchBuilder.append(",");
        }
        if (!CommonUtil.isnull(funDeal.getSellCallPhone())) {
            intelligentSearchBuilder.append(funDeal.getSellCallPhone());
            intelligentSearchBuilder.append(",");
        }
        if (!CommonUtil.isnull(funDeal.getBuyCallPhone())) {
            intelligentSearchBuilder.append(funDeal.getBuyCallPhone());
            intelligentSearchBuilder.append(",");
        }
        if (!CommonUtil.isnull(funDeal.getBuyIdCard())) {
            intelligentSearchBuilder.append(funDeal.getBuyIdCard());
            intelligentSearchBuilder.append(",");
        }
        if (!CommonUtil.isnull(funDeal.getSellIdCard())) {
            intelligentSearchBuilder.append(funDeal.getSellIdCard());
            intelligentSearchBuilder.append(",");
        }
        funDeal.setIntelligentSearch(intelligentSearchBuilder.toString());
    }


    private Integer[] isRepeatConstarctNo(ErpFunDeal funDeal, Integer cityId) {
        Operator operator = getOperator();
        Integer[] resultArr = new Integer[]{0, 0};
        // 判断是否是编辑状态下，编辑情况下，判断合同编号有没有改变，如果有改变，则进行判重，否则不进行
        if (funDeal.getDealId() != null) {
            funDeal.setShardCityId(cityId);
            ErpFunDeal oldModel = erpFunDealMapper.selectByPrimaryKey(funDeal);
            if (oldModel.getContractNo().equals(funDeal.getContractNo())) {
                resultArr[0] = 0;
                return resultArr;
            } else {
                resultArr[1] = 1;
            }
        }
        Integer isSplit = StringUtil.paseInteger(erpSysParaMapper.getParamValue(operator.getCityId(), operator.getCompId(), "SALE_RENT_DEAL_REPEAT"));
        Integer isAllow = StringUtil.paseInteger(erpSysParaMapper.getParamValue(operator.getCityId(), operator.getCompId(), "ALLOW_UNUSE_DEALNO_ISBYHAND"));
        Integer isCan = StringUtil.paseInteger(erpSysParaMapper.getParamValue(operator.getCityId(), operator.getCompId(), "INVALID_DEALNO_CAN_USE_AGAIN"));
        ErpFunDealExample dealExample = new ErpFunDealExample();
        dealExample.setShardCityId(operator.getCityId());
        ErpFunDealExample.Criteria dealExampleCriteria = dealExample.createCriteria();
        dealExampleCriteria.andCompIdEqualTo(operator.getCompId()).andContractNoEqualTo(funDeal.getContractNo()).andIsbyhandEqualTo((byte) 0);
        if (isSplit == 1) {
            dealExampleCriteria.andDealTypeEqualTo(funDeal.getDealType());
        }
        if (isCan == 1) {
            dealExampleCriteria.andDealAuditStatusNotEqualTo((byte) 3);
        }
        // 判重
        int count = erpFunDealMapper.countByExample(dealExample);
        if (count > 0) {
            resultArr[0] = 1;
            return resultArr;
        }
        // 允许手动录入未使用的自动分配的合同编号 1是0否
        if (funDeal.getCodeType() != 0) {
            return resultArr;
        }
        if (isAllow == 0) {// 手动录入的情况下 不允许
            Integer dealType = null;
            if (funDeal.getDealType() == 101) {
                dealType = 2;
            }
            if (funDeal.getDealType() == 102) {
                dealType = 1;
            }
            int isAllowCount = erpFunDealCodelogMapper.getIsAllowCount(operator.getCityId(), operator.getCompId(), funDeal.getContractNo(), dealType);
            if (isAllowCount > 0) {
                resultArr[0] = 2;
            }
        } else {
            boolean isWarrantManageOpers = erpUserOpersService.judgePermission(operator.getCityId(), operator.getUserId(), "WARRANT_MANAGE");
            Integer dealType = null;
            if (101 == funDeal.getDealType()) {
                dealType = 2;
            }

            if (102 == funDeal.getDealType()) {
                dealType = 1;
            }

            Integer deptId = !isWarrantManageOpers ? operator.getDeptId() : null;
            Integer codeId = erpFunDealCodelogMapper.getCodeId(operator.getCityId(), operator.getCompId(), funDeal.getContractNo(), dealType, deptId);
            if (codeId != null) {
                funDeal.setCodeId(codeId);
                resultArr[1] = 1;
            }
        }
        return resultArr;
    }

    /**
     * @tag 为优家需要律师审核的合同生成自动编号 如果CONTRACT_NO不为空则直接返回
     * @author 邓永洪
     * @since 2018/5/30
     */
    private void createConstarctNoForYouJia(ErpFunDeal funDeal) {
        if (StringUtils.isNotBlank(funDeal.getContractNo())) {
            return;// 编号不为空直接返回
        }
        if (!"1".equals(getOperator().getAttribute("YOU_CITY_DEAL_NEED_EXAMINE"))) {
            throw new BusinessException("请输入编号");// 正常情况下不会到这里来
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        String contractNo = sdf.format(new Date());
        if (Const.DIC_CASE_TYPE_SALE_DEAL == funDeal.getDealType().intValue()) {
            contractNo = "S" + contractNo;
        } else {
            contractNo = "Z" + contractNo;
        }
        funDeal.setContractNo(contractNo);
    }


    /**
     * @tag 合同照片保存
     * @author 邓永洪
     * @since 2018/6/7
     */
    @RequestMapping("/dealPhotoSave")
    public ErpResponseJson uploadWaterStain(@RequestBody BaseMapParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        Integer userId = operator.getUserId();
        String photoPath = param.getString("photoPath");
        Byte photoType = param.getByte("photoType");
        Byte fileType = param.getByte("fileType");
        Byte fileSubType = param.getByte("fileSubType");
        Integer pellucidity = param.getInteger("pellucidity");
        if (photoPath == null && photoType == 8) {//只更新透明度
            ErpFunDealPhotoExample photoExample = new ErpFunDealPhotoExample();
            photoExample.setShardCityId(cityId);
            photoExample.createCriteria().andCompIdEqualTo(compId).andPhotoTypeEqualTo(photoType).andTransmitFlagEqualTo((byte) 0);
            List<ErpFunDealPhoto> dealPhotos = erpFunDealPhotoMapper.selectByExample(photoExample);
            if (!dealPhotos.isEmpty() && dealPhotos.get(0) != null) {
                ErpFunDealPhoto dealPhoto = dealPhotos.get(0);
                ErpFunDealPhoto updateModel = new ErpFunDealPhoto();
                updateModel.setShardCityId(cityId);
                updateModel.setPhotoId(dealPhoto.getPhotoId());
                updateModel.setPellucidity(pellucidity);
                erpFunDealPhotoMapper.updateByPrimaryKeySelective(updateModel);
            }
        } else {
            erpFunDealPhotoService.updateAndInsertPhoto(cityId, compId, userId, photoPath, photoType, pellucidity, fileType, fileSubType);
        }
        return ErpResponseJson.ok();
    }

    /**
     * @tag 删除合同照片
     * @author 邓永洪
     * @since 2018/6/11
     */
    @ApiOperation("删除合同照片(包含合同LOGO,印章管理,合同水印等)")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = DealPhotoParamAndVo.class, message = "成功")
    })
    @PostMapping("/delDealPhoto")
    public ErpResponseJson delDealPhoto(@RequestBody DealPhotoParamAndVo param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        Byte photoType = param.getPhotoType();
        ErpFunDealPhotoExample photoExample = new ErpFunDealPhotoExample();
        photoExample.setShardCityId(cityId);
        photoExample.createCriteria().andCompIdEqualTo(compId).andPhotoTypeEqualTo(photoType);
        ErpFunDealPhoto erpFunDealPhoto = new ErpFunDealPhoto();
        erpFunDealPhoto.setShardCityId(cityId);
        erpFunDealPhoto.setTransmitFlag((byte) 2);
        erpFunDealPhotoMapper.updateByExampleSelective(erpFunDealPhoto, photoExample);
        return ErpResponseJson.ok(param);
    }

    /**
     * @tag 更新合同财务状态
     * @author 邓永洪
     * @since 2018/6/25
     */
    @ApiOperation("更新合同财务状态")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/updateDealFinancStatus")
    public ErpResponseJson updateDealFinancStatus(@RequestBody FunContractParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer dealId = param.getDealId();
        Integer financStatusId = param.getFinancStatusId();
        String financName = param.getFinancName();
        if (StringUtils.isBlank(financName) && null == financStatusId) {
            ErpResponseJson.ok();
        }

        ErpFunDeal deal = erpFunDealMapper.getBaseDealInfo(cityId, dealId);

        GeneralParam generalParam = new GeneralParam(operator);
        generalParam.setCurrDeptUserName(getCurrentUserName());
        erpFunDealService.updateDealFinancStatus(deal, financStatusId, financName, dealId, cityId, generalParam);

        return ErpResponseJson.ok();
    }

    /**
     * @tag 合同附件删除
     * @author 邓永洪
     * @since 2018/6/23
     */
    @ApiOperation("合同附件删除(客户资料,业主资料,其他资料)")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/updateFunDealPhotoList")
    public ErpResponseJson updateFunDealPhotoList(@RequestBody UpdateFunDealPhotoParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        ErpFunDealPhotoExample dealPhotoExample = new ErpFunDealPhotoExample();
        dealPhotoExample.setShardCityId(cityId);
        dealPhotoExample.createCriteria().andPhotoIdIn(StringUtil.toIntList(param.getPhotoIds(), ","));
        ErpFunDealPhoto dealPhoto = new ErpFunDealPhoto();
        dealPhoto.setTransmitFlag((byte) 2);

        GeneralParam generalParam = new GeneralParam(operator);
        String trackContent = getCurrentUserName();
        erpFunDealPhotoService.updateFunDealPhotoList(param, dealPhoto, dealPhotoExample, generalParam, trackContent);

        return ErpResponseJson.ok();
    }

    /**
     * 查询印章
     *
     * @param param
     * @return Modified XXX HeWei 2018年7月18日
     * @author HeWei
     * @since 2018年7月18日 下午3:17:11
     */
    @ApiOperation("获取印章")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = DealSealVo.class, message = "成功")
    })
    @PostMapping("/getDealSeal")
    public ErpResponseJson getDealSeal(@RequestBody DealSealParam param) {
        Integer compId = getOperator().getCompId();
        Integer cityId = getOperator().getCityId();

        Integer photoType = param.getPhotoType();
        ErpFunDealPhotoExample erpFunDealPhotoExample = new ErpFunDealPhotoExample();
        erpFunDealPhotoExample.setOrderByClause(" PHOTO_ID desc");
        erpFunDealPhotoExample.setShardCityId(cityId);
        erpFunDealPhotoExample.createCriteria().andPhotoTypeEqualTo(photoType.byteValue()).andTransmitFlagEqualTo((byte) 0).andCompIdEqualTo(compId);
        List<ErpFunDealPhoto> list = erpFunDealPhotoMapper.selectByExample(erpFunDealPhotoExample);
        String photoAddr = "";
        if (list.size() > 0) {
            ErpFunDealPhoto erpFunDealPhoto = list.get(0);
            if (erpFunDealPhoto.getPhotoAddr() != null) {
                photoAddr = AppConfig.getUserPhotoPicDomainPath(erpFunDealPhoto.getPhotoAddr().replaceAll("\\\\", "/"));
            }
        }

        DealSealVo dealSealVo = new DealSealVo();
        dealSealVo.setDealSeal(photoAddr);
        return ErpResponseJson.ok(dealSealVo);
    }

    /**
     * 删除合同印章
     *
     * @param param
     * @return Modified XXX HeWei 2018年7月18日
     * @author HeWei
     * @since 2018年7月18日 下午4:50:00
     */
    @ApiOperation("删除合同印章")
    @ApiResponses({@ApiResponse(code = 200, response = ErpResponseJson.class, message = "success")})
    @PostMapping("/updateDealLogoStatus")
    public ErpResponseJson updateDealLogoStatus(@RequestBody BaseMapParam param) {
        Operator operator = getOperator();
        Integer compId = operator.getCompId();
        Integer cityId = operator.getCityId();
        ErpFunDealPhoto erpFunDealPhoto = new ErpFunDealPhoto();
        erpFunDealPhoto.setTransmitFlag((byte) 2);
        ErpFunDealPhotoExample erpFunDealPhotoExample = new ErpFunDealPhotoExample();
        erpFunDealPhotoExample.setShardCityId(cityId);
        erpFunDealPhotoExample.createCriteria().andCompIdEqualTo(compId).andPhotoTypeEqualTo((byte) 3);
        erpFunDealPhotoMapper.updateByExampleSelective(erpFunDealPhoto, erpFunDealPhotoExample);
        return ErpResponseJson.ok();
    }

    /**
     * 查询手动录入业绩修改日志列表
     *
     * @param param
     * @return Modified XXX HeWei 2018年7月18日
     * @author HeWei
     * @since 2018年7月18日 下午6:27:32
     */
    @ApiOperation("获取手动录入业绩列表")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = HandProfitLogListVo.class, message = "成功")
    })
    @PostMapping("/getByHandProfitLogList")
    public ErpResponseJson getByHandProfitLogList(@RequestBody HandProfitListParam param) {
        Operator operator = getOperator();
        Integer compId = operator.getCompId();
        Integer cityId = operator.getCityId();
        Integer dealId = param.getDealId();

        ErpFunDealRecordExample erpFunDealRecordExample = new ErpFunDealRecordExample();
        erpFunDealRecordExample.setShardCityId(cityId);
        erpFunDealRecordExample.setOrderByClause(" UPDATE_DATE DESC ");
        Criteria criteria = erpFunDealRecordExample.createCriteria();
        criteria.andCompIdEqualTo(compId);
        if (dealId != null) {
            criteria.andAgreementNoEqualTo(dealId.toString());
        }
        List<Byte> typeList = new ArrayList<>();
        typeList.add((byte) 0);
        typeList.add((byte) 2);
        criteria.andUpdateTypeIn(typeList);
        PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
        List<ErpFunDealRecord> list = erpFunDealRecordMapper.selectByExample(erpFunDealRecordExample);
        for (ErpFunDealRecord erpFunDealRecord : list) {
            // 合同指标修改类型暂不显示详情
            if (erpFunDealRecord.getUpdateType() != null && "3".equals(erpFunDealRecord.getUpdateType().toString())) {
                erpFunDealRecord.setFrontRecordId(null);
            }
        }
        PageInfo<ErpFunDealRecord> pageInfo = new PageInfo<>(list);
        HandProfitLogListVo resultVo = new HandProfitLogListVo(pageInfo);
        return ErpResponseJson.ok(resultVo);
    }

    /**
     * 编辑合同保存
     *
     * @return
     * @throws Exception Modified XXX HeWei 2018年7月19日
     * @author HeWei
     * @since 2018年7月19日 下午3:58:50
     */
    @ApiOperation("编辑合同")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/updateMgrDealData")
    public ErpResponseJson updateMgrDealData(@RequestBody ErpFunDealsParam param) throws Exception {
        ErpFunDeal model = getParamObj(ErpFunDeal.class);
        Integer compId = getOperator().getCompId();
        Integer cityId = getOperator().getCityId();
        Integer compType = getOperator().getCompType();
        String deptType = getOperator().getAttribute("DEPT_TYPE")+"";
        if (compType == 6 && "6".equals(deptType)) {
            deptType = "6";
        } else {
            deptType = "1";
        }
        //判断是否是房基地
        if (adminFunCompService.judgerIsFangjidi(getOperator().getAdminCompId())) {
            if (param.getDealBuyStyle() != null && "0".equals(param.getDealBuyStyle().toString())
                    && param.getDealSellStyle() != null && "0".equals(param.getDealSellStyle().toString())) { //都是內部合作
                //判断佣金是否小于总共的90%
                if (!erpProcessFinanceService.chackCommission(cityId, getOperator().getCompId(), param.getDealType(), param.getSellDealMoney(), param.getRentDealMoney(), param.getRentPriceUnit(), param.getArea(), param.getSellOwnerCommsion(), param.getBuyCustomerCommsion())) {
                    return ErpResponseJson.warn("业主与客户付佣的总金额 不能低于 业主与客户付佣金额标准的90%！");
                }
            }
            if (null != param.getIntroducerId()) {
                if (null != param.getCustUserUid() && param.getIntroducerId().equals(param.getCustUserUid())) {
                    return ErpResponseJson.warn("介绍人不可与客源所属经纪人相同！");
                }
                if (null != param.getHouseUserUid() && param.getIntroducerId().equals(param.getHouseUserUid())) {
                    return ErpResponseJson.warn("介绍人不可与房源所属经纪人相同！");
                }
            }
            if (null != param.getAdultPromotionId()) {
                if (null != param.getCustUserUid() && param.getAdultPromotionId().equals(param.getCustUserUid())) {
                    return ErpResponseJson.warn("促成人不可与客源所属经纪人相同！");
                }
            }
        }
        ErpFunDealExample erpFunDealExample = new ErpFunDealExample();
        erpFunDealExample.setShardCityId(cityId);
        erpFunDealExample.createCriteria().andDealIdEqualTo(model.getDealId()).andCompIdEqualTo(compId);
        List<ErpFunDeal> list = erpFunDealMapper.selectByExample(erpFunDealExample);
        if (list.size() > 0) {
            ErpFunDeal oldModel = list.get(0);

            // 添加更新人信息
            if (model.getDealHouseId() != null) {
                model.setSellOwnerPhone(model.getSellOwnerPhone());
                model.setSellOwnerPhoneencode(model.getSellOwnerPhoneencode());
            } else {
                model.setSellOwnerPhoneencode(model.getSellOwnerPhone());
            }
            if (StringUtils.isBlank(model.getSellOwnerPhoneBak())) {
                model.setSellOwnerPhoneBak(oldModel.getSellOwnerPhoneBak());
            }
            if (model.getDealCustomerId() != null) {
                model.setBuyCustomerPhone(model.getBuyCustomerPhone());
                model.setBuyCustomerPhoneencode(model.getBuyCustomerPhoneencode());
            } else {
                model.setBuyCustomerPhoneencode(model.getBuyCustomerPhone());
            }

            if (model.getBuildRegId() != null) {
                ErpFunReg reg = new ErpFunReg();
                reg.setCityId(cityId.shortValue());
                reg.setRegId(model.getBuildRegId());
                reg.setShardCityId(cityId);
                ErpFunReg erpFunReg = erpFunRegMapper.selectByPrimaryKey(reg);
                if (erpFunReg != null) {
                    model.setBuildRegName(erpFunReg.getRegName());
                }
            }
            model.setUpdateTime(new Date());
            model.setUpdateUid(getOperator().getUserId());

            Integer[] repeatAndCodeFlagArr = isRepeatConstarctNo(model, cityId);
            if (repeatAndCodeFlagArr[0] == 1) {
                return ErpResponseJson.warn("该号段与已分配编码有重复，请重新分配");
            }
            if (repeatAndCodeFlagArr[0] == 2) {
                return ErpResponseJson.warn("不可手动录入未使用的自动分配的合同编号");
            }

            Integer signUser = model.getSignUserId();
            Integer signManageUser = model.getSignManagerId();

            if (signUser != null) {
                ErpFunUsers erpFunUsers = erpFunUsersMapper.selectUserNameByUserId(cityId, signUser);
                model.setSignUserName(erpFunUsers.getUserName());
                if (getOperator().newOrganizationType()) {
                    ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, erpFunUsers.getCompId(), erpFunUsers.getOrganizationId());
                    model.setSignUserDeptId(erpFunOrganization.getOrganizationId());
                    model.setSignUserDeptName(erpFunOrganization.getOrganizationName());
                } else {
                    ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(cityId, erpFunUsers.getDeptId());
                    model.setSignUserDeptId(erpFunDepts.getDeptId());
                    model.setSignUserDeptName(erpFunDepts.getDeptName());
                }
            }

            if (signManageUser != null) {
                ErpFunUsers erpFunUsers = erpFunUsersMapper.selectUserNameByUserId(cityId, signManageUser);
                model.setSignManagerName(erpFunUsers.getUserName());
                if (getOperator().newOrganizationType()) {
                    ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, erpFunUsers.getCompId(), erpFunUsers.getOrganizationId());
                    model.setSignManagerDeptId(erpFunOrganization.getOrganizationId());
                    model.setSignManagerDeptName(erpFunOrganization.getOrganizationName());
                } else {
                    ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(cityId, erpFunUsers.getDeptId());
                    model.setSignManagerDeptId(erpFunDepts.getDeptId());
                    model.setSignManagerDeptName(erpFunDepts.getDeptName());
                }
            }

            createDealIntelligentSearch(model);
            GeneralParam generalParam = new GeneralParam(getOperator());
            Map<String, Object> resultMap = new HashMap<>();
            erpFunDealService.updateMgrDealData(model, repeatAndCodeFlagArr, oldModel, generalParam, deptType, resultMap);
            if (resultMap.containsKey("messages")) {
                List<AdminFunUserMessage> messages = (List<AdminFunUserMessage>) resultMap.get("messages");
                TaskQueueThread.sendMessageList(messages);
            }
        }
        return ErpResponseJson.ok();
    }

    @RequestMapping("/updateByHandProfit")
    public ErpResponseJson updateByHandProfit(@RequestBody BaseMapParam param) throws IllegalAccessException {
        Operator operator = getOperator();
        ErpFunDeal deal = BeanUtil.buildBaseBean(new ErpFunDeal(), operator.getParamMap());

        return ErpResponseJson.ok();
    }

    /**
     * 添加一条内成交信息
     *
     * @param param
     * @return
     * @throws Exception Modified XXX HeWei 2018年7月20日
     * @author HeWei
     * @since 2018年7月20日 下午2:25:29
     */
    @RequestMapping("/insertMgrDeal")
    public ErpResponseJson insertMgrDeal(@RequestBody InsertDealInfoParam param) throws Exception {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        param.setPersonalVersion(operator.isPersonalVersion());
        param.setSelfCompType(operator.getCompType());
        param.setSelfDeptName(operator.getDeptName());
        param.setSelfUserName(operator.getUserName());
        param.setSelfUserId(operator.getUserId());
        param.setSelfDeptId(operator.getDeptId());
        param.setSelfCompId(operator.getCompId());
        param.setSelfArchiveId(operator.getArchiveId());
        param.setSelfGrId(operator.getGrId());
        param.setSelfAreaId(operator.getAreaId());
        param.setSelfRegId(operator.getRegId());
        param.setCityId(cityId);
        Integer dealId = insetDealInfo(param);
        copyPhoto(dealId, param);
        HashMap<String, Object> hm = new HashMap<String, Object>();
        HashMap<String, Object> returnMap = new HashMap<String, Object>();
        hm.put("dealId", dealId);
        List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
        returnList.add(hm);
        returnMap.put("DATA", returnList);
        return ErpResponseJson.ok(hm);
    }

    /**
     * @tag 修改合同锁定状态
     * @author 邓永洪
     * @since 2018/7/20
     */
    @RequestMapping("/updateDealLockFlag")
    public ErpResponseJson updateDealLockFlag(@RequestBody BaseMapParam param) {
        ErpFunDeal deal = getParamObj(ErpFunDeal.class);
        deal.setShardCityId(getOperator().getCityId());
        erpFunDealMapper.updateByPrimaryKeySelective(deal);
        return ErpResponseJson.ok();
    }

    /**
     * @tag 合同写跟进
     * @author chenfeng
     * @since 2019/7/5
     */
    @ApiOperation("合同写跟进")
    @ApiResponses({@ApiResponse(code = 200, response = CreateDealTrackVO.class, message = "success")})
    @PostMapping("/createDealTrack")
    public ResponseJson createDealTrack(@RequestBody CreateDealTrackParam param) {
        GeneralParam generalParam = new GeneralParam(getOperator());
        Assert.isTrueThrow(StringUtil.isBlank(param.getTrackContent()) && StringUtil.isBlank(param.getWarmContent()), "数据异常，请联系在线客服");

        String trackIds = erpFunDealService.createDealTrack(generalParam, param);
        if (StringUtil.isNotBlank(param.getWarmContent()) && StringUtil.isNotBlank(param.getWarmUser())) {
            // 发送合同提醒消息
            String[] columns = new String[]{"DEAL_ID", "CONTRACT_NO", "DEAL_TYPE"};
            ErpFunDeal erpFunDeal = erpFunDealMapper.selectByDealId(generalParam.getCityId(), param.getDealId(), columns);
            String[] userIdArr = param.getWarmUser().split(",");
            Set<Integer> userIdSet = new HashSet<>();
            for (String userId : userIdArr) {
                userIdSet.add(Integer.valueOf(userId));
            }
            if (null != erpFunDeal && userIdSet.size() > 0) {
                String warmContent = param.getWarmContent();
                erpFunTaskService.pushMsgForDealRemind(generalParam, erpFunDeal, warmContent, userIdSet);
            }
        }
        CreateDealTrackVO createDealTrackVO = new CreateDealTrackVO();
        createDealTrackVO.setTrackIds(trackIds);
        return ErpResponseJson.ok(createDealTrackVO);
    }

    /**
     * @tag 获取合同跟进
     * @author chenfeng
     * @since 2019/7/5
     */
    @ApiOperation("获取合同跟进")
    @ApiResponses({@ApiResponse(code = 200, response = GetDealTrackVO.class, message = "success")})
    @PostMapping("/getDealTrack")
    public ResponseJson getDealTrack(@RequestBody @Valid GetDealTrackParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        Integer dealId = param.getDealId();
        Assert.isTrueThrow(null == dealId, "数据异常，请联系在线客服");
        ErpFunDealTrackExample erpFunDealTrackExample = new ErpFunDealTrackExample();
        erpFunDealTrackExample.setShardCityId(cityId);
        erpFunDealTrackExample.setOrderByClause("CREATION_TIME DESC");
        erpFunDealTrackExample.createCriteria().andCompIdEqualTo(compId).andDealIdEqualTo(dealId);
        PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
        List<ErpFunDealTrack> erpFunDealTrackList = erpFunDealTrackMapper.selectByExample(erpFunDealTrackExample);
        List<ErpFunDealTrackVO> resultList = new ArrayList<>();
        // story#11536 PC跨城管理-查询人员的组织信息
        if (!erpFunDealTrackList.isEmpty()) {
        	List<Integer> userIdList = erpFunDealTrackList.stream().map(ErpFunDealTrack :: getUserId).collect(Collectors.toList());
        	if (!userIdList.isEmpty()) {
        		Map<Integer, UserOrganizationInfoVO> userOrganizationInfoMap = erpFunUsersService.getUserOrganizationInfoByUserIds(cityId, userIdList);
        		if (null != userOrganizationInfoMap) {
        			erpFunDealTrackList.stream().forEach(a -> {
        				Integer userId = a.getUserId();
        				ErpFunDealTrackVO erpFunDealTrackVO = new ErpFunDealTrackVO();
        				try {
							BeanUtilsHelper.copyProperties(erpFunDealTrackVO, a);
						} catch (Exception e) {
							e.printStackTrace();
						}
        				UserOrganizationInfoVO userOrganizationInfoVO = userOrganizationInfoMap.get(userId);
        				if (null != userOrganizationInfoVO) {
        					erpFunDealTrackVO.setUserId(userOrganizationInfoVO.getUserId());
        					erpFunDealTrackVO.setUserName(userOrganizationInfoVO.getUserName());
        					erpFunDealTrackVO.setOrganizationId(userOrganizationInfoVO.getOrganizationId());
        					erpFunDealTrackVO.setOrganizationName(userOrganizationInfoVO.getOrganizationName());
        					erpFunDealTrackVO.setCompName(userOrganizationInfoVO.getCompName());
        				}
        				resultList.add(erpFunDealTrackVO);
        			});
        		}
        	}
        }
        GetDealTrackVO getDealTrackVO = new GetDealTrackVO();
        getDealTrackVO.setList(resultList);
        return ErpResponseJson.ok(getDealTrackVO);
    }

    @ApiOperation("获取房客源附件  325")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
    })
    @PostMapping("/getHouseOrCustomerEnclosure")
    public ResponseJson getHouseOrCustomerEnclosure(@RequestBody HouseOrCustomerEnclosureParam param) {
        if (param.getCaseId() == null) {
            throw new BusinessException("信息id缺失");
        }
        if (param.getCaseType() == null) {
            throw new BusinessException("信息类型缺失");
        }
        param.setCityId(getOperator().getCityId());
        param.setCompId(getOperator().getCompId());
        List<EnclosureVo> enclosureVos = new ArrayList<EnclosureVo>();
        if ("1".endsWith(param.getCaseType().toString())) { //出售
            enclosureVos = erpFunHouseFileMapper.getHouseFile(param.getCityId(), param);
        } else if ("2".endsWith(param.getCaseType().toString())) {//出租
            enclosureVos = erpFunHouseFileMapper.getHouseFile(param.getCityId(), param);
        } else if ("3".endsWith(param.getCaseType().toString())) {//求购
            //带完善
        } else if ("4".endsWith(param.getCaseType().toString())) {//求租
            //带完善
        }
        if (enclosureVos != null && enclosureVos.size() > 0) {
            for (EnclosureVo enclosureVo : enclosureVos) {
                if (StringUtil.isNotEmpty(enclosureVo.getFileAddr())) {
                    enclosureVo.setFileAddr(AppConfig.getHousePicDomainPath(enclosureVo.getFileAddr()));
                }
            }
        }
        HouseOrCustomerEnclosureVo customerEnclosureVo = new HouseOrCustomerEnclosureVo();
        customerEnclosureVo.setEnclosureList(enclosureVos);
        return ErpResponseJson.ok(customerEnclosureVo);
    }

    @RequestMapping("/uploadBillSeal")
    public ResponseJson uploadBillSeal(@Valid @RequestBody UploadBillSealParam param) {
        Operator operator = getOperator();
        ErpFunDealPhotoExample erpFunDealPhotoExample = new ErpFunDealPhotoExample();
        erpFunDealPhotoExample.setShardCityId(operator.getCityId());
        erpFunDealPhotoExample.createCriteria().andCompIdEqualTo(operator.getCompId()).andTransmitFlagLessThan(Byte.valueOf("2"));
        ErpFunDealPhoto updateFunDealPhoto = new ErpFunDealPhoto();
        updateFunDealPhoto.setTransmitFlag((byte) 2);
        erpFunDealPhotoMapper.updateByExampleSelective(updateFunDealPhoto, erpFunDealPhotoExample);

        ErpFunDealPhoto erpFunDealPhoto = new ErpFunDealPhoto();
        erpFunDealPhoto.setShardCityId(operator.getCityId());
        erpFunDealPhoto.setCompId(operator.getCompId());
        erpFunDealPhoto.setPhotoAddr(param.getPhotoAddr());
        erpFunDealPhoto.setPhotoType(Byte.valueOf("9"));
        erpFunDealPhoto.setUseageType(Byte.valueOf("1"));
        erpFunDealPhoto.setUploadUser(operator.getUserId());
        erpFunDealPhoto.setUploadDate(new Date());
        erpFunDealPhoto.setTransmitFlag(Byte.valueOf("0"));
        erpFunDealPhotoMapper.insertSelective(erpFunDealPhoto);
        return ErpResponseJson.ok();
    }

    @RequestMapping("/canSeeFunDealPhoto")
    @ApiResponses({@ApiResponse(code = 200, response = CanSeeFunDealPhotoVo.class, message = "success")})
    @PostMapping("/canSeeFunDealPhoto")
    public ResponseJson canSeeFunDealPhoto(@Valid @RequestBody CanSeeFunDealPhotoParam param) {
        Operator operator = getOperator();
        GeneralParam generalParam = new GeneralParam(operator);
        Integer canSee = erpFunDealService.canSeeFunDealPhoto(param, generalParam);
        if (operator.isSwitchCompLogin()) {
        	canSee =1;
        }
        CanSeeFunDealPhotoVo vo = new CanSeeFunDealPhotoVo();
        vo.setCanSee(canSee);
        return ErpResponseJson.ok(vo);
    }
}

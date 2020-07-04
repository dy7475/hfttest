package com.myfun.service.business.erpdb.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Objects;
import com.myfun.erpWeb.managecenter.constract.param.*;
import com.myfun.erpWeb.managecenter.constract.vo.CanSeeFunDealPhotoVo;
import com.myfun.erpWeb.managecenter.constract.vo.CommonSelectVO;
import com.myfun.erpWeb.managecenter.deal.param.DealAuditCommonParam;
import com.myfun.erpWeb.managecenter.deal.param.DealBussinessCommonParam;
import com.myfun.erpWeb.managecenter.transaction.param.CounterMgrSettleDealParam;
import com.myfun.erpWeb.managecenter.transaction.param.ProcessFinancStatusParam;
import com.myfun.erpWeb.managecenter.transaction.param.SettlementDealParam;
import com.myfun.erpWeb.managecenter.transaction.param.changeWarrantParam;
import com.myfun.erpWeb.managecenter.transaction.vo.ErpProcessRuntimeStepDto;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.admindb.dao.*;
import com.myfun.repository.admindb.po.*;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.ErpProcessFinancDto;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminJmsMessageService;
import com.myfun.service.business.erpdb.*;
import com.myfun.service.business.erpdb.bean.vo.InsertSqlVO;
import com.myfun.service.jms.bean.UpdateFunProfitMessage;
import com.myfun.utils.*;
import io.swagger.models.auth.In;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scala.collection.parallel.ParIterableLike;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

import static com.myfun.utils.DateTimeHelper.getTimeNow;

@Service
public class ErpFunDealServiceImpl extends AbstractService<ErpFunDeal, ErpFunDeal> implements ErpFunDealService {

    @Autowired
    private ErpFunDealMapper erpFunDealMapper;
    @Autowired
    private ErpDealTrackMapper erpDealTrackMapper;
    @Autowired
    ErpBroadcastService erpBroadcastService;
    @Autowired
    AdminBulletMapper adminBulletMapper;
    @Autowired
    ErpProcessFinancMapper erpProcessFinancMapper;
    @Autowired
    ErpEarbestMoneyMapper erpEarbestMoneyMapper;
    @Autowired
    ErpFunDealRecordMapper erpFunDealRecordMapper;
    @Autowired
    ErpFunEarbestMoneyrecordMapper erpFunEarbestMoneyrecordMapper;
    @Autowired
    ErpFunSaleMapper erpFunSaleMapper;

    @Autowired
    ErpFunLeaseMapper erpFunLeaseMapper;

    @Autowired
    ErpPosPaymentOrderMapper erpPosPaymentOrderMapper;
    @Autowired
    AdminSysParaMapper adminSysParaMapper;
    @Autowired
    ErpFunDealCodeMapper erpFunDealCodeMapper;
    @Autowired
    ErpFunTrackService erpFunTrackService;
    @Autowired
    ErpProcessFinanceService erpProcessFinanceService;
    @Autowired
    ErpFunProfitService erpFunProfitService;
    @Autowired
    ErpFunHouseBiddingMapper erpFunHouseBiddingMapper;
    @Autowired
    ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
    @Autowired
    ErpFunRentCustomerMapper erpFunRentCustomerMapper;
    @Autowired
    ErpSysParaService erpSysParaService;
    @Autowired
    ErpFunAdsContentMapper erpFunAdsContentMapper;
    @Autowired
    ErpFunAdsContentService erpFunAdsContentService;
    @Autowired
    ErpFunTaskMapper erpFunTaskMapper;
    @Autowired
    ErpDealUserRelativeService erpDealUserRelativeService;
    @Autowired
    ErpSysParaMapper erpSysParaMapper;
    @Autowired
    ErpFunBillMapper erpFunBillMapper;
    @Autowired
    ErpFunProfitMapper erpFunProfitMapper;
    @Autowired
    ErpFunDealCodelogMapper erpFunDealCodelogMapper;
    @Autowired
    ErpProcessRuntimeStepMapper erpProcessRuntimeStepMapper;
    @Autowired
    ErpFunProcessRecordService erpFunProcessRecordService;
    @Autowired
    ErpFunDealRecordService erpFunDealRecordService;
    @Autowired
    ErpFunUsersService erpFunUsersService;
    @Autowired
    ErpFunTaskService erpFunTaskService;
    @Autowired
    ErpDealUserRelativeMapper erpDealUserRelativeMapper;
    @Autowired
    ErpFunUsersMapper erpFunUsersMapper;
    @Autowired
    ErpProcessRuntimeStepService erpProcessRuntimeStepService;
    @Autowired
    AdminCrmCompMapper adminCrmCompMapper;
    @Autowired
    ErpFunCompService erpFunCompService;
    @Autowired
    ErpFunDeptsMapper erpFunDeptsMapper;
    @Autowired
    AdminFunDeptsMapper adminFunDeptsMapper;
    @Autowired
    AdminWeiUserInfoMapper adminWeiUserInfoMapper;
    @Autowired
    ErpFunBrokerageMapper erpFunBrokerageMapper;
    @Autowired
    ErpFunDealTaxesSubMapper erpFunDealTaxesSubMapper;
    @Autowired
    ErpFunDealTaxesFatherMapper erpFunDealTaxesFatherMapper;
    @Autowired
    ErpFunDealService erpFunDealService;
    @Autowired
    ErpFunFinancStatusMapper erpFunFinancStatusMapper;
    @Autowired
    ErpFunWageMapper erpFunWageMapper;
    @Autowired
    ErpFunContractTagService erpFunContractTagService;
    @Autowired
    ErpProcessModelMapper erpProcessModelMapper;
    @Autowired
    ErpModelStepRelateMapper erpModelStepRelateMapper;
    @Autowired
    AdminJmsMessageService adminJmsMessageService;
    @Autowired
    ErpUserOpersService erpUserOpersService;
    @Autowired
    ErpFunDealTrackMapper erpFunDealTrackMapper;
    @Autowired
    ErpAuditRuntimeMapper erpAuditRuntimeMapper;
    @Autowired
    ErpFunTrackMapper erpFunTrackMapper;
    @Autowired
    ErpSsqContractMapper erpSsqContractMapper;
    @Autowired
    AdminOnlinePaymentOrderMapper adminOnlinePaymentOrderMapper;
    @Autowired
    AdminOnlinePaymentOrderPayeeMapper adminOnlinePaymentOrderPayeeMapper;
    @Autowired
    ErpFunFinancPaymentMapper erpFunFinancPaymentMapper;
    @Autowired
    ErpFunCompMapper erpFunCompMapper;
    @Autowired
    AdminFunCompMapper adminFunCompMapper;
    @Autowired
    private ErpUserOpersMapper erpUserOpersMapper;
    @Autowired
    private ErpFunContractCategoryMapper erpFunContractCategoryMapper;
    @Autowired
    private  ErpFunMsgMapper erpFunMsgMapper;
    @Autowired
    private  ErpFunOrganizationService erpFunOrganizationService;
    

    @PostConstruct
    @Override
    public void setBaseMapper() {
        super.baseMapper = this.erpFunDealMapper;
    }
	
	/*@Override
	public PageInfo<DealBulletDto> getDealBulletList(Integer cityId, DealBulletListParam param) {
		param.setIsCount("0");
		List<DealBulletDto> list = erpFunDealMapper.selectDealBulletList(cityId, param);
		PageInfo<DealBulletDto> pageInfo = new PageInfo<>(list);
		pageInfo.setPageNum(param.getPageOffset());
		if (list.size() > 0 && list.size() <= param.getPageRows()) {
			param.setIsCount("1");
			Integer count = erpFunDealMapper.selectDealBulletListCount(cityId, param);
			pageInfo.setTotal(count);
		} else {
			pageInfo.setTotal(list.size());
		}
		return pageInfo;
	}*/

    @Transactional
    @Override
    public void updateByPrimaryKeys(Integer cityId, BaseMapParam paramMap) {
        String bulletIds = paramMap.getString("bulletId");
        String releaseStatus = paramMap.getString("releaseStatus");
        if (bulletIds.toString().endsWith(",")) {
            bulletIds = bulletIds.substring(0, bulletIds.length() - 1).toString();
        }
        String[] arr = bulletIds.split(",");
        List<String> bulletIdList = Arrays.asList(arr);
        if (1 == Integer.valueOf(releaseStatus)) {
            for (int i = 0; i < bulletIdList.size(); i++) {
                Integer bulletId = Integer.valueOf(bulletIdList.get(i));
                // 广播
                erpBroadcastService.insertBulletBroadcast(cityId, bulletId, paramMap.getMap());
            }
        }
        adminBulletMapper.updateBulletByPrimaryKeys(cityId, bulletIdList, paramMap.getMap());
    }

    @Override
    public List<ErpFunDeal> getDealListOrderByDealIdDesc(String shardDbName, Integer lastDealId) {
        List<ErpFunDeal> dealList = erpFunDealMapper.getDealListOrderByDealIdDesc(shardDbName, lastDealId);
        List<ErpDealTrack> dealTrackList = new LinkedList<>();
        for (ErpFunDeal erpDeal : dealList) {
            ErpDealTrack dealTrack = new ErpDealTrack();
            dealTrack.setDealId(erpDeal.getDealId());
            dealTrackList.add(dealTrack);
        }
        if (!dealTrackList.isEmpty()) {
            erpDealTrackMapper.insertList(shardDbName, dealTrackList);
        }
        return dealList;
    }

    /**
     * title ：发起pos机支付
     * athor：lcb
     * date  : 2017/10/23
     */
    @Transactional
    @Override
    public Map<String, Object> initiationOfPayments(String financeType, String financeIds, Integer dealId, Integer cityId, Integer compId,
                                                    Integer deptId, Integer userId, String userName, String deptName) {
        // 目前是直接修改支付方式 1:诚意金 2：合同

        Map<String, Object> resMap = new HashMap<>();
        String[] pfIds = financeIds.split(",");
        String financeNames = "";
        String buildName = "";
        BigDecimal totalAmount = new BigDecimal(0);
        if (Constants_DIC.LAKLA_POS_PAY_TYPE_1.equals(financeType)) {
            financeNames = "诚意金";
            Set<Integer> earbestIdSet = new HashSet<>();
            for (String pfId : pfIds) {
                earbestIdSet.add(Integer.valueOf(pfId));
            }
            if (earbestIdSet.size() == 0) {
                return null;
            }

            ErpEarbestMoneyExample erpEarbestMoneyExample = new ErpEarbestMoneyExample();
            erpEarbestMoneyExample.setShardCityId(cityId);
            erpEarbestMoneyExample.createCriteria().andEarbestIdIn(new ArrayList<>(earbestIdSet)).andCompIdEqualTo(compId).andIsDelEqualTo(new Byte("0"));
            List<ErpEarbestMoney> erpEarbestMonies = erpEarbestMoneyMapper.selectByExample(erpEarbestMoneyExample);

            // 待提交数据
            ErpPosPaymentOrder erpPosPaymentOrder = new ErpPosPaymentOrder();
            erpPosPaymentOrder.setShardCityId(cityId);
            erpPosPaymentOrder.setCompId(compId);

            erpPosPaymentOrder.setCreationTime(new Date());
            erpPosPaymentOrder.setFinanceType(new Byte("1"));
            erpPosPaymentOrder.setCreateUid(userId);
            for (ErpEarbestMoney erpEarbestMoney : erpEarbestMonies) {
                // 101/102
                deptId = erpEarbestMoney.getDeptId();
                buildName = erpEarbestMoney.getBuildName();
                totalAmount = totalAmount.add(new BigDecimal(erpEarbestMoney.getReceiptMoney()));
                erpPosPaymentOrder.setDeptId(erpEarbestMoney.getDeptId());
                erpEarbestMoney.setShardCityId(cityId);
                erpPosPaymentOrder.setShardCityId(cityId);
                erpPosPaymentOrder.setFinanceMoney(new BigDecimal(erpEarbestMoney.getReceiptMoney()));
                erpPosPaymentOrder.setFinanceName("诚意金");
                erpPosPaymentOrder.setCaseType(100 + Integer.valueOf(erpEarbestMoney.getPerformanceName()));
                erpPosPaymentOrder.setFinanceId(erpEarbestMoney.getEarbestId());
                erpPosPaymentOrder.setPayUserName("客户-" + erpEarbestMoney.getCustName());
                erpPosPaymentOrder.setCaseNo(erpEarbestMoney.getCaseNo());
                erpEarbestMoney.setPaymentType("POS机支付");
                erpEarbestMoneyMapper.updateByPrimaryKeySelective(erpEarbestMoney);
                erpPosPaymentOrder.setPaymentId(-1);
                erpPosPaymentOrderMapper.insertSelective(erpPosPaymentOrder);
            }
        } else {
            Set<Integer> pfIdsSet = new HashSet<>();
            for (String pfId : pfIds) {
                pfIdsSet.add(Integer.valueOf(pfId));
            }

            if (pfIdsSet.size() == 0) {
                return null;
            }

            ErpFunDeal erpFunDeal = new ErpFunDeal();
            erpFunDeal.setShardCityId(cityId);
            erpFunDeal.setDealId(dealId);

            erpFunDeal = erpFunDealMapper.selectByPrimaryKey(erpFunDeal);
            if (null == erpFunDeal) {
                return null;
            }
            deptId = erpFunDeal.getSignUserDeptId();

            String custName = erpFunDeal.getBuyOwnerName();
            String ownerNameName = erpFunDeal.getSellOwnerName();

            ErpProcessFinancExample erpProcessFinancExample = new ErpProcessFinancExample();
            erpProcessFinancExample.setShardCityId(cityId);
            erpProcessFinancExample.createCriteria().andPfIdIn(new ArrayList<>(pfIdsSet)).andCompIdEqualTo(compId).andPfActualEqualTo(new Byte("0"));

            List<ErpProcessFinanc> erpProcessFinancs = erpProcessFinancMapper.selectByExample(erpProcessFinancExample);

            // 待提交数据
            ErpPosPaymentOrder erpPosPaymentOrder = new ErpPosPaymentOrder();
            erpPosPaymentOrder.setShardCityId(cityId);
            erpPosPaymentOrder.setCompId(compId);

            erpPosPaymentOrder.setCreationTime(new Date());
            erpPosPaymentOrder.setDealId(dealId);
            erpPosPaymentOrder.setFinanceType(new Byte("2"));
            erpPosPaymentOrder.setCreateUid(userId);
            buildName = erpFunDeal.getBuildName();
            for (ErpProcessFinanc erpProcessFinanc : erpProcessFinancs) {
                financeNames = erpProcessFinanc.getPfName() + ",";
                totalAmount = totalAmount.add(erpProcessFinanc.getPayAmount());
                erpProcessFinanc.setShardCityId(cityId);
                String pfPayer = erpProcessFinanc.getPfPayer();
                erpPosPaymentOrder.setDeptId(erpFunDeal.getSignUserDeptId());
                //  1:客户2:业主
                if ("1".equals(pfPayer)) {
                    erpPosPaymentOrder.setPayUserName("客户-" + custName);
                } else {
                    erpPosPaymentOrder.setPayUserName("业主-" + ownerNameName);
                }
                erpPosPaymentOrder.setFinanceId(erpProcessFinanc.getPfId());
                erpPosPaymentOrder.setCaseType(erpFunDeal.getDealType().intValue());
                erpPosPaymentOrder.setFinanceMoney(erpProcessFinanc.getPayAmount());
                erpPosPaymentOrder.setFinanceName(erpProcessFinanc.getPfName());
                erpPosPaymentOrder.setCaseNo(erpFunDeal.getDealHouseNo());
                erpPosPaymentOrder.setPaymentId(erpProcessFinanc.getPaymentId());
                erpPosPaymentOrderMapper.insertSelective(erpPosPaymentOrder);
                erpProcessFinanc.setPaymentType(2);
                erpProcessFinanc.setPayTypeDesc("POS机支付");
                erpProcessFinancMapper.updateByPrimaryKeySelective(erpProcessFinanc);
            }
        }

        if (financeNames.endsWith(",")) {
            financeNames = StringUtils.stripEnd(financeNames, ",");
        }

        if (pfIds.length > 0) {
            // 诚意金日志
            if (Constants_DIC.LAKLA_POS_PAY_TYPE_1.equals(financeType)) {
                // 循环生成日志FUN_EARBEST_MONEYRECORD
                ErpFunEarbestMoneyrecord erpFunEarbestMoneyrecord = new ErpFunEarbestMoneyrecord();
                for (String earbestId : pfIds) {
                    erpFunEarbestMoneyrecord.setShardCityId(cityId);
                    erpFunEarbestMoneyrecord.setCompId(compId);
                    erpFunEarbestMoneyrecord.setCreateTime(new Date());
                    erpFunEarbestMoneyrecord.setCreateUser(userId);
                    erpFunEarbestMoneyrecord.setLogContent(deptName + "店" + userName + "生成了POS收款订单");
                    erpFunEarbestMoneyrecord.setEarbestId(Integer.valueOf(earbestId));
                    erpFunEarbestMoneyrecordMapper.insertSelective(erpFunEarbestMoneyrecord);
                }
            } else {

                if (StringUtils.isNotBlank(financeNames)) {
                    // 合同日志
                    ErpFunDealRecord erpFunDealRecord = new ErpFunDealRecord();
                    erpFunDealRecord.setShardCityId(cityId);
                    erpFunDealRecord.setCompId(compId);
                    erpFunDealRecord.setDeptId(deptId);
                    erpFunDealRecord.setUpdateUserName(userName);
                    erpFunDealRecord.setUpdateType(new Byte("1"));
                    erpFunDealRecord.setUpdateUid(userId);
                    erpFunDealRecord.setAgreementNo(dealId + "");
                    erpFunDealRecord.setPfActual(new Byte("0"));
                    erpFunDealRecord.setTrackContent(deptName + "店" + userName + "生成了" + financeNames + " " + totalAmount.toString() + "元的POS收款订单");
                    erpFunDealRecord.setUpdateDate(DateUtil.DateToString(new Date()));
                    erpFunDealRecord.setUpdateClassic("[POS收款]");
                    erpFunDealRecordMapper.insertSelective(erpFunDealRecord);
                }

            }
        }
        resMap.put("deptId", deptId);
        resMap.put("buildName", buildName);
        resMap.put("totalAmount", totalAmount);
        resMap.put("financeNames", financeNames);
        return resMap;
    }

    /**
     * @tag 完成一条合同记录 写入以下 1.跟进与提醒任务 2.合同成交数据 3.合同记录
     * @author 邓永洪
     * @since 2018/5/30
     */
    @Transactional
    @Override
    public void createAgreement(Integer cityId, ErpFunDeal funDeal, String trackContent, Map<String, Object> resultMap, InsertDealInfoParam param) {
    	
    	funDeal.setShardCityId(param.getCityId());

        if (param.getDeptType() != null && param.getDeptType() == 6) {
            funDeal.setFinancName("已结清");
        }
        erpFunDealMapper.insertSelective(funDeal);
//		Integer isAllow = StringUtil.paseInteger(erpSysParaMapper.getParamValue(cityId,param.getSelfCompId(),"ALLOW_UNUSE_DEALNO_ISBYHAND"));//允许手动录入未使用的自动分配的合同编号 1是0否
        updateFunDealCode(cityId, funDeal.getContractNo(), funDeal.getCodeId());
        // 2.写跟进
        resultMap.putAll(erpFunTrackService.writeTrackInfoToDeal(cityId, funDeal, trackContent, param));
        // 3.创建默认的财务和业绩
        erpProcessFinanceService.createDefaultFinancForDeal(param, funDeal);// 增加应收财务,并将佣金总额返回
        updateNeedandRealIncomeOffDeal(param.getCityId(), funDeal);
        erpFunProfitService.createDefaultProfitForDeal(funDeal, param);// 将所有的佣金作为业绩分配给经纪人
        // 4.修改房客源状态
        houseCustStatuChange(funDeal, param, Const.DIC_HOUSE_STATUS_INNERDEAL);
        // 5.写合同更新日志

        // 从任务中来的合同，将任务自动完成
        Integer taskId = param.getTaskId();
        if (null != taskId) {
            ErpFunTask funTask = new ErpFunTask();
            funTask.setTaskStatus(Const.DIC_TASK_STATUS_COMPLETE);
            funTask.setTaskId(taskId);
            erpFunTaskMapper.updateByPrimaryKeySelective(funTask);
        }
        erpDealUserRelativeService.createDealUserRelative(cityId, param.getSelfCompId(), funDeal);

        // 处理合作数据
        if(null != param.getCooperateId()) {
            dealCooperatePaymentData(cityId, funDeal.getCompId(), funDeal.getDealId(), funDeal.getDealType().intValue(), param.getCooperateId());
        }
    }

    // 处理合作数据
    private void dealCooperatePaymentData(Integer cityId,Integer compId, Integer dealId, Integer dealType, Integer cooperateId) {
        // 新建关联信息
        erpFunDealMapper.insertCooperateDealRelative(cityId, compId, dealId, cooperateId);
        AdminOnlinePaymentOrderExample adminOnlinePaymentOrderExample = new AdminOnlinePaymentOrderExample();
        adminOnlinePaymentOrderExample.createCriteria().andBusinessIdEqualTo(cooperateId).andBusinessTypeEqualTo((byte) 1).andPaymentStatusEqualTo((byte) 1).
                andOrderTypeEqualTo((byte) 1);
        List<AdminOnlinePaymentOrder> adminOnlinePaymentOrders = adminOnlinePaymentOrderMapper.selectByExample(adminOnlinePaymentOrderExample);
        if(adminOnlinePaymentOrders.size() == 0) {
            return;
        }

        // 查询自己所得款项
        Map<Integer, AdminOnlinePaymentOrder> orderMap = adminOnlinePaymentOrders.stream().collect(Collectors.toMap(val -> val.getId(), val->val));
        List<Integer> orderId = adminOnlinePaymentOrders.stream().collect(Collectors.mapping(val -> val.getId(), Collectors.toList()));

        AdminOnlinePaymentOrderPayeeExample adminOnlinePaymentOrderPayeeExample = new AdminOnlinePaymentOrderPayeeExample();
        adminOnlinePaymentOrderPayeeExample.createCriteria().andOrderIdIn(orderId);
        List<AdminOnlinePaymentOrderPayee> adminOnlinePaymentOrderPayees = adminOnlinePaymentOrderPayeeMapper.selectByExample(adminOnlinePaymentOrderPayeeExample);

        Integer paymentId = null;
        if(Const.DIC_CASE_TYPE_SALE_DEAL.equals(dealType)){
            ErpFunFinancPayment erpFunFinancPayment = getDefaultProcessFinanc("佣金",cityId,compId);
            if(null != erpFunFinancPayment) {
                paymentId = erpFunFinancPayment.getPaymentId();
            }
        }else if(Const.DIC_CASE_TYPE_RENT_DEAL.equals(dealType)){
            ErpFunFinancPayment erpFunFinancPayment = getDefaultProcessFinanc("租赁佣金",cityId,compId);
            if(null != erpFunFinancPayment) {
                paymentId = erpFunFinancPayment.getPaymentId();
            }
        }

        // 处理订单到实收款项上去
        for (AdminOnlinePaymentOrderPayee orderPayee : adminOnlinePaymentOrderPayees) {
            if(!orderPayee.getCompId().equals(compId)) {
                continue;
            }
            AdminOnlinePaymentOrder adminOnlinePaymentOrder = orderMap.get(orderPayee.getOrderId());

            ErpProcessFinanc erpProcessFinanc = new ErpProcessFinanc();
            erpProcessFinanc.setPfName(adminOnlinePaymentOrder.getPfName());
            erpProcessFinanc.setShardCityId(cityId);
            erpProcessFinanc.setAuditStatus("1");
            erpProcessFinanc.setAuditTime(new Date());
            erpProcessFinanc.setPaymentId(paymentId);
            erpProcessFinanc.setCompId(compId);
            erpProcessFinanc.setCreateTime(adminOnlinePaymentOrder.getPaymentTime());
            erpProcessFinanc.setCreateUid(999);
            erpProcessFinanc.setDealId(dealId);
            erpProcessFinanc.setPayAmount(orderPayee.getReceivedAmount());
            erpProcessFinanc.setPayType(3);
            erpProcessFinanc.setPfTime(new Date());
            erpProcessFinanc.setPfActual((byte) 1);
            erpProcessFinanc.setPfPayer(adminOnlinePaymentOrder.getPayer() + "");
            erpProcessFinanc.setPfGeter(Const.DIC_PFMAN_BROKER);
            if(Const.DIC_CASE_TYPE_SALE_DEAL.equals(dealType)){
                erpProcessFinanc.setPerformanceType((byte)2);//二手佣金
            }else if(Const.DIC_CASE_TYPE_RENT_DEAL.equals(dealType)){
                erpProcessFinanc.setPerformanceType((byte)4);//租赁佣金
            }

            erpProcessFinanc.setReceiptMoneyUser(adminOnlinePaymentOrder.getUserId());
            erpProcessFinanc.setReceiptMoneyDept(adminOnlinePaymentOrder.getDeptId());
            erpProcessFinanc.setPayTypeDesc("在线支付");
            erpProcessFinanc.setPfDesc("合作收款转入");

            erpProcessFinancMapper.insertSelective(erpProcessFinanc);
        }


    }

    private ErpFunFinancPayment getDefaultProcessFinanc(String name, Integer cityId, Integer compId) {
        ErpFunFinancPaymentExample funFinancPaymentExample = new ErpFunFinancPaymentExample();
        funFinancPaymentExample.setShardCityId(cityId);
        funFinancPaymentExample.createCriteria().andCompIdEqualTo(compId).andCanDelEqualTo(0).andPaymentNameEqualTo(name);
        List<ErpFunFinancPayment> erpFunFinancPayments = erpFunFinancPaymentMapper.selectByExample(funFinancPaymentExample);
        if(erpFunFinancPayments.size() > 0) {
            return erpFunFinancPayments.get(0);
        }
        return null;
    }


    /**
     * @tag 修改和更新权证流程的合同信息
     * @author 邓永洪
     * @since 2018/6/14
     */
    @Transactional
    @Override
    public void updateDealShenheInfo(UpdateDealAuditStatusParam param, ErpFunDeal oldDeal) {
        ErpFunDeal updateModel = new ErpFunDeal();
        Integer cityId = param.getCityId();
        Integer dealComplete = param.getDealAuditStatus();
        updateModel.setDealAuditStatus(dealComplete.byteValue());
        updateModel.setUpdateTime(new Date());
        updateModel.setCompleteDate(DateTimeHelper.getTimeNow());
        updateModel.setCompleteUser(param.getCityId());
        updateModel.setCompleteUserName(param.getSelfUserName());
        if (Const.DIC_DEAL_COMPLETE_FAIL.equals(dealComplete.byteValue())) {// 审核未通过,撤销合同
            // 租房合同在撤销时需要删除之前填写的提醒任务
            if (Const.DIC_CASE_TYPE_RENT_DEAL.equals(oldDeal.getDealType())) {
                if (null != oldDeal.getCustDuetimeTaskId()) {
                    ErpFunTaskExample taskExample = new ErpFunTaskExample();
                    taskExample.setShardCityId(cityId);
                    taskExample.createCriteria().andTaskIdEqualTo(oldDeal.getCustDuetimeTaskId()).andCompIdEqualTo(oldDeal.getCompId());
                    erpFunTaskMapper.deleteByExample(taskExample);
                    updateModel.setCustDuetimeTaskId(null);
                }
                if (null != oldDeal.getHouseDuetimeTaskId()) {
                    ErpFunTaskExample taskExample = new ErpFunTaskExample();
                    taskExample.setShardCityId(cityId);
                    taskExample.createCriteria().andTaskIdEqualTo(oldDeal.getHouseDuetimeTaskId()).andCompIdEqualTo(oldDeal.getCompId());
                    erpFunTaskMapper.deleteByExample(taskExample);
                    updateModel.setHouseDuetimeTaskId(null);
                }
            }
            InsertDealInfoParam dealInfoParam = new InsertDealInfoParam();
            dealInfoParam.setPersonalVersion(param.isPersonalVersion());
            dealInfoParam.setSelfCompType(param.getSelfCompType());
            dealInfoParam.setSelfDeptName(param.getSelfDeptName());
            dealInfoParam.setSelfUserName(param.getSelfUserName());
            dealInfoParam.setSelfUserId(param.getSelfUserId());
            dealInfoParam.setSelfDeptId(param.getSelfDeptId());
            dealInfoParam.setSelfCompId(param.getCompId());
            dealInfoParam.setSelfArchiveId(param.getSelfArchiveId());
            dealInfoParam.setSelfGrId(param.getSelfGrId());
            dealInfoParam.setSelfAreaId(param.getSelfAreaId());
            dealInfoParam.setSelfRegId(param.getSelfRegId());
            dealInfoParam.setCityId(cityId);
            houseCustStatuChange(oldDeal, dealInfoParam, Const.DIC_HOUSE_STATUS_AVAILABLE);
            // 创建合同撤销相关的房客源跟进（即 内成交转有效）
            GeneralParam generalParam = new GeneralParam();
            generalParam.setCityId(cityId);
            generalParam.setCompId(param.getSelfCompId());
            generalParam.setUserId(param.getSelfUserId());
            generalParam.setUserName(param.getSelfUserName());
            erpFunTrackService.createTrackForUndoDeal(generalParam, oldDeal);

            // 清除掉该合同的财务业绩等信息
            ErpProcessFinancExample financExample = new ErpProcessFinancExample();
            financExample.setShardCityId(cityId);
            financExample.createCriteria().andCompIdEqualTo(param.getSelfCompId()).andDealIdEqualTo(oldDeal.getDealId());
            erpProcessFinancMapper.deleteByExample(financExample);
            //同步作废票据
            ErpFunBill funBill = new ErpFunBill();
            funBill.setBillStatus((byte) 2);
            ErpFunBillExample erpFunBillExample = new ErpFunBillExample();
            erpFunBillExample.setShardCityId(cityId);
            erpFunBillExample.createCriteria().andCompIdEqualTo(param.getSelfCompId()).andDealIdEqualTo(oldDeal.getDealId());
            erpFunBillMapper.updateByExampleSelective(funBill, erpFunBillExample);

            ErpFunProfitExample profitExample = new ErpFunProfitExample();
            profitExample.setShardCityId(cityId);
            profitExample.createCriteria().andCompIdEqualTo(param.getSelfCompId()).andUserIdGreaterThan(0).andDealIdEqualTo(oldDeal.getDealId());
            List<ErpFunProfit> funProfits = erpFunProfitMapper.selectByExample(profitExample);
            if (!funProfits.isEmpty()) {
                String archiveIds = funProfits.stream().filter(val->(null != val.getArchiveId())).map(val -> val.getArchiveId() + "").collect(Collectors.joining(","));
                erpFunProfitService.countProfitStandard(cityId, param.getSelfCompId(), archiveIds);
            }
            //清除合同的业绩数据
            ErpFunProfitExample erpFunProfitExample = new ErpFunProfitExample();
            erpFunProfitExample.setShardCityId(cityId);
            erpFunProfitExample.createCriteria().andCompIdEqualTo(param.getSelfCompId()).andDealIdEqualTo(oldDeal.getDealId());
            erpFunProfitMapper.deleteByExample(erpFunProfitExample);
            BigDecimal zero = new BigDecimal(0);
            updateModel.setTotalNeedIncome(zero);
            updateModel.setTotalRealIncome(zero);
            updateModel.setTotalNeedPerformance(zero);
            updateModel.setTotalRealPerformance(zero);
            //合同编号逻辑
            if (null != oldDeal.getCodeId()) {
                String isCan = erpSysParaMapper.getParamValue(cityId, param.getSelfCompId(), "INVALID_DEALNO_CAN_USE_AGAIN");
                if ("1".equals(isCan)) {
                    ErpFunDealCodeExample codeExample = new ErpFunDealCodeExample();
                    codeExample.setShardCityId(cityId);
                    codeExample.createCriteria().andStatusEqualTo((byte) 1).andCodeIdEqualTo(oldDeal.getCodeId());
                    List<ErpFunDealCode> dealCodes = erpFunDealCodeMapper.selectByExample(codeExample);
                    if (!dealCodes.isEmpty() && null != dealCodes.get(0)) {
                        ErpFunDealCodelogExample dealCodelogExample = new ErpFunDealCodelogExample();
                        dealCodelogExample.setShardCityId(cityId);
                        dealCodelogExample.createCriteria().andCodeNoEqualTo(oldDeal.getContractNo()).
                                andCompIdEqualTo(param.getSelfCompId()).andCodeIdEqualTo(oldDeal.getCodeId());
                        ErpFunDealCodelog dealCodelog = new ErpFunDealCodelog();
                        dealCodelog.setUseStatus((byte) 0);
                        erpFunDealCodelogMapper.updateByExampleSelective(dealCodelog, dealCodelogExample);
                        erpFunDealCodeMapper.updateUsedCount(cityId, param.getSelfCompId(), oldDeal.getCodeId());
                    }
                }
            }
        }
        updateModel.setDealId(oldDeal.getDealId());
        updateModel.setShardCityId(cityId);
        updateModel.setFirstTrialCompleteDate(param.getFirstTrialCompleteDate());
        updateModel.setRecheckCompleteDate(param.getRecheckCompleteDate());
        updateModel.setInvalidCompleteDate(param.getInvalidCompleteDate());
        erpFunDealMapper.updateByPrimaryKeySelective(updateModel);
    }

    @Transactional
    @Override
    public void makingDeal(GeneralParam generalParam, Integer dealId) {
        Integer cityId = generalParam.getCityId();

        // 2019-3-28 办结和反办结只修改总状态,不修改步骤到跳过状态
//		ErpProcessRuntimeStep runtimeStepupdateModel = new ErpProcessRuntimeStep();
//		runtimeStepupdateModel.setRunstepStatus(Const.DIC_RUNSTEP_STATUS_SKIP);
//		ErpProcessRuntimeStepExample processRuntimeStepExample = new ErpProcessRuntimeStepExample();
//		processRuntimeStepExample.setShardCityId(cityId);
//		processRuntimeStepExample.createCriteria().andDealIdEqualTo(dealId).andRunstepStatusLessThan(Const.DIC_RUNSTEP_STATUS_SUCCESS).andDelFlagEqualTo((byte) 0);
//		//跳过所有未完成的流程步骤
//		erpProcessRuntimeStepMapper.updateByExampleSelective(runtimeStepupdateModel, processRuntimeStepExample);
        String nodeName = null;
        ErpProcessRuntimeStepExample erpProcessRuntimeStepExample = new ErpProcessRuntimeStepExample();
        erpProcessRuntimeStepExample.setShardCityId(cityId);
        erpProcessRuntimeStepExample.createCriteria().andDealIdEqualTo(dealId).andDelFlagEqualTo((byte) 0);
        erpProcessRuntimeStepExample.setOrderByClause("STEP_SEQ DESC");
        List<ErpProcessRuntimeStep> nodeNow = erpProcessRuntimeStepMapper.selectByExample(erpProcessRuntimeStepExample);
        if (nodeNow != null && nodeNow.size() > 0) {
            nodeName = nodeNow.get(0).getStepName();
        }
        // 插入流程日志（全流程办结时）
        Date now = new Date();
        ErpFunDeal funDeal = erpFunDealMapper.getFunDealById(cityId, generalParam.getCompId(), dealId);
        funDeal.setProcessStatus(Const.DIC_DEAL_STATUS_TRANSACT);
        funDeal.setProcessEndTime(now);
        String trackContent = generalParam.getCurrDeptUserName() + " 进行了全流程办结";
        erpFunProcessRecordService.insert4UpdateStep(generalParam, dealId, nodeName, null,
                Const.DIC_DEAL_UPDATE_CLASSIC_PROCESSCREATEALLDEAL, trackContent, null);
        //更改合同状态为已办结
        ErpFunDeal updateModel = new ErpFunDeal();
        updateModel.setDealId(dealId);
        updateModel.setUpdateTime(now);
        // 办结的时候,合同上stepName遵循以前的规则不改变
//		updateModel.setRunstepName(nodeName);
        updateModel.setProcessStatus(Const.DIC_DEAL_STATUS_TRANSACT);
        updateModel.setProcessEndTime(now);
        updateModel.setShardCityId(cityId);
        erpFunDealMapper.updateByPrimaryKeySelective(updateModel);
        // 合同日志
        String dealTrackContent = generalParam.getCurrDeptUserName() + " 将该合同的流程状态修改为已办结";
        String updateClassic = Const.DIC_DEAL_UPDATE_CLASSIC_DEAL;
        erpFunDealRecordService.writeDealRecord(generalParam, dealId, null, updateClassic, (byte) 0, dealTrackContent,
                1, null, false, null);
        String taskType = Const.DIC_TASK_TYPE_CONTRACT_REMIND_STR;
        String taskSubJect = taskType + " " + generalParam.getCurrDeptUserName() + " 办结了编号" + funDeal.getContractNo() + "的合同";
        List<ErpFunUsers> list = erpFunUsersService.getTaskUserList(cityId, dealId, 0, generalParam.getCompId(), generalParam.getUserId());
        erpFunTaskService.createDealWarmTask(funDeal.getDealType(), dealId, funDeal.getContractNo(), list, taskSubJect,
                Const.DIC_TASK_TYPE_CONTRACT_REMIND, taskSubJect, generalParam.getUserId(), generalParam.getCityId(), generalParam.getDeptId(), generalParam.getCompId());
    }

    /**
     * @tag 合同流程反办结
     * @author 邓永洪
     * @since 2018/6/20
     */
    @Transactional
    @Override
    public void completionProcess(GeneralParam generalParam, Integer dealId, String modelName) {
        ErpFunDeal updateModel = new ErpFunDeal();
        updateModel.setDealId(dealId);
        updateModel.setProcessStatus(Const.DIC_DEAL_STATUS_DOING);
        updateModel.setProcessEndTime(null);
        updateModel.setShardCityId(generalParam.getCityId());
        erpFunDealService.updateProcessEndTime(updateModel);
        String trackContent = generalParam.getCurrDeptUserName() + " 撤销了办结合同的" + modelName + "流程";
        erpFunProcessRecordService.insert4UpdateStep(generalParam, dealId, null, null,
                Const.DIC_DEAL_UPDATE_CLASSIC_PROCESSCOMPLETION, trackContent, null);
        // 合同日志
        String dealTrackContent = generalParam.getCurrDeptUserName() + " 撤销了办结合同";
        String updateClassic = Const.DIC_DEAL_UPDATE_CLASSIC_DEAL_COUNT;
        erpFunDealRecordService.writeDealRecord(generalParam, dealId, null, updateClassic, (byte) 0, dealTrackContent,
                1, null, false, null);
    }

    /**
     * @tag 更新合同过户日期过户日期、取证日期、放款日期 和流程负责人信息的变更
     * @author 邓永洪
     * @since 2018/6/22
     */
    @Transactional
    @Override
    public void updateWarrantsDates(GeneralParam generalParam, ErpFunDeal model) {
        Integer cityId = generalParam.getCityId();
        model.setShardCityId(cityId);
        model.setUpdateTime(new Date());
        model.setUpdateUid(generalParam.getUserId());
        if (StringUtils.isBlank(model.getEvidenceDate())) {
            model.setEvidenceDate(null);
        }
        if (StringUtils.isBlank(model.getTransferDate())) {
            model.setTransferDate(null);
        }
        ErpFunDeal oldModel = erpFunDealMapper.selectByDealId(cityId, model.getDealId(), null);
        erpFunDealMapper.updateWarrantsDates(model);

        Integer dealUserId = model.getDealUserId();
        if (null != dealUserId) {
            ErpDealUserRelativeExample dealUserRelativeExample = new ErpDealUserRelativeExample();
            dealUserRelativeExample.setShardCityId(cityId);
            dealUserRelativeExample.createCriteria().andDealIdEqualTo(model.getDealId())
                    .andCompIdEqualTo(generalParam.getCompId()).andRelateTypeEqualTo(Const.DIC_RELATE_TYPE_DEALUSER);
            erpDealUserRelativeMapper.deleteByExample(dealUserRelativeExample);
            ErpFunUsers funUsers = erpFunUsersMapper.getFunUserByUserId(cityId, dealUserId);
            if (null != funUsers) {
                ErpDealUserRelative dealUserRelative = new ErpDealUserRelative();
                dealUserRelative.setCompId(generalParam.getCompId());
                dealUserRelative.setArchiveId(funUsers.getArchiveId());
                dealUserRelative.setAreaId(funUsers.getAreaId());
                dealUserRelative.setDealId(model.getDealId());
                dealUserRelative.setRegId(funUsers.getRegId());
                dealUserRelative.setDeptId(funUsers.getDeptId());
                dealUserRelative.setGrId(funUsers.getGrId());
                dealUserRelative.setRelateType(Const.DIC_RELATE_TYPE_DEALUSER);
                dealUserRelative.setUserId(dealUserId);
                dealUserRelative.setShardCityId(cityId);
                dealUserRelative.setOrganizationPath(funUsers.getTissueLine());
                dealUserRelative.setOrg1(funUsers.getOrg1());
                dealUserRelative.setOrg2(funUsers.getOrg2());
                dealUserRelative.setOrg3(funUsers.getOrg3());
                dealUserRelative.setOrg4(funUsers.getOrg4());
                dealUserRelative.setOrg5(funUsers.getOrg5());
                dealUserRelative.setOrg6(funUsers.getOrg6());
                dealUserRelative.setOrg7(funUsers.getOrg7());
                dealUserRelative.setOrg8(funUsers.getOrg8());
                dealUserRelative.setOrg9(funUsers.getOrg9());
                dealUserRelative.setOrg10(funUsers.getOrg10());
                dealUserRelative.setOrg11(funUsers.getOrg11());
                dealUserRelative.setOrg12(funUsers.getOrg12());
                dealUserRelative.setOrg13(funUsers.getOrg13());
                dealUserRelative.setOrg14(funUsers.getOrg14());
                erpDealUserRelativeMapper.insertSelective(dealUserRelative);
            }
        }
        // 插入合同日志
        String updateContent = model.getUpdateContent(oldModel);
        if (!CommonUtil.isnull(updateContent)) {
            String arr[] = updateContent.split("、");
            if (arr.length == 1) {
                updateContent = arr[0];
            } else {
                updateContent += "等";
            }
        }
        if (model != null) {
            if (oldModel.getDealUserId() != null) {
                if (!oldModel.getDealUserId().equals(model.getDealUserId())) {
                    String trackContent = generalParam.getCurrDeptUserName() + " 修改了流程总负责人";
                    erpFunProcessRecordService.insert4UpdateStep(generalParam, model.getDealId(), null, null,
                            Const.DIC_DEAL_UPDATE_CLASSIC_PROCESSINFO, trackContent, null);
                }
            }
        }
        erpProcessRuntimeStepService.updateStepExcutorOfNotDoing(cityId, generalParam.getCompId(), model.getDealId(), model.getDealUserId(), "DEAL_USER");
        if (StringUtils.isNotBlank(updateContent)) {
            String trackContent = generalParam.getCurrDeptUserName() + " 修改了" + updateContent + "信息";
            erpFunDealRecordService.writeDealRecord(generalParam, model.getDealId(), null, Constants_DIC.DIC_DEAL_UPDATE_CLASSIC_DEALEDIT, (byte) 0
                    , trackContent, 1, null, true, null);
        }
    }

    /**
     * @tag 修改房客源状态
     * @author 邓永洪
     * @since 2018/5/31
     */
    private void houseCustStatuChange(ErpFunDeal funDeal, InsertDealInfoParam param, Byte stauts) {
        Integer cityId = param.getCityId();
        Map<String, Object> fieldsHMhouse = new HashMap<>();
        Map<String, Object> fieldsHMCust = new HashMap<>();
        Integer dealType = funDeal.getDealType().intValue();
        if (Const.DIC_HOUSE_STATUS_AVAILABLE.equals(stauts)) {
            fieldsHMhouse.put("dealTime", null);
            fieldsHMCust.put("dealTime", null);
            if (Const.DIC_CASE_TYPE_RENT_DEAL.equals(dealType)) {
                fieldsHMhouse.put("dueTime", null);
                fieldsHMCust.put("dueTime", null);
            }
        } else if (Const.DIC_HOUSE_STATUS_INNERDEAL.equals(stauts)) {
            Date now = new Date();
            fieldsHMhouse.put("dealTime", now);
            fieldsHMhouse.put("updateTime", now);
            fieldsHMCust.put("dealTime", now);
            fieldsHMCust.put("updateTime", now);
            Integer houseId = funDeal.getDealHouseId();
            Integer custId = funDeal.getDealCustomerId();
            Byte plateTypeHouse = null;
            Byte plateTypeCust = null;
            if (Const.DIC_CASE_TYPE_RENT_DEAL.equals(dealType)) {
                if (null != houseId) {
                    ErpFunLease funLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, houseId);
                    plateTypeHouse = funLease.getPlateType();
                    if (funLease.getArchiveId() != null) {
                        erpFunHouseBiddingMapper.updateFunHouseBiddingYyStatus(param.getCityId(), Const.DIC_CASE_TYPE_LEASE_FUN, houseId, param.getSelfArchiveId());
                    }
                }
                if (null != custId) {
                    ErpFunRentCustomer rentCustomer = erpFunRentCustomerMapper.getRentCustomerByCustId(cityId, custId);
                    plateTypeCust = rentCustomer.getPlateType();
                }
            } else {
                if (null != houseId) {
                    ErpFunSale funSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, houseId);
                    plateTypeHouse = funSale.getPlateType();
                    if (funSale.getArchiveId() != null) {
                        erpFunHouseBiddingMapper.updateFunHouseBiddingYyStatus(param.getCityId(), Const.DIC_CASE_TYPE_LEASE_FUN, houseId, param.getSelfArchiveId());
                    }
                }
                if (null != custId) {
                    ErpFunBuyCustomer buyCustomer = erpFunBuyCustomerMapper.getFunBuyCustomer(cityId, custId);
                    plateTypeCust = buyCustomer.getPlateType();
                }
            }
            //如果是私盘制下的公盘信息转为预订、封盘、成交、等涉及到改变状态的逻辑时则将其转为该申请人的私盘
            if (null != houseId) {
                boolean isPrivateModelCust = erpSysParaService.getSysRunModelIsPrivate(Const.DIC_CASE_TYPE_SALE_FUN, cityId, param.getSelfCompId());//房源私盘制
                if (isPrivateModelCust) {//注意这里的隐藏逻辑 私盘下的公盘房源信息被修改状态后信息要变成修改人的信息
                    if (plateTypeHouse.equals(Const.DIC_PLATE_TYPE_SHARE.byteValue())) {// SHARE 表示公盘数据，PUBLIC表示抢盘数据 这里注意区分
                        fieldsHMhouse.put("plateType", Const.DIC_PLATE_TYPE_PRIVATE);
                        fieldsHMhouse.put("grId", param.getSelfGrId());
                        fieldsHMhouse.put("deptId", param.getSelfDeptId());
                        fieldsHMhouse.put("regId", param.getSelfRegId());
                        fieldsHMhouse.put("areaId", param.getSelfAreaId());
                        fieldsHMhouse.put("userId", param.getSelfUserId());
                        fieldsHMhouse.put("archiveId", param.getSelfArchiveId());
                    }
                }
            }
            //如果是私盘制下的公盘信息转为预订、封盘、成交、等涉及到改变状态的逻辑时则将其转为该申请人的私盘
            if (null != custId) {//注意这里的隐藏逻辑 私盘下的公盘客源信息被修改状态后信息要变成修改人的信息
                boolean isPrivateModelCust = erpSysParaService.getSysRunModelIsPrivate(Const.DIC_CASE_TYPE_BUY_CUST, cityId, param.getSelfCompId());//客源私盘制
                if (isPrivateModelCust) {//注意这里的隐藏逻辑
                    if (plateTypeCust.equals(Constants_DIC.DIC_PLATE_TYPE_SHARE)) {// SHARE 表示公盘数据，PUBLIC表示抢盘数据 这里注意区分
                        fieldsHMCust.put("plateType", Const.DIC_PLATE_TYPE_PRIVATE);
                        fieldsHMCust.put("grId", param.getSelfGrId());
                        fieldsHMCust.put("deptId", param.getSelfDeptId());
                        fieldsHMCust.put("regId", param.getSelfRegId());
                        fieldsHMCust.put("areaId", param.getSelfAreaId());
                        fieldsHMCust.put("userId", param.getSelfUserId());
                        fieldsHMCust.put("archiveId", param.getSelfArchiveId());
                    }
                }
            }
            if (Const.DIC_CASE_TYPE_RENT_DEAL.equals(dealType)) {//租方的数据需要填写到期时间,并写入租期到期提醒
                fieldsHMhouse.put("dueTime", param.getRentOverDate());
                fieldsHMCust.put("dueTime", param.getRentOverDate());
            }
        }

        if (Const.DIC_CASE_TYPE_SALE_DEAL.equals(dealType)) {//出售合同
            Integer houseId = funDeal.getDealHouseId();
            ErpFunSale funSale = BeanUtil.map2Bean(fieldsHMhouse, ErpFunSale.class);
            if (null != houseId) {
                funSale.setSaleStatus(stauts);
                funSale.setSalePublish(false);
                funSale.setSaleLevel((byte) 1);
                funSale.setCityShareFlag((byte) 0);
                funSale.setAdsFlag(Const.DIC_ADS_CASE_STATUS_0);
                // 取消租售关联
                ErpFunSale baseInfoFunSale = erpFunSaleMapper.getHouseBaseInfo(cityId, houseId);

                if (Const.DIC_HOUSE_STATUS_AVAILABLE.equals(stauts)) {
                    // 是否禁止
                    Boolean aBoolean = forbiddenTurnableFlag(cityId, baseInfoFunSale.getCompId(), houseId, (byte) 1);
                    if (!aBoolean) {
                        if (baseInfoFunSale.getSaleLeaseId() != null && baseInfoFunSale.getIsSaleLease() == 1) {
                            funSale.setIsSaleLease((byte) 0);
                            ErpFunLease funLease = new ErpFunLease();
                            funLease.setLeaseId(baseInfoFunSale.getSaleLeaseId());
                            funLease.setIsSaleLease((byte) 0);
                            funLease.setShardCityId(cityId);
                            erpFunLeaseMapper.updateByPrimaryKeySelective(funLease);
                        }
                        funSale.setSaleId(houseId);
                        funSale.setShardCityId(cityId);
                        erpFunSaleMapper.updateByPrimaryKeySelective(funSale);
                        erpFunAdsContentService.cancleAdsContent(cityId, houseId, Const.DIC_CASE_TYPE_SALE_FUN);
                    }
                } else {
                    if (baseInfoFunSale.getSaleLeaseId() != null && baseInfoFunSale.getIsSaleLease() == 1) {
                        funSale.setIsSaleLease((byte) 0);
                        ErpFunLease funLease = new ErpFunLease();
                        funLease.setLeaseId(baseInfoFunSale.getSaleLeaseId());
                        funLease.setIsSaleLease((byte) 0);
                        funLease.setShardCityId(cityId);
                        erpFunLeaseMapper.updateByPrimaryKeySelective(funLease);
                    }
                    funSale.setSaleId(houseId);
                    funSale.setShardCityId(cityId);
                    erpFunSaleMapper.updateByPrimaryKeySelective(funSale);
                    erpFunAdsContentService.cancleAdsContent(cityId, houseId, Const.DIC_CASE_TYPE_SALE_FUN);
                }

            }
            // 客源 ID
            Integer custId = funDeal.getDealCustomerId();
            if (null != custId) {
                ErpFunBuyCustomer buyCustomer = BeanUtil.map2Bean(fieldsHMCust, ErpFunBuyCustomer.class);
                buyCustomer.setBuyCustStatus(stauts);
                fieldsHMhouse.put("leasePublish", false);
                buyCustomer.setShardCityId(cityId);
                buyCustomer.setBuyCustId(custId);
                erpFunBuyCustomerMapper.updateByPrimaryKeySelective(buyCustomer);
            }
        } else if (Const.DIC_CASE_TYPE_RENT_DEAL.equals(dealType)) {
            Integer houseId = funDeal.getDealHouseId();
            Integer custId = funDeal.getDealCustomerId();
            ErpFunLease funLease = BeanUtil.map2Bean(fieldsHMhouse, ErpFunLease.class);
            if (null != houseId) {
                funLease.setLeaseStatus(stauts.intValue());
                funLease.setLeaseLevel((byte) 1);
                funLease.setCityShareFlag((byte) 0);
                funLease.setAdsFlag(Const.DIC_ADS_CASE_STATUS_0);
                // 取消租售关联
                ErpFunLease baseInfoFunLease = erpFunLeaseMapper.getHouseBaseInfo(cityId, houseId);

                if (Const.DIC_HOUSE_STATUS_AVAILABLE.equals(stauts)) {
                    Boolean aBoolean = forbiddenTurnableFlag(cityId, baseInfoFunLease.getCompId(), houseId, (byte) 2);
                    if (!aBoolean) {
                        if (baseInfoFunLease.getSaleLeaseId() != null && baseInfoFunLease.getIsSaleLease() == 1) {
                            funLease.setIsSaleLease((byte) 0);
                            ErpFunSale funSale = new ErpFunSale();
                            funSale.setSaleId(baseInfoFunLease.getSaleLeaseId());
                            funSale.setIsSaleLease((byte) 0);
                            funSale.setShardCityId(cityId);
                            erpFunSaleMapper.updateByPrimaryKeySelective(funSale);
                        }
                        if (Const.DIC_HOUSE_STATUS_INNERDEAL.equals(stauts)) {
                            funLease.setDueTime(DateUtil.StringToDate(fieldsHMhouse.get("dueTime").toString()));
                        }
                        funLease.setLeaseId(houseId);
                        funLease.setShardCityId(cityId);
                        erpFunLeaseMapper.updateByPrimaryKeySelective(funLease);
                        erpFunAdsContentService.cancleAdsContent(cityId, houseId, Const.DIC_CASE_TYPE_LEASE_FUN);
                    }
                } else {
                    if (baseInfoFunLease.getSaleLeaseId() != null && baseInfoFunLease.getIsSaleLease() == 1) {
                        funLease.setIsSaleLease((byte) 0);
                        ErpFunSale funSale = new ErpFunSale();
                        funSale.setSaleId(baseInfoFunLease.getSaleLeaseId());
                        funSale.setIsSaleLease((byte) 0);
                        funSale.setShardCityId(cityId);
                        erpFunSaleMapper.updateByPrimaryKeySelective(funSale);
                    }
                    if (Const.DIC_HOUSE_STATUS_INNERDEAL.equals(stauts)) {
                        funLease.setDueTime(DateUtil.StringToDate(fieldsHMhouse.get("dueTime").toString()));
                    }
                    funLease.setLeaseId(houseId);
                    funLease.setShardCityId(cityId);
                    erpFunLeaseMapper.updateByPrimaryKeySelective(funLease);
                    erpFunAdsContentService.cancleAdsContent(cityId, houseId, Const.DIC_CASE_TYPE_LEASE_FUN);
                }

            }
            if (null != custId) {
                ErpFunRentCustomer rentCustomer = BeanUtil.map2Bean(fieldsHMCust, ErpFunRentCustomer.class);
                rentCustomer.setRentCustStatus(stauts);
                rentCustomer.setRentCustId(custId);
                rentCustomer.setShardCityId(cityId);
                erpFunRentCustomerMapper.updateByPrimaryKeySelective(rentCustomer);
            }
        }

    }

    /**
     * @param
     * @return
     * @title 鸿基 封盘转外成交 后不能转有效
     * @author lcb
     * @since 2019/8/7
     */
    private Boolean forbiddenTurnableFlag(Integer cityId, Integer compId, Integer caseId, Byte caseType) {
        Boolean forbiddenFlag = false;
        Boolean hjCustomer = erpFunCompService.judgeHjCustomer(cityId, compId);
        if (hjCustomer) {

            Set<Integer> caseIds = new HashSet<>();
            caseIds.add(caseId);
            Map<Integer, CommonSelectVO> caseCountMap = erpFunTrackMapper.countDataByCaseIdsAndTrackType(cityId, compId,
                    caseIds, caseType, 13);
            CommonSelectVO commonSelectVO = caseCountMap.get(caseId);

            if (null != commonSelectVO && commonSelectVO.getSelectValue() > 0) {
                forbiddenFlag = true;
            }
        }
        return forbiddenFlag;
    }


    private void updateNeedandRealIncomeOffDeal(Integer cityId, ErpFunDeal funDeal) {
        // 应收总额
        BigDecimal totalNeedPerformance = erpFunDealMapper.sumTotalNeedPerformance(cityId, funDeal.getDealId());
        ErpFunDeal updateModel = new ErpFunDeal();
        boolean flag = false;
        if (null != funDeal.getCommissionRate()) {
            updateModel.setCommissionRate(funDeal.getCommissionRate());
            flag = true;
        }
        if (null != funDeal.getStandardCommission()) {
            updateModel.setStandardCommission(funDeal.getStandardCommission());
            flag = true;
        }
        if (totalNeedPerformance != null) {
            updateModel.setTotalNeedPerformance(totalNeedPerformance);
            funDeal.setTotalNeedPerformance(totalNeedPerformance);
            updateModel.setTotalNeedIncome(totalNeedPerformance);
            funDeal.setTotalNeedIncome(totalNeedPerformance);
            if (Objects.equal(Byte.valueOf(Const.DIC_CASE_TYPE_SALE_DEAL.toString()), funDeal.getDealType())) {
                updateModel.setSecondhandNeedPerformance(totalNeedPerformance);
                funDeal.setSecondhandNeedPerformance(totalNeedPerformance);
            } else if (Objects.equal(Byte.valueOf(Const.DIC_CASE_TYPE_RENT_DEAL.toString()), funDeal.getDealType())) {
                updateModel.setLeaseNeedPerformance(totalNeedPerformance);
                funDeal.setLeaseNeedPerformance(totalNeedPerformance);
            }
            flag = true;
            updateModel.setDealId(funDeal.getDealId());
            updateModel.setShardCityId(cityId);
            if (flag) {
                erpFunDealMapper.updateByPrimaryKeySelective(updateModel);
            }
        }
    }

    private void updateFunDealCode(Integer cityId, String dealNo, Integer codeId) {
        if (codeId == null) {
            return;
        }
        ErpFunDealCode erpFunDealCode = new ErpFunDealCode();
        erpFunDealCode.setCodeId(codeId);
        erpFunDealCode.setShardCityId(cityId);
        ErpFunDealCode funDealCode = erpFunDealCodeMapper.selectByPrimaryKey(erpFunDealCode);
        if (funDealCode.getTotalCount() != null && funDealCode.getTotalCount().equals(funDealCode.getUsedCount())) {
            throw new BusinessException("该合同编号已被其他人使用!");
        }
        erpFunDealCode.setUsedCount(funDealCode.getUsedCount() + 1);
        erpFunDealCodeMapper.updateByPrimaryKeySelective(erpFunDealCode);
        ErpFunDealCodelogExample dealCodelogExample = new ErpFunDealCodelogExample();
        dealCodelogExample.setShardCityId(cityId);
        dealCodelogExample.createCriteria().andCodeNoEqualTo(dealNo).andCodeIdEqualTo(codeId);
        List<ErpFunDealCodelog> erpFunDealCodelogs = erpFunDealCodelogMapper.selectByExample(dealCodelogExample);
        if (!erpFunDealCodelogs.isEmpty() && erpFunDealCodelogs.get(0) != null) {
            ErpFunDealCodelog erpFunDealCodelog = erpFunDealCodelogs.get(0);
            Byte useStatus = erpFunDealCodelog.getUseStatus();
            if (useStatus == 1) {
                throw new BusinessException("该合同编号已被其他人使用!");
            }
        }
        ErpFunDealCodelog dealCodelog = new ErpFunDealCodelog();
        dealCodelog.setUseStatus((byte) 1);
        erpFunDealCodelogMapper.updateByExampleSelective(dealCodelog, dealCodelogExample);
    }

    /**
     * @tag 更新流程主负责人
     * @author 邓永洪
     * @since 2018/6/23
     */
    @Transactional
    @Override
    public void updateDealUser(Integer cityId, Integer compId, Integer dealUserId, String dealUserName, Integer dealId) {
        //没有上传USER_ID将合同创建人设置为总负责人
        if (dealUserId == null) {
            erpFunDealMapper.updateDealUser(cityId, compId, dealId);
            return;
        }
        ErpFunDeal funDeal = new ErpFunDeal();
        funDeal.setShardCityId(cityId);
        funDeal.setDealId(dealId);
        funDeal.setDealUserName(dealUserName);
        funDeal.setDealUserId(dealUserId);
        funDeal.setUpdateTime(new Date());
        ErpFunDealExample funDealExample = new ErpFunDealExample();
        funDealExample.setShardCityId(cityId);
        funDealExample.createCriteria().andCompIdEqualTo(compId).andDealIdEqualTo(dealId);
        erpFunDealMapper.updateByExampleSelective(funDeal, funDealExample);
    }

    /**
     * @tag 合同结算
     * @author 邓永洪
     * @since 2018/6/30
     */
    @Transactional
    @Override
    public void settlementDeal(DealBussinessCommonParam commonParam) {
        SettlementDealParam param = commonParam.getSettlementDealParam();
        GeneralParam generalParam = commonParam.getGeneralParam();
        ErpFunDeal funDeal = new ErpFunDeal();
        Integer cityId = generalParam.getCityId();
        Integer compId = generalParam.getCompId();
        Integer dealId = param.getDealId();

        this.checkCanSettleDeal(cityId, dealId);

        String currentDeptUserName = generalParam.getCurrDeptUserName();
        funDeal.setDealId(dealId);
        funDeal.setShardCityId(cityId);
        funDeal.setDealVerifyTime(param.getDealVerifyTime());
        funDeal.setDealStatus(Const.DIC_DEAL_STATUS_DEALOVER);
        erpFunDealMapper.updateByPrimaryKeySelective(funDeal);
        ErpFunProfit funProfit = new ErpFunProfit();
        funProfit.setShardCityId(cityId);
        funProfit.setDealVerifyTime(DateUtil.StringToDate(param.getDealVerifyTime()));
        ErpFunProfitExample profitExample = new ErpFunProfitExample();
        profitExample.setShardCityId(cityId);
        profitExample.createCriteria().andCompIdEqualTo(compId).andDealIdEqualTo(dealId);
        erpFunProfitMapper.updateByExampleSelective(funProfit, profitExample);

        List<ErpFunProfit> funProfits = erpFunProfitMapper.selectByExample(profitExample);
        if (funProfits == null || funProfits.isEmpty()) {
            return;
        }
        ErpFunDeal dealInfo = erpFunDealMapper.getBaseDealInfo(cityId, dealId);
        List<ErpFunUsers> userList = null;
        String taskSubJect = currentDeptUserName + " 结算了编号" + dealInfo.getContractNo() + "的合同";
        String taskContent = currentDeptUserName + " 结算了编号" + dealInfo.getContractNo() + "的合同";
        userList = erpFunUsersService.getTaskUserList(cityId, dealId, 1, compId, generalParam.getUserId());
//		erpFunTaskService.createDealWarmTask(dealInfo.getDealType(), dealId, dealInfo.getContractNo(),
//				userList, taskSubJect, Const.DIC_TASK_TYPE_BARGAIN_REMIND, taskContent,
//				generalParam.getUserId(), cityId, generalParam.getDeptId(), compId);
        String trackContent = currentDeptUserName + " 将该合同结算";
        erpFunDealRecordService.writeDealRecord(generalParam, dealId, null, Const.DIC_DEAL_UPDATE_CLASSIC_DEALSETTLEMENT,
                (byte) 0, trackContent, 1, null, false, null);

        String archiveIds = funProfits.stream().filter(val->(null != val.getArchiveId())).map(val -> val.getArchiveId() + "").collect(Collectors.joining(","));
        erpFunProfitService.countProfitStandard(cityId, compId, archiveIds);
        // 发送消息计算提成金额
//		Map<String, Object> content = new HashMap<>();
//		content.put("cityId",cityId);
//		content.put("compId",compId);
//		content.put("dealId", dealId);
//		content.put("dealOpType", "2");
//		adminJmsMessageService.createProfitDetail(cityId,content);

        UpdateFunProfitMessage message = new UpdateFunProfitMessage();
        message.setCityId(cityId);
        message.setCompId(compId);
        message.setDealId(dealId);
        message.setDealOpType(2);

        adminJmsMessageService.createProfitDetail(message);

    }

    @Override
    public void checkCanSettleDeal(Integer cityId, Integer dealId) {
        // 先检查流程步骤是否有条件步骤 需求：10257
        ErpFunDeal baseDealInfo = erpFunDealMapper.getBaseDealInfo(cityId, dealId);
        if (null != baseDealInfo.getModelId()) {
            // 判断是否有条件流程
            ErpProcessModel processModel = new ErpProcessModel();
            processModel.setModelId(baseDealInfo.getModelId());
            processModel.setShardCityId(cityId);
            processModel.setCompId(baseDealInfo.getCompId());
            final ErpProcessModel erpProcessModel = erpProcessModelMapper.selectByPrimaryKey(processModel);
            if (null != erpProcessModel && null != erpProcessModel.getConditionStepIds()) {
                String conditionStepIds = erpProcessModel.getConditionStepIds();
                String[] conditionStepIdArr = conditionStepIds.split(",");
                Integer [] convert = (Integer [])ConvertUtils.convert(conditionStepIdArr, Integer.class);
                List<Integer> integers = Arrays.asList(convert);
                // 查询关联流程步骤
                List<ErpProcessRuntimeStepDto> runtimeStepDtoList = erpProcessRuntimeStepMapper.getMgrWarrantStepList(cityId, baseDealInfo.getCompId(), dealId);
                List<String> stepNames = new ArrayList();
                if (runtimeStepDtoList.size() > 0) {
                    Map<Integer, String> stepIdNameMap = runtimeStepDtoList.stream().collect(Collectors.toMap(val -> val.getStepId(), val -> val.getStepName()));
                    runtimeStepDtoList.forEach(val -> {
                        if (integers.contains(val.getStepId()) && 1 != val.getDelFlag() && 3 != val.getRunstepStatus()) {
                            String stepName = stepIdNameMap.get(val.getStepId());
                            if (StringUtils.isNotBlank(stepName)) {
//                                throw new BusinessException("权证流程[" + stepName + "]未完成前,不可结算合同!");
                                stepNames.add(stepName);
                            }
                        }
                    });
                    StringBuilder stepNamesStr= new StringBuilder();
                    if(stepNames.size()>0){
                        stepNames.forEach(stepName ->{
                            stepNamesStr.append(stepName+",");
                        });
                        String substring = stepNamesStr.substring(0, stepNamesStr.length() - 1);
                        throw new BusinessException("权证流程[" + substring + "]未完成前,不可结算合同!");
                    }
                }
            }
        }

    }

    /**
     * @tag 判断是否为优加合同
     * @author 邓永洪
     * @since 2018/7/13
     */
    @Override
    public Boolean isYouJiaDealByDealId(Integer cityId, Integer dealId, Integer userId, Integer crmCompId) {
        // 判断是否是总部
        List<Integer> compIdList = new ArrayList<>();
        if (null != crmCompId) {
            AdminCrmComp adminCrmCompPO = adminCrmCompMapper.selectByPrimaryKey(crmCompId);
            if (!adminCrmCompPO.getSuperComp()) {
                compIdList = erpFunCompService.getErpCompIdListByCrmCompId(cityId, crmCompId);
                if (compIdList.size() == 0) {
                    return false;
                }
            }
        }
        ErpFunDealExample dealExample = new ErpFunDealExample();
        dealExample.setShardCityId(cityId);
        ErpFunDealExample.Criteria criteria = dealExample.createCriteria();
        criteria.andDealIdEqualTo(dealId);
        if (compIdList != null && compIdList.size() > 0) {
            criteria.andCompIdIn(compIdList);
        }
        List<ErpFunDeal> dealList = erpFunDealMapper.selectByExample(dealExample);
        // 合同不为空并且签约门店不为空
        ErpFunDeal deal = null;
        if (dealList != null && dealList.size() > 0) {
            deal = dealList.get(0);
            if (deal != null && deal.getSignUserDeptId() != null) {
                Integer deptId = deal.getSignUserDeptId(); // 签约门店Id
                ErpFunDepts depts = new ErpFunDepts();
                depts.setDeptId(deptId);
                depts.setShardCityId(cityId);
                depts = erpFunDeptsMapper.selectByPrimaryKey(depts);
                if (null != depts) {
                    AdminFunDeptsExample deptsExample = new AdminFunDeptsExample();
                    deptsExample.createCriteria().andDeptNoEqualTo(depts.getDeptNo()).andCompNoEqualTo(depts.getCompNo()).andYoujiaDeptFlagEqualTo((byte) 1);
                    int count = adminFunDeptsMapper.countByExample(deptsExample);
                    if (count > 0) {
                        return true;
                    }
                }
            }
        }
        String userRoleId = adminWeiUserInfoMapper.getUserRoleId(userId);
        if (StringUtils.isNotBlank(userRoleId) && "BROKER".equals(userRoleId)) {
            // 经纪人
            AdminWeiUserInfoExample weiUserInfoExample = new AdminWeiUserInfoExample();
            weiUserInfoExample.createCriteria().andWeiUserIdEqualTo(userId).andCrmCompIdEqualTo(crmCompId);
            List<AdminWeiUserInfo> adminWeiUserInfos = adminWeiUserInfoMapper.selectByExample(weiUserInfoExample);
            if (adminWeiUserInfos != null && adminWeiUserInfos.size() > 0) {
                AdminWeiUserInfo adminWeiUserInfo = adminWeiUserInfos.get(0);
                if (adminWeiUserInfo != null) {
                    ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUsersByMobile(cityId, adminWeiUserInfo.getUserMobile());
                    if (deal.getCompId() == erpFunUsers.getCompId()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Transactional
    @Override
    public void updateFunDealAndCode(ErpFunDeal model, Integer codeUpdateFlag, Integer cityId) throws Exception {
        model.setShardCityId(cityId);
        erpFunDealMapper.updateByPrimaryKeySelective(model);
        if (codeUpdateFlag == 1) {
            this.updateFunDealCode(cityId, model.getContractNo(), model.getCodeId());
        }
    }

    /**
     * 获取合同的成交金额
     *
     * @see com.myfun.service.business.erpdb.ErpFunDealService#getDealMoneyByDeal(com.myfun.repository.erpdb.po.ErpFunDeal)
     */
    @Override
    public double getDealMoneyByDeal(ErpFunDeal dealPO) throws Exception {
        double money = 0;// 成交金额
        if (Constants_DIC.DIC_CASE_TYPE_SALE_DEAL.equals(dealPO.getDealType())) {
            BigDecimal sellDealMoney = dealPO.getSellDealMoney();
            if (sellDealMoney != null) {
                money = sellDealMoney.doubleValue();// 现在数据库存储的是元对应的数值，只是用SALE_PRICE_UNIT来区分
            }
        } else if (Constants_DIC.DIC_CASE_TYPE_RENT_DEAL.equals(dealPO.getDealType())) {
            money = getLeaseMoneyByMonth(dealPO.getRentPriceUnit().toString(), dealPO.getRentDealMoney().toString(), dealPO.getArea().toString());
        }
        return money;

    }

    @Override
    public double getLeaseMoneyByMonth(String priceUnit, String tatalMoney, String tatalArea) {
        double money = parseToDouble(tatalMoney);
        if (Constants_DIC.DIC_PRICE_UNIT_PERCENTIARE.equals(priceUnit)) {
            double area = parseToDouble(tatalArea);
            return money * area * 1;
        } else if (Constants_DIC.DIC_PRICE_UNIT_PERDAY.equals(priceUnit)) {
            return money * 30;
        } else if (Constants_DIC.DIC_PRICE_UNIT_PERDAYCENT.equals(priceUnit)) {
            double area = parseToDouble(tatalArea);
            return money * area * 30;
        } else if (Constants_DIC.DIC_PRICE_UNIT_PERMONTH.equals(priceUnit)) {
            return money;
        } else if (Constants_DIC.DIC_PRICE_UNIT_PERYEAR.equals(priceUnit)) {
            return money / 12;
        }
        return money;
    }

    private double parseToDouble(String param) {
        double result = 0;
        if (!CommonUtil.isnull(param)) {
            try {
                result = Double.valueOf(param);
            } catch (Exception e) {
                result = 0;
            }
        }
        return result;
    }

    @Transactional
    @Override
    public void updateMgrDealData(ErpFunDeal model, Integer[] repeatAndCodeFlagArr, ErpFunDeal oldModel, GeneralParam generalParam, String deptType, Map<String, Object> resultMap) throws Exception {

        Integer compId = generalParam.getCompId();
        Integer cityId = generalParam.getCityId();
        model.setSignType(null);// 设置签约类型为null,不让编辑修改。
        this.updateFunDealAndCode(model, repeatAndCodeFlagArr[1], cityId);

        ErpFunDealExample funDealExample = new ErpFunDealExample();
        funDealExample.setShardCityId(cityId);
        funDealExample.createCriteria().andDealIdEqualTo(model.getDealId()).andCompIdEqualTo(compId);
        List<ErpFunDeal> example = erpFunDealMapper.selectByExample(funDealExample);
        ErpFunDeal afterModel = example.get(0);

        double money = this.getDealMoneyByDeal(afterModel);
        double brokerageRate = 0;
        if (afterModel.getCommissionRate() != null) {
            brokerageRate = afterModel.getCommissionRate().doubleValue();
        }
        ErpFunDeal updateModel = new ErpFunDeal();
        DecimalFormat format = new DecimalFormat("0.##");
        updateModel.setStandardCommission(new BigDecimal(format.format(money * brokerageRate / 100)));
        updateModel.setShardCityId(cityId);
        updateModel.setDealId(model.getDealId());
          
        erpFunDealMapper.updateByPrimaryKeySelective(updateModel);
        //修改合同介绍人和合同促成人,签约地点
        erpFunDealMapper.updateDealIntroducer(cityId,model.getDealId(),model.getIntroducerId(),model.getAdultPromotionId(),model.getSignSiteDept(),model.getSignSiteGr());
        
        erpProcessRuntimeStepService.updateStepExcutorOfNotDoing(model.getDealId(), model.getSignUserId(), "SIGN_USER", cityId, compId);
        erpDealUserRelativeService.createDealUserRelative(cityId, compId, afterModel);
        // 写入更新记录
        if (StringUtil.isEmpty(oldModel.getBuyPriceMoney())) {
            oldModel.setBuyPriceMoney(null);
        }
        String updateContent = model.getUpdateContent(oldModel);
        if (!com.myfun.framework.utils.CommonUtil.isnull(updateContent)) {
            String arr[] = updateContent.split("、");
            if (arr.length == 1) {
                updateContent = arr[0];
            } else {
                updateContent += "等";
            }
        } else {
            return;
        }
        String deptName = generalParam.getDeptName();
        String userName = generalParam.getUserName();

        String deptUserName = userName;
        if (StringUtil.isNotEmpty(deptName)) {
            deptUserName = deptName + userName;
        }
        String trackContent = deptUserName + " 修改了" + updateContent + "信息";

        String taskType = Const.DIC_TASK_TYPE_DEAL_UPDATE_STR;
//		String taskSubJect = taskType + " " + deptUserName + " 修改了编号" + model.getContractNo() + "的合同的资料";
        String taskContent = deptUserName + " 修改了编号" + model.getContractNo() + "的合同的资料";

        // xxx店xx人 修改了你 英郡 2室 69㎡ 70万 的房源买卖合同
        String taskSubJect = getTaskSubject(cityId, generalParam.getDeptId(), generalParam.getUserName(), model.getDealType(), model);

        erpFunDealRecordService.writeDealRecord(generalParam, model.getDealId(), null, Const.DIC_DEAL_UPDATE_CLASSIC_DEALEDIT, (byte) 0,
                trackContent, 1, null, true, null);

        List<ErpFunUsers> taskUserList = erpFunUsersService.getTaskUserList(cityId, model.getDealId(), 2,
                generalParam.getCompId(), generalParam.getUserId());

//		erpFunTaskService.createDealWarmTask(model.getDealType(), model.getDealId(), model.getContractNo(),
//				taskUserList, taskSubJect, Const.DIC_TASK_TYPE_DEAL_UPDATE, taskContent,
//				generalParam.getUserId(), cityId, generalParam.getDeptId(), compId);

        List<AdminFunUserMessage> messages = erpFunTaskService.createDealTask(model.getDealType(), model.getDealId(), model.getContractNo(),
                taskUserList, taskSubJect, Const.DIC_TASK_TYPE_DEAL_UPDATE, taskContent,
                generalParam.getUserId(), cityId, generalParam.getDeptId(), compId, model.getCreatorUid());

        if (messages != null && messages.size() > 0) {
            resultMap.put("messages", messages);
        }

        //如果是单店版，修改合同后重新生成财务数据
        if ("6".equals(deptType)) {
            InsertDealInfoParam param = new InsertDealInfoParam();
            param.setCityId(cityId);
            param.setSelfCompId(compId);
            param.setDeptType(Byte.valueOf(deptType));
            param.setSelfArchiveId(generalParam.getArchiveId());
            // 创建默认的财务和业绩
            erpProcessFinanceService.createDefaultFinancForDeal(param, model);// 增加应收财务,并将佣金总额返回
            updateNeedandRealIncomeOffDeal(cityId, model);
            erpFunProfitService.createDefaultProfitForDeal(model, param);// 将所有的佣金作为业绩分配给经纪人
        }
    }

    private String getTaskSubject(Integer cityId, Integer deptId, String userName, Byte dealType, ErpFunDeal model) {
        // 租售, 求购求租两个不能同时为内部合作, 所以必有一个
        Integer dealCustomerId = model.getDealCustomerId();
        Integer dealHouseId = model.getDealHouseId();

        switch (dealType) {
            case 101: {
                if (dealHouseId != null) {
                    ErpFunSale erpFunSale = new ErpFunSale();
                    erpFunSale.setShardCityId(cityId);
                    erpFunSale.setSaleId(dealHouseId);
                    erpFunSale = erpFunSaleMapper.selectByPrimaryKey(erpFunSale);
                    if (erpFunSale == null) {
                        return "";
                    }
                    String buildName = erpFunSale.getBuildName();
                    Byte saleRoom = erpFunSale.getSaleRoom();
                    BigDecimal saleArea = erpFunSale.getSaleArea();
                    BigDecimal saleTotalPrice = erpFunSale.getSaleTotalPrice();

                    String deptName = "";
                    if (!deptId.equals(erpFunSale.getDeptId())) {
                        ErpFunDepts erpFunDepts = new ErpFunDepts();
                        erpFunDepts.setShardCityId(cityId);
                        erpFunDepts.setDeptId(deptId);
                        deptName = erpFunDeptsMapper.selectNameByPrimaryKey(erpFunDepts);
                    }

                    String finalSaleArea = removeZero(saleArea);
                    String finalSaleTotalPrice = removeZero(saleTotalPrice);

                    // xxx店xx人 修改了你 英郡 2室 69㎡ 70万 的房源买卖合同
                    return deptName + userName + " 修改了你 " + buildName + " " + (saleRoom == null ? "" : saleRoom + "室 ")
                            + finalSaleArea + "㎡ " + finalSaleTotalPrice + "万 的房源买卖合同";
                } else if (dealCustomerId != null) {
                    // 求购
                    ErpFunBuyCustomer erpFunBuyCustomer = new ErpFunBuyCustomer();
                    erpFunBuyCustomer.setShardCityId(cityId);
                    erpFunBuyCustomer.setBuyCustId(dealCustomerId);
                    erpFunBuyCustomer = erpFunBuyCustomerMapper.selectByPrimaryKey(erpFunBuyCustomer);
                    if (erpFunBuyCustomer == null) {
                        return "";
                    }
                    String buyCustName = erpFunBuyCustomer.getBuyCustName();
                    // true=先生 false=女士
                    Boolean buyCustSex = erpFunBuyCustomer.getBuyCustSex();
                    // 90-120平
                    BigDecimal houseAreaLow = erpFunBuyCustomer.getHouseAreaLow();
                    BigDecimal houseAreaHigh = erpFunBuyCustomer.getHouseAreaHigh();
                    // 2-3室
                    Byte houseRoom = erpFunBuyCustomer.getHouseRoom();
                    Byte houseRoom1 = erpFunBuyCustomer.getHouseRoom1();

                    String deptName = "";
                    if (!deptId.equals(erpFunBuyCustomer.getDeptId())) {
                        ErpFunDepts erpFunDepts = new ErpFunDepts();
                        erpFunDepts.setShardCityId(cityId);
                        erpFunDepts.setDeptId(deptId);
                        deptName = erpFunDeptsMapper.selectNameByPrimaryKey(erpFunDepts);
                    }

                    String finalHouseAreaLow = removeZero(houseAreaLow);
                    String finalHouseAreaHigh = removeZero(houseAreaHigh);

                    // xxx店xx人 修改了你 李先生求购2-3室 60-90㎡ 的客户买卖合同
                    return deptName + userName + " 修改了你 " + buyCustName + (buyCustSex ? "先生" : "女士") + "求购" +
                            houseRoom + "-" + houseRoom1 + "室 " + finalHouseAreaLow + "-" + finalHouseAreaHigh + "㎡" + " 的客户买卖合同";
                }
            }
            case 102: {
                if (dealHouseId != null) {
                    ErpFunLease erpFunLease = new ErpFunLease();
                    erpFunLease.setShardCityId(cityId);
                    erpFunLease.setLeaseId(dealHouseId);
                    erpFunLease = erpFunLeaseMapper.selectByPrimaryKey(erpFunLease);
                    if (erpFunLease == null) {
                        return "";
                    }
                    String buildName = erpFunLease.getBuildName();
                    Byte leaseRoom = erpFunLease.getLeaseRoom();
                    Byte priceUnit = erpFunLease.getPriceUnit();

                    double leaseTotalPrice = Optional.ofNullable(erpFunLease.getLeaseTotalPrice()).orElse(BigDecimal.ZERO).doubleValue();
                    double leaseArea = Optional.ofNullable(erpFunLease.getLeaseArea()).orElse(new BigDecimal(20)).doubleValue();
                    double totalPrice = com.myfun.framework.utils.CommonUtil.getLeaseMoneyByMonth(priceUnit, leaseTotalPrice, leaseArea);

                    String deptName = "";
                    if (!deptId.equals(erpFunLease.getDeptId())) {
                        ErpFunDepts erpFunDepts = new ErpFunDepts();
                        erpFunDepts.setShardCityId(cityId);
                        erpFunDepts.setDeptId(deptId);
                        deptName = erpFunDeptsMapper.selectNameByPrimaryKey(erpFunDepts);
                    }

                    String finalLeaseArea = removeZero(BigDecimal.valueOf(leaseArea));

                    // xxx店xx人 修改了你 英郡 2室 69㎡ 7000/㎡ 的房源租赁合同
                    return deptName + userName + " 修改了你 " + buildName + " " + (leaseRoom == null ? "" : leaseRoom + "室 ") +
                            finalLeaseArea + "㎡ " + new DecimalFormat("#.00").format(totalPrice) + "元/月 的房源租赁合同";
                } else if (dealCustomerId != null) {
                    ErpFunRentCustomerKey erpFunRentCustomerKey = new ErpFunRentCustomerKey();
                    erpFunRentCustomerKey.setShardCityId(cityId);
                    erpFunRentCustomerKey.setRentCustId(dealCustomerId);
                    ErpFunRentCustomer erpFunRentCustomer = erpFunRentCustomerMapper.selectByPrimaryKey(erpFunRentCustomerKey);

                    if (erpFunRentCustomer == null) {
                        return "";
                    }
                    String rentCustName = erpFunRentCustomer.getRentCustName();
                    // true=先生 false=女士
                    Boolean rentCustSex = erpFunRentCustomer.getRentCustSex();
                    // 90-120平
                    BigDecimal houseAreaLow = erpFunRentCustomer.getHouseAreaLow();
                    BigDecimal houseAreaHigh = erpFunRentCustomer.getHouseAreaHigh();
                    // 2-3室
                    Byte houseRoom = erpFunRentCustomer.getHouseRoom();
                    Byte houseRoom1 = erpFunRentCustomer.getHouseRoom1();

                    String deptName = "";
                    if (!deptId.equals(erpFunRentCustomer.getDeptId())) {
                        ErpFunDepts erpFunDepts = new ErpFunDepts();
                        erpFunDepts.setShardCityId(cityId);
                        erpFunDepts.setDeptId(deptId);
                        deptName = erpFunDeptsMapper.selectNameByPrimaryKey(erpFunDepts);
                    }

                    String finalHouseAreaLow = removeZero(houseAreaLow);
                    String finalHouseAreaHigh = removeZero(houseAreaHigh);

                    // xxx店xx人 修改了你 李先生求租2-3室 60-90㎡ 的客户租赁合同
                    return deptName + userName + " 修改了你 " + rentCustName + (rentCustSex ? "先生" : "女士") + "求租 " +
                            houseRoom + "-" + houseRoom1 + "室 " + finalHouseAreaLow + "-" + finalHouseAreaHigh + "㎡" + " 的客户租赁合同";
                }
            }
            default:
                break;
        }
        return "";
    }

    /**
     * 总价如果是60.00万, 则取整为60万
     * 面积如果是100.00㎡, 则取整为100㎡
     */
    private String removeZero(BigDecimal zeroNumber) {
        String finalNumber = "";
        if (zeroNumber != null) {
            if (zeroNumber.toString().endsWith(".00") || zeroNumber.toString().endsWith(".0")) {
                finalNumber = String.valueOf(zeroNumber.intValue());
            } else {
                finalNumber = zeroNumber.toString();
            }
        }
        return finalNumber;
    }


    @Transactional
    @Override
    public void saveBrokerage(ErpFunBrokerage leaseBrokerage, ErpFunBrokerage saleBrokerage, Integer cityId) {
        if (leaseBrokerage != null) {
            leaseBrokerage.setShardCityId(cityId);
            erpFunBrokerageMapper.updateByPrimaryKeySelective(leaseBrokerage);
        }
        if (saleBrokerage != null) {
            saleBrokerage.setShardCityId(cityId);
            erpFunBrokerageMapper.updateByPrimaryKeySelective(saleBrokerage);
        }
    }

    @Transactional
    @Override
    public void insertTaxesData(List<TaxesDataOutParamDto> taxesSubList, Integer compId, Integer cityId) {
        for (TaxesDataOutParamDto taxesDataOutParamDto : taxesSubList) {
            Integer fartherId = taxesDataOutParamDto.getId();
            String fartherName = taxesDataOutParamDto.getName();
            Integer payType = taxesDataOutParamDto.getPayType();
            List<ErpFunDealTaxesSub> subList = taxesDataOutParamDto.getValList();
            if (null != fartherId) {
                List<ErpFunDealTaxesSub> addSubList = new ArrayList<ErpFunDealTaxesSub>();
                for (ErpFunDealTaxesSub fdtsp : subList) {
                    if (fdtsp.getId() == null) {
                        fdtsp.setFatherId(fartherId);
                        fdtsp.setCompId(compId);
                        fdtsp.setCanDel((byte) 1);
                        addSubList.add(fdtsp);
                        continue;
                    }
                    fdtsp.setShardCityId(cityId);
                    erpFunDealTaxesSubMapper.updateByPrimaryKeySelective(fdtsp);
                }
                if (addSubList.size() > 0) {
                    erpFunDealTaxesSubMapper.insertBathList(cityId, addSubList);
                }
            } else {
                ErpFunDealTaxesFather erpFunDealTaxesFather = new ErpFunDealTaxesFather();
                erpFunDealTaxesFather.setName(fartherName);
                erpFunDealTaxesFather.setCompId(compId);
                erpFunDealTaxesFather.setPayType(payType.byteValue());
                erpFunDealTaxesFather.setShardCityId(cityId);
                erpFunDealTaxesFatherMapper.insertSelective(erpFunDealTaxesFather);
                for (ErpFunDealTaxesSub fdtsp : subList) {
                    fdtsp.setCompId(compId);
                    fdtsp.setCanDel((byte) 1);
                    fdtsp.setFatherId(erpFunDealTaxesFather.getId());
                }
                if (subList.size() > 0) {
                    erpFunDealTaxesSubMapper.insertBathList(cityId, subList);
                }
            }
        }
    }

    @Transactional
    @Override
    public void updateMgrDealAduitStatus(UpdateDealAuditStatusParam param, GeneralParam generalParam, ErpFunDeal oldDeal, ErpFunDeal deal, List<ErpFunUsers> taskUserList) {
        erpFunDealService.updateDealShenheInfo(param, oldDeal);
//		erpFunTaskService.createDealWarmTask(oldDeal.getDealType(),deal.getDealId(),oldDeal.getContractNo(),taskUserList,param.getTaskSubJect(),Const.DIC_TASK_TYPE_CONTRACT_REMIND,
//				param.getTaskContent(),param.getSelfUserId(),param.getCityId(),param.getSelfDeptId(),param.getCompId());
        erpFunDealRecordService.writeDealRecord(generalParam, deal.getDealId(), null, param.getUpdateClassic(),
                new Byte("0"), param.getTrackContent(), 1, null, false, null);
        if (Const.DIC_DEAL_COMPLETE_FAIL.equals(deal.getDealAuditStatus())) {
            // 作废POS合同订单(未支付的POS款项作废)
            ErpPosPaymentOrderExample posPaymentOrderExample = new ErpPosPaymentOrderExample();
            posPaymentOrderExample.setShardCityId(param.getCityId());
            posPaymentOrderExample.createCriteria().andDealIdEqualTo(deal.getDealId()).andPayStatusEqualTo((byte) 0);
            ErpPosPaymentOrder posPaymentOrder = new ErpPosPaymentOrder();
            posPaymentOrder.setPayStatus((byte) 3);
            erpPosPaymentOrderMapper.updateByExampleSelective(posPaymentOrder, posPaymentOrderExample);
        }
    }

    @Transactional
    @Override
    public void changeWarrant(Integer cityId, Integer compId, changeWarrantParam param, ErpProcessRuntimeStep model, GeneralParam generalParam, String trackContent) {
        erpProcessRuntimeStepService.deleteAndNewStep(cityId, compId, param, model);
        erpFunProcessRecordService.insert4UpdateStep(generalParam, model.getDealId(), null,
                null, Const.DIC_DEAL_UPDATE_CLASSIC_PROCESSCHANGE, trackContent, null);
    }

    @Transactional
    @Override
    public void updateProcessFinancStatus(DealBussinessCommonParam commonParam) {

        GeneralParam generalParam = commonParam.getGeneralParam();
        ProcessFinancStatusParam param = commonParam.getProcessFinancStatusParam();
        Integer cityId = generalParam.getCityId();
        Integer compId = generalParam.getCompId();
        String pfIds = param.getPfIds();
        Integer dealId = param.getDealId();
        Integer pfActual = param.getPfActual();
        Integer auditStatus = param.getAuditStatus();
        String currentDeptUserName = generalParam.getCurrDeptUserName();
        if (StringUtil.isBlank(pfIds)) {
            return;
        }
        String[] pfIdArr = pfIds.split(",");
        ErpFunDeal funBaseInfoDealPo = erpFunDealMapper.getBaseDealInfo(cityId, dealId);

        List<ErpFunUsers> userList = erpFunUsersService.getTaskUserList(cityId, dealId, 2, compId, generalParam.getUserId());
        String taskSubJect = currentDeptUserName + " 撤销了编号" + funBaseInfoDealPo.getContractNo() + "的合同的财务收付明细的审核";
        String taskContract = currentDeptUserName + " 撤销了编号" + funBaseInfoDealPo.getContractNo() + "的合同的财务收付明细审核";
        Map<String, Object> insertMap = new HashMap<>();
        Map<String, Object> dealUpdateMap = new HashMap<>();

        int fianacCount = erpProcessFinancMapper.countProcessFinanc(cityId, compId, pfActual, null, pfIdArr);
        boolean fianacFlag = false;
        if (fianacCount == pfIdArr.length) {
            fianacFlag = true;
        }

        String financStatus = "";
        if (auditStatus == 0) {
            insertMap.put("auditTime", null);
            insertMap.put("auditUser", null);
            insertMap.put("auditUserName", null);
            insertMap.put("auditStatus", "0");
            if ("已结清".equals(funBaseInfoDealPo.getFinancName())) {
                this.createDealFinancStatus(dealUpdateMap, "待结清", cityId, compId);
                financStatus = currentDeptUserName + " 撤销审核之后将财务状态改为从已结清变为待结清";
                erpFunDealMapper.updateDealStatusByDealId(cityId, dealId, dealUpdateMap);
            }
        } else {
            insertMap.put("auditTime", getTimeNow());
            insertMap.put("auditUser", generalParam.getUserId());
            insertMap.put("auditUserName", generalParam.getUserName());
            insertMap.put("auditStatus", "1");
        }

        if (pfActual == 0) {
            if (auditStatus == 1) {
                String trackContent = currentDeptUserName + " 审核了应收应付";
                taskSubJect = currentDeptUserName + " 审核了编号" + funBaseInfoDealPo.getContractNo()
                        + "的合同的应收财务收付明细";

                taskContract = currentDeptUserName + " 审核了编号" + funBaseInfoDealPo.getContractNo()
                        + "的合同的应收财务收付明细";
                erpFunDealRecordService.writeDealRecord(generalParam, dealId, null,
                        Const.DIC_DEAL_UPDATE_CLASSIC_PROCESSFIANACAUDITACCOUNTRECEIVABLE, (byte) 1, trackContent, 1,
                        (byte) 0, false, null);
            } else {
                String trackContent = currentDeptUserName + " 撤销了应收应付审核";
                erpFunDealRecordService.writeDealRecord(generalParam, dealId, null,
                        Const.DIC_DEAL_UPDATE_CLASSIC_PROCESSFIANACAUDITACCOUNTRECEIVABLE, (byte) 1, trackContent, 1,
                        (byte) 0, false, null);
            }
            erpProcessFinancMapper.updateProcessFinanc(cityId, compId, pfActual, pfIdArr, dealId, insertMap);
        } else {
            erpProcessFinancMapper.updateProcessFinanc(cityId, compId, pfActual, pfIdArr, dealId, insertMap);
            if (auditStatus == 1) {
                String trackContent = currentDeptUserName + " 审核了实收实付";
                taskSubJect = currentDeptUserName + " 审核了编号" + funBaseInfoDealPo.getContractNo() + "的合同的实收财务收付明细";
                taskContract = currentDeptUserName + " 审核了编号" + funBaseInfoDealPo.getContractNo() + "的合同的实收财务收付明细";
                erpFunDealRecordService.writeDealRecord(generalParam, dealId, null,
                        Const.DIC_DEAL_UPDATE_CLASSIC_PROCESSFIANACREALINCOMEAUDIT, (byte) 1, trackContent, 1,
                        (byte) 1, false, null);
            } else {
                String trackContent = currentDeptUserName + " 撤销了实收实付审核";
                erpFunDealRecordService.writeDealRecord(generalParam, dealId, null,
                        Const.DIC_DEAL_UPDATE_CLASSIC_PROCESSFIANACREALINCOMEAUDIT, (byte) 1, trackContent, 1,
                        (byte) 1, false, null);
            }
        }

        //-----这个字段貌似没啥用，要用也是错误的
        Map<String, Object> updateMap = new HashMap<>();
        if (fianacFlag && auditStatus == 1) {
            updateMap.put("needAduitStatus", auditStatus);
            erpFunDealMapper.updateDealStatusByDealId(cityId, dealId, updateMap);
        } else if (auditStatus == 0) {
            updateMap.put("needAduitStatus", auditStatus);
            erpFunDealMapper.updateDealStatusByDealId(cityId, dealId, updateMap);
        }

        if (auditStatus == 1) {
            ErpProcessFinancDto erpProcessFinancDto = erpProcessFinancMapper.getFinancActualgetByDeal(cityId, dealId);
            if (erpProcessFinancDto != null) {
                Double SHOULDGET_ADUITED = StringUtil.paseDouble(erpProcessFinancDto.getShouldgetAduited());
                SHOULDGET_ADUITED = SHOULDGET_ADUITED == null ? 0d : SHOULDGET_ADUITED;
                Double ACUTALGET_ADUITED = StringUtil.paseDouble(erpProcessFinancDto.getAcutalgetAduited());
                ACUTALGET_ADUITED = ACUTALGET_ADUITED == null ? 0d : ACUTALGET_ADUITED;
                if (ACUTALGET_ADUITED >= 0 && SHOULDGET_ADUITED >= 0) {
                    if (ACUTALGET_ADUITED >= SHOULDGET_ADUITED) {
                        if (fianacFlag && "待结清".equals(funBaseInfoDealPo.getFinancName())) {
                            financStatus = currentDeptUserName + " 审核之后系统将财务状态改为从待结清变为已结清";
                            createDealFinancStatus(dealUpdateMap, "已结清", cityId, compId);
                            erpFunDealMapper.updateDealStatusByDealId(cityId, dealId, dealUpdateMap);
                        }
                    }
                }
            }
        }

        if (StringUtils.isNotBlank(financStatus)) {
            erpFunDealRecordService.writeDealRecord(generalParam, dealId, null,
                    Const.DIC_DEAL_UPDATE_CLASSIC_PROCESSFIANACSTATUSCHANGE, (byte) 1, financStatus, 1,
                    (byte) 1, false, null);
        }
//		erpFunTaskService.createDealWarmTask(funBaseInfoDealPo.getDealType(), dealId, funBaseInfoDealPo.getContractNo(),
//				userList, taskSubJect, Const.DIC_TASK_TYPE_CONTRACT_REMIND, taskContract,
//				generalParam.getUserId(), cityId, generalParam.getDeptId(),compId);
        erpFunBillMapper.updateBillStatusByFianacId(cityId, compId, auditStatus, pfIdArr);

        // 发送jms消息 创建流水信息
        UpdateFunProfitMessage updateFunProfitMessage = new UpdateFunProfitMessage();
        updateFunProfitMessage.setCityId(generalParam.getCityId());
        updateFunProfitMessage.setCompId(generalParam.getCompId());
        updateFunProfitMessage.setDealId(dealId);
        updateFunProfitMessage.setPfIds(pfIds);
        if (auditStatus == 1) {
            if (pfActual == 1) {
                updateFunProfitMessage.setDealOpType(1);
            } else {
                updateFunProfitMessage.setDealOpType(4);
            }
        } else if (auditStatus == 0) {
            // 反审核实收
            if (pfActual == 1) {
                // 反审核实收
                updateFunProfitMessage.setDealOpType(5);
            } else {
                // 应收
                updateFunProfitMessage.setDealOpType(6);
            }
        }
        adminJmsMessageService.createProfitDetail(updateFunProfitMessage);

    }

    private void createDealFinancStatus(Map<String, Object> dealUpdateMap, String type, Integer cityId, Integer compId) {
        ErpFunFinancStatus erpFunFinancStatus = erpFunFinancStatusMapper.getFunFinancStatus(cityId, compId, type);
        if (erpFunFinancStatus != null) {
            dealUpdateMap.put("financStatusId", erpFunFinancStatus.getFinancStatusId());
            dealUpdateMap.put("financName", type);
        }
    }

    @Transactional
    @Override
    public void counterMgrSettleDeal(CounterMgrSettleDealParam param, ErpFunDeal funDeal, GeneralParam generalParam, ErpFunDeal baseDealInfo, List<ErpFunProfit> profitList) throws ParseException {
        Integer cityId = generalParam.getCityId();
        Integer compId = generalParam.getCompId();
        String dealVerifyTime = param.getDealVerifyTime();
        String dealVerifyCon = param.getDealVerifyCon();
        Integer dealId = param.getDealId();
        String currentDeptUserName = generalParam.getCurrDeptUserName();
        /***判断是否玛雅房基地定制***/
		byte maYaModel = 0;
		ErpFunComp erpFunComp = erpFunCompMapper.selectByCompId(cityId, compId);
		if(null != erpFunComp){
			if(null != erpFunComp.getCompNo()){
				AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(erpFunComp.getCompNo());
				if(null != adminFunComp){
					if(adminFunComp.getCompManagementModel() == 2 && adminFunComp.getCustomizedType() == 1){
						maYaModel = 1;
					}
				}
			}
		}
		if(maYaModel == 0){
	        Integer paramValue = StringUtil.paseInteger(erpSysParaMapper.getParamValue(cityId, compId, "PROFIT_PERCENT_RULE"));
	        erpFunProfitService.updateProfitProportion(cityId, compId, paramValue, dealId);
		}
        List<Integer> userIds = profitList.stream().map(ErpFunProfit::getUserId).collect(Collectors.toList());
        String nowTime = DateTimeHelper.formatDateTimetoString(getTimeNow(), DateTimeHelper.FMT_yyyyMMdd);
        String dealVerifyTimestr = DateTimeHelper.formatDateTimetoString(dealVerifyTime, DateTimeHelper.FMT_yyyyMMdd);
        if (!nowTime.equals(dealVerifyTime)) {
            ErpFunWage funWage = new ErpFunWage();
            funWage.setCheckStatus((byte) 0);// 0代表工资未审核，1代表已审核

            String startDate = DateTimeHelper.formatDateTimetoString(DateTimeHelper.parseToDate(dealVerifyTime, "yyyy-MM-dd"),
                    "yyyy-MM") + "-01 00:00:00.000";
            String endDate = DateTimeHelper.formatDateTimetoString(DateTimeHelper
                    .addMonths(DateTimeHelper.parseToDate(dealVerifyTime, "yyyy-MM-dd"), 1), "yyyy-MM")
                    + "-01 00:00:00.000";
            ErpFunWageExample wageExample = new ErpFunWageExample();
            wageExample.setShardCityId(cityId);
            wageExample.createCriteria().andUserIdIn(userIds).andCreateDateGreaterThanOrEqualTo(startDate).
                    andCreateDateLessThan(endDate).andCompIdEqualTo(compId);
            erpFunWageMapper.updateByExampleSelective(funWage, wageExample);
        }
        ErpFunProfit funProfit = new ErpFunProfit();
        funProfit.setShardCityId(cityId);
        funProfit.setDealVerifyTime(null);
        funProfit.setSettleTime(null);
        funProfit.setSettleFlag(Const.SETTLE_FLAG_NOCHECK);
        funProfit.setCompId(compId);
        funProfit.setDealId(dealId);
        erpFunProfitMapper.updateSetSettleTime(funProfit);
        List<ErpFunUsers> userList = null;
        String taskSubJect = currentDeptUserName + " 撤销了编号" + baseDealInfo.getContractNo() + "的合同结算";
        String taskContent = currentDeptUserName + " 撤销了编号" + baseDealInfo.getContractNo() + "的合同的结算";
        userList = erpFunUsersService.getTaskUserList(cityId, dealId, 1, generalParam.getCompId(), generalParam.getUserId());
//		erpFunTaskService.createDealWarmTask(baseDealInfo.getDealType(), dealId, baseDealInfo.getContractNo(),
//				userList, taskSubJect, Const.DIC_TASK_TYPE_BARGAIN_REMIND, taskContent,
//				generalParam.getUserId(), cityId, generalParam.getDeptId(), compId);
        String trackContent = currentDeptUserName + " 撤销了该合同的业绩结算审核" + ",撤销结算原因：" + dealVerifyCon;
        erpFunDealRecordService.writeDealRecord(generalParam, dealId, null, Const.DIC_DEAL_UPDATE_CLASSIC_DEALSETTLEMENT,
                (byte) 0, trackContent, 1, null, false, null);
    }

    @Override
    public void updateDealVerifyTime(ErpFunDeal funDeal) {
        erpFunDealMapper.updateDealVerifyTime(funDeal);
    }

    @Transactional
    @Override
    public void updateProcessEndTime(ErpFunDeal funDeal) {
        erpFunDealMapper.updateProcessEndTime(funDeal);
    }

    @Override
    public void updateYouJiaDealAduitStatus(ErpFunDeal oldModel, GeneralParam generalParam, Integer dealId, Byte contentType, String taskSubJect, String updateClassic, String trackContent) {
        // 增加内部审核，只能是内部人员审核，律师无法看到
        Integer cityId = generalParam.getCityId();
        ErpFunDeal updateModel = new ErpFunDeal();
        updateModel.setDealId(oldModel.getDealId());
        if (Const.DIC_FUN_DEAL_FILE_TYPE_1 == contentType) {
            updateModel.setYouAduitStatus(Const.DIC_YOU_ADUIT_STATUS_SEVEN_INSTANCE);
        } else {
            updateModel.setYouAduitStatusProtocol(Const.DIC_YOU_ADUIT_STATUS_SEVEN_INSTANCE);
        }
        Date now = new Date();
        updateModel.setUpdateTime(now);
        // 律师提审时间
        updateModel.setSubAduitTime(now);
        updateModel.setShardCityId(cityId);
        erpFunDealMapper.updateByPrimaryKeySelective(updateModel);
        List<ErpFunUsers> taskUserList = erpFunUsersService.getTaskUserList(cityId, dealId, 1, generalParam.getCompId(), generalParam.getUserId());
        erpFunTaskService.createDealWarmTask(oldModel.getDealType(), oldModel.getDealId(), oldModel.getContractNo(), taskUserList,
                taskSubJect, Const.DIC_TASK_TYPE_AUTHORITY_REMIND, taskSubJect, generalParam.getUserId(), cityId, generalParam.getDeptId(), generalParam.getCompId());
        erpFunDealRecordService.writeDealRecord(generalParam, oldModel.getDealId(), null, updateClassic, (byte) 0,
                trackContent, 0, null, false, null);
        erpFunContractTagService.updateTagStatus(cityId, oldModel.getDealId(), oldModel.getCompId(), oldModel.getDeptId(), (byte) 1, null);
    }

    @Transactional
    @Override
    public void updateMgrDealAduitStatusByCounter(DealBussinessCommonParam commonParam) {
        GeneralParam generalParam = commonParam.getGeneralParam();
        Integer cityId = generalParam.getCityId();
        Integer compId = generalParam.getCompId();
        Integer userId = generalParam.getUserId();

        UpdateDealAuditStatusParam param = commonParam.getUpdateDealAuditStatusParam();

        param.setCityId(cityId);
        param.setCompId(compId);
        param.setSelfDeptName(generalParam.getDeptName());
        param.setSelfUserName(generalParam.getUserName());
        param.setSelfUserId(generalParam.getUserId());
        param.setSelfDeptId(generalParam.getDeptId());
        param.setSelfCompId(generalParam.getCompId());
        param.setSelfArchiveId(generalParam.getArchiveId());
        param.setSelfGrId(generalParam.getGrId());
        param.setSelfAreaId(generalParam.getAreaId());
        param.setSelfRegId(generalParam.getRegId());
        ErpFunDeal model = new ErpFunDeal();
        model.setDealId(param.getDealId());
        String dealVerifyCon = param.getDealVerifyCon();

        ErpFunDeal oldModel = erpFunDealMapper.getFunDealById(generalParam.getCityId(), generalParam.getCompId(), model.getDealId());
        Byte dealAuditStatus = oldModel.getDealAuditStatus();
        if (Const.DIC_DEAL_COMPLETE_INIT.equals(dealAuditStatus)
                || Const.DIC_DEAL_COMPLETE_FAIL.equals(dealAuditStatus)) {
            return;
        }

        String taskSubJect = "";
        String taskContent = "";
        List<ErpFunUsers> taskUserList = erpFunUsersService.getTaskUserList(cityId, model.getDealId(), 1, compId, userId);
        String trackContent = generalParam.getCurrDeptUserName();
        String updateClassic = Const.DIC_DEAL_UPDATE_CLASSIC_DEALCOUNTERAUDIT;
        taskSubJect = trackContent + " 撤销了编号" + oldModel.getContractNo() + "的合同审核";
        taskContent = trackContent + " 撤销了编号" + oldModel.getContractNo() + "的合同审核";
        trackContent += " 对该合同进行了撤销审核 ,撤销审核原因：" + dealVerifyCon;
        if (Const.DIC_DEAL_FIRSTCOMPLETE_OK.equals(dealAuditStatus)) {
            //问了一下逻辑 有初审权和复审权的人都可以操作反审核
			/*if (!dealInitialReview) {
				return ErpResponseJson.ok();
			} else {
				param.setDealAuditStatus(Const.DIC_DEAL_COMPLETE_INIT);
			}*/
            param.setDealAuditStatus(Const.DIC_DEAL_COMPLETE_INIT.intValue());
        }
        boolean dealRepeatReview = erpUserOpersService.judgePermission(cityId, userId, "DEAL_REPEAT_REVIEW");
        if (Const.DIC_DEAL_REPEATCOMPLETE_OK.equals(dealAuditStatus)) {
            if (!dealRepeatReview) {
                return;
            } else {
                param.setDealAuditStatus(Const.DIC_DEAL_FIRSTCOMPLETE_OK.intValue());
            }
        }
        param.setTaskContent(taskContent);
        param.setTaskSubJect(taskSubJect);
        param.setUpdateClassic(updateClassic);
        param.setTrackContent(trackContent);
        Integer auditType = commonParam.getAuditType();
        if (null != auditType) {
            if (5 == auditType) {
                param.setFirstTrialCompleteDate("");
                param.setDealAuditStatus(0);
                // 更新上上签标记
                ErpSsqContractExample ssqCondition = new ErpSsqContractExample();
                ssqCondition.setShardCityId(cityId);
                ssqCondition.createCriteria().andDealIdEqualTo(param.getDealId()).andIsDelEqualTo((byte) 0);
                ErpSsqContract erpSsqContract = new ErpSsqContract();
                erpSsqContract.setIsDel(Byte.valueOf("1"));
                erpSsqContractMapper.updateByExampleSelective(erpSsqContract, ssqCondition);
            } else if (6 == auditType) {
                param.setRecheckCompleteDate("");
                param.setDealAuditStatus(1);
            }
        }
        Byte dealType = oldModel.getDealType();


        erpFunDealService.updateDealShenheInfo(param, oldModel);
//		erpFunTaskService.createDealWarmTask(dealType, model.getDealId(), oldModel.getContractNo(), taskUserList, param.getTaskSubJect(),
//				Const.DIC_TASK_TYPE_CONTRACT_REMIND, param.getTaskContent(), generalParam.getUserId(), generalParam.getCityId(), generalParam.getDeptId(), generalParam.getCompId());
        erpFunDealRecordService.writeDealRecord(generalParam, model.getDealId(), null, param.getUpdateClassic(), (byte) 0,
                param.getTrackContent(), 1, null, false, null);

    }

    @Transactional
    @Override
    public void updateDealFinancStatus(ErpFunDeal deal, Integer financStatusId, String financName, Integer dealId, Integer cityId, GeneralParam generalParam) {
        ErpFunDeal updateModel = new ErpFunDeal();
        updateModel.setFinancStatusId(financStatusId);
        updateModel.setFinancName(financName);
        updateModel.setDealId(dealId);
        updateModel.setShardCityId(cityId);
        erpFunDealMapper.updateByPrimaryKeySelective(updateModel);
        String trackContent = generalParam.getCurrDeptUserName() + " 将财务状态从" + deal.getFinancName() + "变更为" + financName;
        if (!financStatusId.equals(deal.getFinancStatusId())) {
            erpFunDealRecordService.writeDealRecord(generalParam, dealId, null,
                    Const.DIC_DEAL_UPDATE_CLASSIC_PROCESSFIANACSTATUSCHANGE, (byte) 1, trackContent, 1, (byte) 0, false, null);
        }
    }

    @Transactional
    @Override
    public int createProcessModel(ErpProcessModel processModel, String stepIds) {
        int modelId = erpProcessModelMapper.insertSelective(processModel);

        if (StringUtils.isNotBlank(stepIds)) {
            int i = 0;
            for (String stepId : stepIds.split(",")) {
                ErpModelStepRelate erpModelStepRelate = new ErpModelStepRelate();
                erpModelStepRelate.setModelId(modelId);
                erpModelStepRelate.setStepId(StringUtil.paseInteger(stepId));
                erpModelStepRelate.setCompId(processModel.getCompId());
                erpModelStepRelate.setStepSeq((byte) (i + 1));
                erpModelStepRelateMapper.insertSelective(erpModelStepRelate);
                i++;
            }
        }
        return modelId;
    }

    /**
     * @Title 审核通过的
     * @Author lcb
     * @Time 2019/7/3 10:12
     * @Desc
     **/
    @Transactional
    @Override
    public void doBussiness(DealBussinessCommonParam param) throws Exception {
        // 跟进auditType来处理不同的数据
        Integer auditType = param.getAuditType();
        if (1 == auditType) {
            // 初审
            updateDealAduitStatus(param);
        } else if (2 == auditType) {
            //复审
            updateDealAduitStatus(param);
        } else if (3 == auditType) {
            settlementDeal(param);
        } else if (4 == auditType) {
            //合同作废
            updateDealAduitStatus(param);
        } else if (5 == auditType) {
            //撤销初审
            updateMgrDealAduitStatusByCounter(param);
        } else if (6 == auditType) {
            //撤销复审
            updateMgrDealAduitStatusByCounter(param);
        } else if (7 == auditType) {
            //撤销结算
            counterMgrSettleDeal(param);
        } else if (8 == auditType) {
            //应收
            dealProcessFinceAudit(param);
        } else if (9 == auditType) {
            //实收
            dealProcessFinceAudit(param);
        } else if (10 == auditType) {
            //撤销应收审核
            dealProcessFinceAudit(param);
        } else if (11 == auditType) {
            //撤销实收审核
            dealProcessFinceAudit(param);
        }
    }

    /**
     * @Title 应收实收审核
     * @Author lcb
     * @Time 2019/7/3 19:23
     * @Desc
     **/
    private void dealProcessFinceAudit(DealBussinessCommonParam commonParam) {
        updateProcessFinancStatus(commonParam);
    }

    @Override
    public void updateDealAduitStatus(DealBussinessCommonParam commonParam) {
        GeneralParam generalParam = commonParam.getGeneralParam();
        UpdateDealAuditStatusParam param = commonParam.getUpdateDealAuditStatusParam();

        param.setCityId(generalParam.getCityId());
        param.setCompId(generalParam.getCompId());
        param.setSelfDeptName(generalParam.getDeptName());
        param.setSelfUserName(generalParam.getUserName());
        param.setSelfUserId(generalParam.getUserId());
        param.setSelfDeptId(generalParam.getDeptId());
        param.setSelfCompId(generalParam.getCompId());
        param.setSelfArchiveId(generalParam.getArchiveId());
        param.setSelfGrId(generalParam.getGrId());
        param.setSelfAreaId(generalParam.getAreaId());
        param.setSelfRegId(generalParam.getRegId());
        ErpFunDeal deal = new ErpFunDeal();
        deal.setDealId(param.getDealId());
        deal.setDealAuditStatus(param.getDealAuditStatus().byteValue());

        Integer dealId = param.getDealId();
        String dealVerifyCon = param.getDealVerifyCon();
        //获取作废 来源，1=表示来源于手动录入业绩
        Integer completeFailSource = param.getCompleteFailSource();
        if (completeFailSource != null && completeFailSource == 1) {
            boolean operateFlag = erpUserOpersService.judgePermission(generalParam.getCityId(), generalParam.getUserId(), "DISTRIBUTE_PROFIT");
            if (!operateFlag) {
                throw new BusinessException("您没有权限操作此功能！请联系管理员开通！");
            }
        }
        List<Integer> userList = new ArrayList<Integer>();
        ErpFunDeal oldDeal = erpFunDealMapper.getFunDealById(generalParam.getCityId(), generalParam.getCompId(), dealId);
        Byte oldDealCompelete = oldDeal.getDealAuditStatus();
        oldDeal.setDealId(dealId);
        String taskSubJect = "";
        String taskContent = "";
        List<ErpFunUsers> taskUserList = erpFunUsersService.getTaskUserList(generalParam.getCityId(), dealId, 1, generalParam.getCompId(), generalParam.getUserId());
        String trackContent = generalParam.getCurrDeptUserName();
        String updateClassic = Const.DIC_DEAL_UPDATE_CLASSIC_ADUIT;
        if (Const.DIC_DEAL_FIRSTCOMPLETE_OK.equals(deal.getDealAuditStatus())) {
            if (Const.DIC_DEAL_REPEATCOMPLETE_OK.equals(oldDealCompelete)) {
                return;
            } else if (Const.DIC_DEAL_UPDATE_CLASSIC_DEALINVALID.equals(oldDealCompelete)) {
                return;
            }
            taskSubJect = trackContent + " 初审通过了编号" + oldDeal.getContractNo() + "的合同";
            taskContent = trackContent + " 初审通过了编号" + oldDeal.getContractNo() + "的合同";
            trackContent += " 合同初审通过，审核意见：" + dealVerifyCon;
        } else if (Const.DIC_DEAL_REPEATCOMPLETE_OK.equals(deal.getDealAuditStatus())) {
            if (Const.DIC_DEAL_UPDATE_CLASSIC_DEALINVALID.equals(oldDealCompelete)) {
                return;
            }
            updateClassic = Const.DIC_DEAL_UPDATE_CLASSIC_ADUIT;
            taskSubJect = trackContent + " 复审通过了编号" + oldDeal.getContractNo() + "的合同";
            taskContent = trackContent + " 复审通过了编号" + oldDeal.getContractNo() + "的合同";
            trackContent += " 合同复审通过，审核意见：" + dealVerifyCon;
        } else if (Const.DIC_DEAL_COMPLETE_FAIL.equals(deal.getDealAuditStatus())) {
            updateClassic = Const.DIC_DEAL_UPDATE_CLASSIC_DEALINVALID;
            taskSubJect = trackContent + " 作废编号" + oldDeal.getContractNo() + "的合同";
            taskContent = trackContent + " 作废编号" + oldDeal.getContractNo() + "的合同";
            trackContent += " 将该合同作废,作废原因" + dealVerifyCon;
            
            userList = getDealUserList(generalParam.getCityId(), generalParam.getCompId(), dealId,generalParam.getUserId());
             
        }

        param.setTaskSubJect(taskSubJect);
        param.setTaskContent(taskContent);
        param.setTrackContent(trackContent);
        param.setUpdateClassic(updateClassic);

        Integer auditType = commonParam.getAuditType();

        // 增加时间
        if (null != auditType) {
            // 1=初审 2=复审 3=结算 4=合同作废 5=撤销初审 6=撤销复审 7= 撤销结算 8=应收审核 9=实收审核 10=撤销应收审核 11=撤销实收审核
            if (1 == auditType) {
                param.setFirstTrialCompleteDate(DateUtil.DateToString(new Date()));
            } else if (2 == auditType) {
                param.setRecheckCompleteDate(DateUtil.DateToString(new Date()));
            } else if (4 == auditType) {
                param.setInvalidCompleteDate(DateUtil.DateToString(new Date()));
            }
        }

        erpFunDealService.updateMgrDealAduitStatus(param, generalParam, oldDeal, deal, taskUserList);
         
        if(Const.DIC_DEAL_COMPLETE_FAIL.equals(deal.getDealAuditStatus())) {
            // 发送消息计算提成金额-- 这里暂时兼容下
/*            Map<String, Object> content = new HashMap<>();
            content.put("cityId", generalParam.getCityId());
            content.put("compId", generalParam.getCompId());
            content.put("dealId", deal.getDealId());
            content.put("dealOpType", "3");
            content.put("caseId", oldDeal.getDealHouseId());
            content.put("caseType", oldDeal.getDealType());
            content.put("signUserId", oldDeal.getSignUserId());*/
            UpdateFunProfitMessage message = new UpdateFunProfitMessage();
            message.setCityId(generalParam.getCityId());
            message.setCompId(generalParam.getCompId());
            message.setDealId(deal.getDealId());
            message.setDealOpType(3);
            message.setCaseId(oldDeal.getDealHouseId());
            message.setCaseType(oldDeal.getDealType());
            message.setSignUserId(oldDeal.getSignUserId());
            adminJmsMessageService.createProfitDetail(message);;

            //出售合同作废逻辑，作废之后，需要将房源从内成交转有效，这个时候需要去触发一下同步逻辑，因为这个时候report库min表的状态也需要同步，否则影响统计2019-02-19 flj加
            if (Const.DIC_CASE_TYPE_SALE_DEAL.equals(oldDeal.getDealType().intValue())) {
                if (oldDeal.getDealHouseId() != null && oldDeal.getDealHouseId() > 0) {
                    KafkaBizUtils.syncFunSale(generalParam.getCityId(), oldDeal.getDealHouseId(), Const.DIC_CASE_TYPE_SALE_FUN, Byte.valueOf("2"));
                }
                if (oldDeal.getDealCustomerId() != null && oldDeal.getDealCustomerId() > 0) {
                    KafkaBizUtils.syncCustomer(generalParam.getCityId(), oldDeal.getDealCustomerId(), Const.DIC_CASE_TYPE_BUY_CUST, 2);
                }
            } else {
                //出租合同作废逻辑
                if (oldDeal.getDealHouseId() != null && oldDeal.getDealHouseId() > 0) {
                    KafkaBizUtils.syncFunLease(generalParam.getCityId(), oldDeal.getDealHouseId(), Const.DIC_CASE_TYPE_LEASE_FUN, Byte.valueOf("2"));
                }
                if (oldDeal.getDealCustomerId() != null && oldDeal.getDealCustomerId() > 0) {
                    KafkaBizUtils.syncCustomer(generalParam.getCityId(), oldDeal.getDealCustomerId(), Const.DIC_CASE_TYPE_RENT_CUST, 2);
                }
            }
            
            // 把待审核的审批作废掉
            ErpAuditRuntimeExample erpAuditRuntimeExample = new ErpAuditRuntimeExample();
            erpAuditRuntimeExample.setShardCityId(generalParam.getCityId());
            erpAuditRuntimeExample.createCriteria().andCaseIdEqualTo(param.getDealId()).andAuditStatusEqualTo((byte) 0);
            ErpAuditRuntime erpAuditRuntime = new ErpAuditRuntime();
            erpAuditRuntime.setAuditStatus((byte) 5);
            erpAuditRuntimeMapper.updateByExampleSelective(erpAuditRuntime, erpAuditRuntimeExample);
            
            //给相关人推送消息
            if(userList.size() > 0){
            	this.setMsgToRelatedPerson(generalParam.getCityId(), generalParam.getCompId(), dealId,generalParam.getUserId(),userList,dealVerifyCon);
            }
        }
  
    }
 
    private List<Integer> getDealUserList(Integer cityId,Integer compId,Integer dealId,Integer userId){
    	Set<Integer> userIds = new HashSet<Integer>();
    	ErpFunDeal dealInfo = erpFunDealMapper.getFunDealById(cityId, compId, dealId);
    	  
    	if(dealInfo.getHouseUserUid() !=null){ //房源所属经纪人
    		userIds.add(dealInfo.getHouseUserUid());
    	}
    	if(dealInfo.getCustUserUid() !=null){//客源所属经纪人
    		userIds.add(dealInfo.getCustUserUid());
    	}
    	if(dealInfo.getSignUserId() !=null){ 	//签约人员
    		userIds.add(dealInfo.getSignUserId());
    	}
    	if(dealInfo.getDealUserId() !=null){    //流程总负责人
    		userIds.add(dealInfo.getDealUserId());
    	}
    	if(dealInfo.getExecutor() !=null){ 		//执行人
    		userIds.add(dealInfo.getExecutor());
    	}
    	//查询合同相关人
    	ErpFunProfitExample erpFunProfitExample = new ErpFunProfitExample();
    	erpFunProfitExample.setShardCityId(cityId);
    	erpFunProfitExample.createCriteria().andCompIdEqualTo(compId).andDealIdEqualTo(dealId).andValidFlagEqualTo(0);
    	List<ErpFunProfit> erpFunProfits =  erpFunProfitMapper.selectByExample(erpFunProfitExample);
    	if(erpFunProfits !=null && erpFunProfits.size() > 0){
    		for (ErpFunProfit erpFunProfit : erpFunProfits) {
				if(erpFunProfit.getUserId() !=null){
					userIds.add(erpFunProfit.getUserId());
				}
			}
    	}
    	//步骤执行人
    	ErpDealUserRelativeExample dealUserRelativeExample = new ErpDealUserRelativeExample();
    	dealUserRelativeExample.setShardCityId(cityId);
    	dealUserRelativeExample.createCriteria().andCompIdEqualTo(compId).andDealIdEqualTo(dealId)
    	.andRelateTypeEqualTo((byte)5);
    	List<ErpDealUserRelative> erpDealUserRelatives = erpDealUserRelativeMapper.selectByExample(dealUserRelativeExample);
    	if(erpDealUserRelatives != null && erpDealUserRelatives.size() > 0){
    		for (ErpDealUserRelative erpDealUserRelative : erpDealUserRelatives) {
    			if(erpDealUserRelative.getUserId() !=null){
					userIds.add(erpDealUserRelative.getUserId());
				}
			}
    	}
    	
    	if(userIds.contains(userId)){
    		userIds.remove(userId);
    	}
    	if(userIds.size() > 0){
    		return new ArrayList<Integer>(userIds);
    	}else{
    		return new ArrayList<Integer>();
    	}
    }
    
    public void setMsgToRelatedPerson(Integer cityId,Integer compId,Integer dealId, Integer userId, List<Integer> userIds,String dealVerifyCon) {
    	ErpFunDeal dealInfo = erpFunDealMapper.getFunDealById(cityId, compId, dealId);
    	//推送小秘书
    	ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
    	erpFunUsersExample.setShardCityId(cityId);
    	erpFunUsersExample.createCriteria().andCompIdEqualTo(compId).andUserWriteoffEqualTo(false).andUserIdIn(new ArrayList<Integer>(userIds));
    	List<ErpFunUsers> erpFunUsersList =  erpFunUsersMapper.selectByExample(erpFunUsersExample);
    	
    	ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(cityId, userId);
    	String currentDeptUserName = erpFunUsers.getUserName();
    	
    	ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(cityId, erpFunUsers.getDeptId());
    	
        String taskSubJect =  "[合同删除] " + erpFunDepts.getDeptCname()+ currentDeptUserName+ "已将编号"+dealInfo.getContractNo()+" 的合同作废";
        
        String content =  erpFunDepts.getDeptCname()+ currentDeptUserName+ "已将编号"+dealInfo.getContractNo()+" 的合同作废";
        if(StringUtil.isNotEmpty(dealVerifyCon)){
        	taskSubJect = taskSubJect+"，作废原因："+dealVerifyCon+"。";
        	content =  content+"，作废原因："+dealVerifyCon+"。";
        }else{
        	taskSubJect = taskSubJect+"。";
        	content =  content+"。";
        } 
        ErpFunTask insertModel = new ErpFunTask();
        insertModel.setCaseId(dealId);
        insertModel.setCaseType(dealInfo.getDealType());

        insertModel.setCompId(compId);
        insertModel.setWarmTime(DateTimeHelper.formatDateTimetoString(new Date()));
        insertModel.setCreationTime(DateTimeHelper.formatDateTimetoString(new Date()));
        insertModel.setTrackWarm(true);
        insertModel.setTaskSubject(taskSubJect);
        insertModel.setTaskDesc(taskSubJect);
        insertModel.setTaskType(Const.DIC_TASK_TYPE_CONTRACT_REMIND);
        insertModel.setTypeFlag(Const.DIC_TASK_TYPE_FLAG_0);
        insertModel.setIsRead(false);
        insertModel.setTaskStatus(Const.DIC_TASK_STATUS_NEW);
        insertModel.setCreatorUid(userId);
        insertModel.setDeptId(erpFunDepts.getDeptId());
        insertModel.setShardCityId(cityId);
        insertModel.setCaseNo(dealInfo.getContractNo());
        Set<Integer> set = new HashSet<>();
        if (erpFunUsersList != null) {
            set = erpFunUsersList.stream().map(ErpFunUsers::getUserId).collect(Collectors.toSet());
        }
        erpFunTaskService.insertTask(cityId, insertModel, set, (byte) 0,1);
       
        
    	if(erpFunUsersList !=null && erpFunUsersList.size() > 0){
        	//发送IM消息
    		for (ErpFunUsers funUsers : erpFunUsersList) {	    			
    			 JSONObject jsonObject = new JSONObject();
    	         jsonObject.put("templateId", "126");
    	         jsonObject.put("receiver", funUsers.getArchiveId());
    	         jsonObject.put("title", "合同删除");
    	         jsonObject.put("content", content);
    	         jsonObject.put("caseType", dealInfo.getDealType());
    	         jsonObject.put("businessId", dealInfo.getDealId());
//	    	         jsonObject.put("caseId", erpFunSale.getSaleId());
//	    	         jsonObject.put("caseType", caseType);
    	         JSONObject param = new JSONObject();
    	         param.put("paramExt", jsonObject.toJSONString());
    			 
                HttpUtil.postJson(AppConfig.getPushWebDomain() + "systemApi/im/send/kafka/pushMsg", param);
			}
    		
    	}
	}

     
	@Override
    public void counterMgrSettleDeal(DealBussinessCommonParam commonParam) throws Exception {
        CounterMgrSettleDealParam param = commonParam.getCounterMgrSettleDealParam();
        GeneralParam generalParam = commonParam.getGeneralParam();

        Integer cityId = generalParam.getCityId();
        Integer compId = generalParam.getCompId();
        Integer dealId = param.getDealId();

        ErpFunDeal baseDealInfo = erpFunDealMapper.getBaseDealInfo(cityId, dealId);
        ErpFunDeal funDeal = new ErpFunDeal();
        funDeal.setDealId(dealId);
        funDeal.setShardCityId(cityId);
        funDeal.setDealStatus(Const.DIC_DEAL_STATUS_WAITDEAL);
        funDeal.setDealVerifyTime(null);
        erpFunDealService.updateDealVerifyTime(funDeal);
        ErpFunProfitExample profitExample = new ErpFunProfitExample();
        profitExample.setShardCityId(cityId);
        ErpFunProfitExample.Criteria profitExampleCriteria = profitExample.createCriteria();
        profitExampleCriteria.andCompIdEqualTo(compId).andDealIdEqualTo(dealId);
        List<ErpFunProfit> profitList = erpFunProfitMapper.selectByExample(profitExample);
        if (profitList == null || profitList.isEmpty()) {
            return;
        }
        profitExampleCriteria.andUserIdGreaterThan(0);
        List<ErpFunProfit> userFunProfits = erpFunProfitMapper.selectByExample(profitExample);
        if (userFunProfits == null || userFunProfits.isEmpty()) {
            return;
        }

        this.counterMgrSettleDeal(param, funDeal, generalParam, baseDealInfo, profitList);

        String archiveIds = profitList.stream().filter(val->(null != val.getArchiveId())).map(val -> val.getArchiveId() + "").collect(Collectors.joining(","));
        erpFunProfitService.countProfitStandard(cityId, compId, archiveIds);
        // 发送消息计算提成金额
        UpdateFunProfitMessage updateFunProfitMessage = new UpdateFunProfitMessage();
        updateFunProfitMessage.setCityId(cityId);
        updateFunProfitMessage.setCompId(compId);
        updateFunProfitMessage.setDealId(dealId);
        updateFunProfitMessage.setDealOpType(7);
        adminJmsMessageService.createProfitDetail(updateFunProfitMessage);
    }

    /**
     * @Title 审核通过的
     * @Author lcb
     * @Time 2019/7/3 10:12
     * @Desc
     **/
    @Override
    public void doUpdateBussinessStatus(DealBussinessCommonParam param, Integer type) {
        // 跟进auditType来处理不同的数据
        Integer auditType = param.getAuditType();
        if (1 == auditType) {
            // 初审
            doUpdateDealAuditStatus(param, type);
        } else if (2 == auditType) {
            //复审
            doUpdateDealAuditStatus(param, type);
        } else if (3 == auditType) {
            // 结算
            doUpdateDealSettleStatus(param, type);
        } else if (4 == auditType) {
            //合同作废
            doUpdateDealAuditStatus(param, type);
        } else if (5 == auditType) {
            //撤销初审
            doUpdateDealAuditStatusByCounter(param, type);
        } else if (6 == auditType) {
            //撤销复审
            doUpdateDealAuditStatusByCounter(param, type);
        } else if (7 == auditType) {
            //撤销结算
            doUpdateCounterMgrSettleDeal(param, type);
        } else if (8 == auditType) {
            //应收
            doUpdateProcessFinceAuditStatus(param, type);
        } else if (9 == auditType) {
            //实收
            doUpdateProcessFinceAuditStatus(param, type);
        } else if (10 == auditType) {
            //撤销应收审核
            doUpdateProcessFinceAuditStatus(param, type);
        } else if (11 == auditType) {
            //撤销实收审核
            doUpdateProcessFinceAuditStatus(param, type);
        }
    }

    // 合同初审状态修改 作废
    // type=0 是审核失败  1=提交审核
    private void doUpdateDealAuditStatus(DealBussinessCommonParam commonParam, Integer type) {
        UpdateDealAuditStatusParam param = commonParam.getUpdateDealAuditStatusParam();
        GeneralParam generalParam = commonParam.getGeneralParam();
        // 将状态变为审核中
        // 合同审核状态 0=未审核，1=初审，2=复审，3=作废 4=初审中  5=复审中  6=作废中
        Map<String, Object> updatePoMap = new HashMap<>();
        if (1 == param.getDealAuditStatus()) {
            if (0 == type) {
                updatePoMap.put("dealAuditStatus", "0");
            } else {
                updatePoMap.put("dealAuditStatus", "5");
            }
        } else if (2 == param.getDealAuditStatus()) {
            if (0 == type) {
                updatePoMap.put("dealAuditStatus", "1");
            } else {
                updatePoMap.put("dealAuditStatus", "6");
            }
        } else if (3 == param.getDealAuditStatus()) {
            ErpFunDeal erpFunDeal = erpFunDealMapper.getBaseDealInfo(generalParam.getCityId(), param.getDealId());
            if (0 == type) {
                if (null == erpFunDeal.getDealAuditStatusBefore()) {
                    throw new BusinessException("数据异常，请联系在线客服");
                }
                // 尼玛 这个地方有点坑 作废状态
                updatePoMap.put("dealAuditStatus", erpFunDeal.getDealAuditStatusBefore());
                updatePoMap.put("dealAuditStatusBefore", "");
            } else {
                updatePoMap.put("dealAuditStatus", "7");
                // 记录作废前的状态
                updatePoMap.put("dealAuditStatusBefore", erpFunDeal.getDealAuditStatus());

            }

        }
        if (updatePoMap.entrySet().size() > 0) {
            erpFunDealMapper.updateDealStatusByDealId(generalParam.getCityId(), param.getDealId(), updatePoMap);
        }
    }

    // 合同初审状态修改
    // type=0 是审核失败  1=提交审核
    private void doUpdateProcessFinceAuditStatus(DealBussinessCommonParam commonParam, Integer type) {
        ProcessFinancStatusParam param = commonParam.getProcessFinancStatusParam();
        GeneralParam generalParam = commonParam.getGeneralParam();
        // 财务款项审核状态0未审，1已审核  2=审核中 3=撤销审核中
        // 审核=1 反审核=0
        if (param.getAuditStatus() == 0) {
            if (0 == type) {
                erpProcessFinancMapper.updateProcessFinancStatus(generalParam.getCityId(), generalParam.getCompId(), param.getDealId(), param.getPfIds().split(","), 1);
            } else {
                erpProcessFinancMapper.updateProcessFinancStatus(generalParam.getCityId(), generalParam.getCompId(), param.getDealId(), param.getPfIds().split(","), 3);
            }
        } else {
            if (0 == type) {
                erpProcessFinancMapper.updateProcessFinancStatus(generalParam.getCityId(), generalParam.getCompId(), param.getDealId(), param.getPfIds().split(","), 0);
            } else {
                erpProcessFinancMapper.updateProcessFinancStatus(generalParam.getCityId(), generalParam.getCompId(), param.getDealId(), param.getPfIds().split(","), 2);
            }
        }
    }

    // 合同结算
    // type=0 是审核失败  1=提交审核
    private void doUpdateDealSettleStatus(DealBussinessCommonParam commonParam, Integer type) {
        SettlementDealParam param = commonParam.getSettlementDealParam();
        GeneralParam generalParam = commonParam.getGeneralParam();
        Map<String, Object> updatePoMap = new HashMap<>();
        if (1 == type) {
            updatePoMap.put("dealStatus", 3);
        } else {
            updatePoMap.put("dealStatus", 1);
        }

        if (updatePoMap.entrySet().size() > 0) {
            erpFunDealMapper.updateDealStatusByDealId(generalParam.getCityId(), param.getDealId(), updatePoMap);
        }

    }

    // type=0 是审核失败  1=提交审核
    private void doUpdateDealAuditStatusByCounter(DealBussinessCommonParam commonParam, Integer type) {
        UpdateDealAuditStatusParam param = commonParam.getUpdateDealAuditStatusParam();
        GeneralParam generalParam = commonParam.getGeneralParam();
        Map<String, Object> updatePoMap = new HashMap<>();
        if (5 == param.getDealAuditStatus()) {
            if (0 == type) {
                updatePoMap.put("dealAuditStatus", "1");
            } else {
                updatePoMap.put("dealAuditStatus", "8");
            }

        } else if (6 == param.getDealAuditStatus()) {
            if (0 == type) {
                updatePoMap.put("dealAuditStatus", "2");
            } else {
                updatePoMap.put("dealAuditStatus", "9");
            }
        }
        if (updatePoMap.entrySet().size() > 0) {
            erpFunDealMapper.updateDealStatusByDealId(generalParam.getCityId(), param.getDealId(), updatePoMap);
        }

    }

    // 反结算
    // type=0 是审核失败  1=提交审核
    private void doUpdateCounterMgrSettleDeal(DealBussinessCommonParam commonParam, Integer type) {
        CounterMgrSettleDealParam param = commonParam.getCounterMgrSettleDealParam();
        GeneralParam generalParam = commonParam.getGeneralParam();
        // 修改为结算中
        Map<String, Object> updatePoMap = new HashMap<>();

        if (0 == type) {
            updatePoMap.put("dealStatus", 2);
        } else {
            updatePoMap.put("dealStatus", 4);
        }
        erpFunDealMapper.updateDealStatusByDealId(generalParam.getCityId(), param.getDealId(), updatePoMap);
    }

    @Override
    public Integer doCheckBussinessStatus(DealAuditCommonParam param, ErpFunDeal erpFunDeal) {
        GeneralParam generalParam = param.getGeneralParam();
        // 跟进auditType来处理不同的数据
        Integer auditType = param.getAuditType();
        if (1 == auditType) {
            // 初审
            if (0 != erpFunDeal.getDealAuditStatus().intValue()) {
                return 1;
            }
        } else if (2 == auditType) {
            //复审
            if (1 != erpFunDeal.getDealAuditStatus().intValue()) {
                return 1;
            }
        } else if (3 == auditType) {
            // 结算
            if (3 == erpFunDeal.getDealStatus().intValue()) {
                return 1;
            }
        } else if (4 == auditType) {
            //合同作废 只有作废中的需要刷新
            if (7 == erpFunDeal.getDealAuditStatus().intValue()) {
                return 1;
            }
        } else if (5 == auditType) {
            //撤销初审
            if (1 != erpFunDeal.getDealAuditStatus().intValue()) {
                return 1;
            }
        } else if (6 == auditType) {
            //撤销复审
            if (2 != erpFunDeal.getDealAuditStatus().intValue()) {
                return 1;
            }
        } else if (7 == auditType) {
            //撤销结算
            if (2 != erpFunDeal.getDealStatus().intValue()) {
                return 1;
            }
        } else if (8 == auditType) {
            ProcessFinancStatusParam processFinancStatusParam = param.getProcessFinancStatusParam();

            if (StringUtils.isBlank(processFinancStatusParam.getPfIds())) {
                return 1;
            }
            // 查询款项状态
            List<ErpProcessFinanc> erpProcessFinancs = erpProcessFinancMapper.selectProcessFinancByPfIds(generalParam.getCityId(), generalParam.getCompId(), processFinancStatusParam.getPfActual(), processFinancStatusParam.getDealId(), processFinancStatusParam.getPfIds().split(","));
            Integer res = 0;
            for (ErpProcessFinanc erpProcessFinanc : erpProcessFinancs) {
                if (!"0".equals(erpProcessFinanc.getAuditStatus())) {
                    res = 1;
                    break;
                }
            }
            return res;
        } else if (9 == auditType) {
            //实收
            ProcessFinancStatusParam processFinancStatusParam = param.getProcessFinancStatusParam();

            if (StringUtils.isBlank(processFinancStatusParam.getPfIds())) {
                return 1;
            }
            // 查询款项状态
            List<ErpProcessFinanc> erpProcessFinancs = erpProcessFinancMapper.selectProcessFinancByPfIds(generalParam.getCityId(), generalParam.getCompId(), processFinancStatusParam.getPfActual(), processFinancStatusParam.getDealId(), processFinancStatusParam.getPfIds().split(","));
            Integer res = 0;
            for (ErpProcessFinanc erpProcessFinanc : erpProcessFinancs) {
                if (!"0".equals(erpProcessFinanc.getAuditStatus())) {
                    res = 1;
                    break;
                }
            }
            return res;
        } else if (10 == auditType) {
            //撤销应收审核
            ProcessFinancStatusParam processFinancStatusParam = param.getProcessFinancStatusParam();

            if (StringUtils.isBlank(processFinancStatusParam.getPfIds())) {
                return 1;
            }
            // 查询款项状态
            List<ErpProcessFinanc> erpProcessFinancs = erpProcessFinancMapper.selectProcessFinancByPfIds(generalParam.getCityId(), generalParam.getCompId(), processFinancStatusParam.getPfActual(), processFinancStatusParam.getDealId(), processFinancStatusParam.getPfIds().split(","));
            Integer res = 0;
            for (ErpProcessFinanc erpProcessFinanc : erpProcessFinancs) {
                if (!"1".equals(erpProcessFinanc.getAuditStatus())) {
                    res = 1;
                    break;
                }
            }
            return res;
        } else if (11 == auditType) {
            //撤销应收审核
            ProcessFinancStatusParam processFinancStatusParam = param.getProcessFinancStatusParam();

            if (StringUtils.isBlank(processFinancStatusParam.getPfIds())) {
                return 1;
            }
            // 查询款项状态
            List<ErpProcessFinanc> erpProcessFinancs = erpProcessFinancMapper.selectProcessFinancByPfIds(generalParam.getCityId(), generalParam.getCompId(), processFinancStatusParam.getPfActual(), processFinancStatusParam.getDealId(), processFinancStatusParam.getPfIds().split(","));
            Integer res = 0;
            for (ErpProcessFinanc erpProcessFinanc : erpProcessFinancs) {
                if (!"1".equals(erpProcessFinanc.getAuditStatus())) {
                    res = 1;
                    break;
                }
            }
            return res;
        }
        return 0;
    }

    @Transactional
    @Override
    public String createDealTrack(GeneralParam generalParam, CreateDealTrackParam param) {
        Integer cityId = generalParam.getCityId();
        Integer compId = generalParam.getCompId();
        Integer userId = generalParam.getUserId();
        Integer deptId = generalParam.getDeptId();
        String deptName = generalParam.getDeptName();
        Integer grId = generalParam.getGrId();
        String grName = generalParam.getGrName();
        Integer dealId = param.getDealId();
        Integer runstepId = param.getRunstepId();
        String runstepName = param.getRunstepName();
        String trackContent = param.getTrackContent();
        String warmContent = param.getWarmContent();
        String warmUser = param.getWarmUser();
        String trackIds = "";
        // 判断是否是提醒，是就先写跟进在发送提醒消息
        if (StringUtil.isNotBlank(warmContent) && null != warmUser) {
            ErpFunDealTrack erpFunDealTrack = new ErpFunDealTrack();
            erpFunDealTrack.setShardCityId(cityId);
            erpFunDealTrack.setClassName("【提醒】");
            erpFunDealTrack.setCompId(compId);
            erpFunDealTrack.setCreationTime(DateTimeHelper.getSystemDate());
            erpFunDealTrack.setDealId(dealId);
            erpFunDealTrack.setDeptId(deptId);
            erpFunDealTrack.setDeptName(deptName);
            erpFunDealTrack.setGrId(grId);
            erpFunDealTrack.setGrName(grName);
            erpFunDealTrack.setTrackWarm(true);
            erpFunDealTrack.setUserId(userId);
            erpFunDealTrack.setWarmContent(warmContent);
            erpFunDealTrack.setWarmUser(warmUser);
            erpFunDealTrackMapper.insertSelective(erpFunDealTrack);
            Integer trackId = erpFunDealTrack.getTrackId();
            trackIds += trackId + ",";
        }

        // 判断是否有跟进内容，有就需要需要写跟进
        if (StringUtil.isNotBlank(trackContent)) {
            ErpFunDealTrack erpFunDealTrack = new ErpFunDealTrack();
            erpFunDealTrack.setShardCityId(cityId);
            String className = null;
            if (StringUtil.isNotBlank(runstepName)) {
                className = "【" + runstepName + "】";
            }
            erpFunDealTrack.setClassName(className);
            erpFunDealTrack.setCompId(compId);
            erpFunDealTrack.setCreationTime(DateTimeHelper.getSystemDate());
            erpFunDealTrack.setDealId(dealId);
            erpFunDealTrack.setDeptId(deptId);
            erpFunDealTrack.setDeptName(deptName);
            erpFunDealTrack.setGrId(grId);
            erpFunDealTrack.setGrName(grName);
            erpFunDealTrack.setRunstepId(runstepId);
            erpFunDealTrack.setRunstepName(runstepName);
            erpFunDealTrack.setTrackContent(trackContent);
            erpFunDealTrack.setTrackWarm(false);
            erpFunDealTrack.setUserId(userId);
            erpFunDealTrackMapper.insertSelective(erpFunDealTrack);
            Integer trackId = erpFunDealTrack.getTrackId();
            trackIds += trackId + "";
        }
        if (StringUtil.isNotBlank(trackIds) && trackIds.endsWith(",")) {
            trackIds = trackIds.substring(0, trackIds.length() - 1);
        }
        return trackIds;
    }

    @Transactional
    @Override
    public void createSsqContract(ErpSsqContract erpSsqContract, ErpFunDeal erpFunDeal) {
        erpSsqContractMapper.insertSelective(erpSsqContract);
        erpFunDealMapper.updateByPrimaryKeySelective(erpFunDeal);
    }

    @Override
    public Integer canSeeFunDealPhoto(CanSeeFunDealPhotoParam param, GeneralParam generalParam) {
        Integer cityId = generalParam.getCityId();
        Integer userId = generalParam.getUserId();
        Integer compId = generalParam.getCompId();
        Integer dealId = param.getDealId();

        ErpFunDeal condition = new ErpFunDeal(cityId, param.getDealId());
        ErpFunDeal erpFunDeal = erpFunDealMapper.selectByPrimaryKey(condition);

        if (erpFunDeal == null) {
            throw new BusinessException("合同不存在！");
        }

        // DEAL_INITIAL_REVIEW: 合同初审权, DEAL_REPEAT_REVIEW: 合同复审权, WARRANT_MANAGE: 权证流程管理权, DEAL_SETTLEMENT_DEAL: 合同结算权
        List<String> opers = Arrays.asList("DEAL_INITIAL_REVIEW", "DEAL_REPEAT_REVIEW", "WARRANT_MANAGE", "DEAL_SETTLEMENT_DEAL");

        ErpUserOpersExample erpFunOpersExample = new ErpUserOpersExample();
        erpFunOpersExample.setShardCityId(cityId);
        erpFunOpersExample.createCriteria().andUserIdEqualTo(userId).andOperIdIn(opers);
        int count = erpUserOpersMapper.countByExample(erpFunOpersExample);
        // 客源经纪人直接可看
        Integer custUserUid = erpFunDeal.getCustUserUid();

        if (count > 0 || (custUserUid != null && custUserUid.equals(userId))) {
            return 1;
        }

        // 查看自己的合同查看权范围
        // 合同文件，具xx合同查看权的人可以查看合同客源经纪人是自己权限范围内的合同文件
        // 例如：合同查看权范围是门店，那么他可以查看合同客源经纪人是自己店的合同文件
        if (custUserUid != null) {
            Map<String, Boolean> dealViewAuthMap = this.getDealViewAuthMap(cityId, userId);
            if (dealViewAuthMap != null && dealViewAuthMap.size() > 0) {
                ErpFunUsers custUser = erpFunUsersMapper.selectDataByUserId(cityId, compId, custUserUid);
                ErpFunUsers selfUser = erpFunUsersMapper.selectDataByUserId(cityId, compId, userId);

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

                boolean isSameArea = selfUser.getAreaId().equals(custUser.getAreaId());
                boolean isSameReg = selfUser.getRegId().equals(custUser.getRegId());
                boolean isSameDept = selfUser.getDeptId().equals(custUser.getDeptId());
                boolean isSameGr = !selfUser.getGrId().equals(0) && !custUser.getGrId().equals(0) && selfUser.getGrId().equals(custUser.getGrId());

                boolean canView = viewCompDeal || (viewAreaDeal && isSameArea) ||
                        (viewRegDeal && isSameReg) || (viewDeptDeal && isSameDept) || (viewGrDeal && isSameGr);

                if (canView) {
                    return 1;
                }
            }
        }

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

        // 线下签约 且在初审前
        if (signType == 0 && dealAuditStatus != null && dealAuditStatus == 0) {
            return 0;
        }

        if (signType == 1) {
            // 在线签约, 双方签约前
            ErpSsqContractExample erpSsqContractExample = new ErpSsqContractExample();
            erpSsqContractExample.setShardCityId(cityId);
            erpSsqContractExample.createCriteria().andDealIdEqualTo(dealId).andIsDelEqualTo((byte) 0);
            List<ErpSsqContract> ssqContracts = erpSsqContractMapper.selectByExample(erpSsqContractExample);
            if (CollectionUtils.isEmpty(ssqContracts)) {
                return 0;
            }
            // 出现签约前的, 则返回不能看(签约前: 没有作废, 并且没有完成)
            long before = ssqContracts.stream().filter(it -> it.getContractStatus() != null && it.getContractStatus() == 0).count();
            if (before > 0) {
                return 0;
            }
        }

        // 流程总负责人 指定执行人 签约人 签约主管, 在线下签约初审后或者在线签约签约后, 都可以看合同附件
        Integer dealUserId = erpFunDeal.getDealUserId();
        Integer signUserId = erpFunDeal.getSignUserId();
        Integer signManagerId = erpFunDeal.getSignManagerId();


        ErpProcessRuntimeStepExample erpProcessRuntimeStepExample = new ErpProcessRuntimeStepExample();
        erpProcessRuntimeStepExample.setShardCityId(cityId);
        erpProcessRuntimeStepExample.createCriteria().andCompIdEqualTo(compId).andDealIdEqualTo(dealId).andDelFlagEqualTo((byte) 0);
        List<ErpProcessRuntimeStep> steps = erpProcessRuntimeStepMapper.selectByExample(erpProcessRuntimeStepExample);
        Set<Integer> executors =  steps.stream().filter(it -> it.getUpdateUser() != null).map(ErpProcessRuntimeStep::getUpdateUser).collect(Collectors.toSet());

        boolean userCanSee = (dealUserId != null && dealUserId.equals(userId)) ||
                (CollectionUtils.isNotEmpty(executors) && executors.contains(userId)) ||
                (signUserId != null && signUserId.equals(userId)) ||
                (signManagerId != null && signManagerId.equals(userId));

        if (userCanSee) {
            return 1;
        }

        return 0;
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

}

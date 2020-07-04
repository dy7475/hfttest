package com.myfun.repository.admindb.dao;

import com.github.pagehelper.Page;
import com.myfun.erpWeb.onlinepay.param.DealRecordCountParam;
import com.myfun.erpWeb.usercenter.param.CashRecordParam;
import com.myfun.erpWeb.usercenter.param.GetPaidListParam;
import com.myfun.erpWeb.usercenter.param.InvoiceWritedParam;
import com.myfun.erpWeb.usercenter.param.UcenterIncomePayRecordParam;
import com.myfun.erpWeb.usercenter.vo.AdminFunPaidVo;
import com.myfun.erpWeb.usercenter.vo.InvoiceNotWritedVo;
import com.myfun.repository.admindb.dto.AdminFunPaidDto;
import com.myfun.repository.admindb.param.AdminCrmAcountsParam;
import com.myfun.repository.admindb.param.AdminCrmPresentParam;
import com.myfun.repository.admindb.param.AdminFunPaidParam;
import com.myfun.repository.admindb.param.AdminPaidCountParam;
import com.myfun.repository.admindb.po.AdminFunPaid;
import com.myfun.repository.admindb.po.AdminFunPaidExample;
import com.myfun.repository.admindb.po.AdminFunPaidKey;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.mybatis.common.BaseMap;
import com.myfun.repository.support.mybatis.query.*;
import com.myfun.utils.Constants_DIC;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


public interface AdminFunPaidMapper extends BaseMapper<AdminFunPaid, AdminFunPaidKey> {

    /**
     * @mbggenerated
     */
    int countByExample(AdminFunPaidExample example);

    /**
     * @mbggenerated
     */
    int deleteByExample(AdminFunPaidExample example);

    /**
     * @mbggenerated
     */
    List<AdminFunPaid> selectByExample(AdminFunPaidExample example);

    /**
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminFunPaid record, @Param("example") AdminFunPaidExample example);

    /**
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminFunPaid record, @Param("example") AdminFunPaidExample example);

    List<AdminFunPaidDto> getAdminFunPaidList(AdminFunPaidParam adminCrmGiftParam);

    BigDecimal getCrmPaidAmountAcount(AdminFunPaidParam adminFunPaidParam);

    Float getActualSales(AdminCrmAcountsParam acounts);

    int updateByCondition(AdminCrmPresentParam presentParam);

    /**
     * 消费类别统计
     *
     * @param adminPaidCountParam
     * @return
     */
    ArrayList<AdminPaidCountDto> sumPaid(AdminPaidCountParam adminPaidCountParam);

    /**
     * ERP,CRM查询统计
     *
     * @param faaType
     * @param paidSource
     * @param adminPaidCountParam
     * @return
     */
    Page<AdminFunPaidDto> selectByTypeAndOther(@Param("faaType") String faaType, @Param("paidSource") String paidSource,
                                               @Param("adminPaidCountParam") AdminPaidCountParam adminPaidCountParam);

    List<AdminFunPaid> getFunPaidByArchiveId(Integer archiveId);

    AdminFunPaid selectByCondition(AdminFunPaid funPaid);

    AdminFunPaid getPaidRecord(AdminFunPaid funPaid);

    List<AdminFunPaid> getFunPaidByArchiveIdAndPaidType(Map<String, Object> condition);

    void updateCardNo(AdminFunPaid funPaid);

    //	@SelectProvider(method="getPaidList",type=FunPaidSqlProvider.class)
//	@ResultMap("BaseResultMap")
//	@Param("param")Map<String,Object>
    List<AdminFunPaidVo> getPaidList(@Param("param") GetPaidListParam param);

    List<AdminFunPaid> getShareMoneyPaidList(@Param("archiveId") Integer archiveId);

    List<Map<String, Object>> getFunPaidRecordList(@Param("param") UcenterIncomePayRecordParam param);

    List<Map<String, Object>> getCashMoneyRecord(@Param("param") UcenterIncomePayRecordParam param);

    List<AdminFunPaid> getOnlinePayPaidCount(DealRecordCountParam param);

    class FunPaidSqlProvider {
        public String getPaidList(Map<String, Object> pMap) throws Exception {
            BaseMap param = (BaseMap) pMap.get("param");
            String tableName = "FUN_PAID";
            Condition condition = new Condition();
            // 收入还是支出 INCOME=收入 PAY=支出  GIFT=赠送
            if (!StringUtils.isBlank(param.getString("paidCatigory"))) {
                if ("INCOME".equals(param.getString("paidCatigory"))) {// 查询收入的时候把赠送的也查出来
                    Condition conSub = new Condition();
                    conSub.add(new ConditionItem("PAID_CATIGORY", "=", "INCOME"));
                    conSub.add(Condition.OR, new ConditionItem("PAID_CATIGORY", "=", "GIFT"));
                    condition.add(conSub);
                } else {
                    condition.add(new ConditionItem("PAID_CATIGORY", "=", "#{param.paidCatigory}"));
                }
            }
            // 支付类型
            if (!StringUtils.isBlank(param.getString("paidType"))) {
                if ("OTHER".equals(param.getString("paidType"))) {
                    condition.add(new ConditionItem("PAID_TYPE", "NOT IN", new String[]{"VOIP", "BIDDING", "HOUSE_BIDDING", "TRUEHOUSE_LIGHT", "SRV_QUAN", "CLEAR4PAST"}));
                } else {
                    condition.add(new ConditionItem("PAID_TYPE", "=", param.getString("paidType")));
                }
            }
            // 排除优家消费记录
            condition.add(new ConditionItem("PAID_TYPE", "NOT IN", new String[]{"YOU_GET_VIEW_FEE", "YOU_RETURN_VIEW_FEE",
                    "YOU_SHARE_TRUE_HOUSE", "YOU_RETURN_TRUE_HOUSE", "YOU_WITHDRAWALS_WEIXIN",
                    "YOU_PAY_VIEW_FEE", "YOU_GET_BUYOUT_WUYE", "YOU_PAY_BUYOUT_WUYE",
                    "YOU_WITHDRAWALS_ACCOUNT"
            }));
            // 支付方式
            String paidMode = param.getString("paidMode");
            if ("0".equals(paidMode)) {// 其他
                condition.add(new ConditionItem("AMOUNT_COIN", "<=", "0"));
                condition.add(new ConditionItem("AMOUNT_QUAN", "<=", "0"));
            } else if ("1".equals(paidMode)) {// 好房币
                condition.add(new ConditionItem("AMOUNT_COIN", ">", "0"));
            } else if ("2".equals(paidMode)) {// 优惠券
                condition.add(new ConditionItem("AMOUNT_QUAN", ">", "0"));
            }
            // 时间范围
            String dateRange = param.getString("dateRange");
            if (!StringUtils.isBlank(dateRange)) {
                String[] val = dateRange.split("~");
                // 必须是两个单位
                if (val.length == 2 && !StringUtils.isBlank(val[0]) && !StringUtils.isBlank(val[1])) {
                    condition.add(new ConditionItem("PADI_TIME", ">=", val[0]));
                    condition.add(new ConditionItem("PADI_TIME", "<=", val[1] + " 23:59:59"));// 这里必须添加时间结束;
                }
            } else if (!StringUtils.isBlank(param.getString("date"))) {
                String[] conStr = ConditionUtil.getConditionDate(param.getString("date"));
                String creationTime1 = conStr[0];
                String creationTime2 = conStr[1];
                ConditionUtil.builderTimeAreaCondition(condition, creationTime1, creationTime2, "PADI_TIME");
            }
            if (param.getBoolean("isGeneralManager")) {
                Condition conSelf = new Condition();
                Condition conTotle = new Condition();
                conSelf.add(new ConditionItem("UA_ID", "=", "#{param.uaId}"));
                conSelf.add("OR", new ConditionItem("ARCHIVE_ID", "=", "#{param.currentArchiveId}"));
                Condition conComp = new Condition();
                conComp.add(new ConditionItem("UA_ID", "=", "#{param.compUaId}"));
                String paidAccount = param.getString("paidAccount");
                if ("1".equals(paidAccount)) {
                    condition.add(conSelf);
                } else if ("2".equals(paidAccount)) {
                    condition.add(conComp);
                } else {
                    conTotle.add(conSelf);
                    conTotle.add("OR", conComp);
                    condition.add(conTotle);
                }
            } else {
                // 非总经理查看公司账户消费记录时直接返回空
                if ("2".equals(param.getString("paidAccount"))) {
                    return null;
                }
                Condition conAccount = new Condition();
                conAccount.add(new ConditionItem("UA_ID", "=", "#{param.compUaId}"));
                conAccount.add("OR", new ConditionItem("ARCHIVE_ID", "=", "#{param.currentArchiveId}"));
                condition.add(conAccount);
                condition.add(new ConditionItem("PAID_TYPE", "!=", "VOIP"));
            }
            // 不为1的才显示  --zhl 微店在个人中心购买还是联系销售购买，联系销售购买的不查询出来
            condition.add(new ConditionItem("REAL_WEIXIN", "!=", Constants_DIC.DIC_IS_REAL_WEIXIN));

            Columns columns = new Columns(new String[]{
                    "PAID_ID",
                    "UA_ID",
                    "ARCHIVE_ID",
                    "CITY_ID",
                    "PAID_CATIGORY",
                    "PAID_TYPE",
                    "CARDNO",
                    "ORDERNO",
                    "AMOUNT",
                    "PADI_TIME",
                    "DEAL_ID",
                    "[STATUS]",
                    "OLD_TIME",
                    "[DESC]",
                    "AMOUNT_BEFORE",
                    "AMOUNT_AFTER",
                    "CRM_COMP_ID",
                    "PAID_SOURCE",
                    "REAL_WEIXIN",
                    "AMOUNT_QUAN",
                    "AMOUNT_COIN",
            });
            String orderBy = "PAID_ID DESC";
            SQL sql = SqlFactory.createDelFaultSelectSql(tableName, false, condition, columns, orderBy, null);
            return SQLBuilderSupport.constructSQLForSelect(sql).toString();
        }
    }

    List<AdminFunPaidDto> getInvoiceHasWritedList(@Param("param") InvoiceWritedParam param);

    List<AdminFunPaidDto> getManagerInvoiceHasWritedList(@Param("param") InvoiceWritedParam param);

    List<AdminFunPaidDto> getDetailPaidList(@Param("invoiceId") Integer invoiceId);

    /**
     * 查询保证金流水记录
     *
     * @param archiveId
     * @return
     * @author 张宏利
     * @since 2018年3月19日
     */
    List<AdminFunPaid> getTrueHousePiadList(@Param("archiveId") Integer archiveId);

    @AccessReadonlyDb
    List<AdminFunPaidVo> getCashRecordList(@Param("param") CashRecordParam param);

    List<AdminFunPaidVo> getHfCoinRecordList(@Param("param") CashRecordParam param);

    List<AdminFunPaidVo> getTrueHouseLightRecordList(@Param("param") CashRecordParam param);

    List<AdminFunPaidVo> getBrokerInvitePrizeRecordList(@Param("param") CashRecordParam param);

    List<AdminFunPaidVo> getO2ORecordList(@Param("param") CashRecordParam param);

    List<AdminFunPaidVo> getSRVRecordList(@Param("param") CashRecordParam param);

    /**
     * 查询发票历史
     *
     * @return
     * @author 朱科
     * @since 2018年7月13日
     */
    @SwitchDB(type = SwitchDBType.ARCHIVE_ID)
    List<AdminFunPaidDto> getInvoiceList(@Param("cityId") Integer cityId, @Param("shardArchiveId") Integer archiveId, @Param("invoiceType") Integer invoiceType, @Param("compId") Integer compId, @Param("generalManagerFlag") boolean generalManagerFlag, @Param("padiTimeStart") String padiTimeStart);

    /**
     * 查询待开发票的消费记录
     *
     * @return
     * @author 朱科
     * @since 2018年7月16日
     */
    List<AdminFunPaidDto> getPaidDetailList(@Param("invoiceId") Integer invoiceId);

    /**
     * 查询门店和vip的数量
     *
     * @param paidId
     * @return
     */
    @AccessReadonlyDb
    Map<String, Integer> getDeptAndVipcountByPaid(@Param("paidIdList") List<Integer> paidIdList);

    /**
     * 查询订单的总额
     *
     * @param paidIdList
     * @return
     */
    Double getAmountByPaidId(@Param("paidIdList") List<Integer> paidIdList);

    @AccessReadonlyDb
    List<InvoiceNotWritedVo> getInvoiceNotWritedListForGeneral(@Param("shardCityId") Integer cityId, @Param("param") InvoiceWritedParam param);

    @AccessReadonlyDb
    List<InvoiceNotWritedVo> getInvoiceNotWritedListForUser(@Param("shardCityId") Integer cityId, @Param("param") InvoiceWritedParam param);

    @SwitchDB(type = SwitchDBType.CITY_ID)
    @AccessReadonlyDb
    Float sumBeanGot(@Param("shardCityId") Integer cityId, @Param("uaId") Integer uaId, @Param("filterTime") Date filterTime);

    @SwitchDB(type = SwitchDBType.ARCHIVE_ID)
    @AccessReadonlyDb
    AdminPaidCountDto getAllHaofangAmount(@Param("uaId") Integer uaId, @Param("isUseUaId") boolean isUseUaId, @Param("filterTime") Date filterTime);

}


package com.myfun.repository.admindb.dao;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;

import com.myfun.repository.admindb.dto.AdminFunIssueInvoiceDto;
import com.myfun.repository.admindb.po.AdminFunIssueInvoice;
import com.myfun.repository.admindb.po.AdminFunIssueInvoiceExample;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.mybatis.common.BaseMap;
import com.myfun.repository.support.mybatis.query.Columns;
import com.myfun.repository.support.mybatis.query.Condition;
import com.myfun.repository.support.mybatis.query.ConditionItem;
import com.myfun.repository.support.mybatis.query.SQL;
import com.myfun.repository.support.mybatis.query.SQLBuilderSupport;
import com.myfun.repository.support.mybatis.query.SqlFactory;
import com.myfun.utils.DateTimeHelper;

public interface AdminFunIssueInvoiceMapper extends BaseMapper<AdminFunIssueInvoice, Integer> {
    /**
	 * @mbggenerated
	 */
	int countByExample(AdminFunIssueInvoiceExample example);
	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminFunIssueInvoiceExample example);
	/**
	 * @mbggenerated
	 */
	List<AdminFunIssueInvoice> selectByExample(
			AdminFunIssueInvoiceExample example);
	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminFunIssueInvoice record,
			@Param("example") AdminFunIssueInvoiceExample example);
	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminFunIssueInvoice record,
			@Param("example") AdminFunIssueInvoiceExample example);
	@SelectProvider(method ="getInvoiceDetail", type=AdminFunIssueInvoiceSqlProvider.class)
    @ResultMap("DtoBaseResultMap")
	@AccessReadonlyDb
    List<AdminFunIssueInvoiceDto> getInvoiceDetail(@Param("param") BaseMap baseMap);
//    @SelectProvider(method ="countEffectiveInvoice", type=AdminFunIssueInvoiceSqlProvider.class)
//    @ResultType(Integer.class)
	@AccessReadonlyDb
	Integer countEffectiveInvoice(@Param("startTime")String startTime,@Param("endTime") String endTime,@Param("aduitDate")String aduitDate);
    class AdminFunIssueInvoiceSqlProvider{
    	/*public String getInvoiceList(Map<String,Object> pMap){
    		BaseMap baseMap = (BaseMap) pMap.get("param");
    		String tableName = " hft_admindb.dbo.FUN_PAID fp left JOIN hft_admindb.dbo.FUN_ISSUE_INVOICE fi on fp.paid_id = fi.paid_id ";
    		Condition condition = new Condition();
    		condition.add(new ConditionItem("fp.REAL_WEIXIN","!=", Constants_DIC.DIC_IS_REAL_WEIXIN));
    		String type = baseMap.getString("type");
    		if("2".equals(type)) {
    			// 查询历史
    			// 查询待开发票
    			// 总经理
    			if(baseMap.getBoolean("isGeneralManager")) {
    				Condition archiveCondition = new Condition();
    				archiveCondition.add(new ConditionItem("fp.ARCHIVE_ID", "IN", new SQL(SQL.SELECT,"select archive_Id from fun_users where user_writeoff=0 and comp_id = ? and archive_id <> ?", new String[]{operator.getCompId(), operator.getArchiveId()})));
    				archiveCondition.add(new ConditionItem("fp.PAID_TYPE", "IN", new String[]{"O2O","UPGRADE_SRV","PAY_WEIXIN","BUYDEPT"}));
    				// 自己的数据
    				Condition selfCondition = new Condition();
    				selfCondition.add(new ConditionItem("fp.ARCHIVE_ID", "=", pMap.get("currentArchiveId")));
    				selfCondition.add(new ConditionItem("fp.PAID_TYPE", "IN", new String[]{"O2O","UPGRADE_SRV","PAY_WEIXIN","BUYDEPT","SRV"}));
    				archiveCondition.add(Condition.OR, selfCondition);
    				condition.add(archiveCondition);
    				
    			}else { // 非总经理
    				condition.add(new ConditionItem("fp.ARCHIVE_ID", "=", baseMap.get("currentArchiveId")));
    			}
    		}
    		return null;
    	}*/
    	public String getInvoiceDetail(Map<String,Object> pMap) {
    		String tableName = "FUN_ISSUE_INVOICE fi left join FUN_PAID_INVOICERELATIVE pi on fi.INVOICE_ID = pi.INVOICE_ID";
    		String orderBy = "fi.INVOICE_ID desc";
    		Columns columns = new Columns(new String[]{
    				"fi.*"
    		});
    		Condition condition = new Condition();
    		condition.add(new ConditionItem("fi.INVOICE_ID", "=", "#{param.invoiceId}"));
    		SQL sql = SqlFactory.createDelFaultSelectSql(tableName, false, condition, columns, orderBy, null);
			return 	SQLBuilderSupport.constructSQLForSelect(sql).toString();
    	}
    	
    	public String countEffectiveInvoice(Map<String,Object> pMap) {
    		String tableName = " FUN_ISSUE_INVOICE ";
    		Columns columns = new Columns(new String[]{
    				"COUNT(1) as ATTR"
    		});
    		Condition condition = new Condition();
    		condition.add(new ConditionItem("INVOICE_ID", "=", "#{invoiceId}"));
    		Condition queryCondition = new Condition();
    		queryCondition.add(new ConditionItem("APPLY_TIME", ">=", "#{param.startTime}"));
    		queryCondition.add(new ConditionItem("APPLY_TIME", "<=", "#{param.endTime}"));
    		Calendar countDate = Calendar.getInstance();
    		countDate.add(Calendar.DAY_OF_MONTH, -3);
    		Condition subCondition = new Condition();
    		Condition subOneCondition = new Condition();
    		subCondition.add(new ConditionItem("INVOICE_STATUS","NOT IN",new Object[]{"1","6"}));
    		subCondition.add(Condition.OR,subOneCondition);
    		subOneCondition.add(new ConditionItem("INVOICE_STATUS","=","1"));
    		subOneCondition.add(new ConditionItem("ADUIT_DATE",">",DateTimeHelper.formatDateTimetoString(countDate.getTime())));
    		queryCondition.add(subCondition);
    		SQL sql = SqlFactory.createDelFaultSelectSql(tableName, false, condition, columns, null, null);
    		return 	SQLBuilderSupport.constructSQLForSelect(sql).toString();
    	}
    }
    
    /**
     * 查询发票数量
     * @param paidId
     * @param invoiceTypes
     * @return
     */
    @AccessReadonlyDb
	Integer getInvoiceCount(@Param("paidId") Integer paidId, @Param("invoiceTypes") List<Byte> invoiceTypes);
	
	 /**
     * 查询发票数量通过一种发票类型
     * @param paidId
     * @param invoiceTypes
     * @return
     */
	Integer getInvoiceCountByOneType(@Param("paidIdList") List<Integer> paidIdList);
}
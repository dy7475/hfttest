package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.managecenter.financialStatements.param.PaySettlementListParam;
import com.myfun.repository.erpdb.dto.ErpProcessFinancDto;
import com.myfun.repository.erpdb.param.QueryDealPfActualParam;
import com.myfun.repository.erpdb.po.ErpProcessFinanc;
import com.myfun.repository.erpdb.po.ErpProcessFinancExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.mybatis.query.Condition;
import com.myfun.repository.support.mybatis.query.ConditionItem;
import com.myfun.utils.DateTimeHelper;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ErpProcessFinancMapper extends BaseMapper<ErpProcessFinanc, ErpProcessFinanc> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpProcessFinancExample example);
	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpProcessFinancExample example);
	/**
	 * @mbggenerated
	 */List<ErpProcessFinanc> selectByExample(ErpProcessFinancExample example);
	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpProcessFinanc record,@Param("example") ErpProcessFinancExample example);
	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpProcessFinanc record,@Param("example") ErpProcessFinancExample example);
	Map<String, Object> getFinancComssionInfoByDealId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("dealId")Integer dealId);
	List<Map<String, Object>> getFinancComssionInfoNameByDealId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("dealId")Integer dealId);

	Map<String, Object> getInitProcessFinanc(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("dealId")Integer dealId);
	

	@SwitchDB(type = SwitchDBType.CITY_ID)
    List<ErpProcessFinancDto> getList(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,@Param("dealId") Integer dealId);


	List<ErpProcessFinanc> getPfActualListOffDeal(@Param("shardCityId")Integer cityId, @Param("param")QueryDealPfActualParam param);
	
	
	List<ErpProcessFinanc> getProcessFinancList(@Param("shardCityId") Integer cityId,@Param("param") PaySettlementListParam map);

	int countProcessFinanc(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("pfActual") Integer pfActual,@Param("dealId") Integer dealId,@Param("pfIdArr") String[] pfIdArr);
	List<ErpProcessFinanc> selectProcessFinancByPfIds(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("pfActual") Integer pfActual,@Param("dealId") Integer dealId,@Param("pfIdArr") String[] pfIdArr);

	void updateProcessFinanc(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("pfActual") Integer pfActual,@Param("pfIdArr") String[] pfIdArr,@Param("dealId") Integer dealId,@Param("param") Map<String,Object> param);

	ErpProcessFinancDto getFinancActualgetByDeal(@Param("shardCityId")Integer cityId,@Param("dealId") Integer dealId);

	ErpProcessFinancDto getProcessFinancDtoByDealId(@Param("shardCityId")Integer cityId,@Param("dealId") Integer dealId);

	List<ErpProcessFinanc> getHasFinancList(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("dealId") Integer dealId);

	void delProcessFinanc(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("dealId") Integer dealId, @Param("pfIds") String[] pfIds, @Param("pfActual") Integer pfActual);

	ErpProcessFinancDto getProcessFinancByDealId(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("dealId") Integer dealId);

	List<ErpProcessFinanc> getProcessFinancListByDealId(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("dealId") Integer dealId);

	void updateProcessFinancStatus(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("dealId")Integer dealId, @Param("pfIds")String[] pfIds, @Param("auditStatus")Integer auditStatus);

    BigDecimal sumPayAmount(@Param("shardCityId")Integer cityId, @Param("erpProcessFinanc") ErpProcessFinanc erpProcessFinanc);

    class ErpProcessSqlProvider {
		public String getPfActualListOffDeal(Map<String,Object> pMap){
			QueryDealPfActualParam param = (QueryDealPfActualParam)pMap.get("Param");
			String pfPayer = param.getPfPayer();
			Integer auditStatus = param.getAuditStatus();
			Integer auditUser = param.getAuditUser();
			String paymentId = param.getPaymentId();
			List<Integer> dealIds = param.getDealIds();
			Object[] paymentIds = param.getPaymentIds();
			String pfActual = param.getPfActual();//getString("PF_ACTUAL");
			String dateType = param.getDateType();//getString("DATE_TYPE");
			String performanceType = param.getPerformanceType();//getString("PERFORMANCE_TYPE");
			String pfTime = param.getPfTime();
			String startTime = param.getStartTime();
			String endTime = param.getEndTime();
			Condition condition = new Condition();
			condition.add(new ConditionItem("COMP_ID","=",param.getCompId()));
			if (StringUtils.isNotBlank(pfPayer)) {
				condition.add(new ConditionItem("PF_PAYER", "=", pfPayer));
			}
			if (auditStatus!=null) {
				condition.add(new ConditionItem("AUDIT_STATUS", "=", auditStatus));
			}
			if (auditUser != null) {
				condition.add(new ConditionItem("AUDIT_USER", "=", auditUser));
			}
			if(StringUtils.isNotBlank(performanceType)){
				condition.add(new ConditionItem("PERFORMANCE_TYPE","=",performanceType));
			}
			if (paymentIds!=null) {
				condition.add(new ConditionItem("PAYMENT_ID","IN",paymentIds));
			}
			if (paymentId!=null) {
				condition.add(new ConditionItem("PAYMENT_ID","=",paymentId));
			}
			
			if (StringUtils.isNotBlank(pfActual)) {
				condition.add(new ConditionItem("PF_ACTUAL", "=", pfActual));
			}
			
			if (StringUtils.isNotBlank(dateType)) {
				if ("AUDIT_DATE".equals(dateType)) {
					if (StringUtils.isNotBlank(startTime)) {
						condition.add(new ConditionItem("AUDIT_TIME", ">=", startTime));
					}
					if (StringUtils.isNotBlank(endTime)) {
						condition.add(new ConditionItem("AUDIT_TIME", "<=", endTime));
					}
				}
			}
			
			if (StringUtils.isNotBlank(pfTime)) {
				condition.add(new ConditionItem("PF_TIME", ">=",DateTimeHelper.formatDateTimetoString(startTime, "yyyy-MM-dd 00:00:00")));
				condition.add(new ConditionItem("PF_TIME", "<=",DateTimeHelper.formatDateTimetoString(endTime, "yyyy-MM-dd 23:59:59")));
			}
			
			StringBuilder tableNameBuilder = new StringBuilder(" FUN_DEAL A join PROCESS_FINANC B ON A.DEAL_ID=B.DEAL_ID ");
			if ("SIGN_USER_ID".equals(param.getUserType())) {
				tableNameBuilder.append(" JOIN FUN_USERS C ON C.USER_ID=A.SIGN_USER_ID ");
			} else {
				tableNameBuilder.append(" JOIN FUN_USERS C ON C.USER_ID=B.AUDIT_USER ");
			}
			StringBuilder sqlBuilder = new StringBuilder(" select * from PROCESS_FINANC ");
			sqlBuilder.append(" where ");
			if (param.getDealSize()>2000) {
				sqlBuilder.append(condition.getConditionStatement());
				Condition queryCondition = new Condition();
				ErpFunDealMapper.ErpFunDealMapperSqlProvider.buildPfActualOffDealCondition(queryCondition, param);
				StringBuilder subSqlBuilder = new StringBuilder();
				subSqlBuilder.append(" select distinct A.DEAL_ID from ").append(tableNameBuilder);
				subSqlBuilder.append(" where ").append(queryCondition.getConditionStatement());
				sqlBuilder.append(" and DEAL_ID IN(").append(subSqlBuilder.toString()).append(")");
			} else {
				condition.add(new ConditionItem("DEAL_ID", "in" , dealIds ));
				sqlBuilder.append(condition.getConditionStatement());
			}
			return sqlBuilder.toString();
		}
	}
	void delBillPhoto(@Param("shardCityId") Integer cityId,@Param("financId") Integer financId);
	
	List<ErpProcessFinanc> getFinancListByDealId(@Param("shardCityId") Integer cityId,@Param("dealId")Integer dealId, @Param("pfActual")String pfActual);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpProcessFinanc> getProcessFinancByDealIds(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("dealIdList") List<Integer> dealIdList);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	String getPfTimeByDealId(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("dealId") Integer dealId);
}
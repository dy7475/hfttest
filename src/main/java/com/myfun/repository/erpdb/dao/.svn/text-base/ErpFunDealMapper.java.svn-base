package com.myfun.repository.erpdb.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.myfun.erpWeb.managecenter.financialStatements.param.FinancialStatementsMonthlyShopReportParam;
import com.myfun.erpWeb.managecenter.financialStatements.param.PaySettlementListParam;
import com.myfun.erpWeb.managecenter.financialStatements.vo.ErpFunDealFinanceVo;
import com.myfun.erpWeb.managecenter.param.DealStatictisListParam;
import com.myfun.erpWeb.managecenter.profit.param.FinancAuditListParam;
import com.myfun.erpWeb.managecenter.profit.vo.FinancAuditListVO;
import com.myfun.erpWeb.managecenter.profit.vo.SignStatisticsListVO;
import com.myfun.erpWeb.openApi.analysis.param.AnalysisForWebParam;
import com.myfun.repository.erpdb.dto.*;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import com.myfun.erpWeb.managecenter.financialStatements.param.ProfitPercentParam;
import com.myfun.erpWeb.managecenter.transaction.param.DealContractParam;
import com.myfun.erpWeb.managecenter.transaction.vo.DealContractDto;
import com.myfun.repository.erpdb.param.ErpFunProfitDetailParam;
import com.myfun.repository.erpdb.param.ProfitDragonTigerParam;
import com.myfun.repository.erpdb.param.QueryDealListParam;
import com.myfun.repository.erpdb.param.QueryDealPfActualParam;
import com.myfun.repository.erpdb.po.ErpFunDeal;
import com.myfun.repository.erpdb.po.ErpFunDealExample;
import com.myfun.repository.erpdb.po.ErpFunFinancPayment;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.mybatis.common.BaseMap;
import com.myfun.repository.support.mybatis.query.Condition;
import com.myfun.repository.support.mybatis.query.ConditionItem;
import com.myfun.repository.support.param.DaoBaseParam;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.DateUtil;
import com.myfun.utils.StringUtil;

@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpFunDealMapper extends BaseMapper<ErpFunDeal, ErpFunDeal> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunDealExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunDealExample example);

	/**
	 * @mbggenerated
	 */List<ErpFunDeal> selectByExample(ErpFunDealExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpFunDeal record,@Param("example") ErpFunDealExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpFunDeal record,@Param("example") ErpFunDealExample example);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateHouseForReg(@Param("shardCityId")Integer cityId, @Param("pMap")Map<String, Object> pMap);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	Integer selectDealBulletListCount(@Param("shardCityId")Integer cityId, @Param("param")DaoBaseParam param);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<DealBulletDto> selectDealBulletList(@Param("shardCityId")Integer cityId, @Param("param")DaoBaseParam param);

	ErpFunDeal selectByDealId(@Param("shardCityId")Integer cityId, @Param("dealId")Integer dealId,@Param("columns") String[] columns);
	/**
	 * 合同号段详情查询
	 * @author 何传强
	 * @since 2017年7月12日
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<ErpFunDeal> getDealFunDealCodeInfo(@Param("shardCityId") Integer cityId, @Param("param") Map<String, Object> param);
	@SwitchDB(type = SwitchDBType.DB_NAME)
	List<ErpFunDeal> getDealListOrderByDealIdDesc(@Param("shardDbName")String shardDbName, @Param("dealId")Integer lastDealId);

	List<Map<String, Object>> getFunProfitCount(@Param("shardCityId")Integer cityId, @Param("param")ProfitDragonTigerParam param, @Param("countFiledName")String countFiledName);

	List<Map<String, Object>> getFunProfitReportDealCount(@Param("shardCityId")Integer cityId, @Param("param") ProfitDragonTigerParam param);

	List<Map<String, Object>> getFunProfitReportOfficialOrdersCountCount(@Param("shardCityId")Integer cityId, @Param("param") ProfitDragonTigerParam param);

	List<Map<String, Object>> getDealHouseDistributionSituationOffTopFour(@Param("shardCityId")Integer cityId, @Param("param") Map<String, Object> map);

	Map<String, Object> getDealHouseDistributionSituationOffTotal(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);

	List<Map<String, Object>> getTransactionCycleDeptRank(@Param("shardCityId")Integer cityId, @Param("param") Map<String, Object> map);
	/**
	 * 签单量,签单率(有合同)
	 * @author 何传强
	 * @since 2017年7月25日
	 * @param cityId
	 * @param param
	 * @return
	 */
	public List<ErpFunStatisticRateDto> getSignRateCountHasDeal(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);

	/**
	 * 转换率分析报表 - 签单量有合同的
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param param
	 * @return
	 */
	@ResultType(value = Map.class)
	@SelectProvider(type=ErpFunDealMapperSqlProvider.class ,method = "getSignOperationalDataAnalysisHasDealReport")
	List<Map<String, Object>> getSignOperationalDataAnalysisHasDealReport(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	
	/**
	 * 转换率分析图表 - 成交总量有合同
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param param
	 * @return
	 */
	@SelectProvider(type=ErpFunDealMapperSqlProvider.class ,method = "getOperationalDataAnalysisHouseCjCount")
	@ResultType(value = Map.class)
	public List<Map<String, Object>> getOperationalDataAnalysisHouseCjCount(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	
	/**
	 * 转换率分析柱状图 - 成交总量有合同的
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param param
	 * @return
	 */
	@SelectProvider(type=ErpFunDealMapperSqlProvider.class ,method = "getSignOperationalDataAnalysisPie")
	@ResultType(value = Map.class)
	public Map<String, Object> getSignOperationalDataAnalysisDealPie(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	
	/**
	 * 转换率分析图表 - 成交对比
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param param
	 * @return
	 */
	public List<Map<String, Object>> getCjContrastOffRatioAnalysis(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);

	/**
	 * 转换率分析图表 - 成交总量
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param param
	 * @return
	 */
	public Map<String, Object> getTotalCjContrastOffRatioAnalysis(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	
	/**
	 * 获取符合条件的列表
	 * @author 臧铁
	 * @since 2017年8月7日
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getHouseCustFlowAnalysisCountList(@Param("shardCityId")Integer cityId,@Param("param") Map<String, Object> map);
	
	/**
	 * 有合同成交率-报表
	 * @author 何传强
	 * @since 2017年7月29日
	 * @param cityId
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getSignRateCountHasDealReport(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
	
	/**
	 * 无合同成交率-报表
	 * @author 何传强
	 * @since 2017年7月29日
	 * @param cityId
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getSignRateCountNoDealReport(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);

	/**
	 * 签单量,签单率 (无合同)
	 * @author 何传强
	 * @since 2017年7月25日
	 * @param cityId
	 * @param param
	 * @return
	 */
	public List<ErpFunStatisticRateDto> getSignRateCountNoDeal(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
	@SwitchDB(type = SwitchDBType.CITY_ID)
    ErpFunDeal selectFunDealByContractId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("contractId")Integer contractId);


	/**
	 * 转换率分析报表 - 签单量没有合同的
	 * @author 方李骥
	 * @since 2017年7月26日
	 * @param param
	 * @return
	 */
	@SelectProvider(type=ErpFunDealMapperSqlProvider.class ,method = "getSignOperationalDataAnalysisNoDealReport")
	@ResultType(value = Map.class)
	
	public List<Map<String, Object>> getSignOperationalDataAnalysisNoDealReport(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	
	/**
	 * 获取合同列表
	 * @author 方李骥
	 * @since 2017年9月26日
	 * @param param
	 * @return
	 */
	@SelectProvider(type=ErpFunDealMapperSqlProvider.class ,method = "getDealList")
	@ResultMap(value = { "extBaseResultMap" })
	List<ErpFunDealExtVO> getDealList(@Param("shardCityId")Integer cityId, @Param("param")QueryDealListParam param) ;
	/**
	 * 获取合同列表
	 * @author 方李骥
	 * @since 2017年9月26日
	 * @param param
	 * @return
	 */
	@SelectProvider(type=ErpFunDealMapperSqlProvider.class ,method = "getDealTotalPrice")
	@ResultType(value = Map.class)
	Map<String,Object> getDealTotalPrice(@Param("shardCityId")Integer cityId, @Param("param")QueryDealListParam param) ;
	/**
	 * 获取合同条数
	 * @author 方李骥
	 * @since 2017年9月26日
	 * @param param
	 * @return
	 */
	@SelectProvider(type=ErpFunDealMapperSqlProvider.class ,method = "getDealTotalCount")
	@ResultType(value = int.class)
	int getDealTotalCount(@Param("shardCityId")Integer cityId, @Param("param")QueryDealListParam param) ;

	Map<String, Object> sumYsSsAmount(@Param("shardCityId") Integer cityId, @Param("pfActual") Integer pfActual,
			@Param("param") ErpFunProfitDetailParam param, @Param("assessMentMonthSet") Set<String> assessMentMonth,@Param("dealIdSet") Set<Integer> dealIdSet);

	Map<String,Object>    sumJsAmount(@Param("shardCityId")Integer cityId, @Param("dealIdList") List<Integer> ysDealIdList);
	
	/**
	 * 获取合同列表
	 * @param 
	 * @auther 胡坤
	 * @since 2018/4/28
	 * @return 
	 * 
	 */
	List<ErpFunDeal> getDealListByMap(@Param("shardCityId")Integer cityId, @Param("param") DealStatictisListParam param);
	
	List<ErpFunDeal> getFunDealList(@Param("shardCityId") Integer cityId,@Param("param") ErpFunDeal param);
	
	List<Map<String,ErpFunFinancPayment>> getFinancialStatementsMonthlyShopReport(@Param("shardCityId") Integer cityId,  @Param("param")FinancialStatementsMonthlyShopReportParam param);
	
	List<ErpFunDealFinanceVo> getDealListByTableName(@Param("shardCityId") Integer cityId, @Param("param") PaySettlementListParam map);

	List<DealContractDto> getDealContractList(@Param("shardCityId") Integer cityId,@Param("param") DealContractParam param);

    List<ErpFunDealDto> getListOFExcuteByMap(@Param("shardCityId") Integer cityId,@Param("param") DealContractParam param);

	Integer getDealByMap(@Param("shardCityId") Integer cityId,@Param("param") DealContractParam param);

	Integer selectSeqDealId(@Param("shardCityId")Integer cityId);

	/**
	 * 获取业绩龙虎榜的成交价格分布
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/30
	 */
	List<ErpFunDealDto> getCompTransactionDistribution(@Param("shardCityId") Integer cityId,@Param("param") Map<String,Object> param);

	List<ErpFunDealDto> getListOFExcuteByParam(@Param("shardCityId") Integer cityId,@Param("param") Map<String,Object> param);

	List<ErpFunDealDto> getDealCountListByParam(@Param("shardCityId") Integer cityId,@Param("param") Map<String,Object> param);

	List<ErpFunDealDto> getofficialOrdersCountListByParam(@Param("shardCityId") Integer cityId,@Param("param") Map<String,Object> param);

	/**
	 * 查询目标业绩
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/31
	 */
	List<ErpFunDealDto> getTargetListByParam(@Param("shardCityId") Integer cityId,@Param("param") Map<String,Object> param);

	BigDecimal sumTotalNeedPerformance(@Param("shardCityId")Integer cityId, @Param("dealId")Integer dealId);

	ErpFunDeal getFunDealById(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId, @Param("dealId")Integer dealId);

	List<ErpFunDealDto> getDealListOne(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("dealId") Integer dealId);

	ErpFunDeal getBaseDealInfo(@Param("shardCityId")Integer cityId,@Param("dealId")Integer dealId);

	void updateWarrantsDates(ErpFunDeal model);

	void updateDealUser(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("dealId") Integer dealId);

	/**
	 * @tag 清空合同流程负责人 放款时间 等等
	 * @author 邓永洪
	 * @since 2018/6/29
	 */
	void cleanFunDealData(@Param("shardCityId")Integer cityId,@Param("dealId") Integer dealId);

	void updateDealVerifyTime( ErpFunDeal funDeal);

	Integer getDealLockFlagList(@Param("shardCityId")Integer cityId,@Param("param") ErpFunDeal param);

	void updateDealStatusByDealId(@Param("shardCityId")Integer cityId,@Param("dealId") Integer dealId,@Param("param") Map<String,Object> param);

	Integer getPageCountByMap(@Param("shardCityId")Integer cityId, @Param("param")DealStatictisListParam param);

	List<Integer> getRepeatDealIds(@Param("shardCityId")Integer cityId,@Param("param") DealContractParam param);


	void updateAgreementNoByDealId(@Param("shardCityId")Integer cityId,@Param("dealNo") String dealNo,@Param("dealId") Integer dealId);

	List<Map<String,Object>> countSaleDeal(@Param("shardCityId")Integer cityId,@Param("param") AnalysisForWebParam param);

	List<Map<String,Object>> countLeaseDeal(@Param("shardCityId")Integer cityId,@Param("param") AnalysisForWebParam param);

    List<SignStatisticsListVO> selectSignList(@Param("shardCityId")Integer cityId, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("statisticsType") Integer statisticsType, @Param("ids")List<Integer> ids);

	List<FinancAuditListVO> selectFinancAuditList(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId, @Param("param")FinancAuditListParam param);

    List<Integer> selectGroupByDeptOrGr(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("statisticsType") Integer statisticsType);

	List<SignStatisticsListVO> selectLeaseAndSellDealNum(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("statisticsType") Integer statisticsType, @Param("ids")List<Integer> ids);

	List<ErpFunDealDto> getListOFExcuteByParamNewPrg(@Param("shardCityId") Integer cityId,@Param("param") Map<String,Object> param);

	List<ErpFunDealDto> getDealCountListByParamNewPrg(@Param("shardCityId") Integer cityId,@Param("param") Map<String,Object> param);

	List<ErpFunDealDto> getofficialOrdersCountListByParamNewPrg(Integer cityId, Map<String, Object> map);

	List<ErpFunDealDto> getTargetListByParamNewOrg(@Param("shardCityId") Integer cityId,@Param("param") Map<String,Object> param);

	List<Map<String, String>> getPercentProfitListNewOrg(@Param("shardCityId")Integer cityId, @Param("param")ProfitPercentParam param);


	public class ErpFunDealMapperSqlProvider{
		public String getDealTotalCount(Map<String,Object> pMap) throws Exception{
			QueryDealListParam queryDealListParam = (QueryDealListParam)pMap.get("param");
			StringBuilder countBuilder = new StringBuilder();
			countBuilder.append(" select count(DISTINCT A.DEAL_ID) as ATTR_NAME ");
			Condition condition = buildQueryDealListCondition(pMap);
			countBuilder.append(buildTableSqlPart(queryDealListParam, condition));
			return countBuilder.toString();

		}
		private Condition buildQueryDealListCondition(Map<String,Object> pMap) throws Exception{
			QueryDealListParam queryDealListParam = (QueryDealListParam)pMap.get("param");
			Integer currentUserId = queryDealListParam.getCurrentUserId();
			Integer userId = queryDealListParam.getUserId();
			Integer areaId = queryDealListParam.getAreaId();
			Integer regId = queryDealListParam.getRegId();
			Integer deptId = queryDealListParam.getDeptId();
			Integer grId = queryDealListParam.getGrId();
			Integer organizationId = queryDealListParam.getOrganizationId();
			boolean newOrganization = queryDealListParam.isNewOrganization();
			String bkName = queryDealListParam.getBankName();
			Condition condition = new Condition();
			condition.add(new ConditionItem("A.COMP_ID","=",queryDealListParam.getCompId()));
			if (StringUtil.isNotBlank(bkName)) {
				String[] nameList = bkName.split(",");
				for (String bName : nameList) {
					Condition queryBankCondition = new Condition();
					queryBankCondition.add(new ConditionItem("A.COMMERCIAL_LENDER_BANK", "like", "%" + bName + "%"));
					queryBankCondition.add(Condition.OR,
							new ConditionItem("A.PROVIDENT_LENDER_BANK", "like", "%" + bName + "%"));
					condition.add(queryBankCondition);
				}
			}
			if (!newOrganization && !currentUserId.equals(userId)) {
				if (areaId!=null) {
					condition.add(new ConditionItem("B.AREA_ID", "=", areaId));
				}
				if (regId!=null) {
					condition.add(new ConditionItem("B.REG_ID", "=", regId));
				}
				if (deptId!=null) {
					condition.add(new ConditionItem("B.DEPT_ID", "=", deptId));
				}
				if (grId!=null) {
					condition.add(new ConditionItem("B.GR_ID", "=", grId));
				}
			}
			//新版组织机构，查询组织机构时直接使用合同相关人中ORGANIZATION_PATH进行查询   ↑↑↑↑↑上面这个方法是老版的查询方式，需要前端传不同层级结构的ID
			if(newOrganization && null != organizationId && organizationId != 0){
				condition.add(new ConditionItem("B.ORGANIZATION_PATH", "LIKE", "%:"+organizationId+":%"));
			}
			// 房源编号、房源地址、房源片区、楼盘名称、业主姓名、业主身份证、业主电话、客源编号、客户姓名、客户身份证、客户电话
			/**
			 * 指定合同的人员查询 判空 主要是用于最开是查询的时候没有数据开始===== 1 创建人 2主办人 3 签约人 4签约主管
			 */
			if (userId!=null) {
				if(queryDealListParam.getArchiveIds() != null && queryDealListParam.getArchiveIds().size() > 0){
					condition.add(new ConditionItem("B.ARCHIVE_ID", "IN", queryDealListParam.getArchiveIds().toArray()));
				}else{
					condition.add(new ConditionItem("B.ARCHIVE_ID", "=", queryDealListParam.getArichveId()));
				}
			}
			/** 指定合同的人员查询 结束===== */
			if (StringUtil.isNotBlank(queryDealListParam.getDealType())) {// 合同的类型
				condition.add(new ConditionItem("A.DEAL_TYPE", "=", queryDealListParam.getDealType()));
			}

			if (StringUtil.isNotBlank(queryDealListParam.getIntelligentSearch())) {// 合同编号
				condition.add(new ConditionItem("A.INTELLIGENT_SEARCH", "like", "%" + queryDealListParam.getIntelligentSearch() + "%"));
			}
			if (StringUtil.isNotBlank(queryDealListParam.getDealAuditStatus())) {
				if (Constants_DIC.DIC_DEAL_COMPLETE_NOTFAIL.equals(queryDealListParam.getDealAuditStatus())) {
					condition.add(new ConditionItem("A.DEAL_AUDIT_STATUS", "!=", Constants_DIC.DIC_DEAL_COMPLETE_FAIL));
				} else {
					condition.add(new ConditionItem("A.DEAL_AUDIT_STATUS", "=", queryDealListParam.getDealAuditStatus()));
				}
			}
			if (StringUtil.isNotBlank(queryDealListParam.getDealStatus())) {
				if (Constants_DIC.DIC_DEAL_STATUS_NOTDEAL.equals(queryDealListParam.getDealStatus())) {
					condition.add(new ConditionItem("A.DEAL_STATUS", "!=", Constants_DIC.DIC_DEAL_STATUS_DEALOVER));
				} else {
					condition.add(new ConditionItem("A.DEAL_STATUS", "=", queryDealListParam.getDealStatus()));
				}
			}
			if (StringUtil.isNotBlank(queryDealListParam.getYouAduitStatus())) {
				condition.add(new ConditionItem("A.YOU_ADUIT_STATUS", "=", queryDealListParam.getYouAduitStatus()));
			}
			if (StringUtil.isNotBlank(queryDealListParam.getProcessStatus())) {
				if (Constants_DIC.DIC_DEAL_STATUS_NOTTRANSACT.equals(queryDealListParam.getProcessStatus())) {
					condition.add(new ConditionItem("A.PROCESS_STATUS", "!=", Constants_DIC.DIC_DEAL_STATUS_TRANSACT));
				} else {
					condition.add(new ConditionItem("A.PROCESS_STATUS", "=", queryDealListParam.getProcessStatus()));
				}
			}
			if (null != queryDealListParam.getPayTypeId()) {

				if(null != queryDealListParam.getYoujiaPayTypeId()) {
					Condition payTypeCondition = new Condition();
					payTypeCondition.add(new ConditionItem("A.PAYTYPE_ID", "=", queryDealListParam.getPayTypeId()));
					payTypeCondition.add(Condition.OR, new ConditionItem("A.PAYTYPE_ID", "=", queryDealListParam.getYoujiaPayTypeId()));
					condition.add(payTypeCondition);
				}else {
					condition.add(new ConditionItem("A.PAYTYPE_ID", "=", queryDealListParam.getPayTypeId()));
				}

			}
			if (StringUtil.isNotBlank(queryDealListParam.getHouseUseage())) {
				condition.add(new ConditionItem("A.HOUSE_USEAGE", "=", queryDealListParam.getHouseUseage()));
			}
			if (StringUtil.isNotBlank(queryDealListParam.getBuildId())) {
				condition.add(new ConditionItem("A.BUILD_ID", "in", queryDealListParam.getBuildId().split(",")));
			}
			if (StringUtil.isNotBlank(queryDealListParam.getBuildName())) {
				condition.add(new ConditionItem("A.BUILD_NAME", "like", "%" + queryDealListParam.getBuildName() + "%"));
			}
			if (StringUtil.isNotBlank(queryDealListParam.getCategoryId())) {// 合同类别查询
				condition.add(new ConditionItem("A.CATEGORY_ID", "=", queryDealListParam.getCategoryId()));
			}
			if (StringUtil.isNotBlank(queryDealListParam.getRentPayMethod())) {
				condition.add(new ConditionItem("A.RENT_PAY_METHOD", "=", queryDealListParam.getRentPayMethod()));
			}
			String dateType = queryDealListParam.getDateType();
			dateType = "A." + dateType;
			if (StringUtil.isNotBlank(queryDealListParam.getDate())) {
				String[] conStr = DateUtil.getConditionDate(queryDealListParam.getDate());
				String creationTime1 = conStr[0];
				String creationTime2 = conStr[1];
				if (StringUtil.isNotBlank(creationTime1)) {
					condition.add(new ConditionItem(dateType, ">=", DateTimeHelper.formatDateTimetoString(creationTime1, "yyyy-MM-dd 00:00:00")));
				}
				if (StringUtil.isNotBlank(creationTime2)) {
					condition.add(new ConditionItem(dateType, "<=", DateTimeHelper.formatDateTimetoString(creationTime2, "yyyy-MM-dd 23:59:59")));
				}
			}
			// 另一种是直接上传起止时间
			if (StringUtil.isNotBlank(queryDealListParam.getDateRange())) {
				String[] val = queryDealListParam.getDateRange().split("~");
				// 必须是两个单位
				if (val.length == 2 && StringUtil.isNotBlank(val[0]) && StringUtil.isNotBlank(val[1])) {
					// 此逻辑有效期至 9999 年
					if (StringUtil.isNotBlank(val[0]) && val[0].length() <= "2015-05".length()) {
						val[0] = DateUtil.getFirstDateOfMonth(val[0] + "-01");
					}
					if (StringUtil.isNotBlank(val[1])) {
						if (val[1].length() <= "2015-05".length()) {
							val[1] = DateUtil.getFirstDateOfNextMonth(val[1] + "-01");
						} else {
							val[1] = DateUtil.getNextDate(val[1]);// 返回的年月日
						}
					}
					condition.add(new ConditionItem(dateType, ">=", val[0]));
					// 这里必须添加时间结束; 陈文超添加；这里应该是小于第二天，否则成交信息会多统计一天的数据，所以这里改为小于
					// 看后期会不会在其他地方遇到问题，测试权证流程和成交信息在调用这，改为小于没问题
					condition.add(new ConditionItem(dateType, "<", val[1]));
				}
			}
			if (StringUtil.isNotBlank(queryDealListParam.getFinancName())) {
				condition.add(new ConditionItem("A.FINANC_NAME","!=","已结清"));
			} else if (null != queryDealListParam.getFinancStatusId()){
				condition.add(new ConditionItem("A.FINANC_STATUS_ID","=",queryDealListParam.getFinancStatusId()));
			}
			condition.add(new ConditionItem("A.ISBYHAND", "=", "0"));
			return condition;
			
		}
		public String getDealTotalPrice(Map<String,Object> pMap) throws Exception{
			QueryDealListParam queryDealListParam = (QueryDealListParam)pMap.get("param");
			Condition condition = buildQueryDealListCondition(pMap);
			StringBuilder priceBuilder = new StringBuilder();
			priceBuilder.append(
					"select sum(SELL_DEAL_MONEY) as sellDealMoney,sum(TOTAL_NEED_INCOME) as totalNeedIncome,sum(TOTAL_REAL_INCOME) as totalRealIncome,sum(TOTAL_REAL_PERFORMANCE) AS totalRealPerformance,sum(COMMERCIAL_LOAN_MONEY) AS commercialLoanMoney,sum(AREA) AS area");
			priceBuilder.append(" FROM FUN_DEAL WHERE DEAL_ID IN (");
			priceBuilder.append("SELECT A.DEAL_ID ");
			priceBuilder.append(buildTableSqlPart(queryDealListParam, condition)).append(")");
			return priceBuilder.toString();
		}
		public String getDealList(Map<String,Object> pMap) throws Exception{
			QueryDealListParam queryDealListParam = (QueryDealListParam)pMap.get("param");
			Integer pageNum = queryDealListParam.getPageOffset();
			Integer pageRows = queryDealListParam.getPageRows();
			StringBuilder sBuilder = new StringBuilder();
			// build - body
			sBuilder.append(
					"select DISTINCT A.PROCESS_END_TIME,A.DEAL_ID,A.DEAL_TYPE,A.PAYTYPE_ID,A.RENT_DEPOSIT_PAY,A.PAYTYPE_NAME,A.AGREEMENT_NO,A.CONTRACT_NO,A.HOUSEADDRESS,A.OWNER_STYLE,A.FINANC_STATUS_ID,A.AREA,A.REAL_TOTALPRICE,A.SELL_DEAL_MONEY,A.RENT_DEAL_MONEY,");
			sBuilder.append(
					"A.RENT_PRICE_UNIT,A.HOUSE_USEAGE,A.CREATOR_DATE,A.CREATOR_UID,A.CREATOR_NAME,A.DEAL_USER_ID,A.DEAL_USER_NAME,A.DEAL_AUDIT_STATUS,A.DEAL_STATUS,A.UPDATE_TIME,A.DEAL_HOUSE_ID,");
			sBuilder.append(
					"A.DEAL_CUSTOMER_ID,A.MODEL_ID,A.MODEL_NAME,A.COMP_ID,A.SALE_PRICE_UNIT,A.DEAL_CUSTOMER_NO,A.DEAL_HOUSE_NO,A.BUY_OWNER_NAME,A.SELL_OWNER_NAME,A.BUY_OWNER_NAME_BAK,");
			sBuilder.append(
					"A.SELL_OWNER_NAME_BAK,A.BUY_ID_CARD,A.SELL_ID_CARD,A.BUY_ID_CARD_BAK,A.SELL_ID_CARD_BAK,A.CUST_USERNAME,A.CUST_USER_UID,A.HOUSE_USERNAME,A.HOUSE_USER_UID,A.BUY_CALL_PHONE,A.SELL_CALL_PHONE,A.CUST_DEPT_ID,");
			sBuilder.append(
					"A.HOUSE_DEPT_ID,A.SELL_ADDRESS,A.SIGN_USER_DEPT_ID,A.BUY_MORTGAGE_TYPE,A.SIGN_USER_NAME,A.SIGN_MANAGER_NAME,A.SELL_ISHAVE_LOAN,A.OWNER_NO,A.LANDCARD_NO,A.TAX,A.MANGEMENT_TAX,");
			sBuilder.append(
					"A.OWNER_TAX,A.DEAL_AUDIT_STATUS_BEFORE,A.SIGN_USER_DEPT_NAME,A.RENT_DATE,A.RENT_OVER_DATE,A.RENT_PAY_EARLY,A.RENT_OTHER_MONEY,A.RENT_PAY_METHOD,A.RENT_PAY_SPACE,A.GOODSDETAILED,A.WATERLIGHTEXPENSES,");
			sBuilder.append(
					"A.SELL_ADDRESS,A.FINANC_NAME,A.CATEGORY_ID,A.CATEGORY_NAME,A.DEAL_BUY_STYLE,A.DEAL_SELL_STYLE,A.DEAL_VERIFY_TIME,A.SIGN_DATE,A.TRANSFER_DATE,A.EVIDENCE_DATE");
			sBuilder.append(
					",A.RUNSTEP_NAME,A.PROCESS_STATUS,A.BUY_CUSTOMER_PHONEENCODE,A.SELL_OWNER_PHONEENCODE,A.TOTAL_NEED_INCOME,A.TOTAL_REAL_INCOME,A.TOTAL_NEED_PERFORMANCE,A.TOTAL_REAL_PERFORMANCE,A.NEED_ADUIT_STATUS,A.REAL_ADUIT_STATUS,");
			sBuilder.append(
					"A.BUY_CUSTOMER_PHONE,A.RENT_PAY_METHOD,A.SELL_OWNER_PHONE,A.COMMERCIAL_LOAN_MONEY,A.PROVIDENT_LOAN_MONEY,A.COMMERCIAL_LOAN_DATE,A.COMMERCIAL_LENDER_DATE,A.COMMERCIAL_LENDER_LIMIT,A.COMMERCIAL_LENDER_BANK,A.PROVIDENT_LOAN_DATE,A.PROVIDENT_LENDER_DATE,A.PROVIDENT_LENDER_LIMIT,A.PROVIDENT_LENDER_BANK");
			sBuilder.append(
					",A.YOU_ADUIT_STATUS,A.BUILD_REG_ID,A.BUILD_REG_NAME, A.YOU_ADUIT_STATUS_PROTOCOL,A.PROTOCOL_ID,A.BUILD_ID,A.BUILD_NAME,A.SIGN_USER_ID,A.SIGN_USER_ARCHIVE,A.ENTRUST_BANK,A.ENTRUST_MONEY,A.FIRST_TRIAL_COMPLETE_DATE,A.RECHECK_COMPLETE_DATE,A.INVALID_COMPLETE_DATE ");
			Condition condition = buildQueryDealListCondition(pMap);
			sBuilder.append(buildTableSqlPart(queryDealListParam, condition));
			sBuilder.append(" order by ");
			String orderBy = queryDealListParam.getOrderBy();
			if (StringUtil.isBlank(orderBy)) {
				orderBy = " A.UPDATE_TIME DESC ,A.DEAL_AUDIT_STATUS ASC,A.DEAL_STATUS ASC ";
			} else if (orderBy.equals("DEAL_AUDIT_STATUS ASC") || orderBy.equals("DEAL_AUDIT_STATUS DESC") || orderBy.equals("DEAL_AUDIT_STATUS")) {
				orderBy = " A." + orderBy + " ";
			} else if (orderBy.equals("DEAL_STATUS ASC") || orderBy.equals("DEAL_STATUS DESC") || orderBy.equals("DEAL_STATUS")) {
				orderBy = " A." + orderBy + " ";
			} else {
				orderBy = " A." + orderBy + ",A.DEAL_AUDIT_STATUS ASC,A.DEAL_STATUS ASC ";
			}
			sBuilder.append(orderBy);
			sBuilder.append(" OFFSET " + ((pageNum - 1) * pageRows) + " ROW FETCH NEXT " + pageRows+ " ROWS ONLY");
			return sBuilder.toString();
			
		}
		private String buildTableSqlPart(QueryDealListParam queryDealListParam,Condition condition) throws Exception{
			String userFlag = queryDealListParam.getFlag();
			StringBuilder footBuilder = new StringBuilder();
			footBuilder.append(" from FUN_DEAL A ");
			if (Constants_DIC.DIC_RELATE_TYPE_CREATOR.equals(userFlag)) {
				footBuilder.append(" join DEAL_USER_RELATIVE B on ");
				footBuilder.append("A.DEAL_ID = B.DEAL_ID and B.RELATE_TYPE = " + Constants_DIC.DIC_RELATE_TYPE_CREATOR
						+ " and A.DEAL_ID = B.DEAL_ID");
			} else if (Constants_DIC.DIC_RELATE_TYPE_DEALUSER.equals(userFlag)) {
				footBuilder.append(" join DEAL_USER_RELATIVE B on ");
				footBuilder.append("A.DEAL_ID = B.DEAL_ID and B.RELATE_TYPE = " + Constants_DIC.DIC_RELATE_TYPE_DEALUSER
						+ " and A.DEAL_ID = B.DEAL_ID");
			} else if (Constants_DIC.DIC_RELATE_TYPE_SIGNUSER.equals(userFlag)) {
				footBuilder.append(" join DEAL_USER_RELATIVE B on A.DEAL_ID = B.DEAL_ID and B.RELATE_TYPE = "
						+ Constants_DIC.DIC_RELATE_TYPE_SIGNUSER + " and A.DEAL_ID = B.DEAL_ID");
			} else if (Constants_DIC.DIC_RELATE_TYPE_SIGNMANAGE.equals(userFlag)) {
				footBuilder.append(" join DEAL_USER_RELATIVE B on A.DEAL_ID = B.DEAL_ID and B.RELATE_TYPE = "
						+ Constants_DIC.DIC_RELATE_TYPE_SIGNMANAGE + " and A.DEAL_ID = B.DEAL_ID");
			} else if (Constants_DIC.DIC_RELATE_TYPE_STEPUSER.equals(userFlag)) {
				footBuilder
						.append(" left join PROCESS_RUNTIME_STEP C ON A.DEAL_ID = C.DEAL_ID join DEAL_USER_RELATIVE B ON C.DEAL_ID = B.DEAL_ID and C.DEAL_ID = B.DEAL_ID and B.RELATE_TYPE = "
								+ Constants_DIC.DIC_RELATE_TYPE_STEPUSER);
				Condition orCondition = new Condition();
                orCondition.add(new ConditionItem("C.DEL_FLAG", "=", "0"));
                orCondition.add(Condition.OR, new ConditionItem("C.DEL_FLAG","IS", "NULL", true));
                condition.add(orCondition);
			} else if (Constants_DIC.DIC_RELATE_TYPE_HOUSEUSER.equals(userFlag)) {
				footBuilder.append(" join DEAL_USER_RELATIVE B on A.DEAL_ID = B.DEAL_ID and B.RELATE_TYPE = "
						+ Constants_DIC.DIC_RELATE_TYPE_HOUSEUSER + " and A.DEAL_ID = B.DEAL_ID");
			} else if (Constants_DIC.DIC_RELATE_TYPE_CUSTUSER.equals(userFlag)) {
				footBuilder.append(" join DEAL_USER_RELATIVE B on A.DEAL_ID = B.DEAL_ID and B.RELATE_TYPE = "
						+ Constants_DIC.DIC_RELATE_TYPE_CUSTUSER + " and A.DEAL_ID = B.DEAL_ID");
			} else if (Constants_DIC.DIC_RELATE_TYPE_PROFIT.equals(userFlag)) {
				footBuilder.append(" join FUN_PROFIT B on A.DEAL_ID = B.DEAL_ID ");
			} else if (StringUtil.isBlank(userFlag)) {
				footBuilder.append(" join DEAL_USER_RELATIVE B on A.DEAL_ID = B.DEAL_ID");
				footBuilder.append(" and B.COMP_ID=" + queryDealListParam.getCompId());
			}

			// 关联签约门店
//			footBuilder.append(" join FUN_DEPTS c on A.SIGN_USER_DEPT_ID = c.DEPT_ID");
			footBuilder.append(" where " + condition.getConditionStatement().toString());
			return footBuilder.toString();
		}
		public String getSignOperationalDataAnalysisNoDealReport(Map<String,Object> pMap) throws Exception{
			BaseMap param = (BaseMap)pMap.get("param");
			String serchRange = param.getString("serchRange");
			String queryColumn = DateUtil.getDateDimensionGroupBy(param.getString("dateType"), "A.CREATE_TIME", new String[]{param.getString("startTime"),param.getString("endTime")});
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append("SET DATEFIRST 1;")
			.append("SELECT ")
			.append(queryColumn)
			.append(" AS dateCount,")
			.append("sum(iif(A.CASE_TYPE =1,1,0)) as saleSignCount,")
			.append("sum(iif(A.CASE_TYPE =2,1,0)) as leaseSignCount")
			.append(" FROM HOUSE_INNERDEAL_ANALYSIS A")
			.append(" where A.COMP_ID = #{param.compId}");
			if("AREA".equals(serchRange)){
				sqlBuilder.append(" AND A.AREA_ID = #{param.serchRangeId} ");
			}else if("REG".equals(serchRange)){
				sqlBuilder.append(" AND A.REG_ID = #{param.serchRangeId} ");
			}else if("DEPT".equals(serchRange)){
				sqlBuilder.append(" AND A.DEPT_ID = #{param.serchRangeId} ");
			}else if("GROUP".equals(serchRange)){
				sqlBuilder.append(" AND A.GR_ID = #{param.serchRangeId} ");
			}else if("USER".equals(serchRange)){
				sqlBuilder.append(" AND A.ARCHIVE_ID = #{param.archiveId} ");
			}
			sqlBuilder.append(" AND A.DEAL_ID IS NULL");
			sqlBuilder.append(" AND A.CREATE_TIME >= #{param.startTime}");
			sqlBuilder.append(" AND A.CREATE_TIME <= #{param.endTime}");
			
			sqlBuilder.append(" group by ").append(queryColumn);
			return sqlBuilder.toString();
		}
		
		public String getSignOperationalDataAnalysisPie(Map<String,Object> pMap) throws Exception{
			BaseMap param = (BaseMap)pMap.get("param");
			String caseType = param.getString("caseType");
			String serchRange = param.getString("serchRange");
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append("SET DATEFIRST 1;")
			.append("SELECT ");
			if("101".equals(caseType)){
				sqlBuilder.append(" SUM(iif(B.SIGN_USER_ID>0,1,0)) as buySignCount");
			}else if ("102".equals(caseType)){
				sqlBuilder.append(" SUM(iif(B.SIGN_USER_ID>0,1,0)) as rentSignCount");
			}
			sqlBuilder.append(" FROM FUN_DEAL　B LEFT JOIN DEAL_USER_RELATIVE C ON B.DEAL_ID = C.DEAL_ID  AND B.DEAL_AUDIT_STATUS != 3 AND C.RELATE_TYPE =7")
			.append(" where B.COMP_ID = #{param.compId}");
			if("AREA".equals(serchRange)){
				sqlBuilder.append(" and C.AREA_ID = #{param.serchRangeId}");
			}else if("REG".equals(serchRange)){
				sqlBuilder.append(" and  C.REG_ID = #{param.serchRangeId}");
			}else if("DEPT".equals(serchRange)){
				sqlBuilder.append(" and  C.DEPT_ID = #{param.serchRangeId}");
			}else if("GROUP".equals(serchRange)){
				sqlBuilder.append(" and  C.GR_ID = #{param.serchRangeId}");
			}else if("USER".equals(serchRange)){
				sqlBuilder.append(" and  C.ARCHIVE_ID = #{param.archiveId}");
			}
			if ("101".equals(caseType)) {
				sqlBuilder.append(" AND B.DEAL_TYPE = 101 AND B.DEAL_CUSTOMER_ID>0 ");
			} else if ("102".equals(caseType)) {
				sqlBuilder.append(" AND B.DEAL_TYPE = 102 AND B.DEAL_CUSTOMER_ID>0 ");
			}
			sqlBuilder.append(" AND B.DEAL_ID>0");
			sqlBuilder.append(" AND B.SIGN_DATE >= #{param.startTime}");
			sqlBuilder.append(" AND B.SIGN_DATE <= #{param.endTime}");
			return sqlBuilder.toString();
		}
		
		public String getOperationalDataAnalysisHouseCjCount(Map<String,Object> pMap) throws Exception{
			BaseMap param = (BaseMap)pMap.get("param");
			String caseType = param.getString("caseType");
			String serchRange = param.getString("serchRange");
			String queryColumn = DateUtil.getDateDimensionGroupBy(param.getString("dateType"), "B.SIGN_DATE", new String[]{param.getString("startTime"),DateTimeHelper.formatDateTimetoString(param.getString("endTime"),DateTimeHelper.FMT_yyyyMMdd)});
			String columnName = "saleSignCount";
			if("102".equals(caseType)){
				columnName = "leaseSignCount";
			}
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append("SET DATEFIRST 1;")
			.append(" select C.dateCount,SUM(C.")
			.append(columnName)
			.append(") as ").append(columnName)
			.append(" from (")
			.append("SELECT ")
			.append(queryColumn)
			.append(" AS dateCount,");
			sqlBuilder.append("COUNT(distinct B.DEAL_ID) as ");
			sqlBuilder.append(columnName);
			sqlBuilder.append(" FROM FUN_DEAL　B LEFT JOIN DEAL_USER_RELATIVE C ON B.DEAL_ID = C.DEAL_ID AND B.SIGN_USER_ID = C.USER_ID  AND B.DEAL_AUDIT_STATUS != 3 AND C.RELATE_TYPE =3 ");
			sqlBuilder.append(" where B.COMP_ID = #{param.compId}");
			if("AREA".equals(serchRange)){
				sqlBuilder.append(" AND C.AREA_ID = #{param.serchRangeId} ");
			}else if("REG".equals(serchRange)){
				sqlBuilder.append(" AND C.REG_ID = #{param.serchRangeId}");
			}else if("DEPT".equals(serchRange)){
				sqlBuilder.append(" AND C.DEPT_ID = #{param.serchRangeId}");
			}else if("GROUP".equals(serchRange)){
				sqlBuilder.append(" AND C.GR_ID = #{param.serchRangeId}");
			}else if("USER".equals(serchRange)){
				sqlBuilder.append(" AND C.ARCHIVE_ID = #{param.archiveId}");
			}
			if ("101".equals(caseType)) {
				sqlBuilder.append("AND B.DEAL_TYPE = 101 ");
			} else if ("102".equals(caseType)) {
				sqlBuilder.append("AND B.DEAL_TYPE = 102 ");
			}
			sqlBuilder.append(" AND B.SIGN_DATE >= #{param.startTime}");
			sqlBuilder.append(" AND B.SIGN_DATE <= #{param.endTime}");
			sqlBuilder.append(" group by ").append(queryColumn);
			sqlBuilder.append(") C group by ").append("C.dateCount");
			return sqlBuilder.toString();
		}
		
		public String getOperationalDataAnalysisHouseCjNoDealCount(Map<String,Object> pMap) throws Exception{
			BaseMap param = (BaseMap)pMap.get("param");
			String caseType = param.getString("caseType");
			String serchRange = param.getString("serchRange");
			String queryColumn = DateUtil.getDateDimensionGroupBy(param.getString("dateType"), "A.CREATE_TIME", new String[]{param.getString("startTime"),DateTimeHelper.formatDateTimetoString(param.getString("endTime"),DateTimeHelper.FMT_yyyyMMdd)});
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append(" SELECT ")
			.append(queryColumn)
			.append(" AS dateCount,");
			if("101".equals(caseType)){
				sqlBuilder.append("sum(iif(A.CASE_TYPE =1 OR A.CASE_TYPE =3,1,0)) as saleSignCount");
			}else if("102".equals(caseType)){
				sqlBuilder.append("sum(iif(A.CASE_TYPE =2 OR A.CASE_TYPE =4,1,0)) as leaseSignCount");
			}
			sqlBuilder.append(" FROM HOUSE_INNERDEAL_ANALYSIS A ");
			sqlBuilder.append(" where A.COMP_ID = #{param.compId}");
			if("AREA".equals(serchRange)){
				sqlBuilder.append(" AND A.AREA_ID = #{param.serchRangeId} ");
			}else if("REG".equals(serchRange)){
				sqlBuilder.append(" AND A.REG_ID = #{param.serchRangeId} ");
			}else if("DEPT".equals(serchRange)){
				sqlBuilder.append(" AND A.DEPT_ID = #{param.serchRangeId} ");
			}else if("GROUP".equals(serchRange)){
				sqlBuilder.append(" AND A.GR_ID = #{param.serchRangeId} ");
			}else if("USER".equals(serchRange)){
				sqlBuilder.append(" AND A.ARCHIVE_ID = #{param.archiveId} ");
			}
			if ("101".equals(caseType)) {
				sqlBuilder.append(" AND A.CASE_TYPE IN(1,3)");
			} else if ("102".equals(caseType)) {
				sqlBuilder.append(" AND A.CASE_TYPE IN(2,4)");
			}
			sqlBuilder.append(" AND A.DEAL_ID IS NULL");
			sqlBuilder.append(" AND A.CREATE_TIME >= #{param.startTime}");
			sqlBuilder.append(" AND A.CREATE_TIME <= #{param.endTime}");
			sqlBuilder.append(" group by ").append(queryColumn);
			return sqlBuilder.toString();
		}
		
		public String getSignOperationalDataAnalysisHasDealReport(Map<String,Object> pMap) throws Exception{
			BaseMap param = (BaseMap)pMap.get("param");
			String serchRange = param.getString("serchRange");
			String caseType = param.getString("caseType");
			String queryColumn = DateUtil.getDateDimensionGroupBy(param.getString("dateType"), "B.SIGN_DATE", new String[]{param.getString("startTime"),param.getString("endTime")});
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append("SET DATEFIRST 1;")
			.append("SELECT ")
			.append(queryColumn)
			.append(" AS dateCount,")
			.append("sum(iif(B.SIGN_USER_ID>0 AND B.DEAL_TYPE = 101,1,0)) as saleSignCount,")
			.append("sum(iif(B.SIGN_USER_ID>0 AND B.DEAL_TYPE = 102,1,0)) as leaseSignCount")
			.append(" FROM FUN_DEAL B LEFT JOIN DEAL_USER_RELATIVE C ON B.DEAL_ID = C.DEAL_ID AND B.SIGN_USER_ID = C.USER_ID  AND B.DEAL_AUDIT_STATUS != 3 AND C.RELATE_TYPE =3 ")
			.append(" where B.COMP_ID = #{param.compId}");
			if("AREA".equals(serchRange)){
				sqlBuilder.append(" AND C.AREA_ID = #{param.serchRangeId} ");
			}else if("REG".equals(serchRange)){
				sqlBuilder.append(" AND C.REG_ID = #{param.serchRangeId}");
			}else if("DEPT".equals(serchRange)){
				sqlBuilder.append(" AND C.DEPT_ID = #{param.serchRangeId}");
			}else if("GROUP".equals(serchRange)){
				sqlBuilder.append(" AND C.GR_ID = #{param.serchRangeId}");
			}else if("USER".equals(serchRange)){
				sqlBuilder.append(" AND C.ARCHIVE_ID = #{param.archiveId}");
			}
			if("101".equals(caseType)){
				sqlBuilder.append(" AND B.DEAL_TYPE = 101");
			} else if ("102".equals(caseType)){
				sqlBuilder.append(" AND B.DEAL_TYPE = 102");
			}
			
			sqlBuilder.append(" AND B.SIGN_DATE >= #{param.startTime}");
			sqlBuilder.append(" AND B.SIGN_DATE <= #{param.endTime}");
			sqlBuilder.append(" group by ").append(queryColumn);
			return sqlBuilder.toString();
		}
		
		/**
		 * 财务应收，实收报表
		 * @param pMap
		 * @return
		 */
		public String getPfActualOffDealList(Map<String,Object> pMap){
			QueryDealPfActualParam param = (QueryDealPfActualParam)pMap.get("Param");
			String isExport = param.getIsExport();
			StringBuilder sqlBuilder = new StringBuilder(" select DISTINCT A.DEAL_ID,A.AGREEMENT_NO,A.CONTRACT_NO,A.SIGN_DATE,A.HOUSEADDRESS,A.DEAL_VERIFY_TIME,A.BUY_OWNER_NAME,A.SELL_OWNER_NAME,A.SIGN_USER_DEPT_NAME,A.SIGN_USER_DEPT_ID,A.SIGN_USER_NAME,A.DEAL_TYPE,A.SELL_DEAL_MONEY,A.RENT_DEAL_MONEY,A.SELL_ADDRESS,A.COMMERCIAL_LOAN_MONEY,A.PROVIDENT_LOAN_MONEY,A.PROCESS_END_TIME FROM FUN_DEAL A join PROCESS_FINANC B ON A.DEAL_ID=B.DEAL_ID ");
			String orderBy = "A.DEAL_ID";
			if (StringUtils.isNotBlank(param.getOrderBy())) {
				orderBy = param.getOrderBy();
			}
			// 1= 签约人 2=审核人
			if ("SIGN_USER_ID".equals(param.getUserType())) {
				sqlBuilder.append(" JOIN FUN_USERS C ON C.USER_ID=A.SIGN_USER_ID ");
			} else {
				sqlBuilder.append(" JOIN FUN_USERS C ON C.USER_ID=B.AUDIT_USER ");
			}
			Condition condition = new Condition();
			buildPfActualOffDealCondition(condition, param);
			sqlBuilder.append(" where ");
			sqlBuilder.append(condition.getConditionStatement());
			if ("1".equals(isExport)) {
				Integer pageNum = param.getPageOffset();
				Integer pageRows = param.getPageRows();
				sqlBuilder.append(" order by ");
				sqlBuilder.append(orderBy);
				sqlBuilder.append(" OFFSET " + ((pageNum - 1) * pageRows) + " ROW FETCH NEXT " + pageRows+ " ROWS ONLY");
			}
			return sqlBuilder.toString();
		}
		
		/**
		 * 财务应收，实收总量
		 * @param pMap
		 * @return
		 */
		public String getPfActualOffDealCount(Map<String,Object> pMap){
			QueryDealPfActualParam param = (QueryDealPfActualParam)pMap.get("param");
			StringBuilder sqlBuilder = new StringBuilder();
			Condition condition = new Condition();
			buildPfActualOffDealCondition(condition, param);
			StringBuilder tableNameBuilder = new StringBuilder(" FUN_DEAL A join PROCESS_FINANC B ON A.DEAL_ID=B.DEAL_ID AND A.COMP_ID = B.COMP_ID ");
			// 1= 签约人 2=审核人
			if ("SIGN_USER_ID".equals(param.getUserType())) {
				tableNameBuilder.append(" JOIN FUN_USERS C ON C.USER_ID=A.SIGN_USER_ID ");
			} else {
				tableNameBuilder.append(" JOIN FUN_USERS C ON C.USER_ID=B.AUDIT_USER ");
			}
			sqlBuilder.append(" SELECT COUNT(DISTINCT A.DEAL_ID) AS ATTR_NAME FROM " + tableNameBuilder.toString() + " WHERE ");
			sqlBuilder.append(condition.getConditionStatement());
			return sqlBuilder.toString();
		}
		
		/**
		 * 构建查询应收，实收条件
		 * @param condition
		 * @param param
		 * @return
		 */
		public static Condition buildPfActualOffDealCondition(Condition condition,QueryDealPfActualParam param){
			String intelligentSearch = param.getIntelligentSearch();
			String dateType = param.getDateType();
			Integer areaId = param.getAreaId();
			Integer regId = param.getRegId();
			Integer deptId = param.getDeptId();
			Integer userId = param.getUserId();
			Integer auditStatus = param.getAuditStatus();
			String pfActual = param.getPfActual();
			String pfPayer = param.getPfPayer();
			String pfTime = param.getPfTime();
			String startTime = param.getStartTime();
			String endTime = param.getEndTime();
			String performanceType = param.getPerformanceType();
			Integer processStatus = param.getProcessStatus();
			String paymentId = param.getPaymentId();
			Object[] paymentIds = param.getPaymentIds();
			condition.add(new ConditionItem("A.COMP_ID", "=", "#{param.compId}",true));
			if (userId!=null) {
				condition.add(new ConditionItem("C.USER_ID", "=", "#{param.userId}",true));
			}
			if (areaId!=null) {
				condition.add(new ConditionItem("C.AREA_ID", "=", "#{param.areaId}",true));
			}
			if (regId!=null) {
				condition.add(new ConditionItem("C.REG_ID", "=", "#{param.regId}",true));
			}
			if (deptId!=null) {
				condition.add(new ConditionItem("C.DEPT_ID", "=", "#{param.deptId}",true));
			}
			// 此处用于检索后的数据模糊匹配 实现数据的模糊查询
			if (StringUtils.isNotBlank(intelligentSearch)) {// 模糊检索
				condition.add(new ConditionItem("A.INTELLIGENT_SEARCH", "LIKE", "%" + intelligentSearch + "%"));
			}
			
			if (auditStatus!=null) {
				condition.add(new ConditionItem("B.AUDIT_STATUS", "=", "#{param.auditStatus}",true));
			}
			
			if (StringUtils.isNotBlank(pfActual)) {
				condition.add(new ConditionItem("B.PF_ACTUAL", "=", "#{param.pfActual}",true));
			}
			
			if (StringUtils.isNotBlank(performanceType)) {
				condition.add(new ConditionItem("B.PERFORMANCE_TYPE", "=", "#{param.performanceType}",true));
			}
			
			if (StringUtils.isNotBlank(pfPayer)) {
				condition.add(new ConditionItem("B.PF_PAYER", "=", "#{param.pfPayer}",true));
			}
			
			if (StringUtils.isNotBlank(paymentId)) {
				condition.add(new ConditionItem("B.PAYMENT_ID", "=", "#{param.paymentId}",true));
			} else if (paymentIds!=null && paymentIds.length>0) {
				condition.add(new ConditionItem("B.PAYMENT_ID", "IN", paymentIds));
			}
			
			if (processStatus!=null) {
				if ("3".equals(processStatus)) {
					condition.add(new ConditionItem("A.PROCESS_STATUS", "!=", Constants_DIC.DIC_DEAL_STATUS_TRANSACT));
				} else {
					condition.add(new ConditionItem("A.PROCESS_STATUS", "=", processStatus));
				}
			}
			
			if (StringUtils.isNotBlank(pfTime)) {
				condition.add(new ConditionItem("B.PF_TIME", ">=", DateTimeHelper.formatDateTimetoString(startTime, "yyyy-MM-dd 00:00:00")));
				condition.add(new ConditionItem("B.PF_TIME", "<=", DateTimeHelper.formatDateTimetoString(endTime, "yyyy-MM-dd 23:59:59")));
			}
			
			if (StringUtils.isNotBlank(dateType)) {
				if ("AUDIT_DATE".equals(dateType)) {
					dateType = "B.AUDIT_TIME";
				} else {
					dateType = "A." + dateType;
				}
				if (StringUtils.isNotBlank(startTime)) {
					condition.add(new ConditionItem(dateType, ">=", DateTimeHelper.formatDateTimetoString(startTime, "yyyy-MM-dd 00:00:00")));
				}
				if (StringUtils.isNotBlank(endTime)) {
					condition.add(new ConditionItem(dateType, "<=", DateTimeHelper.formatDateTimetoString(endTime, "yyyy-MM-dd 23:59:59")));
				}
			}
			condition.add(new ConditionItem("A.ISBYHAND", "=", "0"));
			return condition;
			
		}
	}
	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunDealDto getFunDealDto(ErpFunDeal erpFunDeal);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunDealDtoTemp> getDealListNotHaveBullet(@Param("shardCityId")Short cityId);

	List<ErpFunDeal> getPfActualOffDealList(@Param("shardCityId")Integer cityId, @Param("param")QueryDealPfActualParam param);

	int getPfActualOffDealCount(@Param("shardCityId")Integer cityId, @Param("param")QueryDealPfActualParam param);

	List<Map<String, String>> getPercentProfitList(@Param("shardCityId")Integer cityId, @Param("param")ProfitPercentParam param);
	
	/**
	 * 掌通业绩龙虎榜查询
	 * @author 朱科
	 * @since 2018年9月3日
	 * @return
	 */
	List<Map<String, Object>> getAppAchieveMonthStatisticsRank(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("deptId")Integer deptId, @Param("lookType")Integer lookType, @Param("rangeType")Integer rangeType, @Param("rangeIds")Set<Integer> rangeIds, @Param("startTime")String startTime, @Param("endTime")String endTime, @Param("selfDeptId")Integer selfDeptId, @Param("profitShowType")Integer profitShowType, @Param("isFjdFlag") boolean isFjdFlag);

	List<Map<String, Object>> getAppAchieveMonthStatisticsRankForOrg(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,  @Param("startTime")String startTime, @Param("endTime")String endTime, @Param("profitShowType")Integer profitShowType,@Param("groupByColumn")String groupByColumn,
																	 @Param("whereCause") String whereCause);

	Integer getProntDealRecordId(@Param("shardCityId")Integer cityId,@Param("dealId")Integer dealId, @Param("updateType")String updateType, @Param("pfActual")String pfActual);
	
	
	List<Integer> getDistinctDealIds(@Param("shardCityId")Integer cityId,@Param("param") DealContractParam param);
	
	
	List<ErpFunDeal> getFunDealByDealIds(@Param("shardCityId")Integer cityId,@Param("dealIds")List<Integer> dealIds);

	void updateStepInDeal(@Param("shardCityId")Integer cityId, @Param("record") ErpFunDeal record);

	void updateProcessEndTime(ErpFunDeal funDeal);
	
	void updateSignType(@Param("shardCityId")Integer cityId, @Param("dealId") Integer dealId);

	void updateDealIntroducer(@Param("shardCityId")Integer cityId, @Param("dealId") Integer dealId, @Param("introducerId")Integer introducerId, @Param("adultPromotionId")Integer adultPromotionId,@Param("signSiteDept")Integer signSiteDept,@Param("signSiteGr")Integer signSiteGr);
	
	void insertCooperateDealRelative(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("dealId")Integer dealId,
									 @Param("cooperateId")Integer cooperateId);
}


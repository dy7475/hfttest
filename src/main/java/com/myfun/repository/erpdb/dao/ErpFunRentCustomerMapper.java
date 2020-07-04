package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.myfun.erpWeb.managecenter.transaction.vo.CustInfoVO;
import com.myfun.repository.erpdb.dto.ErpFunRentCustomerDto;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.mybatis.query.Columns;
import com.myfun.repository.support.mybatis.query.Condition;
import com.myfun.repository.support.mybatis.query.ConditionItem;
import com.myfun.repository.support.mybatis.query.SQLBuilderSupport;
import com.myfun.repository.erpdb.po.ErpFunRentCustomer;
import com.myfun.repository.erpdb.po.ErpFunRentCustomerExample;
@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpFunRentCustomerMapper extends BaseMapper<ErpFunRentCustomer, ErpFunRentCustomerKey> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunRentCustomerExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunRentCustomerExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunRentCustomer> selectByExampleWithBLOBs(ErpFunRentCustomerExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunRentCustomer> selectByExample(ErpFunRentCustomerExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunRentCustomer record,
			@Param("example") ErpFunRentCustomerExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleWithBLOBs(@Param("record") ErpFunRentCustomer record,
			@Param("example") ErpFunRentCustomerExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunRentCustomer record,
			@Param("example") ErpFunRentCustomerExample example);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(ErpFunRentCustomer record);

	int updateByUserId(@Param("shardCityId")Integer shardCityId, @Param("map")Map<String, Object> map);

	/**
	 * @author 方李骥
	 * @since 2016年8月30日
	 * @param caseId
	 * @param shardCityId
	 */
	ErpFunRentCustomer getFunRentCustomer(@Param("shardCityId")Integer shardCityId,@Param("erpFunRentCustomerKey")ErpFunRentCustomerKey erpFunRentCustomerKey);

	Integer countShareHouse(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateOthersbyUserPauseToNormal(@Param("shardCityId")Integer cityId, @Param("pMap") Map<String, Object> pMap);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateHouseForReg(@Param("shardCityId")Integer cityId, @Param("pMap")Map<String, Object> pMap);
	

	/**
	 * 通过出售信息匹配求购信息，用于新增房源推送
	 * @author 张宏利
	 * @since 2017年2月25日
	 * @param cityId 城市ID，用于分库
	 * @param compId 公司ID
	 * @param operRange 权限范围
	 * @param operRangeId 权限范围ID
	 * @param erpFunlease 出售信息，用于匹配
	 * @return
	 */
	List<ErpFunRentCustomer> getMatchHouseCustList(
			@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, 
			@Param("operRange")String operRange, @Param("operRangeId")int operRangeId, 
			@Param("lease")ErpFunLease erpFunlease);

	/**
	 * 通过ID查询指定列
	 * @author 张宏利
	 * @since 2017年2月25日
	 * @param cityId 城市ID，用于分库
	 * @param rentCustId 求购客源ID
	 * @param compId 公司ID，保证是这个公司的数据
	 * @param columns 查询的指定列
	 * @return
	 */
	ErpFunRentCustomer selectColumnById(@Param("shardCityId")Integer cityId, @Param("rentCustId")Integer rentCustId, @Param("compId")Integer compId, @Param("columns") String[] columns);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	@SelectProvider(type=FunRentCustomerSqlProvider.class,method="selectFunRentCustomerListByIds")
	@ResultType(Map.class)
	List<Map<String,Object>> selectFunRentCustomerListByIds(@Param("shardCityId")Integer cityId,@Param("queryIds") Integer[] queryIds,@Param("queryColumn") String[] queryColumn,@Param("compId") Integer compId);

	Integer countByUserId(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId,@Param("userId") Integer userId);

	List<ErpFunRentCustomerDto> getSpecialListCount(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("deptId") Integer deptId, @Param("userId") Integer userId);

	List<ErpFunRentCustomer> getFunRentCustomerByCompNo(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId);


	class FunRentCustomerSqlProvider {
		public String selectFunRentCustomerListByIds(Map<String, Object> paramMap) throws Exception{
			Integer[] rentCustIds = (Integer[]) paramMap.get("queryIds");
			String[] saleColumns = (String[]) paramMap.get("queryColumn");
			Condition condition = new Condition();
			condition.add(new ConditionItem("COMP_ID","=","#{compId}")); 
			condition.add(new ConditionItem("RENT_CUST_ID","IN",rentCustIds)); 
			Columns columns = new Columns(saleColumns);
			return SQLBuilderSupport.selectByCondition( "FUN_RENT_CUSTOMER",false, columns, condition, null, null).toString();
		}
		
		public String excuteSqlList(Map<String, Object> paramMap) throws Exception{
			return paramMap.get("querySql").toString();
		}
		
		public String excuteSqlCount(Map<String, Object> paramMap) throws Exception{
			String querySql = paramMap.get("querySql").toString();
			String lowerSql = querySql.toLowerCase();
			querySql = querySql.substring(0, lowerSql.lastIndexOf(" order by "));
			querySql = "SELECT COUNT(1) AS COUNTS " + querySql.substring(lowerSql.indexOf(" from "));
			return querySql;
		}
	}
	
	/**
	 * 执行SQL，返回List<Map>
	 * @since 2017年6月9日
	 * @param cityId
	 * @param querySql
	 * @return
	 */
	@ResultType(Map.class)
	@SwitchDB(type = SwitchDBType.CITY_ID)
	@SelectProvider(type = FunRentCustomerSqlProvider.class, method = "excuteSqlList")
	List<Map<String, String>> excuteSqlList(@Param("shardCityId") Integer cityId, @Param("querySql") String querySql);

	/**
	 * 执行SQL，返回Long
	 * @since 2017年6月9日
	 * @param cityId
	 * @param querySql
	 * @return
	 */
	@ResultType(Map.class)
	@SwitchDB(type = SwitchDBType.CITY_ID)
	@SelectProvider(type = FunRentCustomerSqlProvider.class, method = "excuteSqlCount")
	Long excuteSqlCount(@Param("shardCityId") Integer cityId, @Param("querySql") String querySql);

	/**
	 * 当月新增数据中的求租客源数据
	 * @author 臧铁
	 * @since 2017年7月15日
	 * @param cityId
	 * @param areaId
	 * @param regId
	 * @param deptId
	 * @param userId
	 * @param compId
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	List<Map<String, Object>> getFlowAnalysisCountList(@Param("shardCityId")Integer cityId,@Param("areaId")Integer areaId, 
			@Param("regId")Integer regId, @Param("deptId")Integer deptId,@Param("userId")Integer userId, 
			@Param("compId")Integer compId,@Param("startTime")String startTime,@Param("endTime") String endTime);

	/**
	 * 数据分析首页-房客源数据-各求租客源状态统计
	 * @author 臧铁
	 * @since 2017年7月20日
	 * @param cityId
	 * @param compId
	 * @param weekTime 本周星期一
	 * @param monthTime 本月一号
	 * @return
	 */
	Map<String, Object> getHouseCustStatusData(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("weekTime") String weekTime, @Param("monthTime")String monthTime);
	
	/**
	 * 获取有效求租客源总量
	 * @author 臧铁
	 * @since 2017年7月20日
	 * @param cityId
	 * @param compId
	 * @return
	 */
	Integer countAvailableHouse(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId);

	/**
	 * 数据分析首页-租赁房价购买力分析客源人数
	 * @author 臧铁
	 * @since 2017年7月24日
	 * @param cityId
	 * @param compId
	 * @param caseWhenSql  经过处理的条件   见DataAnalysisUtil.getCaseWhenSql
	 * @return
	 */
	List<Map<String, Object>> getHouseBuyingPowerData(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("caseWhenSql")String caseWhenSql);

	/**
	 * 获取房客源存量数据统计
	 * @author 张宏利
	 * @since 2017年7月26日
	 * @param cityId
	 * @param map
	 */
	List<Map<String,Object>> getStoreDataAnalysis(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);

	/**
	 * 获取房客源存量数据量
	 * @author 张宏利
	 * @since 2017年7月26日
	 * @param cityId
	 * @param map
	 */
	Integer getStoreDataCount(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);

	/**
	 * 获取带看或房勘情况
	 * @author 张宏利
	 * @since 2017年7月26日
	 * @param cityId
	 * @param param
	 * @return
	 */
	Map<String, Object> getStoreDataDaiKan(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);

	/**
	 * 通过用途对相关维度分析统计
	 * @author 张宏利
	 * @since 2017年7月26日
	 * @param cityId
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> getStoreDataAnalysisByUseage(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
	
	ErpFunRentCustomer getRentCustomerByCustId(@Param("shardCityId")Integer cityId, @Param("rentCustId")Integer rentCustId);

	/**
	 * 获取加密和推荐条数
	 * @author 张宏利
	 * @since 2017年10月23日
	 * @param cityId
	 * @param infoOwnerUserId
	 * @param compId
	 * @param deptId
	 * @return
	 */
	Map<String, Integer> getLevelCounts(@Param("shardCityId")Integer cityId,@Param("caseId")Integer caseId,@Param("infoOwnerUserId")Integer infoOwnerUserId,@Param("compId")Integer compId,@Param("deptId")Integer deptId);
	
	ErpFunRentCustomer getRentCustomerInfoByCustId(@Param("shardDbName")String shardDbName, @Param("rentCustId")Integer rentCustId);

	/**
	 * 获取电话重复列表
	 * @author 张宏利
	 * @since 2017年10月24日
	 * @return
	 */
	List<Map<String, Object>> getPhoneRepeatList(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("userId") Integer userId, @Param("phoneArr")String[] phoneArr);

	/**
	 * 获取身份证重复条数
	 * @author 张宏利
	 * @since 2017年10月24日
	 * @param cityId 城市ID
	 * @param compId 公司ID
	 * @param selfUserId 自己的用户ID，不为空时只查询自己的客源
	 * @param custId 不为空时则有不等于这个ID的条件
	 * @param idCard 查询的身份证号
	 * @return
	 */
	int getIdCardRepeat(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("userId")Integer userId, 
			@Param("custId")Integer custId, @Param("idCard")String idCard, @Param("idCardType")Integer idCardType);
	
	/**
	 * 修改指定的列
	 * @author 张宏利
	 * @since 2017年10月23日
	 * @param cityId 城市ID
	 * @param param 需要修改的map
	 * @param caseId saleId
	 */
	public Integer updateModelData(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param,
			@Param("caseId")Integer caseId, @Param("plateType")Integer plateType);

	/**
	 * 获取用户的求租客源数量
	 * @author 张宏利
	 * @since 2018年1月30日
	 * @param cityId
	 * @param userId
	 * @return
	 */
	Integer getRentCustCount(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("userId") Integer userId);
	
	/**
	 * 提醒关注数量待跟客
	 *@author 朱科
	 *@param 
	 *@return Integer
	 *@since 2018年2月5日
	 */
	Integer getRentCustCountByFlag(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("rangeType") Integer rangeType,
								   @Param("rangeIds") Set<Integer> rangeIds, @Param("partnerId") Integer partnerId,
								   @Param("newOrganizationType") boolean newOrganizationType);

	/**
	 * 管理范围内新增客源
	 *@author 朱科
	 *@param 
	 *@return Integer
	 *@since 2018年2月6日
	 */
	@AccessReadonlyDb
	Integer getRentAddCount(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("manageLevel") Byte manageLevel,
                            @Param("manageRangIds") Set<Integer> manageRangIds, @Param("startTime")String startTime, @Param("partnerId") Integer partnerId);

	/**
	 * @tag 获取一千条求租数据
	 * @author 邓永洪
	 * @since 2018/4/27
	 */
	List<ErpFunRentCustomer> getTopFunRentCustomer(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId, @Param("deptId")Integer srcDeptId,
													   @Param("userId")String srcUserId, @Param("plateType")Integer plateType,@Param("num")Integer num);

	/**
	 * @tag 统计移交数据
	 * @author 邓永洪
	 * @since 2018/4/27
	 */
	int countFunRentCustomer(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId, @Param("deptId")Integer srcDeptId,
							 @Param("userId") String srcUserId,@Param("plateType")Integer plateType, @Param("caseIds")List<Integer> caseIds);

	/**
	 * @tag 判断指定员工的所有信息中是否存在已成交或注销信息
	 * @author 邓永洪
	 * @since 2018/5/3
	 */
	ErpFunRentCustomer detectTransDataByDeptIdAndUserId(@Param("shardCityId")Integer cityId,@Param("deptId") Integer srcDeptId,
											 @Param("userId")  String srcUserId,@Param("plateType")Integer plateType);

	/**
	 * @tag 数据中是否存在已经成交或注销的信息
	 * @author 邓永洪
	 * @since 2018/5/3
	 */
	ErpFunRentCustomer detectTransData(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("caseIds")String[] caseIds);

	/**
	 * 移动端和ERP端共用匹配查询
	 * 注意在业务层两端匹配有差异，主要是区分 ：个人数据的逻辑（ERP没有、移动端有）
	 * @author 陈文超
	 * @date 2019年11月22日 上午11:56:44
	 * 
	 * 陈文超移植该方法到houseCustWeb并停用-2019-11-22
	 */
	@Deprecated
	List<ErpFunRentCustomer> getMatchRentCustomerList(@Param("shardCityId") Integer cityId, @Param("param") Map<String, Object> map);

	/**
	 * 通过条件查询Top1的对象信息
	 * @author ZangTie
	 * @since 2018年7月24日 下午6:13:51
	 * @param erpFunRentCustomerExample
	 * @return
	 * Modified XXX ZangTie 2018年7月24日
	 */
	ErpFunRentCustomer selectOneByExample(ErpFunRentCustomerExample erpFunRentCustomerExample);
	
	/**
	 * 通过公司ID和caseIds集合获取出售房源列表
	 * @author ZangTie
	 * @since 2018年7月27日 下午8:54:16
	 * @param shardCityId=切库城市ID
	 * @param compId=公司ID
	 * @param caseIds=caseId集合
	 * Modified XXX ZangTie 2018年7月27日
	 * @return 
	 */
	List<ErpFunRentCustomer> getFunRentCustListByCompIdAndCaseIds(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("caseIds")Set<Integer> caseIds);
	
	/**
	 * 通过客源列表权限查看房源
	 * @author 朱科
	 * @since 2018年10月22日
	 * @return
	 */
	List<ErpFunRentCustomer> getAppAchieveMonthStatisticsRankDetailCustomerAdd(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("caseIds")Set<Integer> caseIds, @Param("trueViewRang")Integer trueViewRang, @Param("trueViewRangId")Integer trueViewRangId, @Param("deptId") Integer deptId);

	/**
	 * 通过客源列表权限查看房源
	 * @author 朱科
	 * @since 2018年10月22日
	 * @return
	 */
	List<ErpFunRentCustomer> getAppAchieveMonthStatisticsRankDetailCustomerForOrg(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("caseIds")Set<Integer> caseIds, @Param("orgLikeWhereCause")String orgLikeWhereCause);


	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunRentCustomer getFunRentCustByRentId(@Param("shardCityId") Integer shardCityId, @Param("rentCustId") Integer rentCustId);

	/**
	 * 通过客源列表查看客源
	 *
	 * @author czq
	 * @since 2019年6月1日
	 */
	List<ErpFunRentCustomer> getCustomersByCaseIds(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("caseIds") String[] caseIds);

	List<CustInfoVO> selectCustInfoListByIds(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("caseIds")List<Integer> custIds);

	void transDataForDeleteUser(@Param("shardCityId") Integer cityId, @Param("paramMap")Map<String,Object> paramMap);
	
	void transRentData(@Param("shardCityId") Integer cityId, @Param("paramMap")Map<String,Object> paramMap);

}


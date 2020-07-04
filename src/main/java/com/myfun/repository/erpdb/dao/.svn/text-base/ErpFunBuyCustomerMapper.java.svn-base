package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.myfun.erpWeb.managecenter.transaction.vo.CustInfoVO;
import com.myfun.repository.erpdb.dto.ErpFunBuyCustomerDto;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import com.myfun.repository.erpdb.po.ErpFunBuyCustomer;
import com.myfun.repository.erpdb.po.ErpFunBuyCustomerExample;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.mybatis.query.Columns;
import com.myfun.repository.support.mybatis.query.Condition;
import com.myfun.repository.support.mybatis.query.ConditionItem;
import com.myfun.repository.support.mybatis.query.SQLBuilderSupport;

public interface ErpFunBuyCustomerMapper extends BaseMapper<ErpFunBuyCustomer, ErpFunBuyCustomer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunBuyCustomerExample example);
	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunBuyCustomerExample example);
	/**
	 * @mbggenerated
	 */
	List<ErpFunBuyCustomer> selectByExampleWithBLOBs(ErpFunBuyCustomerExample example);
	/**
	 * @mbggenerated
	 */
	List<ErpFunBuyCustomer> selectByExample(ErpFunBuyCustomerExample example);
	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunBuyCustomer record,
			@Param("example") ErpFunBuyCustomerExample example);
	/**
	 * @mbggenerated
	 */
	int updateByExampleWithBLOBs(@Param("record") ErpFunBuyCustomer record,
			@Param("example") ErpFunBuyCustomerExample example);
	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunBuyCustomer record, @Param("example") ErpFunBuyCustomerExample example);
	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(ErpFunBuyCustomer record);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	int updateByUserId(@Param("shardCityId")Integer shardCityId,  @Param("map")Map<String, Object> map);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunBuyCustomer getFunBuyCustomer(@Param("shardCityId")Integer shardCityId, @Param("buyCustId")Integer buyCustId);	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	Integer countShareHouse(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId);

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
	 * @param erpFunSale 出售信息，用于匹配
	 * @return
	 */
	List<ErpFunBuyCustomer> getMatchHouseCustList(
			@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, 
			@Param("operRange")String operRange, @Param("operRangeId")int operRangeId, 
			@Param("sale")ErpFunSale erpFunSale);
	
	/**
	 * 通过ID查询指定列
	 * @author 张宏利
	 * @since 2017年2月25日
	 * @param cityId 城市ID，用于分库
	 * @param buyCustId 求购客源ID
	 * @param compId 公司ID，保证是这个公司的数据
	 * @param columns 查询的指定列
	 * @return
	 */
	ErpFunBuyCustomer selectColumnById(@Param("shardCityId")Integer cityId, @Param("buyCustId")Integer buyCustId, @Param("compId")Integer compId, @Param("columns") String[] columns);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	@SelectProvider(type=FunBuyCustomerSqlProvider.class,method="selectFunBuyCustomerListByIds")
	@ResultType(Map.class)
	List<Map<String,Object>> selectFunBuyCustomerListByIds(@Param("shardCityId")Integer cityId,@Param("queryIds") Integer[] queryIds,@Param("queryColumn") String[] queryColumn,@Param("compId") Integer compId);

	/**
	 * 通过指定条件查询列表
	 * @author 臧铁
	 * @param map  caseId 房客源ID  date 时间范围 deptId 门店ID matchType   SOURCE_DEPT_ID
	 * @param map  bound 匹配范围 0 全公司【本公司】 范围 1 共享圈 范围 3 好友圈 范围 CITY_SHARE 匹配城市公盘，排除本公司范围
	 * @param map  plateType 盘别 1抢盘2私盘3公盘  orderBy 排序方式
	 * @since 2017年5月24日
	 * @return
	 * 
	 * 陈文超移植该方法到houseCustWeb并停用-2019-11-22
	 */
	@Deprecated
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunBuyCustomer> getMatchBuyCustomerList(@Param("shardCityId") Integer cityId, @Param("param") Map<String, Object> map) throws Exception;

	Integer countByUserId(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId,@Param("userId") Integer userId);

	List<ErpFunBuyCustomerDto> getSpecialListCount(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("deptId") Integer deptId, @Param("userId") Integer userId);


	class FunBuyCustomerSqlProvider{
		public String selectFunBuyCustomerListByIds(Map<String, Object> paramMap) throws Exception{
			Integer[] buyCustIds = (Integer[]) paramMap.get("queryIds");
			String[] buyCustColumns = (String[]) paramMap.get("queryColumn");
			Condition condition = new Condition();
			condition.add(new ConditionItem("COMP_ID","=","#{compId}")); 
			condition.add(new ConditionItem("BUY_CUST_ID","IN",buyCustIds)); 
			Columns columns = new Columns(buyCustColumns);
			
			return SQLBuilderSupport.selectByCondition( "FUN_BUY_CUSTOMER",false, columns, condition, null, null).toString();
		}
	}

	/**
	 * 当月新增数据中的求购客源数据
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
	 * 数据分析首页-房客源数据-各求购客源状态统计
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
	 * 获取有效求购客源总量
	 * @author 臧铁
	 * @since 2017年7月20日
	 * @param cityId
	 * @param compId
	 * @return
	 */
	Integer countAvailableHouse(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId);
	
	/**
	 * 数据分析首页-买卖房价购买力分析客源人数
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
	List<Map<String, Object>> getStoreDataAnalysis(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);

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
	 * 获取用户的求购客源数量
	 * @author 张宏利
	 * @since 2018年1月30日
	 * @param cityId
	 * @param userId
	 * @return
	 */
	Integer getBuyCustCount(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("userId") Integer userId);
	
	/**
	 * 提醒关注数量待跟客
	 *@author 朱科
	 *@param 
	 *@return Integer
	 *@since 2018年2月5日
	 */
	Integer getBuyCustCountByFlag(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("rangeType") Integer rangeType,
								  @Param("rangeIds") Set<Integer> rangeIds, @Param("partnerId") Integer partnerId,
								  @Param("newOrganizationType") boolean newOrganizationType);
	
	/**
	 * 管理范围内新增客源源
	 *@author 朱科
	 *@param 
	 *@return Integer
	 *@since 2018年2月6日
	 */
	@AccessReadonlyDb
	Integer getBuyAddCount(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("manageLevel") Byte manageLevel,
                           @Param("manageRangIds") Set<Integer> manageRangIds, @Param("startTime")String startTime, @Param("partnerId") Integer partnerId);

	/**
	* @author 邓永洪
	* @since 2018/4/23
	* @tag 判断指定员工的所有信息中是否存在已成交或注销信息
	*/
	ErpFunBuyCustomer detectTransDataByDeptIdAndUserId(@Param("shardCityId")Integer cityId,@Param("deptId") Integer srcDeptId,
													   @Param("userId")  String srcUserId,@Param("plateType")Integer plateType);

	ErpFunBuyCustomer detectTransData(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("caseIds")String[] caseIds);

	/**
	* @author 邓永洪
	* @since 2018/4/24
	* @tag 获取1000条数据移交数据
	*/
	List<ErpFunBuyCustomer> getTopFunBuyCustomer(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId, @Param("deptId")Integer srcDeptId,
												 @Param("userId")String srcUserId, @Param("plateType")Integer plateType,@Param("num")Integer num);

	/**
	* @author 邓永洪
	* @since 2018/4/24
	* @tag 统计移交数据
	*/
	int countFunBuyCustomer(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId, @Param("deptId")Integer srcDeptId,
							@Param("userId") String srcUserId,@Param("plateType")Integer plateType, @Param("caseIds")List<Integer> caseIds);
	
	/**
	 * 通过条件查询Top1的对象信息
	 * @author ZangTie
	 * @since 2018年7月24日 下午6:10:52
	 * @param erpFunBuyCustomerExample
	 * @return
	 * Modified XXX ZangTie 2018年7月24日
	 */
	ErpFunBuyCustomer selectOneByExample(ErpFunBuyCustomerExample erpFunBuyCustomerExample);

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
	List<ErpFunBuyCustomer> getFunBuyCustListByCompIdAndCaseIds(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("caseIds")Set<Integer> caseIds);
	
	/**
	 * 通过客源列表权限查看房源
	 * @author 朱科
	 * @since 2018年10月22日
	 * @return
	 */
	List<ErpFunBuyCustomer> getAppAchieveMonthStatisticsRankDetailCustomerAdd(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("caseIds")Set<Integer> caseIds, @Param("trueViewRang")Integer trueViewRang, @Param("trueViewRangId")Integer trueViewRangId, @Param("deptId") Integer deptId);
	/**
	 * 通过客源列表权限查看房源
	 * @author 朱科
	 * @since 2018年10月22日
	 * @return
	 */
	List<ErpFunBuyCustomer> getAppAchieveMonthStatisticsRankDetailCustomerAddForOrg(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("caseIds")Set<Integer> caseIds, @Param("orgLikeWhereCause") String orgLikeWhereCause);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunBuyCustomer getFunBuyCustByCustId(@Param("shardCityId") Integer shardCityId, @Param("buyCustId") Integer buyCustId);

	/**
	 * 通过客源列表查看客源
	 *
	 * @author czq
	 * @since 2019年6月1日
	 */
	List<ErpFunBuyCustomer> getCustomersByCaseIds(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("caseIds") String[] caseIds);
	
	
	List<CustInfoVO> selectCustInfoListByIds(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("caseIds")List<Integer> custIds);

	void transDataForDeleteUser(@Param("shardCityId") Integer cityId, @Param("paramMap")Map<String,Object> paramMap);
	
	//新增的移交客源方法
	void transBuyData(@Param("shardCityId") Integer cityId, @Param("paramMap")Map<String,Object> paramMap);

}
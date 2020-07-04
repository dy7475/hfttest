package com.myfun.repository.erpdb.dao;

import java.math.BigDecimal;
import java.util.*;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import com.github.pagehelper.Page;
import com.myfun.erpWeb.house.vo.FunSaleDto;
import com.myfun.erpWeb.managecenter.transaction.vo.HouseInfoVO;
import com.myfun.repository.erpdb.dto.ErpBulletHouseDto;
import com.myfun.repository.erpdb.dto.ErpFunSaleDto;
import com.myfun.repository.erpdb.dto.HouseCustAddCountDto;
import com.myfun.repository.erpdb.dto.houseAuditDto;
import com.myfun.repository.erpdb.param.ErpBuildingSetFloorParam;
import com.myfun.repository.erpdb.param.ErpFunSaleParam;
import com.myfun.repository.erpdb.param.QueryHouseCustListParam;
import com.myfun.repository.erpdb.param.ReqBulletinHouseListParam;
import com.myfun.repository.erpdb.param.houseAuditParam;
import com.myfun.repository.erpdb.po.ErpFunBuyCustomer;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.repository.erpdb.po.ErpFunSaleExample;
import com.myfun.repository.searchdb.dto.SearchSosoViewDto;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.generator.ColumnVo;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.mybatis.condition.BaseQuery;
import com.myfun.repository.support.mybatis.query.Columns;
import com.myfun.repository.support.mybatis.query.Condition;
import com.myfun.repository.support.mybatis.query.ConditionItem;
import com.myfun.repository.support.mybatis.query.SQLBuilderSupport;
import com.myfun.repository.support.param.DaoBaseParam;

@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpFunSaleMapper extends BaseMapper<ErpFunSale, ErpFunSale> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunSaleExample example);

	/**
	 * @mbggenerated
	 */                                                                     
	int deleteByExample(ErpFunSaleExample example);

	/**                                                     
	 * @mbggenerated
	 */List<ErpFunSale> selectByExampleWithBLOBs(ErpFunSaleExample example);

	/**
	 * @mbggenerated
	 */List<ErpFunSale> selectByExample(ErpFunSaleExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpFunSale record,@Param("example") ErpFunSaleExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleWithBLOBs(@Param("record") ErpFunSale record,@Param("example") ErpFunSaleExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpFunSale record,@Param("example") ErpFunSaleExample example);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(ErpFunSale record);

	List<ErpFunSale> getFunSaleListForPage(DaoBaseParam param);

	@AccessReadonlyDb
	List<ErpFunSale> getFunSaleListBySolrParamForPage(DaoBaseParam param);

	/**
	 * 查询房源审核列表
	 * 
	 * @param pageNum
	 * @param param
	 * @return
	 */
	public Page<houseAuditDto> getHouseAuditSaleList(@Param("shardCityId") String shardCityId, @Param("house") houseAuditParam param);

	public List<ColumnVo> getColumnInfoByTbName(@Param("shardCityId") Integer shardCityId, @Param("tbName") String tbName);

	/**
	 * 房源信息
	 **/
	public List<ErpFunSale> getFunSaleByCondition(ErpFunSale s);

	public List<ErpFunSale> getFunSaleByCondition4YouYou(ErpFunSale s);

	int updateByUserId(ErpFunSaleParam erpFunSale);

	ErpFunSale getFunSaleBySaleId(@Param("shardCityId") Integer cityId, @Param("saleId") Integer saleId);

	ErpFunSale getSaleLeaseInfo(@Param("shardCityId") Integer cityId, @Param("saleId") Integer saleId);

	/**
	 * 根据archiveId和userId修改数据
	 * 
	 * @param erpFunSale
	 */
	void updateByArchiveIdAndUserId(ErpFunSaleParam erpFunSale);

	/**
	 * 只能修改电话方法斯蒂芬地方
	 * 
	 * @param erpFunSale
	 */
	void updateCellPhoneByPrimaryKey(ErpFunSale erpFunSale);

	/**
	 * 查询优优详情数据为空时返回两条有效的列表信息
	 * 
	 * @author 陈文超
	 * @date 2016年6月3日 下午2:50:12
	 */
	List<ErpFunSale> getFunSaleList4YouYou(@Param("shardCityId") Integer shardCityId);
	
	// 下架真房源
	void updateTrueFlag(@Param("shardCityId")Integer cityId, @Param("saleIds")Integer[] saleIds, @Param("trueFlag")Byte trueFlag);
	
	List<ErpFunSale> getFunSaleList(@Param("shardCityId")Integer cityId, @Param("saleIds")String saleIds);

	List<ErpBulletHouseDto> getSaleListForCreateBullet(@Param("compId")Integer compId, @Param("shardCityId")Integer cityId, @Param("saleIds")String[] saleIds);

	void updateCancleTrueHouse(@Param("shardCityId")Short cityId, @Param("saleId")Integer caseId);
	
	ErpFunSale getSaleByCondition(Condition condition);
	
	List<ErpFunSale> selectListByCondition(BaseQuery condition);

	/**
	 * @author 方李骥
	 * @since 2016年8月30日
	 * @param cityId
	 * @param saleId
	 */
	void updateFunSaleKeyNumById(@Param("shardCityId")Integer cityId, @Param("updateModel")ErpFunSale ErpFunSale);
	
	List<ErpFunSale> getBulletinHouseList(ReqBulletinHouseListParam param);

	Integer countShareHouse(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId);

	void updateHouseOffCompId(@Param("shardCityId")Integer cityId, @Param("conditionModel")ErpFunSale conditionModel,
			@Param("updateModel")ErpFunSale updateModel, @Param("orgIds") List<Integer> orgIds);

	@SwitchDB(type = SwitchDBType.CITY_ID)
    void updateOthersbyUserPauseToNormal(@Param("shardCityId")Integer cityId, @Param("pMap") Map<String, Object> pMap);

	@SwitchDB(type = SwitchDBType.CITY_ID)
    void updateHouseForReg(@Param("shardCityId")Integer cityId, @Param("pMap")Map<String, Object> pMap);
	/**
	 * 获取需要处理单元信息的房源列表
	 * @author 张宏利
	 * @since 2017年2月23日
	 * @param dbName
	 * @param pageSize
	 * @return
	 */
	List<ErpFunSale> getNeedUpdateHouseUnitList(@Param("shardDbName")String dbName,@Param("pageSize") int pageSize, @Param("limitDate") String limitDate, @Param("lock") Integer lock);
	
	/**
	 * 通过ID重新生成MD5和单元，专用方法
	 * @author 张宏利
	 * @since 2017年2月23日
	 * @param funSaleUpdate
	 */
	void updateMd5AndUnit(ErpFunSale funSaleUpdate);
	
	/**
	 * 通过ID查询指定列
	 * @author 张宏利
	 * @since 2017年2月25日
	 * @param cityId 城市ID，用于分库
	 * @param saleId 出售房源ID
	 * @param compId 公司ID，保证是这个公司的数据
	 * @param columns 查询的指定列
	 * @return
	 */
	ErpFunSale selectColumnById(@Param("shardCityId")Integer cityId, @Param("saleId")Integer saleId, @Param("compId")Integer compId, @Param("columns") String[] columns);

	/**
	 * 通过求购信息匹配出售信息，用于新增房源推送
	 * @author 张宏利
	 * @since 2017年2月25日
	 * @param cityId 城市ID，分库用
	 * @param compId 公司ID，基础条件
	 * @param operRange 权限范围
	 * @param operRangeId 权限范围ID
	 * @param regIds 区域ID，逗号分隔
	 * @param sections 板块ID，逗号分隔
	 * @param buildIds 楼盘ID，逗号分隔
	 * @param useages 用途ID，逗号分隔
	 * @param funBuyCustomer 求购客源
	 * @return
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunSale> getMatchHouseCustList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,
			@Param("operRange")String operRange, @Param("operRangeId")int operRangeId, @Param("regIds")String regIds,
			@Param("sections")String sections, @Param("buildIds")String buildIds, @Param("useages")String useages,
			@Param("buyCust")ErpFunBuyCustomer funBuyCustomer
			);
	
	/**
	 * 获取自己某楼盘房源数量
	 * @author 张宏利
	 * @since 2017年3月9日
	 * @param cityId 城市ID
	 * @param userId 用户ID
	 * @param buildId 楼盘ID
	 * @return
	 */
	Map<String, Integer> getBuildHouseCount(@Param("shardCityId")Integer cityId, @Param("userId")Integer userId, @Param("buildId")Integer buildId);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	@SelectProvider(type=ErpFunSaleMapperProvider.class,method="selectFunSaleListByIds")
	@ResultType(Map.class)
	List<Map<String,Object>> selectFunSaleListByIds(@Param("shardCityId")Integer cityId,@Param("queryIds") Integer[] queryIds,@Param("queryColumn") String[] queryColumn,@Param("compId") Integer compId);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunSale> selectSaleListByIds(@Param("shardCityId")Integer cityId,@Param("queryIds") Integer[] queryIds,@Param("queryColumn") String[] queryColumn,@Param("compId") Integer compId);
	
	/**
	 * 更新缩略图文件路径为null
	 * @author 臧铁
	 * @since 2017年5月18日
	 * @return
	 */
	void updateThumbUrl(ErpFunSale erpFunSale);


	/**
	 * 获取没有生成fun_phone的房源数据
	 * @author 张宏利
	 * @since 2017年5月31日
	 * @param shardDbName
	 * @return
	 */
	List<ErpFunSale> getNoFunPhoneData(@Param("shardDbName")String shardDbName);
	
	/**
	 * 修改出售房源为广告房源
	 * @author 熊刚
	 * @since 2017年6月16日
	 */
	int updateFunAsdSalHouse(@Param("shardCityId") Integer cityId,@Param("caseId")Integer caseId,@Param("adsFlag")Integer adsFlag);
	
	int updateFunAsdSalHouseList(@Param("shardCityId") Integer cityId,@Param("caseIdList")List caseIdList,@Param("adsFlag")Integer adsFlag);

	void calcleIsSaleLease(@Param("shardCityId")Integer cityId, @Param("saleId")Integer caseId);

    List<Map<String, Object>> getSaleCountBySaleUnit(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("buildId") Integer buildId, @Param("caseRoof")String caseRoof, @Param("caseUnit") String caseUnit);

	Map<String,Integer> getSaleHouseBuildCountData(@Param("shardCityId")Integer cityId,
												   @Param("compId")Integer compId, @Param("buildId")Integer buildId, @Param("caseRoof")String caseRoof, @Param("caseUnit")String caseUnit);

    List<ErpFunSale> getSaleListByRoomId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("param")ErpBuildingSetFloorParam param);

	List<ErpFunSale> getOldSaleUnitList(@Param("shardDbName")String shardDbName);
	
	/**
	 * 获取需要处理的核心信息表的单元的列表
	 * @author 张宏利
	 * @since 2018年1月19日
	 * @param shardDbName
	 * @return
	 */
	List<ErpFunSale> getNeedDealUnitList(@Param("shardDbName")String shardDbName);
	
	/**
	 * 统计上架数
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/12
	 * @return
	 *
	 */
	Integer getExtensionNumber(@Param("compId") Integer compId,@Param("shardCityId") Integer cityId,
							   @Param("archiveId") Integer archiveId,@Param("sendToYouYou") Integer sendToYouYou,
							   @Param("buildIdFlag") boolean buildIdFlag);

    Integer countByUserId(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId,@Param("userId") Integer userId);

	/**
	 * 房源状态统计
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/29
	 */
	ErpFunSaleDto getSaleHouseStatusCount(@Param("shardCityId") Integer cityId,@Param("param")  Map<String,Object> param);

	/**
	 * 房源来源统计
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/29
	 */
	List<ErpFunSaleDto> getSaleHouseFromCount(@Param("shardCityId") Integer cityId,@Param("param") Map<String,Object> param);

	/**
	 * 房源分布区域统计
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/29
	 */	
	List<ErpFunSaleDto> getSaleHouseRegionCount(@Param("shardCityId") Integer cityId,@Param("param") Map<String,Object> param);

	/**
	 * 房源用途统计
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/29
	 */
	List<ErpFunSaleDto> getSaleHouseSaleCount(@Param("shardCityId") Integer cityId,@Param("param") Map<String,Object> param);

	List<ErpFunSaleDto> getSpecialListCount(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId,@Param("deptId") Integer deptId,@Param("userId") Integer userId);

	List<ErpFunSale> getFunSaleListByIds(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("caseIds") Set<Integer> caseIds);

	List<ErpFunSale> getFunSaleListByParam(@Param("shardCityId")Integer cityId,@Param("userId") Integer userId,@Param("buildIds") Set<Integer> buildIds);

	List<Map<String,Object>> getCompSaleAddCountByDate(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("startTime") Date startTime);

	List<Map<String,Object>> getSaleCountGoupByDept(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId);
	
	/**
	 *委托失效时修改房源上的委托备案状态和委托价格
	 * @detail [2020年05月16日] HuangJiang 
	 * @author HuangJiang
	 * @since 2020年05月16日 20:22
	 * @param cityId 城市ID
	 * @param saleId 房源ID
	 * @return void
	 * Modified XXX HuangJiang 2020年05月16日
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
    void cleanEntrustInfoBySaleId(@Param("shardCityId")Integer cityId, @Param("saleId") Integer saleId);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
    void setEntrustInfoBySaleId(@Param("shardCityId")Integer cityId, @Param("saleId") Integer saleId,
								@Param("record") Integer record,@Param("hasEntrust") Integer hasEntrust,@Param("saleEntrustPrice") BigDecimal saleEntrustPrice);
    
	List<Map<String,Object>> countCroupeByUserId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("rate")BigDecimal rate, @Param("cityRate") BigDecimal cityRate, @Param("organizationId")Integer organizationId, @Param("position")String position, @Param("userId")Integer userId);

	List<Map<String, Object>> countCheckCroupeByUserId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("rate")BigDecimal rate, @Param("cityRate") BigDecimal cityRate, @Param("organizationId")Integer organizationId, @Param("position")String position, @Param("userId")Integer userId);

	List<Map<String, Object>> getPersonnalPortentialPerformance(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("userId")Integer userId, @Param("offereeRate")BigDecimal offereeRate, @Param("submitKeyRate")BigDecimal submitKeyRate,
			@Param("funCheckRate")BigDecimal funCheckRate, @Param("recordRate")BigDecimal recordRate, @Param("cityRate")BigDecimal cityRate, @Param("caseType")Byte caseType);

    
    class ErpFunSaleMapperProvider{
		public String selectFunSaleListByIds(Map<String, Object> paramMap) throws Exception{
			Integer[] saleIds = (Integer[]) paramMap.get("queryIds");
			String[] saleColumns = (String[]) paramMap.get("queryColumn");
			Condition condition = new Condition();
			condition.add(new ConditionItem("COMP_ID","=","#{compId}")); 
			condition.add(new ConditionItem("SALE_ID","IN",saleIds)); 
			Columns columns = new Columns(saleColumns);
			return SQLBuilderSupport.selectByCondition( "FUN_SALE",false, columns, condition, null, null).toString();
		}
	}
	
	/**
	 * 通过主键ID获取房源电话
	 * @author 张宏利
	 * @since 2017年6月26日
	 * @param erpFunSale
	 * @return
	 */
	ErpFunSale getCellPhone(ErpFunSale erpFunSale);

	/**
	 * 当月新增数据中的出售数据
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
	 * 房源状态统计（有钥匙、有图片、有视频、已房勘、微店、真房源、有VR、预订）
	 * @author 臧铁
	 * @since 2017年7月18日
	 * @param cityId
	 * @param map
	 * @return
	 */
	Map<String, Object> getHouseBottomInfoForStatus(@Param("shardCityId")Integer cityId,@Param("param") Map<String, Object> map);

	/**
	 * 委托方式统计
	 * @author 臧铁
	 * @since 2017年7月19日
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> getHouseBottomInfoForSourceConsign(@Param("shardCityId")Integer cityId,@Param("param") Map<String, Object> map);

	/**
	 * 房源级别统计
	 * @author 臧铁
	 * @since 2017年7月19日
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> getHouseBottomInfoForSourceLevel(@Param("shardCityId")Integer cityId, @Param("param") Map<String, Object> map);
	
	/**
	 * 装修方式统计
	 * @author 臧铁
	 * @since 2017年7月19日
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> getHouseBottomInfoForSourceFitment(@Param("shardCityId")Integer cityId, @Param("param") Map<String, Object> map);
	/**
	 * 环域统计
	 * @author 臧铁
	 * @since 2017年7月19日
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> getHouseBottomInfoForRegionRound(@Param("shardCityId")Integer cityId,@Param("param") Map<String, Object> map);

	/**
	 * 片区、版块统计
	 * @author 臧铁
	 * @since 2017年7月19日
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> getHouseBottomInfoForRegionSection(@Param("shardCityId")Integer cityId, @Param("param") Map<String, Object> map);
	
	/**
	 * 房源用途统计（住宅、别墅、商铺、写字楼）
	 * @author 臧铁
	 * @since 2017年7月19日
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> getHouseBottomInfoForUseage(@Param("shardCityId")Integer cityId, @Param("param") Map<String, Object> map);

	/**
	 * 数据分析首页-房客源数据-各出售房源状态统计
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
	 * 获取有效出售房源总量
	 * @author 臧铁
	 * @since 2017年7月20日
	 * @param cityId
	 * @param compId
	 * @return
	 */
	Integer countAvailableHouse(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId);

	/**
	 * 通过楼盘IDs统计房源数量
	 * @author 臧铁
	 * @since 2017年7月21日
	 * @param cityId
	 * @param buildIds
	 * @return
	 */
	List<Map<String,Object>> countByBuildIds(@Param("shardCityId")Integer cityId, @Param("param") Map<String, Object> map);
	
	/**
	 * 通过商圈IDs统计房源数量
	 * @author 臧铁
	 * @since 2017年7月21日
	 * @param cityId
	 * @param sectionIds
	 * @return
	 */
	List<Map<String,Object>> countBySectionIds(@Param("shardCityId")Integer cityId, @Param("param") Map<String, Object> map);
	
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
	 * 获取员工或门店存量排名
	 * @author 张宏利
	 * @since 2017年7月26日
	 * @param cityId
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> getStoreDataRanking(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
	
	/**
	 * 通过价格对相关维度分析统计
	 * @author 张宏利
	 * @since 2017年7月26日
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getStoreDataAnalysisByPrice(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
	
	/**
	 * 通过面积对相关维度分析统计
	 * @author 张宏利
	 * @since 2017年7月26日
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getStoreDataAnalysisByArea(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
	
	/**
	 * 通过户型对相关维度分析统计
	 * @author 张宏利
	 * @since 2017年7月26日
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getStoreDataAnalysisByRoom(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);

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
	 * 房客源存量分析--买卖房客源基本情况
	 * @author 臧铁
	 * @since 2017年7月28日
	 * @param cityId
	 * @param map
	 * @return
	 */
	Map<String, Object> getHouseCustBasicStatus(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);

	/**
	 * 数据分析首页-买卖房价购买力分析房源套数
	 * @author 臧铁
	 * @since 2017年8月2日
	 * @param cityId
	 * @param compId
	 * @param caseWhenSql  经过处理的条件   见DataAnalysisUtil.getCaseWhenSql
	 * @return
	 */
	List<Map<String, Object>> getHouseBuyingPowerData(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("caseWhenSql")String caseWhenSql);

	/**
	 * 获取房客源列表
	 * @author 张宏利
	 * @since 2017年8月7日
	 * @param cityId
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getCaseList(@Param("shardCityId")Integer cityId, @Param("param") Map<String, Object> map);
	
	public List<Map<String, Object>> getCaseListCut(@Param("shardCityId")Integer cityId, @Param("param") Map<String, Object> map);

	public List<HouseCustAddCountDto> getHouseAddCountData(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	
	public List<HouseCustAddCountDto> getCustAddCountData(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);

	ErpFunSale getHouseBaseInfo(@Param("shardCityId")Integer cityId, @Param("saleId") Integer saleId);
	
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

	@MapKey("saleId")
	Map<Integer, ErpFunSaleDto> getDkErpFunSale(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("targetIds")String[] targetIds);
	
	/**
	 * 获取重复数据
	 * 
	 * @author 张宏利
	 * @since 2017年10月24日
	 * @param buildId
	 * @param md5Str
	 * @param useageArr
	 * @return
	 */
	List<Map<String, Object>> getAddrRepetList(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
			@Param("userId") Integer userId, @Param("buildId") Integer buildId,
			@Param("md5StrList") List<String> md5StrList, @Param("useageArr") Byte[] useageArr,
			@Param("tradeAddrCon") String tradeAddrCon, @Param("numCon") String numCon);

	/**
	 * 获取电话重复列表
	 * 
	 * @author 张宏利
	 * @since 2017年10月24日
	 * @return
	 */
	List<Map<String, Object>> getPhoneRepeatList(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("userId") Integer userId, @Param("phoneArr")String[] phoneArr);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	String generatorSaleNo(@Param("shardCityId")Integer cityId, @Param("compNo") String compNo);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	Integer countRangeRepeatHouse(@Param("shardCityId")Integer cityId, @Param("areaId") Integer areaId , @Param("regId") Integer regId ,
								 @Param("grId") Integer grId, @Param("compId") Integer compId, @Param("deptId") Integer deptId,
								  @Param("addrMd5") List<String> addrMd5, @Param("buildId") Integer buildId, @Param("repeatRange") String repeatRange ,@Param("useage") Set<Byte> useage);
	
	List<Map<String, Object>> testSaleSql(@Param("shardCityId")Integer cityId, @Param("allColumn") Integer allColumn);
	
	/**
	 * 获取用户的出售房源数量
	 * @author 张宏利
	 * @since 2018年1月30日
	 * @param cityId
	 * @param userId
	 * @return
	 */
	Integer getSaleCount(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("userId") Integer userId);
	
	/**
	 * 提醒关注数量待跟房、待完善
	 *@author 朱科
	 *@param 
	 *@return Integer
	 *@since 2018年2月5日
	 */
	Map<String, Integer> getSaleCountByFlag(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("rangeType") Integer rangeType,
											@Param("rangeIds") Set<Integer> rangeIds, @Param("partnerId") Integer partnerId,
											@Param("newOrganizationType") boolean newOrganizationType);
	
	/**
	 * 提醒关注数量店内新增
	 *@author 朱科
	 *@param 
	 *@return Integer
	 *@since 2018年2月5日
	 */
	Integer selectHotIncrementByDeptId(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId,
									   @Param("deptId") Integer deptId, @Param("nowDate") String nowDate,@Param("privateTime") String privateTime,
									   @Param("plateType") Integer plateType, @Param("houseLevel") Integer houseLevel, @Param("partnerId") Integer partnerId);

	/**
	 * 提醒关注数量组织内新增
	 */
	Integer selectHotIncrementByOrgId(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId,
									   @Param("organizationId") Integer organizationId, @Param("nowDate") String nowDate,@Param("privateTime") String privateTime,
									   @Param("plateType") Integer plateType, @Param("houseLevel") Integer houseLevel, @Param("partnerId") Integer partnerId);

	/**
	 * 提醒关注数量调价房
	 *@author 朱科
	 *@param 
	 *@return Integer
	 *@since 2018年2月5日
	 */
	Integer getModifyPriceEndCount(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("nowDate")String nowDate, @Param("deptId") Integer deptId, @Param("userId") Integer userId);

	/**
	 * 提醒关注数量调价房(组织内)
	 */
	Integer getModifyPriceEndCountByOrg(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("nowDate")String nowDate,
								  	 @Param("organizationId") Integer organizationId, @Param("userId") Integer userId);


	/**
	 * 管理范围内新增房源
	 *@author 朱科
	 *@param 
	 *@return Integer
	 *@since 2018年2月6日
	 */
	@AccessReadonlyDb
	Integer getSaleAddCount(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("manageLevel") Byte manageLevel,
							@Param("manageRangIds") Set<Integer> manageRangIds, @Param("startTime")String startTime, @Param("dealTime")String dealTime,
							@Param("saleStatus")Integer saleStatus, @Param("trackTime")String trackTime, @Param("partnerId") Integer partnerId);
	
	/**
	 * 查询unit不为空、unit_t为空的数据
	 * @author 张宏利
	 * @since 2018年3月14日
	 * @param dbName
	 * @param i
	 * @return
	 */
	List<ErpFunSale> getUnitNotEqDecryptList(@Param("shardDbName")String dbName,@Param("pageSize") Integer pageSize, @Param("compId") Integer compId);
	
	/**
	 * 暂缓盘
	 * @return
	 */
	@AccessReadonlyDb
	Integer getSaleZhAddCount(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("manageLevel") Byte manageLevel,
                              @Param("manageRangIds") Set<Integer> manageRangIds, @Param("saleStatus")Integer saleStatus,
                              @Param("startTime")String startTime, @Param("saleIds")Set<Integer> saleIds, @Param("partnerId") Integer partnerId);
	
	/**
	 * 下架 推广房源和真房源
	 * @param cityId
	 * @param compId
	 * @param archiveId
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updatePublishAndTrueFlagByArchiveId(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("archiveIds")List<Integer> archiveIds, @Param("deptId") Integer deptId);

	List<ErpFunSale> getTopFunSale(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId, @Param("deptId")Integer srcDeptId,
									  @Param("userId")String srcUserId, @Param("plateType")Integer plateType,@Param("num")Integer num);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<FunSaleDto> getHouseSaleList(@Param("shardCityId")Integer cityId, @Param("param")QueryHouseCustListParam param);
	
	/**
	 * 帐号从暂停到启用更新策略参数信息
	 * @param cityId
	 * @param timeZone
	 * @param compId
	 * @param deptId
	 * @param userId
	 */
	void updatebyUserPauseToNormal(@Param("shardCityId")Integer cityId,@Param("timeZone")Integer timeZone,@Param("compId") Integer compId, @Param("deptId") Integer deptId, @Param("userId") Integer userId);

	List<ErpFunSaleDto> getMatchSaleList(@Param("shardCityId")Integer cityId, @Param("param")Map<String,Object> map);
	
	/**
	 * 系统策略参数更新房勘计时起始时间
	 * @author 朱科
	 * @since 2018年7月23日
	 * @return
	 */
	void updateHouseActionTimeByPlot(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId,
									 @Param("tableName")String tableName, @Param("day")Integer day, @Param("orgIds")List<Integer> orgIds);
	
	/**
	 * 系统策略参数更新跟进计时起始时间
	 * @author 朱科
	 * @since 2018年7月23日
	 * @return
	 */
	void updateHouseTrackTimeByPlot(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("tableName")String tableName,
									@Param("fromPublic")Integer fromPublic, @Param("day")Integer day, @Param("orgIds")List<Integer> orgIds);
	
	/**
	 * 系统策略参数更新时间
	 * @author 朱科
	 * @since 2018年7月23日
	 * @return
	 */
	void updateHousePublicTimeByPlot(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("tableName")String tableName,
									 @Param("day")Integer day, @Param("orgIds")List<Integer> orgIds);
	
	/**
	 * 关闭策略参数更新标记
	 * @author 朱科
	 * @since 2018年7月23日
	 * @return
	 */
	void clearFlagByPlctSwotch(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("orgIds")List<Integer> orgIds);

	/**
	 * 通过条件查询Top1的对象信息
	 * @author ZangTie
	 * @since 2018年7月24日 下午6:02:31
	 * @param erpFunSaleExample
	 * @return
	 * Modified XXX ZangTie 2018年7月24日
	 */
	ErpFunSale selectOneByExample(ErpFunSaleExample erpFunSaleExample);
	
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
	List<ErpFunSale> getFunSaleListByCompIdAndCaseIds(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("caseIds")Set<Integer> caseIds);
	
	/**
	 * 获取soso数据列表
	 * @author 朱科
	 * @since 2018年8月28日
	 * @return
	 */
	List<SearchSosoViewDto> getSosoViewDataList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,
			@Param("areaId")Integer areaId, @Param("regId")Integer regId, @Param("deptId")Integer deptId, @Param("grId")Integer grId,
			@Param("userId")Integer userId, @Param("caseIds")Set<Integer> caseIds, @Param("phone")String phone, @Param("trueViewRang")Integer trueViewRang);
	/***
	 * 通过实名修改标记
	 * @author 尹振兴
	 * @since 2018年3月26日
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updatePassRealNamePublish(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("deptId") Integer deptId, @Param("userId") Integer userId);
	
	/**
	 * 通过房源列表权限查看房源
	 * @author 朱科
	 * @since 2018年10月22日
	 * @return
	 */
	List<ErpFunSale> getAppAchieveMonthStatisticsRankDetailHouseAdd(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("caseIds")Set<Integer> caseIds, @Param("trueViewRang")Integer trueViewRang, @Param("trueViewRangId")Integer trueViewRangId, @Param("deptId") Integer deptId);

/**
	 * 通过房源列表权限查看房源
	 * @author 朱科
	 * @since 2018年10月22日
	 * @return
	 */
	List<ErpFunSale> getAppAchieveMonthStatisticsRankDetailHouseAddForOrg(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("caseIds")Set<Integer> caseIds,@Param("orgLikeWhereCause") String orgLikeWhereCause);

	void updateByUserDefineSql(@Param("shardCityId")Integer cityId, @Param("sql")String sql);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunSale> getDealSaleList(@Param("shardCityId")Integer cityId, @Param("saleIds")List<Integer> saleIds);

	List<ErpFunSale> getHouseByIds(@Param("shardCityId") Integer cityId,@Param("saleIds") List<Integer> saleIds);

	List<ErpFunSale> getFunSaleListByCaseIds(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
											 @Param("buildId") Integer buildId, @Param("caseIds") Set<Integer> caseIds);

	/**
	 * 通过房源列表查看房源
	 *
	 * @author czq
	 * @since 2019年4月11日
	 */
	List<ErpFunSale> getFunListByCaseIds(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("caseIds") String[] caseIds);

	List<ErpFunSale> getFunListByCaseIds(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("caseIds") List<Integer> caseIds);

	List<HouseInfoVO> selectHouseInfoListByIds(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("caseIds")List<Integer> houseIds);

    Integer countShareHouseByPartner(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("partnerId") Integer partnerId);

	void transDataForDeleteUser(@Param("shardCityId") Integer cityId, @Param("paramMap")Map<String,Object> paramMap);

	ErpFunSale selectSaleInfoByCaseNo(@Param("shardCityId") Integer cityId, @Param("caseNo") String caseNo);

	void updateByCaseNo(@Param("shardCityId")Integer cityId, @Param("caseNo")String caseNo, @Param("operatorType")Integer operatorType,@Param("days") Integer days);
	
	//新增的离职员工移交私盘房源
	void transSaleData(@Param("shardCityId") Integer cityId, @Param("paramMap")Map<String,Object> paramMap);

}


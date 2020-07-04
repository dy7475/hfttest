package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.myfun.repository.erpdb.dto.ErpFunDealDto;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.dto.ErpFunAreaDto;
import com.myfun.repository.erpdb.po.ErpFunArea;
import com.myfun.repository.erpdb.po.ErpFunAreaExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunAreaMapper extends BaseMapper<ErpFunArea, ErpFunArea> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunAreaExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunAreaExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunArea> selectByExample(ErpFunAreaExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunArea record, @Param("example") ErpFunAreaExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunArea record, @Param("example") ErpFunAreaExample example);

	/**
	 * 根据compId查询大区
	 * @param cityId
	 * @param compId
	 * @return
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunAreaDto> selectByCondition(ErpFunArea erpFunArea);
	
	/**
	 * 获取公司大区数量
	 * @author 张宏利
	 * @since 2018年2月5日
	 * @param cityId
	 * @param compId
	 * @return
	 */
	List<ErpFunArea> getAllAreaCount(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId);

	List<ErpFunArea> selectAreaList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,
									@Param("manageRangeRangeType") Integer manageRangeRangeType, @Param("userManageRangeIds") Set<Integer> userManageRangeIds, @Param("updateTime") String updateTime);
	
	List<ErpFunArea> selectAreaListRank(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("areaId")Integer areaId);

    List<ErpFunArea> getDataListByCompId(@Param("shardCityId")Integer cityId,@Param("compId") String compId);

    /**
     * 统计大区名字
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/5/18
     */
    Integer countByAreaName(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,@Param("areaName") String areaName);

    /**
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/5/18
     */
	ErpFunArea getAreaByAreaId(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId,@Param("areaId") Integer areaId);

//	List<ErpFunDealDto> getRangeListDaTaOfComp(@Param("shardCityId") Integer cityId, @Param("param") Map<String,Object> param);
//
//	List<ErpFunDealDto> getRangeListDaTaOfAreaAndGroup(@Param("shardCityId") Integer cityId,@Param("param") Map<String,Object> param);
//
//	List<ErpFunDealDto> getRangeListDaTaOfRegAndGroup(@Param("shardCityId") Integer cityId,@Param("param") Map<String,Object> param);
//
//	List<ErpFunDealDto> getRangeListDaTaOfDeptAndGroup(@Param("shardCityId") Integer cityId,@Param("param") Map<String,Object> param);
//
//	List<ErpFunDealDto> getRangeListDaTa(@Param("shardCityId") Integer cityId,@Param("param") Map<String,Object> param);

	/**
	 * 查询需要扑数据的
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/14
	 */
	List<ErpFunDealDto> getRangeListData(@Param("shardCityId") Integer cityId,@Param("param")  Map<String,Object> param);

	List<Map<String,Object>> executeBySQL(@Param("shardCityId")Integer cityId, @Param("columnName")String columnName,
										  @Param("tableName") String tableName,@Param("whereSql") String whereSql);
	
	void updateByAdminUser(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("areaId") Integer areaId);

	Integer getCompAreaId(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId);
}
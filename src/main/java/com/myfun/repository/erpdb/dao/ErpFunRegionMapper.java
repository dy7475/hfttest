package com.myfun.repository.erpdb.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.dto.ErpFunRegionDto;
import com.myfun.repository.erpdb.po.ErpFunRegion;
import com.myfun.repository.erpdb.po.ErpFunRegionExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunRegionMapper extends BaseMapper<ErpFunRegion, ErpFunRegion> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunRegionExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunRegionExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunRegion> selectByExample(ErpFunRegionExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunRegion record, @Param("example") ErpFunRegionExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunRegion record, @Param("example") ErpFunRegionExample example);

	/**
	 * 根据compId查询片区
	 * @param cityId
	 * @param compId
	 * @return
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunRegion> selectByCompId(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId);

	/**
	 * 根据compId查询?条，id ASC
	 * @param compId
	 * @return
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunRegion selectByCompIdOne(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunRegionDto> selectListByCondition(ErpFunRegion erpFunRegion);

	/**
	 * 获取公司片区数量
	 * @author 张宏利
	 * @since 2018年2月5日
	 * @param cityId
	 * @param compId
	 * @return
	 */
	List<ErpFunRegion> getAllRegCount(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId);

	List<ErpFunRegion> getRegListByAreaId(@Param("shardCityId")Integer cityId,  @Param("compId")Integer compId, @Param("areaId") Integer rangeId);

	List<ErpFunRegion> selectRegList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("manageRangeRangeType")Integer manageRangeRangeType,
									 @Param("userManageRangeIds")Set<Integer> userManageRangeIds, @Param("updateTime") String updateTime);
	
	List<ErpFunRegion> selectRegListRank(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("areaId")Integer areaId);

	List<ErpFunRegion> getCacheableRegionListByAreaId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId);
	
	/**
	 * 根据regId查询片区
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/20
	 * @return
	 *
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunRegion getDataById(@Param("shardCityId")Integer cityId,@Param("regId") Integer regId);
	
	/**
	 * 跟新片区至大区
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/20
	 * @return
	 *
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateRegforArea(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("regId") Integer regId,@Param("areaId") Integer areaId);

	/**
	 * 根据compId删除更新
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/23
	 * @return
	 *
	 */
	void deleteByCompIdAndRegId(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("regId") Integer regId);

	/**
	 * 统计片区名字
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/18
	 */
    Integer countRegionByRegName(@Param("shardCityId")  Integer cityId,@Param("compId") Integer compId,@Param("areaId") Integer areaId,@Param("regName") String regName);

    /**
     * 通过regId查询
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/5/18
     */
	ErpFunRegion selectByRegId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("areaId")Integer areaId, @Param("regId")Integer regId);
	
	/**
	 * 片区调大区之后修改相关数据组织机构
	 * @author 张宏利
	 * @since 2018年5月28日
	 * @param cityId
	 * @param compId
	 * @param areaId
	 * @param regId
	 */
	void updateAreaByRegChange(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("areaId")Integer areaId, @Param("regId")Integer regId);

	ErpFunRegion getModelDataById(@Param("shardCityId")Integer cityId,@Param("primaryId") String primaryId);

    List<ErpFunRegion> getRegionListBynamicId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("columnName")String columnName, @Param("columnValue")String columnValue);

//	@SwitchDB(type = SwitchDBType.CITY_ID)
//	ErpFunReg getCacheableModelDataById(ErpFunReg pReg);
    
    List<ErpFunRegion> getRegListByAreaIds(@Param("shardCityId")Integer cityId,  @Param("compId")Integer compId, @Param("rangeIds") List<Integer> rangeIds, @Param("selfAreaId")Integer selfAreaId);
    
    void updateByAdminUser(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("areaId") Integer areaId, @Param("regId") Integer regId);
}
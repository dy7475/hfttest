package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.param.ErpBuildingSetParam;
import com.myfun.repository.erpdb.po.ErpBuildingSet;
import com.myfun.repository.erpdb.po.ErpBuildingSetExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.DaoBaseParam;

public interface ErpBuildingSetMapper extends BaseMapper<ErpBuildingSet, ErpBuildingSet> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpBuildingSetExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpBuildingSetExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpBuildingSet> selectByExample(ErpBuildingSetExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpBuildingSet record,
			@Param("example") ErpBuildingSetExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpBuildingSet record, @Param("example") ErpBuildingSetExample example);

	/**
	 * @author 方李骥
	 * @since 2016年9月1日
	 * @param conditionModel
	 * @return
	 */
	
	@SwitchDB(type=SwitchDBType.CITY_ID)
	int countErpBuildingSet(ErpBuildingSet conditionModel);

	/**
	 * @author 方李骥
	 * @since 2016年9月1日
	 * @param conditionModel
	 * @return
	 */
	
	
	@SwitchDB(type=SwitchDBType.CITY_ID)
	List<ErpBuildingSet> getBuildingRuleList(ErpBuildingSet conditionModel);

	/**
	 * @author 方李骥
	 * @since 2016年9月2日
	 * @param param
	 */
	
	
	@SwitchDB(type=SwitchDBType.CITY_ID)
	void updateErpBuildingSet(@Param("shardCityId")Integer cityId,@Param("updateModel")DaoBaseParam param);
	/**
	 * @author 方李骥
	 * @since 2016年9月2日
	 * @param param
	 */
	
	
	@SwitchDB(type=SwitchDBType.CITY_ID)
	void insertErpBuildingSet(@Param("shardCityId")Integer cityId,@Param("insertModel")DaoBaseParam param);

	/**
	 * @author 方李骥
	 * @since 2016年9月2日
	 * @param cityId
	 * @param buildLock
	 * @param conditionModel
	 */
	
	
	@SwitchDB(type=SwitchDBType.CITY_ID)
	void updateLockBuildRule(@Param("shardCityId")Integer cityId,@Param("buildLock") Byte buildLock,@Param("condition")ErpBuildingSet condition);

	/**
	 * @author 方李骥
	 * @since 2016年9月2日
	 * @param cityId
	 * @param condition
	 * @return
	 */
	
	
	@SwitchDB(type=SwitchDBType.CITY_ID)
	ErpBuildingSet selectBuildfloors(@Param("shardCityId")Integer cityId,@Param("conditionModel") ErpBuildingSet condition);
	
	/**
	 * 查询锁定的楼盘字典
	 * @author 熊刚
	 * @since 2017年7月7日
	 * @param cityId
	 * @param buildIdList
	 * @return
	 */
	@SwitchDB(type=SwitchDBType.CITY_ID)
	List<ErpBuildingSet> selectBuildIdLockList(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("buildIdList")Set<Integer> buildIdList);
	
	/**
	 * 获取是否锁定
	 * @author 张宏利
	 * @since 2017年8月21日
	 * @param cityId
	 * @param buildId
	 * @return 大于0代表锁定
	 */
	Integer getIsLock(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId,@Param("buildId")Integer buildId);
	
	/**
	 * 获取栋座数
	 * @author 张宏利
	 * @since 2017年8月22日
	 * @param cityId
	 * @param compId
	 * @param buildId
	 * @return
	 */
	List<Map<String, Object>> getRoofDoorCount(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId,@Param("buildId")Integer buildId);
	
	/**
	 * 通过栋座和单元名称查询是否有重复的
	 * @author 张宏利
	 * @since 2017年8月22日
	 * @param cityId
	 * @param compId
	 * @param buildId
	 * @param roofList
	 * @param unitList
	 * @return
	 */
	Integer getRoofUnitNameRepeatCount(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId,@Param("buildId")Integer buildId,
			@Param("buildRoof")String buildRoof, @Param("buildUnit")String buildUnit, @Param("bsId")Integer bsId);
	
	/**
	 * 获取栋座列表
	 * @author 张宏利
	 * @since 2017年8月22日
	 * @param param
	 * @return
	 */
	List<ErpBuildingSet> getBuildRoofList(ErpBuildingSetParam param);

	/**
	 * 获取单元列表
	 * @author 张宏利
	 * @since 2017年8月22日
	 * @param param
	 * @return
	 */
	List<ErpBuildingSet> getBuildUnitList(ErpBuildingSetParam param);

	/**
	 * 删除栋座 
	 * @author 臧铁
	 * @since 2017年8月25日
	 * @param param compId buildId  buildRoof栋座
	 */
	void delBuildRoofById(ErpBuildingSetParam param);

	/**
	 * 删除单元
	 * @author 臧铁
	 * @since 2017年8月25日
	 * @param param compId buildId  buildRoof栋座   buildUnit单元
	 */
	void delBuildUnitById(ErpBuildingSetParam param);
	
	/**
	 * 获取当前栋号室起始号
	 * @author 张宏利
	 * @since 2017年9月7日
	 * @param cityId
	 * @param compId
	 * @param buildId
	 * @param numberRule 
	 * @return
	 */
	Integer getDoorStartNum(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId,@Param("buildId")Integer buildId,@Param("buildRoof")String buildRoof, @Param("numberRule")Byte numberRule);
	
	/**
	 * 通过老的roof修改成新的roof
	 * @author 张宏利
	 * @since 2017年9月27日
	 * @param param
	 */
	void updateRoofByOldRoof(ErpBuildingSetParam param);
	
	List<ErpBuildingSet> getBuildRoofUnits(@Param("shardCityId") Integer cityId,@Param("param") Map<String, Object> map);
	
	/**
	 * 获取规则记录
	 * @author 张宏利
	 * @since 2017年10月17日
	 * @param cityId
	 * @param buildId
	 * @param compId 
	 * @param buildRoof
	 * @param buildUnit
	 * @return
	 */
	ErpBuildingSet selectByBuildUnit(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("buildId")Integer buildId, @Param("buildRoof")String buildRoof, @Param("buildUnit")String buildUnit);
	
	ErpBuildingSet getErpBuildingSet(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("buildId")Integer buildId, @Param("isLock")Integer isLock);
	
	ErpBuildingSet getErpBuildingSetByRoofAndUnit(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId,@Param("buildId")Integer buildId,@Param("buildRoof")String buildRoof,@Param("buildUnit")String buildUnit);
	
	/**
	 * 创建楼盘规则模板
	 * @author 张宏利
	 * @since 2017年12月20日
	 * @param cityId
	 * @param buildId
	 */
	void createTempBuildingSet(@Param("shardCityId")Integer cityId, @Param("sourceCompId") Integer sourceCompId,
			@Param("buildId")Integer buildId, @Param("copyToCompId") Integer copyToCompId, 
			@Param("copyToCompNo") String copyToCompNo);
	
	/**
	 * 删除公司的已有楼盘规则
	 * @author 张宏利
	 * @since 2018年3月20日
	 * @param cityId
	 * @param buildId
	 * @param compId
	 */
	void deleteCompBuildingSet(@Param("shardCityId")Integer cityId, @Param("buildId")Integer buildId, @Param("compId")Integer compId);

	void delBuildById(ErpBuildingSetParam param);

	/**
	 * 应用系统模板到楼盘
	 *
	 * @param cityId Integer
	 * @param sourceCompId  Integer
	 * @param buildId  Integer
	 * @param copyToCompId  Integer
	 *
	 * @author czq
	 * @since 2018年12月11日
	 */
	void copyTempBuildRule(@Param("shardCityId")Integer cityId, @Param("sourceCompId") Integer sourceCompId,
						   @Param("buildId")Integer buildId, @Param("copyToCompId") Integer copyToCompId);
}



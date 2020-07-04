package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.param.ErpBuildingSetParam;
import com.myfun.repository.erpdb.po.ErpBuildingSetSetting;
import com.myfun.repository.erpdb.po.ErpBuildingSetSettingExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpBuildingSetSettingMapper extends BaseMapper<ErpBuildingSetSetting, ErpBuildingSetSetting> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpBuildingSetSettingExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpBuildingSetSettingExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpBuildingSetSetting> selectByExample(ErpBuildingSetSettingExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpBuildingSetSetting record,
			@Param("example") ErpBuildingSetSettingExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpBuildingSetSetting record,
			@Param("example") ErpBuildingSetSettingExample example);

	/**
	 * 通过楼盘ID获取配置
	 * @author 张宏利
	 * @since 2018年5月19日
	 * @param cityId
	 * @param compId
	 * @param buildId
	 * @return
	 */
	ErpBuildingSetSetting selectByBuildId(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("buildId") Integer buildId);
	
	/**
	 * 修改锁定状态
	 * @author 张宏利
	 * @since 2018年5月19日
	 * @param cityId
	 * @param compId
	 * @param buildId
	 * @param lockFlag
	 */
	void updateLockBuildRule(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("deptId") Integer deptId, @Param("buildId") Integer buildId, @Param("buildLock") Integer buildLock);

	void delBuildById(ErpBuildingSetParam param);

	void updateBuildLock(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("buildId") Integer buildId, @Param("buildLock") Integer buildLock);

}

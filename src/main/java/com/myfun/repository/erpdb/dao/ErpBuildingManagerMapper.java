package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpBuildingManager;
import com.myfun.repository.erpdb.po.ErpBuildingManagerExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ErpBuildingManagerMapper extends BaseMapper<ErpBuildingManager, ErpBuildingManager> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpBuildingManagerExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpBuildingManagerExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpBuildingManager> selectByExample(ErpBuildingManagerExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpBuildingManager record,
			@Param("example") ErpBuildingManagerExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpBuildingManager record,
			@Param("example") ErpBuildingManagerExample example);

	List<ErpBuildingManager> getBuildingManagers(@Param("shardCityId") Integer cityId,@Param("buildIds")List<Integer> buildIds,@Param("compId")Integer compId);

	List<ErpBuildingManager> getRoofManagers(@Param("shardCityId") Integer cityId,@Param("buildIds")List<Integer> buildIds,@Param("compId")Integer compId);

	Integer getBuildManageUserId(@Param("shardCityId") Integer cityId,@Param("buildId")Integer buildId,@Param("compId")Integer compId);

	Integer getRoofManagerById(@Param("shardCityId") Integer cityId,@Param("compId")Integer compId,@Param("managerId")Integer managerId);

	Integer getRoofManagerByUserId(@Param("shardCityId") Integer cityId,@Param("compId")Integer compId,@Param("buildId")Integer buildId,@Param("userId")Integer userId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void insertManager(ErpBuildingManager manager);
	void updateManager(@Param("shardCityId") Integer cityId,@Param("compId")Integer compId,@Param("buildId")Integer buildId,@Param("userId") Integer userId);

	/**
	 * 查询楼盘是否有维护人
	 * @author wangchun
	 * @return
	 */
	Integer ckeckHaveManager(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId , @Param("buildId")Integer buildId);

	void deleteUnuseRoofManager(@Param("shardCityId") Integer cityId,@Param("compId")Integer compId,@Param("buildId")Integer buildId);

	/**
	 * 获取栋座管理员的楼盘ids
	 * @param cityId
	 * @param compId
	 * @param userIdList
	 * @param managerType
	 */
	List<ErpBuildingManager> getBuildListByUserId(@Param("shardCityId") Integer cityId,@Param("compId")Integer compId,@Param("userIdList")List<Integer> userIds,@Param("mType")Byte managerType);
}
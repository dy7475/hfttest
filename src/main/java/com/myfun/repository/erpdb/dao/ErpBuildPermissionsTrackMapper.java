package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.build.param.PermissionTrackListParam;
import com.myfun.repository.erpdb.po.ErpBuildPermissionsTrack;
import com.myfun.repository.erpdb.po.ErpBuildPermissionsTrackExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpBuildPermissionsTrackMapper extends BaseMapper<ErpBuildPermissionsTrack, ErpBuildPermissionsTrack> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpBuildPermissionsTrackExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpBuildPermissionsTrackExample example);

	/**
	 * @mbggenerated
	 */List<ErpBuildPermissionsTrack> selectByExample(ErpBuildPermissionsTrackExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpBuildPermissionsTrack record,@Param("example") ErpBuildPermissionsTrackExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpBuildPermissionsTrack record,@Param("example") ErpBuildPermissionsTrackExample example);

	@SwitchDB(type = SwitchDBType.CITY_ID)
    List<ErpBuildPermissionsTrack> selectPermissionTrackList(@Param("shardCityId") Integer cityId , @Param("param")PermissionTrackListParam param);
}
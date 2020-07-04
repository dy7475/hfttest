package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpBroadcast;
import com.myfun.repository.erpdb.po.ErpBroadcastKey;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpBroadcastMapper extends BaseMapper<ErpBroadcast, ErpBroadcastKey> {

	Integer insertBoradCast(Map<String, Object> paramMap);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void insertBulletBroadcast(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
			@Param("bulletId") Integer bulletId, @Param("bound") Integer bound, @Param("userId") Integer userId,
			@Param("deptId") Integer deptId, @Param("isPartner")boolean isPartner, @Param("partnerId")Integer partnerId);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void insertBulletBroadcastNewOrg(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
			@Param("bulletId") Integer bulletId, @Param("bound") Integer bound, @Param("userId") Integer userId,
			@Param("pubOrganizationId") String pubOrganizationId, @Param("isPartner") boolean isPartner, @Param("partnerId") Integer partnerId);

    List<ErpBroadcast> getBroadCastList(@Param("shardArchiveId")Integer archiveId, @Param("isYouJia")Boolean isYouJia);

    void deleteByArchiveId(@Param("shardCityId")Integer cityId, @Param("archiveId")Integer archiveId);
}


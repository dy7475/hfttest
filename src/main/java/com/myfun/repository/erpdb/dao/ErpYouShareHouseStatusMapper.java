package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import com.myfun.repository.erpdb.po.ErpTrackVideo;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.dto.ErpYouComplainDto;
import com.myfun.repository.erpdb.param.ErpYouComplainParam;
import com.myfun.repository.erpdb.po.ErpYouShareHouseStatus;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpYouShareHouseStatusMapper extends BaseMapper<ErpYouShareHouseStatus, ErpYouShareHouseStatus> {

	List<ErpYouComplainDto> getComplainList(ErpYouComplainParam erpYouComplainParam);

	@SwitchDB(type=SwitchDBType.CITY_ID)
	ErpYouShareHouseStatus getRecordByShareId(@Param("shardCityId")Integer cityId, @Param("shareId")Integer targetInfoId);

	@SwitchDB(type=SwitchDBType.CITY_ID)
	int downShareHouse(@Param("shardCityId")Integer cityId, @Param("houseStatus")ErpYouShareHouseStatus houseStatus);

	@SwitchDB(type=SwitchDBType.CITY_ID)
	int buckleHouseIntegral(@Param("shardCityId")Integer cityId, @Param("houseStatus")ErpYouShareHouseStatus houseStatus);

	@SwitchDB(type=SwitchDBType.CITY_ID)
	void downShareHouseByCondition(@Param("shardCityId")Integer cityId, @Param("houseStatus")ErpYouShareHouseStatus houseStatus);

	@SwitchDB(type=SwitchDBType.CITY_ID)
	void downShareDataByCaseIds(@Param("shardCityId") Integer cityId, @Param("pMap")Map<String, Object> pMap);

	/**
	 * @author 方李骥
	 * @since 2016年8月30日
	 * @param cityId
	 * @param youShareHouseStatusPO
	 * @param youSHareHouseCondition
	 */	
	@SwitchDB(type=SwitchDBType.CITY_ID)
	void updateKeyStatus(@Param("shardCityId")Integer cityId, @Param("updateModel")ErpYouShareHouseStatus youShareHouseStatusPO,
			 @Param("conditionModel")ErpYouShareHouseStatus youSHareHouseCondition);


	// 迁移图片
	Integer selectLastPhotoId(@Param("shardDbName") String shardDbName);

	List<ErpYouShareHouseStatus> getPhotoListOrderByPhotoIdDesc(@Param("shardDbName") String shardDbName, @Param("shareId")Integer photoId);

	void insertList(@Param("shardDbName") String shardDbName, @Param("photoList") List<Map<String, Object>> fastdfsPhotoList);

	void updatePhotoAddrForList(@Param("shardDbName") String shardDbName, @Param("photoList") List<Map<String, Object>> fastdfsPhotoList);
	// 迁移图片
}
package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpTrackVideo;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpTrackVideoExample;

public interface ErpTrackVideoMapper extends BaseMapper<ErpTrackVideo, ErpTrackVideo> {

    /**
	 * @mbggenerated
	 */
	int countByExample(ErpTrackVideoExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpTrackVideoExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpTrackVideo> selectByExample(ErpTrackVideoExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpTrackVideo record, @Param("example") ErpTrackVideoExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpTrackVideo record, @Param("example") ErpTrackVideoExample example);

	Integer selectLastPhotoId(@Param("shardDbName") String shardDbName);

    List<ErpTrackVideo> getPhotoListOrderByPhotoIdDesc(@Param("shardDbName") String shardDbName, @Param("videoId")Integer photoId);
    List<ErpTrackVideo> getErpTrackVideoListByTrackId(@Param("shardCityId") Integer cityId, @Param("trackId")Integer trackId);
    void insertList(@Param("shardDbName") String shardDbName, @Param("photoList") List<Map<String, Object>> fastdfsPhotoList);

    void updatePhotoAddrForList(@Param("shardDbName") String shardDbName, @Param("photoList") List<Map<String, Object>> fastdfsPhotoList);

}
package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpTrackPhoto;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpTrackPhotoMapper extends BaseMapper<ErpTrackPhoto, ErpTrackPhoto> {

    Integer selectLastPhotoId(@Param("shardDbName") String shardDbName);

    List<ErpTrackPhoto> getPhotoListOrderByPhotoIdDesc(@Param("shardDbName") String shardDbName, @Param("photoId")Integer photoId);
    
    List<ErpTrackPhoto> getPhotoListByTrackId(@Param("shardCityId") Integer cityId, @Param("trackId")Integer trackId);

    void insertList(@Param("shardDbName") String shardDbName, @Param("photoList") List<Map<String, Object>> fastdfsPhotoList);
    void updatePhotoAddrForList(@Param("shardDbName") String shardDbName, @Param("photoList") List<Map<String, Object>> fastdfsPhotoList);
}
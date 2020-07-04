package com.myfun.repository.erpdb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpBuildingPhotoFastdfs;
import com.myfun.repository.erpdb.po.ErpBuildingPhotoFastdfsExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpBuildingPhotoFastdfsMapper extends BaseMapper<ErpBuildingPhotoFastdfs, ErpBuildingPhotoFastdfs> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpBuildingPhotoFastdfsExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpBuildingPhotoFastdfsExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpBuildingPhotoFastdfs> selectByExample(ErpBuildingPhotoFastdfsExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpBuildingPhotoFastdfs record, @Param("example") ErpBuildingPhotoFastdfsExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpBuildingPhotoFastdfs record, @Param("example") ErpBuildingPhotoFastdfsExample example);

	Integer selectLastPhotoId(@Param("shardDbName") String shardDbName);
	void insertList(@Param("shardDbName") String shardDbName, @Param("photoList") List<ErpBuildingPhotoFastdfs> fastdfsPhotoList);
	void updatePhotoAddrForList(@Param("shardDbName") String shardDbName, @Param("photoList") List<ErpBuildingPhotoFastdfs> fastdfsPhotoList);
}

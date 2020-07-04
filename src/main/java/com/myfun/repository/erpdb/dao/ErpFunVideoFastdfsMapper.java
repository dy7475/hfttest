package com.myfun.repository.erpdb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpFunPhotoFastdfs;
import com.myfun.repository.erpdb.po.ErpFunVideoFastdfs;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunVideoFastdfsMapper extends BaseMapper<ErpFunVideoFastdfs, ErpFunVideoFastdfs> {
	Integer selectLastVideoId(@Param("shardDbName") String shardDbName);
	
	void insertList(@Param("shardDbName") String shardDbName, @Param("videoList") List<ErpFunVideoFastdfs> fastdfsVideoList);

	void updateVideoAddrForList(@Param("shardDbName")String shardDbName,
			@Param("videoList")List<ErpFunVideoFastdfs> fastdfsVideoList);
}
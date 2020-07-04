package com.myfun.repository.erpdb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpFunPhotoFastdfs;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunPhotoFastdfsMapper extends BaseMapper<ErpFunPhotoFastdfs, ErpFunPhotoFastdfs> {
	
	Integer selectLastPhotoId(@Param("shardDbName") String shardDbName);
	
	void insertList(@Param("shardDbName") String shardDbName, @Param("photoList") List<ErpFunPhotoFastdfs> fastdfsPhotoList);
	void updatePhotoAddrForList(@Param("shardDbName") String shardDbName, @Param("photoList") List<ErpFunPhotoFastdfs> fastdfsPhotoList);

	List<ErpFunPhotoFastdfs> dealCopyFunPhotoWhosError(@Param("shardDbName") String shardDbName);
}
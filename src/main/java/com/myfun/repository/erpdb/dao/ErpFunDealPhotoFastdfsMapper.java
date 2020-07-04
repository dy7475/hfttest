package com.myfun.repository.erpdb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpFunDealPhotoFastdfs;
import com.myfun.repository.erpdb.po.ErpFunDealPhotoFastdfsExample;
import com.myfun.repository.erpdb.po.ErpFunPhotoFastdfs;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunDealPhotoFastdfsMapper extends BaseMapper<ErpFunDealPhotoFastdfs, ErpFunDealPhotoFastdfs> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunDealPhotoFastdfsExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunDealPhotoFastdfsExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunDealPhotoFastdfs> selectByExample(ErpFunDealPhotoFastdfsExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunDealPhotoFastdfs record, @Param("example") ErpFunDealPhotoFastdfsExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunDealPhotoFastdfs record, @Param("example") ErpFunDealPhotoFastdfsExample example);

	Integer selectLastPhotoId(@Param("shardDbName") String shardDbName);

	void insertList(@Param("shardDbName") String shardDbName, @Param("photoList") List<ErpFunDealPhotoFastdfs> fastdfsPhotoList);
	void updatePhotoAddrForList(@Param("shardDbName") String shardDbName, @Param("photoList") List<ErpFunDealPhotoFastdfs> fastdfsPhotoList);

}
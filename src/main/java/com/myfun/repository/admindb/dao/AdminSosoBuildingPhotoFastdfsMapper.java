package com.myfun.repository.admindb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminSosoBuildingPhotoFastdfs;
import com.myfun.repository.admindb.po.AdminSosoBuildingPhotoFastdfsExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminSosoBuildingPhotoFastdfsMapper extends BaseMapper<AdminSosoBuildingPhotoFastdfs, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminSosoBuildingPhotoFastdfsExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminSosoBuildingPhotoFastdfsExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminSosoBuildingPhotoFastdfs> selectByExample(AdminSosoBuildingPhotoFastdfsExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminSosoBuildingPhotoFastdfs record, @Param("example") AdminSosoBuildingPhotoFastdfsExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminSosoBuildingPhotoFastdfs record, @Param("example") AdminSosoBuildingPhotoFastdfsExample example);

	void insertList(@Param("photoList") List<AdminSosoBuildingPhotoFastdfs> fastdfsPhotoList);
	
	void updatePhotoAddrForList(@Param("photoList") List<AdminSosoBuildingPhotoFastdfs> fastdfsPhotoList);
	
	Integer selectLastPhotoId();
}
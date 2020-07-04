package com.myfun.repository.admindb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminSosoBuildingPhoto;
import com.myfun.repository.admindb.po.AdminSosoBuildingPhotoExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminSosoBuildingPhotoMapper extends BaseMapper<AdminSosoBuildingPhoto, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminSosoBuildingPhotoExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminSosoBuildingPhotoExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminSosoBuildingPhoto> selectByExample(AdminSosoBuildingPhotoExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminSosoBuildingPhoto record, @Param("example") AdminSosoBuildingPhotoExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminSosoBuildingPhoto record, @Param("example") AdminSosoBuildingPhotoExample example);

	List<AdminSosoBuildingPhoto> getPhotoListOrderByPhotoIdDesc(@Param("photoId")Integer photoId);
	
}
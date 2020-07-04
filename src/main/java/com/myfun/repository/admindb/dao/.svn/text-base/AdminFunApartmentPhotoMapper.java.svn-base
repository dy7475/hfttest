package com.myfun.repository.admindb.dao;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminFunApartmentPhoto;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunApartmentPhotoMapper extends BaseMapper<AdminFunApartmentPhoto, String> {

	/**
	 * 获取首图，通过房源UUID和房间uuid，没传房间的查房源的
	 * @author 张宏利
	 * @since 2016年12月13日
	 * @param uuid
	 * @return
	 */
	AdminFunApartmentPhoto getMainPhoto(@Param("apartmentUuid") String apartmentUuid, @Param("roomUuid")  String roomUuid);
	
	/**
	 * 获取图片数量
	 * @author 张宏利
	 * @since 2016年12月22日
	 * @param apartmentUuid
	 * @param roomUuid
	 * @return
	 */
	int getPhotoCount(@Param("apartmentUuid") String apartmentUuid,@Param("roomUuid")  String roomUuid);
}
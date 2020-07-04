package com.myfun.service.business.admindb;

import java.util.List;

import com.myfun.repository.admindb.po.AdminSosoBuildingPhoto;
import com.myfun.repository.support.mybatis.api.BaseMapper;

/** 
 * 
 */
public interface AdminSosoBuildingPhotoService extends BaseMapper<AdminSosoBuildingPhoto, Integer> {
	
	List<AdminSosoBuildingPhoto> getPhotoListOrderByPhotoIdDesc();

}

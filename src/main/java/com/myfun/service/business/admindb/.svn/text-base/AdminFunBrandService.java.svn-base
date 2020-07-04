package com.myfun.service.business.admindb;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.myfun.repository.admindb.dto.AdminFunBrandCityDto;
import com.myfun.repository.admindb.dto.AdminFunBrandDto;
import com.myfun.repository.admindb.param.AdminFunBrandParam;
import com.myfun.repository.admindb.param.FunBrandCityOrderParam;
import com.myfun.repository.admindb.po.AdminFunBrand;
import com.myfun.repository.support.mybatis.api.BaseMapper;

/**
 *    
 * 
 * @Title: file_name 
 * @Package package_name 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author lcb
 * @date 2016-3-31 下午2:40:01 
 * @version V1.0   
 */
public interface AdminFunBrandService extends BaseMapper<AdminFunBrand, Integer> {
	
	/**
	 * @Fields field : 分页数据查询 
	 */
	PageInfo<AdminFunBrand> getAdminFunBrandShowList(AdminFunBrandParam adminFunBrandParam);

	Integer updateFunbrand(AdminFunBrand funBrand, String newCityIds);
	
	/**
	 * @Fields field : 查询
	 */
	AdminFunBrand getAdminFunBrandById(Integer brandId);

	/**
	 * 跟进品牌id查询所在城市
	 * **/
	List<AdminFunBrandCityDto> getFunBrandCityByBrandId(Integer brandId);

	Integer insertFunBrand(AdminFunBrand adminFunBrand, String cityIds);

	PageInfo<AdminFunBrandDto> getAdminFunBrandCityOrder(FunBrandCityOrderParam funBrandCityOrderParam);

	Integer updateFunBrandCityOrder(String paramString);

	
}

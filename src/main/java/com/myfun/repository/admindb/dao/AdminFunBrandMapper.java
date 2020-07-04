package com.myfun.repository.admindb.dao;

import java.util.List;

import com.myfun.repository.admindb.dto.AdminFunBrandDto;
import com.myfun.repository.admindb.param.AdminFunBrandParam;
import com.myfun.repository.admindb.po.AdminFunBrand;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunBrandMapper extends BaseMapper<AdminFunBrand, Integer> {

	List<AdminFunBrand> getAdminFunBrandList(AdminFunBrandParam adminBrokerVisitParam);

	List<AdminFunBrandDto> getAdminFunBrandCityOrder(Integer cityId);

}
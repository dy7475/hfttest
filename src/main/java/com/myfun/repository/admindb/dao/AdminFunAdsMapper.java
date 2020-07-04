package com.myfun.repository.admindb.dao;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminFunAds;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunAdsMapper extends BaseMapper<AdminFunAds, Integer> {

	AdminFunAds getAdsByTypeAndCityId(@Param("adType") String adType, @Param("cityId") Short cityId);

	AdminFunAds getAdsByTypeAndDefault(String adType);
}
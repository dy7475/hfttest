package com.myfun.repository.admindb.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminWebSite;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminWebSiteMapper extends BaseMapper<AdminWebSite, Integer> {
	  /**
	   * 根据站点id查询站点列表
	   * @author 何传强
	   * @since 2017年7月14日
	   * @param siteIds
	   * @return
	   */
	  List<AdminWebSite> getSiteMapByCityId(@Param("cityId")Integer cityId);
	  List<Map<String,Object>> getSiteName(@Param("param")Map<String, Object> param,@Param("sitesIdList")List<String> list);
}
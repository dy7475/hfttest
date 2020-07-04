package com.myfun.repository.admindb.dao;

import java.util.List;

import com.myfun.repository.admindb.po.AdminSolrDeleteData;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.DaoBaseParam;

public interface AdminSolrDeleteDataMapper extends BaseMapper<AdminSolrDeleteData, Long> {

	List<AdminSolrDeleteData> getSolrDeleteDataBySolrForPage(DaoBaseParam param);
}
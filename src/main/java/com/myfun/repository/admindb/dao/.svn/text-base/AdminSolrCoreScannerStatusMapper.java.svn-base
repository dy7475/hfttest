package com.myfun.repository.admindb.dao;

import java.util.Date;
import java.util.List;

import com.myfun.repository.admindb.po.AdminSolrCoreScannerStatus;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminSolrCoreScannerStatusMapper extends BaseMapper<AdminSolrCoreScannerStatus, Integer> {

	List<AdminSolrCoreScannerStatus> getScannerStatusAll();

	Date getLastSyncTimeById(Integer id);
}
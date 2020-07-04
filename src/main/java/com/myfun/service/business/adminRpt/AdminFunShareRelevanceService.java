package com.myfun.service.business.adminRpt;

import java.util.List;

import com.myfun.repository.admindb.po.AdminFunShareRelevance;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunShareRelevanceService extends BaseMapper<AdminFunShareRelevance, Integer> {
	public List<Integer> getCompIdsByShareId(Integer shareId, Integer cityId);
}

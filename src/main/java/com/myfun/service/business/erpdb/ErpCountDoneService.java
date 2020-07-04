package com.myfun.service.business.erpdb;

import java.util.List;
import java.util.Map;

import com.myfun.repository.erpdb.po.ErpCountDone;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpCountDoneService extends BaseMapper<ErpCountDone, ErpCountDone> {

	public Map<Integer, String> getHouseCountDoneList(Integer cityId, Integer compId, List<Integer> caseIds, Integer caseType, Integer selfArchiveId);
}

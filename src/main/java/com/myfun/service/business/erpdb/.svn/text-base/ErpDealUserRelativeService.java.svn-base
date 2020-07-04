package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpDealUserRelative;
import com.myfun.repository.erpdb.po.ErpFunDeal;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.Set;

public interface ErpDealUserRelativeService extends BaseMapper<ErpDealUserRelative,  ErpDealUserRelative> {
	void createDealUserRelative(Integer cityId, Integer compId, ErpFunDeal funDeal);

	void createDealUserRelativeOffStep(Integer cityId, Integer compId, Integer dealId, Set<Integer> userIds, Byte relateType);
}

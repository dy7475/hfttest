package com.myfun.service.business.report;

import com.myfun.repository.reportdb.po.ReportFunSaleMin;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ReportFunSaleMinService extends BaseMapper<ReportFunSaleMin, Long> {
	void judgeOperatorTransferShop(String compNo, Integer cityId, Integer compId, String srcUserId, Integer descType, Integer caseType, Integer partnerId);
	public boolean canMoveOrgNow(String compNo, Integer cityId, Integer compId, Integer oldOrgId, Integer partnerId);
}

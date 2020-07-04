package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpFunCoreInfo;
import com.myfun.repository.support.mybatis.api.BaseMapper;


public interface ErpFunCoreInfoService extends BaseMapper<ErpFunCoreInfo, ErpFunCoreInfo>{

	void createOrUpdateCoreInfo(Integer cityId, Integer compId, Integer caseId, Integer caseType, Integer buildId, String houseRoof,
								String houseUnit, String unitFloor, String houseRoom, Byte useage, String tradeAddr);
}

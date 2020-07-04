package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpFunPaidConfig;
import com.myfun.repository.erpdb.po.ErpFunUserResume;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunPaidConfigService extends BaseMapper<ErpFunPaidConfig, ErpFunPaidConfig> {
	void savePaidConfig(Integer cityId, Integer compId, ErpFunPaidConfig erpFunPaidConfig);
}

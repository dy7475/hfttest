package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpModelStepRelate;
import com.myfun.repository.erpdb.po.ErpModelStepRelateKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpModelStepRelateService extends BaseMapper<ErpModelStepRelate, ErpModelStepRelateKey> {
	void deleteMgrStepModelFromPro(Integer cityId, Integer compId, ErpModelStepRelate modelStepRelate, Integer userId, String currUname);
}

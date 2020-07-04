package com.myfun.service.business.erpdb;

import com.myfun.erpWeb.managecenter.transaction.param.InsertMgrStepModelParam;
import com.myfun.repository.erpdb.po.ErpModelStepRelate;
import com.myfun.repository.erpdb.po.ErpProcessModel;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpProcessModelService extends BaseMapper<ErpProcessModel, ErpProcessModel>{

	void initCompProcessModelList(Integer cityId, Integer compId);

	void insertMgrStepModelToPro(Integer cityId, Integer userId, String currUname, ErpModelStepRelate modelStepRelate, InsertMgrStepModelParam param );

	void deleteProcessModel(Integer cityId, Integer compId, Integer modelId);
}

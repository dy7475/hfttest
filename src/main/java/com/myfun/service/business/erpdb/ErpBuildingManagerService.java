package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.param.CreatOrEditManagerParam;
import com.myfun.repository.erpdb.po.ErpBuildingManager;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpBuildingManagerService extends BaseMapper<ErpBuildingManager, ErpBuildingManager> {

    void creatOrEditManager(CreatOrEditManagerParam param);
}

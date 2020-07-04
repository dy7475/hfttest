package com.myfun.service.business.erpdb;

import com.myfun.erpWeb.managecenter.sysmanager.param.CreateAreaParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.DeleteAreaDataParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.UpdateAreaData;
import com.myfun.repository.erpdb.po.ErpFunArea;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunAreaService extends BaseMapper<ErpFunArea, ErpFunArea>{

	Integer insertMgrArea(CreateAreaParam param);

	void deleteMgrArea(DeleteAreaDataParam param);
    void updateMgrArea(UpdateAreaData param);

	void evictAreaByCompId(Integer cityId,Integer compId);

}

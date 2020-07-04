package com.myfun.service.business.erpdb;


import com.myfun.erpWeb.managecenter.sysmanager.param.InsertFunRegData;
import com.myfun.erpWeb.managecenter.sysmanager.param.UpdateRangeData;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.po.ErpFunRegion;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunRegionService extends BaseMapper<ErpFunRegion, ErpFunRegion>{
	
	void evictRegionByCompId(Integer cityId,Integer compId);

	void insertMgrRegion(ErpFunRegion erpFunRegion, InsertFunRegData param);

	void updateMgrRegion(UpdateRangeData param);

	void deleteRegionInfo(BaseMapParam param, Integer regId, String content);
	
	void updateRegInfo(BaseMapParam param);
}

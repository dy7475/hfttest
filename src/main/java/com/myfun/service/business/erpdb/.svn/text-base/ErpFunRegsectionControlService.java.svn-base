package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.param.QueryHouseCustListParam;
import com.myfun.repository.erpdb.po.ErpFunRegsectionControl;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunRegsectionControlService extends BaseMapper<ErpFunRegsectionControl, ErpFunRegsectionControl>{
	public void saveFunRegsectionControlOffDept(Integer cityId, Integer compId, Integer deptId, Integer creatorUid , Integer creatorDeptId, String cotrolJsonListStr, String currentUserName , String controllType);
	
	public Integer buildHouseListQueryRegSection(QueryHouseCustListParam queryParam, Integer compId, Integer areaId, Integer regId, Integer deptId, Integer grId, String userId, String range, Integer cityId, Integer selfAreaId, Integer selfRegId, Integer selfDeptId, Integer selfGrId, Integer selfUserId);
}

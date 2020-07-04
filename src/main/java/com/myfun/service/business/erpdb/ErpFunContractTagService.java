package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpFunContractTag;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunContractTagService extends BaseMapper<ErpFunContractTag,  ErpFunContractTag> {
	void updateTagStatus(Integer cityId, Integer dealId, Integer compId, Integer deptId, Byte status, Integer crmCompId);
}

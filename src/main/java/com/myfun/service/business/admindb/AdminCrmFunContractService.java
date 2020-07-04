package com.myfun.service.business.admindb;

import com.myfun.repository.admindb.dto.SoftContractDto;
import com.myfun.repository.admindb.po.AdminCrmFunContract;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminCrmFunContractService extends BaseMapper<AdminCrmFunContract, Integer> {
	
	public SoftContractDto showSoftContract(Integer adminDeptId);

}

package com.myfun.service.business.erpdb;

import com.myfun.erpWeb.managecenter.financialStatements.param.UpdateDeptFeeStatusParam;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.param.AccountParam;
import com.myfun.repository.erpdb.param.ErpFunDeptFeeListParam;
import com.myfun.repository.erpdb.param.ErpFunDeptFeeModifyParam;
import com.myfun.repository.erpdb.po.ErpAccount;
import com.myfun.repository.erpdb.po.ErpFunDeptFeeList;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.List;


public interface ErpFunDeptFeeListService extends BaseMapper<ErpFunDeptFeeList, ErpFunDeptFeeList>{

	void addFunDeptFee(Integer cityId, Integer compId, Integer userId, String userName, Integer deptId, ErpFunDeptFeeListParam param);
    Integer auditDeptFee(Integer cityId, Integer compId, Integer deptId, Integer userId, String userName, ErpFunDeptFeeListParam param);
    Integer updateDeptFee(Integer cityId,Integer compId, Integer deptId, Integer userId, String userName, UpdateDeptFeeStatusParam param, Integer partnerId);

	Integer importDeptFee(Integer cityId, Integer compId, Integer userId, String userName, Integer deptId, ErpFunDeptFeeListParam param, Integer partnerId);

    Integer modifyDeptFee(Integer cityId, Integer compId, Integer userId, String userName, Integer deptId, ErpFunDeptFeeModifyParam param);

    Integer updateDeptFeeBillPic(Integer cityId, Integer compId, Integer userId, String userName, Integer deptId, ErpFunDeptFeeModifyParam param);
	
    void addOrganizationFee(Integer cityId, Integer compId, Integer userId, String userName, Integer deptId, ErpFunDeptFeeListParam param);
}

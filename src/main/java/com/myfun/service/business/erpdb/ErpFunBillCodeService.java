package com.myfun.service.business.erpdb;

import java.util.List;

import com.myfun.repository.erpdb.param.FunBillModuleParam;
import com.myfun.repository.erpdb.po.ErpFunBillCode;
import com.myfun.repository.erpdb.po.ErpFunBillCodelog;
import com.myfun.repository.support.mybatis.api.BaseMapper;


public interface ErpFunBillCodeService extends BaseMapper<ErpFunBillCode, ErpFunBillCode>{

	Integer updateBillCodeRule(Integer cityId, Integer compId, FunBillModuleParam param);

    Integer updateBillCode(Integer cityId, Integer compId, FunBillModuleParam param);

    Integer createBillCode(Integer cityId, Integer compId, Integer userId, String userName, FunBillModuleParam param);

    ErpFunBillCodelog getBillCodeLog(Integer cityId, Integer compId, Integer deptId, Byte billType, Byte billWay);
    
    Integer updateBillCodeLogStatus(Integer cityId, Integer compId, Integer deptId, String codeNo, Integer type);

    Integer judgeBillCodeLogIsReapt(Integer cityId,Integer compId,Integer deptId, Byte billType, Byte billWay, Integer billCodeId, List<Integer> fianacIds ,  String billNo);
}

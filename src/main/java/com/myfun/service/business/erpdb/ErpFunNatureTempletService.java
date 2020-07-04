package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpFunNatureTemplet;
import com.myfun.repository.support.mybatis.api.BaseMapper;


public interface ErpFunNatureTempletService extends BaseMapper<ErpFunNatureTemplet, ErpFunNatureTemplet>{


	Integer addOrEditNatureTemplet(Integer cityId, Integer compId, Integer deptId, ErpFunNatureTemplet erpFunNatureTemplet) throws Exception;
}

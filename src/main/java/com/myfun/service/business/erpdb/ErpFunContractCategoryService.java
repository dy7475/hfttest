package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpFunContractCategory;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.List;


public interface ErpFunContractCategoryService extends BaseMapper<ErpFunContractCategory, ErpFunContractCategory>{


	Integer createOrUpdateFunContractCategory(Integer cityId, Integer compId, List<ErpFunContractCategory> paramList);
}

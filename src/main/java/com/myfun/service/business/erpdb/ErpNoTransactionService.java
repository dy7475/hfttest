package com.myfun.service.business.erpdb;

import java.util.List;

import com.myfun.repository.erpdb.po.ErpCompRoleOpers;
import com.myfun.repository.erpdb.po.ErpUserOpers;
import com.myfun.repository.support.mybatis.api.BaseMapper;


/** 不带事务的  ****/
public interface ErpNoTransactionService extends BaseMapper<ErpUserOpers, Integer>{


    void evictCacheableModelData(Integer cityId, Integer userId);

    void evictBaseInfoByCompId(Integer cityId, Integer compId);

	List<ErpCompRoleOpers> getCompRoleOpersByRoleId(Integer cityId, Integer compId, String roleId);

    //void evictWorkCountTargetData(String key);
}

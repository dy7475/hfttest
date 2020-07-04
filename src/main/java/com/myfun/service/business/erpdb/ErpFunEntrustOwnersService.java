package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpFunEntrust;
import com.myfun.repository.erpdb.po.ErpFunEntrustOwners;
import com.myfun.repository.support.mybatis.api.BaseMapper;

/**
 * @Author 蔡春林
 * @Date 2019/11/26 0026 上午 11:48
 **/
public interface ErpFunEntrustOwnersService extends BaseMapper<ErpFunEntrustOwners, ErpFunEntrustOwners> {

    /**
     * @param cityId
     * @param entrustId
     * @param ownerId
     * @param erpFunEntrust
     * @return int
     * @author 蔡春林 修改业主签约状态
     * @date 2019/11/26 0026
     */
    int updateOwnerSignStatus(Integer cityId, Integer entrustId, Integer ownerId, String signaturePic, ErpFunEntrust erpFunEntrust);
}

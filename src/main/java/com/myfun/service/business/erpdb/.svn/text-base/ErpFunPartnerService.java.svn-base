package com.myfun.service.business.erpdb;

import com.myfun.erpWeb.managecenter.sysmanager.param.AddPartnerParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.PartnerDeptsParam;
import com.myfun.repository.erpdb.po.ErpFunPartner;
import com.myfun.service.business.BaseService;

/**
 * @Date: 2019/11/11 19:22
 * @Description:
 */
public interface ErpFunPartnerService extends BaseService<ErpFunPartner,ErpFunPartner> {


    ErpFunPartner addPartner(AddPartnerParam param);

    void deletePartnerSysParam(Integer cityId,Integer compId,Integer partnerId);

    /**
     * 新版组织机构的加盟商
     * @param param p
     * @return
     */
    ErpFunPartner addPartnerForNewOrg(AddPartnerParam param);

}

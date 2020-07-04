package com.myfun.service.business.erpdb;

import com.myfun.erpWeb.deal.vo.ShareDealVo;
import com.myfun.erpWeb.managecenter.constract.param.ShareDealParam;
import com.myfun.repository.erpdb.param.ErpFunContractTemplaeParam;
import com.myfun.repository.erpdb.po.ErpFunContract;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.List;
import java.util.Map;


public interface ErpFunContractService extends BaseMapper<ErpFunContract, ErpFunContract>{


    List<Map<String,Object>> generatorContract(ErpFunContractTemplaeParam erpFunContractTemplaeParam, Integer cityId, Integer userId, String userName);

    void deleteLink(Integer cityId, Integer dealId);

    ShareDealVo shareDeal(ShareDealParam param);

    void sendMsg(Integer cityId, Integer dealId, Integer auditType);
}

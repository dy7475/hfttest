package com.myfun.service.business.erpdb;

import com.myfun.erpWeb.managecenter.sysmanager.param.UpdatePartnerConfigParam;
import com.myfun.repository.erpdb.dto.CheckPartnerConfigDto;
import com.myfun.repository.erpdb.dto.PartnerConfigDto;
import com.myfun.repository.erpdb.po.ErpFunPartnerConfig;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.BaseService;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Date: 2019/11/11 19:22
 * @Description:
 */
public interface ErpFunPartnerConfigService extends BaseService<ErpFunPartnerConfig,ErpFunPartnerConfig> {

    PartnerConfigDto getPartnerConfiguration(Integer cityId, Integer compId);

    void updateConfig(GeneralParam generalParam, UpdatePartnerConfigParam param);

    CheckPartnerConfigDto checkPartnerConfig(Integer cityId, Integer compId, Integer partnerId, String apartName);
}

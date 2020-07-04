package com.myfun.erpWeb.managecenter.profit.vo;

import com.myfun.repository.erpdb.dto.ErpFunWageDto;
import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;

/**
 * create by 程二狗 on 2018/11/13 0013
 */
@ApiModel
public class FunWageDetailVo implements EncryParamIfc {
    private ErpFunWageDto erpFunWageDto;

    public ErpFunWageDto getErpFunWageDto() {
        return erpFunWageDto;
    }

    public void setErpFunWageDto(ErpFunWageDto erpFunWageDto) {
        this.erpFunWageDto = erpFunWageDto;
    }
}

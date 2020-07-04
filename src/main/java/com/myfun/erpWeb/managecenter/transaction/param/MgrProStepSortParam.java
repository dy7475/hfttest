package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * create by 程二狗 on 2018/11/7 0007
 */
@ApiModel
public class MgrProStepSortParam extends BaseMapParam {
    @ApiModelProperty("流程ID")
    private Integer modelId;
    @ApiModelProperty("步骤 例如step1")
    private Integer step;

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }
}

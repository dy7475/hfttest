package com.myfun.erpWeb.managecenter.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @create by 程二狗 on 2019/2/18 0018
 **/
public class MaxApplyClassParam implements EncryParamIfc {

    @ApiModelProperty("考勤月")
    private String attMonth;

    public String getAttMonth() {
        return attMonth;
    }

    public void setAttMonth(String attMonth) {
        this.attMonth = attMonth;
    }
}

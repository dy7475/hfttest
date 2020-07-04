package com.myfun.erpWeb.businesstools.builddic.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author czq
 * @since 2019/9/17
 */
public class GenerateBuildRuleByExcelParam implements EncryParamIfc {

    @ApiModelProperty(value = "公司No", required = true)
    private String compNo;

    public String getCompNo() {
        return compNo;
    }

    public void setCompNo(String compNo) {
        this.compNo = compNo;
    }
}
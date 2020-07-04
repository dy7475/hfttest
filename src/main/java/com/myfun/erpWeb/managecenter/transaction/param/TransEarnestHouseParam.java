package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author yz
 */
@ApiModel(value = "转房源")
public class TransEarnestHouseParam implements EncryParamIfc {

    private static final long serialVersionUID = 1L;
    private boolean isFJD = false;
    @ApiModelProperty(value = "诚意金id")
    private Integer earbestId;
    @ApiModelProperty(value = "房源ID")
    private Integer caseId;
    @ApiModelProperty(value = "房源类型")
    private Integer caseType;
    @ApiModelProperty(hidden = true)
    private Integer compId;
    @ApiModelProperty(hidden = true)
    private Integer userId;
    @ApiModelProperty(hidden = true)
    private Integer cityId;

    public boolean isFJD() {
        return isFJD;
    }

    public void setFJD(boolean FJD) {
        isFJD = FJD;
    }

    public Integer getEarbestId() {
        return earbestId;
    }

    public void setEarbestId(Integer earbestId) {
        this.earbestId = earbestId;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public Integer getCaseType() {
        return caseType;
    }

    public void setCaseType(Integer caseType) {
        this.caseType = caseType;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}

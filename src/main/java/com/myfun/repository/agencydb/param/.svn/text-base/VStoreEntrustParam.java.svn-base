package com.myfun.repository.agencydb.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author czq
 * @since 2019/8/14
 */
public class VStoreEntrustParam extends AbstractEncryParam implements EncryParamIfc {

    @ApiModelProperty(value = "城市ID")
    private Integer cityId;

    @ApiModelProperty(value = "ERP公司ID")
    private Integer compId;

    @ApiModelProperty(value = "委托类型 1=出售 2=出租 3=求购 4=求租")
    private Integer caseType;

    @ApiModelProperty(value = "开始时间,精确到日 2019-8-14")
    private String startTime;

    @ApiModelProperty(value = "结束时间,精确到日 2019-8-15")
    private String endTime;

    @ApiModelProperty(value = "是否是专属委托 1：是、0：否 不传:全部")
    private String isVip;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getCaseType() {
        return caseType;
    }

    public void setCaseType(Integer caseType) {
        this.caseType = caseType;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getIsVip() {
        return isVip;
    }

    public void setIsVip(String isVip) {
        this.isVip = isVip;
    }
}
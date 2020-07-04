package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.EncryParamIfc;

import java.util.List;

/**
 * @Auther: leber
 * @Date: 2019/11/20 15:37
 * @Description:
 */
public class PartnerTestOpenApiParam implements EncryParamIfc {

    private Integer cityId;
    private Integer compId;
    private Integer partnerId;
    private Integer userId;
    private String paramId;
    private List<String> paramIds;


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

    public Integer getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getParamId() {
        return paramId;
    }

    public void setParamId(String paramId) {
        this.paramId = paramId;
    }

    public List<String> getParamIds() {
        return paramIds;
    }

    public void setParamIds(List<String> paramIds) {
        this.paramIds = paramIds;
    }
}

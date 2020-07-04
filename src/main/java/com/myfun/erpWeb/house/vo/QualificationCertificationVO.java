package com.myfun.erpWeb.house.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author czq
 * @since 2018/12/30
 */
public class QualificationCertificationVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "0=未通过 1=已通过")
    private Integer userHonest;
    @ApiModelProperty(value = "")
    private Integer rqsAptitudeStatus;

    public Integer getUserHonest() {
        return userHonest;
    }

    public void setUserHonest(Integer userHonest) {
        this.userHonest = userHonest;
    }

    public Integer getRqsAptitudeStatus() {
        return rqsAptitudeStatus;
    }

    public void setRqsAptitudeStatus(Integer rqsAptitudeStatus) {
        this.rqsAptitudeStatus = rqsAptitudeStatus;
    }

}

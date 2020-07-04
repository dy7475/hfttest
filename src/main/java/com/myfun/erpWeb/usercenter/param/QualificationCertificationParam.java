package com.myfun.erpWeb.usercenter.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author czq
 * @since 2018/12/30
 */
public class QualificationCertificationParam implements EncryParamIfc {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "名片")
    private String cardPhoto;

    @ApiModelProperty(value = "门店室内图")
    private String shopInnerPhoto;

    @ApiModelProperty(value = "门店室外图")
    private String shopOuterPhoto;

    @ApiModelProperty(value = "经纪人Id", hidden = true)
    private Integer archiveId;

    public String getCardPhoto() {
        return cardPhoto;
    }

    public void setCardPhoto(String cardPhoto) {
        this.cardPhoto = cardPhoto;
    }

    public String getShopInnerPhoto() {
        return shopInnerPhoto;
    }

    public void setShopInnerPhoto(String shopInnerPhoto) {
        this.shopInnerPhoto = shopInnerPhoto;
    }

    public String getShopOuterPhoto() {
        return shopOuterPhoto;
    }

    public void setShopOuterPhoto(String shopOuterPhoto) {
        this.shopOuterPhoto = shopOuterPhoto;
    }

    public Integer getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }

}

package com.myfun.repository.erpdb.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author czq
 * @since 2019/11/13
 */
public class CheckPartnerConfigDto {

    @ApiModelProperty(value = "公司是否开启加盟模式：0=没有开启 1=开启")
    private Byte openPartner = 0;

    @ApiModelProperty(value = "该配置项是否分开管控：0=否 1=是")
    private Byte isApart = 0;

    @ApiModelProperty(value = "查看范围的加盟商ID集合")
    private List<Integer> partnerIds;

    public Byte getOpenPartner() {
        return openPartner;
    }

    public void setOpenPartner(Byte openPartner) {
        this.openPartner = openPartner;
    }

    public Byte getIsApart() {
        return isApart;
    }

    public void setIsApart(Byte isApart) {
        this.isApart = isApart;
    }

    public List<Integer> getPartnerIds() {
        return partnerIds;
    }

    public void setPartnerIds(List<Integer> partnerIds) {
        this.partnerIds = partnerIds;
    }
}
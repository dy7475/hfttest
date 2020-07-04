package com.myfun.erpWeb.house.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author 蔡春林
 * @Date 2019/11/25 0025 下午 7:52
 **/
@ApiModel
public class EntrustCertificateVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "证书Id")
    private Integer certificateId; 
    @ApiModelProperty(value = "证书编号")
    private String certificateNo;
    @ApiModelProperty(value = "证书类型 1房产证 2不动产证")
    private Byte certificateType;
    @ApiModelProperty(value = "委托ID")
    private Integer entrustId;

    public Integer getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(Integer certificateId) {
        this.certificateId = certificateId;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public Byte getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(Byte certificateType) {
        this.certificateType = certificateType;
    }

    public Integer getEntrustId() {
        return entrustId;
    }

    public void setEntrustId(Integer entrustId) {
        this.entrustId = entrustId;
    }
}

package com.myfun.erpWeb.house.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author HuangJiang
 * @since 2019年11月25日 16:25:36
 * Modified XXX HuangJiang 2019年11月25日
 */
@ApiModel(description = "委托产权号信息")
public class EntrustCertificateInfoParam implements EncryParamIfc {
    
    @ApiModelProperty(value = "委托产权号ID（修改时要传）")
    private Integer certificateId;
    @ApiModelProperty(value = "证书类型")
    private Byte certificateType;
    @ApiModelProperty(value = "证书编号")
    private String certificateNo;
    
    public Integer getCertificateId() {
        return certificateId;
    }
    
    public void setCertificateId(Integer certificateId) {
        this.certificateId = certificateId;
    }
    
    public Byte getCertificateType() {
        return certificateType;
    }
    
    public void setCertificateType(Byte certificateType) {
        this.certificateType = certificateType;
    }
    
    public String getCertificateNo() {
        return certificateNo;
    }
    
    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }
}

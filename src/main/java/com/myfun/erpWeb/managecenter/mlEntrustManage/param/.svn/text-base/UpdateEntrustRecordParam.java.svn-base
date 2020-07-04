package com.myfun.erpWeb.managecenter.mlEntrustManage.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author HuangJiang
 * @since 2019年11月28日 10:04:03
 * Modified XXX HuangJiang 2019年11月28日
 */
public class UpdateEntrustRecordParam implements EncryParamIfc {
    
    @ApiModelProperty(value = "委托ID")
    @NotNull
    private Integer entrustId;
    @ApiModelProperty(value = "操作类型 1=添加备案 2=修改备案 3=清空备案")
    @NotNull
    private Integer operateType;
    @ApiModelProperty(value = "备案人")
    private Integer recordUser;
    @ApiModelProperty(value = "备案时间")
    private Date recordTime;
    @ApiModelProperty(value = "备案号")
    private String recordNo;
    @ApiModelProperty("出售委托价格")
    private BigDecimal saleEntrustPrice;
    @ApiModelProperty("出租委托价格")
    private BigDecimal leaseEntrustPrice;
    @ApiModelProperty(value = "出租 委托价格单位id")
    private Byte priceUnit;

    public BigDecimal getSaleEntrustPrice() {
        return saleEntrustPrice;
    }

    public void setSaleEntrustPrice(BigDecimal saleEntrustPrice) {
        this.saleEntrustPrice = saleEntrustPrice == null ? null : new BigDecimal(saleEntrustPrice.stripTrailingZeros().toPlainString());
    }

    public BigDecimal getLeaseEntrustPrice() {
        return leaseEntrustPrice;
    }

    public void setLeaseEntrustPrice(BigDecimal leaseEntrustPrice) {
        this.leaseEntrustPrice = leaseEntrustPrice == null ? null : new BigDecimal(leaseEntrustPrice.stripTrailingZeros().toPlainString());
    }
    public Integer getOperateType() {
        return operateType;
    }
    
    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }
    
    public Integer getEntrustId() {
        return entrustId;
    }
    
    public void setEntrustId(Integer entrustId) {
        this.entrustId = entrustId;
    }
    
    public Integer getRecordUser() {
        return recordUser;
    }
    
    public void setRecordUser(Integer recordUser) {
        this.recordUser = recordUser;
    }
    
    public Date getRecordTime() {
        return recordTime;
    }
    
    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }
    
    public String getRecordNo() {
        return recordNo;
    }
    
    public void setRecordNo(String recordNo) {
        this.recordNo = recordNo;
    }

    public Byte getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(Byte priceUnit) {
        this.priceUnit = priceUnit;
    }
}

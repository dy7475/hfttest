package com.myfun.erpWeb.house.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author 蔡春林
 * @Date 2019/12/2 0002 下午 5:43
 **/
@ApiModel
public class getOwnerInfoVo  implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("业主姓名")
    private String ownerName;
    @ApiModelProperty("业主籍贯")
    private String nativePlace;
    @ApiModelProperty("证件类型 1=身份证 2=护照 3=军官证 4=士兵证 5=回乡证 6=台胞证")
    private Byte idType;
    @ApiModelProperty("证件号码")
    private String cardNo;
    @ApiModelProperty("手机号码")
    private String ownerPhone;
    @ApiModelProperty("联系地址")
    private String address;
    @ApiModelProperty("是否签约（0=未签约；1=已签约）")
    private Byte isSign;
    @ApiModelProperty("签约时间")
    private String signDate;
    @ApiModelProperty("业主ID")
    private Integer ownerId;
    @ApiModelProperty("签约图片的地址")
    private String signPicAddr;
    @ApiModelProperty("委托Id")
    private Integer entrustId;
    @ApiModelProperty("城市Id")
    private Integer cityId;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public Byte getIdType() {
        return idType;
    }

    public void setIdType(Byte idType) {
        this.idType = idType;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Byte getIsSign() {
        return isSign;
    }

    public void setIsSign(Byte isSign) {
        this.isSign = isSign;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getSignPicAddr() {
        return signPicAddr;
    }

    public void setSignPicAddr(String signPicAddr) {
        this.signPicAddr = signPicAddr;
    }

    public Integer getEntrustId() {
        return entrustId;
    }

    public void setEntrustId(Integer entrustId) {
        this.entrustId = entrustId;
    }
}

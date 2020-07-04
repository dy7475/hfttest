package com.myfun.erpWeb.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("加盟圈")
public class JoinCompListNewVO {

    @ApiModelProperty("公司编号")
    private String compNo;
    @ApiModelProperty("公司简称")
    private String compCname;
    @ApiModelProperty("共享圈ID")
    private Integer shareId;
    @ApiModelProperty("erp的compId")
    private Integer compId;
    @ApiModelProperty("compContact")
    private String compContact;
    @ApiModelProperty("contactPhone")
    private String contactPhone;
    @ApiModelProperty("compAddr")
    private String compAddr;
    @ApiModelProperty("sname")
    private String sname;
    @ApiModelProperty("createTime")
    private Date createTime;
    @ApiModelProperty("ord")
    private Integer ord;

    public String getCompAddr() {
        return compAddr;
    }

    public void setCompAddr(String compAddr) {
        this.compAddr = compAddr;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOrd() {
        return ord;
    }

    public void setOrd(Integer ord) {
        this.ord = ord;
    }

    public String getCompContact() {
        return compContact;
    }

    public void setCompContact(String compContact) {
        this.compContact = compContact;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getCompNo() {
        return compNo;
    }

    public void setCompNo(String compNo) {
        this.compNo = compNo;
    }

    public String getCompCname() {
        return compCname;
    }

    public void setCompCname(String compCname) {
        this.compCname = compCname;
    }

    public Integer getShareId() {
        return shareId;
    }

    public void setShareId(Integer shareId) {
        this.shareId = shareId;
    }
}

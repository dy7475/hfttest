package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @author yz
 */
@ApiModel(value = "代付")
public class TransEarnestToProprietorParam implements EncryParamIfc {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "诚意金id")
    private Integer earbestId;
    @ApiModelProperty("代付金额")
    private BigDecimal payMoney;
    @ApiModelProperty("代付备注")
    private String earbestRemark;
    @ApiModelProperty(hidden = true)
    private Integer caseId;
    @ApiModelProperty(hidden = true)
    private Integer caseType;
    @ApiModelProperty(hidden = true)
    private Integer compId;
    @ApiModelProperty(hidden = true)
    private Integer userId;
    @ApiModelProperty(hidden = true)
    private Integer cityId;
    @ApiModelProperty(hidden = true)
    private String userName;

    @ApiModelProperty(hidden = true)
    private String currentUserName;

    @ApiModelProperty(hidden = true)
    private Integer deptId;

    @ApiModelProperty(hidden = true)
    private String deptName;

    public String getEarbestRemark() {
        return earbestRemark;
    }

    public void setEarbestRemark(String earbestRemark) {
        this.earbestRemark = earbestRemark;
    }

    public BigDecimal getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    public Integer getEarbestId() {
        return earbestId;
    }

    public void setEarbestId(Integer earbestId) {
        this.earbestId = earbestId;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public Integer getCaseType() {
        return caseType;
    }

    public void setCaseType(Integer caseType) {
        this.caseType = caseType;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getCurrentUserName() {
        return currentUserName;
    }

    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
    }
}

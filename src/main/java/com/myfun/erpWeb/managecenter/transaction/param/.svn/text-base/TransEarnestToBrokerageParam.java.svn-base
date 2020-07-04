package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;
import com.myfun.repository.support.param.GeneralParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @author yz
 */
@ApiModel(value = "转佣金")
public class TransEarnestToBrokerageParam implements EncryParamIfc {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "诚意金id")
    private Integer earbestId;
    @ApiModelProperty("转佣金的金额")
    private BigDecimal commssion;

    @ApiModelProperty("佣金类型1:客户2:业主")
    private Byte pfPayer;

    @ApiModelProperty("备注")
    private String earbestRemark;
    @ApiModelProperty(hidden = true)
    private GeneralParam generalParam;
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
    private Integer pfId;

    @ApiModelProperty(hidden = true)
    private String deptName;

    public Integer getPfId() {
        return pfId;
    }

    public void setPfId(Integer pfId) {
        this.pfId = pfId;
    }

    public BigDecimal getCommssion() {
        return commssion;
    }

    public void setCommssion(BigDecimal commssion) {
        this.commssion = commssion;
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

    public Byte getPfPayer() {
        return pfPayer;
    }

    public void setPfPayer(Byte pfPayer) {
        this.pfPayer = pfPayer;
    }

    public String getEarbestRemark() {
        return earbestRemark;
    }

    public void setEarbestRemark(String earbestRemark) {
        this.earbestRemark = earbestRemark;
    }

    public GeneralParam getGeneralParam() {
        return generalParam;
    }

    public void setGeneralParam(GeneralParam generalParam) {
        this.generalParam = generalParam;
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

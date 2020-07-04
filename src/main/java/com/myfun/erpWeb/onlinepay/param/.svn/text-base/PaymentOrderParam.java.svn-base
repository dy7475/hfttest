package com.myfun.erpWeb.onlinepay.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;

@ApiModel
public class PaymentOrderParam implements EncryParamIfc {
    // 订单支付方式
    @ApiModelProperty(value = "订单支付方式 1=微信 2=快捷支付", required = true)
    private Byte orderPaymentType;
    // 订单主业务编号
    @ApiModelProperty(value = "订单主业务编号，配合businessType使用 businessType=1时代表合作ID, businessType=2代表合同dealId", required = true)
    private Integer businessId;
    // 订单类型
    @ApiModelProperty(value = "订单类型 1=合作 2=合同", required = true)
    private Byte businessType;
    // 订单支付金额（）
    @ApiModelProperty(value = "订单总金额", required = true)
    private BigDecimal orderAmount;
    // 房源公司ID
    @ApiModelProperty(value = "房源公司", hidden = true)
    private Integer houseCompId;
    // 客源公司ID
    @ApiModelProperty(value = "客源公司", hidden = true)
    private Integer custCompId;
    // 款项ID
    @ApiModelProperty(value = "应收款项ID, 如果businessType=2时必传")
    private Integer pfId;
    // 支付方，客方还是卖方
    @ApiModelProperty(value = "付款方, 1:客户2:业主", required = true)
    private Byte pfPayer;
    // 楼盘名称
    @ApiModelProperty(value = "楼盘名称", hidden = true)
    private String buildName;
    // 支付方姓名
    @ApiModelProperty(value = "支付方姓名", hidden = true)
    private String payerName;
    // 下单方城市ID
    @ApiModelProperty(value = "下单人城市", hidden = true)
    private Integer cityId;
    // 下单人
    @ApiModelProperty(value = "下单人id", hidden = true)
    private Integer userId;
    // 下单人
    @ApiModelProperty(value = "下单人id", hidden = true)
    private Integer deptId;
    // 下单人
    @ApiModelProperty(value = "下单人id", hidden = true)
    private Integer compId;
    // 下单人
    @ApiModelProperty(value = "下单人id", hidden = true)
    private String deptName;
    @ApiModelProperty(value = "下单人id", hidden = true)
    private String userName;
    // 分账信息
    @ApiModelProperty(value = "分账信息", required = true)
    private List<PaymentPayeeParam> orderPayeeList;
    // 订单描述，微信端展示商品
    @ApiModelProperty(value = "订单商品名", hidden = true)
    private String orderBody;
    // 回单摘要
    @ApiModelProperty(value = "回单摘要", hidden = true)
    private String orderSummary;
    // 客户端IP
    @ApiModelProperty(value = "客户端IP", required = false)
    private String clientIp;
    @ApiModelProperty(value = "楼盘ID", hidden = true)
    private Integer buildId;
    @ApiModelProperty(value = "houseCityId", hidden = true)
    private Integer houseCityId;
    @ApiModelProperty(value = "custCityId", hidden = true)
    private Integer custCityId;
    @ApiModelProperty(value = "款项名称", hidden = true)
    private String pfName;
    @ApiModelProperty(value = "订单描述", required = true)
    private String orderRemark;

    @ApiModelProperty(value = "订单号 快捷支付必传", required = false)
    private String orderNo;
    @ApiModelProperty(value = "下单人", hidden = false)
    private Integer archiveId;
    @ApiModelProperty(value = "类型", hidden = false)
    private Byte caseType;
    @ApiModelProperty(value = "公司", hidden = false)
    private String compName;

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public Byte getCaseType() {
        return caseType;
    }

    public void setCaseType(Byte caseType) {
        this.caseType = caseType;
    }

    public Integer getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    public String getPfName() {
        return pfName;
    }

    public void setPfName(String pfName) {
        this.pfName = pfName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getHouseCityId() {
        return houseCityId;
    }

    public void setHouseCityId(Integer houseCityId) {
        this.houseCityId = houseCityId;
    }

    public Integer getCustCityId() {
        return custCityId;
    }

    public void setCustCityId(Integer custCityId) {
        this.custCityId = custCityId;
    }

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public Byte getOrderPaymentType() {
        return orderPaymentType;
    }

    public void setOrderPaymentType(Byte orderPaymentType) {
        this.orderPaymentType = orderPaymentType;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Byte getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Byte businessType) {
        this.businessType = businessType;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getHouseCompId() {
        return houseCompId;
    }

    public void setHouseCompId(Integer houseCompId) {
        this.houseCompId = houseCompId;
    }

    public Integer getCustCompId() {
        return custCompId;
    }

    public void setCustCompId(Integer custCompId) {
        this.custCompId = custCompId;
    }

    public Integer getPfId() {
        return pfId;
    }

    public void setPfId(Integer pfId) {
        this.pfId = pfId;
    }

    public Byte getPfPayer() {
        return pfPayer;
    }

    public void setPfPayer(Byte pfPayer) {
        this.pfPayer = pfPayer;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public List<PaymentPayeeParam> getOrderPayeeList() {
        return orderPayeeList;
    }

    public void setOrderPayeeList(List<PaymentPayeeParam> orderPayeeList) {
        this.orderPayeeList = orderPayeeList;
    }

    public String getOrderBody() {
        return orderBody;
    }

    public void setOrderBody(String orderBody) {
        this.orderBody = orderBody;
    }

    public String getOrderSummary() {
        return orderSummary;
    }

    public void setOrderSummary(String orderSummary) {
        this.orderSummary = orderSummary;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

}
